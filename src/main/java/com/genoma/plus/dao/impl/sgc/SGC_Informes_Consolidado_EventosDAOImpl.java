package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.SGC_Informes_Consolidado_EventosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SGC_Informes_Consolidado_EventosDAOImpl.class */
public class SGC_Informes_Consolidado_EventosDAOImpl implements SGC_Informes_Consolidado_EventosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informes_Consolidado_EventosDAO
    public List<Object[]> informeConsolidadoTipoEvento(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informes_Consolidado_EventosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), Long.valueOf(rs.getLong(3)), Long.valueOf(rs.getLong(4)), Double.valueOf(rs.getDouble(5))};
                return fila;
            }
        };
        String sql = "SELECT\n    `s_sgc_tipoproceso`.`Nbre` AS `NProceso`\n    , `s_sgc_sc_tipoevento`.`Nbre` AS `NEvento`\n    , COUNT(`s_sgc_sc_tipoevento`.`Id`) AS `Numero`\n    , d.CantidadTotal, round(((COUNT(`s_sgc_sc_tipoevento`.`Id`)/d.CantidadTotal)*100),2) Porcentaje\nFROM\n     (SELECT COUNT(s_sgc_sc_evento_adverso.`Id`) CantidadTotal\nFROM  `s_sgc_sc_evento_adverso`\nWHERE s_sgc_sc_evento_adverso.`FechaE`>='" + xFechai + "'\n AND  s_sgc_sc_evento_adverso.`FechaE`<='" + xFechaf + "' AND s_sgc_sc_evento_adverso.`Estado`=1) d, `s_sgc_sc_evento_adverso`\n    INNER JOIN  `s_sgc_sc_triesgo_tevento` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TRiesgoE` = `s_sgc_sc_triesgo_tevento`.`Id`)\n    INNER JOIN  `s_sgc_sc_tipoevento` \n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\n    INNER JOIN  `s_sgc_tipoproceso` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)\nWHERE (`s_sgc_sc_evento_adverso`.`FechaE` >='" + xFechai + "'\n    AND `s_sgc_sc_evento_adverso`.`FechaE` <='" + xFechaf + "'\n    AND `s_sgc_sc_evento_adverso`.`Estado` =1)\nGROUP BY `s_sgc_sc_tipoevento`.`Id`\nORDER BY `NProceso` ASC, `NEvento` ASC";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informes_Consolidado_EventosDAO
    public List<Object[]> informeConsolidadoTipoClasificacion(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informes_Consolidado_EventosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[5];
                fila[0] = rs.getString(1);
                fila[1] = Long.valueOf(rs.getLong(2));
                fila[2] = Long.valueOf(rs.getLong(3));
                fila[3] = Double.valueOf(rs.getDouble(4));
                return fila;
            }
        };
        String sql = "SELECT D.NClasicacion , COUNT(D.IdC) NEventos, j.Cant,  ROUND(((COUNT(D.IdC)/j.Cant)*100),2) Porcentaje FROM (SELECT COUNT(s_sgc_sc_evento_adverso.`Id`) Cant\nFROM  `s_sgc_sc_evento_adverso`\nWHERE s_sgc_sc_evento_adverso.`FechaE`>='" + xFechai + "'\n AND  s_sgc_sc_evento_adverso.`FechaE`<='" + xFechaf + "' AND s_sgc_sc_evento_adverso.`Estado`=1) j, (\nSELECT\n    `s_sgc_sc_evento_adverso`.`Id`\n    , `s_sgc_sc_tipoevento`.`Nbre` NTipoEvento\n    , IFNULL(`s_sgc_sc_tipoclasificacion`.`Id`, -1) IdC\n    , IFNULL(`s_sgc_sc_tipoclasificacion`.`Nbre`, 'NO CLASIFICADO')  NClasicacion\nFROM\n     `s_sgc_sc_evento_adverso`\n    INNER JOIN  `s_sgc_sc_triesgo_tevento` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TRiesgoE` = `s_sgc_sc_triesgo_tevento`.`Id`)\n    INNER JOIN  `s_sgc_sc_tipoevento` \n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\n    INNER JOIN  `s_sgc_tipoproceso` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)\n    LEFT JOIN  `s_sgc_sc_evento_adverso_clasificacion` \n        ON (`s_sgc_sc_evento_adverso_clasificacion`.`Id_Evento` = `s_sgc_sc_evento_adverso`.`Id`)\n    LEFT JOIN  `s_sgc_sc_tipoclasificacion` \n        ON (`s_sgc_sc_evento_adverso_clasificacion`.`Id_Clasificacion` = `s_sgc_sc_tipoclasificacion`.`Id`)\nWHERE (`s_sgc_sc_evento_adverso`.`FechaE` >='" + xFechai + "'\n    AND `s_sgc_sc_evento_adverso`.`FechaE` <='" + xFechaf + "'\n    AND `s_sgc_sc_evento_adverso`.`Estado` =1)\n    ) D GROUP BY D.IdC ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informes_Consolidado_EventosDAO
    public List<Object[]> informeConsolidadoTipoCategoria(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informes_Consolidado_EventosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[5];
                fila[0] = rs.getString(1);
                fila[1] = Long.valueOf(rs.getLong(2));
                fila[2] = Long.valueOf(rs.getLong(3));
                fila[3] = Double.valueOf(rs.getDouble(4));
                return fila;
            }
        };
        String sql = "SELECT\n     `s_sgc_tipo_categoria`.`Nbre`\n    , COUNT(`s_sgc_tipo_categoria`.`Id`) AS `Cantidad`, j.Cant,  ROUND(((COUNT(`s_sgc_tipo_categoria`.`Id`)/j.Cant)*100),2) Porcentaje\nFROM  (SELECT COUNT(s_sgc_sc_evento_adverso.`Id`) Cant\nFROM  `s_sgc_sc_evento_adverso`\nWHERE s_sgc_sc_evento_adverso.`FechaE`>='" + xFechai + "'\n AND  s_sgc_sc_evento_adverso.`FechaE`<='" + xFechaf + "' AND s_sgc_sc_evento_adverso.`Estado`=1) j, \n     `s_sgc_sc_evento_adverso`\n    INNER JOIN  `s_sgc_sc_triesgo_tevento` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TRiesgoE` = `s_sgc_sc_triesgo_tevento`.`Id`)\n    INNER JOIN  `s_sgc_sc_tipoevento` \n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\n    INNER JOIN  `s_sgc_tipoproceso` \n        ON (`s_sgc_sc_evento_adverso`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)\n    INNER JOIN  `s_sgc_tipo_categoria` \n        ON (`s_sgc_sc_tipoevento`.`Id_Categoria` = `s_sgc_tipo_categoria`.`Id`)\nWHERE (`s_sgc_sc_evento_adverso`.`FechaE` >='" + xFechai + "'\n    AND `s_sgc_sc_evento_adverso`.`FechaE` <='" + xFechaf + "'\n    AND `s_sgc_sc_evento_adverso`.`Estado` =1)\nGROUP BY `s_sgc_tipo_categoria`.`Id`";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
