package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.Planificacion_Familias_AIC_clinica_pajonalDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/Planificacion_Familias_AIC_clinica_pajonalDAO.class */
public interface Planificacion_Familias_AIC_clinica_pajonalDAO {
    List<Object[]> mBuscarPlanificacionFamiliar(Planificacion_Familias_AIC_clinica_pajonalDTO planificacion_Familias_AIC_clinica_pajonalDTO, Boolean bool);

    List<Object[]> mCargarCombo();
}
