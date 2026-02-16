package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValePreguntasDAO;
import com.genoma.plus.dto.historia.ValePreguntasDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValePreguntasDAOImpl.class */
public class ValePreguntasDAOImpl implements ValePreguntasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValePreguntasDAO
    public List<Object[]> listaValePreguntas() {
        RowMapper mapper = (rs, row) -> {
            Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), Boolean.valueOf(rs.getBoolean(6))};
            return fila;
        };
        List<Object[]> listaValePreguntas = this.jdbcTemplate.query("SELECT `id`,`id_rango`,`pregunta`,`tipo_pregunta`,`marca`,`estado` FROM `h_p_vale_pregutas`", mapper);
        return listaValePreguntas;
    }

    @Override // com.genoma.plus.dao.historia.ValePreguntasDAO
    public String mCreate(ValePreguntasDTO valePreguntasDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_p_vale_pregutas` (`id_rango`,`pregunta`,`tipo_pregunta`,`marca`,`estado`,`id_usuario`) VALUES (?,?,?,?,?,?);", new Object[]{Integer.valueOf(valePreguntasDTO.getIdRango()), valePreguntasDTO.getPregunta(), valePreguntasDTO.getTipoPregunta(), valePreguntasDTO.getMarca(), Boolean.valueOf(valePreguntasDTO.isEstado()), Integer.valueOf(valePreguntasDTO.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.ValePreguntasDAO
    public String mUpdate(ValePreguntasDTO valePreguntasDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_p_vale_pregutas` SET `id_rango`=?,`pregunta`=?,`tipo_pregunta`=?,`marca`=?,`estado`=?,`id_usuario`=?,`fecha`=?, WHERE `id`=?", new Object[]{Integer.valueOf(valePreguntasDTO.getIdRango()), valePreguntasDTO.getPregunta(), valePreguntasDTO.getTipoPregunta(), valePreguntasDTO.getMarca(), Boolean.valueOf(valePreguntasDTO.isEstado()), Integer.valueOf(valePreguntasDTO.getIdUsuario()), valePreguntasDTO.getFecha(), Integer.valueOf(valePreguntasDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.ValePreguntasDAO
    public String edad(String fecha1, String fecha2) {
        String sql = "select DATEDIFF('" + fecha2 + "', '" + fecha1 + "')";
        RowMapper mapper = (rs, i) -> {
            String res = rs.getString(1);
            return res;
        };
        String resultado = this.jdbcTemplate.query(sql, mapper).get(0).toString();
        return resultado;
    }
}
