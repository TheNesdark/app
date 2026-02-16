package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.FacturacionDAO;
import com.genoma.plus.dto.facturacion.GenericoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/FacturacionDAOImp.class */
public class FacturacionDAOImp implements FacturacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listProcedimientoTipo(Long idTipoProcedimiento) {
        String xsql = "SELECT   `Id`  , `Nbre` FROM `g_procedimiento` WHERE (`Id_tipoprocedimiento` ='" + idTipoProcedimiento + "'  AND `Estado` =0) ORDER BY `Nbre` ASC ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listProcedimiento(String idProcedimiento) {
        String xsql = "SELECT  g_procedimiento.Id ,  ifnull(C_Homologado,'') as codigo   , `Nbre` FROM `g_procedimiento` WHERE ((`Id` ='" + idProcedimiento + "' or C_Homologado ='" + idProcedimiento + "')  AND `Estado` =0)";
        System.out.println("sql : " + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                g.setCodigo(rs.getString("codigo"));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listProcedimientoRelacionado(Long IdProcedimientoR) {
        String xsql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, `h_procedimientoxprelacionado`.`Estado` FROM `h_procedimientoxprelacionado`\nINNER JOIN `baseserver`.`g_procedimiento` ON (`h_procedimientoxprelacionado`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (`h_procedimientoxprelacionado`.`Id_ProcedimientoR` ='" + IdProcedimientoR + "') ORDER BY `g_procedimiento`.`Nbre` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                g.setEstado(Boolean.valueOf(rs.getBoolean("Estado")));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public void addProcedimientoRelacionado(String id_Procedimiento, String id_ProcedimientoR, Integer Estado) {
        this.jdbcTemplate.update("INSERT IGNORE INTO h_procedimientoxprelacionado(Id_Procedimiento, Id_ProcedimientoR, Estado)    VALUES (?,?,?)", new Object[]{id_Procedimiento, id_ProcedimientoR, Estado});
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public void updateProcedimientoRelacionado(String id_Procedimiento, String id_ProcedimientoR, Integer Estado) {
        this.jdbcTemplate.update("UPDATE h_procedimientoxprelacionado SET  `Estado` =? WHERE (`Id_Procedimiento` =? AND `Id_ProcedimientoR` =?)", new Object[]{Estado, id_Procedimiento, id_ProcedimientoR});
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<Object[]> listSalidaInventario(Long IdIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), Long.valueOf(rs.getLong(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), Long.valueOf(rs.getLong(9))};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n                     `i_salidas`.`Id`\n                     , `i_salidas`.`FechaSalida` AS `Fecha`\n                     , CONCAT(`i_suministro`.`Nbre` , ' ', `i_presentacionfarmaceutica`.`Nbre`, ' ',`i_laboratorio`.`Nbre`) AS `NProucto`\n                     , `i_detallesalida`.`CantidadDespachada` AS `Cantidad`\n                     , `i_detallesalida`.`Lote` AS `Lote`\n                     , `i_tiposmovimientos`.`Nbre` AS `TipoMovimiento`\n                     , `i_bodegas`.`Nbre` AS `NBodega`\n                     , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n                     , IFNULL(d.Id_OrdenF,0) AS Id_OrdenF\n                 FROM\n                     `i_detallesalida`\n                     INNER JOIN `i_salidas` \n                         ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n                     INNER JOIN `i_tiposmovimientos` \n                         ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n                     INNER JOIN `i_bodegas` \n                         ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\n                     INNER JOIN `i_suministro` \n                         ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n                     INNER JOIN `i_presentacionfarmaceutica` \n                         ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n                     INNER JOIN `i_laboratorio` \n                         ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n                     INNER JOIN `i_tipoproducto` \n                         ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n                     LEFT JOIN( SELECT `h_ordenes_unidosis_detalle`.`Id_Salida`, h_ordenes_unidosis_detalle.`Id_Suministro` , `h_ordenes_unidosis_aplicacion`.`Id_OrdenF`\n\t\t\tFROM `h_ordenes_unidosis_detalle`\n\t\t\tINNER JOIN `h_ordenes_unidosis` \n\t\t\tON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`)\n\t\t\tINNER JOIN `h_ordenes_unidosis_aplicacion` \n\t\t\tON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`)\n\t\t\tINNER JOIN `h_ordenes_unidosis_aplicacion_detalle` \n\t\t\tON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `h_ordenes_unidosis_detalle`.`Id_Suministro`) AND (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`)\n\t\t\t) d ON d.Id_Salida = `i_salidas`.`Id` AND d.Id_Suministro = `i_detallesalida`.`IdSuministro`\n                 WHERE (`i_salidas`.`Id_Ingreso` =?\n                     AND `i_salidas`.`Estado` =0)\n                 ORDER BY `i_salidas`.`Id` DESC, `NTipoProducto` ASC, `NProucto` ASC", mapper, new Object[]{IdIngreso});
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<Object[]> listSalidaInventarioCTipoMovimiento(Long IdIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[8];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = Long.valueOf(rs.getLong(5));
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT \n `i_bodegas`.`Nbre` AS `NBodega` \n   , `i_tiposmovimientos`.`Nbre` AS `TipoMovimiento` \n   , `i_tipoproducto`.`Nbre` AS `NTipoProducto`   \n , CONCAT(`i_suministro`.`Nbre` , ' ', `i_presentacionfarmaceutica`.`Nbre`, ' ',`i_laboratorio`.`Nbre`) AS `NProucto` \n , SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`  \n FROM \n `i_detallesalida` \n INNER JOIN `i_salidas`  \n     ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) \n INNER JOIN `i_tiposmovimientos`  \n     ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) \n INNER JOIN `i_bodegas`  \n     ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`) \n INNER JOIN `i_suministro`  \n     ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) \n INNER JOIN `i_presentacionfarmaceutica`  \n     ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) \n INNER JOIN `i_laboratorio`  \n     ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) \n INNER JOIN `i_tipoproducto`  \n     ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`) \n WHERE (`i_salidas`.`Id_Ingreso` =?\n AND `i_salidas`.`Estado` =0) \n  GROUP BY  `i_salidas`.`IdBodega`, `i_tipoproducto`.`Id`, `i_tiposmovimientos`.`Id`, `i_suministro`.`Id`\n ORDER BY `i_bodegas`.`Nbre` ASC , `i_tiposmovimientos`.`Nbre` ASC, `NTipoProducto` ASC, `NProucto` ASC;", mapper, new Object[]{IdIngreso});
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listSuministro(String codigo) {
        String xsql = "SELECT   `Id`  , `Nbre` FROM `i_suministro` WHERE ((i_suministro.`codigoIUM` ='" + codigo + "' OR i_suministro.`CodigoCUM` ='" + codigo + "') AND i_suministro.`EstaActivo`=1) ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listOtroProcedimiento(String idProcedimiento) {
        String xsql = "SELECT   ifnull(C_Homologado,'') as Id   , `Nbre` FROM `g_procedimiento` WHERE ((`Id` ='" + idProcedimiento + "' or C_Homologado ='" + idProcedimiento + "')  AND `Estado` =0 AND g_procedimiento.`Id_TipoProcRIPS` IN (1,2,3,4) )";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.FacturacionDAO
    public List<GenericoDTO> listMaterialAnexo1(String codigo) {
        String xsql = "SELECT   `Id`  , `Nbre` FROM `i_suministro` \nWHERE ((i_suministro.`codigoIUM` ='" + codigo + "'\n OR i_suministro.`CodigoCUM` ='" + codigo + "') AND i_suministro.`EstaActivo`=1 AND i_suministro.`EsMaterial`=1) ; ";
        System.err.println("xsql" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoDTO g = new GenericoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
