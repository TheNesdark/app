package com.genoma.plus.dao.impl.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HNotasClinicaDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.HNotasClinicasDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/HNotaClinicaDAOImpl.class */
public class HNotaClinicaDAOImpl implements HNotasClinicaDAO {
    private JdbcTemplate jdbcTemplate;
    private String xsql;
    Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.HNotasClinicaDAO
    public Long mCrear(final HNotasClinicasDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl.1
            final String sql = "INSERT INTO `h_notasclinicas` (    `Id_Atencion` , `Id_Tipo_Atencion` , `Id_TipoNota` , `FechaNota` , `HoraNota` , `Descripcion` , `Id_Profesional` , `Id_Especialidad`\n    , `IdEndodoncia`  , `Id_OrdenF` , `NCierre` , `Estado` , `Fecha` , `UsuarioS`,`EstadoGeneral` , `InterpretacionAyudasDx`, `NombreProcedimiento` , `ObservacionP` , `ComplicacionP`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_notasclinicas` (    `Id_Atencion` , `Id_Tipo_Atencion` , `Id_TipoNota` , `FechaNota` , `HoraNota` , `Descripcion` , `Id_Profesional` , `Id_Especialidad`\n    , `IdEndodoncia`  , `Id_OrdenF` , `NCierre` , `Estado` , `Fecha` , `UsuarioS`,`EstadoGeneral` , `InterpretacionAyudasDx`, `NombreProcedimiento` , `ObservacionP` , `ComplicacionP`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setInt(2, e.getIdTipoAtencion().intValue());
                ps.setInt(3, e.getIdTipoNota().intValue());
                ps.setString(4, e.getFechaNota());
                ps.setString(5, e.getHoraNota());
                ps.setString(6, e.getDescripcion());
                ps.setLong(7, e.getIdProfesional().longValue());
                ps.setLong(8, e.getIdEspecialidad().longValue());
                ps.setLong(9, e.getIdEndodoncia().intValue());
                ps.setLong(10, e.getIdOrdenF().longValue());
                ps.setBoolean(11, e.getNCierre().booleanValue());
                ps.setBoolean(12, e.getEstado().booleanValue());
                ps.setString(13, e.getFecha());
                ps.setString(14, e.getUsuarioS());
                ps.setString(15, e.getEstadoGeneral());
                ps.setString(16, e.getInterpretacionAyudaDx());
                ps.setString(17, e.getNombreProcedimiento());
                ps.setString(18, e.getObservacionP());
                ps.setString(19, e.getComplicacionP());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idNotaClinica = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idNotaClinica;
    }

