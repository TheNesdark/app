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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFRiesgoCardiovascular.class */
public class JIFRiesgoCardiovascular extends JInternalFrame {
    public Persona frmPersona;
    public clasesHistoriaCE xclase;
    private String xsql;
    public String[] xidEspecialidad;
    public String[] xidProfesional;
    public String[] xestado;
    public String[][] xClaseCita;
    public String[][] xidexamen;
    public Ingreso frmIngreso;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloR;
    private Object[] xdato;
    public JDateChooser CBOFechaConf;
    public JDateChooser CBOFechaConf2;
    public JDateChooser CBOFechaIngresoP;
    private JButton JBTAdicionar;
    public static JComboBox JCBClaseCita;
    public JComboBox JCBClasificacion;
    public JComboBox JCBEspecialidad;
    private JComboBox JCBExamen;
    public JComboBox JCBProfesional;
    private JCheckBox JCHConfiDbt;
    private JCheckBox JCHConfiEnpril1;
    private JCheckBox JCHConfiHta;
    private JCheckBox JCHConfirenal;
    private JCheckBox JCHConlosartan;
    private JCheckBox JCHIngreso;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaAtencion;
    private JEditorPane JEPObservacion;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPHistorico;
    private JPanel JPIDxConclusion;
    private JPanel JPIInicioC;
    private JPanel JPIPresion;
    private JPanel JPI_Datos2_D;
    private JPanel JPI_Datos2_Dx;
    private JPanel JPI_DatosA;
    private JPanel JPdiabetes;
    private JPanel JPhta;
    private JPanel JPingreso;
    private JPanel JPresultado;
    private JScrollPane JSPObservacion;
    private JTextArea JTArenalcronica;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCostosHTA;
    private JTextField JTFCostosdbt;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextField JTFFResultado;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTable JTHistorico;
    private JTabbedPane JTP_Datos1;
    private JTabbedPane JTP_Datos2;
    private JTable JTresultado;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JPanel panelPersona;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private boolean xlleno = false;
    public int cboLleno = 0;
    public int xconfirmardohta = 0;
    public int xconfirmadobt = 0;
    public int combocc = 0;
    public int xconfirmadolosartan = 0;
    public int xconfirmadoenapril = 0;
    public int xconfirmadorenal = 0;
    private double imc = 0.0d;
    private long xEsIngreso = 0;
    private long xestadog = 1;

