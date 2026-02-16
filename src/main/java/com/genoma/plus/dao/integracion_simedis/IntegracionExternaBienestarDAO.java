package com.genoma.plus.dao.integracion_simedis;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/integracion_simedis/IntegracionExternaBienestarDAO.class */
public interface IntegracionExternaBienestarDAO {
    List<Object[]> listadoProcedimientoItems(String str, Integer num);

    List<Object[]> listadoProcedimientoItemsDinamica(String str);

    List<Object[]> listadoProcedimientoItemsGIIS(String str);

    List<Object[]> listadoProcedimientoItemsCNT(String str, String str2);

    List<Object[]> listadoProcedimientoHomologadosCNT(String str);

    List<Object[]> listadoProcedimientoItemsBS1(String str);

    List<Object[]> listadoProcedimientoEncabezadoBS1(String str, int i);

    List<Object[]> listadoProcedimientoItemsColgenes(String str);

    List<Object[]> listadoProcedimientosBS1(int i, String str, String str2);

    void insertEmcabezadoOrdenBs1(String str, String str2, String str3, String str4, String str5);

    void actualizarHistoriaBS1(String str);
}
