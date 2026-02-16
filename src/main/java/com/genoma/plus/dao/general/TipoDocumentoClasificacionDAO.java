package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoDocumentoClasificacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoDocumentoClasificacionDAO.class */
public interface TipoDocumentoClasificacionDAO {
    List<TipoDocumentoClasificacionDTO> listTipoDocumentoClasificacion();

    String mCreate(TipoDocumentoClasificacionDTO tipoDocumentoClasificacionDTO);

    String mUpdate(TipoDocumentoClasificacionDTO tipoDocumentoClasificacionDTO);
}
