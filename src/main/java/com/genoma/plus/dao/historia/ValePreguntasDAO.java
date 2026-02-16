package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValePreguntasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValePreguntasDAO.class */
public interface ValePreguntasDAO {
    List<Object[]> listaValePreguntas();

    String mCreate(ValePreguntasDTO valePreguntasDTO);

    String mUpdate(ValePreguntasDTO valePreguntasDTO);

    String edad(String str, String str2);
}
