package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
import com.genoma.plus.dto.historia.AntecedentesFisicoPsiaquiatricosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AntecedentesFisicoPsiquiatricosDAO.class */
public interface AntecedentesFisicoPsiquiatricosDAO {
    String create(AntecedentesFisicoPsiaquiatricosDTO antecedentesFisicoPsiaquiatricosDTO);

    List<AntecedentesFisicoPsiaquiatricosDTO> listaAntecedentesPsiquiatricos(long j);

    String update(AntecedentesFisicoPsiaquiatricosDTO antecedentesFisicoPsiaquiatricosDTO);

    List<TipoAntecedentesPsiquiatricosDTO> listaTipoAntecedentesPsiquiatricos();
}
