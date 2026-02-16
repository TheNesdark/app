package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.MunicipioDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/MunicipioDAO.class */
public interface MunicipioDAO {
    List<MunicipioDTO> listadoMunicipioFiltradoIdDepartamento(String str);
}
