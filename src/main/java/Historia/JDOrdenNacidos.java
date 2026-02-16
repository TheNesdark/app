package Historia;

import Acceso.Principal;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDOrdenNacidos.class */
public class JDOrdenNacidos extends JDialog {
    private Metodos xmt;
    private int xmenbrana;
    private int xPEspontaneo;
    private int xCesarea;
    private int xSuFetal;
    private int xMeconio;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private int xnfilas;
    private ConsultasMySQL xct;
    private String xEncabezado;
    public String xOrdenQx;
    private boolean xlleno;
    private String[] idDestino;
    private ButtonGroup Cesarea;
    private ButtonGroup Clasificacion;
    private ButtonGroup ClasificacionPeso;
    private ButtonGroup Estado;
    private JButton JBAGrabar;
    private JButton JBAImprimir;
    private JButton JBANovedad;
    private JButton JBASalir;
    private JButton JBAgregar;
    private JComboBox JCBDestino;
    private JComboBox JCBLiqAmiotico;
    private JComboBox JCBPlacenta;
    private JComboBox JCBPresentacion;
    public JDateChooser JDCFechaNac;
    private JPanel JPDatos;
    private JRadioButton JRBCesNO;
    private JRadioButton JRBCesSI;
    private JRadioButton JRBEspoNO;
    private JRadioButton JRBEspoSI;
    private JRadioButton JRBFem;
    private JRadioButton JRBMasc;
    private JRadioButton JRBMembNo;
    private JRadioButton JRBMembSI;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBProfNo;
    private JRadioButton JRBProfSi;
    private JRadioButton JRBReanNo1;
    private JRadioButton JRBReanSI1;
    private JRadioButton JRBSFetalNo;
    private JRadioButton JRBSFetalSi;
    private JRadioButton JRBVitaNo;
    private JRadioButton JRBVitaNo2;
    private JRadioButton JRBVitaNo3;
    private JRadioButton JRBVitaNo4;
    private JRadioButton JRBVitaNo5;
    private JRadioButton JRBVitaNo6;
    private JRadioButton JRBVitaSi;
    private JRadioButton JRBVitaSi2;
    private JRadioButton JRBVivo;
    private JTextField JTFAPGar;
    public JTextField JTFDx;
    private JTextArea JTFExaFisico;
    public JTextFieldValidator JTFFPCefalico;
    public JTextFieldValidator JTFFPToraxico;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    private JFormattedTextField JTFF_EdadGestacional;
    public JTextFieldValidator JTFF_NControles;
    private JTextArea JTFMed;
    private JTextArea JTFOtros;
    public JTextField JTFPatologia;
    private JTable JTNacidos;
    private JRadioButton M2;
    private JRadioButton M3;
    private JRadioButton MI;
    private ButtonGroup Meconio;
    private ButtonGroup Membrana;
    private ButtonGroup PEspontaneo;
    private ButtonGroup ProfOculas;
    private ButtonGroup Reanimacion;
    private ButtonGroup SFEtales;
    private ButtonGroup Sexo;
    private ButtonGroup Vitamina;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    public JFormattedTextField txtHora;

