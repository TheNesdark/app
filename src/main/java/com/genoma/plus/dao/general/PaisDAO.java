package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.PaisDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/PaisDAO.class */
public interface PaisDAO {
    List<PaisDTO> listPais();

    String mCreate(PaisDTO paisDTO);

    String mUpdate(PaisDTO paisDTO);
}
