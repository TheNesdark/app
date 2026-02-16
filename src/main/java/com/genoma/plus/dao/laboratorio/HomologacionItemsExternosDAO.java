package com.genoma.plus.dao.laboratorio;

import com.genoma.plus.dto.laboratorio.HomologacionItemsExternosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/HomologacionItemsExternosDAO.class */
public interface HomologacionItemsExternosDAO {
    List<HomologacionItemsExternosDTO> listaItemsExternos();

    String create(HomologacionItemsExternosDTO homologacionItemsExternosDTO);

    String update(HomologacionItemsExternosDTO homologacionItemsExternosDTO);
}
