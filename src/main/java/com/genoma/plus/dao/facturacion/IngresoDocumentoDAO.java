package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.IngresoDocumentoDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/IngresoDocumentoDAO.class */
public interface IngresoDocumentoDAO {
    List<IngresoDocumentoDTO> mListar(Long l);

    List<GCGenericoDTO> mTipoDocumento();

    String create_return_id(IngresoDocumentoDTO ingresoDocumentoDTO);

    String mUpdateRuta(IngresoDocumentoDTO ingresoDocumentoDTO);

    String mUpdate(IngresoDocumentoDTO ingresoDocumentoDTO);

    String mDelete(IngresoDocumentoDTO ingresoDocumentoDTO);
}
