package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.CensoHospitalizacionDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/CensoHospitalizacionDAO.class */
public interface CensoHospitalizacionDAO {
    List<CensoHospitalizacionDTO> cargarBusqueda(String str, String str2);

    List<CensoHospitalizacionDTO> cargarBusquedaConvenio(int i, String str, String str2);

    List<GenericoComboDTO> cargarCombo(String str, String str2);
}
