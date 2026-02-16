package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ConfiguracionItemsxTipoHistoriaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ConfiguracionItemsxTipoHistoriaDAOImpl.class */
public class ConfiguracionItemsxTipoHistoriaDAOImpl implements ConfiguracionItemsxTipoHistoriaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO
    public List<Object[]> mListar(String xIdTipoHistoria, String filtrar) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ConfiguracionItemsxTipoHistoriaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("id")), rs.getString("nombre"), Integer.valueOf(rs.getInt("Orden")), rs.getString("Grabado")};
                return fila;
            }
        };
        String xSql = "SELECT\n    h_configuracion_items.`id`\n    , h_configuracion_items.`nombre`\n    , IF(IFNULL(e.`orden`,-1)<>-1,e.`orden`, h_configuracion_items.`numeroOrden`) Orden\n    , IF(e.dato=1,'ACTIVO',IF(e.dato=0,'DESACTIVADO','SIN GRABAR')) AS Grabado\nFROM\n    `h_configuracion_items`\n    LEFT JOIN (SELECT\n    h_configuracion_items_tipohistoria.`idConfiguracion`,\n    h_configuracion_items_tipohistoria.`orden`,\n    h_configuracion_items_tipohistoria.`Estado` AS dato\nFROM\n    `h_configuracion_items_tipohistoria`\nWHERE (`idTipoHistoria` ='" + xIdTipoHistoria + "')) e ON (e.idConfiguracion=h_configuracion_items.`id`)\nWHERE (h_configuracion_items.nombre LIKE '%" + filtrar + "%' AND h_configuracion_items.`estado` =1)\nORDER BY Grabado ASC, Orden ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO
    public List<GCGenericoDTO> listaTipoHistoria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ConfiguracionItemsxTipoHistoriaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `h_tipohistoria` WHERE (`Estado` = 0 AND `Forma` = 1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO
    public String mCreate(ConfiguracionItemsxTipoHistoriaDTO xconfiguracion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO `h_configuracion_items_tipohistoria` (`idConfiguracion`,`idTipoHistoria`,`orden`,`Estado`)\nVALUES(?,?,?,?);", new Object[]{xconfiguracion.getIdConfiguracion(), xconfiguracion.getIdTipoHistoria(), Integer.valueOf(xconfiguracion.getOrden()), Integer.valueOf(xconfiguracion.getEstado())});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO
    public String mUpdate(ConfiguracionItemsxTipoHistoriaDTO xconfiguracion) {
        String sql = "UPDATE `h_configuracion_items_tipohistoria` SET    `orden` = ?,   `Estado` = ? WHERE `idConfiguracion` = ? and `idTipoHistoria`=?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xconfiguracion.getOrden()), Integer.valueOf(xconfiguracion.getEstado()), xconfiguracion.getIdConfiguracion(), xconfiguracion.getIdTipoHistoria()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
