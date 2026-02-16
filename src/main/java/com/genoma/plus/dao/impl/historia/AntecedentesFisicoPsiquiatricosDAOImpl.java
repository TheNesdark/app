package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO;
import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
import com.genoma.plus.dto.historia.AntecedentesFisicoPsiaquiatricosDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AntecedentesFisicoPsiquiatricosDAOImpl.class */
public class AntecedentesFisicoPsiquiatricosDAOImpl implements AntecedentesFisicoPsiquiatricosDAO {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "INSERT INTO `h_antecedentes_fisicos_psiquiatricos` (`Id_Atencion`,`Id_Usuario`,`Id_Tipo_Ante_Psiquiatrico`,`Descripcion`,`UsuarioS`)VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE `h_antecedentes_fisicos_psiquiatricos` SET `Id_Tipo_Ante_Psiquiatrico` = ?,`Descripcion` = ?,`UsuarioS` = ? WHERE `Id` = ? AND `Id_Atencion`=? AND UsuarioS=?";
    private static final String SQL_READALL = "SELECT `h_antecedentes_fisicos_psiquiatricos`.`Id`, `h_antecedentes_fisicos_psiquiatricos`.`Id_Atencion`\n    , `g_tipo_antecedentes_fisico_psiquiatricos`.`Tipo_Antecedente`, `h_antecedentes_fisicos_psiquiatricos`.`Descripcion` FROM `baseserver`.`h_antecedentes_fisicos_psiquiatricos`\n    INNER JOIN `baseserver`.`g_tipo_antecedentes_fisico_psiquiatricos` ON (`h_antecedentes_fisicos_psiquiatricos`.`Id_Tipo_Ante_Psiquiatrico` = `g_tipo_antecedentes_fisico_psiquiatricos`.`Id`)\nWHERE (`h_antecedentes_fisicos_psiquiatricos`.`Id_Usuario` =?)";
    private static final String SQL_LIST_TIPO_ANTE = "SELECT `Id`,Tipo_Antecedente FROM `g_tipo_antecedentes_fisico_psiquiatricos` WHERE Estado=1";

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO
    public String create(final AntecedentesFisicoPsiaquiatricosDTO antecedentePsiquiatrico) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesFisicoPsiquiatricosDAOImpl.1
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(AntecedentesFisicoPsiquiatricosDAOImpl.SQL_INSERT, 1);
                ps.setLong(1, antecedentePsiquiatrico.getIdAtencion());
                ps.setLong(2, antecedentePsiquiatrico.getIdUsuario());
                ps.setString(3, antecedentePsiquiatrico.getIdTipoAntecedentePsiquiatrico());
                ps.setString(4, antecedentePsiquiatrico.getDescripcion());
                ps.setString(5, antecedentePsiquiatrico.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String idAntecedente = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("Id Antecedente --> " + idAntecedente);
        System.out.println("SQL INSERT --> INSERT INTO `h_antecedentes_fisicos_psiquiatricos` (`Id_Atencion`,`Id_Usuario`,`Id_Tipo_Ante_Psiquiatrico`,`Descripcion`,`UsuarioS`)VALUES (?,?,?,?,?)");
        return idAntecedente;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO
    public List<AntecedentesFisicoPsiaquiatricosDTO> listaAntecedentesPsiquiatricos(long idUsuario) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesFisicoPsiquiatricosDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                AntecedentesFisicoPsiaquiatricosDTO antecedentePsiq = new AntecedentesFisicoPsiaquiatricosDTO();
                antecedentePsiq.setId(rs.getInt("Id"));
                antecedentePsiq.setIdAtencion(rs.getInt("Id_Atencion"));
                antecedentePsiq.setIdTipoAntecedentePsiquiatrico(rs.getString("Tipo_Antecedente"));
                antecedentePsiq.setDescripcion(rs.getString("Descripcion"));
                return antecedentePsiq;
            }
        };
        List<AntecedentesFisicoPsiaquiatricosDTO> listAntecedente = this.jdbcTemplate.query(SQL_READALL, rowMapper, new Object[]{Long.valueOf(idUsuario)});
        System.out.println("SQL Lista antecedentes --> SELECT `h_antecedentes_fisicos_psiquiatricos`.`Id`, `h_antecedentes_fisicos_psiquiatricos`.`Id_Atencion`\n    , `g_tipo_antecedentes_fisico_psiquiatricos`.`Tipo_Antecedente`, `h_antecedentes_fisicos_psiquiatricos`.`Descripcion` FROM `baseserver`.`h_antecedentes_fisicos_psiquiatricos`\n    INNER JOIN `baseserver`.`g_tipo_antecedentes_fisico_psiquiatricos` ON (`h_antecedentes_fisicos_psiquiatricos`.`Id_Tipo_Ante_Psiquiatrico` = `g_tipo_antecedentes_fisico_psiquiatricos`.`Id`)\nWHERE (`h_antecedentes_fisicos_psiquiatricos`.`Id_Usuario` =?) id Usuario --> " + idUsuario);
        return listAntecedente;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO
    public String update(AntecedentesFisicoPsiaquiatricosDTO antecedentePsiquiatrico) {
        String resultado = "Se actualizó Correctamente";
        int ctos = this.jdbcTemplate.update(SQL_UPDATE, new Object[]{antecedentePsiquiatrico.getIdTipoAntecedentePsiquiatrico(), antecedentePsiquiatrico.getDescripcion(), antecedentePsiquiatrico.getUsuarioS(), Integer.valueOf(antecedentePsiquiatrico.getId()), Long.valueOf(antecedentePsiquiatrico.getIdAtencion()), antecedentePsiquiatrico.getUsuarioS()});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        System.out.println("SQL UPDATE --> UPDATE `h_antecedentes_fisicos_psiquiatricos` SET `Id_Tipo_Ante_Psiquiatrico` = ?,`Descripcion` = ?,`UsuarioS` = ? WHERE `Id` = ? AND `Id_Atencion`=? AND UsuarioS=?");
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO
    public List<TipoAntecedentesPsiquiatricosDTO> listaTipoAntecedentesPsiquiatricos() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesFisicoPsiquiatricosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                TipoAntecedentesPsiquiatricosDTO antePsiq = new TipoAntecedentesPsiquiatricosDTO();
                antePsiq.setId(rs.getInt("Id"));
                antePsiq.setTipoAntecedente(rs.getString("Tipo_Antecedente"));
                return antePsiq;
            }
        };
        List<TipoAntecedentesPsiquiatricosDTO> list = this.jdbcTemplate.query(SQL_LIST_TIPO_ANTE, mapper);
        return list;
    }
}
