package com.genoma.plus.dao.impl.inventario;

import Acceso.Principal;
import com.genoma.plus.dao.inventario.ConsolidadoSalidasDAO;
import com.genoma.plus.dto.inventario.ConsolidadoSalidasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/ConsolidadoSalidasDAOImpl.class */
public class ConsolidadoSalidasDAOImpl implements ConsolidadoSalidasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.ConsolidadoSalidasDAO
    public List<ConsolidadoSalidasDTO> listaConsolidadoSalidas(String xFechaI, String xFechaF, int opc) {
        String xsql = "";
        switch (opc) {
            case 0:
                xsql = "SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`FechaSalida`\n    , `i_tiposmovimientos`.`Nbre` AS `NMovimiento`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_salidas`.`Id_DocContable`\n    , `i_salidas`.`Observaciones`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_presentacioncomercial`.`Nbre` AS `NPresentacionComercial`\n    , `i_suministro`.`FechaVInvima`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    , `i_detallesalida`.`Lote`\n    , `i_detallesalida`.`FechaVencimiento`\n    , `i_detallesalida`.`CantidadDespachada` AS `Cantidad`\n    , ROUND(`i_detallesalida`.`ValorUnitario`) AS `VUnitario`\n    , (`i_detallesalida`.`CantidadDespachada`*ROUND(`i_detallesalida`.`ValorUnitario`)) VTotal\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`TipoD`=1, IF(`i_salidas`.`TipoD`=1,`f_centrocosto`.`Nbre`, '') , IF(`i_salidas`.`TipoD`=0, IF(`i_salidas`.`TipoD`=0,CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`), ''), IF(`i_salidas`.`TipoD`=2,`cc_terceros`.`RazonSocialCompleta`,''))) DestinoSalida\n    , `i_salidas`.`Fecha` fechaRegistro\n    , `i_salidas`.`UsuarioS` usuarioRegistro\n    \nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    LEFT JOIN `f_centrocosto` \n        ON (`f_centrocosto`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `i_salidas`.`IdDestino`)\nWHERE (`i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND `i_salidas`.`FechaSalida` >='" + xFechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xFechaF + "')\nORDER BY `i_salidas`.`Id` DESC;";
                break;
            case 1:
                xsql = "SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`FechaSalida`\n    , `i_tiposmovimientos`.`Nbre` AS `NMovimiento`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_salidas`.`Id_DocContable`\n    , `i_salidas`.`Observaciones`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_presentacioncomercial`.`Nbre` AS `NPresentacionComercial`\n    , `i_suministro`.`FechaVInvima`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    , `i_detallesalida`.`Lote`\n    , `i_detallesalida`.`FechaVencimiento`\n    , `i_detallesalida`.`CantidadDespachada` AS `Cantidad`\n    , ROUND(`i_detallesalida`.`ValorUnitario`) AS `VUnitario`\n    , (`i_detallesalida`.`CantidadDespachada`*ROUND(`i_detallesalida`.`ValorUnitario`)) VTotal\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`TipoD`=1, IF(`i_salidas`.`TipoD`=1,`f_centrocosto`.`Nbre`, '') , IF(`i_salidas`.`TipoD`=0, IF(`i_salidas`.`TipoD`=0,CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`), ''), IF(`i_salidas`.`TipoD`=2,`cc_terceros`.`RazonSocialCompleta`,''))) DestinoSalida\n    , `i_salidas`.`Fecha` fechaRegistro\n    , `i_salidas`.`UsuarioS` usuarioRegistro\n    \nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    LEFT JOIN `f_centrocosto` \n        ON (`f_centrocosto`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `i_salidas`.`IdDestino`)\nWHERE (`i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND `i_salidas`.`FechaSalida` >='" + xFechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xFechaF + "'\n    AND `i_salidas`.`Estado` =0)\nORDER BY `i_salidas`.`Id` DESC;";
                break;
            case 2:
                xsql = "SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`FechaSalida`\n    , `i_tiposmovimientos`.`Nbre` AS `NMovimiento`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`Estado`=0, 'ACTIVO', 'ANULADO') AS `Estado`\n    , `i_salidas`.`Id_DocContable`\n    , `i_salidas`.`Observaciones`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `i_categoria`.`Nbre` AS `NCategoria`\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_presentacioncomercial`.`Nbre` AS `NPresentacionComercial`\n    , `i_suministro`.`FechaVInvima`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    , `i_detallesalida`.`Lote`\n    , `i_detallesalida`.`FechaVencimiento`\n    , `i_detallesalida`.`CantidadDespachada` AS `Cantidad`\n    , ROUND(`i_detallesalida`.`ValorUnitario`) AS `VUnitario`\n    , (`i_detallesalida`.`CantidadDespachada`*ROUND(`i_detallesalida`.`ValorUnitario`)) VTotal\n    , `i_salidas`.`TipoD`\n    , `i_salidas`.`Destino`\n    , `i_salidas`.`IdDestino`\n    , IF(`i_salidas`.`TipoD`=1, IF(`i_salidas`.`TipoD`=1,`f_centrocosto`.`Nbre`, '') , IF(`i_salidas`.`TipoD`=0, IF(`i_salidas`.`TipoD`=0,CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`), ''), IF(`i_salidas`.`TipoD`=2,`cc_terceros`.`RazonSocialCompleta`,''))) DestinoSalida\n    , `i_salidas`.`Fecha` fechaRegistro\n    , `i_salidas`.`UsuarioS` usuarioRegistro\n    \nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_categoria` \n        ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    LEFT JOIN `f_centrocosto` \n        ON (`f_centrocosto`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `i_salidas`.`IdDestino`)\nWHERE (`i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND `i_salidas`.`FechaSalida` >='" + xFechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xFechaF + "'\n    AND `i_salidas`.`Estado` =1)\nORDER BY `i_salidas`.`Id` DESC;";
                break;
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.ConsolidadoSalidasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsolidadoSalidasDTO g = new ConsolidadoSalidasDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setFechaSalida(rs.getString("FechaSalida"));
                g.setNMovimiento(rs.getString("NMovimiento"));
                g.setDestino(rs.getInt("Destino"));
                g.setTipoD(rs.getInt("TipoD"));
                g.setIdDestino(Long.valueOf(rs.getLong("IdDestino")));
                g.setEstado(rs.getString("Estado"));
                g.setIdDocContable(Long.valueOf(rs.getLong("Id_DocContable")));
                g.setObservacion(rs.getString("Observaciones"));
                g.setNTipoProducto(rs.getString("NTipoProducto"));
                g.setNCategoria(rs.getString("NCategoria"));
                g.setNProducto(rs.getString("NProducto"));
                g.setNPActivo(rs.getString("NPActivo"));
                g.setNConcentracion(rs.getString("NConcentracion"));
                g.setNPresentacionComercial(rs.getString("NPresentacionComercial"));
                g.setFechaVInvima(rs.getString("FechaVInvima"));
                g.setNLaboratorio(rs.getString("NLaboratorio"));
                g.setLote(rs.getString("Lote"));
                g.setFechaVencimiento(rs.getString("FechaVencimiento"));
                g.setCantidad(rs.getInt("Cantidad"));
                g.setVUnitario(Double.valueOf(rs.getDouble("VUnitario")));
                g.setVTotal(Double.valueOf(rs.getDouble("VTotal")));
                g.setDestinoSalida(rs.getString("DestinoSalida"));
                g.setFechaRegistro(rs.getString("fechaRegistro"));
                g.setUsuarioRegistro(rs.getString("usuarioRegistro"));
                return g;
            }
        };
        List<ConsolidadoSalidasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
