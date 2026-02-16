package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADItemAreaRangoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADItemAreaRangoDAO.class */
public interface PEADItemAreaRangoDAO {
    List<PEADItemAreaRangoDTO> listaItemAreasRango();

    String mCreate(PEADItemAreaRangoDTO pEADItemAreaRangoDTO);

    String mUpdate(PEADItemAreaRangoDTO pEADItemAreaRangoDTO);
}
