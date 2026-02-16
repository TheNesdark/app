package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoEventoSCDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoEventoSCDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoEventoSCDAOImpl.class */
public class TipoEventoSCDAOImpl implements TipoEventoSCDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoEventoSCDAO
    public List<TipoEventoSCDTO> list(String xnombre) {
        String sql = "SELECT `s_sgc_sc_tipoevento`.`Id`, `s_sgc_sc_tipoevento`.`Nbre`, `s_sgc_sc_tipoevento`.`NDiasV`, `s_sgc_sc_tipoevento`.`CV256`, `s_sgc_sc_tipoevento`.`RAnalisis`, `s_sgc_sc_tipoevento`.`EsPanorama`\n, `s_sgc_sc_tipoevento`.`AplicaM`, `s_sgc_sc_tipoevento`.`Estado`, `s_sgc_tipo_categoria`.`Nbre` AS `Categoria` FROM `s_sgc_sc_tipoevento` INNER JOIN `s_sgc_tipo_categoria` \nON (`s_sgc_sc_tipoevento`.`Id_Categoria` = `s_sgc_tipo_categoria`.`Id`) WHERE (`s_sgc_sc_tipoevento`.`Nbre` LIKE '%" + xnombre + "%') ORDER BY `s_sgc_sc_tipoevento`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoEventoSCDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoEventoSCDTO evento = new TipoEventoSCDTO();
                evento.setId(rs.getInt("Id"));
                evento.setNombre(rs.getString("Nbre"));
                evento.setNDias(rs.getInt("NDiasV"));
                evento.setCV256(rs.getInt("CV256"));
                evento.setAnalisis(rs.getInt("RAnalisis"));
                evento.setEsPanorama(rs.getInt("EsPanorama"));
                evento.setAplicaM(rs.getInt("AplicaM"));
                evento.setEstado(rs.getInt("Estado"));
                evento.setIdTipoCategoria(rs.getString("Categoria"));
                return evento;
            }
        };
        List<TipoEventoSCDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.TipoEventoSCDAO
    public String create(TipoEventoSCDTO evento) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_tipoevento`(`Nbre`, `RAnalisis`, `NDiasV`, `CV256`, `EsPanorama`, `AplicaM`, `Id_Categoria`, `Estado`, `Id_UsuarioS`) VALUES (?,?,?,?,?,?,?,?,?);", new Object[]{evento.getNombre(), Integer.valueOf(evento.getAnalisis()), Integer.valueOf(evento.getNDias()), Integer.valueOf(evento.getCV256()), Integer.valueOf(evento.getEsPanorama()), Integer.valueOf(evento.getAplicaM()), evento.getIdTipoCategoria(), Integer.valueOf(evento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoEventoSCDAO
    public String update(TipoEventoSCDTO evento) {
        String sql = "UPDATE `s_sgc_sc_tipoevento` SET    `Nbre` = ?,   `RAnalisis` = ?,   `NDiasV` = ?,   `CV256` = ?,   `EsPanorama` = ?,   `AplicaM` = ?,   `Id_Categoria` = ?,   `Estado` = ?,   `Id_UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{evento.getNombre(), Integer.valueOf(evento.getAnalisis()), Integer.valueOf(evento.getNDias()), Integer.valueOf(evento.getCV256()), Integer.valueOf(evento.getEsPanorama()), Integer.valueOf(evento.getAplicaM()), evento.getIdTipoCategoria(), Integer.valueOf(evento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(evento.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoEventoSCDAO
    public List<GCGenericoDTO> listaTCategoria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoEventoSCDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `s_sgc_tipo_categoria` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }
}
