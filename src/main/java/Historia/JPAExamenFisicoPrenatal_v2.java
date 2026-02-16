package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.DetalleExamenFisicoDAO;
import com.genoma.plus.dao.historia.ExamenFisicoDAO;
import com.genoma.plus.dao.impl.historia.DetalleExamenFisicoDAOImpl;
import com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl;
import com.genoma.plus.dto.historia.DetalleExamenFisicoNDTO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAExamenFisicoPrenatal_v2.class */
public class JPAExamenFisicoPrenatal_v2 extends JPanel {
    private static clasesHistoriaCE xclase;
    private String[] xidriesgo;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private Imagen Grafica;
    private Grafica2 GraficaPM;
    private Grafica2 GraficaPresion;
    private Grafica2 GraficaIMC;
    private File Directorio;
    private ExamenFisicoDAO examenFisicoDAO;
    private DetalleExamenFisicoDAO detalleExamenFisicoDAO;
    private ButtonGroup JBGControlDM;
    private ButtonGroup JBGControlado;
    private JButton JBTGuardar;
    private JComboBox JCBCuelloU;
    private JComboBox JCBEdemas;
    private JComboBox JCBMovFetalH1;
    private JComboBox JCBMovFetalH2;
    private JComboBox JCBPresentacionFH1;
    private JComboBox JCBPresentacionFH2;
    private JComboBox JCBSPEclampsia;
    private JComboBox JCBSaludOral;
    private JCheckBox JCHCefaleaPersist;
    private JCheckBox JCHFlujoVaginal;
    private JCheckBox JCHNauseasVomito;
    private JCheckBox JCHSintomatologiaU;
    private JCheckBox JCH_EstadoInicial;
    private JCheckBox JCH_ValorporDefecto;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPGraficaIMC;
    private JPanel JPGrafico;
    private JPanel JPGraficoPM;
    private JPanel JPGraficoPresion;
    private JPanel JPIExamenFisico;
    private JPanel JPIGraficoPAD;
    private JPanel JPIGraficoPM;
    private JPanel JPIGraficos;
    private JPanel JPIPresion;
    private JPanel JPSignosVitales;
    public JTextFieldValidator JSPFcfh1;
    public JTextFieldValidator JSPFcfh2;
    private JScrollPane JSPHistorico;
    private JScrollPane JSP_Hallazgo;
    public JTable JTBHistorico;
    private JTable JTB_Hallazgo;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSAlturaUterina;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSSGestacion;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    private JTabbedPane JTPDatosE;
    private JPanel jPanel1;
    private Metodos xmetodo = new Metodos();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private int xcontrolado = 0;
    private int xcontroldm = 0;
    private int xsintomatologiaU = 0;
    private int xflujovaginal = 0;
    private int xcefalea = 0;
    private int xnauseasvomito = 0;
    private double imc = 0.0d;
    private String xidexamenf = "0";

