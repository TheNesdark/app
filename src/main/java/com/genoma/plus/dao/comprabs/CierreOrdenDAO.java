package com.genoma.plus.dao.comprabs;

import com.genoma.plus.dto.comprabs.CierreOrdenDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/comprabs/CierreOrdenDAO.class */
public interface CierreOrdenDAO {
    List<CierreOrdenDTO> list(String str);

    String create(CierreOrdenDTO cierreOrdenDTO);

    String delete(CierreOrdenDTO cierreOrdenDTO);
}
