package com.genoma.plus.dao.impl.contabilidad;

import Acceso.Principal;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dto.contabilidad.CTipoDocumentoDTO;
import com.genoma.plus.dto.contabilidad.ListadoRadicacionFacturaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/contabilidad/ContabilidadDAOImpl.class */
public class ContabilidadDAOImpl implements ContabilidadDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<CTipoDocumentoDTO> listTipoDocContable() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                CTipoDocumentoDTO g = new CTipoDocumentoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                g.setNReporte(rs.getString("NReporte"));
                g.setEstado(Integer.valueOf(rs.getInt("Estado")));
                g.setCodigo(rs.getString("CodigoC"));
                g.setEsContable(Integer.valueOf(rs.getInt("EsContable")));
                g.setEsAjuste(Integer.valueOf(rs.getInt("EsAjuste")));
                g.setEsVenta(Integer.valueOf(rs.getInt("EsVentas")));
                g.setIdDocumentoFirma(Long.valueOf(rs.getLong("Id_DocF")));
                g.setNConsecutivo(Long.valueOf(rs.getLong("NConsecutivo")));
                return g;
            }
        };
        List<CTipoDocumentoDTO> list = this.jdbcTemplate.query("SELECT `Id` , `Nbre` , `NReporte` , `CodigoC` , `EsContable`  , `EsAjuste` , `EsVentas`  , `Estado`   , `Id_DocF`  , `NConsecutivo` FROM  `cc_tipo_documentoc` ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<CTipoDocumentoDTO> listTipoDocContableId(String idTipo) {
        String xsql = "SELECT `Id` , `Nbre` , `NReporte` , `CodigoC` , `EsContable`  , `EsAjuste` , `EsVentas`  , `Estado`   , `Id_DocF`  , `NConsecutivo` FROM  `cc_tipo_documentoc` where Id='" + idTipo + "' ORDER BY `Nbre` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                CTipoDocumentoDTO g = new CTipoDocumentoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                g.setNReporte(rs.getString("NReporte"));
                g.setEstado(Integer.valueOf(rs.getInt("Estado")));
                g.setCodigo(rs.getString("CodigoC"));
                g.setEsContable(Integer.valueOf(rs.getInt("EsContable")));
                g.setEsAjuste(Integer.valueOf(rs.getInt("EsAjuste")));
                g.setEsVenta(Integer.valueOf(rs.getInt("EsVentas")));
                g.setIdDocumentoFirma(Long.valueOf(rs.getLong("Id_DocF")));
                g.setNConsecutivo(Long.valueOf(rs.getLong("NConsecutivo")));
                return g;
            }
        };
        List<CTipoDocumentoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public Long addDocContableEncabezado(final String FechaD, final String Id_TipoComprobante, final Long Id_PeriodoC, final String Descripcion, final Integer esGlobal, final Long nConsecutivo) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.3
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, UsuarioS, EsGlobal, NConsecutivo)     VALUES (?,?,?,?,?,?,?)", 1);
                ps.setString(1, FechaD);
                ps.setString(2, Id_TipoComprobante);
                ps.setLong(3, Id_PeriodoC.longValue());
                ps.setString(4, Descripcion);
                ps.setString(5, Principal.usuarioSistemaDTO.getLogin());
                ps.setLong(6, esGlobal.intValue());
                ps.setLong(7, nConsecutivo.longValue());
                return ps;
            }
        }, generatedKeyHolder);
        return Long.valueOf(generatedKeyHolder.getKey().longValue());
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public String addDocContableDetalle(Long Id_Documentoc, String Id_Puc, Integer TipoCPuc, Long Id_Tercero, String Id_Radicacion, String NFactura, Double VDebito, Double VCredito, String Concepto) {
        String result = null;
        int ctos = this.jdbcTemplate.update("insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto)    VALUES (?,?,?,?,?,?,?,?,?)", new Object[]{Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito, Concepto});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<ListadoRadicacionFacturaDTO> listRadicacionFactura(Integer anno) {
        String xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta, cc_radicacion.Id_Comprobante, cc_radicacion.Id AS Id_Radicacion , ROUND(SUM( cc_radicacion.SubTotal+ cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS TotalR, cc_conceptocmsa.Nbre AS Concepto, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y') AS FechaRad \n, IFNULL(cc_documentoc.`Id`, 0) AS IdDocumento FROM cc_radicacion INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id)  INNER JOIN cc_conceptocmsa ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)  \nINNER JOIN cc_documento_contables ON (cc_documento_contables.Id_Radicacion = cc_radicacion.Id)  LEFT JOIN cc_documentoc ON (cc_documentoc.Id_Radicacion = cc_radicacion.Id AND cc_documentoc.`Estado`=1 )  WHERE (cc_radicacion.`Tipo`= 0 AND cc_radicacion.Estado =1  AND cc_documento_contables.Id_CuentaCobro =0 AND DATE_FORMAT(cc_radicacion.Fecha,'%Y')='" + anno + "' )\nGROUP BY cc_radicacion.Id ORDER BY  cc_terceros.RazonSocialCompleta ASC, cc_radicacion.Fecha DESC ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ListadoRadicacionFacturaDTO g = new ListadoRadicacionFacturaDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNEmpresa(rs.getString("Nbre"));
                g.setIdComprobante(Long.valueOf(rs.getLong("Id_Comprobante")));
                g.setIdRadicacion(Long.valueOf(rs.getLong("Id_Radicacion")));
                g.setValor(Double.valueOf(rs.getDouble("TotalR")));
                g.setFechaRad(rs.getString("FechaRad"));
                g.setConcepto(rs.getString("Concepto"));
                g.setIdDocumento(Long.valueOf(rs.getLong("IdDocumento")));
                return g;
            }
        };
        List<ListadoRadicacionFacturaDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public void updateEstadoGlobal_DocContable(String xIdDoc) {
        this.jdbcTemplate.update("UPDATE cc_documentoc SET  `EsGlobal` =0 WHERE (`Id` =?)", new Object[]{xIdDoc});
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public Long mConsultarConsecutivo(String xIdTipoDoc) {
        Long xId = (Long) this.jdbcTemplate.queryForObject("SELECT MAX(`NConsecutivo`) \nFROM `cc_documentoc` \nWHERE (`Id_TipoComprobante` =? AND `Estado` =1)\nGROUP BY `Id_TipoComprobante`", new Object[]{xIdTipoDoc}, Long.class);
        return xId;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<Object[]> facturaPorPagar(String nFactura, String idTercero) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Double.valueOf(rs.getDouble(5)), rs.getString(6), rs.getString(7), rs.getString(8)};
                return fila;
            }
        };
        this.jdbcTemplate.update("DROP TABLE IF EXISTS cc_tmp_libro_diario");
        String sql = "SELECT cc_documentoc.Id, cc_detalle_documentoc.`NFactura` NoFactura,\ncc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`,\n \n  CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario,cc_terceros.Id\n\nFROM \n cc_documentoc \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.`Id_Puc`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\n\n\nWHERE ( cc_documentoc.GenerarC=0 AND cc_detalle_firma_documentoc.Autorizo =1 \nAND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo \nHAVING VCreditoD>0 \nAND NoFactura='" + nFactura + "' AND cc_terceros.Id='" + idTercero + "'\nORDER BY cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
        this.jdbcTemplate.update("DROP TABLE IF EXISTS cc_tmp_libro_diario");
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<Object[]> facturaPorPagarIdTercero(String idTercero) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Double.valueOf(rs.getDouble(5)), rs.getString(6), rs.getString(7), rs.getString(8)};
                return fila;
            }
        };
        this.jdbcTemplate.update("DROP TABLE IF EXISTS cc_tmp_libro_diario");
        String sql = "SELECT cc_documentoc.Id, cc_detalle_documentoc.`NFactura` NoFactura,\ncc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`,\n \n  CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario,cc_terceros.Id\n\nFROM \n cc_documentoc \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.`Id_Puc`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\n\n\nWHERE ( cc_documentoc.GenerarC=0 AND cc_detalle_firma_documentoc.Autorizo =1 \nAND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo \nHAVING VCreditoD>0 \nAND cc_terceros.Id='" + idTercero + "'\nORDER BY cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
        this.jdbcTemplate.update("DROP TABLE IF EXISTS cc_tmp_libro_diario");
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<Object[]> listadoPeriodoContable(String ano, Integer filtro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[7];
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Mes");
                fila[2] = rs.getString("FechaI");
                fila[3] = rs.getString("FechaF");
                fila[4] = Integer.valueOf(rs.getInt("Activo"));
                fila[5] = Boolean.valueOf(rs.getBoolean("Estado"));
                return fila;
            }
        };
        String sql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE Activo='" + filtro + "' and date_format(FechaI,'%Y')='" + ano + "' ORDER BY Id DESC; ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.ContabilidadDAO
    public List<Object[]> obtenerNumeroDeFacturaMYPrefijo(String noFactura) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Prefijo"), rs.getString("No_FacturaEvento_M")};
                return fila;
            }
        };
        String sql = "SELECT\n    `cc_resolucion_dian`.`Prefijo`\n    , `f_factura_evento`.`No_FacturaEvento_M`\n    , `f_factura_evento`.`No_FacturaEvento`\nFROM\n    `baseserver`.`cc_resolucion_dian`\n    INNER JOIN `baseserver`.`f_factura_evento` \n        ON (`cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)\nWHERE (`f_factura_evento`.`No_FacturaEvento` = " + noFactura + ");";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
