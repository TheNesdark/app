package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.MedicamentosEntregadosPorEPSDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/MedicamentosEntregadosPorEPSDAO.class */
public interface MedicamentosEntregadosPorEPSDAO {
    List<Object[]> medicamentosEntregadosPorEPS(MedicamentosEntregadosPorEPSDTO medicamentosEntregadosPorEPSDTO);

    List<Object[]> listarEPS(MedicamentosEntregadosPorEPSDTO medicamentosEntregadosPorEPSDTO);
}
