package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ConfiguracionItemsDAO.class */
public interface ConfiguracionItemsDAO {
    List<Object[]> listConfiguracionItems(String str);

    List<GCGenericoDTO> listCarpetaPadre();

    String mCreate(ConfiguracionItems configuracionItems);

    String mUpdate(ConfiguracionItems configuracionItems);
}
