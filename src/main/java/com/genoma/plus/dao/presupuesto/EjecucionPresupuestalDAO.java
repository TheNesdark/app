package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.EjecucionPresupuestalDTO;
import com.genoma.plus.dto.presupuesto.EjecucionPresupuestalNuevaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/EjecucionPresupuestalDAO.class */
public interface EjecucionPresupuestalDAO {
    boolean existeTable(String str);

    String executeQueryPTO(String str, String str2, String str3);

    void updateValoresPadres(String str);

    List<EjecucionPresupuestalDTO> getEjecucionPresupuestal(String str);

    void deleteTemporalTable(String str);

    String libroPresupuestalIngreso(String str, String str2, String str3);

    String libroPresupuestalGastos(String str, String str2, String str3);

    List<EjecucionPresupuestalDTO> listEjecucionPresupuestalPeriodo(String str, String str2, String str3, String str4);

    Double valorRubro(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, String str6);

    boolean verificarExistenciaTabla(String str);

    String queryEjecucionNeuva(String str, String str2, String str3);

    void actualizarValoresPadreNuevoFormato(String str);

    List<EjecucionPresupuestalNuevaDTO> getEjecucionPresupuestalNueva(String str);

    void eliminarTablasTemporales(String str);
}
