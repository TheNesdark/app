package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.CuestionarioDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/CuestionarioDAO.class */
public interface CuestionarioDAO {
    Long mCrear(CuestionarioDTO cuestionarioDTO);

    CuestionarioDTO mCuestionarioIdAtencion(Long l);

    List<Object[]> mListCuestionario(String str, int i, int i2);

    List<Object[]> mListCuestionarioSmoking(String str, int i, int i2);

    List<Object[]> mResultadoPorItems(int i, double d);

    List<Object[]> mListHistoricoCuestionario(String str, int i, String str2);
}
