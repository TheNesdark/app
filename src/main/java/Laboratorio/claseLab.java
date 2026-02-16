package Laboratorio;

import Acceso.Principal;
import Facturacion.JIFInformacion_Empresa;
import GestionDoc.JIFConsultarCitaProgramada;
import GestionDoc.JIFCopiaDocumentosG;
import Historia.JIFConsultarAtenciones;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFConsultarResultadoExamenes;
import Historia.JIFGenerarCertificado;
import Mantenimiento.JIFReporte;
import ParametrizacionN.JIFFProcedimiento;
import ParametrizacionN.JIFGenerico1CheckBox;
import ParametrizacionN.JIFGenerico3CheckBoxC3;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.controller.integracion_simedis.JIFRetransmision;
import com.genoma.plus.controller.laboratorio.JD_FormularioImpresion;
import com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios;
import com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas;
import com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen;
import com.genoma.plus.controller.laboratorio.JIFExportacionResultadosInstitucional;
import com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia;
import com.genoma.plus.controller.laboratorio.JIFHomologacionItemsExternos;
import com.genoma.plus.controller.laboratorio.JIFImportacionCorreosPorUsuarios;
import com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos;
import com.genoma.plus.controller.laboratorio.JIFRecepcionStikers;
import com.genoma.plus.controller.laboratorio.JIFRecepcionStikers1;
import com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia;
import com.genoma.plus.controller.laboratorio.JIFTipoResultado;
import com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API;
import com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia;
import com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra;
import com.genoma.plus.controller.laboratorio.JIF_ValidacionResultado_Interfaz;
import com.genoma.plus.controller.laboratorio.JIFvalidacionAdministrativa;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.jpa.dto.ParametroFiltroPlanillaTrabajoDTO;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/claseLab.class */
public class claseLab {
    public Principal frmPrincipal;
    public RecepcionAuto frmRecep;
    public RecepcionAutoBienestarSalud frmRecepBienestarSalud;
    public ImporExpor frmIE;
    public JIFProtocolos frmProto;
    public JIFProcedimientoxProtocolo frmPxAxP;
    public TipoResultado frmTipoRes;
    public RecepcionManual frmRecepManual;
    public JIFProtocoloxTipoResultado frmPxTR;
    public ResultadoManual frmResultManual;
    public JIFAuditoriaTiempos jifauditoria;
    public JIFConfProcedimiento jifprocedimiento;
    public JIFGenerico jifgenerico;
    public JIFImprimir frmImp;
    public JIFCruzados jifcruzados;
    public Agenda xjifagenda;
    public AgendaBienestar xjifagendabienestar;
    public JIFImportacion jfimportacion;
    public JIFRemisionLab jifremision;
    public JIFRemisionLab2 jifremision2;
    public JIFResultadoxExamen jifresultadoxexamen;
    public JIFGenerarReporteExamen jifgenerarreporte;
    public JIFImportacionQuimica jifimportacionquimica;
    public JIFConsultarExamenesxUsuario xjiconsultarexusuario;
    public JIFReporte xjifreporte;
    public JIFConsultasInfLab xjiconsultainf;
    private JIFGenerarCertificado xjifgenerarcerti;
    private JIFProcedimientoxPRelacionado xjifprocedimientorelacionado;
    private JIFImportacionCombilyzer13 xjifimportacionorina;
    private JIFConsultasInfProced xjifconsultarinf;
    private JIFConsultarAtenciones xjifcatencioneshc;
    private JIFRegistroRechazoMuestra xjifregistrormuestra;
    private JIFGenerico3CheckBoxC3 xjifgenerico3;
    private JIFGenerico1CheckBox xjifgenerico1;
    private JIFRegistroDatosV xjifregistrodatosv;
    private JIFImportacionLabExterno xjifimportacionlabexterno;
    public JIFPlanillaTrabajo xjifplanillatrajano;
    private JDFiltroPlanillaTrabajo xjiffiltroplantilla;
    private JIFExportacionDatos xjifexportaciond;
    private JIFFProcedimiento xjifprocedimiento;
    private JIFComentarioxArea xjifcomentarioarea;
    private String xsql;
    private double xtppoblacional;
    private double xisi;
    private JIFConsultarCitaProgramada xjifconsultallamadas;
    private JIFGenerico2Text1CheckBox xjifGenerico2textb;
    private JIFCopiaDocumentosG xjifcopiadocs;
    private JIFInformacion_Empresa xjif_consulta_inf;
    private JIFConsultarResultadoExamenes xjifconsultarexamen;
    private JIFImportacionHL7Infinity xJIFImportacionHL7Infinity;
    public static JIFSerialCom xJIFSerialCom;
    private JIFRecepcionStikers xJIFRecepcionStikers;
    private JIFRecepcionStikers1 xJIFRecepcionStikers1;
    private JIFRecepcionStikersCitologia xJIFRecepcionStikersCitologia;
    private JIF_ValidacionResultado_Interfaz xJIFValidacionResultadosInterfaz;
    private JIFEstadisticaMuestrasNuevas xJIFEstadisticaMuestrasNuevas;
    private JIFHomologacionItemsExternos xJIFHomologacionItemsExternos;
    private JIFImportacionResultadosExternos xJIFImportacionResultadosExternos;
    private JIFImportacionCorreosPorUsuarios xImportacionPorCorreo;
    private JIFExportacionResultadosInstitucional xJIFExportacionResultadosInstitucional;
    private JIFTipoResultado xJIFTipoResultado;
    private JIFConsolidadoExamenesPorServicios consolidadoExamenesPorServicios;
    private JIFExportacionPDFExamen exportacionPDFExamen;
    private JIF_Reportes_PyP_Generico xJIF_Reportes_PyP_Generico;
    private JIFRetransmision xJIFRetransmision;
    public JIFvalidacionAdministrativa administrativa;
    public JIF_ResultadoCitologia resultadoCitologia;
    public JIFValidacionMasiva_API jIFValidacionMasiva_API;
    private JIF_Trazabilidad_Muestra trazabilidad_Muestra;
    public JIFGenerarReporteExamenCitologia generarReporteExamenCitologia;
    public static boolean interaccionAgendas = false;
    private DecimalFormat xdf = new DecimalFormat("#.##");
    private String xidorden = "0";
    private int xFormaStiker = -1;
    private int xposfila = -1;
    private int xlugarprocesamiento = 0;
    private int xtipo_empresa = 0;
    private int fitroCitologias = 2;
    private long xid_ingreso = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();

