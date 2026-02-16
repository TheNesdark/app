package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeCondicionesEstructuralesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeCondicionesEstructuralesDAO.class */
public interface ValeCondicionesEstructuralesDAO {
    List<Object[]> listaValeCondicionesEstructurales(int i);

    String mCreate(ValeCondicionesEstructuralesDTO valeCondicionesEstructuralesDTO);

    String mUpdate(ValeCondicionesEstructuralesDTO valeCondicionesEstructuralesDTO);
}
