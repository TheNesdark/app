package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO;
import com.genoma.plus.dto.historia.ValeRiesgoGeneralesDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeRiesgosGeneralesDAOImpl.class */
public class ValeRiesgosGeneralesDAOImpl implements ValeRiesgoGeneralesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO
    public List<Object[]> listariesgoGenerales(int idAtencion) {
        String sql;
        if (idAtencion == 0) {
            sql = "SELECT\n    IFNULL(`h_vale_riesgo_generales`.`id`,0) AS id\n    , `h_p_vale_pregutas`.`id`\n    , `h_p_vale_rango_edad`.`rango`    , `h_p_vale_pregutas`.`pregunta`\n    , `h_vale_riesgo_generales`.`id_atencion`\n    , ifnull(`h_vale_riesgo_generales`.`observacion`,' ') as observacion    , ifnull(`h_vale_riesgo_generales`.`respuesta`,0) as respuesta \nFROM\n    `baseserver`.`h_p_vale_pregutas`\n    LEFT JOIN `baseserver`.`h_vale_riesgo_generales` \n        ON (`h_p_vale_pregutas`.`id` = `h_vale_riesgo_generales`.`id_pregunta`)AND (`h_vale_riesgo_generales`.`id_atencion`=" + idAtencion + ") INNER JOIN `baseserver`.`h_p_vale_rango_edad` \n        ON (`h_p_vale_rango_edad`.`id` = `h_p_vale_pregutas`.`id_rango`);";
        } else {
            sql = "SELECT\n    IFNULL(`h_vale_riesgo_generales`.`id`,0) AS id \n    , `h_p_vale_pregutas`.`id`\n    , `h_p_vale_rango_edad`.`rango`    , `h_p_vale_pregutas`.`pregunta`\n    , `h_vale_riesgo_generales`.`id_atencion`    , `h_vale_riesgo_generales`.`observacion`\n    , `h_vale_riesgo_generales`.`respuesta`\nFROM\n    `baseserver`.`h_p_vale_pregutas`\n    LEFT JOIN `baseserver`.`h_vale_riesgo_generales` \n        ON (`h_p_vale_pregutas`.`id` = `h_vale_riesgo_generales`.`id_pregunta`) INNER JOIN `baseserver`.`h_p_vale_rango_edad` \n        ON (`h_p_vale_rango_edad`.`id` = `h_p_vale_pregutas`.`id_rango`)WHERE(`h_vale_riesgo_generales`.`id_atencion` = " + idAtencion + " );";
        }
        System.out.println("este es el listado ----------------------------------> " + sql);
        RowMapper mapper = (rs, arg1) -> {
            Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), rs.getString(4), Integer.valueOf(rs.getInt(5)), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
            return fila;
        };
        List<Object[]> listaRiesgoGenerales = this.jdbcTemplate.query(sql, mapper);
        return listaRiesgoGenerales;
    }

    @Override // com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO
    public void create(ValeRiesgoGeneralesDTO valeRiesgoGeneralesDTO) {
        this.jdbcTemplate.update("INSERT INTO `h_vale_riesgo_generales` (`id_pregunta`,`id_atencion`,`respuesta`,`estado`,`id_usuario`,`observacion`)\n         VALUES (?,?,?,?,?,?);", new Object[]{Integer.valueOf(valeRiesgoGeneralesDTO.getIdPregunta()), Integer.valueOf(valeRiesgoGeneralesDTO.getIdAtencion()), Boolean.valueOf(valeRiesgoGeneralesDTO.isRespuesta()), Boolean.valueOf(valeRiesgoGeneralesDTO.isEstado()), Long.valueOf(valeRiesgoGeneralesDTO.getIdUsuario()), valeRiesgoGeneralesDTO.getObservacion()});
        System.out.println("---------------------------------------------------------------------------------------------------------------> INSERT INTO `h_vale_riesgo_generales` (`id_pregunta`,`id_atencion`,`respuesta`,`estado`,`id_usuario`,`observacion`)\n         VALUES (?,?,?,?,?,?);");
    }

    @Override // com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO
    public void update(ValeRiesgoGeneralesDTO valeRiesgoGeneralesDTO) {
        this.jdbcTemplate.update("UPDATE `h_vale_riesgo_generales` SET `id_pregunta`=?,`id_atencion`=?,`respuesta`=?,`estado`=?,`id_usuario`=?,`observacion`=? WHERE `id`=?;", new Object[]{Integer.valueOf(valeRiesgoGeneralesDTO.getIdPregunta()), Integer.valueOf(valeRiesgoGeneralesDTO.getIdAtencion()), Boolean.valueOf(valeRiesgoGeneralesDTO.isRespuesta()), Boolean.valueOf(valeRiesgoGeneralesDTO.isEstado()), Long.valueOf(valeRiesgoGeneralesDTO.getIdUsuario()), valeRiesgoGeneralesDTO.getObservacion(), Integer.valueOf(valeRiesgoGeneralesDTO.getId())});
    }

    @Override // com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO
    public int verificarExistencia(String idAtencion) {
        String sql = "SELECT `id_atencion` FROM `h_vale_riesgo_generales`  WHERE `id_atencion` = " + idAtencion + "";
        RowMapper mapper = (rs, arg1) -> {
            Object[] fila = new Object[1];
            return fila;
        };
        List<Object> lista = this.jdbcTemplate.query(sql, mapper);
        return lista.size();
    }

    @Override // com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO
    public List<Object[]> obtenerRango(Integer dias) {
        String sql = "SELECT `id` FROM `p_vale_reporte_padre_rangos` WHERE(`dias_inicio`<= " + dias + " AND `dias_fin` >= " + dias + ")";
        RowMapper mapper = (rs, arg1) -> {
            Object[] fila = {Integer.valueOf(rs.getInt(1))};
            return fila;
        };
        List<Object[]> resultado = this.jdbcTemplate.query(sql, mapper);
        return resultado;
    }
}
