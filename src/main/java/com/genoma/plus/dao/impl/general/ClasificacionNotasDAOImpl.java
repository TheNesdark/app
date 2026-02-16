package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.ClasificacionNotasDAO;
import com.genoma.plus.dto.general.ClasificacionNotasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ClasificacionNotasDAOImpl.class */
public class ClasificacionNotasDAOImpl implements ClasificacionNotasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ClasificacionNotasDAO
    public List<ClasificacionNotasDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ClasificacionNotasDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ClasificacionNotasDTO xClasificacion = new ClasificacionNotasDTO();
                xClasificacion.setId(Long.valueOf(rs.getLong("Id")));
                xClasificacion.setNombre(rs.getString("Nbre"));
                xClasificacion.setNOrden(rs.getInt("NOrden"));
                xClasificacion.setEstado(rs.getInt("Estado"));
                return xClasificacion;
            }
        };
        List<ClasificacionNotasDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `NOrden`, `Estado` FROM `baseserver`.`h_tiponota_clasificacion` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.ClasificacionNotasDAO
    public String mCreate(ClasificacionNotasDTO xClasificacion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("insert into `h_tiponota_clasificacion` (`Nbre`,`NOrden`,`Estado`, `Id_UsuarioRh`)\nvalues (?,?,?,?);", new Object[]{xClasificacion.getNombre(), Integer.valueOf(xClasificacion.getNOrden()), Integer.valueOf(xClasificacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ClasificacionNotasDAO
    public String mUpdate(ClasificacionNotasDTO xClasificacion) {
        String sql = "UPDATE\n  `h_tiponota_clasificacion`\nSET\n  `Nbre` = ?,\n  `NOrden` = ?,\n  `Estado` = ?,\n  `Id_UsuarioRh` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xClasificacion.getNombre(), Integer.valueOf(xClasificacion.getNOrden()), Integer.valueOf(xClasificacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), xClasificacion.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
