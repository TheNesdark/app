package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.EjecucionPresupuestalPorFechaDAO;
import com.genoma.plus.dto.sgc.EjecucionPresupuestalPorFechaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/EjecucionPresupuestalPorFechaDAOImpl.class */
public class EjecucionPresupuestalPorFechaDAOImpl implements EjecucionPresupuestalPorFechaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.EjecucionPresupuestalPorFechaDAO
    public List<Object[]> mEjecusionPresupuestal(EjecucionPresupuestalPorFechaDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.EjecucionPresupuestalPorFechaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[8];
                for (int i = 0; i < 8; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String concat = "";
        if (!dto.getFiltroCombo().isEmpty()) {
            concat = " `pp_movimiento`.`Id_TipoDoc` = '" + dto.getFiltroCombo() + "' AND ";
        }
        String sql = "SELECT\n   `pp_movimiento`.`FechaD` \n    ,`pp_movimiento`.`NoConcecutivo`\n    ,`pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre` AS rubro\n    , `g_empresa`.`No_identificacion`\n    , IF(`g_empresa`.`Nbre`= '', CONCAT(`g_empresa`.`Nombre1`,' ', `g_empresa`.`Nombre2`,' ', `g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`),`g_empresa`.`Nbre`) AS nombre\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_detalle_movimiento`.`Observacion`\nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `pp_detalle_movimiento`.`Id_Tercero`)\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_rubros`.`Id` = `pp_detalle_movimiento`.`Id_Rubro`)\n        WHERE ( " + concat + " FechaD >= '" + dto.getFechaInicio() + "'   AND FechaD<= '" + dto.getFechaFinal() + "' ); ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.EjecucionPresupuestalPorFechaDAO
    public List<Object[]> mCargarCombo(EjecucionPresupuestalPorFechaDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.EjecucionPresupuestalPorFechaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n   pp_tipo_documentos.`Id`\n  ,pp_tipo_documentos.`Nbre`\nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `pp_detalle_movimiento`.`Id_Tercero`)\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_rubros`.`Id` = `pp_detalle_movimiento`.`Id_Rubro`)\n        WHERE ( FechaD >= '" + dto.getFechaInicio() + "'  AND  FechaD<= '" + dto.getFechaFinal() + "' ) \n        GROUP BY pp_tipo_documentos.`Id`\n        ORDER BY pp_tipo_documentos.`Id` ASC; ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
