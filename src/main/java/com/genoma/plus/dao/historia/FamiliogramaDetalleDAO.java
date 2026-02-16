package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.FamiliogramaDetalleDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/FamiliogramaDetalleDAO.class */
public interface FamiliogramaDetalleDAO {
    List<Object[]> lisdatoFDetalle(int i);

    int mCreate(FamiliogramaDetalleDTO familiogramaDetalleDTO);

    String mUpdate(FamiliogramaDetalleDTO familiogramaDetalleDTO);

    List<Object[]> TraerIds(String str);

    List<Object[]> traerfamilia(int i);

    List<Object[]> DatosPaciente(long j);

    String anularDetalle(int i);
}
