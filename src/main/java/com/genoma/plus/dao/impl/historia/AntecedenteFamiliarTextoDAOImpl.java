package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.AntecedenteFamiliarTextoDAO;
import com.genoma.plus.dto.historia.AntecedenteFamiliarTextoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AntecedenteFamiliarTextoDAOImpl.class */
public class AntecedenteFamiliarTextoDAOImpl implements AntecedenteFamiliarTextoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteFamiliarTextoDAO
    public Long crear(final AntecedenteFamiliarTextoDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteFamiliarTextoDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_antecedentes_familiares_texto` (`Id_Atencion` , `Descripcion` , `Estado` , `Fecha` , `IdUsuarioRh`) \nVALUES (?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_antecedentes_familiares_texto` (`Id_Atencion` , `Descripcion` , `Estado` , `Fecha` , `IdUsuarioRh`) \nVALUES (?,?,?,?,?)", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setString(2, e.getDescripcion());
                ps.setBoolean(3, e.isEstado());
                ps.setString(4, e.getFecha());
                ps.setLong(5, e.getIdUsuarioRh().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idAntecedentesFamiliares = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idAntecedentesFamiliares;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteFamiliarTextoDAO
    public List<AntecedenteFamiliarTextoDTO> antecedenteFamiliarTextoDTO(Long idAtencion) {
        String sql = "SELECT\n    `Id`\n    , `Id_Atencion`\n    , `Descripcion`\n    , `Estado`\n    , `Fecha`\n    , `IdUsuarioRh`\nFROM\n    `h_antecedentes_familiares_texto`\nWHERE (`Id_Atencion` ='" + idAtencion + "')";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteFamiliarTextoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                AntecedenteFamiliarTextoDTO g = new AntecedenteFamiliarTextoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setIdAtencion(Long.valueOf(rs.getLong("Id_Atencion")));
                g.setDescripcion(rs.getString("Descripcion"));
                g.setEstado(rs.getBoolean("Estado"));
                g.setFecha(rs.getString("Fecha"));
                g.setIdUsuarioRh(Long.valueOf(rs.getLong("IdUsuarioRh")));
                return g;
            }
        };
        List<AntecedenteFamiliarTextoDTO> lsAntReuma = this.jdbcTemplate.query(sql, rowMapper);
        return lsAntReuma;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteFamiliarTextoDAO
    public void actualizar(String idAntecedente, AntecedenteFamiliarTextoDTO e) {
        String xsql = "update h_antecedentes_familiares_texto set  `Descripcion`='" + e.getDescripcion() + "' where Id='" + idAntecedente + "'";
        this.jdbcTemplate.update(xsql);
    }
}
