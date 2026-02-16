package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.Generico3Text1CheckDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/Generico3Text1CheckDAO.class */
public interface Generico3Text1CheckDAO {
    List<Generico3Text1CheckDTO> list(String str);

    String create(Generico3Text1CheckDTO generico3Text1CheckDTO, String str);

    String update(Generico3Text1CheckDTO generico3Text1CheckDTO, String str);

    String delete(Generico3Text1CheckDTO generico3Text1CheckDTO, String str);
}
