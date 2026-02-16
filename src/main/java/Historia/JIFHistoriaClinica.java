package Historia;

import Acceso.Principal;
import Citas.JDCitasInterConsulta;
import Enfermeria.JPControlDiabetes;
import Enfermeria.JPControlLiquidos;
import Enfermeria.JPControlOxigeno;
import Enfermeria.JPRSignosVitales;
import Historia.aiepi.JPAiepi;
import Historia.aiepi.JPAiepiMadres;
import Historia.aiepi.JPAiepiNinos;
import Odontologia.JPAAntecentesOdontologicos;
import Odontologia.JPAnalisiOclusal;
import Odontologia.JPAnalisisEstomatologico;
import Odontologia.JPAnalisisFuncional;
import Odontologia.JPCefalometria;
import Odontologia.JPControlPlaca;
import Odontologia.JPControlPlacaCompleto;
import Odontologia.JPEndoExamenClinico;
import Odontologia.JPExamenDentario;
import Odontologia.JPOclusion;
import Odontologia.JPOdontograma;
import Odontologia.JPOdontogramaClinico;
import Odontologia.JPOdontogramaInicial;
import Odontologia.JPRxOdontologia;
import PyP.Alimentacion;
import PyP.JPEscalaAbreviada;
import PyP.MotricidadFina;
import PyP.MotricidadGruesa;
import PyP.ValoracionLenguaje;
import PyP.ValoracionPersonal;
import PyP.ValoracionResultado;
import Salud_Ocupacional.JPPruebaAyD;
import Salud_Ocupacional.JPTestFatiga;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3;
import com.genoma.plus.controller.historia.JPAAntecedenteReumatologia;
import com.genoma.plus.controller.historia.JPAAntecedentesGinecobstetricos;
import com.genoma.plus.controller.historia.JPAClasificacionEular;
import com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo;
import com.genoma.plus.controller.historia.JPAEvaluacionRecienNacido;
import com.genoma.plus.controller.historia.JPAFamiliograma;
import com.genoma.plus.controller.historia.JPAFonoaudiologia;
import com.genoma.plus.controller.historia.JPATamizajeEstetico;
import com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla;
import com.genoma.plus.controller.historia.JPA_Atencion_InformacionN10;
import com.genoma.plus.controller.historia.JPA_NotasMedicasN;
import com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores;
import com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla;
import com.genoma.plus.controller.historia.JPA_TestCrb65;
import com.genoma.plus.controller.historia.JPAntecedenteFamiliarTexto;
import com.genoma.plus.controller.historia.JPAntecedentesFisicosPsiquiatricos;
import com.genoma.plus.controller.historia.JPAtencionDieta;
import com.genoma.plus.controller.historia.JPCuestionarioHAQ;
import com.genoma.plus.controller.historia.JPDepresionPosparto;
import com.genoma.plus.controller.historia.JPGaleriaImagenes;
import com.genoma.plus.controller.historia.JPMaltratoViolencia;
import com.genoma.plus.controller.historia.JPSo_Audiometria_nueva;
import com.genoma.plus.controller.historia.JPSo_Psicomotriz;
import com.genoma.plus.controller.historia.JPTriageRespiratorio;
import com.genoma.plus.controller.historia.JPTriageRespiratorio_V2;
import com.genoma.plus.controller.historia.JP_ExamenFisicoI;
import com.genoma.plus.controller.historia.JP_ExamenFisicoI1;
import com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R;
import com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO;
import com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo;
import com.genoma.plus.controller.sgc.JPEventoAdverso;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFHistoriaClinica.class */
public class JIFHistoriaClinica extends JInternalFrame {
    public String[][] xArbolHC;
    public int xnfila;
    public String xNHojaActual;
    public Alimentacion frmAlimentacion;
    public MotricidadFina frmMF;
    public MotricidadGruesa frmMG;
    public ValoracionLenguaje frmVL;
    public ValoracionPersonal frmVP;
    public ValoracionResultado frmVR;
    private Metodos xmetodos;
    private ConsultasMySQL xct;
    public SimpleDateFormat xfechansql;
    private SimpleDateFormat xanovigente;
    public SimpleDateFormat xhorasql;
    private DecimalFormat formato;
    public GregorianCalendar hoy;
    private GregorianCalendar hoyg;
    private DefaultMutableTreeNode antecedentes;
    private DefaultMutableTreeNode cnutricion;
    private DefaultMutableTreeNode motivoconsulta;
    private DefaultMutableTreeNode examenfatencion;
    private DefaultMutableTreeNode hallexamenfatencion;
    private DefaultMutableTreeNode revisionsistema;
    private DefaultMutableTreeNode conclusion;
    private DefaultMutableTreeNode filtraciong;
    private DefaultMutableTreeNode riesgopsicosocial;
    private DefaultMutableTreeNode escalariesgocp;
    private DefaultMutableTreeNode hcfonoaudiologia;
    private DefaultMutableTreeNode hcReumatologia;
    private DefaultMutableTreeNode hcAntecedentesFisicoPsiquiatricos;
    private DefaultMutableTreeNode examenFisicoN1;
    private DefaultMutableTreeNode pyp;
    private DefaultMutableTreeNode CyD;
    private DefaultMutableTreeNode Vacunacion;
    DefaultMutableTreeNode mg;
    DefaultMutableTreeNode mf;
    DefaultMutableTreeNode al;
    DefaultMutableTreeNode ps;
    DefaultMutableTreeNode alm;
    DefaultMutableTreeNode res;
    private DefaultMutableTreeNode ordenes;
    private DefaultMutableTreeNode examenes;
    private DefaultMutableTreeNode otros;
    private DefaultMutableTreeNode notas;
    private DefaultMutableTreeNode guiasm;
    private DefaultMutableTreeNode notasn;
    private DefaultMutableTreeNode fomentos;
    private DefaultMutableTreeNode fomentoAct;
    private DefaultMutableTreeNode citascontrol;
    private DefaultMutableTreeNode AtencionDieta;
    private DefaultMutableTreeNode genericos;
    private DefaultMutableTreeNode genericosg;
    private String[] antec;
    private String[] otrasordenes;
    private String[] ordenesmed;
    public Vector datosatencion;
    public Vector datoshexamenfisico;
    public String notah;
    private int[] idprograma;
    private String sql;
    private String nombreempresa;
    Object jfp;
    public long idpaciente;
    public long idepisodiofides;
    public long idpacientesfides;
    public long xidatencion;
    public int idtconsulta;
    public int idtprograma;
    public int idsexo;
    public int idempresa;
    public int xcardinal;
    private int ghabito;
    private int gantginecologico;
    private int gantecedentesped;
    public Object jpsuministro;
    public Object jpprocedimientos;
    public Object jpgenerico;
    public Object jifperm;
    public int xhexamenes;
    public int xnantepatpers;
    public int xControlHC;
    public long xidingreso;
    public long xidexamenf;
    public long xidatenciont;
    public int xtipocita;
    public int xtipohc;
    public int xidcita;
    public int xidtc;
    public int xv;
    public int xremitida;
    public int xtipoch;
    public String xsexo;
    public String xidusuario;
    public boolean xguardado;
    public String xmotivoconsulta;
    public String xllamarPanel;
    public static String xnusuario;
    private boolean xValidado;
    public int xmodulo;
    private WorkerSQL xWorkerSQL;
    private DefaultMutableTreeNode usuario;
    private DefaultTreeModel modelo;
    private DefaultMutableTreeNode atencion;
    public clasesHistoriaCE xclase;
    public JPOOrdenSuministroH xjpsuministroh;
    public JPOOrdenProcedimientosH xjpprocedimientosh;
    public JPORemisiones xjpremisiones;
    public JPORemisiones1 xjpremisiones1;
    public JPAIncapacidad xjpincapacidad;
    public JPAIncapacidad_v2 aIncapacidad_v2;
    public JPAEventoNoDeseado xjpeventonodeseado;
    public JPPermisosMedicos xjppermisos;
    public JPANotas xjpnotas;
    public JPANotas_v2 xjpnotas1;
    public JPHNutricional xjpnutricion;
    public JPAConclusion xjifconclusion;
    public JP_CP_ResultadoExamenes1 xjifpyprevisionexamenes;
    public JPSo_Visiometria xjifvisiometria;
    public JPSo_VisiometriaFPZ xjifvisiometriafpz;
    public JPSo_VisiometriaG xjifvisiometriaG;
    public JPSo_Espirometria xjifespirometria;
    public JPSo_EspirometriaSI xjifespirometriaSI;
    public JPSo_Audiometria xjifaudiometria;
    public JPSo_Concepto_E xjifconceptoso_e;
    public JPSo_Concepto_I xjifconceptosio_i;
    public JPSo_Concepto_R concepto_R;
    public JPSo_Osteomuscular xjifosteomuscuar;
    public JPAEcografiaGenerico xjifecografiagenerico;
    public JPSo_PEjercicio xjifprescripcionejercicio;
    public JPSo_Optometria xjifoptometria;
    public JP_Optometria jP_Optometria;
    public JPSo_Cuestionarios xjifcuestionarios;
    public JPSo_Cuestionario_N xjifcuestionarios_n;
    public JPSo_Test_PRespiratorio xjiftest_prespiratorio;
    public JPHistoricoAtenciones xjifhatenciones;
    public JPPruebaAyD xjifpruebaayd;
    public JPOdontograma xjifOdontograma;
    public JPControlPlaca xjifControlPlaca;
    public JPTestFatiga xjptestfatiga;
    public JPAEcografiaPelvica xjifecografiap;
    public JPIOrden_Tratamiento xjiftratamiento;
    public JP_PyP_HTA xjifHTA;
    public JP_PyP_Diabetes xjifdiabetes;
    public JPExamenDentario xJPExamenDentario;
    public JPOclusion xJPOclusion;
    public JPITriage xjptriage;
    private String xnombre;
    public JPEndoExamenClinico xJPEndoExamenClinico;
    public JPOdontogramaInicial xJPOdontogramaInicial;
    public JPCefalometria xJPCefalometria;
    public JPAnalisiOclusal xJPAnalisiOclusal;
    public JPAnalisisEstomatologico xJPAnalisisEstomatologico;
    public JPAnalisisFuncional xJPAnalisisFuncional;
    public JPGestionRiesgo_Dm xjpgestionriesgo;
    public JPISeguimiento_Pac xjifseguimiento;
    public JPGestionRiesgo_Hta xjpgestionriesgohta;
    public JPEscalaAbreviada xJPEscalaAbreviada;
    public JPFiltroIFG xJPFiltroIFG;
    public JPVacunacion xJPVacunacion;
    public JPAExamenFisicoPrenatal xJPAExamenFisicoPrenatal;
    private JPGraficasPyP xJPGraficasPyP;
    public JPSo_CuestionarioSico xJPSo_CuestionarioSico;
    public JPHistoria_Terapias xjif_terapiaf;
    public JPAiepi xJPAiepi;
    public JPAiepiNinos xJPAiepiNinos;
    public JPAiepiMadres xJPAiepiMadres;
    public JPTransfuciones xJPTransfuciones;
    public JPTrasnporteAsis xJPTrasnporteAsis;
    public JPI_Cirugias xJPCirugias;
    public JPI_Cirugias1 xJPCirugias1;
    public JPI_Control_Impresion xJPImpresion_Doc;
    public JPListaCHequeo xJPListaCHequeo;
    public JPAdultoMayor xJPAdultoMayor;
    public JIFAdultoJoven xJIFAdultoJoven;
    public JPSociodemografico xJPSociodemografico;
    public JPOftamologiaGen xJPOftamologiaGen;
    public JP_Cargar_DocumentosHC xjif_importardochc;
    public JPI_Test_AgudezaVisual xjif_testagudeza_visual;
    public JPControlPlacaCompleto xJPControlPlacaCompleto;
    public JIFAdultoJoven2 xJIFAdultoJoven2;
    public JPPartograma xJPPartograma;
    public JPOdontogramaClinico xJPOdontogramaClinico;
    private int xNombreNodo;
    public JPPlanificacionFliar xJPPlanificacionFliar;
    private JPGraficaAgenteSEG xJPGraficaAgenteSEG;
    public JPEventoAdverso xJPEventoAdverso;
    public JPAEvaluacionRiesgo xJPAEvaluacionRiesgo;
    public JPRxOdontologia xJPRxOdontologia;
    public JPFramingham xJPFramingham;
    public JPFramingham1 xJPFramingham1;
    public JPFramingham_M xJPFraminghamM;
    public JPRuffier xJPRuffier;
    public JPTestFindrisk xJPTestFindrisk;
    public JPRevisonExamenSo xJPRevisonExamenSo;
    public JPCertificadoSO xJPCertificadoSO;
    public JPSoBiblioteca xJPSoBiblioteca;
    public JPARevisionAyudasDxS xJPARevisionAyudasDxS;
    public JPARevisionSistemas xJPARevisionSistemas;
    public JPARevisionAyudasDxRx xJPARevisionAyudasDxRx;
    public JPARevisionAyudasDx xJPARevisionAyudasDx;
    public JPADiagnostico xJPADiagnostico;
    public JPAAtencion xJPAAtencion;
    public JPRSignosVitales xJPRSignosVitales;
    public JPControlDiabetes xJPControlDiabetes;
    public JPIExamenClinicoPE xJPIExamenClinicoPE;
    public JPAAntecentesFamiliares xJPAAntecentesFamiliares;
    public JPAAntecentesHabitos xJPAAntecentesHabitos;
    public JPAAntecentesPPersonales xJPAAntecentesPPersonales;
    public JPAAPatologiasAsociadas xJPAAPatologiasAsociadas;
    public JPAAntecedentesPediatricos xJPAAntecedentesPediatricos;
    public JPAAntecentesOdontologicos xJPAAntecentesOdontologicos;
    public JPAExamenFisico xJPAExamenFisico;
    public JPAHExamenFisico xJPAHExamenFisico;
    public JPRiesgoBiosicoSocial xJPRiesgoBiosicoSocial;
    public JPEgresoUrgencias xJPEgresoUrgencias;
    public JPAAntecedenteGineco xJPAAntecedenteGineco;
    public JPATestMorisky xJPATestMorisky;
    public JPASaludOcupacional xJPASaludOcupacional;
    public JPAEcografiaObstetrica xJPAEcografiaObstetrica;
    public JPGaleriaImagenes xJPGaleriaImagenes;
    public JPEscalaDolor xJPEscalaDolor;
    public JPEscalaFuerzaMuscular xJPEscalaFuerzaMuscular;
    public JPAFonoaudiologia xJPAFonoaudiologia;
    public JPAAntecedenteReumatologia xJPAAntecedenteReumatologia;
    public JPATamizajeEstetico xJPATamizajeEstetico;
    public JPSo_Psicomotriz xJPSo_Psicomotriz;
    public JPDepresionPosparto xJPDepresionPosparto;
    public JPMaltratoViolencia xJPMaltratoViolencia;
    public JPReuConteoArticulaciones xJPReuConteoArticulaciones;
    public JPAClasificacionEular xJPAClasificacionEular;
    public JPCuestionarioHAQ xJPCuestionarioHAQ;
    public JPSo_VisiometriaMineros xJPSo_VisiometriaMineros;
    public JPA_AntecedentesPersonalesTabla xJPAntecedentesPersonalesTabla;
    public JPA_RevisionSistemasTabla xRevisionSistemasTabla;
    public JPAAntecedentesGinecobstetricos xJPAAntecedentesGinecobstetricos;
    public JPA_Atencion_InformacionN10 xJPA_Atencion_InformacionN10;
    public JPA_Atencion_InformacionN10 itemsJPA_Atencion_InformacionN10;
    public JPAntecedenteFamiliarTexto antecedenteFamiliarTexto;
    public JPGlasgow xJPGlasgow;
    public JP_ExamenFisicoI examenFisicoI;
    public JP_ExamenFisicoI1 examenFisicoI1;
    public JPA_NotasMedicasN xNotasMedicasNa;
    public JPAFamiliograma xJPAFamiliograma;
    public JPA_NotasProcedimientosMenores xA_NotasProcedimientosMenores;
    public JPAEscalaAbreviadaDeDesarrollo jPAEscalaAbreviadaDeDesarrollo;
    public JPAntecedentesFisicosPsiquiatricos jpAntecedentesFisicosPsiquiatricos;
    public JPI_FormularioAnexo3 formularioAnexo3;
    public JPI_FormularioAnexo2 formularioAnexo2;
    public JPTriageRespiratorio triageRespiratorio;
    public JPTriageRespiratorio_V2 triageRespiratorio_V2;
    public JPAtencionDieta xJPAtencionDieta;
    public JPA_TestCrb65 testCrb65;
    public JPSo_Audiometria_nueva xJPSo_Audiometria_nueva;
    public String prueba1;
    public String xitem;
    private JButton JBTAlerta;
    private JButton JBTCAtenciones;
    private JButton JBTHCNutricional;
    private JButton JBTInterconsulta;
    private JLabel JLBNAtencion;
    private JLabel JLBNDatosU;
    private JLabel JLBNHC;
    private JLabel JLBNIngreso;
    public JPanel JPIDetalleAtencion;
    private JPanel JPIPacPrograma;
    private JScrollPane JSPMAtencion;
    private JTree JTAtencion;
    public JFormattedTextField JTFFNAtencion;
    public JFormattedTextField JTFFNIngreso;
    private JPanel jPanel1;
    public static int xver = 0;
    public static int xtipoc = 0;
    public static int xesguardado = 0;
    public static boolean xenviado = false;

