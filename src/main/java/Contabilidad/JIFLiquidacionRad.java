package Contabilidad;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos;
import com.genoma.plus.jpa.entities.CcRadicacionCompromiso;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GMotivoanulacion;
import com.genoma.plus.jpa.entities.PpDetalleMovimiento;
import com.genoma.plus.jpa.entities.PpMovimiento;
import com.genoma.plus.jpa.entities.PpPeriodo;
import com.genoma.plus.jpa.entities.PpRubros;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.entities.PpTipoDocumentos;
import com.genoma.plus.jpa.entities.PpTipoVigencia;
import com.genoma.plus.jpa.projection.IGenericoDosValores;
import com.genoma.plus.jpa.projection.IInformacionCompromisosPorObligar;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.genoma.plus.jpa.service.IPpPeriodoService;
import com.genoma.plus.jpa.service.IPpTipoDocumentosService;
import com.genoma.plus.jpa.service.IRadicacionCompromisoService;
import com.genoma.plus.jpa.service.IRadicacionService;
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
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFLiquidacionRad.class */
public class JIFLiquidacionRad extends JInternalFrame {
    private DefaultTableModel xmodeloregimen;
    public DefaultTableModel xmodelogasto;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo_r;
    private JIFExportarDatosTipoDoc xjifconsultar;
    private Object[] xdato;
    private boolean xauxtipo;
    private boolean xauxptipo;
    private String xobjetollamador;
    private String xsql;
    public String xidtercero;
    public List<Long> xId_Compromiso;
    private JIFRadicacionNC xjifradnc;
    private JIFRadicacion xjifradn;
    private String[] xidtipodoc_ppt;
    private String[] xidcuentabancaria;
    private String[][] xidperiodo_ppt;
    private String[][] xidtipodoc_cont;
    private String[][] idTipoDocPpt;
    private String xidObligacion;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private String idClasificacion;
    private String xnfactura;
    public List<CcRadicacionCompromiso> radicacionCompromisos;
    private List<PpTipoDocumentos> ppTipoDocumentos;
    private List<PpPeriodo> ppPeriodos;
    private JInternalFrame xjif;
    private Long idTercero;
    private String idRadicacion;
    private int tipoDocPresupuesto;
    private JButton JBTDeducciones;
    private JButton JBTGastos;
    private JComboBox JCBCuentaBancaria2;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoDoc_Cont;
    private JComboBox JCBTipoDoc_Ppt;
    private JCheckBox JCH_UtilizarVR;
    public JDateChooser JDFFechaC;
    private JLabel JLBEstado;
    private JLabel JLBNumero;
    private JPanel JPID_Ppto;
    private JPanel JPIDatosL;
    private JPanel JPIFacturaInterna1;
    private JPanel JPIRadicado;
    private JPanel JPI_DContables;
    private JPanel JPI_Ppto;
    private JPanel JPValores;
    private JScrollPane JSPCGasto;
    private JScrollPane JSPImpuestos;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPTipoRegimen;
    private JScrollPane JSP_DRubros;
    private JTextPane JTAObservacion;
    public JTable JTB_DRubros;
    public JTable JTCGasto;
    private JTextField JTFEmpresa;
    private JFormattedTextField JTFFBaseIva;
    private JFormattedTextField JTFFFlete;
    private JFormattedTextField JTFFIva;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFNeto;
    private JFormattedTextField JTFFOtros;
    private JFormattedTextField JTFFSubTotal;
    private JFormattedTextField JTFFTotalD;
    private JFormattedTextField JTFFTotalFactura;
    private JFormattedTextField JTFFTotalGasto;
    private JFormattedTextField JTFFTotalizarR;
    public JTable JTImpuestos;
    private JTabbedPane JTP_Datos;
    public JTable JTTipoRegimen;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public int xnfila = 0;
    public int xnfilad = 0;
    public int xperiodoc = 0;
    public int xtipodoc = 0;
    public int xidcuentabdispersion = 0;
    public int xclasedoc = 0;
    private boolean xlleno = false;
    private String xconceptop = "";
    private String xidauxiliarpago = "";
    private String xnauxiliarpago = "";
    private String xidauxiliar = "";
    private String xnauxiliar = "";
    private DecimalFormat xformato = new DecimalFormat("#,##0");
    private int xConsecutivo = 0;
    private Email e = new Email();
    public int tipo = 0;
    public int bandera = 0;
    private final IRadicacionService iRadicacionService = (IRadicacionService) Principal.contexto.getBean(IRadicacionService.class);
    private final IRadicacionCompromisoService iRadicacionCompromisoService = (IRadicacionCompromisoService) Principal.contexto.getBean(IRadicacionCompromisoService.class);
    private final IPpMovimientoService iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
    private final IPpTipoDocumentosService iPpTipoDocumentosService = (IPpTipoDocumentosService) Principal.contexto.getBean(IPpTipoDocumentosService.class);
    private final IPpPeriodoService iPpPeriodoService = (IPpPeriodoService) Principal.contexto.getBean(IPpPeriodoService.class);
    private Long idCompromiso = new Long(0);
    private PpMovimiento movimientoNuevo = null;
    private List<PpMovimiento> movimientosCompromiso = new ArrayList();
    private List<String> idObligacion = new ArrayList();
    private List<Long> idMovimientoObligacion = new ArrayList();

    public JIFLiquidacionRad(JInternalFrame xjif, String xidObligacion, String idClasificacion, int tipo, List<CcRadicacionCompromiso> radicacionCompromisos, String numeroFactura, Long idTercero, String idRadicacion) {
        this.xnfactura = "";
        initComponents();
        this.idTercero = idTercero;
        this.radicacionCompromisos = radicacionCompromisos;
        this.idRadicacion = idRadicacion;
        this.xnfactura = numeroFactura;
        this.idClasificacion = idClasificacion;
        this.xjif = xjif;
        iniciarInformacionInicial(xjif);
        System.out.println("tipo " + radicacionCompromisos);
    }

