package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TEventoTConAccDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/SC_TEventoTConAccDAO.class */
public interface SC_TEventoTConAccDAO {
    List<SC_TEventoTConAccDTO> mListar(String str);

    List<GCGenericoDTO> listaAcciones(int i);

    String mCreate(SC_TEventoTConAccDTO sC_TEventoTConAccDTO);

    String mUpdate(SC_TEventoTConAccDTO sC_TEventoTConAccDTO);
}
