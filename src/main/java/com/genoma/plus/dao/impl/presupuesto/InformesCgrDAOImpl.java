package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.InformesCgrDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/InformesCgrDAOImpl.class */
public class InformesCgrDAOImpl implements InformesCgrDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.InformesCgrDAO
    public List<Object[]> lisProgramacionIngresos(String idPeriodo, String idEncabezado, String anno) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.InformesCgrDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Tipo"), rs.getString("idRubro"), rs.getString("nombreRubro"), rs.getString("idCodigoContraloria"), rs.getString("idTipoRecurso"), rs.getString("idOrigenIngreso"), rs.getString("idTipoDestinacion"), rs.getString("idTipoSituacion"), Integer.valueOf(rs.getInt("UltNivel"))};
                return fila;
            }
        };
        String sql = "SELECT 'D' Tipo,\n    `pp_rubros`.`Id` AS `idRubro`\n    , `pp_rubros`.`Nbre` AS `nombreRubro`\n    , `pp_rubros`.`UltNivel`, pp_rubros.`IdPadre`\n    , IFNULL(`pp_parametrizacion_cgr`.`idRubro_Contraloria`,'') AS `idCodigoContraloria`\n    , IFNULL(`pp_tipo_recursos`.`Codigo`,'') AS `idTipoRecurso`\n    , IFNULL(`pp_origen_ingreso`.`Codigo`,'') AS `idOrigenIngreso`\n    , IFNULL(`pp_tipo_destinacion`.`Codigo`,'') AS `idTipoDestinacion`\n    , IFNULL(`pp_tipo_situacion`.`Codigo`,'') AS `idTipoSituacion`\nFROM\n    `pp_parametrizacion_cgr`\n    RIGHT JOIN `pp_rubros` \n        ON (`pp_parametrizacion_cgr`.`idRubro` = `pp_rubros`.`Id`)\n    LEFT JOIN `pp_tipo_recursos` \n        ON (`pp_parametrizacion_cgr`.`idTipoRecurso` = `pp_tipo_recursos`.`Id`)\n    LEFT JOIN `pp_tipo_situacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoSituacion` = `pp_tipo_situacion`.`Id`)\n    LEFT JOIN `pp_origen_ingreso` \n        ON (`pp_parametrizacion_cgr`.`IdOrigienIngreso` = `pp_origen_ingreso`.`Id`)\n    LEFT JOIN `pp_tipo_destinacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoDestino` = `pp_tipo_destinacion`.`Id`)\nWHERE (`pp_rubros`.`idEncabezadoRubro` ='" + idEncabezado + "'\n    AND `pp_rubros`.`TipoRubro` ='I');";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.InformesCgrDAO
    public List<Object[]> lisProgramacionGastos(String idPeriodo, String idEncabezado, String anno) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.InformesCgrDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Tipo"), rs.getString("idRubro"), rs.getString("nombreRubro"), rs.getString("idCodigoContraloria"), rs.getString("IdConsecutivo"), rs.getString("idTipoRecurso"), rs.getString("idOrigenIngreso"), rs.getString("idTipoDestinacion"), rs.getString("idFinGasto"), Integer.valueOf(rs.getInt("UltNivel"))};
                return fila;
            }
        };
        String sql = "SELECT\n    'D' Tipo,`pp_rubros`.`Id` AS `idRubro`\n    , `pp_rubros`.`Nbre` AS `nombreRubro`\n    , `pp_rubros`.`UltNivel`\n , pp_rubros.`IdPadre`, 1 IdConsecutivo\n    , IFNULL(`pp_parametrizacion_cgr`.`idRubro_Contraloria`,'') AS `idCodigoContraloria`\n    , IFNULL(`pp_tipo_recursos`.`Codigo`,'') AS `idTipoRecurso`\n    , IFNULL(`pp_origen_ingreso`.`Codigo`,'') AS `idOrigenIngreso`\n    , IFNULL(`pp_tipo_destinacion`.`Codigo`,'') AS `idTipoDestinacion`\n    , IFNULL(`pp_finalidad_gasto`.`Codigo`,'') AS `idFinGasto`\nFROM\n    `pp_parametrizacion_cgr`\n    RIGHT JOIN `pp_rubros` \n        ON (`pp_parametrizacion_cgr`.`idRubro` = `pp_rubros`.`Id`)\n    LEFT JOIN `pp_tipo_recursos` \n        ON (`pp_parametrizacion_cgr`.`idTipoRecurso` = `pp_tipo_recursos`.`Id`)\n    LEFT JOIN `pp_tipo_situacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoSituacion` = `pp_tipo_situacion`.`Id`)\n    LEFT JOIN `pp_origen_ingreso` \n        ON (`pp_parametrizacion_cgr`.`IdOrigienIngreso` = `pp_origen_ingreso`.`Id`)\n    LEFT JOIN `pp_tipo_destinacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoDestino` = `pp_tipo_destinacion`.`Id`)\n    LEFT JOIN `pp_finalidad_gasto` \n        ON (`pp_parametrizacion_cgr`.`idFinGasto` = `pp_finalidad_gasto`.`Id`)\nWHERE (`pp_rubros`.`idEncabezadoRubro` ='" + idEncabezado + "'\n    AND `pp_rubros`.`TipoRubro` ='G')";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.InformesCgrDAO
    public List<Object[]> lisEjecucionGastos(String idPeriodo, String idEncabezado, String anno) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.InformesCgrDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[10];
                fila[0] = rs.getString("Tipo");
                fila[1] = rs.getString("idRubro");
                fila[2] = rs.getString("nombreRubro");
                fila[3] = rs.getString("idCodigoContraloria");
                fila[4] = rs.getString("IdConsecutivo");
                fila[5] = rs.getString("idTipoRecurso");
                fila[6] = rs.getString("idOrigenIngreso");
                fila[7] = rs.getString("idTipoDestinacion");
                fila[8] = rs.getString("idFinGasto");
                fila[9] = rs.getString("idTipoSituacion");
                fila[10] = rs.getString("CodigoEntidad");
                fila[11] = Double.valueOf(rs.getDouble("ValorCompromisoConAnticipo"));
                fila[12] = Double.valueOf(rs.getDouble("ValorCompromisoSinAnticipo"));
                fila[13] = Double.valueOf(rs.getDouble("ReversionGasto"));
                fila[14] = Double.valueOf(rs.getDouble("ValorPagos"));
                fila[15] = Double.valueOf(rs.getDouble("ValorAnulacionPagos"));
                fila[16] = Double.valueOf(rs.getDouble("ValorCuentaporPagar"));
                return fila;
            }
        };
        String sql = "SELECT 'D' Tipo    \n    , `pp_rubros`.`Id` idRubro\n    , `pp_rubros`.`Nbre` nombreRubro\n    , IFNULL(`pp_parametrizacion_cgr`.`idRubro_Contraloria`,'') AS `idCodigoContraloria`,\n1 IdConsecutivo\n, IFNULL(`pp_tipo_recursos`.`Codigo`,'') AS `idTipoRecurso`\n, IFNULL(`pp_origen_ingreso`.`Codigo`,'') AS `idOrigenIngreso`\n , IFNULL(`pp_tipo_destinacion`.`Codigo`,'') AS `idTipoDestinacion`\n    , IFNULL(`pp_finalidad_gasto`.`Codigo`,'') AS `idFinGasto`\n    , IFNULL(`pp_tipo_situacion`.`Codigo`,'') AS `idTipoSituacion`\n    , `g_empresa`.`CodigoPresupuestal` CodigoEntidad\n    , 0 ValorCompromisoConAnticipo\n    , SUM(IF(`pp_tipo_documentos`.`Id_ClaseDoc`=4, `pp_detalle_movimiento`.`Valor`, 0)) ValorCompromisoSinAnticipo\n    , 0 ReversionGasto\n    , SUM(IF(`pp_tipo_documentos`.`Id_ClaseDoc`=6, `pp_detalle_movimiento`.`Valor`, 0)) ValorPagos\n    , 0 ValorAnulacionPagos\n    , 0 ValorCuentaporPagar\nFROM\n     `pp_detalle_movimiento`\n    INNER JOIN  `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n    INNER JOIN  `pp_rubros` \n        ON (`pp_rubros`.`Id` = `pp_detalle_movimiento`.`Id_Rubro`)\n    INNER JOIN  `pp_parametrizacion_cgr` \n        ON (`pp_parametrizacion_cgr`.`idRubro` = `pp_rubros`.`Id`)\n    INNER JOIN  `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n        LEFT JOIN  `pp_tipo_recursos` \n        ON (`pp_parametrizacion_cgr`.`idTipoRecurso` = `pp_tipo_recursos`.`Id`)\n    LEFT JOIN  `pp_tipo_situacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoSituacion` = `pp_tipo_situacion`.`Id`)\n    LEFT JOIN  `pp_origen_ingreso` \n        ON (`pp_parametrizacion_cgr`.`IdOrigienIngreso` = `pp_origen_ingreso`.`Id`)\n    LEFT JOIN  `pp_tipo_destinacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoDestino` = `pp_tipo_destinacion`.`Id`)\n    LEFT JOIN  `pp_finalidad_gasto` \n        ON (`pp_parametrizacion_cgr`.`idFinGasto` = `pp_finalidad_gasto`.`Id`)\nWHERE (`pp_detalle_movimiento`.`idEncabezado` ='" + idEncabezado + "'\n    AND `pp_movimiento`.`Id_Periodo` <=" + idPeriodo + "\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1 \n    AND DATE_FORMAT(`pp_movimiento`.`FechaD`, '%Y') ='" + anno + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc` IN(4, 6))\n";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
