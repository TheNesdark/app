package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.AntecedenteFamiliarTextoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AntecedenteFamiliarTextoDAO.class */
public interface AntecedenteFamiliarTextoDAO {
    List<AntecedenteFamiliarTextoDTO> antecedenteFamiliarTextoDTO(Long l);

    Long crear(AntecedenteFamiliarTextoDTO antecedenteFamiliarTextoDTO);

    void actualizar(String str, AntecedenteFamiliarTextoDTO antecedenteFamiliarTextoDTO);
}
