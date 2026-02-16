package com.genoma.plus.dao.enfermeria;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/enfermeria/HojaTratamientoDAO.class */
public interface HojaTratamientoDAO {
    List<Object[]> listaHojaTratamiento(String str, boolean z, String str2);

    String createAplicacionTratamiento_return_id(String str, String str2, String str3, String str4);

    void crearDetalleAplicacionTratamiento(String str, String str2, String str3, String str4, String str5);

    void deleteResultado(Long l, Long l2);

    void deleteResultado(List<Long> list, List<Long> list2);

    void updateTratamiento(String str, int i, String str2, Long l, Long l2, String str3);
}
