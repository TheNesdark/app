package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.UnidadCamaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/UnidadCamaDAO.class */
public interface UnidadCamaDAO {
    List<Object[]> listaUnidadCama();

    String mCreate(UnidadCamaDTO unidadCamaDTO);

    String mUpdate(UnidadCamaDTO unidadCamaDTO);

    List<Object[]> listaTipoAtencion();
}
