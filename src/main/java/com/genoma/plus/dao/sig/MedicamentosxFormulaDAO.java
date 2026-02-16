package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/MedicamentosxFormulaDAO.class */
public interface MedicamentosxFormulaDAO {
    List<Object[]> mListarMedicamentos(String str, String str2);

    List<GenericoComboDTO> mListarTipoFormula();
}
