package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SO_TipoResultadoDAO;
import com.genoma.plus.dto.general.SO_TipoResultadoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/SO_TipoResultadoDAOImpl.class */
public class SO_TipoResultadoDAOImpl implements SO_TipoResultadoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.SO_TipoResultadoDAO
    public List<SO_TipoResultadoDTO> mListar() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SO_TipoResultadoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SO_TipoResultadoDTO forma = new SO_TipoResultadoDTO();
                forma.setId(Long.valueOf(rs.getLong("Id")));
                forma.setNombre(rs.getString("Nbre"));
                forma.setTipoExamen(rs.getString("Tipo"));
                forma.setEstado(rs.getInt("Estado"));
                return forma;
            }
        };
        List<SO_TipoResultadoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, IF(`TipoExamen`=1,'ESPIROMETRIA',IF(`TipoExamen`=2,'AUDIOMETRIA',IF(`TipoExamen`=3,'OPTOMETRIA',IF(`TipoExamen`=4,'OSTEOMUSCULAR',IF(`TipoExamen`=5,'CUESTIONARIOS',IF(`TipoExamen`=6,'VISIOMETRIA',IF(`TipoExamen`=7,'PSICOMOTRIZ','NO APLICA'))))))) AS Tipo,\nEstado FROM `h_so_resultado` ORDER BY `Tipo` ASC, Nbre ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.SO_TipoResultadoDAO
    public String mCreate(SO_TipoResultadoDTO xrespuesta) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_so_resultado`(`Nbre`,`TipoExamen`,`Estado`,`Id_UsuarioS`)\nVALUES (?,?,?,?);", new Object[]{xrespuesta.getNombre(), xrespuesta.getTipoExamen(), Integer.valueOf(xrespuesta.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.SO_TipoResultadoDAO
    public String mUpdate(SO_TipoResultadoDTO xrespuesta) {
        String sql = "UPDATE `h_so_resultado`\nSET `Nbre` = ?,\n  `TipoExamen` = ?,\n  `Estado` = ?,  \n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xrespuesta.getNombre(), xrespuesta.getTipoExamen(), Integer.valueOf(xrespuesta.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xrespuesta.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
