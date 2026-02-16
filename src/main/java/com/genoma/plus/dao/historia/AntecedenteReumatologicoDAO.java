package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AntecedenteReumatologicoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AntecedenteReumatologicoDAO.class */
public interface AntecedenteReumatologicoDAO {
    String mCreate(AntecedenteReumatologicoDTO antecedenteReumatologicoDTO);

    List<AntecedenteReumatologicoDTO> listAnteReumatologico(Long l);

    String mUpdate(AntecedenteReumatologicoDTO antecedenteReumatologicoDTO);

    List<GCGenericoDTO> listEspecialidad();

    List<GCGenericoDTO> listProfesional(String str);
}
