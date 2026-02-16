package com.genoma.plus.dao.impl.pyp;

import com.genoma.plus.dao.pyp.GestionExamenesPyPDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/pyp/GestionExamenesPyPDAOImpl.class */
public class GestionExamenesPyPDAOImpl implements GestionExamenesPyPDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.pyp.GestionExamenesPyPDAO
    public List<Object[]> listaOrdenesProcedimientos(String xFechaI, String xFechaF, String xFiltro, String xFiltroNombre) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.GestionExamenesPyPDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("FechaOrden"), rs.getString("Documento"), rs.getString("NoHistoria"), rs.getString("NUsuario"), rs.getString("Edad"), rs.getString("Sexo"), rs.getString("Telefono"), rs.getString("EmpresaConvenio"), Long.valueOf(rs.getLong("IdProcedimiento")), rs.getString("Nprocedimiento"), rs.getString("NEspecialidad"), rs.getString("Profesional"), Long.valueOf(rs.getLong("IdIngreso")), Long.valueOf(rs.getLong("IdAtencion")), Long.valueOf(rs.getLong("IdUsuario")), Integer.valueOf(rs.getInt("Id_TipoCita")), Integer.valueOf(rs.getInt("Id_Historia")), Integer.valueOf(rs.getInt("Id_Programa")), rs.getString("FechaAtencion"), Integer.valueOf(rs.getInt("Id_TipoAtencion")), Boolean.valueOf(rs.getBoolean("Seguimiento")), Long.valueOf(rs.getLong("IdItem"))};
                return fila;
            }
        };
        String sql = "SELECT\n    `h_ordenes`.`FechaOrden`\n    , CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`   \n    , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_ordenes`.`FechaOrden`),' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `h_ordenes`.`FechaOrden`)) AS `Edad`\n    , `g_persona`.`Id_Sexo` AS `Sexo`\n    ,  IF((g_persona.`Telefono`='' AND g_persona.`Movil`=''), 'NO REGISTRA', IF((g_persona.`Telefono`<>'' AND g_persona.`Movil`<>''), CONCAT(g_persona.`Telefono`,' - ',g_persona.`Movil`) , IF((g_persona.`Telefono`='' AND g_persona.`Movil`<>''), g_persona.`Movil`, g_persona.`Telefono`))) Telefono \n    , `f_empresacontxconvenio`.`Nbre` AS `EmpresaConvenio`\n    , `g_procedimiento`.`Id` IdProcedimiento\n    , `g_procedimiento`.`Nbre` AS `Nprocedimiento`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    ,  CONCAT(`Profesional`.`Apellido1` ,' ', `Profesional`.`Apellido2`,' ',`Profesional`.`Nombre1`,' ',`Profesional`.`Nombre2`) AS `Profesional`\n    , `ingreso`.`Id` AS `IdIngreso`\n    , `h_atencion`.`Id` AS `IdAtencion`\n    , `g_usuario`.`Id_persona` AS `IdUsuario`    \n    , `c_clasecita`.`Id_TipoCita`    \n    , `c_clasecita`.`Id_Historia`\n    , `c_clasecita`.`Id_Programa`    \n    ,  CONCAT(`h_atencion`.`Fecha_Atencion` ,' ', `h_atencion`.`Hora_Atencion`) AS `FechaAtencion`    \n    , `ingreso`.`Id_TipoAtencion` , IF(h_itemordenproced_seguimiento.`Id` IS NULL, 0, 1) Seguimiento, h_itemordenesproced.Id IdItem\n    \nFROM\n     `ingreso`\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `h_itemordenesproced` \n        ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `h_itemordenesproced`.`Id_Procedimiento`)\n    INNER JOIN  `g_persona` AS `Profesional` \n        ON (`Profesional`.`Id` = `h_ordenes`.`Id_Profesional`)\n    LEFT JOIN `h_itemordenproced_seguimiento`    \n\tON (h_itemordenproced_seguimiento.`Id_ItemsOrden`=h_itemordenesproced.`Id`) AND (h_itemordenproced_seguimiento.`Estado`=1)\nWHERE (`h_ordenes`.`FechaOrden` >='" + xFechaI + "'\n    AND `h_ordenes`.`Estado` =0\n    AND `g_procedimiento`.`Seguimiento` =1\n    AND `h_ordenes`.`FechaOrden` <='" + xFechaF + "'    \n    )\nGROUP BY h_itemordenesproced.`Id`\nHAVING(NUsuario LIKE '" + xFiltroNombre + "%' AND NoHistoria LIKE '" + xFiltroNombre + "%' and Seguimiento in (" + xFiltro + "))\nORDER BY `h_ordenes`.`FechaOrden` ASC, NUsuario ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
