package Historia;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Odontologia.JPOdontograma;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import com.genoma.plus.controller.historia.JPTriageRespiratorio;
import com.genoma.plus.controller.historia.JPTriageRespiratorio_V2;
import com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dto.facturacion.IngresoOrdenSalidaDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPITriageP.class */
public class JPITriageP extends JPanel {
    private int clasificacion;
    private String xsql;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private PatologiaCie10DAO xPatologiaCie10DAO;
    private Object[] xdatos;
    private JPTriageRespiratorio_V2 triageRespiratorio_V2;
    private JPTriageRespiratorio triageRespiratorio;
    private IngresoOrdenSalidaDAO ingresoOrdenSalidaDAO;
    public boolean nTriage;
    private DefaultTableModel modelo;
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private int nfila;
    private int columna;
    private int estadob;
    private int xValidacion;
    Object jppatologias;
    Object jifhistoria;
    private String xnombre;
    JTextField codigo;
    JTextField nombrep;
    JTable tabla;
    String idcofides;
    int nidcofides;
    private JPSo_Osteomuscular xclase;
    private JPOdontograma xJPOdontograma;
    JComboBox xcombo;
    private String[][] xid_pabellon;
    private String[][] xid_cama;
    private boolean xlleno;
    private JButton JBTGuardarTemp1;
    private JComboBox JCB_ACama;
    private JComboBox JCB_APabellon;
    private JCheckBox JCHAplicaTestRespiratorio;
    private JCheckBox JCHContiene;
    private JCheckBox JCHEmpieza;
    private JCheckBox JCHFiltroPrograma;
    public JCheckBox JCH_SParto;
    private JCheckBox JCH_SinValidacionSignos;
    private JDateChooser JDCFecha;
    public JFormattedTextField JFTFNombrePatologia;
    private JLabel JLBNRegistroC;
    private JLabel JLBPBSentado;
    private JPanel JPDiagnostico1;
    private JPanel JPIClasificacion;
    private JPanel JPIDatosBuscar;
    private JPanel JPIFBusqueda;
    private JPanel JPIPresion;
    private JPanel JPI_DatosTriage;
    private JPanel JPI_TriageRespiratorio;
    private JPanel JPSignosVitales;
    private JSpinner JSOrden;
    private JScrollPane JSPDiagnostico;
    private JScrollPane JSPMotivoC;
    private JScrollPane JSPResultado;
    private JTextArea JTAMotivoC;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFPDiastolica;
    private JFormattedTextField JTFFPSistolica;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNTriage;
    private JTabbedPane JTPMenu;
    private JTabbedPane JTP_DatosUrgencias;
    private JTable JTResultado;
    private JButton btnAmarillo;
    private JButton btnNaranja;
    private JButton btnNegro;
    private JButton btnRojo;
    private JButton btnVerde;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;

