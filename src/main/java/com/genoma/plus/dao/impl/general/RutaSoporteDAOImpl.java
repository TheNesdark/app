package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.RutaSoporteDAO;
import com.genoma.plus.dto.general.RutaSoporteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/RutaSoporteDAOImpl.class */
public class RutaSoporteDAOImpl implements RutaSoporteDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.RutaSoporteDAO
    public List<RutaSoporteDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.RutaSoporteDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                RutaSoporteDTO ruta = new RutaSoporteDTO();
                ruta.setId(rs.getInt("id"));
                ruta.setIdModulo(rs.getString("Modulo"));
                ruta.setObservacion(rs.getString("Observacion"));
                ruta.setUbicacion(rs.getString("Ubiacion"));
                ruta.setEstado(rs.getInt("Estado"));
                return ruta;
            }
        };
        List<RutaSoporteDTO> lsEstrato = this.jdbcTemplate.query("SELECT\n    `p_s_rutas_soportes`.`Id`\n    , `g_modulos`.`Nbre` AS `Modulo`\n    , `p_s_rutas_soportes`.`Observacion`\n    , `p_s_rutas_soportes`.`Ubiacion`\n    , `p_s_rutas_soportes`.`Estado`\nFROM\n    `p_s_rutas_soportes`\n    INNER JOIN `g_modulos` \n        ON (`p_s_rutas_soportes`.`Id_Modulo` = `g_modulos`.`Id`)\nORDER BY `Modulo` ASC;", rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.RutaSoporteDAO
    public String update(RutaSoporteDTO ruta) {
        String sql = "UPDATE `p_s_rutas_soportes`\nSET `Ubiacion` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{ruta.getUbicacion(), Integer.valueOf(ruta.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(ruta.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
