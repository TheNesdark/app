package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AtencionImagenesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AtencionImagenesDAO.class */
public interface AtencionImagenesDAO {
    List<AtencionImagenesDTO> list(String str, String str2, String str3, int i);

    List<GCGenericoDTO> listClasificacion();

    List<GCGenericoDTO> listClasificacionFiltrado(String str, String str2, int i);

    String create_return_id_Detalle(AtencionImagenesDTO atencionImagenesDTO);

    String update(AtencionImagenesDTO atencionImagenesDTO);

    String mUpdateURLDetalle(AtencionImagenesDTO atencionImagenesDTO);
}
