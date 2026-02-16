package com.genoma.plus.dao.rrhh;

import com.genoma.plus.dto.rrhh.PresupuestoDetalleDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/rrhh/PresupuestoDetalleDAO.class */
public interface PresupuestoDetalleDAO {
    List<PresupuestoDetalleDTO> listaPresupuestoDetalle(int i);

    String crearPresupuestoDetalle(PresupuestoDetalleDTO presupuestoDetalleDTO);

    String updatePresupuestoDetalle(PresupuestoDetalleDTO presupuestoDetalleDTO);
}
