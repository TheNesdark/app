package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeReportePadresEncabezadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeReportePadresEncabezadoDAO.class */
public interface ValeReportePadresEncabezadoDAO {
    List<Object[]> listaReportePadresEncabezado(int i);

    int create(ValeReportePadresEncabezadoDTO valeReportePadresEncabezadoDTO);

    void update(ValeReportePadresEncabezadoDTO valeReportePadresEncabezadoDTO);
}
