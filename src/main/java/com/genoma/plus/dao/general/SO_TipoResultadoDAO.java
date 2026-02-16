package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.SO_TipoResultadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/SO_TipoResultadoDAO.class */
public interface SO_TipoResultadoDAO {
    List<SO_TipoResultadoDTO> mListar();

    String mCreate(SO_TipoResultadoDTO sO_TipoResultadoDTO);

    String mUpdate(SO_TipoResultadoDTO sO_TipoResultadoDTO);
}
