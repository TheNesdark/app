package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_SuspensionDAO;
import com.genoma.plus.dto.historia.Orden_Unidosis_Detalle_SuspensionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/Orden_Unidosis_Detalle_SuspensionDAOImpl.class */
public class Orden_Unidosis_Detalle_SuspensionDAOImpl implements Orden_Unidosis_Detalle_SuspensionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_SuspensionDAO
    public Long grabar(final Orden_Unidosis_Detalle_SuspensionDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.Orden_Unidosis_Detalle_SuspensionDAOImpl.1
            final String sql = "INSERT INTO `h_ordenes_unidosis_detalle_suspension` (`idDetalleUnidosis` , `fechaSuspension` , `observacion` , `idProfesional` , `idEspecialidad` , `estado` , `fecha`)\nVALUES (?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_ordenes_unidosis_detalle_suspension` (`idDetalleUnidosis` , `fechaSuspension` , `observacion` , `idProfesional` , `idEspecialidad` , `estado` , `fecha`)\nVALUES (?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdDetalleUnidosis().longValue());
                ps.setString(2, e.getFechaSuspension());
                ps.setString(3, e.getObservacion());
                ps.setLong(4, e.getIdProfesional().longValue());
                ps.setLong(5, e.getIdEspecialidad().longValue());
                ps.setBoolean(6, e.getEstado().booleanValue());
                ps.setString(7, e.getFecha());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idOrdenDetalleUnidosisSuspension = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idOrdenDetalleUnidosisSuspension;
    }
}
