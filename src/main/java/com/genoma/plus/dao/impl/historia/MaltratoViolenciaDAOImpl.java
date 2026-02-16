package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.MaltratoViolenciaDAO;
import com.genoma.plus.dto.historia.MaltratoViolenciaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/MaltratoViolenciaDAOImpl.class */
public class MaltratoViolenciaDAOImpl implements MaltratoViolenciaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.MaltratoViolenciaDAO
    public List<MaltratoViolenciaDTO> listMaltrato(String xIdPersona) {
        String sql = "SELECT\n    `h_atencion_maltrato_violencia_atencion`.`Id`\n    , `h_atencion_maltrato_violencia_atencion`.`Id_Atencion`\n    , `h_atencion_maltrato_violencia_atencion`.`FechaA`\n    , `h_atencion_maltrato_violencia_atencion`.`P1`\n    , `h_atencion_maltrato_violencia_atencion`.`Detalle_P1`\n    , `h_atencion_maltrato_violencia_atencion`.`P2`\n    , `h_atencion_maltrato_violencia_atencion`.`Detalle_P2`\n    , `h_atencion_maltrato_violencia_atencion`.`P3`\n    , `h_atencion_maltrato_violencia_atencion`.`Detalle_P3`\n    , `h_atencion_maltrato_violencia_atencion`.`P4`\n    , `h_atencion_maltrato_violencia_atencion`.`Detalle_P4`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n    `h_atencion_maltrato_violencia_atencion`\n    INNER JOIN `h_atencion` \n        ON (`h_atencion_maltrato_violencia_atencion`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_atencion_maltrato_violencia_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion_maltrato_violencia_atencion`.`Id_Especialidad`)\nWHERE (`h_atencion_maltrato_violencia_atencion`.`Estado` =1\n    AND `ingreso`.`Id_Usuario` ='" + xIdPersona + "')ORDER BY `h_atencion_maltrato_violencia_atencion`.`Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.MaltratoViolenciaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                MaltratoViolenciaDTO xMaltrato = new MaltratoViolenciaDTO();
                xMaltrato.setId(Long.valueOf(rs.getLong("Id")));
                xMaltrato.setIdAtencion(Long.valueOf(rs.getLong("Id_Atencion")));
                xMaltrato.setFecha(rs.getString("FechaA"));
                xMaltrato.setP1(rs.getInt("P1"));
                xMaltrato.setDetalleP1(rs.getString("Detalle_P1"));
                xMaltrato.setP2(rs.getInt("P2"));
                xMaltrato.setDetalleP2(rs.getString("Detalle_P2"));
                xMaltrato.setP3(rs.getInt("P3"));
                xMaltrato.setDetalleP3(rs.getString("Detalle_P3"));
                xMaltrato.setP4(rs.getInt("P4"));
                xMaltrato.setDetalleP4(rs.getString("Detalle_P4"));
                xMaltrato.setIdProfesional(rs.getString("NProfesional"));
                xMaltrato.setIdEspecialidad(rs.getString("Especialidad"));
                return xMaltrato;
            }
        };
        List<MaltratoViolenciaDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.historia.MaltratoViolenciaDAO
    public String create_return_id(final MaltratoViolenciaDTO xMaltrato) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.MaltratoViolenciaDAOImpl.2
            final String sql = "INSERT INTO `h_atencion_maltrato_violencia_atencion` (`Id_Atencion`,`FechaA`,`P1`,`Detalle_P1`,`P2`,`Detalle_P2`,`P3`,`Detalle_P3`,`P4`,`Detalle_P4`,`Id_Especialidad`,`Id_Profesional`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_atencion_maltrato_violencia_atencion` (`Id_Atencion`,`FechaA`,`P1`,`Detalle_P1`,`P2`,`Detalle_P2`,`P3`,`Detalle_P3`,`P4`,`Detalle_P4`,`Id_Especialidad`,`Id_Profesional`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, xMaltrato.getIdAtencion().longValue());
                ps.setString(2, xMaltrato.getFecha());
                ps.setInt(3, xMaltrato.getP1());
                ps.setString(4, xMaltrato.getDetalleP1());
                ps.setInt(5, xMaltrato.getP2());
                ps.setString(6, xMaltrato.getDetalleP2());
                ps.setInt(7, xMaltrato.getP3());
                ps.setString(8, xMaltrato.getDetalleP3());
                ps.setInt(9, xMaltrato.getP4());
                ps.setString(10, xMaltrato.getDetalleP4());
                ps.setString(11, xMaltrato.getIdEspecialidad());
                ps.setString(12, xMaltrato.getIdProfesional());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdMaltrato = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdMaltrato-->" + xIdMaltrato);
        return xIdMaltrato;
    }
}
