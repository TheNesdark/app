package Historia;

import Acceso.Principal;
import ComprasBS.JIFAutorizacionOrdenesCT;
import Enfermeria.JIFAgenda_UH;
import Enfermeria.JIFCensoCama;
import General.JIFBuscarPatologia;
import Mantenimiento.JIFReporte;
import Odontologia.JPEndoExamenClinico;
import Salud_Ocupacional.JIFAgenda;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia;
import com.genoma.plus.controller.historia.FuncionalidadPanelHistoriaClinica;
import com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO;
import com.genoma.plus.controller.historia.JIF_Historia_Clinica_v2;
import com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4;
import com.genoma.plus.controller.historia.JPAFamiliograma;
import com.genoma.plus.controller.historia.JPAVale;
import com.genoma.plus.controller.historia.JPAtencionDieta;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.Anexo5Dto;
import com.genoma.plus.controller.historia.dto.Anexo6Dto;
import com.genoma.plus.controller.historia.dto.AnexoDatoUsuarioDto;
import com.genoma.plus.controller.historia.dto.AnexoInformacionIpsDto;
import com.genoma.plus.controller.historia.dto.ListaCupsDetalleDto;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/clasesHistoriaCE.class */
public class clasesHistoriaCE {
    public JIFHistoriaClinica xjifhistoriaclinica;
    public JIFConsultarHistorial xjifconsultarhc;
    public JIFConsultarHAyudasDx xjifconsultaradx;
    public JIFFormulasPyP xjifformulaspyp;
    private JIFAgendaM jifagenda;
    public JIFPermisosMedicos xjifpermiso;
    public JIFConsultarResultadoExamenes xjifconsultarexamen;
    public JIFConsultarExamenesxUsuario xjiconsultarexusuario;
    public JIFIncapacidades xjifincapacidad;
    public JPANotas_v2 Xjpnotas1;
    public JIFReporte xjifreporte;
    public JIFRVisitasDomiciliarias xjivisitad;
    public JIFRJuntaMedica xjijuntamed;
    private JIFInformesH xjifreporteh;
    private JIFGenerarCertificado xjifgenerarcerti;
    private JIFAcronimos xjifacronimos;
    private JIFConsultarAtencionesEsp xjifconsultar;
    private JIFSeguimientoOrdenesLab xjifseguimientollab;
    private JIFAutorizacionOrdenesCT xjifautorizacionorden;
    private JPAEvaluacionRiesgo xJPAEvaluacionRiesgo;
    private JDFormulaVencida xjifvencida;
    public JPEndoExamenClinico xJPEndoExamenClinico;
    private JIFCensoCama xJIFCensoCama;
    private Sivigila xSivigila;
    private JPAFamiliograma xJPAFamiliograma;
    public JIF_Historia_Clinica_v2 historia_Clinica_v2;
    public JIF_Historia_Clinica_v4 historia_Clinica_v4;
    public JIF_AgendaHistoriaServiciosDTO agendaHistoriaServiciosDTO;
    public JIF_Historia_Clinica_Cirugia historia_Clinica_Cirugia;
    private JPAVale jPAVale;
    private String xsql;
    public static InformacionAgendaMedicaDTO informacionAgendaMedicaDTO;
    private JIF_Reportes_PyP_Generico jifreportes;
    public Principal frmPrincipal;
    private PatologiaCie10DAO patologiaCie10DAO;
    private String idIngresoNuevo;
    private String idCitaNP;
    private String nombreAgenda;
    private JPAtencionDieta xJPAtencionDieta;
    public JIFAgendaMedico xjifagendamedico = null;
    public JIFAgendaMedico_N xjifagendan = null;
    private JIFRegistroAtencionesEsp xjifatencionesp = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    public JIFAgenda_UH xjifagenda_UH = null;
    public JIFAgenda xjifagenda = null;

    public clasesHistoriaCE() {
        informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
        informacionAgendaMedicaDTO.setIdTipoAtencion(1);
        springStart();
    }

    private void springStart() {
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("patologiaCie10DAOImpl");
    }

    public void cargarPantalla(String frm, Principal frmP, String xnombre) {
        System.out.println("entroo " + frm);
        switch (frm) {
            case "Historia":
                this.xjifhistoriaclinica = new JIFHistoriaClinica(this, xnombre);
                Principal.cargarPantalla(this.xjifhistoriaclinica);
                break;
            case "Historia_Nueva":
            case "Agenda de Consulta Externa":
                if (this.historia_Clinica_v2 != null) {
                    this.historia_Clinica_v2.dispose();
                }
                if (this.historia_Clinica_v4 != null) {
                    this.historia_Clinica_v4.dispose();
                }
                setNombreAgenda(frm);
                this.historia_Clinica_v2 = new JIF_Historia_Clinica_v2();
                Principal.cargarPantalla(this.historia_Clinica_v2);
                break;
            case "Agenda de Servicios Beta":
                setNombreAgenda(frm);
                this.agendaHistoriaServiciosDTO = new JIF_AgendaHistoriaServiciosDTO();
                Principal.cargarPantalla(this.agendaHistoriaServiciosDTO);
                break;
            case "Agenda de Servicios":
                if (this.historia_Clinica_v2 != null) {
                    this.historia_Clinica_v2.dispose();
                    this.historia_Clinica_v2 = null;
                }
                if (this.historia_Clinica_v4 != null) {
                    this.historia_Clinica_v4.dispose();
                    this.historia_Clinica_v4 = null;
                }
                setNombreAgenda("Agenda de Servicios");
                this.historia_Clinica_v4 = new JIF_Historia_Clinica_v4();
                Principal.cargarPantalla(this.historia_Clinica_v4);
                break;
        }
    }

