package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoAnalisisDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SC_EventoAdversoAnalisisDAO.class */
public interface SC_EventoAdversoAnalisisDAO {
    List<SC_EventoAdversoAnalisisDTO> listEvento(int i, String str, String str2);

    List<GCGenericoDTO> listaTProceso();
}
