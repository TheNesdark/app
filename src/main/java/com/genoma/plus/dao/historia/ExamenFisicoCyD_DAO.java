package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ExamenFisicoCyD_DTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ExamenFisicoCyD_DAO.class */
public interface ExamenFisicoCyD_DAO {
    List<ExamenFisicoCyD_DTO> listaDetalleExamenFisico(int i, String str);

    List<Object[]> listaGraficasGuardadas_IdUsuarioPrograma(long j);
}
