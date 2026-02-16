package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TRiesgoTEventoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/SC_TRiesgoTEventoDAO.class */
public interface SC_TRiesgoTEventoDAO {
    List<SC_TRiesgoTEventoDTO> mListar();

    List<GCGenericoDTO> listaTEvento();

    List<GCGenericoDTO> listaTRiesgo();

    String mCreate(SC_TRiesgoTEventoDTO sC_TRiesgoTEventoDTO);

    String mUpdate(SC_TRiesgoTEventoDTO sC_TRiesgoTEventoDTO);
}
