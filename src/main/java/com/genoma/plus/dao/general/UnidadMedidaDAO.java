package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.UnidadMedidaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/UnidadMedidaDAO.class */
public interface UnidadMedidaDAO {
    List<UnidadMedidaDTO> mListar();

    String mCreate(UnidadMedidaDTO unidadMedidaDTO);

    String mUpdate(UnidadMedidaDTO unidadMedidaDTO);
}
