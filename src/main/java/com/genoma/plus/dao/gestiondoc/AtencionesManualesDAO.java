package com.genoma.plus.dao.gestiondoc;

import com.genoma.plus.dto.gestiondoc.AtencionesManualesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/gestiondoc/AtencionesManualesDAO.class */
public interface AtencionesManualesDAO {
    String mCreate(AtencionesManualesDTO atencionesManualesDTO);

    String mUpdate(AtencionesManualesDTO atencionesManualesDTO);

    List<Object[]> validacion(String str);
}