    public JIFRiesgoCardiovascular() {
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

    /* JADX WARN: Type inference failed for: r3v221, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v269, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.panelPersona = new JPanel();
        this.JTP_Datos1 = new JTabbedPane();
        this.JPingreso = new JPanel();
        this.JPI_DatosA = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        JCBClaseCita = new JComboBox();
        this.JDFechaAtencion = new JDateChooser();
        this.JTP_Datos2 = new JTabbedPane();
        this.JPI_Datos2_D = new JPanel();
        this.CBOFechaIngresoP = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JPhta = new JPanel();
        this.JCHConfiHta = new JCheckBox();
        this.CBOFechaConf = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFCostosHTA = new JTextField();
        this.JPdiabetes = new JPanel();
        this.JCHConfiDbt = new JCheckBox();
        this.CBOFechaConf2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFCostosdbt = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTArenalcronica = new JTextArea();
        this.JCBClasificacion = new JComboBox();
        this.JCHConlosartan = new JCheckBox();
        this.JCHConfirenal = new JCheckBox();
        this.JCHConfiEnpril1 = new JCheckBox();
        this.JPI_Datos2_Dx = new JPanel();
        this.JPIDxConclusion = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.jPanel5 = new JPanel();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JPresultado = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTresultado = new JTable();
        this.JPIInicioC = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBExamen = new JComboBox();
        this.JTFFResultado = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JEPObservacion = new JEditorPane();
        this.JBTAdicionar = new JButton();
        this.JCHIngreso = new JCheckBox();
        this.JPHistorico = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONTROL CARDIOVASCULAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFRiesgoCardiovascular");
        setOpaque(true);
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1039, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 184, 32767));
        this.JTP_Datos1.setForeground(new Color(255, 0, 0));
        this.JTP_Datos1.setToolTipText("");
        this.JTP_Datos1.setFont(new Font("Arial", 1, 14));
        this.JPingreso.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosA.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JIFRiesgoCardiovascular.1
            public void itemStateChanged(ItemEvent evt) {
                JIFRiesgoCardiovascular.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBClaseCita.setFont(new Font("Arial", 1, 12));
        JCBClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBClaseCita.setName("JCBClaseCita");
        JCBClaseCita.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.2
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoCardiovascular.this.JCBClaseCitaMouseClicked(evt);
            }
        });
        JCBClaseCita.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.3
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCBClaseCitaActionPerformed(evt);
            }
        });
        this.JDFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaAtencion.setDateFormatString("dd/MM/yyyy");
        this.JDFechaAtencion.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_DatosALayout = new GroupLayout(this.JPI_DatosA);
        this.JPI_DatosA.setLayout(JPI_DatosALayout);
        JPI_DatosALayout.setHorizontalGroup(JPI_DatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosALayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_DatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosALayout.createSequentialGroup().addComponent(this.JDFechaAtencion, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 340, -2)).addComponent(JCBClaseCita, -2, 339, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBProfesional, -2, 463, -2).addGap(29, 29, 29)));
        JPI_DatosALayout.setVerticalGroup(JPI_DatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosALayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPI_DatosALayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JDFechaAtencion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBProfesional, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCBClaseCita, -2, 54, -2).addContainerGap(-1, 32767)));
        this.JTP_Datos2.setBackground(new Color(204, 204, 204));
        this.JTP_Datos2.setForeground(new Color(0, 103, 0));
        this.JTP_Datos2.setFont(new Font("Arial", 1, 14));
        this.CBOFechaIngresoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha De Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.CBOFechaIngresoP.setDateFormatString("dd/MM/yyyy");
        this.CBOFechaIngresoP.setName("txtFecha");
        this.CBOFechaIngresoP.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.4
            public void focusGained(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaIngresoPFocusGained(evt);
            }
        });
        this.CBOFechaIngresoP.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoCardiovascular.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaIngresoPPropertyChange(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.6
            public void focusGained(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.7
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.8
            public void focusGained(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.9
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFSPesoActionPerformed(evt);
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
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.10
            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.11
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoS, new AbsoluteConstraints(10, 15, 45, 30));
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.12
            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.13
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoD, new AbsoluteConstraints(80, 15, 45, 30));
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JPIPresion.add(this.JLBPBSentado, new AbsoluteConstraints(60, 20, -1, 23));
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        this.JPIPresion.add(this.JLBPSentado1, new AbsoluteConstraints(10, 50, 120, -1));
        this.JPhta.setBorder(BorderFactory.createTitledBorder(""));
        this.JCHConfiHta.setFont(new Font("Arial", 1, 12));
        this.JCHConfiHta.setForeground(Color.blue);
        this.JCHConfiHta.setText("Confirmado HTA ?");
        this.JCHConfiHta.setBorder(BorderFactory.createTitledBorder((Border) null, "SI", 0, 0, new Font("Tahoma", 0, 16), new Color(0, 51, 255)));
        this.JCHConfiHta.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.14
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHConfiHtaActionPerformed(evt);
            }
        });
        this.CBOFechaConf.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Dx HTA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.CBOFechaConf.setDateFormatString("dd/MM/yyyy");
        this.CBOFechaConf.setName("txtFecha");
        this.CBOFechaConf.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.15
            public void focusGained(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaConfFocusGained(evt);
            }
        });
        this.CBOFechaConf.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoCardiovascular.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaConfPropertyChange(evt);
            }
        });
        this.JTFCostosHTA.setFont(new Font("Arial", 1, 12));
        this.JTFCostosHTA.setBorder(BorderFactory.createTitledBorder((Border) null, "Costos HTA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPhtaLayout = new GroupLayout(this.JPhta);
        this.JPhta.setLayout(JPhtaLayout);
        JPhtaLayout.setHorizontalGroup(JPhtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPhtaLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JCHConfiHta, -1, 198, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.CBOFechaConf, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFCostosHTA, -2, 603, -2).addGap(17, 17, 17)));
        JPhtaLayout.setVerticalGroup(JPhtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPhtaLayout.createSequentialGroup().addGroup(JPhtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPhtaLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPhtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCostosHTA, -2, 50, -2).addComponent(this.CBOFechaConf, -2, 50, -2))).addComponent(this.JCHConfiHta, -2, 46, -2)).addGap(3, 3, 3)));
        this.JPdiabetes.setBorder(BorderFactory.createTitledBorder(""));
        this.JCHConfiDbt.setFont(new Font("Arial", 1, 12));
        this.JCHConfiDbt.setForeground(Color.blue);
        this.JCHConfiDbt.setText("Confirmado DBT Multiple ?");
        this.JCHConfiDbt.setBorder(BorderFactory.createTitledBorder((Border) null, "SI", 0, 0, new Font("Tahoma", 0, 16), new Color(0, 51, 255)));
        this.JCHConfiDbt.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.17
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHConfiDbtActionPerformed(evt);
            }
        });
        this.CBOFechaConf2.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Dx DBT", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.CBOFechaConf2.setDateFormatString("dd/MM/yyyy");
        this.CBOFechaConf2.setName("txtFecha");
        this.CBOFechaConf2.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.18
            public void focusGained(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaConf2FocusGained(evt);
            }
        });
        this.CBOFechaConf2.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFRiesgoCardiovascular.19
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRiesgoCardiovascular.this.CBOFechaConf2PropertyChange(evt);
            }
        });
        this.JTFCostosdbt.setFont(new Font("Arial", 1, 12));
        this.JTFCostosdbt.setBorder(BorderFactory.createTitledBorder((Border) null, "Costos DBT Multiples ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPdiabetesLayout = new GroupLayout(this.JPdiabetes);
        this.JPdiabetes.setLayout(JPdiabetesLayout);
        JPdiabetesLayout.setHorizontalGroup(JPdiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPdiabetesLayout.createSequentialGroup().addComponent(this.JCHConfiDbt, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.CBOFechaConf2, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFCostosdbt, -2, 604, -2).addContainerGap(-1, 32767)));
        JPdiabetesLayout.setVerticalGroup(JPdiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPdiabetesLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPdiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCostosdbt, -2, 50, -2).addComponent(this.CBOFechaConf2, -2, 50, -2).addComponent(this.JCHConfiDbt, -2, 46, -2)).addGap(3, 3, 3)));
        this.JTArenalcronica.setColumns(20);
        this.JTArenalcronica.setFont(new Font("Arial", 1, 12));
        this.JTArenalcronica.setRows(5);
        this.JTArenalcronica.setBorder(BorderFactory.createTitledBorder((Border) null, "Etioligica de la Enfermedad Renal Cronica", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTArenalcronica);
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setModel(new DefaultComboBoxModel(new String[]{"BAJO", "MEDIO", "ALTO", "MUY ALTO"}));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHConlosartan.setFont(new Font("Arial", 1, 12));
        this.JCHConlosartan.setForeground(Color.blue);
        this.JCHConlosartan.setText("Toma Losartan ?");
        this.JCHConlosartan.setBorder(BorderFactory.createTitledBorder((Border) null, "SI", 0, 0, new Font("Tahoma", 0, 16), new Color(0, 51, 255)));
        this.JCHConlosartan.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.20
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHConlosartanActionPerformed(evt);
            }
        });
        this.JCHConfirenal.setFont(new Font("Arial", 1, 12));
        this.JCHConfirenal.setForeground(Color.blue);
        this.JCHConfirenal.setText("Confirmado Enfermedad Renal  ?");
        this.JCHConfirenal.setBorder(BorderFactory.createTitledBorder((Border) null, "SI", 0, 0, new Font("Tahoma", 0, 16), new Color(0, 51, 255)));
        this.JCHConfirenal.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.21
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHConfirenalActionPerformed(evt);
            }
        });
        this.JCHConfiEnpril1.setFont(new Font("Arial", 1, 12));
        this.JCHConfiEnpril1.setForeground(Color.blue);
        this.JCHConfiEnpril1.setText("Toma Enapril o Captopril ? ");
        this.JCHConfiEnpril1.setBorder(BorderFactory.createTitledBorder((Border) null, "SI", 0, 0, new Font("Tahoma", 0, 16), new Color(0, 51, 255)));
        this.JCHConfiEnpril1.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.22
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHConfiEnpril1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2_DLayout = new GroupLayout(this.JPI_Datos2_D);
        this.JPI_Datos2_D.setLayout(JPI_Datos2_DLayout);
        JPI_Datos2_DLayout.setHorizontalGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JCHConlosartan, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHConfiEnpril1, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHConfirenal, -2, 248, -2).addContainerGap(-1, 32767)).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addComponent(this.CBOFechaIngresoP, -2, 159, -2).addGap(10, 10, 10).addComponent(this.JTFFSTalla, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFSPeso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFSIMC, -2, 100, -2).addGap(18, 18, 18).addComponent(this.JPIPresion, -2, 142, -2).addGap(26, 26, 26).addComponent(this.JCBClasificacion, -2, 228, -2).addGap(0, 0, 32767)).addComponent(this.jScrollPane3).addComponent(this.JPdiabetes, -1, -1, 32767).addComponent(this.JPhta, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(10, 10, 10)))));
        JPI_Datos2_DLayout.setVerticalGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 54, -2).addComponent(this.JTFFSPeso, -2, 55, -2)).addComponent(this.JTFFSIMC, -2, 55, -2))).addComponent(this.JPIPresion, -2, 75, -2))).addGroup(JPI_Datos2_DLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.CBOFechaIngresoP, -2, 56, -2))).addGap(5, 5, 5)).addGroup(GroupLayout.Alignment.TRAILING, JPI_Datos2_DLayout.createSequentialGroup().addComponent(this.JCBClasificacion, -2, 50, -2).addGap(18, 18, 18))).addComponent(this.JPhta, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JPdiabetes, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, -1, -2).addGap(5, 5, 5).addGroup(JPI_Datos2_DLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHConlosartan, -2, 46, -2).addComponent(this.JCHConfiEnpril1, -2, 46, -2).addComponent(this.JCHConfirenal, -2, 46, -2)).addGap(10, 10, 10)));
        this.JTP_Datos2.addTab("DATOS", this.JPI_Datos2_D);
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.23
            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.24
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoCardiovascular.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.25
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoCardiovascular.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.26
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoCardiovascular.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP).addContainerGap()));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 50, -2).addComponent(this.JTFNCodigoDxP, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder(""));
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.27
            public void focusLost(FocusEvent evt) {
                JIFRiesgoCardiovascular.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.28
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoCardiovascular.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Secundario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.29
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoCardiovascular.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.30
            public void keyPressed(KeyEvent evt) {
                JIFRiesgoCardiovascular.this.JTFNDxR1KeyPressed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxR1, -2, 118, -2).addGap(10, 10, 10).addComponent(this.JTFNDxR1, -1, 807, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(22, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxR1, -2, 50, -2).addComponent(this.JTFNDxR1, -2, 50, -2)).addContainerGap()));
        GroupLayout JPI_Datos2_DxLayout = new GroupLayout(this.JPI_Datos2_Dx);
        this.JPI_Datos2_Dx.setLayout(JPI_Datos2_DxLayout);
        JPI_Datos2_DxLayout.setHorizontalGroup(JPI_Datos2_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DxLayout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos2_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDxConclusion, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPI_Datos2_DxLayout.setVerticalGroup(JPI_Datos2_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2_DxLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDxConclusion, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addContainerGap(190, 32767)));
        this.JTP_Datos2.addTab("DIAGÒSTICOS", this.JPI_Datos2_Dx);
        GroupLayout JPingresoLayout = new GroupLayout(this.JPingreso);
        this.JPingreso.setLayout(JPingresoLayout);
        JPingresoLayout.setHorizontalGroup(JPingresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPingresoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPingresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_DatosA, -1, -1, 32767).addComponent(this.JTP_Datos2, -2, 0, 32767)).addContainerGap()));
        JPingresoLayout.setVerticalGroup(JPingresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPingresoLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPI_DatosA, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JTP_Datos2).addGap(10, 10, 10)));
        this.JTP_Datos1.addTab("INGRESO", this.JPingreso);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTRO DE RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTresultado.setFont(new Font("Arial", 1, 12));
        this.JTresultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane2.setViewportView(this.JTresultado);
        this.JPIInicioC.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO DE EXÁMENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBExamen.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.31
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCBExamenActionPerformed(evt);
            }
        });
        this.JTFFResultado.setFont(new Font("Arial", 1, 12));
        this.JTFFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFResultado.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.32
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoCardiovascular.this.JTFFResultadoMouseClicked(evt);
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
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.33
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCHIngreso.setFont(new Font("Arial", 1, 12));
        this.JCHIngreso.setText("Es Ingreso?");
        this.JCHIngreso.addActionListener(new ActionListener() { // from class: Facturacion.JIFRiesgoCardiovascular.34
            public void actionPerformed(ActionEvent evt) {
                JIFRiesgoCardiovascular.this.JCHIngresoActionPerformed(evt);
            }
        });
        GroupLayout JPIInicioCLayout = new GroupLayout(this.JPIInicioC);
        this.JPIInicioC.setLayout(JPIInicioCLayout);
        JPIInicioCLayout.setHorizontalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIInicioCLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JCBExamen, -2, 372, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFResultado)).addComponent(this.JSPObservacion, -2, 696, -2)).addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.JBTAdicionar, -1, 201, 32767).addContainerGap()).addGroup(JPIInicioCLayout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.JCHIngreso).addContainerGap(-1, 32767)))));
        JPIInicioCLayout.setVerticalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIInicioCLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHIngreso).addGap(18, 18, 18).addComponent(this.JBTAdicionar, -2, 74, -2)).addGroup(JPIInicioCLayout.createSequentialGroup().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -2, 45, -2).addComponent(this.JCBExamen, GroupLayout.Alignment.TRAILING, -2, 43, -2).addComponent(this.JTFFResultado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 61, -2))).addGap(10, 10, 10)));
        GroupLayout JPresultadoLayout = new GroupLayout(this.JPresultado);
        this.JPresultado.setLayout(JPresultadoLayout);
        JPresultadoLayout.setHorizontalGroup(JPresultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPresultadoLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(JPresultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2).addComponent(this.JPIInicioC, -1, -1, 32767)).addContainerGap(34, 32767)));
        JPresultadoLayout.setVerticalGroup(JPresultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPresultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIInicioC, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jScrollPane2, -1, 399, 32767).addContainerGap()));
        this.JTP_Datos1.addTab("RESULTADOS", this.JPresultado);
        this.jScrollPane1.setFont(new Font("Arial", 1, 14));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRiesgoCardiovascular.35
            public void mouseClicked(MouseEvent evt) {
                JIFRiesgoCardiovascular.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1034, 32767));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 608, 32767));
        this.JTP_Datos1.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JTP_Datos1, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos1).addGap(8, 8, 8)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBExamen.getSelectedIndex() != -1) {
            if (!this.JTFFResultado.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de kevin?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xsql = "INSERT INTO `f_co_resultados` (Id_antencion,`Fecha_R`,`Id_examen`, `Resultado`,Es_ingreso,`Observacion`,`Usuarios`, `Fecha`)VALUES ('" + Principal.txtNo.getText() + "','" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xidexamen[this.JCBExamen.getSelectedIndex()][0] + "','" + this.JTFFResultado.getText() + "','" + this.xEsIngreso + "','" + this.JEPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarResultado(Principal.txtNo.getText());
                    this.JDFecha.setDate(this.metodos.getFechaActual());
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
    public void JTFFResultadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBExamenActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClaseCitaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClaseCitaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        cargarCboProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIngresoActionPerformed(ActionEvent evt) {
        if (this.JCHIngreso.isSelected()) {
            this.xEsIngreso = 1L;
        } else {
            this.xEsIngreso = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCBProfesional.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            JCBClaseCita.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            mCargarResultado(Principal.txtNo.getText());
            String sql = "SELECT`f_co_cardiovascular`.`ConfirmadoHTA`, `f_co_cardiovascular`.`Fecha_conf` , `f_co_cardiovascular`.`CostosHTA`, `f_co_cardiovascular`.`ConfirmadoDBT` , `f_co_cardiovascular`.`Fecha_confdbt`, `f_co_cardiovascular`.`CostosDBT` , `f_co_cardiovascular`.`EtiologiaR`, `f_co_atencion`.`Fecha_atencion`, `f_co_atencion`.`cie10P`, `f_co_atencion`.`cie10S`, `f_co_atencion`.`Fecha_ingreso` , `f_co_atencion`.`Talla`, `f_co_atencion`.`Peso`, `f_co_atencion`.`Imc`, `f_co_atencion`.`Psistolica`, `f_co_atencion`.`Pdistolica`FROM`f_co_cardiovascular`INNER JOIN `baseserver`.`f_co_atencion` ON (`f_co_cardiovascular`.`Id_atencion` = `f_co_atencion`.`Id`)WHERE (`f_co_atencion`.`Id` ='" + Principal.txtNo.getText() + "');";
            ResultSet rs = this.xconsulta.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.first();
                    if (this.JCHConfiHta.isSelected()) {
                        this.xconfirmardohta = 0;
                    } else {
                        this.xconfirmardohta = 1;
                    }
                    this.CBOFechaConf.setDate(rs.getDate("Fecha_conf"));
                    this.JTFCostosHTA.setText(rs.getString("CostosHTA"));
                    if (this.JCHConfiDbt.isSelected()) {
                        this.xconfirmadobt = 0;
                    } else {
                        this.xconfirmadobt = 1;
                    }
                    this.CBOFechaConf2.setDate(rs.getDate("Fecha_confdbt"));
                    this.JTFCostosdbt.setText(rs.getString("CostosDBT"));
                    this.JTArenalcronica.setText(rs.getString("EtiologiaR"));
                    this.JDFechaAtencion.setDate(rs.getDate("Fecha_atencion"));
                    this.JTFCDxP.setText(rs.getString("cie10P"));
                    buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
                    this.JTFCDxR1.setText(rs.getString("cie10S"));
                    buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0);
                    this.CBOFechaIngresoP.setDate(rs.getDate("Fecha_ingreso"));
                    this.JTFFSTalla.setText("" + rs.getInt("Talla"));
                    this.JTFFSPeso.setText("" + rs.getDouble("Peso"));
                    this.JTFFSIMC.setText("" + rs.getDouble("Imc"));
                    calcularImc();
                    this.JTFFPSentadoS.setText(rs.getString("Psistolica"));
                    this.JTFFPSentadoD.setText(rs.getString("Pdistolica"));
                }
                rs.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
            }
            this.xestadog = 0L;
        }
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
    public void CBOFechaConf2PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaConf2FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConfiDbtActionPerformed(ActionEvent evt) {
        if (this.JCHConfiDbt.isSelected()) {
            this.xconfirmadobt = 1;
        } else {
            this.xconfirmadobt = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaConfPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaConfFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConfiHtaActionPerformed(ActionEvent evt) {
        if (this.JCHConfiHta.isSelected()) {
            this.xconfirmardohta = 1;
        } else {
            this.xconfirmardohta = 0;
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
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaIngresoPPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaIngresoPFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConlosartanActionPerformed(ActionEvent evt) {
        if (this.JCHConlosartan.isSelected()) {
            this.xconfirmadolosartan = 1;
        } else {
            this.xconfirmadolosartan = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConfirenalActionPerformed(ActionEvent evt) {
        if (this.JCHConfirenal.isSelected()) {
            this.xconfirmadorenal = 1;
        } else {
            this.xconfirmadorenal = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConfiEnpril1ActionPerformed(ActionEvent evt) {
        if (this.JCHConfiEnpril1.isSelected()) {
            this.xconfirmadoenapril = 1;
        } else {
            this.xconfirmadoenapril = 0;
        }
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
        mValidarCF();
    }

    private void cargarCboProfesional() {
        ConsultasMySQL xconsulta = new ConsultasMySQL();
        if (this.JCBEspecialidad.getSelectedIndex() > -1 && this.xlleno) {
            String sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM g_profesional INNER JOIN baseserver.w_profesional   ON (g_profesional.Id_Persona = w_profesional.Id_Persona) WHERE (g_profesional.P_Ips =1 AND g_profesional.Estado =0 AND w_profesional.IdEspecialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY w_profesional.NProfesional ASC ";
            this.JCBProfesional.removeAllItems();
            this.xidProfesional = xconsulta.llenarCombo(sql, this.xidProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(0);
            JCBClaseCita.removeAllItems();
            this.xClaseCita = xconsulta.llenarComboyLista("SELECT Id, Nbre, Duracion FROM c_clasecita WHERE Id_Especialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and Estado=0 ORDER BY Nbre ASC", this.xClaseCita, JCBClaseCita, 3);
            xconsulta.cerrarConexionBd();
            if (JCBClaseCita.getItemCount() > 0) {
                JCBClaseCita.setSelectedIndex(-1);
                this.combocc = 1;
            }
            xconsulta.cerrarConexionBd();
            return;
        }
        this.JCBProfesional.removeAllItems();
        this.xidProfesional = xconsulta.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (Estado =0 AND IdEspecialidad =382) ORDER BY NProfesional ASC", this.xidProfesional, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        xconsulta.cerrarConexionBd();
    }

    public void mNuevo() {
        this.frmPersona.nuevo();
        Principal.txtNo.setText("");
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFCDxR1.setText("");
        this.JTFNDxR1.setText("");
        this.JTFCostosHTA.setText("");
        this.JTFCostosdbt.setText("");
        this.JTArenalcronica.setText("");
        this.JTFFSTalla.setText("0");
        this.JTFFSPeso.setText("0");
        this.JTFFSIMC.setText("0");
        this.JTFFPSentadoS.setText("0");
        this.JTFFPSentadoD.setText("0");
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBProfesional.setSelectedIndex(-1);
        JCBClaseCita.setSelectedIndex(-1);
        this.xconfirmadobt = 0;
        this.xconfirmardohta = 0;
        this.xconfirmadolosartan = 0;
        this.xconfirmadoenapril = 0;
        this.xconfirmadorenal = 0;
        this.JCHConfiHta.setSelected(false);
        this.JCHConfiDbt.setSelected(false);
        this.JCHConlosartan.setSelected(false);
        this.JCHConfiEnpril1.setSelected(false);
        this.JCHConfirenal.setSelected(false);
        this.JDFechaAtencion.setDate(this.metodos.getFechaActualPC());
        this.CBOFechaIngresoP.setDate(this.metodos.getFechaActualPC());
        this.CBOFechaConf.setDate(this.metodos.getFechaActualPC());
        this.CBOFechaConf2.setDate(this.metodos.getFechaActualPC());
        this.frmPersona.nuevo();
        mCrearTablaHisstorico();
        mCrearTablaR();
        this.frmPersona.requestFocus();
        setEnableContainer(this.JPIInicioC, false);
        this.xestadog = 1L;
    }

    public void mGrabar() {
        if (mValidarCampos()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO`f_co_atencion`(`Id_especialidad`, `Id_profecional`,Id_clasecita,`Id_persona`,`Fecha_atencion`,`Fecha_ingreso`,cie10P,cie10S,`Talla`,`Peso`,`Imc`,`Psistolica`,`Pdistolica`,`Fecha`,`UsuarioS`)VALUES ('" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xClaseCita[JCBClaseCita.getSelectedIndex()][0] + "','" + this.frmPersona.getIdPersona() + "','" + this.metodos.formatoAMD.format(this.JDFechaAtencion.getDate()) + "','" + this.metodos.formatoAMD.format(this.CBOFechaIngresoP.getDate()) + "','" + this.JTFCDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText() + "','" + this.JTFFPSentadoS.getText() + "','" + this.JTFFPSentadoD.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                this.xconsulta.cerrarConexionBd();
                String sql1 = "INSERT INTO f_co_cardiovascular(Id_atencion,`ConfirmadoHTA`,`Fecha_conf`,`CostosHTA`,`ConfirmadoDBT`,`Fecha_confdbt`,`CostosDBT`,`EtiologiaR`,clasificacion,`Medicamento1`,`Medicamento2`,EnfRenal,`Fecha`,`Usuarios`)VALUES ('" + Principal.txtNo.getText() + "','" + this.xconfirmardohta + "','" + this.metodos.formatoAMD.format(this.CBOFechaIngresoP.getDate()) + "','" + this.JTFCostosHTA.getText() + "','" + this.xconfirmadobt + "','" + this.metodos.formatoAMD.format(this.CBOFechaConf2.getDate()) + "','" + this.JTFCostosdbt.getText() + "','" + this.JTArenalcronica.getText() + "','" + this.JCBClasificacion.getSelectedItem() + "','" + this.xconfirmadolosartan + "','" + this.xconfirmadoenapril + "','" + this.xconfirmadorenal + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(sql1);
                this.xconsulta.cerrarConexionBd();
                mCargarHistorico(this.frmPersona.getIdPersona());
                setEnableContainer(this.JPresultado, true);
            }
        }
    }

    private boolean mValidarCampos() {
        boolean rs = false;
        if (this.frmPersona.getIdPersona() != "0") {
            if (Principal.txtNo.getText().isEmpty()) {
                if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                    if (this.JCBProfesional.getSelectedIndex() == -1) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tDebe seleccionar  un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBProfesional.requestFocus();
                    } else if (JCBClaseCita.getSelectedIndex() == -1) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tSeleccionar clase cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        JCBClaseCita.requestFocus();
                    } else if (Double.parseDouble(this.JTFFSPeso.getText().toString()) < 0.0d) {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tEl pesos no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSPeso.requestFocus();
                    } else if (Double.parseDouble(this.JTFFSTalla.getText().toString()) >= 0.0d) {
                        if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                            rs = true;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa codigo dx no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTP_Datos2.setSelectedIndex(1);
                            this.JTFNCodigoDxP.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "\t\t\tLa talla no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSTalla.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Especialidad no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBEspecialidad.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Este registro esta activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "No existe usuario activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
        }
        return rs;
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

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("") && Double.parseDouble(this.JTFFSPeso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFSPeso.getText());
        }
        return valor;
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && !this.JTFFSTalla.getText().equals("0") && Double.valueOf(this.JTFFSTalla.getText()).doubleValue() > 0.0d) {
            valor = Double.valueOf(this.JTFFSTalla.getText()).doubleValue();
        }
        return valor;
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

    public void mCargarHistorico(String xidp) {
        try {
            this.xsql = "SELECT `f_co_atencion`.`Id` , `f_co_atencion`.`Fecha_atencion` , `c_clasecita`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`\nFROM`f_co_atencion`INNER JOIN `baseserver`.`profesional1` ON (`f_co_atencion`.`Id_especialidad` = `profesional1`.`IdEspecialidad`) AND (`f_co_atencion`.`Id_profecional` = `profesional1`.`Id_Persona`)\nINNER JOIN `baseserver`.`persona`  ON (`f_co_atencion`.`Id_persona` = `persona`.`Id_persona`)INNER JOIN `baseserver`.`c_clasecita`ON (`f_co_atencion`.`Id_clasecita` = `c_clasecita`.`Id`)INNER JOIN `baseserver`.`f_co_cardiovascular`ON (`f_co_atencion`.`Id` = `f_co_cardiovascular`.`Id_atencion`)WHERE (`persona`.`Id_persona` ='" + xidp + "')ORDER BY `f_co_atencion`.`Id` DESC;";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    mCrearTablaHisstorico();
                    int x = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), x, 4);
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHisstorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Clase Cita", "Especialidad", "Profesional"}) { // from class: Facturacion.JIFRiesgoCardiovascular.36
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Exámen", "Resultado", "Es ingreso", "Observación"}) { // from class: Facturacion.JIFRiesgoCardiovascular.37
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTresultado.setModel(this.xmodeloR);
        this.JTresultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTresultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTresultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTresultado.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTresultado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTresultado.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTresultado.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTresultado.getColumnModel().getColumn(5).setPreferredWidth(150);
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

    private void mBuscarGuiasPatologias(String codigo) {
        try {
            String sql = "SELECT PathGuia FROM h_patologiaxguiamanejo WHERE (Id_Patologia ='" + codigo + "')";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int x = JOptionPane.showInternalConfirmDialog(this, "El código tiene una guia asociada \n\t\t Desea consultarla?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.metodos.mostrarPdf(xrs.getString(1));
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRiesgoObstetrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.frmPersona.buscar(3);
        mCargarHistorico(this.frmPersona.getIdPersona());
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

    private void mValidarCF() {
        setEnableContainer(this.JPresultado, false);
    }
}
