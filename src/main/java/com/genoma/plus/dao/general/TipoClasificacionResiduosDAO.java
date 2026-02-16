package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoClasificacionResiduosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoClasificacionResiduosDAO.class */
public interface TipoClasificacionResiduosDAO {
    List<TipoClasificacionResiduosDTO> listClasificacionResiduos();

    String mCreate(TipoClasificacionResiduosDTO tipoClasificacionResiduosDTO);

    String mUpdate(TipoClasificacionResiduosDTO tipoClasificacionResiduosDTO);
}
