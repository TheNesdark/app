package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADConversionPDPTDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADConversionPDPTDAO.class */
public interface PEADConversionPDPTDAO {
    List<Object[]> listaConversionPDPT();

    String mCreate(PEADConversionPDPTDTO pEADConversionPDPTDTO);

    String mUpdate(PEADConversionPDPTDTO pEADConversionPDPTDTO);
}
