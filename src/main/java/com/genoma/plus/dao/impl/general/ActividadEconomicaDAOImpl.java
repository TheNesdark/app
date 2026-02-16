package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.ActividadEconomicaDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ActividadEconomicaDTO;
import com.genoma.plus.dto.general.ActividadEconomicaNivelDTO;
import com.genoma.plus.dto.general.ActividadEconomicaTerceroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ActividadEconomicaDAOImpl.class */
public class ActividadEconomicaDAOImpl implements ActividadEconomicaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public List<ActividadEconomicaDTO> listActividadEconomica() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ActividadEconomicaDTO Actividad = new ActividadEconomicaDTO();
                Actividad.setId(rs.getString("Id"));
                Actividad.setIdNivel(rs.getString("Nivel"));
                Actividad.setNombre(rs.getString("Nbre"));
                Actividad.setEstado(rs.getInt("Estado"));
                return Actividad;
            }
        };
        List<ActividadEconomicaDTO> lsGen = this.jdbcTemplate.query("SELECT  cc_actividad_economica . Id ,  cc_actividad_economica_nivel.Nbre As Nivel ,  cc_actividad_economica.Nbre ,  cc_actividad_economica . Estado \nFROM    cc_actividad_economica INNER JOIN    cc_actividad_economica_nivel  ON ( cc_actividad_economica . Id_Nivel  =  cc_actividad_economica_nivel . Id )\nORDER BY  cc_actividad_economica . Nbre  ASC", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String createActividadEconomica(ActividadEconomicaDTO Actividad) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_actividad_economica`(`Id`,`Nbre`,`Id_Nivel`,`Estado`,`Id_UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{Actividad.getId(), Actividad.getNombre(), Actividad.getIdNivel(), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String updateActividadEconomica(ActividadEconomicaDTO Actividad) {
        String sql = "UPDATE `cc_actividad_economica`\nSET `Nbre` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Actividad.getNombre(), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Actividad.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public List<ActividadEconomicaNivelDTO> listActividadENivel() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ActividadEconomicaNivelDTO Actividad = new ActividadEconomicaNivelDTO();
                Actividad.setId(Long.valueOf(rs.getLong("Id")));
                Actividad.setNombre(rs.getString("Nbre"));
                Actividad.setNDigitos(rs.getInt("NDigitos"));
                Actividad.setNCaracter(rs.getString("NCaracter"));
                Actividad.setEstado(rs.getInt("Estado"));
                return Actividad;
            }
        };
        List<ActividadEconomicaNivelDTO> lsGen = this.jdbcTemplate.query("SELECT  Id ,  Nbre ,  NDigitos , NCaracter, Estado FROM cc_actividad_economica_nivel ORDER BY  Nbre  ASC", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String createActividadEnivel(ActividadEconomicaNivelDTO Actividad) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_actividad_economica_nivel`(`Nbre`,`NDigitos`,`NCaracter`,`Estado`, `Id_UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{Actividad.getNombre(), Integer.valueOf(Actividad.getNDigitos()), Actividad.getNCaracter(), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String updateActividadEnivel(ActividadEconomicaNivelDTO Actividad) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `cc_actividad_economica_nivel`\nSET `Nbre` = ?,\n  `NDigitos` = ?,\n  `NCaracter` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{Actividad.getNombre(), Integer.valueOf(Actividad.getNDigitos()), Actividad.getNCaracter(), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Actividad.getId()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public List<ActividadEconomicaTerceroDTO> listActividadETercero(String xidTercero) {
        String sql = "SELECT\n    `cc_actividad_economica`.`Id`\n    , `cc_actividad_economica`.`Nbre`\n    , `cc_actividad_economica_tercero`.`Observacion`\n    , `cc_actividad_economica_tercero`.`EsPrincipal`\n    , `cc_actividad_economica_tercero`.`Estado`\nFROM\n    `cc_actividad_economica_tercero`\n    INNER JOIN `cc_actividad_economica` \n        ON (`cc_actividad_economica_tercero`.`Id_Actividad_Economica` = `cc_actividad_economica`.`Id`)\nWHERE (`cc_actividad_economica_tercero`.`Id_Tercero` ='" + xidTercero + "')\nORDER BY `cc_actividad_economica`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ActividadEconomicaTerceroDTO Actividad = new ActividadEconomicaTerceroDTO();
                Actividad.setId(Long.valueOf(rs.getLong("Id")));
                Actividad.setIdActividadEconomica(rs.getString("Nbre"));
                Actividad.setObservacion(rs.getString("Observacion"));
                Actividad.setEsPrincipal(rs.getInt("EsPrincipal"));
                Actividad.setEstado(rs.getInt("Estado"));
                return Actividad;
            }
        };
        List<ActividadEconomicaTerceroDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String createActividadETercero(ActividadEconomicaTerceroDTO Actividad) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO cc_actividad_economica_tercero (Id_Tercero , Id_Actividad_Economica , EsPrincipal , Observacion , Estado , Id_UsuarioS)VALUES(?,?,?,?,?,?)", new Object[]{Actividad.getIdTercero(), Actividad.getIdActividadEconomica(), Integer.valueOf(Actividad.getEsPrincipal()), Actividad.getObservacion(), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public String updateActividadETercero(ActividadEconomicaTerceroDTO Actividad) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE cc_actividad_economica_tercero SET Observacion =?, EsPrincipal = ?, Estado=?, Id_UsuarioS=? WHERE Id_Tercero=? AND  Id_Actividad_Economica = ?", new Object[]{Actividad.getObservacion(), Integer.valueOf(Actividad.getEsPrincipal()), Integer.valueOf(Actividad.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Actividad.getIdTercero(), Actividad.getIdActividadEconomica()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ActividadEconomicaDAO
    public List<GCGenericoDTO> listActividad(String xconsulta) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query(xconsulta, rowMapper);
        return lsGen;
    }
}
