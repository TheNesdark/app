package com.genoma.plus.dao.impl.enfermeria;

import Acceso.Principal;
import com.genoma.plus.dao.enfermeria.AplicacionTratamientoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/enfermeria/AplicacionTratamientoDAOImpl.class */
public class AplicacionTratamientoDAOImpl implements AplicacionTratamientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.enfermeria.AplicacionTratamientoDAO
    public List<Object[]> detalleUnidosisAplicar(String idOrdenUnidosis) {
        String sql = "SELECT `i_suministro`.`Id` , UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS `NSuministro` \n   , CONCAT(`h_ordenes_unidosis_detalle`.`Dosis` ,' ', `h_ordenes_unidosis_detalle`.`Frecuencia`, ' ',`h_ordenes_unidosis_detalle`.`Observacion`) AS `FAplicacion`\n   ,     `h_ordenes_unidosis_detalle`.Cantidad,`h_ordenes_unidosis`.`Id` AS id_unidosis\n   -- , (`h_ordenes_unidosis_detalle`.Cantidad- IFNULL(d.SCantidad,0)) AS Ct\n,  `h_ordenes_unidosis_detalle`.Id AS Id_Detalle, IF(`i_presentacionfarmaceutica`.Facturable=0, `i_presentacionfarmaceutica`.Dosis, '') AS Dosis, h_ordenes_unidosis_detalle.DuracionD\nFROM\n     `h_ordenes_unidosis_detalle`\n    INNER JOIN  `h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN `i_concentracion`\n        ON (i_concentracion.`Id`=`i_suministro`.`IdConcentracion`)\n    INNER JOIN `i_principioactivo`\n        ON (i_principioactivo.`Id`=`i_suministro`.`IdPrincipioActivo`)\n\nWHERE (`h_ordenes_unidosis`.`Id` ='" + idOrdenUnidosis + "'\n    AND `h_ordenes_unidosis_detalle`.`Cerrada` =0\n    AND `h_ordenes_unidosis`.`Estado` =1)\n     ORDER BY `i_tipoproducto`.`Nbre` ASC, `NSuministro` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.enfermeria.AplicacionTratamientoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("NSuministro"), rs.getString("FAplicacion"), Long.valueOf(rs.getLong("Cantidad") - AplicacionTratamientoDAOImpl.this.cantidadAplicadaUnidosis(rs.getString("id_unidosis"), rs.getString("Id")).longValue()), Long.valueOf(rs.getLong("id_unidosis")), Long.valueOf(rs.getLong("Id_Detalle")), rs.getString("Dosis"), Integer.valueOf(rs.getInt("DuracionD"))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.enfermeria.AplicacionTratamientoDAO
    public Long cantidadAplicadaUnidosis(String idOrdenUnidosis, String idSuministro) {
        Long valor;
        String sql = "SELECT\n   SUM(`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`) AS `SCantidad`\n    \nFROM\n     `h_ordenes_unidosis_aplicacion_detalle`\n    INNER JOIN  `h_ordenes_unidosis_aplicacion` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`)\nWHERE (`h_ordenes_unidosis_aplicacion`.`Estado` =1\n    AND `h_ordenes_unidosis_aplicacion`.`Id_Unidosis` ='" + idOrdenUnidosis + "'\n    AND `h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` ='" + idSuministro + "'\n    AND `h_ordenes_unidosis_aplicacion_detalle`.`Estado` =1)\nGROUP BY `h_ordenes_unidosis_aplicacion`.`Id_Unidosis`, `h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro`";
        try {
            valor = (Long) this.jdbcTemplate.queryForObject(sql, Long.class);
        } catch (EmptyResultDataAccessException e) {
            valor = new Long(0L);
        }
        return valor;
    }

    @Override // com.genoma.plus.dao.enfermeria.AplicacionTratamientoDAO
    public List<Object[]> ordenUnidosisPacienteIdAtencion(String idAtencion) {
        String sql;
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            sql = "SELECT `h_ordenes_unidosis`.`Id` , `h_ordenes_unidosis`.`Fecha` , g_especialidad.`Nbre` `Especialidad` ,\nCONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2` ) `NProfesional` \n, `h_ordenes_unidosis_detalle`.`Id_Salida`, `h_ordenes_unidosis`.`Finalizado`\n, g_tipoatencion.`Nbre` AS `TATencion`\n, h_ordenes_unidosis.Solicitado \nFROM `h_ordenes_unidosis`\nINNER JOIN  `g_persona`   ON (g_persona.`Id` = `h_ordenes_unidosis`.`Id_Profesional`) \nINNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id`= `h_ordenes_unidosis`.`Id_Especialidad`) \nINNER JOIN `h_ordenes_unidosis_detalle`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) \nINNER JOIN `g_tipoatencion` ON(`g_tipoatencion`.`Id`=`h_ordenes_unidosis`.`Tipo`)\nWHERE ( `h_ordenes_unidosis`.`Estado` =1 AND `h_ordenes_unidosis`.`Id_Atencion` ='" + idAtencion + "')\nGROUP BY `h_ordenes_unidosis`.`Id` \nORDER BY `h_ordenes_unidosis`.`Fecha` DESC ";
        } else {
            sql = "SELECT `h_ordenes_unidosis`.`Id` \n, `h_ordenes_unidosis`.`Fecha` \n, ge.Nbre  `Especialidad` \n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NProfesional` ,\n`h_ordenes_unidosis_detalle`.`Id_Salida`\n, `h_ordenes_unidosis`.`Finalizado`,\ngt.Nbre AS `TATencion`,\nh_ordenes_unidosis.Solicitado \nFROM h_ordenes_unidosis \nINNER JOIN `h_ordenes_unidosis_detalle`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) \ninner join g_especialidad ge on (ge.Id=h_ordenes_unidosis.Id_Especialidad)\ninner join g_persona gp on (gp.Id=h_ordenes_unidosis.Id_Profesional)\ninner join g_tipoatencion gt on (gt.Id=h_ordenes_unidosis.Tipo)\nWHERE ( `h_ordenes_unidosis`.`Estado` =1 \nAND `h_ordenes_unidosis`.`Id_Atencion` =" + idAtencion + ") \nGROUP BY `h_ordenes_unidosis`.`Id` ORDER BY `h_ordenes_unidosis`.`Fecha` DESC ";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.enfermeria.AplicacionTratamientoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Fecha"), rs.getString("Especialidad"), rs.getString("NProfesional"), Long.valueOf(rs.getLong("Id_Salida")), Boolean.valueOf(rs.getBoolean("Finalizado")), rs.getString("TATencion"), Boolean.valueOf(rs.getBoolean("Solicitado"))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }
}
