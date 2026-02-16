package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.UsuarioSistemaDAO;
import com.genoma.plus.dto.general.GeneralDTO;
import com.genoma.plus.dto.general.UsuarioSistemaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/UsuarioSistemaDAOImpl.class */
public class UsuarioSistemaDAOImpl implements UsuarioSistemaDAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.UsuarioSistemaDAO
    public void desactivarUsuarioSistema(String login) {
        this.sql = "UPDATE g_usuario_sist, (\nSELECT  IF(DATEDIFF(FechaFinC, NOW())<=0, 1,0) AS Vencida,  Id_Persona \nFROM g_usuario_sist WHERE (Login ='" + login + "' AND Estado=0) \nHAVING Vencida=1) d \nSET g_usuario_sist.`Estado`=1 \nWHERE g_usuario_sist.`Id_Persona`=d.Id_Persona";
        this.jdbcTemplate.update(this.sql);
    }

    @Override // com.genoma.plus.dao.general.UsuarioSistemaDAO
    public List<UsuarioSistemaDTO> usuarioSistema(String login) {
        BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(UsuarioSistemaDTO.class);
        String sql = "SELECT CONCAT(g_persona.Apellido1,' ', g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) nombreUsuario\n, g_usuario_sist.Login AS login, g_usuario_sist.Clave AS clave, \n g_usuario_sist.EsAdministrativo AS tipoUsuario,\n IF( NOW()>= ADDDATE(`FechaUltimoC`, INTERVAL `g_ips`.`NDiasCambio` DAY), 1,0) AS  estado,\n g_usuario_sist.EsConsulta AS esConsulta, g_usuario_sist.PLaboratorio  AS autorizacionLaboratorio, g_persona.Id AS idUsuarioSistema\n , rh_tipo_persona_cargon.Id idPersonaCargo\n ,  rh_tipo_cargo.Nbre nombreCargoUsuario\n , g_persona.`Correo` correoUsuario\n ,  rh_unidad_funcional.Nbre unidadFuncional\n ,  CONCAT(persona.`Apellido1`, ' ', persona.`Apellido2`, ' ', persona.`Nombre1`, ' ', persona.`Nombre2`) nombreLider\n ,persona.`Correo` correoLider\n , persona.`Id` idPersonaLider, ifnull(rh_tipo_persona_cargon.UrlFirma, '') as urlFirma , g_usuario_sist.`idUsuarioBs1`, rh_unidad_funcional.Id as idUnidadFuncional, g_usuario_sist.autorizadoEnvioFacturaDian, gt.Id tipoDocumento\n, gt.Id_Dian tipoDocumentoDian\n, g_persona.NoDocumento numeroDocumento, g_persona.Nombre1 primerNombre\n, g_persona.Nombre2 segundoNombre\n, g_persona.Apellido1 primerApellido\n, g_persona.Apellido2 SegundoApellido\nFROM  g_ips, g_persona \nINNER JOIN g_usuario_sist ON (g_persona.Id = g_usuario_sist.Id_Persona) inner join g_tipoidentificacion gt on (gt.Id=g_persona.Id_TipoIdentificacion)\nLEFT JOIN rh_tipo_persona_cargon ON (rh_tipo_persona_cargon.`Id_Persona`=g_persona.`Id`) AND (rh_tipo_persona_cargon.Estado =1)\nLEFT JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) \nLEFT JOIN rh_unidad_funcional  ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id)\nLEFT JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) \nLEFT JOIN g_persona persona ON (rh_unidad_funcional.Id_Persona = persona.Id)   \n WHERE (g_usuario_sist.Login ='" + login + "' AND g_usuario_sist.Estado=0)\n ";
        List<UsuarioSistemaDTO> e = this.jdbcTemplate.query(sql, bprm);
        return e;
    }

    @Override // com.genoma.plus.dao.general.UsuarioSistemaDAO
    public List<GeneralDTO> usuarioSistemaSede(String idPersona) {
        BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(GeneralDTO.class);
        String sql = "SELECT `g_sedes`.`Id` AS id, `g_sedes`.`Nbre` AS nombre, g_sedes.minutos, g_sedes.codigoInterfaz, g_sedes.urlMicroServicios, g_sedes.CodigoOrganismo as codigoOrganismo\nFROM `g_usuario_sist_sede` INNER JOIN `g_sedes`  ON (`g_usuario_sist_sede`.`Id_Sede` = `g_sedes`.`Id`)\nWHERE (`g_usuario_sist_sede`.`Id_Persona` ='" + idPersona + "' AND `g_usuario_sist_sede`.`Estado` =1)\nORDER BY `g_sedes`.`Nbre` ASC";
        List<GeneralDTO> e = this.jdbcTemplate.query(sql, bprm);
        return e;
    }

    @Override // com.genoma.plus.dao.general.UsuarioSistemaDAO
    public List<Object[]> usuarioSistemaModulo(String idPersona) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.UsuarioSistemaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1))};
                return fila;
            }
        };
        this.sql = "SELECT Id_Modulo FROM g_usuariosxmodulo WHERE (Id_persona ='" + idPersona + "' and Estado=0)";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }
}
