package Sgc;

import Acceso.Principal;
import AutorizacionMP.JIFConsultasUsuarioEnv;
import ImagenesDx.JIFInformesPlacas;
import Informes.JIFAuditoriaHC;
import Informes.JIFAuditoriaTiemposInf;
import Informes.JIFInformes;
import Inventarios.JIFConsultasInfMed;
import Inventarios.JIFInformeConsolidadoMov;
import Laboratorio.JIFAuditoriaTiempos;
import Laboratorio.JIFConsultasInfLab;
import Laboratorio.JIFConsultasInfProced;
import Odontologia.JIFFIndicadoresGenerales;
import PyP.JIFPyP_InformesC;
import Salud_Ocupacional.JIFFInformes;
import Sig.JIFAuditoriaTriage;
import Sig.JIFConsultarInf1Comb2Tabla;
import Sig.JIFConsultarInf1CombTabla1;
import Sig.JIFConsultarInf3Tabla;
import Sig.JIFConsultarInfCove;
import Sig.JIFConsultarInfNutricion;
import Sig.JIFConsultarInfR4505;
import Sig.JIFConsultarInforSo;
import Sig.JIFConsultar_Informacion_P;
import Sig.JIFGeneracion_Archivos;
import Sig.JIFGenericoxFecha;
import Sig.JIFIndiOdontologia;
import Sig.JIFInformeSalidaAdministrativa;
import Sig.JIFInformesPyP;
import Sig.JIFInformesSupersalud;
import Sig.JIFInformes_Pyp_Eps;
import Sig.JIFRefConsultaNutricion;
import Sig.JIFResultadoBateria;
import Sig.JIFVigenciaPoliza;
import Sig.JIF_Informes_GResoluciones;
import com.genoma.plus.controller.general.JIF_CargarBaseEntidades;
import com.genoma.plus.controller.salud_ocupacional.JIFInformesSo;
import com.genoma.plus.controller.sgc.JIFActas;
import com.genoma.plus.controller.sgc.JIFConCuentaNominaxUsuario;
import com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso;
import com.genoma.plus.controller.sgc.JIFEstadisticaCitas;
import com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral;
import com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion;
import com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha;
import com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad;
import com.genoma.plus.controller.sgc.JIFF_InformeSesionesXTrabajador;
import com.genoma.plus.controller.sgc.JIFF_Planificacion_Familias_AIC_clinica_pajonal;
import com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis;
import com.genoma.plus.controller.sgc.JIFInforme015OportunidadAtencionv1;
import com.genoma.plus.controller.sgc.JIFInformesGenericoFiltroFechaCombo;
import com.genoma.plus.controller.sgc.JIFRegistroReuniones;
import com.genoma.plus.controller.sgc.JIF_Auditoria_Medicamentos_Facturados_Rips;
import com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips;
import com.genoma.plus.controller.sgc.JIF_Consulta_Atencion_por_Fecha;
import com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO;
import com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica;
import com.genoma.plus.controller.sgc.JIF_Informe_Diagnostico;
import com.genoma.plus.controller.sgc.JIF_MedicamentosEntregadosPorEPS;
import com.genoma.plus.controller.sgc.JIF_RConsultasMedicasDiarias;
import com.genoma.plus.controller.sgc.JIF_RCronicos;
import com.genoma.plus.controller.sgc.JIF_RProduccionRes2193;
import com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1;
import com.genoma.plus.controller.sgc.JIF_RRemisiones;
import com.genoma.plus.controller.sgc.JIF_Reportes_Generico;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.controller.sig.JIFConsultarNovedad;
import com.genoma.plus.controller.sig.JIFEstadisticaMorbilidadMortalidad;
import com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad;
import com.genoma.plus.controller.sig.JIFInformeInterconsultas;
import com.genoma.plus.controller.sig.JIFInformeMedicamentosSivigilia;
import com.genoma.plus.controller.sig.JIFInformesGenericoSO;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/claseSgc.class */
public class claseSgc {
    public Principal frmPrincipal;
    public JIFConfiguracionUno xfrmConfiguracionUno;
    public JIFConfiguracionCDos xfrmConfiguracionCDos;
    private JIFGestionSolicitudes jifgestionsol;
    private JIFResultadoEncuesta xjifresultadoencuesta;
    private JIFEncuestaS xjifregistroencuesta;
    private JIFConsultasInfProced xjifconsultainflabproc;
    private JIFConsolidadoSolicitud xjifconsolidadosol;
    private JIF_Informe_CCasosSeguridadClinica xjifconsolidadoseguridadclinica;
    private JIFRNoConfomidad xjifreportenc;
    public JIFFicha5w1H xjifficha5w1h;
    private JIFRCSeguridadClinica xjifrseguridadclinica;
    private JIFRegistroIndicadores xjifregistroindicadores;
    private JIFConsultasInfLab xjiconsultainf;
    public JIFAuditoriaTiempos jifauditoria;
    private JIFRefConsultaNutricion xjifconsnutricion;
    private JIFConsultarInfNutricion xjifconsultarinfnutricional;
    private JIFInformesPyP xjifinformespyp;
    private JIFInformeConsolidadoMov xjifinformeconsmovimiento;
    private JIFInformesPyP xjifinforme;
    private JIFConsultarInfCove xjifconsultarcove;
    private JIFConsultarInf3Tabla xjifconsultarinf2tablas;
    private JIFInformesPlacas xjifinformeplacas;
    private JIFConsultarInf1CombTabla1 xjifconsultar1comtabla;
    private JIFConsultarInf1Comb2Tabla xjifconsulta1tablar;
    private JIFConsultarInforSo xjifconsultarinfso;
    private JIFAuditoriaHC xjifauditoriahc;
    private JIFInformesSupersalud xjifinformesupersalud;
    private JIFConsultasInfMed xjifformulacionmed;
    private JIFVigenciaPoliza xjifpoliza;
    private JIFConsultasUsuarioEnv xjifuser_envio;
    private JIFConsultarInfR4505 xjifres4505;
    private JIF_Consultar_Examenes_SO consultar_Examenes_SO;
    private JIFAuditoriaTriage jifauditoriatriage;
    private JIFGeneracion_Archivos xjifgeneracionpdf;
    private JIFInformes_Pyp_Eps xjifinformeeps;
    private JIFDemandaNoAtendidas xJIFDemandaNoAtendidas;
    private JIFResultadoBateria xJIFResultadoBateria;
    private JIFFInformes xjiffinformes;
    private JIFPyP_InformesC xjif_infocitologia;
    private JIFConsultar_Informacion_P xjifc_informacion_p;
    private JIFGenericoxFecha xJIFGenericoxFecha;
    private JIFInformes xJIFInformes;
    private JIFAuditoriaTiemposInf jifautoriatiempo;
    private JIF_Informes_GResoluciones xjif_inresoluciones;
    private JIFInformeSalidaAdministrativa xJIF_InformeSalidaAdministrativa;
    private JIFIndiOdontologia xJIFIndiOdontologia;
    private JIFFEventoAdverso xJIFFEventoAdverso;
    private JIF_Informes_GResoluciones xJIF_Informes_GResoluciones;
    private JIFConCuentaNominaxUsuario xJIFConCuentaNominaxUsuario;
    public JIFF_SC_EventoAdversoAnalisis xJIFF_SC_EventoAdversoAnalisis;
    public JIFFConsultasPyP xJIFFConsultasPyP;
    public JIFActas xJIFActas;
    private JIFF_InformeSesionesXTrabajador xJIFF_InformeSesionesXTrabajador;
    private JIFConsultarPanoramaEventoAdverso xJIFConsultarPanoramaEventoAdverso;
    private JIFConsultarNovedad xJIFConsultarNovedad;
    private JIFInformesSo xJIFInformesSo;
    private JIFRegistroReuniones xJIFRegistroReuniones;
    private JIFInformesGenericoSO xJIFInformesGenericoSO;
    private JIFInforme015OportunidadAtencionv1 xJIFInforme015OportunidadAtencionv1;
    private JIFInformeMedicamentosSivigilia xJIFInformeMedicamentosSivigilia;
    private JIFEstadisticaCitas xJIFEstadisticaCitas;
    private JIFFConsultarSISMEDTrimestral xJIFFConsultarSIMEDTrimestral;
    private JIFF_Planificacion_Familias_AIC_clinica_pajonal xPlanificacion_Familias_AIC_clinica_pajonal;
    private JIFF_ConsultarInformacionGenericaHospitalizacion xJIFF_ConsultarInformacionGenericaHospitalizacion;
    private JIFF_InformePacientesFacturadosConFinalidad xJIFF_InformePacientesFacturadosConFinalidad;
    private JIFFIndicadoresGenerales xJIFFIndicadoresGenerales;
    private JIF_MedicamentosEntregadosPorEPS xJIF_MedicamentosEntregadosPorEPS;
    private JIFF_EjecucionPresupuestalPorFecha xJIFF_EjecucionPresupuestalPorFecha;
    private JIF_RConsultasMedicasDiarias xJIF_RConsultasMedicasDiarias;
    private JIF_RProduccionRes2193 xJIF_RProduccionRes2193;
    private JIF_RProduccionRes2193_V1 produccionRes2193_V1;
    private JIF_RRemisiones xJIF_RRemisiones;
    private JIF_RCronicos xJIF_RCronicos;
    private JIF_CargarBaseEntidades cargarBaseEntidades;
    private JIF_Informe_Diagnostico xJIF_Informe_Diagnostico;
    private JIF_Consulta_Atencion_por_Fecha xJIF_Consulta_Atencion_por_Fecha;
    private JIF_Auditoria_Medicamentos_Facturados_Rips xJIF_Auditoria_Medicamentos_Facturados_Rips;
    private JIF_Auditoria_Procedimientos_Facturados_Rips xJIF_Auditoria_Procedimientos_Facturados_Rips;
    private JIF_Reportes_PyP_Generico xJIF_Reportes_PyP_Generico;
    private JIFInformesGenericoFiltroFechaCombo genericoFiltroFechaCombo;
    private JIF_Reportes_Generico xJIF_Reportes_Generico;
    private JIFEstadisticaMorbilidadMortalidad estadisticaMorbilidadMortalidad;
    private JIFInformeInterconsultas xJIFInformeInterconsultas;
    private JIFInformeConsolidadoPypFinalidad informeConsolidadoPypFinalidad;
    private JIFSeguimientoAmbulatorio ambulatorio;
    private JIFGestionOrdenesDynamicos jifgestionordenesdynamicos;

