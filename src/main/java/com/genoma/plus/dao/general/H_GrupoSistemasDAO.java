package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.H_GrupoSistemasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/H_GrupoSistemasDAO.class */
public interface H_GrupoSistemasDAO {
    List<H_GrupoSistemasDTO> listGrupoSistemas();

    String mCreate(H_GrupoSistemasDTO h_GrupoSistemasDTO);

    String mUpdate(H_GrupoSistemasDTO h_GrupoSistemasDTO);
}
