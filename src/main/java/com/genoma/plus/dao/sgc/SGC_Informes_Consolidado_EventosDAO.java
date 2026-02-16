package com.genoma.plus.dao.sgc;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SGC_Informes_Consolidado_EventosDAO.class */
public interface SGC_Informes_Consolidado_EventosDAO {
    List<Object[]> informeConsolidadoTipoEvento(String str, String str2);

    List<Object[]> informeConsolidadoTipoClasificacion(String str, String str2);

    List<Object[]> informeConsolidadoTipoCategoria(String str, String str2);
}
