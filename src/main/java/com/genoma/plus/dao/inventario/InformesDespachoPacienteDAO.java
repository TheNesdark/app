package com.genoma.plus.dao.inventario;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.inventario.InformesDespachoPacienteDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/inventario/InformesDespachoPacienteDAO.class */
public interface InformesDespachoPacienteDAO {
    List<InformesDespachoPacienteDTO> listaPacientes(String str, String str2, String str3);

    List<InformesDespachoPacienteDTO> listaAuditoria(String str, String str2, String str3);

    List<InformesDespachoPacienteDTO> listaProducto(String str, String str2, String str3);

    List<InformesDespachoPacienteDTO> listaEmpresa(String str, String str2, String str3);

    List<GCGenericoDTO> listabodegas();
}
