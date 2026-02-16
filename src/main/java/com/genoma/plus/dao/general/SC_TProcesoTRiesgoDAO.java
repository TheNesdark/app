package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TProcesoTRiesgoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/SC_TProcesoTRiesgoDAO.class */
public interface SC_TProcesoTRiesgoDAO {
    List<SC_TProcesoTRiesgoDTO> mListar(String str);

    List<GCGenericoDTO> listaTProceso();

    List<GCGenericoDTO> listaTRiesgo();

    String mCreate(SC_TProcesoTRiesgoDTO sC_TProcesoTRiesgoDTO);

    String mUpdate(SC_TProcesoTRiesgoDTO sC_TProcesoTRiesgoDTO);
}
