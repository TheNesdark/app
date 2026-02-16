package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ExamenFisicoPrenatalDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ExamenFisicoPrenatalDAOImpl.class */
public class ExamenFisicoPrenatalDAOImpl implements ExamenFisicoPrenatalDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoPrenatalDAO
    public List<Object[]> mConsultaDatosExamenFisico(int idUsuarioPrograma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoPrenatalDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[13];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = Integer.valueOf(rs.getInt(4));
                fila[4] = Integer.valueOf(rs.getInt(5));
                fila[5] = rs.getString(6);
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("", mapper, new Object[]{Integer.valueOf(idUsuarioPrograma)});
        return list;
    }
}
