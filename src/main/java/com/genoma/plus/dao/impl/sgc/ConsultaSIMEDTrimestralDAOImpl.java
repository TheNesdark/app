package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import com.genoma.plus.dao.sgc.ConsultaSIMEDTrimestralDAO;
import com.genoma.plus.dto.sgc.ConsultaSIMEDTrimestralDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/ConsultaSIMEDTrimestralDAOImpl.class */
public class ConsultaSIMEDTrimestralDAOImpl implements ConsultaSIMEDTrimestralDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.ConsultaSIMEDTrimestralDAO
    public List<Object[]> mBuscarComprasPorPeriodo(ConsultaSIMEDTrimestralDTO dtoConsultaSIMEDTrimestral) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultaSIMEDTrimestralDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20)};
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
            sql = "WITH DESPACHOS AS\n(SELECT\n  '2' AS TR,\n  @rownum := @rownum + 1 AS contador,\n  SUBSTRING(g_ips.CodigoOrganismo,1,CHAR_LENGTH(g_ips.CodigoOrganismo) - 2) AS CHabilitacion,\n  DATE_FORMAT(ingreso.FechaIngreso, '%c') AS Fecha,\n  '2' AS RolActor,\n  'VN' AS TOperacion,\n  '05' AS TTransaccion,\n  0 AS IUM_Inivel,\n  0 AS IUM_IInivel,\n  0 AS IUM_IIIInivel,\n  SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1) AS CodigoCUM,\n  CASE\n    WHEN LENGTH(i_suministro.CodigoCUM) = LENGTH(\n      SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n    )\n    THEN '1'\n    ELSE SUBSTRING(\n      CodigoCUM,\n      LENGTH(\n        SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n      ) + 2\n    )\n  END AS Nconsecutivo,\n  'C' AS UFacturaMed,\n  ROUND(MIN(f_itemordenessum.ValorUnit),2) AS vlr_minimo,\n  ROUND(MAX(f_itemordenessum.ValorUnit),2) AS vlr_maximo,\n  ROUND(SUM(\n    cantidad * f_itemordenessum.ValorUnit\n  ),2) AS Vlr_total,\n  SUM(f_itemordenessum.Cantidad) AS cantidad,\n  CONCAT('V000000', MIN(ingreso.Id)) AS facturaPminimo,\n  CONCAT('V000000', MAX(ingreso.Id)) AS facturaPmaxmo,\n  i_suministro.Nbre\nFROM\n  (SELECT\n    @rownum := 0) r,\n  baseserver.f_ordenes\n  INNER JOIN baseserver.ingreso\n    ON (\n      f_ordenes.Id_Ingreso = ingreso.Id\n    )\n  INNER JOIN baseserver.g_sedes\n    ON (ingreso.Id_Sede = g_sedes.Id)\n  INNER JOIN baseserver.g_ips\n    ON (g_sedes.Id_Ips = g_ips.Id)\n  INNER JOIN baseserver.f_itemordenessum\n    ON (\n      f_itemordenessum.Id_Ordenes = f_ordenes.Id\n    )\n  INNER JOIN baseserver.i_suministro\n    ON (\n      f_itemordenessum.Id_Suministro = i_suministro.Id\n    )\n  INNER JOIN baseserver.f_liquidacion\n    ON (\n      f_liquidacion.Id_Ingreso = ingreso.Id\n    )\n  LEFT JOIN baseserver.f_factura_evento\n    ON (\n      f_factura_evento.Id_Liquidacion = f_liquidacion.Id\n    )\nWHERE (\n    f_ordenes.Id_TipoServicio = 7\n    AND i_suministro.IdTipoProducto IN (1, 7, 8, 10)\n    AND ingreso.FechaIngreso >= '" + dtoConsultaSIMEDTrimestral.getFechaInicial() + "'\n    AND ingreso.FechaIngreso <= '" + dtoConsultaSIMEDTrimestral.getFechaFinal() + "'\n  )\nGROUP BY DATE_FORMAT(ingreso.FechaIngreso, '%c'),\n  i_suministro.CodigoCUM\nORDER BY contador ASC),\nCOMPRAS AS\n(SELECT\n  '2' AS RT,\n  @rownum1 := @rownum1 + 1 AS contador,\n  SUBSTRING(g_ips.CodigoOrganismo,1,CHAR_LENGTH(g_ips.CodigoOrganismo) - 2) AS CHabilitacion,\n  DATE_FORMAT(i_entradas.FechaEntrada, '%c') AS Fecha,\n  '2' AS RolActor,\n  'CM' AS TOperacion,\n  '05' AS TTransaccion,\n  0 AS IUM_Inivel,\n  0 AS IUM_IInivel,\n  0 AS IUM_IIIInivel,\n  SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1) AS CodigoCUM,\n  CASE\n    WHEN LENGTH(i_suministro.CodigoCUM) = LENGTH(\n      SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n    )\n    THEN '1'\n    ELSE SUBSTRING(\n      CodigoCUM,\n      LENGTH(\n        SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n      ) + 2\n    )\n  END AS Nconsecutivo,\n  'C' AS UFacturaMed,\n  ROUND(MIN(i_detalleentrada.ValorUnitario),2) AS vlr_minimo,\n  ROUND(MAX(i_detalleentrada.ValorUnitario),2) AS vlr_maximo,\n  ROUND(SUM(\n    cantidad * i_detalleentrada.ValorUnitario\n  ),2) AS Vlr_total,\n  SUM(i_detalleentrada.Cantidad) AS cantidad,\n  CONCAT('CEF00000', MIN(i_entradas.Id)) AS entradaMin,\n  CONCAT('CEF00000', MAX(i_entradas.Id)) AS entradaMax,\n  i_suministro.Nbre\nFROM\n  baseserver.g_ips,\n  (SELECT\n    @rownum1 := 0) r,\n  baseserver.i_detalleentrada\n  INNER JOIN baseserver.i_entradas\n    ON (\n      i_detalleentrada.IdEntrada = i_entradas.Id\n    )\n  INNER JOIN baseserver.i_suministro\n    ON (\n      i_detalleentrada.IdSuministro = i_suministro.Id\n    )\nWHERE (\n    i_suministro.IdTipoProducto IN (1, 7, 8, 10)\n    AND i_entradas.FechaEntrada >= '" + dtoConsultaSIMEDTrimestral.getFechaInicial() + "'\n    AND i_entradas.FechaEntrada <= '" + dtoConsultaSIMEDTrimestral.getFechaFinal() + "'\n  )\nGROUP BY DATE_FORMAT(i_entradas.FechaEntrada, '%c'),\n  i_suministro.CodigoCUM\nORDER BY contador ASC)\nSELECT\n  *\nFROM\n  DESPACHOS\nUNION\nALL\nSELECT\n  *\nFROM\n  COMPRAS";
        } else {
            sql = "WITH DESPACHOS AS\n(SELECT\n  '2' AS TR,\n  @rownum := @rownum + 1 AS contador,\n  SUBSTRING(g_ips.CodigoOrganismo,1,CHAR_LENGTH(g_ips.CodigoOrganismo) - 2) AS CHabilitacion,\n  DATE_FORMAT(ingreso.FechaIngreso, '%m') AS Fecha,\n  '2' AS RolActor,\n  'VN' AS TOperacion,\n  '05' AS TTransaccion,\n  0 AS IUM_Inivel,\n  0 AS IUM_IInivel,\n  0 AS IUM_IIIInivel,\n  SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1) AS CodigoCUM,\n  CASE\n    WHEN LENGTH(i_suministro.CodigoCUM) = LENGTH(\n      SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n    )\n    THEN '1'\n    ELSE SUBSTRING(\n      CodigoCUM,\n      LENGTH(\n        SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n      ) + 2\n    )\n  END AS Nconsecutivo,\n  'C' AS UFacturaMed,\n  ROUND(MIN(f_itemordenessum.ValorUnit),2) AS vlr_minimo,\n  ROUND(MAX(f_itemordenessum.ValorUnit),2) AS vlr_maximo,\n  ROUND(SUM(\n    cantidad * f_itemordenessum.ValorUnit\n  ),2) AS Vlr_total,\n  SUM(f_itemordenessum.Cantidad) AS cantidad,\n  CONCAT('V000000', MIN(ingreso.Id)) AS facturaPminimo,\n  CONCAT('V000000', MAX(ingreso.Id)) AS facturaPmaxmo,\n  i_suministro.Nbre\nFROM\n  (SELECT\n    @rownum := 0) r,\n  baseserver.f_ordenes\n  INNER JOIN baseserver.ingreso\n    ON (\n      f_ordenes.Id_Ingreso = ingreso.Id\n    )\n  INNER JOIN baseserver.g_sedes\n    ON (ingreso.Id_Sede = g_sedes.Id)\n  INNER JOIN baseserver.g_ips\n    ON (g_sedes.Id_Ips = g_ips.Id)\n  INNER JOIN baseserver.f_itemordenessum\n    ON (\n      f_itemordenessum.Id_Ordenes = f_ordenes.Id\n    )\n  INNER JOIN baseserver.i_suministro\n    ON (\n      f_itemordenessum.Id_Suministro = i_suministro.Id\n    )\n  INNER JOIN baseserver.f_liquidacion\n    ON (\n      f_liquidacion.Id_Ingreso = ingreso.Id\n    )\n  LEFT JOIN baseserver.f_factura_evento\n    ON (\n      f_factura_evento.Id_Liquidacion = f_liquidacion.Id\n    )\nWHERE (\n    f_ordenes.Id_TipoServicio = 7\n    AND i_suministro.IdTipoProducto IN (1, 7, 8, 10)\n    AND ingreso.FechaIngreso >= '" + dtoConsultaSIMEDTrimestral.getFechaInicial() + "'\n    AND ingreso.FechaIngreso <= '" + dtoConsultaSIMEDTrimestral.getFechaFinal() + "'\n  )\nGROUP BY DATE_FORMAT(ingreso.FechaIngreso, '%m'),\n  i_suministro.CodigoCUM\nORDER BY contador ASC),\nCOMPRAS AS\n(SELECT\n  '2' AS RT,\n  @rownum1 := @rownum1 + 1 AS contador,\n  g_ips.CodigoOrganismo AS CHabilitacion,\n  DATE_FORMAT(i_entradas.FechaEntrada, '%m') AS Fecha,\n  '2' AS RolActor,\n  'CM' AS TOperacion,\n  '05' AS TTransaccion,\n  0 AS IUM_Inivel,\n  0 AS IUM_IInivel,\n  0 AS IUM_IIIInivel,\n  SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1) AS CodigoCUM,\n  CASE\n    WHEN LENGTH(i_suministro.CodigoCUM) = LENGTH(\n      SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n    )\n    THEN '1'\n    ELSE SUBSTRING(\n      CodigoCUM,\n      LENGTH(\n        SUBSTRING_INDEX(i_suministro.CodigoCUM, \"-\", 1)\n      ) + 2\n    )\n  END AS Nconsecutivo,\n  'C' AS UFacturaMed,\n  ROUND(MIN(i_detalleentrada.ValorUnitario),2) AS vlr_minimo,\n  ROUND(MAX(i_detalleentrada.ValorUnitario),2) AS vlr_maximo,\n  ROUND(SUM(\n    cantidad * i_detalleentrada.ValorUnitario\n  ),2) AS Vlr_total,\n  SUM(i_detalleentrada.Cantidad) AS cantidad,\n  CONCAT('CEF00000', MIN(i_entradas.Id)) AS entradaMin,\n  CONCAT('CEF00000', MAX(i_entradas.Id)) AS entradaMax,\n  i_suministro.Nbre\nFROM\n  baseserver.g_ips,\n  (SELECT\n    @rownum1 := 0) r,\n  baseserver.i_detalleentrada\n  INNER JOIN baseserver.i_entradas\n    ON (\n      i_detalleentrada.IdEntrada = i_entradas.Id\n    )\n  INNER JOIN baseserver.i_suministro\n    ON (\n      i_detalleentrada.IdSuministro = i_suministro.Id\n    )\nWHERE (\n    i_suministro.IdTipoProducto IN (1, 7, 8, 10)\n    AND i_entradas.FechaEntrada >= '" + dtoConsultaSIMEDTrimestral.getFechaInicial() + "'\n    AND i_entradas.FechaEntrada <= '" + dtoConsultaSIMEDTrimestral.getFechaFinal() + "'\n  )\nGROUP BY DATE_FORMAT(i_entradas.FechaEntrada, '%m'),\n  i_suministro.CodigoCUM\nORDER BY contador ASC)\nSELECT\n  *\nFROM\n  DESPACHOS\nUNION\nALL\nSELECT\n  *\nFROM\n  COMPRAS";
        }
        System.err.println("sql" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultaSIMEDTrimestralDAO
    public List<Object[]> mBuscarIps() {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultaSIMEDTrimestralDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[13];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
            sql = "SELECT Id_TipoIdentificacion, Identificacion, DigitoVerificacion FROM g_ips";
        } else {
            sql = "SELECT Id_TipoIdentificacion, LPAD(Identificacion,12, '0') as Identificacion, DigitoVerificacion FROM g_ips";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
