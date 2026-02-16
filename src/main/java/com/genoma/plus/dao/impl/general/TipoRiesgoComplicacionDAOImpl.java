package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoRiesgoComplicacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoRiesgoComplicacionDAOImpl.class */
public class TipoRiesgoComplicacionDAOImpl implements TipoRiesgoComplicacionDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO
    public List<TipoRiesgoComplicacionDTO> listTipoRiesgoComplicacion(String xnombre) {
        String sql = "SELECT\n    `h_tipo_riesgo_complicacion`.`Id`\n    , `h_tipo_riesgo_complicacion`.`Nbre`\n    , `h_tipo_riesgo_complicacion_clasificacion`.`Nbre` AS `Clasificacion`\n    , `h_tipo_riesgo_complicacion`.`Estado`\nFROM\n    `h_tipo_riesgo_complicacion`\n    INNER JOIN `h_tipo_riesgo_complicacion_clasificacion` \n        ON (`h_tipo_riesgo_complicacion`.`IdTipoClasificacion` = `h_tipo_riesgo_complicacion_clasificacion`.`Id`)\nWHERE (`h_tipo_riesgo_complicacion`.`Nbre` LIKE '%" + xnombre + "%')\nORDER BY `h_tipo_riesgo_complicacion`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoRiesgoComplicacionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoRiesgoComplicacionDTO Complicacion = new TipoRiesgoComplicacionDTO();
                Complicacion.setId(rs.getInt("Id"));
                Complicacion.setNombre(rs.getString("Nbre"));
                Complicacion.setIdTipoClasificacion(rs.getString("Clasificacion"));
                Complicacion.setEstado(rs.getInt("Estado"));
                return Complicacion;
            }
        };
        List<TipoRiesgoComplicacionDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO
    public List<GCGenericoDTO> listClasificacioTipoRiesgoComplicacion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoRiesgoComplicacionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo_complicacion_clasificacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO
    public String mCreatetipoRiesgoComplicacion(TipoRiesgoComplicacionDTO xTipoRiesgoComplicacion) {
        String sql = "INSERT INTO `h_tipo_riesgo_complicacion` (`Nbre`,`IdTipoClasificacion`,`Estado`,`Id_UsuarioR`)\nVALUES (?,?,?,?);";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xTipoRiesgoComplicacion.getNombre(), xTipoRiesgoComplicacion.getIdTipoClasificacion(), Integer.valueOf(xTipoRiesgoComplicacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            sql = "No se inserto";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO
    public String mUpdatetipoRiesgoComplicacion(TipoRiesgoComplicacionDTO xTipoRiesgoComplicacion) {
        String sql = "UPDATE\n  `h_tipo_riesgo_complicacion`\nSET\n  `Nbre` = ?,\n  `IdTipoClasificacion` = ?,\n  `Estado` = ?,\n  `Id_UsuarioR` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xTipoRiesgoComplicacion.getNombre(), xTipoRiesgoComplicacion.getIdTipoClasificacion(), Integer.valueOf(xTipoRiesgoComplicacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xTipoRiesgoComplicacion.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
