package com.genoma.plus.dao.salud_ocupacional;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.RevisionExamenSoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/salud_ocupacional/RevisionExamenSoDAO.class */
public interface RevisionExamenSoDAO {
    List<RevisionExamenSoDTO> listRevisionExamen(String str);

    List<Object[]> listRevisionExamen2(String str);

    List<Object[]> listaSoportes(String str, Long l);

    String updateRevisionExamen(RevisionExamenSoDTO revisionExamenSoDTO);

    List<GCGenericoDTO> listaResultados(String str);

    void cargarArchivosDeResultados(RevisionExamenSoDTO revisionExamenSoDTO);
}
