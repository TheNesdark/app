package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO;
import com.genoma.plus.dto.general.FichaNotificacionSivigilaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/FichaNotificacionSivigilaDAOImpl.class */
public class FichaNotificacionSivigilaDAOImpl implements FichaNotificacionSivigilaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO
    public List<FichaNotificacionSivigilaDTO> listSivigila() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.FichaNotificacionSivigilaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                FichaNotificacionSivigilaDTO xSivigila = new FichaNotificacionSivigilaDTO();
                xSivigila.setId(rs.getLong("Id"));
                xSivigila.setCodigo(rs.getString("Codigo"));
                xSivigila.setNombre(rs.getString("Nbre"));
                xSivigila.setDescripcion(rs.getString("Descripcion"));
                xSivigila.setArchivo(rs.getInt("Archivo"));
                xSivigila.setEstado(rs.getInt("Estado"));
                xSivigila.setArchivoSivigila(rs.getBytes("ArchivoSivigila"));
                return xSivigila;
            }
        };
        List<FichaNotificacionSivigilaDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Codigo`, `Nbre`, IFNULL(`Descripcion`,'') AS Descripcion,IF(`ArchivoSivigila` IS NULL, 0,1) Archivo, `Estado`, ArchivoSivigila FROM `g_fichas_notificacion_sivigila` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO
    public String mCreate(FichaNotificacionSivigilaDTO xSivigila) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `g_fichas_notificacion_sivigila` (`Nbre`,`Descripcion`,`Codigo`,`ArchivoSivigila`,`Estado`,`Id_UsuarioR`)\nVALUES (?,?,?,?,?,?);", new Object[]{xSivigila.getNombre(), xSivigila.getDescripcion(), xSivigila.getCodigo(), xSivigila.getArchivoSivigila(), Integer.valueOf(xSivigila.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO
    public String mCreateSinArchivo(FichaNotificacionSivigilaDTO xSivigila) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `g_fichas_notificacion_sivigila` (`Nbre`,`Descripcion`,`Codigo`,`Estado`,`Id_UsuarioR`)\nVALUES (?,?,?,?,?);", new Object[]{xSivigila.getNombre(), xSivigila.getDescripcion(), xSivigila.getCodigo(), Integer.valueOf(xSivigila.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO
    public String mUpdate(FichaNotificacionSivigilaDTO xSivigila) {
        String sql = "UPDATE\n  `g_fichas_notificacion_sivigila`\nSET\n  `Nbre` = ?,\n  `Descripcion` = ?,\n  `Codigo` = ?,\n  `ArchivoSivigila` = ?,\n  `Estado` = ?,\n  `Id_UsuarioR` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xSivigila.getNombre(), xSivigila.getDescripcion(), xSivigila.getCodigo(), xSivigila.getArchivoSivigila(), Integer.valueOf(xSivigila.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xSivigila.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO
    public String mUpdateSinArchivo(FichaNotificacionSivigilaDTO xSivigila) {
        String sql = "UPDATE\n  `g_fichas_notificacion_sivigila`\nSET\n  `Nbre` = ?,\n  `Descripcion` = ?,\n  `Codigo` = ?,\n  `Estado` = ?,\n  `Id_UsuarioR` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xSivigila.getNombre(), xSivigila.getDescripcion(), xSivigila.getCodigo(), Integer.valueOf(xSivigila.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xSivigila.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
