package com.genoma.plus.dao.impl.general;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.H_GrupoSistemasDAO;
import com.genoma.plus.dto.general.H_GrupoSistemasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/H_GrupoSistemasDAOImpl.class */
public class H_GrupoSistemasDAOImpl implements H_GrupoSistemasDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.H_GrupoSistemasDAO
    public List<H_GrupoSistemasDTO> listGrupoSistemas() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.H_GrupoSistemasDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                H_GrupoSistemasDTO grupoSistema = new H_GrupoSistemasDTO();
                grupoSistema.setId(rs.getInt("Id"));
                grupoSistema.setNombre(rs.getString("Nbre"));
                grupoSistema.setOrden(rs.getInt("Orden"));
                grupoSistema.setEstado(Boolean.valueOf(rs.getBoolean("Estado")));
                grupoSistema.setFecha(rs.getString("Fecha"));
                grupoSistema.setUsuario(rs.getString("UsuarioS"));
                return grupoSistema;
            }
        };
        List<H_GrupoSistemasDTO> listGrupo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `Orden`, `Estado`, `Fecha`, `UsuarioS` FROM `h_gruposistemas`", rowMapper);
        return listGrupo;
    }

    @Override // com.genoma.plus.dao.general.H_GrupoSistemasDAO
    public String mCreate(H_GrupoSistemasDTO xgrupo) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_gruposistemas` (`Nbre`, `Orden`, `Estado`, `Fecha`, `UsuarioS`) VALUES (?,?,?,?,?)", new Object[]{xgrupo.getNombre(), Integer.valueOf(xgrupo.getOrden()), xgrupo.getEstado(), xgrupo.getFecha(), xgrupo.getUsuario()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.H_GrupoSistemasDAO
    public String mUpdate(H_GrupoSistemasDTO xgrupo) {
        String sql = "UPDATE `h_gruposistemas` SET `Nbre`= ?, `Orden`= ?, `Estado`= ?, `Fecha`= ?, `UsuarioS`= ? WHERE `Id`= ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xgrupo.getNombre(), Integer.valueOf(xgrupo.getOrden()), xgrupo.getEstado(), xgrupo.getFecha(), xgrupo.getUsuario(), Integer.valueOf(xgrupo.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
