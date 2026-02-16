package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.General1Text2Spinner1CheckDAO;
import com.genoma.plus.dto.general.General1Text2Spinner1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/General1Text2Spinner1CheckDAOImpl.class */
public class General1Text2Spinner1CheckDAOImpl implements General1Text2Spinner1CheckDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.General1Text2Spinner1CheckDAO
    public List<General1Text2Spinner1CheckDTO> list(String xTabla) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.General1Text2Spinner1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                General1Text2Spinner1CheckDTO gen = new General1Text2Spinner1CheckDTO();
                gen.setId(rs.getInt(1));
                gen.setNombre(rs.getString(2));
                gen.setJsgenerico1(rs.getInt(3));
                gen.setJsgenerico2(rs.getInt(4));
                gen.setEstado(rs.getInt(5));
                return gen;
            }
        };
        List<General1Text2Spinner1CheckDTO> lsGen = this.jdbcTemplate.query(xTabla, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.General1Text2Spinner1CheckDAO
    public String create(General1Text2Spinner1CheckDTO gen, String xTabla) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update(xTabla, new Object[]{gen.getNombre(), Integer.valueOf(gen.getJsgenerico1()), Integer.valueOf(gen.getJsgenerico2()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.General1Text2Spinner1CheckDAO
    public String update(General1Text2Spinner1CheckDTO gen, String xTabla) {
        String sql = xTabla;
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), Integer.valueOf(gen.getJsgenerico1()), Integer.valueOf(gen.getJsgenerico2()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.General1Text2Spinner1CheckDAO
    public String delete(General1Text2Spinner1CheckDTO gen, String xTabla) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
