package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import General.Anular;
import Presupuesto.JDAdiciones;
import Presupuesto.JDReintegro;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.InformacionIpsDAO;
import com.genoma.plus.dao.impl.general.InformacionIpsDAOImpl;
import com.genoma.plus.dto.presupuesto.MovimientoDTO;
import com.genoma.plus.jpa.dto.InformeDocumentoPPTDto;
import com.genoma.plus.jpa.dto.ListMovimientosPPTDto;
import com.genoma.plus.jpa.dto.MovimientoPPTDto;
import com.genoma.plus.jpa.entities.CcRRequisicion;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GMotivoanulacion;
import com.genoma.plus.jpa.entities.PpDetalleMovimiento;
import com.genoma.plus.jpa.entities.PpMovimiento;
import com.genoma.plus.jpa.entities.PpPeriodo;
import com.genoma.plus.jpa.entities.PpRubroXTipoDoc;
import com.genoma.plus.jpa.entities.PpRubros;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosEncabezado;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.entities.PpSolicitudPto;
import com.genoma.plus.jpa.entities.PpTipoDocumentos;
import com.genoma.plus.jpa.entities.PpTipoVigencia;
import com.genoma.plus.jpa.projection.IPpMovimientoProjection;
import com.genoma.plus.jpa.projection.IPpSolicitudPtoDetalleProjection;
import com.genoma.plus.jpa.projection.IPp_SaldoRubro;
import com.genoma.plus.jpa.repository.IPpMovimientoRepository;
import com.genoma.plus.jpa.service.ICcRRequisicionService;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.IPpMovimientoDetalleService;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.genoma.plus.jpa.service.IPpRubroXTipoDocSevice;
import com.genoma.plus.jpa.service.IPpRubrosCentrocostosService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import com.genoma.plus.jpa.service.IPpRubrosFuenteFinanciacionService;
import com.genoma.plus.jpa.service.IPpRubrosService;
import com.genoma.plus.jpa.service.IPpSolicitudPtoService;
import com.genoma.plus.jpa.service.IPpTipoDocumentosService;
import com.genoma.plus.jpa.service.IPpTipoVigenciaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JIFFMovimiento_new.class */
public class JIFFMovimiento_new extends JInternalFrame {
    public DefaultTableModel modeloDatos;
    public DefaultTableModel xmodeloEvidencia;
    public DefaultTableModel modeloDatosDisp;
    private String idClaseDocumento;
    private String nombreDocumentoBuscar;
    private final IPpTipoDocumentosService iPpTipoDocumentosService;
    private final IPpRubrosCentrocostosService iPpRubrosCentrocostosService;
    private final IPpRubrosFuenteFinanciacionService iPpRubrosFuenteFinanciacionService;
    private final IPpRubroXTipoDocSevice iPpRubroXTipoDocSevice;
    private final IPpMovimientoService iPpMovimientoService;
    private final IPpRubrosCpcService iPpRubrosCpcService;
    private final IPpTipoVigenciaService iPpTipoVigenciaService;
    private final IGEmpresaService iGEmpresaService;
    private final IPpRubrosService iPpRubrosService;
    private final ICcRRequisicionService iCcRRequisicionService;
    private final IPpSolicitudPtoService iPpSolicitudPtoService;
    private final IPpMovimientoDetalleService detalleMovimientoService;
    private List<PpTipoDocumentos> listTipoDocumentos;
    private List<PpRubrosFuenteFinanciacion> listFuenteFinanciacion;
    private List<PpRubrosCentrocostos> listCentroCosto;
    private List<PpRubros> listRubros;
    private List<PpRubroXTipoDoc> listRubrosTipoDocumento;
    private List<PpTipoVigencia> listTipoVigencia;
    private List<PpDetalleMovimiento> listDetalleMovimiento;
    private List<CcRRequisicion> listRequisicion;
    private Optional<PpSolicitudPto> listSolicitudPto;
    private PpRubrosEncabezado rubrosEncabezado;
    public IPp_SaldoRubro pp_SaldoRubro;
    public PpRubrosCpc ppRubrosCpc;
    private GEmpresa empresa;
    private PpRubros rubro;
    private PpMovimiento movimiento;
    private MovimientoDTO movimientoDTO;
    private MovimientoPPTDto movimientoPPTDto;
    private PpPeriodo periodo;
    public PpSolicitudPto solicitudPto;
    private InformacionIpsDAO informacionIpsDAO;
    public List<IPpSolicitudPtoDetalleProjection> detalleProjections;
    private CcRRequisicion ccRRequisicion;
    private PpMovimiento ppMovimientoGrabado;
    private String[][] xIdDocumento;
    private List<IPpMovimientoProjection> movimientoProjection;
    private PpDetalleMovimiento detalle;
    private PpRubrosCentrocostos centrocostos;
    private PpRubrosCpc cpc;
    private PpRubrosFuenteFinanciacion fuenteFinanciacion;
    public String xIdClaseDoc;
    private IPpMovimientoRepository ppMovimientoRepository;
    public Long idSolicitud;
    private ListMovimientosPPTDto movimientos;
    private boolean seleccionar;
    private JButton JBAdicion;
    private JButton JBAdicionar;
    private JButton JBAgregar;
    private JButton JBBuscar;
    private JButton JBReintegro;
    private JButton JBT_BusquedaCPC;
    private JButton JBT_BusquedaCPC1;
    private JButton JBT_TerceroBusqueda;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBFuenteFinanciacion;
    private JComboBox JCBTipoDocumento;
    private JComboBox JCBVIgencia;
    private JDateChooser JDC_FechaD;
    private JDateChooser JDC_FechaDocumento;
    public JFormattedTextField JFTFValorDoc;
    public JLabel JLB_Registro;
    public JLabel JLCodigoDoc;
    private JLabel JLConsecutivo;
    private JPanel JPI_Datos;
    private JPanel JPI_DatosInfo;
    private JPanel JPI_DetalleAdicional;
    private JPanel JPI_DetalleRubro;
    private JPanel JPI_InformacionDetalle;
    private JPanel JPI_Operaciones;
    private JPanel JPI_Tercero;
    public JTable JTDetalle;
    private JTable JTDetalleEvidencia;
    public JTextField JTFCodigoCPC;
    public JTextField JTFCodigoRbro;
    private JFormattedTextField JTFFValorTotal;
    private JFormattedTextField JTFF_Valor;
    private JFormattedTextField JTFF_ValorSaldoR;
    public JTextField JTFNoDocumento;
    private JTextField JTFNombreArc;
    private JTextField JTFNombreCPC;
    private JTextField JTFNombreRbro;
    private JTextField JTFObservacion;
    private JTextField JTFRutaEvidencia;
    public JTextField JTFTerceroNDocumento;
    private JTextField JTFTerceroNombre;
    public JTextArea JTObservacion;
    public JTextArea JTObservacionArch;
    private JTabbedPane JTP_Datos;
    private JTabbedPane JTP_Detalle;
    private ButtonGroup TipoMov;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private ConsultasMySQL consultasMySQL = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    public String xMovimiento = "";
    private long Consecutivo = 0;

