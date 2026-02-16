package com.genoma.plus.dao.impl.sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisAccionDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisCausaDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisIntegranteDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisPCausaDTO;
import com.genoma.plus.dto.sgc.SGC_Analisis_EventoAdversoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SC_EventoAdversoGestionDAOImpl.class */
public class SC_EventoAdversoGestionDAOImpl implements SC_EventoAdversoGestionDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String create_return_id(final SGC_Analisis_EventoAdversoDTO xanalisis) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.1
            final String sql = "INSERT INTO `s_sgc_sc_evento_adverso_analisis`\n            (`Id_Evento`,\n             `FechaA`,\n             `ObservacionG`,\n             `Estado`,\n             `Id_Anulado`,\n             `Id_UsuarioS`)\nVALUES (?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `s_sgc_sc_evento_adverso_analisis`\n            (`Id_Evento`,\n             `FechaA`,\n             `ObservacionG`,\n             `Estado`,\n             `Id_Anulado`,\n             `Id_UsuarioS`)\nVALUES (?,?,?,?,?,?);", 1);
                ps.setInt(1, xanalisis.getXId_Evento());
                ps.setString(2, xanalisis.getXFechaA());
                ps.setString(3, xanalisis.getXObservacionG());
                ps.setInt(4, xanalisis.getXEstado());
                ps.setInt(5, xanalisis.getXId_Anulado());
                ps.setInt(6, xanalisis.getXId_UsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdAnalisis = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdAnalisis-->" + xIdAnalisis);
        return xIdAnalisis;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String mDeleteGeneral(SGC_Analisis_EventoAdversoDTO xEvento) {
        String sql = "UPDATE `s_sgc_sc_evento_adverso_analisis` SET `Id_Anulado` = ?,   `MotivoAnulacion` = ?,   `FechaAnulacion` = ?,   `UsuarioAnulacion` = ?,   `Estado` = ?  WHERE `Id` = ? and `Id_Evento`=?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xEvento.getXId_Anulado()), xEvento.getXMotivoAnulacion(), xEvento.getXFechaAnulacion(), Principal.usuarioSistemaDTO.getNombreUsuario(), Integer.valueOf(xEvento.getXEstado()), Integer.valueOf(xEvento.getXId()), Integer.valueOf(xEvento.getXId_Evento())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String create_causa(SGC_AnalisisCausaDTO xCausa) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_evento_adverso_analisis_causas`\n            (`Id_EventoA`,\n             `Id_CausaA`,\n             `Descripcion`,\n             `NOrden`,\n             `Estado`,\n             `Id_UsuarioS`)\nVALUES (?,?,?,?,?,?);", new Object[]{Integer.valueOf(xCausa.getXId_EventoA()), xCausa.getXId_CausaA(), xCausa.getXDescripcion(), Integer.valueOf(xCausa.getXNOrden()), Integer.valueOf(xCausa.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String mCreatePCausa(SGC_AnalisisPCausaDTO xPCausa) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_evento_adverso_analisis_pcausas`(`Id_EventoA`,`Descripcion`,`NOrden`,`Estado`,`Id_UsuarioS`)VALUES (?,?,?,?,?)", new Object[]{Integer.valueOf(xPCausa.getXIdEvenACausaP()), xPCausa.getXDescripACausaP(), Integer.valueOf(xPCausa.getXNOrdenACausaP()), Integer.valueOf(xPCausa.getXEstadoACausaP()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String mCreateIntegrante(SGC_AnalisisIntegranteDTO xIntegrante) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_evento_adverso_analisis_integrantes` (`Id_Analisis`,`Tipo`,`Id_PersonaC`,`Id_TipoProceso`,`PE_Nombre`,`PE_Cargo`,`FechaFirma`)\nVALUES (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(xIntegrante.getXId_Analisis()), Integer.valueOf(xIntegrante.getXTipo()), Integer.valueOf(xIntegrante.getXId_PersonaC()), xIntegrante.getXId_TipoProceso(), xIntegrante.getXPE_Nombre(), xIntegrante.getXPE_Cargo(), xIntegrante.getXFechaFirma()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public String mCreateAccion(SGC_AnalisisAccionDTO xAccion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_evento_adverso_analisis_acciones`(`Id_EventoA`,`Id_TipoAccion`,`Detalle`,`Id_TipoProceso`,`Id_RhPersonaC`,`FechaE`,`Id_Ficha`,`Estado`,`Id_UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(xAccion.getXId_EventoA()), xAccion.getXId_TipoAccion(), xAccion.getXDetalle(), xAccion.getXId_TipoProceso(), xAccion.getXId_RhPersonaC(), xAccion.getXFechaE(), Integer.valueOf(xAccion.getXId_Ficha()), Integer.valueOf(xAccion.getXEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<GCGenericoDTO> listComboCausa() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id` , `Nbre` FROM`s_sgc_sc_tipo_causa_analisis` WHERE (`Estado` =1)ORDER BY `Nbre` ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<GCGenericoDTO> listaTProceso(String xIdUsuarioS) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("select\n\t`s_sgc_tipoproceso`.`Id`,\n\t`s_sgc_tipoproceso`.`Nbre`\nfrom\n\t`rh_tipo_persona_cargon`\ninner join `persona` on\n\t(`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\ninner join `s_sgc_usuario_tipoproceso` on\n\t(`s_sgc_usuario_tipoproceso`.`Id_Usuario` = `persona`.`Id_persona`)\ninner join `rh_unidadf_cargo` on\n\t(`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\ninner join `rh_tipo_cargo` on\n\t(`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\ninner join `s_sgc_tipoproceso` on\n\t(`s_sgc_usuario_tipoproceso`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`)\nwhere\n\t(rh_tipo_persona_cargon.`Estado` = 1\n\tand `s_sgc_tipoproceso`.`Estado` = 1 )\ngroup by\n\t`s_sgc_tipoproceso`.`Nbre`\norder by\n\t`s_sgc_tipoproceso`.`Nbre` asc", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<Object[]> listComboUsuario(String xIdTipoProceso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[5];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                return fila;
            }
        };
        String sql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, persona.`NoDocumento` FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona) WHERE (s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + xIdTipoProceso + "') ORDER BY persona.NUsuario ASC";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<GCGenericoDTO> listComboAccion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.5
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

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<Object[]> listComboRespon(String xIdTipoProceso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[5];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                return fila;
            }
        };
        String sql = "SELECT\n    `rh_tipo_persona_cargon`.`Id`\n    , `persona`.`NUsuario`\n    , `persona`.`NoDocumento`\n    , `rh_tipo_cargo`.`Nbre` AS `Cargo`\nFROM\n    `rh_tipo_persona_cargon`\n    INNER JOIN `persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\n    INNER JOIN `s_sgc_usuario_tipoproceso` \n        ON (`s_sgc_usuario_tipoproceso`.`Id_Usuario` = `persona`.`Id_persona`)\n    INNER JOIN `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nWHERE (`s_sgc_usuario_tipoproceso`.`Id_TipoProceso` ='" + xIdTipoProceso + "' AND rh_tipo_persona_cargon.`Estado`=1 )\nORDER BY `persona`.`NUsuario` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<SGC_Analisis_EventoAdversoDTO> listAnalisis(String xidevento) {
        String xsql = "SELECT `Id`, `FechaA`, `ObservacionG` FROM `s_sgc_sc_evento_adverso_analisis` WHERE (`Id_Evento` ='" + xidevento + "' AND `Id_Anulado` =1);";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_Analisis_EventoAdversoDTO g = new SGC_Analisis_EventoAdversoDTO();
                g.setXId(rs.getInt("Id"));
                g.setXFechaA(rs.getString("FechaA"));
                g.setXObservacionG(rs.getString("ObservacionG"));
                return g;
            }
        };
        List<SGC_Analisis_EventoAdversoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<SGC_AnalisisCausaDTO> listCausa(String xidAnalisis) {
        String xsql = "SELECT `s_sgc_sc_tipo_causa_analisis`.`Nbre` AS `Causa`, `s_sgc_sc_evento_adverso_analisis_causas`.`Descripcion`, `s_sgc_sc_evento_adverso_analisis_causas`.`NOrden`\n, `s_sgc_sc_evento_adverso_analisis_causas`.`Estado` FROM `s_sgc_sc_evento_adverso_analisis_causas` INNER JOIN `s_sgc_sc_tipo_causa_analisis` \nON (`s_sgc_sc_evento_adverso_analisis_causas`.`Id_CausaA` = `s_sgc_sc_tipo_causa_analisis`.`Id`) WHERE (`s_sgc_sc_evento_adverso_analisis_causas`.`Id_EventoA` ='" + xidAnalisis + "')\nORDER BY `Causa` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_AnalisisCausaDTO g = new SGC_AnalisisCausaDTO();
                g.setXId_CausaA(rs.getString("Causa"));
                g.setXDescripcion(rs.getString("Descripcion"));
                g.setXNOrden(rs.getInt("NOrden"));
                g.setXEstado(rs.getInt("Estado"));
                return g;
            }
        };
        List<SGC_AnalisisCausaDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<SGC_AnalisisPCausaDTO> listPCausa(String xidAnalisis) {
        String xsql = "SELECT `Descripcion`, `NOrden`, `Estado` FROM `s_sgc_sc_evento_adverso_analisis_pcausas` WHERE (`Id_EventoA` ='" + xidAnalisis + "') ORDER BY `NOrden` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.9
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_AnalisisPCausaDTO g = new SGC_AnalisisPCausaDTO();
                g.setXDescripACausaP(rs.getString("Descripcion"));
                g.setXNOrdenACausaP(rs.getInt("NOrden"));
                g.setXEstadoACausaP(rs.getInt("Estado"));
                return g;
            }
        };
        List<SGC_AnalisisPCausaDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<SGC_AnalisisIntegranteDTO> listIntegrante(String xidAnalisis) {
        String xsql = "SELECT\n    `s_sgc_sc_evento_adverso_analisis_integrantes`.`Tipo`\n    , `s_sgc_sc_evento_adverso_analisis_integrantes`.`PE_Nombre`\n    , `s_sgc_tipoproceso`.`Nbre` AS `TipoProceso`\n    , `s_sgc_sc_evento_adverso_analisis_integrantes`.`PE_Cargo`\n    , `s_sgc_sc_evento_adverso_analisis_integrantes`.`FechaFirma`\nFROM\n    `s_sgc_tipoproceso`\n    INNER JOIN `s_sgc_sc_evento_adverso_analisis_integrantes` \n        ON (`s_sgc_tipoproceso`.`Id` = `s_sgc_sc_evento_adverso_analisis_integrantes`.`Id_TipoProceso`)\nWHERE (`s_sgc_sc_evento_adverso_analisis_integrantes`.`Id_Analisis` ='" + xidAnalisis + "')\nORDER BY `s_sgc_sc_evento_adverso_analisis_integrantes`.`Tipo` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.10
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_AnalisisIntegranteDTO g = new SGC_AnalisisIntegranteDTO();
                g.setXTipo(rs.getInt("Tipo"));
                g.setXPE_Nombre(rs.getString("PE_Nombre"));
                g.setXId_TipoProceso(rs.getString("TipoProceso"));
                g.setXPE_Cargo(rs.getString("PE_Cargo"));
                g.setXFechaFirma(rs.getString("FechaFirma"));
                return g;
            }
        };
        List<SGC_AnalisisIntegranteDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO
    public List<SGC_AnalisisAccionDTO> listAccion(String xidAnalisis) {
        String xsql = "SELECT\n    `s_sgc_tipo_accion`.`Nbre` AS `Accion`\n    , `s_sgc_sc_evento_adverso_analisis_acciones`.`Detalle`\n    , `s_sgc_tipoproceso`.`Nbre` AS `Proceso`\n    , `persona`.`NUsuario`\n    , `s_sgc_sc_evento_adverso_analisis_acciones`.`FechaE`\n    , `s_sgc_sc_evento_adverso_analisis_acciones`.`Id_Ficha`\n    , `s_sgc_sc_evento_adverso_analisis_acciones`.`Estado`\nFROM\n    `s_sgc_sc_evento_adverso_analisis_acciones`\n    INNER JOIN `s_sgc_tipo_accion` \n        ON (`s_sgc_sc_evento_adverso_analisis_acciones`.`Id_TipoAccion` = `s_sgc_tipo_accion`.`Id`)\n    INNER JOIN `s_sgc_tipoproceso` \n        ON (`s_sgc_sc_evento_adverso_analisis_acciones`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`)\n    INNER JOIN `rh_tipo_persona_cargon` \n        ON (`s_sgc_sc_evento_adverso_analisis_acciones`.`Id_RhPersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\nWHERE (`s_sgc_sc_evento_adverso_analisis_acciones`.`Id_EventoA` ='" + xidAnalisis + "')\nORDER BY `Accion` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl.11
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                SGC_AnalisisAccionDTO g = new SGC_AnalisisAccionDTO();
                g.setXId_TipoAccion(rs.getString("Accion"));
                g.setXDetalle(rs.getString("Detalle"));
                g.setXId_TipoProceso(rs.getString("Proceso"));
                g.setXId_RhPersonaC(rs.getString("NUsuario"));
                g.setXFechaE(rs.getString("FechaE"));
                g.setXId_Ficha(rs.getInt("Id_Ficha"));
                g.setXEstado(rs.getInt("Estado"));
                return g;
            }
        };
        List<SGC_AnalisisAccionDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
