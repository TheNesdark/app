package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.IngresoOrdenSalidaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/IngresoOrdenSalidaDAO.class */
public interface IngresoOrdenSalidaDAO {
    List<IngresoOrdenSalidaDTO> mListarOrdenSalida(Long l);

    String create_return_id(IngresoOrdenSalidaDTO ingresoOrdenSalidaDTO);

    IngresoOrdenSalidaDTO consultarEstadoLiquidacion(long j);

    String anular(IngresoOrdenSalidaDTO ingresoOrdenSalidaDTO);

    void actualizar(IngresoOrdenSalidaDTO ingresoOrdenSalidaDTO);
}
