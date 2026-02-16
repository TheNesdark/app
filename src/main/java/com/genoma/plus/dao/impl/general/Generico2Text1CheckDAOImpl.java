package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.Generico2Text1CheckDAO;
import com.genoma.plus.dto.general.Generico2Text1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/Generico2Text1CheckDAOImpl.class */
public class Generico2Text1CheckDAOImpl implements Generico2Text1CheckDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.Generico2Text1CheckDAO
    public List<Generico2Text1CheckDTO> mListar(String xconsulta) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico2Text1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Generico2Text1CheckDTO gen = new Generico2Text1CheckDTO();
                gen.setId(Long.valueOf(rs.getLong(1)));
                gen.setNombre(rs.getString(2));
                gen.setTipo(rs.getInt(3));
                gen.setEstado(rs.getInt(4));
                return gen;
            }
        };
        List<Generico2Text1CheckDTO> lsGen = this.jdbcTemplate.query(xconsulta, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.Generico2Text1CheckDAO
    public String create(Generico2Text1CheckDTO gen, String xconsulta) {
        String result = "Se insertó correctamente";
        int ctos = this.jdbcTemplate.update(xconsulta, new Object[]{gen.getNombre(), Integer.valueOf(gen.getTipo()), Integer.valueOf(gen.getEstado()), gen.getIdUsuario()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.Generico2Text1CheckDAO
    public String update(Generico2Text1CheckDTO gen, String xconsulta) {
        String sql = xconsulta;
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), Integer.valueOf(gen.getTipo()), Integer.valueOf(gen.getEstado()), gen.getIdUsuario(), gen.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
