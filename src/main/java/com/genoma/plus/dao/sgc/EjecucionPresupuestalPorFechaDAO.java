package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.EjecucionPresupuestalPorFechaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/EjecucionPresupuestalPorFechaDAO.class */
public interface EjecucionPresupuestalPorFechaDAO {
    List<Object[]> mEjecusionPresupuestal(EjecucionPresupuestalPorFechaDTO ejecucionPresupuestalPorFechaDTO);

    List<Object[]> mCargarCombo(EjecucionPresupuestalPorFechaDTO ejecucionPresupuestalPorFechaDTO);
}
