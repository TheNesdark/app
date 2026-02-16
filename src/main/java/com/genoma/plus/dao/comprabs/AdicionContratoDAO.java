package com.genoma.plus.dao.comprabs;

import com.genoma.plus.dto.comprabs.AdicionContratoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/comprabs/AdicionContratoDAO.class */
public interface AdicionContratoDAO {
    List<AdicionContratoDTO> list(String str);

    String create(AdicionContratoDTO adicionContratoDTO);

    String update(AdicionContratoDTO adicionContratoDTO);

    String delete(AdicionContratoDTO adicionContratoDTO);
}
