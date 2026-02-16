package Contabilidad;

import Acceso.Principal;
import General.Anular;
import Historia.JDPatologia;
import Presupuesto.JDBusquedaMovPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos;
import com.genoma.plus.jpa.dto.EntradaRadicacionDTO;
import com.genoma.plus.jpa.entities.CcRadicacion;
import com.genoma.plus.jpa.entities.CcRadicacionCompromiso;
import com.genoma.plus.jpa.entities.FacturaEquivalenteDTO;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.IEntradaService;
import com.genoma.plus.jpa.service.IRadicacionCompromisoService;
import com.genoma.plus.jpa.service.IRadicacionService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFRadicacion.class */
public class JIFRadicacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[] xidunidadfuncional;
    private String[] xidcuentas;
    public String[] xidconcepto;
    public String[][] xidcentrocosto;
    public String[][] xidauxiliar;
    public String[][] xidauxiliarxpagar;
    public String[][] xidempresa;
    private JIFConsultarDatos xjifconsultar;
    public claseContabilidad xclases;
    private Object[] xdato;
    private JIFConsultarDatosR xjifconsultarreembolsos;
    public JIFLiquidacionRad xjifliquidacionr;
    private String xIdClaseDoc;
    private String xcc_puc;
    private List<IResolucionFacturaElectronica> resoluciones;
    public List<CcRadicacionCompromiso> radicacionCompromisos;
    private String idFacturaInterna;
    private Long idEntrada;
    private EntradaRadicacionDTO entrada;
    private JButton JBBuscaTercero;
    private JButton JBBuscar;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBG_TipoRadicacion;
    private JButton JBTActualizarCo;
    private JButton JBTConsultarReembolsoA;
    private JButton JBTGenerar;
    private JButton JBTGenerarDocumentoSoporte;
    private JButton JBTGrabar1;
    private JComboBox JCBConcepto;
    private JComboBox JCBCuenta;
    public JComboBox JCBCuentaAuxiliar;
    public JComboBox JCBCuentaAuxiliarPagar;
    public JComboBox JCBEmpresa;
    private JComboBox<String> JCBResolucionDian;
    private JComboBox JCBUnidadFuncional;
    private JCheckBox JCHFiltro;
    public JDateChooser JDFFechaFact;
    public JDateChooser JDFFechaOC;
    public JDateChooser JDFFechaR;
    public JLabel JLBId;
    private JLabel JLBNFactInterna;
    public JLabel JLCodigoDoc1;
    private JPanel JPDatosB;
    private JPanel JPDatospago;
    private JPanel JPIDContable;
    private JPanel JPIFacturaInterna;
    private JPanel JPIRadicado;
    private JPanel JPI_TipoRadicacion;
    private JPanel JPValores;
    private JRadioButton JRBT_Excedente;
    private JRadioButton JRBT_RPropios;
    private JRadioButton JRBT_Reembolzable;
    private JRadioButton JRB_TNormal;
    private JRadioButton JRB_TVigenciaAnterior;
    private JSpinner JSPCantidad;
    private JScrollPane JSPConcepto;
    private JSpinner JSPNMedicamentos;
    private JSpinner JSPNPacientes;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    public JTextPane JTAConcepto;
    public JTextArea JTAConceptoC;
    private JTextPane JTAObservacion;
    public JFormattedTextField JTFFFlete;
    public JFormattedTextField JTFFIva;
    public JFormattedTextField JTFFOtros;
    private JFormattedTextField JTFFPRetFuente;
    public JFormattedTextField JTFFSubTotal;
    public JFormattedTextField JTFFTotalFactura;
    private JFormattedTextField JTFFVTotal;
    private JFormattedTextField JTFFVUnitario;
    public JTextField JTFNFactura;
    public JTextField JTFNOrdenCompra;
    private JTextField JTFPeriodoFac;
    private JTextField JTFTercero;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosC;
    public JTable JTResultado;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private CcRadicacion radicacionNueva = new CcRadicacion();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    private long xidnfacturainterna = 0;
    private String xidcuentapuc = "0";
    private int xesreembolso = 0;
    private int xtipo = 0;
    private int xIdTipoO = 1;
    public long xIDCompromiso = 0;
    private long xid = 0;
    public Vector xvector = new Vector();
    public int tipo = 0;
    private final IResolucionDianDAO resolucionDian = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private final IRadicacionService iRadicacionService = (IRadicacionService) Principal.contexto.getBean(IRadicacionService.class);
    private final IEntradaService iEntradaService = (IEntradaService) Principal.contexto.getBean(IEntradaService.class);
    private final IRadicacionCompromisoService iRadicacionCompromisoService = (IRadicacionCompromisoService) Principal.contexto.getBean(IRadicacionCompromisoService.class);
    private CcRadicacion radicacion = new CcRadicacion();

    public JIFRadicacion(claseContabilidad xclases) {
        initComponents();
        this.xclases = xclases;
        inicalizacionCondtructor();
    }

    public JIFRadicacion(claseContabilidad xclases, Long idEntrada) {
        initComponents();
        this.idEntrada = idEntrada;
        this.xclases = xclases;
        inicalizacionCondtructor();
        cargarDatosEntrada();
    }

    /* JADX WARN: Type inference failed for: r3v301, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBG_TipoRadicacion = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIRadicado = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JPValores = new JPanel();
        this.JTFFSubTotal = new JFormattedTextField();
        this.JTFFIva = new JFormattedTextField();
        this.JTFFFlete = new JFormattedTextField();
        this.JTFFOtros = new JFormattedTextField();
        this.JTFFTotalFactura = new JFormattedTextField();
        this.JCBEmpresa = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JTFNFactura = new JTextField();
        this.JDFFechaFact = new JDateChooser();
        this.JTFNOrdenCompra = new JTextField();
        this.JDFFechaOC = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConceptoC = new JTextArea();
        this.JTPDatosC = new JTabbedPane();
        this.JPIDContable = new JPanel();
        this.JCBUnidadFuncional = new JComboBox();
        this.JCBCuenta = new JComboBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        this.JCBCuentaAuxiliarPagar = new JComboBox();
        this.JCBConcepto = new JComboBox();
        this.JPI_TipoRadicacion = new JPanel();
        this.JRB_TNormal = new JRadioButton();
        this.JRB_TVigenciaAnterior = new JRadioButton();
        this.JPIFacturaInterna = new JPanel();
        this.JSPConcepto = new JScrollPane();
        this.JTAConcepto = new JTextPane();
        this.JSPCantidad = new JSpinner();
        this.JTFFVUnitario = new JFormattedTextField();
        this.JTFFVTotal = new JFormattedTextField();
        this.JLBNFactInterna = new JLabel();
        this.JBTGenerar = new JButton();
        this.JCBResolucionDian = new JComboBox<>();
        this.JTFFPRetFuente = new JFormattedTextField();
        this.jPanel4 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JSPNPacientes = new JSpinner();
        this.JSPNMedicamentos = new JSpinner();
        this.JTFPeriodoFac = new JTextField();
        this.jPanel3 = new JPanel();
        this.JRBT_Reembolzable = new JRadioButton();
        this.JRBT_Excedente = new JRadioButton();
        this.JRBT_RPropios = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JBTGrabar1 = new JButton();
        this.JBTActualizarCo = new JButton();
        this.JBTConsultarReembolsoA = new JButton();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc1 = new JLabel();
        this.JBBuscaTercero = new JButton();
        this.JBTGenerarDocumentoSoporte = new JButton();
        this.JLBId = new JLabel();
        this.JPDatospago = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPDatosB = new JPanel();
        this.JTFTercero = new JTextField();
        this.JCHFiltro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("RADICACIÓN DE FACTURAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifradicacionfac");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFRadicacion.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRadicacion.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIRadicado.setFont(new Font("Arial", 1, 13));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JDFFechaR.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFRadicacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRadicacion.this.JDFFechaRPropertyChange(evt);
            }
        });
        this.JPValores.setBorder(BorderFactory.createTitledBorder((Border) null, "VALORES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFSubTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSubTotal.setHorizontalAlignment(4);
        this.JTFFSubTotal.setFont(new Font("Arial", 1, 13));
        this.JTFFSubTotal.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.3
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFSubTotalActionPerformed(evt);
            }
        });
        this.JTFFSubTotal.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.4
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFSubTotalFocusLost(evt);
            }
        });
        this.JTFFIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFIva.setHorizontalAlignment(4);
        this.JTFFIva.setFont(new Font("Arial", 1, 13));
        this.JTFFIva.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFIvaActionPerformed(evt);
            }
        });
        this.JTFFIva.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.6
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFIvaFocusLost(evt);
            }
        });
        this.JTFFFlete.setBorder(BorderFactory.createTitledBorder((Border) null, "Flete", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFlete.setHorizontalAlignment(4);
        this.JTFFFlete.setFont(new Font("Arial", 1, 13));
        this.JTFFFlete.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFFleteActionPerformed(evt);
            }
        });
        this.JTFFFlete.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.8
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFFleteFocusLost(evt);
            }
        });
        this.JTFFOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFOtros.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFOtros.setHorizontalAlignment(4);
        this.JTFFOtros.setFont(new Font("Arial", 1, 13));
        this.JTFFOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.9
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFOtrosActionPerformed(evt);
            }
        });
        this.JTFFOtros.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.10
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFOtrosFocusLost(evt);
            }
        });
        this.JTFFTotalFactura.setBackground(new Color(0, 102, 0));
        this.JTFFTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalFactura.setForeground(new Color(255, 255, 255));
        this.JTFFTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalFactura.setHorizontalAlignment(4);
        this.JTFFTotalFactura.setEnabled(false);
        this.JTFFTotalFactura.setFont(new Font("Arial", 1, 24));
        GroupLayout JPValoresLayout = new GroupLayout(this.JPValores);
        this.JPValores.setLayout(JPValoresLayout);
        JPValoresLayout.setHorizontalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addContainerGap().addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFOtros, GroupLayout.Alignment.TRAILING, -1, 127, 32767).addComponent(this.JTFFSubTotal)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addComponent(this.JTFFIva, -1, 113, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFlete, -1, 113, 32767)).addComponent(this.JTFFTotalFactura)).addContainerGap()));
        JPValoresLayout.setVerticalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSubTotal).addComponent(this.JTFFIva).addComponent(this.JTFFFlete)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFOtros).addComponent(this.JTFFTotalFactura)).addGap(6, 6, 6)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacion.11
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacion.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.12
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE FACTURA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNFactura.setFont(new Font("Arial", 1, 12));
        this.JTFNFactura.setHorizontalAlignment(2);
        this.JTFNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNFactura.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.13
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFNFacturaFocusLost(evt);
            }
        });
        this.JTFNFactura.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.14
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFNFacturaActionPerformed(evt);
            }
        });
        this.JDFFechaFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaFact.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaFact.setFont(new Font("Arial", 1, 12));
        this.JTFNOrdenCompra.setFont(new Font("Arial", 1, 12));
        this.JTFNOrdenCompra.setHorizontalAlignment(2);
        this.JTFNOrdenCompra.setToolTipText("Número de Orden de Compra, Contrato o Servicio");
        this.JTFNOrdenCompra.setBorder(BorderFactory.createTitledBorder((Border) null, "N°(Oc, Os, C)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNOrdenCompra.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFRadicacion.15
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacion.this.JTFNOrdenCompraMouseClicked(evt);
            }
        });
        this.JDFFechaOC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha (Oc, Os, C)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaOC.setToolTipText("Fecha de Orden de Compra, Orden de Servicio o Contrato");
        this.JDFFechaOC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaOC.setFont(new Font("Arial", 1, 12));
        this.JTAConceptoC.setColumns(1);
        this.JTAConceptoC.setFont(new Font("Arial", 1, 12));
        this.JTAConceptoC.setLineWrap(true);
        this.JTAConceptoC.setRows(1);
        this.JTAConceptoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAConceptoC);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFFechaFact, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JTFNFactura, -2, 139, -2).addGap(18, 18, 18).addComponent(this.JDFFechaOC, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JTFNOrdenCompra, -2, 121, -2)).addComponent(this.jScrollPane1, -2, 570, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNOrdenCompra, GroupLayout.Alignment.LEADING).addComponent(this.JTFNFactura, GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaFact, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFFechaOC, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 90, 32767).addContainerGap()));
        this.JTPDatosC.setForeground(Color.red);
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JCBUnidadFuncional.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacion.16
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacion.this.JCBUnidadFuncionalItemStateChanged(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacion.17
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacion.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaAuxiliarPagar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliarPagar.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Auxiliar por Pagar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaAuxiliarPagar.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacion.18
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacion.this.JCBCuentaAuxiliarPagarItemStateChanged(evt);
            }
        });
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacion.19
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacion.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JPI_TipoRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Radicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_TipoRadicacion.add(this.JRB_TNormal);
        this.JRB_TNormal.setFont(new Font("Arial", 1, 12));
        this.JRB_TNormal.setSelected(true);
        this.JRB_TNormal.setText("Normal");
        this.JRB_TNormal.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.20
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JRB_TNormalActionPerformed(evt);
            }
        });
        this.JBG_TipoRadicacion.add(this.JRB_TVigenciaAnterior);
        this.JRB_TVigenciaAnterior.setFont(new Font("Arial", 1, 12));
        this.JRB_TVigenciaAnterior.setText("Vigencia Anterior");
        this.JRB_TVigenciaAnterior.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.21
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JRB_TVigenciaAnteriorActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoRadicacionLayout = new GroupLayout(this.JPI_TipoRadicacion);
        this.JPI_TipoRadicacion.setLayout(JPI_TipoRadicacionLayout);
        JPI_TipoRadicacionLayout.setHorizontalGroup(JPI_TipoRadicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoRadicacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_TNormal).addGap(18, 18, 18).addComponent(this.JRB_TVigenciaAnterior).addContainerGap(-1, 32767)));
        JPI_TipoRadicacionLayout.setVerticalGroup(JPI_TipoRadicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoRadicacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_TipoRadicacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_TNormal).addComponent(this.JRB_TVigenciaAnterior)).addContainerGap(-1, 32767)));
        GroupLayout JPIDContableLayout = new GroupLayout(this.JPIDContable);
        this.JPIDContable.setLayout(JPIDContableLayout);
        JPIDContableLayout.setHorizontalGroup(JPIDContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContableLayout.createSequentialGroup().addContainerGap().addGroup(JPIDContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContableLayout.createSequentialGroup().addComponent(this.JCBCuentaAuxiliarPagar, -2, 582, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConcepto, 0, -1, 32767)).addGroup(JPIDContableLayout.createSequentialGroup().addComponent(this.JCBUnidadFuncional, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCuenta, 0, 301, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCuentaAuxiliar, -2, 496, -2)).addGroup(JPIDContableLayout.createSequentialGroup().addComponent(this.JPI_TipoRadicacion, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIDContableLayout.setVerticalGroup(JPIDContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContableLayout.createSequentialGroup().addContainerGap().addGroup(JPIDContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2).addComponent(this.JCBUnidadFuncional, -2, 50, -2).addComponent(this.JCBCuenta)).addGap(18, 18, 18).addGroup(JPIDContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCuentaAuxiliarPagar, -2, 50, -2).addComponent(this.JCBConcepto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_TipoRadicacion, -2, -1, -2).addContainerGap()));
        this.JTPDatosC.addTab("DATOS CONTABLES", this.JPIDContable);
        this.JPIFacturaInterna.setBorder(BorderFactory.createTitledBorder((Border) null, "FACTURA INTERNA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JSPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAConcepto.setFont(new Font("Arial", 1, 13));
        this.JSPConcepto.setViewportView(this.JTAConcepto);
        this.JSPCantidad.setFont(new Font("Arial", 1, 13));
        this.JSPCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: Contabilidad.JIFRadicacion.22
            public void stateChanged(ChangeEvent evt) {
                JIFRadicacion.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTFFVUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVUnitario.setHorizontalAlignment(4);
        this.JTFFVUnitario.setText("0");
        this.JTFFVUnitario.setFont(new Font("Arial", 1, 13));
        this.JTFFVUnitario.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.23
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFVUnitarioFocusLost(evt);
            }
        });
        this.JTFFVUnitario.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.24
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFVUnitarioActionPerformed(evt);
            }
        });
        this.JTFFVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVTotal.setHorizontalAlignment(4);
        this.JTFFVTotal.setText("0");
        this.JTFFVTotal.setFont(new Font("Arial", 1, 13));
        this.JLBNFactInterna.setFont(new Font("Arial", 1, 18));
        this.JLBNFactInterna.setHorizontalAlignment(0);
        this.JLBNFactInterna.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerar.setText("<html><P ALIGN=center>Generar Factura Interna");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.25
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JCBResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolucion DIan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPRetFuente.setBorder(BorderFactory.createTitledBorder((Border) null, "% ReteFuente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPRetFuente.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFPRetFuente.setHorizontalAlignment(4);
        this.JTFFPRetFuente.setFont(new Font("Arial", 1, 13));
        this.JTFFPRetFuente.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacion.26
            public void focusLost(FocusEvent evt) {
                JIFRadicacion.this.JTFFPRetFuenteFocusLost(evt);
            }
        });
        this.JTFFPRetFuente.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.27
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JTFFPRetFuenteActionPerformed(evt);
            }
        });
        GroupLayout JPIFacturaInternaLayout = new GroupLayout(this.JPIFacturaInterna);
        this.JPIFacturaInterna.setLayout(JPIFacturaInternaLayout);
        JPIFacturaInternaLayout.setHorizontalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTGenerar, -2, 193, -2).addGap(18, 18, 18).addComponent(this.JCBResolucionDian, -2, 592, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNFactInterna, -2, 148, -2)).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JSPConcepto, -2, 617, -2).addGap(12, 12, 12).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JSPCantidad, -2, 68, -2).addGap(17, 17, 17).addComponent(this.JTFFVUnitario, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVTotal, -1, 156, 32767)).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JTFFPRetFuente, -2, 112, -2).addGap(0, 0, 32767))))).addContainerGap()));
        JPIFacturaInternaLayout.setVerticalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFVTotal, GroupLayout.Alignment.LEADING).addComponent(this.JTFFVUnitario, GroupLayout.Alignment.LEADING).addComponent(this.JSPCantidad, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPRetFuente, -1, 50, 32767)).addComponent(this.JSPConcepto)).addGap(11, 11, 11).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBResolucionDian, -2, 55, -2).addComponent(this.JBTGenerar, -2, 54, -2)).addContainerGap()).addComponent(this.JLBNFactInterna, -1, -1, 32767))));
        this.JTPDatosC.addTab("DOCUMENTO EQUIVALENTE", this.JPIFacturaInterna);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN MEDICINA PREPAGADA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPNPacientes.setFont(new Font("Arial", 0, 13));
        this.JSPNPacientes.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNPacientes.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Usuarios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNMedicamentos.setFont(new Font("Arial", 0, 13));
        this.JSPNMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Medicamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPeriodoFac.setFont(new Font("Arial", 1, 12));
        this.JTFPeriodoFac.setHorizontalAlignment(2);
        this.JTFPeriodoFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Período de Facturación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPNPacientes, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNMedicamentos, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPeriodoFac, -2, 261, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNPacientes, -2, 46, -2).addComponent(this.JSPNMedicamentos, -2, 46, -2).addComponent(this.JTFPeriodoFac, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBT_Reembolzable);
        this.JRBT_Reembolzable.setFont(new Font("Arial", 1, 12));
        this.JRBT_Reembolzable.setSelected(true);
        this.JRBT_Reembolzable.setText("Reembolzable");
        this.JRBT_Reembolzable.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.28
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JRBT_ReembolzableActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBT_Excedente);
        this.JRBT_Excedente.setFont(new Font("Arial", 1, 12));
        this.JRBT_Excedente.setText("Excedente");
        this.JRBT_Excedente.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.29
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JRBT_ExcedenteActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBT_RPropios);
        this.JRBT_RPropios.setFont(new Font("Arial", 1, 12));
        this.JRBT_RPropios.setText("Recursos Propios");
        this.JRBT_RPropios.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.30
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JRBT_RPropiosActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBT_Reembolzable).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBT_Excedente).addGap(18, 18, 18).addComponent(this.JRBT_RPropios, -2, 137, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBT_Reembolzable).addComponent(this.JRBT_Excedente).addComponent(this.JRBT_RPropios)).addContainerGap(15, 32767)));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767).addGap(47, 47, 47)).addGroup(jPanel4Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JSPObservacion).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel4Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jPanel3, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 59, -2).addContainerGap(-1, 32767)));
        this.JTPDatosC.addTab("DATOS ADICIONALES FPZ", this.jPanel4);
        this.JBTGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar1.setText("<html><P ALIGN=center>Generar Liquidación");
        this.JBTGrabar1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.31
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBTGrabar1ActionPerformed(evt);
            }
        });
        this.JBTActualizarCo.setFont(new Font("Arial", 1, 12));
        this.JBTActualizarCo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizarCo.setText("<html><P ALIGN=center> Actualizar Datos Contables");
        this.JBTActualizarCo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.32
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBTActualizarCoActionPerformed(evt);
            }
        });
        this.JBTConsultarReembolsoA.setFont(new Font("Arial", 1, 12));
        this.JBTConsultarReembolsoA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contrato.png")));
        this.JBTConsultarReembolsoA.setText("<html><P ALIGN=center>Consultar Reembolsos");
        this.JBTConsultarReembolsoA.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.33
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBTConsultarReembolsoAActionPerformed(evt);
            }
        });
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.34
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Arial", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "ID. Compromiso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.35
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JBTGenerarDocumentoSoporte.setFont(new Font("Arial", 1, 12));
        this.JBTGenerarDocumentoSoporte.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerarDocumentoSoporte.setText("<html><P ALIGN=center>Generar Documento Soporte");
        this.JBTGenerarDocumentoSoporte.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.36
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JBTGenerarDocumentoSoporteActionPerformed(evt);
            }
        });
        this.JLBId.setFont(new Font("Arial", 1, 12));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIRadicadoLayout = new GroupLayout(this.JPIRadicado);
        this.JPIRadicado.setLayout(JPIRadicadoLayout);
        JPIRadicadoLayout.setHorizontalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosC, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIRadicadoLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPValores, -2, -1, -2)).addGroup(JPIRadicadoLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 668, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2).addGap(18, 18, 18).addComponent(this.JLBId, -1, -1, 32767))).addGap(27, 27, 27)).addGroup(JPIRadicadoLayout.createSequentialGroup().addComponent(this.JBTGrabar1, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTConsultarReembolsoA, -2, 176, -2).addGap(18, 18, 18).addComponent(this.JBTActualizarCo, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGenerarDocumentoSoporte, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBBuscar, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLCodigoDoc1, -2, 170, -2).addGap(38, 38, 38)))));
        JPIRadicadoLayout.setVerticalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEmpresa, -1, 50, 32767).addComponent(this.JDFFechaR, -1, 50, 32767).addComponent(this.JBBuscaTercero, -1, 50, 32767).addComponent(this.JLBId, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JPValores, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JTPDatosC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLCodigoDoc1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBBuscar, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabar1, -2, 50, -2).addComponent(this.JBTConsultarReembolsoA, -2, 50, -2).addComponent(this.JBTGenerarDocumentoSoporte, -2, 50, -2).addComponent(this.JBTActualizarCo, -2, 50, -2))).addContainerGap()));
        this.JTPDatos.addTab("DATOS DE RADICACIÓN", this.JPIRadicado);
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFRadicacion.37
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacion.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFTercero.setFont(new Font("Arial", 1, 12));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFRadicacion.38
            public void keyTyped(KeyEvent evt) {
                JIFRadicacion.this.JTFTerceroKeyTyped(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacion.39
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacion.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPDatosBLayout = new GroupLayout(this.JPDatosB);
        this.JPDatosB.setLayout(JPDatosBLayout);
        JPDatosBLayout.setHorizontalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFTercero, -1, 945, 32767).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap()));
        JPDatosBLayout.setVerticalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosBLayout.createSequentialGroup().addGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTercero, -2, -1, -2).addComponent(this.JCHFiltro)).addContainerGap(-1, 32767)));
        GroupLayout JPDatospagoLayout = new GroupLayout(this.JPDatospago);
        this.JPDatospago.setLayout(JPDatospagoLayout);
        JPDatospagoLayout.setHorizontalGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatospagoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosB, -1, -1, 32767).addComponent(this.JSPResultado, -1, 1048, 32767)).addContainerGap()));
        JPDatospagoLayout.setVerticalGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatospagoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 493, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPDatospago);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 636, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFSubTotal.transferFocus();
    }

    public void setXidnfacturainterna(long xidnfacturainterna) {
        this.xidnfacturainterna = xidnfacturainterna;
    }

    private void llenarComboResoluciones() {
        this.resoluciones = this.resolucionDian.consultarResolucionPorSede(Principal.sedeUsuarioSeleccionadaDTO.getId(), 5);
        for (int j = 0; j < this.resoluciones.size(); j++) {
            this.JCBResolucionDian.addItem(this.resoluciones.get(j).getId() + " " + this.resoluciones.get(j).getDescripcion());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFIva.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFleteActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFFlete.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFleteFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFOtros.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            this.JLBId.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
            if (this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).equals("0") && this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).equals("")) {
                mNuevo();
                mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
            } else {
                String string1 = "Cargar Radicación" + this.JLBId.getText();
                String string2 = "Consultar Soporte" + this.JLBNFactInterna.getText();
                Object[] botones = {string1, string2, "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    mNuevo();
                    mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                } else if (n == 1) {
                    if (!this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).equals("0") || !this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).equals("") || !this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11).equals("")) {
                        String string12 = "Orden Compra" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11);
                        String string22 = "Radicación" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0);
                        String string4 = "Soporte Factura" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 2);
                        String string5 = "Comprobante Egreso" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7);
                        Object[] botones1 = {string12, string22, "Registro Contable", string4, string5, "Cerrar"};
                        switch (JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar")) {
                            case 0:
                                this.xclases.mImprimirOrdenCompra(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11).toString());
                                break;
                            case 1:
                                mImprimirR();
                                break;
                            case 2:
                                this.xclases.mImprimDocumentoContable("IdC", mConsultarNDocContable(this.JLBId.getText()), "CC_LiquidacionFactura", "4", "", "");
                                break;
                            case 3:
                                this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).toString());
                                break;
                            case 4:
                                this.xclases.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).toString(), "CC_RelacionComprobanteEgresoN", "2", "", "");
                                break;
                        }
                    } else if (!this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).equals("0") || (!this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).equals("") && this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11).equals(""))) {
                        String string23 = "Radicación" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0);
                        String string42 = "Soporte Factura" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 2);
                        String string52 = "Comprobante Egreso" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7);
                        Object[] botones12 = {string23, "Registro Contable", string42, string52, "Cerrar"};
                        switch (JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones12, "Cerrar")) {
                            case 0:
                                mImprimirR();
                                break;
                            case 1:
                                this.xclases.mImprimDocumentoContable("IdC", mConsultarNDocContable(this.JLBId.getText()), "CC_LiquidacionFactura", "4", "", "");
                                break;
                            case 2:
                                this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).toString());
                                break;
                            case 3:
                                this.xclases.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).toString(), "CC_RelacionComprobanteEgresoN", "2", "", "");
                                break;
                        }
                    } else if (!this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).equals("0") && this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).equals("") && !this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11).equals("")) {
                        String string13 = "Orden Compra" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11);
                        String string24 = "Radicación" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0);
                        String string53 = "Compurobante Egreso" + this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7);
                        Object[] botones13 = {string13, string24, "Registro Contable", string53, "Cerrar"};
                        switch (JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones13, "Cerrar")) {
                            case 0:
                                this.xclases.mImprimirOrdenCompra(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 11).toString());
                                break;
                            case 1:
                                mImprimirR();
                                break;
                            case 2:
                                this.xclases.mImprimDocumentoContable("IdC", mConsultarNDocContable(this.JLBId.getText()), "CC_LiquidacionFactura", "4", "", "");
                                break;
                            case 3:
                                this.xclases.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 7).toString(), "CC_RelacionComprobanteEgresoN", "2", "", "");
                                break;
                        }
                    }
                }
            }
            this.JLCodigoDoc1.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 12).toString());
            this.xIDCompromiso = Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 13).toString()).longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadFuncional.getSelectedIndex() != -1) {
            this.JCBCuentaAuxiliar.removeAllItems();
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT cc_puc.Id, concat(cc_puc.Id,'-',cc_puc.Nbre) as Nombre FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Estado =1 AND cc_pucxunidad_funcional.Id_UnidadFuncional ='" + this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "') order by cc_puc.Id";
            this.xidcuentas = this.xconsultas.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCuenta.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre, Tipo FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND UNivel =1) ORDER BY Id ASC ";
            this.xidauxiliar = xct.llenarComboyLista(sql, this.xidauxiliar, this.JCBCuentaAuxiliar, 3);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.xlleno2 = false;
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("1")) {
                if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1")) {
                    mActivarC();
                    this.JTFFVUnitario.setValue(this.JTFFSubTotal.getValue());
                    this.JTFFVTotal.setValue(Double.valueOf(Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() * ((double) Integer.valueOf(this.JSPCantidad.getValue().toString()).intValue())));
                } else {
                    mDesactivarC();
                }
                this.JCBCuentaAuxiliarPagar.removeAllItems();
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql = "SELECT cc_cpagarpucxempresa.Id_AuxPuc, CONCAT(cc_cpagarpucxempresa.Id_AuxPuc,'-',cc_puc.Nbre) AS NPuc, cc_puc.Tipo FROM cc_cpagarpucxempresa INNER JOIN cc_puc ON (cc_cpagarpucxempresa.Id_AuxPuc = cc_puc.Id)  WHERE (cc_cpagarpucxempresa.Estado =1 AND cc_cpagarpucxempresa.Id_Empresa ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ";
                this.xidauxiliarxpagar = xct.llenarComboyLista(sql, this.xidauxiliarxpagar, this.JCBCuentaAuxiliarPagar, 3);
                this.JCBCuentaAuxiliarPagar.setSelectedIndex(-1);
                xct.cerrarConexionBd();
                this.xlleno2 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JLBNFactInterna.getText().isEmpty()) {
            if (!this.JLBId.getText().isEmpty()) {
                if (this.JTAConcepto.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "Concepto no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAConcepto.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() != 0.0d) {
                    if (Double.valueOf(this.JTFFVUnitario.getValue().toString()).equals(Double.valueOf(this.JTFFTotalFactura.getValue().toString()))) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into cc_factura_interna (FechaC, Id_Radicacion, Concepto, Cantidad, VUnitario, reteFuente, Fecha, UsuarioS, NoConsecutivo,idUsuarioRh, idResolucion ) values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.JLBId.getText() + "','" + this.JTAConcepto.getText().toUpperCase() + "','" + this.JSPCantidad.getValue() + "','" + this.JTFFVUnitario.getValue() + "','" + this.JTFFPRetFuente.getValue() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "',0, " + Principal.usuarioSistemaDTO.getIdPersonaCargo() + ", " + this.resoluciones.get(this.JCBResolucionDian.getSelectedIndex()).getId() + " )";
                            this.idFacturaInterna = this.xconsultas.ejecutarSQLId(sql);
                            this.JLBNFactInterna.setText(obtenerConsecutivo());
                            this.xconsultas.cerrarConexionBd();
                            String sql2 = "update cc_radicacion set Id_FacturaInterna='" + this.JLBNFactInterna.getText() + "' where Id='" + this.JLBId.getText() + "'";
                            this.xconsultas.ejecutarSQL(sql2);
                            this.xconsultas.cerrarConexionBd();
                            int y = JOptionPane.showInternalConfirmDialog(this, "Desea imprimir la factura interna?", "IMPRESIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (y == 0) {
                                mImprimirF();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Valor de factura diferente a factura interna;Favor Revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFVUnitario.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta valor unitario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFVUnitario.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe número de radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadStateChanged(ChangeEvent evt) {
        mTotalizarFacInterna();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabar1ActionPerformed(ActionEvent evt) {
        if (!this.JLBId.getText().isEmpty()) {
            cargarFormularioLiquidacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaAuxiliarPagarItemStateChanged(ItemEvent evt) {
        if (this.JCBCuentaAuxiliarPagar.getSelectedIndex() != -1 && this.xlleno1) {
            if (this.xidauxiliarxpagar.length > 0) {
                this.xidcuentapuc = this.xidauxiliarxpagar[this.JCBCuentaAuxiliarPagar.getSelectedIndex()][0];
                return;
            }
            return;
        }
        this.xidcuentapuc = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyTyped(KeyEvent evt) {
        if (!this.JTFTercero.getText().isEmpty()) {
            String sql = "SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y'), cc_radicacion.NoFactura,  cc_terceros.`RazonSocialCompleta`,  IF(Id_Comprobante=0,FALSE,TRUE) AS Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS,  cc_radicacion.Id_Comprobante, LEFT(cc_radicacion.Id_CuentaAuxPuc,4) AS Cuenta, cc_conceptocmsa.Nbre, cc_radicacion.UrlFactura, cc_radicacion.NoCompra  , IF(`pp_movimiento`.`NoConcecutivo` IS NULL , 0, `pp_movimiento`.`NoConcecutivo`) AS NConsecutivo, IF(`pp_movimiento`.`Id`  IS NULL , 0, `pp_movimiento`.`Id`) AS Id_Ppt FROM cc_radicacion LEFT JOIN `pp_movimiento`ON (`pp_movimiento`.`Id` = `cc_radicacion`.`Id_Compromiso`)  INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = `cc_terceros`.Id) INNER JOIN cc_conceptocmsa  ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)   WHERE cc_radicacion.Estado=1  and cc_terceros.`RazonSocialCompleta` like '%" + this.JTFTercero.getText() + "%' ORDER BY cc_radicacion.Id  DESC";
            mCargarDatos(sql);
        } else {
            mCargarDatos("SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y'), cc_radicacion.NoFactura,  cc_terceros.`RazonSocialCompleta`,  IF(Id_Comprobante=0,FALSE,TRUE) AS Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS,  cc_radicacion.Id_Comprobante, LEFT(cc_radicacion.Id_CuentaAuxPuc,4) AS Cuenta, cc_conceptocmsa.Nbre, cc_radicacion.UrlFactura, cc_radicacion.NoCompra  , IF(`pp_movimiento`.`NoConcecutivo` IS NULL , 0, `pp_movimiento`.`NoConcecutivo`) AS NConsecutivo, IF(`pp_movimiento`.`Id`  IS NULL , 0, `pp_movimiento`.`Id`) AS Id_Ppt FROM cc_radicacion LEFT JOIN `pp_movimiento`ON (`pp_movimiento`.`Id` = `cc_radicacion`.`Id_Compromiso`) INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = `cc_terceros`.Id) INNER JOIN cc_conceptocmsa  ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)   WHERE cc_radicacion.Estado=1 ORDER BY cc_radicacion.Id  DESC ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarCoActionPerformed(ActionEvent evt) {
        if (!this.JLBId.getText().isEmpty()) {
            mActulizarDatosC();
            mCargarDatos("SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y'), cc_radicacion.NoFactura,  cc_terceros.RazonSocialCompleta,  IF(Id_Comprobante=0,FALSE,TRUE) AS Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS,  cc_radicacion.Id_Comprobante, LEFT(cc_radicacion.Id_CuentaAuxPuc,4) AS Cuenta, cc_conceptocmsa.Nbre, cc_radicacion.UrlFactura, cc_radicacion.NoCompra  , IF(`pp_movimiento`.`NoConcecutivo` IS NULL , 0, `pp_movimiento`.`NoConcecutivo`) AS NConsecutivo, IF(`pp_movimiento`.`Id`  IS NULL , 0, `pp_movimiento`.`Id`) AS Id_Ppt FROM cc_radicacion LEFT JOIN `pp_movimiento`ON (`pp_movimiento`.`Id` = `cc_radicacion`.`Id_Compromiso`) INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_conceptocmsa  ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)   WHERE cc_radicacion.Estado=1 ORDER BY cc_radicacion.Id  DESC ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarReembolsoAActionPerformed(ActionEvent evt) {
        this.xjifconsultarreembolsos = new JIFConsultarDatosR(this);
        Principal.cargarPantalla(this.xjifconsultarreembolsos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNOrdenCompraMouseClicked(MouseEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            this.xclases.cargarPantalla("Consultar Bienes o Servicios");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEmpresa.requestFocus();
        }
        this.xclases.cargarPantalla(this.title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNFacturaActionPerformed(ActionEvent evt) {
        this.JTFNFactura.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNFacturaFocusLost(FocusEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1 && !this.JTFNFactura.getText().isEmpty() && mConsultarRadicacionFac()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "N° Factura ya radicadaDesea cargar los datos?", "VERIFICAR Radicación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mBuscarDatos(String.valueOf(this.xid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioFocusLost(FocusEvent evt) {
        mTotalizarFacInterna();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioActionPerformed(ActionEvent evt) {
        this.JTFFVUnitario.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (!this.JCHFiltro.isSelected()) {
            String sql = "SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y'), cc_radicacion.NoFactura,  cc_terceros.RazonSocialCompleta,  IF(Id_Comprobante=0,FALSE,TRUE) AS Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS,  cc_radicacion.Id_Comprobante, LEFT(cc_radicacion.Id_CuentaAuxPuc,4) AS Cuenta, cc_conceptocmsa.Nbre, cc_radicacion.UrlFactura, cc_radicacion.NoCompra , IF(`pp_movimiento`.`NoConcecutivo` IS NULL , 0,`pp_movimiento`.`NoConcecutivo`) AS NConsecutivo, IF(`pp_movimiento`.`Id`  IS NULL , 0, `pp_movimiento`.`IdCompromiso`) AS Id_Ppt FROM cc_radicacion LEFT JOIN `pp_movimiento` ON (`pp_movimiento`.`IdCompromiso` = `cc_radicacion`.`Id_Compromiso`)INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_conceptocmsa  ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)   WHERE cc_terceros.RazonSocialCompleta LIKE'" + this.JTFTercero.getText() + "%'AND cc_radicacion.Estado=1  ORDER BY cc_radicacion.Id DESC";
            mCargarDatos(sql);
        } else {
            mCrearTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBT_ReembolzableActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBT_ExcedenteActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBT_RPropiosActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            JDBusquedaMovPTO x = new JDBusquedaMovPTO((Frame) null, true, this, "4", this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]);
            x.setLocationRelativeTo(this);
            x.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un provedor ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFVUnitario.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPRetFuenteFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPRetFuenteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarDocumentoSoporteActionPerformed(ActionEvent evt) {
        if (!this.JLBId.getText().isEmpty()) {
            FacturaEquivalenteDTO facturaEquivalenteDTO = new FacturaEquivalenteDTO();
            facturaEquivalenteDTO.setFechaFactura(this.JDFFechaFact.getDate());
            facturaEquivalenteDTO.setNumeroFactura(this.JTFNFactura.getText());
            facturaEquivalenteDTO.setIdRadicacion(Long.valueOf(this.JLBId.getText()));
            facturaEquivalenteDTO.setIdEmpresa(Long.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]));
            facturaEquivalenteDTO.setConcepto(this.JTAConceptoC.getText());
            facturaEquivalenteDTO.setValorUnitario(Double.valueOf(this.JTFFSubTotal.getValue().toString()));
            JDGFacturaInternaNew e = new JDGFacturaInternaNew(null, true, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), facturaEquivalenteDTO);
            e.setLocationRelativeTo(this);
            e.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaRPropertyChange(PropertyChangeEvent evt) {
        this.JDFFechaFact.setDate(this.JDFFechaR.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TNormalActionPerformed(ActionEvent evt) {
        this.tipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TVigenciaAnteriorActionPerformed(ActionEvent evt) {
        this.tipo = 3;
    }

    private void cargarDatosEntrada() {
        if (this.idEntrada.longValue() != 0) {
            this.entrada = this.iEntradaService.obtenerEntradaDetallada(this.idEntrada);
            if (this.entrada != null) {
                if (this.entrada.getIdRadicacion().longValue() != 0) {
                    mBuscarDatos(this.entrada.getIdRadicacion().toString());
                    return;
                }
                Date date = this.xmetodos.convertirLocalDateADate(this.entrada.getFechaFactura());
                System.out.println("" + this.entrada.getNombreTercero());
                this.JCBEmpresa.setSelectedItem(this.entrada.getNombreTercero());
                this.JDFFechaR.setDate(date);
                this.JDFFechaFact.setDate(date);
                this.JTFNFactura.setText(this.entrada.getNumeroFactura());
                this.JTAConceptoC.setText(this.entrada.getConcepto());
                this.JTFFSubTotal.setValue(this.entrada.getSubTotal());
                this.JTFFFlete.setValue(this.entrada.getValorFlete());
                mCalcularTotal();
                if (this.xidauxiliarxpagar.length != -1 && this.xidauxiliarxpagar.length <= 1) {
                    this.JCBCuentaAuxiliarPagar.setSelectedIndex(0);
                }
                if (this.xidunidadfuncional.length == 1) {
                    this.JCBUnidadFuncional.setSelectedIndex(0);
                }
                if (this.xidcuentas.length >= 1) {
                    this.JCBCuenta.setSelectedIndex(0);
                }
                if (this.xidauxiliar.length >= 1) {
                    this.JCBCuentaAuxiliar.setSelectedIndex(0);
                }
                if (this.xidconcepto.length >= 1) {
                    this.JCBConcepto.setSelectedIndex(0);
                }
            }
        }
    }

    public int getxIdTipoO() {
        return this.xIdTipoO;
    }

    public void setxIdTipoO(int xIdTipoO) {
        this.xIdTipoO = xIdTipoO;
    }

    private void consultarAuditoria() {
        if (Principal.xclase.getRequiereAuditoria() == 1) {
            JDAuditoresDocumentos e = new JDAuditoresDocumentos(null, true, Long.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), Long.valueOf(this.JLBId.getText()));
            e.setLocationRelativeTo(this);
            e.setVisible(true);
        }
    }

    public void setListaCompromisos(List<CcRadicacionCompromiso> ccRadicacionCompromisos) {
        this.radicacionCompromisos = new ArrayList();
        ccRadicacionCompromisos.forEach(e -> {
        });
        this.radicacionCompromisos = ccRadicacionCompromisos;
    }

    public void cargarIdCompromiso() {
        List<Integer> idConsecutivo = new ArrayList<>();
        if (!this.radicacionCompromisos.isEmpty() || this.radicacionCompromisos != null) {
            this.radicacionCompromisos.forEach(item -> {
                idConsecutivo.add(Integer.valueOf(item.getIdMovimiento().getNoConcecutivo()));
            });
            this.JLCodigoDoc1.setText("" + idConsecutivo);
        }
    }

    private void cargarFormularioLiquidacion() {
        if (!verificacionEstadoAuditoria().booleanValue()) {
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                this.entrada.setCuentaPucPagar(this.xidauxiliarxpagar[this.JCBCuentaAuxiliarPagar.getSelectedIndex()][0]);
                Principal.xclase.cargarPantalla("Documento Contable", this.entrada);
                Principal.xclase.xjifdoccontable.JDFFechaC.setDate(this.JDFFechaR.getDate());
                return;
            }
            Principal.xclase.cargarPantalla("Generar Liquidacion");
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Factura con auditoría pendiente, no es posble realizar causación", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void inicalizacionCondtructor() {
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xidempresa = this.xconsultas.llenarComboyLista("SELECT  `Id` , `RazonSocialCompleta` AS RazonSocialCompleta , cc_terceros.FacTInterna, `ActivoC`, requiereAuditoria FROM `cc_terceros`  where Estado = 1  ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBEmpresa, 5);
            this.JTFNOrdenCompra.setEditable(false);
        } else {
            this.xidempresa = this.xconsultas.llenarComboyLista("SELECT  `Id` , `RazonSocialCompleta` AS RazonSocialCompleta , cc_terceros.FacTInterna, `ActivoC`, requiereAuditoria FROM `cc_terceros`  where Estado = 1  ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBEmpresa, 5);
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xidunidadfuncional = this.xconsultas.llenarCombo("SELECT cc_unidad_funcional.Id, cc_unidad_funcional.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_unidad_funcional.Estado =1)GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ", this.xidunidadfuncional, this.JCBUnidadFuncional);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xidconcepto = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_conceptocmsa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconcepto, this.JCBConcepto);
        this.JCBConcepto.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
        this.xlleno = true;
        llenarComboResoluciones();
        mCrearTabla();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.JTPDatosC.remove(2);
            this.JTPDatosC.remove(1);
        }
    }

    private Boolean verificacionEstadoAuditoria() {
        Boolean estado = false;
        try {
            String sql = "SELECT\n    IF(`cc_radicacion_detalle_auditoria`.`fechaAuditoria` IS NULL, 0, 1)\nFROM\n    `cc_radicacion_detalle_auditoria`\n    INNER JOIN`cc_radicacion` \n        ON (`cc_radicacion_detalle_auditoria`.`idRadicacion` = `cc_radicacion`.`Id`)\nWHERE (`cc_radicacion_detalle_auditoria`.`idRadicacion` ='" + this.JLBId.getText() + "'  AND cc_radicacion_detalle_auditoria.`estado`=1 \n    AND IF(`cc_radicacion_detalle_auditoria`.`fechaAuditoria` IS NULL, 0, 1) =0)";
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                estado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    private void mGrabarD() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            GEmpresa empresa = new GEmpresa();
            empresa.setId(Long.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]));
            this.radicacion.setFecha(this.JDFFechaR.getDate());
            this.radicacion.setGEmpresa(empresa);
            this.radicacion.setNoFactura(this.JTFNFactura.getText());
            this.radicacion.setIdPeriodoC(Integer.valueOf(this.xclases.getXidperiodoc()));
            this.radicacion.setTipoR(Integer.valueOf(getxIdTipoO()));
            this.radicacion.setNoCompra(this.JTFNOrdenCompra.getText());
            this.radicacion.setFechaOrdenC(this.JDFFechaOC.getDate());
            this.radicacion.setPeriodoFac(this.JTFPeriodoFac.getText());
            this.radicacion.setFechaFac(this.JDFFechaFact.getDate());
            this.radicacion.setNoMedicamentos((Integer) this.JSPNMedicamentos.getValue());
            this.radicacion.setNoPacientes((Integer) this.JSPNPacientes.getValue());
            this.radicacion.setSubTotal(Double.valueOf(this.JTFFSubTotal.getValue().toString()));
            this.radicacion.setIva(Double.valueOf(this.JTFFIva.getValue().toString()));
            this.radicacion.setFlete(Double.valueOf(this.JTFFFlete.getValue().toString()));
            this.radicacion.setOtros(Double.valueOf(this.JTFFOtros.getValue().toString()));
            this.radicacion.setObservacion(this.JTAObservacion.getText());
            this.radicacion.setConceptoC(this.JTAConceptoC.getText());
            this.radicacion.setIdUnidadF(Integer.valueOf(this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()]));
            this.radicacion.setIdCuenta(this.xidcuentas[this.JCBCuenta.getSelectedIndex()]);
            this.radicacion.setIdCuentaAuxPuc(this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][0]);
            this.radicacion.setIdCuentaAuxPPagar(this.xidauxiliarxpagar[this.JCBCuentaAuxiliarPagar.getSelectedIndex()][0]);
            this.radicacion.setIdConcepto(Integer.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()]));
            this.radicacion.setIdCompromiso(Long.valueOf(this.xIDCompromiso));
            this.radicacion.setTipo(Integer.valueOf(this.xtipo));
            this.radicacion.setEstado(true);
            this.radicacion.setPagada(false);
            this.radicacion.setIdComprobante(0);
            this.radicacion.setIdFacturaInterna(0);
            this.radicacion.setIdAnulado(0);
            this.radicacion.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.radicacion.setFechaS(this.xmetodos.getFechaActual());
            this.radicacion.setUrlFactura("");
            CcRadicacion radicacionNueva = this.iRadicacionService.grabar(this.radicacion);
            this.JLBId.setText("" + radicacionNueva.getId());
            if (!this.radicacionCompromisos.isEmpty()) {
                this.radicacionCompromisos.forEach(items -> {
                    items.setIdRadicacion(radicacionNueva);
                });
                this.iRadicacionCompromisoService.grabar(this.radicacionCompromisos);
            }
            mActualizar_Entrada_MRadicacion(radicacionNueva.getId());
            mActualizarNRadicacionReembolso(radicacionNueva.getId());
            if (Principal.xclase.getRequiereAuditoria() == 1) {
                consultarAuditoria();
                cargarFormularioLiquidacion();
            } else {
                cargarFormularioLiquidacion();
            }
        }
    }

    public void mGrabar() {
        if (!this.JLBId.getText().isEmpty()) {
            if (this.xclases.mValidarExistenciaComprobanteContable(this.JLBId.getText()).longValue() == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0 && this.JLBNFactInterna.getText().isEmpty()) {
                    if (this.tipo == 3) {
                        this.xtipo = 3;
                    }
                    if (this.radicacion.getIdDocumento() == null || this.radicacion.getIdDocumento().longValue() == 0) {
                        mGrabarD();
                        cargarFormularioLiquidacion();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Radicacion con documento contable activo, no se puede actualizar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                }
                return;
            }
            cargarFormularioLiquidacion();
            return;
        }
        System.out.println("metodo " + this.xclases.getXidperiodoc());
        if (this.xclases.getXidperiodoc() != -1) {
            System.out.println("this.xclases.getXidperiodoc() ");
            if (!mConsultarRadicacionFac()) {
                System.out.println("tmConsultarRadicacionFac ");
                if (!this.JTFNFactura.getText().trim().isEmpty()) {
                    if (mValidar()) {
                        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("1")) {
                            if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                                if (!this.JLCodigoDoc1.getText().equals("0")) {
                                    mGrabarD();
                                    return;
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un compromiso", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JBBuscar.requestFocus();
                                    return;
                                }
                            }
                            System.out.println("Grabar d ");
                            mGrabarD();
                            return;
                        }
                        mMensajeTercero();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "N° de Factura no puede estar en blanco", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFNFactura.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "N° de Factura ya radicada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen más de un periodo activo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mGenerarLiqudiacion() {
        long xnc = this.xclases.mValidarExistenciaComprobanteContable(this.JLBId.getText()).longValue();
        if (xnc != 0) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Radicación ya tiene un documento generado, Desea visualizarlo? ", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                this.xclases.mImprimDocumentoContable("IdC", String.valueOf(xnc), "CC_LiquidacionFactura", "4", "", "");
                return;
            }
            return;
        }
        int y2 = JOptionPane.showInternalConfirmDialog(this, "Desea generar documento el documento contable?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y2 == 0 && !this.JLBId.getText().isEmpty()) {
            Principal.xclase.cargarPantalla("Generar Liquidacion");
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JLBId.setText("");
        this.radicacion = new CcRadicacion();
        this.radicacionCompromisos = new ArrayList();
        this.JBTGenerarDocumentoSoporte.setEnabled(false);
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JTFNFactura.setText("");
        this.JDFFechaFact.setDate(this.xmetodos.getFechaActual());
        this.JTFNOrdenCompra.setText("");
        this.JDFFechaOC.setDate(this.xmetodos.getFechaActual());
        this.JTFPeriodoFac.setText("");
        this.JTAObservacion.setText("");
        this.JLCodigoDoc1.setText("0");
        this.JTFTercero.setText("");
        this.xIDCompromiso = 0L;
        this.JTFFSubTotal.setValue(new Integer(0));
        this.JTFFIva.setValue(new Integer(0));
        this.JTFFFlete.setValue(new Integer(0));
        this.JTFFOtros.setValue(new Integer(0));
        this.JTFFTotalFactura.setValue(new Integer(0));
        this.JSPNMedicamentos.setValue(new Integer(0));
        this.JSPNPacientes.setValue(new Integer(0));
        this.JTAConceptoC.setText("");
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBCuentaAuxiliar.removeAllItems();
        this.JCBCuenta.removeAllItems();
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.JTAConcepto.setText("");
        this.JSPCantidad.setValue(new Integer(1));
        this.JTFFVUnitario.setValue(new Integer(0));
        this.JTFFPRetFuente.setValue(new Double(0.0d));
        this.JTFFVTotal.setValue(new Integer(0));
        this.JLBNFactInterna.setText("");
        this.JCBCuentaAuxiliarPagar.removeAllItems();
        mDesactivarC();
        this.xesreembolso = 0;
        this.xtipo = 0;
        this.JRB_TNormal.setSelected(true);
        this.JRBT_Reembolzable.setSelected(true);
        this.xlleno = true;
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 0) {
            this.JTPDatos.setEnabledAt(1, false);
        } else {
            this.JTPDatos.setEnabledAt(1, true);
        }
        this.JDFFechaR.requestFocus();
    }

    public void mAnular() {
        if (this.JLBNFactInterna.getText().isEmpty() && !this.JLBId.getText().isEmpty()) {
            if (mConsultarDRadicacion().booleanValue()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Radicacion", 6);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se puede anular;Documento contable activo", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (!this.JLBNFactInterna.getText().isEmpty() && !this.JLBId.getText().isEmpty()) {
            Object[] botones = {"Factura Interna", "Radicación", "Ambas", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Anular", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    Anular frm2 = new Anular(null, true, "Factura Interna", 6);
                    frm2.setLocationRelativeTo(this);
                    frm2.setVisible(true);
                    return;
                }
                return;
            }
            if (n == 1) {
                if (this.JLBNFactInterna.getText().isEmpty()) {
                    if (mConsultarDRadicacion().booleanValue()) {
                        int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x3 == 0) {
                            Anular frm3 = new Anular(null, true, "Radicacion", 6);
                            frm3.setLocationRelativeTo(this);
                            frm3.setVisible(true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No se puede anular;Documento contable activo", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No se puede anular, Factura interna activa", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (n == 2) {
                if (mConsultarDRadicacion().booleanValue()) {
                    int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x4 == 0) {
                        Anular frm4 = new Anular(null, true, "Factura_Radicacion", 6);
                        frm4.setLocationRelativeTo(this);
                        frm4.setVisible(true);
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No se puede anular;Documento contable activo", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private Boolean mConsultarDRadicacion() {
        boolean xestado = false;
        try {
            String sql = "SELECT `Id_Radicacion` FROM  `cc_documentoc` WHERE (`Id_Radicacion` ='" + this.JLBId.getText() + "' AND `Estado` =1); ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (!xrs.next()) {
                xestado = true;
            } else {
                xestado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(xestado);
    }

    public void mAnularRadicacion(String xid, String xmotivo) {
        String sql = "update cc_radicacion set cc_radicacion.Estado=0 , `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where id='" + this.JLBId.getText() + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "update cc_radicacion_reembolso set Id_Radicacion=0  where Id_Radicacion='" + this.JLBId.getText() + "'";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
    }

    public void mAnularFacInterna(String xid, String xmotivo) {
        String sql = "update cc_factura_interna set cc_factura_interna.Estado=0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where id='" + this.JLBNFactInterna.getText() + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        this.JLBNFactInterna.setText("");
    }

    public void mAnularFactura_Radicacion(String xid, String xmotivo) {
        String sql = "update cc_radicacion set cc_radicacion.Estado=0 , `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where id='" + this.JLBId.getText() + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "update cc_factura_interna set cc_factura_interna.Estado=0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where id='" + this.JLBNFactInterna.getText() + "'";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
        this.JLBNFactInterna.setText("");
    }

    private boolean mValidar() {
        boolean xestado1 = false;
        if (this.JCBEmpresa.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Proveedor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEmpresa.requestFocus();
        } else if (Double.valueOf(this.JTFFTotalFactura.getValue().toString()).doubleValue() != 0.0d) {
            if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
                if (this.JCBConcepto.getSelectedIndex() != -1) {
                    if (this.JCBCuentaAuxiliarPagar.getSelectedIndex() != -1) {
                        xestado1 = true;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar  la cuenta auxiliar para pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBCuentaAuxiliarPagar.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de concepto", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBConcepto.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la cuenta auxiliar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFSubTotal.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe resgistra valores de factura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFSubTotal.requestFocus();
        }
        return xestado1;
    }

    public void mCalcularTotal() {
        double total = Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFFlete.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFIva.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFOtros.getValue().toString()).doubleValue();
        this.JTFFTotalFactura.setValue(Double.valueOf(total));
    }

    public void mBuscar() {
        this.xjifconsultar = new JIFConsultarDatos(this.xclases);
        Principal.cargarPantalla(this.xjifconsultar);
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT\n    `cc_radicacion`.`Id`\n    , `cc_radicacion`.`Fecha`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `cc_radicacion`.`NoCompra`\n    , `cc_radicacion`.`FechaOrdenC`\n    , `cc_radicacion`.`PeriodoFac`\n    , `cc_radicacion`.`FechaFac`\n    , `cc_radicacion`.`NoFactura`\n    , `cc_radicacion`.`NoMedicamentos`\n    , `cc_radicacion`.`NoPacientes`\n    , `cc_radicacion`.`SubTotal`\n    , `cc_radicacion`.`Iva`\n    , `cc_radicacion`.`Flete`\n    , `cc_radicacion`.`Otros`\n    , `cc_radicacion`.`Observacion`\n    , `cc_radicacion`.`Estado`\n    , `cc_radicacion`.`Pagada`\n    , `cc_radicacion`.`ConceptoC`\n    , IF(`cc_puc`.`Nbre` IS NULL, '', CONCAT(`cc_puc`.`Id`,'-',`cc_puc`.`Nbre`)) AS `NCuenta`\n    , IF(`cc_unidad_funcional`.`Nbre` IS NULL, '',`cc_unidad_funcional`.`Nbre`)  AS `NUnidadF`\n    , CONCAT(`cc_puc_1`.`Id`, '-', `cc_puc_1`.`Nbre`) AS `NAuxiliar`\n    ,  CONCAT(`cc_puc_2`.`Id`, '-',`cc_puc_2`.`Nbre`) AS `Auxiliarp`\n    , `cc_radicacion`.`Id_CuentaAuxPPagar` AS `AuxiliarPagar`\n    , `cc_conceptocmsa`.`Nbre` AS `NCOncepto`    ,  `cc_radicacion`.`Tipo` \nFROM\n      `cc_terceros`\n    INNER JOIN   `cc_radicacion` \n        ON (`cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`)\n    LEFT JOIN   `cc_unidad_funcional` \n        ON (`cc_unidad_funcional`.`Id` = `cc_radicacion`.`Id_UnidadF`)\n    LEFT JOIN   `cc_puc` \n        ON (`cc_puc`.`Id` = `cc_radicacion`.`Id_Cuenta`)\n    LEFT JOIN   `cc_puc` AS `cc_puc_1` \n        ON (`cc_puc_1`.`Id` = `cc_radicacion`.`Id_CuentaAuxPuc`)\n    LEFT JOIN   `cc_puc` AS `cc_puc_2` \n        ON (`cc_puc_2`.`Id` = `cc_radicacion`.`Id_CuentaAuxPPagar`)\n    INNER JOIN   `cc_conceptocmsa` \n        ON (`cc_conceptocmsa`.`Id` = `cc_radicacion`.`Id_Concepto`) where `cc_radicacion`.`Id`='" + xid + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.radicacionCompromisos = new ArrayList();
                this.radicacion = this.iRadicacionService.radicacionPorId(Long.valueOf(xid));
                this.radicacionCompromisos = this.iRadicacionCompromisoService.listaPorIdRadicacion(this.radicacion);
                cargarIdCompromiso();
                xrs.first();
                this.JLBId.setText(xrs.getString(1));
                this.JTFFSubTotal.setValue(Double.valueOf(xrs.getDouble(11)));
                this.JDFFechaR.setDate(xrs.getDate(2));
                this.JCBEmpresa.setSelectedItem(xrs.getString(3));
                this.JTFNOrdenCompra.setText(xrs.getString(4));
                this.JDFFechaOC.setDate(xrs.getDate(5));
                this.JTFPeriodoFac.setText(xrs.getString(6));
                this.JDFFechaFact.setDate(xrs.getDate(7));
                this.JTFNFactura.setText(xrs.getString(8));
                this.JSPNMedicamentos.setValue(Integer.valueOf(xrs.getInt(9)));
                this.JSPNPacientes.setValue(Integer.valueOf(xrs.getInt(10)));
                this.JTFFIva.setValue(Double.valueOf(xrs.getDouble(12)));
                this.JTFFFlete.setValue(Double.valueOf(xrs.getDouble(13)));
                this.JTFFOtros.setValue(Double.valueOf(xrs.getDouble(14)));
                this.JTAObservacion.setText(xrs.getString(15));
                this.JTAConceptoC.setText(xrs.getString(18));
                this.JCBUnidadFuncional.setSelectedItem(xrs.getString(20));
                this.JCBCuenta.setSelectedItem(xrs.getString(19));
                this.JCBCuentaAuxiliar.setSelectedItem(xrs.getString(21));
                this.JCBCuentaAuxiliarPagar.setSelectedItem(xrs.getString(22));
                this.JCBConcepto.setSelectedItem(xrs.getString(24));
                mBuscarCAuxiliarPagar();
                mBuscarFacturaInterna();
                mCalcularTotal();
                this.JBTGenerar.requestFocus();
                this.tipo = xrs.getInt("Tipo");
                if (xrs.getInt("Tipo") == 0) {
                    this.JRB_TNormal.setSelected(true);
                } else {
                    this.JRB_TVigenciaAnterior.setSelected(true);
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
            this.JTPDatos.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarCAuxiliarPagar() {
        String sql = "SELECT CONCAT(cc_radicacion.Id_CuentaAuxPPagar,'-', cc_puc.Nbre) AS Nombre FROM cc_puc INNER JOIN cc_radicacion  ON (cc_puc.Id = cc_radicacion.Id_CuentaAuxPPagar) WHERE (cc_radicacion.Id ='" + this.JLBId.getText() + "') ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                this.JCBCuentaAuxiliarPagar.setSelectedItem(xrs1.getString(1));
                this.xidcuentapuc = this.xidauxiliarxpagar[this.JCBCuentaAuxiliarPagar.getSelectedIndex()][0];
            } else {
                this.JCBCuentaAuxiliarPagar.setSelectedIndex(-1);
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarFacturaInterna() {
        try {
            String sql = "SELECT Concepto, Cantidad, VUnitario,(VUnitario*Cantidad) AS VTotal, Id, `NoConsecutivo`, reteFuente  FROM cc_factura_interna WHERE (Estado =1 AND Id_Radicacion ='" + this.JLBId.getText() + "') ";
            ConsultasMySQL xct2 = new ConsultasMySQL();
            ResultSet xrs2 = xct2.traerRs(sql);
            if (xrs2.next()) {
                this.JTAConcepto.setText(xrs2.getString(1));
                this.JSPCantidad.setValue(Integer.valueOf(xrs2.getInt(2)));
                this.JTFFVUnitario.setValue(Double.valueOf(xrs2.getDouble(3)));
                this.JTFFPRetFuente.setValue(Double.valueOf(xrs2.getDouble("reteFuente")));
                this.JTFFVTotal.setValue(Double.valueOf(xrs2.getDouble(4)));
                this.idFacturaInterna = xrs2.getString(5);
                this.JLBNFactInterna.setText(xrs2.getString(6));
            }
            xrs2.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimirF() {
        if (!this.JLBNFactInterna.getText().isEmpty()) {
            Principal.xclase.mImprimirFacturaInterna(Long.valueOf(this.idFacturaInterna), 0);
        }
    }

    private void mImprimirR() {
        if (!this.JLBId.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "id";
            mparametros[0][1] = this.JLBId.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "C_RecibidoFactura", mparametros);
        }
    }

    public void mImprimir() {
        String string1 = "Radicación N° : " + this.JLBId.getText();
        String string2 = "Factura Interna N° :  " + this.JLBNFactInterna.getText();
        Object[] botones = {string1, string2, "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea imprimir", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            mImprimirR();
        } else if (n == 1) {
            mImprimirF();
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: Contabilidad.JIFRadicacion.40
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Id");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("N° Factura");
        this.xmodelo.addColumn("Proveedor");
        this.xmodelo.addColumn("Pagada");
        this.xmodelo.addColumn("Estado");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("N° Comprobante");
        this.xmodelo.addColumn("Cuenta");
        this.xmodelo.addColumn("Concepto");
        this.xmodelo.addColumn("UrlFatura");
        this.xmodelo.addColumn("OrdenCompra");
        this.xmodelo.addColumn("Id_Compromiso");
        this.xmodelo.addColumn("Id_Compromisointerno");
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    private void mCargarDatos(String xsql) {
        System.out.println(xsql);
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(rs.getString(14), x, 13);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mDesactivarC() {
        this.JTAConcepto.setEnabled(false);
        this.JSPCantidad.setEnabled(false);
        this.JTFFVUnitario.setEnabled(false);
        this.JTFFVTotal.setEnabled(false);
        this.JBTGenerar.setEnabled(false);
        this.JBTGenerarDocumentoSoporte.setEnabled(false);
    }

    private void mActivarC() {
        this.JTAConcepto.setEnabled(true);
        this.JSPCantidad.setEnabled(true);
        this.JTFFVUnitario.setEnabled(true);
        this.JTFFVTotal.setEnabled(true);
        this.JBTGenerar.setEnabled(true);
        this.JBTGenerarDocumentoSoporte.setEnabled(true);
    }

    private void mActulizarDatosC() {
        String idC = "0";
        ResultSet idContable = this.xconsultas.traerRs("SELECT `cc_documentoc`.`Id`  FROM  `cc_documentoc` WHERE `cc_documentoc`.`Id_Radicacion` = " + this.JLBId.getText() + ";");
        try {
            if (idContable.next()) {
                idContable.beforeFirst();
                while (idContable.next()) {
                    idC = idContable.getString("id");
                }
            }
        } catch (Exception e) {
        }
        this.xconsultas.cerrarConexionBd();
        String sql = "update cc_radicacion set NoCompra='" + this.JTFNOrdenCompra.getText() + "', NoFactura='" + this.JTFNFactura.getText() + "', Observacion='" + this.JTAObservacion.getText() + "', ConceptoC='" + this.JTAConceptoC.getText() + "', PeriodoFac='" + this.JTFPeriodoFac.getText() + "', NoMedicamentos ='" + this.JSPNMedicamentos.getValue() + "', NoPacientes='" + this.JSPNPacientes.getValue() + "', Id_UnidadF='" + this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "', Id_Cuenta='" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "', Id_CuentaAuxPuc='" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][0] + "', Id_CuentaAuxPPagar='" + this.xidcuentapuc + "', Id_Concepto='" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()] + "', Id_Compromiso='" + this.xIDCompromiso + "', Tipo='" + this.xtipo + "' where Id='" + this.JLBId.getText() + "'";
        String sqlRad = "UPDATE cc_radicacion_compromiso\nSET idMovimiento='" + this.xIDCompromiso + "'WHERE idRadicacion='" + this.JLBId.getText() + "';";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.ejecutarSQL(sqlRad);
        this.xconsultas.cerrarConexionBd();
        if (this.xIDCompromiso != 0) {
            this.xconsultas.ejecutaSQLUpdate("UPDATE `pp_movimiento` SET `IdDocContable` = " + idC + ", IdRadicacion= '" + this.JLBId.getText() + "' WHERE `pp_movimiento`.`Id` = " + this.xIDCompromiso + ";");
            this.xconsultas.cerrarConexionBd();
        }
    }

    public void mCargarDatosReembolso(String xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT cc_radicacion_reembolso.Id, cc_radicacion_reembolso.Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_reembolso.Observacion, SUM(cc_detalle_radicacion_reembolso.Valor), cc_unidad_funcional.Nbre, CONCAT(cc_cuentapuc.Id,'-',cc_cuentapuc.Nbre) AS Cuenta, CONCAT(cc_auxiliar_cuenta.Id,'-',cc_auxiliar_cuenta.Nbre) AS CuentaAuxiliar FROM cc_detalle_radicacion_reembolso INNER JOIN cc_radicacion_reembolso ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) INNER JOIN cc_terceros  ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_tipo_concepto_reembolso ON (cc_detalle_radicacion_reembolso.Id_TipoConceptoR = cc_tipo_concepto_reembolso.Id) INNER JOIN cc_auxiliar_cuenta  ON (cc_tipo_concepto_reembolso.Id_CPuc = cc_auxiliar_cuenta.Id) INNER JOIN cc_cuentapuc  ON (cc_cuentapuc.Id = cc_auxiliar_cuenta.Cuenta) INNER JOIN cc_pucxunidad_funcional  ON (cc_auxiliar_cuenta.Cuenta = cc_pucxunidad_funcional.Id_Puc) INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id)WHERE (cc_radicacion_reembolso.Id ='" + xid + "' AND cc_radicacion_reembolso.Estado =1 AND cc_radicacion_reembolso.Autorizado =0) GROUP BY cc_radicacion_reembolso.Id";
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                this.JCBEmpresa.setSelectedItem(rs.getString(3));
                this.JTFNFactura.setText("NRR - " + rs.getString(1));
                this.JDFFechaFact.setDate(rs.getDate(2));
                this.JTAConceptoC.setText(rs.getString(4));
                this.JTFFSubTotal.setValue(Double.valueOf(rs.getDouble(5)));
                this.JCBUnidadFuncional.setSelectedItem(rs.getString(6));
                this.JCBCuenta.setSelectedItem(rs.getString(7));
                this.JCBCuentaAuxiliar.setSelectedItem(rs.getString(8));
                mTotalizar();
                this.xesreembolso = rs.getInt(1);
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarNRadicacionReembolso(Long idRadicacion) {
        if (this.xesreembolso != 0) {
            ConsultasMySQL xct = new ConsultasMySQL();
            String sql = "update cc_radicacion_reembolso set Id_Radicacion=" + idRadicacion + " where Id='" + this.xesreembolso + "'";
            xct.ejecutarSQL(sql);
            xct.cerrarConexionBd();
        }
    }

    private void mTotalizar() {
        this.JTFFTotalFactura.setValue(Double.valueOf(Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFIva.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFFlete.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFOtros.getValue().toString()).doubleValue()));
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00aa: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:22:0x00aa */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ae: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:24:0x00ae */
    private boolean mConsultarRadicacionFac() {
        boolean xestado = false;
        try {
            if (this.JLBId.getText().isEmpty()) {
                try {
                    String sql = "SELECT NoFactura, Id FROM cc_radicacion WHERE (NoFactura ='" + this.JTFNFactura.getText() + "' AND Estado =1 AND Id_Proveedor ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ";
                    ResultSet xrs = this.xconsultas.traerRs(sql);
                    Throwable th = null;
                    if (xrs.next()) {
                        xrs.first();
                        this.xid = xrs.getLong(2);
                        xestado = true;
                    } else {
                        this.xid = 0L;
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
                    this.xconsultas.cerrarConexionBd();
                } finally {
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    private void mTotalizarFacInterna() {
        this.JTFFVTotal.setValue(Double.valueOf(Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSPCantidad.getValue().toString()).doubleValue()));
    }

    private String mConsultarNDocContable(String xidrad) {
        String xid = "0";
        try {
            String xsql = "SELECT `Id` FROM `cc_documentoc` WHERE (`Id_Radicacion` ='" + xidrad + "'  AND `Estado` =1) ";
            ResultSet xrs = this.xconsultas.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                xid = xrs.getString(1);
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xid;
    }

    private void mActualizar_Entrada_MRadicacion(Long idRadicacion) {
        for (int x = 0; x < this.xvector.size(); x++) {
            String xsql = "update i_entradas set Id_RadicacionC=" + idRadicacion + " where Id='" + this.xvector.get(x) + "'";
            this.xconsultas.ejecutarSQL(xsql);
            this.xconsultas.cerrarConexionBd();
        }
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    private String obtenerConsecutivo() {
        String sql = "SELECT  `cc_factura_interna`.`NoConsecutivo` FROM `cc_factura_interna` WHERE Id= " + this.idFacturaInterna + "";
        String consecutivo = "";
        ResultSet xrs1 = this.xconsultas.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                consecutivo = xrs1.getString("NoConsecutivo");
            }
            xrs1.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return consecutivo;
    }
}
