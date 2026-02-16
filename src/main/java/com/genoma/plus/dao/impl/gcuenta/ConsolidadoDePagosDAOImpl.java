package com.genoma.plus.dao.impl.gcuenta;

import com.genoma.plus.dto.gcuenta.ConsolidadoDePagosDTO;
import com.genoma.plus.jpa.gcuenta.ConsolidadoDePagosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/gcuenta/ConsolidadoDePagosDAOImpl.class */
public class ConsolidadoDePagosDAOImpl implements ConsolidadoDePagosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Object[]> mBuscar(ConsolidadoDePagosDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.gcuenta.ConsolidadoDePagosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), Double.valueOf(rs.getDouble(7)), rs.getString(8), rs.getString(9), Long.valueOf(rs.getLong(10)), Long.valueOf(rs.getLong(11)), rs.getString(12), rs.getString(13)};
                return fila;
            }
        };
        String empresa = "";
        String estado = "";
        if (!dto.getEmpresa().isEmpty()) {
            empresa = " AND `cc_terceros`.`Id` = '" + dto.getEmpresa() + "' \n";
        }
        if (dto.getEstado().equals("1")) {
            estado = " AND f_factura_pagos.`Estado`IN (1) ";
        } else if (dto.getEstado().equals("0")) {
            estado = " AND f_factura_pagos.`Estado`IN (0) ";
        }
        String sql = " SELECT\n   CONCAT(`f_factura_evento`.`Prefijo`, '',`f_factura_evento`.`No_FacturaEvento_M`) numeroFactura\n    , `f_factura_evento`.`Fecha_FacturaEvento`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `cc_terceros`.`RazonSocialCompleta` AS `empresa`\n    , `f_factura_pagos`.`FechaAbono` fechaPago\n    , `f_tipoconcepto_pago`.`Nbre` AS `conceptoPago`\n    , `f_factura_pagos`.`Valor`\n    , `cc_periodo_contable`.`Nbre`\n    , `f_factura_pagos`.`Observacion`\n    , `f_factura_pagos`.`Id_DContable`\n    , `f_factura_pagos`.`Id_DPresupuesto`\n    , f_tiporegimen.Nbre AS regimen\n    , IFNULL(pp_detalle_movimiento.Id_Rubro, '') idRubro\nFROM\n    `baseserver`.`f_factura_pagos`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)\n    INNER JOIN `baseserver`.`cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`cc_periodo_contable` \n        ON (`f_factura_pagos`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)\n    INNER JOIN `baseserver`.`f_tipoconcepto_pago` \n        ON (`f_factura_pagos`.`Id_ConceptoPago` = `f_tipoconcepto_pago`.`Id`)\n    INNER JOIN `baseserver`.f_tiporegimen\n        ON (`f_empresacontxconvenio`.Id_TipoRegimen= `f_tiporegimen`.`Id`)  \n    LEFT JOIN pp_detalle_movimiento  \n\t     ON  (pp_detalle_movimiento.Id_Movimiento=`f_factura_pagos`.`Id_DPresupuesto`)\n WHERE ( `f_factura_pagos`.`FechaAbono` BETWEEN '" + dto.getFechaI() + "' AND  '" + dto.getFechaF() + "'\n" + empresa + estado + " );";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    public List<Object[]> mCargarCombo(ConsolidadoDePagosDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.gcuenta.ConsolidadoDePagosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        if (!dto.getEstado().equals("1") && dto.getEstado().equals("1")) {
        }
        List<Object[]> list = this.jdbcTemplate.query(" SELECT\n      `cc_terceros`.`Id`\n    , `cc_terceros`.`RazonSocialCompleta` AS `empresa`\nFROM\n    `baseserver`.`f_factura_pagos`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)\n    INNER JOIN `baseserver`.`cc_terceros` \n        ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`cc_periodo_contable` \n        ON (`f_factura_pagos`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)\n    INNER JOIN `baseserver`.`f_tipoconcepto_pago` \n        ON (`f_factura_pagos`.`Id_ConceptoPago` = `f_tipoconcepto_pago`.`Id`)\nWHERE ( `f_factura_pagos`.`FechaAbono` BETWEEN '2020-01-01' AND  '2020-01-31'\n )\nGROUP BY `cc_terceros`.`Id` ASC;", mapper);
        return list;
    }
}
