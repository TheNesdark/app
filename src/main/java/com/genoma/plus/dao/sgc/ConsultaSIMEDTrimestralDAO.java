package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.ConsultaSIMEDTrimestralDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/ConsultaSIMEDTrimestralDAO.class */
public interface ConsultaSIMEDTrimestralDAO {
    List<Object[]> mBuscarComprasPorPeriodo(ConsultaSIMEDTrimestralDTO consultaSIMEDTrimestralDTO);

    List<Object[]> mBuscarIps();
}
