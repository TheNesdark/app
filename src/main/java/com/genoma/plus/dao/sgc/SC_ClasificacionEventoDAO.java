package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_ClasificacionEventoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SC_ClasificacionEventoDAO.class */
public interface SC_ClasificacionEventoDAO {
    List<SC_ClasificacionEventoDTO> list(String str);

    List<GCGenericoDTO> listaClasificacion();

    String create(SC_ClasificacionEventoDTO sC_ClasificacionEventoDTO);

    String update(SC_ClasificacionEventoDTO sC_ClasificacionEventoDTO);

    String delete(SC_ClasificacionEventoDTO sC_ClasificacionEventoDTO);
}
