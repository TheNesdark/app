package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.ConsultarIngresoSoatDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/ConsultarIngresoSoatDAO.class */
public interface ConsultarIngresoSoatDAO {
    List<ConsultarIngresoSoatDTO> listConsultarIngresoSoat(String str, String str2, String str3, int i);

    List<GCGenericoDTO> listTipoEmpresa(String str, String str2);
}
