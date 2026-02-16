package com.genoma.plus.dao.impl.general;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.H_TipoSistemasDAO;
import com.genoma.plus.dto.general.H_TipoSistemasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/H_TipoSistemasDAOImpl.class */
public class H_TipoSistemasDAOImpl implements H_TipoSistemasDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.H_TipoSistemasDAO
    public List<Object[]> listTipoSistemas() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.H_TipoSistemasDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Integer.valueOf(rs.getInt(3)), rs.getString(4), Integer.valueOf(rs.getInt(5)), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
                return fila;
            }
        };
        List<Object[]> listTSistemas = this.jdbcTemplate.query("SELECT\n    `h_tiposistemas`.`Id`\n    , `h_tiposistemas`.`Nbre`\n    , `h_tiposistemas`.`Id_GrupoSistemas`\n    , `h_gruposistemas`.`Nbre`\n    , `h_tiposistemas`.`Orden`\n    , IFNULL(`h_tiposistemas`.`VDefecto`,'') AS VDefecto\n    , `h_tiposistemas`.`Estado`\nFROM\n    `baseserver`.`h_tiposistemas`\n    INNER JOIN `baseserver`.`h_gruposistemas` \n        ON (`h_tiposistemas`.`Id_GrupoSistemas` = `h_gruposistemas`.`Id`);", rowMapper);
        return listTSistemas;
    }

    @Override // com.genoma.plus.dao.general.H_TipoSistemasDAO
    public String mCreate(H_TipoSistemasDTO xTipos) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_tiposistemas`(`Id_GrupoSistemas`,`Nbre`,`Orden`,`VDefecto`,`Estado`,`Fecha`,`UsuarioS`) VALUES (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(xTipos.getIdGrupo()), xTipos.getNombre(), Integer.valueOf(xTipos.getOrden()), xTipos.getVDefecto(), xTipos.getEstado(), xTipos.getFecha(), xTipos.getUsuario()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.H_TipoSistemasDAO
    public String mUpdate(H_TipoSistemasDTO xTipos) {
        String sql = "UPDATE `h_tiposistemas` SET `Id_GrupoSistemas`= ?,`Nbre`= ?,`Orden`= ?,`VDefecto`= ?,`Estado`= ?,`Fecha`= ?,`UsuarioS`= ? WHERE `Id`= ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xTipos.getIdGrupo()), xTipos.getNombre(), Integer.valueOf(xTipos.getOrden()), xTipos.getVDefecto(), xTipos.getEstado(), xTipos.getFecha(), xTipos.getUsuario(), Integer.valueOf(xTipos.getId())});
        if (ctos == 0) {
            sql = " 0 filas afectadas";
        }
        return sql;
    }
}
