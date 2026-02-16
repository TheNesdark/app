package com.genoma.plus.dao.impl.contabilidad;

import com.genoma.plus.dao.contabilidad.LibroDiarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/contabilidad/LibroDiarioDAOImpl.class */
public class LibroDiarioDAOImpl implements LibroDiarioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.contabilidad.LibroDiarioDAO
    public List<Object[]> listadoLibroDiario(String xFechaI, String xFechaF, int xesNiif) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.LibroDiarioDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), Long.valueOf(rs.getLong(7)), rs.getString(8), rs.getString(9), rs.getString(10), Double.valueOf(rs.getDouble(11)), Double.valueOf(rs.getDouble(12)), Double.valueOf(rs.getDouble(13)), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20)};
                return fila;
            }
        };
        this.jdbcTemplate.update("DROP TABLE IF EXISTS cc_tmp_libro_diario");
        if (xesNiif == 0) {
            sql = "SELECT cc_documentoc.`FechaD`, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre NDocumento, cc_terceros.`TDCompleto1` Documento, cc_terceros.RazonSocialCompleta, cc_documentoc.FechaD as FechaD1, cc_documentoc.Id, cc_detalle_documentoc.Id_Puc, CAST( IF(cc_puc.PBase<>0, CONCAT(cc_puc.Nbre,' ', CONCAT(cc_puc.PBase,'%') ),cc_puc.Nbre) AS  CHAR ) AS NCuenta, IF(cc_detalle_documentoc.TipoCPuc=0,'Debito','Credito')  AS Naturaleza, cc_detalle_documentoc.VDebito         , cc_detalle_documentoc.VCredito, cc_detalle_documentoc.Base , cc_documentoc.Descripcion, cc_detalle_documentoc.Concepto, IF(`cc_documentoc`.`Id_Anulado`=0, 'ACTIVO', 'ANULADO') AS Estado, IF(`cc_documentoc`.`FechaAnulacion` IS NULL, '', `cc_documentoc`.`FechaAnulacion`) AS FAnulacion, IF(`cc_documentoc`.`MotivoAnulacion` IS NULL, '', `cc_documentoc`.`MotivoAnulacion`) AS MAnulacion, `cc_documentoc`.`UsuarioAnulacion`, cc_documentoc.NConsecutivo         FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)         INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN g_empresa  ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`)        WHERE ( cc_documentoc.Estado=1 and cc_documentoc.`FechaD`>='" + xFechaI + "' AND cc_documentoc.`FechaD`<='" + xFechaF + "') order by cc_documentoc.`FechaD` asc, cc_documentoc.Id";
        } else {
            sql = "SELECT\n  cc_documentoc.`FechaD`,\n  cc_tipo_documentoc.CodigoC,\n  cc_tipo_documentoc.Nbre NDocumento,\n  cc_terceros.`TDCompleto1` Documento,\n  cc_terceros.RazonSocialCompleta,\n  cc_documentoc.FechaD AS FechaD1,\n  cc_documentoc.Id,\n  cc_puc_niif.`Id` AS Id_Puc,\n  CAST(IF(cc_puc.PBase <> 0,CONCAT(cc_puc_niif.Nbre,' ',CONCAT(cc_puc.PBase, '%')),cc_puc_niif.Nbre) AS CHAR) AS NCuenta,\n  IF(cc_detalle_documentoc.TipoCPuc = 0,'Debito','Credito') AS Naturaleza,\n  cc_detalle_documentoc.VDebito,\n  cc_detalle_documentoc.VCredito,\n  cc_detalle_documentoc.Base,\n  cc_documentoc.Descripcion,\n  cc_detalle_documentoc.Concepto,\n  IF(`cc_documentoc`.`Id_Anulado` = 0,'ACTIVO','ANULADO') AS Estado,\n  IF(`cc_documentoc`.`FechaAnulacion` IS NULL,'',`cc_documentoc`.`FechaAnulacion`) AS FAnulacion,\n  IF(`cc_documentoc`.`MotivoAnulacion` IS NULL,'',`cc_documentoc`.`MotivoAnulacion`) AS MAnulacion,\n  `cc_documentoc`.`UsuarioAnulacion`,\n  cc_documentoc.NConsecutivo\nFROM\n  cc_detalle_documentoc\n  INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n  INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)\n  INNER JOIN cc_puc ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc)\n  INNER JOIN cc_periodo_contable ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC)\n  INNER JOIN g_empresa ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero)\n  INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`)\n  INNER JOIN `cc_pucg_niif`ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\n  INNER JOIN `cc_puc_niif`ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\nWHERE (\n    cc_documentoc.Estado = 1\n    AND cc_documentoc.`FechaD` >= '" + xFechaI + "'\n    AND cc_documentoc.`FechaD` <= '" + xFechaF + "'\n  )\nORDER BY cc_documentoc.`FechaD` ASC, cc_documentoc.Id";
        }
        System.out.println("" + sql);
        String xsql = "CREATE TABLE cc_tmp_libro_diario " + sql;
        this.jdbcTemplate.update(xsql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