    @Override // com.genoma.plus.dao.historia.HNotasClinicaDAO
    public List<Object[]> listNotaClinica(Long idAtencion, String idFiltro, String idTipoNota) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("NTipoNota"), rs.getString("FechaNota"), rs.getString("HoraNota"), rs.getString("EstadoGeneral"), rs.getString("Descripcion"), rs.getString("InterpretacionAyudasDx"), rs.getString("NombreProcedimiento"), rs.getString("ObservacionP"), rs.getString("ComplicacionP"), rs.getString("Especialidad"), rs.getString("NProfesional")};
                return fila;
            }
        };
        String condicion = idTipoNota.isEmpty() ? "" : " AND `h_tiponota`.`Id`='" + idTipoNota + "'\n";
        String sql = "\tSELECT\n\t    `h_notasclinicas`.`Id`\n\t    , `h_tiponota`.`Nbre` AS `NTipoNota`\n\t    , `h_notasclinicas`.`FechaNota`\n\t    , `h_notasclinicas`.`HoraNota`\n\t    , IFNULL(`h_notasclinicas`.`EstadoGeneral`,'') AS EstadoGeneral\n\t    , IFNULL(`h_notasclinicas`.`Descripcion`,'') AS Descripcion\n\t    , IFNULL(`h_notasclinicas`.`InterpretacionAyudasDx`,'') AS InterpretacionAyudasDx\n\t    , IFNULL(`h_notasclinicas`.`NombreProcedimiento`,'') AS NombreProcedimiento\n\t    , IFNULL(`h_notasclinicas`.`ObservacionP`,'') AS ObservacionP\n\t    , IFNULL(`h_notasclinicas`.`ComplicacionP`,'') AS ComplicacionP\n\t    , `profesional1`.`Especialidad`\n\t    , `profesional1`.`NProfesional`    \n\tFROM\n\t     `h_notasclinicas`\n\t    INNER JOIN  `h_tiponota` \n\t\tON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\n\t    INNER JOIN  `profesional1` \n\t\tON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)\n\tWHERE (`h_notasclinicas`.`Estado` =1 " + condicion + "     AND `h_tiponota`.`Id_Clasificacion` " + idFiltro + " AND `h_notasclinicas`.`Id_Atencion`=" + idAtencion + ")\n\tORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` ASC ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.HNotasClinicaDAO
    public void mActualizar(HNotasClinicasDTO e) {
        this.jdbcTemplate.update("UPDATE h_notasclinicas SET `EstadoGeneral`=?, `Descripcion`=? , `InterpretacionAyudasDx`=?, `NombreProcedimiento`=? , `ObservacionP`=? , `ComplicacionP`=? WHERE Id=?", new Object[]{e.getEstadoGeneral(), e.getDescripcion(), e.getInterpretacionAyudaDx(), e.getNombreProcedimiento(), e.getObservacionP(), e.getComplicacionP(), e.getId()});
    }

    @Override // com.genoma.plus.dao.historia.HNotasClinicaDAO
    public List<GCGenericoDTO> listarTipoNotasRegistradas(long idAtencion, String idFiltro) {
        String xsql = "SELECT\n`h_tiponota`.`Id`\n    ,`h_tiponota`.`Nbre`\nFROM\n    `h_notasclinicas`\n    INNER JOIN `h_tiponota` \n        ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\nWHERE (`h_notasclinicas`.`Id_Atencion` ='" + idAtencion + "' AND `h_tiponota`.`Id_Clasificacion` " + idFiltro + ")\nGROUP BY `h_tiponota`.`Id`\nORDER BY `h_tiponota`.`Nbre` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.HNotasClinicaDAO
    public List<Object[]> listNotaClinica(Long idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("NTipoNota"), rs.getString("FechaNota"), rs.getString("HoraNota"), rs.getString("EstadoGeneral"), rs.getString("Descripcion"), rs.getString("InterpretacionAyudasDx"), rs.getString("NombreProcedimiento"), rs.getString("ObservacionP"), rs.getString("ComplicacionP"), rs.getString("Especialidad"), rs.getString("NProfesional")};
                return fila;
            }
        };
        String sql = "\tSELECT\n\t    `h_notasclinicas`.`Id`\n\t    , `h_tiponota`.`Nbre` AS `NTipoNota`\n\t    , `h_notasclinicas`.`FechaNota`\n\t    , `h_notasclinicas`.`HoraNota`\n\t    , IFNULL(`h_notasclinicas`.`EstadoGeneral`,'') AS EstadoGeneral\n\t    , IFNULL(`h_notasclinicas`.`Descripcion`,'') AS Descripcion\n\t    , IFNULL(`h_notasclinicas`.`InterpretacionAyudasDx`,'') AS InterpretacionAyudasDx\n\t    , IFNULL(`h_notasclinicas`.`NombreProcedimiento`,'') AS NombreProcedimiento\n\t    , IFNULL(`h_notasclinicas`.`ObservacionP`,'') AS ObservacionP\n\t    , IFNULL(`h_notasclinicas`.`ComplicacionP`,'') AS ComplicacionP\n\t    , `profesional1`.`Especialidad`\n\t    , `profesional1`.`NProfesional`    \n\tFROM\n\t     `h_notasclinicas`\n\t    INNER JOIN  `h_tiponota` \n\t\tON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\n\t    INNER JOIN  `profesional1` \n\t\tON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)\n\tWHERE (`h_notasclinicas`.`Estado` =1  AND `profesional1`.`IdEspecialidad` not in(3, 1025)  AND `h_notasclinicas`.`Id_Atencion`=" + idAtencion + ")\n\tORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` ASC ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
