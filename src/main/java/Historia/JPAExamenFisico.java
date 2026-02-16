package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAExamenFisico.class */
public class JPAExamenFisico extends JPanel {
    private clasesHistoriaCE xclase;
    private String xsql;
    private String[] xidriesgo;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private int xEdadActual;
    public JTextFieldValidator IRC;
    private ButtonGroup JBGControlDM;
    private ButtonGroup JBGControlado;
    private ButtonGroup JBGEmbarazo;
    private JButton JBGrafico;
    private JButton JBTGuardar;
    private JButton JBT_DatosTraige;
    private JComboBox JCBCRiesgo;
    private JCheckBox JCHCalcular;
    private JCheckBox JCHCobntrolado;
    private JCheckBox JCHCobntrolado1;
    private JCheckBox JCHExcepcion;
    private JCheckBox JCH_Autoexamenseno;
    private JLabel JLBBAcostado;
    private JLabel JLBBPie;
    private JLabel JLBCCicloErg;
    private JLabel JLBCFlexibilidad;
    private JLabel JLBCITB;
    private JLabel JLBCImc;
    private JLabel JLBCObecidad;
    private JLabel JLBCPAbdominal;
    private JLabel JLBCPGrasa;
    private JLabel JLBIRC;
    private JLabel JLBPAcostado;
    private JLabel JLBPBSentado;
    private JLabel JLBPPie;
    private JLabel JLBPSentado;
    private JLabel JLBPSentado1;
    private JLabel JLGrafico;
    private JLabel JLMeta;
    private JLabel JLPeso;
    private JFormattedTextField JLResultado;
    private JFormattedTextField JLResultadoFreMax;
    private JPanel JPICDiabetes;
    private JPanel JPICEmbarazo;
    private JPanel JPIDPyPDiabetes;
    private JPanel JPIDatosPyp;
    private JPanel JPIExamenFisico;
    private JPanel JPIOtros;
    private JPanel JPIPresion;
    private JPanel JPIndiceTobilloBrazo;
    private JPanel JPSignosVitales;
    private JRadioButton JRBNO;
    private JRadioButton JRBSi;
    private JScrollPane JSPEFObservaciones;
    private JScrollPane JSPHistoricoD;
    private JFormattedTextField JTFFCalculoITB;
    private JSpinner JTFFEEsfuerzo;
    public JTextFieldValidator JTFFFlexibilidad;
    private JFormattedTextField JTFFPAcostadoD;
    private JFormattedTextField JTFFPAcostadoS;
    private JFormattedTextField JTFFPPieD;
    private JFormattedTextField JTFFPPieS;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    private JFormattedTextField JTFFPSentadoTS;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    private JSpinner JTFFSPCefalico;
    public JTextFieldValidator JTFFSPGrasa;
    private JSpinner JTFFSPIdeal;
    private JSpinner JTFFSPerimetroAbd;
    private JSpinner JTFFSPerimetroBranquial;
    private JSpinner JTFFSPerimetroPantorrilla;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    public JTextFieldValidator JTFFV02;
    private JFormattedTextField JTFFVHm;
    public JTextFieldValidator JTFrecMax;
    public JTextFieldValidator JTFrecMaxAl;
    private JTable JTHistoricoD;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosPyp;
    private JTextPane JTPEFObservaciones;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmetodo = new Metodos();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private int xcontrolado = 0;
    private int xcontroldm = 0;
    private double imc = 0.0d;
    private String xidexamenf = "0";
    private String autoexamenseno = "NO";
    private long xembarazo = 0;

