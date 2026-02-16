package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.DepresionPospartoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/DepresionPospartoDAO.class */
public interface DepresionPospartoDAO {
    List<DepresionPospartoDTO> listDeprecion(String str);

    String create_return_id(DepresionPospartoDTO depresionPospartoDTO);
}
