package com.genoma.plus.dao.pyp;

import com.genoma.plus.dto.pyp.ItemProcedimientoSeguimientoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/pyp/ItemProcedimientoSeguimientoDAO.class */
public interface ItemProcedimientoSeguimientoDAO {
    String createSeguimiento(ItemProcedimientoSeguimientoDTO itemProcedimientoSeguimientoDTO);

    List<Object[]> listaSeguimientoItems(Long l);
}
