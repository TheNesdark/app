package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Osteomuscular.class */
public class JPSo_Osteomuscular extends JPanel {
    public ResultSet rsi;
    public String sql;
    public String xnombre;
    public DefaultTableModel xmodeloAnteOMA;
    public DefaultTableModel xmodeloh;
    public DefaultTableModel xmodeloDiagActivo;
    public DefaultTableModel xmodeloEvaDolor;
    public DefaultTableModel xmodeloSigEsp;
    public DefaultTableModel xmodeloMovArt;
    public DefaultTableModel xmodeloFuerzaMusc;
    public DefaultTableModel xmodelorecomendacion;
    public DefaultTableModel xmodelonseveridad;
    private Object[] xdatos;
    private clasesHistoriaCE xclase;
    private String[] xiseginteres;
    private String[] xidtipodolor;
    private String[] xidintensidad;
    private String[] xidhallazgoSigEsp;
    private String[] xidhallazgoMovArt;
    private String[] xidhallazgoFuerzaMusc;
    private String[] xidhallazgoOMA;
    private String[] xidResultado;
    private String xid;
    private JButton JBActualizarExamen;
    private ButtonGroup JBDolorOMa;
    private ButtonGroup JBElementos;
    private ButtonGroup JBGAbdomen;
    private ButtonGroup JBGCabeza;
    private ButtonGroup JBGColumna;
    private ButtonGroup JBGCuello;
    private ButtonGroup JBGDorso;
    private ButtonGroup JBGHombros;
    private ButtonGroup JBGLateralidad;
    private ButtonGroup JBGLumbar;
    private ButtonGroup JBGPelvis;
    private ButtonGroup JBGPies;
    private ButtonGroup JBGRodillas;
    private ButtonGroup JBGTipoIncapacidad;
    private ButtonGroup JBGTronco;
    private JButton JBGrabarExamen;
    private JButton JBGuardar;
    private JComboBox JCBCalAparente;
    private JComboBox JCBCalReal;
    private JComboBox JCBCalSeveridad;
    private JComboBox JCBFuerzaMuscular;
    private JComboBox JCBHallazgosMovArt;
    private JComboBox JCBHallazgosOMA;
    private JComboBox JCBHallazgosSigEsp;
    private JComboBox JCBIntensidad;
    private JComboBox JCBMMCortoA;
    private JComboBox JCBMMCortoFinal;
    private JComboBox JCBMMCortoR;
    private JComboBox JCBResultado;
    private JComboBox JCBSegInteres;
    private JComboBox JCBTipoDolor;
    private JCheckBox JCHAplica;
    private JCheckBox JCHBPotencial;
    private JLabel JLCalificacion;
    private JLabel JLCatFlexibilidad;
    private JLabel JLCatFueAbdominal;
    private JLabel JLCatFueBrazos;
    private JLabel JLVistaAnt;
    private JLabel JLVistaLateral;
    private JPanel JPDatos;
    private JPanel JPDatosAntrop;
    private JPanel JPEvaCuaFisicas;
    private JPanel JPEvaDolor;
    private JPanel JPFuerzaMuscular;
    private JPanel JPHallazgoOMA;
    private JPanel JPHistorico;
    private JPanel JPInterpretacion;
    private JPanel JPLingitudMMI;
    private JPanel JPMovArticular;
    private JScrollPane JPNivelSeveridad;
    private JPanel JPParte2;
    private JPanel JPParte3;
    private JPanel JPParte4;
    private JPanel JPSigEspecial;
    private JPanel JPVistaAnt;
    private JPanel JPVistaLateral;
    private JRadioButton JRBAbdomenDesc;
    private JRadioButton JRBAbdomenNormal;
    private JRadioButton JRBAbdomenProtuido;
    private JRadioButton JRBCabAlineada;
    private JRadioButton JRBCabIncliLeve;
    private JRadioButton JRBCabIncliRotada;
    private JRadioButton JRBColAlineada;
    private JRadioButton JRBColCurvaLateral;
    private JRadioButton JRBColEscoliosis;
    private JRadioButton JRBCuelloAlineado;
    private JRadioButton JRBCuelloLevAumento;
    private JRadioButton JRBCuelloRecti;
    private JRadioButton JRBDerecho;
    private JRadioButton JRBDorsoAumento;
    private JRadioButton JRBDorsoNormal;
    private JRadioButton JRBDorsoProtuidos;
    private JRadioButton JRBHomAlineados;
    private JRadioButton JRBHomLevDescendido;
    private JRadioButton JRBHomMarDescenso;
    private JRadioButton JRBIzquierdo;
    private JRadioButton JRBLumbarAumento;
    private JRadioButton JRBLumbarHiper;
    private JRadioButton JRBLumbarNormal;
    private JRadioButton JRBNO_OMA;
    private JRadioButton JRBNoaplica;
    private JRadioButton JRBPelvHemipelvis;
    private JRadioButton JRBPelvIliacas;
    private JRadioButton JRBPelvMarcado;
    private JRadioButton JRBPieAlineado;
    private JRadioButton JRBPieCavo;
    private JRadioButton JRBPiePlano;
    private JRadioButton JRBRodAlineadas;
    private JRadioButton JRBRodValgo;
    private JRadioButton JRBRodVaro;
    private JRadioButton JRBSI_OMA;
    private JRadioButton JRBTroncoAlineado;
    private JRadioButton JRBTroncoInclinacion;
    private JRadioButton JRBTroncoLeve;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPPAnteOMA;
    private JScrollPane JSPPDiagActivos;
    private JScrollPane JSPPEvaDolor;
    public JScrollPane JSPPFuerzaMuscular;
    private JScrollPane JSPPMovArticular;
    private JScrollPane JSPPSignosEspeciales;
    private JScrollPane JSPRecomendaciones;
    private JTextArea JTAHallazgo;
    private JTextArea JTAInterpretacion;
    public JTable JTAnteOMA;
    public JTable JTDetalleHistorico;
    public JTable JTDiagActivos;
    public JTable JTEvaDolor;
    private JTextField JTFDescripcion;
    private JFormattedTextField JTFFADerecha;
    private JFormattedTextField JTFFAIzquierda;
    private JFormattedTextField JTFFColumna1;
    private JFormattedTextField JTFFColumna2;
    private JFormattedTextField JTFFColumna3;
    private JFormattedTextField JTFFColumna4;
    private JFormattedTextField JTFFColumna5;
    private JFormattedTextField JTFFColumna6;
    private JFormattedTextField JTFFPFlexibilidad;
    private JFormattedTextField JTFFPFuAbdominal;
    private JFormattedTextField JTFFPFuBrazos;
    private JFormattedTextField JTFFRDerecha;
    private JFormattedTextField JTFFRIzquierda;
    private JSpinner JTFFSIMC;
    private JSpinner JTFFSPeso;
    private JSpinner JTFFSTalla;
    private JFormattedTextField JTFFSumatoria;
    private JFormattedTextField JTFFVFlexibilidad;
    private JFormattedTextField JTFFVFuAbdominal;
    private JFormattedTextField JTFFVFuBrazos;
    private JTextArea JTFFactoresDism;
    private JTextArea JTFFactoresExa;
    public JTable JTFuerzaMuscular;
    public JTable JTMovArticular;
    public JTable JTNivelSeveridad;
    private JTable JTRecomendaciones;
    public JTable JTSignosEsp;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    Runtime obj = Runtime.getRuntime();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xlongitudmmi = 1;
    private int xdolor = 0;
    private int xpotencial = 0;
    private int xcabeza = 1;
    private int xhombro = 1;
    private int xcolumna = 1;
    private int xpelvis = 1;
    private int xrodilla = 1;
    private int xpies = 1;
    private int xcuello = 1;
    private int xdorso = 1;
    private int xtronco = 1;
    private int xabdomen = 1;
    private int xlumbar = 1;
    private String xexistencia = "";
    private long xguardado = 0;
    private long xlateralidad = 0;
    private double imc = 0.0d;

