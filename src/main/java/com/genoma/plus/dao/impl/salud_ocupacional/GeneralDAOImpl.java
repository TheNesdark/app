package com.genoma.plus.dao.impl.salud_ocupacional;

import com.genoma.plus.dao.salud_ocupacional.GeneralDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/GeneralDAOImpl.class */
public class GeneralDAOImpl implements GeneralDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.GeneralDAO
    public List<Object[]> listPeriodosFinancieros() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.GeneralDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT `so_manporwer_encabezado`.`Id`  , `cc_periodo_financiero`.`Nbre`\nFROM `so_manporwer_encabezado`  INNER JOIN  `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`)\nGROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`Nbre` ", mapper);
        return list;
    }
}
