package com.genoma.plus.dao.contabilidad;

import com.genoma.plus.dto.contabilidad.CTipoDocumentoDTO;
import com.genoma.plus.dto.contabilidad.ListadoRadicacionFacturaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/contabilidad/ContabilidadDAO.class */
public interface ContabilidadDAO {
    List<CTipoDocumentoDTO> listTipoDocContable();

    List<CTipoDocumentoDTO> listTipoDocContableId(String str);

    Long addDocContableEncabezado(String str, String str2, Long l, String str3, Integer num, Long l2);

    String addDocContableDetalle(Long l, String str, Integer num, Long l2, String str2, String str3, Double d, Double d2, String str4);

    List<ListadoRadicacionFacturaDTO> listRadicacionFactura(Integer num);

    void updateEstadoGlobal_DocContable(String str);

    Long mConsultarConsecutivo(String str);

    List<Object[]> facturaPorPagar(String str, String str2);

    List<Object[]> facturaPorPagarIdTercero(String str);

    List<Object[]> listadoPeriodoContable(String str, Integer num);

    List<Object[]> obtenerNumeroDeFacturaMYPrefijo(String str);
}
