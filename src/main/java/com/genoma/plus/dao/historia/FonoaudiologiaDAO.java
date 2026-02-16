package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.FonoaudiologiaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/FonoaudiologiaDAO.class */
public interface FonoaudiologiaDAO {
    String mCreate(FonoaudiologiaDTO fonoaudiologiaDTO);

    List<FonoaudiologiaDTO> listFonoaudiologia(Long l);

    String mUpdate(FonoaudiologiaDTO fonoaudiologiaDTO);
}
