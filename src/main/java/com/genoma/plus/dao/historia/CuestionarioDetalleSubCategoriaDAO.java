package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.CuestionarioDetalleSubCategoriaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/CuestionarioDetalleSubCategoriaDAO.class */
public interface CuestionarioDetalleSubCategoriaDAO {
    void mCrear(CuestionarioDetalleSubCategoriaDTO cuestionarioDetalleSubCategoriaDTO);

    List<CuestionarioDetalleSubCategoriaDTO> mListCuestionario(Long l, int i);
}
