package com.genoma.plus.dao.general;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ReporteTipoHCDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/ReporteTipoHCDAO.class */
public interface ReporteTipoHCDAO {
    List<ReporteTipoHCDTO> listReportesTipoHC(String str);

    List<GCGenericoDTO> listReportes();

    String mCreate(ReporteTipoHCDTO reporteTipoHCDTO);

    String mUpdate(ReporteTipoHCDTO reporteTipoHCDTO);
}
