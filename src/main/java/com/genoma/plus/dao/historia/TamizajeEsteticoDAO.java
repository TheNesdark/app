package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.TamizajeEsteticoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/TamizajeEsteticoDAO.class */
public interface TamizajeEsteticoDAO {
    String mCreate(TamizajeEsteticoDTO tamizajeEsteticoDTO);

    List<TamizajeEsteticoDTO> listTamizajeEstetico(Long l);

    String mUpdate(TamizajeEsteticoDTO tamizajeEsteticoDTO);
}
