package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.K_FormaPagoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/K_FormaPagoDAO.class */
public interface K_FormaPagoDAO {
    List<K_FormaPagoDTO> mListar();

    List<GCGenericoDTO> mVerificarCuenta(String str);

    String mCreate(K_FormaPagoDTO k_FormaPagoDTO);

    String mUpdate(K_FormaPagoDTO k_FormaPagoDTO);
}
