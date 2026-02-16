package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.general.TipoConcentimientoDTO;
import com.genoma.plus.dto.sgc.ConsentimientoInformadoDTO;
import com.genoma.plus.dto.sgc.ConsentimientoInfxRiesgoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/ConsentimientoInformadoDAO.class */
public interface ConsentimientoInformadoDAO {
    List<ConsentimientoInformadoDTO> listConcentimientoInf(String str);

    List<ConsentimientoInfxRiesgoDTO> listConsentimientoDetalle(String str, String str2);

    List<TipoConcentimientoDTO> listTipoConsentimmiento();

    String create_return_id(ConsentimientoInformadoDTO consentimientoInformadoDTO);

    String mUpdateConcentimientoInf(ConsentimientoInformadoDTO consentimientoInformadoDTO);

    String mCreateConcentimientoxRiesgo(ConsentimientoInfxRiesgoDTO consentimientoInfxRiesgoDTO);
}
