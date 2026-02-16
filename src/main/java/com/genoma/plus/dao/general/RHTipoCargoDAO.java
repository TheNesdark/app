package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.RHTipoCargoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/RHTipoCargoDAO.class */
public interface RHTipoCargoDAO {
    List<RHTipoCargoDTO> list();

    String mCreate(RHTipoCargoDTO rHTipoCargoDTO);

    String mUpdate(RHTipoCargoDTO rHTipoCargoDTO);
}
