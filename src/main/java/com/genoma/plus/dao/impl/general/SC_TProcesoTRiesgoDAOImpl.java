package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TProcesoTRiesgoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/SC_TProcesoTRiesgoDAOImpl.class */
public class SC_TProcesoTRiesgoDAOImpl implements SC_TProcesoTRiesgoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO
    public List<SC_TProcesoTRiesgoDTO> mListar(String xId_TRiesgo_TEvento) {
        String sql = "SELECT `s_sgc_tipoproceso`.`Nbre`, `s_sgc_sc_tproceso_triesgo`.Norden, `s_sgc_sc_tproceso_triesgo`.`Estado` FROM `s_sgc_sc_tproceso_triesgo` INNER JOIN `s_sgc_tipoproceso` \nON (`s_sgc_sc_tproceso_triesgo`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`) WHERE (`s_sgc_sc_tproceso_triesgo`.`Id_TRiesgo_TEvento` ='" + xId_TRiesgo_TEvento + "')\nORDER BY `s_sgc_tipoproceso`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TProcesoTRiesgoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_TProcesoTRiesgoDTO tipo = new SC_TProcesoTRiesgoDTO();
                tipo.setXIdTipoProceso(rs.getString("Nbre"));
                tipo.setOrden(rs.getInt("Norden"));
                tipo.setXEstado(rs.getInt("Estado"));
                return tipo;
            }
        };
        List<SC_TProcesoTRiesgoDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO
    public String mCreate(SC_TProcesoTRiesgoDTO xTipo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO s_sgc_sc_tproceso_triesgo(`Id_TProceso`,`Id_TRiesgo_TEvento`, Norden,`Estado`,`Id_UsuarioS`)VALUES (?,?,?,?,?)", new Object[]{xTipo.getXIdTipoProceso(), xTipo.getXIdTipoRiesgo(), Integer.valueOf(xTipo.getOrden()), Integer.valueOf(xTipo.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO
    public String mUpdate(SC_TProcesoTRiesgoDTO xTipo) {
        String sql = "UPDATE `s_sgc_sc_tproceso_triesgo` SET    `Norden` = ?,   `Estado` = ?,   `Id_UsuarioS` = ? WHERE `Id_TProceso` = ? and `Id_TRiesgo_TEvento`=?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xTipo.getOrden()), Integer.valueOf(xTipo.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xTipo.getXIdTipoProceso(), xTipo.getXIdTipoRiesgo()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO
    public List<GCGenericoDTO> listaTProceso() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TProcesoTRiesgoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre`FROM `s_sgc_tipoproceso`WHERE (`Estado` =1) ORDER BY Nbre ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO
    public List<GCGenericoDTO> listaTRiesgo() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TProcesoTRiesgoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `s_sgc_sc_triesgo_tevento`.`Id`, `s_sgc_sc_tiporiesgo`.`Nbre`FROM`s_sgc_sc_triesgo_tevento` INNER JOIN `s_sgc_sc_tiporiesgo` ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoRiesgo` = `s_sgc_sc_tiporiesgo`.`Id`) WHERE (`s_sgc_sc_triesgo_tevento`.`Estado` =1)ORDER BY `s_sgc_sc_tiporiesgo`.`Nbre` ASC;", mapper);
        return list;
    }
}
