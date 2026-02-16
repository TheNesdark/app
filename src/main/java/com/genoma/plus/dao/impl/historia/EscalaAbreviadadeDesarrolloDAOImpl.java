package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO;
import com.genoma.plus.dto.historia.EADEvaluacionDTO;
import com.genoma.plus.dto.historia.EADEvaluacionDetalleItemsDTO;
import com.genoma.plus.dto.historia.EADEvaluacionResultadoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/EscalaAbreviadadeDesarrolloDAOImpl.class */
public class EscalaAbreviadadeDesarrolloDAOImpl implements EscalaAbreviadadeDesarrolloDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listaEscalaAbreviadadeDesarrollo(int idArea, int evaluacion) {
        String sql;
        System.out.println("evaluacion -> " + evaluacion);
        if (evaluacion > 0) {
            sql = "SELECT\n    `id`\n    , `rango_id`\n    , `area_id`\n    , `nombre`\nFROM\n    `baseserver`.`p_ead_item_area_rango`\n    WHERE ( area_id= " + idArea + ") AND id < 148  ORDER BY `orden` ASC;\n";
        } else {
            sql = "SELECT\n    `id`\n    , `rango_id`\n    , `area_id`\n    , `nombre`\nFROM\n    `baseserver`.`p_ead_item_area_rango`\n    WHERE ( area_id= " + idArea + ") and estado = 1 ORDER BY `orden` ASC;\n";
        }
        System.out.println("lista escala -> " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Integer.valueOf(rs.getInt(3)), rs.getString(4)};
                return fila;
            }
        };
        List<Object[]> listaEscalaAbreviaturadeDesarrollo = this.jdbcTemplate.query(sql, mapper);
        return listaEscalaAbreviaturadeDesarrollo;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public String edad(String fecha1, String fecha2) {
        String sql = "select DATEDIFF('" + fecha2 + "', '" + fecha1 + "')";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                String res = rs.getString(1);
                return res;
            }
        };
        String resultado = this.jdbcTemplate.query(sql, mapper).get(0).toString();
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public int traerRango(String fechaAtencion, String fechaCorregida) {
        int resultado;
        System.out.println("fechaAtencion -> " + fechaAtencion + " \n fechaCorregida -> " + fechaCorregida);
        String sql = "SELECT    `id`\n   , `nombre`\n   , `orden`\n   , `rangoInicioMes`\n   , `rangoInicioDias`\n   , `rangoFinalMes`\n   , `rangoFinalDias` FROM p_ead_rango_edad\nWHERE ((DATEDIFF('" + fechaAtencion + "', '" + fechaCorregida + "')/30)>=p_ead_rango_edad.`mesInicial`AND (DATEDIFF('" + fechaAtencion + "', '" + fechaCorregida + "')/30)<= p_ead_rango_edad.`mesFinal`)";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int rango = rs.getInt(1);
                return Integer.valueOf(rango);
            }
        };
        System.out.println("consulta rango -> " + sql);
        System.out.println("traer rango" + sql);
        try {
            resultado = ((Integer) this.jdbcTemplate.query(sql, mapper).get(0)).intValue();
        } catch (Exception e) {
            resultado = -1;
            System.out.println("la edad no tiene rango");
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public int insertarEvaluacion(EADEvaluacionDTO eADEvaluacionDTO) {
        String sql = "INSERT INTO `h_ead_evaluacion` (`atencion_id`,`fechaR`,`profesional_id`,`especialidad_id`,`rangoEdad_id`,`usuario_id`,`edadAnio`,`edadMes`,`edadDia`,`edadCronologica`,`esPrematuro`,`semanasGestacion`,`estado`,`usuarioS`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, 1);
            ps.setInt(1, eADEvaluacionDTO.getIdAtencion());
            ps.setString(2, eADEvaluacionDTO.getFechaR());
            ps.setLong(3, eADEvaluacionDTO.getIdProfesional());
            ps.setString(4, eADEvaluacionDTO.getIdEspecialidad());
            ps.setInt(5, eADEvaluacionDTO.getIdRangoEdad());
            ps.setLong(6, eADEvaluacionDTO.getIdUsuario());
            ps.setInt(7, eADEvaluacionDTO.getEdadAnio());
            ps.setInt(8, eADEvaluacionDTO.getEdadMes());
            ps.setInt(9, eADEvaluacionDTO.getEdadDia());
            ps.setString(10, eADEvaluacionDTO.getEdadCronologica());
            ps.setBoolean(11, eADEvaluacionDTO.isEsPrematuro());
            ps.setInt(12, eADEvaluacionDTO.getSemanasDeGestacion());
            ps.setBoolean(13, eADEvaluacionDTO.isEstado());
            ps.setString(14, eADEvaluacionDTO.getUsuario());
            return ps;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        int idEvaluacion = generatedKeyHolder.getKey().intValue();
        return idEvaluacion;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public String insertarEvaluacionDetallesItems(EADEvaluacionDetalleItemsDTO aDEvaluacionDetalleItemsDTO) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_ead_evaluacion_detalle_items` (`item_id`,`valor`,`evaluacion_id`,`estado`) VALUES (?,?,?,?);", new Object[]{Integer.valueOf(aDEvaluacionDetalleItemsDTO.getIdItem()), Integer.valueOf(aDEvaluacionDetalleItemsDTO.getValor()), Integer.valueOf(aDEvaluacionDetalleItemsDTO.getIdEvaluacion()), Boolean.valueOf(aDEvaluacionDetalleItemsDTO.isEstado())});
        if (ctos == 0) {
            resultado = "No se inserto correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public String insertarEvaluacionResultado(EADEvaluacionResultadoDTO aDEvaluacionResultadoDTO) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_ead_evaluacion_resultado` (`evaluacion_id`,`area_id`,`totalAcumuladoInicio`,`numeroItemsCorrectos`,`totalPuntuacionDirecta`,`totalPuntuacionTipica`,`clasificacionColor_id`) VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(aDEvaluacionResultadoDTO.getIdEvaluacion()), Integer.valueOf(aDEvaluacionResultadoDTO.getIdArea()), Integer.valueOf(aDEvaluacionResultadoDTO.getTotalAcumuladosInicio()), Integer.valueOf(aDEvaluacionResultadoDTO.getTotalPuntuacionCorrecta()), Integer.valueOf(aDEvaluacionResultadoDTO.getTotalPuntuacionDirecta()), Integer.valueOf(aDEvaluacionResultadoDTO.getTotalPutuacionTipica()), Integer.valueOf(aDEvaluacionResultadoDTO.getIdClasificacionColor())});
        if (ctos == 0) {
            resultado = "No se pudo insertar correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public int traerPuntuacionTipica(int puntuacionDirecta, int idArea, int rango) {
        String sql = "SELECT `id`,`puntuacionTipica`FROM `p_ead_conversion_pd_pt` WHERE `puntuacionDirecta`= " + puntuacionDirecta + " AND `rango_id` =" + rango + " AND `area_id` =" + idArea + ";";
        System.out.println("sql : " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int puntuacion = rs.getInt(2);
                return Integer.valueOf(puntuacion);
            }
        };
        int puntuacionTipica = ((Integer) this.jdbcTemplate.query(sql, mapper).get(0)).intValue();
        return puntuacionTipica;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public int traerColor(int puntuacionTipica, int idArea, int idRango) {
        String sql = "SELECT `color_id` FROM `p_ead_grafica_color_rango_area` WHERE `area_id`= " + idArea + " AND `rango_id`=" + idRango + " AND ( " + puntuacionTipica + " >= `rangoInicio` AND " + puntuacionTipica + " <=`rangoFin`);\t";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.5
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int idColor = rs.getInt(1);
                return Integer.valueOf(idColor);
            }
        };
        int idColor = ((Integer) this.jdbcTemplate.query(sql, mapper).get(0)).intValue();
        return idColor;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public boolean validarGuardado(int idAtencion) {
        String sql = "SELECT `id`,`atencion_id` FROM `h_ead_evaluacion` WHERE (`atencion_id`=" + idAtencion + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.6
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                return Integer.valueOf(id);
            }
        };
        List<Integer> lista = this.jdbcTemplate.query(sql, mapper);
        return lista.size() > 0;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listaFechaIngreso(int idAtencion) {
        String sql = "SELECT `ingreso`.`FechaIngreso` FROM `ingreso` JOIN `h_atencion` \n                ON `h_atencion`.`Id_Ingreso` = `ingreso`.`Id` WHERE `h_atencion`.`Id` =" + idAtencion + "; ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.7
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString(1)};
                return fila;
            }
        };
        List<Object[]> listafechaIngreso = this.jdbcTemplate.query(sql, mapper);
        return listafechaIngreso;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listaEncabezado(long idAtencion) {
        String sql = "SELECT `id`,`atencion_id`,`fechaR`,`profesional_id`,`especialidad_id`,`rangoEdad_id`,\n`usuario_id`,`edadAnio`,`edadMes`,`edadDia`,`edadCronologica`,`esPrematuro`,`semanasGestacion`,`estado`\nFROM `h_ead_evaluacion`\nWHERE `atencion_id` = " + idAtencion + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.8
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Long.valueOf(rs.getLong(2)), rs.getString(3), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), Integer.valueOf(rs.getInt(6)), Integer.valueOf(rs.getInt(7)), Integer.valueOf(rs.getInt(8)), Integer.valueOf(rs.getInt(9)), Integer.valueOf(rs.getInt(10)), rs.getString(11), Boolean.valueOf(rs.getBoolean(12)), Integer.valueOf(rs.getInt(13)), Boolean.valueOf(rs.getBoolean(14))};
                return fila;
            }
        };
        List<Object[]> listaEncabezado = this.jdbcTemplate.query(sql, mapper);
        return listaEncabezado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listaItemenes(int idEvaluacion) {
        String sql = "SELECT\n    `p_ead_item_area_rango`.`area_id`\n    , `h_ead_evaluacion_detalle_items`.`id`\n    , `h_ead_evaluacion_detalle_items`.`item_id`\n    , `h_ead_evaluacion_detalle_items`.`valor`\n    , `h_ead_evaluacion_detalle_items`.`evaluacion_id`\n    , `h_ead_evaluacion_detalle_items`.`estado`\nFROM\n    `baseserver`.`h_ead_evaluacion_detalle_items`\n    INNER JOIN `baseserver`.`p_ead_item_area_rango` \n        ON (`h_ead_evaluacion_detalle_items`.`item_id` = `p_ead_item_area_rango`.`id`)\n        WHERE (`evaluacion_id` = " + idEvaluacion + ")      ;";
        System.out.println("lista itemenes -> " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.9
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), Boolean.valueOf(rs.getBoolean(6))};
                return fila;
            }
        };
        List<Object[]> listaItemenes = this.jdbcTemplate.query(sql, mapper);
        return listaItemenes;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listResuldatdo(int idEvaluacion) {
        String sql = "SELECT `id`,`evaluacion_id`,`area_id`,`totalAcumuladoInicio`,`numeroItemsCorrectos`,`totalPuntuacionDirecta`,\n`totalPuntuacionTipica`,`clasificacionColor_id`\nFROM `h_ead_evaluacion_resultado` WHERE `evaluacion_id` = " + idEvaluacion + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.10
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), Integer.valueOf(rs.getInt(6)), Integer.valueOf(rs.getInt(7)), Integer.valueOf(rs.getInt(8))};
                return fila;
            }
        };
        List<Object[]> listaResultado = this.jdbcTemplate.query(sql, mapper);
        return listaResultado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public List<Object[]> listEncabezadoAnteriores(String idAtencion, long idUsuario) {
        String sql = "SELECT `id`,`atencion_id`,`fechaR`,`profesional_id`,`especialidad_id`,`rangoEdad_id`,\n`usuario_id`,`edadAnio`,`edadMes`,`edadDia`,`edadCronologica`,`esPrematuro`,`semanasGestacion`,`estado`\nFROM `h_ead_evaluacion`\nWHERE (`atencion_id` <= " + idAtencion + " AND `usuario_id` =" + idUsuario + " );";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.11
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Long.valueOf(rs.getLong(2)), rs.getString(3), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), Integer.valueOf(rs.getInt(6)), Integer.valueOf(rs.getInt(7)), Integer.valueOf(rs.getInt(8)), Integer.valueOf(rs.getInt(9)), Integer.valueOf(rs.getInt(10)), rs.getString(11), Boolean.valueOf(rs.getBoolean(12)), Integer.valueOf(rs.getInt(13)), Boolean.valueOf(rs.getBoolean(14))};
                return fila;
            }
        };
        List<Object[]> listaEncabezado = this.jdbcTemplate.query(sql, mapper);
        return listaEncabezado;
    }

    @Override // com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO
    public int traerEvaluacion(int idAtencion) {
        int resultado;
        String sql = "SELECT id FROM `h_ead_evaluacion` WHERE `atencion_id` = '" + idAtencion + "'";
        System.out.println("sql -> " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl.12
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int evaluacion = rs.getInt(1);
                return Integer.valueOf(evaluacion);
            }
        };
        try {
            resultado = ((Integer) this.jdbcTemplate.query(sql, mapper).get(0)).intValue();
        } catch (Exception e) {
            resultado = -1;
            System.out.println("no hay evaluacion");
        }
        return resultado;
    }
}
