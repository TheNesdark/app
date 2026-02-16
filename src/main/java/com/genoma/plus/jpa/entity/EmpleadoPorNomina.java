package com.genoma.plus.jpa.entity;

import java.util.Date;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/EmpleadoPorNomina.class */
public interface EmpleadoPorNomina {
    String getFecha();

    Integer getIdLiquidacion();

    Integer getIdPersona();

    String getNoDocumento();

    String getEmpleado();

    String getFechaIngreso();

    Integer getTiempoLaborado();

    Integer getIdPeriodo();

    String getConsecutivo();

    String getCune();

    String getkeyDian();

    Double getValorTotalNomina();

    String getCorreoElectronico();

    Date getFechaPago();
}
