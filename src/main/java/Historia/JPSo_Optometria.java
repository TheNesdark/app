package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Optometria.class */
public class JPSo_Optometria extends JPanel {
    private String[] xidtipor;
    private clasesHistoriaCE xclase;
    private String xsql;
    public String xoptometria;
    private static String idOptometria;
    private File xfile;
    private File directorio;
    public String id;
    private MiImagen ms;
    private ButtonGroup JBGCorrecionOpt;
    private ButtonGroup JBGElementosPro;
    private ButtonGroup JBGEspecialidades;
    private ButtonGroup JBGOptSeguridad;
    private ButtonGroup JBGPrescripcion;
    private ButtonGroup JBGRemision;
    private ButtonGroup JBGTiempoUso;
    private ButtonGroup JBGTipoFiltro;
    private ButtonGroup JBGTipoFiltroConducta;
    private ButtonGroup JBGTipoFiltroRx;
    private ButtonGroup JBGTipoLente;
    private ButtonGroup JBGTipoLenteConducta;
    private ButtonGroup JBGTipoLenteOpt;
    private ButtonGroup JBGTipoVision;
    private JButton JBGuardar;
    private JCheckBox JCArdor;
    private JCheckBox JCDolor;
    private JCheckBox JCFatiga;
    private JCheckBox JCFotofobia;
    private JCheckBox JCHLC;
    private JCheckBox JCHLCotacto;
    private JCheckBox JCHLO;
    private JCheckBox JCHLOftalmico;
    private JCheckBox JCHVL;
    private JCheckBox JCHVP;
    private JCheckBox JCHiperemia;
    private JCheckBox JCLagrimeo;
    private JCheckBox JCNInguno;
    private JCheckBox JCNistagmus;
    private JCheckBox JCPinguecula;
    private JCheckBox JCPterigio;
    private JCheckBox JCPtosis;
    private JCheckBox JCSaltoR;
    private JCheckBox JCSecrecion;
    private JCheckBox JCVisionD;
    private JCheckBox JCVisionVC;
    private JCheckBox JCVisionVL;
    private JCheckBox JChcefalia;
    private JCheckBox JCotros;
    private JDateChooser JDFechaCambio;
    JLabel JLB_Id;
    private JLabel JLImagen;
    private JLabel JLTrianguloAdd;
    private JCheckBox JOtros;
    private JPanel JP;
    private JPanel JPAgudezaVisual;
    private JPanel JPDatos;
    private JPanel JPGrafica;
    private JPanel JPGrafica1;
    private JPanel JPITipoLentes;
    private JPanel JPITipoLentes1;
    private JPanel JPITipoLentes2;
    private JPanel JPITipoLentes3;
    private JPanel JPITipoLentes4;
    private JPanel JPITipoLentes5;
    private JPanel JPSintomas;
    private JPanel JPSintomas1;
    private JPanel JPSintomas2;
    private JPanel JPVisionProxima;
    private JPanel JPVisionProxima1;
    private JPanel JPVisionProxima2;
    private JPanel JPVisionProxima3;
    private JPanel JPVisionProxima4;
    private JPanel JPVisionProxima5;
    private JPanel JPVisionProxima6;
    private JPanel JPVisionlejana;
    private JRadioButton JRBDGTLBifocales;
    private JRadioButton JRBDGTLBifocalesConducta;
    private JRadioButton JRBDGTLBifocalesRx;
    private JRadioButton JRBDGTLMonofocales;
    private JRadioButton JRBDGTLMonofocalesConducta;
    private JRadioButton JRBDGTLMonofocalesRx;
    private JRadioButton JRBDGTLNinguno;
    private JRadioButton JRBDGTLNingunoConducta;
    private JRadioButton JRBDGTLNingunoRx;
    private JRadioButton JRBDGTLProgresivo;
    private JRadioButton JRBDGTLProgresivoConducta;
    private JRadioButton JRBDGTLProgresivoRx;
    private JRadioButton JRBEsporadico;
    private JRadioButton JRBGrado;
    private JRadioButton JRBGradoConducta;
    private JRadioButton JRBGradoRx;
    private JRadioButton JRBNinguno;
    private JRadioButton JRBNingunoConducta;
    private JRadioButton JRBNingunoRx;
    private JRadioButton JRBNoCorrecionOpt;
    private JRadioButton JRBNoElementos;
    private JRadioButton JRBNoPrescipcion;
    private JRadioButton JRBNoRxSeguridad;
    private JRadioButton JRBPermanente;
    private JRadioButton JRBSTransicionConducta;
    private JRadioButton JRBSTransicionRx;
    private JRadioButton JRBSiCorrecionOpt;
    private JRadioButton JRBSiElementos;
    private JRadioButton JRBSiPrescipcion;
    private JRadioButton JRBSiRxSeguridad;
    private JRadioButton JRBTransicion;
    private JRadioButton JRBUV;
    private JRadioButton JRBUVConducta;
    private JRadioButton JRBUVRx;
    private JCheckBox JSecrecion;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacion1;
    private JTextField JTFColor;
    private JTextField JTFLensometroOI;
    private JTextField JTFOAPersonalVL;
    private JTextField JTFOAPersonalVP;
    private JTextField JTFOASCVL;
    private JTextField JTFOASCVP;
    private JTextField JTFOASeguridadVL;
    private JTextField JTFOASeguridadVP;
    private JTextField JTFODAV;
    private JTextField JTFODAVRet;
    private JTextField JTFODAVRxFinal;
    private JTextField JTFODAVRxFinalVP;
    private JTextField JTFODAVRxUso;
    private JTextField JTFODAVSub;
    private JTextField JTFODAddRxFinal;
    private JTextField JTFODAddRxFinalVP;
    private JTextField JTFODCilindro;
    private JTextField JTFODCilindroRet;
    private JTextField JTFODCilindroRxFinal;
    private JTextField JTFODCilindroRxFinalVP;
    private JTextField JTFODCilindroRxUso;
    private JTextField JTFODCilindroSub;
    private JTextField JTFODEje;
    private JTextField JTFODEjeRet;
    private JTextField JTFODEjeRxFinal;
    private JTextField JTFODEjeRxFinalVP;
    private JTextField JTFODEjeRxUso;
    private JTextField JTFODEjeSub;
    private JTextField JTFODEsfera;
    private JTextField JTFODEsferaRet;
    private JTextField JTFODEsferaRxFinal;
    private JTextField JTFODEsferaRxFinalVP;
    private JTextField JTFODEsferaRxUso;
    private JTextField JTFODEsferaSub;
    private JTextField JTFODPersonalVL;
    private JTextField JTFODPersonalVP;
    private JTextField JTFODSCVL;
    private JTextField JTFODSCVP;
    private JTextField JTFODSeguridadVL;
    private JTextField JTFODSeguridadVP;
    private JTextField JTFOIAV;
    private JTextField JTFOIAVRet;
    private JTextField JTFOIAVRxFinal;
    private JTextField JTFOIAVRxFinalVP;
    private JTextField JTFOIAVRxUso;
    private JTextField JTFOIAVSub;
    private JTextField JTFOIAddRxFinal;
    private JTextField JTFOIAddRxFinalVP;
    private JTextField JTFOICilindro;
    private JTextField JTFOICilindroRet;
    private JTextField JTFOICilindroRxFinal;
    private JTextField JTFOICilindroRxFinalVP;
    private JTextField JTFOICilindroRxUso;
    private JTextField JTFOICilindroSub;
    private JTextField JTFOIEje;
    private JTextField JTFOIEjeRet;
    private JTextField JTFOIEjeRxFinal;
    private JTextField JTFOIEjeRxFinalVP;
    private JTextField JTFOIEjeRxUso;
    private JTextField JTFOIEjeSub;
    private JTextField JTFOIEsfera;
    private JTextField JTFOIEsferaRet;
    private JTextField JTFOIEsferaRxFinal;
    private JTextField JTFOIEsferaRxFinalVP;
    private JTextField JTFOIEsferaRxUso;
    private JTextField JTFOIEsferaSub;
    private JTextField JTFOIPersonalVL;
    private JTextField JTFOIPersonalVP;
    private JTextField JTFOISCVL;
    private JTextField JTFOISCVP;
    private JTextField JTFOISeguridadVL;
    private JTextField JTFOISeguridadVP;
    private JTextArea JTHallazgos;
    private JTextField JTLensometroOD;
    private JTabbedPane JTPaneDatos;
    private JTextField JTQueratometroOD;
    private JTextField JTQueratometroOI;
    private JCheckBox JhIPEREMIA;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private ButtonGroup buttonGroup5;
    private ButtonGroup buttonGroup6;
    private JPanel contenedor;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel6;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel66;
    private JLabel jLabel67;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton10;
    private JRadioButton jRadioButton11;
    private JRadioButton jRadioButton12;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JRadioButton jRadioButton7;
    private JRadioButton jRadioButton8;
    private JRadioButton jRadioButton9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JPanel jpDiagnostico;
    public com.genoma.plus.dao.historia.JPADiagnostico aDiagnostico = null;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xprescripcion = 0;
    private long xlo = 0;
    private long xlc = 0;
    private long xtiempouso = 0;
    private long xtipovision = 0;
    private long xtipolenterxuso = 0;
    private long xtipofiltrorxuso = 3;
    private long xRxOpticaSeg = 0;
    private long xTipoLenteOpticaSeg = 0;
    private long xTipoFiltroOpticaSeg = 3;
    private long xcorrecionOptica = 0;
    private long xlenteOftalmico = 0;
    private long xlenteContacto = 0;
    private long xelementoProteccion = 0;
    private long xtipolenteElemento = 0;
    private long xtipofiltroElemento = 3;
    private long xremision = 0;
    private long xespecialidad = 0;
    private long xEstadoHC = 0;
    private int contador_de_objetos = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    String adjunto = "";
    String xsql1 = "";
    private final Metodos xmetodo = new Metodos();
    JList points = new JList();
    private long xcefalea = 0;
    private long xladrimeo = 0;
    private long xardor = 0;
    private long xdolor = 0;
    private long xsecrecion = 0;
    private long xhiperemia = 0;
    private long visionVL = 0;
    private long xvisionVC = 0;
    private long xfotofobia = 0;
    private long xfatigaV = 0;
    private long xvisiondoble = 0;
    private long xsaltoR = 0;
    private long xotros = 0;
    private long xninguno = 0;
    private long xptrigio = 0;
    private long xpinguecula = 0;
    private long xptosis = 0;
    private long ysecrecion = 0;
    private long yhiperemia = 0;
    private long xnistagmus = 0;
    private long yotros = 0;
    private long xoftalmoscopiaOD = 0;
    private long xoftalmoscopiaOI = 0;
    private long xhallazgos = 0;
    private long xqueratometroOD = 0;
    private long xqueratometroOI = 0;
    private long xlensometroOD = 0;
    private long xlensometroOI = 0;
    private long xtest = 0;
    private long xvcromatica = 0;
    private long xcampovisialOD = 1;
    private long xcampovisialOI = 1;
    private String xid = "0";
    private DefaultListModel listModel = new DefaultListModel();

    public JPSo_Optometria(clasesHistoriaCE xclase) {
        this.xoptometria = "";
        this.id = "";
        initComponents();
        this.id = this.JLB_Id.getText();
        this.xclase = xclase;
        this.JDFechaCambio.setDate(this.xmt.getFechaActual());
        this.xoptometria = this.JLB_Id.getText();
        System.out.println("el id: " + this.JLB_Id.getText());
        mBuscarDatosBd();
        cargarDiagnostico();
        this.ms = new MiImagen(this.contenedor, this.listModel);
        this.points.setModel(this.listModel);
        this.JPGrafica.setVisible(false);
        radios();
        this.JTPaneDatos.remove(3);
    }

    private void cargarDiagnostico() {
        if (this.aDiagnostico == null) {
            this.aDiagnostico = new com.genoma.plus.dao.historia.JPADiagnostico(this);
        }
        this.aDiagnostico.setBounds(1, 1, 780, 250);
        this.jpDiagnostico.add(this.aDiagnostico);
        this.aDiagnostico.setVisible(true);
    }

    private void radios() {
        this.buttonGroup1.add(this.jRadioButton1);
        this.buttonGroup1.add(this.jRadioButton2);
        this.buttonGroup2.add(this.jRadioButton3);
        this.buttonGroup2.add(this.jRadioButton4);
        this.buttonGroup3.add(this.jRadioButton5);
        this.buttonGroup3.add(this.jRadioButton6);
        this.buttonGroup4.add(this.jRadioButton7);
        this.buttonGroup4.add(this.jRadioButton8);
        this.buttonGroup5.add(this.jRadioButton9);
        this.buttonGroup5.add(this.jRadioButton10);
        this.buttonGroup6.add(this.jRadioButton11);
        this.buttonGroup6.add(this.jRadioButton12);
    }

