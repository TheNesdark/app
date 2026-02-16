package Acceso;

import Utilidades.ConsultasMySQL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/Menus1.class */
public class Menus1 extends JPanel {
    private ConsultasMySQL ConsultasMysql = new ConsultasMySQL();
    Principal xjp;
    private JMenuItem JIMRUInformes;
    private JMenu JMBSPyPCaCervix;
    public static JMenuBar JMBSgcP1;
    public static JMenuBar JMBSgcP10;
    public static JMenuBar JMBSgcP11;
    public static JMenuBar JMBSgcP12;
    public static JMenuBar JMBSgcP14;
    public static JMenuBar JMBSgcP15;
    public static JMenuBar JMBSgcP16;
    public static JMenuBar JMBSgcP17;
    public static JMenuBar JMBSgcP18;
    public static JMenuBar JMBSgcP19;
    public static JMenuBar JMBSgcP2;
    public static JMenuBar JMBSgcP20;
    public static JMenuBar JMBSgcP22;
    public static JMenuBar JMBSgcP3;
    public static JMenuBar JMBSgcP4;
    public static JMenuBar JMBSgcP5;
    public static JMenuBar JMBSgcP6;
    public static JMenuBar JMBSgcP7;
    public static JMenuBar JMBSgcP8;
    public static JMenuBar JMBSgcP9;
    public static JMenuBar JMBSigPyP;
    private JMenuItem JMICCronicos;
    private JMenuItem JMICInformeFecha;
    private JMenuItem JMICRecepcion;
    private JMenuItem JMICRecepcionStiker;
    private JMenuItem JMICResultado;
    private JMenuItem JMIFormulacionMedica;
    private JMenuItem JMIInformeDespacho1;
    private JMenuItem JMIInformeDespacho2;
    private JMenuItem JMIP10CasosSGC;
    private JMenuItem JMIP10Ficha5w1h;
    private JMenuItem JMIP10IHospitalizados;
    private JMenuItem JMIP10IREncuesta;
    private JMenuItem JMIP10IResiduosPeligrosos;
    private JMenuItem JMIP10RegistroAnalisisNc;
    private JMenuItem JMIP11CasosSGC;
    private JMenuItem JMIP11Ficha5w1h;
    private JMenuItem JMIP11IEstudios;
    private JMenuItem JMIP11IPlacasD;
    private JMenuItem JMIP11IREncuesta;
    private JMenuItem JMIP11RegistroAnalisisNc;
    private JMenuItem JMIP12CasosSGC;
    private JMenuItem JMIP12Ficha5w1h;
    private JMenuItem JMIP12IREncuesta;
    private JMenuItem JMIP12RegistroAnalisisNc;
    private JMenuItem JMIP14CasosSGC;
    private JMenuItem JMIP14Ficha5w1h;
    private JMenuItem JMIP14RegistroAnalisisNc;
    private JMenuItem JMIP15CasosSGC;
    private JMenuItem JMIP15Eficacia;
    private JMenuItem JMIP15Ficha5w1h;
    private JMenuItem JMIP15IREncuesta;
    private JMenuItem JMIP15RegistroAnalisisNc;
    private JMenuItem JMIP15SesionesXTrabajador;
    private JMenuItem JMIP16Autorizar;
    private JMenuItem JMIP16CasosSGC;
    private JMenuItem JMIP16Ficha5w1h;
    private JMenuItem JMIP16IREncuesta;
    private JMenu JMIP16Informes;
    private JMenuItem JMIP16RegistroAnalisisNc;
    private JMenuItem JMIP16SGestionar;
    private JMenu JMIP16Sgc;
    private JMenu JMIP16Utilidades;
    private JMenuItem JMIP17CasosSGC;
    private JMenuItem JMIP17Ficha5w1h;
    private JMenuItem JMIP17IREncuesta;
    private JMenuItem JMIP17RegistroAnalisisNc;
    private JMenuItem JMIP18CasosSGC;
    private JMenuItem JMIP18Ficha5w1h;
    private JMenuItem JMIP18IREncuesta;
    private JMenuItem JMIP18RegistroAnalisisNc;
    private JMenuItem JMIP19CasosSGC;
    private JMenuItem JMIP19Ficha5w1h;
    private JMenuItem JMIP19IREncuesta;
    private JMenuItem JMIP19IRPolizas;
    private JMenuItem JMIP19ISuperSalud;
    private JMenuItem JMIP19IUser_Medicamentos;
    private JMenuItem JMIP19RegistroAnalisisNc;
    private JMenuItem JMIP1CasosSGC;
    private JMenuItem JMIP1Ficha5w1h;
    private JMenuItem JMIP1IREncuesta;
    private JMenu JMIP1Informes;
    private JMenuItem JMIP1RegistroAnalisisNc;
    private JMenuItem JMIP1SAutorizar;
    private JMenuItem JMIP1SGestionar;
    private JMenu JMIP1Sgc;
    private JMenu JMIP1Utilidades;
    private JMenuItem JMIP20CasosSGC;
    private JMenuItem JMIP20Ficha5w1h;
    private JMenuItem JMIP20IREncuesta;
    private JMenuItem JMIP20RegistroAnalisisNc;
    private JMenuItem JMIP22CasosSGC;
    private JMenuItem JMIP22Ficha5w1h;
    private JMenuItem JMIP22RegistroAnalisisNc;
    private JMenuItem JMIP22RegistroEncuesta;
    private JMenuItem JMIP2Ficha5w1h;
    private JMenuItem JMIP2GFicha5w1h;
    private JMenuItem JMIP2G_AnalasisEventoA;
    private JMenuItem JMIP2IConsolidadoEventosA;
    private JMenuItem JMIP2IREncuesta;
    private JMenu JMIP2Informes;
    private JMenuItem JMIP2Nc;
    private JMenuItem JMIP2RegistroAnalisisNc;
    private JMenuItem JMIP2RegistroIndicadores;
    private JMenuItem JMIP2SAutorizar;
    private JMenuItem JMIP2SGestionar;
    private JMenu JMIP2Sgc;
    private JMenu JMIP2Utilidades;
    private JMenuItem JMIP3CasosSGC;
    private JMenuItem JMIP3Ficha5w1h;
    private JMenuItem JMIP3IREncuesta;
    private JMenuItem JMIP3RegistroAnalisisNc;
    private JMenuItem JMIP4CasosSGC;
    private JMenuItem JMIP4Ficha5w1h;
    private JMenuItem JMIP4IREncuesta;
    private JMenuItem JMIP4RegistroAnalisisNc;
    private JMenuItem JMIP5CasosSGC;
    private JMenuItem JMIP5Ficha5w1h;
    private JMenuItem JMIP5IREncuesta;
    private JMenu JMIP5Informes;
    private JMenuItem JMIP5RegistroAnalisisNc;
    private JMenuItem JMIP5SAutorizar;
    private JMenuItem JMIP5SConsolidadoS;
    private JMenuItem JMIP5SGestionar;
    private JMenu JMIP5Sgc;
    private JMenu JMIP5SgcPyp;
    private JMenu JMIP5Utilidades;
    private JMenuItem JMIP6AHEnfermera;
    private JMenuItem JMIP6AHMedicos;
    private JMenuItem JMIP6CasosSGC;
    private JMenuItem JMIP6ConsultrarAlertas;
    private JMenuItem JMIP6ConsultrarFisioterapia;
    private JMenuItem JMIP6ConsultrarMorbilidadG;
    private JMenuItem JMIP6ConsultrarMorbilidadGEdades;
    private JMenuItem JMIP6ConsultrarMorbilidadGSexo;
    private JMenuItem JMIP6ConsultrarMorbilidadGSexoEdades;
    private JMenuItem JMIP6Espirometria;
    private JMenuItem JMIP6Ficha5w1h;
    private JMenuItem JMIP6ICCitasSaludOcupacional;
    private JMenuItem JMIP6ICCitasSaludOcupacional1;
    private JMenuItem JMIP6ICInformacionImcS;
    private JMenuItem JMIP6ICPrepararPR;
    private JMenuItem JMIP6ICReporte1;
    private JMenuItem JMIP6IConsultarUsuarioInactivos;
    private JMenuItem JMIP6IConsultarVProfesional;
    private JMenuItem JMIP6IFormaAsigCitas;
    private JMenuItem JMIP6IRDemandaNA;
    private JMenuItem JMIP6IREncuesta;
    private JMenuItem JMIP6IRIncapacidad;
    private JMenuItem JMIP6IRemisionesxProfesional;
    private JMenuItem JMIP6ITSEventosNoDeseados;
    private JMenuItem JMIP6MedicinaDerporte;
    private JMenuItem JMIP6PAudiometria;
    private JMenuItem JMIP6PRespiratoria;
    private JMenuItem JMIP6RCAtenciones;
    private JMenuItem JMIP6RTestAuditivo;
    private JMenuItem JMIP6RegistroAnalisisNc;
    private JMenuItem JMIP6ReporteCuestionario;
    private JMenuItem JMIP6ReporteOMA;
    private JMenuItem JMIP6ReporteSicologia;
    private JMenuItem JMIP6ReporteSociodem;
    private JMenuItem JMIP6Tratamientos;
    private JMenuItem JMIP7CasosSGC;
    private JMenuItem JMIP7Ficha5w1h;
    private JMenuItem JMIP7IREncuesta;
    private JMenuItem JMIP7RegistroAnalisisNc;
    private JMenuItem JMIP8CasosSGC;
    private JMenuItem JMIP8Ficha5w1h;
    private JMenuItem JMIP8IREncuesta9;
    private JMenuItem JMIP8RegistroAnalisisNc;
    private JMenuItem JMIP9AuditoriaTriage;
    private JMenuItem JMIP9CasosSGC;
    private JMenuItem JMIP9Ficha5w1h;
    private JMenuItem JMIP9ICEstadoAsign;
    private JMenuItem JMIP9ICTiemposA;
    private JMenuItem JMIP9IREncuesta;
    private JMenuItem JMIP9IResiduosPeligrosos;
    private JMenuItem JMIP9RegistroAnalisisNc;
    private JMenuItem JMIPIREncuesta22;
    private JMenuItem JMIPIREncuesta23;
    private JMenu JMIPInformes10;
    private JMenu JMIPInformes12;
    private JMenu JMIPInformes14;
    private JMenu JMIPInformes15;
    private JMenu JMIPInformes17;
    private JMenu JMIPInformes18;
    private JMenu JMIPInformes19;
    private JMenu JMIPInformes20;
    private JMenu JMIPInformes22;
    private JMenu JMIPInformes3;
    private JMenu JMIPInformes4;
    private JMenu JMIPInformes7;
    private JMenu JMIPInformes8;
    private JMenu JMIPInformes9;
    private JMenuItem JMIPPyPCasosSGC;
    private JMenuItem JMIPPyPRegistroAnalisisNc;
    private JMenuItem JMIPPyPRiesgoCV;
    private JMenuItem JMIPSAutorizar10;
    private JMenuItem JMIPSAutorizar11;
    private JMenuItem JMIPSAutorizar12;
    private JMenuItem JMIPSAutorizar14;
    private JMenuItem JMIPSAutorizar15;
    private JMenuItem JMIPSAutorizar17;
    private JMenuItem JMIPSAutorizar18;
    private JMenuItem JMIPSAutorizar19;
    private JMenuItem JMIPSAutorizar20;
    private JMenuItem JMIPSAutorizar22;
    private JMenuItem JMIPSAutorizar3;
    private JMenuItem JMIPSAutorizar4;
    private JMenuItem JMIPSAutorizar6;
    private JMenuItem JMIPSAutorizar7;
    private JMenuItem JMIPSAutorizar8;
    private JMenuItem JMIPSAutorizar9;
    private JMenuItem JMIPSGestionar10;
    private JMenuItem JMIPSGestionar11;
    private JMenuItem JMIPSGestionar12;
    private JMenuItem JMIPSGestionar14;
    private JMenuItem JMIPSGestionar15;
    private JMenuItem JMIPSGestionar17;
    private JMenuItem JMIPSGestionar18;
    private JMenuItem JMIPSGestionar19;
    private JMenuItem JMIPSGestionar20;
    private JMenuItem JMIPSGestionar22;
    private JMenuItem JMIPSGestionar3;
    private JMenuItem JMIPSGestionar4;
    private JMenuItem JMIPSGestionar6;
    private JMenuItem JMIPSGestionar7;
    private JMenuItem JMIPSGestionar8;
    private JMenuItem JMIPSGestionar9;
    private JMenuItem JMIPSIREncuesta;
    private JMenuItem JMIPSIUsuariosxActividad;
    private JMenuItem JMIPSResolucion1552;
    private JMenuItem JMIPSResolucion202;
    private JMenuItem JMIPSResolucion2175;
    private JMenuItem JMIPSResolucion256;
    private JMenuItem JMIPSResolucion4505;
    private JMenu JMIPSgc10;
    private JMenu JMIPSgc11;
    private JMenu JMIPSgc12;
    private JMenu JMIPSgc14;
    private JMenu JMIPSgc15;
    private JMenu JMIPSgc17;
    private JMenu JMIPSgc18;
    private JMenu JMIPSgc19;
    private JMenu JMIPSgc20;
    private JMenu JMIPSgc22;
    private JMenu JMIPSgc3;
    private JMenu JMIPSgc4;
    private JMenu JMIPSgc6;
    private JMenu JMIPSgc7;
    private JMenu JMIPSgc8;
    private JMenu JMIPSgc9;
    private JMenu JMIPSig11;
    private JMenu JMIPSigs6;
    private JMenuItem JMIPTiempoFacCons;
    private JMenu JMIPUtilidades10;
    private JMenu JMIPUtilidades11;
    private JMenu JMIPUtilidades12;
    private JMenu JMIPUtilidades14;
    private JMenu JMIPUtilidades15;
    private JMenu JMIPUtilidades17;
    private JMenu JMIPUtilidades18;
    private JMenu JMIPUtilidades19;
    private JMenu JMIPUtilidades20;
    private JMenu JMIPUtilidades22;
    private JMenu JMIPUtilidades3;
    private JMenu JMIPUtilidades4;
    private JMenu JMIPUtilidades6;
    private JMenu JMIPUtilidades7;
    private JMenu JMIPUtilidades8;
    private JMenu JMIPUtilidades9;
    private JMenu JMIPyPUtilidades;
    private JMenuItem JMIRCaCervix1;
    private JMenuItem JMISAtencionesxEspecialidad;
    private JMenuItem JMISCitasPxEspecialidad;
    private JMenuItem JMISInfCardiovascular;
    private JMenuItem JMISInfCronicosEps;
    private JMenuItem JMISInfPatologiasAs;
    private JMenuItem JMISInformacionCove;
    private JMenuItem JMISInformeEps;
    private JMenuItem JMISMultivitaminico;
    private JMenuItem JMISPolimedicadoxTipoF;
    private JMenuItem JMISResultadoLabProc;
    private JMenuItem JMISUsuariosxPrograma;
    private JMenuItem JMISegCyD;
    private JMenuItem JMISgcP11Lab1;
    private JMenuItem JMISgcP11Lab2;
    private JMenuItem JMISgcP11Lab3;
    private JMenuItem JMITPago;
    private JMenuItem JMITiempoEsperaRX;
    private JMenuItem JMNIActualizarRef;
    private JMenuItem JMNIConsInfo;
    private JMenu JMP16Solicitudes;
    private JMenu JMP1Solicitudes;
    private JMenu JMP2Solicitudes;
    private JMenu JMP5Solicitudes;
    private JMenu JMP6Admisiones;
    private JMenu JMP6AuditoriaHC;
    private JMenu JMP6EMorbilidad;
    private JMenu JMP6Nutricion;
    private JMenu JMP6Odontologia;
    private JMenu JMP6SaludOcupacional;
    private JMenu JMP6TrabajoSocial;
    private JMenu JMPLaboratorio;
    private JMenu JMPRadiologia;
    private JMenu JMPSO_Gestion_Examenes;
    private JMenu JMPSolicitudes10;
    private JMenu JMPSolicitudes11;
    private JMenu JMPSolicitudes12;
    private JMenu JMPSolicitudes14;
    private JMenu JMPSolicitudes15;
    private JMenu JMPSolicitudes17;
    private JMenu JMPSolicitudes18;
    private JMenu JMPSolicitudes19;
    private JMenu JMPSolicitudes20;
    private JMenu JMPSolicitudes22;
    private JMenu JMPSolicitudes3;
    private JMenu JMPSolicitudes4;
    private JMenu JMPSolicitudes6;
    private JMenu JMPSolicitudes7;
    private JMenu JMPSolicitudes8;
    private JMenu JMPSolicitudes9;
    private JMenu JMSigPyp;
    public static JMenuBar barraMnuCitologix;
    public static JMenuBar barraMnuTesoreria;
    private JMenu mnuCitologix;
    private JMenu mnuCitologixInformes;
    private JMenu mnuTesoreria;