    public JPAExamenFisico(clasesHistoriaCE xclase) {
        initComponents();
        SpinnerNumberModel mn = new SpinnerNumberModel();
        mn.setMaximum(100);
        mn.setMinimum(0);
        this.xclase = xclase;
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("341")) {
            this.xidriesgo = this.xconsultasbd.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =1) ORDER BY `Nbre` ASC", this.xidriesgo, this.JCBCRiesgo);
            if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                this.JCBCRiesgo.setSelectedIndex(-1);
            } else {
                this.JCBCRiesgo.setSelectedItem("SIN DETERMINAR");
            }
            this.xconsultasbd.cerrarConexionBd();
        } else if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("382") || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("387")) {
            this.xidriesgo = this.xconsultasbd.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =2) ORDER BY `Nbre` ASC", this.xidriesgo, this.JCBCRiesgo);
            if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                this.JCBCRiesgo.setSelectedIndex(-1);
            } else {
                this.JCBCRiesgo.setSelectedItem("SIN DETERMINAR");
            }
            this.xconsultasbd.cerrarConexionBd();
        } else {
            this.xidriesgo = this.xconsultasbd.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =0) ORDER BY `Nbre` ASC", this.xidriesgo, this.JCBCRiesgo);
            if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                this.JCBCRiesgo.setSelectedIndex(-1);
            } else {
                this.JCBCRiesgo.setSelectedItem("NO APLICA");
            }
            this.xconsultasbd.cerrarConexionBd();
        }
        if (!Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
            this.JCHExcepcion.setVisible(false);
        }
        String sql = "SELECT  Edad FROM `persona` WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
        ResultSet xrs = this.xconsultasbd.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xEdadActual = xrs.getInt("Edad");
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        mBuscarDatosBd();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo().equals("M")) {
            this.JPICEmbarazo.setEnabled(false);
            this.JRBNO.setEnabled(false);
            this.JRBSi.setEnabled(false);
        } else {
            this.JPICEmbarazo.setEnabled(true);
            this.JRBNO.setEnabled(true);
            this.JRBSi.setEnabled(true);
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue() == 1 || clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue() == 2) {
            this.JPIndiceTobilloBrazo.setVisible(true);
        } else {
            this.JPIndiceTobilloBrazo.setVisible(false);
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() != 3) {
            this.JBT_DatosTraige.setVisible(false);
        }
        if ((Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") && Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue() == 444893) || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.JTFFPs2.setEnabled(false);
            this.JTFFPs2.setVisible(false);
        }
        mBuscarresultado();
        mBuscarMeta();
    }

    /* JADX WARN: Type inference failed for: r3v343, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGControlado = new ButtonGroup();
        this.JBGControlDM = new ButtonGroup();
        this.JBGEmbarazo = new ButtonGroup();
        this.JPIExamenFisico = new JPanel();
        this.JTPDatos = new JTabbedPane();
        this.JPSignosVitales = new JPanel();
        this.JTFFSPerimetroAbd = new JSpinner();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JTFFPPieS = new JFormattedTextField();
        this.JTFFPPieD = new JFormattedTextField();
        this.JTFFPAcostadoS = new JFormattedTextField();
        this.JTFFPAcostadoD = new JFormattedTextField();
        this.JLBPSentado = new JLabel();
        this.JLBPBSentado = new JLabel();
        this.JLBBPie = new JLabel();
        this.JLBPPie = new JLabel();
        this.JLBPAcostado = new JLabel();
        this.JLBBAcostado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JCHCobntrolado = new JCheckBox();
        this.JCHExcepcion = new JCheckBox();
        this.JTFFSPIdeal = new JSpinner();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JSPEFObservaciones = new JScrollPane();
        this.JTPEFObservaciones = new JTextPane();
        this.JBT_DatosTraige = new JButton();
        this.jPanel2 = new JPanel();
        this.JLBCImc = new JLabel();
        this.JLBCObecidad = new JLabel();
        this.JLBCPAbdominal = new JLabel();
        this.JCH_Autoexamenseno = new JCheckBox();
        this.JTFFSPerimetroPantorrilla = new JSpinner();
        this.JTFFSPerimetroBranquial = new JSpinner();
        this.JPIOtros = new JPanel();
        this.JTFFSPCefalico = new JSpinner();
        this.JPICEmbarazo = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNO = new JRadioButton();
        this.JCBCRiesgo = new JComboBox();
        this.JLBCPGrasa = new JLabel();
        this.JTFFEEsfuerzo = new JSpinner();
        this.JLBCFlexibilidad = new JLabel();
        this.JTFFSPGrasa = new JTextFieldValidator();
        this.JTFFFlexibilidad = new JTextFieldValidator();
        this.jPanel1 = new JPanel();
        this.JTFFV02 = new JTextFieldValidator();
        this.JLBCCicloErg = new JLabel();
        this.jLabel1 = new JLabel();
        this.JLPeso = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JLResultado = new JFormattedTextField();
        this.JTFrecMax = new JTextFieldValidator();
        this.JTFrecMaxAl = new JTextFieldValidator();
        this.JLResultadoFreMax = new JFormattedTextField();
        this.JCHCalcular = new JCheckBox();
        this.JLBIRC = new JLabel();
        this.IRC = new JTextFieldValidator();
        this.JPIndiceTobilloBrazo = new JPanel();
        this.JTFFPSentadoTS = new JFormattedTextField();
        this.JLBCITB = new JLabel();
        this.JTFFCalculoITB = new JFormattedTextField();
        this.JPIDatosPyp = new JPanel();
        this.JTPDatosPyp = new JTabbedPane();
        this.JPIDPyPDiabetes = new JPanel();
        this.JPICDiabetes = new JPanel();
        this.JTFFVHm = new JFormattedTextField();
        this.JCHCobntrolado1 = new JCheckBox();
        this.JLMeta = new JLabel();
        this.JSPHistoricoD = new JScrollPane();
        this.JTHistoricoD = new JTable();
        this.JBGrafico = new JButton();
        this.JLGrafico = new JLabel();
        this.JBTGuardar = new JButton();
        setMaximumSize(null);
        setName("jpaexamenfisico");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAExamenFisico.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAExamenFisico.this.formAncestorRemoved(evt);
            }
        });
        addMouseListener(new MouseAdapter() { // from class: Historia.JPAExamenFisico.2
            public void mouseExited(MouseEvent evt) {
                JPAExamenFisico.this.formMouseExited(evt);
            }
        });
        this.JPIExamenFisico.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN FÍSICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFSPerimetroAbd.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd.setModel(new SpinnerNumberModel(0.0d, 0.0d, 250.0d, 1.0d));
        this.JTFFSPerimetroAbd.setBorder(BorderFactory.createTitledBorder((Border) null, "Circunferencia cintura", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSPerimetroAbd.addChangeListener(new ChangeListener() { // from class: Historia.JPAExamenFisico.3
            public void stateChanged(ChangeEvent evt) {
                JPAExamenFisico.this.JTFFSPerimetroAbdStateChanged(evt);
            }
        });
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.4
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.5
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoS, new AbsoluteConstraints(8, 49, 45, 25));
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.6
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.7
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoD, new AbsoluteConstraints(66, 49, 45, 25));
        this.JTFFPPieS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPPieS.setHorizontalAlignment(4);
        this.JTFFPPieS.setFont(new Font("Arial", 1, 12));
        this.JTFFPPieS.setName("fechanaciemiento");
        this.JTFFPPieS.setValue(new Integer(0));
        this.JTFFPPieS.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.8
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPPieSActionPerformed(evt);
            }
        });
        this.JTFFPPieS.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.9
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPPieSFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPPieS, new AbsoluteConstraints(117, 49, 45, 25));
        this.JTFFPPieD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPPieD.setHorizontalAlignment(4);
        this.JTFFPPieD.setFont(new Font("Arial", 1, 12));
        this.JTFFPPieD.setName("fechanaciemiento");
        this.JTFFPPieD.setValue(new Integer(0));
        this.JTFFPPieD.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.10
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPPieDActionPerformed(evt);
            }
        });
        this.JTFFPPieD.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.11
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPPieDFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPPieD, new AbsoluteConstraints(178, 49, 45, 25));
        this.JTFFPAcostadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPAcostadoS.setHorizontalAlignment(4);
        this.JTFFPAcostadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPAcostadoS.setName("fechanaciemiento");
        this.JTFFPAcostadoS.setValue(new Integer(0));
        this.JTFFPAcostadoS.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.12
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPAcostadoSActionPerformed(evt);
            }
        });
        this.JTFFPAcostadoS.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.13
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPAcostadoSFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPAcostadoS, new AbsoluteConstraints(233, 49, 45, 25));
        this.JTFFPAcostadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPAcostadoD.setHorizontalAlignment(4);
        this.JTFFPAcostadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPAcostadoD.setName("fechanaciemiento");
        this.JTFFPAcostadoD.setValue(new Integer(0));
        this.JTFFPAcostadoD.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.14
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPAcostadoDActionPerformed(evt);
            }
        });
        this.JTFFPAcostadoD.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.15
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPAcostadoDFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPAcostadoD, new AbsoluteConstraints(294, 49, 45, 25));
        this.JLBPSentado.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado.setForeground(Color.blue);
        this.JLBPSentado.setHorizontalAlignment(0);
        this.JLBPSentado.setText("Sentado");
        this.JPIPresion.add(this.JLBPSentado, new AbsoluteConstraints(10, 20, 103, -1));
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JPIPresion.add(this.JLBPBSentado, new AbsoluteConstraints(57, 49, -1, 23));
        this.JLBBPie.setFont(new Font("Arial", 1, 18));
        this.JLBBPie.setForeground(Color.blue);
        this.JLBBPie.setHorizontalAlignment(0);
        this.JLBBPie.setText("/");
        this.JPIPresion.add(this.JLBBPie, new AbsoluteConstraints(166, 49, 8, 23));
        this.JLBPPie.setFont(new Font("Arial", 1, 12));
        this.JLBPPie.setForeground(Color.blue);
        this.JLBPPie.setHorizontalAlignment(0);
        this.JLBPPie.setText("Pie");
        this.JPIPresion.add(this.JLBPPie, new AbsoluteConstraints(117, 23, 106, -1));
        this.JLBPAcostado.setFont(new Font("Arial", 1, 12));
        this.JLBPAcostado.setForeground(Color.blue);
        this.JLBPAcostado.setHorizontalAlignment(0);
        this.JLBPAcostado.setText("Acostado");
        this.JPIPresion.add(this.JLBPAcostado, new AbsoluteConstraints(233, 23, 106, -1));
        this.JLBBAcostado.setFont(new Font("Arial", 1, 18));
        this.JLBBAcostado.setForeground(Color.blue);
        this.JLBBAcostado.setHorizontalAlignment(0);
        this.JLBBAcostado.setText("/");
        this.JPIPresion.add(this.JLBBAcostado, new AbsoluteConstraints(282, 49, 8, 23));
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        this.JPIPresion.add(this.JLBPSentado1, new AbsoluteConstraints(8, 80, 331, -1));
        this.JCHCobntrolado.setFont(new Font("Arial", 1, 12));
        this.JCHCobntrolado.setSelected(true);
        this.JCHCobntrolado.setText("Controlado?");
        this.JCHCobntrolado.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.16
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JCHCobntroladoActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JCHCobntrolado, new AbsoluteConstraints(10, 100, -1, -1));
        this.JCHExcepcion.setFont(new Font("Arial", 1, 12));
        this.JCHExcepcion.setText("Caso Especial?");
        this.JCHExcepcion.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.17
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JCHExcepcionActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JCHExcepcion, new AbsoluteConstraints(110, 100, -1, -1));
        this.JTFFSPIdeal.setFont(new Font("Arial", 1, 12));
        this.JTFFSPIdeal.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JTFFSPIdeal.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso Ideal", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.18
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.19
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.20
            public void keyPressed(KeyEvent evt) {
                JPAExamenFisico.this.JTFFSFcKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFSFcKeyTyped(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.21
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFSFr.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.22
            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFSFrKeyTyped(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.23
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.24
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.25
            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFTemperaturaKeyTyped(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.26
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.27
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.28
            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFPs2KeyTyped(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.29
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.30
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.31
            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFSPesoKeyTyped(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.32
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.33
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addHierarchyListener(new HierarchyListener() { // from class: Historia.JPAExamenFisico.34
            public void hierarchyChanged(HierarchyEvent evt) {
                JPAExamenFisico.this.JTFFSTallaHierarchyChanged(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.35
            public void keyTyped(KeyEvent evt) {
                JPAExamenFisico.this.JTFFSTallaKeyTyped(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setExprecionRegular("^[0-9]{1,5}(\\,[0-9]{0,2})?$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        this.JSPEFObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.36
            public void keyPressed(KeyEvent evt) {
                JPAExamenFisico.this.JTPEFObservacionesKeyPressed(evt);
            }
        });
        this.JSPEFObservaciones.setViewportView(this.JTPEFObservaciones);
        this.JBT_DatosTraige.setFont(new Font("Arial", 1, 12));
        this.JBT_DatosTraige.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_DatosTraige.setText("Traer Datos Triage");
        this.JBT_DatosTraige.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.37
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JBT_DatosTraigeActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación antropométrica", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JLBCImc.setFont(new Font("Arial", 1, 14));
        this.JLBCImc.setForeground(Color.red);
        this.JLBCImc.setHorizontalAlignment(0);
        this.JLBCImc.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo (IMC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBCObecidad.setFont(new Font("Arial", 1, 14));
        this.JLBCObecidad.setForeground(Color.red);
        this.JLBCObecidad.setHorizontalAlignment(0);
        this.JLBCObecidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Obesidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBCPAbdominal.setFont(new Font("Arial", 1, 14));
        this.JLBCPAbdominal.setForeground(new Color(255, 0, 0));
        this.JLBCPAbdominal.setHorizontalAlignment(0);
        this.JLBCPAbdominal.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo (Circunferencia cintura)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBCImc, -2, 179, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBCObecidad, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBCPAbdominal, -1, 283, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBCObecidad, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBCImc, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBCPAbdominal, -2, 50, -2)).addGap(5, 5, 5)));
        this.JCH_Autoexamenseno.setFont(new Font("Arial", 1, 12));
        this.JCH_Autoexamenseno.setForeground(Color.red);
        this.JCH_Autoexamenseno.setText("Se ha realizado autoexamen seno?");
        this.JCH_Autoexamenseno.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.38
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JCH_AutoexamensenoActionPerformed(evt);
            }
        });
        this.JTFFSPerimetroPantorrilla.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroPantorrilla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 250.0d, 1.0d));
        this.JTFFSPerimetroPantorrilla.setBorder(BorderFactory.createTitledBorder((Border) null, "Perimetro Pantorilla", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSPerimetroPantorrilla.addChangeListener(new ChangeListener() { // from class: Historia.JPAExamenFisico.39
            public void stateChanged(ChangeEvent evt) {
                JPAExamenFisico.this.JTFFSPerimetroPantorrillaStateChanged(evt);
            }
        });
        this.JTFFSPerimetroBranquial.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroBranquial.setModel(new SpinnerNumberModel(0.0d, 0.0d, 250.0d, 1.0d));
        this.JTFFSPerimetroBranquial.setBorder(BorderFactory.createTitledBorder((Border) null, "Perimetro Branquial", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSPerimetroBranquial.addChangeListener(new ChangeListener() { // from class: Historia.JPAExamenFisico.40
            public void stateChanged(ChangeEvent evt) {
                JPAExamenFisico.this.JTFFSPerimetroBranquialStateChanged(evt);
            }
        });
        GroupLayout JPSignosVitalesLayout = new GroupLayout(this.JPSignosVitales);
        this.JPSignosVitales.setLayout(JPSignosVitalesLayout);
        JPSignosVitalesLayout.setHorizontalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPEFObservaciones, GroupLayout.Alignment.TRAILING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSFc, -2, 80, -2).addGap(14, 14, 14).addComponent(this.JTFFSFr, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTemperatura, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPs2, -2, 80, -2).addGap(43, 43, 43)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFSPIdeal, -2, 97, -2)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSPerimetroAbd, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_DatosTraige))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPresion, -2, 351, -2).addComponent(this.JCH_Autoexamenseno)).addGap(0, 0, 32767))).addContainerGap()).addGroup(JPSignosVitalesLayout.createSequentialGroup().addContainerGap().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSPerimetroBranquial, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JTFFSPerimetroPantorrilla, -2, 143, -2)).addComponent(this.jPanel2, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPSignosVitalesLayout.setVerticalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPSignosVitalesLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JPIPresion, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Autoexamenseno)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSFc, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2)).addComponent(this.JTFFSIMC, -2, 50, -2).addComponent(this.JTFFSPIdeal, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_DatosTraige, -2, 53, -2).addComponent(this.JTFFSPerimetroAbd, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSPerimetroBranquial, -2, 50, -2).addComponent(this.JTFFSPerimetroPantorrilla, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEFObservaciones, -2, 176, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("SIGNOS VITALES", this.JPSignosVitales);
        this.JTFFSPCefalico.setFont(new Font("Arial", 1, 12));
        this.JTFFSPCefalico.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JTFFSPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Cefálico", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPICEmbarazo.setBorder(BorderFactory.createTitledBorder((Border) null, "REFIERE ESTAR EMBARAZADA", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGEmbarazo.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Sí");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.41
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGEmbarazo.add(this.JRBNO);
        this.JRBNO.setFont(new Font("Arial", 1, 12));
        this.JRBNO.setSelected(true);
        this.JRBNO.setText("No");
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.42
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JRBNOActionPerformed(evt);
            }
        });
        GroupLayout JPICEmbarazoLayout = new GroupLayout(this.JPICEmbarazo);
        this.JPICEmbarazo.setLayout(JPICEmbarazoLayout);
        JPICEmbarazoLayout.setHorizontalGroup(JPICEmbarazoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPICEmbarazoLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JRBSi, -2, 61, -2).addGap(49, 49, 49).addComponent(this.JRBNO).addContainerGap(52, 32767)));
        JPICEmbarazoLayout.setVerticalGroup(JPICEmbarazoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICEmbarazoLayout.createSequentialGroup().addGroup(JPICEmbarazoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNO).addComponent(this.JRBSi)).addGap(0, 0, 32767)));
        this.JCBCRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBCRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo Cardiovascular", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBCPGrasa.setFont(new Font("Arial", 1, 14));
        this.JLBCPGrasa.setForeground(new Color(255, 0, 0));
        this.JLBCPGrasa.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación %Grasa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFEEsfuerzo.setFont(new Font("Arial", 1, 12));
        this.JTFFEEsfuerzo.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JTFFEEsfuerzo.setBorder(BorderFactory.createTitledBorder((Border) null, "E. Esfuerzo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBCFlexibilidad.setFont(new Font("Arial", 1, 14));
        this.JLBCFlexibilidad.setForeground(new Color(255, 0, 0));
        this.JLBCFlexibilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Flexibilidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPGrasa.setBorder(BorderFactory.createTitledBorder((Border) null, "% Grasa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPGrasa.setHorizontalAlignment(0);
        this.JTFFSPGrasa.setText("0");
        this.JTFFSPGrasa.setToolTipText("% Grasa");
        this.JTFFSPGrasa.setExprecionRegular("^[0-9]*$");
        this.JTFFSPGrasa.setFocusAccelerator('C');
        this.JTFFSPGrasa.setFont(new Font("Arial", 1, 12));
        this.JTFFSPGrasa.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.43
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSPGrasaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFSPGrasaFocusLost(evt);
            }
        });
        this.JTFFSPGrasa.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.44
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFSPGrasaActionPerformed(evt);
            }
        });
        this.JTFFFlexibilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Flexibilidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFlexibilidad.setHorizontalAlignment(0);
        this.JTFFFlexibilidad.setText("0");
        this.JTFFFlexibilidad.setToolTipText("Flexibilidad");
        this.JTFFFlexibilidad.setExprecionRegular("^[0-9]*$");
        this.JTFFFlexibilidad.setFocusAccelerator('C');
        this.JTFFFlexibilidad.setFont(new Font("Arial", 1, 12));
        this.JTFFFlexibilidad.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.45
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFFlexibilidadFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFFlexibilidadFocusLost(evt);
            }
        });
        this.JTFFFlexibilidad.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.46
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFFlexibilidadActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "CÁLCULO V02 MAX EN CICLOERGOMETRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFFV02.setBorder(BorderFactory.createTitledBorder((Border) null, "Wmax", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFV02.setHorizontalAlignment(0);
        this.JTFFV02.setText("0");
        this.JTFFV02.setToolTipText("Flexibilidad");
        this.JTFFV02.setExprecionRegular("-?[0.0-9]+");
        this.JTFFV02.setFocusAccelerator('C');
        this.JTFFV02.setFont(new Font("Arial", 1, 12));
        this.JTFFV02.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.47
            public void focusGained(FocusEvent evt) {
                JPAExamenFisico.this.JTFFV02FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFV02FocusLost(evt);
            }
        });
        this.JTFFV02.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.48
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFV02ActionPerformed(evt);
            }
        });
        this.JLBCCicloErg.setFont(new Font("Arial", 1, 14));
        this.JLBCCicloErg.setForeground(new Color(255, 0, 0));
        this.JLBCCicloErg.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación V02 MAX", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setText("11.2  x");
        this.JLPeso.setFont(new Font("Arial", 1, 14));
        this.JLPeso.setHorizontalAlignment(0);
        this.JLPeso.setText("0");
        this.JLPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Kg", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel3.setFont(new Font("Arial", 1, 24));
        this.jLabel3.setText("/");
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setText("+7 =");
        this.JLResultado.setEditable(false);
        this.JLResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLResultado.setForeground(Color.red);
        this.JLResultado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0.##"))));
        this.JLResultado.setHorizontalAlignment(0);
        this.JLResultado.setText("0");
        this.JLResultado.setToolTipText("");
        this.JLResultado.setFont(new Font("Arial", 1, 14));
        this.JTFrecMax.setEditable(false);
        this.JTFrecMax.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec.Max", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFrecMax.setHorizontalAlignment(0);
        this.JTFrecMax.setText("0");
        this.JTFrecMax.setToolTipText("Flexibilidad");
        this.JTFrecMax.setExprecionRegular("-?[0.0-9]+");
        this.JTFrecMax.setFocusAccelerator('C');
        this.JTFrecMax.setFont(new Font("Arial", 1, 12));
        this.JTFrecMaxAl.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Max. Alcanzada", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFrecMaxAl.setHorizontalAlignment(0);
        this.JTFrecMaxAl.setText("0");
        this.JTFrecMaxAl.setToolTipText("Flexibilidad");
        this.JTFrecMaxAl.setExprecionRegular("-?[0.0-9]+");
        this.JTFrecMaxAl.setFocusAccelerator('C');
        this.JTFrecMaxAl.setFont(new Font("Arial", 1, 12));
        this.JLResultadoFreMax.setEditable(false);
        this.JLResultadoFreMax.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado % FCM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLResultadoFreMax.setForeground(Color.red);
        this.JLResultadoFreMax.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0.##"))));
        this.JLResultadoFreMax.setHorizontalAlignment(0);
        this.JLResultadoFreMax.setText("0");
        this.JLResultadoFreMax.setToolTipText("");
        this.JLResultadoFreMax.setFont(new Font("Arial", 1, 14));
        this.JCHCalcular.setFont(new Font("Arial", 1, 12));
        this.JCHCalcular.setText("Calcular");
        this.JCHCalcular.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.49
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JCHCalcularActionPerformed(evt);
            }
        });
        this.JLBIRC.setFont(new Font("Arial", 1, 14));
        this.JLBIRC.setForeground(new Color(255, 0, 0));
        this.JLBIRC.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación IRC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.IRC.setBorder(BorderFactory.createTitledBorder((Border) null, "IRC 2Minutos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.IRC.setHorizontalAlignment(0);
        this.IRC.setText("0");
        this.IRC.setToolTipText("Flexibilidad");
        this.IRC.setExprecionRegular("-?[0.0-9]+");
        this.IRC.setFocusAccelerator('C');
        this.IRC.setFont(new Font("Arial", 1, 12));
        this.IRC.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.50
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.IRCActionPerformed(evt);
            }
        });
        this.IRC.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.51
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.IRCFocusLost(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.IRC, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBIRC, -1, -1, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBCCicloErg, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 46, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(56, 56, 56).addComponent(this.JTFFV02, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -2, 13, -2).addGap(1, 1, 1).addComponent(this.JLPeso, -2, 61, -2).addGap(1, 1, 1).addComponent(this.jLabel4, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLResultado, -2, 82, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFrecMax, -2, 93, -2).addGap(5, 5, 5).addComponent(this.JTFrecMaxAl, -2, 154, -2)).addComponent(this.JLResultadoFreMax)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCalcular))).addGap(0, 0, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLPeso, -2, 58, -2).addComponent(this.JLResultado, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFV02, -2, 56, -2).addComponent(this.jLabel1).addComponent(this.jLabel3).addComponent(this.jLabel4))).addGap(3, 3, 3).addComponent(this.JLBCCicloErg, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFrecMax, -2, 56, -2).addComponent(this.JTFrecMaxAl, -2, 56, -2).addComponent(this.JCHCalcular)).addGap(4, 4, 4).addComponent(this.JLResultadoFreMax, -2, 50, -2).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBIRC, -2, 53, -2).addComponent(this.IRC, -2, 56, -2)).addContainerGap(-1, 32767)));
        this.JPIndiceTobilloBrazo.setBorder(BorderFactory.createTitledBorder((Border) null, "INDICE DE TOBILLO BRAZO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFPSentadoTS.setBorder(BorderFactory.createTitledBorder((Border) null, "Tension  A. Tobillo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPSentadoTS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoTS.setHorizontalAlignment(4);
        this.JTFFPSentadoTS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoTS.setName("fechanaciemiento");
        this.JTFFPSentadoTS.setValue(new Integer(0));
        this.JTFFPSentadoTS.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.52
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoTSFocusLost(evt);
            }
        });
        this.JTFFPSentadoTS.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.53
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFPSentadoTSActionPerformed(evt);
            }
        });
        this.JLBCITB.setFont(new Font("Arial", 1, 14));
        this.JLBCITB.setHorizontalAlignment(0);
        this.JLBCITB.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo (ITB)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFCalculoITB.setBorder(BorderFactory.createTitledBorder((Border) null, "ITB", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCalculoITB.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFCalculoITB.setHorizontalAlignment(4);
        this.JTFFCalculoITB.setFont(new Font("Arial", 1, 12));
        this.JTFFCalculoITB.setName("fechanaciemiento");
        this.JTFFCalculoITB.setValue(new Integer(0));
        this.JTFFCalculoITB.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.54
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFCalculoITBFocusLost(evt);
            }
        });
        this.JTFFCalculoITB.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.55
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JTFFCalculoITBActionPerformed(evt);
            }
        });
        GroupLayout JPIndiceTobilloBrazoLayout = new GroupLayout(this.JPIndiceTobilloBrazo);
        this.JPIndiceTobilloBrazo.setLayout(JPIndiceTobilloBrazoLayout);
        JPIndiceTobilloBrazoLayout.setHorizontalGroup(JPIndiceTobilloBrazoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIndiceTobilloBrazoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFPSentadoTS, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFCalculoITB, -2, 134, -2).addContainerGap()).addComponent(this.JLBCITB, -2, 376, -2));
        JPIndiceTobilloBrazoLayout.setVerticalGroup(JPIndiceTobilloBrazoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIndiceTobilloBrazoLayout.createSequentialGroup().addContainerGap().addGroup(JPIndiceTobilloBrazoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPSentadoTS, -2, 50, -2).addComponent(this.JTFFCalculoITB, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBCITB, -2, 66, -2)));
        GroupLayout JPIOtrosLayout = new GroupLayout(this.JPIOtros);
        this.JPIOtros.setLayout(JPIOtrosLayout);
        JPIOtrosLayout.setHorizontalGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFSPGrasa, -1, 97, 32767).addComponent(this.JTFFFlexibilidad, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBCPGrasa, -1, 208, 32767).addComponent(this.JLBCFlexibilidad, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addComponent(this.JTFFEEsfuerzo).addGap(10, 10, 10).addComponent(this.JCBCRiesgo, -2, 273, -2)).addGroup(JPIOtrosLayout.createSequentialGroup().addComponent(this.JPICEmbarazo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSPCefalico, -2, 137, -2).addGap(0, 0, 32767))).addGap(23, 23, 23)).addGroup(JPIOtrosLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIndiceTobilloBrazo, -1, -1, 32767).addContainerGap()))));
        JPIOtrosLayout.setVerticalGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCRiesgo, -2, 50, -2).addComponent(this.JLBCPGrasa, -2, 53, -2).addComponent(this.JTFFEEsfuerzo, -2, 50, -2)).addComponent(this.JTFFSPGrasa, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBCFlexibilidad, -2, 53, -2).addComponent(this.JTFFFlexibilidad, -2, 50, -2).addComponent(this.JPICEmbarazo, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JTFFSPCefalico, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, 32767).addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JPIndiceTobilloBrazo, -2, -1, -2)).addContainerGap()));
        this.JTPDatos.addTab("OTROS DATOS", this.JPIOtros);
        this.JTPDatosPyp.setForeground(new Color(0, 103, 0));
        this.JTPDatosPyp.setFont(new Font("Arial", 1, 12));
        this.JPICDiabetes.setBorder(BorderFactory.createTitledBorder((Border) null, "% Hb Glicosilada", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFVHm.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVHm.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JTFFVHm.setHorizontalAlignment(4);
        this.JTFFVHm.setFont(new Font("Arial", 1, 12));
        this.JTFFVHm.setName("fechanaciemiento");
        this.JTFFVHm.setValue(new Integer(0));
        this.JTFFVHm.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisico.56
            public void focusLost(FocusEvent evt) {
                JPAExamenFisico.this.JTFFVHmFocusLost(evt);
            }
        });
        this.JTFFVHm.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.57
            public void keyPressed(KeyEvent evt) {
                JPAExamenFisico.this.JTFFVHmKeyPressed(evt);
            }
        });
        this.JCHCobntrolado1.setFont(new Font("Arial", 1, 12));
        this.JCHCobntrolado1.setSelected(true);
        this.JCHCobntrolado1.setText("Controlado?");
        this.JCHCobntrolado1.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.58
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JCHCobntrolado1ActionPerformed(evt);
            }
        });
        this.JLMeta.setBorder(BorderFactory.createTitledBorder((Border) null, "Meta", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPICDiabetesLayout = new GroupLayout(this.JPICDiabetes);
        this.JPICDiabetes.setLayout(JPICDiabetesLayout);
        JPICDiabetesLayout.setHorizontalGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLMeta, -1, -1, 32767).addComponent(this.JTFFVHm, -1, 92, 32767)).addComponent(this.JCHCobntrolado1)).addContainerGap(-1, 32767)));
        JPICDiabetesLayout.setVerticalGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createSequentialGroup().addComponent(this.JLMeta, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVHm, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCobntrolado1).addContainerGap(-1, 32767)));
        this.JSPHistoricoD.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTHistoricoD.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPHistoricoD.setViewportView(this.JTHistoricoD);
        this.JBGrafico.setFont(new Font("Arial", 1, 12));
        this.JBGrafico.setText("Ver Gráfico");
        this.JBGrafico.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.59
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JBGraficoActionPerformed(evt);
            }
        });
        this.JLGrafico.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIDPyPDiabetesLayout = new GroupLayout(this.JPIDPyPDiabetes);
        this.JPIDPyPDiabetes.setLayout(JPIDPyPDiabetesLayout);
        JPIDPyPDiabetesLayout.setHorizontalGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addComponent(this.JPICDiabetes, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistoricoD, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLGrafico, -1, 282, 32767)).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addComponent(this.JBGrafico).addGap(0, 0, 32767))).addContainerGap()));
        JPIDPyPDiabetesLayout.setVerticalGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLGrafico, -1, -1, 32767).addComponent(this.JSPHistoricoD, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.JPICDiabetes, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrafico).addContainerGap(269, 32767)));
        this.JTPDatosPyp.addTab("PROGRAMA DE DIABETES", this.JPIDPyPDiabetes);
        GroupLayout JPIDatosPypLayout = new GroupLayout(this.JPIDatosPyp);
        this.JPIDatosPyp.setLayout(JPIDatosPypLayout);
        JPIDatosPypLayout.setHorizontalGroup(JPIDatosPypLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPypLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp, -2, 732, -2).addContainerGap(-1, 32767)));
        JPIDatosPypLayout.setVerticalGroup(JPIDatosPypLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPypLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp).addContainerGap()));
        this.JTPDatos.addTab("DATOS PROMOCIÓN Y PREVENCIÓN", this.JPIDatosPyp);
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisico.60
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisico.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisico.61
            public void keyPressed(KeyEvent evt) {
                JPAExamenFisico.this.JBTGuardarKeyPressed(evt);
            }
        });
        GroupLayout JPIExamenFisicoLayout = new GroupLayout(this.JPIExamenFisico);
        this.JPIExamenFisico.setLayout(JPIExamenFisicoLayout);
        JPIExamenFisicoLayout.setHorizontalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addContainerGap().addGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIExamenFisicoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTPDatos, -2, 771, -2)).addComponent(this.JBTGuardar, -1, -1, 32767))));
        JPIExamenFisicoLayout.setVerticalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addComponent(this.JTPDatos, -2, 556, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 59, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIExamenFisico, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIExamenFisico, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEFObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEFObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoS.getText()).intValue(), 0);
            if (!this.JTFFPSentadoTS.getText().isEmpty() && Integer.valueOf(this.JTFFPSentadoTS.getValue().toString()).intValue() != 0) {
                mCalcularITB(Double.valueOf(this.JTFFPSentadoS.getValue().toString()), Double.valueOf(this.JTFFPSentadoTS.getValue().toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoD.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPPieSActionPerformed(ActionEvent evt) {
        this.JTFFPPieS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPPieSFocusLost(FocusEvent evt) {
        if (!this.JTFFPPieS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPPieS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPPieDActionPerformed(ActionEvent evt) {
        this.JTFFPPieD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPPieDFocusLost(FocusEvent evt) {
        if (!this.JTFFPPieD.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPPieD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPAcostadoSActionPerformed(ActionEvent evt) {
        this.JTFFPAcostadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPAcostadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPAcostadoS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPAcostadoS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPAcostadoDActionPerformed(ActionEvent evt) {
        this.JTFFPAcostadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPAcostadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPAcostadoD.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPAcostadoD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCobntroladoActionPerformed(ActionEvent evt) {
        if (this.JCHCobntrolado.isSelected()) {
            this.xcontrolado = 0;
        } else {
            this.xcontrolado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xembarazo = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xembarazo = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPerimetroAbdStateChanged(ChangeEvent evt) {
        mClasificarPAbdominal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
        this.JTFFSFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusGained(FocusEvent evt) {
        this.JTFFSFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusLost(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
        this.JTFFPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
        this.JTFFSTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2FocusGained(FocusEvent evt) {
        this.JTFFPs2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        mPerder_Foco_Talla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        mPerder_Foco_Talla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        mPerder_Foco_Talla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPGrasaFocusGained(FocusEvent evt) {
        this.JTFFSPGrasa.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPGrasaActionPerformed(ActionEvent evt) {
        mClasificarPGrasa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPGrasaFocusLost(FocusEvent evt) {
        mClasificarPGrasa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFlexibilidadActionPerformed(ActionEvent evt) {
        mClasificarFlexibilidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFlexibilidadFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFlexibilidadFocusLost(FocusEvent evt) {
        mClasificarFlexibilidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGraficoActionPerformed(ActionEvent evt) {
        mGenerarGrafico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCobntrolado1ActionPerformed(ActionEvent evt) {
        if (this.JCHCobntrolado1.isSelected()) {
            this.xcontroldm = 0;
        } else {
            this.xcontroldm = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVHmKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFVHm.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVHmFocusLost(FocusEvent evt) {
        if (this.JTFFVHm.getText().isEmpty()) {
            return;
        }
        if (Double.parseDouble(this.JTFFVHm.getText().replace(',', '.')) <= 7.5d) {
            this.JCHCobntrolado1.setSelected(true);
            this.xcontroldm = 0;
        } else {
            this.JCHCobntrolado1.setSelected(false);
            this.xcontroldm = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaHierarchyChanged(HierarchyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFV02ActionPerformed(ActionEvent evt) {
        if (!this.JTFFV02.getText().equals("0")) {
            this.JLBCCicloErg.setText(mClasificacionCicloergometro(Double.valueOf(this.JTFFV02.getText()).doubleValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFV02FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFV02FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCalcularActionPerformed(ActionEvent evt) {
        if (this.JCHCalcular.isSelected()) {
            NumberFormat formatter = new DecimalFormat("#0");
            if (!this.JTFrecMaxAl.getText().equals("0")) {
                int fre = 220 - this.xEdadActual;
                double xr = (Double.valueOf(this.JTFrecMaxAl.getText()).doubleValue() / ((double) fre)) * 100.0d;
                this.JTFrecMax.setText("" + fre);
                this.JLResultadoFreMax.setText(formatter.format(xr) + "%");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la Frecuecia Maxima Alcanzada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCHCalcular.setSelected(false);
            return;
        }
        this.JTFrecMax.setText("0");
        this.JTFrecMaxAl.setText("0");
        this.JLResultadoFreMax.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IRCFocusLost(FocusEvent evt) {
        if (Double.parseDouble(this.IRC.getText()) > 0.0d) {
            mIRC();
        } else {
            this.IRC.setText("0");
            this.JLBIRC.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IRCActionPerformed(ActionEvent evt) {
        if (Double.parseDouble(this.IRC.getText()) > 0.0d) {
            mIRC();
        } else {
            this.IRC.setText("0");
            this.JLBIRC.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2KeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSPeso.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSPeso.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_DatosTraigeActionPerformed(ActionEvent evt) {
        mCargarTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHExcepcionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoTSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty() && Integer.valueOf(this.JTFFPSentadoS.getValue().toString()).intValue() != 0 && !this.JTFFPSentadoTS.getText().isEmpty()) {
            mCalcularITB(Double.valueOf(this.JTFFPSentadoS.getValue().toString()), Double.valueOf(this.JTFFPSentadoTS.getValue().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoTSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoTS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCalculoITBFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCalculoITBActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AutoexamensenoActionPerformed(ActionEvent evt) {
        if (this.JCH_Autoexamenseno.isSelected()) {
            this.autoexamenseno = "SI";
        } else {
            this.autoexamenseno = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPerimetroPantorrillaStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPerimetroBranquialStateChanged(ChangeEvent evt) {
    }

    private void mPerder_Foco_Talla() {
        if (getTalla() > 0.0d) {
            if (this.JCHExcepcion.isSelected()) {
                mCalcularImc();
                return;
            }
            if (getTalla() < 30.0d || getTalla() > 220.0d) {
                JOptionPane.showMessageDialog(this, "Valor fuera de rangos normales;\nFavor Verificar", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSTalla.setText("0");
                this.JTFFSTalla.requestFocus();
                return;
            }
            mCalcularImc();
        }
    }

    private void mClasificarFlexibilidad() {
        if (Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() != 0.0d) {
            if (Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() > 14.0d) {
                this.JLBCFlexibilidad.setText("Excelente");
                return;
            }
            if (Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() >= 11.0d && Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() <= 14.0d) {
                this.JLBCFlexibilidad.setText("Sobre la media");
                return;
            }
            if (Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() >= 7.0d && Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() < 11.0d) {
                this.JLBCFlexibilidad.setText("Promedio");
            } else if (Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() >= -4.0d && Double.valueOf(this.JTFFFlexibilidad.getText()).doubleValue() < 7.0d) {
                this.JLBCFlexibilidad.setText("Bajo");
            } else {
                this.JLBCFlexibilidad.setText("Muy bajo");
            }
        }
    }

    private void mClasificarPGrasa() {
        if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() > 0.0d) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("FEMENINO")) {
                if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 19.0d) {
                    this.JLBCPGrasa.setText("Ideal");
                    return;
                }
                if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 19.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 25.0d) {
                    this.JLBCPGrasa.setText("Bueno");
                    return;
                }
                if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 25.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 30.0d) {
                    this.JLBCPGrasa.setText("Moderado");
                    return;
                } else if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 30.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 34.0d) {
                    this.JLBCPGrasa.setText("Alto");
                    return;
                } else {
                    this.JLBCPGrasa.setText("Obeso");
                    return;
                }
            }
            if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 14.0d) {
                this.JLBCPGrasa.setText("Ideal");
                return;
            }
            if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 14.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 20.0d) {
                this.JLBCPGrasa.setText("Bueno");
                return;
            }
            if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 20.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 25.0d) {
                this.JLBCPGrasa.setText("Moderado");
            } else if (Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() >= 25.0d && Double.valueOf(this.JTFFSPGrasa.getText()).doubleValue() < 30.0d) {
                this.JLBCPGrasa.setText("Alto");
            } else {
                this.JLBCPGrasa.setText("Obeso");
            }
        }
    }

    private void mClasificarPAbdominal() {
        if (Double.valueOf(this.JTFFSPerimetroAbd.getValue().toString()).doubleValue() != 0.0d) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("FEMENINO")) {
                if (((Double) this.JTFFSPerimetroAbd.getValue()).doubleValue() < 80.0d) {
                    this.JLBCPAbdominal.setText("Sin riesgo");
                    return;
                } else {
                    if (((Double) this.JTFFSPerimetroAbd.getValue()).doubleValue() >= 80.0d) {
                        this.JLBCPAbdominal.setText("Obesidad abdominal");
                        return;
                    }
                    return;
                }
            }
            if (((Double) this.JTFFSPerimetroAbd.getValue()).doubleValue() < 90.0d) {
                this.JLBCPAbdominal.setText("Sin riesgo");
            } else if (((Double) this.JTFFSPerimetroAbd.getValue()).doubleValue() >= 90.0d) {
                this.JLBCPAbdominal.setText("Obesidad abdominal");
            }
        }
    }

    private String mClasificacionCicloergometro(double xValor) {
        NumberFormat formatter = new DecimalFormat("#0.0");
        double xCalculo = (11.2d * (xValor / Double.valueOf(this.JTFFSPeso.getText()).doubleValue())) + 7.0d;
        this.JLResultado.setText("" + formatter.format(xCalculo));
        String xCalificacion = null;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
            if (this.xEdadActual < 20 || this.xEdadActual > 29) {
                if (this.xEdadActual < 30 || this.xEdadActual > 39) {
                    if (this.xEdadActual < 40 || this.xEdadActual > 49) {
                        if (this.xEdadActual < 50 || this.xEdadActual > 59) {
                            if (this.xEdadActual >= 60 && this.xEdadActual <= 69) {
                                if (xCalculo < 16.0d) {
                                    xCalificacion = "MUY BAJO: P10";
                                } else if (xCalculo >= 16.0d && xCalculo <= 22.9d) {
                                    xCalificacion = "BAJO: P30";
                                } else if (xCalculo >= 23.0d && xCalculo <= 30.9d) {
                                    xCalificacion = "PROMEDIO: P50";
                                } else if (xCalculo >= 31.0d && xCalculo <= 40.9d) {
                                    xCalificacion = "BUENO: P70";
                                } else if (xCalculo >= 41.0d) {
                                    xCalificacion = "ALTO: P90";
                                }
                            }
                        } else if (xCalculo < 18.0d) {
                            xCalificacion = "MUY BAJO: P10";
                        } else if (xCalculo >= 18.0d && xCalculo <= 24.9d) {
                            xCalificacion = "BAJO: P30";
                        } else if (xCalculo >= 25.0d && xCalculo <= 33.9d) {
                            xCalificacion = "PROMEDIO: P50";
                        } else if (xCalculo >= 34.0d && xCalculo <= 42.9d) {
                            xCalificacion = "BUENO: P70";
                        } else if (xCalculo >= 43.0d) {
                            xCalificacion = "ALTO: P90";
                        }
                    } else if (xCalculo < 20.0d) {
                        xCalificacion = "MUY BAJO: P10";
                    } else if (xCalculo >= 20.0d && xCalculo <= 26.9d) {
                        xCalificacion = "BAJO: P30";
                    } else if (xCalculo >= 27.0d && xCalculo <= 35.9d) {
                        xCalificacion = "PROMEDIO: P50";
                    } else if (xCalculo >= 36.0d && xCalculo <= 44.9d) {
                        xCalificacion = "BUENO: P70";
                    } else if (xCalculo >= 45.0d) {
                        xCalificacion = "ALTO: P90";
                    }
                } else if (xCalculo < 23.0d) {
                    xCalificacion = "MUY BAJO: P10";
                } else if (xCalculo >= 23.0d && xCalculo <= 30.9d) {
                    xCalificacion = "BAJO: P30";
                } else if (xCalculo >= 31.0d && xCalculo <= 38.9d) {
                    xCalificacion = "PROMEDIO: P50";
                } else if (xCalculo >= 39.0d && xCalculo <= 48.9d) {
                    xCalificacion = "BUENO: P70";
                } else if (xCalculo >= 49.0d) {
                    xCalificacion = "ALTO: P90";
                }
            } else if (xCalculo < 25.0d) {
                xCalificacion = "MUY BAJO: P10";
            } else if (xCalculo >= 25.0d && xCalculo <= 33.9d) {
                xCalificacion = "BAJO: P30";
            } else if (xCalculo >= 34.0d && xCalculo <= 42.9d) {
                xCalificacion = "PROMEDIO: P50";
            } else if (xCalculo >= 43.0d && xCalculo <= 52.9d) {
                xCalificacion = "BUENO: P70";
            } else if (xCalculo >= 53.0d) {
                xCalificacion = "ALTO: P90";
            }
        } else if (this.xEdadActual < 20 || this.xEdadActual > 29) {
            if (this.xEdadActual < 30 || this.xEdadActual > 39) {
                if (this.xEdadActual < 40 || this.xEdadActual > 49) {
                    if (this.xEdadActual < 50 || this.xEdadActual > 59) {
                        if (this.xEdadActual >= 60 && this.xEdadActual <= 69) {
                            if (xCalculo < 13.0d) {
                                xCalificacion = "MUY BAJO: P10";
                            } else if (xCalculo >= 13.0d && xCalculo <= 17.9d) {
                                xCalificacion = "BAJO: P30";
                            } else if (xCalculo >= 18.0d && xCalculo <= 23.9d) {
                                xCalificacion = "PROMEDIO: P50";
                            } else if (xCalculo >= 24.0d && xCalculo <= 34.9d) {
                                xCalificacion = "BUENO: P70";
                            } else if (xCalculo >= 35.0d) {
                                xCalificacion = "ALTO: P90";
                            }
                        }
                    } else if (xCalculo < 15.0d) {
                        xCalificacion = "MUY BAJO: P10";
                    } else if (xCalculo >= 15.0d && xCalculo <= 20.9d) {
                        xCalificacion = "BAJO: P30";
                    } else if (xCalculo >= 21.0d && xCalculo <= 27.9d) {
                        xCalificacion = "PROMEDIO: P50";
                    } else if (xCalculo >= 28.0d && xCalculo <= 37.9d) {
                        xCalificacion = "BUENO: P70";
                    } else if (xCalculo >= 38.0d) {
                        xCalificacion = "ALTO: P90";
                    }
                } else if (xCalculo < 17.0d) {
                    xCalificacion = "MUY BAJO: P10";
                } else if (xCalculo >= 17.0d && xCalculo <= 23.9d) {
                    xCalificacion = "BAJO: P30";
                } else if (xCalculo >= 24.0d && xCalculo <= 30.9d) {
                    xCalificacion = "PROMEDIO: P50";
                } else if (xCalculo >= 31.0d && xCalculo <= 41.9d) {
                    xCalificacion = "BUENO: P70";
                } else if (xCalculo >= 42.0d) {
                    xCalificacion = "ALTO: P90";
                }
            } else if (xCalculo < 20.0d) {
                xCalificacion = "MUY BAJO: P10";
            } else if (xCalculo >= 20.0d && xCalculo <= 27.9d) {
                xCalificacion = "BAJO: P30";
            } else if (xCalculo >= 28.0d && xCalculo <= 33.9d) {
                xCalificacion = "PROMEDIO: P50";
            } else if (xCalculo >= 34.0d && xCalculo <= 44.9d) {
                xCalificacion = "BUENO: P70";
            } else if (xCalculo >= 45.0d) {
                xCalificacion = "ALTO: P90";
            }
        } else if (xCalculo < 24.0d) {
            xCalificacion = "MUY BAJO: P10";
        } else if (xCalculo >= 24.0d && xCalculo <= 30.9d) {
            xCalificacion = "BAJO: P30";
        } else if (xCalculo >= 31.0d && xCalculo <= 37.9d) {
            xCalificacion = "PROMEDIO: P50";
        } else if (xCalculo >= 38.0d && xCalculo <= 48.9d) {
            xCalificacion = "BUENO: P70";
        } else if (xCalculo >= 49.0d) {
            xCalificacion = "ALTO: P90";
        }
        return xCalificacion;
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("0.00");
            this.imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFSIMC.setText(String.valueOf(formato.format(this.imc)));
            this.JTFFSPIdeal.setValue(Double.valueOf((getPeso() * 24.9d) / this.imc));
            this.JLBCObecidad.setText("");
            if (this.imc < 18.5d) {
                this.JLBCImc.setText("Delgadez");
            } else if (this.imc >= 18.5d && this.imc < 25.0d) {
                this.JLBCImc.setText("Normal");
            } else if (this.imc >= 25.0d && this.imc < 30.0d) {
                this.JLBCImc.setText("Sobrepeso");
            } else if (this.imc >= 30.0d) {
                this.JLBCImc.setText("Obesidad");
                if (this.imc >= 30.0d && this.imc <= 34.9d) {
                    this.JLBCObecidad.setText("Obesidad grado I");
                } else if (this.imc >= 35.0d && this.imc <= 39.9d) {
                    this.JLBCObecidad.setText("Obesidad grado II");
                } else if (this.imc >= 40.0d) {
                    this.JLBCObecidad.setText("Obesidad grado III");
                }
            }
        } else {
            this.JTFFSIMC.setText("0");
            this.JLBCObecidad.setText("");
        }
        this.JLPeso.setText("" + this.JTFFSPeso.getText());
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && !this.JTFFSTalla.getText().equals("0") && Double.valueOf(this.JTFFSTalla.getText()).doubleValue() > 0.0d) {
            valor = Double.valueOf(this.JTFFSTalla.getText()).doubleValue();
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("") && Double.parseDouble(this.JTFFSPeso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFSPeso.getText());
        }
        return valor;
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        } else if (valor > 0 && valor > 90) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void mEnviarCorreoporPerimetroAbd() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("MASCULINO")) {
            if (Double.valueOf(this.JTFFSPerimetroAbd.getValue().toString()).doubleValue() > 94.0d) {
                String mensaje = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\n Tiene un perímetro abdominal de : " + this.JTFFSPerimetroAbd.getValue() + "  Favor Revisar.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                this.xmetodo.mEnvioCorreoElectronico(mensaje, "nutricion@fundacionpanzenu.org.co", "PERIMETRO ABDOMINAL ELEVADO", Principal.usuarioSistemaDTO.getLogin());
                return;
            }
            return;
        }
        if (Double.valueOf(this.JTFFSPerimetroAbd.getValue().toString()).doubleValue() > 88.0d) {
            String mensaje2 = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\n Tiene un perímetro abdominal de : " + this.JTFFSPerimetroAbd.getValue() + "  Favor Revisar.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
            this.xmetodo.mEnvioCorreoElectronico(mensaje2, "nutricion@fundacionpanzenu.org.co", "PERIMETRO ABDOMINAL ELEVADO", Principal.usuarioSistemaDTO.getLogin());
        }
    }

    public void mGrabarBd() {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
            if (this.JBTGuardar.isEnabled()) {
                if (this.JTFFSFc.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFc.requestFocus();
                    return;
                }
                if (Double.parseDouble(this.JTFFSFc.getText().toString()) > 0.0d) {
                    if (this.JTFFSFr.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSFr.requestFocus();
                        return;
                    }
                    if (Double.parseDouble(this.JTFFSFr.getText().toString()) > 0.0d) {
                        if (this.JTFFSPeso.getText().isEmpty()) {
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSPeso.requestFocus();
                            return;
                        }
                        if (Double.parseDouble(this.JTFFSPeso.getText().toString()) != 0.0d || this.JCHExcepcion.isSelected()) {
                            if (this.JTFFSTalla.getText().isEmpty()) {
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFSTalla.requestFocus();
                                return;
                            }
                            if (Double.parseDouble(this.JTFFSTalla.getText().toString()) != 0.0d) {
                                if (this.JTFFTemperatura.getText().isEmpty()) {
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFTemperatura.requestFocus();
                                    return;
                                }
                                if (Double.parseDouble(this.JTFFTemperatura.getText().toString()) >= 0.0d) {
                                    if (this.JTFFPs2.getText().isEmpty()) {
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFPs2.requestFocus();
                                        return;
                                    }
                                    if (Double.parseDouble(this.JTFFPs2.getText().toString()) >= 0.0d) {
                                        if (this.JTFFSIMC.getText().isEmpty()) {
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tEl IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFSIMC.requestFocus();
                                            return;
                                        }
                                        if (Double.parseDouble(this.JTFFSPerimetroAbd.getValue().toString()) <= 0.0d && !this.JCHExcepcion.isSelected()) {
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tEl Perimetro Abdominal debe \n\t  ser mayor que 0", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFSPerimetroAbd.requestFocus();
                                            return;
                                        }
                                        if (Double.parseDouble(this.JTFFPSentadoS.getValue().toString()) <= 0.0d || this.JTFFPSentadoS.getText().isEmpty()) {
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Presion Sistolica (Sentado) no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFPSentadoS.requestFocus();
                                            return;
                                        }
                                        if (Double.parseDouble(this.JTFFPSentadoD.getValue().toString()) > 0.0d && !this.JTFFPSentadoS.getText().isEmpty()) {
                                            if (this.JTFFV02.getText().isEmpty()) {
                                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFFSIMC.requestFocus();
                                                return;
                                            }
                                            if (Double.parseDouble(this.JTFFV02.getText().toString()) >= 0.0d) {
                                                if (this.JCBCRiesgo.getSelectedIndex() != -1) {
                                                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                                                        try {
                                                            String sql = "SELECT Id, Id_Atencion FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                                                            ResultSet xrs = this.xconsultasbd.traerRs(sql);
                                                            if (xrs.next()) {
                                                                xrs.first();
                                                                String sql2 = "update h_examenfisico set TArtSentadoD='" + this.JTFFPSentadoD.getValue() + "', TArtSentadoS='" + this.JTFFPSentadoS.getValue() + "', TArtAcostadoD='" + this.JTFFPAcostadoD.getValue() + "', TArtAcostadoS='" + this.JTFFPAcostadoS.getValue() + "', TArtPieD='" + this.JTFFPPieD.getValue() + "', TArtPieS='" + this.JTFFPPieS.getValue() + "',ControlTA ='" + this.xcontrolado + "',FCardiaca ='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText().replaceAll(",", ".") + "', RImc='" + this.JLBCImc.getText() + "', RObecidad='" + this.JLBCObecidad.getText() + "', Observacion='" + this.JTPEFObservaciones.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Ps2='" + this.JTFFPs2.getText() + "', ControlDm='" + this.xcontroldm + "', ValorGlicemia='" + this.JTFFVHm.getValue() + "', PerimetroAbdominal='" + this.JTFFSPerimetroAbd.getValue() + "', RPAbdominal='" + this.JLBCPAbdominal.getText() + "', PerimetroCefalico='" + this.JTFFSPCefalico.getValue() + "', Id_CRiesgo='" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "', Embarazo='" + this.xembarazo + "', MetaHb='" + this.JTFFVHm.getValue() + "', PesoIdeal='" + this.JTFFSPIdeal.getValue() + "', PGrasa='" + this.JTFFSPGrasa.getText() + "', RPGrasa='" + this.JLBCPGrasa.getText() + "', EgEsfuerzo='" + this.JTFFEEsfuerzo.getValue() + "', Flexibilidad='" + this.JTFFFlexibilidad.getText() + "', RFlexibilidad='" + this.JLBCFlexibilidad.getText() + "', VMAX='" + this.JTFFV02.getText() + "', ClaVMAX='" + this.JLBCCicloErg.getText() + "', ResultadoVMAX='" + this.JLResultado.getText().replaceAll(",", ".") + "', FrecMax='" + this.JTFrecMax.getText() + "', FrecMaxAlc='" + this.JTFrecMaxAl.getText() + "', ResultadoFrecMax='" + this.JLResultadoFreMax.getText() + "', IRC='" + Double.parseDouble(this.IRC.getText()) + "', ClaIRC='" + this.JLBIRC.getText() + "', TASistolicaT='" + this.JTFFPSentadoTS.getValue() + "', ResultadoITB='" + this.JTFFCalculoITB.getValue() + "', ClaITB='" + this.JLBCITB.getText() + "', AutoExamenSeno='" + this.autoexamenseno + "', `PerimetroBranquial`=" + this.JTFFSPerimetroBranquial.getValue() + ", `PerimetroPantorrilla` = " + this.JTFFSPerimetroPantorrilla.getValue() + ", Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id ='" + xrs.getString(1) + "') ";
                                                                this.xconsultasbd.ejecutarSQL(sql2);
                                                                this.xconsultasbd.cerrarConexionBd();
                                                            } else {
                                                                String sql3 = "insert into h_examenfisico ( Id_Atencion, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA, FCardiaca, FRespiratoria, Talla, Peso, IMC, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, PerimetroAbdominal,AutoExamenSeno, PerimetroCefalico, Id_CRiesgo,Embarazo,MetaHb, `RImc`,RObecidad , `RPAbdominal`, `PesoIdeal`, `PGrasa`, `RPGrasa`, `EgEsfuerzo`, `Flexibilidad`, `RFlexibilidad`,VMAX,ClaVMAX,ResultadoVMAX,FrecMax, FrecMaxAlc ,ResultadoFrecMax, IRC, ClaIRC, TASistolicaT, ResultadoITB, ClaITB,`PerimetroBranquial`,`PerimetroPantorrilla`, Fecha, UsuarioS ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFFPSentadoD.getValue() + "','" + this.JTFFPSentadoS.getValue() + "','" + this.JTFFPAcostadoD.getValue() + "','" + this.JTFFPAcostadoS.getValue() + "','" + this.JTFFPPieD.getValue() + "','" + this.JTFFPPieS.getValue() + "','" + this.xcontrolado + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText().replaceAll(",", ".") + "','" + this.JTPEFObservaciones.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + this.xcontroldm + "','" + this.JTFFVHm.getValue() + "','" + this.JTFFSPerimetroAbd.getValue() + "','" + this.autoexamenseno + "','" + this.JTFFSPCefalico.getValue() + "','" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "','" + this.xembarazo + "','" + this.JLMeta.getText() + "','" + this.JLBCImc.getText() + "','" + this.JLBCObecidad.getText() + "','" + this.JLBCPAbdominal.getText() + "','" + this.JTFFSPIdeal.getValue() + "','" + this.JTFFSPGrasa.getText() + "','" + this.JLBCPGrasa.getText() + "','" + this.JTFFEEsfuerzo.getValue() + "','" + this.JTFFFlexibilidad.getText() + "','" + this.JLBCFlexibilidad.getText() + "','" + this.JTFFV02.getText() + "','" + this.JLBCCicloErg.getText() + "','" + this.JLResultado.getText().replaceAll(",", ".") + "','" + this.JTFrecMax.getText() + "','" + this.JTFrecMaxAl.getText() + "','" + this.JLResultadoFreMax.getText() + "','" + Double.parseDouble(this.IRC.getText()) + "','" + this.JLBIRC.getText() + "','" + this.JTFFPSentadoTS.getValue() + "','" + this.JTFFCalculoITB.getValue() + "','" + this.JLBCITB.getText() + "' ," + this.JTFFSPerimetroBranquial.getValue() + ", " + this.JTFFSPerimetroPantorrilla.getValue() + ",'" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                this.xidexamenf = this.xconsultasbd.ejecutarSQLId(sql3);
                                                                this.xconsultasbd.cerrarConexionBd();
                                                                mEnviarCorreoporPerimetroAbd();
                                                            }
                                                            xrs.close();
                                                            this.xconsultasbd.cerrarConexionBd();
                                                        } catch (SQLException ex) {
                                                            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                                        }
                                                    }
                                                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificacion de riesgo cardiovascular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JCBCRiesgo.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa V02 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFV02.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Presion Diastolica (Sentado) no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFPSentadoD.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFTemperatura.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSTalla.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSPeso.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFr.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFc.requestFocus();
                return;
            }
            return;
        }
        if (this.JBTGuardar.isEnabled()) {
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA")) {
                if (this.JTFFSFc.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFc.requestFocus();
                    return;
                }
                if (Double.parseDouble(this.JTFFSFc.getText().toString()) > 0.0d) {
                    if (this.JTFFSFr.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSFr.requestFocus();
                        return;
                    }
                    if (Double.parseDouble(this.JTFFSFr.getText().toString()) > 0.0d) {
                        if (this.JTFFSPeso.getText().isEmpty()) {
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSPeso.requestFocus();
                            return;
                        }
                        if (Double.parseDouble(this.JTFFSPeso.getText().toString()) > 0.0d || this.JCHExcepcion.isSelected()) {
                            if (this.JTFFSTalla.getText().isEmpty()) {
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFSTalla.requestFocus();
                                return;
                            }
                            if (Double.parseDouble(this.JTFFSTalla.getText().toString()) > 0.0d) {
                                if (this.JTFFTemperatura.getText().isEmpty()) {
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFTemperatura.requestFocus();
                                    return;
                                }
                                if (Double.parseDouble(this.JTFFTemperatura.getText().toString()) > 0.0d) {
                                    if (this.JTFFPs2.getText().isEmpty()) {
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFPs2.requestFocus();
                                        return;
                                    }
                                    if (Double.parseDouble(this.JTFFPs2.getText().toString()) > 0.0d) {
                                        if (this.JTFFPSentadoS.getText().isEmpty()) {
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tVerifique el valor de la presión siastólica, no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFPSentadoS.requestFocus();
                                            return;
                                        }
                                        if (Double.parseDouble(this.JTFFPSentadoS.getText().toString()) > 0.0d) {
                                            if (this.JTFFPSentadoD.getText().isEmpty()) {
                                                JOptionPane.showInternalMessageDialog(this, "\t\t\tVerifique el valor de la presión diastólica, no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFFPSentadoD.requestFocus();
                                                return;
                                            }
                                            if (Double.parseDouble(this.JTFFPSentadoD.getText().toString()) <= 0.0d) {
                                                JOptionPane.showInternalMessageDialog(this, "\t\t\tVerifique el valor de la presión diastólica, no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFFPSentadoD.requestFocus();
                                                return;
                                            }
                                            if (Double.parseDouble(this.JTFFSPerimetroAbd.getValue().toString()) > 0.0d) {
                                                if (!this.JTFFSIMC.getText().isEmpty()) {
                                                    if (this.JTFFV02.getText().isEmpty()) {
                                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                        this.JTFFSIMC.requestFocus();
                                                        return;
                                                    }
                                                    if (Double.parseDouble(this.JTFFV02.getText().toString()) >= 0.0d) {
                                                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                                                            try {
                                                                String sql4 = "SELECT Id, Id_Atencion FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                                                                ResultSet xrs2 = this.xconsultasbd.traerRs(sql4);
                                                                if (xrs2.next()) {
                                                                    xrs2.first();
                                                                    String sql5 = "update h_examenfisico set TArtSentadoD='" + this.JTFFPSentadoD.getValue() + "', TArtSentadoS='" + this.JTFFPSentadoS.getValue() + "', TArtAcostadoD='" + this.JTFFPAcostadoD.getValue() + "', TArtAcostadoS='" + this.JTFFPAcostadoS.getValue() + "', TArtPieD='" + this.JTFFPPieD.getValue() + "', TArtPieS='" + this.JTFFPPieS.getValue() + "',ControlTA ='" + this.xcontrolado + "',FCardiaca ='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText().replaceAll(",", ".") + "', RImc='" + this.JLBCImc.getText() + "', RObecidad='" + this.JLBCObecidad.getText() + "', Observacion='" + this.JTPEFObservaciones.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Ps2='" + this.JTFFPs2.getText() + "', ControlDm='" + this.xcontroldm + "', ValorGlicemia='" + this.JTFFVHm.getValue() + "', PerimetroAbdominal='" + this.JTFFSPerimetroAbd.getValue() + "', RPAbdominal='" + this.JLBCPAbdominal.getText() + "', PerimetroCefalico='" + this.JTFFSPCefalico.getValue() + "', Id_CRiesgo='" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "', Embarazo='" + this.xembarazo + "', MetaHb='" + this.JTFFVHm.getValue() + "', PesoIdeal='" + this.JTFFSPIdeal.getValue() + "', PGrasa='" + this.JTFFSPGrasa.getText() + "', RPGrasa='" + this.JLBCPGrasa.getText() + "', EgEsfuerzo='" + this.JTFFEEsfuerzo.getValue() + "', Flexibilidad='" + this.JTFFFlexibilidad.getText() + "', RFlexibilidad='" + this.JLBCFlexibilidad.getText() + "', VMAX='" + this.JTFFV02.getText() + "', ClaVMAX='" + this.JLBCCicloErg.getText() + "', ResultadoVMAX='" + this.JLResultado.getText().replaceAll(",", ".") + "', FrecMax='" + this.JTFrecMax.getText() + "', FrecMaxAlc='" + this.JTFrecMaxAl.getText() + "', ResultadoFrecMax='" + this.JLResultadoFreMax.getText() + "', IRC='" + Double.parseDouble(this.IRC.getText()) + "', ClaIRC='" + this.JLBIRC.getText() + "', AutoExamenSeno='" + this.autoexamenseno + "', TASistolicaT='" + this.JTFFPSentadoTS.getValue() + "', ResultadoITB='" + this.JTFFCalculoITB.getValue() + "', ClaITB='" + this.JLBCITB.getText() + "',`PerimetroBranquial`=" + this.JTFFSPerimetroBranquial.getValue() + ", `PerimetroPantorrilla` = " + this.JTFFSPerimetroPantorrilla.getValue() + ", Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id ='" + xrs2.getString(1) + "') ";
                                                                    this.xconsultasbd.ejecutarSQL(sql5);
                                                                    this.xconsultasbd.cerrarConexionBd();
                                                                } else {
                                                                    String sql6 = "insert into h_examenfisico ( Id_Atencion, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA, FCardiaca, FRespiratoria, Talla, Peso, IMC, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, PerimetroAbdominal,AutoExamenSeno, PerimetroCefalico, Id_CRiesgo,Embarazo,MetaHb, `RImc`,RObecidad ,`RPAbdominal`, `PesoIdeal`, `PGrasa`, `RPGrasa`, `EgEsfuerzo`, `Flexibilidad`, `RFlexibilidad`,VMAX,ClaVMAX,ResultadoVMAX,FrecMax, FrecMaxAlc ,ResultadoFrecMax, IRC, ClaIRC, TASistolicaT, ResultadoITB, ClaITB,`PerimetroBranquial`,`PerimetroPantorrilla` , Fecha, UsuarioS ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFFPSentadoD.getValue() + "','" + this.JTFFPSentadoS.getValue() + "','" + this.JTFFPAcostadoD.getValue() + "','" + this.JTFFPAcostadoS.getValue() + "','" + this.JTFFPPieD.getValue() + "','" + this.JTFFPPieS.getValue() + "','" + this.xcontrolado + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText().replaceAll(",", ".") + "','" + this.JTPEFObservaciones.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + this.xcontroldm + "','" + this.JTFFVHm.getValue() + "','" + this.JTFFSPerimetroAbd.getValue() + "','" + this.autoexamenseno + "','" + this.JTFFSPCefalico.getValue() + "','" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "','" + this.xembarazo + "','" + this.JLMeta.getText() + "','" + this.JLBCImc.getText() + "','" + this.JLBCObecidad.getText() + "','" + this.JLBCPAbdominal.getText() + "','" + this.JTFFSPIdeal.getValue() + "','" + this.JTFFSPGrasa.getText() + "','" + this.JLBCPGrasa.getText() + "','" + this.JTFFEEsfuerzo.getValue() + "','" + this.JTFFFlexibilidad.getText() + "','" + this.JLBCFlexibilidad.getText() + "','" + this.JTFFV02.getText() + "','" + this.JLBCCicloErg.getText() + "','" + this.JLResultado.getText().replaceAll(",", ".") + "','" + this.JTFrecMax.getText() + "','" + this.JTFrecMaxAl.getText() + "','" + this.JLResultadoFreMax.getText() + "','" + Double.parseDouble(this.IRC.getText()) + "','" + this.JLBIRC.getText() + "','" + this.JTFFPSentadoTS.getValue() + "','" + this.JTFFCalculoITB.getValue() + "','" + this.JLBCITB.getText() + "', " + this.JTFFSPerimetroBranquial.getValue() + ",  " + this.JTFFSPerimetroPantorrilla.getValue() + ",'" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                    this.xidexamenf = this.xconsultasbd.ejecutarSQLId(sql6);
                                                                    this.xconsultasbd.cerrarConexionBd();
                                                                    mEnviarCorreoporPerimetroAbd();
                                                                }
                                                                xrs2.close();
                                                                this.xconsultasbd.cerrarConexionBd();
                                                            } catch (SQLException ex2) {
                                                                Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                                                            }
                                                        }
                                                        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa V02 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JTFFV02.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFFSIMC.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tVerifique el valor de la circunferencia cintura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFSPerimetroAbd.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tVerifique el valor de la presión siastólica, no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFPSentadoS.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFTemperatura.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSTalla.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSPeso.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFr.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFc.requestFocus();
                return;
            }
            if (this.JBTGuardar.isEnabled()) {
                if (this.JTFFSFc.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFc.requestFocus();
                    return;
                }
                if (Double.parseDouble(this.JTFFSFc.getText().toString()) >= 0.0d) {
                    if (this.JTFFSFr.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSFr.requestFocus();
                        return;
                    }
                    if (Double.parseDouble(this.JTFFSFr.getText().toString()) >= 0.0d) {
                        if (this.JTFFSPeso.getText().isEmpty()) {
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSPeso.requestFocus();
                            return;
                        }
                        if (Double.parseDouble(this.JTFFSPeso.getText().toString()) >= 0.0d || this.JCHExcepcion.isSelected()) {
                            if (this.JTFFSTalla.getText().isEmpty()) {
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFSTalla.requestFocus();
                                return;
                            }
                            if (Double.parseDouble(this.JTFFSTalla.getText().toString()) >= 0.0d) {
                                if (this.JTFFTemperatura.getText().isEmpty()) {
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFTemperatura.requestFocus();
                                    return;
                                }
                                if (Double.parseDouble(this.JTFFTemperatura.getText().toString()) >= 0.0d) {
                                    if (this.JTFFPs2.getText().isEmpty()) {
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFPs2.requestFocus();
                                        return;
                                    }
                                    if (Double.parseDouble(this.JTFFPs2.getText().toString()) >= 0.0d) {
                                        if (!this.JTFFSIMC.getText().isEmpty()) {
                                            if (this.JTFFV02.getText().isEmpty()) {
                                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFFSIMC.requestFocus();
                                                return;
                                            }
                                            if (Double.parseDouble(this.JTFFV02.getText().toString()) >= 0.0d) {
                                                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                                                    try {
                                                        String sql7 = "SELECT Id, Id_Atencion FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                                                        ResultSet xrs3 = this.xconsultasbd.traerRs(sql7);
                                                        if (xrs3.next()) {
                                                            xrs3.first();
                                                            String sql8 = "update h_examenfisico set TArtSentadoD='" + this.JTFFPSentadoD.getValue() + "', TArtSentadoS='" + this.JTFFPSentadoS.getValue() + "', TArtAcostadoD='" + this.JTFFPAcostadoD.getValue() + "', TArtAcostadoS='" + this.JTFFPAcostadoS.getValue() + "', TArtPieD='" + this.JTFFPPieD.getValue() + "', TArtPieS='" + this.JTFFPPieS.getValue() + "',ControlTA ='" + this.xcontrolado + "',FCardiaca ='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText().replaceAll(",", ".") + "', RImc='" + this.JLBCImc.getText() + "', RObecidad='" + this.JLBCObecidad.getText() + "', Observacion='" + this.JTPEFObservaciones.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Ps2='" + this.JTFFPs2.getText() + "', ControlDm='" + this.xcontroldm + "', ValorGlicemia='" + this.JTFFVHm.getValue() + "', PerimetroAbdominal='" + this.JTFFSPerimetroAbd.getValue() + "', RPAbdominal='" + this.JLBCPAbdominal.getText() + "', PerimetroCefalico='" + this.JTFFSPCefalico.getValue() + "', Id_CRiesgo='" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "', Embarazo='" + this.xembarazo + "', MetaHb='" + this.JTFFVHm.getValue() + "', PesoIdeal='" + this.JTFFSPIdeal.getValue() + "', PGrasa='" + this.JTFFSPGrasa.getText() + "', RPGrasa='" + this.JLBCPGrasa.getText() + "', EgEsfuerzo='" + this.JTFFEEsfuerzo.getValue() + "', Flexibilidad='" + this.JTFFFlexibilidad.getText() + "', RFlexibilidad='" + this.JLBCFlexibilidad.getText() + "', VMAX='" + this.JTFFV02.getText() + "', ClaVMAX='" + this.JLBCCicloErg.getText() + "', ResultadoVMAX='" + this.JLResultado.getText().replaceAll(",", ".") + "', FrecMax='" + this.JTFrecMax.getText() + "', FrecMaxAlc='" + this.JTFrecMaxAl.getText() + "', ResultadoFrecMax='" + this.JLResultadoFreMax.getText() + "', IRC='" + Double.parseDouble(this.IRC.getText()) + "', ClaIRC='" + this.JLBIRC.getText() + "', AutoExamenSeno='" + this.autoexamenseno + "', TASistolicaT='" + this.JTFFPSentadoTS.getValue() + "', ResultadoITB='" + this.JTFFCalculoITB.getValue() + "', ClaITB='" + this.JLBCITB.getText() + "',`PerimetroBranquial`=" + this.JTFFSPerimetroBranquial.getValue() + ", `PerimetroPantorrilla` = " + this.JTFFSPerimetroPantorrilla.getValue() + ", Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id ='" + xrs3.getString(1) + "') ";
                                                            this.xconsultasbd.ejecutarSQL(sql8);
                                                            this.xconsultasbd.cerrarConexionBd();
                                                        } else {
                                                            String sql9 = "insert into h_examenfisico ( Id_Atencion, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA, FCardiaca, FRespiratoria, Talla, Peso, IMC, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, PerimetroAbdominal,AutoExamenSeno, PerimetroCefalico, Id_CRiesgo,Embarazo,MetaHb, `RImc`,RObecidad ,`RPAbdominal`, `PesoIdeal`, `PGrasa`, `RPGrasa`, `EgEsfuerzo`, `Flexibilidad`, `RFlexibilidad`,VMAX,ClaVMAX,ResultadoVMAX,FrecMax, FrecMaxAlc ,ResultadoFrecMax, IRC, ClaIRC, TASistolicaT, ResultadoITB, ClaITB,`PerimetroBranquial`,`PerimetroPantorrilla` , Fecha, UsuarioS ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFFPSentadoD.getValue() + "','" + this.JTFFPSentadoS.getValue() + "','" + this.JTFFPAcostadoD.getValue() + "','" + this.JTFFPAcostadoS.getValue() + "','" + this.JTFFPPieD.getValue() + "','" + this.JTFFPPieS.getValue() + "','" + this.xcontrolado + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText().replaceAll(",", ".") + "','" + this.JTPEFObservaciones.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + this.xcontroldm + "','" + this.JTFFVHm.getValue() + "','" + this.JTFFSPerimetroAbd.getValue() + "','" + this.autoexamenseno + "','" + this.JTFFSPCefalico.getValue() + "','" + this.xidriesgo[this.JCBCRiesgo.getSelectedIndex()] + "','" + this.xembarazo + "','" + this.JLMeta.getText() + "','" + this.JLBCImc.getText() + "','" + this.JLBCObecidad.getText() + "','" + this.JLBCPAbdominal.getText() + "','" + this.JTFFSPIdeal.getValue() + "','" + this.JTFFSPGrasa.getText() + "','" + this.JLBCPGrasa.getText() + "','" + this.JTFFEEsfuerzo.getValue() + "','" + this.JTFFFlexibilidad.getText() + "','" + this.JLBCFlexibilidad.getText() + "','" + this.JTFFV02.getText() + "','" + this.JLBCCicloErg.getText() + "','" + this.JLResultado.getText().replaceAll(",", ".") + "','" + this.JTFrecMax.getText() + "','" + this.JTFrecMaxAl.getText() + "','" + this.JLResultadoFreMax.getText() + "','" + Double.parseDouble(this.IRC.getText()) + "','" + this.JLBIRC.getText() + "','" + this.JTFFPSentadoTS.getValue() + "','" + this.JTFFCalculoITB.getValue() + "','" + this.JLBCITB.getText() + "', " + this.JTFFSPerimetroBranquial.getValue() + ",  " + this.JTFFSPerimetroPantorrilla.getValue() + ",'" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                            this.xidexamenf = this.xconsultasbd.ejecutarSQLId(sql9);
                                                            this.xconsultasbd.cerrarConexionBd();
                                                            mEnviarCorreoporPerimetroAbd();
                                                        }
                                                        xrs3.close();
                                                        this.xconsultasbd.cerrarConexionBd();
                                                    } catch (SQLException ex3) {
                                                        Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                                                    }
                                                }
                                                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa V02 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFV02.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "\t\t\tEl IMC no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFSIMC.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Ps2 no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Temperatura no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFTemperatura.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSTalla.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Peso no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSPeso.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFSFr.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFc.requestFocus();
            }
        }
    }

    private void mBuscarDatosBd() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                String sql = "SELECT TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA , FCardiaca, FRespiratoria, Talla, Peso, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, h_atencion.TipoGuardado, PerimetroAbdominal, PerimetroCefalico, `h_tipo_riesgo`.`Nbre`, h_examenfisico.Embarazo,  IMC, PGrasa, RPGrasa,EgEsfuerzo,Flexibilidad,RFlexibilidad, VMAX, ClaVMAX, ResultadoVMAX,FrecMax, FrecMaxAlc ,ResultadoFrecMax,IRC, ClaIRC, TASistolicaT, ResultadoITB, ClaITB, RImc ,RObecidad, AutoExamenSeno, PerimetroBranquial,PerimetroPantorrilla  FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN `h_tipo_riesgo`  ON (h_examenfisico.`Id_CRiesgo` = h_tipo_riesgo.Id) WHERE Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                ResultSet xrs = this.xconsultasbd.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFFPSentadoD.setValue(Integer.valueOf(xrs.getInt(1)));
                    this.JTFFPSentadoS.setValue(Integer.valueOf(xrs.getInt(2)));
                    this.JTFFPAcostadoD.setValue(Integer.valueOf(xrs.getInt(3)));
                    this.JTFFPAcostadoS.setValue(Integer.valueOf(xrs.getInt(4)));
                    this.JTFFPPieD.setValue(Integer.valueOf(xrs.getInt(5)));
                    this.JTFFPPieS.setValue(Integer.valueOf(xrs.getInt(6)));
                    if (xrs.getInt(7) == 0) {
                        this.JCHCobntrolado.setSelected(true);
                    } else {
                        this.JCHCobntrolado.setSelected(true);
                    }
                    this.JTFFSFc.setText("" + xrs.getInt(8));
                    this.JTFFSFr.setText("" + xrs.getInt(9));
                    this.JTFFSTalla.setText("" + xrs.getString(10));
                    this.JTFFSPeso.setText("" + xrs.getString(11));
                    this.JTPEFObservaciones.setText(xrs.getString(12));
                    this.JTFFTemperatura.setText("" + xrs.getDouble(13));
                    this.JTFFPs2.setText("" + xrs.getInt(14));
                    if (xrs.getInt(15) == 0) {
                        this.JCHCobntrolado1.setSelected(true);
                    } else {
                        this.JCHCobntrolado1.setSelected(true);
                    }
                    this.JTFFVHm.setValue(Double.valueOf(xrs.getDouble(16)));
                    if (xrs.getInt(17) == 1 && !Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                        this.JBTGuardar.setEnabled(false);
                    } else {
                        this.JBTGuardar.setEnabled(true);
                    }
                    this.JTFFSPerimetroAbd.setValue(Double.valueOf(xrs.getDouble(18)));
                    this.JTFFSPCefalico.setValue(Double.valueOf(xrs.getDouble(19)));
                    this.JCBCRiesgo.setSelectedItem(xrs.getString(20));
                    this.JTFFSPGrasa.setText("" + xrs.getLong(23));
                    this.JLBCPGrasa.setText(xrs.getString("RPGrasa"));
                    this.JTFFEEsfuerzo.setValue(Double.valueOf(xrs.getDouble("EgEsfuerzo")));
                    this.JTFFFlexibilidad.setText("" + xrs.getDouble("Flexibilidad"));
                    this.JLBCFlexibilidad.setText(xrs.getString("RFlexibilidad"));
                    this.JTFFV02.setText(xrs.getString("VMAX"));
                    this.JLBCCicloErg.setText(xrs.getString("ClaVMAX"));
                    this.JLResultado.setText(xrs.getString("ResultadoVMAX"));
                    this.JTFrecMax.setText(xrs.getString("FrecMax"));
                    this.JTFrecMaxAl.setText(xrs.getString("FrecMaxAlc"));
                    this.JLResultadoFreMax.setText(xrs.getString("ResultadoFrecMax"));
                    this.IRC.setText(xrs.getString("IRC"));
                    this.JLBIRC.setText(xrs.getString("ClaIRC"));
                    this.JTFFPSentadoTS.setValue(Integer.valueOf(xrs.getInt("TASistolicaT")));
                    this.JTFFCalculoITB.setValue(Double.valueOf(xrs.getDouble("ResultadoITB")));
                    this.JLBCITB.setText(xrs.getString("ClaITB"));
                    this.JLBCImc.setText(xrs.getString("RImc"));
                    this.JLBCObecidad.setText(xrs.getString("RObecidad"));
                    if (xrs.getLong(21) == 1) {
                        this.JRBSi.setSelected(true);
                    } else {
                        this.JRBNO.setSelected(true);
                    }
                    if (xrs.getString("AutoExamenSeno").equals("NO")) {
                        this.JCH_Autoexamenseno.setSelected(false);
                    } else {
                        this.JCH_Autoexamenseno.setSelected(true);
                    }
                    this.JTFFSPerimetroBranquial.setValue(Integer.valueOf(xrs.getInt("PerimetroBranquial")));
                    this.JTFFSPerimetroPantorrilla.setValue(Integer.valueOf(xrs.getInt("PerimetroPantorrilla")));
                    mCalcularImc();
                    if (Principal.informacionIps.getEsFpz().intValue() == 1 && xrs.getInt(1) == 0) {
                        mCargaDatosSignosV();
                    }
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                } else if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                    mCargaDatosSignosV();
                    mCargarTriage();
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCargarTriage() {
        try {
            this.xsql = "SELECT `Id`, `TArtSentadoD`, `TArtSentadoS`, `Clasificacion`, `FechaTriage`, `HoraTriage`, `MotivoConsulta`, `FCardiaca`, `FRespiratoria`, `Talla`, `Peso`, `IMC`, `Temperatura`, `Ps2` FROM  `h_triage` WHERE (`Estado` =0 AND `IdIngreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFFPSentadoD.setValue(Integer.valueOf(xrs.getInt(2)));
                this.JTFFPSentadoS.setValue(Integer.valueOf(xrs.getInt(3)));
                this.JTFFSFc.setText("" + xrs.getInt(8));
                this.JTFFSFr.setText("" + xrs.getInt(9));
                this.JTFFSTalla.setText("" + xrs.getDouble(10));
                this.JTFFSPeso.setText("" + xrs.getDouble(11));
                this.JTFFTemperatura.setText("" + xrs.getDouble(13));
                this.JTFFPs2.setText("" + xrs.getInt(14));
                mPerder_Foco_Talla();
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargaDatosSignosV() {
        try {
            this.xsql = "SELECT  `TArterialD` , `TArterialS` , `FCardiaca` , `FRespiratoria` , `Talla` , `Peso` , `IMC` , `Temperatura`  , `Ps2` , `PerimetroAbdominal` FROM `h_au_rsignos_vitales` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1) ORDER BY `Fecha` DESC ";
            ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFFPSentadoD.setValue(Integer.valueOf(xrs.getInt(1)));
                this.JTFFPSentadoS.setValue(Integer.valueOf(xrs.getInt(2)));
                this.JTFFSFc.setText("" + xrs.getInt(3));
                this.JTFFSFr.setText("" + xrs.getInt(4));
                this.JTFFSTalla.setText("" + xrs.getDouble(5));
                this.JTFFSPeso.setText("" + xrs.getDouble(6));
                this.JTFFTemperatura.setText("" + xrs.getDouble(8));
                this.JTFFPs2.setText("" + xrs.getInt(9));
                this.JTFFSPerimetroAbd.setValue(Double.valueOf(xrs.getDouble(10)));
                mCalcularImc();
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloHistoricoD() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Resultado", "Meta"}) { // from class: Historia.JPAExamenFisico.62
            Class[] types = {Integer.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoD.setModel(this.xmodelo);
        this.JTHistoricoD.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistoricoD.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistoricoD.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscarresultado() {
        try {
            mModeloHistoricoD();
            String sql = "SELECT  `h_examenfisico`.`Id_Atencion`, `h_atencion`.`Fecha_Atencion`, `h_examenfisico`.`ValorGlicemia`, `h_examenfisico`.`MetaHb` FROM `h_examenfisico` INNER JOIN `h_atencion` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_examenfisico`.`Id_Usuario_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarMeta() {
        try {
            this.JTFFVHm.setValue(0);
            String sql = "SELECT `MetaHbA1C` FROM `g_usuarioxprograma` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            System.out.println("Consulta meta -> " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getString(1) == null) {
                    this.JLMeta.setText("0");
                } else {
                    this.JLMeta.setText(xrs.getString(1));
                }
            } else {
                this.JLMeta.setText("0");
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIRC() {
        double valor = Double.parseDouble(this.JTFrecMaxAl.getText()) - Double.parseDouble(this.IRC.getText());
        if (valor <= 20.0d) {
            this.JLBIRC.setText("MUY MALO");
            return;
        }
        if (valor >= 21.0d && valor <= 29.0d) {
            this.JLBIRC.setText("MALO");
            return;
        }
        if (valor >= 30.0d && valor <= 39.0d) {
            this.JLBIRC.setText("REGULAR");
            return;
        }
        if (valor >= 40.0d && valor <= 49.0d) {
            this.JLBIRC.setText("BUENO");
        } else if (valor >= 50.0d) {
            this.JLBIRC.setText("MUY BUENO");
        }
    }

    public void mGenerarGrafico() {
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Gráfico Hb A1C", "Valores", "Meta", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.BLACK);
        xyplot.setRangeGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        BufferedImage bufferedImage = jfreechart.createBufferedImage(311, 219);
        this.JLGrafico.setIcon(new ImageIcon(bufferedImage));
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        for (int i = 0; i < this.JTHistoricoD.getRowCount(); i++) {
            XYSeries series1 = new XYSeries(this.JTHistoricoD.getValueAt(i, 1).toString());
            for (int x = 2; x < 3; x++) {
                series1.add(Integer.parseInt(this.JTHistoricoD.getColumnName(x)), Integer.parseInt(this.JTHistoricoD.getValueAt(i, x).toString()));
            }
            xyseriescollection.addSeries(series1);
        }
        return xyseriescollection;
    }

    private void mCalcularITB(Double xPSBrazo, Double xPSTobillo) {
        Double xITB = Double.valueOf(xPSTobillo.doubleValue() / xPSBrazo.doubleValue());
        this.JTFFCalculoITB.setValue(xITB);
        if (xITB.doubleValue() < 0.5d) {
            this.JLBCITB.setForeground(Color.red);
            this.JLBCITB.setText("Enfermedad arterial obstructiva periférica grave");
            return;
        }
        if (xITB.doubleValue() >= 0.5d && xITB.doubleValue() < 0.7d) {
            this.JLBCITB.setForeground(new Color(255, 204, 51));
            this.JLBCITB.setText("Enfermedad arterial obstructiva periférica moderada");
            return;
        }
        if (xITB.doubleValue() >= 0.7d && xITB.doubleValue() < 0.9d) {
            this.JLBCITB.setForeground(Color.yellow);
            this.JLBCITB.setText("Enfermedad arterial obstructiva periférica leve");
        } else if (xITB.doubleValue() >= 0.9d && xITB.doubleValue() <= 1.4d) {
            this.JLBCITB.setForeground(new Color(0, 103, 0));
            this.JLBCITB.setText("Normal");
        } else if (xITB.doubleValue() > 1.4d) {
            this.JLBCITB.setForeground(Color.red);
            this.JLBCITB.setText("Calcificación arterial, indica alto riesgo cardiovascular");
        }
    }
}
