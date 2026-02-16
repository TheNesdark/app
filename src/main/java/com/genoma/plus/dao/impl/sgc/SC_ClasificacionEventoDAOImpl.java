package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_ClasificacionEventoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SC_ClasificacionEventoDAOImpl.class */
public class SC_ClasificacionEventoDAOImpl implements SC_ClasificacionEventoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO
    public List<SC_ClasificacionEventoDTO> list(String xidEvento) {
        String sql = "SELECT      `s_sgc_sc_evento_adverso_clasificacion`.`FechaC`     , `s_sgc_sc_tipoclasificacion`.`Nbre`     , `s_sgc_sc_evento_adverso_clasificacion`.`EsPrevenible`     , `s_sgc_sc_evento_adverso_clasificacion`.`Justificacion`     , `s_sgc_sc_evento_adverso_clasificacion`.`Estado` FROM     `s_sgc_sc_evento_adverso_clasificacion`     INNER JOIN `s_sgc_sc_tipoclasificacion`          ON (`s_sgc_sc_evento_adverso_clasificacion`.`Id_Clasificacion` = `s_sgc_sc_tipoclasificacion`.`Id`) WHERE (`s_sgc_sc_evento_adverso_clasificacion`.`Id_Evento` ='" + xidEvento + "'     AND `s_sgc_sc_evento_adverso_clasificacion`.`Id_Anulado` =1);";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_ClasificacionEventoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_ClasificacionEventoDTO evento = new SC_ClasificacionEventoDTO();
                evento.setFechaC(rs.getString("FechaC"));
                evento.setIdClasificacion(rs.getString("Nbre"));
                evento.setEsPrevenible(rs.getInt("EsPrevenible"));
                evento.setJustificacion(rs.getString("Justificacion"));
                evento.setEstado(rs.getInt("Estado"));
                return evento;
            }
        };
        List<SC_ClasificacionEventoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO
    public String create(SC_ClasificacionEventoDTO evento) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_evento_adverso_clasificacion` (Id_Evento,`FechaC`,`Id_Clasificacion`,`EsPrevenible`,`Justificacion`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(evento.getIdEvento()), evento.getFechaC(), evento.getIdClasificacion(), Integer.valueOf(evento.getEsPrevenible()), evento.getJustificacion(), Integer.valueOf(evento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO
    public String update(SC_ClasificacionEventoDTO evento) {
        String sql = "UPDATE `s_sgc_sc_evento_adverso_clasificacion` SET `FechaC` = ?,   `Id_Clasificacion` = ?,   `EsPrevenible` = ?,   `Justificacion` = ?,   `Estado` = ?,   `Id_UsuarioS` = ? WHERE `Id_Evento` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{evento.getFechaC(), evento.getIdClasificacion(), Integer.valueOf(evento.getEsPrevenible()), evento.getJustificacion(), Integer.valueOf(evento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(evento.getIdEvento())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO
    public String delete(SC_ClasificacionEventoDTO evento) {
        String sql = "UPDATE `s_sgc_sc_evento_adverso_clasificacion` SET `Id_Anulado` = ?,   `MotivoAnulacion` = ?,   `FechaAnulacion` = ?,   `UsuarioAnulacion` = ? WHERE `Id_Evento` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(evento.getIdAnulado()), evento.getMotivoAnulacion(), evento.getFechaAnulacion(), evento.getUsuarioAnulacion(), Integer.valueOf(evento.getIdEvento())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO
    public List<GCGenericoDTO> listaClasificacion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_ClasificacionEventoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `s_sgc_sc_tipoclasificacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }
}
