package com.genoma.plus.dao.contabilidad;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/contabilidad/InformesVariosContabilidadDAO.class */
public interface InformesVariosContabilidadDAO {
    List<Object[]> listadoInformeContraloria(String str, String str2, String str3, String str4, String str5);

    Double valorCuenta(String str, String str2);

    List<Object[]> listadoEstadosFinancieros(String str, String str2, String str3);
}
