package Presupuesto;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.presupuesto.MovimientoDetalleDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDetalleDTO;
import com.genoma.plus.jpa.dto.SolicitudPresupuesto;
import com.genoma.plus.jpa.entities.CcUnidadFuncional;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.PpPeriodo;
import com.genoma.plus.jpa.entities.PpRubros;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosEncabezado;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.entities.PpSolicitudPto;
import com.genoma.plus.jpa.entities.PpSolicitudPtoDetalle;
import com.genoma.plus.jpa.entities.PpTipoVigencia;
import com.genoma.plus.jpa.entities.RhTipoPersonaCargon;
import com.genoma.plus.jpa.entities.TipoDocumentoContable;
import com.genoma.plus.jpa.projection.IPp_SaldoRubro;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.genoma.plus.jpa.service.IPpRubrosCentrocostosService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import com.genoma.plus.jpa.service.IPpRubrosFuenteFinanciacionService;
import com.genoma.plus.jpa.service.IPpRubrosService;
import com.genoma.plus.jpa.service.IPpSolicitudPtoService;
import com.genoma.plus.jpa.service.IPpTipoVigenciaService;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFSolicitudPresupuestal.class */
public class JIFFSolicitudPresupuestal extends JInternalFrame {
    public String[][] unidadFuncional;
    private JIFConsultarDatosV jifBuscaOrden;
    private long consecutivo;
    private String[][] idTipoDocumentoContable;
    private String[] idRubros;
    public DefaultTableModel modeloSolicitud;
    private Object[] datos;
    public PresupuestoDAO presupuestoDAO;
    private GEmpresa empresa;
    public PpRubrosCpc ppRubrosCpc;
    private PpRubrosEncabezado rubrosEncabezado;
    private PpSolicitudPto solicitud;
    private PpPeriodo ppPeriodo;
    public CcUnidadFuncional ccUnidadFuncional;
    private RhTipoPersonaCargon rhTipoPersonacargon;
    private TipoDocumentoContable tipoDocumentoContable;
    private PpRubros rubro;
    private SolicitudPresupuesto solicitudPresupuesto;
    private PpRubrosCentrocostos ppRubrosCentrocostos;
    private PpRubrosFuenteFinanciacion ppRubrosFuenteFinanciacion;
    private IPp_SaldoRubro iPpSaldoRubroSolicitud;
    private List<PpRubrosFuenteFinanciacion> listFuenteFinanciacion;
    private List<PpRubrosCentrocostos> listCentroCosto;
    private List<PpTipoVigencia> listTipoVigencia;
    private List<PpSolicitudPtoDetalle> listSolicitudDetalle;
    private final IPpRubrosCpcService iPpRubrosCpcService;
    private final IGEmpresaService iGEmpresaService;
    private final IPpRubrosCentrocostosService iPpRubrosCentrocostosService;
    private final IPpRubrosFuenteFinanciacionService iPpRubrosFuenteFinanciacionService;
    private final IPpTipoVigenciaService iPpTipoVigenciaService;
    private final IPpSolicitudPtoService iPpSolicitudPtoService;
    private final IPpRubrosService iPpRubrosService;
    public List<IPp_SaldoRubro> pp_SaldoRubro;
    private final IPpMovimientoService iPpMovimientoService;
    private JButton JBAdicionar;
    private JButton JBAjusteValor;
    private JButton JBT_BusquedaCPC;
    private JButton JBT_TerceroBusqueda;
    private JButton JBT_TerceroBusqueda1;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBFuenteFinanciacion;
    private JComboBox JCBTipoC;
    public JComboBox JCBUnidadF;
    private JComboBox JCBVIgencia;
    private JDateChooser JDFFechaC;
    public JLabel JLB_Registro;
    private JPanel JPIDatosP;
    private JPanel JPI_DetalleAdicional;
    private JPanel JPRubro;
    private JPanel JPTercero;
    private JPanel JPTipoR;
    private JRadioButton JRBBienes;
    private JRadioButton JRBServicios;
    public JTextArea JTAObservacionG;
    public JTable JTDetalle;
    public JTextField JTFCodigoCPC;
    public JTextField JTFCodigoRubro;
    public JFormattedTextField JTFFValorPpt;
    private JTextField JTFNombreCPC;
    public JTextField JTFNombreRubro;
    public JTextField JTFTerceroNDocumento;
    private JTextField JTFTerceroNombre;
    private JFormattedTextField JTFValor;
    private JFormattedTextField JTFValorSaldoRubro;
    private JTextField JTF_NComprobante;
    private JTabbedPane JTP_Detalle;
    private ButtonGroup buttonGroup1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos metodo = new Metodos();
    private ConsultasMySQL consultasMySql = new ConsultasMySQL();
    private int idTipoSolicitud = 0;
    private String idDisponibilidad = "";
    private List<Integer> vigenciaId = new ArrayList();
    private boolean lleno = false;
    private boolean llenoRubro = false;
    private int file = 0;

