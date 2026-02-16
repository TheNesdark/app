package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.ImplementacionReportesRecusoHumanoDAO;
import com.genoma.plus.dto.rrhh.DetalleReporteNominaConceptoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/ImplementacionReporteRecursoHumanoDAOImpl.class */
public class ImplementacionReporteRecursoHumanoDAOImpl implements ImplementacionReportesRecusoHumanoDAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.ImplementacionReportesRecusoHumanoDAO
    public List<DetalleReporteNominaConceptoDTO> listadoDetalleReporteNominaConcepto(Integer forma, String idNomina, String idClasificacion) {
        if (forma.intValue() == 0) {
            this.sql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `NDocumento`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NEmpleado`\n    , `rh_tipo_persona_cargon`.`SalarioB` AS `NSalario`,ROUND((`rh_tipo_persona_cargon`.`SalarioB`/30)*rh_nomina_liquidacion_detalle.`Cantidad`)  AS `NSalarioDv`\n    , rh_nomina_liquidacion_detalle.`BaseIbc`\n    , rh_nomina_liquidacion_detalle.`VBaseC`\n    , rh_nomina_liquidacion_detalle.`Cantidad`\n    , `rh_nomina_concepto_unidadf`.`Id` AS `Id_Concepto`    \n    , `rh_nomina_conceptos`.`Nbre` AS `NConcepto`\n    , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=2,'Días', IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=3,IF(`rh_nomina_liquidacion_detalle`.`Valor`<>0,CONCAT(`rh_nomina_liquidacion_detalle`.`Valor`, '%'), CONCAT(`rh_nomina_liquidacion_detalle`.`ValorE`, '%')) , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=4,'VF', '')))  AS `TCalculo`\n    , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=3, `rh_nomina_liquidacion_detalle`.`NHora`, `rh_nomina_liquidacion_detalle`.`Valor`) Valor\n,`rh_nomina_liquidacion_detalle`.`TValorE` VDevengado\n    , `rh_tipo_clasificacion`.`Nbre` AS `NClasificacion`\n    , `rh_nomina_conceptos`.`EsDeduccion`  \n    , CONCAT(`rh_nomina_periodo`.`Nbre`, ' ', MID(`rh_nomina_periodo`.`Del`,1,2),'-',`rh_nomina_liquidacion`.`Ano`, ' HASTA ', `rh_nomina_periodo`.`Nbre`, MID(`rh_nomina_periodo`.`Al`,1,2),'-',`rh_nomina_liquidacion`.`Ano`) AS `Periodo`    \n      , rh_unidad_funcional.`Nbre` AS UnidadF, `rh_nomina_conceptos`.`NOrden`\n      , rh_unidad_funcional.`NUnificacion`\nFROM\n\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_periodo`\n        ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_tipo_clasificacion`\n        ON (`rh_tipo_persona_cargon`.`Id_Clasificacion` = `rh_tipo_clasificacion`.`Id`)\n--    INNER JOIN  `rh_unidadf_tipocargo`\n--        ON (`rh_tipo_persona_cargon`.`Id_Cargo` = `rh_unidadf_tipocargo`.`Id_Tipo_Cargo`)\n    INNER JOIN  `g_persona`\n        ON (`rh_tipo_persona_cargon`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `rh_unidadf_cargo`\n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN `rh_unidad_funcional`\n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)\n    INNER JOIN  `rh_tipo_cargo`\n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos`\n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n INNER JOIN  `rh_tipo_clasificacion_conceptonomina`\n        ON (`rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`)\n    INNER JOIN  `rh_tipo_persona_cargon` AS `rh_tipo_persona_cargon_1`\n        ON (`rh_tipo_persona_cargon_1`.`Id` = `rh_nomina_liquidacion`.`Id_PersonaR`)\n        WHERE (rh_nomina_liquidacion.`Id`='" + idNomina + "'\n        AND  rh_tipo_clasificacion_conceptonomina.EsReporte=0\n  AND  rh_unidad_funcional.`NUnificacion`= '" + idClasificacion + "'\n-- AND ( `rh_nomina_liquidacion_detalle`.`VDevengado` <>0 ||\n --    `rh_nomina_liquidacion_detalle`.`VDeducido`<>0)\n     )\n     HAVING (VDevengado <>0)\nORDER BY rh_unidad_funcional.`Nbre` ASC, `NEmpleado` ASC, `rh_nomina_conceptos`.`NOrden` ASC;";
        } else {
            this.sql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `NDocumento`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NEmpleado`\n    , `rh_tipo_persona_cargon`.`SalarioB` AS `NSalario`,ROUND((`rh_tipo_persona_cargon`.`SalarioB`/30)*rh_nomina_liquidacion_detalle.`Cantidad`)  AS `NSalarioDv`, rh_nomina_liquidacion_detalle.`BaseIbc`, rh_nomina_liquidacion_detalle.`VBaseC`\n    , rh_nomina_liquidacion_detalle.`Cantidad`\n    , `rh_nomina_concepto_unidadf`.`Id` AS `Id_Concepto`    \n    , `rh_nomina_conceptos`.`Nbre` AS `NConcepto`\n    , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=2,'Días', IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=3,CONCAT(`rh_nomina_liquidacion_detalle`.`Valor`, '%') , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=4,'VF', '')))  AS `TCalculo`\n    , IF(`rh_nomina_liquidacion_detalle`.`TCalculo`=3, `rh_nomina_liquidacion_detalle`.`NHora`, `rh_nomina_liquidacion_detalle`.`Valor`) Valor\n,IF( `rh_nomina_liquidacion_detalle`.`VDevengado`<>0,  `rh_nomina_liquidacion_detalle`.`VDevengado`, (`rh_nomina_liquidacion_detalle`.`VDeducido`*-1)) VDevengado\n--    , `rh_nomina_liquidacion_detalle`.`VDevengado`\n --   , `rh_nomina_liquidacion_detalle`.`VDeducido`\n    , `rh_tipo_clasificacion`.`Nbre` AS `NClasificacion`\n    , `rh_nomina_conceptos`.`EsDeduccion`\n    , CONCAT(`rh_nomina_periodo`.`Nbre`, ' ', MID(`rh_nomina_periodo`.`Del`,1,2),'-',`rh_nomina_liquidacion`.`Ano`, ' HASTA ', `rh_nomina_periodo`.`Nbre`, MID(`rh_nomina_periodo`.`Al`,1,2),'-',`rh_nomina_liquidacion`.`Ano`) AS `Periodo`\n      , rh_unidad_funcional.`Nbre` AS UnidadF\n      , `rh_nomina_conceptos`.`NOrden`\n\t,  rh_unidad_funcional.`NUnificacion`\nFROM    \n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_periodo`\n        ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_tipo_clasificacion`\n        ON (`rh_tipo_persona_cargon`.`Id_Clasificacion` = `rh_tipo_clasificacion`.`Id`)\n--    INNER JOIN  `rh_unidadf_tipocargo`\n--        ON (`rh_tipo_persona_cargon`.`Id_Cargo` = `rh_unidadf_tipocargo`.`Id_Tipo_Cargo`)\n    INNER JOIN  `g_persona`\n        ON (`rh_tipo_persona_cargon`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `rh_unidadf_cargo`\n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN `rh_unidad_funcional`\n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)\n    INNER JOIN  `rh_tipo_cargo`\n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos`\n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n INNER JOIN  `rh_tipo_clasificacion_conceptonomina`\n        ON (`rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`)\n    INNER JOIN  `rh_tipo_persona_cargon` AS `rh_tipo_persona_cargon_1`\n        ON (`rh_tipo_persona_cargon_1`.`Id` = `rh_nomina_liquidacion`.`Id_PersonaR`)\n        WHERE (rh_nomina_liquidacion.`Id`='" + idNomina + "'\n        AND  rh_tipo_clasificacion_conceptonomina.EsReporte=1\n       -- AND  rh_unidad_funcional.`NUnificacion`='" + idClasificacion + "'\n AND ( `rh_nomina_liquidacion_detalle`.`VDevengado` <>0 ||\n     `rh_nomina_liquidacion_detalle`.`VDeducido`<>0))\n     ORDER BY rh_unidad_funcional.`Nbre` ASC, `NEmpleado` ASC, `rh_nomina_conceptos`.`NOrden` ASC;";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ImplementacionReporteRecursoHumanoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                DetalleReporteNominaConceptoDTO g = new DetalleReporteNominaConceptoDTO();
                g.setDocumento(rs.getString("NDocumento"));
                g.setNombreEmpleado(rs.getString("NEmpleado"));
                g.setValorSalario(Double.valueOf(rs.getDouble("NSalario")));
                g.setValorSalarioDevengado(Double.valueOf(rs.getDouble("NSalarioDv")));
                g.setValorBaseIbc(Double.valueOf(rs.getDouble("BaseIbc")));
                g.setValorBase(Double.valueOf(rs.getDouble("VBaseC")));
                g.setNumeroDias(Double.valueOf(rs.getDouble("Cantidad")));
                g.setIdConcepto(Long.valueOf(rs.getLong("Id_Concepto")));
                g.setNombreConcepto(rs.getString("NConcepto"));
                g.setFormaCalculo(rs.getString("TCalculo"));
                g.setValorCalculo(Double.valueOf(rs.getDouble("Valor")));
                g.setValorDevengado(Double.valueOf(rs.getDouble("VDevengado")));
                g.setNombreClasificacionConcepto(rs.getString("NClasificacion"));
                g.setEsDeducion(Integer.valueOf(rs.getInt("EsDeduccion")));
                g.setUnidadFuncional(rs.getString("UnidadF"));
                g.setOrdenConcepto(Long.valueOf(rs.getLong("NOrden")));
                g.setNombreConceptoUnificado(rs.getString("NUnificacion"));
                return g;
            }
        };
        List<DetalleReporteNominaConceptoDTO> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }
}
