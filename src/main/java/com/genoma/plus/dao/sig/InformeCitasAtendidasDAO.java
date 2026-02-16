package com.genoma.plus.dao.sig;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/InformeCitasAtendidasDAO.class */
public interface InformeCitasAtendidasDAO {
    List<Object[]> mListarCitasProgramas(String str, String str2);

    List<Object[]> mListarCitasNoProgramas(String str, String str2);
}
