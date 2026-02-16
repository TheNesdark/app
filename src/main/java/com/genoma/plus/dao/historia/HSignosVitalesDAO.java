package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.HSignosVitalesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/HSignosVitalesDAO.class */
public interface HSignosVitalesDAO {
    Long mCrear(HSignosVitalesDTO hSignosVitalesDTO);

    List<HSignosVitalesDTO> listSignosVitalesIdNota(String str);
}
