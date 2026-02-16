package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.DepresionPospartoDAO;
import com.genoma.plus.dto.historia.DepresionPospartoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/DepresionPospartoDAOImpl.class */
public class DepresionPospartoDAOImpl implements DepresionPospartoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.DepresionPospartoDAO
    public List<DepresionPospartoDTO> listDeprecion(String xIdPersona) {
        String sql = "SELECT\n    `h_atencion_depresion_posparto`.`Id`\n    , `h_atencion_depresion_posparto`.`Id_Atencion`\n    , `h_atencion_depresion_posparto`.`FechaA`\n    , `h_atencion_depresion_posparto`.`P1`\n    , `h_atencion_depresion_posparto`.`Detalle_P1`\n    , `h_atencion_depresion_posparto`.`P2`\n    , `h_atencion_depresion_posparto`.`Detalle_P2`\n    , `h_atencion_depresion_posparto`.`P3`\n    , `h_atencion_depresion_posparto`.`Detalle_P3`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n    `h_atencion_depresion_posparto`\n    INNER JOIN `h_atencion` \n        ON (`h_atencion_depresion_posparto`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_atencion_depresion_posparto`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion_depresion_posparto`.`Id_Especialidad`)\nWHERE (`h_atencion_depresion_posparto`.`Estado` =1\n    AND `ingreso`.`Id_Usuario` ='" + xIdPersona + "')ORDER BY `h_atencion_depresion_posparto`.`Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.DepresionPospartoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                DepresionPospartoDTO xDeprecion = new DepresionPospartoDTO();
                xDeprecion.setId(Long.valueOf(rs.getLong("Id")));
                xDeprecion.setIdAtencion(Long.valueOf(rs.getLong("Id_Atencion")));
                xDeprecion.setFecha(rs.getString("FechaA"));
                xDeprecion.setP1(rs.getInt("P1"));
                xDeprecion.setDetalleP1(rs.getString("Detalle_P1"));
                xDeprecion.setP2(rs.getInt("P2"));
                xDeprecion.setDetalleP2(rs.getString("Detalle_P2"));
                xDeprecion.setP3(rs.getInt("P3"));
                xDeprecion.setDetalleP3(rs.getString("Detalle_P3"));
                xDeprecion.setIdProfesional(rs.getString("NProfesional"));
                xDeprecion.setIdEspecialidad(rs.getString("Especialidad"));
                return xDeprecion;
            }
        };
        List<DepresionPospartoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.historia.DepresionPospartoDAO
    public String create_return_id(final DepresionPospartoDTO xDeprecion) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.DepresionPospartoDAOImpl.2
            final String sql = "INSERT INTO `h_atencion_depresion_posparto` (`Id_Atencion`,`FechaA`,`P1`,`Detalle_P1`,`P2`,`Detalle_P2`,`P3`,`Detalle_P3`,`Id_Especialidad`,`Id_Profesional`)\nVALUES (?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_atencion_depresion_posparto` (`Id_Atencion`,`FechaA`,`P1`,`Detalle_P1`,`P2`,`Detalle_P2`,`P3`,`Detalle_P3`,`Id_Especialidad`,`Id_Profesional`)\nVALUES (?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, xDeprecion.getIdAtencion().longValue());
                ps.setString(2, xDeprecion.getFecha());
                ps.setInt(3, xDeprecion.getP1());
                ps.setString(4, xDeprecion.getDetalleP1());
                ps.setInt(5, xDeprecion.getP2());
                ps.setString(6, xDeprecion.getDetalleP2());
                ps.setInt(7, xDeprecion.getP3());
                ps.setString(8, xDeprecion.getDetalleP3());
                ps.setString(9, xDeprecion.getIdEspecialidad());
                ps.setString(10, xDeprecion.getIdProfesional());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xidDeprecion = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xidDeprecion-->" + xidDeprecion);
        return xidDeprecion;
    }
}
