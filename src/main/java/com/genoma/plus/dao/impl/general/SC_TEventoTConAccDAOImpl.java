package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SC_TEventoTConAccDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TEventoTConAccDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/SC_TEventoTConAccDAOImpl.class */
public class SC_TEventoTConAccDAOImpl implements SC_TEventoTConAccDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.SC_TEventoTConAccDAO
    public List<SC_TEventoTConAccDTO> mListar(String xTipoEvento) {
        String sql = "SELECT `s_sgc_sc_tipoevento_tipoca`.`Id`, `s_sgc_sc_tipocosecuencia_acciones`.`Nbre`, `s_sgc_sc_tipoevento_tipoca`.`NOrden`, `s_sgc_sc_tipoevento_tipoca`.`Estado`, \nIF(`s_sgc_sc_tipocosecuencia_acciones`.`Tipo`=0, 'CONSECUENCIAS', IF(`s_sgc_sc_tipocosecuencia_acciones`.`Tipo`=1, 'CORRECTIVO INMEDIATO', IF(`s_sgc_sc_tipocosecuencia_acciones`.`Tipo`=2,'ACCIONES PREVENTIVAS', 'N/A'))) AS Tipo\nFROM `s_sgc_sc_tipoevento_tipoca` INNER JOIN `s_sgc_sc_tipocosecuencia_acciones` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`) \nWHERE (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento` ='" + xTipoEvento + "') ORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC, `s_sgc_sc_tipocosecuencia_acciones`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TEventoTConAccDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_TEventoTConAccDTO tipo = new SC_TEventoTConAccDTO();
                tipo.setId(rs.getInt("Id"));
                tipo.setTipoConAcc(rs.getString("Nbre"));
                tipo.setNOrden(rs.getInt("NOrden"));
                tipo.setEstado(rs.getInt("Estado"));
                tipo.setTipo(rs.getString("Tipo"));
                return tipo;
            }
        };
        List<SC_TEventoTConAccDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.SC_TEventoTConAccDAO
    public List<GCGenericoDTO> listaAcciones(int xtipo) {
        String xsql = "SELECT `Id`, `Nbre` FROM `s_sgc_sc_tipocosecuencia_acciones` WHERE (`Estado` =1 AND Tipo='" + xtipo + "') ORDER BY `Nbre` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.SC_TEventoTConAccDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.SC_TEventoTConAccDAO
    public String mCreate(SC_TEventoTConAccDTO xTipo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_tipoevento_tipoca`(`Id_TipoEvento`,`Id_TipoCAccion`,`NOrden`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(xTipo.getTipoEvento()), xTipo.getTipoConAcc(), Integer.valueOf(xTipo.getNOrden()), Integer.valueOf(xTipo.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.SC_TEventoTConAccDAO
    public String mUpdate(SC_TEventoTConAccDTO xTipo) {
        String sql = "UPDATE `s_sgc_sc_tipoevento_tipoca` SET `Id_TipoCAccion` = ?,   `NOrden` = ?,   `Estado` = ?,   `Id_UsuarioS` = ? WHERE `Id` = ?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xTipo.getTipoConAcc(), Integer.valueOf(xTipo.getNOrden()), Integer.valueOf(xTipo.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(xTipo.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
