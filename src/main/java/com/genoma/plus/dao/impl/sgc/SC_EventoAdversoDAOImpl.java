package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.SC_EventoAdversoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SC_EventoAdversoDAOImpl.class */
public class SC_EventoAdversoDAOImpl implements SC_EventoAdversoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public List<SC_EventoAdversoDTO> list(String xidIngreso) {
        String sql = "SELECT     `s_sgc_sc_evento_adverso`.`Id`     , `s_sgc_sc_evento_adverso`.`FechaE`     , `s_sgc_sc_evento_adverso`.`HoraE`     , `s_sgc_tipoproceso`.`Nbre` AS `Proceso`     , `s_sgc_sc_evento_adverso`.`Id_PersonaR`     , `s_sgc_sc_tipoevento`.`Nbre` AS `TipoEvento`     , `s_sgc_sc_evento_adverso`.`Descripcion`     , `s_sgc_sc_evento_adverso`.`EstaI`     , `s_sgc_sc_evento_adverso`.`TAPreventiva`     , `s_sgc_sc_evento_adverso`.`DetalleLesiones`     , `s_sgc_sc_evento_adverso`.`AccionesTomadas`     , `s_sgc_sc_evento_adverso`.`Estado` FROM     `s_sgc_sc_evento_adverso`     INNER JOIN `s_sgc_tipoproceso`          ON (`s_sgc_sc_evento_adverso`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)     INNER JOIN `s_sgc_sc_triesgo_tevento`          ON (`s_sgc_sc_triesgo_tevento`.`Id` = `s_sgc_sc_evento_adverso`.`Id_TRiesgoE`)     INNER JOIN `s_sgc_sc_tipoevento`          ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) WHERE (`s_sgc_sc_evento_adverso`.`Id_Anulado` =1     AND `s_sgc_sc_evento_adverso`.`Id_Ingreso` ='" + xidIngreso + "') ORDER BY `s_sgc_sc_evento_adverso`.`FechaE` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_EventoAdversoDTO evento = new SC_EventoAdversoDTO();
                evento.setId(rs.getInt("Id"));
                evento.setFecha(rs.getString("FechaE"));
                evento.setHora(rs.getString("HoraE"));
                evento.setIdTProceso(rs.getString("Proceso"));
                evento.setPersonaR(rs.getInt("Id_PersonaR"));
                evento.setIdTRiesgoE(rs.getString("TipoEvento"));
                evento.setDescripcion(rs.getString("Descripcion"));
                evento.setEstaI(rs.getInt("EstaI"));
                evento.setTAPreventiva(rs.getInt("TAPreventiva"));
                evento.setDetalleLesion(rs.getString("DetalleLesiones"));
                evento.setAccionT(rs.getString("AccionesTomadas"));
                evento.setEstado(rs.getInt("Estado"));
                return evento;
            }
        };
        List<SC_EventoAdversoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public String create_return_id(final SC_EventoAdversoDTO evento) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl.2
            final String sql = "INSERT INTO `s_sgc_sc_evento_adverso`(`FechaE`,`HoraE`,`Id_Ingreso`,`Id_TProceso`,`Id_PersonaR`,`Id_TRiesgoE`,`Descripcion`,`EstaI`,`TAPreventiva`,`DetalleLesiones`,`AccionesTomadas`,`Estado`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `s_sgc_sc_evento_adverso`(`FechaE`,`HoraE`,`Id_Ingreso`,`Id_TProceso`,`Id_PersonaR`,`Id_TRiesgoE`,`Descripcion`,`EstaI`,`TAPreventiva`,`DetalleLesiones`,`AccionesTomadas`,`Estado`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setString(1, evento.getFecha());
                ps.setString(2, evento.getHora());
                ps.setInt(3, evento.getIdIngreso());
                ps.setString(4, evento.getIdTProceso());
                ps.setInt(5, evento.getPersonaR());
                ps.setString(6, evento.getIdTRiesgoE());
                ps.setString(7, evento.getDescripcion());
                ps.setInt(8, evento.getEstaI());
                ps.setInt(9, evento.getTAPreventiva());
                ps.setString(10, evento.getDetalleLesion());
                ps.setString(11, evento.getAccionT());
                ps.setInt(12, evento.getEstado());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdEventoA = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdEventoA-->" + xIdEventoA);
        return xIdEventoA;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public String update(SC_EventoAdversoDTO evento) {
        String sql = "UPDATE `s_sgc_sc_evento_adverso` SET `FechaE` = ?,   `HoraE` = ?,   `Id_TProceso` = ?,   `Id_TRiesgoE` = ?,   `Descripcion` = ?,   `EstaI` = ?,   `TAPreventiva` = ?,   `DetalleLesiones` = ?,   `AccionesTomadas` = ?,   `Estado` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{evento.getFecha(), evento.getHora(), evento.getIdTProceso(), evento.getIdTRiesgoE(), evento.getDescripcion(), Integer.valueOf(evento.getEstaI()), Integer.valueOf(evento.getTAPreventiva()), evento.getDetalleLesion(), evento.getAccionT(), Integer.valueOf(evento.getEstado()), Integer.valueOf(evento.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public String delete(SC_EventoAdversoDTO evento) {
        String sql = "UPDATE `s_sgc_sc_evento_adverso` SET `Id_Anulado` = ?,   `MotivoAnulacion` = ?,   `FechaAnulacion` = ?,   `UsuarioAnulacion` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(evento.getIdAnulado()), evento.getMotivoAnulacion(), evento.getFechaAnulacion(), evento.getUsuarioAnulacion(), Integer.valueOf(evento.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public List<GCGenericoDTO> listaTRiesgo(String xidTipoProceso) {
        String xsql = "SELECT `s_sgc_sc_triesgo_tevento`.`Id`, UCASE(CONCAT(s_sgc_sc_tiporiesgo.`Nbre`, ' _ ', `s_sgc_sc_tipoevento`.`Nbre`)) `Nbre` FROM `s_sgc_sc_tproceso_triesgo` INNER JOIN `s_sgc_sc_triesgo_tevento`   ON (`s_sgc_sc_tproceso_triesgo`.`Id_TRiesgo_TEvento` = `s_sgc_sc_triesgo_tevento`.`Id`) INNER JOIN `s_sgc_sc_tipoevento` ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)  INNER JOIN `s_sgc_sc_tiporiesgo` ON (`s_sgc_sc_tiporiesgo`.`Id` = s_sgc_sc_triesgo_tevento.`Id_TipoRiesgo`)  WHERE (`s_sgc_sc_tproceso_triesgo`.`Id_TProceso` ='" + xidTipoProceso + "' AND `s_sgc_sc_triesgo_tevento`.`Estado` =1 AND `s_sgc_sc_tipoevento`.`Estado` =1) ORDER BY UCASE(CONCAT(s_sgc_sc_tiporiesgo.`Nbre`, ' _ ', `s_sgc_sc_tipoevento`.`Nbre`)) ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl.3
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

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public List<GCGenericoDTO> listaTProceso() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `s_sgc_tipoproceso`.`Id`, `s_sgc_tipoproceso`.`Nbre` FROM `s_sgc_usuario_tipoproceso` \nINNER JOIN `s_sgc_tipoproceso` ON (`s_sgc_usuario_tipoproceso`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`) \nWHERE (`s_sgc_tipoproceso`.`Estado` =1) GROUP BY `s_sgc_tipoproceso`.`Id` ORDER BY `s_sgc_tipoproceso`.`Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoDAO
    public List<SC_EventoAdversoDTO> listaCheck(String xIdTipoRiesgo) {
        String sql = "SELECT `s_sgc_sc_tipoevento`.`EsPanorama`, IF(Tipo=2,1,0) AS `Tipo` FROM `s_sgc_sc_triesgo_tevento` INNER JOIN `s_sgc_sc_tipoevento` ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) INNER JOIN `s_sgc_sc_tipoevento_tipoca` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) INNER JOIN `s_sgc_sc_tipocosecuencia_acciones`  ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`) WHERE (`s_sgc_sc_triesgo_tevento`.`Id` ='" + xIdTipoRiesgo + "' AND `s_sgc_sc_tipoevento_tipoca`.`Estado` =1 AND `s_sgc_sc_tipocosecuencia_acciones`.`Estado` =1) GROUP BY `Tipo`ORDER BY `Tipo` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl.5
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SC_EventoAdversoDTO evento = new SC_EventoAdversoDTO();
                evento.setEstaI(rs.getInt("EsPanorama"));
                evento.setTAPreventiva(rs.getInt("Tipo"));
                return evento;
            }
        };
        List<SC_EventoAdversoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }
}
