package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JP_CP_DatosPyP.class */
public class JP_CP_DatosPyP extends JPanel {
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloHIngreso;
    private DefaultTableModel xmodeloHEgreso;
    private Object[] xdato;
    private ButtonGroup JBGEInicio;
    private ButtonGroup JBGEMotivo;
    private ButtonGroup JBGViva;
    private JButton JBTAdicionarRN;
    private JButton JBTEGuardar;
    private JButton JBTGuardar;
    private JComboBox JCBApoyoF;
    private JComboBox JCBCausasIngTardio;
    private JComboBox JCBMujerCF;
    private JComboBox JCBNSexo;
    private JComboBox JCBPlaneacionEmb;
    private JDateChooser JDEFecha;
    private JDateChooser JDEHFEgreso;
    private JDateChooser JDEHFIngreso;
    private JDateChooser JDFPP;
    private JDateChooser JDFUM;
    private JDateChooser JDFUPP;
    private JDateChooser JDFecha;
    private JPanel JPESignosVitales;
    private JPanel JPHistorico;
    private JPanel JPIDatosM;
    private JPanel JPIEHospit;
    private JPanel JPIEInicioParto;
    private JPanel JPIEInicioParto1;
    private JPanel JPIEMotivo;
    private JPanel JPIEViva;
    private JPanel JPIEgreso;
    private JPanel JPINDefectoC;
    private JPanel JPINFalleceLP;
    private JPanel JPINReanimacion;
    private JPanel JPINVivo;
    private JPanel JPINacidoVivo;
    private JPanel JPIngreso;
    private JRadioButton JRBEAborto;
    private JRadioButton JRBEICesarea;
    private JRadioButton JRBEIEspontaneo;
    private JRadioButton JRBEIInducido;
    private JRadioButton JRBEParto;
    private JRadioButton JRBEVNo;
    private JRadioButton JRBEVSi;
    private JRadioButton JRBNDCNo;
    private JRadioButton JRBNDCSi;
    private ButtonGroup JRBNDCongenito;
    private JRadioButton JRBNFNo;
    private JRadioButton JRBNFSi;
    private ButtonGroup JRBNFalleceLP;
    private JRadioButton JRBNRNo;
    private JRadioButton JRBNRSi;
    private ButtonGroup JRBNReanimacion;
    private JRadioButton JRBNVNo;
    private JRadioButton JRBNVSi;
    private ButtonGroup JRBNVivo;
    private JRadioButton JRBTri_1;
    private JRadioButton JRBTri_2;
    private JRadioButton JRBTri_3;
    private ButtonGroup JRBTrimestre;
    private JScrollPane JSPEFObservaciones;
    private JScrollPane JSPEFObservaciones1;
    private JSpinner JSPESGestacion;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistorico1;
    private JSpinner JSPNApgar1;
    private JSpinner JSPNApgar5;
    private JScrollPane JSPNDetalle;
    private JSpinner JSPNPCefalico;
    private JSpinner JSPNPeso;
    private JSpinner JSPNSGestacional;
    private JSpinner JSPNTalla;
    public JTextFieldValidator JSPSGestacion;
    public JTextFieldValidator JSPSPesoInicial;
    public JTable JTBHistoricoEgreso;
    public JTable JTBHistoricoIngreso;
    private JTable JTBNDetalle;
    public JTextFieldValidator JTFFE_IMC;
    public JTextFieldValidator JTFFE_Peso;
    public JTextFieldValidator JTFFE_Talla;
    public JTextField JTFNDx1;
    public JTextField JTFNDx2;
    public JTextField JTFNDx3;
    private JTabbedPane JTPDatos;
    private JTextPane JTPEFObservaciones;
    private JTextPane JTPEObservaciones;
    private JCheckBox NAFPP;
    private JCheckBox NAFUM;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xesingreso = 0;
    private int xcardinal = 0;
    private int xemotivo = 0;
    private int xeinicioparto = 0;
    private int xtrimestre = 1;
    private int xeviva = 1;
    private int xnvivo = 1;
    private int xnreanimacion = 0;
    private int xnfallecelp = 0;
    private int xndcongenito = 0;
    private int xnhijo = 1;
    private boolean stipog = false;
    public double xsemEmbarazo = 0.0d;

