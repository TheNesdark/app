package com.genoma.plus.dao.laboratorio;

import com.genoma.plus.dto.laboratorio.ProtocolosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/ProtocolosDAO.class */
public interface ProtocolosDAO {
    ProtocolosDTO findById(Long l);

    List<ProtocolosDTO> listProtocolos(boolean z, String str);

    String mcreate_return_id(ProtocolosDTO protocolosDTO);

    String mUpdate(ProtocolosDTO protocolosDTO);
}
