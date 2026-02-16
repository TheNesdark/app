package com.genoma.plus.dao.salud_ocupacional;

import com.genoma.plus.dto.salud_ocupacional.SOTipoSegmentoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/salud_ocupacional/SOTipoSegmentoDAO.class */
public interface SOTipoSegmentoDAO {
    List<Object[]> listaTSegmentos();

    String mCreate(SOTipoSegmentoDTO sOTipoSegmentoDTO);

    String mUpdate(SOTipoSegmentoDTO sOTipoSegmentoDTO);

    List<Object[]> listaCombo(String str);
}
