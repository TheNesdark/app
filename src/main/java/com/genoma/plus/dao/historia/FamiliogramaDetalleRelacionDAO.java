package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.FamiliogramaDetalleRelacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/FamiliogramaDetalleRelacionDAO.class */
public interface FamiliogramaDetalleRelacionDAO {
    List<Object[]> listadoDRelacion(int i);

    String mCreate(FamiliogramaDetalleRelacionDTO familiogramaDetalleRelacionDTO);

    String mUpdate(FamiliogramaDetalleRelacionDTO familiogramaDetalleRelacionDTO);

    String mAnularDetalle(int i);
}
