package com.genoma.plus.dao.sgc;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SC_EstaditicadeConsulta.class */
public interface SC_EstaditicadeConsulta {
    List<Object[]> informeConsolidadoCitasPyP(String str, String str2);

    List<Object[]> informeConsolidadoCitaEspecialidad(String str, String str2);

    List<Object[]> informeConsolidadoCitaConsolidados(String str, String str2);
}
