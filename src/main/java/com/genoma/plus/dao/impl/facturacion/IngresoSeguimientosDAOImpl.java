package com.genoma.plus.dao.impl.facturacion;

import Acceso.Principal;
import com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO;
import com.genoma.plus.dto.facturacion.IngresoSeguimientoDetalleDTO;
import com.genoma.plus.dto.facturacion.IngresoSeguimientosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/IngresoSeguimientosDAOImpl.class */
public class IngresoSeguimientosDAOImpl implements IngresoSeguimientosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public List<IngresoSeguimientosDTO> mListar(Long xidingreso) {
        String sql = "SELECT \n `ingreso_seguimiento`.`Id` \n , `ingreso_seguimiento`.`FechaD` \n , `ingreso_seguimiento`.`Observacion` \n , `ingreso_seguimiento`.`Estado` \n , `ingreso_seguimiento`.`GAlerta` \n , `g_tiposeguimiento`.`Nbre` AS `TipoSeguimiento` \n , `g_tiposeguimiento`.`PCierreFactura` \n , `ingreso_seguimiento`.`Cerrado` ,\n  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) NUsuario\n    , `rh_tipo_cargo`.`Nbre` Ncargo, `ingreso_seguimiento`.`IdPersonaR`\nFROM \n `ingreso_seguimiento` \n INNER JOIN `g_tiposeguimiento`  \n     ON (`ingreso_seguimiento`.`Id_Tipo` = `g_tiposeguimiento`.`Id`) \n     INNER JOIN    `rh_tipo_persona_cargon`\n        ON (`rh_tipo_persona_cargon`.`Id` = `ingreso_seguimiento`.`IdPersonaR`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\nWHERE (`ingreso_seguimiento`.`Id_Ingreso` ='" + xidingreso + "')\nORDER BY `ingreso_seguimiento`.`FechaD` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoSeguimientosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                IngresoSeguimientosDTO evidencia = new IngresoSeguimientosDTO();
                evidencia.setId(rs.getInt("Id"));
                evidencia.setFecha(rs.getString("FechaD"));
                evidencia.setObservacion(rs.getString("Observacion"));
                evidencia.setEstado(rs.getInt("Estado"));
                evidencia.setGAlerta(rs.getInt("GAlerta"));
                evidencia.setIdTipoSegumiento(rs.getString("TipoSeguimiento"));
                evidencia.setPCierreFactura(rs.getInt("PCierreFactura"));
                evidencia.setCerrado(rs.getInt("Cerrado"));
                evidencia.setCargoResponsable(rs.getString("Ncargo"));
                evidencia.setPersonaResponsable(rs.getString("NUsuario"));
                evidencia.setIdUsuarioResponsable(Long.valueOf(rs.getLong("IdPersonaR")));
                return evidencia;
            }
        };
        List<IngresoSeguimientosDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String mcreate(IngresoSeguimientosDTO e) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `ingreso_seguimiento`(`Id_Ingreso`,`Id_Tipo`, IdPersonaR, `FechaD`,`Observacion`,`GAlerta`,`Id_UsuarioRh`,`Estado`)\nVALUES (?,?,?,?,?,?,?,?);", new Object[]{Long.valueOf(e.getIdIngreso()), e.getIdTipoSegumiento(), e.getIdUsuarioResponsable(), e.getFecha(), e.getObservacion(), Integer.valueOf(e.getGAlerta()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Integer.valueOf(e.getEstado())});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String mDelete(IngresoSeguimientosDTO xevidencia) {
        String sql = "UPDATE\n  `ingreso_seguimiento`\nSET\n  `Id_Motivo_Anulacion` = ?,\n  `Motivo_Anulacion` = ?,\n  `Observacion_Anulacion` = ?,\n  `Fecha_Anulacion` = ?,\n  `UsuarioRH_Anulacion` = ?,  \n  `Estado` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xevidencia.getIdMotivoAnulacion(), xevidencia.getMotivoAnulacion(), xevidencia.getObservacionAnulacion(), xevidencia.getFechaAnulacion(), xevidencia.getUsuarioRHAnulacion(), Integer.valueOf(xevidencia.getEstado()), Long.valueOf(xevidencia.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public List<GCGenericoDTO> mTipoSeguimiento() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoSeguimientosDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `g_tiposeguimiento` WHERE (`Estado` =1) ORDER BY `NOrden` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public List<IngresoSeguimientoDetalleDTO> mListarDetalle(Long xidSeguimiento) {
        String sql = "SELECT `Id`, `FechaD`, `Observacion`, `UrlEvidencia`, `USeguimiento`, `Estado` FROM `ingreso_seguimiento_detalle` WHERE (`Id_IngresoSeguimiento` ='" + xidSeguimiento + "') ORDER BY `FechaD` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoSeguimientosDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                IngresoSeguimientoDetalleDTO detalle = new IngresoSeguimientoDetalleDTO();
                detalle.setId(rs.getInt("Id"));
                detalle.setFecha(rs.getString("FechaD"));
                detalle.setObservacion(rs.getString("Observacion"));
                detalle.setUrlEvidencia(rs.getString("UrlEvidencia"));
                detalle.setUSeguimiento(rs.getInt("USeguimiento"));
                detalle.setEstado(rs.getInt("Estado"));
                return detalle;
            }
        };
        List<IngresoSeguimientoDetalleDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String mUpdateDetalle(IngresoSeguimientoDetalleDTO xdetalle) {
        String sql = "UPDATE\n  `ingreso_seguimiento_detalle`\nSET\n  `FechaD` = ?,\n  `Observacion` = ?,\n  `USeguimiento` = ?,\n  `Estado` = ?,\n  `Id_UsuarioRh` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xdetalle.getFecha(), xdetalle.getObservacion(), Integer.valueOf(xdetalle.getUSeguimiento()), Integer.valueOf(xdetalle.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xdetalle.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String mUpdateURLDetalle(IngresoSeguimientoDetalleDTO xdetalle) {
        String sql = "UPDATE\n  `ingreso_seguimiento_detalle`\nSET\n  `UrlEvidencia` = ?  \nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xdetalle.getUrlEvidencia(), Long.valueOf(xdetalle.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String create_return_id_Detalle(final IngresoSeguimientoDetalleDTO xdetalle) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoSeguimientosDAOImpl.4
            final String sql = "INSERT INTO `ingreso_seguimiento_detalle` (`Id_IngresoSeguimiento`,`FechaD`,`Observacion`,`USeguimiento`,`Estado`,`Id_UsuarioRh`)\nVALUES(?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `ingreso_seguimiento_detalle` (`Id_IngresoSeguimiento`,`FechaD`,`Observacion`,`USeguimiento`,`Estado`,`Id_UsuarioRh`)\nVALUES(?,?,?,?,?,?);", 1);
                ps.setLong(1, xdetalle.getIdIngresoSeguimiento());
                ps.setString(2, xdetalle.getFecha());
                ps.setString(3, xdetalle.getObservacion());
                ps.setInt(4, xdetalle.getUSeguimiento());
                ps.setInt(5, xdetalle.getEstado());
                ps.setLong(6, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdDetalleDoc = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xDetalle-->" + xIdDetalleDoc);
        return xIdDetalleDoc;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoSeguimientosDAO
    public String mCerrarSegumiento(IngresoSeguimientosDTO xevidencia) {
        String sql = "UPDATE\n  `ingreso_seguimiento`\nSET\n  `Cerrado` = ?  \nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xevidencia.getCerrado()), Long.valueOf(xevidencia.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
