package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.GlasgowAntencionDTO;
import com.genoma.plus.dto.historia.GlasgowAtencionDetalleDTO;
import com.genoma.plus.dto.historia.GlasgowItemsDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/GlasgowDAO.class */
public interface GlasgowDAO {
    Long guardaAntencion(GlasgowAntencionDTO glasgowAntencionDTO);

    void guardaDetalle(GlasgowAtencionDetalleDTO glasgowAtencionDetalleDTO);

    List<Object[]> getHistorico(int i);

    List<GlasgowItemsDTO> getGlasgowItems();
}
