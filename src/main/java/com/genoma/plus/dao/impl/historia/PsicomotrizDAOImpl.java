package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import com.genoma.plus.dao.historia.PsicomotrizDAO;
import com.genoma.plus.dto.historia.PsicomotrizDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PsicomotrizDAOImpl.class */
public class PsicomotrizDAOImpl implements PsicomotrizDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PsicomotrizDAO
    public List<PsicomotrizDTO> listPsicomotriz(String xIdPersona) {
        String sql = "SELECT\n    `h_so_test_psicomotriz`.`Id`\n    , `h_so_test_psicomotriz`.`Id_Atencion`\n    , `h_so_test_psicomotriz`.`FechaA`\n    , `h_so_test_psicomotriz`.`ACP1`\n    , `h_so_test_psicomotriz`.`ACP2`\n    , `h_so_test_psicomotriz`.`ACP3`\n    , `h_so_test_psicomotriz`.`RM1`\n    , `h_so_test_psicomotriz`.`RM2`\n    , `h_so_test_psicomotriz`.`RM3`\n    , `h_so_test_psicomotriz`.`RF1`\n    , `h_so_test_psicomotriz`.`CM1`\n    , `h_so_test_psicomotriz`.`CM2`\n    , `h_so_test_psicomotriz`.`VA1`\n    , `h_so_test_psicomotriz`.`Aprobado`\n    , `h_so_test_psicomotriz`.`Observacion`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_so_test_psicomotriz`.`Resultado`\nFROM\n    `h_so_test_psicomotriz`\n    INNER JOIN `h_atencion` \n        ON (`h_so_test_psicomotriz`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_so_test_psicomotriz`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_so_test_psicomotriz`.`Id_Especialdiad`)\nWHERE (`h_so_test_psicomotriz`.`Estado` =1\n    AND `ingreso`.`Id_Usuario` ='" + xIdPersona + "')ORDER BY `h_so_test_psicomotriz`.`Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PsicomotrizDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PsicomotrizDTO xpsicometrico = new PsicomotrizDTO();
                xpsicometrico.setId(rs.getLong("Id"));
                xpsicometrico.setIdAtencion(rs.getLong("Id_Atencion"));
                xpsicometrico.setFechaA(rs.getString("FechaA"));
                xpsicometrico.setAcp1(rs.getDouble("ACP1"));
                xpsicometrico.setAcp2(rs.getDouble("ACP2"));
                xpsicometrico.setAcp3(rs.getDouble("ACP3"));
                xpsicometrico.setRm1(rs.getDouble("RM1"));
                xpsicometrico.setRm2(rs.getDouble("RM2"));
                xpsicometrico.setRm3(rs.getDouble("RM3"));
                xpsicometrico.setRf1(rs.getDouble("RF1"));
                xpsicometrico.setCm1(rs.getDouble("CM1"));
                xpsicometrico.setCm2(rs.getDouble("CM2"));
                xpsicometrico.setVa1(rs.getDouble("VA1"));
                xpsicometrico.setAprobado(rs.getInt("Aprobado"));
                xpsicometrico.setObservacion(rs.getString("Observacion"));
                xpsicometrico.setIdProfesional(rs.getString("NProfesional"));
                xpsicometrico.setIdEspecialidad(rs.getString("Especialidad"));
                xpsicometrico.setResultado(rs.getString("Resultado"));
                return xpsicometrico;
            }
        };
        List<PsicomotrizDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.historia.PsicomotrizDAO
    public String create_return_id(final PsicomotrizDTO psicomotriz) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.PsicomotrizDAOImpl.2
            final String sql = "INSERT INTO `h_so_test_psicomotriz` (`Id_Atencion`,`FechaA`,`ACP1`,`ACP2`,`ACP3`,`RM1`,`RM2`,`RM3`,`RF1`,`CM1`,`CM2`,`VA1`,`Aprobado`,`Observacion`,`Id_Especialdiad`,`Id_Profesional`,`Estado`,`Id_UsuarioRh`,Resultado)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_so_test_psicomotriz` (`Id_Atencion`,`FechaA`,`ACP1`,`ACP2`,`ACP3`,`RM1`,`RM2`,`RM3`,`RF1`,`CM1`,`CM2`,`VA1`,`Aprobado`,`Observacion`,`Id_Especialdiad`,`Id_Profesional`,`Estado`,`Id_UsuarioRh`,Resultado)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, psicomotriz.getIdAtencion());
                ps.setString(2, psicomotriz.getFechaA());
                ps.setDouble(3, psicomotriz.getAcp1());
                ps.setDouble(4, psicomotriz.getAcp2());
                ps.setDouble(5, psicomotriz.getAcp3());
                ps.setDouble(6, psicomotriz.getRm1());
                ps.setDouble(7, psicomotriz.getRm2());
                ps.setDouble(8, psicomotriz.getRm3());
                ps.setDouble(9, psicomotriz.getRf1());
                ps.setDouble(10, psicomotriz.getCm1());
                ps.setDouble(11, psicomotriz.getCm2());
                ps.setDouble(12, psicomotriz.getVa1());
                ps.setInt(13, psicomotriz.getAprobado());
                ps.setString(14, psicomotriz.getObservacion());
                ps.setString(15, psicomotriz.getIdEspecialidad());
                ps.setString(16, psicomotriz.getIdProfesional());
                ps.setInt(17, 1);
                ps.setLong(18, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                ps.setString(19, psicomotriz.getResultado());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdPicomotriz = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdPicomotriz-->" + xIdPicomotriz);
        return xIdPicomotriz;
    }
}
