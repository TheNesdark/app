package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoDocumentoSoporteDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoDocumentoSoporteDAO.class */
public interface TipoDocumentoSoporteDAO {
    List<TipoDocumentoSoporteDTO> list();

    List<TipoDocumentoSoporteDTO> listaFiltradaTipo(Integer num);

    String create(TipoDocumentoSoporteDTO tipoDocumentoSoporteDTO);

    String update(TipoDocumentoSoporteDTO tipoDocumentoSoporteDTO);

    String delete(TipoDocumentoSoporteDTO tipoDocumentoSoporteDTO);
}
