package com.genoma.plus.dao.sig;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/ConsultaPeriodoDuracionTratamientoDAO.class */
public interface ConsultaPeriodoDuracionTratamientoDAO {
    List<Object[]> listaInformacion(String str, String str2, String str3, Boolean bool);

    List<Object[]> listaInformacion2(String str, String str2, String str3, Boolean bool);

    List<Object[]> listaEmpresa(String str, String str2);
}
