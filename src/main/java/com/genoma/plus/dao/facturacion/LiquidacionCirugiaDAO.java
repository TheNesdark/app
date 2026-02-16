package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.ItemsRipsNacimientosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/LiquidacionCirugiaDAO.class */
public interface LiquidacionCirugiaDAO {
    List<Object[]> listadoCirugiaHistoria(String str);

    List<Object[]> listadoIntegrantesCirugiaHistoria(String str);

    List<Object[]> listadoDiagnosticoCirugiaHistoria(String str);

    List<Object[]> listadoProcedimientosdeCirugiaHistoria(String str);

    List<Object[]> listadoNacimientosCirugiaHistoria(String str);

    void mCreateItemsRipsNacimiento(ItemsRipsNacimientosDTO itemsRipsNacimientosDTO);

    void mActualizarIdOrdenQxHistoria(String str, String str2);
}