    public JIFHistoriaClinica(String xidusuario, long xidingreso, int xtipocita, String xnusuario2, String xtipoconsulta, Object jfp, int xtipohc, String xsexo, int xidtc, int xidcita, int xremitida, String usuarioS, int xControl) {
        this.xArbolHC = new String[100][3];
        this.xnfila = 0;
        this.xmetodos = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xfechansql = new SimpleDateFormat("yyyy/MM/dd");
        this.xanovigente = new SimpleDateFormat("yyyy");
        this.xhorasql = new SimpleDateFormat("HH:mm:ss");
        this.formato = new DecimalFormat("#0.00");
        this.hoy = new GregorianCalendar();
        this.antecedentes = new DefaultMutableTreeNode("Antecedentes");
        this.cnutricion = new DefaultMutableTreeNode("Nutrición");
        this.motivoconsulta = new DefaultMutableTreeNode("Motivo Consulta y EA");
        this.examenfatencion = new DefaultMutableTreeNode("Examen Físico");
        this.hallexamenfatencion = new DefaultMutableTreeNode("Hallazgos Examen Físico");
        this.revisionsistema = new DefaultMutableTreeNode("Revision Sistemas");
        this.conclusion = new DefaultMutableTreeNode("Plan Dx y Terapeutico");
        this.filtraciong = new DefaultMutableTreeNode("Calculo Filtrado G");
        this.riesgopsicosocial = new DefaultMutableTreeNode("Riesgo Biopsicosocial");
        this.escalariesgocp = new DefaultMutableTreeNode("Escala de Riesgo CP");
        this.hcfonoaudiologia = new DefaultMutableTreeNode("Fonoaudiologia");
        this.hcReumatologia = new DefaultMutableTreeNode("Antecedentes Reumatología");
        this.hcAntecedentesFisicoPsiquiatricos = new DefaultMutableTreeNode("Antecedentes Físicos Psiquiatricos");
        this.examenFisicoN1 = new DefaultMutableTreeNode("Examen FísicoN");
        this.pyp = new DefaultMutableTreeNode("Promoción y Prevención");
        this.CyD = new DefaultMutableTreeNode("Crecimiento y Desarrollo");
        this.Vacunacion = new DefaultMutableTreeNode("Vacunacion");
        this.mg = new DefaultMutableTreeNode("Motricidad Gruesa");
        this.mf = new DefaultMutableTreeNode("Motricidad Fina");
        this.al = new DefaultMutableTreeNode("Adición Lenguaje");
        this.ps = new DefaultMutableTreeNode("Personal Social");
        this.alm = new DefaultMutableTreeNode("Alimentación");
        this.res = new DefaultMutableTreeNode("Resultados");
        this.ordenes = new DefaultMutableTreeNode("Ordenes Medicas");
        this.examenes = new DefaultMutableTreeNode("Revisión Ayudas Dx");
        this.otros = new DefaultMutableTreeNode("Otros");
        this.notas = new DefaultMutableTreeNode("Notas");
        this.guiasm = new DefaultMutableTreeNode("Guias de Manejo");
        this.notasn = new DefaultMutableTreeNode("Nueva Nota");
        this.fomentos = new DefaultMutableTreeNode("Fomento de la Salud");
        this.fomentoAct = new DefaultMutableTreeNode("Fomento de la Salud");
        this.citascontrol = new DefaultMutableTreeNode("Cita de Control");
        this.AtencionDieta = new DefaultMutableTreeNode("Solicitud Dieta");
        this.antec = new String[]{"Familiares", "Habitos", "Ginecologicos", "Antecedentes Personales", "Patologicos Personales", "Antecedente Infantil"};
        this.otrasordenes = new String[]{"Incapacidades", "Permisos", "Evento no deseado", "Certificados"};
        this.ordenesmed = new String[]{"Medicamentos", "Laboratorio", "Radiologia", "Otros Servicios", "Promoción y prevencion", "InterConsulta"};
        this.datosatencion = new Vector();
        this.datoshexamenfisico = new Vector();
        this.idpacientesfides = 0L;
        this.xidatencion = 0L;
        this.ghabito = 0;
        this.gantginecologico = 0;
        this.gantecedentesped = 0;
        this.xhexamenes = 0;
        this.xnantepatpers = 0;
        this.xControlHC = 0;
        this.xidexamenf = 0L;
        this.xidatenciont = 0L;
        this.xv = 0;
        this.xremitida = 0;
        this.xtipoch = 0;
        this.xguardado = false;
        this.xmotivoconsulta = null;
        this.xllamarPanel = "";
        this.xValidado = true;
        this.xmodulo = 0;
        this.usuario = new DefaultMutableTreeNode("Usuario");
        this.modelo = new DefaultTreeModel(this.usuario);
        this.atencion = new DefaultMutableTreeNode("Atención");
        this.prueba1 = "prueba hiostoria";
        initComponents();
        this.xControlHC = xControl;
        this.xmodulo = 0;
        this.xidingreso = xidingreso;
        this.xidusuario = xidusuario;
        this.xtipocita = xtipocita;
        this.xtipohc = xtipohc;
        this.xidcita = xidcita;
        this.xremitida = xremitida;
        xnusuario = xnusuario2;
        this.xsexo = xsexo;
        this.xidtc = xidtc;
        this.jfp = jfp;
        setLocation(5, 5);
        this.xmetodos.cargarPanelOdontogramaDientes(this.JPIDetalleAtencion);
        setTitle("USUARIO : " + xnusuario2 + " ----   TIPO CONSULTA: " + xtipoconsulta);
        this.JTFFNIngreso.setText("" + xidingreso);
        mBuscarIngresoCCita();
        if (this.xtipohc == 1) {
            mAtencionMedicinaGeneral();
        } else if (this.xtipohc == 2) {
            mAtencionMGeneralRevision();
        } else if (this.xtipohc == 3) {
            mAtencionNutricion();
        } else if (this.xtipohc == 4) {
            mAtencionEspecialista();
        } else if (this.xtipohc == 5) {
            mAtencionPsicologia();
        } else if (this.xtipohc != 6 && this.xtipohc != 7) {
            if (this.xtipohc == 8) {
                mAtencionControlPrenatal();
            } else if (this.xtipohc == 9) {
                atencionCrecimientoyDesarrollo();
            } else if (this.xtipohc == 10 || this.xtipohc == 11) {
                mAtencionNutricion();
            }
        }
        mEstadoHc();
    }

    private void asignarCita() {
        JDCitasInterConsulta xjdcita = new JDCitasInterConsulta(null, false, String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), Principal.usuarioSistemaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad(), "0", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
        xjdcita.setVisible(true);
    }

    public JIFHistoriaClinica(String xidusuario, long xidingreso, Object jfp, int xtipohc, String usuarioS, long xidatencion) {
        this.xArbolHC = new String[100][3];
        this.xnfila = 0;
        this.xmetodos = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xfechansql = new SimpleDateFormat("yyyy/MM/dd");
        this.xanovigente = new SimpleDateFormat("yyyy");
        this.xhorasql = new SimpleDateFormat("HH:mm:ss");
        this.formato = new DecimalFormat("#0.00");
        this.hoy = new GregorianCalendar();
        this.antecedentes = new DefaultMutableTreeNode("Antecedentes");
        this.cnutricion = new DefaultMutableTreeNode("Nutrición");
        this.motivoconsulta = new DefaultMutableTreeNode("Motivo Consulta y EA");
        this.examenfatencion = new DefaultMutableTreeNode("Examen Físico");
        this.hallexamenfatencion = new DefaultMutableTreeNode("Hallazgos Examen Físico");
        this.revisionsistema = new DefaultMutableTreeNode("Revision Sistemas");
        this.conclusion = new DefaultMutableTreeNode("Plan Dx y Terapeutico");
        this.filtraciong = new DefaultMutableTreeNode("Calculo Filtrado G");
        this.riesgopsicosocial = new DefaultMutableTreeNode("Riesgo Biopsicosocial");
        this.escalariesgocp = new DefaultMutableTreeNode("Escala de Riesgo CP");
        this.hcfonoaudiologia = new DefaultMutableTreeNode("Fonoaudiologia");
        this.hcReumatologia = new DefaultMutableTreeNode("Antecedentes Reumatología");
        this.hcAntecedentesFisicoPsiquiatricos = new DefaultMutableTreeNode("Antecedentes Físicos Psiquiatricos");
        this.examenFisicoN1 = new DefaultMutableTreeNode("Examen FísicoN");
        this.pyp = new DefaultMutableTreeNode("Promoción y Prevención");
        this.CyD = new DefaultMutableTreeNode("Crecimiento y Desarrollo");
        this.Vacunacion = new DefaultMutableTreeNode("Vacunacion");
        this.mg = new DefaultMutableTreeNode("Motricidad Gruesa");
        this.mf = new DefaultMutableTreeNode("Motricidad Fina");
        this.al = new DefaultMutableTreeNode("Adición Lenguaje");
        this.ps = new DefaultMutableTreeNode("Personal Social");
        this.alm = new DefaultMutableTreeNode("Alimentación");
        this.res = new DefaultMutableTreeNode("Resultados");
        this.ordenes = new DefaultMutableTreeNode("Ordenes Medicas");
        this.examenes = new DefaultMutableTreeNode("Revisión Ayudas Dx");
        this.otros = new DefaultMutableTreeNode("Otros");
        this.notas = new DefaultMutableTreeNode("Notas");
        this.guiasm = new DefaultMutableTreeNode("Guias de Manejo");
        this.notasn = new DefaultMutableTreeNode("Nueva Nota");
        this.fomentos = new DefaultMutableTreeNode("Fomento de la Salud");
        this.fomentoAct = new DefaultMutableTreeNode("Fomento de la Salud");
        this.citascontrol = new DefaultMutableTreeNode("Cita de Control");
        this.AtencionDieta = new DefaultMutableTreeNode("Solicitud Dieta");
        this.antec = new String[]{"Familiares", "Habitos", "Ginecologicos", "Antecedentes Personales", "Patologicos Personales", "Antecedente Infantil"};
        this.otrasordenes = new String[]{"Incapacidades", "Permisos", "Evento no deseado", "Certificados"};
        this.ordenesmed = new String[]{"Medicamentos", "Laboratorio", "Radiologia", "Otros Servicios", "Promoción y prevencion", "InterConsulta"};
        this.datosatencion = new Vector();
        this.datoshexamenfisico = new Vector();
        this.idpacientesfides = 0L;
        this.xidatencion = 0L;
        this.ghabito = 0;
        this.gantginecologico = 0;
        this.gantecedentesped = 0;
        this.xhexamenes = 0;
        this.xnantepatpers = 0;
        this.xControlHC = 0;
        this.xidexamenf = 0L;
        this.xidatenciont = 0L;
        this.xv = 0;
        this.xremitida = 0;
        this.xtipoch = 0;
        this.xguardado = false;
        this.xmotivoconsulta = null;
        this.xllamarPanel = "";
        this.xValidado = true;
        this.xmodulo = 0;
        this.usuario = new DefaultMutableTreeNode("Usuario");
        this.modelo = new DefaultTreeModel(this.usuario);
        this.atencion = new DefaultMutableTreeNode("Atención");
        this.prueba1 = "prueba hiostoria";
        initComponents();
        this.xmodulo = 1;
        this.xidingreso = xidingreso;
        this.xidusuario = xidusuario;
        this.xidatencion = xidatencion;
        this.xtipohc = xtipohc;
        this.jfp = jfp;
        setLocation(5, 5);
        setTitle(" HISTORIA CLINICA DE ENFERMERIA ");
        this.JTFFNIngreso.setText("" + xidingreso);
        this.JTFFNAtencion.setText("" + xidatencion);
        mAtencionEnfermeria(0);
        mCargarDatosHc();
    }

