package Contabilidad;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import co.com.genomaempresarial.ankara.dto.Adjunto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dto.contabilidad.ListadoRadicacionFacturaDTO;
import com.genoma.plus.jpa.entities.CcDetalleCuentacobrom;
import com.genoma.plus.jpa.entities.CcDetalleDocumentoc;
import com.genoma.plus.jpa.entities.CcDocumentoc;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcTipoDocumentoc;
import com.genoma.plus.jpa.entities.Cccuentacobro;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.projection.IimpuestoProjection;
import com.genoma.plus.jpa.service.CCDetalleCuentacobromService;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import com.genoma.plus.jpa.service.IFacturaElectronicaDAO;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ImpuestoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerarCuentaCobroMImpuestos.class */
public class JIFGenerarCuentaCobroMImpuestos extends JInternalFrame {
    public static DefaultTableModel xmodeloDataAuto;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    public String[][] xidsubgrupo;
    public String[] xidtipodoc;
    public String[] xidtipodoc_ppt;
    public String[] xidperiodo_ppt;
    private String[][] xidempresa;
    private String[][] xidconcepto;
    private Object[] xdato;
    private JIFConsultarDatosV xjifconsultard;
    private String xnombre;
    private String xsql;
    private ContabilidadDAOImpl xCotabilidad;
    private ImpuestoService impuestoService;
    private static CcDetalleCuentacobrom cdc = new CcDetalleCuentacobrom();
    private IResolucionFacturaElectronica resolucionDian;
    private List<ICargarCombo> medioDePago;
    private List<ICargarCombo> tipoDePago;
    private File file;
    private CCDetalleCuentacobromService cCDetalleCuentacobromService;
    private List<Adjunto> adjunto;
    private List<CcDetalleCuentacobrom> listaCC;
    private JIFConceptoCCobro xjifconceptoccobro;
    private int idLiquidacion;
    private JButton JBBuscarDoc;
    private ButtonGroup JBGTipo;
    private JButton JBTActualizarAbdjunto;
    private JButton JBTAdicionar;
    private JButton JBT_EnvioDian;
    private JComboBox JCBConcepto;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBSubGrupo;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox<String> JCBTipoPago;
    private JCheckBox JCHDetalle;
    private JCheckBox JCHMovxConcepto;
    private JCheckBox JCH_AplicaMC;
    private JCheckBox JCH_AplicaMP;
    private JDateChooser JDFFechaC;
    private JLabel JLB_EstadoDian;
    private JLabel JLB_MensajeDian;
    private JPanel JPIConsulta;
    private JPanel JPIDContables1;
    private JPanel JPIDatosFactura;
    private JPanel JPIDatosP;
    private JPanel JPIUtilidades;
    private JPanel JPI_DFactura;
    private JSpinner JSPNDiasP;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    private JTextPane JTAObservacion;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFDescuento;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFNFacturaEvento;
    private JFormattedTextField JTFFTotalizarDescuento;
    private JFormattedTextField JTFFTotalizarR;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorTotal;
    private JTextField JTFOrdenCompra;
    private JTextField JTFRuta;
    private JTabbedPane JTP_DatosFac;
    private JTabbedPane JTP_Detalle;
    public JTable JTResultado;
    public JTable JTResultado1;
    private JButton jButton1;
    private JPanel jPanel1;
    private JFormattedTextField jtffPorcentajeImpuesto;
    JD_ImpuestoG frmA = null;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xnfila = 0;
    private int xesdetalle = 0;
    private boolean xlleno = false;
    private String xidcuentapuc = "0";
    private String xnfacturaevento = "";
    public String xnfactura = "";
    private final IResolucionDianDAO xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);
    private double valorSubtotal = 0.0d;
    private double valorImpuesto = 0.0d;
    private double valorImpuestoUnitario = 0.0d;
    private double descuentoTotal = 0.0d;
    private Cccuentacobro cccuentacobro = new Cccuentacobro();
    private IFacturaElectronicaDAO xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);
    public List<CcDetalleCuentacobrom> ccDetalleCuentacobromsList = new ArrayList();
    private boolean conceptosAgregados = false;

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerarCuentaCobroMImpuestos$CellChangeHandler.class */
    public class CellChangeHandler implements TableModelListener {
        public CellChangeHandler() {
        }

        public void tableChanged(TableModelEvent e) {
            try {
                if (e.getType() == 0 && JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getRowCount() > 0) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 1 || column == 2 || column == 3) {
                        Double.valueOf(0.0d);
                        Double subtotal = Double.valueOf(Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getValueAt(row, 2).toString()).doubleValue() * Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getValueAt(row, 3).toString()).doubleValue());
                        Double total = Double.valueOf((subtotal.doubleValue() + Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getValueAt(row, 6).toString()).doubleValue()) - Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getValueAt(row, 12).toString()).doubleValue());
                        JIFGenerarCuentaCobroMImpuestos.this.JTResultado.setValueAt(total, row, 7);
                        JIFGenerarCuentaCobroMImpuestos.this.JTResultado.setValueAt(subtotal, row, 4);
                        ObjectMapper mapper = new ObjectMapper();
                        System.out.println("entra a imprimir objetMapper");
                        System.out.println(mapper.writeValueAsString(JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).getMCcFacturaInternaDetalleCollection()));
                        if (!JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).getMCcFacturaInternaDetalleCollection().isEmpty()) {
                            JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).getMCcFacturaInternaDetalleCollection().clear();
                            System.out.println(mapper.writeValueAsString(JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).getMCcFacturaInternaDetalleCollection()));
                            System.out.println("si entra");
                            JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).setValor(Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.xmodelo.getValueAt(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow(), 2).toString()));
                            JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).setCantidad(Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.xmodelo.getValueAt(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow(), 3).toString()));
                            JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()).setNProcedimiento(JIFGenerarCuentaCobroMImpuestos.this.xmodelo.getValueAt(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow(), 1).toString());
                            JIFGenerarCuentaCobroMImpuestos.this.frmA = new JD_ImpuestoG(null, true, Integer.valueOf(JIFGenerarCuentaCobroMImpuestos.this.xidempresa[JIFGenerarCuentaCobroMImpuestos.this.JCBTercero.getSelectedIndex()][0]), null, total, "cuentaCobro", JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.get(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getSelectedRow()));
                            JIFGenerarCuentaCobroMImpuestos.this.frmA.setLocationRelativeTo(null);
                            JIFGenerarCuentaCobroMImpuestos.this.frmA.setVisible(true);
                            System.out.println("se paso a la otra ventana");
                            JIFGenerarCuentaCobroMImpuestos.this.ccDetalleCuentacobromsList.add(JIFGenerarCuentaCobroMImpuestos.cdc);
                        }
                        JIFGenerarCuentaCobroMImpuestos.this.JTResultado.setValueAt(subtotal, row, 4);
                        JIFGenerarCuentaCobroMImpuestos.this.JTResultado.setValueAt(total, row, 7);
                    }
                }
                Double granTotal = Double.valueOf(0.0d);
                for (int i = 0; i < JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getRowCount(); i++) {
                    granTotal = Double.valueOf(granTotal.doubleValue() + Double.valueOf(JIFGenerarCuentaCobroMImpuestos.this.JTResultado.getValueAt(i, 7).toString()).doubleValue());
                }
                JIFGenerarCuentaCobroMImpuestos.this.JTFFTotalizarR.setText(String.valueOf(granTotal));
            } catch (Exception e2) {
            }
        }
    }

    public JIFGenerarCuentaCobroMImpuestos(String xnombre) {
        initComponents();
        this.impuestoService = (ImpuestoService) Principal.contexto.getBean(ImpuestoService.class);
        springStart();
        this.xnombre = xnombre;
        this.adjunto = new ArrayList();
        setName(xnombre);
        this.cCDetalleCuentacobromService = (CCDetalleCuentacobromService) Principal.contexto.getBean(CCDetalleCuentacobromService.class);
        mNuevo();
        this.xct.cerrarConexionBd();
        this.cCDetalleCuentacobromService = (CCDetalleCuentacobromService) Principal.contexto.getBean(CCDetalleCuentacobromService.class);
        mValidaResolucionDian(true);
        if (!Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.jButton1.setEnabled(false);
            this.jButton1.setVisible(false);
        }
        this.idLiquidacion = 0;
    }

    /* JADX WARN: Type inference failed for: r3v113, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v238, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.JSPNDiasP = new JSpinner();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JTFOrdenCompra = new JTextField();
        this.JTP_Detalle = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPIConsulta = new JPanel();
        this.JTFFValor = new JFormattedTextField();
        this.JCBConcepto = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.JCHDetalle = new JCheckBox();
        this.JTFFValorTotal = new JFormattedTextField();
        this.JTFFCantidad = new JFormattedTextField();
        this.jtffPorcentajeImpuesto = new JFormattedTextField();
        this.JTFFDescuento = new JFormattedTextField();
        this.jButton1 = new JButton();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTP_DatosFac = new JTabbedPane();
        this.JPIDatosFactura = new JPanel();
        this.JCBSubGrupo = new JComboBox();
        this.JTFFNFacturaEvento = new JFormattedTextField();
        this.JCBTipoC = new JComboBox();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JCHMovxConcepto = new JCheckBox();
        this.JCBTipoPago = new JComboBox<>();
        this.JCBMedioDePago = new JComboBox<>();
        this.JCH_AplicaMC = new JCheckBox();
        this.JTFFTotalizarDescuento = new JFormattedTextField();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCH_AplicaMP = new JCheckBox();
        this.JPIUtilidades = new JPanel();
        this.JBT_EnvioDian = new JButton();
        this.JLB_MensajeDian = new JLabel();
        this.JLB_EstadoDian = new JLabel();
        this.JTFRuta = new JTextField();
        this.JBTActualizarAbdjunto = new JButton();
        this.JBBuscarDoc = new JButton();
        this.JPI_DFactura = new JPanel();
        this.JSPResultado1 = new JScrollPane();
        this.JTResultado1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("FACTURACIÓN POR CONCEPTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifcuentacobromImpuestos");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.1
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasP.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasP.setModel(new SpinnerNumberModel(0, 0, 360, 5));
        this.JSPNDiasP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFOrdenCompra.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden de Compra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaC, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, -2, 382, -2).addGap(18, 18, 18).addComponent(this.JTFOrdenCompra, -2, 183, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPNDiasP, -2, 101, -2).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaC, -1, 52, 32767).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNDiasP, -2, 50, -2).addComponent(this.JCBTercero, -2, -1, -2)).addGap(0, 0, 32767)))).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFOrdenCompra))).addContainerGap()));
        this.JTP_Detalle.setForeground(new Color(0, 103, 0));
        this.JTP_Detalle.setFont(new Font("Arial", 1, 14));
        this.JPIConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.2
            public void focusLost(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFValorFocusLost(evt);
            }
        });
        this.JTFFValor.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.3
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFValorKeyPressed(evt);
            }
        });
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.4
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JCBConcepto.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.5
            public void mousePressed(MouseEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBConceptoMousePressed(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBConceptoMouseClicked(evt);
            }
        });
        this.JCBConcepto.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.6
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBConceptoActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.7
            public void focusGained(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBTAdicionarFocusGained(evt);
            }
        });
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.8
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCHDetalle.setFont(new Font("Arial", 1, 12));
        this.JCHDetalle.setForeground(Color.blue);
        this.JCHDetalle.setText("Es Detalle?");
        this.JCHDetalle.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.9
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCHDetalleActionPerformed(evt);
            }
        });
        this.JTFFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFValorTotal.setHorizontalAlignment(4);
        this.JTFFValorTotal.setFont(new Font("Arial", 1, 12));
        this.JTFFValorTotal.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.10
            public void focusGained(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFValorTotalFocusGained(evt);
            }
        });
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFCantidad.setHorizontalAlignment(4);
        this.JTFFCantidad.setText("1");
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFFCantidad.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.11
            public void focusLost(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFCantidadFocusLost(evt);
            }
        });
        this.JTFFCantidad.addInputMethodListener(new InputMethodListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.12
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFCantidadInputMethodTextChanged(evt);
            }
        });
        this.JTFFCantidad.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.13
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFCantidadKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFCantidadKeyReleased(evt);
            }
        });
        this.jtffPorcentajeImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "% Imp", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jtffPorcentajeImpuesto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.jtffPorcentajeImpuesto.setHorizontalAlignment(4);
        this.jtffPorcentajeImpuesto.setFont(new Font("Arial", 1, 12));
        this.jtffPorcentajeImpuesto.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.14
            public void focusLost(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.jtffPorcentajeImpuestoFocusLost(evt);
            }
        });
        this.jtffPorcentajeImpuesto.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.15
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.jtffPorcentajeImpuestoKeyPressed(evt);
            }
        });
        this.JTFFDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Dscuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFDescuento.setHorizontalAlignment(4);
        this.JTFFDescuento.setText("1");
        this.JTFFDescuento.setFont(new Font("Arial", 1, 12));
        this.JTFFDescuento.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.16
            public void focusLost(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFDescuentoFocusLost(evt);
            }
        });
        this.JTFFDescuento.addInputMethodListener(new InputMethodListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.17
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFDescuentoInputMethodTextChanged(evt);
            }
        });
        this.JTFFDescuento.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.18
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFDescuentoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFFDescuentoKeyReleased(evt);
            }
        });
        this.jButton1.setText("BS");
        this.jButton1.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.19
            public void focusLost(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.jButton1FocusLost(evt);
            }
        });
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.20
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIConsultaLayout = new GroupLayout(this.JPIConsulta);
        this.JPIConsulta.setLayout(JPIConsultaLayout);
        JPIConsultaLayout.setHorizontalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBConcepto, -2, 333, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jtffPorcentajeImpuesto, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCantidad, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDescuento, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorTotal, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHDetalle, -2, 97, -2).addComponent(this.jButton1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 124, -2).addGap(12, 12, 12)));
        JPIConsultaLayout.setVerticalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor, -2, 52, -2).addComponent(this.JTFFCantidad, -2, 52, -2).addComponent(this.JTFFValorTotal, -2, 52, -2).addComponent(this.jtffPorcentajeImpuesto, -2, 52, -2).addComponent(this.JTFFDescuento, -2, 52, -2).addComponent(this.JCBConcepto, -2, 52, -2))).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar, -2, 52, -2).addComponent(this.JCHDetalle)))).addContainerGap(-1, 32767)));
        this.JTFFDescuento.getAccessibleContext().setAccessibleName("Descuento");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Tahoma", 0, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.21
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JTP_DatosFac.setForeground(Color.red);
        this.JTP_DatosFac.setFont(new Font("Arial", 1, 14));
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubGrupo.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.22
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBSubGrupoItemStateChanged(evt);
            }
        });
        this.JTFFNFacturaEvento.setEditable(false);
        this.JTFFNFacturaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° FACTURA EVENTO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFacturaEvento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNFacturaEvento.setHorizontalAlignment(0);
        this.JTFFNFacturaEvento.setFont(new Font("Arial", 1, 18));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setEditable(false);
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        this.JCHMovxConcepto.setFont(new Font("Arial", 1, 12));
        this.JCHMovxConcepto.setSelected(true);
        this.JCHMovxConcepto.setText("Movimiento Contable x Concepto?");
        this.JCHMovxConcepto.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.23
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCHMovxConceptoActionPerformed(evt);
            }
        });
        this.JCBTipoPago.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPago.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.24
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JCBTipoPagoActionPerformed(evt);
            }
        });
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica movimiento contable?");
        this.JTFFTotalizarDescuento.setEditable(false);
        this.JTFFTotalizarDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFTotalizarDescuento.setHorizontalAlignment(4);
        this.JTFFTotalizarDescuento.setFont(new Font("Arial", 1, 13));
        GroupLayout JPIDatosFacturaLayout = new GroupLayout(this.JPIDatosFactura);
        this.JPIDatosFactura.setLayout(JPIDatosFacturaLayout);
        JPIDatosFacturaLayout.setHorizontalGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addComponent(this.JCBTipoC, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JTFFNFacturaEvento, -2, 169, -2).addGap(29, 29, 29).addComponent(this.JCBTipoPago, -2, 208, -2).addGap(18, 18, 18).addComponent(this.JCBMedioDePago, -2, 255, -2).addContainerGap(128, 32767)).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addComponent(this.JCBSubGrupo, -2, 487, -2).addGap(10, 10, 10).addComponent(this.JCHMovxConcepto)).addComponent(this.JCH_AplicaMC)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFTotalizarDescuento, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotalizarR, -2, 177, -2)))));
        JPIDatosFacturaLayout.setVerticalGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalizarR, -2, 66, -2).addComponent(this.JTFFTotalizarDescuento, -2, 66, -2)).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSubGrupo, -2, 50, -2).addComponent(this.JCHMovxConcepto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_AplicaMC))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNFacturaEvento, -2, 50, -2).addComponent(this.JCBTipoPago, -2, 50, -2).addComponent(this.JCBMedioDePago, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTP_DatosFac.addTab("DATOS PARA FACTURAR", this.JPIDatosFactura);
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        this.JCH_AplicaMP.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMP.setText("Aplica?");
        GroupLayout JPIDContables1Layout = new GroupLayout(this.JPIDContables1);
        this.JPIDContables1.setLayout(JPIDContables1Layout);
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMP).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 315, 32767).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addContainerGap()));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCH_AplicaMP)).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt))).addGap(85, 85, 85)));
        this.JTP_DatosFac.addTab("DATOS PRESUPUESTALES", this.JPIDContables1);
        this.JBT_EnvioDian.setFont(new Font("Arial", 1, 12));
        this.JBT_EnvioDian.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_EnvioDian.setText("<html><P ALIGN=center>Enviar Factura Electronica(DIAN)");
        this.JBT_EnvioDian.setEnabled(false);
        this.JBT_EnvioDian.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.25
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBT_EnvioDianActionPerformed(evt);
            }
        });
        this.JLB_MensajeDian.setFont(new Font("Arial", 1, 12));
        this.JLB_MensajeDian.setForeground(Color.red);
        this.JLB_MensajeDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Mensaje Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JLB_EstadoDian.setFont(new Font("Arial", 1, 12));
        this.JLB_EstadoDian.setForeground(Color.red);
        this.JLB_EstadoDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Adjunto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.26
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.27
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTActualizarAbdjunto.setFont(new Font("Arial", 1, 12));
        this.JBTActualizarAbdjunto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizarAbdjunto.setText("Actualizar Adjunto");
        this.JBTActualizarAbdjunto.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.28
            public void focusGained(FocusEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBTActualizarAbdjuntoFocusGained(evt);
            }
        });
        this.JBTActualizarAbdjunto.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.29
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBTActualizarAbdjuntoActionPerformed(evt);
            }
        });
        this.JBBuscarDoc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBBuscarDoc.setText("Buscar Doc");
        this.JBBuscarDoc.setToolTipText("");
        this.JBBuscarDoc.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.30
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBBuscarDocMouseClicked(evt);
            }
        });
        this.JBBuscarDoc.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.31
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JBBuscarDocActionPerformed(evt);
            }
        });
        GroupLayout JPIUtilidadesLayout = new GroupLayout(this.JPIUtilidades);
        this.JPIUtilidades.setLayout(JPIUtilidadesLayout);
        JPIUtilidadesLayout.setHorizontalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addComponent(this.JLB_MensajeDian, -2, 618, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_EstadoDian, -1, 416, 32767)).addGroup(JPIUtilidadesLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 524, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTActualizarAbdjunto, -2, 184, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscarDoc, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JBT_EnvioDian, -2, 166, -2))).addContainerGap()));
        JPIUtilidadesLayout.setVerticalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBT_EnvioDian, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTActualizarAbdjunto, -1, 52, 32767).addComponent(this.JBBuscarDoc, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_MensajeDian, -2, 35, -2).addComponent(this.JLB_EstadoDian, -2, 35, -2)).addContainerGap(35, 32767)));
        this.JTP_DatosFac.addTab("ENVÍO DIAN", this.JPIUtilidades);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIConsulta, -2, 0, 32767).addComponent(this.JSPResultado).addComponent(this.JTP_DatosFac)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIConsulta, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_DatosFac, -2, -1, -2).addContainerGap(53, 32767)));
        this.JTP_Detalle.addTab("DETALLE", this.jPanel1);
        this.JSPResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado1.setFont(new Font("Arial", 1, 12));
        this.JTResultado1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado1.setEditingColumn(1);
        this.JTResultado1.setEditingRow(1);
        this.JTResultado1.setGridColor(new Color(204, 204, 204));
        this.JTResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado1.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado1.setSelectionMode(0);
        this.JTResultado1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.32
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarCuentaCobroMImpuestos.this.JTResultado1PropertyChange(evt);
            }
        });
        this.JSPResultado1.setViewportView(this.JTResultado1);
        GroupLayout JPI_DFacturaLayout = new GroupLayout(this.JPI_DFactura);
        this.JPI_DFactura.setLayout(JPI_DFacturaLayout);
        JPI_DFacturaLayout.setHorizontalGroup(JPI_DFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DFacturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado1, -1, 1069, 32767).addContainerGap()));
        JPI_DFacturaLayout.setVerticalGroup(JPI_DFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DFacturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado1, -1, 539, 32767).addContainerGap()));
        this.JTP_Detalle.addTab("FACTURA PROVEEDORES", this.JPI_DFactura);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Detalle, -1, -1, -2).addComponent(this.JPIDatosP, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Detalle, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBConcepto.getSelectedIndex() != -1) {
            String porImpuesto = this.xidconcepto[this.JCBConcepto.getSelectedIndex()][5];
            this.jtffPorcentajeImpuesto.setValue(Integer.valueOf(porImpuesto));
            if (this.xidconcepto[this.JCBConcepto.getSelectedIndex()][1].equals("1")) {
                this.JTFFValor.setValue(Double.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][2]));
                return;
            }
            this.JTFFValor.setValue(new Double(0.0d));
            this.JTFFValorTotal.setValue(new Double(0.0d));
            this.JTFFDescuento.setValue(new Double(0.0d));
            this.jtffPorcentajeImpuesto.setValue(0);
            this.JTFFCantidad.setValue(0);
        }
    }

    public void AutoLlenarCampos(DefaultTableModel xmodeloData) {
        for (int y = 0; y < xmodeloData.getRowCount(); y++) {
            String target = xmodeloData.getValueAt(y, 3).toString();
            int indexComboConcepto = 0;
            OptionalInt result = IntStream.range(0, this.xidconcepto.length).filter(i -> {
                return this.xidconcepto[i][0].equals(target);
            }).findFirst();
            if (result.isPresent()) {
                System.out.println("Se encontró el valor " + target + " en la fila " + result.getAsInt());
                indexComboConcepto = result.getAsInt();
            } else {
                System.out.println("No se encontró el valor " + target + " en la columna 0");
            }
            this.JCBConcepto.setSelectedIndex(indexComboConcepto);
            this.JTFFCantidad.setValue(Double.valueOf(Double.parseDouble(xmodeloData.getValueAt(y, 2).toString())));
            this.JTFFValor.setValue(Double.valueOf(Double.parseDouble(xmodeloData.getValueAt(y, 1).toString())));
            calcularValor();
            agregarItem();
        }
        xmodeloDataAuto = new DefaultTableModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        agregarItem();
    }

    private void agregarItem() {
        if (this.JCBTercero.getSelectedIndex() != -1) {
            if (this.JTFFValorTotal.getValue().toString().equals("0.0")) {
                JOptionPane.showInternalMessageDialog(this, "No hay valor total", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConcepto.requestFocus();
                return;
            }
            calcularValor();
            if (this.JCBConcepto.getSelectedIndex() != -1) {
                if (!this.JTFFValor.getText().isEmpty()) {
                    if (this.JCBConcepto.getSelectedIndex() > -1) {
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                this.xmodelo.addRow(this.xdato);
                                cdc = new CcDetalleCuentacobrom();
                                cdc.setId_ConceptoCC(Integer.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0]));
                                cdc.setTipoConcepto(Integer.valueOf(this.xesdetalle));
                                cdc.setValor(Double.valueOf(this.JTFFValor.getValue().toString()));
                                cdc.setCantidad(Double.valueOf(this.JTFFCantidad.getValue().toString()));
                                cdc.setPorcentajeImpuesto(Integer.valueOf(this.jtffPorcentajeImpuesto.getValue().toString()));
                                cdc.setValorImpuesto(Double.valueOf(this.valorImpuestoUnitario));
                                cdc.setValorTotalImpuesto(Double.valueOf(this.valorImpuesto));
                                cdc.setDescuento(Double.valueOf(this.descuentoTotal));
                                cdc.setIdCuentacobro(this.cccuentacobro);
                                cdc.setNProcedimiento(this.JCBConcepto.getSelectedItem().toString());
                                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                    cdc.setIdPucCredito(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4]);
                                    cdc.setIdPucDebito(traerMedioPago());
                                }
                                List<IimpuestoProjection> iimpuestos = this.impuestoService.listarIMpuestos(Integer.valueOf(this.xidempresa[this.JCBTercero.getSelectedIndex()][0]));
                                if (iimpuestos.size() > 0) {
                                    this.frmA = new JD_ImpuestoG(null, true, Integer.valueOf(this.xidempresa[this.JCBTercero.getSelectedIndex()][0]), null, Double.valueOf(this.JTFFValorTotal.getValue().toString()), "cuentaCobro", cdc);
                                    this.frmA.setLocationRelativeTo(this);
                                    this.frmA.setVisible(true);
                                }
                                System.out.println("se paso a la otra ventana");
                                System.out.println("this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3] -> " + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3]);
                                System.out.println("this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4] -> " + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4]);
                                this.ccDetalleCuentacobromsList.add(cdc);
                                this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0], this.xnfila, 0);
                                this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 1);
                                this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 2);
                                this.xmodelo.setValueAt(this.JTFFCantidad.getValue(), this.xnfila, 3);
                                this.xmodelo.setValueAt(Double.valueOf(this.valorSubtotal), this.xnfila, 4);
                                this.xmodelo.setValueAt(this.jtffPorcentajeImpuesto.getValue(), this.xnfila, 5);
                                this.xmodelo.setValueAt(Double.valueOf(this.valorImpuesto), this.xnfila, 6);
                                this.xmodelo.setValueAt(this.JTFFValorTotal.getValue(), this.xnfila, 7);
                                this.xmodelo.setValueAt(Integer.valueOf(this.xesdetalle), this.xnfila, 8);
                                this.xmodelo.setValueAt(traerMedioPago(), this.xnfila, 9);
                                this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4], this.xnfila, 10);
                                this.xmodelo.setValueAt(Double.valueOf(this.valorImpuestoUnitario), this.xnfila, 11);
                                this.xmodelo.setValueAt(this.JTFFDescuento.getValue(), this.xnfila, 12);
                                this.xnfila++;
                                mTotalizarReembolso();
                                this.JTFFValor.setValue(new Integer(0));
                                this.JTFFCantidad.setValue(0);
                                this.JTFFValorTotal.setValue(0);
                                this.JCBConcepto.setSelectedIndex(-1);
                                this.JCHDetalle.setSelected(false);
                                this.xesdetalle = 0;
                                this.JTFFDescuento.setValue(0);
                                this.JCBConcepto.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog((Component) null, "Seleccione un medio de pago");
                            this.JCBMedioDePago.requestFocus();
                            return;
                        }
                        this.xmodelo.addRow(this.xdato);
                        cdc = new CcDetalleCuentacobrom();
                        cdc.setId_ConceptoCC(Integer.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0]));
                        cdc.setTipoConcepto(Integer.valueOf(this.xesdetalle));
                        cdc.setValor(Double.valueOf(this.JTFFValor.getValue().toString()));
                        cdc.setCantidad(Double.valueOf(this.JTFFCantidad.getValue().toString()));
                        cdc.setPorcentajeImpuesto(Integer.valueOf(this.jtffPorcentajeImpuesto.getValue().toString()));
                        cdc.setValorImpuesto(Double.valueOf(this.valorImpuestoUnitario));
                        cdc.setValorTotalImpuesto(Double.valueOf(this.valorImpuesto));
                        cdc.setDescuento(Double.valueOf(this.descuentoTotal));
                        cdc.setIdCuentacobro(this.cccuentacobro);
                        cdc.setNProcedimiento(this.JCBConcepto.getSelectedItem().toString());
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            cdc.setIdPucCredito(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4]);
                            cdc.setIdPucDebito(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3]);
                        }
                        List<IimpuestoProjection> iimpuestos2 = this.impuestoService.listarIMpuestos(Integer.valueOf(this.xidempresa[this.JCBTercero.getSelectedIndex()][0]));
                        if (iimpuestos2.size() > 0) {
                            this.frmA = new JD_ImpuestoG(null, true, Integer.valueOf(this.xidempresa[this.JCBTercero.getSelectedIndex()][0]), null, Double.valueOf(this.JTFFValorTotal.getValue().toString()), "cuentaCobro", cdc);
                            this.frmA.setLocationRelativeTo(this);
                            this.frmA.setVisible(true);
                        }
                        System.out.println("se paso a la otra ventana");
                        System.out.println("this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3] -> " + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3]);
                        System.out.println("this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4] -> " + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4]);
                        this.ccDetalleCuentacobromsList.add(cdc);
                        this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0], this.xnfila, 0);
                        this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 1);
                        this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 2);
                        this.xmodelo.setValueAt(this.JTFFCantidad.getValue(), this.xnfila, 3);
                        this.xmodelo.setValueAt(Double.valueOf(this.valorSubtotal), this.xnfila, 4);
                        this.xmodelo.setValueAt(this.jtffPorcentajeImpuesto.getValue(), this.xnfila, 5);
                        this.xmodelo.setValueAt(Double.valueOf(this.valorImpuesto), this.xnfila, 6);
                        this.xmodelo.setValueAt(this.JTFFValorTotal.getValue(), this.xnfila, 7);
                        this.xmodelo.setValueAt(Integer.valueOf(this.xesdetalle), this.xnfila, 8);
                        this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][3], this.xnfila, 9);
                        this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4], this.xnfila, 10);
                        this.xmodelo.setValueAt(Double.valueOf(this.valorImpuestoUnitario), this.xnfila, 11);
                        this.xmodelo.setValueAt(this.JTFFDescuento.getValue(), this.xnfila, 12);
                        this.xnfila++;
                        mTotalizarReembolso();
                        this.JTFFValor.setValue(new Integer(0));
                        this.JTFFCantidad.setValue(0);
                        this.JTFFValorTotal.setValue(0);
                        this.JCBConcepto.setSelectedIndex(-1);
                        this.JCHDetalle.setSelected(false);
                        this.xesdetalle = 0;
                        this.JTFFDescuento.setValue(0);
                        this.JCBConcepto.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Seleccione un concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta digitar el valor", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValor.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTercero.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyPressed(KeyEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila seleccionada?", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.ccDetalleCuentacobromsList.remove(this.JTResultado.getSelectedRow());
                this.xmodelo.removeRow(this.JTResultado.getSelectedRow());
                this.xnfila--;
                mTotalizarReembolso();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDetalleActionPerformed(ActionEvent evt) {
        if (this.JCHDetalle.isSelected()) {
            this.xesdetalle = 1;
        } else {
            this.xesdetalle = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubGrupoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.JCBTercero.getSelectedIndex() != -1 && this.xlleno) {
            this.JCBSubGrupo.removeAllItems();
            this.xsql = "SELECT `f_subgrupo_empresa`.`Id`, concat(`f_subgruposervicio`.`Nbre`,' - ', f_empresacontxconvenio.Nbre) as  SubGrupo, `f_empresacontxconvenio`.`Id`, `f_subgruposervicio`.`Id_GrupoServicio`, `f_empresacontxconvenio`.Id_GIps, `f_subgrupo_empresa`.`CPuc_Debito`, `f_subgrupo_empresa`.`CPuc_Credito`, `f_subgrupo_empresa`.`IdRubro` FROM  `f_subgrupo_empresa` INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_subgrupo_empresa`.`Id_Empresa` = `f_empresacontxconvenio`.`Id`) WHERE (`f_subgrupo_empresa`.`EsContable` =1 AND `f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "' AND `f_subgrupo_empresa`.`Estado` =1) ORDER BY `f_subgruposervicio`.`Nbre` ASC ";
            this.xidsubgrupo = this.xct.llenarComboyLista(this.xsql, this.xidsubgrupo, this.JCBSubGrupo, 8);
            this.JCBSubGrupo.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultado1PropertyChange(PropertyChangeEvent evt) {
        mTotalizarReembolsoP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMovxConceptoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorFocusLost(FocusEvent evt) {
        calcularValor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadFocusLost(FocusEvent evt) {
        calcularValor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFCantidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorTotalFocusGained(FocusEvent evt) {
        calcularValor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadInputMethodTextChanged(InputMethodEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtffPorcentajeImpuestoFocusLost(FocusEvent evt) {
        calcularValor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoFocusLost(FocusEvent evt) {
        calcularValor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoInputMethodTextChanged(InputMethodEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFDescuento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDescuentoKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtffPorcentajeImpuestoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.jtffPorcentajeImpuesto.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFValor.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EnvioDianActionPerformed(ActionEvent evt) {
        if (!this.JTFFNFacturaEvento.getText().isEmpty()) {
            boolean formaEnvio = false;
            if (!this.JLB_EstadoDian.getText().equals("SUCCESS")) {
                formaEnvio = true;
            }
            System.out.println("" + this.xnfacturaevento);
            this.xIFacturaElectronicaDAO.mGenerarFacturaElectronica(this.xnfacturaevento, 1, Boolean.valueOf(formaEnvio), this.adjunto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                this.file = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.file.getAbsolutePath());
                Adjunto a = new Adjunto();
                a.setFileName(this.file.getName());
                try {
                    Metodos metodos = this.xmt;
                    a.setBase64(Metodos.encodeFileToBase64Binary(this.file.getAbsolutePath()));
                } catch (IOException ex) {
                    Logger.getLogger(JIFGenerarCuentaCobroMImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                this.adjunto.add(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarAbdjuntoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarAbdjuntoActionPerformed(ActionEvent evt) {
        String path = this.JTFRuta.getText();
        String escapedFilepath = path.replace("\\", "\\\\");
        System.out.println("Path: " + path + " Replace = " + escapedFilepath);
        if (!this.JTFFNFacturaEvento.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar la ruta del archivo adjunto de la factura : " + this.JTFFNFacturaEvento.getText() + "?", "Confirmar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                int numeroFactura = Integer.valueOf(this.JTFFNFacturaEvento.getText()).intValue();
                ActualizarRutaAbjunto(escapedFilepath, numeroFactura);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoActionPerformed(ActionEvent evt) {
    }

    public void cargarComboConcepto() {
        this.JCBConcepto.removeAllItems();
        this.xidconcepto = this.xct.llenarComboyLista("SELECT Id, Nbre, VFijo, Valor, CDebito, CCredito,porcentajeImpuesto FROM cc_tipo_concepto_cuentacobro WHERE (Estado =1) order by Nbre", this.xidconcepto, this.JCBConcepto, 7);
        this.JCBConcepto.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar un concepto", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.xclase.cargarPantalla("Concepto Cuenta de Cobro");
                this.conceptosAgregados = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoMousePressed(MouseEvent evt) {
        if (this.conceptosAgregados) {
            cargarComboConcepto();
            this.conceptosAgregados = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoPagoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        xmodeloDataAuto = new DefaultTableModel();
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            if (this.JCBTercero.getSelectedIndex() > -1) {
                if (this.JCBMedioDePago.getSelectedIndex() > -1) {
                    JD_FacturacionBienEstar frmFacturacionBienEstar = new JD_FacturacionBienEstar(null, true, this.xidempresa[this.JCBTercero.getSelectedIndex()][1], this.JCBTercero.getSelectedItem().toString());
                    frmFacturacionBienEstar.setLocationRelativeTo(this);
                    frmFacturacionBienEstar.setVisible(true);
                    if (xmodeloDataAuto.getRowCount() > 0) {
                        AutoLlenarCampos(xmodeloDataAuto);
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Para un proceso más automatico seleccione un medio de pago antes, Seleccionar medio de pago.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Seleccione un tercero antes");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarDocMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarDocActionPerformed(ActionEvent evt) {
        JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
        xfilec.setFileSelectionMode(0);
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            File xfile = xfilec.getSelectedFile();
            this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
            this.JTFRuta.requestFocus();
        }
        try {
            File archivoGuardado = new File(this.JTFRuta.getText());
            Desktop.getDesktop().open(archivoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int ActualizarRutaAbjunto(String ruta, int numFacturaEvento) {
        String sqlActualizar = "update f_factura_evento set archivoAbjunto ='" + ruta + "'\nwhere No_FacturaEvento ='" + numFacturaEvento + "'";
        int result = this.xct.ejecutaSQLUpdate(sqlActualizar);
        this.xct.cerrarConexionBd();
        return result;
    }

    private void calcularValor() {
        Double valorTotal = new Double(0.0d);
        DecimalFormat mf = new DecimalFormat("#0.000");
        if (this.JCBConcepto.getSelectedIndex() != -1) {
            double porcentajeImpuesto = Double.parseDouble(this.jtffPorcentajeImpuesto.getValue().toString());
            if (!this.JTFFCantidad.getText().isEmpty() && Double.valueOf(this.JTFFCantidad.getText()).doubleValue() > 0.0d) {
                double cantidad = Double.parseDouble(this.JTFFCantidad.getValue().toString());
                double valorUnitario = Double.parseDouble(this.JTFFValor.getValue().toString());
                double descuento = Double.parseDouble(this.JTFFDescuento.getValue().toString());
                this.valorSubtotal = cantidad * valorUnitario;
                this.valorImpuestoUnitario = (porcentajeImpuesto / 100.0d) * valorUnitario;
                this.valorImpuesto = (porcentajeImpuesto / 100.0d) * this.valorSubtotal;
                valorTotal = Double.valueOf((this.valorSubtotal + this.valorImpuesto) - descuento);
            }
        }
        System.out.println("valorTotal -> " + valorTotal);
        System.out.println("mf.format(valorTotal) -> " + mf.format(valorTotal));
        this.JTFFValorTotal.setText(mf.format(valorTotal));
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JTFFValorTotal.setValue(valorTotal);
        }
    }

    private void mValidaResolucionDian(Boolean validar) {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0) {
            this.resolucionDian = lis.get(0);
            if (validar.booleanValue()) {
                this.xmt.mResolucionDian(lis.get(0));
            }
        }
    }

    private void mCargarCombo() {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.medioDePago = this.xICargarComboMedioPagoDAO.cargarComboMedioDePago();
            this.JCBMedioDePago.removeAllItems();
            for (int i = 0; i < this.medioDePago.size(); i++) {
                this.JCBMedioDePago.addItem(this.medioDePago.get(i).getNombre());
            }
            this.JCBMedioDePago.setSelectedIndex(-1);
            this.tipoDePago = this.xICargarComboMedioPagoDAO.cargarComboTipoDePago();
            this.JCBTipoPago.removeAllItems();
            for (int i2 = 0; i2 < this.tipoDePago.size(); i2++) {
                this.JCBTipoPago.addItem(this.tipoDePago.get(i2).getNombre());
            }
            this.JCBTipoPago.setSelectedIndex(-1);
            return;
        }
        this.medioDePago = this.xICargarComboMedioPagoDAO.cargarComboMedioDePago();
        this.JCBMedioDePago.removeAllItems();
        for (int i3 = 0; i3 < this.medioDePago.size(); i3++) {
            this.JCBMedioDePago.addItem(this.medioDePago.get(i3).getNombre());
        }
        this.JCBMedioDePago.setSelectedItem("Crédito ACH");
        this.tipoDePago = this.xICargarComboMedioPagoDAO.cargarComboTipoDePago();
        this.JCBTipoPago.removeAllItems();
        for (int i4 = 0; i4 < this.tipoDePago.size(); i4++) {
            this.JCBTipoPago.addItem(this.tipoDePago.get(i4).getNombre());
        }
        this.JCBTipoPago.setSelectedIndex(-1);
    }

    private void mTotalizarReembolsoP() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTResultado1.getRowCount(); y++) {
            if (this.JTResultado1.getValueAt(y, 7).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo1.getValueAt(y, 6).toString()).doubleValue();
            }
        }
        this.JTFFValor.setValue(Double.valueOf(xtotal));
    }

    public void mGrabar() {
        CcDocumentoc cd = new CcDocumentoc();
        new CcDetalleDocumentoc();
        CcTipoDocumentoc tipoDocumentoc = new CcTipoDocumentoc();
        tipoDocumentoc.setId(Integer.valueOf(this.xidtipodoc[this.JCBTipoC.getSelectedIndex()]));
        CcPeriodoContable periodoContable = new CcPeriodoContable();
        periodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
        cd.setFechaD(this.JDFFechaC.getDate());
        cd.setIdTipoComprobante(tipoDocumentoc);
        cd.setIdPeriodoC(periodoContable);
        System.out.println("FACTURA EVENTO>>>>>>>>>>>>>>> " + this.JTFFNFacturaEvento.getText());
        cd.setDescripcion(quitarSaltos(this.JTAObservacion.getText()) + " Factura Venta N° " + this.JTFFNFacturaEvento.getText());
        cd.setAprobadoA(true);
        cd.setEjecutado(true);
        cd.setEsGlobal(false);
        cd.setEstado(true);
        cd.setEstadoA(false);
        cd.setExportadoC(false);
        cd.setFecha(this.xmt.getFechaActual());
        cd.setFechaR(this.xmt.getFechaActual());
        cd.setGenerarC(false);
        cd.setIdCertificado(0);
        cd.setIdCierreCaja(0);
        cd.setIdConcepto(0);
        cd.setIdCuentaCobro(0);
        cd.setIdCuentaEmpresa(0);
        cd.setIdCuentaEmpresaP(0);
        cd.setIdNomina(BigInteger.ZERO);
        cd.setIdRadicacion(BigInteger.ZERO);
        cd.setRevisadoC(true);
        cd.setTipoPago(0);
        cd.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JTResultado.getRowCount() != -1) {
                if (this.JCBSubGrupo.getSelectedIndex() != -1) {
                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Confirmar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            if (!this.JCH_AplicaMP.isSelected() && !this.JCH_AplicaMC.isSelected()) {
                                if (this.JTResultado.getRowCount() > 0) {
                                    if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 6) && !this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                                            if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                                if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                    mGrabarCuentaCorbro();
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JCBTipoPago.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JCBMedioDePago.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBTipoC.requestFocus();
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Hay cuentas debito o credito sin parametrizar en el concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe adicionar algun concepto.", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            } else if (!this.JCH_AplicaMP.isSelected() && this.JCH_AplicaMC.isSelected()) {
                                if (this.JCHMovxConcepto.isSelected()) {
                                    if (this.JTResultado.getRowCount() > 0) {
                                        if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 6) && !this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                                if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                                    if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                        mGrabarCuentaCorbro();
                                                        mGenerarDocContable_Evento();
                                                        mGrabarDetalleDoc_PorConcepto(this.xnfactura);
                                                        mGrabar_ActualizarImpuest0(this.xnfactura);
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JCBTipoPago.requestFocus();
                                                    }
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JCBMedioDePago.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JCBTipoC.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Hay cuentas debito o credito sin parametrizar en el concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe adicionar algun concepto.", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else if (!this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][5].equals("")) {
                                    if (this.JTResultado.getRowCount() > 0) {
                                        if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 6) && !this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                                if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                                    if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                        mGrabarCuentaCorbro();
                                                        mGenerarDocContable_Evento();
                                                        mGrabarDetalle_Normal(this.xnfactura);
                                                        mGrabar_ActualizarImpuest0(this.xnfactura);
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JCBTipoPago.requestFocus();
                                                    }
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JCBMedioDePago.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JCBTipoC.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Hay cuentas debito o credito sin parametrizar en el concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe adicionar algun concepto.", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Hay cuentas debito o credito sin parametrizar en el concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            } else if (!this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                    if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                                        if (!this.JTFFNFacturaEvento.getText().isEmpty()) {
                                            mGenerarDoc_Presupuesto();
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de documento presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JCBTipoDoc_Ppt.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBPeriodo_Ppt.requestFocus();
                                }
                            } else if (this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                                if (this.JTResultado.getRowCount() > 0) {
                                    if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 6) && !this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                                            if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                                if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                    if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                                        if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                                                            mGrabarCuentaCorbro();
                                                            mGenerarDocContable_Evento();
                                                            mGrabarDetalleDoc_PorConcepto(this.xnfactura);
                                                            mGrabar_ActualizarImpuest0(this.xnfactura);
                                                            mGenerarDoc_Presupuesto();
                                                        } else {
                                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de documento presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                            this.JCBTipoDoc_Ppt.requestFocus();
                                                        }
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JCBPeriodo_Ppt.requestFocus();
                                                    }
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JCBTipoPago.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JCBMedioDePago.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBTipoC.requestFocus();
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Hay cuentas debito o credito sin parametrizar en el concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe adicionar algun concepto.", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            }
                            System.out.println("idLiquidacion -> " + this.idLiquidacion);
                            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && this.JCBMedioDePago.getSelectedItem().equals("EFECTIVO")) {
                                ConsultasMySQL xct = new ConsultasMySQL();
                                String sql = "SELECT Id_Liquidacion FROM `f_factura_evento` WHERE CONCAT(Prefijo,`No_FacturaEvento_M`) = '" + this.JTFFNFacturaEvento.getText() + "'";
                                ResultSet xrs = xct.traerRs(sql);
                                try {
                                    if (xrs.next()) {
                                        xrs.first();
                                        this.idLiquidacion = xrs.getInt("Id_Liquidacion");
                                    }
                                    xrs.close();
                                    xct.cerrarConexionBd();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                System.out.println("liquidacion nueva -> " + this.idLiquidacion);
                                insertarProcedureFFacturaPagos(this.idLiquidacion);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JDFFechaC.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un subgrupo", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSubGrupo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe registrar un concepto", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarCuentaCorbro() {
        if (this.JTResultado.getRowCount() != -1) {
            for (int i = 0; i < this.JTResultado.getRowCount(); i++) {
                try {
                    System.out.println("detalle ccm -> " + this.ccDetalleCuentacobromsList.get(i));
                } catch (JsonProcessingException | NumberFormatException ex) {
                    Logger.getLogger(JDGFacturaInternaNew.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            this.cccuentacobro.setFechaC(this.JDFFechaC.getDate());
            this.cccuentacobro.setIdTercero(Integer.valueOf(this.xidempresa[this.JCBTercero.getSelectedIndex()][0]));
            this.cccuentacobro.setObservacion(quitarSaltos(this.JTAObservacion.getText()));
            this.cccuentacobro.setFecha(this.xmt.getFechaActual());
            this.cccuentacobro.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.cccuentacobro.setEstado(true);
            this.cccuentacobro.setCcDetalleCuentacobromCollection(this.ccDetalleCuentacobromsList);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(this.cccuentacobro));
            Cccuentacobro cccuentacobroService = this.cCDetalleCuentacobromService.grabar(this.cccuentacobro);
            if (!cccuentacobroService.equals((Object) null)) {
                JOptionPane.showMessageDialog((Component) null, "¡Datos Guardados!");
            } else {
                JOptionPane.showMessageDialog((Component) null, "¡Los Datos No Se Grabaron!");
            }
            System.out.println("ID CUENTA COBROO>>>>>>>>>>" + this.cccuentacobro.getId());
            Principal.txtNo.setText(String.valueOf(this.cccuentacobro.getId()));
            for (int y = 0; y < this.JTResultado1.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 7).toString()).booleanValue()) {
                    String sql = "update cc_documentoc set Id_CuentaCobro='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo1.getValueAt(y, 5) + "'";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                }
            }
            mGenerarFacturaEvento();
        }
    }

    private void mGenerarDoc_Presupuesto() {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,IdUsuarioR, `Observacion`,NoFact, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + quitarSaltos(this.JTAObservacion.getText()) + "','" + this.JTFFNFacturaEvento.getValue() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][6] + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + this.JTFFTotalizarR.getValue() + "','" + quitarSaltos(this.JTAObservacion.getText()) + " SEGÚN FACTURA N° " + this.JTFFNFacturaEvento.getText() + "');";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDocContable_Evento() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        if (Principal.informacionIps.getPrefijoFactura().equals("")) {
            this.xnfactura = this.JTFFNFacturaEvento.getText();
        } else {
            this.xnfactura = Principal.informacionIps.getPrefijoFactura() + "-" + this.JTFFNFacturaEvento.getText();
        }
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + Principal.xclase.getXidperiodoc() + "','" + quitarSaltos(this.JTAObservacion.getText()) + " Factura Venta N° " + this.JTFFNFacturaEvento.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(xct1.ejecutarSQLId(this.xsql));
        xct1.cerrarConexionBd();
    }

    private void mGrabar_ActualizarImpuest0(String xnfactura) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "update f_factura_evento set Id_DocumentoC='" + Principal.txtNo.getText() + "' where No_FacturaEvento='" + this.xnfacturaevento + "'";
        xct1.ejecutarSQL(this.xsql);
        xct1.cerrarConexionBd();
        this.xsql = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, ((" + this.JTFFTotalizarR.getValue() + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, ((" + this.JTFFTotalizarR.getValue() + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "' and cc_impuestoxempresa.Estado=1)";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs2 = xct1.traerRs(this.xsql);
        try {
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + Principal.txtNo.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','0','" + xnfactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "','" + this.JTFFTotalizarR.getValue() + "','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "' )";
                    xct2.ejecutarSQL(this.xsql);
                    xct2.cerrarConexionBd();
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarCuentaCobroMImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        xct1.cerrarConexionBd();
    }

    private String traerMedioPago() {
        String medioPago = null;
        System.out.println("medio de pago -> " + this.JCBMedioDePago.getSelectedItem());
        String xsql = "SELECT cuentaDebito FROM medio_pago WHERE nombre = '" + this.JCBMedioDePago.getSelectedItem() + "'";
        System.out.println("consulta -> " + xsql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                medioPago = xrs.getString("cuentaDebito");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
            System.out.println(">>>error<<<");
        }
        return medioPago;
    }

    private void mGrabarDetalleDoc_PorConcepto(String xnfactura) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + traerMedioPago() + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','" + this.xmodelo.getValueAt(x, 7) + "','0','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
                System.out.println(" Detalle Puc : " + this.xsql);
                xct1.ejecutarSQL(this.xsql);
                xct1.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 10).toString() + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','0','" + this.xmodelo.getValueAt(x, 7) + "','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
                xct1.ejecutarSQL(this.xsql);
                xct1.cerrarConexionBd();
            }
            return;
        }
        for (int x2 = 0; x2 < this.JTResultado.getRowCount(); x2++) {
            ConsultasMySQL xct12 = new ConsultasMySQL();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x2, 9).toString() + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','" + this.xmodelo.getValueAt(x2, 7) + "','0','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
            xct12.ejecutarSQL(this.xsql);
            xct12.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x2, 10).toString() + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','0','" + this.xmodelo.getValueAt(x2, 7) + "','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
            xct12.ejecutarSQL(this.xsql);
            xct12.cerrarConexionBd();
        }
    }

    private void mGrabarDetalle_Normal(String xnfactura) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][4] + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','" + this.JTFFTotalizarR.getValue() + "','0','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
        xct1.ejecutarSQL(this.xsql);
        xct1.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][5] + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + xnfactura + "','0','" + this.JTFFTotalizarR.getValue() + "','" + quitarSaltos(this.JTAObservacion.getText()) + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
        xct1.ejecutarSQL(this.xsql);
        xct1.cerrarConexionBd();
    }

    private void springStart() {
        this.xCotabilidad = (ContabilidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("contabilidadDAOImpl");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFFNFacturaEvento.setText("");
        this.xlleno = false;
        this.descuentoTotal = 0.0d;
        this.JTFFTotalizarDescuento.setText(String.valueOf(this.descuentoTotal));
        this.JTFFValorTotal.setEditable(false);
        this.JCBSubGrupo.removeAllItems();
        this.xnfactura = "";
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBTercero.removeAllItems();
        this.xsql = "SELECT  `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta`,  cc_terceros.No_identificacion \nFROM `f_empresacontxconvenio` INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_subgrupo_empresa`.`Id_Empresa` = `f_empresacontxconvenio`.`Id`) \nGROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBTercero, 3);
        this.JCBConcepto.removeAllItems();
        this.xidconcepto = this.xct.llenarComboyLista("SELECT Id, Nbre, VFijo, Valor, CDebito, CCredito,porcentajeImpuesto FROM cc_tipo_concepto_cuentacobro WHERE (Estado =1) order by Nbre", this.xidconcepto, this.JCBConcepto, 7);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConcepto.setSelectedIndex(-1);
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1 && !Principal.informacionIps.getIdTipoIdentificacion().equals("812003382")) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.xct.llenarCombo("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        this.JTAObservacion.setText("");
        this.JTFFValor.setValue(1);
        this.JTFFTotalizarR.setValue(0);
        this.JTFFValorTotal.setValue(0);
        this.JTFFCantidad.setValue(0);
        this.JTFFDescuento.setValue(0);
        this.JCHDetalle.setSelected(false);
        this.xlleno = true;
        this.xesdetalle = 0;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCH_AplicaMP.setSelected(true);
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
        mCrearTabla();
        mCrearTabla_Proveedores();
        this.JCBTercero.requestFocus();
        cdc = new CcDetalleCuentacobrom();
        this.cccuentacobro = new Cccuentacobro();
        this.ccDetalleCuentacobromsList = new ArrayList();
        this.valorSubtotal = 0.0d;
        this.valorImpuesto = 0.0d;
        this.valorImpuestoUnitario = 0.0d;
        this.descuentoTotal = 0.0d;
        this.frmA = null;
        mCargarCombo();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Concepto", "Valor", "Cantidad", "Subtotal", "%Imp", "Valor Imp", "Total", "Tipo", "Debito", "Credito", "Valor Unit Impuesto", "Descuento"}) { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.33
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, true, true, true, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.xnfila = 0;
        TableModel model = this.JTResultado.getModel();
        CellChangeHandler handler = new CellChangeHandler();
        model.addTableModelListener(handler);
    }

    private void mCrearTabla_Proveedores() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Empresa", "N° Comprobante", "N° Radicación", "Fecha Radicación", "N° DocumentoC", "Valor", "Reembolsar?", "Concepto"}) { // from class: Contabilidad.JIFGenerarCuentaCobroMImpuestos.34
            Class[] types = {Long.class, String.class, Long.class, Long.class, String.class, Long.class, Double.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado1.setModel(this.xmodelo1);
        this.JTResultado1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTResultado1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTResultado1.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTResultado1.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(8).setPreferredWidth(40);
    }

    private void mCargar_DatosRadicacion() {
        mCrearTabla_Proveedores();
        List<ListadoRadicacionFacturaDTO> list = this.xCotabilidad.listRadicacionFactura(Integer.valueOf(this.xmt.formatoANO.format(this.JDFFechaC.getDate())));
        this.xmt.mEstablecerTextEditor(this.JTResultado1, 1);
        this.xmt.mEstablecerTextEditor(this.JTResultado1, 8);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo1.addRow(this.xdato);
            this.xmodelo1.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo1.setValueAt(list.get(x).getNEmpresa(), x, 1);
            this.xmodelo1.setValueAt(list.get(x).getIdComprobante(), x, 2);
            this.xmodelo1.setValueAt(list.get(x).getIdRadicacion(), x, 3);
            this.xmodelo1.setValueAt(list.get(x).getFechaRad(), x, 4);
            this.xmodelo1.setValueAt(list.get(x).getIdDocumento(), x, 5);
            this.xmodelo1.setValueAt(list.get(x).getValor(), x, 6);
            this.xmodelo1.setValueAt(false, x, 7);
            this.xmodelo1.setValueAt(list.get(x).getConcepto(), x, 8);
        }
    }

    public void mImprimir() {
        new convertirNumerosLetras();
        String[][] mparametros = new String[5][2];
        if (!this.JTFFNFacturaEvento.getText().isEmpty() || !this.JTFFNFacturaEvento.getText().equals("0")) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                mparametros[0][0] = "id_factura";
                mparametros[0][1] = this.JTFFNFacturaEvento.getText();
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[2][0] = "nvalor";
                mparametros[2][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalizarR.getText());
                mparametros[3][0] = "SUBREPORT_DIR";
                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_FacturaDianConsolidada1_F3_Dajud", mparametros);
                return;
            }
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "nvalor";
            mparametros[2][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalizarR.getText());
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_F_FacturaDianConsolidada", mparametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_F_FacturaDianConsolidada_Nueva", mparametros);
                return;
            }
        }
        mparametros[0][0] = "IdC";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "nvalor";
        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalizarR.getText());
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_CuentaCobroM", mparametros);
    }

    public void mBuscarDatos(String xid) {
        mNuevo();
        String sql = "SELECT cc_cuentacobro.Id,\n   cc_cuentacobro.FechaC, \n   IF(cc_cuentacobro.Estado=1,'ACTIVA', 'ANULADA') AS Estado, \n   cc_terceros.RazonSocialCompleta, \n   cc_cuentacobro.Observacion,\n    cc_detalle_cuentacobrom.Id_ConceptoCC, cc_tipo_concepto_cuentacobro.Nbre AS nombreConcepto,\n     cc_detalle_cuentacobrom.Valor AS vrUnit, \n     cc_detalle_cuentacobrom.TipoConcepto, \n     `cc_cuentacobro`.`NFactura_Evento`, \n     `cc_tipo_concepto_cuentacobro`.CDebito, \n     cc_tipo_concepto_cuentacobro.CCredito, \n     cc_detalle_cuentacobrom.cantidad,\n     cc_detalle_cuentacobrom.TipoConcepto,\n     cc_detalle_cuentacobrom.porcentajeImpuesto,\n     (cc_detalle_cuentacobrom.valor*cc_detalle_cuentacobrom.`cantidad`) AS subTotal,\n     cc_detalle_cuentacobrom.`valorTotalImpuesto`,\n     ( (cc_detalle_cuentacobrom.`cantidad`*cc_detalle_cuentacobrom.`Valor`)+cc_detalle_cuentacobrom.`valorTotalImpuesto`) AS total,\n     ifnull(ffe.responseMensaje, '')responseMensaje , ifnull(ffe.responseEstado, '')responseEstado \n, ffe.ordenDeCompra FROM  cc_cuentacobro \n INNER join cc_detalle_cuentacobrom  ON (cc_detalle_cuentacobrom.Id_cuentacobro = cc_cuentacobro.Id) \n INNER JOIN cc_tipo_concepto_cuentacobro   ON (cc_detalle_cuentacobrom.Id_ConceptoCC = cc_tipo_concepto_cuentacobro.Id) \n INNER JOIN cc_terceros  ON (cc_cuentacobro.Id_Tercero = cc_terceros.Id) \n inner join f_factura_evento ffe on (ffe.No_FacturaEvento = cc_cuentacobro.NFactura_Evento)\n WHERE cc_cuentacobro.Id='" + xid + "'";
        System.out.println("Buscar datos factura -> " + sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                Principal.txtNo.setText(rs.getString(1));
                this.JLB_EstadoDian.setText(rs.getString("responseEstado"));
                this.JLB_MensajeDian.setText(rs.getString("responseMensaje"));
                this.JDFFechaC.setDate(rs.getDate(2));
                Principal.txtEstado.setText(rs.getString(3));
                this.JCBTercero.setSelectedItem(rs.getString(4));
                this.JTAObservacion.setText(rs.getString(5));
                this.JTFOrdenCompra.setText(rs.getString("ordenDeCompra"));
                this.JTFFNFacturaEvento.setText(rs.getString(10));
                this.xnfacturaevento = rs.getString(10);
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_ConceptoCC")), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString("nombreConcepto"), this.xnfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("cantidad")), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("vrUnit")), this.xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("TipoConcepto")), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs.getString("CDebito"), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs.getString("CCredito"), this.xnfila, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("porcentajeImpuesto")), this.xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("subTotal")), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("valorTotalImpuesto")), this.xnfila, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("total")), this.xnfila, 7);
                    this.xmodelo.setValueAt(0, this.xnfila, 12);
                    this.xnfila++;
                }
                mTotalizarReembolso();
                activarEnvioDian();
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void activarEnvioDian() {
        if (Principal.usuarioSistemaDTO.getAutorizadoEnvioFacturaDian().booleanValue()) {
            this.JBT_EnvioDian.setEnabled(true);
            this.JLB_EstadoDian.setVisible(true);
            this.JLB_MensajeDian.setVisible(true);
            if (this.JLB_EstadoDian.getText().equals("SUCCESS")) {
                this.JLB_MensajeDian.setForeground(new Color(0, 103, 0));
                this.JLB_EstadoDian.setForeground(new Color(0, 103, 0));
            }
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && !Principal.txtEstado.getText().equals("ANULADA")) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular la cuenta de cobro?", "Confirmar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xnombre.equals("jifcuentacobrom") || this.xnombre.equals("jifcuentacobrom2")) {
                    Principal.xclase.mAnularCuentaCobro(Principal.txtNo.getText());
                    Principal.xclase.mAnularFacturaEvento(this.JTFFNFacturaEvento.getText());
                }
            }
        }
    }

    public void mBuscar() {
        Object[] botones = {"Facturas", "Radicaciones", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjifconsultard = new JIFConsultarDatosV(this);
            Principal.cargarPantalla(this.xjifconsultard);
        } else if (n == 1) {
            mCargar_DatosRadicacion();
            this.JTP_Detalle.setSelectedIndex(1);
        }
    }

    private void mTotalizarReembolso() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            System.out.println("valor conlumna " + this.xmodelo.getValueAt(y, 7).toString());
            xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 7).toString()).doubleValue();
            this.descuentoTotal += Double.valueOf(this.xmodelo.getValueAt(y, 12).toString()).doubleValue();
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
        this.JTFFTotalizarDescuento.setValue(Double.valueOf(this.descuentoTotal));
    }

    private void mGenerarFacturaEvento() {
        String sql;
        mValidaResolucionDian(false);
        String sql2 = "insert into f_liquidacion (TotalServicio, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Estado, IdFormaPago, Fecha, UsuarioS )  values ('" + (Double.parseDouble(this.JTFFTotalizarR.getValue().toString()) + this.descuentoTotal) + "','" + Double.parseDouble(this.JTFFTotalizarR.getValue().toString()) + "','" + this.descuentoTotal + "','0','0','0','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][0] + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][1] + "' ,'" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','0','" + this.tipoDePago.get(this.JCBTipoPago.getSelectedIndex()).getId() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xidliquidacion = this.xct.ejecutarSQLId(sql2);
        this.xct.cerrarConexionBd();
        String sql3 = "insert into f_cuentacobro(IdGrupoServicio, IdEmpContxConv, Id_PeriodoC, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][2] + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][1] + "','" + Principal.xclase.getXidperiodoc() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.JTFFTotalizarR.getValue() + "','0','0','0','" + this.JTFFTotalizarR.getValue() + "','" + this.JTResultado.getRowCount() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xcuentacobro = this.xct.ejecutarSQLId(sql3);
        this.xct.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            sql = "insert into f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M, Id_Liquidacion, idResolucionDian, idMedioPago, EstaArmada, No_CuentaCobro, ConceptoCobro, Sede, diasPago,Fecha, UsuarioS, archivoAbjunto, ordenDeCompra)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + xidliquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','2','" + xcuentacobro + "','" + quitarSaltos(this.JTAObservacion.getText()) + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.JSPNDiasP.getValue() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFRuta.getText() + "','" + this.JTFOrdenCompra.getText() + "')";
        } else {
            String path = this.JTFRuta.getText();
            String escapedFilepath = path.replace("\\", "\\\\");
            System.out.println("Path: " + path + " Replace = " + escapedFilepath);
            System.out.println("medio de pago -> " + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId());
            sql = "insert into f_factura_evento(Fecha_FacturaEvento,  Prefijo, No_FacturaEvento_M, Id_Liquidacion, idResolucionDian, idMedioPago, EstaArmada, No_CuentaCobro, ConceptoCobro, Sede, diasPago,Fecha, UsuarioS, archivoAbjunto, ordenDeCompra)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + xidliquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','2','" + xcuentacobro + "','" + quitarSaltos(this.JTAObservacion.getText()) + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.JSPNDiasP.getValue() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + escapedFilepath + "','" + this.JTFOrdenCompra.getText() + "')";
        }
        this.xnfacturaevento = this.xct.ejecutarSQLId(sql);
        activarEnvioDian();
        this.xct.cerrarConexionBd();
        Principal.clasegeneral.mActualizar_ResolucionDian(this.xnfacturaevento, this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][3]);
        String sql4 = "insert into f_detalle_facturaevento (No_FacturaEvento, Concepto, Total ) values('" + this.xnfacturaevento + "','" + this.JCBSubGrupo.getSelectedItem() + "','" + this.JTFFTotalizarR.getValue() + "')";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        List<Object[]> lista = this.xCotabilidad.obtenerNumeroDeFacturaMYPrefijo(this.xnfacturaevento);
        this.JTFFNFacturaEvento.setText(lista.get(0)[0].toString() + lista.get(0)[1].toString());
        String sql5 = "update cc_cuentacobro set NFactura_Evento='" + this.xnfacturaevento + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
    }

    private void insertarProcedureFFacturaPagos(int idLiquidacion) {
        System.out.println("idLiquidacioon -> " + idLiquidacion);
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `insertarFFPagos`('" + idLiquidacion + "')}");
            cs.execute();
            JOptionPane.showMessageDialog((Component) null, "Se realizó el pago correctamente");
            cs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String quitarSaltos(String cadena) {
        return cadena.replaceAll("(\\n|\\r)", " ");
    }
}
