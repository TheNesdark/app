package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoConcentimientoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoConsentimientoDAO.class */
public interface TipoConsentimientoDAO {
    List<TipoConcentimientoDTO> listTipoConcentimiento();

    String mCreatetipoConcentimiento(TipoConcentimientoDTO tipoConcentimientoDTO);

    String mUpdatetipoConcentimiento(TipoConcentimientoDTO tipoConcentimientoDTO);
}
