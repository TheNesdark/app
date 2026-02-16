package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.GeneralRhDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/GeneralDAOImpl.class */
public class GeneralDAOImpl implements GeneralRhDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.GeneralRhDAO
    public List<Object[]> mListadoUsuario(String xFiltro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.GeneralDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                return fila;
            }
        };
        String xSql = "SELECT\n    `rh_tipo_persona_cargon`.`Id`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `rh_tipo_cargo`.`Nbre` AS `Cargo`\n    , `rh_unidad_funcional`.`Nbre` AS `UnidadFuncional`, g_persona.`Correo`\nFROM\n     `rh_tipo_persona_cargon`\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_unidad_funcional` \n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)\n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nWHERE (`rh_tipo_persona_cargon`.`Estado` =1 AND (`g_persona`.`NoDocumento`LIKE '" + xFiltro + "%' or CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) LIKE'" + xFiltro + "%'))\nORDER BY `NUsuario` ASC";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.rrhh.GeneralRhDAO
    public List<Object[]> listadoUnidadFuncionalConceptoNomina() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.GeneralDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT  `cc_unidad_funcional`.`Id` , `cc_unidad_funcional`.`Nbre` \nFROM `rh_nomina_concepto_unidadf` INNER JOIN  `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN  `cc_unidad_funcional`  ON (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` = `cc_unidad_funcional`.`Id`)\nGROUP BY `cc_unidad_funcional`.`Id`\nORDER BY `cc_unidad_funcional`.`Nbre` ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.rrhh.GeneralRhDAO
    public List<Object[]> listadoConceptoNominaUnidadFuncional(String idUnidadFuncional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.GeneralDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        String xSql = "SELECT  `rh_nomina_concepto_unidadf`.`Id` , `rh_nomina_conceptos`.`Nbre`\nFROM `rh_nomina_concepto_unidadf` INNER JOIN  `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN  `cc_unidad_funcional`  ON (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` = `cc_unidad_funcional`.`Id`)\nWHERE (`cc_unidad_funcional`.`Id` ='" + idUnidadFuncional + "' and rh_nomina_concepto_unidadf.`Estado`=1)\nORDER BY `rh_nomina_conceptos`.`Nbre` ASC";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
