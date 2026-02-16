package com.genoma.plus.dao.integracion_simedis;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/integracion_simedis/IntegracionExternaDAO.class */
public interface IntegracionExternaDAO {
    List<Object[]> listadoProcedimientoItems(String str, Integer num);

    List<Object[]> listadoProcedimientoItemsSifas(String str, String str2);

    List<Object[]> listadoProcedimientoItemsDinamica(String str);

    List<Object[]> listadoProcedimientoItemsGIIS(String str);

    List<Object[]> listadoProcedimientoItemsCNT(String str, String str2, String str3, String str4);

    List<Object[]> listadoProcedimientoHomologadosCNT(String str);

    List<Object[]> listadoProcedimientoItemsBS1(String str);

    List<Object[]> listadoProcedimientoEncabezadoBS1(String str);

    List<Object[]> listadoProcedimientoItemsColgenes(String str);

    List<Object[]> listadoProcedimientoItemsXenco(String str);

    void insertEmcabezadoOrdenBs1(String str, String str2, String str3, String str4, String str5);
}