    public JPITriageP() {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        springStart();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTAMotivoC);
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
        this.JTFNTriage.setText("0");
        cargarPanelTraigeRespiratorio();
        mCargarTriage();
        mCargarDatosTabla();
        mClasificar_SalaPArto();
        nuevo();
        this.JTP_DatosUrgencias.setEnabledAt(1, false);
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == -1) {
            this.JCHAplicaTestRespiratorio.setVisible(false);
            this.JTP_DatosUrgencias.remove(1);
        }
        this.nTriage = (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText() == null || this.JTFNTriage.getText().equals("0")) ? false : true;
    }

    public JPITriageP(Object jppatologias, String nombre, JTextField codigo, JTextField nombrep, Object jifhistoria, String idcofides) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.jppatologias = jppatologias;
        this.jifhistoria = jifhistoria;
        this.xnombre = nombre;
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.idcofides = idcofides;
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("CodFides");
        this.modelo.addRow(this.dato);
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(5);
        nuevo();
    }

    public JPITriageP(Object jppatologias, String nombre, JTextField codigo, JTextField nombrep, Object jifhistoria, int nidcofides) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.jppatologias = jppatologias;
        this.jifhistoria = jifhistoria;
        this.xnombre = nombre;
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.nidcofides = nidcofides;
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre");
        this.modelo.addRow(this.dato);
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(500);
        nuevo();
    }

    public JPITriageP(Object jppatologias, String xnombrellamador) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.jppatologias = jppatologias;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
        nuevo();
    }

    public JPITriageP(JTextField codigo, JTextField nombrep, String xnombrellamador, int xValidacion) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.xValidacion = xValidacion;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        if (xValidacion == 1) {
            this.JCHFiltroPrograma.setSelected(true);
        } else {
            this.JCHFiltroPrograma.setVisible(false);
        }
        this.JFTFNombrePatologia.requestFocus();
        nuevo();
    }

    public JPITriageP(JTextField codigo, String xnombrellamador) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.codigo = codigo;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
        nuevo();
    }

    public JPITriageP(JPSo_Osteomuscular xclase, String xnombrellamador) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
        nuevo();
    }

    public JPITriageP(JPOdontograma xJPOdontograma, String xnombrellamador) {
        this.clasificacion = -1;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        this.xlleno = false;
        initComponents();
        this.xJPOdontograma = xJPOdontograma;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
        nuevo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xPatologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.ingresoOrdenSalidaDAO = (IngresoOrdenSalidaDAOImpl) classPathXmlApplicationContext.getBean("ingresoOrdenSalidaDAO");
    }

    /* JADX WARN: Type inference failed for: r3v100, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_DatosUrgencias = new JTabbedPane();
        this.JPI_DatosTriage = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIPresion = new JPanel();
        this.JTFFPSistolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JTFFPDiastolica = new JFormattedTextField();
        this.JCH_SParto = new JCheckBox();
        this.JPSignosVitales = new JPanel();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JTPMenu = new JTabbedPane();
        this.JSPMotivoC = new JScrollPane();
        this.JTAMotivoC = new JTextArea();
        this.JPDiagnostico1 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JSPDiagnostico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardarTemp1 = new JButton();
        this.JSOrden = new JSpinner();
        this.JTFNCodigoDxP = new JTextField();
        this.jPanel1 = new JPanel();
        this.JPIDatosBuscar = new JPanel();
        this.JFTFNombrePatologia = new JFormattedTextField();
        this.JPIFBusqueda = new JPanel();
        this.JCHEmpieza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JCHFiltroPrograma = new JCheckBox();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JCHAplicaTestRespiratorio = new JCheckBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIClasificacion = new JPanel();
        this.btnNegro = new JButton();
        this.btnVerde = new JButton();
        this.btnAmarillo = new JButton();
        this.btnNaranja = new JButton();
        this.btnRojo = new JButton();
        this.JTFNTriage = new JTextField();
        this.jPanel2 = new JPanel();
        this.JCB_APabellon = new JComboBox();
        this.JCB_ACama = new JComboBox();
        this.JLBNRegistroC = new JLabel();
        this.JCH_SinValidacionSignos = new JCheckBox();
        this.JPI_TriageRespiratorio = new JPanel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN TRIAGE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjptriage");
        this.JTP_DatosUrgencias.setForeground(Color.red);
        this.JTP_DatosUrgencias.setFont(new Font("Arial", 1, 14));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFFPSistolica.setHorizontalAlignment(4);
        this.JTFFPSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPSistolica.setName("fechanaciemiento");
        this.JTFFPSistolica.setValue(new Integer(0));
        this.JTFFPSistolica.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.1
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFPSistolicaActionPerformed(evt);
            }
        });
        this.JTFFPSistolica.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.2
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFPSistolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriageP.this.JTFFPSistolicaFocusLost(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JTFFPDiastolica.setHorizontalAlignment(4);
        this.JTFFPDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPDiastolica.setName("fechanaciemiento");
        this.JTFFPDiastolica.setValue(new Integer(0));
        this.JTFFPDiastolica.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.3
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFPDiastolicaFocusGained(evt);
            }
        });
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFPSistolica, -2, 60, -2).addGap(7, 7, 7).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFPDiastolica, -2, 60, -2).addContainerGap(27, 32767)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSistolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPDiastolica, -2, 25, -2)).addGap(0, 3, 32767)));
        this.JCH_SParto.setFont(new Font("Arial", 1, 12));
        this.JCH_SParto.setForeground(Color.red);
        this.JCH_SParto.setText("S. Parto");
        this.JCH_SParto.setToolTipText("Poner o Quitar clasificación para sala de partos solo si es materna");
        this.JCH_SParto.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.4
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCH_SPartoActionPerformed(evt);
            }
        });
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.5
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriageP.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.6
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.7
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFSFrActionPerformed(evt);
            }
        });
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.8
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.9
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.10
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.11
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.12
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.13
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.14
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriageP.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.15
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.16
            public void focusGained(FocusEvent evt) {
                JPITriageP.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriageP.this.JTFFSPesoFocusLost(evt);
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
        GroupLayout JPSignosVitalesLayout = new GroupLayout(this.JPSignosVitales);
        this.JPSignosVitales.setLayout(JPSignosVitalesLayout);
        JPSignosVitalesLayout.setHorizontalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFFSFc, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFSFr, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFTemperatura, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFPs2, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFSTalla, -2, 90, -2).addGap(3, 3, 3).addComponent(this.JTFFSPeso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFSIMC, -2, 100, -2).addContainerGap()));
        JPSignosVitalesLayout.setVerticalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2)).addComponent(this.JTFFSIMC, -2, 50, -2))));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTAMotivoC.setColumns(20);
        this.JTAMotivoC.setFont(new Font("Arial", 1, 12));
        this.JTAMotivoC.setLineWrap(true);
        this.JTAMotivoC.setRows(1);
        this.JTAMotivoC.setTabSize(1);
        this.JTAMotivoC.setBorder((Border) null);
        this.JTAMotivoC.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriageP.17
            public void keyPressed(KeyEvent evt) {
                JPITriageP.this.JTAMotivoCKeyPressed(evt);
            }
        });
        this.JSPMotivoC.setViewportView(this.JTAMotivoC);
        this.JTPMenu.addTab("MOTIVO DE CONSULTA", this.JSPMotivoC);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriageP.18
            public void focusLost(FocusEvent evt) {
                JPITriageP.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriageP.19
            public void keyPressed(KeyEvent evt) {
                JPITriageP.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPITriageP.20
            public void mouseClicked(MouseEvent evt) {
                JPITriageP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriageP.21
            public void keyPressed(KeyEvent evt) {
                JPITriageP.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setViewportView(this.JTDetalle);
        this.JBTGuardarTemp1.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp1.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.22
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JBTGuardarTemp1ActionPerformed(evt);
            }
        });
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPITriageP.23
            public void mouseClicked(MouseEvent evt) {
                JPITriageP.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.24
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JTFNCodigoDxPActionPerformed(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriageP.25
            public void keyPressed(KeyEvent evt) {
                JPITriageP.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        GroupLayout JPDiagnostico1Layout = new GroupLayout(this.JPDiagnostico1);
        this.JPDiagnostico1.setLayout(JPDiagnostico1Layout);
        JPDiagnostico1Layout.setHorizontalGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico1Layout.createSequentialGroup().addContainerGap().addGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDiagnostico, -1, 757, 32767).addGroup(JPDiagnostico1Layout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 63, -2).addGap(18, 18, 18).addComponent(this.JTFNCodigoDxP).addGap(18, 18, 18).addComponent(this.JSOrden, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemp1, -2, 52, -2))).addContainerGap()));
        JPDiagnostico1Layout.setVerticalGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGuardarTemp1, -1, -1, 32767).addComponent(this.JTFCDxP).addGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSOrden, -2, 0, 32767).addComponent(this.JTFNCodigoDxP, -2, 43, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDiagnostico, -1, 165, 32767)));
        this.JTPMenu.addTab("DIAGNÓSTICOS", this.JPDiagnostico1);
        this.JPIDatosBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JFTFNombrePatologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFNombrePatologia.setFont(new Font("Arial", 1, 12));
        this.JFTFNombrePatologia.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriageP.26
            public void keyPressed(KeyEvent evt) {
                JPITriageP.this.JFTFNombrePatologiaKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPITriageP.this.JFTFNombrePatologiaKeyReleased(evt);
            }
        });
        this.JPIFBusqueda.setBorder(BorderFactory.createEtchedBorder(Color.white, (Color) null));
        this.JCHEmpieza.setFont(new Font("Arial", 1, 12));
        this.JCHEmpieza.setForeground(Color.blue);
        this.JCHEmpieza.setSelected(true);
        this.JCHEmpieza.setText("Comienza por");
        this.JCHEmpieza.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.27
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCHEmpiezaActionPerformed(evt);
            }
        });
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setForeground(Color.blue);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.28
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JCHFiltroPrograma.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPrograma.setForeground(Color.blue);
        this.JCHFiltroPrograma.setSelected(true);
        this.JCHFiltroPrograma.setText("Filtro por porgrama");
        this.JCHFiltroPrograma.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.29
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCHFiltroProgramaActionPerformed(evt);
            }
        });
        GroupLayout JPIFBusquedaLayout = new GroupLayout(this.JPIFBusqueda);
        this.JPIFBusqueda.setLayout(JPIFBusquedaLayout);
        JPIFBusquedaLayout.setHorizontalGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFBusquedaLayout.createSequentialGroup().addComponent(this.JCHContiene).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEmpieza)).addGroup(JPIFBusquedaLayout.createSequentialGroup().addComponent(this.JCHFiltroPrograma).addGap(0, 0, 32767))).addContainerGap()));
        JPIFBusquedaLayout.setVerticalGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHContiene).addComponent(this.JCHEmpieza)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroPrograma).addContainerGap()));
        GroupLayout JPIDatosBuscarLayout = new GroupLayout(this.JPIDatosBuscar);
        this.JPIDatosBuscar.setLayout(JPIDatosBuscarLayout);
        JPIDatosBuscarLayout.setHorizontalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JFTFNombrePatologia, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIFBusqueda, -2, -1, -2).addContainerGap(40, 32767)));
        JPIDatosBuscarLayout.setVerticalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JFTFNombrePatologia, -2, 50, -2).addContainerGap(-1, 32767)).addComponent(this.JPIFBusqueda, -1, -1, 32767));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JPITriageP.30
            public void mouseClicked(MouseEvent evt) {
                JPITriageP.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBuscar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPResultado)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBuscar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPResultado, -2, 123, -2).addGap(130, 130, 130)));
        this.JTPMenu.addTab("PATOLOGÍA", this.jPanel1);
        this.JCHAplicaTestRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaTestRespiratorio.setForeground(Color.red);
        this.JCHAplicaTestRespiratorio.setText("Aplica Test Respiratorio?");
        this.JCHAplicaTestRespiratorio.setToolTipText("Aplica triage respiratorio (SARS-Cov-2)");
        this.JCHAplicaTestRespiratorio.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.31
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCHAplicaTestRespiratorioActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.btnNegro.setFont(new Font("Arial", 1, 14));
        this.btnNegro.setText("5");
        this.btnNegro.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.32
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.btnNegroActionPerformed(evt);
            }
        });
        this.btnVerde.setBackground(Color.green);
        this.btnVerde.setFont(new Font("Arial", 1, 14));
        this.btnVerde.setForeground(new Color(0, 0, 204));
        this.btnVerde.setText("4");
        this.btnVerde.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.33
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.btnVerdeActionPerformed(evt);
            }
        });
        this.btnAmarillo.setBackground(new Color(255, 255, 0));
        this.btnAmarillo.setFont(new Font("Arial", 1, 14));
        this.btnAmarillo.setForeground(new Color(0, 0, 204));
        this.btnAmarillo.setText("3");
        this.btnAmarillo.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.34
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.btnAmarilloActionPerformed(evt);
            }
        });
        this.btnNaranja.setBackground(Color.orange);
        this.btnNaranja.setFont(new Font("Arial", 1, 14));
        this.btnNaranja.setForeground(new Color(0, 0, 204));
        this.btnNaranja.setText("2");
        this.btnNaranja.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.35
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.btnNaranjaActionPerformed(evt);
            }
        });
        this.btnRojo.setBackground(Color.red);
        this.btnRojo.setFont(new Font("Arial", 1, 14));
        this.btnRojo.setForeground(new Color(0, 0, 204));
        this.btnRojo.setText("1");
        this.btnRojo.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.36
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.btnRojoActionPerformed(evt);
            }
        });
        this.JTFNTriage.setEditable(false);
        this.JTFNTriage.setFont(new Font("Arial", 1, 24));
        this.JTFNTriage.setHorizontalAlignment(0);
        this.JTFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIClasificacionLayout = new GroupLayout(this.JPIClasificacion);
        this.JPIClasificacion.setLayout(JPIClasificacionLayout);
        JPIClasificacionLayout.setHorizontalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.btnRojo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNaranja, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAmarillo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnVerde, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNegro, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.JTFNTriage, -2, 158, -2).addGap(16, 16, 16)));
        JPIClasificacionLayout.setVerticalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNTriage, -2, 64, -2).addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnVerde, -1, -1, 32767).addComponent(this.btnNegro, -1, -1, 32767).addComponent(this.btnNaranja, -1, -1, 32767).addComponent(this.btnRojo, -1, -1, 32767).addComponent(this.btnAmarillo, -2, 70, -2))).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("CLASIFICACIÓN", this.JPIClasificacion);
        this.JCB_APabellon.setFont(new Font("Arial", 1, 12));
        this.JCB_APabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_APabellon.addItemListener(new ItemListener() { // from class: Historia.JPITriageP.37
            public void itemStateChanged(ItemEvent evt) {
                JPITriageP.this.JCB_APabellonItemStateChanged(evt);
            }
        });
        this.JCB_APabellon.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.38
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCB_APabellonActionPerformed(evt);
            }
        });
        this.JCB_ACama.setFont(new Font("Arial", 1, 12));
        this.JCB_ACama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_ACama.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.39
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCB_ACamaActionPerformed(evt);
            }
        });
        this.JLBNRegistroC.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistroC.setForeground(new Color(255, 0, 0));
        this.JLBNRegistroC.setHorizontalAlignment(0);
        this.JLBNRegistroC.setBorder(BorderFactory.createTitledBorder((Border) null, "Registro N°", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCB_APabellon, -2, 348, -2).addGap(18, 18, 18).addComponent(this.JCB_ACama, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JLBNRegistroC, -2, 157, -2).addGap(16, 16, 16)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(28, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNRegistroC, -2, 52, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_APabellon, -2, 50, -2).addComponent(this.JCB_ACama, -2, 50, -2))).addGap(13, 13, 13)));
        this.jTabbedPane1.addTab("ASIGNACIÓN SERVICIO", this.jPanel2);
        this.JCH_SinValidacionSignos.setFont(new Font("Arial", 1, 12));
        this.JCH_SinValidacionSignos.setForeground(Color.red);
        this.JCH_SinValidacionSignos.setText("Sin Signos Vitales");
        this.JCH_SinValidacionSignos.addActionListener(new ActionListener() { // from class: Historia.JPITriageP.40
            public void actionPerformed(ActionEvent evt) {
                JPITriageP.this.JCH_SinValidacionSignosActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosTriageLayout = new GroupLayout(this.JPI_DatosTriage);
        this.JPI_DatosTriage.setLayout(JPI_DatosTriageLayout);
        JPI_DatosTriageLayout.setHorizontalGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTPMenu)).addComponent(this.jTabbedPane1).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addComponent(this.JPSignosVitales, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIPresion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addComponent(this.JCH_SParto).addGap(37, 37, 37).addComponent(this.JCH_SinValidacionSignos).addGap(0, 0, 32767)).addComponent(this.JCHAplicaTestRespiratorio, -1, -1, 32767)))).addContainerGap()));
        JPI_DatosTriageLayout.setVerticalGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JDCFecha, -2, 50, -2)).addComponent(this.JPIPresion, -2, -1, -2).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SParto, -2, 20, -2).addComponent(this.JCH_SinValidacionSignos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAplicaTestRespiratorio))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSignosVitales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenu, -2, 266, 32767).addGap(11, 11, 11).addComponent(this.jTabbedPane1, -2, 124, -2).addContainerGap()));
        this.JTP_DatosUrgencias.addTab("DATOS", this.JPI_DatosTriage);
        GroupLayout JPI_TriageRespiratorioLayout = new GroupLayout(this.JPI_TriageRespiratorio);
        this.JPI_TriageRespiratorio.setLayout(JPI_TriageRespiratorioLayout);
        JPI_TriageRespiratorioLayout.setHorizontalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 789, 32767));
        JPI_TriageRespiratorioLayout.setVerticalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 549, 32767));
        this.JTP_DatosUrgencias.addTab("TEST RESPIRATORIO (SARS-CoV-2)", this.JPI_TriageRespiratorio);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosUrgencias).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosUrgencias, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNegroActionPerformed(ActionEvent evt) {
        this.clasificacion = 5;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVerdeActionPerformed(ActionEvent evt) {
        this.clasificacion = 4;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAmarilloActionPerformed(ActionEvent evt) {
        this.clasificacion = 3;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNaranjaActionPerformed(ActionEvent evt) {
        this.clasificacion = 2;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRojoActionPerformed(ActionEvent evt) {
        this.clasificacion = 1;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFPDiastolica.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaFocusGained(FocusEvent evt) {
        this.JTFFPSistolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFPSistolica.getText().isEmpty() && !this.JTFFPSistolica.getText().equals("0")) {
            mValidarPresion(Integer.valueOf(this.JTFFPSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPDiastolicaFocusGained(FocusEvent evt) {
        this.JTFFPDiastolica.selectAll();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrActionPerformed(ActionEvent evt) {
        this.JTFFTemperatura.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
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
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        this.btnRojo.requestFocus();
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
    public void JCH_SPartoActionPerformed(ActionEvent evt) {
        if (this.JCH_SParto.isSelected()) {
            this.xsql = "update `ingreso` set `CS_Parto`=1 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        } else {
            this.xsql = "update `ingreso` set `CS_Parto`=0 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            mBuscarPatologiaCodigo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.JTPMenu.setSelectedIndex(2);
        this.JFTFNombrePatologia.requestFocus();
        this.codigo = this.JTFCDxP;
        this.xnombre = this.JTFNCodigoDxP.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getRowCount() != 0 && this.JTDetalle.getSelectedRow() != -1) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp1ActionPerformed(ActionEvent evt) {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
            if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
                Object[] fila = {this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), this.JSOrden.getValue()};
                this.xmodelo.addRow(fila);
                this.JTDetalle.setModel(this.xmodelo);
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSOrden.setValue(new Integer(1));
                return;
            }
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.setFocusable(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaTestRespiratorioActionPerformed(ActionEvent evt) {
        this.JTP_DatosUrgencias.setEnabledAt(1, true);
        this.JTP_DatosUrgencias.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAMotivoCKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextArea(evt, this.JTAMotivoC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFNombrePatologiaKeyPressed(KeyEvent evt) {
        if (!this.JFTFNombrePatologia.getText().isEmpty()) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFNombrePatologiaKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmpiezaActionPerformed(ActionEvent evt) {
        this.estadob = 0;
        this.JFTFNombrePatologia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.estadob = 1;
        this.JFTFNombrePatologia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroProgramaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        System.out.println("Nombre -> " + this.xnombre);
        mLlenarTextFiel2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_APabellon.getSelectedIndex() != -1) {
            this.JCB_ACama.removeAllItems();
            this.xsql = "SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_camas`.`Disponible`, CObservacion FROM `f_camas` INNER JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1 AND `f_camas`.`Disponible` =0 AND `f_camas`.`Id_UnidadCamas` ='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][0] + "') ORDER BY `f_camas`.`Nbre` ASC ";
            this.xid_cama = this.xct.llenarComboyLista(this.xsql, this.xid_cama, this.JCB_ACama, 4);
            this.JCB_ACama.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ACamaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinValidacionSignosActionPerformed(ActionEvent evt) {
    }

    private void cargarPanelTraigeRespiratorio() {
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
            this.triageRespiratorio = new JPTriageRespiratorio(Long.valueOf(this.JTFNTriage.getText()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "");
            this.triageRespiratorio.setBounds(1, 1, 700, 300);
            this.JPI_TriageRespiratorio.add(this.triageRespiratorio);
            this.JPI_TriageRespiratorio.repaint();
            return;
        }
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
            this.triageRespiratorio_V2 = new JPTriageRespiratorio_V2(Long.valueOf(this.JTFNTriage.getText()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "");
            this.triageRespiratorio_V2.setBounds(1, 1, 700, 300);
            this.JPI_TriageRespiratorio.add(this.triageRespiratorio_V2);
            this.JPI_TriageRespiratorio.repaint();
        }
    }

    private void grabarOrdenMedicaAsignacion() {
        if (this.JCB_APabellon.getSelectedIndex() != -1 && this.JCB_ACama.getSelectedIndex() != -1) {
            this.xsql = "insert into h_orden_hospitalizacion(`Id_Atencion`, `FechaH`, `Id_Profesional_O`, `Id_Especialidad_O`, FechaS, Id_Profesional_S, Id_Especialidad_S, FechaA, Id_Profesional_A, Id_Especialidad_A,  Id_Cama, `Dx_Cie10`, `Observacion`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "','" + this.JTDetalle.getValueAt(0, 0) + "','ASIGNACION DESDE TRIAGE','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JLBNRegistroC.setText(this.xct.ejecutarSQLId(this.xsql));
            this.xct.cerrarConexionBd();
            grabarAsignacionBase();
        }
    }

    public void grabarAsignacionBase() {
        this.xsql = "update ingreso set `Id_TipoAtencion`='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][2] + "', `Cama`='" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_camas set `Disponible`=1  where Id='" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into h_orden_hospitalizacion_traslado( `IdOrdenHosp` , `Id_Atencion` , `Fecha_Ingreso` , `Id_CamaOrigen`) values('" + this.JLBNRegistroC.getText() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.xid_cama[this.JCB_ACama.getSelectedIndex()][0] + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void nuevo() {
        this.xlleno = false;
        this.JCB_ACama.removeAllItems();
        this.JCB_APabellon.removeAllItems();
        this.xsql = "SELECT `f_unidadcama`.`Id`, `f_unidadcama`.`Nbre`, f_unidadcama.EsHosp, `f_unidadcama`.`idTipoAtencion` \nFROM `f_camas` INNER JOIN  `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) \ninner join g_tipoatencion gt on (gt.Id=f_unidadcama.idTipoAtencion)\nWHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1 and gt.Id_TipoAmbito=3) \nGROUP BY `f_unidadcama`.`Id` ORDER BY `f_unidadcama`.`Nbre` ASC";
        this.xid_pabellon = this.xct.llenarComboyLista(this.xsql, this.xid_pabellon, this.JCB_APabellon, 4);
        this.JCB_APabellon.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mBotonesTriage() {
        this.btnRojo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnVerde.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNegro.setIcon(new ImageIcon(getClass().getResource("")));
        switch (this.clasificacion) {
            case 1:
                this.btnRojo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 2:
                this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 3:
                this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 4:
                this.btnVerde.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 5:
                this.btnNegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
        }
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

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            if (imc > 0.0d) {
                this.JTFFSIMC.setText(String.valueOf(formato.format(imc)));
                return;
            } else {
                this.JTFFSIMC.setText("0.0");
                return;
            }
        }
        this.JTFFSIMC.setText("0.0");
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

    public void mGrabar() {
        if (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText().equals("0")) {
            if (!this.JTAMotivoC.getText().isEmpty()) {
                if (this.JCH_SinValidacionSignos.isSelected()) {
                    grabarTriage();
                    return;
                }
                if (Integer.parseInt(this.JTFFPSistolica.getText()) > 0) {
                    if (Integer.parseInt(this.JTFFPDiastolica.getText()) > 0) {
                        if (Integer.parseInt(this.JTFFSFc.getText()) > 0) {
                            if (Integer.parseInt(this.JTFFSFr.getText()) > 0) {
                                if (Integer.parseInt(this.JTFFTemperatura.getText()) > 0) {
                                    if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                        grabarTriage();
                                        return;
                                    }
                                    if (Integer.parseInt(this.JTFFPs2.getText()) > 0) {
                                        if (Integer.parseInt(this.JTFFSTalla.getText()) > 0) {
                                            if (Integer.parseInt(this.JTFFSPeso.getText()) > 0) {
                                                if (Integer.parseInt(this.JTFFSIMC.getText()) > 0) {
                                                    grabarTriage();
                                                    return;
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "IMC no tiene valor", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JTFFSIMC.requestFocus();
                                                    return;
                                                }
                                            }
                                            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para el peso", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFFSPeso.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la talla", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFFSTalla.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la saturación de oxígeno", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la temperatura", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFTemperatura.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la frecuencia respiratoria", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFSFr.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la frecuencia cardíaca", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSFc.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la presión diastólica", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFPDiastolica.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la presión sistólica", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFPSistolica.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Motivo de consulta no puede estar en blanco", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAMotivoC.requestFocus();
            return;
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
            if (this.clasificacion <= 2) {
                mUpdateTriage();
                return;
            }
            Object[] botones = {"Grabar", "Grabar y Cerrar HC", "Cerrar"};
            int y = JOptionPane.showOptionDialog(this, "Que desea hacer?", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y == 0) {
                mUpdateTriage();
                return;
            }
            if (y == 1) {
                mUpdateTriage();
                this.xsql = "update `ingreso` set `Egreso`=1 , `FEgreso`='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "update `h_atencion` set `InicioAtencion`=1, `TipoGuardado`=1  where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabarTriage() {
        if (this.clasificacion >= 1) {
            if (this.clasificacion <= 2) {
                mGrabarTriage();
                grabarOrdenMedicaAsignacion();
                Principal.clasehistoriace.mCambiarEstadoHc(2);
                return;
            }
            Object[] botones = {"Grabar", "Grabar y Cerrar HC", "Cerrar"};
            int y = JOptionPane.showOptionDialog(this, "Que desea hacer?", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y == 0) {
                mGrabarTriage();
                Principal.clasehistoriace.mCambiarEstadoHc(2);
                return;
            } else {
                if (y == 1) {
                    mGrabarTriage();
                    grabarSalidaAdminstrativa();
                    this.xsql = "update `ingreso` set `Egreso`=1 , `FEgreso`='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update `h_atencion` set `InicioAtencion`=1, `TipoGuardado`=1  where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Falta clasificación triage", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabarSalidaAdminstrativa() {
        IngresoOrdenSalidaDTO e = new IngresoOrdenSalidaDTO();
        e.setIdIngreso(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        e.setFechaS(this.xmt.formatoAMD1.format(this.JDCFecha.getDate()));
        e.setHoraS(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        e.setObservacion("Orden de Salida por triage No. " + this.clasificacion);
        e.setIdUsuarioRH(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        e.setEstado(1);
        this.ingresoOrdenSalidaDAO.create_return_id(e);
    }

    private void mGrabarTriage() {
        this.xsql = "INSERT INTO h_triage (IdIngreso, TArtSentadoD, TArtSentadoS, Clasificacion, FechaTriage, HoraTriage, MotivoConsulta,  FCardiaca, FRespiratoria, Talla, Peso, IMC, Temperatura, Ps2, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.JTFFPDiastolica.getText() + "','" + this.JTFFPSistolica.getText() + "','" + this.clasificacion + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTAMotivoC.getText() + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.JTFNTriage.setText(this.xct.ejecutarSQLId(this.xsql));
        if (!this.JTFNTriage.getText().isEmpty() || !this.JTFNTriage.getText().equals("0")) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xsql = "INSERT INTO `h_triage_diagnostico` (`Id_Triage`,`Id_Patologia`,`NOrden`,`Id_UsuarioS`)\nVALUES  ('" + this.JTFNTriage.getText() + "','" + this.JTDetalle.getValueAt(i, 0).toString() + "','" + Integer.valueOf(this.JTDetalle.getValueAt(i, 2).toString()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                this.xct.ejecutaSQLUpdate(this.xsql);
            }
            if (this.JCHAplicaTestRespiratorio.isSelected()) {
                this.triageRespiratorio.setIdTriage(Long.valueOf(this.JTFNTriage.getText()));
                this.triageRespiratorio.setIdIngreso(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
                this.triageRespiratorio.grabar();
            }
        }
        this.xct.cerrarConexionBd();
        if (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText() == null) {
            this.nTriage = false;
        } else {
            this.nTriage = true;
        }
        System.out.println("triage en grabar-> " + this.nTriage);
    }

    private void mUpdateTriage() {
        this.xsql = "update h_triage  set  TArtSentadoD='" + this.JTFFPDiastolica.getText() + "', TArtSentadoS='" + this.JTFFPSistolica.getText() + "' , Clasificacion='" + this.clasificacion + "', FechaTriage='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "', HoraTriage='" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "', MotivoConsulta='" + this.JTAMotivoC.getText() + "', FCardiaca='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() + "', Ps2='" + this.JTFFPs2.getText() + "' WHERE Id='" + this.JTFNTriage.getText() + "'";
        this.xct.ejecutaSQLUpdate(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarTriage() {
        try {
            this.xsql = "SELECT h_triage.`Id`, h_triage.`TArtSentadoD`, h_triage.`TArtSentadoS`, h_triage.`Clasificacion`, h_triage.`FechaTriage`, h_triage.`HoraTriage`, h_triage.`MotivoConsulta`, h_triage.`FCardiaca`, h_triage.`FRespiratoria`, h_triage.`Talla`, h_triage.`Peso`, h_triage.`IMC`, h_triage.`Temperatura`, h_triage.`Ps2` , ifnull(h_triage_respiratorio.id,0) as idTriageRespiratorio, h_triage.Id  as  idTriage  FROM  `h_triage`  left join h_triage_respiratorio on (h_triage.Id=h_triage_respiratorio.idTriage) and (h_triage_respiratorio.estado=1) WHERE (h_triage.`Estado` =0 AND h_triage.`IdIngreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JTFNTriage.setText(xrs.getString(1));
                    this.JTFFPDiastolica.setValue(Integer.valueOf(xrs.getInt(2)));
                    this.JTFFPSistolica.setValue(Integer.valueOf(xrs.getInt(3)));
                    switch (xrs.getInt(4)) {
                        case 1:
                            this.clasificacion = 1;
                            mBotonesTriage();
                            break;
                        case 2:
                            this.clasificacion = 2;
                            mBotonesTriage();
                            break;
                        case 3:
                            this.clasificacion = 3;
                            mBotonesTriage();
                            break;
                        case 4:
                            this.clasificacion = 4;
                            mBotonesTriage();
                            break;
                        case 5:
                            this.clasificacion = 5;
                            mBotonesTriage();
                            break;
                    }
                    this.JDCFecha.setDate(xrs.getDate(5));
                    this.JTFFHora.setValue(xrs.getTime(6));
                    this.JTAMotivoC.setText(xrs.getString(7));
                    this.JTFFSFc.setText("" + xrs.getInt(8));
                    this.JTFFSFr.setText("" + xrs.getInt(9));
                    this.JTFFSTalla.setText("" + xrs.getDouble(10));
                    this.JTFFSPeso.setText("" + xrs.getDouble(11));
                    this.JTFFSIMC.setText("" + xrs.getDouble(12));
                    this.JTFFTemperatura.setText("" + xrs.getDouble(13));
                    this.JTFFPs2.setText("" + xrs.getInt(14));
                    if (xrs.getLong("idTriageRespiratorio") != 0) {
                        this.triageRespiratorio.setIdTriage(Long.valueOf(xrs.getLong("idTriage")));
                        this.triageRespiratorio.nuevo();
                        this.JCHAplicaTestRespiratorio.setSelected(true);
                        this.JTP_DatosUrgencias.setEnabledAt(1, true);
                    }
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(xrs.getInt(4)));
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
                this.xct.cerrarConexionBd();
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
            Logger.getLogger(JPITriageP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JTFNTriage.getText().isEmpty()) {
            ClaseImpresionInformes claseImpresionInformes = new ClaseImpresionInformes();
            claseImpresionInformes.mImprimirTriage(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        }
    }

    private void mClasificar_SalaPArto() {
        try {
            this.xsql = "SELECT`ingreso`.`CS_Parto` , `g_persona`.`Id_Sexo` FROM `g_persona` INNER JOIN  `ingreso`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) WHERE (`ingreso`.`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCH_SParto.setSelected(xrs.getBoolean(1));
                if (xrs.getString(2).equals("F")) {
                    this.JCH_SParto.setVisible(true);
                } else {
                    this.JCH_SParto.setVisible(false);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriageP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        try {
            this.xsql = "SELECT\n    `g_patologia`.`Id` AS CIE10\n    , `g_patologia`.`Nbre`\n    , `h_triage_diagnostico`.`NOrden`\nFROM\n    `g_patologia`\n    INNER JOIN `h_triage_diagnostico` \n        ON (`g_patologia`.`Id` = `h_triage_diagnostico`.`Id_Patologia`)\nWHERE (`h_triage_diagnostico`.`Id_Triage` ='" + this.JTFNTriage.getText() + "'\n    AND `h_triage_diagnostico`.`Estado` =1);";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("CIE10"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("NOrden")), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriageP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Diagnóstico", "Nº Orden"}) { // from class: Historia.JPITriageP.41
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mBuscarPatologiaCodigo() {
        List<PatologiaCie10DTO> listPatologia = this.xPatologiaCie10DAO.listPatologiaFiltrada(this.JTFCDxP.getText(), "0");
        if (!listPatologia.isEmpty()) {
            for (int i = 0; i < listPatologia.size(); i++) {
                this.JTFCDxP.setText("" + listPatologia.get(i).getId());
                this.JTFNCodigoDxP.setText("" + listPatologia.get(i).getNombre());
            }
            return;
        }
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
    }

    private void mBuscar() {
        String sql;
        try {
            mCrearTabla();
            System.out.println("nombree -> " + this.xnombre);
            if (this.xnombre.equals("conclusion")) {
                if (Principal.informacionIps.getFiltroPatologiaPrograma().intValue() == 1) {
                    if (this.JCHFiltroPrograma.isSelected() && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue() != 0) {
                        if (this.estadob == 0) {
                            sql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\nFROM\n    `g_patologia_programa`\n    INNER JOIN `g_patologia` \n        ON (`g_patologia_programa`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`g_patologia`.`Nbre` =like '" + this.JFTFNombrePatologia.getText() + "%'\n    AND `g_patologia_programa`.`Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "'\n    AND `g_patologia_programa`.`Estado` =1)";
                        } else {
                            sql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\nFROM\n    `g_patologia_programa`\n    INNER JOIN `g_patologia` \n        ON (`g_patologia_programa`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`g_patologia`.`Nbre` like '%" + this.JFTFNombrePatologia.getText() + "%'\n    AND `g_patologia_programa`.`Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "'\n    AND `g_patologia_programa`.`Estado` =1)";
                        }
                    } else if (this.estadob == 0) {
                        sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                    } else {
                        sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                    }
                } else if (this.estadob == 0) {
                    sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                } else {
                    sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                }
            } else if (this.estadob == 0) {
                sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
            } else {
                sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
            }
            ResultSet res = this.consultas.traerRs(sql);
            if (res.next()) {
                res.beforeFirst();
                int nfila1 = 0;
                while (res.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(res.getString(1), nfila1, 0);
                    this.modelo.setValueAt(res.getString(2), nfila1, 1);
                    nfila1++;
                }
            }
            res.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void mLlenarTextFiel() {
        this.codigo.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        this.nombrep.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
        System.out.println(this.codigo.getText() + " - " + this.nombrep.getText());
        this.codigo.requestFocus();
    }

    private void mLlenarTextFiel1() {
        this.codigo.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        this.codigo.requestFocus();
    }

    private void mLlenarTextFiel2() {
        this.JTFCDxP.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        this.JTFNCodigoDxP.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
        this.JTPMenu.setSelectedIndex(1);
        this.JTFCDxP.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre"}) { // from class: Historia.JPITriageP.42
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(600);
    }
}
