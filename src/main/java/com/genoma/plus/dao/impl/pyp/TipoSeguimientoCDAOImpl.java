package com.genoma.plus.dao.impl.pyp;

import com.genoma.plus.dao.pyp.TipoSeguimientoCDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/pyp/TipoSeguimientoCDAOImpl.class */
public class TipoSeguimientoCDAOImpl implements TipoSeguimientoCDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.pyp.TipoSeguimientoCDAO
    public List<Object[]> listTipoSeguimiento() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.TipoSeguimientoCDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = Long.valueOf(rs.getLong(1));
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`    \nFROM\n    `p_citologia_tiposeguimiento`\nWHERE (`Estado` =1)\nORDER BY `Nbre` ASC", mapper);
        return list;
    }
}
