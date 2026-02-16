package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.RHTipoCargoDAO;
import com.genoma.plus.dto.general.RHTipoCargoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/RHTipoCargoDAOImpl.class */
public class RHTipoCargoDAOImpl implements RHTipoCargoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.RHTipoCargoDAO
    public List<RHTipoCargoDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.RHTipoCargoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                RHTipoCargoDTO xtipocargo = new RHTipoCargoDTO();
                xtipocargo.setId(Long.valueOf(rs.getLong("Id")));
                xtipocargo.setNbre(rs.getString("Nbre"));
                xtipocargo.setNbreD785(rs.getString("Nbre_D785"));
                xtipocargo.setCodigo(rs.getString("Codigo"));
                xtipocargo.setEstado(rs.getInt("Estado"));
                return xtipocargo;
            }
        };
        List<RHTipoCargoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `Nbre_D785`, Codigo, `Estado` FROM `rh_tipo_cargo` ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.RHTipoCargoDAO
    public String mCreate(RHTipoCargoDTO xtipocargo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `rh_tipo_cargo`(`Nbre`,`Nbre_D785`, Codigo,`Estado`,`UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{xtipocargo.getNbre(), xtipocargo.getNbreD785(), xtipocargo.getCodigo(), Integer.valueOf(xtipocargo.getEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.RHTipoCargoDAO
    public String mUpdate(RHTipoCargoDTO xtipocargo) {
        int ctos = this.jdbcTemplate.update("UPDATE `rh_tipo_cargo`\nSET `Nbre` = ?,\n  `Nbre_D785` = ?,\n  `Codigo` = ?,\n  `Estado` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{xtipocargo.getNbre(), xtipocargo.getNbreD785(), xtipocargo.getCodigo(), Integer.valueOf(xtipocargo.getEstado()), Principal.usuarioSistemaDTO.getLogin(), xtipocargo.getId()});
        if (ctos == 0) {
        }
        return "Se inserto correctamente";
    }
}
