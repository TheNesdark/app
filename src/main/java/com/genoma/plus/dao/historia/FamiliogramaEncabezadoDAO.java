package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.FamiliogramaEncabezadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/FamiliogramaEncabezadoDAO.class */
public interface FamiliogramaEncabezadoDAO {
    List<FamiliogramaEncabezadoDTO> ListadoFEncabezado(int i);

    int mCreate(FamiliogramaEncabezadoDTO familiogramaEncabezadoDTO);

    String mUpdate(FamiliogramaEncabezadoDTO familiogramaEncabezadoDTO);

    List<Object[]> traerFamiliogramas(long j);

    List<Object[]> datosHC(String str);
}