    public JPSo_Osteomuscular() {
        initComponents();
        this.xidResultado = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=4) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        mVerificarExistenciaExamen();
        mCargarDatosTablaHistorico();
        mBuscarAnteOMA();
        mBuscarDiagActivo();
        mBuscarEvaDolor();
        mBuscarSigEsp();
        mBuscarMovArt();
        mBuscarFuerzaMusc();
        mBuscarRecomendacion();
        mBuscarNSeveridad();
        mLlenarCombos();
        mTraerDatosBD();
    }

    private void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_OMA", mparametros);
        } else {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_OMA1", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r3v173, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v196, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v219, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v527, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v539, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v578, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v77, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v85, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v95, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoIncapacidad = new ButtonGroup();
        this.JBElementos = new ButtonGroup();
        this.JBDolorOMa = new ButtonGroup();
        this.JBGCabeza = new ButtonGroup();
        this.JBGHombros = new ButtonGroup();
        this.JBGColumna = new ButtonGroup();
        this.JBGPelvis = new ButtonGroup();
        this.JBGRodillas = new ButtonGroup();
        this.JBGPies = new ButtonGroup();
        this.JBGCuello = new ButtonGroup();
        this.JBGDorso = new ButtonGroup();
        this.JBGTronco = new ButtonGroup();
        this.JBGAbdomen = new ButtonGroup();
        this.JBGLumbar = new ButtonGroup();
        this.JBGLateralidad = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JPLingitudMMI = new JPanel();
        this.jLabel1 = new JLabel();
        this.JTFFRIzquierda = new JFormattedTextField();
        this.JTFFRDerecha = new JFormattedTextField();
        this.jLabel2 = new JLabel();
        this.JTFFAIzquierda = new JFormattedTextField();
        this.JTFFADerecha = new JFormattedTextField();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JCBCalReal = new JComboBox();
        this.JCBCalAparente = new JComboBox();
        this.JCBMMCortoR = new JComboBox();
        this.JCBMMCortoA = new JComboBox();
        this.JCBMMCortoFinal = new JComboBox();
        this.JCHAplica = new JCheckBox();
        this.JSPPAnteOMA = new JScrollPane();
        this.JTAnteOMA = new JTable();
        this.JSPPDiagActivos = new JScrollPane();
        this.JTDiagActivos = new JTable();
        this.JPEvaDolor = new JPanel();
        this.JSPPEvaDolor = new JScrollPane();
        this.JTEvaDolor = new JTable();
        this.JCBSegInteres = new JComboBox();
        this.JRBSI_OMA = new JRadioButton();
        this.JRBNO_OMA = new JRadioButton();
        this.jLabel5 = new JLabel();
        this.JCBTipoDolor = new JComboBox();
        this.JCBIntensidad = new JComboBox();
        this.JRBDerecho = new JRadioButton();
        this.JRBIzquierdo = new JRadioButton();
        this.JRBNoaplica = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTFFactoresExa = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.JTFFactoresDism = new JTextArea();
        this.JPParte2 = new JPanel();
        this.JPSigEspecial = new JPanel();
        this.JSPPSignosEspeciales = new JScrollPane();
        this.JTSignosEsp = new JTable();
        this.JCBHallazgosSigEsp = new JComboBox();
        this.JPMovArticular = new JPanel();
        this.JSPPMovArticular = new JScrollPane();
        this.JTMovArticular = new JTable();
        this.JCBHallazgosMovArt = new JComboBox();
        this.JPFuerzaMuscular = new JPanel();
        this.JSPPFuerzaMuscular = new JScrollPane();
        this.JTFuerzaMuscular = new JTable();
        this.JCBFuerzaMuscular = new JComboBox();
        this.JPDatosAntrop = new JPanel();
        this.JTFFSTalla = new JSpinner();
        this.JTFFSPeso = new JSpinner();
        this.JTFFSIMC = new JSpinner();
        this.JPParte3 = new JPanel();
        this.JPVistaAnt = new JPanel();
        this.JRBCabAlineada = new JRadioButton();
        this.JRBCabIncliLeve = new JRadioButton();
        this.JRBCabIncliRotada = new JRadioButton();
        this.JRBHomAlineados = new JRadioButton();
        this.JRBHomLevDescendido = new JRadioButton();
        this.JRBHomMarDescenso = new JRadioButton();
        this.JRBColAlineada = new JRadioButton();
        this.JRBColEscoliosis = new JRadioButton();
        this.JRBColCurvaLateral = new JRadioButton();
        this.JRBPelvIliacas = new JRadioButton();
        this.JRBPelvHemipelvis = new JRadioButton();
        this.JRBPelvMarcado = new JRadioButton();
        this.JRBRodAlineadas = new JRadioButton();
        this.JRBRodValgo = new JRadioButton();
        this.JRBRodVaro = new JRadioButton();
        this.JRBPieAlineado = new JRadioButton();
        this.JRBPiePlano = new JRadioButton();
        this.JRBPieCavo = new JRadioButton();
        this.JLVistaAnt = new JLabel();
        this.JPVistaLateral = new JPanel();
        this.JRBCuelloAlineado = new JRadioButton();
        this.JRBCuelloLevAumento = new JRadioButton();
        this.JRBCuelloRecti = new JRadioButton();
        this.JRBDorsoNormal = new JRadioButton();
        this.JRBDorsoAumento = new JRadioButton();
        this.JRBDorsoProtuidos = new JRadioButton();
        this.JRBTroncoAlineado = new JRadioButton();
        this.JRBTroncoLeve = new JRadioButton();
        this.JRBTroncoInclinacion = new JRadioButton();
        this.JRBAbdomenNormal = new JRadioButton();
        this.JRBAbdomenProtuido = new JRadioButton();
        this.JRBAbdomenDesc = new JRadioButton();
        this.JRBLumbarNormal = new JRadioButton();
        this.JRBLumbarAumento = new JRadioButton();
        this.JRBLumbarHiper = new JRadioButton();
        this.JLVistaLateral = new JLabel();
        this.JTFFColumna1 = new JFormattedTextField();
        this.JTFFColumna2 = new JFormattedTextField();
        this.JTFFColumna3 = new JFormattedTextField();
        this.JTFFColumna4 = new JFormattedTextField();
        this.JTFFColumna5 = new JFormattedTextField();
        this.JTFFColumna6 = new JFormattedTextField();
        this.JTFFSumatoria = new JFormattedTextField();
        this.JLCalificacion = new JLabel();
        this.JTFDescripcion = new JTextField();
        this.JPParte4 = new JPanel();
        this.JPEvaCuaFisicas = new JPanel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.JTFFVFlexibilidad = new JFormattedTextField();
        this.jLabel11 = new JLabel();
        this.JTFFPFlexibilidad = new JFormattedTextField();
        this.JTFFVFuAbdominal = new JFormattedTextField();
        this.JTFFPFuAbdominal = new JFormattedTextField();
        this.JTFFVFuBrazos = new JFormattedTextField();
        this.JTFFPFuBrazos = new JFormattedTextField();
        this.jLabel12 = new JLabel();
        this.JLCatFlexibilidad = new JLabel();
        this.JLCatFueAbdominal = new JLabel();
        this.JLCatFueBrazos = new JLabel();
        this.JPHallazgoOMA = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAHallazgo = new JTextArea();
        this.JCBHallazgosOMA = new JComboBox();
        this.JCHBPotencial = new JCheckBox();
        this.JSPRecomendaciones = new JScrollPane();
        this.JTRecomendaciones = new JTable();
        this.JBGrabarExamen = new JButton();
        this.JPNivelSeveridad = new JScrollPane();
        this.JTNivelSeveridad = new JTable();
        this.JCBCalSeveridad = new JComboBox();
        this.JBActualizarExamen = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JBGuardar = new JButton();
        this.JPInterpretacion = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTAInterpretacion = new JTextArea();
        this.JCBResultado = new JComboBox();
        setBorder(BorderFactory.createTitledBorder((Border) null, "PROGRAMA DE PREVENCIÓN DE LESIONES OSTEOMUSCULOARTICULARES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifosteomuscular");
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPLingitudMMI.setBorder(BorderFactory.createTitledBorder((Border) null, "LONGITUD DE MMII", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Real");
        this.JTFFRIzquierda.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFRIzquierda.setHorizontalAlignment(4);
        this.JTFFRIzquierda.setText("0");
        this.JTFFRIzquierda.setFont(new Font("Arial", 1, 12));
        this.JTFFRIzquierda.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JTFFRIzquierdaActionPerformed(evt);
            }
        });
        this.JTFFRIzquierda.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Osteomuscular.2
            public void focusGained(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFRIzquierdaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFRIzquierdaFocusLost(evt);
            }
        });
        this.JTFFRIzquierda.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Osteomuscular.3
            public void keyPressed(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFRIzquierdaKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFRIzquierdaKeyTyped(evt);
            }
        });
        this.JTFFRDerecha.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFRDerecha.setHorizontalAlignment(4);
        this.JTFFRDerecha.setText("0");
        this.JTFFRDerecha.setFont(new Font("Arial", 1, 12));
        this.JTFFRDerecha.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JTFFRDerechaActionPerformed(evt);
            }
        });
        this.JTFFRDerecha.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Osteomuscular.5
            public void focusLost(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFRDerechaFocusLost(evt);
            }
        });
        this.JTFFRDerecha.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Osteomuscular.6
            public void keyPressed(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFRDerechaKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFRDerechaKeyTyped(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Aparente");
        this.JTFFAIzquierda.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFAIzquierda.setHorizontalAlignment(4);
        this.JTFFAIzquierda.setText("0");
        this.JTFFAIzquierda.setFont(new Font("Arial", 1, 12));
        this.JTFFAIzquierda.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JTFFAIzquierdaActionPerformed(evt);
            }
        });
        this.JTFFAIzquierda.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Osteomuscular.8
            public void focusLost(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFAIzquierdaFocusLost(evt);
            }
        });
        this.JTFFADerecha.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFADerecha.setHorizontalAlignment(4);
        this.JTFFADerecha.setText("0");
        this.JTFFADerecha.setFont(new Font("Arial", 1, 12));
        this.JTFFADerecha.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JTFFADerechaActionPerformed(evt);
            }
        });
        this.JTFFADerecha.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Osteomuscular.10
            public void focusLost(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFADerechaFocusLost(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Izquierda");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Derecha");
        this.JCBCalReal.setFont(new Font("Arial", 1, 12));
        this.JCBCalReal.setModel(new DefaultComboBoxModel(new String[]{"NOTABLE DISMETRIA MMII", "LEVE DISMETRIA MMII", "SIMETRIA MMII"}));
        this.JCBCalReal.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF CUANTITATIVA REAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBCalAparente.setFont(new Font("Arial", 1, 12));
        this.JCBCalAparente.setModel(new DefaultComboBoxModel(new String[]{"NOTABLE DISMETRIA MMII", "LEVE DISMETRIA MMII", "SIMETRIA MMII"}));
        this.JCBCalAparente.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF CUANTITATIVA APARENTE", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBMMCortoR.setFont(new Font("Arial", 1, 12));
        this.JCBMMCortoR.setModel(new DefaultComboBoxModel(new String[]{"MIEMBRO INFERIOR DERECHO", "MIEMBRO INFERIOR IZQUIERDO", "NINGUNO"}));
        this.JCBMMCortoR.setBorder(BorderFactory.createTitledBorder((Border) null, "MIEMBRO MAS CORTO REAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBMMCortoA.setFont(new Font("Arial", 1, 12));
        this.JCBMMCortoA.setModel(new DefaultComboBoxModel(new String[]{"MIEMBRO INFERIOR DERECHO", "MIEMBRO INFERIOR IZQUIERDO", "NINGUNO"}));
        this.JCBMMCortoA.setBorder(BorderFactory.createTitledBorder((Border) null, "MIEMBRO MAS CORTO APARENTE", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBMMCortoFinal.setFont(new Font("Arial", 1, 12));
        this.JCBMMCortoFinal.setModel(new DefaultComboBoxModel(new String[]{"MIEMBRO INFERIOR DERECHO", "MIEMBRO INFERIOR IZQUIERDO", "NINGUNO"}));
        this.JCBMMCortoFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "MIEMBRO INFERIOR MAS CORTO FINAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCHAplica.setFont(new Font("Arial", 1, 12));
        this.JCHAplica.setText("No Aplica");
        this.JCHAplica.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JCHAplicaActionPerformed(evt);
            }
        });
        GroupLayout JPLingitudMMILayout = new GroupLayout(this.JPLingitudMMI);
        this.JPLingitudMMI.setLayout(JPLingitudMMILayout);
        JPLingitudMMILayout.setHorizontalGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLingitudMMILayout.createSequentialGroup().addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLingitudMMILayout.createSequentialGroup().addContainerGap().addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 35, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFAIzquierda).addComponent(this.JTFFRIzquierda, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFRDerecha, -2, 43, -2).addComponent(this.JTFFADerecha, GroupLayout.Alignment.TRAILING, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCalAparente, 0, -1, 32767).addComponent(this.JCBCalReal, 0, -1, 32767)).addGap(18, 18, 18).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBMMCortoR, 0, -1, 32767).addComponent(this.JCBMMCortoA, -2, 222, -2))).addGroup(JPLingitudMMILayout.createSequentialGroup().addGap(254, 254, 254).addComponent(this.JCBMMCortoFinal, -2, 242, -2))).addContainerGap(-1, 32767)).addGroup(JPLingitudMMILayout.createSequentialGroup().addGap(56, 56, 56).addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHAplica).addGap(57, 57, 57)));
        JPLingitudMMILayout.setVerticalGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLingitudMMILayout.createSequentialGroup().addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.JCHAplica)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLingitudMMILayout.createSequentialGroup().addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPLingitudMMILayout.createSequentialGroup().addComponent(this.jLabel1).addGap(35, 35, 35).addComponent(this.jLabel2)).addGroup(JPLingitudMMILayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2, -2).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFRIzquierda, -2, 32, -2).addComponent(this.JTFFRDerecha, -2, 32, -2)).addGap(18, 18, 18).addGroup(JPLingitudMMILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFAIzquierda, -2, 32, -2).addComponent(this.JTFFADerecha, -2, 32, -2))).addGroup(JPLingitudMMILayout.createSequentialGroup().addComponent(this.JCBCalReal, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCalAparente, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBMMCortoFinal, -2, 43, -2).addGap(6, 6, 6)).addGroup(JPLingitudMMILayout.createSequentialGroup().addComponent(this.JCBMMCortoR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMMCortoA, -2, -1, -2).addContainerGap(-1, 32767)))));
        this.JSPPAnteOMA.setBorder(BorderFactory.createTitledBorder((Border) null, "ANTECENDENTES NOMA", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPAnteOMA.setFont(new Font("Arial", 1, 12));
        this.JTAnteOMA.setFont(new Font("Arial", 1, 12));
        this.JTAnteOMA.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAnteOMA.setSelectionBackground(new Color(255, 255, 255));
        this.JTAnteOMA.setSelectionForeground(new Color(255, 0, 0));
        this.JTAnteOMA.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.12
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTAnteOMAMouseClicked(evt);
            }
        });
        this.JSPPAnteOMA.setViewportView(this.JTAnteOMA);
        this.JSPPDiagActivos.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICOS ACTIVOS PRESENTES", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPDiagActivos.setFont(new Font("Arial", 1, 12));
        this.JTDiagActivos.setFont(new Font("Arial", 1, 12));
        this.JTDiagActivos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDiagActivos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDiagActivos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDiagActivos.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.13
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTDiagActivosMouseClicked(evt);
            }
        });
        this.JSPPDiagActivos.setViewportView(this.JTDiagActivos);
        this.JPEvaDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DEL DOLOR", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JSPPEvaDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPEvaDolor.setFont(new Font("Arial", 1, 12));
        this.JSPPEvaDolor.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.14
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JSPPEvaDolorMouseClicked(evt);
            }
        });
        this.JTEvaDolor.setFont(new Font("Arial", 1, 12));
        this.JTEvaDolor.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTEvaDolor.setSelectionBackground(new Color(255, 255, 255));
        this.JTEvaDolor.setSelectionForeground(new Color(255, 0, 0));
        this.JTEvaDolor.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.15
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTEvaDolorMouseClicked(evt);
            }
        });
        this.JSPPEvaDolor.setViewportView(this.JTEvaDolor);
        this.JCBSegInteres.setFont(new Font("Arial", 1, 12));
        this.JCBSegInteres.setBorder(BorderFactory.createTitledBorder((Border) null, "SEGMENTO DE INTERÉS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBDolorOMa.add(this.JRBSI_OMA);
        this.JRBSI_OMA.setFont(new Font("Arial", 1, 11));
        this.JRBSI_OMA.setText("Sí");
        this.JRBSI_OMA.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBSI_OMAActionPerformed(evt);
            }
        });
        this.JBDolorOMa.add(this.JRBNO_OMA);
        this.JRBNO_OMA.setFont(new Font("Arial", 1, 11));
        this.JRBNO_OMA.setText("No");
        this.JRBNO_OMA.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBNO_OMAActionPerformed(evt);
            }
        });
        this.jLabel5.setFont(new Font("Arial", 1, 11));
        this.jLabel5.setForeground(new Color(0, 0, 255));
        this.jLabel5.setText("Presenta dolor a nivel OMA actualmente");
        this.JCBTipoDolor.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DOLOR", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBIntensidad.setFont(new Font("Arial", 1, 12));
        this.JCBIntensidad.setBorder(BorderFactory.createTitledBorder((Border) null, "INTENSIDAD", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGLateralidad.add(this.JRBDerecho);
        this.JRBDerecho.setFont(new Font("Arial", 1, 11));
        this.JRBDerecho.setText("Derecho");
        this.JRBDerecho.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBDerechoActionPerformed(evt);
            }
        });
        this.JBGLateralidad.add(this.JRBIzquierdo);
        this.JRBIzquierdo.setFont(new Font("Arial", 1, 11));
        this.JRBIzquierdo.setText("Izquierdo");
        this.JRBIzquierdo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBIzquierdoActionPerformed(evt);
            }
        });
        this.JBGLateralidad.add(this.JRBNoaplica);
        this.JRBNoaplica.setFont(new Font("Arial", 1, 11));
        this.JRBNoaplica.setSelected(true);
        this.JRBNoaplica.setText("No Aplica");
        this.JRBNoaplica.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBNoaplicaActionPerformed(evt);
            }
        });
        this.JTFFactoresExa.setColumns(1);
        this.JTFFactoresExa.setLineWrap(true);
        this.JTFFactoresExa.setRows(1);
        this.JTFFactoresExa.setBorder(BorderFactory.createTitledBorder((Border) null, "Factores que lo exacerban", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTFFactoresExa);
        this.JTFFactoresDism.setColumns(1);
        this.JTFFactoresDism.setLineWrap(true);
        this.JTFFactoresDism.setRows(1);
        this.JTFFactoresDism.setBorder(BorderFactory.createTitledBorder((Border) null, "Factores que lo disminuyen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane4.setViewportView(this.JTFFactoresDism);
        GroupLayout JPEvaDolorLayout = new GroupLayout(this.JPEvaDolor);
        this.JPEvaDolor.setLayout(JPEvaDolorLayout);
        JPEvaDolorLayout.setHorizontalGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaDolorLayout.createSequentialGroup().addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEvaDolorLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBNoaplica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDerecho).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBIzquierdo)).addGroup(JPEvaDolorLayout.createSequentialGroup().addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPEvaDolorLayout.createSequentialGroup().addComponent(this.JCBSegInteres, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTipoDolor, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(JPEvaDolorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel5).addGap(18, 18, 18).addComponent(this.JRBSI_OMA).addGap(10, 10, 10))).addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNO_OMA).addComponent(this.JCBIntensidad, -2, 94, -2)).addGap(0, 12, 32767)).addComponent(this.jScrollPane2).addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPEvaDolor, -2, 361, -2).addGap(18, 18, 18)));
        JPEvaDolorLayout.setVerticalGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaDolorLayout.createSequentialGroup().addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.JRBNO_OMA).addComponent(this.JRBSI_OMA)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSegInteres, -2, -1, -2).addComponent(this.JCBTipoDolor, -2, -1, -2).addComponent(this.JCBIntensidad, -2, -1, -2)).addGroup(JPEvaDolorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBIzquierdo).addComponent(this.JRBDerecho).addComponent(this.JRBNoaplica)).addGap(3, 3, 3).addComponent(this.jScrollPane2, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane4, -1, 47, 32767).addContainerGap()).addGroup(JPEvaDolorLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPPEvaDolor, -2, 0, 32767)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPLingitudMMI, -1, -1, 32767).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JPEvaDolor, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JSPPAnteOMA, -2, 411, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPDiagActivos, -2, 0, 32767))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPLingitudMMI, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPPAnteOMA, -1, 103, 32767).addComponent(this.JSPPDiagActivos, -2, 0, 32767)).addGap(3, 3, 3).addComponent(this.JPEvaDolor, -1, -1, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("PARTE 1", this.JPDatos);
        this.JPSigEspecial.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS ESPECIALES", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPSignosEspeciales.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPSignosEspeciales.setFont(new Font("Arial", 1, 12));
        this.JTSignosEsp.setFont(new Font("Arial", 1, 12));
        this.JTSignosEsp.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSignosEsp.setSelectionBackground(new Color(255, 255, 255));
        this.JTSignosEsp.setSelectionForeground(new Color(255, 0, 0));
        this.JTSignosEsp.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.21
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTSignosEspMouseClicked(evt);
            }
        });
        this.JSPPSignosEspeciales.setViewportView(this.JTSignosEsp);
        this.JCBHallazgosSigEsp.setFont(new Font("Arial", 1, 12));
        this.JCBHallazgosSigEsp.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        GroupLayout JPSigEspecialLayout = new GroupLayout(this.JPSigEspecial);
        this.JPSigEspecial.setLayout(JPSigEspecialLayout);
        JPSigEspecialLayout.setHorizontalGroup(JPSigEspecialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSigEspecialLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBHallazgosSigEsp, -2, 224, -2).addGap(165, 165, 165)).addGroup(JPSigEspecialLayout.createSequentialGroup().addComponent(this.JSPPSignosEspeciales, -2, 389, -2).addGap(0, 0, 32767)));
        JPSigEspecialLayout.setVerticalGroup(JPSigEspecialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPSigEspecialLayout.createSequentialGroup().addComponent(this.JCBHallazgosSigEsp, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPSignosEspeciales, -1, 143, 32767)));
        this.JPMovArticular.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVILIDAD ARTICULAR", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPMovArticular.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPMovArticular.setFont(new Font("Arial", 1, 12));
        this.JTMovArticular.setFont(new Font("Arial", 1, 12));
        this.JTMovArticular.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMovArticular.setSelectionBackground(new Color(255, 255, 255));
        this.JTMovArticular.setSelectionForeground(new Color(255, 0, 0));
        this.JTMovArticular.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.22
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTMovArticularMouseClicked(evt);
            }
        });
        this.JSPPMovArticular.setViewportView(this.JTMovArticular);
        this.JCBHallazgosMovArt.setFont(new Font("Arial", 1, 12));
        this.JCBHallazgosMovArt.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        GroupLayout JPMovArticularLayout = new GroupLayout(this.JPMovArticular);
        this.JPMovArticular.setLayout(JPMovArticularLayout);
        JPMovArticularLayout.setHorizontalGroup(JPMovArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovArticularLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBHallazgosMovArt, -2, 224, -2).addGap(165, 165, 165)).addGroup(JPMovArticularLayout.createSequentialGroup().addComponent(this.JSPPMovArticular, -2, 389, -2).addGap(0, 0, 32767)));
        JPMovArticularLayout.setVerticalGroup(JPMovArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMovArticularLayout.createSequentialGroup().addComponent(this.JCBHallazgosMovArt, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPMovArticular, -1, 143, 32767)));
        this.JPFuerzaMuscular.setBorder(BorderFactory.createTitledBorder((Border) null, "FUERZA MUSCULAR", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPFuerzaMuscular.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPFuerzaMuscular.setFont(new Font("Arial", 1, 12));
        this.JTFuerzaMuscular.setFont(new Font("Arial", 1, 12));
        this.JTFuerzaMuscular.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTFuerzaMuscular.setSelectionBackground(new Color(255, 255, 255));
        this.JTFuerzaMuscular.setSelectionForeground(new Color(255, 0, 0));
        this.JTFuerzaMuscular.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.23
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTFuerzaMuscularMouseClicked(evt);
            }
        });
        this.JSPPFuerzaMuscular.setViewportView(this.JTFuerzaMuscular);
        this.JCBFuerzaMuscular.setFont(new Font("Arial", 1, 12));
        this.JCBFuerzaMuscular.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        GroupLayout JPFuerzaMuscularLayout = new GroupLayout(this.JPFuerzaMuscular);
        this.JPFuerzaMuscular.setLayout(JPFuerzaMuscularLayout);
        JPFuerzaMuscularLayout.setHorizontalGroup(JPFuerzaMuscularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFuerzaMuscularLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBFuerzaMuscular, -2, 224, -2).addGap(165, 165, 165)).addGroup(JPFuerzaMuscularLayout.createSequentialGroup().addComponent(this.JSPPFuerzaMuscular, -2, 389, -2).addGap(0, 0, 32767)));
        JPFuerzaMuscularLayout.setVerticalGroup(JPFuerzaMuscularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFuerzaMuscularLayout.createSequentialGroup().addComponent(this.JCBFuerzaMuscular, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPFuerzaMuscular, -1, 143, 32767)));
        this.JPDatosAntrop.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ANTROPOMÉTRICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla(cm)", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JTFFSTalla.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Osteomuscular.24
            public void stateChanged(ChangeEvent evt) {
                JPSo_Osteomuscular.this.JTFFSTallaStateChanged(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Osteomuscular.25
            public void keyPressed(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFSTallaKeyPressed(evt);
            }
        });
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso(Kg)", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JTFFSPeso.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Osteomuscular.26
            public void stateChanged(ChangeEvent evt) {
                JPSo_Osteomuscular.this.JTFFSPesoStateChanged(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Osteomuscular.27
            public void focusLost(FocusEvent evt) {
                JPSo_Osteomuscular.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Osteomuscular.28
            public void keyPressed(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTFFSPesoKeyPressed(evt);
            }
        });
        this.JTFFSIMC.setFont(new Font("Arial", 1, 12));
        this.JTFFSIMC.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 2, 0, new Font("Arial", 1, 11), Color.blue));
        GroupLayout JPDatosAntropLayout = new GroupLayout(this.JPDatosAntrop);
        this.JPDatosAntrop.setLayout(JPDatosAntropLayout);
        JPDatosAntropLayout.setHorizontalGroup(JPDatosAntropLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAntropLayout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.JTFFSTalla).addGap(6, 6, 6).addComponent(this.JTFFSPeso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC, -2, 101, -2).addGap(34, 34, 34)));
        JPDatosAntropLayout.setVerticalGroup(JPDatosAntropLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAntropLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAntropLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2).addComponent(this.JTFFSIMC, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPParte2Layout = new GroupLayout(this.JPParte2);
        this.JPParte2.setLayout(JPParte2Layout);
        JPParte2Layout.setHorizontalGroup(JPParte2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte2Layout.createSequentialGroup().addContainerGap().addGroup(JPParte2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte2Layout.createSequentialGroup().addComponent(this.JPSigEspecial, -2, 401, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPMovArticular, -2, 401, -2)).addGroup(JPParte2Layout.createSequentialGroup().addComponent(this.JPFuerzaMuscular, -2, 401, -2).addGap(18, 18, 18).addComponent(this.JPDatosAntrop, -1, -1, 32767))).addContainerGap()));
        JPParte2Layout.setVerticalGroup(JPParte2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte2Layout.createSequentialGroup().addContainerGap().addGroup(JPParte2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPMovArticular, -2, -1, -2).addComponent(this.JPSigEspecial, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPParte2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPFuerzaMuscular, -1, -1, 32767).addComponent(this.JPDatosAntrop, -1, -1, 32767)).addContainerGap(110, 32767)));
        this.jTabbedPane1.addTab("PARTE 2", this.JPParte2);
        this.JPVistaAnt.setLayout((LayoutManager) null);
        this.JRBCabAlineada.setBackground(new Color(255, 255, 255));
        this.JBGCabeza.add(this.JRBCabAlineada);
        this.JRBCabAlineada.setSelected(true);
        this.JRBCabAlineada.setName("10");
        this.JRBCabAlineada.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCabAlineadaActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBCabAlineada);
        this.JRBCabAlineada.setBounds(30, 30, 20, 25);
        this.JRBCabIncliLeve.setBackground(new Color(255, 255, 255));
        this.JBGCabeza.add(this.JRBCabIncliLeve);
        this.JRBCabIncliLeve.setName("5");
        this.JRBCabIncliLeve.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCabIncliLeveActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBCabIncliLeve);
        this.JRBCabIncliLeve.setBounds(160, 30, 20, 25);
        this.JRBCabIncliRotada.setBackground(new Color(255, 255, 255));
        this.JBGCabeza.add(this.JRBCabIncliRotada);
        this.JRBCabIncliRotada.setName("0");
        this.JRBCabIncliRotada.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCabIncliRotadaActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBCabIncliRotada);
        this.JRBCabIncliRotada.setBounds(300, 30, 20, 25);
        this.JRBHomAlineados.setBackground(new Color(255, 255, 255));
        this.JBGHombros.add(this.JRBHomAlineados);
        this.JRBHomAlineados.setSelected(true);
        this.JRBHomAlineados.setName("10");
        this.JRBHomAlineados.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBHomAlineadosActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBHomAlineados);
        this.JRBHomAlineados.setBounds(30, 100, 20, 25);
        this.JRBHomLevDescendido.setBackground(new Color(255, 255, 255));
        this.JBGHombros.add(this.JRBHomLevDescendido);
        this.JRBHomLevDescendido.setName("5");
        this.JRBHomLevDescendido.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBHomLevDescendidoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBHomLevDescendido);
        this.JRBHomLevDescendido.setBounds(160, 100, 20, 25);
        this.JRBHomMarDescenso.setBackground(new Color(255, 255, 255));
        this.JBGHombros.add(this.JRBHomMarDescenso);
        this.JRBHomMarDescenso.setName("0");
        this.JRBHomMarDescenso.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBHomMarDescensoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBHomMarDescenso);
        this.JRBHomMarDescenso.setBounds(300, 100, 20, 25);
        this.JRBColAlineada.setBackground(new Color(255, 255, 255));
        this.JBGColumna.add(this.JRBColAlineada);
        this.JRBColAlineada.setSelected(true);
        this.JRBColAlineada.setName("10");
        this.JRBColAlineada.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBColAlineadaActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBColAlineada);
        this.JRBColAlineada.setBounds(10, 170, 20, 25);
        this.JRBColEscoliosis.setBackground(new Color(255, 255, 255));
        this.JBGColumna.add(this.JRBColEscoliosis);
        this.JRBColEscoliosis.setName("5");
        this.JRBColEscoliosis.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBColEscoliosisActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBColEscoliosis);
        this.JRBColEscoliosis.setBounds(150, 170, 20, 25);
        this.JRBColCurvaLateral.setBackground(new Color(255, 255, 255));
        this.JBGColumna.add(this.JRBColCurvaLateral);
        this.JRBColCurvaLateral.setName("0");
        this.JRBColCurvaLateral.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBColCurvaLateralActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBColCurvaLateral);
        this.JRBColCurvaLateral.setBounds(290, 170, 20, 25);
        this.JRBPelvIliacas.setBackground(new Color(255, 255, 255));
        this.JBGPelvis.add(this.JRBPelvIliacas);
        this.JRBPelvIliacas.setSelected(true);
        this.JRBPelvIliacas.setName("10");
        this.JRBPelvIliacas.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPelvIliacasActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPelvIliacas);
        this.JRBPelvIliacas.setBounds(10, 270, 20, 25);
        this.JRBPelvHemipelvis.setBackground(new Color(255, 255, 255));
        this.JBGPelvis.add(this.JRBPelvHemipelvis);
        this.JRBPelvHemipelvis.setName("5");
        this.JRBPelvHemipelvis.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPelvHemipelvisActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPelvHemipelvis);
        this.JRBPelvHemipelvis.setBounds(140, 270, 20, 25);
        this.JRBPelvMarcado.setBackground(new Color(255, 255, 255));
        this.JBGPelvis.add(this.JRBPelvMarcado);
        this.JRBPelvMarcado.setName("0");
        this.JRBPelvMarcado.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPelvMarcadoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPelvMarcado);
        this.JRBPelvMarcado.setBounds(290, 270, 20, 25);
        this.JRBRodAlineadas.setBackground(new Color(255, 255, 255));
        this.JBGRodillas.add(this.JRBRodAlineadas);
        this.JRBRodAlineadas.setSelected(true);
        this.JRBRodAlineadas.setName("10");
        this.JRBRodAlineadas.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBRodAlineadasActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBRodAlineadas);
        this.JRBRodAlineadas.setBounds(20, 340, 20, 25);
        this.JRBRodValgo.setBackground(new Color(255, 255, 255));
        this.JBGRodillas.add(this.JRBRodValgo);
        this.JRBRodValgo.setName("5");
        this.JRBRodValgo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBRodValgoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBRodValgo);
        this.JRBRodValgo.setBounds(150, 340, 20, 25);
        this.JRBRodVaro.setBackground(new Color(255, 255, 255));
        this.JBGRodillas.add(this.JRBRodVaro);
        this.JRBRodVaro.setName("0");
        this.JRBRodVaro.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBRodVaroActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBRodVaro);
        this.JRBRodVaro.setBounds(300, 340, 20, 25);
        this.JRBPieAlineado.setBackground(new Color(255, 255, 255));
        this.JBGPies.add(this.JRBPieAlineado);
        this.JRBPieAlineado.setSelected(true);
        this.JRBPieAlineado.setName("10");
        this.JRBPieAlineado.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPieAlineadoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPieAlineado);
        this.JRBPieAlineado.setBounds(20, 410, 20, 25);
        this.JRBPiePlano.setBackground(new Color(255, 255, 255));
        this.JBGPies.add(this.JRBPiePlano);
        this.JRBPiePlano.setName("5");
        this.JRBPiePlano.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPiePlanoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPiePlano);
        this.JRBPiePlano.setBounds(150, 410, 20, 25);
        this.JRBPieCavo.setBackground(new Color(255, 255, 255));
        this.JBGPies.add(this.JRBPieCavo);
        this.JRBPieCavo.setName("0");
        this.JRBPieCavo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBPieCavoActionPerformed(evt);
            }
        });
        this.JPVistaAnt.add(this.JRBPieCavo);
        this.JRBPieCavo.setBounds(300, 410, 20, 25);
        this.JLVistaAnt.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Vista_Aterior.png")));
        this.JLVistaAnt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "VISTA ANTERO POSTERIOR", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255))));
        this.JPVistaAnt.add(this.JLVistaAnt);
        this.JLVistaAnt.setBounds(0, 0, 420, 470);
        this.JPVistaLateral.setLayout((LayoutManager) null);
        this.JRBCuelloAlineado.setBackground(new Color(255, 255, 255));
        this.JBGCuello.add(this.JRBCuelloAlineado);
        this.JRBCuelloAlineado.setSelected(true);
        this.JRBCuelloAlineado.setName("10");
        this.JRBCuelloAlineado.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCuelloAlineadoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBCuelloAlineado);
        this.JRBCuelloAlineado.setBounds(30, 30, 20, 25);
        this.JRBCuelloLevAumento.setBackground(new Color(255, 255, 255));
        this.JBGCuello.add(this.JRBCuelloLevAumento);
        this.JRBCuelloLevAumento.setName("5");
        this.JRBCuelloLevAumento.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCuelloLevAumentoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBCuelloLevAumento);
        this.JRBCuelloLevAumento.setBounds(160, 30, 20, 25);
        this.JRBCuelloRecti.setBackground(new Color(255, 255, 255));
        this.JBGCuello.add(this.JRBCuelloRecti);
        this.JRBCuelloRecti.setName("0");
        this.JRBCuelloRecti.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBCuelloRectiActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBCuelloRecti);
        this.JRBCuelloRecti.setBounds(300, 30, 20, 25);
        this.JRBDorsoNormal.setBackground(new Color(255, 255, 255));
        this.JBGDorso.add(this.JRBDorsoNormal);
        this.JRBDorsoNormal.setSelected(true);
        this.JRBDorsoNormal.setName("10");
        this.JRBDorsoNormal.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBDorsoNormalActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBDorsoNormal);
        this.JRBDorsoNormal.setBounds(30, 130, 20, 25);
        this.JRBDorsoAumento.setBackground(new Color(255, 255, 255));
        this.JBGDorso.add(this.JRBDorsoAumento);
        this.JRBDorsoAumento.setName("5");
        this.JRBDorsoAumento.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBDorsoAumentoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBDorsoAumento);
        this.JRBDorsoAumento.setBounds(160, 130, 20, 25);
        this.JRBDorsoProtuidos.setBackground(new Color(255, 255, 255));
        this.JBGDorso.add(this.JRBDorsoProtuidos);
        this.JRBDorsoProtuidos.setName("0");
        this.JRBDorsoProtuidos.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBDorsoProtuidosActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBDorsoProtuidos);
        this.JRBDorsoProtuidos.setBounds(300, 130, 20, 25);
        this.JRBTroncoAlineado.setBackground(new Color(255, 255, 255));
        this.JBGTronco.add(this.JRBTroncoAlineado);
        this.JRBTroncoAlineado.setSelected(true);
        this.JRBTroncoAlineado.setName("10");
        this.JRBTroncoAlineado.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBTroncoAlineadoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBTroncoAlineado);
        this.JRBTroncoAlineado.setBounds(20, 210, 20, 25);
        this.JRBTroncoLeve.setBackground(new Color(255, 255, 255));
        this.JBGTronco.add(this.JRBTroncoLeve);
        this.JRBTroncoLeve.setName("5");
        this.JRBTroncoLeve.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBTroncoLeveActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBTroncoLeve);
        this.JRBTroncoLeve.setBounds(160, 210, 20, 25);
        this.JRBTroncoInclinacion.setBackground(new Color(255, 255, 255));
        this.JBGTronco.add(this.JRBTroncoInclinacion);
        this.JRBTroncoInclinacion.setName("0");
        this.JRBTroncoInclinacion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBTroncoInclinacionActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBTroncoInclinacion);
        this.JRBTroncoInclinacion.setBounds(300, 210, 20, 25);
        this.JRBAbdomenNormal.setBackground(new Color(255, 255, 255));
        this.JBGAbdomen.add(this.JRBAbdomenNormal);
        this.JRBAbdomenNormal.setSelected(true);
        this.JRBAbdomenNormal.setName("10");
        this.JRBAbdomenNormal.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBAbdomenNormalActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBAbdomenNormal);
        this.JRBAbdomenNormal.setBounds(20, 300, 20, 25);
        this.JRBAbdomenProtuido.setBackground(new Color(255, 255, 255));
        this.JBGAbdomen.add(this.JRBAbdomenProtuido);
        this.JRBAbdomenProtuido.setName("5");
        this.JRBAbdomenProtuido.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBAbdomenProtuidoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBAbdomenProtuido);
        this.JRBAbdomenProtuido.setBounds(160, 300, 20, 25);
        this.JRBAbdomenDesc.setBackground(new Color(255, 255, 255));
        this.JBGAbdomen.add(this.JRBAbdomenDesc);
        this.JRBAbdomenDesc.setName("0");
        this.JRBAbdomenDesc.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBAbdomenDescActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBAbdomenDesc);
        this.JRBAbdomenDesc.setBounds(300, 300, 20, 25);
        this.JRBLumbarNormal.setBackground(new Color(255, 255, 255));
        this.JBGLumbar.add(this.JRBLumbarNormal);
        this.JRBLumbarNormal.setSelected(true);
        this.JRBLumbarNormal.setName("10");
        this.JRBLumbarNormal.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBLumbarNormalActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBLumbarNormal);
        this.JRBLumbarNormal.setBounds(20, 400, 20, 25);
        this.JRBLumbarAumento.setBackground(new Color(255, 255, 255));
        this.JBGLumbar.add(this.JRBLumbarAumento);
        this.JRBLumbarAumento.setName("5");
        this.JRBLumbarAumento.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBLumbarAumentoActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBLumbarAumento);
        this.JRBLumbarAumento.setBounds(160, 400, 20, 25);
        this.JRBLumbarHiper.setBackground(new Color(255, 255, 255));
        this.JBGLumbar.add(this.JRBLumbarHiper);
        this.JRBLumbarHiper.setName("0");
        this.JRBLumbarHiper.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JRBLumbarHiperActionPerformed(evt);
            }
        });
        this.JPVistaLateral.add(this.JRBLumbarHiper);
        this.JRBLumbarHiper.setBounds(300, 400, 20, 25);
        this.JLVistaLateral.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Vista_Lateral.png")));
        this.JLVistaLateral.setBorder(BorderFactory.createTitledBorder((Border) null, "VISTA LATERAL", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPVistaLateral.add(this.JLVistaLateral);
        this.JLVistaLateral.setBounds(0, 0, 410, 470);
        this.JTFFColumna1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna1.setHorizontalAlignment(4);
        this.JTFFColumna1.setText("0");
        this.JTFFColumna1.setFont(new Font("Arial", 1, 12));
        this.JTFFColumna2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna2.setHorizontalAlignment(4);
        this.JTFFColumna2.setText("0");
        this.JTFFColumna2.setFont(new Font("Arial", 1, 12));
        this.JTFFColumna3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna3.setHorizontalAlignment(4);
        this.JTFFColumna3.setText("0");
        this.JTFFColumna3.setFont(new Font("Arial", 1, 12));
        this.JTFFColumna4.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna4.setHorizontalAlignment(4);
        this.JTFFColumna4.setText("0");
        this.JTFFColumna4.setFont(new Font("Arial", 1, 12));
        this.JTFFColumna5.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna5.setHorizontalAlignment(4);
        this.JTFFColumna5.setText("0");
        this.JTFFColumna5.setFont(new Font("Arial", 1, 12));
        this.JTFFColumna6.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFColumna6.setHorizontalAlignment(4);
        this.JTFFColumna6.setText("0");
        this.JTFFColumna6.setFont(new Font("Arial", 1, 12));
        this.JTFFSumatoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Sumatoria de hallazgos", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JTFFSumatoria.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFSumatoria.setHorizontalAlignment(4);
        this.JTFFSumatoria.setText("0");
        this.JTFFSumatoria.setFont(new Font("Arial", 1, 12));
        this.JLCalificacion.setFont(new Font("Arial", 1, 12));
        this.JLCalificacion.setForeground(new Color(255, 0, 0));
        this.JLCalificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Calificación de alineación de riesgo postural", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JTFDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        GroupLayout JPParte3Layout = new GroupLayout(this.JPParte3);
        this.JPParte3.setLayout(JPParte3Layout);
        JPParte3Layout.setHorizontalGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte3Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPVistaAnt, -2, 419, -2).addGap(3, 3, 3).addComponent(this.JPVistaLateral, -2, 413, -2).addContainerGap(-1, 32767)).addGroup(JPParte3Layout.createSequentialGroup().addGap(49, 49, 49).addGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPParte3Layout.createSequentialGroup().addComponent(this.JTFFColumna1, -2, 57, -2).addGap(74, 74, 74).addComponent(this.JTFFColumna2, -2, 57, -2).addGap(81, 81, 81).addComponent(this.JTFFColumna3, -2, 57, -2).addGap(105, 105, 105).addComponent(this.JTFFColumna4, -2, 57, -2).addGap(87, 87, 87).addComponent(this.JTFFColumna5, -2, 57, -2).addGap(79, 79, 79).addComponent(this.JTFFColumna6, -2, 57, -2)).addGroup(JPParte3Layout.createSequentialGroup().addComponent(this.JTFFSumatoria, -2, 153, -2).addGap(34, 34, 34).addComponent(this.JLCalificacion, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFDescripcion))).addGap(0, 0, 32767)));
        JPParte3Layout.setVerticalGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte3Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPVistaAnt, -2, 465, -2).addComponent(this.JPVistaLateral, -2, 475, -2)).addGap(3, 3, 3).addGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFColumna1, -2, 32, -2).addComponent(this.JTFFColumna2, -2, 32, -2).addComponent(this.JTFFColumna3, -2, 32, -2)).addComponent(this.JTFFColumna4, -2, 32, -2).addComponent(this.JTFFColumna5, -2, 32, -2).addComponent(this.JTFFColumna6, -2, 32, -2)).addGap(3, 3, 3).addGroup(JPParte3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFSumatoria).addComponent(this.JLCalificacion, -1, -1, 32767).addComponent(this.JTFDescripcion)).addGap(3, 3, 3)));
        this.jTabbedPane1.addTab("PARTE 3", this.JPParte3);
        this.JPEvaCuaFisicas.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DE CUALIDADES FISICAS", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("Prueba");
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Flexibilidad SIT & REACH");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("Fuerza Abdominal");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("Fuerza de brazos");
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("Valor");
        this.JTFFVFlexibilidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFVFlexibilidad.setHorizontalAlignment(4);
        this.JTFFVFlexibilidad.setText("0");
        this.JTFFVFlexibilidad.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("Percentil");
        this.JTFFPFlexibilidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFPFlexibilidad.setHorizontalAlignment(4);
        this.JTFFPFlexibilidad.setText("0");
        this.JTFFPFlexibilidad.setFont(new Font("Arial", 1, 12));
        this.JTFFVFuAbdominal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFVFuAbdominal.setHorizontalAlignment(4);
        this.JTFFVFuAbdominal.setText("0");
        this.JTFFVFuAbdominal.setFont(new Font("Arial", 1, 12));
        this.JTFFPFuAbdominal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFPFuAbdominal.setHorizontalAlignment(4);
        this.JTFFPFuAbdominal.setText("0");
        this.JTFFPFuAbdominal.setFont(new Font("Arial", 1, 12));
        this.JTFFVFuBrazos.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFVFuBrazos.setHorizontalAlignment(4);
        this.JTFFVFuBrazos.setText("0");
        this.JTFFVFuBrazos.setFont(new Font("Arial", 1, 12));
        this.JTFFPFuBrazos.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFPFuBrazos.setHorizontalAlignment(4);
        this.JTFFPFuBrazos.setText("0");
        this.JTFFPFuBrazos.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("Catgoría");
        this.JLCatFlexibilidad.setFont(new Font("Arial", 1, 12));
        this.JLCatFlexibilidad.setForeground(new Color(255, 0, 0));
        this.JLCatFlexibilidad.setBorder(BorderFactory.createTitledBorder(""));
        this.JLCatFueAbdominal.setFont(new Font("Arial", 1, 12));
        this.JLCatFueAbdominal.setForeground(new Color(255, 0, 0));
        this.JLCatFueAbdominal.setBorder(BorderFactory.createTitledBorder(""));
        this.JLCatFueBrazos.setFont(new Font("Arial", 1, 12));
        this.JLCatFueBrazos.setForeground(new Color(255, 0, 0));
        this.JLCatFueBrazos.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout JPEvaCuaFisicasLayout = new GroupLayout(this.JPEvaCuaFisicas);
        this.JPEvaCuaFisicas.setLayout(JPEvaCuaFisicasLayout);
        JPEvaCuaFisicasLayout.setHorizontalGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.jLabel7, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFVFlexibilidad, -2, 57, -2)).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.jLabel6, -2, 50, -2).addGap(142, 142, 142).addComponent(this.jLabel10, -2, 50, -2))).addGap(18, 18, 18).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, -2, 72, -2).addComponent(this.JTFFPFlexibilidad, -2, 57, -2))).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.jLabel9, -2, 153, -2).addGap(32, 32, 32)).addGroup(GroupLayout.Alignment.LEADING, JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.jLabel8, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.JTFFVFuBrazos, -2, 57, -2).addGap(18, 18, 18).addComponent(this.JTFFPFuBrazos, -2, 57, -2)).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addComponent(this.JTFFVFuAbdominal, -2, 57, -2).addGap(18, 18, 18).addComponent(this.JTFFPFuAbdominal, -2, 57, -2))))).addGap(18, 18, 18).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12, -2, 240, -2).addComponent(this.JLCatFlexibilidad, -2, 333, -2).addComponent(this.JLCatFueAbdominal, -2, 333, -2).addComponent(this.JLCatFueBrazos, -2, 333, -2)).addGap(0, 135, 32767)));
        JPEvaCuaFisicasLayout.setVerticalGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaCuaFisicasLayout.createSequentialGroup().addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jLabel10).addComponent(this.jLabel11).addComponent(this.jLabel12)).addGap(6, 6, 6).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFVFlexibilidad, -1, 32, 32767).addComponent(this.JTFFPFlexibilidad, -1, 32, 32767).addComponent(this.jLabel7).addComponent(this.JLCatFlexibilidad, -1, -1, 32767)).addGap(3, 3, 3).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFVFuAbdominal, -1, 32, 32767).addComponent(this.JTFFPFuAbdominal, -1, 32, 32767).addComponent(this.jLabel8).addComponent(this.JLCatFueAbdominal, -1, -1, 32767)).addGap(3, 3, 3).addGroup(JPEvaCuaFisicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel9).addComponent(this.JTFFVFuBrazos, -1, 32, 32767).addComponent(this.JTFFPFuBrazos, -1, 32, 32767).addComponent(this.JLCatFueBrazos, -1, -1, 32767)).addGap(3, 3, 3)));
        this.JPHallazgoOMA.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGO NOMA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAHallazgo.setColumns(1);
        this.JTAHallazgo.setLineWrap(true);
        this.JTAHallazgo.setRows(1);
        this.jScrollPane1.setViewportView(this.JTAHallazgo);
        this.JCBHallazgosOMA.setFont(new Font("Arial", 1, 12));
        this.JCBHallazgosOMA.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCHBPotencial.setFont(new Font("Arial", 1, 12));
        this.JCHBPotencial.setText("Con potencial");
        this.JCHBPotencial.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JCHBPotencialActionPerformed(evt);
            }
        });
        GroupLayout JPHallazgoOMALayout = new GroupLayout(this.JPHallazgoOMA);
        this.JPHallazgoOMA.setLayout(JPHallazgoOMALayout);
        JPHallazgoOMALayout.setHorizontalGroup(JPHallazgoOMALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHallazgoOMALayout.createSequentialGroup().addContainerGap().addGroup(JPHallazgoOMALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(JPHallazgoOMALayout.createSequentialGroup().addComponent(this.JCBHallazgosOMA, -2, 224, -2).addGap(18, 18, 18).addComponent(this.JCHBPotencial).addGap(0, 0, 32767)))));
        JPHallazgoOMALayout.setVerticalGroup(JPHallazgoOMALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHallazgoOMALayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 53, -2).addGroup(JPHallazgoOMALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHallazgoOMALayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JCBHallazgosOMA, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPHallazgoOMALayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBPotencial).addContainerGap()))));
        this.JSPRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "RECOMENDACIONES PARA MEJORAR LA CONDICIÓN NOMA", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPRecomendaciones.setFont(new Font("Arial", 1, 12));
        this.JTRecomendaciones.setFont(new Font("Arial", 1, 12));
        this.JTRecomendaciones.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRecomendaciones.setSelectionBackground(new Color(255, 255, 255));
        this.JTRecomendaciones.setSelectionForeground(new Color(255, 0, 0));
        this.JSPRecomendaciones.setViewportView(this.JTRecomendaciones);
        this.JBGrabarExamen.setFont(new Font("Arial", 1, 12));
        this.JBGrabarExamen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarExamen.setText("Grabar Examen");
        this.JBGrabarExamen.setActionCommand("Actualizar Examen");
        this.JBGrabarExamen.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JBGrabarExamenActionPerformed(evt);
            }
        });
        this.JPNivelSeveridad.setBorder(BorderFactory.createTitledBorder((Border) null, "NIVEL DE SEVERIDAD NOMA INDIVIDUAL", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JPNivelSeveridad.setFont(new Font("Arial", 1, 12));
        this.JTNivelSeveridad.setFont(new Font("Arial", 1, 12));
        this.JTNivelSeveridad.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTNivelSeveridad.setSelectionBackground(new Color(255, 255, 255));
        this.JTNivelSeveridad.setSelectionForeground(new Color(255, 0, 0));
        this.JPNivelSeveridad.setViewportView(this.JTNivelSeveridad);
        this.JCBCalSeveridad.setFont(new Font("Arial", 1, 12));
        this.JCBCalSeveridad.setModel(new DefaultComboBoxModel(new String[]{"BAJO", "MEDIO", "ALTO", "CRITICO"}));
        this.JCBCalSeveridad.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBActualizarExamen.setFont(new Font("Arial", 1, 12));
        this.JBActualizarExamen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBActualizarExamen.setText("Actualizar Examen");
        this.JBActualizarExamen.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JBActualizarExamenActionPerformed(evt);
            }
        });
        GroupLayout JPParte4Layout = new GroupLayout(this.JPParte4);
        this.JPParte4.setLayout(JPParte4Layout);
        JPParte4Layout.setHorizontalGroup(JPParte4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte4Layout.createSequentialGroup().addContainerGap().addGroup(JPParte4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPHallazgoOMA, -1, -1, 32767).addComponent(this.JPEvaCuaFisicas, -1, -1, 32767).addComponent(this.JSPRecomendaciones).addGroup(JPParte4Layout.createSequentialGroup().addComponent(this.JPNivelSeveridad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCalSeveridad, -2, 136, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPParte4Layout.createSequentialGroup().addComponent(this.JBGrabarExamen, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JBActualizarExamen, -2, 404, -2))).addContainerGap()));
        JPParte4Layout.setVerticalGroup(JPParte4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte4Layout.createSequentialGroup().addContainerGap().addComponent(this.JPEvaCuaFisicas, -2, -1, -2).addGroup(JPParte4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParte4Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPNivelSeveridad, -2, 115, -2)).addGroup(JPParte4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCalSeveridad, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPHallazgoOMA, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JSPRecomendaciones, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPParte4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabarExamen, -1, -1, 32767).addComponent(this.JBActualizarExamen, -1, -1, 32767)).addContainerGap()));
        this.jTabbedPane1.addTab("PARTE 4", this.JPParte4);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Osteomuscular.65
            public void mouseClicked(MouseEvent evt) {
                JPSo_Osteomuscular.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JTDetalleHistorico.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Osteomuscular.66
            public void keyPressed(KeyEvent evt) {
                JPSo_Osteomuscular.this.JTDetalleHistoricoKeyPressed(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 828, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(263, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.JPHistorico);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Osteomuscular.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_Osteomuscular.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN MÉDICA", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTAInterpretacion.setColumns(1);
        this.JTAInterpretacion.setLineWrap(true);
        this.JTAInterpretacion.setRows(1);
        this.JTAInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAInterpretacion);
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBResultado, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3).addContainerGap()));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBResultado, -2, -1, -2).addComponent(this.jScrollPane3, -2, -1, -2));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 840, -2).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPInterpretacion, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardar).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 592, -2).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGuardar, -2, 64, -2).addComponent(this.JPInterpretacion, -2, -1, -2)).addContainerGap(20, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRIzquierdaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRDerechaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRIzquierdaActionPerformed(ActionEvent evt) {
        this.JTFFRIzquierda.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRDerechaActionPerformed(ActionEvent evt) {
        this.JTFFRDerecha.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRIzquierdaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRDerechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRIzquierdaFocusLost(FocusEvent evt) {
        mLongitudMMICombo1(Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue(), 0L);
        mLongitudMMICombo2(Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRDerechaFocusLost(FocusEvent evt) {
        mLongitudMMICombo1(Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue(), 0L);
        mLongitudMMICombo2(Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFAIzquierdaActionPerformed(ActionEvent evt) {
        this.JTFFAIzquierda.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFAIzquierdaFocusLost(FocusEvent evt) {
        mLongitudMMICombo1(Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue(), 1L);
        mLongitudMMICombo2(Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue(), 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFADerechaFocusLost(FocusEvent evt) {
        mLongitudMMICombo1(Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue(), 1L);
        mLongitudMMICombo2(Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue(), Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue(), 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFADerechaActionPerformed(ActionEvent evt) {
        this.JTFFADerecha.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDiagActivosMouseClicked(MouseEvent evt) {
        if (this.JTDiagActivos.getSelectedRow() != -1 && this.JTDiagActivos.getSelectedColumn() == 4) {
            JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) "", "diagnostico_activos");
            pac.setVisible(true);
            pac.setLocationRelativeTo(this);
        }
        if (this.JTDiagActivos.getSelectedRow() != -1 && this.JTDiagActivos.getSelectedColumn() == 2) {
            if (this.xmodeloDiagActivo.getValueAt(this.JTDiagActivos.getSelectedRow(), 2).equals(true)) {
                mCalcularSegmentos(this.xmodeloDiagActivo.getValueAt(this.JTDiagActivos.getSelectedRow(), 1).toString(), Double.parseDouble(this.xmodeloDiagActivo.getValueAt(this.JTDiagActivos.getSelectedRow(), 5).toString()));
            } else {
                mCalcularSegmentos(this.xmodeloDiagActivo.getValueAt(this.JTDiagActivos.getSelectedRow(), 1).toString(), -Double.parseDouble(this.xmodeloDiagActivo.getValueAt(this.JTDiagActivos.getSelectedRow(), 5).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPEvaDolorMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTEvaDolorMouseClicked(MouseEvent evt) {
        if (this.JTEvaDolor.getSelectedRow() != -1 && this.JTEvaDolor.getSelectedColumn() == 2) {
            if (this.xmodeloEvaDolor.getValueAt(this.JTEvaDolor.getSelectedRow(), 2).equals(true)) {
                mCalcularSegmentos(this.xmodeloEvaDolor.getValueAt(this.JTEvaDolor.getSelectedRow(), 1).toString(), Double.parseDouble(this.xmodeloEvaDolor.getValueAt(this.JTEvaDolor.getSelectedRow(), 5).toString()));
            } else {
                mCalcularSegmentos(this.xmodeloEvaDolor.getValueAt(this.JTEvaDolor.getSelectedRow(), 1).toString(), -Double.parseDouble(this.xmodeloEvaDolor.getValueAt(this.JTEvaDolor.getSelectedRow(), 5).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSignosEspMouseClicked(MouseEvent evt) {
        if (this.JTSignosEsp.getSelectedRow() != -1 && this.JTSignosEsp.getSelectedColumn() == 2) {
            if (this.xmodeloSigEsp.getValueAt(this.JTSignosEsp.getSelectedRow(), 2).equals(true)) {
                mCalcularSegmentos(this.xmodeloSigEsp.getValueAt(this.JTSignosEsp.getSelectedRow(), 1).toString(), Double.parseDouble(this.xmodeloSigEsp.getValueAt(this.JTSignosEsp.getSelectedRow(), 5).toString()));
            } else {
                mCalcularSegmentos(this.xmodeloSigEsp.getValueAt(this.JTSignosEsp.getSelectedRow(), 1).toString(), -Double.parseDouble(this.xmodeloSigEsp.getValueAt(this.JTSignosEsp.getSelectedRow(), 5).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMovArticularMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFuerzaMuscularMouseClicked(MouseEvent evt) {
    }

    private void mCalcularSumatoriasVPosterior() {
        int totalx10 = 0;
        int totalx5 = 0;
        int totalx0 = 0;
        if (this.JPVistaAnt.getComponentCount() > 0) {
            for (int x = 0; x < this.JPVistaAnt.getComponentCount(); x++) {
                if (this.JPVistaAnt.getComponent(x).getClass().getName().equals("javax.swing.JRadioButton")) {
                    JRadioButton xrb = this.JPVistaAnt.getComponent(x);
                    if (xrb.isSelected() && xrb.getName().equals("10")) {
                        totalx10 = 10 + totalx10;
                        this.JTFFColumna1.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna2.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna3.setValue(Integer.valueOf(totalx0));
                    }
                    if (xrb.isSelected() && xrb.getName().equals("5")) {
                        totalx5 = 5 + totalx5;
                        this.JTFFColumna1.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna2.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna3.setValue(Integer.valueOf(totalx0));
                    }
                    if (xrb.isSelected() && xrb.getName().equals("0")) {
                        totalx0 = 0 + totalx0;
                        this.JTFFColumna1.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna2.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna3.setValue(Integer.valueOf(totalx0));
                    }
                }
            }
            double sumatoria = Double.valueOf(this.JTFFColumna1.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna2.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna3.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna4.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna5.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna6.getText().replaceAll(",", ".")).doubleValue();
            this.JTFFSumatoria.setValue(Double.valueOf(sumatoria));
            if (sumatoria >= 80.0d) {
                this.JLCalificacion.setText("Riesgo Postural Bajo");
                return;
            }
            if (sumatoria < 80.0d && sumatoria >= 60.0d) {
                this.JLCalificacion.setText("Riesgo Postural Medio");
            } else if (sumatoria < 60.0d) {
                this.JLCalificacion.setText("Riesgo Postural Alto");
            }
        }
    }

    private void mCalcularSumatoriasVLateral() {
        int totalx10 = 0;
        int totalx5 = 0;
        int totalx0 = 0;
        if (this.JPVistaLateral.getComponentCount() > 0) {
            for (int x = 0; x < this.JPVistaLateral.getComponentCount(); x++) {
                if (this.JPVistaLateral.getComponent(x).getClass().getName().equals("javax.swing.JRadioButton")) {
                    JRadioButton xrb = this.JPVistaLateral.getComponent(x);
                    if (xrb.isSelected() && xrb.getName().equals("10")) {
                        totalx10 = 10 + totalx10;
                        this.JTFFColumna4.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna5.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna6.setValue(Integer.valueOf(totalx0));
                    }
                    if (xrb.isSelected() && xrb.getName().equals("5")) {
                        totalx5 = 5 + totalx5;
                        this.JTFFColumna4.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna5.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna6.setValue(Integer.valueOf(totalx0));
                    }
                    if (xrb.isSelected() && xrb.getName().equals("0")) {
                        totalx0 = 0 + totalx0;
                        this.JTFFColumna4.setValue(Integer.valueOf(totalx10));
                        this.JTFFColumna5.setValue(Integer.valueOf(totalx5));
                        this.JTFFColumna6.setValue(Integer.valueOf(totalx0));
                    }
                }
            }
            double sumatoria = Double.valueOf(this.JTFFColumna1.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna2.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna3.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna4.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna5.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFColumna6.getText().replaceAll(",", ".")).doubleValue();
            this.JTFFSumatoria.setValue(Double.valueOf(sumatoria));
            if (sumatoria >= 80.0d) {
                this.JLCalificacion.setText("Riesgo Postural Bajo");
                return;
            }
            if (sumatoria < 80.0d && sumatoria >= 60.0d) {
                this.JLCalificacion.setText("Riesgo Postural Medio");
            } else if (sumatoria < 60.0d) {
                this.JLCalificacion.setText("Riesgo Postural Alto");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCabAlineadaActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcabeza = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCabIncliLeveActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcabeza = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCabIncliRotadaActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcabeza = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHomAlineadosActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xhombro = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHomLevDescendidoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xhombro = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHomMarDescensoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xhombro = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBColAlineadaActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcolumna = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBColEscoliosisActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcolumna = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBColCurvaLateralActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xcolumna = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPelvIliacasActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpelvis = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPelvHemipelvisActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpelvis = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPelvMarcadoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpelvis = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPieCavoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpies = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRodVaroActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xrodilla = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRodAlineadasActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xrodilla = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRodValgoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xrodilla = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPieAlineadoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpies = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPiePlanoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVPosterior();
        this.xpies = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuelloAlineadoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xcuello = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuelloLevAumentoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xcuello = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuelloRectiActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xcuello = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDorsoNormalActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xdorso = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDorsoAumentoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xdorso = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDorsoProtuidosActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xdorso = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTroncoAlineadoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xtronco = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTroncoLeveActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xtronco = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTroncoInclinacionActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xtronco = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAbdomenNormalActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xabdomen = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAbdomenProtuidoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xabdomen = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAbdomenDescActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xabdomen = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLumbarNormalActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xlumbar = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLumbarAumentoActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xlumbar = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLumbarHiperActionPerformed(ActionEvent evt) {
        mCalcularSumatoriasVLateral();
        this.xlumbar = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "update `h_so_examen_osteomuscular` set Interpretacion='" + this.JTAInterpretacion.getText() + "', IdUsuarioInter='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Resultado='" + this.JCBResultado.getSelectedItem() + "' , Guardado=1 where Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
                Principal.clasehistoriace.mActualizarVariable_ManPower("ROsteomuscular", this.JCBResultado.getSelectedItem().toString(), "Observacion_Ost", this.JTAInterpretacion.getText());
                if (!this.JCBResultado.getSelectedItem().equals("NORMAL")) {
                    Principal.clasehistoriace.mActualizarAlterado_ManPower();
                }
            }
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                this.JBGuardar.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAnteOMAMouseClicked(MouseEvent evt) {
        if (this.JTAnteOMA.getSelectedRow() != -1 && this.JTAnteOMA.getSelectedColumn() == 2) {
            if (this.xmodeloAnteOMA.getValueAt(this.JTAnteOMA.getSelectedRow(), 2).equals(true)) {
                mCalcularSegmentos(this.xmodeloAnteOMA.getValueAt(this.JTAnteOMA.getSelectedRow(), 1).toString(), Double.parseDouble(this.xmodeloAnteOMA.getValueAt(this.JTAnteOMA.getSelectedRow(), 5).toString()));
            } else {
                mCalcularSegmentos(this.xmodeloAnteOMA.getValueAt(this.JTAnteOMA.getSelectedRow(), 1).toString(), -Double.parseDouble(this.xmodeloAnteOMA.getValueAt(this.JTAnteOMA.getSelectedRow(), 5).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaActionPerformed(ActionEvent evt) {
        if (this.JCHAplica.isSelected()) {
            this.xlongitudmmi = 0;
        } else {
            this.xlongitudmmi = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSI_OMAActionPerformed(ActionEvent evt) {
        this.xdolor = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNO_OMAActionPerformed(ActionEvent evt) {
        this.xdolor = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPotencialActionPerformed(ActionEvent evt) {
        if (this.JCHBPotencial.isSelected()) {
            this.xpotencial = 1;
        } else {
            this.xpotencial = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarExamenActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDerechoActionPerformed(ActionEvent evt) {
        this.xlateralidad = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIzquierdoActionPerformed(ActionEvent evt) {
        this.xlateralidad = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoaplicaActionPerformed(ActionEvent evt) {
        this.xlateralidad = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaStateChanged(ChangeEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFSTalla.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoStateChanged(ChangeEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            calcularImc();
            this.JTFFSPeso.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mAnular();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRIzquierdaFocusGained(FocusEvent evt) {
        this.JTFFRIzquierda.setSelectionEnd(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarExamenActionPerformed(ActionEvent evt) {
        mActualizar();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearTablaAnteOMA() {
        this.xmodeloAnteOMA = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "Observación", "pun"}) { // from class: Historia.JPSo_Osteomuscular.68
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAnteOMA.setModel(this.xmodeloAnteOMA);
        this.JTAnteOMA.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAnteOMA.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAnteOMA.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAnteOMA.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTAnteOMA.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTAnteOMA.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTAnteOMA.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTAnteOMA.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTAnteOMA.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTAnteOMA.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mBuscarAnteOMA() {
        try {
            mCrearTablaAnteOMA();
            String sql = "with maestra as(SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`,so_segmento_encabezado.`Puntaje` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) INNER JOIN `so_segmento_encabezado`   ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =1 AND `so_segmento_x_encabezado`.`Estado` =1) ),atencion as (SELECT `so_segmento_x_encabezado`.`Id`, `so_segmento`.`Nbre`, `h_so_examen_osteo_detalle`.`Valor`, `h_so_examen_osteo_detalle`.`Observacion`, `so_segmento_encabezado`.`Puntaje`FROM `so_segmento_x_encabezado` inner join `h_so_examen_osteo_detalle` ON `so_segmento_x_encabezado`.`Id` = `h_so_examen_osteo_detalle`.`Id_Segmentos` INNER JOIN `so_segmento` ON `so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`INNER JOIN `so_segmento_encabezado` ON `so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`WHERE `so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = 1 AND `h_so_examen_osteo_detalle`.`Id_Atencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' )select m.Id, m.Nbre,if(a.Id is null, false, true) as estadoGuardado,ifnull(a.Valor,'') Valor, ifnull(a.Observacion,'') Observacion , ifnull( a.Puntaje,'') Puntaje from maestra as m left join atencion as a on(m.Id=a.Id) ";
            System.out.println("--> " + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloAnteOMA.addRow(this.xdatos);
                    this.xmodeloAnteOMA.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloAnteOMA.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloAnteOMA.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloAnteOMA.setValueAt(false, x, 2);
                    }
                    this.xmodeloAnteOMA.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloAnteOMA.setValueAt(rs1.getString(5), x, 4);
                    this.xmodeloAnteOMA.setValueAt(rs1.getString(6), x, 5);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDiagActivos() {
        this.xmodeloDiagActivo = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "CIE10", "pun", "Observación"}) { // from class: Historia.JPSo_Osteomuscular.69
            Class[] types = {String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDiagActivos.setModel(this.xmodeloDiagActivo);
        this.JTDiagActivos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDiagActivos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDiagActivos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDiagActivos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDiagActivos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDiagActivos.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDiagActivos.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDiagActivos.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTDiagActivos.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDiagActivos.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDiagActivos.getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    private void mBuscarDiagActivo() {
        try {
            mCrearTablaDiagActivos();
            String sql = "with maestra as ( SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`, so_segmento_encabezado.`Puntaje` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) INNER JOIN `so_segmento_encabezado`   ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =2 AND `so_segmento_x_encabezado`.`Estado` =1) ),diagnostifo as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`  , `h_so_examen_osteo_detalle`.`Valor`  , `h_so_examen_osteo_detalle`.`CodCIE10`, `so_segmento_encabezado`.`Puntaje`,`h_so_examen_osteo_detalle`.`Observacion`  FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`    ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)  INNER JOIN `h_so_examen_osteo_detalle`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)  INNER JOIN `so_segmento_encabezado`  ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`)  WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =2 and  `h_so_examen_osteo_detalle`.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') )select m.Id, m.Nbre,if(d.Id is null, false, true) as estadoGuardado,ifnull(d.Valor,'') Valor,ifnull(d.CodCIE10,'') CIE10, ifnull(d.Puntaje,'') Puntaje, ifnull(d.Observacion,'') Observacion from maestra as m  left join diagnostifo as d on (m.Id=d.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloDiagActivo.addRow(this.xdatos);
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloDiagActivo.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloDiagActivo.setValueAt(false, x, 2);
                    }
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(5), x, 4);
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(6), x, 5);
                    this.xmodeloDiagActivo.setValueAt(rs1.getString(7), x, 6);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEvaDolor() {
        this.xmodeloEvaDolor = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "Observación", "pun"}) { // from class: Historia.JPSo_Osteomuscular.70
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEvaDolor.setModel(this.xmodeloEvaDolor);
        this.JTEvaDolor.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTEvaDolor.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTEvaDolor.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTEvaDolor.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTEvaDolor.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTEvaDolor.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTEvaDolor.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTEvaDolor.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTEvaDolor.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTEvaDolor.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mBuscarEvaDolor() {
        try {
            mCrearTablaEvaDolor();
            String sql = "with maestra as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`,so_segmento_encabezado.`Puntaje` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) INNER JOIN `so_segmento_encabezado`   ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =3 AND `so_segmento_x_encabezado`.`Estado` =1) ),dolor as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`  , `h_so_examen_osteo_detalle`.`Valor`  , `h_so_examen_osteo_detalle`.`Observacion` , `so_segmento_encabezado`.`Puntaje`  FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`    ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)  INNER JOIN `h_so_examen_osteo_detalle`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)  INNER JOIN `so_segmento_encabezado`  ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`)  WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =3 and  `h_so_examen_osteo_detalle`.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') )select m.Id, m.Nbre,if(d.Id is null, false, true) as estadoGuardado,ifnull(d.Valor,'') Valor, ifnull(d.Observacion,'') Observacion , ifnull( d.Puntaje,'') Puntaje from maestra as m left join dolor as d on (m.Id=d.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloEvaDolor.addRow(this.xdatos);
                    this.xmodeloEvaDolor.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloEvaDolor.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloEvaDolor.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloEvaDolor.setValueAt(false, x, 2);
                    }
                    this.xmodeloEvaDolor.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloEvaDolor.setValueAt(rs1.getString(5), x, 4);
                    this.xmodeloEvaDolor.setValueAt(rs1.getString(6), x, 5);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSigEsp() {
        this.xmodeloSigEsp = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "Observación", "pun"}) { // from class: Historia.JPSo_Osteomuscular.71
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSignosEsp.setModel(this.xmodeloSigEsp);
        this.JTSignosEsp.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSignosEsp.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSignosEsp.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSignosEsp.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTSignosEsp.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTSignosEsp.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTSignosEsp.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTSignosEsp.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTSignosEsp.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTSignosEsp.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mBuscarSigEsp() {
        try {
            mCrearTablaSigEsp();
            String sql = "with maestra as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`, so_segmento_encabezado.`Puntaje` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) INNER JOIN `so_segmento_encabezado`   ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =4 AND `so_segmento_x_encabezado`.`Estado` =1) ),esp as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`  , `h_so_examen_osteo_detalle`.`Valor`  , `h_so_examen_osteo_detalle`.`Observacion` , `so_segmento_encabezado`.`Puntaje`  FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`    ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)  INNER JOIN `h_so_examen_osteo_detalle`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)  INNER JOIN `so_segmento_encabezado`  ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`)  WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =4 and  `h_so_examen_osteo_detalle`.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') )select m.Id, m.Nbre,if(e.Id is null, false, true) as estadoGuardado,ifnull(e.Valor,'') Valor,ifnull(e.Observacion,'') Observacion , ifnull( e.Puntaje,'') Puntaje from maestra as m left join esp as e on (m.Id=e.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloSigEsp.addRow(this.xdatos);
                    this.xmodeloSigEsp.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloSigEsp.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloSigEsp.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloSigEsp.setValueAt(false, x, 2);
                    }
                    this.xmodeloSigEsp.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloSigEsp.setValueAt(rs1.getString(5), x, 4);
                    this.xmodeloSigEsp.setValueAt(rs1.getString(6), x, 5);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaMovArt() {
        this.xmodeloMovArt = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "Observación"}) { // from class: Historia.JPSo_Osteomuscular.72
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMovArticular.setModel(this.xmodeloMovArt);
        this.JTMovArticular.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTMovArticular.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTMovArticular.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTMovArticular.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTMovArticular.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTMovArticular.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTMovArticular.getColumnModel().getColumn(4).setPreferredWidth(120);
    }

    private void mBuscarMovArt() {
        try {
            mCrearTablaMovArt();
            String sql = "with maestra as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =5 AND `so_segmento_x_encabezado`.`Estado` =1) ),articular as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`  , `h_so_examen_osteo_detalle`.`Valor`  , `h_so_examen_osteo_detalle`.`Observacion`  FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`    ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)  INNER JOIN `h_so_examen_osteo_detalle`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)  INNER JOIN `so_segmento_encabezado`  ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`)  WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =5 and  `h_so_examen_osteo_detalle`.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') )select m.Id, m.Nbre,if(a.Id is null, false, true) as estadoGuardado,ifnull(a.Valor,'') Valor, ifnull(a.Observacion,'') Observacion  from maestra as m left join articular as a on (m.Id=a.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloMovArt.addRow(this.xdatos);
                    this.xmodeloMovArt.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloMovArt.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloMovArt.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloMovArt.setValueAt(false, x, 2);
                    }
                    this.xmodeloMovArt.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloMovArt.setValueAt(rs1.getString(5), x, 4);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaFuerzaMusc() {
        this.xmodeloFuerzaMusc = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Aplica?", "Valor", "Observación"}) { // from class: Historia.JPSo_Osteomuscular.73
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTFuerzaMuscular.setModel(this.xmodeloFuerzaMusc);
        this.JTFuerzaMuscular.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTFuerzaMuscular.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTFuerzaMuscular.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTFuerzaMuscular.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTFuerzaMuscular.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTFuerzaMuscular.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTFuerzaMuscular.getColumnModel().getColumn(4).setPreferredWidth(120);
    }

    private void mBuscarFuerzaMusc() {
        try {
            mCrearTablaFuerzaMusc();
            String sql = "with maestra as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre` FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`) WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =6 AND `so_segmento_x_encabezado`.`Estado` =1) ),muscular as (SELECT `so_segmento_x_encabezado`.`Id` , `so_segmento`.`Nbre`  , `h_so_examen_osteo_detalle`.`Valor`  , `h_so_examen_osteo_detalle`.`Observacion`  FROM `so_segmento_x_encabezado` INNER JOIN `so_segmento`    ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)  INNER JOIN `h_so_examen_osteo_detalle`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)  INNER JOIN `so_segmento_encabezado`  ON (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` = `so_segmento_encabezado`.`Id`)  WHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =6 and  `h_so_examen_osteo_detalle`.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') )select m.Id, m.Nbre,if(a.Id is null, false, true) as estadoGuardado,ifnull(a.Valor,'') Valor,ifnull(a.Observacion,'') Observacion  from maestra as m left join muscular as a on (m.Id=a.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloFuerzaMusc.addRow(this.xdatos);
                    this.xmodeloFuerzaMusc.setValueAt(rs1.getString(1), x, 0);
                    this.xmodeloFuerzaMusc.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodeloFuerzaMusc.setValueAt(true, x, 2);
                    } else {
                        this.xmodeloFuerzaMusc.setValueAt(false, x, 2);
                    }
                    this.xmodeloFuerzaMusc.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloFuerzaMusc.setValueAt(rs1.getString(5), x, 4);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaRecomendacion() {
        this.xmodelorecomendacion = new DefaultTableModel(new Object[0], new String[]{"Id", "Recomendación", "Aplica?", "Observación"}) { // from class: Historia.JPSo_Osteomuscular.74
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRecomendaciones.setModel(this.xmodelorecomendacion);
        this.JTRecomendaciones.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTRecomendaciones.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTRecomendaciones.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTRecomendaciones.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTRecomendaciones.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.JTRecomendaciones.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void mBuscarRecomendacion() {
        try {
            mCrearTablaRecomendacion();
            String sql = "with maestra as (SELECT `Id` , `Nbre` FROM `so_recomendaciones` WHERE (`Id_Encabezado` =5 AND `Estado` =1)),recomendaciones as (SELECT  `so_recomendaciones`.`Id`,`so_recomendaciones`.`Nbre` , `h_so_exa_osteo_recomendacion`.`Observacion` FROM `h_so_exa_osteo_recomendacion` INNER JOIN `so_recomendaciones`  ON (`h_so_exa_osteo_recomendacion`.`Id_Recomendacion` = `so_recomendaciones`.`Id`) WHERE (`h_so_exa_osteo_recomendacion`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'))select m.Id, m.Nbre,if(a.Id is null, false, true) as estadoGuardado, ifnull(a.Observacion,'') Observacion  from maestra as m left join recomendaciones as a on (m.Id=a.Id)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            TableColumnModel cmodel = this.JTRecomendaciones.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(1).setCellEditor(textEditor);
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelorecomendacion.addRow(this.xdatos);
                    this.xmodelorecomendacion.setValueAt(rs1.getString(1), x, 0);
                    this.xmodelorecomendacion.setValueAt(rs1.getString(2), x, 1);
                    if (rs1.getBoolean(3)) {
                        this.xmodelorecomendacion.setValueAt(true, x, 2);
                    } else {
                        this.xmodelorecomendacion.setValueAt(false, x, 2);
                    }
                    this.xmodelorecomendacion.setValueAt(rs1.getString(4), x, 3);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaNSeveridad() {
        this.xmodelonseveridad = new DefaultTableModel(new Object[0], new String[]{"Id", "Segmento", "Valor", "Calificación"}) { // from class: Historia.JPSo_Osteomuscular.75
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTNivelSeveridad.setModel(this.xmodelonseveridad);
        this.JTNivelSeveridad.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTNivelSeveridad.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTNivelSeveridad.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTNivelSeveridad.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTNivelSeveridad.getColumnModel().getColumn(2).setPreferredWidth(35);
        this.JTNivelSeveridad.getColumnModel().getColumn(3).setPreferredWidth(280);
    }

    private void mBuscarNSeveridad() {
        try {
            mCrearTablaNSeveridad();
            String sql = "with maestra as (SELECT `Id`, `Nbre` FROM `so_segmento` WHERE (`Estado` =1 and Nbre<>'NINGUNO')),severidad as (SELECT so_segmento.`Id`,`so_segmento`.`Nbre` , `h_so_exa_osteo_niv_severidad`.`Valor`  , `h_so_exa_osteo_niv_severidad`.`Calificacion`  FROM `h_so_exa_osteo_niv_severidad`  INNER JOIN `so_segmento`  ON (`h_so_exa_osteo_niv_severidad`.`Id_Segmento` = `so_segmento`.`Id`) WHERE (`h_so_exa_osteo_niv_severidad`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'))select m.Id, m.Nbre,ifnull(a.Valor,'0') Valor,ifnull(a.Calificacion,'') Calificacion  from maestra as m left join severidad as a on (m.Id=a.Id) group by m.Id";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelonseveridad.addRow(this.xdatos);
                    this.xmodelonseveridad.setValueAt(Integer.valueOf(rs1.getInt(1)), x, 0);
                    this.xmodelonseveridad.setValueAt(rs1.getString(2), x, 1);
                    this.xmodelonseveridad.setValueAt(rs1.getString(3), x, 2);
                    this.xmodelonseveridad.setValueAt(rs1.getString(4), x, 3);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarCombos() {
        this.JCBSegInteres.removeAllItems();
        this.xiseginteres = this.xconsultasbd.llenarCombo("SELECT  `Id` , `Nbre` FROM `so_segmento` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xiseginteres, this.JCBSegInteres);
        this.JCBSegInteres.setSelectedItem("NINGUNO");
        this.JCBTipoDolor.removeAllItems();
        this.xidtipodolor = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `so_tipodolor` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidtipodolor, this.JCBTipoDolor);
        this.JCBTipoDolor.setSelectedItem("NO APLICA");
        this.JCBIntensidad.removeAllItems();
        this.xidintensidad = this.xconsultasbd.llenarCombo("SELECT  `Id`, `Nbre` FROM `so_intensidad_dolor` WHERE (`Estado` =1) ORDER BY `Id` ASC", this.xidintensidad, this.JCBIntensidad);
        this.JCBIntensidad.setSelectedItem("NO APLICA");
        this.JCBHallazgosSigEsp.removeAllItems();
        this.xidhallazgoSigEsp = this.xconsultasbd.llenarCombo("SELECT `Id`  , `Nbre` FROM `so_hallazgo_x_encabezado` WHERE (`Id_Encabezado` =4 AND `Estado` =1)", this.xidhallazgoSigEsp, this.JCBHallazgosSigEsp);
        this.JCBHallazgosSigEsp.setSelectedIndex(-1);
        this.JCBHallazgosMovArt.removeAllItems();
        this.xidhallazgoMovArt = this.xconsultasbd.llenarCombo("SELECT `Id`  , `Nbre` FROM `so_hallazgo_x_encabezado` WHERE (`Id_Encabezado` =5 AND `Estado` =1)", this.xidhallazgoMovArt, this.JCBHallazgosMovArt);
        this.JCBHallazgosMovArt.setSelectedIndex(-1);
        this.JCBFuerzaMuscular.removeAllItems();
        this.xidhallazgoFuerzaMusc = this.xconsultasbd.llenarCombo("SELECT `Id`  , `Nbre` FROM `so_hallazgo_x_encabezado` WHERE (`Id_Encabezado` =6 AND `Estado` =1)", this.xidhallazgoFuerzaMusc, this.JCBFuerzaMuscular);
        this.JCBFuerzaMuscular.setSelectedIndex(-1);
        this.JCBHallazgosOMA.removeAllItems();
        this.xidhallazgoOMA = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM`so_hallazgo_x_encabezado` WHERE (`Id_Encabezado` =7)", this.xidhallazgoOMA, this.JCBHallazgosOMA);
        this.JCBHallazgosOMA.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.JTFFRIzquierda.setValue(Double.valueOf(0.0d));
        this.JTFFRDerecha.setValue(Double.valueOf(0.0d));
        this.JTFFAIzquierda.setValue(Double.valueOf(0.0d));
        this.JTFFADerecha.setValue(Double.valueOf(0.0d));
        this.JTFFVFlexibilidad.setValue(Double.valueOf(0.0d));
        this.JTFFPFlexibilidad.setValue(Double.valueOf(0.0d));
        this.JTFFVFuAbdominal.setValue(Double.valueOf(0.0d));
        this.JTFFPFuAbdominal.setValue(Double.valueOf(0.0d));
        this.JTFFVFuBrazos.setValue(Double.valueOf(0.0d));
        this.JTFFPFuBrazos.setValue(Double.valueOf(0.0d));
    }

    private void mLongitudMMICombo1(double x, double y, long tipo) {
        double total = x - y;
        if (tipo == 0) {
            if (total < -1.5d) {
                this.JCBCalReal.setSelectedItem("NOTABLE DISMETRIA MMII");
            } else if (total > -1.6d && total < 0.0d) {
                this.JCBCalReal.setSelectedItem("LEVE DISMETRIA MMII");
            } else if (total == 0.0d) {
                this.JCBCalReal.setSelectedItem("SIMETRIA MMII");
            } else if (total > 0.0d && total < 1.6d) {
                this.JCBCalReal.setSelectedItem("LEVE DISMETRIA MMII");
            } else if (total > 1.5d) {
                this.JCBCalReal.setSelectedItem("NOTABLE DISMETRIA MMII");
            }
        } else if (tipo == 1) {
            if (total < -1.5d) {
                this.JCBCalAparente.setSelectedItem("NOTABLE DISMETRIA MMII");
            } else if (total > -1.6d && total < 0.0d) {
                this.JCBCalAparente.setSelectedItem("LEVE DISMETRIA MMII");
            } else if (total == 0.0d) {
                this.JCBCalAparente.setSelectedItem("SIMETRIA MMII");
            } else if (total > 0.0d && total < 1.6d) {
                this.JCBCalAparente.setSelectedItem("LEVE DISMETRIA MMII");
            } else if (total > 1.5d) {
                this.JCBCalAparente.setSelectedItem("NOTABLE DISMETRIA MMII");
            }
        }
        double tsuma1 = Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue();
        double tsuma2 = Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue();
        if (this.JCBMMCortoA.getSelectedItem().equals("NINGUNO")) {
            this.JCBMMCortoFinal.setSelectedItem("NINGUNO");
            return;
        }
        if (tsuma1 > tsuma2 || tsuma1 == tsuma2) {
            this.JCBMMCortoFinal.setSelectedItem(this.JCBMMCortoA.getSelectedItem());
        } else if (tsuma1 < tsuma2) {
            this.JCBMMCortoFinal.setSelectedItem(this.JCBMMCortoR.getSelectedItem());
        }
    }

    private void mLongitudMMICombo2(double x, double y, long tipo) {
        double total = x - y;
        if (tipo == 0) {
            if (total > 0.0d) {
                this.JCBMMCortoR.setSelectedItem("MIEMBRO INFERIOR DERECHO");
            } else if (total < 0.0d) {
                this.JCBMMCortoR.setSelectedItem("MIEMBRO INFERIOR IZQUIERDO");
            } else if (total == 0.0d) {
                this.JCBMMCortoR.setSelectedItem("NINGUNO");
            }
        } else if (tipo == 1) {
            if (total > 0.0d) {
                this.JCBMMCortoA.setSelectedItem("MIEMBRO INFERIOR DERECHO");
            } else if (total < 0.0d) {
                this.JCBMMCortoA.setSelectedItem("MIEMBRO INFERIOR IZQUIERDO");
            } else if (total == 0.0d) {
                this.JCBMMCortoA.setSelectedItem("NINGUNO");
            }
        }
        double tsuma1 = Double.valueOf(this.JTFFRIzquierda.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFRDerecha.getText().replaceAll(",", ".")).doubleValue();
        double tsuma2 = Double.valueOf(this.JTFFAIzquierda.getText().replaceAll(",", ".")).doubleValue() + Double.valueOf(this.JTFFADerecha.getText().replaceAll(",", ".")).doubleValue();
        if (this.JCBMMCortoA.getSelectedItem().equals("NINGUNO")) {
            this.JCBMMCortoFinal.setSelectedItem("NINGUNO");
            return;
        }
        if (tsuma1 > tsuma2 || tsuma1 == tsuma2) {
            this.JCBMMCortoFinal.setSelectedItem(this.JCBMMCortoA.getSelectedItem());
        } else if (tsuma1 < tsuma2) {
            this.JCBMMCortoFinal.setSelectedItem(this.JCBMMCortoR.getSelectedItem());
        }
    }

    private void mCalcularSegmentos(String contenido, double xvalor) {
        for (int i = 0; i < this.JTNivelSeveridad.getRowCount(); i++) {
            if (contenido.equals(this.xmodelonseveridad.getValueAt(i, 1))) {
                double suma = Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) + xvalor;
                this.xmodelonseveridad.setValueAt(Double.valueOf(suma), i, 2);
                if (Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) >= 0.0d && Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) <= 0.9d) {
                    this.xmodelonseveridad.setValueAt("BAJO", i, 3);
                } else if (Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) >= 1.0d && Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) <= 1.9d) {
                    this.xmodelonseveridad.setValueAt("MEDIO", i, 3);
                } else if (Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) >= 2.0d && Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) <= 2.9d) {
                    this.xmodelonseveridad.setValueAt("ALTO", i, 3);
                } else if (Double.parseDouble(this.xmodelonseveridad.getValueAt(i, 2).toString()) >= 3.0d) {
                    this.xmodelonseveridad.setValueAt("CRÍTICO", i, 3);
                }
            }
        }
    }

    private void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO h_so_examen_osteomuscular (`Id_Usuario` , `Id_Atencion` , `FechaE` , `LongitudMMII`  , `RIzquierda`  , `RDerecha` , `RCalificacion` , `RMiembCorto`  , `AIzquierda`  , `ADerecha` , `ACalificacion` , `AMiembCorto` , `MiembCortoF`  , `DolorOMA`  , `SegmentoInteres` , `TipoDolor` , `Intensidad` , `FactorExac` , `FactorDism` , `HallazgoSignos`  , `HallazgoMov`  , `HallazgoFuerza` , `VACabeza` , `VAHombro` , `VAColumna` , `VAPelvis` , `VARodillas` , `VAPies` , `VLCuello` , `VLDorso` , `VLTronco` , `VLAbdomen` , `VLLumbar` , `Sumatoria`  , `CalAlineacionRiesgo` , `DescripcionCal`  , `FlexValor` , `FlexPercentil`  , `FlexCategoria` , `FAbdValor` , `FAbdPercentil` , `FAbdCategoria`  , `FBrazValor` , `FBrazPercentil` , `FBrazCategoria` , `CalSeveridad`  , `HallazgoOMA` , `Hallazgo` , `Potencial`, IdUsuarioOMA, IdEspecialidad,Lateralidad,Talla, Peso, IMC, UsuarioS)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xlongitudmmi + "','" + this.JTFFRIzquierda.getValue() + "','" + this.JTFFRDerecha.getValue() + "','" + this.JCBCalReal.getSelectedItem() + "','" + this.JCBMMCortoR.getSelectedItem() + "','" + this.JTFFAIzquierda.getValue() + "','" + this.JTFFADerecha.getValue() + "','" + this.JCBCalAparente.getSelectedItem() + "','" + this.JCBMMCortoA.getSelectedItem() + "','" + this.JCBMMCortoFinal.getSelectedItem() + "','" + this.xdolor + "','" + this.JCBSegInteres.getSelectedItem() + "','" + this.JCBTipoDolor.getSelectedItem() + "','" + this.JCBIntensidad.getSelectedItem() + "','" + this.JTFFactoresExa.getText() + "','" + this.JTFFactoresDism.getText() + "','" + this.JCBHallazgosSigEsp.getSelectedItem() + "','" + this.JCBHallazgosMovArt.getSelectedItem() + "','" + this.JCBFuerzaMuscular.getSelectedItem() + "','" + this.xcabeza + "','" + this.xhombro + "','" + this.xcolumna + "','" + this.xpelvis + "','" + this.xrodilla + "','" + this.xpies + "','" + this.xcuello + "','" + this.xdorso + "','" + this.xtronco + "','" + this.xabdomen + "','" + this.xlumbar + "','" + this.JTFFSumatoria.getValue() + "','" + this.JLCalificacion.getText() + "','" + this.JTFDescripcion.getText() + "','" + this.JTFFVFlexibilidad.getValue() + "','" + this.JTFFPFlexibilidad.getValue() + "','" + this.JLCatFlexibilidad.getText() + "','" + this.JTFFVFuAbdominal.getValue() + "','" + this.JTFFPFuAbdominal.getValue() + "','" + this.JLCatFueAbdominal.getText() + "','" + this.JTFFVFuBrazos.getValue() + "','" + this.JTFFPFuBrazos.getValue() + "','" + this.JLCatFueBrazos.getText() + "','" + this.JCBCalSeveridad.getSelectedItem() + "','" + this.JTAHallazgo.getText() + "','" + this.JCBHallazgosOMA.getSelectedItem() + "','" + this.xpotencial + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xlateralidad + "','" + this.JTFFSTalla.getValue() + "','" + this.JTFFSPeso.getValue() + "','" + this.JTFFSIMC.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xid = this.xconsultasbd.ejecutarSQLId(sql);
            this.xconsultasbd.cerrarConexionBd();
            for (int y = 0; y < this.JTAnteOMA.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodeloAnteOMA.getValueAt(y, 2).toString()).booleanValue()) {
                    String sql2 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`, Id_Atencion) values ('" + this.xid + "','" + this.xmodeloAnteOMA.getValueAt(y, 0) + "','" + this.xmodeloAnteOMA.getValueAt(y, 3) + "','" + this.xmodeloAnteOMA.getValueAt(y, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y2 = 0; y2 < this.JTDiagActivos.getRowCount(); y2++) {
                if (Boolean.valueOf(this.xmodeloDiagActivo.getValueAt(y2, 2).toString()).booleanValue()) {
                    String sql3 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `CodCIE10`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloDiagActivo.getValueAt(y2, 0) + "','" + this.xmodeloDiagActivo.getValueAt(y2, 3) + "','" + this.xmodeloDiagActivo.getValueAt(y2, 4) + "','" + this.xmodeloDiagActivo.getValueAt(y2, 6) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql3);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y3 = 0; y3 < this.JTEvaDolor.getRowCount(); y3++) {
                if (Boolean.valueOf(this.xmodeloEvaDolor.getValueAt(y3, 2).toString()).booleanValue()) {
                    String sql4 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloEvaDolor.getValueAt(y3, 0) + "','" + this.xmodeloEvaDolor.getValueAt(y3, 3) + "','" + this.xmodeloEvaDolor.getValueAt(y3, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql4);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y4 = 0; y4 < this.JTSignosEsp.getRowCount(); y4++) {
                if (Boolean.valueOf(this.xmodeloSigEsp.getValueAt(y4, 2).toString()).booleanValue()) {
                    String sql5 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloSigEsp.getValueAt(y4, 0) + "','" + this.xmodeloSigEsp.getValueAt(y4, 3) + "','" + this.xmodeloSigEsp.getValueAt(y4, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql5);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y5 = 0; y5 < this.JTMovArticular.getRowCount(); y5++) {
                if (Boolean.valueOf(this.xmodeloMovArt.getValueAt(y5, 2).toString()).booleanValue()) {
                    String sql6 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloMovArt.getValueAt(y5, 0) + "','" + this.xmodeloMovArt.getValueAt(y5, 3) + "','" + this.xmodeloMovArt.getValueAt(y5, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql6);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y6 = 0; y6 < this.JTFuerzaMuscular.getRowCount(); y6++) {
                if (Boolean.valueOf(this.xmodeloFuerzaMusc.getValueAt(y6, 2).toString()).booleanValue()) {
                    String sql7 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloFuerzaMusc.getValueAt(y6, 0) + "','" + this.xmodeloFuerzaMusc.getValueAt(y6, 3) + "','" + this.xmodeloFuerzaMusc.getValueAt(y6, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql7);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y7 = 0; y7 < this.JTNivelSeveridad.getRowCount(); y7++) {
                String sql8 = "insert into h_so_exa_osteo_niv_severidad(`Id_ExamenOsteo`, `Id_Segmento`, `Valor`, `Calificacion`,Id_Atencion ) values ('" + this.xid + "','" + this.xmodelonseveridad.getValueAt(y7, 0) + "','" + this.xmodelonseveridad.getValueAt(y7, 2) + "','" + this.xmodelonseveridad.getValueAt(y7, 3) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                this.xconsultasbd.ejecutarSQL(sql8);
                this.xconsultasbd.cerrarConexionBd();
            }
            for (int y8 = 0; y8 < this.JTRecomendaciones.getRowCount(); y8++) {
                if (Boolean.valueOf(this.xmodelorecomendacion.getValueAt(y8, 2).toString()).booleanValue()) {
                    String sql9 = "insert into h_so_exa_osteo_recomendacion (`Id_ExamenOsteo` , `Id_Recomendacion`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodelorecomendacion.getValueAt(y8, 0) + "','" + this.xmodelorecomendacion.getValueAt(y8, 3) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    this.xconsultasbd.ejecutarSQL(sql9);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mCargarDatosTablaHistorico();
            this.JBGrabarExamen.setEnabled(false);
        }
    }

    private void mActualizar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                verificarVariablesGraficas();
            }
            String sql = "UPDATE h_so_examen_osteomuscular SET `Id_Usuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', `FechaE` ='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', `LongitudMMII` = '" + this.xlongitudmmi + "', `RIzquierda` = '" + this.JTFFRIzquierda.getValue() + "', `RDerecha` = '" + this.JTFFRDerecha.getValue() + "', `RCalificacion` = '" + this.JCBCalReal.getSelectedItem() + "', `RMiembCorto` = '" + this.JCBMMCortoR.getSelectedItem() + "', `AIzquierda` = '" + this.JTFFAIzquierda.getValue() + "', `ADerecha` = '" + this.JTFFADerecha.getValue() + "', `ACalificacion` = '" + this.JCBCalAparente.getSelectedItem() + "', `AMiembCorto` = '" + this.JCBMMCortoA.getSelectedItem() + "', `MiembCortoF` = '" + this.JCBMMCortoFinal.getSelectedItem() + "', `DolorOMA` = '" + this.xdolor + "', `SegmentoInteres` = '" + this.JCBSegInteres.getSelectedItem() + "', `TipoDolor` = '" + this.JCBTipoDolor.getSelectedItem() + "', `Intensidad` = '" + this.JCBIntensidad.getSelectedItem() + "', `FactorExac` = '" + this.JTFFactoresExa.getText() + "', `FactorDism` = '" + this.JTFFactoresDism.getText() + "', `HallazgoSignos` = '" + this.JCBHallazgosSigEsp.getSelectedItem() + "', `HallazgoMov` = '" + this.JCBHallazgosMovArt.getSelectedItem() + "', `HallazgoFuerza` = '" + this.JCBFuerzaMuscular.getSelectedItem() + "', `VACabeza` = '" + this.xcabeza + "', `VAHombro` = '" + this.xhombro + "', `VAColumna` = '" + this.xcolumna + "', `VAPelvis` = '" + this.xpelvis + "', `VARodillas` ='" + this.xrodilla + "', `VAPies` = '" + this.xpies + "', `VLCuello` = '" + this.xcuello + "', `VLDorso` = '" + this.xdorso + "', `VLTronco` = '" + this.xtronco + "', `VLAbdomen` = '" + this.xabdomen + "', `VLLumbar` = '" + this.xlumbar + "', `Sumatoria` = '" + this.JTFFSumatoria.getValue() + "', `CalAlineacionRiesgo` = '" + this.JLCalificacion.getText() + "', `DescripcionCal` = '" + this.JTFDescripcion.getText() + "', `FlexValor` = '" + this.JTFFVFlexibilidad.getValue() + "', `FlexPercentil` = '" + this.JTFFPFlexibilidad.getValue() + "', `FlexCategoria` = '" + this.JLCatFlexibilidad.getText() + "', `FAbdValor` = '" + this.JTFFVFuAbdominal.getValue() + "', `FAbdPercentil` = '" + this.JTFFPFuAbdominal.getValue() + "', `FAbdCategoria` = '" + this.JLCatFueAbdominal.getText() + "', `FBrazValor` = '" + this.JTFFVFuBrazos.getValue() + "', `FBrazPercentil` = '" + this.JTFFPFuBrazos.getValue() + "', `FBrazCategoria` = '" + this.JLCatFueBrazos.getText() + "', `CalSeveridad` = '" + this.JCBCalSeveridad.getSelectedItem() + "', `HallazgoOMA` = '" + this.JTAHallazgo.getText() + "', `Hallazgo` = '" + this.JCBHallazgosOMA.getSelectedItem() + "', `Potencial` = '" + this.xpotencial + "', `IdUsuarioOMA` = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', `IdEspecialidad` = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', `Lateralidad` = '" + this.xlateralidad + "', `Talla` = '" + this.JTFFSTalla.getValue() + "', `Peso` = '" + this.JTFFSPeso.getValue() + "', `IMC` = '" + this.JTFFSIMC.getValue() + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            System.out.println("actualizar actualizar 1 -> " + sql);
            this.xconsultasbd.ejecutarSQL(sql);
            String xsql = "SELECT Id FROM h_so_examen_osteomuscular WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            try {
                ResultSet xrs = this.xconsultasbd.traerRs(xsql);
                if (xrs.next()) {
                    this.xid = xrs.getString(1);
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            System.out.println("id -> " + this.xid);
            this.xconsultasbd.cerrarConexionBd();
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y = 0; y < this.JTAnteOMA.getRowCount(); y++) {
                    String sql2 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloAnteOMA.getValueAt(y, 0) + "',Valor = '" + this.xmodeloAnteOMA.getValueAt(y, 3) + "', Observacion = '" + this.xmodeloAnteOMA.getValueAt(y, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloAnteOMA.getValueAt(y, 0).toString()) + "';";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                    System.out.println("actualizar actualizar 2 -> " + sql2);
                }
            } else {
                for (int y2 = 0; y2 < this.JTAnteOMA.getRowCount(); y2++) {
                    boolean oma = false;
                    String sqlOMA = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloAnteOMA.getValueAt(y2, 0).toString()) + "';";
                    try {
                        ResultSet xrs2 = this.xconsultasbd.traerRs(sqlOMA);
                        if (xrs2.next() && (xrs2.getString(1) != null || !xrs2.getString(1).isEmpty())) {
                            oma = true;
                        }
                        xrs2.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e) {
                    }
                    if (oma) {
                        String sql3 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + Integer.parseInt(this.xmodeloAnteOMA.getValueAt(y2, 0).toString()) + "',Valor = '" + this.xmodeloAnteOMA.getValueAt(y2, 3) + "', Observacion = '" + this.xmodeloAnteOMA.getValueAt(y2, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloAnteOMA.getValueAt(y2, 0).toString()) + "';";
                        this.xconsultasbd.ejecutarSQL(sql3);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("actualizar actualizar 2 -> " + sql3);
                    } else if (Boolean.valueOf(this.xmodeloAnteOMA.getValueAt(y2, 2).toString()).booleanValue()) {
                        String sql4 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`, Id_Atencion) values ('" + this.xid + "','" + this.xmodeloAnteOMA.getValueAt(y2, 0) + "','" + this.xmodeloAnteOMA.getValueAt(y2, 3) + "','" + this.xmodeloAnteOMA.getValueAt(y2, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql4);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en oma -> " + sql4);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y3 = 0; y3 < this.JTDiagActivos.getRowCount(); y3++) {
                    String sql5 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloDiagActivo.getValueAt(y3, 0) + "',Valor = '" + this.xmodeloDiagActivo.getValueAt(y3, 3) + "',CodCIE10='" + this.xmodeloDiagActivo.getValueAt(y3, 4) + "', Observacion = '" + this.xmodeloDiagActivo.getValueAt(y3, 6) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloDiagActivo.getValueAt(y3, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 3 -> " + sql5);
                    this.xconsultasbd.ejecutarSQL(sql5);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y4 = 0; y4 < this.JTDiagActivos.getRowCount(); y4++) {
                    boolean act = false;
                    String sqlAct = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloDiagActivo.getValueAt(y4, 0).toString()) + "';";
                    try {
                        ResultSet xrs3 = this.xconsultasbd.traerRs(sqlAct);
                        if (xrs3.next() && (xrs3.getString(1) != null || !xrs3.getString(1).isEmpty())) {
                            act = true;
                        }
                        xrs3.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e2) {
                    }
                    if (act) {
                        String sql6 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloDiagActivo.getValueAt(y4, 0) + "',Valor = '" + this.xmodeloDiagActivo.getValueAt(y4, 3) + "',CodCIE10='" + this.xmodeloDiagActivo.getValueAt(y4, 4) + "', Observacion = '" + this.xmodeloDiagActivo.getValueAt(y4, 6) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloDiagActivo.getValueAt(y4, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 3 -> " + sql6);
                        this.xconsultasbd.ejecutarSQL(sql6);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloDiagActivo.getValueAt(y4, 2).toString()).booleanValue()) {
                        String sql7 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `CodCIE10`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloDiagActivo.getValueAt(y4, 0) + "','" + this.xmodeloDiagActivo.getValueAt(y4, 3) + "','" + this.xmodeloDiagActivo.getValueAt(y4, 4) + "','" + this.xmodeloDiagActivo.getValueAt(y4, 6) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql7);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en activos presentes -> " + sql7);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y5 = 0; y5 < this.JTEvaDolor.getRowCount(); y5++) {
                    String sql8 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloEvaDolor.getValueAt(y5, 0) + "',Valor = '" + this.xmodeloEvaDolor.getValueAt(y5, 3) + "', Observacion = '" + this.xmodeloEvaDolor.getValueAt(y5, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloEvaDolor.getValueAt(y5, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 4 -> " + sql8);
                    this.xconsultasbd.ejecutarSQL(sql8);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y6 = 0; y6 < this.JTEvaDolor.getRowCount(); y6++) {
                    boolean dolor = false;
                    String sqlDolor = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloEvaDolor.getValueAt(y6, 0).toString()) + "';";
                    try {
                        ResultSet xrs4 = this.xconsultasbd.traerRs(sqlDolor);
                        if (xrs4.next() && (xrs4.getString(1) != null || !xrs4.getString(1).isEmpty())) {
                            dolor = true;
                        }
                        xrs4.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e3) {
                    }
                    if (dolor) {
                        String sql9 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloEvaDolor.getValueAt(y6, 0) + "',Valor = '" + this.xmodeloEvaDolor.getValueAt(y6, 3) + "', Observacion = '" + this.xmodeloEvaDolor.getValueAt(y6, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloEvaDolor.getValueAt(y6, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 4 -> " + sql9);
                        this.xconsultasbd.ejecutarSQL(sql9);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloEvaDolor.getValueAt(y6, 2).toString()).booleanValue()) {
                        String sql10 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloEvaDolor.getValueAt(y6, 0) + "','" + this.xmodeloEvaDolor.getValueAt(y6, 3) + "','" + this.xmodeloEvaDolor.getValueAt(y6, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql10);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en evaluacion del dolor -> " + sql10);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y7 = 0; y7 < this.JTSignosEsp.getRowCount(); y7++) {
                    String sql11 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloSigEsp.getValueAt(y7, 0) + "',Valor = '" + this.xmodeloSigEsp.getValueAt(y7, 3) + "', Observacion = '" + this.xmodeloSigEsp.getValueAt(y7, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloSigEsp.getValueAt(y7, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 5 -> " + sql11);
                    this.xconsultasbd.ejecutarSQL(sql11);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y8 = 0; y8 < this.JTSignosEsp.getRowCount(); y8++) {
                    boolean signos = false;
                    String sqlsignos = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloSigEsp.getValueAt(y8, 0).toString()) + "';";
                    try {
                        ResultSet xrs5 = this.xconsultasbd.traerRs(sqlsignos);
                        if (xrs5.next() && (xrs5.getString(1) != null || !xrs5.getString(1).isEmpty())) {
                            signos = true;
                        }
                        xrs5.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e4) {
                    }
                    if (signos) {
                        String sql12 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloSigEsp.getValueAt(y8, 0) + "',Valor = '" + this.xmodeloSigEsp.getValueAt(y8, 3) + "', Observacion = '" + this.xmodeloSigEsp.getValueAt(y8, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloSigEsp.getValueAt(y8, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 5 -> " + sql12);
                        this.xconsultasbd.ejecutarSQL(sql12);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloSigEsp.getValueAt(y8, 2).toString()).booleanValue()) {
                        String sql13 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloSigEsp.getValueAt(y8, 0) + "','" + this.xmodeloSigEsp.getValueAt(y8, 3) + "','" + this.xmodeloSigEsp.getValueAt(y8, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql13);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en signos especiales -> " + sql13);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y9 = 0; y9 < this.JTMovArticular.getRowCount(); y9++) {
                    String sql14 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloMovArt.getValueAt(y9, 0) + "',Valor = '" + this.xmodeloMovArt.getValueAt(y9, 3) + "', Observacion = '" + this.xmodeloMovArt.getValueAt(y9, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloMovArt.getValueAt(y9, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 6 -> " + sql14);
                    this.xconsultasbd.ejecutarSQL(sql14);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y10 = 0; y10 < this.JTMovArticular.getRowCount(); y10++) {
                    boolean mov = false;
                    String sqlMov = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloMovArt.getValueAt(y10, 0).toString()) + "';";
                    try {
                        ResultSet xrs6 = this.xconsultasbd.traerRs(sqlMov);
                        if (xrs6.next() && (xrs6.getString(1) != null || !xrs6.getString(1).isEmpty())) {
                            mov = true;
                        }
                        xrs6.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e5) {
                    }
                    if (mov) {
                        String sql15 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloMovArt.getValueAt(y10, 0) + "',Valor = '" + this.xmodeloMovArt.getValueAt(y10, 3) + "', Observacion = '" + this.xmodeloMovArt.getValueAt(y10, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloMovArt.getValueAt(y10, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 6 -> " + sql15);
                        this.xconsultasbd.ejecutarSQL(sql15);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloMovArt.getValueAt(y10, 2).toString()).booleanValue()) {
                        String sql16 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloMovArt.getValueAt(y10, 0) + "','" + this.xmodeloMovArt.getValueAt(y10, 3) + "','" + this.xmodeloMovArt.getValueAt(y10, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql16);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en movilidad articular -> " + sql16);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y11 = 0; y11 < this.JTFuerzaMuscular.getRowCount(); y11++) {
                    String sql17 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloFuerzaMusc.getValueAt(y11, 0) + "',Valor = '" + this.xmodeloFuerzaMusc.getValueAt(y11, 3) + "', Observacion = '" + this.xmodeloFuerzaMusc.getValueAt(y11, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloFuerzaMusc.getValueAt(y11, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 7 -> " + sql17);
                    this.xconsultasbd.ejecutarSQL(sql17);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y12 = 0; y12 < this.JTFuerzaMuscular.getRowCount(); y12++) {
                    boolean fuer = false;
                    String sqlFuer = "SELECT Id_Atencion\nFROM h_so_examen_osteo_detalle\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloFuerzaMusc.getValueAt(y12, 0).toString()) + "';";
                    try {
                        ResultSet xrs7 = this.xconsultasbd.traerRs(sqlFuer);
                        if (xrs7.next() && (xrs7.getString(1) != null || !xrs7.getString(1).isEmpty())) {
                            fuer = true;
                        }
                        xrs7.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e6) {
                    }
                    if (fuer) {
                        String sql18 = "UPDATE h_so_examen_osteo_detalle SET Id_Segmentos='" + this.xmodeloFuerzaMusc.getValueAt(y12, 0) + "',Valor = '" + this.xmodeloFuerzaMusc.getValueAt(y12, 3) + "', Observacion = '" + this.xmodeloFuerzaMusc.getValueAt(y12, 4) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmentos = '" + Integer.parseInt(this.xmodeloFuerzaMusc.getValueAt(y12, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 7 -> " + sql18);
                        this.xconsultasbd.ejecutarSQL(sql18);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloFuerzaMusc.getValueAt(y12, 2).toString()).booleanValue()) {
                        String sql19 = "insert into h_so_examen_osteo_detalle(`Id_ExamenOsteo` , `Id_Segmentos`, `Valor`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodeloFuerzaMusc.getValueAt(y12, 0) + "','" + this.xmodeloFuerzaMusc.getValueAt(y12, 3) + "','" + this.xmodeloFuerzaMusc.getValueAt(y12, 4) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql19);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en fuerza muscular -> " + sql19);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y13 = 0; y13 < this.JTNivelSeveridad.getRowCount(); y13++) {
                    String sql20 = "UPDATE h_so_exa_osteo_niv_severidad SET Id_Segmento='" + this.xmodelonseveridad.getValueAt(y13, 0) + "',Valor = '" + this.xmodelonseveridad.getValueAt(y13, 2) + "', Calificacion = '" + this.xmodelonseveridad.getValueAt(y13, 3) + "' WHERE Id_Segmento = '" + Integer.parseInt(this.xmodelonseveridad.getValueAt(y13, 0).toString()) + "' AND Id_ExamenOsteo = '" + this.xid + "'  AND Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "';";
                    System.out.println("actualizar actualizar 8 -> " + sql20);
                    this.xconsultasbd.ejecutarSQL(sql20);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y14 = 0; y14 < this.JTNivelSeveridad.getRowCount(); y14++) {
                    boolean sever = false;
                    String sqlSever = "SELECT Id_Atencion FROM h_so_exa_osteo_niv_severidad WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_ExamenOsteo = '" + this.xid + "' AND Id_Segmento = '" + Integer.parseInt(this.xmodelonseveridad.getValueAt(y14, 0).toString()) + "';";
                    try {
                        ResultSet xrs8 = this.xconsultasbd.traerRs(sqlSever);
                        if (xrs8.next() && (xrs8.getString(1) != null || !xrs8.getString(1).isEmpty())) {
                            sever = true;
                        }
                        xrs8.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e7) {
                    }
                    if (sever) {
                        String sql21 = "UPDATE h_so_exa_osteo_niv_severidad SET Id_Segmento='" + Integer.parseInt(this.xmodelonseveridad.getValueAt(y14, 0).toString()) + "',Valor = '" + this.xmodelonseveridad.getValueAt(y14, 2).toString() + "', Calificacion = '" + this.xmodelonseveridad.getValueAt(y14, 3).toString() + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Segmento = '" + Integer.parseInt(this.xmodelonseveridad.getValueAt(y14, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 8 -> " + sql21);
                        this.xconsultasbd.ejecutarSQL(sql21);
                        this.xconsultasbd.cerrarConexionBd();
                    } else {
                        String sql22 = "insert into h_so_exa_osteo_niv_severidad(`Id_ExamenOsteo`, `Id_Segmento`, `Valor`, `Calificacion`,Id_Atencion ) values ('" + this.xid + "','" + this.xmodelonseveridad.getValueAt(y14, 0) + "','" + this.xmodelonseveridad.getValueAt(y14, 2) + "','" + this.xmodelonseveridad.getValueAt(y14, 3) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql22);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en nivel de severidad ->  " + sql22);
                    }
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && !Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                for (int y15 = 0; y15 < this.JTRecomendaciones.getRowCount(); y15++) {
                    String sql23 = "UPDATE h_so_exa_osteo_recomendacion SET Id_Recomendacion='" + this.xmodelorecomendacion.getValueAt(y15, 0) + "', Observacion = '" + this.xmodelorecomendacion.getValueAt(y15, 3) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Recomendacion = '" + Integer.parseInt(this.xmodelorecomendacion.getValueAt(y15, 0).toString()) + "';";
                    System.out.println("actualizar actualizar 9 -> " + sql23);
                    this.xconsultasbd.ejecutarSQL(sql23);
                    this.xconsultasbd.cerrarConexionBd();
                }
            } else {
                for (int y16 = 0; y16 < this.JTRecomendaciones.getRowCount(); y16++) {
                    boolean rec = false;
                    String sqlRec = "SELECT Id_Atencion \nFROM h_so_exa_osteo_recomendacion\nWHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'\n  AND Id_ExamenOsteo = '" + this.xid + "'\n  AND Id_Recomendacion = '" + Integer.parseInt(this.xmodelorecomendacion.getValueAt(y16, 0).toString()) + "';";
                    try {
                        System.out.println("recomendacioin -> " + sqlRec);
                        ResultSet xrs9 = this.xconsultasbd.traerRs(sqlRec);
                        if (xrs9.next() && (xrs9.getString(1) != null || !xrs9.getString(1).isEmpty())) {
                            rec = true;
                        }
                        xrs9.close();
                        this.xconsultasbd.cerrarConexionBd();
                    } catch (Exception e8) {
                    }
                    if (rec) {
                        String sql24 = "UPDATE h_so_exa_osteo_recomendacion SET Id_Recomendacion='" + this.xmodelorecomendacion.getValueAt(y16, 0) + "', Observacion = '" + this.xmodelorecomendacion.getValueAt(y16, 3) + "' WHERE Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Id_ExamenOsteo = '" + this.xid + "' and Id_Recomendacion = '" + Integer.parseInt(this.xmodelorecomendacion.getValueAt(y16, 0).toString()) + "';";
                        System.out.println("actualizar actualizar 9 -> " + sql24);
                        this.xconsultasbd.ejecutarSQL(sql24);
                        this.xconsultasbd.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodelorecomendacion.getValueAt(y16, 2).toString()).booleanValue()) {
                        String sql25 = "insert into h_so_exa_osteo_recomendacion (`Id_ExamenOsteo` , `Id_Recomendacion`, `Observacion`,Id_Atencion) values ('" + this.xid + "','" + this.xmodelorecomendacion.getValueAt(y16, 0) + "','" + this.xmodelorecomendacion.getValueAt(y16, 3) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                        this.xconsultasbd.ejecutarSQL(sql25);
                        this.xconsultasbd.cerrarConexionBd();
                        System.out.println("inserta en recomendaciones -> " + sql25);
                    }
                }
            }
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mCargarDatosTablaHistorico();
            this.JBGrabarExamen.setEnabled(false);
        }
    }

    private void mTraerDatosBD() {
        try {
            String sql = "SELECT  `LongitudMMII` , `RIzquierda` , `RDerecha`  , `RCalificacion` , `RMiembCorto`, `AIzquierda` , `ADerecha` , `ACalificacion` , `AMiembCorto`, `MiembCortoF`, `DolorOMA`, `SegmentoInteres`, `TipoDolor`, `Intensidad` , `FactorExac` , `FactorDism` , `HallazgoSignos` , `HallazgoMov` , `HallazgoFuerza`  , `VACabeza`, `VAHombro`  , `VAColumna` , `VAPelvis` , `VARodillas` , `VAPies`  , `VLCuello`  , `VLDorso` , `VLTronco`, `VLAbdomen` , `VLLumbar`  , `Sumatoria`  , `CalAlineacionRiesgo` , `DescripcionCal` , `FlexValor` , `FlexPercentil`, `FlexCategoria`  , `FAbdValor` , `FAbdPercentil` , `FAbdCategoria` , `FBrazValor` , `FBrazPercentil` , `FBrazCategoria`, `CalSeveridad` , `HallazgoOMA` , `Hallazgo` , `Potencial` , `Interpretacion`, Resultado, Lateralidad, Talla, Peso, IMC  FROM `h_so_examen_osteomuscular` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `Id_Atencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1) ";
            System.out.println("Consulta que trae los datos varios - " + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.first();
                if (rs1.getLong(1) == 1) {
                    this.JCHAplica.setSelected(false);
                } else {
                    this.JCHAplica.setSelected(true);
                }
                this.JTFFRIzquierda.setValue(Double.valueOf(rs1.getDouble(2)));
                this.JTFFRDerecha.setValue(Double.valueOf(rs1.getDouble(3)));
                this.JCBCalReal.setSelectedItem(rs1.getString(4));
                this.JCBMMCortoR.setSelectedItem(rs1.getString(5));
                this.JTFFAIzquierda.setValue(Double.valueOf(rs1.getDouble(6)));
                this.JTFFADerecha.setValue(Double.valueOf(rs1.getDouble(7)));
                this.JCBCalAparente.setSelectedItem(rs1.getString(8));
                this.JCBMMCortoA.setSelectedItem(rs1.getString(9));
                this.JCBMMCortoFinal.setSelectedItem(rs1.getString(10));
                if (rs1.getLong(11) == 1) {
                    this.JRBSI_OMA.setSelected(true);
                } else {
                    this.JRBNO_OMA.setSelected(true);
                }
                this.JCBSegInteres.setSelectedItem(rs1.getString(12));
                this.JCBTipoDolor.setSelectedItem(rs1.getString(13));
                this.JCBIntensidad.setSelectedItem(rs1.getString(14));
                this.JTFFactoresExa.setText(rs1.getString(15));
                this.JTFFactoresDism.setText(rs1.getString(16));
                this.JCBHallazgosSigEsp.setSelectedItem(rs1.getString(17));
                this.JCBHallazgosMovArt.setSelectedItem(rs1.getString(18));
                this.JCBFuerzaMuscular.setSelectedItem(rs1.getString(19));
                if (rs1.getLong(20) == 1) {
                    this.JRBCabAlineada.setSelected(true);
                } else if (rs1.getLong(20) == 2) {
                    this.JRBCabIncliLeve.setSelected(true);
                } else {
                    this.JRBCabIncliRotada.setSelected(true);
                }
                if (rs1.getLong(21) == 1) {
                    this.JRBHomAlineados.setSelected(true);
                } else if (rs1.getLong(21) == 2) {
                    this.JRBHomLevDescendido.setSelected(true);
                } else {
                    this.JRBHomMarDescenso.setSelected(true);
                }
                if (rs1.getLong(22) == 1) {
                    this.JRBColAlineada.setSelected(true);
                } else if (rs1.getLong(22) == 2) {
                    this.JRBColEscoliosis.setSelected(true);
                } else {
                    this.JRBColCurvaLateral.setSelected(true);
                }
                if (rs1.getLong(23) == 1) {
                    this.JRBPelvIliacas.setSelected(true);
                } else if (rs1.getLong(23) == 2) {
                    this.JRBPelvHemipelvis.setSelected(true);
                } else {
                    this.JRBPelvMarcado.setSelected(true);
                }
                if (rs1.getLong(24) == 1) {
                    this.JRBRodAlineadas.setSelected(true);
                } else if (rs1.getLong(24) == 2) {
                    this.JRBRodValgo.setSelected(true);
                } else {
                    this.JRBRodVaro.setSelected(true);
                }
                if (rs1.getLong(25) == 1) {
                    this.JRBPieAlineado.setSelected(true);
                } else if (rs1.getLong(25) == 2) {
                    this.JRBPiePlano.setSelected(true);
                } else {
                    this.JRBPieCavo.setSelected(true);
                }
                if (rs1.getLong(26) == 1) {
                    this.JRBCuelloAlineado.setSelected(true);
                } else if (rs1.getLong(26) == 2) {
                    this.JRBCuelloLevAumento.setSelected(true);
                } else {
                    this.JRBCuelloRecti.setSelected(true);
                }
                if (rs1.getLong(27) == 1) {
                    this.JRBDorsoNormal.setSelected(true);
                } else if (rs1.getLong(27) == 2) {
                    this.JRBDorsoAumento.setSelected(true);
                } else {
                    this.JRBDorsoProtuidos.setSelected(true);
                }
                if (rs1.getLong(28) == 1) {
                    this.JRBTroncoAlineado.setSelected(true);
                } else if (rs1.getLong(28) == 2) {
                    this.JRBTroncoLeve.setSelected(true);
                } else {
                    this.JRBTroncoInclinacion.setSelected(true);
                }
                if (rs1.getLong(29) == 1) {
                    this.JRBAbdomenNormal.setSelected(true);
                } else if (rs1.getLong(29) == 2) {
                    this.JRBAbdomenProtuido.setSelected(true);
                } else {
                    this.JRBAbdomenDesc.setSelected(true);
                }
                if (rs1.getLong(30) == 1) {
                    this.JRBLumbarNormal.setSelected(true);
                } else if (rs1.getLong(30) == 2) {
                    this.JRBLumbarAumento.setSelected(true);
                } else {
                    this.JRBLumbarHiper.setSelected(true);
                }
                this.JTFFSumatoria.setValue(Integer.valueOf(rs1.getInt(31)));
                this.JLCalificacion.setText(rs1.getString(32));
                this.JTFDescripcion.setText(rs1.getString(33));
                this.JTFFVFlexibilidad.setValue(Double.valueOf(rs1.getDouble(34)));
                this.JTFFPFlexibilidad.setValue(Double.valueOf(rs1.getDouble(35)));
                this.JLCatFlexibilidad.setText(rs1.getString(36));
                this.JTFFVFuAbdominal.setValue(Double.valueOf(rs1.getDouble(37)));
                this.JTFFPFuAbdominal.setValue(Double.valueOf(rs1.getDouble(38)));
                this.JLCatFueAbdominal.setText(rs1.getString(39));
                this.JTFFVFuBrazos.setValue(Double.valueOf(rs1.getDouble(40)));
                this.JTFFPFuBrazos.setValue(Double.valueOf(rs1.getDouble(41)));
                this.JLCatFueBrazos.setText(rs1.getString(42));
                this.JCBCalSeveridad.setSelectedItem(rs1.getString(43));
                this.JTAHallazgo.setText(rs1.getString(44));
                this.JCBHallazgosOMA.setSelectedItem(rs1.getString(45));
                if (rs1.getLong(46) == 1) {
                    this.JCHBPotencial.setSelected(true);
                } else {
                    this.JCHBPotencial.setSelected(false);
                }
                this.JTAInterpretacion.setText(rs1.getString(47));
                this.JCBResultado.setSelectedItem(rs1.getString(48));
                if (rs1.getLong(49) == 0) {
                    this.JRBNoaplica.setSelected(true);
                } else if (rs1.getLong(49) == 1) {
                    this.JRBDerecho.setSelected(true);
                } else {
                    this.JRBIzquierdo.setSelected(true);
                }
                this.JTFFSTalla.setValue(Double.valueOf(rs1.getDouble(50)));
                this.JTFFSPeso.setValue(Double.valueOf(rs1.getDouble(51)));
                this.JTFFSIMC.setValue(Double.valueOf(rs1.getDouble(52)));
            }
            rs1.close();
            xct1.cerrarConexionBd();
            mCalcularSumatoriasVLateral();
            mCalcularSumatoriasVPosterior();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mAnular() {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.sql = "update h_so_examen_osteomuscular set Estado=0 where Id='" + this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3) + "'";
                this.xconsultasbd.ejecutarSQL(this.sql);
                this.xconsultasbd.cerrarConexionBd();
                mVerificarExistenciaExamen();
                mCargarDatosTablaHistorico();
                mBuscarAnteOMA();
                mBuscarDiagActivo();
                mBuscarEvaDolor();
                mBuscarSigEsp();
                mBuscarMovArt();
                mBuscarFuerzaMusc();
                mBuscarRecomendacion();
                mBuscarNSeveridad();
                mLlenarCombos();
                mTraerDatosBD();
            }
        }
    }

    private void mVerificarExistenciaExamen() {
        try {
            String sql = "SELECT `Id_Atencion`, Guardado FROM `h_so_examen_osteomuscular` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_so_examen_osteomuscular.Estado=1)";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.first();
                this.xexistencia = rs1.getString(1);
                this.xguardado = rs1.getLong(2);
            }
            if (this.xexistencia.equals(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())) {
                this.JBGrabarExamen.setEnabled(false);
            } else {
                this.JBGrabarExamen.setEnabled(true);
            }
            if (this.xguardado == 1) {
                if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    this.JBGuardar.setEnabled(false);
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                this.JBGuardar.setEnabled(true);
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Osteomuscular.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "Id"}) { // from class: Historia.JPSo_Osteomuscular.76
            Class[] types = {String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_so_examen_osteomuscular`.`Id_Atencion`  , `h_so_examen_osteomuscular`.`FechaE`   , `profesional1`.`NProfesional`, `h_so_examen_osteomuscular`.Id  FROM `h_so_examen_osteomuscular` INNER JOIN `profesional1` ON (`h_so_examen_osteomuscular`.`IdUsuarioOMA` = `profesional1`.`Id_Persona`) AND (`h_so_examen_osteomuscular`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`h_so_examen_osteomuscular`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND  h_so_examen_osteomuscular.Estado=1)";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloh.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void calcularImc() {
        if (((Double) this.JTFFSTalla.getValue()).doubleValue() != 0.0d) {
            this.JTFFSIMC.setValue(Double.valueOf(((Double) this.JTFFSPeso.getValue()).doubleValue() / Math.pow(((Double) this.JTFFSTalla.getValue()).doubleValue() / 100.0d, 2.0d)));
            this.imc = ((Double) this.JTFFSPeso.getValue()).doubleValue() / Math.pow(((Double) this.JTFFSTalla.getValue()).doubleValue() / 100.0d, 2.0d);
        }
    }

    private void verificarVariablesGraficas() {
        if (this.JRBCabAlineada.isSelected()) {
            this.xcabeza = 1;
        } else if (this.JRBCabIncliLeve.isSelected()) {
            this.xcabeza = 2;
        } else if (this.JRBCabIncliRotada.isSelected()) {
            this.xcabeza = 3;
        }
        if (this.JRBHomAlineados.isSelected()) {
            this.xhombro = 1;
        } else if (this.JRBHomLevDescendido.isSelected()) {
            this.xhombro = 2;
        } else if (this.JRBHomMarDescenso.isSelected()) {
            this.xhombro = 3;
        }
        if (this.JRBColAlineada.isSelected()) {
            this.xcolumna = 1;
        } else if (this.JRBColEscoliosis.isSelected()) {
            this.xcolumna = 2;
        } else if (this.JRBColCurvaLateral.isSelected()) {
            this.xcolumna = 3;
        }
        if (this.JRBPelvIliacas.isSelected()) {
            this.xpelvis = 1;
        } else if (this.JRBPelvHemipelvis.isSelected()) {
            this.xpelvis = 2;
        } else if (this.JRBPelvMarcado.isSelected()) {
            this.xpelvis = 3;
        }
        if (this.JRBRodAlineadas.isSelected()) {
            this.xrodilla = 1;
        } else if (this.JRBRodValgo.isSelected()) {
            this.xrodilla = 2;
        } else if (this.JRBRodVaro.isSelected()) {
            this.xrodilla = 3;
        }
        if (this.JRBPieAlineado.isSelected()) {
            this.xpies = 1;
        } else if (this.JRBPiePlano.isSelected()) {
            this.xpies = 2;
        } else if (this.JRBPieCavo.isSelected()) {
            this.xpies = 3;
        }
        if (this.JRBCuelloAlineado.isSelected()) {
            this.xcuello = 1;
        } else if (this.JRBCuelloLevAumento.isSelected()) {
            this.xcuello = 2;
        } else if (this.JRBCuelloRecti.isSelected()) {
            this.xcuello = 3;
        }
        if (this.JRBDorsoNormal.isSelected()) {
            this.xdorso = 1;
        } else if (this.JRBDorsoAumento.isSelected()) {
            this.xdorso = 2;
        } else if (this.JRBDorsoProtuidos.isSelected()) {
            this.xdorso = 3;
        }
        if (this.JRBTroncoAlineado.isSelected()) {
            this.xtronco = 1;
        } else if (this.JRBTroncoLeve.isSelected()) {
            this.xtronco = 2;
        } else if (this.JRBTroncoInclinacion.isSelected()) {
            this.xtronco = 3;
        }
        if (this.JRBAbdomenNormal.isSelected()) {
            this.xabdomen = 1;
        } else if (this.JRBAbdomenProtuido.isSelected()) {
            this.xabdomen = 2;
        } else if (this.JRBAbdomenDesc.isSelected()) {
            this.xabdomen = 3;
        }
        if (this.JRBLumbarNormal.isSelected()) {
            this.xlumbar = 1;
        } else if (this.JRBLumbarAumento.isSelected()) {
            this.xlumbar = 2;
        } else if (this.JRBLumbarHiper.isSelected()) {
            this.xlumbar = 3;
        }
    }
}
