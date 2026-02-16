package com.genoma.plus.dao.impl.salud_ocupacional;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO;
import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionDTO;
import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionesDetalleCitaDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoAtencionRemisionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/ControlRemisionesDAOImpl.class */
public class ControlRemisionesDAOImpl implements ControlRemisionesDAO {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public List<Object[]> listarTipoAtencionServicio() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.ControlRemisionesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3))};
                return fila;
            }
        };
        System.out.println("Tipo Atenciones : SELECT st.Id, st.Nbre, st.Estado FROM `so_tipo_atencion` st");
        List<Object[]> list = this.jdbcTemplate.query("SELECT st.Id, st.Nbre, st.Estado FROM `so_tipo_atencion` st", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public List<Object[]> cargarTiposdeAtencionRemision() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.ControlRemisionesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = Integer.valueOf(rs.getInt(1));
                return fila;
            }
        };
        System.out.println("Tipos de atenciones asignadas a la remision : select scrdta.idTipoAtencion  from so_control_remisiones scr \ninner join so_control_remisiones_detalle_tipo_atencion scrdta on scrdta.idControlRemision = scr.id");
        List<Object[]> list = this.jdbcTemplate.query("select scrdta.idTipoAtencion  from so_control_remisiones scr \ninner join so_control_remisiones_detalle_tipo_atencion scrdta on scrdta.idControlRemision = scr.id", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void grabarListaTiposAtencion(List<TipoAtencionRemisionDTO> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void create(int idControlRemision, TipoAtencionRemisionDTO e) {
        this.jdbcTemplate.update("INSERT INTO so_control_remisiones_detalle_tipo_atencion (idControlRemision, idTipoAtencion)\nVALUES (?,?);", new Object[]{Integer.valueOf(idControlRemision), e.getId()});
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public String grabarControlREmision(ControlDeRemisionDTO e) {
        String sql = "INSERT INTO baseserver.so_control_remisiones\n(fecha, idPersona, hospedaje, direccion, idCausaExterna, transporteAereo, motivoTransporteAereo, acompanante, motivoAcompanante, AcompananteTransporteAereo, motivoTransporteAereoAcomp ,nombreAcompanante, idPersonaRh, estado, fechaRegistro,idProfesiona,barrioHospedaje,clasificacionEmpleado,codigoEmpleado,pasaporte,observacion,corberturaViajePaciente,corbeturaViajeAcompanante,diasPorFueraPaciente, epsRemision)\nVALUES('" + e.getFecha() + "','" + e.getIdPersona() + "'," + e.getHospedaje() + ",'" + e.getDireccion() + "','" + e.getIdCausaExterna() + "'," + e.getTransporteAereo() + ",'" + e.getMotivoTrasnporteAereo() + "'," + e.getAcompanante() + ",'" + e.getMotivoAcompanante() + "'," + e.getTransporteAereoAcompananate() + ",'" + e.getMotivoTrasnporteAereoAcompanante() + "','" + e.getNombreAcompanante() + "','" + e.getIdPersonaRh() + "'," + e.getEstado() + ",'" + e.getFechaRegistro() + "','" + e.getIdProfesional() + "','" + e.getBarrioHospedaje() + "'," + e.getClasificacionEmpleado() + ",'" + e.getCodigoEmpleado() + "','" + e.getPasaporte() + "','" + e.getObservacion() + "','" + e.getCorbeturaViajeEmpleado() + "','" + e.getCorbeturaViajeAcompanante() + "','" + e.getDiasPorFueraPaciente() + "','" + e.getEpsRemision() + "');";
        System.out.println("guardar en so_control_remisiones -> " + sql);
        String idControlRemision = this.xct.ejecutarSQLId(sql);
        return idControlRemision;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void grabarControlRemisionDetalleCita(List<ControlDeRemisionesDetalleCitaDTO> e) {
        if (e.size() > 0) {
            for (int i = 0; i < e.size(); i++) {
                String sql = "insert into so_control_remisiones_detalle_cita (idControlRemisiones, idEspecialidad, nombreProfesional, fechaCita,\n                                                horaCita, estado,telefonoCita,direcionCita, nombreInstitucion)\nvalues ('" + e.get(i).getIdControlRemisiones() + "','" + e.get(i).getIdEspecialidad() + "','" + e.get(i).getNombreProfesional() + "','" + e.get(i).getFechaCita() + "','" + e.get(i).getHoraCita() + "'," + e.get(i).getEstado() + ",'" + e.get(i).getTelefonoCita() + "','" + e.get(i).getDireccionCita() + "','" + e.get(i).getInstitucion() + "');";
                System.out.println("grabar en so_control_remisiones_detalle_cita -> " + sql);
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void grabarControlRemisionDetalleCitaMineros(List<ControlDeRemisionesDetalleCitaDTO> e) {
        if (e.size() > 0) {
            for (int i = 0; i < e.size(); i++) {
                String sql = "insert into so_control_remisiones_detalle_cita (idControlRemisiones, idEspecialidad, institucion, fechaCita,\n                                                horaCita, estado,telefonoCita,direcionCita)\nvalues ('" + e.get(i).getIdControlRemisiones() + "','" + e.get(i).getIdEspecialidad() + "','" + e.get(i).getInstitucion() + "','" + e.get(i).getFechaCita() + "','" + e.get(i).getHoraCita() + "'," + e.get(i).getEstado() + ",'" + e.get(i).getTelefonoCita() + "','" + e.get(i).getDireccionCita() + "');";
                System.out.println("grabar en so_control_remisiones_detalle_cita -> " + sql);
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void actualizarControlRemision(ControlDeRemisionDTO e, Integer acompanante, Integer clasificacionEmpleado, Integer AcompananteTransporteAereo, Integer transporteAereo) {
        String sql = "UPDATE `baseserver`.`so_control_remisiones` SET `hospedaje` = '" + e.getHospedaje() + "' , `direccion` = '" + e.getDireccion() + "' , `idCausaExterna` = '" + e.getIdCausaExterna() + "' , `barrioHospedaje` = '" + e.getBarrioHospedaje() + "' , `transporteAereo` = '" + transporteAereo + "' , `motivoTransporteAereo` = '" + e.getMotivoTrasnporteAereo() + "' , `acompanante` = '" + acompanante + "' , `motivoAcompanante` = '" + e.getMotivoAcompanante() + "' , `AcompananteTransporteAereo` = '" + AcompananteTransporteAereo + "' , `nombreAcompanante` = '" + e.getNombreAcompanante() + "' , `motivoTransporteAereoAcomp` = '" + e.getMotivoTrasnporteAereoAcompanante() + "' , `idProfesiona` = '" + e.getIdProfesional() + "' , `clasificacionEmpleado` = '" + clasificacionEmpleado + "' , `codigoEmpleado` = '" + e.getCodigoEmpleado() + "' , `observacion` = '" + e.getObservacion() + "' , `corberturaViajePaciente` = '" + e.getCorbeturaViajeEmpleado() + "' , `corbeturaViajeAcompanante` = '" + e.getCorbeturaViajeAcompanante() + "' ,`diasPorFueraPaciente` = '" + e.getDiasPorFueraPaciente() + "' ,epsRemision = '" + e.getEpsRemision() + "' WHERE `id` = '" + Principal.txtNo.getText() + "'; ";
        System.out.println("actualizar en so_control_remisiones_detalle_cita -> " + sql);
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO
    public void actualizarControlRemisionDetalleCitaMineros(List<ControlDeRemisionesDetalleCitaDTO> e, List<Integer> idDetalleCita) {
        if (e.size() > 0) {
            for (int i = 0; i < e.size(); i++) {
                String sql = "UPDATE `baseserver`.`so_control_remisiones_detalle_cita` SET `idEspecialidad` = '" + e.get(i).getIdEspecialidad() + "' , `nombreProfesional` = '" + e.get(i).getNombreProfesional() + "' , `fechaCita` = '" + e.get(i).getFechaCita() + "' , `horaCita` = '" + e.get(i).getHoraCita() + "' , `telefonoCita` = '" + e.get(i).getTelefonoCita() + "' , `direcionCita` = '" + e.get(i).getDireccionCita() + "' , `nombreInstitucion` = '" + e.get(i).getInstitucion() + "' WHERE `idControlRemisiones` = '" + Principal.txtNo.getText() + "' and id='" + e.get(i).getIdListRemision().get(i) + "'; ";
                System.out.println("actualizar en so_control_remisiones_detalle_cita -> " + sql);
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        }
    }
}
