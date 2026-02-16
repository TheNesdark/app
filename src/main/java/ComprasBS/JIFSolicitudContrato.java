package ComprasBS;

import Acceso.Principal;
import Historia.JDPatologia;
import Presupuesto.JDBusquedaDocPTO;
import Sgc.JDEvidenciaSoporte;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.comprabs.AdicionContratoDAO;
import com.genoma.plus.dao.impl.comprabs.AdicionContratoDAOImpl;
import com.genoma.plus.dto.comprabs.AdicionContratoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFSolicitudContrato.class */
public class JIFSolicitudContrato extends JInternalFrame {
    private String[] xidempresa;
    private String[] xunidadf;
    private String[] xiadministrador;
    private String[] xtipodoc;
    private String[] xtipodocsoporte;
    private String[] xidtipodocadicion;
    private String[] xTipoSeguimiento;
    private String xnombre;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo_s;
    public DefaultTableModel xmodelo_d;
    public DefaultTableModel xmodelo_f;
    public DefaultTableModel xmodelo_a;
    private Object[] xdatos;
    private Object[] xdatos_s;
    private Object[] xdatos_d;
    private Object[] xdatos_a;
    private int xtipo;
    private AdicionContratoDAO xAdicionContratoDAO;
    private ButtonGroup BGPTipoAdicion;
    private ButtonGroup BGProrroga;
    private JButton JBBuscar;
    private ButtonGroup JBG_Visualizar;
    private JButton JBT_CargarEvidencias;
    private JComboBox JCBAdministrador;
    public JComboBox JCBTercero;
    private JComboBox JCBTipoDocF;
    private JComboBox JCBTipoDocumentoA;
    private JComboBox JCBTipoSeguimiento;
    private JComboBox JCBUnidadF;
    private JDateChooser JDC_AFecha;
    private JDateChooser JDC_SFecha;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFFechaI;
    public JFormattedTextField JFTFValorAdd;
    public JFormattedTextField JFTFValorDoc1;
    public JFormattedTextField JFTF_FRValor;
    public JFormattedTextField JFTF_FRValor1;
    private JPanel JIPProrroga;
    private JPanel JIPTipo;
    public JLabel JLBDuracion;
    public JLabel JLCodigoDoc1;
    private JPanel JPIAdicionar;
    private JPanel JPIDatosC;
    private JPanel JPIDatosP;
    private JPanel JPIH_Filtro;
    private JPanel JPIPA_Documentos;
    private JPanel JPI_FacRadicadas;
    private JPanel JPI_Historico;
    private JPanel JPI_Visualizar;
    private JPanel JPSeguimiento;
    private JRadioButton JRBFecha;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JRadioButton JRBValor;
    private JRadioButton JRB_Registrados;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPH_Historico;
    public JSpinner JSPIva;
    private JScrollPane JSPObjetivoG;
    private JScrollPane JSPObservacionA;
    private JScrollPane JSPP_Documentos1;
    private JScrollPane JSP_ADetalle;
    private JScrollPane JSP_FRadicadas;
    private JScrollPane JSP_SDescripcion;
    private JScrollPane JSP_SDetalle;
    private JTextPane JTAObjetivoG;
    private JTextPane JTAObservacionA;
    private JTextPane JTA_SDescripcion;
    private JTable JTBH_Historico;
    private JTable JTBP_Documentos;
    private JTable JTB_AdicionD;
    private JTable JTB_DFRadicadas;
    private JTable JTB_SeguimientoD;
    private JTextField JTFCodigocontrato;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalAdicion;
    private JFormattedTextField JTFFTotalIva;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFNumContrato;
    private JTabbedPane JTPContratos;
    private JTabbedPane JTPPrincipal;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xlleno = false;
    private String xsql = null;
    private String xfiltro = "IN(1)";
    public int xIdMovDisponibilidad = 0;
    public int xvalorDisponibilidad = 0;
    private int xtipobusqueda = 1;
    private int xestado = 1;
    private int xtipocodigo = 1;
    private int xesProrroga = 0;
    private int xConsecutivo = 0;

    JIFSolicitudContrato(String xnombre) {
        initComponents();
        springStart();
        mNuevo();
        mCargarDatosHistorico();
        this.xnombre = xnombre;
    }

