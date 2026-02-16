package com.genoma.plus.dao.impl.facturacion;

import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO;
import com.genoma.plus.dto.facturacion.itemsOrdenDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/LiquidacionOrdenesServiciosDAOImpl.class */
public class LiquidacionOrdenesServiciosDAOImpl implements LiquidacionOrdenesServicioDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public List<Object[]> listadoDetalleOrdenesServiciosIngreso(Long idIngreso, String fecha, Boolean filtro, String nombreItems) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("idOrden")), rs.getString("nombreServicio"), rs.getString("fechaHora"), rs.getString("nombreItems"), Boolean.valueOf(rs.getBoolean("seleccion")), Boolean.valueOf(rs.getBoolean("esCobrable")), Integer.valueOf(rs.getInt("plan")), rs.getString("numeroAutorizacion"), Long.valueOf(rs.getLong("cantidad")), Double.valueOf(rs.getDouble("valorUnitario")), Double.valueOf(rs.getDouble("valorDescuento")), Double.valueOf(rs.getDouble("porcentajeImpuesto")), Double.valueOf(rs.getDouble("valorImpuesto")), Long.valueOf(rs.getLong("idSuminsitroProcedimiento")), Integer.valueOf(rs.getInt("TipoServicio")), Integer.valueOf(rs.getInt("idItems"))};
                return fila;
            }
        };
        if (filtro.booleanValue()) {
            xSql = "SELECT FALSE AS seleccion, \n    `f_ordenes`.`Id` idOrden\n    , `f_tiposervicio`.`Nbre` AS `nombreServicio`\n    , CONCAT(`f_ordenes`.`FechaOrden` ,' ', `f_ordenes`.`HoraOrden`) fechaHora\n    , IF(`g_procedimiento`.`Nbre` IS NULL , IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)), `g_procedimiento`.`Nbre` ) AS nombreItems\n, IF(f_itemordenesproced.`EsCobrable` IS NULL , `f_itemordenessum`.`EsCobrable`, f_itemordenesproced.`EsCobrable`) esCobrable  \n , IF(f_itemordenesproced.`Plan` IS NULL, `f_itemordenessum`.`Plan`, f_itemordenesproced.`Plan`) plan\n    , IF(f_itemordenesproced.`NAutorizacion` IS NULL, `f_itemordenessum`.`NAutorizacion`, f_itemordenesproced.`NAutorizacion`) numeroAutorizacion  \n    , IF(f_itemordenesproced.`Cantidad` IS NULL, `f_itemordenessum`.`Cantidad`,f_itemordenesproced.`Cantidad`) cantidad\n    , IF(f_itemordenesproced.`ValorUnitario` IS NULL, `f_itemordenessum`.`ValorUnit`, f_itemordenesproced.`ValorUnitario` ) valorUnitario\n    , IF(f_itemordenesproced.`ValorDescuento` IS NULL, `f_itemordenessum`.`valorDesc`, f_itemordenesproced.`ValorDescuento`) valorDescuento\n    , IF(f_itemordenesproced.`porcentajeImpuesto` IS NULL,`f_itemordenessum`.`porcentajeImpuesto`, f_itemordenesproced.`porcentajeImpuesto`)porcentajeImpuesto\n    , IF(f_itemordenesproced.`valorImpuesto` IS NULL, `f_itemordenessum`.`valorImpuesto`, f_itemordenesproced.`valorImpuesto`)valorImpuesto       \n    , IF(f_itemordenesproced.`Id_Procedimiento` IS NULL, f_itemordenessum.`Id_Suministro`, f_itemordenesproced.`Id_Procedimiento`) idSuminsitroProcedimiento \n    , f_tiposervicio.`TipoServicio`    , IF(f_itemordenesproced.`Id_Procedimiento` IS NULL, f_itemordenessum.`Id_Ordenes`, f_itemordenesproced.`Id`) idItems \nFROM\n     `f_ordenes`\n    INNER JOIN  `f_tiposervicio` \n        ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)            \n    LEFT JOIN  `f_itemordenessum` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    LEFT JOIN  `i_suministro` \n        ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    LEFT JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    LEFT JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    LEFT JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    LEFT JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    LEFT JOIN  `i_formafarmaceutica` \n        ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n    LEFT JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    LEFT JOIN  `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (IF(`g_procedimiento`.`Nbre` IS NULL , IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)), `g_procedimiento`.`Nbre` ) like'%" + nombreItems + "%' and  `f_ordenes`.`Id_Ingreso` =" + idIngreso + " AND f_ordenes.`Estado`=0 AND f_tiposervicio.`TipoServicio`<>4)\nORDER BY `f_ordenes`.`FechaOrden` DESC, `f_ordenes`.`Id` ASC";
        } else {
            xSql = "SELECT FALSE AS seleccion, \n    `f_ordenes`.`Id` idOrden\n    , `f_tiposervicio`.`Nbre` AS `nombreServicio`\n    , CONCAT(`f_ordenes`.`FechaOrden` ,' ', `f_ordenes`.`HoraOrden`) fechaHora\n    , IF(`g_procedimiento`.`Nbre` IS NULL , IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)), `g_procedimiento`.`Nbre` ) AS nombreItems\n, IF(f_itemordenesproced.`EsCobrable` IS NULL , `f_itemordenessum`.`EsCobrable`, f_itemordenesproced.`EsCobrable`) esCobrable  \n , IF(f_itemordenesproced.`Plan` IS NULL, `f_itemordenessum`.`Plan`, f_itemordenesproced.`Plan`) plan\n    , IF(f_itemordenesproced.`NAutorizacion` IS NULL, `f_itemordenessum`.`NAutorizacion`, f_itemordenesproced.`NAutorizacion`) numeroAutorizacion  \n    , IF(f_itemordenesproced.`Cantidad` IS NULL, `f_itemordenessum`.`Cantidad`,f_itemordenesproced.`Cantidad`) cantidad\n    , IF(f_itemordenesproced.`ValorUnitario` IS NULL, `f_itemordenessum`.`ValorUnit`, f_itemordenesproced.`ValorUnitario` ) valorUnitario\n    , IF(f_itemordenesproced.`ValorDescuento` IS NULL, `f_itemordenessum`.`valorDesc`, f_itemordenesproced.`ValorDescuento`) valorDescuento\n    , IF(f_itemordenesproced.`porcentajeImpuesto` IS NULL,`f_itemordenessum`.`porcentajeImpuesto`, f_itemordenesproced.`porcentajeImpuesto`)porcentajeImpuesto\n    , IF(f_itemordenesproced.`valorImpuesto` IS NULL, `f_itemordenessum`.`valorImpuesto`, f_itemordenesproced.`valorImpuesto`)valorImpuesto       \n    , IF(f_itemordenesproced.`Id_Procedimiento` IS NULL, f_itemordenessum.`Id_Suministro`, f_itemordenesproced.`Id_Procedimiento`) idSuminsitroProcedimiento \n    , f_tiposervicio.`TipoServicio`    , IF(f_itemordenesproced.`Id_Procedimiento` IS NULL, f_itemordenessum.`Id_Ordenes`, f_itemordenesproced.`Id`) idItems \nFROM\n     `f_ordenes`\n    INNER JOIN  `f_tiposervicio` \n        ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)            \n    LEFT JOIN  `f_itemordenessum` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    LEFT JOIN  `i_suministro` \n        ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    LEFT JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    LEFT JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    LEFT JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    LEFT JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    LEFT JOIN  `i_formafarmaceutica` \n        ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n    LEFT JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    LEFT JOIN  `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (IF(`g_procedimiento`.`Nbre` IS NULL , IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)), `g_procedimiento`.`Nbre` ) like'%" + nombreItems + "%' and `f_ordenes`.`Id_Ingreso` =" + idIngreso + " AND `f_ordenes`.`FechaOrden`='" + fecha + "' AND f_ordenes.`Estado`=0 AND f_tiposervicio.`TipoServicio`<>4)\nORDER BY `f_ordenes`.`FechaOrden` DESC, `f_ordenes`.`Id` ASC";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public void actualizar(itemsOrdenDTO e, Integer tabla) {
        String sql;
        if (tabla.intValue() == 0) {
            sql = "UPDATE  `f_itemordenessum` SET `Cantidad`=? , `ValorUnit`=? , `valorDesc`=? , `porcentajeImpuesto`=? , `valorImpuesto`=? , `EsCobrable`=? , `Plan`=? , `NAutorizacion`=?  WHERE (`Id_Ordenes` =? AND `Id_Suministro` =? )";
        } else {
            sql = "UPDATE  `f_itemordenesproced` SET `Cantidad`=? , `ValorUnitario`=? , `ValorDescuento`=? , `porcentajeImpuesto`=? , `valorImpuesto`=? , `EsCobrable`=? , `Plan`=? , `NAutorizacion`=?  WHERE (`Id_Ordenes` =? AND `Id_Procedimiento` =? )";
        }
        this.jdbcTemplate.update(sql, new Object[]{e.getCantidad(), e.getValorUnitario(), e.getValorDescuento(), e.getPorcentajeImpuesto(), e.getValorImpuesto(), e.getCobrable(), e.getPlan(), e.getNumeroAutorizacion(), e.getIdOrden(), e.getIdItemsOrden()});
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public void trasladarOrdenIngreso(Long idOrden, Long idIngreso) {
        String sql = "update f_ordenes set Id_Ingreso =" + idIngreso + " where Id=" + idOrden + "";
        this.jdbcTemplate.update(sql);
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public List<Object[]> listadoIngresoDestino(Long idIngresoOrigen, Long idUsuario) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("itemCombo")};
                return fila;
            }
        };
        String xSql = "SELECT\n    `ingreso`.`Id`\n    , CONCAT(`ingreso`.`Id`,'_',`ingreso`.`FechaIngreso`,'_',`f_empresacontxconvenio`.`Nbre`) itemCombo\nFROM\n     `ingreso` \n    LEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` =" + idUsuario + " and `ingreso`.`Id`<>" + idIngresoOrigen + " )\nGROUP BY  `ingreso`.`Id`\nORDER BY `ingreso`.`FechaIngreso` DESC ";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public void actualizarTotalOrden(itemsOrdenDTO e, Double totalValor, Double totalOrden) {
        this.jdbcTemplate.update("UPDATE\n  `baseserver`.`f_ordenes`\nSET\n `TotalOrdenes` = ?, \n  `TotalEPS` = ? ,\n  `TotalDescuento` = ?,\n  `Usuario_Reliquidacion` = ?,\n  `fecha_Reliquidacion` = ?,\n  `ValorAnterior` = ?\nWHERE `Id` = ?;", new Object[]{totalValor, totalValor, totalOrden, e.getUsuario_Reliquidacion(), e.getFecha_Reliquidacion(), "2000", e.getIdOrden()});
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public void actualizarTotalOrden(String idIngreso, String UsuarioLiquida) {
        System.err.println("sqlUPDATE `f_ordenes` , (\nWITH setDatos AS (\nSELECT\n   f_itemordenesproced.`Id`AS idOrdenItems,\n  `Id_Ordenes`,\n  SUM(`ValorUnitario`) AS valorNuevo,\n  `ValorDescuento`,\n  `porcentajeImpuesto`,\n  `valorImpuesto`\nFROM `f_itemordenesproced`\nINNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE EsCobrable=1 AND f_ordenes.`Id_Ingreso`=? GROUP BY Id_Ordenes\n), valorInicial AS (\nSELECT \n `Id_Ordenes` AS idOrden,\n  SUM(`ValorUnitario`) AS valorAnte\nFROM `f_itemordenesproced`\nINNER JOIN `f_ordenes` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE f_ordenes.`Id_Ingreso`=? GROUP BY Id_Ordenes\n)\nSELECT \nsetDatos.Id_Ordenes,\nsetDatos.valorNuevo,\nvalorInicial.valorAnte\nFROM setDatos\nINNER JOIN valorInicial ON setDatos.Id_Ordenes=valorInicial.idOrden\n) d SET  `TotalOrdenes` = d.valorNuevo,\n  `TotalEPS` = d.valorNuevo,\n  `Usuario_Reliquidacion` = ?,\n -- `Fecha_Reliquidacion` = ?,\n  `ValorAnterior` = d.valorAnte\nWHERE `Id` = d.Id_Ordenes;");
        this.jdbcTemplate.update("UPDATE `f_ordenes` , (\nWITH setDatos AS (\nSELECT\n   f_itemordenesproced.`Id`AS idOrdenItems,\n  `Id_Ordenes`,\n  SUM(`ValorUnitario`) AS valorNuevo,\n  `ValorDescuento`,\n  `porcentajeImpuesto`,\n  `valorImpuesto`\nFROM `f_itemordenesproced`\nINNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE EsCobrable=1 AND f_ordenes.`Id_Ingreso`=? GROUP BY Id_Ordenes\n), valorInicial AS (\nSELECT \n `Id_Ordenes` AS idOrden,\n  SUM(`ValorUnitario`) AS valorAnte\nFROM `f_itemordenesproced`\nINNER JOIN `f_ordenes` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE f_ordenes.`Id_Ingreso`=? GROUP BY Id_Ordenes\n)\nSELECT \nsetDatos.Id_Ordenes,\nsetDatos.valorNuevo,\nvalorInicial.valorAnte\nFROM setDatos\nINNER JOIN valorInicial ON setDatos.Id_Ordenes=valorInicial.idOrden\n) d SET  `TotalOrdenes` = d.valorNuevo,\n  `TotalEPS` = d.valorNuevo,\n  `Usuario_Reliquidacion` = ?,\n -- `Fecha_Reliquidacion` = ?,\n  `ValorAnterior` = d.valorAnte\nWHERE `Id` = d.Id_Ordenes;", new Object[]{idIngreso, idIngreso, UsuarioLiquida});
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public void actualizarNumeroAutorizacion(String nuAutroizacion, String idOrden) {
        String sql = "update\n  `baseserver`.`f_itemordenesproced`\nset\n  `NAutorizacion` ='" + nuAutroizacion + "'\nwhere  `Id_Ordenes` = '" + idOrden + "';";
        System.out.println("xsql-->" + sql);
        this.jdbcTemplate.update(sql);
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO
    public List<Object[]> listadoOrdenes(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), Long.valueOf(rs.getLong("Id_Ingreso"))};
                return fila;
            }
        };
        String xSql = "select\n  `Id` ,\n  `Id_Ingreso`\nfrom\n  `baseserver`.`f_ordenes`\nwhere f_ordenes.`Id_Ingreso`='" + idIngreso + "'";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
