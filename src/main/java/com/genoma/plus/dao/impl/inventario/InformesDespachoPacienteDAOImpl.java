package com.genoma.plus.dao.impl.inventario;

import com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.inventario.InformesDespachoPacienteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/InformesDespachoPacienteDAOImpl.class */
public class InformesDespachoPacienteDAOImpl implements InformesDespachoPacienteDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO
    public List<InformesDespachoPacienteDTO> listaPacientes(String xfechaI, String xfechaF, String xidbodega) {
        String xsql = "SELECT\n    i_salidas.Id\n    , i_salidas.FechaSalida\n    , i_salidas.OrdenH\n    , persona.NoHistoria\n    , persona.NUsuario\n    , i_suministros.Producto\n    , i_detallesalida.Lote\n    , i_detallesalida.FechaVencimiento\n    , i_detallesalida.CantidadSolicitada\n    , i_detallesalida.CantidadDespachada\n , i_detallesalida.ValorUnitario\nFROM g_ips,\n    i_salidas\n    INNER JOIN persona\n        ON (i_salidas.IdDestino = persona.Id_persona)\n    INNER JOIN i_detallesalida\n        ON (i_detallesalida.IdSalida = i_salidas.Id)\n    INNER JOIN i_suministros\n        ON (i_detallesalida.IdSuministro = i_suministros.Id)\nWHERE (i_salidas.FechaSalida >= '" + xfechaI + "'\n    AND i_salidas.FechaSalida <= '" + xfechaF + "'\n    AND i_salidas.Estado =0\n    AND i_salidas.Destino =0\n    AND i_salidas.IdBodega ='" + xidbodega + "') ORDER BY i_salidas.Id;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformesDespachoPacienteDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InformesDespachoPacienteDTO g = new InformesDespachoPacienteDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setFechaSalida(rs.getString("FechaSalida"));
                g.setOrdenH(Long.valueOf(rs.getLong("OrdenH")));
                g.setNoHistoria(rs.getString("NoHistoria"));
                g.setUsuario(rs.getString("NUsuario"));
                g.setProducto(rs.getString("Producto"));
                g.setLote(rs.getString("Lote"));
                g.setFechaVencimiento(rs.getString("FechaVencimiento"));
                g.setCantidadSolicitada(rs.getInt("CantidadSolicitada"));
                g.setCantidadDespachada(rs.getInt("CantidadDespachada"));
                g.setValor(Double.valueOf(rs.getDouble("ValorUnitario")));
                return g;
            }
        };
        List<InformesDespachoPacienteDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO
    public List<InformesDespachoPacienteDTO> listaAuditoria(String xfechaI, String xfechaF, String xidbodega) {
        String xsql = "SELECT\n    `i_salidas`.`FechaSalida`\n    , `i_salidas`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    ,GROUP_CONCAT(DISTINCT(CONCAT(`i_suministro`.`Nbre`,'\\t\\tCANTIDAD : ',`i_detallesalida`.`CantidadDespachada`,'\\nLOTE : ',`i_detallesalida`.`Lote`,'\\tFVENCIMIENTO : ', `i_detallesalida`.`FechaVencimiento` , IF(`i_detallesalida`.`Observacion`='', '',CONCAT('\\tOBSERVACIÓN : ', `i_detallesalida`.`Observacion`)))) ORDER BY `i_suministro`.`Nbre` ASC SEPARATOR'\\n')  AS `NSuministroE`\n    ,  IF(GROUP_CONCAT(DISTINCT(CONCAT(`i_suministro_1`.`Nbre`,'\\t\\tCANTIDAD : ',`h_itemordenessum`.`Cantidad`)) ORDER BY `i_suministro_1`.`Nbre` ASC SEPARATOR'\\n' ) IS NULL,'NO TIENE ORDEN RELACIONADA',\n    GROUP_CONCAT(DISTINCT(CONCAT(`i_suministro_1`.`Nbre`,'\\t\\tCANTIDAD : ',`h_itemordenessum`.`Cantidad`)) ORDER BY `i_suministro_1`.`Nbre` ASC SEPARATOR'\\n' ) ) AS `FSolicitada`\n    , `i_bodegas`.`Nbre` AS `NBodega`    \nFROM\n    `d_ips`,\n    `i_detallesalida`\n    INNER JOIN `i_salidas`\n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_tiposmovimientos`\n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `g_persona`\n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `h_ordenes`\n        ON (`h_ordenes`.`Id` = `i_salidas`.`OrdenH`)\n    INNER JOIN `i_bodegas`\n        ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `g_usuario`\n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN `h_itemordenessum`\n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    LEFT JOIN `i_suministro` AS `i_suministro_1`\n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro_1`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + xfechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xfechaF + "'\n    AND `i_tiposmovimientos`.`Despacho` =1\n    AND `i_salidas`.`IdBodega` ='" + xidbodega + "'\n    AND `i_salidas`.`Estado` =0)\nGROUP BY `i_salidas`.`Id`\nORDER BY `i_salidas`.`Id` ;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformesDespachoPacienteDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InformesDespachoPacienteDTO g = new InformesDespachoPacienteDTO();
                g.setFechaSalida(rs.getString("FechaSalida"));
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNoHistoria(rs.getString("NoHistoria"));
                g.setUsuario(rs.getString("NUsuario"));
                g.setProducto(rs.getString("NSuministroE"));
                g.setFSolicitada(rs.getString("FSolicitada"));
                g.setBodega(rs.getString("NBodega"));
                return g;
            }
        };
        List<InformesDespachoPacienteDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO
    public List<InformesDespachoPacienteDTO> listaProducto(String xfechaI, String xfechaF, String xidbodega) {
        String xsql = "SELECT\n    `i_suministro`.`Nbre` AS producto\n    , SUM(`i_detallesalida`.`CantidadDespachada`) AS cantidad_total\n    , `i_tipoproducto`.`Nbre` AS grupo\n    ,`i_detallesalida`.`Lote`\n,i_salidas.FechaSalida AS inicio\n,i_salidas.FechaSalida AS fin\nFROM g_ips,\n    `baseserver`.`i_detallesalida`\n    INNER JOIN `baseserver`.`i_salidas`\n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro`\n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n        INNER JOIN `baseserver`.`i_tipoproducto`\n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\nWHERE (`i_salidas`.`IdBodega` ='" + xidbodega + "'\n    AND `i_salidas`.`FechaSalida` >='" + xfechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xfechaF + "')\n    GROUP BY `i_detallesalida`.`IdSuministro`, `i_detallesalida`.`Lote`\n ORDER BY `i_tipoproducto`.`Nbre`, `i_suministro`.`Nbre`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformesDespachoPacienteDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InformesDespachoPacienteDTO g = new InformesDespachoPacienteDTO();
                g.setProducto(rs.getString("producto"));
                g.setCantidadSolicitada(rs.getInt("cantidad_total"));
                g.setGrupo(rs.getString("grupo"));
                g.setLote(rs.getString("Lote"));
                g.setFechaSalida(rs.getString("inicio"));
                g.setFechaVencimiento(rs.getString("fin"));
                return g;
            }
        };
        List<InformesDespachoPacienteDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO
    public List<InformesDespachoPacienteDTO> listaEmpresa(String xfechaI, String xfechaF, String xidbodega) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO
    public List<GCGenericoDTO> listabodegas() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformesDespachoPacienteDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT Id, Nbre FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", mapper);
        return list;
    }
}
