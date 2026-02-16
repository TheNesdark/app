package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ClasificacionEularDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ClasificacionEularDAO.class */
public interface ClasificacionEularDAO {
    String mCreate(ClasificacionEularDTO clasificacionEularDTO);

    List<ClasificacionEularDTO> listClasificacionEular(Long l);
}
