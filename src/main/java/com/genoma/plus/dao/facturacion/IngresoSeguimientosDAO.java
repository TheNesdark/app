package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.IngresoSeguimientoDetalleDTO;
import com.genoma.plus.dto.facturacion.IngresoSeguimientosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/IngresoSeguimientosDAO.class */
public interface IngresoSeguimientosDAO {
    List<IngresoSeguimientosDTO> mListar(Long l);

    List<GCGenericoDTO> mTipoSeguimiento();

    String mcreate(IngresoSeguimientosDTO ingresoSeguimientosDTO);

    String mDelete(IngresoSeguimientosDTO ingresoSeguimientosDTO);

    String mCerrarSegumiento(IngresoSeguimientosDTO ingresoSeguimientosDTO);

    List<IngresoSeguimientoDetalleDTO> mListarDetalle(Long l);

    String create_return_id_Detalle(IngresoSeguimientoDetalleDTO ingresoSeguimientoDetalleDTO);

    String mUpdateURLDetalle(IngresoSeguimientoDetalleDTO ingresoSeguimientoDetalleDTO);

    String mUpdateDetalle(IngresoSeguimientoDetalleDTO ingresoSeguimientoDetalleDTO);
}
