package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import com.genoma.plus.dao.historia.AtencionImagenesDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AtencionImagenesDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AtencionImagenesDAOImpl.class */
public class AtencionImagenesDAOImpl implements AtencionImagenesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public List<AtencionImagenesDTO> list(String xidPersona, String xAno, String xClasificacion, int opc) {
        String sql = "";
        if (opc == 0) {
            if (xClasificacion.isEmpty()) {
                sql = "SELECT\n    `h_atencion_imagenes`.`Id`\n    , `h_atencion_imagenes`.`FechaR`\n    , `h_atencion_imagenes`.`Id_Atencion`\n    , `h_tipoclasificacion_imagenes`.`Nbre` AS Clasificacion\n    , `h_atencion_imagenes`.`Comentario`\n    , `h_atencion_imagenes`.`UrlImagen`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_atencion_imagenes`.`Estado`\n    , `h_atencion`.`Codigo_Dxp`\n    , `g_patologia`.`Nbre` AS DiagnosticoP\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "')ORDER BY `h_atencion_imagenes`.`Id` DESC;";
            } else {
                sql = "SELECT\n    `h_atencion_imagenes`.`Id`\n    , `h_atencion_imagenes`.`FechaR`\n    , `h_atencion_imagenes`.`Id_Atencion`\n    , `h_tipoclasificacion_imagenes`.`Nbre` AS Clasificacion\n    , `h_atencion_imagenes`.`Comentario`\n    , `h_atencion_imagenes`.`UrlImagen`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_atencion_imagenes`.`Estado`\n    , `h_atencion`.`Codigo_Dxp`\n    , `g_patologia`.`Nbre` AS DiagnosticoP\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "' AND `h_atencion_imagenes`.`Id_Clasificacion`='" + xClasificacion + "')ORDER BY `h_atencion_imagenes`.`Id` DESC;";
            }
        } else if (opc == 1) {
            if (xClasificacion.isEmpty()) {
                sql = "SELECT\n    `h_atencion_imagenes`.`Id`\n    , `h_atencion_imagenes`.`FechaR`\n    , `h_atencion_imagenes`.`Id_Atencion`\n    , `h_tipoclasificacion_imagenes`.`Nbre` AS Clasificacion\n    , `h_atencion_imagenes`.`Comentario`\n    , `h_atencion_imagenes`.`UrlImagen`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_atencion_imagenes`.`Estado`\n    , `h_atencion`.`Codigo_Dxp`\n    , `g_patologia`.`Nbre` AS DiagnosticoP\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "' AND date_format(`h_atencion_imagenes`.`FechaR`, '%Y')='" + xAno + "')ORDER BY `h_atencion_imagenes`.`Id` DESC;";
            } else {
                sql = "SELECT\n    `h_atencion_imagenes`.`Id`\n    , `h_atencion_imagenes`.`FechaR`\n    , `h_atencion_imagenes`.`Id_Atencion`\n    , `h_tipoclasificacion_imagenes`.`Nbre` AS Clasificacion\n    , `h_atencion_imagenes`.`Comentario`\n    , `h_atencion_imagenes`.`UrlImagen`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_atencion_imagenes`.`Estado`\n    , `h_atencion`.`Codigo_Dxp`\n    , `g_patologia`.`Nbre` AS DiagnosticoP\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "' AND date_format(`h_atencion_imagenes`.`FechaR`, '%Y')='" + xAno + "' AND `h_atencion_imagenes`.`Id_Clasificacion`='" + xClasificacion + "')ORDER BY `h_atencion_imagenes`.`Id` DESC;";
            }
        }
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AtencionImagenesDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                AtencionImagenesDTO xGaleria = new AtencionImagenesDTO();
                xGaleria.setId(rs.getInt("Id"));
                xGaleria.setFechaR(rs.getString("FechaR"));
                xGaleria.setIdAtencion(rs.getLong("Id_Atencion"));
                xGaleria.setIdClasificacion(rs.getString("Clasificacion"));
                xGaleria.setComentario(rs.getString("Comentario"));
                xGaleria.setUrlImagen(rs.getString("UrlImagen"));
                xGaleria.setIdProfesional(rs.getString("NProfesional"));
                xGaleria.setIdEspecialidad(rs.getString("Especialidad"));
                xGaleria.setEstado(rs.getInt("Estado"));
                xGaleria.setCodigoDx(rs.getString("Codigo_Dxp"));
                xGaleria.setNDiagnostico(rs.getString("DiagnosticoP"));
                return xGaleria;
            }
        };
        List<AtencionImagenesDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public List<GCGenericoDTO> listClasificacionFiltrado(String xidPersona, String xAno, int opc) {
        String sql = "";
        if (opc == 0) {
            sql = "SELECT\n    `h_tipoclasificacion_imagenes`.`Id`\n    , `h_tipoclasificacion_imagenes`.`Nbre`\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "')GROUP BY `h_tipoclasificacion_imagenes`.`Id` ORDER BY `h_tipoclasificacion_imagenes`.`Nbre` ASC;";
        } else if (opc == 1) {
            sql = "SELECT\n    `h_tipoclasificacion_imagenes`.`Id`\n    , `h_tipoclasificacion_imagenes`.`Nbre`\nFROM\n    `h_atencion_imagenes`\n    INNER JOIN `h_tipoclasificacion_imagenes` \n        ON (`h_atencion_imagenes`.`Id_Clasificacion` = `h_tipoclasificacion_imagenes`.`Id`)\n    INNER JOIN `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion_imagenes`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion_imagenes`.`IdProfesional`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id` = `h_atencion_imagenes`.`Id_Atencion`)\n    INNER JOIN `ingreso` \n        ON (`ingreso`.`Id` = `h_atencion`.`Id_ingreso`)\n    left JOIN `g_patologia`\n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidPersona + "' AND date_format(`h_atencion_imagenes`.`FechaR`, '%Y')='" + xAno + "')GROUP BY `h_tipoclasificacion_imagenes`.`Id` ORDER BY `h_tipoclasificacion_imagenes`.`Nbre` ASC;";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AtencionImagenesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public List<GCGenericoDTO> listClasificacion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AtencionImagenesDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `h_tipoclasificacion_imagenes` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public String update(AtencionImagenesDTO xGaleria) {
        String sql = "UPDATE\n  `h_atencion_imagenes`\nSET\n  `Id_Clasificacion` = ?,\n  `Comentario` = ?,\n  `Estado` = ?,\n  `IdUsuarioR` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xGaleria.getIdClasificacion(), xGaleria.getComentario(), Integer.valueOf(xGaleria.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xGaleria.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public String create_return_id_Detalle(final AtencionImagenesDTO xGaleria) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AtencionImagenesDAOImpl.4
            final String sql = "INSERT INTO `h_atencion_imagenes` (`Id_Atencion`,`Id_Clasificacion`,`FechaR`,`Comentario`,`IdEspecialidad`,`IdProfesional`,`Estado`,`IdUsuarioR`)\nVALUES (?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_atencion_imagenes` (`Id_Atencion`,`Id_Clasificacion`,`FechaR`,`Comentario`,`IdEspecialidad`,`IdProfesional`,`Estado`,`IdUsuarioR`)\nVALUES (?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, xGaleria.getIdAtencion());
                ps.setString(2, xGaleria.getIdClasificacion());
                ps.setString(3, xGaleria.getFechaR());
                ps.setString(4, xGaleria.getComentario());
                ps.setString(5, xGaleria.getIdEspecialidad());
                ps.setString(6, xGaleria.getIdProfesional());
                ps.setInt(7, xGaleria.getEstado());
                ps.setLong(8, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdDetalleDoc = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xfotografia-->" + xIdDetalleDoc);
        return xIdDetalleDoc;
    }

    @Override // com.genoma.plus.dao.historia.AtencionImagenesDAO
    public String mUpdateURLDetalle(AtencionImagenesDTO xGaleria) {
        String sql = "UPDATE\n  `h_atencion_imagenes`\nSET\n  `UrlImagen` = ?  \nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xGaleria.getUrlImagen(), Long.valueOf(xGaleria.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
