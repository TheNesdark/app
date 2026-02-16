package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO;
import com.genoma.plus.dto.general.TipoConcentimientoDTO;
import com.genoma.plus.dto.sgc.ConsentimientoInformadoDTO;
import com.genoma.plus.dto.sgc.ConsentimientoInfxRiesgoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/ConsentimientoInformadoDAOImpl.class */
public class ConsentimientoInformadoDAOImpl implements ConsentimientoInformadoDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public List<ConsentimientoInformadoDTO> listConcentimientoInf(String xIdUsuario) {
        String sql = "SELECT\n    `ingreso_consentimiento_informado`.`Id`\n    , `ingreso_consentimiento_informado`.`Id_Ingreso`\n    , `ingreso_consentimiento_informado`.`idProcedimiento`\n    , `h_tipoconsentimiento`.`Nbre` AS `TipoConsentimiento`\n    , `ingreso_consentimiento_informado`.`Encabezado`\n    , `ingreso_consentimiento_informado`.`Nota1`\n    , `ingreso_consentimiento_informado`.`PiePagina`\n    , `ingreso_consentimiento_informado`.`Observacion`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `profesional1`.`NProfesional`\n    , `ingreso_consentimiento_informado`.`Acepta`\nFROM\n    `ingreso_consentimiento_informado`\n    INNER JOIN `h_tipoconsentimiento` \n        ON (`ingreso_consentimiento_informado`.`Id_TipoConsentimiento` = `h_tipoconsentimiento`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`ingreso_consentimiento_informado`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `g_especialidad` \n        ON (`ingreso_consentimiento_informado`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`Id_Persona` = `ingreso_consentimiento_informado`.`Id_Profesional`)\nWHERE (`ingreso`.`Id` ='" + xIdUsuario + "')\ngroup by `ingreso_consentimiento_informado`.`Id` \nORDER BY `ingreso_consentimiento_informado`.`Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConsentimientoInformadoDTO xConcentimientoInf = new ConsentimientoInformadoDTO();
                xConcentimientoInf.setId(Long.valueOf(rs.getLong("Id")));
                xConcentimientoInf.setIngreso(Long.valueOf(rs.getLong("Id_Ingreso")));
                xConcentimientoInf.setIdProcedimiento(rs.getString("idProcedimiento"));
                xConcentimientoInf.setIdTipoConcentimiento(rs.getString("TipoConsentimiento"));
                xConcentimientoInf.setEncabezado(rs.getString("Encabezado"));
                xConcentimientoInf.setNota(rs.getString("Nota1"));
                xConcentimientoInf.setPiePagina(rs.getString("PiePagina"));
                xConcentimientoInf.setObservacion(rs.getString("Observacion"));
                xConcentimientoInf.setIdEspecialidad(rs.getString("Especialidad"));
                xConcentimientoInf.setIdProfesional(rs.getString("NProfesional"));
                xConcentimientoInf.setAcepta(rs.getInt("Acepta"));
                return xConcentimientoInf;
            }
        };
        List<ConsentimientoInformadoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public List<TipoConcentimientoDTO> listTipoConsentimmiento() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                TipoConcentimientoDTO g = new TipoConcentimientoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                g.setEncabezado(rs.getString("Encabezado"));
                g.setEncabezado(rs.getString("Nota1"));
                g.setEncabezado(rs.getString("PiePagina"));
                return g;
            }
        };
        List<TipoConcentimientoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, IFNULL(`Encabezado`,'') Encabezado, IFNULL(`Nota1`,'') Nota1, IFNULL(`PiePagina`,'') PiePagina FROM `h_tipoconsentimiento` WHERE (`Estado` =1);", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public String create_return_id(final ConsentimientoInformadoDTO xConcentimientoInf) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl.3
            final String sql = "INSERT INTO `ingreso_consentimiento_informado` (`Id_Ingreso`,`Id_TipoConsentimiento`,`Encabezado`,`Nota1`,`PiePagina`,`Observacion`,`Id_Especialidad`,`Id_Profesional`,`Acepta`,`Id_UsuarioR`, idProcedimiento)\nVALUES(?,?,?,?,?,?,?,?,?,?, ?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `ingreso_consentimiento_informado` (`Id_Ingreso`,`Id_TipoConsentimiento`,`Encabezado`,`Nota1`,`PiePagina`,`Observacion`,`Id_Especialidad`,`Id_Profesional`,`Acepta`,`Id_UsuarioR`, idProcedimiento)\nVALUES(?,?,?,?,?,?,?,?,?,?, ?);", 1);
                ps.setLong(1, xConcentimientoInf.getIngreso().longValue());
                ps.setString(2, xConcentimientoInf.getIdTipoConcentimiento());
                ps.setString(3, xConcentimientoInf.getEncabezado());
                ps.setString(4, xConcentimientoInf.getNota());
                ps.setString(5, xConcentimientoInf.getPiePagina());
                ps.setString(6, xConcentimientoInf.getObservacion());
                ps.setString(7, xConcentimientoInf.getIdEspecialidad());
                ps.setString(8, xConcentimientoInf.getIdProfesional());
                ps.setInt(9, xConcentimientoInf.getAcepta());
                ps.setString(10, String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                ps.setString(11, xConcentimientoInf.getIdProcedimiento());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdConsentimiento = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdConsentimiento-->" + xIdConsentimiento);
        return xIdConsentimiento;
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public String mUpdateConcentimientoInf(ConsentimientoInformadoDTO xConcentimientoInf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public String mCreateConcentimientoxRiesgo(ConsentimientoInfxRiesgoDTO xConcentimientoInf) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `ingreso_consentimiento_informado_riesgo_complicacion` (`Id_Consentimiento`, `Id_TipoRiesgo_Complicacion`, `Observacion`)\nVALUES(?,?,?);", new Object[]{Long.valueOf(xConcentimientoInf.getIdConsentimiento()), xConcentimientoInf.getIdTipoRiesgoComplicacion(), xConcentimientoInf.getObservacion()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO
    public List<ConsentimientoInfxRiesgoDTO> listConsentimientoDetalle(String xidconsentimiento, String idProcedimiento) {
        String sql = "SELECT\n    `h_tipo_riesgo_complicacion`.`Id`\n    , `h_tipo_riesgo_complicacion`.`Nbre` AS `NtipoRiesgoComplicacion`\n    , `h_tipo_riesgo_complicacion_clasificacion`.`Nbre` AS `Tipo`\n    , `g_procedimiento_triesgo_complicacion`.`Id_Procedimiento`\n    , IFNULL(ingreso_consentimiento_informado_riesgo_complicacion.`Observacion`, '') Observacion\n    , IF(ingreso_consentimiento_informado_riesgo_complicacion.`Id_TipoRiesgo_Complicacion`= `h_tipo_riesgo_complicacion`.`Id`, TRUE, FALSE) Grabado\nFROM\n    `h_tipo_riesgo_complicacion` \n    INNER JOIN `g_procedimiento_triesgo_complicacion`\n        ON (`g_procedimiento_triesgo_complicacion`.`Id_TipoRiesgo_Complicacion` = `h_tipo_riesgo_complicacion`.`Id`)\n    INNER JOIN `h_tipo_riesgo_complicacion_clasificacion` \n        ON (`h_tipo_riesgo_complicacion`.`IdTipoClasificacion` = `h_tipo_riesgo_complicacion_clasificacion`.`Id`)\n    left JOIN `ingreso_consentimiento_informado_riesgo_complicacion` \n        ON (`ingreso_consentimiento_informado_riesgo_complicacion`.`Id_TipoRiesgo_Complicacion` = `h_tipo_riesgo_complicacion`.`Id`)\n         AND (ingreso_consentimiento_informado_riesgo_complicacion.`Id_Consentimiento`=" + xidconsentimiento + ") AND (ingreso_consentimiento_informado_riesgo_complicacion.`Estado`=1)\n         WHERE `g_procedimiento_triesgo_complicacion`.`Id_Procedimiento`=" + idProcedimiento + "";
        System.out.println("COmplicacion  : " + sql);
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConsentimientoInfxRiesgoDTO xConcentimientoInf = new ConsentimientoInfxRiesgoDTO();
                xConcentimientoInf.setIdConsentimiento(rs.getLong("Id"));
                xConcentimientoInf.setIdTipoRiesgoComplicacion(rs.getString("NtipoRiesgoComplicacion"));
                xConcentimientoInf.setObservacion(rs.getString("Observacion"));
                xConcentimientoInf.setEstado(rs.getInt("Grabado"));
                xConcentimientoInf.setTipo(rs.getString("Tipo"));
                return xConcentimientoInf;
            }
        };
        List<ConsentimientoInfxRiesgoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }
}
