package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.ParametrizacionCGRDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/ParametrizacionCGRDAO.class */
public interface ParametrizacionCGRDAO {
    List<Object[]> listaParametrizacionCGR(String str, String str2);

    String mCreate(ParametrizacionCGRDTO parametrizacionCGRDTO);

    String mUpdate(ParametrizacionCGRDTO parametrizacionCGRDTO);

    List<Object[]> listaCombo(String str);
}
