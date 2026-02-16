package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.PEADGraficaColorRangoAreaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/PEADGraficaColorRangoAreaDAO.class */
public interface PEADGraficaColorRangoAreaDAO {
    List<Object[]> listaGraficaColorRangoArea();

    String mCreate(PEADGraficaColorRangoAreaDTO pEADGraficaColorRangoAreaDTO);

    String mUpdate(PEADGraficaColorRangoAreaDTO pEADGraficaColorRangoAreaDTO);
}
