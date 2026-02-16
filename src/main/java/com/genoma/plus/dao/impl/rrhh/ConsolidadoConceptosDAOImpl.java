package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.ConsolidadoConceptosDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.rrhh.ConsolidadoConceptosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/ConsolidadoConceptosDAOImpl.class */
public class ConsolidadoConceptosDAOImpl implements ConsolidadoConceptosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.ConsolidadoConceptosDAO
    public List<ConsolidadoConceptosDTO> list(String xidLiquidacion) {
        String xsql = "SELECT\n    `rh_nomina_liquidacion`.`Id` AS idLiquidacion\n    , `rh_nomina_conceptos`.`Id` AS idConcepto\n    , `rh_nomina_conceptos`.`Nbre` AS nConcepto\n    ,SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',0,`rh_nomina_liquidacion_detalle`.`VDevengado`)) AS Dev_ASISTENCIAL\n    ,SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',`rh_nomina_liquidacion_detalle`.`VDevengado`,0) )AS Dev_ADMINISTRATIVO\n    , SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',0,`rh_nomina_liquidacion_detalle`.`VDeducido`)) AS Ded_ASISTENCIAL\n     , SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',`rh_nomina_liquidacion_detalle`.`VDeducido`,0)) AS Ded_ADMINISTRATIVO\n    , `rh_nomina_concepto_unidadf`.`RPresupuesto`\n    , SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',0,`rh_nomina_liquidacion_detalle`.`TValorE`)) AS VEmp_ASISTENCIAL\n    , SUM(IF(`rh_tipo_clasificacion`.`Nbre`='ADMINISTRATIVO',`rh_nomina_liquidacion_detalle`.`TValorE`,0)) AS VEmp_ADMINISTRATIVO\n    , `rh_tipo_clasificacion`.`Nbre` AS nClasificacion\n    , CONCAT(`rh_nomina_periodo`.`Nbre`, ' ', MID(`rh_nomina_periodo`.`Del`,1,2),'-',`rh_nomina_liquidacion`.`Ano`, ' HASTA ', `rh_nomina_periodo`.`Nbre`, MID(`rh_nomina_periodo`.`Al`,1,2),'-',`rh_nomina_liquidacion`.`Ano`) AS `Periodo`\n    \nFROM  `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos`\n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n         INNER JOIN  `rh_nomina_periodo`\n        ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_tipo_clasificacion`\n        ON (`rh_tipo_persona_cargon`.`Id_Clasificacion` = `rh_tipo_clasificacion`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`Id` ='" + xidLiquidacion + "'\n  --  AND `rh_nomina_concepto_unidadf`.`RPresupuesto` <>''\n    )\nGROUP BY `rh_nomina_conceptos`.`Id`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ConsolidadoConceptosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsolidadoConceptosDTO g = new ConsolidadoConceptosDTO();
                g.setIdLiquidacion(Long.valueOf(rs.getLong("idLiquidacion")));
                g.setIdConceptos(Long.valueOf(rs.getLong("idConcepto")));
                g.setNConceptos(rs.getString("nConcepto"));
                g.setRubroPresupuestal(rs.getString("RPresupuesto"));
                g.setDevAsistencial(Double.valueOf(rs.getDouble("Dev_ASISTENCIAL")));
                g.setDevAdministrativo(Double.valueOf(rs.getDouble("Dev_ADMINISTRATIVO")));
                g.setDedAsistencial(Double.valueOf(rs.getDouble("Ded_ASISTENCIAL")));
                g.setDedAdministrativo(Double.valueOf(rs.getDouble("Ded_ADMINISTRATIVO")));
                g.setVEmpresaAsistencial(Double.valueOf(rs.getDouble("VEmp_ASISTENCIAL")));
                g.setVEmpresaAdministrativo(Double.valueOf(rs.getDouble("VEmp_ADMINISTRATIVO")));
                g.setNClasificacion(rs.getString("nClasificacion"));
                g.setPeriodo(rs.getString("Periodo"));
                return g;
            }
        };
        List<ConsolidadoConceptosDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.rrhh.ConsolidadoConceptosDAO
    public List<GCGenericoDTO> listaNomina(String str) {
        String xsql = "SELECT `rh_nomina_liquidacion`.`Id`, CONCAT(`rh_nomina_liquidacion`.`Id`,' ',`rh_nomina_periodo`.`Nbre`, ' ', MID(`rh_nomina_periodo`.`Del`,1,2),'-',`rh_nomina_liquidacion`.`Ano`, ' HASTA ', `rh_nomina_periodo`.`Nbre`,' ', MID(`rh_nomina_periodo`.`Al`,1,2),'-',`rh_nomina_liquidacion`.`Ano`) AS Id_Nomina FROM`rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` \nON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` \nON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` \nON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` \nON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)\nINNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\nINNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nINNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)\nINNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\nINNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nINNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nINNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)\nWHERE (rh_nomina_liquidacion.`Ano`='" + str + "' AND rh_nomina_liquidacion.`Estado`=1) GROUP BY `rh_nomina_liquidacion`.`Id`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ConsolidadoConceptosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Id_Nomina"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
