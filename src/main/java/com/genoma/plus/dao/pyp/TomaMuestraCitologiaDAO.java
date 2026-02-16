package com.genoma.plus.dao.pyp;

import com.genoma.plus.dto.pyp.CitologiaSeguimientoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/pyp/TomaMuestraCitologiaDAO.class */
public interface TomaMuestraCitologiaDAO {
    List<Object[]> listaTomaMuestra(Long l);

    List<Object[]> listaSeguimiento(Long l);

    String createSeguimiento(CitologiaSeguimientoDTO citologiaSeguimientoDTO);
}
