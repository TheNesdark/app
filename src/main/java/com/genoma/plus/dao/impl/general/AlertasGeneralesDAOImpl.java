package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.AlertasGeneralesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/AlertasGeneralesDAOImpl.class */
public class AlertasGeneralesDAOImpl implements AlertasGeneralesDAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public List<Object[]> numeroSeguimientoAuditoriaPendientes(Long xIdUsuarioRh) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Cantidad"))};
                return fila;
            }
        };
        this.sql = "SELECT COUNT(d.Cantidad) cantidad FROM ( SELECT ingreso_seguimiento.`Id` AS `Cantidad` , IF(ingreso_seguimiento_cierre.`Id` IS NULL, 0, 1) Cierre FROM `ingreso_seguimiento` LEFT JOIN `ingreso_seguimiento_cierre` ON (`ingreso_seguimiento`.`Id` = `ingreso_seguimiento_cierre`.`Id_Segumiento`) AND (ingreso_seguimiento_cierre.`Estado`=1) WHERE (ingreso_seguimiento.`IdPersonaR` ='" + xIdUsuarioRh + "' AND ingreso_seguimiento.`Id_Motivo_Anulacion` =1) HAVING Cierre=0) d";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Integer numeroAccionesFicha5w1h(Long idUsuarioRecursosHumanos) {
        Integer cantidad;
        try {
            this.sql = "SELECT COUNT(Id) numeroAcciones \nFROM s_sgc_ficha5w1h WHERE (IF( IF(FechaUltimoSeg IS NULL, Cuando, ADDDATE(FechaUltimoSeg ,INTERVAL NDiasSeguimiento DAY ))<=NOW(),TRUE,FALSE) =1 AND Id_RhPersonaR ='" + idUsuarioRecursosHumanos + "' \nAND FechaCierre IS NULL AND ControlSeguimiento=0 AND Estado=1 \nAND IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,IF(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,2),IF(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) )=1) ";
            cantidad = (Integer) this.jdbcTemplate.queryForObject(this.sql, Integer.class);
        } catch (Exception e) {
            cantidad = 0;
        }
        return cantidad;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Integer numeroEncuestasPendientes(Long idUsuarioSistema) {
        Integer cantidad;
        try {
            this.sql = "SELECT COUNT(`Id`) FROM `t_e_tipo_encuesta_detalle` WHERE (`Id_UsuarioG` ='" + idUsuarioSistema + "' AND `Diligencio` =0) GROUP BY `Id_UsuarioG` ";
            cantidad = (Integer) this.jdbcTemplate.queryForObject(this.sql, Integer.class);
        } catch (Exception e) {
            cantidad = 0;
        }
        return cantidad;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public List<Object[]> listaEncuestaporUsuario(Long idUsuarioSistema) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("idEncuesta")), rs.getString("nombreEncuesta"), rs.getString("nombreProceso"), rs.getString("nombreTipoProceso"), Long.valueOf(rs.getLong("idSolicitud"))};
                return fila;
            }
        };
        this.sql = "SELECT t_e_tipo_encuesta_detalle.Id idEncuesta\n, t_encuestas.Nbre nombreEncuesta\n, s_sgc_procesos.Nbre nombreProceso\n, s_sgc_tipoproceso.Nbre nombreTipoProceso\n, t_e_tipo_encuesta_detalle.Id_Solicitud idSolicitud\nFROM t_e_tipo_encuesta_detalle \nINNER JOIN t_e_tipo_encuesta ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) \nINNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) \nINNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) \nINNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) \nWHERE (t_e_tipo_encuesta_detalle.Id_UsuarioG ='" + idUsuarioSistema + "' AND t_e_tipo_encuesta_detalle.Diligencio =0) ";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public List<Object[]> mensajeInformacionTopeUvtTercero(String anno, Long idTercero, Double valor, Integer forma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("RazonSocialCompleta"), Double.valueOf(rs.getDouble("Tope")), Long.valueOf(rs.getLong("Ano")), Double.valueOf(rs.getDouble("Valor"))};
                return fila;
            }
        };
        if (forma.intValue() == 0) {
            this.sql = "SELECT cc_terceros.`Id` , cc_terceros.RazonSocialCompleta, `cc_tipo_regimen`.`Tope`, DATE_FORMAT(`cc_radicacion`.`Fecha`,'%Y') AS `Ano` , SUM((`cc_radicacion`.`SubTotal`+ `cc_radicacion`.`Iva`+ `cc_radicacion`.`Flete`+ `cc_radicacion`.`Otros`)) AS `Valor` FROM `cc_radicacion` INNER JOIN cc_terceros  ON (`cc_radicacion`.`Id_Proveedor` = cc_terceros.`Id`) INNER JOIN `cc_tiporegimenxempresa`  ON (`cc_tiporegimenxempresa`.`Id_Empresa` = cc_terceros.`Id`) INNER JOIN `cc_tipo_regimen`  ON (`cc_tiporegimenxempresa`.`Id_TipoRegimen` = `cc_tipo_regimen`.`Id`) WHERE (DATE_FORMAT(`cc_radicacion`.`Fecha`,'%Y') ='" + anno + "' AND cc_terceros.`Id`='" + idTercero + "') GROUP BY cc_terceros.`Id` HAVING (`Valor` >=(`cc_tipo_regimen`.`Tope`*" + valor + ")) ";
        } else {
            this.sql = "SELECT cc_terceros.`Id`, cc_terceros.RazonSocialCompleta, `cc_tipo_regimen`.`Tope`, DATE_FORMAT(`cc_radicacion`.`Fecha`,'%Y') AS `Ano` , SUM((`cc_radicacion`.`SubTotal`+ `cc_radicacion`.`Iva`+ `cc_radicacion`.`Flete`+ `cc_radicacion`.`Otros`)) AS `Valor` FROM `cc_radicacion` INNER JOIN cc_terceros  ON (`cc_radicacion`.`Id_Proveedor` = cc_terceros.`Id`) INNER JOIN `cc_tiporegimenxempresa`  ON (`cc_tiporegimenxempresa`.`Id_Empresa` = cc_terceros.`Id`) INNER JOIN `cc_tipo_regimen`  ON (`cc_tiporegimenxempresa`.`Id_TipoRegimen` = `cc_tipo_regimen`.`Id`) WHERE (DATE_FORMAT(`cc_radicacion`.`Fecha`,'%Y') ='" + anno + "' AND cc_terceros.`Id`='" + idTercero + "') GROUP BY cc_terceros.`Id`  ";
        }
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Double consultarValorUvr(String anno) {
        Double valor;
        try {
            this.sql = "SELECT `Valor` FROM  `cc_tvalor_uvt` WHERE (`Ano` ='" + anno + "' AND `Estado` =1) ";
            valor = (Double) this.jdbcTemplate.queryForObject(this.sql, Double.class);
        } catch (DataAccessException e) {
            valor = new Double(0.0d);
        }
        return valor;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Boolean verificarUsuarioCajero(Long idUsuarioSistema) {
        Boolean estado;
        try {
            this.sql = "SELECT IF(Id_Caja<>0, TRUE, FALSE) Tipo FROM g_usuariosxcajac WHERE (Id_Persona ='" + idUsuarioSistema + "' AND Estado =1) GROUP BY Id_Persona ";
            estado = (Boolean) this.jdbcTemplate.queryForObject(this.sql, Boolean.class);
        } catch (DataAccessException e) {
            estado = false;
        }
        return estado;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Boolean verificarUsuarioBodega(Long idUsuarioSistema) {
        Boolean estado;
        try {
            this.sql = "SELECT if(`Id_Bodega`<>0, TRUE, FALSE) Tipo FROM  `g_usuariosxbodega` WHERE (`Estado` =1 AND `Id_Persona` ='" + idUsuarioSistema + "') GROUP BY Id_Persona  ";
            estado = (Boolean) this.jdbcTemplate.queryForObject(this.sql, Boolean.class);
        } catch (DataAccessException e) {
            estado = false;
        }
        return estado;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Integer numeroSolicitudesPorAutorizar(Long idUsuarioSistema) {
        Integer cantidad;
        try {
            this.sql = "SELECT COUNT(DISTINCT( s_solicitud.Id))  Cantidad\nFROM s_solicitud_autorizacion \nINNER JOIN s_solicitud  ON (s_solicitud_autorizacion.Id_Solicitud = s_solicitud.Id) \nINNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) \nINNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) \nINNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) \nINNER JOIN g_persona  ON (g_persona.Id = rh_tipo_persona_cargon.Id_Persona) \nINNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id)\n INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) \n INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id)  \nWHERE (s_solicitud_autorizacion.Autorizo ='0'  AND s_solicitud.Estado =1 AND s_solicitud_autorizacion.Id_Persona ='" + idUsuarioSistema + "' AND s_solicitud.EstadoCierre='0')  \nGROUP BY s_solicitud_autorizacion.Id_Persona ORDER BY s_solicitud.FechaS DESC ";
            cantidad = (Integer) this.jdbcTemplate.queryForObject(this.sql, Integer.class);
        } catch (Exception e) {
            cantidad = 0;
        }
        return cantidad;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public Long consultarIdEspecialidadUsuarioSistema(Long idUsuarioSistema) {
        Long cantidad;
        new Long(0L);
        try {
            this.sql = "SELECT Id_Especialidad FROM g_profesionalespecial WHERE (Id_Profesional ='" + idUsuarioSistema + "' and Estado=0) group by Id_Profesional ";
            cantidad = (Long) this.jdbcTemplate.queryForObject(this.sql, Long.class);
        } catch (DataAccessException e) {
            cantidad = new Long(0L);
        }
        return cantidad;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public List<Object[]> verificarListaContratosPorSeguimiento() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Cantidad")), Integer.valueOf(rs.getInt("Validacion"))};
                return fila;
            }
        };
        this.sql = "SELECT COUNT(`cc_orden_compra`.`Id`) Cantidad, IF( `cc_tipo_documentof`.`NDias`=0, -1,\nIF( (DATEDIFF(ADDDATE(`cc_orden_compra`.`FechaFin`, INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())>0   AND DATEDIFF(ADDDATE(`cc_orden_compra`.`FechaFin`, INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())<=30), 0,  IF( (DATEDIFF(ADDDATE(`cc_orden_compra`.`FechaFin`, INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())>30   AND DATEDIFF(ADDDATE(`cc_orden_compra`.`FechaFin`, INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())<=90), 1,  IF(DATEDIFF(ADDDATE(`cc_orden_compra`.`FechaFin`, INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())>90, 2,3)))) Validacion \nFROM `cc_unidad_funcional`\nINNER JOIN `cc_orden_compra`  ON (`cc_unidad_funcional`.`Id` = `cc_orden_compra`.`Id_UnidadF`)\nINNER JOIN `cc_tipo_documentof` ON (`cc_orden_compra`.`Id_TipoDocF` = `cc_tipo_documentof`.`Id`)\nINNER JOIN `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `cc_orden_compra`.`Id_Administrador`)\nINNER JOIN `g_empresa`  ON (`g_empresa`.`Id` = `cc_orden_compra`.`Id_Tercero`)\nINNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\nINNER JOIN `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nINNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nWHERE (`cc_orden_compra`.`Estado` =1)\nGROUP BY Validacion\nHAVING Validacion=0";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public void grabarLogDocumentosHistoria(String idTipoDocumento, String idAtencion, String idUsuario, String nombreHost, String idIpAdrres) {
        this.sql = "insert into v_log_historia(`Id_Usuario`,`Id_Atencion`, `TipoDoc`, `NEquipo`, `DireccionIp`, `NUsuario`, `Cargo`, `UsuarioS`) values('" + idUsuario + "','" + idAtencion + "','" + idTipoDocumento + "','" + nombreHost + "','" + idIpAdrres + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "','" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.jdbcTemplate.execute(this.sql);
    }

    @Override // com.genoma.plus.dao.general.AlertasGeneralesDAO
    public List<Object[]> verificarNumeroCitasPorEspecialdiad(Long idEspecialdidad) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt("CitaRepetida")), Integer.valueOf(rs.getInt("AsignarCita"))};
                return fila;
            }
        };
        this.sql = "SELECT CitaRepetida, AsignarCita FROM g_especialidad WHERE (Id =" + idEspecialdidad + " AND Estado =0)";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }
}