    public void cargarPantalla(String frm, Principal frmP) {
        this.frmPrincipal = frmP;
        switch (frm) {
            case "Agenda":
                this.xjifagendamedico = new JIFAgendaMedico(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString(), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), this);
                Principal.cargarPantalla(this.xjifagendamedico);
                break;
            case "Historia":
                this.xjifhistoriaclinica = new JIFHistoriaClinica(this, "Historia_Med_H");
                Principal.cargarPantalla(this.xjifhistoriaclinica);
                break;
            case "Historia_Nueva":
                this.historia_Clinica_v2 = new JIF_Historia_Clinica_v2();
                Principal.cargarPantalla(this.historia_Clinica_v2);
                break;
            case "Censo de Camas":
                this.xJIFCensoCama = new JIFCensoCama("xjifcensocama1");
                Principal.cargarPantalla(this.xJIFCensoCama);
                break;
            case "Agenda_UH":
                this.xjifagenda_UH = new JIFAgenda_UH(1);
                Principal.cargarPantalla(this.xjifagenda_UH);
                break;
            case "AgendaN":
                this.xjifagendan = new JIFAgendaMedico_N(this, 0);
                Principal.cargarPantalla(this.xjifagendan);
                break;
            case "Consultar Atenciones":
                JIFConsultarAtenciones jif = new JIFConsultarAtenciones(this);
                Principal.cargarPantalla(jif);
                break;
            case "Consultar Historial":
                this.xjifconsultarhc = new JIFConsultarHistorial(0, "jifconsultarhistorial");
                Principal.cargarPantalla(this.xjifconsultarhc);
                break;
            case "Consultar Ayudas Dx":
                this.xjifconsultaradx = new JIFConsultarHAyudasDx();
                Principal.cargarPantalla(this.xjifconsultaradx);
                break;
            case "Formulas PyP":
                this.xjifformulaspyp = new JIFFormulasPyP(this);
                Principal.cargarPantalla(this.xjifformulaspyp);
                break;
            case "Permiso Médico":
                this.xjifpermiso = new JIFPermisosMedicos(this);
                Principal.cargarPantalla(this.xjifpermiso);
                break;
            case "Consultar Resultado de Exámenes":
                this.xjifconsultarexamen = new JIFConsultarResultadoExamenes("jifconsultarresultado");
                Principal.cargarPantalla(this.xjifconsultarexamen);
                break;
            case "Consultar Resultado de Exámenes por Usuario":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarexamenesusuario");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Registro de Incapacidades":
                this.xjifincapacidad = new JIFIncapacidades(this);
                Principal.cargarPantalla(this.xjifincapacidad);
                break;
            case "Reporte":
                this.xjifreporte = new JIFReporte("jifreporte5");
                Principal.cargarPantalla(this.xjifreporte);
                break;
            case "Registro de Visitas Domiciliarias":
                this.xjivisitad = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), frm, "jifvisitadomiciliaria", new Long(0L), 0);
                Principal.cargarPantalla(this.xjivisitad);
                break;
            case "Registro Junta Medica":
                this.xjijuntamed = new JIFRJuntaMedica(this);
                Principal.cargarPantalla(this.xjijuntamed);
                break;
            case "Registro de Consulta Medica No Programada":
                this.xjifreporteh = new JIFInformesH("CONSULTA NO PROGRAMADA", "jifreportesh");
                Principal.cargarPantalla(this.xjifreporteh);
                break;
            case "Generar Constancia de Asistencia":
                this.xjifgenerarcerti = new JIFGenerarCertificado("jifconstanciaservicio");
                Principal.cargarPantalla(this.xjifgenerarcerti);
                break;
            case "Consultar Acrónimos":
                this.xjifacronimos = new JIFAcronimos();
                Principal.cargarPantalla(this.xjifacronimos);
                break;
            case "Consultar Atenciones Especiales":
                this.xjifconsultar = new JIFConsultarAtencionesEsp(this, 0);
                Principal.cargarPantalla(this.xjifconsultar);
                break;
            case "Consultar Cirugias Programadas":
                this.xjifconsultar = new JIFConsultarAtencionesEsp(this, 1);
                Principal.cargarPantalla(this.xjifconsultar);
                break;
            case "jifseguimientolab":
                this.xjifseguimientollab = new JIFSeguimientoOrdenesLab("jifseguimientolab", this.xjifconsultarexamen);
                Principal.cargarPantalla(this.xjifseguimientollab);
                break;
            case "Autorización Ordenes Compra o Trabajo":
                this.xjifautorizacionorden = new JIFAutorizacionOrdenesCT("jifautorizaciondocumentos1", 0);
                Principal.cargarPantalla(this.xjifautorizacionorden);
                break;
            case "Registro de Notas Médicas":
                this.xjivisitad = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), frm, "xjifnotasmedicas", new Long(0L), 0);
                Principal.cargarPantalla(this.xjivisitad);
                break;
            case "Consultar Remisiones y Ordenes":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarRemOrdHist");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Asignación Atención Especial":
                if (this.xjifatencionesp != null) {
                    this.xjifatencionesp.dispose();
                }
                this.xjifatencionesp = new JIFRegistroAtencionesEsp("jifregistroatencionesp3");
                Principal.cargarPantalla(this.xjifatencionesp);
                this.xjifatencionesp.moveToFront();
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(2, "INFORMES GENERALES", "jif_ReportesPyP_hc");
                Principal.cargarPantalla(this.jifreportes);
                break;
            case "Agenda_So":
                this.xjifagenda = new JIFAgenda(Principal.clasehistoriace, 0);
                Principal.cargarPantalla(this.xjifagenda);
                break;
        }
    }

    public void mover(String frm, int boton) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonMover(this.xjifhistoriaclinica.JPIDetalleAtencion, boton, this.xjifhistoriaclinica);
                break;
            case "jif_historiaclinicav2":
                verificacionPanelActivoBotonMover(this.historia_Clinica_v2.JPI_PanelPrincipal, boton, this.historia_Clinica_v2);
                break;
            case "jif_historiaclinicav4":
                verificacionPanelActivoBotonMover(this.historia_Clinica_v4.JPI_PanelPrincipal, boton, this.historia_Clinica_v4);
                break;
        }
    }

    private void verificacionPanelActivoBotonMover(JPanel jPanel, int boton, JInternalFrame jInternalFrame) {
        if (jPanel.getComponentCount() != 0) {
            switch (jPanel.getComponent(0).getName()) {
                case "MotricidadFina":
                    this.xjifhistoriaclinica.mover("MotricidadFina", boton);
                    break;
                case "MotricidadGruesa":
                    this.xjifhistoriaclinica.mover("MotricidadGruesa", boton);
                    break;
                case "ValoracionLenguaje":
                    this.xjifhistoriaclinica.mover("ValoracionLenguaje", boton);
                    break;
                case "ValoracionPersonal":
                    this.xjifhistoriaclinica.mover("ValoracionPersonal", boton);
                    break;
            }
        }
    }

    private void verificacionPanelActivoBotonNuevo(JPanel jPanel, JInternalFrame jInternalFrame) {
        FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
        if (jPanel.getComponentCount() != 0) {
            funcionalidadPanelHistoriaClinica = null;
            if (jInternalFrame.getName().equals("jif_historiaclinicav2")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v2.funcionalidadPanelHistoriaClinica;
            } else if (jInternalFrame.getName().equals("jif_historiaclinicav4")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica;
            }
            switch (jPanel.getComponent(0).getName()) {
                case "jpsuministroh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpsuministroh.nuevo();
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            funcionalidadPanelHistoriaClinica.getXjpsuministroh().nuevo();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjpsuministroh().nuevo();
                        }
                        break;
                    }
                    break;
                case "xjif_importaciondochc":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjif_importardochc.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjif_importardochc().mNuevo();
                        break;
                    }
                    break;
                case "jpprocedimientosh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpprocedimientosh.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().nuevo();
                        break;
                    }
                    break;
                case "jpremisiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones().nuevo();
                        break;
                    }
                    break;
                case "jpincapacidades":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpincapacidad.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpincapacidad().nuevo();
                        break;
                    }
                    break;
                case "jpincapacidades_v2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.aIncapacidad_v2.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getAIncapacidad_v2().nuevo();
                        break;
                    }
                    break;
                case "jpaeventonodeseado":
                    this.xjifhistoriaclinica.xjpeventonodeseado.nuevo();
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpeventonodeseado.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpeventonodeseado().nuevo();
                        break;
                    }
                    break;
                case "jppermisos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjppermisos.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjppermisos().nuevo();
                        break;
                    }
                    break;
                case "jpnotac":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpnotas.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpnotas().mNuevo();
                        break;
                    }
                    break;
                case "Alimentacion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.nuevo("Alimentacion");
                        break;
                    }
                    break;
                case "jptratamiento_ordenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftratamiento.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftratamiento().mNuevo();
                        break;
                    }
                    break;
                case "xjptest_prespiratorio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftest_prespiratorio.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftest_prespiratorio().mNuevo();
                        break;
                    }
                    break;
                case "xjpseguimientopac":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifseguimiento.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifseguimiento().mNuevo();
                        break;
                    }
                    break;
                case "xjp_intervencion_qx":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCirugias.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCirugias().mNuevo();
                        break;
                    }
                    break;
                case "xjpeventoadverso":
                    this.xjifhistoriaclinica.xJPEventoAdverso.mNuevo();
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPGaleriaImagenes.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPGaleriaImagenes().mNuevo();
                        break;
                    }
                    break;
                case "xevaluacionriesgo":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAEvaluacionRiesgo.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAEvaluacionRiesgo().mNuevo();
                        break;
                    }
                    break;
                case "xjp_historia_terapia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        if (this.xjifhistoriaclinica.xjif_terapiaf.JTPDatosHc.getSelectedIndex() == 2) {
                            this.xjifhistoriaclinica.xjif_terapiaf.mNuevo_Seguimiento();
                        }
                        break;
                    } else {
                        if (funcionalidadPanelHistoriaClinica.getXjif_terapiaf().JTPDatosHc.getSelectedIndex() == 2) {
                            funcionalidadPanelHistoriaClinica.getXjif_terapiaf().mNuevo_Seguimiento();
                        }
                        break;
                    }
                    break;
                case "xjpgaleriaimagenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPGaleriaImagenes.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPGaleriaImagenes().mNuevo();
                        break;
                    }
                    break;
                case "xjpsopsicomotriz":
                    switch (jInternalFrame.getName()) {
                        case "jifhistoriaclinica":
                            this.xjifhistoriaclinica.xJPSo_Psicomotriz.mNuevo();
                            break;
                        case "jif_historiaclinicav3":
                            Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mNuevo();
                            break;
                        default:
                            funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mNuevo();
                            break;
                    }
                    break;
                case "xjpdeprecionposparto":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPDepresionPosparto.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPDepresionPosparto().mNuevo();
                        break;
                    }
                    break;
                case "xjpmaltratoviolencia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPMaltratoViolencia.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPMaltratoViolencia().mNuevo();
                        break;
                    }
                    break;
                case "xjtpClasificacionEular":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAClasificacionEular.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAClasificacionEular().mNuevo();
                        break;
                    }
                    break;
                case "xjpCuestionarioHAQ":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCuestionarioHAQ.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCuestionarioHAQ().mNuevo();
                        break;
                    }
                    break;
                case "jifControlPlaca":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifControlPlaca.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifControlPlaca().mNuevo();
                        break;
                    }
                    break;
                case "jptratamiento_ordenes_nuevas":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getOrden_Tratamiento_Nueva().nuevo();
                        break;
                    }
                    break;
                case "jpi_formulario_anexo2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo2.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo2().nuevo();
                        break;
                    }
                    break;
                case "xjpi_formulaanexo3":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo3.nuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo3().nuevo();
                        break;
                    }
                    break;
                case "jpAtencionDieta":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAtencionDieta.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAtencionDieta().mNuevo();
                        break;
                    }
                    break;
                case "jpnotac2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpnotas1.mNuevo();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpnotas1().mNuevo();
                        break;
                    }
                    break;
            }
        }
    }

    private void verificacionPanelActivoBotonGrabar(JPanel jPanel, JInternalFrame jInternalFrame) {
        FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
        if (jPanel.getComponentCount() != 0) {
            funcionalidadPanelHistoriaClinica = null;
            if (jInternalFrame.getName().equals("jif_historiaclinicav2")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v2.funcionalidadPanelHistoriaClinica;
            } else if (jInternalFrame.getName().equals("jif_historiaclinicav4")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica;
            }
            switch (jPanel.getComponent(0).getName()) {
                case "jpsuministroh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpsuministroh.grabar();
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            funcionalidadPanelHistoriaClinica.getXjpsuministroh().grabar();
                        } else if (this.historia_Clinica_v4 != null) {
                            this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getXjpsuministroh().grabar();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjpsuministroh().grabar();
                        }
                        break;
                    }
                    break;
                case "jpprocedimientosh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpprocedimientosh.grabar();
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().grabar();
                        } else if (this.historia_Clinica_v4 != null) {
                            this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().grabar();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().grabar();
                        }
                        break;
                    }
                    break;
                case "jpTriageRespiratorio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                            this.xjifhistoriaclinica.triageRespiratorio.grabar();
                        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                            this.xjifhistoriaclinica.triageRespiratorio_V2.grabar();
                        }
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                                funcionalidadPanelHistoriaClinica.getTriageRespiratorio().grabar();
                            } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                                funcionalidadPanelHistoriaClinica.getTriageRespiratorio_V2().grabar();
                            }
                        } else if (this.historia_Clinica_v4 != null) {
                            if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                                this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getTriageRespiratorio().grabar();
                            } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                                this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getTriageRespiratorio_V2().grabar();
                            }
                        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                            funcionalidadPanelHistoriaClinica.getTriageRespiratorio().grabar();
                        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                            funcionalidadPanelHistoriaClinica.getTriageRespiratorio_V2().grabar();
                        }
                        break;
                    }
                    break;
                case "xjif_testagudeza_visual":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjif_testagudeza_visual.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjif_testagudeza_visual().mGrabar();
                        break;
                    }
                    break;
                case "xjp_intervencion_qx":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCirugias1.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCirugias1().mGrabar();
                        break;
                    }
                    break;
                case "jpremisiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones.grabar();
                        break;
                    } else {
                        if (this.historia_Clinica_v4 != null) {
                            this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getXjpremisiones().grabar();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjpremisiones().grabar();
                        }
                        break;
                    }
                    break;
                case "jpremisiones1":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones1.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones1().grabar();
                        break;
                    }
                    break;
                case "jpincapacidades":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpincapacidad.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpincapacidad().grabar();
                        break;
                    }
                    break;
                case "jpincapacidades_v2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.aIncapacidad_v2.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getAIncapacidad_v2().grabar();
                        break;
                    }
                    break;
                case "jpaeventonodeseado":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpeventonodeseado.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpeventonodeseado().grabar();
                        break;
                    }
                    break;
                case "xjif_importaciondochc":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjif_importardochc.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjif_importardochc().mGrabar();
                        break;
                    }
                    break;
                case "jppermisos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjppermisos.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjppermisos().grabar();
                        break;
                    }
                    break;
                case "jifOdontogramaG":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifOdontograma.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifOdontograma().mGrabar();
                        break;
                    }
                    break;
                case "jifOdontogramaClinico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOdontogramaClinico.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOdontogramaClinico().mGrabar();
                        break;
                    }
                    break;
                case "jifOdontogramaI":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOdontogramaInicial.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOdontogramaInicial().mGrabar();
                        break;
                    }
                    break;
                case "jifControlPlaca":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifControlPlaca.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifControlPlaca().mGrabar();
                        break;
                    }
                    break;
                case "xJPEndodoncia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEndoExamenClinico.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEndoExamenClinico().mGrabar();
                        break;
                    }
                    break;
                case "jpnotac":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpnotas.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpnotas().mGrabar();
                        break;
                    }
                    break;
                case "Alimentacion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.grabar("Alimentacion");
                        break;
                    }
                    break;
                case "MotricidadFina":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.grabar("MotricidadFina");
                        break;
                    }
                    break;
                case "xjpseguimientopac":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifseguimiento.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifseguimiento().mGrabar();
                        break;
                    }
                    break;
                case "MotricidadGruesa":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.grabar("MotricidadGruesa");
                        break;
                    }
                    break;
                case "ValoracionLenguaje":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.grabar("ValoracionLenguaje");
                        break;
                    }
                    break;
                case "ValoracionPersonal":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.grabar("ValoracionPersonal");
                        break;
                    }
                    break;
                case "jptratamiento_ordenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftratamiento.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftratamiento().mGrabar();
                        break;
                    }
                    break;
                case "xjptriage":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjptriage.mGrabar();
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            funcionalidadPanelHistoriaClinica.getXjptriage().mGrabar();
                        } else if (this.historia_Clinica_v4 != null) {
                            this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getXjptriage().mGrabar();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjptriage().mGrabar();
                        }
                        break;
                    }
                    break;
                case "xjptest_prespiratorio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftest_prespiratorio.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftest_prespiratorio().mGrabar();
                        break;
                    }
                    break;
                case "xAIEPI":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAiepi.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAiepi().mGuardar();
                        break;
                    }
                    break;
                case "transfusiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPTransfuciones.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPTransfuciones().mGuardar();
                        break;
                    }
                    break;
                case "jptransporteAsistencial":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPTrasnporteAsis.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPTrasnporteAsis().grabar();
                        break;
                    }
                    break;
                case "jpAiepiNinos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAiepiNinos.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAiepiNinos().mGuardar();
                        break;
                    }
                    break;
                case "jpAiepiMadres":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAiepiMadres.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAiepiMadres().mGuardar();
                        break;
                    }
                    break;
                case "jpAiepiMaterna":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getXJPAiepiAtencionMadres().mGuardar();
                        break;
                    }
                    break;
                case "xjpOftamologia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOftamologiaGen.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOftamologiaGen().mGuardar();
                        break;
                    }
                    break;
                case "jifControlPlacaBacteriana":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPControlPlacaCompleto.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPControlPlacaCompleto().mGrabar();
                        break;
                    }
                    break;
                case "xjpAdultoJoven2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJIFAdultoJoven2.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJIFAdultoJoven2().mGuardar();
                        break;
                    }
                    break;
                case "xjPartograma":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPPartograma.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPPartograma().mGrabar();
                        break;
                    }
                    break;
                case "xjp_vacunacion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPVacunacion.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPVacunacion().mGrabar();
                        break;
                    }
                    break;
                case "xjptestfatiga":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjptestfatiga.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjptestfatiga().mGrabar();
                        break;
                    }
                    break;
                case "xjpeventoadverso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEventoAdverso.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEventoAdverso().mGrabar();
                        break;
                    }
                    break;
                case "xevaluacionriesgo":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAEvaluacionRiesgo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAEvaluacionRiesgo().mGrabar();
                        break;
                    }
                    break;
                case "jpFramigan":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPFramingham.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPFramingham().mGuardar();
                        break;
                    }
                    break;
                case "jpFramigan1":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPFramingham1.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPFramingham1().mGuardar();
                        break;
                    }
                    break;
                case "jpFramiganM":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPFraminghamM.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPFraminghamM().mGuardar();
                        break;
                    }
                    break;
                case "jpRuffier":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPRuffier.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPRuffier().mGrabar();
                        break;
                    }
                    break;
                case "jpFindrisk":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPTestFindrisk.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPTestFindrisk().mGuardar();
                        break;
                    }
                    break;
                case "jifBibliotecaSO":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSoBiblioteca.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPSoBiblioteca().mGrabar();
                        break;
                    }
                    break;
                case "revisionxsistemas":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPARevisionSistemas.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPARevisionSistemas().mGrabarBd();
                        break;
                    }
                    break;
                case "jpayudasdxs":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPARevisionAyudasDxS.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPARevisionAyudasDxS().mGrabarBd();
                        break;
                    }
                    break;
                case "jpayudasdxrx":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPARevisionAyudasDxRx.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPARevisionAyudasDxRx().mGrabarBd();
                        break;
                    }
                    break;
                case "jpayudasdx":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPARevisionAyudasDx.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPARevisionAyudasDx().mGrabarBd();
                        break;
                    }
                    break;
                case "jpconclusiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPADiagnostico.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPADiagnostico().mGrabarBd();
                        break;
                    }
                    break;
                case "atencion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAtencion.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAtencion().mGrabarBd();
                        break;
                    }
                    break;
                case "jprsignosvitales":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPRSignosVitales.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPRSignosVitales().mGrabarBd();
                        break;
                    }
                    break;
                case "jpcontroldiabetes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPControlDiabetes.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPControlDiabetes().mGuardar();
                        break;
                    }
                    break;
                case "jpiexamenclinicope":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPIExamenClinicoPE.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPIExamenClinicoPE().mGrabar();
                        break;
                    }
                    break;
                case "jifantecfamiliares":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecentesFamiliares.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecentesFamiliares().mGrabarBd();
                        break;
                    }
                    break;
                case "jpaantecedenteshabitos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecentesHabitos.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecentesHabitos().mGrabarBd();
                        break;
                    }
                    break;
                case "jpaantecedetesppersonales":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecentesPPersonales.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecentesPPersonales().mGrabarBd();
                        break;
                    }
                    break;
                case "jrevisionsistemas":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xRevisionSistemasTabla.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXRevisionSistemasTabla().mGrabar();
                        break;
                    }
                    break;
                case "jpantecedentesppersonalest":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAntecedentesPersonalesTabla.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAntecedentesPersonalesTabla().mGrabar();
                        break;
                    }
                    break;
                case "patologiasasociadas":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAPatologiasAsociadas.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAPatologiasAsociadas().mGrabarBd();
                        break;
                    }
                    break;
                case "jifCeritficadosMedicos":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getXJPCertificadoSO().mGrabar();
                        break;
                    }
                    break;
                case "jpaantecedentespediatricos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecedentesPediatricos.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecedentesPediatricos().mGrabarBd();
                        break;
                    }
                    break;
                case "jifanteodontologicos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecentesOdontologicos.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecentesOdontologicos().mGrabarBd();
                        break;
                    }
                    break;
                case "jpaexamenfisico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAExamenFisico.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAExamenFisico().mGrabarBd();
                        break;
                    }
                    break;
                case "jpahexamenfisico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAHExamenFisico.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAHExamenFisico().mGrabarBd();
                        break;
                    }
                    break;
                case "jpriesgobiosicosocial":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPRiesgoBiosicoSocial.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPRiesgoBiosicoSocial().mGrabar();
                        break;
                    }
                    break;
                case "jpcpresultadoexamenes1":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifpyprevisionexamenes.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifpyprevisionexamenes().mGrabar();
                        break;
                    }
                    break;
                case "jpaexamenfisicoprenatal":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAExamenFisicoPrenatal.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAExamenFisicoPrenatal().mGrabarBd();
                        break;
                    }
                    break;
                case "jpconclusiones1":
                    this.xjifhistoriaclinica.xjifconclusion.mGrabarBd();
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifconclusion.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifconclusion().mGrabarBd();
                        break;
                    }
                    break;
                case "xjp_egreso_uh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEgresoUrgencias.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEgresoUrgencias().mGrabar();
                        break;
                    }
                    break;
                case "AntecedenteGineco":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecedenteGineco.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecedenteGineco().mGrabar();
                        break;
                    }
                    break;
                case "AntecedenteGineco_Nuevo":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAAntecedenteGineco.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAAntecedenteGineco_Nuevo().mGrabar();
                        break;
                    }
                    break;
                case "jphnutricional":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpnutricion.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpnutricion().mGrabarBd();
                        break;
                    }
                    break;
                case "jpatestmorisky":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPATestMorisky.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPATestMorisky().mGrabar();
                        break;
                    }
                    break;
                case "jpsaludocupacional":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPASaludOcupacional.mGrabarRespuestas();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPASaludOcupacional().mGrabarRespuestas();
                        break;
                    }
                    break;
                case "xjifecografia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifecografiagenerico.mGrabarRespuestas();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifecografiagenerico().mGrabarRespuestas();
                        break;
                    }
                    break;
                case "jpaecografiapelvica":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifecografiap.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifecografiap().mGrabar();
                        break;
                    }
                    break;
                case "jpaecografiaobstetrica":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAEcografiaObstetrica.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAEcografiaObstetrica().mGrabar();
                        break;
                    }
                    break;
                case "xjpconceptolaboral":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifconceptosio_i.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifconceptosio_i().mGrabar();
                        break;
                    }
                    break;
                case "xjpconceptolaborale":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifconceptoso_e.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifconceptoso_e().mGrabar();
                        break;
                    }
                    break;
                case "xjpprescripcionejercicio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifprescripcionejercicio.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifprescripcionejercicio().mGrabar();
                        break;
                    }
                    break;
                case "jpoptometria":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifoptometria.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifoptometria().mGrabar();
                        break;
                    }
                    break;
                case "xjpcuestionarios_so":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifcuestionarios.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifcuestionarios().mGrabar();
                        break;
                    }
                    break;
                case "xjpcuestionarios_n":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifcuestionarios_n.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifcuestionarios_n().mGrabar();
                        break;
                    }
                    break;
                case "xjpcuestionarios_sico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSo_CuestionarioSico.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPSo_CuestionarioSico().mGrabar();
                        break;
                    }
                    break;
                case "xjp_pruebaayd":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifpruebaayd.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifpruebaayd().mGrabar();
                        break;
                    }
                    break;
                case "jpgestionriesgo_hta":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpgestionriesgo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpgestionriesgo().mGrabar();
                        break;
                    }
                    break;
                case "jpgestionriesgo_dm":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpgestionriesgo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpgestionriesgo().mGrabar();
                        break;
                    }
                    break;
                case "jp_pyp_hta":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifHTA.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifHTA().mGrabarBd();
                        break;
                    }
                    break;
                case "jp_pyp_diabetes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifdiabetes.mGrabarBd();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifdiabetes().mGrabarBd();
                        break;
                    }
                    break;
                case "jpexamendentario":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPExamenDentario.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPExamenDentario().mGuardar();
                        break;
                    }
                    break;
                case "jpoclusion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOclusion.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOclusion().mGuardar();
                        break;
                    }
                    break;
                case "jpcefalometria":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCefalometria.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCefalometria().mGuardar();
                        break;
                    }
                    break;
                case "jpanalisisoclusal":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAnalisiOclusal.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAnalisiOclusal().mGuardar();
                        break;
                    }
                    break;
                case "jpanalisisestomatologico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAnalisisEstomatologico.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAnalisisEstomatologico().mGuardar();
                        break;
                    }
                    break;
                case "jpanalisisfuncional":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAnalisisFuncional.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAnalisisFuncional().mGuardar();
                        break;
                    }
                    break;
                case "jpescalaabreviada":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEscalaAbreviada.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEscalaAbreviada().mGuardar();
                        break;
                    }
                    break;
                case "jpfiltroifg":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPFiltroIFG.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPFiltroIFG().mGrabar();
                        break;
                    }
                    break;
                case "jifadultojoven":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJIFAdultoJoven.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJIFAdultoJoven().mGrabar();
                        break;
                    }
                    break;
                case "jpsociodemografico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSociodemografico.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPSociodemografico().mGrabar();
                        break;
                    }
                    break;
                case "xJPPlanificacionFliar":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPPlanificacionFliar.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPPlanificacionFliar().mGrabar();
                        break;
                    }
                    break;
                case "jprevisionexamenso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPRevisonExamenSo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPRevisonExamenSo().mGrabar();
                        break;
                    }
                    break;
                case "xjifEscalaDolor":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEscalaDolor.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEscalaDolor().mGuardar();
                        break;
                    }
                    break;
                case "xjpExamenReumatologia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPReuConteoArticulaciones.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPReuConteoArticulaciones().mGuardar();
                        break;
                    }
                    break;
                case "xjifEscalaFM":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEscalaFuerzaMuscular.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEscalaFuerzaMuscular().mGuardar();
                        break;
                    }
                    break;
                case "xjp_historia_terapia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        if (this.xjifhistoriaclinica.xjif_terapiaf.JTPDatosHc.getSelectedIndex() == 0 || this.xjifhistoriaclinica.xjif_terapiaf.JTPDatosHc.getSelectedIndex() == 1) {
                            this.xjifhistoriaclinica.xjif_terapiaf.mGrabar();
                        } else if (this.xjifhistoriaclinica.xjif_terapiaf.JTPDatosHc.getSelectedIndex() == 2) {
                            this.xjifhistoriaclinica.xjif_terapiaf.mGrabar_Seguimiento();
                        } else if (this.xjifhistoriaclinica.xjif_terapiaf.JTPDatosHc.getSelectedIndex() == 3) {
                            this.xjifhistoriaclinica.xjif_terapiaf.mGrabar_Cierre();
                        }
                        break;
                    } else {
                        if (funcionalidadPanelHistoriaClinica.getXjif_terapiaf().JTPDatosHc.getSelectedIndex() == 0 || funcionalidadPanelHistoriaClinica.getXjif_terapiaf().JTPDatosHc.getSelectedIndex() == 1) {
                            funcionalidadPanelHistoriaClinica.getXjif_terapiaf().mGrabar();
                        } else if (funcionalidadPanelHistoriaClinica.getXjif_terapiaf().JTPDatosHc.getSelectedIndex() == 2) {
                            funcionalidadPanelHistoriaClinica.getXjif_terapiaf().mGrabar_Seguimiento();
                        } else if (funcionalidadPanelHistoriaClinica.getXjif_terapiaf().JTPDatosHc.getSelectedIndex() == 3) {
                            funcionalidadPanelHistoriaClinica.getXjif_terapiaf().mGrabar_Cierre();
                        }
                        break;
                    }
                    break;
                case "xjpcertificadoso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCertificadoSO.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCertificadoSO().mGrabar();
                        break;
                    }
                    break;
                case "xjpgaleriaimagenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPGaleriaImagenes.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPGaleriaImagenes().mGuardar();
                        break;
                    }
                    break;
                case "xjpsopsicomotriz":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSo_Psicomotriz.mGrabar();
                        break;
                    } else {
                        if (jInternalFrame.getName().equals("jif_historiaclinicav3")) {
                            Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mGrabar();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mGrabar();
                        }
                        break;
                    }
                    break;
                case "xjpdeprecionposparto":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPDepresionPosparto.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPDepresionPosparto().mGrabar();
                        break;
                    }
                    break;
                case "xjpmaltratoviolencia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPMaltratoViolencia.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPMaltratoViolencia().mGrabar();
                        break;
                    }
                    break;
                case "xjtpClasificacionEular":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAClasificacionEular.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAClasificacionEular().mGrabar();
                        break;
                    }
                    break;
                case "xjpCuestionarioHAQ":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCuestionarioHAQ.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCuestionarioHAQ().mGrabar();
                        break;
                    }
                    break;
                case "xjpVisiometriaM":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSo_VisiometriaMineros.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPSo_VisiometriaMineros().mGuardar();
                        break;
                    }
                    break;
                case "jpa_atencion_informacionn10":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPA_Atencion_InformacionN10.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPA_Atencion_InformacionN10().mGrabar();
                        break;
                    }
                    break;
                case "xJPFamiliograma":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAFamiliograma.mGuardar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAFamiliograma().mGuardar();
                        break;
                    }
                    break;
                case "JPAEscalaAbreviadaDeDesarrollo_V2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.jPAEscalaAbreviadaDeDesarrollo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getJPAEscalaAbreviadaDeDesarrollo_V2().mGrabar();
                        break;
                    }
                    break;
                case "JPAEscalaAbreviadaDeDesarrollo":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.jPAEscalaAbreviadaDeDesarrollo.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getJPAEscalaAbreviadaDeDesarrollo().mGrabar();
                        break;
                    }
                    break;
                case "glasgowHC":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPGlasgow.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPGlasgow().mGrabar();
                        break;
                    }
                    break;
                case "jptratamiento_ordenes_nuevas":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getOrden_Tratamiento_Nueva().grabar();
                        break;
                    }
                    break;
                case "JPAVale":
                    funcionalidadPanelHistoriaClinica.getJPaVale().mGrabar();
                    break;
                case "jpi_formulario_anexo2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo2.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo2().grabar();
                        break;
                    }
                    break;
                case "xjpi_formulaanexo3":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo3.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo3().grabar();
                        break;
                    }
                    break;
                case "jpAtencionDieta":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPAtencionDieta.mGrabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPAtencionDieta().mGrabar();
                        break;
                    }
                    break;
                case "jpa_TestCrb65":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.testCrb65.grabar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getTestCrb65().grabar();
                        break;
                    }
                    break;
            }
        }
    }

    private void verificacionPanelActivoBotonBuscar(JPanel jPanel, JInternalFrame jInternalFrame) {
        FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
        if (jPanel.getComponentCount() != 0) {
            funcionalidadPanelHistoriaClinica = null;
            if (jInternalFrame.getName().equals("jif_historiaclinicav2")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v2.funcionalidadPanelHistoriaClinica;
            } else if (jInternalFrame.getName().equals("jif_historiaclinicav4")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica;
            }
            switch (jPanel.getComponent(0).getName()) {
                case "jpsuministroh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpsuministroh.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpsuministroh().buscar();
                        break;
                    }
                    break;
                case "jpprocedimientosh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpprocedimientosh.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().buscar();
                        break;
                    }
                    break;
                case "jpremisiones":
                    this.xjifhistoriaclinica.xjpremisiones.buscar();
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones().buscar();
                        break;
                    }
                    break;
                case "jpremisiones1":
                    this.xjifhistoriaclinica.xjpremisiones1.buscar();
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones1.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones1().buscar();
                        break;
                    }
                    break;
                case "jpincapacidades":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpincapacidad.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpincapacidad().buscar();
                        break;
                    }
                    break;
                case "jpincapacidades_v2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.aIncapacidad_v2.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getAIncapacidad_v2().buscar();
                        break;
                    }
                    break;
                case "jpaeventonodeseado":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpeventonodeseado.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpeventonodeseado().buscar();
                        break;
                    }
                    break;
                case "jppermisos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjppermisos.buscar();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjppermisos().buscar();
                        break;
                    }
                    break;
            }
        }
    }

    private void verificacionPanelActivoBotonImprimir(JPanel jPanel, JInternalFrame jInternalFrame) {
        FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
        if (jPanel.getComponentCount() != 0) {
            funcionalidadPanelHistoriaClinica = null;
            if (jInternalFrame.getName().equals("jif_historiaclinicav2")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v2.funcionalidadPanelHistoriaClinica;
            } else if (jInternalFrame.getName().equals("jif_historiaclinicav4")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica;
            }
            switch (jPanel.getComponent(0).getName()) {
                case "jpprocedimientosh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpprocedimientosh.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().imprimir();
                        break;
                    }
                    break;
                case "jpsuministroh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpsuministroh.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpsuministroh().imprimir();
                        break;
                    }
                    break;
                case "jpTriageRespiratorio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                            this.xjifhistoriaclinica.triageRespiratorio.imprimir();
                        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                            this.xjifhistoriaclinica.triageRespiratorio_V2.imprimir();
                        }
                        break;
                    } else {
                        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                            funcionalidadPanelHistoriaClinica.getTriageRespiratorio().imprimir();
                        } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                            funcionalidadPanelHistoriaClinica.getTriageRespiratorio_V2().imprimir();
                        }
                        funcionalidadPanelHistoriaClinica.getTriageRespiratorio().imprimir();
                        break;
                    }
                    break;
                case "jpremisiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones.imprimir();
                        break;
                    } else {
                        if (this.historia_Clinica_v4 != null) {
                            this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.getXjpremisiones().imprimir();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjpremisiones().imprimir();
                        }
                        break;
                    }
                    break;
                case "jpremisiones1":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones1.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones1().imprimir();
                        break;
                    }
                    break;
                case "jpincapacidades":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpincapacidad.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpincapacidad().imprimir();
                        break;
                    }
                    break;
                case "jpincapacidades_v2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.aIncapacidad_v2.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getAIncapacidad_v2().imprimir();
                        break;
                    }
                    break;
                case "jpaeventonodeseado":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpeventonodeseado.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpeventonodeseado().imprimir();
                        break;
                    }
                    break;
                case "jppermisos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjppermisos.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjppermisos().imprimir();
                        break;
                    }
                    break;
                case "jpnotac":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpnotas.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpnotas().mImprimir();
                        break;
                    }
                    break;
                case "jpvisiometria":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifvisiometria.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifvisiometria().mImprimir();
                        break;
                    }
                    break;
                case "jifaudiometria_so":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifaudiometria.mImprimir(informacionAgendaMedicaDTO.getIdAtencion());
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifaudiometria().mImprimir(informacionAgendaMedicaDTO.getIdAtencion());
                        break;
                    }
                    break;
                case "jifaudiometria_so2":
                    this.xjifhistoriaclinica.xJPSo_Audiometria_nueva.mImprimir(informacionAgendaMedicaDTO.getIdAtencion());
                    break;
                case "xjifespirometria":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifespirometria.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifespirometria().mImprimir();
                        break;
                    }
                    break;
                case "xjifecografia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifecografiagenerico.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifecografiagenerico().mImprimir();
                        break;
                    }
                    break;
                case "xjpprescripcionejercicio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifprescripcionejercicio.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifprescripcionejercicio().mImprimir();
                        break;
                    }
                    break;
                case "xjpconceptolaboral":
                    switch (jInternalFrame.getName()) {
                        case "jifhistoriaclinica":
                            this.xjifhistoriaclinica.xjifconceptosio_i.mImprimir();
                            break;
                        case "jif_historiaclinicav3":
                            Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXjifconceptosio_i().mImprimir2();
                            break;
                        default:
                            funcionalidadPanelHistoriaClinica.getXjifconceptosio_i().mImprimir();
                            break;
                    }
                    break;
                case "jifaudiometria_so_nuevo":
                    if (jInternalFrame.getName().equals("jif_historiaclinicav3")) {
                        Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getAudiometria_nueva1().mImprimir2();
                        break;
                    }
                    break;
                case "jpoptometria":
                    if (jInternalFrame.getName().equals("jif_historiaclinicav3")) {
                        Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXjifoptometria().mImprimir(informacionAgendaMedicaDTO.getIdAtencion().toString());
                        break;
                    }
                    break;
                case "xjpconceptolaborale":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifconceptoso_e.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifconceptoso_e().mImprimir();
                        break;
                    }
                    break;
                case "xjptriage":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjptriage.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjptriage().mImprimir();
                        break;
                    }
                    break;
                case "jifControlPlaca":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifControlPlaca.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifControlPlaca().mImprimir();
                        break;
                    }
                    break;
                case "xjpcuestionarios_so":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjifcuestionarios.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjifcuestionarios().mImprimir();
                        break;
                    }
                    break;
                case "jptratamiento_ordenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftratamiento.mImprimir();
                        break;
                    } else {
                        if (this.historia_Clinica_v2 != null) {
                            funcionalidadPanelHistoriaClinica.getXjiftratamiento().mImprimir();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXjiftratamiento().mImprimir();
                        }
                        break;
                    }
                    break;
                case "xjptest_prespiratorio":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftest_prespiratorio.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftest_prespiratorio().mImprimir();
                        break;
                    }
                    break;
                case "xJPEndodoncia":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEndoExamenClinico.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEndoExamenClinico().mImprimir();
                        break;
                    }
                    break;
                case "xjpcuestionarios_sico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSo_CuestionarioSico.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPSo_CuestionarioSico().mImprimir();
                        break;
                    }
                    break;
                case "jptransporteAsistencial":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPTrasnporteAsis.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPTrasnporteAsis().imprimir();
                        break;
                    }
                    break;
                case "xjp_impresion_doc":
                    switch (jInternalFrame.getName()) {
                        case "jifhistoriaclinica":
                            this.xjifhistoriaclinica.xJPImpresion_Doc.mImprimir();
                            break;
                        case "jif_historiaclinicav3":
                            Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXJPImpresion_Doc().mImprimir();
                            break;
                        default:
                            funcionalidadPanelHistoriaClinica.getXJPImpresion_Doc().mImprimir();
                            break;
                    }
                    break;
                case "jifControlPlacaBacteriana":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPControlPlacaCompleto.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPControlPlacaCompleto().mImprimir();
                        break;
                    }
                    break;
                case "xjPartograma":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPPartograma.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPPartograma().mImprimir();
                        break;
                    }
                    break;
                case "xjp_intervencion_qx":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCirugias1.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCirugias1().mImprimir();
                        break;
                    }
                    break;
                case "xjpeventoadverso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEventoAdverso.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEventoAdverso().mImprimir();
                        break;
                    }
                    break;
                case "xjpcertificadoso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPCertificadoSO.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPCertificadoSO().mImprimir();
                        break;
                    }
                    break;
                case "xjpsopsicomotriz":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPSo_Psicomotriz.mImprimir();
                        break;
                    } else {
                        if (jInternalFrame.getName().equals("jif_historiaclinicav3")) {
                            Principal.xclaseso.historia_Clinica_v3.funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mImprimir();
                        } else {
                            funcionalidadPanelHistoriaClinica.getXJPSo_Psicomotriz().mImprimir();
                        }
                        break;
                    }
                    break;
                case "jpi_notas_evoluciones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xNotasMedicasNa.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXNotasMedicasNa().mImprimir();
                        break;
                    }
                    break;
                case "jpi_notas_procedimientosmenores":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xA_NotasProcedimientosMenores.mImprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXA_NotasProcedimientosMenores().mImprimir();
                        break;
                    }
                    break;
                case "jptratamiento_ordenes_nuevas":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getOrden_Tratamiento_Nueva().imprimir();
                        break;
                    }
                    break;
                case "jpi_formulario_anexo2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo2.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo2().imprimir();
                        break;
                    }
                    break;
                case "xjpi_formulaanexo3":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.formularioAnexo3.imprimir();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getFormularioAnexo3().imprimir();
                        break;
                    }
                    break;
            }
        }
    }

    private void verificacionPanelActivoBotonAnular(JPanel jPanel, JInternalFrame jInternalFrame) {
        FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
        if (jPanel.getComponentCount() != 0) {
            funcionalidadPanelHistoriaClinica = null;
            if (jInternalFrame.getName().equals("jif_historiaclinicav2")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v2.funcionalidadPanelHistoriaClinica;
            } else if (jInternalFrame.getName().equals("jif_historiaclinicav4")) {
                funcionalidadPanelHistoriaClinica = this.historia_Clinica_v4.funcionalidadPanelHistoriaClinica;
            }
            switch (jPanel.getComponent(0).getName()) {
                case "jpsuministroh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpsuministroh.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpsuministroh().anular();
                        break;
                    }
                    break;
                case "jpprocedimientosh":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpprocedimientosh.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpprocedimientosh().anular();
                        break;
                    }
                    break;
                case "jpremisiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones().anular();
                        break;
                    }
                    break;
                case "jpremisiones1":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpremisiones1.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpremisiones1().anular();
                        break;
                    }
                    break;
                case "jpincapacidades":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpincapacidad.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpincapacidad().anular();
                        break;
                    }
                    break;
                case "jpincapacidades_v2":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.aIncapacidad_v2.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getAIncapacidad_v2().anular();
                        break;
                    }
                    break;
                case "transfusiones":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPTransfuciones.mAnular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPTransfuciones().mAnular();
                        break;
                    }
                    break;
                case "jpaeventonodeseado":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjpeventonodeseado.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjpeventonodeseado().anular();
                        break;
                    }
                    break;
                case "jppermisos":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjppermisos.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjppermisos().anular();
                        break;
                    }
                    break;
                case "Alimentacion":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.anular("Alimentacion");
                        break;
                    }
                    break;
                case "jptratamiento_ordenes":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xjiftratamiento.mAnular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXjiftratamiento().mAnular();
                        break;
                    }
                    break;
                case "jptratamiento_ordenes_nuevas":
                    if (!jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        funcionalidadPanelHistoriaClinica.getOrden_Tratamiento_Nueva().anular();
                        break;
                    }
                    break;
                case "xjpeventoadverso":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPEventoAdverso.mAnular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPEventoAdverso().mAnular();
                        break;
                    }
                    break;
                case "jifOdontogramaI":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOdontogramaInicial.mAnular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOdontogramaInicial().mAnular();
                        break;
                    }
                    break;
                case "jifOdontogramaClinico":
                    if (jInternalFrame.getName().equals("jifhistoriaclinica")) {
                        this.xjifhistoriaclinica.xJPOdontogramaClinico.anular();
                        break;
                    } else {
                        funcionalidadPanelHistoriaClinica.getXJPOdontogramaInicial().mAnular();
                        break;
                    }
                    break;
            }
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonNuevo(this.xjifhistoriaclinica.JPIDetalleAtencion, this.xjifhistoriaclinica);
                break;
            case "jif_historiaclinicav2":
            case "jif_historiaclinicav3":
            case "jif_historiaclinicav4":
                if (this.historia_Clinica_v2 != null) {
                    verificacionPanelActivoBotonNuevo(this.historia_Clinica_v2.JPI_PanelPrincipal, this.historia_Clinica_v2);
                    break;
                } else {
                    if (Principal.xclaseso != null && Principal.xclaseso.historia_Clinica_v3 != null) {
                        verificacionPanelActivoBotonNuevo(Principal.xclaseso.historia_Clinica_v3.JPI_PanelPrincipal, Principal.xclaseso.historia_Clinica_v3);
                    } else if (this.historia_Clinica_v4 != null) {
                        verificacionPanelActivoBotonNuevo(this.historia_Clinica_v4.JPI_PanelPrincipal, this.historia_Clinica_v4);
                    } else {
                        verificacionPanelActivoBotonNuevo(this.historia_Clinica_Cirugia.JPI_PanelPrincipal, this.historia_Clinica_Cirugia);
                    }
                    break;
                }
                break;
            case "jifconsultarhistorial":
                this.xjifconsultarhc.nuevo();
                break;
            case "jifconsultarhistorialadx":
                this.xjifconsultaradx.nuevo();
                break;
            case "jifformulapyp":
                this.xjifformulaspyp.nuevo();
                break;
            case "jifpermisomedicos":
                this.xjifpermiso.nuevo();
                break;
            case "jifincapacidad":
                this.xjifincapacidad.nuevo();
                break;
            case "jifreporte5":
                this.xjifreporte.nuevo();
                break;
            case "jifvisitadomiciliaria":
            case "xjifnotasmedicas":
                this.xjivisitad.nuevo();
                break;
            case "jifjuntamedica":
                this.xjijuntamed.nuevo();
                break;
            case "jifconstanciaservicio":
                this.xjifgenerarcerti.mNuevo();
                break;
            case "jifautorizaciondocumentos1":
                this.xjifautorizacionorden.mNuevo();
                break;
            case "jifconsultarexamenesusuario":
                this.xjiconsultarexusuario.mNuevo();
                break;
            case "jifconsultarRemOrdHist":
                this.xjiconsultarexusuario.mNuevo();
                break;
            case "xjifcensocama1":
                this.xJIFCensoCama.mNuevo();
                break;
            case "jpnotac2":
                this.Xjpnotas1.mNuevo();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonGrabar(this.xjifhistoriaclinica.JPIDetalleAtencion, this.xjifhistoriaclinica);
                break;
            case "jif_historiaclinicav2":
            case "jif_historiaclinicav3":
            case "jif_historiaclinicav4":
                if (this.historia_Clinica_v2 != null) {
                    verificacionPanelActivoBotonGrabar(this.historia_Clinica_v2.JPI_PanelPrincipal, this.historia_Clinica_v2);
                    break;
                } else {
                    if (Principal.xclaseso != null && Principal.xclaseso.historia_Clinica_v3 != null) {
                        verificacionPanelActivoBotonGrabar(Principal.xclaseso.historia_Clinica_v3.JPI_PanelPrincipal, Principal.xclaseso.historia_Clinica_v3);
                    } else if (this.historia_Clinica_v4 != null) {
                        verificacionPanelActivoBotonGrabar(this.historia_Clinica_v4.JPI_PanelPrincipal, this.historia_Clinica_v4);
                    } else {
                        verificacionPanelActivoBotonGrabar(this.historia_Clinica_Cirugia.JPI_PanelPrincipal, this.historia_Clinica_Cirugia);
                    }
                    break;
                }
                break;
            case "jifformulapyp":
                this.xjifformulaspyp.grabar();
                break;
            case "jifpermisomedicos":
                this.xjifpermiso.grabar();
                break;
            case "jifincapacidad":
                this.xjifincapacidad.grabar();
                break;
            case "jifreporte5":
                this.xjifreporte.grabar();
                break;
            case "jifvisitadomiciliaria":
            case "xjifnotasmedicas":
                this.xjivisitad.grabar();
                break;
            case "jifjuntamedica":
                this.xjijuntamed.grabar();
                break;
            case "jifconstanciaservicio":
                this.xjifgenerarcerti.mGrabar();
                break;
            case "jifautorizaciondocumentos1":
                this.xjifautorizacionorden.mGrabar();
                break;
            case "jifseguimientolab":
                this.xjifseguimientollab.mGrabar();
                break;
            case "JPAVale":
                this.jPAVale.mGrabar();
                break;
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonBuscar(this.xjifhistoriaclinica.JPIDetalleAtencion, this.xjifhistoriaclinica);
                break;
            case "jif_historiaclinicav2":
            case "jif_historiaclinicav3":
            case "jif_historiaclinicav4":
                if (this.historia_Clinica_v2 != null) {
                    verificacionPanelActivoBotonBuscar(this.historia_Clinica_v2.JPI_PanelPrincipal, this.historia_Clinica_v2);
                    break;
                } else {
                    if (Principal.xclaseso != null && Principal.xclaseso.historia_Clinica_v3 != null) {
                        verificacionPanelActivoBotonBuscar(Principal.xclaseso.historia_Clinica_v3.JPI_PanelPrincipal, Principal.xclaseso.historia_Clinica_v3);
                    } else if (this.historia_Clinica_v4 != null) {
                        verificacionPanelActivoBotonBuscar(this.historia_Clinica_v4.JPI_PanelPrincipal, this.historia_Clinica_v4);
                    } else {
                        verificacionPanelActivoBotonBuscar(this.historia_Clinica_Cirugia.JPI_PanelPrincipal, this.historia_Clinica_Cirugia);
                    }
                    break;
                }
                break;
            case "jifconsultarhistorial":
                this.xjifconsultarhc.buscar();
                break;
            case "jifconsultarhistorialadx":
                this.xjifconsultaradx.buscar();
                break;
            case "jifformulapyp":
                this.xjifformulaspyp.buscar();
                break;
            case "jifpermisomedicos":
                this.xjifpermiso.buscar();
                break;
            case "jifconsultarresultado":
                this.xjifconsultarexamen.mBuscar();
                break;
            case "jifconsultarexamenesusuario":
                this.xjiconsultarexusuario.mBuscar();
                break;
            case "jifincapacidad":
                this.xjifincapacidad.buscar();
                break;
            case "jifvisitadomiciliaria":
            case "xjifnotasmedicas":
                this.xjivisitad.mBuscar();
                break;
            case "jifjuntamedica":
                this.xjijuntamed.buscar();
                break;
            case "jifconstanciaservicio":
                this.xjifgenerarcerti.mBuscar();
                break;
            case "jifautorizaciondocumentos1":
                this.xjifautorizacionorden.mBuscar();
                break;
            case "jifconsultarRemOrdHist":
                this.xjiconsultarexusuario.mBuscar();
                break;
            case "jif_ReportesPyP_hc":
                this.jifreportes.mBuscar();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonImprimir(this.xjifhistoriaclinica.JPIDetalleAtencion, this.xjifhistoriaclinica);
                break;
            case "jifconsultarhistorial":
                this.xjifconsultarhc.imprimir();
                break;
            case "jif_historiaclinicav2":
            case "jif_historiaclinicav3":
            case "jif_historiaclinicav4":
                if (this.historia_Clinica_v2 != null) {
                    verificacionPanelActivoBotonImprimir(this.historia_Clinica_v2.JPI_PanelPrincipal, this.historia_Clinica_v2);
                    break;
                } else {
                    if (Principal.xclaseso != null && Principal.xclaseso.historia_Clinica_v3 != null) {
                        verificacionPanelActivoBotonImprimir(Principal.xclaseso.historia_Clinica_v3.JPI_PanelPrincipal, Principal.xclaseso.historia_Clinica_v3);
                    } else if (this.historia_Clinica_v4 != null) {
                        verificacionPanelActivoBotonImprimir(this.historia_Clinica_v4.JPI_PanelPrincipal, this.historia_Clinica_v4);
                    } else {
                        verificacionPanelActivoBotonImprimir(this.historia_Clinica_Cirugia.JPI_PanelPrincipal, this.historia_Clinica_Cirugia);
                    }
                    break;
                }
                break;
            default:
                switch (frm) {
                    case "jifformulapyp":
                        this.xjifformulaspyp.imprimir();
                        break;
                    case "jifpermisomedicos":
                        this.xjifpermiso.imprimir();
                        break;
                    case "jifincapacidad":
                        this.xjifincapacidad.imprimir1();
                        break;
                    case "jifreportesh":
                        this.xjifreporteh.mImprimir();
                        break;
                    case "jifjuntamedica":
                        this.xjijuntamed.mImprimir1();
                        break;
                    case "jifconstanciaservicio":
                        this.xjifgenerarcerti.mImprimir();
                        break;
                    case "jif_agendamedico":
                        this.xjifagendan.mImprimir();
                        break;
                    case "xjifcensocama1":
                        this.xJIFCensoCama.mImprimir();
                        break;
                }
                break;
        }
    }

    public void mImpirmirHC() {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = informacionAgendaMedicaDTO.getIdAtencion();
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = String.valueOf(informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mparametros[2][0] = "rutaSo";
        mparametros[2][1] = this.xmetodo.getRutaRep();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 3) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaNutricion", mparametros);
            return;
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinica", mparametros);
            return;
        }
        if (informacionAgendaMedicaDTO.getIdClaseCita().intValue() == 0) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaOft", mparametros);
                return;
            } else {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinica1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaOft", mparametros);
        } else {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinica_Urgencias", mparametros);
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_Historia_Clinica_Medicamento", mparametros);
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifhistoriaclinica":
                verificacionPanelActivoBotonAnular(this.xjifhistoriaclinica.JPIDetalleAtencion, this.xjifhistoriaclinica);
                break;
            case "jif_historiaclinicav2":
            case "jif_historiaclinicav3":
            case "jif_historiaclinicav4":
                if (this.historia_Clinica_v2 != null) {
                    verificacionPanelActivoBotonAnular(this.historia_Clinica_v2.JPI_PanelPrincipal, this.historia_Clinica_v2);
                    break;
                } else {
                    if (Principal.xclaseso != null && Principal.xclaseso.historia_Clinica_v3 != null) {
                        verificacionPanelActivoBotonAnular(Principal.xclaseso.historia_Clinica_v3.JPI_PanelPrincipal, Principal.xclaseso.historia_Clinica_v3);
                    } else if (this.historia_Clinica_v4 != null) {
                        verificacionPanelActivoBotonAnular(this.historia_Clinica_v4.JPI_PanelPrincipal, this.historia_Clinica_v4);
                    } else {
                        verificacionPanelActivoBotonAnular(this.historia_Clinica_Cirugia.JPI_PanelPrincipal, this.historia_Clinica_Cirugia);
                    }
                    break;
                }
                break;
            default:
                switch (frm) {
                    case "jifpermisomedicos":
                        this.xjifpermiso.anular();
                        break;
                    case "jifconstanciaservicio":
                        this.xjifgenerarcerti.mAnular();
                        break;
                    case "jifincapacidad":
                        this.xjifincapacidad.mAnular();
                        break;
                    case "jifformulapyp":
                        this.xjifformulaspyp.mAnular();
                        break;
                }
                break;
        }
    }

    public boolean mImprimirRemisiones(String xid) {
        boolean xestado = false;
        try {
            this.xsql = "SELECT Detalle FROM h_remisiones WHERE (Id ='" + xid + "') ";
            ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getString(1).length() > 400) {
                    xestado = true;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(clasesHistoriaCE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    /* JADX WARN: Finally extract failed */
    public void mBuscarAtencionIngreso() {
        try {
            String sql = "SELECT Id FROM h_atencion WHERE (Id_Ingreso ='" + informacionAgendaMedicaDTO.getIdIngreso() + "')";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.first();
                    informacionAgendaMedicaDTO.setIdAtencion(rs.getString(1));
                } else {
                    informacionAgendaMedicaDTO.setIdAtencion("0");
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.xconsultasbd.cerrarConexionBd();
            } catch (Throwable th3) {
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        rs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(clasesHistoriaCE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscarMotivoConsulta() {
        String sql = "SELECT Motivo_Atencion  FROM baseserver.h_atencion WHERE (Id ='" + informacionAgendaMedicaDTO.getIdAtencion() + "')";
        informacionAgendaMedicaDTO.setMotivoConsulta(this.xconsultasbd.traerDato(sql));
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mCambiarEstadoCita() {
        if (informacionAgendaMedicaDTO.getTipoCita() != null) {
            if ((informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 0 || informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) && informacionAgendaMedicaDTO.getTipoCita().intValue() == 0) {
                this.xsql = "Update c_citas set Asistida=3 where id='" + informacionAgendaMedicaDTO.getIdCita() + "'";
            } else {
                this.xsql = "Update c_citasnp set Asistida=3 where id='" + informacionAgendaMedicaDTO.getIdCita() + "'";
            }
            this.xconsultasbd.ejecutarSQL(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    public void mCambiarEstadoOrdenProcedimiento() {
        if (informacionAgendaMedicaDTO.getIdOrden().longValue() != 0 && informacionAgendaMedicaDTO.getIdProcedimiento().longValue() != 0) {
            this.xsql = "Update f_itemordenesproced set EsRecepcionado=1 where Id_Ordenes='" + informacionAgendaMedicaDTO.getIdOrden() + "' and Id_Procedimiento='" + informacionAgendaMedicaDTO.getIdProcedimiento() + "'";
        }
        if (this.xsql != null) {
            this.xconsultasbd.ejecutarSQL(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    public void mCambiarEstadoOrdenProcedimiento(int estadoRecepcion) {
        if (informacionAgendaMedicaDTO.getIdOrden() != null || informacionAgendaMedicaDTO.getIdProcedimiento() != null) {
            if (informacionAgendaMedicaDTO.getIdOrden().longValue() != 0 && informacionAgendaMedicaDTO.getIdProcedimiento().longValue() != 0) {
                this.xsql = "Update f_itemordenesproced set EsRecepcionado=" + estadoRecepcion + " where Id_Ordenes='" + informacionAgendaMedicaDTO.getIdOrden() + "' and Id_Procedimiento='" + informacionAgendaMedicaDTO.getIdProcedimiento() + "'";
            }
            if (this.xsql != null) {
                this.xconsultasbd.ejecutarSQL(this.xsql);
                this.xconsultasbd.cerrarConexionBd();
            }
        }
    }

    public void mCambiarEstadoCitaNP() {
        this.xsql = "update c_citasnp set Asistida=2 where Id='" + informacionAgendaMedicaDTO.getIdCita() + "'";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mCambiarEstadoHc(int xtipo) {
        this.xsql = "Update h_atencion set TipoGuardado='" + xtipo + "' where id='" + informacionAgendaMedicaDTO.getIdAtencion() + "'";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mActualizarDx_Ingreso(String x_Dx) {
        this.xsql = "Update ingreso set DxIngreso='" + x_Dx + "' where id='" + informacionAgendaMedicaDTO.getIdIngreso() + "'";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mActualizarFechaHoraIniciaAtencion() {
        this.xsql = "Update h_atencion set Fecha_Atencion=DATE(NOW()), Hora_Atencion=TIME(NOW()), Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', InicioAtencion=1 where id='" + informacionAgendaMedicaDTO.getIdAtencion() + "' and InicioAtencion=0";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mEnviarCorreoporPerimetroAbd() {
        try {
            String sql = "SELECT PerimetroAbdominal FROM h_examenfisico WHERE (Id_Atencion ='" + informacionAgendaMedicaDTO.getIdAtencion() + "' AND PerimetroAbdominal <>0) ";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (informacionAgendaMedicaDTO.getNombreSexo().equals("MASCULINO")) {
                    if (xrs.getDouble(1) > 94.0d) {
                        String mensaje = "La atención N° " + informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + informacionAgendaMedicaDTO.getNumeroHistoria() + " del paciente: " + informacionAgendaMedicaDTO.getNombreUsuario() + "\n Tiene un perímetro abdominal de : " + xrs.getDouble(1) + "  Favor Revisar.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                        this.xmetodo.mEnvioCorreoElectronico(mensaje, "nutricion@fundacionpanzenu.org.co", "PERIMETRO ABDOMINAL ELEVADO", Principal.usuarioSistemaDTO.getLogin());
                    }
                } else if (xrs.getDouble(1) > 88.0d) {
                    String mensaje2 = "La atención N° " + informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + informacionAgendaMedicaDTO.getNumeroHistoria() + " del paciente: " + informacionAgendaMedicaDTO.getNombreUsuario() + "\n Tiene un perímetro abdominal de : " + xrs.getDouble(1) + "  Favor Revisar.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                    this.xmetodo.mEnvioCorreoElectronico(mensaje2, "nutricion@fundacionpanzenu.org.co", "PERIMETRO ABDOMINAL ELEVADO", Principal.usuarioSistemaDTO.getLogin());
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(clasesHistoriaCE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarVariable_ManPower(String xvariable_tabla, String xresultado, String xvariable_tabla1, String xresultado1) {
        this.xsql = "Update so_manporwer_detalle set " + xvariable_tabla + "='" + xresultado + "'," + xvariable_tabla1 + "='" + xresultado1 + "', FechaPA='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', Id_Atencion='" + informacionAgendaMedicaDTO.getIdAtencion() + "' where id='" + informacionAgendaMedicaDTO.getIdManPower() + "'";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mActualizarVariable_ManPower_Efreso(String xvariable_tabla, String xresultado, String xvariable_tabla1, String xresultado1) {
        this.xsql = "Update so_manporwer_detalle set " + xvariable_tabla + "='" + xresultado + "'," + xvariable_tabla1 + "='" + xresultado1 + "', FechaE='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "' where id='" + informacionAgendaMedicaDTO.getIdManPower() + "'";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mActualizarAlterado_ManPower() {
        this.xsql = "update so_manporwer_detalle set Alterado=1 where id='" + informacionAgendaMedicaDTO.getIdManPower() + "' and Alterado=0";
        this.xconsultasbd.ejecutarSQL(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mImprimir_Hc(String xid_Atencion) {
        try {
            this.xsql = "SELECT `ingreso`.`Id_Usuario` , `h_tipohistoria`.`Reporte` , `h_atencion`.`Id_Especialidad`, `ingreso`.`Id_TipoAtencion` FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`h_atencion`.`Id` ='" + xid_Atencion + "') ";
            ResultSet xrs1 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs1.next()) {
                xrs1.first();
                String[][] mparametros = new String[5][2];
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    mparametros = new String[6][2];
                    mparametros[5][0] = "nombreItem";
                    mparametros[5][1] = this.historia_Clinica_v2.nombreItem;
                }
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = xid_Atencion;
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = xrs1.getString(1);
                mparametros[2][0] = "rutaSo";
                mparametros[2][1] = this.xmetodo.getRutaRep();
                mparametros[3][0] = "SUBREPORT_DIR";
                mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (xrs1.getString(3).equals("690")) {
                    this.xmetodo.mGenerarGrafico(xid_Atencion);
                }
                if (xrs1.getString(3).equals("1023") || xrs1.getString(3).equals("1024") || xrs1.getString(3).equals("461") || xrs1.getString(3).equals("1032") || xrs1.getString(3).equals("250")) {
                    try {
                        String xTratamiento = null;
                        String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + xid_Atencion + "')";
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ResultSet xrs = xct.traerRs(sql);
                        if (xrs.next()) {
                            xrs.first();
                            xTratamiento = xrs.getString(1);
                        }
                        xrs.close();
                        xct.cerrarConexionBd();
                        this.xmetodo.mTraerDatosDienteDxOdontInicial(xrs1.getString(1));
                        this.xmetodo.mTraerDatosDienteProcOdontInicial(xrs1.getString(1));
                        this.xmetodo.traerImagenOdontograma();
                        this.xmetodo.mTraerDatosDienteDxTratamiento(xTratamiento);
                        this.xmetodo.traerImagenOdontogramaDx();
                        this.xmetodo.mTraerDatosDienteProcTratamiento(xTratamiento);
                        this.xmetodo.traerImagenOdontogramaProc();
                        this.xmetodo.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                        this.xmetodo.traerImagenOdontogramaControlPlaca();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFConsultarAtenciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + xrs1.getString(2) + ".jasper", mparametros);
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + xrs1.getString(2), mparametros);
                }
                if (xrs1.getInt(4) == 3 || xrs1.getInt(4) == 2) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_Historia_Clinica_Medicamento", mparametros);
                }
                Principal.mGrabarLogAtenciones("HISTORIA CLINICA SISTEMATIZADA", xid_Atencion, xrs1.getString(1));
                xrs1.close();
                this.xconsultasbd.cerrarConexionBd();
            }
        } catch (SQLException ex2) {
            Logger.getLogger(clasesHistoriaCE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void setIdIngresoNuevo(String idIngresoNuevo) {
        this.idIngresoNuevo = idIngresoNuevo;
    }

    public String getIdIngresoNuevo() {
        return this.idIngresoNuevo;
    }

    public void setIdCitaNP(String idCitaNP) {
        this.idCitaNP = idCitaNP;
    }

    public String getIdCitaNP() {
        return this.idCitaNP;
    }

    public String getNombreAgenda() {
        return this.nombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }

    public void insertarCitaNoProgramada(String idIngreso) {
        String sql = "INSERT INTO `c_citasnp` \n(`Id_Profesional`,`Id_Especialidad`,`Id_Usuario`,`Id_EmpresaCont`,`Id_ClaseCita`\n,`Fecha_Cita`,`HoraInicial`,`HoraFinal`, `Telefonica`,`Remitida`\n, `Id_ProfRemite`,`PrimerVez`,`Asistida`,`EstaFacturada`,`Id_MotivoDesistida`\n,`Id_Anulada`,`Id_ingreso`,`Id_TratamientoO`,`So`,`Observacion`\n, `Urgente`,`NAutorizacion`,`Id_Sede`,`Fecha`,`UsuarioS`\n,`Id_UsuarioS`)\nSELECT\n      i.`Id_Profesional`, i.`Id_Especialidad`, i.`Id_Usuario`, i.`Id_EmpresaContxConv`,25 as `Id_ClaseCita`\n    , i.`FechaIngreso`, i.`HoraIngreso`, (NULL) AS HoraFinal,0 AS telefonica, '-1' AS Remitida\n    , '0' AS idProfRemite, '1' AS primeraVez, '3' AS `Asistida`, '1' AS facturada, '0' AS `Id_MotivoDesistida`\n    , '0' AS anulada, i.`Id` AS `idIngreso`, '0' AS `Id_TratamientoO`, '0' AS `So`, i.`Observacion`\n    , '0' AS urgente, i.`NoAutorizacion`, i.`Id_Sede`, i.`Fecha`, 'l' AS `UsuarioS`\n    , '1' AS idUsuarioS\nFROM  `ingreso` AS i\n    INNER JOIN `g_usuario` ON (i.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `h_atencion` h ON (h.`Id_Ingreso` = i.`Id`)\nWHERE (i.`Id` = '" + idIngreso + "')";
        setIdCitaNP(this.xconsultasbd.ejecutarSQLId(sql));
        this.xconsultasbd.cerrarConexionBd();
    }

    public void insertarFOrdenes(String idCitaNP) {
        String sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n Valor AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,Valor,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,Valor,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'DJMARTINEZP' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f.CualValor=0,(((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMinimo),(((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMaximo)),f_procedempresaconvenio.Valor) AS Valor,\n t.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  WHERE f_procedimcentrocosto.Estado=0 GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`) \n WHERE (c_citasnp.Id ='" + idCitaNP + "' AND f_tiposervicio.`EsConsulta`=1) ) TAB";
        String idFOrdenes = this.xconsultasbd.ejecutarSQLId(sql);
        this.xconsultasbd.cerrarConexionBd();
        String sql2 = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto , Id_CentroCosto , Plan, Fecha , UsuarioS)\nSELECT '" + idFOrdenes + "' AS idOrden, \nId,\nId_Finalidad,\nCantidad,\nValor,\nporcentajeImpuesto,\nvalorImpuesto,\nId_CentroCosto ,\nId_TipoPlanProc,\nNOW() AS fecha,'DJMARTINEZP' AS usuarioS \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\nf_tiposervtipoproced.Idtiposervicio ,\nc_citasnp.Fecha_Cita ,\nc_citasnp.HoraInicial , \nc_citasnp.Id_Profesional ,\nc_citasnp.Id_Especialidad ,\nIF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\ng_procedimiento.Id,\nc_clasecita.Id_Finalidad,\n1 AS Cantidad,\nf.Id_TipoPlan AS Id_TipoPlanEmp,\nf.MetodoFact,\nf.Redondeo,\nIF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f.CualValor=0, t.VrMinimo,t.VrMaximo),f_procedempresaconvenio.Valor)  AS Valor,\nt.Id_TipoPlan AS Id_TipoPlanProc, \ng_procedimiento.porcentajeImpuesto, \nIF(f.CualValor=0, ((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100),((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)) AS valorImpuesto \nFROM c_citasnp   \nINNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \nINNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \nINNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \nAND (t.Id_Manual = f.Id_Manual) \nINNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \nINNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \nINNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \nLEFT JOIN \n(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\nWHERE f_procedimcentrocosto.Estado=0\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\nON aux.Id_Procedimiento=g_procedimiento.Id\nLEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id)  AND (f_procedempresaconvenio.`Id_EmpresacontxConv`=f.`Id`)\nWHERE (c_citasnp.Id ='" + idCitaNP + "' AND f_tiposervicio.`EsConsulta`=1)) TAB";
        this.xconsultasbd.ejecutarSQL(sql2);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mDuplicar_Ingreso_Hospitalizacion(String Id_Ingreso) {
        this.xsql = "INSERT INTO `ingreso` (`Id_Usuario`, `FechaIngreso` , `HoraIngreso` , `Id_EmpresaContxConv` , `esCapitado` , `Id_Sede` , `SiCopago` , `Id_Estrato` , `Id_OrigenAdmision` , `Id_CausaExterna` , `Id_Especialidad` ,`Id_Profesional`,  `Id_TipoAtencion` , `Cama` , `DxIngreso` , `NoPoliza` , `NoAutorizacion` , `Id_Contrato` , `Estado` , `EsAtencion` , `NAcompanante` , `TelefonoAcomp` , `ParentezcoAcomp` , `NPersonaResp` , `TelefonoPResp` , `TipDoc` , `NoDocumento` , `Id_NivelEstudio` , `TipoDocA` , `NoDocA` , `Id_Parentesco` , `Id_Ocupacion` , `SO_Cargo` , `SO_Supervisor` , `SO_SEG` , `SO_Jornada` , `HorasTrabajadas` , `SO_Arl` , `SO_Grupo` , `SO_Lateralidad` , `NoHijos` , `ClaseSE` , `SO_FechaIngreso` , `Tipo_Empresa` , `Id_Atencion` , `Id_CondVict` , `Fecha` , `UsuarioS`)   SELECT `Id_Usuario` , `FechaIngreso` , `HoraIngreso` , `Id_EmpresaContxConv` , `esCapitado` , `Id_Sede` , `SiCopago` , `Id_Estrato` , `Id_OrigenAdmision` , `Id_CausaExterna` , `Id_Especialidad` , `Id_Profesional` , 2 , `Cama` , `DxIngreso` , `NoPoliza` , `NoAutorizacion` , `Id_Contrato` , `Estado` , `EsAtencion` , `NAcompanante` , `TelefonoAcomp` , `ParentezcoAcomp` , `NPersonaResp` , `TelefonoPResp` , `TipDoc` , `NoDocumento` , `Id_NivelEstudio` , `TipoDocA` , `NoDocA` , `Id_Parentesco` , `Id_Ocupacion` , `SO_Cargo` , `SO_Supervisor` , `SO_SEG` , `SO_Jornada` , `HorasTrabajadas` , `SO_Arl` , `SO_Grupo` , `SO_Lateralidad` , `NoHijos` , `ClaseSE` , `SO_FechaIngreso` , `Tipo_Empresa` , `Id_Atencion` , `Id_CondVict` , `Fecha` , `UsuarioS` FROM `ingreso` WHERE (`Id` ='" + Id_Ingreso + "') ";
        String xid_Ingreso = this.xconsultasbd.ejecutarSQLId(this.xsql);
        setIdIngresoNuevo(xid_Ingreso);
        this.xconsultasbd.cerrarConexionBd();
        this.xsql = "INSERT INTO h_atencion(`Id_Ingreso` , `Id_ClaseCita`  , `Fecha_Atencion` , `Hora_Atencion` , `Motivo_Atencion` , `EActual` , `Codigo_Dxp`  , `Id_TipoDx` , `Codigo_DxR1` , `Codigo_DxR2` , `Codigo_DxR3`  , `Conclusion`  , `Id_Profesional` , `Id_Especialidad` , `Recomendaciones` , `Fecha` , `UsuarioS`) SELECT  " + xid_Ingreso + " , h_atencion.`Id_ClaseCita`  , h_atencion.`Fecha_Atencion` , h_atencion.`Hora_Atencion` , h_atencion.`Motivo_Atencion` , h_atencion.`EActual` , h_atencion.`Codigo_Dxp` , h_atencion.`Id_TipoDx` , h_atencion.`Codigo_DxR1` , h_atencion.`Codigo_DxR2` , h_atencion.`Codigo_DxR3`  , h_atencion.`Conclusion`  , ingreso.`Id_Profesional` , ingreso.`Id_Especialidad` , h_atencion.`Recomendaciones` , h_atencion.`Fecha` , h_atencion.`UsuarioS` FROM   `h_atencion`  INNER JOIN  `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE `Id_Ingreso`='" + Id_Ingreso + "'";
        String xid_Atencion = this.xconsultasbd.ejecutarSQLId(this.xsql);
        this.xconsultasbd.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.xsql = "UPDATE h_atencion INNER JOIN ingreso ON(ingreso.id=h_atencion.`Id_Ingreso` AND h_atencion.Id_Ingreso='" + xid_Ingreso + "')\nSET h_atencion.Fecha_Atencion='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "'\n,ingreso.FechaIngreso='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "'\n,h_atencion.Hora_Atencion='" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "'\n,ingreso.HoraIngreso='" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "'\n,ingreso.Id_Atencion='" + xid_Atencion + "'\n,h_atencion.`Id_ClaseCita`=25";
            this.xconsultasbd.ejecutarSQL(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "insert into h_notasclinicas (`Id_Atencion` , `Id_Tipo_Atencion` , `Id_TipoNota` , `FechaNota` , `HoraNota` , `Descripcion` , `Id_Profesional` , `Id_Especialidad` , `UsuarioS`) values('" + xid_Atencion + "','2','32','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','SE ORDENA HOSPITALIZACIÓN','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xid_NotaClinica = this.xconsultasbd.ejecutarSQLId(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "insert into h_ordenes_interconsultas(`Id_Nota`, `Id_Especialidad`, `UsuarioS`) values('" + xid_NotaClinica + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xconsultasbd.ejecutarSQL(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    public void buscarPatologiaFichasSivigila(String codigoPatologia) {
        List<Object[]> listPatologiaSivigila = this.patologiaCie10DAO.listPatologiaFichaSivigila(codigoPatologia);
        if (!listPatologiaSivigila.isEmpty()) {
            for (int i = 0; i < listPatologiaSivigila.size(); i++) {
                listPatologiaSivigila.get(i);
                if (this.historia_Clinica_v2 != null) {
                    JOptionPane.showInternalMessageDialog(this.historia_Clinica_v2, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                } else if (this.historia_Clinica_v4 != null) {
                    JOptionPane.showInternalMessageDialog(this.historia_Clinica_v4, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                } else {
                    JOptionPane.showInternalMessageDialog(this.xjifhistoriaclinica, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                this.xSivigila = new Sivigila(informacionAgendaMedicaDTO.getIdAtencion(), codigoPatologia, listPatologiaSivigila.get(i)[6].toString(), (byte[]) listPatologiaSivigila.get(i)[5], Integer.valueOf(Integer.parseInt(listPatologiaSivigila.get(i)[7].toString())));
                this.xSivigila.mGenerarSivigila();
            }
        }
    }

    public void mBuscarPatologiasSivigila(String xCodigo) {
        try {
            String xsql = "SELECT\n    `g_patologia_ficha_sivigila`.`IdPatologia`\n    , `g_fichas_notificacion_sivigila`.`Nbre`\n    , `g_fichas_notificacion_sivigila`.`Descripcion`\n    , `g_fichas_notificacion_sivigila`.`Url_Encabezado`\n    , `g_fichas_notificacion_sivigila`.`Url`\n    , `g_fichas_notificacion_sivigila`.`ArchivoSivigila`\n    , `g_fichas_notificacion_sivigila`.`Estado`\n    , `g_fichas_notificacion_sivigila`.`Codigo`\n    , `g_fichas_notificacion_sivigila`.`forma`\nFROM\n      `g_patologia_ficha_sivigila`\n    INNER JOIN   `g_fichas_notificacion_sivigila` \n        ON (`g_patologia_ficha_sivigila`.`IdFichaNotificcion` = `g_fichas_notificacion_sivigila`.`Id`)\nWHERE (`g_patologia_ficha_sivigila`.`IdPatologia` ='" + xCodigo + "'\n    AND `g_fichas_notificacion_sivigila`.`Estado` =1)";
            ResultSet xrs = this.xconsultasbd.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        if (this.historia_Clinica_v2 != null) {
                            JOptionPane.showInternalMessageDialog(this.historia_Clinica_v2, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        } else if (this.historia_Clinica_v4 != null) {
                            JOptionPane.showInternalMessageDialog(this.historia_Clinica_v4, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        } else {
                            JOptionPane.showInternalMessageDialog(this.xjifhistoriaclinica, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Patología CIE10 con ficha de sivigila relacionada;<br>Favor imprimir y diligenciarla.</p>", "SIVIGILA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        }
                        this.xSivigila = new Sivigila(informacionAgendaMedicaDTO.getIdAtencion(), xCodigo, xrs.getString("Codigo"), xrs.getBytes("ArchivoSivigila"), Integer.valueOf(xrs.getInt("forma")));
                        this.xSivigila.mGenerarSivigila();
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
                    this.xconsultasbd.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void buscarPatologias(JTextField codigo, JTextField nombrep, int xValidacion, String fechaNacimiento, String idSexo, JInternalFrame jInternalFrame) {
        if (!codigo.getText().isEmpty()) {
            Integer verficacion = this.patologiaCie10DAO.patologiaFiltradaEdad(fechaNacimiento, idSexo, codigo.getText());
            if (verficacion.intValue() == 1 || verficacion.intValue() == 0) {
                try {
                    if (verficacion.intValue() != 0) {
                        if (Principal.informacionIps.getFiltroPatologiaPrograma().intValue() == 1) {
                            if ((xValidacion == 0 || xValidacion == 1 || xValidacion == 2 || xValidacion == 3) && informacionAgendaMedicaDTO.getIdPrograma().intValue() != 0) {
                                PatologiaCie10DTO patologia = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), informacionAgendaMedicaDTO.getIdPrograma());
                                if (patologia.getId() != null) {
                                    codigo.setText(patologia.getId());
                                    nombrep.setText(patologia.getNombre());
                                    buscarGuiasManejoPatologias(patologia.getPathGuiaManejo(), jInternalFrame);
                                    buscarRecomendaciones(codigo.getText(), patologia.getEsRecomendaciones());
                                    buscarPatologiaFichasSivigila(codigo.getText());
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El Diagnóstico no configurado para la clase de cita</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                codigo.setText("");
                                nombrep.setText("");
                                codigo.requestFocus();
                                return;
                            }
                            PatologiaCie10DTO patologia2 = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
                            codigo.setText(patologia2.getId());
                            nombrep.setText(patologia2.getNombre());
                            buscarGuiasManejoPatologias(patologia2.getPathGuiaManejo(), jInternalFrame);
                            buscarRecomendaciones(codigo.getText(), patologia2.getEsRecomendaciones());
                            buscarPatologiaFichasSivigila(codigo.getText());
                            return;
                        }
                        PatologiaCie10DTO patologia3 = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
                        codigo.setText(patologia3.getId());
                        nombrep.setText(patologia3.getNombre());
                        buscarGuiasManejoPatologias(patologia3.getPathGuiaManejo(), jInternalFrame);
                        buscarRecomendaciones(codigo.getText(), patologia3.getEsRecomendaciones());
                        buscarPatologiaFichasSivigila(codigo.getText());
                        return;
                    }
                    try {
                        JOptionPane.showInternalMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El Dx no aplica para Sexo y/o Edad</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El Dx no aplica para Sexo y/o Edad</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    } catch (Exception e) {
                        System.err.println("Componente Invalido para ese OptionPane, se procede a provar con otro.");
                        JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El Dx no aplica para Sexo y/o Edad</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                    return;
                } catch (Throwable th) {
                    JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El Dx no aplica para Sexo y/o Edad</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    throw th;
                }
            }
            try {
                try {
                    JOptionPane.showInternalMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Código de diagnóstico no existe</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Código de diagnóstico no existe</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } catch (Exception e2) {
                    System.err.println("Componente Invalido para ese OptionPane, se procede a provar con otro.");
                    JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Código de diagnóstico no existe</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                nombrep.setText((String) null);
                codigo.setText((String) null);
                codigo.requestFocus();
            } catch (Throwable th2) {
                JOptionPane.showMessageDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Código de diagnóstico no existe</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                throw th2;
            }
        }
    }

    private void buscarGuiasManejoPatologias(String pathGuiaManejo, JInternalFrame jInternalFrame) {
        int x;
        if (!pathGuiaManejo.equals("")) {
            try {
                try {
                    JOptionPane.showInternalConfirmDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El código tiene una guia de manejo asociada;<br>Desea consultarla?</p>", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    x = JOptionPane.showConfirmDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El código tiene una guia de manejo asociada;<br>Desea consultarla?</p>", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                } catch (Exception e) {
                    System.err.println("Componente Invalido para ese OptionPane, se procede a provar con otro.");
                    x = JOptionPane.showConfirmDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El código tiene una guia de manejo asociada;<br>Desea consultarla?</p>", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                }
                if (x == 0) {
                    this.xmetodo.mostrarPdf(pathGuiaManejo);
                }
            } catch (Throwable th) {
                JOptionPane.showConfirmDialog(jInternalFrame, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El código tiene una guia de manejo asociada;<br>Desea consultarla?</p>", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                throw th;
            }
        }
    }

    private void buscarRecomendaciones(String codigo, Boolean esRecomendaciones) {
        if (esRecomendaciones.booleanValue()) {
            JDRecomendaciones xjdrecomendaciones = new JDRecomendaciones(this.frmPrincipal, true, codigo);
            xjdrecomendaciones.setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
            xjdrecomendaciones.setVisible(true);
        }
    }

    public void buscarPatologiaNombre(JTextField codigo, JTextField nombrep, int xvalidacion) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "conclusion", xvalidacion);
        pac.setVisible(true);
        pac.setLocationRelativeTo(null);
    }

    public void grabarAnexo1NUevoRemision(Long idRemision, Date date, Integer tipoAnexo) {
        System.out.println("sqlWITH maestra AS (\n                 SELECT \n                 fe.CRips codigoEntidadPagadora, \n                 gp2.Apellido1 primerApellido, \n                 gp2.Apellido2 segundoApellido, \n                 gp2.Nombre1 primerNombre,\n                 gp2.Nombre2 segundoNombre,\n                 gp2.Id_TipoIdentificacion tipoDocumento,\n                 gp2.NoDocumento numeroDocumento,\n                 gp2.FechaNac fechaNacimiento,\n                 gp2.Direccion direccion,\n                 IF(gp2.Telefono='',gp2.Movil,gp2.Telefono) telefono,\n                 gp2.Id_Municipio municipio,\n                 gp2.Correo correo,\n                 gc.codigo causaAtencion,\n                 ha.Codigo_Dxp diagnostico,\n                 ha.Codigo_DxR1 diagnosticoRelacionado1,\n                 ha.Codigo_DxR2 diagnosticoRelacionado2,\n                 ha.Codigo_DxR3 diagnosticoRelacionado3,\n                 '' prioridadAtencion ,\n                 IF(hr.EsUrgente=1, '02', '03') tipoAtencionSolicitada,\n                 ggs.codigo grupoServicios,gsr.codigo codigoServicio, \n                 gma.codigo modalidadAtencion,\n                 hr.`Fecha` AS fechaRemision ,\n                 hr.`Hora` AS horaRemision,\n                 gp2.Direccion AS direccionAlternativa, \n                  i.`NPersonaResp`  AS nombreContactoEmergencia,\n                  i.`TelefonoAcomp`  AS telefonoContactoEmergencia,\n                                  CASE \n                     WHEN gp2.Correo REGEXP '^[a-zA-Z0-9._%-]@[a-zA-Z0-9.-]\\\\\\\\\\\\\\.[a-zA-Z]{2,}$' THEN 'Válido'\n                         ELSE 'No válido'\n                     END AS estado_correo\n                 , hr.Id,  gt.codigo condicionDestino \n                 FROM h_remisiones hr \n                 INNER JOIN h_atencion ha ON (ha.Id=hr.Id_Atencion)\n                 INNER JOIN ingreso i ON (i.Id=ha.Id_Ingreso)\n                 INNER JOIN g_causaexterna gc ON (gc.Id=i.Id_CausaExterna)\n                 INNER JOIN f_empresacontxconvenio fe ON (fe.Id=i.Id_EmpresaContxConv)\n                 INNER JOIN g_persona gp2 ON (gp2.Id=i.Id_Usuario)\n                 INNER JOIN g_usuario gu ON (gu.Id_persona=gp2.Id)\n                 INNER JOIN g_modalidad_atencion gma ON (gma.id=hr.idModalidadAtencion)\n                 INNER JOIN g_servicios_rips gsr ON (gsr.id=hr.idServicioRips)\n                 INNER JOIN g_grupo_servicio ggs ON (ggs.id=gsr.idGrupoServicio)\n                 INNER JOIN g_tipodestino gt ON (gt.Id=hr.idDestino)\n                 WHERE hr.Id ='\"+idRemision+\"'  \n                 ), \n                 cupsDetalle AS (\n                    SELECT \n                         JSON_ARRAYAGG(\n                             JSON_OBJECT(\n                                 'codigoCups','890602',\n                                 'cantidadRequerida', 1,\n                                 'finalidadTecnologia','',\n                                 'codigoServicio', m.codigoServicio,\n                                 'grupoServicios', m.grupoServicios\n                             )\n                         ) AS cupsDetalle\n                     FROM maestra m \n                                   )\n                                  SELECT   m.codigoEntidadPagadora, m.Id idOrden, \n                  JSON_OBJECT(\n                             'primerApellido', m.primerApellido,\n                             'segundoApellido', m.segundoApellido,\n                             'primerNombre', m.primerNombre,\n                             'segundoNombre', m.segundoNombre,\n                             'tipoDocumento', m.tipoDocumento,\n                             'numeroDocumento', m.numeroDocumento,\n                             'fechaNacimiento', m.fechaNacimiento,\n                             'direccion', m.direccion,\n                             'telefono', m.telefono,\n                             'municipio', m.municipio,\n                             'correo', IF(estado_correo='Válido', m.correo, '') ,\n                             'direccionAlternativa' , m.direccionAlternativa, \n                 'nombreContactoEmergencia' , m.nombreContactoEmergencia,\n                 'telefonoContactoEmergencia' , m.telefonoContactoEmergencia\n                               ) AS anexoDatoUsuario,\n                     JSON_OBJECT(\n                             'causaAtencion', m.causaAtencion,\n                             'diagnostico', m.diagnostico,\n                             'diagnosticoRelacionado1', m.diagnosticoRelacionado1,\n                             'diagnosticoRelacionado2', m.diagnosticoRelacionado2,\n                             'diagnosticoRelacionado3', m.diagnosticoRelacionado3,\n                             'prioridadAtencion', m.prioridadAtencion,\n                             'tipoAtencionSolicitada', m.tipoAtencionSolicitada,\n                             'modalidadAtencion', m.modalidadAtencion, \n                             'condicionDestino', m.condicionDestino\n                             \n                   ) AS Anexo5Dto, d.cupsDetalle , m.fechaRemision , m.horaRemision\n                 FROM maestra m, cupsDetalle d\n                 GROUP BY m.Id");
        Anexo2335Dto anexo2335Dto = new Anexo2335Dto();
        Anexo5Dto anexo5Dto = null;
        Anexo6Dto anexo6Dto = null;
        new ArrayList();
        new AnexoDatoUsuarioDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResultSet xrs1 = this.xconsultasbd.traerRs("WITH maestra AS (\n                 SELECT \n                 fe.CRips codigoEntidadPagadora, \n                 gp2.Apellido1 primerApellido, \n                 gp2.Apellido2 segundoApellido, \n                 gp2.Nombre1 primerNombre,\n                 gp2.Nombre2 segundoNombre,\n                 gp2.Id_TipoIdentificacion tipoDocumento,\n                 gp2.NoDocumento numeroDocumento,\n                 gp2.FechaNac fechaNacimiento,\n                 gp2.Direccion direccion,\n                 IF(gp2.Telefono='',gp2.Movil,gp2.Telefono) telefono,\n                 gp2.Id_Municipio municipio,\n                 gp2.Correo correo,\n                 gc.codigo causaAtencion,\n                 ha.Codigo_Dxp diagnostico,\n                 ha.Codigo_DxR1 diagnosticoRelacionado1,\n                 ha.Codigo_DxR2 diagnosticoRelacionado2,\n                 ha.Codigo_DxR3 diagnosticoRelacionado3,\n                 '' prioridadAtencion ,\n                 IF(hr.EsUrgente=1, '02', '03') tipoAtencionSolicitada,\n                 ggs.codigo grupoServicios,gsr.codigo codigoServicio, \n                 gma.codigo modalidadAtencion,\n                 hr.`Fecha` AS fechaRemision ,\n                 hr.`Hora` AS horaRemision,\n                 gp2.Direccion AS direccionAlternativa, \n                  i.`NPersonaResp`  AS nombreContactoEmergencia,\n                  i.`TelefonoAcomp`  AS telefonoContactoEmergencia,\n                                  CASE \n                     WHEN gp2.Correo REGEXP '^[a-zA-Z0-9._%-]@[a-zA-Z0-9.-]\\\\\\\\\\\\\\.[a-zA-Z]{2,}$' THEN 'Válido'\n                         ELSE 'No válido'\n                     END AS estado_correo\n                 , hr.Id,  gt.codigo condicionDestino \n                 FROM h_remisiones hr \n                 INNER JOIN h_atencion ha ON (ha.Id=hr.Id_Atencion)\n                 INNER JOIN ingreso i ON (i.Id=ha.Id_Ingreso)\n                 INNER JOIN g_causaexterna gc ON (gc.Id=i.Id_CausaExterna)\n                 INNER JOIN f_empresacontxconvenio fe ON (fe.Id=i.Id_EmpresaContxConv)\n                 INNER JOIN g_persona gp2 ON (gp2.Id=i.Id_Usuario)\n                 INNER JOIN g_usuario gu ON (gu.Id_persona=gp2.Id)\n                 INNER JOIN g_modalidad_atencion gma ON (gma.id=hr.idModalidadAtencion)\n                 INNER JOIN g_servicios_rips gsr ON (gsr.id=hr.idServicioRips)\n                 INNER JOIN g_grupo_servicio ggs ON (ggs.id=gsr.idGrupoServicio)\n                 INNER JOIN g_tipodestino gt ON (gt.Id=hr.idDestino)\n                 WHERE hr.Id ='\"+idRemision+\"'  \n                 ), \n                 cupsDetalle AS (\n                    SELECT \n                         JSON_ARRAYAGG(\n                             JSON_OBJECT(\n                                 'codigoCups','890602',\n                                 'cantidadRequerida', 1,\n                                 'finalidadTecnologia','',\n                                 'codigoServicio', m.codigoServicio,\n                                 'grupoServicios', m.grupoServicios\n                             )\n                         ) AS cupsDetalle\n                     FROM maestra m \n                                   )\n                                  SELECT   m.codigoEntidadPagadora, m.Id idOrden, \n                  JSON_OBJECT(\n                             'primerApellido', m.primerApellido,\n                             'segundoApellido', m.segundoApellido,\n                             'primerNombre', m.primerNombre,\n                             'segundoNombre', m.segundoNombre,\n                             'tipoDocumento', m.tipoDocumento,\n                             'numeroDocumento', m.numeroDocumento,\n                             'fechaNacimiento', m.fechaNacimiento,\n                             'direccion', m.direccion,\n                             'telefono', m.telefono,\n                             'municipio', m.municipio,\n                             'correo', IF(estado_correo='Válido', m.correo, '') ,\n                             'direccionAlternativa' , m.direccionAlternativa, \n                 'nombreContactoEmergencia' , m.nombreContactoEmergencia,\n                 'telefonoContactoEmergencia' , m.telefonoContactoEmergencia\n                               ) AS anexoDatoUsuario,\n                     JSON_OBJECT(\n                             'causaAtencion', m.causaAtencion,\n                             'diagnostico', m.diagnostico,\n                             'diagnosticoRelacionado1', m.diagnosticoRelacionado1,\n                             'diagnosticoRelacionado2', m.diagnosticoRelacionado2,\n                             'diagnosticoRelacionado3', m.diagnosticoRelacionado3,\n                             'prioridadAtencion', m.prioridadAtencion,\n                             'tipoAtencionSolicitada', m.tipoAtencionSolicitada,\n                             'modalidadAtencion', m.modalidadAtencion, \n                             'condicionDestino', m.condicionDestino\n                             \n                   ) AS Anexo5Dto, d.cupsDetalle , m.fechaRemision , m.horaRemision\n                 FROM maestra m, cupsDetalle d\n                 GROUP BY m.Id");
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        anexo2335Dto.setIngresoId(informacionAgendaMedicaDTO.getIdIngreso());
                        anexo2335Dto.setFechaRegistro(xrs1.getString("fechaRemision").toString());
                        anexo2335Dto.setHoraRegistro(xrs1.getString("horaRemision"));
                        anexo2335Dto.setEstado(true);
                        anexo2335Dto.setProfesionalId(String.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema()));
                        anexo2335Dto.setEspecialidadId(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
                        anexo2335Dto.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        AnexoInformacionIpsDto anexoInformacionIpsDto = new AnexoInformacionIpsDto();
                        anexoInformacionIpsDto.setCodigoEntidadPagadora("");
                        anexoInformacionIpsDto.setCodigoPrestador(Principal.informacionIps.getCodigoOrganismo());
                        anexoInformacionIpsDto.setNumeroAutorizacion("");
                        anexoInformacionIpsDto.setNumeroIdentificacionIps(Principal.informacionIps.getIdentificacion());
                        anexo2335Dto.setAnexoInformacionIps(anexoInformacionIpsDto);
                        anexoInformacionIpsDto.setCodigoEntidadPagadora(xrs1.getString("codigoEntidadPagadora"));
                        anexo2335Dto.setIdOrden(Long.valueOf(xrs1.getLong("idOrden")));
                        AnexoDatoUsuarioDto usuarioDto = (AnexoDatoUsuarioDto) objectMapper.readValue(xrs1.getString("anexoDatoUsuario"), AnexoDatoUsuarioDto.class);
                        if (tipoAnexo.intValue() == 1) {
                            new Anexo5Dto();
                            anexo2335Dto.setTipoAnexo(5);
                            anexo5Dto = (Anexo5Dto) objectMapper.readValue(xrs1.getString("Anexo5Dto"), Anexo5Dto.class);
                            anexo5Dto.setCodigoPrestadorRemite(anexoInformacionIpsDto.getCodigoPrestador());
                            anexo2335Dto.setTipoAnexo(5);
                        } else {
                            new Anexo6Dto();
                            anexo2335Dto.setTipoAnexo(6);
                            anexo6Dto = (Anexo6Dto) objectMapper.readValue(xrs1.getString("Anexo5Dto"), Anexo6Dto.class);
                            anexo6Dto.setCodigoPrestadorRemite(anexoInformacionIpsDto.getCodigoPrestador());
                        }
                        if (xrs1.getString("cupsDetalle") != null) {
                            List<ListaCupsDetalleDto> cupsDetalle = (List) objectMapper.readValue(xrs1.getString("cupsDetalle"), new TypeReference<List<ListaCupsDetalleDto>>() { // from class: Historia.clasesHistoriaCE.1
                            });
                            if (tipoAnexo.intValue() == 1) {
                                anexo5Dto.setCupsDetalle(cupsDetalle);
                            } else {
                                anexo6Dto.setCupsDetalle(cupsDetalle);
                            }
                        }
                        anexo2335Dto.setAnexoDatoUsuario(usuarioDto);
                        anexo2335Dto.setAnexo5(anexo5Dto);
                        anexo2335Dto.setAnexo6(anexo6Dto);
                    }
                    RecursosMicroserviciosDomain microserviciosDomain = this.xmetodo.getParametrosEncriptados("24", "RegistroAnexo2335");
                    System.out.println("" + microserviciosDomain.getUrlRecurso());
                    System.err.println("ada: " + objectMapper.writeValueAsString(anexo2335Dto));
                    Response responsePos = this.xmetodo.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.xmetodo.getMapper().writeValueAsString(anexo2335Dto)));
                    responsePos.close();
                    this.xmetodo.getResteasyClient().close();
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                } catch (Throwable th3) {
                    if (xrs1 != null) {
                        if (th != null) {
                            try {
                                xrs1.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th5;
            }
        } catch (JsonProcessingException e) {
            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
