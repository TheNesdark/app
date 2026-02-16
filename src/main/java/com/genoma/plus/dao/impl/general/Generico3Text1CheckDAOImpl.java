package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.Generico3Text1CheckDAO;
import com.genoma.plus.dto.general.Generico3Text1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/Generico3Text1CheckDAOImpl.class */
public class Generico3Text1CheckDAOImpl implements Generico3Text1CheckDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.Generico3Text1CheckDAO
    public List<Generico3Text1CheckDTO> list(String xConsulta) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico3Text1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Generico3Text1CheckDTO gen = new Generico3Text1CheckDTO();
                gen.setXId(rs.getString(1));
                gen.setXNbre(rs.getString(2));
                gen.setXNbre1(rs.getString(3));
                gen.setXEstado(rs.getInt(4));
                return gen;
            }
        };
        List<Generico3Text1CheckDTO> lsGen = this.jdbcTemplate.query(xConsulta, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.Generico3Text1CheckDAO
    public String create(Generico3Text1CheckDTO gen, String xConsulta) {
        String result = "Se insertó correctamente";
        int ctos = this.jdbcTemplate.update(xConsulta, new Object[]{gen.getXId(), gen.getXNbre(), gen.getXNbre1(), Integer.valueOf(gen.getXEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.Generico3Text1CheckDAO
    public String update(Generico3Text1CheckDTO gen, String xConsulta) {
        String sql = xConsulta;
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getXId(), gen.getXNbre(), gen.getXNbre1(), Integer.valueOf(gen.getXEstado()), Principal.usuarioSistemaDTO.getLogin(), gen.getXId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.Generico3Text1CheckDAO
    public String delete(Generico3Text1CheckDTO gen, String xTabla) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
