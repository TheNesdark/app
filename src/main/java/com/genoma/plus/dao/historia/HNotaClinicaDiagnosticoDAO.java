package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.HNotaClinicaDiagnosticoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/HNotaClinicaDiagnosticoDAO.class */
public interface HNotaClinicaDiagnosticoDAO {
    void mCrear(HNotaClinicaDiagnosticoDTO hNotaClinicaDiagnosticoDTO);

    List<Object[]> listDiagnosticoNotaClinica(String str);

    List<Object[]> listDiagnosticosIngreso(Long l);

    List<Object[]> listUltimaNotaEspecialista(Long l, Long l2);

    List<Object[]> listDiagnosticosEspecialidadAnterior(Long l, Long l2, String str);
}
