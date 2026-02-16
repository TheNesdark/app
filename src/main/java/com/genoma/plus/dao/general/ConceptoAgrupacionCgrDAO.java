package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.ConceptoAgrupacionCgrDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ConceptoAgrupacionCgrDAO.class */
public interface ConceptoAgrupacionCgrDAO {
    List<ConceptoAgrupacionCgrDTO> list();

    String create(ConceptoAgrupacionCgrDTO conceptoAgrupacionCgrDTO);

    String update(ConceptoAgrupacionCgrDTO conceptoAgrupacionCgrDTO);

    String delete(ConceptoAgrupacionCgrDTO conceptoAgrupacionCgrDTO);
}
