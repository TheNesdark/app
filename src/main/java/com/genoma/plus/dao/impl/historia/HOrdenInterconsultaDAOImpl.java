package com.genoma.plus.dao.impl.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HOrdenInterconsultaDAO;
import com.genoma.plus.dto.historia.HOrdenInterconsultaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/HOrdenInterconsultaDAOImpl.class */
public class HOrdenInterconsultaDAOImpl implements HOrdenInterconsultaDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.HOrdenInterconsultaDAO
    public Long mCrear(final HOrdenInterconsultaDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.HOrdenInterconsultaDAOImpl.1
            final String sql = "INSERT INTO `h_ordenes_interconsultas` ( `Id_Nota` , `Id_Especialidad` , `Id_Remoto` , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_ordenes_interconsultas` ( `Id_Nota` , `Id_Especialidad` , `Id_Remoto` , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdNota().longValue());
                ps.setLong(2, e.getIdEspecialidad().longValue());
                ps.setLong(3, e.getIdRemoto().longValue());
                ps.setString(4, e.getFecha());
                ps.setString(5, e.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idNotaInterconsulta = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idNotaInterconsulta;
    }
}
