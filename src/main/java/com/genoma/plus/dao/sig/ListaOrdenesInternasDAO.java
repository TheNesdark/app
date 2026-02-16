package com.genoma.plus.dao.sig;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/ListaOrdenesInternasDAO.class */
public interface ListaOrdenesInternasDAO {
    List<Object[]> ListDetalle(String str, String str2, String str3, String str4);

    List<Object[]> ListConsolidado(String str, String str2, String str3);
}
