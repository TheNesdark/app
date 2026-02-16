package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO;
import com.genoma.plus.dto.general.General1Text1Spinner1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/General1Text1Spinner1CheckDAOImpl.class */
public class General1Text1Spinner1CheckDAOImpl implements General1Text1Spinner1CheckDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO
    public List<General1Text1Spinner1CheckDTO> list(String xConsulta) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.General1Text1Spinner1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                General1Text1Spinner1CheckDTO gen = new General1Text1Spinner1CheckDTO();
                gen.setId(rs.getInt(1));
                gen.setNombre(rs.getString(2));
                gen.setOrden(rs.getInt(3));
                gen.setEstado(rs.getInt(4));
                return gen;
            }
        };
        List<General1Text1Spinner1CheckDTO> lsGen = this.jdbcTemplate.query(xConsulta, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO
    public String create(General1Text1Spinner1CheckDTO gen, String xConsulta) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update(xConsulta, new Object[]{gen.getNombre(), Integer.valueOf(gen.getOrden()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO
    public String update(General1Text1Spinner1CheckDTO gen, String xConsulta) {
        String sql = xConsulta;
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), Integer.valueOf(gen.getOrden()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO
    public String delete(General1Text1Spinner1CheckDTO gen, String xTabla) {
        return null;
    }
}