    public JPAExamenFisicoPrenatal_v2(clasesHistoriaCE xclase2) {
        initComponents();
        xclase = xclase2;
        springStart();
        mCargarDatosTabla();
        mBuscarDatosBd();
        mBuscaHistorico();
        mIniciaPaneles();
        if ((Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") && Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue() == 444893) || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.JTFFPs2.setEnabled(false);
            this.JTFFPs2.setVisible(false);
        }
    }

    public JPAExamenFisicoPrenatal_v2() {
    }

    /* JADX WARN: Type inference failed for: r3v111, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v176, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGControlado = new ButtonGroup();
        this.JBGControlDM = new ButtonGroup();
        this.JTPDatosE = new JTabbedPane();
        this.JPIExamenFisico = new JPanel();
        this.JPSignosVitales = new JPanel();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JCBPresentacionFH1 = new JComboBox();
        this.JCBPresentacionFH2 = new JComboBox();
        this.JCBMovFetalH1 = new JComboBox();
        this.JCBMovFetalH2 = new JComboBox();
        this.JCBCuelloU = new JComboBox();
        this.JCBEdemas = new JComboBox();
        this.JCBSPEclampsia = new JComboBox();
        this.JCBSaludOral = new JComboBox();
        this.JBTGuardar = new JButton();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JTFFSSGestacion = new JTextFieldValidator();
        this.JTFFSAlturaUterina = new JTextFieldValidator();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JSPFcfh1 = new JTextFieldValidator();
        this.JSPFcfh2 = new JTextFieldValidator();
        this.JCHSintomatologiaU = new JCheckBox();
        this.JCHFlujoVaginal = new JCheckBox();
        this.JCHCefaleaPersist = new JCheckBox();
        this.JCHNauseasVomito = new JCheckBox();
        this.JCH_EstadoInicial = new JCheckBox();
        this.JCH_ValorporDefecto = new JCheckBox();
        this.JSP_Hallazgo = new JScrollPane();
        this.JTB_Hallazgo = new JTable();
        this.JPIGraficos = new JPanel();
        this.JPGrafico = new JPanel();
        this.JPIGraficoPM = new JPanel();
        this.JPGraficoPM = new JPanel();
        this.jPanel1 = new JPanel();
        this.JPGraficaIMC = new JPanel();
        this.JPIGraficoPAD = new JPanel();
        this.JPGraficoPresion = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        setMaximumSize(null);
        setName("jpaexamenfisicoprenatal_v2");
        addMouseListener(new MouseAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.1
            public void mouseExited(MouseEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.formMouseExited(evt);
            }
        });
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.2
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.formAncestorRemoved(evt);
            }
        });
        this.JTPDatosE.setForeground(new Color(0, 103, 0));
        this.JTPDatosE.setFont(new Font("Arial", 1, 12));
        this.JTPDatosE.addChangeListener(new ChangeListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.3
            public void stateChanged(ChangeEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTPDatosEStateChanged(evt);
            }
        });
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.4
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.5
            public void focusLost(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoS, new AbsoluteConstraints(10, 20, 45, 25));
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.6
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.7
            public void focusLost(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoD, new AbsoluteConstraints(80, 20, 45, 25));
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JPIPresion.add(this.JLBPBSentado, new AbsoluteConstraints(70, 20, -1, 23));
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        this.JPIPresion.add(this.JLBPSentado1, new AbsoluteConstraints(10, 50, 120, -1));
        this.JCBPresentacionFH1.setFont(new Font("Arial", 1, 12));
        this.JCBPresentacionFH1.setModel(new DefaultComboBoxModel(new String[]{"NO APLICA", "PODALICA", "CEFÁLICA", "TRANSVERSA", "VARIABLE", "OBLICUO"}));
        this.JCBPresentacionFH1.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Fetal H1", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBPresentacionFH2.setFont(new Font("Arial", 1, 12));
        this.JCBPresentacionFH2.setModel(new DefaultComboBoxModel(new String[]{"NO APLICA", "PODALICA", "CEFÁLICA", "TRANSVERSA", "VARIABLE", "OBLICUO"}));
        this.JCBPresentacionFH2.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Fetal H2", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBMovFetalH1.setFont(new Font("Arial", 1, 12));
        this.JCBMovFetalH1.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBMovFetalH1.setBorder(BorderFactory.createTitledBorder((Border) null, "Mov. Fetal H1", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBMovFetalH2.setFont(new Font("Arial", 1, 12));
        this.JCBMovFetalH2.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBMovFetalH2.setBorder(BorderFactory.createTitledBorder((Border) null, "Mov. Fetal H2", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBCuelloU.setFont(new Font("Arial", 1, 12));
        this.JCBCuelloU.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBCuelloU.setToolTipText("Valoracion Cuello Uterino");
        this.JCBCuelloU.setBorder(BorderFactory.createTitledBorder((Border) null, "VCuello Uterino", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBEdemas.setFont(new Font("Arial", 1, 12));
        this.JCBEdemas.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBEdemas.setBorder(BorderFactory.createTitledBorder((Border) null, "Edemas", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBSPEclampsia.setFont(new Font("Arial", 1, 12));
        this.JCBSPEclampsia.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBSPEclampsia.setBorder(BorderFactory.createTitledBorder((Border) null, "Síntomas premonitorios eclampsia", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JCBSaludOral.setFont(new Font("Arial", 1, 12));
        this.JCBSaludOral.setModel(new DefaultComboBoxModel(new String[]{"NO REALIZADA\t", "REALIZADA"}));
        this.JCBSaludOral.setBorder(BorderFactory.createTitledBorder((Border) null, "Salud Oral", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.8
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.9
            public void keyPressed(KeyEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.10
            public void focusGained(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.11
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPAExamenFisicoPrenatal_v2.12
            public void focusGained(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.13
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        this.JTFFSSGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSSGestacion.setHorizontalAlignment(0);
        this.JTFFSSGestacion.setText("0");
        this.JTFFSSGestacion.setToolTipText("Semana de Gestación");
        this.JTFFSSGestacion.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSSGestacion.setFocusAccelerator('C');
        this.JTFFSSGestacion.setFont(new Font("Arial", 1, 12));
        this.JTFFSSGestacion.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.14
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSSGestacionActionPerformed(evt);
            }
        });
        this.JTFFSAlturaUterina.setBorder(BorderFactory.createTitledBorder((Border) null, "Altura Uterina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSAlturaUterina.setHorizontalAlignment(0);
        this.JTFFSAlturaUterina.setText("0");
        this.JTFFSAlturaUterina.setToolTipText("Altura Uterina");
        this.JTFFSAlturaUterina.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSAlturaUterina.setFocusAccelerator('C');
        this.JTFFSAlturaUterina.setFont(new Font("Arial", 1, 12));
        this.JTFFSAlturaUterina.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.15
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSAlturaUterinaActionPerformed(evt);
            }
        });
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiaca");
        this.JTFFSFc.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.16
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.17
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFSFrActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Temp. (°)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0.0-9]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.18
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Presion de Oxigeno");
        this.JTFFPs2.setExprecionRegular("^[0.0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.19
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JSPFcfh1.setBorder(BorderFactory.createTitledBorder((Border) null, "FCF-H1", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFcfh1.setHorizontalAlignment(0);
        this.JSPFcfh1.setText("0");
        this.JSPFcfh1.setToolTipText("Frecuencia fetal hijo 1");
        this.JSPFcfh1.setExprecionRegular("^[0.0-9]*$");
        this.JSPFcfh1.setFocusAccelerator('C');
        this.JSPFcfh1.setFont(new Font("Arial", 1, 12));
        this.JSPFcfh1.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.20
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JSPFcfh1ActionPerformed(evt);
            }
        });
        this.JSPFcfh2.setBorder(BorderFactory.createTitledBorder((Border) null, "FCF-H2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFcfh2.setHorizontalAlignment(0);
        this.JSPFcfh2.setText("0");
        this.JSPFcfh2.setToolTipText("Frecuencia fetal hijo 1");
        this.JSPFcfh2.setExprecionRegular("^[0.0-9]*$");
        this.JSPFcfh2.setFocusAccelerator('C');
        this.JSPFcfh2.setFont(new Font("Arial", 1, 12));
        this.JSPFcfh2.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.21
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JSPFcfh2ActionPerformed(evt);
            }
        });
        this.JCHSintomatologiaU.setFont(new Font("Arial", 1, 12));
        this.JCHSintomatologiaU.setText("Sintomatología Urinaria");
        this.JCHSintomatologiaU.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.22
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCHSintomatologiaUActionPerformed(evt);
            }
        });
        this.JCHFlujoVaginal.setFont(new Font("Arial", 1, 12));
        this.JCHFlujoVaginal.setText("Flujo vaginal");
        this.JCHFlujoVaginal.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.23
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCHFlujoVaginalActionPerformed(evt);
            }
        });
        this.JCHCefaleaPersist.setFont(new Font("Arial", 1, 12));
        this.JCHCefaleaPersist.setText("Cefalea Persistente");
        this.JCHCefaleaPersist.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.24
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCHCefaleaPersistActionPerformed(evt);
            }
        });
        this.JCHNauseasVomito.setFont(new Font("Arial", 1, 12));
        this.JCHNauseasVomito.setText("Nauseas y Vomito");
        this.JCHNauseasVomito.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.25
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCHNauseasVomitoActionPerformed(evt);
            }
        });
        this.JCH_EstadoInicial.setFont(new Font("Arial", 1, 12));
        this.JCH_EstadoInicial.setForeground(Color.red);
        this.JCH_EstadoInicial.setSelected(true);
        this.JCH_EstadoInicial.setText("Estado Inicial");
        this.JCH_EstadoInicial.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.26
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCH_EstadoInicialActionPerformed(evt);
            }
        });
        this.JCH_ValorporDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto.setForeground(Color.red);
        this.JCH_ValorporDefecto.setText("No Patologico");
        this.JCH_ValorporDefecto.addActionListener(new ActionListener() { // from class: Historia.JPAExamenFisicoPrenatal_v2.27
            public void actionPerformed(ActionEvent evt) {
                JPAExamenFisicoPrenatal_v2.this.JCH_ValorporDefectoActionPerformed(evt);
            }
        });
        this.JSP_Hallazgo.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Hallazgo.setFont(new Font("Arial", 1, 12));
        this.JTB_Hallazgo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Hallazgo.setRowHeight(50);
        this.JTB_Hallazgo.setSelectionMode(0);
        this.JSP_Hallazgo.setViewportView(this.JTB_Hallazgo);
        GroupLayout JPSignosVitalesLayout = new GroupLayout(this.JPSignosVitales);
        this.JPSignosVitales.setLayout(JPSignosVitalesLayout);
        JPSignosVitalesLayout.setHorizontalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addContainerGap().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Hallazgo).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSSGestacion, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFSAlturaUterina, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFSFc, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFSFr, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFTemperatura, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFPs2, -2, 100, -2)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSTalla, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFSPeso, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JTFFSIMC, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JSPFcfh1, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JSPFcfh2, -2, 100, -2).addGap(10, 10, 10).addComponent(this.JCBCuelloU, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIPresion, -2, 142, -2)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JCH_EstadoInicial).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_ValorporDefecto)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSPEclampsia, 0, -1, 32767).addComponent(this.JCBPresentacionFH1, -2, 140, -2)).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCBPresentacionFH2, -2, 140, -2).addGap(10, 10, 10).addComponent(this.JCBMovFetalH1, -2, 90, -2).addGap(10, 10, 10).addComponent(this.JCBMovFetalH2, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEdemas, -2, 102, -2)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSaludOral, -2, 456, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHNauseasVomito).addComponent(this.JCHSintomatologiaU).addComponent(this.JCHCefaleaPersist).addComponent(this.JCHFlujoVaginal)))).addGap(0, 69, 32767)).addComponent(this.JBTGuardar, -1, -1, 32767)).addContainerGap()));
        JPSignosVitalesLayout.setVerticalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPSignosVitalesLayout.createSequentialGroup().addContainerGap().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTemperatura, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSSGestacion, -2, 50, -2).addComponent(this.JTFFSAlturaUterina, -2, 50, -2).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2))).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPSignosVitalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFcfh1, -2, 50, -2).addComponent(this.JSPFcfh2, -2, 50, -2).addComponent(this.JCBCuelloU, -2, 50, -2)).addComponent(this.JTFFSIMC, GroupLayout.Alignment.TRAILING, -2, 50, -2))))).addComponent(this.JPIPresion, -2, 75, -2)).addGap(10, 10, 10).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addComponent(this.JCHFlujoVaginal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCefaleaPersist).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHNauseasVomito).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSintomatologiaU)).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMovFetalH1, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPresentacionFH1, -2, 50, -2).addComponent(this.JCBPresentacionFH2, -2, 50, -2)).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMovFetalH2, -2, 50, -2).addComponent(this.JCBEdemas, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSPEclampsia, -2, 48, -2).addComponent(this.JCBSaludOral, -2, 48, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_ValorporDefecto).addComponent(this.JCH_EstadoInicial)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Hallazgo, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 50, -2).addGap(12, 12, 12)));
        GroupLayout JPIExamenFisicoLayout = new GroupLayout(this.JPIExamenFisico);
        this.JPIExamenFisico.setLayout(JPIExamenFisicoLayout);
        JPIExamenFisicoLayout.setHorizontalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPSignosVitales, -2, -1, -2).addContainerGap(17, 32767)));
        JPIExamenFisicoLayout.setVerticalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addComponent(this.JPSignosVitales, -1, -1, 32767).addContainerGap()));
        this.JTPDatosE.addTab("EXÁMEN FÍSICO", this.JPIExamenFisico);
        this.JPGrafico.setBorder(BorderFactory.createTitledBorder(""));
        this.JPGrafico.setMaximumSize(new Dimension(516, 456));
        this.JPGrafico.setPreferredSize(new Dimension(516, 456));
        this.JPGrafico.setLayout((LayoutManager) null);
        GroupLayout JPIGraficosLayout = new GroupLayout(this.JPIGraficos);
        this.JPIGraficos.setLayout(JPIGraficosLayout);
        JPIGraficosLayout.setHorizontalGroup(JPIGraficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGraficosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPGrafico, -2, -1, -2).addGap(473, 473, 473)));
        JPIGraficosLayout.setVerticalGroup(JPIGraficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPGrafico, -2, -1, -2));
        this.JTPDatosE.addTab(" ALTURA UTERINA ", this.JPIGraficos);
        this.JPGraficoPM.setMaximumSize(new Dimension(410, 371));
        this.JPGraficoPM.setMinimumSize(new Dimension(410, 371));
        this.JPGraficoPM.setPreferredSize(new Dimension(410, 371));
        GroupLayout JPGraficoPMLayout = new GroupLayout(this.JPGraficoPM);
        this.JPGraficoPM.setLayout(JPGraficoPMLayout);
        JPGraficoPMLayout.setHorizontalGroup(JPGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 410, 32767));
        JPGraficoPMLayout.setVerticalGroup(JPGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 371, 32767));
        GroupLayout JPIGraficoPMLayout = new GroupLayout(this.JPIGraficoPM);
        this.JPIGraficoPM.setLayout(JPIGraficoPMLayout);
        JPIGraficoPMLayout.setHorizontalGroup(JPIGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGraficoPMLayout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficoPM, -2, -1, -2).addGap(579, 579, 579)));
        JPIGraficoPMLayout.setVerticalGroup(JPIGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGraficoPMLayout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficoPM, -2, -1, -2).addGap(121, 121, 121)));
        this.JTPDatosE.addTab("PESO MATERNO", this.JPIGraficoPM);
        this.JPGraficaIMC.setMaximumSize(new Dimension(510, 443));
        this.JPGraficaIMC.setMinimumSize(new Dimension(510, 443));
        this.JPGraficaIMC.setPreferredSize(new Dimension(510, 443));
        GroupLayout JPGraficaIMCLayout = new GroupLayout(this.JPGraficaIMC);
        this.JPGraficaIMC.setLayout(JPGraficaIMCLayout);
        JPGraficaIMCLayout.setHorizontalGroup(JPGraficaIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 785, 32767));
        JPGraficaIMCLayout.setVerticalGroup(JPGraficaIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 486, 32767));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33).addComponent(this.JPGraficaIMC, -2, 785, -2).addGap(177, 177, 177)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficaIMC, -1, 499, 32767).addContainerGap()));
        this.JTPDatosE.addTab("IMC EDAD GESTACIONAL", this.jPanel1);
        this.JPGraficoPresion.setMaximumSize(new Dimension(450, 450));
        this.JPGraficoPresion.setMinimumSize(new Dimension(450, 450));
        this.JPGraficoPresion.setPreferredSize(new Dimension(450, 450));
        GroupLayout JPGraficoPresionLayout = new GroupLayout(this.JPGraficoPresion);
        this.JPGraficoPresion.setLayout(JPGraficoPresionLayout);
        JPGraficoPresionLayout.setHorizontalGroup(JPGraficoPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 450, 32767));
        JPGraficoPresionLayout.setVerticalGroup(JPGraficoPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 450, 32767));
        GroupLayout JPIGraficoPADLayout = new GroupLayout(this.JPIGraficoPAD);
        this.JPIGraficoPAD.setLayout(JPIGraficoPADLayout);
        JPIGraficoPADLayout.setHorizontalGroup(JPIGraficoPADLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGraficoPADLayout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficoPresion, -2, -1, -2).addGap(539, 539, 539)));
        JPIGraficoPADLayout.setVerticalGroup(JPIGraficoPADLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGraficoPADLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPGraficoPresion, -2, -1, -2).addGap(45, 45, 45)));
        this.JTPDatosE.addTab("PRESIÓN ARTERIAL DIASTÓLICA", this.JPIGraficoPAD);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPHistorico)).addComponent(this.JTPDatosE, -2, 927, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -2, 145, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoS.getText()).intValue(), 0);
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
    public void formAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosEStateChanged(ChangeEvent evt) {
    }

    private void mIniciaPaneles() {
        this.Grafica = null;
        this.Grafica = new Imagen(this);
        this.JPGrafico.add(this.Grafica);
        this.JPGrafico.repaint();
        this.GraficaPM = null;
        this.GraficaPM = new Grafica2(this, 0, 11, 24, 410, 371, "curva_peso_materno", 1);
        this.JPGraficoPM.add(this.GraficaPM);
        this.JPGraficoPM.repaint();
        this.GraficaPresion = null;
        this.GraficaPresion = new Grafica2(this, 0, 7, 25, 450, 450, "curva_presion_arterial", 1);
        this.JPGraficoPresion.add(this.GraficaPresion);
        this.JPGraficoPresion.repaint();
        this.GraficaIMC = null;
        this.GraficaIMC = new Grafica2(this, 0, 10, 51, 680, 479, "grafico-IMC-EdadGestacional-2465_New", 1);
        this.JPGraficaIMC.add(this.GraficaIMC);
        this.JPGraficaIMC.repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSSGestacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSAlturaUterinaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFcfh1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFcfh2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSintomatologiaUActionPerformed(ActionEvent evt) {
        if (this.JCHSintomatologiaU.isSelected()) {
            this.xsintomatologiaU = 1;
        } else {
            this.xsintomatologiaU = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFlujoVaginalActionPerformed(ActionEvent evt) {
        if (this.JCHFlujoVaginal.isSelected()) {
            this.xflujovaginal = 1;
        } else {
            this.xflujovaginal = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCefaleaPersistActionPerformed(ActionEvent evt) {
        if (this.JCHCefaleaPersist.isSelected()) {
            this.xcefalea = 1;
        } else {
            this.xcefalea = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNauseasVomitoActionPerformed(ActionEvent evt) {
        if (this.JCHNauseasVomito.isSelected()) {
            this.xnauseasvomito = 1;
        } else {
            this.xnauseasvomito = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EstadoInicialActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
            this.xmodelo1.setValueAt("", i, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto.isSelected()) {
            for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
                if (this.xmodelo1.getValueAt(i, 2).toString().equals("")) {
                    this.xmodelo1.setValueAt(this.xmodelo1.getValueAt(i, 4).toString(), i, 2);
                }
            }
        }
    }

    private void calcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("00");
            this.imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFSIMC.setText(String.valueOf(formato.format(this.imc)));
            return;
        }
        this.JTFFSIMC.setText("0.0");
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

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.examenFisicoDAO = (ExamenFisicoDAOImpl) classPathXmlApplicationContext.getBean("examenFisicoDAOImpl");
        this.detalleExamenFisicoDAO = (DetalleExamenFisicoDAOImpl) classPathXmlApplicationContext.getBean("detalleExamenFisicoDAOImpl");
    }

    public void mGrabarBd() {
        if (this.JBTGuardar.isEnabled()) {
            if (Double.parseDouble(this.JTFFSFc.getText().toString()) < 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFc.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSFr.getText().toString()) < 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFr.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSPeso.getText().toString()) < 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl Pesos no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSPeso.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSTalla.getText().toString()) >= 0.0d) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null || clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0) {
                        try {
                            String sql = "SELECT Id, Id_Atencion FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                            ResultSet xrs = this.xconsultasbd.traerRs(sql);
                            if (xrs.next()) {
                                xrs.first();
                                String sql2 = "update h_examenfisico set TArtSentadoD='" + this.JTFFPSentadoD.getValue() + "', TArtSentadoS='" + this.JTFFPSentadoS.getValue() + "', Id_Usuario_Programa='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "',FCardiaca ='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Ps2='" + this.JTFFPs2.getText() + "', SGestacion='" + this.JTFFSSGestacion.getText() + "', AlturaUterina='" + this.JTFFSAlturaUterina.getText() + "', FCFh1='" + this.JSPFcfh1.getText() + "', FCFh2='" + this.JSPFcfh2.getText() + "', PFetalH1='" + this.JCBPresentacionFH1.getSelectedItem() + "', PFetalH2='" + this.JCBPresentacionFH2.getSelectedItem() + "', MovFetalH1='" + this.JCBMovFetalH1.getSelectedItem() + "', MovFetalH2='" + this.JCBMovFetalH2.getSelectedItem() + "', VCuelloUterino='" + this.JCBCuelloU.getSelectedItem() + "', Edemas='" + this.JCBEdemas.getSelectedItem() + "', SPEclampsia='" + this.JCBSPEclampsia.getSelectedItem() + "', SaludOral='" + this.JCBSaludOral.getSelectedItem() + "', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', sintomatologiaUrinaria='" + this.xsintomatologiaU + "', flujoVaginal='" + this.xflujovaginal + "', cefaleaPersistente='" + this.xcefalea + "', nauseasVomito='" + this.xnauseasvomito + "' WHERE (Id ='" + xrs.getString(1) + "') ";
                                this.xconsultasbd.ejecutarSQL(sql2);
                                this.xconsultasbd.cerrarConexionBd();
                                mBuscaHistorico();
                                mGuardarGrafica(this.JPGrafico, 1L);
                                mGuardarGrafica(this.JPGraficoPM, 24L);
                                mGuardarGrafica(this.JPGraficoPresion, 25L);
                                mGuardarGrafica(this.JPGraficaIMC, 27L);
                            } else {
                                String sql3 = "insert into h_examenfisico ( Id_Atencion, Id_Usuario_Programa, TArtSentadoD, TArtSentadoS, FCardiaca, FRespiratoria, Talla, Peso, IMC, Temperatura, Ps2,  `SGestacion`, `AlturaUterina`, `FCFh1`, `FCFh2`, `PFetalH1`, `PFetalH2`, `MovFetalH1`, `MovFetalH2`, `VCuelloUterino`, `Edemas`, `SPEclampsia`, `SaludOral`, Fecha, UsuarioS,sintomatologiaUrinaria, flujoVaginal, cefaleaPersistente,nauseasVomito) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "','" + this.JTFFPSentadoD.getValue() + "','" + this.JTFFPSentadoS.getValue() + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + this.JTFFSSGestacion.getText() + "','" + this.JTFFSAlturaUterina.getText() + "','" + this.JSPFcfh1.getText() + "','" + this.JSPFcfh2.getText() + "','" + this.JCBPresentacionFH1.getSelectedItem() + "','" + this.JCBPresentacionFH2.getSelectedItem() + "','" + this.JCBMovFetalH1.getSelectedItem() + "','" + this.JCBMovFetalH2.getSelectedItem() + "','" + this.JCBCuelloU.getSelectedItem() + "','" + this.JCBEdemas.getSelectedItem() + "','" + this.JCBSPEclampsia.getSelectedItem() + "','" + this.JCBSaludOral.getSelectedItem() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xsintomatologiaU + "','" + this.xflujovaginal + "','" + this.xcefalea + "','" + this.xnauseasvomito + "')";
                                this.xidexamenf = this.xconsultasbd.ejecutarSQLId(sql3);
                                this.xconsultasbd.cerrarConexionBd();
                                if (this.JTB_Hallazgo.isEditing()) {
                                    this.JTB_Hallazgo.getCellEditor().stopCellEditing();
                                }
                                for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
                                    DetalleExamenFisicoNDTO d = new DetalleExamenFisicoNDTO();
                                    d.setIdExamenFisico(Long.valueOf(this.xidexamenf));
                                    d.setIdGrupoExamen(Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 0).toString()));
                                    d.setObservacion(this.JTB_Hallazgo.getValueAt(i, 2).toString());
                                    d.setEstado(true);
                                    d.setFecha(this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()));
                                    d.setId(Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 3).toString()));
                                    System.out.println("" + this.JTB_Hallazgo.getValueAt(i, 3).toString());
                                    if (Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 3).toString()).longValue() == 0) {
                                        this.detalleExamenFisicoDAO.mCrear(d);
                                    } else {
                                        this.detalleExamenFisicoDAO.mActualizar(d);
                                    }
                                }
                                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                mBuscaHistorico();
                                mGuardarGrafica(this.JPGrafico, 1L);
                                mGuardarGrafica(this.JPGraficoPM, 24L);
                                mGuardarGrafica(this.JPGraficoPresion, 25L);
                                mGuardarGrafica(this.JPGraficaIMC, 27L);
                                mCargarDatosTabla();
                            }
                            xrs.close();
                            this.xconsultasbd.cerrarConexionBd();
                            return;
                        } catch (SQLException ex) {
                            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "El Usuario no se encuentra matriculado en el Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
        }
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.examenFisicoDAO.listConfDetalleExamenFisico(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        mModelo();
        this.xmetodo.mEstablecerTextEditor(this.JTB_Hallazgo, 1);
        this.xmetodo.mEstablecerTextEditor(this.JTB_Hallazgo, 2);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(list.get(x)[0].toString(), x, 0);
                this.xmodelo1.setValueAt(list.get(x)[1].toString(), x, 1);
                this.xmodelo1.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo1.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo1.setValueAt(list.get(x)[4], x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Sistema", "Descripcion", "IdDetalle", "VDefecto"}) { // from class: Historia.JPAExamenFisicoPrenatal_v2.28
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Hallazgo.setModel(this.xmodelo1);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Hallazgo.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mBuscarDatosBd() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                String sql = "SELECT h_examenfisico.TArtSentadoD, h_examenfisico.TArtSentadoS, h_examenfisico.TArtAcostadoD, h_examenfisico.TArtAcostadoS, h_examenfisico.TArtPieD, h_examenfisico.TArtPieS, h_examenfisico.ControlTA , h_examenfisico.FCardiaca, h_examenfisico.FRespiratoria, h_examenfisico.Talla, h_examenfisico.Peso, h_examenfisico.Observacion, h_examenfisico.Temperatura, Ps2, h_examenfisico.ControlDm, h_examenfisico.ValorGlicemia, h_atencion.TipoGuardado, h_examenfisico.PerimetroAbdominal, h_examenfisico.PerimetroCefalico, `h_tipo_riesgo`.`Nbre` , h_examenfisico.`SGestacion`, h_examenfisico.`AlturaUterina`, h_examenfisico.`FCFh1`, h_examenfisico.`FCFh2`, h_examenfisico.`PFetalH1`, h_examenfisico.`PFetalH2`, h_examenfisico.`MovFetalH1`, h_examenfisico.`MovFetalH2`, h_examenfisico.`VCuelloUterino`, h_examenfisico.`Edemas`, h_examenfisico.`SPEclampsia`, h_examenfisico.`SaludOral`, h_examenfisico.IMC,h_examenfisico.sintomatologiaUrinaria, h_examenfisico.flujoVaginal,h_examenfisico.cefaleaPersistente, h_examenfisico.nauseasVomito  FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN `h_tipo_riesgo`  ON (h_examenfisico.`Id_CRiesgo` = h_tipo_riesgo.Id)  INNER JOIN `g_usuarioxprograma`  ON (`h_examenfisico`.`Id_Usuario_Programa` = `g_usuarioxprograma`.`Id`) WHERE (h_examenfisico.Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND  `g_usuarioxprograma`.`FechaEgreso` IS NULL)";
                System.out.println(" examen fisico " + sql);
                ResultSet xrs = this.xconsultasbd.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFFPSentadoD.setValue(Integer.valueOf(xrs.getInt(1)));
                    this.JTFFPSentadoS.setValue(Integer.valueOf(xrs.getInt(2)));
                    this.JTFFSFc.setText(xrs.getString(8));
                    this.JTFFSFr.setText(xrs.getString(9));
                    this.JTFFSTalla.setText(xrs.getString(10));
                    this.JTFFSPeso.setText(xrs.getString(11));
                    this.JTFFSIMC.setText(xrs.getString("IMC"));
                    this.JTFFTemperatura.setText(xrs.getString(13));
                    this.JTFFPs2.setText(xrs.getString(14));
                    if (xrs.getInt(17) == 1) {
                        this.JBTGuardar.setEnabled(false);
                    } else {
                        this.JBTGuardar.setEnabled(true);
                    }
                    this.JTFFSSGestacion.setText(xrs.getString(21));
                    this.JTFFSAlturaUterina.setText(xrs.getString(22));
                    this.JSPFcfh1.setText(xrs.getString(23));
                    this.JSPFcfh2.setText(xrs.getString(24));
                    this.JCBPresentacionFH1.setSelectedItem(xrs.getString(25));
                    this.JCBPresentacionFH2.setSelectedItem(xrs.getString(26));
                    this.JCBMovFetalH1.setSelectedItem(xrs.getString(27));
                    this.JCBMovFetalH2.setSelectedItem(xrs.getString(28));
                    this.JCBCuelloU.setSelectedItem(xrs.getString(29));
                    this.JCBEdemas.setSelectedItem(xrs.getString(30));
                    this.JCBSPEclampsia.setSelectedItem(xrs.getString(31));
                    this.JCBSaludOral.setSelectedItem(xrs.getString(32));
                    this.JCHSintomatologiaU.setSelected(xrs.getBoolean("sintomatologiaUrinaria"));
                    this.JCHFlujoVaginal.setSelected(xrs.getBoolean("flujoVaginal"));
                    this.JCHNauseasVomito.setSelected(xrs.getBoolean("nauseasVomito"));
                    this.JCHCefaleaPersist.setSelected(xrs.getBoolean("cefaleaPersistente"));
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"SGestación", "Alt. Uterina", "FC(cm)", "FR(r/m)", "T(°C)", "PS2", "PSistólica", "PDiastólica", "Talla", "Peso", "IMC", "AumentoPeso", "Fecha"}) { // from class: Historia.JPAExamenFisicoPrenatal_v2.29
            Class[] types = {Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Date.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        JTable jTable = this.JTBHistorico;
        JTable jTable2 = this.JTBHistorico;
        jTable.setAutoResizeMode(0);
        this.JTBHistorico.doLayout();
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBHistorico.getColumnModel().getColumn(12).setPreferredWidth(80);
    }

    private void mBuscaHistorico() {
        String sql = "with examenFisico as (\nSELECT h_examenfisico.`SGestacion`  , h_examenfisico.`AlturaUterina`  , h_examenfisico.`FCardiaca` , \nh_examenfisico.`FRespiratoria` , h_examenfisico.`Temperatura` , h_examenfisico.`Ps2`  , h_examenfisico.`TArtSentadoS` , \nh_examenfisico.`TArtSentadoD` , h_examenfisico.`Talla` , h_examenfisico.`Peso`  ,\nh_examenfisico.`IMC`\n-- EF_UxP.Peso AS VO ,  \n-- IF(ROUND((h_examenfisico.`Peso`- EF_UxP.Peso),2)<0,'0.00',ROUND((h_examenfisico.`Peso`- EF_UxP.Peso),2))  AS Diferencia  \n,  ha.Fecha_Atencion  \n,i.Id_Usuario , h_examenfisico.Id idExamenFisico\n, row_number() over(PARTITION BY i.Id_Usuario ORDER BY ha.Fecha_Atencion  asc) orden\nFROM `h_examenfisico`\ninner join h_atencion ha on (ha.Id=h_examenfisico.Id_Atencion)\ninner join c_clasecita cc  on (cc.Id=ha.Id_ClaseCita)\ninner join ingreso i on (ha.Id_Ingreso=i.Id)\nWHERE (i.Id_Usuario =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + " and cc.Id_Finalidad='06')\norder by ha.Fecha_Atencion  desc\n),\nusuarioPrograma as (\n\tselect gu.*, e.idExamenFisico\nfrom g_usuarioxprograma gu \ninner join examenFisico e on (e.Id_Usuario=gu.Id_Usuario)\nwhere  gu.Id_Programa =3 and e.Fecha_Atencion  BETWEEN gu.FechaIngreso and IF(gu.PartoProbable IS NULL OR gu.PartoProbable='1800-01-01', ADDDATE(gu.FechaIngreso, INTERVAL 9 MONTH), gu.PartoProbable) \n),\npesosDiferencia as (\n\tselect e.orden, e.Peso, n.Peso as PesoC\n\tfrom examenFisico e\n\tleft join examenFisico n on (n.orden= (e.orden-1))\n\torder by e.orden asc\n)\n\n  -- select * from pesosDiferencia\nSELECT \ne.`SGestacion`  \n,e.`AlturaUterina`  \n, e.`FCardiaca` \n, e.`FRespiratoria` \n, e.`Temperatura` \n, e.`Ps2`  \n, e.`TArtSentadoS` \n, e.`TArtSentadoD` \n, e.`Talla` \n, e.`Peso`  \n, e.`IMC`\n, u.Peso AS VO   \n-- , ifnull(p.PesoC,0) \n, if(e.orden=1, 0 , (e.Peso-ifnull(p.PesoC,0) )) Diferencia\n--  , IF(ROUND((e.`Peso`- u.Peso),2)<0,'0.00',ROUND((e.`Peso`- u.Peso),2))  AS Diferencia  \n, e.Fecha_Atencion\nfrom examenFisico e \nleft join usuarioPrograma u on (u.Id_Usuario=e.Id_Usuario) and (e.idExamenFisico=u.idExamenFisico)\nleft  join pesosDiferencia p on (p.orden=e.orden)\n where  u.Id = " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "";
        mCrearModeloDatos();
        try {
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                            this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                            this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                            this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                            this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                            this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                            this.xmodelo.setValueAt(xrs.getString(13), n, 11);
                            this.xmodelo.setValueAt(xrs.getDate("Fecha_Atencion"), n, 12);
                            n++;
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPAExamenFisicoPrenatal_v2$Imagen.class */
    public class Imagen extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal;

        public Imagen(JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal) {
            setSize(516, 456);
            this.xJPAExamenFisicoPrenatal = xJPAExamenFisicoPrenatal;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Grafica_Altura_Uterina.png"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount() > -1) {
                int x = 0;
                int y = 0;
                this.xCoordenada = new int[this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount()][2];
                for (int j = 0; j < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j++) {
                    String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` =1  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'<`RangoSUp` );";
                    ResultSet xrs = this.xct.traerRs(sql);
                    try {
                        if (xrs.next()) {
                            xrs.last();
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                x++;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` =1  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'<`RangoSUp`);";
                    ResultSet xrs2 = this.xct.traerRs(sql2);
                    try {
                        if (xrs2.next()) {
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                y++;
                            }
                        }
                        xrs2.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                }
            }
            for (int i = 0; i < this.xCoordenada.length; i++) {
                try {
                    if (i != 0) {
                        grafico.setColor(Color.red);
                        g2.setStroke(new BasicStroke(2.0f));
                        g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                    }
                    dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(7.5f));
            g2.draw(new Line2D.Double(x, y, x, y));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPAExamenFisicoPrenatal_v2$Grafica2.class */
    public class Grafica2 extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal;
        private int x;
        private int y;
        private int xTipoGrafica;
        private int xCondicion;
        private String xImg;

        public Grafica2(JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal, int x, int y, int xTipoGrafica, int xWidth, int xHeigth, String xImg, int xCondicion) {
            setSize(xWidth, xHeigth);
            this.xJPAExamenFisicoPrenatal = xJPAExamenFisicoPrenatal;
            this.x = x;
            this.y = y;
            this.xTipoGrafica = xTipoGrafica;
            this.xImg = xImg;
            this.xCondicion = xCondicion;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/" + this.xImg + ".jpg"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount() > -1) {
                int x = 0;
                int y = 0;
                int xValoRango = 0;
                int xRangoFinal = 0;
                if (this.xCondicion == 0) {
                    this.xCoordenada = new int[this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount()][2];
                } else {
                    int xValor = 1;
                    for (int j = 0; j < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j++) {
                        if (this.xTipoGrafica == 24) {
                            xValoRango = 0;
                            xRangoFinal = 40;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 0 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 40) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        } else if (this.xTipoGrafica == 25) {
                            xValoRango = 24;
                            xRangoFinal = 41;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 24 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 41) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        } else if (this.xTipoGrafica == 28) {
                            xValoRango = 6;
                            xRangoFinal = 42;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 6 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 42) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        } else if (this.xTipoGrafica == 51) {
                            xValoRango = 6;
                            xRangoFinal = 42;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 6 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 42) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        }
                    }
                }
                for (int j2 = 0; j2 < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j2++) {
                    if (this.xCondicion == 0) {
                        String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'<`RangoSUp` );";
                        ResultSet xrs = this.xct.traerRs(sql);
                        try {
                            if (xrs.next()) {
                                xrs.last();
                                xrs.beforeFirst();
                                while (xrs.next()) {
                                    this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                    x++;
                                }
                            }
                            xrs.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex) {
                            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                        String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'<`RangoSUp`);";
                        ResultSet xrs2 = this.xct.traerRs(sql2);
                        try {
                            if (xrs2.next()) {
                                xrs2.beforeFirst();
                                while (xrs2.next()) {
                                    this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                    y++;
                                }
                            }
                            xrs2.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex2) {
                            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    } else if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) >= xValoRango && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) <= xRangoFinal) {
                        String sql3 = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'<`RangoSUp` );";
                        ResultSet xrs3 = this.xct.traerRs(sql3);
                        try {
                            if (xrs3.next()) {
                                xrs3.last();
                                xrs3.beforeFirst();
                                while (xrs3.next()) {
                                    this.xCoordenada[x][0] = xrs3.getInt("Coordenada_X");
                                    x++;
                                }
                            }
                            xrs3.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex3) {
                            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                        }
                        String sql4 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'<`RangoSUp`);";
                        ResultSet xrs22 = this.xct.traerRs(sql4);
                        try {
                            if (xrs22.next()) {
                                xrs22.beforeFirst();
                                while (xrs22.next()) {
                                    this.xCoordenada[y][1] = xrs22.getInt("Coordenada_Y");
                                    y++;
                                }
                            }
                            xrs22.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex4) {
                            Logger.getLogger(JPAExamenFisicoPrenatal_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                        }
                    }
                }
                try {
                    if (this.xCoordenada != null) {
                        for (int i = 0; i < this.xCoordenada.length; i++) {
                            if (i != 0) {
                                grafico.setColor(Color.red);
                                g2.setStroke(new BasicStroke(2.0f));
                                g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                            }
                            dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(7.5f));
            g2.draw(new Line2D.Double(x, y, x, y));
        }
    }

    private void mGuardarGrafica(JPanel xpanel, long xidGrafica) {
        if (!this.xmetodo.mVerificaExistenciaGrafica(xidGrafica)) {
            String sqlIs = "INSERT INTO  `p_usuario_grafica` (`IdUsuario`, `IdUsuarioPrograma`, `IdGrafica`, `Ruta`, `UsuarioS`) VALUES('" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()) + "','" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()) + "','" + xidGrafica + "','" + xidGrafica + ".jpg','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            ConsultasMySQL xctI = new ConsultasMySQL();
            xctI.ejecutarSQL(sqlIs);
            xctI.cerrarConexionBd();
        }
    }
}
