package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.Orden_Unidosis_DetalleDAO;
import com.genoma.plus.dto.historia.Orden_Unidosis_DetalleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/Orden_Unidosis_DetalleDAOImpl.class */
public class Orden_Unidosis_DetalleDAOImpl implements Orden_Unidosis_DetalleDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.Orden_Unidosis_DetalleDAO
    public Long grabar(final Orden_Unidosis_DetalleDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.Orden_Unidosis_DetalleDAOImpl.1
            final String sql = "INSERT INTO `h_ordenes_unidosis_detalle` (`Id_Ordenes` , `Id_Suministro` , `Infusion` , `Dosis` , `via` , `Frecuencia`  , `DosisN`\n    , `FrecuenciaN` , `tipoFecuencia` , `DuracionD` , `Cantidad` , `CDetalle` , `Observacion` , `Id_Salida`  , `Aplicado` , `Cerrada` )\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_ordenes_unidosis_detalle` (`Id_Ordenes` , `Id_Suministro` , `Infusion` , `Dosis` , `via` , `Frecuencia`  , `DosisN`\n    , `FrecuenciaN` , `tipoFecuencia` , `DuracionD` , `Cantidad` , `CDetalle` , `Observacion` , `Id_Salida`  , `Aplicado` , `Cerrada` )\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdOrdenes().longValue());
                ps.setLong(2, e.getIdSuministro().longValue());
                ps.setBoolean(3, e.getInfusion().booleanValue());
                ps.setString(4, e.getDosisTexto());
                ps.setString(5, e.getViaAdministracion());
                ps.setString(6, e.getFrecuenciaTexto());
                ps.setDouble(7, e.getDosisNumerica().doubleValue());
                ps.setDouble(8, e.getFrecuenciaNumerica().doubleValue());
                ps.setString(9, e.getTipoFecuencia());
                ps.setDouble(10, e.getDuracionNumerica().doubleValue());
                ps.setDouble(11, e.getCantidad().doubleValue());
                ps.setDouble(12, e.getCDetalle().doubleValue());
                ps.setString(13, e.getObservacion());
                ps.setLong(14, e.getIdSalida().longValue());
                ps.setBoolean(15, e.getAplicado().booleanValue());
                ps.setBoolean(16, e.getCerrada().booleanValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idOrdenDetalleUnidosis = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idOrdenDetalleUnidosis;
    }
}
