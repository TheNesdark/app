package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.GrupoExamenFisicoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/GrupoExamenFisicoDAO.class */
public interface GrupoExamenFisicoDAO {
    List<GrupoExamenFisicoDTO> listExamenesFisicos();

    String mCreate(GrupoExamenFisicoDTO grupoExamenFisicoDTO);

    String mUpdate(GrupoExamenFisicoDTO grupoExamenFisicoDTO);
}
