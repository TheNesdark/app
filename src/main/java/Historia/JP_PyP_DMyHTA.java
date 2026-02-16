package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JP_PyP_DMyHTA.class */
public class JP_PyP_DMyHTA extends JPanel {
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xclasificacionR;
    private String[] listaMotivoEgreso;
    private String xidUsuarioPersona;
    private String xnombre;
    private Object[] xdatos;
    private String[] xidactivadf;
    private String[] xidcalcohol;
    private String[] xidnutricion;
    private String[] xidmplanifica;
    private String[] xidprocedimiento;
    private ButtonGroup JBGHta_TipoDx;
    private ButtonGroup JBGI_TipoDx;
    private ButtonGroup JBGNuevo;
    private ButtonGroup JBGRenal;
    private ButtonGroup JBGTipoD;
    private ButtonGroup JBGTipoDxRenal;
    private JButton JBTGuardar;
    private JComboBox JCBClasfCardiovascular;
    private JComboBox JCBHta_ClasificacionR;
    private JComboBox JCBHta_Estadio;
    private JComboBox JCBI_ClasificacionR;
    private JComboBox JCBI_Tipo_Diabetes;
    private JComboBox JCBI_Tipo_Insulina;
    private JComboBox JCBMotEgreso;
    private JComboBox JCBO_Alcohol;
    private JComboBox JCBO_CActividadF;
    private JComboBox JCBO_Nutricion;
    private JComboBox JCBO_PRealizado;
    private JComboBox JCBO_Planificacion;
    private JComboBox JCBR_ClasificacionEstadio;
    private JCheckBox JCHO_EnfCoronaria;
    private JCheckBox JCHR_Aplica;
    public JDateChooser JDFechaEgreso;
    private JDateChooser JDHta_FechaDx;
    private JDateChooser JDIFecha;
    private JDateChooser JDIFechaDx;
    private JDateChooser JDO_Fecha;
    private JDateChooser JDR_FEcografia;
    private JDateChooser JDR_FMicroAlbumina;
    private JDateChooser JDR_FPOrina;
    private JDateChooser JDR_FProteinas;
    private JDateChooser JDR_FREnfermedad;
    private JDateChooser JDR_FechaDx;
    private JLabel JLBO_Clasificacion;
    private JLabel JLBPBSentado;
    private JLabel JLIdIngresoPrograma;
    private JPanel JPESignosVitales;
    private JPanel JPI;
    private JPanel JPIDHta;
    private JPanel JPIDIngreso;
    private JPanel JPIDObesidad;
    private JPanel JPIEgreso;
    private JPanel JPIExamenF;
    private JPanel JPIHta_TipoDx;
    private JPanel JPIITipo_Dx;
    private JPanel JPIITipo_Dx1;
    private JPanel JPINefroproteccion;
    private JPanel JPIOMedicamento;
    private JPanel JPIOtrosD;
    private JPanel JPIPresion;
    private JPanel JPIR_AyudasDx;
    private JPanel JPIR_TipoDx;
    private JPanel JPIngreso;
    private JRadioButton JRBHta_Conocido;
    private JRadioButton JRBHta_NoAplica;
    private JRadioButton JRBHta_Nuevo;
    private JRadioButton JRBI_TDx_Conocido;
    private JRadioButton JRBI_TDx_Nuevo;
    private JRadioButton JRBNoesNuevoP;
    private JRadioButton JRBO_NoM;
    private JRadioButton JRBO_SiM;
    private JRadioButton JRBR_Conocido;
    private JRadioButton JRBR_NoAplica;
    private JRadioButton JRBR_Nuevo;
    private JRadioButton JRBSiesNuevoP;
    private JScrollPane JSPEObservacion;
    private JScrollPane JSPO_Medicamentos;
    private JTable JTDetalle;
    public JTextFieldValidator JTFFE_IMC;
    public JTextFieldValidator JTFFE_PAbdominal;
    private JFormattedTextField JTFFE_PDiastolica;
    private JFormattedTextField JTFFE_PSistolica;
    public JTextFieldValidator JTFFE_Peso;
    public JTextFieldValidator JTFFE_Talla;
    public JTextFieldValidator JTFFO_CDia;
    public JTextFieldValidator JTFFO_NAnosF;
    private JFormattedTextField JTFFR_VMicroalbumina;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosE;
    private JTextArea JTPEFObsEgresos;
    private JTextArea JTPEFObservaciones;
    private JTextArea JTPO_Medicamentos;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xesingreso = 0;
    private int xesnuevo = 1;
    private boolean xlleno = false;
    public double xsemEmbarazo = 0.0d;
    private long xtipodiabetes = 0;
    private long xhipertenso = 0;
    String xi_fecha = "NULL";
    private int xi_tipodx = -1;
    private int xhta = 0;
    private int xhta_tipodx = -1;
    private String xhta_fecha = "NULL";
    private String xhta_clasificacionr = "";
    private String xr_fecha = "NULL";
    private String xr_cestadio = "";
    private String xr_fecha_proteinas = "NULL";
    private String xr_fecha_orina = "NULL";
    private String xr_fecha_microalbumina = "NULL";
    private String xr_fecha_Ecografia = "NULL";
    private String xr_fecha_REnfermedad = "NULL";
    private double xr_valor_microalbumina = 0.0d;
    private int xr_tipodx = -1;
    private String xemfcoronaria = "NO";
    private String xrmedicamento = "";

    public JP_PyP_DMyHTA(String nombre) {
        initComponents();
        mNuevo();
        mIniciarComponentes();
        mConsultarUserProgram();
        mBuscarDatosUserProgram();
        mBuscarDatosUserProgramEgreso();
        this.xnombre = nombre;
        if (nombre.equals("ingreso")) {
            this.JTPDatos.setSelectedIndex(0);
            this.JTPDatos.remove(1);
        } else {
            this.JTPDatos.setSelectedIndex(1);
            this.JTPDatos.remove(0);
        }
    }

