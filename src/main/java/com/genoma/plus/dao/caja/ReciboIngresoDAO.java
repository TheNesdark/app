package com.genoma.plus.dao.caja;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/caja/ReciboIngresoDAO.class */
public interface ReciboIngresoDAO {
    void anularRecibo(String str, String str2, String str3, String str4);

    void actualizarDatosReciboCajaIdCierre(String str);

    void anularCierreReciboEgreso(String str, String str2, String str3, String str4);

    void actualizarDatosReciboCajaIdCierreEgreso(String str);
}
