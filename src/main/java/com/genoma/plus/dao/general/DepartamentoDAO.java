package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.DepartamentoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/DepartamentoDAO.class */
public interface DepartamentoDAO {
    List<DepartamentoDTO> listDepartamento();

    List<GCGenericoDTO> listPais();

    String mCreate(DepartamentoDTO departamentoDTO);

    String mUpdate(DepartamentoDTO departamentoDTO);
}
