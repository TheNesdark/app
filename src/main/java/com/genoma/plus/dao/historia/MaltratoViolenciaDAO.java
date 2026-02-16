package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.MaltratoViolenciaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/MaltratoViolenciaDAO.class */
public interface MaltratoViolenciaDAO {
    List<MaltratoViolenciaDTO> listMaltrato(String str);

    String create_return_id(MaltratoViolenciaDTO maltratoViolenciaDTO);
}