    public claseLab() {
        mCargarValorV1();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mVerificarGeneracionStiker();
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Recepcion":
                if (this.frmRecep != null) {
                    this.frmRecep.dispose();
                }
                this.frmRecep = new RecepcionAuto("Recepcion", this.xlugarprocesamiento, "");
                Principal.cargarPantalla(this.frmRecep);
                break;
            case "Recepcion_Impresion":
                if (this.frmRecep != null) {
                    this.frmRecep.dispose();
                }
                this.frmRecep = new RecepcionAuto("Recepcion_Impresion", this.xlugarprocesamiento, "");
                Principal.cargarPantalla(this.frmRecep);
                break;
            case "ImportacionCorreosporUusuarios":
                this.xImportacionPorCorreo = new JIFImportacionCorreosPorUsuarios();
                Principal.cargarPantalla(this.xImportacionPorCorreo);
                break;
            case "tracking":
                this.trazabilidad_Muestra = new JIF_Trazabilidad_Muestra();
                Principal.cargarPantalla(this.trazabilidad_Muestra);
                break;
            case "Resultado Citologia":
                this.resultadoCitologia = new JIF_ResultadoCitologia();
                Principal.cargarPantalla(this.resultadoCitologia);
                break;
            case "Resultados por fecha":
                this.generarReporteExamenCitologia = new JIFGenerarReporteExamenCitologia();
                Principal.cargarPantalla(this.generarReporteExamenCitologia);
                break;
            case "ValidacionAdministrativa":
                this.administrativa = new JIFvalidacionAdministrativa();
                Principal.cargarPantalla(this.administrativa);
                break;
            case "RecepcionAutoBienestarSalud":
                if (this.frmRecepBienestarSalud != null) {
                    this.frmRecepBienestarSalud.dispose();
                }
                this.frmRecepBienestarSalud = new RecepcionAutoBienestarSalud("frmRecepBienestarSalud", this.xlugarprocesamiento, "");
                Principal.cargarPantalla(this.frmRecepBienestarSalud);
                break;
            case "Consulta Informes Dinamicos":
                this.xJIF_Reportes_PyP_Generico = new JIF_Reportes_PyP_Generico(24, "INFORMES GENERICOS", "jif_ReportesPyP_Laboratorio");
                Principal.cargarPantalla(this.xJIF_Reportes_PyP_Generico);
                break;
            case "Comentario por Area":
                if (this.xjifcomentarioarea != null) {
                    this.xjifcomentarioarea.dispose();
                }
                this.xjifcomentarioarea = new JIFComentarioxArea();
                Principal.cargarPantalla(this.xjifcomentarioarea);
                this.xjifcomentarioarea.moveToFront();
                break;
            case "Resultados Laboratorio Externo":
                if (this.xjifimportacionlabexterno != null) {
                    this.xjifimportacionlabexterno.dispose();
                }
                this.xjifimportacionlabexterno = new JIFImportacionLabExterno("IMPORTACIÓN RESULTADOS LABORATORIO ECHAVARRIA", 0);
                Principal.cargarPantalla(this.xjifimportacionlabexterno);
                this.xjifimportacionlabexterno.moveToFront();
                break;
            case "IBiosystem":
                if (this.xjifimportacionlabexterno != null) {
                    this.xjifimportacionlabexterno.dispose();
                }
                this.xjifimportacionlabexterno = new JIFImportacionLabExterno("IMPORTACIÓN RESULTADOS EQUIPO BIOSYSTEM A15 - A25", 1);
                Principal.cargarPantalla(this.xjifimportacionlabexterno);
                this.xjifimportacionlabexterno.moveToFront();
                break;
            case "HL7 (Infinity Roche Diagnostics)":
                if (this.xJIFImportacionHL7Infinity != null) {
                    this.xJIFImportacionHL7Infinity.dispose();
                }
                this.xJIFImportacionHL7Infinity = new JIFImportacionHL7Infinity();
                Principal.cargarPantalla(this.xJIFImportacionHL7Infinity);
                this.xJIFImportacionHL7Infinity.moveToFront();
                break;
            case "Cruzados":
                if (this.jifcruzados != null) {
                    this.jifcruzados.dispose();
                }
                this.jifcruzados = new JIFCruzados();
                Principal.cargarPantalla(this.jifcruzados);
                this.jifcruzados.moveToFront();
                break;
            case "Registro Datos Adicionales":
                if (this.xjifregistrodatosv != null) {
                    this.xjifregistrodatosv.dispose();
                }
                this.xjifregistrodatosv = new JIFRegistroDatosV();
                Principal.cargarPantalla(this.xjifregistrodatosv);
                this.xjifregistrodatosv.moveToFront();
                break;
            case "TipoResultado":
                if (this.xJIFTipoResultado != null) {
                    this.xJIFTipoResultado.dispose();
                }
                this.xJIFTipoResultado = new JIFTipoResultado();
                Principal.cargarPantalla(this.xJIFTipoResultado);
                this.xJIFTipoResultado.moveToFront();
                break;
            case "ImporExpor":
                if (this.frmIE != null) {
                    this.frmIE.dispose();
                }
                this.frmIE = new ImporExpor();
                Principal.cargarPantalla(this.frmIE);
                this.frmIE.moveToFront();
                break;
            case "Areas":
                if (this.xjifgenerico1 != null) {
                    this.xjifgenerico1.dispose();
                }
                this.xjifgenerico1 = new JIFGenerico1CheckBox("Áreas", "xjifareas1");
                Principal.cargarPantalla(this.xjifgenerico1);
                this.xjifgenerico1.moveToFront();
                break;
            case "Protocolos":
                if (this.frmProto != null) {
                    this.frmProto.dispose();
                }
                this.frmProto = new JIFProtocolos();
                Principal.cargarPantalla(this.frmProto);
                this.frmProto.moveToFront();
                break;
            case "ProtocolxAreaxProcedim":
                if (this.frmPxAxP != null) {
                    this.frmPxAxP.dispose();
                }
                this.frmPxAxP = new JIFProcedimientoxProtocolo();
                Principal.cargarPantalla(this.frmPxAxP);
                this.frmPxAxP.moveToFront();
                break;
            case "ProtocoloxTipoResultado":
                if (this.frmPxTR != null) {
                    this.frmPxTR.dispose();
                }
                this.frmPxTR = new JIFProtocoloxTipoResultado();
                Principal.cargarPantalla(this.frmPxTR);
                this.frmPxTR.moveToFront();
                break;
            case "Manual":
                if (this.frmRecepManual != null) {
                    this.frmRecepManual.dispose();
                }
                this.frmRecepManual = new RecepcionManual();
                Principal.cargarPantalla(this.frmRecepManual);
                this.frmRecepManual.moveToFront();
                break;
            case "ResultadoManual":
                if (this.frmResultManual != null) {
                    this.frmResultManual.dispose();
                }
                this.frmResultManual = new ResultadoManual();
                Principal.cargarPantalla(this.frmResultManual);
                this.frmResultManual.moveToFront();
                break;
            case "Imprimir":
                if (this.frmImp != null) {
                    this.frmImp.dispose();
                }
                this.frmImp = new JIFImprimir(1);
                Principal.cargarPantalla(this.frmImp);
                this.frmImp.setLocation(getCenterWith(this.frmImp), getCenterHeight(this.frmImp));
                this.frmImp.moveToFront();
                break;
            case "ImprimirResultados":
                if (this.frmImp != null) {
                    this.frmImp.dispose();
                }
                this.frmImp = new JIFImprimir(2);
                Principal.cargarPantalla(this.frmImp);
                this.frmImp.setLocation(getCenterWith(this.frmImp), getCenterHeight(this.frmImp));
                this.frmImp.moveToFront();
                break;
            case "Agenda":
                if (this.xjifagenda != null) {
                    this.xjifagenda.dispose();
                }
                this.xjifagenda = new Agenda(this);
                Principal.cargarPantalla(this.xjifagenda);
                this.xjifagenda.moveToFront();
                break;
            case "Agenda Bienestar":
                if (this.xjifagendabienestar != null) {
                    this.xjifagendabienestar.dispose();
                }
                this.xjifagendabienestar = new AgendaBienestar(this);
                Principal.cargarPantalla(this.xjifagendabienestar);
                this.xjifagendabienestar.moveToFront();
                break;
            case "Estadistica de Tiempo de Espera":
                if (this.jifauditoria != null) {
                    this.jifauditoria.dispose();
                }
                this.jifauditoria = new JIFAuditoriaTiempos("jiftiemposespera", "Estadistica de Tiempo de Espera");
                Principal.cargarPantalla(this.jifauditoria);
                this.jifauditoria.moveToFront();
                break;
            case "Hematologia":
                if (this.jfimportacion != null) {
                    this.jfimportacion.dispose();
                }
                this.jfimportacion = new JIFImportacion(this);
                Principal.cargarPantalla(this.jfimportacion);
                this.jfimportacion.moveToFront();
                break;
            case "Procedimiento":
                this.xjifprocedimiento = new JIFFProcedimiento("jifprocedimiento1");
                Principal.cargarPantalla(this.xjifprocedimiento);
                break;
            case "Tipo Muestra":
                if (this.xjifGenerico2textb != null) {
                    this.xjifGenerico2textb.dispose();
                }
                this.xjifGenerico2textb = new JIFGenerico2Text1CheckBox("Tipo Muestra");
                Principal.cargarPantalla(this.xjifGenerico2textb);
                this.xjifGenerico2textb.moveToFront();
                break;
            case "Tipo Encabezado":
                if (this.jifgenerico != null) {
                    this.jifgenerico.dispose();
                }
                this.jifgenerico = new JIFGenerico("Tipo Encabezado");
                Principal.cargarPantalla(this.jifgenerico);
                this.jifgenerico.moveToFront();
                break;
            case "RemisionLab":
                if (this.jifremision != null) {
                    this.jifremision.dispose();
                }
                this.jifremision = new JIFRemisionLab();
                Principal.cargarPantalla(this.jifremision);
                this.jifremision.moveToFront();
                break;
            case "RemisionLab2":
                if (this.jifremision2 != null) {
                    this.jifremision2.dispose();
                }
                this.jifremision2 = new JIFRemisionLab2();
                Principal.cargarPantalla(this.jifremision2);
                this.jifremision2.moveToFront();
                break;
            case "ResultadoxExamen":
                if (this.jifresultadoxexamen != null) {
                    this.jifresultadoxexamen.dispose();
                }
                this.jifresultadoxexamen = new JIFResultadoxExamen();
                Principal.cargarPantalla(this.jifresultadoxexamen);
                this.jifresultadoxexamen.moveToFront();
                break;
            case "GenerarReporte":
                if (this.jifgenerarreporte != null) {
                    this.jifgenerarreporte.dispose();
                }
                this.jifgenerarreporte = new JIFGenerarReporteExamen("jifgenerarreporte");
                Principal.cargarPantalla(this.jifgenerarreporte);
                this.jifgenerarreporte.moveToFront();
                break;
            case "Quimica":
                if (this.jifimportacionquimica != null) {
                    this.jifimportacionquimica.dispose();
                }
                this.jifimportacionquimica = new JIFImportacionQuimica(this);
                Principal.cargarPantalla(this.jifimportacionquimica);
                this.jifimportacionquimica.moveToFront();
                break;
            case "Imprimir1":
                if (this.frmImp != null) {
                    this.frmImp.dispose();
                }
                this.frmImp = new JIFImprimir(2);
                Principal.cargarPantalla(this.frmImp);
                this.frmImp.setLocation(getCenterWith(this.frmImp), getCenterHeight(this.frmImp));
                this.frmImp.moveToFront();
                break;
            case "Imprimir2":
                if (this.frmImp != null) {
                    this.frmImp.dispose();
                }
                this.frmImp = new JIFImprimir(3);
                Principal.cargarPantalla(this.frmImp);
                this.frmImp.setLocation(getCenterWith(this.frmImp), getCenterHeight(this.frmImp));
                this.frmImp.moveToFront();
                break;
            case "Por Usuario":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarexamenesusuario2");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Reporte":
                this.xjifreporte = new JIFReporte("jifreporte6");
                Principal.cargarPantalla(this.xjifreporte);
                break;
            case "Total de Recepciones por Eps":
                this.xjiconsultainf = new JIFConsultasInfLab("jifconsinformelab_eps", frm);
                Principal.cargarPantalla(this.xjiconsultainf);
                break;
            case "Estadistica de Recepciones":
                this.xjiconsultainf = new JIFConsultasInfLab("jifconsinformelab", frm);
                Principal.cargarPantalla(this.xjiconsultainf);
                break;
            case "Constacia de Atención":
                this.xjifgenerarcerti = new JIFGenerarCertificado("jifconstanciaservicio1");
                Principal.cargarPantalla(this.xjifgenerarcerti);
                break;
            case "Procedimientos Relacionados":
                this.xjifprocedimientorelacionado = new JIFProcedimientoxPRelacionado("jifprocedimientorelacionado", "Procedimientos Relacionados");
                Principal.cargarPantalla(this.xjifprocedimientorelacionado);
                break;
            case "Procedimientos Unificados":
                this.xjifprocedimientorelacionado = new JIFProcedimientoxPRelacionado("jifprocedimientounificado", "Procedimientos Unificados");
                Principal.cargarPantalla(this.xjifprocedimientorelacionado);
                break;
            case "Equipo de Orina":
                this.xjifimportacionorina = new JIFImportacionCombilyzer13(this, 0);
                Principal.cargarPantalla(this.xjifimportacionorina);
                break;
            case "Equipo de Orina1":
                this.xjifimportacionorina = new JIFImportacionCombilyzer13(this, 1);
                Principal.cargarPantalla(this.xjifimportacionorina);
                break;
            case "Estadística de Muestras Recepcionadas":
                this.xjifconsultarinf = new JIFConsultasInfProced("jifconsultarinforlab");
                Principal.cargarPantalla(this.xjifconsultarinf);
                break;
            case "Consultar HC":
                this.xjifcatencioneshc = new JIFConsultarAtenciones(this, 2);
                Principal.cargarPantalla(this.xjifcatencioneshc);
                break;
            case "Tipo Rechazo":
                this.jifgenerico = new JIFGenerico("Tipo Rechazo");
                Principal.cargarPantalla(this.jifgenerico);
                break;
            case "Registro de Rechazo de Muestra":
                this.xjifregistrormuestra = new JIFRegistroRechazoMuestra("Registro de Rechazo de Muestra", frm);
                Principal.cargarPantalla(this.xjifregistrormuestra);
                break;
            case "Demanda no Atendida":
                this.xjifregistrormuestra = new JIFRegistroRechazoMuestra("Demanda no Atendida", frm);
                Principal.cargarPantalla(this.xjifregistrormuestra);
                break;
            case "Tipos de Métodos":
                this.jifgenerico = new JIFGenerico("Tipos de Métodos");
                Principal.cargarPantalla(this.jifgenerico);
                break;
            case "Filtro Panilla":
                this.xjiffiltroplantilla = new JDFiltroPlanillaTrabajo(null, true, this);
                this.xjiffiltroplantilla.setVisible(true);
                break;
            case "Exportación BioSystem A25":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "BIOSYSTEM A25");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación BioSystem A15":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "BIOSYSTEM A15");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación AutoPlex":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación Wiener Lab CB400i":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "CB400I");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación Abbott Architect i1000SR":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "ARCHITECT I1000SR");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación Cobas e411":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "COBAS E411");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación STA Satellite":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "STA SATELLITE");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación DL-96II":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "DL-96II");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación AU480":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "AU480");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "Exportación Wiener Lab CM250":
                this.xjifexportaciond = new JIFExportacionDatos(frm, "Wiener Lab CM250");
                Principal.cargarPantalla(this.xjifexportaciond);
                break;
            case "xjiftranferenciadoclab":
                this.xjifcopiadocs = new JIFCopiaDocumentosG("xjiftranferenciadoclab");
                Principal.cargarPantalla(this.xjifcopiadocs);
                break;
            case "Consolidado de Recepciones por Municipio":
                this.xjif_consulta_inf = new JIFInformacion_Empresa("xjif_recepcion_municipio", frm);
                Principal.cargarPantalla(this.xjif_consulta_inf);
                break;
            case "Recepciones por Entidad  y Municipio":
                this.xjif_consulta_inf = new JIFInformacion_Empresa("xjif_recepcion_entidad_municipio", frm);
                Principal.cargarPantalla(this.xjif_consulta_inf);
                break;
            case "Recepciones por Entidad, Municipio y Procedimiento":
                this.xjif_consulta_inf = new JIFInformacion_Empresa("xjif_recepcion_entidad_municipio_proc", frm);
                Principal.cargarPantalla(this.xjif_consulta_inf);
                break;
            case "Consultar Resultado de Exámenes":
                this.xjifconsultarexamen = new JIFConsultarResultadoExamenes("jifconsultarresultadoLab");
                Principal.cargarPantalla(this.xjifconsultarexamen);
                break;
            case "Recepciones por Municipio con Valor":
                this.xjif_consulta_inf = new JIFInformacion_Empresa("xjif_recepcion_municipio_valor", frm);
                Principal.cargarPantalla(this.xjif_consulta_inf);
                break;
            case "Procedimimientos Facturados por Empresa":
                this.xjif_consulta_inf = new JIFInformacion_Empresa("xjif_procedimientos_Fac", frm);
                Principal.cargarPantalla(this.xjif_consulta_inf);
                break;
            case "Comunicacion Serial":
                if (xJIFSerialCom != null) {
                    JIFSerialCom jIFSerialCom = xJIFSerialCom;
                    if ("Desconectar".equals(JIFSerialCom.conectarBtn.getText())) {
                        JIFSerialCom jIFSerialCom2 = xJIFSerialCom;
                        JIFSerialCom.cerrarPuerto();
                    }
                    xJIFSerialCom.dispose();
                }
                xJIFSerialCom = new JIFSerialCom();
                Principal.cargarPantalla(xJIFSerialCom);
                break;
            case "Impresion de Stikers":
                this.xJIFRecepcionStikers = new JIFRecepcionStikers();
                Principal.cargarPantalla(this.xJIFRecepcionStikers);
                break;
            case "Impresion de Stikers 2":
                this.xJIFRecepcionStikers1 = new JIFRecepcionStikers1();
                Principal.cargarPantalla(this.xJIFRecepcionStikers1);
                break;
            case "ValidarResultadoInterfaz":
                this.xJIFValidacionResultadosInterfaz = new JIF_ValidacionResultado_Interfaz();
                Principal.cargarPantalla(this.xJIFValidacionResultadosInterfaz);
                break;
            case "Estadistica de Muestras Nuevas":
                this.xJIFEstadisticaMuestrasNuevas = new JIFEstadisticaMuestrasNuevas();
                Principal.cargarPantalla(this.xJIFEstadisticaMuestrasNuevas);
                break;
            case "Homologacion de Items Externos":
                this.xJIFHomologacionItemsExternos = new JIFHomologacionItemsExternos();
                Principal.cargarPantalla(this.xJIFHomologacionItemsExternos);
                break;
            case "Importacion de Resultados Externos en PDF":
                this.xJIFImportacionResultadosExternos = new JIFImportacionResultadosExternos();
                Principal.cargarPantalla(this.xJIFImportacionResultadosExternos);
                break;
            case "Exportacion de Resultados Institucional":
                this.xJIFExportacionResultadosInstitucional = new JIFExportacionResultadosInstitucional();
                Principal.cargarPantalla(this.xJIFExportacionResultadosInstitucional);
                break;
            case "Consolidado por tipo de servicio":
                this.consolidadoExamenesPorServicios = new JIFConsolidadoExamenesPorServicios();
                Principal.cargarPantalla(this.consolidadoExamenesPorServicios);
                break;
            case "Exportar Resultado PDF":
                this.exportacionPDFExamen = new JIFExportacionPDFExamen();
                Principal.cargarPantalla(this.exportacionPDFExamen);
                break;
            case "Consultar Resultado de Exámenes x Usuario":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarexamenesusuario1");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Registro General":
                JD_FormularioImpresion formularioImpresion = new JD_FormularioImpresion(this.frmPrincipal, true, "Registro General");
                formularioImpresion.setLocationRelativeTo(this.frmPrincipal);
                formularioImpresion.setVisible(true);
                break;
            case "Retransmision de Resultados":
                this.xJIFRetransmision = new JIFRetransmision();
                Principal.cargarPantalla(this.xJIFRetransmision);
                break;
            case "Validasion Masiva":
                this.jIFValidacionMasiva_API = new JIFValidacionMasiva_API();
                Principal.cargarPantalla(this.jIFValidacionMasiva_API);
                break;
            case "Recepcion de stickers":
                this.xJIFRecepcionStikersCitologia = new JIFRecepcionStikersCitologia();
                Principal.cargarPantalla(this.xJIFRecepcionStikersCitologia);
                break;
        }
    }

    public void cargarPantalla(String frm, Long idGenerico) {
        switch (frm) {
            case "Protocolos":
                if (this.frmProto != null) {
                    this.frmProto.dispose();
                }
                this.frmProto = new JIFProtocolos(idGenerico);
                Principal.cargarPantalla(this.frmProto);
                this.frmProto.moveToFront();
                return;
            default:
                throw new AssertionError();
        }
    }

    public void cargarPantalla(String frm, ParametroFiltroPlanillaTrabajoDTO xparametros, int xlp) {
        if (frm.equals("Planilla Trabajo")) {
            this.xjifplanillatrajano = new JIFPlanillaTrabajo(xparametros, xlp);
            Principal.cargarPantalla(this.xjifplanillatrajano);
        }
    }

    public void cargarPantalla(String frm, String numeroHistoria, String numeroOrdenFacturacion) {
        if (frm.equals("Consultar Resultado de Exámenes x Usuario")) {
            this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarexamenesusuario2", numeroHistoria, numeroOrdenFacturacion);
            Principal.cargarPantalla(this.xjiconsultarexusuario);
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "Recepcion":
                this.frmRecep.anular();
                break;
            case "frmRecepBienestarSalud":
                this.frmRecepBienestarSalud.anular();
                break;
            case "TomaManual":
                this.frmRecepManual.anular();
                break;
            case "TipoResultado":
                this.frmTipoRes.anular();
                break;
            case "ResultadoManual":
                this.frmResultManual.anular();
                break;
            case "jifconstanciaservicio1":
                this.xjifgenerarcerti.mAnular();
                break;
            case "jifremisione":
                this.jifremision.mAnular();
                break;
            case "jifremision2":
                this.jifremision2.anular();
                break;
            case "xjifplanillatrabajo":
                this.xjifplanillatrajano.mAnular(0);
                break;
            case "ProtocoloxTipoResultado":
                this.frmPxTR.mAnular();
                break;
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "Recepcion":
                this.frmRecep.buscar();
                break;
            case "frmRecepBienestarSalud":
                this.frmRecepBienestarSalud.buscar();
                break;
            case "jifPlanillaCitologia":
                this.resultadoCitologia.buscar();
                break;
            case "jifgenerarreportecitologia":
                this.generarReporteExamenCitologia.mBuscar();
                break;
            case "TomaManual":
                this.frmRecepManual.buscar();
                break;
            case "jifValidacionAdministrativa":
                this.administrativa.buscar();
                break;
            case "xjif_recepcion_municipio":
            case "xjif_recepcion_entidad_municipio":
            case "xjif_recepcion_entidad_municipio_proc":
            case "xjif_recepcion_municipio_valor":
            case "xjif_procedimientos_Fac":
                this.xjif_consulta_inf.mBuscar();
                break;
            case "jif_ReportesPyP_Laboratorio":
                this.xJIF_Reportes_PyP_Generico.mBuscar();
                break;
            case "ResultadoManual":
                this.frmResultManual.buscar();
                break;
            case "jifremision2":
                this.jifremision2.buscar();
                break;
            case "jiftiemposespera":
                this.jifauditoria.mBuscar();
                break;
            case "jifremisione":
                this.jifremision.mBuscar();
                break;
            case "jifgenerarreporte":
                this.jifgenerarreporte.mBuscar();
                break;
            case "jifresultadoxexamen":
                this.jifresultadoxexamen.mBuscar();
                break;
            case "jifconsultarexamenesusuario2":
                this.xjiconsultarexusuario.mBuscar();
                break;
            case "jifconsinformelab":
                this.xjiconsultainf.mBuscar();
                break;
            case "jifconstanciaservicio1":
                this.xjifgenerarcerti.mBuscar();
                break;
            case "jifconsultarinforlab":
                this.xjifconsultarinf.mBuscar();
                break;
            case "Registro de Rechazo de Muestra":
                this.xjifregistrormuestra.mBuscar();
                break;
            case "Demanda no Atendida":
                this.xjifregistrormuestra.mBuscar();
                break;
            case "jifregistrodatosv":
                this.xjifregistrodatosv.mBuscar();
                break;
            case "xjifexportaciond":
                this.xjifexportaciond.mBuscar();
                break;
            case "xjiftranferenciadoclab":
                this.xjifcopiadocs.mBuscar();
                break;
            case "jifconsultarresultadoLab":
                this.xjifconsultarexamen.mBuscar();
                break;
            case "xjifrecepcionstikers":
                this.xJIFRecepcionStikers.mBuscar();
                break;
            case "xjifrecepcionstikers1":
                this.xJIFRecepcionStikers1.mBuscar();
                break;
            case "xJIfValidacionResultadoInterfaz":
                this.xJIFValidacionResultadosInterfaz.mBuscar();
                break;
            case "xjifestadisticamuestrasnuevas":
                this.xJIFEstadisticaMuestrasNuevas.mBuscar();
                break;
            case "xjifexportacionresultadosinstitucional":
                this.xJIFExportacionResultadosInstitucional.mBuscar();
                break;
            case "xjConsolidoExamenesPorServicio":
                this.consolidadoExamenesPorServicios.mBuscar();
                break;
            case "jifgenerarreportePDF":
                this.exportacionPDFExamen.mBuscar();
                break;
            case "xjifretransmision":
                this.xJIFRetransmision.buscar();
                break;
            case "ValidacionMasiva":
                this.jIFValidacionMasiva_API.buscar();
                break;
            case "xjif_recepcionstikers_citologia":
                this.xJIFRecepcionStikersCitologia.mBuscar();
                break;
        }
    }

    public void desplazar(String frm, int boton) {
        if (frm.equals("Recepcion")) {
            this.frmRecep.desplazar(boton);
        } else if (frm.equals("TomaManual")) {
            this.frmRecepManual.desplazar(boton);
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "Recepcion":
                this.frmRecep.imprimir();
                break;
            case "frmRecepBienestarSalud":
                this.frmRecepBienestarSalud.imprimirSticker();
                break;
            case "TomaManual":
                this.frmRecepManual.imprimirSticker();
                break;
            case "ResultadoManual":
                this.frmResultManual.imprimir();
                break;
            case "imprimir":
                this.jifremision.mImprimir();
                break;
            case "jifremisione":
                this.jifremision.mImprimir();
                break;
            case "jifremision2":
                this.jifremision2.imprimir();
                break;
            case "jifconstanciaservicio1":
                this.xjifgenerarcerti.mImprimir();
                break;
            case "jifresultadoxexamen":
                this.jifresultadoxexamen.mImprimir();
                break;
            case "xjifplanillatrabajo":
                this.xjifplanillatrajano.mImprimir();
                break;
            case "Registro de Rechazo de Muestra":
                this.xjifregistrormuestra.mImprimir();
                break;
            case "Demanda no Atendida":
                this.xjifregistrormuestra.mImprimir();
                break;
            case "jifconsinformelab":
                this.xjiconsultainf.mImprimir();
                break;
            case "xjifrecepcionstikers":
                this.xJIFRecepcionStikers.mImprimir();
                break;
            case "xjifrecepcionstikers1":
                this.xJIFRecepcionStikers1.mImprimir();
                break;
            case "jifconsultarresultadoLab":
                this.xjifconsultarexamen.mImprimir();
                break;
            case "jifconsultarexamenesusuario2":
                this.xjiconsultarexusuario.mImprimir();
                break;
            case "jifgenerarreportecitologia":
                this.generarReporteExamenCitologia.mImprimir();
                break;
            case "xjif_recepcionstikers_citologia":
                this.xJIFRecepcionStikersCitologia.mImprimir();
                break;
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("Recepcion")) {
            this.frmRecep.nuevo();
            return;
        }
        if (frm.equals("tracking")) {
            this.trazabilidad_Muestra.nuevo();
            return;
        }
        if (frm.equals("jifPlanillaCitologia")) {
            this.resultadoCitologia.nuevo();
            return;
        }
        if (frm.equals("frmRecepBienestarSalud")) {
            this.frmRecepBienestarSalud.nuevo();
            return;
        }
        if (frm.equals("xjif_recepcion_municipio") || frm.equals("xjif_recepcion_entidad_municipio") || frm.equals("xjif_recepcion_entidad_municipio_proc") || frm.equals("xjif_recepcion_municipio_valor") || frm.equals("xjif_procedimientos_Fac")) {
            this.xjif_consulta_inf.mNuevo();
            return;
        }
        if (frm.equals("TomaManual")) {
            this.frmRecepManual.nuevo();
            return;
        }
        if (frm.equals("xjifcomentarioarea")) {
            this.xjifcomentarioarea.mNuevo();
            return;
        }
        if (frm.equals("xjifareas1")) {
            this.xjifgenerico1.mNuevo();
            return;
        }
        if (frm.equals("Protocolos")) {
            this.frmProto.mNuevo();
            return;
        }
        if (frm.equals("ProtocolxAreaxProcedim")) {
            this.frmPxAxP.mNuevo();
            return;
        }
        if (frm.equals("ProtocoloxTipoResultado")) {
            this.frmPxTR.mNuevo();
            return;
        }
        if (frm.equals("TipoResultado")) {
            this.frmTipoRes.nuevo();
            return;
        }
        if (frm.equals("ResultadoManual")) {
            this.frmResultManual.nuevo();
            return;
        }
        if (frm.equals("GenericoLab")) {
            this.jifgenerico.mNuevo();
            return;
        }
        if (frm.equals("jifprocedimiento1")) {
            this.xjifprocedimiento.mNuevo();
            return;
        }
        if (frm.equals("jifresultadoxexamen")) {
            this.jifresultadoxexamen.nuevo();
            return;
        }
        if (frm.equals("jifremisione")) {
            this.jifremision.mNuevo();
            return;
        }
        if (frm.equals("jifreporte6")) {
            this.xjifreporte.nuevo();
            return;
        }
        if (frm.equals("jifconstanciaservicio1")) {
            this.xjifgenerarcerti.mNuevo();
            return;
        }
        if (frm.equals("jifprocedimientor")) {
            this.xjifprocedimientorelacionado.mNuevo();
            return;
        }
        if (frm.equals("xjiftiporesultado")) {
            this.xJIFTipoResultado.mNuevo();
            return;
        }
        if (frm.equals("jifregistrodatosv")) {
            this.xjifregistrodatosv.mNuevo();
            return;
        }
        if (frm.equals("xjifexportaciond")) {
            this.xjifexportaciond.mNuevo();
            return;
        }
        if (frm.equals("jifconsultarexamenesusuario2")) {
            this.xjiconsultarexusuario.mNuevo();
            return;
        }
        if (frm.equals("jifconsultarexamenesusuario2") || frm.equals("jifprocedimientounificado")) {
            this.xjifprocedimientorelacionado.mNuevo();
            return;
        }
        if (frm.equals("Tipo Muestra")) {
            this.xjifGenerico2textb.mNuevo();
            return;
        }
        if (frm.equals("xjifrecepcionstikers")) {
            this.xJIFRecepcionStikers.mNuevo();
            return;
        }
        if (frm.equals("xjifrecepcionstikers1")) {
            this.xJIFRecepcionStikers1.mNuevo();
            return;
        }
        if (frm.equals("xJIfValidacionResultadoInterfaz")) {
            this.xJIFValidacionResultadosInterfaz.mNuevo();
            return;
        }
        if (frm.equals("xjifestadisticamuestrasnuevas")) {
            this.xJIFEstadisticaMuestrasNuevas.mNuevo();
            return;
        }
        if (frm.equals("xjifhomologacionitemsexternos")) {
            this.xJIFHomologacionItemsExternos.mNuevo();
            return;
        }
        if (frm.equals("xjConsolidoExamenesPorServicio")) {
            this.consolidadoExamenesPorServicios.mNuevo();
        } else if (frm.equals("jifValidacionAdministrativa")) {
            this.administrativa.nuevo();
        } else if (frm.equals("ValidacionMasiva")) {
            this.jIFValidacionMasiva_API.nuevo();
        }
    }

    public void grabar(String frm) {
        if (frm.equals("Recepcion")) {
            this.frmRecep.grabar();
            return;
        }
        if (frm.equals("frmRecepBienestarSalud")) {
            this.frmRecepBienestarSalud.grabar();
            return;
        }
        if (frm.equals("TomaManual")) {
            this.frmRecepManual.grabar();
            return;
        }
        if (frm.equals("jifremision2")) {
            this.jifremision2.grabar();
            return;
        }
        if (frm.equals("xjifcomentarioarea")) {
            this.xjifcomentarioarea.mGrabar();
            return;
        }
        if (frm.equals("xjifareas1")) {
            this.xjifgenerico1.mGrabar();
            return;
        }
        if (frm.equals("Protocolos")) {
            this.frmProto.mGrabar();
            return;
        }
        if (frm.equals("ProtocolxAreaxProcedim")) {
            this.frmPxAxP.mGrabar();
            return;
        }
        if (frm.equals("ProtocoloxTipoResultado")) {
            this.frmPxTR.mGrabar();
            return;
        }
        if (frm.equals("TipoResultado")) {
            this.frmTipoRes.grabar();
            return;
        }
        if (frm.equals("ResultadoManual")) {
            this.frmResultManual.grabar(1);
            return;
        }
        if (frm.equals("Procedimiento")) {
            this.jifprocedimiento.mGrabar();
            return;
        }
        if (frm.equals("GenericoLab")) {
            this.jifgenerico.mGrabar();
            return;
        }
        if (frm.equals("jifprocedimiento1")) {
            this.xjifprocedimiento.mGrabar();
            return;
        }
        if (frm.equals("jifremisione")) {
            this.jifremision.mGrabar();
            return;
        }
        if (frm.equals("jifresultadoxexamen")) {
            this.jifresultadoxexamen.grabar(3);
            return;
        }
        if (frm.equals("jifreporte6")) {
            this.xjifreporte.grabar();
            return;
        }
        if (frm.equals("jifconstanciaservicio1")) {
            this.xjifgenerarcerti.mGrabar();
            return;
        }
        if (frm.equals("jifprocedimientor")) {
            this.xjifprocedimientorelacionado.mGrabar();
            return;
        }
        if (frm.equals("Registro de Rechazo de Muestra")) {
            this.xjifregistrormuestra.mGrabar();
            return;
        }
        if (frm.equals("Demanda no Atendida")) {
            this.xjifregistrormuestra.mGrabar();
            return;
        }
        if (frm.equals("xjiftiporesultado")) {
            this.xJIFTipoResultado.mGrabar();
            return;
        }
        if (frm.equals("jifregistrodatosv")) {
            this.xjifregistrodatosv.mGrabar();
            return;
        }
        if (frm.equals("jifconsultarexamenesusuario2") || frm.equals("jifprocedimientounificado")) {
            this.xjifprocedimientorelacionado.mNuevo();
            return;
        }
        if (frm.equals("Tipo Muestra")) {
            this.xjifGenerico2textb.mGrabar();
            return;
        }
        if (frm.equals("xJIfValidacionResultadoInterfaz")) {
            this.xJIFValidacionResultadosInterfaz.mGrabar();
            return;
        }
        if (frm.equals("xjifhomologacionitemsexternos")) {
            this.xJIFHomologacionItemsExternos.mGuardar();
            return;
        }
        if (frm.equals("jifremision2")) {
            this.jifremision2.grabar();
        } else if (frm.equals("ValidacionMasiva")) {
            this.jIFValidacionMasiva_API.grabar();
        } else if (frm.equals("jifTracking")) {
            this.trazabilidad_Muestra.grabar();
        }
    }

    public int getXlugarprocesamiento() {
        return this.xlugarprocesamiento;
    }

    public void setXlugarprocesamiento(int xlugarprocesamiento) {
        this.xlugarprocesamiento = xlugarprocesamiento;
    }

    public String getXidorden() {
        return this.xidorden;
    }

    public void setXidorden(String xidorden) {
        this.xidorden = xidorden;
    }

    public int getXposfila() {
        return this.xposfila;
    }

    public void setXposfila(int xposfila) {
        this.xposfila = xposfila;
    }

    public int getXtipo_empresa() {
        return this.xtipo_empresa;
    }

    public void setXtipo_empresa(int xtipo_empresa) {
        this.xtipo_empresa = xtipo_empresa;
    }

    public long getXid_ingreso() {
        return this.xid_ingreso;
    }

    public void setXid_ingreso(long xid_ingreso) {
        this.xid_ingreso = xid_ingreso;
    }

    public String mFormula1RestaDosValores(double xv1, double xv2) {
        double rs = xv1 - xv2;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula1SumaDosValores(double xv1, double xv2) {
        double rs = xv1 + xv2;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula2(double xv1) {
        double rs = xv1 / this.xtppoblacional;
        String xvalor = String.valueOf(this.xdf.format(Math.pow(rs, this.xisi)));
        return xvalor.replace(',', '.');
    }

    public String mFormula22(double xv1, double xv2) {
        double rs = xv1 / this.xtppoblacional;
        String xvalor = String.valueOf(this.xdf.format(Math.pow(rs, xv2)));
        return xvalor.replace(',', '.');
    }

    public String mFormula3(double xv1, int xc) {
        double rs = xv1 / ((double) xc);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula4(double xv1, double xv2) {
        double rs = (((xv1 * 100.0d) / xv2) * 1.0E7d) / 100.0d;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula5(double xv1, double xv2) {
        double rs = (((xv1 * 100.0d) / xv2) * 100.0d) / 100.0d;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula7(double xv1, double xv2) {
        double rs = (xv1 * xv2) / 100.0d;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula8(double xv1, double xv2, double xv3) {
        double rs = (xv1 - xv2) - xv3;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula9(double xv1, double xc) {
        double rs = xv1 / xc;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula10(double xv1, double xv2, double xv3, int xc1, double xv4, double xc2) {
        double rs = ((((xv1 / ((double) xc1)) * xv3) / xv2) * xc2) / xv4;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula11(double xv1, double xv2) {
        double rs = xv1 * xv2;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula12(double xv2, long xedad, long xraza, String xsexo) {
        double rs = (((186.0d * xv2) - 1.154d) * xedad) - 0.203d;
        if (xsexo.equals("F")) {
            rs *= 0.742d;
        }
        if (xraza == 0) {
            rs *= 1.219d;
        }
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula13(double xv2, long xedad, double xpeso, String xsexo) {
        double rs = (((140 - xedad) * xpeso) / xv2) * 72.0d;
        if (xsexo.equals("F")) {
            rs *= 0.85d;
        }
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula14(double xv1, double xv2, double xv3, double xc1) {
        double rs = (xv1 * xv2) / (xv3 * xc1);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula15(double xv1, double xv2) {
        double rs = ((xv1 * 0.01d) * xv2) / 1000.0d;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula16(double xv1, long xedad, long xraza, String xsexo) {
        double rs = ((double) 186) * Math.pow(xv1, -1.154d) * Math.pow(xedad, -0.203d);
        if (xraza == 0) {
            rs *= 1.21d;
        }
        if (xsexo.equals("F")) {
            rs *= 0.742d;
        }
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula17(double xv1, double xv2, double xv3) {
        double rs = (xv1 * xv3) / (xv3 * 1440.0d);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula18(long xedad, double xpeso, double xvcreatinina, String xsexo) {
        double rs = ((140 - xedad) * xpeso) / (xvcreatinina * 72.0d);
        if (xsexo.equals("F")) {
            rs *= 0.85d;
        }
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula19(double xv1, double xv2, double xv3) {
        double rs = xv1 - (xv2 + xv3);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula20(double xv1, double xv2) {
        double rs = (xv1 * 1.73d) / xv2;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula40(long xedad, double xvcreatinina, String xsexo, boolean xraza) {
        double xk;
        double xvalfa;
        double rs;
        if (xsexo.equals("F")) {
            xk = 0.7d;
            xvalfa = -0.329d;
        } else {
            xk = 0.9d;
            xvalfa = -0.411d;
        }
        if (xsexo.equals("F")) {
            if (xraza) {
                rs = 141.0d * Math.pow(xvcreatinina * xk, xvalfa) * Math.pow(xvcreatinina * xk, -1.209d) * Math.pow(0.993d, xedad) * 1.108d * 1.159d;
            } else {
                rs = 141.0d * Math.pow(xvcreatinina * xk, xvalfa) * Math.pow(xvcreatinina * xk, -1.209d) * Math.pow(0.993d, xedad) * 1.108d;
            }
        } else if (xraza) {
            rs = 141.0d * Math.pow(xvcreatinina * xk, xvalfa) * Math.pow(xvcreatinina * xk, -1.209d) * Math.pow(0.993d, xedad) * 1.159d;
        } else {
            System.out.println(Math.pow(xvcreatinina * xk, xvalfa));
            System.out.println(Math.pow(xvcreatinina * xk, -1.209d));
            System.out.println(Math.pow(0.993d, xedad));
            rs = Math.pow(xvcreatinina * xk, xvalfa) * Math.pow(xvcreatinina * xk, -1.209d) * Math.pow(0.993d, xedad);
        }
        System.out.println(rs);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula41(double xv1, double xv2) {
        double rs = (xv1 * xv2) / 1000.0d;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula44(double xv1, double xv2) {
        double rs = xv1 * (xv2 / 100.0d);
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula45(double xv1, double xv2) {
        double rs = (xv1 * xv2) / 3600.0d;
        String xvalor = String.valueOf(this.xdf.format(Math.sqrt(rs)));
        return xvalor.replace(',', '.');
    }

    public String mFormula46(double xv1, double xv2, double xc1) {
        double rs = (xv1 * xv2) / xc1;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    public String mFormula47(double xv1, double xv2, double xc1) {
        double rs = (xv1 / xv2) * xc1;
        String xvalor = String.valueOf(this.xdf.format(rs));
        return xvalor.replace(',', '.');
    }

    private void mVerificarGeneracionStiker() {
        Object[] botones = {"Visualizacion", "Impresion", "Cerrar"};
        int n = JOptionPane.showOptionDialog((Component) null, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Que desea hacer?</p>", "GENERACIÓN DE STIKER", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            setxFormaStiker(0);
        } else if (n == 1) {
            setxFormaStiker(1);
        }
    }

    private void mCargarValorV1() {
        try {
            this.xsql = "SELECT `Valor` FROM `l_tipo_variables` WHERE (`Id` =1)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                this.xtppoblacional = xrs.getDouble(1);
            }
            xrs.close();
            this.xct.establecerConexionBd();
            this.xsql = "SELECT `Valor` FROM `l_tipo_variables` WHERE (`Id` =2)";
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                this.xisi = xrs2.getDouble(1);
            }
            xrs2.close();
            this.xct.establecerConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void mGrabarHistorico(String xnrecepcion, String xidusuario, String xidprotocoloxproc, int xn) {
        try {
            this.xsql = "SELECT `l_detalleresultado`.`Id_Resultado`, `l_detalleresultado`.`Id_ProtocolProcedim`     FROM  `l_detalleresultado`INNER JOIN `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detalleresultado`.`Id_ProtocolProcedim` ='" + xidprotocoloxproc + "' AND `l_recepcion`.`Id_Paciente` ='" + xidusuario + "') ORDER BY `l_recepcion`.`Id_Paciente` ASC, `l_detalleresultado`.`Id_Resultado` DESC LIMIT " + xn + "";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        this.xsql = "insert IGNORE into `l_detalleresultado_historico` (`Id_Recepcion` ,`Id_Resultado` , `Id_Protocolo_Proc` , `UsuarioS`) values('" + xnrecepcion + "','" + xrs.getString(1) + "','" + xidprotocoloxproc + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        xct1.ejecutarSQL(this.xsql);
                        xct1.cerrarConexionBd();
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(claseLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public int getxFormaStiker() {
        return this.xFormaStiker;
    }

    public void setxFormaStiker(int xFormaStiker) {
        this.xFormaStiker = xFormaStiker;
    }

    public int getFitroCitologias() {
        return this.fitroCitologias;
    }

    public void setFitroCitologias(int fitroCitologias) {
        this.fitroCitologias = fitroCitologias;
    }

    public int getCenterWith(JInternalFrame internalFrame) {
        return (Principal.PanelPpal.getWidth() - internalFrame.getWidth()) / 2;
    }

    public int getCenterHeight(JInternalFrame internalFrame) {
        return (Principal.PanelPpal.getHeight() - internalFrame.getHeight()) / 2;
    }

    public void mAlertaResultadoPendientes(String xIdRecepcion) {
        String xsql = "SELECT\n   if(pcr.Id is not null, if(pcr.Id is null, 0, 1),  `l_detallerecepcion`.`Resultado`) Resultado\n    , `g_procedimiento`.`Id`\n    , SUBSTRING(`g_procedimiento`.`Nbre`,1,100)\n    , `g_procedimiento`.`EsRemitido`, pcr.Id\n    , l_detallerecepcion.Id_Recepcion\nFROM\n     `l_detallerecepcion`\n    INNER JOIN  `g_procedimiento` \n        ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\n   --  left join l_recepcion_citologia lrc on (lrc.Id_Recepcion =l_detallerecepcion.id)\n    LEFT join  p_citologia pc on (pc.Id_Recepcion =l_detallerecepcion.Id_Recepcion)\n    left join p_citologia_resultados pcr on (pcr.Id_Citologia =pc.Id )\nWHERE (`l_detallerecepcion`.`Id_Recepcion` ='" + xIdRecepcion + "'\n -- AND `l_detallerecepcion`.`Resultado`=0 \nAND `g_procedimiento`.`EsRemitido`=0) having Resultado=0";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                String xmensaje = "<html><P ALIGN=center> <b> <font face='Arial' color='red' size=4>LOS SIGUIENTES PROCEDIMIENTOS NO TIENEN RESULTADOS:</font></b></P></html>\n";
                xrs.beforeFirst();
                while (xrs.next()) {
                    xmensaje = xmensaje + "<html><P ALIGN=center> <b> <font face='Arial' color='red' size=4>_" + xrs.getString(3).toUpperCase() + "</font></b></P></html>\n";
                }
                JOptionPane.showMessageDialog((Component) null, xmensaje, "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else {
                System.out.println("Resultados Completos");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
