package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.AtencionEntity;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GPatologia;
import com.genoma.plus.jpa.entities.GProfesional;
import com.genoma.plus.jpa.entities.GTipoempresa;
import com.genoma.plus.jpa.entities.GTipounidadnegocio;
import com.genoma.plus.jpa.entities.HIncapacidad;
import com.genoma.plus.jpa.entities.HTipojustificacionincap;
import com.genoma.plus.jpa.entities.HTipomotivoincap;
import com.genoma.plus.jpa.service.HIncapacidadServe;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAIncapacidad_v2.class */
public class JPAIncapacidad_v2 extends JPanel {
    private int lleno;
    private GregorianCalendar hoyaux;
    public ResultSet rsi;
    public String sql;
    public String xnombre;
    private clasesHistoriaCE xclase;
    private String[] idjustificacion;
    private String[] idunidadnegocio;
    private String[] idsupervisor;
    private String[] ideps;
    private String[][] idtipoempresa;
    public String[][] idtipoenfermedad;
    private ButtonGroup JBGProrroga;
    private ButtonGroup JBGTipoIncapacidad;
    private JButton JBSanitas;
    private JButton JBTVisualizar;
    public JComboBox JCBEps;
    private JComboBox JCBJefeInmediato;
    private JComboBox JCBTipoEmpresa;
    public JComboBox JCBTipoEnfermedad;
    private JComboBox JCBTipoJustificacion;
    private JComboBox JCBUnidadNegocio;
    private JPanel JPIDetalleInc;
    private JPanel JPITipoEmpresa;
    private JRadioButton JRBAmbulatorio;
    private JRadioButton JRBHospitalizado;
    private JRadioButton JRBNo;
    private JRadioButton JRBProrrogaNo;
    private JRadioButton JRBProrrogaSi;
    private JRadioButton JRBSi;
    private JScrollPane JSPObservacionesIncap;
    private JTextField JTFCDxP;
    private JTextField JTFCDxP1;
    private JTextField JTFCDxP2;
    private JTextField JTFCDxP3;
    private JSpinner JTFFEdadGestacional;
    public JFormattedTextField JTFFEstado;
    private JDateChooser JTFFFechaAccidenTrabaj;
    private JDateChooser JTFFFechaFin;
    private JDateChooser JTFFFechaInicio;
    private JDateChooser JTFFFechaParto;
    private JFormattedTextField JTFFJefeInmediatoOtras;
    private JSpinner JTFFNDias;
    public JFormattedTextField JTFFNIncapacidad;
    private JSpinner JTFFNacidos;
    private JFormattedTextField JTFFNit;
    private JFormattedTextField JTFFNombreEmpresa;
    private JTextField JTFNCertificado;
    private JTextField JTFNCodigoDxP;
    private JTextField JTFNCodigoDxP1;
    private JTextField JTFNCodigoDxP2;
    private JTextField JTFNCodigoDxP3;
    private JTextPane JTPObservacionesIncap;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel18;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JPanel jPanel3;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JTabbedPane jTabbedPane1;
    private int xtipoincapacidad = 0;
    private int prorroga = 0;
    private int multiple = 0;
    private final HIncapacidadServe hIncapacidadServe = (HIncapacidadServe) Principal.contexto.getBean(HIncapacidadServe.class);
    private GregorianCalendar hoy = new GregorianCalendar();
    Runtime obj = Runtime.getRuntime();
    private String fechaat = "";
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPAIncapacidad_v2(clasesHistoriaCE xclase, String xnombre) {
        this.lleno = 0;
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        this.JTFFFechaInicio.setDate(this.xmetodo.getFechaActual());
        this.JTFFFechaFin.setDate(this.xmetodo.getFechaActual());
        this.JTFFFechaAccidenTrabaj.setDate(this.xmetodo.getFechaActual());
        this.sql = "SELECT Id, Nbre, ExigeNit FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC";
        this.idtipoempresa = this.xconsultasbd.llenarComboyLista(this.sql, this.idtipoempresa, this.JCBTipoEmpresa, 3);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.idjustificacion = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipojustificacionincap WHERE (Estado =0)", this.idjustificacion, this.JCBTipoJustificacion);
        this.ideps = this.xconsultasbd.llenarCombo("SELECT ge.Id ,\nif(ge.Nbre = '', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) nombreEmpresa\nfrom  g_empresa ge \nwhere ge.Eps in(1,2)\norder by if(ge.Nbre = '', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre )  asc", this.ideps, this.JCBEps);
        this.JCBEps.setSelectedIndex(-1);
        this.JCBTipoJustificacion.setSelectedIndex(0);
        this.idtipoenfermedad = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, EsTrabajo, NumDias FROM h_tipomotivoincap WHERE (Estado =0) ORDER BY Orden ASC", this.idtipoenfermedad, this.JCBTipoEnfermedad, 4);
        this.JCBTipoEnfermedad.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mVerificarCruceIncapacidades();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            mLLenarCombosIniciales();
        } else {
            mLLenarCboEmpresa();
            this.JCBJefeInmediato.setVisible(false);
            this.JCBUnidadNegocio.setVisible(false);
            this.JTFFNit.setVisible(false);
            this.JTFFNombreEmpresa.setVisible(false);
            this.JTFFJefeInmediatoOtras.setVisible(false);
            if (this.idtipoempresa.length > 0) {
                this.JCBTipoEmpresa.setSelectedIndex(0);
                this.sql = "SELECT Id, Nbre FROM g_tipounidadnegocio where Id_TipoEmpresa='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' AND Estado =0 ORDER BY Nbre ASC";
                this.idunidadnegocio = this.xconsultasbd.llenarCombo(this.sql, this.idunidadnegocio, this.JCBUnidadNegocio);
                this.xconsultasbd.cerrarConexionBd();
                this.JCBUnidadNegocio.setSelectedIndex(0);
                this.sql = "SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) WHERE (g_supervisor.Id_TipoEmpresa ='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' and g_supervisor.Estado=0) ORDER BY supervisor";
                this.idsupervisor = this.xconsultasbd.llenarCombo(this.sql, this.idsupervisor, this.JCBJefeInmediato);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (this.idunidadnegocio.length > 0) {
                this.JCBUnidadNegocio.setSelectedIndex(0);
            }
            if (this.idsupervisor.length > 0) {
                this.JCBJefeInmediato.setSelectedIndex(0);
            }
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JBSanitas.setVisible(true);
        } else {
            this.JBSanitas.setVisible(false);
        }
        this.lleno = 1;
        this.buttonGroup1.add(this.JRBNo);
        this.buttonGroup1.add(this.JRBSi);
        this.JTFFFechaParto.setDate(this.hoy.getTime());
    }

