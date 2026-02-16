package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO;
import com.genoma.plus.dto.rrhh.PresupuestoEncabezadoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/PresupuestoEncabezadoDAOImpl.class */
public class PresupuestoEncabezadoDAOImpl implements PresupuestoEncabezadoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO
    public List<PresupuestoEncabezadoDTO> obtenerMovimiento(int idCompromiso) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.PresupuestoEncabezadoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PresupuestoEncabezadoDTO fila = PresupuestoEncabezadoDTO.builder().id(rs.getInt(1)).idPeriodo(rs.getInt(2)).idTipoDocumento(rs.getInt(3)).noConsecutivo(rs.getInt(4)).fechaD(rs.getString(5)).observacion(rs.getString(6)).fechaFact(rs.getString(7)).NoFactura(rs.getString(8)).valorF(rs.getDouble(9)).idUsuarioR(rs.getInt(10)).idMotivoAnulacion(rs.getInt(11)).observacionAnulacion(rs.getString(12)).usuarioAnulacion(rs.getString(13)).idSolicitud(rs.getInt(14)).idDisponibilidad(rs.getInt(15)).idCompromiso(rs.getInt(16)).idObligacion(rs.getInt(17)).noDocumento(rs.getString(18)).idContable(rs.getInt(19)).idNomina(rs.getInt(20)).datoResolucion(rs.getString(21)).fechaAD(rs.getString(22)).noDocumentoPadre(rs.getString(23)).bloqueo(rs.getBoolean(24)).esGlobal(rs.getBoolean(25)).fecha(rs.getString(26)).usuario(rs.getString(27)).build();
                return fila;
            }
        };
        List<PresupuestoEncabezadoDTO> listaPresupuestoEncabezado = this.jdbcTemplate.query("SELECT `Id`,`Id_Periodo`,`Id_TipoDoc`,`NoConcecutivo`,`FechaD`,`Observacion`,`FechaFact`,`NoFact`,`ValorF`,`IdUsuarioR`,\n`Id_MotivoAnulacion`,`FechaAnulacion`,`Observacion_Anul`,`Usuario_Anul`,`IdSolicitud`,`IdDisponibilidad`,\n`IdCompromiso`,`IdObligacion`,`NoDocumento`,`IdDocContable`,`Id_Nomina`,`DatoResolucion`,`FechaAD`,\n`NoDocumentoPadre`,`EsGlobal`,`Fecha`,`UsuarioS` FROM `pp_movimiento` WHERE (id = ?);", rowMapper);
        return listaPresupuestoEncabezado;
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO
    public int crearEncabezado(final PresupuestoEncabezadoDTO presupuestoEncabezado) {
        final String sql = "INSERT INTO `Id_Periodo`,`Id_TipoDoc`,`NoConcecutivo`,`FechaD`,`Observacion`,`FechaFact`,`NoFact`,`ValorF`,`IdUsuarioR`,`Id_MotivoAnulacion`\n,`FechaAnulacion`,`Observacion_Anul`,`Usuario_Anul`,`IdSolicitud`,`IdDisponibilidad`,`IdCompromiso`,`IdObligacion`,`NoDocumento`,\n`IdDocContable`,`Id_Nomina`,`DatoResolucion`,`FechaAD`,`NoDocumentoPadre`,`Bloqueo`,`EsGlobal`,`Fecha`,`UsuarioS` VALUES \n(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?);";
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.rrhh.PresupuestoEncabezadoDAOImpl.2
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, 1);
                ps.setInt(1, presupuestoEncabezado.getIdPeriodo());
                ps.setInt(2, presupuestoEncabezado.getIdTipoDocumento());
                ps.setString(3, presupuestoEncabezado.getNoDocumento());
                ps.setString(4, presupuestoEncabezado.getFechaD());
                ps.setString(6, presupuestoEncabezado.getObservacion());
                ps.setString(7, presupuestoEncabezado.getFechaFact());
                ps.setString(8, presupuestoEncabezado.getNoFactura());
                ps.setDouble(9, presupuestoEncabezado.getValorF());
                ps.setInt(10, presupuestoEncabezado.getIdUsuarioR());
                ps.setInt(11, presupuestoEncabezado.getIdMotivoAnulacion());
                ps.setString(12, presupuestoEncabezado.getFechaAnulacion());
                ps.setString(13, presupuestoEncabezado.getObservacionAnulacion());
                ps.setString(14, presupuestoEncabezado.getUsuarioAnulacion());
                ps.setInt(15, presupuestoEncabezado.getIdSolicitud());
                ps.setInt(16, presupuestoEncabezado.getIdDisponibilidad());
                ps.setInt(17, presupuestoEncabezado.getIdCompromiso());
                ps.setInt(18, presupuestoEncabezado.getIdObligacion());
                ps.setString(19, presupuestoEncabezado.getNoDocumento());
                ps.setInt(20, presupuestoEncabezado.getIdContable());
                ps.setInt(21, presupuestoEncabezado.getIdNomina());
                ps.setString(22, presupuestoEncabezado.getDatoResolucion());
                ps.setString(23, presupuestoEncabezado.getFechaAD());
                ps.setString(24, presupuestoEncabezado.getNoDocumentoPadre());
                ps.setBoolean(25, presupuestoEncabezado.isBloqueo());
                ps.setBoolean(26, presupuestoEncabezado.isEsGlobal());
                ps.setString(27, presupuestoEncabezado.getFecha());
                ps.setString(28, presupuestoEncabezado.getUsuario());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        int idEncabezadoPresupuesto = generatedKeyHolder.getKey().intValue();
        return idEncabezadoPresupuesto;
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO
    public String updateEncabezado(PresupuestoEncabezadoDTO presupuestoEncabezado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO
    public String actualizarCompromiso(int idDisponibilidad, int idCompromiso) {
        String resultado = "Se actualizo el compromiso";
        String sql = "UPDATE `pp_movimiento` SET `pp_movimiento`.`IdDisponibilidad`=" + idDisponibilidad + " WHERE `pp_movimiento`.`Id` =" + idCompromiso + ";";
        int ctos = this.jdbcTemplate.update(sql);
        if (ctos == 0) {
            resultado = "No se pudo actualizar";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoEncabezadoDAO
    public int consultarDisponibilidadDeNominaDelCompromiso(int idCompromiso) {
        String sql = "SELECT `Id` FROM `pp_movimiento` WHERE (`pp_movimiento`.`IdCompromiso` =" + idCompromiso + "  AND `pp_movimiento`.`Id_MotivoAnulacion` =1);";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.PresupuestoEncabezadoDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                return Integer.valueOf(id);
            }
        };
        int id = Integer.parseInt(this.jdbcTemplate.query(sql, rowMapper).get(0).toString());
        return id;
    }
}
