package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.RelacionesFamiliaresDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/RelacionesFamiliaresDAO.class */
public interface RelacionesFamiliaresDAO {
    List<RelacionesFamiliaresDTO> listadoRelaciones();

    String mCreate(RelacionesFamiliaresDTO relacionesFamiliaresDTO);

    String mUpdate(RelacionesFamiliaresDTO relacionesFamiliaresDTO);

    boolean existeAbreviatura(String str);
}
