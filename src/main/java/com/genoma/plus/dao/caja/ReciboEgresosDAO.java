package com.genoma.plus.dao.caja;

import com.genoma.plus.dto.caja.ReciboEgresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/caja/ReciboEgresosDAO.class */
public interface ReciboEgresosDAO {
    List<ReciboEgresosDTO> listaHistoricoReciboEgresos(String str, String str2, String str3, int i);

    List<ReciboEgresosDTO> listaReciboEgresos(String str);

    List<GCGenericoDTO> listaConceptos(int i);

    List<GCGenericoDTO> listaTerceros();

    String create_return_id(ReciboEgresosDTO reciboEgresosDTO);

    String createDetalleRecibo(ReciboEgresosDTO reciboEgresosDTO);

    void anularRecibo(String str, String str2, String str3, Long l);

    Integer validarNumeroFactura(Long l, String str);
}
