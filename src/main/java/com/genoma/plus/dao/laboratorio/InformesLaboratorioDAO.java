package com.genoma.plus.dao.laboratorio;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/InformesLaboratorioDAO.class */
public interface InformesLaboratorioDAO {
    List<Object[]> informeEstadisticamuestraNuevas(String str, String str2);

    List<Object[]> informeEstadisticaExamenesPorServiciosAmbulatoria(String str, String str2);

    List<Object[]> informeEstadisticaExamenesPorServicios(String str, String str2);
}
