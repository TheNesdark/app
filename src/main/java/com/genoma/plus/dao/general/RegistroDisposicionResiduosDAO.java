package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.RegistroDisposicionResiduosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/RegistroDisposicionResiduosDAO.class */
public interface RegistroDisposicionResiduosDAO {
    List<RegistroDisposicionResiduosDTO> listaRegistroDisposicionResiduos();

    List<RegistroDisposicionResiduosDTO> listaRegistroDetalleResiduos(int i);

    List<GCGenericoDTO> listaClasificacionResiduos();

    List<GCGenericoDTO> listaTerceros();

    String create_return_id(RegistroDisposicionResiduosDTO registroDisposicionResiduosDTO);

    String createDetalleResiduo(RegistroDisposicionResiduosDTO registroDisposicionResiduosDTO);
}
