package com.genoma.plus.dao.impl.enfermeria;

import Acceso.Principal;
import com.genoma.plus.dao.enfermeria.AgendaProcedimientosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/enfermeria/AgendaProcedimientosDAOImpl.class */
public class AgendaProcedimientosDAOImpl implements AgendaProcedimientosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.enfermeria.AgendaProcedimientosDAO
    public List<Object[]> listCargarProcedimientos(String fecha, String filtroEstado, String filtroNombre) {
        String sql;
        if (filtroNombre.isEmpty()) {
            sql = "SELECT\n     CONCAT(`ingreso`.`FechaIngreso` ,' ', `ingreso`.`HoraIngreso`) AS `fechaHora`\n     , CONCAT(g_persona.`Id_TipoIdentificacion`, ' ', g_persona.`NoDocumento`) documentoUsuario\n    ,  CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `nombreUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `CalculaTiempo_AMD_2Fechas`(`g_persona`.`FechaNac`, `ingreso`.`FechaIngreso`) AS `Edad`\n    , `f_empresacontxconvenio`.`Nbre` AS `empresaConvenio`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nombreProcedimiento`\n    , IF(`f_ordenes`.`EstadoRecep`=0,'POR ATENDER', 'ATENDIDO') nombreEstado\n    , `f_ordenes`.`EstadoRecep`\n    , `f_ordenes`.`Id` idOrden\n    , `f_ordenes`.`Id_Ingreso`, g_usuario.NoHistoria\n    , gs.Nbre  sede\n   \nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n        inner join g_sedes gs on (ingreso.Id_Sede=gs.Id)\nWHERE (`g_procedimiento`.`AProcEnfer` =1\n    AND `f_ordenes`.`Estado` =0 and ingreso.Id_Sede = '" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "'\n    AND  `f_ordenes`.`EstadoRecep` IN (" + filtroEstado + ")\n    AND `ingreso`.`FechaIngreso` ='" + fecha + "')\nORDER BY   `ingreso`.`HoraIngreso` ASC ";
        } else {
            sql = "SELECT\n     CONCAT(`ingreso`.`FechaIngreso` ,' ', `ingreso`.`HoraIngreso`) AS `fechaHora`\n     , CONCAT(g_persona.`Id_TipoIdentificacion`, ' ', g_persona.`NoDocumento`) documentoUsuario\n    ,  CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `nombreUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `CalculaTiempo_AMD_2Fechas`(`g_persona`.`FechaNac`, `ingreso`.`FechaIngreso`) AS `Edad`\n    , `f_empresacontxconvenio`.`Nbre` AS `empresaConvenio`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nombreProcedimiento`\n    , IF(`f_ordenes`.`EstadoRecep`=0,'POR ATENDER', 'ATENDIDO') nombreEstado\n    , `f_ordenes`.`EstadoRecep`\n    , `f_ordenes`.`Id` idOrden\n    , `f_ordenes`.`Id_Ingreso`, g_usuario.NoHistoria\n    , gs.Nbre  sede\n   \nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n        inner join g_sedes gs on (ingreso.Id_Sede=gs.Id)\nWHERE (`g_procedimiento`.`AProcEnfer` =1\n    AND `f_ordenes`.`Estado` =0 and ingreso.Id_Sede = '" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "'\n    AND  `f_ordenes`.`EstadoRecep` IN (" + filtroEstado + ")\n    AND (CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) LIKE'" + filtroNombre + "%'   OR g_persona.`NoDocumento`  LIKE'" + filtroNombre + "%')\n    AND `ingreso`.`FechaIngreso` ='" + fecha + "')\nORDER BY   `ingreso`.`HoraIngreso` ASC ";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.enfermeria.AgendaProcedimientosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString("fechaHora"), rs.getString("documentoUsuario"), rs.getString("nombreUsuario"), rs.getString("Id_Sexo"), rs.getString("Edad"), rs.getString("empresaConvenio"), Long.valueOf(rs.getLong("idProcedimiento")), rs.getString("nombreProcedimiento"), rs.getString("nombreEstado"), Integer.valueOf(rs.getInt("EstadoRecep")), Long.valueOf(rs.getLong("idOrden")), Long.valueOf(rs.getLong("Id_Ingreso")), rs.getString("NoHistoria"), rs.getString("sede")};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.enfermeria.AgendaProcedimientosDAO
    public void actualizarEstadoAtencion(Long idIngreso) {
        String sql = "update f_ordenes set EstadoRecep=1, UsuarioA='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Ingreso=" + idIngreso + "";
        this.jdbcTemplate.execute(sql);
    }
}
