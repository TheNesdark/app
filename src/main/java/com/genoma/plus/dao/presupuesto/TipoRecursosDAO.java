package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.TipoRecursosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/TipoRecursosDAO.class */
public interface TipoRecursosDAO {
    List<Object[]> listaTipoRecursos();

    String mCreate(TipoRecursosDTO tipoRecursosDTO);

    String mUpdate(TipoRecursosDTO tipoRecursosDTO);
}
