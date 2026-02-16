package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADAreaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADAreaDAO.class */
public interface PEADAreaDAO {
    List<PEADAreaDTO> listaArea();

    String mCreate(PEADAreaDTO pEADAreaDTO);

    String mUpdate(PEADAreaDTO pEADAreaDTO);
}