    public void buscar(String frm) {
        if (frm.equals("jifgestionsolicitudes")) {
            this.jifgestionsol.mBuscar();
            return;
        }
        if (frm.equals("xjif_informescasosseguridadclinica")) {
            this.xjifconsolidadoseguridadclinica.mBuscar();
            return;
        }
        if (frm.equals("jifresultadoencuesta")) {
            this.xjifresultadoencuesta.mBuscar();
            return;
        }
        if (frm.equals("jifconsultarinforlab1")) {
            this.xjifconsultainflabproc.mBuscar();
            return;
        }
        if (frm.equals("xjifconsolidadosolicitudes")) {
            this.xjifconsolidadosol.mBuscar();
            return;
        }
        if (frm.equals("xjifreportenc1") || frm.equals("xjifreportenc2")) {
            this.xjifreportenc.mBuscar();
            return;
        }
        if (frm.equals("xjifregistroindicadores")) {
            this.xjifregistroindicadores.mBuscar();
            return;
        }
        if (frm.equals("jifconsinformelab2")) {
            this.xjiconsultainf.mBuscar();
            return;
        }
        if (frm.equals("jiftiemposespera1")) {
            this.jifauditoria.mBuscar();
            return;
        }
        if (frm.equals("xjifreferenciac3")) {
            this.xjifconsnutricion.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarinfnutricion")) {
            this.xjifconsultarinfnutricional.mBuscar();
            return;
        }
        if (frm.equals("xjifconsolidadomovimiento2")) {
            this.xjifinformeconsmovimiento.mBuscar();
            return;
        }
        if (frm.equals("jifinformespyp")) {
            this.xjifinforme.mBuscar();
            return;
        }
        if (frm.equals("jifinformacioncove")) {
            this.xjifconsultarcove.mBuscar();
            return;
        }
        if (frm.equals("xjifplacasdanadas")) {
            this.xjifconsultarinf2tablas.mBuscar();
            return;
        }
        if (frm.equals("jifinformeplacas")) {
            this.xjifinformeplacas.mBuscar();
            return;
        }
        if (frm.equals("xjiffasignacioncitas")) {
            this.xjifconsultar1comtabla.mBuscar();
            return;
        }
        if (frm.equals("xjifinformacionxespecialidad")) {
            this.xjifconsulta1tablar.mBuscar();
            return;
        }
        if (frm.equals("xjifestudiosrealizados")) {
            this.xjifinformeplacas.mBuscar();
            return;
        }
        if (frm.equals("xjifremisionesxprofesional")) {
            this.xjifconsulta1tablar.mBuscar();
            return;
        }
        if (frm.equals("xjifinformacionso")) {
            this.xjifconsultarinfso.mBuscar();
            return;
        }
        if (frm.equals("xjifauditoriahcmed") || frm.equals("xjifauditoriahcenfer")) {
            this.xjifauditoriahc.buscar();
            return;
        }
        if (frm.equals("xjifinformesupersalud")) {
            this.xjifinformesupersalud.mBuscar();
            return;
        }
        if (frm.equals("xjifficha5w1h")) {
            this.xjifficha5w1h.mBuscar();
            return;
        }
        if (frm.equals("xjifinformacionr4505")) {
            this.xjifres4505.mBuscar();
            return;
        }
        if (frm.equals("jiftiemposesperarx2")) {
            this.jifauditoria.mBuscar();
            return;
        }
        if (frm.equals("jifauditoriatriage1")) {
            this.jifauditoriatriage.mBuscar();
            return;
        }
        if (frm.equals("xjif_consultarinformes_eps")) {
            this.xjifinformeeps.mBuscar();
            return;
        }
        if (frm.equals("xjifResultadoSicosocial")) {
            this.xJIFResultadoBateria.mBuscar();
            return;
        }
        if (frm.equals("xjiftestfatigaInf2")) {
            this.xjiffinformes.mBuscar();
            return;
        }
        if (frm.equals("jifconsultarinformesm1")) {
            this.xjifformulacionmed.mBuscar();
            return;
        }
        if (frm.equals("xjif_pyp_informes1")) {
            this.xjif_infocitologia.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultas_informes_p") || frm.equals("xjifconsultas_informes_p1")) {
            this.xjifc_informacion_p.mBuscar();
            return;
        }
        if (frm.equals("jifGenericoxFecha")) {
            this.xJIFGenericoxFecha.mBuscar();
            return;
        }
        if (frm.equals("jifauditoriatiempo")) {
            this.jifautoriatiempo.buscar();
            return;
        }
        if (frm.equals("jifnofacturadas")) {
            this.xJIFDemandaNoAtendidas.mBuscar();
            return;
        }
        if (frm.equals("xjif_informes_resoluciones")) {
            this.xjif_inresoluciones.mBuscar();
            return;
        }
        if (frm.equals("xjifInformeOdont")) {
            this.xJIFIndiOdontologia.mBuscar();
            return;
        }
        if (frm.equals("jiffAnalisisEventoAdverso")) {
            this.xJIFF_SC_EventoAdversoAnalisis.mBuscar();
            return;
        }
        if (frm.equals("agudezaVisual") || frm.equals("planificacionFamiliar") || frm.equals("jovenSano") || frm.equals("adultoSano") || frm.equals("crecimientoYDesarrollo")) {
            this.xJIFFConsultasPyP.mBuscar();
            return;
        }
        if (frm.equals("xjiffSesionesXTrabajdor")) {
            this.xJIFF_InformeSesionesXTrabajador.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarpanoramaeventos")) {
            this.xJIFConsultarPanoramaEventoAdverso.mBuscar();
            return;
        }
        if (frm.equals("xJIFConsultarNovedad")) {
            this.xJIFConsultarNovedad.mBuscar();
            return;
        }
        if (frm.equals("xjif_informeSo_SGC")) {
            this.xJIFInformesSo.mBuscar();
            return;
        }
        if (frm.equals("xjifinformegenericoso")) {
            this.xJIFInformesGenericoSO.mBuscar();
            return;
        }
        if (frm.equals("jiFOportunidadAtencion")) {
            this.xJIFInforme015OportunidadAtencionv1.mBuscar();
            return;
        }
        if (frm.equals("jIFInformeMedicamentosSivigilia")) {
            this.xJIFInformeMedicamentosSivigilia.mBuscar();
            return;
        }
        if (frm.equals("xJIFEstadisticaCitas")) {
            this.xJIFEstadisticaCitas.mBuscar();
            return;
        }
        if (frm.equals("jiffConsultarSIMEDTrimestral")) {
            this.xJIFFConsultarSIMEDTrimestral.mBuscar();
            return;
        }
        if (frm.equals("jiff_planificacion_Familias_AIC_clinica_pajonal")) {
            this.xPlanificacion_Familias_AIC_clinica_pajonal.mBuscar();
            return;
        }
        if (frm.equals("jiff_ConsultarInformacionGenericaHospitalizacion")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion.mBuscar();
            return;
        }
        if (frm.equals("xjifreferenciac3")) {
            this.xjifconsnutricion.mBuscar();
            return;
        }
        if (frm.equals("xjifAReferenciac")) {
            this.xjifconsnutricion.mBuscar();
            return;
        }
        if (frm.equals("jiff_InformePacientesFacturadosConFinalidad")) {
            this.xJIFF_InformePacientesFacturadosConFinalidad.mBuscar();
            return;
        }
        if (frm.equals("jifIndicadoresOdontologia")) {
            this.xJIFFIndicadoresGenerales.buscarDatos();
            return;
        }
        if (frm.equals("jif_MedicamentosEntregadosPorEPS")) {
            this.xJIF_MedicamentosEntregadosPorEPS.mBuscar();
            return;
        }
        if (frm.equals("jiff_EjecucionPresupuestalPorFecha")) {
            this.xJIFF_EjecucionPresupuestalPorFecha.mBuscar();
            return;
        }
        if (frm.equals("jif_ReporteConsultasDiarias")) {
            this.xJIF_RConsultasMedicasDiarias.mBuscar();
            return;
        }
        if (frm.equals("jif_ReporteProduccion2193")) {
            this.xJIF_RProduccionRes2193.mBuscar();
            return;
        }
        if (frm.equals("jif_ReporteProduccion2193_V1")) {
            this.produccionRes2193_V1.buscar();
            return;
        }
        if (frm.equals("jif_ReporteRemisiones")) {
            this.xJIF_RRemisiones.mBuscar();
            return;
        }
        if (frm.equals("jif_ReporteCronicos")) {
            this.xJIF_RCronicos.mBuscar();
            return;
        }
        if (frm.equals("jif_InformeDiagnostico")) {
            this.xJIF_Informe_Diagnostico.mBuscar();
            return;
        }
        if (frm.equals("jif_ConsultarAtencionPorFecha")) {
            this.xJIF_Consulta_Atencion_por_Fecha.mBuscar();
            return;
        }
        if (frm.equals("jif_AuditoriaMedicamentosFacRips")) {
            this.xJIF_Auditoria_Medicamentos_Facturados_Rips.mBuscar();
            return;
        }
        if (frm.equals("jif_AuditoriaProcedimientosFacRips")) {
            this.xJIF_Auditoria_Procedimientos_Facturados_Rips.mBuscar();
            return;
        }
        if (frm.equals("jif_ReportesPyP")) {
            this.xJIF_Reportes_PyP_Generico.mBuscar();
            return;
        }
        if (frm.equals("jifinformegenericofechas")) {
            this.genericoFiltroFechaCombo.buscar();
            return;
        }
        if (frm.equals("jif_ReportesGenerico")) {
            this.xJIF_Reportes_Generico.mBuscar();
            return;
        }
        if (frm.equals("jifmorbilidad_mortalidad")) {
            this.estadisticaMorbilidadMortalidad.buscar();
        } else if (frm.equals("jifInformeConsoliadoPorFinalidad1")) {
            this.informeConsolidadoPypFinalidad.buscar();
        } else if (frm.equals("jifgestionordenes")) {
            this.jifgestionordenesdynamicos.cargarDatosTabla();
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Tipo de Proceso") || frm.equals("Procesos")) {
            this.xfrmConfiguracionUno = new JIFConfiguracionUno(frm.toUpperCase());
            Principal.cargarPantalla(this.xfrmConfiguracionUno);
            return;
        }
        if (frm.equals("Informe Consolidado Casos Seguridad Clinica")) {
            this.xjifconsolidadoseguridadclinica = new JIF_Informe_CCasosSeguridadClinica();
            Principal.cargarPantalla(this.xjifconsolidadoseguridadclinica);
            return;
        }
        if (frm.equals("Cargue Información Entidades")) {
            this.cargarBaseEntidades = new JIF_CargarBaseEntidades();
            Principal.cargarPantalla(this.cargarBaseEntidades);
            return;
        }
        if (frm.equals("Atenciones So")) {
            this.xjiffinformes = new JIFFInformes("xjiftestfatigaInf2", "Atenciones Salud Ocupacional");
            Principal.cargarPantalla(this.xjiffinformes);
            return;
        }
        if (frm.equals("Reuniones")) {
            this.xJIFRegistroReuniones = new JIFRegistroReuniones();
            Principal.cargarPantalla(this.xJIFRegistroReuniones);
            return;
        }
        if (frm.equals("Consultar Estado de Asignaciones de Citas no Programadas")) {
            this.xjifc_informacion_p = new JIFConsultar_Informacion_P("xjifconsultas_informes_p1", "Consultar Estado de Asignaciones de Citas no Programadas");
            Principal.cargarPantalla(this.xjifc_informacion_p);
            return;
        }
        if (frm.equals("Consolidado Tiempos de Atención")) {
            this.xjifc_informacion_p = new JIFConsultar_Informacion_P("xjifconsultas_informes_p", "Consolidado Tiempos de Atención");
            Principal.cargarPantalla(this.xjifc_informacion_p);
            return;
        }
        if (frm.equals("Generacion_PDF")) {
            this.xjifgeneracionpdf = new JIFGeneracion_Archivos("INCAPACIDADES");
            Principal.cargarPantalla(this.xjifgeneracionpdf);
            return;
        }
        if (frm.equals("Informe por eps")) {
            this.xjifinformeeps = new JIFInformes_Pyp_Eps();
            Principal.cargarPantalla(this.xjifinformeeps);
            return;
        }
        if (frm.equals("Resolucion4505")) {
            this.xjifres4505 = new JIFConsultarInfR4505("4505");
            Principal.cargarPantalla(this.xjifres4505);
            return;
        }
        if (frm.equals("examenesSO")) {
            this.consultar_Examenes_SO = new JIF_Consultar_Examenes_SO();
            Principal.cargarPantalla(this.consultar_Examenes_SO);
            return;
        }
        if (frm.equals("Movimiento Consolidado")) {
            this.xjifinformeconsmovimiento = new JIFInformeConsolidadoMov("xjifconsolidadomovimiento2");
            Principal.cargarPantalla(this.xjifinformeconsmovimiento);
            return;
        }
        if (frm.equals("Consultar Reduccion y/o Aumento de Peso")) {
            this.xjifconsultarinfnutricional = new JIFConsultarInfNutricion();
            Principal.cargarPantalla(this.xjifconsultarinfnutricional);
            return;
        }
        if (frm.equals("Referencia Consulta Nutrición")) {
            this.xjifconsnutricion = new JIFRefConsultaNutricion("xjifreferenciac3");
            Principal.cargarPantalla(this.xjifconsnutricion);
            return;
        }
        if (frm.equals("CSeguridadClinica")) {
            this.xjifrseguridadclinica = new JIFRCSeguridadClinica(0, "xjifcseguridadclinica");
            Principal.cargarPantalla(this.xjifrseguridadclinica);
            return;
        }
        if (frm.equals("Estadística de Tiempo de Espera")) {
            this.jifauditoria = new JIFAuditoriaTiempos("jiftiemposespera1", "Estadistica de Tiempo de Espera");
            Principal.cargarPantalla(this.jifauditoria);
            return;
        }
        if (frm.equals("Tiempo de Espera RX")) {
            this.jifauditoria = new JIFAuditoriaTiempos("jiftiemposesperarx2", "Estadistica de Tiempo de Espera");
            Principal.cargarPantalla(this.jifauditoria);
            return;
        }
        if (frm.equals("Estadística de Recepciones")) {
            this.xjiconsultainf = new JIFConsultasInfLab("jifconsinformelab2", frm);
            Principal.cargarPantalla(this.xjiconsultainf);
            return;
        }
        if (frm.equals("Registro de Indicadores")) {
            this.xjifregistroindicadores = new JIFRegistroIndicadores();
            Principal.cargarPantalla(this.xjifregistroindicadores);
            return;
        }
        if (frm.equals("Proceso x Tipo")) {
            this.xfrmConfiguracionCDos = new JIFConfiguracionCDos(frm.toUpperCase());
            Principal.cargarPantalla(this.xfrmConfiguracionCDos);
            return;
        }
        if (frm.equals("Consolidado de Cuenta Nomina por Usuario")) {
            this.xJIFConCuentaNominaxUsuario = new JIFConCuentaNominaxUsuario();
            Principal.cargarPantalla(this.xJIFConCuentaNominaxUsuario);
            return;
        }
        if (frm.equals("Autorizar Solicitudes")) {
            this.jifgestionsol = new JIFGestionSolicitudes(0, "jifgestionsolicitudes", false);
            Principal.cargarPantalla(this.jifgestionsol);
            return;
        }
        if (frm.equals("Gestionar Solicitudes")) {
            this.jifgestionsol = new JIFGestionSolicitudes(1, "jifgestionsolicitudes", true);
            Principal.cargarPantalla(this.jifgestionsol);
            return;
        }
        if (frm.equals("Resultado Encuestas")) {
            this.xjifresultadoencuesta = new JIFResultadoEncuesta();
            Principal.cargarPantalla(this.xjifresultadoencuesta);
            return;
        }
        if (frm.equals("Registro Encuesta")) {
            this.xjifregistroencuesta = new JIFEncuestaS("xjifregistroencuesta3");
            Principal.cargarPantalla(this.xjifregistroencuesta);
            return;
        }
        if (frm.equals("Resultado Examenes por Procedimiento") || frm.equals("Estadística de Muestras Recepcionadas")) {
            this.xjifconsultainflabproc = new JIFConsultasInfProced("jifconsultarinforlab1");
            Principal.cargarPantalla(this.xjifconsultainflabproc);
            return;
        }
        if (frm.equals("Informacion Consolidada")) {
            this.xjifconsolidadosol = new JIFConsolidadoSolicitud();
            Principal.cargarPantalla(this.xjifconsolidadosol);
            return;
        }
        if (frm.equals("Reporte NC") || frm.equals("Registro-Analisis NC")) {
            this.xjifreportenc = new JIFRNoConfomidad(0, "xjifreportenc1");
            Principal.cargarPantalla(this.xjifreportenc);
            return;
        }
        if (frm.equals("Revisar Reporte NC")) {
            this.xjifreportenc = new JIFRNoConfomidad(1, "xjifreportenc2");
            Principal.cargarPantalla(this.xjifreportenc);
            return;
        }
        if (frm.equals("Ficha 5w1H")) {
            this.xjifficha5w1h = new JIFFicha5w1H(0, "xjifficha5w1h");
            Principal.cargarPantalla(this.xjifficha5w1h);
            return;
        }
        if (frm.equals("Consultar Reporte NC")) {
            this.xjifreportenc = new JIFRNoConfomidad(2, "xjifreportenc3");
            Principal.cargarPantalla(this.xjifreportenc);
            return;
        }
        if (frm.equals("Gestion Ficha 5w1H")) {
            this.xjifficha5w1h = new JIFFicha5w1H(1, "xjifficha5w1h");
            Principal.cargarPantalla(this.xjifficha5w1h);
            return;
        }
        if (frm.equals("Usuario x Programa") || frm.equals("Usuario x Actividad") || frm.equals("Hospitalizaciones-Remisiones") || frm.equals("Información Cardiovascular") || frm.equals("Patologías Asociadas") || frm.equals("Suministro Multivitamínicos") || frm.equals("Atenciones por Especialidad") || frm.equals("Formulación por Tipo de Fórmula") || frm.equals("Citas Programadas por Especialidad") || frm.equals("Consultar Alertas Parametrizadas") || frm.equals("Consultar Usuarios Inactivos") || frm.equals("Información Crónicos Colmedica") || frm.equals("Residuos Peligrosos") || frm.equals("Autoreportes") || frm.equals("Reporte Prueba Respiratoria") || frm.equals("Reporte Test Auditivo") || frm.equals("SEGUIMIENTO CRECIMIENTO Y DESARROLLO") || frm.equals("Consultar Morbilidad Fisioterapia") || frm.equals("Eficacia Fisioterapia") || frm.equals("Reporte Sociodemografico") || frm.equals("Consultar Atenciones IMC>30")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase());
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 0);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Edades")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 1);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Sexo")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 2);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Sexo y Edad")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 3);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Auditoria Medica")) {
            this.xjifauditoriahc = new JIFAuditoriaHC("xjifauditoriahcmed");
            Principal.cargarPantalla(this.xjifauditoriahc);
            return;
        }
        if (frm.equals("Auditoria Enfermeria")) {
            this.xjifauditoriahc = new JIFAuditoriaHC("xjifauditoriahcenfer");
            Principal.cargarPantalla(this.xjifauditoriahc);
            return;
        }
        if (frm.equals("Consolidado Eventos No Deseados")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase());
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Informacion SO")) {
            this.xjifconsultarinfso = new JIFConsultarInforSo();
            Principal.cargarPantalla(this.xjifconsultarinfso);
            return;
        }
        if (frm.equals("Informe de Incapacidades")) {
            this.xjifconsultarinfso = new JIFConsultarInforSo();
            Principal.cargarPantalla(this.xjifconsultarinfso);
            return;
        }
        if (frm.equals("Informe Morbilidad General (Sivigila)")) {
            this.xjifconsultarcove = new JIFConsultarInfCove();
            Principal.cargarPantalla(this.xjifconsultarcove);
            return;
        }
        if (frm.equals("Placas Dañadas")) {
            this.xjifconsultarinf2tablas = new JIFConsultarInf3Tabla("xjifplacasdanadas", "INFORME DE PLACAS DAÑADAS");
            Principal.cargarPantalla(this.xjifconsultarinf2tablas);
            return;
        }
        if (frm.equals("Informes de Placas")) {
            this.xjifinformeplacas = new JIFInformesPlacas("Informes de Placas", "jifinformeplacas");
            Principal.cargarPantalla(this.xjifinformeplacas);
            return;
        }
        if (frm.equals("Forma de Asignación Citas")) {
            this.xjifconsultar1comtabla = new JIFConsultarInf1CombTabla1("xjiffasignacioncitas", "INFORME FORMA DE ASIGNACIÓN DE CITAS");
            Principal.cargarPantalla(this.xjifconsultar1comtabla);
            return;
        }
        if (frm.equals("Remisiones por Profesional")) {
            this.xjifconsulta1tablar = new JIFConsultarInf1Comb2Tabla("xjifremisionesxprofesional", frm.toUpperCase());
            Principal.cargarPantalla(this.xjifconsulta1tablar);
            return;
        }
        if (frm.equals("Información Cita x Especialidad")) {
            this.xjifconsulta1tablar = new JIFConsultarInf1Comb2Tabla("xjifinformacionxespecialidad", frm.toUpperCase());
            Principal.cargarPantalla(this.xjifconsulta1tablar);
            return;
        }
        if (frm.equals("Usuarios Atendidos")) {
            this.xjifinformeplacas = new JIFInformesPlacas("USUARIOS ATENDIDOS Y ESTUDIOS REALIZADOS", "xjifestudiosrealizados");
            Principal.cargarPantalla(this.xjifinformeplacas);
            return;
        }
        if (frm.equals("Usuarios Atendidos")) {
            this.xjifconsultarinf2tablas = new JIFConsultarInf3Tabla("xjifusuariosatendidos", "INFORME DE USUARIOS ATENDIDOS Y ESTUDIOS REALIZADOS");
            Principal.cargarPantalla(this.xjifconsultarinf2tablas);
            return;
        }
        if (frm.equals("Informe Super Salud")) {
            this.xjifinformesupersalud = new JIFInformesSupersalud();
            Principal.cargarPantalla(this.xjifinformesupersalud);
            return;
        }
        if (frm.equals("Formulacion Medica")) {
            this.xjifformulacionmed = new JIFConsultasInfMed("jifconsultarinformesm1");
            Principal.cargarPantalla(this.xjifformulacionmed);
            return;
        }
        if (frm.equals("Vigencia de Pólizas x Proveedor")) {
            this.xjifpoliza = new JIFVigenciaPoliza("jifvigenciapoliza");
            Principal.cargarPantalla(this.xjifpoliza);
            return;
        }
        if (frm.equals("CONSULTA USUARIOS MATRICULADOS1")) {
            this.xjifuser_envio = new JIFConsultasUsuarioEnv("jifconsultausuario");
            Principal.cargarPantalla(this.xjifuser_envio);
            return;
        }
        if (frm.equals("Auditoria de Triage")) {
            this.jifauditoriatriage = new JIFAuditoriaTriage("jifauditoriatriage1");
            Principal.cargarPantalla(this.jifauditoriatriage);
            return;
        }
        if (frm.equals("DemandasNA")) {
            this.xJIFDemandaNoAtendidas = new JIFDemandaNoAtendidas("xjifdemandana");
            Principal.cargarPantalla(this.xJIFDemandaNoAtendidas);
            return;
        }
        if (frm.equals("Bateria Sicosocial")) {
            this.xJIFResultadoBateria = new JIFResultadoBateria();
            Principal.cargarPantalla(this.xJIFResultadoBateria);
            return;
        }
        if (frm.equals("Informe de Citologías")) {
            if (this.xjif_infocitologia != null) {
                this.xjif_infocitologia.dispose();
            }
            this.xjif_infocitologia = new JIFPyP_InformesC("xjif_pyp_informes1", frm.toUpperCase());
            Principal.cargarPantalla(this.xjif_infocitologia);
            this.xjif_infocitologia.moveToFront();
            return;
        }
        if (frm.equals("Reporte Audiometría")) {
            this.xJIFGenericoxFecha = new JIFGenericoxFecha("xAudiometria", "Reporte resultados audiometrias");
            Principal.cargarPantalla(this.xJIFGenericoxFecha);
            return;
        }
        if (frm.equals("Reporte Espirometría")) {
            this.xJIFGenericoxFecha = new JIFGenericoxFecha("xEspiromertria", "Reporte resultados espirometrías");
            Principal.cargarPantalla(this.xJIFGenericoxFecha);
            return;
        }
        if (frm.equals("Reporte Espirometría1")) {
            this.xJIFGenericoxFecha = new JIFGenericoxFecha("xEspiromertria1", "Reporte resultados espirometrías");
            Principal.cargarPantalla(this.xJIFGenericoxFecha);
            return;
        }
        if (frm.equals("Somnolencia")) {
            this.xJIFGenericoxFecha = new JIFGenericoxFecha("xSomnolencia", "Informe Somnolencia");
            Principal.cargarPantalla(this.xJIFGenericoxFecha);
            return;
        }
        if (frm.equals("Consolidado de Información")) {
            this.xJIFInformes = new JIFInformes("Consolidado de Información");
            Principal.cargarPantalla(this.xJIFInformes);
            return;
        }
        if (frm.equals("Consultadores Crónicos Por Especialidad")) {
            this.xJIFInformes = new JIFInformes("Consultadores Crónicos Por Especialidad");
            Principal.cargarPantalla(this.xJIFInformes);
            return;
        }
        if (frm.equals("Facturación - Atención Médica Programada")) {
            this.jifautoriatiempo = new JIFAuditoriaTiemposInf(1, frm.toUpperCase());
            Principal.cargarPantalla(this.jifautoriatiempo);
            return;
        }
        if (frm.equals("Resolucion2175")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Resolución 2175");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Resolucion1552")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Resolución 1552");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Reporte Medicina del Deporte")) {
            this.xJIFGenericoxFecha = new JIFGenericoxFecha("xDeportologia", "Reporte Evaluación Medicina del Deporte");
            Principal.cargarPantalla(this.xJIFGenericoxFecha);
            return;
        }
        if (frm.equals("Informe Tratamientos")) {
            this.xJIFIndiOdontologia = new JIFIndiOdontologia();
            Principal.cargarPantalla(this.xJIFIndiOdontologia);
            return;
        }
        if (frm.equals("RegEventoAdverso")) {
            this.xJIFFEventoAdverso = new JIFFEventoAdverso();
            Principal.cargarPantalla(this.xJIFFEventoAdverso);
            return;
        }
        if (frm.equals("Resolucion256")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Resolución 256");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Circular014")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Circular 014");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Circular014FT025")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Circular 000014 (FT025)");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Informe Circular 015(Formato ST006)")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Circular 015(Formato ST006)");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Informe Salida Administrativa")) {
            this.xJIF_InformeSalidaAdministrativa = new JIFInformeSalidaAdministrativa("Informe Salida Administrativa");
            Principal.cargarPantalla(this.xJIF_InformeSalidaAdministrativa);
            return;
        }
        if (frm.equals("Circular015")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Circular Externa 015");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Resolucion1552")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Resolución 1552");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("SC Análisis Evento Adverso")) {
            this.xJIFF_SC_EventoAdversoAnalisis = new JIFF_SC_EventoAdversoAnalisis(true);
            Principal.cargarPantalla(this.xJIFF_SC_EventoAdversoAnalisis);
            return;
        }
        if (frm.equals("Agudeza Visual")) {
            this.xJIFFConsultasPyP = new JIFFConsultasPyP("agudezaVisual", frm);
            Principal.cargarPantalla(this.xJIFFConsultasPyP);
            return;
        }
        if (frm.equals("Planificación Familiar")) {
            this.xJIFFConsultasPyP = new JIFFConsultasPyP("planificacionFamiliar", frm);
            Principal.cargarPantalla(this.xJIFFConsultasPyP);
            return;
        }
        if (frm.equals("Joven Sano")) {
            this.xJIFFConsultasPyP = new JIFFConsultasPyP("jovenSano", frm);
            Principal.cargarPantalla(this.xJIFFConsultasPyP);
            return;
        }
        if (frm.equals("Adulto Sano")) {
            this.xJIFFConsultasPyP = new JIFFConsultasPyP("adultoSano", frm);
            Principal.cargarPantalla(this.xJIFFConsultasPyP);
            return;
        }
        if (frm.equals("Crecimiento y Desarrollo")) {
            this.xJIFFConsultasPyP = new JIFFConsultasPyP("crecimientoYDesarrollo", frm);
            Principal.cargarPantalla(this.xJIFFConsultasPyP);
            return;
        }
        if (frm.equals("Actas")) {
            this.xJIFActas = new JIFActas();
            Principal.cargarPantalla(this.xJIFActas);
            return;
        }
        if (frm.equals("xjiffSesionesXTrabajdor")) {
            this.xJIFF_InformeSesionesXTrabajador = new JIFF_InformeSesionesXTrabajador();
            Principal.cargarPantalla(this.xJIFF_InformeSesionesXTrabajador);
            return;
        }
        if (frm.equals("Consultar Panoramas de Eventos Adversos")) {
            this.xJIFConsultarPanoramaEventoAdverso = new JIFConsultarPanoramaEventoAdverso();
            Principal.cargarPantalla(this.xJIFConsultarPanoramaEventoAdverso);
            return;
        }
        if (frm.equals("Cita No Asignada")) {
            this.xJIFConsultarNovedad = new JIFConsultarNovedad();
            Principal.cargarPantalla(this.xJIFConsultarNovedad);
            return;
        }
        if (frm.equals("Consultar Casos de Seguridad Clinica")) {
            this.xJIFF_SC_EventoAdversoAnalisis = new JIFF_SC_EventoAdversoAnalisis(false);
            Principal.cargarPantalla(this.xJIFF_SC_EventoAdversoAnalisis);
            return;
        }
        if (frm.equals("Información Riesgo Cardiovascular")) {
            this.xJIFInformesSo = new JIFInformesSo("Información Riesgo Cardiovascular", "xjif_informeSo_SGC");
            Principal.cargarPantalla(this.xJIFInformesSo);
            return;
        }
        if (frm.equals("Informe NOMA")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe NOMA", "xjifinformegenericoso");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe Audiometría")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe Audiometría", "xjifinformegenericoso");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe Espirometría")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe Espirometría", "xjifinformegenericoso");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe Espirometría1")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe Espirometría1", "xjifinformegenericoso");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe Visiometria")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe Visiometria", "xjifinformegenericoso");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe Oportunidad Atencion 1552")) {
            this.xJIFInforme015OportunidadAtencionv1 = new JIFInforme015OportunidadAtencionv1();
            Principal.cargarPantalla(this.xJIFInforme015OportunidadAtencionv1);
            return;
        }
        if (frm.equals("Informe Medicamentos Sivigila")) {
            this.xJIFInformeMedicamentosSivigilia = new JIFInformeMedicamentosSivigilia();
            Principal.cargarPantalla(this.xJIFInformeMedicamentosSivigilia);
            return;
        }
        if (frm.equals("Informe Estadistiaca Citas PyP")) {
            this.xJIFEstadisticaCitas = new JIFEstadisticaCitas();
            Principal.cargarPantalla(this.xJIFEstadisticaCitas);
            return;
        }
        if (frm.equals("Informe SISMED")) {
            this.xJIFFConsultarSIMEDTrimestral = new JIFFConsultarSISMEDTrimestral();
            Principal.cargarPantalla(this.xJIFFConsultarSIMEDTrimestral);
            return;
        }
        if (frm.equals("Informe Planificacion Familias")) {
            this.xPlanificacion_Familias_AIC_clinica_pajonal = new JIFF_Planificacion_Familias_AIC_clinica_pajonal();
            Principal.cargarPantalla(this.xPlanificacion_Familias_AIC_clinica_pajonal);
            return;
        }
        if (frm.equals("Total dias hospitalizados")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Total dias hospitalizados");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Informe de camas")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Informe de camas");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Pacientes ingresados")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Pacientes ingresados");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Pacientes egresados")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Pacientes egresados");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Citas no programadas consulta externa")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Citas no programadas consulta externa");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Citas programadas")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion = new JIFF_ConsultarInformacionGenericaHospitalizacion("Citas programadas");
            Principal.cargarPantalla(this.xJIFF_ConsultarInformacionGenericaHospitalizacion);
            return;
        }
        if (frm.equals("Actualizar Referencia de Consulta")) {
            this.xjifconsnutricion = new JIFRefConsultaNutricion("xjifAReferenciac");
            Principal.cargarPantalla(this.xjifconsnutricion);
            return;
        }
        if (frm.equals("Informe pacientes facturados con finalidad")) {
            this.xJIFF_InformePacientesFacturadosConFinalidad = new JIFF_InformePacientesFacturadosConFinalidad();
            Principal.cargarPantalla(this.xJIFF_InformePacientesFacturadosConFinalidad);
            return;
        }
        if (frm.equals("IndicadoresGeneralesOdont")) {
            this.xJIFFIndicadoresGenerales = new JIFFIndicadoresGenerales();
            Principal.cargarPantalla(this.xJIFFIndicadoresGenerales);
            return;
        }
        if (frm.equals("Medicamentos Entregados")) {
            this.xJIF_MedicamentosEntregadosPorEPS = new JIF_MedicamentosEntregadosPorEPS();
            Principal.cargarPantalla(this.xJIF_MedicamentosEntregadosPorEPS);
            return;
        }
        if (frm.equals("Ejecucion presupuestal")) {
            this.xJIFF_EjecucionPresupuestalPorFecha = new JIFF_EjecucionPresupuestalPorFecha();
            Principal.cargarPantalla(this.xJIFF_EjecucionPresupuestalPorFecha);
            return;
        }
        if (frm.equals("Reportes Diarios Consultas")) {
            this.xJIF_RConsultasMedicasDiarias = new JIF_RConsultasMedicasDiarias();
            Principal.cargarPantalla(this.xJIF_RConsultasMedicasDiarias);
            return;
        }
        if (frm.equals("Resolucion 2193")) {
            this.xJIF_RProduccionRes2193 = new JIF_RProduccionRes2193();
            Principal.cargarPantalla(this.xJIF_RProduccionRes2193);
            return;
        }
        if (frm.equals("Producción (Resolución 2193)") || frm.equals("Consolidado Egresos por Edades") || frm.equals("Producción (Resolución 2193) Entidad Privada")) {
            this.produccionRes2193_V1 = new JIF_RProduccionRes2193_V1(frm);
            Principal.cargarPantalla(this.produccionRes2193_V1);
            return;
        }
        if (frm.equals("Informe Remisiones")) {
            this.xJIF_RRemisiones = new JIF_RRemisiones();
            Principal.cargarPantalla(this.xJIF_RRemisiones);
            return;
        }
        if (frm.equals("Informe de Cronicos")) {
            this.xJIF_RCronicos = new JIF_RCronicos();
            Principal.cargarPantalla(this.xJIF_RCronicos);
            return;
        }
        if (frm.equals("Informe Diagnostico")) {
            this.xJIF_Informe_Diagnostico = new JIF_Informe_Diagnostico();
            Principal.cargarPantalla(this.xJIF_Informe_Diagnostico);
            return;
        }
        if (frm.equals("Consultar Atención por Fecha")) {
            this.xJIF_Consulta_Atencion_por_Fecha = new JIF_Consulta_Atencion_por_Fecha();
            Principal.cargarPantalla(this.xJIF_Consulta_Atencion_por_Fecha);
            return;
        }
        if (frm.equals("Auditoría de Procedimientos Facturados Rips")) {
            this.xJIF_Auditoria_Procedimientos_Facturados_Rips = new JIF_Auditoria_Procedimientos_Facturados_Rips();
            Principal.cargarPantalla(this.xJIF_Auditoria_Procedimientos_Facturados_Rips);
            return;
        }
        if (frm.equals("Auditoría de Medicamentos Facturados Rips")) {
            this.xJIF_Auditoria_Medicamentos_Facturados_Rips = new JIF_Auditoria_Medicamentos_Facturados_Rips();
            Principal.cargarPantalla(this.xJIF_Auditoria_Medicamentos_Facturados_Rips);
            return;
        }
        if (frm.equals("Informes PyP")) {
            this.xJIF_Reportes_PyP_Generico = new JIF_Reportes_PyP_Generico(1, "INFORMES PYP", "jif_ReportesPyP");
            Principal.cargarPantalla(this.xJIF_Reportes_PyP_Generico);
            return;
        }
        if (frm.equals("Número de Atenciones por Servicio")) {
            this.genericoFiltroFechaCombo = new JIFInformesGenericoFiltroFechaCombo("Número de Atenciones por Servicio", "jifinformegenericofechas");
            Principal.cargarPantalla(this.genericoFiltroFechaCombo);
            return;
        }
        if (frm.equals("Informe Citologias")) {
            this.xJIF_Reportes_Generico = new JIF_Reportes_Generico("Citologias");
            Principal.cargarPantalla(this.xJIF_Reportes_Generico);
            return;
        }
        if (frm.equals("Morbilidad Consulta Externa")) {
            this.estadisticaMorbilidadMortalidad = new JIFEstadisticaMorbilidadMortalidad(frm, 0);
            Principal.cargarPantalla(this.estadisticaMorbilidadMortalidad);
            return;
        }
        if (frm.equals("Morbilidad Por Servicio")) {
            this.estadisticaMorbilidadMortalidad = new JIFEstadisticaMorbilidadMortalidad(frm, 1);
            Principal.cargarPantalla(this.estadisticaMorbilidadMortalidad);
            return;
        }
        if (frm.equals("Mortalidad Por Servicio")) {
            this.estadisticaMorbilidadMortalidad = new JIFEstadisticaMorbilidadMortalidad(frm, 2);
            Principal.cargarPantalla(this.estadisticaMorbilidadMortalidad);
            return;
        }
        if (frm.equals("Resolucion1552CajaCopi")) {
            this.xjif_inresoluciones = new JIF_Informes_GResoluciones("Informe Resolución 1552 (CajaCopi)");
            Principal.cargarPantalla(this.xjif_inresoluciones);
            return;
        }
        if (frm.equals("Resolucion202")) {
            this.xjifres4505 = new JIFConsultarInfR4505("202");
            Principal.cargarPantalla(this.xjifres4505);
            return;
        }
        if (frm.equals("ReportesDeFacturacion")) {
            this.xJIF_Reportes_PyP_Generico = new JIF_Reportes_PyP_Generico(1, "INFORMES SGC", "jif_ReportesPyP");
            Principal.cargarPantalla(this.xJIF_Reportes_PyP_Generico);
            return;
        }
        if (frm.equals("Informe de Interconsultas") || frm.equals("Reingreso antes de 72 Horas")) {
            this.xJIFInformeInterconsultas = new JIFInformeInterconsultas(frm);
            Principal.cargarPantalla(this.xJIFInformeInterconsultas);
            return;
        }
        if (frm.equals("Información de Facturación Agrupada")) {
            this.informeConsolidadoPypFinalidad = new JIFInformeConsolidadoPypFinalidad("jifInformeConsoliadoPorFinalidad1", frm.toUpperCase());
            Principal.cargarPantalla(this.informeConsolidadoPypFinalidad);
            return;
        }
        if (frm.equals("Seguimiento a servicios ambulatorios")) {
            this.ambulatorio = new JIFSeguimientoAmbulatorio(frm);
            Principal.cargarPantalla(this.ambulatorio);
        } else if (frm.equals("AutoGestión servicios ambulatorios")) {
            this.ambulatorio = new JIFSeguimientoAmbulatorio(frm);
            Principal.cargarPantalla(this.ambulatorio);
        } else if (frm.equals("Gestion Ordenes Dynamicos")) {
            this.jifgestionordenesdynamicos = new JIFGestionOrdenesDynamicos();
            Principal.cargarPantalla(this.jifgestionordenesdynamicos);
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifsgcconfiguracionuno":
                this.xfrmConfiguracionUno.grabar();
                break;
            case "jifsgcconfiguracioncdos":
                this.xfrmConfiguracionCDos.grabar();
                break;
            case "jifgestionsolicitudes":
                this.jifgestionsol.mGrabar();
                break;
            case "xjifregistroencuesta3":
                this.xjifregistroencuesta.mGrabar();
                break;
            case "xjifreportenc1":
            case "xjifreportenc2":
                this.xjifreportenc.mGrabar();
                break;
            case "xjifficha5w1h":
                this.xjifficha5w1h.mGrabar();
                break;
            case "xjifregistroindicadores":
                this.xjifregistroindicadores.mGrabar();
                break;
            case "xjifreferenciac3":
                this.xjifconsnutricion.mGrabar();
                break;
            case "jifactas":
                this.xJIFActas.mGrabar();
                break;
            case "xjifregistroreuniones":
                this.xJIFRegistroReuniones.mGrabar();
                break;
            case "jifCargueInformacionEntidades":
                this.cargarBaseEntidades.grabar();
                break;
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("jifsgcconfiguracionuno")) {
            this.xfrmConfiguracionUno.nuevo();
            return;
        }
        if (frm.equals("xjif_informescasosseguridadclinica")) {
            this.xjifconsolidadoseguridadclinica.mNuevo();
            return;
        }
        if (frm.equals("jifsgcconfiguracioncdos")) {
            this.xfrmConfiguracionCDos.nuevo();
            return;
        }
        if (frm.equals("xjif_consultarinformes_eps")) {
            this.xjifinformeeps.mNuevo();
            return;
        }
        if (frm.equals("jifgestionsolicitudes")) {
            this.jifgestionsol.mNuevo();
            return;
        }
        if (frm.equals("xjifregistroencuesta3")) {
            this.xjifregistroencuesta.mNuevo(1);
            return;
        }
        if (frm.equals("jifconsultarinforlab1")) {
            this.xjifconsultainflabproc.mNuevo();
            return;
        }
        if (frm.equals("xjifreportenc1")) {
            this.xjifreportenc.mNuevo();
            return;
        }
        if (frm.equals("xjifficha5w1h")) {
            this.xjifficha5w1h.mNuevo();
            return;
        }
        if (frm.equals("xjifregistroindicadores")) {
            this.xjifregistroindicadores.mNuevo();
            return;
        }
        if (frm.equals("xjifconsolidadomovimiento2")) {
            this.xjifinformeconsmovimiento.mNuevo();
            return;
        }
        if (frm.equals("jifinformacioncove")) {
            this.xjifconsultarcove.mNuevo();
            return;
        }
        if (frm.equals("xjifplacasdanadas")) {
            this.xjifconsultarinf2tablas.mNuevo();
            return;
        }
        if (frm.equals("jifinformeplacas")) {
            this.xjifinformeplacas.mNuevo();
            return;
        }
        if (frm.equals("xjiffasignacioncitas")) {
            this.xjifconsultar1comtabla.mNuevo();
            return;
        }
        if (frm.equals("xjifinformacionxespecialidad")) {
            this.xjifconsulta1tablar.mNuevo();
            return;
        }
        if (frm.equals("xjifestudiosrealizados")) {
            this.xjifinformeplacas.mNuevo();
            return;
        }
        if (frm.equals("xjifinformesupersalud")) {
            this.xjifinformesupersalud.mNuevo();
            return;
        }
        if (frm.equals("xjifauditoriahcmed") || frm.equals("xjifauditoriahcenfer")) {
            this.xjifauditoriahc.nuevo();
            return;
        }
        if (frm.equals("xjifinformacionr4505")) {
            this.xjifres4505.mNuevo();
            return;
        }
        if (frm.equals("jifauditoriatriage1")) {
            this.jifauditoriatriage.mNuevo();
            return;
        }
        if (frm.equals("xjif_consultarinformes_eps")) {
            this.xjifinformeeps.mNuevo();
            return;
        }
        if (frm.equals("xjif_pyp_informes1")) {
            this.xjif_infocitologia.mNuevo();
            return;
        }
        if (frm.equals("xjifconsultas_informes_p") || frm.equals("xjifconsultas_informes_p1")) {
            this.xjifc_informacion_p.mNuevo();
            return;
        }
        if (frm.equals("agudezaVisual") || frm.equals("planificacionFamiliar") || frm.equals("jovenSano") || frm.equals("adultoSano") || frm.equals("crecimientoYDesarrollo")) {
            this.xJIFFConsultasPyP.mNuevo();
            return;
        }
        if (frm.equals("jifactas")) {
            this.xJIFActas.mNuevo();
            return;
        }
        if (frm.equals("xjiffSesionesXTrabajdor")) {
            this.xJIFF_InformeSesionesXTrabajador.mNuevo();
            return;
        }
        if (frm.equals("xjifconsultarpanoramaeventos")) {
            this.xJIFConsultarPanoramaEventoAdverso.mNuevo();
            return;
        }
        if (frm.equals("xJIFConsultarNovedad")) {
            this.xJIFConsultarNovedad.mNuevo();
            return;
        }
        if (frm.equals("xjifinformegenericoso")) {
            this.xJIFInformesGenericoSO.mNuevo();
            return;
        }
        if (frm.equals("xjifregistroreuniones")) {
            this.xJIFRegistroReuniones.mNuevo();
            return;
        }
        if (frm.equals("jiFOportunidadAtencion")) {
            this.xJIFInforme015OportunidadAtencionv1.mNuevo();
            return;
        }
        if (frm.equals("jIFInformeMedicamentosSivigilia")) {
            this.xJIFInformeMedicamentosSivigilia.mNuevo();
            return;
        }
        if (frm.equals("xJIFEstadisticaCitas")) {
            this.xJIFEstadisticaCitas.mNuevo();
            return;
        }
        if (frm.equals("jiffConsultarSIMEDTrimestral")) {
            this.xJIFFConsultarSIMEDTrimestral.mNuevo();
            return;
        }
        if (frm.equals("jiff_planificacion_Familias_AIC_clinica_pajonal")) {
            this.xPlanificacion_Familias_AIC_clinica_pajonal.mNuevo();
            return;
        }
        if (frm.equals("jiff_ConsultarInformacionGenericaHospitalizacion")) {
            this.xJIFF_ConsultarInformacionGenericaHospitalizacion.mNuevo();
            return;
        }
        if (frm.equals("jiff_InformePacientesFacturadosConFinalidad")) {
            this.xJIFF_InformePacientesFacturadosConFinalidad.mNuevo();
            return;
        }
        if (frm.equals("jiff_EjecucionPresupuestalPorFecha")) {
            this.xJIFF_EjecucionPresupuestalPorFecha.mNuevo();
            return;
        }
        if (frm.equals("jifCargueInformacionEntidades")) {
            this.cargarBaseEntidades.nuevo();
            return;
        }
        if (frm.equals("jifinformegenericofechas")) {
            this.genericoFiltroFechaCombo.nuevo();
            return;
        }
        if (frm.equals("jif_ReporteProduccion2193_V1")) {
            this.produccionRes2193_V1.nuevo();
        } else if (frm.equals("jifmorbilidad_mortalidad")) {
            this.estadisticaMorbilidadMortalidad.nuevo();
        } else if (frm.equals("jifgestionordenes")) {
            this.jifgestionordenesdynamicos.mNuevo();
        }
    }

    public void anular(String frm) {
        if (frm.equals("jiffAnalisisEventoAdverso")) {
            this.xJIFF_SC_EventoAdversoAnalisis.mAnular();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("jifinformespyp")) {
            this.xjifinforme.mImprimeMorb();
            return;
        }
        if (frm.equals("jiffAnalisisEventoAdverso")) {
            this.xJIFF_SC_EventoAdversoAnalisis.mImprimir();
            return;
        }
        if (frm.equals("jifactas")) {
            this.xJIFActas.mImprimir();
            return;
        }
        if (frm.equals("xjifconsultarpanoramaeventos")) {
            this.xJIFConsultarPanoramaEventoAdverso.mImprimir();
        } else if (!frm.equals("xjifregistroreuniones") && frm.equals("jifInformeConsoliadoPorFinalidad1")) {
            this.informeConsolidadoPypFinalidad.impimir();
        }
    }
}
