package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.HNotasClinicasDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/HNotasClinicaDAO.class */
public interface HNotasClinicaDAO {
    Long mCrear(HNotasClinicasDTO hNotasClinicasDTO);

    List<Object[]> listNotaClinica(Long l, String str, String str2);

    List<Object[]> listNotaClinica(Long l);

    List<GCGenericoDTO> listarTipoNotasRegistradas(long j, String str);

    void mActualizar(HNotasClinicasDTO hNotasClinicasDTO);
}
