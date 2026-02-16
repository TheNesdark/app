package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoEventoSCDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoEventoSCDAO.class */
public interface TipoEventoSCDAO {
    List<TipoEventoSCDTO> list(String str);

    List<GCGenericoDTO> listaTCategoria();

    String create(TipoEventoSCDTO tipoEventoSCDTO);

    String update(TipoEventoSCDTO tipoEventoSCDTO);
}
