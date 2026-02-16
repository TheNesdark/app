package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADGraficaColorDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADGraficaColorDAO.class */
public interface PEADGraficaColorDAO {
    List<PEADGraficaColorDTO> listaGraficaColor();

    String mCreate(PEADGraficaColorDTO pEADGraficaColorDTO);

    String mUpdate(PEADGraficaColorDTO pEADGraficaColorDTO);
}
