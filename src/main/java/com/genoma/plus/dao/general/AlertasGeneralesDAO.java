package com.genoma.plus.dao.general;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/AlertasGeneralesDAO.class */
public interface AlertasGeneralesDAO {
    List<Object[]> numeroSeguimientoAuditoriaPendientes(Long l);

    Integer numeroAccionesFicha5w1h(Long l);

    Integer numeroEncuestasPendientes(Long l);

    List<Object[]> listaEncuestaporUsuario(Long l);

    List<Object[]> mensajeInformacionTopeUvtTercero(String str, Long l, Double d, Integer num);

    Double consultarValorUvr(String str);

    Boolean verificarUsuarioCajero(Long l);

    Boolean verificarUsuarioBodega(Long l);

    Integer numeroSolicitudesPorAutorizar(Long l);

    Long consultarIdEspecialidadUsuarioSistema(Long l);

    List<Object[]> verificarListaContratosPorSeguimiento();

    void grabarLogDocumentosHistoria(String str, String str2, String str3, String str4, String str5);

    List<Object[]> verificarNumeroCitasPorEspecialdiad(Long l);
}
