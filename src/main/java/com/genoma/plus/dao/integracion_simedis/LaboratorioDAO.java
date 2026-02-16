package com.genoma.plus.dao.integracion_simedis;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.integracion_simedis.DGLEnvioResultadosDTO;
import com.genoma.plus.dto.integracion_simedis.LaboratoriosDTO;
import com.genoma.plus.jpa.entities.IInterfazXencoOrden;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/integracion_simedis/LaboratorioDAO.class */
public interface LaboratorioDAO {
    List<GCGenericoDTO> listarSedesSimedi();

    List<LaboratoriosDTO> listadoAgendaFechaSede(String str, String str2, String str3, Boolean bool, String str4);

    List<LaboratoriosDTO> listadoAgendaFechaSedeSifa(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeSifaSantaClara(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeSifaServiciosSantaClara(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencial(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencialServicios(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencialAtlantico(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencialServiciosAtlantico(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCentralReferencia(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaServiciosCentralReferencia(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaSedeIndigo(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaSedeIndigoServicios(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeCNT(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeGIIS(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeGIISServicios(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNT(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNTServicios(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNTBiomed(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNTServiciosBiomed(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNTAnori(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaCNTServiciosAnori(String str, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeBienEstarIps(String str, String str2, Boolean bool, String str3);

    List<IInterfazXencoOrden> listadoAgendaFechaInterfaceXenco(String str, String str2, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaSedeXenco(String str, Long l, String str2, Boolean bool, String str3);

    List<LaboratoriosDTO> listadoAgendaFechaColgenes(String str, String str2, Boolean bool, String str3);

    LaboratoriosDTO recepcionIdOrde(String str);

    LaboratoriosDTO recepcionIdOrden(String str);

    LaboratoriosDTO recepcionIdOrdenDinamica(String str);

    LaboratoriosDTO recepcionIdOrdenGIIS(String str);

    LaboratoriosDTO recepcionIdOrdenCNT(String str, String str2, String str3);

    LaboratoriosDTO recepcionIdOrdenCNTBiomed(String str);

    LaboratoriosDTO recepcionIdOrdenColgenes(String str);

    LaboratoriosDTO recepcionIdOrdenBs1(String str);

    LaboratoriosDTO recepcionIdOrdenXenco(String str);

    Long consultarOrdenGenoma(Long l);

    void actualizarDatosRecepcion(String str, Long l, String str2);

    void actualizarDatosRecepcionSifas(String str, Long l, String str2, String str3);

    void actualizarDatosRecepcionGIIS(String str, String str2);

    void actualizarDatosRecepcionBS1(String str, String str2, String str3);

    void actualizarDatosRecepcionCNT(String str, String str2, String str3);

    void actualizarResultadoSimedis(Long l, String str, String str2, Long l2, boolean z, String str3);

    void actualizarResultadoGIIS(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Long l, String str14, String str15);

    void actualizarResultadoXenco(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18);

    void actualizarResultadoBs1(String str, String str2, String str3, String str4, Long l);

    void actualizarMedicoBs1(String str, String str2);

    void actualizarObservacionBs1(String str, String str2);

    void insertCabezeraResultadosBS1(String str, String str2, String str3);

    void actualizarResultadoCNT(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Long l, String str15);

    void actualizarResultadoCNT2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Long l, String str15);

    void actualizarResultadoCNTBiomed(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Long l, String str15);

    Long consultarIdRecepcionPorIdOrdenDinamica(String str, String str2);

    Object[] consultarParametrosParaInsertarOrdenDinamicaGerencial(String str, String str2, String str3);

    String insertarEncabezadoResultadoDinamica(String str, Date date, String str2);

    void insertarDetalleResultadoDinamica(String str, String str2, String str3, String str4);

    List<DGLEnvioResultadosDTO> enviarDetalleResultadoDinamica(Long l, Long l2);

    void validacionResultadosDinamica(String str);

    void validacionResultadosDinamica(String str, String str2);
}
