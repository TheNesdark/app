package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO;
import com.genoma.plus.dto.historia.ValeReportePadresDetalleDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeReportePadresDetalleDAOImpl.class */
public class ValeReportePadresDetalleDAOImpl implements ValeReportePadresDetalleDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public List<Object[]> listaReportePadres(int idAtencion, int rangoGeneral, int rangovestibular) {
        String sql;
        if (idAtencion != 0) {
            sql = "SELECT\n `p_vale_reporte_padre_rangos`.`nombre` ,\n   `h_vale_reporte_padres_encabezado`.`id`,\n  `h_vale_reporte_padres_detalle`.`id`,\n  `p_vale_reporte_padre_rango_items`.`id`,\n  `p_vale_reporte_padre_rango_items`.`pregunta`,\n  `p_vale_reporte_padre_rango_items`.`instruccion`,\n  `p_vale_reporte_padre_rango_items`.`clasificacion`,\n  `p_vale_reporte_padre_rango_items`.`orden`,\n  IFNULL(\n    `h_vale_reporte_padres_detalle`.`respuesta`,\n    1\n  ) AS respuesta\nFROM\n  `baseserver`.`p_vale_reporte_padre_rango_items`\nINNER JOIN`p_vale_reporte_padre_rangos`ON (`p_vale_reporte_padre_rango_items`.`id_rango`= `p_vale_reporte_padre_rangos`.`id`)  LEFT JOIN `baseserver`.`h_vale_reporte_padres_detalle`\n    ON (\n      `p_vale_reporte_padre_rango_items`.`id` = `h_vale_reporte_padres_detalle`.`id_item`\n    )\n INNER JOIN `baseserver`.`h_vale_reporte_padres_encabezado`\n    ON (\n      `h_vale_reporte_padres_detalle`.`id_encabezado` = `h_vale_reporte_padres_encabezado`.`id`\n    )\n    AND (\n      `h_vale_reporte_padres_encabezado`.`id_atencion` = " + idAtencion + "\n    ) WHERE(p_vale_reporte_padre_rangos.`id` <= " + rangoGeneral + ")";
        } else {
            sql = "SELECT\n                     `p_vale_reporte_padre_rangos`.`nombre` ,\n                     0 AS  idEncabezado\n                    , 0 AS idDetalle\n                    , `p_vale_reporte_padre_rango_items`.`id`\n                    , `p_vale_reporte_padre_rango_items`.`pregunta`\n                    , `p_vale_reporte_padre_rango_items`.`instruccion`\n                    , `p_vale_reporte_padre_rango_items`.`clasificacion`\n                    , `p_vale_reporte_padre_rango_items`.`orden`\n                    , 1 AS respuesta\n                FROM\n                    `baseserver`.`p_vale_reporte_padre_rango_items`\nINNER JOIN`p_vale_reporte_padre_rangos`ON (`p_vale_reporte_padre_rango_items`.`id_rango`= `p_vale_reporte_padre_rangos`.`id`)                 WHERE(`p_vale_reporte_padre_rango_items`.`id_rango` <= " + rangoGeneral + "                   OR `p_vale_reporte_padre_rango_items`.`id_rango`= " + rangovestibular + " )\n                                        ;                    ";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresDetalleDAOImpl.1
            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Object[] fila = {rs.getString(1), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), Integer.valueOf(rs.getInt(4)), rs.getString(5), rs.getString(6), rs.getString(7), Integer.valueOf(rs.getInt(8)), Boolean.valueOf(rs.getBoolean(9))};
                return fila;
            }
        };
        List<Object[]> listaReportePadres = this.jdbcTemplate.query(sql, mapper);
        return listaReportePadres;
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public void create(ValeReportePadresDetalleDTO valeReportePadresDetalleDTO) {
        this.jdbcTemplate.update("INSERT INTO `h_vale_reporte_padres_detalle` (`id_encabezado`,`id_item`,`respuesta`,`estado`,`id_usuario`) \n      VALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(valeReportePadresDetalleDTO.getIdEncabezado()), Integer.valueOf(valeReportePadresDetalleDTO.getIdItem()), Boolean.valueOf(valeReportePadresDetalleDTO.isRespuesta()), Boolean.valueOf(valeReportePadresDetalleDTO.isEstado()), Long.valueOf(valeReportePadresDetalleDTO.getIdUsuario())});
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public void update(ValeReportePadresDetalleDTO valeReportePadresDetalleDTO) {
        this.jdbcTemplate.update("UPDATE `h_vale_reporte_padres_detalle` SET `id_item`=?,`respuesta`=?,`estado`=?,`id_usuario`=? WHERE `id`=?;", new Object[]{Integer.valueOf(valeReportePadresDetalleDTO.getIdItem()), Boolean.valueOf(valeReportePadresDetalleDTO.isRespuesta()), Boolean.valueOf(valeReportePadresDetalleDTO.isEstado()), Long.valueOf(valeReportePadresDetalleDTO.getIdUsuario()), Integer.valueOf(valeReportePadresDetalleDTO.getId())});
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public List<Object[]> listaDeReportesGuardados(int idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresDetalleDAOImpl.2
            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1))};
                return fila;
            }
        };
        List<Object[]> listaGuardados = this.jdbcTemplate.query("SELECT `id` FROM`h_vale_reporte_padres_encabezado` WHERE `id_atencion`=?", mapper);
        return listaGuardados;
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public List<Integer> buscarItemsPorRango(int edadEnDias) {
        String sql = "SELECT `id` FROM `p_vale_reporte_padre_rangos` WHERE ((`dias_inicio`<= " + edadEnDias + " AND `dias_fin`>= " + edadEnDias + ")AND `tipo`= 1);";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresDetalleDAOImpl.3
            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Integer fila = Integer.valueOf(rs.getInt(1));
                return fila;
            }
        };
        List<Integer> lista = this.jdbcTemplate.query(sql, mapper);
        if (lista.size() == 0) {
            lista.add(0);
        }
        System.out.println("el rango es " + lista.get(0).toString());
        return lista;
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO
    public List<Integer> buscarItemsVestibularPorRango(int edadEnDias) {
        String sql = "SELECT `id` FROM `p_vale_reporte_padre_rangos` WHERE ((`dias_inicio`<= " + edadEnDias + " AND `dias_fin`>= " + edadEnDias + ")AND `tipo`= 2);";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresDetalleDAOImpl.4
            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Integer fila = Integer.valueOf(rs.getInt(1));
                return fila;
            }
        };
        List<Integer> lista = this.jdbcTemplate.query(sql, mapper);
        if (lista.size() == 0) {
            lista.add(0);
        }
        System.out.println("el rango2 es " + lista.get(0).toString());
        return lista;
    }
}
