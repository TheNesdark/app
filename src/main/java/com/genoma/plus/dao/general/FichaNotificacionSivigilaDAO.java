package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.FichaNotificacionSivigilaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/FichaNotificacionSivigilaDAO.class */
public interface FichaNotificacionSivigilaDAO {
    List<FichaNotificacionSivigilaDTO> listSivigila();

    String mCreate(FichaNotificacionSivigilaDTO fichaNotificacionSivigilaDTO);

    String mCreateSinArchivo(FichaNotificacionSivigilaDTO fichaNotificacionSivigilaDTO);

    String mUpdate(FichaNotificacionSivigilaDTO fichaNotificacionSivigilaDTO);

    String mUpdateSinArchivo(FichaNotificacionSivigilaDTO fichaNotificacionSivigilaDTO);
}
