package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.Generico1Combo1CheckDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/Generico1Combo1CheckDAO.class */
public interface Generico1Combo1CheckDAO {
    List<Generico1Combo1CheckDTO> list(String str);

    List<GCGenericoDTO> listComboGenerico(String str);

    List<GCGenericoDTO> listComboGenericoConIdString(String str);

    String mCreate(Generico1Combo1CheckDTO generico1Combo1CheckDTO, String str);

    String mUpdate(Generico1Combo1CheckDTO generico1Combo1CheckDTO, String str);
}
