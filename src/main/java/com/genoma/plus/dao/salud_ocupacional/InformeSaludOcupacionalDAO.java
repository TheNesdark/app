package com.genoma.plus.dao.salud_ocupacional;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.AutoReporteDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/salud_ocupacional/InformeSaludOcupacionalDAO.class */
public interface InformeSaludOcupacionalDAO {
    List<AutoReporteDTO> listAutoReporteDetalle(String str, String str2, String str3);

    List<AutoReporteDTO> listFramingham(String str, String str2);

    List<AutoReporteDTO> listRuffier(String str, String str2);

    List<GCGenericoDTO> listTipoCuestionario(String str, String str2);

    List<Object[]> informeRiesgoCardioVascularSo(String str, int i, int i2);

    List<Object[]> informeRiesgoCardioVascularSoMineros(String str, int i, int i2);
}
