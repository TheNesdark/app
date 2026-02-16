package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.CuestionarioHaqDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/CuestionarioHaqDAO.class */
public interface CuestionarioHaqDAO {
    String mCreate(CuestionarioHaqDTO cuestionarioHaqDTO);

    List<CuestionarioHaqDTO> listCuestionarioHAQ(Long l);
}
