package com.genoma.plus.dao.impl.comprabs;

import Acceso.Principal;
import com.genoma.plus.dao.comprabs.CierreOrdenDAO;
import com.genoma.plus.dto.comprabs.CierreOrdenDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/comprabs/CierreOrdenDAOImpl.class */
public class CierreOrdenDAOImpl implements CierreOrdenDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.comprabs.CierreOrdenDAO
    public List<CierreOrdenDTO> list(String xidOrdenCompra) {
        String sql = "SELECT `Id`, `FechaC`, `Observacion` FROM `cc_orden_compra_cierre` WHERE (`Id_Orden_Compra` ='" + xidOrdenCompra + "' AND `Estado` =1);";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.comprabs.CierreOrdenDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CierreOrdenDTO orden = new CierreOrdenDTO();
                orden.setId(rs.getInt("Id"));
                orden.setFecha(rs.getString("FechaC"));
                orden.setObservacion(rs.getString("Observacion"));
                return orden;
            }
        };
        List<CierreOrdenDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.comprabs.CierreOrdenDAO
    public String create(CierreOrdenDTO orden) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_orden_compra_cierre` (`Id_Orden_Compra`,`FechaC`,`Observacion`,`Estado`,`Id_RhPCierre`)\nVALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(orden.getIdOrdenCompra()), orden.getFecha(), orden.getObservacion(), Integer.valueOf(orden.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.comprabs.CierreOrdenDAO
    public String delete(CierreOrdenDTO orden) {
        String sql = "UPDATE `cc_orden_compra_cierre`\nSET `Estado` = ?,\n  `Id_RhPCierre` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(orden.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Integer.valueOf(orden.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
