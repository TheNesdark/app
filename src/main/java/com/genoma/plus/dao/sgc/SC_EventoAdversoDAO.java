package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SC_EventoAdversoDAO.class */
public interface SC_EventoAdversoDAO {
    List<SC_EventoAdversoDTO> list(String str);

    List<GCGenericoDTO> listaTProceso();

    List<GCGenericoDTO> listaTRiesgo(String str);

    List<SC_EventoAdversoDTO> listaCheck(String str);

    String create_return_id(SC_EventoAdversoDTO sC_EventoAdversoDTO);

    String update(SC_EventoAdversoDTO sC_EventoAdversoDTO);

    String delete(SC_EventoAdversoDTO sC_EventoAdversoDTO);
}
