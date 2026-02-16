package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeEstructurasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeEstructurasDAO.class */
public interface ValeEstructurasDAO {
    List<Object[]> listaValeEstructuras();

    String mCreate(ValeEstructurasDTO valeEstructurasDTO);

    String mUpdate(ValeEstructurasDTO valeEstructurasDTO);
}
