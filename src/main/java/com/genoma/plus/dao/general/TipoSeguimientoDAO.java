package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoSeguimientoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoSeguimientoDAO.class */
public interface TipoSeguimientoDAO {
    List<TipoSeguimientoDTO> listTipoSeguimiento();

    String mCreate(TipoSeguimientoDTO tipoSeguimientoDTO);

    String mUpdate(TipoSeguimientoDTO tipoSeguimientoDTO);
}