    private void initComponents() {
        this.JBGPrescripcion = new ButtonGroup();
        this.JBGTiempoUso = new ButtonGroup();
        this.JBGTipoVision = new ButtonGroup();
        this.JBGTipoLente = new ButtonGroup();
        this.JBGOptSeguridad = new ButtonGroup();
        this.JBGTipoLenteOpt = new ButtonGroup();
        this.JBGTipoFiltro = new ButtonGroup();
        this.JBGTipoFiltroRx = new ButtonGroup();
        this.JBGCorrecionOpt = new ButtonGroup();
        this.JBGElementosPro = new ButtonGroup();
        this.JBGTipoLenteConducta = new ButtonGroup();
        this.JBGTipoFiltroConducta = new ButtonGroup();
        this.JBGRemision = new ButtonGroup();
        this.JBGEspecialidades = new ButtonGroup();
        this.jPanel10 = new JPanel();
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.buttonGroup5 = new ButtonGroup();
        this.buttonGroup6 = new ButtonGroup();
        this.JTPaneDatos = new JTabbedPane();
        this.JPGrafica1 = new JPanel();
        this.jPanel11 = new JPanel();
        this.JPSintomas2 = new JPanel();
        this.JPVisionProxima1 = new JPanel();
        this.jLabel55 = new JLabel();
        this.jLabel56 = new JLabel();
        this.JTFLensometroOI = new JTextField();
        this.JTLensometroOD = new JTextField();
        this.JPVisionProxima2 = new JPanel();
        this.jLabel54 = new JLabel();
        this.jLabel57 = new JLabel();
        this.jRadioButton7 = new JRadioButton();
        this.jRadioButton8 = new JRadioButton();
        this.JPVisionProxima3 = new JPanel();
        this.jLabel60 = new JLabel();
        this.jLabel61 = new JLabel();
        this.JTQueratometroOI = new JTextField();
        this.JTQueratometroOD = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTHallazgos = new JTextArea();
        this.JPVisionProxima4 = new JPanel();
        this.jLabel62 = new JLabel();
        this.jLabel63 = new JLabel();
        this.jLabel64 = new JLabel();
        this.jLabel65 = new JLabel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jRadioButton3 = new JRadioButton();
        this.jRadioButton4 = new JRadioButton();
        this.JPVisionProxima5 = new JPanel();
        this.jLabel58 = new JLabel();
        this.jLabel59 = new JLabel();
        this.jRadioButton5 = new JRadioButton();
        this.jRadioButton6 = new JRadioButton();
        this.JPVisionProxima6 = new JPanel();
        this.jLabel66 = new JLabel();
        this.jLabel67 = new JLabel();
        this.jLabel68 = new JLabel();
        this.jLabel69 = new JLabel();
        this.jRadioButton9 = new JRadioButton();
        this.jRadioButton10 = new JRadioButton();
        this.jRadioButton11 = new JRadioButton();
        this.jRadioButton12 = new JRadioButton();
        this.JPSintomas = new JPanel();
        this.JChcefalia = new JCheckBox();
        this.JCotros = new JCheckBox();
        this.JCHiperemia = new JCheckBox();
        this.JCSecrecion = new JCheckBox();
        this.JCLagrimeo = new JCheckBox();
        this.JCArdor = new JCheckBox();
        this.JCDolor = new JCheckBox();
        this.JCVisionD = new JCheckBox();
        this.JCSaltoR = new JCheckBox();
        this.JCFatiga = new JCheckBox();
        this.JCFotofobia = new JCheckBox();
        this.JCVisionVC = new JCheckBox();
        this.JCNInguno = new JCheckBox();
        this.JCVisionVL = new JCheckBox();
        this.JPSintomas1 = new JPanel();
        this.JCPterigio = new JCheckBox();
        this.JCNistagmus = new JCheckBox();
        this.JhIPEREMIA = new JCheckBox();
        this.JCPinguecula = new JCheckBox();
        this.JCPtosis = new JCheckBox();
        this.JSecrecion = new JCheckBox();
        this.JOtros = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion1 = new JTextArea();
        this.JPDatos = new JPanel();
        this.jPanel1 = new JPanel();
        this.JRBSiPrescipcion = new JRadioButton();
        this.JRBNoPrescipcion = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JCHLO = new JCheckBox();
        this.JCHLC = new JCheckBox();
        this.jLabel3 = new JLabel();
        this.JRBPermanente = new JRadioButton();
        this.JRBEsporadico = new JRadioButton();
        this.JCHVL = new JCheckBox();
        this.JCHVP = new JCheckBox();
        this.JPITipoLentes = new JPanel();
        this.JRBDGTLNinguno = new JRadioButton();
        this.JRBDGTLProgresivo = new JRadioButton();
        this.JRBDGTLBifocales = new JRadioButton();
        this.JRBDGTLMonofocales = new JRadioButton();
        this.jLabel5 = new JLabel();
        this.JRBSiRxSeguridad = new JRadioButton();
        this.JRBNoRxSeguridad = new JRadioButton();
        this.JPITipoLentes1 = new JPanel();
        this.JRBDGTLNingunoRx = new JRadioButton();
        this.JRBDGTLProgresivoRx = new JRadioButton();
        this.JRBDGTLBifocalesRx = new JRadioButton();
        this.JRBDGTLMonofocalesRx = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JTFODEsfera = new JTextField();
        this.JTFODCilindro = new JTextField();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.JTFODEje = new JTextField();
        this.JTFODAV = new JTextField();
        this.JTFOIEsfera = new JTextField();
        this.JTFOICilindro = new JTextField();
        this.JTFOIEje = new JTextField();
        this.JTFOIAV = new JTextField();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JPITipoLentes2 = new JPanel();
        this.JRBUV = new JRadioButton();
        this.JRBGrado = new JRadioButton();
        this.JRBTransicion = new JRadioButton();
        this.JRBNinguno = new JRadioButton();
        this.JPITipoLentes3 = new JPanel();
        this.JRBUVRx = new JRadioButton();
        this.JRBGradoRx = new JRadioButton();
        this.JRBSTransicionRx = new JRadioButton();
        this.JRBNingunoRx = new JRadioButton();
        this.jPanel3 = new JPanel();
        this.JTFODEsferaRxUso = new JTextField();
        this.JTFODCilindroRxUso = new JTextField();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.JTFODEjeRxUso = new JTextField();
        this.JTFODAVRxUso = new JTextField();
        this.JTFOIEsferaRxUso = new JTextField();
        this.JTFOICilindroRxUso = new JTextField();
        this.JTFOIEjeRxUso = new JTextField();
        this.JTFOIAVRxUso = new JTextField();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.JPAgudezaVisual = new JPanel();
        this.JPVisionlejana = new JPanel();
        this.JTFODSCVL = new JTextField();
        this.JTFODPersonalVL = new JTextField();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.JTFODSeguridadVL = new JTextField();
        this.JTFOISCVL = new JTextField();
        this.JTFOIPersonalVL = new JTextField();
        this.JTFOISeguridadVL = new JTextField();
        this.jLabel23 = new JLabel();
        this.jLabel24 = new JLabel();
        this.jLabel25 = new JLabel();
        this.JTFOASCVL = new JTextField();
        this.JTFOAPersonalVL = new JTextField();
        this.JTFOASeguridadVL = new JTextField();
        this.JPVisionProxima = new JPanel();
        this.JTFODSCVP = new JTextField();
        this.JTFODPersonalVP = new JTextField();
        this.jLabel22 = new JLabel();
        this.jLabel26 = new JLabel();
        this.jLabel27 = new JLabel();
        this.JTFODSeguridadVP = new JTextField();
        this.JTFOISCVP = new JTextField();
        this.JTFOIPersonalVP = new JTextField();
        this.JTFOISeguridadVP = new JTextField();
        this.jLabel28 = new JLabel();
        this.jLabel29 = new JLabel();
        this.jLabel30 = new JLabel();
        this.JTFOASCVP = new JTextField();
        this.JTFOAPersonalVP = new JTextField();
        this.JTFOASeguridadVP = new JTextField();
        this.JLB_Id = new JLabel();
        this.JDFechaCambio = new JDateChooser();
        this.jPanel4 = new JPanel();
        this.JP = new JPanel();
        this.jLabel31 = new JLabel();
        this.JTFODEsferaRet = new JTextField();
        this.jLabel33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.JTFODCilindroRet = new JTextField();
        this.JTFODEjeRet = new JTextField();
        this.JTFODAVRet = new JTextField();
        this.JTFOIEsferaRet = new JTextField();
        this.JTFOICilindroRet = new JTextField();
        this.JTFOIEjeRet = new JTextField();
        this.JTFOIAVRet = new JTextField();
        this.jLabel37 = new JLabel();
        this.JTFODEsferaRxFinal = new JTextField();
        this.JTFODCilindroRxFinal = new JTextField();
        this.JTFODEjeRxFinal = new JTextField();
        this.JTFODAddRxFinal = new JTextField();
        this.JTFODAVRxFinal = new JTextField();
        this.JTFOIAVRxFinal = new JTextField();
        this.JTFOIAddRxFinal = new JTextField();
        this.JTFOIEjeRxFinal = new JTextField();
        this.JTFOICilindroRxFinal = new JTextField();
        this.JTFOIEsferaRxFinal = new JTextField();
        this.JTFODEsferaRxFinalVP = new JTextField();
        this.JTFODCilindroRxFinalVP = new JTextField();
        this.JTFODEjeRxFinalVP = new JTextField();
        this.JTFODAddRxFinalVP = new JTextField();
        this.JTFODAVRxFinalVP = new JTextField();
        this.JTFOIAVRxFinalVP = new JTextField();
        this.JTFOIAddRxFinalVP = new JTextField();
        this.JTFOIEjeRxFinalVP = new JTextField();
        this.JTFOICilindroRxFinalVP = new JTextField();
        this.JTFOIEsferaRxFinalVP = new JTextField();
        this.jLabel32 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel38 = new JLabel();
        this.jLabel40 = new JLabel();
        this.jLabel42 = new JLabel();
        this.jLabel43 = new JLabel();
        this.jLabel46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.jLabel45 = new JLabel();
        this.jLabel48 = new JLabel();
        this.JTFODEsferaSub = new JTextField();
        this.JTFOIEsferaSub = new JTextField();
        this.JTFODCilindroSub = new JTextField();
        this.JTFOICilindroSub = new JTextField();
        this.JTFODEjeSub = new JTextField();
        this.JTFOIEjeSub = new JTextField();
        this.JTFODAVSub = new JTextField();
        this.JTFOIAVSub = new JTextField();
        this.jLabel41 = new JLabel();
        this.jLabel44 = new JLabel();
        this.jLabel49 = new JLabel();
        this.jLabel51 = new JLabel();
        this.jLabel52 = new JLabel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.JRBSiCorrecionOpt = new JRadioButton();
        this.JRBNoCorrecionOpt = new JRadioButton();
        this.JCHLOftalmico = new JCheckBox();
        this.JCHLCotacto = new JCheckBox();
        this.jPanel6 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JRBSiElementos = new JRadioButton();
        this.JRBNoElementos = new JRadioButton();
        this.JPITipoLentes4 = new JPanel();
        this.JRBDGTLNingunoConducta = new JRadioButton();
        this.JRBDGTLProgresivoConducta = new JRadioButton();
        this.JRBDGTLBifocalesConducta = new JRadioButton();
        this.JRBDGTLMonofocalesConducta = new JRadioButton();
        this.JPITipoLentes5 = new JPanel();
        this.JRBUVConducta = new JRadioButton();
        this.JRBGradoConducta = new JRadioButton();
        this.JRBSTransicionConducta = new JRadioButton();
        this.JRBNingunoConducta = new JRadioButton();
        this.JTFColor = new JTextField();
        this.jpDiagnostico = new JPanel();
        this.JPGrafica = new JPanel();
        this.jPanel7 = new JPanel();
        this.jPanel8 = new JPanel();
        this.JLTrianguloAdd = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel39 = new JLabel();
        this.jPanel9 = new JPanel();
        this.contenedor = new JPanel();
        this.JLImagen = new JLabel();
        this.JBGuardar = new JButton();
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setName("jpsooptometria");
        this.JTPaneDatos.setForeground(new Color(255, 0, 0));
        this.JTPaneDatos.setFont(new Font("Arial", 1, 14));
        this.JPGrafica1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.JPSintomas2.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPVisionProxima1.setBorder(BorderFactory.createTitledBorder((Border) null, "Lensometro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel55.setFont(new Font("Arial", 1, 12));
        this.jLabel55.setText("O.D.");
        this.jLabel56.setFont(new Font("Arial", 1, 12));
        this.jLabel56.setText("O.I.");
        this.JTFLensometroOI.setFont(new Font("Arial", 1, 12));
        this.JTFLensometroOI.setHorizontalAlignment(2);
        this.JTFLensometroOI.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTLensometroOD.setFont(new Font("Arial", 1, 12));
        this.JTLensometroOD.setHorizontalAlignment(2);
        this.JTLensometroOD.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPVisionProxima1Layout = new GroupLayout(this.JPVisionProxima1);
        this.JPVisionProxima1.setLayout(JPVisionProxima1Layout);
        JPVisionProxima1Layout.setHorizontalGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel55, -2, 33, -2).addComponent(this.jLabel56, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFLensometroOI, -2, 84, -2).addComponent(this.JTLensometroOD, -2, 84, -2)).addContainerGap(20, 32767)));
        JPVisionProxima1Layout.setVerticalGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel55).addComponent(this.JTLensometroOD, -2, -1, -2)).addGap(14, 14, 14).addGroup(JPVisionProxima1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel56).addComponent(this.JTFLensometroOI, -2, -1, -2)).addGap(0, 5, 32767)));
        this.JPVisionProxima2.setBorder(BorderFactory.createTitledBorder((Border) null, " visión cromatica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel54.setFont(new Font("Arial", 1, 12));
        this.jLabel54.setHorizontalAlignment(0);
        this.jLabel54.setText("N");
        this.jLabel57.setFont(new Font("Arial", 1, 12));
        this.jLabel57.setHorizontalAlignment(0);
        this.jLabel57.setText("A");
        this.jRadioButton7.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton7ActionPerformed(evt);
            }
        });
        this.jRadioButton8.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton8ActionPerformed(evt);
            }
        });
        GroupLayout JPVisionProxima2Layout = new GroupLayout(this.JPVisionProxima2);
        this.JPVisionProxima2.setLayout(JPVisionProxima2Layout);
        JPVisionProxima2Layout.setHorizontalGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima2Layout.createSequentialGroup().addContainerGap().addGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel54, -2, 19, -2).addComponent(this.jRadioButton7)).addGap(26, 26, 26).addGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel57, -2, 31, -2).addGroup(JPVisionProxima2Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jRadioButton8))).addContainerGap(28, 32767)));
        JPVisionProxima2Layout.setVerticalGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima2Layout.createSequentialGroup().addGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel54).addComponent(this.jLabel57)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPVisionProxima2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton7).addComponent(this.jRadioButton8)).addContainerGap()));
        this.JPVisionProxima3.setBorder(BorderFactory.createTitledBorder((Border) null, "Queratometro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel60.setFont(new Font("Arial", 1, 12));
        this.jLabel60.setText("O.D.");
        this.jLabel61.setFont(new Font("Arial", 1, 12));
        this.jLabel61.setText("O.I.");
        this.JTQueratometroOI.setFont(new Font("Arial", 1, 12));
        this.JTQueratometroOI.setHorizontalAlignment(2);
        this.JTQueratometroOI.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTQueratometroOD.setFont(new Font("Arial", 1, 12));
        this.JTQueratometroOD.setHorizontalAlignment(2);
        this.JTQueratometroOD.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPVisionProxima3Layout = new GroupLayout(this.JPVisionProxima3);
        this.JPVisionProxima3.setLayout(JPVisionProxima3Layout);
        JPVisionProxima3Layout.setHorizontalGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel60, -2, 33, -2).addComponent(this.jLabel61, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTQueratometroOI, -2, 84, -2).addComponent(this.JTQueratometroOD, -2, 84, -2)).addContainerGap(20, 32767)));
        JPVisionProxima3Layout.setVerticalGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima3Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel60).addComponent(this.JTQueratometroOD, -2, -1, -2)).addGap(14, 14, 14).addGroup(JPVisionProxima3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel61).addComponent(this.JTQueratometroOI, -2, -1, -2)).addGap(0, 5, 32767)));
        this.JTHallazgos.setColumns(1);
        this.JTHallazgos.setFont(new Font("Arial", 1, 12));
        this.JTHallazgos.setRows(1);
        this.JTHallazgos.setBorder(BorderFactory.createTitledBorder((Border) null, "Hallazgos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTHallazgos);
        this.JPVisionProxima4.setBorder(BorderFactory.createTitledBorder((Border) null, "Oftalmoscopia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel62.setFont(new Font("Arial", 1, 12));
        this.jLabel62.setHorizontalAlignment(0);
        this.jLabel62.setText("N");
        this.jLabel63.setFont(new Font("Arial", 1, 12));
        this.jLabel63.setHorizontalAlignment(0);
        this.jLabel63.setText("A");
        this.jLabel64.setFont(new Font("Arial", 1, 12));
        this.jLabel64.setText("O.D.");
        this.jLabel65.setFont(new Font("Arial", 1, 12));
        this.jLabel65.setText("O.I.");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.jRadioButton3.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton3ActionPerformed(evt);
            }
        });
        this.jRadioButton4.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton4ActionPerformed(evt);
            }
        });
        GroupLayout JPVisionProxima4Layout = new GroupLayout(this.JPVisionProxima4);
        this.JPVisionProxima4.setLayout(JPVisionProxima4Layout);
        JPVisionProxima4Layout.setHorizontalGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima4Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel64, -2, 33, -2).addComponent(this.jLabel65, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel62, -2, 19, -2).addComponent(this.jRadioButton1).addComponent(this.jRadioButton3)).addGap(22, 22, 22).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel63, -2, 31, -2).addGroup(JPVisionProxima4Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton2).addComponent(this.jRadioButton4)))).addContainerGap(-1, 32767)));
        JPVisionProxima4Layout.setVerticalGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima4Layout.createSequentialGroup().addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel62).addComponent(this.jLabel63)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPVisionProxima4Layout.createSequentialGroup().addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton1).addComponent(this.jLabel64)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel65).addComponent(this.jRadioButton3))).addGroup(JPVisionProxima4Layout.createSequentialGroup().addComponent(this.jRadioButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton4))).addGap(0, 16, 32767)));
        this.JPVisionProxima5.setBorder(BorderFactory.createTitledBorder((Border) null, "Test Estereopsis", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel58.setFont(new Font("Arial", 1, 12));
        this.jLabel58.setHorizontalAlignment(0);
        this.jLabel58.setText("N");
        this.jLabel59.setFont(new Font("Arial", 1, 12));
        this.jLabel59.setHorizontalAlignment(0);
        this.jLabel59.setText("A");
        this.jRadioButton5.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton5ActionPerformed(evt);
            }
        });
        this.jRadioButton6.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton6ActionPerformed(evt);
            }
        });
        GroupLayout JPVisionProxima5Layout = new GroupLayout(this.JPVisionProxima5);
        this.JPVisionProxima5.setLayout(JPVisionProxima5Layout);
        JPVisionProxima5Layout.setHorizontalGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima5Layout.createSequentialGroup().addContainerGap().addGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel58, -2, 19, -2).addComponent(this.jRadioButton6)).addGap(26, 26, 26).addGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel59, -2, 31, -2).addGroup(JPVisionProxima5Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jRadioButton5))).addContainerGap(28, 32767)));
        JPVisionProxima5Layout.setVerticalGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima5Layout.createSequentialGroup().addGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel58).addComponent(this.jLabel59)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton5).addComponent(this.jRadioButton6)).addContainerGap()));
        this.JPVisionProxima6.setBorder(BorderFactory.createTitledBorder((Border) null, "Campo Visual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel66.setFont(new Font("Arial", 1, 12));
        this.jLabel66.setHorizontalAlignment(0);
        this.jLabel66.setText("N");
        this.jLabel67.setFont(new Font("Arial", 1, 12));
        this.jLabel67.setHorizontalAlignment(0);
        this.jLabel67.setText("A");
        this.jLabel68.setFont(new Font("Arial", 1, 12));
        this.jLabel68.setText("O.D.");
        this.jLabel69.setFont(new Font("Arial", 1, 12));
        this.jLabel69.setText("O.I.");
        this.jRadioButton9.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton9ActionPerformed(evt);
            }
        });
        this.jRadioButton10.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton10ActionPerformed(evt);
            }
        });
        this.jRadioButton11.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton11ActionPerformed(evt);
            }
        });
        this.jRadioButton12.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.12
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.jRadioButton12ActionPerformed(evt);
            }
        });
        GroupLayout JPVisionProxima6Layout = new GroupLayout(this.JPVisionProxima6);
        this.JPVisionProxima6.setLayout(JPVisionProxima6Layout);
        JPVisionProxima6Layout.setHorizontalGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima6Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel69, -1, -1, 32767).addComponent(this.jLabel68, -1, 33, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPVisionProxima6Layout.createSequentialGroup().addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton11).addComponent(this.jRadioButton9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jRadioButton12).addComponent(this.jRadioButton10, GroupLayout.Alignment.LEADING))).addGroup(JPVisionProxima6Layout.createSequentialGroup().addComponent(this.jLabel66, -2, 19, -2).addGap(31, 31, 31).addComponent(this.jLabel67, -2, 17, -2))).addContainerGap(-1, 32767)));
        JPVisionProxima6Layout.setVerticalGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima6Layout.createSequentialGroup().addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel66).addComponent(this.jLabel67)).addGap(7, 7, 7).addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProxima6Layout.createSequentialGroup().addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel68).addComponent(this.jRadioButton9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProxima6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel69).addComponent(this.jRadioButton11))).addGroup(JPVisionProxima6Layout.createSequentialGroup().addComponent(this.jRadioButton10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton12)))));
        GroupLayout JPSintomas2Layout = new GroupLayout(this.JPSintomas2);
        this.JPSintomas2.setLayout(JPSintomas2Layout);
        JPSintomas2Layout.setHorizontalGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomas2Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPVisionProxima6, -1, -1, 32767).addComponent(this.JPVisionProxima4, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomas2Layout.createSequentialGroup().addComponent(this.JPVisionProxima3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767).addComponent(this.JPVisionProxima1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPVisionProxima5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPVisionProxima2, -2, -1, -2)).addComponent(this.jScrollPane3)).addContainerGap()));
        JPSintomas2Layout.setVerticalGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomas2Layout.createSequentialGroup().addContainerGap().addGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPVisionProxima1, -2, -1, -2).addComponent(this.JPVisionProxima4, -2, -1, -2).addGroup(JPSintomas2Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPVisionProxima5, -1, -1, 32767).addComponent(this.JPVisionProxima2, -1, -1, 32767))).addComponent(this.JPVisionProxima3, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPSintomas2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPVisionProxima6, -1, -1, 32767).addComponent(this.jScrollPane3)).addContainerGap(-1, 32767)));
        this.JPSintomas.setBorder(BorderFactory.createTitledBorder((Border) null, "Sintomas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JChcefalia.setFont(new Font("Arial", 1, 11));
        this.JChcefalia.setText("Cefalea");
        this.JChcefalia.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JChcefaliaActionPerformed(evt);
            }
        });
        this.JCotros.setFont(new Font("Arial", 1, 11));
        this.JCotros.setText("Otros");
        this.JCotros.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCotrosActionPerformed(evt);
            }
        });
        this.JCHiperemia.setFont(new Font("Arial", 1, 11));
        this.JCHiperemia.setText("Hiperemia");
        this.JCHiperemia.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHiperemiaActionPerformed(evt);
            }
        });
        this.JCSecrecion.setFont(new Font("Arial", 1, 11));
        this.JCSecrecion.setText("Secreción ");
        this.JCSecrecion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCSecrecionActionPerformed(evt);
            }
        });
        this.JCLagrimeo.setFont(new Font("Arial", 1, 11));
        this.JCLagrimeo.setText("LaGrimeo");
        this.JCLagrimeo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCLagrimeoActionPerformed(evt);
            }
        });
        this.JCArdor.setFont(new Font("Arial", 1, 11));
        this.JCArdor.setText("Ardor");
        this.JCArdor.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCArdorActionPerformed(evt);
            }
        });
        this.JCDolor.setFont(new Font("Arial", 1, 11));
        this.JCDolor.setText("Dolor");
        this.JCDolor.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCDolorActionPerformed(evt);
            }
        });
        this.JCVisionD.setFont(new Font("Arial", 1, 11));
        this.JCVisionD.setText("visión doble");
        this.JCVisionD.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCVisionDActionPerformed(evt);
            }
        });
        this.JCSaltoR.setFont(new Font("Arial", 1, 11));
        this.JCSaltoR.setText("Salto de renglón");
        this.JCSaltoR.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCSaltoRActionPerformed(evt);
            }
        });
        this.JCFatiga.setFont(new Font("Arial", 1, 11));
        this.JCFatiga.setText("Fatiga visual");
        this.JCFatiga.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCFatigaActionPerformed(evt);
            }
        });
        this.JCFotofobia.setFont(new Font("Arial", 1, 11));
        this.JCFotofobia.setText("Fotofobia");
        this.JCFotofobia.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCFotofobiaActionPerformed(evt);
            }
        });
        this.JCVisionVC.setFont(new Font("Arial", 1, 11));
        this.JCVisionVC.setText("visión borrosa VC");
        this.JCVisionVC.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCVisionVCActionPerformed(evt);
            }
        });
        this.JCNInguno.setFont(new Font("Arial", 1, 11));
        this.JCNInguno.setText("NInguno");
        this.JCNInguno.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCNIngunoActionPerformed(evt);
            }
        });
        this.JCVisionVL.setFont(new Font("Arial", 1, 11));
        this.JCVisionVL.setText("visión borrosa VL");
        this.JCVisionVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCVisionVLActionPerformed(evt);
            }
        });
        GroupLayout JPSintomasLayout = new GroupLayout(this.JPSintomas);
        this.JPSintomas.setLayout(JPSintomasLayout);
        JPSintomasLayout.setHorizontalGroup(JPSintomasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomasLayout.createSequentialGroup().addContainerGap().addGroup(JPSintomasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomasLayout.createSequentialGroup().addComponent(this.JCFotofobia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCFatiga, -2, 98, -2).addGap(18, 18, 18).addComponent(this.JCVisionD).addGap(30, 30, 30).addComponent(this.JCSaltoR, -2, 115, -2).addGap(18, 18, 18).addComponent(this.JCotros, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCNInguno, -2, 73, -2)).addGroup(JPSintomasLayout.createSequentialGroup().addComponent(this.JChcefalia, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCLagrimeo, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCArdor, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCDolor, -2, 73, -2).addGap(12, 12, 12).addComponent(this.JCSecrecion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHiperemia, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCVisionVL).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCVisionVC))).addContainerGap(-1, 32767)));
        JPSintomasLayout.setVerticalGroup(JPSintomasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomasLayout.createSequentialGroup().addContainerGap().addGroup(JPSintomasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JChcefalia).addComponent(this.JCLagrimeo).addComponent(this.JCArdor).addComponent(this.JCDolor).addComponent(this.JCSecrecion).addComponent(this.JCHiperemia).addComponent(this.JCVisionVL).addComponent(this.JCVisionVC)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPSintomasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCFotofobia).addComponent(this.JCFatiga).addComponent(this.JCVisionD).addComponent(this.JCSaltoR).addComponent(this.JCotros).addComponent(this.JCNInguno)).addContainerGap(22, 32767)));
        this.JPSintomas1.setBorder(BorderFactory.createTitledBorder((Border) null, "Examen Externo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCPterigio.setFont(new Font("Arial", 1, 11));
        this.JCPterigio.setText("Pterigio");
        this.JCPterigio.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCPterigioActionPerformed(evt);
            }
        });
        this.JCNistagmus.setFont(new Font("Arial", 1, 11));
        this.JCNistagmus.setText("Nistagmus");
        this.JCNistagmus.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCNistagmusActionPerformed(evt);
            }
        });
        this.JhIPEREMIA.setFont(new Font("Arial", 1, 11));
        this.JhIPEREMIA.setText("Hiperemia");
        this.JhIPEREMIA.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JhIPEREMIAActionPerformed(evt);
            }
        });
        this.JCPinguecula.setFont(new Font("Arial", 1, 11));
        this.JCPinguecula.setText("Pinguecula");
        this.JCPinguecula.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCPingueculaActionPerformed(evt);
            }
        });
        this.JCPtosis.setFont(new Font("Arial", 1, 11));
        this.JCPtosis.setText("Ptosis");
        this.JCPtosis.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCPtosisActionPerformed(evt);
            }
        });
        this.JSecrecion.setFont(new Font("Arial", 1, 11));
        this.JSecrecion.setText("Secreción ");
        this.JSecrecion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JSecrecionActionPerformed(evt);
            }
        });
        this.JOtros.setFont(new Font("Arial", 1, 11));
        this.JOtros.setText("Otros");
        this.JOtros.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JOtrosActionPerformed(evt);
            }
        });
        this.JTAObservacion1.setColumns(1);
        this.JTAObservacion1.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion1.setRows(1);
        this.JTAObservacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacion1);
        GroupLayout JPSintomas1Layout = new GroupLayout(this.JPSintomas1);
        this.JPSintomas1.setLayout(JPSintomas1Layout);
        JPSintomas1Layout.setHorizontalGroup(JPSintomas1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomas1Layout.createSequentialGroup().addContainerGap().addGroup(JPSintomas1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(JPSintomas1Layout.createSequentialGroup().addComponent(this.JCPterigio, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCPinguecula, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCPtosis, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSecrecion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JhIPEREMIA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCNistagmus, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JOtros).addGap(0, 0, 32767))).addContainerGap()));
        JPSintomas1Layout.setVerticalGroup(JPSintomas1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSintomas1Layout.createSequentialGroup().addContainerGap().addGroup(JPSintomas1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCPterigio).addComponent(this.JCPinguecula).addComponent(this.JCPtosis).addComponent(this.JSecrecion).addComponent(this.JhIPEREMIA).addComponent(this.JCNistagmus).addComponent(this.JOtros)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 61, -2).addContainerGap(-1, 32767)));
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPSintomas, -1, -1, 32767).addComponent(this.JPSintomas1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPSintomas2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.JPSintomas, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPSintomas1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSintomas2, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout JPGrafica1Layout = new GroupLayout(this.JPGrafica1);
        this.JPGrafica1.setLayout(JPGrafica1Layout);
        JPGrafica1Layout.setHorizontalGroup(JPGrafica1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPGrafica1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -1, -1, 32767).addContainerGap()));
        JPGrafica1Layout.setVerticalGroup(JPGrafica1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGrafica1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -2, -1, -2).addContainerGap(15, 32767)));
        this.JTPaneDatos.addTab("PARTE 1", this.JPGrafica1);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JBGPrescripcion.add(this.JRBSiPrescipcion);
        this.JRBSiPrescipcion.setFont(new Font("Arial", 1, 11));
        this.JRBSiPrescipcion.setText("Sí");
        this.JRBSiPrescipcion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSiPrescipcionActionPerformed(evt);
            }
        });
        this.JBGPrescripcion.add(this.JRBNoPrescipcion);
        this.JRBNoPrescipcion.setFont(new Font("Arial", 1, 11));
        this.JRBNoPrescipcion.setSelected(true);
        this.JRBNoPrescipcion.setText("No");
        this.JRBNoPrescipcion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNoPrescipcionActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Prescripción");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Tipo de Prescripción:");
        this.JCHLO.setFont(new Font("Arial", 1, 11));
        this.JCHLO.setText("LO");
        this.JCHLO.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHLOActionPerformed(evt);
            }
        });
        this.JCHLC.setFont(new Font("Arial", 1, 11));
        this.JCHLC.setText("LC");
        this.JCHLC.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHLCActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Tiempo de uso:");
        this.JBGTiempoUso.add(this.JRBPermanente);
        this.JRBPermanente.setFont(new Font("Arial", 1, 11));
        this.JRBPermanente.setText("Permanente");
        this.JRBPermanente.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBPermanenteActionPerformed(evt);
            }
        });
        this.JBGTiempoUso.add(this.JRBEsporadico);
        this.JRBEsporadico.setFont(new Font("Arial", 1, 11));
        this.JRBEsporadico.setText("Esporádico");
        this.JRBEsporadico.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBEsporadicoActionPerformed(evt);
            }
        });
        this.JBGTipoVision.add(this.JCHVL);
        this.JCHVL.setFont(new Font("Arial", 1, 11));
        this.JCHVL.setText("VL");
        this.JCHVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHVLActionPerformed(evt);
            }
        });
        this.JBGTipoVision.add(this.JCHVP);
        this.JCHVP.setFont(new Font("Arial", 1, 11));
        this.JCHVP.setText("VP");
        this.JCHVP.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHVPActionPerformed(evt);
            }
        });
        this.JPITipoLentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoLente.add(this.JRBDGTLNinguno);
        this.JRBDGTLNinguno.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLNinguno.setSelected(true);
        this.JRBDGTLNinguno.setText("Ninguno");
        this.JRBDGTLNinguno.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLNingunoActionPerformed(evt);
            }
        });
        this.JBGTipoLente.add(this.JRBDGTLProgresivo);
        this.JRBDGTLProgresivo.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLProgresivo.setText("Progresivo");
        this.JRBDGTLProgresivo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLProgresivoActionPerformed(evt);
            }
        });
        this.JBGTipoLente.add(this.JRBDGTLBifocales);
        this.JRBDGTLBifocales.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLBifocales.setText("Bifocales");
        this.JRBDGTLBifocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLBifocalesActionPerformed(evt);
            }
        });
        this.JBGTipoLente.add(this.JRBDGTLMonofocales);
        this.JRBDGTLMonofocales.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLMonofocales.setText("Monofocales");
        this.JRBDGTLMonofocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLMonofocalesActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentesLayout = new GroupLayout(this.JPITipoLentes);
        this.JPITipoLentes.setLayout(JPITipoLentesLayout);
        JPITipoLentesLayout.setHorizontalGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentesLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBDGTLNinguno).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLProgresivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLBifocales).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDGTLMonofocales, -2, 99, -2).addGap(4, 4, 4)));
        JPITipoLentesLayout.setVerticalGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentesLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTLProgresivo).addComponent(this.JRBDGTLBifocales).addComponent(this.JRBDGTLNinguno).addComponent(this.JRBDGTLMonofocales)).addGap(2, 2, 2)));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Uso de Rx óptica de seguridad");
        this.JBGOptSeguridad.add(this.JRBSiRxSeguridad);
        this.JRBSiRxSeguridad.setFont(new Font("Arial", 1, 11));
        this.JRBSiRxSeguridad.setText("Sí");
        this.JRBSiRxSeguridad.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSiRxSeguridadActionPerformed(evt);
            }
        });
        this.JBGOptSeguridad.add(this.JRBNoRxSeguridad);
        this.JRBNoRxSeguridad.setFont(new Font("Arial", 1, 11));
        this.JRBNoRxSeguridad.setText("No");
        this.JRBNoRxSeguridad.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNoRxSeguridadActionPerformed(evt);
            }
        });
        this.JPITipoLentes1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoLenteOpt.add(this.JRBDGTLNingunoRx);
        this.JRBDGTLNingunoRx.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLNingunoRx.setSelected(true);
        this.JRBDGTLNingunoRx.setText("Ninguno");
        this.JRBDGTLNingunoRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLNingunoRxActionPerformed(evt);
            }
        });
        this.JBGTipoLenteOpt.add(this.JRBDGTLProgresivoRx);
        this.JRBDGTLProgresivoRx.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLProgresivoRx.setText("Progresivo");
        this.JRBDGTLProgresivoRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLProgresivoRxActionPerformed(evt);
            }
        });
        this.JBGTipoLenteOpt.add(this.JRBDGTLBifocalesRx);
        this.JRBDGTLBifocalesRx.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLBifocalesRx.setText("Bifocales");
        this.JRBDGTLBifocalesRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLBifocalesRxActionPerformed(evt);
            }
        });
        this.JBGTipoLenteOpt.add(this.JRBDGTLMonofocalesRx);
        this.JRBDGTLMonofocalesRx.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLMonofocalesRx.setText("Monofocales");
        this.JRBDGTLMonofocalesRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLMonofocalesRxActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentes1Layout = new GroupLayout(this.JPITipoLentes1);
        this.JPITipoLentes1.setLayout(JPITipoLentes1Layout);
        JPITipoLentes1Layout.setHorizontalGroup(JPITipoLentes1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes1Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBDGTLNingunoRx).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLProgresivoRx).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLBifocalesRx).addGap(2, 2, 2).addComponent(this.JRBDGTLMonofocalesRx).addGap(2, 2, 2)));
        JPITipoLentes1Layout.setVerticalGroup(JPITipoLentes1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPITipoLentes1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTLProgresivoRx).addComponent(this.JRBDGTLBifocalesRx).addComponent(this.JRBDGTLNingunoRx).addComponent(this.JRBDGTLMonofocalesRx)).addGap(2, 2, 2)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Rx en uso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFODEsfera.setFont(new Font("Arial", 1, 12));
        this.JTFODEsfera.setHorizontalAlignment(4);
        this.JTFODEsfera.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODCilindro.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindro.setHorizontalAlignment(4);
        this.JTFODCilindro.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("ESFERA");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("CILINDRO");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("EJE");
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("ADD");
        this.JTFODEje.setFont(new Font("Arial", 1, 12));
        this.JTFODEje.setHorizontalAlignment(4);
        this.JTFODEje.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAV.setFont(new Font("Arial", 1, 12));
        this.JTFODAV.setHorizontalAlignment(4);
        this.JTFODAV.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsfera.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsfera.setHorizontalAlignment(4);
        this.JTFOIEsfera.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindro.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindro.setHorizontalAlignment(4);
        this.JTFOICilindro.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindro.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroActionPerformed(evt);
            }
        });
        this.JTFOIEje.setFont(new Font("Arial", 1, 12));
        this.JTFOIEje.setHorizontalAlignment(4);
        this.JTFOIEje.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAV.setFont(new Font("Arial", 1, 12));
        this.JTFOIAV.setHorizontalAlignment(4);
        this.JTFOIAV.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("O.D.");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("O.I.");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, -2, 33, -2).addComponent(this.jLabel12, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODEsfera).addComponent(this.JTFOIEsfera).addComponent(this.jLabel7, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFOICilindro).addComponent(this.JTFODCilindro).addComponent(this.jLabel8, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFOIEje, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAV, -2, 84, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODEje).addComponent(this.jLabel9, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10, -2, 67, -2).addComponent(this.JTFODAV, -2, 84, -2)))).addGap(5, 5, 5)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsfera, -2, -1, -2).addComponent(this.JTFODCilindro, -2, -1, -2).addComponent(this.JTFODEje, -2, -1, -2).addComponent(this.JTFODAV, -2, -1, -2).addComponent(this.jLabel11)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsfera, -2, -1, -2).addComponent(this.JTFOICilindro, -2, -1, -2).addComponent(this.JTFOIEje, -2, -1, -2).addComponent(this.JTFOIAV, -2, -1, -2).addComponent(this.jLabel12)).addGap(3, 3, 3)));
        this.JPITipoLentes2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoFiltro.add(this.JRBUV);
        this.JRBUV.setFont(new Font("Arial", 1, 11));
        this.JRBUV.setText("UV");
        this.JRBUV.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBUVActionPerformed(evt);
            }
        });
        this.JBGTipoFiltro.add(this.JRBGrado);
        this.JRBGrado.setFont(new Font("Arial", 1, 11));
        this.JRBGrado.setText("Grado Sol");
        this.JRBGrado.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBGradoActionPerformed(evt);
            }
        });
        this.JBGTipoFiltro.add(this.JRBTransicion);
        this.JRBTransicion.setFont(new Font("Arial", 1, 11));
        this.JRBTransicion.setText("Transition");
        this.JRBTransicion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBTransicionActionPerformed(evt);
            }
        });
        this.JBGTipoFiltro.add(this.JRBNinguno);
        this.JRBNinguno.setFont(new Font("Arial", 1, 11));
        this.JRBNinguno.setSelected(true);
        this.JRBNinguno.setText("Ninguno");
        this.JRBNinguno.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentes2Layout = new GroupLayout(this.JPITipoLentes2);
        this.JPITipoLentes2.setLayout(JPITipoLentes2Layout);
        JPITipoLentes2Layout.setHorizontalGroup(JPITipoLentes2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBNinguno).addGap(18, 18, 18).addComponent(this.JRBUV).addGap(18, 18, 18).addComponent(this.JRBGrado).addGap(18, 18, 18).addComponent(this.JRBTransicion).addContainerGap(-1, 32767)));
        JPITipoLentes2Layout.setVerticalGroup(JPITipoLentes2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLentes2Layout.createSequentialGroup().addGroup(JPITipoLentes2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGrado).addComponent(this.JRBTransicion).addComponent(this.JRBUV).addComponent(this.JRBNinguno)).addGap(2, 2, 2)));
        this.JPITipoLentes3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoFiltroRx.add(this.JRBUVRx);
        this.JRBUVRx.setFont(new Font("Arial", 1, 11));
        this.JRBUVRx.setText("UV");
        this.JRBUVRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBUVRxActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroRx.add(this.JRBGradoRx);
        this.JRBGradoRx.setFont(new Font("Arial", 1, 11));
        this.JRBGradoRx.setText("Grado Sol");
        this.JRBGradoRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBGradoRxActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroRx.add(this.JRBSTransicionRx);
        this.JRBSTransicionRx.setFont(new Font("Arial", 1, 11));
        this.JRBSTransicionRx.setText("Transition");
        this.JRBSTransicionRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSTransicionRxActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroRx.add(this.JRBNingunoRx);
        this.JRBNingunoRx.setFont(new Font("Arial", 1, 11));
        this.JRBNingunoRx.setSelected(true);
        this.JRBNingunoRx.setText("Ninguno");
        this.JRBNingunoRx.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNingunoRxActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentes3Layout = new GroupLayout(this.JPITipoLentes3);
        this.JPITipoLentes3.setLayout(JPITipoLentes3Layout);
        JPITipoLentes3Layout.setHorizontalGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLentes3Layout.createSequentialGroup().addGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNingunoRx).addComponent(this.JRBGradoRx)).addGap(32, 32, 32).addGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSTransicionRx).addComponent(this.JRBUVRx)).addGap(3, 3, 3)));
        JPITipoLentes3Layout.setVerticalGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes3Layout.createSequentialGroup().addGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNingunoRx).addComponent(this.JRBUVRx)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPITipoLentes3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGradoRx).addComponent(this.JRBSTransicionRx)).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Rx de seguridad en uso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFODEsferaRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFODEsferaRxUso.setHorizontalAlignment(4);
        this.JTFODEsferaRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODCilindroRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindroRxUso.setHorizontalAlignment(4);
        this.JTFODCilindroRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("ESFERA");
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setText("CILINDRO");
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setText("EJE");
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setText("ADD");
        this.JTFODEjeRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFODEjeRxUso.setHorizontalAlignment(4);
        this.JTFODEjeRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAVRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFODAVRxUso.setHorizontalAlignment(4);
        this.JTFODAVRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsferaRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsferaRxUso.setHorizontalAlignment(4);
        this.JTFOIEsferaRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindroRxUso.setHorizontalAlignment(4);
        this.JTFOICilindroRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxUso.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroRxUsoActionPerformed(evt);
            }
        });
        this.JTFOIEjeRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFOIEjeRxUso.setHorizontalAlignment(4);
        this.JTFOIEjeRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAVRxUso.setFont(new Font("Arial", 1, 12));
        this.JTFOIAVRxUso.setHorizontalAlignment(4);
        this.JTFOIAVRxUso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setText("O.D.");
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setText("O.I.");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17, -2, 33, -2).addComponent(this.jLabel18, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addGap(6, 6, 6).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODEsferaRxUso).addComponent(this.JTFOIEsferaRxUso).addComponent(this.jLabel13, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFOICilindroRxUso).addComponent(this.JTFODCilindroRxUso).addComponent(this.jLabel14, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JTFOIEjeRxUso, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAVRxUso, -2, 84, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODEjeRxUso).addComponent(this.jLabel15, -1, 84, 32767)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16, -2, 67, -2).addComponent(this.JTFODAVRxUso, -2, 84, -2)))).addGap(5, 5, 5)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jLabel14).addComponent(this.jLabel15).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsferaRxUso, -2, -1, -2).addComponent(this.JTFODCilindroRxUso, -2, -1, -2).addComponent(this.JTFODEjeRxUso, -2, -1, -2).addComponent(this.JTFODAVRxUso, -2, -1, -2).addComponent(this.jLabel17)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsferaRxUso, -2, -1, -2).addComponent(this.JTFOICilindroRxUso, -2, -1, -2).addComponent(this.JTFOIEjeRxUso, -2, -1, -2).addComponent(this.JTFOIAVRxUso, -2, -1, -2).addComponent(this.jLabel18)).addGap(3, 3, 3)));
        this.JPAgudezaVisual.setBorder(BorderFactory.createTitledBorder((Border) null, "Agudeza Visual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPVisionlejana.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión Lejana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFODSCVL.setFont(new Font("Arial", 1, 12));
        this.JTFODSCVL.setHorizontalAlignment(4);
        this.JTFODSCVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODSCVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFODSCVLActionPerformed(evt);
            }
        });
        this.JTFODPersonalVL.setFont(new Font("Arial", 1, 12));
        this.JTFODPersonalVL.setHorizontalAlignment(4);
        this.JTFODPersonalVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setText("S.C.");
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setText("C.C. personal");
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setText("C.C. de seguridad");
        this.JTFODSeguridadVL.setFont(new Font("Arial", 1, 12));
        this.JTFODSeguridadVL.setHorizontalAlignment(4);
        this.JTFODSeguridadVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOISCVL.setFont(new Font("Arial", 1, 12));
        this.JTFOISCVL.setHorizontalAlignment(4);
        this.JTFOISCVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIPersonalVL.setFont(new Font("Arial", 1, 12));
        this.JTFOIPersonalVL.setHorizontalAlignment(4);
        this.JTFOIPersonalVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIPersonalVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIPersonalVLActionPerformed(evt);
            }
        });
        this.JTFOISeguridadVL.setFont(new Font("Arial", 1, 12));
        this.JTFOISeguridadVL.setHorizontalAlignment(4);
        this.JTFOISeguridadVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOISeguridadVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOISeguridadVLActionPerformed(evt);
            }
        });
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setText("O.D.");
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setText("O.I.");
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setText("A.O.");
        this.JTFOASCVL.setFont(new Font("Arial", 1, 12));
        this.JTFOASCVL.setHorizontalAlignment(4);
        this.JTFOASCVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOAPersonalVL.setFont(new Font("Arial", 1, 12));
        this.JTFOAPersonalVL.setHorizontalAlignment(4);
        this.JTFOAPersonalVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOAPersonalVL.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.65
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOAPersonalVLActionPerformed(evt);
            }
        });
        this.JTFOASeguridadVL.setFont(new Font("Arial", 1, 12));
        this.JTFOASeguridadVL.setHorizontalAlignment(4);
        this.JTFOASeguridadVL.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPVisionlejanaLayout = new GroupLayout(this.JPVisionlejana);
        this.JPVisionlejana.setLayout(JPVisionlejanaLayout);
        JPVisionlejanaLayout.setHorizontalGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionlejanaLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionlejanaLayout.createSequentialGroup().addComponent(this.jLabel25, -2, 33, -2).addGap(6, 6, 6).addComponent(this.JTFOASCVL, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOAPersonalVL, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFOASeguridadVL, -2, 84, -2)).addGroup(JPVisionlejanaLayout.createSequentialGroup().addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel23, -2, 33, -2).addComponent(this.jLabel24, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addGap(6, 6, 6).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODSCVL, -2, 84, -2).addComponent(this.JTFOISCVL, -2, 84, -2).addComponent(this.jLabel19, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODPersonalVL, -2, 84, -2).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.JTFOIPersonalVL, -2, 84, -2)).addGap(5, 5, 5).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODSeguridadVL, -2, 84, -2).addComponent(this.jLabel21, -1, -1, 32767).addComponent(this.JTFOISeguridadVL, -2, 84, -2)))).addContainerGap(-1, 32767)));
        JPVisionlejanaLayout.setVerticalGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionlejanaLayout.createSequentialGroup().addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.jLabel20).addComponent(this.jLabel21)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODSCVL, -2, -1, -2).addComponent(this.JTFODPersonalVL, -2, -1, -2).addComponent(this.JTFODSeguridadVL, -2, -1, -2).addComponent(this.jLabel23)).addGap(5, 5, 5).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOISCVL, -2, -1, -2).addComponent(this.JTFOIPersonalVL, -2, -1, -2).addComponent(this.JTFOISeguridadVL, -2, -1, -2).addComponent(this.jLabel24)).addGap(5, 5, 5).addGroup(JPVisionlejanaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOASCVL, -2, -1, -2).addComponent(this.JTFOAPersonalVL, -2, -1, -2).addComponent(this.JTFOASeguridadVL, -2, -1, -2).addComponent(this.jLabel25))));
        this.JPVisionProxima.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión Próxima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFODSCVP.setFont(new Font("Arial", 1, 12));
        this.JTFODSCVP.setHorizontalAlignment(4);
        this.JTFODSCVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODPersonalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODPersonalVP.setHorizontalAlignment(4);
        this.JTFODPersonalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setText("S.C.");
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setText("C.C. personal");
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setText("C.C. de seguridad");
        this.JTFODSeguridadVP.setFont(new Font("Arial", 1, 12));
        this.JTFODSeguridadVP.setHorizontalAlignment(4);
        this.JTFODSeguridadVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOISCVP.setFont(new Font("Arial", 1, 12));
        this.JTFOISCVP.setHorizontalAlignment(4);
        this.JTFOISCVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIPersonalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOIPersonalVP.setHorizontalAlignment(4);
        this.JTFOIPersonalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIPersonalVP.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.66
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIPersonalVPActionPerformed(evt);
            }
        });
        this.JTFOISeguridadVP.setFont(new Font("Arial", 1, 12));
        this.JTFOISeguridadVP.setHorizontalAlignment(4);
        this.JTFOISeguridadVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOISeguridadVP.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOISeguridadVPActionPerformed(evt);
            }
        });
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setText("O.D.");
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setText("O.I.");
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setText("A.O.");
        this.JTFOASCVP.setFont(new Font("Arial", 1, 12));
        this.JTFOASCVP.setHorizontalAlignment(4);
        this.JTFOASCVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOAPersonalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOAPersonalVP.setHorizontalAlignment(4);
        this.JTFOAPersonalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOAPersonalVP.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.68
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOAPersonalVPActionPerformed(evt);
            }
        });
        this.JTFOASeguridadVP.setFont(new Font("Arial", 1, 12));
        this.JTFOASeguridadVP.setHorizontalAlignment(4);
        this.JTFOASeguridadVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPVisionProximaLayout = new GroupLayout(this.JPVisionProxima);
        this.JPVisionProxima.setLayout(JPVisionProximaLayout);
        JPVisionProximaLayout.setHorizontalGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProximaLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPVisionProximaLayout.createSequentialGroup().addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel28, -2, 33, -2).addComponent(this.jLabel29, GroupLayout.Alignment.TRAILING, -2, 33, -2)).addGap(6, 6, 6).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODSCVP, -2, 84, -2).addComponent(this.JTFOISCVP, -2, 84, -2).addComponent(this.jLabel22, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFOIPersonalVP, -2, 84, -2).addComponent(this.JTFODPersonalVP, -2, 84, -2).addComponent(this.jLabel26, -1, -1, 32767)).addGap(5, 5, 5)).addGroup(JPVisionProximaLayout.createSequentialGroup().addComponent(this.jLabel30, -2, 33, -2).addGap(6, 6, 6).addComponent(this.JTFOASCVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOAPersonalVP, -2, 84, -2).addGap(4, 4, 4))).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFODSeguridadVP, -2, 84, -2).addComponent(this.jLabel27, -1, -1, 32767).addComponent(this.JTFOISeguridadVP, -2, 84, -2)).addComponent(this.JTFOASeguridadVP, -2, 84, -2)).addContainerGap(-1, 32767)));
        JPVisionProximaLayout.setVerticalGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionProximaLayout.createSequentialGroup().addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.jLabel26).addComponent(this.jLabel27)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODSCVP, -2, -1, -2).addComponent(this.JTFODPersonalVP, -2, -1, -2).addComponent(this.JTFODSeguridadVP, -2, -1, -2).addComponent(this.jLabel28)).addGap(5, 5, 5).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOISCVP, -2, -1, -2).addComponent(this.JTFOIPersonalVP, -2, -1, -2).addComponent(this.JTFOISeguridadVP, -2, -1, -2).addComponent(this.jLabel29)).addGap(5, 5, 5).addGroup(JPVisionProximaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOASCVP, -2, -1, -2).addComponent(this.JTFOAPersonalVP, -2, -1, -2).addComponent(this.JTFOASeguridadVP, -2, -1, -2).addComponent(this.jLabel30))));
        GroupLayout JPAgudezaVisualLayout = new GroupLayout(this.JPAgudezaVisual);
        this.JPAgudezaVisual.setLayout(JPAgudezaVisualLayout);
        JPAgudezaVisualLayout.setHorizontalGroup(JPAgudezaVisualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAgudezaVisualLayout.createSequentialGroup().addComponent(this.JPVisionlejana, -2, 336, -2).addGap(18, 18, 18).addComponent(this.JPVisionProxima, -2, 336, -2).addGap(0, 119, 32767)));
        JPAgudezaVisualLayout.setVerticalGroup(JPAgudezaVisualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPVisionlejana, -2, -1, -2).addComponent(this.JPVisionProxima, -2, -1, -2));
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setForeground(Color.red);
        this.JLB_Id.setHorizontalAlignment(11);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaCambio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha uiltimo cambio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaCambio.setDateFormatString("dd/MM/yyyy");
        this.JDFechaCambio.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_Id, -2, 126, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5).addGap(2, 2, 2).addComponent(this.JRBSiRxSeguridad).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNoRxSeguridad).addGap(1, 1, 1).addComponent(this.JPITipoLentes1, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPITipoLentes, -1, -1, 32767).addComponent(this.JPITipoLentes2, -1, -1, 32767))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaCambio, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHVL).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHVP)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(2, 2, 2).addComponent(this.JRBSiPrescipcion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNoPrescipcion).addGap(18, 18, 18).addComponent(this.jLabel2, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHLO).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHLC))).addGap(18, 18, 18).addComponent(this.jLabel3, -2, 89, -2).addGap(2, 2, 2).addComponent(this.JRBPermanente).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEsporadico)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPITipoLentes3, -2, -1, -2)).addComponent(this.JPAgudezaVisual, -2, -1, -2))).addGap(33, 33, 33)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiPrescipcion).addComponent(this.JRBNoPrescipcion).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.JCHLO).addComponent(this.JCHLC).addComponent(this.jLabel3).addComponent(this.JRBPermanente).addComponent(this.JRBEsporadico)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHVL).addComponent(this.JCHVP).addComponent(this.JDFechaCambio, -2, -1, -2)).addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPITipoLentes, -2, -1, -2).addGap(2, 2, 2).addComponent(this.JPITipoLentes2, -2, -1, -2))).addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoLentes1, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiRxSeguridad).addComponent(this.JRBNoRxSeguridad).addComponent(this.jLabel5)))).addGap(2, 2, 2).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JPITipoLentes3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPAgudezaVisual, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_Id, -2, 40, -2).addGap(10, 10, 10)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)));
        this.JTPaneDatos.addTab("PARTE 2", this.JPDatos);
        this.JP.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setText("ESFERA");
        this.JTFODEsferaRet.setFont(new Font("Arial", 1, 12));
        this.JTFODEsferaRet.setHorizontalAlignment(4);
        this.JTFODEsferaRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setText("CILINDRO");
        this.jLabel34.setFont(new Font("Arial", 1, 12));
        this.jLabel34.setText("EJE");
        this.jLabel35.setFont(new Font("Arial", 1, 12));
        this.jLabel35.setText("A.V.");
        this.JTFODCilindroRet.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindroRet.setHorizontalAlignment(4);
        this.JTFODCilindroRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODEjeRet.setFont(new Font("Arial", 1, 12));
        this.JTFODEjeRet.setHorizontalAlignment(4);
        this.JTFODEjeRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAVRet.setFont(new Font("Arial", 1, 12));
        this.JTFODAVRet.setHorizontalAlignment(4);
        this.JTFODAVRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsferaRet.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsferaRet.setHorizontalAlignment(4);
        this.JTFOIEsferaRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsferaRet.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.69
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIEsferaRetActionPerformed(evt);
            }
        });
        this.JTFOICilindroRet.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindroRet.setHorizontalAlignment(4);
        this.JTFOICilindroRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRet.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.70
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroRetActionPerformed(evt);
            }
        });
        this.JTFOIEjeRet.setFont(new Font("Arial", 1, 12));
        this.JTFOIEjeRet.setHorizontalAlignment(4);
        this.JTFOIEjeRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEjeRet.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.71
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIEjeRetActionPerformed(evt);
            }
        });
        this.JTFOIAVRet.setFont(new Font("Arial", 1, 12));
        this.JTFOIAVRet.setHorizontalAlignment(4);
        this.JTFOIAVRet.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel37.setFont(new Font("Arial", 1, 12));
        this.jLabel37.setText("ADD");
        this.JTFODEsferaRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFODEsferaRxFinal.setHorizontalAlignment(4);
        this.JTFODEsferaRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODCilindroRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindroRxFinal.setHorizontalAlignment(4);
        this.JTFODCilindroRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODEjeRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFODEjeRxFinal.setHorizontalAlignment(4);
        this.JTFODEjeRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAddRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFODAddRxFinal.setHorizontalAlignment(4);
        this.JTFODAddRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAVRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFODAVRxFinal.setHorizontalAlignment(4);
        this.JTFODAVRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAVRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFOIAVRxFinal.setHorizontalAlignment(4);
        this.JTFOIAVRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAddRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFOIAddRxFinal.setHorizontalAlignment(4);
        this.JTFOIAddRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEjeRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFOIEjeRxFinal.setHorizontalAlignment(4);
        this.JTFOIEjeRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindroRxFinal.setHorizontalAlignment(4);
        this.JTFOICilindroRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxFinal.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.72
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroRxFinalActionPerformed(evt);
            }
        });
        this.JTFOIEsferaRxFinal.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsferaRxFinal.setHorizontalAlignment(4);
        this.JTFOIEsferaRxFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODEsferaRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODEsferaRxFinalVP.setHorizontalAlignment(4);
        this.JTFODEsferaRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODCilindroRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindroRxFinalVP.setHorizontalAlignment(4);
        this.JTFODCilindroRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODEjeRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODEjeRxFinalVP.setHorizontalAlignment(4);
        this.JTFODEjeRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAddRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODAddRxFinalVP.setHorizontalAlignment(4);
        this.JTFODAddRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFODAVRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFODAVRxFinalVP.setHorizontalAlignment(4);
        this.JTFODAVRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAVRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOIAVRxFinalVP.setHorizontalAlignment(4);
        this.JTFOIAVRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAddRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOIAddRxFinalVP.setHorizontalAlignment(4);
        this.JTFOIAddRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEjeRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOIEjeRxFinalVP.setHorizontalAlignment(4);
        this.JTFOIEjeRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindroRxFinalVP.setHorizontalAlignment(4);
        this.JTFOICilindroRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroRxFinalVP.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.73
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroRxFinalVPActionPerformed(evt);
            }
        });
        this.JTFOIEsferaRxFinalVP.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsferaRxFinalVP.setHorizontalAlignment(4);
        this.JTFOIEsferaRxFinalVP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setForeground(new Color(255, 0, 0));
        this.jLabel32.setText("RETINOSCOPIA");
        this.jLabel32.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel36.setFont(new Font("Arial", 1, 12));
        this.jLabel36.setHorizontalAlignment(0);
        this.jLabel36.setText("O.D.");
        this.jLabel36.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel38.setFont(new Font("Arial", 1, 12));
        this.jLabel38.setHorizontalAlignment(0);
        this.jLabel38.setText("O.I.");
        this.jLabel38.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel40.setFont(new Font("Arial", 1, 12));
        this.jLabel40.setForeground(new Color(255, 0, 0));
        this.jLabel40.setText("RX FINAL");
        this.jLabel40.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setHorizontalAlignment(0);
        this.jLabel42.setText("O.D.");
        this.jLabel42.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setHorizontalAlignment(0);
        this.jLabel43.setText("O.I.");
        this.jLabel43.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel46.setFont(new Font("Arial", 1, 12));
        this.jLabel46.setHorizontalAlignment(0);
        this.jLabel46.setText("V.P.");
        this.jLabel46.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel47.setFont(new Font("Arial", 1, 12));
        this.jLabel47.setHorizontalAlignment(0);
        this.jLabel47.setText("V.L.");
        this.jLabel47.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel45.setFont(new Font("Arial", 1, 12));
        this.jLabel45.setHorizontalAlignment(0);
        this.jLabel45.setText("O.D.");
        this.jLabel45.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setHorizontalAlignment(0);
        this.jLabel48.setText("O.I.");
        this.jLabel48.setBorder(BorderFactory.createTitledBorder(""));
        this.JTFODEsferaSub.setFont(new Font("Arial", 1, 12));
        this.JTFODEsferaSub.setHorizontalAlignment(4);
        this.JTFODEsferaSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsferaSub.setFont(new Font("Arial", 1, 12));
        this.JTFOIEsferaSub.setHorizontalAlignment(4);
        this.JTFOIEsferaSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEsferaSub.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.74
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIEsferaSubActionPerformed(evt);
            }
        });
        this.JTFODCilindroSub.setFont(new Font("Arial", 1, 12));
        this.JTFODCilindroSub.setHorizontalAlignment(4);
        this.JTFODCilindroSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroSub.setFont(new Font("Arial", 1, 12));
        this.JTFOICilindroSub.setHorizontalAlignment(4);
        this.JTFOICilindroSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOICilindroSub.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.75
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOICilindroSubActionPerformed(evt);
            }
        });
        this.JTFODEjeSub.setFont(new Font("Arial", 1, 12));
        this.JTFODEjeSub.setHorizontalAlignment(4);
        this.JTFODEjeSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEjeSub.setFont(new Font("Arial", 1, 12));
        this.JTFOIEjeSub.setHorizontalAlignment(4);
        this.JTFOIEjeSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIEjeSub.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.76
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JTFOIEjeSubActionPerformed(evt);
            }
        });
        this.JTFODAVSub.setFont(new Font("Arial", 1, 12));
        this.JTFODAVSub.setHorizontalAlignment(4);
        this.JTFODAVSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFOIAVSub.setFont(new Font("Arial", 1, 12));
        this.JTFOIAVSub.setHorizontalAlignment(4);
        this.JTFOIAVSub.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel41.setFont(new Font("Arial", 1, 12));
        this.jLabel41.setHorizontalAlignment(0);
        this.jLabel41.setText("O.D.");
        this.jLabel41.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setHorizontalAlignment(0);
        this.jLabel44.setText("O.I.");
        this.jLabel44.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel49.setFont(new Font("Arial", 1, 12));
        this.jLabel49.setHorizontalAlignment(0);
        this.jLabel49.setText("A.V.");
        this.jLabel49.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setForeground(new Color(255, 0, 0));
        this.jLabel51.setText("<html>SUBJETIVO Y </P> AFINACIONES</html>");
        this.jLabel51.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel52.setFont(new Font("Arial", 1, 12));
        this.jLabel52.setHorizontalAlignment(0);
        this.jLabel52.setText("A.V.");
        this.jLabel52.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout JPLayout = new GroupLayout(this.JP);
        this.JP.setLayout(JPLayout);
        JPLayout.setHorizontalGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPLayout.createSequentialGroup().addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel32, -2, 91, -2).addGap(6, 6, 6).addComponent(this.jLabel49, -2, 46, -2).addGap(6, 6, 6).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel36, -2, 34, -2).addGap(1, 1, 1)).addComponent(this.jLabel38, -1, -1, 32767))).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel40).addGap(2, 2, 2).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.jLabel47, -1, 94, 32767).addGap(6, 6, 6).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPLayout.createSequentialGroup().addComponent(this.jLabel43, -2, 33, -2).addGap(1, 1, 1)).addComponent(this.jLabel42, GroupLayout.Alignment.TRAILING, -2, 34, -2))).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel46, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel45, GroupLayout.Alignment.TRAILING, -2, 33, -2).addComponent(this.jLabel48, GroupLayout.Alignment.TRAILING, -2, 33, -2)))))).addGap(4, 4, 4).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel31, -2, 84, -2).addGap(5, 5, 5).addComponent(this.jLabel33, -2, 84, -2).addGap(5, 5, 5).addComponent(this.jLabel34, -2, 84, -2).addGap(6, 6, 6).addComponent(this.jLabel37, -2, 84, -2).addGap(6, 6, 6).addComponent(this.jLabel35, -2, 67, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFOIEsferaRet, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOICilindroRet, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIEjeRet, -2, 84, -2).addGap(94, 94, 94).addComponent(this.JTFOIAVRet, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFODEsferaRet, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODCilindroRet, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODEjeRet, -2, 84, -2).addGap(94, 94, 94).addComponent(this.JTFODAVRet, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFODEsferaRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODCilindroRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODEjeRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODAddRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODAVRxFinal, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFOIEsferaRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOICilindroRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIEjeRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAddRxFinal, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAVRxFinal, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFODEsferaRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODCilindroRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODEjeRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODAddRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODAVRxFinalVP, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFOIEsferaRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOICilindroRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIEjeRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAddRxFinalVP, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIAVRxFinalVP, -2, 84, -2)))).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel51, -2, 91, -2).addGap(6, 6, 6).addComponent(this.jLabel52, -2, 46, -2).addGap(8, 8, 8).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel44, -1, -1, 32767).addComponent(this.jLabel41, -1, 34, 32767)).addGap(10, 10, 10).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFOIEsferaSub, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOICilindroSub, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFOIEjeSub, -2, 84, -2).addGap(94, 94, 94).addComponent(this.JTFOIAVSub, -2, 84, -2)).addGroup(JPLayout.createSequentialGroup().addComponent(this.JTFODEsferaSub, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODCilindroSub, -2, 84, -2).addGap(5, 5, 5).addComponent(this.JTFODEjeSub, -2, 84, -2).addGap(94, 94, 94).addComponent(this.JTFODAVSub, -2, 84, -2))))).addGap(71, 71, 71)));
        JPLayout.setVerticalGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel31).addComponent(this.jLabel33).addComponent(this.jLabel34).addComponent(this.jLabel37).addComponent(this.jLabel35)).addGap(2, 2, 2).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPLayout.createSequentialGroup().addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsferaRet, -2, -1, -2).addComponent(this.jLabel36)).addComponent(this.JTFODCilindroRet, -2, -1, -2).addComponent(this.JTFODEjeRet, -2, -1, -2).addComponent(this.JTFODAVRet, -2, -1, -2)).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsferaRet, -2, -1, -2).addComponent(this.JTFOICilindroRet, -2, -1, -2).addComponent(this.JTFOIEjeRet, -2, -1, -2).addComponent(this.JTFOIAVRet, -2, -1, -2).addComponent(this.jLabel38))).addComponent(this.jLabel32, -1, -1, 32767).addGroup(JPLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jLabel49, -1, -1, 32767))).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel51, -2, 39, -2).addComponent(this.jLabel52, -2, 39, -2)).addGroup(JPLayout.createSequentialGroup().addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFODCilindroSub, -2, -1, -2).addComponent(this.JTFODEjeSub, -2, -1, -2).addComponent(this.JTFODAVSub, -2, -1, -2)).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsferaSub, -2, -1, -2).addComponent(this.JTFOICilindroSub, -2, -1, -2).addComponent(this.JTFOIEjeSub, -2, -1, -2).addComponent(this.JTFOIAVSub, -2, -1, -2).addComponent(this.jLabel44))).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsferaSub, -2, -1, -2).addComponent(this.jLabel41))).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLayout.createSequentialGroup().addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPLayout.createSequentialGroup().addComponent(this.jLabel47, -2, 40, -2).addGap(8, 8, 8).addComponent(this.jLabel46, -1, -1, 32767)).addComponent(this.jLabel40, -2, 88, -2)).addGap(22, 22, 22)).addGroup(JPLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsferaRxFinal, -2, -1, -2).addComponent(this.JTFODCilindroRxFinal, -2, -1, -2).addComponent(this.JTFODEjeRxFinal, -2, -1, -2).addComponent(this.JTFODAddRxFinal, -2, -1, -2).addComponent(this.JTFODAVRxFinal, -2, -1, -2).addComponent(this.jLabel42, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsferaRxFinal, -2, -1, -2).addComponent(this.JTFOICilindroRxFinal, -2, -1, -2).addComponent(this.JTFOIEjeRxFinal, -2, -1, -2).addComponent(this.JTFOIAddRxFinal, -2, -1, -2).addComponent(this.JTFOIAVRxFinal, -2, -1, -2).addComponent(this.jLabel43, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFODEsferaRxFinalVP, -2, -1, -2).addComponent(this.JTFODCilindroRxFinalVP, -2, -1, -2).addComponent(this.JTFODEjeRxFinalVP, -2, -1, -2).addComponent(this.JTFODAddRxFinalVP, -2, -1, -2).addComponent(this.JTFODAVRxFinalVP, -2, -1, -2).addComponent(this.jLabel45, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFOIEsferaRxFinalVP, -2, -1, -2).addComponent(this.JTFOICilindroRxFinalVP, -2, -1, -2).addComponent(this.JTFOIEjeRxFinalVP, -2, -1, -2).addComponent(this.JTFOIAddRxFinalVP, -2, -1, -2).addComponent(this.JTFOIAVRxFinalVP, -2, -1, -2).addComponent(this.jLabel48, -1, -1, 32767)))).addContainerGap()));
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Corrección Óptica");
        this.JBGCorrecionOpt.add(this.JRBSiCorrecionOpt);
        this.JRBSiCorrecionOpt.setFont(new Font("Arial", 1, 11));
        this.JRBSiCorrecionOpt.setText("Sí");
        this.JRBSiCorrecionOpt.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.77
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSiCorrecionOptActionPerformed(evt);
            }
        });
        this.JBGCorrecionOpt.add(this.JRBNoCorrecionOpt);
        this.JRBNoCorrecionOpt.setFont(new Font("Arial", 1, 11));
        this.JRBNoCorrecionOpt.setSelected(true);
        this.JRBNoCorrecionOpt.setText("No");
        this.JRBNoCorrecionOpt.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.78
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNoCorrecionOptActionPerformed(evt);
            }
        });
        this.JCHLOftalmico.setFont(new Font("Arial", 1, 11));
        this.JCHLOftalmico.setText("Lente oftálmico");
        this.JCHLOftalmico.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.79
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHLOftalmicoActionPerformed(evt);
            }
        });
        this.JCHLCotacto.setFont(new Font("Arial", 1, 11));
        this.JCHLCotacto.setText("Lente de contacto");
        this.JCHLCotacto.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.80
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JCHLCotactoActionPerformed(evt);
            }
        });
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Elemento de protección visual y ocular: (tipo, material, color)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JBGElementosPro.add(this.JRBSiElementos);
        this.JRBSiElementos.setFont(new Font("Arial", 1, 11));
        this.JRBSiElementos.setText("Sí");
        this.JRBSiElementos.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.81
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSiElementosActionPerformed(evt);
            }
        });
        this.JBGElementosPro.add(this.JRBNoElementos);
        this.JRBNoElementos.setFont(new Font("Arial", 1, 11));
        this.JRBNoElementos.setSelected(true);
        this.JRBNoElementos.setText("No");
        this.JRBNoElementos.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.82
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNoElementosActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 415, -2).addGap(0, 16, 32767)).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSiElementos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNoElementos).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiElementos).addComponent(this.JRBNoElementos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1).addContainerGap()));
        this.JPITipoLentes4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoLenteConducta.add(this.JRBDGTLNingunoConducta);
        this.JRBDGTLNingunoConducta.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLNingunoConducta.setSelected(true);
        this.JRBDGTLNingunoConducta.setText("Ninguno");
        this.JRBDGTLNingunoConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.83
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLNingunoConductaActionPerformed(evt);
            }
        });
        this.JBGTipoLenteConducta.add(this.JRBDGTLProgresivoConducta);
        this.JRBDGTLProgresivoConducta.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLProgresivoConducta.setText("Progresivo");
        this.JRBDGTLProgresivoConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.84
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLProgresivoConductaActionPerformed(evt);
            }
        });
        this.JBGTipoLenteConducta.add(this.JRBDGTLBifocalesConducta);
        this.JRBDGTLBifocalesConducta.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLBifocalesConducta.setText("Bifocales");
        this.JRBDGTLBifocalesConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.85
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLBifocalesConductaActionPerformed(evt);
            }
        });
        this.JBGTipoLenteConducta.add(this.JRBDGTLMonofocalesConducta);
        this.JRBDGTLMonofocalesConducta.setFont(new Font("Arial", 1, 11));
        this.JRBDGTLMonofocalesConducta.setText("Monofocales");
        this.JRBDGTLMonofocalesConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.86
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBDGTLMonofocalesConductaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentes4Layout = new GroupLayout(this.JPITipoLentes4);
        this.JPITipoLentes4.setLayout(JPITipoLentes4Layout);
        JPITipoLentes4Layout.setHorizontalGroup(JPITipoLentes4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes4Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBDGTLNingunoConducta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLProgresivoConducta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLBifocalesConducta).addGap(2, 2, 2).addComponent(this.JRBDGTLMonofocalesConducta).addGap(2, 2, 2)));
        JPITipoLentes4Layout.setVerticalGroup(JPITipoLentes4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes4Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPITipoLentes4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTLProgresivoConducta).addComponent(this.JRBDGTLBifocalesConducta).addComponent(this.JRBDGTLNingunoConducta).addComponent(this.JRBDGTLMonofocalesConducta)).addGap(2, 2, 2)));
        this.JPITipoLentes5.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoFiltroConducta.add(this.JRBUVConducta);
        this.JRBUVConducta.setFont(new Font("Arial", 1, 11));
        this.JRBUVConducta.setText("UV");
        this.JRBUVConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.87
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBUVConductaActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroConducta.add(this.JRBGradoConducta);
        this.JRBGradoConducta.setFont(new Font("Arial", 1, 11));
        this.JRBGradoConducta.setText("Grado Sol");
        this.JRBGradoConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.88
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBGradoConductaActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroConducta.add(this.JRBSTransicionConducta);
        this.JRBSTransicionConducta.setFont(new Font("Arial", 1, 11));
        this.JRBSTransicionConducta.setText("Transition");
        this.JRBSTransicionConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.89
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBSTransicionConductaActionPerformed(evt);
            }
        });
        this.JBGTipoFiltroConducta.add(this.JRBNingunoConducta);
        this.JRBNingunoConducta.setFont(new Font("Arial", 1, 11));
        this.JRBNingunoConducta.setSelected(true);
        this.JRBNingunoConducta.setText("Ninguno");
        this.JRBNingunoConducta.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.90
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JRBNingunoConductaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentes5Layout = new GroupLayout(this.JPITipoLentes5);
        this.JPITipoLentes5.setLayout(JPITipoLentes5Layout);
        JPITipoLentes5Layout.setHorizontalGroup(JPITipoLentes5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentes5Layout.createSequentialGroup().addComponent(this.JRBNingunoConducta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBUVConducta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBGradoConducta).addGap(18, 18, 18).addComponent(this.JRBSTransicionConducta).addGap(20, 20, 20)));
        JPITipoLentes5Layout.setVerticalGroup(JPITipoLentes5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLentes5Layout.createSequentialGroup().addGroup(JPITipoLentes5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGradoConducta).addComponent(this.JRBSTransicionConducta).addComponent(this.JRBUVConducta).addComponent(this.JRBNingunoConducta)).addGap(2, 2, 2)));
        this.JTFColor.setFont(new Font("Arial", 1, 12));
        this.JTFColor.setBorder(BorderFactory.createTitledBorder((Border) null, "Color", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.JCHLOftalmico)).addGap(2, 2, 2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JRBSiCorrecionOpt).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNoCorrecionOpt)).addComponent(this.JCHLCotacto))).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoLentes5, -1, -1, 32767).addComponent(this.JTFColor).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JPITipoLentes4, -2, -1, -2).addGap(0, 0, 32767))))).addGap(39, 39, 39)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiCorrecionOpt).addComponent(this.JRBNoCorrecionOpt).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHLOftalmico).addComponent(this.JCHLCotacto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JPITipoLentes4, -2, -1, -2).addGap(2, 2, 2).addComponent(this.JPITipoLentes5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFColor, -2, -1, -2)).addComponent(this.jPanel6, -1, -1, 32767)).addGap(39, 39, 39)));
        this.jTabbedPane1.addTab("CONDUCTA", this.jPanel5);
        GroupLayout jpDiagnosticoLayout = new GroupLayout(this.jpDiagnostico);
        this.jpDiagnostico.setLayout(jpDiagnosticoLayout);
        jpDiagnosticoLayout.setHorizontalGroup(jpDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 839, 32767));
        jpDiagnosticoLayout.setVerticalGroup(jpDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 247, 32767));
        this.jTabbedPane1.addTab("DIAGNÓSTICO", this.jpDiagnostico);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP, -2, -1, -2).addComponent(this.jTabbedPane1, -2, 839, -2)).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JP, -2, 222, 32767).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 280, -2).addGap(142, 142, 142)));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("CONDUCTA");
        this.JTPaneDatos.addTab("PARTE 3", this.jPanel4);
        this.JPGrafica.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.JPGrafica.setEnabled(false);
        this.jPanel7.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.jPanel8.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.JLTrianguloAdd.setIcon(new ImageIcon(getClass().getResource("/Imagenes/plus.png")));
        this.JLTrianguloAdd.setText("Add");
        this.JLTrianguloAdd.setCursor(new Cursor(12));
        this.JLTrianguloAdd.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Optometria.91
            public void mouseClicked(MouseEvent evt) {
                JPSo_Optometria.this.JLTrianguloAddMouseClicked(evt);
            }
        });
        this.jLabel6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/circle.png")));
        this.jLabel6.setText("Add");
        this.jLabel6.setCursor(new Cursor(12));
        this.jLabel6.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Optometria.92
            public void mouseClicked(MouseEvent evt) {
                JPSo_Optometria.this.jLabel6MouseClicked(evt);
            }
        });
        this.jLabel39.setIcon(new ImageIcon(getClass().getResource("/Imagenes/triangle.png")));
        this.jLabel39.setText("Add");
        this.jLabel39.setCursor(new Cursor(12));
        this.jLabel39.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Optometria.93
            public void mouseClicked(MouseEvent evt) {
                JPSo_Optometria.this.jLabel39MouseClicked(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTrianguloAdd).addComponent(this.jLabel6).addComponent(this.jLabel39)).addContainerGap(68, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JLTrianguloAdd).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel39).addContainerGap(69, 32767)));
        this.jPanel9.setBackground(Color.white);
        this.jPanel9.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.contenedor.setBackground(Color.white);
        this.contenedor.setBorder(BorderFactory.createLineBorder(Color.white));
        this.contenedor.setForeground(Color.white);
        this.JLImagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ojox.png")));
        GroupLayout contenedorLayout = new GroupLayout(this.contenedor);
        this.contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(contenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup().addContainerGap().addComponent(this.JLImagen, -1, 392, 32767).addContainerGap()));
        contenedorLayout.setVerticalGroup(contenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLImagen, GroupLayout.Alignment.TRAILING, -1, 129, 32767));
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(120, 120, 120).addComponent(this.contenedor, -2, -1, -2).addContainerGap(140, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.contenedor, -2, -1, -2).addGap(0, 9, 32767)));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel9, -1, -1, 32767).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(29, 29, 29).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel8, -2, -1, -2).addComponent(this.jPanel9, -2, -1, -2)).addContainerGap(33, 32767)));
        GroupLayout JPGraficaLayout = new GroupLayout(this.JPGrafica);
        this.JPGrafica.setLayout(JPGraficaLayout);
        JPGraficaLayout.setHorizontalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGraficaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -1, -1, 32767).addContainerGap()));
        JPGraficaLayout.setVerticalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGraficaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, -1, -2).addContainerGap(454, 32767)));
        this.JTPaneDatos.addTab("PARTE 4", this.JPGrafica);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Optometria.94
            public void actionPerformed(ActionEvent evt) {
                JPSo_Optometria.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPaneDatos, -2, 854, -2).addComponent(this.JBGuardar, -2, 844, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPaneDatos, -2, 554, -2).addGap(10, 10, 10).addComponent(this.JBGuardar, -2, 38, -2).addContainerGap(44, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JOtrosActionPerformed(ActionEvent evt) {
        if (this.JOtros.isSelected()) {
            this.yotros = 1L;
        } else {
            this.yotros = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSecrecionActionPerformed(ActionEvent evt) {
        if (this.JSecrecion.isSelected()) {
            this.ysecrecion = 1L;
        } else {
            this.ysecrecion = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPtosisActionPerformed(ActionEvent evt) {
        if (this.JCPtosis.isSelected()) {
            this.xptosis = 1L;
        } else {
            this.xptosis = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPingueculaActionPerformed(ActionEvent evt) {
        if (this.JCPinguecula.isSelected()) {
            this.xpinguecula = 1L;
        } else {
            this.xpinguecula = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JhIPEREMIAActionPerformed(ActionEvent evt) {
        if (this.JhIPEREMIA.isSelected()) {
            this.yhiperemia = 1L;
        } else {
            this.yhiperemia = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCNistagmusActionPerformed(ActionEvent evt) {
        if (this.JCNistagmus.isSelected()) {
            this.xnistagmus = 1L;
        } else {
            this.xnistagmus = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPterigioActionPerformed(ActionEvent evt) {
        if (this.JCPterigio.isSelected()) {
            this.xptrigio = 1L;
        } else {
            this.xptrigio = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCVisionVLActionPerformed(ActionEvent evt) {
        if (this.JCVisionVL.isSelected()) {
            this.visionVL = 1L;
        } else {
            this.visionVL = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCNIngunoActionPerformed(ActionEvent evt) {
        if (this.JCNInguno.isSelected()) {
            this.xninguno = 1L;
        } else {
            this.xninguno = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCVisionVCActionPerformed(ActionEvent evt) {
        if (this.JCVisionVC.isSelected()) {
            this.xvisionVC = 1L;
        } else {
            this.xvisionVC = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCFotofobiaActionPerformed(ActionEvent evt) {
        if (this.JCFotofobia.isSelected()) {
            this.xfotofobia = 1L;
        } else {
            this.xfotofobia = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCFatigaActionPerformed(ActionEvent evt) {
        if (this.JCFatiga.isSelected()) {
            this.xfatigaV = 1L;
        } else {
            this.xfatigaV = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSaltoRActionPerformed(ActionEvent evt) {
        if (this.JCSaltoR.isSelected()) {
            this.xsaltoR = 1L;
        } else {
            this.xsaltoR = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCVisionDActionPerformed(ActionEvent evt) {
        if (this.JCVisionD.isSelected()) {
            this.xvisiondoble = 1L;
        } else {
            this.xvisiondoble = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCDolorActionPerformed(ActionEvent evt) {
        if (this.JCDolor.isSelected()) {
            this.xdolor = 1L;
        } else {
            this.xdolor = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCArdorActionPerformed(ActionEvent evt) {
        if (this.JCArdor.isSelected()) {
            this.xardor = 1L;
        } else {
            this.xardor = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCLagrimeoActionPerformed(ActionEvent evt) {
        if (this.JCLagrimeo.isSelected()) {
            this.xladrimeo = 1L;
        } else {
            this.xladrimeo = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSecrecionActionPerformed(ActionEvent evt) {
        if (this.JCSecrecion.isSelected()) {
            this.xsecrecion = 1L;
        } else {
            this.xsecrecion = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHiperemiaActionPerformed(ActionEvent evt) {
        if (this.JCHiperemia.isSelected()) {
            this.xhiperemia = 1L;
        } else {
            this.xhiperemia = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCotrosActionPerformed(ActionEvent evt) {
        if (this.JCotros.isSelected()) {
            this.xotros = 1L;
        } else {
            this.xotros = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JChcefaliaActionPerformed(ActionEvent evt) {
        if (this.JChcefalia.isSelected()) {
            this.xcefalea = 1L;
        } else {
            this.xcefalea = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoConductaActionPerformed(ActionEvent evt) {
        this.xtipofiltroElemento = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSTransicionConductaActionPerformed(ActionEvent evt) {
        this.xtipofiltroElemento = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGradoConductaActionPerformed(ActionEvent evt) {
        this.xtipofiltroElemento = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUVConductaActionPerformed(ActionEvent evt) {
        this.xtipofiltroElemento = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLMonofocalesConductaActionPerformed(ActionEvent evt) {
        this.xtipolenteElemento = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLBifocalesConductaActionPerformed(ActionEvent evt) {
        this.xtipolenteElemento = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLProgresivoConductaActionPerformed(ActionEvent evt) {
        this.xtipolenteElemento = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLNingunoConductaActionPerformed(ActionEvent evt) {
        this.xtipolenteElemento = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoElementosActionPerformed(ActionEvent evt) {
        this.xelementoProteccion = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiElementosActionPerformed(ActionEvent evt) {
        this.xelementoProteccion = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLCotactoActionPerformed(ActionEvent evt) {
        if (this.JCHLCotacto.isSelected()) {
            this.xlenteContacto = 1L;
        } else {
            this.xlenteContacto = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLOftalmicoActionPerformed(ActionEvent evt) {
        if (this.JCHLOftalmico.isSelected()) {
            this.xlenteOftalmico = 1L;
        } else {
            this.xlenteOftalmico = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoCorrecionOptActionPerformed(ActionEvent evt) {
        this.xcorrecionOptica = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiCorrecionOptActionPerformed(ActionEvent evt) {
        this.xcorrecionOptica = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIEjeSubActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroSubActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIEsferaSubActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroRxFinalVPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroRxFinalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIEjeRetActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroRetActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIEsferaRetActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOAPersonalVPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOISeguridadVPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIPersonalVPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOAPersonalVLActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOISeguridadVLActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOIPersonalVLActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFODSCVLActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroRxUsoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoRxActionPerformed(ActionEvent evt) {
        this.xTipoFiltroOpticaSeg = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSTransicionRxActionPerformed(ActionEvent evt) {
        this.xTipoFiltroOpticaSeg = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGradoRxActionPerformed(ActionEvent evt) {
        this.xTipoFiltroOpticaSeg = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUVRxActionPerformed(ActionEvent evt) {
        this.xTipoFiltroOpticaSeg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoActionPerformed(ActionEvent evt) {
        this.xtipofiltrorxuso = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTransicionActionPerformed(ActionEvent evt) {
        this.xtipofiltrorxuso = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGradoActionPerformed(ActionEvent evt) {
        this.xtipofiltrorxuso = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUVActionPerformed(ActionEvent evt) {
        this.xtipofiltrorxuso = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOICilindroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLMonofocalesRxActionPerformed(ActionEvent evt) {
        this.xTipoLenteOpticaSeg = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLBifocalesRxActionPerformed(ActionEvent evt) {
        this.xTipoLenteOpticaSeg = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLProgresivoRxActionPerformed(ActionEvent evt) {
        this.xTipoLenteOpticaSeg = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLNingunoRxActionPerformed(ActionEvent evt) {
        this.xTipoLenteOpticaSeg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoRxSeguridadActionPerformed(ActionEvent evt) {
        this.xRxOpticaSeg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiRxSeguridadActionPerformed(ActionEvent evt) {
        this.xRxOpticaSeg = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLMonofocalesActionPerformed(ActionEvent evt) {
        this.xtipolenterxuso = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLBifocalesActionPerformed(ActionEvent evt) {
        this.xtipolenterxuso = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLProgresivoActionPerformed(ActionEvent evt) {
        this.xtipolenterxuso = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLNingunoActionPerformed(ActionEvent evt) {
        this.xtipolenterxuso = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVPActionPerformed(ActionEvent evt) {
        this.xtipovision = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVLActionPerformed(ActionEvent evt) {
        this.xtipovision = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEsporadicoActionPerformed(ActionEvent evt) {
        this.xtiempouso = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPermanenteActionPerformed(ActionEvent evt) {
        this.xtiempouso = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLCActionPerformed(ActionEvent evt) {
        if (this.JCHLC.isSelected()) {
            this.xlc = 1L;
        } else {
            this.xlc = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLOActionPerformed(ActionEvent evt) {
        if (this.JCHLO.isSelected()) {
            this.xlo = 1L;
        } else {
            this.xlo = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoPrescipcionActionPerformed(ActionEvent evt) {
        this.xprescripcion = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiPrescipcionActionPerformed(ActionEvent evt) {
        this.xprescripcion = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.xoftalmoscopiaOD = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        this.xoftalmoscopiaOD = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton3ActionPerformed(ActionEvent evt) {
        this.xoftalmoscopiaOI = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton4ActionPerformed(ActionEvent evt) {
        this.xoftalmoscopiaOI = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton6ActionPerformed(ActionEvent evt) {
        this.xtest = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton5ActionPerformed(ActionEvent evt) {
        this.xtest = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton7ActionPerformed(ActionEvent evt) {
        this.xvcromatica = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton8ActionPerformed(ActionEvent evt) {
        this.xvcromatica = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton9ActionPerformed(ActionEvent evt) {
        this.xcampovisialOD = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton10ActionPerformed(ActionEvent evt) {
        this.xcampovisialOD = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton11ActionPerformed(ActionEvent evt) {
        this.xcampovisialOI = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton12ActionPerformed(ActionEvent evt) {
        this.xcampovisialOI = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel39MouseClicked(MouseEvent evt) {
        this.ms.imagen = "triangle.png";
        this.ms.Nuevo_Objeto();
        this.JLImagen.getParent().setComponentZOrder(this.JLImagen, this.contador_de_objetos + 1);
        this.contador_de_objetos++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel6MouseClicked(MouseEvent evt) {
        this.ms.imagen = "circle.png";
        this.ms.Nuevo_Objeto();
        this.JLImagen.getParent().setComponentZOrder(this.JLImagen, this.contador_de_objetos + 1);
        this.contador_de_objetos++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLTrianguloAddMouseClicked(MouseEvent evt) {
        this.ms.imagen = "plus.png";
        this.ms.Nuevo_Objeto();
        this.JLImagen.getParent().setComponentZOrder(this.JLImagen, this.contador_de_objetos + 1);
        this.contador_de_objetos++;
    }

    public static final void makeScreenshot(String rutaArchivo, String id, JPanel contenedor) {
        Rectangle rec = contenedor.getBounds();
        BufferedImage bufferedImage = new BufferedImage(rec.width, rec.height, 2);
        contenedor.paint(bufferedImage.getGraphics());
        try {
            File temp = new File(rutaArchivo, id + ".png");
            ImageIO.write(bufferedImage, "png", temp);
        } catch (IOException e) {
        }
    }

    public void mGrabar() {
        if (this.xEstadoHC == 0) {
            Object[] botones = {"Grabar", "Grabar y Finalizar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "OPCIONES", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xEstadoHC = 1L;
                mGrabarBd();
                grabarSintomas();
                grabarexmanes();
                grabarOtros();
                mGrababarPdfOptometria();
                return;
            }
            if (n == 1) {
                this.xEstadoHC = 2L;
                mGrabarBd();
                grabarSintomas();
                grabarexmanes();
                grabarOtros();
                mGrababarPdfOptometria();
                this.JBGuardar.setEnabled(false);
                return;
            }
            return;
        }
        if (this.xEstadoHC == 1) {
            Object[] botones2 = {"Actualizar", "Actualizar y Finalizar", "Cerrar"};
            int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "OPCIONES", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            if (n2 == 0) {
                this.xEstadoHC = 1L;
                mActulizarBd();
                actualzarSintomas();
                actualzarExamnes();
                actualzarotros();
                return;
            }
            if (n2 == 1) {
                this.xEstadoHC = 2L;
                mActulizarBd();
                actualzarSintomas();
                actualzarExamnes();
                actualzarotros();
                this.JBGuardar.setEnabled(false);
            }
        }
    }

    public void mGrababarPdfOptometria() {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmetodo.GenerarPdfOptometriaBienestar(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Optometria_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), true);
        }
    }

    public void mImprimir(String idAtencion) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "ID_ATENCION";
        mparametros[0][1] = "Optometria";
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        mparametros[3][0] = "RESOURCE_DIR";
        mparametros[3][1] = this.xmetodo.getDirectorioExportacion() + "resource" + this.xmetodo.getBarra() + "so" + this.xmetodo.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion;
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Optometria_Bienestar", mparametros);
        } else {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                System.out.println(":::::: GENERANDO PDF BIENESTAR SALUD (SOLO VISTA)");
                this.xmetodo.GenerarPdfOptometriaBienestar(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Optometria_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), false);
                return;
            }
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Optometria_Bienestar", mparametros);
        }
    }

    public void mNuevo() {
    }

    private void grabarSintomas() {
        this.xsql = "INSERT INTO h_so_optometria_sintomas (id_optometria,Cefalia,Lagrimeo,Ardor,Dolor,Secrecion,Hiperemia,`Vision borrosa VL`,`Vision borrosa VC`,Fotofobia\n,`Fatiga Visual`,`Vision Doble`,`Salto de Renglon`,Otros,Ninguno)\nVALUES(" + this.xoptometria + "," + this.xcefalea + "," + this.xladrimeo + "," + this.xardor + "," + this.xdolor + "," + this.xsecrecion + "," + this.xhiperemia + "," + this.visionVL + "," + this.xvisionVC + "," + this.xfotofobia + "," + this.xfatigaV + "," + this.xvisiondoble + "," + this.xsaltoR + "," + this.xotros + "," + this.xninguno + ")";
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        System.out.println("ENTROOOOOOOOOO a la tabla de sintomas");
    }

    private void grabarexmanes() {
        this.xsql = "INSERT INTO h_so_optometria_examen_externo (id_optometria,Pterigio ,Pinguecula ,Ptosis ,Secrecion ,Hiperemia ,Nistagmus ,Otros,Observacion)VALUES(" + this.xoptometria + "," + this.xptrigio + "," + this.xpinguecula + "," + this.xptosis + "," + this.ysecrecion + "," + this.yhiperemia + "," + this.xnistagmus + "," + this.yotros + ",'" + this.JTAObservacion1.getText() + "')";
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        System.out.println("ENTROOOOOOOOOO a la tabla de examnes");
    }

    private void grabarOtros() {
        if (this.JTQueratometroOD.getText().equals("")) {
            this.JTQueratometroOD.setText("0");
        }
        if (this.JTQueratometroOI.getText().equals("")) {
            this.JTQueratometroOI.setText("0");
        }
        if (this.JTLensometroOD.getText().equals("")) {
            this.JTLensometroOD.setText("0");
        }
        if (this.JTFLensometroOI.getText().equals("")) {
            this.JTFLensometroOI.setText("0");
        }
        this.xsql = "INSERT INTO h_so_optometria_otros  (id_optometria,`Oftalmoscopia OD`  ,`Oftalmoscopia OI`  ,Hallazgos  ,`Queratometro OD`  ,`Queratometro OI`  ,`Lensometro OD` ,`Lensometro OI` ,\n`Test Estereopsis` ,`Vision Cromatica` ,`Campo Visual OD` ,`Campo Visual OI`)\nVALUES(" + this.xoptometria + "," + this.xoftalmoscopiaOD + "," + this.xoftalmoscopiaOI + ",'" + this.JTHallazgos.getText() + "'," + this.JTQueratometroOD.getText() + "," + this.JTQueratometroOI.getText() + "," + this.JTLensometroOD.getText() + "," + this.JTFLensometroOI.getText() + "," + this.xtest + "," + this.xvcromatica + "," + this.xcampovisialOD + "," + this.xcampovisialOI + ")";
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        System.out.println("ENTROOOOOOOOOO a la tabla de otros");
    }

    private void actualzarSintomas() {
        this.xsql = "UPDATE h_so_optometria_sintomas SET Cefalia=" + this.xcefalea + ", Lagrimeo=" + this.xladrimeo + ", Ardor=" + this.xardor + ", Dolor=" + this.xdolor + " , Secrecion=" + this.xsecrecion + " , Hiperemia=" + this.xhiperemia + " , `Vision borrosa VL`=" + this.visionVL + "  , `Vision borrosa VC`=" + this.xvisionVC + "  , Fotofobia=" + this.xfotofobia + "  , `Fatiga Visual`=" + this.xfatigaV + " , `Vision Doble`=" + this.xvisiondoble + " , `Salto de Renglon`=" + this.xsaltoR + " , Otros=" + this.xotros + " , Ninguno=" + this.xninguno + "  WHERE (id_optometria=" + this.xoptometria + ")";
        System.out.println(this.xsql1);
        this.xct.ejecutarSQL(this.xsql);
    }

    private void actualzarExamnes() {
        this.xsql = "UPDATE h_so_optometria_examen_externo SET Pterigio= " + this.xptrigio + ", Pinguecula=" + this.xpinguecula + ", Ptosis=" + this.xptosis + ", Secrecion=" + this.ysecrecion + ", Hiperemia=" + this.yhiperemia + " , Nistagmus=" + this.xnistagmus + " , Otros=" + this.yotros + "  , Observacion='" + this.JTAObservacion1.getText() + "'  WHERE (id_optometria =" + this.xoptometria + ")";
        System.out.println(this.xsql1);
        this.xct.ejecutarSQL(this.xsql);
    }

    private void actualzarotros() {
        if (this.JTQueratometroOD.getText().equals("")) {
            this.JTQueratometroOD.setText("0");
        }
        if (this.JTQueratometroOI.getText().equals("")) {
            this.JTQueratometroOI.setText("0");
        }
        if (this.JTLensometroOD.getText().equals("")) {
            this.JTLensometroOD.setText("0");
        }
        if (this.JTFLensometroOI.getText().equals("")) {
            this.JTFLensometroOI.setText("0");
        }
        this.xsql = "UPDATE h_so_optometria_otros SET `Oftalmoscopia OD`=" + this.xoftalmoscopiaOD + ", `Oftalmoscopia OI`=" + this.xoftalmoscopiaOI + ", Hallazgos='" + this.JTHallazgos.getText() + "', `Queratometro OD`=" + this.JTQueratometroOD.getText() + " , `Queratometro OI`=" + this.JTQueratometroOI.getText() + " , `Lensometro OD`=" + this.JTLensometroOD.getText() + ", `Lensometro OI`=" + this.JTFLensometroOI.getText() + ", `Test Estereopsis`=" + this.xtest + "  , `Vision Cromatica`=" + this.xvcromatica + "\n                 , `Campo Visual OD`=" + this.xcampovisialOD + " , `Campo Visual OI`=" + this.xcampovisialOI + " WHERE (id_optometria=" + this.xoptometria + ")";
        System.out.println(this.xsql1);
        this.xct.ejecutarSQL(this.xsql);
    }

    private void mGrabarBd() {
        this.xsql = "insert into h_so_optometria (`Id_Atencion` , `Prescripcion` , `LO` , `LC`  , `TiempoUso` , `TipoVision` , `FechaCambio` , `RxODEsfera`  , `RxODCilindro`  , `RxODEje` , `RxODAV` , `RxOIEsfera` , `RxOICilindro` , `RxOIEje` , `RxOIAV` , `TipoLenteRxUso` , `TipoFiltroRxUso` , `RxOpticaSeg` , `TipoLenteSeg` , `TipoFiltroSeg` , `RxSegODEsfera` , `RxSegODCilindro` , `RxSegODEje` , `RxSegODAV`  , `RxSegOIEsfera` , `RxSegOICilindro` , `RxSegOIEje` , `RxSegOIAV` , `SCODVL` , `PersonalODVL` , `SeguridadODVL`  , `SCOIVL`  , `PersonalOIVL` , `SeguridadOIVL`, `SCOAVL` , `PersonalOAVL` , `SeguridadOAVL` , `SCODVP` , `PersonalODVP` , `SeguridadODVP` , `SCOIVP` , `PersonalOIVP` , `SeguridadOIVP`  , `SCOAVP` , `PersonalOAVP`, `SeguridadOAVP` , `CorrecionOpt` , `LenteOft` , `LenteCont` , `Elementos` , `TipoLenteConducta` , `TipoFiltro` , `Color`  ,  ObservacionElemento, EstadoHC, `UsuarioS`, Id_Profesional, Id_Especialidad) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xprescripcion + "','" + this.xlo + "','" + this.xlc + "','" + this.xtiempouso + "','" + this.xtipovision + "','" + this.xmt.formatoAMD.format(this.JDFechaCambio.getDate()) + "','" + this.JTFODEsfera.getText() + "','" + this.JTFODCilindro.getText() + "','" + this.JTFODEje.getText() + "','" + this.JTFODAV.getText() + "','" + this.JTFOIEsfera.getText() + "','" + this.JTFOICilindro.getText() + "','" + this.JTFOIEje.getText() + "','" + this.JTFOIAV.getText() + "','" + this.xtipolenterxuso + "','" + this.xtipofiltrorxuso + "','" + this.xRxOpticaSeg + "','" + this.xTipoLenteOpticaSeg + "','" + this.xTipoFiltroOpticaSeg + "','" + this.JTFODEsferaRxUso.getText() + "','" + this.JTFODCilindroRxUso.getText() + "','" + this.JTFODEjeRxUso.getText() + "','" + this.JTFODAVRxUso.getText() + "','" + this.JTFOIEsferaRxUso.getText() + "','" + this.JTFOICilindroRxUso.getText() + "','" + this.JTFOIEjeRxUso.getText() + "','" + this.JTFOIAVRxUso.getText() + "','" + this.JTFODSCVL.getText() + "','" + this.JTFODPersonalVL.getText() + "','" + this.JTFODSeguridadVL.getText() + "','" + this.JTFOISCVL.getText() + "','" + this.JTFOIPersonalVL.getText() + "','" + this.JTFOISeguridadVL.getText() + "','" + this.JTFOASCVL.getText() + "','" + this.JTFOAPersonalVL.getText() + "','" + this.JTFOASeguridadVL.getText() + "','" + this.JTFODSCVP.getText() + "','" + this.JTFODPersonalVP.getText() + "','" + this.JTFODSeguridadVP.getText() + "','" + this.JTFOISCVP.getText() + "','" + this.JTFOIPersonalVP.getText() + "','" + this.JTFOISeguridadVP.getText() + "','" + this.JTFOASCVP.getText() + "','" + this.JTFOAPersonalVP.getText() + "','" + this.JTFOASeguridadVP.getText() + "','" + this.xcorrecionOptica + "','" + this.xlenteOftalmico + "','" + this.xlenteContacto + "','" + this.xelementoProteccion + "','" + this.xtipolenteElemento + "','" + this.xtipofiltroElemento + "','" + this.JTFColor.getText() + "','" + this.JTAObservacion.getText() + "','" + this.xEstadoHC + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "')";
        this.xoptometria = this.xct.ejecutarSQLId(this.xsql);
        this.xct.cerrarConexionBd();
        System.out.println("ENTROOOOOOOOOO");
        System.out.println(this.adjunto);
        System.out.println("optometria id : " + this.xoptometria);
        this.adjunto = this.xoptometria + ".png";
        this.directorio = new File(this.xmt.mRutaSoporte("JPSo_Optometria"));
        System.out.println(this.directorio);
        makeScreenshot(String.valueOf(this.directorio), String.valueOf(this.xoptometria), this.contenedor);
        System.out.println("Finalizò");
        this.xsql = "UPDATE h_so_optometria set ImagenOptometria='" + this.adjunto + "' WHERE Id='" + this.xoptometria + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` , Var_ADD, `AV`) values ('" + this.xoptometria + "','1','1','1','" + this.JTFODEsferaRet.getText() + "','" + this.JTFODCilindroRet.getText() + "','" + this.JTFODEjeRet.getText() + "','NA','" + this.JTFODAVRet.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','1','1','0','" + this.JTFOIEsferaRet.getText() + "','" + this.JTFOICilindroRet.getText() + "','" + this.JTFOIEjeRet.getText() + "','NA','" + this.JTFOIAVRet.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','2','1','1','" + this.JTFODEsferaSub.getText() + "','" + this.JTFODCilindroSub.getText() + "','" + this.JTFODEjeSub.getText() + "','NA','" + this.JTFODAVSub.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','2','1','0','" + this.JTFOIEsferaSub.getText() + "','" + this.JTFOICilindroSub.getText() + "','" + this.JTFOIEjeSub.getText() + "','NA','" + this.JTFOIAVSub.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','3','2','1','" + this.JTFODEsferaRxFinal.getText() + "','" + this.JTFODCilindroRxFinal.getText() + "','" + this.JTFODEjeRxFinal.getText() + "','" + this.JTFODAddRxFinal.getText() + "','" + this.JTFODAVRxFinal.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','3','2','0','" + this.JTFOIEsferaRxFinal.getText() + "','" + this.JTFOICilindroRxFinal.getText() + "','" + this.JTFOIEjeRxFinal.getText() + "','" + this.JTFOIAddRxFinal.getText() + "','" + this.JTFOIAVRxFinal.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','3','3','1','" + this.JTFODEsferaRxFinalVP.getText() + "','" + this.JTFODCilindroRxFinalVP.getText() + "','" + this.JTFODEjeRxFinalVP.getText() + "','" + this.JTFODAddRxFinalVP.getText() + "','" + this.JTFODAVRxFinalVP.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_so_optometria_detalle(`Id_Optometria`  , `Encabezado` , `TipoVision`  , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` ,Var_ADD, `AV`) values ('" + this.xoptometria + "','3','3','0','" + this.JTFOIEsferaRxFinalVP.getText() + "','" + this.JTFOICilindroRxFinalVP.getText() + "','" + this.JTFOIEjeRxFinalVP.getText() + "','" + this.JTFOIAddRxFinalVP.getText() + "','" + this.JTFOIAVRxFinalVP.getText() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.aDiagnostico.grabar();
        Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento(2);
    }

    private void mActulizarBd() {
        String sql1 = "UPDATE h_so_optometria SET `Prescripcion`='" + this.xprescripcion + "' , `LO`='" + this.xlo + "' , `LC`='" + this.xlc + "'  , `TiempoUso`='" + this.xtiempouso + "' , `TipoVision`='" + this.xtipovision + "' , `FechaCambio`='" + this.xmt.formatoAMD.format(this.JDFechaCambio.getDate()) + "' , `RxODEsfera`='" + this.JTFODEsfera.getText() + "'  , `RxODCilindro`='" + this.JTFODCilindro.getText() + "'  , `RxODEje`='" + this.JTFODEje.getText() + "'  , `RxODAV`='" + this.JTFODAV.getText() + "' , `RxOIEsfera`='" + this.JTFOIEsfera.getText() + "' , `RxOICilindro`='" + this.JTFOICilindro.getText() + "' , `RxOIEje`='" + this.JTFOIEje.getText() + "' , `RxOIAV`='" + this.JTFOIAV.getText() + "' , `TipoLenteRxUso`='" + this.xtipolenterxuso + "' , `TipoFiltroRxUso`='" + this.xtipofiltrorxuso + "' , `RxOpticaSeg`='" + this.xRxOpticaSeg + "' , `TipoLenteSeg`='" + this.xTipoLenteOpticaSeg + "' , `TipoFiltroSeg`='" + this.xTipoFiltroOpticaSeg + "' , `RxSegODEsfera`='" + this.JTFODEsferaRxUso.getText() + "' , `RxSegODCilindro`='" + this.JTFODCilindroRxUso.getText() + "' , `RxSegODEje`='" + this.JTFODEjeRxUso.getText() + "' , `RxSegODAV`='" + this.JTFODAVRxUso.getText() + "'  , `RxSegOIEsfera`='" + this.JTFOIEsferaRxUso.getText() + "' , `RxSegOICilindro`='" + this.JTFOICilindroRxUso.getText() + "' , `RxSegOIEje`='" + this.JTFOIEjeRxUso.getText() + "' , `RxSegOIAV`='" + this.JTFOIAVRxUso.getText() + "' , `SCODVL`='" + this.JTFODSCVL.getText() + "' , `PersonalODVL`='" + this.JTFODPersonalVL.getText() + "'  , `SeguridadODVL`='" + this.JTFODSeguridadVL.getText() + "'  , `SCOIVL`='" + this.JTFOISCVL.getText() + "'  , `PersonalOIVL`='" + this.JTFOIPersonalVL.getText() + "' , `SeguridadOIVL`='" + this.JTFOISeguridadVL.getText() + "', `SCOAVL`='" + this.JTFOASCVL.getText() + "' , `PersonalOAVL`='" + this.JTFOAPersonalVL.getText() + "' , `SeguridadOAVL`='" + this.JTFOASeguridadVL.getText() + "' , `SCODVP`='" + this.JTFODSCVP.getText() + "' , `PersonalODVP`='" + this.JTFODPersonalVP.getText() + "' , `SeguridadODVP`='" + this.JTFODSeguridadVP.getText() + "'  , `SCOIVP`='" + this.JTFOISCVP.getText() + "' , `PersonalOIVP`='" + this.JTFOIPersonalVP.getText() + "' , `SeguridadOIVP`='" + this.JTFOISeguridadVP.getText() + "'  , `SCOAVP`='" + this.JTFOASCVP.getText() + "' , `PersonalOAVP`='" + this.JTFOAPersonalVP.getText() + "', `SeguridadOAVP`='" + this.JTFOASeguridadVP.getText() + "' , `CorrecionOpt`='" + this.xcorrecionOptica + "' , `LenteOft`='" + this.xlenteOftalmico + "' , `LenteCont`='" + this.xlenteContacto + "' , `Elementos`='" + this.xelementoProteccion + "'  , `TipoLenteConducta`='" + this.xtipolenteElemento + "' , `TipoFiltro`='" + this.xtipofiltroElemento + "' , `Color`='" + this.JTFColor.getText() + "',  ObservacionElemento='" + this.JTAObservacion.getText() + "', EstadoHC='" + this.xEstadoHC + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "', EstadoHC='" + this.xEstadoHC + "'  WHERE (Id='" + this.xoptometria + "')";
        this.xct.ejecutarSQL(sql1);
        this.xct.cerrarConexionBd();
        makeScreenshot(String.valueOf(this.directorio), String.valueOf(this.xoptometria), this.contenedor);
        String sql2 = "UPDATE h_so_optometria_detalle SET  `Esfera`='" + this.JTFODEsferaRet.getText() + "' , `Cilindro`='" + this.JTFODCilindroRet.getText() + "' , `Eje`='" + this.JTFODEjeRet.getText() + "' , Var_ADD='NA', `AV`='" + this.JTFODAVRet.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=1 AND TipoVision=1 AND LateralidadOjo=1 )";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        String sql3 = "UPDATE h_so_optometria_detalle SET  `Esfera`='" + this.JTFOIEsferaRet.getText() + "' , `Cilindro`='" + this.JTFOICilindroRet.getText() + "' , `Eje`='" + this.JTFOIEjeRet.getText() + "' ,Var_ADD='NA', `AV`='" + this.JTFOIAVRet.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=1 AND TipoVision=1 AND LateralidadOjo=0) ";
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        String sql4 = "UPDATE  h_so_optometria_detalle SET `Esfera`='" + this.JTFODEsferaSub.getText() + "' , `Cilindro`='" + this.JTFODCilindroSub.getText() + "' , `Eje`='" + this.JTFODEjeSub.getText() + "' ,Var_ADD='NA', `AV`='" + this.JTFODAVSub.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=2 AND TipoVision=1 AND LateralidadOjo=1 ) ";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        String sql5 = "UPDATE  h_so_optometria_detalle SET `Esfera`= '" + this.JTFOIEsferaSub.getText() + "', `Cilindro`='" + this.JTFOICilindroSub.getText() + "' , `Eje`='" + this.JTFOIEjeSub.getText() + "' ,Var_ADD='NA', `AV`='" + this.JTFOIAVSub.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=2 AND TipoVision=1 AND LateralidadOjo=0 )";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
        String sql6 = "UPDATE  h_so_optometria_detalle SET `Esfera`='" + this.JTFODEsferaRxFinal.getText() + "' , `Cilindro`='" + this.JTFODCilindroRxFinal.getText() + "' , `Eje`='" + this.JTFODEjeRxFinal.getText() + "' ,Var_ADD='" + this.JTFODAddRxFinal.getText() + "', `AV`='" + this.JTFODAVRxFinal.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=3 AND TipoVision=2 AND LateralidadOjo=1 )";
        this.xct.ejecutarSQL(sql6);
        this.xct.cerrarConexionBd();
        String sql7 = "UPDATE  h_so_optometria_detalle SET `Esfera`='" + this.JTFOIEsferaRxFinal.getText() + "' , `Cilindro`='" + this.JTFOICilindroRxFinal.getText() + "' , `Eje`='" + this.JTFOIEjeRxFinal.getText() + "' ,Var_ADD='" + this.JTFOIAddRxFinal.getText() + "', `AV`='" + this.JTFOIAVRxFinal.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=3 AND TipoVision=2 AND LateralidadOjo=0) ";
        this.xct.ejecutarSQL(sql7);
        this.xct.cerrarConexionBd();
        String sql8 = "UPDATE h_so_optometria_detalle SET `Esfera`='" + this.JTFODEsferaRxFinalVP.getText() + "' , `Cilindro`='" + this.JTFODCilindroRxFinalVP.getText() + "' , `Eje`='" + this.JTFODEjeRxFinalVP.getText() + "' ,Var_ADD='" + this.JTFODAddRxFinalVP.getText() + "', `AV`='" + this.JTFODAVRxFinalVP.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=3 AND TipoVision=3 AND LateralidadOjo=1 )";
        this.xct.ejecutarSQL(sql8);
        this.xct.cerrarConexionBd();
        String sql9 = "UPDATE h_so_optometria_detalle SET  `Esfera`='" + this.JTFOIEsferaRxFinalVP.getText() + "' , `Cilindro`='" + this.JTFOICilindroRxFinalVP.getText() + "' , `Eje`='" + this.JTFOIEjeRxFinalVP.getText() + "' ,Var_ADD='" + this.JTFOIAddRxFinalVP.getText() + "', `AV`='" + this.JTFOIAVRxFinalVP.getText() + "' WHERE (Id_Optometria='" + this.xoptometria + "' AND Encabezado=3 AND TipoVision=3 AND LateralidadOjo=0 )";
        this.xct.ejecutarSQL(sql9);
        this.xct.cerrarConexionBd();
        Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento(2);
        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    private void buscarSintomas() {
        try {
            this.xsql = "SELECT Cefalia , Lagrimeo , Ardor , Dolor , Secrecion, Hiperemia, `Vision borrosa VL` ,`Vision borrosa VC` \n, Fotofobia ,`Fatiga Visual` , `Vision Doble` , `Salto de Renglon`, Otros , Ninguno  FROM h_so_optometria_sintomas hsos WHERE id_Optometria=" + this.xoptometria + "";
            System.out.println("Datos " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong("Cefalia") == 1) {
                    this.JChcefalia.setSelected(true);
                    this.xcefalea = 1L;
                } else {
                    this.JChcefalia.setSelected(false);
                    this.xcefalea = 0L;
                }
                if (xrs.getLong("Lagrimeo") == 1) {
                    this.JCLagrimeo.setSelected(true);
                    this.xladrimeo = 1L;
                } else {
                    this.JCLagrimeo.setSelected(false);
                    this.xladrimeo = 0L;
                }
                if (xrs.getLong("Ardor") == 1) {
                    this.JCArdor.setSelected(true);
                    this.xardor = 1L;
                } else {
                    this.JCArdor.setSelected(false);
                    this.xardor = 0L;
                }
                if (xrs.getLong("Dolor") == 1) {
                    this.JCDolor.setSelected(true);
                    this.xdolor = 1L;
                } else {
                    this.JCDolor.setSelected(false);
                    this.xdolor = 0L;
                }
                if (xrs.getLong("Secrecion") == 1) {
                    this.JCSecrecion.setSelected(true);
                    this.xsecrecion = 1L;
                } else {
                    this.JCSecrecion.setSelected(false);
                    this.xsecrecion = 0L;
                }
                if (xrs.getLong("Hiperemia") == 1) {
                    this.JCHiperemia.setSelected(true);
                    this.xhiperemia = 1L;
                } else {
                    this.JCHiperemia.setSelected(false);
                    this.xhiperemia = 0L;
                }
                if (xrs.getLong("Vision borrosa VL") == 1) {
                    this.JCVisionVL.setSelected(true);
                    this.visionVL = 1L;
                } else {
                    this.JCVisionVL.setSelected(false);
                    this.visionVL = 0L;
                }
                if (xrs.getLong("Vision borrosa VC") == 1) {
                    this.JCVisionVC.setSelected(true);
                    this.xvisionVC = 1L;
                } else {
                    this.JCVisionVC.setSelected(false);
                    this.xvisionVC = 0L;
                }
                if (xrs.getLong("Fotofobia") == 1) {
                    this.JCFotofobia.setSelected(true);
                    this.xfotofobia = 1L;
                } else {
                    this.JCFotofobia.setSelected(false);
                    this.xfotofobia = 0L;
                }
                if (xrs.getLong("Fatiga Visual") == 1) {
                    this.JCFatiga.setSelected(true);
                    this.xfatigaV = 1L;
                } else {
                    this.JCFatiga.setSelected(false);
                    this.xfatigaV = 0L;
                }
                if (xrs.getLong("Vision Doble") == 1) {
                    this.JCVisionD.setSelected(true);
                    this.xvisiondoble = 1L;
                } else {
                    this.JCVisionD.setSelected(false);
                    this.xvisiondoble = 0L;
                }
                if (xrs.getLong("Salto de Renglon") == 1) {
                    this.JCSaltoR.setSelected(true);
                    this.xsaltoR = 1L;
                } else {
                    this.JCSaltoR.setSelected(false);
                    this.xsaltoR = 0L;
                }
                if (xrs.getLong("Otros") == 1) {
                    this.JCotros.setSelected(true);
                    this.xotros = 1L;
                } else {
                    this.JCotros.setSelected(false);
                    this.xotros = 0L;
                }
                if (xrs.getLong("Ninguno") == 1) {
                    this.JCNInguno.setSelected(true);
                    this.xninguno = 1L;
                } else {
                    this.JCNInguno.setSelected(false);
                    this.xninguno = 0L;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Optometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarexamnes() {
        try {
            this.xsql = "SELECT Pterigio,Pinguecula,Ptosis,Secrecion,Hiperemia,Nistagmus ,Otros, Observacion  FROM h_so_optometria_examen_externo hsoee   WHERE id_Optometria=" + this.xoptometria + "";
            System.out.println("Datos " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong("Pterigio") == 1) {
                    this.JCPterigio.setSelected(true);
                    this.xptrigio = 1L;
                } else {
                    this.JCPterigio.setSelected(false);
                    this.xptrigio = 0L;
                }
                if (xrs.getLong("Pinguecula") == 1) {
                    this.JCPinguecula.setSelected(true);
                    this.xpinguecula = 1L;
                } else {
                    this.JCPinguecula.setSelected(false);
                    this.xpinguecula = 0L;
                }
                if (xrs.getLong("Ptosis") == 1) {
                    this.JCPtosis.setSelected(true);
                    this.xptosis = 1L;
                } else {
                    this.JCPtosis.setSelected(false);
                    this.xptosis = 0L;
                }
                if (xrs.getLong("Secrecion") == 1) {
                    this.JSecrecion.setSelected(true);
                    this.ysecrecion = 1L;
                } else {
                    this.JCSecrecion.setSelected(false);
                    this.ysecrecion = 0L;
                }
                if (xrs.getLong("Hiperemia") == 1) {
                    this.JhIPEREMIA.setSelected(true);
                    this.yhiperemia = 1L;
                } else {
                    this.JhIPEREMIA.setSelected(false);
                    this.yhiperemia = 0L;
                }
                if (xrs.getLong("Nistagmus") == 1) {
                    this.JCNistagmus.setSelected(true);
                    this.xnistagmus = 1L;
                } else {
                    this.JCNistagmus.setSelected(false);
                    this.xninguno = 0L;
                }
                if (xrs.getLong("Otros") == 1) {
                    this.JOtros.setSelected(true);
                    this.yotros = 1L;
                } else {
                    this.JOtros.setSelected(false);
                    this.yotros = 0L;
                }
                if (xrs.getString("Observacion") != null) {
                    this.JTAObservacion1.setText(xrs.getString("Observacion"));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Optometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarotros() {
        try {
            this.xsql = "SELECT `Oftalmoscopia OD`  , `Oftalmoscopia OI`  , `Queratometro OD`  , `Queratometro OI`, `Lensometro OD` , `Lensometro OI` , `Test Estereopsis`  ,`Vision Cromatica`  \n, `Campo Visual OD`  ,`Campo Visual OI`  , Hallazgos   FROM h_so_optometria_otros hsoo  WHERE id_Optometria=" + this.xoptometria + "";
            System.out.println("Datos " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong("Oftalmoscopia OD") == 1) {
                    this.jRadioButton2.setSelected(true);
                    this.xoftalmoscopiaOD = 1L;
                } else {
                    this.jRadioButton1.setSelected(true);
                    this.xoftalmoscopiaOD = 0L;
                }
                if (xrs.getLong("Oftalmoscopia OI") == 1) {
                    this.jRadioButton4.setSelected(true);
                    this.xoftalmoscopiaOI = 1L;
                } else {
                    this.jRadioButton3.setSelected(true);
                    this.xoftalmoscopiaOI = 0L;
                }
                if (xrs.getDouble("Queratometro OD") != 0.0d) {
                    this.JTQueratometroOD.setText(String.valueOf(xrs.getDouble("Queratometro OD")));
                } else {
                    this.JTQueratometroOD.setText("");
                }
                if (xrs.getDouble("Queratometro OI") != 0.0d) {
                    this.JTQueratometroOI.setText(String.valueOf(xrs.getDouble("Queratometro OI")));
                } else {
                    this.JTQueratometroOD.setText("");
                }
                if (xrs.getDouble("Lensometro OD") != 0.0d) {
                    this.JTLensometroOD.setText(String.valueOf(xrs.getDouble("Lensometro OD")));
                } else {
                    this.JTLensometroOD.setText("");
                }
                if (xrs.getDouble("Lensometro OI") != 0.0d) {
                    this.JTFLensometroOI.setText(String.valueOf(xrs.getDouble("Lensometro OI")));
                } else {
                    this.JTFLensometroOI.setText("");
                }
                if (xrs.getLong("Test Estereopsis") == 1) {
                    this.jRadioButton5.setSelected(true);
                    this.xtest = 1L;
                } else {
                    this.jRadioButton6.setSelected(true);
                    this.xtest = 0L;
                }
                if (xrs.getLong("Vision Cromatica") == 1) {
                    this.jRadioButton8.setSelected(true);
                    this.xvcromatica = 1L;
                } else {
                    this.jRadioButton7.setSelected(true);
                    this.xvcromatica = 0L;
                }
                if (xrs.getLong("Campo Visual OD") == 1) {
                    this.jRadioButton10.setSelected(true);
                    this.xcampovisialOD = 1L;
                } else {
                    this.jRadioButton9.setSelected(true);
                    this.xcampovisialOD = 0L;
                }
                if (xrs.getLong("Campo Visual OI") == 1) {
                    this.jRadioButton12.setSelected(true);
                    this.xcampovisialOI = 1L;
                } else {
                    this.jRadioButton11.setSelected(true);
                    this.xcampovisialOI = 0L;
                }
                if (xrs.getString("Hallazgos") != null) {
                    this.JTHallazgos.setText(xrs.getString("Hallazgos"));
                } else {
                    this.JTHallazgos.setText("");
                }
                if (this.JTQueratometroOD.getText().equals("")) {
                    this.JTQueratometroOD.setText("0");
                }
                if (this.JTQueratometroOI.getText().equals("")) {
                    this.JTQueratometroOI.setText("0");
                }
                if (this.JTLensometroOD.getText().equals("")) {
                    this.JTLensometroOD.setText("0");
                }
                if (this.JTFLensometroOI.getText().equals("")) {
                    this.JTFLensometroOI.setText("0");
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Optometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosBd() {
        try {
            this.xsql = "SELECT Id, `Prescripcion` , `LO` , `LC`  , `TiempoUso` , `TipoVision` , `FechaCambio` , `RxODEsfera`  , `RxODCilindro`  , `RxODEje` , `RxODAV` , `RxOIEsfera` , `RxOICilindro` , `RxOIEje` , `RxOIAV` , `TipoLenteRxUso` , `TipoFiltroRxUso` , `RxOpticaSeg` , `TipoLenteSeg` , `TipoFiltroSeg` , `RxSegODEsfera` , `RxSegODCilindro` , `RxSegODEje` , `RxSegODAV`  , `RxSegOIEsfera` , `RxSegOICilindro` , `RxSegOIEje` , `RxSegOIAV` , `SCODVL` , `PersonalODVL` , `SeguridadODVL`  , `SCOIVL`  , `PersonalOIVL` , `SeguridadOIVL`, `SCOAVL` , `PersonalOAVL` , `SeguridadOAVL` , `SCODVP` , `PersonalODVP` , `SeguridadODVP` , `SCOIVP` , `PersonalOIVP` , `SeguridadOIVP`  , `SCOAVP` , `PersonalOAVP`, `SeguridadOAVP` , `CorrecionOpt` , `LenteOft` , `LenteCont` , `Elementos` , `TipoLenteConducta` , `TipoFiltro` , `Color` ,`ImagenOptometria` , ObservacionElemento, `Id_Atencion`, EstadoHC FROM `h_so_optometria` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
            System.out.println("Datos " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong("Prescripcion") == 1) {
                    this.JRBSiPrescipcion.setSelected(true);
                    this.xprescripcion = 1L;
                } else {
                    this.JRBNoPrescipcion.setSelected(true);
                    this.xprescripcion = 0L;
                }
                if (xrs.getLong("LO") == 1) {
                    this.JCHLO.setSelected(true);
                    this.xlo = 1L;
                } else {
                    this.JCHLO.setSelected(false);
                    this.xlo = 0L;
                }
                if (xrs.getLong("LC") == 1) {
                    this.JCHLC.setSelected(true);
                    this.xlc = 1L;
                } else {
                    this.JCHLC.setSelected(false);
                    this.xlc = 0L;
                }
                if (xrs.getLong("TiempoUso") == 0) {
                    this.JRBPermanente.setSelected(true);
                    this.xtiempouso = 0L;
                } else {
                    this.JRBEsporadico.setSelected(true);
                    this.xtiempouso = 1L;
                }
                if (xrs.getLong("TipoVision") == 0) {
                    this.JCHVL.setSelected(true);
                    this.xtipovision = 0L;
                } else {
                    this.JCHVP.setSelected(true);
                    this.xtipovision = 1L;
                }
                this.JDFechaCambio.setDate(xrs.getDate("FechaCambio"));
                this.JTFODEsfera.setText(xrs.getString("RxODEsfera"));
                this.JTFODCilindro.setText(xrs.getString("RxODCilindro"));
                this.JTFODEje.setText(xrs.getString("RxODEje"));
                this.JTFODAV.setText(xrs.getString("RxODAV"));
                this.JTFOIEsfera.setText(xrs.getString("RxOIEsfera"));
                this.JTFOICilindro.setText(xrs.getString("RxOICilindro"));
                this.JTFOIEje.setText(xrs.getString("RxOIEje"));
                this.directorio = new File(this.xmt.mRutaSoporte("JPSo_Optometria"));
                System.out.println(this.JLImagen.getIcon());
                this.adjunto = xrs.getString("ImagenOptometria");
                System.out.println(this.adjunto);
                String ruta = this.directorio + "/" + this.adjunto;
                System.out.println(ruta);
                System.out.println("Directorio" + this.directorio);
                System.out.println();
                ImageIcon iid = new ImageIcon(ruta);
                this.JLImagen.setIcon(iid);
                this.JTFOIAV.setText(xrs.getString("RxOIAV"));
                if (xrs.getLong("TipoLenteRxUso") == 0) {
                    this.JRBDGTLNinguno.setSelected(true);
                    this.xtipolenterxuso = 0L;
                } else if (xrs.getLong("TipoLenteRxUso") == 1) {
                    this.xtipolenterxuso = 1L;
                    this.JRBDGTLProgresivo.setSelected(true);
                } else if (xrs.getLong("TipoLenteRxUso") == 2) {
                    this.xtipolenterxuso = 2L;
                    this.JRBDGTLBifocales.setSelected(true);
                } else if (xrs.getLong("TipoLenteRxUso") == 3) {
                    this.xtipolenterxuso = 3L;
                    this.JRBDGTLMonofocales.setSelected(true);
                }
                if (xrs.getLong("TipoFiltroRxUso") == 0) {
                    this.JRBUV.setSelected(true);
                    this.xtipofiltrorxuso = 0L;
                } else if (xrs.getLong("TipoFiltroRxUso") == 1) {
                    this.JRBGrado.setSelected(true);
                    this.xtipofiltrorxuso = 1L;
                } else if (xrs.getLong("TipoFiltroRxUso") == 2) {
                    this.JRBTransicion.setSelected(true);
                    this.xtipofiltrorxuso = 2L;
                } else if (xrs.getLong("TipoFiltroRxUso") == 3) {
                    this.JRBNinguno.setSelected(true);
                    this.xtipofiltrorxuso = 3L;
                }
                if (xrs.getLong("RxOpticaSeg") == 1) {
                    this.JRBSiRxSeguridad.setSelected(true);
                    this.xRxOpticaSeg = 1L;
                } else {
                    this.JRBNoRxSeguridad.setSelected(true);
                    this.xRxOpticaSeg = 0L;
                }
                if (xrs.getLong("TipoLenteSeg") == 0) {
                    this.JRBDGTLNingunoRx.setSelected(true);
                    this.xTipoLenteOpticaSeg = 0L;
                } else if (xrs.getLong("TipoLenteSeg") == 1) {
                    this.JRBDGTLProgresivoRx.setSelected(true);
                    this.xTipoLenteOpticaSeg = 1L;
                } else if (xrs.getLong("TipoLenteSeg") == 2) {
                    this.JRBDGTLBifocalesRx.setSelected(true);
                    this.xTipoLenteOpticaSeg = 2L;
                } else if (xrs.getLong("TipoLenteSeg") == 3) {
                    this.JRBDGTLMonofocalesRx.setSelected(true);
                    this.xTipoLenteOpticaSeg = 3L;
                }
                if (xrs.getLong("TipoFiltroSeg") == 0) {
                    this.JRBUVRx.setSelected(true);
                    this.xTipoFiltroOpticaSeg = 0L;
                } else if (xrs.getLong("TipoFiltroSeg") == 1) {
                    this.JRBGradoRx.setSelected(true);
                    this.xTipoFiltroOpticaSeg = 1L;
                } else if (xrs.getLong("TipoFiltroSeg") == 2) {
                    this.JRBSTransicionRx.setSelected(true);
                    this.xTipoFiltroOpticaSeg = 2L;
                } else if (xrs.getLong("TipoFiltroSeg") == 3) {
                    this.JRBNingunoRx.setSelected(true);
                    this.xTipoFiltroOpticaSeg = 3L;
                }
                this.JTFODEsferaRxUso.setText(xrs.getString("RxSegODEsfera"));
                this.JTFODCilindroRxUso.setText(xrs.getString("RxSegODCilindro"));
                this.JTFODEjeRxUso.setText(xrs.getString("RxSegODEje"));
                this.JTFODAVRxUso.setText(xrs.getString("RxSegODAV"));
                this.JTFOIEsferaRxUso.setText(xrs.getString("RxSegOIEsfera"));
                this.JTFOICilindroRxUso.setText(xrs.getString("RxSegOICilindro"));
                this.JTFOIEjeRxUso.setText(xrs.getString("RxSegOIEje"));
                this.JTFOIAVRxUso.setText(xrs.getString("RxSegOIAV"));
                this.JTFODSCVL.setText(xrs.getString("SCODVL"));
                this.JTFODPersonalVL.setText(xrs.getString("PersonalODVL"));
                this.JTFODSeguridadVL.setText(xrs.getString("SeguridadODVL"));
                this.JTFOISCVL.setText(xrs.getString("SCOIVL"));
                this.JTFOIPersonalVL.setText(xrs.getString("PersonalOIVL"));
                this.JTFOISeguridadVL.setText(xrs.getString("SeguridadOIVL"));
                this.JTFOASCVL.setText(xrs.getString("SCOAVL"));
                this.JTFOAPersonalVL.setText(xrs.getString("PersonalOAVL"));
                this.JTFOASeguridadVL.setText(xrs.getString("SeguridadOAVL"));
                this.JTFODSCVP.setText(xrs.getString("SCODVP"));
                this.JTFODPersonalVP.setText(xrs.getString("PersonalODVP"));
                this.JTFODSeguridadVP.setText(xrs.getString("SeguridadODVP"));
                this.JTFOISCVP.setText(xrs.getString("SCOIVP"));
                this.JTFOIPersonalVP.setText(xrs.getString("PersonalOIVP"));
                this.JTFOISeguridadVP.setText(xrs.getString("SeguridadOIVP"));
                this.JTFOASCVP.setText(xrs.getString("SCOAVP"));
                this.JTFOAPersonalVP.setText(xrs.getString("PersonalOAVP"));
                this.JTFOASeguridadVP.setText(xrs.getString("SeguridadOAVP"));
                if (xrs.getLong("CorrecionOpt") == 1) {
                    this.JRBSiCorrecionOpt.setSelected(true);
                    this.xcorrecionOptica = 1L;
                } else {
                    this.JRBNoCorrecionOpt.setSelected(true);
                    this.xcorrecionOptica = 0L;
                }
                if (xrs.getLong("LenteOft") == 1) {
                    this.JCHLOftalmico.setSelected(true);
                    this.xlenteOftalmico = 1L;
                } else {
                    this.JCHLOftalmico.setSelected(false);
                    this.xlenteOftalmico = 0L;
                }
                if (xrs.getLong("LenteCont") == 1) {
                    this.JCHLCotacto.setSelected(true);
                    this.xlenteContacto = 1L;
                } else {
                    this.JCHLCotacto.setSelected(false);
                    this.xlenteContacto = 0L;
                }
                if (xrs.getLong("Elementos") == 1) {
                    this.JRBSiElementos.setSelected(true);
                    this.xelementoProteccion = 1L;
                } else {
                    this.JRBNoElementos.setSelected(true);
                    this.xelementoProteccion = 0L;
                }
                this.JTAObservacion.setText(xrs.getString("ObservacionElemento"));
                if (xrs.getLong("TipoLenteConducta") == 0) {
                    this.JRBDGTLNingunoConducta.setSelected(true);
                    this.xtipolenteElemento = 0L;
                } else if (xrs.getLong("TipoLenteConducta") == 1) {
                    this.JRBDGTLProgresivoConducta.setSelected(true);
                    this.xtipolenteElemento = 1L;
                } else if (xrs.getLong("TipoLenteConducta") == 2) {
                    this.JRBDGTLBifocalesConducta.setSelected(true);
                    this.xtipolenteElemento = 2L;
                } else if (xrs.getLong("TipoLenteConducta") == 3) {
                    this.JRBDGTLMonofocalesConducta.setSelected(true);
                    this.xtipolenteElemento = 3L;
                }
                if (xrs.getLong("TipoFiltro") == 0) {
                    this.JRBUVConducta.setSelected(true);
                    this.xtipofiltroElemento = 0L;
                } else if (xrs.getLong("TipoFiltro") == 1) {
                    this.JRBGradoConducta.setSelected(true);
                    this.xtipofiltroElemento = 1L;
                } else if (xrs.getLong("TipoFiltro") == 2) {
                    this.JRBSTransicionConducta.setSelected(true);
                    this.xtipofiltroElemento = 2L;
                } else if (xrs.getLong("TipoFiltro") == 3) {
                    this.JRBNingunoConducta.setSelected(true);
                    this.xtipofiltroElemento = 3L;
                }
                this.JTFColor.setText(xrs.getString("Color"));
                if (xrs.getString("EstadoHC").equals("2")) {
                    this.JBGuardar.setEnabled(false);
                }
                this.xEstadoHC = xrs.getLong("EstadoHC");
                this.JLB_Id.setText(xrs.getString("Id"));
                this.xoptometria = xrs.getString("Id");
                String sql1 = "SELECT `Encabezado` , `TipoVision` , `LateralidadOjo` , `Esfera` , `Cilindro` , `Eje` , `Var_ADD`, `AV` FROM `h_so_optometria_detalle` WHERE (`Id_Optometria` ='" + xrs.getString("Id") + "')";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs1 = xct1.traerRs(sql1);
                if (xrs1.next()) {
                    xrs1.beforeFirst();
                    int n = 0;
                    while (xrs1.next()) {
                        if (xrs1.getLong("Encabezado") == 1) {
                            if (xrs1.getLong("TipoVision") == 1) {
                                if (xrs1.getLong("LateralidadOjo") == 1) {
                                    this.JTFODEsferaRet.setText(xrs1.getString("Esfera"));
                                    this.JTFODCilindroRet.setText(xrs1.getString("Cilindro"));
                                    this.JTFODEjeRet.setText(xrs1.getString("Eje"));
                                    this.JTFODAVRet.setText(xrs1.getString("AV"));
                                } else {
                                    this.JTFOIEsferaRet.setText(xrs1.getString("Esfera"));
                                    this.JTFOICilindroRet.setText(xrs1.getString("Cilindro"));
                                    this.JTFOIEjeRet.setText(xrs1.getString("Eje"));
                                    this.JTFOIAVRet.setText(xrs1.getString("AV"));
                                }
                            }
                        } else if (xrs1.getLong("Encabezado") == 2) {
                            if (xrs1.getLong("TipoVision") == 1) {
                                if (xrs1.getLong("LateralidadOjo") == 1) {
                                    this.JTFODEsferaSub.setText(xrs1.getString("Esfera"));
                                    this.JTFODCilindroSub.setText(xrs1.getString("Cilindro"));
                                    this.JTFODEjeSub.setText(xrs1.getString("Eje"));
                                    this.JTFODAVSub.setText(xrs1.getString("AV"));
                                } else {
                                    this.JTFOIEsferaSub.setText(xrs1.getString("Esfera"));
                                    this.JTFOICilindroSub.setText(xrs1.getString("Cilindro"));
                                    this.JTFOIEjeSub.setText(xrs1.getString("Eje"));
                                    this.JTFOIAVSub.setText(xrs1.getString("AV"));
                                }
                            }
                        } else if (xrs1.getLong("Encabezado") == 3) {
                            if (xrs1.getLong("TipoVision") == 2) {
                                if (xrs1.getLong("LateralidadOjo") == 1) {
                                    this.JTFODEsferaRxFinal.setText(xrs1.getString("Esfera"));
                                    this.JTFODCilindroRxFinal.setText(xrs1.getString("Cilindro"));
                                    this.JTFODEjeRxFinal.setText(xrs1.getString("Eje"));
                                    this.JTFODAddRxFinal.setText(xrs1.getString("Var_ADD"));
                                    this.JTFODAVRxFinal.setText(xrs1.getString("AV"));
                                } else {
                                    this.JTFOIEsferaRxFinal.setText(xrs1.getString("Esfera"));
                                    this.JTFOICilindroRxFinal.setText(xrs1.getString("Cilindro"));
                                    this.JTFOIEjeRxFinal.setText(xrs1.getString("Eje"));
                                    this.JTFOIAddRxFinal.setText(xrs1.getString("Var_ADD"));
                                    this.JTFOIAVRxFinal.setText(xrs1.getString("AV"));
                                }
                            } else if (xrs1.getLong("TipoVision") == 3) {
                                if (xrs1.getLong("LateralidadOjo") == 1) {
                                    this.JTFODEsferaRxFinalVP.setText(xrs1.getString("Esfera"));
                                    this.JTFODCilindroRxFinalVP.setText(xrs1.getString("Cilindro"));
                                    this.JTFODEjeRxFinalVP.setText(xrs1.getString("Eje"));
                                    this.JTFODAddRxFinalVP.setText(xrs1.getString("Var_ADD"));
                                    this.JTFODAVRxFinalVP.setText(xrs1.getString("AV"));
                                } else {
                                    this.JTFOIEsferaRxFinalVP.setText(xrs1.getString("Esfera"));
                                    this.JTFOICilindroRxFinalVP.setText(xrs1.getString("Cilindro"));
                                    this.JTFOIEjeRxFinalVP.setText(xrs1.getString("Eje"));
                                    this.JTFOIAddRxFinalVP.setText(xrs1.getString("Var_ADD"));
                                    this.JTFOIAVRxFinalVP.setText(xrs1.getString("AV"));
                                }
                            }
                        }
                        n++;
                        buscarSintomas();
                        buscarexamnes();
                        buscarotros();
                    }
                }
                xrs1.close();
                xct1.cerrarConexionBd();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Optometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarExistencia() {
        try {
            this.xsql = "";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Optometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
