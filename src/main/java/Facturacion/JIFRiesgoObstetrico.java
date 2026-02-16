package Facturacion;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import General.Persona;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFRiesgoObstetrico.class */
public class JIFRiesgoObstetrico extends JInternalFrame {
    public Persona frmPersona;
    public clasesHistoriaCE xclase;
    private DefaultTableModel xmodeloH;
    private DefaultTableModel xmodeloR;
    public String[] xidEspecialidad;
    public String[] xidProfesional;
    public String[][] xClaseCita;
    public String[][] xidexamen;
    private Object[] xdato;
    public String xsql;
    private JButton JBTAdicionar;
    public static JComboBox JCBClaseCita;
    public JComboBox JCBClasificacion;
    public JComboBox JCBEspecialidad;
    private JComboBox JCBExamen;
    public JComboBox JCBProfesional;
    private JCheckBox JCHEmbarazada;
    private JCheckBox JCHIngreso;
    private JDateChooser JDCFechaIngresoP;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaAtencion;
    private JEditorPane JEPObservacion;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPHistorico;
    public JPanel JPIDetalleAtencion;
    private JPanel JPIDxConclusion;
    private JPanel JPIInicioC;
    private JPanel JPIObstetricos;
    private JPanel JPIPresion;
    private JPanel JPInformacion;
    private JPanel JPResultado;
    private JScrollPane JSDetalle;
    private JScrollPane JSHistorico;
    private JSpinner JSPNoAbortos;
    private JSpinner JSPNoCesareas;
    private JSpinner JSPNoEmbarazos;
    private JSpinner JSPNoEptopicos;
    private JSpinner JSPNoMuertos;
    private JSpinner JSPNoPartos;
    private JSpinner JSPNoVivos;
    private JScrollPane JSPObservacion;
    private JTable JTBHistorico;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFEMenarquia;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextField JTFFResultado;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSSGestacion;
    public JTextFieldValidator JTFFSTalla;
    private JTextField JTFFechaPParto;
    private JTextField JTFFechaUAborto;
    private JTextField JTFFechaULegrado;
    private JTextField JTFFechaUMestruacion;
    private JTextField JTFFechaUParto;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFPIntergenesico;
    private JTextField JTFSemanaG;
    private JTabbedPane JTPOpciones;
    public JDateChooser cboFechaPParto;
    public JDateChooser cboUltimaAborto;
    public JDateChooser cboUltimaLegrado;
    public JDateChooser cboUltimaMestruacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private JPanel panelPersona;
    public JDateChooser txtUltimoParto;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xlleno = false;
    public int xEsIngreso = 0;
    public int xestadog = 1;
    int combocc = 0;

    public JIFRiesgoObstetrico() {
        initComponents();
        this.frmPersona = new Persona(this);
        cargarPanelPersona();
        mCargarCombos();
        mNuevo();
    }

