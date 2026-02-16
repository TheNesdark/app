package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoDocumentoFiltroSoporteDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoDocumentoFiltroSoporteDAO.class */
public interface TipoDocumentoFiltroSoporteDAO {
    List<TipoDocumentoFiltroSoporteDTO> list();

    List<GCGenericoDTO> listaSoporte();

    String create(TipoDocumentoFiltroSoporteDTO tipoDocumentoFiltroSoporteDTO);

    String update(TipoDocumentoFiltroSoporteDTO tipoDocumentoFiltroSoporteDTO);

    String delete(TipoDocumentoFiltroSoporteDTO tipoDocumentoFiltroSoporteDTO);
}
