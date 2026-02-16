package com.genoma.plus.dao.impl.laboratorio;

import com.genoma.plus.dao.laboratorio.HomologacionItemsExternosDAO;
import com.genoma.plus.dto.laboratorio.HomologacionItemsExternosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/HomologacionItemsExternosDAOImpl.class */
public class HomologacionItemsExternosDAOImpl implements HomologacionItemsExternosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.HomologacionItemsExternosDAO
    public List<HomologacionItemsExternosDTO> listaItemsExternos() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.HomologacionItemsExternosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                HomologacionItemsExternosDTO g = new HomologacionItemsExternosDTO();
                g.setIdCodigoPadre(rs.getLong("idCodigoPadre"));
                g.setNombreExterno(rs.getString("nombreExterno"));
                g.setIdDetalleAnalito(rs.getLong("idDetalleAnalito"));
                g.setIdProcedimiento(rs.getLong("idProcedimiento"));
                g.setEsUltimoNivel(rs.getInt("esUltimo"));
                return g;
            }
        };
        List<HomologacionItemsExternosDTO> listaConsulta = this.jdbcTemplate.query("SELECT `idCodigoPadre`,`nombreExterno`,`idDetalleAnalito`,`idProcedimiento`,`esUltimo` FROM `l_homologacion_items_externos`", rowMapper);
        return listaConsulta;
    }

    @Override // com.genoma.plus.dao.laboratorio.HomologacionItemsExternosDAO
    public String create(HomologacionItemsExternosDTO item) {
        String result = "Datos insertados Satisfactoriamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO `l_homologacion_items_externos` (`idCodigoPadre`,`nombreExterno`,`idDetalleAnalito`,`idProcedimiento`,`esUltimo`)\nVALUES (?,?,?,?,?);", new Object[]{Long.valueOf(item.getIdCodigoPadre()), item.getNombreExterno(), Long.valueOf(item.getIdDetalleAnalito()), Long.valueOf(item.getIdProcedimiento()), Integer.valueOf(item.getEsUltimoNivel())});
        if (ctos == 0) {
            result = "No se inserto ";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.laboratorio.HomologacionItemsExternosDAO
    public String update(HomologacionItemsExternosDTO item) {
        String sql = "UPDATE\n  `l_homologacion_items_externos`\nSET\n  `esUltimo` = ?\nWHERE `idCodigoPadre` = ?\n  AND `idDetalleAnalito` = ?\n  AND `idProcedimiento` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(item.getEsUltimoNivel()), Long.valueOf(item.getIdCodigoPadre()), Long.valueOf(item.getIdDetalleAnalito()), Long.valueOf(item.getIdProcedimiento())});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }
}
