package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.ClasificacionNotasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ClasificacionNotasDAO.class */
public interface ClasificacionNotasDAO {
    List<ClasificacionNotasDTO> list();

    String mCreate(ClasificacionNotasDTO clasificacionNotasDTO);

    String mUpdate(ClasificacionNotasDTO clasificacionNotasDTO);
}
