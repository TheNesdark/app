package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_DilucionDAO;
import com.genoma.plus.dto.historia.Orden_Unidosis_Detalle_DilucionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/Orden_Unidosis_Detalle_DilucionDAOImpl.class */
public class Orden_Unidosis_Detalle_DilucionDAOImpl implements Orden_Unidosis_Detalle_DilucionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_DilucionDAO
    public Long grabar(final Orden_Unidosis_Detalle_DilucionDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.Orden_Unidosis_Detalle_DilucionDAOImpl.1
            final String sql = "INSERT INTO `h_ordenes_unidosis_detalle_dilucion` (`idOrdenesUnidosis` , `idSuministro` , `velocidad` , `volumen` , `forma` , `Estado` , `Fecha` , `IdUsuarioRh`)\nVALUES (?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_ordenes_unidosis_detalle_dilucion` (`idOrdenesUnidosis` , `idSuministro` , `velocidad` , `volumen` , `forma` , `Estado` , `Fecha` , `IdUsuarioRh`)\nVALUES (?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdOrdenesUnidosis().longValue());
                ps.setLong(2, e.getIdSuministro().longValue());
                ps.setDouble(3, e.getVelocidad().doubleValue());
                ps.setDouble(4, e.getVolumen().doubleValue());
                ps.setString(5, e.getFormaVelocidad());
                ps.setBoolean(6, e.getEstado().booleanValue());
                ps.setString(7, e.getFecha());
                ps.setLong(8, e.getIdUsuarioRh().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idOrdenDetalleUnidosisDilucion = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idOrdenDetalleUnidosisDilucion;
    }
}
