package com.genoma.plus.dao.sig;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/ConsultaInformacionCronicosDAO.class */
public interface ConsultaInformacionCronicosDAO {
    List<Object[]> listaConvenios(String str, String str2);

    void mEliminarDatosTabla();

    void EjecutarConsultas(String str, String str2, String str3, String str4, Long l);

    List<Object[]> listaConsultasSql();

    List<Object[]> listaAtencionesEspecialidad(String str, String str2, String str3, String str4);

    List<Object[]> listaResultadoExamenProtocoloOrdenASC(String str, String str2, String str3, String str4, String str5);

    List<Object[]> listaResultadoExamenProtocoloOrdenDES(String str, String str2, String str3, String str4, String str5);

    List<Object[]> listaUltimaFechaRelizacionProcedimiento(String str, String str2, String str3, String str4);

    List<Object[]> listaUltimaEntregaMedicamentosInventario(String str, String str2, String str3);

    List<Object[]> listaUltimaFormulacionMedicamentosHistoria(String str, String str2, String str3);

    void actualizarVariableenTabla(String str, String str2, String str3);

    List<Object[]> listaDatos();
}
