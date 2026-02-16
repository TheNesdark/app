package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.Generico2Text1CheckDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/Generico2Text1CheckDAO.class */
public interface Generico2Text1CheckDAO {
    List<Generico2Text1CheckDTO> mListar(String str);

    String create(Generico2Text1CheckDTO generico2Text1CheckDTO, String str);

    String update(Generico2Text1CheckDTO generico2Text1CheckDTO, String str);
}