    public JP_CP_DatosPyP(String xnombre) {
        initComponents();
        mNuevo();
        mBuscarDatosIngreso();
        mBuscarDatosEgreso();
        mBuscaHistoricoIngresos();
        mBuscaHistoricoEgresos();
        if (xnombre.equals("Ingreso")) {
            this.JTPDatos.setEnabledAt(0, true);
            this.JTPDatos.setEnabledAt(1, true);
            this.JTPDatos.setSelectedIndex(0);
        } else {
            this.JTPDatos.setEnabledAt(0, false);
            this.JTPDatos.setEnabledAt(1, true);
            this.JTPDatos.setSelectedIndex(1);
            this.JBTAdicionarRN.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v231, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v365, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEMotivo = new ButtonGroup();
        this.JBGEInicio = new ButtonGroup();
        this.JBGViva = new ButtonGroup();
        this.JRBNVivo = new ButtonGroup();
        this.JRBNReanimacion = new ButtonGroup();
        this.JRBNDCongenito = new ButtonGroup();
        this.JRBNFalleceLP = new ButtonGroup();
        this.JRBTrimestre = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIngreso = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JDFUM = new JDateChooser();
        this.JDFPP = new JDateChooser();
        this.JSPEFObservaciones = new JScrollPane();
        this.JTPEFObservaciones = new JTextPane();
        this.JBTGuardar = new JButton();
        this.JDFUPP = new JDateChooser();
        this.JPIEInicioParto1 = new JPanel();
        this.JRBTri_1 = new JRadioButton();
        this.JRBTri_2 = new JRadioButton();
        this.JRBTri_3 = new JRadioButton();
        this.JCBCausasIngTardio = new JComboBox();
        this.JCBPlaneacionEmb = new JComboBox();
        this.JPESignosVitales = new JPanel();
        this.JTFFE_Talla = new JTextFieldValidator();
        this.JTFFE_Peso = new JTextFieldValidator();
        this.JTFFE_IMC = new JTextFieldValidator();
        this.JSPSGestacion = new JTextFieldValidator();
        this.JSPSPesoInicial = new JTextFieldValidator();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistoricoIngreso = new JTable();
        this.NAFUM = new JCheckBox();
        this.NAFPP = new JCheckBox();
        this.JCBApoyoF = new JComboBox();
        this.JCBMujerCF = new JComboBox();
        this.JPIEgreso = new JPanel();
        this.JPINacidoVivo = new JPanel();
        this.JCBNSexo = new JComboBox();
        this.JPINVivo = new JPanel();
        this.JRBNVSi = new JRadioButton();
        this.JRBNVNo = new JRadioButton();
        this.JSPNTalla = new JSpinner();
        this.JSPNPeso = new JSpinner();
        this.JSPNPCefalico = new JSpinner();
        this.JSPNSGestacional = new JSpinner();
        this.JSPNApgar1 = new JSpinner();
        this.JSPNApgar5 = new JSpinner();
        this.JPINReanimacion = new JPanel();
        this.JRBNRSi = new JRadioButton();
        this.JRBNRNo = new JRadioButton();
        this.JPINFalleceLP = new JPanel();
        this.JRBNFSi = new JRadioButton();
        this.JRBNFNo = new JRadioButton();
        this.JPINDefectoC = new JPanel();
        this.JRBNDCSi = new JRadioButton();
        this.JRBNDCNo = new JRadioButton();
        this.JTFNDx1 = new JTextField();
        this.JTFNDx2 = new JTextField();
        this.JTFNDx3 = new JTextField();
        this.JBTAdicionarRN = new JButton();
        this.JSPNDetalle = new JScrollPane();
        this.JTBNDetalle = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIDatosM = new JPanel();
        this.JDEFecha = new JDateChooser();
        this.JPIEMotivo = new JPanel();
        this.JRBEParto = new JRadioButton();
        this.JRBEAborto = new JRadioButton();
        this.JPIEHospit = new JPanel();
        this.JDEHFIngreso = new JDateChooser();
        this.JDEHFEgreso = new JDateChooser();
        this.JPIEInicioParto = new JPanel();
        this.JRBEIEspontaneo = new JRadioButton();
        this.JRBEIInducido = new JRadioButton();
        this.JRBEICesarea = new JRadioButton();
        this.JSPESGestacion = new JSpinner();
        this.JSPEFObservaciones1 = new JScrollPane();
        this.JTPEObservaciones = new JTextPane();
        this.JPIEViva = new JPanel();
        this.JRBEVSi = new JRadioButton();
        this.JRBEVNo = new JRadioButton();
        this.JBTEGuardar = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistorico1 = new JScrollPane();
        this.JTBHistoricoEgreso = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("Ingreso a Programa");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.setMaxSelectableDate(new Date(253370786508000L));
        this.JDFecha.setMinSelectableDate(new Date(-62135747892000L));
        this.JDFUM.setBorder(BorderFactory.createTitledBorder((Border) null, "FUM", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFUM.setDateFormatString("dd/MM/yyyy");
        this.JDFUM.setFont(new Font("Arial", 1, 12));
        this.JDFUM.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_CP_DatosPyP.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_CP_DatosPyP.this.JDFUMPropertyChange(evt);
            }
        });
        this.JDFPP.setBorder(BorderFactory.createTitledBorder((Border) null, "FPP", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFPP.setToolTipText("");
        this.JDFPP.setDateFormatString("dd/MM/yyyy");
        this.JDFPP.setFont(new Font("Arial", 1, 12));
        this.JSPEFObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_DatosPyP.2
            public void keyPressed(KeyEvent evt) {
                JP_CP_DatosPyP.this.JTPEFObservacionesKeyPressed(evt);
            }
        });
        this.JSPEFObservaciones.setViewportView(this.JTPEFObservaciones);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.3
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_DatosPyP.4
            public void keyPressed(KeyEvent evt) {
                JP_CP_DatosPyP.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JDFUPP.setBorder(BorderFactory.createTitledBorder((Border) null, "FUP", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFUPP.setToolTipText("Fecha Último Parto");
        this.JDFUPP.setDateFormatString("dd/MM/yyyy");
        this.JDFUPP.setFont(new Font("Arial", 1, 12));
        this.JPIEInicioParto1.setBorder(BorderFactory.createTitledBorder((Border) null, "Trimestre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBTrimestre.add(this.JRBTri_1);
        this.JRBTri_1.setFont(new Font("Arial", 1, 12));
        this.JRBTri_1.setSelected(true);
        this.JRBTri_1.setText("I");
        this.JRBTri_1.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.5
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBTri_1ActionPerformed(evt);
            }
        });
        this.JRBTrimestre.add(this.JRBTri_2);
        this.JRBTri_2.setFont(new Font("Arial", 1, 12));
        this.JRBTri_2.setText("II");
        this.JRBTri_2.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.6
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBTri_2ActionPerformed(evt);
            }
        });
        this.JRBTrimestre.add(this.JRBTri_3);
        this.JRBTri_3.setFont(new Font("Arial", 1, 12));
        this.JRBTri_3.setText("III");
        this.JRBTri_3.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.7
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBTri_3ActionPerformed(evt);
            }
        });
        GroupLayout JPIEInicioParto1Layout = new GroupLayout(this.JPIEInicioParto1);
        this.JPIEInicioParto1.setLayout(JPIEInicioParto1Layout);
        JPIEInicioParto1Layout.setHorizontalGroup(JPIEInicioParto1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEInicioParto1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTri_1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTri_2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTri_3).addContainerGap(-1, 32767)));
        JPIEInicioParto1Layout.setVerticalGroup(JPIEInicioParto1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEInicioParto1Layout.createSequentialGroup().addGroup(JPIEInicioParto1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTri_1).addComponent(this.JRBTri_2).addComponent(this.JRBTri_3)).addContainerGap(-1, 32767)));
        this.JCBCausasIngTardio.setFont(new Font("Arial", 1, 12));
        this.JCBCausasIngTardio.setModel(new DefaultComboBoxModel(new String[]{"Acceso geográfico", "Desconoce derechos", "Desconocía su estado", "Dificultad con seguridad social", "Embarazo no deseado", "Factores culturales y creencias", "Falta apoyo familiar", "Falta de dinero para ir a la IPS", "Negación del servicio", "No encontró cita", "Problema de orden público", "Pob Venezolana", "Aseguramiento a edad avanzada de gestacion", "Afiliacion reciente EPS", "Control prenatal en otra IPS o EPS sin documento", "Hopitalización", "Otros", "Sin dato", "No aplica"}));
        this.JCBCausasIngTardio.setBorder(BorderFactory.createTitledBorder((Border) null, "Causas Ingreso Tardío CP", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBPlaneacionEmb.setFont(new Font("Arial", 1, 12));
        this.JCBPlaneacionEmb.setModel(new DefaultComboBoxModel(new String[]{"Planeado", "No planeado y deseado", "No planeado y No deseado", "No planeado y aceptado"}));
        this.JCBPlaneacionEmb.setBorder(BorderFactory.createTitledBorder((Border) null, "Planeación del Embarazo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPESignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ANTROPOMÉTRICOS", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFE_Talla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Talla.setHorizontalAlignment(0);
        this.JTFFE_Talla.setText("0");
        this.JTFFE_Talla.setToolTipText("Talla en Centimetros");
        this.JTFFE_Talla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_Talla.setFocusAccelerator('C');
        this.JTFFE_Talla.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Talla.addFocusListener(new FocusAdapter() { // from class: Historia.JP_CP_DatosPyP.8
            public void focusGained(FocusEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_TallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_TallaFocusLost(evt);
            }
        });
        this.JTFFE_Talla.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.9
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_TallaActionPerformed(evt);
            }
        });
        this.JTFFE_Peso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Peso.setHorizontalAlignment(0);
        this.JTFFE_Peso.setText("0");
        this.JTFFE_Peso.setToolTipText("Peso en Kilogramos");
        this.JTFFE_Peso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_Peso.setFocusAccelerator('C');
        this.JTFFE_Peso.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Peso.addFocusListener(new FocusAdapter() { // from class: Historia.JP_CP_DatosPyP.10
            public void focusGained(FocusEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_PesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_PesoFocusLost(evt);
            }
        });
        this.JTFFE_Peso.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.11
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JTFFE_PesoActionPerformed(evt);
            }
        });
        this.JTFFE_IMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_IMC.setHorizontalAlignment(0);
        this.JTFFE_IMC.setText("0");
        this.JTFFE_IMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFE_IMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFE_IMC.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_IMC.setFocusable(false);
        this.JTFFE_IMC.setFont(new Font("Arial", 1, 24));
        GroupLayout JPESignosVitalesLayout = new GroupLayout(this.JPESignosVitales);
        this.JPESignosVitales.setLayout(JPESignosVitalesLayout);
        JPESignosVitalesLayout.setHorizontalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFE_Talla, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_Peso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_IMC, -2, 100, -2)));
        JPESignosVitalesLayout.setVerticalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFE_Talla, -2, 50, -2).addComponent(this.JTFFE_Peso, -2, 50, -2).addComponent(this.JTFFE_IMC, -2, 50, -2));
        this.JSPSGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPSGestacion.setHorizontalAlignment(0);
        this.JSPSGestacion.setText("0");
        this.JSPSGestacion.setToolTipText("Talla en Centimetros");
        this.JSPSGestacion.setExprecionRegular("^[0.0-9]*$");
        this.JSPSGestacion.setFocusAccelerator('C');
        this.JSPSGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPSGestacion.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.12
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JSPSGestacionActionPerformed(evt);
            }
        });
        this.JSPSGestacion.addFocusListener(new FocusAdapter() { // from class: Historia.JP_CP_DatosPyP.13
            public void focusGained(FocusEvent evt) {
                JP_CP_DatosPyP.this.JSPSGestacionFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_CP_DatosPyP.this.JSPSGestacionFocusLost(evt);
            }
        });
        this.JSPSPesoInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso Inicial (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPSPesoInicial.setHorizontalAlignment(0);
        this.JSPSPesoInicial.setText("0");
        this.JSPSPesoInicial.setToolTipText("Talla en Centimetros");
        this.JSPSPesoInicial.setExprecionRegular("^[0.0-9]*$");
        this.JSPSPesoInicial.setFocusAccelerator('C');
        this.JSPSPesoInicial.setFont(new Font("Arial", 1, 12));
        this.JSPSPesoInicial.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.14
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JSPSPesoInicialActionPerformed(evt);
            }
        });
        this.JSPSPesoInicial.addFocusListener(new FocusAdapter() { // from class: Historia.JP_CP_DatosPyP.15
            public void focusGained(FocusEvent evt) {
                JP_CP_DatosPyP.this.JSPSPesoInicialFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_CP_DatosPyP.this.JSPSPesoInicialFocusLost(evt);
            }
        });
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO INGRESO AL PROGRAMA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistoricoIngreso.setFont(new Font("Arial", 1, 12));
        this.JTBHistoricoIngreso.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistoricoIngreso.setRowHeight(25);
        this.JTBHistoricoIngreso.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistoricoIngreso.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistoricoIngreso.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistoricoIngreso);
        this.NAFUM.setFont(new Font("Arial", 1, 12));
        this.NAFUM.setText("NA");
        this.NAFUM.setToolTipText("No Aplica, No Recuerda");
        this.NAFUM.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.16
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.NAFUMActionPerformed(evt);
            }
        });
        this.NAFPP.setFont(new Font("Arial", 1, 12));
        this.NAFPP.setText("NA");
        this.NAFPP.setToolTipText("No Aplica, No Recuerda");
        this.NAFPP.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.17
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.NAFPPActionPerformed(evt);
            }
        });
        this.JCBApoyoF.setFont(new Font("Arial", 1, 12));
        this.JCBApoyoF.setModel(new DefaultComboBoxModel(new String[]{"SI", "NO"}));
        this.JCBApoyoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Apoyo Familiar?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBMujerCF.setFont(new Font("Arial", 1, 12));
        this.JCBMujerCF.setModel(new DefaultComboBoxModel(new String[]{"NO", "SI"}));
        this.JCBMujerCF.setBorder(BorderFactory.createTitledBorder((Border) null, "Mujer Cabeza de Familia?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIngresoLayout = new GroupLayout(this.JPIngreso);
        this.JPIngreso.setLayout(JPIngresoLayout);
        JPIngresoLayout.setHorizontalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIngresoLayout.createSequentialGroup().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFUPP, -2, 110, -2).addComponent(this.JDFecha, -2, 109, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JPIEInicioParto1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCausasIngTardio, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPlaneacionEmb, -2, 192, -2)).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JDFUM, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.NAFUM).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFPP, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.NAFPP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPSGestacion, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPSPesoInicial, -2, 110, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 130, -2)).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JPESignosVitales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEFObservaciones))).addGap(30, 30, 30)).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JCBApoyoF, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMujerCF, -2, 192, -2).addContainerGap(-1, 32767)))));
        JPIngresoLayout.setVerticalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIngresoLayout.createSequentialGroup().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFUM, -2, 50, -2).addComponent(this.JDFPP, -2, 50, -2)).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPSGestacion, -2, 50, -2).addComponent(this.JSPSPesoInicial, -2, 50, -2).addComponent(this.NAFPP)).addComponent(this.JDFecha, -2, 50, -2).addGroup(JPIngresoLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.NAFUM))).addGap(10, 10, 10).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIEInicioParto1, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JDFUPP, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCausasIngTardio, -2, 50, -2).addComponent(this.JCBPlaneacionEmb, -2, 50, -2)))).addComponent(this.JBTGuardar, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBApoyoF, -2, 50, -2).addComponent(this.JCBMujerCF, -2, 50, -2)).addGap(5, 5, 5).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPESignosVitales, -2, -1, -2).addComponent(this.JSPEFObservaciones, -2, 71, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorico, -2, 231, -2).addContainerGap()));
        this.JTPDatos.addTab("INGRESO", this.JPIngreso);
        this.JPINacidoVivo.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RECIEN NACIDO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBNSexo.setFont(new Font("Arial", 1, 12));
        this.JCBNSexo.setModel(new DefaultComboBoxModel(new String[]{"M", "F"}));
        this.JCBNSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPINVivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Vivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBNVivo.add(this.JRBNVSi);
        this.JRBNVSi.setFont(new Font("Arial", 1, 12));
        this.JRBNVSi.setSelected(true);
        this.JRBNVSi.setText("Si");
        this.JRBNVSi.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.18
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNVSiActionPerformed(evt);
            }
        });
        this.JRBNVivo.add(this.JRBNVNo);
        this.JRBNVNo.setFont(new Font("Arial", 1, 12));
        this.JRBNVNo.setText("No");
        this.JRBNVNo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.19
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNVNoActionPerformed(evt);
            }
        });
        GroupLayout JPINVivoLayout = new GroupLayout(this.JPINVivo);
        this.JPINVivo.setLayout(JPINVivoLayout);
        JPINVivoLayout.setHorizontalGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINVivoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNVSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNVNo).addContainerGap(-1, 32767)));
        JPINVivoLayout.setVerticalGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINVivoLayout.createSequentialGroup().addGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNVSi).addComponent(this.JRBNVNo)).addGap(0, 3, 32767)));
        this.JSPNTalla.setFont(new Font("Arial", 1, 12));
        this.JSPNTalla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JSPNTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla(cm)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNPeso.setFont(new Font("Arial", 1, 12));
        this.JSPNPeso.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(1.0d)));
        this.JSPNPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso(Kg)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNPCefalico.setFont(new Font("Arial", 1, 12));
        this.JSPNPCefalico.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPNPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Cefálico", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNSGestacional.setFont(new Font("Arial", 1, 12));
        this.JSPNSGestacional.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPNSGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNApgar1.setFont(new Font("Arial", 1, 12));
        this.JSPNApgar1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JSPNApgar1.setBorder(BorderFactory.createTitledBorder((Border) null, "Apgar - 1", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNApgar5.setFont(new Font("Arial", 1, 12));
        this.JSPNApgar5.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JSPNApgar5.setBorder(BorderFactory.createTitledBorder((Border) null, "Apgar - 5", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINReanimacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Reanimación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBNReanimacion.add(this.JRBNRSi);
        this.JRBNRSi.setFont(new Font("Arial", 1, 12));
        this.JRBNRSi.setText("Si");
        this.JRBNRSi.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.20
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNRSiActionPerformed(evt);
            }
        });
        this.JRBNReanimacion.add(this.JRBNRNo);
        this.JRBNRNo.setFont(new Font("Arial", 1, 12));
        this.JRBNRNo.setSelected(true);
        this.JRBNRNo.setText("No");
        this.JRBNRNo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.21
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNRNoActionPerformed(evt);
            }
        });
        GroupLayout JPINReanimacionLayout = new GroupLayout(this.JPINReanimacion);
        this.JPINReanimacion.setLayout(JPINReanimacionLayout);
        JPINReanimacionLayout.setHorizontalGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINReanimacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNRSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNRNo).addContainerGap(-1, 32767)));
        JPINReanimacionLayout.setVerticalGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINReanimacionLayout.createSequentialGroup().addGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNRSi).addComponent(this.JRBNRNo)).addGap(0, 0, 32767)));
        this.JPINFalleceLP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fallece LP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINFalleceLP.setToolTipText("Fellece en el lugar del parto");
        this.JRBNFalleceLP.add(this.JRBNFSi);
        this.JRBNFSi.setFont(new Font("Arial", 1, 12));
        this.JRBNFSi.setText("Si");
        this.JRBNFSi.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.22
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNFSiActionPerformed(evt);
            }
        });
        this.JRBNFalleceLP.add(this.JRBNFNo);
        this.JRBNFNo.setFont(new Font("Arial", 1, 12));
        this.JRBNFNo.setSelected(true);
        this.JRBNFNo.setText("No");
        this.JRBNFNo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.23
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNFNoActionPerformed(evt);
            }
        });
        GroupLayout JPINFalleceLPLayout = new GroupLayout(this.JPINFalleceLP);
        this.JPINFalleceLP.setLayout(JPINFalleceLPLayout);
        JPINFalleceLPLayout.setHorizontalGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINFalleceLPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNFSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNFNo).addContainerGap(-1, 32767)));
        JPINFalleceLPLayout.setVerticalGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINFalleceLPLayout.createSequentialGroup().addGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNFSi).addComponent(this.JRBNFNo)).addGap(0, 3, 32767)));
        this.JPINDefectoC.setBorder(BorderFactory.createTitledBorder((Border) null, "D. Congenito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINDefectoC.setToolTipText("Defectos Congenitos");
        this.JRBNDCongenito.add(this.JRBNDCSi);
        this.JRBNDCSi.setFont(new Font("Arial", 1, 12));
        this.JRBNDCSi.setText("Si");
        this.JRBNDCSi.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.24
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNDCSiActionPerformed(evt);
            }
        });
        this.JRBNDCongenito.add(this.JRBNDCNo);
        this.JRBNDCNo.setFont(new Font("Arial", 1, 12));
        this.JRBNDCNo.setSelected(true);
        this.JRBNDCNo.setText("No");
        this.JRBNDCNo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.25
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBNDCNoActionPerformed(evt);
            }
        });
        GroupLayout JPINDefectoCLayout = new GroupLayout(this.JPINDefectoC);
        this.JPINDefectoC.setLayout(JPINDefectoCLayout);
        JPINDefectoCLayout.setHorizontalGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINDefectoCLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNDCSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNDCNo).addContainerGap(-1, 32767)));
        JPINDefectoCLayout.setVerticalGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINDefectoCLayout.createSequentialGroup().addGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNDCSi).addComponent(this.JRBNDCNo)).addGap(0, 0, 32767)));
        this.JTFNDx1.setFont(new Font("Arial", 1, 12));
        this.JTFNDx1.setHorizontalAlignment(4);
        this.JTFNDx1.setText("0000");
        this.JTFNDx1.setToolTipText("");
        this.JTFNDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx1", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx1.setEnabled(false);
        this.JTFNDx1.addMouseListener(new MouseAdapter() { // from class: Historia.JP_CP_DatosPyP.26
            public void mouseClicked(MouseEvent evt) {
                JP_CP_DatosPyP.this.JTFNDx1MouseClicked(evt);
            }
        });
        this.JTFNDx2.setFont(new Font("Arial", 1, 12));
        this.JTFNDx2.setHorizontalAlignment(4);
        this.JTFNDx2.setText("0000");
        this.JTFNDx2.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx2.setEnabled(false);
        this.JTFNDx2.addMouseListener(new MouseAdapter() { // from class: Historia.JP_CP_DatosPyP.27
            public void mouseClicked(MouseEvent evt) {
                JP_CP_DatosPyP.this.JTFNDx2MouseClicked(evt);
            }
        });
        this.JTFNDx3.setFont(new Font("Arial", 1, 12));
        this.JTFNDx3.setHorizontalAlignment(4);
        this.JTFNDx3.setText("0000");
        this.JTFNDx3.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx3", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx3.setEnabled(false);
        this.JTFNDx3.addMouseListener(new MouseAdapter() { // from class: Historia.JP_CP_DatosPyP.28
            public void mouseClicked(MouseEvent evt) {
                JP_CP_DatosPyP.this.JTFNDx3MouseClicked(evt);
            }
        });
        this.JBTAdicionarRN.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarRN.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarRN.setText("Adicionar");
        this.JBTAdicionarRN.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.29
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JBTAdicionarRNActionPerformed(evt);
            }
        });
        this.JSPNDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBNDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBNDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBNDetalle.setRowHeight(25);
        this.JTBNDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBNDetalle.setSelectionForeground(Color.red);
        this.JTBNDetalle.setSelectionMode(0);
        this.JSPNDetalle.setViewportView(this.JTBNDetalle);
        GroupLayout JPINacidoVivoLayout = new GroupLayout(this.JPINacidoVivo);
        this.JPINacidoVivo.setLayout(JPINacidoVivoLayout);
        JPINacidoVivoLayout.setHorizontalGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addContainerGap().addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JSPNDetalle).addContainerGap()).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JCBNSexo, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINVivo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNTalla).addGap(6, 6, 6).addComponent(this.JSPNPeso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNPCefalico, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNSGestacional, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNApgar1, -2, 88, -2).addGap(18, 18, 18).addComponent(this.JSPNApgar5, -2, 88, -2).addGap(8, 8, 8)).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JPINReanimacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINFalleceLP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINDefectoC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDx1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNDx2, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNDx3, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarRN, -1, -1, 32767).addContainerGap()))));
        JPINacidoVivoLayout.setVerticalGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addContainerGap().addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNTalla, -2, 50, -2).addComponent(this.JSPNPeso, -2, 50, -2).addComponent(this.JSPNPCefalico, -2, 50, -2).addComponent(this.JSPNSGestacional, -2, 50, -2).addComponent(this.JSPNApgar1, -2, 50, -2).addComponent(this.JSPNApgar5, -2, 50, -2)).addComponent(this.JPINVivo, -2, -1, -2).addComponent(this.JCBNSexo, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPINFalleceLP, -1, -1, 32767).addComponent(this.JPINReanimacion, -1, -1, 32767).addComponent(this.JPINDefectoC, -1, -1, 32767).addComponent(this.JTFNDx1).addComponent(this.JTFNDx2).addComponent(this.JTFNDx3).addComponent(this.JBTAdicionarRN, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNDetalle, -1, 120, 32767).addContainerGap()));
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPIDatosM.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA MADRE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDEFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEFecha.setDateFormatString("dd/MM/yyyy");
        this.JDEFecha.setFont(new Font("Arial", 1, 12));
        this.JPIEMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGEMotivo.add(this.JRBEParto);
        this.JRBEParto.setFont(new Font("Arial", 1, 12));
        this.JRBEParto.setSelected(true);
        this.JRBEParto.setText("Parto");
        this.JRBEParto.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.30
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEPartoActionPerformed(evt);
            }
        });
        this.JBGEMotivo.add(this.JRBEAborto);
        this.JRBEAborto.setFont(new Font("Arial", 1, 12));
        this.JRBEAborto.setText("Aborto");
        this.JRBEAborto.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.31
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEAbortoActionPerformed(evt);
            }
        });
        GroupLayout JPIEMotivoLayout = new GroupLayout(this.JPIEMotivo);
        this.JPIEMotivo.setLayout(JPIEMotivoLayout);
        JPIEMotivoLayout.setHorizontalGroup(JPIEMotivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEMotivoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEParto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEAborto).addContainerGap(-1, 32767)));
        JPIEMotivoLayout.setVerticalGroup(JPIEMotivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEMotivoLayout.createSequentialGroup().addGroup(JPIEMotivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEParto).addComponent(this.JRBEAborto)).addGap(0, 3, 32767)));
        this.JPIEHospit.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Hospitalización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDEHFIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEHFIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDEHFIngreso.setFont(new Font("Arial", 1, 12));
        this.JDEHFEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEHFEgreso.setDateFormatString("dd/MM/yyyy");
        this.JDEHFEgreso.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIEHospitLayout = new GroupLayout(this.JPIEHospit);
        this.JPIEHospit.setLayout(JPIEHospitLayout);
        JPIEHospitLayout.setHorizontalGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEHospitLayout.createSequentialGroup().addContainerGap().addComponent(this.JDEHFIngreso, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDEHFEgreso, -2, 110, -2).addContainerGap(14, 32767)));
        JPIEHospitLayout.setVerticalGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEHospitLayout.createSequentialGroup().addContainerGap().addGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDEHFIngreso, -1, -1, 32767).addComponent(this.JDEHFEgreso, -1, -1, 32767)).addContainerGap()));
        this.JPIEInicioParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicio del Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGEInicio.add(this.JRBEIEspontaneo);
        this.JRBEIEspontaneo.setFont(new Font("Arial", 1, 12));
        this.JRBEIEspontaneo.setSelected(true);
        this.JRBEIEspontaneo.setText("Espontaneo");
        this.JRBEIEspontaneo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.32
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEIEspontaneoActionPerformed(evt);
            }
        });
        this.JBGEInicio.add(this.JRBEIInducido);
        this.JRBEIInducido.setFont(new Font("Arial", 1, 12));
        this.JRBEIInducido.setText("Inducido");
        this.JRBEIInducido.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.33
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEIInducidoActionPerformed(evt);
            }
        });
        this.JBGEInicio.add(this.JRBEICesarea);
        this.JRBEICesarea.setFont(new Font("Arial", 1, 12));
        this.JRBEICesarea.setText("Cesárea Electiva");
        this.JRBEICesarea.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.34
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEICesareaActionPerformed(evt);
            }
        });
        GroupLayout JPIEInicioPartoLayout = new GroupLayout(this.JPIEInicioParto);
        this.JPIEInicioParto.setLayout(JPIEInicioPartoLayout);
        JPIEInicioPartoLayout.setHorizontalGroup(JPIEInicioPartoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEInicioPartoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEIEspontaneo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEIInducido).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEICesarea).addContainerGap(-1, 32767)));
        JPIEInicioPartoLayout.setVerticalGroup(JPIEInicioPartoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEInicioPartoLayout.createSequentialGroup().addGroup(JPIEInicioPartoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEIEspontaneo).addComponent(this.JRBEIInducido).addComponent(this.JRBEICesarea)).addContainerGap(-1, 32767)));
        this.JSPESGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPESGestacion.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPESGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEFObservaciones1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_DatosPyP.35
            public void keyPressed(KeyEvent evt) {
                JP_CP_DatosPyP.this.JTPEObservacionesKeyPressed(evt);
            }
        });
        this.JSPEFObservaciones1.setViewportView(this.JTPEObservaciones);
        this.JPIEViva.setBorder(BorderFactory.createTitledBorder((Border) null, "Viva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGViva.add(this.JRBEVSi);
        this.JRBEVSi.setFont(new Font("Arial", 1, 12));
        this.JRBEVSi.setSelected(true);
        this.JRBEVSi.setText("Si");
        this.JRBEVSi.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.36
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEVSiActionPerformed(evt);
            }
        });
        this.JBGViva.add(this.JRBEVNo);
        this.JRBEVNo.setFont(new Font("Arial", 1, 12));
        this.JRBEVNo.setText("No");
        this.JRBEVNo.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.37
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JRBEVNoActionPerformed(evt);
            }
        });
        GroupLayout JPIEVivaLayout = new GroupLayout(this.JPIEViva);
        this.JPIEViva.setLayout(JPIEVivaLayout);
        JPIEVivaLayout.setHorizontalGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEVivaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEVSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEVNo).addContainerGap(-1, 32767)));
        JPIEVivaLayout.setVerticalGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEVivaLayout.createSequentialGroup().addGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEVSi).addComponent(this.JRBEVNo)).addGap(0, 3, 32767)));
        this.JBTEGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTEGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTEGuardar.setText("Grabar");
        this.JBTEGuardar.addActionListener(new ActionListener() { // from class: Historia.JP_CP_DatosPyP.38
            public void actionPerformed(ActionEvent evt) {
                JP_CP_DatosPyP.this.JBTEGuardarActionPerformed(evt);
            }
        });
        this.JBTEGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_DatosPyP.39
            public void keyPressed(KeyEvent evt) {
                JP_CP_DatosPyP.this.JBTEGuardarKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosMLayout = new GroupLayout(this.JPIDatosM);
        this.JPIDatosM.setLayout(JPIDatosMLayout);
        JPIDatosMLayout.setHorizontalGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addComponent(this.JPIEHospit, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIEViva, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEFObservaciones1, -2, 257, -2).addGap(18, 18, 18).addComponent(this.JBTEGuardar)).addGroup(JPIDatosMLayout.createSequentialGroup().addComponent(this.JDEFecha, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEMotivo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIEInicioParto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPESGestacion, -2, 97, -2))).addContainerGap(-1, 32767)));
        JPIDatosMLayout.setVerticalGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDEFecha, -2, 50, -2).addComponent(this.JPIEMotivo, -2, -1, -2).addComponent(this.JPIEInicioParto, -2, -1, -2).addComponent(this.JSPESGestacion, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIEHospit, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPEFObservaciones1, GroupLayout.Alignment.LEADING).addComponent(this.JPIEViva, -2, -1, -2).addComponent(this.JBTEGuardar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("INFORMACIÓN", this.JPIDatosM);
        this.JSPHistorico1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO EGRESO AL PROGRAMA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistoricoEgreso.setFont(new Font("Arial", 1, 12));
        this.JTBHistoricoEgreso.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistoricoEgreso.setRowHeight(25);
        this.JTBHistoricoEgreso.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistoricoEgreso.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistorico1.setViewportView(this.JTBHistoricoEgreso);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 804, 32767).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico1, -1, 792, 32767).addContainerGap())));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 190, 32767).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico1, -1, 190, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO EGRESOS", this.JPHistorico);
        GroupLayout JPIEgresoLayout = new GroupLayout(this.JPIEgreso);
        this.JPIEgreso.setLayout(JPIEgresoLayout);
        JPIEgresoLayout.setHorizontalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addComponent(this.JPINacidoVivo, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPIEgresoLayout.setVerticalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.jTabbedPane1, -2, 219, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPINacidoVivo, -2, -1, -2).addContainerGap(13, 32767)));
        this.JTPDatos.addTab("EGRESO", this.JPIEgreso);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPDatos, -2, 854, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEFObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEFObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEPartoActionPerformed(ActionEvent evt) {
        this.xemotivo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEAbortoActionPerformed(ActionEvent evt) {
        this.xemotivo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEIEspontaneoActionPerformed(ActionEvent evt) {
        this.xeinicioparto = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEIInducidoActionPerformed(ActionEvent evt) {
        this.xeinicioparto = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEICesareaActionPerformed(ActionEvent evt) {
        this.xeinicioparto = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVSiActionPerformed(ActionEvent evt) {
        this.xeviva = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVNoActionPerformed(ActionEvent evt) {
        this.xeviva = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNVSiActionPerformed(ActionEvent evt) {
        this.xnvivo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNVNoActionPerformed(ActionEvent evt) {
        this.xnvivo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNRSiActionPerformed(ActionEvent evt) {
        this.xnreanimacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNRNoActionPerformed(ActionEvent evt) {
        this.xnreanimacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNFSiActionPerformed(ActionEvent evt) {
        this.xnfallecelp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNFNoActionPerformed(ActionEvent evt) {
        this.xnfallecelp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNDCSiActionPerformed(ActionEvent evt) {
        this.xndcongenito = 1;
        this.JTFNDx1.setEnabled(true);
        this.JTFNDx2.setEnabled(true);
        this.JTFNDx3.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNDCNoActionPerformed(ActionEvent evt) {
        this.xndcongenito = 0;
        this.JTFNDx1.setEnabled(false);
        this.JTFNDx2.setEnabled(false);
        this.JTFNDx3.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx2MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx3MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarRNActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xsql = "insert into g_partos(`Id_Persona`, `Cardinal`, `NHijo`, `Sexo`, `NacioVivo`, `Peso`, `Talla`, `PerimetroCefalico`, `Edad_Gestacional`, `Apgar1`, `Apgar5`, `Reanimacion`, `FalleceLP`, `DefectosCong`, `Dx1`, `Dx2`, `Dx3`, `Fecha`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xcardinal + "','" + this.xnhijo + "','" + this.JCBNSexo.getSelectedIndex() + "','" + this.xnvivo + "','" + this.JSPNPeso.getValue() + "','" + this.JSPNTalla.getValue() + "','" + this.JSPNPCefalico.getValue() + "','" + this.JSPNSGestacional.getValue() + "','" + this.JSPNApgar1.getValue() + "','" + this.JSPNApgar5.getValue() + "','" + this.xnreanimacion + "','" + this.xnfallecelp + "','" + this.xndcongenito + "','" + this.JTFNDx1.getText() + "','" + this.JTFNDx2.getText() + "','" + this.JTFNDx3.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mNuevoDRecienNacido();
            this.xnhijo++;
            mBuscarDatosEgreso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xsql = "update g_usuarioxprograma set FechaEgreso='" + this.xmt.formatoAMD.format(this.JDEFecha.getDate()) + "', MotivoEgreso='" + this.xemotivo + "',Fecha_Ingreso_Hosp='" + this.xmt.formatoAMD.format(this.JDEHFIngreso.getDate()) + "',Fecha_Egreso_Hosp='" + this.xmt.formatoAMD.format(this.JDEHFEgreso.getDate()) + "',InicioParto='" + this.xeinicioparto + "',Edad_Gestacion_Parto='" + this.JSPESGestacion.getValue() + "',Viva='" + this.xeviva + "',Estado=0 ,Id_Atencion_Egreso='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',Observacion_Egreso='" + this.JTPEObservaciones.getText() + "' where Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Id_Programa='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "' and Cardinal='" + this.xcardinal + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JBTAdicionarRN.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTri_1ActionPerformed(ActionEvent evt) {
        this.xtrimestre = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTri_2ActionPerformed(ActionEvent evt) {
        this.xtrimestre = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTri_3ActionPerformed(ActionEvent evt) {
        this.xtrimestre = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaActionPerformed(ActionEvent evt) {
        this.JTFFE_Peso.requestFocus();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaFocusGained(FocusEvent evt) {
        this.JTFFE_Talla.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoFocusGained(FocusEvent evt) {
        this.JTFFE_Peso.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSGestacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSGestacionFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSGestacionFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSPesoInicialActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSPesoInicialFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSPesoInicialFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NAFUMActionPerformed(ActionEvent evt) {
        if (this.NAFUM.isSelected()) {
            mStringToDate(this.JDFUM);
        } else {
            this.JDFUM.setDate((Date) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NAFPPActionPerformed(ActionEvent evt) {
        if (this.NAFPP.isSelected()) {
            mStringToDate(this.JDFPP);
        } else {
            this.JDFPP.setDate((Date) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFUMPropertyChange(PropertyChangeEvent evt) {
        if (this.JDFUM.getDate() != null && !this.xmt.formatoAMD.format(this.JDFUM.getDate()).equals("1800/01/01")) {
            this.JSPSGestacion.setText("" + this.xmt.mSemanaGestacion(this.xmt.formatoAMD.format(this.JDFUM.getDate())));
            this.JDFPP.setDate(getFPP(this.xmt.formatoAMD.format(this.JDFUM.getDate())));
        } else {
            this.JSPSGestacion.setText("0");
            mStringToDate(this.JDFPP);
        }
    }

    private Date getFPP(String xFUM) {
        Date xValor = null;
        String sql = "SELECT DATE_SUB(ADDDATE(DATE_ADD(('" + xFUM + "'),INTERVAL 1 YEAR),7),INTERVAL 3 MONTH) AS FPP";
        ConsultasMySQL xctr = new ConsultasMySQL();
        ResultSet xrs = xctr.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDate("FPP");
            }
            xrs.close();
            xctr.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    private int getTalla() {
        int valor = 0;
        if (this.JTFFE_Talla.getText() != null && !this.JTFFE_Talla.getText().equals("") && Integer.parseInt(this.JTFFE_Talla.getText()) > 0) {
            valor = Integer.parseInt(this.JTFFE_Talla.getText());
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFE_Peso.getText() != null && !this.JTFFE_Peso.getText().equals("") && Double.parseDouble(this.JTFFE_Peso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFE_Peso.getText());
        }
        return valor;
    }

    private void mCalcularImc() {
        if (this.JTFFE_Talla.getText() != null && this.JTFFE_Peso.getText() != null) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFE_IMC.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.JTFFE_IMC.setText("0.0");
    }

    private void mNuevo() {
        this.JDEFecha.setDate(this.xmt.getFechaActual());
        this.JDEHFEgreso.setDate(this.xmt.getFechaActual());
        this.JDEHFIngreso.setDate(this.xmt.getFechaActual());
        mCrearTablaRecienNacido();
        this.xesingreso = 0;
    }

    private void mNuevoDRecienNacido() {
        this.JSPNApgar1.setValue(new Integer(0));
        this.JSPNApgar5.setValue(new Integer(0));
        this.JSPNPCefalico.setValue(new Integer(0));
        this.JSPNPeso.setValue(new Integer(0));
        this.JSPNSGestacional.setValue(new Integer(0));
        this.JSPNTalla.setValue(new Integer(0));
        this.JTFNDx1.setText("0000");
        this.JTFNDx2.setText("0000");
        this.JTFNDx3.setText("0000");
        this.JCBNSexo.requestFocus();
    }

    private void mBuscarPatologiaN(JTextField codigo) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, codigo, "EgresoPyP");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mGrabarBd() {
        if (Double.parseDouble(this.JTFFE_Talla.getText()) <= 0.0d) {
            JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Debe digitar la talla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_Talla.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFE_Peso.getText()) > 0.0d) {
            if (this.JDFUM.getDate() != null) {
                if (this.JDFPP.getDate() != null) {
                    if (this.JSPNSGestacional.getValue().equals("0")) {
                        JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Debe digitar la semana de gestación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JSPNSGestacional.requestFocus();
                        return;
                    }
                    if (Double.parseDouble(this.JSPSPesoInicial.getText()) > 0.0d) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() == 0) {
                                this.xsql = "insert into g_usuarioxprograma (`Id_Usuario`, `Id_Programa`,Cardinal, `FechaIngreso`, Id_Atencion_Ingreso, `UltimaMestruacion`, `PartoProbable`, `SemanaGestacion`, `Peso_Inicio`, `FUP`, `ObservacionIngreso`, Trimestre, CPIngresoTardio,CPPlanEmbarazo,CPTalla,CPPeso,CPIMC, Fecha,mujerCabezaF,apoyoFamiliar , UsuarioS)  values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "','" + this.xcardinal + "','" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + mDevolverFecha(this.JDFUM.getDate()) + "','" + mDevolverFecha(this.JDFPP.getDate()) + "','" + this.JSPSGestacion.getText() + "','" + this.JSPSPesoInicial.getText() + "','" + mDevolverFecha(this.JDFUPP.getDate()) + "','" + this.JTPEFObservaciones.getText() + "','" + this.xtrimestre + "','" + this.JCBCausasIngTardio.getSelectedItem() + "','" + this.JCBPlaneacionEmb.getSelectedItem() + "','" + this.JTFFE_Talla.getText() + "','" + this.JTFFE_Peso.getText() + "','" + this.JTFFE_IMC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.JCBMujerCF.getSelectedItem() + "','" + this.JCBApoyoF.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(this.xct.ejecutarSQLId(this.xsql)));
                                this.xct.cerrarConexionBd();
                                mBuscaHistoricoIngresos();
                                mGrabaUserPro_h_atencion();
                                return;
                            }
                            this.xsql = "Update g_usuarioxprograma set FechaIngreso='" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "',UltimaMestruacion='" + mDevolverFecha(this.JDFUM.getDate()) + "',PartoProbable='" + mDevolverFecha(this.JDFPP.getDate()) + "',SemanaGestacion='" + this.JSPSGestacion.getText() + "',Peso_Inicio='" + this.JSPSPesoInicial.getText() + "',Trimestre='" + this.xtrimestre + "',CPIngresoTardio='" + this.JCBCausasIngTardio.getSelectedItem() + "',CPPlanEmbarazo='" + this.JCBPlaneacionEmb.getSelectedItem() + "',CPTalla='" + this.JTFFE_Talla.getText() + "',CPPeso='" + this.JTFFE_Peso.getText() + "',CPIMC='" + this.JTFFE_IMC.getText() + "',FUP='" + mDevolverFecha(this.JDFUPP.getDate()) + "',ObservacionIngreso='" + this.JTPEFObservaciones.getText() + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mGrabaUserPro_h_atencion();
                            mBuscaHistoricoIngresos();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Debe digitar el peso inicial", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JSPSPesoInicial.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Falta digitar FPP", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JDFPP.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Falta digitar FUM", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JDFUM.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(Principal.clasehistoriace.xjifhistoriaclinica, "Debe digitar el peso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFE_Peso.requestFocus();
    }

    private void mGrabaUserPro_h_atencion() {
        String sql = "UPDATE h_atencion SET IdUsuarioPrograma='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' WHERE Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private String mDevolverFecha(Date xfecha) {
        String fecha = "1800-01-01";
        if (xfecha != null) {
            fecha = this.xmt.formatoAMD.format(xfecha);
        }
        return fecha;
    }

    private void mBuscarDatosIngreso() {
        try {
            this.xsql = "SELECT `FechaIngreso`, `UltimaMestruacion`, `PartoProbable`, `SemanaGestacion`, `ObservacionIngreso`, Cardinal, Peso_Inicio, Trimestre, CPIngresoTardio, CPPlanEmbarazo, CPTalla, CPPeso, CPIMC, FUP ,apoyoFamiliar , mujerCabezaF  FROM `g_usuarioxprograma` WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' AND `Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "' AND `FechaEgreso` IS NULL) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JDFecha.setDate(xrs.getDate(1));
                this.JDFUM.setDate(xrs.getDate(2));
                this.JDFPP.setDate(xrs.getDate(3));
                this.JSPSGestacion.setText(xrs.getString(4));
                this.JTPEFObservaciones.setText(xrs.getString(5));
                this.JSPSPesoInicial.setText(xrs.getString(7));
                this.xcardinal = xrs.getInt(6);
                if (xrs.getLong("Trimestre") == 1) {
                    this.xtrimestre = 1;
                    this.JRBTri_1.setSelected(true);
                } else if (xrs.getLong("Trimestre") == 2) {
                    this.xtrimestre = 2;
                    this.JRBTri_2.setSelected(true);
                } else {
                    this.xtrimestre = 3;
                    this.JRBTri_3.setSelected(true);
                }
                this.JCBCausasIngTardio.setSelectedItem(xrs.getString("CPIngresoTardio"));
                this.JCBPlaneacionEmb.setSelectedItem(xrs.getString("CPPlanEmbarazo"));
                this.JTFFE_Talla.setText(xrs.getString("CPTalla"));
                this.JTFFE_Peso.setText(xrs.getString("CPPeso"));
                this.JTFFE_IMC.setText(xrs.getString("CPIMC"));
                this.JDFUPP.setDate(xrs.getDate("FUP"));
                this.JCBApoyoF.setSelectedItem(xrs.getString("apoyoFamiliar"));
                this.JCBMujerCF.setSelectedItem(xrs.getString("mujerCabezaF"));
            } else {
                mNuevo();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_CP_DatosPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosEgreso() {
        try {
            this.xsql = "SELECT `g_usuarioxprograma`.`FechaEgreso`, `g_usuarioxprograma`.`MotivoEgreso`, `g_usuarioxprograma`.`Fecha_Ingreso_Hosp`, `g_usuarioxprograma`.`Fecha_Egreso_Hosp`, `g_usuarioxprograma`.`InicioParto`, `g_usuarioxprograma`.`Edad_Gestacion_Parto`, `g_usuarioxprograma`.`Viva` , `g_usuarioxprograma`.`Observacion_Egreso` , `g_partos`.`NHijo` , `g_partos`.`Sexo` , IF(`g_partos`.`NacioVivo`,'SI','NO') AS NVivo , `g_partos`.`Peso` , `g_partos`.`Talla` , `g_partos`.`PerimetroCefalico` , `g_partos`.`Edad_Gestacional` , `g_partos`.`Apgar1` , `g_partos`.`Apgar5` , IF(`g_partos`.`Reanimacion`,'SI','NO') AS Reanimacion , IF(`g_partos`.`FalleceLP`,'SI','NO') AS FalleceLP , IF(`g_partos`.`DefectosCong`,'SI','NO') AS DefectosC , `g_partos`.`Dx1` , `g_partos`.`Dx2` , `g_partos`.`Dx3` FROM  `g_partos` INNER JOIN  `g_usuarioxprograma`  ON (`g_partos`.`Id_Persona` = `g_usuarioxprograma`.`Id_Usuario`) AND (`g_partos`.`Cardinal` = `g_usuarioxprograma`.`Cardinal`) WHERE (`g_usuarioxprograma`.`Id_Atencion_Egreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ORDER BY  `g_partos`.`NHijo` ASC  ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JDEFecha.setDate(xrs.getDate(1));
                if (xrs.getInt(2) == 0) {
                    this.JRBEParto.setSelected(true);
                } else {
                    this.JRBEAborto.setSelected(true);
                }
                this.JDEHFIngreso.setDate(xrs.getDate(3));
                this.JDEHFEgreso.setDate(xrs.getDate(4));
                if (xrs.getInt(5) == 0) {
                    this.JRBEIEspontaneo.setSelected(true);
                } else if (xrs.getInt(5) == 1) {
                    this.JRBEIInducido.setSelected(true);
                } else {
                    this.JRBEICesarea.setSelected(true);
                }
                this.JSPESGestacion.setValue(Double.valueOf(xrs.getDouble(6)));
                if (xrs.getInt(7) == 0) {
                    this.JRBEVNo.setSelected(true);
                } else {
                    this.JRBEVSi.setSelected(true);
                }
                this.JTPEObservaciones.setText(xrs.getString(8));
                xrs.beforeFirst();
                mCrearTablaRecienNacido();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), x, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(16)), x, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(17)), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(18), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(19), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(20), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(21), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(22), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(23), x, 14);
                    x++;
                }
                this.JBTEGuardar.setEnabled(false);
                this.JBTAdicionarRN.setEnabled(false);
            } else {
                mNuevo();
                this.JBTEGuardar.setEnabled(true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_CP_DatosPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaRecienNacido() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Hijo", "Sexo", "NVivo", "Peso", "Talla", "PCefalico", "EGestacional", "Apgar1", "Apgar5", "Reanimación", "FLugarParto", "DCongenito", "Dx1", "Dx2", "Dx3"}) { // from class: Historia.JP_CP_DatosPyP.40
            Class[] types = {Integer.class, String.class, String.class, Double.class, Double.class, Double.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBNDetalle.setModel(this.xmodelo);
        this.JTBNDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(8).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(9).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(10).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(11).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloHistoricoIngreso() {
        this.xmodeloHIngreso = new DefaultTableModel(new Object[0], new String[]{"FechaIngreso", "Ultima Mestración", "PartoProbable", "SGestación", "ObsIngreso", "Cardinal", "PesoInicial", "Trimestre", "IngresoTardio", "PlanEmbarazo", "Talla", "Peso", "IMC", "FUP", "FechaEgreso", "MujerCabezaF", "ApoyoFamiliar"}) { // from class: Historia.JP_CP_DatosPyP.41
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistoricoIngreso.setModel(this.xmodeloHIngreso);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(11).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(12).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(14).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(15).setPreferredWidth(30);
        this.JTBHistoricoIngreso.getColumnModel().getColumn(16).setPreferredWidth(30);
    }

    private void mBuscaHistoricoIngresos() {
        mCreaModeloHistoricoIngreso();
        String sql = "SELECT `FechaIngreso`, `UltimaMestruacion`, `PartoProbable`, `SemanaGestacion`, `ObservacionIngreso`, Cardinal, Peso_Inicio, Trimestre, CPIngresoTardio, CPPlanEmbarazo, CPTalla, CPPeso, CPIMC, FUP, IF(`FechaEgreso` IS NULL, 'ACTIVO',FechaEgreso) AS FechaEgreso , mujerCabezaF ,apoyoFamiliar   FROM `g_usuarioxprograma` WHERE (Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "') ORDER BY FechaIngreso DESC";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHIngreso.addRow(this.xdato);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(16), n, 15);
                    this.xmodeloHIngreso.setValueAt(xrs.getString(17), n, 16);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_CP_DatosPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloHistoricoEgreso() {
        this.xmodeloHEgreso = new DefaultTableModel(new Object[0], new String[]{"Fecha Egreso", "Motivo Egreso", "Fecha IngHospital", "FechaEgrHospital", "InicioParto", "EdadGestacion", "Vivo?", "ObservaciónEgreso"}) { // from class: Historia.JP_CP_DatosPyP.42
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistoricoEgreso.setModel(this.xmodeloHEgreso);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBHistoricoEgreso.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mBuscaHistoricoEgresos() {
        mCreaModeloHistoricoEgreso();
        String sql = "SELECT `g_usuarioxprograma`.`FechaEgreso`, IF(`g_usuarioxprograma`.`MotivoEgreso`=0,'Parto','Aborto') AS MotivoEgreso, `g_usuarioxprograma`.`Fecha_Ingreso_Hosp`, `g_usuarioxprograma`.`Fecha_Egreso_Hosp`, IF(`g_usuarioxprograma`.`InicioParto`=0,'Espontaneo',IF(`g_usuarioxprograma`.`InicioParto`=1,'Inducido','Cesarea Electiva')) AS InicioParto, `g_usuarioxprograma`.`Edad_Gestacion_Parto`, IF(`g_usuarioxprograma`.`Viva`=1,'Si','No') AS Viva   , `g_usuarioxprograma`.`Observacion_Egreso` , `g_partos`.`NHijo` , `g_partos`.`Sexo` , IF(`g_partos`.`NacioVivo`,'SI','NO') AS NVivo , `g_partos`.`Peso` , `g_partos`.`Talla` , `g_partos`.`PerimetroCefalico` , `g_partos`.`Edad_Gestacional`    , `g_partos`.`Apgar1` , `g_partos`.`Apgar5` , IF(`g_partos`.`Reanimacion`,'SI','NO') AS Reanimacion , IF(`g_partos`.`FalleceLP`,'SI','NO') AS FalleceLP , IF(`g_partos`.`DefectosCong`,'SI','NO') AS DefectosC , `g_partos`.`Dx1` , `g_partos`.`Dx2` , `g_partos`.`Dx3`    FROM  `g_partos` INNER JOIN  `g_usuarioxprograma`  ON (`g_partos`.`Id_Persona` = `g_usuarioxprograma`.`Id_Usuario`) AND (`g_partos`.`Cardinal` = `g_usuarioxprograma`.`Cardinal`)    WHERE (`g_usuarioxprograma`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `g_usuarioxprograma`.`FechaEgreso` IS NOT NULL) ORDER BY `g_usuarioxprograma`.`FechaEgreso` DESC  ";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHEgreso.addRow(this.xdato);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloHEgreso.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_CP_DatosPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mStringToDate(JDateChooser xFecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            xFecha.setDate(formato.parse("01/01/1800"));
        } catch (ParseException e) {
        }
    }
}
