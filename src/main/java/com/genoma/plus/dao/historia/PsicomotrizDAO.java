package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PsicomotrizDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PsicomotrizDAO.class */
public interface PsicomotrizDAO {
    List<PsicomotrizDTO> listPsicomotriz(String str);

    String create_return_id(PsicomotrizDTO psicomotrizDTO);
}
