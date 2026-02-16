package com.genoma.plus.dao.inventario;

import com.genoma.plus.dto.inventario.InformeSalidasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/inventario/InformeSalidasDAO.class */
public interface InformeSalidasDAO {
    List<Object[]> mCargarTabla(InformeSalidasDTO informeSalidasDTO);

    List<Object[]> mCargarCombo(InformeSalidasDTO informeSalidasDTO);
}
