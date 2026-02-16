package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.EntidadesContraloriaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/EntidadesContraloriaDAO.class */
public interface EntidadesContraloriaDAO {
    List<Object[]> listaEntidadesContraloria();

    String mCreate(EntidadesContraloriaDTO entidadesContraloriaDTO);

    String mUpdate(EntidadesContraloriaDTO entidadesContraloriaDTO);
}
