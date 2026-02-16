package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.ConsultarNovedadDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/ConsultarNovedadDAO.class */
public interface ConsultarNovedadDAO {
    List<GenericoComboDTO> comboNovedad();

    List<ConsultarNovedadDTO> list(String str, String str2);

    List<ConsultarNovedadDTO> listF(String str, String str2, String str3);
}
