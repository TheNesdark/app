package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoRiesgoComplicacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/TipoRiesgoComplicacionDAO.class */
public interface TipoRiesgoComplicacionDAO {
    List<TipoRiesgoComplicacionDTO> listTipoRiesgoComplicacion(String str);

    List<GCGenericoDTO> listClasificacioTipoRiesgoComplicacion();

    String mCreatetipoRiesgoComplicacion(TipoRiesgoComplicacionDTO tipoRiesgoComplicacionDTO);

    String mUpdatetipoRiesgoComplicacion(TipoRiesgoComplicacionDTO tipoRiesgoComplicacionDTO);
}
