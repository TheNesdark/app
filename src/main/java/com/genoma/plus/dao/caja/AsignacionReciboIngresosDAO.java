package com.genoma.plus.dao.caja;

import com.genoma.plus.dto.caja.AsignacionReciboIngresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/caja/AsignacionReciboIngresosDAO.class */
public interface AsignacionReciboIngresosDAO {
    List<AsignacionReciboIngresosDTO> ListRecibosUsuario(String str);

    List<GCGenericoDTO> listaComboIngresos(String str);

    String updateReciboxIngreso(AsignacionReciboIngresosDTO asignacionReciboIngresosDTO);
}
