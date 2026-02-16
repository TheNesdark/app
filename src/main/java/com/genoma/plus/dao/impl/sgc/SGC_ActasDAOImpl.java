package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.sgc.SGC_ActasDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAccionConclusionDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAsistentesDTO;
import com.genoma.plus.dto.sgc.SGC_ActasDTO;
import com.genoma.plus.dto.sgc.SGC_Ficha5w1hDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SGC_ActasDAOImpl.class */
public class SGC_ActasDAOImpl implements SGC_ActasDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<SGC_ActasDTO> listActas(String FechaI, String FechaF, String IdTipoProceso, String Objetivo) {
        String sql;
        if (IdTipoProceso.isEmpty()) {
            sql = "SELECT\n  `s_sgc_actas`.`Id`,\n  `s_sgc_actas`.`FechaA`,\n  `s_sgc_actas`.`Hora`,\n  `s_sgc_actas`.`HoraFinal`,\n  `s_sgc_tipoproceso`.`Nbre` AS `TipoProceso`,\n  `s_sgc_actas`.`Id_Actividad`,\n  `s_sgc_actas`.`Lugar`,\n  `s_sgc_tipo_reunion`.`Nbre` AS `TipoReunion`,\n  `s_sgc_actas`.`Objetivo`,\n  `s_sgc_actas`.`Aclaraciones`,\n  `s_sgc_actas`.`Desarrollo`,\n  `s_sgc_actas`.`Estado`\nFROM\n  `s_sgc_tipoproceso`\n  INNER JOIN `s_sgc_actas` ON (`s_sgc_tipoproceso`.`Id` = `s_sgc_actas`.`Id_Proceso`)\n  INNER JOIN `s_sgc_tipo_reunion` ON (`s_sgc_tipo_reunion`.`Id` = `s_sgc_actas`.`Id_Tipo`)\nWHERE (`s_sgc_actas`.`FechaA`>='" + FechaI + "' AND `s_sgc_actas`.`FechaA`<='" + FechaF + "' AND `s_sgc_actas`.`Objetivo` LIKE '%" + Objetivo + "%')\nORDER BY `s_sgc_actas`.`FechaA` DESC;";
        } else {
            sql = "SELECT\n  `s_sgc_actas`.`Id`,\n  `s_sgc_actas`.`FechaA`,\n  `s_sgc_actas`.`Hora`,\n  `s_sgc_actas`.`HoraFinal`,\n  `s_sgc_tipoproceso`.`Nbre` AS `TipoProceso`,\n  `s_sgc_actas`.`Id_Actividad`,\n  `s_sgc_actas`.`Lugar`,\n  `s_sgc_tipo_reunion`.`Nbre` AS `TipoReunion`,\n  `s_sgc_actas`.`Objetivo`,\n  `s_sgc_actas`.`Aclaraciones`,\n  `s_sgc_actas`.`Desarrollo`,\n  `s_sgc_actas`.`Estado`\nFROM\n  `s_sgc_tipoproceso`\n  INNER JOIN `s_sgc_actas` ON (`s_sgc_tipoproceso`.`Id` = `s_sgc_actas`.`Id_Proceso`)\n  INNER JOIN `s_sgc_tipo_reunion` ON (`s_sgc_tipo_reunion`.`Id` = `s_sgc_actas`.`Id_Tipo`)\nWHERE (`s_sgc_actas`.`FechaA`>='" + FechaI + "' AND `s_sgc_actas`.`FechaA`<='" + FechaF + "' AND s_sgc_tipoproceso.`Id`='" + IdTipoProceso + "' AND `s_sgc_actas`.`Objetivo` LIKE '%" + Objetivo + "%')\nORDER BY `s_sgc_actas`.`FechaA` DESC;";
        }
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_ActasDTO actas = new SGC_ActasDTO();
                actas.setIdActas(rs.getInt("Id"));
                actas.setFechActa(rs.getString("FechaA"));
                actas.setHora(rs.getString("Hora"));
                actas.setHora(rs.getString("HoraFinal"));
                actas.setIdProceso(rs.getString("TipoProceso"));
                actas.setIdActividad(rs.getString("Id_Actividad"));
                actas.setLugar(rs.getString("Lugar"));
                actas.setIdTipo(rs.getString("TipoReunion"));
                actas.setObjetivo(rs.getString("Objetivo"));
                actas.setAclaraciones(rs.getString("Aclaraciones"));
                actas.setDesarrollo(rs.getString("Desarrollo"));
                actas.setEstado(rs.getInt("Estado"));
                return actas;
            }
        };
        List<SGC_ActasDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<SGC_ActasAccionConclusionDTO> listConclusion(String xidActas) {
        String sql = "SELECT `s_sgc_actas_accion_conclusiones`.`Id`, `s_sgc_tipo_accion`.`Nbre` AS `TipoAccion`, `s_sgc_actas_accion_conclusiones`.`Detalle`, `s_sgc_tipoproceso`.`Nbre` AS `TipoProceso`, `persona`.`NUsuario` , `s_sgc_actas_accion_conclusiones`.`FechaEjecucion`, `s_sgc_actas_accion_conclusiones`.`Id_Ficha` FROM `s_sgc_actas_accion_conclusiones`INNER JOIN `s_sgc_tipo_accion` ON (`s_sgc_actas_accion_conclusiones`.`Id_tipoaccion` = `s_sgc_tipo_accion`.`Id`) INNER JOIN `s_sgc_tipoproceso` ON (`s_sgc_actas_accion_conclusiones`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`) INNER JOIN `rh_tipo_persona_cargon` ON (`s_sgc_actas_accion_conclusiones`.`Id_RhPersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN `persona` ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`) WHERE (`s_sgc_actas_accion_conclusiones`.`Id_Actas` ='" + xidActas + "');";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_ActasAccionConclusionDTO actas = new SGC_ActasAccionConclusionDTO();
                actas.setId(rs.getInt("Id"));
                actas.setIdTipoAccion(rs.getString("TipoAccion"));
                actas.setDetalle(rs.getString("Detalle"));
                actas.setIdTipoProceso(rs.getString("TipoProceso"));
                actas.setIdRhPersonaC(rs.getString("NUsuario"));
                actas.setFechaEjecucion(rs.getString("FechaEjecucion"));
                actas.setIdFicha(rs.getInt("Id_Ficha"));
                return actas;
            }
        };
        List<SGC_ActasAccionConclusionDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<SGC_ActasAsistentesDTO> listAsistentes(String xidActas) {
        String sql = "SELECT s_sgc_actas_asistentes.`Id_TipoProceso`, `s_sgc_actas_asistentes`.`Proceso` AS `TipoProceso`, s_sgc_actas_asistentes.`Id_RhPersonaCargo` , `s_sgc_actas_asistentes`.`Nbre_Integrante`, s_sgc_actas_asistentes.`Cargo`, IF(s_sgc_actas_asistentes.`Firma` <> '', 1,0) AS Firmado, s_sgc_actas_asistentes.`EsExterno`, s_sgc_actas_asistentes.Id  \nFROM `s_sgc_actas_asistentes` WHERE (`s_sgc_actas_asistentes`.`Id_Actas` ='" + xidActas + "') ORDER BY TipoProceso ASC, Nbre_Integrante ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_ActasAsistentesDTO actas = new SGC_ActasAsistentesDTO();
                actas.setIdTipoProceso(rs.getString("Id_TipoProceso"));
                actas.setProceso(rs.getString("TipoProceso"));
                actas.setIdRhPersonaC(rs.getString("Id_RhPersonaCargo"));
                actas.setNbreIntegrante(rs.getString("Nbre_Integrante"));
                actas.setCargo(rs.getString("Cargo"));
                actas.setFirmo(rs.getInt("Firmado"));
                actas.setEsExterno(rs.getInt("EsExterno"));
                actas.setId(Long.valueOf(rs.getLong("Id")));
                return actas;
            }
        };
        List<SGC_ActasAsistentesDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<GCGenericoDTO> lisTipoProceso() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `s_sgc_tipoproceso`.`Id`, `s_sgc_tipoproceso`.`Nbre` FROM `s_sgc_tipoproceso` WHERE (`s_sgc_tipoproceso`.`Estado` =1) ORDER BY `s_sgc_tipoproceso`.`Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<SGC_ActasAsistentesDTO> listComboUsuario(String xIdTipoProceso) {
        String xsql = "SELECT `rh_tipo_persona_cargon`.`Id`, `persona`.`NUsuario`, rh_tipo_cargo.`Nbre` AS Cargo\nFROM `rh_tipo_persona_cargon` \nINNER JOIN `persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\nINNER JOIN `s_sgc_usuario_tipoproceso` ON (`s_sgc_usuario_tipoproceso`.`Id_Usuario` = `persona`.`Id_persona`) \nINNER JOIN `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) \nINNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nWHERE (`s_sgc_usuario_tipoproceso`.`Id_TipoProceso` ='" + xIdTipoProceso + "') ORDER BY `persona`.`NUsuario` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_ActasAsistentesDTO g = new SGC_ActasAsistentesDTO();
                g.setIdRhPersonaC(rs.getString("Id"));
                g.setNbreIntegrante(rs.getString("NUsuario"));
                g.setCargo(rs.getString("Cargo"));
                return g;
            }
        };
        List<SGC_ActasAsistentesDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<GCGenericoDTO> listComboAccion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre`FROM`s_sgc_tipo_accion`WHERE (`Estado` =1)ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<GCGenericoDTO> listTipoReunion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `s_sgc_tipo_reunion`WHERE (`Estado` =1) ORDER BY `Nbre` ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public String create_return_id(final SGC_ActasDTO xActa) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.8
            final String sql = "INSERT INTO `s_sgc_actas`(`FechaA`,`Hora`, Id_Actividad,`Id_Proceso`,`Lugar`,`Id_Tipo`,`Objetivo`,`Aclaraciones`,`Desarrollo`,`Estado`,`UsuarioS`,HoraFinal)VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `s_sgc_actas`(`FechaA`,`Hora`, Id_Actividad,`Id_Proceso`,`Lugar`,`Id_Tipo`,`Objetivo`,`Aclaraciones`,`Desarrollo`,`Estado`,`UsuarioS`,HoraFinal)VALUES (?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setString(1, xActa.getFechActa());
                ps.setString(2, xActa.getHora());
                ps.setString(3, xActa.getIdActividad());
                ps.setString(4, xActa.getIdProceso());
                ps.setString(5, xActa.getLugar());
                ps.setString(6, xActa.getIdTipo());
                ps.setString(7, xActa.getObjetivo());
                ps.setString(8, xActa.getAclaraciones());
                ps.setString(9, xActa.getDesarrollo());
                ps.setInt(10, xActa.getEstado());
                ps.setString(11, Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                ps.setString(12, xActa.getHoraFinal());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdActa = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIDActa-->" + xIdActa);
        return xIdActa;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public String mCreateActaAsistentes(SGC_ActasAsistentesDTO xActa) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_actas_asistentes`(`Id_Actas`,`Id_RhPersonaCargo`,`Id_TipoProceso`, EsExterno, Nbre_Integrante, Cargo, Proceso)VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(xActa.getIdActa()), xActa.getIdRhPersonaC(), xActa.getIdTipoProceso(), Integer.valueOf(xActa.getEsExterno()), xActa.getNbreIntegrante(), xActa.getCargo(), xActa.getProceso()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public String mCreateActaConcluson(SGC_ActasAccionConclusionDTO xActa) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_actas_accion_conclusiones`(`Id_Actas`,`Id_tipoaccion`,`Detalle`,`Id_TipoProceso`,`Id_RhPersonaC`,`FechaEjecucion`,`Id_Ficha`)VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(xActa.getIdActas()), xActa.getIdTipoAccion(), xActa.getDetalle(), xActa.getIdTipoProceso(), xActa.getIdRhPersonaC(), xActa.getFechaEjecucion(), Integer.valueOf(xActa.getIdFicha())});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public List<GCGenericoDTO> listOrigen(int xfiltro) {
        String xsql;
        if (xfiltro == 0) {
            xsql = "SELECT `Id`, `Nbre` FROM `s_sgc_ncorigen`WHERE (`Estado` =1) ORDER BY `Nbre` ASC;";
        } else {
            xsql = "SELECT `Id`, `Nbre` FROM `s_sgc_ncorigen`WHERE (`Estado` =1 AND EsSC=1) ORDER BY `Nbre` ASC;";
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.9
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

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public String create_return_idFicha(final SGC_Ficha5w1hDTO xFicha5w1h) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl.10
            final String sql = "insert into s_sgc_ficha5w1h(FechaRF, Id_TipoAccion, Id_Origen, Id_TipoProceso, Id_RhPersonaR, Id_RhPersonaRP, Que, Cuando)  values(?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into s_sgc_ficha5w1h(FechaRF, Id_TipoAccion, Id_Origen, Id_TipoProceso, Id_RhPersonaR, Id_RhPersonaRP, Que, Cuando)  values(?,?,?,?,?,?,?,?);", 1);
                ps.setString(1, xFicha5w1h.getFechaRF());
                ps.setString(2, xFicha5w1h.getIdTipoAccion());
                ps.setString(3, xFicha5w1h.getIdOrigen());
                ps.setString(4, xFicha5w1h.getIdTipoProceso());
                ps.setString(5, xFicha5w1h.getIdRhPersonaR());
                ps.setString(6, xFicha5w1h.getIdRhPersonaRP());
                ps.setString(7, xFicha5w1h.getQue());
                ps.setString(8, xFicha5w1h.getCuando());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xidFicha = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xidFicha-->" + xidFicha);
        return xidFicha;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_ActasDAO
    public String mUpdate(SGC_ActasDTO xActa) {
        String sql = "UPDATE `s_sgc_actas`SET `FechaA` = ?,  `Hora` = ?,  `HoraFinal` = ?,  `Id_Proceso` = ?,  `Id_Actividad` = ?,  `Lugar` = ?,  `Id_Tipo` = ?,  `Objetivo` = ?,  `Aclaraciones` = ?,  `Desarrollo` = ?,  `Estado` = ?,  `UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xActa.getFechActa(), xActa.getHora(), xActa.getHoraFinal(), xActa.getIdProceso(), xActa.getIdActividad(), xActa.getLugar(), xActa.getIdTipo(), xActa.getObjetivo(), xActa.getAclaraciones(), xActa.getDesarrollo(), Integer.valueOf(xActa.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(xActa.getIdActas())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
