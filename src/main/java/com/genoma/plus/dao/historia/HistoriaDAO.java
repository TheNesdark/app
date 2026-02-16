package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.ExamenFisicoDTO;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/HistoriaDAO.class */
public interface HistoriaDAO {
    List<ConfiguracionItems> listaItemsPorIdHistoria(Integer num, String str, String str2, String str3);

    List<ConfiguracionItems> listaItemsPorIdPadre(Integer num, Long l, String str, String str2, String str3);

    List<ExamenFisicoDTO> listExamenFisicoIdUsuarioUltimo(Long l);

    List<Object[]> listadoTipoNotasporEspecialidad(String str, String str2);

    List<Object[]> listadoEspecialidadInterconsulta(String str);

    List<Object[]> listadoNotasClinicasFiltradaPorId(String str);

    List<InformacionAgendaMedicaDTO> listadoCitasProgramadas(String str, String str2, Long l, Long l2, Long l3);

    List<InformacionAgendaMedicaDTO> listadoCitasNoProgramadas(String str, String str2, Long l, Long l2, Long l3, int i);

    List<InformacionAgendaMedicaDTO> listadoCitasNoProgramadasFiltro(String str, String str2, ArrayList<Integer> arrayList, Long l, Long l2, int i, int i2);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicio(Long l, String str, String str2, Integer num, String str3, int i, Integer num2, Integer num3);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioInterConsultasM(Long l, String str, String str2, Integer num, String str3, int i, Integer num2, Integer num3);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioObservacion(Long l, String str, String str2, Integer num, String str3, int i, Integer num2, Integer num3, String str4);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioClasificado(Long l, String str, String str2, Integer num, String str3, int i, Integer num2, Integer num3);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioFechaIngreso(Long l, String str, String str2, Integer num, String str3, int i, Integer num2, String str4);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioInterconsulta(Long l, String str, Long l2, Integer num, String str2, Integer num2);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioCirugia(Long l, String str, Long l2, Integer num);

    void actualizarFechaHoraAtencion(String str, Long l, Long l2);

    List<Object[]> listadoMedicamentosOrdenFiltradoNombre(String str);

    List<Object[]> listadoHistoricoOrdenesMedicamentosNuevo(Long l, String str, Boolean bool);

    List<InformacionAgendaMedicaDTO> listadoAgendaServicioFiltroSexo(Long l, String str, String str2, Integer num, String str3, String str4);
}
