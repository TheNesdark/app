package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.DetalleContenidoHCDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/DetalleContenidoHCDAO.class */
public interface DetalleContenidoHCDAO {
    List<Object[]> listadoDetalleCHC();

    String mCreate(DetalleContenidoHCDTO detalleContenidoHCDTO);

    String mUpdate(DetalleContenidoHCDTO detalleContenidoHCDTO);
}
