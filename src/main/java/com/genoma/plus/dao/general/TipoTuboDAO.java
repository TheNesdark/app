package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoTuboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoTuboDAO.class */
public interface TipoTuboDAO {
    List<TipoTuboDTO> mListar();

    String mCreate(TipoTuboDTO tipoTuboDTO);

    String mUpdate(TipoTuboDTO tipoTuboDTO);
}
