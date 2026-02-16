package com.genoma.plus.dao.parametrizacion;

import com.genoma.plus.dto.parametrizacion.ConvenioServicioDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/parametrizacion/EmpresaServicioDAO.class */
public interface EmpresaServicioDAO {
    List<Object[]> listarEmpresaServicio(Long l, String str);

    void create(ConvenioServicioDTO convenioServicioDTO);

    void update(ConvenioServicioDTO convenioServicioDTO);
}
