package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO;
import com.genoma.plus.dto.sgc.SGC_RegistroReuniones;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesIntegrantesDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesObjetivosDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesRecursosDTO;
import com.genoma.plus.dto.sgc.SGC_TipoRecurso_Reunion;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SGC_RegistroReunionesDAOImpl.class */
public class SGC_RegistroReunionesDAOImpl implements SGC_RegistoReunionesDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<SGC_TipoRecurso_Reunion> listTipoRecursos() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_TipoRecurso_Reunion tipoReunion = new SGC_TipoRecurso_Reunion();
                tipoReunion.setId(rs.getInt("Id"));
                tipoReunion.setNombre(rs.getString("Nbre"));
                tipoReunion.setEmail(rs.getString("Email"));
                tipoReunion.setControl(Boolean.valueOf(rs.getBoolean("Control")));
                tipoReunion.setEstado(Boolean.valueOf(rs.getBoolean("Estado")));
                return tipoReunion;
            }
        };
        List<SGC_TipoRecurso_Reunion> lsTipoRecursos = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`\n    , `Email`\n    , `Control`\n    , `Estado`\nFROM\n    `s_sgc_tipo_recursos_reuniones`\nWHERE (`Estado` =1)\nORDER BY `Nbre` ASC", rowMapper);
        return lsTipoRecursos;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<Object[]> listTipoRecursos_Utilizados(int xFiltro, String xFechaC, Long xIdRecurso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                return fila;
            }
        };
        String sql = "";
        if (xFiltro == 0) {
            sql = "SELECT\n    `s_sgc_tipo_reunion`.`Nbre`\n    , `s_sgc_registro_reuniones`.`FechaI`\n    , `s_sgc_registro_reuniones`.`HoraI`\n    , `s_sgc_registro_reuniones`.`FechaF`\n    , `s_sgc_registro_reuniones`.`HoraF`\n    , `s_sgc_registro_reuniones`.`Lugar`\nFROM\n     `s_sgc_registro_reuniones_recursos`\n    INNER JOIN  `s_sgc_registro_reuniones` \n        ON (`s_sgc_registro_reuniones_recursos`.`Id_RegistroR` = `s_sgc_registro_reuniones`.`Id`)\n    INNER JOIN  `s_sgc_tipo_reunion` \n        ON (`s_sgc_registro_reuniones`.`IdTipoR` = `s_sgc_tipo_reunion`.`Id`)\nWHERE (`s_sgc_registro_reuniones`.`FechaI` ='" + xFechaC + "'\n    AND `s_sgc_registro_reuniones_recursos`.`Id_Recursos` ='" + xIdRecurso + "'\n    AND `s_sgc_registro_reuniones`.`Estado` =1)\nORDER BY `s_sgc_registro_reuniones`.`FechaI` ASC";
        } else if (xFiltro == 1) {
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public String create_return_id(final SGC_RegistroReuniones xRegistroReunion) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.3
            final String sql = "INSERT INTO s_sgc_registro_reuniones (`IdTipoR`, `FechaI`, `HoraI`, `FechaF`, `HoraF`, `Lugar`, `ObjetivoG`, `ObservacionC`, `IdUsuarioR`)VALUES (?,?,?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO s_sgc_registro_reuniones (`IdTipoR`, `FechaI`, `HoraI`, `FechaF`, `HoraF`, `Lugar`, `ObjetivoG`, `ObservacionC`, `IdUsuarioR`)VALUES (?,?,?,?,?,?,?,?,?)", 1);
                ps.setString(1, xRegistroReunion.getIdTipoReunion());
                ps.setString(2, xRegistroReunion.getFechaInicial());
                ps.setString(3, xRegistroReunion.getHoraIncial());
                ps.setString(4, xRegistroReunion.getFechaFinal());
                ps.setString(5, xRegistroReunion.getHoraFinal());
                ps.setString(6, xRegistroReunion.getLugar());
                ps.setString(7, xRegistroReunion.getObjetivo());
                ps.setString(8, xRegistroReunion.getObservacion());
                ps.setLong(9, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdReunion = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIDActa-->" + xIdReunion);
        return xIdReunion;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public String create_objetivo(SGC_RegistroReunionesObjetivosDTO xIdReunion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_registro_reuniones_objetivos` (`Id_RegistroR`,`Id_UsuarioRh`,`ObjetivoE`,`NUsuario`,`NCargo`,`Estado`)\nVALUES(?,?,?,?,?,?);", new Object[]{xIdReunion.getIdRegistroR(), xIdReunion.getIdUsuarioRH(), xIdReunion.getObjetivoE(), xIdReunion.getNUsuario(), xIdReunion.getNCargo(), 1});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public String create_integrante(SGC_RegistroReunionesIntegrantesDTO xIdReunion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_registro_reuniones_integrantes` (`Id_RegistroR`,`IdUsuarioRh`,`NUsuario`,`NCargo` )\nVALUES (?,?,?,?);", new Object[]{xIdReunion.getIdRegistroR(), xIdReunion.getIdUsuarioRH(), xIdReunion.getNUsuario(), xIdReunion.getNCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public String create_recurso(SGC_RegistroReunionesRecursosDTO xIdReunion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_registro_reuniones_recursos` (`Id_RegistroR`,`Id_Recursos`,`Cantidad`,`Observacion` )\nVALUES(?,?,?,?);", new Object[]{xIdReunion.getIdRegistroR(), xIdReunion.getIdRecurso(), Integer.valueOf(xIdReunion.getCantidad()), xIdReunion.getObservacion()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<SGC_RegistroReuniones> listReuniones() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_RegistroReuniones Reunion = new SGC_RegistroReuniones();
                Reunion.setIdReunion(rs.getInt("Id"));
                Reunion.setFechaInicial(rs.getString("FechaI"));
                Reunion.setHoraIncial(rs.getString("HoraI"));
                Reunion.setFechaFinal(rs.getString("FechaF"));
                Reunion.setHoraFinal(rs.getString("HoraF"));
                Reunion.setIdTipoReunion(rs.getString("TipoReunion"));
                Reunion.setLugar(rs.getString("Lugar"));
                Reunion.setObjetivo(rs.getString("ObjetivoG"));
                Reunion.setObservacion(rs.getString("ObservacionC"));
                return Reunion;
            }
        };
        List<SGC_RegistroReuniones> lsResgitroReuniones = this.jdbcTemplate.query("SELECT\n    `s_sgc_registro_reuniones`.`Id`\n    , `s_sgc_registro_reuniones`.`FechaI`\n    , `s_sgc_registro_reuniones`.`HoraI`\n    , `s_sgc_registro_reuniones`.`FechaF`\n    , `s_sgc_registro_reuniones`.`HoraF`\n    , `s_sgc_tipo_reunion`.`Nbre` AS `TipoReunion`\n    , `s_sgc_registro_reuniones`.`Lugar`\n    , `s_sgc_registro_reuniones`.`ObjetivoG`\n    , `s_sgc_registro_reuniones`.`ObservacionC`\nFROM\n    `s_sgc_registro_reuniones`\n    INNER JOIN `s_sgc_tipo_reunion` \n        ON (`s_sgc_registro_reuniones`.`IdTipoR` = `s_sgc_tipo_reunion`.`Id`)\nORDER BY `s_sgc_registro_reuniones`.`FechaI` DESC;", rowMapper);
        return lsResgitroReuniones;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<SGC_RegistroReunionesObjetivosDTO> listObjetivos(String xIdReunion) {
        String sql = "SELECT\n    `ObjetivoE`\n    , `NCargo`\n    , `NUsuario`\n    , `Id_UsuarioRh`\nFROM\n    `s_sgc_registro_reuniones_objetivos`\nWHERE (`Id_RegistroR` ='" + xIdReunion + "'\n    AND `Estado` =1);";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.5
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_RegistroReunionesObjetivosDTO Reunion = new SGC_RegistroReunionesObjetivosDTO();
                Reunion.setObjetivoE(rs.getString("ObjetivoE"));
                Reunion.setNCargo(rs.getString("NCargo"));
                Reunion.setNUsuario(rs.getString("NUsuario"));
                Reunion.setIdUsuarioRH(Long.valueOf(rs.getLong("Id_UsuarioRh")));
                return Reunion;
            }
        };
        List<SGC_RegistroReunionesObjetivosDTO> lsResgitroObjetivos = this.jdbcTemplate.query(sql, rowMapper);
        return lsResgitroObjetivos;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<SGC_RegistroReunionesIntegrantesDTO> listIntegrantes(String xIdReunion) {
        String sql = "SELECT\n    IFNULL(`s_sgc_registro_reuniones_integrantes`.`IdUsuarioRh`, 0) AS IdUsuarioRh\n    , `s_sgc_registro_reuniones_integrantes`.`NCargo`\n    , `s_sgc_registro_reuniones_integrantes`.`NUsuario`\n    , IFNULL(`g_persona`.`Correo`,'') AS Correo\nFROM\n    `s_sgc_registro_reuniones_integrantes`\n    LEFT JOIN `rh_tipo_persona_cargon` \n        ON (`rh_tipo_persona_cargon`.`Id` = `s_sgc_registro_reuniones_integrantes`.`IdUsuarioRh`)\n    LEFT JOIN `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`s_sgc_registro_reuniones_integrantes`.`Id_RegistroR` ='" + xIdReunion + "'\n    AND `s_sgc_registro_reuniones_integrantes`.`Estado` =1) ;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.6
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_RegistroReunionesIntegrantesDTO Reunion = new SGC_RegistroReunionesIntegrantesDTO();
                Reunion.setIdUsuarioRH(Long.valueOf(rs.getLong("IdUsuarioRh")));
                Reunion.setNCargo(rs.getString("NCargo"));
                Reunion.setNUsuario(rs.getString("NUsuario"));
                Reunion.setCorreo(rs.getString("Correo"));
                return Reunion;
            }
        };
        List<SGC_RegistroReunionesIntegrantesDTO> lsResgitroIntegrantes = this.jdbcTemplate.query(sql, rowMapper);
        return lsResgitroIntegrantes;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO
    public List<SGC_RegistroReunionesRecursosDTO> listRecursos(String xIdReunion) {
        String sql = "SELECT\n     `s_sgc_registro_reuniones_recursos`.`Id_Recursos`\n    , `s_sgc_tipo_recursos_reuniones`.`Nbre` AS `Recurso`\n    , `s_sgc_registro_reuniones_recursos`.`Observacion`\n    , IFNULL(`s_sgc_tipo_recursos_reuniones`.`Email`,'') AS Email\n    , `s_sgc_tipo_recursos_reuniones`.`Control`\nFROM\n    `s_sgc_registro_reuniones_recursos`\n    INNER JOIN `s_sgc_tipo_recursos_reuniones` \n        ON (`s_sgc_registro_reuniones_recursos`.`Id_Recursos` = `s_sgc_tipo_recursos_reuniones`.`Id`)\nWHERE (`s_sgc_registro_reuniones_recursos`.`Id_RegistroR` ='" + xIdReunion + "'\n    AND `s_sgc_registro_reuniones_recursos`.`Estado` =1);";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl.7
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_RegistroReunionesRecursosDTO Reunion = new SGC_RegistroReunionesRecursosDTO();
                Reunion.setIdRecurso(Long.valueOf(rs.getLong("Id_Recursos")));
                Reunion.setNRecurso(rs.getString("Recurso"));
                Reunion.setObservacion(rs.getString("Observacion"));
                Reunion.setEmail(rs.getString("Email"));
                Reunion.setControl(rs.getInt("Control"));
                return Reunion;
            }
        };
        List<SGC_RegistroReunionesRecursosDTO> lsResgitrorecurso = this.jdbcTemplate.query(sql, rowMapper);
        return lsResgitrorecurso;
    }
}