    public Menus1(Principal xjp) {
        initComponents();
        this.xjp = xjp;
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            xjp.xMenus.mnuListadoBasicoMedicamentos.setText("Listado de Productos Con Cantidad");
        }
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            xjp.xMenus.JMIURGenerarRipsCovid.setVisible(true);
        } else {
            xjp.xMenus.JMIURGenerarRipsCovid.setVisible(false);
        }
    }

    private void initComponents() {
        JMBSigPyP = new JMenuBar();
        this.JMIP5SgcPyp = new JMenu();
        this.JMIPPyPCasosSGC = new JMenuItem();
        this.JMIPPyPRegistroAnalisisNc = new JMenuItem();
        this.JMSigPyp = new JMenu();
        this.JMISAtencionesxEspecialidad = new JMenuItem();
        this.JMISPolimedicadoxTipoF = new JMenuItem();
        this.JMISCitasPxEspecialidad = new JMenuItem();
        this.JMISInfCardiovascular = new JMenuItem();
        this.JMISInfCronicosEps = new JMenuItem();
        this.JMIPPyPRiesgoCV = new JMenuItem();
        this.JMISInformeEps = new JMenuItem();
        this.JMIPSResolucion256 = new JMenuItem();
        this.JMIPSResolucion2175 = new JMenuItem();
        this.JMIPSResolucion4505 = new JMenuItem();
        this.JMIPSResolucion202 = new JMenuItem();
        this.JMIPSResolucion1552 = new JMenuItem();
        this.JMISegCyD = new JMenuItem();
        this.JMISInfPatologiasAs = new JMenuItem();
        this.JMBSPyPCaCervix = new JMenu();
        this.JMIRCaCervix1 = new JMenuItem();
        this.JMISInformacionCove = new JMenuItem();
        this.JMIPSIREncuesta = new JMenuItem();
        this.JMISResultadoLabProc = new JMenuItem();
        this.JMISMultivitaminico = new JMenuItem();
        this.JMIPSIUsuariosxActividad = new JMenuItem();
        this.JMISUsuariosxPrograma = new JMenuItem();
        this.JMIPyPUtilidades = new JMenu();
        JMBSgcP5 = new JMenuBar();
        this.JMIP5Sgc = new JMenu();
        this.JMIP5CasosSGC = new JMenuItem();
        this.JMIP5Ficha5w1h = new JMenuItem();
        this.JMIP5RegistroAnalisisNc = new JMenuItem();
        this.JMIP5Informes = new JMenu();
        this.JMIP5IREncuesta = new JMenuItem();
        this.JMIP5Utilidades = new JMenu();
        this.JMP5Solicitudes = new JMenu();
        this.JMIP5SAutorizar = new JMenuItem();
        this.JMIP5SGestionar = new JMenuItem();
        this.JMIP5SConsolidadoS = new JMenuItem();
        JMBSgcP16 = new JMenuBar();
        this.JMIP16Sgc = new JMenu();
        this.JMIP16CasosSGC = new JMenuItem();
        this.JMIP16Ficha5w1h = new JMenuItem();
        this.JMIP16RegistroAnalisisNc = new JMenuItem();
        this.JMIP16Informes = new JMenu();
        this.JMIP16IREncuesta = new JMenuItem();
        this.JMIP16Utilidades = new JMenu();
        this.JMP16Solicitudes = new JMenu();
        this.JMIP16Autorizar = new JMenuItem();
        this.JMIP16SGestionar = new JMenuItem();
        JMBSgcP1 = new JMenuBar();
        this.JMIP1Sgc = new JMenu();
        this.JMIP1CasosSGC = new JMenuItem();
        this.JMIP1Ficha5w1h = new JMenuItem();
        this.JMIP1RegistroAnalisisNc = new JMenuItem();
        this.JMIP1Informes = new JMenu();
        this.JMIP1IREncuesta = new JMenuItem();
        this.JMIP1Utilidades = new JMenu();
        this.JMP1Solicitudes = new JMenu();
        this.JMIP1SAutorizar = new JMenuItem();
        this.JMIP1SGestionar = new JMenuItem();
        JMBSgcP2 = new JMenuBar();
        this.JMIP2Sgc = new JMenu();
        this.JMIP2Ficha5w1h = new JMenuItem();
        this.JMIP2RegistroAnalisisNc = new JMenuItem();
        this.JMIP2RegistroIndicadores = new JMenuItem();
        this.JMIP2Informes = new JMenu();
        this.JMIP2IREncuesta = new JMenuItem();
        this.JMIP2IConsolidadoEventosA = new JMenuItem();
        this.JMIP2Utilidades = new JMenu();
        this.JMIP2G_AnalasisEventoA = new JMenuItem();
        this.JMIP2GFicha5w1h = new JMenuItem();
        this.JMIP2Nc = new JMenuItem();
        this.JMP2Solicitudes = new JMenu();
        this.JMIP2SAutorizar = new JMenuItem();
        this.JMIP2SGestionar = new JMenuItem();
        JMBSgcP3 = new JMenuBar();
        this.JMIPSgc3 = new JMenu();
        this.JMIP3CasosSGC = new JMenuItem();
        this.JMIP3Ficha5w1h = new JMenuItem();
        this.JMIP3RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes3 = new JMenu();
        this.JMIP3IREncuesta = new JMenuItem();
        this.JMIPUtilidades3 = new JMenu();
        this.JMPSolicitudes3 = new JMenu();
        this.JMIPSAutorizar3 = new JMenuItem();
        this.JMIPSGestionar3 = new JMenuItem();
        JMBSgcP4 = new JMenuBar();
        this.JMIPSgc4 = new JMenu();
        this.JMIP4CasosSGC = new JMenuItem();
        this.JMIP4Ficha5w1h = new JMenuItem();
        this.JMIP4RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes4 = new JMenu();
        this.JMIP4IREncuesta = new JMenuItem();
        this.JMIPUtilidades4 = new JMenu();
        this.JMPSolicitudes4 = new JMenu();
        this.JMIPSAutorizar4 = new JMenuItem();
        this.JMIPSGestionar4 = new JMenuItem();
        JMBSgcP6 = new JMenuBar();
        this.JMIPSgc6 = new JMenu();
        this.JMIP6CasosSGC = new JMenuItem();
        this.JMIP6Ficha5w1h = new JMenuItem();
        this.JMIP6RegistroAnalisisNc = new JMenuItem();
        this.JMIPSigs6 = new JMenu();
        this.JMP6Admisiones = new JMenu();
        this.JMIP6IConsultarUsuarioInactivos = new JMenuItem();
        this.JMIPTiempoFacCons = new JMenuItem();
        this.JMIP6IFormaAsigCitas = new JMenuItem();
        this.JMIP6IConsultarVProfesional = new JMenuItem();
        this.JMIP6ICCitasSaludOcupacional = new JMenuItem();
        this.JMIP6IRemisionesxProfesional = new JMenuItem();
        this.JMP6AuditoriaHC = new JMenu();
        this.JMIP6AHEnfermera = new JMenuItem();
        this.JMIP6AHMedicos = new JMenuItem();
        this.JMICCronicos = new JMenuItem();
        this.JMIP6ConsultrarAlertas = new JMenuItem();
        this.JMIP6IRDemandaNA = new JMenuItem();
        this.JMIP6IRIncapacidad = new JMenuItem();
        this.JMP6EMorbilidad = new JMenu();
        this.JMIP6ConsultrarFisioterapia = new JMenuItem();
        this.JMIP6ConsultrarMorbilidadG = new JMenuItem();
        this.JMIP6ConsultrarMorbilidadGEdades = new JMenuItem();
        this.JMIP6ConsultrarMorbilidadGSexo = new JMenuItem();
        this.JMIP6ConsultrarMorbilidadGSexoEdades = new JMenuItem();
        this.JMIP6ICCitasSaludOcupacional1 = new JMenuItem();
        this.JMP6Nutricion = new JMenu();
        this.JMNIActualizarRef = new JMenuItem();
        this.JMNIConsInfo = new JMenuItem();
        this.JMIP6ICInformacionImcS = new JMenuItem();
        this.JMIP6ICReporte1 = new JMenuItem();
        this.JMIP6ICPrepararPR = new JMenuItem();
        this.JMP6Odontologia = new JMenu();
        this.JMIP6Tratamientos = new JMenuItem();
        this.JMIP6IREncuesta = new JMenuItem();
        this.JMP6SaludOcupacional = new JMenu();
        this.JMIP6ReporteCuestionario = new JMenuItem();
        this.JMPSO_Gestion_Examenes = new JMenu();
        this.JMIP6RCAtenciones = new JMenuItem();
        this.JMIP6ReporteSicologia = new JMenuItem();
        this.JMIP6ReporteOMA = new JMenuItem();
        this.JMIP6PRespiratoria = new JMenuItem();
        this.JMIP6RTestAuditivo = new JMenuItem();
        this.JMIP6PAudiometria = new JMenuItem();
        this.JMIP6Espirometria = new JMenuItem();
        this.JMIP6ReporteSociodem = new JMenuItem();
        this.JMIP6MedicinaDerporte = new JMenuItem();
        this.JMP6TrabajoSocial = new JMenu();
        this.JMIP6ITSEventosNoDeseados = new JMenuItem();
        this.JMIPUtilidades6 = new JMenu();
        this.JMPSolicitudes6 = new JMenu();
        this.JMIPSAutorizar6 = new JMenuItem();
        this.JMIPSGestionar6 = new JMenuItem();
        JMBSgcP7 = new JMenuBar();
        this.JMIPSgc7 = new JMenu();
        this.JMIP7CasosSGC = new JMenuItem();
        this.JMIP7Ficha5w1h = new JMenuItem();
        this.JMIP7RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes7 = new JMenu();
        this.JMIP7IREncuesta = new JMenuItem();
        this.JMIPUtilidades7 = new JMenu();
        this.JMPSolicitudes7 = new JMenu();
        this.JMIPSAutorizar7 = new JMenuItem();
        this.JMIPSGestionar7 = new JMenuItem();
        JMBSgcP8 = new JMenuBar();
        this.JMIPSgc8 = new JMenu();
        this.JMIP8CasosSGC = new JMenuItem();
        this.JMIP8Ficha5w1h = new JMenuItem();
        this.JMIP8RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes8 = new JMenu();
        this.JMIP8IREncuesta9 = new JMenuItem();
        this.JMIPUtilidades8 = new JMenu();
        this.JMPSolicitudes8 = new JMenu();
        this.JMIPSAutorizar8 = new JMenuItem();
        this.JMIPSGestionar8 = new JMenuItem();
        JMBSgcP9 = new JMenuBar();
        this.JMIPSgc9 = new JMenu();
        this.JMIP9CasosSGC = new JMenuItem();
        this.JMIP9Ficha5w1h = new JMenuItem();
        this.JMIP9RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes9 = new JMenu();
        this.JMIP9AuditoriaTriage = new JMenuItem();
        this.JMIP9ICTiemposA = new JMenuItem();
        this.JMIP9ICEstadoAsign = new JMenuItem();
        this.JMIP10IHospitalizados = new JMenuItem();
        this.JMIP9IREncuesta = new JMenuItem();
        this.JMIP9IResiduosPeligrosos = new JMenuItem();
        this.JMIPUtilidades9 = new JMenu();
        this.JMPSolicitudes9 = new JMenu();
        this.JMIPSAutorizar9 = new JMenuItem();
        this.JMIPSGestionar9 = new JMenuItem();
        JMBSgcP10 = new JMenuBar();
        this.JMIPSgc10 = new JMenu();
        this.JMIP10CasosSGC = new JMenuItem();
        this.JMIP10Ficha5w1h = new JMenuItem();
        this.JMIP10RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes10 = new JMenu();
        this.JMIP10IREncuesta = new JMenuItem();
        this.JMIP10IResiduosPeligrosos = new JMenuItem();
        this.JMIPUtilidades10 = new JMenu();
        this.JMPSolicitudes10 = new JMenu();
        this.JMIPSAutorizar10 = new JMenuItem();
        this.JMIPSGestionar10 = new JMenuItem();
        JMBSgcP11 = new JMenuBar();
        this.JMIPSgc11 = new JMenu();
        this.JMIP11CasosSGC = new JMenuItem();
        this.JMIP11Ficha5w1h = new JMenuItem();
        this.JMIP11RegistroAnalisisNc = new JMenuItem();
        this.JMIPSig11 = new JMenu();
        this.JMPLaboratorio = new JMenu();
        this.JMISgcP11Lab2 = new JMenuItem();
        this.JMISgcP11Lab1 = new JMenuItem();
        this.JMISgcP11Lab3 = new JMenuItem();
        this.JMPRadiologia = new JMenu();
        this.JMIP11IEstudios = new JMenuItem();
        this.JIMRUInformes = new JMenuItem();
        this.JMIP11IPlacasD = new JMenuItem();
        this.JMITiempoEsperaRX = new JMenuItem();
        this.JMIP11IREncuesta = new JMenuItem();
        this.JMIPUtilidades11 = new JMenu();
        this.JMPSolicitudes11 = new JMenu();
        this.JMIPSAutorizar11 = new JMenuItem();
        this.JMIPSGestionar11 = new JMenuItem();
        JMBSgcP12 = new JMenuBar();
        this.JMIPSgc12 = new JMenu();
        this.JMIP12CasosSGC = new JMenuItem();
        this.JMIP12Ficha5w1h = new JMenuItem();
        this.JMIP12RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes12 = new JMenu();
        this.JMIP12IREncuesta = new JMenuItem();
        this.JMIPUtilidades12 = new JMenu();
        this.JMPSolicitudes12 = new JMenu();
        this.JMIPSAutorizar12 = new JMenuItem();
        this.JMIPSGestionar12 = new JMenuItem();
        JMBSgcP14 = new JMenuBar();
        this.JMIPSgc14 = new JMenu();
        this.JMIP14CasosSGC = new JMenuItem();
        this.JMIP14Ficha5w1h = new JMenuItem();
        this.JMIP14RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes14 = new JMenu();
        this.JMIFormulacionMedica = new JMenuItem();
        this.JMIInformeDespacho1 = new JMenuItem();
        this.JMIInformeDespacho2 = new JMenuItem();
        this.JMIPUtilidades14 = new JMenu();
        this.JMPSolicitudes14 = new JMenu();
        this.JMIPSAutorizar14 = new JMenuItem();
        this.JMIPSGestionar14 = new JMenuItem();
        JMBSgcP15 = new JMenuBar();
        this.JMIPSgc15 = new JMenu();
        this.JMIP15CasosSGC = new JMenuItem();
        this.JMIP15Ficha5w1h = new JMenuItem();
        this.JMIP15RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes15 = new JMenu();
        this.JMIP15IREncuesta = new JMenuItem();
        this.JMIP15Eficacia = new JMenuItem();
        this.JMIP15SesionesXTrabajador = new JMenuItem();
        this.JMIPUtilidades15 = new JMenu();
        this.JMPSolicitudes15 = new JMenu();
        this.JMIPSAutorizar15 = new JMenuItem();
        this.JMIPSGestionar15 = new JMenuItem();
        JMBSgcP17 = new JMenuBar();
        this.JMIPSgc17 = new JMenu();
        this.JMIP17CasosSGC = new JMenuItem();
        this.JMIP17Ficha5w1h = new JMenuItem();
        this.JMIP17RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes17 = new JMenu();
        this.JMIP17IREncuesta = new JMenuItem();
        this.JMIPUtilidades17 = new JMenu();
        this.JMPSolicitudes17 = new JMenu();
        this.JMIPSAutorizar17 = new JMenuItem();
        this.JMIPSGestionar17 = new JMenuItem();
        JMBSgcP18 = new JMenuBar();
        this.JMIPSgc18 = new JMenu();
        this.JMIP18CasosSGC = new JMenuItem();
        this.JMIP18Ficha5w1h = new JMenuItem();
        this.JMIP18RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes18 = new JMenu();
        this.JMIP18IREncuesta = new JMenuItem();
        this.JMIPUtilidades18 = new JMenu();
        this.JMPSolicitudes18 = new JMenu();
        this.JMIPSAutorizar18 = new JMenuItem();
        this.JMIPSGestionar18 = new JMenuItem();
        JMBSgcP19 = new JMenuBar();
        this.JMIPSgc19 = new JMenu();
        this.JMIP19CasosSGC = new JMenuItem();
        this.JMIP19Ficha5w1h = new JMenuItem();
        this.JMIP19RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes19 = new JMenu();
        this.JMIP19IUser_Medicamentos = new JMenuItem();
        this.JMIP19ISuperSalud = new JMenuItem();
        this.JMIP19IREncuesta = new JMenuItem();
        this.JMIP19IRPolizas = new JMenuItem();
        this.JMIPUtilidades19 = new JMenu();
        this.JMPSolicitudes19 = new JMenu();
        this.JMIPSAutorizar19 = new JMenuItem();
        this.JMIPSGestionar19 = new JMenuItem();
        JMBSgcP20 = new JMenuBar();
        this.JMIPSgc20 = new JMenu();
        this.JMIP20CasosSGC = new JMenuItem();
        this.JMIP20Ficha5w1h = new JMenuItem();
        this.JMIP20RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes20 = new JMenu();
        this.JMIP20IREncuesta = new JMenuItem();
        this.JMIPUtilidades20 = new JMenu();
        this.JMPSolicitudes20 = new JMenu();
        this.JMIPSAutorizar20 = new JMenuItem();
        this.JMIPSGestionar20 = new JMenuItem();
        JMBSgcP22 = new JMenuBar();
        this.JMIPSgc22 = new JMenu();
        this.JMIP22CasosSGC = new JMenuItem();
        this.JMIP22Ficha5w1h = new JMenuItem();
        this.JMIP22RegistroEncuesta = new JMenuItem();
        this.JMIP22RegistroAnalisisNc = new JMenuItem();
        this.JMIPInformes22 = new JMenu();
        this.JMIPIREncuesta22 = new JMenuItem();
        this.JMIPUtilidades22 = new JMenu();
        this.JMPSolicitudes22 = new JMenu();
        this.JMIPSAutorizar22 = new JMenuItem();
        this.JMIPSGestionar22 = new JMenuItem();
        this.JMIPIREncuesta23 = new JMenuItem();
        barraMnuTesoreria = new JMenuBar();
        this.mnuTesoreria = new JMenu();
        this.JMITPago = new JMenuItem();
        barraMnuCitologix = new JMenuBar();
        this.mnuCitologix = new JMenu();
        this.JMICRecepcion = new JMenuItem();
        this.JMICResultado = new JMenuItem();
        this.mnuCitologixInformes = new JMenu();
        this.JMICInformeFecha = new JMenuItem();
        this.JMICRecepcionStiker = new JMenuItem();
        JMBSigPyP.setFont(new Font("Arial", 1, 12));
        this.JMIP5SgcPyp.setText("SGC");
        this.JMIP5SgcPyp.setFont(new Font("Arial", 1, 12));
        this.JMIPPyPCasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIPPyPCasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIPPyPCasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.1
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPPyPCasosSGCActionPerformed(evt);
            }
        });
        this.JMIP5SgcPyp.add(this.JMIPPyPCasosSGC);
        this.JMIPPyPRegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIPPyPRegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIPPyPRegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.2
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPPyPRegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIP5SgcPyp.add(this.JMIPPyPRegistroAnalisisNc);
        JMBSigPyP.add(this.JMIP5SgcPyp);
        this.JMSigPyp.setText("SIG");
        this.JMSigPyp.setFont(new Font("Arial", 1, 12));
        this.JMISAtencionesxEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JMISAtencionesxEspecialidad.setText("Atenciones por Especialidad");
        this.JMISAtencionesxEspecialidad.addActionListener(new ActionListener() { // from class: Acceso.Menus1.3
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISAtencionesxEspecialidadActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISAtencionesxEspecialidad);
        this.JMISPolimedicadoxTipoF.setFont(new Font("Arial", 1, 12));
        this.JMISPolimedicadoxTipoF.setText("Formulación por Tipo de Fórmula");
        this.JMISPolimedicadoxTipoF.addActionListener(new ActionListener() { // from class: Acceso.Menus1.4
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISPolimedicadoxTipoFActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISPolimedicadoxTipoF);
        this.JMISCitasPxEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JMISCitasPxEspecialidad.setText("Citas Programadas por Especialidad");
        this.JMISCitasPxEspecialidad.addActionListener(new ActionListener() { // from class: Acceso.Menus1.5
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISCitasPxEspecialidadActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISCitasPxEspecialidad);
        this.JMISInfCardiovascular.setFont(new Font("Arial", 1, 12));
        this.JMISInfCardiovascular.setText("Información Cardiovascular");
        this.JMISInfCardiovascular.addActionListener(new ActionListener() { // from class: Acceso.Menus1.6
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISInfCardiovascularActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISInfCardiovascular);
        this.JMISInfCronicosEps.setFont(new Font("Arial", 1, 12));
        this.JMISInfCronicosEps.setText("Información Crónicos Colmedica");
        this.JMISInfCronicosEps.addActionListener(new ActionListener() { // from class: Acceso.Menus1.7
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISInfCronicosEpsActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISInfCronicosEps);
        this.JMIPPyPRiesgoCV.setFont(new Font("Arial", 1, 12));
        this.JMIPPyPRiesgoCV.setText("Información Riesgo Cardiovascular");
        this.JMIPPyPRiesgoCV.addActionListener(new ActionListener() { // from class: Acceso.Menus1.8
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPPyPRiesgoCVActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPPyPRiesgoCV);
        this.JMISInformeEps.setFont(new Font("Arial", 1, 12));
        this.JMISInformeEps.setText("Informe por eps");
        this.JMISInformeEps.addActionListener(new ActionListener() { // from class: Acceso.Menus1.9
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISInformeEpsActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISInformeEps);
        this.JMIPSResolucion256.setFont(new Font("Arial", 1, 12));
        this.JMIPSResolucion256.setText("Informe Resolución 256");
        this.JMIPSResolucion256.addActionListener(new ActionListener() { // from class: Acceso.Menus1.10
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSResolucion256ActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSResolucion256);
        this.JMIPSResolucion2175.setFont(new Font("Arial", 1, 12));
        this.JMIPSResolucion2175.setText("Informe Resolución 2175");
        this.JMIPSResolucion2175.addActionListener(new ActionListener() { // from class: Acceso.Menus1.11
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSResolucion2175ActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSResolucion2175);
        this.JMIPSResolucion4505.setFont(new Font("Arial", 1, 12));
        this.JMIPSResolucion4505.setText("Informe Resolución 4505");
        this.JMIPSResolucion4505.addActionListener(new ActionListener() { // from class: Acceso.Menus1.12
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSResolucion4505ActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSResolucion4505);
        this.JMIPSResolucion202.setFont(new Font("Arial", 1, 12));
        this.JMIPSResolucion202.setText("Informe Resolución 202");
        this.JMIPSResolucion202.addActionListener(new ActionListener() { // from class: Acceso.Menus1.13
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSResolucion202ActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSResolucion202);
        this.JMIPSResolucion1552.setFont(new Font("Arial", 1, 12));
        this.JMIPSResolucion1552.setText("Informe Resolución 1552");
        this.JMIPSResolucion1552.addActionListener(new ActionListener() { // from class: Acceso.Menus1.14
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSResolucion1552ActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSResolucion1552);
        this.JMISegCyD.setFont(new Font("Arial", 1, 12));
        this.JMISegCyD.setText("Informe Seg. Programa de Salud Infantil");
        this.JMISegCyD.addActionListener(new ActionListener() { // from class: Acceso.Menus1.15
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISegCyDActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISegCyD);
        this.JMISInfPatologiasAs.setFont(new Font("Arial", 1, 12));
        this.JMISInfPatologiasAs.setText("Patologías Asociadas");
        this.JMISInfPatologiasAs.addActionListener(new ActionListener() { // from class: Acceso.Menus1.16
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISInfPatologiasAsActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISInfPatologiasAs);
        this.JMBSPyPCaCervix.setText("Programa Ca Cervix");
        this.JMBSPyPCaCervix.setFont(new Font("Arial", 1, 12));
        this.JMIRCaCervix1.setText("Informe de Citologías");
        this.JMIRCaCervix1.addActionListener(new ActionListener() { // from class: Acceso.Menus1.17
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIRCaCervix1ActionPerformed(evt);
            }
        });
        this.JMBSPyPCaCervix.add(this.JMIRCaCervix1);
        this.JMSigPyp.add(this.JMBSPyPCaCervix);
        this.JMISInformacionCove.setFont(new Font("Arial", 1, 12));
        this.JMISInformacionCove.setText("Reporte de Gestión de Riesgo");
        this.JMISInformacionCove.addActionListener(new ActionListener() { // from class: Acceso.Menus1.18
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISInformacionCoveActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISInformacionCove);
        this.JMIPSIREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIPSIREncuesta.setText("Resultado de Encuestas");
        this.JMIPSIREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.19
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSIREncuestaActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSIREncuesta);
        this.JMISResultadoLabProc.setFont(new Font("Arial", 1, 12));
        this.JMISResultadoLabProc.setText("Resultados de Exámenes por Procedimiento");
        this.JMISResultadoLabProc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.20
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISResultadoLabProcActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISResultadoLabProc);
        this.JMISMultivitaminico.setFont(new Font("Arial", 1, 12));
        this.JMISMultivitaminico.setText("Suministro Multivitamínicos");
        this.JMISMultivitaminico.addActionListener(new ActionListener() { // from class: Acceso.Menus1.21
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISMultivitaminicoActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISMultivitaminico);
        this.JMIPSIUsuariosxActividad.setFont(new Font("Arial", 1, 12));
        this.JMIPSIUsuariosxActividad.setText("Usuario por Actividad");
        this.JMIPSIUsuariosxActividad.addActionListener(new ActionListener() { // from class: Acceso.Menus1.22
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSIUsuariosxActividadActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMIPSIUsuariosxActividad);
        this.JMISUsuariosxPrograma.setFont(new Font("Arial", 1, 12));
        this.JMISUsuariosxPrograma.setText("Usuario por Programa");
        this.JMISUsuariosxPrograma.addActionListener(new ActionListener() { // from class: Acceso.Menus1.23
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISUsuariosxProgramaActionPerformed(evt);
            }
        });
        this.JMSigPyp.add(this.JMISUsuariosxPrograma);
        JMBSigPyP.add(this.JMSigPyp);
        this.JMIPyPUtilidades.setText("Utilidades");
        this.JMIPyPUtilidades.setFont(new Font("Arial", 1, 12));
        JMBSigPyP.add(this.JMIPyPUtilidades);
        JMBSgcP5.setFont(new Font("Arial", 1, 12));
        this.JMIP5Sgc.setText("SGC");
        this.JMIP5Sgc.setFont(new Font("Arial", 1, 12));
        this.JMIP5CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP5CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP5CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.24
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5CasosSGCActionPerformed(evt);
            }
        });
        this.JMIP5Sgc.add(this.JMIP5CasosSGC);
        this.JMIP5Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP5Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP5Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.25
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIP5Sgc.add(this.JMIP5Ficha5w1h);
        this.JMIP5RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP5RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP5RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.26
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIP5Sgc.add(this.JMIP5RegistroAnalisisNc);
        JMBSgcP5.add(this.JMIP5Sgc);
        this.JMIP5Informes.setText("SIG");
        this.JMIP5Informes.setFont(new Font("Arial", 1, 12));
        this.JMIP5IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP5IREncuesta.setText("Resultado de Encuestas");
        this.JMIP5IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.27
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5IREncuestaActionPerformed(evt);
            }
        });
        this.JMIP5Informes.add(this.JMIP5IREncuesta);
        JMBSgcP5.add(this.JMIP5Informes);
        this.JMIP5Utilidades.setText("Utilidades");
        this.JMIP5Utilidades.setFont(new Font("Arial", 1, 12));
        this.JMP5Solicitudes.setText("Solicitud");
        this.JMP5Solicitudes.setFont(new Font("Arial", 1, 12));
        this.JMIP5SAutorizar.setFont(new Font("Arial", 1, 12));
        this.JMIP5SAutorizar.setText("Autorizar");
        this.JMIP5SAutorizar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.28
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5SAutorizarActionPerformed(evt);
            }
        });
        this.JMP5Solicitudes.add(this.JMIP5SAutorizar);
        this.JMIP5SGestionar.setFont(new Font("Arial", 1, 12));
        this.JMIP5SGestionar.setText("Gestionar");
        this.JMIP5SGestionar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.29
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5SGestionarActionPerformed(evt);
            }
        });
        this.JMP5Solicitudes.add(this.JMIP5SGestionar);
        this.JMIP5SConsolidadoS.setFont(new Font("Arial", 1, 12));
        this.JMIP5SConsolidadoS.setText("Información Consolidada");
        this.JMIP5SConsolidadoS.addActionListener(new ActionListener() { // from class: Acceso.Menus1.30
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP5SConsolidadoSActionPerformed(evt);
            }
        });
        this.JMP5Solicitudes.add(this.JMIP5SConsolidadoS);
        this.JMIP5Utilidades.add(this.JMP5Solicitudes);
        JMBSgcP5.add(this.JMIP5Utilidades);
        JMBSgcP16.setFont(new Font("Arial", 1, 12));
        this.JMIP16Sgc.setText("SGC");
        this.JMIP16Sgc.setFont(new Font("Arial", 1, 12));
        this.JMIP16CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP16CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP16CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.31
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16CasosSGCActionPerformed(evt);
            }
        });
        this.JMIP16Sgc.add(this.JMIP16CasosSGC);
        this.JMIP16Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP16Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP16Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.32
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIP16Sgc.add(this.JMIP16Ficha5w1h);
        this.JMIP16RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP16RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP16RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.33
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIP16Sgc.add(this.JMIP16RegistroAnalisisNc);
        JMBSgcP16.add(this.JMIP16Sgc);
        this.JMIP16Informes.setText("SIG");
        this.JMIP16Informes.setFont(new Font("Arial", 1, 12));
        this.JMIP16IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP16IREncuesta.setText("Resultado de Encuestas");
        this.JMIP16IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.34
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16IREncuestaActionPerformed(evt);
            }
        });
        this.JMIP16Informes.add(this.JMIP16IREncuesta);
        JMBSgcP16.add(this.JMIP16Informes);
        this.JMIP16Utilidades.setText("Utilidades");
        this.JMIP16Utilidades.setFont(new Font("Arial", 1, 12));
        this.JMP16Solicitudes.setText("Solicitud");
        this.JMP16Solicitudes.setFont(new Font("Arial", 1, 12));
        this.JMIP16Autorizar.setFont(new Font("Arial", 1, 12));
        this.JMIP16Autorizar.setText("Autorizar");
        this.JMIP16Autorizar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.35
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16AutorizarActionPerformed(evt);
            }
        });
        this.JMP16Solicitudes.add(this.JMIP16Autorizar);
        this.JMIP16SGestionar.setFont(new Font("Arial", 1, 12));
        this.JMIP16SGestionar.setText("Gestionar");
        this.JMIP16SGestionar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.36
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP16SGestionarActionPerformed(evt);
            }
        });
        this.JMP16Solicitudes.add(this.JMIP16SGestionar);
        this.JMIP16Utilidades.add(this.JMP16Solicitudes);
        JMBSgcP16.add(this.JMIP16Utilidades);
        JMBSgcP1.setFont(new Font("Arial", 1, 12));
        this.JMIP1Sgc.setText("SGC");
        this.JMIP1Sgc.setFont(new Font("Arial", 1, 12));
        this.JMIP1CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP1CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP1CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.37
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1CasosSGCActionPerformed(evt);
            }
        });
        this.JMIP1Sgc.add(this.JMIP1CasosSGC);
        this.JMIP1Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP1Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP1Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.38
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIP1Sgc.add(this.JMIP1Ficha5w1h);
        this.JMIP1RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP1RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP1RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.39
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIP1Sgc.add(this.JMIP1RegistroAnalisisNc);
        JMBSgcP1.add(this.JMIP1Sgc);
        this.JMIP1Informes.setText("SIG");
        this.JMIP1Informes.setFont(new Font("Arial", 1, 12));
        this.JMIP1IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP1IREncuesta.setText("Resultado de Encuestas");
        this.JMIP1IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.40
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1IREncuestaActionPerformed(evt);
            }
        });
        this.JMIP1Informes.add(this.JMIP1IREncuesta);
        JMBSgcP1.add(this.JMIP1Informes);
        this.JMIP1Utilidades.setText("Utilidades");
        this.JMIP1Utilidades.setFont(new Font("Arial", 1, 12));
        this.JMP1Solicitudes.setText("Solicitud");
        this.JMP1Solicitudes.setFont(new Font("Arial", 1, 12));
        this.JMIP1SAutorizar.setFont(new Font("Arial", 1, 12));
        this.JMIP1SAutorizar.setText("Autorizar");
        this.JMIP1SAutorizar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.41
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1SAutorizarActionPerformed(evt);
            }
        });
        this.JMP1Solicitudes.add(this.JMIP1SAutorizar);
        this.JMIP1SGestionar.setFont(new Font("Arial", 1, 12));
        this.JMIP1SGestionar.setText("Gestionar");
        this.JMIP1SGestionar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.42
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP1SGestionarActionPerformed(evt);
            }
        });
        this.JMP1Solicitudes.add(this.JMIP1SGestionar);
        this.JMIP1Utilidades.add(this.JMP1Solicitudes);
        JMBSgcP1.add(this.JMIP1Utilidades);
        JMBSgcP2.setFont(new Font("Arial", 1, 12));
        this.JMIP2Sgc.setText("SGC");
        this.JMIP2Sgc.setFont(new Font("Arial", 1, 12));
        this.JMIP2Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP2Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP2Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.43
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIP2Sgc.add(this.JMIP2Ficha5w1h);
        this.JMIP2RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP2RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP2RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.44
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIP2Sgc.add(this.JMIP2RegistroAnalisisNc);
        this.JMIP2RegistroIndicadores.setFont(new Font("Arial", 1, 12));
        this.JMIP2RegistroIndicadores.setText("Registro de Indicadores");
        this.JMIP2RegistroIndicadores.addActionListener(new ActionListener() { // from class: Acceso.Menus1.45
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2RegistroIndicadoresActionPerformed(evt);
            }
        });
        this.JMIP2Sgc.add(this.JMIP2RegistroIndicadores);
        JMBSgcP2.add(this.JMIP2Sgc);
        this.JMIP2Informes.setText("SIG");
        this.JMIP2Informes.setFont(new Font("Arial", 1, 12));
        this.JMIP2IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP2IREncuesta.setText("Resultado de Encuestas");
        this.JMIP2IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.46
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2IREncuestaActionPerformed(evt);
            }
        });
        this.JMIP2Informes.add(this.JMIP2IREncuesta);
        this.JMIP2IConsolidadoEventosA.setFont(new Font("Arial", 1, 12));
        this.JMIP2IConsolidadoEventosA.setText("Informe Consolidado Casos Seguridad Clinica");
        this.JMIP2IConsolidadoEventosA.addActionListener(new ActionListener() { // from class: Acceso.Menus1.47
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2IConsolidadoEventosAActionPerformed(evt);
            }
        });
        this.JMIP2Informes.add(this.JMIP2IConsolidadoEventosA);
        JMBSgcP2.add(this.JMIP2Informes);
        this.JMIP2Utilidades.setText("Utilidades");
        this.JMIP2Utilidades.setFont(new Font("Arial", 1, 12));
        this.JMIP2G_AnalasisEventoA.setFont(new Font("Arial", 1, 12));
        this.JMIP2G_AnalasisEventoA.setText("Análisis de Casos: Seguridad Clinica");
        this.JMIP2G_AnalasisEventoA.addActionListener(new ActionListener() { // from class: Acceso.Menus1.48
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2G_AnalasisEventoAActionPerformed(evt);
            }
        });
        this.JMIP2Utilidades.add(this.JMIP2G_AnalasisEventoA);
        this.JMIP2GFicha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP2GFicha5w1h.setText("Gestión Ficha 5w1h");
        this.JMIP2GFicha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.49
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2GFicha5w1hActionPerformed(evt);
            }
        });
        this.JMIP2Utilidades.add(this.JMIP2GFicha5w1h);
        this.JMIP2Nc.setFont(new Font("Arial", 1, 12));
        this.JMIP2Nc.setText("Revisar Reportes NC");
        this.JMIP2Nc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.50
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2NcActionPerformed(evt);
            }
        });
        this.JMIP2Utilidades.add(this.JMIP2Nc);
        this.JMP2Solicitudes.setText("Solicitud");
        this.JMP2Solicitudes.setFont(new Font("Arial", 1, 12));
        this.JMIP2SAutorizar.setFont(new Font("Arial", 1, 12));
        this.JMIP2SAutorizar.setText("Autorizar");
        this.JMIP2SAutorizar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.51
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2SAutorizarActionPerformed(evt);
            }
        });
        this.JMP2Solicitudes.add(this.JMIP2SAutorizar);
        this.JMIP2SGestionar.setFont(new Font("Arial", 1, 12));
        this.JMIP2SGestionar.setText("Gestionar");
        this.JMIP2SGestionar.addActionListener(new ActionListener() { // from class: Acceso.Menus1.52
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP2SGestionarActionPerformed(evt);
            }
        });
        this.JMP2Solicitudes.add(this.JMIP2SGestionar);
        this.JMIP2Utilidades.add(this.JMP2Solicitudes);
        JMBSgcP2.add(this.JMIP2Utilidades);
        JMBSgcP3.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc3.setText("SGC");
        this.JMIPSgc3.setFont(new Font("Arial", 1, 12));
        this.JMIP3CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP3CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP3CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.53
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP3CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc3.add(this.JMIP3CasosSGC);
        this.JMIP3Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP3Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP3Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.54
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP3Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc3.add(this.JMIP3Ficha5w1h);
        this.JMIP3RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP3RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP3RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.55
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP3RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc3.add(this.JMIP3RegistroAnalisisNc);
        JMBSgcP3.add(this.JMIPSgc3);
        this.JMIPInformes3.setText("SIG");
        this.JMIPInformes3.setFont(new Font("Arial", 1, 12));
        this.JMIP3IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP3IREncuesta.setText("Resultado de Encuestas");
        this.JMIP3IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.56
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP3IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes3.add(this.JMIP3IREncuesta);
        JMBSgcP3.add(this.JMIPInformes3);
        this.JMIPUtilidades3.setText("Utilidades");
        this.JMIPUtilidades3.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes3.setText("Solicitud");
        this.JMPSolicitudes3.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar3.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar3.setText("Autorizar");
        this.JMIPSAutorizar3.addActionListener(new ActionListener() { // from class: Acceso.Menus1.57
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar3ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes3.add(this.JMIPSAutorizar3);
        this.JMIPSGestionar3.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar3.setText("Gestionar");
        this.JMIPSGestionar3.addActionListener(new ActionListener() { // from class: Acceso.Menus1.58
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar3ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes3.add(this.JMIPSGestionar3);
        this.JMIPUtilidades3.add(this.JMPSolicitudes3);
        JMBSgcP3.add(this.JMIPUtilidades3);
        JMBSgcP4.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc4.setText("SGC");
        this.JMIPSgc4.setFont(new Font("Arial", 1, 12));
        this.JMIP4CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP4CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP4CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.59
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP4CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc4.add(this.JMIP4CasosSGC);
        this.JMIP4Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP4Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP4Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.60
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP4Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc4.add(this.JMIP4Ficha5w1h);
        this.JMIP4RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP4RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP4RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.61
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP4RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc4.add(this.JMIP4RegistroAnalisisNc);
        JMBSgcP4.add(this.JMIPSgc4);
        this.JMIPInformes4.setText("SIG");
        this.JMIPInformes4.setFont(new Font("Arial", 1, 12));
        this.JMIP4IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP4IREncuesta.setText("Resultado de Encuestas");
        this.JMIP4IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.62
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP4IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes4.add(this.JMIP4IREncuesta);
        JMBSgcP4.add(this.JMIPInformes4);
        this.JMIPUtilidades4.setText("Utilidades");
        this.JMIPUtilidades4.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes4.setText("Solicitud");
        this.JMPSolicitudes4.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar4.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar4.setText("Autorizar");
        this.JMIPSAutorizar4.addActionListener(new ActionListener() { // from class: Acceso.Menus1.63
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar4ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes4.add(this.JMIPSAutorizar4);
        this.JMIPSGestionar4.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar4.setText("Gestionar");
        this.JMIPSGestionar4.addActionListener(new ActionListener() { // from class: Acceso.Menus1.64
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar4ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes4.add(this.JMIPSGestionar4);
        this.JMIPUtilidades4.add(this.JMPSolicitudes4);
        JMBSgcP4.add(this.JMIPUtilidades4);
        JMBSgcP6.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc6.setText("SGC");
        this.JMIPSgc6.setFont(new Font("Arial", 1, 12));
        this.JMIP6CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP6CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP6CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.65
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc6.add(this.JMIP6CasosSGC);
        this.JMIP6Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP6Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP6Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.66
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc6.add(this.JMIP6Ficha5w1h);
        this.JMIP6RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP6RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP6RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.67
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc6.add(this.JMIP6RegistroAnalisisNc);
        JMBSgcP6.add(this.JMIPSgc6);
        this.JMIPSigs6.setText("SIG");
        this.JMIPSigs6.setFont(new Font("Arial", 1, 12));
        this.JMP6Admisiones.setText("Admisión");
        this.JMP6Admisiones.setFont(new Font("Arial", 1, 12));
        this.JMIP6IConsultarUsuarioInactivos.setFont(new Font("Arial", 1, 12));
        this.JMIP6IConsultarUsuarioInactivos.setText("Consultar Usuarios Inactivos");
        this.JMIP6IConsultarUsuarioInactivos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.68
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IConsultarUsuarioInactivosActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIP6IConsultarUsuarioInactivos);
        this.JMIPTiempoFacCons.setFont(new Font("Arial", 1, 12));
        this.JMIPTiempoFacCons.setText("Facturación - Atención Médica Programada");
        this.JMIPTiempoFacCons.addActionListener(new ActionListener() { // from class: Acceso.Menus1.69
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPTiempoFacConsActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIPTiempoFacCons);
        this.JMIP6IFormaAsigCitas.setFont(new Font("Arial", 1, 12));
        this.JMIP6IFormaAsigCitas.setText("Forma de Asignación Citas");
        this.JMIP6IFormaAsigCitas.addActionListener(new ActionListener() { // from class: Acceso.Menus1.70
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IFormaAsigCitasActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIP6IFormaAsigCitas);
        this.JMIP6IConsultarVProfesional.setFont(new Font("Arial", 1, 12));
        this.JMIP6IConsultarVProfesional.setText("Información Cita x Especialidad");
        this.JMIP6IConsultarVProfesional.addActionListener(new ActionListener() { // from class: Acceso.Menus1.71
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IConsultarVProfesionalActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIP6IConsultarVProfesional);
        this.JMIP6ICCitasSaludOcupacional.setFont(new Font("Arial", 1, 12));
        this.JMIP6ICCitasSaludOcupacional.setText("Información Salud Ocupacional");
        this.JMIP6ICCitasSaludOcupacional.addActionListener(new ActionListener() { // from class: Acceso.Menus1.72
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ICCitasSaludOcupacionalActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIP6ICCitasSaludOcupacional);
        this.JMIP6IRemisionesxProfesional.setFont(new Font("Arial", 1, 12));
        this.JMIP6IRemisionesxProfesional.setText("Remisiones por Profesional");
        this.JMIP6IRemisionesxProfesional.addActionListener(new ActionListener() { // from class: Acceso.Menus1.73
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IRemisionesxProfesionalActionPerformed(evt);
            }
        });
        this.JMP6Admisiones.add(this.JMIP6IRemisionesxProfesional);
        this.JMIPSigs6.add(this.JMP6Admisiones);
        this.JMP6AuditoriaHC.setText("Auditoria Historia Clínica");
        this.JMP6AuditoriaHC.setFont(new Font("Arial", 1, 12));
        this.JMIP6AHEnfermera.setFont(new Font("Arial", 1, 12));
        this.JMIP6AHEnfermera.setText("Enfermera");
        this.JMIP6AHEnfermera.addActionListener(new ActionListener() { // from class: Acceso.Menus1.74
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6AHEnfermeraActionPerformed(evt);
            }
        });
        this.JMP6AuditoriaHC.add(this.JMIP6AHEnfermera);
        this.JMIP6AHMedicos.setFont(new Font("Arial", 1, 12));
        this.JMIP6AHMedicos.setText("Médica");
        this.JMIP6AHMedicos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.75
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6AHMedicosActionPerformed(evt);
            }
        });
        this.JMP6AuditoriaHC.add(this.JMIP6AHMedicos);
        this.JMIPSigs6.add(this.JMP6AuditoriaHC);
        this.JMICCronicos.setFont(new Font("Arial", 1, 12));
        this.JMICCronicos.setText("Consultadores Crónicos por Especialidad");
        this.JMICCronicos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.76
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMICCronicosActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMICCronicos);
        this.JMIP6ConsultrarAlertas.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarAlertas.setText("Consultar Alertas Parametrizadas");
        this.JMIP6ConsultrarAlertas.addActionListener(new ActionListener() { // from class: Acceso.Menus1.77
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarAlertasActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMIP6ConsultrarAlertas);
        this.JMIP6IRDemandaNA.setFont(new Font("Arial", 1, 12));
        this.JMIP6IRDemandaNA.setText("Demandas NO Atendidas");
        this.JMIP6IRDemandaNA.addActionListener(new ActionListener() { // from class: Acceso.Menus1.78
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IRDemandaNAActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMIP6IRDemandaNA);
        this.JMIP6IRIncapacidad.setFont(new Font("Arial", 1, 12));
        this.JMIP6IRIncapacidad.setText("Generación Incapacidades");
        this.JMIP6IRIncapacidad.addActionListener(new ActionListener() { // from class: Acceso.Menus1.79
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IRIncapacidadActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMIP6IRIncapacidad);
        this.JMP6EMorbilidad.setText("Estadística de Morbilidad");
        this.JMP6EMorbilidad.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarFisioterapia.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarFisioterapia.setText("Fisioterapia");
        this.JMIP6ConsultrarFisioterapia.addActionListener(new ActionListener() { // from class: Acceso.Menus1.80
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarFisioterapiaActionPerformed(evt);
            }
        });
        this.JMP6EMorbilidad.add(this.JMIP6ConsultrarFisioterapia);
        this.JMIP6ConsultrarMorbilidadG.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarMorbilidadG.setText("General");
        this.JMIP6ConsultrarMorbilidadG.addActionListener(new ActionListener() { // from class: Acceso.Menus1.81
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarMorbilidadGActionPerformed(evt);
            }
        });
        this.JMP6EMorbilidad.add(this.JMIP6ConsultrarMorbilidadG);
        this.JMIP6ConsultrarMorbilidadGEdades.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarMorbilidadGEdades.setText("General por edades");
        this.JMIP6ConsultrarMorbilidadGEdades.addActionListener(new ActionListener() { // from class: Acceso.Menus1.82
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarMorbilidadGEdadesActionPerformed(evt);
            }
        });
        this.JMP6EMorbilidad.add(this.JMIP6ConsultrarMorbilidadGEdades);
        this.JMIP6ConsultrarMorbilidadGSexo.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarMorbilidadGSexo.setText("General por sexo");
        this.JMIP6ConsultrarMorbilidadGSexo.addActionListener(new ActionListener() { // from class: Acceso.Menus1.83
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarMorbilidadGSexoActionPerformed(evt);
            }
        });
        this.JMP6EMorbilidad.add(this.JMIP6ConsultrarMorbilidadGSexo);
        this.JMIP6ConsultrarMorbilidadGSexoEdades.setFont(new Font("Arial", 1, 12));
        this.JMIP6ConsultrarMorbilidadGSexoEdades.setText("General por sexo y edad");
        this.JMIP6ConsultrarMorbilidadGSexoEdades.addActionListener(new ActionListener() { // from class: Acceso.Menus1.84
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ConsultrarMorbilidadGSexoEdadesActionPerformed(evt);
            }
        });
        this.JMP6EMorbilidad.add(this.JMIP6ConsultrarMorbilidadGSexoEdades);
        this.JMIPSigs6.add(this.JMP6EMorbilidad);
        this.JMIP6ICCitasSaludOcupacional1.setFont(new Font("Arial", 1, 12));
        this.JMIP6ICCitasSaludOcupacional1.setText("Informe de Incapacidades");
        this.JMIP6ICCitasSaludOcupacional1.addActionListener(new ActionListener() { // from class: Acceso.Menus1.85
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ICCitasSaludOcupacional1ActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMIP6ICCitasSaludOcupacional1);
        this.JMP6Nutricion.setText("Nutrición");
        this.JMP6Nutricion.setFont(new Font("Arial", 1, 12));
        this.JMNIActualizarRef.setFont(new Font("Arial", 1, 12));
        this.JMNIActualizarRef.setText("Actualizar Referencia de Consulta");
        this.JMNIActualizarRef.addActionListener(new ActionListener() { // from class: Acceso.Menus1.86
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMNIActualizarRefActionPerformed1(evt);
            }
        });
        this.JMP6Nutricion.add(this.JMNIActualizarRef);
        this.JMNIConsInfo.setFont(new Font("Arial", 1, 12));
        this.JMNIConsInfo.setText("Consolidado de Información");
        this.JMNIConsInfo.addActionListener(new ActionListener() { // from class: Acceso.Menus1.87
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMNIConsInfoActionPerformed1(evt);
            }
        });
        this.JMP6Nutricion.add(this.JMNIConsInfo);
        this.JMIP6ICInformacionImcS.setFont(new Font("Arial", 1, 12));
        this.JMIP6ICInformacionImcS.setText("Consultar Atenciones IMC>30");
        this.JMIP6ICInformacionImcS.addActionListener(new ActionListener() { // from class: Acceso.Menus1.88
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ICInformacionImcSActionPerformed(evt);
            }
        });
        this.JMP6Nutricion.add(this.JMIP6ICInformacionImcS);
        this.JMIP6ICReporte1.setFont(new Font("Arial", 1, 12));
        this.JMIP6ICReporte1.setText("Consultar Reduccion y/o Aumento de Peso");
        this.JMIP6ICReporte1.addActionListener(new ActionListener() { // from class: Acceso.Menus1.89
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ICReporte1ActionPerformed(evt);
            }
        });
        this.JMP6Nutricion.add(this.JMIP6ICReporte1);
        this.JMIP6ICPrepararPR.setFont(new Font("Arial", 1, 12));
        this.JMIP6ICPrepararPR.setText("Preparar Referencia de Consulta");
        this.JMIP6ICPrepararPR.addActionListener(new ActionListener() { // from class: Acceso.Menus1.90
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ICPrepararPRActionPerformed(evt);
            }
        });
        this.JMP6Nutricion.add(this.JMIP6ICPrepararPR);
        this.JMIPSigs6.add(this.JMP6Nutricion);
        this.JMP6Odontologia.setText("Odontología");
        this.JMP6Odontologia.setFont(new Font("Arial", 1, 12));
        this.JMIP6Tratamientos.setFont(new Font("Arial", 1, 12));
        this.JMIP6Tratamientos.setText("Informe Tratamientos");
        this.JMIP6Tratamientos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.91
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6TratamientosActionPerformed(evt);
            }
        });
        this.JMP6Odontologia.add(this.JMIP6Tratamientos);
        this.JMIPSigs6.add(this.JMP6Odontologia);
        this.JMIP6IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP6IREncuesta.setText("Resultado de Encuestas");
        this.JMIP6IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.92
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPSigs6.add(this.JMIP6IREncuesta);
        this.JMP6SaludOcupacional.setText("Salud Ocupacional");
        this.JMP6SaludOcupacional.setFont(new Font("Arial", 1, 12));
        this.JMIP6ReporteCuestionario.setFont(new Font("Arial", 1, 12));
        this.JMIP6ReporteCuestionario.setText("Autoreportes");
        this.JMIP6ReporteCuestionario.addActionListener(new ActionListener() { // from class: Acceso.Menus1.93
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ReporteCuestionarioActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6ReporteCuestionario);
        this.JMPSO_Gestion_Examenes.setText("Gestión de Exámenes");
        this.JMPSO_Gestion_Examenes.setFont(new Font("Arial", 1, 12));
        this.JMIP6RCAtenciones.setFont(new Font("Arial", 1, 12));
        this.JMIP6RCAtenciones.setText("Consolidado de Atenciones ");
        this.JMIP6RCAtenciones.addActionListener(new ActionListener() { // from class: Acceso.Menus1.94
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6RCAtencionesActionPerformed(evt);
            }
        });
        this.JMPSO_Gestion_Examenes.add(this.JMIP6RCAtenciones);
        this.JMP6SaludOcupacional.add(this.JMPSO_Gestion_Examenes);
        this.JMIP6ReporteSicologia.setFont(new Font("Arial", 1, 12));
        this.JMIP6ReporteSicologia.setText("Resultado Batería Sicosocial");
        this.JMIP6ReporteSicologia.addActionListener(new ActionListener() { // from class: Acceso.Menus1.95
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ReporteSicologiaActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6ReporteSicologia);
        this.JMIP6ReporteOMA.setFont(new Font("Arial", 1, 12));
        this.JMIP6ReporteOMA.setText("Reporte NOMA");
        this.JMIP6ReporteOMA.addActionListener(new ActionListener() { // from class: Acceso.Menus1.96
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ReporteOMAActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6ReporteOMA);
        this.JMIP6PRespiratoria.setFont(new Font("Arial", 1, 12));
        this.JMIP6PRespiratoria.setText("Reporte Prueba Respiratoria");
        this.JMIP6PRespiratoria.addActionListener(new ActionListener() { // from class: Acceso.Menus1.97
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6PRespiratoriaActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6PRespiratoria);
        this.JMIP6RTestAuditivo.setFont(new Font("Arial", 1, 12));
        this.JMIP6RTestAuditivo.setText("Reporte Test Auditivo");
        this.JMIP6RTestAuditivo.addActionListener(new ActionListener() { // from class: Acceso.Menus1.98
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6RTestAuditivoActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6RTestAuditivo);
        this.JMIP6PAudiometria.setFont(new Font("Arial", 1, 12));
        this.JMIP6PAudiometria.setText("Reporte Audiometría");
        this.JMIP6PAudiometria.addActionListener(new ActionListener() { // from class: Acceso.Menus1.99
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6PAudiometriaActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6PAudiometria);
        this.JMIP6Espirometria.setFont(new Font("Arial", 1, 12));
        this.JMIP6Espirometria.setText("Reporte Espirometría");
        this.JMIP6Espirometria.addActionListener(new ActionListener() { // from class: Acceso.Menus1.100
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6EspirometriaActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6Espirometria);
        this.JMIP6ReporteSociodem.setFont(new Font("Arial", 1, 12));
        this.JMIP6ReporteSociodem.setText("Reporte Sociodemografico");
        this.JMIP6ReporteSociodem.addActionListener(new ActionListener() { // from class: Acceso.Menus1.101
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ReporteSociodemActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6ReporteSociodem);
        this.JMIP6MedicinaDerporte.setFont(new Font("Arial", 1, 12));
        this.JMIP6MedicinaDerporte.setText("Reporte Medicina del Deporte");
        this.JMIP6MedicinaDerporte.addActionListener(new ActionListener() { // from class: Acceso.Menus1.102
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6MedicinaDerporteActionPerformed(evt);
            }
        });
        this.JMP6SaludOcupacional.add(this.JMIP6MedicinaDerporte);
        this.JMIPSigs6.add(this.JMP6SaludOcupacional);
        this.JMP6TrabajoSocial.setText("Trabajo Social");
        this.JMP6TrabajoSocial.setFont(new Font("Arial", 1, 12));
        this.JMIP6ITSEventosNoDeseados.setFont(new Font("Arial", 1, 12));
        this.JMIP6ITSEventosNoDeseados.setText("Consolidado de Eventos no Deseados");
        this.JMIP6ITSEventosNoDeseados.addActionListener(new ActionListener() { // from class: Acceso.Menus1.103
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP6ITSEventosNoDeseadosActionPerformed(evt);
            }
        });
        this.JMP6TrabajoSocial.add(this.JMIP6ITSEventosNoDeseados);
        this.JMIPSigs6.add(this.JMP6TrabajoSocial);
        JMBSgcP6.add(this.JMIPSigs6);
        this.JMIPUtilidades6.setText("Utilidades");
        this.JMIPUtilidades6.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes6.setText("Solicitud");
        this.JMPSolicitudes6.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar6.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar6.setText("Autorizar");
        this.JMIPSAutorizar6.addActionListener(new ActionListener() { // from class: Acceso.Menus1.104
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar6ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes6.add(this.JMIPSAutorizar6);
        this.JMIPSGestionar6.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar6.setText("Gestionar");
        this.JMIPSGestionar6.addActionListener(new ActionListener() { // from class: Acceso.Menus1.105
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar6ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes6.add(this.JMIPSGestionar6);
        this.JMIPUtilidades6.add(this.JMPSolicitudes6);
        JMBSgcP6.add(this.JMIPUtilidades6);
        JMBSgcP7.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc7.setText("SGC");
        this.JMIPSgc7.setFont(new Font("Arial", 1, 12));
        this.JMIP7CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP7CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP7CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.106
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP7CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc7.add(this.JMIP7CasosSGC);
        this.JMIP7Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP7Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP7Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.107
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP7Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc7.add(this.JMIP7Ficha5w1h);
        this.JMIP7RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP7RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP7RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.108
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP7RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc7.add(this.JMIP7RegistroAnalisisNc);
        JMBSgcP7.add(this.JMIPSgc7);
        this.JMIPInformes7.setText("SIG");
        this.JMIPInformes7.setFont(new Font("Arial", 1, 12));
        this.JMIP7IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP7IREncuesta.setText("Resultado de Encuestas");
        this.JMIP7IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.109
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP7IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes7.add(this.JMIP7IREncuesta);
        JMBSgcP7.add(this.JMIPInformes7);
        this.JMIPUtilidades7.setText("Utilidades");
        this.JMIPUtilidades7.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes7.setText("Solicitud");
        this.JMPSolicitudes7.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar7.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar7.setText("Autorizar");
        this.JMIPSAutorizar7.addActionListener(new ActionListener() { // from class: Acceso.Menus1.110
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar7ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes7.add(this.JMIPSAutorizar7);
        this.JMIPSGestionar7.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar7.setText("Gestionar");
        this.JMIPSGestionar7.addActionListener(new ActionListener() { // from class: Acceso.Menus1.111
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar7ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes7.add(this.JMIPSGestionar7);
        this.JMIPUtilidades7.add(this.JMPSolicitudes7);
        JMBSgcP7.add(this.JMIPUtilidades7);
        JMBSgcP8.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc8.setText("SGC");
        this.JMIPSgc8.setFont(new Font("Arial", 1, 12));
        this.JMIP8CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP8CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP8CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.112
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP8CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc8.add(this.JMIP8CasosSGC);
        this.JMIP8Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP8Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP8Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.113
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP8Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc8.add(this.JMIP8Ficha5w1h);
        this.JMIP8RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP8RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP8RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.114
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP8RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc8.add(this.JMIP8RegistroAnalisisNc);
        JMBSgcP8.add(this.JMIPSgc8);
        this.JMIPInformes8.setText("SIG");
        this.JMIPInformes8.setFont(new Font("Arial", 1, 12));
        this.JMIP8IREncuesta9.setFont(new Font("Arial", 1, 12));
        this.JMIP8IREncuesta9.setText("Resultado de Encuestas");
        this.JMIP8IREncuesta9.addActionListener(new ActionListener() { // from class: Acceso.Menus1.115
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP8IREncuesta9ActionPerformed(evt);
            }
        });
        this.JMIPInformes8.add(this.JMIP8IREncuesta9);
        JMBSgcP8.add(this.JMIPInformes8);
        this.JMIPUtilidades8.setText("Utilidades");
        this.JMIPUtilidades8.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes8.setText("Solicitud");
        this.JMPSolicitudes8.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar8.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar8.setText("Autorizar");
        this.JMIPSAutorizar8.addActionListener(new ActionListener() { // from class: Acceso.Menus1.116
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar8ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes8.add(this.JMIPSAutorizar8);
        this.JMIPSGestionar8.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar8.setText("Gestionar");
        this.JMIPSGestionar8.addActionListener(new ActionListener() { // from class: Acceso.Menus1.117
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar8ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes8.add(this.JMIPSGestionar8);
        this.JMIPUtilidades8.add(this.JMPSolicitudes8);
        JMBSgcP8.add(this.JMIPUtilidades8);
        JMBSgcP9.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc9.setText("SGC");
        this.JMIPSgc9.setFont(new Font("Arial", 1, 12));
        this.JMIP9CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP9CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP9CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.118
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc9.add(this.JMIP9CasosSGC);
        this.JMIP9Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP9Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP9Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.119
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc9.add(this.JMIP9Ficha5w1h);
        this.JMIP9RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP9RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP9RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.120
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc9.add(this.JMIP9RegistroAnalisisNc);
        JMBSgcP9.add(this.JMIPSgc9);
        this.JMIPInformes9.setText("SIG");
        this.JMIPInformes9.setFont(new Font("Arial", 1, 12));
        this.JMIP9AuditoriaTriage.setFont(new Font("Arial", 1, 12));
        this.JMIP9AuditoriaTriage.setText("Auditoria de Triage");
        this.JMIP9AuditoriaTriage.addActionListener(new ActionListener() { // from class: Acceso.Menus1.121
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9AuditoriaTriageActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP9AuditoriaTriage);
        this.JMIP9ICTiemposA.setFont(new Font("Arial", 1, 12));
        this.JMIP9ICTiemposA.setText("Consolidado Tiempos de Atención");
        this.JMIP9ICTiemposA.addActionListener(new ActionListener() { // from class: Acceso.Menus1.122
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9ICTiemposAActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP9ICTiemposA);
        this.JMIP9ICEstadoAsign.setFont(new Font("Arial", 1, 12));
        this.JMIP9ICEstadoAsign.setText("Consultar Estado de Asignaciones de Citas no Programadas");
        this.JMIP9ICEstadoAsign.addActionListener(new ActionListener() { // from class: Acceso.Menus1.123
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9ICEstadoAsignActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP9ICEstadoAsign);
        this.JMIP10IHospitalizados.setFont(new Font("Arial", 1, 12));
        this.JMIP10IHospitalizados.setText("Hospitalizaciones-Remisiones");
        this.JMIP10IHospitalizados.addActionListener(new ActionListener() { // from class: Acceso.Menus1.124
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10IHospitalizadosActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP10IHospitalizados);
        this.JMIP9IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP9IREncuesta.setText("Resultado de Encuestas");
        this.JMIP9IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.125
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP9IREncuesta);
        this.JMIP9IResiduosPeligrosos.setFont(new Font("Arial", 1, 12));
        this.JMIP9IResiduosPeligrosos.setText("Residuos Peligrosos");
        this.JMIP9IResiduosPeligrosos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.126
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP9IResiduosPeligrososActionPerformed(evt);
            }
        });
        this.JMIPInformes9.add(this.JMIP9IResiduosPeligrosos);
        JMBSgcP9.add(this.JMIPInformes9);
        this.JMIPUtilidades9.setText("Utilidades");
        this.JMIPUtilidades9.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes9.setText("Solicitud");
        this.JMPSolicitudes9.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar9.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar9.setText("Autorizar");
        this.JMIPSAutorizar9.addActionListener(new ActionListener() { // from class: Acceso.Menus1.127
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar9ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes9.add(this.JMIPSAutorizar9);
        this.JMIPSGestionar9.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar9.setText("Gestionar");
        this.JMIPSGestionar9.addActionListener(new ActionListener() { // from class: Acceso.Menus1.128
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar9ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes9.add(this.JMIPSGestionar9);
        this.JMIPUtilidades9.add(this.JMPSolicitudes9);
        JMBSgcP9.add(this.JMIPUtilidades9);
        JMBSgcP10.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc10.setText("SGC");
        this.JMIPSgc10.setFont(new Font("Arial", 1, 12));
        this.JMIP10CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP10CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP10CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.129
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc10.add(this.JMIP10CasosSGC);
        this.JMIP10Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP10Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP10Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.130
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc10.add(this.JMIP10Ficha5w1h);
        this.JMIP10RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP10RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP10RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.131
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc10.add(this.JMIP10RegistroAnalisisNc);
        JMBSgcP10.add(this.JMIPSgc10);
        this.JMIPInformes10.setText("SIG");
        this.JMIPInformes10.setFont(new Font("Arial", 1, 12));
        this.JMIP10IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP10IREncuesta.setText("Resultado de Encuestas");
        this.JMIP10IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.132
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes10.add(this.JMIP10IREncuesta);
        this.JMIP10IResiduosPeligrosos.setFont(new Font("Arial", 1, 12));
        this.JMIP10IResiduosPeligrosos.setText("Residuos Peligrosos");
        this.JMIP10IResiduosPeligrosos.setToolTipText("");
        this.JMIP10IResiduosPeligrosos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.133
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP10IResiduosPeligrososActionPerformed(evt);
            }
        });
        this.JMIPInformes10.add(this.JMIP10IResiduosPeligrosos);
        JMBSgcP10.add(this.JMIPInformes10);
        this.JMIPUtilidades10.setText("Utilidades");
        this.JMIPUtilidades10.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes10.setText("Solicitud");
        this.JMPSolicitudes10.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar10.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar10.setText("Autorizar");
        this.JMIPSAutorizar10.addActionListener(new ActionListener() { // from class: Acceso.Menus1.134
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar10ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes10.add(this.JMIPSAutorizar10);
        this.JMIPSGestionar10.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar10.setText("Gestionar");
        this.JMIPSGestionar10.addActionListener(new ActionListener() { // from class: Acceso.Menus1.135
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar10ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes10.add(this.JMIPSGestionar10);
        this.JMIPUtilidades10.add(this.JMPSolicitudes10);
        JMBSgcP10.add(this.JMIPUtilidades10);
        JMBSgcP11.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc11.setText("SGC");
        this.JMIPSgc11.setFont(new Font("Arial", 1, 12));
        this.JMIP11CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP11CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP11CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.136
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc11.add(this.JMIP11CasosSGC);
        this.JMIP11Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP11Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP11Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.137
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc11.add(this.JMIP11Ficha5w1h);
        this.JMIP11RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP11RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP11RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.138
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc11.add(this.JMIP11RegistroAnalisisNc);
        JMBSgcP11.add(this.JMIPSgc11);
        this.JMIPSig11.setText("SIG");
        this.JMIPSig11.setFont(new Font("Arial", 1, 12));
        this.JMPLaboratorio.setText("Laboratorio");
        this.JMPLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JMISgcP11Lab2.setFont(new Font("Arial", 1, 12));
        this.JMISgcP11Lab2.setText("Estadística de Muestras Recepcionadas");
        this.JMISgcP11Lab2.addActionListener(new ActionListener() { // from class: Acceso.Menus1.139
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISgcP11Lab2ActionPerformed(evt);
            }
        });
        this.JMPLaboratorio.add(this.JMISgcP11Lab2);
        this.JMISgcP11Lab1.setFont(new Font("Arial", 1, 12));
        this.JMISgcP11Lab1.setText("Estadística de Recepciones");
        this.JMISgcP11Lab1.addActionListener(new ActionListener() { // from class: Acceso.Menus1.140
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISgcP11Lab1ActionPerformed(evt);
            }
        });
        this.JMPLaboratorio.add(this.JMISgcP11Lab1);
        this.JMISgcP11Lab3.setFont(new Font("Arial", 1, 12));
        this.JMISgcP11Lab3.setText("Estadística de Tiempo de Espera");
        this.JMISgcP11Lab3.setToolTipText("Genera resultado de los Exámenes realizados");
        this.JMISgcP11Lab3.addActionListener(new ActionListener() { // from class: Acceso.Menus1.141
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMISgcP11Lab3ActionPerformed(evt);
            }
        });
        this.JMPLaboratorio.add(this.JMISgcP11Lab3);
        this.JMIPSig11.add(this.JMPLaboratorio);
        this.JMPRadiologia.setText("Radiología");
        this.JMPRadiologia.setFont(new Font("Arial", 1, 12));
        this.JMIP11IEstudios.setFont(new Font("Arial", 1, 12));
        this.JMIP11IEstudios.setText("Estudios Realizados");
        this.JMIP11IEstudios.addActionListener(new ActionListener() { // from class: Acceso.Menus1.142
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11IEstudiosActionPerformed(evt);
            }
        });
        this.JMPRadiologia.add(this.JMIP11IEstudios);
        this.JIMRUInformes.setFont(new Font("Arial", 1, 12));
        this.JIMRUInformes.setText("Informes de Placas");
        this.JIMRUInformes.setToolTipText("");
        this.JIMRUInformes.addActionListener(new ActionListener() { // from class: Acceso.Menus1.143
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JIMRUInformesActionPerformed(evt);
            }
        });
        this.JMPRadiologia.add(this.JIMRUInformes);
        this.JMIP11IPlacasD.setFont(new Font("Arial", 1, 12));
        this.JMIP11IPlacasD.setText("Placas Dañadas");
        this.JMIP11IPlacasD.addActionListener(new ActionListener() { // from class: Acceso.Menus1.144
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11IPlacasDActionPerformed(evt);
            }
        });
        this.JMPRadiologia.add(this.JMIP11IPlacasD);
        this.JMITiempoEsperaRX.setFont(new Font("Arial", 1, 12));
        this.JMITiempoEsperaRX.setText("Tiempo de Espera RX");
        this.JMITiempoEsperaRX.addActionListener(new ActionListener() { // from class: Acceso.Menus1.145
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMITiempoEsperaRXActionPerformed(evt);
            }
        });
        this.JMPRadiologia.add(this.JMITiempoEsperaRX);
        this.JMIPSig11.add(this.JMPRadiologia);
        this.JMIP11IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP11IREncuesta.setText("Resultado de Encuestas");
        this.JMIP11IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.146
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP11IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPSig11.add(this.JMIP11IREncuesta);
        JMBSgcP11.add(this.JMIPSig11);
        this.JMIPUtilidades11.setText("Utilidades");
        this.JMIPUtilidades11.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes11.setText("Solicitud");
        this.JMPSolicitudes11.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar11.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar11.setText("Autorizar");
        this.JMIPSAutorizar11.addActionListener(new ActionListener() { // from class: Acceso.Menus1.147
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar11ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes11.add(this.JMIPSAutorizar11);
        this.JMIPSGestionar11.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar11.setText("Gestionar");
        this.JMIPSGestionar11.addActionListener(new ActionListener() { // from class: Acceso.Menus1.148
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar11ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes11.add(this.JMIPSGestionar11);
        this.JMIPUtilidades11.add(this.JMPSolicitudes11);
        JMBSgcP11.add(this.JMIPUtilidades11);
        JMBSgcP12.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc12.setText("SGC");
        this.JMIPSgc12.setFont(new Font("Arial", 1, 12));
        this.JMIP12CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP12CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP12CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.149
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP12CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc12.add(this.JMIP12CasosSGC);
        this.JMIP12Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP12Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP12Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.150
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP12Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc12.add(this.JMIP12Ficha5w1h);
        this.JMIP12RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP12RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP12RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.151
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP12RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc12.add(this.JMIP12RegistroAnalisisNc);
        JMBSgcP12.add(this.JMIPSgc12);
        this.JMIPInformes12.setText("SIG");
        this.JMIPInformes12.setFont(new Font("Arial", 1, 12));
        this.JMIP12IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP12IREncuesta.setText("Resultado de Encuestas");
        this.JMIP12IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.152
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP12IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes12.add(this.JMIP12IREncuesta);
        JMBSgcP12.add(this.JMIPInformes12);
        this.JMIPUtilidades12.setText("Utilidades");
        this.JMIPUtilidades12.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes12.setText("Solicitud");
        this.JMPSolicitudes12.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar12.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar12.setText("Autorizar");
        this.JMIPSAutorizar12.addActionListener(new ActionListener() { // from class: Acceso.Menus1.153
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar12ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes12.add(this.JMIPSAutorizar12);
        this.JMIPSGestionar12.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar12.setText("Gestionar");
        this.JMIPSGestionar12.addActionListener(new ActionListener() { // from class: Acceso.Menus1.154
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar12ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes12.add(this.JMIPSGestionar12);
        this.JMIPUtilidades12.add(this.JMPSolicitudes12);
        JMBSgcP12.add(this.JMIPUtilidades12);
        JMBSgcP14.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc14.setText("SGC");
        this.JMIPSgc14.setFont(new Font("Arial", 1, 12));
        this.JMIP14CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP14CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP14CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.155
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP14CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc14.add(this.JMIP14CasosSGC);
        this.JMIP14Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP14Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP14Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.156
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP14Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc14.add(this.JMIP14Ficha5w1h);
        this.JMIP14RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP14RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP14RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.157
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP14RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc14.add(this.JMIP14RegistroAnalisisNc);
        JMBSgcP14.add(this.JMIPSgc14);
        this.JMIPInformes14.setText("SIG");
        this.JMIPInformes14.setFont(new Font("Arial", 1, 12));
        this.JMIFormulacionMedica.setFont(new Font("Arial", 1, 12));
        this.JMIFormulacionMedica.setText("Formulación Médica");
        this.JMIFormulacionMedica.addActionListener(new ActionListener() { // from class: Acceso.Menus1.158
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIFormulacionMedicaActionPerformed(evt);
            }
        });
        this.JMIPInformes14.add(this.JMIFormulacionMedica);
        this.JMIInformeDespacho1.setFont(new Font("Arial", 1, 12));
        this.JMIInformeDespacho1.setText("Movimientos Consolidados");
        this.JMIInformeDespacho1.addActionListener(new ActionListener() { // from class: Acceso.Menus1.159
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIInformeDespacho1ActionPerformed(evt);
            }
        });
        this.JMIPInformes14.add(this.JMIInformeDespacho1);
        this.JMIInformeDespacho2.setFont(new Font("Arial", 1, 12));
        this.JMIInformeDespacho2.setText("Resultado de Encuestas");
        this.JMIInformeDespacho2.addActionListener(new ActionListener() { // from class: Acceso.Menus1.160
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIInformeDespacho2ActionPerformed(evt);
            }
        });
        this.JMIPInformes14.add(this.JMIInformeDespacho2);
        JMBSgcP14.add(this.JMIPInformes14);
        this.JMIPUtilidades14.setText("Utilidades");
        this.JMIPUtilidades14.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes14.setText("Solicitud");
        this.JMPSolicitudes14.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar14.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar14.setText("Autorizar");
        this.JMIPSAutorizar14.addActionListener(new ActionListener() { // from class: Acceso.Menus1.161
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar14ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes14.add(this.JMIPSAutorizar14);
        this.JMIPSGestionar14.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar14.setText("Gestionar");
        this.JMIPSGestionar14.addActionListener(new ActionListener() { // from class: Acceso.Menus1.162
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar14ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes14.add(this.JMIPSGestionar14);
        this.JMIPUtilidades14.add(this.JMPSolicitudes14);
        JMBSgcP14.add(this.JMIPUtilidades14);
        JMBSgcP15.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc15.setText("SGC");
        this.JMIPSgc15.setFont(new Font("Arial", 1, 12));
        this.JMIP15CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP15CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP15CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.163
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc15.add(this.JMIP15CasosSGC);
        this.JMIP15Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP15Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP15Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.164
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc15.add(this.JMIP15Ficha5w1h);
        this.JMIP15RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP15RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP15RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.165
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc15.add(this.JMIP15RegistroAnalisisNc);
        JMBSgcP15.add(this.JMIPSgc15);
        this.JMIPInformes15.setText("SIG");
        this.JMIPInformes15.setFont(new Font("Arial", 1, 12));
        this.JMIP15IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP15IREncuesta.setText("Resultado de Encuestas");
        this.JMIP15IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.166
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes15.add(this.JMIP15IREncuesta);
        this.JMIP15Eficacia.setFont(new Font("Arial", 1, 12));
        this.JMIP15Eficacia.setText("Eficacia");
        this.JMIP15Eficacia.addActionListener(new ActionListener() { // from class: Acceso.Menus1.167
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15EficaciaActionPerformed(evt);
            }
        });
        this.JMIPInformes15.add(this.JMIP15Eficacia);
        this.JMIP15SesionesXTrabajador.setFont(new Font("Arial", 1, 12));
        this.JMIP15SesionesXTrabajador.setText("Sesiones Por Trabajador");
        this.JMIP15SesionesXTrabajador.addActionListener(new ActionListener() { // from class: Acceso.Menus1.168
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP15SesionesXTrabajadorActionPerformed(evt);
            }
        });
        this.JMIPInformes15.add(this.JMIP15SesionesXTrabajador);
        JMBSgcP15.add(this.JMIPInformes15);
        this.JMIPUtilidades15.setText("Utilidades");
        this.JMIPUtilidades15.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes15.setText("Solicitud");
        this.JMPSolicitudes15.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar15.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar15.setText("Autorizar");
        this.JMIPSAutorizar15.addActionListener(new ActionListener() { // from class: Acceso.Menus1.169
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar15ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes15.add(this.JMIPSAutorizar15);
        this.JMIPSGestionar15.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar15.setText("Gestionar");
        this.JMIPSGestionar15.addActionListener(new ActionListener() { // from class: Acceso.Menus1.170
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar15ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes15.add(this.JMIPSGestionar15);
        this.JMIPUtilidades15.add(this.JMPSolicitudes15);
        JMBSgcP15.add(this.JMIPUtilidades15);
        JMBSgcP17.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc17.setText("SGC");
        this.JMIPSgc17.setFont(new Font("Arial", 1, 12));
        this.JMIP17CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP17CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP17CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.171
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP17CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc17.add(this.JMIP17CasosSGC);
        this.JMIP17Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP17Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP17Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.172
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP17Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc17.add(this.JMIP17Ficha5w1h);
        this.JMIP17RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP17RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP17RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.173
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP17RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc17.add(this.JMIP17RegistroAnalisisNc);
        JMBSgcP17.add(this.JMIPSgc17);
        this.JMIPInformes17.setText("SIG");
        this.JMIPInformes17.setFont(new Font("Arial", 1, 12));
        this.JMIP17IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP17IREncuesta.setText("Resultado de Encuestas");
        this.JMIP17IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.174
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP17IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes17.add(this.JMIP17IREncuesta);
        JMBSgcP17.add(this.JMIPInformes17);
        this.JMIPUtilidades17.setText("Utilidades");
        this.JMIPUtilidades17.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes17.setText("Solicitud");
        this.JMPSolicitudes17.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar17.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar17.setText("Autorizar");
        this.JMIPSAutorizar17.addActionListener(new ActionListener() { // from class: Acceso.Menus1.175
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar17ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes17.add(this.JMIPSAutorizar17);
        this.JMIPSGestionar17.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar17.setText("Gestionar");
        this.JMIPSGestionar17.addActionListener(new ActionListener() { // from class: Acceso.Menus1.176
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar17ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes17.add(this.JMIPSGestionar17);
        this.JMIPUtilidades17.add(this.JMPSolicitudes17);
        JMBSgcP17.add(this.JMIPUtilidades17);
        JMBSgcP18.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc18.setText("SGC");
        this.JMIPSgc18.setFont(new Font("Arial", 1, 12));
        this.JMIP18CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP18CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP18CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.177
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP18CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc18.add(this.JMIP18CasosSGC);
        this.JMIP18Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP18Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP18Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.178
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP18Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc18.add(this.JMIP18Ficha5w1h);
        this.JMIP18RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP18RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP18RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.179
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP18RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc18.add(this.JMIP18RegistroAnalisisNc);
        JMBSgcP18.add(this.JMIPSgc18);
        this.JMIPInformes18.setText("SIG");
        this.JMIPInformes18.setFont(new Font("Arial", 1, 12));
        this.JMIP18IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP18IREncuesta.setText("Resultado de Encuestas");
        this.JMIP18IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.180
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP18IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes18.add(this.JMIP18IREncuesta);
        JMBSgcP18.add(this.JMIPInformes18);
        this.JMIPUtilidades18.setText("Utilidades");
        this.JMIPUtilidades18.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes18.setText("Solicitud");
        this.JMPSolicitudes18.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar18.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar18.setText("Autorizar");
        this.JMIPSAutorizar18.addActionListener(new ActionListener() { // from class: Acceso.Menus1.181
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar18ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes18.add(this.JMIPSAutorizar18);
        this.JMIPSGestionar18.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar18.setText("Gestionar");
        this.JMIPSGestionar18.addActionListener(new ActionListener() { // from class: Acceso.Menus1.182
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar18ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes18.add(this.JMIPSGestionar18);
        this.JMIPUtilidades18.add(this.JMPSolicitudes18);
        JMBSgcP18.add(this.JMIPUtilidades18);
        JMBSgcP19.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc19.setText("SGC");
        this.JMIPSgc19.setFont(new Font("Arial", 1, 12));
        this.JMIP19CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP19CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP19CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.183
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc19.add(this.JMIP19CasosSGC);
        this.JMIP19Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP19Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP19Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.184
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc19.add(this.JMIP19Ficha5w1h);
        this.JMIP19RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP19RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP19RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.185
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc19.add(this.JMIP19RegistroAnalisisNc);
        JMBSgcP19.add(this.JMIPSgc19);
        this.JMIPInformes19.setText("SIG");
        this.JMIPInformes19.setFont(new Font("Arial", 1, 12));
        this.JMIP19IUser_Medicamentos.setFont(new Font("Arial", 1, 12));
        this.JMIP19IUser_Medicamentos.setText("Consultar Usuarios Matriculados");
        this.JMIP19IUser_Medicamentos.addActionListener(new ActionListener() { // from class: Acceso.Menus1.186
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19IUser_MedicamentosActionPerformed(evt);
            }
        });
        this.JMIPInformes19.add(this.JMIP19IUser_Medicamentos);
        this.JMIP19ISuperSalud.setFont(new Font("Arial", 1, 12));
        this.JMIP19ISuperSalud.setText("Informe Super Salud");
        this.JMIP19ISuperSalud.addActionListener(new ActionListener() { // from class: Acceso.Menus1.187
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19ISuperSaludActionPerformed(evt);
            }
        });
        this.JMIPInformes19.add(this.JMIP19ISuperSalud);
        this.JMIP19IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP19IREncuesta.setText("Resultado de Encuestas");
        this.JMIP19IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.188
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes19.add(this.JMIP19IREncuesta);
        this.JMIP19IRPolizas.setFont(new Font("Arial", 1, 12));
        this.JMIP19IRPolizas.setText("Vigencia de Pólizas por Proveedor");
        this.JMIP19IRPolizas.addActionListener(new ActionListener() { // from class: Acceso.Menus1.189
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP19IRPolizasActionPerformed(evt);
            }
        });
        this.JMIPInformes19.add(this.JMIP19IRPolizas);
        JMBSgcP19.add(this.JMIPInformes19);
        this.JMIPUtilidades19.setText("Utilidades");
        this.JMIPUtilidades19.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes19.setText("Solicitud");
        this.JMPSolicitudes19.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar19.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar19.setText("Autorizar");
        this.JMIPSAutorizar19.addActionListener(new ActionListener() { // from class: Acceso.Menus1.190
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar19ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes19.add(this.JMIPSAutorizar19);
        this.JMIPSGestionar19.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar19.setText("Gestionar");
        this.JMIPSGestionar19.addActionListener(new ActionListener() { // from class: Acceso.Menus1.191
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar19ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes19.add(this.JMIPSGestionar19);
        this.JMIPUtilidades19.add(this.JMPSolicitudes19);
        JMBSgcP19.add(this.JMIPUtilidades19);
        JMBSgcP20.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc20.setText("SGC");
        this.JMIPSgc20.setFont(new Font("Arial", 1, 12));
        this.JMIP20CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP20CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP20CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.192
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP20CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc20.add(this.JMIP20CasosSGC);
        this.JMIP20Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP20Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP20Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.193
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP20Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc20.add(this.JMIP20Ficha5w1h);
        this.JMIP20RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP20RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP20RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.194
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP20RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc20.add(this.JMIP20RegistroAnalisisNc);
        JMBSgcP20.add(this.JMIPSgc20);
        this.JMIPInformes20.setText("SIG");
        this.JMIPInformes20.setFont(new Font("Arial", 1, 12));
        this.JMIP20IREncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP20IREncuesta.setText("Resultado de Encuestas");
        this.JMIP20IREncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.195
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP20IREncuestaActionPerformed(evt);
            }
        });
        this.JMIPInformes20.add(this.JMIP20IREncuesta);
        JMBSgcP20.add(this.JMIPInformes20);
        this.JMIPUtilidades20.setText("Utilidades");
        this.JMIPUtilidades20.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes20.setText("Solicitud");
        this.JMPSolicitudes20.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar20.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar20.setText("Autorizar");
        this.JMIPSAutorizar20.addActionListener(new ActionListener() { // from class: Acceso.Menus1.196
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar20ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes20.add(this.JMIPSAutorizar20);
        this.JMIPSGestionar20.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar20.setText("Gestionar");
        this.JMIPSGestionar20.addActionListener(new ActionListener() { // from class: Acceso.Menus1.197
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar20ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes20.add(this.JMIPSGestionar20);
        this.JMIPUtilidades20.add(this.JMPSolicitudes20);
        JMBSgcP20.add(this.JMIPUtilidades20);
        JMBSgcP22.setFont(new Font("Arial", 1, 12));
        this.JMIPSgc22.setText("SGC");
        this.JMIPSgc22.setFont(new Font("Arial", 1, 12));
        this.JMIP22CasosSGC.setFont(new Font("Arial", 1, 12));
        this.JMIP22CasosSGC.setText("Consultar Casos de Seguridad Clinica");
        this.JMIP22CasosSGC.addActionListener(new ActionListener() { // from class: Acceso.Menus1.198
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP22CasosSGCActionPerformed(evt);
            }
        });
        this.JMIPSgc22.add(this.JMIP22CasosSGC);
        this.JMIP22Ficha5w1h.setFont(new Font("Arial", 1, 12));
        this.JMIP22Ficha5w1h.setText("Ficha 5w1H");
        this.JMIP22Ficha5w1h.addActionListener(new ActionListener() { // from class: Acceso.Menus1.199
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP22Ficha5w1hActionPerformed(evt);
            }
        });
        this.JMIPSgc22.add(this.JMIP22Ficha5w1h);
        this.JMIP22RegistroEncuesta.setFont(new Font("Arial", 1, 12));
        this.JMIP22RegistroEncuesta.setText("Registro de Encuesta");
        this.JMIP22RegistroEncuesta.addActionListener(new ActionListener() { // from class: Acceso.Menus1.200
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP22RegistroEncuestaActionPerformed(evt);
            }
        });
        this.JMIPSgc22.add(this.JMIP22RegistroEncuesta);
        this.JMIP22RegistroAnalisisNc.setFont(new Font("Arial", 1, 12));
        this.JMIP22RegistroAnalisisNc.setText("Registro - Análisis NC");
        this.JMIP22RegistroAnalisisNc.addActionListener(new ActionListener() { // from class: Acceso.Menus1.201
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIP22RegistroAnalisisNcActionPerformed(evt);
            }
        });
        this.JMIPSgc22.add(this.JMIP22RegistroAnalisisNc);
        JMBSgcP22.add(this.JMIPSgc22);
        this.JMIPInformes22.setText("SIG");
        this.JMIPInformes22.setFont(new Font("Arial", 1, 12));
        this.JMIPIREncuesta22.setFont(new Font("Arial", 1, 12));
        this.JMIPIREncuesta22.setText("Resultado de Encuestas");
        this.JMIPIREncuesta22.addActionListener(new ActionListener() { // from class: Acceso.Menus1.202
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPIREncuesta22ActionPerformed(evt);
            }
        });
        this.JMIPInformes22.add(this.JMIPIREncuesta22);
        JMBSgcP22.add(this.JMIPInformes22);
        this.JMIPUtilidades22.setText("Utilidades");
        this.JMIPUtilidades22.setFont(new Font("Arial", 1, 12));
        this.JMPSolicitudes22.setText("Solicitud");
        this.JMPSolicitudes22.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar22.setFont(new Font("Arial", 1, 12));
        this.JMIPSAutorizar22.setText("Autorizar");
        this.JMIPSAutorizar22.addActionListener(new ActionListener() { // from class: Acceso.Menus1.203
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSAutorizar22ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes22.add(this.JMIPSAutorizar22);
        this.JMIPSGestionar22.setFont(new Font("Arial", 1, 12));
        this.JMIPSGestionar22.setText("Gestionar");
        this.JMIPSGestionar22.addActionListener(new ActionListener() { // from class: Acceso.Menus1.204
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPSGestionar22ActionPerformed(evt);
            }
        });
        this.JMPSolicitudes22.add(this.JMIPSGestionar22);
        this.JMIPUtilidades22.add(this.JMPSolicitudes22);
        this.JMIPIREncuesta23.setFont(new Font("Arial", 1, 12));
        this.JMIPIREncuesta23.setText("Registro Encuesta");
        this.JMIPIREncuesta23.addActionListener(new ActionListener() { // from class: Acceso.Menus1.205
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMIPIREncuesta23ActionPerformed(evt);
            }
        });
        this.JMIPUtilidades22.add(this.JMIPIREncuesta23);
        JMBSgcP22.add(this.JMIPUtilidades22);
        this.mnuTesoreria.setText("Principal");
        this.mnuTesoreria.setFont(new Font("Arial", 1, 12));
        this.JMITPago.setFont(new Font("Arial", 1, 12));
        this.JMITPago.setText("Comprobrantes Egreso");
        this.JMITPago.setToolTipText("");
        this.JMITPago.addActionListener(new ActionListener() { // from class: Acceso.Menus1.206
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMITPagoActionPerformed(evt);
            }
        });
        this.mnuTesoreria.add(this.JMITPago);
        barraMnuTesoreria.add(this.mnuTesoreria);
        this.mnuCitologix.setText("Principal");
        this.mnuCitologix.setFont(new Font("Arial", 1, 12));
        this.JMICRecepcion.setFont(new Font("Arial", 1, 12));
        this.JMICRecepcion.setText("Agenda");
        this.JMICRecepcion.setToolTipText("");
        this.JMICRecepcion.addActionListener(new ActionListener() { // from class: Acceso.Menus1.207
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMICRecepcionActionPerformed(evt);
            }
        });
        this.mnuCitologix.add(this.JMICRecepcion);
        this.JMICResultado.setFont(new Font("Arial", 1, 12));
        this.JMICResultado.setText("Planilla Resultado");
        this.JMICResultado.setToolTipText("");
        this.JMICResultado.addActionListener(new ActionListener() { // from class: Acceso.Menus1.208
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMICResultadoActionPerformed(evt);
            }
        });
        this.mnuCitologix.add(this.JMICResultado);
        barraMnuCitologix.add(this.mnuCitologix);
        this.mnuCitologixInformes.setText("Informes");
        this.mnuCitologixInformes.setFont(new Font("Arial", 1, 12));
        this.JMICInformeFecha.setFont(new Font("Arial", 1, 12));
        this.JMICInformeFecha.setText("Resultados por fecha");
        this.JMICInformeFecha.setToolTipText("");
        this.JMICInformeFecha.addActionListener(new ActionListener() { // from class: Acceso.Menus1.209
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMICInformeFechaActionPerformed(evt);
            }
        });
        this.mnuCitologixInformes.add(this.JMICInformeFecha);
        this.JMICRecepcionStiker.setFont(new Font("Arial", 1, 12));
        this.JMICRecepcionStiker.setToolTipText("");
        this.JMICRecepcionStiker.setLabel("Impresion de stickers");
        this.JMICRecepcionStiker.addActionListener(new ActionListener() { // from class: Acceso.Menus1.210
            public void actionPerformed(ActionEvent evt) {
                Menus1.this.JMICRecepcionStikerActionPerformed(evt);
            }
        });
        this.mnuCitologixInformes.add(this.JMICRecepcionStiker);
        this.JMICRecepcionStiker.getAccessibleContext().setAccessibleName("Recepcion de stickers");
        barraMnuCitologix.add(this.mnuCitologixInformes);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPPyPCasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPPyPRegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISAtencionesxEspecialidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISAtencionesxEspecialidad.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISCitasPxEspecialidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISCitasPxEspecialidad.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISPolimedicadoxTipoFActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISPolimedicadoxTipoF.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISInfCardiovascularActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISInfCardiovascular.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISInfCronicosEpsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISInfCronicosEps.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSResolucion256ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resolucion256");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSResolucion2175ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resolucion2175");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSResolucion4505ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resolucion4505");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISInfPatologiasAsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISInfPatologiasAs.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISInformacionCoveActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe Morbilidad General (Sivigila)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSIREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISResultadoLabProcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Examenes por Procedimiento");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISMultivitaminicoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISMultivitaminico.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSIUsuariosxActividadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Usuario x Actividad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISUsuariosxProgramaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Usuario x Programa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISInformeEpsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe por eps");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRCaCervix1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe de Citologías");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISegCyDActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("SEGUIMIENTO CRECIMIENTO Y DESARROLLO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPPyPRiesgoCVActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Información Riesgo Cardiovascular");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5SAutorizarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5SGestionarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP5SConsolidadoSActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informacion Consolidada");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16AutorizarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP16SGestionarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1SAutorizarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP1SGestionarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2RegistroIndicadoresActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro de Indicadores");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2IConsolidadoEventosAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe Consolidado Casos Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2G_AnalasisEventoAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("SC Análisis Evento Adverso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2GFicha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestion Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2NcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Revisar Reporte NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2SAutorizarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP2SGestionarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP3CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP3Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP3RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP3IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP4CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP4Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP4RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP4IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar4ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IConsultarUsuarioInactivosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Usuarios Inactivos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IConsultarVProfesionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP6IConsultarVProfesional.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ICCitasSaludOcupacionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informacion SO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IFormaAsigCitasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Forma de Asignación Citas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IRemisionesxProfesionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Remisiones por Profesional");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPTiempoFacConsActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIPTiempoFacCons.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6AHEnfermeraActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Auditoria Enfermeria");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6AHMedicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Auditoria Medica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarAlertasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP6ConsultrarAlertas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarMorbilidadGActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Morbilidad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarMorbilidadGEdadesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Edades");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarMorbilidadGSexoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Sexo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarMorbilidadGSexoEdadesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Sexo y Edad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ConsultrarFisioterapiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Morbilidad Fisioterapia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNIActualizarRefActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMNIActualizarRef.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNIConsInfoActionPerformed1(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMNIConsInfo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ICInformacionImcSActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP6ICInformacionImcS.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ICReporte1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP6ICReporte1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ICPrepararPRActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Referencia Consulta Nutrición");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ITSEventosNoDeseadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consolidado Eventos No Deseados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IRIncapacidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Generacion_PDF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6IRDemandaNAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("DemandasNA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6TratamientosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe Tratamientos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ICCitasSaludOcupacional1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informacion SO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ReporteCuestionarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autoreportes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ReporteSicologiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Bateria Sicosocial");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ReporteOMAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Informe NOMA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6PRespiratoriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Prueba Respiratoria");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6RTestAuditivoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Test Auditivo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6RCAtencionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Atenciones So");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6PAudiometriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Audiometría");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6EspirometriaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Espirometría");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6ReporteSociodemActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Sociodemografico");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP6MedicinaDerporteActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reporte Medicina del Deporte");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICCronicosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultadores Crónicos Por Especialidad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar6ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar6ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP7CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP7Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP7RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP7IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar7ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar7ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP8CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP8Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP8RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP8IREncuesta9ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar8ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar8ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9AuditoriaTriageActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP9AuditoriaTriage.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9ICTiemposAActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP9ICTiemposA.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9ICEstadoAsignActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP9ICEstadoAsign.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10IHospitalizadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP10IHospitalizados.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP9IResiduosPeligrososActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP9IResiduosPeligrosos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar9ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar9ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP10IResiduosPeligrososActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP10IResiduosPeligrosos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar10ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar10ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISgcP11Lab2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISgcP11Lab2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISgcP11Lab1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISgcP11Lab1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISgcP11Lab3ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMISgcP11Lab3.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11IEstudiosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Usuarios Atendidos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMRUInformesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JIMRUInformes.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11IPlacasDActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Placas Dañadas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITiempoEsperaRXActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Tiempo de Espera RX");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP11IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar11ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar11ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP12CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP12Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP12RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP12IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar12ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar12ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP14CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP14Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP14RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFormulacionMedicaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Formulacion Medica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeDespacho1ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Movimiento Consolidado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIInformeDespacho2ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar14ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar14ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15EficaciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Eficacia Fisioterapia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP15SesionesXTrabajadorActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("xjiffSesionesXTrabajdor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar15ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar15ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP17CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP17Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP17RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP17IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar17ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar17ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP18CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP18Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP18RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP18IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar18ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar18ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19IUser_MedicamentosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseautorizacionmp.cargarPantalla("CONSULTA USUARIOS MATRICULADOS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19ISuperSaludActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP19ISuperSalud.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP19IRPolizasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla(this.JMIP19IRPolizas.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar19ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar19ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP20CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP20Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP20RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP20IREncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar20ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar20ActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP22CasosSGCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Consultar Casos de Seguridad Clinica");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP22Ficha5w1hActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP22RegistroEncuestaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Registro Encuesta");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIP22RegistroAnalisisNcActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPIREncuesta22ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSAutorizar22ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSGestionar22ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPIREncuesta23ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Registro Encuesta");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSResolucion202ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Resolucion202");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPSResolucion1552ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.cargarPantalla("Resolucion1552");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMITPagoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase.cargarPantalla("Generar Pago Individual");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRecepcionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla(this.JMICRecepcion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICResultadoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Resultado Citologia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICInformeFechaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Resultados por fecha");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICRecepcionStikerActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claselab.cargarPantalla("Recepcion de stickers");
    }
}
