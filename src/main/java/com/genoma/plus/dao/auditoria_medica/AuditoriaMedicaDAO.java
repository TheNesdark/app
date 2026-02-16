package com.genoma.plus.dao.auditoria_medica;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/auditoria_medica/AuditoriaMedicaDAO.class */
public interface AuditoriaMedicaDAO {
    List<Object[]> listaIngresosTipoAtencion(String str, String str2, String str3);

    List<Object[]> listaSeguimientosUsuario(String str, String str2, String str3);

    List<Object[]> listaFacturaAuditoria(String str, String str2, String str3, String str4, String str5);

    List<Object[]> listaAuditoriAdministracion(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool);

    List<Object[]> listaSeguimiento_Para_Cierre(String str, String str2, String str3);

    List<Object[]> listaInformeSeguimientos(String str, String str2, String str3);

    List<Object[]> listaServiciosFiltradosUsuario(String str, String str2);

    List<Object[]> listaServiciosFiltradoPorCierresDeSeguimiento(String str, String str2);

    List<Object[]> listaServiciosFiltradoFactura(String str, String str2, String str3, String str4);

    List<Object[]> listaServiciosFiltradoPorIngreso(String str, String str2);

    List<Object[]> listaServiciosFiltradoParaAuditoria(String str, String str2, String str3, String str4, String str5, String str6);
}
