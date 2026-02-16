package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.TipoHistoriaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/TipoHistoriaDAO.class */
public interface TipoHistoriaDAO {
    List<Object[]> listaTHistoria();

    String mCreate(TipoHistoriaDTO tipoHistoriaDTO);

    String mUpdate(TipoHistoriaDTO tipoHistoriaDTO);
}
