package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.BuscarConceptoNominaxVFijoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/BuscarConceptoNominaxVFijoDAO.class */
public interface BuscarConceptoNominaxVFijoDAO {
    List<BuscarConceptoNominaxVFijoDTO> list(String str, String str2);

    List<GCGenericoDTO> listTerceros();

    String create(BuscarConceptoNominaxVFijoDTO buscarConceptoNominaxVFijoDTO);
}
