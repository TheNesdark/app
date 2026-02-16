package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.EntornoFamiliarDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/EntornoFamiliarDAO.class */
public interface EntornoFamiliarDAO {
    List<EntornoFamiliarDTO> listadoEntorno();

    String mCrear(EntornoFamiliarDTO entornoFamiliarDTO);

    String mUpdate(EntornoFamiliarDTO entornoFamiliarDTO);
}
