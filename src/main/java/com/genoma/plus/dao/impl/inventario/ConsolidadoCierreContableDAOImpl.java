package com.genoma.plus.dao.impl.inventario;

import com.genoma.plus.dao.inventario.ConsolidadoCierreContableDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/ConsolidadoCierreContableDAOImpl.class */
public class ConsolidadoCierreContableDAOImpl implements ConsolidadoCierreContableDAO {
    private JdbcTemplate jdbcTemplate;
    private String xsql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.ConsolidadoCierreContableDAO
    public List<Object[]> listBodegasDocContable(String fechaI, String fechaF, int opc) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.ConsolidadoCierreContableDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        if (opc == 0) {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre`\nFROM `i_salidas`  INNER JOIN `i_bodegas`   ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + fechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + fechaF + "'\n    AND `i_salidas`.`Estado` =0\n    AND `i_bodegas`.`Contabilidad` =1 and `i_salidas`.`Id_DocContable`=0)\nGROUP BY `i_bodegas`.`Id`\nORDER BY `i_bodegas`.`Nbre` ASC";
        } else {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre`\nFROM `i_entradas`  INNER JOIN `i_bodegas`   ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (`i_entradas`.`FechaEntrada`>='" + fechaI + "'\n    AND `i_entradas`.`FechaEntrada` <='" + fechaF + "'\n    AND `i_entradas`.`Estado` =0\n    AND `i_bodegas`.`Contabilidad` =1 AND i_entradas.`Id_DocContable`=0)\nGROUP BY `i_bodegas`.`Id`\nORDER BY `i_bodegas`.`Nbre` ASC";
        }
        List<Object[]> list = this.jdbcTemplate.query(this.xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.ConsolidadoCierreContableDAO
    public List<Object[]> listConsolidadoCierre(String fechaI, String fechaF, int opc, String idBodega) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.ConsolidadoCierreContableDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[5];
                fila[0] = Long.valueOf(rs.getLong(1));
                fila[1] = rs.getString(2);
                fila[2] = Double.valueOf(rs.getDouble(3));
                fila[3] = Long.valueOf(rs.getLong(4));
                return fila;
            }
        };
        if (opc == 0) {
            this.xsql = "SELECT i_tiposmovimientos.`Id`, i_tiposmovimientos.Nbre, ROUND(SUM((i_detallesalida.CantidadDespachada*i_detallesalida.ValorUnitario))) AS ValorConsolidado, i_salidas.Id_DocContable\nFROM i_salidas \nINNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) \nINNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id) \nWHERE (i_salidas.IdBodega ='" + idBodega + "'  AND i_salidas.Estado =0  \nAND i_salidas.FechaSalida >='" + fechaI + "' \nAND i_salidas.Id_DocContable<>0 AND i_salidas.FechaSalida <='" + fechaF + "') \nGROUP BY i_tiposmovimientos.Nbre , i_salidas.Id_DocContable\nORDER BY i_salidas.Id_DocContable ASC, i_tiposmovimientos.Nbre ASC ";
        } else {
            this.xsql = "SELECT i_tiposmovimientos.`Id`,  i_tiposmovimientos.Nbre, ROUND(SUM((i_detalleentrada.Cantidad*i_detalleentrada.ValorUnitario))) AS Valor, i_entradas.`Id_DocContable`\nFROM i_detalleentrada \nINNER JOIN i_entradas  ON (i_detalleentrada.IdEntrada = i_entradas.Id) \nINNER JOIN i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) \nWHERE (i_entradas.IdBodega ='" + idBodega + "' \n AND i_entradas.Estado =0 AND i_entradas.Id_DocContable <>0  \n  AND i_entradas.FechaEntrada >='" + fechaI + "' \n  AND i_entradas.FechaEntrada <='" + fechaF + "') \n  GROUP BY i_entradas.`Id_DocContable`, i_tiposmovimientos.`Id`\n  ORDER BY i_entradas.`Id_DocContable`ASC, i_tiposmovimientos.Nbre ASC";
        }
        List<Object[]> list = this.jdbcTemplate.query(this.xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.ConsolidadoCierreContableDAO
    public List<Object[]> listDetalleCierre(int opc, String idDocContable) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.ConsolidadoCierreContableDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                fila[0] = Long.valueOf(rs.getLong(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = Integer.valueOf(rs.getInt(9));
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                fila[11] = rs.getString(12);
                fila[12] = rs.getString(13);
                fila[13] = rs.getString(14);
                fila[14] = Integer.valueOf(rs.getInt(15));
                fila[15] = Integer.valueOf(rs.getInt(16));
                fila[16] = Integer.valueOf(rs.getInt(17));
                fila[17] = Double.valueOf(rs.getDouble(18));
                fila[18] = rs.getString(19);
                return fila;
            }
        };
        if (opc == 0) {
            this.xsql = "SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`FechaSalida`\n    , `i_tiposmovimientos`.`Nbre` AS `NMovimento`\n    , `i_bodegas`.`Nbre` AS `NBodega`\n    , `i_periodo`.`Nbre` AS `NPeriodo`\n    , IF(`Destino`.`Nbre` IS NULL, CONCAT(`g_persona`.`Apellido1` , ' ',`g_persona`.`Apellido2` , ' ',`g_persona`.`Nombre1`  , ' ',`g_persona`.`Nombre2`),`Destino`.`Nbre`)  AS `Destino`\n    , `i_salidas`.`OrdenH`\n    , `i_salidas`.`Observaciones`\n    , `i_salidas`.`Id_Ingreso`\n    , `i_salidas`.`Id_DocContable`\n    , `i_suministro`.`Id` AS `IdSuministro`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_detallesalida`.`Lote`\n    , `i_detallesalida`.`FechaVencimiento`\n    , `i_detallesalida`.`CantidadSolicitada`\n    , `i_detallesalida`.`CantidadDespachada`\n    , `i_detallesalida`.`ValorUnitario`\n    , (`i_detallesalida`.`ValorUnitario`*`i_detallesalida`.`CantidadDespachada`) AS `VTotal`\n    , IFNULL(`i_detallesalida`.`Observacion`, '')\nFROM\n    `baseserver`.`i_detallesalida`\n    INNER JOIN `baseserver`.`i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `baseserver`.`i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `baseserver`.`i_bodegas` \n        ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN `baseserver`.`i_periodo` \n        ON (`i_salidas`.`Id_Periodo` = `i_periodo`.`Id`)\n    LEFT JOIN `baseserver`.`i_bodegas` AS `Destino` \n        ON (`Destino`.`Id` = `i_salidas`.`Destino`)\n    LEFT JOIN `baseserver`.`g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\nWHERE (`i_salidas`.`Id_DocContable` =" + idDocContable + ");";
        } else {
            this.xsql = "SELECT\n    `i_entradas`.`Id`\n    , `i_entradas`.`FechaEntrada`\n    , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimento`\n    , `i_bodegas`.`Nbre` AS `NBodega`\n    , `i_periodo`.`Nbre` AS `NPeriodo`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `i_entradas`.`NoFactura`\n    , `i_detalleentrada`.`Acepta`\n    , `i_entradas`.`Id_DocContable`\n    , `i_suministro`.`Id` AS `IdSuministro`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_detalleentrada`.`Lote`\n    , `i_detalleentrada`.`FechaVencimiento`\n    , `i_detalleentrada`.`Cantidad`\n    , `i_detalleentrada`.`ValorUnitario`\n    , `i_detalleentrada`.`Iva`\n    , `i_detalleentrada`.`VFletesO`\n    , `i_detalleentrada`.`VDescuento`\n    , IFNULL(`i_detalleentrada`.`Observaciones`,' ')\nFROM\n     `i_detalleentrada`\n    INNER JOIN  `i_entradas` \n        ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)\n    LEFT JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)\n    INNER JOIN  `i_periodo` \n        ON (`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)\n    INNER JOIN  `i_tiposmovimientos` \n        ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN  `i_bodegas` \n        ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`)\nWHERE (`i_entradas`.`Id_DocContable` =" + idDocContable + ");";
        }
        List<Object[]> list = this.jdbcTemplate.query(this.xsql, mapper);
        return list;
    }
}
