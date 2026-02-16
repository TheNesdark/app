package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeRangoEdadDAO;
import com.genoma.plus.dto.historia.ValeRangoEdadDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeRangoEdadDAOImpl.class */
public class ValeRangoEdadDAOImpl implements ValeRangoEdadDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeRangoEdadDAO
    public List<Object[]> listaValeRangoEdad() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeRangoEdadDAOImpl.1
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                Object[] fila = new Object[67];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = Integer.valueOf(rs.getInt(2));
                fila[2] = Integer.valueOf(rs.getInt(3));
                fila[3] = Boolean.valueOf(rs.getBoolean(4));
                fila[4] = Integer.valueOf(rs.getInt(5));
                fila[5] = Boolean.valueOf(rs.getBoolean(6));
                return fila;
            }
        };
        List<Object[]> listaValeRangoEdad = this.jdbcTemplate.query("SELECT\n    `id`\n    , `rango`\n    , `rango_dias_inicio`\n    , `rango_dias_fin`\n    , `estado`\nFROM\n    `baseserver`.`h_p_vale_rango_edad`", mapper);
        return listaValeRangoEdad;
    }

    @Override // com.genoma.plus.dao.historia.ValeRangoEdadDAO
    public int traerRango(String fechaAtencion, String fechaCorregida) {
        int resultado;
        String sql = "SELECT    `id`\n   , `rango`\n   , `rango_dias_inicio`\n   , `rango_dias_fin`\n   FROM h_p_vale_rango_edad\nWHERE ((DATEDIFF('" + fechaAtencion + "', '" + fechaCorregida + "')/30)>=h_p_vale_rango_edad.`rango_dias_inicio`AND (DATEDIFF('" + fechaAtencion + "', '" + fechaCorregida + "')/30)<=h_p_vale_rango_edad.`rango_dias_fin`)";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeRangoEdadDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int rango = rs.getInt(1);
                return Integer.valueOf(rango);
            }
        };
        System.out.println("traer rango" + sql);
        try {
            resultado = ((Integer) this.jdbcTemplate.query(sql, mapper).get(0)).intValue();
        } catch (Exception e) {
            resultado = -1;
            System.out.println("la edad no tiene rango");
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.ValeRangoEdadDAO
    public String mCreate(ValeRangoEdadDTO valeRangoEdadDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_p_vale_rango_edad` (`rango`,`rango_dias_inicio`,`rango_dias_fin`,`estado`,`id_usuario`) VALUES (?,?,?,?,?);", new Object[]{valeRangoEdadDTO.getRango(), Integer.valueOf(valeRangoEdadDTO.getRangoDiasInicio()), Integer.valueOf(valeRangoEdadDTO.getRangoDiasFin()), Boolean.valueOf(valeRangoEdadDTO.isEstado()), Integer.valueOf(valeRangoEdadDTO.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.ValeRangoEdadDAO
    public String mUpdate(ValeRangoEdadDTO valeRangoEdadDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_p_vale_rango_edad` SET `rango`=?,`rango_dias_inicio`=?,`rango_dias_fin`=?,`estado`=?,`id_usuario`=?,`fecha`=?, WHERE `id`=?", new Object[]{valeRangoEdadDTO.getRango(), Integer.valueOf(valeRangoEdadDTO.getRangoDiasInicio()), Integer.valueOf(valeRangoEdadDTO.getRangoDiasFin()), Boolean.valueOf(valeRangoEdadDTO.isEstado()), Integer.valueOf(valeRangoEdadDTO.getIdUsuario()), valeRangoEdadDTO.getFecha(), Integer.valueOf(valeRangoEdadDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
