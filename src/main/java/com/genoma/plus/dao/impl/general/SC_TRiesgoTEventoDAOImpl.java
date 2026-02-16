package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TRiesgoTEventoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/SC_TRiesgoTEventoDAOImpl.class */
public class SC_TRiesgoTEventoDAOImpl implements SC_TRiesgoTEventoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO
    public List<SC_TRiesgoTEventoDTO> mListar() {
        String sql = "SELECT `s_sgc_sc_triesgo_tevento`.`Id`, `s_sgc_sc_tipoevento`.`Nbre` , `s_sgc_sc_triesgo_tevento`.`NOrden`, `s_sgc_sc_triesgo_tevento`.`Estado`\nFROM `s_sgc_sc_triesgo_tevento` INNER JOIN `s_sgc_sc_tipoevento` ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\nINNER JOIN `s_sgc_sc_tiporiesgo` ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoRiesgo` = `s_sgc_sc_tiporiesgo`.`Id`) WHERE (`s_sgc_sc_triesgo_tevento`.`Id_TipoRiesgo` ='" + Principal.txtNo.getText() + "')\nORDER BY `s_sgc_sc_triesgo_tevento`.`NOrden` ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TRiesgoTEventoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_TRiesgoTEventoDTO tipo = new SC_TRiesgoTEventoDTO();
                tipo.setXId(rs.getInt("Id"));
                tipo.setXTipoEvento(rs.getString("Nbre"));
                tipo.setXOrden(rs.getInt("NOrden"));
                tipo.setXEstado(rs.getInt("Estado"));
                return tipo;
            }
        };
        List<SC_TRiesgoTEventoDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO
    public List<GCGenericoDTO> listaTEvento() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TRiesgoTEventoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`,`Nbre` FROM `s_sgc_sc_tipoevento` WHERE Estado=1 ORDER BY Nbre ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO
    public List<GCGenericoDTO> listaTRiesgo() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TRiesgoTEventoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`,`Nbre`FROM `s_sgc_sc_tiporiesgo` WHERE Estado=1 ORDER BY Nbre ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO
    public String mCreate(SC_TRiesgoTEventoDTO xTipo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO `s_sgc_sc_triesgo_tevento` (`Id_TipoRiesgo`,`Id_TipoEvento`,`NOrden`,`Estado`,`Id_UsuarioS`)VALUES (?,?,?,?,?)", new Object[]{xTipo.getXTipoRiesgo(), xTipo.getXTipoEvento(), Integer.valueOf(xTipo.getXOrden()), Integer.valueOf(xTipo.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO
    public String mUpdate(SC_TRiesgoTEventoDTO xTipo) {
        String sql = "UPDATE `s_sgc_sc_triesgo_tevento`\nSET `NOrden` = ?,  `Estado` = ? ,  `Id_UsuarioS` = ?WHERE `Id` = ?    AND `Id_TipoRiesgo` = ?    AND `Id_TipoEvento` = ?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xTipo.getXOrden()), Integer.valueOf(xTipo.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(xTipo.getXId()), xTipo.getXTipoRiesgo(), xTipo.getXTipoEvento()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