    public JDOrdenNacidos(Frame parent, boolean modal, String xOrdenQx) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xmenbrana = 1;
        this.xPEspontaneo = 1;
        this.xCesarea = 0;
        this.xSuFetal = 0;
        this.xMeconio = 0;
        this.xnfilas = 0;
        this.xct = new ConsultasMySQL();
        this.xEncabezado = "";
        this.xOrdenQx = "";
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("DATOS RECIEN NACIDOS");
        this.xOrdenQx = xOrdenQx;
        setLocationRelativeTo(null);
        mIniciaComp();
        mBuscaInformacion(this.xOrdenQx);
        mVerificaEncabezadoRN();
    }

    /* JADX WARN: Type inference failed for: r3v334, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Membrana = new ButtonGroup();
        this.PEspontaneo = new ButtonGroup();
        this.Cesarea = new ButtonGroup();
        this.SFEtales = new ButtonGroup();
        this.Estado = new ButtonGroup();
        this.Sexo = new ButtonGroup();
        this.Reanimacion = new ButtonGroup();
        this.Vitamina = new ButtonGroup();
        this.ProfOculas = new ButtonGroup();
        this.Clasificacion = new ButtonGroup();
        this.ClasificacionPeso = new ButtonGroup();
        this.Meconio = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JCBPresentacion = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JRBMembSI = new JRadioButton();
        this.JRBMembNo = new JRadioButton();
        this.JCBLiqAmiotico = new JComboBox();
        this.jPanel2 = new JPanel();
        this.JRBEspoSI = new JRadioButton();
        this.JRBEspoNO = new JRadioButton();
        this.jPanel3 = new JPanel();
        this.JRBCesSI = new JRadioButton();
        this.JRBCesNO = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTFOtros = new JTextArea();
        this.jPanel4 = new JPanel();
        this.JRBSFetalSi = new JRadioButton();
        this.JRBSFetalNo = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTFMed = new JTextArea();
        this.jPanel12 = new JPanel();
        this.MI = new JRadioButton();
        this.M2 = new JRadioButton();
        this.M3 = new JRadioButton();
        this.JTFF_EdadGestacional = new JFormattedTextField();
        this.JTFF_NControles = new JTextFieldValidator();
        this.jPanel5 = new JPanel();
        this.JDCFechaNac = new JDateChooser();
        this.txtHora = new JFormattedTextField();
        this.JCBPlacenta = new JComboBox();
        this.jPanel6 = new JPanel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.jPanel7 = new JPanel();
        this.JRBMasc = new JRadioButton();
        this.JRBFem = new JRadioButton();
        this.JTFAPGar = new JTextField();
        this.jPanel8 = new JPanel();
        this.JRBVitaSi = new JRadioButton();
        this.JRBVitaNo = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.JRBReanSI1 = new JRadioButton();
        this.JRBReanNo1 = new JRadioButton();
        this.jPanel10 = new JPanel();
        this.JRBProfSi = new JRadioButton();
        this.JRBProfNo = new JRadioButton();
        this.jPanel11 = new JPanel();
        this.JRBVitaSi2 = new JRadioButton();
        this.JRBVitaNo2 = new JRadioButton();
        this.JRBVitaNo3 = new JRadioButton();
        this.JRBVitaNo4 = new JRadioButton();
        this.JRBVitaNo5 = new JRadioButton();
        this.JRBVitaNo6 = new JRadioButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTFExaFisico = new JTextArea();
        this.JTFDx = new JTextField();
        this.JTFPatologia = new JTextField();
        this.jButton1 = new JButton();
        this.JTFFPCefalico = new JTextFieldValidator();
        this.JTFFPToraxico = new JTextFieldValidator();
        this.JCBDestino = new JComboBox();
        this.JBAgregar = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTNacidos = new JTable();
        this.JBAGrabar = new JButton();
        this.JBASalir = new JButton();
        this.JBAImprimir = new JButton();
        this.JBANovedad = new JButton();
        setDefaultCloseOperation(2);
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBPresentacion.setFont(new Font("Arial", 1, 12));
        this.JCBPresentacion.setModel(new DefaultComboBoxModel(new String[]{"", "PODALICO", "CEFALICO"}));
        this.JCBPresentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESENTACIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruptura de Membrana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Membrana.add(this.JRBMembSI);
        this.JRBMembSI.setFont(new Font("Arial", 1, 12));
        this.JRBMembSI.setSelected(true);
        this.JRBMembSI.setText("SI");
        this.JRBMembSI.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.1
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBMembSIActionPerformed(evt);
            }
        });
        this.Membrana.add(this.JRBMembNo);
        this.JRBMembNo.setFont(new Font("Arial", 1, 12));
        this.JRBMembNo.setText("NO");
        this.JRBMembNo.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.2
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBMembNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBMembSI).addGap(18, 18, 18).addComponent(this.JRBMembNo).addContainerGap(36, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMembSI).addComponent(this.JRBMembNo))));
        this.JCBLiqAmiotico.setFont(new Font("Arial", 1, 12));
        this.JCBLiqAmiotico.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "ANORMAL"}));
        this.JCBLiqAmiotico.setBorder(BorderFactory.createTitledBorder((Border) null, "LIQ. AMNIÓTICO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLiqAmiotico.addItemListener(new ItemListener() { // from class: Historia.JDOrdenNacidos.3
            public void itemStateChanged(ItemEvent evt) {
                JDOrdenNacidos.this.JCBLiqAmioticoItemStateChanged(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Parto espontaneo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.PEspontaneo.add(this.JRBEspoSI);
        this.JRBEspoSI.setFont(new Font("Arial", 1, 12));
        this.JRBEspoSI.setSelected(true);
        this.JRBEspoSI.setText("SI");
        this.JRBEspoSI.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.4
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBEspoSIActionPerformed(evt);
            }
        });
        this.PEspontaneo.add(this.JRBEspoNO);
        this.JRBEspoNO.setFont(new Font("Arial", 1, 12));
        this.JRBEspoNO.setText("NO");
        this.JRBEspoNO.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.5
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBEspoNOActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBEspoSI).addGap(18, 18, 18).addComponent(this.JRBEspoNO).addContainerGap(36, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEspoSI).addComponent(this.JRBEspoNO))));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Cesarea", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Cesarea.add(this.JRBCesSI);
        this.JRBCesSI.setFont(new Font("Arial", 1, 12));
        this.JRBCesSI.setText("SI");
        this.JRBCesSI.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.6
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBCesSIActionPerformed(evt);
            }
        });
        this.Cesarea.add(this.JRBCesNO);
        this.JRBCesNO.setFont(new Font("Arial", 1, 12));
        this.JRBCesNO.setSelected(true);
        this.JRBCesNO.setText("NO");
        this.JRBCesNO.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.7
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBCesNOActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBCesSI).addGap(18, 18, 18).addComponent(this.JRBCesNO).addContainerGap(36, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCesSI).addComponent(this.JRBCesNO))));
        this.JTFOtros.setColumns(1);
        this.JTFOtros.setLineWrap(true);
        this.JTFOtros.setRows(1);
        this.JTFOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTFOtros);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Sufrimientos Fetales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.SFEtales.add(this.JRBSFetalSi);
        this.JRBSFetalSi.setFont(new Font("Arial", 1, 12));
        this.JRBSFetalSi.setText("SI");
        this.JRBSFetalSi.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.8
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBSFetalSiActionPerformed(evt);
            }
        });
        this.SFEtales.add(this.JRBSFetalNo);
        this.JRBSFetalNo.setFont(new Font("Arial", 1, 12));
        this.JRBSFetalNo.setSelected(true);
        this.JRBSFetalNo.setText("NO");
        this.JRBSFetalNo.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.9
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBSFetalNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBSFetalSi).addGap(18, 18, 18).addComponent(this.JRBSFetalNo).addContainerGap(36, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSFetalSi).addComponent(this.JRBSFetalNo))));
        this.JTFMed.setColumns(1);
        this.JTFMed.setLineWrap(true);
        this.JTFMed.setRows(1);
        this.JTFMed.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamentos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTFMed);
        this.jPanel12.setBorder(BorderFactory.createTitledBorder((Border) null, "Meconio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Meconio.add(this.MI);
        this.MI.setFont(new Font("Arial", 1, 12));
        this.MI.setText("I");
        this.MI.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.10
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.MIActionPerformed(evt);
            }
        });
        this.Meconio.add(this.M2);
        this.M2.setFont(new Font("Arial", 1, 12));
        this.M2.setText("II");
        this.M2.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.11
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.M2ActionPerformed(evt);
            }
        });
        this.Meconio.add(this.M3);
        this.M3.setFont(new Font("Arial", 1, 12));
        this.M3.setText("III");
        this.M3.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.12
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.M3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.MI).addGap(5, 5, 5).addComponent(this.M2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.M3).addContainerGap()));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.MI).addComponent(this.M2).addComponent(this.M3))));
        this.JTFF_EdadGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad gestacional (Semanas)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_EdadGestacional.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.JTFF_EdadGestacional.setHorizontalAlignment(4);
        this.JTFF_EdadGestacional.setToolTipText("Semanas de Gestación");
        this.JTFF_EdadGestacional.setFont(new Font("Arial", 1, 12));
        this.JTFF_EdadGestacional.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.13
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFF_EdadGestacionalFocusGained(evt);
            }
        });
        this.JTFF_EdadGestacional.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.14
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFF_EdadGestacionalActionPerformed(evt);
            }
        });
        this.JTFF_NControles.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Controles", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_NControles.setHorizontalAlignment(0);
        this.JTFF_NControles.setText("0");
        this.JTFF_NControles.setToolTipText("Número de controles prenatales");
        this.JTFF_NControles.setExprecionRegular("^[0.0-9]*$");
        this.JTFF_NControles.setFocusAccelerator('C');
        this.JTFF_NControles.setFont(new Font("Arial", 1, 12));
        this.JTFF_NControles.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.15
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFF_NControlesFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFF_NControlesFocusLost(evt);
            }
        });
        this.JTFF_NControles.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.16
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFF_NControlesActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBPresentacion, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBLiqAmiotico, -2, 155, -2).addGap(0, 0, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1)).addComponent(this.jScrollPane2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel12, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2)).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(123, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFF_EdadGestacional, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_NControles, -1, 116, 32767).addGap(72, 72, 72)))));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBLiqAmiotico, -2, 46, -2).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPresentacion, -2, 46, -2).addComponent(this.jPanel1, -2, -1, -2)).addComponent(this.jPanel12, -2, -1, -2).addComponent(this.jPanel2, -2, -1, -2)).addGap(6, 6, 6).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.jPanel4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 1, 32767).addComponent(this.JTFF_EdadGestacional, -2, 45, -2).addGap(5, 5, 5)).addComponent(this.JTFF_NControles, -1, -1, 32767).addComponent(this.jScrollPane2))));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RECIÉN NACIDO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JDCFechaNac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nac", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNac.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaNac.setFont(new Font("Arial", 1, 12));
        this.JDCFechaNac.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JDOrdenNacidos.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDOrdenNacidos.this.JDCFechaNacPropertyChange(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Historia.JDOrdenNacidos.18
            public void keyPressed(KeyEvent evt) {
                JDOrdenNacidos.this.txtHoraKeyPressed(evt);
            }
        });
        this.JCBPlacenta.setFont(new Font("Arial", 1, 12));
        this.JCBPlacenta.setModel(new DefaultComboBoxModel(new String[]{"COMPLETA", "INCOMPLETA"}));
        this.JCBPlacenta.setBorder(BorderFactory.createTitledBorder((Border) null, "PLACENTA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Estado.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("VIVO");
        this.Estado.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setText("MUERTO");
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBVivo).addGap(5, 5, 5).addComponent(this.JRBMuerto).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVivo).addComponent(this.JRBMuerto))));
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.19
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.20
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Gr)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Gramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.21
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.22
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Sexo.add(this.JRBMasc);
        this.JRBMasc.setFont(new Font("Arial", 1, 12));
        this.JRBMasc.setText("MASCULINO");
        this.Sexo.add(this.JRBFem);
        this.JRBFem.setFont(new Font("Arial", 1, 12));
        this.JRBFem.setText("FEMENINO");
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBMasc).addGap(5, 5, 5).addComponent(this.JRBFem).addContainerGap(-1, 32767)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMasc).addComponent(this.JRBFem))));
        this.JTFAPGar.setFont(new Font("Arial", 1, 12));
        this.JTFAPGar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue), "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "VitaminaK", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Vitamina.add(this.JRBVitaSi);
        this.JRBVitaSi.setFont(new Font("Arial", 1, 12));
        this.JRBVitaSi.setSelected(true);
        this.JRBVitaSi.setText("SI");
        this.Vitamina.add(this.JRBVitaNo);
        this.JRBVitaNo.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo.setText("NO");
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBVitaSi).addGap(18, 18, 18).addComponent(this.JRBVitaNo).addContainerGap(-1, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVitaSi).addComponent(this.JRBVitaNo))));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "Reanimación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Reanimacion.add(this.JRBReanSI1);
        this.JRBReanSI1.setFont(new Font("Arial", 1, 12));
        this.JRBReanSI1.setText("SI");
        this.Reanimacion.add(this.JRBReanNo1);
        this.JRBReanNo1.setFont(new Font("Arial", 1, 12));
        this.JRBReanNo1.setSelected(true);
        this.JRBReanNo1.setText("NO");
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBReanSI1).addGap(18, 18, 18).addComponent(this.JRBReanNo1).addContainerGap(-1, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBReanSI1).addComponent(this.JRBReanNo1))));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "Profilaxis Ocular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.ProfOculas.add(this.JRBProfSi);
        this.JRBProfSi.setFont(new Font("Arial", 1, 12));
        this.JRBProfSi.setSelected(true);
        this.JRBProfSi.setText("SI");
        this.ProfOculas.add(this.JRBProfNo);
        this.JRBProfNo.setFont(new Font("Arial", 1, 12));
        this.JRBProfNo.setText("NO");
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBProfSi).addGap(18, 18, 18).addComponent(this.JRBProfNo).addContainerGap(-1, 32767)));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProfSi).addComponent(this.JRBProfNo))));
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Clasificacion.add(this.JRBVitaSi2);
        this.JRBVitaSi2.setFont(new Font("Arial", 1, 12));
        this.JRBVitaSi2.setText("(RNP)");
        this.JRBVitaSi2.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.23
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JRBVitaSi2ActionPerformed(evt);
            }
        });
        this.Clasificacion.add(this.JRBVitaNo2);
        this.JRBVitaNo2.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo2.setSelected(true);
        this.JRBVitaNo2.setText("(RNT)");
        this.Clasificacion.add(this.JRBVitaNo3);
        this.JRBVitaNo3.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo3.setText("(RNPO)");
        this.ClasificacionPeso.add(this.JRBVitaNo4);
        this.JRBVitaNo4.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo4.setText("(GEG)");
        this.ClasificacionPeso.add(this.JRBVitaNo5);
        this.JRBVitaNo5.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo5.setSelected(true);
        this.JRBVitaNo5.setText("(AEG)");
        this.ClasificacionPeso.add(this.JRBVitaNo6);
        this.JRBVitaNo6.setFont(new Font("Arial", 1, 12));
        this.JRBVitaNo6.setText("(PEG)");
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBVitaSi2).addGap(3, 3, 3).addComponent(this.JRBVitaNo2).addGap(3, 3, 3).addComponent(this.JRBVitaNo3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVitaNo4).addGap(3, 3, 3).addComponent(this.JRBVitaNo5).addGap(3, 3, 3).addComponent(this.JRBVitaNo6).addGap(3, 3, 3)));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVitaSi2).addComponent(this.JRBVitaNo2).addComponent(this.JRBVitaNo3).addComponent(this.JRBVitaNo4).addComponent(this.JRBVitaNo5).addComponent(this.JRBVitaNo6))));
        this.JTFExaFisico.setColumns(1);
        this.JTFExaFisico.setLineWrap(true);
        this.JTFExaFisico.setRows(1);
        this.JTFExaFisico.setBorder(BorderFactory.createTitledBorder((Border) null, "Examen Físico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTFExaFisico);
        this.JTFDx.setFont(new Font("Arial", 1, 12));
        this.JTFDx.setHorizontalAlignment(0);
        this.JTFDx.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDx.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.24
            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFDxFocusLost(evt);
            }
        });
        this.JTFDx.addKeyListener(new KeyAdapter() { // from class: Historia.JDOrdenNacidos.25
            public void keyPressed(KeyEvent evt) {
                JDOrdenNacidos.this.JTFDxKeyPressed(evt);
            }
        });
        this.JTFPatologia.setEditable(false);
        this.JTFPatologia.setFont(new Font("Arial", 1, 12));
        this.JTFPatologia.setHorizontalAlignment(0);
        this.JTFPatologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.jButton1.setToolTipText("Busca Patología");
        this.jButton1.setName("xBtbNacido");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.26
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.jButton1ActionPerformed(evt);
            }
        });
        this.JTFFPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Cefálico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPCefalico.setHorizontalAlignment(0);
        this.JTFFPCefalico.setText("0");
        this.JTFFPCefalico.setToolTipText("Perimetro Cefálico");
        this.JTFFPCefalico.setExprecionRegular("^[0.0-9]*$");
        this.JTFFPCefalico.setFocusAccelerator('C');
        this.JTFFPCefalico.setFont(new Font("Arial", 1, 12));
        this.JTFFPCefalico.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.27
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFPCefalicoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFPCefalicoFocusLost(evt);
            }
        });
        this.JTFFPCefalico.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.28
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFFPCefalicoActionPerformed(evt);
            }
        });
        this.JTFFPToraxico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Toráxico", 0, 0, new Font("Arial", 1, 11), new Color(0, 0, 255)));
        this.JTFFPToraxico.setHorizontalAlignment(0);
        this.JTFFPToraxico.setText("0");
        this.JTFFPToraxico.setToolTipText("Perimetro Toráxico");
        this.JTFFPToraxico.setExprecionRegular("^[0.0-9]*$");
        this.JTFFPToraxico.setFocusAccelerator('C');
        this.JTFFPToraxico.setFont(new Font("Arial", 1, 12));
        this.JTFFPToraxico.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.29
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JTFFPToraxicoActionPerformed(evt);
            }
        });
        this.JTFFPToraxico.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidos.30
            public void focusGained(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFPToraxicoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDOrdenNacidos.this.JTFFPToraxicoFocusLost(evt);
            }
        });
        this.JCBDestino.setFont(new Font("Arial", 1, 12));
        this.JCBDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel7, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JTFAPGar, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel8, -2, -1, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JDCFechaNac, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPlacenta, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel6, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFFSTalla, -2, 90, -2).addGap(3, 3, 3).addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPCefalico, -2, 93, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel10, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPToraxico, -2, 93, -2))).addGap(0, 0, 32767)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFDx, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPatologia, -2, 356, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel11, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDestino, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 239, -2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaNac, -1, 45, 32767).addComponent(this.txtHora)).addComponent(this.JCBPlacenta, -2, 46, -2).addComponent(this.jPanel6, -2, -1, -2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2).addComponent(this.JTFFPCefalico, -2, 50, -2))).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -2, -1, -2).addComponent(this.jPanel7, -2, -1, -2).addComponent(this.JTFAPGar, -2, -1, -2).addComponent(this.jPanel8, -2, -1, -2).addComponent(this.jPanel10, -2, -1, -2))).addGroup(jPanel5Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPToraxico, -2, 38, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel11, -2, -1, -2).addComponent(this.JCBDestino, -2, -1, -2)).addGap(5, 5, 5).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jButton1, -1, 35, 32767).addContainerGap()).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDx).addComponent(this.JTFPatologia)))).addComponent(this.jScrollPane3))));
        this.JBAgregar.setFont(new Font("Arial", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        this.JBAgregar.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.31
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JBAgregarActionPerformed(evt);
            }
        });
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE RECIEN NACIDOS", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTNacidos.setFont(new Font("Arial", 1, 12));
        this.JTNacidos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTNacidos.setAutoResizeMode(0);
        this.JTNacidos.addMouseListener(new MouseAdapter() { // from class: Historia.JDOrdenNacidos.32
            public void mouseClicked(MouseEvent evt) {
                JDOrdenNacidos.this.JTNacidosMouseClicked(evt);
            }
        });
        this.JTNacidos.addKeyListener(new KeyAdapter() { // from class: Historia.JDOrdenNacidos.33
            public void keyPressed(KeyEvent evt) {
                JDOrdenNacidos.this.JTNacidosKeyPressed(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTNacidos);
        this.JBAGrabar.setFont(new Font("Arial", 1, 12));
        this.JBAGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Modificar29x27.png")));
        this.JBAGrabar.setText("Guardar");
        this.JBAGrabar.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.34
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JBAGrabarActionPerformed(evt);
            }
        });
        this.JBASalir.setFont(new Font("Arial", 1, 12));
        this.JBASalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBASalir.setText("Salir");
        this.JBASalir.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.35
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JBASalirActionPerformed(evt);
            }
        });
        this.JBAImprimir.setFont(new Font("Arial", 1, 12));
        this.JBAImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBAImprimir.setText("Imprimir");
        this.JBAImprimir.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.36
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JBAImprimirActionPerformed(evt);
            }
        });
        this.JBANovedad.setFont(new Font("Arial", 1, 12));
        this.JBANovedad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBANovedad.setText("Novedad");
        this.JBANovedad.setToolTipText("Registro de Muerte, APGAR(5 minutos despues)");
        this.JBANovedad.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidos.37
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidos.this.JBANovedadActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.JBAgregar, -1, -1, 32767).addComponent(this.jScrollPane4).addGroup(layout.createSequentialGroup().addComponent(this.JBAGrabar, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBANovedad, -2, 235, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAImprimir, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBASalir, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBASalir, -2, 41, -2).addComponent(this.JBAImprimir)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBAGrabar, -1, -1, 32767).addComponent(this.JBANovedad))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaNacPropertyChange(PropertyChangeEvent evt) {
    }

    private void mIniciaComp() {
        this.JCBLiqAmiotico.setSelectedIndex(-1);
        this.JCBPlacenta.setSelectedIndex(-1);
        this.JDCFechaNac.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.JTFFPCefalico.setText("0");
        this.JTFFPToraxico.setText("0");
        this.xlleno = true;
        this.jPanel12.setEnabled(false);
        this.MI.setEnabled(false);
        this.M2.setEnabled(false);
        this.M3.setEnabled(false);
        this.JTFF_NControles.setText("0");
        this.JCBDestino.removeAllItems();
        this.idDestino = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `g_tipodestino` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.idDestino, this.JCBDestino);
        this.JCBDestino.setSelectedIndex(-1);
        mCrearModeloRNacidos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBASalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMembSIActionPerformed(ActionEvent evt) {
        this.xmenbrana = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMembNoActionPerformed(ActionEvent evt) {
        this.xmenbrana = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspoSIActionPerformed(ActionEvent evt) {
        this.xPEspontaneo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspoNOActionPerformed(ActionEvent evt) {
        this.xPEspontaneo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCesSIActionPerformed(ActionEvent evt) {
        this.xCesarea = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCesNOActionPerformed(ActionEvent evt) {
        this.xCesarea = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSFetalSiActionPerformed(ActionEvent evt) {
        this.xSuFetal = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSFetalNoActionPerformed(ActionEvent evt) {
        this.xSuFetal = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (this.JCBPlacenta.getSelectedIndex() > -1) {
            if (!this.JTFFSTalla.getText().equals("0")) {
                if (!this.JTFFSPeso.getText().equals("0")) {
                    if (!this.JTFDx.getText().equals("")) {
                        if (this.JCBDestino.getSelectedIndex() > -1) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt("", this.xnfilas, 0);
                            this.xmodelo.setValueAt(this.xmt.formatoAMD.format(this.JDCFechaNac.getDate()), this.xnfilas, 1);
                            this.xmodelo.setValueAt(this.xmt.formatoH24.format(this.txtHora.getValue()), this.xnfilas, 2);
                            this.xmodelo.setValueAt(this.JCBPlacenta.getSelectedItem(), this.xnfilas, 3);
                            this.xmodelo.setValueAt(getButtonText(this.Estado), this.xnfilas, 4);
                            this.xmodelo.setValueAt(Double.valueOf(Double.parseDouble(this.JTFFSPeso.getText())), this.xnfilas, 5);
                            this.xmodelo.setValueAt(Double.valueOf(Double.parseDouble(this.JTFFSTalla.getText())), this.xnfilas, 6);
                            this.xmodelo.setValueAt(getButtonText(this.Sexo), this.xnfilas, 7);
                            this.xmodelo.setValueAt(this.JTFAPGar.getText(), this.xnfilas, 8);
                            this.xmodelo.setValueAt(getButtonText(this.Reanimacion), this.xnfilas, 9);
                            this.xmodelo.setValueAt(getButtonText(this.Vitamina), this.xnfilas, 10);
                            this.xmodelo.setValueAt(getButtonText(this.ProfOculas), this.xnfilas, 11);
                            this.xmodelo.setValueAt(getButtonText(this.Clasificacion), this.xnfilas, 12);
                            this.xmodelo.setValueAt(getButtonText(this.ClasificacionPeso), this.xnfilas, 13);
                            this.xmodelo.setValueAt(this.JTFExaFisico.getText(), this.xnfilas, 14);
                            if (getButtonText(this.Estado).equals("MUERTO")) {
                                this.xmodelo.setValueAt("", this.xnfilas, 17);
                                this.xmodelo.setValueAt("", this.xnfilas, 18);
                                this.xmodelo.setValueAt(this.JTFDx.getText(), this.xnfilas, 23);
                                this.xmodelo.setValueAt(this.JTFPatologia.getText(), this.xnfilas, 24);
                            } else {
                                this.xmodelo.setValueAt(this.JTFDx.getText(), this.xnfilas, 17);
                                this.xmodelo.setValueAt(this.JTFPatologia.getText(), this.xnfilas, 18);
                                this.xmodelo.setValueAt("", this.xnfilas, 23);
                                this.xmodelo.setValueAt("", this.xnfilas, 24);
                            }
                            this.xmodelo.setValueAt(Double.valueOf(Double.parseDouble(this.JTFFPCefalico.getText())), this.xnfilas, 19);
                            this.xmodelo.setValueAt(Double.valueOf(Double.parseDouble(this.JTFFPToraxico.getText())), this.xnfilas, 20);
                            if (getButtonText(this.Estado).equals("MUERTO")) {
                                this.xmodelo.setValueAt(this.xmt.formatoAMD.format(this.JDCFechaNac.getDate()), this.xnfilas, 21);
                                this.xmodelo.setValueAt(this.xmt.formatoH24.format(this.txtHora.getValue()), this.xnfilas, 22);
                            } else {
                                this.xmodelo.setValueAt("", this.xnfilas, 21);
                                this.xmodelo.setValueAt("", this.xnfilas, 22);
                            }
                            this.xmodelo.setValueAt(this.idDestino[this.JCBDestino.getSelectedIndex()], this.xnfilas, 26);
                            this.xnfilas++;
                            mLimpiar();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe Seleccionar el destino del recien nacido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBDestino.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Peso digitar el diagnóstico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFDx.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Peso debe ser direfente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSPeso.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Talla debe ser direfente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar la placenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPlacenta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAGrabarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNacidosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mEliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAImprimirActionPerformed(ActionEvent evt) {
        if (this.JTNacidos.getSelectedRow() != -1) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 16).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 15).toString();
            mparametros[2][0] = "ID_RNACIDO";
            mparametros[2][1] = this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 0).toString();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_RecienNacido", mparametros);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar el recien nacido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDxFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFDx, this.JTFPatologia, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFDx, this.JTFPatologia, 0);
            this.JTFDx.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVitaSi2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPCefalicoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPCefalicoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPCefalicoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPToraxicoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPToraxicoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPToraxicoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MIActionPerformed(ActionEvent evt) {
        this.xMeconio = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2ActionPerformed(ActionEvent evt) {
        this.xMeconio = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M3ActionPerformed(ActionEvent evt) {
        this.xMeconio = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLiqAmioticoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && !this.JCBLiqAmiotico.getSelectedItem().equals("ANORMAL")) {
            this.jPanel12.setEnabled(false);
            this.MI.setEnabled(false);
            this.MI.setSelected(false);
            this.M2.setEnabled(false);
            this.M2.setSelected(false);
            this.M3.setEnabled(false);
            this.M3.setSelected(false);
            return;
        }
        this.jPanel12.setEnabled(true);
        this.MI.setEnabled(true);
        this.M2.setEnabled(true);
        this.M3.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBANovedadActionPerformed(ActionEvent evt) {
        if (this.JTNacidos.getSelectedRow() > -1) {
            JDOrdenNacidosNovedad x = new JDOrdenNacidosNovedad(null, true, this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 0).toString(), this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Recien Nacido de la Tabla");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNacidosMouseClicked(MouseEvent evt) {
        if (this.JTNacidos.getSelectedRow() != -1) {
            SimpleDateFormat form_fecha = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat xhora = new SimpleDateFormat("HH:mm");
            try {
                this.JDCFechaNac.setDate(form_fecha.parse(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 1).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(JDOrdenNacidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            try {
                this.txtHora.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 2).toString()));
            } catch (ParseException ex2) {
                Logger.getLogger(JDOrdenNacidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            this.JCBPlacenta.setSelectedItem(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 3).toString());
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 4).equals("VIVO")) {
                this.JRBVivo.setSelected(true);
            } else {
                this.JRBMuerto.setSelected(true);
            }
            this.JTFFSPeso.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 5).toString());
            this.JTFFSTalla.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 6).toString());
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 7).equals("FEMENINO")) {
                this.JRBFem.setSelected(true);
            } else {
                this.JRBMasc.setSelected(true);
            }
            this.JTFAPGar.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 8).toString());
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 9).equals("SI")) {
                this.JRBReanSI1.setSelected(true);
            } else {
                this.JRBReanNo1.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 10).equals("SI")) {
                this.JRBVitaSi.setSelected(true);
            } else {
                this.JRBVitaNo.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 11).equals("SI")) {
                this.JRBProfSi.setSelected(true);
            } else {
                this.JRBProfNo.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 12).equals("(RNP)")) {
                this.JRBVitaSi2.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 12).equals("(RNT)")) {
                this.JRBVitaNo2.setSelected(true);
            } else {
                this.JRBVitaNo3.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 13).equals("(GEG)")) {
                this.JRBVitaNo4.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 13).equals("(AEG)")) {
                this.JRBVitaNo5.setSelected(true);
            } else {
                this.JRBVitaNo6.setSelected(true);
            }
            this.JTFExaFisico.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 14).toString());
            if (!this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 17).equals("") && !this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 18).equals("")) {
                this.JTFDx.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 17).toString());
                this.JTFPatologia.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 18).toString());
            } else {
                this.JTFDx.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 23).toString());
                this.JTFPatologia.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 24).toString());
            }
            this.JTFFPCefalico.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 19).toString());
            this.JTFFPToraxico.setText(this.xmodelo.getValueAt(this.JTNacidos.getSelectedRow(), 20).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_EdadGestacionalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_EdadGestacionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NControlesFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NControlesFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NControlesActionPerformed(ActionEvent evt) {
    }

    public void mEliminarFilaGrid() {
        if (this.xmt.getPregunta("Esta seguro de Eliminar el registro?") == 0) {
            this.xmodelo.removeRow(this.JTNacidos.getSelectedRow());
            this.xnfilas--;
            this.xmt.mostrarMensaje("Registro Eliminado");
        }
    }

    private void mLimpiar() {
        this.JDCFechaNac.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.JCBPlacenta.setSelectedIndex(-1);
        this.JRBVivo.setSelected(true);
        this.JTFFSTalla.setText("0");
        this.JTFFSPeso.setText("0");
        this.JRBMasc.setSelected(false);
        this.JTFAPGar.setText("");
        this.JRBReanNo1.setSelected(true);
        this.JRBVitaNo.setSelected(true);
        this.JRBProfNo.setSelected(true);
        this.JRBVitaNo2.setSelected(true);
        this.JRBVitaNo5.setSelected(true);
        this.JTFExaFisico.setText("");
        this.JTFDx.setText("");
        this.JTFPatologia.setText("");
        this.JTFFPCefalico.setText("0");
        this.JTFFPToraxico.setText("0");
    }

    private void mGuardar() {
        if (this.JTNacidos.getRowCount() > 0) {
            if (this.JCBPresentacion.getSelectedIndex() > -1) {
                if (this.JCBLiqAmiotico.getSelectedIndex() > -1) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!mVerificaEncabezadoRN()) {
                            String sql = "INSERT INTO  `h_orden_qx_nacidos`  ( `IdOrdenQx`, SGestacion, `Presentacion`, `RMembrana`, `LiqAmiotico`, `PEspontaneo`, `Cesarea`, `Otros`, `SuFetal`, `Medicamentos`,numeroControles,  Meconio, `UsuarioS`)  VALUES ( '" + this.xOrdenQx + "', '" + this.JTFF_EdadGestacional.getText() + "', '" + this.JCBPresentacion.getSelectedItem() + "', '" + this.xmenbrana + "', '" + this.JCBLiqAmiotico.getSelectedItem() + "', '" + this.xPEspontaneo + "', '" + this.xCesarea + "', '" + this.JTFOtros.getText() + "', '" + this.xSuFetal + "', '" + this.JTFMed.getText() + "','" + this.JTFF_NControles.getText() + "', '" + this.xMeconio + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xEncabezado = this.xct.ejecutarSQLId(sql);
                            this.xct.cerrarConexionBd();
                            for (int i = 0; i < this.JTNacidos.getRowCount(); i++) {
                                if (this.xmodelo.getValueAt(i, 4).toString().equals("VIVO")) {
                                    String sql2 = "INSERT INTO  `h_orden_qx_nacido_detalle` ( `IdEncabezado`, `FechaNac`, `Hora`, `Placenta`, `EstadoR`, `Peso`, `Talla`, `Sexo`, `Apgar`,\n    `Reanimacion`, `VitaminaK`, `ProfOcular`, `Clasificacion`,ClasificacionPeso, `ExamenFisico`,DX, PCefalico,PToraxico, idDestino, `UsuarioS`)\nVALUES ( '" + this.xEncabezado + "', '" + this.xmodelo.getValueAt(i, 1) + "', '" + this.xmodelo.getValueAt(i, 2) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.xmodelo.getValueAt(i, 4) + "', '" + this.xmodelo.getValueAt(i, 5) + "', '" + this.xmodelo.getValueAt(i, 6) + "', '" + this.xmodelo.getValueAt(i, 7) + "', '" + this.xmodelo.getValueAt(i, 8) + "', '" + this.xmodelo.getValueAt(i, 9) + "',\n    '" + this.xmodelo.getValueAt(i, 10) + "', '" + this.xmodelo.getValueAt(i, 11) + "', '" + this.xmodelo.getValueAt(i, 12) + "', '" + this.xmodelo.getValueAt(i, 13) + "','" + this.xmodelo.getValueAt(i, 14) + "','" + this.xmodelo.getValueAt(i, 17) + "','" + this.xmodelo.getValueAt(i, 19) + "','" + this.xmodelo.getValueAt(i, 20) + "','" + this.xmodelo.getValueAt(i, 26) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQLId(sql2);
                                    this.xct.cerrarConexionBd();
                                } else {
                                    String sql22 = "INSERT INTO  `h_orden_qx_nacido_detalle` ( `IdEncabezado`, `FechaNac`, `Hora`, `Placenta`, `EstadoR`, `Peso`, `Talla`, `Sexo`, `Apgar`,\n    `Reanimacion`, `VitaminaK`, `ProfOcular`, `Clasificacion`,ClasificacionPeso, `ExamenFisico`,PCefalico,PToraxico,FechaMuerte,HoraMuerte,DXMuerte, idDestino, `UsuarioS`)\nVALUES ( '" + this.xEncabezado + "', '" + this.xmodelo.getValueAt(i, 1) + "', '" + this.xmodelo.getValueAt(i, 2) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.xmodelo.getValueAt(i, 4) + "', '" + this.xmodelo.getValueAt(i, 5) + "', '" + this.xmodelo.getValueAt(i, 6) + "', '" + this.xmodelo.getValueAt(i, 7) + "', '" + this.xmodelo.getValueAt(i, 8) + "', '" + this.xmodelo.getValueAt(i, 9) + "',\n    '" + this.xmodelo.getValueAt(i, 10) + "', '" + this.xmodelo.getValueAt(i, 11) + "', '" + this.xmodelo.getValueAt(i, 12) + "', '" + this.xmodelo.getValueAt(i, 13) + "','" + this.xmodelo.getValueAt(i, 14) + "','" + this.xmodelo.getValueAt(i, 19) + "','" + this.xmodelo.getValueAt(i, 20) + "','" + this.xmodelo.getValueAt(i, 21) + "','" + this.xmodelo.getValueAt(i, 22) + "','" + this.xmodelo.getValueAt(i, 23) + "', '" + this.xmodelo.getValueAt(i, 26) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQLId(sql22);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < this.JTNacidos.getRowCount(); i2++) {
                                if (this.xmodelo.getValueAt(i2, 0).toString().equals("")) {
                                    if (this.xmodelo.getValueAt(i2, 4).toString().equals("VIVO")) {
                                        String sql23 = "INSERT INTO  `h_orden_qx_nacido_detalle` ( `IdEncabezado`, `FechaNac`, `Hora`, `Placenta`, `EstadoR`, `Peso`, `Talla`, `Sexo`, `Apgar`,\n    `Reanimacion`, `VitaminaK`, `ProfOcular`, `Clasificacion`,ClasificacionPeso, `ExamenFisico`, DX, PCefalico,PToraxico, idDestino, `UsuarioS`)\nVALUES ( '" + this.xEncabezado + "', '" + this.xmodelo.getValueAt(i2, 1) + "', '" + this.xmodelo.getValueAt(i2, 2) + "', '" + this.xmodelo.getValueAt(i2, 3) + "', '" + this.xmodelo.getValueAt(i2, 4) + "', '" + this.xmodelo.getValueAt(i2, 5) + "', '" + this.xmodelo.getValueAt(i2, 6) + "', '" + this.xmodelo.getValueAt(i2, 7) + "', '" + this.xmodelo.getValueAt(i2, 8) + "', '" + this.xmodelo.getValueAt(i2, 9) + "',\n    '" + this.xmodelo.getValueAt(i2, 10) + "', '" + this.xmodelo.getValueAt(i2, 11) + "', '" + this.xmodelo.getValueAt(i2, 12) + "', '" + this.xmodelo.getValueAt(i2, 13) + "','" + this.xmodelo.getValueAt(i2, 14) + "','" + this.xmodelo.getValueAt(i2, 17) + "','" + this.xmodelo.getValueAt(i2, 19) + "','" + this.xmodelo.getValueAt(i2, 20) + "', '" + this.xmodelo.getValueAt(i2, 26) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                        this.xct.ejecutarSQLId(sql23);
                                        this.xct.cerrarConexionBd();
                                    } else {
                                        String sql24 = "INSERT INTO  `h_orden_qx_nacido_detalle` ( `IdEncabezado`, `FechaNac`, `Hora`, `Placenta`, `EstadoR`, `Peso`, `Talla`, `Sexo`, `Apgar`,\n    `Reanimacion`, `VitaminaK`, `ProfOcular`, `Clasificacion`,ClasificacionPeso, `ExamenFisico`,PCefalico,PToraxico,FechaMuerte,HoraMuerte,DXMuerte, idDestino, `UsuarioS`)\nVALUES ( '" + this.xEncabezado + "', '" + this.xmodelo.getValueAt(i2, 1) + "', '" + this.xmodelo.getValueAt(i2, 2) + "', '" + this.xmodelo.getValueAt(i2, 3) + "', '" + this.xmodelo.getValueAt(i2, 4) + "', '" + this.xmodelo.getValueAt(i2, 5) + "', '" + this.xmodelo.getValueAt(i2, 6) + "', '" + this.xmodelo.getValueAt(i2, 7) + "', '" + this.xmodelo.getValueAt(i2, 8) + "', '" + this.xmodelo.getValueAt(i2, 9) + "',\n    '" + this.xmodelo.getValueAt(i2, 10) + "', '" + this.xmodelo.getValueAt(i2, 11) + "', '" + this.xmodelo.getValueAt(i2, 12) + "', '" + this.xmodelo.getValueAt(i2, 13) + "','" + this.xmodelo.getValueAt(i2, 14) + "','" + this.xmodelo.getValueAt(i2, 19) + "','" + this.xmodelo.getValueAt(i2, 20) + "','" + this.xmodelo.getValueAt(i2, 21) + "','" + this.xmodelo.getValueAt(i2, 22) + "','" + this.xmodelo.getValueAt(i2, 23) + "', '" + this.xmodelo.getValueAt(i2, 26) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                        this.xct.ejecutarSQLId(sql24);
                                        this.xct.cerrarConexionBd();
                                    }
                                }
                            }
                        }
                        mBuscaInformacion(this.xOrdenQx);
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe Seleccionar Liquido amniótico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBLiqAmiotico.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe Seleccionar la presentación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPresentacion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe agregar Recien Nacidos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRNacidos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaNac", "Hora", "Placenta", "Estado", "Peso", "Talla", "Sexo", "APGAR", "Reanimación", "VitaminaK", "ProfilaxisOcular", "ClasificaciónSemana", "ClasificaciónPeso", "ExámenFísico", "Id_Paciente", "Id_Atencion", "Cod. DX", "Patologia", "P.Cefalico", "P.Toraxico", "FechaMuerte", "HoraMuerte", "DX.Muerte", "PatolgiaMuerte", "APGAR(5 Min)", "idDestino"}) { // from class: Historia.JDOrdenNacidos.38
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTNacidos.setModel(this.xmodelo);
        this.JTNacidos.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTNacidos.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTNacidos.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTNacidos.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTNacidos.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTNacidos.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTNacidos.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTNacidos.getColumnModel().getColumn(26).setPreferredWidth(80);
    }

    private String getButtonText(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public void mBuscaInformacion(String xidEncabezado) {
        String sql = "SELECT `h_orden_qx_nacidos`.`Id` , `h_orden_qx_nacidos`.`Presentacion` , `h_orden_qx_nacidos`.`RMembrana` , `h_orden_qx_nacidos`.`LiqAmiotico`\n    , `h_orden_qx_nacidos`.`PEspontaneo` , `h_orden_qx_nacidos`.`Cesarea`  , `h_orden_qx_nacidos`.`Otros`  , `h_orden_qx_nacidos`.`SuFetal`\n    , `h_orden_qx_nacidos`.`Medicamentos` , IF(h_orden_qx_nacido_detalle.Id IS NULL,'', h_orden_qx_nacido_detalle.Id) AS IdDetalleRN, `h_orden_qx_nacido_detalle`.`FechaNac` , `h_orden_qx_nacido_detalle`.`Hora` , `h_orden_qx_nacido_detalle`.`Placenta`\n    , `h_orden_qx_nacido_detalle`.`EstadoR` , `h_orden_qx_nacido_detalle`.`Peso`  , `h_orden_qx_nacido_detalle`.`Talla`  , `h_orden_qx_nacido_detalle`.`Sexo`\n    , `h_orden_qx_nacido_detalle`.`Apgar` , `h_orden_qx_nacido_detalle`.`Reanimacion` , `h_orden_qx_nacido_detalle`.`VitaminaK`\n    , `h_orden_qx_nacido_detalle`.`ProfOcular` , `h_orden_qx_nacido_detalle`.`Clasificacion`,`h_orden_qx_nacido_detalle`.`ClasificacionPeso` , `h_orden_qx_nacido_detalle`.`ExamenFisico`, `ingreso`.`Id_Usuario` AS Id_Usuario , `h_atencion`.`Id` AS Id_Atencion, `h_orden_qx_nacido_detalle`.`DX` , IF(`g_patologia`.`Nbre` IS NULL,'',`g_patologia`.`Nbre`) AS Patologia, h_orden_qx_nacido_detalle.PCefalico,h_orden_qx_nacido_detalle.PToraxico, h_orden_qx_nacidos.Meconio, IF(h_orden_qx_nacido_detalle.FechaMuerte IS NULL, '',h_orden_qx_nacido_detalle.FechaMuerte) AS FechaMuerte,IF(h_orden_qx_nacido_detalle.HoraMuerte IS NULL,'' ,h_orden_qx_nacido_detalle.HoraMuerte) AS HoraMuerte,h_orden_qx_nacido_detalle.DXMuerte,IF(`g_patologia_1`.`Nbre` IS NULL,'',`g_patologia_1`.`Nbre`)AS PatologiaMuerte, h_orden_qx_nacido_detalle.Apgar_c  \nFROM `h_orden_qx_nacido_detalle` RIGHT JOIN `h_orden_qx_nacidos`  ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`) INNER JOIN `h_orden_qx`  ON (`h_orden_qx_nacidos`.`IdOrdenQx` = `h_orden_qx`.`Id`) INNER JOIN `h_atencion`  ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`)  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n LEFT JOIN  `g_patologia`   ON (`h_orden_qx_nacido_detalle`.`DX` = `g_patologia`.`Id`)  LEFT JOIN  `g_patologia` AS `g_patologia_1` ON (`h_orden_qx_nacido_detalle`.`DXMuerte` = `g_patologia_1`.`Id`)WHERE (`h_orden_qx_nacidos`.`IdOrdenQx` ='" + xidEncabezado + "' and h_orden_qx_nacidos.Estado=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        mCrearModeloRNacidos();
        this.xnfilas = 0;
        try {
            if (xrs.next()) {
                xrs.first();
                this.xEncabezado = xrs.getString("Id");
                if (xrs.getLong("RMembrana") == 1) {
                    this.JRBMembSI.setSelected(true);
                } else {
                    this.JRBMembNo.setSelected(true);
                }
                this.JCBLiqAmiotico.setSelectedItem(xrs.getString("LiqAmiotico"));
                if (xrs.getLong("Meconio") == 1) {
                    this.MI.setSelected(true);
                } else if (xrs.getLong("Meconio") == 2) {
                    this.M2.setSelected(true);
                } else if (xrs.getLong("Meconio") == 3) {
                    this.M3.setSelected(true);
                }
                if (xrs.getLong("PEspontaneo") == 1) {
                    this.JRBEspoSI.setSelected(true);
                } else {
                    this.JRBEspoNO.setSelected(true);
                }
                if (xrs.getLong("Cesarea") == 1) {
                    this.JRBCesSI.setSelected(true);
                } else {
                    this.JRBCesNO.setSelected(true);
                }
                this.JTFOtros.setText(xrs.getString("Otros"));
                if (xrs.getLong("SuFetal") == 1) {
                    this.JRBSFetalSi.setSelected(true);
                } else {
                    this.JRBSFetalNo.setSelected(true);
                }
                this.JTFMed.setText(xrs.getString("Medicamentos"));
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (!xrs.getString("IdDetalleRN").equals("")) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getString("IdDetalleRN"), this.xnfilas, 0);
                        this.xmodelo.setValueAt(xrs.getString("FechaNac"), this.xnfilas, 1);
                        this.xmodelo.setValueAt(xrs.getString("Hora"), this.xnfilas, 2);
                        this.xmodelo.setValueAt(xrs.getString("Placenta"), this.xnfilas, 3);
                        this.xmodelo.setValueAt(xrs.getString("EstadoR"), this.xnfilas, 4);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Peso")), this.xnfilas, 5);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Talla")), this.xnfilas, 6);
                        this.xmodelo.setValueAt(xrs.getString("Sexo"), this.xnfilas, 7);
                        this.xmodelo.setValueAt(xrs.getString("Apgar"), this.xnfilas, 8);
                        this.xmodelo.setValueAt(xrs.getString("Reanimacion"), this.xnfilas, 9);
                        this.xmodelo.setValueAt(xrs.getString("VitaminaK"), this.xnfilas, 10);
                        this.xmodelo.setValueAt(xrs.getString("ProfOcular"), this.xnfilas, 11);
                        this.xmodelo.setValueAt(xrs.getString("Clasificacion"), this.xnfilas, 12);
                        this.xmodelo.setValueAt(xrs.getString("ClasificacionPeso"), this.xnfilas, 13);
                        this.xmodelo.setValueAt(xrs.getString("ExamenFisico"), this.xnfilas, 14);
                        this.xmodelo.setValueAt(xrs.getString("Id_Usuario"), this.xnfilas, 15);
                        this.xmodelo.setValueAt(xrs.getString("Id_Atencion"), this.xnfilas, 16);
                        this.xmodelo.setValueAt(xrs.getString("DX"), this.xnfilas, 17);
                        this.xmodelo.setValueAt(xrs.getString("Patologia"), this.xnfilas, 18);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("PCefalico")), this.xnfilas, 19);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("PToraxico")), this.xnfilas, 20);
                        this.xmodelo.setValueAt(xrs.getString("FechaMuerte"), this.xnfilas, 21);
                        this.xmodelo.setValueAt(xrs.getString("HoraMuerte"), this.xnfilas, 22);
                        this.xmodelo.setValueAt(xrs.getString("DXMuerte"), this.xnfilas, 23);
                        this.xmodelo.setValueAt(xrs.getString("PatologiaMuerte"), this.xnfilas, 24);
                        this.xmodelo.setValueAt(xrs.getString("Apgar_c"), this.xnfilas, 25);
                        this.xnfilas++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDOrdenNacidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaEncabezadoRN() {
        boolean xexiste = false;
        String sql = "SELECT `Id`,`IdOrdenQx` FROM `h_orden_qx_nacidos` WHERE (`IdOrdenQx`='" + this.xOrdenQx + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDOrdenNacidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }
}
