package com.genoma.plus.dao.inventario;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/inventario/ConsolidadoCierreContableDAO.class */
public interface ConsolidadoCierreContableDAO {
    List<Object[]> listBodegasDocContable(String str, String str2, int i);

    List<Object[]> listConsolidadoCierre(String str, String str2, int i, String str3);

    List<Object[]> listDetalleCierre(int i, String str);
}
