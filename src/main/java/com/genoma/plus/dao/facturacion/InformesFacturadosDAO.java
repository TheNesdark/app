package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.InformesFacturadosDTO;
import com.genoma.plus.dto.facturacion.ListaFacturaVentasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/InformesFacturadosDAO.class */
public interface InformesFacturadosDAO {
    List<InformesFacturadosDTO> listProcedimientoFacturado(String str, String str2, String str3, int i);

    List<InformesFacturadosDTO> listSuministroFacturado(String str, String str2, String str3, int i);

    List<ListaFacturaVentasDTO> listFacturaVentas(String str, String str2, String str3, String str4);
}
