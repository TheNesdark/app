package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.itemsOrdenDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/LiquidacionOrdenesServicioDAO.class */
public interface LiquidacionOrdenesServicioDAO {
    List<Object[]> listadoDetalleOrdenesServiciosIngreso(Long l, String str, Boolean bool, String str2);

    void actualizar(itemsOrdenDTO itemsordendto, Integer num);

    void actualizarTotalOrden(itemsOrdenDTO itemsordendto, Double d, Double d2);

    void trasladarOrdenIngreso(Long l, Long l2);

    List<Object[]> listadoIngresoDestino(Long l, Long l2);

    void actualizarTotalOrden(String str, String str2);

    List<Object[]> listadoOrdenes(String str);

    void actualizarNumeroAutorizacion(String str, String str2);
}
