package Odontologia;

import General.JIFBuscarPatologia;
import General.Persona;
import Historia.JPAAPatologiasAsociadas;
import Historia.JPAAntecedenteGineco;
import Historia.JPAAntecedentesPediatricos;
import Historia.JPAAntecentesFamiliares;
import Historia.JPAAntecentesHabitos;
import Historia.JPAAntecentesPPersonales;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JIFHistoriaOdontologica.class */
public class JIFHistoriaOdontologica extends JInternalFrame {
    public Persona xjppersona;
    public JPAAntecentesFamiliares xjpafamiliares;
    public JPAAntecentesHabitos xjphabitos;
    public JPAAPatologiasAsociadas xjppasociadas;
    public JPAAntecentesPPersonales xjpapersonales;
    private JPAAntecentesOdontologicos xjpaodontologicos;
    private JPHcDental xjphcdental;
    private JPAAntecedentesPediatricos xjpainfancia;
    private JPAAntecedenteGineco xjpaginecoobstetricos;
    private claseOdonto xclaseo1;
    private DefaultTableModel xmodelo0;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelodetalletto;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private String xsql;
    private String[] x1edolor;
    private String[] x2eintensidad;
    private String[] xefrecuencia;
    private String[] x3ecaries;
    private String[] x4etipocaries;
    private String[] x5eccolor;
    private String[] x6ecolor;
    private String[] x7fverticar;
    private String[] x8fradicular;
    private String[] x9ftipo1;
    private String[] x10fhorizontal;
    private String[] x11fcoronal;
    private String[] x12fipo2;
    private String[] x13aintraoral;
    private String[] x14atipo1;
    private String[] x15aextraoral;
    private String[] x16atipo2;
    private String[] x17aretauracion;
    private String[] x18atipo;
    private String[] x19aestado;
    private String[] x20abifurcacion;
    private String[] x21atipo;
    private String[] x22afisura;
    private String[] x23aexamenpulpar;
    private String[] x24pffrio;
    private String[] x25pfcalor;
    private String[] x26pfvitalometro;
    private String[] x27pfmovilidad;
    private String[] x28pfgrado;
    private String[] x29pftestcavitario;
    private String[] x30pvertical;
    private String[] x31ptipo;
    private String[] x32pgrado;
    private String[] x33phorizontal;
    private String[] x34ptipo;
    private String[] x35pgrado;
    private String[] x36ttraumasant;
    private String[] x37thgdolocabeza;
    private String[] x38thgconciencia;
    private String[] x39thgnauseas;
    private String[] x40thiespontaneo;
    private String[] x41thifrio;
    private String[] x42thipercusion;
    private String[] x43thiexposicionpulpar;
    private String[] x44thicolorocioncorona;
    private String[] x45thimovdentaria;
    private String[] x46thimbucal;
    private String[] x47thillabial;
    private String[] x48iddiagnostico;
    private String[] x49idrespuestadx;
    private String[] x50hrformacionrad;
    private String[] x51hrfracradicular;
    private String[] x52hrlesionapical;
    private String[] x53hrcavidadpulpar;
    private String[] x54hrreabsoricionrad;
    private String[] x55hrtiporeabsorcionrad;
    private String[] x56hrmembranaperio;
    private String[] x57hralveolooseo;
    private String[] x58rseco;
    private String[] x59ragua;
    private String[] x60rsaliva;
    private String[] x61rleche;
    private String[] x62ftipodx;
    private String[] xidtipodx;
    private String[] xidservicio;
    private String[] xidprocedimiento;
    private String[] xidtipodx1;
    private JButton JBTAdicionar;
    private JButton JBTAdicionarAntCli;
    private JButton JBTAdicionarDx;
    private JComboBox JCBAExtraoral;
    private JComboBox JCBAIntraoral;
    private JComboBox JCBATipo;
    private JComboBox JCBATipo1;
    private JComboBox JCBBirfulcacion;
    private JComboBox JCBCColor;
    private JComboBox JCBCColoracionCorona;
    private JComboBox JCBCalorPC;
    private JComboBox JCBCaries;
    private JComboBox JCBCariesTipo;
    private JComboBox JCBColor;
    private JComboBox JCBDAAgua;
    private JComboBox JCBDALeche;
    private JComboBox JCBDASaliva;
    private JComboBox JCBDASeco;
    private JComboBox JCBDDiagnostico;
    private JComboBox JCBDEspontaneo;
    private JComboBox JCBDExposicionP;
    private JComboBox JCBDFrecuencia;
    private JComboBox JCBDFrio;
    private JComboBox JCBDIntensidad;
    private JComboBox JCBDPercusion;
    private JComboBox JCBDiagnostico;
    private JComboBox JCBDolor;
    private JComboBox JCBDxRespuesta;
    private JComboBox JCBEPulpar;
    private JComboBox JCBFCoronal;
    private JComboBox JCBFHorizontal;
    private JComboBox JCBFRadicular;
    private JComboBox JCBFTipo;
    private JComboBox JCBFTipo1;
    private JComboBox JCBFVertical;
    private JComboBox JCBFisura;
    private JComboBox JCBFrio;
    private JComboBox JCBHRCavidadPul;
    private JComboBox JCBHREstMembranaPerio;
    private JComboBox JCBHRFracturaAlveolo;
    private JComboBox JCBHRFracturaRadicular;
    private JComboBox JCBHRFradicular;
    private JComboBox JCBHRLesionApical;
    private JComboBox JCBHRTipoReabsRadicular;
    private JComboBox JCBHRreabsRadicular;
    private JComboBox JCBLLabial;
    private JComboBox JCBMBucal;
    private JComboBox JCBMovDentaria;
    private JComboBox JCBMovGrado;
    private JComboBox JCBMovTesCav;
    private JComboBox JCBMovilidad;
    private JComboBox JCBPGradoH;
    private JComboBox JCBPGradoV;
    private JComboBox JCBPHorizontal;
    private JComboBox JCBPTipoH;
    private JComboBox JCBPTipoV;
    private JComboBox JCBPVertical;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBRestauracion;
    public JComboBox JCBRestauracionEstado;
    private JComboBox JCBRestauracionTipo;
    private JComboBox JCBTConciencia;
    private JComboBox JCBTDolorCabeza;
    private JComboBox JCBTNauseas;
    private JComboBox JCBTipoDx;
    private JComboBox JCBTipoDx1;
    private JComboBox JCBTipoServicio;
    private JComboBox JCBTraumasAnt;
    private JDateChooser JDCFechaFTto;
    private JDateChooser JDCFechaITto;
    private JDateChooser JDCFechaITto1;
    public JDateChooser JDFFechaTrauma;
    public JDateChooser JDFFechaTrauma1;
    private JLabel JLBTDxRelacionados;
    private JPanel JPIAFamiliares;
    private JPanel JPIAGinecoObst;
    private JPanel JPIAInfancia;
    private JPanel JPIAPersonales;
    private JPanel JPIAbsceso;
    private JPanel JPIDAAntecedentes;
    private JPanel JPIDDAResguardado;
    private JPanel JPIDEPrimera;
    private JPanel JPIDEvolucion;

    /* JADX INFO: renamed from: JPIDHIDaño, reason: contains not printable characters */
    private JPanel f15JPIDHIDao;
    private JPanel JPIDHIDientesInv;
    private JPanel JPIDHIDolor;
    private JPanel JPIDHistoriaDental;
    private JPanel JPIDatosAt;
    private JPanel JPIDatosCDienteAvul;
    private JPanel JPIDatosEndodoncia;
    private JPanel JPIDatosHGenerales;
    private JPanel JPIDatosHIntrahorales;
    private JPanel JPIDatosHRadirograficos;
    private JPanel JPIDatosTto;
    private JPanel JPIDatosU;
    private JPanel JPIDiagnostico;
    private JPanel JPIDiagnosticoT;
    private JPanel JPIDxConclusion;
    private JPanel JPIESegunda;
    private JPanel JPIEndExamenC;
    private JPanel JPIEvolucion;
    private JPanel JPIExRadiografico;
    private JPanel JPIExamen;
    private JPanel JPIFractura;
    private JPanel JPIHabitos;
    private JPanel JPIMotivoC;
    private JPanel JPIPAsociadas;
    private JPanel JPIPClinicas;
    private JPanel JPIPercusion;
    private JPanel JPITDatos;
    private JPanel JPITratamiento;
    private JPanel JPITrauma;
    private JScrollPane JPSMotivoC;
    private JScrollPane JSPDAPlanTrato;
    private JScrollPane JSPDetalleTto;
    private JScrollPane JSPHistorialDx;
    private JScrollPane JSPHistorialDx1;
    private JSpinner JSPNCitas;
    private JSpinner JSPNDiente;
    private JScrollPane JSPObsCalorPC;
    private JScrollPane JSPObsCarie;
    private JScrollPane JSPObsCausasTrauma;
    private JScrollPane JSPObsColor;
    private JScrollPane JSPObsExRadiografico;
    private JScrollPane JSPObsFrio;
    private JScrollPane JSPObsGeneral;
    private JScrollPane JSPObsPclinica;
    private JScrollPane JSPTDiagnostico;
    private JTable JTBTDiagnostico;
    private JTable JTDetalleTto;
    public JTextField JTFCDxP;
    public JTextField JTFCDxP1;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    private JTextField JTFCamaraPulpar;
    private JTextField JTFConductos;
    private JTextField JTFCorona;
    private JTextField JTFDAFCabidadB;
    private JTextField JTFDOtros;
    private JTextField JTFDPermanentes;
    private JTextField JTFDTemporales;
    private JTextField JTFDientesInv;
    private JTextField JTFEPulparObserv;
    private JTextField JTFFisuraUbicacion;
    private JTextField JTFHRForamenApical;
    private JTextField JTFLaminaDura;
    private JTextField JTFLugar;
    private JTextField JTFNCodigoDxP;
    private JTextField JTFNCodigoDxP1;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    private JTextField JTFPElectricaV;
    private JTextField JTFPeriapice;
    private JTextField JTFRaiz;
    private JTable JTHistorialDx;
    private JTable JTHistorialDx1;
    private JTextPane JTPDAPlanTrato;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosAtencion;
    private JTabbedPane JTPDetalleAnt;
    private JTabbedPane JTPEndodoncia;
    private JTabbedPane JTPHallagoz;
    private JTextPane JTPMotivoC;
    private JTextPane JTPObsCalorPC;
    private JTextPane JTPObsCarie;
    private JTextPane JTPObsColor;
    private JTextPane JTPObsExRadiografico;
    private JTextPane JTPObsExRadiografico1;
    private JTextPane JTPObsFrio;
    private JTextPane JTPObsGeneral;
    private JTextPane JTPObsGeneral1;
    private JTabbedPane JTPPlanificador;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xmod = -1;
    private int xnfilamodelo0 = 0;
    private int xnfilamodelo1 = 0;
    private int xnfilamodelodetalletto = 0;
    private boolean xlleno = false;