    public void cargarPanelPersona() {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(5, 15, 980, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r3v225, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v249, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFFSSGestacion = new JTextFieldValidator();
        this.panelPersona = new JPanel();
        this.JTPOpciones = new JTabbedPane();
        this.JPInformacion = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBProfesional = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        JCBClaseCita = new JComboBox();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JDFechaAtencion = new JDateChooser();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIObstetricos = new JPanel();
        this.JSPNoEmbarazos = new JSpinner();
        this.JSPNoEptopicos = new JSpinner();
        this.JSPNoPartos = new JSpinner();
        this.JSPNoCesareas = new JSpinner();
        this.JSPNoAbortos = new JSpinner();
        this.JSPNoMuertos = new JSpinner();
        this.JSPNoVivos = new JSpinner();
        this.JTFFechaUParto = new JTextField();
        this.txtUltimoParto = new JDateChooser();
        this.JTFFechaUAborto = new JTextField();
        this.cboUltimaAborto = new JDateChooser();
        this.JTFFechaUMestruacion = new JTextField();
        this.cboUltimaMestruacion = new JDateChooser();
        this.JTFFechaPParto = new JTextField();
        this.cboFechaPParto = new JDateChooser();
        this.JTFSemanaG = new JTextField();
        this.JTFFechaULegrado = new JTextField();
        this.cboUltimaLegrado = new JDateChooser();
        this.JCHEmbarazada = new JCheckBox();
        this.JTFEMenarquia = new JTextField();
        this.JCBClasificacion = new JComboBox();
        this.JTFPIntergenesico = new JTextField();
        this.JDCFechaIngresoP = new JDateChooser();
        this.JPIDxConclusion = new JPanel();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JPResultado = new JPanel();
        this.JPIDetalleAtencion = new JPanel();
        this.jPanel2 = new JPanel();
        this.JPIInicioC = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBExamen = new JComboBox();
        this.JTFFResultado = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JEPObservacion = new JEditorPane();
        this.JBTAdicionar = new JButton();
        this.JCHIngreso = new JCheckBox();
        this.JSHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.JPHistorico = new JPanel();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFSSGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSSGestacion.setHorizontalAlignment(0);
        this.JTFFSSGestacion.setText("0");
        this.JTFFSSGestacion.setToolTipText("Semana de Gestación");
        this.JTFFSSGestacion.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSSGestacion.setFocusAccelerator('C');
        this.JTFFSSGestacion.setFont(new Font("Arial", 1, 12));
        this.JTFFSSGestacion.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.1
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSSGestacionActionPerformed(evt);
            }
        });
        setClosable(true);
        setIconifiable(true);
        setTitle("RIESGO OBSTETRICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFRiesgoObstetrico");
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 186, 32767));
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JIFRiesgoObstetrico.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRiesgoObstetrico.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        JCBClaseCita.setFont(new Font("Arial", 1, 12));
        JCBClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBClaseCita.setName("JCBClaseCita");
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.3
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.4
            public void focusGained(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.5
            public void keyTyped(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSTallaKeyTyped(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.6
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.7
            public void focusGained(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.8
            public void keyTyped(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFFSPesoKeyTyped(evt);
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
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.9
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.10
            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoS, new AbsoluteConstraints(20, 20, 45, 25));
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.11
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.12
            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFFPSentadoDFocusLost(evt);
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
        this.JDFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaAtencion.setDateFormatString("dd/MM/yyyy");
        this.JDFechaAtencion.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFSTalla, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JPIPresion, -2, 141, -2)).addComponent(this.JCBEspecialidad, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(JCBClaseCita, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaAtencion, -2, 126, -2).addGap(30, 30, 30)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBProfesional, -2, 515, -2).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCBProfesional, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2)).addComponent(this.JTFFSIMC, -2, 50, -2).addComponent(JCBClaseCita, -2, 54, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JDFechaAtencion, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIPresion, -2, 75, -2))).addContainerGap(13, 32767)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPIObstetricos.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSTETRICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPNoEmbarazos.setFont(new Font("Arial", 1, 12));
        this.JSPNoEmbarazos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoEmbarazos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Embarazo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoEmbarazos.setMinimumSize(new Dimension(44, 60));
        this.JSPNoEmbarazos.setPreferredSize(new Dimension(44, 60));
        this.JSPNoEptopicos.setFont(new Font("Arial", 1, 12));
        this.JSPNoEptopicos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoEptopicos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ectopicos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoPartos.setFont(new Font("Arial", 1, 12));
        this.JSPNoPartos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoPartos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Partos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoCesareas.setFont(new Font("Arial", 1, 12));
        this.JSPNoCesareas.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoCesareas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cesareas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoAbortos.setFont(new Font("Arial", 1, 12));
        this.JSPNoAbortos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoAbortos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Abortos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoMuertos.setFont(new Font("Arial", 1, 12));
        this.JSPNoMuertos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoMuertos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Muertos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNoVivos.setFont(new Font("Arial", 1, 12));
        this.JSPNoVivos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNoVivos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Vivos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUParto.setHorizontalAlignment(4);
        this.JTFFechaUParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtUltimoParto.setDateFormatString("dd/MM/yyyy");
        this.txtUltimoParto.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimoParto.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimoParto.setName("cboMenarquia");
        this.txtUltimoParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoObstetrico.13
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoObstetrico.this.txtUltimoPartoPropertyChange(evt);
            }
        });
        this.JTFFechaUAborto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUAborto.setHorizontalAlignment(4);
        this.JTFFechaUAborto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Aborto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaAborto.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaAborto.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaAborto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaAborto.setName("cboMenarquia");
        this.cboUltimaAborto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoObstetrico.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoObstetrico.this.cboUltimaAbortoPropertyChange(evt);
            }
        });
        this.JTFFechaUMestruacion.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUMestruacion.setHorizontalAlignment(4);
        this.JTFFechaUMestruacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Mestruación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaMestruacion.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaMestruacion.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaMestruacion.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaMestruacion.setName("cboMenarquia");
        this.cboUltimaMestruacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoObstetrico.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoObstetrico.this.cboUltimaMestruacionPropertyChange(evt);
            }
        });
        this.JTFFechaPParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPParto.setHorizontalAlignment(4);
        this.JTFFechaPParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FPP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboFechaPParto.setDateFormatString("dd/MM/yyyy");
        this.cboFechaPParto.setFont(new Font("Tahoma", 1, 12));
        this.cboFechaPParto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboFechaPParto.setName("cboMenarquia");
        this.cboFechaPParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoObstetrico.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoObstetrico.this.cboFechaPPartoPropertyChange(evt);
            }
        });
        this.JTFSemanaG.setFont(new Font("Arial", 1, 12));
        this.JTFSemanaG.setHorizontalAlignment(4);
        this.JTFSemanaG.setBorder(BorderFactory.createTitledBorder((Border) null, "Semana Gestaciòn", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaULegrado.setFont(new Font("Arial", 1, 12));
        this.JTFFechaULegrado.setHorizontalAlignment(4);
        this.JTFFechaULegrado.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Legrado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaLegrado.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaLegrado.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaLegrado.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaLegrado.setName("cboMenarquia");
        this.cboUltimaLegrado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoObstetrico.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoObstetrico.this.cboUltimaLegradoPropertyChange(evt);
            }
        });
        this.JCHEmbarazada.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada.setText("Actualmente esta embarazada?");
        this.JCHEmbarazada.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.18
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JCHEmbarazadaActionPerformed(evt);
            }
        });
        this.JTFEMenarquia.setFont(new Font("Arial", 1, 12));
        this.JTFEMenarquia.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Menarquia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setModel(new DefaultComboBoxModel(new String[]{"BAJO", "MEDIO", "ALTO"}));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPIntergenesico.setFont(new Font("Arial", 1, 12));
        this.JTFPIntergenesico.setHorizontalAlignment(4);
        this.JTFPIntergenesico.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Intergenesico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaIngresoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaIngresoP.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaIngresoP.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIObstetricosLayout = new GroupLayout(this.JPIObstetricos);
        this.JPIObstetricos.setLayout(JPIObstetricosLayout);
        JPIObstetricosLayout.setHorizontalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addContainerGap().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFEMenarquia, -2, 116, -2).addGap(6, 6, 6).addComponent(this.JTFPIntergenesico, -2, 157, -2).addGap(18, 18, 18).addComponent(this.JTFSemanaG, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JCHEmbarazada).addGap(18, 18, 18).addComponent(this.JCBClasificacion, -2, 228, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaIngresoP, -2, 126, -2)).addGroup(JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPNoEmbarazos, -1, -1, 32767).addComponent(this.JSPNoVivos, -2, 119, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaUParto, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtUltimoParto, -2, 20, -2)).addComponent(this.JSPNoAbortos, -2, 146, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaUAborto, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaAborto, -2, 20, -2)).addComponent(this.JSPNoPartos, -2, 148, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaUMestruacion, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaMestruacion, -2, 20, -2)).addGroup(JPIObstetricosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JSPNoCesareas, -2, 142, -2))).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaULegrado, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaLegrado, -2, 20, -2)).addComponent(this.JSPNoEptopicos, GroupLayout.Alignment.TRAILING, -2, 146, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaPParto, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboFechaPParto, -2, 20, -2)).addComponent(this.JSPNoMuertos, GroupLayout.Alignment.TRAILING, -2, 165, -2)))).addGap(0, 0, 32767)));
        JPIObstetricosLayout.setVerticalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addContainerGap().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNoEmbarazos, -2, 50, -2).addComponent(this.JSPNoPartos, -2, 50, -2).addComponent(this.JSPNoEptopicos, -2, 50, -2).addComponent(this.JSPNoMuertos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUAborto).addComponent(this.JSPNoVivos, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboUltimaAborto, -2, 50, -2).addComponent(this.cboFechaPParto, -2, 50, -2).addComponent(this.JTFFechaPParto, -2, 50, -2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaULegrado, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.cboUltimaLegrado, GroupLayout.Alignment.TRAILING, -2, 50, -2)))))).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JSPNoCesareas, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUMestruacion, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.cboUltimaMestruacion, -2, 50, -2)))).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JSPNoAbortos, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUParto).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtUltimoParto, -2, 50, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEMenarquia, -2, 50, -2).addComponent(this.JTFSemanaG, -2, 50, -2).addComponent(this.JTFPIntergenesico, -2, 50, -2).addComponent(this.JCHEmbarazada).addComponent(this.JCBClasificacion, -2, 50, -2)).addComponent(this.JDCFechaIngresoP, -2, 50, -2)).addGap(24, 24, 24)));
        this.jTabbedPane1.addTab("ANTECEDENTES", this.JPIObstetricos);
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.19
            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.20
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Secundario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.21
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoObstetrico.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.22
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.23
            public void focusLost(FocusEvent evt) {
                JIFRiesgoObstetrico.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.24
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.25
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoObstetrico.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.26
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoObstetrico.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxP, -1, 119, 32767).addComponent(this.JTFCDxR1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNCodigoDxP, -1, 904, 32767).addComponent(this.JTFNDxR1)).addContainerGap()));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(48, 48, 48).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 50, -2).addComponent(this.JTFNCodigoDxP, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNDxR1, -2, 50, -2).addComponent(this.JTFCDxR1, -2, 50, -2)).addContainerGap(61, 32767)));
        this.jTabbedPane1.addTab("DIAGNÓSTICO", this.JPIDxConclusion);
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 251, -2).addContainerGap(-1, 32767)));
        this.JTPOpciones.addTab("INFORMACION", this.JPInformacion);
        this.JPResultado.setEnabled(false);
        this.JPIDetalleAtencion.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO DE EXÁMENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIInicioC.setBorder(BorderFactory.createTitledBorder((Border) null, "TAMIZAJE CLÍNICO Y DE LABORATORIO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFResultado.setFont(new Font("Arial", 1, 12));
        this.JTFFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFResultado.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.27
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoObstetrico.this.JTFFResultadoMouseClicked(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setHorizontalScrollBarPolicy(31);
        this.JSPObservacion.setVerticalScrollBarPolicy(21);
        this.JEPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JEPObservacion);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.28
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCHIngreso.setFont(new Font("Arial", 1, 12));
        this.JCHIngreso.setText("Es Ingreso?");
        this.JCHIngreso.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoObstetrico.29
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoObstetrico.this.JCHIngresoActionPerformed(evt);
            }
        });
        GroupLayout JPIInicioCLayout = new GroupLayout(this.JPIInicioC);
        this.JPIInicioC.setLayout(JPIInicioCLayout);
        JPIInicioCLayout.setHorizontalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion, -2, 666, -2).addGroup(JPIInicioCLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JCBExamen, -2, 372, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFResultado, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHIngreso))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar, -1, 304, 32767).addContainerGap()));
        JPIInicioCLayout.setVerticalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -2, 45, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBExamen, -2, 43, -2).addComponent(this.JTFFResultado))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(JPIInicioCLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JCHIngreso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.JSPObservacion, -2, 52, -2)).addComponent(this.JBTAdicionar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        this.JSHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(Color.red);
        this.JSHistorico.setViewportView(this.JTBHistorico);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSHistorico).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPIInicioC, -1, -1, 32767).addContainerGap()))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPIInicioC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSHistorico, -2, 192, -2).addContainerGap(-1, 32767)));
        GroupLayout JPIDetalleAtencionLayout = new GroupLayout(this.JPIDetalleAtencion);
        this.JPIDetalleAtencion.setLayout(JPIDetalleAtencionLayout);
        JPIDetalleAtencionLayout.setHorizontalGroup(JPIDetalleAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        JPIDetalleAtencionLayout.setVerticalGroup(JPIDetalleAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        GroupLayout JPResultadoLayout = new GroupLayout(this.JPResultado);
        this.JPResultado.setLayout(JPResultadoLayout);
        JPResultadoLayout.setHorizontalGroup(JPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDetalleAtencion, -1, -1, 32767));
        JPResultadoLayout.setVerticalGroup(JPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDetalleAtencion, -1, -1, 32767));
        this.JTPOpciones.addTab("RESULTADOS", this.JPResultado);
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "INGRESOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoObstetrico.30
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoObstetrico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSDetalle, -1, 1058, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSDetalle, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPOpciones.addTab("HISTORICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTPOpciones, GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPOpciones, -2, 452, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        cargarCboProfesional();
    }

    private void cargarCboProfesional() {
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.JCBEspecialidad.getSelectedIndex() > -1 && this.xlleno) {
            String sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM g_profesional INNER JOIN baseserver.w_profesional   ON (g_profesional.Id_Persona = w_profesional.Id_Persona) WHERE (g_profesional.P_Ips =1 AND g_profesional.Estado =0 AND w_profesional.IdEspecialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY w_profesional.NProfesional ASC ";
            this.JCBProfesional.removeAllItems();
            this.xidProfesional = xct.llenarCombo(sql, this.xidProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(0);
            JCBClaseCita.removeAllItems();
            this.xClaseCita = this.xconsulta.llenarComboyLista("SELECT Id, Nbre, Duracion FROM c_clasecita WHERE Id_Especialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and Estado=0 ORDER BY Nbre ASC", this.xClaseCita, JCBClaseCita, 3);
            this.xconsulta.cerrarConexionBd();
            if (JCBClaseCita.getItemCount() > 0) {
                JCBClaseCita.setSelectedIndex(-1);
                this.combocc = 1;
            }
            xct.cerrarConexionBd();
            return;
        }
        this.JCBProfesional.removeAllItems();
        this.xidProfesional = xct.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (Estado =0 AND IdEspecialidad =382) ORDER BY NProfesional ASC", this.xidProfesional, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        mCalcularImc();
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
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoD.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSSGestacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
        mBuscarGuiasPatologias(this.JTFCDxP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 1);
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 1);
        mBuscarGuiasPatologias(this.JTFCDxR1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFResultadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBExamen.getSelectedIndex() != -1) {
            if (!this.JTFFResultado.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xsql = "INSERT INTO `f_co_resultados` (Id_antencion,`Fecha_R`,`Id_examen`, `Resultado`,Es_ingreso,`Observacion`,`Usuarios`, `Fecha`)VALUES ('" + Principal.txtNo.getText() + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xidexamen[this.JCBExamen.getSelectedIndex()][0] + "','" + this.JTFFResultado.getText() + "','" + this.xEsIngreso + "','" + this.JEPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarResultado(Principal.txtNo.getText());
                    this.JDFecha.setDate(this.xmetodo.getFechaActual());
                    this.JCBExamen.setSelectedIndex(-1);
                    this.JTFFResultado.setText("");
                    this.JEPObservacion.setText("");
                    this.JCBExamen.requestFocus();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Resultado no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFResultado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBExamen.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIngresoActionPerformed(ActionEvent evt) {
        if (this.JCHIngreso.isSelected()) {
            this.xEsIngreso = 1;
        } else {
            this.xEsIngreso = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimoPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.txtUltimoParto.getDate() != null) {
            this.JTFFechaUParto.setText(this.xmetodo.formatoDMA.format(this.txtUltimoParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaAbortoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaAborto.getDate() != null) {
            this.JTFFechaUAborto.setText(this.xmetodo.formatoDMA.format(this.cboUltimaAborto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaMestruacionPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaMestruacion.getDate() != null) {
            this.JTFFechaUMestruacion.setText(this.xmetodo.formatoAMD.format(this.cboUltimaMestruacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaPPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboFechaPParto.getDate() != null) {
            this.JTFFechaPParto.setText(this.xmetodo.formatoDMA.format(this.cboFechaPParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaLegradoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaLegrado.getDate() != null) {
            this.JTFFechaULegrado.setText(this.xmetodo.formatoDMA.format(this.cboUltimaLegrado.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazadaActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada.isSelected()) {
            this.JTFSemanaG.setText("" + this.xmetodo.mSemanaGestacion(this.JTFFechaUMestruacion.getText()));
            this.JTFFechaPParto.setText("" + getFPP(this.JTFFechaUMestruacion.getText()));
        } else {
            this.JTFSemanaG.setText("0");
            this.JTFFechaPParto.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodeloH.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBEspecialidad.setSelectedItem(this.xmodeloH.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCBProfesional.setSelectedItem(this.xmodeloH.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            JCBClaseCita.setSelectedItem(this.xmodeloH.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            mCargarResultado(Principal.txtNo.getText());
            String sql = "SELECT`f_co_obstetrico`.`EMenarquia`, `f_co_obstetrico`.`FUMenstruacion`, `f_co_obstetrico`.`PIntergenesico`, `f_co_obstetrico`.`EGestacional`, `f_co_obstetrico`.`CRiesgo`, `f_co_obstetrico`.`FPParto`, `f_co_obstetrico`.`NEmbarazo`, `f_co_obstetrico`.`NAbortos`, `f_co_obstetrico`.`NPartos`, `f_co_obstetrico`.`NCesareas`,`f_co_obstetrico`.`NEctopicos`, `f_co_obstetrico`.`NNacMuertos`, `f_co_obstetrico`.`NNacVivos`, `f_co_obstetrico`.`FUParto`, `f_co_obstetrico`.`FUAborto`,`f_co_obstetrico`.`FULegrado`, `f_co_atencion`.`cie10P`, `f_co_atencion`.`cie10S`, `f_co_atencion`.`Fecha_atencion`, `f_co_atencion`.`Fecha_ingreso`, `f_co_atencion`.`Talla`, `f_co_atencion`.`Peso`, `f_co_atencion`.`Imc`, `f_co_atencion`.`Psistolica`, `f_co_atencion`.`Pdistolica`FROM`f_co_atencion`INNER JOIN `f_co_obstetrico` ON (`f_co_atencion`.`Id` = `f_co_obstetrico`.`Id_Atencion`)\nWHERE (`f_co_obstetrico`.`Id_Atencion` ='" + Principal.txtNo.getText() + "');";
            ResultSet rs = this.xconsulta.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.first();
                    this.JTFEMenarquia.setText(rs.getString("EMenarquia"));
                    this.JTFFechaUMestruacion.setText(rs.getString("FUMenstruacion"));
                    this.JTFPIntergenesico.setText(rs.getString("PIntergenesico"));
                    this.JTFSemanaG.setText(rs.getString("EGestacional"));
                    this.JCBClasificacion.setSelectedItem(rs.getString("CRiesgo"));
                    this.JTFFechaPParto.setText(rs.getString("FPParto"));
                    this.JSPNoEmbarazos.setValue(Integer.valueOf(rs.getInt("NEmbarazo")));
                    this.JSPNoAbortos.setValue(Integer.valueOf(rs.getInt("NAbortos")));
                    this.JSPNoCesareas.setValue(Integer.valueOf(rs.getInt("NCesareas")));
                    this.JSPNoPartos.setValue(Integer.valueOf(rs.getInt("NPartos")));
                    this.JSPNoEptopicos.setValue(Integer.valueOf(rs.getInt("NEctopicos")));
                    this.JSPNoMuertos.setValue(Integer.valueOf(rs.getInt("NNacMuertos")));
                    this.JSPNoVivos.setValue(Integer.valueOf(rs.getInt("NNacVivos")));
                    this.JTFFechaUParto.setText(rs.getString("FUParto"));
                    this.JTFFechaUAborto.setText(rs.getString("FUAborto"));
                    this.JTFFechaULegrado.setText(rs.getString("FULegrado"));
                    this.JTFCDxP.setText(rs.getString("cie10P"));
                    this.JTFNCodigoDxP.setText(mBuscarPatologias(rs.getString("cie10P")));
                    this.JTFCDxR1.setText(rs.getString("cie10S"));
                    this.JTFNDxR1.setText(mBuscarPatologias(rs.getString("cie10S")));
                    this.JDFechaAtencion.setDate(rs.getDate("Fecha_atencion"));
                    this.JDCFechaIngresoP.setDate(rs.getDate("Fecha_ingreso"));
                    this.JTFFSTalla.setText("" + rs.getInt("Talla"));
                    this.JTFFSPeso.setText("" + rs.getDouble("Peso"));
                    this.JTFFSIMC.setText("" + rs.getDouble("Imc"));
                    mCalcularImc();
                    this.JTFFPSentadoS.setText(rs.getString("Psistolica"));
                    this.JTFFPSentadoD.setText(rs.getString("Pdistolica"));
                }
                rs.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
            }
            this.xestadog = 0;
            setEnableContainer(this.JPResultado, true);
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

    private void mCargarCombos() {
        this.JCBEspecialidad.removeAllItems();
        this.xidEspecialidad = this.xconsulta.llenarCombo("SELECT  g_especialidad.Id ,  g_especialidad.Nbre FROM g_profesionalespecial  INNER JOIN  g_especialidad ON ( g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0 AND g_profesionalespecial.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC", this.xidEspecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBExamen.removeAllItems();
        this.xidexamen = this.xconsulta.llenarComboyLista("SELECT `Id`, `Nbre`, `Id_Procedimiento` FROM `p_demanda_inducida` WHERE (`Nbre` <>'' AND `Estado` =1) ORDER BY `Nbre` ASC", this.xidexamen, this.JCBExamen, 3);
        this.JCBExamen.setSelectedIndex(-1);
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
    }

    private int getTalla() {
        int valor = 0;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && Integer.parseInt(this.JTFFSTalla.getText()) > 0) {
            valor = Integer.parseInt(this.JTFFSTalla.getText());
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

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("0.00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFSIMC.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.JTFFSIMC.setText("0");
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "conclusion", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xconsulta.traerRs(sql);
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
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private String mBuscarPatologias(String xcodigo) {
        String xnombre = null;
        try {
            ConsultasMySQL xmt = new ConsultasMySQL();
            String sql = "SELECT Id, Nbre FROM  g_patologia where Id='" + xcodigo + "'";
            ResultSet res = xmt.traerRs(sql);
            if (res.next()) {
                xnombre = res.getString(2);
            }
            res.close();
            xmt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnombre;
    }

    private void mBuscarGuiasPatologias(String codigo) {
        try {
            String sql = "SELECT PathGuia FROM h_patologiaxguiamanejo WHERE (Id_Patologia ='" + codigo + "')";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int x = JOptionPane.showInternalConfirmDialog(this, "El código tiene una guia asociada \t Desea consultarla?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmetodo.mostrarPdf(xrs.getString(1));
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.xmetodo.mostrarMensaje("La Presión Sistólica esta Baja");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.xmetodo.mostrarMensaje("La Presión Sistólica esta Alta");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.xmetodo.mostrarMensaje("La Presion Diastólica esta Baja");
        } else if (valor > 0 && valor > 90) {
            this.xmetodo.mostrarMensaje("La Presión Diastólica esta Alta");
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JCBEspecialidad.requestFocus();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBProfesional.setSelectedIndex(-1);
        JCBClaseCita.setSelectedIndex(-1);
        this.JTFFSTalla.setText("0");
        this.JTFFSPeso.setText("0");
        this.JTFFSIMC.setText("0");
        this.JTFFPSentadoS.setText("0");
        this.JTFFPSentadoD.setText("0");
        this.JSPNoEmbarazos.setValue(new Integer(0));
        this.JSPNoAbortos.setValue(new Integer(0));
        this.JSPNoPartos.setValue(new Integer(0));
        this.JSPNoCesareas.setValue(new Integer(0));
        this.JSPNoEptopicos.setValue(new Integer(0));
        this.JSPNoMuertos.setValue(new Integer(0));
        this.JSPNoVivos.setValue(new Integer(0));
        this.JTFFechaUParto.setText("");
        this.JTFFechaUAborto.setText("");
        this.JTFFechaUMestruacion.setText("");
        this.JTFFechaULegrado.setText("");
        this.JTFFechaPParto.setText("");
        this.JTFEMenarquia.setText("");
        this.JTFPIntergenesico.setText("");
        this.JTFSemanaG.setText("");
        this.JCBClasificacion.setSelectedIndex(0);
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFCDxR1.setText("");
        this.JTFNDxR1.setText("");
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JCBExamen.setSelectedIndex(-1);
        this.JTFFResultado.setText("");
        this.JCHIngreso.setSelected(false);
        this.xEsIngreso = 1;
        this.JEPObservacion.setText("");
        this.JDFechaAtencion.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaIngresoP.setDate(this.xmetodo.getFechaActual());
        setEnableContainer(this.JPResultado, false);
        mCrearTablaHisstorico();
        mCrearTablaR();
        this.frmPersona.nuevo();
        this.frmPersona.requestFocus();
        this.xestadog = 1;
    }

    private boolean mValidarCampos() {
        boolean rs = false;
        if (this.frmPersona.getIdPersona() != "0") {
            if (Principal.txtNo.getText().isEmpty()) {
                if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                    if (this.JCBProfesional.getSelectedIndex() == -1) {
                        JOptionPane.showInternalMessageDialog(this, "seleccionar un profecional ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBProfesional.requestFocus();
                    } else if (JCBClaseCita.getSelectedIndex() != -1) {
                        if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                            rs = true;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe haber por lo menos un Diagnostico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFNCodigoDxP.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Seleccionar Clase Cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        JCBClaseCita.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "La Especialidad no debe   estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBEspecialidad.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Este registro esta Activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar un Numero de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
        }
        return rs;
    }

    public void mGrabar() {
        if (mValidarCampos()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO`f_co_atencion`(Id_persona,`Id_especialidad`, `Id_profecional`,`Id_clasecita`,`Fecha_atencion`,cie10P,cie10S,`Fecha_ingreso`,`Talla`,`Peso`,`Imc`,`Psistolica`,`Pdistolica`,`Fecha`,`UsuarioS`)VALUES ('" + this.frmPersona.getIdPersona() + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xClaseCita[JCBClaseCita.getSelectedIndex()][0] + "','" + this.xmetodo.formatoAMD.format(this.JDFechaAtencion.getDate()) + "','" + this.JTFCDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaIngresoP.getDate()) + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText().replaceAll(",", ".") + "','" + this.JTFFPSentadoS.getText() + "','" + this.JTFFPSentadoD.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                this.xconsulta.cerrarConexionBd();
                String sql1 = "INSERT INTO f_co_obstetrico(Id_atencion,`EMenarquia`,`FUMenstruacion`,`PIntergenesico`,`EGestacional`,`CRiesgo`,`FPParto`,`NEmbarazo`,`NAbortos`,`NCesareas`, `NPartos`,`NEctopicos`,`NNacMuertos`,`NNacVivos`,`FUParto`,`FUAborto`,`FULegrado`,`Fecha`,`UsuarioS`)VALUES ('" + Principal.txtNo.getText() + "','" + this.JTFEMenarquia.getText() + "','" + this.JTFFechaUMestruacion.getText() + "','" + this.JTFPIntergenesico.getText() + "','" + this.JTFSemanaG.getText() + "','" + this.JCBClasificacion.getSelectedItem() + "','" + this.JTFFechaPParto.getText() + "','" + this.JSPNoEmbarazos.getValue() + "','" + this.JSPNoAbortos.getValue() + "','" + this.JSPNoCesareas.getValue() + "','" + this.JSPNoPartos.getValue() + "','" + this.JSPNoEptopicos.getValue() + "','" + this.JSPNoMuertos.getValue() + "','" + this.JSPNoVivos.getValue() + "','" + this.JTFFechaUParto.getText() + "','" + this.JTFFechaUAborto.getText() + "','" + this.JTFFechaULegrado.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(sql1);
                this.xconsulta.cerrarConexionBd();
                mCargarHistorico(this.frmPersona.getIdPersona());
                setEnableContainer(this.JPResultado, true);
            }
        }
    }

    public static void setEnableContainer(Container c, boolean band) {
        Container[] components = c.getComponents();
        c.setEnabled(band);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);
            if (components[i] instanceof Container) {
                setEnableContainer(components[i], band);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Exámen", "Resultado", "Es ingreso", "Observación"}) { // from class: Facturacion.JIFRiesgoObstetrico.31
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodeloR);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarResultado(String xidatencion) {
        try {
            String xsql = "SELECT `f_co_resultados`.`Id`,`f_co_resultados`.`Fecha_R`, `p_demanda_inducida`.`Nbre`, `f_co_resultados`.`Resultado`, `f_co_resultados`.`Es_ingreso`, `f_co_resultados`.`Observacion`FROM`f_co_atencion`INNER JOIN `f_co_resultados` ON (`f_co_atencion`.`Id` = `f_co_resultados`.`Id_antencion`)INNER JOIN `p_demanda_inducida` ON (`p_demanda_inducida`.`Id` = `f_co_resultados`.`Id_examen`)WHERE (`f_co_resultados`.`Id_antencion` ='" + xidatencion + "')ORDER BY `f_co_resultados`.`Fecha_R` DESC;";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            Throwable th = null;
            try {
                mCrearTablaR();
                int x = 0;
                while (xrs.next()) {
                    this.xmodeloR.addRow(this.xdato);
                    this.xmodeloR.setValueAt(xrs.getString(1), x, 0);
                    this.xmodeloR.setValueAt(xrs.getString(2), x, 1);
                    this.xmodeloR.setValueAt(xrs.getString(3), x, 2);
                    this.xmodeloR.setValueAt(xrs.getString(4), x, 3);
                    this.xmodeloR.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 4);
                    this.xmodeloR.setValueAt(xrs.getString(6), x, 5);
                    x++;
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
                this.xconsulta.cerrarConexionBd();
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
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.frmPersona.buscar(3);
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarHistorico(String xidp) {
        try {
            this.xsql = " SELECT`f_co_atencion`.`Id`, `f_co_atencion`.`Fecha_atencion`, `f_co_obstetrico`.`CRiesgo`, `c_clasecita`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`FROM`c_clasecita`INNER JOIN `f_co_atencion` ON (`c_clasecita`.`Id` = `f_co_atencion`.`Id_clasecita`)INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `f_co_atencion`.`Id_profecional`) AND (`profesional1`.`IdEspecialidad` = `f_co_atencion`.`Id_especialidad`)INNER JOIN `persona` ON (`persona`.`Id_persona` = `f_co_atencion`.`Id_persona`)INNER JOIN `f_co_obstetrico` ON (`f_co_obstetrico`.`Id_Atencion` = `f_co_atencion`.`Id`)WHERE (`persona`.`Id_persona` ='" + xidp + "'AND f_co_atencion.Estado=1)ORDER BY `f_co_atencion`.`Id` DESC;";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            Throwable th = null;
            try {
                mCrearTablaHisstorico();
                int x = 0;
                while (xrs.next()) {
                    this.xmodeloH.addRow(this.xdato);
                    this.xmodeloH.setValueAt(xrs.getString(1), x, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), x, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), x, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), x, 3);
                    this.xmodeloH.setValueAt(xrs.getString(5), x, 4);
                    this.xmodeloH.setValueAt(xrs.getString(6), x, 5);
                    x++;
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
                this.xconsulta.cerrarConexionBd();
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
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHisstorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Clasificacion De Riesgo", "Clase Cita", "Especialidad", "Profesional"}) { // from class: Facturacion.JIFRiesgoObstetrico.32
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloH);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }
}
