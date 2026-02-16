package com.genoma.plus.dao.enfermeria;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/enfermeria/AplicacionTratamientoDAO.class */
public interface AplicacionTratamientoDAO {
    List<Object[]> detalleUnidosisAplicar(String str);

    Long cantidadAplicadaUnidosis(String str, String str2);

    List<Object[]> ordenUnidosisPacienteIdAtencion(String str);
}
