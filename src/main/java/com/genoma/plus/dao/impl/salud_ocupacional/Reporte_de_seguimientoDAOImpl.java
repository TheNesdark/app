package com.genoma.plus.dao.impl.salud_ocupacional;

import com.genoma.plus.dao.salud_ocupacional.Reporte_de_seguimientoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/Reporte_de_seguimientoDAOImpl.class */
public class Reporte_de_seguimientoDAOImpl implements Reporte_de_seguimientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.Reporte_de_seguimientoDAO
    public List<Object[]> Reporte_seguimientoDAO(String periodo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.Reporte_de_seguimientoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28)};
                return fila;
            }
        };
        String sql = "SELECT\n  `so_manporwer_detalle`.`Id`,\n  `so_manporwer_detalle`.`Cedula`,\n  concat(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) as `NUsuario`,\n  `g_cargos`.`Nbre`,\n  so_manporwer_detalle.`UnidadN`,\n  `so_tipo_segmento`.`Nbre`,\n  `so_tipo_clasificacion`.`Nbre`,\n  IF(\n    `so_manporwer_detalle`.`FechaPA` IS NULL,\n    '',\n    `so_manporwer_detalle`.`FechaPA`\n  ) AS FechaPA,\n  `so_manporwer_detalle`.`Alterado`,\n  `so_manporwer_detalle`.ConceptoI,\n  `so_manporwer_detalle`.`Id_Atencion`,\n  `so_manporwer_detalle`.`Id_Persona`,\n  `so_manporwer_detalle`.EstadoS,\n  IF(\n    `so_manporwer_detalle`.`Restricciones` IS NULL,\n    '',\n    `so_manporwer_detalle`.`Restricciones`\n  ) AS RT,\n  IF(\n    `so_manporwer_detalle`.`HConcepto` IS NULL,\n    '',\n    `so_manporwer_detalle`.`HConcepto`\n  ) AS HC,\n  `g_persona`.`Edad`,\n  `so_manporwer_detalle`.`FEntrada`,\n  `CalculaTiempo_AMD` (\n    `so_manporwer_detalle`.`FEntrada`\n  ),\n  `g_sexo`.`Nbre` AS `NSexo`\n  ,IFNULL(d.Nbre,'') AS seguimiento\n  ,IFNULL(d.`Observacion`,'') AS observacion\n  ,IFNULL(d.`NDiasS`,'') AS NDiasS\n  ,IFNULL(d.Fecha_US,'') AS FechaUS\n  ,IFNULL(d.Fecha_Cierre,'') AS Fecha_Cierre\n  ,IFNULL(d.FC,'') FC\n  ,IFNULL(d.vigilancia,'') AS vigilancia\n  , IFNULL(d.FP,'') AS  FP\n  , IFNULL (d.Canti,'') AS Canti\n  FROM\n  `so_manporwer_detalle`\n  INNER JOIN `so_manporwer_encabezado`\n    ON (\n      `so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`\n    )\n  INNER JOIN `g_persona`\n    ON (\n      `g_persona`.Id  = `so_manporwer_detalle`.`Id_Persona`\n    )\n  INNER JOIN `g_sexo`\n    ON (\n    `g_sexo`.Id=`g_persona`.Id_Sexo\n    )\n  INNER JOIN `g_usuario`\n    ON (\n      `g_usuario`.`Id_persona` =  `g_persona`.Id\n    )\n  INNER JOIN `so_tipo_segmento`\n    ON (\n      `g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`\n    )\n  INNER JOIN `g_cargos`\n    ON (\n      `g_usuario`.`Id_Cargo` = `g_cargos`.`Id`\n    )\n  INNER JOIN `so_tipo_clasificacion`\n    ON (\n      `so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`\n    )\n  LEFT JOIN\n    (SELECT\n      `so_manpower_seguimiento`.`Id_Manpower_Detalle` AS llave,\n      `so_manpower_seguimiento_detalle`.`Id`,\n      `so_tipo_vigilancia`.`Nbre`,\n      `so_manpower_seguimiento_detalle`.`Observacion`,\n      `so_manpower_seguimiento_detalle`.`NDiasS`,\n      IF(\n        `so_manpower_seguimiento_detalle`.`FechaUS` IS NULL,\n        '',\n        DATE_FORMAT(\n          `so_manpower_seguimiento_detalle`.`FechaUS`,\n          '%d-%m-%Y'\n        )\n      ) AS `Fecha_US`,\n      IF(\n        `so_manpower_seguimiento_detalle`.`FechaCierre` IS NULL,\n        '',\n        DATE_FORMAT(\n          `so_manpower_seguimiento_detalle`.`FechaCierre`,\n          '%d-%m-%Y'\n        )\n      ) AS `Fecha_Cierre`,\n      IF(\n        `so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,\n        1,\n        IF(\n          `so_manpower_seguimiento_detalle`.`FechaUS` IS NULL,\n          2,\n          IF(\n            DATEDIFF(\n              ADDDATE(\n                `so_manpower_seguimiento_detalle`.`FechaUS`,\n                INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY\n              ),\n              NOW()\n            ) <= 0,\n            3,\n            4\n          )\n        )\n      ) AS FC,\n      `so_tipo_vigilancia`.`Id` AS vigilancia,\n      DATE_FORMAT(\n        ADDDATE(\n          `so_manpower_seguimiento_detalle`.`FechaUS`,\n          INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY\n        ),\n        '%d-%m-%Y'\n      ) AS FP,\n      COUNT(\n        `so_manpower_seguimiento_detalle_s`.`Id`\n      ) AS `Canti`\n    FROM\n      `so_manpower_seguimiento_detalle`\n      INNER JOIN `so_manpower_seguimiento`\n        ON (\n          `so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`\n        )\n      LEFT JOIN `so_manpower_seguimiento_detalle_s`\n        ON (\n          `so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`\n        )\n      INNER JOIN `so_tipo_vigilancia`\n        ON (\n          `so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`\n        )\n    WHERE ( \n         `so_manpower_seguimiento_detalle`.`Estado` = 1\n      )\n    GROUP BY `so_manpower_seguimiento_detalle`.`Id`\n    ORDER BY FC ASC) d\n    ON (\n      d.llave = `so_manporwer_detalle`.`Id`\n    )\nWHERE (\n    `so_manporwer_encabezado`.`Id_Periodo` = '" + periodo + "'\n  )\nORDER BY concat(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) ASC";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.Reporte_de_seguimientoDAO
    public List<Object[]> CargarCombo() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.Reporte_de_seguimientoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `cc_periodo_financiero`.`Id`\n    , `cc_periodo_financiero`.`Nbre`\nFROM\n    `so_manporwer_encabezado`\n    INNER JOIN `cc_periodo_financiero` \n        ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`);", mapper);
        return list;
    }
}
