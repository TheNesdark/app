package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.MovimientoDetalleDTO;
import com.genoma.plus.dto.presupuesto.PeriodoDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDetalleDTO;
import com.genoma.plus.dto.presupuesto.TipoDocumentoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/PresupuestoDAO.class */
public interface PresupuestoDAO {
    List<PeriodoDTO> listPeriodoPPT();

    List<PeriodoDTO> listPeriodoPPT(String str);

    List<PeriodoDTO> listPeriodoPptActivos();

    List<TipoDocumentoDTO> lisTipoDocumentoId(int i);

    Long addMovimientoPpt(Long l, String str, String str2, String str3, String str4, Integer num);

    String addMovimientoDetallePpt(Long l, String str, String str2, String str3, Double d, String str4);

    String guardaSolicitud_return_id(SolicitudDTO solicitudDTO);

    String guardaSolicitudDetalle(SolicitudDetalleDTO solicitudDetalleDTO);

    List<Object[]> getListRubrosSolicitud(int i, int i2);

    String actualizaAjusteEncabezado(int i, double d, String str, String str2);

    String actualizaAjusteSolicitudRubro(SolicitudDetalleDTO solicitudDetalleDTO);

    List<Object[]> getDisponibilidad(int i);

    List<Object[]> getCompromiso(int i);

    List<Object[]> getObligacion(int i);

    String guardaDetalleMovimiento(MovimientoDetalleDTO movimientoDetalleDTO);

    void actualizarEstadoDetalleSolicitud(Long l);

    void actualizarEstadoDetalleMovimiento(Long l);

    void actualizarDetalleEncabezadoMovimiento(Long l, String str);

    List<Object[]> getListSolicitudDetalle(int i, int i2);
}
