package com.genoma.plus.dao.citas;

import com.genoma.plus.dto.citas.ConsultarCitasAtendidasDTO;
import com.genoma.plus.dto.citas.ConsultarCitasNoAtendidasDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/citas/InformesCitasDAO.class */
public interface InformesCitasDAO {
    List<ConsultarCitasAtendidasDTO> listProgramadas(String str, String str2, String str3, String str4);

    List<ConsultarCitasAtendidasDTO> listNoProgramadas(String str, String str2, String str3, String str4);

    void addConsolidadoCitasTmp(String str, String str2, String str3, String str4, Integer num);

    void deleteInformacionConsolidadoCitasTmp();

    List<ConsultarCitasNoAtendidasDTO> listCitasNoAtendidas(String str, String str2, String str3);

    List<GCGenericoDTO> listProgramaNoAtendidas(String str, String str2);

    List<GCGenericoDTO> listEspecialidadNoAtendidas(String str, String str2);

    List<GCGenericoDTO> listConvenioNoAtendidas(String str, String str2);

    List<GCGenericoDTO> listProfesionalNoAtendidas(String str, String str2);
}
