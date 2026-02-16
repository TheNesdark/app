package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ActividadEconomicaDTO;
import com.genoma.plus.dto.general.ActividadEconomicaNivelDTO;
import com.genoma.plus.dto.general.ActividadEconomicaTerceroDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ActividadEconomicaDAO.class */
public interface ActividadEconomicaDAO {
    List<ActividadEconomicaDTO> listActividadEconomica();

    String createActividadEconomica(ActividadEconomicaDTO actividadEconomicaDTO);

    String updateActividadEconomica(ActividadEconomicaDTO actividadEconomicaDTO);

    List<ActividadEconomicaNivelDTO> listActividadENivel();

    String createActividadEnivel(ActividadEconomicaNivelDTO actividadEconomicaNivelDTO);

    String updateActividadEnivel(ActividadEconomicaNivelDTO actividadEconomicaNivelDTO);

    List<ActividadEconomicaTerceroDTO> listActividadETercero(String str);

    List<GCGenericoDTO> listActividad(String str);

    String createActividadETercero(ActividadEconomicaTerceroDTO actividadEconomicaTerceroDTO);

    String updateActividadETercero(ActividadEconomicaTerceroDTO actividadEconomicaTerceroDTO);
}
