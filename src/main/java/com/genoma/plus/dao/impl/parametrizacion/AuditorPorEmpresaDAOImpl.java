package com.genoma.plus.dao.impl.parametrizacion;

import com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO;
import com.genoma.plus.dto.parametrizacion.AuditorPorEmpresaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/AuditorPorEmpresaDAOImpl.class */
public class AuditorPorEmpresaDAOImpl implements AuditorPorEmpresaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO
    public List<Object[]> mCargarCombo() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.AuditorPorEmpresaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n  rh_tipo_persona_cargon.Id,\n  persona.NUsuario,\n  persona.Id_persona\nFROM\n  persona\n  INNER JOIN rh_tipo_persona_cargon\n    ON (\n      persona.Id_persona = rh_tipo_persona_cargon.Id_Persona\n    )\nWHERE (\n    rh_tipo_persona_cargon.Lider = 1\n    AND rh_tipo_persona_cargon.Estado = 1\n  )\nORDER BY persona.NUsuario ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO
    public String mGrabar(AuditorPorEmpresaDTO dto) {
        String xsql = "INSERT INTO g_empresa_persona_auditoria (\n  idEmpresa,\n  idPersonaCargoRh,\n  fecha,\n  estado,\n  idUsuarioRh\n) VALUES (\n    '" + dto.getIdEmpresa() + "',\n    '" + dto.getIdPersonaCargoRh() + "',\n    '" + dto.getFecha() + "',\n    '" + dto.getEstado() + "',\n    '" + dto.getIdUsuarioRh() + "'\n  );";
        int list = this.jdbcTemplate.update(xsql);
        return list + "";
    }

    @Override // com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO
    public String mUpdate(AuditorPorEmpresaDTO dto) {
        String xsql = "UPDATE\n  g_empresa_persona_auditoria\nSET\n  estado = '" + dto.getEstado() + "'\nWHERE id = '" + dto.getId() + "';";
        int list = this.jdbcTemplate.update(xsql);
        return list + "";
    }

    @Override // com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO
    public List<Object[]> mCargarTabla(AuditorPorEmpresaDTO dto) {
        String xsql = "SELECT\n    `g_empresa_persona_auditoria`.`id`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `auditor`\n    , `rh_tipo_cargo`.`Nbre` AS `cargo`\n    , `g_empresa_persona_auditoria`.`fecha`\n    , `g_empresa_persona_auditoria`.`estado`\nFROM\n    `g_empresa_persona_auditoria`\n    INNER JOIN `rh_tipo_persona_cargon` \n        ON (`g_empresa_persona_auditoria`.`idPersonaCargoRh` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`g_empresa_persona_auditoria`.`idEmpresa` ='" + dto.getIdEmpresa() + "')\nORDER BY `auditor` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.AuditorPorEmpresaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO
    public String mValidarExiste(AuditorPorEmpresaDTO dto) {
        String xsql = "SELECT id FROM g_empresa_persona_auditoria WHERE idPersonaCargoRh ='" + dto.getIdPersonaCargoRh() + "' and idEmpresa='" + dto.getIdEmpresa() + "'";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.AuditorPorEmpresaDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        String id = "";
        if (!list.isEmpty()) {
            id = list.get(0)[0].toString();
        }
        return id;
    }
}
