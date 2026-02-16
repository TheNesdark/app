package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.Orden_UnidosisDTO;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/Orden_UnidosisDAO.class */
public interface Orden_UnidosisDAO {
    Long grabar(Orden_UnidosisDTO orden_UnidosisDTO);

    void anular(Long l);

    void solicitarServicioFarmaceutico(Long l, String str);
}
