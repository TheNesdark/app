package com.genoma.plus.dao.impl.sig;

import Acceso.Principal;
import com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeMorbilidadEDADAOImpl1.class */
public class InformeMorbilidadEDADAOImpl1 implements InformeMorbilidadEDADAO1 {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListHospitalizacion1(String xFechaI, String xFechaF) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(2)\n    AND(g_patologia.`Id` LIKE 'A00%' OR g_patologia.`Id` LIKE 'A01%' OR g_patologia.`Id` LIKE 'A02%' OR g_patologia.`Id` LIKE 'A03%'\n    OR g_patologia.`Id` LIKE 'A04%' OR g_patologia.`Id` LIKE 'A05%' OR g_patologia.`Id` LIKE 'A06%' OR g_patologia.`Id` LIKE 'A07%'\n    OR g_patologia.`Id` LIKE 'A08%' OR g_patologia.`Id` LIKE 'A09%')\n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        } else {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(2)\n    AND( g_patologia.`Id` LIKE 'K591%' )\n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListHospitalizacion2(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        String sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' AND g_patologia.`Id`<>'0000' AND ingreso.`Id_TipoAtencion`IN(2))) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListMuertes1(String xFechaI, String xFechaF) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    \n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `h_egreso_atencion`\n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     \n    INNER JOIN `baseserver`.`g_patologia` \n    ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)           \n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' \n    AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(1,3)\n    AND(g_patologia.`Id` LIKE 'A00%' OR g_patologia.`Id` LIKE 'A01%' OR g_patologia.`Id` LIKE 'A02%' OR g_patologia.`Id` LIKE 'A03%'\n    OR g_patologia.`Id` LIKE 'A04%' OR g_patologia.`Id` LIKE 'A05%' OR g_patologia.`Id` LIKE 'A06%' OR g_patologia.`Id` LIKE 'A07%'\n    OR g_patologia.`Id` LIKE 'A08%' OR g_patologia.`Id` LIKE 'A09%') AND h_egreso_atencion.`EstodoS`='2' \n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        } else {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    \n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `h_egreso_atencion`\n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     \n    INNER JOIN `baseserver`.`g_patologia` \n    ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)           \n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' \n    AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(1,3)\n    AND( g_patologia.`Id` LIKE 'K591%' ) AND h_egreso_atencion.`EstodoS`='2' \n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListMuertes2(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        String sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    \n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `h_egreso_atencion`\n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     \n    INNER JOIN `baseserver`.`g_patologia` \n    ON (`h_egreso_atencion`.`DxMuerte` = `g_patologia`.`Id`)           \n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' \n    AND g_patologia.`Id`<>'0000' \n   -- AND ingreso.`Id_TipoAtencion`IN(1,3)\n   -- AND( g_patologia.`Id` LIKE 'K591%' ) AND h_egreso_atencion.`EstodoS`='2' \n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListMorbilidad1(String xFechaI, String xFechaF) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' \n    AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(1,3)\n    AND(g_patologia.`Id` LIKE 'A00%' OR g_patologia.`Id` LIKE 'A01%' OR g_patologia.`Id` LIKE 'A02%' OR g_patologia.`Id` LIKE 'A03%'\n    OR g_patologia.`Id` LIKE 'A04%' OR g_patologia.`Id` LIKE 'A05%' OR g_patologia.`Id` LIKE 'A06%' OR g_patologia.`Id` LIKE 'A07%'\n    OR g_patologia.`Id` LIKE 'A08%' OR g_patologia.`Id` LIKE 'A09%')\n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        } else {
            sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' \n    AND g_patologia.`Id`<>'0000' \n    AND ingreso.`Id_TipoAtencion`IN(1,3)\n    AND( g_patologia.`Id` LIKE 'K591%' )\n    )) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1
    public List<Object[]> ListMOrbilidad2(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(2), rs.getString(1)};
                return fila;
            }
        };
        String sql = "SELECT \n f.RangoT\n , LPAD(COUNT(f.Rango),6,' ') Cantidad\nFROM (SELECT \n\tIF(d.EdadD<=360, 1, IF((d.EdadD>360 AND d.EdadD<=729),2,IF((d.EdadD>729 AND d.EdadD<=1459),3\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),4,IF((d.EdadD>6934 AND d.EdadD<=14235),5\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),6,7)))))) Rango\n\t,IF(d.EdadD<=360, '<1', IF((d.EdadD>360 AND d.EdadD<=729),'1',IF((d.EdadD>729 AND d.EdadD<=1459),'2 a 4'\n\t,IF((d.EdadD>1459 AND d.EdadD<=6934),'5 a 19',IF((d.EdadD>6934 AND d.EdadD<=14235),'20 a 39'\n\t,IF((d.EdadD>14235 AND d.EdadD<=21534),'40 a 59','>=60')))))) RangoT\n\t, d.EdadD\nFROM (\nSELECT    \n    DATEDIFF(`h_atencion`.`Fecha_Atencion`,`g_persona`.`FechaNac`) AS `EdadD`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + xFechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + xFechaF + "' AND g_patologia.`Id`<>'0000' AND ingreso.`Id_TipoAtencion`IN(1,3))) d\nORDER BY  Rango ASC   \n    ) f\n    \n    GROUP BY f.Rango;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
