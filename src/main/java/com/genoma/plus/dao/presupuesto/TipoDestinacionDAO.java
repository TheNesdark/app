package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.TipoDestinacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/TipoDestinacionDAO.class */
public interface TipoDestinacionDAO {
    List<Object[]> listaTipoDestinacion();

    String mCreate(TipoDestinacionDTO tipoDestinacionDTO);

    String mUpdate(TipoDestinacionDTO tipoDestinacionDTO);
}
