package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.PP_RubrosEncabezadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/PP_RubrosEncabezadoDAO.class */
public interface PP_RubrosEncabezadoDAO {
    List<PP_RubrosEncabezadoDTO> mListar();

    String mCreate(PP_RubrosEncabezadoDTO pP_RubrosEncabezadoDTO);

    String mUpdate(PP_RubrosEncabezadoDTO pP_RubrosEncabezadoDTO);
}