    private void springStart() {
        this.xAdicionContratoDAO = (AdicionContratoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("adicionContratoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v124, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v288, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v76, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGProrroga = new ButtonGroup();
        this.BGPTipoAdicion = new ButtonGroup();
        this.JBG_Visualizar = new ButtonGroup();
        this.JTPPrincipal = new JTabbedPane();
        this.JPSeguimiento = new JPanel();
        this.JDC_SFecha = new JDateChooser();
        this.JSP_SDescripcion = new JScrollPane();
        this.JTA_SDescripcion = new JTextPane();
        this.JSP_SDetalle = new JScrollPane();
        this.JTB_SeguimientoD = new JTable();
        this.JCBTipoSeguimiento = new JComboBox();
        this.JPIPA_Documentos = new JPanel();
        this.JBT_CargarEvidencias = new JButton();
        this.JSPP_Documentos1 = new JScrollPane();
        this.JTBP_Documentos = new JTable();
        this.JPI_Visualizar = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Registrados = new JRadioButton();
        this.JPIAdicionar = new JPanel();
        this.JSP_ADetalle = new JScrollPane();
        this.JTB_AdicionD = new JTable();
        this.JIPTipo = new JPanel();
        this.JRBFecha = new JRadioButton();
        this.JRBValor = new JRadioButton();
        this.JDC_AFecha = new JDateChooser();
        this.JFTFValorAdd = new JFormattedTextField();
        this.JSPObservacionA = new JScrollPane();
        this.JTAObservacionA = new JTextPane();
        this.JCBTipoDocumentoA = new JComboBox();
        this.JPI_FacRadicadas = new JPanel();
        this.JSP_FRadicadas = new JScrollPane();
        this.JTB_DFRadicadas = new JTable();
        this.JFTF_FRValor = new JFormattedTextField();
        this.JFTF_FRValor1 = new JFormattedTextField();
        this.JTPContratos = new JTabbedPane();
        this.JPIDatosP = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JPIDatosC = new JPanel();
        this.JSPObjetivoG = new JScrollPane();
        this.JTAObjetivoG = new JTextPane();
        this.JSPIva = new JSpinner();
        this.JTFFTotalIva = new JFormattedTextField();
        this.JTFFTotal = new JFormattedTextField();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc1 = new JLabel();
        this.JFTFValorDoc1 = new JFormattedTextField();
        this.JLBDuracion = new JLabel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaC = new JDateChooser();
        this.JTFFTotalAdicion = new JFormattedTextField();
        this.JCBTipoDocF = new JComboBox();
        this.JTFNumContrato = new JTextField();
        this.JCBAdministrador = new JComboBox();
        this.JIPProrroga = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JPI_Historico = new JPanel();
        this.JPIH_Filtro = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JTFCodigocontrato = new JTextField();
        this.JSPH_Historico = new JScrollPane();
        this.JTBH_Historico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("HOJA DE VIDA DE CONTRATOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFSolicitudContrato");
        this.JTPPrincipal.setForeground(Color.red);
        this.JTPPrincipal.setFont(new Font("Arial", 1, 14));
        this.JDC_SFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_SFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_SFecha.setFont(new Font("Arial", 1, 12));
        this.JDC_SFecha.setMaxSelectableDate(new Date(253370786507000L));
        this.JSP_SDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_SDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSP_SDescripcion.setViewportView(this.JTA_SDescripcion);
        this.JSP_SDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_SeguimientoD.setFont(new Font("Arial", 1, 12));
        this.JTB_SeguimientoD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_SeguimientoD.setRowHeight(25);
        this.JTB_SeguimientoD.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_SeguimientoD.setSelectionForeground(Color.red);
        this.JSP_SDetalle.setViewportView(this.JTB_SeguimientoD);
        this.JCBTipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoSeguimiento.addItemListener(new ItemListener() { // from class: ComprasBS.JIFSolicitudContrato.1
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudContrato.this.JCBTipoSeguimientoItemStateChanged(evt);
            }
        });
        this.JCBTipoSeguimiento.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.2
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JCBTipoSeguimientoActionPerformed(evt);
            }
        });
        GroupLayout JPSeguimientoLayout = new GroupLayout(this.JPSeguimiento);
        this.JPSeguimiento.setLayout(JPSeguimientoLayout);
        JPSeguimientoLayout.setHorizontalGroup(JPSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSeguimientoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_SDetalle).addGroup(JPSeguimientoLayout.createSequentialGroup().addGroup(JPSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDC_SFecha, -1, 233, 32767).addComponent(this.JCBTipoSeguimiento, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_SDescripcion, -2, 656, -2))).addContainerGap()));
        JPSeguimientoLayout.setVerticalGroup(JPSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSeguimientoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPSeguimientoLayout.createSequentialGroup().addComponent(this.JDC_SFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoSeguimiento, -2, 50, -2)).addComponent(this.JSP_SDescripcion, -1, 122, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_SDetalle, -1, 165, 32767).addContainerGap()));
        this.JTPPrincipal.addTab("SEGUIMIENTO", this.JPSeguimiento);
        this.JBT_CargarEvidencias.setFont(new Font("Arial", 1, 12));
        this.JBT_CargarEvidencias.setForeground(new Color(0, 0, 153));
        this.JBT_CargarEvidencias.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_CargarEvidencias.setText("Cargar evidencias");
        this.JBT_CargarEvidencias.setPreferredSize(new Dimension(71, 23));
        this.JBT_CargarEvidencias.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.3
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JBT_CargarEvidenciasActionPerformed(evt);
            }
        });
        this.JSPP_Documentos1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBP_Documentos.setFont(new Font("Arial", 1, 12));
        this.JTBP_Documentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBP_Documentos.setRowHeight(25);
        this.JTBP_Documentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTBP_Documentos.setSelectionForeground(Color.red);
        this.JTBP_Documentos.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFSolicitudContrato.4
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudContrato.this.JTBP_DocumentosMouseClicked(evt);
            }
        });
        this.JSPP_Documentos1.setViewportView(this.JTBP_Documentos);
        this.JPI_Visualizar.setBorder(BorderFactory.createTitledBorder((Border) null, "Visualizar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Visualizar.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.5
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Visualizar.add(this.JRB_Registrados);
        this.JRB_Registrados.setFont(new Font("Arial", 1, 12));
        this.JRB_Registrados.setSelected(true);
        this.JRB_Registrados.setText("Registrados");
        this.JRB_Registrados.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.6
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRB_RegistradosActionPerformed(evt);
            }
        });
        GroupLayout JPI_VisualizarLayout = new GroupLayout(this.JPI_Visualizar);
        this.JPI_Visualizar.setLayout(JPI_VisualizarLayout);
        JPI_VisualizarLayout.setHorizontalGroup(JPI_VisualizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_VisualizarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Registrados, -1, 105, 32767).addContainerGap()));
        JPI_VisualizarLayout.setVerticalGroup(JPI_VisualizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_VisualizarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Registrados)));
        GroupLayout JPIPA_DocumentosLayout = new GroupLayout(this.JPIPA_Documentos);
        this.JPIPA_Documentos.setLayout(JPIPA_DocumentosLayout);
        JPIPA_DocumentosLayout.setHorizontalGroup(JPIPA_DocumentosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPA_DocumentosLayout.createSequentialGroup().addContainerGap().addGroup(JPIPA_DocumentosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_CargarEvidencias, -1, 893, 32767).addComponent(this.JSPP_Documentos1, -1, 893, 32767).addGroup(JPIPA_DocumentosLayout.createSequentialGroup().addComponent(this.JPI_Visualizar, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIPA_DocumentosLayout.setVerticalGroup(JPIPA_DocumentosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPA_DocumentosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Visualizar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPP_Documentos1, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_CargarEvidencias, -2, 46, -2).addContainerGap(-1, 32767)));
        this.JTPPrincipal.addTab("DOCUMENTOS", this.JPIPA_Documentos);
        this.JSP_ADetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_AdicionD.setFont(new Font("Arial", 1, 12));
        this.JTB_AdicionD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AdicionD.setRowHeight(25);
        this.JTB_AdicionD.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_AdicionD.setSelectionForeground(Color.red);
        this.JSP_ADetalle.setViewportView(this.JTB_AdicionD);
        this.JIPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Adicion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.BGPTipoAdicion.add(this.JRBFecha);
        this.JRBFecha.setFont(new Font("Arial", 1, 12));
        this.JRBFecha.setSelected(true);
        this.JRBFecha.setText("Tiempo");
        this.JRBFecha.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.7
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRBFechaActionPerformed(evt);
            }
        });
        this.BGPTipoAdicion.add(this.JRBValor);
        this.JRBValor.setFont(new Font("Arial", 1, 12));
        this.JRBValor.setText("Valor");
        this.JRBValor.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.8
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRBValorActionPerformed(evt);
            }
        });
        GroupLayout JIPTipoLayout = new GroupLayout(this.JIPTipo);
        this.JIPTipo.setLayout(JIPTipoLayout);
        JIPTipoLayout.setHorizontalGroup(JIPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPTipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFecha).addGap(18, 18, 18).addComponent(this.JRBValor).addContainerGap(-1, 32767)));
        JIPTipoLayout.setVerticalGroup(JIPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPTipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JIPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFecha).addComponent(this.JRBValor))));
        this.JDC_AFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_AFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_AFecha.setFont(new Font("Arial", 1, 12));
        this.JFTFValorAdd.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorAdd.setForeground(Color.red);
        this.JFTFValorAdd.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorAdd.setHorizontalAlignment(4);
        this.JFTFValorAdd.setText("0");
        this.JFTFValorAdd.setToolTipText("");
        this.JFTFValorAdd.setEnabled(false);
        this.JFTFValorAdd.setFont(new Font("Arial", 1, 12));
        this.JFTFValorAdd.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFSolicitudContrato.9
            public void focusLost(FocusEvent evt) {
                JIFSolicitudContrato.this.JFTFValorAddFocusLost(evt);
            }
        });
        this.JFTFValorAdd.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.10
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JFTFValorAddActionPerformed(evt);
            }
        });
        this.JFTFValorAdd.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JFTFValorAddPropertyChange(evt);
            }
        });
        this.JSPObservacionA.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionA.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionA.setViewportView(this.JTAObservacionA);
        this.JCBTipoDocumentoA.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoA.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumentoA.addItemListener(new ItemListener() { // from class: ComprasBS.JIFSolicitudContrato.12
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudContrato.this.JCBTipoDocumentoAItemStateChanged(evt);
            }
        });
        GroupLayout JPIAdicionarLayout = new GroupLayout(this.JPIAdicionar);
        this.JPIAdicionar.setLayout(JPIAdicionarLayout);
        JPIAdicionarLayout.setHorizontalGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionarLayout.createSequentialGroup().addContainerGap().addGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_ADetalle, -1, 893, 32767).addGroup(JPIAdicionarLayout.createSequentialGroup().addComponent(this.JIPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_AFecha, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorAdd, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumentoA, 0, -1, 32767)).addComponent(this.JSPObservacionA)).addContainerGap()));
        JPIAdicionarLayout.setVerticalGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAdicionarLayout.createSequentialGroup().addContainerGap().addGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JIPTipo, -2, -1, -2).addGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValorAdd, -2, 50, -2).addComponent(this.JCBTipoDocumentoA, -2, 54, -2)).addComponent(this.JDC_AFecha, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacionA, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_ADetalle, -1, 137, 32767).addContainerGap()));
        this.JTPPrincipal.addTab("ADICION", this.JPIAdicionar);
        this.JSP_FRadicadas.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_DFRadicadas.setFont(new Font("Arial", 1, 12));
        this.JTB_DFRadicadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DFRadicadas.setRowHeight(25);
        this.JTB_DFRadicadas.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DFRadicadas.setSelectionForeground(Color.red);
        this.JTB_DFRadicadas.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFSolicitudContrato.13
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudContrato.this.JTB_DFRadicadasMouseClicked(evt);
            }
        });
        this.JSP_FRadicadas.setViewportView(this.JTB_DFRadicadas);
        this.JFTF_FRValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Facturas", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTF_FRValor.setForeground(Color.red);
        this.JFTF_FRValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTF_FRValor.setHorizontalAlignment(4);
        this.JFTF_FRValor.setToolTipText("");
        this.JFTF_FRValor.setFont(new Font("Arial", 1, 12));
        this.JFTF_FRValor.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFSolicitudContrato.14
            public void focusLost(FocusEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValorFocusLost(evt);
            }
        });
        this.JFTF_FRValor.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.15
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValorActionPerformed(evt);
            }
        });
        this.JFTF_FRValor.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValorPropertyChange(evt);
            }
        });
        this.JFTF_FRValor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo Contrato", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTF_FRValor1.setForeground(Color.red);
        this.JFTF_FRValor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTF_FRValor1.setHorizontalAlignment(4);
        this.JFTF_FRValor1.setToolTipText("");
        this.JFTF_FRValor1.setFont(new Font("Arial", 1, 12));
        this.JFTF_FRValor1.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFSolicitudContrato.17
            public void focusLost(FocusEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValor1FocusLost(evt);
            }
        });
        this.JFTF_FRValor1.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.18
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValor1ActionPerformed(evt);
            }
        });
        this.JFTF_FRValor1.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.19
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JFTF_FRValor1PropertyChange(evt);
            }
        });
        GroupLayout JPI_FacRadicadasLayout = new GroupLayout(this.JPI_FacRadicadas);
        this.JPI_FacRadicadas.setLayout(JPI_FacRadicadasLayout);
        JPI_FacRadicadasLayout.setHorizontalGroup(JPI_FacRadicadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FacRadicadasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FacRadicadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_FRadicadas, -1, 899, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPI_FacRadicadasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JFTF_FRValor, -2, 150, -2).addGap(40, 40, 40).addComponent(this.JFTF_FRValor1, -2, 150, -2))).addContainerGap()));
        JPI_FacRadicadasLayout.setVerticalGroup(JPI_FacRadicadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FacRadicadasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_FRadicadas, -2, 205, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FacRadicadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTF_FRValor, -2, 50, -2).addComponent(this.JFTF_FRValor1, -2, 50, -2)).addContainerGap(39, 32767)));
        this.JTPPrincipal.addTab("FACTURAS RADICADAS", this.JPI_FacRadicadas);
        this.JTPContratos.setForeground(new Color(0, 102, 0));
        this.JTPContratos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ComprasBS.JIFSolicitudContrato.20
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudContrato.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFSolicitudContrato.21
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudContrato.this.JCBTerceroMouseClicked(evt);
            }
        });
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL CONTRATO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPObjetivoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObjetivoG.setFont(new Font("Arial", 1, 12));
        this.JTAObjetivoG.setMaximumSize(new Dimension(6, 21));
        this.JSPObjetivoG.setViewportView(this.JTAObjetivoG);
        this.JSPIva.setFont(new Font("Arial", 1, 13));
        this.JSPIva.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPIva.setBorder(BorderFactory.createTitledBorder((Border) null, "% Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPIva.addChangeListener(new ChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.22
            public void stateChanged(ChangeEvent evt) {
                JIFSolicitudContrato.this.JSPIvaStateChanged(evt);
            }
        });
        this.JTFFTotalIva.setEditable(false);
        this.JTFFTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalIva.setHorizontalAlignment(4);
        this.JTFFTotalIva.setFont(new Font("Arial", 1, 13));
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 14));
        this.JBBuscar.setFont(new Font("Arial", 1, 12));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setText("Disponibilidad");
        this.JBBuscar.setToolTipText("Buscar Disponibilidad");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.23
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Arial", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc1.setForeground(Color.red);
        this.JFTFValorDoc1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorDoc1.setHorizontalAlignment(4);
        this.JFTFValorDoc1.setToolTipText("");
        this.JFTFValorDoc1.setFont(new Font("Arial", 1, 12));
        this.JFTFValorDoc1.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.24
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JFTFValorDoc1ActionPerformed(evt);
            }
        });
        this.JFTFValorDoc1.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFSolicitudContrato.25
            public void focusLost(FocusEvent evt) {
                JIFSolicitudContrato.this.JFTFValorDoc1FocusLost(evt);
            }
        });
        this.JFTFValorDoc1.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.26
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JFTFValorDoc1PropertyChange(evt);
            }
        });
        this.JLBDuracion.setBackground(new Color(255, 255, 255));
        this.JLBDuracion.setFont(new Font("Arial", 1, 12));
        this.JLBDuracion.setForeground(Color.red);
        this.JLBDuracion.setHorizontalAlignment(0);
        this.JLBDuracion.setToolTipText("Duracion en meses");
        this.JLBDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.27
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JDFFechaC.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFSolicitudContrato.28
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudContrato.this.JDFFechaCPropertyChange(evt);
            }
        });
        this.JTFFTotalAdicion.setEditable(false);
        this.JTFFTotalAdicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Adición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalAdicion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalAdicion.setHorizontalAlignment(4);
        this.JTFFTotalAdicion.setFont(new Font("Arial", 1, 13));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBDuracion, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorDoc1, -2, 121, -2)).addComponent(this.JSPObjetivoG, -2, 500, -2)).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JSPIva, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalIva, -2, 98, -2).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFFTotalAdicion, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBBuscar, -1, -1, 32767).addComponent(this.JLCodigoDoc1, -1, -1, 32767).addComponent(this.JTFFTotal)).addGap(10, 10, 10)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal, -2, 50, -2).addComponent(this.JTFFTotalIva, -2, 50, -2).addComponent(this.JSPIva, -2, 50, -2).addComponent(this.JFTFValorDoc1, -2, 50, -2)).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JLBDuracion, GroupLayout.Alignment.LEADING, -2, 50, -2)).addComponent(this.JDFFechaI, GroupLayout.Alignment.LEADING, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLCodigoDoc1, -2, 50, -2).addComponent(this.JTFFTotalAdicion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 50, -2)).addComponent(this.JSPObjetivoG, -2, 106, -2)).addContainerGap()));
        this.JCBTipoDocF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocF.addItemListener(new ItemListener() { // from class: ComprasBS.JIFSolicitudContrato.29
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudContrato.this.JCBTipoDocFItemStateChanged(evt);
            }
        });
        this.JCBTipoDocF.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.30
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JCBTipoDocFActionPerformed(evt);
            }
        });
        this.JTFNumContrato.setFont(new Font("Arial", 1, 14));
        this.JTFNumContrato.setForeground(Color.red);
        this.JTFNumContrato.setHorizontalAlignment(0);
        this.JTFNumContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Contrato", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAdministrador.setFont(new Font("Arial", 1, 12));
        this.JCBAdministrador.setBorder(BorderFactory.createTitledBorder((Border) null, "Administrador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JIPProrroga.setBorder(BorderFactory.createTitledBorder((Border) null, "Prorroga Automática", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.BGProrroga.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.31
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRBSiActionPerformed(evt);
            }
        });
        this.BGProrroga.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: ComprasBS.JIFSolicitudContrato.32
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudContrato.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JIPProrrogaLayout = new GroupLayout(this.JIPProrroga);
        this.JIPProrroga.setLayout(JIPProrrogaLayout);
        JIPProrrogaLayout.setHorizontalGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPProrrogaLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JRBSi).addGap(26, 26, 26).addComponent(this.JRBNo).addGap(21, 21, 21)));
        JIPProrrogaLayout.setVerticalGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPProrrogaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo))));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosC, -1, -1, 32767).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTercero, -2, 437, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBTipoDocF, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAdministrador, -2, 458, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JIPProrroga, -1, -1, 32767).addComponent(this.JTFNumContrato, -2, 153, -2)))).addGap(15, 15, 15)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadF, -2, 50, -2).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JTFNumContrato, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocF, -2, 50, -2).addComponent(this.JCBAdministrador, -2, 50, -2)).addComponent(this.JIPProrroga, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosC, -2, -1, -2).addGap(33, 33, 33)));
        this.JTPContratos.addTab("DATOS", this.JPIDatosP);
        this.JPIH_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFSolicitudContrato.33
            public void keyTyped(KeyEvent evt) {
                JIFSolicitudContrato.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFSolicitudContrato.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        this.JTFCodigocontrato.setFont(new Font("Arial", 1, 12));
        this.JTFCodigocontrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigocontrato.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFSolicitudContrato.34
            public void keyTyped(KeyEvent evt) {
                JIFSolicitudContrato.this.JTFCodigocontratoKeyTyped(evt);
            }
        });
        GroupLayout JPIH_FiltroLayout = new GroupLayout(this.JPIH_Filtro);
        this.JPIH_Filtro.setLayout(JPIH_FiltroLayout);
        JPIH_FiltroLayout.setHorizontalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFCodigocontrato, -2, 173, -2).addGap(18, 18, 18).addComponent(this.JTFNombreBusqueda).addContainerGap()));
        JPIH_FiltroLayout.setVerticalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreBusqueda, -2, -1, -2).addComponent(this.JTFCodigocontrato, -2, 41, -2)).addGap(8, 8, 8)));
        this.JSPH_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBH_Historico.setFont(new Font("Arial", 1, 12));
        this.JTBH_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBH_Historico.setRowHeight(25);
        this.JTBH_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBH_Historico.setSelectionForeground(Color.red);
        this.JTBH_Historico.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFSolicitudContrato.35
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudContrato.this.JTBH_HistoricoMouseClicked(evt);
            }
        });
        this.JSPH_Historico.setViewportView(this.JTBH_Historico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIH_Filtro, -1, -1, 32767).addComponent(this.JSPH_Historico, -1, 893, 32767)).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIH_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPH_Historico, -1, 263, 32767).addContainerGap()));
        this.JTPContratos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPPrincipal).addComponent(this.JTPContratos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPContratos, -2, 397, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPPrincipal, -1, 352, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("Solicitud Contratos");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.JCBTercero.removeAllItems();
            this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta FROM cc_unidadfuncionalxempresa  INNER JOIN cc_terceros ON (cc_unidadfuncionalxempresa.Id_Empresa = cc_terceros.Id) WHERE (cc_unidadfuncionalxempresa.Estado =1 AND cc_unidadfuncionalxempresa.Id_UnidadF ='" + this.xunidadf[this.JCBUnidadF.getSelectedIndex()] + "') ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            this.xidempresa = this.xconsultas.llenarCombo(this.xsql, this.xidempresa, this.JCBTercero);
            this.JCBTercero.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBH_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTBH_Historico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 0).toString());
            this.JTFNumContrato.setText(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 1).toString());
            this.JDFFechaI.setDate(java.sql.Date.valueOf(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 2).toString()));
            this.JDFFechaC.setDate(java.sql.Date.valueOf(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 12).toString()));
            this.JCBUnidadF.setSelectedItem(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 4).toString());
            this.JCBTercero.setSelectedItem(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 3).toString());
            this.JCBTipoDocF.setSelectedItem(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 5).toString());
            this.JTAObjetivoG.setText(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 6).toString());
            this.JFTFValorDoc1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 7).toString()));
            this.JSPIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 8).toString()));
            this.JCBAdministrador.setSelectedItem(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 9).toString());
            this.JLCodigoDoc1.setText(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 11).toString());
            this.JLBDuracion.setText(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 16).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBH_Historico.getSelectedRow(), 17).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xesProrroga = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xesProrroga = 0;
            }
            mCargarDatos_Documentos(Principal.txtNo.getText());
            mCargarDatos_Adiciones(Principal.txtNo.getText());
        }
        this.JTPContratos.setSelectedIndex(0);
        mCargarDatosTabla_Seguimiento();
        mCargarDatos_FRadicados();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        JDBusquedaDocPTO x = new JDBusquedaDocPTO(null, true, this, "9", "");
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIvaStateChanged(ChangeEvent evt) {
        mTotalizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarEvidenciasActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JTBP_Documentos.getSelectedRow() != -1) {
                if (Boolean.valueOf(this.xmodelo_d.getValueAt(this.JTBP_Documentos.getSelectedRow(), 5).toString()).booleanValue()) {
                    JDEvidenciaSoporte dialog = new JDEvidenciaSoporte(this.xmodelo_d.getValueAt(this.JTBP_Documentos.getSelectedRow(), 6).toString(), this.xmodelo_d.getValueAt(this.JTBP_Documentos.getSelectedRow(), 1).toString(), null, true);
                    dialog.setLocationRelativeTo(this);
                    dialog.setVisible(true);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Este documento no esta guardado", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un documento a evidenciar", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proyecto", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTPPrincipal.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBP_DocumentosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocFActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorDoc1ActionPerformed(ActionEvent evt) {
        this.JFTFValorDoc1.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorDoc1FocusLost(FocusEvent evt) {
        mTotalizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorDoc1PropertyChange(PropertyChangeEvent evt) {
        this.JTFFTotal.setText(this.JFTFValorDoc1.getText());
        this.JSPIva.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDPatologia x = new JDPatologia(null, true, this);
            x.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigocontratoKeyTyped(KeyEvent evt) {
        if (!this.JTFCodigocontrato.getText().isEmpty()) {
            mCargarDatosHistorico();
        } else {
            this.xtipocodigo = 0;
            mCargarDatosHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcularTiempo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaCPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcularTiempo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDocF.getSelectedIndex() != -1) {
            mConsecutivo();
            mCargarDatos_Documentos(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DFRadicadasMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValorFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValorPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        if (this.JRBSi.isSelected()) {
            this.xesProrroga = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        if (this.JRBNo.isSelected()) {
            this.xesProrroga = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechaActionPerformed(ActionEvent evt) {
        if (this.JRBFecha.isSelected()) {
            this.xtipo = 0;
            this.JFTFValorAdd.setEnabled(false);
            this.JDC_AFecha.setEnabled(true);
            this.JFTFValorAdd.setValue((Object) null);
            this.JDC_AFecha.setDate(this.xmt.getFechaActual());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValorActionPerformed(ActionEvent evt) {
        if (this.JRBValor.isSelected()) {
            this.xtipo = 1;
            this.JFTFValorAdd.setEnabled(true);
            this.JFTFValorAdd.setValue(0);
            this.JDC_AFecha.setEnabled(false);
            this.JDC_AFecha.setDate((Date) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorAddFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorAddActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorAddPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoAItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        this.xfiltro = "IN(0,1)";
        mCargarDatos_Documentos(Principal.txtNo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RegistradosActionPerformed(ActionEvent evt) {
        this.xfiltro = "IN(1)";
        mCargarDatos_Documentos(Principal.txtNo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoSeguimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoSeguimientoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFNombreBusqueda.getText().isEmpty()) {
                mCargarDatosHistorico();
            } else {
                this.xtipobusqueda = 0;
                mCargarDatosHistorico();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValor1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValor1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTF_FRValor1PropertyChange(PropertyChangeEvent evt) {
    }

    private void mCrearTablaDetalle_RFactura() {
        this.xmodelo_f = new DefaultTableModel() { // from class: ComprasBS.JIFSolicitudContrato.36
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo_f.addColumn("N° Radicación");
        this.xmodelo_f.addColumn("FRadicación");
        this.xmodelo_f.addColumn("FFactura");
        this.xmodelo_f.addColumn("N° Factura");
        this.xmodelo_f.addColumn("Valor");
        this.xmodelo_f.addColumn("Pagada?");
        this.xmodelo_f.addColumn("Usuario");
        this.xmodelo_f.addColumn("Url Factura");
        JTable jTable = this.JTB_DFRadicadas;
        JTable jTable2 = this.JTB_DFRadicadas;
        jTable.setAutoResizeMode(0);
        this.JTB_DFRadicadas.doLayout();
        this.JTB_DFRadicadas.setModel(this.xmodelo_f);
        this.JTB_DFRadicadas.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTB_DFRadicadas.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTB_DFRadicadas.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTB_DFRadicadas.setModel(this.xmodelo_f);
    }

    private void mConsecutivo() {
        if (Principal.txtNo.getText().isEmpty()) {
            int Con = 0;
            String sql = "SELECT MAX(`NInterno`) as MaximoCons FROM `cc_orden_compra` WHERE (`Id_TipoDocF` ='" + this.xtipodoc[this.JCBTipoDocF.getSelectedIndex()] + "' AND `Estado` =1);";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(sql);
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    Con = xrs1.getInt("MaximoCons");
                }
                xrs1.close();
                xct1.cerrarConexionBd();
                this.JTFNumContrato.setText("" + (Con + 1));
            } catch (SQLException ex) {
                Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JTFCodigocontrato.setText("");
        this.JTFNombreBusqueda.setText("");
        this.JTAObjetivoG.setText("");
        this.JTFNumContrato.setText("");
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JFTFValorDoc1.setValue(new Integer(0));
        this.JTFFTotalIva.setValue(new Integer(0));
        this.JTFFTotal.setValue(new Integer(0));
        this.JSPIva.setValue(new Integer(0));
        this.JLCodigoDoc1.setText("0");
        this.JCBAdministrador.setSelectedIndex(-1);
        Principal.txtNo.setText("");
        this.JDC_SFecha.setDate(this.xmt.getFechaActual());
        this.JTA_SDescripcion.setText("");
        this.JRBNo.setSelected(true);
        this.xesProrroga = 0;
        this.JCBTercero.removeAllItems();
        this.JCBTercero.setSelectedIndex(-1);
        mIniciarCombo();
        this.xlleno = true;
        this.JRBFecha.setSelected(true);
        JRBFechaActionPerformed(null);
        this.JTAObservacionA.setText("");
        mCargarDatosHistorico();
        mCrearModeloDatos_Seguimiento();
        mCrearModelo_Documentos();
        mCrearTablaDetalle_RFactura();
        mCrearModelo_Adiciones();
    }

    private void mIniciarCombo() {
        this.JCBUnidadF.removeAllItems();
        this.xunidadf = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xunidadf, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTipoSeguimiento.removeAllItems();
        this.xTipoSeguimiento = this.xconsultas.llenarCombo("Select Id,Nbre from `cc_tipo_seguimiento_contrato` where estado = 1;", this.xTipoSeguimiento, this.JCBTipoSeguimiento);
        this.JCBTipoSeguimiento.setSelectedIndex(-1);
        this.JCBAdministrador.removeAllItems();
        this.xiadministrador = this.xconsultas.llenarCombo("SELECT    `rh_tipo_persona_cargon`.`Id`    , CONCAT(CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) , ' - ', `rh_tipo_cargo`.`Nbre`) AS `Nombre`FROM    `rh_tipo_persona_cargon`    INNER JOIN `rh_unidadf_cargo`         ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)    INNER JOIN `rh_tipo_cargo`         ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)    INNER JOIN `g_persona`         ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)WHERE (`rh_tipo_persona_cargon`.`Estado` =1)ORDER BY `Nombre` ASC;", this.xiadministrador, this.JCBAdministrador);
        this.JCBAdministrador.setSelectedIndex(-1);
        this.JCBTipoDocF.removeAllItems();
        this.xtipodoc = this.xconsultas.llenarCombo("SELECT `Id`,`Nbre` FROM `cc_tipo_documentof` WHERE (Estado =1 and Tipo=3) ORDER BY Nbre ASC", this.xtipodoc, this.JCBTipoDocF);
        this.JCBTipoDocF.setSelectedIndex(-1);
        this.JCBTipoDocumentoA.removeAllItems();
        this.xidtipodocadicion = this.xconsultas.llenarCombo("SELECT `Id`,`Nbre` FROM `cc_tipo_documentof` WHERE (Estado =1 AND Tipo=4) ORDER BY Nbre ASC ", this.xidtipodocadicion, this.JCBTipoDocumentoA);
        this.JCBTipoDocumentoA.setSelectedIndex(-1);
    }

    private void mTotalizar() {
        this.JTFFTotalIva.setValue(Double.valueOf((Double.valueOf(this.JFTFValorDoc1.getValue().toString()).doubleValue() * Double.valueOf(this.JSPIva.getValue().toString()).doubleValue()) / 100.0d));
        this.JTFFTotal.setValue(Double.valueOf(Double.valueOf(this.JFTFValorDoc1.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFTotalIva.getValue().toString()).doubleValue()));
    }

    private void mConcecutivo() {
        int Con = 0;
        this.xsql = "SELECT  MAX(`NInterno`) as MaximoCons FROM `cc_orden_compra` WHERE (`Id_TipoDocF` ='" + this.xtipodoc[this.JCBTipoDocF.getSelectedIndex()] + "' AND DATE_FORMAT(`FechaC`,'%Y') ='" + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + "' ) GROUP BY `Id_TipoDocF` ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudContrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mCalcularTiempo() {
        try {
            this.xsql = "select if(round(datediff('" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "', '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "')/30)<=0, CONCAT(1,' Mes'),CONCAT(round(datediff('" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "', '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "')/30), ' Meses'))  dif";
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBDuracion.setText(xrs.getString(1));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudContrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JCBAdministrador.getSelectedIndex() == -1) {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Administrador", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBAdministrador.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JFTFValorDoc1.getValue().toString()).doubleValue() != 0.0d) {
                    if (!mPresupuesto()) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            mConcecutivo();
                            String sql = "INSERT INTO `cc_orden_compra`(NInterno,`FechaC`,`Id_Tercero`,`Id_UnidadF`,`Id_TipoDocF`,`ObjetivoG`,`ValorP`,`Iva`,`Id_Administrador`,`IdDisponibilidad`,FechaFin, EsProg, Estado,`Fecha`, Id_PersonaRh,`UsuarioS`)Values ('" + this.JTFNumContrato.getText() + "','" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xunidadf[this.JCBUnidadF.getSelectedIndex()] + "','" + this.xtipodoc[this.JCBTipoDocF.getSelectedIndex()] + "','" + this.JTAObjetivoG.getText() + "','" + this.JFTFValorDoc1.getValue() + "','" + this.JSPIva.getValue() + "','" + this.xiadministrador[this.JCBAdministrador.getSelectedIndex()] + "','" + this.JLCodigoDoc1.getText() + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xesProrroga + "','" + this.xestado + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                            mNuevo();
                            this.xconsultas.cerrarConexionBd();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Disponibilidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JLCodigoDoc1.requestFocus();
                    this.JLCodigoDoc1.setBackground(Color.red);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El Valor de la Propuesta no puede ser 0", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JFTFValorDoc1.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JTPPrincipal.getSelectedIndex() == 0) {
                mGrabar_Seguimiento();
                return;
            } else if (this.JTPPrincipal.getSelectedIndex() == 1) {
                mGrabar_Docmentos();
                return;
            } else {
                if (this.JTPPrincipal.getSelectedIndex() == 2) {
                    mGrabar_Adiciones();
                    return;
                }
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No existe proyecto seleccionado", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private boolean mPresupuesto() {
        boolean xPto = false;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && this.JLCodigoDoc1.getText().equals("0")) {
            xPto = true;
        }
        return xPto;
    }

    public void mCargarDatosHistorico() {
        try {
            String sql = "SELECT `cc_orden_compra`.`Id`, `cc_orden_compra`.`NInterno`, `cc_orden_compra`.`FechaC` , `cc_terceros`.`RazonSocialCompleta` AS `razon social`, `cc_unidad_funcional`.`Nbre` AS `unidad funcional`, `cc_tipo_documentof`.`Nbre` AS `tipo documento`, `cc_orden_compra`.`ObjetivoG`, `cc_orden_compra`.`ValorP`, `cc_orden_compra`.`Iva`, CONCAT(CONCAT(g_persona.Apellido1 ,' ', g_persona.Apellido2 ,' ', g_persona.Nombre1 ,' ', g_persona.Nombre2) , ' - ', rh_tipo_cargo.Nbre) AS `administrador`, `rh_tipo_cargo`.`Nbre` AS `cargo`, cc_orden_compra.IdDisponibilidad ,IF(`cc_orden_compra_adicion`.`FechaP` IS NULL, cc_orden_compra.`FechaFin`, `cc_orden_compra_adicion`.`FechaP`) , cc_orden_compra.Fecha, cc_orden_compra.Estado, cc_orden_compra.UsuarioS , IF(ROUND(DATEDIFF(cc_orden_compra.`FechaFin`, cc_orden_compra.`FechaC`)/30)<=0,  CONCAT(1,' Mes'),CONCAT(ROUND(DATEDIFF(cc_orden_compra.`FechaFin`, cc_orden_compra.`FechaC`)/30), ' Meses')) AS duracion , cc_orden_compra.EsProg , IF(cc_orden_compra_cierre.`Estado`=1,-2,  IF( `cc_tipo_documentof`.`NDias`=0, -1,  IF( (DATEDIFF(ADDDATE(IF(`cc_orden_compra_adicion`.`FechaP` IS NULL, cc_orden_compra.`FechaFin`, `cc_orden_compra_adicion`.`FechaP`), INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())<=30), 0,  IF( (DATEDIFF(ADDDATE(IF(`cc_orden_compra_adicion`.`FechaP` IS NULL, cc_orden_compra.`FechaFin`, `cc_orden_compra_adicion`.`FechaP`), INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())>30   AND DATEDIFF(ADDDATE(IF(`cc_orden_compra_adicion`.`FechaP` IS NULL, cc_orden_compra.`FechaFin`, `cc_orden_compra_adicion`.`FechaP`), INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())<=90), 1,  IF(DATEDIFF(ADDDATE(IF(`cc_orden_compra_adicion`.`FechaP` IS NULL, cc_orden_compra.`FechaFin`, `cc_orden_compra_adicion`.`FechaP`), INTERVAL `cc_tipo_documentof`.`NDias` DAY), NOW())>90, 2,3))))) Validacion FROM `cc_unidad_funcional`INNER JOIN `cc_orden_compra`  ON (`cc_unidad_funcional`.`Id` = `cc_orden_compra`.`Id_UnidadF`)LEFT  JOIN `cc_orden_compra_cierre` ON (`cc_orden_compra_cierre`.`Id_Orden_Compra` = `cc_orden_compra`.`Id`) AND (cc_orden_compra_cierre.`Estado`=1)\nINNER JOIN `cc_tipo_documentof` ON (`cc_orden_compra`.`Id_TipoDocF` = `cc_tipo_documentof`.`Id`)INNER JOIN `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `cc_orden_compra`.`Id_Administrador`)INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_orden_compra`.`Id_Tercero`)INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) LEFT JOIN `cc_orden_compra_adicion`  ON (`cc_orden_compra_adicion`.`Id_OrdenCompra` = `cc_orden_compra`.`Id`) AND (cc_orden_compra_adicion.`Estado`=1) WHERE (`cc_orden_compra`.`NInterno` LIKE '%" + this.JTFCodigocontrato.getText() + "%' AND `cc_terceros`.`RazonSocialCompleta` LIKE '%" + this.JTFNombreBusqueda.getText() + "%' AND cc_tipo_documentof.Tipo=3 AND `cc_orden_compra`.`Estado` =1);";
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(15)), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString("duracion"), n, 16);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("EsProg")), n, 17);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Validacion")), n, 18);
                    this.JTBH_Historico.setDefaultRenderer(Object.class, new MiRenderHistorico());
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        mCrearModeloDatos_Seguimiento();
    }

    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "N_Contrato", "FechaC", "Tercero", "Unidad Func", "Tipo Doc", "ObjetivoG", "ValorP", "Iva", "Administrador", "Cargo", "IdDisponibilidad", "FechaFin", "Fecha", "Estado", "UsuarioS", "Duracion", "EsProrroga?", "Validacion"}) { // from class: ComprasBS.JIFSolicitudContrato.37
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Long.class, String.class, String.class, Long.class, String.class, String.class, Boolean.class, String.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTBH_Historico;
        JTable jTable2 = this.JTBH_Historico;
        jTable.setAutoResizeMode(0);
        this.JTBH_Historico.doLayout();
        this.JTBH_Historico.setModel(this.xmodelo);
        this.JTBH_Historico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBH_Historico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBH_Historico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBH_Historico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBH_Historico.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBH_Historico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBH_Historico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTBH_Historico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBH_Historico.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTBH_Historico.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(17).setPreferredWidth(60);
        this.JTBH_Historico.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBH_Historico.getColumnModel().getColumn(18).setMaxWidth(0);
    }

    private void mGrabar_Seguimiento() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.JTA_SDescripcion.getText().isEmpty()) {
                if (this.JCBTipoSeguimiento.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "INSERT INTO `cc_orden_compra_seguimiento` (`Id_OrdenC`,`FechaS`,`Observacion`,`Estado`,`UsuarioS`, Id_tipo_Seguiendo)values('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDC_SFecha.getDate()) + "','" + this.JTA_SDescripcion.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', " + this.xTipoSeguimiento[this.JCBTipoSeguimiento.getSelectedIndex()] + ")";
                        this.xconsultas.ejecutarSQL(this.xsql);
                        this.xconsultas.cerrarConexionBd();
                        mCargarDatosTabla_Seguimiento();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Se debe Selecionar un tipo de Seguimiento", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Solicitud de Contrato ya Existente", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTA_SDescripcion.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Solicitud de Contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        this.JDC_SFecha.setDate(this.xmt.getFechaActual());
        this.JTA_SDescripcion.setText("");
    }

    private void mCargarDatosTabla_Seguimiento() {
        try {
            mCrearModeloDatos_Seguimiento();
            this.xsql = "SELECT `cc_orden_compra_seguimiento`.`FechaS`,`cc_orden_compra_seguimiento`.`Observacion`,  `cc_orden_compra_seguimiento`.`UsuarioS`,`cc_tipo_seguimiento_contrato`. `Nbre`  FROM `cc_orden_compra_seguimiento`    INNER JOIN `cc_orden_compra`         ON (`cc_orden_compra_seguimiento`.`Id_OrdenC` = `cc_orden_compra`.`Id`)INNER JOIN `cc_tipo_seguimiento_contrato`\n ON (`cc_tipo_seguimiento_contrato`.`Id` = `cc_orden_compra_seguimiento`.`Id_tipo_Seguiendo`) WHERE (`cc_orden_compra`.`Id` = '" + Principal.txtNo.getText() + "')ORDER BY `cc_orden_compra_seguimiento`.`FechaS` ASC; ";
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo_s.addRow(this.xdatos_s);
                    this.xmodelo_s.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo_s.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo_s.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo_s.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            } else {
                mCrearModeloDatos_Seguimiento();
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudContrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_Seguimiento() {
        this.xmodelo_s = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Observación", "Usuario", "Tipo de seguimiento "}) { // from class: ComprasBS.JIFSolicitudContrato.38
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_SeguimientoD.setModel(this.xmodelo_s);
        this.JTB_SeguimientoD.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_SeguimientoD.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_SeguimientoD.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_SeguimientoD.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void mGrabar_Docmentos() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTBP_Documentos, 4)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    for (int y = 0; y < this.JTBP_Documentos.getRowCount(); y++) {
                        if (Boolean.valueOf(this.xmodelo_d.getValueAt(y, 4).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo_d.getValueAt(y, 5).toString()).booleanValue()) {
                            this.xsql = "INSERT INTO `cc_orden_compra_documento`(`Id_OrdenCompra`,`Id_TipoDocumento`,`Estado`,`Fecha`,`Id_UsuarioS`) values('" + Principal.txtNo.getText() + "','" + this.xmodelo_d.getValueAt(y, 0).toString() + "','" + this.xestado + "','" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                            this.xconsultas.ejecutarSQL(this.xsql);
                            this.xconsultas.cerrarConexionBd();
                        }
                    }
                    mCargarDatos_Documentos(Principal.txtNo.getText());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Documentos() {
        this.xmodelo_d = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Es Entregable?", "Nº Dias", "Seleccionar", "Grabada", "Id_Documento", "NValidacion"}) { // from class: ComprasBS.JIFSolicitudContrato.39
            Class[] types = {Long.class, String.class, Boolean.class, Integer.class, Boolean.class, Boolean.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBP_Documentos.setModel(this.xmodelo_d);
        this.JTBP_Documentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBP_Documentos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBP_Documentos.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBP_Documentos.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBP_Documentos.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBP_Documentos.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBP_Documentos.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    public void mCargarDatos_Documentos(String idOrdenCompra) {
        try {
            mCrearModelo_Documentos();
            String sql = "SELECT\n    `cc_tipo_documentos_soporte`.`Id`\n    , `cc_tipo_documentos_soporte`.`Nbre`\n    , `cc_tipo_documentos_soporte`.`Tipo`\n    , `cc_tipo_documentos_soporte`.`NDias`\n    , IF(`cc_orden_compra_documento`.`Id_OrdenCompra` IS NULL,  0, 1) EsGrabada\n    , IFNULL(`cc_orden_compra_documento`.`Id`,0) Id_Documento\n    , IFNULL(d.NValidacionV, 0) NValidacion\nFROM\n    `cc_tipo_documento_filtro_soporte`\n    INNER JOIN `cc_tipo_documentos_soporte` \n        ON (`cc_tipo_documento_filtro_soporte`.`Id_TipoDocSoporte` = `cc_tipo_documentos_soporte`.`Id`)\n    LEFT JOIN `cc_orden_compra_documento` \n        ON (`cc_orden_compra_documento`.`Id_TipoDocumento` = `cc_tipo_documentos_soporte`.`Id`) AND ( `cc_orden_compra_documento`.Id_OrdenCompra='" + Principal.txtNo.getText() + "')\nLEFT JOIN (SELECT `cc_orden_compra_documento`.`Id_OrdenCompra`, `cc_orden_compra_documento_evidencia`.`Estado`, `cc_tipo_documentos_soporte`.`Id`,\n  IF( `cc_tipo_documentos_soporte`.`NDias`=0, -1,\n    IF( (DATEDIFF(ADDDATE(`cc_orden_compra_documento_evidencia`.`FechaE`, INTERVAL `cc_tipo_documentos_soporte`.`NDias` DAY), NOW())<=30), 0,\n     IF( (DATEDIFF(ADDDATE(`cc_orden_compra_documento_evidencia`.`FechaE`, INTERVAL `cc_tipo_documentos_soporte`.`NDias` DAY), NOW())>30 \n    AND DATEDIFF(ADDDATE(`cc_orden_compra_documento_evidencia`.`FechaE`, INTERVAL `cc_tipo_documentos_soporte`.`NDias` DAY), NOW())<=90), 1,\n     IF(DATEDIFF(ADDDATE(`cc_orden_compra_documento_evidencia`.`FechaE`, INTERVAL `cc_tipo_documentos_soporte`.`NDias` DAY), NOW())>90, 2,3)))) NValidacionV\nFROM\n     `cc_orden_compra_documento_evidencia`\n    INNER JOIN  `cc_orden_compra_documento` \n        ON (`cc_orden_compra_documento_evidencia`.`Id_orden_compra_documento` = `cc_orden_compra_documento`.`Id`)\n    INNER JOIN  `cc_tipo_documentos_soporte` \n        ON (`cc_orden_compra_documento`.`Id_TipoDocumento` = `cc_tipo_documentos_soporte`.`Id`)\n) d      \n    ON  (d.`Id_OrdenCompra` =IFNULL(`cc_orden_compra_documento`.`Id_OrdenCompra`,0))    AND  (d.`Estado` =1)\n    AND (d.`Id` =`cc_tipo_documentos_soporte`.`Id`)\n        \n        \nWHERE (IF(`cc_orden_compra_documento`.`Id_OrdenCompra` IS NULL,  0, 1) " + this.xfiltro + " and `cc_tipo_documento_filtro_soporte`.`Id_TipoDoc` ='" + this.xtipodoc[this.JCBTipoDocF.getSelectedIndex()] + "' AND cc_tipo_documentos_soporte.`Estado`=1 )\nORDER BY cc_tipo_documento_filtro_soporte.`NOrden` ASC";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo_d.addRow(this.xdatos_d);
                    this.xmodelo_d.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo_d.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo_d.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo_d.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo_d.setValueAt(Boolean.valueOf(xrs.getBoolean("EsGrabada")), n, 4);
                    this.xmodelo_d.setValueAt(Boolean.valueOf(xrs.getBoolean("EsGrabada")), n, 5);
                    this.xmodelo_d.setValueAt(Long.valueOf(xrs.getLong("Id_Documento")), n, 6);
                    this.xmodelo_d.setValueAt(Integer.valueOf(xrs.getInt("NValidacion")), n, 7);
                    this.JTBP_Documentos.setDefaultRenderer(Object.class, new MiRenderDoc());
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudContrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar_Adiciones() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoDocumentoA.getSelectedIndex() != -1) {
                if (!this.JTAObservacionA.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        AdicionContratoDTO e = new AdicionContratoDTO();
                        e.setIdContrato(Long.valueOf(Principal.txtNo.getText()));
                        e.setTipo(String.valueOf(this.xtipo));
                        if (this.xtipo == 0) {
                            e.setValor((Double) null);
                            e.setFechaP(this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()));
                        } else {
                            e.setValor(Double.valueOf(this.JFTFValorAdd.getValue().toString()));
                            e.setFechaP((String) null);
                        }
                        e.setIdTipoDocF(this.xidtipodocadicion[this.JCBTipoDocumentoA.getSelectedIndex()]);
                        e.setObservacion(this.JTAObservacionA.getText());
                        e.setEstado(1);
                        this.xAdicionContratoDAO.create(e);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar una observacion", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAObservacionA.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDocumentoA.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Solicitud de Contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        this.JRBFecha.setSelected(true);
        JRBFechaActionPerformed(null);
        this.JCBTipoDocumentoA.setSelectedIndex(-1);
        this.JTAObservacionA.setText("");
        mCargarDatos_Adiciones(Principal.txtNo.getText());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Adiciones() {
        this.xmodelo_a = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Documento", "Fecha", "Valor", "Observacion", "Estado"}) { // from class: ComprasBS.JIFSolicitudContrato.40
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_AdicionD.setModel(this.xmodelo_a);
        this.JTB_AdicionD.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_AdicionD.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_AdicionD.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_AdicionD.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_AdicionD.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTB_AdicionD.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTB_AdicionD.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTB_AdicionD.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTB_AdicionD.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    public void mCargarDatos_Adiciones(String idcocumentoC) {
        mCrearModelo_Adiciones();
        List<AdicionContratoDTO> list = this.xAdicionContratoDAO.list(idcocumentoC);
        double valorTotal = 0.0d;
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo_a.addRow(this.xdatos_a);
            this.xmodelo_a.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo_a.setValueAt(list.get(x).getTipo(), x, 1);
            this.xmodelo_a.setValueAt(list.get(x).getIdTipoDocF(), x, 2);
            this.xmodelo_a.setValueAt(list.get(x).getFechaP(), x, 3);
            this.xmodelo_a.setValueAt(list.get(x).getValor(), x, 4);
            this.xmodelo_a.setValueAt(list.get(x).getObservacion(), x, 5);
            valorTotal += list.get(x).getValor().doubleValue();
            if (list.get(x).getEstado() == 1) {
                this.xmodelo_a.setValueAt(true, x, 6);
            } else {
                this.xmodelo_a.setValueAt(false, x, 6);
            }
        }
        this.JTFFTotalAdicion.setValue(Double.valueOf(valorTotal));
        this.JTFFTotal.setValue(Double.valueOf(Double.valueOf(this.JFTFValorDoc1.getValue().toString()).doubleValue() + valorTotal));
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFSolicitudContrato$MiRenderDoc.class */
    public static class MiRenderDoc extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int nvalidacion = Integer.valueOf(table.getValueAt(row, 7).toString()).intValue();
            if (!Boolean.valueOf(table.getValueAt(row, 5).toString()).booleanValue() || nvalidacion == -1 || nvalidacion == 3) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else if (nvalidacion == 0) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
            } else if (nvalidacion == 1) {
                cell.setBackground(new Color(255, 255, 0));
                cell.setForeground(Color.BLACK);
            } else if (nvalidacion == 2) {
                cell.setBackground(new Color(0, 204, 0));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFSolicitudContrato$MiRenderHistorico.class */
    public static class MiRenderHistorico extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int nvalidacion = Integer.valueOf(table.getValueAt(row, 18).toString()).intValue();
            switch (nvalidacion) {
                case -2:
                    cell.setBackground(Color.cyan);
                    cell.setForeground(Color.BLACK);
                    break;
                case -1:
                case 3:
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
                case 0:
                    cell.setBackground(Color.red);
                    cell.setForeground(Color.BLACK);
                    break;
                case 1:
                    cell.setBackground(new Color(255, 255, 0));
                    cell.setForeground(Color.BLACK);
                    break;
                case 2:
                    cell.setBackground(new Color(0, 204, 0));
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    public void mCargarDatos_FRadicados() {
        try {
            mCrearTablaDetalle_RFactura();
            String sql = "SELECT cc_radicacion.Id,\nDATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y') FRadicacion,\nDATE_FORMAT(cc_radicacion.FechaFac,'%d-%m-%Y') FFactura,\ncc_radicacion.NoFactura,   \n(cc_radicacion.`SubTotal`+cc_radicacion.`Otros`+cc_radicacion.`Flete`+cc_radicacion.`Iva`) Valor,\n  IF(Id_Comprobante=0,FALSE,TRUE) AS Pagada,\n    cc_radicacion.UsuarioS,  \n  cc_radicacion.UrlFactura   \n \n   FROM cc_radicacion \n   LEFT JOIN `pp_movimiento`ON (`pp_movimiento`.`Id` = `cc_radicacion`.`Id_Compromiso`) \n   INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = `cc_terceros`.Id) \n   INNER JOIN cc_conceptocmsa  ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)   \n   WHERE (cc_radicacion.Estado=1 AND  cc_radicacion.`Id_Proveedor`='" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "' AND cc_radicacion.`NoCompra`='" + Principal.txtNo.getText() + "') \n   ORDER BY cc_radicacion.Id  DESC ";
            double xValor = 0.0d;
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo_f.addRow(this.xdatos_d);
                    this.xmodelo_f.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo_f.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo_f.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo_f.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo_f.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo_f.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo_f.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo_f.setValueAt(xrs.getString(8), n, 7);
                    xValor += xrs.getDouble(5);
                    n++;
                }
            }
            this.JFTF_FRValor.setValue(Double.valueOf(xValor));
            this.JFTF_FRValor1.setValue(Double.valueOf(Double.valueOf(this.JTFFTotal.getValue().toString()).doubleValue() - xValor));
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudContrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
