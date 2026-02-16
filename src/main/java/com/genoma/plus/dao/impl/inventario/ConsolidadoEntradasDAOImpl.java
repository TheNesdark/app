package com.genoma.plus.dao.impl.inventario;

import Acceso.Principal;
import com.genoma.plus.dao.inventario.ConsolidadoEntradasDAO;
import com.genoma.plus.dto.inventario.ConsolidadoEntradasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/ConsolidadoEntradasDAOImpl.class */
public class ConsolidadoEntradasDAOImpl implements ConsolidadoEntradasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.ConsolidadoEntradasDAO
    public List<ConsolidadoEntradasDTO> listaConsolidadoEntradas(String xFechaI, String xFechaF, int opc) {
        String xsql = "";
        switch (opc) {
            case 0:
                xsql = "SELECT\n    `i_entradas`.`Id`\n    , `i_entradas`.`FechaEntrada`\n    , `i_entradas`.`NoFactura`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimiento`\n    , `i_bodegas`.`Nbre` AS `NBodega`\n    ,  IF(`i_entradas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_entradas`.`Id_DocContable`\n    , `i_entradas`.`Observacion`\n    , `i_suministro`.`Id` AS IdSuministros\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_presentacioncomercial`.`Nbre` AS `NPComercial`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_detalleentrada`.`Cantidad`\n    , `i_detalleentrada`.`ValorUnitario`\n    , `i_detalleentrada`.`Iva`\n    , `i_detalleentrada`.`VFletesO`\n    , `i_detalleentrada`.`VDescuento`\n    , `i_detalleentrada`.`Lote`\n    , `i_detalleentrada`.`FechaVencimiento`\n    , `i_entradas`.`Fecha` fechaRegistro\n    , `i_entradas`.`UsuarioS` usuarioRegistro\nFROM\n    `cc_terceros`\n    LEFT JOIN `i_entradas` \n        ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_bodegas` \n        ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN `i_detalleentrada` \n        ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\nWHERE (`i_entradas`.`FechaEntrada` >='" + xFechaI + "'\n    AND `i_entradas`.`FechaEntrada` <='" + xFechaF + "'\n    AND `i_entradas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "');";
                break;
            case 1:
                xsql = "SELECT\n    `i_entradas`.`Id`\n    , `i_entradas`.`FechaEntrada`\n    , `i_entradas`.`NoFactura`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimiento`\n    , `i_bodegas`.`Nbre` AS `NBodega`\n    ,  IF(`i_entradas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_entradas`.`Id_DocContable`\n    , `i_entradas`.`Observacion`\n    , `i_suministro`.`Id` AS IdSuministros\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_presentacioncomercial`.`Nbre` AS `NPComercial`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_detalleentrada`.`Cantidad`\n    , `i_detalleentrada`.`ValorUnitario`\n    , `i_detalleentrada`.`Iva`\n    , `i_detalleentrada`.`VFletesO`\n    , `i_detalleentrada`.`VDescuento`\n    , `i_detalleentrada`.`Lote`\n    , `i_detalleentrada`.`FechaVencimiento`\n    , `i_entradas`.`Fecha` fechaRegistro\n    , `i_entradas`.`UsuarioS` usuarioRegistro\nFROM\n    `cc_terceros`\n    LEFT JOIN `i_entradas` \n        ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_bodegas` \n        ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN `i_detalleentrada` \n        ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\nWHERE (`i_entradas`.`FechaEntrada` >='" + xFechaI + "'\n    AND `i_entradas`.`FechaEntrada` <='" + xFechaF + "'\n    AND `i_entradas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND `i_entradas`.`Estado`=0);";
                break;
            case 2:
                xsql = "SELECT\n    `i_entradas`.`Id`\n    , `i_entradas`.`FechaEntrada`\n    , `i_entradas`.`NoFactura`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimiento`\n    , `i_bodegas`.`Nbre` AS `NBodega`\n    ,  IF(`i_entradas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_entradas`.`Id_DocContable`\n    , `i_entradas`.`Observacion`\n    , `i_suministro`.`Id` AS IdSuministros\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_presentacioncomercial`.`Nbre` AS `NPComercial`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_detalleentrada`.`Cantidad`\n    , `i_detalleentrada`.`ValorUnitario`\n    , `i_detalleentrada`.`Iva`\n    , `i_detalleentrada`.`VFletesO`\n    , `i_detalleentrada`.`VDescuento`\n    , `i_detalleentrada`.`Lote`\n    , `i_detalleentrada`.`FechaVencimiento`\n    , `i_entradas`.`Fecha` fechaRegistro\n    , `i_entradas`.`UsuarioS` usuarioRegistro\nFROM\n    `cc_terceros`\n    LEFT JOIN `i_entradas` \n        ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_bodegas` \n        ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN `i_detalleentrada` \n        ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detalleentrada`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\nWHERE (`i_entradas`.`FechaEntrada` >='" + xFechaI + "'\n    AND `i_entradas`.`FechaEntrada` <='" + xFechaF + "'\n    AND `i_entradas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND `i_entradas`.`Estado`=1);";
                break;
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.ConsolidadoEntradasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsolidadoEntradasDTO g = new ConsolidadoEntradasDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setFechaEntrada(rs.getString("FechaEntrada"));
                g.setNoFactura(rs.getString("NoFactura"));
                g.setTercero(rs.getString("RazonSocialCompleta"));
                g.setNTipoMovimiento(rs.getString("NTipoMovimiento"));
                g.setNBodega(rs.getString("NBodega"));
                g.setEstado(rs.getString("Estado"));
                g.setIdDocContable(Long.valueOf(rs.getLong("Id_DocContable")));
                g.setObservacion(rs.getString("Observacion"));
                g.setIdSuministros(Long.valueOf(rs.getLong("IdSuministros")));
                g.setNProducto(rs.getString("NProducto"));
                g.setNPresentacionComercial(rs.getString("NPComercial"));
                g.setNPActivo(rs.getString("NPActivo"));
                g.setNTipoProducto(rs.getString("NTipoProducto"));
                g.setNCategoria(rs.getString("NCategoria"));
                g.setCantidad(rs.getInt("Cantidad"));
                g.setVUnitario(Double.valueOf(rs.getDouble("ValorUnitario")));
                g.setIva(Double.valueOf(rs.getDouble("Iva")));
                g.setVFletesO(Double.valueOf(rs.getDouble("VFletesO")));
                g.setVDescuento(Double.valueOf(rs.getDouble("VDescuento")));
                g.setLote(rs.getString("Lote"));
                g.setFechaVencimiento(rs.getString("FechaVencimiento"));
                g.setFechaRegistro(rs.getString("fechaRegistro"));
                g.setUsuarioRegistro(rs.getString("usuarioRegistro"));
                return g;
            }
        };
        List<ConsolidadoEntradasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
