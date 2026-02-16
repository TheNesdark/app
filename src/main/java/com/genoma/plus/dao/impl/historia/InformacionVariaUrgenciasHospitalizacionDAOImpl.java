package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/InformacionVariaUrgenciasHospitalizacionDAOImpl.class */
public class InformacionVariaUrgenciasHospitalizacionDAOImpl implements InformacionVariaUrgenciasHospitalizacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO
    public List<Object[]> listadoServiciosEspecialidad(Long idEspecialidad, Integer modulo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        if (idEspecialidad.longValue() == 382 || idEspecialidad.longValue() == 21) {
            if (modulo.intValue() == 0) {
                sql = "SELECT  DISTINCT \n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`     \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE  ingreso.`Estado`=0 order by  `g_tipoatencion`.`Nbre`  asc";
            } else {
                sql = "SELECT  DISTINCT \n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`     \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE  ingreso.`Estado`=0 AND `g_tipoatencion`.`Id`>1 order by  `g_tipoatencion`.`Nbre`  asc";
            }
        } else if (modulo.intValue() == 0) {
            if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                sql = "SELECT DISTINCT \n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`     \nFROM `ingreso`\n    INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE  ingreso.`Estado`=0 \nUNION \nSELECT DISTINCT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre` \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER  JOIN `h_notasclinicas` \n\tON (`h_atencion`.`Id` = `h_notasclinicas`.`Id_Atencion`)\n    INNER  JOIN `h_ordenes_interconsultas`\n        ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`)\nWHERE ( ingreso.`Estado`=0 ) ORDER BY Nbre ASC;";
            } else {
                sql = "SELECT  DISTINCT \n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`     \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE  ingreso.`Estado`=0 AND  ingreso.`Id_Especialidad`=" + idEspecialidad + "  \nUNION \nSELECT DISTINCT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre` \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER  JOIN `h_notasclinicas` \n\tON (`h_atencion`.`Id` = `h_notasclinicas`.`Id_Atencion`)\n    INNER  JOIN `h_ordenes_interconsultas`\n        ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`)\nWHERE ( ingreso.`Estado`=0 AND  h_ordenes_interconsultas.`Id_Especialidad`=" + idEspecialidad + ") ORDER BY Nbre ASC;";
            }
        } else if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            sql = "SELECT  DISTINCT \n`g_tipoatencion`.`Id`\n, `g_tipoatencion`.`Nbre`     \n FROM `ingreso`\n INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n INNER JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n WHERE  ingreso.`Estado`=0 AND `g_tipoatencion`.`Id`>1 \n UNION \n SELECT DISTINCT\n `g_tipoatencion`.`Id`\n , `g_tipoatencion`.`Nbre` \n FROM `ingreso`\n INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n INNER JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n INNER  JOIN `h_notasclinicas` ON (`h_atencion`.`Id` = `h_notasclinicas`.`Id_Atencion`)\n INNER  JOIN `h_ordenes_interconsultas`ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`)\n WHERE ( ingreso.`Estado`=0  AND `g_tipoatencion`.`Id`>1) ORDER BY Nbre ASC;";
        } else {
            sql = "SELECT  DISTINCT \n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`     \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE  ingreso.`Estado`=0 AND  ingreso.`Id_Especialidad`=" + idEspecialidad + " AND `g_tipoatencion`.`Id`>1 \nUNION \nSELECT DISTINCT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre` \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER  JOIN `h_notasclinicas` \n\tON (`h_atencion`.`Id` = `h_notasclinicas`.`Id_Atencion`)\n    INNER  JOIN `h_ordenes_interconsultas`\n        ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`)\nWHERE ( ingreso.`Estado`=0 AND  h_ordenes_interconsultas.`Id_Especialidad`=" + idEspecialidad + " AND `g_tipoatencion`.`Id`>1) ORDER BY Nbre ASC;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO
    public List<Object[]> listadoServiciosEspecialidadFiltroCirugia(Long idEspecialidad) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        if (idEspecialidad.longValue() == 382 || idEspecialidad.longValue() == 21) {
            sql = "SELECT d.Id, d.Nbre\nFROM (\nSELECT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`   \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `ingreso_orden_salida` \n        ON (`ingreso_orden_salida`.`Id_Ingreso` = `ingreso`.`Id`) AND (ingreso_orden_salida.`Estado`=1)\nWHERE (`ingreso_orden_salida`.`Id` IS NULL AND ingreso.`Estado`=0 and  `g_tipoatencion`.esQx=1))d\n\nGROUP BY d.Id ORDER BY d.Nbre ASC";
        } else {
            sql = "SELECT d.Id, d.Nbre, d.Id_Especialidad\nFROM (\nSELECT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre` , h_ordenes_interconsultas.`Id_Especialidad`,`g_tipoatencion`.esQx    \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `h_notasclinicas` \n\tON (`h_atencion`.`Id` = `h_notasclinicas`.`Id_Atencion`)\n    left  JOIN `h_ordenes_interconsultas`\n        ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`)\n    LEFT JOIN `ingreso_orden_salida` \n        ON (`ingreso_orden_salida`.`Id_Ingreso` = `ingreso`.`Id`) AND (ingreso_orden_salida.`Estado`=1)\nWHERE (`ingreso_orden_salida`.`Id` IS NULL AND ingreso.`Estado`=0))d\nWHERE (d.Id_Especialidad='" + idEspecialidad + "' and  d.esQx=1)\nGROUP BY d.Id, d.Id_Especialidad ORDER BY d.Nbre ASC";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO
    public List<Object[]> listadoServiciosEnfermeria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT d.Id, d.Nbre\nFROM (\nSELECT\n    `g_tipoatencion`.`Id`\n    , `g_tipoatencion`.`Nbre`   \nFROM\n    `ingreso`\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `ingreso_orden_salida` \n        ON (`ingreso_orden_salida`.`Id_Ingreso` = `ingreso`.`Id`) AND (ingreso_orden_salida.`Estado`=1)\nWHERE (`g_tipoatencion`.`Id_TipoAmbito` <>1 AND ingreso.`Estado`=0 ))d\n\nGROUP BY d.Id ORDER BY d.Nbre ASC", mapper);
        return list;
    }
}