    public JIFFMovimiento_new(String idClaseDocumento) {
        initComponents();
        this.xIdClaseDoc = idClaseDocumento;
        System.out.println("this.xIdClaseDoc -> " + this.xIdClaseDoc);
        this.periodo = new PpPeriodo();
        springStart();
        this.periodo.setId(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()));
        this.idClaseDocumento = idClaseDocumento;
        this.iPpTipoDocumentosService = (IPpTipoDocumentosService) Principal.contexto.getBean(IPpTipoDocumentosService.class);
        this.iPpTipoVigenciaService = (IPpTipoVigenciaService) Principal.contexto.getBean(IPpTipoVigenciaService.class);
        this.iPpRubrosCentrocostosService = (IPpRubrosCentrocostosService) Principal.contexto.getBean(IPpRubrosCentrocostosService.class);
        this.iPpRubrosFuenteFinanciacionService = (IPpRubrosFuenteFinanciacionService) Principal.contexto.getBean(IPpRubrosFuenteFinanciacionService.class);
        this.iPpRubroXTipoDocSevice = (IPpRubroXTipoDocSevice) Principal.contexto.getBean(IPpRubroXTipoDocSevice.class);
        this.iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.iPpRubrosCpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
        this.iPpRubrosService = (IPpRubrosService) Principal.contexto.getBean(IPpRubrosService.class);
        this.rubrosEncabezado = new PpRubrosEncabezado();
        this.rubrosEncabezado.setId(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()));
        this.iCcRRequisicionService = (ICcRRequisicionService) Principal.contexto.getBean(ICcRRequisicionService.class);
        this.iPpSolicitudPtoService = (IPpSolicitudPtoService) Principal.contexto.getBean(IPpSolicitudPtoService.class);
        this.detalleMovimientoService = (IPpMovimientoDetalleService) Principal.contexto.getBean(IPpMovimientoDetalleService.class);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v247, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.TipoMov = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Datos = new JPanel();
        this.JPI_DatosInfo = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.JDC_FechaD = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jScrollPane1 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc = new JLabel();
        this.JDC_FechaDocumento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFNoDocumento = new JTextField();
        this.JFTFValorDoc = new JFormattedTextField();
        this.JLConsecutivo = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFValorTotal = new JFormattedTextField();
        this.JPI_Operaciones = new JPanel();
        this.JBReintegro = new JButton();
        this.JBAdicion = new JButton();
        this.JLB_Registro = new JLabel();
        this.JPI_InformacionDetalle = new JPanel();
        this.JTP_Detalle = new JTabbedPane();
        this.JPI_DetalleRubro = new JPanel();
        this.JTFCodigoRbro = new JTextField();
        this.JTFNombreRbro = new JTextField();
        this.JTFF_Valor = new JFormattedTextField();
        this.JTFObservacion = new JTextField();
        this.JTFF_ValorSaldoR = new JFormattedTextField();
        this.JBT_BusquedaCPC1 = new JButton();
        this.JPI_Tercero = new JPanel();
        this.JTFTerceroNDocumento = new JTextField();
        this.JTFTerceroNombre = new JTextField();
        this.JBT_TerceroBusqueda = new JButton();
        this.JPI_DetalleAdicional = new JPanel();
        this.JCBFuenteFinanciacion = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JTFCodigoCPC = new JTextField();
        this.JTFNombreCPC = new JTextField();
        this.JBT_BusquedaCPC = new JButton();
        this.JCBVIgencia = new JComboBox();
        this.JBAdicionar = new JButton();
        this.jPanel4 = new JPanel();
        this.jPanel6 = new JPanel();
        this.JTFNombreArc = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTObservacionArch = new JTextArea();
        this.JTFRutaEvidencia = new JTextField();
        this.JBAgregar = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleEvidencia = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MOVIMIENTO DE RUBROS PRESUPUESTALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifMovimientoPPTO_N");
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosInfo.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovimiento_new.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JCBTipoDocumento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.2
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JCBTipoDocumentoActionPerformed(evt);
            }
        });
        this.JCBTipoDocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.3
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento_new.this.JCBTipoDocumentoKeyPressed(evt);
            }
        });
        this.JDC_FechaD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaD.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaD.setFont(new Font("Tahoma", 1, 12));
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setLineWrap(true);
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTObservacion);
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.4
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaDocumento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Fecha Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaDocumento.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaDocumento.setFont(new Font("Tahoma", 1, 12));
        this.JTFNoDocumento.setFont(new Font("Arial", 1, 18));
        this.JTFNoDocumento.setForeground(Color.red);
        this.JTFNoDocumento.setHorizontalAlignment(0);
        this.JTFNoDocumento.setToolTipText("");
        this.JTFNoDocumento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Numero  Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc.setEditable(false);
        this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc.setForeground(Color.red);
        this.JFTFValorDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorDoc.setHorizontalAlignment(0);
        this.JFTFValorDoc.setText("0");
        this.JFTFValorDoc.setFont(new Font("Arial", 1, 14));
        this.JLConsecutivo.setHorizontalAlignment(0);
        this.JLConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLConsecutivo.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.5
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimiento_new.this.JLConsecutivoMouseClicked(evt);
            }
        });
        GroupLayout JPI_DatosInfoLayout = new GroupLayout(this.JPI_DatosInfo);
        this.JPI_DatosInfo.setLayout(JPI_DatosInfoLayout);
        JPI_DatosInfoLayout.setHorizontalGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosInfoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_FechaD, -2, 130, -2).addComponent(this.JDC_FechaDocumento, -2, 130, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosInfoLayout.createSequentialGroup().addComponent(this.JCBTipoDocumento, -2, 486, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorDoc)).addGroup(JPI_DatosInfoLayout.createSequentialGroup().addComponent(this.JTFNoDocumento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLConsecutivo, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 464, -2))).addContainerGap()));
        JPI_DatosInfoLayout.setVerticalGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosInfoLayout.createSequentialGroup().addGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDC_FechaD, -1, -1, 32767).addComponent(this.JCBTipoDocumento).addComponent(this.JBBuscar, -1, -1, 32767).addComponent(this.JLCodigoDoc, -1, -1, 32767).addComponent(this.JFTFValorDoc, GroupLayout.Alignment.TRAILING, -2, 52, -2)).addGap(5, 5, 5).addGroup(JPI_DatosInfoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosInfoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jScrollPane1, -2, 63, -2)).addComponent(this.JDC_FechaDocumento, -1, -1, 32767).addComponent(this.JTFNoDocumento).addComponent(this.JLConsecutivo, -1, -1, 32767)).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.6
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento_new.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JTFFValorTotal.setEditable(false);
        this.JTFFValorTotal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFValorTotal.setForeground(Color.red);
        this.JTFFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTotal.setHorizontalAlignment(0);
        this.JTFFValorTotal.setText("0");
        this.JTFFValorTotal.setFont(new Font("Arial", 1, 14));
        this.JPI_Operaciones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Operaciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBReintegro.setFont(new Font("Arial", 1, 12));
        this.JBReintegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBReintegro.setText("Reintegro");
        this.JBReintegro.setToolTipText("Reintegro");
        this.JBReintegro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.7
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBReintegroActionPerformed(evt);
            }
        });
        this.JBAdicion.setFont(new Font("Arial", 1, 12));
        this.JBAdicion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBAdicion.setText("Adición");
        this.JBAdicion.setToolTipText("Adición");
        this.JBAdicion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.8
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBAdicionActionPerformed(evt);
            }
        });
        GroupLayout JPI_OperacionesLayout = new GroupLayout(this.JPI_Operaciones);
        this.JPI_Operaciones.setLayout(JPI_OperacionesLayout);
        JPI_OperacionesLayout.setHorizontalGroup(JPI_OperacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OperacionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBReintegro, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JBAdicion, -2, 130, -2).addGap(22, 22, 22)));
        JPI_OperacionesLayout.setVerticalGroup(JPI_OperacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OperacionesLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPI_OperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBReintegro, -1, 50, 32767).addComponent(this.JBAdicion, -1, 50, 32767))));
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_InformacionDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DETALLE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTP_Detalle.setForeground(Color.red);
        this.JTP_Detalle.setFont(new Font("Arial", 1, 14));
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.9
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento_new.this.JTFCodigoRbroKeyPressed(evt);
            }
        });
        this.JTFNombreRbro.setFont(new Font("Arial", 1, 12));
        this.JTFNombreRbro.setToolTipText("");
        this.JTFNombreRbro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Valor.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Valor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_Valor.setHorizontalAlignment(0);
        this.JTFF_Valor.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_ValorSaldoR.setEditable(false);
        this.JTFF_ValorSaldoR.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Saldo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_ValorSaldoR.setForeground(Color.red);
        this.JTFF_ValorSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_ValorSaldoR.setHorizontalAlignment(0);
        this.JTFF_ValorSaldoR.setText("0");
        this.JTFF_ValorSaldoR.setFont(new Font("Arial", 1, 14));
        this.JBT_BusquedaCPC1.setFont(new Font("Arial", 1, 12));
        this.JBT_BusquedaCPC1.setText("...");
        this.JBT_BusquedaCPC1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.10
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBT_BusquedaCPC1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_DetalleRubroLayout = new GroupLayout(this.JPI_DetalleRubro);
        this.JPI_DetalleRubro.setLayout(JPI_DetalleRubroLayout);
        JPI_DetalleRubroLayout.setHorizontalGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRubroLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFObservacion).addGroup(JPI_DetalleRubroLayout.createSequentialGroup().addComponent(this.JTFCodigoRbro, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombreRbro, -2, 435, -2).addGap(3, 3, 3).addComponent(this.JBT_BusquedaCPC1, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Valor, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_ValorSaldoR, -1, 171, 32767))).addContainerGap()));
        JPI_DetalleRubroLayout.setVerticalGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRubroLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_Valor, -2, 50, -2).addComponent(this.JTFF_ValorSaldoR, -2, 50, -2)).addGroup(JPI_DetalleRubroLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_BusquedaCPC1, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(JPI_DetalleRubroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoRbro, -2, 50, -2).addComponent(this.JTFNombreRbro, -2, 50, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JTFObservacion, -2, 50, -2).addGap(12, 12, 12)));
        this.JTP_Detalle.addTab("RUBRO", this.JPI_DetalleRubro);
        this.JTFTerceroNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFTerceroNDocumento.setToolTipText("");
        this.JTFTerceroNDocumento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTerceroNDocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.11
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento_new.this.JTFTerceroNDocumentoKeyPressed(evt);
            }
        });
        this.JTFTerceroNombre.setFont(new Font("Arial", 1, 12));
        this.JTFTerceroNombre.setToolTipText("");
        this.JTFTerceroNombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_TerceroBusqueda.setFont(new Font("Arial", 1, 12));
        this.JBT_TerceroBusqueda.setText("...");
        this.JBT_TerceroBusqueda.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.12
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBT_TerceroBusquedaActionPerformed(evt);
            }
        });
        GroupLayout JPI_TerceroLayout = new GroupLayout(this.JPI_Tercero);
        this.JPI_Tercero.setLayout(JPI_TerceroLayout);
        JPI_TerceroLayout.setHorizontalGroup(JPI_TerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TerceroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFTerceroNDocumento, -1, 147, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTerceroNombre, -2, 713, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_TerceroBusqueda, -2, 57, -2).addGap(18, 18, 18)));
        JPI_TerceroLayout.setVerticalGroup(JPI_TerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TerceroLayout.createSequentialGroup().addGroup(JPI_TerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TerceroLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(JPI_TerceroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTerceroNombre, -2, 50, -2).addComponent(this.JTFTerceroNDocumento, -2, 50, -2))).addGroup(JPI_TerceroLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JBT_TerceroBusqueda, -2, 50, -2))).addContainerGap(65, 32767)));
        this.JTP_Detalle.addTab("TERCERO", this.JPI_Tercero);
        this.JCBFuenteFinanciacion.setFont(new Font("Arial", 1, 12));
        this.JCBFuenteFinanciacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Fuente Financiación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Centro Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCPC.setToolTipText("");
        this.JTFCodigoCPC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Código CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.13
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento_new.this.JTFCodigoCPCKeyPressed(evt);
            }
        });
        this.JTFNombreCPC.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCPC.setToolTipText("");
        this.JTFNombreCPC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Nombre CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_BusquedaCPC.setFont(new Font("Arial", 1, 12));
        this.JBT_BusquedaCPC.setText("...");
        this.JBT_BusquedaCPC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.14
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBT_BusquedaCPCActionPerformed(evt);
            }
        });
        this.JCBVIgencia.setFont(new Font("Arial", 1, 12));
        this.JCBVIgencia.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)), "Vigencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DetalleAdicionalLayout = new GroupLayout(this.JPI_DetalleAdicional);
        this.JPI_DetalleAdicional.setLayout(JPI_DetalleAdicionalLayout);
        JPI_DetalleAdicionalLayout.setHorizontalGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addComponent(this.JCBFuenteFinanciacion, -2, 214, -2).addGap(18, 18, 18).addComponent(this.JCBCentroCosto, -2, 424, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBVIgencia, -2, 272, -2)).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addComponent(this.JTFCodigoCPC, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreCPC, -2, 707, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_BusquedaCPC, -2, 57, -2))).addContainerGap(-1, 32767)));
        JPI_DetalleAdicionalLayout.setVerticalGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleAdicionalLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFuenteFinanciacion, -2, 52, -2).addComponent(this.JCBCentroCosto, -2, 52, -2).addComponent(this.JCBVIgencia, -2, 52, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addGroup(JPI_DetalleAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoCPC, -2, 53, -2).addComponent(this.JTFNombreCPC, -2, 53, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleAdicionalLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JBT_BusquedaCPC, -2, 50, -2))).addContainerGap()));
        this.JTP_Detalle.addTab("ADICIONAL", this.JPI_DetalleAdicional);
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.15
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento_new.this.JBAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_InformacionDetalleLayout = new GroupLayout(this.JPI_InformacionDetalle);
        this.JPI_InformacionDetalle.setLayout(JPI_InformacionDetalleLayout);
        JPI_InformacionDetalleLayout.setHorizontalGroup(JPI_InformacionDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Detalle).addComponent(this.JBAdicionar, -1, -1, 32767)).addContainerGap()));
        JPI_InformacionDetalleLayout.setVerticalGroup(JPI_InformacionDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Detalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -2, 39, -2).addContainerGap(8, 32767)));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosInfo, -1, -1, 32767).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JPI_Operaciones, -2, -1, -2).addGap(184, 184, 184).addComponent(this.JLB_Registro, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFValorTotal, -2, 169, -2)).addComponent(this.jScrollPane2).addComponent(this.JPI_InformacionDetalle, -1, -1, 32767)).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JPI_DatosInfo, -2, 149, -2).addGap(30, 30, 30).addComponent(this.JPI_InformacionDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Operaciones, -2, -1, -2).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorTotal, GroupLayout.Alignment.TRAILING, -1, 66, 32767).addComponent(this.JLB_Registro, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addContainerGap(-1, 32767)));
        this.JTP_Datos.addTab("DATOS", this.JPI_Datos);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombreArc.setFont(new Font("Arial", 1, 12));
        this.JTFNombreArc.setToolTipText("");
        this.JTFNombreArc.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTObservacionArch.setColumns(1);
        this.JTObservacionArch.setFont(new Font("Arial", 1, 12));
        this.JTObservacionArch.setRows(1);
        this.JTObservacionArch.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTObservacionArch);
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBAgregar.setFont(new Font("Tahoma", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JTFNombreArc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaEvidencia, -2, 551, -2)).addComponent(this.JBAgregar, -1, -1, 32767).addComponent(this.jScrollPane3)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombreArc, -1, 53, 32767).addComponent(this.JTFRutaEvidencia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, 37, 32767).addContainerGap()));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "EVIDENCIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEvidencia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEvidencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEvidencia.setSelectionForeground(Color.red);
        this.jScrollPane4.setViewportView(this.JTDetalleEvidencia);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 975, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 313, -2).addContainerGap(148, 32767)));
        this.JTP_Datos.addTab("SOPORTES", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTP_Datos).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTP_Datos, -2, 704, -2).addGap(0, 0, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarInformacionRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_BusquedaCPCActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("CodigoCpc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_BusquedaCPC1ActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("Rubro");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCPCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarInformacionCodigoCpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JTFCodigoRbro.getText() == null) {
            showMessage("Debe seleccionar un rubro", 0, this.JTFCodigoRbro);
            return;
        }
        if (this.JTFF_Valor.getText() == null || Double.parseDouble(this.JTFF_Valor.getValue().toString()) <= 0.0d) {
            showMessage("El valor no puede ser nulo y debe ser mayor a cero", 0, this.JTFF_Valor);
            return;
        }
        if (Double.valueOf(this.JTFF_ValorSaldoR.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFF_Valor.getValue().toString()).doubleValue()) {
            showMessage("El valor no puede ser mayor al saldo del rubro", 0, this.JTFF_Valor);
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
            showMessage("Debe seleccionar un código CPC", 2, this.JTFCodigoCPC);
            return;
        }
        if (this.JTFTerceroNDocumento == null || this.JTFTerceroNDocumento.getText().isEmpty() || this.JTFTerceroNombre == null || this.JTFTerceroNombre.getText().isEmpty()) {
            int response = JOptionPane.showConfirmDialog(this, "El tercero está vacío. ¿Desea usar el tercero por defecto?", "Confirmar", 0);
            if (response == 0) {
                this.empresa = this.iGEmpresaService.getGEmpresaById(Principal.informacionIps.getIdEmpresa());
            } else {
                this.JTP_Detalle.setSelectedIndex(1);
                this.JTFTerceroNDocumento.requestFocus();
                return;
            }
        }
        PpDetalleMovimiento pdm = PpDetalleMovimiento.builder().estado(true).idConceptoN(0).idEncabezado(this.rubrosEncabezado).idMovimiento(this.movimiento).idRubro(this.rubro).idTercero(this.empresa).nCCobro(0L).nFactura("0").observacion(this.JTFObservacion.getText()).ppRubrosCentrocostos(this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex())).ppRubrosCpc(this.ppRubrosCpc).ppRubrosFunteFinanciacion(this.listFuenteFinanciacion.get(this.JCBFuenteFinanciacion.getSelectedIndex())).tipo(true).PpTipoVigencia(this.listTipoVigencia.get(this.JCBVIgencia.getSelectedIndex())).valor(Double.valueOf(this.JTFF_Valor.getValue().toString()).doubleValue()).build();
        this.listDetalleMovimiento.add(pdm);
        cargarDatosDetalle();
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
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            this.listDetalleMovimiento.remove(this.JTDetalle.getSelectedRow());
            cargarDatosDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JLB_Registro.getText().isEmpty()) {
            JD_BusquedaDocumentosPto busquedaDocumentosPto = new JD_BusquedaDocumentosPto(null, true, this.nombreDocumentoBuscar, this.listTipoDocumentos.get(this.JCBTipoDocumento.getSelectedIndex()).getIdClaseDoc().getId(), this);
            busquedaDocumentosPto.setLocationRelativeTo(this);
            busquedaDocumentosPto.setVisible(true);
            crearModeloDisponibilidad();
            if (!this.detalleProjections.isEmpty()) {
                System.out.println(this.detalleProjections.size() + ". - " + this.detalleProjections.get(0).getNbre());
                this.detalleProjections.forEach(e -> {
                    this.modeloDatos.addRow((Object[]) null);
                    this.JTDetalle.setValueAt(e.getIdrubro(), this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(e.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(e.getValor(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt("", this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(0, this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(0, this.JTDetalle.getRowCount() - 1, 5);
                    this.JTDetalle.setValueAt(true, this.JTDetalle.getRowCount() - 1, 8);
                    this.JTDetalle.setValueAt(e.getRubrosFuenteFinanciacion(), this.JTDetalle.getRowCount() - 1, 9);
                    this.JTDetalle.setValueAt(e.getRubrosCentroCostos(), this.JTDetalle.getRowCount() - 1, 10);
                    this.JTDetalle.setValueAt(e.getNombreVigencia(), this.JTDetalle.getRowCount() - 1, 11);
                    this.JTDetalle.setValueAt(e.getRubrosCpc(), this.JTDetalle.getRowCount() - 1, 12);
                    this.JTDetalle.setValueAt(e.getNombreCPC(), this.JTDetalle.getRowCount() - 1, 13);
                });
                this.JTFTerceroNDocumento.setText(this.detalleProjections.get(0).getDocEmpresa());
                this.JTFTerceroNombre.setText(this.detalleProjections.get(0).getNbreEmpresa());
                this.empresa.setId(Long.valueOf(this.detalleProjections.get(0).getId_Tercero()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            List<String[]> listaDatos = new ArrayList<>();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String[] datosFila = {this.JTDetalle.getValueAt(i, 0).toString(), this.JTDetalle.getValueAt(i, 1).toString(), this.JTDetalle.getValueAt(i, 2).toString(), this.JTDetalle.getValueAt(i, 3).toString(), this.JTDetalle.getValueAt(i, 4).toString(), this.JTDetalle.getValueAt(i, 5).toString()};
                listaDatos.add(datosFila);
            }
            JDAdiciones x = new JDAdiciones(null, true, this, this.idClaseDocumento, listaDatos, this.JLB_Registro.getText());
            x.setLocationRelativeTo(this);
            x.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBReintegroActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mAbreReintegro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoDocumento.getSelectedIndex() != -1 && this.JLB_Registro.getText().isEmpty()) {
            consecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLConsecutivoMouseClicked(MouseEvent evt) {
        int opcion = JOptionPane.showConfirmDialog((Component) null, "¿Desea añadir el consecutivo de forma manual?", "Confirmar acción", 0);
        if (opcion == 0) {
            String inputConsecutivo = JOptionPane.showInputDialog((Component) null, "Ingrese el consecutivo manual:");
            try {
                this.JLConsecutivo.setText(String.valueOf(inputConsecutivo));
                this.Consecutivo = Long.valueOf(inputConsecutivo).longValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void springStart() {
        this.informacionIpsDAO = (InformacionIpsDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informacionIpsDAOImpl");
    }

    public void cargarMovimiento(MovimientoPPTDto dto) {
        this.movimientoPPTDto = dto;
        this.JLB_Registro.setText("" + this.movimientoPPTDto.getMovimiento().getId());
    }

    private void cargarDialogoBusqueda(String nombre) {
        JD_BusquedaInfoPresupuesto jd = new JD_BusquedaInfoPresupuesto(null, true, this, nombre);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
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

    public void cargarInformacionRubro() {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            this.pp_SaldoRubro = this.iPpMovimientoService.getMovimientoConsolidadoRubro(this.JTFCodigoRbro.getText(), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), this.rubrosEncabezado.getId(), "G");
            this.rubro = new PpRubros();
            if (this.pp_SaldoRubro != null) {
                this.rubro = this.iPpRubrosService.getPpRubrosByIdEncabezado(this.pp_SaldoRubro.getIdRubro(), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
                this.JTFNombreRbro.setText(this.pp_SaldoRubro.getNombreRubro());
                if (this.idClaseDocumento.equals("9")) {
                    this.JTFF_ValorSaldoR.setValue(this.pp_SaldoRubro.getValorSaldoDisponible());
                }
                if (this.idClaseDocumento.equals("4")) {
                    this.JTFF_ValorSaldoR.setValue(this.pp_SaldoRubro.getValorSinComprometer());
                }
                this.JTFF_Valor.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Código rubo no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombreRbro.setText("");
        }
    }

    public final void nuevo() {
        Principal.txtNo.setText("");
        this.JFTFValorDoc.setText("");
        this.JLCodigoDoc.setText("");
        this.JLB_Registro.setText("");
        this.ppMovimientoGrabado = new PpMovimiento();
        this.movimientoDTO = new MovimientoDTO();
        this.movimiento = new PpMovimiento();
        this.movimientoDTO.setMovimiento(this.movimiento);
        this.solicitudPto = new PpSolicitudPto();
        this.listDetalleMovimiento = new ArrayList();
        this.empresa = new GEmpresa();
        this.JDC_FechaD.setDate(this.metodos.getFechaActual());
        this.JDC_FechaDocumento.setDate((Date) null);
        this.ppRubrosCpc = new PpRubrosCpc();
        this.JTFTerceroNDocumento.setText("");
        this.JTFFValorTotal.setValue(new Double(0.0d));
        this.JTFTerceroNombre.setText("");
        this.rubro = new PpRubros();
        switch (this.idClaseDocumento) {
            case "4":
                setTitle("COMPROMISO PRESUPUESTAL");
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Disp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.nombreDocumentoBuscar = "DISPONIBILIDAD PRESUPUESTAL";
                break;
            case "9":
                setTitle("DISPONIBILIDAD PRESUPUESTAL");
                this.nombreDocumentoBuscar = "SOLICITUD PRESUPUESTAL";
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                crearModeloDisponibilidad();
                break;
            default:
                setTitle("");
                break;
        }
        this.JTFCodigoCPC.setText("");
        this.JTFCodigoRbro.setText("");
        this.JTFNombreRbro.setText("");
        this.JTFNoDocumento.setText("");
        this.JTFNombreArc.setText("");
        this.JTFNombreCPC.setText("");
        this.JTFObservacion.setText("");
        this.JTObservacion.setText("");
        this.JTObservacionArch.setText("");
        this.JTFF_ValorSaldoR.setValue(new Double(0.0d));
        this.JTFF_Valor.setValue(new Double(0.0d));
        this.JLConsecutivo.setText("");
        this.JCBTipoDocumento.removeAllItems();
        this.listTipoDocumentos = new ArrayList();
        this.listTipoDocumentos = this.iPpTipoDocumentosService.listaTipoDocumentosPorIdClaseDocumento(Integer.valueOf(this.idClaseDocumento));
        this.listTipoDocumentos.forEach(e -> {
            this.JCBTipoDocumento.addItem(e.getNbre());
        });
        this.JCBCentroCosto.removeAllItems();
        this.listCentroCosto = new ArrayList();
        this.listCentroCosto = this.iPpRubrosCentrocostosService.getListPpRubrosCentrocostosOrderByNombreAsc();
        this.listCentroCosto.forEach(e2 -> {
            this.JCBCentroCosto.addItem(e2.getNombre());
        });
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.JCBFuenteFinanciacion.removeAllItems();
        this.listFuenteFinanciacion = new ArrayList();
        this.listFuenteFinanciacion = this.iPpRubrosFuenteFinanciacionService.getListPpRubrosFuenteFinanciacionOrderByNombreAsc();
        this.listFuenteFinanciacion.forEach(e3 -> {
            this.JCBFuenteFinanciacion.addItem(e3.getNombre());
        });
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
        this.JCBVIgencia.removeAllItems();
        this.listTipoVigencia = new ArrayList();
        this.listTipoVigencia = this.iPpTipoVigenciaService.getListIPpTipoVigenciaOrderByNombreAsc();
        this.listTipoVigencia.forEach(e4 -> {
            this.JCBVIgencia.addItem(e4.getNombre());
        });
        this.JCBVIgencia.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.modeloDatos = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "IdTercero", "Tercero", "Valor", "Observacion", "Estado", "Tipo"}) { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modeloDatos);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(5);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearModeloDisponibilidad() {
        this.modeloDatos = new DefaultTableModel(new Object[0], new String[]{"CodRubro", "Nombre Rubro", "Valor", "Observacion", "Adicion", "Reintegros", "Comprometido", "PorEjecutar", "Estado", "Fuente Financiación", "Centro Costo", "Vigencia", "Código CPC", "Nombre CPC"}) { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.17
            Class[] types = {String.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloDatos);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCompromiso() {
        this.modeloDatos = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "ValorComprometido", "IdTercero", "Tercero", "Observacion", "Estado", "", "DisponibilidadInicial", "AdicionCompr.", "PorEjecutar", "ReintegroCompromiso"}) { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.18
            Class[] types = {String.class, String.class, String.class, Double.class, String.class, String.class, String.class, Boolean.class, JButton.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, true, false, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setDefaultRenderer(JButton.class, (jtable, objeto, estaSeleccionado, tieneElFoco, fila, columna) -> {
            return (Component) objeto;
        });
        this.JTDetalle.setModel(this.modeloDatos);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(20);
    }

    public void buscar() {
        if (this.JLB_Registro.getText().isEmpty()) {
            JDBusquedaMovPTO_new busquedaDocumentosPto = new JDBusquedaMovPTO_new(null, true, this.listTipoDocumentos.get(this.JCBTipoDocumento.getSelectedIndex()).getIdClaseDoc().getId(), this, getName());
            busquedaDocumentosPto.setLocationRelativeTo(this);
            busquedaDocumentosPto.setVisible(true);
        }
    }

    public final void grabar() {
        if (this.JLB_Registro.getText().isEmpty()) {
            if (this.metodos.mVerificaFecha_PeriodoPresupuesto(this.metodos.formatoAMD.format(this.JDC_FechaD.getDate()))) {
                if (this.JDC_FechaD.getDate() != null) {
                    if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
                        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            GMotivoanulacion gMotivoanulacion = new GMotivoanulacion();
                            gMotivoanulacion.setId(1);
                            this.movimiento.setBloqueo(false);
                            this.movimiento.setEsGlobal(false);
                            this.movimiento.setFecha(this.metodos.getFechaActual());
                            this.movimiento.setFechaAD(this.JDC_FechaDocumento.getDate());
                            this.movimiento.setFechaD(this.JDC_FechaD.getDate());
                            this.movimiento.setIdCompromiso(new Long(0L));
                            this.movimiento.setIdDisponibilidad(new Long(0L));
                            this.movimiento.setIdDocContable(new Long(0L));
                            this.movimiento.setIdMotivoAnulacion(gMotivoanulacion);
                            this.movimiento.setIdNomina(new Long(0L));
                            this.movimiento.setIdObligacion(new Long(0L));
                            this.movimiento.setIdPeriodo(this.periodo);
                            this.movimiento.setIdRadicacion(new Long(0L));
                            this.movimiento.setIdSolicitud(this.idSolicitud);
                            this.movimiento.setIdTipoDoc(this.listTipoDocumentos.get(this.JCBTipoDocumento.getSelectedIndex()));
                            this.movimiento.setIdUsuarioR(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                            this.movimiento.setNoDocumento(this.JTFNoDocumento.getText());
                            this.movimiento.setNoDocumentoPadre("0");
                            this.movimiento.setNoFact("");
                            this.movimiento.setObservacion(this.JTObservacion.getText());
                            this.movimiento.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            this.movimiento.setValorF(new Double(0.0d));
                            this.movimiento.setNoConcecutivo(Integer.valueOf(this.JLConsecutivo.getText()).intValue());
                            this.movimiento = this.iPpMovimientoService.grabar(this.movimiento);
                            this.JLB_Registro.setText("" + this.movimiento.getId());
                            grabarDetalleMovimiento();
                            imprimir();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTP_Detalle.setSelectedIndex(2);
                    this.JCBTipoDocumento.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha documento no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTP_Detalle.setSelectedIndex(2);
                this.JDC_FechaD.requestFocus();
                return;
            }
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this, "Disponibilidad ya creada. ¿Desea actualizar el concepto en Disponibilidad?", "Actualizar Concepto", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (respuesta == 0) {
            try {
                this.iPpMovimientoService.actualizarConcepto(Long.valueOf(this.JLB_Registro.getText()), this.JTObservacion.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void imprimir() {
        InformeDocumentoPPTDto informeDocumentoPPTDto = new InformeDocumentoPPTDto();
        informeDocumentoPPTDto.setInformacionIps(this.informacionIpsDAO.informacionIps());
        informeDocumentoPPTDto.setRutaSubReportes(this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra());
        informeDocumentoPPTDto.setRutaFirmas(this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra());
        informeDocumentoPPTDto.setUsuarioGeneradorInforme(Principal.usuarioSistemaDTO.getNombreUsuario());
        Double valorAdicion = new Double(0.0d);
        Double valorReintegro = new Double(0.0d);
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            valorAdicion = Double.valueOf(valorAdicion.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getRowCount() - 1, 4).toString()).doubleValue());
            valorReintegro = Double.valueOf(valorReintegro.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getRowCount() - 1, 5).toString()).doubleValue());
        }
        String valor = this.JTFFValorTotal.getText();
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdDisponibilidad";
        mparametros[0][1] = this.xMovimiento;
        mparametros[1][0] = "numeroLetra1";
        mparametros[1][1] = this.metodos.mConvertirNumeroLetras(valor);
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        mparametros[4][0] = "idClaseDocumento";
        System.out.println("xMovimiento-->" + this.xMovimiento);
        if (valorAdicion.doubleValue() > 0.0d || valorReintegro.doubleValue() > 0.0d) {
            Object[] botones1 = {"Disponibilidad", "Reintegro-Adición", "Cerrar"};
            int v = JOptionPane.showOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Disponibilidad");
            if (v == 0) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_CDP", mparametros);
                return;
            } else {
                if (v == 1) {
                    if (valorAdicion.doubleValue() > 0.0d) {
                        mparametros[4][1] = "10";
                    } else {
                        mparametros[4][1] = "11";
                    }
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_AdicionReintegros", mparametros);
                    return;
                }
                return;
            }
        }
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_CDP", mparametros);
    }

    private void llenarDatosTerceros() {
        this.JTFTerceroNDocumento.setText(this.empresa.getNoidentificacion());
        if (this.empresa.getNbre().isEmpty() || this.empresa.getNbre() == null) {
            this.JTFTerceroNombre.setText(this.empresa.getApellido1().concat(" ").concat(this.empresa.getApellido1()).concat(" ").concat(this.empresa.getApellido2()).concat(" ").concat(this.empresa.getNombre1()).concat(" ").concat(this.empresa.getNombre2()));
        } else {
            this.JTFTerceroNombre.setText(this.empresa.getNbre());
        }
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

    private void cargarDatosDetalle() {
        this.movimientoDTO.setAddListDetalle(this.listDetalleMovimiento);
        if (this.JTDetalle.getRowCount() <= 0) {
            crearModeloDisponibilidad();
        }
        this.movimientoDTO.getMovimiento().getPpDetalleMovimientoCollection().forEach(e -> {
            this.modeloDatos.addRow((Object[]) null);
            this.JTDetalle.setValueAt(e.getIdRubro().getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.JTDetalle.setValueAt(e.getIdRubro().getNbre(), this.JTDetalle.getRowCount() - 1, 1);
            this.JTDetalle.setValueAt(Double.valueOf(e.getValor()), this.JTDetalle.getRowCount() - 1, 2);
            this.JTDetalle.setValueAt(e.getObservacion(), this.JTDetalle.getRowCount() - 1, 3);
            this.JTDetalle.setValueAt(0, this.JTDetalle.getRowCount() - 1, 4);
            this.JTDetalle.setValueAt(0, this.JTDetalle.getRowCount() - 1, 5);
            this.JTDetalle.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 8);
            this.JTDetalle.setValueAt(e.getPpRubrosFunteFinanciacion().getNombre(), this.JTDetalle.getRowCount() - 1, 9);
            this.JTDetalle.setValueAt(e.getPpRubrosCentrocostos().getNombre(), this.JTDetalle.getRowCount() - 1, 10);
            this.JTDetalle.setValueAt(e.getPpTipoVigencia().getNombre(), this.JTDetalle.getRowCount() - 1, 11);
            this.JTDetalle.setValueAt(e.getPpRubrosCpc().getCodigo(), this.JTDetalle.getRowCount() - 1, 12);
            this.JTDetalle.setValueAt(e.getPpRubrosCpc().getNombre(), this.JTDetalle.getRowCount() - 1, 13);
        });
        this.JTFFValorTotal.setValue(this.movimientoDTO.getValorTotal());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDisponibilidad() {
        this.modeloDatos = new DefaultTableModel(new Object[0], new String[]{"CodRubro", "Nombre Rubro", "Valor", "Observacion", "Adicion", "Reintegros", "Comprometido", "PorEjecutar", "Estado", "Fuente Financiación", "Centro Costo", "Vigencia", "Código CPC", "Nombre CPC", "IdDetalle"}) { // from class: com.genoma.plus.controller.presupuesto.JIFFMovimiento_new.19
            Class[] types = {String.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modeloDatos);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
    }

    public void mBuscaMovimiento(String xId, String disponibilidad) {
        this.JLB_Registro.setText(xId);
        System.out.println("Antes " + this.JLB_Registro.getText());
        if (this.JCBTipoDocumento.getSelectedItem().equals("DISPONIBILIDAD")) {
            mCrearModeloDatosDisponibilidad();
            System.out.println("this.JLB_Registro.getText()" + this.JLB_Registro.getText());
            System.out.println("Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() -> " + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
            List<IPpMovimientoProjection> detalleProjection = this.iPpMovimientoService.getListMovimientoDisponibilidad(this.JLB_Registro.getText(), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
            detalleProjection.forEach(e -> {
                if (this.JCBTipoDocumento.getSelectedItem().equals("DISPONIBILIDAD")) {
                    this.xMovimiento = e.getIdDisponibilidad();
                    String fechaOriginal = e.getFechaD();
                    try {
                        SimpleDateFormat sdfOriginal = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaDate = sdfOriginal.parse(fechaOriginal);
                        SimpleDateFormat sdfNuevo = new SimpleDateFormat("dd-MM-yyyy");
                        String nuevaFecha = sdfNuevo.format(fechaDate);
                        this.JDC_FechaD.setDateFormatString(nuevaFecha);
                    } catch (ParseException ev) {
                        ev.printStackTrace();
                    }
                    this.JDC_FechaD.setDateFormatString(xId);
                    this.JCBTipoDocumento.setSelectedItem(e.getTipoDocumento());
                    this.JTObservacion.setText(e.getObservacion());
                    this.modeloDatos.addRow((Object[]) null);
                    this.JTDetalle.setValueAt(e.getIdDetalleMovimiento(), this.JTDetalle.getRowCount() - 1, 14);
                    this.JTDetalle.setValueAt(e.getId_Rubro(), this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(e.getNombreRubro(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(e.getValorDetalle(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt(e.getObsDetalle(), this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(e.getAdicion(), this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(e.getReintegro(), this.JTDetalle.getRowCount() - 1, 5);
                    this.JTDetalle.setValueAt(e.getCompromiso(), this.JTDetalle.getRowCount() - 1, 6);
                    this.JTDetalle.setValueAt(e.getPor_Ejecutar(), this.JTDetalle.getRowCount() - 1, 7);
                    this.JTDetalle.setValueAt(true, this.JTDetalle.getRowCount() - 1, 8);
                    this.JTDetalle.setValueAt(e.getFuenteFinanciacion(), this.JTDetalle.getRowCount() - 1, 9);
                    this.JTDetalle.setValueAt(e.getCentroCostos(), this.JTDetalle.getRowCount() - 1, 10);
                    this.JTDetalle.setValueAt(e.getVigencia(), this.JTDetalle.getRowCount() - 1, 11);
                    this.JTDetalle.setValueAt(e.getIdCpc(), this.JTDetalle.getRowCount() - 1, 12);
                    this.JTDetalle.setValueAt(e.getCpc(), this.JTDetalle.getRowCount() - 1, 13);
                    this.JTFNoDocumento.setText(e.getNoDocumento());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date fecha = formatoFecha.parse(e.getFechaD());
                        this.JDC_FechaD.setDate(fecha);
                    } catch (ParseException i) {
                        i.printStackTrace();
                    }
                    this.JLConsecutivo.setText(e.getNoConcecutivo());
                    if (this.JCBTipoDocumento.getSelectedItem().equals("DISPONIBILIDAD")) {
                        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                        this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                        mBuscaValorSolicitud(e.getIdSolicitud());
                    }
                }
            });
            double valorTotal = 0.0d;
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                valorTotal += (Double.valueOf(this.JTDetalle.getValueAt(i, 2).toString()).doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(i, 4).toString()).doubleValue()) - Double.valueOf(this.JTDetalle.getValueAt(i, 5).toString()).doubleValue();
            }
            System.out.println("valorTotal -> " + valorTotal);
            this.JTFFValorTotal.setValue(Double.valueOf(valorTotal));
        }
    }

    private void mBuscaValorSolicitud(String xid) {
        int id = Integer.parseInt(xid);
        if (Principal.informacionIps.getTiposolicitudcdp() == 0) {
            this.listRequisicion = this.iCcRRequisicionService.findAll();
            this.listRequisicion.forEach(e -> {
                if (e.getId().intValue() == id) {
                    this.JLCodigoDoc.setText(e.getNConsecutivo().toString());
                    this.JFTFValorDoc.setValue(Double.valueOf(e.getVPresupuestado().doubleValue()));
                }
            });
            return;
        }
        long idSolicitud = id;
        this.listSolicitudPto = this.iPpSolicitudPtoService.findById(Long.valueOf(idSolicitud));
        if (this.listSolicitudPto.isPresent()) {
            this.JLCodigoDoc.setText(this.listSolicitudPto.get().getNconsecutivo().toString());
            this.JFTFValorDoc.setValue(Double.valueOf(this.listSolicitudPto.get().getValor().doubleValue()));
        } else {
            System.out.println("La lista solicitud esta vacia");
        }
    }

    private List<PpDetalleMovimiento> obtenerDetalleMovimiento() {
        List<PpDetalleMovimiento> detallesMovimiento = new ArrayList<>();
        PpDetalleMovimiento detalle = new PpDetalleMovimiento();
        System.out.println("detalle pro ---> " + this.detalleProjections.size());
        this.detalleProjections.forEach(e -> {
            new PpRubros();
            PpRubros ppRubros = this.iPpRubrosService.getPpRubrosByIdEncabezado(e.getIdrubro(), "3");
            new PpRubrosCentrocostos();
            PpRubrosCentrocostos centrocostos = this.iPpRubrosCentrocostosService.getPpRubrosCentrocostosByNombreOrCodigo(e.getRubrosCentroCostos());
            new PpRubrosCpc();
            PpRubrosCpc cpc = this.iPpRubrosCpcService.getPpRubrosCpcByNombreOrCodigo(e.getNombreCPC(), true);
            new PpRubrosFuenteFinanciacion();
            PpRubrosFuenteFinanciacion fuenteFinanciacion = this.iPpRubrosFuenteFinanciacionService.getPpRubrosFuenteFinanciacionByNombreOrCodigo(e.getRubrosFuenteFinanciacion());
            detalle.setEstado(true);
            detalle.setIdEncabezado(this.rubrosEncabezado);
            detalle.setIdConceptoN(0);
            detalle.setIdMovimiento(this.movimiento);
            detalle.setIdRubro(ppRubros);
            detalle.setPpRubrosCentrocostos(centrocostos);
            detalle.setPpRubrosCpc(cpc);
            detalle.setPpRubrosFunteFinanciacion(fuenteFinanciacion);
            detallesMovimiento.add(detalle);
        });
        return detallesMovimiento;
    }

    private void grabarDetalleMovimiento() {
        boolean tipoRubro = true;
        double valorTotal = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.detalle = new PpDetalleMovimiento();
            this.rubro = new PpRubros();
            this.rubro = this.iPpRubrosService.getPpRubrosByIdEncabezado(this.JTDetalle.getValueAt(i, 0).toString(), Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
            this.centrocostos = new PpRubrosCentrocostos();
            this.centrocostos = this.iPpRubrosCentrocostosService.getPpRubrosCentrocostosByNombreOrCodigo(this.JTDetalle.getValueAt(i, 10).toString());
            this.cpc = new PpRubrosCpc();
            this.cpc = this.iPpRubrosCpcService.getPpRubrosCpcByNombreOrCodigo(this.JTDetalle.getValueAt(i, 12).toString(), true);
            this.fuenteFinanciacion = new PpRubrosFuenteFinanciacion();
            this.fuenteFinanciacion = this.iPpRubrosFuenteFinanciacionService.getPpRubrosFuenteFinanciacionByNombreOrCodigo(this.JTDetalle.getValueAt(i, 9).toString());
            List<PpTipoVigencia> ppTipoVigencia = this.iPpTipoVigenciaService.getListIPpTipoVigenciaOrderByNombreAsc();
            PpTipoVigencia ppTipoVig = new PpTipoVigencia();
            Iterator<PpTipoVigencia> it = ppTipoVigencia.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PpTipoVigencia a = it.next();
                if (a.getId().toString().equals(this.detalleProjections.get(i).getIdTipoVigencia())) {
                    ppTipoVig = a;
                    break;
                }
            }
            if (this.rubro.getTipoRubro().equals("I")) {
                tipoRubro = false;
            }
            this.movimiento = this.iPpMovimientoService.buscarMovimientoPorId(Long.valueOf(this.JLB_Registro.getText()));
            PpDetalleMovimiento detalleMovimiento = PpDetalleMovimiento.builder().PpTipoVigencia(ppTipoVig).estado(true).idConceptoN(0).idEncabezado(this.rubrosEncabezado).idMovimiento(this.movimiento).idRubro(this.rubro).ppRubrosCentrocostos(this.centrocostos).ppRubrosCpc(this.cpc).ppRubrosFunteFinanciacion(this.fuenteFinanciacion).idTercero(this.empresa).tipo(Boolean.valueOf(tipoRubro)).observacion(this.JTDetalle.getValueAt(i, 3).toString()).valor(Double.valueOf(this.JTDetalle.getValueAt(i, 2).toString()).doubleValue()).build();
            this.detalleMovimientoService.grabar(detalleMovimiento);
            valorTotal += Double.valueOf(this.JTDetalle.getValueAt(i, 2).toString()).doubleValue();
        }
        this.xMovimiento = this.movimiento.getId().toString();
        try {
            this.iPpMovimientoService.actualizarIdDisponibilidad(Long.valueOf(this.JLB_Registro.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String valorT = String.valueOf(valorTotal);
        this.JTFFValorTotal.setText(valorT.replace(".", ","));
    }

    private void mAbreReintegro() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            if (this.JCBTipoDocumento.getSelectedItem().equals("DISPONIBILIDAD")) {
                if (Double.valueOf(this.modeloDatos.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).doubleValue() > 0.0d) {
                    List<String> listaDatos = new ArrayList<>();
                    for (int i = 0; i < this.JTDetalle.getColumnCount(); i++) {
                        System.out.println("- " + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), i).toString());
                        listaDatos.add(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), i).toString());
                    }
                    JDReintegro x = new JDReintegro((Frame) null, true, (Object) this, this.xIdClaseDoc, Long.valueOf(this.JLB_Registro.getText()), listaDatos);
                    x.setLocationRelativeTo(this);
                    x.setVisible(true);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Este movimiento no tiene saldo disponible para reintegros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void consecutivo() {
        int Con = 0;
        String sql = "SELECT\n\tMAX(NoConcecutivo) AS Consecutivo\nFROM\n\tpp_movimiento pm\nWHERE\n\t(pm.Id_TipoDoc = '" + this.listTipoDocumentos.get(this.JCBTipoDocumento.getSelectedIndex()).getId() + "'\n\t\tAND DATE_FORMAT(pm.FechaD, '%Y')= " + this.metodos.formatoANO.format(this.JDC_FechaD.getDate()) + ")";
        System.out.println("CONSECUTIVO: " + sql);
        ConsultasMySQL consultasMySql1 = new ConsultasMySQL();
        ResultSet consulta1 = consultasMySql1.traerRs(sql);
        try {
            if (consulta1.next()) {
                consulta1.first();
                Con = consulta1.getInt("Consecutivo");
            }
            this.JLConsecutivo.setText("" + (Con + 1));
            consulta1.close();
            consultasMySql1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento_new.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.Consecutivo = Con + 1;
    }

    private void showMessage(String mensaje, int tabIndex, JComponent componente) {
        JOptionPane.showInternalMessageDialog(this, mensaje, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTP_Detalle.setSelectedIndex(tabIndex);
        if (componente != null) {
            componente.requestFocus();
        }
    }

    public void mAnular() {
        System.out.println("");
        if (!this.JLB_Registro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jiffmovimiento_new", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularMovimiento(xIdMot, xObservacion, this.JLB_Registro.getText(), xObservacion);
        Principal.txtEstado.setText("ANULADO");
        System.err.println(Principal.txtEstado.getText());
    }
}
