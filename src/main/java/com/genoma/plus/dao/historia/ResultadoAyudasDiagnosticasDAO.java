package com.genoma.plus.dao.historia;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ResultadoAyudasDiagnosticasDAO.class */
public interface ResultadoAyudasDiagnosticasDAO {
    List<Object[]> listadoTipoAyudasDiagnosticasFiltradaPorUsuario(String str);

    List<Object[]> listadoAyudasDiagnosticasFiltradaPorUsuario(String str, String str2);

    String update(String str, String str2, String str3);
}
