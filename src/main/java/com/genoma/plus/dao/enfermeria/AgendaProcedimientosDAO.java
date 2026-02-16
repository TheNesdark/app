package com.genoma.plus.dao.enfermeria;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/enfermeria/AgendaProcedimientosDAO.class */
public interface AgendaProcedimientosDAO {
    List<Object[]> listCargarProcedimientos(String str, String str2, String str3);

    void actualizarEstadoAtencion(Long l);
}
