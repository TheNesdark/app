package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.TipoSituacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/TipoSituacionDAO.class */
public interface TipoSituacionDAO {
    List<Object[]> listaTipoSituacion();

    String mCreate(TipoSituacionDTO tipoSituacionDTO);

    String mUpdate(TipoSituacionDTO tipoSituacionDTO);
}
