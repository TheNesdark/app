package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ConfiguracionItemsxTipoHistoriaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ConfiguracionItemsxTipoHistoriaDAO.class */
public interface ConfiguracionItemsxTipoHistoriaDAO {
    List<Object[]> mListar(String str, String str2);

    List<GCGenericoDTO> listaTipoHistoria();

    String mCreate(ConfiguracionItemsxTipoHistoriaDTO configuracionItemsxTipoHistoriaDTO);

    String mUpdate(ConfiguracionItemsxTipoHistoriaDTO configuracionItemsxTipoHistoriaDTO);
}
