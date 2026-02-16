package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AntecedenteReumatologicoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AntecedenteReumatologicoDAOImpl.class */
public class AntecedenteReumatologicoDAOImpl implements AntecedenteReumatologicoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO
    public String mCreate(final AntecedenteReumatologicoDTO xAntReuma) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteReumatologicoDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_atecedente_reumatologico` (\n  `Id_Atencion`, `Id_Usuario`,`FechaR`,`FInicio`,`FDiagnostico`,`FTratamiento`,\n  `Hta`,`Dm`,`Ecv`,`Erc`,`Osteo`,`Ss`,`Id_Especialidad`,`Id_Profesional`,`Estado`\n) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_atecedente_reumatologico` (\n  `Id_Atencion`, `Id_Usuario`,`FechaR`,`FInicio`,`FDiagnostico`,`FTratamiento`,\n  `Hta`,`Dm`,`Ecv`,`Erc`,`Osteo`,`Ss`,`Id_Especialidad`,`Id_Profesional`,`Estado`\n) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;", 1);
                ps.setLong(1, xAntReuma.getXId_Atencion());
                ps.setLong(2, xAntReuma.getXId_Usuario());
                ps.setString(3, xAntReuma.getXFechaR());
                ps.setInt(4, xAntReuma.getXFInicio());
                ps.setInt(5, xAntReuma.getXFDiagnostico());
                ps.setInt(6, xAntReuma.getXFTratamiento());
                ps.setInt(7, xAntReuma.getXHta());
                ps.setInt(8, xAntReuma.getXDm());
                ps.setInt(9, xAntReuma.getXEcv());
                ps.setInt(10, xAntReuma.getXErc());
                ps.setInt(11, xAntReuma.getXOsteo());
                ps.setInt(12, xAntReuma.getXSs());
                ps.setString(13, xAntReuma.getXId_Especialidad());
                ps.setString(14, xAntReuma.getXId_Profesional());
                ps.setInt(15, xAntReuma.getXEstado());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdAntReuma = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdAntReuma --> " + xIdAntReuma);
        return xIdAntReuma;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO
    public List<AntecedenteReumatologicoDTO> listAnteReumatologico(Long idUsuario) {
        String SQL_READALL = "SELECT `h_atecedente_reumatologico`.`Id`\n    , `h_atecedente_reumatologico`.`Id_Atencion`\n    , `h_atencion`.`Fecha_Atencion`\n    , `h_atecedente_reumatologico`.`FechaR`\n    , `h_atecedente_reumatologico`.`FInicio`\n    , `h_atecedente_reumatologico`.`FDiagnostico`\n    , `h_atecedente_reumatologico`.`FTratamiento`\n    , `h_atecedente_reumatologico`.`Hta`\n    , `h_atecedente_reumatologico`.`Dm`\n    , `h_atecedente_reumatologico`.`Ecv`\n    , `h_atecedente_reumatologico`.`Erc`\n    , `h_atecedente_reumatologico`.`Osteo`\n    , `h_atecedente_reumatologico`.`Ss`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `profesional1`.`NProfesional`\n    , `h_atecedente_reumatologico`.`Estado`\nFROM\n    `baseserver`.`h_atecedente_reumatologico`\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`h_atecedente_reumatologico`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atecedente_reumatologico`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`profesional1` \n        ON (`h_atecedente_reumatologico`.`Id_Profesional` = `profesional1`.`Id_Persona`)\nWHERE (`h_atecedente_reumatologico`.`Id_Usuario` ='" + idUsuario + "')\nORDER BY `h_atencion`.`Fecha_Atencion` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteReumatologicoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                AntecedenteReumatologicoDTO xAntReuma = new AntecedenteReumatologicoDTO();
                xAntReuma.setXId(rs.getLong("Id"));
                xAntReuma.setXId_Atencion(rs.getLong("Id_Atencion"));
                xAntReuma.setXFechaAtencion(rs.getString("Fecha_Atencion"));
                xAntReuma.setXFechaR(rs.getString("FechaR"));
                xAntReuma.setXFInicio(rs.getInt("FInicio"));
                xAntReuma.setXFDiagnostico(rs.getInt("FDiagnostico"));
                xAntReuma.setXFTratamiento(rs.getInt("FTratamiento"));
                xAntReuma.setXHta(rs.getInt("Hta"));
                xAntReuma.setXDm(rs.getInt("Dm"));
                xAntReuma.setXEcv(rs.getInt("Ecv"));
                xAntReuma.setXErc(rs.getInt("Erc"));
                xAntReuma.setXOsteo(rs.getInt("Osteo"));
                xAntReuma.setXSs(rs.getInt("Ss"));
                xAntReuma.setXId_Especialidad(rs.getString("Especialidad"));
                xAntReuma.setXId_Profesional(rs.getString("NProfesional"));
                xAntReuma.setXEstado(rs.getInt("Estado"));
                return xAntReuma;
            }
        };
        List<AntecedenteReumatologicoDTO> lsAntReuma = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        return lsAntReuma;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO
    public String mUpdate(AntecedenteReumatologicoDTO xAntReuma) {
        String resultado = "Se actualizÓ Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_atecedente_reumatologico` SET `Estado` = ? WHERE `Id` = ? ;", new Object[]{Integer.valueOf(xAntReuma.getXEstado()), Long.valueOf(xAntReuma.getXId())});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO
    public List<GCGenericoDTO> listEspecialidad() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteReumatologicoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO
    public List<GCGenericoDTO> listProfesional(String xIdEspecialidad) {
        String xSQL = "SELECT profesional1.Id_Persona AS Id, profesional1.NProfesional AS Nbre FROM \ng_profesional INNER JOIN profesional1  \nON (g_profesional.Id_Persona = profesional1.Id_Persona) \nWHERE (profesional1.IdEspecialidad ='" + xIdEspecialidad + "'  \nAND g_profesional.Estado =0) ORDER BY profesional1.NProfesional ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedenteReumatologicoDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setIdString(rs.getString("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xSQL, mapper);
        return list;
    }
}
