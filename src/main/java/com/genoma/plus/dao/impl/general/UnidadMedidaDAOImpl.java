package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.UnidadMedidaDAO;
import com.genoma.plus.dto.general.UnidadMedidaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/UnidadMedidaDAOImpl.class */
public class UnidadMedidaDAOImpl implements UnidadMedidaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.UnidadMedidaDAO
    public List<UnidadMedidaDTO> mListar() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.UnidadMedidaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                UnidadMedidaDTO xunidad = new UnidadMedidaDTO();
                xunidad.setId(Long.valueOf(rs.getLong("Id")));
                xunidad.setNombre(rs.getString("Nbre"));
                xunidad.setDescripcion(rs.getString("Descripcion"));
                xunidad.setNInvima(rs.getString("NInvima"));
                xunidad.setMedida(rs.getInt("Medida"));
                xunidad.setEstado(rs.getInt("Estado"));
                xunidad.setCodigo(Integer.valueOf(rs.getInt("codigo")));
                return xunidad;
            }
        };
        List<UnidadMedidaDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `NInvima`, `Descripcion`, `Medida`, `Estado`, `codigo` FROM `i_unidadmedida` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.UnidadMedidaDAO
    public String mCreate(UnidadMedidaDTO xunidad) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `baseserver`.`i_unidadmedida` (`Nbre`,`NInvima`,`Descripcion`,`Medida`,`Estado`, codigo, UsuarioS)\nVALUES (?,?,?,?,?,?,?);", new Object[]{xunidad.getNombre(), xunidad.getNInvima(), xunidad.getDescripcion(), Integer.valueOf(xunidad.getMedida()), Integer.valueOf(xunidad.getEstado()), xunidad.getCodigo(), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.UnidadMedidaDAO
    public String mUpdate(UnidadMedidaDTO xunidad) {
        String sql = "UPDATE `i_unidadmedida` SET `Nbre` = ?,   `NInvima` = ?,   `Descripcion` = ?,   `Medida` = ?,   `Estado` = ?,   `codigo`= ?,   `UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xunidad.getNombre(), xunidad.getNInvima(), xunidad.getDescripcion(), Integer.valueOf(xunidad.getMedida()), Integer.valueOf(xunidad.getEstado()), xunidad.getCodigo(), Principal.usuarioSistemaDTO.getLogin(), xunidad.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
