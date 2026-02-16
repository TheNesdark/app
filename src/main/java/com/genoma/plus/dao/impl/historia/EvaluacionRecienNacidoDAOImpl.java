package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.EvaluacionRecienNacidoDAO;
import com.genoma.plus.dto.historia.EvaluacionRecienNacidoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/EvaluacionRecienNacidoDAOImpl.class */
public class EvaluacionRecienNacidoDAOImpl implements EvaluacionRecienNacidoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.EvaluacionRecienNacidoDAO
    public List<EvaluacionRecienNacidoDTO> listaEvaluacionRecienNacido(String idAtencion) {
        String sql = "SELECT `id`,`id_atencion`,`descripcion`,`id_usuarioS` FROM `h_evaluacion_reciennacido` WHERE `id_atencion`=" + idAtencion + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EvaluacionRecienNacidoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                EvaluacionRecienNacidoDTO eReciennacido = EvaluacionRecienNacidoDTO.builder().id(rs.getInt(1)).idAtencion(rs.getString(2)).observacion(rs.getString(3)).build();
                return eReciennacido;
            }
        };
        List<EvaluacionRecienNacidoDTO> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.historia.EvaluacionRecienNacidoDAO
    public String create(EvaluacionRecienNacidoDTO evaluacionRecienNacidoDTO) {
        String resultado = "Se inserto correctamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_evaluacion_reciennacido` (`id_atencion`,`descripcion`,`id_usuarioS`) VALUES (?,?,?);", new Object[]{evaluacionRecienNacidoDTO.getIdAtencion(), evaluacionRecienNacidoDTO.getObservacion(), Long.valueOf(evaluacionRecienNacidoDTO.getIdUsuario())});
        if (ctos == 0) {
            resultado = "No se inserto correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.EvaluacionRecienNacidoDAO
    public String update(EvaluacionRecienNacidoDTO evaluacionRecienNacidoDTO) {
        String resultado = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_evaluacion_reciennacido` SET `id_atencion`=?,`descripcion`=?,`id_usuarioS`=? WHERE `id`=?;", new Object[]{evaluacionRecienNacidoDTO.getIdAtencion(), evaluacionRecienNacidoDTO.getObservacion(), Long.valueOf(evaluacionRecienNacidoDTO.getIdUsuario()), Integer.valueOf(evaluacionRecienNacidoDTO.getId())});
        if (ctos == 0) {
            resultado = "No se actualizo correctamente";
        }
        return resultado;
    }
}
