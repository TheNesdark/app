package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.FinalidadGastoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/FinalidadGastoDAO.class */
public interface FinalidadGastoDAO {
    List<Object[]> listaFinalidadGasto();

    String mCreate(FinalidadGastoDTO finalidadGastoDTO);

    String mUpdate(FinalidadGastoDTO finalidadGastoDTO);
}
