package com.genoma.plus.dao.rrhh;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.rrhh.ConsolidadoConceptosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/rrhh/ConsolidadoConceptosDAO.class */
public interface ConsolidadoConceptosDAO {
    List<ConsolidadoConceptosDTO> list(String str);

    List<GCGenericoDTO> listaNomina(String str);
}
