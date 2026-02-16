package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeRangoEdadDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeRangoEdadDAO.class */
public interface ValeRangoEdadDAO {
    List<Object[]> listaValeRangoEdad();

    int traerRango(String str, String str2);

    String mCreate(ValeRangoEdadDTO valeRangoEdadDTO);

    String mUpdate(ValeRangoEdadDTO valeRangoEdadDTO);
}
