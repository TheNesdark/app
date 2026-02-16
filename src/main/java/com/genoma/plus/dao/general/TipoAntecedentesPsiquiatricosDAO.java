package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoAntecedentesPsiquiatricosDAO.class */
public interface TipoAntecedentesPsiquiatricosDAO {
    List<TipoAntecedentesPsiquiatricosDTO> list();

    String create(TipoAntecedentesPsiquiatricosDTO tipoAntecedentesPsiquiatricosDTO);

    String update(TipoAntecedentesPsiquiatricosDTO tipoAntecedentesPsiquiatricosDTO);
}
