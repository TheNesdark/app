package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.TipoVigenciaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/TipoVigenciaDAO.class */
public interface TipoVigenciaDAO {
    List<Object[]> listaTipoVigencia();

    String mCreate(TipoVigenciaDTO tipoVigenciaDTO);

    String mUpdate(TipoVigenciaDTO tipoVigenciaDTO);
}
