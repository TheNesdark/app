package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.TipoAtencionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/TipoAtencionDAO.class */
public interface TipoAtencionDAO {
    List<Object[]> listTipoAtencion();

    List<Object[]> listTipoAmbito();

    List<Object[]> listGrupoServicio();

    void addTipoAtencion(TipoAtencionDTO tipoAtencionDTO);

    void updateTipoAtencion(TipoAtencionDTO tipoAtencionDTO);
}