    public JIFHistoriaOdontologica(claseOdonto xclaseo1) {
        initComponents();
        this.xclaseo1 = xclaseo1;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v135, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v442, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v474, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v755, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosU = new JPanel();
        this.JTPDatosAtencion = new JTabbedPane();
        this.JPIDatosAt = new JPanel();
        this.JTPPlanificador = new JTabbedPane();
        this.JPIMotivoC = new JPanel();
        this.JPSMotivoC = new JScrollPane();
        this.JTPMotivoC = new JTextPane();
        this.JPIDxConclusion = new JPanel();
        this.JTFNCodigoDxP = new JTextField();
        this.JTFCDxP = new JTextField();
        this.JCBTipoDx = new JComboBox();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JLBTDxRelacionados = new JLabel();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JPITratamiento = new JPanel();
        this.JPIDatosTto = new JPanel();
        this.JCBTipoServicio = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JSPNDiente = new JSpinner();
        this.JSPNCitas = new JSpinner();
        this.JTFCDxP1 = new JTextField();
        this.JTFNCodigoDxP1 = new JTextField();
        this.JCBTipoDx1 = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.JSPDetalleTto = new JScrollPane();
        this.JTDetalleTto = new JTable();
        this.JPIEvolucion = new JPanel();
        this.JPIDEvolucion = new JPanel();
        this.JDCFechaITto1 = new JDateChooser();
        this.JDCFechaITto = new JDateChooser();
        this.JDCFechaFTto = new JDateChooser();
        this.JPIDAAntecedentes = new JPanel();
        this.JTPDetalleAnt = new JTabbedPane();
        this.JPIAFamiliares = new JPanel();
        this.JPIHabitos = new JPanel();
        this.JPIPAsociadas = new JPanel();
        this.JPIAPersonales = new JPanel();
        this.JPIAInfancia = new JPanel();
        this.JPIAGinecoObst = new JPanel();
        this.JPIDHistoriaDental = new JPanel();
        this.JPIDatosEndodoncia = new JPanel();
        this.JTPEndodoncia = new JTabbedPane();
        this.JPIEndExamenC = new JPanel();
        this.JTPDatos = new JTabbedPane();
        this.JPIDEPrimera = new JPanel();
        this.JPIExamen = new JPanel();
        this.JCBDolor = new JComboBox();
        this.JCBDIntensidad = new JComboBox();
        this.JCBDFrecuencia = new JComboBox();
        this.JCBCaries = new JComboBox();
        this.JCBCariesTipo = new JComboBox();
        this.JSPObsCarie = new JScrollPane();
        this.JTPObsCarie = new JTextPane();
        this.JCBCColor = new JComboBox();
        this.JCBColor = new JComboBox();
        this.JSPObsColor = new JScrollPane();
        this.JTPObsColor = new JTextPane();
        this.JPIFractura = new JPanel();
        this.JCBFVertical = new JComboBox();
        this.JCBFRadicular = new JComboBox();
        this.JCBFTipo = new JComboBox();
        this.JCBFHorizontal = new JComboBox();
        this.JCBFCoronal = new JComboBox();
        this.JCBFTipo1 = new JComboBox();
        this.JSPObsGeneral = new JScrollPane();
        this.JTPObsGeneral = new JTextPane();
        this.JPIESegunda = new JPanel();
        this.JPIAbsceso = new JPanel();
        this.JCBAIntraoral = new JComboBox();
        this.JCBATipo = new JComboBox();
        this.JCBAExtraoral = new JComboBox();
        this.JCBATipo1 = new JComboBox();
        this.JCBRestauracion = new JComboBox();
        this.JCBRestauracionTipo = new JComboBox();
        this.JCBRestauracionEstado = new JComboBox();
        this.JCBBirfulcacion = new JComboBox();
        this.JCBFisura = new JComboBox();
        this.JTFFisuraUbicacion = new JTextField();
        this.JCBEPulpar = new JComboBox();
        this.JTFEPulparObserv = new JTextField();
        this.JPIPClinicas = new JPanel();
        this.JCBFrio = new JComboBox();
        this.JSPObsFrio = new JScrollPane();
        this.JTPObsFrio = new JTextPane();
        this.JCBCalorPC = new JComboBox();
        this.JSPObsCalorPC = new JScrollPane();
        this.JTPObsCalorPC = new JTextPane();
        this.JPIPercusion = new JPanel();
        this.JCBPVertical = new JComboBox();
        this.JCBPTipoV = new JComboBox();
        this.JCBPGradoV = new JComboBox();
        this.JCBPHorizontal = new JComboBox();
        this.JCBPTipoH = new JComboBox();
        this.JCBPGradoH = new JComboBox();
        this.JSPObsPclinica = new JScrollPane();
        this.JTPObsGeneral1 = new JTextPane();
        this.JCBMovilidad = new JComboBox();
        this.JCBMovGrado = new JComboBox();
        this.JCBMovTesCav = new JComboBox();
        this.JPIExRadiografico = new JPanel();
        this.JTFCorona = new JTextField();
        this.JTFConductos = new JTextField();
        this.JTFCamaraPulpar = new JTextField();
        this.JTFLaminaDura = new JTextField();
        this.JTFRaiz = new JTextField();
        this.JTFPeriapice = new JTextField();
        this.JSPObsExRadiografico = new JScrollPane();
        this.JTPObsExRadiografico = new JTextPane();
        this.JPIDiagnostico = new JPanel();
        this.JSPHistorialDx = new JScrollPane();
        this.JTHistorialDx = new JTable();
        this.JCBDiagnostico = new JComboBox();
        this.JCBDxRespuesta = new JComboBox();
        this.JBTAdicionarAntCli = new JButton();
        this.jPanel1 = new JPanel();
        this.JSPHistorialDx1 = new JScrollPane();
        this.JTHistorialDx1 = new JTable();
        this.jPanel3 = new JPanel();
        this.JDFFechaTrauma1 = new JDateChooser();
        this.JPITrauma = new JPanel();
        this.JPITDatos = new JPanel();
        this.JDFFechaTrauma = new JDateChooser();
        this.JCBTraumasAnt = new JComboBox();
        this.JTFDientesInv = new JTextField();
        this.JTFLugar = new JTextField();
        this.JSPObsCausasTrauma = new JScrollPane();
        this.JTPObsExRadiografico1 = new JTextPane();
        this.JTPHallagoz = new JTabbedPane();
        this.JPIDatosHGenerales = new JPanel();
        this.JCBTDolorCabeza = new JComboBox();
        this.JCBTConciencia = new JComboBox();
        this.JCBTNauseas = new JComboBox();
        this.JPIDatosHIntrahorales = new JPanel();
        this.JPIDHIDientesInv = new JPanel();
        this.JTFDTemporales = new JTextField();
        this.JTFDPermanentes = new JTextField();
        this.JPIDHIDolor = new JPanel();
        this.JCBDEspontaneo = new JComboBox();
        this.JCBDFrio = new JComboBox();
        this.JCBDPercusion = new JComboBox();
        this.JCBDExposicionP = new JComboBox();
        this.JTFPElectricaV = new JTextField();
        this.JCBCColoracionCorona = new JComboBox();
        this.JCBMovDentaria = new JComboBox();
        this.f15JPIDHIDao = new JPanel();
        this.JCBMBucal = new JComboBox();
        this.JCBLLabial = new JComboBox();
        this.JTFDOtros = new JTextField();
        this.JPIDatosHRadirograficos = new JPanel();
        this.JCBHRFradicular = new JComboBox();
        this.JTFHRForamenApical = new JTextField();
        this.JCBHRFracturaRadicular = new JComboBox();
        this.JCBHRLesionApical = new JComboBox();
        this.JCBHRCavidadPul = new JComboBox();
        this.JCBHRreabsRadicular = new JComboBox();
        this.JCBHRTipoReabsRadicular = new JComboBox();
        this.JCBHREstMembranaPerio = new JComboBox();
        this.JCBHRFracturaAlveolo = new JComboBox();
        this.JPIDatosCDienteAvul = new JPanel();
        this.JPIDDAResguardado = new JPanel();
        this.JCBDASeco = new JComboBox();
        this.JCBDAAgua = new JComboBox();
        this.JCBDASaliva = new JComboBox();
        this.JCBDALeche = new JComboBox();
        this.JTFDAFCabidadB = new JTextField();
        this.JSPDAPlanTrato = new JScrollPane();
        this.JTPDAPlanTrato = new JTextPane();
        this.JPIDiagnosticoT = new JPanel();
        this.JCBDDiagnostico = new JComboBox();
        this.JBTAdicionarDx = new JButton();
        this.JSPTDiagnostico = new JScrollPane();
        this.JTBTDiagnostico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORIA CLÍNICA ODONTOLOGÍA");
        setDoubleBuffered(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifhcodontologia");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Odontologia.JIFHistoriaOdontologica.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFHistoriaOdontologica.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
                JIFHistoriaOdontologica.this.formInternalFrameOpened(evt);
            }
        });
        this.JPIDatosU.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO DE USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosU.setPreferredSize(new Dimension(960, 160));
        GroupLayout JPIDatosULayout = new GroupLayout(this.JPIDatosU);
        this.JPIDatosU.setLayout(JPIDatosULayout);
        JPIDatosULayout.setHorizontalGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1054, 32767));
        JPIDatosULayout.setVerticalGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.JTPDatosAtencion.setForeground(Color.red);
        this.JTPDatosAtencion.setTabPlacement(2);
        this.JTPDatosAtencion.setDoubleBuffered(true);
        this.JTPDatosAtencion.setFont(new Font("Arial", 1, 12));
        this.JTPDatosAtencion.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.2
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTPDatosAtencionMouseClicked(evt);
            }
        });
        this.JTPDatosAtencion.addChangeListener(new ChangeListener() { // from class: Odontologia.JIFHistoriaOdontologica.3
            public void stateChanged(ChangeEvent evt) {
                JIFHistoriaOdontologica.this.JTPDatosAtencionStateChanged(evt);
            }
        });
        this.JTPPlanificador.setForeground(Color.blue);
        this.JTPPlanificador.setFont(new Font("Arial", 1, 14));
        this.JPSMotivoC.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPMotivoC.setFont(new Font("Arial", 1, 12));
        this.JTPMotivoC.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.4
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTPMotivoCKeyPressed(evt);
            }
        });
        this.JPSMotivoC.setViewportView(this.JTPMotivoC);
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.5
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.6
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.7
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.8
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.9
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.10
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.11
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.12
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JLBTDxRelacionados.setBackground(new Color(0, 0, 153));
        this.JLBTDxRelacionados.setFont(new Font("Bell MT", 1, 14));
        this.JLBTDxRelacionados.setForeground(new Color(204, 255, 255));
        this.JLBTDxRelacionados.setHorizontalAlignment(0);
        this.JLBTDxRelacionados.setText("Diagnosticos Relacionados");
        this.JLBTDxRelacionados.setBorder(new SoftBevelBorder(0));
        this.JLBTDxRelacionados.setOpaque(true);
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.13
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.14
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.15
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.16
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.17
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.18
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.19
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.20
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFNDxR3KeyPressed(evt);
            }
        });
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -1, 625, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDx, -2, 176, -2)).addComponent(this.JLBTDxRelacionados, GroupLayout.Alignment.TRAILING, -1, 877, 32767).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR3).addComponent(this.JTFCDxR2).addComponent(this.JTFCDxR1, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNDxR3, GroupLayout.Alignment.TRAILING, -1, 820, 32767).addComponent(this.JTFNDxR2, GroupLayout.Alignment.TRAILING, -1, 820, 32767).addComponent(this.JTFNDxR1, -1, 820, 32767)))).addContainerGap()));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 46, -2).addComponent(this.JTFNCodigoDxP, -2, 46, -2).addComponent(this.JCBTipoDx, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBTDxRelacionados, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 25, -2).addComponent(this.JTFCDxR1, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, 25, -2).addComponent(this.JTFCDxR2, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 25, -2).addComponent(this.JTFCDxR3, -2, 25, -2))));
        GroupLayout JPIMotivoCLayout = new GroupLayout(this.JPIMotivoC);
        this.JPIMotivoC.setLayout(JPIMotivoCLayout);
        JPIMotivoCLayout.setHorizontalGroup(JPIMotivoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMotivoCLayout.createSequentialGroup().addContainerGap().addGroup(JPIMotivoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDxConclusion, -1, -1, 32767).addComponent(this.JPSMotivoC, -1, 913, 32767)).addContainerGap()));
        JPIMotivoCLayout.setVerticalGroup(JPIMotivoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMotivoCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPSMotivoC, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDxConclusion, -2, -1, -2).addContainerGap(19, 32767)));
        this.JTPPlanificador.addTab("MOTIVO CONSULTA EA", this.JPIMotivoC);
        this.JPIDatosTto.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoServicio.addItemListener(new ItemListener() { // from class: Odontologia.JIFHistoriaOdontologica.21
            public void itemStateChanged(ItemEvent evt) {
                JIFHistoriaOdontologica.this.JCBTipoServicioItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNDiente.setFont(new Font("Arial", 1, 12));
        this.JSPNDiente.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNDiente.setBorder(BorderFactory.createTitledBorder((Border) null, "Diente N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNCitas.setFont(new Font("Arial", 1, 12));
        this.JSPNCitas.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "Citas N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP1.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.22
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxP1FocusLost(evt);
            }
        });
        this.JTFCDxP1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.23
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFCDxP1KeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCodigoDxP1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.24
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTFNCodigoDxP1MouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.25
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTFNCodigoDxP1KeyPressed(evt);
            }
        });
        this.JCBTipoDx1.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Odontologia.JIFHistoriaOdontologica.26
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaOdontologica.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosTtoLayout = new GroupLayout(this.JPIDatosTto);
        this.JPIDatosTto.setLayout(JPIDatosTtoLayout);
        JPIDatosTtoLayout.setHorizontalGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addContainerGap(12, 32767).addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addComponent(this.JCBTipoServicio, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimiento, -2, 507, -2).addGap(6, 6, 6).addComponent(this.JSPNDiente, -2, 84, -2).addGap(18, 18, 18).addComponent(this.JSPNCitas, -2, 84, -2)).addGroup(JPIDatosTtoLayout.createSequentialGroup().addComponent(this.JTFCDxP1, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP1, -2, 499, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDx1, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, 141, 32767)))));
        JPIDatosTtoLayout.setVerticalGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoServicio, -2, -1, -2).addComponent(this.JCBProcedimiento, -2, -1, -2).addComponent(this.JSPNDiente, -2, 46, -2).addComponent(this.JSPNCitas, -2, 46, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAdicionar, -1, -1, 32767).addComponent(this.JCBTipoDx1).addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP1, -2, 50, -2).addComponent(this.JTFNCodigoDxP1, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalleTto.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleTto.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTto.setRowHeight(25);
        this.JTDetalleTto.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTto.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleTto.setSelectionMode(0);
        this.JSPDetalleTto.setViewportView(this.JTDetalleTto);
        GroupLayout JPITratamientoLayout = new GroupLayout(this.JPITratamiento);
        this.JPITratamiento.setLayout(JPITratamientoLayout);
        JPITratamientoLayout.setHorizontalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosTto, -1, -1, 32767).addContainerGap()).addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JSPDetalleTto, -1, 907, 32767).addContainerGap())));
        JPITratamientoLayout.setVerticalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosTto, -2, -1, -2).addContainerGap(193, 32767)).addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITratamientoLayout.createSequentialGroup().addContainerGap(170, 32767).addComponent(this.JSPDetalleTto, -2, 165, -2).addContainerGap())));
        this.JTPPlanificador.addTab("TRATAMIENTO", this.JPITratamiento);
        this.JPIDEvolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JDCFechaITto1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaITto1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaITto1.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDEvolucionLayout = new GroupLayout(this.JPIDEvolucion);
        this.JPIDEvolucion.setLayout(JPIDEvolucionLayout);
        JPIDEvolucionLayout.setHorizontalGroup(JPIDEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEvolucionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaITto1, -2, 125, -2).addContainerGap(769, 32767)));
        JPIDEvolucionLayout.setVerticalGroup(JPIDEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEvolucionLayout.createSequentialGroup().addComponent(this.JDCFechaITto1, -2, 56, -2).addContainerGap(70, 32767)));
        GroupLayout JPIEvolucionLayout = new GroupLayout(this.JPIEvolucion);
        this.JPIEvolucion.setLayout(JPIEvolucionLayout);
        JPIEvolucionLayout.setHorizontalGroup(JPIEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvolucionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDEvolucion, -2, -1, -2).addContainerGap(-1, 32767)));
        JPIEvolucionLayout.setVerticalGroup(JPIEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvolucionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDEvolucion, -2, -1, -2).addContainerGap(185, 32767)));
        this.JTPPlanificador.addTab("EVOLUCIÓN", this.JPIEvolucion);
        this.JDCFechaITto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaITto.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaITto.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFTto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFTto.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFTto.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosAtLayout = new GroupLayout(this.JPIDatosAt);
        this.JPIDatosAt.setLayout(JPIDatosAtLayout);
        JPIDatosAtLayout.setHorizontalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addComponent(this.JDCFechaITto, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFTto, -2, 125, -2)).addComponent(this.JTPPlanificador, -2, 938, -2)).addContainerGap(-1, 32767)));
        JPIDatosAtLayout.setVerticalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPPlanificador, -2, 377, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaITto, -2, 56, -2).addComponent(this.JDCFechaFTto, -2, 56, -2)).addContainerGap(29, 32767)));
        this.JTPDatosAtencion.addTab("ATENCIÓN", this.JPIDatosAt);
        this.JTPDetalleAnt.setForeground(Color.blue);
        this.JTPDetalleAnt.setCursor(new Cursor(0));
        this.JTPDetalleAnt.setDebugGraphicsOptions(4);
        this.JTPDetalleAnt.setDoubleBuffered(true);
        this.JTPDetalleAnt.setFont(new Font("Arial", 1, 14));
        this.JTPDetalleAnt.addChangeListener(new ChangeListener() { // from class: Odontologia.JIFHistoriaOdontologica.27
            public void stateChanged(ChangeEvent evt) {
                JIFHistoriaOdontologica.this.JTPDetalleAntStateChanged(evt);
            }
        });
        this.JTPDetalleAnt.addFocusListener(new FocusAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.28
            public void focusLost(FocusEvent evt) {
                JIFHistoriaOdontologica.this.JTPDetalleAntFocusLost(evt);
            }
        });
        GroupLayout JPIAFamiliaresLayout = new GroupLayout(this.JPIAFamiliares);
        this.JPIAFamiliares.setLayout(JPIAFamiliaresLayout);
        JPIAFamiliaresLayout.setHorizontalGroup(JPIAFamiliaresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIAFamiliaresLayout.setVerticalGroup(JPIAFamiliaresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("FAMILIARES", this.JPIAFamiliares);
        this.JPIAFamiliares.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIHabitosLayout = new GroupLayout(this.JPIHabitos);
        this.JPIHabitos.setLayout(JPIHabitosLayout);
        JPIHabitosLayout.setHorizontalGroup(JPIHabitosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIHabitosLayout.setVerticalGroup(JPIHabitosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("HÁBITOS", this.JPIHabitos);
        this.JPIHabitos.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIPAsociadasLayout = new GroupLayout(this.JPIPAsociadas);
        this.JPIPAsociadas.setLayout(JPIPAsociadasLayout);
        JPIPAsociadasLayout.setHorizontalGroup(JPIPAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIPAsociadasLayout.setVerticalGroup(JPIPAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("P.ASOCIADAS", this.JPIPAsociadas);
        this.JPIPAsociadas.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIAPersonalesLayout = new GroupLayout(this.JPIAPersonales);
        this.JPIAPersonales.setLayout(JPIAPersonalesLayout);
        JPIAPersonalesLayout.setHorizontalGroup(JPIAPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIAPersonalesLayout.setVerticalGroup(JPIAPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("PERSONAL", this.JPIAPersonales);
        this.JPIAPersonales.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIAInfanciaLayout = new GroupLayout(this.JPIAInfancia);
        this.JPIAInfancia.setLayout(JPIAInfanciaLayout);
        JPIAInfanciaLayout.setHorizontalGroup(JPIAInfanciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIAInfanciaLayout.setVerticalGroup(JPIAInfanciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("INFANCIA", this.JPIAInfancia);
        this.JPIAInfancia.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIAGinecoObstLayout = new GroupLayout(this.JPIAGinecoObst);
        this.JPIAGinecoObst.setLayout(JPIAGinecoObstLayout);
        JPIAGinecoObstLayout.setHorizontalGroup(JPIAGinecoObstLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        JPIAGinecoObstLayout.setVerticalGroup(JPIAGinecoObstLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 431, 32767));
        this.JTPDetalleAnt.addTab("GINECO-OBSTETRICOS", this.JPIAGinecoObst);
        this.JPIAGinecoObst.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        GroupLayout JPIDAAntecedentesLayout = new GroupLayout(this.JPIDAAntecedentes);
        this.JPIDAAntecedentes.setLayout(JPIDAAntecedentesLayout);
        JPIDAAntecedentesLayout.setHorizontalGroup(JPIDAAntecedentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAAntecedentesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDetalleAnt).addContainerGap()));
        JPIDAAntecedentesLayout.setVerticalGroup(JPIDAAntecedentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAAntecedentesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDetalleAnt).addContainerGap()));
        this.JTPDetalleAnt.getAccessibleContext().setAccessibleParent(this.JTPDetalleAnt);
        this.JTPDatosAtencion.addTab("ANTECEDENTES", this.JPIDAAntecedentes);
        GroupLayout JPIDHistoriaDentalLayout = new GroupLayout(this.JPIDHistoriaDental);
        this.JPIDHistoriaDental.setLayout(JPIDHistoriaDentalLayout);
        JPIDHistoriaDentalLayout.setHorizontalGroup(JPIDHistoriaDentalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 955, 32767));
        JPIDHistoriaDentalLayout.setVerticalGroup(JPIDHistoriaDentalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 484, 32767));
        this.JTPDatosAtencion.addTab("HC DENTAL", this.JPIDHistoriaDental);
        this.JTPEndodoncia.setForeground(new Color(0, 103, 0));
        this.JTPEndodoncia.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.setForeground(Color.blue);
        this.JTPDatos.setFont(new Font("Arial", 1, 12));
        this.JPIExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBDolor.setFont(new Font("Arial", 1, 12));
        this.JCBDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDIntensidad.setFont(new Font("Arial", 1, 12));
        this.JCBDIntensidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Intensidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDFrecuencia.setFont(new Font("Arial", 1, 12));
        this.JCBDFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCaries.setFont(new Font("Arial", 1, 12));
        this.JCBCaries.setBorder(BorderFactory.createTitledBorder((Border) null, "Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCariesTipo.setFont(new Font("Arial", 1, 12));
        this.JCBCariesTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCarie.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Carie", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCarie.setFont(new Font("Arial", 1, 12));
        this.JTPObsCarie.setFont(new Font("Arial", 1, 12));
        this.JSPObsCarie.setViewportView(this.JTPObsCarie);
        this.JCBCColor.setFont(new Font("Arial", 1, 12));
        this.JCBCColor.setBorder(BorderFactory.createTitledBorder((Border) null, "C. Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBColor.setFont(new Font("Arial", 1, 12));
        this.JCBColor.setBorder(BorderFactory.createTitledBorder((Border) null, "Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsColor.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsColor.setFont(new Font("Arial", 1, 12));
        this.JSPObsColor.setViewportView(this.JTPObsColor);
        GroupLayout JPIExamenLayout = new GroupLayout(this.JPIExamen);
        this.JPIExamen.setLayout(JPIExamenLayout);
        JPIExamenLayout.setHorizontalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenLayout.createSequentialGroup().addContainerGap().addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenLayout.createSequentialGroup().addComponent(this.JCBDolor, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDIntensidad, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDFrecuencia, -2, 130, -2)).addGroup(JPIExamenLayout.createSequentialGroup().addComponent(this.JCBCColor, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBColor, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsColor, -1, 155, 32767)).addGroup(JPIExamenLayout.createSequentialGroup().addComponent(this.JCBCaries, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCariesTipo, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsCarie, -1, 155, 32767))).addGap(10, 10, 10)));
        JPIExamenLayout.setVerticalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenLayout.createSequentialGroup().addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDolor, -2, -1, -2).addComponent(this.JCBDIntensidad, -2, -1, -2).addComponent(this.JCBDFrecuencia, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsCarie, 0, 0, 32767).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCaries).addComponent(this.JCBCariesTipo, -2, -1, -2))).addGap(13, 13, 13).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsColor, 0, 0, 32767).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCColor).addComponent(this.JCBColor, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JPIFractura.setBorder(BorderFactory.createTitledBorder((Border) null, "FRACTURA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBFVertical.setFont(new Font("Arial", 1, 12));
        this.JCBFVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Vertical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBFRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFTipo.setFont(new Font("Arial", 1, 12));
        this.JCBFTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFHorizontal.setFont(new Font("Arial", 1, 12));
        this.JCBFHorizontal.setBorder(BorderFactory.createTitledBorder((Border) null, "Horizontal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFCoronal.setFont(new Font("Arial", 1, 12));
        this.JCBFCoronal.setBorder(BorderFactory.createTitledBorder((Border) null, "Coronal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFTipo1.setFont(new Font("Arial", 1, 12));
        this.JCBFTipo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIFracturaLayout = new GroupLayout(this.JPIFractura);
        this.JPIFractura.setLayout(JPIFracturaLayout);
        JPIFracturaLayout.setHorizontalGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addComponent(this.JCBFVertical, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFRadicular, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFTipo, 0, 131, 32767)).addGroup(JPIFracturaLayout.createSequentialGroup().addComponent(this.JCBFHorizontal, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFCoronal, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFTipo1, 0, 0, 32767))).addContainerGap()));
        JPIFracturaLayout.setVerticalGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFVertical, -2, -1, -2).addComponent(this.JCBFRadicular, -2, -1, -2).addComponent(this.JCBFTipo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBFHorizontal).addComponent(this.JCBFCoronal, -2, -1, -2)).addGap(2, 2, 2)).addGroup(JPIFracturaLayout.createSequentialGroup().addComponent(this.JCBFTipo1, -1, 58, 32767).addContainerGap()))));
        this.JSPObsGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsGeneral.setFont(new Font("Arial", 1, 12));
        this.JSPObsGeneral.setViewportView(this.JTPObsGeneral);
        GroupLayout JPIDEPrimeraLayout = new GroupLayout(this.JPIDEPrimera);
        this.JPIDEPrimera.setLayout(JPIDEPrimeraLayout);
        JPIDEPrimeraLayout.setHorizontalGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIExamen, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFractura, -1, -1, 32767).addComponent(this.JSPObsGeneral, -1, 439, 32767)).addContainerGap()));
        JPIDEPrimeraLayout.setVerticalGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIExamen, -2, -1, -2)).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPIFractura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObsGeneral, -1, 60, 32767))).addContainerGap(85, 32767)));
        this.JTPDatos.addTab("PRIMERA", this.JPIDEPrimera);
        this.JPIAbsceso.setBorder(BorderFactory.createTitledBorder((Border) null, "ABSCESO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBAIntraoral.setFont(new Font("Arial", 1, 12));
        this.JCBAIntraoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Intraoral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBATipo.setFont(new Font("Arial", 1, 12));
        this.JCBATipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAExtraoral.setFont(new Font("Arial", 1, 12));
        this.JCBAExtraoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Extraoral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBATipo1.setFont(new Font("Arial", 1, 12));
        this.JCBATipo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIAbscesoLayout = new GroupLayout(this.JPIAbsceso);
        this.JPIAbsceso.setLayout(JPIAbscesoLayout);
        JPIAbscesoLayout.setHorizontalGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAbscesoLayout.createSequentialGroup().addContainerGap().addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAIntraoral, -2, 130, -2).addComponent(this.JCBAExtraoral, -2, 130, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBATipo1, 0, 217, 32767).addComponent(this.JCBATipo, 0, 217, 32767)).addContainerGap()));
        JPIAbscesoLayout.setVerticalGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAbscesoLayout.createSequentialGroup().addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIAbscesoLayout.createSequentialGroup().addComponent(this.JCBATipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBATipo1)).addGroup(GroupLayout.Alignment.LEADING, JPIAbscesoLayout.createSequentialGroup().addComponent(this.JCBAIntraoral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAExtraoral, -2, -1, -2))).addGap(2, 2, 2)));
        this.JCBRestauracion.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Restauración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRestauracionTipo.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracionTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRestauracionEstado.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracionEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBirfulcacion.setFont(new Font("Arial", 1, 12));
        this.JCBBirfulcacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Bifurcación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFisura.setFont(new Font("Arial", 1, 12));
        this.JCBFisura.setBorder(BorderFactory.createTitledBorder((Border) null, "Fistula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFisuraUbicacion.setFont(new Font("Arial", 1, 12));
        this.JTFFisuraUbicacion.setToolTipText("");
        this.JTFFisuraUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEPulpar.setFont(new Font("Arial", 1, 12));
        this.JCBEPulpar.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEPulparObserv.setFont(new Font("Arial", 1, 12));
        this.JTFEPulparObserv.setToolTipText("");
        this.JTFEPulparObserv.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIESegundaLayout = new GroupLayout(this.JPIESegunda);
        this.JPIESegunda.setLayout(JPIESegundaLayout);
        JPIESegundaLayout.setHorizontalGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addContainerGap().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addComponent(this.JPIAbsceso, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addComponent(this.JCBRestauracion, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRestauracionTipo, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRestauracionEstado, -2, 121, -2)).addComponent(this.JCBBirfulcacion, -2, 159, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767)).addGroup(JPIESegundaLayout.createSequentialGroup().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEPulpar, 0, -1, 32767).addComponent(this.JCBFisura, -2, 153, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEPulparObserv, -1, 727, 32767).addComponent(this.JTFFisuraUbicacion, -1, 727, 32767)))).addContainerGap()));
        JPIESegundaLayout.setVerticalGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIAbsceso, -2, -1, -2)).addGroup(JPIESegundaLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRestauracion, -2, -1, -2).addComponent(this.JCBRestauracionTipo, -2, -1, -2).addComponent(this.JCBRestauracionEstado, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JCBBirfulcacion, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFisura, -1, 50, 32767).addComponent(this.JTFFisuraUbicacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEPulpar, -1, 50, 32767).addComponent(this.JTFEPulparObserv, -2, -1, -2)).addContainerGap()));
        this.JTPDatos.addTab("SEGUNDA", this.JPIESegunda);
        GroupLayout JPIEndExamenCLayout = new GroupLayout(this.JPIEndExamenC);
        this.JPIEndExamenC.setLayout(JPIEndExamenCLayout);
        JPIEndExamenCLayout.setHorizontalGroup(JPIEndExamenCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEndExamenCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        JPIEndExamenCLayout.setVerticalGroup(JPIEndExamenCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEndExamenCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        this.JTPEndodoncia.addTab("EXÁMEN CLÍNICO", this.JPIEndExamenC);
        this.JCBFrio.setFont(new Font("Arial", 1, 12));
        this.JCBFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Frio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsFrio.setFont(new Font("Arial", 1, 12));
        this.JSPObsFrio.setViewportView(this.JTPObsFrio);
        this.JCBCalorPC.setFont(new Font("Arial", 1, 12));
        this.JCBCalorPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Calor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCalorPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsCalorPC.setFont(new Font("Arial", 1, 12));
        this.JSPObsCalorPC.setViewportView(this.JTPObsCalorPC);
        this.JPIPercusion.setBorder(BorderFactory.createTitledBorder((Border) null, "PERCUSIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBPVertical.setFont(new Font("Arial", 1, 12));
        this.JCBPVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Vertical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPTipoV.setFont(new Font("Arial", 1, 12));
        this.JCBPTipoV.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPGradoV.setFont(new Font("Arial", 1, 12));
        this.JCBPGradoV.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPHorizontal.setFont(new Font("Arial", 1, 12));
        this.JCBPHorizontal.setBorder(BorderFactory.createTitledBorder((Border) null, "Horizontal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPTipoH.setFont(new Font("Arial", 1, 12));
        this.JCBPTipoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPGradoH.setFont(new Font("Arial", 1, 12));
        this.JCBPGradoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsPclinica.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsGeneral1.setFont(new Font("Arial", 1, 12));
        this.JSPObsPclinica.setViewportView(this.JTPObsGeneral1);
        GroupLayout JPIPercusionLayout = new GroupLayout(this.JPIPercusion);
        this.JPIPercusion.setLayout(JPIPercusionLayout);
        JPIPercusionLayout.setHorizontalGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObsPclinica, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIPercusionLayout.createSequentialGroup().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPVertical, -2, 130, -2).addComponent(this.JCBPHorizontal, -2, 130, -2)).addGap(18, 18, 18).addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBPTipoV, 0, -1, 32767).addComponent(this.JCBPTipoH, -2, 136, -2)).addGap(18, 18, 18).addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPGradoV, -2, 130, -2).addComponent(this.JCBPGradoH, -2, 130, -2)))).addContainerGap()));
        JPIPercusionLayout.setVerticalGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createSequentialGroup().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPTipoV, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPTipoH, -2, -1, -2)).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPVertical, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPHorizontal, -2, -1, -2))).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPGradoV, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPGradoH, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsPclinica).addContainerGap()));
        this.JCBMovilidad.setFont(new Font("Arial", 1, 12));
        this.JCBMovilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Movilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovGrado.setFont(new Font("Arial", 1, 12));
        this.JCBMovGrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovTesCav.setFont(new Font("Arial", 1, 12));
        this.JCBMovTesCav.setBorder(BorderFactory.createTitledBorder((Border) null, "Test Cavitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIPClinicasLayout = new GroupLayout(this.JPIPClinicas);
        this.JPIPClinicas.setLayout(JPIPClinicasLayout);
        JPIPClinicasLayout.setHorizontalGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPClinicasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPClinicasLayout.createSequentialGroup().addComponent(this.JCBMovilidad, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JCBMovGrado, 0, 121, 32767).addGap(18, 18, 18).addComponent(this.JCBMovTesCav, -2, 130, -2)).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIPClinicasLayout.createSequentialGroup().addComponent(this.JCBCalorPC, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsCalorPC)).addGroup(GroupLayout.Alignment.LEADING, JPIPClinicasLayout.createSequentialGroup().addComponent(this.JCBFrio, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsFrio, -2, 293, -2)))).addGap(18, 18, 18).addComponent(this.JPIPercusion, -2, -1, -2).addGap(12, 12, 12)));
        JPIPClinicasLayout.setVerticalGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPClinicasLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIPercusion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIPClinicasLayout.createSequentialGroup().addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsFrio, 0, 0, 32767).addComponent(this.JCBFrio, -2, -1, -2)).addGap(32, 32, 32).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsCalorPC, 0, 0, 32767).addComponent(this.JCBCalorPC, -2, -1, -2)).addGap(96, 96, 96).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBMovGrado, -2, -1, -2).addComponent(this.JCBMovilidad, -2, -1, -2)).addComponent(this.JCBMovTesCav, -2, -1, -2)))).addGap(86, 86, 86)));
        this.JTPEndodoncia.addTab("PRUEBA CLÍNICA", this.JPIPClinicas);
        this.JTFCorona.setFont(new Font("Arial", 1, 12));
        this.JTFCorona.setToolTipText("");
        this.JTFCorona.setBorder(BorderFactory.createTitledBorder((Border) null, "Corona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConductos.setFont(new Font("Arial", 1, 12));
        this.JTFConductos.setToolTipText("");
        this.JTFConductos.setBorder(BorderFactory.createTitledBorder((Border) null, "Conductos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCamaraPulpar.setFont(new Font("Arial", 1, 12));
        this.JTFCamaraPulpar.setToolTipText("");
        this.JTFCamaraPulpar.setBorder(BorderFactory.createTitledBorder((Border) null, "Camara Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLaminaDura.setFont(new Font("Arial", 1, 12));
        this.JTFLaminaDura.setToolTipText("");
        this.JTFLaminaDura.setBorder(BorderFactory.createTitledBorder((Border) null, "Lamina Dura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRaiz.setFont(new Font("Arial", 1, 12));
        this.JTFRaiz.setToolTipText("");
        this.JTFRaiz.setBorder(BorderFactory.createTitledBorder((Border) null, "Raiz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPeriapice.setFont(new Font("Arial", 1, 12));
        this.JTFPeriapice.setToolTipText("");
        this.JTFPeriapice.setBorder(BorderFactory.createTitledBorder((Border) null, "Periapice", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsExRadiografico.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsExRadiografico.setFont(new Font("Arial", 1, 12));
        this.JSPObsExRadiografico.setViewportView(this.JTPObsExRadiografico);
        GroupLayout JPIExRadiograficoLayout = new GroupLayout(this.JPIExRadiografico);
        this.JPIExRadiografico.setLayout(JPIExRadiograficoLayout);
        JPIExRadiograficoLayout.setHorizontalGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIExRadiograficoLayout.createSequentialGroup().addContainerGap().addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObsExRadiografico, GroupLayout.Alignment.LEADING, -1, 893, 32767).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCorona, -1, 280, 32767).addComponent(this.JTFLaminaDura, -1, 280, 32767)).addGap(27, 27, 27).addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addComponent(this.JTFConductos, -1, 280, 32767).addGap(26, 26, 26).addComponent(this.JTFCamaraPulpar, -1, 280, 32767)).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addComponent(this.JTFRaiz, -1, 280, 32767).addGap(26, 26, 26).addComponent(this.JTFPeriapice, -1, 280, 32767))))).addGap(18, 18, 18)));
        JPIExRadiograficoLayout.setVerticalGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addContainerGap().addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCorona, -2, -1, -2).addComponent(this.JTFCamaraPulpar, -2, -1, -2).addComponent(this.JTFConductos, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFLaminaDura, -2, -1, -2).addComponent(this.JTFPeriapice, -2, -1, -2).addComponent(this.JTFRaiz, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPObsExRadiografico, -1, 87, 32767).addGap(147, 147, 147)));
        this.JTPEndodoncia.addTab("Ex. RADIOGRÁFICO", this.JPIExRadiografico);
        this.JSPHistorialDx.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistorialDx.setFont(new Font("Arial", 1, 12));
        this.JTHistorialDx.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialDx.setRowHeight(25);
        this.JTHistorialDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialDx.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialDx.setSelectionMode(0);
        this.JTHistorialDx.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.29
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTHistorialDxMouseClicked(evt);
            }
        });
        this.JSPHistorialDx.setViewportView(this.JTHistorialDx);
        this.JCBDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JCBDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDiagnostico.addItemListener(new ItemListener() { // from class: Odontologia.JIFHistoriaOdontologica.30
            public void itemStateChanged(ItemEvent evt) {
                JIFHistoriaOdontologica.this.JCBDiagnosticoItemStateChanged(evt);
            }
        });
        this.JCBDiagnostico.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.31
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JCBDiagnosticoKeyPressed(evt);
            }
        });
        this.JCBDxRespuesta.setFont(new Font("Arial", 1, 12));
        this.JCBDxRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDxRespuesta.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.32
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JCBDxRespuestaKeyPressed(evt);
            }
        });
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Odontologia.JIFHistoriaOdontologica.33
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaOdontologica.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        GroupLayout JPIDiagnosticoLayout = new GroupLayout(this.JPIDiagnostico);
        this.JPIDiagnostico.setLayout(JPIDiagnosticoLayout);
        JPIDiagnosticoLayout.setHorizontalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorialDx, GroupLayout.Alignment.LEADING, -1, 901, 32767).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addComponent(this.JCBDiagnostico, -2, 474, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDxRespuesta, 0, 245, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarAntCli, -2, 166, -2))).addContainerGap()));
        JPIDiagnosticoLayout.setVerticalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionarAntCli, -1, -1, 32767).addComponent(this.JCBDiagnostico).addComponent(this.JCBDxRespuesta)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorialDx, -1, 287, 32767).addContainerGap()));
        this.JTPEndodoncia.addTab("DIAGNÓSTICO", this.JPIDiagnostico);
        this.JSPHistorialDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistorialDx1.setFont(new Font("Arial", 1, 12));
        this.JTHistorialDx1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialDx1.setRowHeight(25);
        this.JTHistorialDx1.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialDx1.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialDx1.setSelectionMode(0);
        this.JTHistorialDx1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.34
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaOdontologica.this.JTHistorialDx1MouseClicked(evt);
            }
        });
        this.JSPHistorialDx1.setViewportView(this.JTHistorialDx1);
        this.JDFFechaTrauma1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaTrauma1.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaTrauma1.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaTrauma1, -2, 114, -2).addContainerGap(777, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaTrauma1, -1, 52, 32767).addGap(59, 59, 59)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorialDx1, -1, 901, 32767).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addContainerGap(230, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(190, 32767).addComponent(this.JSPHistorialDx1, -2, 162, -2).addContainerGap())));
        this.JTPEndodoncia.addTab("EVOLUCIÓN", this.jPanel1);
        this.JPITDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Trauma", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaTrauma.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaTrauma.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaTrauma.setFont(new Font("Arial", 1, 12));
        this.JCBTraumasAnt.setFont(new Font("Arial", 1, 12));
        this.JCBTraumasAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Traumas Anteriores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDientesInv.setFont(new Font("Arial", 1, 12));
        this.JTFDientesInv.setToolTipText("");
        this.JTFDientesInv.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Involucrados", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLugar.setFont(new Font("Arial", 1, 12));
        this.JTFLugar.setToolTipText("");
        this.JTFLugar.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCausasTrauma.setBorder(BorderFactory.createTitledBorder((Border) null, "Causas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsExRadiografico1.setFont(new Font("Arial", 1, 12));
        this.JSPObsCausasTrauma.setViewportView(this.JTPObsExRadiografico1);
        GroupLayout JPITDatosLayout = new GroupLayout(this.JPITDatos);
        this.JPITDatos.setLayout(JPITDatosLayout);
        JPITDatosLayout.setHorizontalGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosLayout.createSequentialGroup().addComponent(this.JDFFechaTrauma, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTraumasAnt, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDientesInv, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFLugar, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObsCausasTrauma, -2, 236, -2).addContainerGap()));
        JPITDatosLayout.setVerticalGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosLayout.createSequentialGroup().addGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITDatosLayout.createSequentialGroup().addComponent(this.JDFFechaTrauma, -1, 52, 32767).addGap(7, 7, 7)).addGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFLugar).addComponent(this.JTFDientesInv).addComponent(this.JCBTraumasAnt)).addComponent(this.JSPObsCausasTrauma, -1, 59, 32767)).addContainerGap()));
        this.JTPHallagoz.setForeground(Color.red);
        this.JTPHallagoz.setFont(new Font("Arial", 1, 12));
        this.JCBTDolorCabeza.setFont(new Font("Arial", 1, 12));
        this.JCBTDolorCabeza.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor de Cabeza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTConciencia.setFont(new Font("Arial", 1, 12));
        this.JCBTConciencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Conciencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTNauseas.setFont(new Font("Arial", 1, 12));
        this.JCBTNauseas.setBorder(BorderFactory.createTitledBorder((Border) null, "Náuseas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosHGeneralesLayout = new GroupLayout(this.JPIDatosHGenerales);
        this.JPIDatosHGenerales.setLayout(JPIDatosHGeneralesLayout);
        JPIDatosHGeneralesLayout.setHorizontalGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHGeneralesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTDolorCabeza, -2, 273, -2).addGap(18, 18, 18).addComponent(this.JCBTConciencia, -2, 273, -2).addGap(18, 18, 18).addComponent(this.JCBTNauseas, -2, 273, -2).addContainerGap(31, 32767)));
        JPIDatosHGeneralesLayout.setVerticalGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHGeneralesLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTDolorCabeza, -2, -1, -2).addComponent(this.JCBTConciencia, -2, -1, -2).addComponent(this.JCBTNauseas, -2, -1, -2)).addContainerGap(129, 32767)));
        this.JTPHallagoz.addTab("H.Generales", this.JPIDatosHGenerales);
        this.JPIDHIDientesInv.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Involucrados", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFDTemporales.setFont(new Font("Arial", 1, 12));
        this.JTFDTemporales.setToolTipText("");
        this.JTFDTemporales.setBorder(BorderFactory.createTitledBorder((Border) null, "Temporales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDPermanentes.setFont(new Font("Arial", 1, 12));
        this.JTFDPermanentes.setToolTipText("");
        this.JTFDPermanentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Permanentes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDHIDientesInvLayout = new GroupLayout(this.JPIDHIDientesInv);
        this.JPIDHIDientesInv.setLayout(JPIDHIDientesInvLayout);
        JPIDHIDientesInvLayout.setHorizontalGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDientesInvLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDPermanentes, -2, 108, -2).addContainerGap(-1, 32767)).addGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDientesInvLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDTemporales, -2, 106, -2).addContainerGap(12, 32767))));
        JPIDHIDientesInvLayout.setVerticalGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDHIDientesInvLayout.createSequentialGroup().addContainerGap(70, 32767).addComponent(this.JTFDPermanentes, -2, -1, -2).addContainerGap()).addGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDientesInvLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDTemporales, -2, -1, -2).addContainerGap(70, 32767))));
        this.JPIDHIDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDEspontaneo.setFont(new Font("Arial", 1, 12));
        this.JCBDEspontaneo.setBorder(BorderFactory.createTitledBorder((Border) null, "Espontáneo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDFrio.setFont(new Font("Arial", 1, 12));
        this.JCBDFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Frio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDPercusion.setFont(new Font("Arial", 1, 12));
        this.JCBDPercusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Percusión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDExposicionP.setFont(new Font("Arial", 1, 12));
        this.JCBDExposicionP.setBorder(BorderFactory.createTitledBorder((Border) null, "Exposición Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDHIDolorLayout = new GroupLayout(this.JPIDHIDolor);
        this.JPIDHIDolor.setLayout(JPIDHIDolorLayout);
        JPIDHIDolorLayout.setHorizontalGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDEspontaneo, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDFrio, 0, -1, 32767).addComponent(this.JCBDExposicionP, -2, 122, -2)).addContainerGap(-1, 32767)).addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDPercusion, -2, 116, -2).addContainerGap(144, 32767))));
        JPIDHIDolorLayout.setVerticalGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addContainerGap().addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addComponent(this.JCBDFrio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDExposicionP, -2, -1, -2)).addComponent(this.JCBDEspontaneo, -2, -1, -2)).addContainerGap(14, 32767)).addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addGap(65, 65, 65).addComponent(this.JCBDPercusion, -2, -1, -2).addContainerGap(16, 32767))));
        this.JTFPElectricaV.setFont(new Font("Arial", 1, 12));
        this.JTFPElectricaV.setToolTipText("");
        this.JTFPElectricaV.setBorder(BorderFactory.createTitledBorder((Border) null, "Prueba Eléctrica Vítalidad (EPT)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCColoracionCorona.setFont(new Font("Arial", 1, 12));
        this.JCBCColoracionCorona.setBorder(BorderFactory.createTitledBorder((Border) null, "C. Coloración Corona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovDentaria.setFont(new Font("Arial", 1, 12));
        this.JCBMovDentaria.setBorder(BorderFactory.createTitledBorder((Border) null, "Movilidad Dentaria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f15JPIDHIDao.setBorder(BorderFactory.createTitledBorder((Border) null, "Daño", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBMBucal.setFont(new Font("Arial", 1, 12));
        this.JCBMBucal.setBorder(BorderFactory.createTitledBorder((Border) null, "M. Bucal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLLabial.setFont(new Font("Arial", 1, 12));
        this.JCBLLabial.setBorder(BorderFactory.createTitledBorder((Border) null, "L. Labial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDOtros.setFont(new Font("Arial", 1, 12));
        this.JTFDOtros.setToolTipText("");
        this.JTFDOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout groupLayout = new GroupLayout(this.f15JPIDHIDao);
        this.f15JPIDHIDao.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.JCBMBucal, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JCBLLabial, -2, 84, -2)).addComponent(this.JTFDOtros, -1, 185, 32767)).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMBucal, -2, -1, -2).addComponent(this.JCBLLabial, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JTFDOtros, -2, -1, -2).addContainerGap(13, 32767)));
        GroupLayout JPIDatosHIntrahoralesLayout = new GroupLayout(this.JPIDatosHIntrahorales);
        this.JPIDatosHIntrahorales.setLayout(JPIDatosHIntrahoralesLayout);
        JPIDatosHIntrahoralesLayout.setHorizontalGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHIntrahoralesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDHIDientesInv, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDHIDolor, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFPElectricaV, -1, 204, 32767).addComponent(this.JCBCColoracionCorona, 0, 209, 32767).addComponent(this.JCBMovDentaria, 0, 204, 32767)).addGap(18, 18, 18).addComponent(this.f15JPIDHIDao, -1, -1, 32767).addContainerGap()));
        JPIDatosHIntrahoralesLayout.setVerticalGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosHIntrahoralesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDHIDientesInv, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDHIDolor, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.f15JPIDHIDao, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIDatosHIntrahoralesLayout.createSequentialGroup().addComponent(this.JTFPElectricaV, -1, 45, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCColoracionCorona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMovDentaria, -2, -1, -2))).addGap(42, 42, 42)));
        this.JTPHallagoz.addTab("H. Intraorales", this.JPIDatosHIntrahorales);
        this.JCBHRFradicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRFradicular.setBorder(BorderFactory.createTitledBorder((Border) null, "S.Formación Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHRForamenApical.setFont(new Font("Arial", 1, 12));
        this.JTFHRForamenApical.setToolTipText("");
        this.JTFHRForamenApical.setBorder(BorderFactory.createTitledBorder((Border) null, "Foramen Apical (mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRFracturaRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRFracturaRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Fractura Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRLesionApical.setFont(new Font("Arial", 1, 12));
        this.JCBHRLesionApical.setBorder(BorderFactory.createTitledBorder((Border) null, "Lesión Apical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRCavidadPul.setFont(new Font("Arial", 1, 12));
        this.JCBHRCavidadPul.setBorder(BorderFactory.createTitledBorder((Border) null, "Obli. Cavidad Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRreabsRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRreabsRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Reabsorción Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRTipoReabsRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRTipoReabsRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reabsorción Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHREstMembranaPerio.setFont(new Font("Arial", 1, 12));
        this.JCBHREstMembranaPerio.setBorder(BorderFactory.createTitledBorder((Border) null, "Ensan. Membrana Perio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRFracturaAlveolo.setFont(new Font("Arial", 1, 12));
        this.JCBHRFracturaAlveolo.setBorder(BorderFactory.createTitledBorder((Border) null, "Fractura Alvéolo Oseo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosHRadirograficosLayout = new GroupLayout(this.JPIDatosHRadirograficos);
        this.JPIDatosHRadirograficos.setLayout(JPIDatosHRadirograficosLayout);
        JPIDatosHRadirograficosLayout.setHorizontalGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBHRreabsRadicular, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBHRFradicular, GroupLayout.Alignment.LEADING, 0, 182, 32767)).addGap(18, 18, 18).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addComponent(this.JTFHRForamenApical, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHRFracturaRadicular, -2, 143, -2)).addComponent(this.JCBHRTipoReabsRadicular, 0, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addComponent(this.JCBHRLesionApical, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHRCavidadPul, -2, 143, -2)).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addComponent(this.JCBHREstMembranaPerio, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHRFracturaAlveolo, -2, 143, -2))).addContainerGap(73, 32767)));
        JPIDatosHRadirograficosLayout.setVerticalGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHRFradicular).addComponent(this.JTFHRForamenApical).addComponent(this.JCBHRFracturaRadicular).addComponent(this.JCBHRLesionApical).addComponent(this.JCBHRCavidadPul)).addGap(18, 18, 18).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHRreabsRadicular).addComponent(this.JCBHRTipoReabsRadicular).addComponent(this.JCBHREstMembranaPerio).addComponent(this.JCBHRFracturaAlveolo)).addGap(104, 104, 104)));
        this.JTPHallagoz.addTab("H.Radiográficos", this.JPIDatosHRadirograficos);
        this.JPIDDAResguardado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resguardado en:", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDASeco.setFont(new Font("Arial", 1, 12));
        this.JCBDASeco.setBorder(BorderFactory.createTitledBorder((Border) null, "Seco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDAAgua.setFont(new Font("Arial", 1, 12));
        this.JCBDAAgua.setBorder(BorderFactory.createTitledBorder((Border) null, "Agua", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDASaliva.setFont(new Font("Arial", 1, 12));
        this.JCBDASaliva.setBorder(BorderFactory.createTitledBorder((Border) null, "Saliva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDALeche.setFont(new Font("Arial", 1, 12));
        this.JCBDALeche.setBorder(BorderFactory.createTitledBorder((Border) null, "Leche", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDDAResguardadoLayout = new GroupLayout(this.JPIDDAResguardado);
        this.JPIDDAResguardado.setLayout(JPIDDAResguardadoLayout);
        JPIDDAResguardadoLayout.setHorizontalGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDASeco, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDAAgua, 0, -1, 32767).addComponent(this.JCBDALeche, -2, 122, -2)).addContainerGap(-1, 32767)).addGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDASaliva, -2, 116, -2).addContainerGap(144, 32767))));
        JPIDDAResguardadoLayout.setVerticalGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addComponent(this.JCBDAAgua, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDALeche, -2, -1, -2)).addComponent(this.JCBDASeco, -2, -1, -2)).addContainerGap(47, 32767)).addGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addGap(65, 65, 65).addComponent(this.JCBDASaliva, -2, -1, -2).addContainerGap(28, 32767))));
        this.JTFDAFCabidadB.setFont(new Font("Arial", 1, 12));
        this.JTFDAFCabidadB.setToolTipText("Tiempo Permanencia Fuera C.Bucal(min)");
        this.JTFDAFCabidadB.setBorder(BorderFactory.createTitledBorder((Border) null, "T. P. Fuera C.Bucal(min)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDAPlanTrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Plan Tratamiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDAPlanTrato.setFont(new Font("Arial", 1, 12));
        this.JSPDAPlanTrato.setViewportView(this.JTPDAPlanTrato);
        this.JPIDiagnosticoT.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JCBDDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarDx.addActionListener(new ActionListener() { // from class: Odontologia.JIFHistoriaOdontologica.35
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaOdontologica.this.JBTAdicionarDxActionPerformed(evt);
            }
        });
        this.JSPTDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPTDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JTBTDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JTBTDiagnostico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBTDiagnostico.setRowHeight(20);
        this.JTBTDiagnostico.setSelectionMode(0);
        this.JTBTDiagnostico.addKeyListener(new KeyAdapter() { // from class: Odontologia.JIFHistoriaOdontologica.36
            public void keyPressed(KeyEvent evt) {
                JIFHistoriaOdontologica.this.JTBTDiagnosticoKeyPressed(evt);
            }
        });
        this.JSPTDiagnostico.setViewportView(this.JTBTDiagnostico);
        GroupLayout JPIDiagnosticoTLayout = new GroupLayout(this.JPIDiagnosticoT);
        this.JPIDiagnosticoT.setLayout(JPIDiagnosticoTLayout);
        JPIDiagnosticoTLayout.setHorizontalGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPTDiagnostico, GroupLayout.Alignment.LEADING, -1, 380, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDiagnosticoTLayout.createSequentialGroup().addComponent(this.JCBDDiagnostico, -2, 296, -2).addGap(18, 18, 18).addComponent(this.JBTAdicionarDx, -2, 61, -2))).addContainerGap()));
        JPIDiagnosticoTLayout.setVerticalGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoTLayout.createSequentialGroup().addGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionarDx, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBDDiagnostico, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTDiagnostico, -1, 76, 32767).addContainerGap()));
        GroupLayout JPIDatosCDienteAvulLayout = new GroupLayout(this.JPIDatosCDienteAvul);
        this.JPIDatosCDienteAvul.setLayout(JPIDatosCDienteAvulLayout);
        JPIDatosCDienteAvulLayout.setHorizontalGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCDienteAvulLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDDAResguardado, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDAPlanTrato).addComponent(this.JTFDAFCabidadB, -1, 158, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDiagnosticoT, -1, -1, 32767).addContainerGap()));
        JPIDatosCDienteAvulLayout.setVerticalGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCDienteAvulLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDiagnosticoT, -1, -1, 32767).addGroup(JPIDatosCDienteAvulLayout.createSequentialGroup().addComponent(this.JTFDAFCabidadB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDAPlanTrato, -1, 113, 32767)).addComponent(this.JPIDDAResguardado, -1, -1, 32767)).addContainerGap()));
        this.JTPHallagoz.addTab("C.Diente Avulsionado", this.JPIDatosCDienteAvul);
        GroupLayout JPITraumaLayout = new GroupLayout(this.JPITrauma);
        this.JPITrauma.setLayout(JPITraumaLayout);
        JPITraumaLayout.setHorizontalGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITraumaLayout.createSequentialGroup().addContainerGap().addGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPHallagoz, GroupLayout.Alignment.LEADING).addComponent(this.JPITDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPITraumaLayout.setVerticalGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITraumaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPITDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPHallagoz, -2, 225, -2).addContainerGap(27, 32767)));
        this.JTPHallagoz.getAccessibleContext().setAccessibleName("H.Generales");
        this.JTPEndodoncia.addTab("TRAUMA", this.JPITrauma);
        GroupLayout JPIDatosEndodonciaLayout = new GroupLayout(this.JPIDatosEndodoncia);
        this.JPIDatosEndodoncia.setLayout(JPIDatosEndodonciaLayout);
        JPIDatosEndodonciaLayout.setHorizontalGroup(JPIDatosEndodonciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEndodonciaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPEndodoncia, -2, 926, -2).addContainerGap(19, 32767)));
        JPIDatosEndodonciaLayout.setVerticalGroup(JPIDatosEndodonciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEndodonciaLayout.createSequentialGroup().addContainerGap(79, 32767).addComponent(this.JTPEndodoncia, -2, 394, -2).addContainerGap()));
        this.JTPDatosAtencion.addTab("ENDODONCIA", this.JPIDatosEndodoncia);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosAtencion, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JPIDatosU, GroupLayout.Alignment.LEADING, -2, 1066, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosU, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosAtencion, -2, 489, -2).addContainerGap(69, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetalleAntFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosAtencionStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetalleAntStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosAtencionMouseClicked(MouseEvent evt) {
        this.JTPDetalleAnt.updateUI();
        this.JTPDetalleAnt.repaint();
        this.JTPDetalleAnt.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialDxMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialDx1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarDxActionPerformed(ActionEvent evt) {
        if (this.JCBDDiagnostico.getSelectedIndex() != -1 && !this.xmt.mVerificarDatosDoblesTabla(this.JTBTDiagnostico, 0, this.x62ftipodx[this.JCBDDiagnostico.getSelectedIndex()])) {
            this.xmodelo0.addRow(this.xdato);
            this.xmodelo0.setValueAt(this.x62ftipodx[this.JCBDDiagnostico.getSelectedIndex()], this.xnfilamodelo0, 0);
            this.xmodelo0.setValueAt(this.JCBDDiagnostico.getSelectedItem().toString(), this.xnfilamodelo0, 1);
            this.xnfilamodelo0++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiagnosticoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDiagnostico.getSelectedIndex() != -1) {
            this.JCBDxRespuesta.removeAllItems();
            this.xsql = "SELECT o_tipo_parametros.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_descripcionxparametro.Id_cdescipcion ='" + this.x48iddiagnostico[this.JCBDiagnostico.getSelectedIndex()] + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_descripcionxparametro.NOrden ASC ";
            this.x49idrespuestadx = this.xct.llenarCombo(this.xsql, this.x49idrespuestadx, this.JCBDxRespuesta);
            this.JCBDxRespuesta.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiagnosticoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBDiagnostico.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDxRespuestaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameOpened(InternalFrameEvent evt) {
        repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTDiagnosticoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTBTDiagnostico.getSelectedRow() != -1) {
            this.xmodelo0.removeRow(this.JTBTDiagnostico.getSelectedRow());
            this.xnfilamodelo0--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
        mBuscarGuiasPatologias(this.JTFCDxP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 1);
        mBuscarGuiasPatologias(this.JTFCDxR1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 1);
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 2);
        mBuscarGuiasPatologias(this.JTFCDxR2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 2);
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR2, this.JTFNDxR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 3);
        mBuscarGuiasPatologias(this.JTFCDxR3.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 3);
            this.JTFCDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR3, this.JTFNDxR3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMotivoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPMotivoC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP1, this.JTFNCodigoDxP1, 1);
        mBuscarGuiasPatologias(this.JTFCDxP1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP1, this.JTFNCodigoDxP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoServicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoServicio.getSelectedIndex() != -1) {
            this.JCBProcedimiento.removeAllItems();
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (g_procedimiento.Estado =0 AND f_tiposervicio.Id ='" + this.xidservicio[this.JCBTipoServicio.getSelectedIndex()] + "' and g_procedimiento.EsOdontologico=1) ORDER BY g_procedimiento.Nbre ASC ";
            this.xidprocedimiento = this.xct.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            if (!this.JTFCDxP1.getText().isEmpty()) {
                if (this.JCBTipoDx1.getSelectedIndex() != -1) {
                    this.xmodelodetalletto.addRow(this.xdato);
                    this.xmodelodetalletto.setValueAt(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()], this.xnfilamodelodetalletto, 0);
                    this.xmodelodetalletto.setValueAt(this.JCBProcedimiento.getSelectedItem().toString(), this.xnfilamodelodetalletto, 1);
                    this.xmodelodetalletto.setValueAt(this.JSPNDiente.getValue(), this.xnfilamodelodetalletto, 2);
                    this.xmodelodetalletto.setValueAt(this.JSPNCitas.getValue(), this.xnfilamodelodetalletto, 3);
                    this.xmodelodetalletto.setValueAt(this.JTFCDxP1.getText(), this.xnfilamodelodetalletto, 4);
                    this.xmodelodetalletto.setValueAt(this.JTFNCodigoDxP1.getText(), this.xnfilamodelodetalletto, 5);
                    this.xmodelodetalletto.setValueAt(this.xidtipodx1[this.JCBTipoDx1.getSelectedIndex()], this.xnfilamodelodetalletto, 6);
                    this.xmodelodetalletto.setValueAt(this.JCBProcedimiento.getSelectedItem().toString(), this.xnfilamodelodetalletto, 7);
                    this.xnfilamodelodetalletto++;
                    mLimpiarDatosAtencionTto();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de dx", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDx1.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo de dx no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP1.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProcedimiento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "Odontolgia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscarGuiasPatologias(String codigo) {
        try {
            String sql = "SELECT PathGuia FROM h_patologiaxguiamanejo WHERE (Id_Patologia ='" + codigo + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int x = JOptionPane.showInternalConfirmDialog(this, "El código tiene una guia asociada \n\t\t Desea consultarla?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mostrarPdf(xrs.getString(1));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaOdontologica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        mCargarCombosParametros();
        mCargarCombos();
        mCargarPanelPersona();
        mCargarPanelAFamiliares();
        mCargarPanelAHabitos();
        mCargarPanelPAsociadas();
        mCargarPanelPPersonales();
        mCargarPanelAInfancia();
        mCargarPanelHcDental();
        mCargarPanelAGineObstetricos();
        mCrearTablaDxTrauma();
        mCrearTablaDiagnostico();
        mCrearTablaDetalleTto();
        this.JDCFechaITto.setDate(this.xmt.getFechaActual());
        this.JDCFechaFTto.setDate(this.xmt.getFechaActual());
        this.xjppersona.txtHistoria.requestFocus();
    }

    private void mCargarPanelPersona() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDatosU.setVisible(false);
        this.xjppersona.setBounds(10, 15, 930, 160);
        this.JPIDatosU.add(this.xjppersona);
        this.JPIDatosU.setVisible(true);
    }

    private void mCargarPanelAFamiliares() {
        this.xjpafamiliares = new JPAAntecentesFamiliares(this, 1);
        this.xjpafamiliares.setVisible(true);
        this.JPIAFamiliares.setVisible(false);
        this.xjpafamiliares.setBounds(0, 0, 850, 450);
        this.JPIAFamiliares.add(this.xjpafamiliares);
        this.JPIAFamiliares.setVisible(true);
    }

    private void mCargarPanelAHabitos() {
        this.xjphabitos = new JPAAntecentesHabitos(this, 1);
        this.xjphabitos.setVisible(true);
        this.JPIHabitos.setVisible(false);
        this.xjphabitos.setBounds(0, 0, 850, 450);
        this.JPIHabitos.add(this.xjphabitos);
        this.JPIHabitos.setVisible(true);
    }

    private void mCargarPanelPAsociadas() {
        this.xjppasociadas = new JPAAPatologiasAsociadas(this, 1);
        this.xjppasociadas.setVisible(true);
        this.JPIPAsociadas.setVisible(false);
        this.xjppasociadas.setBounds(0, 0, 850, 380);
        this.JPIPAsociadas.add(this.xjppasociadas);
        this.JPIPAsociadas.setVisible(true);
    }

    private void mCargarPanelPPersonales() {
        this.xjpapersonales = new JPAAntecentesPPersonales(this, 1);
        this.xjpapersonales.setVisible(true);
        this.JPIAPersonales.setVisible(false);
        this.xjpapersonales.setBounds(0, 0, 850, 380);
        this.JPIAPersonales.add(this.xjpapersonales);
        this.JPIAPersonales.setVisible(true);
    }

    private void mCargarPanelAInfancia() {
        this.xjpainfancia = new JPAAntecedentesPediatricos(this, 1);
        this.xjpainfancia.setVisible(true);
        this.JPIAInfancia.setVisible(false);
        this.xjpainfancia.setBounds(0, 0, 850, 420);
        this.JPIAInfancia.add(this.xjpainfancia);
        this.JPIAInfancia.setVisible(true);
    }

    private void mCargarPanelHcDental() {
        this.xjphcdental = new JPHcDental(this, 1);
        this.xjphcdental.setVisible(true);
        this.JPIDHistoriaDental.setVisible(false);
        this.xjphcdental.setBounds(0, 0, 850, 380);
        this.JPIDHistoriaDental.add(this.xjphcdental);
        this.JPIDHistoriaDental.setVisible(true);
    }

    private void mCargarPanelAGineObstetricos() {
        this.xjpaginecoobstetricos = new JPAAntecedenteGineco(this, 2);
        this.xjpaginecoobstetricos.setVisible(true);
        this.JPIAGinecoObst.setVisible(false);
        this.xjpaginecoobstetricos.setBounds(0, 0, 850, 420);
        this.JPIAGinecoObst.add(this.xjpaginecoobstetricos);
        this.JPIAGinecoObst.setVisible(true);
    }

    public void mCargarDatosHCUsuario() {
        this.xjpafamiliares.mNuevo();
        this.xjphabitos.mNuevo();
        this.xjppasociadas.mNuevo();
        this.xjpapersonales.mNuevo();
        this.xjphcdental.mNuevo();
        this.xjpainfancia.mNuevo();
        if (this.xjppersona.getIdSexo().equals("M")) {
            this.JTPDetalleAnt.remove(5);
        } else {
            this.xjpaginecoobstetricos.mNuevo();
        }
        this.JTPDatosAtencion.repaint();
        repaint();
    }

    private void mCargarCombos() {
        this.xlleno = false;
        this.JCBDxRespuesta.removeAllItems();
        this.JCBDiagnostico.removeAllItems();
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_contenido_descripcion.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenido_descripcion.EsDx =1 AND o_tipo_descripcionxparametro.Estado =1) GROUP BY o_tipo_contenido_descripcion.Id ORDER BY o_tipo_contenido_descripcion.Nbre ASC ";
        this.x48iddiagnostico = this.xct.llenarCombo(this.xsql, this.x48iddiagnostico, this.JCBDiagnostico);
        this.JCBDiagnostico.setSelectedIndex(-1);
        this.xsql = "SELECT Id, Nbre FROM o_tipo_diagnostico WHERE (EsFractura =1 AND Estado =1) ORDER BY Nbre ASC";
        this.x62ftipodx = this.xct.llenarCombo(this.xsql, this.x62ftipodx, this.JCBDDiagnostico);
        this.JCBDDiagnostico.setSelectedIndex(-1);
        this.xsql = "SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC";
        this.xidtipodx = this.xct.llenarCombo(this.xsql, this.xidtipodx, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.xidtipodx1 = this.xct.llenarCombo(this.xsql, this.xidtipodx1, this.JCBTipoDx1);
        this.JCBTipoDx1.setSelectedIndex(-1);
        this.xsql = "SELECT f_tiposervicio.Id, f_tiposervicio.Nbre FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_tiposervicio.Id IN(4,5)) GROUP BY f_tiposervicio.Id ";
        this.xidservicio = this.xct.llenarCombo(this.xsql, this.xidservicio, this.JCBTipoServicio);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mCargarCombosParametros() {
        this.x1edolor = mllenarCombos("18", this.JCBDolor);
        this.JCBDolor.setSelectedIndex(7);
        this.x2eintensidad = mllenarCombos("16", this.JCBDIntensidad);
        this.JCBDIntensidad.setSelectedIndex(0);
        this.x3ecaries = mllenarCombos("15", this.JCBCaries);
        this.JCBCaries.setSelectedIndex(0);
        this.x4etipocaries = mllenarCombos("15", this.JCBCariesTipo);
        this.JCBCariesTipo.setSelectedIndex(0);
        this.x5eccolor = mllenarCombos("162", this.JCBCColor);
        this.JCBCColor.setSelectedIndex(0);
        this.x6ecolor = mllenarCombos("118", this.JCBColor);
        this.JCBColor.setSelectedIndex(0);
        this.x7fverticar = mllenarCombos("120", this.JCBFVertical);
        this.JCBFVertical.setSelectedIndex(0);
        this.x8fradicular = mllenarCombos("122", this.JCBFRadicular);
        this.JCBFRadicular.setSelectedIndex(0);
        this.x9ftipo1 = mllenarCombos("170", this.JCBFTipo);
        this.JCBFTipo.setSelectedIndex(0);
        this.x10fhorizontal = mllenarCombos("121", this.JCBFHorizontal);
        this.JCBFHorizontal.setSelectedIndex(0);
        this.x11fcoronal = mllenarCombos("121", this.JCBFCoronal);
        this.JCBFCoronal.setSelectedIndex(0);
        this.x12fipo2 = mllenarCombos("121", this.JCBFTipo1);
        this.JCBFTipo1.setSelectedIndex(0);
        this.x13aintraoral = mllenarCombos("198", this.JCBAIntraoral);
        this.JCBAIntraoral.setSelectedIndex(0);
        this.x15aextraoral = mllenarCombos("194", this.JCBAExtraoral);
        this.JCBAExtraoral.setSelectedIndex(0);
        this.x17aretauracion = mllenarCombos("130", this.JCBRestauracion);
        this.JCBRestauracion.setSelectedIndex(0);
        this.x19aestado = mllenarCombos("131", this.JCBRestauracionEstado);
        this.JCBRestauracionEstado.setSelectedIndex(0);
        this.x20abifurcacion = mllenarCombos("133", this.JCBBirfulcacion);
        this.JCBBirfulcacion.setSelectedIndex(0);
        this.x24pffrio = mllenarCombos("135", this.JCBFrio);
        this.JCBFrio.setSelectedIndex(0);
        this.x25pfcalor = mllenarCombos("136", this.JCBCalorPC);
        this.JCBCalorPC.setSelectedIndex(0);
        this.x27pfmovilidad = mllenarCombos("139", this.JCBMovilidad);
        this.JCBMovilidad.setSelectedIndex(0);
        this.x28pfgrado = mllenarCombos("140", this.JCBMovGrado);
        this.JCBMovGrado.setSelectedIndex(0);
        this.x29pftestcavitario = mllenarCombos("141", this.JCBMovTesCav);
        this.JCBMovTesCav.setSelectedIndex(0);
        this.x30pvertical = mllenarCombos("137", this.JCBPVertical);
        this.JCBPVertical.setSelectedIndex(0);
        this.x32pgrado = mllenarCombos("140", this.JCBPGradoV);
        this.JCBPGradoV.setSelectedIndex(0);
        this.x33phorizontal = mllenarCombos("138", this.JCBPHorizontal);
        this.JCBPHorizontal.setSelectedIndex(0);
        this.x35pgrado = mllenarCombos("140", this.JCBPGradoH);
        this.JCBPGradoH.setSelectedIndex(0);
        this.x36ttraumasant = mllenarCombos("148", this.JCBTraumasAnt);
        this.JCBTraumasAnt.setSelectedIndex(0);
        this.x37thgdolocabeza = mllenarCombos("154", this.JCBTDolorCabeza);
        this.JCBTDolorCabeza.setSelectedIndex(0);
        this.x38thgconciencia = mllenarCombos("155", this.JCBTConciencia);
        this.JCBTConciencia.setSelectedIndex(0);
        this.x39thgnauseas = mllenarCombos("156", this.JCBTNauseas);
        this.JCBTConciencia.setSelectedIndex(0);
        this.x41thifrio = mllenarCombos("135", this.JCBDFrio);
        this.JCBDFrio.setSelectedIndex(0);
        this.x42thipercusion = mllenarCombos("160", this.JCBDPercusion);
        this.JCBDPercusion.setSelectedIndex(0);
        this.x43thiexposicionpulpar = mllenarCombos("161", this.JCBDExposicionP);
        this.JCBDExposicionP.setSelectedIndex(0);
        this.x44thicolorocioncorona = mllenarCombos("162", this.JCBCColoracionCorona);
        this.JCBCColoracionCorona.setSelectedIndex(0);
        this.x45thimovdentaria = mllenarCombos("103", this.JCBMovDentaria);
        this.JCBMovDentaria.setSelectedIndex(0);
        this.x46thimbucal = mllenarCombos("163", this.JCBMBucal);
        this.JCBMBucal.setSelectedIndex(0);
        this.x47thillabial = mllenarCombos("164", this.JCBLLabial);
        this.JCBLLabial.setSelectedIndex(0);
        this.x50hrformacionrad = mllenarCombos("179", this.JCBHRFradicular);
        this.JCBHRFradicular.setSelectedIndex(0);
        this.x51hrfracradicular = mllenarCombos("168", this.JCBHRFracturaRadicular);
        this.JCBHRFracturaRadicular.setSelectedIndex(0);
        this.x52hrlesionapical = mllenarCombos("57", this.JCBHRLesionApical);
        this.JCBHRLesionApical.setSelectedIndex(0);
        this.x53hrcavidadpulpar = mllenarCombos("185", this.JCBHRCavidadPul);
        this.JCBHRCavidadPul.setSelectedIndex(0);
        this.x54hrreabsoricionrad = mllenarCombos("187", this.JCBHRreabsRadicular);
        this.JCBHRreabsRadicular.setSelectedIndex(0);
        this.x55hrtiporeabsorcionrad = mllenarCombos("170", this.JCBHRTipoReabsRadicular);
        this.JCBHRTipoReabsRadicular.setSelectedIndex(0);
        this.x57hralveolooseo = mllenarCombos("172", this.JCBHRFracturaAlveolo);
        this.JCBHRFracturaAlveolo.setSelectedIndex(0);
        this.x58rseco = mllenarCombos("174", this.JCBDASeco);
        this.JCBDASeco.setSelectedIndex(0);
        this.x59ragua = mllenarCombos("175", this.JCBDAAgua);
        this.JCBDAAgua.setSelectedIndex(0);
        this.x60rsaliva = mllenarCombos("176", this.JCBDASaliva);
        this.JCBDASaliva.setSelectedIndex(0);
        this.x61rleche = mllenarCombos("176", this.JCBDALeche);
        this.JCBDALeche.setSelectedIndex(0);
        this.xct.cerrarConexionBd();
    }

    private String[] mllenarCombos(String xv, JComboBox xcombo) {
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenido_descripcion.Id ='" + xv + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_parametros.Nbre ASC, o_tipo_descripcionxparametro.NOrden ASC ";
        String[] xvalor = this.xct.llenarCombo(this.xsql, null, xcombo);
        this.xct.cerrarConexionBd();
        return xvalor;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDxTrauma() {
        this.xmodelo0 = new DefaultTableModel(new Object[0], new String[]{"Id", "Diagnóstico"}) { // from class: Odontologia.JIFHistoriaOdontologica.37
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTDiagnostico.setModel(this.xmodelo0);
        this.JTBTDiagnostico.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBTDiagnostico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.xnfilamodelo0 = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleTto() {
        this.xmodelodetalletto = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "NDiente", "NCitas", "Dx", "Nombre Diagnóstico", "IdTipoDx", "Tipo Dx"}) { // from class: Odontologia.JIFHistoriaOdontologica.38
            Class[] types = {Long.class, String.class, Long.class, Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTto.setModel(this.xmodelodetalletto);
        this.JTDetalleTto.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleTto.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleTto.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.xnfilamodelodetalletto = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDiagnostico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Diagnóstico", "Respuesta"}) { // from class: Odontologia.JIFHistoriaOdontologica.39
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialDx.setModel(this.xmodelo1);
        this.JTHistorialDx.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTHistorialDx.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTHistorialDx.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.xnfilamodelo1 = 0;
    }

    private void mLimpiarDatosAtencionTto() {
        this.xlleno = false;
        this.JCBTipoDx1.removeAllItems();
        this.xsql = "SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC";
        this.xidtipodx1 = this.xct.llenarCombo(this.xsql, this.xidtipodx1, this.JCBTipoDx1);
        this.JCBTipoDx1.setSelectedIndex(-1);
        this.JCBProcedimiento.removeAllItems();
        this.JCBTipoServicio.removeAllItems();
        this.xsql = "SELECT f_tiposervicio.Id, f_tiposervicio.Nbre FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_tiposervicio.Id IN(4,5)) GROUP BY f_tiposervicio.Id ";
        this.xidservicio = this.xct.llenarCombo(this.xsql, this.xidservicio, this.JCBTipoServicio);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JSPNDiente.setValue(new Integer(0));
        this.JSPNCitas.setValue(new Integer(1));
        this.JTFCDxP1.setText("");
        this.JTFNCodigoDxP1.setText("");
        this.JCBTipoServicio.requestFocus();
    }
}
