package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.RutaSoporteDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/RutaSoporteDAO.class */
public interface RutaSoporteDAO {
    List<RutaSoporteDTO> list();

    String update(RutaSoporteDTO rutaSoporteDTO);
}
