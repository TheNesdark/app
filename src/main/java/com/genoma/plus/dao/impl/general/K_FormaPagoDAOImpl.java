package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.K_FormaPagoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.K_FormaPagoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/K_FormaPagoDAOImpl.class */
public class K_FormaPagoDAOImpl implements K_FormaPagoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.K_FormaPagoDAO
    public List<K_FormaPagoDTO> mListar() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.K_FormaPagoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                K_FormaPagoDTO forma = new K_FormaPagoDTO();
                forma.setId(rs.getInt("Id"));
                forma.setNombre(rs.getString("Nbre"));
                forma.setCDebito(rs.getString("CDebito"));
                forma.setNOrden(rs.getInt("Orden"));
                forma.setDatosA(rs.getInt("DatosA"));
                forma.setEstado(rs.getInt("Estado"));
                return forma;
            }
        };
        List<K_FormaPagoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `CDebito`, `Orden`, `DatosA`, `Estado` FROM `k_formapago` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.K_FormaPagoDAO
    public String mCreate(K_FormaPagoDTO xforma) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `k_formapago`(`Nbre`,`Estado`,`DatosA`,`Orden`,`CDebito`,`UsuarioS`) VALUES (?,?,?,?,?,?);", new Object[]{xforma.getNombre(), Integer.valueOf(xforma.getEstado()), Integer.valueOf(xforma.getDatosA()), Integer.valueOf(xforma.getNOrden()), xforma.getCDebito(), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.K_FormaPagoDAO
    public String mUpdate(K_FormaPagoDTO xforma) {
        String sql = "UPDATE `k_formapago` SET    `Nbre` = ?,   `Estado` = ?,   `DatosA` = ?,   `Orden` = ?,   `CDebito` = ?,   `UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xforma.getNombre(), Integer.valueOf(xforma.getEstado()), Integer.valueOf(xforma.getDatosA()), Integer.valueOf(xforma.getNOrden()), xforma.getCDebito(), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(xforma.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.K_FormaPagoDAO
    public List<GCGenericoDTO> mVerificarCuenta(String xcuenta) {
        String xsql = "SELECT `Id`, `Nbre` FROM `cc_puc` WHERE (`Id` ='" + xcuenta + "' AND `UNivel` =1);";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.K_FormaPagoDAOImpl.2
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
}
