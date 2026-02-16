package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.TipoAntecedentesPsiquiatricosDAO;
import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoAntecedentesPsiquiatricosDAOImpl.class */
public class TipoAntecedentesPsiquiatricosDAOImpl implements TipoAntecedentesPsiquiatricosDAO {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "INSERT INTO `g_tipo_antecedentes_fisico_psiquiatricos` (`Tipo_Antecedente`,`Estado`,`UsuarioS`)VALUES(?,?,?);";
    private static final String SQL_UPDATE = "UPDATE `g_tipo_antecedentes_fisico_psiquiatricos` SET `Tipo_Antecedente` = ?,`Estado` = ?,`UsuarioS` = ? WHERE `Id` = ?;";
    private static final String SQL_READALL = "SELECT `Id`,`Tipo_Antecedente`,`Estado` FROM `g_tipo_antecedentes_fisico_psiquiatricos`";

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoAntecedentesPsiquiatricosDAO
    public List<TipoAntecedentesPsiquiatricosDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoAntecedentesPsiquiatricosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoAntecedentesPsiquiatricosDTO antecedentePsiq = new TipoAntecedentesPsiquiatricosDTO();
                antecedentePsiq.setId(rs.getInt("Id"));
                antecedentePsiq.setTipoAntecedente(rs.getString("Tipo_Antecedente"));
                antecedentePsiq.setEstado(rs.getInt("Estado"));
                return antecedentePsiq;
            }
        };
        List<TipoAntecedentesPsiquiatricosDTO> listAntecedente = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        System.out.println("SQL Lista antecedentes --> SELECT `Id`,`Tipo_Antecedente`,`Estado` FROM `g_tipo_antecedentes_fisico_psiquiatricos`");
        return listAntecedente;
    }

    @Override // com.genoma.plus.dao.general.TipoAntecedentesPsiquiatricosDAO
    public String create(final TipoAntecedentesPsiquiatricosDTO antecedente) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.general.TipoAntecedentesPsiquiatricosDAOImpl.2
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(TipoAntecedentesPsiquiatricosDAOImpl.SQL_INSERT, 1);
                ps.setString(1, antecedente.getTipoAntecedente().toUpperCase());
                ps.setInt(2, antecedente.getEstado());
                ps.setString(3, antecedente.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String idAntecedente = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("Id Tipo Antecedente --> " + idAntecedente);
        System.out.println("SQL INSERT --> INSERT INTO `g_tipo_antecedentes_fisico_psiquiatricos` (`Tipo_Antecedente`,`Estado`,`UsuarioS`)VALUES(?,?,?);");
        return idAntecedente;
    }

    @Override // com.genoma.plus.dao.general.TipoAntecedentesPsiquiatricosDAO
    public String update(TipoAntecedentesPsiquiatricosDTO antecedente) {
        String resultado = "Se actualizó Correctamente";
        int ctos = this.jdbcTemplate.update(SQL_UPDATE, new Object[]{antecedente.getTipoAntecedente(), Integer.valueOf(antecedente.getEstado()), antecedente.getUsuarioS(), Integer.valueOf(antecedente.getId())});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        System.out.println("SQL UPDATE --> UPDATE `g_tipo_antecedentes_fisico_psiquiatricos` SET `Tipo_Antecedente` = ?,`Estado` = ?,`UsuarioS` = ? WHERE `Id` = ?;");
        return resultado;
    }
}
