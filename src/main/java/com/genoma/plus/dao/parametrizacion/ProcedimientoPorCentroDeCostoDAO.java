package com.genoma.plus.dao.parametrizacion;

import com.genoma.plus.dto.parametrizacion.ProcedimientoPorCentroDeCostoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/parametrizacion/ProcedimientoPorCentroDeCostoDAO.class */
public interface ProcedimientoPorCentroDeCostoDAO {
    List<Object[]> listProcedimientoPorCentroCosto(String str);

    List<Object[]> listProcedimientoEnCentroCosto(String str, String str2);

    List<Object[]> listCentroDeCosto();

    void addProcedimientoPorCentroCosto(ProcedimientoPorCentroDeCostoDTO procedimientoPorCentroDeCostoDTO);

    void updateProcedimientoPorCentroCosto(ProcedimientoPorCentroDeCostoDTO procedimientoPorCentroDeCostoDTO);
}