    public JIFFSolicitudPresupuestal() {
        initComponents();
        this.iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
        this.iPpRubrosCpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.iPpRubrosCentrocostosService = (IPpRubrosCentrocostosService) Principal.contexto.getBean(IPpRubrosCentrocostosService.class);
        this.iPpRubrosFuenteFinanciacionService = (IPpRubrosFuenteFinanciacionService) Principal.contexto.getBean(IPpRubrosFuenteFinanciacionService.class);
        this.iPpTipoVigenciaService = (IPpTipoVigenciaService) Principal.contexto.getBean(IPpTipoVigenciaService.class);
        this.iPpSolicitudPtoService = (IPpSolicitudPtoService) Principal.contexto.getBean(IPpSolicitudPtoService.class);
        this.iPpRubrosService = (IPpRubrosService) Principal.contexto.getBean(IPpRubrosService.class);
        this.rubrosEncabezado = new PpRubrosEncabezado();
        this.rubrosEncabezado.setId(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()));
        this.ppPeriodo = new PpPeriodo();
        this.ppPeriodo.setId(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()));
        this.iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        springStart();
        crearModeloSolicitud();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JTFFValorPpt = new JFormattedTextField();
        this.JPTipoR = new JPanel();
        this.JRBBienes = new JRadioButton();
        this.JRBServicios = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JCBTipoC = new JComboBox();
        this.JTF_NComprobante = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBAjusteValor = new JButton();
        this.JLB_Registro = new JLabel();
        this.JTP_Detalle = new JTabbedPane();
        this.JPRubro = new JPanel();
        this.JTFCodigoRubro = new JTextField();
        this.JTFValor = new JFormattedTextField();
        this.JTFValorSaldoRubro = new JFormattedTextField();
        this.JTFNombreRubro = new JTextField();
        this.JBT_TerceroBusqueda1 = new JButton();
        this.JPTercero = new JPanel();
        this.JTFTerceroNDocumento = new JTextField();
        this.JTFTerceroNombre = new JTextField();
        this.JBT_TerceroBusqueda = new JButton();
        this.JPI_DetalleAdicional = new JPanel();
        this.JCBFuenteFinanciacion = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JTFCodigoCPC = new JTextField();
        this.JTFNombreCPC = new JTextField();
        this.JBT_BusquedaCPC = new JButton();
        this.JBAdicionar = new JButton();
        this.JCBVIgencia = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SOLICITUD PRESUPUESTO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsolicitud_new");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFSolicitudPresupuestal.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPresupuestal.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JTFFValorPpt.setEditable(false);
        this.JTFFValorPpt.setBorder(BorderFactory.createTitledBorder((Border) null, "Presupuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPpt.setHorizontalAlignment(0);
        this.JTFFValorPpt.setText("0");
        this.JTFFValorPpt.setToolTipText("Presupuesto aproximando");
        this.JTFFValorPpt.setFont(new Font("Arial", 1, 12));
        this.JPTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.JRBBienes);
        this.JRBBienes.setFont(new Font("Arial", 1, 12));
        this.JRBBienes.setSelected(true);
        this.JRBBienes.setText("Bienes");
        this.JRBBienes.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.3
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JRBBienesActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBServicios);
        this.JRBServicios.setFont(new Font("Arial", 1, 12));
        this.JRBServicios.setText("Servicio");
        this.JRBServicios.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.4
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JRBServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPTipoRLayout = new GroupLayout(this.JPTipoR);
        this.JPTipoR.setLayout(JPTipoRLayout);
        JPTipoRLayout.setHorizontalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addComponent(this.JRBBienes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBServicios, -1, 99, 32767).addContainerGap()));
        JPTipoRLayout.setVerticalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBServicios).addComponent(this.JRBBienes)).addContainerGap(-1, 32767)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setToolTipText("Digite la descripción de la solicitud");
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacionG);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.5
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPresupuestal.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JCBTipoC.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPresupuestal.6
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPresupuestal.this.JCBTipoCKeyPressed(evt);
            }
        });
        this.JTF_NComprobante.setEditable(false);
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setForeground(new Color(0, 102, 0));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFSolicitudPresupuestal.7
            public void mouseClicked(MouseEvent evt) {
                JIFFSolicitudPresupuestal.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBAjusteValor.setFont(new Font("Arial", 1, 12));
        this.JBAjusteValor.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tarifas.png")));
        this.JBAjusteValor.setText("Ajuste Valores");
        this.JBAjusteValor.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.8
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JBAjusteValorActionPerformed(evt);
            }
        });
        this.JLB_Registro.setFont(new Font("Arial", 1, 18));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero de Solicitud", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DETALLE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTP_Detalle.setForeground(new Color(255, 0, 0));
        this.JTP_Detalle.setFont(new Font("Arial", 1, 14));
        this.JPRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigoRubro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRubro.setToolTipText("");
        this.JTFCodigoRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRubro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFSolicitudPresupuestal.9
            public void focusLost(FocusEvent evt) {
                JIFFSolicitudPresupuestal.this.JTFCodigoRubroFocusLost(evt);
            }
        });
        this.JTFCodigoRubro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.10
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JTFCodigoRubroActionPerformed(evt);
            }
        });
        this.JTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor a Ingresar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFValor.setHorizontalAlignment(0);
        this.JTFValor.setFont(new Font("Arial", 1, 12));
        this.JTFValorSaldoRubro.setEditable(false);
        this.JTFValorSaldoRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo Rubro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFValorSaldoRubro.setForeground(Color.red);
        this.JTFValorSaldoRubro.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFValorSaldoRubro.setHorizontalAlignment(0);
        this.JTFValorSaldoRubro.setText("0");
        this.JTFValorSaldoRubro.setFont(new Font("Arial", 1, 14));
        this.JTFNombreRubro.setFont(new Font("Arial", 1, 12));
        this.JTFNombreRubro.setToolTipText("");
        this.JTFNombreRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_TerceroBusqueda1.setFont(new Font("Arial", 1, 12));
        this.JBT_TerceroBusqueda1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBT_TerceroBusqueda1.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.11
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JBT_TerceroBusqueda1ActionPerformed(evt);
            }
        });
        GroupLayout JPRubroLayout = new GroupLayout(this.JPRubro);
        this.JPRubro.setLayout(JPRubroLayout);
        JPRubroLayout.setHorizontalGroup(JPRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRubroLayout.createSequentialGroup().addContainerGap().addGroup(JPRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPRubroLayout.createSequentialGroup().addComponent(this.JTFCodigoRubro, -2, 319, -2).addGap(33, 33, 33).addComponent(this.JTFValor, -2, 293, -2).addGap(26, 26, 26).addComponent(this.JTFValorSaldoRubro, -2, 259, -2)).addGroup(JPRubroLayout.createSequentialGroup().addComponent(this.JTFNombreRubro, -2, 761, -2).addGap(18, 18, 18).addComponent(this.JBT_TerceroBusqueda1, -1, -1, 32767))).addContainerGap(21, 32767)));
        JPRubroLayout.setVerticalGroup(JPRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRubroLayout.createSequentialGroup().addGroup(JPRubroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoRubro, -2, 53, -2).addComponent(this.JTFValor, -2, 52, -2).addComponent(this.JTFValorSaldoRubro, -2, 52, -2)).addGap(18, 18, 18).addGroup(JPRubroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombreRubro, -2, 50, -2).addComponent(this.JBT_TerceroBusqueda1, -2, 53, -2)).addContainerGap()));
        this.JTP_Detalle.addTab("RUBROS", this.JPRubro);
        this.JTFTerceroNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFTerceroNDocumento.setToolTipText("");
        this.JTFTerceroNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTerceroNDocumento.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPresupuestal.12
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPresupuestal.this.JTFTerceroNDocumentoKeyPressed(evt);
            }
        });
        this.JTFTerceroNombre.setFont(new Font("Arial", 1, 12));
        this.JTFTerceroNombre.setToolTipText("");
        this.JTFTerceroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_TerceroBusqueda.setFont(new Font("Arial", 1, 12));
        this.JBT_TerceroBusqueda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBT_TerceroBusqueda.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.13
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JBT_TerceroBusquedaActionPerformed(evt);
            }
        });
        GroupLayout JPTerceroLayout = new GroupLayout(this.JPTercero);
        this.JPTercero.setLayout(JPTerceroLayout);
        JPTerceroLayout.setHorizontalGroup(JPTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerceroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFTerceroNDocumento, -1, 147, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFTerceroNombre, -2, 713, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_TerceroBusqueda, -2, 77, -2).addContainerGap()));
        JPTerceroLayout.setVerticalGroup(JPTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerceroLayout.createSequentialGroup().addGap(49, 49, 49).addGroup(JPTerceroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_TerceroBusqueda, -2, 53, -2).addGroup(JPTerceroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTerceroNDocumento, -2, 50, -2).addComponent(this.JTFTerceroNombre, -2, 50, -2))).addContainerGap(57, 32767)));
        this.JTP_Detalle.addTab("TERCERO", this.JPTercero);
        this.JCBFuenteFinanciacion.setFont(new Font("Arial", 1, 12));
        this.JCBFuenteFinanciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fuente Financiación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCPC.setToolTipText("");
        this.JTFCodigoCPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Código CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPresupuestal.14
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPresupuestal.this.JTFCodigoCPCKeyPressed(evt);
            }
        });
        this.JTFNombreCPC.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCPC.setToolTipText("");
        this.JTFNombreCPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_BusquedaCPC.setFont(new Font("Arial", 1, 12));
        this.JBT_BusquedaCPC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBT_BusquedaCPC.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.15
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JBT_BusquedaCPCActionPerformed(evt);
            }
        });
        GroupLayout JPI_DetalleAdicionalLayout = new GroupLayout(this.JPI_DetalleAdicional);
        this.JPI_DetalleAdicional.setLayout(JPI_DetalleAdicionalLayout);
        JPI_DetalleAdicionalLayout.setHorizontalGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addComponent(this.JCBFuenteFinanciacion, -2, 214, -2).addGap(18, 18, 18).addComponent(this.JCBCentroCosto, -2, 424, -2)).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addComponent(this.JTFCodigoCPC, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreCPC, -2, 707, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_BusquedaCPC, -2, 83, -2))).addContainerGap(21, 32767)));
        JPI_DetalleAdicionalLayout.setVerticalGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFuenteFinanciacion, -2, 52, -2).addComponent(this.JCBCentroCosto, -2, 52, -2)).addGap(18, 18, 18).addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoCPC, -2, 53, -2).addComponent(this.JTFNombreCPC, -2, 53, -2)).addComponent(this.JBT_BusquedaCPC, -1, -1, 32767)).addContainerGap(20, 32767)));
        this.JTP_Detalle.addTab("ADICIONAL", this.JPI_DetalleAdicional);
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.16
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPresupuestal.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JCBVIgencia.setFont(new Font("Arial", 1, 12));
        this.JCBVIgencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Vigencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBVIgencia.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPresupuestal.17
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPresupuestal.this.JCBVIgenciaItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoR, -2, -1, -2)).addComponent(this.JCBTipoC, -2, 220, -2)).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBVIgencia, -2, 272, -2).addComponent(this.JCBUnidadF, -2, 405, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorPpt).addComponent(this.JTF_NComprobante, -2, 171, -2))))).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2)).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Detalle).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JBAjusteValor, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_Registro, -2, 176, -2)).addComponent(this.JBAdicionar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPTipoR, -1, -1, 32767).addComponent(this.JCBUnidadF).addComponent(this.JTFFValorPpt)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTF_NComprobante, -2, 50, -2)).addComponent(this.JCBVIgencia, -2, 52, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 71, -2).addGap(18, 18, 18).addComponent(this.JTP_Detalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -2, 39, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAjusteValor, -2, 61, -2).addComponent(this.JLB_Registro, -2, 61, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPIDatosP, -1, -1, 32767).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatosP, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
    }

    private void springStart() {
        this.presupuestoDAO = (PresupuestoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("presupuestoDAOImpl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBienesActionPerformed(ActionEvent evt) {
        this.idTipoSolicitud = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServiciosActionPerformed(ActionEvent evt) {
        this.idTipoSolicitud = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (!this.lleno || this.JCBTipoC.getSelectedIndex() == -1 || this.JCBVIgencia.getSelectedIndex() == -1 || this.JLB_Registro.getText().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoC.transferFocus();
        }
    }

    public double saldoRubro(String idRubro) {
        this.iPpSaldoRubroSolicitud = this.iPpSolicitudPtoService.getSaldoRubro(idRubro, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
        double valor = this.iPpSaldoRubroSolicitud.getValorSaldoDisponible().doubleValue();
        return valor;
    }

    private void adicionarDetalle() {
        if (this.JLB_Registro.getText().isEmpty()) {
            if (this.JTFCodigoRubro.getText() == null) {
                showMessage("Debe seleccionar un rubro", 0, this.JTFCodigoRubro);
                return;
            }
            if (this.JTFValor.getText() == null || Double.parseDouble(this.JTFValor.getValue().toString()) <= 0.0d) {
                showMessage("Valor no puede ser nulo y debe ser mayor a cero", 0, this.JTFValor);
                return;
            }
            if (Double.valueOf(this.JTFValorSaldoRubro.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFValor.getValue().toString()).doubleValue()) {
                showMessage("El valor a ingresar no puede ser mayor al saldo del rubro", 0, this.JTFValor);
                return;
            }
            if (this.JCBCentroCosto.getSelectedIndex() == -1) {
                showMessage("Debe seleccionar un centro de costo", 2, this.JCBCentroCosto);
                return;
            }
            if (this.JCBVIgencia.getSelectedIndex() == -1) {
                showMessage("Debe seleccionar la vigencia", 2, this.JCBVIgencia);
                return;
            }
            if (this.JCBFuenteFinanciacion.getSelectedIndex() == -1) {
                showMessage("Debe seleccionar la fuente de financiación", 2, this.JCBFuenteFinanciacion);
                return;
            }
            if (this.ppRubrosCpc == null || this.ppRubrosCpc.getId() == null) {
                showMessage("Debe seleccionar un codigo de cpc", 2, this.JTFCodigoCPC);
                return;
            }
            if (this.JTFTerceroNDocumento == null || this.JTFTerceroNDocumento.getText().isEmpty() || this.JTFTerceroNombre == null || this.JTFTerceroNombre.getText().isEmpty()) {
                int response = JOptionPane.showConfirmDialog(this, "El tercero está vacío. ¿Desea usar el tercero por defecto?", "Confirmar", 0);
                if (response == 0) {
                    this.empresa = this.iGEmpresaService.getGEmpresaById(Principal.informacionIps.getIdEmpresa());
                } else {
                    showMessage("Tercero no puede ser nulo", 1, this.JTFTerceroNDocumento);
                    return;
                }
            }
            PpSolicitudPtoDetalle psd = PpSolicitudPtoDetalle.builder().idmovimiento(this.solicitud).idEncabezado(this.rubrosEncabezado).idrubro(this.rubro).idTercero(this.empresa).idRubrosCentroCostos(this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex())).idRubrosFuenteFinanciacion(this.listFuenteFinanciacion.get(this.JCBFuenteFinanciacion.getSelectedIndex())).idRubrosCpc(this.ppRubrosCpc).idTipoVigencia(this.listTipoVigencia.get(this.JCBVIgencia.getSelectedIndex())).valor(Double.valueOf(this.JTFValor.getValue().toString())).estado(true).build();
            this.listSolicitudDetalle.add(psd);
            cargarDatosDetalle();
            limpia();
        }
    }

    private void showMessage(String message, int tabIndex, JComponent focusComponent) {
        JOptionPane.showInternalMessageDialog(this, message, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTP_Detalle.setSelectedIndex(tabIndex);
        focusComponent.requestFocus();
    }

    private void totaliza() {
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            total += Double.valueOf(this.modeloSolicitud.getValueAt(i, 8).toString()).doubleValue();
        }
        this.JTFFValorPpt.setValue(Double.valueOf(total));
    }

    private void limpia() {
        this.JTFCodigoRubro.setText("");
        this.JTFValor.setValue(0);
        this.JTFValorSaldoRubro.setValue(0);
        this.JTFTerceroNDocumento.setText("");
        this.JTFTerceroNombre.setText("");
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
        this.JTFCodigoCPC.setText("");
        this.JTFNombreCPC.setText("");
        this.JTFNombreRubro.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSolicitud() {
        this.modeloSolicitud = new DefaultTableModel(new Object[0], new String[]{"Codigo Rubro", "Nombre Rubro", "Tercero", "Centro de Costo", "Fuente Financiación", "Codigo Rubro Cpc", "Rubro Cpc", "Vigencia", "Valor", "Estado"}) { // from class: Presupuesto.JIFFSolicitudPresupuestal.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloSolicitud);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAjusteValorActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            JDAjusteSolicitudPresupuestal x = new JDAjusteSolicitudPresupuestal(null, true, this, this.solicitud.getId());
            x.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "No hay solicitud cargada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        adicionarDetalle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRubroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRubroFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoRubro.getText().isEmpty()) {
            mVerificarRubro();
            cargarInformacionRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroNDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarInformacionTercero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_TerceroBusquedaActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("tercero");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCPCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarInformacionCodigoCpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_BusquedaCPCActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("CodigoCpc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_TerceroBusqueda1ActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("Rubro");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBVIgenciaItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.JCBTipoC.getSelectedIndex() != -1 && this.JCBVIgencia.getSelectedIndex() != -1 && this.JLB_Registro.getText().isEmpty()) {
            mConcecutivo();
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) AS MaximoCons FROM pp_solicitud_pto so inner join pp_solicitud_pto_detalle sd on so.id=sd.idMovimiento \nWHERE (so.`idTipoDocumento` ='" + this.idTipoDocumentoContable[this.JCBTipoC.getSelectedIndex()][0] + "'  AND sd.id_TipoVigencia = '" + this.vigenciaId.get(this.JCBVIgencia.getSelectedIndex()) + "' and so.`Estado` =1 AND DATE_FORMAT(so.`FechaR`, '%Y')=" + this.metodo.formatoANO.format(this.JDFFechaC.getDate()) + ")";
        System.out.println("sql -> " + sql);
        ConsultasMySQL consultasMySql1 = new ConsultasMySQL();
        ResultSet consulta1 = consultasMySql1.traerRs(sql);
        try {
            if (consulta1.next()) {
                consulta1.first();
                Con = consulta1.getInt("MaximoCons");
            }
            consulta1.close();
            consultasMySql1.cerrarConexionBd();
            int opcion = JOptionPane.showConfirmDialog((Component) null, "¿Desea añadir el consecutivo de forma manual?", "Confirmar acción", 0);
            if (opcion == 0) {
                String inputConsecutivo = JOptionPane.showInputDialog((Component) null, "Ingrese el consecutivo manual:");
                if (inputConsecutivo != null && !inputConsecutivo.isEmpty()) {
                    try {
                        Con = Integer.parseInt(inputConsecutivo);
                        this.JTF_NComprobante.setText("" + Con);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog((Component) null, "El valor ingresado no es un número válido.", "Error", 0);
                    }
                }
            } else {
                this.JTF_NComprobante.setText("" + (Con + 1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPresupuestal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.consecutivo = Con + 1;
    }

    public void mNuevo() {
        this.solicitudPresupuesto = new SolicitudPresupuesto();
        this.solicitud = new PpSolicitudPto();
        this.solicitudPresupuesto.setSolicitudPto(this.solicitud);
        this.listSolicitudDetalle = new ArrayList();
        this.JTFTerceroNombre.setText("");
        this.JTFNombreCPC.setText("");
        this.JTFCodigoCPC.setText("");
        this.JCBVIgencia.setSelectedIndex(-1);
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
        this.JTFTerceroNDocumento.setText("");
        this.JTFValorSaldoRubro.setText("0");
        this.JTFCodigoRubro.setText("");
        this.JTF_NComprobante.setText("");
        this.JLB_Registro.setText("");
        this.JTFFValorPpt.setValue(0);
        this.lleno = false;
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.metodo.getFechaActual());
        this.JCBUnidadF.removeAllItems();
        this.empresa = this.iGEmpresaService.getGEmpresaById(Principal.informacionIps.getIdEmpresa());
        System.out.println("UF-->SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, '' Correo,0 Id_Persona FROM cc_unidad_funcional   WHERE cc_unidad_funcional.Estado=1");
        this.unidadFuncional = this.consultasMySql.llenarComboyLista("SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, '' Correo,0 Id_Persona FROM cc_unidad_funcional   WHERE cc_unidad_funcional.Estado=1", this.unidadFuncional, this.JCBUnidadF, 4);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTipoC.removeAllItems();
        this.idTipoDocumentoContable = this.consultasMySql.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1 and EsContable=2) ORDER BY Nbre ASC", this.idTipoDocumentoContable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.consultasMySql.cerrarConexionBd();
        this.JRBBienes.setSelected(true);
        this.idTipoSolicitud = 0;
        this.JTFFValorPpt.setValue(0);
        this.JTAObservacionG.setText("");
        this.lleno = true;
        crearModeloSolicitud();
        this.JTFValor.setValue(0);
        this.JTFValorSaldoRubro.setValue(0);
        this.file = 0;
        this.JTFNombreRubro.setText("");
        this.JCBCentroCosto.removeAllItems();
        this.listCentroCosto = new ArrayList();
        this.listCentroCosto = this.iPpRubrosCentrocostosService.getListPpRubrosCentrocostosOrderByNombreAsc();
        this.listCentroCosto.forEach(e -> {
            this.JCBCentroCosto.addItem(e.getNombre());
        });
        this.JCBFuenteFinanciacion.removeAllItems();
        this.listFuenteFinanciacion = new ArrayList();
        this.listFuenteFinanciacion = this.iPpRubrosFuenteFinanciacionService.getListPpRubrosFuenteFinanciacionOrderByNombreAsc();
        this.listFuenteFinanciacion.forEach(e2 -> {
            this.JCBFuenteFinanciacion.addItem(e2.getNombre());
        });
        this.JCBVIgencia.removeAllItems();
        this.listTipoVigencia = new ArrayList();
        this.listTipoVigencia = this.iPpTipoVigenciaService.getListIPpTipoVigenciaOrderByNombreAsc();
        new int[1][0] = 0;
        this.listTipoVigencia.forEach(e3 -> {
            this.JCBVIgencia.addItem(e3.getNombre());
            this.vigenciaId.add(e3.getId());
        });
        this.JCBVIgencia.setSelectedIndex(-1);
    }

    public void mGrabar() {
        boolean idSolicitud;
        if (this.metodo.mVerificaFecha_PeriodoPresupuesto(this.metodo.formatoAMD.format(this.JDFFechaC.getDate()))) {
            if (this.JCBUnidadF.getSelectedIndex() > -1) {
                if (this.JCBTipoC.getSelectedIndex() <= -1) {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoC.requestFocus();
                    return;
                }
                if (Double.parseDouble(this.JTFFValorPpt.getValue().toString()) > 0.0d) {
                    if (!this.JTAObservacionG.getText().isEmpty()) {
                        if (this.JTDetalle.getRowCount() > 0) {
                            if (this.JLB_Registro.getText().isEmpty()) {
                                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x == 0) {
                                    if (this.JRBBienes.isSelected()) {
                                        idSolicitud = false;
                                    } else {
                                        idSolicitud = true;
                                    }
                                    this.ccUnidadFuncional = new CcUnidadFuncional();
                                    this.rhTipoPersonacargon = new RhTipoPersonaCargon();
                                    this.tipoDocumentoContable = new TipoDocumentoContable();
                                    this.tipoDocumentoContable.setId(Integer.valueOf(this.idTipoDocumentoContable[this.JCBTipoC.getSelectedIndex()][0]));
                                    this.rhTipoPersonacargon.setId(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                    this.ccUnidadFuncional.setId(Integer.valueOf(this.unidadFuncional[this.JCBUnidadF.getSelectedIndex()][0]));
                                    this.solicitud.setIdUsuarioCargon(this.rhTipoPersonacargon);
                                    this.solicitud.setIdTipoDocumento(this.tipoDocumentoContable);
                                    this.solicitud.setFechaR(this.JDFFechaC.getDate());
                                    this.solicitud.setDescripcion(this.JTAObservacionG.getText());
                                    this.solicitud.setIdMovimiento(0L);
                                    this.solicitud.setValor(Double.valueOf(this.JTFFValorPpt.getValue().toString()));
                                    this.solicitud.setTiposolicitud(Boolean.valueOf(idSolicitud));
                                    this.solicitud.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                                    this.solicitud.setNconsecutivo(Integer.valueOf(this.JTF_NComprobante.getText()));
                                    this.solicitud.setIdunidadfuncional(this.ccUnidadFuncional);
                                    this.solicitud.setIdPeriodo(this.ppPeriodo);
                                    this.solicitud.setFecha(this.metodo.getFechaActual());
                                    this.solicitud.setEstado(true);
                                    this.solicitud = this.iPpSolicitudPtoService.save(this.solicitud);
                                    String idSolicitudDetalle = String.valueOf(this.solicitud.getId());
                                    this.JLB_Registro.setText(idSolicitudDetalle);
                                    return;
                                }
                                return;
                            }
                            List<Object[]> disponibilidad = this.presupuestoDAO.getDisponibilidad(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                            System.out.println("dis.size()-->" + disponibilidad.size());
                            if (disponibilidad.size() > 0) {
                                List<Object[]> compromiso = this.presupuestoDAO.getCompromiso(Integer.valueOf(disponibilidad.get(0)[0].toString()).intValue());
                                this.presupuestoDAO.actualizarDetalleEncabezadoMovimiento(Long.valueOf(disponibilidad.get(0)[0].toString()), this.JTAObservacionG.getText());
                                if (compromiso.size() > 0) {
                                    this.presupuestoDAO.actualizarDetalleEncabezadoMovimiento(Long.valueOf(compromiso.get(0)[0].toString()), this.JTAObservacionG.getText());
                                    List<Object[]> obligacion = this.presupuestoDAO.getObligacion(Integer.valueOf(compromiso.get(0)[0].toString()).intValue());
                                    if (obligacion.size() > 0) {
                                        System.out.println("hay obligaciones obli.size()-->" + obligacion.size());
                                        JOptionPane.showInternalMessageDialog(this, "No puede agregar rubros a la solicitud por que hay obligaciones registradas", "ERROR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta solicitud tiene movimientos presupuesales asociados, esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x2 == 0) {
                                        this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.unidadFuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                                        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                            if (this.modeloSolicitud.getValueAt(i, 0).toString().isEmpty()) {
                                                SolicitudDetalleDTO sd = new SolicitudDetalleDTO();
                                                sd.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                                sd.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                                sd.setIdrubro(this.modeloSolicitud.getValueAt(i, 1).toString());
                                                sd.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i, 3).toString()).doubleValue());
                                                this.presupuestoDAO.guardaSolicitudDetalle(sd);
                                                if (disponibilidad.size() > 0) {
                                                    System.out.println("Guarda detalle disponibilidad");
                                                    MovimientoDetalleDTO md = new MovimientoDetalleDTO();
                                                    md.setIdEncabezado(Integer.valueOf(disponibilidad.get(0)[2].toString()).intValue());
                                                    md.setId_Movimiento(Integer.valueOf(disponibilidad.get(0)[0].toString()).intValue());
                                                    md.setId_Rubro(this.modeloSolicitud.getValueAt(i, 1).toString());
                                                    md.setId_Tercero(Integer.valueOf(disponibilidad.get(0)[3].toString()).intValue());
                                                    md.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i, 3).toString()).doubleValue());
                                                    this.presupuestoDAO.guardaDetalleMovimiento(md);
                                                }
                                                if (compromiso.size() > 0) {
                                                    System.out.println("Guarda detalle compromiso");
                                                    MovimientoDetalleDTO md2 = new MovimientoDetalleDTO();
                                                    md2.setIdEncabezado(Integer.valueOf(compromiso.get(0)[2].toString()).intValue());
                                                    md2.setId_Movimiento(Integer.valueOf(compromiso.get(0)[0].toString()).intValue());
                                                    md2.setId_Rubro(this.modeloSolicitud.getValueAt(i, 1).toString());
                                                    md2.setId_Tercero(Integer.valueOf(compromiso.get(0)[3].toString()).intValue());
                                                    md2.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i, 3).toString()).doubleValue());
                                                    this.presupuestoDAO.guardaDetalleMovimiento(md2);
                                                }
                                            }
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    return;
                                }
                                System.out.println("No tiene compromiso");
                                int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar la solicitud?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x3 == 0) {
                                    this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.unidadFuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                                    for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                        if (this.modeloSolicitud.getValueAt(i2, 0).toString().isEmpty()) {
                                            SolicitudDetalleDTO sd2 = new SolicitudDetalleDTO();
                                            sd2.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                            sd2.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                            sd2.setIdrubro(this.modeloSolicitud.getValueAt(i2, 1).toString());
                                            sd2.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i2, 3).toString()).doubleValue());
                                            this.presupuestoDAO.guardaSolicitudDetalle(sd2);
                                            if (disponibilidad.size() > 0) {
                                                System.out.println("Guarda detalle disponibilidad");
                                                MovimientoDetalleDTO md3 = new MovimientoDetalleDTO();
                                                md3.setIdEncabezado(Integer.valueOf(disponibilidad.get(0)[2].toString()).intValue());
                                                md3.setId_Movimiento(Integer.valueOf(disponibilidad.get(0)[0].toString()).intValue());
                                                md3.setId_Rubro(this.modeloSolicitud.getValueAt(i2, 1).toString());
                                                md3.setId_Tercero(Integer.valueOf(disponibilidad.get(0)[3].toString()).intValue());
                                                md3.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i2, 3).toString()).doubleValue());
                                                this.presupuestoDAO.guardaDetalleMovimiento(md3);
                                            }
                                        }
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                return;
                            }
                            System.out.println("No tiene disponibilidad");
                            int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar la solicitud?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x4 == 0) {
                                this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.unidadFuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                                for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                    if (this.modeloSolicitud.getValueAt(i3, 0).toString().isEmpty()) {
                                        SolicitudDetalleDTO sd3 = new SolicitudDetalleDTO();
                                        sd3.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                        sd3.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                        sd3.setIdrubro(this.modeloSolicitud.getValueAt(i3, 1).toString());
                                        sd3.setValor(Double.valueOf(this.modeloSolicitud.getValueAt(i3, 3).toString()).doubleValue());
                                        this.presupuestoDAO.guardaSolicitudDetalle(sd3);
                                    }
                                }
                                JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTAObservacionG.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar el Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAObservacionG.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El Valor debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValorPpt.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadF.requestFocus();
        }
    }

    public void mBuscar() {
        this.jifBuscaOrden = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.jifBuscaOrden);
    }

    public void mImprimir() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.JLB_Registro.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.metodo.getSO() + this.metodo.getBarra() + "Reportes" + this.metodo.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.metodo.getSO() + this.metodo.getBarra() + "Firmas" + this.metodo.getBarra();
            mparametros[4][0] = "idEncabezadoRubro";
            mparametros[4][1] = Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro();
            this.metodo.GenerarPDF(this.metodo.getRutaRep() + "PP_SolicutudServ_Rubros", mparametros);
        }
    }

    public void mConsultaSolicitud() {
        String sql = "SELECT\nso.`Id`\n, so.`FechaR`\n, uf.`Nbre` AS UF \n, so.tiposolicitud TipoR\n, so.Descripcion as  ObservacionG\n, so.valor VPresupuestado\n, so.IdMovimiento  IdDisponibilidad  , so.`NConsecutivo` , tdc.Nbre AS TipoDoc\nFROM pp_solicitud_pto so\nINNER JOIN  `cc_unidad_funcional` uf  ON (so.idunidadfuncional = uf.`Id`) \nINNER JOIN `cc_tipo_documentoc` tdc ON tdc.`Id`=so.`idTipoDocumento`\nWHERE (so.`Id` =" + this.JLB_Registro.getText() + ");";
        System.out.println("mConsultaSolicitud: " + sql);
        ResultSet consulta = this.consultasMySql.traerRs(sql);
        try {
            if (consulta.next()) {
                consulta.first();
                this.JDFFechaC.setDate(consulta.getDate("FechaR"));
                this.idDisponibilidad = consulta.getString("IdDisponibilidad");
                this.JCBUnidadF.setSelectedItem(consulta.getString("UF"));
                if (consulta.getString("TipoR").equals("0")) {
                    this.JRBBienes.setSelected(true);
                    this.idTipoSolicitud = 0;
                } else {
                    this.JRBServicios.setSelected(true);
                    this.idTipoSolicitud = 1;
                }
                this.JTFFValorPpt.setValue(Double.valueOf(consulta.getDouble("VPresupuestado")));
                this.JTAObservacionG.setText(consulta.getString("ObservacionG"));
                this.JCBTipoC.setSelectedItem(consulta.getString("TipoDoc"));
                this.JTF_NComprobante.setText(consulta.getString("NConsecutivo"));
                buscarSolicitudes(consulta.getInt("id"));
            }
            consulta.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPresupuestal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void buscarSolicitudes(int idSolicitud) {
        crearModeloSolicitud();
        this.file = 0;
        List<Object[]> listSolicitudDetalle = this.presupuestoDAO.getListSolicitudDetalle(idSolicitud, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
        if (listSolicitudDetalle.size() > 0) {
            for (int i = 0; i < listSolicitudDetalle.size(); i++) {
                this.modeloSolicitud.addRow(this.datos);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[0], this.file, 0);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[1], this.file, 1);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[2], this.file, 2);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[3], this.file, 3);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[4], this.file, 4);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[5], this.file, 5);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[6], this.file, 6);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[7], this.file, 7);
                this.modeloSolicitud.setValueAt(listSolicitudDetalle.get(i)[8], this.file, 8);
                this.modeloSolicitud.setValueAt(true, this.file, 9);
                this.file++;
            }
        }
        totaliza();
    }

    public void mAnular() {
        System.out.println("");
        if (!this.JLB_Registro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jifsolicitud_new", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularSolicitudPTOV2(xIdMot, xObservacion, this.JLB_Registro.getText());
        Principal.txtEstado.setText("ANULADO");
        System.err.println(Principal.txtEstado.getText());
    }

    private void cargarDialogoBusqueda(String nombre) {
        JD_BusquedaInfoPresupuesto_New jd = new JD_BusquedaInfoPresupuesto_New(null, true, this, nombre);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    public void cargarInformacionTercero() {
        if (!this.JTFTerceroNDocumento.getText().isEmpty()) {
            this.empresa = new GEmpresa();
            this.empresa = this.iGEmpresaService.getGEmpresaByNumeroDocumento(this.JTFTerceroNDocumento.getText());
            if (this.empresa != null) {
                llenarDatosTerceros();
                this.JTFTerceroNombre.transferFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Identificación no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFTerceroNombre.setText("");
            }
        }
    }

    public void cargarInformacionRubro() {
        if (!this.JTFCodigoRubro.getText().isEmpty()) {
            this.iPpSaldoRubroSolicitud = this.iPpSolicitudPtoService.getSaldoRubro(this.JTFCodigoRubro.getText(), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
            this.rubro = new PpRubros();
            if (this.iPpSaldoRubroSolicitud != null) {
                this.rubro = this.iPpRubrosService.getPpRubrosByIdEncabezado(this.iPpSaldoRubroSolicitud.getIdRubro(), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
                this.JTFValorSaldoRubro.setValue(this.iPpSaldoRubroSolicitud.getValorSaldoDisponible());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Código rubo no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCodigoRubro.setText("");
            }
        }
    }

    private void llenarDatosTerceros() {
        this.JTFTerceroNDocumento.setText(this.empresa.getNoidentificacion());
        if (this.empresa.getNbre().isEmpty() || this.empresa.getNbre() == null) {
            this.JTFTerceroNombre.setText(this.empresa.getApellido1().concat(" ").concat(this.empresa.getApellido2()).concat(" ").concat(this.empresa.getNombre1()).concat(" ").concat(this.empresa.getNombre2()));
        } else {
            this.JTFTerceroNombre.setText(this.empresa.getNbre());
        }
    }

    public void cargarInformacionCodigoCpc() {
        if (!this.JTFCodigoCPC.getText().isEmpty()) {
            this.ppRubrosCpc = new PpRubrosCpc();
            this.ppRubrosCpc = this.iPpRubrosCpcService.getPpRubrosCpcByNombreOrCodigo(this.JTFCodigoCPC.getText(), true);
            if (this.ppRubrosCpc != null) {
                this.JTFNombreCPC.setText(this.ppRubrosCpc.getNombre());
                this.JTFNombreCPC.transferFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Código CPC no existe o no es de ultimo nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombreCPC.setText("");
            }
        }
    }

    private void cargarDatosDetalle() {
        this.solicitudPresupuesto.setAddListDetalle(this.listSolicitudDetalle);
        crearModeloSolicitud();
        this.solicitudPresupuesto.getSolicitudPto().getPpSolicitudPtoDetalleCollection().forEach(e -> {
            this.modeloSolicitud.addRow((Object[]) null);
            this.JTDetalle.setValueAt(e.getIdrubro().getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.JTDetalle.setValueAt(e.getIdrubro().getNbre(), this.JTDetalle.getRowCount() - 1, 1);
            if (!e.getIdTercero().getNbre().isEmpty()) {
                this.JTDetalle.setValueAt(e.getIdTercero().getNbre(), this.JTDetalle.getRowCount() - 1, 2);
            } else {
                this.JTDetalle.setValueAt(e.getIdTercero().getApellido1().concat(" ").concat(e.getIdTercero().getApellido2()).concat(" ").concat(e.getIdTercero().getNombre1()).concat(" ").concat(e.getIdTercero().getNombre2()), this.JTDetalle.getRowCount() - 1, 2);
            }
            this.JTDetalle.setValueAt(e.getIdRubrosCentroCostos().getNombre(), this.JTDetalle.getRowCount() - 1, 3);
            this.JTDetalle.setValueAt(e.getIdRubrosFuenteFinanciacion().getNombre(), this.JTDetalle.getRowCount() - 1, 4);
            this.JTDetalle.setValueAt(e.getIdRubrosCpc().getCodigo(), this.JTDetalle.getRowCount() - 1, 5);
            this.JTDetalle.setValueAt(e.getIdRubrosCpc().getNombre(), this.JTDetalle.getRowCount() - 1, 6);
            this.JTDetalle.setValueAt(e.getIdTipoVigencia().getNombre(), this.JTDetalle.getRowCount() - 1, 7);
            this.JTDetalle.setValueAt(e.getValor(), this.JTDetalle.getRowCount() - 1, 8);
            this.JTDetalle.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 9);
        });
        totaliza();
    }

    private void mVerificarRubro() {
        this.pp_SaldoRubro = this.iPpMovimientoService.getListMovimientoConsolidadoRubro(this.JTFCodigoRubro.getText(), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()), "G");
        if (!this.pp_SaldoRubro.isEmpty() || this.pp_SaldoRubro != null) {
            this.pp_SaldoRubro.forEach(e -> {
                this.JTFNombreRubro.setText(e.getNombreRubro());
            });
            return;
        }
        this.JTFNombreRubro.setText("");
        this.JTFCodigoRubro.setText("");
        JOptionPane.showMessageDialog(this, "Rubro no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