    public JIFHistoriaClinica(clasesHistoriaCE xclase, String xnombre) {
        this.xArbolHC = new String[100][3];
        this.xnfila = 0;
        this.xmetodos = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xfechansql = new SimpleDateFormat("yyyy/MM/dd");
        this.xanovigente = new SimpleDateFormat("yyyy");
        this.xhorasql = new SimpleDateFormat("HH:mm:ss");
        this.formato = new DecimalFormat("#0.00");
        this.hoy = new GregorianCalendar();
        this.antecedentes = new DefaultMutableTreeNode("Antecedentes");
        this.cnutricion = new DefaultMutableTreeNode("Nutrición");
        this.motivoconsulta = new DefaultMutableTreeNode("Motivo Consulta y EA");
        this.examenfatencion = new DefaultMutableTreeNode("Examen Físico");
        this.hallexamenfatencion = new DefaultMutableTreeNode("Hallazgos Examen Físico");
        this.revisionsistema = new DefaultMutableTreeNode("Revision Sistemas");
        this.conclusion = new DefaultMutableTreeNode("Plan Dx y Terapeutico");
        this.filtraciong = new DefaultMutableTreeNode("Calculo Filtrado G");
        this.riesgopsicosocial = new DefaultMutableTreeNode("Riesgo Biopsicosocial");
        this.escalariesgocp = new DefaultMutableTreeNode("Escala de Riesgo CP");
        this.hcfonoaudiologia = new DefaultMutableTreeNode("Fonoaudiologia");
        this.hcReumatologia = new DefaultMutableTreeNode("Antecedentes Reumatología");
        this.hcAntecedentesFisicoPsiquiatricos = new DefaultMutableTreeNode("Antecedentes Físicos Psiquiatricos");
        this.examenFisicoN1 = new DefaultMutableTreeNode("Examen FísicoN");
        this.pyp = new DefaultMutableTreeNode("Promoción y Prevención");
        this.CyD = new DefaultMutableTreeNode("Crecimiento y Desarrollo");
        this.Vacunacion = new DefaultMutableTreeNode("Vacunacion");
        this.mg = new DefaultMutableTreeNode("Motricidad Gruesa");
        this.mf = new DefaultMutableTreeNode("Motricidad Fina");
        this.al = new DefaultMutableTreeNode("Adición Lenguaje");
        this.ps = new DefaultMutableTreeNode("Personal Social");
        this.alm = new DefaultMutableTreeNode("Alimentación");
        this.res = new DefaultMutableTreeNode("Resultados");
        this.ordenes = new DefaultMutableTreeNode("Ordenes Medicas");
        this.examenes = new DefaultMutableTreeNode("Revisión Ayudas Dx");
        this.otros = new DefaultMutableTreeNode("Otros");
        this.notas = new DefaultMutableTreeNode("Notas");
        this.guiasm = new DefaultMutableTreeNode("Guias de Manejo");
        this.notasn = new DefaultMutableTreeNode("Nueva Nota");
        this.fomentos = new DefaultMutableTreeNode("Fomento de la Salud");
        this.fomentoAct = new DefaultMutableTreeNode("Fomento de la Salud");
        this.citascontrol = new DefaultMutableTreeNode("Cita de Control");
        this.AtencionDieta = new DefaultMutableTreeNode("Solicitud Dieta");
        this.antec = new String[]{"Familiares", "Habitos", "Ginecologicos", "Antecedentes Personales", "Patologicos Personales", "Antecedente Infantil"};
        this.otrasordenes = new String[]{"Incapacidades", "Permisos", "Evento no deseado", "Certificados"};
        this.ordenesmed = new String[]{"Medicamentos", "Laboratorio", "Radiologia", "Otros Servicios", "Promoción y prevencion", "InterConsulta"};
        this.datosatencion = new Vector();
        this.datoshexamenfisico = new Vector();
        this.idpacientesfides = 0L;
        this.xidatencion = 0L;
        this.ghabito = 0;
        this.gantginecologico = 0;
        this.gantecedentesped = 0;
        this.xhexamenes = 0;
        this.xnantepatpers = 0;
        this.xControlHC = 0;
        this.xidexamenf = 0L;
        this.xidatenciont = 0L;
        this.xv = 0;
        this.xremitida = 0;
        this.xtipoch = 0;
        this.xguardado = false;
        this.xmotivoconsulta = null;
        this.xllamarPanel = "";
        this.xValidado = true;
        this.xmodulo = 0;
        this.usuario = new DefaultMutableTreeNode("Usuario");
        this.modelo = new DefaultTreeModel(this.usuario);
        this.atencion = new DefaultMutableTreeNode("Atención");
        this.prueba1 = "prueba hiostoria";
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        mArmarHC();
        mConsultarALerta();
        mConsultarNConsultas();
        mConsultarHNutricional();
        mConsultarDatosUsuarioFPZ();
        mConsultarIdUsuarioPrograma();
        mConsultar_Crear_Tratamiento_Odontologia();
        mConsultarDatosEmailUsuarioFPZ();
        mCargarDatosPersona();
        mConsultarId_ManPower();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsRemitada().intValue() > 0) {
            this.JBTInterconsulta.setVisible(true);
        } else {
            this.JBTInterconsulta.setVisible(false);
        }
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
                this.JBTCAtenciones.setVisible(true);
                this.JBTHCNutricional.setVisible(true);
            } else {
                this.JBTCAtenciones.setVisible(false);
                this.JBTHCNutricional.setVisible(false);
            }
        }
    }

    public void anular(String hoja) {
        if (hoja.equals("Alimentacion")) {
            this.frmAlimentacion.anular();
        }
    }

    public void mover(String hoja, int boton) {
        if (hoja.equals("MotricidadFina")) {
            if (boton == 6) {
                this.frmMF.navegar(1);
                return;
            }
            if (boton == 7) {
                this.frmMF.navegar(2);
                return;
            } else if (boton == 8) {
                this.frmMF.navegar(3);
                return;
            } else {
                if (boton == 9) {
                    this.frmMF.navegar(4);
                    return;
                }
                return;
            }
        }
        if (hoja.equals("MotricidadGruesa")) {
            if (boton == 6) {
                this.frmMG.navegar(1);
                return;
            }
            if (boton == 7) {
                this.frmMG.navegar(2);
                return;
            } else if (boton == 8) {
                this.frmMG.navegar(3);
                return;
            } else {
                if (boton == 9) {
                    this.frmMG.navegar(4);
                    return;
                }
                return;
            }
        }
        if (hoja.equals("ValoracionLenguaje")) {
            if (boton == 6) {
                this.frmVL.navegar(1);
                return;
            }
            if (boton == 7) {
                this.frmVL.navegar(2);
                return;
            } else if (boton == 8) {
                this.frmVL.navegar(3);
                return;
            } else {
                if (boton == 9) {
                    this.frmVL.navegar(4);
                    return;
                }
                return;
            }
        }
        if (hoja.equals("ValoracionPersonal")) {
            if (boton == 6) {
                this.frmVP.navegar(1);
                return;
            }
            if (boton == 7) {
                this.frmVP.navegar(2);
            } else if (boton == 8) {
                this.frmVP.navegar(3);
            } else if (boton == 9) {
                this.frmVP.navegar(4);
            }
        }
    }

    public void nuevo(String hoja) {
        if (hoja.equals("Alimentacion")) {
            this.frmAlimentacion.nuevo();
            return;
        }
        if (hoja.equals("MotricidadFina")) {
            this.frmMF.nuevo();
            return;
        }
        if (hoja.equals("MotricidadGruesa")) {
            this.frmMG.nuevo();
        } else if (hoja.equals("ValoracionLenguaje")) {
            this.frmVL.nuevo();
        } else if (hoja.equals("ValoracionPersonal")) {
            this.frmVP.nuevo();
        }
    }

    public void grabar(String hoja) {
        if (hoja.equals("Alimentacion")) {
            this.frmAlimentacion.grabar();
            return;
        }
        if (hoja.equals("MotricidadFina")) {
            this.frmMF.grabar();
            return;
        }
        if (hoja.equals("MotricidadGruesa")) {
            this.frmMG.grabar();
        } else if (hoja.equals("ValoracionLenguaje")) {
            this.frmVL.grabar();
        } else if (hoja.equals("ValoracionPersonal")) {
            this.frmVP.grabar();
        }
    }

    private void initComponents() {
        this.JPIPacPrograma = new JPanel();
        this.JSPMAtencion = new JScrollPane();
        this.JTAtencion = new JTree();
        this.JPIDetalleAtencion = new JPanel();
        this.JTFFNAtencion = new JFormattedTextField();
        this.JTFFNIngreso = new JFormattedTextField();
        this.JLBNIngreso = new JLabel();
        this.JLBNHC = new JLabel();
        this.JLBNDatosU = new JLabel();
        this.JLBNAtencion = new JLabel();
        this.jPanel1 = new JPanel();
        this.JBTCAtenciones = new JButton();
        this.JBTInterconsulta = new JButton();
        this.JBTHCNutricional = new JButton();
        this.JBTAlerta = new JButton();
        setClosable(true);
        setTitle("HISTORIA CLÍNICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifhistoriaclinica");
        setPreferredSize(new Dimension(1138, 800));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFHistoriaClinica.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFHistoriaClinica.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFHistoriaClinica.this.formInternalFrameClosed(evt);
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFHistoriaClinica.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTAtencion.setBorder(BorderFactory.createEtchedBorder());
        this.JTAtencion.setFont(new Font("Arial", 1, 12));
        this.JTAtencion.setAutoscrolls(true);
        this.JTAtencion.setRootVisible(false);
        this.JTAtencion.setToggleClickCount(1);
        this.JTAtencion.addMouseListener(new MouseAdapter() { // from class: Historia.JIFHistoriaClinica.2
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaClinica.this.JTAtencionMouseClicked(evt);
            }
        });
        this.JSPMAtencion.setViewportView(this.JTAtencion);
        this.JPIDetalleAtencion.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIDetalleAtencionLayout = new GroupLayout(this.JPIDetalleAtencion);
        this.JPIDetalleAtencion.setLayout(JPIDetalleAtencionLayout);
        JPIDetalleAtencionLayout.setHorizontalGroup(JPIDetalleAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 876, 32767));
        JPIDetalleAtencionLayout.setVerticalGroup(JPIDetalleAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 732, 32767));
        this.JTFFNAtencion.setEditable(false);
        this.JTFFNAtencion.setBackground(new Color(0, 0, 153));
        this.JTFFNAtencion.setBorder(BorderFactory.createEtchedBorder());
        this.JTFFNAtencion.setForeground(new Color(255, 255, 255));
        this.JTFFNAtencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNAtencion.setHorizontalAlignment(0);
        this.JTFFNAtencion.setText("61");
        this.JTFFNAtencion.setFont(new Font("Arial", 1, 24));
        this.JTFFNIngreso.setEditable(false);
        this.JTFFNIngreso.setBackground(new Color(0, 0, 153));
        this.JTFFNIngreso.setBorder(BorderFactory.createEtchedBorder());
        this.JTFFNIngreso.setForeground(new Color(255, 255, 255));
        this.JTFFNIngreso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNIngreso.setHorizontalAlignment(0);
        this.JTFFNIngreso.setFont(new Font("Arial", 1, 24));
        this.JLBNIngreso.setFont(new Font("Arial", 1, 12));
        this.JLBNIngreso.setForeground(Color.blue);
        this.JLBNIngreso.setHorizontalAlignment(4);
        this.JLBNIngreso.setText("N° INGRESO");
        this.JLBNHC.setFont(new Font("Arial", 1, 12));
        this.JLBNHC.setForeground(Color.red);
        this.JLBNHC.setHorizontalAlignment(4);
        this.JLBNHC.setText("USUARIO");
        this.JLBNDatosU.setBackground(new Color(255, 255, 255));
        this.JLBNDatosU.setFont(new Font("Arial", 1, 14));
        this.JLBNDatosU.setForeground(new Color(0, 0, 204));
        this.JLBNDatosU.setHorizontalAlignment(0);
        this.JLBNAtencion.setFont(new Font("Arial", 1, 12));
        this.JLBNAtencion.setForeground(Color.blue);
        this.JLBNAtencion.setHorizontalAlignment(4);
        this.JLBNAtencion.setText("N° ATENCION");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JBTCAtenciones.setFont(new Font("Arial", 1, 12));
        this.JBTCAtenciones.setForeground(Color.blue);
        this.JBTCAtenciones.setText("<html><P ALIGN=center>Consultar \nAtenciones");
        this.JBTCAtenciones.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaClinica.3
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaClinica.this.JBTCAtencionesActionPerformed1(evt);
            }
        });
        this.JBTInterconsulta.setFont(new Font("Arial", 1, 12));
        this.JBTInterconsulta.setForeground(Color.blue);
        this.JBTInterconsulta.setText("<html><P ALIGN=center>Consultar Interconsulta");
        this.JBTInterconsulta.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaClinica.4
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaClinica.this.JBTInterconsultaActionPerformed1(evt);
            }
        });
        this.JBTHCNutricional.setFont(new Font("Arial", 1, 12));
        this.JBTHCNutricional.setForeground(Color.blue);
        this.JBTHCNutricional.setText("<html><P ALIGN=center>Consultar Histórico Nutricional");
        this.JBTHCNutricional.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaClinica.5
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaClinica.this.JBTHCNutricionalActionPerformed1(evt);
            }
        });
        this.JBTAlerta.setFont(new Font("Arial", 1, 12));
        this.JBTAlerta.setForeground(Color.blue);
        this.JBTAlerta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Alerta.gif")));
        this.JBTAlerta.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaClinica.6
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaClinica.this.JBTAlertaActionPerformed1(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTHCNutricional, GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTCAtenciones, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTInterconsulta, -2, 103, -2)).addComponent(this.JBTAlerta, -1, -1, 32767)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCAtenciones, -2, 35, -2).addComponent(this.JBTInterconsulta, -2, 35, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHCNutricional, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAlerta).addContainerGap()));
        GroupLayout JPIPacProgramaLayout = new GroupLayout(this.JPIPacPrograma);
        this.JPIPacPrograma.setLayout(JPIPacProgramaLayout);
        JPIPacProgramaLayout.setHorizontalGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPacProgramaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPacProgramaLayout.createSequentialGroup().addComponent(this.JLBNHC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNDatosU, -2, 589, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNIngreso, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNIngreso, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNAtencion, -2, 83, -2).addGap(7, 7, 7).addComponent(this.JTFFNAtencion, -2, 136, -2)).addGroup(JPIPacProgramaLayout.createSequentialGroup().addGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMAtencion, -2, 232, -2).addComponent(this.jPanel1, -2, 230, -2)).addGap(10, 10, 10).addComponent(this.JPIDetalleAtencion, -2, -1, -2))).addGap(0, 0, 0)));
        JPIPacProgramaLayout.setVerticalGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPacProgramaLayout.createSequentialGroup().addGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNHC, -2, 26, -2).addComponent(this.JLBNDatosU, -2, 26, -2).addComponent(this.JLBNIngreso, -2, 26, -2).addComponent(this.JTFFNIngreso, -2, 29, -2).addComponent(this.JLBNAtencion, -2, 26, -2).addComponent(this.JTFFNAtencion, -2, 29, -2)).addGroup(JPIPacProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPacProgramaLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPMAtencion, -2, 575, -2).addGap(0, 0, 0).addComponent(this.jPanel1, -2, -1, -2)).addGroup(JPIPacProgramaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDetalleAtencion, -2, -1, -2))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPacPrograma, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPacPrograma, -1, -1, 32767));
        pack();
    }

    private void JBTCAtencionesActionPerformed(ActionEvent evt) {
    }

    private boolean[] mVerificarValidaciones() {
        boolean[] xestado = new boolean[3];
        try {
            String xsql2 = "SELECT `Codigo_Dxp` , `Id` FROM `h_atencion` WHERE (`Codigo_Dxp` <>'' AND `Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
            ResultSet xrs2 = this.xct.traerRs(xsql2);
            if (xrs2.next()) {
                xestado[1] = true;
            } else {
                xestado[1] = false;
                this.xitem = "Diagnóstico";
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql1 = "SELECT  Motivo_Atencion ,  EActual ,  Id FROM h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND (Motivo_Atencion  <>'' AND  EActual  <>''))";
            ResultSet xrs1 = xct.traerRs(xsql1);
            if (xrs1.next()) {
                xestado[0] = true;
            } else {
                xestado[0] = false;
                this.xitem = "Motivo Consulta y EA";
            }
            xrs1.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    private boolean mVerificarMotivo() {
        boolean xestado = false;
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql1 = "SELECT  Motivo_Atencion ,  EActual ,  Id FROM h_atencion WHERE ( Motivo_Atencion  <>'' AND  EActual  <>'' AND  Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
            ResultSet xrs1 = xct.traerRs(xsql1);
            if (xrs1.next()) {
                xestado = true;
            }
            xrs1.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    private void mRecorreNodo(TreeNode nodo) {
        if (nodo.toString().equals(this.xitem)) {
            switch (this.xitem) {
                case "Diagnóstico":
                    this.xJPADiagnostico = new JPADiagnostico(this.xclase);
                    mMostrarPanel(this.xJPADiagnostico);
                    break;
                case "Motivo Consulta y EA":
                    this.xJPAAtencion = new JPAAtencion(this.xclase);
                    mMostrarPanel(this.xJPAAtencion);
                    break;
            }
        }
        if (nodo.getChildCount() >= 0) {
            Enumeration e = nodo.children();
            while (e.hasMoreElements() && !nodo.toString().equals(this.xitem)) {
                TreeNode n = (TreeNode) e.nextElement();
                mRecorreNodo(n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (mVerificarValidaciones()[0] && mVerificarValidaciones()[1]) {
            mActivarAgendas();
            return;
        }
        if (!mVerificarValidaciones()[0] || !mVerificarValidaciones()[1]) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Cerrar la HC,  Tiene Información sin guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                dispose();
                return;
            }
            setDefaultCloseOperation(0);
            TreeNode raiz = (TreeNode) this.JTAtencion.getModel().getRoot();
            mRecorreNodo(raiz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        if (this.xControlHC == 2) {
            Principal.clasehistoriace.mCambiarEstadoHc(1);
        }
        mActivarAgendas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAtencionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.JTAtencion.getLastSelectedPathComponent();
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 3) {
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsTriage().intValue() != -1) {
                        mCargarPanelHC();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Clasificación del traige aun no ha sido diligenciado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.xjptriage = new JPITriage();
                    mMostrarPanel(this.xjptriage);
                    return;
                }
                if (isxValidado()) {
                    mCargarPanelHC();
                    this.xNHojaActual = nodo.getUserObject().toString();
                    return;
                } else {
                    mCargarPanelHC();
                    return;
                }
            }
            mCargarPanelHC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCAtencionesActionPerformed1(ActionEvent evt) {
        new JIFConsultarAtenciones(this.xclase);
        this.xclase.cargarPantalla("Consultar Atenciones", this.xclase.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAlertaActionPerformed1(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTInterconsultaActionPerformed1(ActionEvent evt) {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsRemitada().intValue() > 0) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idremision";
            mparametros[0][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsRemitada());
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RRemision", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHCNutricionalActionPerformed1(ActionEvent evt) {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idusuario";
        parametros[0][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        parametros[1][0] = "usuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "H_HistoricoNutricional", parametros);
    }

    public void mCargarPanelHC() {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.JTAtencion.getLastSelectedPathComponent();
        if (nodo != null && !nodo.getUserObject().toString().equals("Atención")) {
            System.out.println("nodo -> " + nodo.getParent().getParent().toString());
            if (nodo.getParent().getParent().toString().equals("Revision Sistemas")) {
                this.xJPARevisionSistemas = new JPARevisionSistemas(nodo.getUserObject().toString(), this.xclase);
                mMostrarPanel(this.xJPARevisionSistemas);
                this.xJPARevisionSistemas.JRBEstadoAnormal.requestFocus();
                return;
            }
            if (nodo.getParent().toString().equals("Revisión Ayudas Dx")) {
                if (nodo.toString().equals("Laboratorio Sistematizado")) {
                    this.xJPARevisionAyudasDxS = new JPARevisionAyudasDxS(this.xclase, nodo.getUserObject().toString());
                    mMostrarPanel(this.xJPARevisionAyudasDxS);
                    return;
                } else if (nodo.toString().equals("Radiología Sistematizadas")) {
                    this.xJPARevisionAyudasDxRx = new JPARevisionAyudasDxRx(this.xclase, nodo.getUserObject().toString());
                    mMostrarPanel(this.xJPARevisionAyudasDxRx);
                    return;
                } else if (nodo.getUserObject().toString().equals("RX Odontología")) {
                    this.xJPRxOdontologia = new JPRxOdontologia();
                    mMostrarPanel1(this.xJPRxOdontologia);
                    return;
                } else {
                    this.xJPARevisionAyudasDx = new JPARevisionAyudasDx(this.xclase, nodo.getUserObject().toString());
                    mMostrarPanel(this.xJPARevisionAyudasDx);
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Tratamiento") || nodo.getUserObject().toString().equals("Medicamentos/Dispositivos Medicos")) {
                this.xjiftratamiento = new JPIOrden_Tratamiento(this.JTFFNAtencion.getText(), this.JTFFNIngreso.getText(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCargo().longValue(), getName());
                mMostrarPanel(this.xjiftratamiento);
                return;
            }
            if (nodo.getUserObject().toString().equals("Diagnóstico") || nodo.getUserObject().toString().equals("Diagnóstico de Ingreso")) {
                this.xJPADiagnostico = new JPADiagnostico(this.xclase);
                mMostrarPanel(this.xJPADiagnostico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Motivo Consulta y EA")) {
                this.xJPAAtencion = new JPAAtencion(this.xclase);
                mMostrarPanel(this.xJPAAtencion);
                this.xJPAAtencion.JTPMotivoConsulta.requestFocus();
                return;
            }
            if (nodo.getUserObject().toString().equals("Datos de Usuario")) {
                JPFichaUsuario frm = new JPFichaUsuario(this.JTFFNIngreso.getText());
                mMostrarPanel(frm);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen FísicoN")) {
                this.examenFisicoI = new JP_ExamenFisicoI(this.xclase, nodo.getUserObject().toString());
                mMostrarPanel(this.examenFisicoI);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen Físico_N")) {
                this.examenFisicoI1 = new JP_ExamenFisicoI1(this.xclase, nodo.getUserObject().toString());
                mMostrarPanel(this.examenFisicoI1);
                return;
            }
            if (nodo.getUserObject().toString().equals("Histórico de Atenciones")) {
                this.xjifhatenciones = new JPHistoricoAtenciones(this.xclase);
                mMostrarPanel(this.xjifhatenciones);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test Agudeza Visual")) {
                this.xjif_testagudeza_visual = new JPI_Test_AgudezaVisual();
                mMostrarPanel(this.xjif_testagudeza_visual);
                return;
            }
            if (nodo.getUserObject().toString().equals("Prueba Protector Respiratorio")) {
                this.xjiftest_prespiratorio = new JPSo_Test_PRespiratorio(0);
                mMostrarPanel(this.xjiftest_prespiratorio);
                return;
            }
            if (nodo.getUserObject().toString().equals("Importar Documentos HC")) {
                this.xjif_importardochc = new JP_Cargar_DocumentosHC(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.xjif_importardochc);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test Auditivo")) {
                this.xjiftest_prespiratorio = new JPSo_Test_PRespiratorio(1);
                mMostrarPanel(this.xjiftest_prespiratorio);
                return;
            }
            if (nodo.getUserObject().toString().equals("Signos Vitales")) {
                this.xJPRSignosVitales = new JPRSignosVitales(getName());
                mMostrarPanel(this.xJPRSignosVitales);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control Oxígeno")) {
                JPControlOxigeno frm2 = new JPControlOxigeno(getName());
                mMostrarPanel(frm2);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control de Líquidos")) {
                JPControlLiquidos frm3 = new JPControlLiquidos(String.valueOf(this.xidatencion), this.xidusuario);
                mMostrarPanel(frm3);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control Diabetes")) {
                this.xJPControlDiabetes = new JPControlDiabetes(getName());
                mMostrarPanel(this.xJPControlDiabetes);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen Clínico PE")) {
                this.xJPIExamenClinicoPE = new JPIExamenClinicoPE(this.xclase);
                mMostrarPanel(this.xJPIExamenClinicoPE);
                return;
            }
            if (nodo.getUserObject().toString().equals("Intervenciones Quirúrgicas") || nodo.getUserObject().toString().equals("Atención del Parto") || nodo.getUserObject().toString().equals("Procedimientos Menores") || nodo.getUserObject().toString().equals("Informe de Parto")) {
                this.xJPCirugias1 = new JPI_Cirugias1(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel(this.xJPCirugias1);
                return;
            }
            if (nodo.getUserObject().toString().equals("Familiares")) {
                this.xJPAAntecentesFamiliares = new JPAAntecentesFamiliares(this.xclase, 0);
                mMostrarPanel(this.xJPAAntecentesFamiliares);
                this.xJPAAntecentesFamiliares.JCBTipoParentesco.requestFocus();
                return;
            }
            if (nodo.getUserObject().toString().equals("Habitos")) {
                this.xJPAAntecentesHabitos = new JPAAntecentesHabitos(this.xclase, 0);
                mMostrarPanel(this.xJPAAntecentesHabitos);
                this.xJPAAntecentesHabitos.JRBPDSi.requestFocus();
                return;
            }
            if (nodo.getUserObject().toString().equals("Test Respiratorio(SARS-CoV-2)")) {
                if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                    this.triageRespiratorio = new JPTriageRespiratorio(new Long(0L), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "Test Respiratorio(SARS-CoV-2)");
                    mMostrarPanel(this.triageRespiratorio);
                    return;
                } else {
                    if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                        this.triageRespiratorio_V2 = new JPTriageRespiratorio_V2(new Long(0L), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "Test Respiratorio(SARS-CoV-2)");
                        mMostrarPanel(this.triageRespiratorio_V2);
                        return;
                    }
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Patologicos Personales")) {
                this.xJPAAntecentesPPersonales = new JPAAntecentesPPersonales(this.xclase, 0);
                mMostrarPanel(this.xJPAAntecentesPPersonales);
                return;
            }
            if (nodo.getUserObject().toString().equals("Revision Sistemas.")) {
                this.xRevisionSistemasTabla = new JPA_RevisionSistemasTabla(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()));
                mMostrarPanel(this.xRevisionSistemasTabla);
                return;
            }
            if (nodo.getUserObject().toString().equals("Patologicos Personales.") || nodo.getUserObject().toString().equals("Antecedentes Personales.") || nodo.getUserObject().toString().equals("Antecedentes N")) {
                this.xJPAntecedentesPersonalesTabla = new JPA_AntecedentesPersonalesTabla(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
                mMostrarPanel(this.xJPAntecedentesPersonalesTabla);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedentes Personales")) {
                this.xJPAAPatologiasAsociadas = new JPAAPatologiasAsociadas(this.xclase, 0);
                mMostrarPanel(this.xJPAAPatologiasAsociadas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedente Infantil")) {
                this.xJPAAntecedentesPediatricos = new JPAAntecedentesPediatricos(this.xclase, 0);
                mMostrarPanel(this.xJPAAntecedentesPediatricos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Odontológicos") || nodo.getUserObject().toString().equals("Antecedentes Odontológicos")) {
                this.xJPAAntecentesOdontologicos = new JPAAntecentesOdontologicos(this.xclase, 0, "jifanteodontologicos");
                mMostrarPanel(this.xJPAAntecentesOdontologicos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen Físico") || nodo.getUserObject().toString().equals("Signos Vitales.")) {
                this.xJPAExamenFisico = new JPAExamenFisico(this.xclase);
                mMostrarPanel(this.xJPAExamenFisico);
                this.xJPAExamenFisico.JTFFSFc.requestFocus();
                return;
            }
            if (nodo.getParent().getParent().toString().equals("Hallazgos Examen Físico") || nodo.getParent().getParent().toString().equals("DETALLE EXÁMEN FÍSICO") || nodo.getParent().getParent().toString().equals("Detalle Exámen Físico") || nodo.getParent().getParent().toString().equals("Test Optometrico") || nodo.getParent().getParent().toString().equals("Detalle Examen Optometrico") || nodo.getParent().getParent().toString().equals("Exámen Físico N")) {
                this.xJPAHExamenFisico = new JPAHExamenFisico(nodo.getUserObject().toString(), this.xclase, 0);
                mMostrarPanel(this.xJPAHExamenFisico);
                this.xJPAHExamenFisico.JRBEstadoAnormal.requestFocus();
                return;
            }
            if (nodo.getParent().toString().equals("Exámen Físico N")) {
                this.xJPAHExamenFisico = new JPAHExamenFisico(nodo.getUserObject().toString(), this.xclase, 1);
                mMostrarPanel(this.xJPAHExamenFisico);
                this.xJPAHExamenFisico.JRBEstadoAnormal.requestFocus();
                return;
            }
            if (nodo.getUserObject().toString().equals("Medicamentos")) {
                this.xjpsuministroh = new JPOOrdenSuministroH("Historia", this.xclase);
                mMostrarPanel(this.xjpsuministroh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Laboratorios")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 2, 1, nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Radiologia")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 3, 1, nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Otros Servicios")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 6, 1, nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografía")) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 11, 1, nodo.getParent().toString());
                } else {
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 12, 1, nodo.getParent().toString());
                }
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Otros Procedimientos")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 6, 1, nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Procedimientos Qx")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 10, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Laboratorios.")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 2, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Radiologia.")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 3, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Otros Servicios.")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 6, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografías.")) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 11, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                } else {
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 12, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nodo.getParent().toString());
                }
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Triage")) {
                this.xjptriage = new JPITriage();
                mMostrarPanel(this.xjptriage);
                return;
            }
            if (nodo.getUserObject().toString().equals("InterConsulta")) {
                this.xjpremisiones = new JPORemisiones(this.xclase, 0, true);
                mMostrarPanel(this.xjpremisiones);
                return;
            }
            if (nodo.getUserObject().toString().equals("Remisión")) {
                this.xjpremisiones = new JPORemisiones(this.xclase, 1, false);
                mMostrarPanel(this.xjpremisiones);
                return;
            }
            if (nodo.getUserObject().toString().equals("InterConsulta")) {
                this.xjpremisiones1 = new JPORemisiones1(this.xclase, 0, true);
                mMostrarPanel(this.xjpremisiones1);
                return;
            }
            if (nodo.getUserObject().toString().equals("Remisión1")) {
                this.xjpremisiones1 = new JPORemisiones1(this.xclase, 1, false);
                mMostrarPanel(this.xjpremisiones1);
                return;
            }
            if (nodo.getUserObject().toString().equals("Impresión Documentos")) {
                this.xJPImpresion_Doc = new JPI_Control_Impresion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario());
                mMostrarPanel(this.xJPImpresion_Doc);
                return;
            }
            if (nodo.getUserObject().toString().equals("Promoción y Prevención")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(this.xclase, 5, 1, nodo.getParent().toString());
                mMostrarPanel(this.xjpprocedimientosh);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ingreso a Programa")) {
                JP_CP_DatosPyP frm4 = new JP_CP_DatosPyP("Ingreso");
                mMostrarPanel1(frm4);
                return;
            }
            if (nodo.getUserObject().toString().equals("Egreso Programa")) {
                JP_CP_DatosPyP frm5 = new JP_CP_DatosPyP("Egreso");
                mMostrarPanel1(frm5);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala de Riesgo Biosicosocial")) {
                this.xJPRiesgoBiosicoSocial = new JPRiesgoBiosicoSocial();
                mMostrarPanel1(this.xJPRiesgoBiosicoSocial);
                return;
            }
            if (nodo.getUserObject().toString().equals("Resultados de Examenes") || nodo.getUserObject().toString().equals("Resultados Examenes Prenatal")) {
                this.xjifpyprevisionexamenes = new JP_CP_ResultadoExamenes1();
                mMostrarPanel1(this.xjifpyprevisionexamenes);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen Físico Prenatal")) {
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0) {
                    this.xJPAExamenFisicoPrenatal = new JPAExamenFisicoPrenatal(this.xclase);
                    mMostrarPanel1(this.xJPAExamenFisicoPrenatal);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Primero debe ingresar el Usuario al programa\nen el item Ingreso a Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Epicrisis")) {
                String[][] mparametros = new String[3][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = this.JTFFNAtencion.getText();
                mparametros[1][0] = "SUBREPORT_DIR";
                mparametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "H_HistoriaClinica_EpicrisisC", mparametros);
                return;
            }
            if (nodo.getUserObject().toString().equals("Plan Dx y Terapeutico")) {
                new JPFramingham();
                System.out.println("-------- " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdClaseCita());
                this.xjifconclusion = new JPAConclusion(this.xclase);
                mMostrarPanel(this.xjifconclusion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Egreso Urgencias") || nodo.getUserObject().toString().equals("Egreso") || nodo.getUserObject().toString().equals("Egreso Hospitalización")) {
                this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
                mMostrarPanel2(this.xJPEgresoUrgencias);
                return;
            }
            if (nodo.getUserObject().toString().equals("Laboratorio") || nodo.getUserObject().toString().equals("Lectura Radiologia") || nodo.getUserObject().toString().equals("Ecografia") || nodo.getUserObject().toString().equals("Otros Examenes Especializados") || nodo.getUserObject().toString().equals("Citologia") || nodo.getUserObject().toString().equals("Espirometria") || nodo.getUserObject().toString().equals("Ecocardiograma") || nodo.getUserObject().toString().equals("Electrocardiograma") || nodo.getUserObject().toString().equals("Control Glucometrias") || nodo.getUserObject().toString().equals("Mamografía") || nodo.getUserObject().toString().equals("Endoscopia") || nodo.getUserObject().toString().equals("Polisomnografia") || nodo.getUserObject().toString().equals("Resonancia") || nodo.getUserObject().toString().equals("Tac") || nodo.getUserObject().toString().equals("Prueba de Esfuerzo") || nodo.getUserObject().toString().equals("Densiometria Osea") || nodo.getUserObject().toString().equals("Tacar") || nodo.getUserObject().toString().equals("Esofagogastroduoendoscopia") || nodo.getUserObject().toString().equals("Test de Alergia") || nodo.getUserObject().toString().equals("Colonoscopia") || nodo.getUserObject().toString().equals("Audiometria") || nodo.getUserObject().toString().equals("Copia de Atencion") || nodo.getUserObject().toString().equals("Otros Documentos") || nodo.getUserObject().toString().equals("Tomografia")) {
                this.xJPARevisionAyudasDx = new JPARevisionAyudasDx(this.xclase, nodo.getUserObject().toString());
                mMostrarPanel(this.xJPARevisionAyudasDx);
                return;
            }
            if (nodo.getUserObject().toString().equals("Incapacidades")) {
                this.xjpincapacidad = new JPAIncapacidad(this.xclase, "xjifhistoria");
                mMostrarPanel(this.xjpincapacidad);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evento no deseado")) {
                this.xjpeventonodeseado = new JPAEventoNoDeseado(this.xclase);
                mMostrarPanel(this.xjpeventonodeseado);
                return;
            }
            if (nodo.getUserObject().toString().equals("Permisos")) {
                this.xjppermisos = new JPPermisosMedicos(this.xclase);
                mMostrarPanel(this.xjppermisos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Nueva Nota") || nodo.getUserObject().toString().equals("Evoluciones") || nodo.getUserObject().toString().equals("Evolución y/o Ordenes")) {
                this.xjpnotas = new JPANotas(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel4(this.xjpnotas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evolución y Conducta Inicial Urgencias")) {
                this.xjpnotas = new JPANotas(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(2,4)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel4(this.xjpnotas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Revisión Paraclinicos y Ayudas Dx")) {
                this.xjpnotas = new JPANotas(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(10)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel4(this.xjpnotas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Orden Medica Texto")) {
                this.xjpnotas = new JPANotas(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(3)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel4(this.xjpnotas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Nota Interconsulta") || nodo.getUserObject().toString().equals("Interconsulta-HU")) {
                this.xjpnotas = new JPANotas(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel4(this.xjpnotas);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evolucion Asistencial")) {
                this.xNotasMedicasNa = new JPA_NotasMedicasN(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5,6,7)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel(this.xNotasMedicasNa);
                return;
            }
            if (nodo.getUserObject().toString().equals("Procedimientos Menores N")) {
                this.xA_NotasProcedimientosMenores = new JPA_NotasProcedimientosMenores(this, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(8)", nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel(this.xA_NotasProcedimientosMenores);
                return;
            }
            if (nodo.getUserObject().toString().equals("Historico de Educación")) {
                JPAActividadesPyP frm6 = new JPAActividadesPyP(this.xclase);
                mMostrarPanel(frm6);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ginecologicos")) {
                this.xJPAAntecedenteGineco = new JPAAntecedenteGineco(this.xclase, 1);
                mMostrarPanel(this.xJPAAntecedenteGineco);
                return;
            }
            if (nodo.getUserObject().toString().equals("Cita Control")) {
                asignarCita();
                return;
            }
            if (nodo.getUserObject().toString().equals("Alimentacion")) {
                this.frmAlimentacion = new Alimentacion(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.frmAlimentacion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Motricidad Fina")) {
                this.frmMF = new MotricidadFina(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.frmMF);
                return;
            }
            if (nodo.getUserObject().toString().equals("Motricidad Gruesa")) {
                this.frmMG = new MotricidadGruesa(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.frmMG);
                return;
            }
            if (nodo.getUserObject().toString().equals("Valoracion Lenguaje")) {
                this.frmVL = new ValoracionLenguaje(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.frmVL);
                return;
            }
            if (nodo.getUserObject().toString().equals("Valoracion Personal")) {
                this.frmVP = new ValoracionPersonal(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel(this.frmVP);
                return;
            }
            if (nodo.getUserObject().toString().equals("Resultados CyD")) {
                this.frmVR = new ValoracionResultado(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo());
                mMostrarPanel(this.frmVR);
                return;
            }
            if (nodo.getUserObject().toString().equals("Laboratorio Sistematizado")) {
                JPARevisionAyudasDxS frm7 = new JPARevisionAyudasDxS(this.xclase, nodo.getUserObject().toString());
                mMostrarPanel(frm7);
                return;
            }
            if (nodo.getUserObject().toString().equals("Radiología Sistematizadas")) {
                this.xJPARevisionAyudasDxRx = new JPARevisionAyudasDxRx(this.xclase, nodo.getUserObject().toString());
                mMostrarPanel(this.xJPARevisionAyudasDxRx);
                return;
            }
            if (nodo.getUserObject().toString().equals("Nutricion")) {
                this.xjpnutricion = new JPHNutricional(this.xclase);
                mMostrarPanel(this.xjpnutricion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ocupacionales_Nuevo")) {
                JPAAntecentesOcupacionalesNuevo aAntecentesOcupacionalesNuevo = new JPAAntecentesOcupacionalesNuevo(Principal.clasehistoriace, 0);
                mMostrarPanel(aAntecentesOcupacionalesNuevo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ocupacionales")) {
                JPAAntecentesOcupacionales frm8 = new JPAAntecentesOcupacionales(this.xclase, 0);
                mMostrarPanel(frm8);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test de Morisky - Green")) {
                this.xJPATestMorisky = new JPATestMorisky(this.xclase, 0);
                mMostrarPanel(this.xJPATestMorisky);
                return;
            }
            if (nodo.getParent().toString().equals("Revision Sistemas")) {
                this.xJPARevisionSistemas = new JPARevisionSistemas(nodo.getUserObject().toString(), this.xclase);
                mMostrarPanel(this.xJPARevisionSistemas);
                this.xJPARevisionSistemas.JRBEstadoAnormal.requestFocus();
                return;
            }
            if (nodo.getParent().toString().equals("PyP CP")) {
                if (nodo.getUserObject().equals("Ingreso") || nodo.getUserObject().equals("Egreso")) {
                    JP_CP_DatosPyP frm9 = new JP_CP_DatosPyP(nodo.getUserObject().toString());
                    mMostrarPanel1(frm9);
                    return;
                } else {
                    if (nodo.getUserObject().equals("Riesgo BiosicoSocial")) {
                        this.xJPRiesgoBiosicoSocial = new JPRiesgoBiosicoSocial();
                        mMostrarPanel1(this.xJPRiesgoBiosicoSocial);
                        return;
                    }
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Trabajo en Alturas")) {
                this.xJPASaludOcupacional = new JPASaludOcupacional();
                mMostrarPanel1(this.xJPASaludOcupacional);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografia Abdominal")) {
                this.xjifecografiagenerico = new JPAEcografiaGenerico("jifecoabdominal", this.xclase);
                mMostrarPanel1(this.xjifecografiagenerico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografía Ecobiliarab")) {
                this.xjifecografiagenerico = new JPAEcografiaGenerico("jifecoecobiliarab", this.xclase);
                mMostrarPanel1(this.xjifecografiagenerico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografía Pélvica")) {
                this.xjifecografiap = new JPAEcografiaPelvica("xjifecografia", this.xclase);
                mMostrarPanel1(this.xjifecografiap);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografía.")) {
                this.xjifecografiagenerico = new JPAEcografiaGenerico("xjifecografia", this.xclase);
                mMostrarPanel1(this.xjifecografiagenerico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ecografia Obstetrica")) {
                this.xJPAEcografiaObstetrica = new JPAEcografiaObstetrica("jifecoobstetrica", this.xclase);
                mMostrarPanel1(this.xJPAEcografiaObstetrica);
                return;
            }
            if (nodo.getUserObject().toString().equals("Concepto Aptitud")) {
                this.xjifconceptosio_i = new JPSo_Concepto_I(this.xclase, 2);
                mMostrarPanel1(this.xjifconceptosio_i);
                return;
            }
            if (nodo.getUserObject().toString().equals("Concepto Aptitud Laboral")) {
                this.xjifconceptosio_i = new JPSo_Concepto_I(this.xclase, 0, this.JTFFNIngreso.getText());
                mMostrarPanel1(this.xjifconceptosio_i);
                return;
            }
            if (nodo.getUserObject().toString().equals("Concepto Aptitud Laboral R")) {
                this.concepto_R = new JPSo_Concepto_R(this.xclase, 0, this.JTFFNIngreso.getText());
                mMostrarPanel1(this.concepto_R);
                return;
            }
            if (nodo.getUserObject().toString().equals("Concepto Aptitud Laboral (Egreso)")) {
                this.xjifconceptoso_e = new JPSo_Concepto_E(this.xclase);
                mMostrarPanel1(this.xjifconceptoso_e);
                return;
            }
            if (nodo.getUserObject().toString().equals("Prescripción Ejercicio")) {
                this.xjifprescripcionejercicio = new JPSo_PEjercicio(this.xclase);
                mMostrarPanel1(this.xjifprescripcionejercicio);
                return;
            }
            if (nodo.getUserObject().toString().equals("Audiometria So")) {
                this.xjifaudiometria = new JPSo_Audiometria();
                mMostrarPanel1(this.xjifaudiometria);
                return;
            }
            if (nodo.getUserObject().toString().equals("Audiometria So 2")) {
                this.xJPSo_Audiometria_nueva = new JPSo_Audiometria_nueva();
                mMostrarPanel1(this.xJPSo_Audiometria_nueva);
                return;
            }
            if (nodo.getUserObject().toString().equals("Espirometria So")) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0 || Principal.informacionIps.getIdentificacion().equals("901420803")) {
                    this.xjifespirometria = new JPSo_Espirometria();
                    mMostrarPanel1(this.xjifespirometria);
                    return;
                } else {
                    this.xjifespirometriaSI = new JPSo_EspirometriaSI();
                    mMostrarPanel1(this.xjifespirometriaSI);
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Visiometria So")) {
                this.xjifvisiometriafpz = new JPSo_VisiometriaFPZ();
                mMostrarPanel1(this.xjifvisiometriafpz);
                return;
            }
            if (nodo.getUserObject().toString().equals("Visiometria So2")) {
                this.xjifvisiometriaG = new JPSo_VisiometriaG();
                mMostrarPanel1(this.xjifvisiometriaG);
                return;
            }
            if (nodo.getUserObject().toString().equals("NOMA")) {
                this.xjifosteomuscuar = new JPSo_Osteomuscular();
                mMostrarPanel1(this.xjifosteomuscuar);
                return;
            }
            if (nodo.getUserObject().toString().equals("Exámen Optometrico")) {
                this.jP_Optometria = new JP_Optometria(this.xclase);
                mMostrarPanel1(this.jP_Optometria);
                return;
            }
            if (nodo.getUserObject().toString().equals("Visual")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 1, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Auditivo")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 2, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Respiratorio")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 3, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Alergia")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 4, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Altura")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 5, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala de  Kessler (K10)")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 13, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Acoso Sexual")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 41, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Síntomas neurotóxicos Q16")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 49, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Consumo de Alcohol - Audit Test")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 14, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala de Epworth - Tamiz Somnolencia")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 15, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala DSM4")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 16, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("CAGE - Riesgo de Alcoholismo")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 17, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evaluación Estres")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 7, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Factores Psicosociales Extralaborales")) {
                this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nodo.getUserObject().toString().toUpperCase(), 8);
                mMostrarPanel1(this.xJPSo_CuestionarioSico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Estilos de Afrontamiento")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 9, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Formato A (Intralaboral)")) {
                this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nodo.getUserObject().toString().toUpperCase(), 10);
                mMostrarPanel1(this.xJPSo_CuestionarioSico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Formato B (Intralaboral)")) {
                this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nodo.getUserObject().toString().toUpperCase(), 11);
                mMostrarPanel1(this.xJPSo_CuestionarioSico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evaluación de Fatiga")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 12, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("DASS 21")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 50, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("HINE")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 54, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Childhood Asthma Control Test")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 51, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Indice predictor de asma (IPA)")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 52, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("PAQLQ")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 53, 0);
                mMostrarPanel1(this.xjifcuestionarios_n);
                return;
            }
            if (nodo.getUserObject().toString().equals("Prueba de AyD")) {
                this.xjifpruebaayd = new JPPruebaAyD(this);
                mMostrarPanel1(this.xjifpruebaayd);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test de Fatiga")) {
                this.xjptestfatiga = new JPTestFatiga(this);
                mMostrarPanel1(this.xjptestfatiga);
                return;
            }
            if (nodo.getUserObject().toString().equals("Odontograma")) {
                this.xjifOdontograma = new JPOdontograma();
                mMostrarPanel1(this.xjifOdontograma);
                return;
            }
            if (nodo.getUserObject().toString().equals("Odontograma Inicial")) {
                this.xJPOdontogramaInicial = new JPOdontogramaInicial();
                mMostrarPanel1(this.xJPOdontogramaInicial);
                return;
            }
            if (nodo.getUserObject().toString().equals("Odontograma Clínico")) {
                this.xJPOdontogramaClinico = new JPOdontogramaClinico();
                mMostrarPanel1(this.xJPOdontogramaClinico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control Placa")) {
                this.xjifControlPlaca = new JPControlPlaca();
                mMostrarPanel1(this.xjifControlPlaca);
                return;
            }
            if (nodo.getUserObject().toString().equals("Clasificación Riesgo.")) {
                this.xjpgestionriesgohta = new JPGestionRiesgo_Hta(this.xclase);
                mMostrarPanel1(this.xjpgestionriesgohta);
                return;
            }
            if (nodo.getUserObject().toString().equals("Clasificación Riesgo")) {
                this.xjpgestionriesgo = new JPGestionRiesgo_Dm(this.xclase);
                mMostrarPanel1(this.xjpgestionriesgo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Seguimiento")) {
                this.xjifseguimiento = new JPISeguimiento_Pac(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel1(this.xjifseguimiento);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ingreso HTA")) {
                this.xjifHTA = new JP_PyP_HTA("xjifhta_HC", 1L);
                mMostrarPanel1(this.xjifHTA);
                return;
            }
            if (nodo.getUserObject().toString().equals("Egreso HTA")) {
                this.xjifHTA = new JP_PyP_HTA("xjifhta_HC", 2L);
                mMostrarPanel1(this.xjifHTA);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ingreso DM")) {
                this.xjifdiabetes = new JP_PyP_Diabetes("xjifDiabetes_HC", 1L);
                mMostrarPanel1(this.xjifdiabetes);
                return;
            }
            if (nodo.getUserObject().toString().equals("Egreso DM")) {
                this.xjifdiabetes = new JP_PyP_Diabetes("xjifDiabetes_HC", 2L);
                mMostrarPanel1(this.xjifdiabetes);
                return;
            }
            if (nodo.getUserObject().toString().equals("Exámenes Dentarios")) {
                this.xJPExamenDentario = new JPExamenDentario();
                mMostrarPanel1(this.xJPExamenDentario);
                return;
            }
            if (nodo.getUserObject().toString().equals("Hábitos Dentarios")) {
                this.xJPAAntecentesOdontologicos = new JPAAntecentesOdontologicos(this.xclase, 0, "jifhdentarios");
                mMostrarPanel(this.xJPAAntecentesOdontologicos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Oclusión")) {
                this.xJPOclusion = new JPOclusion();
                mMostrarPanel(this.xJPOclusion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Endodoncia")) {
                this.xJPEndoExamenClinico = new JPEndoExamenClinico();
                mMostrarPanel1(this.xJPEndoExamenClinico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Análisis Cefalométrico")) {
                this.xJPCefalometria = new JPCefalometria();
                mMostrarPanel1(this.xJPCefalometria);
                return;
            }
            if (nodo.getUserObject().toString().equals("Análisis Oclusal")) {
                this.xJPAnalisiOclusal = new JPAnalisiOclusal();
                mMostrarPanel1(this.xJPAnalisiOclusal);
                return;
            }
            if (nodo.getUserObject().toString().equals("Análisis Estomatológico")) {
                this.xJPAnalisisEstomatologico = new JPAnalisisEstomatologico();
                mMostrarPanel1(this.xJPAnalisisEstomatologico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Análisis Funcional")) {
                this.xJPAnalisisFuncional = new JPAnalisisFuncional();
                mMostrarPanel1(this.xJPAnalisisFuncional);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala Abreviada")) {
                this.xJPEscalaAbreviada = new JPEscalaAbreviada();
                mMostrarPanel1(this.xJPEscalaAbreviada);
                return;
            }
            if (nodo.getUserObject().toString().equals("Cálculo IFG")) {
                this.xJPFiltroIFG = new JPFiltroIFG();
                mMostrarPanel1(this.xJPFiltroIFG);
                return;
            }
            if (nodo.getUserObject().toString().equals("Vacunación") || nodo.getUserObject().toString().equals("Esquema de Vacunación")) {
                this.xJPVacunacion = new JPVacunacion();
                mMostrarPanel1(this.xJPVacunacion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Exámen Físico CyD")) {
                this.xJPGraficasPyP = new JPGraficasPyP();
                mMostrarPanel1(this.xJPGraficasPyP);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala Abreviada de Desarrollo")) {
                this.jPAEscalaAbreviadaDeDesarrollo = new JPAEscalaAbreviadaDeDesarrollo(clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
                mMostrarPanel(this.jPAEscalaAbreviadaDeDesarrollo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Terapia Física")) {
                this.xjif_terapiaf = new JPHistoria_Terapias(0);
                mMostrarPanel1(this.xjif_terapiaf);
                return;
            }
            if (nodo.getUserObject().toString().equals("Terapia Respiratoria")) {
                this.xjif_terapiaf = new JPHistoria_Terapias(1);
                mMostrarPanel1(this.xjif_terapiaf);
                return;
            }
            if (nodo.getUserObject().toString().equals("Atención del niño de 2 meses a 5 años")) {
                this.xJPAiepi = new JPAiepi();
                mMostrarPanel1(this.xJPAiepi);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control de Transfusiones")) {
                this.xJPTransfuciones = new JPTransfuciones("xTransfusionHC");
                mMostrarPanel1(this.xJPTransfuciones);
                return;
            }
            if (nodo.getUserObject().toString().equals("Trasnporte Asistencial")) {
                this.xJPTrasnporteAsis = new JPTrasnporteAsis();
                mMostrarPanel1(this.xJPTrasnporteAsis);
                return;
            }
            if (nodo.getUserObject().toString().equals("Aiepi Niños 0 a 2 Meses")) {
                this.xJPAiepiNinos = new JPAiepiNinos();
                mMostrarPanel1(this.xJPAiepiNinos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Aiepi Atención a la Madre")) {
                this.xJPAiepiMadres = new JPAiepiMadres();
                mMostrarPanel1(this.xJPAiepiMadres);
                return;
            }
            if (nodo.getUserObject().toString().equals("Lista de chequeo")) {
                this.xJPListaCHequeo = new JPListaCHequeo();
                mMostrarPanel1(this.xJPListaCHequeo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Adulto Mayor") || nodo.getUserObject().toString().equals("Evaluación Riesgo Psicosocial")) {
                this.xJPAdultoMayor = new JPAdultoMayor();
                mMostrarPanel1(this.xJPAdultoMayor);
                return;
            }
            if (nodo.getUserObject().toString().equals("Adulto Joven")) {
                this.xJIFAdultoJoven = new JIFAdultoJoven();
                mMostrarPanel1(this.xJIFAdultoJoven);
                return;
            }
            if (nodo.getUserObject().toString().equals("Datos sociodemográficos")) {
                this.xJPSociodemografico = new JPSociodemografico();
                mMostrarPanel1(this.xJPSociodemografico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Exámen Oftamológico")) {
                this.xJPOftamologiaGen = new JPOftamologiaGen();
                mMostrarPanel1(this.xJPOftamologiaGen);
                return;
            }
            if (nodo.getUserObject().toString().equals("Control Placa Bacteriana")) {
                this.xJPControlPlacaCompleto = new JPControlPlacaCompleto();
                mMostrarPanel1(this.xJPControlPlacaCompleto);
                return;
            }
            if (nodo.getUserObject().toString().equals("Información Complementaria")) {
                this.xJIFAdultoJoven2 = new JIFAdultoJoven2();
                mMostrarPanel1(this.xJIFAdultoJoven2);
                return;
            }
            if (nodo.getUserObject().toString().equals("Partograma")) {
                this.xJPPartograma = new JPPartograma(nodo.getUserObject().toString().toUpperCase());
                mMostrarPanel1(this.xJPPartograma);
                return;
            }
            if (nodo.getUserObject().toString().equals("Planificación Familiar")) {
                this.xJPPlanificacionFliar = new JPPlanificacionFliar();
                mMostrarPanel1(this.xJPPlanificacionFliar);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evaluacion Recien Nacido")) {
                JPAEvaluacionRecienNacido evaluacion = new JPAEvaluacionRecienNacido(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), "" + Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                mMostrarPanel(evaluacion);
                return;
            }
            if (nodo.getUserObject().toString().equals("Histórico de exposición")) {
                this.xJPGraficaAgenteSEG = new JPGraficaAgenteSEG();
                mMostrarPanel1(this.xJPGraficaAgenteSEG);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evento Adverso")) {
                this.xJPEventoAdverso = new JPEventoAdverso(false, this.JTFFNIngreso.getText(), 2);
                mMostrarPanel1(this.xJPEventoAdverso);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evaluacion de Riesgo")) {
                this.xJPAEvaluacionRiesgo = new JPAEvaluacionRiesgo();
                mMostrarPanel1(this.xJPAEvaluacionRiesgo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Framingham")) {
                this.xJPFramingham = new JPFramingham();
                mMostrarPanel1(this.xJPFramingham);
                return;
            }
            if (nodo.getUserObject().toString().equals("Framingham1")) {
                this.xJPFramingham1 = new JPFramingham1();
                mMostrarPanel1(this.xJPFramingham);
                return;
            }
            if (nodo.getUserObject().toString().equals("Framingham_M")) {
                this.xJPFraminghamM = new JPFramingham_M();
                mMostrarPanel1(this.xJPFramingham);
                return;
            }
            if (nodo.getUserObject().toString().equals("Biblioteca SO")) {
                this.xJPSoBiblioteca = new JPSoBiblioteca();
                mMostrarPanel1(this.xJPSoBiblioteca);
                return;
            }
            if (nodo.getUserObject().toString().equals("Ruffier")) {
                this.xJPRuffier = new JPRuffier();
                mMostrarPanel1(this.xJPRuffier);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala del dolor")) {
                this.xJPEscalaDolor = new JPEscalaDolor();
                mMostrarPanel1(this.xJPEscalaDolor);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala fuerza muscular")) {
                this.xJPEscalaFuerzaMuscular = new JPEscalaFuerzaMuscular();
                mMostrarPanel1(this.xJPEscalaFuerzaMuscular);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test Findrisk")) {
                try {
                    String sql = "SELECT PerimetroAbdominal, IMC FROM h_examenfisico WHERE Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    ResultSet xrs = this.xct.traerRs(sql);
                    if (xrs.next()) {
                        xrs.first();
                        if (xrs.getInt("IMC") > 0) {
                            if (xrs.getInt("PerimetroAbdominal") > 0) {
                                this.xJPTestFindrisk = new JPTestFindrisk();
                                mMostrarPanel1(this.xJPTestFindrisk);
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el perímetro abdominal en el examen físico \n para poder continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el IMC en el examen físico \n para poder continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    }
                    xrs.close();
                    this.xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            if (nodo.getUserObject().toString().equals("Revision Examenes So")) {
                this.xJPRevisonExamenSo = new JPRevisonExamenSo(this.xclase);
                mMostrarPanel1(this.xJPRevisonExamenSo);
                return;
            }
            if (nodo.getUserObject().toString().equals("Certificados Salud Ocupacional")) {
                this.xJPCertificadoSO = new JPCertificadoSO(this.xclase);
                mMostrarPanel1(this.xJPCertificadoSO);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evidencia Fotografica")) {
                this.xllamarPanel = "Evidencia Fotografica";
                this.xWorkerSQL = null;
                this.xWorkerSQL = new WorkerSQL("Cargando Panel...", this);
                this.xWorkerSQL.execute();
                return;
            }
            if (nodo.getUserObject().toString().equals("Fonoaudiologia")) {
                this.xJPAFonoaudiologia = new JPAFonoaudiologia(this.xclase);
                mMostrarPanel1(this.xJPAFonoaudiologia);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedentes Reumatología")) {
                this.xJPAAntecedenteReumatologia = new JPAAntecedenteReumatologia(this.xclase);
                mMostrarPanel1(this.xJPAAntecedenteReumatologia);
                return;
            }
            if (nodo.getUserObject().toString().equals("Tamizaje Estético")) {
                this.xJPATamizajeEstetico = new JPATamizajeEstetico(this.xclase);
                mMostrarPanel1(this.xJPATamizajeEstetico);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedentes Físicos Psiquiatricos")) {
                this.jpAntecedentesFisicosPsiquiatricos = new JPAntecedentesFisicosPsiquiatricos();
                mMostrarPanel1(this.jpAntecedentesFisicosPsiquiatricos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Test Psicomotriz")) {
                this.xJPSo_Psicomotriz = new JPSo_Psicomotriz(this.xclase);
                mMostrarPanel1(this.xJPSo_Psicomotriz);
                return;
            }
            if (nodo.getUserObject().toString().equals("Deprecion Posparto") || nodo.getUserObject().toString().equals("Deprecion en Embarazo")) {
                this.xJPDepresionPosparto = new JPDepresionPosparto(this.xclase);
                mMostrarPanel1(this.xJPDepresionPosparto);
                return;
            }
            if (nodo.getUserObject().toString().equals("Violencia y Maltrato")) {
                this.xJPMaltratoViolencia = new JPMaltratoViolencia(this.xclase);
                mMostrarPanel1(this.xJPMaltratoViolencia);
                return;
            }
            if (nodo.getUserObject().toString().equals("Exámen Reumatológico")) {
                this.xJPReuConteoArticulaciones = new JPReuConteoArticulaciones();
                mMostrarPanel1(this.xJPReuConteoArticulaciones);
                return;
            }
            if (nodo.getUserObject().toString().equals("Clasificación ACR Eular")) {
                this.xJPAClasificacionEular = new JPAClasificacionEular(this.xclase);
                mMostrarPanel1(this.xJPAClasificacionEular);
                return;
            }
            if (nodo.getUserObject().toString().equals("Cuestionario de Discapacidad HAQ")) {
                this.xJPCuestionarioHAQ = new JPCuestionarioHAQ(this.xclase);
                mMostrarPanel1(this.xJPCuestionarioHAQ);
                return;
            }
            if (nodo.getUserObject().toString().equals("Visiometria M")) {
                this.xJPSo_VisiometriaMineros = new JPSo_VisiometriaMineros();
                mMostrarPanel1(this.xJPSo_VisiometriaMineros);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedentes Gineco-Obstétricos")) {
                this.xJPAAntecedentesGinecobstetricos = new JPAAntecedentesGinecobstetricos(this.xclase);
                mMostrarPanel1(this.xJPAAntecedentesGinecobstetricos);
                return;
            }
            if (nodo.getUserObject().toString().equals("Antecedentes Familiares Texto")) {
                this.antecedenteFamiliarTexto = new JPAntecedenteFamiliarTexto(this.xclase);
                mMostrarPanel1(this.antecedenteFamiliarTexto);
                return;
            }
            if (nodo.getUserObject().toString().equals("Escala de Glasgow")) {
                this.xJPGlasgow = new JPGlasgow();
                mMostrarPanel1(this.xJPGlasgow);
                return;
            }
            if (nodo.getUserObject().toString().equals("Familiograma  y Ecomapa")) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                long idPersona = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
                clasesHistoriaCE.informacionAgendaMedicaDTO.getFecha_HoraAtencion();
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS")) {
                    this.xJPAFamiliograma = new JPAFamiliograma(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), clasesHistoriaCE.informacionAgendaMedicaDTO.getFecha_HoraAtencion(), idPersona);
                    mMostrarPanel(this.xJPAFamiliograma);
                    return;
                }
                return;
            }
            if (nodo.getUserObject().toString().equals("RQC")) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS")) {
                    this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nodo.getUserObject().toString().toUpperCase(), 18, 0);
                    mMostrarPanel1(this.xjifcuestionarios_n);
                    return;
                }
                return;
            }
            if (nodo.getUserObject().toString().equals("Progreso en los Hitos del desarrollo") || nodo.getUserObject().toString().equals("Resultados de las pruebas de tamizaje neonatal") || nodo.getUserObject().toString().equals("Valoración de salud mental") || nodo.getUserObject().toString().equals("Valoración de prácticas alimentarias") || nodo.getUserObject().toString().equals("Dinámica familiar como apoyo al desarrollo integral") || nodo.getUserObject().toString().equals("Valorar la salud sexual") || nodo.getUserObject().toString().equals("Valorar la salud visual") || nodo.getUserObject().toString().equals("Valorar la salud auditiva y comunicativa") || nodo.getUserObject().toString().equals("Otros aspectos físicos") || nodo.getUserObject().toString().equals("Valorar las estructuras dentomaxilofaciales  y su funcionalidad")) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS")) {
                    this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                    mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
                    return;
                }
                return;
            }
            if (nodo.getUserObject().toString().equals("Anexo 2")) {
                this.formularioAnexo2 = new JPI_FormularioAnexo2(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mMostrarPanel1(this.formularioAnexo2);
                return;
            }
            if (nodo.getUserObject().toString().equals("Anexo 3")) {
                this.formularioAnexo3 = new JPI_FormularioAnexo3(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString());
                mMostrarPanel1(this.formularioAnexo3);
                return;
            }
            if (nodo.getUserObject().toString().equals("Solicitud Dieta")) {
                this.xJPAtencionDieta = new JPAtencionDieta(this.xclase);
                mMostrarPanel1(this.xJPAtencionDieta);
                return;
            }
            if (nodo.getUserObject().toString().equals("Evaluación Criterios CRB-65")) {
                this.testCrb65 = new JPA_TestCrb65(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                mMostrarPanel1(this.testCrb65);
                return;
            }
            if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
                if (nodo.getUserObject().toString().equals("Hallazgos Examen Físico")) {
                    this.xJPAHExamenFisico = new JPAHExamenFisico(nodo.getUserObject().toString(), this.xclase, 0);
                    mMostrarPanel(this.xJPAHExamenFisico);
                    this.xJPAHExamenFisico.JRBEstadoAnormal.requestFocus();
                    return;
                }
                return;
            }
            if (nodo.getUserObject().toString().equals("Tejidos Blandos")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
                return;
            }
            if (nodo.getUserObject().toString().equals("ATM Onclusion")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
                return;
            }
            if (nodo.getUserObject().toString().equals("Tejidos Dentales")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
                return;
            }
            if (nodo.getUserObject().toString().equals("Tejidos Peridontal")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
                return;
            }
            if (nodo.getUserObject().toString().equals("Examen Pulpar")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
            } else if (nodo.getUserObject().toString().equals("Habitos Orales")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
            } else if (nodo.getUserObject().toString().equals("Acción Preventiva")) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nodo.getUserObject().toString().toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mMostrarPanel1(this.xJPA_Atencion_InformacionN10);
            } else {
                mLimpiarPanel();
            }
        }
    }

    public void mCargarPanelConLoad() {
        if (this.xllamarPanel.equals("Evidencia Fotografica")) {
            this.xJPGaleriaImagenes = new JPGaleriaImagenes(this.xclase);
            mMostrarPanel1(this.xJPGaleriaImagenes);
        }
        this.xllamarPanel = "";
    }

    private void mActivarAgendas() {
        if (this.xnombre.equals("Historia_Med")) {
            if (this.xclase.xjifagendan == null) {
                this.xclase.frmPrincipal.mLimpiarPanel();
                this.xclase.cargarPantalla("AgendaN", this.xclase.frmPrincipal);
                return;
            }
            return;
        }
        if (this.xnombre.equals("Historia_Enf")) {
            if (Principal.claseenfer.xjifagenda == null) {
                Principal.claseenfer.xjp.mLimpiarPanel();
                Principal.claseenfer.cargarPantalla("Agenda");
                return;
            }
            return;
        }
        if (this.xnombre.equals("Historia_So")) {
            if (Principal.xclaseso.xjifagenda == null) {
                Principal.xclaseso.xjfp.mLimpiarPanel();
                Principal.xclaseso.cargarPantalla("Agenda_So");
                return;
            }
            return;
        }
        if (this.xnombre.equals("Historia_Med_H") && Principal.clasehistoriace.xjifagenda_UH == null) {
            dispose();
            Principal.clasehistoriace.cargarPantalla("Agenda_UH", Principal.clasehistoriace.frmPrincipal);
        }
    }

    public void mActualizarEstadoValidacion(String xEstado, String xNombreHoja, int xNColumna) {
        for (int i = 0; i < this.xArbolHC.length && this.xArbolHC[i][0] != null; i++) {
            if (this.xArbolHC[i][0].equals(xNombreHoja)) {
                this.xArbolHC[i][xNColumna] = xEstado;
                return;
            }
        }
    }

    public String mVerificarEstadoHoja(String xNombreHoja, int xNColumna) {
        String estado = "0";
        int i = 0;
        while (true) {
            if (i >= this.xArbolHC.length || this.xArbolHC[i][0] == null) {
                break;
            }
            if (!this.xArbolHC[i][0].equals(xNombreHoja)) {
                i++;
            } else {
                estado = this.xArbolHC[i][xNColumna];
                break;
            }
        }
        return estado;
    }

    private void mArmarHC() {
        int xtiposex;
        String xsql;
        setxValidado(false);
        this.JLBNDatosU.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " - " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta() + " - " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + " - " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo());
        this.JTFFNIngreso.setText(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
        this.JTFFNAtencion.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        setTitle(getTitle() + " -- " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreEmpresaCovenio() + "  --  " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFecha_HoraAtencion());
        this.xclase.mBuscarMotivoConsulta();
        String xsql2 = "SELECT h_chistoria.Id, h_chistoria.Nbre, h_chistoria.Nivel, h_chistoria.`Validable`  FROM h_ctipohcxdhistoria INNER JOIN h_chistoria  ON (h_ctipohcxdhistoria.Id_CHhistoria = h_chistoria.Id)  WHERE (h_ctipohcxdhistoria.Id_TipoHistoria ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "' AND h_ctipohcxdhistoria.Estado=1)  ORDER BY h_ctipohcxdhistoria.Orden ASC ";
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(xsql2);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    if (rs.getBoolean("Validable")) {
                        this.xArbolHC[this.xnfila][0] = rs.getString("Nbre");
                        this.xArbolHC[this.xnfila][1] = "1";
                        this.xArbolHC[this.xnfila][2] = "0";
                        this.xnfila++;
                    }
                    this.genericosg = new DefaultMutableTreeNode(rs.getString(2));
                    this.modelo.insertNodeInto(this.genericosg, this.atencion, x);
                    if (rs.getInt(3) == 1) {
                        String xsql3 = "SELECT Id, Nbre, Sexo, Programa, Validable FROM h_cniveluno WHERE (id_chistoria ='" + rs.getInt(1) + "' AND h_cniveluno.Estado=1) ORDER BY Orden ASC ";
                        ConsultasMySQL xmt1 = new ConsultasMySQL();
                        ResultSet rs1 = xmt1.traerRs(xsql3);
                        if (rs1.next()) {
                            rs1.beforeFirst();
                            int j = 0;
                            while (rs1.next()) {
                                if (rs1.getBoolean("Validable")) {
                                    this.xArbolHC[this.xnfila][0] = rs1.getString("Nbre");
                                    this.xArbolHC[this.xnfila][1] = "1";
                                    this.xArbolHC[this.xnfila][2] = "0";
                                    this.xnfila++;
                                }
                                if (rs1.getInt(3) == 1) {
                                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("F") || clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("FEMENINO")) {
                                        this.modelo.insertNodeInto(new DefaultMutableTreeNode(rs1.getString(2)), this.genericosg, j);
                                        j++;
                                    }
                                } else {
                                    this.modelo.insertNodeInto(new DefaultMutableTreeNode(rs1.getString(2)), this.genericosg, j);
                                    j++;
                                }
                            }
                        }
                        rs1.close();
                        xmt1.cerrarConexionBd();
                    } else if (rs.getInt(3) == 2) {
                        ConsultasMySQL xmt2 = new ConsultasMySQL();
                        String xsql4 = "SELECT h_tiposistemas.Id, h_tiposistemas.Nbre    FROM h_tiposistemas INNER JOIN h_gruposistemas  ON (h_tiposistemas.Id_GrupoSistemas = h_gruposistemas.Id) INNER JOIN h_csistemaxtipohc  ON (h_csistemaxtipohc.Id_TipoSistema = h_tiposistemas.Id) WHERE ( h_csistemaxtipohc.Id_TipoHc = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "'AND h_tiposistemas.Estado =0) ";
                        ResultSet rs2 = xmt2.traerRs(xsql4);
                        if (rs2.next()) {
                            rs2.beforeFirst();
                            int y = 0;
                            while (rs2.next()) {
                                DefaultMutableTreeNode genericosy = new DefaultMutableTreeNode(rs2.getString(2));
                                this.modelo.insertNodeInto(genericosy, this.genericosg, y);
                                y++;
                            }
                        }
                        rs2.close();
                        xmt2.cerrarConexionBd();
                        mCrearRevisionSistemas();
                    } else if (rs.getInt(3) == 3) {
                        ConsultasMySQL xmt12 = new ConsultasMySQL();
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                            xtiposex = 0;
                            xsql = "SELECT h_grupoexamenfisico.Id, h_grupoexamenfisico.Nbre  FROM h_cdetalleexamenfisicoxtipohc INNER JOIN h_tipoexamenfisico  ON (h_cdetalleexamenfisicoxtipohc.Id_Tipoexamenfisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) WHERE (h_grupoexamenfisico.Estado =0  AND h_cdetalleexamenfisicoxtipohc.Id_TipoHc ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "' AND FiltroSexo=0) GROUP BY h_grupoexamenfisico.Id ";
                        } else {
                            xtiposex = 1;
                            xsql = "SELECT h_grupoexamenfisico.Id, h_grupoexamenfisico.Nbre  FROM h_cdetalleexamenfisicoxtipohc INNER JOIN h_tipoexamenfisico  ON (h_cdetalleexamenfisicoxtipohc.Id_Tipoexamenfisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) WHERE (h_grupoexamenfisico.Estado =0  AND h_cdetalleexamenfisicoxtipohc.Id_TipoHc ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "') GROUP BY h_grupoexamenfisico.Id ";
                        }
                        ResultSet rs12 = xmt12.traerRs(xsql);
                        if (rs12.next()) {
                            rs12.beforeFirst();
                            int j2 = 0;
                            while (rs12.next()) {
                                DefaultMutableTreeNode genericosj = new DefaultMutableTreeNode(rs12.getString(2));
                                this.modelo.insertNodeInto(genericosj, this.genericosg, j2);
                                String xsql5 = "SELECT h_tipoexamenfisico.Id, h_tipoexamenfisico.Nbre FROM h_cdetalleexamenfisicoxtipohc INNER JOIN h_tipoexamenfisico  ON (h_cdetalleexamenfisicoxtipohc.Id_Tipoexamenfisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) WHERE (h_tipoexamenfisico.Estado =0  AND h_tipoexamenfisico.Id_GrupoExamenFisico ='" + rs12.getInt(1) + "' and h_cdetalleexamenfisicoxtipohc.Id_TipoHc='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "')";
                                ConsultasMySQL xmt22 = new ConsultasMySQL();
                                ResultSet rs22 = xmt22.traerRs(xsql5);
                                if (rs22.next()) {
                                    rs22.beforeFirst();
                                    int y2 = 0;
                                    while (rs22.next()) {
                                        DefaultMutableTreeNode genericosy2 = new DefaultMutableTreeNode(rs22.getString(2));
                                        this.modelo.insertNodeInto(genericosy2, genericosj, y2);
                                        y2++;
                                    }
                                }
                                rs22.close();
                                xmt22.cerrarConexionBd();
                                j2++;
                            }
                        }
                        mCrearHExamenFisico(xtiposex, 0);
                        rs12.close();
                        xmt12.cerrarConexionBd();
                    } else if (rs.getInt(3) == 4) {
                        ConsultasMySQL xmt13 = new ConsultasMySQL();
                        xmt13.ejecutarSQL("DROP TABLE IF EXISTS z_t_tmp");
                        xmt13.cerrarConexionBd();
                        String xsql6 = "CREATE TABLE  `z_t_tmp`  AS SELECT `h_tipoayudadx`.`Nbre` FROM `h_resultadoayudasdx` INNER JOIN  `h_tipoayudadx`  ON (`h_resultadoayudasdx`.`Id_TipoAyudaDX` = `h_tipoayudadx`.`Id`) WHERE (`h_resultadoayudasdx`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY `h_tipoayudadx`.`Id` ORDER BY `h_tipoayudadx`.`Nbre` ASC ";
                        xmt13.ejecutarSQL(xsql6);
                        xmt13.cerrarConexionBd();
                        String xsql7 = "insert into z_t_tmp (Nbre) SELECT 'Laboratorio Sistematizado' as Nbre FROM `l_detallerecepcion` INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_recepcion`.`Id_Paciente` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY `l_recepcion`.`Id_Paciente`";
                        xmt13.ejecutarSQL(xsql7);
                        xmt13.cerrarConexionBd();
                        String xsql8 = "insert into z_t_tmp (Nbre) SELECT 'RX Odontología'\nFROM `o_hc_tratamiento_procedimiento` INNER JOIN `o_hc_tratamiento` ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)\n    INNER JOIN `g_procedimiento`  ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `h_atencion`  ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `o_proced_x_grupo`  ON (`o_proced_x_grupo`.`IdProcedimiento` = `g_procedimiento`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `o_proced_x_grupo`.`IdGrupo` =5) GROUP BY `ingreso`.`Id_Usuario`";
                        xmt13.ejecutarSQL(xsql8);
                        xmt13.cerrarConexionBd();
                        String xsql9 = "insert into z_t_tmp (Nbre) SELECT 'Radiología Sistematizadas' AS `Nbre`  FROM  `f_ordenes` INNER JOIN `h_radiologia`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_radiologia.`Url_Estudio`<>'' ) GROUP BY `ingreso`.`Id_Usuario`";
                        xmt13.ejecutarSQL(xsql9);
                        xmt13.cerrarConexionBd();
                        ResultSet rs13 = xmt13.traerRs("SELECT Nbre  FROM z_t_tmp ORDER BY Nbre ASC");
                        if (rs13.next()) {
                            rs13.beforeFirst();
                            int j3 = 0;
                            while (rs13.next()) {
                                this.modelo.insertNodeInto(new DefaultMutableTreeNode(rs13.getString(1)), this.genericosg, j3);
                                j3++;
                            }
                        }
                        rs13.close();
                        xmt13.cerrarConexionBd();
                    }
                    x++;
                }
            }
            rs.close();
            xmt.cerrarConexionBd();
            this.JTAtencion.setModel(this.modelo);
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getExpandirHistoria().booleanValue()) {
                mExpandAll(this.JTAtencion, true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mMostrarPanel(JPanel formulario) {
        mLimpiarPanel();
        formulario.setBounds(5, 5, 860, 750);
        this.JPIDetalleAtencion.add(formulario);
        this.JPIDetalleAtencion.setVisible(true);
    }

    public void mMostrarPanel4(JPanel formulario) {
        mLimpiarPanel();
        formulario.setBounds(5, 10, 860, 580);
        this.JPIDetalleAtencion.add(formulario);
        this.JPIDetalleAtencion.setVisible(true);
    }

    public void mMostrarPanel1(JPanel formulario) {
        mLimpiarPanel();
        formulario.setBounds(5, 5, 860, 750);
        this.JPIDetalleAtencion.add(formulario);
        this.JPIDetalleAtencion.setVisible(true);
    }

    public void mMostrarPanel2(JPanel formulario) {
        mLimpiarPanel();
        formulario.setBounds(5, 10, 839, 600);
        this.JPIDetalleAtencion.add(formulario);
        this.JPIDetalleAtencion.setVisible(true);
    }

    public void mLimpiarPanel() {
        this.JPIDetalleAtencion.setVisible(false);
        this.JPIDetalleAtencion.removeAll();
        this.JPIDetalleAtencion.setVisible(true);
    }

    private void mCrearRevisionSistemas() {
        try {
            Metodos xmtc = new Metodos();
            ConsultasMySQL xmtc1 = new ConsultasMySQL();
            String xsql = "SELECT h_tiposistemas.Id, h_tiposistemas.Nbre FROM h_tiposistemas INNER JOIN h_gruposistemas   ON (h_tiposistemas.Id_GrupoSistemas = h_gruposistemas.Id) INNER JOIN h_csistemaxtipohc  ON (h_csistemaxtipohc.Id_TipoSistema = h_tiposistemas.Id)  WHERE (h_csistemaxtipohc.Id_TipoHc ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "' AND h_tiposistemas.Estado =0) ";
            String sqlz = "SELECT Id FROM h_revisionsistemas WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet xrsm = xmtc1.traerRs(sqlz);
            if (!xrsm.next()) {
                this.sql = "insert into h_revisionsistemas ( Id_Atencion, Fecha, UsuarioS) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + xmtc.formatoAMDH24.format(xmtc.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xidrevision = xmtc1.ejecutarSQLId(this.sql);
                ConsultasMySQL xmtc2 = new ConsultasMySQL();
                ResultSet xrsm1 = xmtc2.traerRs(xsql);
                if (xrsm1.next()) {
                    xrsm1.beforeFirst();
                    while (xrsm1.next()) {
                        ConsultasMySQL xmtc3 = new ConsultasMySQL();
                        String sqlm = "insert into h_detallerevisionsistemas (Id_RevisionSistemas, Id_TipoSistemas, Valor, Descripcion) values ('" + xidrevision + "','" + xrsm1.getInt(1) + "','0','NO REFIERE')";
                        xmtc3.ejecutarSQL(sqlm);
                        xmtc3.cerrarConexionBd();
                    }
                }
                xrsm1.close();
                xmtc2.cerrarConexionBd();
            }
            xrsm.close();
            xmtc1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearHExamenFisico(int xtiposexo, int x) {
        try {
            Metodos xmt = new Metodos();
            ConsultasMySQL xmtc = new ConsultasMySQL();
            ConsultasMySQL xmtc1 = new ConsultasMySQL();
            String sqlz = "SELECT Id FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet xrsm = xmtc.traerRs(sqlz);
            if (!xrsm.next()) {
                this.sql = "INSERT INTO h_examenfisico(Id_Atencion, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA, FCardiaca, FRespiratoria, Talla, Peso, IMC, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, Fecha, UsuarioS) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','0','0','0','0','0','0','0','0','0','0','0','0','','0','0','0','0','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xidexamenfisico = xmtc1.ejecutarSQLId(this.sql);
                xmtc1.cerrarConexionBd();
                mCrearDatosExamenFisico(xidexamenfisico, xtiposexo);
            } else {
                mCrearDatosExamenFisico(xrsm.getString(1), xtiposexo);
            }
            xrsm.close();
            xmtc.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearDatosExamenFisico(String Id, int xtipos) {
        String xsql;
        try {
            ConsultasMySQL xmtc = new ConsultasMySQL();
            ResultSet xrs3 = xmtc.traerRs("SELECT Id_ExamenFisico FROM h_detalleexamenfisico WHERE (Id_ExamenFisico ='" + Id + "')");
            if (!xrs3.next()) {
                ConsultasMySQL xmtc2 = new ConsultasMySQL();
                if (xtipos == 0) {
                    xsql = "SELECT h_tipoexamenfisico.Id, h_tipoexamenfisico.Nbre FROM h_cdetalleexamenfisicoxtipohc INNER JOIN h_tipoexamenfisico  ON (h_cdetalleexamenfisicoxtipohc.Id_Tipoexamenfisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) WHERE (h_tipoexamenfisico.Estado =0  AND h_cdetalleexamenfisicoxtipohc.Id_tipoHc ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "' AND h_grupoexamenfisico.FiltroSexo='" + xtipos + "' )";
                } else {
                    xsql = "SELECT h_tipoexamenfisico.Id, h_tipoexamenfisico.Nbre FROM h_cdetalleexamenfisicoxtipohc INNER JOIN h_tipoexamenfisico  ON (h_cdetalleexamenfisicoxtipohc.Id_Tipoexamenfisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) WHERE (h_tipoexamenfisico.Estado =0  AND h_cdetalleexamenfisicoxtipohc.Id_tipoHc ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc() + "' )";
                }
                ResultSet xrsm1 = xmtc2.traerRs(xsql);
                if (xrsm1.next()) {
                    xrsm1.beforeFirst();
                    while (xrsm1.next()) {
                        ConsultasMySQL xmtc3 = new ConsultasMySQL();
                        String sqlm = "insert into  h_detalleexamenfisico (Id_ExamenFisico, Id_TipoExamenFisico, Valor, Descripcion) values ('" + Id + "','" + xrsm1.getInt(1) + "','2','SIN HALLAZGOS')";
                        xmtc3.ejecutarSQL(sqlm);
                        xmtc3.cerrarConexionBd();
                    }
                }
                xrsm1.close();
                xmtc2.cerrarConexionBd();
            }
            xrs3.close();
            xmtc.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void atencionCrecimientoyDesarrollo() {
        mAtencionGeneral();
        this.modelo.insertNodeInto(this.pyp, this.atencion, 7);
        this.modelo.insertNodeInto(this.CyD, this.pyp, 0);
        this.modelo.insertNodeInto(this.Vacunacion, this.pyp, 1);
        this.modelo.insertNodeInto(this.alm, this.CyD, 0);
        this.modelo.insertNodeInto(this.mg, this.CyD, 1);
        this.modelo.insertNodeInto(this.mf, this.CyD, 2);
        this.modelo.insertNodeInto(this.al, this.CyD, 3);
        this.modelo.insertNodeInto(this.ps, this.CyD, 4);
        this.modelo.insertNodeInto(this.res, this.CyD, 5);
        mDatosRevisionSistema();
        mDatosExamenFisico();
        mAntecedentes();
        mCargarAyudasDx();
        mCargarGuias();
        this.JTAtencion.setModel(this.modelo);
    }

    private void mGuardadoGeneralPaciente() {
    }

    private void mGuardadoAtencion(int x1, int x2, int x3) {
    }

    private void mGuardarRevisionSistema() {
    }

    private void mGuardarDatosNutricion() {
    }

    private void mGuardarExamenFisico() {
    }

    private void mGuardarRevisionExamen() {
    }

    private void mGuardarPanelesAdicionales() {
    }

    public void mguardarH(int x1, int x2, int x3) {
    }

    public void mguardar() {
    }

    private void mCargarDatosHc() {
    }

    public void mGuardarHcEnfermeria(int xidpro, String xidusuario) {
    }

    public static void expandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    private static void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    private void mCerrarJIFHc() {
    }

    private boolean mEstadoHc() {
        return false;
    }

    public void mBuscarIngresoCCita() {
    }

    public void mBuscarAtencionIngreso(int idingreso) {
    }

    private void mAtencionEspecialista() {
        DefaultMutableTreeNode interconsulta = new DefaultMutableTreeNode("InterConsulta");
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        this.modelo.insertNodeInto(this.notas, this.usuario, 1);
        this.modelo.insertNodeInto(this.guiasm, this.usuario, 2);
        this.modelo.insertNodeInto(interconsulta, this.atencion, 0);
        this.modelo.insertNodeInto(this.motivoconsulta, this.atencion, 1);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 2);
        this.modelo.insertNodeInto(this.examenfatencion, this.atencion, 3);
        this.modelo.insertNodeInto(this.hallexamenfatencion, this.atencion, 4);
        this.modelo.insertNodeInto(this.examenes, this.atencion, 5);
        this.modelo.insertNodeInto(this.ordenes, this.atencion, 6);
        this.modelo.insertNodeInto(this.otros, this.atencion, 7);
        this.modelo.insertNodeInto(this.conclusion, this.atencion, 8);
        this.modelo.insertNodeInto(this.notasn, this.notas, 0);
        mDatosExamenFisico();
        mAntecedentes();
        mOrdenes();
        mCargarAyudasDx();
        mCargarGuias();
        this.JTAtencion.setModel(this.modelo);
    }

    private void mAtencionGeneral() {
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        if (this.xtipohc != 9) {
            this.modelo.insertNodeInto(this.ordenes, this.usuario, 1);
            this.modelo.insertNodeInto(this.otros, this.usuario, 2);
            this.modelo.insertNodeInto(this.notas, this.usuario, 3);
            this.modelo.insertNodeInto(this.guiasm, this.usuario, 4);
            this.modelo.insertNodeInto(this.fomentos, this.usuario, 5);
        } else {
            this.modelo.insertNodeInto(this.notas, this.usuario, 1);
            this.modelo.insertNodeInto(this.guiasm, this.usuario, 2);
            this.modelo.insertNodeInto(this.fomentos, this.usuario, 3);
        }
        this.modelo.insertNodeInto(this.motivoconsulta, this.atencion, 0);
        this.modelo.insertNodeInto(this.revisionsistema, this.atencion, 1);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 2);
        this.modelo.insertNodeInto(this.examenfatencion, this.atencion, 3);
        this.modelo.insertNodeInto(this.hallexamenfatencion, this.atencion, 4);
        this.modelo.insertNodeInto(this.examenes, this.atencion, 5);
        this.modelo.insertNodeInto(this.conclusion, this.atencion, 6);
        this.modelo.insertNodeInto(this.notasn, this.notas, 0);
        this.modelo.insertNodeInto(this.fomentoAct, this.fomentos, 0);
    }

    private void mAtencionControlPrenatal() {
        mAtencionGeneral();
        this.modelo.insertNodeInto(this.pyp, this.atencion, 7);
        this.modelo.insertNodeInto(this.riesgopsicosocial, this.pyp, 0);
        this.modelo.insertNodeInto(this.escalariesgocp, this.pyp, 1);
        mDatosRevisionSistema();
        mDatosExamenFisico();
        mAntecedentes();
        mOrdenes();
        mCargarAyudasDx();
        mCargarGuias();
        this.JTAtencion.setModel(this.modelo);
    }

    private void mAtencionMedicinaGeneral() {
        mAtencionGeneral();
        this.modelo.insertNodeInto(this.filtraciong, this.atencion, 7);
        this.modelo.insertNodeInto(this.citascontrol, this.atencion, 8);
        mDatosRevisionSistema();
        mDatosExamenFisico();
        mAntecedentes();
        mCargarAyudasDx();
        mOrdenes();
        mCargarGuias();
        this.JTAtencion.setModel(this.modelo);
    }

    private void mAtencionMGeneralRevision() {
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        this.modelo.insertNodeInto(this.otros, this.usuario, 1);
        this.modelo.insertNodeInto(this.notas, this.usuario, 2);
        this.modelo.insertNodeInto(this.guiasm, this.usuario, 3);
        this.modelo.insertNodeInto(this.motivoconsulta, this.atencion, 0);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 1);
        this.modelo.insertNodeInto(this.examenes, this.atencion, 2);
        this.modelo.insertNodeInto(this.ordenes, this.atencion, 3);
        this.modelo.insertNodeInto(this.conclusion, this.atencion, 4);
        this.modelo.insertNodeInto(this.filtraciong, this.atencion, 5);
        this.modelo.insertNodeInto(this.notasn, this.notas, 0);
        mAntecedentes();
        mOrdenes();
        mCargarAyudasDx();
        mCargarGuias();
        this.JTAtencion.setModel(this.modelo);
    }

    private void mDatosRevisionSistema() {
    }

    private void mDatosExamenFisico() {
    }

    private void mAntecedentes() {
    }

    private void mOrdenes() {
        for (int j = 0; j < this.ordenesmed.length; j++) {
            this.genericosg = new DefaultMutableTreeNode(this.ordenesmed[j]);
            this.modelo.insertNodeInto(this.genericosg, this.ordenes, j);
        }
        for (int j2 = 0; j2 < this.otrasordenes.length; j2++) {
            this.genericosg = new DefaultMutableTreeNode(this.otrasordenes[j2]);
            this.modelo.insertNodeInto(this.genericosg, this.otros, j2);
        }
    }

    private void mCargarGuias() {
    }

    private void mCargarAyudasDx() {
    }

    private void mAtencionNutricion() {
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        this.modelo.insertNodeInto(this.motivoconsulta, this.atencion, 0);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 1);
        this.modelo.insertNodeInto(this.cnutricion, this.atencion, 2);
        this.modelo.insertNodeInto(this.ordenes, this.atencion, 3);
        this.modelo.insertNodeInto(this.conclusion, this.atencion, 4);
        int n = 0;
        for (int j = 0; j < this.antec.length; j++) {
            if (this.antec[j].equals("Ginecologicos")) {
                if (this.xsexo.equals("F")) {
                    this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                    this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                    n++;
                }
            } else {
                this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                n++;
            }
        }
        DefaultMutableTreeNode interconsulta = new DefaultMutableTreeNode("InterConsulta");
        this.modelo.insertNodeInto(interconsulta, this.ordenes, 0);
        DefaultMutableTreeNode laboratorio = new DefaultMutableTreeNode("Laboratorio");
        this.modelo.insertNodeInto(laboratorio, this.ordenes, 1);
        this.JTAtencion.setModel(this.modelo);
        mExpandAll(this.JTAtencion, true);
    }

    private void mAtencionPsicologia() {
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        this.modelo.insertNodeInto(this.motivoconsulta, this.atencion, 0);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 1);
        this.modelo.insertNodeInto(this.ordenes, this.atencion, 2);
        this.modelo.insertNodeInto(this.conclusion, this.atencion, 3);
        int n = 0;
        for (int j = 0; j < this.antec.length; j++) {
            if (this.antec[j].equals("Ginecologicos")) {
                if (this.xsexo.equals("F")) {
                    this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                    this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                    n++;
                }
            } else {
                this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                n++;
            }
        }
        DefaultMutableTreeNode interconsulta = new DefaultMutableTreeNode("InterConsulta");
        this.modelo.insertNodeInto(interconsulta, this.ordenes, 0);
        this.JTAtencion.setModel(this.modelo);
        mExpandAll(this.JTAtencion, true);
    }

    private void mAtencionEnfermeria(int idsexo) {
        this.modelo.insertNodeInto(this.atencion, this.usuario, 0);
        this.modelo.insertNodeInto(this.antecedentes, this.atencion, 0);
        this.modelo.insertNodeInto(this.notas, this.usuario, 1);
        this.modelo.insertNodeInto(this.notasn, this.notas, 0);
        int n = 0;
        for (int j = 0; j < this.antec.length; j++) {
            if (this.antec[j].equals("Ginecologicos")) {
                if (idsexo == 2) {
                    this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                    this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                    n++;
                }
            } else {
                this.genericosg = new DefaultMutableTreeNode(this.antec[j]);
                this.modelo.insertNodeInto(this.genericosg, this.antecedentes, n);
                n++;
            }
        }
        this.JTAtencion.setModel(this.modelo);
        mExpandAll(this.JTAtencion, true);
    }

    public boolean isxValidado() {
        return this.xValidado;
    }

    public void setxValidado(boolean xValidado) {
        this.xValidado = xValidado;
    }

    public static void mExpandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        mExpandAll(tree, new TreePath(root), expand);
    }

    private static void mExpandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                mExpandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    public void mImprimirHc() {
    }

    public void mCambiarEstadoCita() {
        if (this.xidtc == 0) {
            this.sql = "Update c_citas set Asistida=3 where id='" + this.xidcita + "'";
        } else {
            this.sql = "Update c_citasnp set Asistida=3 where id='" + this.xidcita + "'";
        }
    }

    private void mTraerDatosExamenFisicoHc() {
    }

    private void mConsultarALerta() {
        String xsql = "SELECT g_tipoalerta.Nbre, g_usuarioxtipoalerta.Detalle FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) WHERE (g_usuarioxtipoalerta.Estado =1 AND g_tipoalerta.EsHC =1 AND g_usuarioxtipoalerta.Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY g_tipoalerta.Nbre ASC ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                String xmensaje = "";
                xrs.beforeFirst();
                while (xrs.next()) {
                    xmensaje = xmensaje + "TIPO DE MENSAJE: " + xrs.getString(1) + "\nINFORMACIÓN:" + xrs.getString(2).toUpperCase() + "\n";
                }
                JOptionPane.showMessageDialog((Component) null, xmensaje, "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JPIPacPrograma.setBackground(Color.YELLOW);
                this.JBTAlerta.setVisible(true);
            } else {
                this.JBTAlerta.setVisible(false);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosPersona() {
        String xsql = "SELECT `FechaNac` FROM `g_persona` WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(xrs.getString("FechaNac"));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarDatosUsuarioFPZ() {
        String xsql = "SELECT Id_Parentesco, Id_Empresa FROM g_usuario_fpz WHERE (Id_Persona ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdParentesco(Integer.valueOf(xrs.getInt(1)));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoEmpresa(Integer.valueOf(xrs.getInt(2)));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarDatosEmailUsuarioFPZ() {
        String xsql = "SELECT `h_atencion`.`Id_Ingreso`, `persona`.`Corre` AS `Correo_Usuario` , `persona_1`.`Corre` AS `Correo_Supervisor` FROM  `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `persona` AS `persona_1` ON (`g_usuario`.`Id_Supervisor` = `persona_1`.`Id_persona`) WHERE (`h_atencion`.`Id_Ingreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
        System.out.println(xsql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailUsuario(xrs.getString(2));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailsupervisor(xrs.getString(3));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarId_ManPower() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() != 0) {
            String xsql = "SELECT `so_manporwer_detalle`.`Id` FROM `so_manporwer_detalle` INNER JOIN  `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) WHERE (`so_manporwer_encabezado`.`Activa` =1 AND `so_manporwer_encabezado`.`Estado` =1 AND `so_manporwer_detalle`.`Id_Persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ";
            ConsultasMySQL ct1 = new ConsultasMySQL();
            ResultSet xrs = ct1.traerRs(xsql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(Integer.valueOf(xrs.getInt(1)));
                }
                xrs.close();
                ct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mConsultarIdUsuarioPrograma() {
        String xsql = "SELECT `Id` FROM `g_usuarioxprograma` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "' AND `Estado` =0 AND FechaEgreso IS NULL) ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(xrs.getLong(1)));
            } else {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(new Long(0L));
            }
            xrs.close();
            xct.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue() == 3) {
                String sql = "UPDATE h_atencion SET IdUsuarioPrograma='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' WHERE Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarNConsultas() {
        String xsql;
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("382")) {
            xsql = "SELECT COUNT(h_atencion.Id) FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Estado=0 and  DATE_FORMAT(h_atencion.Fecha_Atencion,'%m-%Y')='" + this.xmetodos.formatoMesAno.format(this.xmetodos.getFechaActual()) + "' AND ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_atencion.Id_Especialidad =382 AND h_atencion.Codigo_Dxp <>'') GROUP BY ingreso.Id_Usuario HAVING (COUNT(h_atencion.Id) >=3) ORDER BY COUNT(h_atencion.Id) DESC ";
        } else {
            xsql = "SELECT  COUNT(h_atencion.Id) FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Estado=0 and DATE_FORMAT(h_atencion.Fecha_Atencion,'%Y')='" + this.xmetodos.formatoANO.format(this.xmetodos.getFechaActual()) + "'  AND ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_atencion.Id_Especialidad ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND h_atencion.Codigo_Dxp <>'') GROUP BY ingreso.Id_Usuario HAVING (COUNT(h_atencion.Id) >=3) ORDER BY COUNT(h_atencion.Id) DESC    ";
        }
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                String xmensaje = "";
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("382")) {
                        xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4> ESTA ES LA CONSULTA N°" + xrs.getString(1) + " EN EL MES DE ESTE USUARIO";
                    } else {
                        xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>ESTA ES LA CONSULTA N° " + xrs.getString(1) + " EN EL AÑO DE ESTE USUARIO CON SU ESPECIALIDAD";
                    }
                }
                JOptionPane.showMessageDialog((Component) null, xmensaje, "ALERTA N° CONSULTAS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarHNutricional() {
        String xsql = "SELECT ingreso.Id_Usuario FROM h_nutricional INNER JOIN h_atencion  ON (h_nutricional.Id_Atencion = h_atencion.Id)  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY ingreso.Id_Usuario ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                this.JBTHCNutricional.setVisible(true);
            } else {
                this.JBTHCNutricional.setVisible(false);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultar_Crear_Tratamiento_Odontologia() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsOdontologica().intValue() == 1 && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento().longValue() == 0) {
            this.sql = "insert into o_hc_tratamiento (`Id_Atencion`, `FInicio`, `Id_Profesional`, `Id_Especialidad`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(this.xct.ejecutarSQLId(this.sql)));
            this.xct.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoCita().intValue() == 0) {
                this.sql = "update c_citas set `Id_TratamientoO`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'";
            } else {
                this.sql = "update c_citasnp set `Id_TratamientoO`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'";
            }
            this.xct.ejecutarSQL(this.sql);
            this.xct.cerrarConexionBd();
        }
    }
}
