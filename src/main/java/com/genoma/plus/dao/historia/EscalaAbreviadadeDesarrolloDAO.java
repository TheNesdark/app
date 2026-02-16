package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.EADEvaluacionDTO;
import com.genoma.plus.dto.historia.EADEvaluacionDetalleItemsDTO;
import com.genoma.plus.dto.historia.EADEvaluacionResultadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/EscalaAbreviadadeDesarrolloDAO.class */
public interface EscalaAbreviadadeDesarrolloDAO {
    List<Object[]> listaEscalaAbreviadadeDesarrollo(int i, int i2);

    String edad(String str, String str2);

    int traerRango(String str, String str2);

    int insertarEvaluacion(EADEvaluacionDTO eADEvaluacionDTO);

    String insertarEvaluacionDetallesItems(EADEvaluacionDetalleItemsDTO eADEvaluacionDetalleItemsDTO);

    String insertarEvaluacionResultado(EADEvaluacionResultadoDTO eADEvaluacionResultadoDTO);

    int traerPuntuacionTipica(int i, int i2, int i3);

    int traerColor(int i, int i2, int i3);

    boolean validarGuardado(int i);

    List<Object[]> listaEncabezado(long j);

    List<Object[]> listaItemenes(int i);

    List<Object[]> listResuldatdo(int i);

    List<Object[]> listEncabezadoAnteriores(String str, long j);

    List<Object[]> listaFechaIngreso(int i);

    int traerEvaluacion(int i);
}
