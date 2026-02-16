package com.genoma.plus.dao.inventario;

import com.genoma.plus.dto.inventario.ClasificacionLasaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/inventario/ClasificacionLasaDAO.class */
public interface ClasificacionLasaDAO {
    List<ClasificacionLasaDTO> listaClasificacionLasa();

    String crearClasificacionLasa(ClasificacionLasaDTO clasificacionLasaDTO);

    String actualizarClasificacionLasa(ClasificacionLasaDTO clasificacionLasaDTO);
}
