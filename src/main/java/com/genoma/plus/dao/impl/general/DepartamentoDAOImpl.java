package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.DepartamentoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.DepartamentoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/DepartamentoDAOImpl.class */
public class DepartamentoDAOImpl implements DepartamentoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.DepartamentoDAO
    public List<DepartamentoDTO> listDepartamento() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.DepartamentoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                DepartamentoDTO departamento = new DepartamentoDTO();
                departamento.setId(rs.getString("Id"));
                departamento.setNombre(rs.getString("Departamento"));
                departamento.setCodPais(rs.getString("Pais"));
                departamento.setEstado(rs.getInt("Estado"));
                return departamento;
            }
        };
        List<DepartamentoDTO> lsTipo = this.jdbcTemplate.query("SELECT\n    `g_departamento`.`Id`\n    , Ucase(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_pais`.`Nbre` AS `Pais`\n    , `g_departamento`.`Estado`\nFROM\n    `g_pais`\n    INNER JOIN `g_departamento` \n        ON (`g_pais`.`Id` = `g_departamento`.`CodPais`)\nORDER BY `Pais` ASC, `Departamento` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.DepartamentoDAO
    public List<GCGenericoDTO> listPais() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.DepartamentoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setIdString(rs.getString("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `g_pais` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.DepartamentoDAO
    public String mCreate(DepartamentoDTO xdepartamento) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO `g_departamento` (`Id`,`Nbre`,`CodPais`,`Estado`, `UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{xdepartamento.getId(), xdepartamento.getNombre(), xdepartamento.getCodPais(), Integer.valueOf(xdepartamento.getEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.DepartamentoDAO
    public String mUpdate(DepartamentoDTO xdepartamento) {
        String sql = "UPDATE\n  `g_departamento`\nSET\n  `Nbre` = ?,\n  `CodPais` = ?,\n  `Estado` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xdepartamento.getNombre(), xdepartamento.getCodPais(), Integer.valueOf(xdepartamento.getEstado()), Principal.usuarioSistemaDTO.getLogin(), xdepartamento.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
