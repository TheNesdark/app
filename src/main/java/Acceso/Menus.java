package Acceso;

import Activos.claseGActivos;
import Autorizaciones.Autoriza;
import Citas.ReporteCitas;
import General.Acercade;
import Sgc.claseSgc;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/Menus.class */
public class Menus extends JPanel {
    private ConsultasMySQL ConsultasMysql = new ConsultasMySQL();
    Principal xjp;
    private JMenu JIMA_Informes;
    private JMenu JIMIInformesCp;
    private JMenu JIMIInformesRx;
    private JMenu JIMIPrincipal;
    private JMenu JIMIPrincipalCp;
    private JMenu JIMIPrincipalCp1;
    private JMenu JIMIUtilidades;
    private JMenu JIMInformes;
    private JMenuItem JIMRInformesGenerales;
    private JMenuItem JIMRUInfomeLecturaUsuario;
    private JMenuItem JIMRULecturaOit;
    private JMenuItem JIMRUNotasIma;
    private JMenu JIMUtilidadesC;
    private JMenu JMAPrincipal;
    public JMenu JMActividadesPyP;
    private JMenu JMActivos;
    public static JMenu JMAgendaSeparada;
    private JMenu JMAtencion;
    private JMenuItem JMAuditoriaMp;
    private JMenuItem JMAutorizacion;
    private JMenu JMAyuda;
    private JMenu JMAyuda1;
    private JMenu JMAyuda5;
    public static JMenuBar JMBAdministracionNomina;
    public static JMenuBar JMBInformesV;
    private JMenu JMBMatriculaUsuarios;
    public static JMenuBar JMBOdontologia;
    private JMenu JMBPolimedicado;
    public static JMenuBar JMBSo;
    private JMenu JMBienes;
    private JMenu JMCAuditoria;
    private JMenu JMCCajaM;
    private JMenuItem JMCConsolidadoContrato;
    private JMenuItem JMCConsultarEstado;
    private JMenuItem JMCConsultarEstadoS;

    /* JADX INFO: renamed from: JMCCotización, reason: contains not printable characters */
    private JMenuItem f0JMCCotizacin;
    private JMenu JMCCuentaC;
    private JMenuItem JMCEvaluada;
    private JMenu JMCFactura;
    private JMenuItem JMCIProcesos;
    private JMenuItem JMCIProcxTipo;
    private JMenuItem JMCITipoProceso;
    private JMenuItem JMCInformeCGR;
    private JMenuItem JMCInformeGenerales;
    private JMenu JMCInformes;
    private JMenu JMCReembolso;
    private JMenuItem JMCSolicitud;
    private JMenuItem JMCSolicitudC;
    private JMenuItem JMCSolicitudS;
    private JMenu JMCUAnularDocXCCobro;
    private JMenu JMConfiguracion;
    private JMenuItem JMConstanciaAten;
    private JMenu JMContratos;
    private JMenuItem JMCopiaDocumentos;
    private JMenu JMCxInformes;
    private JMenu JMCxInformes1;
    private JMenu JMCxPrincipal;
    private JMenu JMCxPrincipal1;
    private JMenu JMEPrincipal;
    private JMenu JMEncuesta;
    private JMenu JMEstadistica;
    private JMenu JMEstadistica1;
    private JMenu JMExportacion;
    public static JMenu JMFCaja;
    private JMenu JMFIngresoSOAT;
    private JMenu JMFUtilidades;
    private JMenu JMGAInformes;
    private JMenu JMGAPrincipal;
    private JMenuItem JMGCCG_PagosGrupales;
    private JMenuItem JMGCCGestion;
    private JMenu JMGCCartera;
    private JMenuItem JMGDeduccionConceptos;
    private JMenu JMGMAuditoria;
    private JMenuItem JMGReporte;
    private JMenu JMG_Nomina;
    private JMenu JMG_Nomina1;
    private JMenu JMGastos;
    private JMenu JMGestion;
    private JMenu JMGestion1;
    private JMenu JMGestion2;
    private JMenu JMGestion3;
    private JMenu JMGestionAM;
    private JMenuItem JMGestionEmpleado;
    private JMenu JMGestionFaltantes;
    private JMenu JMGestionQrs;
    private JMenuItem JMHReporte;
    private JMenu JMHojadeVida;
    private JMenuItem JMIAAcercade;
    private JMenuItem JMIAAcercade1;
    private JMenuItem JMIAAcercade4;
    private JMenuItem JMIAAutorizacionDoc;
    private JMenuItem JMIACapitacion1;
    private JMenuItem JMIACapitacionG;
    private JMenuItem JMIACapitacionServicio;
    private JMenuItem JMIAGEventoServicio;
    private JMenuItem JMIAInformesGenerales;
    private JMenuItem JMIANRReporteHExtras;
    private JMenuItem JMIAOrdenFactura;
    private JMenuItem JMIAProcedimientosA;
    private JMenu JMIA_InfCartera;
    private JMenu JMIA_Produccion;
    public JMenuItem JMIAgendaCE;
    public static JMenuItem JMIAgendaN;
    public static JMenuItem JMIAgendaN1;
    public static JMenuItem JMIAgendaNSO;
    private JMenuItem JMIAgendaRx;
    private JMenuItem JMIAgendaRx2;
    public static JMenuItem JMIAgendaServicios;
    public JMenuItem JMIAgendaServiciosBeta;
    private JMenuItem JMIAlertaxUsuario;
    private JMenuItem JMIAnulaDoc;
    private JMenuItem JMIAnularProgramacion;
    private JMenuItem JMIArchivarDocs;
    private JMenuItem JMIAsignacionCNP;
    private JMenuItem JMIAsignacion_AtencionE;
    private JMenuItem JMIBalanceContable;
    private JMenuItem JMIBalanceContable1;
    private JMenuItem JMIBalanceContable2;
    public JMenuItem JMICCierre;
    private JMenuItem JMICConsultar_Tiempo;
    private JMenuItem JMICCuentaCobroA;
    private JMenuItem JMICCuentaCobroM;
    private JMenuItem JMICDocumentoC;
    private JMenuItem JMICExportar;
    public JMenuItem JMICGPago;
    private JMenuItem JMICGPago1;
    private JMenuItem JMICGasto;
    private JMenu JMICGenerar;
    public JMenuItem JMICIEjecucionP;
    public JMenuItem JMICI_ConsultarEstadoFacturas;
    private JMenuItem JMICInformesGenerales;
    private JMenuItem JMICLibroGeneral;
    private JMenuItem JMICLibroRangoCuenta;
    private JMenuItem JMICLibroTerceros;
    private JMenuItem JMICPRConsolidadoRemisiones;
    private JMenuItem JMICPReferencia;
    private JMenuItem JMICPSoporteDigitalizado;
    private JMenuItem JMICPermisoMedicos;
    private JMenuItem JMICRConsolidado;
    private JMenuItem JMICRadicacion;
    private JMenuItem JMICRadicacionNC;
    private JMenuItem JMICRadicacionR;
    private JMenuItem JMICRegistroRecibos;
    private JMenuItem JMICRegistroRecibosCM;
    private JMenuItem JMICRotacion;
    private JMenuItem JMICSeleccionC;
    private JMenuItem JMICSeleccionC1;
    private JMenuItem JMICSolicitudR;
    private JMenuItem JMICSolicitudRCM;
    private JMenuItem JMICargueInicial;
    private JMenu JMICertificado;
    private JMenu JMICoagulacion;
    private JMenuItem JMICompromisoBeta;
    private JMenuItem JMICompromisoPTO;
    private JMenuItem JMIConsolidadoLectura;
    private JMenuItem JMIConstanciaAsistencia;
    private JMenuItem JMIConsultarADx;
    private JMenuItem JMIConsultarADx1;
    private JMenuItem JMIConsultarAcronimos;
    private JMenuItem JMIConsultarAcronimos1;
    private JMenuItem JMIConsultarAgendaEnfermeria;
    private JMenuItem JMIConsultarAtenciones;
    private JMenuItem JMIConsultarAyudasDx;
    private JMenuItem JMIConsultarAyudasDx1;
    private JMenuItem JMIConsultarCitasUsuario;
    private JMenuItem JMIConsultarCprogramada;
    private JMenuItem JMIConsultarEstadoO;
    private JMenuItem JMIConsultarHC;
    private JMenuItem JMIConsultarHC1;
    private JMenuItem JMIConsultarHc;
    private JMenuItem JMIConsultarHc1;
    private JMenuItem JMIConsultarIncapacidad;
    private JMenuItem JMIConsultarLecturaRx;
    private JMenuItem JMIConsultarMovimientoDocClinico;
    private JMenuItem JMIConsultarOrdRem;
    private JMenuItem JMIConsultarRemOrd;
    private JMenuItem JMIConsultarRemOrdC;
    private JMenuItem JMIConsultarResultado;
    private JMenuItem JMIConsultarResultadoExa;
    private JMenuItem JMIConsultarResultadoExa1;
    private JMenuItem JMIConsultarResultadoG;
    private JMenuItem JMIConsultarResultadoUsuario;
    private JMenuItem JMIConsultarResultadoUsuario1;
    private JMenuItem JMIConsultarResultadoUsuario2;
    private JMenu JMIContratos;
    private JMenuItem JMICopiasDoc;
    private JMenuItem JMICuentasxPagar;
    private JMenuItem JMIDEstadoResultado;
    private JMenuItem JMIDMedios;
    private JMenuItem JMIDMedios1;
    private JMenuItem JMIDeclaracionAntecedentes;
    private JMenuItem JMIDecreto2193;
    private JMenuItem JMIDisponibilidad;
    private JMenuItem JMIDisponibilidad1;
    private JMenuItem JMIDisponibilidad2;
    private JMenuItem JMIDisponibilidad3;
    private JMenuItem JMIDocDescuadrados;
    private JMenuItem JMIEAutoplex;
    private JMenuItem JMIEBiosystemA15;
    private JMenuItem JMIEBiosystemA25;
    private JMenuItem JMIECM250;
    private JMenuItem JMIECargarS;
    private JMenuItem JMIECobase411;
    private JMenuItem JMIEDL96II;
    private JMenuItem JMIERegistroE;
    private JMenuItem JMIESTASatellite1;
    private JMenuItem JMIESoInfAyD;
    private JMenuItem JMIESoTFatiga;
    private JMenuItem JMIEWienerLabCB400i;
    private JMenuItem JMIEWienerLabCB400i2;
    private JMenuItem JMIEjecucionPtal;
    private JMenuItem JMIEjecucionPtalPeriodo;
    private JMenu JMIEquipoEspecializados;
    private JMenu JMIEquipoHematologia;
    private JMenu JMIEquipoHormonas;
    private JMenu JMIEquipoMicrobiologia;
    private JMenu JMIEquipoOrinas;
    private JMenu JMIEquipoQuimica;
    private JMenu JMIEquipoQuimica1;
    private JMenuItem JMIEstadoFinancieroComp;
    private JMenuItem JMIFEncabezado;
    private JMenuItem JMIFExportarExcelPDF;
    private JMenuItem JMIFInfOportunidad;
    private JMenuItem JMIFInfhospitalizados;
    private JMenuItem JMIFInfhospitalizados1;
    private JMenuItem JMIFListFacturas1;
    private JMenuItem JMIFListFacturasArm1;
    private JMenuItem JMIFListaChequeo;
    private JMenuItem JMIFPFacturasPE;
    private JMenuItem JMIFPFacturasPE1;
    private JMenuItem JMIFPFacturasPE2;
    private JMenuItem JMIFPFacturasPE3;
    private JMenuItem JMIFReorganizacionF1;
    private JMenuItem JMIFReorganizacionF2;
    private JMenuItem JMIFUCConciliacionC;
    private JMenuItem JMIGAActivos;
    private JMenuItem JMIGAInformeActivos;
    private JMenuItem JMIGAM_AuditoriaAdministracion;
    private JMenuItem JMIGAM_AuditoriaConcurrente;
    private JMenuItem JMIGAM_AuditoriaFacturas;
    private JMenuItem JMIGInformesGenerales;
    private JMenuItem JMIGN_Causacion;
    private JMenuItem JMIGN_ConsolidadoConceptosRH;
    private JMenuItem JMIGN_ConsolidadoPersonal;
    private JMenuItem JMIGN_ConsultarNominaIntervaloFecha;
    private JMenuItem JMIGN_ConsultarPlanillas;
    private JMenuItem JMIGN_InformeCGR;
    private JMenuItem JMIGN_LiquidacionN;
    private JMenuItem JMIGN_LiquidacionNueva;
    private JMenuItem JMIGRegistro;
    private JMenuItem JMIGSeguimiento;
    private JMenu JMIGasto;
    private JMenuItem JMIGestion_CACervix;
    private JMenuItem JMIGestion_Procedimientos;
    private JMenuItem JMIIActualizarPendientes;
    private JMenuItem JMIIAdicionarProdc;
    private JMenuItem JMIIAuditoriasAleatorias;
    private JMenuItem JMIIBiosystemA25;
    private JMenuItem JMIICombilyzer3;
    private JMenuItem JMIIConciliacionInv;
    private JMenuItem JMIIDiruiH;
    private JMenuItem JMIIFormulacionMedica;
    private JMenuItem JMIIFormulasGeneradas;
    private JMenuItem JMIIHL7Infinity;
    private JMenuItem JMIIHematologia;
    private JMenuItem JMIIHematologia1;
    private JMenuItem JMIIInformesGenerales;
    private JMenuItem JMIIKardex;
    private JMenuItem JMIIKardexI;
    public JMenuItem JMIIKardex_P;
    private JMenuItem JMIILibroMayor;
    private JMenuItem JMIIModificarCodAg;
    private JMenuItem JMIIModificarMPM;
    private JMenuItem JMIIQHumastar80;
    private JMenuItem JMIIRepBodegas;
    private JMenuItem JMIIResultadoExternos;
    private JMenuItem JMIIRiesgoC;
    private JMenuItem JMIISoporteLote;
    private JMenuItem JMII_InformeSeguimiento;
    private JMenuItem JMII_InformesGenerales;
    private JMenuItem JMIImportarAyudasDx;
    private JMenuItem JMIImportarAyudasDx1;
    private JMenuItem JMIInformeCGR;
    public JMenuItem JMIInformeContraloria;
    private JMenuItem JMIInformeDespacho;
    public JMenu JMIInformeFinancieros;
    private JMenuItem JMIInformeGenerale;
    private JMenuItem JMIInformeTipoImpuesto;
    private JMenuItem JMIInformeTipoImpuesto1;
    private JMenuItem JMIInformeTipoImpuesto2;
    private JMenu JMIInformes;
    private JMenuItem JMIInformesAutorizacion;
    private JMenuItem JMIInformesGenerales;
    private JMenuItem JMIInformesIngresoEventoSoat;
    private JMenuItem JMIInformesIngresoEventoSoat1;
    private JMenuItem JMILInformesGenerales;
    private JMenuItem JMILValidacionAdministrativa;
    private JMenu JMILibroAuxiliar;
    private JMenuItem JMILibroPresupuesto;
    private JMenuItem JMIMAgendaCirugia;
    private JMenuItem JMIMAgendaUnidosis;
    private JMenuItem JMIManualesIng;
    private JMenu JMIMediosDian;
    private JMenuItem JMIMovManual;
    private JMenuItem JMIMovimiento;
    private JMenuItem JMIMovimiento_Tercero;
    private JMenuItem JMIOdontoAgenda;
    private JMenuItem JMIOperacionesM1;
    private JMenu JMIPANReporte;
    public JMenuItem JMIPAgenda_UH;
    public JMenuItem JMIPAgenda_UH1;
    public JMenuItem JMIPAgenda_UH2;
    private JMenuItem JMIPConsultarCPE;
    private JMenuItem JMIPDiabetes;
    private JMenuItem JMIPGestion;
    private JMenuItem JMIPHta;
    private JMenuItem JMIPListaFacturaVenta;
    private JMenuItem JMIPListaOrdenInterna;
    private JMenuItem JMIPSoAtenciones;
    private JMenuItem JMIPSoAutoReportes;
    private JMenuItem JMIPSoCSeguimiento;
    private JMenuItem JMIPSoEstudiosRadiologicos;
    private JMenuItem JMIPSoExaPerioSeguimientoDetalles;
    private JMenuItem JMIPSoFramingham;
    private JMenuItem JMIPSoInfAyD;
    private JMenuItem JMIPSoInformeCIS20;
    private JMenuItem JMIPSoInformeDiagnosticoSalud;
    private JMenuItem JMIPSoInformesGenericos;
    private JMenuItem JMIPSoInformesGenericos1;
    private JMenuItem JMIPSoInformesSistemaVigilancia;
    private JMenuItem JMIPSoReporteAudiometria;
    private JMenuItem JMIPSoReporteEspirometria;
    private JMenuItem JMIPSoReporteEspirometria1;
    private JMenuItem JMIPSoReporteNOMA;
    private JMenuItem JMIPSoReporteVisiometria;
    private JMenuItem JMIPSoRiesgoCV;
    private JMenuItem JMIPSoTFatiga;
    private JMenuItem JMIPSoTRuffier;
    private JMenuItem JMIPSo_Agenda;
    private JMenuItem JMIPSo_Alcohol_Drogra;
    private JMenuItem JMIPSo_Alcohol_DrograE;
    private JMenuItem JMIPSo_Test_Fatiga;
    private JMenuItem JMIPSo_Test_FatigaE;
    private JMenuItem JMIP_AInforme;
    public static JMenuItem JMIP_AgendaN;
    private JMenu JMIP_Alimentacion;
    private JMenuItem JMIP_Circular030;
    private JMenuItem JMIP_ConsolidadoCartera;
    private JMenuItem JMIP_ConsolidadoFE;
    private JMenuItem JMIP_ConsolidadoFF;
    private JMenuItem JMIP_ConsolidadoGlosas;
    private JMenuItem JMIP_ConsolidadoGlosasDefinitivo;
    private JMenuItem JMIP_ConsolidadosDePagos;
    private JMenuItem JMIP_CxProgramacion;
    private JMenuItem JMIP_IProgramacion;
    private JMenuItem JMIP_InformeCartera2193;
    private JMenuItem JMIP_InformeCirugia;
    private JMenuItem JMIP_InformesGenerales;
    private JMenuItem JMIP_InformesPyP;
    private JMenuItem JMIP_SolicitudAlimentacion;
    private JMenuItem JMIPasarCitasxLote;
    private JMenuItem JMIPeriodoContableI;
    private JMenuItem JMIR4505;
    private JMenuItem JMIRActProfesional;
    private JMenuItem JMIRActUsuarios;
    public JMenuItem JMIRActividades;
    private JMenuItem JMIRCaCervix;
    private JMenuItem JMIRConsultarUnidosisAplicada;
    private JMenuItem JMIRDiasAsignacionCita;
    private JMenu JMIRInformes;
    private JMenu JMIRInventario;
    private JMenu JMIRSaludOcupacional;
    private JMenuItem JMIR_ValidarInterfaz;
    private JMenuItem JMIRadicacionFacturasMasiva;
    private JMenuItem JMIRegistroConsultaNP;
    private JMenuItem JMIRegistroDiario;
    private JMenuItem JMIRegistroDiario1;
    private JMenuItem JMIRegistroDiario2;
    private JMenuItem JMIRegistroDiario3;
    private JMenuItem JMIRegistroDiario4;
    private JMenuItem JMIRegistroExamenesA;
    private JMenuItem JMIRegistroIncapac;
    private JMenuItem JMIRegistroInformacionP;
    private JMenuItem JMIRegistroJuntaMedica;
    private JMenuItem JMIRegistroNMedicas;
    private JMenuItem JMIRegistroNMedicas1;
    private JMenuItem JMIRegistroNotas;
    private JMenuItem JMIRegistroReembolso;
    private JMenuItem JMIRegistroVDomiciliarias;
    private JMenuItem JMIRelacionPago;
    private JMenuItem JMIRemOrdenes;
    private JMenuItem JMIRentransmisionResultados;
    private JMenuItem JMISolicitudes;
    private JMenuItem JMITSegValor;
    private JMenuItem JMITiempoRx;
    private JMenuItem JMITipoAgente;
    private JMenuItem JMITipoSeg;
    private JMenuItem JMITipoSistemaVigilancia;
    private JMenuItem JMIUAjustarPuntosSC;
    private JMenuItem JMIUAjusteDoc;
    public static JMenuItem JMIUAjusteDoc1;
    private JMenuItem JMIUAnticipos;
    private JMenuItem JMIUAtencionesManuales;
    private JMenuItem JMIUAtencionesManuales1;
    private JMenuItem JMIUAutorizaciones;
    private JMenuItem JMIUCAutomatico;
    private JMenuItem JMIUCDepreciacion;
    private JMenuItem JMIUCDespachoxEspecialidad;
    private JMenuItem JMIUCFaltatesFecha;
    private JMenuItem JMIUCImpuesto;
    private JMenuItem JMIUCManual;
    private JMenuItem JMIUCPeriodicos;
    private JMenuItem JMIUC_Gestion_Concepto;
    private JMenuItem JMIUCargarDatos;
    private JMenuItem JMIUComentarioA;
    private JMenuItem JMIUConsultarDocTercero;
    private JMenuItem JMIUCuentasCGI;
    private JMenuItem JMIUCuentasGastosR;
    private JMenuItem JMIUDCargarLote;
    private JMenuItem JMIUDGenerarPlantilla;
    private JMenuItem JMIUDPlantillaAplicada;
    private JMenu JMIUDiagnostico;
    private JMenu JMIUDiagnostico1;
    private JMenuItem JMIUDigitacionDx;
    private JMenuItem JMIUDigitacionDx1;
    private JMenuItem JMIUDxMasivo;
    private JMenuItem JMIUEAxamenes;
    private JMenuItem JMIUEAxamenesFEcha;
    private JMenuItem JMIUEHistoriaPdf;
    private JMenuItem JMIUEHistoriaPdf1;
    private JMenuItem JMIUEHistoriaPdf2;
    private JMenu JMIUExportarDHC;
    private JMenu JMIUExportarDHC1;
    private JMenuItem JMIUFormulasPyP;
    private JMenuItem JMIUGPeriodicos;
    private JMenuItem JMIUGSeguimiento;
    private JMenuItem JMIUGTActivar;
    private JMenuItem JMIUGenerarDisfon;
    private JMenuItem JMIUGestionActivos;
    private JMenuItem JMIUGestionExamenes;
    private JMenuItem JMIUGestionExamenes1;
    private JMenuItem JMIUGestionarFaltantes;
    private JMenuItem JMIUGestionarPreposicion;
    private JMenuItem JMIUIFacturas;
    private JMenuItem JMIUIPCrearCuenta;
    private JMenuItem JMIUImportarAyudasdx;
    private JMenuItem JMIUImportarAyudasdx1;
    private JMenu JMIUImportarDHC;
    private JMenu JMIUImportarDHC1;
    private JMenuItem JMIUImportarDxRips;
    private JMenuItem JMIUInformes;
    private JMenuItem JMIUInformesGeneral;
    private JMenuItem JMIUInformesGenerales;
    private JMenuItem JMIUInformesNovedades;
    public static JMenuItem JMIUModificacionDocC;
    private JMenuItem JMIUModificarSolicitud;
    private JMenuItem JMIUMovimientoS;
    private JMenu JMIUNomina;
    private JMenu JMIUNovedadesN;
    private JMenuItem JMIUPeriodoC;
    private JMenuItem JMIUPeriodoF;
    private JMenuItem JMIUPlanCuenta;
    private JMenuItem JMIURGenerar;
    private JMenuItem JMIURGenerar1;
    private JMenuItem JMIURGenerar2;
    public JMenuItem JMIURGenerarRipsCovid;
    private JMenuItem JMIURGenerarRipsExtranjeros;
    private JMenuItem JMIURegistroFac;
    private JMenu JMIURips;
    private JMenuItem JMIUSegAgente;
    private JMenuItem JMIUSegProcedimientos;
    private JMenuItem JMIUSolicitudDocClinicos;
    private JMenuItem JMIUSolicitudDocClinicos1;
    private JMenuItem JMIUSuministroLote;
    private JMenuItem JMIU_CierresSeguimiento;
    private JMenu JMIUtilidadesCart;
    private JMenu JMIUtilidadesFac1;
    private JMenuItem JMI_BusquedaMovPpt;
    private JMenuItem JMI_CPagosContabilidad;
    private JMenuItem JMI_CRecibo;
    private JMenuItem JMI_HojaTratamiento;
    private JMenuItem JMI_InformeGeneral;
    private JMenuItem JMI_LibroDiario;
    private JMenu JMImportacion;
    private JMenu JMInformesAM;
    private JMenu JMIngresos;
    private JMenuItem JMLReporte;
    private JMenu JMLectura;
    private JMenuItem JMLogistica;
    private JMenu JMMovManuales;
    private JMenu JMOdntoUtilidades;
    private JMenu JMOdontAtencion;
    private JMenu JMRecepcion;
    private JMenuItem JMRegisDatosExamen;
    private JMenuItem JMRegisRechazo;
    private JMenuItem JMReporteI;
    private JMenuItem JMReporteI1;
    private JMenu JMRequisicion;
    private JMenu JMResultado;
    private JMenuItem JMResultadoA;
    private JMenu JMResultados;
    private JMenu JMSoAutorizaciones;
    private JMenu JMSoInformes;
    private JMenu JMSoPrincipal;
    private JMenu JMSoUtilidades;
    private JMenu JMSolicitud;
    private JMenu JMUArmadoCuentas;
    private JMenuItem JMUCCargarAc1;
    private JMenu JMUCCierre;
    private JMenuItem JMUCConsolidadoCierre;
    private JMenuItem JMUCCostos;
    private JMenu JMUCGeneral;
    private JMenuItem JMUCNotasCargo;
    private JMenu JMUCUGActivo;
    private JMenu JMUCierres;
    private JMenuItem JMUConsultaOrdenes;
    private JMenu JMUConsultarAtencionesNP;
    private JMenuItem JMUConsultarAtencionesNPGeneral;
    private JMenuItem JMUConsultarAtencionesNPHora;
    private JMenu JMUContabilidad;
    private JMenu JMUContabilidad1;
    private JMenu JMUCuentaCobro;
    private JMenu JMUDCDescuento;
    private JMenu JMUEAyudasDx;
    private JMenuItem JMUGAGenerar;
    private JMenu JMUGCertificadoI;
    private JMenuItem JMUGFacturaConcepto;
    private JMenuItem JMUGenerar;
    private JMenuItem JMUGenerarCotizacion;
    private JMenu JMUGestionB;
    private JMenu JMUGestionTerceros;
    private JMenu JMUImportacionDoc;
    private JMenu JMUInventario;
    private JMenu JMULogisticaE;
    private JMenu JMULogisticaG;
    private JMenu JMULogisticaG1;
    private JMenu JMULogisticaH;
    private JMenu JMUMFacturaOrden;
    private JMenu JMUMGAutorizacion;
    private JMenu JMUMRiesgos;
    private JMenu JMUMedicinaP;
    private JMenuItem JMUNCambiarG;
    private JMenuItem JMUNCambiarG1;
    private JMenuItem JMUNCambiarG2;
    private JMenuItem JMUNCambiarG3;
    private JMenuItem JMUNCambiarG4;
    private JMenuItem JMUNCardiovascular;
    private JMenuItem JMUNObstetricos;
    private JMenuItem JMUNReliquidacion;
    private JMenuItem JMUPConsultaUser;
    private JMenuItem JMUPConsultaUser1;
    private JMenuItem JMUPMatricula;
    private JMenuItem JMUPRegistroEnvio;
    private JMenu JMUPeriodicos;
    private JMenu JMUProgEspecial1;
    private JMenu JMUPuc;
    private JMenu JMURecibos;
    private JMenuItem JMURegistroAtencionEspecial;
    private JMenuItem JMURelacionExamenO;
    private JMenu JMUReportesLog;
    private JMenuItem JMUSAutorizaciones;
    private JMenuItem JMUS_GestionSolicitudes;
    private JMenuItem JMUTempBodega;
    private JMenu JMUtilidades;
    private JMenu JMUtilidadesAM;
    private JMenu JMUtilidadesE;
    private JMenu JMUtilidadesG;
    private JMenu JMUtilidadesGD1;
    private JMenu JMUtilidadesH;
    private JMenu JMUtilidadesPTO;
    private JMenu JMUtilidadesRH;
    private JMenu JMVacunacion;
    private JMenuItem auditoria;
    public JMenuBar barraMnuAuditoriaMedica;
    public JMenuBar barraMnuAutorizacion;
    public static JMenuBar barraMnuAutorizacionMP;
    public static JMenuBar barraMnuCaja;
    public static JMenuBar barraMnuCajaM;
    public static JMenuBar barraMnuCirugia;
    public JMenuBar barraMnuCita;
    public static JMenuBar barraMnuCompras;
    public static JMenuBar barraMnuContabilidad;
    public static JMenuBar barraMnuEnfermeria;
    public static JMenuBar barraMnuFacturacion;
    public static JMenuBar barraMnuGCuentas;
    public static JMenuBar barraMnuGestionActivo;
    public static JMenuBar barraMnuGestionDoc;
    public static JMenuBar barraMnuHistoriaCE;
    public static JMenuBar barraMnuImagenDx;
    public static JMenuBar barraMnuInventario;
    public static JMenuBar barraMnuLab;
    public static JMenuBar barraMnuMant;
    public static JMenuBar barraMnuParametrizacion;
    public static JMenuBar barraMnuPresupuesto;
    public JMenuBar barraMnuPyP;
    public static JMenuBar barraMnuReferencia;
    public static JMenuBar barraMnuRrhh;
    public static JMenuBar barraMnuSgc;
    public static JMenuBar barraMnuSoportesDigitalizados;
    public static JMenuBar barraMnuTrancisionXenco;
    public static JMenuBar barraMnuTriage;
    private JMenuItem citaAtencion_Especial;
    private JMenuItem citaNoProgramada;
    private JMenuItem citaProgramada;
    private JMenuItem citaTerapia;
    private JMenuItem citasPCirugia;
    private JMenuItem importarcorreo;
    private JMenuItem jMIUEmpleados;
    private JMenuItem jMIUNovedadesNomina;
    private JMenuItem jMIUPrestamos;
    private JMenuItem jMIUTrasmisionNomina;
    private JMenuItem jMIUTrasmisionNotaNomina;
    private JMenuItem jMPagosNomina;
    private JMenu jMenu4;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem10;
    private JMenuItem jMenuItem11;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    private JPopupMenu.Separator jSeparator10;
    private JPopupMenu.Separator jSeparator11;
    private JPopupMenu.Separator jSeparator2;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JPopupMenu.Separator jSeparator6;
    private JPopupMenu.Separator jSeparator7;
    private JPopupMenu.Separator jSeparator8;
    private JPopupMenu.Separator jSeparator9;
    private JMenuItem jmiInformesGeneralesFac;
    private JMenuItem mnuAcercade;
    private JMenuItem mnuActivos;
    public static JMenuItem mnuAgendaSimedis;
    public JMenuItem mnuAgendar;
    private JMenuItem mnuAmbulatorio;
    private JMenuItem mnuAsignacionIngresoRecibos;
    private JMenu mnuAtencion;
    public JMenuItem mnuAtencionesEsp;
    private JMenuItem mnuAuditoria;
    public JMenuItem mnuAutoriza;
    public JMenu mnuAutorizar;
    private JMenu mnuAyuda;
    private JMenuItem mnuCLALasa;
    private JMenu mnuCUtilidades;
    private JMenuItem mnuCierre;
    private JMenuItem mnuCierreEgreso;
    private JMenuItem mnuCierreInv;
    private JMenu mnuCitaReportes;
    private JMenu mnuCitaUtilidad;
    private JMenuItem mnuCitaUtilidadPasarProg;
    private JMenuItem mnuCitaUtilidadProgramacion;
    private JMenu mnuCitas;
    private JMenu mnuComprasS;
    private JMenuItem mnuConsolidado;
    private JMenuItem mnuConsolidadoSalidas;
    private JMenuItem mnuConsultarEstado;
    private JMenu mnuContabilidad;
    private JMenuItem mnuConteo1;
    private JMenuItem mnuConteo2;
    private JMenuItem mnuCrearLote;
    private JMenuItem mnuDemandaNoAtendida;
    public JMenuItem mnuEnfAgenda;
    public JMenuItem mnuEnfAgenda1;
    public JMenuItem mnuEnfAgenda2;
    public JMenuItem mnuEnfAtencion;
    private JMenu mnuEntradas;
    private JMenu mnuEstadistica;
    private JMenu mnuFacturac;
    private JMenuItem mnuFacturacion;
    private JMenuItem mnuFacturacionAgenda;
    private JMenuItem mnuFacturacionAgil;
    private JMenuItem mnuGeneralxArea;
    private JMenuItem mnuGeneralxArea1;
    private JMenuItem mnuGeneralxCategoria;
    private JMenuItem mnuGenerar;
    private JMenu mnuImportarResultadoExternosPDF;
    private JMenuItem mnuImpresionStikers;
    private JMenuItem mnuImpresionStikers1;
    private JMenuItem mnuImprimirInv;
    private JMenuItem mnuInfCDespachoxMedico;
    private JMenuItem mnuInfCMovimientoI;
    private JMenuItem mnuInfCPendientesGenerados;
    private JMenuItem mnuInfCTiempoLLamada;
    private JMenuItem mnuInfConsumo;
    private JMenu mnuInfDespachos;
    private JMenu mnuInfFaltantes;
    private JMenuItem mnuInfMovimientoI;
    private JMenuItem mnuInfSalidas;
    private JMenuItem mnuInfSomnolencia;
    private JMenuItem mnuInfTraslados;
    private JMenuItem mnuInformeGeneral;
    private JMenu mnuInformesCaja;
    private JMenuItem mnuInformesGenerales;
    private JMenu mnuInformesPyP;
    private JMenuItem mnuIngresar;
    private JMenuItem mnuInvCons;
    private JMenuItem mnuInvDespachos;
    private JMenuItem mnuInvEntradas;
    private JMenuItem mnuInvFaltantes;
    private JMenuItem mnuInvKardex;
    private JMenuItem mnuInvSalidas;
    private JMenuItem mnuInvTraslados;
    private JMenu mnuInventarioMovto;
    private JMenu mnuInventarioUtilidad;
    private JMenu mnuInventarios;
    private JMenuItem mnuLabAgenda;
    private JMenuItem mnuLabAreas;
    public JMenu mnuLabConf;
    private JMenuItem mnuLabConsolidadoPorTipoServicio;
    private JMenuItem mnuLabCruzados;
    private JMenuItem mnuLabExportarResultadosPDF;
    private JMenuItem mnuLabHomologacionItemsExternos;
    private JMenu mnuLabInformes;
    private JMenuItem mnuLabInformesDinamicos;
    private JMenuItem mnuLabManual;
    private JMenu mnuLabMovimiento;
    private JMenuItem mnuLabPlanillaTrabajo;
    private JMenuItem mnuLabProcedimiento;
    private JMenuItem mnuLabProcedimientoRelac;
    private JMenuItem mnuLabProcedimientoUnif;
    private JMenuItem mnuLabProduccion;
    private JMenuItem mnuLabProduccion1;
    private JMenuItem mnuLabProduccion2;
    private JMenuItem mnuLabProduccion3;
    private JMenuItem mnuLabProduccion4;
    private JMenuItem mnuLabProtocolos;
    private JMenuItem mnuLabProtocoloxTipoResultado;
    private JMenuItem mnuLabProxAreaxPocedim;
    private JMenuItem mnuLabRegistroGeneral;
    private JMenuItem mnuLabResultadoExportacionInstitucional;
    private JMenuItem mnuLabResultados1;
    private JMenuItem mnuLabResultados2;
    private JMenuItem mnuLabResultados3;
    private JMenuItem mnuLabResultados4;
    private JMenuItem mnuLabTipoMetodo;
    private JMenuItem mnuLabTipoMuestra;
    private JMenuItem mnuLabTipoRechazo;
    private JMenuItem mnuLabTipoResultado;
    private JMenuItem mnuLabTipoTubo;
    public JMenuItem mnuListadoBasicoMedicamentos;
    public JMenuItem mnuListadoBasicoMedicamentosPsiquiatria;
    private JMenuItem mnuListadoDispositivosMedicos;
    private JMenuItem mnuLogistica;
    private JMenuItem mnuMaxyMin;
    private JMenuItem mnuModificarLote;
    private JMenuItem mnuMonitoreo;
    private JMenuItem mnuMuestrasRecepcionadas;
    private JMenu mnuMvto;
    private JMenu mnuMvtom;
    private JMenuItem mnuPlanillaTrabajo;
    private JMenuItem mnuPlanillaTrabajo1;
    private JMenuItem mnuPrepararInv;
    private JMenu mnuPrincipal;
    private JMenuItem mnuProximosAVencer;
    private JMenuItem mnuPyPAgendaVacunacion;
    private JMenu mnuPyPCACervix;
    private JMenuItem mnuPyPEgreso;
    private JMenuItem mnuPyPIngreso;
    private JMenu mnuPyPProgramas;
    private JMenuItem mnuPyPVacunacion;
    private JMenu mnuRPrincipal;
    private JMenu mnuRReporte;
    private JMenuItem mnuRecibos;
    private JMenuItem mnuRecibosEgresos;
    private JMenuItem mnuRemisionR;
    public JMenuItem mnuRemisionR2;
    private JMenu mnuReporte;
    private JMenuItem mnuReportes;
    private JMenuItem mnuReportes1;
    private JMenuItem mnuRotacion;
    private JMenuItem mnuRotacion1;
    private JMenu mnuSDPrincipal;
    private JMenu mnuSalidas;
    public JMenuItem mnuTraking;
    private JMenuItem mnubaja;
    private JMenuItem mnuturnosDigitales;
    private JMenuItem sisAtendidas;
    private JMenuItem sisAtendidasProfecional;
    private JMenuItem sisMedico;
    private JMenuItem sisNoAtendidas;
    private JMenuItem sisNoProgramado;

    public Menus(Principal xjp) {
        initComponents();
        this.xjp = xjp;
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.mnuListadoBasicoMedicamentos.setText("Listado de Productos Con Cantidad");
            this.mnuListadoBasicoMedicamentosPsiquiatria.setVisible(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
            this.mnuAmbulatorio.setVisible(false);
            this.mnuFacturacion.setVisible(false);
            this.mnuturnosDigitales.setVisible(false);
            this.mnuFacturacionAgil.setVisible(false);
            this.mnuFacturacionAgenda.setVisible(false);
        }
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.JMIURGenerarRipsCovid.setVisible(true);
        } else {
            this.JMIURGenerarRipsCovid.setVisible(false);
        }
        this.mnuCrearLote.setVisible(false);
        this.mnuImprimirInv.setVisible(false);
        this.mnuModificarLote.setVisible(false);
        this.JMIUSuministroLote.setVisible(false);
        if (Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR")) {
            JMIAgendaServicios.setVisible(false);
        }
        if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            this.mnuLabCruzados.setVisible(false);
        }
        if (Principal.informacionIps.getIdentificacion().equals("8296850")) {
            this.JMIConsultarADx.setVisible(false);
            this.JMIConsultarHc.setVisible(false);
            this.JMIAsignacion_AtencionE.setVisible(false);
            this.JMICPermisoMedicos.setVisible(false);
            this.JMIRegistroDiario2.setVisible(false);
            this.JMIConsultarAcronimos.setVisible(false);
            this.JMIConsultarResultado.setVisible(false);
            this.JMIConsultarResultadoUsuario.setVisible(false);
            this.JMIConsultarOrdRem.setVisible(false);
            this.JMIUFormulasPyP.setVisible(false);
            this.JMIConstanciaAsistencia.setVisible(false);
            this.JMHReporte.setVisible(false);
            this.JMIRegistroConsultaNP.setVisible(false);
            this.JMIRegistroNMedicas.setVisible(false);
            this.JMIRegistroIncapac.setVisible(false);
            this.JMIRegistroVDomiciliarias.setVisible(false);
            this.JMIRegistroJuntaMedica.setVisible(false);
            this.JMIInformeGenerale.setVisible(false);
            this.JMICertificado.setVisible(false);
            this.JMULogisticaH.setVisible(false);
            JMIAgendaServicios.setVisible(false);
            this.JMIAgendaServiciosBeta.setVisible(false);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812000317")) {
            this.mnuEnfAgenda.setVisible(false);
            this.JMIPAgenda_UH.setVisible(false);
            this.mnuEnfAgenda2.setVisible(false);
        }
        if (!Principal.informacionIps.getIdentificacion().equals("901420803")) {
            JMIAgendaNSO.setVisible(false);
        }
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                System.out.println("Entrooo");
                this.mnuLabConf.setEnabled(true);
            } else {
                this.mnuLabConf.setEnabled(false);
            }
        }
    }

    private void initComponents() {
        this.barraMnuAuditoriaMedica = new JMenuBar();
        this.JMGestionAM = new JMenu();
        this.JMGMAuditoria = new JMenu();
        this.JMIGAM_AuditoriaAdministracion = new JMenuItem();
        this.JMIGAM_AuditoriaConcurrente = new JMenuItem();
        this.JMIGAM_AuditoriaFacturas = new JMenuItem();
        this.JMInformesAM = new JMenu();
        this.JMII_InformeSeguimiento = new JMenuItem();
        this.JMII_InformesGenerales = new JMenuItem();
        this.JMUtilidadesAM = new JMenu();
        this.JMIU_CierresSeguimiento = new JMenuItem();
        this.barraMnuAutorizacion = new JMenuBar();
        this.mnuAutorizar = new JMenu();
        this.mnuAutoriza = new JMenuItem();
        this.mnuAyuda = new JMenu();
        this.mnuAcercade = new JMenuItem();
        barraMnuCaja = new JMenuBar();
        this.mnuMvto = new JMenu();
        this.mnuAsignacionIngresoRecibos = new JMenuItem();
        this.JMUCierres = new JMenu();
        this.mnuCierre = new JMenuItem();
        this.mnuCierreEgreso = new JMenuItem();
        this.mnuConsolidado = new JMenuItem();
        this.JMURecibos = new JMenu();
        this.mnuRecibosEgresos = new JMenuItem();
        this.mnuRecibos = new JMenuItem();
        this.mnuInformesCaja = new JMenu();
        this.JMI_CRecibo = new JMenuItem();
        this.JMI_InformeGeneral = new JMenuItem();
        this.mnuCUtilidades = new JMenu();
        this.JMI_CPagosContabilidad = new JMenuItem();
        barraMnuTriage = new JMenuBar();
        this.mnuAtencion = new JMenu();
        this.mnuAgendar = new JMenuItem();
        barraMnuFacturacion = new JMenuBar();
        this.mnuFacturac = new JMenu();
        mnuAgendaSimedis = new JMenuItem();
        this.mnuAmbulatorio = new JMenuItem();
        this.mnuFacturacion = new JMenuItem();
        this.mnuturnosDigitales = new JMenuItem();
        this.mnuFacturacionAgil = new JMenuItem();
        this.mnuFacturacionAgenda = new JMenuItem();
        this.JMFIngresoSOAT = new JMenu();
        this.JMIFPFacturasPE = new JMenuItem();
        this.JMIFPFacturasPE3 = new JMenuItem();
        this.JMIInformesIngresoEventoSoat = new JMenuItem();
        this.JMIInformesIngresoEventoSoat1 = new JMenuItem();
        this.JMIInformesAutorizacion = new JMenuItem();
        this.jmiInformesGeneralesFac = new JMenuItem();
        this.JMIFInfhospitalizados = new JMenuItem();
        this.JMIFInfOportunidad = new JMenuItem();
        this.JMIFListaChequeo = new JMenuItem();
        this.JMIFPFacturasPE2 = new JMenuItem();
        this.JMIFPFacturasPE1 = new JMenuItem();
        this.JMFUtilidades = new JMenu();
        this.JMUMGAutorizacion = new JMenu();
        this.JMUGAGenerar = new JMenuItem();
        this.JMIRegistroDiario3 = new JMenuItem();
        this.JMUConsultarAtencionesNP = new JMenu();
        this.JMUConsultarAtencionesNPGeneral = new JMenuItem();
        this.JMUConsultarAtencionesNPHora = new JMenuItem();
        this.JMUCNotasCargo = new JMenuItem();
        this.JMUConsultaOrdenes = new JMenuItem();
        this.JMIUDiagnostico1 = new JMenu();
        this.JMIUDigitacionDx1 = new JMenuItem();
        this.JMUGenerarCotizacion = new JMenuItem();
        this.JMUS_GestionSolicitudes = new JMenuItem();
        this.JMUMFacturaOrden = new JMenu();
        this.JMUNCambiarG = new JMenuItem();
        this.JMUNReliquidacion = new JMenuItem();
        this.JMUNCambiarG2 = new JMenuItem();
        this.JMURegistroAtencionEspecial = new JMenuItem();
        this.JMURelacionExamenO = new JMenuItem();
        this.JMUMRiesgos = new JMenu();
        this.JMUNCardiovascular = new JMenuItem();
        this.JMUNObstetricos = new JMenuItem();
        this.JMUSAutorizaciones = new JMenuItem();
        JMFCaja = new JMenu();
        this.JMICCierre = new JMenuItem();
        this.barraMnuCita = new JMenuBar();
        this.mnuCitas = new JMenu();
        this.citaAtencion_Especial = new JMenuItem();
        this.citaNoProgramada = new JMenuItem();
        this.citaProgramada = new JMenuItem();
        this.citasPCirugia = new JMenuItem();
        this.citaTerapia = new JMenuItem();
        this.mnuCitaReportes = new JMenu();
        this.auditoria = new JMenuItem();
        this.jSeparator4 = new JPopupMenu.Separator();
        this.sisAtendidas = new JMenuItem();
        this.sisAtendidasProfecional = new JMenuItem();
        this.sisNoAtendidas = new JMenuItem();
        this.JMICConsultar_Tiempo = new JMenuItem();
        this.sisNoProgramado = new JMenuItem();
        this.sisMedico = new JMenuItem();
        this.mnuCitaUtilidad = new JMenu();
        this.JMIAlertaxUsuario = new JMenuItem();
        this.JMIAnularProgramacion = new JMenuItem();
        this.JMIConsultarAgendaEnfermeria = new JMenuItem();
        this.JMIConsultarCitasUsuario = new JMenuItem();
        this.JMIConsultarRemOrdC = new JMenuItem();
        this.jMenu4 = new JMenu();
        this.mnuLogistica = new JMenuItem();
        this.mnuCitaUtilidadPasarProg = new JMenuItem();
        this.JMIPasarCitasxLote = new JMenuItem();
        this.mnuCitaUtilidadProgramacion = new JMenuItem();
        this.JMIRDiasAsignacionCita = new JMenuItem();
        this.JMIRegistroExamenesA = new JMenuItem();
        this.JMIRegistroReembolso = new JMenuItem();
        this.JMIUSolicitudDocClinicos1 = new JMenuItem();
        this.JMIUInformesGenerales = new JMenuItem();
        barraMnuInventario = new JMenuBar();
        this.mnuInventarioMovto = new JMenu();
        this.mnuInvEntradas = new JMenuItem();
        this.jSeparator2 = new JPopupMenu.Separator();
        this.mnuInvDespachos = new JMenuItem();
        this.mnuInvSalidas = new JMenuItem();
        this.mnuInvTraslados = new JMenuItem();
        this.jSeparator3 = new JPopupMenu.Separator();
        this.JMIMAgendaCirugia = new JMenuItem();
        this.JMIMAgendaUnidosis = new JMenuItem();
        this.mnuInvFaltantes = new JMenuItem();
        this.JIMInformes = new JMenu();
        this.mnuInventarios = new JMenu();
        this.mnuGeneralxArea = new JMenuItem();
        this.mnuProximosAVencer = new JMenuItem();
        this.jSeparator5 = new JPopupMenu.Separator();
        this.mnuListadoDispositivosMedicos = new JMenuItem();
        this.mnuListadoBasicoMedicamentos = new JMenuItem();
        this.mnuListadoBasicoMedicamentosPsiquiatria = new JMenuItem();
        this.mnuGeneralxCategoria = new JMenuItem();
        this.jSeparator6 = new JPopupMenu.Separator();
        this.mnuCLALasa = new JMenuItem();
        this.JMICRotacion = new JMenuItem();
        this.mnuRotacion1 = new JMenuItem();
        this.mnuGeneralxArea1 = new JMenuItem();
        this.mnuMaxyMin = new JMenuItem();
        this.mnuRotacion = new JMenuItem();
        this.mnuEntradas = new JMenu();
        this.jMenuItem10 = new JMenuItem();
        this.jMenuItem1 = new JMenuItem();
        this.mnuEstadistica = new JMenu();
        this.mnuInfConsumo = new JMenuItem();
        this.mnuInfCDespachoxMedico = new JMenuItem();
        this.mnuInfCPendientesGenerados = new JMenuItem();
        this.mnuInfCTiempoLLamada = new JMenuItem();
        this.mnuInfMovimientoI = new JMenuItem();
        this.mnuInfCMovimientoI = new JMenuItem();
        this.mnuSalidas = new JMenu();
        this.mnuInfFaltantes = new JMenu();
        this.jMenuItem2 = new JMenuItem();
        this.jMenuItem3 = new JMenuItem();
        this.jMenuItem4 = new JMenuItem();
        this.mnuInfDespachos = new JMenu();
        this.jMenuItem9 = new JMenuItem();
        this.jMenuItem7 = new JMenuItem();
        this.jMenuItem5 = new JMenuItem();
        this.jMenuItem8 = new JMenuItem();
        this.jMenuItem6 = new JMenuItem();
        this.mnuInfTraslados = new JMenuItem();
        this.mnuInfSalidas = new JMenuItem();
        this.mnuInfSomnolencia = new JMenuItem();
        this.mnuConsolidadoSalidas = new JMenuItem();
        this.mnuInformeGeneral = new JMenuItem();
        this.mnuInventarioUtilidad = new JMenu();
        this.mnuAuditoria = new JMenuItem();
        this.mnuInvCons = new JMenuItem();
        this.mnuInvKardex = new JMenuItem();
        this.jSeparator8 = new JPopupMenu.Separator();
        this.JMUContabilidad = new JMenu();
        this.JMUCConsolidadoCierre = new JMenuItem();
        this.JMUCCostos = new JMenuItem();
        this.JMIIFormulacionMedica = new JMenuItem();
        this.JMIIFormulasGeneradas = new JMenuItem();
        this.JMIUMovimientoS = new JMenuItem();
        this.JMGestionFaltantes = new JMenu();
        this.JMIUCFaltatesFecha = new JMenuItem();
        this.JMIUGestionarFaltantes = new JMenuItem();
        this.JMUGestionB = new JMenu();
        this.JMIIActualizarPendientes = new JMenuItem();
        this.JMIIAdicionarProdc = new JMenuItem();
        this.JMIUAjustarPuntosSC = new JMenuItem();
        this.JMIUCDespachoxEspecialidad = new JMenuItem();
        this.JMIIKardex = new JMenuItem();
        this.JMIIKardex_P = new JMenuItem();
        this.JMIUModificarSolicitud = new JMenuItem();
        this.JMIIModificarMPM = new JMenuItem();
        this.JMIIModificarCodAg = new JMenuItem();
        this.JMIIRepBodegas = new JMenuItem();
        this.JMIUGestionarPreposicion = new JMenuItem();
        this.JMIUSuministroLote = new JMenuItem();
        this.JMUInventario = new JMenu();
        this.mnuPrepararInv = new JMenuItem();
        this.mnuConteo1 = new JMenuItem();
        this.mnuConteo2 = new JMenuItem();
        this.mnuCierreInv = new JMenuItem();
        this.mnuCrearLote = new JMenuItem();
        this.mnuImprimirInv = new JMenuItem();
        this.mnuModificarLote = new JMenuItem();
        this.mnuMonitoreo = new JMenuItem();
        this.JMUContabilidad1 = new JMenu();
        this.JMReporteI = new JMenuItem();
        this.JMIPeriodoContableI = new JMenuItem();
        this.JMUTempBodega = new JMenuItem();
        barraMnuContabilidad = new JMenuBar();
        this.mnuContabilidad = new JMenu();
        this.JMCCajaM = new JMenu();
        this.JMICRegistroRecibos = new JMenuItem();
        this.JMICSolicitudR = new JMenuItem();
        this.JMICDocumentoC = new JMenuItem();
        this.JMCFactura = new JMenu();
        this.JMICGPago = new JMenuItem();
        this.JMICGPago1 = new JMenuItem();
        this.JMICRadicacion = new JMenuItem();
        this.JMICRadicacionNC = new JMenuItem();
        this.JMICSeleccionC = new JMenuItem();
        this.JMICSeleccionC1 = new JMenuItem();
        this.JMCCuentaC = new JMenu();
        this.JMICCuentaCobroA = new JMenuItem();
        this.JMICCuentaCobroM = new JMenuItem();
        this.JMCReembolso = new JMenu();
        this.JMICRadicacionR = new JMenuItem();
        this.jMPagosNomina = new JMenuItem();
        this.JMCAuditoria = new JMenu();
        this.JMIAAutorizacionDoc = new JMenuItem();
        this.JMCInformes = new JMenu();
        this.JMIBalanceContable = new JMenuItem();
        this.JMIBalanceContable1 = new JMenuItem();
        this.JMIBalanceContable2 = new JMenuItem();
        this.JMIInformeTipoImpuesto1 = new JMenuItem();
        this.JMIUConsultarDocTercero = new JMenuItem();
        this.JMICI_ConsultarEstadoFacturas = new JMenuItem();
        this.JMICIEjecucionP = new JMenuItem();
        this.JMIEstadoFinancieroComp = new JMenuItem();
        this.JMIMediosDian = new JMenu();
        this.JMIDMedios = new JMenuItem();
        this.JMIDMedios1 = new JMenuItem();
        this.JMIGasto = new JMenu();
        this.JMICRConsolidado = new JMenuItem();
        this.JMIInformeContraloria = new JMenuItem();
        this.JMIInformeFinancieros = new JMenu();
        this.JMIDEstadoResultado = new JMenuItem();
        this.JMIRInventario = new JMenu();
        this.JMIIAuditoriasAleatorias = new JMenuItem();
        this.JMIIConciliacionInv = new JMenuItem();
        this.JMIInformeDespacho = new JMenuItem();
        this.JMIIKardexI = new JMenuItem();
        this.JMILibroAuxiliar = new JMenu();
        this.JMICLibroGeneral = new JMenuItem();
        this.JMICLibroRangoCuenta = new JMenuItem();
        this.JMICLibroTerceros = new JMenuItem();
        this.JMI_LibroDiario = new JMenuItem();
        this.JMIILibroMayor = new JMenuItem();
        this.JMIMovimiento = new JMenuItem();
        this.JMIMovimiento_Tercero = new JMenuItem();
        this.JMIRelacionPago = new JMenuItem();
        this.JMIInformeTipoImpuesto = new JMenuItem();
        this.JMIInformeTipoImpuesto2 = new JMenuItem();
        this.JMCUAnularDocXCCobro = new JMenu();
        this.JMIUAjusteDoc = new JMenuItem();
        JMIUAjusteDoc1 = new JMenuItem();
        this.JMICGasto = new JMenuItem();
        this.JMUGCertificadoI = new JMenu();
        this.JMIUCManual = new JMenuItem();
        this.JMIUCAutomatico = new JMenuItem();
        this.JMUCCierre = new JMenu();
        this.JMIUCuentasCGI = new JMenuItem();
        this.JMIUCImpuesto = new JMenuItem();
        this.JMICExportar = new JMenuItem();
        this.JMIUCuentasGastosR = new JMenuItem();
        this.JMIDocDescuadrados = new JMenuItem();
        this.JMIUGenerarDisfon = new JMenuItem();
        this.JMUCUGActivo = new JMenu();
        this.JMIUGestionActivos = new JMenuItem();
        this.JMIUCDepreciacion = new JMenuItem();
        this.JMUGestionTerceros = new JMenu();
        this.JMIUGTActivar = new JMenuItem();
        this.JMUImportacionDoc = new JMenu();
        this.JMIUIFacturas = new JMenuItem();
        JMIUModificacionDocC = new JMenuItem();
        this.JMIUPeriodoC = new JMenuItem();
        this.JMIUPeriodoF = new JMenuItem();
        this.JMUPuc = new JMenu();
        this.JMIUIPCrearCuenta = new JMenuItem();
        this.JMIUPlanCuenta = new JMenuItem();
        this.JMIURegistroFac = new JMenuItem();
        this.barraMnuPyP = new JMenuBar();
        this.mnuPyPProgramas = new JMenu();
        this.JMActividadesPyP = new JMenu();
        this.JMIRActProfesional = new JMenuItem();
        this.JMIRActividades = new JMenuItem();
        this.JMIRActUsuarios = new JMenuItem();
        this.jSeparator11 = new JPopupMenu.Separator();
        this.mnuPyPCACervix = new JMenu();
        this.JMIGestion_CACervix = new JMenuItem();
        this.JMIGestion_Procedimientos = new JMenuItem();
        this.jSeparator7 = new JPopupMenu.Separator();
        this.mnuPyPEgreso = new JMenuItem();
        this.mnuPyPIngreso = new JMenuItem();
        this.JMBMatriculaUsuarios = new JMenu();
        this.JMIPDiabetes = new JMenuItem();
        this.JMIPHta = new JMenuItem();
        this.JMBPolimedicado = new JMenu();
        this.JMIPGestion = new JMenuItem();
        this.JMIR4505 = new JMenuItem();
        this.jSeparator10 = new JPopupMenu.Separator();
        this.JMVacunacion = new JMenu();
        this.mnuPyPAgendaVacunacion = new JMenuItem();
        this.mnuPyPVacunacion = new JMenuItem();
        this.mnuInformesPyP = new JMenu();
        this.JMIRCaCervix = new JMenuItem();
        this.JMIInformesGenerales = new JMenuItem();
        barraMnuEnfermeria = new JMenuBar();
        this.JMEPrincipal = new JMenu();
        this.mnuEnfAgenda = new JMenuItem();
        this.JMIPAgenda_UH = new JMenuItem();
        this.JMIPAgenda_UH2 = new JMenuItem();
        this.JMIPAgenda_UH1 = new JMenuItem();
        this.mnuAtencionesEsp = new JMenuItem();
        this.mnuEnfAtencion = new JMenuItem();
        this.mnuEnfAgenda1 = new JMenuItem();
        this.mnuEnfAgenda2 = new JMenuItem();
        this.JMIRInformes = new JMenu();
        this.JMIRegistroDiario1 = new JMenuItem();
        this.JMIRegistroDiario = new JMenuItem();
        this.JMIRConsultarUnidosisAplicada = new JMenuItem();
        this.JMIRSaludOcupacional = new JMenu();
        this.JMIESoInfAyD = new JMenuItem();
        this.JMIESoTFatiga = new JMenuItem();
        this.JMIRegistroDiario4 = new JMenuItem();
        this.JMIFInfhospitalizados1 = new JMenuItem();
        this.JMUtilidadesE = new JMenu();
        this.JMIP_Alimentacion = new JMenu();
        this.JMIP_SolicitudAlimentacion = new JMenuItem();
        this.JMIP_AInforme = new JMenuItem();
        this.JMIConsultarAcronimos1 = new JMenuItem();
        this.JMIRemOrdenes = new JMenuItem();
        this.JMULogisticaE = new JMenu();
        this.JMLReporte = new JMenuItem();
        this.JMIPSo_Alcohol_DrograE = new JMenuItem();
        this.JMIRegistroNotas = new JMenuItem();
        this.JMIPSo_Test_FatigaE = new JMenuItem();
        barraMnuAutorizacionMP = new JMenuBar();
        this.JMAPrincipal = new JMenu();
        this.JMAutorizacion = new JMenuItem();
        this.JMUtilidades = new JMenu();
        this.JMUDCDescuento = new JMenu();
        this.JMUCCargarAc1 = new JMenuItem();
        this.JMIUDCargarLote = new JMenuItem();
        this.JMIUDPlantillaAplicada = new JMenuItem();
        this.JMUGenerar = new JMenuItem();
        this.JMIUDGenerarPlantilla = new JMenuItem();
        this.JMULogisticaG1 = new JMenu();
        this.JMLogistica = new JMenuItem();
        this.JMUMedicinaP = new JMenu();
        this.JMAuditoriaMp = new JMenuItem();
        this.JMResultadoA = new JMenuItem();
        this.JMUProgEspecial1 = new JMenu();
        this.JMUPConsultaUser = new JMenuItem();
        this.JMUPMatricula = new JMenuItem();
        this.JMUPRegistroEnvio = new JMenuItem();
        this.JMUPConsultaUser1 = new JMenuItem();
        this.JMAyuda = new JMenu();
        this.JMIAAcercade = new JMenuItem();
        barraMnuHistoriaCE = new JMenuBar();
        this.JMAtencion = new JMenu();
        JMIAgendaN = new JMenuItem();
        JMIAgendaN1 = new JMenuItem();
        JMAgendaSeparada = new JMenu();
        JMIAgendaNSO = new JMenuItem();
        this.JMIAgendaCE = new JMenuItem();
        JMIAgendaServicios = new JMenuItem();
        this.JMIAgendaServiciosBeta = new JMenuItem();
        this.JMIConsultarADx = new JMenuItem();
        this.JMIConsultarHc = new JMenuItem();
        this.JMUtilidadesH = new JMenu();
        this.JMIAsignacionCNP = new JMenuItem();
        this.JMIAsignacion_AtencionE = new JMenuItem();
        this.JMICertificado = new JMenu();
        this.JMICPermisoMedicos = new JMenuItem();
        this.JMIRegistroDiario2 = new JMenuItem();
        this.JMIConsultarAcronimos = new JMenuItem();
        this.JMIConsultarResultado = new JMenuItem();
        this.JMIConsultarResultadoUsuario = new JMenuItem();
        this.JMIConsultarOrdRem = new JMenuItem();
        this.JMIUFormulasPyP = new JMenuItem();
        this.JMIConstanciaAsistencia = new JMenuItem();
        this.JMULogisticaH = new JMenu();
        this.JMHReporte = new JMenuItem();
        this.JMIRegistroConsultaNP = new JMenuItem();
        this.JMIRegistroNMedicas = new JMenuItem();
        this.JMIRegistroIncapac = new JMenuItem();
        this.JMIRegistroVDomiciliarias = new JMenuItem();
        this.JMIRegistroJuntaMedica = new JMenuItem();
        this.JMIInformeGenerale = new JMenuItem();
        this.JMAyuda1 = new JMenu();
        this.JMIAAcercade1 = new JMenuItem();
        barraMnuGestionDoc = new JMenuBar();
        this.JMGestion = new JMenu();
        this.JMEncuesta = new JMenu();
        this.JMIECargarS = new JMenuItem();
        this.JMIERegistroE = new JMenuItem();
        this.JMIConsultarAyudasDx = new JMenuItem();
        this.JMIConsultarHC = new JMenuItem();
        this.JMIConsultarLecturaRx = new JMenuItem();
        this.JMIRegistroNMedicas1 = new JMenuItem();
        this.JMGestionQrs = new JMenu();
        this.JMIGRegistro = new JMenuItem();
        this.JMIGSeguimiento = new JMenuItem();
        this.JMUtilidadesG = new JMenu();
        this.JMIArchivarDocs = new JMenuItem();
        this.JMIConsultarAtenciones = new JMenuItem();
        this.JMIConsultarCprogramada = new JMenuItem();
        this.JMIConsultarIncapacidad = new JMenuItem();
        this.JMIConsultarRemOrd = new JMenuItem();
        this.JMIConsultarResultadoG = new JMenuItem();
        this.JMIConsultarResultadoUsuario1 = new JMenuItem();
        this.JMIUExportarDHC = new JMenu();
        this.JMIUEHistoriaPdf = new JMenuItem();
        this.JMUEAyudasDx = new JMenu();
        this.JMIUEAxamenes = new JMenuItem();
        this.JMIUEAxamenesFEcha = new JMenuItem();
        this.JMIUEHistoriaPdf2 = new JMenuItem();
        this.JMIUGestionExamenes = new JMenuItem();
        this.JMIUImportarDHC = new JMenu();
        this.JMIUAtencionesManuales = new JMenuItem();
        this.JMIUImportarAyudasdx = new JMenuItem();
        this.JMIImportarAyudasDx = new JMenuItem();
        this.JMICopiasDoc = new JMenuItem();
        this.JMIISoporteLote = new JMenuItem();
        this.JMULogisticaG = new JMenu();
        this.JMGReporte = new JMenuItem();
        this.JMIConsultarMovimientoDocClinico = new JMenuItem();
        this.JMIUSolicitudDocClinicos = new JMenuItem();
        this.JMIUInformes = new JMenuItem();
        barraMnuSgc = new JMenuBar();
        this.JMConfiguracion = new JMenu();
        this.JMCIProcesos = new JMenuItem();
        this.JMCIProcxTipo = new JMenuItem();
        this.JMCITipoProceso = new JMenuItem();
        this.JMGestion1 = new JMenu();
        this.JMIConsultarAyudasDx1 = new JMenuItem();
        this.JMIConsultarHC1 = new JMenuItem();
        this.JMUtilidadesGD1 = new JMenu();
        this.JMIUExportarDHC1 = new JMenu();
        this.JMIUEHistoriaPdf1 = new JMenuItem();
        this.JMIUGestionExamenes1 = new JMenuItem();
        this.JMIUImportarDHC1 = new JMenu();
        this.JMIUAtencionesManuales1 = new JMenuItem();
        this.JMIUImportarAyudasdx1 = new JMenuItem();
        this.JMIImportarAyudasDx1 = new JMenuItem();
        barraMnuLab = new JMenuBar();
        this.mnuLabMovimiento = new JMenu();
        this.JMRecepcion = new JMenu();
        this.mnuLabAgenda = new JMenuItem();
        this.mnuLabManual = new JMenuItem();
        this.mnuLabCruzados = new JMenuItem();
        this.JMResultado = new JMenu();
        this.mnuPlanillaTrabajo = new JMenuItem();
        this.JMIR_ValidarInterfaz = new JMenuItem();
        this.mnuPlanillaTrabajo1 = new JMenuItem();
        this.jSeparator9 = new JPopupMenu.Separator();
        this.JMExportacion = new JMenu();
        this.JMIEquipoQuimica1 = new JMenu();
        this.JMIEBiosystemA15 = new JMenuItem();
        this.JMIEBiosystemA25 = new JMenuItem();
        this.JMIEWienerLabCB400i = new JMenuItem();
        this.JMIECM250 = new JMenuItem();
        this.JMIEquipoHormonas = new JMenu();
        this.JMIEAutoplex = new JMenuItem();
        this.JMIEWienerLabCB400i2 = new JMenuItem();
        this.JMIEquipoEspecializados = new JMenu();
        this.JMIECobase411 = new JMenuItem();
        this.JMICoagulacion = new JMenu();
        this.JMIESTASatellite1 = new JMenuItem();
        this.JMIEquipoMicrobiologia = new JMenu();
        this.JMIEDL96II = new JMenuItem();
        this.JMIRentransmisionResultados = new JMenuItem();
        this.JMImportacion = new JMenu();
        this.JMIEquipoHematologia = new JMenu();
        this.JMIIHematologia1 = new JMenuItem();
        this.JMIIHematologia = new JMenuItem();
        this.JMIEquipoOrinas = new JMenu();
        this.JMIICombilyzer3 = new JMenuItem();
        this.JMIIDiruiH = new JMenuItem();
        this.JMIEquipoQuimica = new JMenu();
        this.JMIIBiosystemA25 = new JMenuItem();
        this.JMIIQHumastar80 = new JMenuItem();
        this.JMIIHL7Infinity = new JMenuItem();
        this.JMIIResultadoExternos = new JMenuItem();
        this.mnuRemisionR = new JMenuItem();
        this.mnuRemisionR2 = new JMenuItem();
        this.mnuTraking = new JMenuItem();
        this.mnuLabInformes = new JMenu();
        this.mnuLabConsolidadoPorTipoServicio = new JMenuItem();
        this.mnuDemandaNoAtendida = new JMenuItem();
        this.JMEstadistica = new JMenu();
        this.mnuLabResultados3 = new JMenuItem();
        this.mnuLabProduccion = new JMenuItem();
        this.mnuLabProduccion4 = new JMenuItem();
        this.mnuMuestrasRecepcionadas = new JMenuItem();
        this.mnuLabResultados4 = new JMenuItem();
        this.mnuLabProduccion1 = new JMenuItem();
        this.mnuLabProduccion2 = new JMenuItem();
        this.mnuLabProduccion3 = new JMenuItem();
        this.mnuLabResultados1 = new JMenuItem();
        this.mnuLabInformesDinamicos = new JMenuItem();
        this.mnuImpresionStikers = new JMenuItem();
        this.mnuImpresionStikers1 = new JMenuItem();
        this.mnuLabPlanillaTrabajo = new JMenuItem();
        this.JMResultados = new JMenu();
        this.JMIConsultarResultadoUsuario2 = new JMenuItem();
        this.mnuLabResultados2 = new JMenuItem();
        this.mnuLabResultadoExportacionInstitucional = new JMenuItem();
        this.mnuLabExportarResultadosPDF = new JMenuItem();
        this.mnuLabRegistroGeneral = new JMenuItem();
        this.mnuLabConf = new JMenu();
        this.JMUCGeneral = new JMenu();
        this.mnuLabAreas = new JMenuItem();
        this.JMIUComentarioA = new JMenuItem();
        this.mnuLabProtocolos = new JMenuItem();
        this.JMIFEncabezado = new JMenuItem();
        this.mnuLabTipoMuestra = new JMenuItem();
        this.mnuLabTipoRechazo = new JMenuItem();
        this.mnuLabTipoMetodo = new JMenuItem();
        this.mnuLabTipoResultado = new JMenuItem();
        this.mnuLabTipoTubo = new JMenuItem();
        this.mnuLabHomologacionItemsExternos = new JMenuItem();
        this.mnuLabProcedimiento = new JMenuItem();
        this.mnuLabProcedimientoUnif = new JMenuItem();
        this.mnuLabProcedimientoRelac = new JMenuItem();
        this.mnuLabProxAreaxPocedim = new JMenuItem();
        this.mnuLabProtocoloxTipoResultado = new JMenuItem();
        this.mnuImportarResultadoExternosPDF = new JMenu();
        this.JMConstanciaAten = new JMenuItem();
        this.JMCopiaDocumentos = new JMenuItem();
        this.JMRegisDatosExamen = new JMenuItem();
        this.JMRegisRechazo = new JMenuItem();
        this.JMUReportesLog = new JMenu();
        this.JMReporteI1 = new JMenuItem();
        this.JMIConsultarResultadoExa = new JMenuItem();
        this.JMIConsultarResultadoExa1 = new JMenuItem();
        this.JMILValidacionAdministrativa = new JMenuItem();
        this.importarcorreo = new JMenuItem();
        barraMnuMant = new JMenuBar();
        this.JMActivos = new JMenu();
        this.mnuActivos = new JMenuItem();
        this.JMHojadeVida = new JMenu();
        this.mnubaja = new JMenuItem();
        this.mnuIngresar = new JMenuItem();
        this.mnuReporte = new JMenu();
        this.mnuConsultarEstado = new JMenuItem();
        this.mnuGenerar = new JMenuItem();
        this.mnuReportes = new JMenuItem();
        this.mnuReportes1 = new JMenuItem();
        this.mnuInformesGenerales = new JMenuItem();
        barraMnuParametrizacion = new JMenuBar();
        barraMnuRrhh = new JMenuBar();
        this.JMGestion2 = new JMenu();
        this.JMGestionEmpleado = new JMenuItem();
        this.JMG_Nomina = new JMenu();
        this.JMIGN_LiquidacionN = new JMenuItem();
        this.JMIGN_LiquidacionNueva = new JMenuItem();
        this.JMIGN_Causacion = new JMenuItem();
        this.JMGDeduccionConceptos = new JMenuItem();
        this.JMUtilidadesRH = new JMenu();
        this.JMIUAutorizaciones = new JMenuItem();
        this.jMIUEmpleados = new JMenuItem();
        this.JMIUNomina = new JMenu();
        this.JMIUC_Gestion_Concepto = new JMenuItem();
        this.JMIUNovedadesN = new JMenu();
        this.jMIUNovedadesNomina = new JMenuItem();
        this.JMIUInformesNovedades = new JMenuItem();
        this.jMIUPrestamos = new JMenuItem();
        this.jMIUTrasmisionNomina = new JMenuItem();
        this.jMIUTrasmisionNotaNomina = new JMenuItem();
        this.JMIUAnticipos = new JMenuItem();
        this.JMGestion3 = new JMenu();
        this.JMG_Nomina1 = new JMenu();
        this.JMIGN_ConsolidadoConceptosRH = new JMenuItem();
        this.JMIGN_ConsultarNominaIntervaloFecha = new JMenuItem();
        this.JMIGN_ConsolidadoPersonal = new JMenuItem();
        this.JMIGN_ConsultarPlanillas = new JMenuItem();
        this.JMIGN_InformeCGR = new JMenuItem();
        this.JMIUInformesGeneral = new JMenuItem();
        barraMnuCajaM = new JMenuBar();
        this.mnuMvtom = new JMenu();
        this.JMICRegistroRecibosCM = new JMenuItem();
        this.JMICSolicitudRCM = new JMenuItem();
        this.JMICInformesGenerales = new JMenuItem();
        barraMnuImagenDx = new JMenuBar();
        this.JIMIPrincipal = new JMenu();
        this.JMIAgendaRx = new JMenuItem();
        this.JMIConsultarEstadoO = new JMenuItem();
        this.JMIRegistroInformacionP = new JMenuItem();
        this.JIMIInformesRx = new JMenu();
        this.JMEstadistica1 = new JMenu();
        this.JMITiempoRx = new JMenuItem();
        this.JMLectura = new JMenu();
        this.JMIConsolidadoLectura = new JMenuItem();
        this.JIMIUtilidades = new JMenu();
        this.JIMRUInfomeLecturaUsuario = new JMenuItem();
        this.JIMRULecturaOit = new JMenuItem();
        this.JIMRUNotasIma = new JMenuItem();
        this.JIMRInformesGenerales = new JMenuItem();
        barraMnuGCuentas = new JMenuBar();
        this.JIMIPrincipalCp1 = new JMenu();
        this.JMUArmadoCuentas = new JMenu();
        this.JMIACapitacionG = new JMenuItem();
        this.JMIAOrdenFactura = new JMenuItem();
        this.JMIAProcedimientosA = new JMenuItem();
        this.JMGCCartera = new JMenu();
        this.JMGCCGestion = new JMenuItem();
        this.JMGCCG_PagosGrupales = new JMenuItem();
        this.JMIAgendaRx2 = new JMenuItem();
        this.JMIRadicacionFacturasMasiva = new JMenuItem();
        this.JMUCuentaCobro = new JMenu();
        this.JMIPConsultarCPE = new JMenuItem();
        this.JMICGenerar = new JMenu();
        this.JMIACapitacion1 = new JMenuItem();
        this.JMIACapitacionServicio = new JMenuItem();
        this.JMUGFacturaConcepto = new JMenuItem();
        this.JMIAGEventoServicio = new JMenuItem();
        this.JIMA_Informes = new JMenu();
        this.JMIA_Produccion = new JMenu();
        this.JMIP_ConsolidadoFE = new JMenuItem();
        this.JMIP_ConsolidadoFF = new JMenuItem();
        this.JMIPListaFacturaVenta = new JMenuItem();
        this.JMIPListaOrdenInterna = new JMenuItem();
        this.JMIA_InfCartera = new JMenu();
        this.JMIP_ConsolidadoCartera = new JMenuItem();
        this.JMIP_ConsolidadoGlosas = new JMenuItem();
        this.JMIP_ConsolidadoGlosasDefinitivo = new JMenuItem();
        this.JMIP_Circular030 = new JMenuItem();
        this.JMIP_InformeCartera2193 = new JMenuItem();
        this.JMIP_ConsolidadosDePagos = new JMenuItem();
        this.JMIP_InformesPyP = new JMenuItem();
        this.JIMUtilidadesC = new JMenu();
        this.JMIUtilidadesCart = new JMenu();
        this.JMIFUCConciliacionC = new JMenuItem();
        this.JMIUDiagnostico = new JMenu();
        this.JMIUDigitacionDx = new JMenuItem();
        this.JMIUDxMasivo = new JMenuItem();
        this.JMIUImportarDxRips = new JMenuItem();
        this.JMIURips = new JMenu();
        this.JMIURGenerar = new JMenuItem();
        this.JMIURGenerarRipsCovid = new JMenuItem();
        this.JMIURGenerarRipsExtranjeros = new JMenuItem();
        this.JMIURGenerar1 = new JMenuItem();
        this.JMIURGenerar2 = new JMenuItem();
        this.JMIUtilidadesFac1 = new JMenu();
        this.JMUNCambiarG1 = new JMenuItem();
        this.JMIFExportarExcelPDF = new JMenuItem();
        this.JMIFListFacturas1 = new JMenuItem();
        this.JMIFListFacturasArm1 = new JMenuItem();
        this.JMIFReorganizacionF1 = new JMenuItem();
        this.JMIFReorganizacionF2 = new JMenuItem();
        this.JMUNCambiarG3 = new JMenuItem();
        this.JMUNCambiarG4 = new JMenuItem();
        barraMnuCompras = new JMenuBar();
        this.JIMIPrincipalCp = new JMenu();
        this.JMBienes = new JMenu();
        this.JMCConsultarEstado = new JMenuItem();
        this.JMCSolicitud = new JMenuItem();
        this.JMRequisicion = new JMenu();
        this.JMCEvaluada = new JMenuItem();
        this.f0JMCCotizacin = new JMenuItem();
        this.mnuComprasS = new JMenu();
        this.JMCConsultarEstadoS = new JMenuItem();
        this.JMCSolicitudS = new JMenuItem();
        this.JMContratos = new JMenu();
        this.JMCSolicitudC = new JMenuItem();
        this.JIMIInformesCp = new JMenu();
        this.JMIContratos = new JMenu();
        this.JMCConsolidadoContrato = new JMenuItem();
        this.JMCInformeCGR = new JMenuItem();
        this.JMCInformeGenerales = new JMenuItem();
        JMBOdontologia = new JMenuBar();
        this.JMOdontAtencion = new JMenu();
        this.JMIOdontoAgenda = new JMenuItem();
        this.JMIConsultarADx1 = new JMenuItem();
        this.JMIConsultarHc1 = new JMenuItem();
        this.JMOdntoUtilidades = new JMenu();
        this.JMIPSoInformesGenericos1 = new JMenuItem();
        this.JMAyuda5 = new JMenu();
        this.JMIAAcercade4 = new JMenuItem();
        JMBAdministracionNomina = new JMenuBar();
        this.JMIPANReporte = new JMenu();
        this.JMIANRReporteHExtras = new JMenuItem();
        this.JMIAInformesGenerales = new JMenuItem();
        JMBInformesV = new JMenuBar();
        this.JMIInformes = new JMenu();
        this.JMIIRiesgoC = new JMenuItem();
        this.JMIIInformesGenerales = new JMenuItem();
        JMBSo = new JMenuBar();
        this.JMSoPrincipal = new JMenu();
        this.JMIPSo_Agenda = new JMenuItem();
        this.JMIPSo_Alcohol_Drogra = new JMenuItem();
        this.JMIPSo_Test_Fatiga = new JMenuItem();
        this.JMUPeriodicos = new JMenu();
        this.JMIUCargarDatos = new JMenuItem();
        this.JMIUCPeriodicos = new JMenuItem();
        this.JMIUGPeriodicos = new JMenuItem();
        this.JMIUGSeguimiento = new JMenuItem();
        this.JMSoInformes = new JMenu();
        this.JMIPSoAutoReportes = new JMenuItem();
        this.JMIPSoInfAyD = new JMenuItem();
        this.JMIPSoCSeguimiento = new JMenuItem();
        this.JMIPSoAtenciones = new JMenuItem();
        this.JMIPSoExaPerioSeguimientoDetalles = new JMenuItem();
        this.JMIPSoFramingham = new JMenuItem();
        this.JMIPSoRiesgoCV = new JMenuItem();
        this.JMIPSoInformeCIS20 = new JMenuItem();
        this.JMIPSoInformeDiagnosticoSalud = new JMenuItem();
        this.JMIPSoInformesGenericos = new JMenuItem();
        this.JMIPSoEstudiosRadiologicos = new JMenuItem();
        this.JMIPSoInformesSistemaVigilancia = new JMenuItem();
        this.JMIPSoReporteAudiometria = new JMenuItem();
        this.JMIPSoReporteEspirometria1 = new JMenuItem();
        this.JMIPSoReporteEspirometria = new JMenuItem();
        this.JMIPSoReporteNOMA = new JMenuItem();
        this.JMIPSoReporteVisiometria = new JMenuItem();
        this.JMIPSoTFatiga = new JMenuItem();
        this.JMIPSoTRuffier = new JMenuItem();
        this.JMSoUtilidades = new JMenu();
        this.JMITipoSeg = new JMenuItem();
        this.JMITipoAgente = new JMenuItem();
        this.JMIUSegProcedimientos = new JMenuItem();
        this.JMIUSegAgente = new JMenuItem();
        this.JMITSegValor = new JMenuItem();
        this.JMITipoSistemaVigilancia = new JMenuItem();
        this.JMSoAutorizaciones = new JMenu();
        this.JMIDeclaracionAntecedentes = new JMenuItem();
        barraMnuGestionActivo = new JMenuBar();
        this.JMGAPrincipal = new JMenu();
        this.JMIGAActivos = new JMenuItem();
        this.JMGAInformes = new JMenu();
        this.JMIGAInformeActivos = new JMenuItem();
        this.JMIGInformesGenerales = new JMenuItem();
        barraMnuCirugia = new JMenuBar();
        this.JMCxPrincipal = new JMenu();
        JMIP_AgendaN = new JMenuItem();
        this.JMIP_CxProgramacion = new JMenuItem();
        this.JMCxInformes = new JMenu();
        this.JMIP_IProgramacion = new JMenuItem();
        this.JMIP_InformeCirugia = new JMenuItem();
        this.JMIP_InformesGenerales = new JMenuItem();
        barraMnuPresupuesto = new JMenuBar();
        this.JMCxPrincipal1 = new JMenu();
        this.JMGastos = new JMenu();
        this.JMIDisponibilidad = new JMenuItem();
        this.JMIDisponibilidad1 = new JMenuItem();
        this.JMICompromisoPTO = new JMenuItem();
        this.JMICompromisoBeta = new JMenuItem();
        this.JMIngresos = new JMenu();
        this.JMIManualesIng = new JMenuItem();
        this.JMMovManuales = new JMenu();
        this.JMIMovManual = new JMenuItem();
        this.JMIOperacionesM1 = new JMenuItem();
        this.JMSolicitud = new JMenu();
        this.JMIDisponibilidad2 = new JMenuItem();
        this.JMIDisponibilidad3 = new JMenuItem();
        this.JMCxInformes1 = new JMenu();
        this.JMI_BusquedaMovPpt = new JMenuItem();
        this.JMIDecreto2193 = new JMenuItem();
        this.JMIEjecucionPtal = new JMenuItem();
        this.JMIEjecucionPtalPeriodo = new JMenuItem();
        this.JMIInformeCGR = new JMenuItem();
        this.JMICuentasxPagar = new JMenuItem();
        this.JMILibroPresupuesto = new JMenuItem();
        this.JMILInformesGenerales = new JMenuItem();
        this.JMUtilidadesPTO = new JMenu();
        this.JMIAnulaDoc = new JMenuItem();
        this.JMICargueInicial = new JMenuItem();
        this.JMISolicitudes = new JMenuItem();
        barraMnuTrancisionXenco = new JMenuBar();
        this.mnuPrincipal = new JMenu();
        this.JMI_HojaTratamiento = new JMenuItem();
        barraMnuReferencia = new JMenuBar();
        this.mnuRPrincipal = new JMenu();
        this.JMICPReferencia = new JMenuItem();
        this.mnuRReporte = new JMenu();
        this.JMICPRConsolidadoRemisiones = new JMenuItem();
        barraMnuSoportesDigitalizados = new JMenuBar();
        this.mnuSDPrincipal = new JMenu();
        this.JMICPSoporteDigitalizado = new JMenuItem();
        this.jMenuItem11 = new JMenuItem();
        this.JMGestionAM.setText("Auditoría Médica");
        this.JMGestionAM.setToolTipText("");
        this.JMGestionAM.setFont(new Font("Arial", 1, 12));
        this.JMGMAuditoria.setText("Auditorias");
        this.JMGMAuditoria.setFont(new Font("Arial", 1, 12));
        this.JMIGAM_AuditoriaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JMIGAM_AuditoriaAdministracion.setText("Administracion");
        this.JMIGAM_AuditoriaAdministracion.addActionListener(new ActionListener() { // from class: Acceso.Menus.1
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGAM_AuditoriaAdministracionActionPerformed(evt);
            }
        });
        this.JMGMAuditoria.add(this.JMIGAM_AuditoriaAdministracion);
        this.JMIGAM_AuditoriaConcurrente.setFont(new Font("Arial", 1, 12));
        this.JMIGAM_AuditoriaConcurrente.setText("Concurrente");
        this.JMIGAM_AuditoriaConcurrente.addActionListener(new ActionListener() { // from class: Acceso.Menus.2
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGAM_AuditoriaConcurrenteActionPerformed(evt);
            }
        });
        this.JMGMAuditoria.add(this.JMIGAM_AuditoriaConcurrente);
        this.JMIGAM_AuditoriaFacturas.setFont(new Font("Arial", 1, 12));
        this.JMIGAM_AuditoriaFacturas.setText("Facturas");
        this.JMIGAM_AuditoriaFacturas.addActionListener(new ActionListener() { // from class: Acceso.Menus.3
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGAM_AuditoriaFacturasActionPerformed(evt);
            }
        });
        this.JMGMAuditoria.add(this.JMIGAM_AuditoriaFacturas);
        this.JMGestionAM.add(this.JMGMAuditoria);
        this.barraMnuAuditoriaMedica.add(this.JMGestionAM);
        this.JMInformesAM.setText("Informes");
        this.JMInformesAM.setFont(new Font("Arial", 1, 12));
        this.JMII_InformeSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JMII_InformeSeguimiento.setText("Consolidado de Seguimiento");
        this.JMII_InformeSeguimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.4
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMII_InformeSeguimientoActionPerformed(evt);
            }
        });
        this.JMInformesAM.add(this.JMII_InformeSeguimiento);
        this.JMII_InformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMII_InformesGenerales.setText("Informes Generales");
        this.JMII_InformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.5
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMII_InformesGeneralesActionPerformed(evt);
            }
        });
        this.JMInformesAM.add(this.JMII_InformesGenerales);
        this.barraMnuAuditoriaMedica.add(this.JMInformesAM);
        this.JMUtilidadesAM.setText("Utilidades");
        this.JMUtilidadesAM.setFont(new Font("Arial", 1, 12));
        this.JMIU_CierresSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JMIU_CierresSeguimiento.setText("Cierre de Seguimiento");
        this.JMIU_CierresSeguimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.6
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIU_CierresSeguimientoActionPerformed(evt);
            }
        });
        this.JMUtilidadesAM.add(this.JMIU_CierresSeguimiento);
        this.barraMnuAuditoriaMedica.add(this.JMUtilidadesAM);
        this.mnuAutorizar.setMnemonic('A');
        this.mnuAutorizar.setText("Autorizaciones");
        this.mnuAutorizar.setFont(new Font("Arial", 1, 12));
        this.mnuAutorizar.setName("mnuAutorizar");
        this.mnuAutorizar.addActionListener(new ActionListener() { // from class: Acceso.Menus.7
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAutorizarActionPerformed(evt);
            }
        });
        this.mnuAutoriza.setFont(new Font("Arial", 1, 12));
        this.mnuAutoriza.setForeground(new Color(0, 0, 204));
        this.mnuAutoriza.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.mnuAutoriza.setMnemonic('R');
        this.mnuAutoriza.setText("Autorizaciones");
        this.mnuAutoriza.setToolTipText("Autorizar un Servicio");
        this.mnuAutoriza.setName("mnuAutoriza");
        this.mnuAutoriza.addActionListener(new ActionListener() { // from class: Acceso.Menus.8
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAutorizaActionPerformed(evt);
            }
        });
        this.mnuAutorizar.add(this.mnuAutoriza);
        this.barraMnuAutorizacion.add(this.mnuAutorizar);
        this.mnuAyuda.setForeground(new Color(0, 0, 153));
        this.mnuAyuda.setMnemonic('Y');
        this.mnuAyuda.setText("Ayuda");
        this.mnuAyuda.setFont(new Font("Arial", 1, 12));
        this.mnuAcercade.setFont(new Font("Arial", 1, 12));
        this.mnuAcercade.setForeground(new Color(0, 0, 204));
        this.mnuAcercade.setMnemonic('A');
        this.mnuAcercade.setText("Acerca de ...");
        this.mnuAcercade.setToolTipText("Informacion de la empresa");
        this.mnuAcercade.addActionListener(new ActionListener() { // from class: Acceso.Menus.9
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAcercadeActionPerformed(evt);
            }
        });
        this.mnuAyuda.add(this.mnuAcercade);
        this.barraMnuAutorizacion.add(this.mnuAyuda);
        this.mnuMvto.setText("Caja");
        this.mnuMvto.setFont(new Font("Arial", 1, 12));
        this.mnuAsignacionIngresoRecibos.setFont(new Font("Arial", 1, 12));
        this.mnuAsignacionIngresoRecibos.setText("Asinacion de Ingresos a Recibos de Caja");
        this.mnuAsignacionIngresoRecibos.addActionListener(new ActionListener() { // from class: Acceso.Menus.10
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAsignacionIngresoRecibosActionPerformed(evt);
            }
        });
        this.mnuMvto.add(this.mnuAsignacionIngresoRecibos);
        this.JMUCierres.setText("Cierre");
        this.JMUCierres.setFont(new Font("Arial", 1, 12));
        this.mnuCierre.setFont(new Font("Arial", 1, 12));
        this.mnuCierre.setText("Cierre de Ingresos");
        this.mnuCierre.addActionListener(new ActionListener() { // from class: Acceso.Menus.11
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCierreEgresoActionPerformed(evt);
            }
        });
        this.JMUCierres.add(this.mnuCierre);
        this.mnuCierreEgreso.setFont(new Font("Arial", 1, 12));
        this.mnuCierreEgreso.setText("Cierre de Egresos");
        this.mnuCierreEgreso.addActionListener(new ActionListener() { // from class: Acceso.Menus.12
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCierreEgresoActionPerformed1(evt);
            }
        });
        this.JMUCierres.add(this.mnuCierreEgreso);
        this.mnuMvto.add(this.JMUCierres);
        this.mnuConsolidado.setFont(new Font("Arial", 1, 12));
        this.mnuConsolidado.setText("Consolidado");
        this.mnuConsolidado.addActionListener(new ActionListener() { // from class: Acceso.Menus.13
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuConsolidadoActionPerformed(evt);
            }
        });
        this.mnuMvto.add(this.mnuConsolidado);
        this.JMURecibos.setText("Recibos");
        this.JMURecibos.setFont(new Font("Arial", 1, 12));
        this.mnuRecibosEgresos.setFont(new Font("Arial", 1, 12));
        this.mnuRecibosEgresos.setText("Egresos");
        this.mnuRecibosEgresos.addActionListener(new ActionListener() { // from class: Acceso.Menus.14
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRecibosEgresosActionPerformed(evt);
            }
        });
        this.JMURecibos.add(this.mnuRecibosEgresos);
        this.mnuRecibos.setFont(new Font("Arial", 1, 12));
        this.mnuRecibos.setText("Ingresos");
        this.mnuRecibos.addActionListener(new ActionListener() { // from class: Acceso.Menus.15
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRecibosActionPerformed(evt);
            }
        });
        this.JMURecibos.add(this.mnuRecibos);
        this.mnuMvto.add(this.JMURecibos);
        barraMnuCaja.add(this.mnuMvto);
        this.mnuInformesCaja.setText("Informes");
        this.mnuInformesCaja.setFont(new Font("Arial", 1, 12));
        this.JMI_CRecibo.setFont(new Font("Arial", 1, 12));
        this.JMI_CRecibo.setText("Consultar Recibos");
        this.JMI_CRecibo.addActionListener(new ActionListener() { // from class: Acceso.Menus.16
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_CReciboActionPerformed(evt);
            }
        });
        this.mnuInformesCaja.add(this.JMI_CRecibo);
        this.JMI_InformeGeneral.setFont(new Font("Arial", 1, 12));
        this.JMI_InformeGeneral.setText("Informe General");
        this.JMI_InformeGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.17
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_InformeGeneralActionPerformed(evt);
            }
        });
        this.mnuInformesCaja.add(this.JMI_InformeGeneral);
        barraMnuCaja.add(this.mnuInformesCaja);
        this.mnuCUtilidades.setText("Utilidades");
        this.mnuCUtilidades.setFont(new Font("Arial", 1, 12));
        this.JMI_CPagosContabilidad.setFont(new Font("Arial", 1, 12));
        this.JMI_CPagosContabilidad.setText("Generar Pago Individual");
        this.JMI_CPagosContabilidad.addActionListener(new ActionListener() { // from class: Acceso.Menus.18
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_CPagosContabilidadActionPerformed(evt);
            }
        });
        this.mnuCUtilidades.add(this.JMI_CPagosContabilidad);
        barraMnuCaja.add(this.mnuCUtilidades);
        this.mnuAtencion.setText("Triage");
        this.mnuAtencion.setFont(new Font("Arial", 1, 12));
        this.mnuAtencion.setName("mnuAtencion");
        this.mnuAtencion.addActionListener(new ActionListener() { // from class: Acceso.Menus.19
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAtencionActionPerformed(evt);
            }
        });
        this.mnuAgendar.setFont(new Font("Arial", 1, 12));
        this.mnuAgendar.setText("Agenda");
        this.mnuAgendar.setToolTipText("");
        this.mnuAgendar.setName("mnuAgendar");
        this.mnuAgendar.addActionListener(new ActionListener() { // from class: Acceso.Menus.20
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAgendarActionPerformed(evt);
            }
        });
        this.mnuAtencion.add(this.mnuAgendar);
        barraMnuTriage.add(this.mnuAtencion);
        this.mnuFacturac.setText("Facturación");
        this.mnuFacturac.setFont(new Font("Arial", 1, 12));
        mnuAgendaSimedis.setFont(new Font("Arial", 1, 12));
        mnuAgendaSimedis.setText("Agenda Laboratorio");
        mnuAgendaSimedis.setToolTipText("Agenda de usuarios admisionados en simedis");
        mnuAgendaSimedis.addActionListener(new ActionListener() { // from class: Acceso.Menus.21
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAgendaSimedisActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(mnuAgendaSimedis);
        this.mnuAmbulatorio.setFont(new Font("Arial", 1, 12));
        this.mnuAmbulatorio.setText("Ambulatorio");
        this.mnuAmbulatorio.setToolTipText("Facturación de Servicios Ambulatorios");
        this.mnuAmbulatorio.addActionListener(new ActionListener() { // from class: Acceso.Menus.22
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAmbulatorioActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(this.mnuAmbulatorio);
        this.mnuFacturacion.setFont(new Font("Arial", 1, 12));
        this.mnuFacturacion.setText("Servicios");
        this.mnuFacturacion.setToolTipText("Facturar Servicios de Urgencias y Hospitalización");
        this.mnuFacturacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.23
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuFacturacionActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(this.mnuFacturacion);
        this.mnuturnosDigitales.setFont(new Font("Arial", 1, 12));
        this.mnuturnosDigitales.setText("Agenda-Turnos");
        this.mnuturnosDigitales.setToolTipText("Facturar Servicios de Urgencias y Hospitalización");
        this.mnuturnosDigitales.addActionListener(new ActionListener() { // from class: Acceso.Menus.24
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuturnosDigitalesActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(this.mnuturnosDigitales);
        this.mnuFacturacionAgil.setFont(new Font("Arial", 1, 12));
        this.mnuFacturacionAgil.setText("Ambulatorio Agil");
        this.mnuFacturacionAgil.setToolTipText("Facturar Servicios de Urgencias y Hospitalización");
        this.mnuFacturacionAgil.addActionListener(new ActionListener() { // from class: Acceso.Menus.25
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuFacturacionAgilActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(this.mnuFacturacionAgil);
        this.mnuFacturacionAgenda.setFont(new Font("Arial", 1, 12));
        this.mnuFacturacionAgenda.setText("Agenda");
        this.mnuFacturacionAgenda.setToolTipText("Facturar Servicios de Urgencias y Hospitalización");
        this.mnuFacturacionAgenda.addActionListener(new ActionListener() { // from class: Acceso.Menus.26
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuFacturacionAgendaActionPerformed(evt);
            }
        });
        this.mnuFacturac.add(this.mnuFacturacionAgenda);
        barraMnuFacturacion.add(this.mnuFacturac);
        this.JMFIngresoSOAT.setText("Informes");
        this.JMFIngresoSOAT.setFont(new Font("Arial", 1, 12));
        this.JMIFPFacturasPE.setFont(new Font("Arial", 1, 12));
        this.JMIFPFacturasPE.setText("Consolidado de Procedimientos Facturados");
        this.JMIFPFacturasPE.setToolTipText("");
        this.JMIFPFacturasPE.addActionListener(new ActionListener() { // from class: Acceso.Menus.27
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFPFacturasPEActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFPFacturasPE);
        this.JMIFPFacturasPE3.setFont(new Font("Arial", 1, 12));
        this.JMIFPFacturasPE3.setText("Consultar facturas por cerrar(Pre-Auditoria)");
        this.JMIFPFacturasPE3.setToolTipText("");
        this.JMIFPFacturasPE3.addActionListener(new ActionListener() { // from class: Acceso.Menus.28
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFPFacturasPE3ActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFPFacturasPE3);
        this.JMIInformesIngresoEventoSoat.setFont(new Font("Arial", 1, 12));
        this.JMIInformesIngresoEventoSoat.setText("Consultar Ingresos con Evento SOAT");
        this.JMIInformesIngresoEventoSoat.setToolTipText("");
        this.JMIInformesIngresoEventoSoat.addActionListener(new ActionListener() { // from class: Acceso.Menus.29
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformesIngresoEventoSoatActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIInformesIngresoEventoSoat);
        this.JMIInformesIngresoEventoSoat1.setFont(new Font("Arial", 1, 12));
        this.JMIInformesIngresoEventoSoat1.setText("Consultar Ingresos por liquidación");
        this.JMIInformesIngresoEventoSoat1.setToolTipText("");
        this.JMIInformesIngresoEventoSoat1.addActionListener(new ActionListener() { // from class: Acceso.Menus.30
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformesIngresoEventoSoat1ActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIInformesIngresoEventoSoat1);
        this.JMIInformesAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JMIInformesAutorizacion.setText("Informes de Autorización");
        this.JMIInformesAutorizacion.setToolTipText("");
        this.JMIInformesAutorizacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.31
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformesAutorizacionActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIInformesAutorizacion);
        this.jmiInformesGeneralesFac.setFont(new Font("Arial", 1, 12));
        this.jmiInformesGeneralesFac.setText("Informes Generales Facturación");
        this.jmiInformesGeneralesFac.addActionListener(new ActionListener() { // from class: Acceso.Menus.32
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jmiInformesGeneralesFacActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.jmiInformesGeneralesFac);
        this.JMIFInfhospitalizados.setFont(new Font("Arial", 1, 12));
        this.JMIFInfhospitalizados.setText("Informes Hospitalización");
        this.JMIFInfhospitalizados.setToolTipText("");
        this.JMIFInfhospitalizados.addActionListener(new ActionListener() { // from class: Acceso.Menus.33
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFInfhospitalizadosActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFInfhospitalizados);
        this.JMIFInfOportunidad.setFont(new Font("Arial", 1, 12));
        this.JMIFInfOportunidad.setText("Informes Urgencias");
        this.JMIFInfOportunidad.setToolTipText("");
        this.JMIFInfOportunidad.addActionListener(new ActionListener() { // from class: Acceso.Menus.34
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFInfOportunidadActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFInfOportunidad);
        this.JMIFListaChequeo.setFont(new Font("Arial", 1, 12));
        this.JMIFListaChequeo.setText("Lista de Chequeo de Salud Ocupacional");
        this.JMIFListaChequeo.setToolTipText("");
        this.JMIFListaChequeo.addActionListener(new ActionListener() { // from class: Acceso.Menus.35
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFListaChequeoActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFListaChequeo);
        this.JMIFPFacturasPE2.setFont(new Font("Arial", 1, 12));
        this.JMIFPFacturasPE2.setText("Listado de Facturas de Ventas");
        this.JMIFPFacturasPE2.setToolTipText("");
        this.JMIFPFacturasPE2.addActionListener(new ActionListener() { // from class: Acceso.Menus.36
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFPFacturasPE2ActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFPFacturasPE2);
        this.JMIFPFacturasPE1.setFont(new Font("Arial", 1, 12));
        this.JMIFPFacturasPE1.setText("Listado de Ordenes Internas");
        this.JMIFPFacturasPE1.setToolTipText("");
        this.JMIFPFacturasPE1.addActionListener(new ActionListener() { // from class: Acceso.Menus.37
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFPFacturasPE1ActionPerformed(evt);
            }
        });
        this.JMFIngresoSOAT.add(this.JMIFPFacturasPE1);
        barraMnuFacturacion.add(this.JMFIngresoSOAT);
        this.JMFUtilidades.setText("Utilidades");
        this.JMFUtilidades.setFont(new Font("Arial", 1, 12));
        this.JMUMGAutorizacion.setText("Autorización de Servicios");
        this.JMUMGAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JMUGAGenerar.setFont(new Font("Arial", 1, 12));
        this.JMUGAGenerar.setText("Generar");
        this.JMUGAGenerar.addActionListener(new ActionListener() { // from class: Acceso.Menus.38
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUGAGenerarActionPerformed(evt);
            }
        });
        this.JMUMGAutorizacion.add(this.JMUGAGenerar);
        this.JMFUtilidades.add(this.JMUMGAutorizacion);
        this.JMIRegistroDiario3.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario3.setText("Censo de Camas");
        this.JMIRegistroDiario3.addActionListener(new ActionListener() { // from class: Acceso.Menus.39
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroDiario3ActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMIRegistroDiario3);
        this.JMUConsultarAtencionesNP.setText("Consultar Atenciones No Programadas");
        this.JMUConsultarAtencionesNP.setFont(new Font("Arial", 1, 12));
        this.JMUConsultarAtencionesNPGeneral.setFont(new Font("Arial", 1, 12));
        this.JMUConsultarAtencionesNPGeneral.setText("Generar");
        this.JMUConsultarAtencionesNPGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.40
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUConsultarAtencionesNPGeneralActionPerformed(evt);
            }
        });
        this.JMUConsultarAtencionesNP.add(this.JMUConsultarAtencionesNPGeneral);
        this.JMUConsultarAtencionesNPHora.setFont(new Font("Arial", 1, 12));
        this.JMUConsultarAtencionesNPHora.setText("Filtrado por Hora");
        this.JMUConsultarAtencionesNPHora.addActionListener(new ActionListener() { // from class: Acceso.Menus.41
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUConsultarAtencionesNPHoraActionPerformed(evt);
            }
        });
        this.JMUConsultarAtencionesNP.add(this.JMUConsultarAtencionesNPHora);
        this.JMFUtilidades.add(this.JMUConsultarAtencionesNP);
        this.JMUCNotasCargo.setFont(new Font("Arial", 1, 12));
        this.JMUCNotasCargo.setText("Consultar Notas de Cargo");
        this.JMUCNotasCargo.addActionListener(new ActionListener() { // from class: Acceso.Menus.42
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUCNotasCargoActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMUCNotasCargo);
        this.JMUConsultaOrdenes.setFont(new Font("Arial", 1, 12));
        this.JMUConsultaOrdenes.setText("Consultar Remisiones y Ordenes");
        this.JMUConsultaOrdenes.addActionListener(new ActionListener() { // from class: Acceso.Menus.43
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUConsultaOrdenesActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMUConsultaOrdenes);
        this.JMIUDiagnostico1.setText("Diagnóstico");
        this.JMIUDiagnostico1.setFont(new Font("Arial", 1, 12));
        this.JMIUDigitacionDx1.setFont(new Font("Arial", 1, 12));
        this.JMIUDigitacionDx1.setText("Digitación Manual");
        this.JMIUDigitacionDx1.addActionListener(new ActionListener() { // from class: Acceso.Menus.44
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDigitacionDx1ActionPerformed(evt);
            }
        });
        this.JMIUDiagnostico1.add(this.JMIUDigitacionDx1);
        this.JMFUtilidades.add(this.JMIUDiagnostico1);
        this.JMUGenerarCotizacion.setFont(new Font("Arial", 1, 12));
        this.JMUGenerarCotizacion.setText("Generar Cotización");
        this.JMUGenerarCotizacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.45
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUGenerarCotizacionActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMUGenerarCotizacion);
        this.JMUS_GestionSolicitudes.setFont(new Font("Arial", 1, 12));
        this.JMUS_GestionSolicitudes.setText("Gestión Solicitudes de Servicios");
        this.JMUS_GestionSolicitudes.addActionListener(new ActionListener() { // from class: Acceso.Menus.46
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUS_GestionSolicitudesActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMUS_GestionSolicitudes);
        this.JMUSAutorizaciones.setVisible(false);
        this.JMUMFacturaOrden.setText("N° Factura/Orden");
        this.JMUMFacturaOrden.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG.setText("Cambiar Grupo");
        this.JMUNCambiarG.addActionListener(new ActionListener() { // from class: Acceso.Menus.47
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCambiarGActionPerformed(evt);
            }
        });
        this.JMUMFacturaOrden.add(this.JMUNCambiarG);
        this.JMUNReliquidacion.setFont(new Font("Arial", 1, 12));
        this.JMUNReliquidacion.setText("Reliquidación de ordenes");
        this.JMUNReliquidacion.setActionCommand("Reliquidacion de ordenes");
        this.JMUNReliquidacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.48
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNReliquidacionActionPerformed(evt);
            }
        });
        this.JMUMFacturaOrden.add(this.JMUNReliquidacion);
        this.JMUNReliquidacion.setVisible(false);
        this.JMUNCambiarG2.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG2.setText("Actualizar Numero Autorizacion");
        this.JMUNCambiarG2.addActionListener(new ActionListener() { // from class: Acceso.Menus.49
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCambiarG2ActionPerformed(evt);
            }
        });
        this.JMUMFacturaOrden.add(this.JMUNCambiarG2);
        this.JMFUtilidades.add(this.JMUMFacturaOrden);
        this.JMURegistroAtencionEspecial.setFont(new Font("Arial", 1, 12));
        this.JMURegistroAtencionEspecial.setText("Registro Atención Especial");
        this.JMURegistroAtencionEspecial.addActionListener(new ActionListener() { // from class: Acceso.Menus.50
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMURegistroAtencionEspecialActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMURegistroAtencionEspecial);
        this.JMURelacionExamenO.setFont(new Font("Arial", 1, 12));
        this.JMURelacionExamenO.setText("Relación Exámenes Ocupacionales");
        this.JMURelacionExamenO.addActionListener(new ActionListener() { // from class: Acceso.Menus.51
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMURelacionExamenOActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMURelacionExamenO);
        this.JMUMRiesgos.setText("Riesgos");
        this.JMUMRiesgos.setFont(new Font("Arial", 1, 12));
        this.JMUNCardiovascular.setFont(new Font("Arial", 1, 12));
        this.JMUNCardiovascular.setText("Cardiovascular");
        this.JMUNCardiovascular.addActionListener(new ActionListener() { // from class: Acceso.Menus.52
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCardiovascularActionPerformed(evt);
            }
        });
        this.JMUMRiesgos.add(this.JMUNCardiovascular);
        this.JMUNObstetricos.setFont(new Font("Arial", 1, 12));
        this.JMUNObstetricos.setText("Obstetricos");
        this.JMUNObstetricos.addActionListener(new ActionListener() { // from class: Acceso.Menus.53
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNObstetricosActionPerformed(evt);
            }
        });
        this.JMUMRiesgos.add(this.JMUNObstetricos);
        this.JMFUtilidades.add(this.JMUMRiesgos);
        this.JMUMRiesgos.setVisible(false);
        this.JMUSAutorizaciones.setFont(new Font("Arial", 1, 12));
        this.JMUSAutorizaciones.setText("Solicitud Autorizaciones");
        this.JMUSAutorizaciones.addActionListener(new ActionListener() { // from class: Acceso.Menus.54
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUSAutorizacionesActionPerformed(evt);
            }
        });
        this.JMFUtilidades.add(this.JMUSAutorizaciones);
        this.JMUSAutorizaciones.setVisible(false);
        barraMnuFacturacion.add(this.JMFUtilidades);
        JMFCaja.setText("Caja");
        JMFCaja.setFont(new Font("Arial", 1, 12));
        this.JMICCierre.setFont(new Font("Arial", 1, 12));
        this.JMICCierre.setText("Cierre");
        this.JMICCierre.setToolTipText("CIerre de Caja");
        this.JMICCierre.addActionListener(new ActionListener() { // from class: Acceso.Menus.55
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICCierreActionPerformed(evt);
            }
        });
        JMFCaja.add(this.JMICCierre);
        barraMnuFacturacion.add(JMFCaja);
        Principal principal = this.xjp;
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            JMFCaja.setVisible(true);
        } else {
            JMFCaja.setVisible(false);
        }
        this.mnuCitas.setText("Citas");
        this.mnuCitas.setToolTipText("Asignación de Citas");
        this.mnuCitas.setFont(new Font("Arial", 1, 12));
        this.citaAtencion_Especial.setFont(new Font("Arial", 1, 12));
        this.citaAtencion_Especial.setText("Atención Especial");
        this.citaAtencion_Especial.addActionListener(new ActionListener() { // from class: Acceso.Menus.56
            public void actionPerformed(ActionEvent evt) {
                Menus.this.citaAtencion_EspecialActionPerformed(evt);
            }
        });
        this.mnuCitas.add(this.citaAtencion_Especial);
        this.citaNoProgramada.setFont(new Font("Arial", 1, 12));
        this.citaNoProgramada.setText("No Programadas");
        this.citaNoProgramada.addActionListener(new ActionListener() { // from class: Acceso.Menus.57
            public void actionPerformed(ActionEvent evt) {
                Menus.this.citaNoProgramadaActionPerformed(evt);
            }
        });
        this.mnuCitas.add(this.citaNoProgramada);
        this.citaProgramada.setFont(new Font("Arial", 1, 12));
        this.citaProgramada.setText("Programadas");
        this.citaProgramada.setToolTipText("Asignación de Citas Programadas");
        this.citaProgramada.addActionListener(new ActionListener() { // from class: Acceso.Menus.58
            public void actionPerformed(ActionEvent evt) {
                Menus.this.citaProgramadaActionPerformed(evt);
            }
        });
        this.mnuCitas.add(this.citaProgramada);
        this.citasPCirugia.setFont(new Font("Arial", 1, 12));
        this.citasPCirugia.setText("Programación de CIrugia");
        this.citasPCirugia.addActionListener(new ActionListener() { // from class: Acceso.Menus.59
            public void actionPerformed(ActionEvent evt) {
                Menus.this.citasPCirugiaActionPerformed(evt);
            }
        });
        this.mnuCitas.add(this.citasPCirugia);
        this.citaTerapia.setFont(new Font("Arial", 1, 12));
        this.citaTerapia.setText("Terapias");
        this.citaTerapia.addActionListener(new ActionListener() { // from class: Acceso.Menus.60
            public void actionPerformed(ActionEvent evt) {
                Menus.this.citaTerapiaActionPerformed(evt);
            }
        });
        this.mnuCitas.add(this.citaTerapia);
        this.barraMnuCita.add(this.mnuCitas);
        this.mnuCitaReportes.setText("Reportes");
        this.mnuCitaReportes.setFont(new Font("Arial", 1, 12));
        this.auditoria.setFont(new Font("Arial", 1, 12));
        this.auditoria.setText("Asignación por Usuario");
        this.auditoria.setToolTipText("Muestra los Usuarios que asignaron Citas a un Profesional");
        this.auditoria.addActionListener(new ActionListener() { // from class: Acceso.Menus.61
            public void actionPerformed(ActionEvent evt) {
                Menus.this.auditoriaActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.auditoria);
        this.mnuCitaReportes.add(this.jSeparator4);
        this.sisAtendidas.setFont(new Font("Arial", 1, 12));
        this.sisAtendidas.setText("Citas Atendidas");
        this.sisAtendidas.addActionListener(new ActionListener() { // from class: Acceso.Menus.62
            public void actionPerformed(ActionEvent evt) {
                Menus.this.sisAtendidasActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.sisAtendidas);
        this.sisAtendidasProfecional.setFont(new Font("Arial", 1, 12));
        this.sisAtendidasProfecional.setText("Citas Atendidas Por Profesional");
        this.sisAtendidasProfecional.addActionListener(new ActionListener() { // from class: Acceso.Menus.63
            public void actionPerformed(ActionEvent evt) {
                Menus.this.sisAtendidasProfecionalActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.sisAtendidasProfecional);
        this.sisNoAtendidas.setFont(new Font("Arial", 1, 12));
        this.sisNoAtendidas.setText("Citas No Atendidas");
        this.sisNoAtendidas.addActionListener(new ActionListener() { // from class: Acceso.Menus.64
            public void actionPerformed(ActionEvent evt) {
                Menus.this.sisNoAtendidasActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.sisNoAtendidas);
        this.JMICConsultar_Tiempo.setFont(new Font("Arial", 1, 12));
        this.JMICConsultar_Tiempo.setText("Consultar Tiempo de Atención");
        this.JMICConsultar_Tiempo.addActionListener(new ActionListener() { // from class: Acceso.Menus.65
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICConsultar_TiempoActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.JMICConsultar_Tiempo);
        this.sisNoProgramado.setFont(new Font("Arial", 1, 12));
        this.sisNoProgramado.setText("SIS Citas No Programadas");
        this.sisNoProgramado.addActionListener(new ActionListener() { // from class: Acceso.Menus.66
            public void actionPerformed(ActionEvent evt) {
                Menus.this.sisNoProgramadoActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.sisNoProgramado);
        this.sisMedico.setFont(new Font("Arial", 1, 12));
        this.sisMedico.setText("SIS Médicos");
        this.sisMedico.addActionListener(new ActionListener() { // from class: Acceso.Menus.67
            public void actionPerformed(ActionEvent evt) {
                Menus.this.sisMedicoActionPerformed(evt);
            }
        });
        this.mnuCitaReportes.add(this.sisMedico);
        this.barraMnuCita.add(this.mnuCitaReportes);
        this.mnuCitaUtilidad.setText("Utilidades");
        this.mnuCitaUtilidad.setFont(new Font("Arial", 1, 12));
        this.JMIAlertaxUsuario.setFont(new Font("Arial", 1, 12));
        this.JMIAlertaxUsuario.setText("Alerta por Usuario");
        this.JMIAlertaxUsuario.setToolTipText("");
        this.JMIAlertaxUsuario.addActionListener(new ActionListener() { // from class: Acceso.Menus.68
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAlertaxUsuarioActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIAlertaxUsuario);
        this.JMIAnularProgramacion.setFont(new Font("Arial", 1, 12));
        this.JMIAnularProgramacion.setText("Anular Programación");
        this.JMIAnularProgramacion.setToolTipText("");
        this.JMIAnularProgramacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.69
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAnularProgramacionActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIAnularProgramacion);
        this.JMIConsultarAgendaEnfermeria.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAgendaEnfermeria.setText("Consultar Agenda Enfermería");
        this.JMIConsultarAgendaEnfermeria.setToolTipText("");
        this.JMIConsultarAgendaEnfermeria.addActionListener(new ActionListener() { // from class: Acceso.Menus.70
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAgendaEnfermeriaActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIConsultarAgendaEnfermeria);
        this.JMIConsultarCitasUsuario.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarCitasUsuario.setText("Consultar Citas por Usuario");
        this.JMIConsultarCitasUsuario.setToolTipText("");
        this.JMIConsultarCitasUsuario.addActionListener(new ActionListener() { // from class: Acceso.Menus.71
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarCitasUsuarioActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIConsultarCitasUsuario);
        this.JMIConsultarRemOrdC.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarRemOrdC.setText("Consultar Remisiones y Ordenes");
        this.JMIConsultarRemOrdC.setToolTipText("");
        this.JMIConsultarRemOrdC.addActionListener(new ActionListener() { // from class: Acceso.Menus.72
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarRemOrdCActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIConsultarRemOrdC);
        this.jMenu4.setText("Logística");
        this.jMenu4.setFont(new Font("Arial", 1, 12));
        this.mnuLogistica.setFont(new Font("Arial", 1, 12));
        this.mnuLogistica.setText("Reporte");
        this.mnuLogistica.setToolTipText("Pasa Programación del mismo profesional entre fechas y de diferentes profesionales");
        this.mnuLogistica.addActionListener(new ActionListener() { // from class: Acceso.Menus.73
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLogisticaActionPerformed(evt);
            }
        });
        this.jMenu4.add(this.mnuLogistica);
        this.mnuCitaUtilidad.add(this.jMenu4);
        this.mnuCitaUtilidadPasarProg.setFont(new Font("Arial", 1, 12));
        this.mnuCitaUtilidadPasarProg.setText("Pasar Programación");
        this.mnuCitaUtilidadPasarProg.setToolTipText("");
        this.mnuCitaUtilidadPasarProg.addActionListener(new ActionListener() { // from class: Acceso.Menus.74
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCitaUtilidadPasarProgActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.mnuCitaUtilidadPasarProg);
        this.mnuCitaUtilidadPasarProg.setVisible(false);
        this.JMIPasarCitasxLote.setFont(new Font("Arial", 1, 12));
        this.JMIPasarCitasxLote.setText("Pasar Citas por Lote");
        this.JMIPasarCitasxLote.setToolTipText("");
        this.JMIPasarCitasxLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.75
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPasarCitasxLoteActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIPasarCitasxLote);
        this.mnuCitaUtilidadProgramacion.setFont(new Font("Arial", 1, 12));
        this.mnuCitaUtilidadProgramacion.setText("Programación de Profesionales");
        this.mnuCitaUtilidadProgramacion.setToolTipText("");
        this.mnuCitaUtilidadProgramacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.76
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCitaUtilidadProgramacionActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.mnuCitaUtilidadProgramacion);
        this.JMIRDiasAsignacionCita.setFont(new Font("Arial", 1, 12));
        this.JMIRDiasAsignacionCita.setText("Oportunidad en Asignación de Citas");
        this.JMIRDiasAsignacionCita.setToolTipText("");
        this.JMIRDiasAsignacionCita.addActionListener(new ActionListener() { // from class: Acceso.Menus.77
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRDiasAsignacionCitaActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIRDiasAsignacionCita);
        this.JMIRegistroExamenesA.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroExamenesA.setText("Registro de Exámenes Alterados");
        this.JMIRegistroExamenesA.setToolTipText("");
        this.JMIRegistroExamenesA.addActionListener(new ActionListener() { // from class: Acceso.Menus.78
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroExamenesAActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIRegistroExamenesA);
        this.JMIRegistroReembolso.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroReembolso.setText("Registro de Reembolso");
        this.JMIRegistroReembolso.setToolTipText("");
        this.JMIRegistroReembolso.addActionListener(new ActionListener() { // from class: Acceso.Menus.79
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroReembolsoActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIRegistroReembolso);
        this.JMIUSolicitudDocClinicos1.setFont(new Font("Arial", 1, 12));
        this.JMIUSolicitudDocClinicos1.setText("Solicitud de Documentos Clínicos");
        this.JMIUSolicitudDocClinicos1.addActionListener(new ActionListener() { // from class: Acceso.Menus.80
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUSolicitudDocClinicos1ActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIUSolicitudDocClinicos1);
        this.JMIUInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMIUInformesGenerales.setText("Informes Generales");
        this.JMIUInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.81
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUInformesGeneralesActionPerformed(evt);
            }
        });
        this.mnuCitaUtilidad.add(this.JMIUInformesGenerales);
        this.barraMnuCita.add(this.mnuCitaUtilidad);
        this.mnuInventarioMovto.setText("Gestión Inventario");
        this.mnuInventarioMovto.setFont(new Font("Arial", 1, 12));
        this.mnuInvEntradas.setFont(new Font("Arial", 1, 12));
        this.mnuInvEntradas.setText("Entradas");
        this.mnuInvEntradas.addActionListener(new ActionListener() { // from class: Acceso.Menus.82
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvEntradasActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.mnuInvEntradas);
        this.mnuInventarioMovto.add(this.jSeparator2);
        this.mnuInvDespachos.setFont(new Font("Arial", 1, 12));
        this.mnuInvDespachos.setText("Dispensación");
        this.mnuInvDespachos.addActionListener(new ActionListener() { // from class: Acceso.Menus.83
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvDespachosActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.mnuInvDespachos);
        this.mnuInvSalidas.setFont(new Font("Arial", 1, 12));
        this.mnuInvSalidas.setText("Salidas");
        this.mnuInvSalidas.addActionListener(new ActionListener() { // from class: Acceso.Menus.84
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvSalidasActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.mnuInvSalidas);
        this.mnuInvTraslados.setFont(new Font("Arial", 1, 12));
        this.mnuInvTraslados.setText("Traslados");
        this.mnuInvTraslados.addActionListener(new ActionListener() { // from class: Acceso.Menus.85
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvTrasladosActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.mnuInvTraslados);
        this.mnuInventarioMovto.add(this.jSeparator3);
        this.JMIMAgendaCirugia.setFont(new Font("Arial", 1, 12));
        this.JMIMAgendaCirugia.setText("Agenda Cirugia");
        this.JMIMAgendaCirugia.addActionListener(new ActionListener() { // from class: Acceso.Menus.86
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIMAgendaCirugiaActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.JMIMAgendaCirugia);
        this.JMIMAgendaUnidosis.setFont(new Font("Arial", 1, 12));
        this.JMIMAgendaUnidosis.setText("Agenda Unidosis");
        this.JMIMAgendaUnidosis.addActionListener(new ActionListener() { // from class: Acceso.Menus.87
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIMAgendaUnidosisActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.JMIMAgendaUnidosis);
        this.mnuInvFaltantes.setFont(new Font("Arial", 1, 12));
        this.mnuInvFaltantes.setText("Descargar Faltante");
        this.mnuInvFaltantes.addActionListener(new ActionListener() { // from class: Acceso.Menus.88
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvFaltantesActionPerformed(evt);
            }
        });
        this.mnuInventarioMovto.add(this.mnuInvFaltantes);
        barraMnuInventario.add(this.mnuInventarioMovto);
        this.JIMInformes.setText("Informes");
        this.JIMInformes.setFont(new Font("Arial", 1, 12));
        this.mnuInventarios.setText("Inventario");
        this.mnuInventarios.setFont(new Font("Arial", 1, 12));
        this.mnuGeneralxArea.setFont(new Font("Arial", 1, 12));
        this.mnuGeneralxArea.setText("General por Area");
        this.mnuGeneralxArea.addActionListener(new ActionListener() { // from class: Acceso.Menus.89
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuGeneralxAreaActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuGeneralxArea);
        this.mnuProximosAVencer.setFont(new Font("Arial", 1, 12));
        this.mnuProximosAVencer.setText("Proximos a Vencer");
        this.mnuProximosAVencer.addActionListener(new ActionListener() { // from class: Acceso.Menus.90
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuProximosAVencerActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuProximosAVencer);
        this.mnuInventarios.add(this.jSeparator5);
        this.mnuListadoDispositivosMedicos.setFont(new Font("Arial", 1, 12));
        this.mnuListadoDispositivosMedicos.setText("Listado de Dispositivos Medicos");
        this.mnuListadoDispositivosMedicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.91
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuListadoDispositivosMedicosActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuListadoDispositivosMedicos);
        this.mnuListadoBasicoMedicamentos.setFont(new Font("Arial", 1, 12));
        this.mnuListadoBasicoMedicamentos.setText("Listado Basico de Medicamentos");
        this.mnuListadoBasicoMedicamentos.addActionListener(new ActionListener() { // from class: Acceso.Menus.92
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuListadoBasicoMedicamentosActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuListadoBasicoMedicamentos);
        this.mnuListadoBasicoMedicamentosPsiquiatria.setFont(new Font("Arial", 1, 12));
        this.mnuListadoBasicoMedicamentosPsiquiatria.setText("Listado Basico de Medicamentos Psiquiatras");
        this.mnuListadoBasicoMedicamentosPsiquiatria.addActionListener(new ActionListener() { // from class: Acceso.Menus.93
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuListadoBasicoMedicamentosPsiquiatriaActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuListadoBasicoMedicamentosPsiquiatria);
        this.mnuGeneralxCategoria.setFont(new Font("Arial", 1, 12));
        this.mnuGeneralxCategoria.setText("Listado General de Productos por categoría");
        this.mnuGeneralxCategoria.addActionListener(new ActionListener() { // from class: Acceso.Menus.94
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuGeneralxCategoriaActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuGeneralxCategoria);
        this.mnuInventarios.add(this.jSeparator6);
        this.mnuCLALasa.setFont(new Font("Arial", 1, 12));
        this.mnuCLALasa.setText("Clasificación LASA");
        this.mnuCLALasa.addActionListener(new ActionListener() { // from class: Acceso.Menus.95
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCLALasaActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuCLALasa);
        this.JMICRotacion.setFont(new Font("Arial", 1, 12));
        this.JMICRotacion.setText("Consultar Productos Sin Rotación");
        this.JMICRotacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.96
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRotacionActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.JMICRotacion);
        this.mnuRotacion1.setFont(new Font("Arial", 1, 12));
        this.mnuRotacion1.setText("Gestión Fecha Vencimiento Invima");
        this.mnuRotacion1.addActionListener(new ActionListener() { // from class: Acceso.Menus.97
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRotacion1ActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuRotacion1);
        this.mnuGeneralxArea1.setFont(new Font("Arial", 1, 12));
        this.mnuGeneralxArea1.setText("Inventario General");
        this.mnuGeneralxArea1.addActionListener(new ActionListener() { // from class: Acceso.Menus.98
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuGeneralxArea1ActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuGeneralxArea1);
        this.mnuMaxyMin.setFont(new Font("Arial", 1, 12));
        this.mnuMaxyMin.setText("Máximos y Mínimos");
        this.mnuMaxyMin.addActionListener(new ActionListener() { // from class: Acceso.Menus.99
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuMaxyMinActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuMaxyMin);
        this.mnuRotacion.setFont(new Font("Arial", 1, 12));
        this.mnuRotacion.setText("Productos con la ultima fecha de rotacion ");
        this.mnuRotacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.100
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRotacionActionPerformed(evt);
            }
        });
        this.mnuInventarios.add(this.mnuRotacion);
        this.JIMInformes.add(this.mnuInventarios);
        this.mnuEntradas.setText("Entradas");
        this.mnuEntradas.setFont(new Font("Arial", 1, 12));
        this.jMenuItem10.setFont(new Font("Arial", 1, 12));
        this.jMenuItem10.setText("Consolidado de Entradas");
        this.jMenuItem10.addActionListener(new ActionListener() { // from class: Acceso.Menus.101
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem10ActionPerformed(evt);
            }
        });
        this.mnuEntradas.add(this.jMenuItem10);
        this.jMenuItem1.setFont(new Font("Arial", 1, 12));
        this.jMenuItem1.setText("Entrada a Inventario");
        this.jMenuItem1.addActionListener(new ActionListener() { // from class: Acceso.Menus.102
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.mnuEntradas.add(this.jMenuItem1);
        this.JIMInformes.add(this.mnuEntradas);
        this.mnuEstadistica.setText("Estadistica");
        this.mnuEstadistica.setFont(new Font("Arial", 1, 12));
        this.mnuInfConsumo.setFont(new Font("Arial", 1, 12));
        this.mnuInfConsumo.setText("Consolidado de Despacho");
        this.mnuInfConsumo.addActionListener(new ActionListener() { // from class: Acceso.Menus.103
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfConsumoActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfConsumo);
        this.mnuInfCDespachoxMedico.setFont(new Font("Arial", 1, 12));
        this.mnuInfCDespachoxMedico.setText("Consolidado de Despacho por Medico");
        this.mnuInfCDespachoxMedico.addActionListener(new ActionListener() { // from class: Acceso.Menus.104
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfCDespachoxMedicoActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfCDespachoxMedico);
        this.mnuInfCPendientesGenerados.setFont(new Font("Arial", 1, 12));
        this.mnuInfCPendientesGenerados.setText("Consolidado de Pendientes Generados");
        this.mnuInfCPendientesGenerados.addActionListener(new ActionListener() { // from class: Acceso.Menus.105
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfCPendientesGeneradosActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfCPendientesGenerados);
        this.mnuInfCTiempoLLamada.setFont(new Font("Arial", 1, 12));
        this.mnuInfCTiempoLLamada.setText("Consultar Tiempos de LLamada");
        this.mnuInfCTiempoLLamada.addActionListener(new ActionListener() { // from class: Acceso.Menus.106
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfCTiempoLLamadaActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfCTiempoLLamada);
        this.mnuInfMovimientoI.setFont(new Font("Arial", 1, 12));
        this.mnuInfMovimientoI.setText("Movimiento");
        this.mnuInfMovimientoI.addActionListener(new ActionListener() { // from class: Acceso.Menus.107
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfMovimientoIActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfMovimientoI);
        this.mnuInfCMovimientoI.setFont(new Font("Arial", 1, 12));
        this.mnuInfCMovimientoI.setText("Movimientos Consolidados");
        this.mnuInfCMovimientoI.addActionListener(new ActionListener() { // from class: Acceso.Menus.108
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfCMovimientoIActionPerformed(evt);
            }
        });
        this.mnuEstadistica.add(this.mnuInfCMovimientoI);
        this.JIMInformes.add(this.mnuEstadistica);
        this.mnuSalidas.setText("Salidas");
        this.mnuSalidas.setFont(new Font("Arial", 1, 12));
        this.mnuInfFaltantes.setText("Faltantes / Pendientes");
        this.mnuInfFaltantes.setFont(new Font("Arial", 1, 12));
        this.jMenuItem2.setFont(new Font("Arial", 1, 12));
        this.jMenuItem2.setText("Faltantes / Pendientes por Despacho");
        this.jMenuItem2.addActionListener(new ActionListener() { // from class: Acceso.Menus.109
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.mnuInfFaltantes.add(this.jMenuItem2);
        this.jMenuItem3.setFont(new Font("Arial", 1, 12));
        this.jMenuItem3.setText("Listado General de Pendientes por Fecha");
        this.jMenuItem3.addActionListener(new ActionListener() { // from class: Acceso.Menus.110
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.mnuInfFaltantes.add(this.jMenuItem3);
        this.jMenuItem4.setFont(new Font("Arial", 1, 12));
        this.jMenuItem4.setText("Listado de Pendientes sin Entregar por Fecha");
        this.jMenuItem4.addActionListener(new ActionListener() { // from class: Acceso.Menus.111
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem4ActionPerformed(evt);
            }
        });
        this.mnuInfFaltantes.add(this.jMenuItem4);
        this.mnuSalidas.add(this.mnuInfFaltantes);
        this.mnuInfDespachos.setText("Despachos");
        this.mnuInfDespachos.setFont(new Font("Arial", 1, 12));
        this.jMenuItem9.setFont(new Font("Arial", 1, 12));
        this.jMenuItem9.setText("General");
        this.jMenuItem9.addActionListener(new ActionListener() { // from class: Acceso.Menus.112
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem9ActionPerformed(evt);
            }
        });
        this.mnuInfDespachos.add(this.jMenuItem9);
        this.jMenuItem7.setFont(new Font("Arial", 1, 12));
        this.jMenuItem7.setText("Por Empresa");
        this.jMenuItem7.addActionListener(new ActionListener() { // from class: Acceso.Menus.113
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem7ActionPerformed(evt);
            }
        });
        this.mnuInfDespachos.add(this.jMenuItem7);
        this.jMenuItem5.setFont(new Font("Arial", 1, 12));
        this.jMenuItem5.setText("Por Fecha por Paciente");
        this.jMenuItem5.addActionListener(new ActionListener() { // from class: Acceso.Menus.114
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem5ActionPerformed(evt);
            }
        });
        this.mnuInfDespachos.add(this.jMenuItem5);
        this.jMenuItem8.setFont(new Font("Arial", 1, 12));
        this.jMenuItem8.setText("Por Fecha por Paciente para Auditoria");
        this.jMenuItem8.addActionListener(new ActionListener() { // from class: Acceso.Menus.115
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem8ActionPerformed(evt);
            }
        });
        this.mnuInfDespachos.add(this.jMenuItem8);
        this.jMenuItem6.setFont(new Font("Arial", 1, 12));
        this.jMenuItem6.setText("Por Fecha por Producto");
        this.jMenuItem6.addActionListener(new ActionListener() { // from class: Acceso.Menus.116
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMenuItem6ActionPerformed(evt);
            }
        });
        this.mnuInfDespachos.add(this.jMenuItem6);
        this.mnuSalidas.add(this.mnuInfDespachos);
        this.mnuInfTraslados.setFont(new Font("Arial", 1, 12));
        this.mnuInfTraslados.setText("Traslados");
        this.mnuInfTraslados.addActionListener(new ActionListener() { // from class: Acceso.Menus.117
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfTrasladosActionPerformed(evt);
            }
        });
        this.mnuSalidas.add(this.mnuInfTraslados);
        this.mnuInfSalidas.setFont(new Font("Arial", 1, 12));
        this.mnuInfSalidas.setText("Salidas");
        this.mnuInfSalidas.addActionListener(new ActionListener() { // from class: Acceso.Menus.118
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfSalidasActionPerformed(evt);
            }
        });
        this.mnuSalidas.add(this.mnuInfSalidas);
        this.mnuInfSomnolencia.setFont(new Font("Arial", 1, 12));
        this.mnuInfSomnolencia.setText("Informe Somnolencia");
        this.mnuInfSomnolencia.addActionListener(new ActionListener() { // from class: Acceso.Menus.119
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInfSomnolenciaActionPerformed(evt);
            }
        });
        this.mnuSalidas.add(this.mnuInfSomnolencia);
        this.mnuConsolidadoSalidas.setFont(new Font("Arial", 1, 12));
        this.mnuConsolidadoSalidas.setText("Consolidado de Salidas");
        this.mnuConsolidadoSalidas.addActionListener(new ActionListener() { // from class: Acceso.Menus.120
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuConsolidadoSalidasActionPerformed(evt);
            }
        });
        this.mnuSalidas.add(this.mnuConsolidadoSalidas);
        this.JIMInformes.add(this.mnuSalidas);
        this.mnuInformeGeneral.setFont(new Font("Arial", 1, 12));
        this.mnuInformeGeneral.setText("Informes Generales");
        this.mnuInformeGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.121
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInformeGeneralActionPerformed(evt);
            }
        });
        this.JIMInformes.add(this.mnuInformeGeneral);
        barraMnuInventario.add(this.JIMInformes);
        this.mnuInventarioUtilidad.setText("Utilidades");
        this.mnuInventarioUtilidad.setToolTipText("Utilidades");
        this.mnuInventarioUtilidad.setFont(new Font("Arial", 1, 12));
        this.mnuAuditoria.setFont(new Font("Arial", 1, 12));
        this.mnuAuditoria.setText("Auditoria");
        this.mnuAuditoria.addActionListener(new ActionListener() { // from class: Acceso.Menus.122
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAuditoriaActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.mnuAuditoria);
        this.mnuInvCons.setFont(new Font("Arial", 1, 12));
        this.mnuInvCons.setText("Consultar Existencias");
        this.mnuInvCons.addActionListener(new ActionListener() { // from class: Acceso.Menus.123
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvConsActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.mnuInvCons);
        this.mnuInvKardex.setFont(new Font("Arial", 1, 12));
        this.mnuInvKardex.setText("Kardex / Movimiento");
        this.mnuInvKardex.addActionListener(new ActionListener() { // from class: Acceso.Menus.124
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInvKardexActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.mnuInvKardex);
        this.mnuInventarioUtilidad.add(this.jSeparator8);
        this.JMUContabilidad.setText("Cierres Contables");
        this.JMUContabilidad.setFont(new Font("Arial", 1, 12));
        this.JMUCConsolidadoCierre.setFont(new Font("Arial", 1, 12));
        this.JMUCConsolidadoCierre.setText("Consolidado de Cierres Contables");
        this.JMUCConsolidadoCierre.addActionListener(new ActionListener() { // from class: Acceso.Menus.125
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUCConsolidadoCierreActionPerformed(evt);
            }
        });
        this.JMUContabilidad.add(this.JMUCConsolidadoCierre);
        this.JMUCCostos.setFont(new Font("Arial", 1, 12));
        this.JMUCCostos.setText("Costo");
        this.JMUCCostos.addActionListener(new ActionListener() { // from class: Acceso.Menus.126
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUCCostosActionPerformed(evt);
            }
        });
        this.JMUContabilidad.add(this.JMUCCostos);
        this.mnuInventarioUtilidad.add(this.JMUContabilidad);
        this.JMIIFormulacionMedica.setFont(new Font("Arial", 1, 12));
        this.JMIIFormulacionMedica.setText("Consultar Formulación Medica en Linea");
        this.JMIIFormulacionMedica.addActionListener(new ActionListener() { // from class: Acceso.Menus.127
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIFormulacionMedicaActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.JMIIFormulacionMedica);
        this.JMIIFormulasGeneradas.setFont(new Font("Arial", 1, 12));
        this.JMIIFormulasGeneradas.setText("Consultar Formulas Generadas");
        this.JMIIFormulasGeneradas.addActionListener(new ActionListener() { // from class: Acceso.Menus.128
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIFormulasGeneradasActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.JMIIFormulasGeneradas);
        this.JMIUMovimientoS.setFont(new Font("Arial", 1, 12));
        this.JMIUMovimientoS.setText("Consultar Información Producto");
        this.JMIUMovimientoS.addActionListener(new ActionListener() { // from class: Acceso.Menus.129
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUMovimientoSActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.JMIUMovimientoS);
        this.JMGestionFaltantes.setText("Faltantes");
        this.JMGestionFaltantes.setFont(new Font("Arial", 1, 12));
        this.JMIUCFaltatesFecha.setFont(new Font("Arial", 1, 12));
        this.JMIUCFaltatesFecha.setText("Consultar Productos");
        this.JMIUCFaltatesFecha.addActionListener(new ActionListener() { // from class: Acceso.Menus.130
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCFaltatesFechaActionPerformed(evt);
            }
        });
        this.JMGestionFaltantes.add(this.JMIUCFaltatesFecha);
        this.JMIUGestionarFaltantes.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionarFaltantes.setText("Gestión de Pendiente");
        this.JMIUGestionarFaltantes.addActionListener(new ActionListener() { // from class: Acceso.Menus.131
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGestionarFaltantesActionPerformed(evt);
            }
        });
        this.JMGestionFaltantes.add(this.JMIUGestionarFaltantes);
        this.mnuInventarioUtilidad.add(this.JMGestionFaltantes);
        this.JMUGestionB.setText("Gestión Bodegas");
        this.JMUGestionB.setFont(new Font("Arial", 1, 12));
        this.JMIIActualizarPendientes.setFont(new Font("Arial", 1, 12));
        this.JMIIActualizarPendientes.setText("Actualizar Pendientes a Cero");
        this.JMIIActualizarPendientes.addActionListener(new ActionListener() { // from class: Acceso.Menus.132
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIActualizarPendientesActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIActualizarPendientes);
        this.JMIIAdicionarProdc.setFont(new Font("Arial", 1, 12));
        this.JMIIAdicionarProdc.setText("Adicionar Productos Bodega-Proveedores");
        this.JMIIAdicionarProdc.addActionListener(new ActionListener() { // from class: Acceso.Menus.133
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIAdicionarProdcActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIAdicionarProdc);
        this.JMIUAjustarPuntosSC.setFont(new Font("Arial", 1, 12));
        this.JMIUAjustarPuntosSC.setText("Ajustar Puntos (Reposición, Mínimo y Máximo)");
        this.JMIUAjustarPuntosSC.addActionListener(new ActionListener() { // from class: Acceso.Menus.134
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAjustarPuntosSCActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIUAjustarPuntosSC);
        this.JMIUCDespachoxEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JMIUCDespachoxEspecialidad.setText("Consultar Despacho x Especialidad");
        this.JMIUCDespachoxEspecialidad.addActionListener(new ActionListener() { // from class: Acceso.Menus.135
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCDespachoxEspecialidadActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIUCDespachoxEspecialidad);
        this.JMIIKardex.setFont(new Font("Arial", 1, 12));
        this.JMIIKardex.setText("Kardex");
        this.JMIIKardex.addActionListener(new ActionListener() { // from class: Acceso.Menus.136
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIKardexActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIKardex);
        this.JMIIKardex_P.setFont(new Font("Arial", 1, 12));
        this.JMIIKardex_P.setText("Kardex Producto");
        this.JMIIKardex_P.addActionListener(new ActionListener() { // from class: Acceso.Menus.137
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIKardex_PActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIKardex_P);
        this.JMIUModificarSolicitud.setFont(new Font("Arial", 1, 12));
        this.JMIUModificarSolicitud.setText("Modificar Estado de Productos x Solicitud");
        this.JMIUModificarSolicitud.addActionListener(new ActionListener() { // from class: Acceso.Menus.138
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUModificarSolicitudActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIUModificarSolicitud);
        this.JMIIModificarMPM.setFont(new Font("Arial", 1, 12));
        this.JMIIModificarMPM.setText("Modificar PReposicion, Minimos y Maximos");
        this.JMIIModificarMPM.addActionListener(new ActionListener() { // from class: Acceso.Menus.139
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIModificarMPMActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIModificarMPM);
        this.JMIIModificarCodAg.setFont(new Font("Arial", 1, 12));
        this.JMIIModificarCodAg.setText("Modificar y Consultar Código de Agrupación");
        this.JMIIModificarCodAg.addActionListener(new ActionListener() { // from class: Acceso.Menus.140
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIModificarCodAgActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIModificarCodAg);
        this.JMIIRepBodegas.setFont(new Font("Arial", 1, 12));
        this.JMIIRepBodegas.setText("Reposiciones a Bodegas");
        this.JMIIRepBodegas.addActionListener(new ActionListener() { // from class: Acceso.Menus.141
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIRepBodegasActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIIRepBodegas);
        this.JMIUGestionarPreposicion.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionarPreposicion.setText("Solicitud de Productos");
        this.JMIUGestionarPreposicion.addActionListener(new ActionListener() { // from class: Acceso.Menus.142
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGestionarPreposicionActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIUGestionarPreposicion);
        this.JMIUSuministroLote.setFont(new Font("Arial", 1, 12));
        this.JMIUSuministroLote.setText("Suministro por Bodega por Lote");
        this.JMIUSuministroLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.143
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUSuministroLoteActionPerformed(evt);
            }
        });
        this.JMUGestionB.add(this.JMIUSuministroLote);
        this.mnuInventarioUtilidad.add(this.JMUGestionB);
        this.JMUInventario.setText("Inventario");
        this.JMUInventario.setFont(new Font("Arial", 1, 12));
        this.mnuPrepararInv.setFont(new Font("Arial", 1, 12));
        this.mnuPrepararInv.setMnemonic('P');
        this.mnuPrepararInv.setText("1- Preparar Inventario");
        this.mnuPrepararInv.setToolTipText("");
        this.mnuPrepararInv.addActionListener(new ActionListener() { // from class: Acceso.Menus.144
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPrepararInvActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuPrepararInv);
        this.mnuConteo1.setFont(new Font("Arial", 1, 12));
        this.mnuConteo1.setMnemonic('C');
        this.mnuConteo1.setText("2- Primer Conteo");
        this.mnuConteo1.setToolTipText("Primer onteo de Inventarios");
        this.mnuConteo1.addActionListener(new ActionListener() { // from class: Acceso.Menus.145
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuConteo1ActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuConteo1);
        this.mnuConteo2.setFont(new Font("Arial", 1, 12));
        this.mnuConteo2.setMnemonic('S');
        this.mnuConteo2.setText("3- Segundo Conteo (Opcional)");
        this.mnuConteo2.setToolTipText("egundo Conteo de Inventario");
        this.mnuConteo2.addActionListener(new ActionListener() { // from class: Acceso.Menus.146
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuConteo2ActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuConteo2);
        this.mnuCierreInv.setFont(new Font("Arial", 1, 12));
        this.mnuCierreInv.setMnemonic('I');
        this.mnuCierreInv.setText("4- Cierre de Inventario");
        this.mnuCierreInv.setToolTipText("Cierre de Inventario");
        this.mnuCierreInv.addActionListener(new ActionListener() { // from class: Acceso.Menus.147
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCierreInvActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuCierreInv);
        this.mnuCrearLote.setFont(new Font("Arial", 1, 12));
        this.mnuCrearLote.setText("Crear Lotes");
        this.mnuCrearLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.148
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuCrearLoteActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuCrearLote);
        this.mnuImprimirInv.setFont(new Font("Arial", 1, 12));
        this.mnuImprimirInv.setText("Informes");
        this.mnuImprimirInv.setToolTipText("Informes del Inventario");
        this.mnuImprimirInv.addActionListener(new ActionListener() { // from class: Acceso.Menus.149
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuImprimirInvActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuImprimirInv);
        this.mnuModificarLote.setFont(new Font("Arial", 1, 12));
        this.mnuModificarLote.setText("Modificar Lote");
        this.mnuModificarLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.150
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuModificarLoteActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuModificarLote);
        this.mnuMonitoreo.setFont(new Font("Arial", 1, 12));
        this.mnuMonitoreo.setMnemonic('P');
        this.mnuMonitoreo.setText("Monitoreo");
        this.mnuMonitoreo.addActionListener(new ActionListener() { // from class: Acceso.Menus.151
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuMonitoreoActionPerformed(evt);
            }
        });
        this.JMUInventario.add(this.mnuMonitoreo);
        this.mnuInventarioUtilidad.add(this.JMUInventario);
        this.JMUContabilidad1.setText("Logística");
        this.JMUContabilidad1.setFont(new Font("Arial", 1, 12));
        this.JMReporteI.setFont(new Font("Arial", 1, 12));
        this.JMReporteI.setText("Reporte");
        this.JMReporteI.addActionListener(new ActionListener() { // from class: Acceso.Menus.152
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMReporteIActionPerformed(evt);
            }
        });
        this.JMUContabilidad1.add(this.JMReporteI);
        this.mnuInventarioUtilidad.add(this.JMUContabilidad1);
        this.JMIPeriodoContableI.setFont(new Font("Arial", 1, 12));
        this.JMIPeriodoContableI.setText("Periodos de Inventario");
        this.JMIPeriodoContableI.addActionListener(new ActionListener() { // from class: Acceso.Menus.153
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPeriodoContableIActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.JMIPeriodoContableI);
        this.JMUTempBodega.setFont(new Font("Arial", 1, 12));
        this.JMUTempBodega.setText("Temperatura Bodega");
        this.JMUTempBodega.addActionListener(new ActionListener() { // from class: Acceso.Menus.154
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUTempBodegaActionPerformed(evt);
            }
        });
        this.mnuInventarioUtilidad.add(this.JMUTempBodega);
        barraMnuInventario.add(this.mnuInventarioUtilidad);
        this.mnuContabilidad.setText("Contabilidad");
        this.mnuContabilidad.setToolTipText("");
        this.mnuContabilidad.setFont(new Font("Arial", 1, 12));
        this.JMCCajaM.setText("Caja Menor");
        this.JMCCajaM.setFont(new Font("Arial", 1, 12));
        this.JMICRegistroRecibos.setFont(new Font("Arial", 1, 12));
        this.JMICRegistroRecibos.setText("Registro Recibos");
        this.JMICRegistroRecibos.setToolTipText("");
        this.JMICRegistroRecibos.addActionListener(new ActionListener() { // from class: Acceso.Menus.155
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRegistroRecibosActionPerformed(evt);
            }
        });
        this.JMCCajaM.add(this.JMICRegistroRecibos);
        this.JMICSolicitudR.setFont(new Font("Arial", 1, 12));
        this.JMICSolicitudR.setText("Solicitud de Reembolso");
        this.JMICSolicitudR.setToolTipText("");
        this.JMICSolicitudR.addActionListener(new ActionListener() { // from class: Acceso.Menus.156
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICSolicitudRActionPerformed(evt);
            }
        });
        this.JMCCajaM.add(this.JMICSolicitudR);
        this.mnuContabilidad.add(this.JMCCajaM);
        this.JMICDocumentoC.setFont(new Font("Arial", 1, 12));
        this.JMICDocumentoC.setText("Documento Contable");
        this.JMICDocumentoC.setToolTipText("");
        this.JMICDocumentoC.addActionListener(new ActionListener() { // from class: Acceso.Menus.157
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICDocumentoCActionPerformed(evt);
            }
        });
        this.mnuContabilidad.add(this.JMICDocumentoC);
        this.JMCFactura.setText("Factura");
        this.JMCFactura.setFont(new Font("Arial", 1, 12));
        this.JMICGPago.setFont(new Font("Arial", 1, 12));
        this.JMICGPago.setText("Generar Pago");
        this.JMICGPago.setToolTipText("");
        this.JMICGPago.addActionListener(new ActionListener() { // from class: Acceso.Menus.158
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICGPagoActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICGPago);
        this.JMICGPago1.setFont(new Font("Arial", 1, 12));
        this.JMICGPago1.setText("Generar Pago Individual");
        this.JMICGPago1.setToolTipText("");
        this.JMICGPago1.addActionListener(new ActionListener() { // from class: Acceso.Menus.159
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICGPago1ActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICGPago1);
        this.JMICRadicacion.setFont(new Font("Arial", 1, 12));
        this.JMICRadicacion.setText("Radicación");
        this.JMICRadicacion.setToolTipText("");
        this.JMICRadicacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.160
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRadicacionActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICRadicacion);
        this.JMICRadicacionNC.setFont(new Font("Arial", 1, 12));
        this.JMICRadicacionNC.setText("Radicación Nota Crédito");
        this.JMICRadicacionNC.setToolTipText("");
        this.JMICRadicacionNC.addActionListener(new ActionListener() { // from class: Acceso.Menus.161
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRadicacionNCActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICRadicacionNC);
        this.JMICSeleccionC.setFont(new Font("Arial", 1, 12));
        this.JMICSeleccionC.setText("Selección de Documento para Pago");
        this.JMICSeleccionC.setToolTipText("");
        this.JMICSeleccionC.addActionListener(new ActionListener() { // from class: Acceso.Menus.162
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICSeleccionCActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICSeleccionC);
        this.JMICSeleccionC1.setFont(new Font("Arial", 1, 12));
        this.JMICSeleccionC1.setText("Gestión Facturas Dian Recibidas");
        this.JMICSeleccionC1.setToolTipText("");
        this.JMICSeleccionC1.addActionListener(new ActionListener() { // from class: Acceso.Menus.163
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICSeleccionC1ActionPerformed(evt);
            }
        });
        this.JMCFactura.add(this.JMICSeleccionC1);
        this.mnuContabilidad.add(this.JMCFactura);
        this.JMCCuentaC.setText("Generación Cuenta Cobro");
        this.JMCCuentaC.setFont(new Font("Arial", 1, 12));
        this.JMICCuentaCobroA.setFont(new Font("Arial", 1, 12));
        this.JMICCuentaCobroA.setText("Automatica");
        this.JMICCuentaCobroA.setToolTipText("");
        this.JMICCuentaCobroA.addActionListener(new ActionListener() { // from class: Acceso.Menus.164
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICCuentaCobroAActionPerformed(evt);
            }
        });
        this.JMCCuentaC.add(this.JMICCuentaCobroA);
        this.JMICCuentaCobroM.setFont(new Font("Arial", 1, 12));
        this.JMICCuentaCobroM.setText("Manual");
        this.JMICCuentaCobroM.setToolTipText("");
        this.JMICCuentaCobroM.addActionListener(new ActionListener() { // from class: Acceso.Menus.165
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICCuentaCobroMActionPerformed(evt);
            }
        });
        this.JMCCuentaC.add(this.JMICCuentaCobroM);
        this.mnuContabilidad.add(this.JMCCuentaC);
        this.JMCReembolso.setText("Reembolso");
        this.JMCReembolso.setFont(new Font("Arial", 1, 12));
        this.JMICRadicacionR.setFont(new Font("Arial", 1, 12));
        this.JMICRadicacionR.setText("Radicación");
        this.JMICRadicacionR.setToolTipText("");
        this.JMICRadicacionR.addActionListener(new ActionListener() { // from class: Acceso.Menus.166
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRadicacionRActionPerformed(evt);
            }
        });
        this.JMCReembolso.add(this.JMICRadicacionR);
        this.mnuContabilidad.add(this.JMCReembolso);
        this.jMPagosNomina.setFont(new Font("Arial", 1, 12));
        this.jMPagosNomina.setText("Pagos nomina");
        this.jMPagosNomina.addActionListener(new ActionListener() { // from class: Acceso.Menus.167
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMPagosNominaActionPerformed(evt);
            }
        });
        this.mnuContabilidad.add(this.jMPagosNomina);
        barraMnuContabilidad.add(this.mnuContabilidad);
        this.JMCAuditoria.setText("Autorización");
        this.JMCAuditoria.setToolTipText("");
        this.JMCAuditoria.setFont(new Font("Arial", 1, 12));
        this.JMIAAutorizacionDoc.setFont(new Font("Arial", 1, 12));
        this.JMIAAutorizacionDoc.setText("Documentos por Fecha y Tercero");
        this.JMIAAutorizacionDoc.setToolTipText("");
        this.JMIAAutorizacionDoc.addActionListener(new ActionListener() { // from class: Acceso.Menus.168
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAAutorizacionDocActionPerformed(evt);
            }
        });
        this.JMCAuditoria.add(this.JMIAAutorizacionDoc);
        barraMnuContabilidad.add(this.JMCAuditoria);
        this.JMCInformes.setText("Informes");
        this.JMCInformes.setToolTipText("");
        this.JMCInformes.setFont(new Font("Arial", 1, 12));
        this.JMIBalanceContable.setFont(new Font("Arial", 1, 12));
        this.JMIBalanceContable.setText("Balance Contable");
        this.JMIBalanceContable.setToolTipText("");
        this.JMIBalanceContable.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIBalanceContable.addActionListener(new ActionListener() { // from class: Acceso.Menus.169
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIBalanceContableActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIBalanceContable);
        this.JMIBalanceContable1.setFont(new Font("Arial", 1, 12));
        this.JMIBalanceContable1.setText("Balance Contable por Fecha");
        this.JMIBalanceContable1.setToolTipText("");
        this.JMIBalanceContable1.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIBalanceContable1.addActionListener(new ActionListener() { // from class: Acceso.Menus.170
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIBalanceContable1ActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIBalanceContable1);
        this.JMIBalanceContable2.setFont(new Font("Arial", 1, 12));
        this.JMIBalanceContable2.setText("Balance General");
        this.JMIBalanceContable2.setToolTipText("");
        this.JMIBalanceContable2.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIBalanceContable2.addActionListener(new ActionListener() { // from class: Acceso.Menus.171
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIBalanceContable2ActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIBalanceContable2);
        this.JMIInformeTipoImpuesto1.setFont(new Font("Arial", 1, 12));
        this.JMIInformeTipoImpuesto1.setText("Consultar Cuentas Por Pagar");
        this.JMIInformeTipoImpuesto1.setToolTipText("");
        this.JMIInformeTipoImpuesto1.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIInformeTipoImpuesto1.addActionListener(new ActionListener() { // from class: Acceso.Menus.172
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeTipoImpuesto1ActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIInformeTipoImpuesto1);
        this.JMIUConsultarDocTercero.setFont(new Font("Arial", 1, 12));
        this.JMIUConsultarDocTercero.setText("Consultar Documentos x Terceros");
        this.JMIUConsultarDocTercero.setToolTipText("");
        this.JMIUConsultarDocTercero.addActionListener(new ActionListener() { // from class: Acceso.Menus.173
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUConsultarDocTerceroActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIUConsultarDocTercero);
        this.JMICI_ConsultarEstadoFacturas.setFont(new Font("Arial", 1, 12));
        this.JMICI_ConsultarEstadoFacturas.setText("Consultar Estado de Facturas para Auditoría");
        this.JMICI_ConsultarEstadoFacturas.setToolTipText("");
        this.JMICI_ConsultarEstadoFacturas.addActionListener(new ActionListener() { // from class: Acceso.Menus.174
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICI_ConsultarEstadoFacturasActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMICI_ConsultarEstadoFacturas);
        this.JMICIEjecucionP.setFont(new Font("Arial", 1, 12));
        this.JMICIEjecucionP.setText("Ejecución Presupuestal");
        this.JMICIEjecucionP.setToolTipText("");
        this.JMICIEjecucionP.addActionListener(new ActionListener() { // from class: Acceso.Menus.175
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICIEjecucionPActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMICIEjecucionP);
        this.JMIEstadoFinancieroComp.setFont(new Font("Arial", 1, 12));
        this.JMIEstadoFinancieroComp.setText("Estados Financieros");
        this.JMIEstadoFinancieroComp.addActionListener(new ActionListener() { // from class: Acceso.Menus.176
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEstadoFinancieroCompActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIEstadoFinancieroComp);
        this.JMIMediosDian.setText("Entidades Externas");
        this.JMIMediosDian.setFont(new Font("Arial", 1, 12));
        this.JMIDMedios.setFont(new Font("Arial", 1, 12));
        this.JMIDMedios.setText("Medios Magnéticos Dian");
        this.JMIDMedios.setToolTipText("");
        this.JMIDMedios.addActionListener(new ActionListener() { // from class: Acceso.Menus.177
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDMediosActionPerformed(evt);
            }
        });
        this.JMIMediosDian.add(this.JMIDMedios);
        this.JMIDMedios1.setFont(new Font("Arial", 1, 12));
        this.JMIDMedios1.setText("Medios Magnéticos Distritales");
        this.JMIDMedios1.setToolTipText("");
        this.JMIDMedios1.addActionListener(new ActionListener() { // from class: Acceso.Menus.178
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDMedios1ActionPerformed(evt);
            }
        });
        this.JMIMediosDian.add(this.JMIDMedios1);
        this.JMCInformes.add(this.JMIMediosDian);
        this.JMIGasto.setText("Gasto");
        this.JMIGasto.setFont(new Font("Arial", 1, 12));
        this.JMICRConsolidado.setFont(new Font("Arial", 1, 12));
        this.JMICRConsolidado.setText("Consolidado por Fecha");
        this.JMICRConsolidado.setToolTipText("");
        this.JMICRConsolidado.addActionListener(new ActionListener() { // from class: Acceso.Menus.179
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRConsolidadoActionPerformed(evt);
            }
        });
        this.JMIGasto.add(this.JMICRConsolidado);
        this.JMCInformes.add(this.JMIGasto);
        this.JMIInformeContraloria.setFont(new Font("Arial", 1, 12));
        this.JMIInformeContraloria.setText("Información Contraloría");
        this.JMIInformeContraloria.setToolTipText("");
        this.JMIInformeContraloria.setActionCommand("Informacion Contraloria");
        this.JMIInformeContraloria.addActionListener(new ActionListener() { // from class: Acceso.Menus.180
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeContraloriaActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIInformeContraloria);
        this.JMIInformeFinancieros.setText("Informes Financieros");
        this.JMIInformeFinancieros.setFont(new Font("Arial", 1, 12));
        this.JMIDEstadoResultado.setFont(new Font("Arial", 1, 12));
        this.JMIDEstadoResultado.setText("Estado de Resultado");
        this.JMIDEstadoResultado.setToolTipText("");
        this.JMIDEstadoResultado.addActionListener(new ActionListener() { // from class: Acceso.Menus.181
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDEstadoResultadoActionPerformed(evt);
            }
        });
        this.JMIInformeFinancieros.add(this.JMIDEstadoResultado);
        this.JMCInformes.add(this.JMIInformeFinancieros);
        this.JMIRInventario.setText("Inventario");
        this.JMIRInventario.setFont(new Font("Arial", 1, 12));
        this.JMIIAuditoriasAleatorias.setFont(new Font("Arial", 1, 12));
        this.JMIIAuditoriasAleatorias.setText("Auditorias Aleatorias");
        this.JMIIAuditoriasAleatorias.addActionListener(new ActionListener() { // from class: Acceso.Menus.182
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIAuditoriasAleatoriasActionPerformed(evt);
            }
        });
        this.JMIRInventario.add(this.JMIIAuditoriasAleatorias);
        this.JMIIConciliacionInv.setFont(new Font("Arial", 1, 12));
        this.JMIIConciliacionInv.setText("Conciliación Inventario");
        this.JMIIConciliacionInv.addActionListener(new ActionListener() { // from class: Acceso.Menus.183
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIConciliacionInvActionPerformed(evt);
            }
        });
        this.JMIRInventario.add(this.JMIIConciliacionInv);
        this.JMIInformeDespacho.setFont(new Font("Arial", 1, 12));
        this.JMIInformeDespacho.setText("Movimientos Consolidados Servicio Farmacéutico");
        this.JMIInformeDespacho.addActionListener(new ActionListener() { // from class: Acceso.Menus.184
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeDespachoActionPerformed(evt);
            }
        });
        this.JMIRInventario.add(this.JMIInformeDespacho);
        this.JMIIKardexI.setFont(new Font("Arial", 1, 12));
        this.JMIIKardexI.setText("Kardex");
        this.JMIIKardexI.addActionListener(new ActionListener() { // from class: Acceso.Menus.185
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIKardexIActionPerformed(evt);
            }
        });
        this.JMIRInventario.add(this.JMIIKardexI);
        this.JMCInformes.add(this.JMIRInventario);
        this.JMILibroAuxiliar.setText("Libro Auxiliar");
        this.JMILibroAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JMICLibroGeneral.setFont(new Font("Arial", 1, 12));
        this.JMICLibroGeneral.setText("General");
        this.JMICLibroGeneral.setToolTipText("");
        this.JMICLibroGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.186
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICLibroGeneralActionPerformed(evt);
            }
        });
        this.JMILibroAuxiliar.add(this.JMICLibroGeneral);
        this.JMICLibroRangoCuenta.setFont(new Font("Arial", 1, 12));
        this.JMICLibroRangoCuenta.setText("Filtrado por Rango de Cuenta");
        this.JMICLibroRangoCuenta.setToolTipText("");
        this.JMICLibroRangoCuenta.addActionListener(new ActionListener() { // from class: Acceso.Menus.187
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICLibroRangoCuentaActionPerformed(evt);
            }
        });
        this.JMILibroAuxiliar.add(this.JMICLibroRangoCuenta);
        this.JMICLibroTerceros.setFont(new Font("Arial", 1, 12));
        this.JMICLibroTerceros.setText("Fitrado por Tercero");
        this.JMICLibroTerceros.setToolTipText("");
        this.JMICLibroTerceros.addActionListener(new ActionListener() { // from class: Acceso.Menus.188
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICLibroTercerosActionPerformed(evt);
            }
        });
        this.JMILibroAuxiliar.add(this.JMICLibroTerceros);
        this.JMCInformes.add(this.JMILibroAuxiliar);
        this.JMI_LibroDiario.setFont(new Font("Arial", 1, 12));
        this.JMI_LibroDiario.setText("Libro Diario");
        this.JMI_LibroDiario.setToolTipText("");
        this.JMI_LibroDiario.addActionListener(new ActionListener() { // from class: Acceso.Menus.189
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_LibroDiarioActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMI_LibroDiario);
        this.JMIILibroMayor.setFont(new Font("Arial", 1, 12));
        this.JMIILibroMayor.setText("Libro Mayor");
        this.JMIILibroMayor.addActionListener(new ActionListener() { // from class: Acceso.Menus.190
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIILibroMayorActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIILibroMayor);
        this.JMIMovimiento.setFont(new Font("Arial", 1, 12));
        this.JMIMovimiento.setText("Movimientos");
        this.JMIMovimiento.setToolTipText("");
        this.JMIMovimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.191
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIMovimientoActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIMovimiento);
        this.JMIMovimiento_Tercero.setFont(new Font("Arial", 1, 12));
        this.JMIMovimiento_Tercero.setText("Movimientos por Tercero");
        this.JMIMovimiento_Tercero.setToolTipText("");
        this.JMIMovimiento_Tercero.addActionListener(new ActionListener() { // from class: Acceso.Menus.192
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIMovimiento_TerceroActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIMovimiento_Tercero);
        this.JMIRelacionPago.setFont(new Font("Arial", 1, 12));
        this.JMIRelacionPago.setText("Relación de Pagos");
        this.JMIRelacionPago.setToolTipText("");
        this.JMIRelacionPago.addActionListener(new ActionListener() { // from class: Acceso.Menus.193
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRelacionPagoActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIRelacionPago);
        this.JMIInformeTipoImpuesto.setFont(new Font("Arial", 1, 12));
        this.JMIInformeTipoImpuesto.setText("Reportes de Bases Gravadas");
        this.JMIInformeTipoImpuesto.setToolTipText("");
        this.JMIInformeTipoImpuesto.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIInformeTipoImpuesto.addActionListener(new ActionListener() { // from class: Acceso.Menus.194
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeTipoImpuestoActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIInformeTipoImpuesto);
        this.JMIInformeTipoImpuesto2.setFont(new Font("Arial", 1, 12));
        this.JMIInformeTipoImpuesto2.setText("Informes Generales");
        this.JMIInformeTipoImpuesto2.setToolTipText("");
        this.JMIInformeTipoImpuesto2.setActionCommand("Reportes de Bases Gravadas Acumuladas");
        this.JMIInformeTipoImpuesto2.addActionListener(new ActionListener() { // from class: Acceso.Menus.195
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeTipoImpuesto2ActionPerformed(evt);
            }
        });
        this.JMCInformes.add(this.JMIInformeTipoImpuesto2);
        barraMnuContabilidad.add(this.JMCInformes);
        this.JMCUAnularDocXCCobro.setText("Utilidades");
        this.JMCUAnularDocXCCobro.setToolTipText("");
        this.JMCUAnularDocXCCobro.setFont(new Font("Arial", 1, 12));
        this.JMIUAjusteDoc.setFont(new Font("Arial", 1, 12));
        this.JMIUAjusteDoc.setText("Ajuste DocumentoC");
        this.JMIUAjusteDoc.setToolTipText("");
        this.JMIUAjusteDoc.addActionListener(new ActionListener() { // from class: Acceso.Menus.196
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAjusteDocActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIUAjusteDoc);
        JMIUAjusteDoc1.setFont(new Font("Arial", 1, 12));
        JMIUAjusteDoc1.setText("Anular Documentos Por Cuenta de Cobro");
        JMIUAjusteDoc1.setToolTipText("");
        JMIUAjusteDoc1.addActionListener(new ActionListener() { // from class: Acceso.Menus.197
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAjusteDoc1ActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(JMIUAjusteDoc1);
        this.JMICGasto.setFont(new Font("Arial", 1, 12));
        this.JMICGasto.setText("Cargar Gasto");
        this.JMICGasto.setToolTipText("");
        this.JMICGasto.addActionListener(new ActionListener() { // from class: Acceso.Menus.198
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICGastoActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMICGasto);
        this.JMUGCertificadoI.setText("Certificado de Impuestos");
        this.JMUGCertificadoI.setFont(new Font("Arial", 1, 12));
        this.JMUGCertificadoI.addActionListener(new ActionListener() { // from class: Acceso.Menus.199
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUGCertificadoIActionPerformed(evt);
            }
        });
        this.JMIUCManual.setFont(new Font("Arial", 1, 12));
        this.JMIUCManual.setText("Manual");
        this.JMIUCManual.setToolTipText("");
        this.JMIUCManual.addActionListener(new ActionListener() { // from class: Acceso.Menus.200
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCManualActionPerformed(evt);
            }
        });
        this.JMUGCertificadoI.add(this.JMIUCManual);
        this.JMIUCAutomatico.setFont(new Font("Arial", 1, 12));
        this.JMIUCAutomatico.setText("Automático");
        this.JMIUCAutomatico.addActionListener(new ActionListener() { // from class: Acceso.Menus.201
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCAutomaticoActionPerformed(evt);
            }
        });
        this.JMUGCertificadoI.add(this.JMIUCAutomatico);
        this.JMCUAnularDocXCCobro.add(this.JMUGCertificadoI);
        this.JMUCCierre.setText("Cierre");
        this.JMUCCierre.setFont(new Font("Arial", 1, 12));
        this.JMIUCuentasCGI.setFont(new Font("Arial", 1, 12));
        this.JMIUCuentasCGI.setText("Cuentas CGI");
        this.JMIUCuentasCGI.setToolTipText("");
        this.JMIUCuentasCGI.addActionListener(new ActionListener() { // from class: Acceso.Menus.202
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCuentasCGIActionPerformed(evt);
            }
        });
        this.JMUCCierre.add(this.JMIUCuentasCGI);
        this.JMIUCImpuesto.setFont(new Font("Arial", 1, 12));
        this.JMIUCImpuesto.setText("Impuesto");
        this.JMIUCImpuesto.setToolTipText("");
        this.JMIUCImpuesto.addActionListener(new ActionListener() { // from class: Acceso.Menus.203
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCImpuestoActionPerformed(evt);
            }
        });
        this.JMUCCierre.add(this.JMIUCImpuesto);
        this.JMCUAnularDocXCCobro.add(this.JMUCCierre);
        this.JMICExportar.setFont(new Font("Arial", 1, 12));
        this.JMICExportar.setText("Consultar Documentos Contables");
        this.JMICExportar.setToolTipText("");
        this.JMICExportar.addActionListener(new ActionListener() { // from class: Acceso.Menus.204
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICExportarActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMICExportar);
        this.JMIUCuentasGastosR.setFont(new Font("Arial", 1, 12));
        this.JMIUCuentasGastosR.setText("Cuentas Gastos Retención");
        this.JMIUCuentasGastosR.setToolTipText("");
        this.JMIUCuentasGastosR.addActionListener(new ActionListener() { // from class: Acceso.Menus.205
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCuentasGastosRActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIUCuentasGastosR);
        this.JMIDocDescuadrados.setFont(new Font("Arial", 1, 12));
        this.JMIDocDescuadrados.setText("Documentos descuadrados");
        this.JMIDocDescuadrados.addActionListener(new ActionListener() { // from class: Acceso.Menus.206
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDocDescuadradosActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIDocDescuadrados);
        this.JMIUGenerarDisfon.setFont(new Font("Arial", 1, 12));
        this.JMIUGenerarDisfon.setText("Generar Disfon");
        this.JMIUGenerarDisfon.setToolTipText("");
        this.JMIUGenerarDisfon.addActionListener(new ActionListener() { // from class: Acceso.Menus.207
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGenerarDisfonActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIUGenerarDisfon);
        this.JMUCUGActivo.setText("Gestión Activos");
        this.JMUCUGActivo.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionActivos.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionActivos.setText("Activos");
        this.JMIUGestionActivos.setToolTipText("");
        this.JMIUGestionActivos.addActionListener(new ActionListener() { // from class: Acceso.Menus.208
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGestionActivosActionPerformed(evt);
            }
        });
        this.JMUCUGActivo.add(this.JMIUGestionActivos);
        this.JMIUCDepreciacion.setFont(new Font("Arial", 1, 12));
        this.JMIUCDepreciacion.setText("Depreciación");
        this.JMIUCDepreciacion.setToolTipText("");
        this.JMIUCDepreciacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.209
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCDepreciacionActionPerformed(evt);
            }
        });
        this.JMUCUGActivo.add(this.JMIUCDepreciacion);
        this.JMCUAnularDocXCCobro.add(this.JMUCUGActivo);
        this.JMUGestionTerceros.setText("Gestión Terceros");
        this.JMUGestionTerceros.setFont(new Font("Arial", 1, 12));
        this.JMIUGTActivar.setFont(new Font("Arial", 1, 12));
        this.JMIUGTActivar.setText("Activar");
        this.JMIUGTActivar.setToolTipText("");
        this.JMIUGTActivar.addActionListener(new ActionListener() { // from class: Acceso.Menus.210
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGTActivarActionPerformed(evt);
            }
        });
        this.JMUGestionTerceros.add(this.JMIUGTActivar);
        this.JMCUAnularDocXCCobro.add(this.JMUGestionTerceros);
        this.JMUImportacionDoc.setText("Importación Soportes");
        this.JMUImportacionDoc.setFont(new Font("Arial", 1, 12));
        this.JMIUIFacturas.setFont(new Font("Arial", 1, 12));
        this.JMIUIFacturas.setText("Facturas");
        this.JMIUIFacturas.setToolTipText("");
        this.JMIUIFacturas.addActionListener(new ActionListener() { // from class: Acceso.Menus.211
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUIFacturasActionPerformed(evt);
            }
        });
        this.JMUImportacionDoc.add(this.JMIUIFacturas);
        this.JMCUAnularDocXCCobro.add(this.JMUImportacionDoc);
        JMIUModificacionDocC.setFont(new Font("Arial", 1, 12));
        JMIUModificacionDocC.setText("Modificación Documento Contables");
        JMIUModificacionDocC.setToolTipText("");
        JMIUModificacionDocC.addActionListener(new ActionListener() { // from class: Acceso.Menus.212
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUModificacionDocCActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(JMIUModificacionDocC);
        this.JMIUPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JMIUPeriodoC.setText("Periodos Contables");
        this.JMIUPeriodoC.setToolTipText("");
        this.JMIUPeriodoC.addActionListener(new ActionListener() { // from class: Acceso.Menus.213
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUPeriodoCActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIUPeriodoC);
        this.JMIUPeriodoF.setFont(new Font("Arial", 1, 12));
        this.JMIUPeriodoF.setText("Periodos Financieros");
        this.JMIUPeriodoF.setToolTipText("");
        this.JMIUPeriodoF.addActionListener(new ActionListener() { // from class: Acceso.Menus.214
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUPeriodoFActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIUPeriodoF);
        this.JMUPuc.setText("Puc");
        this.JMUPuc.setFont(new Font("Arial", 1, 12));
        this.JMIUIPCrearCuenta.setFont(new Font("Arial", 1, 12));
        this.JMIUIPCrearCuenta.setText("Crear Cuenta");
        this.JMIUIPCrearCuenta.setToolTipText("");
        this.JMIUIPCrearCuenta.addActionListener(new ActionListener() { // from class: Acceso.Menus.215
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUIPCrearCuentaActionPerformed(evt);
            }
        });
        this.JMUPuc.add(this.JMIUIPCrearCuenta);
        this.JMIUPlanCuenta.setFont(new Font("Arial", 1, 12));
        this.JMIUPlanCuenta.setText("Plan de Cuenta");
        this.JMIUPlanCuenta.setToolTipText("");
        this.JMIUPlanCuenta.addActionListener(new ActionListener() { // from class: Acceso.Menus.216
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUPlanCuentaActionPerformed(evt);
            }
        });
        this.JMUPuc.add(this.JMIUPlanCuenta);
        this.JMCUAnularDocXCCobro.add(this.JMUPuc);
        this.JMIURegistroFac.setFont(new Font("Arial", 1, 12));
        this.JMIURegistroFac.setText("Registro de Facturas");
        this.JMIURegistroFac.setToolTipText("");
        this.JMIURegistroFac.addActionListener(new ActionListener() { // from class: Acceso.Menus.217
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURegistroFacActionPerformed(evt);
            }
        });
        this.JMCUAnularDocXCCobro.add(this.JMIURegistroFac);
        barraMnuContabilidad.add(this.JMCUAnularDocXCCobro);
        this.barraMnuPyP.setToolTipText("Menú de Promoción y Prevención");
        this.mnuPyPProgramas.setText("Programa PyM");
        this.mnuPyPProgramas.setToolTipText("Ingreso a los Programas de PyM");
        this.mnuPyPProgramas.setFont(new Font("Arial", 1, 12));
        this.JMActividadesPyP.setText("Actividades PyP");
        this.JMActividadesPyP.setFont(new Font("Arial", 1, 12));
        this.JMIRActProfesional.setFont(new Font("Arial", 1, 12));
        this.JMIRActProfesional.setText("Programación Actividades");
        this.JMIRActProfesional.addActionListener(new ActionListener() { // from class: Acceso.Menus.218
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRActProfesionalActionPerformed(evt);
            }
        });
        this.JMActividadesPyP.add(this.JMIRActProfesional);
        this.JMIRActividades.setFont(new Font("Arial", 1, 12));
        this.JMIRActividades.setText("Registro Actividades");
        this.JMIRActividades.addActionListener(new ActionListener() { // from class: Acceso.Menus.219
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRActividadesActionPerformed(evt);
            }
        });
        this.JMActividadesPyP.add(this.JMIRActividades);
        this.JMIRActUsuarios.setFont(new Font("Arial", 1, 12));
        this.JMIRActUsuarios.setText("Registro Actividades por Usuario");
        this.JMIRActUsuarios.addActionListener(new ActionListener() { // from class: Acceso.Menus.220
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRActUsuariosActionPerformed(evt);
            }
        });
        this.JMActividadesPyP.add(this.JMIRActUsuarios);
        this.mnuPyPProgramas.add(this.JMActividadesPyP);
        this.mnuPyPProgramas.add(this.jSeparator11);
        this.mnuPyPCACervix.setText("Detección Temprana de Cáncer");
        this.mnuPyPCACervix.setFont(new Font("Arial", 1, 12));
        this.JMIGestion_CACervix.setFont(new Font("Arial", 1, 12));
        this.JMIGestion_CACervix.setText("Gestión Ca Cervix");
        this.JMIGestion_CACervix.addActionListener(new ActionListener() { // from class: Acceso.Menus.221
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGestion_CACervixActionPerformed(evt);
            }
        });
        this.mnuPyPCACervix.add(this.JMIGestion_CACervix);
        this.JMIGestion_Procedimientos.setFont(new Font("Arial", 1, 12));
        this.JMIGestion_Procedimientos.setText("Gestión Procedimientos");
        this.JMIGestion_Procedimientos.addActionListener(new ActionListener() { // from class: Acceso.Menus.222
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGestion_ProcedimientosActionPerformed(evt);
            }
        });
        this.mnuPyPCACervix.add(this.JMIGestion_Procedimientos);
        this.mnuPyPProgramas.add(this.mnuPyPCACervix);
        this.mnuPyPProgramas.add(this.jSeparator7);
        this.mnuPyPEgreso.setFont(new Font("Arial", 1, 12));
        this.mnuPyPEgreso.setText("Egreso de Usuarios");
        this.mnuPyPEgreso.setToolTipText("Egreso de Usuarios a los Programas de PyP");
        this.mnuPyPEgreso.addActionListener(new ActionListener() { // from class: Acceso.Menus.223
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPyPEgresoActionPerformed(evt);
            }
        });
        this.mnuPyPProgramas.add(this.mnuPyPEgreso);
        this.mnuPyPIngreso.setFont(new Font("Arial", 1, 12));
        this.mnuPyPIngreso.setText("Ingreso de Usuarios");
        this.mnuPyPIngreso.setToolTipText("Ingreso de Usuarios a los Programas de PyP");
        this.mnuPyPIngreso.addActionListener(new ActionListener() { // from class: Acceso.Menus.224
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPyPIngresoActionPerformed(evt);
            }
        });
        this.mnuPyPProgramas.add(this.mnuPyPIngreso);
        this.JMBMatriculaUsuarios.setText("Matricular Usuarios");
        this.JMBMatriculaUsuarios.setFont(new Font("Arial", 1, 12));
        this.JMIPDiabetes.setFont(new Font("Arial", 1, 12));
        this.JMIPDiabetes.setText("Diabetes");
        this.JMIPDiabetes.addActionListener(new ActionListener() { // from class: Acceso.Menus.225
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPDiabetesActionPerformed(evt);
            }
        });
        this.JMBMatriculaUsuarios.add(this.JMIPDiabetes);
        this.JMIPHta.setFont(new Font("Arial", 1, 12));
        this.JMIPHta.setText("HTA");
        this.JMIPHta.addActionListener(new ActionListener() { // from class: Acceso.Menus.226
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPHtaActionPerformed(evt);
            }
        });
        this.JMBMatriculaUsuarios.add(this.JMIPHta);
        this.mnuPyPProgramas.add(this.JMBMatriculaUsuarios);
        this.JMBPolimedicado.setText("Polimedicado");
        this.JMBPolimedicado.setFont(new Font("Arial", 1, 12));
        this.JMIPGestion.setFont(new Font("Arial", 1, 12));
        this.JMIPGestion.setText("Gestión");
        this.JMIPGestion.addActionListener(new ActionListener() { // from class: Acceso.Menus.227
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPGestionActionPerformed(evt);
            }
        });
        this.JMBPolimedicado.add(this.JMIPGestion);
        this.mnuPyPProgramas.add(this.JMBPolimedicado);
        this.JMIR4505.setFont(new Font("Arial", 1, 12));
        this.JMIR4505.setText("Registro individual 4505");
        this.JMIR4505.addActionListener(new ActionListener() { // from class: Acceso.Menus.228
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIR4505ActionPerformed(evt);
            }
        });
        this.mnuPyPProgramas.add(this.JMIR4505);
        this.mnuPyPProgramas.add(this.jSeparator10);
        this.JMVacunacion.setText("Vacunacion");
        this.JMVacunacion.setFont(new Font("Arial", 1, 12));
        this.mnuPyPAgendaVacunacion.setFont(new Font("Arial", 1, 12));
        this.mnuPyPAgendaVacunacion.setText("Agenda");
        this.mnuPyPAgendaVacunacion.setToolTipText("Agenda de usuarios facturados para vacunacion");
        this.mnuPyPAgendaVacunacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.229
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPyPAgendaVacunacionActionPerformed(evt);
            }
        });
        this.JMVacunacion.add(this.mnuPyPAgendaVacunacion);
        this.mnuPyPVacunacion.setFont(new Font("Arial", 1, 12));
        this.mnuPyPVacunacion.setText("Carnet");
        this.mnuPyPVacunacion.setToolTipText("Programa de Vacunación");
        this.mnuPyPVacunacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.230
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPyPVacunacionActionPerformed(evt);
            }
        });
        this.JMVacunacion.add(this.mnuPyPVacunacion);
        this.mnuPyPProgramas.add(this.JMVacunacion);
        this.barraMnuPyP.add(this.mnuPyPProgramas);
        this.mnuInformesPyP.setText("Informes");
        this.mnuInformesPyP.setToolTipText("");
        this.mnuInformesPyP.setFont(new Font("Arial", 1, 12));
        this.JMIRCaCervix.setFont(new Font("Arial", 1, 12));
        this.JMIRCaCervix.setText("Programa Ca Cervix");
        this.JMIRCaCervix.addActionListener(new ActionListener() { // from class: Acceso.Menus.231
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRCaCervixActionPerformed(evt);
            }
        });
        this.mnuInformesPyP.add(this.JMIRCaCervix);
        this.JMIInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMIInformesGenerales.setText("Informes Generales");
        this.JMIInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.232
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformesGeneralesActionPerformed(evt);
            }
        });
        this.mnuInformesPyP.add(this.JMIInformesGenerales);
        this.barraMnuPyP.add(this.mnuInformesPyP);
        this.JMEPrincipal.setText("Enfermería");
        this.JMEPrincipal.setToolTipText("");
        this.JMEPrincipal.setFont(new Font("Arial", 1, 12));
        this.mnuEnfAgenda.setFont(new Font("Arial", 1, 12));
        this.mnuEnfAgenda.setText("Agenda - Clasificaciòn de Triage");
        this.mnuEnfAgenda.setToolTipText("Agenda de Usuarios Pendientes por Atención");
        this.mnuEnfAgenda.addActionListener(new ActionListener() { // from class: Acceso.Menus.233
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuEnfAgendaActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.mnuEnfAgenda);
        this.JMIPAgenda_UH.setFont(new Font("Arial", 1, 12));
        this.JMIPAgenda_UH.setText("Agenda Servicios");
        this.JMIPAgenda_UH.setToolTipText("Agenda de atenciones de urgencias y hospitalizaciones");
        this.JMIPAgenda_UH.addActionListener(new ActionListener() { // from class: Acceso.Menus.234
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPAgenda_UHActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.JMIPAgenda_UH);
        this.JMIPAgenda_UH2.setFont(new Font("Arial", 1, 12));
        this.JMIPAgenda_UH2.setText("Agenda Servicios");
        this.JMIPAgenda_UH2.setToolTipText("Agenda de atenciones de servicios");
        this.JMIPAgenda_UH2.addActionListener(new ActionListener() { // from class: Acceso.Menus.235
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPAgenda_UH2ActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.JMIPAgenda_UH2);
        this.JMIPAgenda_UH1.setFont(new Font("Arial", 1, 12));
        this.JMIPAgenda_UH1.setText("Agenda Urgencias - Hospitalizacion");
        this.JMIPAgenda_UH1.setToolTipText("Agenda de atenciones de urgencias y hospitalizaciones");
        this.JMIPAgenda_UH1.addActionListener(new ActionListener() { // from class: Acceso.Menus.236
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPAgenda_UH1ActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.JMIPAgenda_UH1);
        this.mnuAtencionesEsp.setFont(new Font("Arial", 1, 12));
        this.mnuAtencionesEsp.setText("Atencion Especial");
        this.mnuAtencionesEsp.setToolTipText("");
        this.mnuAtencionesEsp.addActionListener(new ActionListener() { // from class: Acceso.Menus.237
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuAtencionesEspActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.mnuAtencionesEsp);
        this.mnuEnfAtencion.setFont(new Font("Arial", 1, 12));
        this.mnuEnfAtencion.setText("Ingreso");
        this.mnuEnfAtencion.setToolTipText("Ingreso de Usuarios");
        this.mnuEnfAtencion.addActionListener(new ActionListener() { // from class: Acceso.Menus.238
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuEnfAtencionActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.mnuEnfAtencion);
        this.mnuEnfAgenda1.setFont(new Font("Arial", 1, 12));
        this.mnuEnfAgenda1.setText("Ingreso");
        this.mnuEnfAgenda1.setToolTipText("Ingreso de atencionn de urgencias");
        this.mnuEnfAgenda1.addActionListener(new ActionListener() { // from class: Acceso.Menus.239
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuEnfAgenda1ActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.mnuEnfAgenda1);
        this.mnuEnfAgenda2.setFont(new Font("Arial", 1, 12));
        this.mnuEnfAgenda2.setText("Agenda Procedimientos");
        this.mnuEnfAgenda2.setToolTipText("Agenda de procedimientos de enfermeria");
        this.mnuEnfAgenda2.addActionListener(new ActionListener() { // from class: Acceso.Menus.240
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuEnfAgenda2ActionPerformed(evt);
            }
        });
        this.JMEPrincipal.add(this.mnuEnfAgenda2);
        barraMnuEnfermeria.add(this.JMEPrincipal);
        this.JMIRInformes.setText("Informes");
        this.JMIRInformes.setToolTipText("Informes Preliminares");
        this.JMIRInformes.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario1.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario1.setText("Censo de Camas");
        this.JMIRegistroDiario1.addActionListener(new ActionListener() { // from class: Acceso.Menus.241
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroDiario1ActionPerformed(evt);
            }
        });
        this.JMIRInformes.add(this.JMIRegistroDiario1);
        this.JMIRegistroDiario.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario.setText("Registro Diario");
        this.JMIRegistroDiario.addActionListener(new ActionListener() { // from class: Acceso.Menus.242
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroDiarioActionPerformed(evt);
            }
        });
        this.JMIRInformes.add(this.JMIRegistroDiario);
        this.JMIRConsultarUnidosisAplicada.setFont(new Font("Arial", 1, 12));
        this.JMIRConsultarUnidosisAplicada.setText("Consultar Unidosis Aplicadas");
        this.JMIRConsultarUnidosisAplicada.addActionListener(new ActionListener() { // from class: Acceso.Menus.243
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRConsultarUnidosisAplicadaActionPerformed(evt);
            }
        });
        this.JMIRInformes.add(this.JMIRConsultarUnidosisAplicada);
        this.JMIRSaludOcupacional.setText("Salud Ocupacional");
        this.JMIRSaludOcupacional.setFont(new Font("Arial", 1, 12));
        this.JMIESoInfAyD.setFont(new Font("Arial", 1, 12));
        this.JMIESoInfAyD.setText("Prueba de AyD");
        this.JMIESoInfAyD.setToolTipText("");
        this.JMIESoInfAyD.addActionListener(new ActionListener() { // from class: Acceso.Menus.244
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIESoInfAyDActionPerformed(evt);
            }
        });
        this.JMIRSaludOcupacional.add(this.JMIESoInfAyD);
        this.JMIESoTFatiga.setFont(new Font("Arial", 1, 12));
        this.JMIESoTFatiga.setText("Test de Fatiga");
        this.JMIESoTFatiga.addActionListener(new ActionListener() { // from class: Acceso.Menus.245
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIESoTFatigaActionPerformed(evt);
            }
        });
        this.JMIRSaludOcupacional.add(this.JMIESoTFatiga);
        this.JMIRInformes.add(this.JMIRSaludOcupacional);
        this.JMIRegistroDiario4.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario4.setText("Informes Generales");
        this.JMIRegistroDiario4.addActionListener(new ActionListener() { // from class: Acceso.Menus.246
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroDiario4ActionPerformed(evt);
            }
        });
        this.JMIRInformes.add(this.JMIRegistroDiario4);
        this.JMIFInfhospitalizados1.setFont(new Font("Arial", 1, 12));
        this.JMIFInfhospitalizados1.setText("Informes Hospitalización");
        this.JMIFInfhospitalizados1.setToolTipText("");
        this.JMIFInfhospitalizados1.addActionListener(new ActionListener() { // from class: Acceso.Menus.247
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFInfhospitalizados1ActionPerformed(evt);
            }
        });
        this.JMIRInformes.add(this.JMIFInfhospitalizados1);
        barraMnuEnfermeria.add(this.JMIRInformes);
        this.JMUtilidadesE.setText("Utilidades");
        this.JMUtilidadesE.setFont(new Font("Arial", 1, 12));
        this.JMIP_Alimentacion.setText("Alimentación");
        this.JMIP_Alimentacion.setFont(new Font("Arial", 1, 12));
        this.JMIP_SolicitudAlimentacion.setFont(new Font("Arial", 1, 12));
        this.JMIP_SolicitudAlimentacion.setText("Solicitud");
        this.JMIP_SolicitudAlimentacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.248
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_SolicitudAlimentacionActionPerformed(evt);
            }
        });
        this.JMIP_Alimentacion.add(this.JMIP_SolicitudAlimentacion);
        this.JMIP_AInforme.setFont(new Font("Arial", 1, 12));
        this.JMIP_AInforme.setText("Informe");
        this.JMIP_AInforme.addActionListener(new ActionListener() { // from class: Acceso.Menus.249
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_AInformeActionPerformed(evt);
            }
        });
        this.JMIP_Alimentacion.add(this.JMIP_AInforme);
        this.JMUtilidadesE.add(this.JMIP_Alimentacion);
        this.JMIConsultarAcronimos1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAcronimos1.setText("Consultar Acrónimos");
        this.JMIConsultarAcronimos1.addActionListener(new ActionListener() { // from class: Acceso.Menus.250
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAcronimos1ActionPerformed(evt);
            }
        });
        this.JMUtilidadesE.add(this.JMIConsultarAcronimos1);
        this.JMIRemOrdenes.setFont(new Font("Arial", 1, 12));
        this.JMIRemOrdenes.setText("Consultar Remisiones y Ordenes");
        this.JMIRemOrdenes.addActionListener(new ActionListener() { // from class: Acceso.Menus.251
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRemOrdenesActionPerformed(evt);
            }
        });
        this.JMUtilidadesE.add(this.JMIRemOrdenes);
        this.JMULogisticaE.setText("Logística");
        this.JMULogisticaE.setFont(new Font("Arial", 1, 12));
        this.JMLReporte.setFont(new Font("Arial", 1, 12));
        this.JMLReporte.setText("Reporte");
        this.JMLReporte.addActionListener(new ActionListener() { // from class: Acceso.Menus.252
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMLReporteActionPerformed(evt);
            }
        });
        this.JMULogisticaE.add(this.JMLReporte);
        this.JMUtilidadesE.add(this.JMULogisticaE);
        this.JMIPSo_Alcohol_DrograE.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Alcohol_DrograE.setText("Prueba de AyD");
        this.JMIPSo_Alcohol_DrograE.addActionListener(new ActionListener() { // from class: Acceso.Menus.253
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSo_Alcohol_DrograEActionPerformed(evt);
            }
        });
        this.JMUtilidadesE.add(this.JMIPSo_Alcohol_DrograE);
        this.JMIRegistroNotas.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroNotas.setText("Registro de Notas");
        this.JMIRegistroNotas.addActionListener(new ActionListener() { // from class: Acceso.Menus.254
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroNotasActionPerformed(evt);
            }
        });
        this.JMUtilidadesE.add(this.JMIRegistroNotas);
        this.JMIPSo_Test_FatigaE.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Test_FatigaE.setText("Test de Fatiga");
        this.JMIPSo_Test_FatigaE.addActionListener(new ActionListener() { // from class: Acceso.Menus.255
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSo_Test_FatigaEActionPerformed(evt);
            }
        });
        this.JMUtilidadesE.add(this.JMIPSo_Test_FatigaE);
        barraMnuEnfermeria.add(this.JMUtilidadesE);
        this.JMAPrincipal.setText("Autorización Medicina Prepagada ");
        this.JMAPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JMAutorizacion.setText("Autorizaciones");
        this.JMAutorizacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.256
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMAutorizacionActionPerformed(evt);
            }
        });
        this.JMAPrincipal.add(this.JMAutorizacion);
        barraMnuAutorizacionMP.add(this.JMAPrincipal);
        this.JMUtilidades.setText("Utilidades");
        this.JMUtilidades.setFont(new Font("Arial", 1, 12));
        this.JMUDCDescuento.setText("Control Descuento");
        this.JMUDCDescuento.setFont(new Font("Arial", 1, 12));
        this.JMUCCargarAc1.setFont(new Font("Arial", 1, 12));
        this.JMUCCargarAc1.setText("Cargar al Acumulado");
        this.JMUCCargarAc1.addActionListener(new ActionListener() { // from class: Acceso.Menus.257
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUCCargarAc1ActionPerformed(evt);
            }
        });
        this.JMUDCDescuento.add(this.JMUCCargarAc1);
        this.JMIUDCargarLote.setFont(new Font("Arial", 1, 12));
        this.JMIUDCargarLote.setText("Cargar Soporte por Lote");
        this.JMIUDCargarLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.258
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDCargarLoteActionPerformed(evt);
            }
        });
        this.JMUDCDescuento.add(this.JMIUDCargarLote);
        this.JMIUDPlantillaAplicada.setFont(new Font("Arial", 1, 12));
        this.JMIUDPlantillaAplicada.setText("Conciliación Plantilla Aplicada");
        this.JMIUDPlantillaAplicada.addActionListener(new ActionListener() { // from class: Acceso.Menus.259
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDPlantillaAplicadaActionPerformed(evt);
            }
        });
        this.JMUDCDescuento.add(this.JMIUDPlantillaAplicada);
        this.JMUGenerar.setFont(new Font("Arial", 1, 12));
        this.JMUGenerar.setText("Generar");
        this.JMUGenerar.addActionListener(new ActionListener() { // from class: Acceso.Menus.260
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUGenerarActionPerformed(evt);
            }
        });
        this.JMUDCDescuento.add(this.JMUGenerar);
        this.JMIUDGenerarPlantilla.setFont(new Font("Arial", 1, 12));
        this.JMIUDGenerarPlantilla.setText("Generar Plantilla de Cobro");
        this.JMIUDGenerarPlantilla.addActionListener(new ActionListener() { // from class: Acceso.Menus.261
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDGenerarPlantillaActionPerformed(evt);
            }
        });
        this.JMUDCDescuento.add(this.JMIUDGenerarPlantilla);
        this.JMUtilidades.add(this.JMUDCDescuento);
        this.JMULogisticaG1.setText("Logística");
        this.JMULogisticaG1.setFont(new Font("Arial", 1, 12));
        this.JMLogistica.setFont(new Font("Arial", 1, 12));
        this.JMLogistica.setText("Reporte");
        this.JMLogistica.addActionListener(new ActionListener() { // from class: Acceso.Menus.262
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMLogisticaActionPerformed(evt);
            }
        });
        this.JMULogisticaG1.add(this.JMLogistica);
        this.JMUtilidades.add(this.JMULogisticaG1);
        this.JMUMedicinaP.setText("Medicina Prepagada");
        this.JMUMedicinaP.setFont(new Font("Arial", 1, 12));
        this.JMAuditoriaMp.setFont(new Font("Arial", 1, 12));
        this.JMAuditoriaMp.setText("Auditoria");
        this.JMAuditoriaMp.addActionListener(new ActionListener() { // from class: Acceso.Menus.263
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMAuditoriaMpActionPerformed(evt);
            }
        });
        this.JMUMedicinaP.add(this.JMAuditoriaMp);
        this.JMResultadoA.setFont(new Font("Arial", 1, 12));
        this.JMResultadoA.setText("Reporte");
        this.JMResultadoA.addActionListener(new ActionListener() { // from class: Acceso.Menus.264
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMResultadoAActionPerformed(evt);
            }
        });
        this.JMUMedicinaP.add(this.JMResultadoA);
        this.JMUtilidades.add(this.JMUMedicinaP);
        this.JMUProgEspecial1.setText("Programa Especial de Envíos de Medicamentos");
        this.JMUProgEspecial1.setFont(new Font("Arial", 1, 12));
        this.JMUPConsultaUser.setFont(new Font("Arial", 1, 12));
        this.JMUPConsultaUser.setText("Consultar Usuarios Matriculados");
        this.JMUPConsultaUser.addActionListener(new ActionListener() { // from class: Acceso.Menus.265
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUPConsultaUserActionPerformed(evt);
            }
        });
        this.JMUProgEspecial1.add(this.JMUPConsultaUser);
        this.JMUPMatricula.setFont(new Font("Arial", 1, 12));
        this.JMUPMatricula.setText("Matricula");
        this.JMUPMatricula.addActionListener(new ActionListener() { // from class: Acceso.Menus.266
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUPMatriculaActionPerformed(evt);
            }
        });
        this.JMUProgEspecial1.add(this.JMUPMatricula);
        this.JMUPRegistroEnvio.setFont(new Font("Arial", 1, 12));
        this.JMUPRegistroEnvio.setText("Registro de Envío");
        this.JMUPRegistroEnvio.addActionListener(new ActionListener() { // from class: Acceso.Menus.267
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUPRegistroEnvioActionPerformed(evt);
            }
        });
        this.JMUProgEspecial1.add(this.JMUPRegistroEnvio);
        this.JMUtilidades.add(this.JMUProgEspecial1);
        this.JMUPConsultaUser1.setFont(new Font("Arial", 1, 12));
        this.JMUPConsultaUser1.setText("Informes Generales");
        this.JMUPConsultaUser1.addActionListener(new ActionListener() { // from class: Acceso.Menus.268
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUPConsultaUser1ActionPerformed(evt);
            }
        });
        this.JMUtilidades.add(this.JMUPConsultaUser1);
        barraMnuAutorizacionMP.add(this.JMUtilidades);
        this.JMAyuda.setText("Ayuda");
        this.JMAyuda.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade.setText("Acerca de ...");
        this.JMIAAcercade.addActionListener(new ActionListener() { // from class: Acceso.Menus.269
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAAcercadeActionPerformed(evt);
            }
        });
        this.JMAyuda.add(this.JMIAAcercade);
        barraMnuAutorizacionMP.add(this.JMAyuda);
        this.JMAtencion.setMnemonic('P');
        this.JMAtencion.setText("Historia Clínica");
        this.JMAtencion.setFont(new Font("Arial", 1, 12));
        JMIAgendaN.setFont(new Font("Arial", 1, 12));
        JMIAgendaN.setText("Agenda");
        JMIAgendaN.addActionListener(new ActionListener() { // from class: Acceso.Menus.270
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaNActionPerformed(evt);
            }
        });
        this.JMAtencion.add(JMIAgendaN);
        JMIAgendaN1.setFont(new Font("Arial", 1, 12));
        JMIAgendaN1.setText("Agenda Nueva");
        JMIAgendaN1.addActionListener(new ActionListener() { // from class: Acceso.Menus.271
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaN1ActionPerformed(evt);
            }
        });
        this.JMAtencion.add(JMIAgendaN1);
        JMAgendaSeparada.setText("Agendas");
        JMAgendaSeparada.setFont(new Font("Arial", 1, 12));
        JMIAgendaNSO.setFont(new Font("Arial", 1, 12));
        JMIAgendaNSO.setText("Agenda");
        JMIAgendaNSO.addActionListener(new ActionListener() { // from class: Acceso.Menus.272
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaNSOActionPerformed(evt);
            }
        });
        JMAgendaSeparada.add(JMIAgendaNSO);
        this.JMIAgendaCE.setFont(new Font("Arial", 1, 12));
        this.JMIAgendaCE.setText("Agenda Consulta Externa");
        this.JMIAgendaCE.addActionListener(new ActionListener() { // from class: Acceso.Menus.273
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaCEActionPerformed(evt);
            }
        });
        JMAgendaSeparada.add(this.JMIAgendaCE);
        JMIAgendaServicios.setFont(new Font("Arial", 1, 12));
        JMIAgendaServicios.setText("Agenda Servicios");
        JMIAgendaServicios.addActionListener(new ActionListener() { // from class: Acceso.Menus.274
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaServiciosActionPerformed(evt);
            }
        });
        JMAgendaSeparada.add(JMIAgendaServicios);
        this.JMIAgendaServiciosBeta.setFont(new Font("Arial", 1, 12));
        this.JMIAgendaServiciosBeta.setText("Agenda Servicios");
        this.JMIAgendaServiciosBeta.addActionListener(new ActionListener() { // from class: Acceso.Menus.275
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaServiciosBetaActionPerformed(evt);
            }
        });
        JMAgendaSeparada.add(this.JMIAgendaServiciosBeta);
        this.JMAtencion.add(JMAgendaSeparada);
        this.JMIConsultarADx.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarADx.setText("Consultar Ayudas Dx");
        this.JMIConsultarADx.addActionListener(new ActionListener() { // from class: Acceso.Menus.276
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarADxActionPerformed(evt);
            }
        });
        this.JMAtencion.add(this.JMIConsultarADx);
        this.JMIConsultarHc.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarHc.setText("Consultar Historial");
        this.JMIConsultarHc.addActionListener(new ActionListener() { // from class: Acceso.Menus.277
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarHcActionPerformed(evt);
            }
        });
        this.JMAtencion.add(this.JMIConsultarHc);
        barraMnuHistoriaCE.add(this.JMAtencion);
        this.JMUtilidadesH.setText("Utilidades");
        this.JMUtilidadesH.setFont(new Font("Arial", 1, 12));
        this.JMIAsignacionCNP.setFont(new Font("Arial", 1, 12));
        this.JMIAsignacionCNP.setText("Asignación Cita No Programada");
        this.JMIAsignacionCNP.addActionListener(new ActionListener() { // from class: Acceso.Menus.278
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAsignacionCNPActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIAsignacionCNP);
        this.JMIAsignacion_AtencionE.setFont(new Font("Arial", 1, 12));
        this.JMIAsignacion_AtencionE.setText("Asignación Atención Especial");
        this.JMIAsignacion_AtencionE.addActionListener(new ActionListener() { // from class: Acceso.Menus.279
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAsignacion_AtencionEActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIAsignacion_AtencionE);
        this.JMICertificado.setText("Certificados");
        this.JMICertificado.setFont(new Font("Arial", 1, 12));
        this.JMICPermisoMedicos.setFont(new Font("Arial", 1, 12));
        this.JMICPermisoMedicos.setText("Permiso Médico");
        this.JMICPermisoMedicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.280
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICPermisoMedicosActionPerformed(evt);
            }
        });
        this.JMICertificado.add(this.JMICPermisoMedicos);
        this.JMUtilidadesH.add(this.JMICertificado);
        this.JMIRegistroDiario2.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroDiario2.setText("Censo de Camas");
        this.JMIRegistroDiario2.addActionListener(new ActionListener() { // from class: Acceso.Menus.281
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroDiario2ActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroDiario2);
        this.JMIConsultarAcronimos.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAcronimos.setText("Consultar Acrónimos");
        this.JMIConsultarAcronimos.addActionListener(new ActionListener() { // from class: Acceso.Menus.282
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAcronimosActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIConsultarAcronimos);
        this.JMIConsultarResultado.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultado.setText("Consultar Resultado de Exámenes");
        this.JMIConsultarResultado.addActionListener(new ActionListener() { // from class: Acceso.Menus.283
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIConsultarResultado);
        this.JMIConsultarResultadoUsuario.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoUsuario.setText("Consultar Resultado de Exámenes x Usuario");
        this.JMIConsultarResultadoUsuario.addActionListener(new ActionListener() { // from class: Acceso.Menus.284
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoUsuarioActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIConsultarResultadoUsuario);
        this.JMIConsultarOrdRem.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarOrdRem.setText("Consultar Remisiones y Ordenes");
        this.JMIConsultarOrdRem.addActionListener(new ActionListener() { // from class: Acceso.Menus.285
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarOrdRemActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIConsultarOrdRem);
        this.JMIUFormulasPyP.setFont(new Font("Arial", 1, 12));
        this.JMIUFormulasPyP.setText("Formulas PyP");
        this.JMIUFormulasPyP.addActionListener(new ActionListener() { // from class: Acceso.Menus.286
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUFormulasPyPActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIUFormulasPyP);
        this.JMIConstanciaAsistencia.setFont(new Font("Arial", 1, 12));
        this.JMIConstanciaAsistencia.setText("Generar Constancia de Asistencia");
        this.JMIConstanciaAsistencia.addActionListener(new ActionListener() { // from class: Acceso.Menus.287
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConstanciaAsistenciaActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIConstanciaAsistencia);
        this.JMULogisticaH.setText("Logística");
        this.JMULogisticaH.setFont(new Font("Arial", 1, 12));
        this.JMHReporte.setFont(new Font("Arial", 1, 12));
        this.JMHReporte.setText("Reporte");
        this.JMHReporte.addActionListener(new ActionListener() { // from class: Acceso.Menus.288
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMHReporteActionPerformed(evt);
            }
        });
        this.JMULogisticaH.add(this.JMHReporte);
        this.JMUtilidadesH.add(this.JMULogisticaH);
        this.JMIRegistroConsultaNP.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroConsultaNP.setText("Registro de Consulta Medica No Programada");
        this.JMIRegistroConsultaNP.addActionListener(new ActionListener() { // from class: Acceso.Menus.289
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroConsultaNPActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroConsultaNP);
        this.JMIRegistroNMedicas.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroNMedicas.setText("Registro de Notas Médicas");
        this.JMIRegistroNMedicas.addActionListener(new ActionListener() { // from class: Acceso.Menus.290
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroNMedicasActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroNMedicas);
        this.JMIRegistroIncapac.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroIncapac.setText("Registro de Incapacidades");
        this.JMIRegistroIncapac.setToolTipText("");
        this.JMIRegistroIncapac.addActionListener(new ActionListener() { // from class: Acceso.Menus.291
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroIncapacActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroIncapac);
        this.JMIRegistroVDomiciliarias.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroVDomiciliarias.setText("Registro de Visitas Domiciliarias");
        this.JMIRegistroVDomiciliarias.addActionListener(new ActionListener() { // from class: Acceso.Menus.292
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroVDomiciliariasActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroVDomiciliarias);
        this.JMIRegistroJuntaMedica.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroJuntaMedica.setText("Registro Junta Medica");
        this.JMIRegistroJuntaMedica.addActionListener(new ActionListener() { // from class: Acceso.Menus.293
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroJuntaMedicaActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIRegistroJuntaMedica);
        this.JMIInformeGenerale.setFont(new Font("Arial", 1, 12));
        this.JMIInformeGenerale.setText("Informes Generales");
        this.JMIInformeGenerale.addActionListener(new ActionListener() { // from class: Acceso.Menus.294
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeGeneraleActionPerformed(evt);
            }
        });
        this.JMUtilidadesH.add(this.JMIInformeGenerale);
        barraMnuHistoriaCE.add(this.JMUtilidadesH);
        this.JMAyuda1.setText("Ayuda");
        this.JMAyuda1.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade1.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade1.setText("Acerca de ...");
        this.JMIAAcercade1.addActionListener(new ActionListener() { // from class: Acceso.Menus.295
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAAcercade1ActionPerformed(evt);
            }
        });
        this.JMAyuda1.add(this.JMIAAcercade1);
        barraMnuHistoriaCE.add(this.JMAyuda1);
        this.JMGestion.setMnemonic('P');
        this.JMGestion.setText("Gestión Documental");
        this.JMGestion.setFont(new Font("Arial", 1, 12));
        this.JMEncuesta.setMnemonic('P');
        this.JMEncuesta.setText("Encuesta");
        this.JMEncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIECargarS.setFont(new Font("Arial", 1, 12));
        this.JMIECargarS.setText("Cargar Soporte");
        this.JMIECargarS.addActionListener(new ActionListener() { // from class: Acceso.Menus.296
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIECargarSActionPerformed(evt);
            }
        });
        this.JMEncuesta.add(this.JMIECargarS);
        this.JMIERegistroE.setFont(new Font("Arial", 1, 12));
        this.JMIERegistroE.setText("Registro");
        this.JMIERegistroE.addActionListener(new ActionListener() { // from class: Acceso.Menus.297
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIERegistroEActionPerformed(evt);
            }
        });
        this.JMEncuesta.add(this.JMIERegistroE);
        this.JMGestion.add(this.JMEncuesta);
        this.JMIConsultarAyudasDx.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAyudasDx.setText("Consultar Ayudas Dx");
        this.JMIConsultarAyudasDx.addActionListener(new ActionListener() { // from class: Acceso.Menus.298
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAyudasDxActionPerformed(evt);
            }
        });
        this.JMGestion.add(this.JMIConsultarAyudasDx);
        this.JMIConsultarHC.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarHC.setText("Consultar Historia");
        this.JMIConsultarHC.addActionListener(new ActionListener() { // from class: Acceso.Menus.299
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarHCActionPerformed(evt);
            }
        });
        this.JMGestion.add(this.JMIConsultarHC);
        this.JMIConsultarLecturaRx.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarLecturaRx.setText("Consultar Lecturas Rx");
        this.JMIConsultarLecturaRx.addActionListener(new ActionListener() { // from class: Acceso.Menus.300
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarLecturaRxActionPerformed(evt);
            }
        });
        this.JMGestion.add(this.JMIConsultarLecturaRx);
        this.JMIRegistroNMedicas1.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroNMedicas1.setText("Registro de Notas Médicas");
        this.JMIRegistroNMedicas1.addActionListener(new ActionListener() { // from class: Acceso.Menus.301
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroNMedicas1ActionPerformed(evt);
            }
        });
        this.JMGestion.add(this.JMIRegistroNMedicas1);
        this.JMGestionQrs.setMnemonic('P');
        this.JMGestionQrs.setText("Quejas, Reclamos, Sugerencias y Reconocimientos");
        this.JMGestionQrs.setFont(new Font("Arial", 1, 12));
        this.JMIGRegistro.setFont(new Font("Arial", 1, 12));
        this.JMIGRegistro.setText("Registro de QRSR");
        this.JMIGRegistro.addActionListener(new ActionListener() { // from class: Acceso.Menus.302
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGRegistroActionPerformed(evt);
            }
        });
        this.JMGestionQrs.add(this.JMIGRegistro);
        this.JMIGSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JMIGSeguimiento.setText("Seguimiento a QRSR");
        this.JMIGSeguimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.303
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGSeguimientoActionPerformed(evt);
            }
        });
        this.JMGestionQrs.add(this.JMIGSeguimiento);
        this.JMGestion.add(this.JMGestionQrs);
        barraMnuGestionDoc.add(this.JMGestion);
        this.JMUtilidadesG.setText("Utilidades");
        this.JMUtilidadesG.setFont(new Font("Arial", 1, 12));
        this.JMIArchivarDocs.setFont(new Font("Arial", 1, 12));
        this.JMIArchivarDocs.setText("Archivar Documentos");
        this.JMIArchivarDocs.addActionListener(new ActionListener() { // from class: Acceso.Menus.304
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIArchivarDocsActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIArchivarDocs);
        this.JMIConsultarAtenciones.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAtenciones.setText("Consultar Atenciones");
        this.JMIConsultarAtenciones.addActionListener(new ActionListener() { // from class: Acceso.Menus.305
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAtencionesActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarAtenciones);
        this.JMIConsultarCprogramada.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarCprogramada.setText("Consultar Citas Programadas");
        this.JMIConsultarCprogramada.addActionListener(new ActionListener() { // from class: Acceso.Menus.306
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarCprogramadaActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarCprogramada);
        this.JMIConsultarIncapacidad.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarIncapacidad.setText("Consultar Incapacidad");
        this.JMIConsultarIncapacidad.addActionListener(new ActionListener() { // from class: Acceso.Menus.307
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarIncapacidadActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarIncapacidad);
        this.JMIConsultarRemOrd.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarRemOrd.setText("Consultar Remisiones y Ordenes");
        this.JMIConsultarRemOrd.setToolTipText("");
        this.JMIConsultarRemOrd.addActionListener(new ActionListener() { // from class: Acceso.Menus.308
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarRemOrdActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarRemOrd);
        this.JMIConsultarResultadoG.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoG.setText("Consultar Resultado de Exámenes");
        this.JMIConsultarResultadoG.addActionListener(new ActionListener() { // from class: Acceso.Menus.309
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoGActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarResultadoG);
        this.JMIConsultarResultadoUsuario1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoUsuario1.setText("Consultar Resultado de Exámenes por Usuario");
        this.JMIConsultarResultadoUsuario1.setToolTipText("");
        this.JMIConsultarResultadoUsuario1.addActionListener(new ActionListener() { // from class: Acceso.Menus.310
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoUsuario1ActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarResultadoUsuario1);
        this.JMIUExportarDHC.setText("Exportar");
        this.JMIUExportarDHC.setFont(new Font("Arial", 1, 12));
        this.JMIUEHistoriaPdf.setFont(new Font("Arial", 1, 12));
        this.JMIUEHistoriaPdf.setText("Historia Clinica en PDF");
        this.JMIUEHistoriaPdf.addActionListener(new ActionListener() { // from class: Acceso.Menus.311
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUEHistoriaPdfActionPerformed1(evt);
            }
        });
        this.JMIUExportarDHC.add(this.JMIUEHistoriaPdf);
        this.JMUEAyudasDx.setText("Ayudas Dx");
        this.JMUEAyudasDx.setFont(new Font("Arial", 1, 12));
        this.JMIUEAxamenes.setFont(new Font("Arial", 1, 12));
        this.JMIUEAxamenes.setText("Exámenes de Laboratorio por Usuario");
        this.JMIUEAxamenes.addActionListener(new ActionListener() { // from class: Acceso.Menus.312
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUEAxamenesActionPerformed(evt);
            }
        });
        this.JMUEAyudasDx.add(this.JMIUEAxamenes);
        this.JMIUEAxamenesFEcha.setFont(new Font("Arial", 1, 12));
        this.JMIUEAxamenesFEcha.setText("Resultados de  Laboratorio por Fecha");
        this.JMIUEAxamenesFEcha.addActionListener(new ActionListener() { // from class: Acceso.Menus.313
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUEAxamenesFEchaActionPerformed(evt);
            }
        });
        this.JMUEAyudasDx.add(this.JMIUEAxamenesFEcha);
        this.JMIUExportarDHC.add(this.JMUEAyudasDx);
        this.JMIUEHistoriaPdf2.setFont(new Font("Arial", 1, 12));
        this.JMIUEHistoriaPdf2.setText("Historia Clinica en PDF Plantilla(EXCEL)");
        this.JMIUEHistoriaPdf2.addActionListener(new ActionListener() { // from class: Acceso.Menus.314
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUEHistoriaPdf2ActionPerformed1(evt);
            }
        });
        this.JMIUExportarDHC.add(this.JMIUEHistoriaPdf2);
        this.JMUtilidadesG.add(this.JMIUExportarDHC);
        this.JMIUGestionExamenes.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionExamenes.setText("Gestion de Examenes");
        this.JMIUGestionExamenes.addActionListener(new ActionListener() { // from class: Acceso.Menus.315
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGestionExamenesActionPerformed1(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIUGestionExamenes);
        this.JMIUImportarDHC.setText("Importar Documentos HC");
        this.JMIUImportarDHC.setFont(new Font("Arial", 1, 12));
        this.JMIUAtencionesManuales.setFont(new Font("Arial", 1, 12));
        this.JMIUAtencionesManuales.setText("Atenciones Manuales");
        this.JMIUAtencionesManuales.addActionListener(new ActionListener() { // from class: Acceso.Menus.316
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAtencionesManualesActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC.add(this.JMIUAtencionesManuales);
        this.JMIUImportarAyudasdx.setFont(new Font("Arial", 1, 12));
        this.JMIUImportarAyudasdx.setText("Ayudas Diagnostica Individual");
        this.JMIUImportarAyudasdx.addActionListener(new ActionListener() { // from class: Acceso.Menus.317
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUImportarAyudasdxActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC.add(this.JMIUImportarAyudasdx);
        this.JMIImportarAyudasDx.setFont(new Font("Arial", 1, 12));
        this.JMIImportarAyudasDx.setText("Ayudas Diagnosticas por Lote");
        this.JMIImportarAyudasDx.addActionListener(new ActionListener() { // from class: Acceso.Menus.318
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIImportarAyudasDxActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC.add(this.JMIImportarAyudasDx);
        this.JMICopiasDoc.setFont(new Font("Arial", 1, 12));
        this.JMICopiasDoc.setText("Copia de Documentos");
        this.JMICopiasDoc.addActionListener(new ActionListener() { // from class: Acceso.Menus.319
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICopiasDocActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC.add(this.JMICopiasDoc);
        this.JMIISoporteLote.setFont(new Font("Arial", 1, 12));
        this.JMIISoporteLote.setText("Cargar Soporte Por Lote");
        this.JMIISoporteLote.addActionListener(new ActionListener() { // from class: Acceso.Menus.320
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIISoporteLoteActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC.add(this.JMIISoporteLote);
        this.JMUtilidadesG.add(this.JMIUImportarDHC);
        this.JMULogisticaG.setText("Logística");
        this.JMULogisticaG.setFont(new Font("Arial", 1, 12));
        this.JMGReporte.setFont(new Font("Arial", 1, 12));
        this.JMGReporte.setText("Reporte");
        this.JMGReporte.addActionListener(new ActionListener() { // from class: Acceso.Menus.321
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMGReporteActionPerformed(evt);
            }
        });
        this.JMULogisticaG.add(this.JMGReporte);
        this.JMUtilidadesG.add(this.JMULogisticaG);
        this.JMIConsultarMovimientoDocClinico.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarMovimientoDocClinico.setText("Reporte Movimiento Documentos Clínicos");
        this.JMIConsultarMovimientoDocClinico.addActionListener(new ActionListener() { // from class: Acceso.Menus.322
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarMovimientoDocClinicoActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIConsultarMovimientoDocClinico);
        this.JMIUSolicitudDocClinicos.setFont(new Font("Arial", 1, 12));
        this.JMIUSolicitudDocClinicos.setText("Solicitud de Documentos Clínicos");
        this.JMIUSolicitudDocClinicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.323
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUSolicitudDocClinicosActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIUSolicitudDocClinicos);
        this.JMIUInformes.setFont(new Font("Arial", 1, 12));
        this.JMIUInformes.setText("Informes Generales");
        this.JMIUInformes.addActionListener(new ActionListener() { // from class: Acceso.Menus.324
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUInformesActionPerformed(evt);
            }
        });
        this.JMUtilidadesG.add(this.JMIUInformes);
        barraMnuGestionDoc.add(this.JMUtilidadesG);
        this.JMConfiguracion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda29x27.png")));
        this.JMConfiguracion.setText("Configuración SGC");
        this.JMConfiguracion.setFont(new Font("Arial", 1, 12));
        this.JMConfiguracion.addActionListener(new ActionListener() { // from class: Acceso.Menus.325
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMConfiguracionActionPerformed(evt);
            }
        });
        this.JMCIProcesos.setFont(new Font("Arial", 1, 12));
        this.JMCIProcesos.setText("Procesos");
        this.JMCIProcesos.addActionListener(new ActionListener() { // from class: Acceso.Menus.326
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCIProcesosActionPerformed(evt);
            }
        });
        this.JMConfiguracion.add(this.JMCIProcesos);
        this.JMCIProcxTipo.setFont(new Font("Arial", 1, 12));
        this.JMCIProcxTipo.setText("Proceso por Tipo");
        this.JMCIProcxTipo.addActionListener(new ActionListener() { // from class: Acceso.Menus.327
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCIProcxTipoActionPerformed(evt);
            }
        });
        this.JMConfiguracion.add(this.JMCIProcxTipo);
        this.JMCITipoProceso.setFont(new Font("Arial", 1, 12));
        this.JMCITipoProceso.setText("Tipo de Proceso");
        this.JMCITipoProceso.addActionListener(new ActionListener() { // from class: Acceso.Menus.328
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCITipoProcesoActionPerformed(evt);
            }
        });
        this.JMConfiguracion.add(this.JMCITipoProceso);
        barraMnuSgc.add(this.JMConfiguracion);
        this.JMGestion1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JMGestion1.setMnemonic('P');
        this.JMGestion1.setText("Sgc");
        this.JMGestion1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAyudasDx1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarAyudasDx1.setText("Consultar Ayudas Dx");
        this.JMIConsultarAyudasDx1.addActionListener(new ActionListener() { // from class: Acceso.Menus.329
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarAyudasDx1ActionPerformed(evt);
            }
        });
        this.JMGestion1.add(this.JMIConsultarAyudasDx1);
        this.JMIConsultarHC1.setAccelerator(KeyStroke.getKeyStroke(65, 128));
        this.JMIConsultarHC1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarHC1.setText("Consultar Historia");
        this.JMIConsultarHC1.addActionListener(new ActionListener() { // from class: Acceso.Menus.330
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarHC1ActionPerformed(evt);
            }
        });
        this.JMGestion1.add(this.JMIConsultarHC1);
        barraMnuSgc.add(this.JMGestion1);
        this.JMUtilidadesGD1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configurar29x27.png")));
        this.JMUtilidadesGD1.setText("Utilidades");
        this.JMUtilidadesGD1.setFont(new Font("Arial", 1, 12));
        this.JMIUExportarDHC1.setText("Exportar");
        this.JMIUExportarDHC1.setFont(new Font("Arial", 1, 12));
        this.JMIUEHistoriaPdf1.setFont(new Font("Arial", 1, 12));
        this.JMIUEHistoriaPdf1.setText("Historia Clinica en PDF");
        this.JMIUEHistoriaPdf1.addActionListener(new ActionListener() { // from class: Acceso.Menus.331
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUEHistoriaPdf1ActionPerformed1(evt);
            }
        });
        this.JMIUExportarDHC1.add(this.JMIUEHistoriaPdf1);
        this.JMUtilidadesGD1.add(this.JMIUExportarDHC1);
        this.JMIUGestionExamenes1.setFont(new Font("Arial", 1, 12));
        this.JMIUGestionExamenes1.setText("Gestion de Examenes");
        this.JMIUGestionExamenes1.addActionListener(new ActionListener() { // from class: Acceso.Menus.332
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGestionExamenes1ActionPerformed1(evt);
            }
        });
        this.JMUtilidadesGD1.add(this.JMIUGestionExamenes1);
        this.JMIUImportarDHC1.setText("Importar Documentos HC");
        this.JMIUImportarDHC1.setFont(new Font("Arial", 1, 12));
        this.JMIUAtencionesManuales1.setFont(new Font("Arial", 1, 12));
        this.JMIUAtencionesManuales1.setText("Atenciones Manuales");
        this.JMIUAtencionesManuales1.addActionListener(new ActionListener() { // from class: Acceso.Menus.333
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAtencionesManuales1ActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC1.add(this.JMIUAtencionesManuales1);
        this.JMIUImportarAyudasdx1.setFont(new Font("Arial", 1, 12));
        this.JMIUImportarAyudasdx1.setText("Ayudas Diagnostica Individual");
        this.JMIUImportarAyudasdx1.addActionListener(new ActionListener() { // from class: Acceso.Menus.334
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUImportarAyudasdx1ActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC1.add(this.JMIUImportarAyudasdx1);
        this.JMIImportarAyudasDx1.setFont(new Font("Arial", 1, 12));
        this.JMIImportarAyudasDx1.setText("Ayudas Diagnosticas por Lote");
        this.JMIImportarAyudasDx1.addActionListener(new ActionListener() { // from class: Acceso.Menus.335
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIImportarAyudasDx1ActionPerformed(evt);
            }
        });
        this.JMIUImportarDHC1.add(this.JMIImportarAyudasDx1);
        this.JMUtilidadesGD1.add(this.JMIUImportarDHC1);
        barraMnuSgc.add(this.JMUtilidadesGD1);
        this.mnuLabMovimiento.setText("Laboratorio Clínico");
        this.mnuLabMovimiento.setFont(new Font("Arial", 1, 12));
        this.JMRecepcion.setText("Recepción");
        this.JMRecepcion.setFont(new Font("Arial", 1, 12));
        this.mnuLabAgenda.setFont(new Font("Arial", 1, 12));
        this.mnuLabAgenda.setText("Agenda");
        this.mnuLabAgenda.setToolTipText("Toma de Muestras");
        this.mnuLabAgenda.addActionListener(new ActionListener() { // from class: Acceso.Menus.336
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabAgendaActionPerformed(evt);
            }
        });
        this.JMRecepcion.add(this.mnuLabAgenda);
        this.mnuLabManual.setFont(new Font("Arial", 1, 12));
        this.mnuLabManual.setText("Manual");
        this.mnuLabManual.addActionListener(new ActionListener() { // from class: Acceso.Menus.337
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabManualActionPerformed(evt);
            }
        });
        this.JMRecepcion.add(this.mnuLabManual);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.mnuLabManual.setVisible(true);
        } else {
            this.mnuLabManual.setVisible(false);
        }
        this.mnuLabCruzados.setFont(new Font("Arial", 1, 12));
        this.mnuLabCruzados.setText("Recepciones Cruzadas ");
        this.mnuLabCruzados.setToolTipText("Toma de Muestras");
        this.mnuLabCruzados.addActionListener(new ActionListener() { // from class: Acceso.Menus.338
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabCruzadosActionPerformed(evt);
            }
        });
        this.JMRecepcion.add(this.mnuLabCruzados);
        this.mnuLabMovimiento.add(this.JMRecepcion);
        this.JMResultado.setText("Resultados");
        this.JMResultado.setFont(new Font("Arial", 1, 12));
        this.mnuPlanillaTrabajo.setFont(new Font("Arial", 1, 12));
        this.mnuPlanillaTrabajo.setText("Planilla");
        this.mnuPlanillaTrabajo.addActionListener(new ActionListener() { // from class: Acceso.Menus.339
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPlanillaTrabajoActionPerformed(evt);
            }
        });
        this.JMResultado.add(this.mnuPlanillaTrabajo);
        this.JMIR_ValidarInterfaz.setFont(new Font("Arial", 1, 12));
        this.JMIR_ValidarInterfaz.setText("Validar Resultados Masivos (Interfaces)");
        this.JMIR_ValidarInterfaz.addActionListener(new ActionListener() { // from class: Acceso.Menus.340
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIR_ValidarInterfazActionPerformed(evt);
            }
        });
        this.JMResultado.add(this.JMIR_ValidarInterfaz);
        this.mnuPlanillaTrabajo1.setFont(new Font("Arial", 1, 12));
        this.mnuPlanillaTrabajo1.setText("Validacion Masiva");
        this.mnuPlanillaTrabajo1.addActionListener(new ActionListener() { // from class: Acceso.Menus.341
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuPlanillaTrabajo1ActionPerformed(evt);
            }
        });
        this.JMResultado.add(this.mnuPlanillaTrabajo1);
        this.mnuLabMovimiento.add(this.JMResultado);
        this.mnuLabMovimiento.add(this.jSeparator9);
        this.JMExportacion.setText("Exportación");
        this.JMExportacion.setFont(new Font("Arial", 1, 12));
        this.JMIEquipoQuimica1.setText("Equipos de Química");
        this.JMIEquipoQuimica1.setFont(new Font("Arial", 1, 12));
        this.JMIEBiosystemA15.setFont(new Font("Arial", 1, 12));
        this.JMIEBiosystemA15.setText("Biosystem A15");
        this.JMIEBiosystemA15.addActionListener(new ActionListener() { // from class: Acceso.Menus.342
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEBiosystemA15ActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica1.add(this.JMIEBiosystemA15);
        this.JMIEBiosystemA25.setFont(new Font("Arial", 1, 12));
        this.JMIEBiosystemA25.setText("Biosystem A25");
        this.JMIEBiosystemA25.addActionListener(new ActionListener() { // from class: Acceso.Menus.343
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEBiosystemA25ActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica1.add(this.JMIEBiosystemA25);
        this.JMIEWienerLabCB400i.setFont(new Font("Arial", 1, 12));
        this.JMIEWienerLabCB400i.setText("Wiener Lab CB400i");
        this.JMIEWienerLabCB400i.addActionListener(new ActionListener() { // from class: Acceso.Menus.344
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEWienerLabCB400iActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica1.add(this.JMIEWienerLabCB400i);
        this.JMIECM250.setFont(new Font("Arial", 1, 12));
        this.JMIECM250.setText("CM250");
        this.JMIECM250.addActionListener(new ActionListener() { // from class: Acceso.Menus.345
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIECM250ActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica1.add(this.JMIECM250);
        this.JMExportacion.add(this.JMIEquipoQuimica1);
        this.JMIEquipoHormonas.setText("Equipos de Hormonas");
        this.JMIEquipoHormonas.setFont(new Font("Arial", 1, 12));
        this.JMIEAutoplex.setFont(new Font("Arial", 1, 12));
        this.JMIEAutoplex.setText("AutoPlex");
        this.JMIEAutoplex.addActionListener(new ActionListener() { // from class: Acceso.Menus.346
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEAutoplexActionPerformed(evt);
            }
        });
        this.JMIEquipoHormonas.add(this.JMIEAutoplex);
        this.JMIEWienerLabCB400i2.setFont(new Font("Arial", 1, 12));
        this.JMIEWienerLabCB400i2.setText("Abbott Architect i1000SR");
        this.JMIEWienerLabCB400i2.addActionListener(new ActionListener() { // from class: Acceso.Menus.347
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEWienerLabCB400i2ActionPerformed(evt);
            }
        });
        this.JMIEquipoHormonas.add(this.JMIEWienerLabCB400i2);
        this.JMExportacion.add(this.JMIEquipoHormonas);
        this.JMIEquipoEspecializados.setText("Equipos de Especialidades");
        this.JMIEquipoEspecializados.setFont(new Font("Arial", 1, 12));
        this.JMIECobase411.setFont(new Font("Arial", 1, 12));
        this.JMIECobase411.setText("Cobas e411");
        this.JMIECobase411.addActionListener(new ActionListener() { // from class: Acceso.Menus.348
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIECobase411ActionPerformed(evt);
            }
        });
        this.JMIEquipoEspecializados.add(this.JMIECobase411);
        this.JMExportacion.add(this.JMIEquipoEspecializados);
        this.JMICoagulacion.setText("Equipos de Coagulacion");
        this.JMICoagulacion.setFont(new Font("Arial", 1, 12));
        this.JMIESTASatellite1.setFont(new Font("Arial", 1, 12));
        this.JMIESTASatellite1.setText("STA Satellite");
        this.JMIESTASatellite1.addActionListener(new ActionListener() { // from class: Acceso.Menus.349
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIESTASatellite1ActionPerformed(evt);
            }
        });
        this.JMICoagulacion.add(this.JMIESTASatellite1);
        this.JMExportacion.add(this.JMICoagulacion);
        this.JMICoagulacion.setVisible(false);
        this.JMIEquipoMicrobiologia.setText("Equipos de Microbiologia");
        this.JMIEquipoMicrobiologia.setFont(new Font("Arial", 1, 12));
        this.JMIEDL96II.setFont(new Font("Arial", 1, 12));
        this.JMIEDL96II.setText("DL-96II");
        this.JMIEDL96II.addActionListener(new ActionListener() { // from class: Acceso.Menus.350
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEDL96IIActionPerformed(evt);
            }
        });
        this.JMIEquipoMicrobiologia.add(this.JMIEDL96II);
        this.JMExportacion.add(this.JMIEquipoMicrobiologia);
        this.JMIRentransmisionResultados.setFont(new Font("Arial", 1, 12));
        this.JMIRentransmisionResultados.setText("Retransmision de Resultados");
        this.JMIRentransmisionResultados.addActionListener(new ActionListener() { // from class: Acceso.Menus.351
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRentransmisionResultadosActionPerformed(evt);
            }
        });
        this.JMExportacion.add(this.JMIRentransmisionResultados);
        this.mnuLabMovimiento.add(this.JMExportacion);
        this.JMImportacion.setText("Importación");
        this.JMImportacion.setFont(new Font("Arial", 1, 12));
        this.JMIEquipoHematologia.setText("Equipos de Hematología");
        this.JMIEquipoHematologia.setFont(new Font("Arial", 1, 12));
        this.JMIIHematologia1.setFont(new Font("Arial", 1, 12));
        this.JMIIHematologia1.setText("HA-22 TOUCH");
        this.JMIIHematologia1.addActionListener(new ActionListener() { // from class: Acceso.Menus.352
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIHematologia1ActionPerformed(evt);
            }
        });
        this.JMIEquipoHematologia.add(this.JMIIHematologia1);
        this.JMIIHematologia.setFont(new Font("Arial", 1, 12));
        this.JMIIHematologia.setText("Sysmex RX- 21N");
        this.JMIIHematologia.addActionListener(new ActionListener() { // from class: Acceso.Menus.353
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIHematologiaActionPerformed(evt);
            }
        });
        this.JMIEquipoHematologia.add(this.JMIIHematologia);
        this.JMImportacion.add(this.JMIEquipoHematologia);
        this.JMIEquipoOrinas.setText("Equipos de Orinas");
        this.JMIEquipoOrinas.setFont(new Font("Arial", 1, 12));
        this.JMIICombilyzer3.setFont(new Font("Arial", 1, 12));
        this.JMIICombilyzer3.setText("Combilyzer 3");
        this.JMIICombilyzer3.addActionListener(new ActionListener() { // from class: Acceso.Menus.354
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIICombilyzer3ActionPerformed(evt);
            }
        });
        this.JMIEquipoOrinas.add(this.JMIICombilyzer3);
        this.JMIIDiruiH.setFont(new Font("Arial", 1, 12));
        this.JMIIDiruiH.setText("Dirui H-100");
        this.JMIIDiruiH.addActionListener(new ActionListener() { // from class: Acceso.Menus.355
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIDiruiHActionPerformed(evt);
            }
        });
        this.JMIEquipoOrinas.add(this.JMIIDiruiH);
        this.JMImportacion.add(this.JMIEquipoOrinas);
        this.JMIEquipoQuimica.setText("Equipos de Química");
        this.JMIEquipoQuimica.setFont(new Font("Arial", 1, 12));
        this.JMIIBiosystemA25.setFont(new Font("Arial", 1, 12));
        this.JMIIBiosystemA25.setText("Biosystem A15 - A25");
        this.JMIIBiosystemA25.addActionListener(new ActionListener() { // from class: Acceso.Menus.356
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIBiosystemA25ActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica.add(this.JMIIBiosystemA25);
        this.JMIIQHumastar80.setFont(new Font("Arial", 1, 12));
        this.JMIIQHumastar80.setText("Humastar 80");
        this.JMIIQHumastar80.addActionListener(new ActionListener() { // from class: Acceso.Menus.357
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIQHumastar80ActionPerformed(evt);
            }
        });
        this.JMIEquipoQuimica.add(this.JMIIQHumastar80);
        this.JMImportacion.add(this.JMIEquipoQuimica);
        this.JMIIHL7Infinity.setFont(new Font("Arial", 1, 12));
        this.JMIIHL7Infinity.setText("HL7 (Infinity Roche Diagnostics)");
        this.JMIIHL7Infinity.addActionListener(new ActionListener() { // from class: Acceso.Menus.358
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIHL7InfinityActionPerformed(evt);
            }
        });
        this.JMImportacion.add(this.JMIIHL7Infinity);
        this.JMIIResultadoExternos.setFont(new Font("Arial", 1, 12));
        this.JMIIResultadoExternos.setText("Resultados Laboratorio Echavarria");
        this.JMIIResultadoExternos.addActionListener(new ActionListener() { // from class: Acceso.Menus.359
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIResultadoExternosActionPerformed(evt);
            }
        });
        this.JMImportacion.add(this.JMIIResultadoExternos);
        this.mnuLabMovimiento.add(this.JMImportacion);
        this.mnuRemisionR.setFont(new Font("Arial", 1, 12));
        this.mnuRemisionR.setText("Remisión de Exámenes");
        this.mnuRemisionR.addActionListener(new ActionListener() { // from class: Acceso.Menus.360
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRemisionRActionPerformed(evt);
            }
        });
        this.mnuLabMovimiento.add(this.mnuRemisionR);
        this.mnuRemisionR2.setFont(new Font("Arial", 1, 12));
        this.mnuRemisionR2.setText("Remisión de Exámenes 2");
        this.mnuRemisionR2.addActionListener(new ActionListener() { // from class: Acceso.Menus.361
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuRemisionR2ActionPerformed(evt);
            }
        });
        this.mnuLabMovimiento.add(this.mnuRemisionR2);
        this.mnuTraking.setFont(new Font("Arial", 1, 12));
        this.mnuTraking.setText("Tracking(Seguimiento Muestra)");
        this.mnuTraking.addActionListener(new ActionListener() { // from class: Acceso.Menus.362
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuTrakingActionPerformed(evt);
            }
        });
        this.mnuLabMovimiento.add(this.mnuTraking);
        barraMnuLab.add(this.mnuLabMovimiento);
        this.mnuLabInformes.setText("Informes");
        this.mnuLabInformes.setFont(new Font("Arial", 1, 12));
        this.mnuLabConsolidadoPorTipoServicio.setFont(new Font("Arial", 1, 12));
        this.mnuLabConsolidadoPorTipoServicio.setText("Consolidado por Tipo de Servicio");
        this.mnuLabConsolidadoPorTipoServicio.setToolTipText("Consolidado por tipo de servicio");
        this.mnuLabConsolidadoPorTipoServicio.addActionListener(new ActionListener() { // from class: Acceso.Menus.363
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabConsolidadoPorTipoServicioActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuLabConsolidadoPorTipoServicio);
        this.mnuDemandaNoAtendida.setFont(new Font("Arial", 1, 12));
        this.mnuDemandaNoAtendida.setText("Demanda no Atendida");
        this.mnuDemandaNoAtendida.setToolTipText("");
        this.mnuDemandaNoAtendida.addActionListener(new ActionListener() { // from class: Acceso.Menus.364
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuDemandaNoAtendidaActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuDemandaNoAtendida);
        this.JMEstadistica.setText("Estadística");
        this.JMEstadistica.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultados3.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultados3.setText("Costo por Municipio");
        this.mnuLabResultados3.setToolTipText("");
        this.mnuLabResultados3.addActionListener(new ActionListener() { // from class: Acceso.Menus.365
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabResultados3ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabResultados3);
        this.mnuLabProduccion.setFont(new Font("Arial", 1, 12));
        this.mnuLabProduccion.setText("Estadística de Exámenes");
        this.mnuLabProduccion.addActionListener(new ActionListener() { // from class: Acceso.Menus.366
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProduccionActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabProduccion);
        this.mnuLabProduccion4.setFont(new Font("Arial", 1, 12));
        this.mnuLabProduccion4.setText("Estadística de Muestras Nuevas");
        this.mnuLabProduccion4.addActionListener(new ActionListener() { // from class: Acceso.Menus.367
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProduccion4ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabProduccion4);
        this.mnuMuestrasRecepcionadas.setFont(new Font("Arial", 1, 12));
        this.mnuMuestrasRecepcionadas.setText("Muestras Recepcionadas");
        this.mnuMuestrasRecepcionadas.addActionListener(new ActionListener() { // from class: Acceso.Menus.368
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuMuestrasRecepcionadasActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuMuestrasRecepcionadas);
        this.mnuLabResultados4.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultados4.setText("Procedimimientos Facturados por Empresa");
        this.mnuLabResultados4.setToolTipText("");
        this.mnuLabResultados4.addActionListener(new ActionListener() { // from class: Acceso.Menus.369
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabResultados4ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabResultados4);
        this.mnuLabProduccion1.setFont(new Font("Arial", 1, 12));
        this.mnuLabProduccion1.setText("Recepciones por Entidad");
        this.mnuLabProduccion1.addActionListener(new ActionListener() { // from class: Acceso.Menus.370
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProduccion1ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabProduccion1);
        this.mnuLabProduccion2.setFont(new Font("Arial", 1, 12));
        this.mnuLabProduccion2.setText("Recepciones por Entidad  y Municipio");
        this.mnuLabProduccion2.addActionListener(new ActionListener() { // from class: Acceso.Menus.371
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProduccion2ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabProduccion2);
        this.mnuLabProduccion3.setFont(new Font("Arial", 1, 12));
        this.mnuLabProduccion3.setText("Recepciones por Entidad, Municipio y Procedimiento");
        this.mnuLabProduccion3.addActionListener(new ActionListener() { // from class: Acceso.Menus.372
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProduccion3ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabProduccion3);
        this.mnuLabResultados1.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultados1.setText("Tiempo de Espera");
        this.mnuLabResultados1.setToolTipText("");
        this.mnuLabResultados1.addActionListener(new ActionListener() { // from class: Acceso.Menus.373
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabResultados1ActionPerformed(evt);
            }
        });
        this.JMEstadistica.add(this.mnuLabResultados1);
        this.mnuLabInformes.add(this.JMEstadistica);
        this.mnuLabInformesDinamicos.setFont(new Font("Arial", 1, 12));
        this.mnuLabInformesDinamicos.setText("Informes Dinámicos");
        this.mnuLabInformesDinamicos.setToolTipText("Consulta de informes dinámicos");
        this.mnuLabInformesDinamicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.374
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabInformesDinamicosActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuLabInformesDinamicos);
        this.mnuImpresionStikers.setFont(new Font("Arial", 1, 12));
        this.mnuImpresionStikers.setToolTipText("");
        this.mnuImpresionStikers.setLabel("Impresión de Stikers(Forma A)");
        this.mnuImpresionStikers.addActionListener(new ActionListener() { // from class: Acceso.Menus.375
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuImpresionStikersActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuImpresionStikers);
        this.mnuImpresionStikers1.setFont(new Font("Arial", 1, 12));
        this.mnuImpresionStikers1.setText("Impresión de Stikers(Forma B)");
        this.mnuImpresionStikers1.setToolTipText("");
        this.mnuImpresionStikers1.addActionListener(new ActionListener() { // from class: Acceso.Menus.376
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuImpresionStikers1ActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuImpresionStikers1);
        this.mnuLabPlanillaTrabajo.setFont(new Font("Arial", 1, 12));
        this.mnuLabPlanillaTrabajo.setText("Lista de Trabajo por Area");
        this.mnuLabPlanillaTrabajo.setToolTipText("Genera las Listas de Trabajo por Area");
        this.mnuLabPlanillaTrabajo.addActionListener(new ActionListener() { // from class: Acceso.Menus.377
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabPlanillaTrabajoActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuLabPlanillaTrabajo);
        this.JMResultados.setText("Resultado");
        this.JMResultados.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoUsuario2.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoUsuario2.setText("Por Usuario");
        this.JMIConsultarResultadoUsuario2.addActionListener(new ActionListener() { // from class: Acceso.Menus.378
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoUsuario2ActionPerformed(evt);
            }
        });
        this.JMResultados.add(this.JMIConsultarResultadoUsuario2);
        this.mnuLabResultados2.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultados2.setText("Por Fecha");
        this.mnuLabResultados2.addActionListener(new ActionListener() { // from class: Acceso.Menus.379
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabResultados2ActionPerformed(evt);
            }
        });
        this.JMResultados.add(this.mnuLabResultados2);
        this.mnuLabResultadoExportacionInstitucional.setFont(new Font("Arial", 1, 12));
        this.mnuLabResultadoExportacionInstitucional.setText("Para Exportacion Institucional");
        this.mnuLabResultadoExportacionInstitucional.addActionListener(new ActionListener() { // from class: Acceso.Menus.380
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabResultadoExportacionInstitucionalActionPerformed(evt);
            }
        });
        this.JMResultados.add(this.mnuLabResultadoExportacionInstitucional);
        this.mnuLabExportarResultadosPDF.setFont(new Font("Arial", 1, 12));
        this.mnuLabExportarResultadosPDF.setText("Exportar Resultado PDF");
        this.mnuLabExportarResultadosPDF.addActionListener(new ActionListener() { // from class: Acceso.Menus.381
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabExportarResultadosPDFActionPerformed(evt);
            }
        });
        this.JMResultados.add(this.mnuLabExportarResultadosPDF);
        this.mnuLabInformes.add(this.JMResultados);
        this.mnuLabRegistroGeneral.setFont(new Font("Arial", 1, 12));
        this.mnuLabRegistroGeneral.setText("Registro General");
        this.mnuLabRegistroGeneral.setToolTipText("Genera lista de pacientes para llamar");
        this.mnuLabRegistroGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.382
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabRegistroGeneralActionPerformed(evt);
            }
        });
        this.mnuLabInformes.add(this.mnuLabRegistroGeneral);
        barraMnuLab.add(this.mnuLabInformes);
        this.mnuLabConf.setText("Parametrizaciòn");
        this.mnuLabConf.setFont(new Font("Arial", 1, 12));
        this.JMUCGeneral.setText("General");
        this.JMUCGeneral.setFont(new Font("Arial", 1, 12));
        this.mnuLabAreas.setFont(new Font("Arial", 1, 12));
        this.mnuLabAreas.setText("Areas");
        this.mnuLabAreas.addActionListener(new ActionListener() { // from class: Acceso.Menus.383
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabAreasActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabAreas);
        this.JMIUComentarioA.setFont(new Font("Arial", 1, 12));
        this.JMIUComentarioA.setText("Comentario por area");
        this.JMIUComentarioA.addActionListener(new ActionListener() { // from class: Acceso.Menus.384
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUComentarioAActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.JMIUComentarioA);
        this.mnuLabProtocolos.setFont(new Font("Arial", 1, 12));
        this.mnuLabProtocolos.setText("Protocolos");
        this.mnuLabProtocolos.addActionListener(new ActionListener() { // from class: Acceso.Menus.385
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProtocolosActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabProtocolos);
        this.JMIFEncabezado.setFont(new Font("Arial", 1, 12));
        this.JMIFEncabezado.setText("Tipo Encabezado");
        this.JMIFEncabezado.addActionListener(new ActionListener() { // from class: Acceso.Menus.386
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFEncabezadoActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.JMIFEncabezado);
        this.mnuLabTipoMuestra.setFont(new Font("Arial", 1, 12));
        this.mnuLabTipoMuestra.setText("Tipo Muestra");
        this.mnuLabTipoMuestra.addActionListener(new ActionListener() { // from class: Acceso.Menus.387
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabTipoMuestraActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabTipoMuestra);
        this.mnuLabTipoRechazo.setFont(new Font("Arial", 1, 12));
        this.mnuLabTipoRechazo.setText("Tipo Rechazo");
        this.mnuLabTipoRechazo.addActionListener(new ActionListener() { // from class: Acceso.Menus.388
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabTipoRechazoActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabTipoRechazo);
        this.mnuLabTipoMetodo.setFont(new Font("Arial", 1, 12));
        this.mnuLabTipoMetodo.setText("Tipos de Métodos");
        this.mnuLabTipoMetodo.addActionListener(new ActionListener() { // from class: Acceso.Menus.389
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabTipoMetodoActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabTipoMetodo);
        this.mnuLabTipoResultado.setFont(new Font("Arial", 1, 12));
        this.mnuLabTipoResultado.setText("Tipos de Resultados");
        this.mnuLabTipoResultado.addActionListener(new ActionListener() { // from class: Acceso.Menus.390
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabTipoResultadoActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabTipoResultado);
        this.mnuLabTipoTubo.setFont(new Font("Arial", 1, 12));
        this.mnuLabTipoTubo.setText("Tipos de Tubo");
        this.mnuLabTipoTubo.addActionListener(new ActionListener() { // from class: Acceso.Menus.391
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabTipoTuboActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabTipoTubo);
        this.mnuLabHomologacionItemsExternos.setFont(new Font("Arial", 1, 12));
        this.mnuLabHomologacionItemsExternos.setText("Homologacion de Items Externos");
        this.mnuLabHomologacionItemsExternos.addActionListener(new ActionListener() { // from class: Acceso.Menus.392
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabHomologacionItemsExternosActionPerformed(evt);
            }
        });
        this.JMUCGeneral.add(this.mnuLabHomologacionItemsExternos);
        this.mnuLabConf.add(this.JMUCGeneral);
        this.mnuLabProcedimiento.setFont(new Font("Arial", 1, 12));
        this.mnuLabProcedimiento.setText("Procedimiento");
        this.mnuLabProcedimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.393
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProcedimientoActionPerformed(evt);
            }
        });
        this.mnuLabConf.add(this.mnuLabProcedimiento);
        this.mnuLabProcedimientoUnif.setFont(new Font("Arial", 1, 12));
        this.mnuLabProcedimientoUnif.setText("Procedimientos Unificados");
        this.mnuLabProcedimientoUnif.addActionListener(new ActionListener() { // from class: Acceso.Menus.394
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProcedimientoUnifActionPerformed(evt);
            }
        });
        this.mnuLabConf.add(this.mnuLabProcedimientoUnif);
        this.mnuLabProcedimientoRelac.setFont(new Font("Arial", 1, 12));
        this.mnuLabProcedimientoRelac.setText("Procedimientos Relacionados");
        this.mnuLabProcedimientoRelac.addActionListener(new ActionListener() { // from class: Acceso.Menus.395
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProcedimientoRelacActionPerformed(evt);
            }
        });
        this.mnuLabConf.add(this.mnuLabProcedimientoRelac);
        this.mnuLabProcedimientoRelac.setVisible(false);
        this.mnuLabProxAreaxPocedim.setFont(new Font("Arial", 1, 12));
        this.mnuLabProxAreaxPocedim.setText("Protocolos x Area x Procedimientos");
        this.mnuLabProxAreaxPocedim.addActionListener(new ActionListener() { // from class: Acceso.Menus.396
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProxAreaxPocedimActionPerformed(evt);
            }
        });
        this.mnuLabConf.add(this.mnuLabProxAreaxPocedim);
        this.mnuLabProtocoloxTipoResultado.setFont(new Font("Arial", 1, 12));
        this.mnuLabProtocoloxTipoResultado.setText("Protocolo x Tipo de Resultado");
        this.mnuLabProtocoloxTipoResultado.addActionListener(new ActionListener() { // from class: Acceso.Menus.397
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuLabProtocoloxTipoResultadoActionPerformed(evt);
            }
        });
        this.mnuLabConf.add(this.mnuLabProtocoloxTipoResultado);
        barraMnuLab.add(this.mnuLabConf);
        this.mnuImportarResultadoExternosPDF.setText("Utilidades");
        this.mnuImportarResultadoExternosPDF.setFont(new Font("Arial", 1, 12));
        this.JMConstanciaAten.setFont(new Font("Arial", 1, 12));
        this.JMConstanciaAten.setText("Constacia de Atención");
        this.JMConstanciaAten.addActionListener(new ActionListener() { // from class: Acceso.Menus.398
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMConstanciaAtenActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMConstanciaAten);
        this.JMCopiaDocumentos.setFont(new Font("Arial", 1, 12));
        this.JMCopiaDocumentos.setText("Copia de Documentos");
        this.JMCopiaDocumentos.addActionListener(new ActionListener() { // from class: Acceso.Menus.399
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCopiaDocumentosActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMCopiaDocumentos);
        this.JMRegisDatosExamen.setFont(new Font("Arial", 1, 12));
        this.JMRegisDatosExamen.setText("Registro de Datos Adicinales a Exámen");
        this.JMRegisDatosExamen.addActionListener(new ActionListener() { // from class: Acceso.Menus.400
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMRegisDatosExamenActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMRegisDatosExamen);
        this.JMRegisRechazo.setFont(new Font("Arial", 1, 12));
        this.JMRegisRechazo.setText("Registro de Rechazo de Muestra");
        this.JMRegisRechazo.addActionListener(new ActionListener() { // from class: Acceso.Menus.401
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMRegisRechazoActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMRegisRechazo);
        this.JMUReportesLog.setText("Logística");
        this.JMUReportesLog.setFont(new Font("Arial", 1, 12));
        this.JMReporteI1.setFont(new Font("Arial", 1, 12));
        this.JMReporteI1.setText("Reporte");
        this.JMReporteI1.addActionListener(new ActionListener() { // from class: Acceso.Menus.402
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMReporteI1ActionPerformed(evt);
            }
        });
        this.JMUReportesLog.add(this.JMReporteI1);
        this.mnuImportarResultadoExternosPDF.add(this.JMUReportesLog);
        this.JMIConsultarResultadoExa.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoExa.setText("Consultar Resultado de Exámenes");
        this.JMIConsultarResultadoExa.addActionListener(new ActionListener() { // from class: Acceso.Menus.403
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoExaActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMIConsultarResultadoExa);
        this.JMIConsultarResultadoExa1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarResultadoExa1.setText("Importacion de Resultados Externos en PDF");
        this.JMIConsultarResultadoExa1.addActionListener(new ActionListener() { // from class: Acceso.Menus.404
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarResultadoExa1ActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMIConsultarResultadoExa1);
        this.JMILValidacionAdministrativa.setFont(new Font("Arial", 1, 12));
        this.JMILValidacionAdministrativa.setText("Validación Administrativa");
        this.JMILValidacionAdministrativa.addActionListener(new ActionListener() { // from class: Acceso.Menus.405
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMILValidacionAdministrativaActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.JMILValidacionAdministrativa);
        this.importarcorreo.setText("Importar Correos por Usuarios");
        this.importarcorreo.addActionListener(new ActionListener() { // from class: Acceso.Menus.406
            public void actionPerformed(ActionEvent evt) {
                Menus.this.importarcorreoActionPerformed(evt);
            }
        });
        this.mnuImportarResultadoExternosPDF.add(this.importarcorreo);
        barraMnuLab.add(this.mnuImportarResultadoExternosPDF);
        this.JMActivos.setText("Activos");
        this.JMActivos.setFont(new Font("Arial", 1, 12));
        this.mnuActivos.setFont(new Font("Arial", 1, 12));
        this.mnuActivos.setText("Gestión");
        this.mnuActivos.addActionListener(new ActionListener() { // from class: Acceso.Menus.407
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuActivosActionPerformed(evt);
            }
        });
        this.JMActivos.add(this.mnuActivos);
        barraMnuMant.add(this.JMActivos);
        this.JMHojadeVida.setText("Hoja de Vida Equipo");
        this.JMHojadeVida.setFont(new Font("Arial", 1, 12));
        this.mnubaja.setFont(new Font("Arial", 1, 12));
        this.mnubaja.setText("Equipos Activos / Inactivos");
        this.mnubaja.addActionListener(new ActionListener() { // from class: Acceso.Menus.408
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnubajaActionPerformed(evt);
            }
        });
        this.JMHojadeVida.add(this.mnubaja);
        this.mnuIngresar.setFont(new Font("Arial", 1, 12));
        this.mnuIngresar.setText("Ingresar Equipos");
        this.mnuIngresar.addActionListener(new ActionListener() { // from class: Acceso.Menus.409
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuIngresarActionPerformed(evt);
            }
        });
        this.JMHojadeVida.add(this.mnuIngresar);
        barraMnuMant.add(this.JMHojadeVida);
        this.mnuReporte.setText("Reporte");
        this.mnuReporte.setFont(new Font("Arial", 1, 12));
        this.mnuConsultarEstado.setFont(new Font("Arial", 1, 12));
        this.mnuConsultarEstado.setText("Consultar Estado");
        this.mnuConsultarEstado.setToolTipText("Generar Reporte");
        this.mnuConsultarEstado.addActionListener(new ActionListener() { // from class: Acceso.Menus.410
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuConsultarEstadoActionPerformed(evt);
            }
        });
        this.mnuReporte.add(this.mnuConsultarEstado);
        this.mnuGenerar.setFont(new Font("Arial", 1, 12));
        this.mnuGenerar.setText("Generar");
        this.mnuGenerar.setToolTipText("Generar Reporte");
        this.mnuGenerar.addActionListener(new ActionListener() { // from class: Acceso.Menus.411
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuGenerarActionPerformed(evt);
            }
        });
        this.mnuReporte.add(this.mnuGenerar);
        this.mnuReportes.setFont(new Font("Arial", 1, 12));
        this.mnuReportes.setText("Reportes");
        this.mnuReportes.setToolTipText("Generar Reporte");
        this.mnuReportes.addActionListener(new ActionListener() { // from class: Acceso.Menus.412
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuReportesActionPerformed(evt);
            }
        });
        this.mnuReporte.add(this.mnuReportes);
        this.mnuReportes1.setFont(new Font("Arial", 1, 12));
        this.mnuReportes1.setText("Tiempo Reportes");
        this.mnuReportes1.setToolTipText("Generar Reporte");
        this.mnuReportes1.addActionListener(new ActionListener() { // from class: Acceso.Menus.413
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuReportes1ActionPerformed(evt);
            }
        });
        this.mnuReporte.add(this.mnuReportes1);
        this.mnuInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.mnuInformesGenerales.setText("InformesGenerales");
        this.mnuInformesGenerales.setToolTipText("Generar Reporte");
        this.mnuInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.414
            public void actionPerformed(ActionEvent evt) {
                Menus.this.mnuInformesGeneralesActionPerformed(evt);
            }
        });
        this.mnuReporte.add(this.mnuInformesGenerales);
        barraMnuMant.add(this.mnuReporte);
        this.JMGestion2.setMnemonic('P');
        this.JMGestion2.setText("Gestión RRHH");
        this.JMGestion2.setFont(new Font("Arial", 1, 12));
        this.JMGestionEmpleado.setFont(new Font("Arial", 1, 12));
        this.JMGestionEmpleado.setText("Gestion De Empleado");
        this.JMGestionEmpleado.addActionListener(new ActionListener() { // from class: Acceso.Menus.415
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMGestionEmpleadoActionPerformed1(evt);
            }
        });
        this.JMGestion2.add(this.JMGestionEmpleado);
        this.JMG_Nomina.setText("Nomina");
        this.JMG_Nomina.setFont(new Font("Arial", 1, 12));
        this.JMIGN_LiquidacionN.setFont(new Font("Arial", 1, 12));
        this.JMIGN_LiquidacionN.setText("Liquidación");
        this.JMIGN_LiquidacionN.addActionListener(new ActionListener() { // from class: Acceso.Menus.416
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_LiquidacionNActionPerformed(evt);
            }
        });
        this.JMG_Nomina.add(this.JMIGN_LiquidacionN);
        this.JMIGN_LiquidacionNueva.setFont(new Font("Arial", 1, 12));
        this.JMIGN_LiquidacionNueva.setText("Liquidación(Beta)");
        this.JMIGN_LiquidacionNueva.addActionListener(new ActionListener() { // from class: Acceso.Menus.417
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_LiquidacionNuevaActionPerformed(evt);
            }
        });
        this.JMG_Nomina.add(this.JMIGN_LiquidacionNueva);
        this.JMIGN_Causacion.setFont(new Font("Arial", 1, 12));
        this.JMIGN_Causacion.setText("Causación");
        this.JMIGN_Causacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.418
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_CausacionActionPerformed(evt);
            }
        });
        this.JMG_Nomina.add(this.JMIGN_Causacion);
        this.JMGDeduccionConceptos.setFont(new Font("Arial", 1, 12));
        this.JMGDeduccionConceptos.setText("Consolidado por Concepto");
        this.JMGDeduccionConceptos.addActionListener(new ActionListener() { // from class: Acceso.Menus.419
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMGDeduccionConceptosActionPerformed1(evt);
            }
        });
        this.JMG_Nomina.add(this.JMGDeduccionConceptos);
        this.JMGestion2.add(this.JMG_Nomina);
        barraMnuRrhh.add(this.JMGestion2);
        this.JMUtilidadesRH.setText("Utilidades");
        this.JMUtilidadesRH.setFont(new Font("Arial", 1, 12));
        this.JMIUAutorizaciones.setFont(new Font("Arial", 1, 12));
        this.JMIUAutorizaciones.setText("Autorización");
        this.JMIUAutorizaciones.addActionListener(new ActionListener() { // from class: Acceso.Menus.420
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAutorizacionesActionPerformed1(evt);
            }
        });
        this.JMUtilidadesRH.add(this.JMIUAutorizaciones);
        this.jMIUEmpleados.setFont(new Font("Arial", 1, 12));
        this.jMIUEmpleados.setText("Empleados");
        this.jMIUEmpleados.addMouseListener(new MouseAdapter() { // from class: Acceso.Menus.421
            public void mouseClicked(MouseEvent evt) {
                Menus.this.jMIUEmpleadosMouseClicked(evt);
            }
        });
        this.jMIUEmpleados.addActionListener(new ActionListener() { // from class: Acceso.Menus.422
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMIUEmpleadosActionPerformed(evt);
            }
        });
        this.JMUtilidadesRH.add(this.jMIUEmpleados);
        this.JMIUNomina.setText("Nomina");
        this.JMIUNomina.setFont(new Font("Arial", 1, 12));
        this.JMIUC_Gestion_Concepto.setFont(new Font("Arial", 1, 12));
        this.JMIUC_Gestion_Concepto.setText("Gestión de Conceptos por Lote");
        this.JMIUC_Gestion_Concepto.addActionListener(new ActionListener() { // from class: Acceso.Menus.423
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUC_Gestion_ConceptoActionPerformed(evt);
            }
        });
        this.JMIUNomina.add(this.JMIUC_Gestion_Concepto);
        this.JMUtilidadesRH.add(this.JMIUNomina);
        this.JMIUNovedadesN.setText("Novedades");
        this.JMIUNovedadesN.setFont(new Font("Arial", 1, 12));
        this.jMIUNovedadesNomina.setFont(new Font("Arial", 1, 12));
        this.jMIUNovedadesNomina.setText("Registro");
        this.jMIUNovedadesNomina.addActionListener(new ActionListener() { // from class: Acceso.Menus.424
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMIUNovedadesNominaActionPerformed(evt);
            }
        });
        this.JMIUNovedadesN.add(this.jMIUNovedadesNomina);
        this.JMIUInformesNovedades.setFont(new Font("Arial", 1, 12));
        this.JMIUInformesNovedades.setText("Consolidado de Registro");
        this.JMIUInformesNovedades.addActionListener(new ActionListener() { // from class: Acceso.Menus.425
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUInformesNovedadesActionPerformed(evt);
            }
        });
        this.JMIUNovedadesN.add(this.JMIUInformesNovedades);
        this.JMUtilidadesRH.add(this.JMIUNovedadesN);
        this.jMIUPrestamos.setFont(new Font("Arial", 1, 12));
        this.jMIUPrestamos.setText("Prestamos");
        this.jMIUPrestamos.addMouseListener(new MouseAdapter() { // from class: Acceso.Menus.426
            public void mouseClicked(MouseEvent evt) {
                Menus.this.jMIUPrestamosMouseClicked(evt);
            }
        });
        this.jMIUPrestamos.addActionListener(new ActionListener() { // from class: Acceso.Menus.427
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMIUPrestamosActionPerformed(evt);
            }
        });
        this.JMUtilidadesRH.add(this.jMIUPrestamos);
        this.jMIUTrasmisionNomina.setFont(new Font("Arial", 1, 12));
        this.jMIUTrasmisionNomina.setText("Transmisión Nómina");
        this.jMIUTrasmisionNomina.addActionListener(new ActionListener() { // from class: Acceso.Menus.428
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMIUTrasmisionNominaActionPerformed(evt);
            }
        });
        this.JMUtilidadesRH.add(this.jMIUTrasmisionNomina);
        this.jMIUTrasmisionNotaNomina.setFont(new Font("Arial", 1, 12));
        this.jMIUTrasmisionNotaNomina.setText("Transmisión Notas Nómina");
        this.jMIUTrasmisionNotaNomina.addActionListener(new ActionListener() { // from class: Acceso.Menus.429
            public void actionPerformed(ActionEvent evt) {
                Menus.this.jMIUTrasmisionNotaNominaActionPerformed(evt);
            }
        });
        this.JMUtilidadesRH.add(this.jMIUTrasmisionNotaNomina);
        this.JMIUAnticipos.setFont(new Font("Arial", 1, 12));
        this.JMIUAnticipos.setText("Viáticos y Gastos de Viaje");
        this.JMIUAnticipos.addActionListener(new ActionListener() { // from class: Acceso.Menus.430
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUAnticiposActionPerformed1(evt);
            }
        });
        this.JMUtilidadesRH.add(this.JMIUAnticipos);
        barraMnuRrhh.add(this.JMUtilidadesRH);
        this.JMGestion3.setMnemonic('P');
        this.JMGestion3.setText("Informes");
        this.JMGestion3.setFont(new Font("Arial", 1, 12));
        this.JMG_Nomina1.setText("Nomina");
        this.JMG_Nomina1.setFont(new Font("Arial", 1, 12));
        this.JMIGN_ConsolidadoConceptosRH.setFont(new Font("Arial", 1, 12));
        this.JMIGN_ConsolidadoConceptosRH.setText("Consolidado Por Conceptos");
        this.JMIGN_ConsolidadoConceptosRH.addActionListener(new ActionListener() { // from class: Acceso.Menus.431
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_ConsolidadoConceptosRHActionPerformed(evt);
            }
        });
        this.JMG_Nomina1.add(this.JMIGN_ConsolidadoConceptosRH);
        this.JMIGN_ConsultarNominaIntervaloFecha.setFont(new Font("Arial", 1, 12));
        this.JMIGN_ConsultarNominaIntervaloFecha.setText("Consolidado por Intervalo de Fecha");
        this.JMIGN_ConsultarNominaIntervaloFecha.addActionListener(new ActionListener() { // from class: Acceso.Menus.432
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_ConsultarNominaIntervaloFechaActionPerformed(evt);
            }
        });
        this.JMG_Nomina1.add(this.JMIGN_ConsultarNominaIntervaloFecha);
        this.JMIGN_ConsolidadoPersonal.setFont(new Font("Arial", 1, 12));
        this.JMIGN_ConsolidadoPersonal.setText("Consolidado Personal");
        this.JMIGN_ConsolidadoPersonal.addActionListener(new ActionListener() { // from class: Acceso.Menus.433
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_ConsolidadoPersonalActionPerformed(evt);
            }
        });
        this.JMG_Nomina1.add(this.JMIGN_ConsolidadoPersonal);
        this.JMIGN_ConsultarPlanillas.setFont(new Font("Arial", 1, 12));
        this.JMIGN_ConsultarPlanillas.setText("Consultar Planillas");
        this.JMIGN_ConsultarPlanillas.addActionListener(new ActionListener() { // from class: Acceso.Menus.434
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_ConsultarPlanillasActionPerformed(evt);
            }
        });
        this.JMG_Nomina1.add(this.JMIGN_ConsultarPlanillas);
        this.JMIGN_InformeCGR.setFont(new Font("Arial", 1, 12));
        this.JMIGN_InformeCGR.setText("Informe CGR");
        this.JMIGN_InformeCGR.addActionListener(new ActionListener() { // from class: Acceso.Menus.435
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGN_InformeCGRActionPerformed(evt);
            }
        });
        this.JMG_Nomina1.add(this.JMIGN_InformeCGR);
        this.JMGestion3.add(this.JMG_Nomina1);
        this.JMIUInformesGeneral.setFont(new Font("Arial", 1, 12));
        this.JMIUInformesGeneral.setText("Informes Generales");
        this.JMIUInformesGeneral.addActionListener(new ActionListener() { // from class: Acceso.Menus.436
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUInformesGeneralActionPerformed1(evt);
            }
        });
        this.JMGestion3.add(this.JMIUInformesGeneral);
        barraMnuRrhh.add(this.JMGestion3);
        this.mnuMvtom.setText("Caja Menor");
        this.mnuMvtom.setFont(new Font("Arial", 1, 12));
        this.JMICRegistroRecibosCM.setFont(new Font("Arial", 1, 12));
        this.JMICRegistroRecibosCM.setText("Registro Recibos");
        this.JMICRegistroRecibosCM.setToolTipText("");
        this.JMICRegistroRecibosCM.addActionListener(new ActionListener() { // from class: Acceso.Menus.437
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICRegistroRecibosCMActionPerformed(evt);
            }
        });
        this.mnuMvtom.add(this.JMICRegistroRecibosCM);
        this.JMICSolicitudRCM.setFont(new Font("Arial", 1, 12));
        this.JMICSolicitudRCM.setText("Cierre");
        this.JMICSolicitudRCM.setToolTipText("");
        this.JMICSolicitudRCM.addActionListener(new ActionListener() { // from class: Acceso.Menus.438
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICSolicitudRCMActionPerformed(evt);
            }
        });
        this.mnuMvtom.add(this.JMICSolicitudRCM);
        this.JMICInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMICInformesGenerales.setText("Informes Generales");
        this.JMICInformesGenerales.setToolTipText("");
        this.JMICInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.439
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICInformesGeneralesActionPerformed(evt);
            }
        });
        this.mnuMvtom.add(this.JMICInformesGenerales);
        barraMnuCajaM.add(this.mnuMvtom);
        this.JIMIPrincipal.setText("Imágenes Diagnósticas");
        this.JIMIPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMIAgendaRx.setFont(new Font("Arial", 1, 12));
        this.JMIAgendaRx.setText("Agenda");
        this.JMIAgendaRx.setToolTipText("");
        this.JMIAgendaRx.addActionListener(new ActionListener() { // from class: Acceso.Menus.440
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaRxActionPerformed(evt);
            }
        });
        this.JIMIPrincipal.add(this.JMIAgendaRx);
        this.JMIConsultarEstadoO.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarEstadoO.setText("Consutar Estado Ordenes");
        this.JMIConsultarEstadoO.setToolTipText("");
        this.JMIConsultarEstadoO.addActionListener(new ActionListener() { // from class: Acceso.Menus.441
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarEstadoOActionPerformed(evt);
            }
        });
        this.JIMIPrincipal.add(this.JMIConsultarEstadoO);
        this.JMIRegistroInformacionP.setFont(new Font("Arial", 1, 12));
        this.JMIRegistroInformacionP.setText("Registro de Información Placas");
        this.JMIRegistroInformacionP.setToolTipText("");
        this.JMIRegistroInformacionP.addActionListener(new ActionListener() { // from class: Acceso.Menus.442
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRegistroInformacionPActionPerformed(evt);
            }
        });
        this.JIMIPrincipal.add(this.JMIRegistroInformacionP);
        barraMnuImagenDx.add(this.JIMIPrincipal);
        this.JIMIInformesRx.setText("Informes");
        this.JIMIInformesRx.setFont(new Font("Arial", 1, 12));
        this.JMEstadistica1.setText("Estadística");
        this.JMEstadistica1.setFont(new Font("Arial", 1, 12));
        this.JMITiempoRx.setFont(new Font("Arial", 1, 12));
        this.JMITiempoRx.setText("Tiempo de Espera RX");
        this.JMITiempoRx.setToolTipText("");
        this.JMITiempoRx.addActionListener(new ActionListener() { // from class: Acceso.Menus.443
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMITiempoRxActionPerformed(evt);
            }
        });
        this.JMEstadistica1.add(this.JMITiempoRx);
        this.JIMIInformesRx.add(this.JMEstadistica1);
        this.JMLectura.setText("Lectura");
        this.JMLectura.setFont(new Font("Arial", 1, 12));
        this.JMIConsolidadoLectura.setFont(new Font("Arial", 1, 12));
        this.JMIConsolidadoLectura.setText("Consolidado de Lecturas");
        this.JMIConsolidadoLectura.setToolTipText("");
        this.JMIConsolidadoLectura.addActionListener(new ActionListener() { // from class: Acceso.Menus.444
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsolidadoLecturaActionPerformed(evt);
            }
        });
        this.JMLectura.add(this.JMIConsolidadoLectura);
        this.JIMIInformesRx.add(this.JMLectura);
        barraMnuImagenDx.add(this.JIMIInformesRx);
        this.JIMIUtilidades.setText("Utilidades");
        this.JIMIUtilidades.setFont(new Font("Arial", 1, 12));
        this.JIMRUInfomeLecturaUsuario.setFont(new Font("Arial", 1, 12));
        this.JIMRUInfomeLecturaUsuario.setText("Informe De Lecturas Por Usuario");
        this.JIMRUInfomeLecturaUsuario.setToolTipText("");
        this.JIMRUInfomeLecturaUsuario.addActionListener(new ActionListener() { // from class: Acceso.Menus.445
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JIMRUInfomeLecturaUsuarioActionPerformed(evt);
            }
        });
        this.JIMIUtilidades.add(this.JIMRUInfomeLecturaUsuario);
        this.JIMRULecturaOit.setFont(new Font("Arial", 1, 12));
        this.JIMRULecturaOit.setText("Lectura Imagenes");
        this.JIMRULecturaOit.setToolTipText("");
        this.JIMRULecturaOit.addActionListener(new ActionListener() { // from class: Acceso.Menus.446
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JIMRULecturaOitActionPerformed(evt);
            }
        });
        this.JIMIUtilidades.add(this.JIMRULecturaOit);
        this.JIMRUNotasIma.setFont(new Font("Arial", 1, 12));
        this.JIMRUNotasIma.setText("Notas de Radiologías");
        this.JIMRUNotasIma.setToolTipText("");
        this.JIMRUNotasIma.addActionListener(new ActionListener() { // from class: Acceso.Menus.447
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JIMRUNotasImaActionPerformed(evt);
            }
        });
        this.JIMIUtilidades.add(this.JIMRUNotasIma);
        this.JIMRInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JIMRInformesGenerales.setText("Informes Generales");
        this.JIMRInformesGenerales.setToolTipText("");
        this.JIMRInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.448
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JIMRInformesGeneralesActionPerformed(evt);
            }
        });
        this.JIMIUtilidades.add(this.JIMRInformesGenerales);
        barraMnuImagenDx.add(this.JIMIUtilidades);
        this.JIMIPrincipalCp1.setText("Gestión Cuentas");
        this.JIMIPrincipalCp1.setFont(new Font("Arial", 1, 12));
        this.JMUArmadoCuentas.setText("Armado de Cuentas");
        this.JMUArmadoCuentas.setFont(new Font("Arial", 1, 12));
        this.JMIACapitacionG.setFont(new Font("Arial", 1, 12));
        this.JMIACapitacionG.setText("Capitación Global");
        this.JMIACapitacionG.addActionListener(new ActionListener() { // from class: Acceso.Menus.449
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIACapitacionGActionPerformed(evt);
            }
        });
        this.JMUArmadoCuentas.add(this.JMIACapitacionG);
        this.JMIAOrdenFactura.setFont(new Font("Arial", 1, 12));
        this.JMIAOrdenFactura.setText("Ordenes / Facturas");
        this.JMIAOrdenFactura.addActionListener(new ActionListener() { // from class: Acceso.Menus.450
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAOrdenFacturaActionPerformed(evt);
            }
        });
        this.JMUArmadoCuentas.add(this.JMIAOrdenFactura);
        this.JMIAProcedimientosA.setFont(new Font("Arial", 1, 12));
        this.JMIAProcedimientosA.setText("Procedimientos Ambulatorios");
        this.JMIAProcedimientosA.addActionListener(new ActionListener() { // from class: Acceso.Menus.451
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAProcedimientosAActionPerformed(evt);
            }
        });
        this.JMUArmadoCuentas.add(this.JMIAProcedimientosA);
        this.JIMIPrincipalCp1.add(this.JMUArmadoCuentas);
        this.JMGCCartera.setText("Cartera");
        this.JMGCCartera.setFont(new Font("Arial", 1, 12));
        this.JMGCCGestion.setFont(new Font("Arial", 1, 12));
        this.JMGCCGestion.setText("Gestión");
        this.JMGCCGestion.addActionListener(new ActionListener() { // from class: Acceso.Menus.452
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMGCCGestionActionPerformed(evt);
            }
        });
        this.JMGCCartera.add(this.JMGCCGestion);
        this.JMGCCG_PagosGrupales.setFont(new Font("Arial", 1, 12));
        this.JMGCCG_PagosGrupales.setText("Gestión Pagos");
        this.JMGCCG_PagosGrupales.addActionListener(new ActionListener() { // from class: Acceso.Menus.453
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMGCCG_PagosGrupalesActionPerformed(evt);
            }
        });
        this.JMGCCartera.add(this.JMGCCG_PagosGrupales);
        this.JMIAgendaRx2.setFont(new Font("Arial", 1, 12));
        this.JMIAgendaRx2.setText("Gestión de Factura");
        this.JMIAgendaRx2.setToolTipText("");
        this.JMIAgendaRx2.addActionListener(new ActionListener() { // from class: Acceso.Menus.454
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAgendaRx2ActionPerformed(evt);
            }
        });
        this.JMGCCartera.add(this.JMIAgendaRx2);
        this.JMIRadicacionFacturasMasiva.setFont(new Font("Arial", 1, 12));
        this.JMIRadicacionFacturasMasiva.setToolTipText("");
        this.JMIRadicacionFacturasMasiva.setLabel("Radicación Masiva de Facturas");
        this.JMIRadicacionFacturasMasiva.addActionListener(new ActionListener() { // from class: Acceso.Menus.455
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIRadicacionFacturasMasivaActionPerformed(evt);
            }
        });
        this.JMGCCartera.add(this.JMIRadicacionFacturasMasiva);
        this.JIMIPrincipalCp1.add(this.JMGCCartera);
        this.JMUCuentaCobro.setText("Cuenta de Cobro");
        this.JMUCuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JMIPConsultarCPE.setFont(new Font("Arial", 1, 12));
        this.JMIPConsultarCPE.setText("Consultar Cuentas por Empresa");
        this.JMIPConsultarCPE.addActionListener(new ActionListener() { // from class: Acceso.Menus.456
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPConsultarCPEActionPerformed(evt);
            }
        });
        this.JMUCuentaCobro.add(this.JMIPConsultarCPE);
        this.JMICGenerar.setText("Generación");
        this.JMICGenerar.setFont(new Font("Arial", 1, 12));
        this.JMIACapitacion1.setFont(new Font("Arial", 1, 12));
        this.JMIACapitacion1.setText("Capitacion Global");
        this.JMIACapitacion1.addActionListener(new ActionListener() { // from class: Acceso.Menus.457
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIACapitacion1ActionPerformed(evt);
            }
        });
        this.JMICGenerar.add(this.JMIACapitacion1);
        this.JMIACapitacionServicio.setFont(new Font("Arial", 1, 12));
        this.JMIACapitacionServicio.setText("Capitación por Servicio");
        this.JMIACapitacionServicio.addActionListener(new ActionListener() { // from class: Acceso.Menus.458
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIACapitacionServicioActionPerformed(evt);
            }
        });
        this.JMICGenerar.add(this.JMIACapitacionServicio);
        this.JMUGFacturaConcepto.setFont(new Font("Arial", 1, 12));
        this.JMUGFacturaConcepto.setText("Generar Factura por Conceptos");
        this.JMUGFacturaConcepto.addActionListener(new ActionListener() { // from class: Acceso.Menus.459
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUGFacturaConceptoActionPerformed(evt);
            }
        });
        this.JMICGenerar.add(this.JMUGFacturaConcepto);
        this.JMIAGEventoServicio.setFont(new Font("Arial", 1, 12));
        this.JMIAGEventoServicio.setText("Evento Servicio");
        this.JMIAGEventoServicio.addActionListener(new ActionListener() { // from class: Acceso.Menus.460
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAGEventoServicioActionPerformed(evt);
            }
        });
        this.JMICGenerar.add(this.JMIAGEventoServicio);
        this.JMUCuentaCobro.add(this.JMICGenerar);
        this.JIMIPrincipalCp1.add(this.JMUCuentaCobro);
        barraMnuGCuentas.add(this.JIMIPrincipalCp1);
        this.JIMA_Informes.setText("Informes");
        this.JIMA_Informes.setFont(new Font("Arial", 1, 12));
        this.JMIA_Produccion.setText("Facturación");
        this.JMIA_Produccion.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoFE.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoFE.setText("Consolidado de Ingresos por Empresa");
        this.JMIP_ConsolidadoFE.addActionListener(new ActionListener() { // from class: Acceso.Menus.461
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadoFEActionPerformed(evt);
            }
        });
        this.JMIA_Produccion.add(this.JMIP_ConsolidadoFE);
        this.JMIP_ConsolidadoFF.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoFF.setActionCommand("Consolidado de Ingresos por Facturador");
        this.JMIP_ConsolidadoFF.setLabel("Consolidado de Ingresos por Facturador");
        this.JMIP_ConsolidadoFF.addActionListener(new ActionListener() { // from class: Acceso.Menus.462
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadoFFActionPerformed(evt);
            }
        });
        this.JMIA_Produccion.add(this.JMIP_ConsolidadoFF);
        this.JMIPListaFacturaVenta.setFont(new Font("Arial", 1, 12));
        this.JMIPListaFacturaVenta.setText("Listado de Facturas de Ventas");
        this.JMIPListaFacturaVenta.setToolTipText("");
        this.JMIPListaFacturaVenta.addActionListener(new ActionListener() { // from class: Acceso.Menus.463
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPListaFacturaVentaActionPerformed(evt);
            }
        });
        this.JMIA_Produccion.add(this.JMIPListaFacturaVenta);
        this.JMIPListaOrdenInterna.setFont(new Font("Arial", 1, 12));
        this.JMIPListaOrdenInterna.setText("Listado de Ordenes Internas");
        this.JMIPListaOrdenInterna.setToolTipText("");
        this.JMIPListaOrdenInterna.addActionListener(new ActionListener() { // from class: Acceso.Menus.464
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPListaOrdenInternaActionPerformed(evt);
            }
        });
        this.JMIA_Produccion.add(this.JMIPListaOrdenInterna);
        this.JIMA_Informes.add(this.JMIA_Produccion);
        this.JMIA_InfCartera.setText("Cartera");
        this.JMIA_InfCartera.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoCartera.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoCartera.setText("Consolidado de Cartera");
        this.JMIP_ConsolidadoCartera.addActionListener(new ActionListener() { // from class: Acceso.Menus.465
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadoCarteraActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_ConsolidadoCartera);
        this.JMIP_ConsolidadoGlosas.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoGlosas.setText("Consolidado de Glosas");
        this.JMIP_ConsolidadoGlosas.addActionListener(new ActionListener() { // from class: Acceso.Menus.466
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadoGlosasActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_ConsolidadoGlosas);
        this.JMIP_ConsolidadoGlosasDefinitivo.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadoGlosasDefinitivo.setText("Consolidado de Glosas Definitivo");
        this.JMIP_ConsolidadoGlosasDefinitivo.addActionListener(new ActionListener() { // from class: Acceso.Menus.467
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadoGlosasDefinitivoActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_ConsolidadoGlosasDefinitivo);
        this.JMIP_Circular030.setFont(new Font("Arial", 1, 12));
        this.JMIP_Circular030.setText("Circular 030");
        this.JMIP_Circular030.addActionListener(new ActionListener() { // from class: Acceso.Menus.468
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_Circular030ActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_Circular030);
        this.JMIP_InformeCartera2193.setFont(new Font("Arial", 1, 12));
        this.JMIP_InformeCartera2193.setText("Informe Cartera 2193");
        this.JMIP_InformeCartera2193.addActionListener(new ActionListener() { // from class: Acceso.Menus.469
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_InformeCartera2193ActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_InformeCartera2193);
        this.JMIP_ConsolidadosDePagos.setFont(new Font("Arial", 1, 12));
        this.JMIP_ConsolidadosDePagos.setText("Consolidados de pagos");
        this.JMIP_ConsolidadosDePagos.addActionListener(new ActionListener() { // from class: Acceso.Menus.470
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_ConsolidadosDePagosActionPerformed(evt);
            }
        });
        this.JMIA_InfCartera.add(this.JMIP_ConsolidadosDePagos);
        this.JIMA_Informes.add(this.JMIA_InfCartera);
        this.JMIP_InformesPyP.setFont(new Font("Arial", 1, 12));
        this.JMIP_InformesPyP.setText("Informes Generales");
        this.JMIP_InformesPyP.addActionListener(new ActionListener() { // from class: Acceso.Menus.471
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_InformesPyPActionPerformed(evt);
            }
        });
        this.JIMA_Informes.add(this.JMIP_InformesPyP);
        barraMnuGCuentas.add(this.JIMA_Informes);
        this.JIMUtilidadesC.setText("Utilidades");
        this.JIMUtilidadesC.setFont(new Font("Arial", 1, 12));
        this.JMIUtilidadesCart.setText("Cartera");
        this.JMIUtilidadesCart.setFont(new Font("Arial", 1, 12));
        this.JMIFUCConciliacionC.setFont(new Font("Arial", 1, 12));
        this.JMIFUCConciliacionC.setText("Conciliación");
        this.JMIFUCConciliacionC.addActionListener(new ActionListener() { // from class: Acceso.Menus.472
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFUCConciliacionCActionPerformed(evt);
            }
        });
        this.JMIUtilidadesCart.add(this.JMIFUCConciliacionC);
        this.JIMUtilidadesC.add(this.JMIUtilidadesCart);
        this.JMIUtilidadesCart.setVisible(false);
        this.JMIUDiagnostico.setText("Diagnóstico");
        this.JMIUDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JMIUDigitacionDx.setFont(new Font("Arial", 1, 12));
        this.JMIUDigitacionDx.setText("Digitación Manual");
        this.JMIUDigitacionDx.addActionListener(new ActionListener() { // from class: Acceso.Menus.473
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDigitacionDxActionPerformed(evt);
            }
        });
        this.JMIUDiagnostico.add(this.JMIUDigitacionDx);
        this.JMIUDxMasivo.setFont(new Font("Arial", 1, 12));
        this.JMIUDxMasivo.setText("Digitar por Grupos");
        this.JMIUDxMasivo.addActionListener(new ActionListener() { // from class: Acceso.Menus.474
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUDxMasivoActionPerformed(evt);
            }
        });
        this.JMIUDiagnostico.add(this.JMIUDxMasivo);
        this.JMIUImportarDxRips.setFont(new Font("Arial", 1, 12));
        this.JMIUImportarDxRips.setText("Importar de Historía Cliníca");
        this.JMIUImportarDxRips.setActionCommand("Importar de la Historia");
        this.JMIUImportarDxRips.addActionListener(new ActionListener() { // from class: Acceso.Menus.475
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUImportarDxRipsActionPerformed(evt);
            }
        });
        this.JMIUDiagnostico.add(this.JMIUImportarDxRips);
        this.JIMUtilidadesC.add(this.JMIUDiagnostico);
        this.JMIURips.setText("Generar Archivos Planos");
        this.JMIURips.setActionCommand("Generar");
        this.JMIURips.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerar.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerar.setText("Rips");
        this.JMIURGenerar.addActionListener(new ActionListener() { // from class: Acceso.Menus.476
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURGenerarActionPerformed(evt);
            }
        });
        this.JMIURips.add(this.JMIURGenerar);
        this.JMIURGenerarRipsCovid.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerarRipsCovid.setText("Rips Covid");
        this.JMIURGenerarRipsCovid.addActionListener(new ActionListener() { // from class: Acceso.Menus.477
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURGenerarRipsCovidActionPerformed(evt);
            }
        });
        this.JMIURips.add(this.JMIURGenerarRipsCovid);
        this.JMIURGenerarRipsExtranjeros.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerarRipsExtranjeros.setText("Rips Extranjeros");
        this.JMIURGenerarRipsExtranjeros.addActionListener(new ActionListener() { // from class: Acceso.Menus.478
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURGenerarRipsExtranjerosActionPerformed(evt);
            }
        });
        this.JMIURips.add(this.JMIURGenerarRipsExtranjeros);
        this.JMIURGenerar1.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerar1.setText("FutRips/FurTran");
        this.JMIURGenerar1.addActionListener(new ActionListener() { // from class: Acceso.Menus.479
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURGenerar1ActionPerformed(evt);
            }
        });
        this.JMIURips.add(this.JMIURGenerar1);
        this.JMIURGenerar2.setFont(new Font("Arial", 1, 12));
        this.JMIURGenerar2.setText("FutRips/FurTran V2023");
        this.JMIURGenerar2.addActionListener(new ActionListener() { // from class: Acceso.Menus.480
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIURGenerar2ActionPerformed(evt);
            }
        });
        this.JMIURips.add(this.JMIURGenerar2);
        this.JIMUtilidadesC.add(this.JMIURips);
        this.JMIUtilidadesFac1.setText("Utilidades");
        this.JMIUtilidadesFac1.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG1.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG1.setText("Cambiar Grupo Factura y/o Imprimir");
        this.JMUNCambiarG1.addActionListener(new ActionListener() { // from class: Acceso.Menus.481
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCambiarG1ActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMUNCambiarG1);
        this.JMIFExportarExcelPDF.setFont(new Font("Arial", 1, 12));
        this.JMIFExportarExcelPDF.setText("Exportar Excel - PDF(Facturas)");
        this.JMIFExportarExcelPDF.addActionListener(new ActionListener() { // from class: Acceso.Menus.482
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFExportarExcelPDFActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMIFExportarExcelPDF);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JMIFReorganizacionF1.setVisible(true);
        } else {
            this.JMIFReorganizacionF1.setVisible(false);
        }
        this.JMIFListFacturas1.setFont(new Font("Arial", 1, 12));
        this.JMIFListFacturas1.setText("Listado de Facturas x Empresa");
        this.JMIFListFacturas1.addActionListener(new ActionListener() { // from class: Acceso.Menus.483
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFListFacturas1ActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMIFListFacturas1);
        this.JMIFListFacturasArm1.setFont(new Font("Arial", 1, 12));
        this.JMIFListFacturasArm1.setText("Listado de Facturas Armadas x Empresa");
        this.JMIFListFacturasArm1.addActionListener(new ActionListener() { // from class: Acceso.Menus.484
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFListFacturasArm1ActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMIFListFacturasArm1);
        this.JMIFReorganizacionF1.setFont(new Font("Arial", 1, 12));
        this.JMIFReorganizacionF1.setText("Reliquidación de Orden o Factura");
        this.JMIFReorganizacionF1.addActionListener(new ActionListener() { // from class: Acceso.Menus.485
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFReorganizacionF1ActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMIFReorganizacionF1);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JMIFReorganizacionF1.setVisible(true);
        } else {
            this.JMIFReorganizacionF1.setVisible(false);
        }
        this.JMIFReorganizacionF2.setFont(new Font("Arial", 1, 12));
        this.JMIFReorganizacionF2.setText("Reliquidación de Orden Por Convenio");
        this.JMIFReorganizacionF2.addActionListener(new ActionListener() { // from class: Acceso.Menus.486
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIFReorganizacionF2ActionPerformed(evt);
            }
        });
        this.JMIUtilidadesFac1.add(this.JMIFReorganizacionF2);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JMIFReorganizacionF1.setVisible(true);
        } else {
            this.JMIFReorganizacionF1.setVisible(false);
        }
        this.JIMUtilidadesC.add(this.JMIUtilidadesFac1);
        this.JMUNCambiarG3.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG3.setText("Transmisión de factura electrónica");
        this.JMUNCambiarG3.addActionListener(new ActionListener() { // from class: Acceso.Menus.487
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCambiarG3ActionPerformed(evt);
            }
        });
        this.JIMUtilidadesC.add(this.JMUNCambiarG3);
        this.JMUNCambiarG4.setFont(new Font("Arial", 1, 12));
        this.JMUNCambiarG4.setText("Gestion Factura Nota electrónica");
        this.JMUNCambiarG4.addActionListener(new ActionListener() { // from class: Acceso.Menus.488
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMUNCambiarG4ActionPerformed(evt);
            }
        });
        this.JIMUtilidadesC.add(this.JMUNCambiarG4);
        barraMnuGCuentas.add(this.JIMUtilidadesC);
        this.JIMIPrincipalCp.setText("Gestión de Compras");
        this.JIMIPrincipalCp.setFont(new Font("Arial", 1, 12));
        this.JMBienes.setText("Bienes");
        this.JMBienes.setFont(new Font("Arial", 1, 12));
        this.JMCConsultarEstado.setFont(new Font("Arial", 1, 12));
        this.JMCConsultarEstado.setText("Consultar Estado");
        this.JMCConsultarEstado.setToolTipText("");
        this.JMCConsultarEstado.addActionListener(new ActionListener() { // from class: Acceso.Menus.489
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCConsultarEstadoActionPerformed(evt);
            }
        });
        this.JMBienes.add(this.JMCConsultarEstado);
        this.JMCSolicitud.setFont(new Font("Arial", 1, 12));
        this.JMCSolicitud.setText("Solicitud");
        this.JMCSolicitud.setToolTipText("");
        this.JMCSolicitud.addActionListener(new ActionListener() { // from class: Acceso.Menus.490
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCSolicitudActionPerformed(evt);
            }
        });
        this.JMBienes.add(this.JMCSolicitud);
        this.JIMIPrincipalCp.add(this.JMBienes);
        this.JMRequisicion.setText("Requisiciones");
        this.JMRequisicion.setFont(new Font("Arial", 1, 12));
        this.JMCEvaluada.setFont(new Font("Arial", 1, 12));
        this.JMCEvaluada.setText("Evaluación");
        this.JMCEvaluada.setToolTipText("");
        this.JMCEvaluada.addActionListener(new ActionListener() { // from class: Acceso.Menus.491
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCEvaluadaActionPerformed(evt);
            }
        });
        this.JMRequisicion.add(this.JMCEvaluada);
        this.f0JMCCotizacin.setFont(new Font("Arial", 1, 12));
        this.f0JMCCotizacin.setText("Registro de Cotizaciones");
        this.f0JMCCotizacin.setToolTipText("");
        this.f0JMCCotizacin.addActionListener(new ActionListener() { // from class: Acceso.Menus.492
            public void actionPerformed(ActionEvent evt) {
                Menus.this.m0JMCCotizacinActionPerformed(evt);
            }
        });
        this.JMRequisicion.add(this.f0JMCCotizacin);
        this.JIMIPrincipalCp.add(this.JMRequisicion);
        this.mnuComprasS.setText("Servicios");
        this.mnuComprasS.setFont(new Font("Arial", 1, 12));
        this.JMCConsultarEstadoS.setFont(new Font("Arial", 1, 12));
        this.JMCConsultarEstadoS.setText("Consultar Estado");
        this.JMCConsultarEstadoS.setToolTipText("");
        this.JMCConsultarEstadoS.addActionListener(new ActionListener() { // from class: Acceso.Menus.493
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCConsultarEstadoSActionPerformed(evt);
            }
        });
        this.mnuComprasS.add(this.JMCConsultarEstadoS);
        this.JMCSolicitudS.setFont(new Font("Arial", 1, 12));
        this.JMCSolicitudS.setText("Solicitud");
        this.JMCSolicitudS.setToolTipText("");
        this.JMCSolicitudS.addActionListener(new ActionListener() { // from class: Acceso.Menus.494
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCSolicitudSActionPerformed(evt);
            }
        });
        this.mnuComprasS.add(this.JMCSolicitudS);
        this.JIMIPrincipalCp.add(this.mnuComprasS);
        this.JMContratos.setText("Contratos");
        this.JMContratos.setFont(new Font("Arial", 1, 12));
        this.JMCSolicitudC.setFont(new Font("Arial", 1, 12));
        this.JMCSolicitudC.setText("Registro");
        this.JMCSolicitudC.addActionListener(new ActionListener() { // from class: Acceso.Menus.495
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCSolicitudCActionPerformed(evt);
            }
        });
        this.JMContratos.add(this.JMCSolicitudC);
        this.JIMIPrincipalCp.add(this.JMContratos);
        barraMnuCompras.add(this.JIMIPrincipalCp);
        this.JIMIInformesCp.setText("Informes");
        this.JIMIInformesCp.setFont(new Font("Arial", 1, 12));
        this.JMIContratos.setText("Contratos");
        this.JMIContratos.setFont(new Font("Arial", 1, 12));
        this.JMCConsolidadoContrato.setFont(new Font("Arial", 1, 12));
        this.JMCConsolidadoContrato.setText("Consolidado");
        this.JMCConsolidadoContrato.addActionListener(new ActionListener() { // from class: Acceso.Menus.496
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCConsolidadoContratoActionPerformed(evt);
            }
        });
        this.JMIContratos.add(this.JMCConsolidadoContrato);
        this.JMCInformeCGR.setFont(new Font("Arial", 1, 12));
        this.JMCInformeCGR.setText("Informe CGR");
        this.JMCInformeCGR.addActionListener(new ActionListener() { // from class: Acceso.Menus.497
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCInformeCGRActionPerformed(evt);
            }
        });
        this.JMIContratos.add(this.JMCInformeCGR);
        this.JIMIInformesCp.add(this.JMIContratos);
        this.JMCInformeGenerales.setFont(new Font("Arial", 1, 12));
        this.JMCInformeGenerales.setText("Informes Generales");
        this.JMCInformeGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.498
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMCInformeGeneralesActionPerformed(evt);
            }
        });
        this.JIMIInformesCp.add(this.JMCInformeGenerales);
        barraMnuCompras.add(this.JIMIInformesCp);
        this.JMOdontAtencion.setText("Odontología");
        this.JMOdontAtencion.setFont(new Font("Arial", 1, 12));
        this.JMIOdontoAgenda.setFont(new Font("Arial", 1, 12));
        this.JMIOdontoAgenda.setText("Agenda");
        this.JMIOdontoAgenda.addActionListener(new ActionListener() { // from class: Acceso.Menus.499
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIOdontoAgendaActionPerformed(evt);
            }
        });
        this.JMOdontAtencion.add(this.JMIOdontoAgenda);
        this.JMIConsultarADx1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarADx1.setText("Consultar Ayudas Dx");
        this.JMIConsultarADx1.addActionListener(new ActionListener() { // from class: Acceso.Menus.500
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarADx1ActionPerformed(evt);
            }
        });
        this.JMOdontAtencion.add(this.JMIConsultarADx1);
        this.JMIConsultarHc1.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarHc1.setText("Consultar Historial");
        this.JMIConsultarHc1.addActionListener(new ActionListener() { // from class: Acceso.Menus.501
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIConsultarHc1ActionPerformed(evt);
            }
        });
        this.JMOdontAtencion.add(this.JMIConsultarHc1);
        JMBOdontologia.add(this.JMOdontAtencion);
        this.JMOdntoUtilidades.setText("Informes");
        this.JMOdntoUtilidades.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformesGenericos1.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformesGenericos1.setText("Informes Generales");
        this.JMIPSoInformesGenericos1.addActionListener(new ActionListener() { // from class: Acceso.Menus.502
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInformesGenericos1ActionPerformed(evt);
            }
        });
        this.JMOdntoUtilidades.add(this.JMIPSoInformesGenericos1);
        JMBOdontologia.add(this.JMOdntoUtilidades);
        this.JMAyuda5.setText("Ayuda");
        this.JMAyuda5.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade4.setFont(new Font("Arial", 1, 12));
        this.JMIAAcercade4.setText("Acerca de ...");
        this.JMIAAcercade4.addActionListener(new ActionListener() { // from class: Acceso.Menus.503
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAAcercade4ActionPerformed(evt);
            }
        });
        this.JMAyuda5.add(this.JMIAAcercade4);
        JMBOdontologia.add(this.JMAyuda5);
        JMBAdministracionNomina.setFont(new Font("Arial", 1, 12));
        this.JMIPANReporte.setText("Reporte");
        this.JMIPANReporte.setFont(new Font("Arial", 1, 12));
        this.JMIANRReporteHExtras.setFont(new Font("Arial", 1, 12));
        this.JMIANRReporteHExtras.setText("Horas Extras");
        this.JMIANRReporteHExtras.addActionListener(new ActionListener() { // from class: Acceso.Menus.504
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIANRReporteHExtrasActionPerformed(evt);
            }
        });
        this.JMIPANReporte.add(this.JMIANRReporteHExtras);
        this.JMIAInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMIAInformesGenerales.setText("Informes Generales");
        this.JMIAInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.505
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAInformesGeneralesActionPerformed(evt);
            }
        });
        this.JMIPANReporte.add(this.JMIAInformesGenerales);
        JMBAdministracionNomina.add(this.JMIPANReporte);
        JMBInformesV.setFont(new Font("Arial", 1, 12));
        this.JMIInformes.setText("Reporte");
        this.JMIInformes.setFont(new Font("Arial", 1, 12));
        this.JMIIRiesgoC.setFont(new Font("Arial", 1, 12));
        this.JMIIRiesgoC.setText("Consolidado de Riesgo");
        this.JMIIRiesgoC.addActionListener(new ActionListener() { // from class: Acceso.Menus.506
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIRiesgoCActionPerformed(evt);
            }
        });
        this.JMIInformes.add(this.JMIIRiesgoC);
        this.JMIIInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMIIInformesGenerales.setText("Informes Generales");
        this.JMIIInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.507
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIIInformesGeneralesActionPerformed(evt);
            }
        });
        this.JMIInformes.add(this.JMIIInformesGenerales);
        JMBInformesV.add(this.JMIInformes);
        this.JMSoPrincipal.setText("Atención");
        this.JMSoPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Agenda.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Agenda.setText("Agenda");
        this.JMIPSo_Agenda.addActionListener(new ActionListener() { // from class: Acceso.Menus.508
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSo_AgendaActionPerformed(evt);
            }
        });
        this.JMSoPrincipal.add(this.JMIPSo_Agenda);
        this.JMIPSo_Alcohol_Drogra.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Alcohol_Drogra.setText("Prueba de AyD");
        this.JMIPSo_Alcohol_Drogra.addActionListener(new ActionListener() { // from class: Acceso.Menus.509
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSo_Alcohol_DrograActionPerformed(evt);
            }
        });
        this.JMSoPrincipal.add(this.JMIPSo_Alcohol_Drogra);
        this.JMIPSo_Test_Fatiga.setFont(new Font("Arial", 1, 12));
        this.JMIPSo_Test_Fatiga.setText("Escala de Calidad y Cantidad de Sueño");
        this.JMIPSo_Test_Fatiga.addActionListener(new ActionListener() { // from class: Acceso.Menus.510
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSo_Test_FatigaActionPerformed(evt);
            }
        });
        this.JMSoPrincipal.add(this.JMIPSo_Test_Fatiga);
        this.JMUPeriodicos.setText("Gestión de Exámenes Periódicos");
        this.JMUPeriodicos.setFont(new Font("Arial", 1, 12));
        this.JMIUCargarDatos.setFont(new Font("Arial", 1, 12));
        this.JMIUCargarDatos.setText("Cargue Población Objeto");
        this.JMIUCargarDatos.addActionListener(new ActionListener() { // from class: Acceso.Menus.511
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCargarDatosActionPerformed(evt);
            }
        });
        this.JMUPeriodicos.add(this.JMIUCargarDatos);
        this.JMIUCPeriodicos.setFont(new Font("Arial", 1, 12));
        this.JMIUCPeriodicos.setText("Clasificación FR");
        this.JMIUCPeriodicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.512
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUCPeriodicosActionPerformed(evt);
            }
        });
        this.JMUPeriodicos.add(this.JMIUCPeriodicos);
        this.JMIUGPeriodicos.setFont(new Font("Arial", 1, 12));
        this.JMIUGPeriodicos.setText("Gestión de Periódicos");
        this.JMIUGPeriodicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.513
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGPeriodicosActionPerformed(evt);
            }
        });
        this.JMUPeriodicos.add(this.JMIUGPeriodicos);
        this.JMIUGSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JMIUGSeguimiento.setText("Seguimiento");
        this.JMIUGSeguimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.514
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUGSeguimientoActionPerformed(evt);
            }
        });
        this.JMUPeriodicos.add(this.JMIUGSeguimiento);
        this.JMSoPrincipal.add(this.JMUPeriodicos);
        JMBSo.add(this.JMSoPrincipal);
        this.JMSoInformes.setText("Informes");
        this.JMSoInformes.setFont(new Font("Arial", 1, 12));
        this.JMIPSoAutoReportes.setFont(new Font("Arial", 1, 12));
        this.JMIPSoAutoReportes.setText("AutoReportes");
        this.JMIPSoAutoReportes.addActionListener(new ActionListener() { // from class: Acceso.Menus.515
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoAutoReportesActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoAutoReportes);
        this.JMIPSoInfAyD.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInfAyD.setText("AyD por Fecha");
        this.JMIPSoInfAyD.addActionListener(new ActionListener() { // from class: Acceso.Menus.516
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInfAyDActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoInfAyD);
        this.JMIPSoCSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JMIPSoCSeguimiento.setText("Consolidado de Seguimientos");
        this.JMIPSoCSeguimiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.517
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoCSeguimientoActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoCSeguimiento);
        this.JMIPSoAtenciones.setFont(new Font("Arial", 1, 12));
        this.JMIPSoAtenciones.setText("Consulta Atenciones");
        this.JMIPSoAtenciones.addActionListener(new ActionListener() { // from class: Acceso.Menus.518
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoAtencionesActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoAtenciones);
        this.JMIPSoExaPerioSeguimientoDetalles.setFont(new Font("Arial", 1, 12));
        this.JMIPSoExaPerioSeguimientoDetalles.setText("Examenes periodicos seguimiento detalles");
        this.JMIPSoExaPerioSeguimientoDetalles.addActionListener(new ActionListener() { // from class: Acceso.Menus.519
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoExaPerioSeguimientoDetallesActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoExaPerioSeguimientoDetalles);
        this.JMIPSoFramingham.setFont(new Font("Arial", 1, 12));
        this.JMIPSoFramingham.setText("Framingham");
        this.JMIPSoFramingham.addActionListener(new ActionListener() { // from class: Acceso.Menus.520
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoFraminghamActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoFramingham);
        this.JMIPSoRiesgoCV.setFont(new Font("Arial", 1, 12));
        this.JMIPSoRiesgoCV.setText("Información Riesgo Cardiovascular");
        this.JMIPSoRiesgoCV.addActionListener(new ActionListener() { // from class: Acceso.Menus.521
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoRiesgoCVActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoRiesgoCV);
        this.JMIPSoInformeCIS20.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformeCIS20.setText("Informe CIS20");
        this.JMIPSoInformeCIS20.addActionListener(new ActionListener() { // from class: Acceso.Menus.522
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInformeCIS20ActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoInformeCIS20);
        this.JMIPSoInformeDiagnosticoSalud.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformeDiagnosticoSalud.setText("Informe de Diagnosticos de Salud");
        this.JMIPSoInformeDiagnosticoSalud.addActionListener(new ActionListener() { // from class: Acceso.Menus.523
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInformeDiagnosticoSaludActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoInformeDiagnosticoSalud);
        this.JMIPSoInformesGenericos.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformesGenericos.setText("Informes Generales");
        this.JMIPSoInformesGenericos.addActionListener(new ActionListener() { // from class: Acceso.Menus.524
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInformesGenericosActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoInformesGenericos);
        this.JMIPSoEstudiosRadiologicos.setFont(new Font("Arial", 1, 12));
        this.JMIPSoEstudiosRadiologicos.setText("Interpretaciones Estudios Radiológicos");
        this.JMIPSoEstudiosRadiologicos.setToolTipText("");
        this.JMIPSoEstudiosRadiologicos.addActionListener(new ActionListener() { // from class: Acceso.Menus.525
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoEstudiosRadiologicosActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoEstudiosRadiologicos);
        this.JMIPSoInformesSistemaVigilancia.setFont(new Font("Arial", 1, 12));
        this.JMIPSoInformesSistemaVigilancia.setText("Informes Sistema Vigilancia");
        this.JMIPSoInformesSistemaVigilancia.addActionListener(new ActionListener() { // from class: Acceso.Menus.526
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoInformesSistemaVigilanciaActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoInformesSistemaVigilancia);
        this.JMIPSoReporteAudiometria.setFont(new Font("Arial", 1, 12));
        this.JMIPSoReporteAudiometria.setText("Reporte Audiometría");
        this.JMIPSoReporteAudiometria.addActionListener(new ActionListener() { // from class: Acceso.Menus.527
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoReporteAudiometriaActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoReporteAudiometria);
        this.JMIPSoReporteEspirometria1.setFont(new Font("Arial", 1, 12));
        this.JMIPSoReporteEspirometria1.setText("Reporte Espirometría");
        this.JMIPSoReporteEspirometria1.addActionListener(new ActionListener() { // from class: Acceso.Menus.528
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoReporteEspirometria1ActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoReporteEspirometria1);
        this.JMIPSoReporteEspirometria.setFont(new Font("Arial", 1, 12));
        this.JMIPSoReporteEspirometria.setText("Reporte Espirometría G");
        this.JMIPSoReporteEspirometria.addActionListener(new ActionListener() { // from class: Acceso.Menus.529
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoReporteEspirometriaActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoReporteEspirometria);
        this.JMIPSoReporteNOMA.setFont(new Font("Arial", 1, 12));
        this.JMIPSoReporteNOMA.setText("Reporte NOMA");
        this.JMIPSoReporteNOMA.addActionListener(new ActionListener() { // from class: Acceso.Menus.530
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoReporteNOMAActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoReporteNOMA);
        this.JMIPSoReporteVisiometria.setFont(new Font("Arial", 1, 12));
        this.JMIPSoReporteVisiometria.setText("Reporte Visiometria");
        this.JMIPSoReporteVisiometria.addActionListener(new ActionListener() { // from class: Acceso.Menus.531
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoReporteVisiometriaActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoReporteVisiometria);
        this.JMIPSoTFatiga.setFont(new Font("Arial", 1, 12));
        this.JMIPSoTFatiga.setText("Test de Fatiga por Fecha");
        this.JMIPSoTFatiga.addActionListener(new ActionListener() { // from class: Acceso.Menus.532
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoTFatigaActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoTFatiga);
        this.JMIPSoTRuffier.setFont(new Font("Arial", 1, 12));
        this.JMIPSoTRuffier.setText("Test de Ruffier");
        this.JMIPSoTRuffier.addActionListener(new ActionListener() { // from class: Acceso.Menus.533
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIPSoTRuffierActionPerformed(evt);
            }
        });
        this.JMSoInformes.add(this.JMIPSoTRuffier);
        JMBSo.add(this.JMSoInformes);
        this.JMSoUtilidades.setText("Utilidades");
        this.JMSoUtilidades.setFont(new Font("Arial", 1, 12));
        this.JMITipoSeg.setFont(new Font("Arial", 1, 12));
        this.JMITipoSeg.setText("Tipo SEG");
        this.JMITipoSeg.addActionListener(new ActionListener() { // from class: Acceso.Menus.534
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMITipoSegActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMITipoSeg);
        this.JMITipoAgente.setFont(new Font("Arial", 1, 12));
        this.JMITipoAgente.setText("Tipo Agente");
        this.JMITipoAgente.addActionListener(new ActionListener() { // from class: Acceso.Menus.535
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMITipoAgenteActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMITipoAgente);
        this.JMIUSegProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JMIUSegProcedimientos.setText("SEG Procedimientos");
        this.JMIUSegProcedimientos.addActionListener(new ActionListener() { // from class: Acceso.Menus.536
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUSegProcedimientosActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMIUSegProcedimientos);
        this.JMIUSegAgente.setFont(new Font("Arial", 1, 12));
        this.JMIUSegAgente.setText("SEG x Agente");
        this.JMIUSegAgente.addActionListener(new ActionListener() { // from class: Acceso.Menus.537
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIUSegAgenteActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMIUSegAgente);
        this.JMITSegValor.setFont(new Font("Arial", 1, 12));
        this.JMITSegValor.setText("Registro Valores x SEG");
        this.JMITSegValor.addActionListener(new ActionListener() { // from class: Acceso.Menus.538
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMITSegValorActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMITSegValor);
        this.JMITipoSistemaVigilancia.setFont(new Font("Arial", 1, 12));
        this.JMITipoSistemaVigilancia.setText("Tipo Sistema de Vigilancia");
        this.JMITipoSistemaVigilancia.addActionListener(new ActionListener() { // from class: Acceso.Menus.539
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMITipoSistemaVigilanciaActionPerformed(evt);
            }
        });
        this.JMSoUtilidades.add(this.JMITipoSistemaVigilancia);
        JMBSo.add(this.JMSoUtilidades);
        this.JMSoAutorizaciones.setText("Autorizaciones");
        this.JMSoAutorizaciones.setFont(new Font("Arial", 1, 12));
        this.JMIDeclaracionAntecedentes.setFont(new Font("Arial", 1, 12));
        this.JMIDeclaracionAntecedentes.setText("Declaración de antecedentes");
        this.JMIDeclaracionAntecedentes.addActionListener(new ActionListener() { // from class: Acceso.Menus.540
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDeclaracionAntecedentesActionPerformed(evt);
            }
        });
        this.JMSoAutorizaciones.add(this.JMIDeclaracionAntecedentes);
        JMBSo.add(this.JMSoAutorizaciones);
        this.JMGAPrincipal.setMnemonic('P');
        this.JMGAPrincipal.setText("Gestión de Activos");
        this.JMGAPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMIGAActivos.setFont(new Font("Arial", 1, 12));
        this.JMIGAActivos.setText("Activos");
        this.JMIGAActivos.addActionListener(new ActionListener() { // from class: Acceso.Menus.541
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGAActivosActionPerformed(evt);
            }
        });
        this.JMGAPrincipal.add(this.JMIGAActivos);
        barraMnuGestionActivo.add(this.JMGAPrincipal);
        this.JMGAInformes.setMnemonic('P');
        this.JMGAInformes.setText("Informes");
        this.JMGAInformes.setFont(new Font("Arial", 1, 12));
        this.JMIGAInformeActivos.setFont(new Font("Arial", 1, 12));
        this.JMIGAInformeActivos.setText("Informe de Activos");
        this.JMIGAInformeActivos.addActionListener(new ActionListener() { // from class: Acceso.Menus.542
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGAInformeActivosActionPerformed(evt);
            }
        });
        this.JMGAInformes.add(this.JMIGAInformeActivos);
        this.JMIGInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMIGInformesGenerales.setText("Informes Generales");
        this.JMIGInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.543
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIGInformesGeneralesActionPerformed(evt);
            }
        });
        this.JMGAInformes.add(this.JMIGInformesGenerales);
        barraMnuGestionActivo.add(this.JMGAInformes);
        this.JMCxPrincipal.setMnemonic('P');
        this.JMCxPrincipal.setText("Cirugía");
        this.JMCxPrincipal.setFont(new Font("Arial", 1, 12));
        JMIP_AgendaN.setFont(new Font("Arial", 1, 12));
        JMIP_AgendaN.setText("Agenda");
        JMIP_AgendaN.addActionListener(new ActionListener() { // from class: Acceso.Menus.544
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_AgendaNActionPerformed(evt);
            }
        });
        this.JMCxPrincipal.add(JMIP_AgendaN);
        this.JMIP_CxProgramacion.setFont(new Font("Arial", 1, 12));
        this.JMIP_CxProgramacion.setText("Programación");
        this.JMIP_CxProgramacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.545
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_CxProgramacionActionPerformed(evt);
            }
        });
        this.JMCxPrincipal.add(this.JMIP_CxProgramacion);
        barraMnuCirugia.add(this.JMCxPrincipal);
        this.JMCxInformes.setMnemonic('P');
        this.JMCxInformes.setText("Informes");
        this.JMCxInformes.setFont(new Font("Arial", 1, 12));
        this.JMIP_IProgramacion.setFont(new Font("Arial", 1, 12));
        this.JMIP_IProgramacion.setText("Programación");
        this.JMIP_IProgramacion.addActionListener(new ActionListener() { // from class: Acceso.Menus.546
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_IProgramacionActionPerformed(evt);
            }
        });
        this.JMCxInformes.add(this.JMIP_IProgramacion);
        this.JMIP_InformeCirugia.setText("Informe Cirugia");
        this.JMIP_InformeCirugia.setToolTipText("");
        this.JMIP_InformeCirugia.addActionListener(new ActionListener() { // from class: Acceso.Menus.547
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_InformeCirugiaActionPerformed(evt);
            }
        });
        this.JMCxInformes.add(this.JMIP_InformeCirugia);
        this.JMIP_InformesGenerales.setText("Informes Generales");
        this.JMIP_InformesGenerales.setToolTipText("");
        this.JMIP_InformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.548
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIP_InformesGeneralesActionPerformed(evt);
            }
        });
        this.JMCxInformes.add(this.JMIP_InformesGenerales);
        barraMnuCirugia.add(this.JMCxInformes);
        this.JMCxPrincipal1.setMnemonic('P');
        this.JMCxPrincipal1.setText("Presupuesto");
        this.JMCxPrincipal1.setFont(new Font("Arial", 1, 12));
        this.JMGastos.setText("Gastos");
        this.JMGastos.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad.setText("1. Disponibilidad");
        this.JMIDisponibilidad.setToolTipText("");
        this.JMIDisponibilidad.addActionListener(new ActionListener() { // from class: Acceso.Menus.549
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDisponibilidadActionPerformed(evt);
            }
        });
        this.JMGastos.add(this.JMIDisponibilidad);
        this.JMIDisponibilidad1.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad1.setText("1. Disponibilidad(Nuevo Beta)");
        this.JMIDisponibilidad1.setToolTipText("");
        this.JMIDisponibilidad1.addActionListener(new ActionListener() { // from class: Acceso.Menus.550
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDisponibilidad1ActionPerformed(evt);
            }
        });
        this.JMGastos.add(this.JMIDisponibilidad1);
        this.JMICompromisoPTO.setFont(new Font("Arial", 1, 12));
        this.JMICompromisoPTO.setText("Compromiso");
        this.JMICompromisoPTO.setToolTipText("");
        this.JMICompromisoPTO.addActionListener(new ActionListener() { // from class: Acceso.Menus.551
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICompromisoPTOActionPerformed(evt);
            }
        });
        this.JMGastos.add(this.JMICompromisoPTO);
        this.JMICompromisoBeta.setFont(new Font("Arial", 1, 12));
        this.JMICompromisoBeta.setText("Compromiso(Nuevo Beta)");
        this.JMICompromisoBeta.setToolTipText("");
        this.JMICompromisoBeta.addActionListener(new ActionListener() { // from class: Acceso.Menus.552
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICompromisoBetaActionPerformed(evt);
            }
        });
        this.JMGastos.add(this.JMICompromisoBeta);
        this.JMCxPrincipal1.add(this.JMGastos);
        this.JMIngresos.setText("Ingresos");
        this.JMIngresos.setFont(new Font("Arial", 1, 12));
        this.JMIngresos.addActionListener(new ActionListener() { // from class: Acceso.Menus.553
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIngresosActionPerformed(evt);
            }
        });
        this.JMIManualesIng.setFont(new Font("Arial", 1, 12));
        this.JMIManualesIng.setText("Manuales");
        this.JMIManualesIng.setToolTipText("");
        this.JMIManualesIng.addActionListener(new ActionListener() { // from class: Acceso.Menus.554
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIManualesIngActionPerformed(evt);
            }
        });
        this.JMIngresos.add(this.JMIManualesIng);
        this.JMCxPrincipal1.add(this.JMIngresos);
        this.JMMovManuales.setText("Movimientos Manuales");
        this.JMMovManuales.setFont(new Font("Arial", 1, 12));
        this.JMIMovManual.setFont(new Font("Arial", 1, 12));
        this.JMIMovManual.setText("Movimientos Manuales");
        this.JMIMovManual.setToolTipText("");
        this.JMIMovManual.addActionListener(new ActionListener() { // from class: Acceso.Menus.555
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIMovManualActionPerformed(evt);
            }
        });
        this.JMMovManuales.add(this.JMIMovManual);
        this.JMIOperacionesM1.setFont(new Font("Arial", 1, 12));
        this.JMIOperacionesM1.setText("Operaciones Manuales");
        this.JMIOperacionesM1.setToolTipText("");
        this.JMIOperacionesM1.addActionListener(new ActionListener() { // from class: Acceso.Menus.556
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIOperacionesM1ActionPerformed(evt);
            }
        });
        this.JMMovManuales.add(this.JMIOperacionesM1);
        this.JMCxPrincipal1.add(this.JMMovManuales);
        this.JMSolicitud.setText("Solicitud");
        this.JMSolicitud.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad2.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad2.setText("1.Solicitud");
        this.JMIDisponibilidad2.setToolTipText("");
        this.JMIDisponibilidad2.addActionListener(new ActionListener() { // from class: Acceso.Menus.557
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDisponibilidad2ActionPerformed(evt);
            }
        });
        this.JMSolicitud.add(this.JMIDisponibilidad2);
        this.JMIDisponibilidad3.setFont(new Font("Arial", 1, 12));
        this.JMIDisponibilidad3.setText("2. Solicitud (Nuevo Beta)");
        this.JMIDisponibilidad3.setToolTipText("");
        this.JMIDisponibilidad3.addActionListener(new ActionListener() { // from class: Acceso.Menus.558
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDisponibilidad3ActionPerformed(evt);
            }
        });
        this.JMSolicitud.add(this.JMIDisponibilidad3);
        this.JMCxPrincipal1.add(this.JMSolicitud);
        barraMnuPresupuesto.add(this.JMCxPrincipal1);
        this.JMCxInformes1.setMnemonic('P');
        this.JMCxInformes1.setText("Informes");
        this.JMCxInformes1.setFont(new Font("Arial", 1, 12));
        this.JMI_BusquedaMovPpt.setFont(new Font("Arial", 1, 12));
        this.JMI_BusquedaMovPpt.setText("Búsqueda de Documentos Presupuestales");
        this.JMI_BusquedaMovPpt.addActionListener(new ActionListener() { // from class: Acceso.Menus.559
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_BusquedaMovPptActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMI_BusquedaMovPpt);
        this.JMIDecreto2193.setFont(new Font("Arial", 1, 12));
        this.JMIDecreto2193.setText("Decreto 2193");
        this.JMIDecreto2193.addActionListener(new ActionListener() { // from class: Acceso.Menus.560
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIDecreto2193ActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMIDecreto2193);
        this.JMIEjecucionPtal.setFont(new Font("Arial", 1, 12));
        this.JMIEjecucionPtal.setText("Ejecución Presupuestal");
        this.JMIEjecucionPtal.addActionListener(new ActionListener() { // from class: Acceso.Menus.561
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEjecucionPtalActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMIEjecucionPtal);
        this.JMIEjecucionPtalPeriodo.setFont(new Font("Arial", 1, 12));
        this.JMIEjecucionPtalPeriodo.setText("Ejecución Presupuestal por Periodos");
        this.JMIEjecucionPtalPeriodo.addActionListener(new ActionListener() { // from class: Acceso.Menus.562
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIEjecucionPtalPeriodoActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMIEjecucionPtalPeriodo);
        this.JMIInformeCGR.setFont(new Font("Arial", 1, 12));
        this.JMIInformeCGR.setText("Informes CGR");
        this.JMIInformeCGR.addActionListener(new ActionListener() { // from class: Acceso.Menus.563
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIInformeCGRActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMIInformeCGR);
        this.JMICuentasxPagar.setFont(new Font("Arial", 1, 12));
        this.JMICuentasxPagar.setText("Informes Cuentas x Pagar");
        this.JMICuentasxPagar.addActionListener(new ActionListener() { // from class: Acceso.Menus.564
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICuentasxPagarActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMICuentasxPagar);
        this.JMILibroPresupuesto.setFont(new Font("Arial", 1, 12));
        this.JMILibroPresupuesto.setText("Libros Presupuestales");
        this.JMILibroPresupuesto.addActionListener(new ActionListener() { // from class: Acceso.Menus.565
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMILibroPresupuestoActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMILibroPresupuesto);
        this.JMILInformesGenerales.setFont(new Font("Arial", 1, 12));
        this.JMILInformesGenerales.setText("Informes Generales");
        this.JMILInformesGenerales.addActionListener(new ActionListener() { // from class: Acceso.Menus.566
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMILInformesGeneralesActionPerformed(evt);
            }
        });
        this.JMCxInformes1.add(this.JMILInformesGenerales);
        barraMnuPresupuesto.add(this.JMCxInformes1);
        this.JMUtilidadesPTO.setText("Utilidades");
        this.JMUtilidadesPTO.setFont(new Font("Arial", 1, 12));
        this.JMIAnulaDoc.setFont(new Font("Arial", 1, 12));
        this.JMIAnulaDoc.setText("Anular Documentos");
        this.JMIAnulaDoc.setToolTipText("");
        this.JMIAnulaDoc.addActionListener(new ActionListener() { // from class: Acceso.Menus.567
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMIAnulaDocActionPerformed(evt);
            }
        });
        this.JMUtilidadesPTO.add(this.JMIAnulaDoc);
        this.JMICargueInicial.setFont(new Font("Arial", 1, 12));
        this.JMICargueInicial.setText("Cargue Presupuesto Inicial");
        this.JMICargueInicial.setToolTipText("");
        this.JMICargueInicial.addActionListener(new ActionListener() { // from class: Acceso.Menus.568
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICargueInicialActionPerformed(evt);
            }
        });
        this.JMUtilidadesPTO.add(this.JMICargueInicial);
        this.JMISolicitudes.setFont(new Font("Arial", 1, 12));
        this.JMISolicitudes.setText("Solicitudes");
        this.JMISolicitudes.setToolTipText("");
        this.JMISolicitudes.addActionListener(new ActionListener() { // from class: Acceso.Menus.569
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMISolicitudesActionPerformed(evt);
            }
        });
        this.JMUtilidadesPTO.add(this.JMISolicitudes);
        barraMnuPresupuesto.add(this.JMUtilidadesPTO);
        this.mnuPrincipal.setText("Principal");
        this.mnuPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMI_HojaTratamiento.setFont(new Font("Arial", 1, 12));
        this.JMI_HojaTratamiento.setText("Impresión Hoja Tratamiento");
        this.JMI_HojaTratamiento.setToolTipText("");
        this.JMI_HojaTratamiento.addActionListener(new ActionListener() { // from class: Acceso.Menus.570
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMI_HojaTratamientoActionPerformed(evt);
            }
        });
        this.mnuPrincipal.add(this.JMI_HojaTratamiento);
        barraMnuTrancisionXenco.add(this.mnuPrincipal);
        this.mnuRPrincipal.setText("Referencia");
        this.mnuRPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMICPReferencia.setFont(new Font("Arial", 1, 12));
        this.JMICPReferencia.setText("Referencia");
        this.JMICPReferencia.setToolTipText("");
        this.JMICPReferencia.addActionListener(new ActionListener() { // from class: Acceso.Menus.571
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICPReferenciaActionPerformed(evt);
            }
        });
        this.mnuRPrincipal.add(this.JMICPReferencia);
        barraMnuReferencia.add(this.mnuRPrincipal);
        this.mnuRReporte.setText("Informes");
        this.mnuRReporte.setFont(new Font("Arial", 1, 12));
        this.JMICPRConsolidadoRemisiones.setFont(new Font("Arial", 1, 12));
        this.JMICPRConsolidadoRemisiones.setText("Consolidado de Referencia");
        this.JMICPRConsolidadoRemisiones.setToolTipText("");
        this.JMICPRConsolidadoRemisiones.addActionListener(new ActionListener() { // from class: Acceso.Menus.572
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICPRConsolidadoRemisionesActionPerformed(evt);
            }
        });
        this.mnuRReporte.add(this.JMICPRConsolidadoRemisiones);
        barraMnuReferencia.add(this.mnuRReporte);
        this.mnuSDPrincipal.setText("Soporte Digitalizado");
        this.mnuSDPrincipal.setFont(new Font("Arial", 1, 12));
        this.JMICPSoporteDigitalizado.setFont(new Font("Arial", 1, 12));
        this.JMICPSoporteDigitalizado.setText("Soportes Digitalizados");
        this.JMICPSoporteDigitalizado.setToolTipText("");
        this.JMICPSoporteDigitalizado.addActionListener(new ActionListener() { // from class: Acceso.Menus.573
            public void actionPerformed(ActionEvent evt) {
                Menus.this.JMICPSoporteDigitalizadoActionPerformed(evt);
            }
        });
        this.mnuSDPrincipal.add(this.JMICPSoporteDigitalizado);
        barraMnuSoportesDigitalizados.add(this.mnuSDPrincipal);
        this.jMenuItem11.setText("jMenuItem11");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGAM_AuditoriaAdministracionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla(this.JMIGAM_AuditoriaAdministracion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGAM_AuditoriaConcurrenteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla(this.JMIGAM_AuditoriaConcurrente.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGAM_AuditoriaFacturasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla(this.JMIGAM_AuditoriaFacturas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMII_InformeSeguimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla("InformeSeguimientoAM");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIU_CierresSeguimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla("Cierre de Seguimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAutorizaActionPerformed(ActionEvent evt) {
        this.xjp.frmAutoriza = new Autoriza();
        Principal principal = this.xjp;
        Principal.cargarPantalla(this.xjp.frmAutoriza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAutorizarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAcercadeActionPerformed(ActionEvent evt) {
        this.xjp.acercade();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCierreEgresoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Cierre");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCierreEgresoActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Cierre de Egresos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuConsolidadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Consolidado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAsignacionIngresoRecibosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Asinacion de Ingresos a Recibos de Caja");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRecibosEgresosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Recibos Egresos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRecibosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Recibos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_CReciboActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Consultar Recibos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAgendarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Agenda", "triage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAtencionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAmbulatorioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Facturac");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuFacturacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Facturación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFPFacturasPEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consolidado de Procedimientos Facturados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFInfOportunidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consulta de Oportunidad Urgencia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFInfhospitalizadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consulta de Usuarios Hospitalizados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFListaChequeoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.mImprimirListaChequeoSo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFPFacturasPE2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Listado de Facturas de Ventas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFPFacturasPE1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Listado de Ordenes Internas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformesAutorizacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("informeAutorizacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformesIngresoEventoSoatActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Ingresos con Evento SOAT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUGAGenerarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Generador de Autorizacion de Servicios");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroDiario3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Censo de Camas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUConsultarAtencionesNPGeneralActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Atenciones NP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUConsultarAtencionesNPHoraActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Atenciones NP Hora");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUCNotasCargoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla(this.JMUCNotasCargo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUConsultaOrdenesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Remisiones y Ordenes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDigitacionDx1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Digitación Manual");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCambiarGActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Cambiar Grupo Factura");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNReliquidacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMURegistroAtencionEspecialActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Registro Atencion Especial");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMURelacionExamenOActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Relacion Examen Ocupacional");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCardiovascularActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Cardiovascular");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNObstetricosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Obstetricos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUSAutorizacionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Solicitud Autorizaciones P");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICCierreActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Cierre de Caja");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void citaAtencion_EspecialActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Atención Especial");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void citaTerapiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla("CitasTerapia", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void citaNoProgramadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "CitasNP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void citaProgramadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Citas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void citasPCirugiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Programación Cirugia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auditoriaActionPerformed(ActionEvent evt) {
        ReporteCitas frmRepCita = new ReporteCitas(null, true, 4);
        frmRepCita.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sisAtendidasActionPerformed(ActionEvent evt) {
        ReporteCitas frmRepCita = new ReporteCitas(null, true, 6);
        frmRepCita.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sisAtendidasProfecionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Citas Atendidas Por Profesional");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sisNoAtendidasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Citas No Atendidas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICConsultar_TiempoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Consultar Tiempo Atención");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sisNoProgramadoActionPerformed(ActionEvent evt) {
        ReporteCitas frmRepCita = new ReporteCitas(null, true, 2);
        frmRepCita.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sisMedicoActionPerformed(ActionEvent evt) {
        ReporteCitas frmRepCita = new ReporteCitas(null, true, 1);
        frmRepCita.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAnularProgramacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIAnularProgramacion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAgendaEnfermeriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIConsultarAgendaEnfermeria.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarCitasUsuarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIConsultarCitasUsuario.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLogisticaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.mnuLogistica.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAlertaxUsuarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIAlertaxUsuario.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCitaUtilidadPasarProgActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "PasarTurnos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPasarCitasxLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIPasarCitasxLote.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCitaUtilidadProgramacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Programar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarRemOrdCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIConsultarRemOrdC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRDiasAsignacionCitaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Reorganizar Dias de Asignacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroExamenesAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIRegistroExamenesA.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroReembolsoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIRegistroReembolso.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUSolicitudDocClinicos1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, this.JMIUSolicitudDocClinicos1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvEntradasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Entradas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvDespachosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Despachos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvSalidasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Salidas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvTrasladosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Traslados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvFaltantesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Faltantes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMAgendaUnidosisActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Agenda_Unidosis");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMAgendaCirugiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Agenda_Cirugia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuGeneralxAreaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuProximosAVencerActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuGeneralxCategoriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuListadoBasicoMedicamentosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuListadoDispositivosMedicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRotacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMICRotacion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuGeneralxArea1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Inventario General");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRotacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("UltimaRotacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCLALasaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("ClaLASA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Entrada a Inventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem10ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consolidado de Entradas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfConsumoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.mnuInfConsumo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfCDespachoxMedicoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consolidado de Despacho x Medico");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfMovimientoIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.mnuInfMovimientoI.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfCMovimientoIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consolidado de Movimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfCPendientesGeneradosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.mnuInfCPendientesGenerados.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfCTiempoLLamadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.mnuInfCTiempoLLamada.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.1.1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.1.2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.1.3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem5ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.2.1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem8ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.2.1_1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem6ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.2.2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem7ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes3.2.3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem9ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes de Despacho");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfTrasladosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfSalidasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInfSomnolenciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc = new claseSgc();
        Principal principal2 = this.xjp;
        Principal.xclasesgc.cargarPantalla("Somnolencia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuConsolidadoSalidasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consolidado de Salidas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAuditoriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Auditorias Aleatorias");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvConsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("ConsultarExistencia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInvKardexActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Kardex");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIFormulacionMedicaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consultar Formulacion Medica en Linea");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIFormulasGeneradasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consultar Formulas Generadas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUMovimientoSActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIUMovimientoS.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUCCostosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Cierre de Costo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCFaltatesFechaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consultar Listado Productos Faltantes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGestionarFaltantesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIUGestionarFaltantes.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIActualizarPendientesActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de Actualizar los Pendientes a Cero?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            StringBuilder sbAppend = new StringBuilder().append(" UPDATE `i_suministroxlotexbodega`,`i_suministroxbodega`  SET `i_suministroxlotexbodega`.`CPendiente`=0 WHERE `i_suministroxlotexbodega`.id=`i_suministroxbodega`.`Id` AND `i_suministroxbodega`.`IdBodega`='");
            Principal principal = this.xjp;
            String sql = sbAppend.append(Principal.xClaseInventario.getIdBodega()).append("'AND `i_suministroxlotexbodega`.`CPendiente`<>0").toString();
            this.ConsultasMysql.ejecutarSQL(sql);
            this.ConsultasMysql.cerrarConexionBd();
            JOptionPane.showMessageDialog(this, "Actualización realizada correctamente", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIAdicionarProdcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIIAdicionarProdc.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAjustarPuntosSCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Ajustar Puntos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCDespachoxEspecialidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consultar Despacho x Especialidad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGestionarPreposicionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIUGestionarPreposicion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIKardexActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Kardex_I");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIKardex_PActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Kardex_P");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUModificarSolicitudActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIUModificarSolicitud.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIModificarMPMActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIIModificarMPM.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIModificarCodAgActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIIModificarCodAg.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIRepBodegasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMIIRepBodegas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUSuministroLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Suministro x Bodega x Lote");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCierreInvActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("CerrarInventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuConteo1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Conteo1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuConteo2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Conteo2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuCrearLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("CrearLote");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuImprimirInvActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("ImprimirInventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuModificarLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("ModificarLote");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuMonitoreoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Monitoreo Inventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPrepararInvActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("PrepararInventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMReporteIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMReporteI.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPeriodoContableIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Periodos Contables");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUTempBodegaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla(this.JMUTempBodega.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRegistroRecibosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICRegistroRecibos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICSolicitudRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICSolicitudR.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICDocumentoCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICDocumentoC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICGPagoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICGPago.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICGPago1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICGPago1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRadicacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICRadicacion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRadicacionNCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICRadicacionNC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICSeleccionCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Selección de Documento para Pago");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICCuentaCobroAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Generar Cuenta Cobro A");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICCuentaCobroMActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Generar Cuenta Cobro M");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRadicacionRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Radicación Reembolso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAAutorizacionDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIAAutorizacionDoc.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIBalanceContableActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Balance Contable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIBalanceContable1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Balance Contable por Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIBalanceContable2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Balance General");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeTipoImpuesto1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Consultar Cuentas Por Pagar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUConsultarDocTerceroActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUConsultarDocTercero.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICIEjecucionPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICIEjecucionP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDMediosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIDMedios.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDMedios1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIDMedios1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRConsolidadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICRConsolidado.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIAuditoriasAleatoriasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("xjifauditoriaaleatoria1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIConciliacionInvActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Conciliacion Inventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeDespachoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Consolidado de Movimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIKardexIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Kardex_I");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICLibroGeneralActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Libro Auxiliar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICLibroRangoCuentaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Libro Auxiliar por Rango Cuentas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICLibroTercerosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Libro Auxiliar por Terceros");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_LibroDiarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("MovimientoxRangoFecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIILibroMayorActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Libro Mayor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMovimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIMovimiento.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMovimiento_TerceroActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Movimientos por Tercero");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRelacionPagoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIRelacionPago.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeTipoImpuestoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Informe Tipo Impuesto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAjusteDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUAjusteDoc.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICGastoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICGasto.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCManualActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Certificado Manual");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCAutomaticoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Certificado Automatico");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCuentasGastosRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Cuentas Gastos Retención");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCImpuestoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("xjifcierrecontable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCuentasCGIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("xjifcierrecuentascgi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICExportarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICExportar.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGenerarDisfonActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUGenerarDisfon.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGestionActivosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegactivo = new claseGActivos(this.xjp);
        Principal principal2 = this.xjp;
        Principal.xclasegactivo.cargarPantalla("Activos Fijos1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCDepreciacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Depreciacion Activos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUIFacturasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUIFacturas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUModificacionDocCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Modificacion DocumentoC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUPeriodoCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUPeriodoC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUPeriodoFActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseparametrizacionn.cargarPantalla(this.JMIUPeriodoF.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUPlanCuentaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMIUPlanCuenta.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUIPCrearCuentaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Crear CPuc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURegistroFacActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Registro Facturas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGTActivarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Gestion Tercero");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAjusteDoc1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Anular Documentos Por Cuenta de Cobro");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRActividadesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Registro Actividades");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRActProfesionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("ProActividades");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRActUsuariosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Registro Actividades por Usuario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGestion_CACervixActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Toma");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGestion_ProcedimientosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("GestionProcedimientos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyPIngresoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Ingreso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyPEgresoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Egreso de Usuarios Del Programa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPHtaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Ingreso HTA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPDiabetesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Ingreso Diabetes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPGestionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Gestion Polimedicados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIR4505ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Registro individual 4505");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyPAgendaVacunacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("AgendaVacunacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyPVacunacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Vacunacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRCaCervixActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Informe de Citología");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuEnfAgendaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Agenda");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAtencionesEspActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.mnuAtencionesEsp.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuEnfAtencionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Atencion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPAgenda_UHActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMIPAgenda_UH.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuEnfAgenda1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Atencion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroDiario1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Censo de Camas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroDiarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMIRegistroDiario.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIESoInfAyDActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("AyD por Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIESoTFatigaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Test de Fatiga por Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAcronimos1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMIConsultarAcronimos1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRemOrdenesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Consultar Remisiones y Ordenes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMLReporteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMLReporte.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroNotasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMIRegistroNotas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSo_Alcohol_DrograEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Prueba AyD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSo_Test_FatigaEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Test Fatiga");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMAutorizacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMAutorizacion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAAcercadeActionPerformed(ActionEvent evt) {
        Acercade acercade = new Acercade(this.xjp, true);
        acercade.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaNActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("AgendaN", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarADxActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarADx.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarHcActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarHc.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAsignacionCNPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "CitasNP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAsignacion_AtencionEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIAsignacion_AtencionE.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICPermisoMedicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMICPermisoMedicos.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroDiario2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Censo de Camas", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAcronimosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarAcronimos.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarResultado.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoUsuarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Consultar Resultado de Exámenes por Usuario", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarOrdRemActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Consultar Remisiones y Ordenes", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUFormulasPyPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIUFormulasPyP.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConstanciaAsistenciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConstanciaAsistencia.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMHReporteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMHReporte.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroIncapacActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroIncapac.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroJuntaMedicaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroJuntaMedica.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroConsultaNPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroConsultaNP.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroNMedicasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroNMedicas.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroVDomiciliariasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroVDomiciliarias.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAAcercade1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIECargarSActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIERegistroEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Registro Encuesta", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAyudasDxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarAyudasDx.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarHCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarHC.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroNMedicas1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIRegistroNMedicas.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGRegistroActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIGRegistro.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGSeguimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIGSeguimiento.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIArchivarDocsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Archivar Documentos Clínicos", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAtencionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Consultar Atenciones", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarCprogramadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarCprogramada.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarIncapacidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Registro de Incapacidades", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarRemOrdActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarRemOrd.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoUsuario1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Consultar Resultado de Exámenes x Usuario", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoGActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarResultadoG.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUEHistoriaPdfActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUEHistoriaPdf.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUEAxamenesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUEAxamenes.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUEAxamenesFEchaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUEAxamenesFEcha.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGestionExamenesActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUGestionExamenes.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAtencionesManualesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUAtencionesManuales.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUImportarAyudasdxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUImportarAyudasdx.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIImportarAyudasDxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Ayudas Diagnosticas x Lote", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICopiasDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Copia de Docuemtos", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIISoporteLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Cargar Soporte Lotes GD", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMGReporteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMGReporte.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarMovimientoDocClinicoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIConsultarMovimientoDocClinico.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUSolicitudDocClinicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla(this.JMIUSolicitudDocClinicos.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCIProcesosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMCIProcesos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCIProcxTipoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMCIProcxTipo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCITipoProcesoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMCITipoProceso.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarAyudasDx1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarHC1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUEHistoriaPdf1ActionPerformed1(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGestionExamenes1ActionPerformed1(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAtencionesManuales1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUImportarAyudasdx1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIImportarAyudasDx1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabAgendaActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            Principal principal = this.xjp;
            Principal.claselab.cargarPantalla("Agenda Bienestar");
        } else {
            Principal principal2 = this.xjp;
            Principal.claselab.cargarPantalla(this.mnuLabAgenda.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabManualActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Manual");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPlanillaTrabajoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Filtro Panilla");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIR_ValidarInterfazActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("ValidarResultadoInterfaz");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEBiosystemA15ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación BioSystem A15");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEBiosystemA25ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación BioSystem A25");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEWienerLabCB400iActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación Wiener Lab CB400i");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEAutoplexActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación AutoPlex");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEWienerLabCB400i2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación Abbott Architect i1000SR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIECobase411ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación Cobas e411");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIESTASatellite1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación STA Satellite");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIHematologia1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Hematologia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIHematologiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Hematologia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIICombilyzer3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Equipo de Orina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIDiruiHActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Equipo de Orina1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIBiosystemA25ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("IBiosystem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIQHumastar80ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Quimica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIHL7InfinityActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("HL7 (Infinity Roche Diagnostics)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIResultadoExternosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Resultados Laboratorio Externo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRemisionRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("RemisionLab");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuDemandaNoAtendidaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Demanda no Atendida");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabResultados3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Recepciones por Municipio con Valor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuMuestrasRecepcionadasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Estadística de Muestras Recepcionadas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabResultados4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Procedimimientos Facturados por Empresa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProduccionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Estadistica de Recepciones");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProduccion1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Consolidado de Recepciones por Municipio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProduccion2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Recepciones por Entidad  y Municipio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProduccion3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Recepciones por Entidad, Municipio y Procedimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabResultados1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Estadistica de Tiempo de Espera");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuImpresionStikersActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Impresion de Stikers");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabPlanillaTrabajoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Imprimir");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoUsuario2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.JMIConsultarResultadoUsuario2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabResultados2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("GenerarReporte");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabAreasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Areas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUComentarioAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Comentario por Area");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProtocolosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Protocolos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFEncabezadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.JMIFEncabezado.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabTipoMuestraActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Tipo Muestra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabTipoRechazoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.mnuLabTipoRechazo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabTipoMetodoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.mnuLabTipoMetodo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabTipoResultadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("TipoResultado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabTipoTuboActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseparametrizacionn.cargarPantalla("Tipo de Tubo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProcedimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Procedimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProcedimientoUnifActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Procedimientos Unificados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProcedimientoRelacActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.mnuLabProcedimientoRelac.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProxAreaxPocedimActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("ProtocolxAreaxProcedim");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProtocoloxTipoResultadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("ProtocoloxTipoResultado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMConstanciaAtenActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.JMConstanciaAten.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCopiaDocumentosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("xjiftranferenciadoclab");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMRegisDatosExamenActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Registro Datos Adicionales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMRegisRechazoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Registro de Rechazo de Muestra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMReporteI1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.JMReporteI1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoExaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Consultar Resultado de Exámenes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuActivosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla("Gestion Activos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnubajaActionPerformed(ActionEvent evt) {
        Principal.clasemant.cargarPantalla(this.mnubaja.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuIngresarActionPerformed(ActionEvent evt) {
        Principal.clasemant.cargarPantalla(this.mnuIngresar.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuConsultarEstadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla(this.mnuConsultarEstado.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuGenerarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla(this.mnuGenerar.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuReportesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla(this.mnuReportes.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuReportes1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla(this.mnuReportes1.getText(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMGestionEmpleadoActionPerformed1(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Cargo x Usuario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_LiquidacionNActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("xjif_liquidacionn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_CausacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("xjif_causacion_nomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMGDeduccionConceptosActionPerformed1(ActionEvent evt) {
        Principal.claserecursoshumanos.cargarPantalla("Consulta Deducciones por Conceptos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAnticiposActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Anticipos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUAutorizacionesActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla(this.JMIUAutorizaciones.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUC_Gestion_ConceptoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla(this.JMIUC_Gestion_Concepto.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_ConsultarNominaIntervaloFechaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Consolidado por Intervalo de Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_ConsolidadoPersonalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Consolidado Personal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_ConsultarPlanillasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("xjif_consultarplanillanomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_ConsolidadoConceptosRHActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Consolidado Por Conceptos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_InformeCGRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Informe CGR Nomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRegistroRecibosCMActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clascajamenor.cargarPantalla(this.JMICRegistroRecibosCM.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICSolicitudRCMActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clascajamenor.cargarPantalla("Solicitud de Reembolso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaRxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla("Agenda_Rx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarEstadoOActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla(this.JMIConsultarEstadoO.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroInformacionPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla(this.JMIRegistroInformacionP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITiempoRxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla("Tiempo de Espera RX");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsolidadoLecturaActionPerformed(ActionEvent evt) {
        Principal.xclasesig.cargarPantalla("Informe de Lecturas Por Empresa y Valor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMRUNotasImaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla(this.JIMRUNotasIma.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMRULecturaOitActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla("Lectura Oit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMRUInfomeLecturaUsuarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla("Informe De Lecturas Por Usuario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadoFEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIP_ConsolidadoFE.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadoFFActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIP_ConsolidadoFF.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPListaFacturaVentaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Listado de Facturas de Ventas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPListaOrdenInternaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Listado de Ordenes Internas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadoCarteraActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Consolidado de Cartera");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadoGlosasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Consolidado de Glosas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_Circular030ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("GeneracionCircular030");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFUCConciliacionCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Conciliacion Cartera");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDigitacionDxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIUDigitacionDx.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDxMasivoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIUDxMasivo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUImportarDxRipsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIUImportarDxRips.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURGenerarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Generar Rips");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURGenerarRipsExtranjerosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Generar Rips - Extranjeros");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURGenerar1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Generar FutRips");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFListFacturas1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIFListFacturas1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFListFacturasArm1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIFListFacturasArm1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFReorganizacionF1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIFReorganizacionF1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCConsultarEstadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla(this.JMCConsultarEstado.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCSolicitudActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla(this.JMCSolicitud.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCEvaluadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Evaluación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JMCCotizaciónActionPerformed, reason: contains not printable characters */
    public void m0JMCCotizacinActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Registro de Cotizaciones");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCConsultarEstadoSActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla(this.JMCConsultarEstadoS.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCSolicitudSActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("jifordenservicio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCSolicitudCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Registro De Contrato");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCConsolidadoContratoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Consolidado Contratos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCInformeCGRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Informe CGR Compras");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIOdontoAgendaActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("AgendaN", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarADx1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarADx.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarHc1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla(this.JMIConsultarHc.getText(), this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAAcercade4ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIANRReporteHExtrasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Reporte Horas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIRiesgoCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseinformes.cargarPantalla("Atenciones_Riesgo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSo_AgendaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Agenda_So");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSo_Alcohol_DrograActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Prueba AyD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSo_Test_FatigaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Test Fatiga");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCargarDatosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("GestionMP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUCPeriodicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("ClasificacionFR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGPeriodicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("GestionEP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUGSeguimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("SeguimientoP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoAutoReportesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Informe de Autoreportes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInfAyDActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("AyD por Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoAtencionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Atenciones So");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoCSeguimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("RSeguimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoFraminghamActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Informe Framingham");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoEstudiosRadiologicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Interpretaciones Estudios Radiológicos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoRiesgoCVActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Información Riesgo Cardiovascular");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInformeDiagnosticoSaludActionPerformed(ActionEvent evt) {
        Principal.xclasesig.cargarPantalla("Informe de Diagnosticos de Salud");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInformeCIS20ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Informe CIS20");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoReporteAudiometriaActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Informe Audiometría");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoReporteEspirometriaActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Informe Espirometría1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoReporteNOMAActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Informe NOMA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoReporteVisiometriaActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Informe Visiometria");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoTFatigaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Test de Fatiga por Fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoTRuffierActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Informe Test de Ruffier");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITipoSegActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("TipoSEG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITipoAgenteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseparametrizacionn.cargarPantalla("TipoAgente");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUSegProcedimientosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("SEGxProcedimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUSegAgenteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("SEGxAgente");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITSegValorActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("ValorxSEG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGAActivosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegactivo.cargarPantalla("Activos Fijos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGAInformeActivosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegactivo.cargarPantalla("Informe de Activos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_AgendaNActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("AgendaN", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_CxProgramacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseCirugia.mCargarPantalla("xjig_programacion_cx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_IProgramacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseCirugia.mCargarPantalla("Programación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIManualesIngActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xMovManuales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIngresosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDisponibilidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Disponibilidad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICompromisoPTOActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Compromiso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIOperacionesM1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xMovimientosManuales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMovManualActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Movimientos_Manuales_OB_PP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEjecucionPtalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xConsultaRubros");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_BusquedaMovPptActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xBuscarDocumPpto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEjecucionPtalPeriodoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xConsultaRubrosPer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDecreto2193ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("xConsultaDec2193");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICuentasxPagarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("jiffInformeCuentasxPagar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMILibroPresupuestoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Libros Presupuestales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICargueInicialActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("CargueInicial");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISolicitudesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAnulaDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("AnulaDocPresupuesto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUCConsolidadoCierreActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Consolidado Cierre Contable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarLecturaRxActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Informe De Lecturas Por Usuario", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeContraloriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Informacion Controloria");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDEstadoResultadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Estado de Resultado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeCGRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Informes CGR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEDL96IIActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación DL-96II");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoReporteEspirometria1ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Informe Espirometría");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabProduccion4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Estadistica de Muestras Nuevas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuMaxyMinActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.7");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRConsultarUnidosisAplicadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Consultar Unidosis Aplicada");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaN1ActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Historia_Nueva", this.xjp, "Historia_Nueva");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_HojaTratamientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseTrancision.cargarPantalla("jif_hojatratamiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUGCertificadoIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMConfiguracionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_CPagosContabilidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICGPago1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCambiarG1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Cambiar Grupo Factura y/o Imprimir");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuAgendaSimedisActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabHomologacionItemsExternosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Homologacion de Items Externos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIEstadoFinancieroCompActionPerformed(ActionEvent evt) {
        Principal.xclase.cargarPantalla("Estados Financieros");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_InformeCartera2193ActionPerformed(ActionEvent evt) {
        Principal.xclasegc.cargarPantalla("Informes Cartera 2193");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoExaPerioSeguimientoDetallesActionPerformed(ActionEvent evt) {
        Principal.xclaseso.cargarPantalla("Examenes periodicos seguimiento detalles");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDocDescuadradosActionPerformed(ActionEvent evt) {
        Principal.xclase.cargarPantalla("Documentos Descuadrados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCambiarG2ActionPerformed(ActionEvent evt) {
        Principal.clasefacturacion.cargarPantalla("Reliquidacion Facturas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuEnfAgenda2ActionPerformed(ActionEvent evt) {
        Principal.claseenfer.cargarPantalla("Agenda de Procedimientos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarResultadoExa1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Importacion de Resultados Externos en PDF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabResultadoExportacionInstitucionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportacion de Resultados Institucional");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadosDePagosActionPerformed(ActionEvent evt) {
        Principal.xclasegc.cargarPantalla("Consolidados de pagos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICI_ConsultarEstadoFacturasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla(this.JMICI_ConsultarEstadoFacturas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUEmpleadosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUEmpleadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Empleados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCambiarG3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Factura Electronica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_SolicitudAlimentacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Solicitud de Alimentación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_AInformeActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Reporte Solicitud Alimentación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURGenerarRipsCovidActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Generar Rips Covid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMPagosNominaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Pagos Nomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRotacion1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("jifSuministrosFechaInvima");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformesIngresoEventoSoat1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Ingresos por Liquidación");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_InformeCirugiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseCirugia.mCargarPantalla("JIFInformeCirugia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITipoSistemaVigilanciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("TipoSistemaVigilancia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_ConsolidadoGlosasDefinitivoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Consolidado de Glosas Definitivo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICPReferenciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseReferencia.cargarPantalla("jifReferencia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabRegistroGeneralActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Registro General");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICPSoporteDigitalizadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseDigitalizacionSoporte.cargarPantalla("Digitalizacion de Soportes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICPRConsolidadoRemisionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseReferencia.cargarPantalla("jifConsolidadoReferencia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabConsolidadoPorTipoServicioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Consolidado por tipo de servicio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPAgenda_UH1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla(this.JMIPAgenda_UH1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIECM250ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportación Wiener Lab CM250");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaCEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Agenda de Consulta Externa", this.xjp, "Historia_Nueva");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaServiciosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Agenda de Servicios", this.xjp, "Historia_Nueva");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabExportarResultadosPDFActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Exportar Resultado PDF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInformesGenericosActionPerformed(ActionEvent evt) {
        Principal.xclaseso.cargarPantalla("Informes Generales SO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUPrestamosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUPrestamosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Prestamos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInformesGenericos1ActionPerformed(ActionEvent evt) {
        Principal.xclaseodontolgia.cargarPantalla("Informes Generales Odontologia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabInformesDinamicosActionPerformed(ActionEvent evt) {
        Principal.claselab.cargarPantalla("Consulta Informes Dinamicos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUNovedadesNominaActionPerformed(ActionEvent evt) {
        Principal.claserecursoshumanos.cargarPantalla("NovedadesNomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUTrasmisionNominaActionPerformed(ActionEvent evt) {
        Principal.claserecursoshumanos.cargarPantalla("Transmisión Nómina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMIUTrasmisionNotaNominaActionPerformed(ActionEvent evt) {
        Principal.claserecursoshumanos.cargarPantalla("Transmisión Notas Nómina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuturnosDigitalesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("AgendaTaquilla");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuFacturacionAgilActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("FacturaA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAGEventoServicioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIAGEventoServicio.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUGFacturaConceptoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("GenerarFC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIACapitacionServicioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIACapitacionServicio.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIACapitacion1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIACapitacion1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPConsultarCPEActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Consultar Cuentas x Empresa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMGCCG_PagosGrupalesActionPerformed(ActionEvent evt) {
        Principal.xclasegc.cargarPantalla("jifgestion_pagos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMGCCGestionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Gestion Cartera");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAProcedimientosAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Armado y Auditoria Procedimientos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAOrdenFacturaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Ordenes / Facturas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIACapitacionGActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIACapitacionG.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaRx2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("xJIFGestionDeFactura");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGN_LiquidacionNuevaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("xjif_liquidacionnuevo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRadicacionFacturasMasivaActionPerformed(ActionEvent evt) {
        Principal.xclasegc.cargarPantalla("jifradicacionmasivafacturas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaServiciosBetaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Agenda de Servicios Beta", this.xjp, "Historia_Nueva");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICSeleccionC1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("jiffacturaciondianrecibida");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUEHistoriaPdf2ActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("ExportacionHCPDFPlantilla", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUInformesNovedadesActionPerformed(ActionEvent evt) {
        Principal.claserecursoshumanos.cargarPantalla("InformeNovedadesNomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuRemisionR2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("RemisionLab2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuFacturacionAgendaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPAgenda_UH2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Agenda Servicios (Beta)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSoInformesSistemaVigilanciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Informe Sistema Vigilancia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUGenerarCotizacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Generador de Cotizacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDisponibilidad1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Disponibilidad_N");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRentransmisionResultadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Retransmision de Resultados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_InformesPyPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jmiInformesGeneralesFacActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("jmiInformesGeneralesFac");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMII_InformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseAuditoriaMedica.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUPRegistroEnvioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMUPRegistroEnvio.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUPMatriculaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMUPMatricula.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUPConsultaUserActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("CONSULTA USUARIOS MATRICULADOS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMResultadoAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("Consolidado Auditoria");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMAuditoriaMpActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("Auditoria Formulas MP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMLogisticaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMLogistica.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDGenerarPlantillaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMIUDGenerarPlantilla.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUGenerarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("GenerarD");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDPlantillaAplicadaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMIUDPlantillaAplicada.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUDCargarLoteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMIUDCargarLote.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUCCargarAc1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla(this.JMUCCargarAc1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUPConsultaUser1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMI_InformeGeneralActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecaja.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasescita.cargarPantalla(this.xjp, "Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInformeGeneralActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("jmiInformesGeneralesInventario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeTipoImpuesto2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasepyp.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRegistroDiario4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeGeneraleActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("Informes Generales", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUInformesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegestiondoc.cargarPantalla("Informes Generales", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasemant.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIUInformesGeneralActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clascajamenor.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMRInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseimagendx.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCInformeGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claserecursoshumanos.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseinformes.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIGInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegactivo.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP_InformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseCirugia.mCargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMILInformesGeneralesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Informes Generales");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuLabCruzadosActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            Principal principal = this.xjp;
            Principal.claselab.cargarPantalla("Cruzados");
        } else {
            this.mnuLabCruzados.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIURGenerar2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Generar FutRipsV2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDisponibilidad2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("SolicitudDisponibilidad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDisponibilidad3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Solicitud (Nueva Beta)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMILValidacionAdministrativaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("ValidacionAdministrativa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void importarcorreoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("ImportacionCorreosporUusuarios");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFReorganizacionF2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("Reliquidar Ordenes Convenio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAgendaNSOActionPerformed(ActionEvent evt) {
        this.xjp.mLimpiarPanel();
        Principal principal = this.xjp;
        Principal.clasehistoriace.cargarPantalla("AgendaN", this.xjp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICompromisoBetaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasePresupuesto.cargarPantalla("Compromiso (Nuevo Beta)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDeclaracionAntecedentesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclaseso.cargarPantalla("Declaracion de antecendes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFExportarExcelPDFActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla(this.JMIFExportarExcelPDF.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuListadoBasicoMedicamentosPsiquiatriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xClaseInventario.cargarPantalla("Informes1.4.1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFPFacturasPE3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Consultar Auditoria Por Factura");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUNCambiarG4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasegc.cargarPantalla("xJIFGestionDeFactura");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMUS_GestionSolicitudesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasefacturacion.cargarPantalla("Gestión Solicitudes Servicio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPlanillaTrabajo1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Validasion Masiva");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuImpresionStikers1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Impresion de Stikers 2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuTrakingActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("tracking");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFInfhospitalizados1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseenfer.cargarPantalla("Consulta de Usuarios Hospitalizados");
    }

    private void JIFImportacionCorreosPorUsuarios(String importar_correos_por_usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
