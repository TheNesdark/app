package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.ConsultarNominaxFechaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/ConsultarNominaxFechaDAOImpl.class */
public class ConsultarNominaxFechaDAOImpl implements ConsultarNominaxFechaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.ConsultarNominaxFechaDAO
    public List<Object[]> mListaNomina(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ConsultarNominaxFechaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[29];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = Double.valueOf(rs.getDouble(5));
                fila[5] = Double.valueOf(rs.getDouble(6));
                fila[6] = Double.valueOf(rs.getDouble(7));
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                return fila;
            }
        };
        String xSql = "SELECT\n     CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento`\n     , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `Empleado`\n     , `rh_tipo_cargo`.`Nbre` AS `Cargo`\n     , `rh_nomina_conceptos`.`Nbre`\n     , SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`) AS VDevengado\n     , SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`) AS VDeducido\n     , SUM(`rh_nomina_liquidacion_detalle`.`TValorE`) AS TValorE\n     , `g_persona`.`NoDocumento`\n     , rh_tipo_clasificacion_conceptonomina.`Nbre` AS Concepto\n     , cc_terceros.`TDCompleto2`\n     ,IF(rh_nomina_conceptos.`MTercero`=1,cc_terceros.`RazonSocialCompleta`, '') TerceroP\n\tFROM\n      `rh_nomina_liquidacion_detalle`\n     INNER JOIN  `rh_nomina_liquidacion` \n         ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n     INNER JOIN  `rh_tipo_persona_cargon` \n         ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n     INNER JOIN  `rh_nomina_concepto_unidadf` \n         ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n     INNER JOIN  `g_persona` \n         ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n     INNER JOIN  `rh_unidadf_cargo` \n         ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n     INNER JOIN  `rh_nomina_conceptos` \n         ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n     INNER JOIN  `rh_unidad_funcional` \n         ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)\n     INNER JOIN  `rh_tipo_cargo` \n         ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) \n     INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n         ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`) \n     INNER JOIN  `cc_terceros`\n         ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_terceros`.`Id`)  \n     WHERE (rh_nomina_liquidacion.`FechaR`>='" + xFechaI + "' AND rh_nomina_liquidacion.`FechaR`<='" + xFechaF + "') AND rh_nomina_liquidacion.Estado =1 \n     GROUP BY rh_nomina_liquidacion_detalle.`Id_PersonaC`, `rh_nomina_conceptos`.`Id` ORDER BY `Empleado` ASC, rh_nomina_conceptos.`Id`";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
