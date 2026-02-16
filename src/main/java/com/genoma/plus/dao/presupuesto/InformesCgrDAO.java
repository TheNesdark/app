package com.genoma.plus.dao.presupuesto;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/InformesCgrDAO.class */
public interface InformesCgrDAO {
    List<Object[]> lisProgramacionIngresos(String str, String str2, String str3);

    List<Object[]> lisProgramacionGastos(String str, String str2, String str3);

    List<Object[]> lisEjecucionGastos(String str, String str2, String str3);
}
