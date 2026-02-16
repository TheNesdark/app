package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.PP_RubrosEncabezadoDAO;
import com.genoma.plus.dto.general.PP_RubrosEncabezadoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/PP_RubrosEncabezadoDAOImpl.class */
public class PP_RubrosEncabezadoDAOImpl implements PP_RubrosEncabezadoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.PP_RubrosEncabezadoDAO
    public List<PP_RubrosEncabezadoDTO> mListar() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PP_RubrosEncabezadoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PP_RubrosEncabezadoDTO forma = new PP_RubrosEncabezadoDTO();
                forma.setId(rs.getInt("id"));
                forma.setNombre(rs.getString("nombre"));
                forma.setFechaR(rs.getString("fechaR"));
                forma.setFechaI(rs.getString("fechaI"));
                forma.setFechaF(rs.getString("fechaF"));
                forma.setEstado(rs.getInt("estado"));
                return forma;
            }
        };
        List<PP_RubrosEncabezadoDTO> lsTipo = this.jdbcTemplate.query("SELECT `id`, `nombre`, `fechaR`, `fechaI`, `fechaF`, `estado` FROM `pp_rubros_encabezado` ORDER BY `nombre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.PP_RubrosEncabezadoDAO
    public String mCreate(PP_RubrosEncabezadoDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_rubros_encabezado`(`nombre`,`fechaR`,`fechaI`,`fechaF`,`estado`,`UsuarioS`) VALUES (?,?,?,?,?,?);", new Object[]{gen.getNombre(), gen.getFechaR(), gen.getFechaI(), gen.getFechaF(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.PP_RubrosEncabezadoDAO
    public String mUpdate(PP_RubrosEncabezadoDTO gen) {
        String sql = "UPDATE `pp_rubros_encabezado` SET `nombre` = ?,   `fechaR` = ?,   `fechaI` = ?,   `fechaF` = ?,   `estado` = ?,   `UsuarioS` = ? WHERE `id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), gen.getFechaR(), gen.getFechaI(), gen.getFechaF(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
