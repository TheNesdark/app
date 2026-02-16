package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.CantidadCitasOdontDTO;
import com.genoma.plus.dto.sgc.CantidadProcedimientosOdontDTO;
import com.genoma.plus.dto.sgc.ConNominaxUsuarioDTO;
import com.genoma.plus.dto.sgc.InasistenciaOdontDTO;
import com.genoma.plus.dto.sgc.ProcedimientosPacienteOdontDTO;
import com.genoma.plus.dto.sgc.RegistroDiarioOdontologiaDTO;
import com.genoma.plus.dto.sgc.SGC_ConsultarPanoramaEventoDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/InformesSgcDAO.class */
public interface InformesSgcDAO {
    List<ConNominaxUsuarioDTO> list();

    List<SGC_ConsultarPanoramaEventoDTO> listPanoramaProceso(String str);

    List<SGC_ConsultarPanoramaEventoDTO> listPanoramaEvento(String str, String str2);

    List<Object[]> ListInformeAtencionPrioritaria(String str, String str2, String str3);

    List<Object[]> ListInformeAtencionPrioritariTriage(String str, String str2, String str3);

    List<Object[]> ListInformeAtencionPrioritariPromedio(String str, String str2, String str3);

    List<Object[]> ListInformeDiagnosticoSaludSO(String str, String str2, String str3);

    List<Object[]> ListInformeNOMA(String str, String str2, String str3, int i);

    List<Object[]> ListInformeAudiometria(String str, String str2, String str3, int i);

    List<Object[]> ListInformeEspirometria(String str, String str2, String str3, int i);

    List<Object[]> ListInformeEspirometria1(String str, String str2, String str3, int i);

    List<Object[]> ListInformeVisiometria(String str, String str2, String str3, int i);

    List<Object[]> ListInformeAccidenteTransito(String str, String str2);

    List<GenericoComboDTO> cargarCombo(String str);

    void mCrearTmpAntecedentesFamiliares();

    void mCrearTmpAntecedentesPersonales();

    void mCrearTmpAntecedentesPPatologicos();

    List<CantidadCitasOdontDTO> getCantidadCitasOdont(String str, String str2, Integer num);

    List<CantidadProcedimientosOdontDTO> getCantidadProcedimientosOdont(String str, String str2, Integer num);

    List<InasistenciaOdontDTO> getInasistenciaOdont(String str, String str2, Integer num);

    List<ProcedimientosPacienteOdontDTO> getProcedimientosPacienteOdont(String str, String str2, Integer num);

    List<RegistroDiarioOdontologiaDTO> getRegistroDiarioOdontologia(String str, String str2, Integer num);
}
