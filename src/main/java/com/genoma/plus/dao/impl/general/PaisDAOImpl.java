package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.PaisDAO;
import com.genoma.plus.dto.general.PaisDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/PaisDAOImpl.class */
public class PaisDAOImpl implements PaisDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.PaisDAO
    public List<PaisDTO> listPais() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PaisDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PaisDTO xPais = new PaisDTO();
                xPais.setId(rs.getString("Id"));
                xPais.setNombre(rs.getString("Nbre"));
                xPais.setCodigo(rs.getString("Codigo"));
                xPais.setEstado(rs.getInt("Estado"));
                return xPais;
            }
        };
        List<PaisDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `Codigo`, `Estado` FROM `g_pais` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.PaisDAO
    public String mCreate(PaisDTO xPais) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO `g_pais` (`Id`,`Nbre`,`Codigo`,`Estado`, `Id_UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{xPais.getId(), xPais.getNombre(), xPais.getCodigo(), Integer.valueOf(xPais.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.PaisDAO
    public String mUpdate(PaisDTO xPais) {
        String sql = "UPDATE\n  `g_pais`\nSET\n  `Nbre` = ?,\n  `Codigo` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xPais.getNombre(), xPais.getCodigo(), Integer.valueOf(xPais.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xPais.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
