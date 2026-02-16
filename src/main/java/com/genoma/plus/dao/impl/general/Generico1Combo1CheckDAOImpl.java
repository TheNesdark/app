package com.genoma.plus.dao.impl.general;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.Generico1Combo1CheckDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.Generico1Combo1CheckDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/Generico1Combo1CheckDAOImpl.class */
public class Generico1Combo1CheckDAOImpl implements Generico1Combo1CheckDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.Generico1Combo1CheckDAO
    public List<Generico1Combo1CheckDTO> list(String xsql) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico1Combo1CheckDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Generico1Combo1CheckDTO g = new Generico1Combo1CheckDTO();
                g.setIdGenerico1(rs.getString(1));
                g.setIdGenerico2(rs.getString(2));
                g.setEstado(rs.getInt(3));
                return g;
            }
        };
        List<Generico1Combo1CheckDTO> lsEstrato = this.jdbcTemplate.query(xsql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.Generico1Combo1CheckDAO
    public List<GCGenericoDTO> listComboGenerico(String xsql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico1Combo1CheckDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.Generico1Combo1CheckDAO
    public List<GCGenericoDTO> listComboGenericoConIdString(String xsql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.Generico1Combo1CheckDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setIdString(rs.getString("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.Generico1Combo1CheckDAO
    public String mCreate(Generico1Combo1CheckDTO g, String xsql) {
        String result = "Se insertó correctamente";
        int ctos = this.jdbcTemplate.update(xsql, new Object[]{g.getIdGenerico1(), g.getIdGenerico2(), Integer.valueOf(g.getEstado()), g.getIdUsuario()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.Generico1Combo1CheckDAO
    public String mUpdate(Generico1Combo1CheckDTO g, String xsql) {
        int ctos = this.jdbcTemplate.update(xsql, new Object[]{Integer.valueOf(g.getEstado()), g.getIdUsuario(), g.getIdGenerico1(), g.getIdGenerico2()});
        if (ctos == 0) {
            xsql = "0 filas afectadas";
        }
        return xsql;
    }
}
