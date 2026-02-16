package com.genoma.plus.dao.laboratorio;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.laboratorio.AgendaDetalleDTO;
import com.genoma.plus.dto.laboratorio.DetalleComentarioProtocoloDTO;
import com.genoma.plus.dto.laboratorio.DetalleRecepcionComentarioDTO;
import com.genoma.plus.dto.laboratorio.DetalleRecepcionSoporteDTO;
import com.genoma.plus.dto.laboratorio.GenericoDTO;
import com.genoma.plus.dto.laboratorio.HistoricoResultadoProtocoloDTO;
import com.genoma.plus.dto.laboratorio.RecepcionDTO;
import com.genoma.plus.dto.laboratorio.RecepcionDetalleDTO;
import com.genoma.plus.dto.laboratorio.TipoResultadoProtocoloDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/LaboratorioBienestarDAO.class */
public interface LaboratorioBienestarDAO {
    List<AgendaDetalleDTO> listAgenda(String str, Integer num, Integer num2, String str2, String str3);

    List<AgendaDetalleDTO> listAgendaIdProcedimiento(String str, Integer num, Integer num2, String str2, Long l, String str3, Long l2);

    List<AgendaDetalleDTO> listAgendaDocNombre(String str, String str2, String str3);

    List<RecepcionDTO> listRecepcionPlanillaC(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6);

    List<RecepcionDTO> listRecepcionPlanillaCMunicipio(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7);

    List<RecepcionDTO> listRecepcionPlanillaProcedimiento(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7);

    List<RecepcionDTO> listRecepcionPlanillaProcedimientoMunicipio(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8);

    List<RecepcionDTO> listRecepcionPlanillaArea(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7);

    List<RecepcionDTO> listRecepcionPlanillaAreaMunicipio(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8);

    List<RecepcionDTO> listRecepcionId(String str);

    List<GenericoDTO> listComentarioIdArea(String str);

    List<GenericoDTO> listResultadoInterfaz(String str, Long l, String str2, String str3);

    List<GenericoDTO> listTipoResultadoporDefecto(Long l, Long l2);

    List<GenericoDTO> listTipoResultadoporDefectoPorPatologia(Long l, String str, String str2);

    List<GenericoDTO> listTipoResultadoporDefectoBs1(Long l, Long l2);

    List<RecepcionDetalleDTO> listRecepcionDetalle(String str, Integer num, Integer num2);

    List<RecepcionDetalleDTO> listRecepcionDetalleArea(String str, String str2, Integer num, Integer num2);

    List<RecepcionDetalleDTO> listRecepcionDetalleIdProcedimiento(String str, String str2, Integer num, Integer num2);

    Long addResultado(String str, String str2, String str3, Long l, Long l2, String str4, String str5);

    void addResultadoDetalle(Long l, String str, Long l2, Long l3, Long l4, Long l5, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, String str8, String str9);

    void updateDetalleRecepcion(Integer num, Integer num2, Long l, Long l2, Integer num3, Integer num4);

    void updateDetalleResultado(Integer num, Long l, Long l2, Long l3);

    List<GenericoDTO> devulveUltimoResultadoProtocolo(Long l, Long l2, Long l3);

    void updateDetalleResultadoHistorio(Long l, Long l2);

    void updateIdResultadoComentario(Long l, Long l2, Long l3);

    void updateIdResultadoOrdenFacturacion(Long l, Long l2, Long l3);

    void deleteComentarioResultadoProcedimento(Long l, Long l2);

    List<GenericoDTO> listHistoricoResultadosProtocolo(Long l, Long l2, Integer num);

    void deleteDetalleResultadoComentario(Long l, Long l2, Long l3);

    void addResultadoHistoricoGrafica(String str, Long l, Long l2);

    void addComentarioArea(Long l, Long l2, Long l3, String str, Integer num, String str2);

    String mCreateSeguimiento(DetalleRecepcionComentarioDTO detalleRecepcionComentarioDTO);

    String mUpdateSeguimientos(DetalleRecepcionComentarioDTO detalleRecepcionComentarioDTO);

    String create_return_id_Soporte(DetalleRecepcionSoporteDTO detalleRecepcionSoporteDTO);

    String mUpdateSoportes(DetalleRecepcionSoporteDTO detalleRecepcionSoporteDTO);

    String mUpdateRuta(DetalleRecepcionSoporteDTO detalleRecepcionSoporteDTO);

    Integer verificarProfesionalResultado(Long l, Long l2, Long l3);

    void deleteResultado(Long l, Long l2, Long l3, int i);

    void addResultadoInterfaz(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i);

    void mUpdateResultadoInterfaz(String str, String str2, String str3, String str4, String str5, String str6);

    List<DetalleComentarioProtocoloDTO> listDetalleComentarioProtocolo(Long l, Long l2);

    List<HistoricoResultadoProtocoloDTO> listHistoricoResultadoProtocolo(Long l, Long l2);

    List<TipoResultadoProtocoloDTO> listTipoResultadoProtocolo(Long l, Integer num);

    List<TipoResultadoProtocoloDTO> listTipoResultadoProtocoloEdad(Long l, Integer num, String str);

    List<DetalleRecepcionComentarioDTO> listSeguimientos(Long l, Long l2);

    List<DetalleRecepcionSoporteDTO> listSoportes(Long l, Long l2);

    List<Object[]> devuelveIdProtocoloProcedimiento_Infinity(String str, String str2);

    List<Object[]> consultarNOrdenFacturacion_IdRecepcion(String str);

    List<Object[]> consultarResultadoProtoolo(String str, Long l);

    List<Object[]> consultarComentarioProtocolo(String str, Long l);

    List<Object[]> listRecepcionesMunicipio(String str, String str2);

    List<Object[]> listRecepcionesServicios(String str, String str2);

    List<Object[]> listConsultaInterfaz(String str, String str2, String str3, String str4);

    List<Object[]> listComentariosProcedimientoMaquina(String str, String str2);

    List<Object[]> listComentariosProcedimientoMaquinaResultado(String str, String str2, String str3);

    List<Object[]> listConfiguracionMaquina(String str);

    List<Object[]> listExistenciaResultadoInterfaz(String str, String str2, String str3, String str4, String str5);

    String valorUltimoResultado(String str, String str2, String str3);

    void updateDatelleResultadoEnviado(int i);

    void cargarArchivosDeResultadosExternos(Long l, Long l2, byte[] bArr);

    List<Object[]> listaResultadosExportacionInstitucional(String str, String str2, String str3, String str4);

    List<GCGenericoDTO> listaEmpresaExporactionHomologada();

    List<Object[]> listaEquiposxPC(String str);

    List<Object[]> listaProcedimientosRecepcion(String str);

    List<Object[]> consultarExistenciaHCBs1(String str);

    void updateCierreHcBs1(String str);

    void updateCierreGenomHcBs1(String str);
}
