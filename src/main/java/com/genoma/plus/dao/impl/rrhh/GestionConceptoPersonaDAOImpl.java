package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/GestionConceptoPersonaDAOImpl.class */
public class GestionConceptoPersonaDAOImpl implements GestionConceptoPersonaDAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO
    public List<Object[]> listadoConceptosPersona(String idConceptoUnidadFuncional, int esSoloConcepto, String dato) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.GestionConceptoPersonaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Documento"), rs.getString("Empleado"), rs.getString("UFuncional"), rs.getString("Concepto"), Integer.valueOf(rs.getInt("TCalculo")), Double.valueOf(rs.getDouble("Valor")), Double.valueOf(rs.getDouble("NHoras")), Boolean.valueOf(rs.getBoolean("Estado")), Long.valueOf(rs.getLong("Id_PersonaC")), Long.valueOf(rs.getLong("Id_RhConcepto_UF")), Boolean.valueOf(rs.getBoolean("Aplica"))};
                return fila;
            }
        };
        if (esSoloConcepto == 0) {
            if (idConceptoUnidadFuncional.isEmpty()) {
                this.sql = "SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',  `g_persona`.`Nombre2`) AS `Empleado` , `cc_unidad_funcional`.`Nbre` AS `UFuncional` , `rh_nomina_conceptos`.`Nbre` AS `Concepto`\n, rh_nomina_persona_conceptos.`TCalculo`, rh_nomina_persona_conceptos.`Valor`, rh_nomina_persona_conceptos.`NHoras`,`rh_nomina_persona_conceptos`.`Estado` , `rh_nomina_persona_conceptos`.`Id_PersonaC` , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF`, false as Aplica FROM `rh_nomina_concepto_unidadf` INNER JOIN   `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)  INNER JOIN   `cc_unidad_funcional`   ON (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` = `cc_unidad_funcional`.`Id`)\nINNER JOIN   `rh_nomina_persona_conceptos`  ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)  INNER JOIN   `rh_tipo_persona_cargon`   ON (`rh_nomina_persona_conceptos`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\nINNER JOIN   `rh_unidadf_cargo`   ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)  INNER JOIN   `rh_tipo_cargo`   ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN   `g_persona`   ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n WHERE  `rh_tipo_persona_cargon`.`Estado`=1 AND (`g_persona`.`NoDocumento` LIKE'" + dato + "%' OR CONCAT(`g_persona`.`Apellido1`,`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) LIKE'" + dato + "%') ORDER BY `Empleado` ASC, `Concepto` ASC";
            } else {
                this.sql = "SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',  `g_persona`.`Nombre2`) AS `Empleado` , `cc_unidad_funcional`.`Nbre` AS `UFuncional` , `rh_nomina_conceptos`.`Nbre` AS `Concepto`\n, rh_nomina_persona_conceptos.`TCalculo`, rh_nomina_persona_conceptos.`Valor`, rh_nomina_persona_conceptos.`NHoras`,`rh_nomina_persona_conceptos`.`Estado` , `rh_nomina_persona_conceptos`.`Id_PersonaC` , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF`, false as Aplica FROM `rh_nomina_concepto_unidadf` INNER JOIN   `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)  INNER JOIN   `cc_unidad_funcional`   ON (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` = `cc_unidad_funcional`.`Id`)\nINNER JOIN   `rh_nomina_persona_conceptos`  ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)  INNER JOIN   `rh_tipo_persona_cargon`   ON (`rh_nomina_persona_conceptos`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\nINNER JOIN   `rh_unidadf_cargo`   ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)  INNER JOIN   `rh_tipo_cargo`   ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN   `g_persona`   ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`rh_nomina_concepto_unidadf`.`Id` ='" + idConceptoUnidadFuncional + "'  AND `rh_tipo_persona_cargon`.`Estado`=1 AND (`g_persona`.`NoDocumento` LIKE'" + dato + "%' OR CONCAT(`g_persona`.`Apellido1`,`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) LIKE'" + dato + "%'))\nORDER BY `UFuncional` ASC, `Concepto` ASC, `Empleado` ASC";
            }
        } else {
            String idConcepto = buscarConceptoNomina(idConceptoUnidadFuncional);
            this.sql = "SELECT CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',  `g_persona`.`Nombre2`) AS `Empleado` , `cc_unidad_funcional`.`Nbre` AS `UFuncional` , `rh_nomina_conceptos`.`Nbre` AS `Concepto`\n, rh_nomina_persona_conceptos.`TCalculo`, rh_nomina_persona_conceptos.`Valor`, rh_nomina_persona_conceptos.`NHoras`,`rh_nomina_persona_conceptos`.`Estado` , `rh_nomina_persona_conceptos`.`Id_PersonaC` , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF`, FALSE AS Aplica FROM `rh_nomina_concepto_unidadf` INNER JOIN   `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)  INNER JOIN   `cc_unidad_funcional`   ON (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` = `cc_unidad_funcional`.`Id`)\nINNER JOIN   `rh_nomina_persona_conceptos`  ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)  INNER JOIN   `rh_tipo_persona_cargon`   ON (`rh_nomina_persona_conceptos`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\nINNER JOIN   `rh_unidadf_cargo`   ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)  INNER JOIN   `rh_tipo_cargo`   ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN   `g_persona`   ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n WHERE  (`rh_nomina_conceptos`.`Id`= " + idConcepto + " AND `rh_tipo_persona_cargon`.`Estado`=1 AND (`g_persona`.`NoDocumento` LIKE'" + dato + "%' OR CONCAT(`g_persona`.`Apellido1`,`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) LIKE'" + dato + "%'))ORDER BY `Empleado` ASC, `Concepto` ASC";
        }
        System.out.println("xsql-->" + this.sql);
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO
    public void iniciarValoresFijos(String idConceptoUnidadFuncional, String idPersonaCargo) {
        if (idConceptoUnidadFuncional.isEmpty()) {
            this.sql = "UPDATE rh_nomina_persona_conceptos, ( \n SELECT \n     `rh_nomina_conceptos`.`TipoCalculo` \n     , `rh_nomina_conceptos`.`BInicializar` \n     , `rh_nomina_persona_conceptos`.`Valor` \n     , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` \n FROM \n      `rh_nomina_persona_conceptos` \n     INNER JOIN  `rh_nomina_concepto_unidadf`  \n         ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`) \n     INNER JOIN  `rh_nomina_conceptos`  \n         ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) \n WHERE (`rh_nomina_conceptos`.`TipoCalculo` =4 \n     AND `rh_nomina_conceptos`.`BInicializar` =1 \n     AND `rh_nomina_persona_conceptos`.`Valor` <>0)) d SET rh_nomina_persona_conceptos.`Valor`=0 \n     WHERE rh_nomina_persona_conceptos.`Id_RhConcepto_UF`=d.Id_RhConcepto_UF";
        } else {
            this.sql = "UPDATE rh_nomina_persona_conceptos , ( \n SELECT \n     `rh_nomina_conceptos`.`TipoCalculo` \n     , `rh_nomina_conceptos`.`BInicializar` \n     , `rh_nomina_persona_conceptos`.`Valor` \n     , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` \n FROM \n      `rh_nomina_persona_conceptos` \n     INNER JOIN  `rh_nomina_concepto_unidadf`  \n         ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`) \n     INNER JOIN  `rh_nomina_conceptos`  \n         ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) \n WHERE (`rh_nomina_conceptos`.`TipoCalculo` =4 \n     AND `rh_nomina_conceptos`.`BInicializar` =1 \n     AND `rh_nomina_persona_conceptos`.`Valor` <>0)) d SET rh_nomina_persona_conceptos.`Valor`=0 \n     WHERE rh_nomina_persona_conceptos.`Id_RhConcepto_UF`='" + idConceptoUnidadFuncional + "' and rh_nomina_persona_conceptos.Id_PersonaC='" + idPersonaCargo + "'";
        }
        this.jdbcTemplate.update(this.sql);
    }

    @Override // com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO
    public void iniciarValoresHoras(String idConceptoUnidadFuncional, String idPersonaCargo) {
        if (idConceptoUnidadFuncional.isEmpty()) {
            this.sql = "update rh_nomina_persona_conceptos set NHoras=0";
        } else {
            this.sql = " update rh_nomina_persona_conceptos set NHoras=0 \n WHERE rh_nomina_persona_conceptos.`Id_RhConcepto_UF`='" + idConceptoUnidadFuncional + "' and rh_nomina_persona_conceptos.Id_PersonaC='" + idPersonaCargo + "'";
        }
        this.jdbcTemplate.update(this.sql);
    }

    @Override // com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO
    public void actualizarValoresConceptoPersona(String idConceptoUnidadFuncional, String idPersonaCargo, Boolean estado, Double valor, Double numeroHoras) {
        this.sql = "update rh_nomina_persona_conceptos set estado=" + estado + " , rh_nomina_persona_conceptos.`Valor`=" + valor + " , rh_nomina_persona_conceptos.`NHoras`=" + numeroHoras + " WHERE rh_nomina_persona_conceptos.`Id_RhConcepto_UF`='" + idConceptoUnidadFuncional + "' and rh_nomina_persona_conceptos.Id_PersonaC='" + idPersonaCargo + "'";
        System.out.println("" + this.sql);
        this.jdbcTemplate.execute(this.sql);
    }

    @Override // com.genoma.plus.dao.rrhh.GestionConceptoPersonaDAO
    public String buscarConceptoNomina(String idConceptoUnidadFuncional) {
        String sql = "SELECT `Id_ConceptosN` FROM `rh_nomina_concepto_unidadf` WHERE Id = " + idConceptoUnidadFuncional + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.GestionConceptoPersonaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                String id = rs.getString(1);
                return id;
            }
        };
        List<String> lista = this.jdbcTemplate.query(sql, mapper);
        return lista.get(0);
    }
}
