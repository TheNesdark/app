package com.genoma.plus.dao.laboratorio;

import com.genoma.plus.dto.laboratorio.ProtocoloProcedimientoEmpresaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/ProtocoloProcedimientoEmpresaDAO.class */
public interface ProtocoloProcedimientoEmpresaDAO {
    List<Object[]> listaProtocolosProcedimientoEmpresa(String str, String str2);

    String create(ProtocoloProcedimientoEmpresaDTO protocoloProcedimientoEmpresaDTO);

    String update(ProtocoloProcedimientoEmpresaDTO protocoloProcedimientoEmpresaDTO);

    List<Object[]> ListaEmpresa();
}
