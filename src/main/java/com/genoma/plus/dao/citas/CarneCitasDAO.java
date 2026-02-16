package com.genoma.plus.dao.citas;

import com.genoma.plus.dto.citas.CarneCitasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/citas/CarneCitasDAO.class */
public interface CarneCitasDAO {
    List<CarneCitasDTO> buscarCitas(String str, String str2);

    List<CarneCitasDTO> buscarCitas(String str, String str2, String str3, List<Integer> list);
}
