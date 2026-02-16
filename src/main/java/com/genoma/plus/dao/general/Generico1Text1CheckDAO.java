package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.Generico1Text1CheckDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/Generico1Text1CheckDAO.class */
public interface Generico1Text1CheckDAO {
    List<Generico1Text1CheckDTO> list(String str);

    String create(Generico1Text1CheckDTO generico1Text1CheckDTO, String str);

    String update(Generico1Text1CheckDTO generico1Text1CheckDTO, String str);

    String delete(Generico1Text1CheckDTO generico1Text1CheckDTO, String str);
}