    /* JADX WARN: Type inference failed for: r3v132, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v235, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosL = new JPanel();
        this.JPIRadicado = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JTFEmpresa = new JTextField();
        this.JPValores = new JPanel();
        this.JTFFSubTotal = new JFormattedTextField();
        this.JTFFIva = new JFormattedTextField();
        this.JTFFFlete = new JFormattedTextField();
        this.JTFFOtros = new JFormattedTextField();
        this.JTFFTotalFactura = new JFormattedTextField();
        this.JSPTipoRegimen = new JScrollPane();
        this.JTTipoRegimen = new JTable();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_DContables = new JPanel();
        this.JSPImpuestos = new JScrollPane();
        this.JTImpuestos = new JTable();
        this.JPIFacturaInterna1 = new JPanel();
        this.JTFFTotalD = new JFormattedTextField();
        this.JTFFNeto = new JFormattedTextField();
        this.JTFFBaseIva = new JFormattedTextField();
        this.JTFFTotalGasto = new JFormattedTextField();
        this.JSPCGasto = new JScrollPane();
        this.JTCGasto = new JTable();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JBTDeducciones = new JButton();
        this.JLBNumero = new JLabel();
        this.JBTGastos = new JButton();
        this.JLBEstado = new JLabel();
        this.JCBCuentaBancaria2 = new JComboBox();
        this.JCBTipoDoc_Cont = new JComboBox();
        this.JPI_Ppto = new JPanel();
        this.JPID_Ppto = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCH_UtilizarVR = new JCheckBox();
        this.JSP_DRubros = new JScrollPane();
        this.JTB_DRubros = new JTable();
        this.JTFFTotalizarR = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("LIQUIDACIÓN DE FACTURAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifcomprobantep");
        this.JPIRadicado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "INFORMACIÓN DE FACTURA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JPIRadicado.setFont(new Font("Arial", 1, 14));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTFEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFEmpresa.setHorizontalAlignment(2);
        this.JTFEmpresa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPValores.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "VALOR RADICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JTFFSubTotal.setEditable(false);
        this.JTFFSubTotal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSubTotal.setHorizontalAlignment(4);
        this.JTFFSubTotal.setFont(new Font("Arial", 1, 13));
        this.JTFFIva.setEditable(false);
        this.JTFFIva.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFIva.setHorizontalAlignment(4);
        this.JTFFIva.setFont(new Font("Arial", 1, 13));
        this.JTFFFlete.setEditable(false);
        this.JTFFFlete.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Flete", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFlete.setHorizontalAlignment(4);
        this.JTFFFlete.setFont(new Font("Arial", 1, 13));
        this.JTFFOtros.setEditable(false);
        this.JTFFOtros.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFOtros.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFOtros.setHorizontalAlignment(4);
        this.JTFFOtros.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalFactura.setBackground(new Color(0, 102, 0));
        this.JTFFTotalFactura.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Total Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalFactura.setForeground(new Color(255, 255, 255));
        this.JTFFTotalFactura.setHorizontalAlignment(4);
        this.JTFFTotalFactura.setEnabled(false);
        this.JTFFTotalFactura.setFont(new Font("Arial", 1, 24));
        GroupLayout JPValoresLayout = new GroupLayout(this.JPValores);
        this.JPValores.setLayout(JPValoresLayout);
        JPValoresLayout.setHorizontalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFOtros).addComponent(this.JTFFSubTotal, -1, 98, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPValoresLayout.createSequentialGroup().addComponent(this.JTFFIva, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFlete, -2, 86, -2)).addComponent(this.JTFFTotalFactura))));
        JPValoresLayout.setVerticalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSubTotal, -1, 48, 32767).addComponent(this.JTFFIva, -1, 48, 32767).addComponent(this.JTFFFlete, -1, 48, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFOtros, -1, 48, 32767).addComponent(this.JTFFTotalFactura)).addContainerGap()));
        this.JSPTipoRegimen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Régimen", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTTipoRegimen.setBorder(BorderFactory.createBevelBorder(0));
        this.JTTipoRegimen.setFont(new Font("Tahoma", 0, 12));
        this.JTTipoRegimen.setForeground(new Color(0, 0, 204));
        this.JTTipoRegimen.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTTipoRegimen.setEditingColumn(1);
        this.JTTipoRegimen.setEditingRow(1);
        this.JTTipoRegimen.setGridColor(new Color(204, 255, 204));
        this.JSPTipoRegimen.setViewportView(this.JTTipoRegimen);
        GroupLayout JPIRadicadoLayout = new GroupLayout(this.JPIRadicado);
        this.JPIRadicado.setLayout(JPIRadicadoLayout);
        JPIRadicadoLayout.setHorizontalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRadicadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmpresa)).addComponent(this.JSPTipoRegimen)).addGap(10, 10, 10).addComponent(this.JPValores, -2, -1, -2).addContainerGap()));
        JPIRadicadoLayout.setVerticalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPValores, -2, -1, -2).addGroup(JPIRadicadoLayout.createSequentialGroup().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFechaC, -2, -1, -2).addComponent(this.JTFEmpresa, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTipoRegimen, -2, 84, -2))).addContainerGap(-1, 32767)));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSPImpuestos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DEDUCCIONES", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JTImpuestos.setBorder(BorderFactory.createBevelBorder(0));
        this.JTImpuestos.setFont(new Font("Arial", 1, 12));
        this.JTImpuestos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTImpuestos.setEditingColumn(2);
        this.JTImpuestos.setEditingRow(1);
        this.JTImpuestos.setGridColor(new Color(204, 204, 204));
        this.JTImpuestos.setRowMargin(2);
        this.JTImpuestos.setSelectionBackground(new Color(255, 255, 255));
        this.JTImpuestos.setSelectionForeground(Color.red);
        this.JTImpuestos.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFLiquidacionRad.1
            public void mouseClicked(MouseEvent evt) {
                JIFLiquidacionRad.this.JTImpuestosMouseClicked(evt);
            }
        });
        this.JTImpuestos.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFLiquidacionRad.2
            public void focusLost(FocusEvent evt) {
                JIFLiquidacionRad.this.JTImpuestosFocusLost(evt);
            }
        });
        this.JTImpuestos.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFLiquidacionRad.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFLiquidacionRad.this.JTImpuestosPropertyChange(evt);
            }
        });
        this.JTImpuestos.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFLiquidacionRad.4
            public void keyPressed(KeyEvent evt) {
                JIFLiquidacionRad.this.JTImpuestosKeyPressed(evt);
            }
        });
        this.JSPImpuestos.setViewportView(this.JTImpuestos);
        this.JPIFacturaInterna1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "TOTAL", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JTFFTotalD.setEditable(false);
        this.JTFFTotalD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Deducciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalD.setHorizontalAlignment(4);
        this.JTFFTotalD.setFont(new Font("Arial", 1, 15));
        this.JTFFTotalD.setValue(new Double(0.0d));
        this.JTFFNeto.setEditable(false);
        this.JTFFNeto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Neto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNeto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFNeto.setHorizontalAlignment(4);
        this.JTFFNeto.setFont(new Font("Arial", 1, 15));
        this.JTFFNeto.setValue(new Double(0.0d));
        this.JTFFBaseIva.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Base Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFBaseIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFBaseIva.setHorizontalAlignment(4);
        this.JTFFBaseIva.setFont(new Font("Arial", 1, 15));
        this.JTFFBaseIva.setValue(new Double(0.0d));
        this.JTFFBaseIva.addActionListener(new ActionListener() { // from class: Contabilidad.JIFLiquidacionRad.5
            public void actionPerformed(ActionEvent evt) {
                JIFLiquidacionRad.this.JTFFBaseIvaActionPerformed(evt);
            }
        });
        this.JTFFBaseIva.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFLiquidacionRad.6
            public void focusLost(FocusEvent evt) {
                JIFLiquidacionRad.this.JTFFBaseIvaFocusLost(evt);
            }
        });
        this.JTFFTotalGasto.setEditable(false);
        this.JTFFTotalGasto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Total Gasto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalGasto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalGasto.setHorizontalAlignment(4);
        this.JTFFTotalGasto.setFont(new Font("Arial", 1, 15));
        this.JTFFTotalGasto.setValue(new Double(0.0d));
        GroupLayout JPIFacturaInterna1Layout = new GroupLayout(this.JPIFacturaInterna1);
        this.JPIFacturaInterna1.setLayout(JPIFacturaInterna1Layout);
        JPIFacturaInterna1Layout.setHorizontalGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInterna1Layout.createSequentialGroup().addContainerGap().addGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFNeto).addComponent(this.JTFFBaseIva, -1, 110, 32767)).addGap(28, 28, 28).addGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInterna1Layout.createSequentialGroup().addComponent(this.JTFFTotalD, -2, 110, -2).addGap(0, 0, 32767)).addComponent(this.JTFFTotalGasto)).addContainerGap()));
        JPIFacturaInterna1Layout.setVerticalGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInterna1Layout.createSequentialGroup().addGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFBaseIva, -2, 50, -2).addComponent(this.JTFFTotalD, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIFacturaInterna1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalGasto, -2, 50, -2).addComponent(this.JTFFNeto, -2, 50, -2))));
        this.JSPCGasto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "CUENTAS GASTOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JTCGasto.setBorder(BorderFactory.createBevelBorder(0));
        this.JTCGasto.setFont(new Font("Arial", 1, 12));
        this.JTCGasto.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTCGasto.setEditingColumn(2);
        this.JTCGasto.setEditingRow(1);
        this.JTCGasto.setGridColor(new Color(204, 204, 204));
        this.JTCGasto.setRowHeight(25);
        this.JTCGasto.setRowMargin(2);
        this.JTCGasto.setSelectionBackground(new Color(255, 255, 255));
        this.JTCGasto.setSelectionForeground(Color.red);
        this.JTCGasto.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFLiquidacionRad.7
            public void focusLost(FocusEvent evt) {
                JIFLiquidacionRad.this.JTCGastoFocusLost(evt);
            }
        });
        this.JTCGasto.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFLiquidacionRad.8
            public void mouseClicked(MouseEvent evt) {
                JIFLiquidacionRad.this.JTCGastoMouseClicked(evt);
            }
        });
        this.JTCGasto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFLiquidacionRad.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFLiquidacionRad.this.JTCGastoPropertyChange(evt);
            }
        });
        this.JTCGasto.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFLiquidacionRad.10
            public void keyPressed(KeyEvent evt) {
                JIFLiquidacionRad.this.JTCGastoKeyPressed(evt);
            }
        });
        this.JSPCGasto.setViewportView(this.JTCGasto);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBTDeducciones.setFont(new Font("Arial", 1, 12));
        this.JBTDeducciones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTDeducciones.setText("<html><P ALIGN=center>Adicionar Cuentas a Deducciones");
        this.JBTDeducciones.addActionListener(new ActionListener() { // from class: Contabilidad.JIFLiquidacionRad.11
            public void actionPerformed(ActionEvent evt) {
                JIFLiquidacionRad.this.JBTDeduccionesActionPerformed(evt);
            }
        });
        this.JLBNumero.setBackground(new Color(255, 255, 255));
        this.JLBNumero.setFont(new Font("Arial", 1, 20));
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "N°", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JBTGastos.setFont(new Font("Arial", 1, 12));
        this.JBTGastos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGastos.setText("<html><P ALIGN=center>Adicionar Cuentas a Gasto");
        this.JBTGastos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFLiquidacionRad.12
            public void actionPerformed(ActionEvent evt) {
                JIFLiquidacionRad.this.JBTGastosActionPerformed(evt);
            }
        });
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 20));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Estado", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JCBCuentaBancaria2.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaBancaria2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Cuenta Bancaria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaBancaria2.addItemListener(new ItemListener() { // from class: Contabilidad.JIFLiquidacionRad.13
            public void itemStateChanged(ItemEvent evt) {
                JIFLiquidacionRad.this.JCBCuentaBancaria2ItemStateChanged(evt);
            }
        });
        this.JCBTipoDoc_Cont.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Cont.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DContablesLayout = new GroupLayout(this.JPI_DContables);
        this.JPI_DContables.setLayout(JPI_DContablesLayout);
        JPI_DContablesLayout.setHorizontalGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DContablesLayout.createSequentialGroup().addComponent(this.JCBTipoDoc_Cont, 0, 251, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTDeducciones, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGastos, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNumero, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBEstado, -2, 130, -2)).addGroup(JPI_DContablesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFacturaInterna1, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JCBCuentaBancaria2, GroupLayout.Alignment.TRAILING, -2, 286, -2)))).addContainerGap()).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPImpuestos, -1, 708, 32767).addComponent(this.JSPCGasto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -1, 282, 32767).addContainerGap())));
        JPI_DContablesLayout.setVerticalGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContablesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIFacturaInterna1, -1, -1, 32767).addGap(87, 87, 87).addComponent(this.JCBCuentaBancaria2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBEstado, -1, -1, 32767).addComponent(this.JLBNumero, -2, 55, -2)).addComponent(this.JBTGastos, -2, 54, -2).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoDoc_Cont, -2, 50, -2).addComponent(this.JBTDeducciones, -2, 54, -2))).addGap(17, 17, 17)).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContablesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPImpuestos, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPCGasto, -2, 123, -2).addComponent(this.JSPObservacion, -2, 74, -2)).addGap(84, 84, 84))));
        this.JTP_Datos.addTab("LIQUIDACIÓN CONTABLE", this.JPI_DContables);
        this.JPID_Ppto.setBorder(BorderFactory.createEtchedBorder());
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Ppt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.addItemListener(new ItemListener() { // from class: Contabilidad.JIFLiquidacionRad.14
            public void itemStateChanged(ItemEvent evt) {
                JIFLiquidacionRad.this.JCBTipoDoc_PptItemStateChanged(evt);
            }
        });
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setForeground(Color.red);
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        this.JCH_UtilizarVR.setFont(new Font("Arial", 1, 12));
        this.JCH_UtilizarVR.setText("Utilizar valores del rubro?");
        this.JCH_UtilizarVR.addActionListener(new ActionListener() { // from class: Contabilidad.JIFLiquidacionRad.15
            public void actionPerformed(ActionEvent evt) {
                JIFLiquidacionRad.this.JCH_UtilizarVRActionPerformed(evt);
            }
        });
        GroupLayout JPID_PptoLayout = new GroupLayout(this.JPID_Ppto);
        this.JPID_Ppto.setLayout(JPID_PptoLayout);
        JPID_PptoLayout.setHorizontalGroup(JPID_PptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_PptoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 372, -2).addGap(18, 18, 18).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_UtilizarVR, -2, 170, -2).addContainerGap(19, 32767)));
        JPID_PptoLayout.setVerticalGroup(JPID_PptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_PptoLayout.createSequentialGroup().addContainerGap().addGroup(JPID_PptoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt).addComponent(this.JCH_UtilizarVR)).addGap(13, 13, 13)));
        this.JSP_DRubros.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "RUBRO(s)", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 51)));
        this.JTB_DRubros.setBorder(BorderFactory.createBevelBorder(0));
        this.JTB_DRubros.setFont(new Font("Arial", 1, 12));
        this.JTB_DRubros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_DRubros.setEditingColumn(2);
        this.JTB_DRubros.setEditingRow(1);
        this.JTB_DRubros.setGridColor(new Color(204, 204, 204));
        this.JTB_DRubros.setRowHeight(25);
        this.JTB_DRubros.setRowMargin(2);
        this.JTB_DRubros.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DRubros.setSelectionForeground(Color.red);
        this.JTB_DRubros.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFLiquidacionRad.16
            public void focusLost(FocusEvent evt) {
                JIFLiquidacionRad.this.JTB_DRubrosFocusLost(evt);
            }
        });
        this.JTB_DRubros.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFLiquidacionRad.17
            public void mouseClicked(MouseEvent evt) {
                JIFLiquidacionRad.this.JTB_DRubrosMouseClicked(evt);
            }
        });
        this.JTB_DRubros.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFLiquidacionRad.18
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFLiquidacionRad.this.JTB_DRubrosPropertyChange(evt);
            }
        });
        this.JTB_DRubros.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFLiquidacionRad.19
            public void keyPressed(KeyEvent evt) {
                JIFLiquidacionRad.this.JTB_DRubrosKeyPressed(evt);
            }
        });
        this.JSP_DRubros.setViewportView(this.JTB_DRubros);
        this.JTFFTotalizarR.setEditable(false);
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_PptoLayout = new GroupLayout(this.JPI_Ppto);
        this.JPI_Ppto.setLayout(JPI_PptoLayout);
        JPI_PptoLayout.setHorizontalGroup(JPI_PptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_PptoLayout.createSequentialGroup().addGroup(JPI_PptoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_PptoLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPI_PptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_DRubros).addComponent(this.JPID_Ppto, -1, -1, 32767))).addGroup(JPI_PptoLayout.createSequentialGroup().addGap(311, 822, 32767).addComponent(this.JTFFTotalizarR, -2, 193, -2))).addContainerGap()));
        JPI_PptoLayout.setVerticalGroup(JPI_PptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PptoLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPID_Ppto, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_DRubros, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalizarR, -2, 50, -2).addContainerGap(14, 32767)));
        this.JTP_Datos.addTab("DATOS PRESUPUESTALES", this.JPI_Ppto);
        GroupLayout JPIDatosLLayout = new GroupLayout(this.JPIDatosL);
        this.JPIDatosL.setLayout(JPIDatosLLayout);
        JPIDatosLLayout.setHorizontalGroup(JPIDatosLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTP_Datos).addComponent(this.JPIRadicado, -1, -1, 32767)).addContainerGap()));
        JPIDatosLLayout.setVerticalGroup(JPIDatosLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPIRadicado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -1, 401, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatosL, -2, -1, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosL, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImpuestosMouseClicked(MouseEvent evt) {
        if (this.JTImpuestos.getRowCount() > 0) {
            mCalcularIva();
            mCalcularTotales();
            if (evt.getClickCount() == 2 && this.JTImpuestos.getSelectedColumn() == 11) {
                mModificarTercero(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFBaseIvaFocusLost(FocusEvent evt) {
        if (this.JTImpuestos.getRowCount() > 0) {
            mCalcularIva();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFBaseIvaActionPerformed(ActionEvent evt) {
        this.JTFFBaseIva.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImpuestosFocusLost(FocusEvent evt) {
        mCalcularTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGastosActionPerformed(ActionEvent evt) {
        JD_Buscar_Cuenta_Puc xjd_cuenta = new JD_Buscar_Cuenta_Puc(Principal.xclase.frmPrincipal, true, this, 0);
        xjd_cuenta.setLocation((this.xmetodos.getAnchoPantalla() / 2) / 2, (this.xmetodos.getAltoPantalla() / 2) / 2);
        xjd_cuenta.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCGastoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcularTotales();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDeduccionesActionPerformed(ActionEvent evt) {
        JD_Buscar_Cuenta_Puc xjd_cuenta = new JD_Buscar_Cuenta_Puc(Principal.xclase.frmPrincipal, true, this, 1);
        xjd_cuenta.setLocation((this.xmetodos.getAnchoPantalla() / 2) / 2, (this.xmetodos.getAltoPantalla() / 2) / 2);
        xjd_cuenta.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCGastoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelogasto.removeRow(this.JTCGasto.getSelectedRow());
                this.xnfila--;
            }
            mCalcularTotales();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImpuestosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTImpuestos.getSelectedRow());
                this.xnfilad--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImpuestosPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.JTImpuestos.getRowCount() > 0) {
            mCalcularIva();
            mCalcularTotales();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCGastoFocusLost(FocusEvent evt) {
        mCalcularTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCGastoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTCGasto.getSelectedColumn() == 4) {
            mModificarTercero(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DRubrosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DRubrosFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DRubrosPropertyChange(PropertyChangeEvent evt) {
        if (this.JTB_DRubros.getSelectedColumn() == 4 && this.JTB_DRubros.getRowCount() != 0) {
            if (Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 4).toString()).doubleValue() > Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 3).toString()).doubleValue()) {
                JOptionPane.showInternalMessageDialog(this, "Valor a Pagar no puede ser mayor a Valor del Saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.xmodelo_r.setValueAt(Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 3).toString()), this.JTB_DRubros.getSelectedRow(), 4);
            }
            sumarTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DRubrosKeyPressed(KeyEvent evt) {
        if (this.JTB_DRubros.getSelectedColumn() == 4 && this.JTB_DRubros.getRowCount() != 0) {
            if (Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 4).toString()).doubleValue() > Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 3).toString()).doubleValue()) {
                JOptionPane.showInternalMessageDialog(this, "Valor a Pagar no puede ser mayor a Valor del Saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.xmodelo_r.setValueAt(Double.valueOf(this.xmodelo_r.getValueAt(this.JTB_DRubros.getSelectedRow(), 3).toString()), this.JTB_DRubros.getSelectedRow(), 4);
            }
            sumarTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaBancaria2ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBCuentaBancaria2.getSelectedIndex() != -1) {
            this.xidcuentabdispersion = Integer.valueOf(this.xidcuentabancaria[this.JCBCuentaBancaria2.getSelectedIndex()]).intValue();
        } else {
            this.xidcuentabdispersion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_UtilizarVRActionPerformed(ActionEvent evt) {
        if (this.JTB_DRubros.getRowCount() != -1) {
            for (int x = 0; x < this.JTB_DRubros.getRowCount(); x++) {
                if (this.JCH_UtilizarVR.isSelected()) {
                    this.xmodelo_r.setValueAt(Double.valueOf(this.JTFFTotalFactura.getValue().toString()), x, 4);
                } else {
                    this.xmodelo_r.setValueAt(Double.valueOf(this.xmodelo_r.getValueAt(x, 3).toString()), x, 4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDoc_PptItemStateChanged(ItemEvent evt) {
        String sql = "SELECT id FROM pp_tipo_documentos WHERE (Nbre ='" + this.JCBTipoDoc_Ppt.getSelectedItem() + "' )";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                this.tipoDocPresupuesto = xrs1.getInt("id");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mModificarTercero(int xtipo) {
        int x = JOptionPane.showInternalConfirmDialog(this, "Desea modificar?", "MODIFICAR TERCERO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            JDBuscarDatosT xjdbuscar = new JDBuscarDatosT(null, true, this, xtipo);
            xjdbuscar.setLocationRelativeTo(this);
            xjdbuscar.setVisible(true);
        }
    }

    private void updateEntradaidContable(Long idDocContable) {
        this.xsql = "update i_entradas set Id_DocContable=" + idDocContable + " where IdProveedor=" + this.xidtercero + " and NoFactura='" + this.xnfactura + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void iniciarInformacionInicial(JInternalFrame xjif) {
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mRealizarCasting(xjif);
        mNuevo();
        mInicializarComponentes();
        mCargarLiqudiacion();
        mLlenarComboCuenta();
        this.xidObligacion = this.xidObligacion;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
            this.JTP_Datos.setEnabledAt(1, false);
            return;
        }
        mNuevo_DPpt();
        mCargarDatosPPt();
        mBuscarDatos(this.idRadicacion);
    }

    public void mCalcularIva() {
        if (this.JTImpuestos.getRowCount() > 0) {
            for (int x = 0; x < this.JTImpuestos.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue() && this.xmodelo.getValueAt(x, 3) != null && !Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    this.xmodelo.setValueAt(Long.valueOf(Math.round((Double.valueOf(this.xmodelo.getValueAt(x, 10).toString()).doubleValue() * Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue()) / 100.0d)), x, 4);
                }
            }
        }
    }

    private void mCalcularTotales() {
        double xvalort = 0.0d;
        double xvalorsf = 0.0d;
        for (int x = 0; x < this.JTImpuestos.getRowCount(); x++) {
            if (!this.xmodelo.getValueAt(x, 4).toString().equals("") || this.xmodelo.getValueAt(x, 4) != null) {
                if (this.xobjetollamador.equals("jifradicacionnc")) {
                    if (!Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                        xvalort += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                    } else {
                        xvalorsf += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                    }
                } else if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                    xvalort += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                } else {
                    xvalorsf += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                }
            }
        }
        double xvalorsd = 0.0d;
        double xtotal = 0.0d;
        for (int x2 = 0; x2 < this.JTCGasto.getRowCount(); x2++) {
            if (!this.xmodelogasto.getValueAt(x2, 3).toString().equals("") || this.xmodelogasto.getValueAt(x2, 3) != null) {
                if (!Boolean.valueOf(this.xmodelogasto.getValueAt(x2, 2).toString()).booleanValue()) {
                    xtotal += Double.valueOf(this.xmodelogasto.getValueAt(x2, 3).toString()).doubleValue();
                } else {
                    xvalorsd += Double.valueOf(this.xmodelogasto.getValueAt(x2, 3).toString()).doubleValue();
                }
            }
        }
        this.JTFFTotalD.setValue(Double.valueOf(xvalort));
        this.JTFFNeto.setValue(Double.valueOf((xvalorsf + Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue()) - xvalort));
        this.JTFFTotalGasto.setValue(Double.valueOf(xtotal));
        for (int x3 = 0; x3 < this.JTCGasto.getRowCount(); x3++) {
            if ((!this.xmodelogasto.getValueAt(x3, 3).toString().equals("") || this.xmodelogasto.getValueAt(x3, 3) != null) && this.xmodelogasto.getValueAt(x3, 0).toString().equals(this.xidauxiliarpago) && Boolean.valueOf(this.xmodelogasto.getValueAt(x3, 5).toString()).booleanValue()) {
                this.xmodelogasto.setValueAt(this.JTFFNeto.getValue(), x3, 3);
            }
        }
    }

    public void mGrabar() {
        if (Principal.xclase.getXidperiodoc() != -1) {
            if (Principal.xclase.isXestadop()) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                    if (this.JLBNumero.getText().isEmpty() && this.tipo != 3) {
                        if (mCompararValores()) {
                            if (Double.valueOf(this.JTFFSubTotal.getValue().toString()) != Double.valueOf(this.JTFFTotalGasto.getValue().toString())) {
                                if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                                    if (this.JCBTipoDoc_Ppt.getSelectedIndex() != -1) {
                                        if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                            System.out.println("" + Double.valueOf(this.JTFFTotalFactura.getValue().toString()));
                                            System.out.println("" + Double.valueOf(this.JTFFTotalizarR.getValue().toString()));
                                            if (Double.valueOf(this.JTFFTotalFactura.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFFTotalizarR.getValue().toString()).doubleValue()) {
                                                mGrabar_Base();
                                                return;
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "El Valor de la Obligación no puede ser mayor al pago,\nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                return;
                                            }
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento presupuestal,\nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento presupuestal,\nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    return;
                                }
                                mGrabar_Base();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Distribución errada,\nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Favor revisar, valores errados", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    if (this.JTFFNDoc_Ppt.getText().isEmpty()) {
                        mGrabar_PPT();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFFechaC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Periodo cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen mas de un periodo abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mGrabar_Base() {
        double xvalorc;
        int xtipoc;
        double xvalord;
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            mConsecutivoCont();
            String sql = "insert into " + this.xcc_documentoc + " (FechaD, Id_TipoComprobante, Id_Radicacion, Id_PeriodoC,NConsecutivo, Id_CuentaEmpresa, Descripcion, Fecha, UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "','" + this.idRadicacion + "','" + this.xperiodoc + "','" + this.xConsecutivo + "','" + this.xidcuentabdispersion + "','" + this.xconceptop + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JLBNumero.setText(this.xct.ejecutarSQLId(sql));
            this.JLBEstado.setText("ACTIVO");
            this.xct.cerrarConexionBd();
            mGrabarCuentasI();
            for (int y = 0; y < this.JTImpuestos.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue()) {
                    xvalord = Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
                    xtipoc = 1;
                    xvalorc = 0.0d;
                } else {
                    xvalorc = Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
                    xtipoc = 0;
                    xvalord = 0.0d;
                }
                if (this.xobjetollamador.equals("jifradicacionnc")) {
                    this.xnfactura = this.xjifradnc.JCBNFactura.getSelectedItem().toString();
                } else if (this.xobjetollamador.equals("jifradicacionfac")) {
                    this.xnfactura = this.xjifradn.JTFNFactura.getText();
                }
                String sql2 = "insert into " + this.xcc_detalle_documentoc + " (Id_Documentoc, Id_Puc, TipoCPuc,Concepto, Id_Radicacion, NFactura, Id_Tercero, VDebito, VCredito, Base, PRetencion) Values ('" + this.JLBNumero.getText() + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + xtipoc + "','" + this.JTAObservacion.getText() + "','" + this.idRadicacion + "','" + this.xnfactura + "','" + this.xmodelo.getValueAt(y, 11).toString() + "',round('" + xvalorc + "'),round('" + xvalord + "'),round('" + this.xmodelo.getValueAt(y, 10).toString() + "'),'" + this.xmodelo.getValueAt(y, 2) + "' )";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
            mCompararValores();
            mGrabarUsuarioA();
            if (this.xtipodoc == 3) {
                mActualizarNDCNotaCredito();
            }
            mActualizar_Entrada_DocContable();
            if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                mGrabar_PPT();
            }
            consultarAuditoria();
            updateEntradaidContable(Long.valueOf(this.JLBNumero.getText()));
        }
    }

    private void mGrabar_PPT() {
        List<PpMovimiento> movimientos = new ArrayList<>();
        new ArrayList();
        List<Long> listIdCompromiso = new ArrayList<>();
        for (int i = 0; i < this.JTB_DRubros.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo_r.getValueAt(i, 5).toString()).booleanValue() && !verificarSiYaEstaEnlaLista(Long.valueOf(this.JTB_DRubros.getValueAt(i, 6).toString()), listIdCompromiso)) {
                listIdCompromiso.add(Long.valueOf(this.JTB_DRubros.getValueAt(i, 6).toString()));
            }
        }
        if (!listIdCompromiso.isEmpty()) {
            GMotivoanulacion motivoanulacion = new GMotivoanulacion();
            motivoanulacion.setId(1);
            mConsecutivoPresupuesto();
            for (Long long1 : listIdCompromiso) {
                PpMovimiento mov = new PpMovimiento();
                List<PpDetalleMovimiento> detalleMovimientos = new ArrayList<>();
                mov.setIdTipoDoc(this.ppTipoDocumentos.get(this.JCBTipoDoc_Ppt.getSelectedIndex()));
                mov.setIdPeriodo(this.ppPeriodos.get(this.JCBPeriodo_Ppt.getSelectedIndex()));
                System.out.println("consecutivo -> " + this.xConsecutivo);
                mov.setNoConcecutivo(this.xConsecutivo);
                mov.setFechaD(this.JDFFechaC.getDate());
                mov.setIdUsuarioR(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                mov.setObservacion(this.xconceptop);
                if (this.JLBNumero.getText().isEmpty()) {
                    mov.setIdDocContable(new Long(0L));
                } else {
                    mov.setIdDocContable(Long.valueOf(this.JLBNumero.getText()));
                }
                mov.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                mov.setIdRadicacion(Long.valueOf(this.idRadicacion));
                mov.setFecha(this.xmetodos.getFechaActual());
                mov.setIdUsuarioR(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                mov.setNoFact(this.xnfactura);
                mov.setIdMotivoAnulacion(motivoanulacion);
                mov.setIdCompromiso(long1);
                mov.setIdRadicacion(Long.valueOf(this.idRadicacion));
                mov.setEsGlobal(false);
                mov.setBloqueo(false);
                mov.setIdNomina(new Long(0L));
                mov.setNoDocumento("");
                mov.setIdObligacion(new Long(0L));
                mov.setIdDisponibilidad(new Long(0L));
                mov.setIdSolicitud(new Long(0L));
                for (int i2 = 0; i2 < this.JTB_DRubros.getRowCount(); i2++) {
                    Double valor = Double.valueOf(this.xmodelo_r.getValueAt(i2, 4).toString());
                    this.idCompromiso = Long.valueOf(this.JTB_DRubros.getValueAt(i2, 6).toString());
                    int tipoVig = Integer.parseInt(this.xmodelo_r.getValueAt(i2, 13).toString());
                    int centroC = Integer.parseInt(this.xmodelo_r.getValueAt(i2, 11).toString());
                    int fuenteF = Integer.parseInt(this.xmodelo_r.getValueAt(i2, 9).toString());
                    int cpc = Integer.parseInt(this.xmodelo_r.getValueAt(i2, 7).toString());
                    if (Boolean.valueOf(this.xmodelo_r.getValueAt(i2, 5).toString()).booleanValue()) {
                        PpDetalleMovimiento dt = new PpDetalleMovimiento();
                        System.out.println("" + long1);
                        if (Objects.equals(long1, this.idCompromiso)) {
                            PpRubros ppRubros = new PpRubros();
                            GEmpresa empresa = new GEmpresa();
                            PpTipoVigencia ppTipoVigencia = new PpTipoVigencia();
                            ppTipoVigencia.setId(Integer.valueOf(tipoVig));
                            PpRubrosCentrocostos ppRubrosCentrocostos = new PpRubrosCentrocostos();
                            ppRubrosCentrocostos.setId(Integer.valueOf(centroC));
                            PpRubrosFuenteFinanciacion ppRubrosFunteFinanciacion = new PpRubrosFuenteFinanciacion();
                            ppRubrosFunteFinanciacion.setId(Integer.valueOf(fuenteF));
                            PpRubrosCpc ppRubrosCpc = new PpRubrosCpc();
                            ppRubrosCpc.setId(Integer.valueOf(cpc));
                            empresa.setId(this.idTercero);
                            ppRubros.setId(this.xmodelo_r.getValueAt(i2, 0).toString());
                            dt.setNFactura(this.xnfactura);
                            dt.setObservacion(this.xconceptop);
                            dt.setValor(valor.doubleValue());
                            dt.setIdRubro(ppRubros);
                            dt.setEstado(true);
                            dt.setIdConceptoN(0);
                            dt.setIdEncabezado(this.ppPeriodos.get(this.JCBPeriodo_Ppt.getSelectedIndex()).getIdEncabezado());
                            dt.setIdTercero(empresa);
                            dt.setNCCobro(new Long(0L));
                            dt.setTipo(false);
                            dt.setIdMovimiento(mov);
                            dt.setPpTipoVigencia(ppTipoVigencia);
                            dt.setPpRubrosCentrocostos(ppRubrosCentrocostos);
                            dt.setPpRubrosFunteFinanciacion(ppRubrosFunteFinanciacion);
                            dt.setPpRubrosCpc(ppRubrosCpc);
                            detalleMovimientos.add(dt);
                        }
                    }
                }
                mov.setPpDetalleMovimientoCollection(detalleMovimientos);
                movimientos.add(mov);
            }
            List<PpMovimiento> movimientosNuevos = this.iPpMovimientoService.grabar(movimientos);
            List<Long> idMovimientosNuevos = new ArrayList<>();
            movimientosNuevos.forEach(item -> {
                idMovimientosNuevos.add(item.getId());
            });
            List<Integer> idConsecutivo = new ArrayList<>();
            new ArrayList();
            List<PpMovimiento> movimientosNuevos2 = this.iPpMovimientoService.buscarMovimientoPorId(idMovimientosNuevos);
            if (!movimientosNuevos2.isEmpty()) {
                movimientosNuevos2.forEach(item2 -> {
                    idConsecutivo.add(Integer.valueOf(item2.getNoConcecutivo()));
                    item2.setIdObligacion(item2.getId());
                    if (!this.movimientosCompromiso.isEmpty()) {
                        this.movimientosCompromiso.forEach(itemCompromiso -> {
                            if (Objects.equals(itemCompromiso.getId(), item2.getIdCompromiso())) {
                                itemCompromiso.setIdObligacion(item2.getId());
                            }
                        });
                    }
                });
                this.iPpMovimientoService.grabar(this.movimientosCompromiso);
                this.JTFFNDoc_Ppt.setText("" + idConsecutivo);
                actualizarObligacionPresupuestal();
            }
        }
    }

    private void mActualizarNDCNotaCredito() {
        String sql = "update cc_radicacion_notac set Id_DocumentoC='" + this.JLBNumero.getText() + "' where Id='" + this.idRadicacion + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGrabarCuentasI() {
        double xvalorc;
        int xtipoc;
        double xvalord;
        ConsultasMySQL xct = new ConsultasMySQL();
        for (int x = 0; x < this.JTCGasto.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelogasto.getValueAt(x, 2).toString()).booleanValue()) {
                xvalord = Double.valueOf(this.xmodelogasto.getValueAt(x, 3).toString()).doubleValue();
                xtipoc = 1;
                xvalorc = 0.0d;
            } else {
                xvalorc = Double.valueOf(this.xmodelogasto.getValueAt(x, 3).toString()).doubleValue();
                xtipoc = 0;
                xvalord = 0.0d;
            }
            String xnfactura = "";
            if (this.xobjetollamador.equals("jifradicacionnc")) {
                xnfactura = this.xjifradnc.JCBNFactura.getSelectedItem().toString();
            } else if (this.xobjetollamador.equals("jifradicacionfac")) {
                xnfactura = this.xjifradn.JTFNFactura.getText();
            }
            String sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Tercero, Id_Radicacion, NFactura, Concepto, Id_Puc, TipoCPuc, VDebito, VCredito) Values ('" + this.JLBNumero.getText() + "','" + this.xmodelogasto.getValueAt(x, 4) + "','" + this.idRadicacion + "','" + xnfactura + "','" + this.JTAObservacion.getText() + "','" + this.xmodelogasto.getValueAt(x, 0) + "','" + xtipoc + "',round('" + xvalorc + "'),round('" + xvalord + "'))";
            xct.ejecutarSQL(sql);
            xct.cerrarConexionBd();
        }
    }

    private void mConsecutivoCont() {
        if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
            int Con = 0;
            String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "' AND `Estado` =1);";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(sql);
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    Con = xrs1.getInt("MaximoCons");
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.xConsecutivo = Con + 1;
        }
    }

    private void mConsecutivoPresupuesto() {
        if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
            int Con = 0;
            String sql = "SELECT MAX(`NoConcecutivo`) AS MaximoCons \nFROM `pp_movimiento` m \nINNER JOIN `pp_detalle_movimiento` dm ON m.`Id`=dm.`Id_Movimiento`\nWHERE (`Id_TipoDoc` ='" + this.tipoDocPresupuesto + "' AND dm.`idEncabezado` = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            System.out.println("aaaaaaaaaa -> " + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(sql);
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    Con = xrs1.getInt("MaximoCons");
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.xConsecutivo = Con + 1;
        }
    }

    private boolean mCompararValores() {
        boolean estado;
        double xvalord = 0.0d;
        double xvalorc = 0.0d;
        for (int y = 0; y < this.JTImpuestos.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue()) {
                xvalord += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
            } else {
                xvalorc += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
            }
        }
        for (int y2 = 0; y2 < this.JTCGasto.getRowCount(); y2++) {
            if (Boolean.valueOf(this.xmodelogasto.getValueAt(y2, 2).toString()).booleanValue()) {
                xvalord += Double.valueOf(this.xmodelogasto.getValueAt(y2, 3).toString()).doubleValue();
            } else {
                xvalorc += Double.valueOf(this.xmodelogasto.getValueAt(y2, 3).toString()).doubleValue();
            }
        }
        if (xvalord == xvalorc) {
            estado = true;
        } else {
            estado = false;
        }
        return estado;
    }

    private void consultarAuditoria() {
        if (Principal.xclase.getRequiereAuditoria() == 1) {
            JDAuditoresDocumentos e = new JDAuditoresDocumentos(null, true, Long.valueOf(this.xidtercero), Long.valueOf(this.JLBNumero.getText()));
            e.setLocationRelativeTo(this);
            e.setVisible(true);
        }
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JTAObservacion.setText("");
        this.JTFFSubTotal.setValue(new Integer(0));
        this.JTFFIva.setValue(new Integer(0));
        this.JTFFFlete.setValue(new Integer(0));
        this.JTFFOtros.setValue(new Integer(0));
        this.JTFFTotalFactura.setValue(new Integer(0));
        this.JDFFechaC.requestFocus();
        this.JCBTipoDoc_Cont.removeAllItems();
        this.xsql = "SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1 and IdClasificacion='" + this.idClasificacion + "' and EsContable=1) ORDER BY Nbre ASC";
        this.xidtipodoc_cont = this.xct.llenarComboyLista(this.xsql, this.xidtipodoc_cont, this.JCBTipoDoc_Cont, 3);
        this.xct.cerrarConexionBd();
        this.xnfila = 0;
    }

    private void mLlenarComboCuenta() {
        this.xlleno = false;
        this.JCBCuentaBancaria2.removeAllItems();
        this.xsql = "SELECT  `cc_cuentaxempresa`.`Id` , CONCAT(`cc_banco`.`Nbre`,' ', `cc_cuentaxempresa`.`NCuenta`) AS NCuenta FROM `cc_cuentaxempresa` INNER JOIN  `cc_bancoxsucursal`  ON (`cc_cuentaxempresa`.`Id_SucursalxBanco` = `cc_bancoxsucursal`.`Id`) INNER JOIN  `cc_banco`  ON (`cc_bancoxsucursal`.`Id_Banco` = `cc_banco`.`Id`) WHERE (`cc_cuentaxempresa`.`Id_Empresa` ='" + this.xidtercero + "' AND cc_cuentaxempresa.`Estado`=1) ORDER BY `cc_cuentaxempresa`.`ACheque` DESC ";
        this.xidcuentabancaria = this.xct.llenarCombo(this.xsql, this.xidcuentabancaria, this.JCBCuentaBancaria2);
        this.JCBCuentaBancaria2.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mAnular() {
        if (!this.JLBNumero.getText().isEmpty() || !this.JTFFNDoc_Ppt.getText().isEmpty()) {
            if (!mConsultarDocumentoC().booleanValue()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Liquidacion_Radicacion", 6);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se puede anular;\nDocumento contable con comprobante activo", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private Boolean mConsultarDocumentoC() {
        boolean xestado = false;
        try {
            String sql = "SELECT `cc_documentoc`.`Id`, `cc_radicacion`.`Id_Comprobante` FROM  `cc_documentoc` INNER JOIN  `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) INNER JOIN  `cc_detalle_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id` = `cc_detalle_documentoc`.`Id_Radicacion`) WHERE (`cc_documentoc`.`Id` ='" + this.JLBNumero.getText() + "'  AND `cc_radicacion`.`Id_Comprobante` <>0 AND `cc_documentoc`.`Estado` =1) GROUP BY `cc_documentoc`.`Id` ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xestado = true;
            } else {
                xestado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(xestado);
    }

    public void mAnularDoc(String xid, String xmotivo) {
        String sql = "update cc_documentoc set Estado=0 , `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where id='" + this.JLBNumero.getText() + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.JLBEstado.setText("");
        System.out.println("" + this.idMovimientoObligacion);
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            new ArrayList();
            new ArrayList();
            System.out.println("" + this.idMovimientoObligacion);
            System.out.println("motivo anulacion " + xid);
            List<PpMovimiento> movimientosObligacion = this.iPpMovimientoService.buscarMovimientoPorId(this.idMovimientoObligacion);
            if (!movimientosObligacion.isEmpty()) {
                GMotivoanulacion motivoanulacion = new GMotivoanulacion();
                motivoanulacion.setId(Integer.valueOf(xid));
                movimientosObligacion.forEach(itemMovimiento -> {
                    itemMovimiento.setIdMotivoAnulacion(motivoanulacion);
                    itemMovimiento.setFechaAnulacion(this.xmetodos.getFechaActual());
                    itemMovimiento.setObservacionAnul(xmotivo);
                    itemMovimiento.setUsuarioAnul(Principal.usuarioSistemaDTO.getNombreUsuario());
                    itemMovimiento.getPpDetalleMovimientoCollection().forEach(detalle -> {
                        detalle.setEstado(false);
                    });
                });
                List<PpMovimiento> movimientosCompromiso = this.iPpMovimientoService.buscarMovimientoPorIdObligacionIdClaseDocumento(this.idMovimientoObligacion, 4);
                movimientosCompromiso.forEach(itemCompromiso -> {
                    itemCompromiso.setIdObligacion(new Long(0L));
                    itemCompromiso.setIdMotivoAnulacion(motivoanulacion);
                });
                this.iPpMovimientoService.grabar(movimientosCompromiso);
                this.iPpMovimientoService.grabar(movimientosObligacion);
                this.JTFFNDoc_Ppt.setText("");
            }
            iniciarInformacionInicial(this.xjif);
        }
        this.JLBNumero.setText("");
    }

    private boolean mValidar() {
        boolean xestado1 = false;
        if (Double.valueOf(this.JTFFNeto.getValue().toString()).doubleValue() != 0.0d) {
            xestado1 = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe resgistra valores de factura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFSubTotal.requestFocus();
        }
        return xestado1;
    }

    private void mCalcularTotal() {
        double total = Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFFlete.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFIva.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFOtros.getValue().toString()).doubleValue();
        this.JTFFTotalFactura.setValue(Double.valueOf(total));
    }

    public void mBuscar() {
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT cc_radicacion.Id, cc_radicacion.Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion.NoCompra, cc_radicacion.FechaOrdenC, cc_radicacion.PeriodoFac, cc_radicacion.FechaFac, cc_radicacion.NoFactura, cc_radicacion.NoMedicamentos , cc_radicacion.NoPacientes, cc_radicacion.SubTotal, cc_radicacion.Iva, cc_radicacion.Flete, cc_radicacion.Otros, cc_radicacion.Observacion, cc_radicacion.Estado, cc_radicacion.Pagada,`cc_radicacion`.`Tipo`  FROM cc_radicacion INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion.Id ='" + xid + "') ";
        System.out.println(sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                LocalDate date = LocalDate.now();
                SimpleDateFormat spf = new SimpleDateFormat("yyyy");
                Principal.txtNo.setText(xrs.getString(1));
                this.JTFFSubTotal.setValue(Double.valueOf(xrs.getDouble(11)));
                if (Integer.valueOf(spf.format((Date) xrs.getDate(2))).intValue() < date.getYear()) {
                    this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
                } else {
                    this.JDFFechaC.setDate(xrs.getDate(2));
                }
                this.JTFFIva.setValue(Double.valueOf(xrs.getDouble(12)));
                this.JTFFFlete.setValue(Double.valueOf(xrs.getDouble(13)));
                this.JTFFOtros.setValue(Double.valueOf(xrs.getDouble(14)));
                this.JTAObservacion.setText(xrs.getString(15));
                this.tipo = xrs.getInt("Tipo");
                mCalcularTotal();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.xobjetollamador.equals("jifradicacionfac")) {
                this.xjifradn.xclases.mImprimDocumentoContable("IdC", this.JLBNumero.getText(), this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][1], "1", this.JTFFNeto.getValue().toString(), this.JTFFTotalFactura.getText());
            } else if (this.xobjetollamador.equals("jifradicacionnc")) {
                Principal.xclase.mImprimDocumentoContable("IdC", this.JLBNumero.getText(), "CC_LiquidacionNotaCredito", "5", this.JTFFNeto.getValue().toString(), this.JTFFTotalFactura.getText());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaImpuesto() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "%", "Calcular?", "Valor", "", "TipoV", "ValorF", "Tipo (C-D)", "IdPuc", "Base", "IdTercero"}) { // from class: Contabilidad.JIFLiquidacionRad.20
            Class[] types = {Long.class, String.class, Double.class, Boolean.class, Double.class, Long.class, Boolean.class, Double.class, Boolean.class, String.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTImpuestos.setModel(this.xmodelo);
        this.JTImpuestos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(1).setPreferredWidth(210);
        this.JTImpuestos.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTImpuestos.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTImpuestos.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTImpuestos.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTImpuestos.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTImpuestos.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTImpuestos.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTImpuestos.getColumnModel().getColumn(11).setPreferredWidth(20);
    }

    private void mCrearTablaGasto() {
        this.xmodelogasto = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "TipoC", "Valor", "IdTercero", "Calcular?"}) { // from class: Contabilidad.JIFLiquidacionRad.21
            Class[] types = {Long.class, String.class, Boolean.class, Double.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTCGasto.setModel(this.xmodelogasto);
        this.JTCGasto.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTCGasto.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTCGasto.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTCGasto.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTCGasto.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTCGasto.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private void mCrearTablaRubros() {
        this.xmodelo_r = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "V/Ppto", "Saldo", "V/Pagar", "Aplica?", "IdCompromiso", "idCpc", "CPC", "idFuenteFinanciacion", "Fuente Financiacion", "idCentroCostos", "Centro Costos", "idTipoVigencia", "Vigencia"}) { // from class: Contabilidad.JIFLiquidacionRad.22
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Boolean.class, Long.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, true, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTB_DRubros.setModel(this.xmodelo_r);
        this.JTB_DRubros.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTB_DRubros.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_DRubros.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTB_DRubros.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTB_DRubros.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTB_DRubros.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_DRubros.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTB_DRubros.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTB_DRubros.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTB_DRubros.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTB_DRubros.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_DRubros.getColumnModel().getColumn(14).setPreferredWidth(50);
    }

    private void mCrearTablaRegimen() {
        this.xmodeloregimen = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Aplicar?"}) { // from class: Contabilidad.JIFLiquidacionRad.23
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTTipoRegimen.setModel(this.xmodeloregimen);
        this.JTTipoRegimen.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTTipoRegimen.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTTipoRegimen.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatosImpuesto() {
        String sql = "SELECT cc_valorxtipo_impuesto.Id, cc_puc.Nbre, cc_valorxtipo_impuesto.PValor, cc_tipo_impuesto.Id, cc_valorxtipo_impuesto.TipoV, cc_valorxtipo_impuesto.ValorF, cc_puc.Tipo, cc_puc.Id  FROM cc_impuestoxempresa INNER JOIN cc_valorxtipo_impuesto ON (cc_impuestoxempresa.Id_Impuesto = cc_valorxtipo_impuesto.Id) INNER JOIN cc_tipo_impuesto  ON (cc_valorxtipo_impuesto.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_puc ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) WHERE (cc_impuestoxempresa.`Filtro` IN(-1,0) and cc_impuestoxempresa.Id_Empresa ='" + this.xidtercero + "' AND cc_impuestoxempresa.Estado =1) ORDER BY cc_tipo_impuesto.Nbre ASC, cc_puc.Nbre ASC ";
        System.out.println(sql);
        mCrearTablaImpuesto();
        try {
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 0;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                            this.xmodelo.setValueAt(rs.getString(2), x, 1);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                            this.xmodelo.setValueAt(true, x, 3);
                            if (rs.getInt(5) == 1) {
                                this.xmodelo.setValueAt(Double.valueOf(this.JTFFBaseIva.getValue().toString()), x, 4);
                            } else {
                                this.xmodelo.setValueAt(Double.valueOf((Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() * rs.getDouble(3)) / 100.0d), x, 4);
                            }
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 5);
                            this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 6);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 7);
                            this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(7)), x, 8);
                            this.xmodelo.setValueAt(rs.getString(8), x, 9);
                            if (rs.getDouble(3) != 0.0d) {
                                this.xmodelo.setValueAt(Double.valueOf(this.JTFFSubTotal.getValue().toString()), x, 10);
                            } else {
                                this.xmodelo.setValueAt(0, x, 10);
                            }
                            this.xmodelo.setValueAt(this.xidtercero, x, 11);
                            x++;
                            this.xnfilad++;
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosRegimen() {
        String sql = "SELECT cc_tipo_regimen.Id, cc_tipo_regimen.Nbre FROM cc_tiporegimenxempresa INNER JOIN cc_tipo_regimen  ON (cc_tiporegimenxempresa.Id_TipoRegimen = cc_tipo_regimen.Id) WHERE (cc_tiporegimenxempresa.Estado =1 AND cc_tiporegimenxempresa.Id_Empresa ='" + this.xidtercero + "') ORDER BY cc_tipo_regimen.Nbre ASC ";
        mCrearTablaRegimen();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloregimen.addRow(this.xdato);
                    this.xmodeloregimen.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodeloregimen.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloregimen.setValueAt(true, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosPPt() {
        new ArrayList();
        List<IInformacionCompromisosPorObligar> compromisosPorObligar = this.iRadicacionService.listCompromisoPorObligar(this.xId_Compromiso);
        if (!compromisosPorObligar.isEmpty()) {
            mCrearTablaRubros();
            compromisosPorObligar.forEach(item -> {
                this.xmodelo_r.addRow(this.xdato);
                this.xmodelo_r.setValueAt(item.getIdRubro(), this.JTB_DRubros.getRowCount() - 1, 0);
                this.xmodelo_r.setValueAt(item.getNombreRubro(), this.JTB_DRubros.getRowCount() - 1, 1);
                this.xmodelo_r.setValueAt(item.getValorCompromiso(), this.JTB_DRubros.getRowCount() - 1, 2);
                if (this.xobjetollamador.equals("jifradicacionnc")) {
                    this.xmodelo_r.setValueAt(item.getValorCompromiso(), this.JTB_DRubros.getRowCount() - 1, 3);
                    this.xmodelo_r.setValueAt(this.JTFFTotalFactura.getValue(), this.JTB_DRubros.getRowCount() - 1, 4);
                } else {
                    this.xmodelo_r.setValueAt(item.getValorPorObligacion(), this.JTB_DRubros.getRowCount() - 1, 3);
                    if (Double.valueOf(this.JTFFTotalFactura.getValue().toString()).doubleValue() > item.getValorPorObligacion().doubleValue()) {
                        this.xmodelo_r.setValueAt(item.getValorPorObligacion(), this.JTB_DRubros.getRowCount() - 1, 4);
                    } else {
                        this.xmodelo_r.setValueAt(Double.valueOf(this.JTFFTotalFactura.getValue().toString()), this.JTB_DRubros.getRowCount() - 1, 4);
                    }
                }
                this.xmodelo_r.setValueAt(true, this.JTB_DRubros.getRowCount() - 1, 5);
                this.xmodelo_r.setValueAt(item.getIdCompromiso(), this.JTB_DRubros.getRowCount() - 1, 6);
                this.xmodelo_r.setValueAt(item.getIdCpc(), this.JTB_DRubros.getRowCount() - 1, 7);
                this.xmodelo_r.setValueAt(item.getCpc(), this.JTB_DRubros.getRowCount() - 1, 8);
                this.xmodelo_r.setValueAt(item.getIdFuenteF(), this.JTB_DRubros.getRowCount() - 1, 9);
                this.xmodelo_r.setValueAt(item.getFuenteFinanciacion(), this.JTB_DRubros.getRowCount() - 1, 10);
                this.xmodelo_r.setValueAt(item.getIdCentroCostos(), this.JTB_DRubros.getRowCount() - 1, 11);
                this.xmodelo_r.setValueAt(item.getCentroCostos(), this.JTB_DRubros.getRowCount() - 1, 12);
                this.xmodelo_r.setValueAt(item.getIdTipoVig(), this.JTB_DRubros.getRowCount() - 1, 13);
                this.xmodelo_r.setValueAt(item.getTipoVigencia(), this.JTB_DRubros.getRowCount() - 1, 14);
            });
            sumarTotal();
        }
    }

    private void mCargarDatosPPt1() {
        String sql = "SELECT D.NoConcecutivo as  numeroConsecutivo\n                , D.IdCompromiso as idCompromiso\n                ,D.FechaD as FechaDocumento\n                ,D.TipoDoc tipoDocumento\n                ,D.Observacion observacion \n                ,D.Id_Tercero idTercero\n                ,D.Id_rubro idRubro\n                ,D.NombreRubro nombreRubro\n                ,D.COMPROMISO_ADICION AS valorCompromiso \n                ,IFNULL(C.Obligacion,0) valorObligacion\n                ,(D.COMPROMISO_ADICION-IFNULL(C.Obligacion,0)) valorPorObligacion\n                ,Estado estado\n                \n                 FROM \n                (\n     SELECT    A.* , ((A.COMPROMISO+IFNULL(B.COMPROMISO,0)) - IFNULL(R.COMPROMISO,0) ) COMPROMISO_ADICION FROM \n    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                       , pp_tipo_documentos.Nbre AS TipoDoc \n                       , pp_movimiento.Observacion \n                       , g_motivoanulacion.Nbre AS Estado \n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                       ,pp_detalle_movimiento.Id_Tercero\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_movimiento.`IdCompromiso` in(" + this.xId_Compromiso + ")                    -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) A\n       LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (12) \n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) B\n        ON A.IdDisponibilidad=B.IdDisponibilidad AND A.IdCompromiso=B.IdCompromiso        AND A.Id_Rubro=B.Id_Rubro \n       \n     LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (13) AND  pp_movimiento.`IdCompromiso` in(" + this.xId_Compromiso + ")  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) R\n       ON A.IdDisponibilidad=R.IdDisponibilidad AND A.IdCompromiso=R.IdCompromiso  AND A.Id_Rubro=R.Id_Rubro        ) D\n                      LEFT JOIN \n                     (SELECT  pp_movimiento.IdDisponibilidad\n                      , pp_movimiento.IdCompromiso\n                      , pp_detalle_movimiento.Id_Rubro\n                      , pp_detalle_movimiento.Id_Tercero\n                   ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n                        FROM pp_movimiento  \n                        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                        WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (5) AND pp_movimiento.`IdCompromiso` in(" + this.xId_Compromiso + ")  -- Busca Obligacion\n                        GROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n                  , pp_detalle_movimiento.Id_Rubro\n                  , pp_detalle_movimiento.Id_Tercero -- 38236318 8236318\n                      ) C\n                     ON  D.IdCompromiso=C.IdCompromiso \n                     AND D.Id_Rubro=C.Id_Rubro AND D.Id_Tercero=C.Id_Tercero\n                  WHERE (D.IdCompromiso=in(" + this.xId_Compromiso + "))";
        mCrearTablaRubros();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo_r.addRow(this.xdato);
                    this.xmodelo_r.setValueAt(rs.getString("Id_rubro"), x, 0);
                    this.xmodelo_r.setValueAt(rs.getString("NombreRubro"), x, 1);
                    this.xmodelo_r.setValueAt(Double.valueOf(rs.getDouble("Compromiso")), x, 2);
                    if (this.xobjetollamador.equals("jifradicacionnc")) {
                        this.xmodelo_r.setValueAt(Double.valueOf(rs.getDouble("Compromiso")), x, 3);
                        this.xmodelo_r.setValueAt(this.JTFFTotalFactura.getValue(), x, 4);
                    } else {
                        this.xmodelo_r.setValueAt(Double.valueOf(rs.getDouble("Por_Obligacion")), x, 3);
                        if (Double.valueOf(this.JTFFTotalFactura.getValue().toString()).doubleValue() > rs.getDouble("Por_Obligacion")) {
                            this.xmodelo_r.setValueAt(Double.valueOf(rs.getDouble("Por_Obligacion")), x, 4);
                        } else {
                            this.xmodelo_r.setValueAt(Double.valueOf(this.JTFFTotalFactura.getValue().toString()), x, 4);
                        }
                    }
                    this.xmodelo_r.setValueAt(true, x, 5);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            sumarTotal();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void sumarTotal() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.xmodelo_r.getRowCount(); y++) {
            xtotal += Double.valueOf(this.xmodelo_r.getValueAt(y, 4).toString()).doubleValue();
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }

    private void mCargarDatosGasto() {
        mCrearTablaGasto();
        this.xmodelogasto.addRow(this.xdato);
        this.xmodelogasto.setValueAt(this.xidauxiliar, this.xnfila, 0);
        this.xmodelogasto.setValueAt(this.xnauxiliar.substring(this.xidauxiliar.length() + 1, this.xnauxiliar.length()), this.xnfila, 1);
        this.xmodelogasto.setValueAt(Boolean.valueOf(this.xauxtipo), this.xnfila, 2);
        this.xmodelogasto.setValueAt(this.JTFFSubTotal.getValue(), this.xnfila, 3);
        this.JTFFTotalGasto.setValue(this.JTFFSubTotal.getValue());
        this.xmodelogasto.setValueAt(this.xidtercero, this.xnfila, 4);
        this.xmodelogasto.setValueAt(true, this.xnfila, 5);
        this.xnfila++;
        this.xmodelogasto.addRow(this.xdato);
        this.xmodelogasto.setValueAt(this.xidauxiliarpago, this.xnfila, 0);
        this.xmodelogasto.setValueAt(this.xnauxiliarpago.substring(this.xidauxiliarpago.length() + 1, this.xnauxiliarpago.length()), this.xnfila, 1);
        this.xmodelogasto.setValueAt(Boolean.valueOf(!this.xauxptipo), this.xnfila, 2);
        this.xmodelogasto.setValueAt(new Integer(0), this.xnfila, 3);
        this.xmodelogasto.setValueAt(this.xidtercero, this.xnfila, 4);
        this.xmodelogasto.setValueAt(true, this.xnfila, 5);
        this.JTFFTotalGasto.setValue(this.JTFFSubTotal.getValue());
        this.xnfila++;
    }

    private void mInicializarComponentes() {
        if (this.xobjetollamador.equals("jifradicacionfac")) {
            this.JTFEmpresa.setText(this.xjifradn.JCBEmpresa.getSelectedItem().toString());
            this.JTFFFlete.setValue(this.xjifradn.JTFFFlete.getValue());
            this.JTFFIva.setValue(this.xjifradn.JTFFIva.getValue());
            this.JTFFOtros.setValue(this.xjifradn.JTFFOtros.getValue());
            this.JTFFSubTotal.setValue(this.xjifradn.JTFFSubTotal.getValue());
            this.JTFFTotalFactura.setValue(this.xjifradn.JTFFTotalFactura.getValue());
            this.JTFFBaseIva.setValue(this.xjifradn.JTFFIva.getValue());
            this.xidtercero = this.xjifradn.xidempresa[this.xjifradn.JCBEmpresa.getSelectedIndex()][0];
            this.xperiodoc = this.xjifradn.xclases.getXidperiodoc();
            this.xconceptop = this.xjifradn.JTAConceptoC.getText();
            this.JTAObservacion.setText(this.xjifradn.JTAConceptoC.getText());
            this.xtipodoc = 1;
            this.xidauxiliarpago = this.xjifradn.xidauxiliarxpagar[this.xjifradn.JCBCuentaAuxiliarPagar.getSelectedIndex()][0];
            this.xnauxiliarpago = this.xjifradn.JCBCuentaAuxiliarPagar.getSelectedItem().toString();
            this.xauxptipo = Boolean.valueOf(this.xjifradn.xidauxiliarxpagar[this.xjifradn.JCBCuentaAuxiliarPagar.getSelectedIndex()][1]).booleanValue();
            this.xidauxiliar = this.xjifradn.xidauxiliar[this.xjifradn.JCBCuentaAuxiliar.getSelectedIndex()][0];
            this.xnauxiliar = this.xjifradn.JCBCuentaAuxiliar.getSelectedItem().toString();
            this.xauxtipo = Boolean.valueOf(this.xjifradn.xidauxiliar[this.xjifradn.JCBCuentaAuxiliar.getSelectedIndex()][1]).booleanValue();
            return;
        }
        if (this.xobjetollamador.equals("jifradicacionnc")) {
            this.JTFEmpresa.setText(this.xjifradnc.JCBEmpresa.getSelectedItem().toString());
            this.JTFFFlete.setValue(this.xjifradnc.JTFFFlete.getValue());
            this.JTFFIva.setValue(this.xjifradnc.JTFFIva.getValue());
            this.JTFFOtros.setValue(this.xjifradnc.JTFFOtros.getValue());
            this.JTFFSubTotal.setValue(this.xjifradnc.JTFFSubTotal.getValue());
            this.JTFFTotalFactura.setValue(this.xjifradnc.JTFFTotalFactura.getValue());
            this.JTFFBaseIva.setValue(this.xjifradnc.JTFFIva.getValue());
            this.xidtercero = this.xjifradnc.xidempresa[this.xjifradnc.JCBEmpresa.getSelectedIndex()][0];
            this.xperiodoc = Principal.xclase.getXidperiodoc();
            this.xconceptop = this.xjifradnc.JTAObservacion.getText();
            this.xtipodoc = 3;
            this.xidauxiliarpago = this.xjifradnc.xidauxiliarxpagar[this.xjifradnc.JCBCuentaAuxiliarPagar.getSelectedIndex()];
            this.xnauxiliarpago = this.xjifradnc.JCBCuentaAuxiliarPagar.getSelectedItem().toString();
            this.xidauxiliar = this.xjifradnc.xidauxiliar[this.xjifradnc.JCBCuentaAuxiliar.getSelectedIndex()];
            this.xnauxiliar = this.xjifradnc.JCBCuentaAuxiliar.getSelectedItem().toString();
        }
    }

    private void mNuevo_DPpt() {
        this.ppPeriodos = new ArrayList();
        this.ppTipoDocumentos = new ArrayList();
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        if (this.xobjetollamador.equals("jifradicacionnc")) {
            this.ppTipoDocumentos = this.iPpTipoDocumentosService.listaTipoDocumentosPorIdClaseDocumento(15);
        } else {
            this.ppTipoDocumentos = this.iPpTipoDocumentosService.listaTipoDocumentosPorIdClaseDocumento(5);
        }
        if (!this.ppTipoDocumentos.isEmpty()) {
            this.ppTipoDocumentos.forEach(item -> {
                this.JCBTipoDoc_Ppt.addItem(item.getNbre());
            });
            if (this.ppTipoDocumentos.size() > 1) {
                this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
            }
        }
        this.ppPeriodos = this.iPpPeriodoService.listaPeridodosPorEstadoCerrado(0);
        if (!this.ppPeriodos.isEmpty()) {
            this.ppPeriodos.forEach(item2 -> {
                this.JCBPeriodo_Ppt.addItem(item2.getNbre());
            });
            if (this.xjifradn != null && this.ppPeriodos.size() > 1) {
                this.JCBPeriodo_Ppt.setSelectedItem(this.xjifradn.xclases.getNombrePeriodo());
            }
        }
        mCrearTablaRubros();
    }

    private void mCargarLiqudiacion() {
        List<IGenericoDosValores> list;
        new ArrayList();
        if (this.xobjetollamador.equals("jifradicacionnc")) {
            list = this.iRadicacionService.listNotaRadicacionPorIdRadicacion(Long.valueOf(this.idRadicacion));
        } else if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            System.out.println("Compromiso " + this.xId_Compromiso);
            System.out.println("Radicacion " + Long.valueOf(this.idRadicacion));
            list = this.iRadicacionService.listDocumentoContablePorIdRadicacionIdCompromiso(Long.valueOf(this.idRadicacion), this.xId_Compromiso);
        } else {
            list = this.iRadicacionService.listDocumentoContablePorIdRadicacionIdClaseDocumento(Long.valueOf(this.idRadicacion), Integer.valueOf(this.xclasedoc));
        }
        if (!list.isEmpty()) {
            System.out.println("" + list.get(0).getIdDocumento());
            System.out.println("" + list.get(0).getIdMovimiento());
            System.out.println("" + list.get(0).getNumeroConsecutivo());
            System.out.println("" + list.size());
            if (list.get(0).getIdMovimiento() != null && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                list.forEach(item -> {
                    this.idObligacion.add(item.getNumeroConsecutivo());
                    this.idMovimientoObligacion.add(item.getIdMovimiento());
                });
                this.JTFFNDoc_Ppt.setText("" + this.idObligacion);
            }
            if (list.get(0).getIdDocumento() == null) {
                mCargarDatosInicial();
                return;
            } else {
                if (list.get(0).getIdDocumento().longValue() != 0) {
                    this.JLBNumero.setText("" + list.get(0).getIdDocumento());
                    this.JLBEstado.setText("Activa");
                    mCargarDatos();
                    return;
                }
                return;
            }
        }
        mCargarDatosInicial();
    }

    private void mCargarDatosInicial() {
        mCargarDatosImpuesto();
        mCargarDatosGasto();
        mCargarDatosRegimen();
        this.xlleno = true;
        mCalcularIva();
        mCalcularTotales();
    }

    private void mCargarDatos() {
        this.xlleno = false;
        try {
            mCrearTablaImpuesto();
            mCrearTablaGasto();
            String xsql = "SELECT\n    `cc_detalle_documentoc`.`Id_Documentoc`\n    , `cc_puc`.`Id` AS Id_Puc\n    , `cc_puc`.`Nbre`\n    , `cc_detalle_documentoc`.`PRetencion`\n    , `cc_detalle_documentoc`.`TipoCPuc`\n    , IF(`cc_detalle_documentoc`.`VDebito`<>0,`cc_detalle_documentoc`.`VDebito`, `cc_detalle_documentoc`.`VCredito`) AS Valor\n    , `cc_detalle_documentoc`.`Base`\n    , `cc_detalle_documentoc`.`Id_Tercero`\n    , `cc_tipo_impuesto`.`EsImpuestos`   \n    , IFNULL(c.Id,0) AS idvalortipoimpuesto \n    , IFNULL(c.idimpuesto,0) AS idimpuesto \n    , IFNULL(c.TipoV,0) AS TipoV \n    , IFNULL(c.ValorF,0) AS ValorF\n    , `cc_detalle_documentoc`.`Concepto`\nFROM\n    `cc_documentoc`\n    INNER JOIN `cc_detalle_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `cc_tipo_impuesto` \n        ON (`cc_puc`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`)\n    INNER JOIN `cc_tipo_documentoc` \n        ON (cc_tipo_documentoc.`Id`=cc_documentoc.`Id_TipoComprobante`)\n    LEFT JOIN(SELECT cc_impuestoxempresa.Id_Empresa, cc_impuestoxempresa.Estado, cc_impuestoxempresa.`Filtro`, cc_valorxtipo_impuesto.Id, cc_tipo_impuesto.Id AS idimpuesto, cc_valorxtipo_impuesto.TipoV, cc_valorxtipo_impuesto.ValorF\nFROM cc_impuestoxempresa \nINNER JOIN cc_valorxtipo_impuesto ON (cc_impuestoxempresa.Id_Impuesto = cc_valorxtipo_impuesto.Id) \nINNER JOIN cc_tipo_impuesto  ON (cc_valorxtipo_impuesto.Id_TipoImpuesto = cc_tipo_impuesto.Id) \nINNER JOIN cc_puc ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) \nORDER BY cc_tipo_impuesto.Nbre ASC, cc_puc.Nbre ASC ) c ON (c.Id_Empresa=`cc_detalle_documentoc`.`Id_Tercero` AND c.Estado=1 AND c.Filtro IN(-1,0))\n\nWHERE (`cc_detalle_documentoc`.`Id_Radicacion` ='" + this.idRadicacion + "' AND cc_tipo_documentoc.`IdClasificacion`='" + this.xclasedoc + "' AND cc_documentoc.`Estado`=1)\ngroup by `cc_puc`.`Id`\nORDER BY `cc_puc`.`Nbre` ASC;";
            System.out.println(xsql);
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                int i = 0;
                while (xrs.next()) {
                    this.JTAObservacion.setText(xrs.getString("Concepto"));
                    if (xrs.getInt("EsImpuestos") == 0) {
                        this.xmodelogasto.addRow(this.xdato);
                        this.xmodelogasto.setValueAt(Long.valueOf(xrs.getLong("Id_Puc")), n, 0);
                        this.xmodelogasto.setValueAt(xrs.getString("Nbre"), n, 1);
                        this.xmodelogasto.setValueAt(Boolean.valueOf(xrs.getBoolean("TipoCPuc")), n, 2);
                        this.xmodelogasto.setValueAt(Double.valueOf(xrs.getDouble("Valor")), n, 3);
                        this.xmodelogasto.setValueAt(Long.valueOf(xrs.getLong("Id_Tercero")), n, 4);
                        this.xmodelogasto.setValueAt(true, n, 5);
                        n++;
                    } else {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idvalortipoimpuesto")), i, 0);
                        this.xmodelo.setValueAt(xrs.getString("Nbre"), i, 1);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("PRetencion")), i, 2);
                        this.xmodelo.setValueAt(true, i, 3);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), i, 4);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idimpuesto")), i, 5);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("TipoV")), i, 6);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ValorF")), i, 7);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("TipoCPuc")), i, 8);
                        this.xmodelo.setValueAt(xrs.getString("Id_Puc"), i, 9);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Base")), i, 10);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Tercero")), i, 11);
                        i++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xlleno = true;
    }

    private void mRealizarCasting(JInternalFrame frm) {
        this.xId_Compromiso = new ArrayList();
        if (frm.getName().equals("jifradicacionnc")) {
            this.xjifradnc = (JIFRadicacionNC) frm;
            this.xobjetollamador = "jifradicacionnc";
            this.xId_Compromiso.add(Long.valueOf(this.xjifradnc.JLCodigoDoc1.getText()));
            this.xtipodoc = 3;
            this.xclasedoc = 5;
            return;
        }
        if (frm.getName().equals("jifradicacionfac")) {
            this.xjifradn = (JIFRadicacion) frm;
            if (this.radicacionCompromisos.isEmpty()) {
                this.xId_Compromiso.add(Long.valueOf(this.xjifradn.xIDCompromiso));
            } else {
                this.xjifradn.radicacionCompromisos.forEach(item -> {
                    this.xId_Compromiso.add(item.getIdMovimiento().getId());
                });
            }
            this.JTAObservacion.setText(this.xjifradn.JTAConceptoC.getText());
            this.xobjetollamador = "jifradicacionfac";
            this.xtipodoc = 1;
            this.xclasedoc = 2;
        }
    }

    private void mActualizar_Entrada_DocContable() {
        if (this.xobjetollamador.equals("jifradicacionfac")) {
            for (int x = 0; x < this.xjifradn.xvector.size(); x++) {
                String xsql = "update i_entradas set Id_DocContable='" + this.JLBNumero.getText() + "' where Id='" + this.xjifradn.xvector.get(x) + "'";
                this.xct.ejecutarSQL(xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    private void mGrabarUsuarioA() {
        String xsql;
        try {
            int xtipodocf = 1;
            if (this.xtipodoc == 3) {
                xtipodocf = 5;
            } else if (this.xtipodoc == 1 || this.xtipodoc == 21) {
                xtipodocf = 4;
            }
            String xsql2 = "SELECT cc_usuarioxdocumentof.Id, persona.Corre, cc_usuarioxdocumentof.Orden FROM persona INNER JOIN cc_usuarioxdocumentof ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) WHERE ( cc_usuarioxdocumentof.Id_TipoDocF ='" + xtipodocf + "' AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xct.traerRs(xsql2);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            ConsultasMySQL xct = new ConsultasMySQL();
                            if (rs.getInt("Orden") == 0) {
                                xsql = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF, Autorizo, FechaA, Observacion) values('" + this.JLBNumero.getText() + "','" + rs.getInt(1) + "',1,now(),'' )";
                            } else {
                                xsql = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF) values('" + this.JLBNumero.getText() + "','" + rs.getInt(1) + "')";
                            }
                            xct.ejecutarSQL(xsql);
                            xct.cerrarConexionBd();
                            if (rs.getRow() == 1) {
                                String xsql3 = "update cc_documentoc set EstadoA=1 where  Id='" + this.JLBNumero.getText() + "'";
                                this.xct.ejecutarSQL(xsql3);
                                this.xct.cerrarConexionBd();
                            }
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") && !rs.getString("Corre").equals("")) {
                                this.e.Send(rs.getString("Corre"), "Se ha generarado el siguiente documentos contable para su firma y/o aprobación\n\nDocumento No. " + this.JLBNumero.getText() + "\nTipo Documento : " + this.JCBTipoDoc_Cont.getSelectedItem() + "\nTercero : " + this.JTFEmpresa.getText() + "\nObservación : " + this.JTAObservacion.getText() + "\nValor : " + this.JTFFNeto.getValue(), "noresponder@clinicapajonal.com", "Generación Documento Contable No. " + this.JLBNumero.getText());
                            }
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean verificarSiYaEstaEnlaLista(Long valor, List<Long> listIdCompromiso) {
        return listIdCompromiso.stream().anyMatch(compromiso -> {
            return Objects.equals(compromiso, valor);
        });
    }

    private void actualizarObligacionPresupuestal() {
        int idMov = 0;
        String sql = "SELECT Id, Id_TipoDoc FROM `pp_movimiento` WHERE SUBSTRING('" + this.JTFFNDoc_Ppt.getText() + "', 2, LENGTH('" + this.JTFFNDoc_Ppt.getText() + "') - 2) = NoConcecutivo AND IdDocContable = '" + this.JLBNumero.getText() + "'\n AND Id_TipoDoc = 5";
        System.out.println("Consulta id del movimiento --- " + sql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                if (rs.getInt("Id_TipoDoc") == 5) {
                    idMov = rs.getInt("Id");
                    System.out.println("idMov ++++ " + idMov);
                } else {
                    System.out.println("¡No es obligacion presupuestal!");
                }
            }
            rs.close();
            xct.cerrarConexionBd();
            System.out.println("idMov ----- " + idMov);
            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `actualizarIdObligacion`('" + idMov + "')}");
            cs.execute();
            if (idMov > 0) {
                JOptionPane.showMessageDialog((Component) null, "Obligación actualizada con exito");
            } else {
                JOptionPane.showMessageDialog((Component) null, "Error al actualizar la obligación - ");
            }
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, "Error al actualizar la obligación");
        }
    }
}
