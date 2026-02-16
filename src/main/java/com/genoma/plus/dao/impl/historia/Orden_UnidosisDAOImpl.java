package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.Orden_UnidosisDAO;
import com.genoma.plus.dto.historia.Orden_UnidosisDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/Orden_UnidosisDAOImpl.class */
public class Orden_UnidosisDAOImpl implements Orden_UnidosisDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.Orden_UnidosisDAO
    public Long grabar(final Orden_UnidosisDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.Orden_UnidosisDAOImpl.1
            final String sql = "INSERT INTO `h_ordenes_unidosis` ( `Id_Ingreso`, `Id_Atencion`, `Fecha`, `Id_Profesional`, `Id_Especialidad`, `Tipo`, `Finalizado`, `Solicitado`, `Fecha_S`, `Estado`, `UsuarioS` )\nVALUES (?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_ordenes_unidosis` ( `Id_Ingreso`, `Id_Atencion`, `Fecha`, `Id_Profesional`, `Id_Especialidad`, `Tipo`, `Finalizado`, `Solicitado`, `Fecha_S`, `Estado`, `UsuarioS` )\nVALUES (?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdIngreso().longValue());
                ps.setLong(2, e.getIdAtencion().longValue());
                ps.setString(3, e.getFecha());
                ps.setLong(4, e.getIdProfesional().longValue());
                ps.setLong(5, e.getIdEspecialidad().longValue());
                ps.setInt(6, e.getTipo().intValue());
                ps.setBoolean(7, e.getFinalizado().booleanValue());
                ps.setBoolean(8, e.getSolicitado().booleanValue());
                ps.setString(9, e.getFechaSolicitado());
                ps.setBoolean(10, e.getEstado().booleanValue());
                ps.setString(11, e.getUsuarioSistemas());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idOrdenUnidosis = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idOrdenUnidosis;
    }

    @Override // com.genoma.plus.dao.historia.Orden_UnidosisDAO
    public void anular(Long idOrdenUnidosis) {
        String sql = "UPDATE h_ordenes_unidosis SET Estado = 0 WHERE Id = " + idOrdenUnidosis + "";
        this.jdbcTemplate.execute(sql);
    }

    @Override // com.genoma.plus.dao.historia.Orden_UnidosisDAO
    public void solicitarServicioFarmaceutico(Long idOrdenUnidosis, String fechaSolicitado) {
        String sql = "update h_ordenes_unidosis set Solicitado=1, Fecha_S='" + fechaSolicitado + "' where Id=" + idOrdenUnidosis + "";
        this.jdbcTemplate.execute(sql);
    }
}