    private void initComponents() {
        this.JBGTipoIncapacidad = new ButtonGroup();
        this.JBGProrroga = new ButtonGroup();
        this.buttonGroup1 = new ButtonGroup();
        this.JPITipoEmpresa = new JPanel();
        this.JCBTipoEmpresa = new JComboBox();
        this.JCBUnidadNegocio = new JComboBox();
        this.JTFFNit = new JFormattedTextField();
        this.JTFFNombreEmpresa = new JFormattedTextField();
        this.JCBJefeInmediato = new JComboBox();
        this.JTFFJefeInmediatoOtras = new JFormattedTextField();
        this.JCBEps = new JComboBox();
        this.JCBTipoEnfermedad = new JComboBox();
        this.JPIDetalleInc = new JPanel();
        this.JCBTipoJustificacion = new JComboBox();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPObservacionesIncap = new JScrollPane();
        this.JTPObservacionesIncap = new JTextPane();
        this.jPanel1 = new JPanel();
        this.JRBAmbulatorio = new JRadioButton();
        this.JRBHospitalizado = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JRBProrrogaSi = new JRadioButton();
        this.JRBProrrogaNo = new JRadioButton();
        this.JTFFFechaInicio = new JDateChooser();
        this.JTFFFechaFin = new JDateChooser();
        this.JTFFNDias = new JSpinner();
        this.JTFFFechaAccidenTrabaj = new JDateChooser();
        this.JTFFNIncapacidad = new JFormattedTextField();
        this.JTFFEstado = new JFormattedTextField();
        this.JBTVisualizar = new JButton();
        this.JBSanitas = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel20 = new JPanel();
        this.jPanel7 = new JPanel();
        this.JTFCDxP1 = new JTextField();
        this.JTFNCodigoDxP1 = new JTextField();
        this.JTFCDxP2 = new JTextField();
        this.JTFNCodigoDxP2 = new JTextField();
        this.JTFCDxP3 = new JTextField();
        this.JTFNCodigoDxP3 = new JTextField();
        this.jPanel18 = new JPanel();
        this.jPanel3 = new JPanel();
        this.JTFNCertificado = new JTextField();
        this.JTFFNacidos = new JSpinner();
        this.jPanel6 = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFFEdadGestacional = new JSpinner();
        this.JTFFFechaParto = new JDateChooser();
        setBorder(BorderFactory.createTitledBorder((Border) null, "INCAPACIDAD", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpincapacidades_v2");
        this.JPITipoEmpresa.setBorder(BorderFactory.createEtchedBorder(0, Color.white, (Color) null));
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoEmpresa.addItemListener(new ItemListener() { // from class: Historia.JPAIncapacidad_v2.1
            public void itemStateChanged(ItemEvent evt) {
                JPAIncapacidad_v2.this.JCBTipoEmpresaItemStateChanged(evt);
            }
        });
        this.JCBUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadNegocio.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Negocio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBUnidadNegocio.setEnabled(false);
        this.JTFFNit.setEditable(false);
        this.JTFFNit.setBorder(BorderFactory.createTitledBorder((Border) null, "NIT", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNit.setHorizontalAlignment(2);
        this.JTFFNit.setFont(new Font("Arial", 1, 12));
        this.JTFFNombreEmpresa.setEditable(false);
        this.JTFFNombreEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNombreEmpresa.setHorizontalAlignment(2);
        this.JTFFNombreEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBJefeInmediato.setFont(new Font("Arial", 1, 12));
        this.JCBJefeInmediato.setBorder(BorderFactory.createTitledBorder((Border) null, "Jefe Inmediato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBJefeInmediato.setEnabled(false);
        this.JTFFJefeInmediatoOtras.setEditable(false);
        this.JTFFJefeInmediatoOtras.setBorder(BorderFactory.createTitledBorder((Border) null, "Jefe Inmediato (otras empresas)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFJefeInmediatoOtras.setHorizontalAlignment(2);
        this.JTFFJefeInmediatoOtras.setFont(new Font("Arial", 1, 12));
        this.JCBEps.setFont(new Font("Arial", 1, 12));
        this.JCBEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoEnfermedad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEnfermedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Enfermedad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoEnfermedad.addItemListener(new ItemListener() { // from class: Historia.JPAIncapacidad_v2.2
            public void itemStateChanged(ItemEvent evt) {
                JPAIncapacidad_v2.this.JCBTipoEnfermedadItemStateChanged(evt);
            }
        });
        GroupLayout JPITipoEmpresaLayout = new GroupLayout(this.JPITipoEmpresa);
        this.JPITipoEmpresa.setLayout(JPITipoEmpresaLayout);
        JPITipoEmpresaLayout.setHorizontalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.JCBTipoEmpresa, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUnidadNegocio, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBJefeInmediato, -2, 230, -2)).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.JCBEps, -2, 402, -2).addGap(18, 18, 18).addComponent(this.JCBTipoEnfermedad, -2, 341, -2)).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.JTFFNit, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNombreEmpresa, -2, 292, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFJefeInmediatoOtras, -2, 214, -2))).addContainerGap(-1, 32767)));
        JPITipoEmpresaLayout.setVerticalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEps, -2, 47, -2).addComponent(this.JCBTipoEnfermedad, -2, 47, -2)).addGap(18, 18, 18).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBUnidadNegocio, -1, 45, 32767).addComponent(this.JCBJefeInmediato).addComponent(this.JCBTipoEmpresa)).addGap(18, 18, 18).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFNit, -2, 33, -2).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNombreEmpresa).addComponent(this.JTFFJefeInmediatoOtras, -2, 39, -2))).addContainerGap()));
        this.JPIDetalleInc.setBorder(BorderFactory.createEtchedBorder());
        this.JCBTipoJustificacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoJustificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Justificacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.3
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.4
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patologia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.5
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.6
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTPObservacionesIncap.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPObservacionesIncap.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionesIncap.setViewportView(this.JTPObservacionesIncap);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Incapacidad", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setForeground(Color.blue);
        this.jPanel1.setFont(new Font("Arial", 0, 12));
        this.JBGTipoIncapacidad.add(this.JRBAmbulatorio);
        this.JRBAmbulatorio.setFont(new Font("Arial", 1, 12));
        this.JRBAmbulatorio.setForeground(new Color(0, 0, 255));
        this.JRBAmbulatorio.setSelected(true);
        this.JRBAmbulatorio.setText("Amb.");
        this.JRBAmbulatorio.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.7
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBAmbulatorioActionPerformed(evt);
            }
        });
        this.JBGTipoIncapacidad.add(this.JRBHospitalizado);
        this.JRBHospitalizado.setFont(new Font("Arial", 1, 12));
        this.JRBHospitalizado.setForeground(new Color(0, 0, 255));
        this.JRBHospitalizado.setText("Hosp.");
        this.JRBHospitalizado.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.8
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBHospitalizadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JRBAmbulatorio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBHospitalizado).addContainerGap(-1, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAmbulatorio).addComponent(this.JRBHospitalizado)).addContainerGap(-1, 32767))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Es Prorroga ?", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGProrroga.add(this.JRBProrrogaSi);
        this.JRBProrrogaSi.setFont(new Font("Arial", 1, 12));
        this.JRBProrrogaSi.setForeground(new Color(0, 0, 255));
        this.JRBProrrogaSi.setText("Si");
        this.JRBProrrogaSi.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.9
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBProrrogaSiActionPerformed(evt);
            }
        });
        this.JBGProrroga.add(this.JRBProrrogaNo);
        this.JRBProrrogaNo.setFont(new Font("Arial", 1, 12));
        this.JRBProrrogaNo.setForeground(new Color(0, 0, 255));
        this.JRBProrrogaNo.setSelected(true);
        this.JRBProrrogaNo.setText("No");
        this.JRBProrrogaNo.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.10
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBProrrogaNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBProrrogaSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBProrrogaNo).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProrrogaSi).addComponent(this.JRBProrrogaNo)).addContainerGap(18, 32767)));
        this.JTFFFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JTFFFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaInicio.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.11
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaInicioMouseClicked(evt);
            }
        });
        this.JTFFFechaInicio.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.12
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaInicioFocusLost(evt);
            }
        });
        this.JTFFFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAIncapacidad_v2.13
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaInicioPropertyChange(evt);
            }
        });
        this.JTFFFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaFin.setForeground(new Color(0, 0, 204));
        this.JTFFFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JTFFFechaFin.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaFin.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.14
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaFinFocusLost(evt);
            }
        });
        this.JTFFFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAIncapacidad_v2.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaFinPropertyChange(evt);
            }
        });
        this.JTFFNDias.setFont(new Font("Arial", 1, 12));
        this.JTFFNDias.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JTFFNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Dias", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNDias.addChangeListener(new ChangeListener() { // from class: Historia.JPAIncapacidad_v2.16
            public void stateChanged(ChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFNDiasStateChanged(evt);
            }
        });
        this.JTFFNDias.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.17
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFNDiasFocusLost(evt);
            }
        });
        this.JTFFFechaAccidenTrabaj.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha AT", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaAccidenTrabaj.setDateFormatString("dd/MM/yyyy");
        this.JTFFFechaAccidenTrabaj.setEnabled(false);
        this.JTFFFechaAccidenTrabaj.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaAccidenTrabaj.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAIncapacidad_v2.18
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaAccidenTrabajPropertyChange(evt);
            }
        });
        GroupLayout JPIDetalleIncLayout = new GroupLayout(this.JPIDetalleInc);
        this.JPIDetalleInc.setLayout(JPIDetalleIncLayout);
        JPIDetalleIncLayout.setHorizontalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDetalleIncLayout.createSequentialGroup().addComponent(this.JTFFFechaInicio, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDias, -2, 64, -2).addGap(12, 12, 12).addComponent(this.JTFFFechaFin, -2, 94, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoJustificacion, -2, 198, -2)).addGroup(JPIDetalleIncLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 675, -2)).addGroup(JPIDetalleIncLayout.createSequentialGroup().addComponent(this.JTFFFechaAccidenTrabaj, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionesIncap))).addContainerGap(23, 32767)));
        JPIDetalleIncLayout.setVerticalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDetalleIncLayout.createSequentialGroup().addGap(34, 34, 34).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFNDias).addComponent(this.JTFFFechaFin, -2, 0, 32767).addComponent(this.JTFFFechaInicio, GroupLayout.Alignment.TRAILING, -2, 0, 32767))).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JCBTipoJustificacion)))).addGap(18, 18, 18).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFFechaAccidenTrabaj, -1, -1, 32767).addComponent(this.JSPObservacionesIncap)).addGap(91, 91, 91)));
        this.JTFFNIncapacidad.setEditable(false);
        this.JTFFNIncapacidad.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFFNIncapacidad.setForeground(Color.blue);
        this.JTFFNIncapacidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNIncapacidad.setHorizontalAlignment(0);
        this.JTFFNIncapacidad.setFont(new Font("Arial", 1, 18));
        this.JTFFEstado.setEditable(false);
        this.JTFFEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFFEstado.setForeground(Color.blue);
        this.JTFFEstado.setHorizontalAlignment(0);
        this.JTFFEstado.setFont(new Font("Arial", 1, 18));
        this.JBTVisualizar.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTVisualizar.setText("Visualizar Epicrisis");
        this.JBTVisualizar.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.19
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JBTVisualizarActionPerformed(evt);
            }
        });
        this.JBSanitas.setFont(new Font("Arial", 1, 12));
        this.JBSanitas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Colsanitas.jpg")));
        this.JBSanitas.setText("Formato Sánitas");
        this.JBSanitas.setEnabled(false);
        this.JBSanitas.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.20
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JBSanitasActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNOSTICO RELACIONADO", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFCDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP1.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.21
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP1FocusLost(evt);
            }
        });
        this.JTFCDxP1.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.22
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP1KeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patologia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP1.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.23
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP1MouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP1.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.24
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP1KeyPressed(evt);
            }
        });
        this.JTFCDxP2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP2.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP2.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.25
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP2FocusLost(evt);
            }
        });
        this.JTFCDxP2.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.26
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP2KeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP2.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP2.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patologia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP2.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.27
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP2MouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP2.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.28
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP2KeyPressed(evt);
            }
        });
        this.JTFCDxP3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP3.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP3.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.29
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP3FocusLost(evt);
            }
        });
        this.JTFCDxP3.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.30
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFCDxP3KeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP3.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP3.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patologia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP3.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.31
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP3MouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP3.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.32
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFNCodigoDxP3KeyPressed(evt);
            }
        });
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JTFCDxP3, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP3, -1, 657, 32767)).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCDxP1, -2, 1, 32767).addComponent(this.JTFCDxP2, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNCodigoDxP1, -1, 657, 32767).addComponent(this.JTFNCodigoDxP2)))).addContainerGap(-1, 32767)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP1, -2, -1, -2).addComponent(this.JTFNCodigoDxP1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP2, -2, -1, -2).addComponent(this.JTFNCodigoDxP2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP3, -2, -1, -2).addComponent(this.JTFNCodigoDxP3, -2, -1, -2))));
        GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
        this.jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, -1, -2).addContainerGap(23, 32767)));
        jPanel20Layout.setVerticalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel7, -2, -1, -2).addGap(79, 79, 79)));
        this.jTabbedPane1.addTab("Diagnostico", this.jPanel20);
        this.JTFNCertificado.setFont(new Font("Arial", 1, 12));
        this.JTFNCertificado.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Certificado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCertificado.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.33
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFNCertificadoMouseClicked(evt);
            }
        });
        this.JTFNCertificado.addKeyListener(new KeyAdapter() { // from class: Historia.JPAIncapacidad_v2.34
            public void keyPressed(KeyEvent evt) {
                JPAIncapacidad_v2.this.JTFNCertificadoKeyPressed(evt);
            }
        });
        this.JTFFNacidos.setFont(new Font("Arial", 1, 12));
        this.JTFFNacidos.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JTFFNacidos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nacidos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNacidos.addChangeListener(new ChangeListener() { // from class: Historia.JPAIncapacidad_v2.35
            public void stateChanged(ChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFNacidosStateChanged(evt);
            }
        });
        this.JTFFNacidos.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.36
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFNacidosFocusLost(evt);
            }
        });
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Embarazo Multiple", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setLabel("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.37
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBSiActionPerformed(evt);
            }
        });
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setSelected(true);
        this.JRBNo.setLabel("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JPAIncapacidad_v2.38
            public void actionPerformed(ActionEvent evt) {
                JPAIncapacidad_v2.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JRBSi, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo).addGap(0, 23, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addGap(0, 6, 32767)));
        this.JTFFEdadGestacional.setFont(new Font("Arial", 1, 12));
        this.JTFFEdadGestacional.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JTFFEdadGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Gestacional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFEdadGestacional.addChangeListener(new ChangeListener() { // from class: Historia.JPAIncapacidad_v2.39
            public void stateChanged(ChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFEdadGestacionalStateChanged(evt);
            }
        });
        this.JTFFEdadGestacional.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.40
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFEdadGestacionalFocusLost(evt);
            }
        });
        this.JTFFFechaParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Parto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaParto.setDateFormatString("dd/MM/yyyy");
        this.JTFFFechaParto.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaParto.addFocusListener(new FocusAdapter() { // from class: Historia.JPAIncapacidad_v2.41
            public void focusLost(FocusEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaPartoFocusLost(evt);
            }
        });
        this.JTFFFechaParto.addMouseListener(new MouseAdapter() { // from class: Historia.JPAIncapacidad_v2.42
            public void mouseClicked(MouseEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaPartoMouseClicked(evt);
            }
        });
        this.JTFFFechaParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAIncapacidad_v2.43
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAIncapacidad_v2.this.JTFFFechaPartoPropertyChange(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFFechaParto, -2, 115, -2).addGap(18, 18, 18).addComponent(this.JTFFEdadGestacional, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel6, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFFNacidos, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCertificado, -2, 135, -2).addGap(347, 347, 347)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFFechaParto, -2, -1, -2).addComponent(this.JTFFEdadGestacional, -2, 38, -2).addComponent(this.jPanel6, -2, -1, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNacidos, -2, -1, -2).addComponent(this.JTFNCertificado, -2, -1, -2))).addContainerGap(69, 32767)));
        GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
        this.jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, 735, -2).addContainerGap(28, 32767)));
        jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(12, 32767)));
        this.jTabbedPane1.addTab("PARTO", this.jPanel18);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoEmpresa, -2, -1, -2).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING).addComponent(this.JPIDetalleInc, GroupLayout.Alignment.LEADING, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTFFEstado, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTVisualizar, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSanitas).addGap(174, 174, 174).addComponent(this.JTFFNIncapacidad, -2, 107, -2))))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPITipoEmpresa, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDetalleInc, -2, 199, -2).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 206, -2).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBSanitas, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBTVisualizar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFEstado, GroupLayout.Alignment.TRAILING).addComponent(this.JTFFNIncapacidad, -2, -1, -2)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFCDxP, this.JTFNCodigoDxP, "incapacidad", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEmpresaItemStateChanged(ItemEvent evt) {
        if (this.lleno != 0 && this.JCBTipoEmpresa.getSelectedIndex() != -1) {
            ConsultasMySQL xconsultasbd1 = new ConsultasMySQL();
            if (this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][1].equals("1")) {
                this.JCBUnidadNegocio.removeAllItems();
                this.JCBJefeInmediato.removeAllItems();
                this.sql = "SELECT Id, Nbre FROM g_tipounidadnegocio where Id_TipoEmpresa='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' AND Estado =0 ORDER BY Nbre ASC";
                this.idunidadnegocio = xconsultasbd1.llenarCombo(this.sql, this.idunidadnegocio, this.JCBUnidadNegocio);
                if (this.idunidadnegocio.length > 1) {
                    this.JCBUnidadNegocio.setSelectedIndex(-1);
                }
                xconsultasbd1.cerrarConexionBd();
                this.sql = "SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) WHERE (g_supervisor.Id_TipoEmpresa ='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' and g_supervisor.Estado=0) ORDER BY supervisor";
                this.idsupervisor = xconsultasbd1.llenarCombo(this.sql, this.idsupervisor, this.JCBJefeInmediato);
                if (this.idsupervisor.length > 1) {
                    this.JCBJefeInmediato.setSelectedIndex(-1);
                }
                xconsultasbd1.cerrarConexionBd();
                this.JCBUnidadNegocio.setEnabled(true);
                this.JCBJefeInmediato.setEnabled(true);
                this.JTFFNit.setEditable(false);
                this.JTFFNombreEmpresa.setEditable(false);
                this.JTFFJefeInmediatoOtras.setEditable(false);
                return;
            }
            this.JCBUnidadNegocio.removeAllItems();
            this.sql = "SELECT Id, Nbre FROM g_tipounidadnegocio where Id_TipoEmpresa='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' AND Estado =0 ORDER BY Nbre ASC";
            this.idunidadnegocio = xconsultasbd1.llenarCombo(this.sql, this.idunidadnegocio, this.JCBUnidadNegocio);
            xconsultasbd1.cerrarConexionBd();
            this.JCBUnidadNegocio.setSelectedIndex(0);
            this.sql = "SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) WHERE (g_supervisor.Id_TipoEmpresa ='" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "' and g_supervisor.Estado=0) ORDER BY supervisor";
            this.idsupervisor = xconsultasbd1.llenarCombo(this.sql, this.idsupervisor, this.JCBJefeInmediato);
            xconsultasbd1.cerrarConexionBd();
            this.JCBJefeInmediato.setSelectedIndex(0);
            this.JCBUnidadNegocio.setEnabled(false);
            this.JCBJefeInmediato.setEnabled(false);
            this.JTFFNit.setEditable(true);
            this.JTFFNombreEmpresa.setEditable(true);
            this.JTFFJefeInmediatoOtras.setEditable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAmbulatorioActionPerformed(ActionEvent evt) {
        this.xtipoincapacidad = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHospitalizadoActionPerformed(ActionEvent evt) {
        this.xtipoincapacidad = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProrrogaSiActionPerformed(ActionEvent evt) {
        this.prorroga = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProrrogaNoActionPerformed(ActionEvent evt) {
        this.prorroga = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEnfermedadItemStateChanged(ItemEvent evt) {
        if (this.lleno == 1 && this.JCBTipoEnfermedad.getSelectedIndex() != -1) {
            if (this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][1].equals("1")) {
                this.JTFFFechaAccidenTrabaj.setEnabled(true);
                int numDias = Integer.parseInt(this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][2]);
                this.JTFFNDias.setModel(new SpinnerNumberModel(1, 1, numDias, 1));
            } else {
                this.JTFFFechaAccidenTrabaj.setEnabled(false);
                int numDias2 = Integer.parseInt(this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][2]);
                this.JTFFNDias.setModel(new SpinnerNumberModel(1, 1, numDias2, 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDiasStateChanged(ChangeEvent evt) {
        mcalcularDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaInicioFocusLost(FocusEvent evt) {
        mcalcularDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaFinFocusLost(FocusEvent evt) {
        mcalcularDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaInicioMouseClicked(MouseEvent evt) {
        mcalcularDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaInicioPropertyChange(PropertyChangeEvent evt) {
        mcalcularDias();
        mVerificarCruceIncapacidades();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaFinPropertyChange(PropertyChangeEvent evt) {
        mcalcularDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaAccidenTrabajPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDiasFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizarActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("jifhistoriaclinica") || this.xnombre.equals("xjifhistoria")) {
            if (this.JTFFNIncapacidad.getValue() != null || !this.JTFFNIncapacidad.getText().isEmpty()) {
                String[][] mparametros = new String[3][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                mparametros[1][0] = "SUBREPORT_DIR";
                mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 0) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinica_Epicrisis_C_Positivo", mparametros);
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinica_Epicrisis_C_Positivo_1", mparametros);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSanitasActionPerformed(ActionEvent evt) {
        JDInc_Sanitas x = new JDInc_Sanitas(null, true, this.JTFFNIncapacidad.getText());
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP3MouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFCDxP3, this.JTFNCodigoDxP3, "incapacidad", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP3FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP2MouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFCDxP2, this.JTFNCodigoDxP2, "incapacidad", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP2FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1MouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFCDxP1, this.JTFNCodigoDxP1, "incapacidad", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCertificadoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCertificadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNacidosFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNacidosStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.multiple = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.multiple = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFEdadGestacionalFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFEdadGestacionalStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaPartoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaPartoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFechaPartoFocusLost(FocusEvent evt) {
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (codigo.getText().length() != 0) {
            try {
                this.sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.xconsultasbd.traerRs(this.sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Codigo no existe", "BUSCAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mcalcularDias() {
        if (((Integer) this.JTFFNDias.getValue()).intValue() != 0) {
            this.hoyaux = new GregorianCalendar();
            this.hoyaux.setTime(this.JTFFFechaInicio.getDate());
            this.hoyaux.setGregorianChange(this.JTFFFechaInicio.getDate());
            int ndias = ((Integer) this.JTFFNDias.getValue()).intValue();
            this.hoyaux.add(5, ndias - 1);
            this.JTFFFechaFin.setDate(this.hoyaux.getTime());
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo dias no puede estar en blanco", "VERIFICAR", 0);
        this.JTFFNDias.requestFocus();
    }

    public boolean validarComponentes() {
        boolean validar = false;
        if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
            if (((Integer) this.JTFFNDias.getValue()).intValue() != 0) {
                if (this.JTFNCodigoDxP.getText().length() != 0) {
                    if (this.JCBTipoJustificacion.getSelectedIndex() != -1) {
                        if (this.JCBTipoEnfermedad.getSelectedIndex() != -1) {
                            if (this.JCBEps.getSelectedIndex() != -1) {
                                validar = true;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la entidad", "VERIFICAR", 0);
                                this.JCBEps.requestFocus();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de enfermedad", "VERIFICAR", 0);
                            this.JCBTipoEnfermedad.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de justificacion", "VERIFICAR", 0);
                        this.JCBTipoJustificacion.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "El campo patologia no puede ser nulo", "VERIFICAR", 0);
                    this.JTFNCodigoDxP.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "El campo Ndias no puede ser nulo", "VERIFICAR", 0);
                this.JTFFNDias.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo empresa", "VERIFICAR", 0);
            this.JCBTipoEmpresa.requestFocus();
        }
        return validar;
    }

    private void mLLenarCombosIniciales() {
        try {
            this.sql = "SELECT  `cc_terceros`.`RazonSocialCompleta`, `g_tipoempresa`.`Nbre`, `g_tipounidadnegocio`.`Nbre`, `persona`.`NUsuario` FROM  `g_usuario_fpz` INNER JOIN  `g_usuario`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz`.`Id_Empresa` = `g_tipoempresa`.`Id`) INNER JOIN  `g_tipounidadnegocio`  ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `g_usuario`.`Id_EmpresaCont`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `g_usuario`.`Id_Supervisor`) WHERE (`g_usuario`.`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' ) ";
            ResultSet xrs = this.xconsultasbd.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.lleno = 1;
                this.JCBEps.setSelectedItem(xrs.getString(1));
                this.JCBTipoEmpresa.setSelectedItem(xrs.getString(2));
                this.JCBUnidadNegocio.setSelectedItem(xrs.getString(3));
                this.JCBJefeInmediato.setSelectedItem(xrs.getString(4));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAIncapacidad_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLLenarCboEmpresa() {
        try {
            this.sql = "SELECT `cc_terceros`.`RazonSocialCompleta` \n , gc.Nbre  causaExterna\n , ifnull(if(gp2.Id is null, gp.Id, gp2.Id),'') codigoPatologia\n , ifnull(if(gp2.Id is null, gp.Nbre, gp2.Nbre), '') nombrePatologia\nFROM `ingreso` \nINNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\ninner  join g_causaexterna gc  on (gc.Id=ingreso.Id_CausaExterna)\ninner join h_atencion ha on (ha.Id_Ingreso =ingreso.Id)\nleft join g_patologia gp on (gp.Id=ha.Codigo_Dxp)\nleft join h_egreso_atencion hea  on (hea.Id_Atencion=ha.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) and (hea.Estado=1)\nleft join g_patologia gp2  on (gp2.Id=hea.DxP)\nWHERE (`ingreso`.`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "')";
            ResultSet xrs = this.xconsultasbd.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.JCBEps.setSelectedItem(xrs.getString(1));
                this.JCBTipoEnfermedad.setSelectedItem(xrs.getString("causaExterna"));
                this.JTFCDxP.setText(xrs.getString("codigoPatologia"));
                this.JTFNCodigoDxP.setText(xrs.getString("nombrePatologia"));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAIncapacidad_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void nuevo() {
        this.JCBEps.setSelectedIndex(-1);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.JCBUnidadNegocio.setSelectedIndex(-1);
        this.JCBJefeInmediato.setSelectedIndex(-1);
        this.JCBTipoJustificacion.setSelectedIndex(0);
        this.JCBTipoEnfermedad.setSelectedIndex(1);
        this.JTFFNit.setText((String) null);
        this.JTFFNombreEmpresa.setText((String) null);
        this.JTFFJefeInmediatoOtras.setText((String) null);
        this.JTFFFechaFin.setDate(this.hoy.getTime());
        this.JTFFNDias.setValue(new Integer(1));
        this.JTFFFechaFin.setDate(this.hoy.getTime());
        this.JTFFFechaAccidenTrabaj.setDate(this.hoy.getTime());
        this.JRBAmbulatorio.setSelected(true);
        this.JRBProrrogaNo.setSelected(true);
        this.JTFCDxP.setText((String) null);
        this.JTFNCodigoDxP.setText((String) null);
        this.JTPObservacionesIncap.setText((String) null);
        this.xtipoincapacidad = 0;
        this.JTFFEstado.setText((String) null);
        this.JTFFNIncapacidad.setText((String) null);
        this.prorroga = 0;
        this.JBSanitas.setEnabled(false);
        this.JTFFFechaParto.setDate(this.hoy.getTime());
    }

    public void grabar() {
        String natencion;
        System.out.println("si entra en el grabar");
        GEmpresa empresa = new GEmpresa();
        HTipomotivoincap hTipomotivoincap = new HTipomotivoincap();
        HTipojustificacionincap hTipojustificacionincap = new HTipojustificacionincap();
        GPatologia gPatologia = new GPatologia();
        GTipoempresa gTipoempresa = new GTipoempresa();
        GProfesional gProfesional = new GProfesional();
        AtencionEntity atencionEntity = new AtencionEntity();
        GTipounidadnegocio gTipounidadnegocio = new GTipounidadnegocio();
        if (validarComponentes() && this.JTFFNIncapacidad.getText().isEmpty()) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                natencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            } else {
                natencion = "0";
            }
            System.out.println("el id de atencion:" + natencion);
            empresa.setId(Long.valueOf(this.ideps[this.JCBEps.getSelectedIndex()]));
            GEspecialidad especialidad = new GEspecialidad();
            atencionEntity.setId(Long.valueOf(natencion));
            gTipoempresa.setId(Integer.valueOf(this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0]));
            gTipounidadnegocio.setId(Integer.valueOf(this.idunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()]));
            gPatologia.setId(this.JTFCDxP.getText());
            hTipojustificacionincap.setId(Boolean.valueOf(this.idjustificacion[this.JCBTipoJustificacion.getSelectedIndex()]));
            hTipomotivoincap.setId(Boolean.valueOf(this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][0]));
            gProfesional.setId(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()));
            especialidad.setId(Integer.valueOf(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad())));
            HIncapacidad hIncapacidad = new HIncapacidad();
            hIncapacidad.setIdUsuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
            hIncapacidad.setIdEmpresacont(empresa);
            hIncapacidad.setIdAtencion(atencionEntity);
            hIncapacidad.setIdTipoempresa(gTipoempresa);
            hIncapacidad.setIdTipounidadnegocio(gTipounidadnegocio);
            hIncapacidad.setNitTipoEmpresa(this.JTFFNit.getText());
            hIncapacidad.setNbreEmpresa(this.JTFFNombreEmpresa.getText());
            hIncapacidad.setFechaInicio(this.JTFFFechaInicio.getDate());
            hIncapacidad.setFechaFin(this.JTFFFechaFin.getDate());
            hIncapacidad.setNDias(Integer.valueOf(Integer.parseInt(this.JTFFNDias.getValue().toString())));
            hIncapacidad.setEsProrroga(Boolean.valueOf(String.valueOf(this.prorroga)));
            hIncapacidad.setTipoIncapacidad(hTipojustificacionincap.getId());
            hIncapacidad.setIdPatologia(gPatologia);
            hIncapacidad.setIdMotivoincap(hTipomotivoincap);
            hIncapacidad.setFechaAt(this.JTFFFechaAccidenTrabaj.getDate());
            hIncapacidad.setIdSupervisor(Long.valueOf(this.idsupervisor[this.JCBJefeInmediato.getSelectedIndex()]));
            hIncapacidad.setJefeInmediato(this.JTFFJefeInmediatoOtras.getText());
            hIncapacidad.setIdTipoJustificacion(hTipojustificacionincap);
            hIncapacidad.setObservacion(this.JTPObservacionesIncap.getText());
            hIncapacidad.setIdProfesional(gProfesional);
            hIncapacidad.setIdEspecialidad(especialidad);
            hIncapacidad.setTipoAfiliacion(Boolean.valueOf("0"));
            hIncapacidad.setFecha(this.xmetodo.getFechaActual());
            hIncapacidad.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            hIncapacidad.setEstado(false);
            hIncapacidad.setObservacion(this.JTPObservacionesIncap.getText());
            hIncapacidad.setFechaRegistroSanitas(this.xmetodo.getFechaActual());
            hIncapacidad.setFechaParto(this.xmetodo.formatoAMDH24.format(this.JTFFFechaParto.getDate()));
            hIncapacidad.setEdadGestacional(this.JTFFEdadGestacional.getValue().toString());
            hIncapacidad.setEmbarazoMultiple(Boolean.valueOf(String.valueOf(this.multiple)));
            hIncapacidad.setNumeroNacidos(Integer.valueOf(this.JTFFNacidos.getValue().toString()));
            hIncapacidad.setNumeroCertificadoNacido(this.JTFNCertificado.getText());
            this.sql = "insert into h_incapacidad (Id_Usuario, Id_EmpresaCont,IdAtencion, Id_TipoEmpresa, Id_TipoUnidadNegocio, NitTipoEmpresa, NbreEmpresa, FechaInicio, NDias, FechaFin, EsProrroga, TipoIncapacidad, Id_Patologia, Id_MotivoIncap, FechaAt, JefeInmediato, Id_Supervisor, IdTipoJustificacion, Observacion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS,fechaParto,edadGestacional,embarazoMultiple,numeroNacidos,numeroCertificadoNacido,DiagnosticoR1,DiagnosticoR2,DiagnosticoR3) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.ideps[this.JCBEps.getSelectedIndex()] + "','" + natencion + "','" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "','" + this.idunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.JTFFNit.getText() + "','" + this.JTFFNombreEmpresa.getText() + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaInicio.getDate()) + "','" + this.JTFFNDias.getValue() + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaFin.getDate()) + "','" + this.prorroga + "','" + this.xtipoincapacidad + "','" + this.JTFCDxP.getText() + "','" + this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][0] + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaAccidenTrabaj.getDate()) + "','" + this.JTFFJefeInmediatoOtras.getText() + "','" + this.idsupervisor[this.JCBJefeInmediato.getSelectedIndex()] + "','" + this.idjustificacion[this.JCBTipoJustificacion.getSelectedIndex()] + "','" + this.JTPObservacionesIncap.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.JTFFFechaParto.getDate()) + "','" + this.JTFFEdadGestacional.getValue().toString() + "'," + Boolean.valueOf(String.valueOf(this.multiple)) + "," + Integer.valueOf(this.JTFFNacidos.getValue().toString()) + ",'" + this.JTFNCertificado.getText() + "','" + this.JTFCDxP1.getText() + "','" + this.JTFCDxP2.getText() + "','" + this.JTFCDxP3.getText() + "')";
            this.JTFFNIncapacidad.setText(this.xconsultasbd.ejecutarSQLId(this.sql));
            this.xconsultasbd.cerrarConexionBd();
            this.JTFFEstado.setText("ACTIVA");
            this.JBSanitas.setEnabled(true);
        }
    }

    public void mGuardadDatosIncapacidadManuales(String natencion, String xidusuario) {
        new Metodos();
        if (this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][1].equals("1")) {
            this.sql = "insert into h_incapacidad (Id_Usuario, Id_EmpresaCont, IdAtencion, Id_TipoEmpresa, Id_TipoUnidadNegocio, FechaInicio, NDias, FechaFin, EsProrroga, TipoIncapacidad, Id_Patologia, Id_MotivoIncap, FechaAt, Id_Supervisor, IdTipoJustificacion, Observacion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ('" + xidusuario + "','" + this.ideps[this.JCBEps.getSelectedIndex()] + "','" + natencion + "','" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "','" + this.idunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaInicio.getDate()) + "','" + this.JTFFNDias.getValue() + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaFin.getDate()) + "','" + this.prorroga + "','" + this.xtipoincapacidad + "','" + this.JTFCDxP.getText() + "','" + this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][0] + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaAccidenTrabaj.getDate()) + "','" + this.idsupervisor[this.JCBJefeInmediato.getSelectedIndex()] + "','" + this.idjustificacion[this.JCBTipoJustificacion.getSelectedIndex()] + "','" + this.JTPObservacionesIncap.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        } else {
            this.sql = "insert into h_incapacidad (Id_Usuario, Id_EmpresaCont, IdAtencion, Id_TipoEmpresa,Id_TipoUnidadNegocio, NitTipoEmpresa, NbreEmpresa, FechaInicio, NDias, FechaFin, EsProrroga, TipoIncapacidad, Id_Patologia, Id_MotivoIncap, FechaAt, JefeInmediato, Id_Supervisor, IdTipoJustificacion, Observacion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ('" + xidusuario + "','" + this.ideps[this.JCBEps.getSelectedIndex()] + "','" + natencion + "','" + this.idtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "','" + this.idunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.JTFFNit.getText() + "','" + this.JTFFNombreEmpresa.getText() + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaInicio.getDate()) + "','" + this.JTFFNDias.getValue() + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaFin.getDate()) + "','" + this.prorroga + "','" + this.xtipoincapacidad + "','" + this.JTFCDxP.getText() + "','" + this.idtipoenfermedad[this.JCBTipoEnfermedad.getSelectedIndex()][0] + "','" + this.xmetodo.formatoAMD.format(this.JTFFFechaAccidenTrabaj.getDate()) + "','" + this.JTFFJefeInmediatoOtras.getText() + "','" + this.idsupervisor[this.JCBJefeInmediato.getSelectedIndex()] + "','" + this.idjustificacion[this.JCBTipoJustificacion.getSelectedIndex()] + "','" + this.JTPObservacionesIncap.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        }
        this.JTFFEstado.setText("ACTIVA");
        Principal.txtEstado.setText("ACTIVA");
        this.JTFFNIncapacidad.setText(this.xconsultasbd.ejecutarSQLId(this.sql));
        Principal.txtNo.setText(this.JTFFNIncapacidad.getText());
        this.JBSanitas.setEnabled(true);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void imprimir() {
        if (!this.JTFFNIncapacidad.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "INCAPACIDAD", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = this.JTFFNIncapacidad.getText();
                mparametros[1][0] = "nota";
                mparametros[1][1] = "EPS";
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RIncapacidad", mparametros);
                    return;
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RIncapacidad_nuevo", mparametros);
                    return;
                }
            }
            if (n == 1) {
                String[][] mparametros2 = new String[4][2];
                mparametros2[0][0] = "norden";
                mparametros2[0][1] = this.JTFFNIncapacidad.getText();
                mparametros2[1][0] = "nota";
                mparametros2[1][1] = "Correo";
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RIncapacidad", mparametros2);
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RIncapacidad_nuevo", mparametros2);
                }
            }
        }
    }

    public void anular() {
        if (this.JTFFNIncapacidad.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "No existe N° Incapacidad Activo", "ANULAR INCAPACIDAD", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        int xver = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Anular ? ", "ANULACIÓN", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (xver == 0) {
            this.sql = "UPDATE h_incapacidad SET Estado = 1 WHERE(Id ='" + this.JTFFNIncapacidad.getText() + "')";
            this.xconsultasbd.ejecutarSQL(this.sql);
            this.xconsultasbd.cerrarConexionBd();
            this.JTFFEstado.setText("ANULADA");
        }
    }

    public void mVerificarIncapacidadActiva() {
        try {
            ResultSet rs = this.xconsultasbd.traerRs("SELECT  `g_usuario`.`NoHistoria`, MAX(DATE_FORMAT(`h_incapacidad`.`FechaFin`,'%d-%m-%Y')) AS ultima_inc FROM `h_incapacidad`  INNER JOIN `g_usuario`  ON (`h_incapacidad`.`Id_Usuario` = `g_usuario`.`Id_persona`) WHERE (`g_usuario`.`NoHistoria` =q)");
            rs.next();
            if (rs.getRow() != 0) {
                rs.getString(2);
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAIncapacidad_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscarIncapacidad(String id) {
        try {
            nuevo();
            this.sql = "SELECT h_incapacidad.Id AS Id, cc_terceros.RazonSocialCompleta AS NEps, g_tipoempresa.Nbre AS NTipoEmpregsa, g_tipounidadnegocio.Nbre AS NUnidadNegocio, g_tipoempresa.NIT, h_incapacidad.NbreEmpresa, h_incapacidad.FechaInicio, h_incapacidad.NDias, h_incapacidad.FechaFin, h_incapacidad.EsProrroga , h_incapacidad.TipoIncapacidad, h_incapacidad.Id_Patologia, g_patologia.Nbre, h_tipomotivoincap.Nbre AS NMotivoIncp, h_incapacidad.FechaAt, h_incapacidad.Id_Supervisor, h_incapacidad.JefeInmediato , h_tipojustificacionincap.Nbre AS NJustificacion, h_incapacidad.Observacion, h_incapacidad.Estado,h_incapacidad.Id FROM persona INNER JOIN h_incapacidad ON (persona.Id_persona = h_incapacidad.Id_Usuario)INNER JOIN profesional ON (profesional.Id_Persona = h_incapacidad.Id_Profesional)LEFT JOIN supervisor ON (supervisor.Id_Persona = h_incapacidad.Id_Supervisor)INNER JOIN cc_terceros   ON (h_incapacidad.Id_EmpresaCont = cc_terceros.Id)  INNER JOIN g_tipoempresa  ON (h_incapacidad.Id_TipoEmpresa = g_tipoempresa.Id)  INNER JOIN g_tipounidadnegocio  ON (g_tipounidadnegocio.Id = h_incapacidad.Id_TipoUnidadNegocio) INNER JOIN h_tipojustificacionincap ON (h_incapacidad.IdTipoJustificacion = h_tipojustificacionincap.Id)INNER JOIN h_tipomotivoincap ON (h_incapacidad.Id_MotivoIncap = h_tipomotivoincap.Id)INNER JOIN g_patologia ON (h_incapacidad.Id_Patologia = g_patologia.Id) WHERE (h_incapacidad.Id ='" + id + "') ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet rs = xct.traerRs(this.sql);
            rs.next();
            if (rs.getRow() != 0) {
                this.JTFFNIncapacidad.setValue(Integer.valueOf(rs.getInt(1)));
                this.JCBEps.setSelectedItem(rs.getString(2));
                this.JCBTipoEmpresa.setSelectedItem(rs.getString(3));
                this.JCBUnidadNegocio.setSelectedItem(rs.getString(4));
                this.JTFFNit.setText(rs.getString(5));
                this.JTFFNombreEmpresa.setText(rs.getString(6));
                this.JCBJefeInmediato.setSelectedItem(rs.getString(16));
                this.JTFFJefeInmediatoOtras.setText(rs.getString(17));
                this.JTFFFechaInicio.setDate(rs.getDate(7));
                this.JTFFNDias.setValue(Integer.valueOf(rs.getInt(8)));
                this.JTFFFechaFin.setDate(rs.getDate(9));
                if (rs.getInt(10) == 1) {
                    this.JRBProrrogaSi.setSelected(true);
                } else {
                    this.JRBProrrogaNo.setSelected(true);
                }
                if (rs.getInt(11) == 1) {
                    this.JRBHospitalizado.setSelected(true);
                } else {
                    this.JRBAmbulatorio.setSelected(true);
                }
                this.JTFCDxP.setText(rs.getString(12));
                this.JTFNCodigoDxP.setText(rs.getString(13));
                this.JCBTipoEnfermedad.setSelectedItem(rs.getString(14));
                this.JCBTipoJustificacion.setSelectedItem(rs.getString(18));
                this.JTPObservacionesIncap.setText(rs.getString(19));
                if (rs.getInt(20) == 1) {
                    this.JTFFEstado.setValue("ANULADA");
                } else {
                    this.JTFFEstado.setValue("ACTIVA");
                }
                this.JBSanitas.setEnabled(true);
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAIncapacidad_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void buscar() {
        try {
            Component jIFConsultarInforOtros = new JIFConsultarInforOtros(this.xclase, getName());
            Principal.PanelPpal.add(jIFConsultarInforOtros, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarInforOtros.setVisible(true);
            jIFConsultarInforOtros.setSelected(true);
            if (!this.JTFFNIncapacidad.getText().isEmpty()) {
                this.JBSanitas.setEnabled(true);
            }
        } catch (PropertyVetoException e) {
        }
    }

    public void mImprimirS() {
        String vnota;
        if (!this.JTFFNIncapacidad.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    vnota = "USUARIO";
                } else if (i == 1) {
                    vnota = "EPS";
                } else {
                    vnota = "HISTORIA CLINICA";
                }
                mparametros[0][0] = "norden";
                mparametros[0][1] = this.JTFFNIncapacidad.getText();
                mparametros[1][0] = "nota";
                mparametros[1][1] = vnota;
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RIncapacidad.jasper", mparametros);
                } else {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RIncapacidad_1.jasper", mparametros);
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.sql.ResultSet] */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.sql.ResultSet] */
    public void mVerificarCruceIncapacidades() {
        Object obj;
        System.out.println("" + this.xnombre);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String str = "SELECT Id_Usuario, DATEDIFF(FechaFin, now()) as rs,FechaFin FROM h_incapacidad WHERE (Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and DATEDIFF(FechaFin, now())>0)";
        System.out.println(str);
        try {
            ResultSet resultSetTraerRs = this.xconsultasbd.traerRs(str);
            Throwable th = null;
            try {
                if (resultSetTraerRs.next()) {
                    if (this.xnombre.equals("jifhistoriaclinica")) {
                        JOptionPane.showInternalMessageDialog(this.xclase.xjifhistoriaclinica, "Usuario con dias de incapacidad vigente \n Favor consulte las incapacidades \n Para evitar duplicidad", "verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    } else if (this.xnombre.equals("xjifregincapacidad")) {
                        JOptionPane.showInternalMessageDialog(this.xclase.xjifincapacidad, "Usuario con dias de incapacidad vigente \n Favor consulte las incapacidades \n Para evitar duplicidad", "verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                }
                if (resultSetTraerRs != null) {
                    if (0 != 0) {
                        try {
                            resultSetTraerRs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        resultSetTraerRs.close();
                    }
                }
                obj = resultSetTraerRs;
            } catch (Throwable th3) {
                if (resultSetTraerRs != null) {
                    if (0 != 0) {
                        try {
                            resultSetTraerRs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        resultSetTraerRs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException e) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
            obj = e;
        }
        String str2 = "SELECT count(Id) as NI FROM h_incapacidad WHERE (Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND year(FechaInicio) >='" + simpleDateFormat.format(this.hoy.getTime()) + "' AND Estado =0) GROUP BY Id_Usuario";
        System.out.println(str2);
        try {
            try {
                ResultSet resultSetTraerRs2 = this.xconsultasbd.traerRs(str2);
                Throwable th5 = null;
                if (resultSetTraerRs2.next()) {
                    if (this.xnombre.equals("jifhistoriaclinica")) {
                        JOptionPane.showInternalMessageDialog(this.xclase.xjifhistoriaclinica, "Usuario ha tenido " + resultSetTraerRs2.getString(1) + " inpacidades en el ultimo año \n Favor consulte las incapacidades ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    } else if (this.xnombre.equals("xjifregincapacidad")) {
                        JOptionPane.showInternalMessageDialog(this.xclase.xjifincapacidad, "Usuario ha tenido " + resultSetTraerRs2.getString(1) + " inpacidades en el ultimo año \n Favor consulte las incapacidades ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                }
                if (resultSetTraerRs2 != null) {
                    if (0 != 0) {
                        try {
                            resultSetTraerRs2.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    } else {
                        resultSetTraerRs2.close();
                    }
                }
            } finally {
            }
        } catch (SQLException e2) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
        }
    }

    private void mCrearArchivos() {
        if (!this.JTFFNIncapacidad.getText().isEmpty() && this.JCBTipoEmpresa.getSelectedItem().equals("CMSA") && Integer.valueOf(this.JTFFNDias.getValue().toString()).intValue() > 5) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Usuario con 5 o más días de incapacidad;\nse enviará correo de notificación a salud ocupacional", "ALERTA BLOQUEO DE CARNET", 0, 3);
            if (x == 0) {
                String[][] parametros = new String[1][2];
                parametros[0][0] = "norden";
                parametros[0][1] = this.JTFFNIncapacidad.getText();
                this.xmetodo.mEliminarArchivo(new File(this.xmetodo.getRutaRep() + this.JTFFNIncapacidad.getText() + ".pdf"));
                this.xmetodo.CrearPDF(this.xmetodo.getRutaRep() + "RIncapacidad", parametros, this.xmetodo.getRutaRep() + this.JTFFNIncapacidad.getText());
                String adjunto = this.xmetodo.getRutaRep() + this.JTFFNIncapacidad.getText() + ".pdf";
                File f1 = new File(this.xmetodo.getRutaRep() + "/RIncapacidad.pdf");
                File f2 = new File(adjunto);
                f1.renameTo(f2);
                String[] xdestino = {"cmsa_incapacidad", "evidencia@fundacionpanzenu.org.co"};
                Email xenviar = new Email();
                String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                xenviar.enviarAdjunto(xdestino, "Favor inactivar carné de acceso del trabajadores(ver adjunto), por presentar incapacidad mayor a 5 días;  para reingresar a CMSA, esta persona deberá pasar PREVIAMENTE a valoración en Salud Ocupacional, que en caso de aprobarlo enviará un mail a usted solicitando desbloquear dicho acceso.", remite, "BLOQUEAR CARNÉ POR INCAPACIDAD N° " + this.JTFFNIncapacidad.getText(), this.JTFFNIncapacidad.getText() + ".pdf", this.xmetodo.getRutaRep() + this.JTFFNIncapacidad.getText() + ".pdf");
                this.xmetodo.mEliminarArchivo(new File(this.xmetodo.getRutaRep() + this.JTFFNIncapacidad.getText() + ".pdf"));
            }
        }
    }
}
