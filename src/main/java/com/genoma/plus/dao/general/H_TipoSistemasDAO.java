package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.H_TipoSistemasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/H_TipoSistemasDAO.class */
public interface H_TipoSistemasDAO {
    List<Object[]> listTipoSistemas();

    String mCreate(H_TipoSistemasDTO h_TipoSistemasDTO);

    String mUpdate(H_TipoSistemasDTO h_TipoSistemasDTO);
}
