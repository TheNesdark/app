package com.genoma.plus.dao.impl.presupuesto;

import Acceso.Principal;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.presupuesto.MovimientoDetalleDTO;
import com.genoma.plus.dto.presupuesto.PeriodoDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDetalleDTO;
import com.genoma.plus.dto.presupuesto.TipoDocumentoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/PresupuestoDAOImpl.class */
public class PresupuestoDAOImpl implements PresupuestoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<PeriodoDTO> listPeriodoPPT() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                PeriodoDTO g = new PeriodoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                g.setFechaInicio(rs.getString("FechaI"));
                g.setFechaFin(rs.getString("FechaF"));
                g.setEstadoCierre(rs.getInt("Cerrado"));
                return g;
            }
        };
        List<PeriodoDTO> list = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`\n    , `FechaI`\n    , `FechaF`\n    , `Cerrado`\nFROM\n    `pp_periodo`\nORDER BY `FechaI` DESC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<PeriodoDTO> listPeriodoPptActivos() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                PeriodoDTO g = new PeriodoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                g.setFechaInicio(rs.getString("FechaI"));
                g.setFechaFin(rs.getString("FechaF"));
                g.setEstadoCierre(rs.getInt("Cerrado"));
                g.setIdEncabezado(rs.getInt("idEncabezado"));
                return g;
            }
        };
        List<PeriodoDTO> list = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`\n    , `FechaI`\n    , `FechaF`\n    , `Cerrado`, idEncabezado\nFROM\n    `pp_periodo`\nWhere Cerrado = 0 ORDER BY `FechaI` DESC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<TipoDocumentoDTO> lisTipoDocumentoId(int idClaseDocumento) {
        String xsql = "SELECT\n    `Id`\n    , `Nbre`\n    , `Id_ClaseDoc`\n    , `Estado`\nFROM\n    `baseserver`.`pp_tipo_documentos`\nWHERE (`Id_ClaseDoc` ='" + idClaseDocumento + "'\n    AND `Estado` =1);";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                TipoDocumentoDTO g = new TipoDocumentoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setNombre(rs.getString("Nbre"));
                g.setIdClaseDocumento(Long.valueOf(rs.getLong("Id_ClaseDoc")));
                g.setEstado(rs.getInt("Estado"));
                return g;
            }
        };
        List<TipoDocumentoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public Long addMovimientoPpt(final Long Id_Periodo, final String Id_TipoDoc, final String FechaD, final String Observacion, final String NoFact, final Integer esGlobal) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.4
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,NoFact, IdUsuarioR,`UsuarioS`, EsGlobal)     VALUES (?,?,?,?,?,?,?,?)", 1);
                ps.setLong(1, Id_Periodo.longValue());
                ps.setString(2, Id_TipoDoc);
                ps.setString(3, FechaD);
                ps.setString(4, Observacion);
                ps.setString(5, NoFact);
                ps.setLong(6, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                ps.setString(7, Principal.usuarioSistemaDTO.getLogin());
                ps.setInt(8, esGlobal.intValue());
                return ps;
            }
        }, generatedKeyHolder);
        return Long.valueOf(generatedKeyHolder.getKey().longValue());
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String addMovimientoDetallePpt(Long Id_Movimiento, String Id_Rubro, String Id_Encabezado, String Id_Tercero, Double Valor, String Observacion) {
        String result = null;
        int ctos = this.jdbcTemplate.update("insert into  `pp_detalle_movimiento`(`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,Observacion)    VALUES (?,?,?,?,?,?)", new Object[]{Id_Movimiento, Id_Rubro, Id_Encabezado, Id_Tercero, Valor, Observacion});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<PeriodoDTO> listPeriodoPPT(String anno) {
        String xsql = "SELECT\n    `Id`\n    , `Nbre`\n    , `FechaI`\n    , `FechaF`\n    , `Cerrado`, idEncabezado\nFROM\n    `pp_periodo`\nWHERE (DATE_FORMAT(FechaI,'%Y')='" + anno + "') ORDER BY `FechaI` DESC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                PeriodoDTO g = new PeriodoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                g.setFechaInicio(rs.getString("FechaI"));
                g.setFechaFin(rs.getString("FechaF"));
                g.setEstadoCierre(rs.getInt("Cerrado"));
                g.setIdEncabezado(rs.getInt("idEncabezado"));
                return g;
            }
        };
        List<PeriodoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String guardaSolicitud_return_id(final SolicitudDTO solicitud) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.6
            final String sql = "INSERT INTO pp_solicitud_pto\n(IdUsuarioCargon, FechaR, Descripcion, IdMovimiento, Valor,tiposolicitud,idunidadfuncional,nconsecutivo,idperiodo, UsuarioS, idTipoDocumento)\nVALUES(?,?,?,?,?,?, ?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO pp_solicitud_pto\n(IdUsuarioCargon, FechaR, Descripcion, IdMovimiento, Valor,tiposolicitud,idunidadfuncional,nconsecutivo,idperiodo, UsuarioS, idTipoDocumento)\nVALUES(?,?,?,?,?,?, ?,?,?,?,?);", 1);
                ps.setLong(1, solicitud.getIdUsuarioCargon().longValue());
                ps.setString(2, solicitud.getFechaR());
                ps.setString(3, solicitud.getDescripcion());
                ps.setInt(4, solicitud.getIdMovimiento());
                ps.setDouble(5, solicitud.getValor());
                ps.setInt(6, solicitud.getTipoSolicitud());
                ps.setInt(7, solicitud.getIdUnidadFuncional());
                ps.setInt(8, solicitud.getNoConsecutivo());
                ps.setInt(9, solicitud.getIdPeriodo());
                ps.setString(10, solicitud.getUsuarioS());
                ps.setLong(11, solicitud.getIdTipoDocumento().intValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdSolicitud = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdSolicitud-->" + xIdSolicitud);
        return xIdSolicitud;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String guardaSolicitudDetalle(SolicitudDetalleDTO solicitud) {
        String result = null;
        int ctos = this.jdbcTemplate.update("INSERT INTO pp_solicitud_pto_detalle\n(idmovimiento, idEncabezado, idrubro, valor)\nVALUES(?,?,?,?);", new Object[]{Integer.valueOf(solicitud.getIdmovimiento()), Integer.valueOf(solicitud.getIdEncabezado()), solicitud.getIdrubro(), Double.valueOf(solicitud.getValor())});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<Object[]> getListRubrosSolicitud(int idSolicitud, int idEncabezado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] g = {rs.getString("idrubro"), rs.getString("rubro"), Double.valueOf(rs.getDouble("valor")), rs.getString("observacion"), Integer.valueOf(rs.getInt("id"))};
                return g;
            }
        };
        System.out.println("sql solicitud--> select sod.idrubro, r.Nbre as rubro,sod.valor, '' observacion,sod.id\nfrom pp_solicitud_pto so \ninner join pp_solicitud_pto_detalle sod  on (so.Id=sod.idmovimiento)\ninner join pp_rubros r on (sod.idrubro=r.Id)\nwhere so.Id=? and sod.estado=1 and r.idEncabezadoRubro=?");
        List<Object[]> list = this.jdbcTemplate.query("select sod.idrubro, r.Nbre as rubro,sod.valor, '' observacion,sod.id\nfrom pp_solicitud_pto so \ninner join pp_solicitud_pto_detalle sod  on (so.Id=sod.idmovimiento)\ninner join pp_rubros r on (sod.idrubro=r.Id)\nwhere so.Id=? and sod.estado=1 and r.idEncabezadoRubro=?", mapper, new Object[]{Integer.valueOf(idSolicitud), Integer.valueOf(idEncabezado)});
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String actualizaAjusteSolicitudRubro(SolicitudDetalleDTO solicitud) {
        String result = null;
        System.out.println("actualizaAjusteSolicitudRubro");
        int ctos = this.jdbcTemplate.update("update pp_solicitud_pto_detalle sd \nset sd.valor=?\nwhere sd.id=?", new Object[]{Double.valueOf(solicitud.getValor()), Integer.valueOf(solicitud.getId())});
        if (ctos == 0) {
            result = "No se actualiza";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String actualizaAjusteEncabezado(int idSolicitud, double valor, String descripcion, String idUnidadFuncional) {
        String result = null;
        System.out.println("" + descripcion);
        System.out.println("" + idSolicitud);
        int ctos = this.jdbcTemplate.update("update pp_solicitud_pto s \nset s.valor=?, s.Descripcion=?, s.idunidadfuncional=?\nwhere s.Id=?", new Object[]{Double.valueOf(valor), descripcion, idUnidadFuncional, Integer.valueOf(idSolicitud)});
        if (ctos == 0) {
            result = "No se actualiza";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<Object[]> getDisponibilidad(int idSolicitud) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] g = {rs.getString("Id"), rs.getString("tipoDoc"), rs.getString("idEncabezado"), rs.getString("Id_Tercero")};
                return g;
            }
        };
        System.out.println("sql Disponibilidad--> select m.Id ,td.Nbre  as tipoDoc, dm.idEncabezado, dm.Id_Tercero\nfrom pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\ninner join pp_detalle_movimiento dm on (m.Id=dm.Id_Movimiento) and dm.Estado=1\nwhere m.IdSolicitud=?\nGROUP by m.Id");
        List<Object[]> list = this.jdbcTemplate.query("select m.Id ,td.Nbre  as tipoDoc, dm.idEncabezado, dm.Id_Tercero\nfrom pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\ninner join pp_detalle_movimiento dm on (m.Id=dm.Id_Movimiento) and dm.Estado=1\nwhere m.IdSolicitud=?\nGROUP by m.Id", mapper, new Object[]{Integer.valueOf(idSolicitud)});
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<Object[]> getCompromiso(int idDisponibilidad) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.9
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] g = {rs.getString("Id"), rs.getString("tipoDoc"), rs.getString("idEncabezado"), rs.getString("Id_Tercero")};
                return g;
            }
        };
        System.out.println("sql compromiso--> select m.Id,td.Nbre  as tipoDoc, dm.idEncabezado, dm.Id_Tercero from pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\n inner join pp_detalle_movimiento dm on (m.Id=dm.Id_Movimiento) and dm.Estado=1 \nwhere m.IdDisponibilidad=? and m.Id_MotivoAnulacion=1 and td.Id_ClaseDoc=4 \nGROUP by m.Id");
        List<Object[]> list = this.jdbcTemplate.query("select m.Id,td.Nbre  as tipoDoc, dm.idEncabezado, dm.Id_Tercero from pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\n inner join pp_detalle_movimiento dm on (m.Id=dm.Id_Movimiento) and dm.Estado=1 \nwhere m.IdDisponibilidad=? and m.Id_MotivoAnulacion=1 and td.Id_ClaseDoc=4 \nGROUP by m.Id", mapper, new Object[]{Integer.valueOf(idDisponibilidad)});
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<Object[]> getObligacion(int idCompromiso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.10
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] g = {rs.getString("Id"), rs.getString("tipoDoc")};
                return g;
            }
        };
        System.out.println("sql Obligacion--> select m.Id,td.Nbre  as tipoDoc from pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\nwhere m.IdCompromiso=? and m.Id_MotivoAnulacion=1 and td.Id_ClaseDoc=5\nlimit 1");
        List<Object[]> list = this.jdbcTemplate.query("select m.Id,td.Nbre  as tipoDoc from pp_movimiento m \ninner join pp_tipo_documentos td on (m.Id_TipoDoc=td.Id)\nwhere m.IdCompromiso=? and m.Id_MotivoAnulacion=1 and td.Id_ClaseDoc=5\nlimit 1", mapper, new Object[]{Integer.valueOf(idCompromiso)});
        return list;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public String guardaDetalleMovimiento(MovimientoDetalleDTO md) {
        String result = null;
        int ctos = this.jdbcTemplate.update("INSERT INTO pp_detalle_movimiento\n(idEncabezado, Id_Movimiento, Id_Rubro, Id_Tercero, Valor, Tipo)\nVALUES(?,?,?,?,?,?);", new Object[]{Integer.valueOf(md.getIdEncabezado()), Integer.valueOf(md.getId_Movimiento()), md.getId_Rubro(), Integer.valueOf(md.getId_Tercero()), Double.valueOf(md.getValor()), Integer.valueOf(md.getTipo())});
        if (ctos == 0) {
            result = "No se inserta";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public void actualizarEstadoDetalleSolicitud(Long id) {
        this.jdbcTemplate.update("update pp_solicitud_pto_detalle sd \nset sd.estado=0\nwhere sd.id=?", new Object[]{id});
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public void actualizarEstadoDetalleMovimiento(Long id) {
        System.out.println("" + id);
        System.out.println("update pp_detalle_movimiento sd \nset sd.Estado=0\nwhere sd.Id=?");
        this.jdbcTemplate.update("update pp_detalle_movimiento sd \nset sd.Estado=0\nwhere sd.Id=?", new Object[]{id});
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public void actualizarDetalleEncabezadoMovimiento(Long id, String Observacion) {
        System.out.println("" + id);
        System.out.println("update pp_movimiento sd \nset sd.Observacion=?\nwhere sd.Id=?");
        this.jdbcTemplate.update("update pp_movimiento sd \nset sd.Observacion=?\nwhere sd.Id=?", new Object[]{Observacion, id});
    }

    @Override // com.genoma.plus.dao.presupuesto.PresupuestoDAO
    public List<Object[]> getListSolicitudDetalle(int idSolicitud, int idEncabezado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl.11
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] g = {rs.getString("idRubro"), rs.getString("nombreRubro"), rs.getString("nombreTercero"), rs.getString("nombreCentroCosto"), rs.getString("nombreFuenteFinanciacion"), Integer.valueOf(rs.getInt("codigoCpc")), rs.getString("nombreCpc"), rs.getString("nombreVigencia"), Long.valueOf(rs.getLong("valor"))};
                return g;
            }
        };
        System.out.println("sql solicitud--> SELECT\n  pp_solicitud_pto_detalle.idrubro AS idRubro,\n  pp_rubros.Nbre AS nombreRubro,\n    if(g_empresa.Nbre = '', concat(`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`,' ',`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`), g_empresa.Nbre) AS nombreTercero,\n  pp_rubros_centrocostos.nombre AS nombreCentroCosto,\n  pp_rubros_fuente_financiacion.nombre AS nombreFuenteFinanciacion,\n  pp_rubros_cpc.codigo AS codigoCpc,\n  pp_rubros_cpc.nombre AS nombreCpc,\n  pp_tipo_vigencia.Nombre AS nombreVigencia,\n  pp_solicitud_pto_detalle.valor AS valor\nFROM\n  pp_solicitud_pto\n  INNER JOIN pp_solicitud_pto_detalle ON (pp_solicitud_pto_detalle.idmovimiento = pp_solicitud_pto.Id)\n  INNER JOIN pp_rubros ON (pp_solicitud_pto_detalle.idrubro = pp_rubros.id)\n  INNER JOIN g_empresa ON (pp_solicitud_pto_detalle.Id_Tercero = g_empresa.Id)\n  INNER JOIN pp_rubros_centrocostos ON (pp_solicitud_pto_detalle.Id_RubrosCentroCostos = pp_rubros_centrocostos.id)\n  INNER JOIN pp_rubros_fuente_financiacion ON (pp_solicitud_pto_detalle.Id_RubrosFuenteFinanciacion = pp_rubros_fuente_financiacion.id)\n  INNER JOIN pp_rubros_cpc ON (pp_solicitud_pto_detalle.Id_RubrosCpc = pp_rubros_cpc.id)\n  INNER JOIN pp_tipo_vigencia ON (pp_solicitud_pto_detalle.Id_TipoVigencia = pp_tipo_vigencia.Id)\n  WHERE pp_solicitud_pto.Id =?  AND pp_solicitud_pto_detalle.estado = 1  AND pp_rubros.idEncabezadoRubro =?");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n  pp_solicitud_pto_detalle.idrubro AS idRubro,\n  pp_rubros.Nbre AS nombreRubro,\n    if(g_empresa.Nbre = '', concat(`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`,' ',`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`), g_empresa.Nbre) AS nombreTercero,\n  pp_rubros_centrocostos.nombre AS nombreCentroCosto,\n  pp_rubros_fuente_financiacion.nombre AS nombreFuenteFinanciacion,\n  pp_rubros_cpc.codigo AS codigoCpc,\n  pp_rubros_cpc.nombre AS nombreCpc,\n  pp_tipo_vigencia.Nombre AS nombreVigencia,\n  pp_solicitud_pto_detalle.valor AS valor\nFROM\n  pp_solicitud_pto\n  INNER JOIN pp_solicitud_pto_detalle ON (pp_solicitud_pto_detalle.idmovimiento = pp_solicitud_pto.Id)\n  INNER JOIN pp_rubros ON (pp_solicitud_pto_detalle.idrubro = pp_rubros.id)\n  INNER JOIN g_empresa ON (pp_solicitud_pto_detalle.Id_Tercero = g_empresa.Id)\n  INNER JOIN pp_rubros_centrocostos ON (pp_solicitud_pto_detalle.Id_RubrosCentroCostos = pp_rubros_centrocostos.id)\n  INNER JOIN pp_rubros_fuente_financiacion ON (pp_solicitud_pto_detalle.Id_RubrosFuenteFinanciacion = pp_rubros_fuente_financiacion.id)\n  INNER JOIN pp_rubros_cpc ON (pp_solicitud_pto_detalle.Id_RubrosCpc = pp_rubros_cpc.id)\n  INNER JOIN pp_tipo_vigencia ON (pp_solicitud_pto_detalle.Id_TipoVigencia = pp_tipo_vigencia.Id)\n  WHERE pp_solicitud_pto.Id =?  AND pp_solicitud_pto_detalle.estado = 1  AND pp_rubros.idEncabezadoRubro =?", mapper, new Object[]{Integer.valueOf(idSolicitud), Integer.valueOf(idEncabezado)});
        return list;
    }
}
