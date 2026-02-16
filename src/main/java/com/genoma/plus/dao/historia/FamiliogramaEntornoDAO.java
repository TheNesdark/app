package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.FamiliogramaEntornoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/FamiliogramaEntornoDAO.class */
public interface FamiliogramaEntornoDAO {
    List<Object[]> listadoFEntorno(int i);

    String mCreate(FamiliogramaEntornoDTO familiogramaEntornoDTO);

    String mUpdate(FamiliogramaEntornoDTO familiogramaEntornoDTO);
}
