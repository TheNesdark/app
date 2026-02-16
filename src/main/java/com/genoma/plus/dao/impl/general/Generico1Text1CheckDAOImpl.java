package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.Generico1Text1CheckDAO;
import com.genoma.plus.dto.general.Generico1Text1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/Generico1Text1CheckDAOImpl.class */
public class Generico1Text1CheckDAOImpl implements Generico1Text1CheckDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.Generico1Text1CheckDAO
    public List<Generico1Text1CheckDTO> list(String xConsulta) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico1Text1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Generico1Text1CheckDTO gen = new Generico1Text1CheckDTO();
                gen.setXId(rs.getInt(1));
                gen.setXNombre(rs.getString(2));
                gen.setXEstado(rs.getInt(3));
                return gen;
            }
        };
        List<Generico1Text1CheckDTO> lsGen = this.jdbcTemplate.query(xConsulta, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.Generico1Text1CheckDAO
    public String create(Generico1Text1CheckDTO gen, String xConsulta) {
        String result = "Se insertó correctamente";
        int ctos = this.jdbcTemplate.update(xConsulta, new Object[]{gen.getXNombre(), Integer.valueOf(gen.getXEstado()), gen.getXIdUsuario()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.Generico1Text1CheckDAO
    public String update(Generico1Text1CheckDTO gen, String xConsulta) {
        String sql = xConsulta;
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getXNombre(), Integer.valueOf(gen.getXEstado()), gen.getXIdUsuario(), Integer.valueOf(gen.getXId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.Generico1Text1CheckDAO
    public String delete(Generico1Text1CheckDTO gen, String xConsulta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
