package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.CuestionarioDetalleDAO;
import com.genoma.plus.dto.historia.CuestionarioDetalleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/CuestionarioDetalleDAOImpl.class */
public class CuestionarioDetalleDAOImpl implements CuestionarioDetalleDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDetalleDAO
    public Long mCrear(final CuestionarioDetalleDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDetalleDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_so_cuestionario_detalle` (`Id_Cuestionario`, `Id_Pregunta`, `Id_Respuesta`, `ValorR`, `ValorC`, `Observacion`, `UsuarioS`)  VALUES (?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_so_cuestionario_detalle` (`Id_Cuestionario`, `Id_Pregunta`, `Id_Respuesta`, `ValorR`, `ValorC`, `Observacion`, `UsuarioS`)  VALUES (?,?,?,?,?,?,?)", 1);
                ps.setLong(1, e.getIdCuestionario().longValue());
                ps.setLong(2, e.getIdPregunta().longValue());
                ps.setLong(3, e.getIdRespuesta().longValue());
                ps.setString(4, e.getValorR());
                ps.setLong(5, e.getValorC().longValue());
                ps.setString(6, e.getObservacion());
                ps.setString(7, e.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long xIdCuestionarioDetalle = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return xIdCuestionarioDetalle;
    }
}
