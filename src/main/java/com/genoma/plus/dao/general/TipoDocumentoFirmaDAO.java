package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoDocumentoFirmaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoDocumentoFirmaDAO.class */
public interface TipoDocumentoFirmaDAO {
    List<TipoDocumentoFirmaDTO> list();

    String create(TipoDocumentoFirmaDTO tipoDocumentoFirmaDTO);

    String update(TipoDocumentoFirmaDTO tipoDocumentoFirmaDTO);

    String delete(TipoDocumentoFirmaDTO tipoDocumentoFirmaDTO);
}
