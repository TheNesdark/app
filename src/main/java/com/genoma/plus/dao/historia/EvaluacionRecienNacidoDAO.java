package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.EvaluacionRecienNacidoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/EvaluacionRecienNacidoDAO.class */
public interface EvaluacionRecienNacidoDAO {
    List<EvaluacionRecienNacidoDTO> listaEvaluacionRecienNacido(String str);

    String create(EvaluacionRecienNacidoDTO evaluacionRecienNacidoDTO);

    String update(EvaluacionRecienNacidoDTO evaluacionRecienNacidoDTO);
}
