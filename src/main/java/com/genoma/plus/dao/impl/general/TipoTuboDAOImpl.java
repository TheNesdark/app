package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoTuboDAO;
import com.genoma.plus.dto.general.TipoTuboDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoTuboDAOImpl.class */
public class TipoTuboDAOImpl implements TipoTuboDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoTuboDAO
    public List<TipoTuboDTO> mListar() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoTuboDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoTuboDTO forma = new TipoTuboDTO();
                forma.setId(rs.getInt("Id"));
                forma.setNombre(rs.getString("Nbre"));
                forma.setAbreviatura(rs.getString("Abreviatura"));
                forma.setEstado(rs.getInt("Estado"));
                return forma;
            }
        };
        List<TipoTuboDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,`Abreviatura`,`Estado` FROM `l_tipo_tubo` ORDER BY `Nbre` ASC", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.TipoTuboDAO
    public String mCreate(TipoTuboDTO xtubo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `l_tipo_tubo` (`Nbre`,`Abreviatura`,`Estado`,`UsuarioS`) VALUES (?,?,?,?);", new Object[]{xtubo.getNombre(), xtubo.getAbreviatura(), Integer.valueOf(xtubo.getEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoTuboDAO
    public String mUpdate(TipoTuboDTO xtubo) {
        String sql = "UPDATE `l_tipo_tubo` SET `Nbre` = ?,   `Abreviatura` = ?,   `Estado` = ?,   `UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xtubo.getNombre(), xtubo.getAbreviatura(), Integer.valueOf(xtubo.getEstado()), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(xtubo.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