    private void initComponents() {
        this.JBGI_TipoDx = new ButtonGroup();
        this.JBGTipoD = new ButtonGroup();
        this.JBGRenal = new ButtonGroup();
        this.JBGTipoDxRenal = new ButtonGroup();
        this.JBGHta_TipoDx = new ButtonGroup();
        this.JBGNuevo = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIngreso = new JPanel();
        this.JPIDHta = new JPanel();
        this.JDHta_FechaDx = new JDateChooser();
        this.JPIHta_TipoDx = new JPanel();
        this.JRBHta_NoAplica = new JRadioButton();
        this.JRBHta_Nuevo = new JRadioButton();
        this.JRBHta_Conocido = new JRadioButton();
        this.JCBHta_ClasificacionR = new JComboBox();
        this.JCBHta_Estadio = new JComboBox();
        this.JPIDIngreso = new JPanel();
        this.JDIFecha = new JDateChooser();
        this.JDIFechaDx = new JDateChooser();
        this.JPIITipo_Dx = new JPanel();
        this.JRBI_TDx_Nuevo = new JRadioButton();
        this.JRBI_TDx_Conocido = new JRadioButton();
        this.JCBI_ClasificacionR = new JComboBox();
        this.JCBI_Tipo_Diabetes = new JComboBox();
        this.JCBI_Tipo_Insulina = new JComboBox();
        this.JPIITipo_Dx1 = new JPanel();
        this.JRBSiesNuevoP = new JRadioButton();
        this.JRBNoesNuevoP = new JRadioButton();
        this.JCBClasfCardiovascular = new JComboBox();
        this.JTPDatosE = new JTabbedPane();
        this.JPIExamenF = new JPanel();
        this.JSPEObservacion = new JScrollPane();
        this.JTPEFObservaciones = new JTextArea();
        this.JPIPresion = new JPanel();
        this.JTFFE_PSistolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JTFFE_PDiastolica = new JFormattedTextField();
        this.JPESignosVitales = new JPanel();
        this.JTFFE_PAbdominal = new JTextFieldValidator();
        this.JTFFE_Talla = new JTextFieldValidator();
        this.JTFFE_Peso = new JTextFieldValidator();
        this.JTFFE_IMC = new JTextFieldValidator();
        this.JPINefroproteccion = new JPanel();
        this.JCHR_Aplica = new JCheckBox();
        this.JDR_FechaDx = new JDateChooser();
        this.JCBR_ClasificacionEstadio = new JComboBox();
        this.JPIR_TipoDx = new JPanel();
        this.JRBR_NoAplica = new JRadioButton();
        this.JRBR_Nuevo = new JRadioButton();
        this.JRBR_Conocido = new JRadioButton();
        this.JPIR_AyudasDx = new JPanel();
        this.JDR_FProteinas = new JDateChooser();
        this.JDR_FPOrina = new JDateChooser();
        this.JDR_FMicroAlbumina = new JDateChooser();
        this.JTFFR_VMicroalbumina = new JFormattedTextField();
        this.JDR_FEcografia = new JDateChooser();
        this.JDR_FREnfermedad = new JDateChooser();
        this.JPIOtrosD = new JPanel();
        this.JCBO_CActividadF = new JComboBox();
        this.JCBO_Alcohol = new JComboBox();
        this.JCBO_Nutricion = new JComboBox();
        this.JPI = new JPanel();
        this.JTFFO_CDia = new JTextFieldValidator();
        this.JTFFO_NAnosF = new JTextFieldValidator();
        this.JLBO_Clasificacion = new JLabel();
        this.JCBO_Planificacion = new JComboBox();
        this.JCHO_EnfCoronaria = new JCheckBox();
        this.JPIDObesidad = new JPanel();
        this.JDO_Fecha = new JDateChooser();
        this.JCBO_PRealizado = new JComboBox();
        this.JPIOMedicamento = new JPanel();
        this.JRBO_SiM = new JRadioButton();
        this.JRBO_NoM = new JRadioButton();
        this.JSPO_Medicamentos = new JScrollPane();
        this.JTPO_Medicamentos = new JTextArea();
        this.JPIEgreso = new JPanel();
        this.JDFechaEgreso = new JDateChooser();
        this.JCBMotEgreso = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTPEFObsEgresos = new JTextArea();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardar = new JButton();
        this.JLIdIngresoPrograma = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jp_pyp_htaydm");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIDHta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS HIPERTENSIÓN", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JDHta_FechaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Dx HTA", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDHta_FechaDx.setDateFormatString("dd/MM/yyyy");
        this.JDHta_FechaDx.setFont(new Font("Arial", 1, 12));
        this.JDHta_FechaDx.setMaxSelectableDate(new Date(253370786508000L));
        this.JDHta_FechaDx.setMinSelectableDate(new Date(-62135747892000L));
        this.JDHta_FechaDx.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDHta_FechaDxPropertyChange(evt);
            }
        });
        this.JPIHta_TipoDx.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGHta_TipoDx.add(this.JRBHta_NoAplica);
        this.JRBHta_NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBHta_NoAplica.setSelected(true);
        this.JRBHta_NoAplica.setText("No Aplica");
        this.JRBHta_NoAplica.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.2
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBHta_NoAplicaActionPerformed(evt);
            }
        });
        this.JBGHta_TipoDx.add(this.JRBHta_Nuevo);
        this.JRBHta_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JRBHta_Nuevo.setText("Nuevo");
        this.JRBHta_Nuevo.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.3
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBHta_NuevoActionPerformed(evt);
            }
        });
        this.JBGHta_TipoDx.add(this.JRBHta_Conocido);
        this.JRBHta_Conocido.setFont(new Font("Arial", 1, 12));
        this.JRBHta_Conocido.setText("Conocido");
        this.JRBHta_Conocido.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.4
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBHta_ConocidoActionPerformed(evt);
            }
        });
        GroupLayout JPIHta_TipoDxLayout = new GroupLayout(this.JPIHta_TipoDx);
        this.JPIHta_TipoDx.setLayout(JPIHta_TipoDxLayout);
        JPIHta_TipoDxLayout.setHorizontalGroup(JPIHta_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHta_TipoDxLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPIHta_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBHta_NoAplica, -2, 81, -2).addComponent(this.JRBHta_Nuevo).addComponent(this.JRBHta_Conocido)).addContainerGap(-1, 32767)));
        JPIHta_TipoDxLayout.setVerticalGroup(JPIHta_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHta_TipoDxLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.JRBHta_NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBHta_Nuevo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBHta_Conocido).addContainerGap(-1, 32767)));
        this.JCBHta_ClasificacionR.setFont(new Font("Arial", 1, 12));
        this.JCBHta_ClasificacionR.setModel(new DefaultComboBoxModel(new String[]{" ", "Bajo", "Moderado", "Alto"}));
        this.JCBHta_ClasificacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHta_ClasificacionR.addItemListener(new ItemListener() { // from class: Historia.JP_PyP_DMyHTA.5
            public void itemStateChanged(ItemEvent evt) {
                JP_PyP_DMyHTA.this.JCBHta_ClasificacionRItemStateChanged(evt);
            }
        });
        this.JCBHta_Estadio.setFont(new Font("Arial", 1, 12));
        this.JCBHta_Estadio.setModel(new DefaultComboBoxModel(new String[]{"", "Estadio 1", "Estadio 2", "Estadio 3", "Estadio 4", "Estadio 5"}));
        this.JCBHta_Estadio.setBorder(BorderFactory.createTitledBorder((Border) null, "Estadio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHta_Estadio.addItemListener(new ItemListener() { // from class: Historia.JP_PyP_DMyHTA.6
            public void itemStateChanged(ItemEvent evt) {
                JP_PyP_DMyHTA.this.JCBHta_EstadioItemStateChanged(evt);
            }
        });
        GroupLayout JPIDHtaLayout = new GroupLayout(this.JPIDHta);
        this.JPIDHta.setLayout(JPIDHtaLayout);
        JPIDHtaLayout.setHorizontalGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHtaLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBHta_Estadio, -2, 158, -2).addComponent(this.JCBHta_ClasificacionR, 0, -1, 32767).addComponent(this.JDHta_FechaDx, -1, 159, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIHta_TipoDx, -2, 93, -2)));
        JPIDHtaLayout.setVerticalGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHtaLayout.createSequentialGroup().addGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHtaLayout.createSequentialGroup().addComponent(this.JDHta_FechaDx, -2, 51, -2).addGap(3, 3, 3).addComponent(this.JCBHta_ClasificacionR, -2, 51, -2).addGap(5, 5, 5).addComponent(this.JCBHta_Estadio, -2, 51, -2)).addGroup(JPIDHtaLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JPIHta_TipoDx, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JPIDIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DIABETES", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JDIFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso al Programa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDIFecha.setToolTipText("Fecha Ingreso al Programa");
        this.JDIFecha.setDateFormatString("dd/MM/yyyy");
        this.JDIFecha.setFont(new Font("Arial", 1, 12));
        this.JDIFechaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Dx DM", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDIFechaDx.setDateFormatString("dd/MM/yyyy");
        this.JDIFechaDx.setFont(new Font("Arial", 1, 12));
        this.JDIFechaDx.setMaxSelectableDate(new Date(253370786508000L));
        this.JDIFechaDx.setMinSelectableDate(new Date(-62135747892000L));
        this.JDIFechaDx.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDIFechaDxPropertyChange(evt);
            }
        });
        this.JPIITipo_Dx.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGI_TipoDx.add(this.JRBI_TDx_Nuevo);
        this.JRBI_TDx_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JRBI_TDx_Nuevo.setSelected(true);
        this.JRBI_TDx_Nuevo.setText("Nuevo");
        this.JRBI_TDx_Nuevo.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.8
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBI_TDx_NuevoActionPerformed(evt);
            }
        });
        this.JBGI_TipoDx.add(this.JRBI_TDx_Conocido);
        this.JRBI_TDx_Conocido.setFont(new Font("Arial", 1, 12));
        this.JRBI_TDx_Conocido.setText("Conocido");
        this.JRBI_TDx_Conocido.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.9
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBI_TDx_ConocidoActionPerformed(evt);
            }
        });
        GroupLayout JPIITipo_DxLayout = new GroupLayout(this.JPIITipo_Dx);
        this.JPIITipo_Dx.setLayout(JPIITipo_DxLayout);
        JPIITipo_DxLayout.setHorizontalGroup(JPIITipo_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIITipo_DxLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBI_TDx_Nuevo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBI_TDx_Conocido)));
        JPIITipo_DxLayout.setVerticalGroup(JPIITipo_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIITipo_DxLayout.createSequentialGroup().addGroup(JPIITipo_DxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBI_TDx_Conocido).addComponent(this.JRBI_TDx_Nuevo)).addContainerGap(10, 32767)));
        this.JCBI_ClasificacionR.setFont(new Font("Arial", 1, 12));
        this.JCBI_ClasificacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBI_Tipo_Diabetes.setFont(new Font("Arial", 1, 12));
        this.JCBI_Tipo_Diabetes.setModel(new DefaultComboBoxModel(new String[]{" ", "Tipo I", "Tipo II", "Tipo II -  Insulinorequiriente", " "}));
        this.JCBI_Tipo_Diabetes.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Diabetes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBI_Tipo_Insulina.setFont(new Font("Arial", 1, 12));
        this.JCBI_Tipo_Insulina.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Análoga", "Convencional"}));
        this.JCBI_Tipo_Insulina.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Insulina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIITipo_Dx1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Es Nuevo?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGNuevo.add(this.JRBSiesNuevoP);
        this.JRBSiesNuevoP.setFont(new Font("Arial", 1, 12));
        this.JRBSiesNuevoP.setSelected(true);
        this.JRBSiesNuevoP.setText("Si");
        this.JRBSiesNuevoP.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.10
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBSiesNuevoPActionPerformed(evt);
            }
        });
        this.JBGNuevo.add(this.JRBNoesNuevoP);
        this.JRBNoesNuevoP.setFont(new Font("Arial", 1, 12));
        this.JRBNoesNuevoP.setText("No");
        this.JRBNoesNuevoP.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.11
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBNoesNuevoPActionPerformed(evt);
            }
        });
        GroupLayout JPIITipo_Dx1Layout = new GroupLayout(this.JPIITipo_Dx1);
        this.JPIITipo_Dx1.setLayout(JPIITipo_Dx1Layout);
        JPIITipo_Dx1Layout.setHorizontalGroup(JPIITipo_Dx1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIITipo_Dx1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JRBSiesNuevoP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoesNuevoP)));
        JPIITipo_Dx1Layout.setVerticalGroup(JPIITipo_Dx1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIITipo_Dx1Layout.createSequentialGroup().addGroup(JPIITipo_Dx1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNoesNuevoP).addComponent(this.JRBSiesNuevoP)).addContainerGap(10, 32767)));
        this.JCBClasfCardiovascular.setFont(new Font("Arial", 1, 12));
        this.JCBClasfCardiovascular.setModel(new DefaultComboBoxModel(new String[]{" ", "Bajo", "Moderado", "Alto", "Muy Alto"}));
        this.JCBClasfCardiovascular.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación riesgo Cardiovascular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasfCardiovascular.addItemListener(new ItemListener() { // from class: Historia.JP_PyP_DMyHTA.12
            public void itemStateChanged(ItemEvent evt) {
                JP_PyP_DMyHTA.this.JCBClasfCardiovascularItemStateChanged(evt);
            }
        });
        GroupLayout JPIDIngresoLayout = new GroupLayout(this.JPIDIngreso);
        this.JPIDIngreso.setLayout(JPIDIngresoLayout);
        JPIDIngresoLayout.setHorizontalGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDIngresoLayout.createSequentialGroup().addComponent(this.JDIFechaDx, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBI_ClasificacionR, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBI_Tipo_Insulina, 0, 176, 32767).addGap(25, 25, 25)).addGroup(JPIDIngresoLayout.createSequentialGroup().addComponent(this.JCBClasfCardiovascular, -2, 302, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDIngresoLayout.createSequentialGroup().addComponent(this.JDIFecha, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIITipo_Dx1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIITipo_Dx, -2, -1, -2).addGap(0, 0, 0).addComponent(this.JCBI_Tipo_Diabetes, -2, 120, -2)));
        JPIDIngresoLayout.setVerticalGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDIngresoLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDIFecha, -2, 50, -2).addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIITipo_Dx, -2, -1, -2).addComponent(this.JCBI_Tipo_Diabetes, -2, 51, -2)).addGroup(JPIDIngresoLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JPIITipo_Dx1, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDIFechaDx, -2, 51, -2).addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBI_Tipo_Insulina, -2, 51, -2).addComponent(this.JCBI_ClasificacionR, -2, 51, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBClasfCardiovascular, -2, 51, -2)));
        this.JTPDatosE.setForeground(Color.red);
        this.JTPDatosE.setFont(new Font("Arial", 1, 12));
        this.JSPEObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPEFObservaciones.setColumns(1);
        this.JTPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.setLineWrap(true);
        this.JTPEFObservaciones.setRows(1);
        this.JTPEFObservaciones.setTabSize(1);
        this.JTPEFObservaciones.setBorder((Border) null);
        this.JSPEObservacion.setViewportView(this.JTPEFObservaciones);
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFE_PSistolica.setHorizontalAlignment(4);
        this.JTFFE_PSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFE_PSistolica.setName("fechanaciemiento");
        this.JTFFE_PSistolica.setValue(new Integer(0));
        this.JTFFE_PSistolica.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.13
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PSistolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PSistolicaFocusLost(evt);
            }
        });
        this.JTFFE_PSistolica.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.14
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PSistolicaActionPerformed(evt);
            }
        });
        this.JTFFE_PSistolica.addKeyListener(new KeyAdapter() { // from class: Historia.JP_PyP_DMyHTA.15
            public void keyTyped(KeyEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PSistolicaKeyTyped(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JTFFE_PDiastolica.setHorizontalAlignment(4);
        this.JTFFE_PDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFE_PDiastolica.setName("fechanaciemiento");
        this.JTFFE_PDiastolica.setValue(new Integer(0));
        this.JTFFE_PDiastolica.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.16
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PDiastolicaFocusGained(evt);
            }
        });
        this.JTFFE_PDiastolica.addKeyListener(new KeyAdapter() { // from class: Historia.JP_PyP_DMyHTA.17
            public void keyTyped(KeyEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PDiastolicaKeyTyped(evt);
            }
        });
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFE_PSistolica, -2, 60, -2).addGap(7, 7, 7).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFE_PDiastolica, -2, 60, -2).addContainerGap(27, 32767)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFE_PSistolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFE_PDiastolica, -2, 25, -2)).addGap(0, 3, 32767)));
        this.JPESignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFE_PAbdominal.setBorder(BorderFactory.createTitledBorder((Border) null, "P.Abdominal (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_PAbdominal.setHorizontalAlignment(0);
        this.JTFFE_PAbdominal.setText("0");
        this.JTFFE_PAbdominal.setToolTipText("Perímetro Abdominal");
        this.JTFFE_PAbdominal.setExprecionRegular("^[1-9]\\d?\\d?$");
        this.JTFFE_PAbdominal.setFocusAccelerator('C');
        this.JTFFE_PAbdominal.setFont(new Font("Arial", 1, 12));
        this.JTFFE_PAbdominal.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.18
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PAbdominalFocusGained(evt);
            }
        });
        this.JTFFE_PAbdominal.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.19
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PAbdominalActionPerformed(evt);
            }
        });
        this.JTFFE_PAbdominal.addKeyListener(new KeyAdapter() { // from class: Historia.JP_PyP_DMyHTA.20
            public void keyTyped(KeyEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PAbdominalKeyTyped(evt);
            }
        });
        this.JTFFE_Talla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Talla.setHorizontalAlignment(0);
        this.JTFFE_Talla.setText("0");
        this.JTFFE_Talla.setToolTipText("Talla en Centimetros");
        this.JTFFE_Talla.setExprecionRegular("^[1-9]\\d?\\d?$");
        this.JTFFE_Talla.setFocusAccelerator('C');
        this.JTFFE_Talla.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Talla.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.21
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_TallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_TallaFocusLost(evt);
            }
        });
        this.JTFFE_Talla.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.22
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_TallaActionPerformed(evt);
            }
        });
        this.JTFFE_Talla.addKeyListener(new KeyAdapter() { // from class: Historia.JP_PyP_DMyHTA.23
            public void keyTyped(KeyEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_TallaKeyTyped(evt);
            }
        });
        this.JTFFE_Peso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Peso.setHorizontalAlignment(0);
        this.JTFFE_Peso.setText("0");
        this.JTFFE_Peso.setToolTipText("Peso en Kilogramos");
        this.JTFFE_Peso.setExprecionRegular("^[1-9]\\d?\\d?$");
        this.JTFFE_Peso.setFocusAccelerator('C');
        this.JTFFE_Peso.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Peso.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.24
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PesoFocusLost(evt);
            }
        });
        this.JTFFE_Peso.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.25
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PesoActionPerformed(evt);
            }
        });
        this.JTFFE_Peso.addKeyListener(new KeyAdapter() { // from class: Historia.JP_PyP_DMyHTA.26
            public void keyTyped(KeyEvent evt) {
                JP_PyP_DMyHTA.this.JTFFE_PesoKeyTyped(evt);
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
        JPESignosVitalesLayout.setHorizontalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFE_PAbdominal, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFE_Talla, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_Peso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_IMC, -2, 100, -2).addContainerGap()));
        JPESignosVitalesLayout.setVerticalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFE_PAbdominal, -2, 50, -2).addComponent(this.JTFFE_Talla, -2, 50, -2)).addComponent(this.JTFFE_Peso, -2, 50, -2).addComponent(this.JTFFE_IMC, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIExamenFLayout = new GroupLayout(this.JPIExamenF);
        this.JPIExamenF.setLayout(JPIExamenFLayout);
        JPIExamenFLayout.setHorizontalGroup(JPIExamenFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFLayout.createSequentialGroup().addContainerGap().addGroup(JPIExamenFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPEObservacion).addGroup(JPIExamenFLayout.createSequentialGroup().addComponent(this.JPIPresion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPESignosVitales, -2, -1, -2))).addContainerGap(102, 32767)));
        JPIExamenFLayout.setVerticalGroup(JPIExamenFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIExamenFLayout.createSequentialGroup().addContainerGap().addGroup(JPIExamenFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPresion, -2, -1, -2).addComponent(this.JPESignosVitales, -2, 85, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEObservacion, -2, 73, -2).addContainerGap(-1, 32767)));
        this.JTPDatosE.addTab("EXÁMEN FÍSICO", this.JPIExamenF);
        this.JPINefroproteccion.setBorder(BorderFactory.createEtchedBorder());
        this.JCHR_Aplica.setFont(new Font("Arial", 1, 12));
        this.JCHR_Aplica.setText("Aplica?");
        this.JCHR_Aplica.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.27
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JCHR_AplicaActionPerformed(evt);
            }
        });
        this.JDR_FechaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FechaDx.setDateFormatString("dd/MM/yyyy");
        this.JDR_FechaDx.setFont(new Font("Arial", 1, 12));
        this.JDR_FechaDx.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.28
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FechaDxPropertyChange(evt);
            }
        });
        this.JCBR_ClasificacionEstadio.setFont(new Font("Arial", 1, 12));
        this.JCBR_ClasificacionEstadio.setModel(new DefaultComboBoxModel(new String[]{" ", "Estadío 1", "Estadío 2", "Estadío 3", "Estadío 4", "Estadío 5"}));
        this.JCBR_ClasificacionEstadio.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Estadío", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBR_ClasificacionEstadio.addItemListener(new ItemListener() { // from class: Historia.JP_PyP_DMyHTA.29
            public void itemStateChanged(ItemEvent evt) {
                JP_PyP_DMyHTA.this.JCBR_ClasificacionEstadioItemStateChanged(evt);
            }
        });
        this.JPIR_TipoDx.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoDxRenal.add(this.JRBR_NoAplica);
        this.JRBR_NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBR_NoAplica.setSelected(true);
        this.JRBR_NoAplica.setText("No Aplica");
        this.JRBR_NoAplica.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.30
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBR_NoAplicaActionPerformed(evt);
            }
        });
        this.JBGTipoDxRenal.add(this.JRBR_Nuevo);
        this.JRBR_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JRBR_Nuevo.setText("Nuevo");
        this.JRBR_Nuevo.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.31
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBR_NuevoActionPerformed(evt);
            }
        });
        this.JBGTipoDxRenal.add(this.JRBR_Conocido);
        this.JRBR_Conocido.setFont(new Font("Arial", 1, 12));
        this.JRBR_Conocido.setText("Conocido");
        this.JRBR_Conocido.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.32
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBR_ConocidoActionPerformed(evt);
            }
        });
        GroupLayout JPIR_TipoDxLayout = new GroupLayout(this.JPIR_TipoDx);
        this.JPIR_TipoDx.setLayout(JPIR_TipoDxLayout);
        JPIR_TipoDxLayout.setHorizontalGroup(JPIR_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIR_TipoDxLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBR_NoAplica, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBR_Nuevo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBR_Conocido)));
        JPIR_TipoDxLayout.setVerticalGroup(JPIR_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIR_TipoDxLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPIR_TipoDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBR_Nuevo).addComponent(this.JRBR_NoAplica).addComponent(this.JRBR_Conocido)).addContainerGap(-1, 32767)));
        this.JPIR_AyudasDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Ayudas Diagnósticas", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDR_FProteinas.setBorder(BorderFactory.createTitledBorder((Border) null, "Proteinas 24H", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FProteinas.setToolTipText("Fecha Proteinas en 24 Horas");
        this.JDR_FProteinas.setDateFormatString("dd/MM/yyyy");
        this.JDR_FProteinas.setFont(new Font("Arial", 1, 12));
        this.JDR_FProteinas.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.33
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FProteinasPropertyChange(evt);
            }
        });
        this.JDR_FPOrina.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Orina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FPOrina.setToolTipText("Fecha Parcial Orina");
        this.JDR_FPOrina.setDateFormatString("dd/MM/yyyy");
        this.JDR_FPOrina.setFont(new Font("Arial", 1, 12));
        this.JDR_FPOrina.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.34
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FPOrinaPropertyChange(evt);
            }
        });
        this.JDR_FMicroAlbumina.setBorder(BorderFactory.createTitledBorder((Border) null, "MicroAlbumina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FMicroAlbumina.setToolTipText("Fecha MicroAlbumina");
        this.JDR_FMicroAlbumina.setDateFormatString("dd/MM/yyyy");
        this.JDR_FMicroAlbumina.setFont(new Font("Arial", 1, 12));
        this.JDR_FMicroAlbumina.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.35
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FMicroAlbuminaPropertyChange(evt);
            }
        });
        this.JTFFR_VMicroalbumina.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Microalbumina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFR_VMicroalbumina.setHorizontalAlignment(4);
        this.JTFFR_VMicroalbumina.setToolTipText("Valor MicroAlbumina");
        this.JTFFR_VMicroalbumina.setFont(new Font("Arial", 1, 12));
        this.JDR_FEcografia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ecografía", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FEcografia.setToolTipText("Fecha Ecografía Renal");
        this.JDR_FEcografia.setDateFormatString("dd/MM/yyyy");
        this.JDR_FEcografia.setFont(new Font("Arial", 1, 12));
        this.JDR_FEcografia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.36
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FEcografiaPropertyChange(evt);
            }
        });
        this.JDR_FREnfermedad.setBorder(BorderFactory.createTitledBorder((Border) null, "R.Enfermedad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDR_FREnfermedad.setToolTipText("Regresion de la Enfermedad");
        this.JDR_FREnfermedad.setDateFormatString("dd/MM/yyyy");
        this.JDR_FREnfermedad.setFont(new Font("Arial", 1, 12));
        this.JDR_FREnfermedad.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JP_PyP_DMyHTA.37
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_PyP_DMyHTA.this.JDR_FREnfermedadPropertyChange(evt);
            }
        });
        GroupLayout JPIR_AyudasDxLayout = new GroupLayout(this.JPIR_AyudasDx);
        this.JPIR_AyudasDx.setLayout(JPIR_AyudasDxLayout);
        JPIR_AyudasDxLayout.setHorizontalGroup(JPIR_AyudasDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIR_AyudasDxLayout.createSequentialGroup().addContainerGap().addComponent(this.JDR_FProteinas, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDR_FPOrina, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDR_FMicroAlbumina, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFR_VMicroalbumina, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JDR_FEcografia, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDR_FREnfermedad, -2, 110, -2).addContainerGap(29, 32767)));
        JPIR_AyudasDxLayout.setVerticalGroup(JPIR_AyudasDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIR_AyudasDxLayout.createSequentialGroup().addGroup(JPIR_AyudasDxLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIR_AyudasDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDR_FEcografia, -2, 50, -2).addComponent(this.JDR_FREnfermedad, -2, 50, -2)).addComponent(this.JTFFR_VMicroalbumina, -2, 50, -2).addGroup(JPIR_AyudasDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDR_FProteinas, -2, 50, -2).addComponent(this.JDR_FPOrina, -2, 50, -2).addComponent(this.JDR_FMicroAlbumina, -2, 50, -2))).addGap(0, 15, 32767)));
        GroupLayout JPINefroproteccionLayout = new GroupLayout(this.JPINefroproteccion);
        this.JPINefroproteccion.setLayout(JPINefroproteccionLayout);
        JPINefroproteccionLayout.setHorizontalGroup(JPINefroproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINefroproteccionLayout.createSequentialGroup().addContainerGap().addGroup(JPINefroproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINefroproteccionLayout.createSequentialGroup().addComponent(this.JPIR_AyudasDx, -1, -1, 32767).addContainerGap()).addGroup(JPINefroproteccionLayout.createSequentialGroup().addComponent(this.JCHR_Aplica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDR_FechaDx, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBR_ClasificacionEstadio, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIR_TipoDx, -2, -1, -2).addGap(0, 0, 32767)))));
        JPINefroproteccionLayout.setVerticalGroup(JPINefroproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINefroproteccionLayout.createSequentialGroup().addContainerGap().addGroup(JPINefroproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHR_Aplica).addComponent(this.JCBR_ClasificacionEstadio).addComponent(this.JDR_FechaDx, -1, 50, 32767).addComponent(this.JPIR_TipoDx, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JPIR_AyudasDx, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosE.addTab("DATOS NEFROPROTECCIÓN", this.JPINefroproteccion);
        this.JCBO_CActividadF.setFont(new Font("Arial", 1, 12));
        this.JCBO_CActividadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad Física", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBO_Alcohol.setFont(new Font("Arial", 1, 12));
        this.JCBO_Alcohol.setBorder(BorderFactory.createTitledBorder((Border) null, "Consumo Alcohol", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBO_Nutricion.setFont(new Font("Arial", 1, 12));
        this.JCBO_Nutricion.setBorder(BorderFactory.createTitledBorder((Border) null, "Nutrición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI.setBorder(BorderFactory.createTitledBorder((Border) null, "Tabaquimos (N° Paquetes Año)", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFO_CDia.setBorder(BorderFactory.createTitledBorder((Border) null, "CCigarrilloxDía", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFO_CDia.setHorizontalAlignment(0);
        this.JTFFO_CDia.setText("0");
        this.JTFFO_CDia.setToolTipText("Cantidad de Cigarrillo Día");
        this.JTFFO_CDia.setExprecionRegular("^[0-9]*$");
        this.JTFFO_CDia.setFocusAccelerator('C');
        this.JTFFO_CDia.setFont(new Font("Arial", 1, 12));
        this.JTFFO_CDia.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.38
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFO_CDiaActionPerformed(evt);
            }
        });
        this.JTFFO_CDia.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.39
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFO_CDiaFocusGained(evt);
            }
        });
        this.JTFFO_NAnosF.setBorder(BorderFactory.createTitledBorder((Border) null, "Años Fumador", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFO_NAnosF.setHorizontalAlignment(0);
        this.JTFFO_NAnosF.setText("0");
        this.JTFFO_NAnosF.setToolTipText("Años de fumador");
        this.JTFFO_NAnosF.setExprecionRegular("^[0-9]*$");
        this.JTFFO_NAnosF.setFocusAccelerator('C');
        this.JTFFO_NAnosF.setFont(new Font("Arial", 1, 12));
        this.JTFFO_NAnosF.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.40
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JTFFO_NAnosFActionPerformed(evt);
            }
        });
        this.JTFFO_NAnosF.addFocusListener(new FocusAdapter() { // from class: Historia.JP_PyP_DMyHTA.41
            public void focusGained(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFO_NAnosFFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JP_PyP_DMyHTA.this.JTFFO_NAnosFFocusLost(evt);
            }
        });
        this.JLBO_Clasificacion.setFont(new Font("Arial", 1, 18));
        this.JLBO_Clasificacion.setHorizontalAlignment(0);
        this.JLBO_Clasificacion.setText("NO APLICA");
        this.JLBO_Clasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Paquetes Año", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPILayout = new GroupLayout(this.JPI);
        this.JPI.setLayout(JPILayout);
        JPILayout.setHorizontalGroup(JPILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPILayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFO_CDia, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFO_NAnosF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBO_Clasificacion, -1, 122, 32767).addContainerGap()));
        JPILayout.setVerticalGroup(JPILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPILayout.createSequentialGroup().addContainerGap().addGroup(JPILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPILayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFO_CDia, -2, 50, -2).addComponent(this.JTFFO_NAnosF, -2, 50, -2))).addComponent(this.JLBO_Clasificacion, -1, -1, 32767)).addContainerGap()));
        this.JCBO_Planificacion.setFont(new Font("Arial", 1, 12));
        this.JCBO_Planificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Metodo de Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHO_EnfCoronaria.setFont(new Font("Arial", 1, 12));
        this.JCHO_EnfCoronaria.setText("Antecedente familiar de coronariopatía?");
        this.JCHO_EnfCoronaria.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.42
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JCHO_EnfCoronariaActionPerformed(evt);
            }
        });
        GroupLayout JPIOtrosDLayout = new GroupLayout(this.JPIOtrosD);
        this.JPIOtrosD.setLayout(JPIOtrosDLayout);
        JPIOtrosDLayout.setHorizontalGroup(JPIOtrosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosDLayout.createSequentialGroup().addContainerGap().addGroup(JPIOtrosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosDLayout.createSequentialGroup().addComponent(this.JPI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHO_EnfCoronaria).addGap(0, 0, 32767)).addGroup(JPIOtrosDLayout.createSequentialGroup().addComponent(this.JCBO_CActividadF, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBO_Alcohol, -2, 190, -2).addGap(18, 18, 18).addComponent(this.JCBO_Nutricion, -2, 189, -2).addGap(18, 18, 18).addComponent(this.JCBO_Planificacion, -2, 189, -2))).addContainerGap()));
        JPIOtrosDLayout.setVerticalGroup(JPIOtrosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosDLayout.createSequentialGroup().addContainerGap().addGroup(JPIOtrosDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBO_CActividadF, -1, 50, 32767).addComponent(this.JCBO_Alcohol, -1, 50, 32767).addComponent(this.JCBO_Nutricion, -1, 50, 32767).addComponent(this.JCBO_Planificacion, -1, 50, 32767)).addGap(16, 16, 16).addGroup(JPIOtrosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI, -2, -1, -2).addComponent(this.JCHO_EnfCoronaria)).addGap(72, 72, 72)));
        this.JTPDatosE.addTab("OTROS DATOS", this.JPIOtrosD);
        this.JDO_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDO_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDO_Fecha.setFont(new Font("Arial", 1, 12));
        this.JCBO_PRealizado.setFont(new Font("Arial", 1, 12));
        this.JCBO_PRealizado.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento Realizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIOMedicamento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Recibe Medicamentos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JRBO_SiM.setFont(new Font("Arial", 1, 12));
        this.JRBO_SiM.setSelected(true);
        this.JRBO_SiM.setText("Si");
        this.JRBO_SiM.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.43
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBO_SiMActionPerformed(evt);
            }
        });
        this.JRBO_NoM.setFont(new Font("Arial", 1, 12));
        this.JRBO_NoM.setText("No");
        this.JRBO_NoM.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.44
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JRBO_NoMActionPerformed(evt);
            }
        });
        GroupLayout JPIOMedicamentoLayout = new GroupLayout(this.JPIOMedicamento);
        this.JPIOMedicamento.setLayout(JPIOMedicamentoLayout);
        JPIOMedicamentoLayout.setHorizontalGroup(JPIOMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIOMedicamentoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBO_SiM).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, 32767).addComponent(this.JRBO_NoM, -2, 58, -2).addContainerGap()));
        JPIOMedicamentoLayout.setVerticalGroup(JPIOMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOMedicamentoLayout.createSequentialGroup().addGroup(JPIOMedicamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBO_NoM).addComponent(this.JRBO_SiM)).addContainerGap(10, 32767)));
        this.JSPO_Medicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPO_Medicamentos.setColumns(1);
        this.JTPO_Medicamentos.setFont(new Font("Arial", 1, 12));
        this.JTPO_Medicamentos.setLineWrap(true);
        this.JTPO_Medicamentos.setRows(1);
        this.JTPO_Medicamentos.setTabSize(1);
        this.JTPO_Medicamentos.setBorder((Border) null);
        this.JSPO_Medicamentos.setViewportView(this.JTPO_Medicamentos);
        GroupLayout JPIDObesidadLayout = new GroupLayout(this.JPIDObesidad);
        this.JPIDObesidad.setLayout(JPIDObesidadLayout);
        JPIDObesidadLayout.setHorizontalGroup(JPIDObesidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDObesidadLayout.createSequentialGroup().addContainerGap().addGroup(JPIDObesidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDObesidadLayout.createSequentialGroup().addComponent(this.JDO_Fecha, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JCBO_PRealizado, -2, 439, -2).addGap(27, 27, 27).addComponent(this.JPIOMedicamento, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JSPO_Medicamentos, -1, 784, 32767)).addContainerGap()));
        JPIDObesidadLayout.setVerticalGroup(JPIDObesidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDObesidadLayout.createSequentialGroup().addContainerGap().addGroup(JPIDObesidadLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDObesidadLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIOMedicamento, -2, -1, -2)).addComponent(this.JCBO_PRealizado).addComponent(this.JDO_Fecha, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JSPO_Medicamentos, -2, 73, -2).addGap(36, 36, 36)));
        this.JTPDatosE.addTab("OBESIDAD", this.JPIDObesidad);
        GroupLayout JPIngresoLayout = new GroupLayout(this.JPIngreso);
        this.JPIngreso.setLayout(JPIngresoLayout);
        JPIngresoLayout.setHorizontalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JPIDIngreso, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIDHta, -2, -1, -2)).addComponent(this.JTPDatosE, -2, 0, 32767)).addContainerGap()));
        JPIngresoLayout.setVerticalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDHta, -1, -1, 32767).addComponent(this.JPIDIngreso, -1, -1, 32767)).addGap(4, 4, 4).addComponent(this.JTPDatosE, -2, 217, -2).addContainerGap()));
        this.JTPDatos.addTab("INGRESO", this.JPIngreso);
        this.JDFechaEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaEgreso.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Egreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEFObsEgresos.setColumns(1);
        this.JTPEFObsEgresos.setLineWrap(true);
        this.JTPEFObsEgresos.setRows(1);
        this.JTPEFObsEgresos.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTPEFObsEgresos);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout JPIEgresoLayout = new GroupLayout(this.JPIEgreso);
        this.JPIEgreso.setLayout(JPIEgresoLayout);
        JPIEgresoLayout.setHorizontalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 815, 32767).addGroup(JPIEgresoLayout.createSequentialGroup().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 801, -2).addGroup(JPIEgresoLayout.createSequentialGroup().addComponent(this.JDFechaEgreso, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMotEgreso, -2, 464, -2))).addGap(0, 10, 32767))).addContainerGap()));
        JPIEgresoLayout.setVerticalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMotEgreso, -2, 51, -2).addComponent(this.JDFechaEgreso, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane2, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 214, -2).addContainerGap(21, 32767)));
        this.JTPDatos.addTab("EGRESO", this.JPIEgreso);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JP_PyP_DMyHTA.45
            public void actionPerformed(ActionEvent evt) {
                JP_PyP_DMyHTA.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JLIdIngresoPrograma.setFont(new Font("Arial", 1, 18));
        this.JLIdIngresoPrograma.setHorizontalAlignment(0);
        this.JLIdIngresoPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardar, -2, 642, -2).addGap(27, 27, 27).addComponent(this.JLIdIngresoPrograma, -2, 156, -2)).addComponent(this.JTPDatos, -2, 840, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 465, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLIdIngresoPrograma, -1, -1, 32767).addComponent(this.JBTGuardar, -1, 43, 32767)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        this.JBTGuardar.requestFocus();
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBI_TDx_NuevoActionPerformed(ActionEvent evt) {
        this.xesingreso = 0;
        this.xi_tipodx = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBI_TDx_ConocidoActionPerformed(ActionEvent evt) {
        this.xesingreso = 1;
        this.xi_tipodx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR_NoAplicaActionPerformed(ActionEvent evt) {
        this.xr_tipodx = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR_NuevoActionPerformed(ActionEvent evt) {
        this.xr_tipodx = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR_ConocidoActionPerformed(ActionEvent evt) {
        this.xr_tipodx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHta_NoAplicaActionPerformed(ActionEvent evt) {
        this.xhta_tipodx = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHta_NuevoActionPerformed(ActionEvent evt) {
        this.xhta_tipodx = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHta_ConocidoActionPerformed(ActionEvent evt) {
        this.xhta_tipodx = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDHta_FechaDxPropertyChange(PropertyChangeEvent evt) {
        if (this.JDHta_FechaDx.getDate() != null) {
            this.xhta_fecha = this.xmt.formatoAMD.format(this.JDHta_FechaDx.getDate());
        } else {
            this.xhta_fecha = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHta_ClasificacionRItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBHta_ClasificacionR.getSelectedIndex() != -1) {
            this.xhta_clasificacionr = this.JCBHta_ClasificacionR.getSelectedItem().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FechaDxPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FechaDx.getDate() != null) {
            this.xr_fecha = this.xmt.formatoAMD.format(this.JDR_FechaDx.getDate());
        } else {
            this.xr_fecha = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDIFechaDxPropertyChange(PropertyChangeEvent evt) {
        if (this.JDIFechaDx.getDate() != null) {
            this.xi_fecha = this.xmt.formatoAMD.format(this.JDIFechaDx.getDate());
        } else {
            this.xi_fecha = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBR_ClasificacionEstadioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBR_ClasificacionEstadio.getSelectedIndex() != -1) {
            this.xr_cestadio = this.JCBR_ClasificacionEstadio.getSelectedItem().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FProteinasPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FProteinas.getDate() != null) {
            this.xr_fecha_proteinas = this.xmt.formatoAMD.format(this.JDR_FProteinas.getDate());
        } else {
            this.xr_fecha_proteinas = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FPOrinaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FPOrina.getDate() != null) {
            this.xr_fecha_orina = this.xmt.formatoAMD.format(this.JDR_FPOrina.getDate());
        } else {
            this.xr_fecha_orina = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FMicroAlbuminaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FMicroAlbumina.getDate() != null) {
            this.xr_fecha_microalbumina = this.xmt.formatoAMD.format(this.JDR_FMicroAlbumina.getDate());
        } else {
            this.xr_fecha_microalbumina = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FEcografiaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FEcografia.getDate() != null) {
            this.xr_fecha_Ecografia = this.xmt.formatoAMD.format(this.JDR_FEcografia.getDate());
        } else {
            this.xr_fecha_Ecografia = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDR_FREnfermedadPropertyChange(PropertyChangeEvent evt) {
        if (this.JDR_FREnfermedad.getDate() != null) {
            this.xr_fecha_REnfermedad = this.xmt.formatoAMD.format(this.JDR_FREnfermedad.getDate());
        } else {
            this.xr_fecha_REnfermedad = "NULL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFE_PDiastolica.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaFocusGained(FocusEvent evt) {
        this.JTFFE_PSistolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFE_PSistolica.getText().isEmpty() && !this.JTFFE_PSistolica.getText().equals("0")) {
            mValidarPresion(Integer.valueOf(this.JTFFE_PSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PDiastolicaFocusGained(FocusEvent evt) {
        this.JTFFE_PDiastolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PAbdominalActionPerformed(ActionEvent evt) {
        this.JTFFE_Talla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PAbdominalFocusGained(FocusEvent evt) {
        this.JTFFE_PAbdominal.selectAll();
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
    public void JTFFO_CDiaActionPerformed(ActionEvent evt) {
        mC_Paquetes_Cigarrillo_Ano();
        this.JTFFO_CDia.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFO_CDiaFocusGained(FocusEvent evt) {
        this.JTFFO_CDia.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFO_NAnosFActionPerformed(ActionEvent evt) {
        mC_Paquetes_Cigarrillo_Ano();
        this.JTFFO_NAnosF.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFO_NAnosFFocusGained(FocusEvent evt) {
        this.JTFFO_NAnosF.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHO_EnfCoronariaActionPerformed(ActionEvent evt) {
        if (this.JCHO_EnfCoronaria.isSelected()) {
            this.xemfcoronaria = "SI";
        } else {
            this.xemfcoronaria = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBO_SiMActionPerformed(ActionEvent evt) {
        this.xrmedicamento = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBO_NoMActionPerformed(ActionEvent evt) {
        this.xrmedicamento = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFO_NAnosFFocusLost(FocusEvent evt) {
        mC_Paquetes_Cigarrillo_Ano();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHR_AplicaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiesNuevoPActionPerformed(ActionEvent evt) {
        this.xesnuevo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoesNuevoPActionPerformed(ActionEvent evt) {
        this.xesnuevo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHta_EstadioItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasfCardiovascularItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PAbdominalKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_PAbdominal.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_Talla.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_Peso.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_PSistolica.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PDiastolicaKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_PDiastolica.getText());
    }

    private void soloNumero(KeyEvent evt, String campo) {
        if (IsInteger(evt.getKeyChar() + "") && campo.length() < 3) {
            evt.setKeyChar(evt.getKeyChar());
        } else {
            evt.consume();
        }
    }

    public void mNuevo() {
        this.xesingreso = 0;
        this.JRBI_TDx_Nuevo.setSelected(true);
        this.xtipodiabetes = 0L;
        this.JDFechaEgreso.setDate(this.xmt.getFechaActual());
        this.JTPEFObservaciones.setText("");
        this.JTPEFObsEgresos.setText("");
        this.JCBMotEgreso.setSelectedItem(-1);
        this.JDFechaEgreso.setDate(this.xmt.getFechaActual());
        this.JCBR_ClasificacionEstadio.setSelectedIndex(0);
        this.JDIFecha.setDate(this.xmt.getFechaActual());
        this.JDIFechaDx.setDate((Date) null);
        this.JCBI_ClasificacionR.setSelectedIndex(-1);
        this.xi_tipodx = -1;
        this.JRBI_TDx_Nuevo.setSelected(false);
        this.JRBI_TDx_Conocido.setSelected(false);
        this.JCBI_Tipo_Diabetes.setSelectedIndex(0);
        this.JCBI_Tipo_Insulina.setSelectedIndex(0);
        this.JCBI_ClasificacionR.setSelectedIndex(-1);
        this.JDHta_FechaDx.setDate((Date) null);
        this.xhta_tipodx = -1;
        this.xhipertenso = 0L;
        this.xhta_clasificacionr = "";
        this.xhta_fecha = "NULL";
        this.JCBHta_ClasificacionR.setSelectedIndex(0);
        this.JRBHta_NoAplica.setSelected(true);
        this.xr_fecha = "NULL";
        this.xr_fecha_proteinas = "NULL";
        this.xr_fecha_orina = "NULL";
        this.xr_fecha_microalbumina = "NULL";
        this.xr_fecha_Ecografia = "NULL";
        this.xr_fecha_REnfermedad = "NULL";
        this.xr_valor_microalbumina = 0.0d;
        this.xr_cestadio = "";
        this.JDR_FechaDx.setDate((Date) null);
        this.JDR_FProteinas.setDate((Date) null);
        this.JDR_FPOrina.setDate((Date) null);
        this.JDR_FMicroAlbumina.setDate((Date) null);
        this.JDR_FEcografia.setDate((Date) null);
        this.JDR_FREnfermedad.setDate((Date) null);
        this.JTFFR_VMicroalbumina.setValue(new Integer(0));
        this.JCBO_Alcohol.setSelectedItem("NO APLICA");
        this.JCBO_CActividadF.setSelectedItem("NO APLICA");
        this.JCBO_Nutricion.setSelectedItem("NO APLICA");
        this.JTFFO_CDia.setText("0");
        this.JTFFO_NAnosF.setText("0");
        this.JLBO_Clasificacion.setText("NO APLICA");
        this.JCHO_EnfCoronaria.setSelected(false);
        this.xemfcoronaria = "NO";
        this.JDO_Fecha.setDate((Date) null);
        this.JCBO_PRealizado.setSelectedItem("Ninguno");
        this.JCBO_Planificacion.setSelectedItem("NO APLICA");
        this.xrmedicamento = "";
        this.JRBO_SiM.setSelected(false);
        this.JRBO_NoM.setSelected(false);
        this.JTPO_Medicamentos.setText("");
    }

    private Boolean datosObligatorios() {
        this.JDIFecha.getDateFormatString();
        Boolean opcion = true;
        System.out.println("1. " + this.JDHta_FechaDx.getDateFormatString());
        System.out.println("2. " + this.JDHta_FechaDx.getCalendar());
        System.out.println("2. " + this.JDHta_FechaDx.getDate());
        System.out.println("2. " + this.JDHta_FechaDx.getSize());
        if (this.JDIFecha.getDate() == null) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la fecha de ingreso al programa (Fecha en la que el paciente ingreso a este programa).", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JDIFecha.requestFocus();
        } else if (this.JCBI_Tipo_Diabetes.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de diabetes.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBI_Tipo_Diabetes.requestFocus();
        } else if (this.JDIFechaDx.getDate() == null) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la fecha diagnostico de diabetes (Fecha Dx DM).", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JDIFechaDx.requestFocus();
        } else if (this.JCBI_ClasificacionR.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clasificacion de riesgo Diabetes.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBI_ClasificacionR.requestFocus();
        } else if (this.JCBI_Tipo_Insulina.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo insulina.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBI_Tipo_Insulina.requestFocus();
        } else if (this.JCBClasfCardiovascular.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clasificacion del riesgo cardiovascular.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBClasfCardiovascular.requestFocus();
        } else if (this.JDHta_FechaDx.getDate() == null) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la fecha diagnostico HTA (Fecha Dx HTA).", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JDHta_FechaDx.requestFocus();
        } else if (this.JCBHta_ClasificacionR.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clasificacion del riesgo HTA.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBHta_ClasificacionR.requestFocus();
        } else if (this.JCBHta_Estadio.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el estadio HTA.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBHta_Estadio.requestFocus();
        } else if (this.JTFFE_PSistolica.getText().isEmpty() || IsDoouble(this.JTFFE_PSistolica.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_PSistolica.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en Presión Sistólica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_PSistolica.requestFocus();
            opcion = false;
        } else if (this.JTFFE_PDiastolica.getText().isEmpty() || IsDoouble(this.JTFFE_PDiastolica.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_PDiastolica.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en Presión Diastólica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_PDiastolica.requestFocus();
            opcion = false;
        } else if (this.JTFFE_PAbdominal.getText().isEmpty() || IsDoouble(this.JTFFE_PAbdominal.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_PAbdominal.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en PAbdominal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_PAbdominal.requestFocus();
            opcion = false;
        } else if (this.JTFFE_Talla.getText().isEmpty() || IsDoouble(this.JTFFE_Talla.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_Talla.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en Talla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_Talla.requestFocus();
            opcion = false;
        } else if (this.JTFFE_Peso.getText().isEmpty() || IsDoouble(this.JTFFE_Peso.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_Peso.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en Peso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_Peso.requestFocus();
            opcion = false;
        } else if (this.JTFFE_IMC.getText().isEmpty() || IsDoouble(this.JTFFE_IMC.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_IMC.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en IMC", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_IMC.requestFocus();
            opcion = false;
        }
        return opcion;
    }

    public static boolean IsInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Double IsDoouble(String text) {
        Double v = Double.valueOf(0.0d);
        try {
            v = Double.valueOf(Double.parseDouble(text));
        } catch (NumberFormatException e) {
        }
        return v;
    }

    public void mGrabarBd() {
        String xusuarioA = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()).toString();
        String xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        if (this.xnombre.equals("ingreso")) {
            if (this.JCBI_ClasificacionR.getSelectedIndex() != -1) {
                if (datosObligatorios().booleanValue()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (mConsultarUserProgram()) {
                            String sql = " UPDATE g_usuarioxprograma SET EsIngreso='" + this.xesingreso + "' , FechaIngreso='" + this.xmt.formatoAMD.format(this.JDIFecha.getDate()) + "' ,ObservacionIngreso='" + this.JTPEFObservaciones.getText() + "', FechaDiab='" + this.xmt.formatoAMD.format(this.JDIFechaDx.getDate()) + "', TipoDiabetes='" + this.xtipodiabetes + "', EsDM_HTA='" + this.xhipertenso + "' ,Hta_TipoDx='" + this.xhta_tipodx + "' ,ClasifRiesgoHTA='" + this.xhta_clasificacionr + "' ," + mDatoFecha(this.JDIFecha, "I_Fecha", this.xi_fecha) + " ," + mDatoFecha(this.JDIFechaDx, "I_FechaDx", this.xi_fecha) + " ,I_TipoDx='" + this.xi_tipodx + "' ,I_CRiesgo='" + this.JCBI_ClasificacionR.getSelectedItem() + "' ,I_Tipo_Diabetes='" + this.JCBI_Tipo_Diabetes.getSelectedItem() + "' ,I_Tipo_Insulina='" + this.JCBI_Tipo_Insulina.getSelectedItem() + "' ," + mDatoFecha(this.JDR_FechaDx, "I_NF_Fecha", this.xr_fecha) + " ,I_NF_TipoDx='" + this.xr_tipodx + "' ,I_NF_CRiesgo='" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "' ,I_NF_Estadio='" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "' ," + mDatoFecha(this.JDR_FProteinas, "I_NF_FProteinas24H", this.xr_fecha_proteinas) + " ," + mDatoFecha(this.JDR_FPOrina, "I_NF_FOrina", this.xr_fecha_orina) + " ," + mDatoFecha(this.JDR_FMicroAlbumina, "I_NF_FMicroAlbumina", this.xr_fecha_microalbumina) + " ,I_NF_VMicroAlbumina='" + this.JTFFR_VMicroalbumina.getValue() + "' ," + mDatoFecha(this.JDR_FEcografia, "I_NF_FEcografiaR", this.xr_fecha_Ecografia) + " ," + mDatoFecha(this.JDR_FREnfermedad, "I_NF_FRegresionE", this.xr_fecha_REnfermedad) + " ,Talla='" + this.JTFFE_Talla.getText() + "' ,Peso='" + this.JTFFE_Peso.getText() + "' ,IMC='" + this.JTFFE_IMC.getText() + "' ,PAbdominal='" + this.JTFFE_PAbdominal.getText() + "' ,TASistolica='" + this.JTFFE_PSistolica.getValue() + "' ,TADiastolica='" + this.JTFFE_PDiastolica.getValue() + "' ,I_CActividadFisica='" + this.JCBO_CActividadF.getSelectedItem() + "' ,I_CAlcohol='" + this.JCBO_Alcohol.getSelectedItem() + "' ,I_CNutricional='" + this.JCBO_Nutricion.getSelectedItem() + "' ,I_CTabaco_CDia='" + this.JTFFO_CDia.getText() + "' ,I_CTabaco_CAno='" + this.JTFFO_NAnosF.getText() + "' ,I_CTabaco_Clasificacion='" + this.JLBO_Clasificacion.getText() + "' ,I_CAntecedenteFC='" + this.xemfcoronaria + "' ,I_CPanifica='" + this.JCBO_Planificacion.getSelectedItem() + "' ,O_PRealizado='" + this.JCBO_PRealizado.getSelectedItem() + "' ," + mDatoFecha_Nulo(this.JDO_Fecha, "O_Fecha_PR") + " ,O_RMedicamentos='" + this.xrmedicamento + "' ,O_Cual_Medicamento='" + this.JTPO_Medicamentos.getText() + "' ,Fecha='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' ,I_esNuevo='" + this.xesnuevo + "' ,HtaEstadio='" + this.JCBHta_Estadio.getSelectedItem() + "' ,ClasRiesgoCVascular='" + this.JCBClasfCardiovascular.getSelectedItem() + "' ,UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id_Usuario= '" + xusuarioA + "' AND Id_Programa='12'";
                            this.xct.ejecutarSQL(sql);
                        } else {
                            String sql2 = " INSERT INTO g_usuarioxprograma (`Id_Usuario` , `Id_Programa` , `Cardinal` , `EsIngreso` , `FechaIngreso` , `Id_Atencion_Ingreso` , `ObservacionIngreso`, `FechaDiab` , `ClasifRiesgoDiab` , `ClasifEstDiab` , `Talla` , `Peso` , `IMC`,`PAbdominal`,`TASistolica`,`TADiastolica`,TipoDiabetes, EsDM_HTA, Hta_FechaDx, Hta_TipoDx, ClasifRiesgoHTA, `I_Fecha`, `I_FechaDx`, `I_TipoDx`, `I_CRiesgo`, `I_Tipo_Diabetes`, `I_Tipo_Insulina`, `I_NF_Fecha`, `I_NF_TipoDx`, `I_NF_Estadio`, `I_NF_FProteinas24H`, `I_NF_FOrina`, `I_NF_FMicroAlbumina`, `I_NF_VMicroAlbumina`, `I_NF_FEcografiaR`, `I_NF_FRegresionE`, `I_CActividadFisica`, `I_CAlcohol`, `I_CNutricional`, `I_CTabaco_CDia`, `I_CTabaco_CAno`, `I_CTabaco_Clasificacion`,  `I_CAntecedenteFC`, `I_CPanifica` , `O_PRealizado`, `O_Fecha_PR`, `O_RMedicamentos`, `O_Cual_Medicamento`,I_esNuevo, Fecha,  HtaEstadio,ClasRiesgoCVascular, UsuarioS) VALUES ('" + xusuarioA + "','12','0','1'," + mDatoFecha(this.JDIFecha) + ",'" + xidatencion + "','" + this.JTPEFObservaciones.getText() + "'," + mDatoFecha(this.JDIFechaDx) + ",'" + this.JCBI_ClasificacionR.getSelectedItem() + "','" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "','" + this.JTFFE_Talla.getText() + "','" + this.JTFFE_Peso.getText() + "','" + this.JTFFE_IMC.getText() + "','" + this.JTFFE_PAbdominal.getText() + "','" + this.JTFFE_PSistolica.getValue() + "','" + this.JTFFE_PDiastolica.getValue() + "','" + this.xtipodiabetes + "','" + this.xhipertenso + "'," + mDatoFecha(this.JDHta_FechaDx) + ",'" + this.xhta_tipodx + "','" + this.xhta_clasificacionr + "'," + mDatoFecha(this.JDIFecha) + "," + mDatoFecha(this.JDIFechaDx) + ",'" + this.xi_tipodx + "','" + this.JCBI_ClasificacionR.getSelectedItem() + "','" + this.JCBI_Tipo_Diabetes.getSelectedItem() + "','" + this.JCBI_Tipo_Insulina.getSelectedItem() + "'," + this.xr_fecha + ",'" + this.xr_tipodx + "','" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "'," + this.xr_fecha_proteinas + "," + this.xr_fecha_orina + "," + this.xr_fecha_microalbumina + "," + this.JTFFR_VMicroalbumina.getValue() + "," + this.xr_fecha_Ecografia + "," + this.xr_fecha_REnfermedad + ",'" + this.JCBO_CActividadF.getSelectedItem() + "','" + this.JCBO_Alcohol.getSelectedItem() + "','" + this.JCBO_Nutricion.getSelectedItem() + "','" + this.JTFFO_CDia.getText() + "','" + this.JTFFO_NAnosF.getText() + "','" + this.JLBO_Clasificacion.getText() + "','" + this.xemfcoronaria + "','" + this.JCBO_Planificacion.getSelectedItem() + "','" + this.JCBO_PRealizado.getSelectedItem() + "'," + mDatoFecha(this.JDO_Fecha) + ",'" + this.xrmedicamento + "','" + this.JTPO_Medicamentos.getText() + "','" + this.xesnuevo + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JCBHta_Estadio.getSelectedItem() + "','" + this.JCBClasfCardiovascular.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.JLIdIngresoPrograma.setText(this.xct.ejecutarSQLId(sql2));
                        }
                        this.xct.cerrarConexionBd();
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un riesgo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBI_ClasificacionR.requestFocus();
            return;
        }
        if (this.JCBMotEgreso.getSelectedIndex() != -1) {
            if (this.JTDetalle.getSelectedRow() >= 0) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).equals("Activo")) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        String sql3 = " UPDATE g_usuarioxprograma SET `FechaEgreso`='" + this.xmt.formatoAMD.format(this.JDFechaEgreso.getDate()) + "' , `MotivoEgreso`='" + this.listaMotivoEgreso[this.JCBMotEgreso.getSelectedIndex()] + "' , `Observacion_Egreso` = '" + this.JTPEFObsEgresos.getText() + "', `Id_Atencion_Egreso`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' ,Fecha='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' , Estado = 1 WHERE Id = " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "";
                        this.xct.ejecutarSQL(sql3);
                        this.xct.cerrarConexionBd();
                        mBuscarDatosUserProgramEgreso();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El ingreso a programa seleccionado ya se encuentra Inactivo.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro de la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un motivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBMotEgreso.requestFocus();
    }

    private String mDatoFecha(JDateChooser xcomp, String xvariable, String xvariable1) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = xvariable + "='" + xvariable1 + "'";
        } else {
            xv = xvariable + "=" + xvariable1 + "";
        }
        return xv;
    }

    private String mDatoFecha(JDateChooser xcomp) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = "'" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = "NULL";
        }
        return xv;
    }

    private String mDatoFecha_Nulo(JDateChooser xcomp, String xvariable) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = xvariable + "='" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = xvariable + "=" + ((Object) null) + "";
        }
        return xv;
    }

    public boolean mConsultarUserProgram() {
        boolean xexiste = false;
        String xusuarioA = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        String sql = "SELECT  `Id`,  `Id_Usuario` , `Id_Programa`,`EsIngreso` , `FechaIngreso` , `ObservacionIngreso` , `FechaDxhta` , `ClasifRiesgoHTA` , `ClasifEstHTA` , `Talla` , `Peso` , `IMC` FROM `g_usuarioxprograma` WHERE (`Id_Usuario` = '" + xusuarioA + "' AND `Id_Programa` ='12' AND Estado = 0)";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                xexiste = true;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
        return xexiste;
    }

    public void mBuscarDatosUserProgram() {
        String xusuarioA = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        String sql = "SELECT  g_usuarioxprograma.`Id`,  g_usuarioxprograma.`Id_Usuario` , g_usuarioxprograma.`Id_Programa`,g_usuarioxprograma.`EsIngreso` , g_usuarioxprograma.`FechaIngreso` , g_usuarioxprograma.`ObservacionIngreso` , g_usuarioxprograma.`FechaDiab` , g_usuarioxprograma.`ClasifRiesgoDiab` , g_usuarioxprograma.`ClasifEstDiab` , g_usuarioxprograma.`Talla` , g_usuarioxprograma.`Peso` , g_usuarioxprograma.`IMC`,  g_usuarioxprograma.`PAbdominal`,g_usuarioxprograma.`TASistolica`,g_usuarioxprograma.`TADiastolica`, g_usuarioxprograma.TipoDiabetes, g_usuarioxprograma.EsDM_HTA, g_usuarioxprograma.EnfCronica, g_usuarioxprograma.FechaEnfCron, g_usuarioxprograma.TipoDxEnfCron , `ClasifRiesgoHTA`, `Hta_FechaDx`, `Hta_TipoDx`, `I_Fecha`, `I_FechaDx`, `I_TipoDx`, `I_CRiesgo`, `I_Tipo_Diabetes`, `I_Tipo_Insulina`,  IF(`I_NF_Fecha` IS NULL,FALSE, TRUE) AS AplicaNF, `I_NF_Fecha` , `I_NF_CRiesgo`, `I_NF_TipoDx`, `I_NF_Estadio`, `I_NF_FProteinas24H`, `I_NF_FOrina`, `I_NF_FMicroAlbumina`, `I_NF_VMicroAlbumina`, `I_NF_FEcografiaR`, `I_NF_FRegresionE`, `I_CActividadFisica`, `I_CAlcohol`,`I_CNutricional`, `I_CTabaco_CDia`, `I_CTabaco_CAno`, `I_CTabaco_Clasificacion`, `I_CAntecedenteFC`, `I_CPanifica`  ,`O_PRealizado`, `O_Fecha_PR`, `O_RMedicamentos`, `O_Cual_Medicamento`, I_esNuevo , HtaEstadio, ClasRiesgoCVascular   FROM `g_usuarioxprograma`  WHERE (`Id_Usuario` = '" + xusuarioA + "' AND `Id_Programa` ='12' AND Estado = 0)";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                this.JLIdIngresoPrograma.setText(rs.getString("Id"));
                if (rs.getInt("EsIngreso") == 0) {
                    this.JRBI_TDx_Nuevo.setSelected(true);
                    this.xesingreso = 0;
                } else {
                    this.JRBI_TDx_Conocido.setSelected(true);
                    this.xesingreso = 1;
                }
                this.JDIFecha.setDate(rs.getDate("FechaIngreso"));
                this.JTPEFObservaciones.setText(rs.getString("ObservacionIngreso"));
                this.JDIFechaDx.setDate(rs.getDate("FechaDiab"));
                this.JCBI_ClasificacionR.setSelectedItem(rs.getString("ClasifRiesgoDiab"));
                this.JCBR_ClasificacionEstadio.setSelectedItem(rs.getString("ClasifEstDiab"));
                this.JTFFE_Talla.setText("" + rs.getString("Talla"));
                this.JTFFE_Peso.setText("" + rs.getString("Peso"));
                this.JTFFE_IMC.setText("" + rs.getString("IMC"));
                this.JTFFE_PAbdominal.setText("" + rs.getString("PAbdominal"));
                this.JTFFE_PDiastolica.setValue(Integer.valueOf(rs.getInt("TADiastolica")));
                this.JTFFE_PSistolica.setValue(Integer.valueOf(rs.getInt("TASistolica")));
                if (rs.getLong("I_esNuevo") == 1) {
                    this.xesnuevo = 1;
                    this.JRBSiesNuevoP.setSelected(true);
                } else {
                    this.xesnuevo = 0;
                    this.JRBNoesNuevoP.setSelected(true);
                }
                this.xhta_clasificacionr = rs.getString("ClasifRiesgoHTA");
                if (rs.getString("ClasifRiesgoHTA").equals("")) {
                    this.JCBHta_ClasificacionR.setSelectedIndex(-1);
                } else {
                    this.JCBHta_ClasificacionR.setSelectedItem(rs.getString("ClasifRiesgoHTA"));
                }
                this.JDHta_FechaDx.setDate(rs.getDate("Hta_FechaDx"));
                this.xhta_tipodx = rs.getInt("Hta_TipoDx");
                if (rs.getInt("Hta_TipoDx") == -1) {
                    this.JRBHta_NoAplica.setSelected(true);
                } else if (rs.getInt("Hta_TipoDx") == 0) {
                    this.JRBHta_Nuevo.setSelected(true);
                } else {
                    this.JRBHta_Conocido.setSelected(true);
                }
                this.JDIFecha.setDate(rs.getDate("I_Fecha"));
                this.JDIFechaDx.setDate(rs.getDate("I_FechaDx"));
                if (rs.getInt("I_TipoDx") == -1) {
                    this.JRBI_TDx_Nuevo.setSelected(false);
                    this.JRBI_TDx_Conocido.setSelected(false);
                } else if (rs.getInt("I_TipoDx") == 0) {
                    this.JRBI_TDx_Nuevo.setSelected(true);
                } else {
                    this.JRBI_TDx_Conocido.setSelected(true);
                }
                this.JCBI_ClasificacionR.setSelectedItem(rs.getString("I_CRiesgo"));
                this.JCBI_Tipo_Diabetes.setSelectedItem(rs.getString("I_Tipo_Diabetes"));
                this.JCBI_Tipo_Insulina.setSelectedItem(rs.getString("I_Tipo_Insulina"));
                this.JCHR_Aplica.setSelected(rs.getBoolean("AplicaNF"));
                this.JDR_FechaDx.setDate(rs.getDate("I_NF_Fecha"));
                this.JCBR_ClasificacionEstadio.setSelectedItem(rs.getString("I_NF_Estadio"));
                if (rs.getInt("I_NF_TipoDx") == -1) {
                    this.JRBR_NoAplica.setSelected(true);
                } else if (rs.getInt("I_NF_TipoDx") == 0) {
                    this.JRBR_Nuevo.setSelected(true);
                } else {
                    this.JRBR_Conocido.setSelected(true);
                }
                this.JDR_FProteinas.setDate(rs.getDate("I_NF_FProteinas24H"));
                this.JDR_FPOrina.setDate(rs.getDate("I_NF_FOrina"));
                this.JDR_FProteinas.setDate(rs.getDate("I_NF_FMicroAlbumina"));
                this.JTFFR_VMicroalbumina.setValue(Double.valueOf(rs.getDouble("I_NF_VMicroAlbumina")));
                this.JDR_FEcografia.setDate(rs.getDate("I_NF_FEcografiaR"));
                this.JDR_FREnfermedad.setDate(rs.getDate("I_NF_FRegresionE"));
                this.JCBO_Alcohol.setSelectedItem(rs.getString("I_CAlcohol"));
                this.JCBO_CActividadF.setSelectedItem(rs.getString("I_CActividadFisica"));
                this.JCBO_Nutricion.setSelectedItem(rs.getString("I_CNutricional"));
                this.JTFFO_CDia.setText(rs.getString("I_CTabaco_CDia"));
                this.JTFFO_NAnosF.setText(rs.getString("I_CTabaco_CAno"));
                this.JLBO_Clasificacion.setText(rs.getString("I_CTabaco_Clasificacion"));
                if (rs.getString("I_CAntecedenteFC").equals("SI")) {
                    this.JCHO_EnfCoronaria.setSelected(true);
                } else {
                    this.JCHO_EnfCoronaria.setSelected(false);
                }
                this.JCBO_Planificacion.setSelectedItem(rs.getString("I_CPanifica"));
                this.JCBO_PRealizado.setSelectedItem(rs.getString("O_PRealizado"));
                this.JDO_Fecha.setDate(rs.getDate("O_Fecha_PR"));
                if (rs.getString("O_RMedicamentos").equals("SI")) {
                    this.JRBO_SiM.setSelected(true);
                    this.JRBO_NoM.setSelected(false);
                    this.xrmedicamento = "SI";
                } else if (rs.getString("O_RMedicamentos").equals("NO")) {
                    this.JRBO_SiM.setSelected(false);
                    this.JRBO_NoM.setSelected(true);
                    this.xrmedicamento = "NO";
                } else {
                    this.JRBO_SiM.setSelected(false);
                    this.JRBO_NoM.setSelected(false);
                    this.xrmedicamento = "";
                }
                this.JCBHta_Estadio.setSelectedItem(rs.getString("HtaEstadio"));
                this.JCBClasfCardiovascular.setSelectedItem(rs.getString("ClasRiesgoCVascular"));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mBuscarDatosUserProgramEgreso() {
        String xusuarioA = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        String sql = "SELECT  g_usuarioxprograma.Id, IFNULL(`g_usuarioxprograma`.`FechaIngreso`,'') FechaIngreso, IFNULL(`g_usuarioxprograma`.`FechaEgreso`,'') FechaEgreso, IFNULL(`p_motivoegreso`.`Nbre`,'') AS MotivoEgreso, IFNULL(`g_usuarioxprograma`.`Observacion_Egreso`,'') Observacion_Egreso, IF(g_usuarioxprograma.Estado=0,'Activo','Inactivo') AS Estado  FROM `g_usuarioxprograma`  left JOIN `p_motivoegreso`  ON (`g_usuarioxprograma`.`MotivoEgreso` = `p_motivoegreso`.`Id`) WHERE (`Id_Usuario` = '" + xusuarioA + "' AND `Id_Programa` ='12' )";
        mCrearModeloDatos1();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(rs.getString(1), n, 0);
                    this.xmodelo.setValueAt(rs.getString(2), n, 1);
                    this.xmodelo.setValueAt(rs.getString(3), n, 2);
                    this.xmodelo.setValueAt(rs.getString(4), n, 3);
                    this.xmodelo.setValueAt(rs.getString(5), n, 4);
                    this.xmodelo.setValueAt(rs.getString(6), n, 5);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaIngreso", "FechaEgreso", "MotivoEgreso", "Observacion_Egreso", "Estado"}) { // from class: Historia.JP_PyP_DMyHTA.46
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mIniciarComponentes() {
        this.xlleno = false;
        this.JCBI_ClasificacionR.removeAllItems();
        this.xclasificacionR = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =5  AND `Estado` =1) ORDER BY Nbre", this.xclasificacionR, this.JCBI_ClasificacionR);
        this.JCBI_ClasificacionR.setSelectedIndex(-1);
        this.listaMotivoEgreso = this.xct.llenarCombo("SELECT Id, Nbre FROM p_motivoegreso WHERE (Estado =0) ORDER BY Nbre ASC", this.listaMotivoEgreso, this.JCBMotEgreso);
        this.JCBMotEgreso.setSelectedIndex(-1);
        this.JCBO_CActividadF.removeAllItems();
        this.xidactivadf = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =6  AND `Estado` =1) ORDER BY Id", this.xidactivadf, this.JCBO_CActividadF);
        this.JCBO_CActividadF.setSelectedItem("NO APLICA");
        this.JCBO_Alcohol.removeAllItems();
        this.xidcalcohol = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =7  AND `Estado` =1) ORDER BY Id", this.xidcalcohol, this.JCBO_Alcohol);
        this.JCBO_Alcohol.setSelectedItem("NO APLICA");
        this.JCBO_Nutricion.removeAllItems();
        this.xidnutricion = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =8  AND `Estado` =1) ORDER BY Id", this.xidnutricion, this.JCBO_Nutricion);
        this.JCBO_Nutricion.setSelectedItem("NO APLICA");
        this.JCBO_Planificacion.removeAllItems();
        this.xidmplanifica = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_tipometplanifica` ORDER BY `Nbre` ASC", this.xidmplanifica, this.JCBO_Planificacion);
        this.JCBO_Planificacion.setSelectedItem("NO APLICA");
        this.JCBO_PRealizado.removeAllItems();
        this.xidprocedimiento = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =9  AND `Estado` =1) ORDER BY Id", this.xidprocedimiento, this.JCBO_PRealizado);
        this.JCBO_PRealizado.setSelectedItem("Ninguno");
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mCalcularImc() {
        if (this.JTFFE_Talla.getText() != null && this.JTFFE_Peso.getText() != null) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFE_IMC.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.JTFFE_IMC.setText("0");
    }

    private void mC_Paquetes_Cigarrillo_Ano() {
        if (this.JTFFO_CDia.getText() != null && this.JTFFO_NAnosF != null && Double.valueOf(this.JTFFO_CDia.getText()).doubleValue() != 0.0d && Double.valueOf(this.JTFFO_NAnosF.getText()).doubleValue() != 0.0d) {
            DecimalFormat formato = new DecimalFormat("00");
            double resultado = (mDevolverValorComponenteF(this.JTFFO_CDia) * mDevolverValorComponenteF(this.JTFFO_NAnosF)) / 20;
            if (resultado > 0.0d) {
                this.JLBO_Clasificacion.setText("" + formato.format(resultado));
                return;
            } else {
                this.JLBO_Clasificacion.setText("NO APLICA");
                return;
            }
        }
        this.JLBO_Clasificacion.setText("NO APLICA");
    }

    private int mDevolverValorComponenteF(JTextFieldValidator xcomponente) {
        int valor = 0;
        if (xcomponente.getText() != null && !xcomponente.getText().equals("") && Integer.parseInt(xcomponente.getText()) > 0) {
            valor = Integer.parseInt(xcomponente.getText());
        }
        return valor;
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

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.xmt.mostrarMensaje("La Presión Sistólica esta Baja");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.xmt.mostrarMensaje("La Presión Sistólica esta Alta");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.xmt.mostrarMensaje("La Presion Diastólica esta Baja");
        } else if (valor > 0 && valor > 90) {
            this.xmt.mostrarMensaje("La Presión Diastólica esta Alta");
        }
    }

    public String getXidUsuarioPersona() {
        return this.xidUsuarioPersona;
    }

    public void setXidUsuarioPersona(String xidUsuarioPersona) {
        this.xidUsuarioPersona = xidUsuarioPersona;
    }
}
