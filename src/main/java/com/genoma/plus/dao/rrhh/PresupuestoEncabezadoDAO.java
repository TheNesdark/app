package com.genoma.plus.dao.rrhh;

import com.genoma.plus.dto.rrhh.PresupuestoEncabezadoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/rrhh/PresupuestoEncabezadoDAO.class */
public interface PresupuestoEncabezadoDAO {
    List<PresupuestoEncabezadoDTO> obtenerMovimiento(int i);

    int crearEncabezado(PresupuestoEncabezadoDTO presupuestoEncabezadoDTO);

    String updateEncabezado(PresupuestoEncabezadoDTO presupuestoEncabezadoDTO);

    String actualizarCompromiso(int i, int i2);

    int consultarDisponibilidadDeNominaDelCompromiso(int i);
}
