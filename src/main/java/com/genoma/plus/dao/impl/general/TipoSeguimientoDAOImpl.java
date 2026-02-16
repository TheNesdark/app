package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoSeguimientoDAO;
import com.genoma.plus.dto.general.TipoSeguimientoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoSeguimientoDAOImpl.class */
public class TipoSeguimientoDAOImpl implements TipoSeguimientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoSeguimientoDAO
    public List<TipoSeguimientoDTO> listTipoSeguimiento() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoSeguimientoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoSeguimientoDTO tiposeguimiento = new TipoSeguimientoDTO();
                tiposeguimiento.setId(Long.valueOf(rs.getLong("Id")));
                tiposeguimiento.setNombre(rs.getString("Nbre"));
                tiposeguimiento.setTipo(rs.getString("Tipo"));
                tiposeguimiento.setPCierreFactura(rs.getInt("PCierreFactura"));
                tiposeguimiento.setNOrden(rs.getInt("NOrden"));
                tiposeguimiento.setEstado(rs.getInt("Estado"));
                return tiposeguimiento;
            }
        };
        List<TipoSeguimientoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, IF(`Tipo`=0, 'ASISTENCIAL',IF(`Tipo`=1,'ADMINISTRATIVO','NO APLICA')) AS Tipo , `PCierreFactura`, `Estado`, NOrden FROM `g_tiposeguimiento` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.TipoSeguimientoDAO
    public String mCreate(TipoSeguimientoDTO xTipoSeguimiento) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `g_tiposeguimiento` (`Nbre`,`Tipo`,`PCierreFactura`, NOrden,`Estado`,`Id_UsuarioS`)\nVALUES(?,?,?,?,?,?);", new Object[]{xTipoSeguimiento.getNombre(), xTipoSeguimiento.getTipo(), Integer.valueOf(xTipoSeguimiento.getPCierreFactura()), Integer.valueOf(xTipoSeguimiento.getNOrden()), Integer.valueOf(xTipoSeguimiento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoSeguimientoDAO
    public String mUpdate(TipoSeguimientoDTO xTipoSeguimiento) {
        String sql = "update\n  `g_tiposeguimiento`\nset\n  `Nbre` = ?,\n  `Tipo` = ?,\n  `PCierreFactura` = ?,\n  `Estado` = ?,\n  `NOrden` = ?,\n  `Id_UsuarioS` = ?\nwhere `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xTipoSeguimiento.getNombre(), xTipoSeguimiento.getTipo(), Integer.valueOf(xTipoSeguimiento.getPCierreFactura()), Integer.valueOf(xTipoSeguimiento.getEstado()), Integer.valueOf(xTipoSeguimiento.getNOrden()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xTipoSeguimiento.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
