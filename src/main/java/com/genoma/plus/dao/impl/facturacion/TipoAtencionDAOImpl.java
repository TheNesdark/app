package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.TipoAtencionDAO;
import com.genoma.plus.dto.facturacion.TipoAtencionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.table.DefaultTableModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/TipoAtencionDAOImpl.class */
public class TipoAtencionDAOImpl implements TipoAtencionDAO {
    private JdbcTemplate jdbcTemplate;
    private DefaultTableModel xmodelo;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.TipoAtencionDAO
    public List<Object[]> listTipoAtencion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.TipoAtencionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3)), Long.valueOf(rs.getLong(4)), rs.getString(5), Boolean.valueOf(rs.getBoolean(6)), Long.valueOf(rs.getLong(7)), rs.getString(8), rs.getString(9)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT `g_tipoatencion`.`Id` , `g_tipoatencion`.`Nbre` , `g_tipoatencion`.`GenHosp` , `g_tipoatencion`.`Id_TipoAmbito` , `g_tipoambito`.`Nbre` , `g_tipoatencion`.`Estado` , `g_tipoatencion`.`Orden` ,\n  g_grupo_servicio.`nombre` grupoServicio, g_grupo_servicio.id  FROM `baseserver`.`g_tipoatencion` INNER JOIN `baseserver`.`g_tipoambito` ON (`g_tipoatencion`.`Id_TipoAmbito` = `g_tipoambito`.`Id`)  INNER JOIN `g_grupo_servicio`\n    ON g_grupo_servicio.`id` = g_tipoatencion.`grupoServicio` ORDER BY `g_tipoatencion`.`Orden`;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.TipoAtencionDAO
    public void addTipoAtencion(TipoAtencionDTO tipoAtencionDTO) {
        this.jdbcTemplate.update("INSERT INTO `g_tipoatencion` (`Nbre`,`GenHosp`,`Id_TipoAmbito`,`Estado`,`Orden`,`UsuarioS`, grupoServicio) VALUES (?,?,?,?,?,?,?)", new Object[]{tipoAtencionDTO.getNombre(), Boolean.valueOf(tipoAtencionDTO.isGenHosp()), Integer.valueOf(tipoAtencionDTO.getIdTipoAmbito()), Boolean.valueOf(tipoAtencionDTO.isEstado()), Integer.valueOf(tipoAtencionDTO.getOrden()), tipoAtencionDTO.getUsuarioSistema()});
    }

    @Override // com.genoma.plus.dao.facturacion.TipoAtencionDAO
    public void updateTipoAtencion(TipoAtencionDTO tipoAtencionDTO) {
        this.jdbcTemplate.update("UPDATE  `g_tipoatencion` SET `Nbre`= ?,`GenHosp`= ?,`Id_TipoAmbito`= ?,`Estado`= ?,`Orden`= ?,`UsuarioS`= ?, grupoServicio=?  WHERE  `Id` = ?", new Object[]{tipoAtencionDTO.getNombre(), Boolean.valueOf(tipoAtencionDTO.isGenHosp()), Integer.valueOf(tipoAtencionDTO.getIdTipoAmbito()), Boolean.valueOf(tipoAtencionDTO.isEstado()), Integer.valueOf(tipoAtencionDTO.getOrden()), tipoAtencionDTO.getUsuarioSistema(), Integer.valueOf(tipoAtencionDTO.getId())});
    }

    @Override // com.genoma.plus.dao.facturacion.TipoAtencionDAO
    public List<Object[]> listTipoAmbito() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.TipoAtencionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n  `Id`,\n  `Nbre`\nFROM\n  `baseserver`.`g_tipoambito`", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.TipoAtencionDAO
    public List<Object[]> listGrupoServicio() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.TipoAtencionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n  `id`,\n  `nombre`\nFROM\n  `baseserver`.`g_grupo_servicio`", mapper);
        return list;
    }
}
