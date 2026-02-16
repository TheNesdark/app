package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoConAccionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoConAccionDAO.class */
public interface TipoConAccionDAO {
    List<TipoConAccionDTO> list();

    List<TipoConAccionDTO> listFiltroAcciones(String str, int i, String str2);

    String create(TipoConAccionDTO tipoConAccionDTO);

    String update(TipoConAccionDTO tipoConAccionDTO);
}
