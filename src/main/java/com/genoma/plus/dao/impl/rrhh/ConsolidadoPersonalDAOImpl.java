package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.ConsolidadoPersonalDAO;
import com.genoma.plus.dto.rrhh.ConsolidadoPersonalDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/ConsolidadoPersonalDAOImpl.class */
public class ConsolidadoPersonalDAOImpl implements ConsolidadoPersonalDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.ConsolidadoPersonalDAO
    public List<ConsolidadoPersonalDTO> listConsolidadoPersonal(String xfechai, String xfechaf) {
        String xsql = "SELECT\n    `rh_tipo_persona_cargon`.`Codigo`\n    , `rh_tipo_persona_cargon`.`Grado`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS Usuario\n    , `rh_tipo_persona_cargon`.`SalarioB`\nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN `rh_tipo_persona_cargon` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`FechaR` >='" + xfechai + "'\n    AND `rh_nomina_liquidacion`.`FechaR` <='" + xfechaf + "'\n    AND `rh_tipo_persona_cargon`.`Estado` =1)\nGROUP BY `g_persona`.`Id` ORDER BY Usuario ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ConsolidadoPersonalDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsolidadoPersonalDTO g = new ConsolidadoPersonalDTO();
                g.setCodigo(rs.getString("Codigo"));
                g.setGrado(rs.getString("Grado"));
                g.setUsuario(rs.getString("Usuario"));
                g.setSalarioB(Double.valueOf(rs.getDouble("SalarioB")));
                return g;
            }
        };
        List<ConsolidadoPersonalDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.rrhh.ConsolidadoPersonalDAO
    public List<ConsolidadoPersonalDTO> listInformePersonal2193(String xfechai, String xfechaf) {
        String xsql = "SELECT\n    `rh_tipo_persona_cargon`.`Codigo`\n    , `rh_tipo_persona_cargon`.`Grado`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS Usuario\n    , `rh_tipo_persona_cargon`.`SalarioB`\n    , (SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`)+SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`)+SUM(`rh_nomina_liquidacion_detalle`.`TValorE`)) AS Total\nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN `rh_tipo_persona_cargon` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`FechaR` >='" + xfechai + "'\n    AND `rh_nomina_liquidacion`.`FechaR` <='" + xfechaf + "'\n    AND `rh_tipo_persona_cargon`.`Estado` =1)\nGROUP BY `g_persona`.`Id` ORDER BY Usuario ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ConsolidadoPersonalDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsolidadoPersonalDTO g = new ConsolidadoPersonalDTO();
                g.setCodigo(rs.getString("Codigo"));
                g.setGrado(rs.getString("Grado"));
                g.setUsuario(rs.getString("Usuario"));
                g.setSalarioB(Double.valueOf(rs.getDouble("SalarioB")));
                g.setSalarioT(Double.valueOf(rs.getDouble("Total")));
                return g;
            }
        };
        List<ConsolidadoPersonalDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
