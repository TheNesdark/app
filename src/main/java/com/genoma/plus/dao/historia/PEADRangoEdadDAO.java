package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADRangoEdadDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADRangoEdadDAO.class */
public interface PEADRangoEdadDAO {
    List<PEADRangoEdadDTO> listaRangoEdad();

    String mCreate(PEADRangoEdadDTO pEADRangoEdadDTO);

    String mUpdate(PEADRangoEdadDTO pEADRangoEdadDTO);
}
