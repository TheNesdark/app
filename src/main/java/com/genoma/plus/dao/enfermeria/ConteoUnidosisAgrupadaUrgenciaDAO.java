package com.genoma.plus.dao.enfermeria;

import com.genoma.plus.dto.enfermeria.ConteoUnidosisAgrupadaUrgenciaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/enfermeria/ConteoUnidosisAgrupadaUrgenciaDAO.class */
public interface ConteoUnidosisAgrupadaUrgenciaDAO {
    List<ConteoUnidosisAgrupadaUrgenciaDTO> CantidadUnidosisAplicadaAgrupada(String str, String str2);

    List<ConteoUnidosisAgrupadaUrgenciaDTO> CantidadUnidosisAplicada(String str, String str2);
}
