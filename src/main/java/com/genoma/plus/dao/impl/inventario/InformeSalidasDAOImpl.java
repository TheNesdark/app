package com.genoma.plus.dao.impl.inventario;

import com.genoma.plus.dao.inventario.InformeSalidasDAO;
import com.genoma.plus.dto.inventario.InformeSalidasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/InformeSalidasDAOImpl.class */
public class InformeSalidasDAOImpl implements InformeSalidasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.InformeSalidasDAO
    public List<Object[]> mCargarTabla(InformeSalidasDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformeSalidasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), Long.valueOf(rs.getLong(2)), rs.getString(3), rs.getString(4), rs.getString(5), Long.valueOf(rs.getLong(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), Long.valueOf(rs.getLong(14)), Long.valueOf(rs.getLong(15)), Long.valueOf(rs.getLong(16)), rs.getString(17), Long.valueOf(rs.getLong(18)), rs.getString(19), Long.valueOf(rs.getLong(20)), rs.getString(21)};
                return fila;
            }
        };
        String bodega = "";
        String estado = "";
        if (!dto.getFiltroC().isEmpty()) {
            bodega = " `i_salidas`.`IdBodega` = '" + dto.getFiltroC() + "' AND \n";
        }
        if (dto.getEstado().equals("0")) {
            estado = "AND `i_salidas`.`Estado` = '" + dto.getEstado() + "' ";
        } else if (dto.getEstado().equals("1")) {
            estado = "AND `i_salidas`.`Estado` >= '" + dto.getEstado() + "' ";
        }
        String sql = " SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`IdTipoMovimiento`\n    , `i_tiposmovimientos`.`Nbre` AS `NMOvimiento`\n    , `i_salidas`.`FechaSalida`  \n    , CONCAT(IF(`i_salidas`.`Destino`=0,CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',  `g_persona`.`Nombre2`), '')\n    , IF(`i_salidas`.`Destino`=2, `g_empresa`.`Nbre`, '')\n    , IF(`i_salidas`.`Destino`=1,`i_bodegas`.`Nbre`,'')\n    , IF(`i_salidas`.`Destino`=3,`f_centrocosto`.`Nbre`, ''))  destino\n    , `i_suministro`.`Id` AS `idSUministro`\n    , `i_suministro`.`Nbre` AS `nombreSumistro`\n    , `i_laboratorio`.`Nbre` AS `laboratorio`\n    , `i_presentacionfarmaceutica`.`Nbre` AS `presentacionFarmaceutica`\n    , `i_presentacioncomercial`.`Nbre` AS `presentacionComercial`\n    ,  i_tipoproducto.`Nbre` AS tipoProducto\n    , `i_detallesalida`.`Lote`\n    , `i_detallesalida`.`FechaVencimiento`\n    , `i_detallesalida`.`CantidadSolicitada`\n    , `i_detallesalida`.`CantidadDespachada`\n    , ROUND(`i_detallesalida`.`ValorUnitario`) valorUnitario\n    , `i_detallesalida`.`Observacion`\n    , `i_salidas`.`Id_DocContable`\n    , `i_salidas`.`OrdenH`\n    , `i_salidas`.`Id_Ingreso`\n    , IF(`i_salidas`.`Estado` = 0, 'ACTIVO', 'ANULADO') AS Estado \n    \n  --  0:Paciente 1:Bodega 2:Proveedor 3:Centro Costo\nFROM\n    `baseserver`.`i_detallesalida`\n    INNER JOIN `baseserver`.`i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `baseserver`.`i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    LEFT JOIN `baseserver`.`g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `baseserver`.`i_bodegas` \n        ON (`i_bodegas`.`Id` = `i_salidas`.`IdDestino`)\n    LEFT JOIN `baseserver`.`f_centrocosto` \n        ON (`f_centrocosto`.`Id` = `i_salidas`.`IdDestino`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n      INNER JOIN `baseserver`.`i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN `baseserver`.`i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `baseserver`.`i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  \n    INNER JOIN `baseserver`.`i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)      \nWHERE ( " + bodega + "    `i_salidas`.`FechaSalida` >= '" + dto.getFechaI() + "'\n    AND `i_salidas`.`FechaSalida` <= '" + dto.getFechaF() + "'\n    " + estado + " )\n ORDER BY `i_salidas`.`Id` ASC; ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.inventario.InformeSalidasDAO
    public List<Object[]> mCargarCombo(InformeSalidasDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformeSalidasDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  i_bodegas.`Id`,\n  i_bodegas.`Nbre`\nFROM\n  `baseserver`.`i_detallesalida`\n  INNER JOIN `baseserver`.`i_salidas`\n    ON (\n      `i_detallesalida`.`IdSalida` = `i_salidas`.`Id`\n    )\n  INNER JOIN `baseserver`.`i_tiposmovimientos`\n    ON (\n      `i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`\n    )\n  LEFT JOIN `baseserver`.`g_persona`\n    ON (\n      `g_persona`.`Id` = `i_salidas`.`IdDestino`\n    )\n  LEFT JOIN `baseserver`.`g_empresa`\n    ON (\n      `g_empresa`.`Id` = `i_salidas`.`IdDestino`\n    )\n  INNER JOIN `baseserver`.`i_bodegas`\n    ON (\n      `i_bodegas`.`Id` = `i_salidas`.`IdDestino`\n    )\n  LEFT JOIN `baseserver`.`f_centrocosto`\n    ON (\n      `f_centrocosto`.`Id` = `i_salidas`.`IdDestino`\n    )\n  INNER JOIN `baseserver`.`i_suministro`\n    ON (\n      `i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`\n    )\n  INNER JOIN `baseserver`.`i_laboratorio`\n    ON (\n      `i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`\n    )\n  INNER JOIN `baseserver`.`i_presentacioncomercial`\n    ON (\n      `i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`\n    )\n  INNER JOIN `baseserver`.`i_presentacionfarmaceutica`\n    ON (\n      `i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`\n    )\n  INNER JOIN `baseserver`.`i_tipoproducto`\n    ON (\n      `i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`\n    )\nWHERE (\n    `i_salidas`.`FechaSalida` >= '" + dto.getFechaI() + "'\n    AND `i_salidas`.`FechaSalida` <= '" + dto.getFechaF() + "'\n    AND `i_salidas`.`Estado` = 0\n  )\nGROUP BY i_bodegas.`Id`\nORDER BY i_bodegas.`Id` ASC;\n";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
