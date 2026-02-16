package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.OrigenIngresoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/OrigenIngresoDAO.class */
public interface OrigenIngresoDAO {
    List<Object[]> listaOrigenIngreso();

    String mCreate(OrigenIngresoDTO origenIngresoDTO);

    String mUpdate(OrigenIngresoDTO origenIngresoDTO);

    List<Object[]> listaFiltro(String str, String str2);
}
