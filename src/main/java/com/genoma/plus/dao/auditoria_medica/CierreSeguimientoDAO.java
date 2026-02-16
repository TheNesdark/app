package com.genoma.plus.dao.auditoria_medica;

import com.genoma.plus.dto.auditoria_medica.CierreSeguimientoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/auditoria_medica/CierreSeguimientoDAO.class */
public interface CierreSeguimientoDAO {
    String create(CierreSeguimientoDTO cierreSeguimientoDTO);

    List<CierreSeguimientoDTO> listCierreSeguiento(Long l);
}
