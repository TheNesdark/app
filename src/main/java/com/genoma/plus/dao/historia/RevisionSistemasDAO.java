package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.RevisionSistemasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/RevisionSistemasDAO.class */
public interface RevisionSistemasDAO {
    List<Object[]> listConfRevisionSistemas(String str, String str2);

    List<Object[]> listRevisionSistemas(String str);

    Long mCrear(RevisionSistemasDTO revisionSistemasDTO);

    void mUpdate(String[] strArr);

    void mCrearObservacion(String str, long j);
}
