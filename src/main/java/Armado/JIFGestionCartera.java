package Armado;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.jpa.entities.FEConceptoNotas;
import com.genoma.plus.jpa.entities.FacturaGlosaDetalle;
import com.genoma.plus.jpa.entities.FacturaNota;
import com.genoma.plus.jpa.entities.FacturaNotaDetalle;
import com.genoma.plus.jpa.projection.DetalleGlosa;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.projection.ItemsGlosaNotaCredito;
import com.genoma.plus.jpa.service.FEConceptoNotasService;
import com.genoma.plus.jpa.service.FacturaGlosaDetalleDAO;
import com.genoma.plus.jpa.service.FacturaNotaDetalleService;
import com.genoma.plus.jpa.service.FacturaNotasService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ItemsGlosaNotaCreditoDAO;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFGestionCartera.class */
public class JIFGestionCartera extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodelo4;
    private DefaultTableModel modeloItemsGlosados;
    private DefaultTableModel modeloItemsRespuestaGlosa;
    private String[] xidempresa;
    private String[] xidetapa;
    private String[] xidtipodoc;
    private String[] xidtipodoc_ppt;
    private String[][] xidconceptop;
    private String[][] xidconceptog;
    private String[][] xidconceptod;
    private String[][] xCuenta;
    private String[][] xidperiodo_ppt;
    private String xsql;
    private Object[] xdato;
    private File xfile;
    private File directorio;
    private String[][] xencabezado;
    private GCuentaDAOImpl gcuenta;
    private PresupuestoDAOImpl presupuesto;
    private ContabilidadDAOImpl contabilidad;
    private long xIdDocRespuestaGlosa;
    public List<FacturaGlosaDetalle> listaGlosa;
    private List<FEConceptoNotas> listaConceptoNotas;
    private String idEmpresa;
    private ButtonGroup JBGBuscar;
    private ButtonGroup JBGCJuridico;
    private JButton JBTAdicionar;
    private JButton JBTAdicionar1;
    private JButton JBTAdicionar2;
    private JButton JBTAdicionarG;
    private JButton JBTAdicionarP;
    private JButton JBTAdicionarSoporteR;
    private JButton JBTDevolucion;
    private JButton JBTERespGrabar;
    private JButton JBTExportar;
    private JButton JBTRespAnular;
    private JButton JBTRespImprimir;
    private JComboBox JCBConceptoDevolucion;
    private JComboBox JCBConceptoG;
    private JComboBox JCBConceptoP;
    private JCheckBox JCBDevolucionTotal;
    private JComboBox JCBEProceso;
    private JComboBox JCBEmpresa;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox<String> JCConceptoNota;
    private JCheckBox JCHEsConciliada;
    private JCheckBox JCHEsGrupal;
    private JCheckBox JCHEsReiterada;
    private JCheckBox JCHEsTraslado;
    private JCheckBox JCHEstadoSoporte;
    private JCheckBox JCHFiltro;
    private JCheckBox JCH_AplicaMC;
    private JCheckBox JCH_AplicaMP;
    private JCheckBox JCH_Seleccionar;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFechaDevolucion;
    private JDateChooser JDFechaEnt;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaGlosa;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaPago;
    private JDateChooser JDFechaRGlosa;
    private JDateChooser JDFechaRad;
    private JLabel JLBNRespuesta;
    private JLabel JLValorItemsGlosado;
    private JPanel JPICJuridico;
    private JPanel JPIDContables1;
    private JPanel JPIDRespuesta;
    private JPanel JPIDSoportes;
    private JPanel JPIDatosC;
    private JPanel JPIDatosGlosa;
    private JPanel JPIDatosPago;
    private JPanel JPIDevoluciones;
    private JPanel JPIFDatos;
    private JPanel JPIGlosa;
    private JPanel JPINotaDebito;
    private JPanel JPIPagos;
    private JPanel JPIRespuesta;
    private JPanel JPITotales;
    private JPanel JPI_DatosRad;
    private JPanel JPI_DetalleFac;
    private JPanel JPI_DetalleRad;
    private JPanel JPI_Devoluciones;
    private JPanel JPI_Filtro1;
    private JPanel JPI_InformacionContable;
    private JPanel JPI_Utilizades;
    private JRadioButton JRBCCobro;
    private JRadioButton JRBFactura;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalleG;
    private JScrollPane JSPDetalleP;
    private JScrollPane JSPDetalleS;
    private JScrollPane JSPDetalle_D;
    private JScrollPane JSPHistoricoResp;
    private JScrollPane JSPObsDevolucion;
    private JScrollPane JSPObsGlosa;
    private JScrollPane JSPObsPago;
    private JScrollPane JSPObsRadicacion;
    private JScrollPane JSPObservacionSoporte;
    private JScrollPane JSPRespuesraGlosa;
    private JScrollPane JSPRespuestaSoporte;
    private JTextPane JTAObsDevolucion;
    private JTextPane JTAObsGlosa;
    private JTextPane JTAObsPago;
    private JTextPane JTAObsRadicacion;
    private JTextArea JTAObservacionSoporte;
    private JTextPane JTARespuestaGlosa;
    private JTabbedPane JTBDetalleGlosa;
    private JTabbedPane JTBGestionC;
    private JTable JTDetalleD;
    private JTable JTDetalleG;
    private JTable JTDetalleP;
    private JTable JTDetalleS;
    private JTextField JTFCreditoG;
    private JTextField JTFCreditoSub;
    private JTextField JTFDebitoSub;
    private JTextField JTFFNCuentaC;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFPDiasC;
    public JFormattedTextField JTFFRValorAceptado;
    private JFormattedTextField JTFFRValorGlosado;
    public JFormattedTextField JTFFRValorRecobrado;
    private JFormattedTextField JTFFTotalFac;
    private JFormattedTextField JTFFTotalGlosa;
    private JFormattedTextField JTFFTotalGlosado;
    private JFormattedTextField JTFFTotalPagado;
    private JFormattedTextField JTFFTotalSaldo;
    private JFormattedTextField JTFFValorDevolucion;
    public JFormattedTextField JTFFValorGlosado;
    private JFormattedTextField JTFFValorPagado;
    private JTextField JTFNCCredito;
    private JTextField JTFNCDebito;
    private JTextField JTFNDevolucion;
    private JTextField JTFNGlosa;
    private JTextField JTFNRadi;
    private JTextField JTFRGDebito;
    private JTextField JTFRuta;
    private JTextField JTFRutaSoportePago;
    private JTextField JTFRutaSoporteRad;
    private JTextField JTFSoporteRespuesta;
    private JTextField JTFUrlSoporteDevoluciones;
    private JTextField JTFUrlSoporteGS;
    private JTable JTHistoricoResp;
    private JTable JTItemsGlosados;
    private JTable JTItemsRespuestaGlosa;
    private JTabbedPane JTPDatosRespuesta;
    private JTabbedPane JTPDatosU;
    private JTabbedPane JTPDetalleFa;
    private JTable JTRespuestaSoporte;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JCheckBox jchbNotaSinFactura;
    private ConsultasMySQL xct = new ConsultasMySQL();
    public long xidfactura = 0;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xestadograbadorglosa = false;
    private boolean esFactura = true;
    private String nFactura = "";
    private double xvalorg = 0.0d;
    private int xcjuridico = 0;
    private int xtraslado = 0;
    private int xsoporterespuesta = 0;
    private int xgrabadosoporteRespuesta = 0;
    private int xEsReiterada = 0;
    private long xConsecutivo = 0;
    private long xIdDocGlosa = 0;
    private long xIdDocDevoluciones = 0;
    private String idGlosa = "";
    public List<FacturaNotaDetalle> listaNotaDetalle = new ArrayList();
    private Long idGlosaF = 0L;
    private FacturaGlosaDetalleDAO facturaGlosaDetalle = (FacturaGlosaDetalleDAO) Principal.contexto.getBean(FacturaGlosaDetalleDAO.class);
    private FEConceptoNotasService feConceptoNotasService = (FEConceptoNotasService) Principal.contexto.getBean(FEConceptoNotasService.class);
    private FacturaNotasService facturaNotaService = (FacturaNotasService) Principal.contexto.getBean(FacturaNotasService.class);
    private FacturaNotaDetalleService facturaNotaDetalleService = (FacturaNotaDetalleService) Principal.contexto.getBean(FacturaNotaDetalleService.class);
    private ItemsGlosaNotaCreditoDAO xItemsGlosaNotacredito = (ItemsGlosaNotaCreditoDAO) Principal.contexto.getBean(ItemsGlosaNotaCreditoDAO.class);
    private IResolucionDianDAO resolucionDian = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private FacturaGlosaDetalleDAO xItemsGlosaNotacredit = (FacturaGlosaDetalleDAO) Principal.contexto.getBean(FacturaGlosaDetalleDAO.class);
    private String idFactura = "0";
    private Integer esCapita = 2;
    private Long ingreso = 0L;
    private int idIngreso = 0;

    public JIFGestionCartera() {
        initComponents();
        springStart();
        mNuevo();
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JTBGestionC.remove(3);
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JTBGestionC.remove(2);
            this.JCH_AplicaMP.setSelected(false);
            this.JCH_AplicaMP.setEnabled(false);
        } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JCH_AplicaMC.setSelected(true);
            this.JCH_AplicaMC.setVisible(false);
            this.JCH_AplicaMC.setEnabled(false);
        } else {
            this.JTBGestionC.remove(3);
            this.JTBGestionC.remove(2);
        }
        this.JTBDetalleGlosa.setSelectedIndex(1);
        this.listaGlosa = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r3v275, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v302, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v373, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v402, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v431, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v488, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v545, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGCJuridico = new ButtonGroup();
        this.JBGBuscar = new ButtonGroup();
        this.JTBGestionC = new JTabbedPane();
        this.JPIFDatos = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JTFFPDiasC = new JFormattedTextField();
        this.JTPDetalleFa = new JTabbedPane();
        this.JPI_DetalleFac = new JPanel();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JPITotales = new JPanel();
        this.JTFFTotalFac = new JFormattedTextField();
        this.JTFFTotalGlosado = new JFormattedTextField();
        this.JTFFTotalPagado = new JFormattedTextField();
        this.JTFFTotalSaldo = new JFormattedTextField();
        this.JCH_Seleccionar = new JCheckBox();
        this.JTFFNCuentaC = new JTextField();
        this.JPI_Filtro1 = new JPanel();
        this.JRBFactura = new JRadioButton();
        this.JRBCCobro = new JRadioButton();
        this.JPI_DetalleRad = new JPanel();
        this.JPI_DatosRad = new JPanel();
        this.JPICJuridico = new JPanel();
        this.JRBNo = new JRadioButton();
        this.JRBSi = new JRadioButton();
        this.JCBEProceso = new JComboBox();
        this.JBTAdicionar1 = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFNRadi = new JTextField();
        this.JDFechaEnt = new JDateChooser();
        this.JDFechaRad = new JDateChooser();
        this.JTFRutaSoporteRad = new JTextField();
        this.JCHEsGrupal = new JCheckBox();
        this.JBTAdicionar = new JButton();
        this.JSPObsRadicacion = new JScrollPane();
        this.JTAObsRadicacion = new JTextPane();
        this.JPIGlosa = new JPanel();
        this.JPIDatosGlosa = new JPanel();
        this.JDFechaGlosa = new JDateChooser();
        this.JTFNGlosa = new JTextField();
        this.JCBConceptoG = new JComboBox();
        this.JSPObsGlosa = new JScrollPane();
        this.JTAObsGlosa = new JTextPane();
        this.JTFFValorGlosado = new JFormattedTextField();
        this.JBTAdicionarG = new JButton();
        this.JTFUrlSoporteGS = new JTextField();
        this.JCHEsReiterada = new JCheckBox();
        this.JTBDetalleGlosa = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTItemsGlosados = new JTable();
        this.JLValorItemsGlosado = new JLabel();
        this.JCBDevolucionTotal = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.JSPDetalleG = new JScrollPane();
        this.JTDetalleG = new JTable();
        this.JTFFTotalGlosa = new JFormattedTextField();
        this.JPIRespuesta = new JPanel();
        this.JTPDatosRespuesta = new JTabbedPane();
        this.JPIDRespuesta = new JPanel();
        this.JSPRespuesraGlosa = new JScrollPane();
        this.JTARespuestaGlosa = new JTextPane();
        this.JTFFRValorGlosado = new JFormattedTextField();
        this.JTFFRValorAceptado = new JFormattedTextField();
        this.JTFFRValorRecobrado = new JFormattedTextField();
        this.JDFechaRGlosa = new JDateChooser();
        this.JBTERespGrabar = new JButton();
        this.JLBNRespuesta = new JLabel();
        this.JBTRespAnular = new JButton();
        this.JBTRespImprimir = new JButton();
        this.JCHEsTraslado = new JCheckBox();
        this.JCConceptoNota = new JComboBox<>();
        this.jScrollPane2 = new JScrollPane();
        this.JTItemsRespuestaGlosa = new JTable();
        this.jchbNotaSinFactura = new JCheckBox();
        this.JCHEsConciliada = new JCheckBox();
        this.JPIDSoportes = new JPanel();
        this.JSPRespuestaSoporte = new JScrollPane();
        this.JTRespuestaSoporte = new JTable();
        this.JSPObservacionSoporte = new JScrollPane();
        this.JTAObservacionSoporte = new JTextArea();
        this.JTFSoporteRespuesta = new JTextField();
        this.JBTAdicionarSoporteR = new JButton();
        this.JCHEstadoSoporte = new JCheckBox();
        this.JSPHistoricoResp = new JScrollPane();
        this.JTHistoricoResp = new JTable();
        this.JPIPagos = new JPanel();
        this.JPIDatosPago = new JPanel();
        this.JDFechaPago = new JDateChooser();
        this.JCBConceptoP = new JComboBox();
        this.JTFFValorPagado = new JFormattedTextField();
        this.JSPObsPago = new JScrollPane();
        this.JTAObsPago = new JTextPane();
        this.JBTAdicionarP = new JButton();
        this.JTFRutaSoportePago = new JTextField();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalleP = new JTable();
        this.JPI_Devoluciones = new JPanel();
        this.JPIDevoluciones = new JPanel();
        this.JDFechaDevolucion = new JDateChooser();
        this.JTFNDevolucion = new JTextField();
        this.JCBConceptoDevolucion = new JComboBox();
        this.JSPObsDevolucion = new JScrollPane();
        this.JTAObsDevolucion = new JTextPane();
        this.JTFFValorDevolucion = new JFormattedTextField();
        this.JBTDevolucion = new JButton();
        this.JTFUrlSoporteDevoluciones = new JTextField();
        this.JTFNCDebito = new JTextField();
        this.JTFNCCredito = new JTextField();
        this.JSPDetalle_D = new JScrollPane();
        this.JTDetalleD = new JTable();
        this.JTPDatosU = new JTabbedPane();
        this.JPI_Utilizades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPI_InformacionContable = new JPanel();
        this.JCH_AplicaMC = new JCheckBox();
        this.JCBTipoC = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.JTFDebitoSub = new JTextField();
        this.JTFCreditoSub = new JTextField();
        this.JTFCreditoG = new JTextField();
        this.JTFRGDebito = new JTextField();
        this.JTFFNDoc = new JFormattedTextField();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCH_AplicaMP = new JCheckBox();
        this.JPINotaDebito = new JPanel();
        this.JBTAdicionar2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE CARTERA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestioncartera");
        this.JTBGestionC.setForeground(new Color(0, 103, 0));
        this.JTBGestionC.setFont(new Font("Arial", 1, 14));
        this.JTBGestionC.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.1
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTBGestionCMouseClicked(evt);
            }
        });
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGestionCartera.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionCartera.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGestionCartera.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionCartera.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JTFFPDiasC.setBorder(BorderFactory.createTitledBorder((Border) null, "Días Cartera", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPDiasC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFPDiasC.setHorizontalAlignment(4);
        this.JTFFPDiasC.setFont(new Font("Arial", 1, 12));
        this.JTFFPDiasC.setValue(new Long(0L));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 115, -2).addGap(7, 7, 7).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 565, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPDiasC, -2, 133, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEmpresa, -2, 50, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JTFFPDiasC, -2, 50, -2))).addGap(10, 10, 10)));
        this.JTPDetalleFa.setForeground(Color.red);
        this.JTPDetalleFa.setFont(new Font("Arial", 1, 14));
        this.JTPDetalleFa.setName("");
        this.JTPDetalleFa.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.5
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTPDetalleFaMouseClicked(evt);
            }
        });
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setForeground(new Color(0, 0, 204));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleS.setEditingColumn(1);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setName("");
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.setSelectionMode(0);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.6
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTDetalleSMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIFGestionCartera.this.JTDetalleSMouseEntered(evt);
            }
        });
        this.JTDetalleS.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.7
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTDetalleSKeyPressed(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTDetalleS.getAccessibleContext().setAccessibleName("");
        this.JPITotales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotalFac.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Facturado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalFac.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalFac.setHorizontalAlignment(4);
        this.JTFFTotalFac.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalFac.setValue(new Long(0L));
        this.JTFFTotalGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Glosado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalGlosado.setHorizontalAlignment(4);
        this.JTFFTotalGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalGlosado.setValue(new Long(0L));
        this.JTFFTotalPagado.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Pagado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPagado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalPagado.setHorizontalAlignment(4);
        this.JTFFTotalPagado.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalPagado.setValue(new Long(0L));
        this.JTFFTotalSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldo.setHorizontalAlignment(4);
        this.JTFFTotalSaldo.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalSaldo.setValue(new Long(0L));
        GroupLayout JPITotalesLayout = new GroupLayout(this.JPITotales);
        this.JPITotales.setLayout(JPITotalesLayout);
        JPITotalesLayout.setHorizontalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFTotalFac, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalGlosado, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalPagado, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalSaldo, -2, 130, -2).addGap(27, 27, 27)));
        JPITotalesLayout.setVerticalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFTotalGlosado, GroupLayout.Alignment.LEADING, -1, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalPagado, -1, -1, -2).addComponent(this.JTFFTotalSaldo, -1, -1, -2)).addComponent(this.JTFFTotalFac, -1, -1, -2)).addGap(16, 16, 16)));
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar Todo?");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.8
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        this.JTFFNCuentaC.setFont(new Font("Arial", 1, 12));
        this.JTFFNCuentaC.setHorizontalAlignment(4);
        this.JTFFNCuentaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCuentaC.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.9
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFFNCuentaCFocusLost(evt);
            }
        });
        this.JTFFNCuentaC.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.10
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTFFNCuentaCKeyPressed(evt);
            }
        });
        this.JPI_Filtro1.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGBuscar.add(this.JRBFactura);
        this.JRBFactura.setFont(new Font("Arial", 1, 12));
        this.JRBFactura.setSelected(true);
        this.JRBFactura.setText("Factura");
        this.JRBFactura.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JRBFacturaActionPerformed(evt);
            }
        });
        this.JBGBuscar.add(this.JRBCCobro);
        this.JRBCCobro.setFont(new Font("Arial", 1, 12));
        this.JRBCCobro.setText("Cuenta de Cobro");
        this.JRBCCobro.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.12
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JRBCCobroActionPerformed(evt);
            }
        });
        GroupLayout JPI_Filtro1Layout = new GroupLayout(this.JPI_Filtro1);
        this.JPI_Filtro1.setLayout(JPI_Filtro1Layout);
        JPI_Filtro1Layout.setHorizontalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFactura).addComponent(this.JRBCCobro)).addContainerGap(-1, 32767)));
        JPI_Filtro1Layout.setVerticalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addComponent(this.JRBFactura).addGap(9, 9, 9).addComponent(this.JRBCCobro)));
        GroupLayout JPI_DetalleFacLayout = new GroupLayout(this.JPI_DetalleFac);
        this.JPI_DetalleFac.setLayout(JPI_DetalleFacLayout);
        JPI_DetalleFacLayout.setHorizontalGroup(JPI_DetalleFacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleFacLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleFacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleS, -2, 1013, -2).addGroup(JPI_DetalleFacLayout.createSequentialGroup().addComponent(this.JPITotales, -2, -1, -2).addGap(57, 57, 57).addComponent(this.JPI_Filtro1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DetalleFacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Seleccionar, GroupLayout.Alignment.TRAILING).addComponent(this.JTFFNCuentaC, GroupLayout.Alignment.TRAILING, -2, 140, -2)))).addGap(35, 35, 35)));
        JPI_DetalleFacLayout.setVerticalGroup(JPI_DetalleFacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleFacLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleS, -2, 337, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DetalleFacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleFacLayout.createSequentialGroup().addComponent(this.JTFFNCuentaC, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Seleccionar)).addComponent(this.JPITotales, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JPI_Filtro1, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap()));
        this.JTPDetalleFa.addTab("DETALLE", this.JPI_DetalleFac);
        this.JPI_DatosRad.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR INFORMACIÓN ESTADO DE CUENTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPICJuridico.setBorder(BorderFactory.createTitledBorder((Border) null, "Cobro Jurídico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGCJuridico.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.13
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JRBNoActionPerformed(evt);
            }
        });
        this.JBGCJuridico.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.14
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JRBSiActionPerformed(evt);
            }
        });
        GroupLayout JPICJuridicoLayout = new GroupLayout(this.JPICJuridico);
        this.JPICJuridico.setLayout(JPICJuridicoLayout);
        JPICJuridicoLayout.setHorizontalGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICJuridicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNo, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSi).addGap(20, 20, 20)));
        JPICJuridicoLayout.setVerticalGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICJuridicoLayout.createSequentialGroup().addContainerGap().addGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBSi)).addGap(13, 13, 13)));
        this.JCBEProceso.setFont(new Font("Arial", 1, 12));
        this.JCBEProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Etapa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar1.setText("Actualizar");
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.15
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosRadLayout = new GroupLayout(this.JPI_DatosRad);
        this.JPI_DatosRad.setLayout(JPI_DatosRadLayout);
        JPI_DatosRadLayout.setHorizontalGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRadLayout.createSequentialGroup().addContainerGap().addComponent(this.JPICJuridico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEProceso, -2, 453, -2).addGap(165, 165, 165).addComponent(this.JBTAdicionar1, -2, 185, -2).addContainerGap()));
        JPI_DatosRadLayout.setVerticalGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEProceso, -2, 50, -2).addComponent(this.JBTAdicionar1, -2, 47, -2)).addComponent(this.JPICJuridico, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JTFNRadi.setFont(new Font("Arial", 1, 12));
        this.JTFNRadi.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Entrega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEnt.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEnt.setFont(new Font("Arial", 1, 12));
        this.JDFechaRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Radicado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRad.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRad.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporteRad.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporteRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporteRad.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.16
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFRutaSoporteRadMouseClicked(evt);
            }
        });
        this.JCHEsGrupal.setFont(new Font("Arial", 1, 12));
        this.JCHEsGrupal.setText("Es Grupal?");
        this.JCHEsGrupal.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.17
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHEsGrupalActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.18
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPObsRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsRadicacion.setFont(new Font("Arial", 1, 12));
        this.JSPObsRadicacion.setViewportView(this.JTAObsRadicacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObsRadicacion, -2, 682, -2).addGap(103, 103, 103)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHEsGrupal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.JBTAdicionar, -2, 159, -2).addGap(28, 28, 28)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNRadi, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaEnt, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaRad, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaSoporteRad, -2, 304, -2).addGap(289, 289, 289))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionar, -2, 144, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEsGrupal).addGap(32, 32, 32).addComponent(this.JSPObsRadicacion, -2, 62, -2))).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaEnt, -2, 50, -2).addComponent(this.JTFNRadi, -2, 50, -2).addComponent(this.JDFechaRad, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addComponent(this.JTFRutaSoporteRad, -2, 50, -2)).addContainerGap(84, 32767))));
        GroupLayout JPI_DetalleRadLayout = new GroupLayout(this.JPI_DetalleRad);
        this.JPI_DetalleRad.setLayout(JPI_DetalleRadLayout);
        JPI_DetalleRadLayout.setHorizontalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 975, -2).addComponent(this.JPI_DatosRad, -2, -1, -2)).addContainerGap()));
        JPI_DetalleRadLayout.setVerticalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(129, 129, 129).addComponent(this.JPI_DatosRad, -2, -1, -2).addGap(52, 52, 52)));
        this.JTPDetalleFa.addTab("RADICACIÓN", this.JPI_DetalleRad);
        GroupLayout JPIFDatosLayout = new GroupLayout(this.JPIFDatos);
        this.JPIFDatos.setLayout(JPIFDatosLayout);
        JPIFDatosLayout.setHorizontalGroup(JPIFDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIFDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JTPDetalleFa, -2, 1039, -2)).addContainerGap()));
        JPIFDatosLayout.setVerticalGroup(JPIFDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDetalleFa, -2, -1, -2).addContainerGap()));
        this.JTPDetalleFa.getAccessibleContext().setAccessibleName("DETALLE");
        this.JTBGestionC.addTab("FACTURAS", this.JPIFDatos);
        this.JPIDatosGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaGlosa.setDateFormatString("dd/MM/yyyy");
        this.JDFechaGlosa.setFont(new Font("Arial", 1, 12));
        this.JTFNGlosa.setFont(new Font("Arial", 1, 12));
        this.JTFNGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoG.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoG.addItemListener(new ItemListener() { // from class: Armado.JIFGestionCartera.19
            public void itemStateChanged(ItemEvent evt) {
                JIFGestionCartera.this.JCBConceptoGItemStateChanged(evt);
            }
        });
        this.JSPObsGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsGlosa.setFont(new Font("Arial", 1, 12));
        this.JTAObsGlosa.setMaximumSize(new Dimension(508, 508));
        this.JTAObsGlosa.setName("");
        this.JTAObsGlosa.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.20
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTAObsGlosaFocusLost(evt);
            }
        });
        this.JSPObsGlosa.setViewportView(this.JTAObsGlosa);
        this.JTFFValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorGlosado.setHorizontalAlignment(4);
        this.JTFFValorGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFValorGlosado.setValue(new Long(0L));
        this.JTFFValorGlosado.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.21
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFFValorGlosadoFocusLost(evt);
            }
        });
        this.JTFFValorGlosado.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.22
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JTFFValorGlosadoActionPerformed(evt);
            }
        });
        this.JTFFValorGlosado.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.23
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTFFValorGlosadoKeyPressed(evt);
            }
        });
        this.JBTAdicionarG.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarG.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarG.setText("Grabar");
        this.JBTAdicionarG.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.24
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionarGActionPerformed(evt);
            }
        });
        this.JTFUrlSoporteGS.setFont(new Font("Arial", 1, 12));
        this.JTFUrlSoporteGS.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUrlSoporteGS.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.25
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFUrlSoporteGSMouseClicked(evt);
            }
        });
        this.JCHEsReiterada.setFont(new Font("Arial", 1, 12));
        this.JCHEsReiterada.setText("Es Reiterada?");
        this.JCHEsReiterada.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.26
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHEsReiteradaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosGlosaLayout = new GroupLayout(this.JPIDatosGlosa);
        this.JPIDatosGlosa.setLayout(JPIDatosGlosaLayout);
        JPIDatosGlosaLayout.setHorizontalGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addComponent(this.JDFechaGlosa, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNGlosa, -2, 125, -2)).addComponent(this.JTFUrlSoporteGS, -2, 250, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addComponent(this.JCBConceptoG, -2, 429, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorGlosado, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsReiterada)).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addComponent(this.JSPObsGlosa, -2, 549, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarG, -2, 130, -2))).addContainerGap(16, 32767)));
        JPIDatosGlosaLayout.setVerticalGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNGlosa, -2, 50, -2).addComponent(this.JCBConceptoG, -2, 50, -2).addComponent(this.JTFFValorGlosado, -2, 50, -2).addComponent(this.JCHEsReiterada)).addComponent(this.JDFechaGlosa, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosGlosaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFUrlSoporteGS, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JSPObsGlosa, GroupLayout.Alignment.LEADING, -2, 49, -2))).addGroup(JPIDatosGlosaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarG, -2, 54, -2)))));
        this.JTBDetalleGlosa.setForeground(new Color(0, 103, 0));
        this.JTBDetalleGlosa.setFont(new Font("Arial", 1, 14));
        this.JTItemsGlosados.setFont(new Font("Arial", 1, 12));
        this.JTItemsGlosados.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTItemsGlosados.setSelectionMode(0);
        this.JTItemsGlosados.addInputMethodListener(new InputMethodListener() { // from class: Armado.JIFGestionCartera.27
            public void caretPositionChanged(InputMethodEvent evt) {
                JIFGestionCartera.this.JTItemsGlosadosCaretPositionChanged(evt);
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
            }
        });
        this.JTItemsGlosados.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGestionCartera.28
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionCartera.this.JTItemsGlosadosPropertyChange(evt);
            }
        });
        this.JTItemsGlosados.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.29
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTItemsGlosadosKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTItemsGlosados);
        this.JLValorItemsGlosado.setFont(new Font("Arial", 1, 12));
        this.JLValorItemsGlosado.setHorizontalAlignment(4);
        this.JLValorItemsGlosado.setText("0");
        this.JLValorItemsGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Glosado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDevolucionTotal.setFont(new Font("Arial", 1, 12));
        this.JCBDevolucionTotal.setText("Devolucion Total");
        this.JCBDevolucionTotal.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.30
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCBDevolucionTotalActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBDevolucionTotal).addGap(70, 70, 70).addComponent(this.JLValorItemsGlosado, -2, 152, -2).addGap(48, 48, 48)).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 998, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 345, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JCBDevolucionTotal)).addGroup(jPanel5Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLValorItemsGlosado, -2, 44, -2))).addContainerGap()));
        this.JTBDetalleGlosa.addTab("ITEMS GLOSADOS", this.jPanel5);
        this.JSPDetalleG.setFont(new Font("Arial", 1, 12));
        this.JTDetalleG.setFont(new Font("Arial", 1, 12));
        this.JTDetalleG.setForeground(new Color(0, 0, 204));
        this.JTDetalleG.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleG.setEditingColumn(1);
        this.JTDetalleG.setEditingRow(1);
        this.JTDetalleG.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleG.setSelectionForeground(Color.red);
        this.JTDetalleG.setSelectionMode(0);
        this.JTDetalleG.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.31
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTDetalleGMouseClicked(evt);
            }
        });
        this.JSPDetalleG.setViewportView(this.JTDetalleG);
        this.JTFFTotalGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Glosas", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalGlosa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalGlosa.setHorizontalAlignment(4);
        this.JTFFTotalGlosa.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalGlosa.setValue(new Long(0L));
        this.JTFFTotalGlosa.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.32
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFFTotalGlosaFocusLost(evt);
            }
        });
        this.JTFFTotalGlosa.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.33
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JTFFTotalGlosaActionPerformed(evt);
            }
        });
        this.JTFFTotalGlosa.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.34
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTFFTotalGlosaKeyPressed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFTotalGlosa, -2, 127, -2).addContainerGap()).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleG, -2, 1010, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleG, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, 32767).addComponent(this.JTFFTotalGlosa, -2, 52, -2)));
        this.JTBDetalleGlosa.addTab("HISTORICO DE GLOSA", this.jPanel3);
        this.JTPDatosRespuesta.setForeground(Color.red);
        this.JTPDatosRespuesta.setFont(new Font("Arial", 1, 14));
        this.JSPRespuesraGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTARespuestaGlosa.setFont(new Font("Arial", 1, 12));
        this.JSPRespuesraGlosa.setViewportView(this.JTARespuestaGlosa);
        this.JTFFRValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Glosado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFRValorGlosado.setHorizontalAlignment(4);
        this.JTFFRValorGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorGlosado.setValue(new Long(0L));
        this.JTFFRValorGlosado.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.35
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JTFFRValorGlosadoActionPerformed(evt);
            }
        });
        this.JTFFRValorGlosado.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.36
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTFFRValorGlosadoKeyPressed(evt);
            }
        });
        this.JTFFRValorAceptado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Aceptado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorAceptado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFRValorAceptado.setHorizontalAlignment(4);
        this.JTFFRValorAceptado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorAceptado.setValue(new Long(0L));
        this.JTFFRValorAceptado.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.37
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFFRValorAceptadoFocusLost(evt);
            }
        });
        this.JTFFRValorAceptado.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.38
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JTFFRValorAceptadoActionPerformed(evt);
            }
        });
        this.JTFFRValorAceptado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGestionCartera.39
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionCartera.this.JTFFRValorAceptadoPropertyChange(evt);
            }
        });
        this.JTFFRValorAceptado.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.40
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JTFFRValorAceptadoKeyPressed(evt);
            }
        });
        this.JTFFRValorRecobrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor a Recobrar", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorRecobrado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFRValorRecobrado.setHorizontalAlignment(4);
        this.JTFFRValorRecobrado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorRecobrado.setValue(new Long(0L));
        this.JDFechaRGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRGlosa.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRGlosa.setEnabled(false);
        this.JDFechaRGlosa.setFont(new Font("Arial", 1, 12));
        this.JBTERespGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTERespGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTERespGrabar.setText("Grabar");
        this.JBTERespGrabar.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.41
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTERespGrabarActionPerformed(evt);
            }
        });
        this.JLBNRespuesta.setFont(new Font("Arial", 1, 18));
        this.JLBNRespuesta.setHorizontalAlignment(0);
        this.JLBNRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTRespAnular.setFont(new Font("Arial", 1, 12));
        this.JBTRespAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTRespAnular.setText("Anular");
        this.JBTRespAnular.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.42
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTRespAnularActionPerformed(evt);
            }
        });
        this.JBTRespImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTRespImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTRespImprimir.setText("Imprimir");
        this.JBTRespImprimir.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.43
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTRespImprimirActionPerformed(evt);
            }
        });
        this.JCHEsTraslado.setFont(new Font("Arial", 1, 12));
        this.JCHEsTraslado.setText("Es Traslado?");
        this.JCHEsTraslado.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.44
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHEsTrasladoActionPerformed(evt);
            }
        });
        this.JCConceptoNota.setFont(new Font("Arial", 1, 12));
        this.JCConceptoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCConceptoNota.addItemListener(new ItemListener() { // from class: Armado.JIFGestionCartera.45
            public void itemStateChanged(ItemEvent evt) {
                JIFGestionCartera.this.JCConceptoNotaItemStateChanged(evt);
            }
        });
        this.JTItemsRespuestaGlosa.setFont(new Font("Arial", 1, 10));
        this.JTItemsRespuestaGlosa.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTItemsRespuestaGlosa.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGestionCartera.46
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionCartera.this.JTItemsRespuestaGlosaPropertyChange(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTItemsRespuestaGlosa);
        this.jchbNotaSinFactura.setFont(new Font("Arial", 1, 12));
        this.jchbNotaSinFactura.setText("Nota Sin Factura");
        this.jchbNotaSinFactura.setToolTipText("Notas Créditos sin Factura relacionada");
        this.jchbNotaSinFactura.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.47
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.jchbNotaSinFacturaActionPerformed(evt);
            }
        });
        this.JCHEsConciliada.setText("Es Conciliada?");
        this.JCHEsConciliada.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.48
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHEsConciliadaActionPerformed(evt);
            }
        });
        GroupLayout JPIDRespuestaLayout = new GroupLayout(this.JPIDRespuesta);
        this.JPIDRespuesta.setLayout(JPIDRespuestaLayout);
        JPIDRespuestaLayout.setHorizontalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPRespuesraGlosa, -2, 999, -2).addGroup(JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JBTERespGrabar, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRespAnular, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRespImprimir, -2, 227, -2).addGap(44, 44, 44).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jchbNotaSinFactura, -2, 130, -2).addComponent(this.JCHEsTraslado, -2, 113, -2).addComponent(this.JCHEsConciliada))).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JTFFRValorGlosado, -2, 161, -2).addGap(18, 18, 18).addComponent(this.JTFFRValorAceptado, -2, 161, -2).addGap(18, 18, 18).addComponent(this.JTFFRValorRecobrado, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaRGlosa, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCConceptoNota, -2, 196, -2).addGap(139, 139, 139))).addContainerGap(31, 32767)).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBNRespuesta, -2, 119, -2).addComponent(this.jScrollPane2, -2, 998, -2)).addGap(0, 0, 32767)));
        JPIDRespuestaLayout.setVerticalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPRespuesraGlosa, -2, 81, -2).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGap(30, 30, 30).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFRValorGlosado, -2, -1, -2).addComponent(this.JTFFRValorAceptado, -2, -1, -2).addComponent(this.JTFFRValorRecobrado, -2, -1, -2)).addGap(27, 27, 27)).addGroup(GroupLayout.Alignment.LEADING, JPIDRespuestaLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCConceptoNota, -2, 48, -2).addComponent(this.JDFechaRGlosa, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTERespGrabar, -2, 56, -2).addComponent(this.JBTRespAnular, -2, 56, -2).addComponent(this.JBTRespImprimir, -2, 56, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNRespuesta, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsConciliada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsTraslado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jchbNotaSinFactura))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 111, -2).addContainerGap(-1, 32767)));
        this.JTPDatosRespuesta.addTab("RESPUESTA", this.JPIDRespuesta);
        this.JSPRespuestaSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRespuestaSoporte.setSelectionBackground(Color.white);
        this.JTRespuestaSoporte.setSelectionForeground(Color.red);
        this.JTRespuestaSoporte.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.49
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTRespuestaSoporteMouseClicked(evt);
            }
        });
        this.JSPRespuestaSoporte.setViewportView(this.JTRespuestaSoporte);
        this.JSPObservacionSoporte.setViewportBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionSoporte.setColumns(20);
        this.JTAObservacionSoporte.setRows(5);
        this.JSPObservacionSoporte.setViewportView(this.JTAObservacionSoporte);
        this.JTFSoporteRespuesta.setFont(new Font("Arial", 1, 12));
        this.JTFSoporteRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSoporteRespuesta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.50
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFSoporteRespuestaMouseClicked(evt);
            }
        });
        this.JBTAdicionarSoporteR.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarSoporteR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarSoporteR.setText("Grabar");
        this.JBTAdicionarSoporteR.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.51
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionarSoporteRActionPerformed(evt);
            }
        });
        this.JCHEstadoSoporte.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSoporte.setSelected(true);
        this.JCHEstadoSoporte.setText("Estado");
        this.JCHEstadoSoporte.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.52
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JCHEstadoSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPIDSoportesLayout = new GroupLayout(this.JPIDSoportes);
        this.JPIDSoportes.setLayout(JPIDSoportesLayout);
        JPIDSoportesLayout.setHorizontalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSoportesLayout.createSequentialGroup().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSoportesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacionSoporte).addComponent(this.JSPRespuestaSoporte, -1, 1020, 32767))).addGroup(JPIDSoportesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFSoporteRespuesta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarSoporteR, -2, 137, -2))).addContainerGap()));
        JPIDSoportesLayout.setVerticalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFSoporteRespuesta, -2, 50, -2).addComponent(this.JBTAdicionarSoporteR, -2, 53, -2).addComponent(this.JCHEstadoSoporte)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObservacionSoporte, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespuestaSoporte, -2, 130, -2).addContainerGap()));
        this.JTPDatosRespuesta.addTab("SOPORTES", this.JPIDSoportes);
        this.JSPHistoricoResp.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoResp.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoResp.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoResp.setEditingColumn(1);
        this.JTHistoricoResp.setEditingRow(1);
        this.JTHistoricoResp.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoResp.setSelectionForeground(Color.red);
        this.JTHistoricoResp.setSelectionMode(0);
        this.JTHistoricoResp.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.53
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTHistoricoRespMouseClicked(evt);
            }
        });
        this.JSPHistoricoResp.setViewportView(this.JTHistoricoResp);
        this.JTPDatosRespuesta.addTab("HISTÓRICO", this.JSPHistoricoResp);
        GroupLayout JPIRespuestaLayout = new GroupLayout(this.JPIRespuesta);
        this.JPIRespuesta.setLayout(JPIRespuestaLayout);
        JPIRespuestaLayout.setHorizontalGroup(JPIRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRespuestaLayout.createSequentialGroup().addComponent(this.JTPDatosRespuesta, -2, 1036, -2).addGap(0, 0, 32767)));
        JPIRespuestaLayout.setVerticalGroup(JPIRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRespuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosRespuesta, -2, 388, -2).addContainerGap(-1, 32767)));
        this.JTBDetalleGlosa.addTab("RESPUESTA", this.JPIRespuesta);
        GroupLayout JPIGlosaLayout = new GroupLayout(this.JPIGlosa);
        this.JPIGlosa.setLayout(JPIGlosaLayout);
        JPIGlosaLayout.setHorizontalGroup(JPIGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGlosaLayout.createSequentialGroup().addContainerGap().addGroup(JPIGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosGlosa, -2, -1, -2).addComponent(this.JTBDetalleGlosa, -2, 1031, -2)).addContainerGap(26, 32767)));
        JPIGlosaLayout.setVerticalGroup(JPIGlosaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGlosaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosGlosa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBDetalleGlosa, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTBGestionC.addTab("GLOSA", this.JPIGlosa);
        this.JPIDatosPago.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaPago.setDateFormatString("dd/MM/yyyy");
        this.JDFechaPago.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoP.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoP.addItemListener(new ItemListener() { // from class: Armado.JIFGestionCartera.54
            public void itemStateChanged(ItemEvent evt) {
                JIFGestionCartera.this.JCBConceptoPItemStateChanged(evt);
            }
        });
        this.JTFFValorPagado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPagado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPagado.setHorizontalAlignment(4);
        this.JTFFValorPagado.setFont(new Font("Arial", 1, 14));
        this.JTFFValorPagado.setValue(new Long(0L));
        this.JSPObsPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsPago.setFont(new Font("Arial", 1, 12));
        this.JTAObsPago.setFont(new Font("Arial", 1, 12));
        this.JSPObsPago.setViewportView(this.JTAObsPago);
        this.JBTAdicionarP.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarP.setText("Grabar");
        this.JBTAdicionarP.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.55
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionarPActionPerformed(evt);
            }
        });
        this.JTFRutaSoportePago.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoportePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoportePago.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.56
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFRutaSoportePagoMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosPagoLayout = new GroupLayout(this.JPIDatosPago);
        this.JPIDatosPago.setLayout(JPIDatosPagoLayout);
        JPIDatosPagoLayout.setHorizontalGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addComponent(this.JDFechaPago, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConceptoP, -2, 458, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorPagado, -2, 127, -2).addGap(0, 124, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPagoLayout.createSequentialGroup().addComponent(this.JTFRutaSoportePago).addGap(21, 21, 21).addComponent(this.JSPObsPago, -2, 392, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarP, -2, 179, -2).addContainerGap()));
        JPIDatosPagoLayout.setVerticalGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarP, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPIDatosPagoLayout.createSequentialGroup().addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBConceptoP, -2, 50, -2).addComponent(this.JDFechaPago, -2, 50, -2).addComponent(this.JTFFValorPagado, GroupLayout.Alignment.LEADING)).addGap(11, 11, 11).addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsPago, -2, -1, -2).addComponent(this.JTFRutaSoportePago)))).addContainerGap()));
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setForeground(new Color(0, 0, 204));
        this.JTDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleP.setEditingColumn(1);
        this.JTDetalleP.setEditingRow(1);
        this.JTDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleP.setSelectionForeground(Color.red);
        this.JTDetalleP.setSelectionMode(0);
        this.JTDetalleP.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.57
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTDetallePMouseClicked(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTDetalleP);
        GroupLayout JPIPagosLayout = new GroupLayout(this.JPIPagos);
        this.JPIPagos.setLayout(JPIPagosLayout);
        JPIPagosLayout.setHorizontalGroup(JPIPagosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPagosLayout.createSequentialGroup().addContainerGap().addGroup(JPIPagosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleP, GroupLayout.Alignment.LEADING, -1, 1051, 32767).addComponent(this.JPIDatosPago, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPIPagosLayout.setVerticalGroup(JPIPagosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPagosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosPago, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleP, -1, 436, 32767).addContainerGap()));
        this.JTBGestionC.addTab("PAGOS", this.JPIPagos);
        this.JPIDevoluciones.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaDevolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaDevolucion.setDateFormatString("dd/MM/yyyy");
        this.JDFechaDevolucion.setFont(new Font("Arial", 1, 12));
        this.JTFNDevolucion.setFont(new Font("Arial", 1, 12));
        this.JTFNDevolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoDevolucion.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoDevolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoDevolucion.addItemListener(new ItemListener() { // from class: Armado.JIFGestionCartera.58
            public void itemStateChanged(ItemEvent evt) {
                JIFGestionCartera.this.JCBConceptoDevolucionItemStateChanged(evt);
            }
        });
        this.JSPObsDevolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsDevolucion.setFont(new Font("Arial", 1, 12));
        this.JSPObsDevolucion.setViewportView(this.JTAObsDevolucion);
        this.JTFFValorDevolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorDevolucion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDevolucion.setHorizontalAlignment(4);
        this.JTFFValorDevolucion.setFont(new Font("Arial", 1, 14));
        this.JTFFValorDevolucion.setValue(new Long(0L));
        this.JBTDevolucion.setFont(new Font("Arial", 1, 12));
        this.JBTDevolucion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTDevolucion.setText("Grabar");
        this.JBTDevolucion.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.59
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTDevolucionActionPerformed(evt);
            }
        });
        this.JTFUrlSoporteDevoluciones.setFont(new Font("Arial", 1, 12));
        this.JTFUrlSoporteDevoluciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUrlSoporteDevoluciones.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.60
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFUrlSoporteDevolucionesMouseClicked(evt);
            }
        });
        this.JTFNCDebito.setFont(new Font("Arial", 1, 12));
        this.JTFNCDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCCredito.setFont(new Font("Arial", 1, 12));
        this.JTFNCCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Credito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDevolucionesLayout = new GroupLayout(this.JPIDevoluciones);
        this.JPIDevoluciones.setLayout(JPIDevolucionesLayout);
        JPIDevolucionesLayout.setHorizontalGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDevolucionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDevolucionesLayout.createSequentialGroup().addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDevolucionesLayout.createSequentialGroup().addComponent(this.JDFechaDevolucion, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNDevolucion, -2, 125, -2)).addComponent(this.JTFUrlSoporteDevoluciones, -2, 250, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConceptoDevolucion, -2, 508, -2)).addGroup(JPIDevolucionesLayout.createSequentialGroup().addComponent(this.JTFNCDebito, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JTFNCCredito, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObsDevolucion))).addGap(24, 24, 24).addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTDevolucion, -2, 130, -2).addComponent(this.JTFFValorDevolucion, -2, 127, -2)).addContainerGap(113, 32767)));
        JPIDevolucionesLayout.setVerticalGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDevolucionesLayout.createSequentialGroup().addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDevolucionesLayout.createSequentialGroup().addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDevolucion).addComponent(this.JCBConceptoDevolucion, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDevolucionesLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JDFechaDevolucion, -2, 50, -2))).addGap(11, 11, 11).addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDevolucionesLayout.createSequentialGroup().addGroup(JPIDevolucionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCDebito, -1, 51, 32767).addComponent(this.JTFNCCredito, -1, 51, 32767)).addGap(18, 18, 18).addComponent(this.JTFUrlSoporteDevoluciones, -2, -1, -2)).addComponent(this.JSPObsDevolucion))).addGroup(JPIDevolucionesLayout.createSequentialGroup().addComponent(this.JTFFValorDevolucion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDevolucion, -1, -1, 32767))).addContainerGap()));
        this.JSPDetalle_D.setFont(new Font("Arial", 1, 12));
        this.JTDetalleD.setFont(new Font("Arial", 1, 12));
        this.JTDetalleD.setForeground(new Color(0, 0, 204));
        this.JTDetalleD.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleD.setEditingColumn(1);
        this.JTDetalleD.setEditingRow(1);
        this.JTDetalleD.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleD.setSelectionForeground(Color.red);
        this.JTDetalleD.setSelectionMode(0);
        this.JTDetalleD.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.61
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTDetalleDMouseClicked(evt);
            }
        });
        this.JSPDetalle_D.setViewportView(this.JTDetalleD);
        GroupLayout JPI_DevolucionesLayout = new GroupLayout(this.JPI_Devoluciones);
        this.JPI_Devoluciones.setLayout(JPI_DevolucionesLayout);
        JPI_DevolucionesLayout.setHorizontalGroup(JPI_DevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DevolucionesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDevoluciones, -1, -1, 32767).addComponent(this.JSPDetalle_D)).addContainerGap()));
        JPI_DevolucionesLayout.setVerticalGroup(JPI_DevolucionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DevolucionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDevoluciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle_D, -1, 373, 32767).addContainerGap()));
        this.JTBGestionC.addTab("DEVOLUCIONES", this.JPI_Devoluciones);
        this.JTPDatosU.setForeground(Color.red);
        this.JTPDatosU.setFont(new Font("Arial", 1, 14));
        this.JPI_Utilizades.setForeground(Color.red);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.62
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.63
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilizadesLayout = new GroupLayout(this.JPI_Utilizades);
        this.JPI_Utilizades.setLayout(JPI_UtilizadesLayout);
        JPI_UtilizadesLayout.setHorizontalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilizadesLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JTFRuta, -2, 660, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 188, -2).addContainerGap()));
        JPI_UtilizadesLayout.setVerticalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilizadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(78, 78, 78)));
        this.JTPDatosU.addTab("UTILIDADES", this.JPI_Utilizades);
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica?");
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTO DE CUENTAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFDebitoSub.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoSub.setToolTipText("");
        this.JTFDebitoSub.setBorder(BorderFactory.createTitledBorder((Border) null, "Subsanable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoSub.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.64
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFDebitoSubFocusLost(evt);
            }
        });
        this.JTFDebitoSub.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.65
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFDebitoSubMouseClicked(evt);
            }
        });
        this.JTFCreditoSub.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoSub.setToolTipText("");
        this.JTFCreditoSub.setBorder(BorderFactory.createTitledBorder((Border) null, "No Subsanable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoSub.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.66
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFCreditoSubFocusLost(evt);
            }
        });
        this.JTFCreditoSub.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.67
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFCreditoSubMouseClicked(evt);
            }
        });
        this.JTFCreditoG.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoG.setToolTipText("");
        this.JTFCreditoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Generacion Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoG.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.68
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFCreditoGFocusLost(evt);
            }
        });
        this.JTFCreditoG.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.69
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFCreditoGMouseClicked(evt);
            }
        });
        this.JTFRGDebito.setFont(new Font("Arial", 1, 12));
        this.JTFRGDebito.setToolTipText("");
        this.JTFRGDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Rad. Glosa Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRGDebito.addFocusListener(new FocusAdapter() { // from class: Armado.JIFGestionCartera.70
            public void focusLost(FocusEvent evt) {
                JIFGestionCartera.this.JTFRGDebitoFocusLost(evt);
            }
        });
        this.JTFRGDebito.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGestionCartera.71
            public void mouseClicked(MouseEvent evt) {
                JIFGestionCartera.this.JTFRGDebitoMouseClicked(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFDebitoSub, -2, 140, -2).addComponent(this.JTFCreditoG, -2, 140, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRGDebito, -2, 140, -2).addComponent(this.JTFCreditoSub, -2, 140, -2)).addGap(10, 10, 10)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoSub, -2, 40, -2).addComponent(this.JTFRGDebito, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCreditoG, -2, 40, -2).addComponent(this.JTFCreditoSub, -2, 40, -2)).addGap(15, 15, 15)));
        this.JTFFNDoc.setEditable(false);
        this.JTFFNDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc.setHorizontalAlignment(0);
        this.JTFFNDoc.setFont(new Font("Arial", 1, 18));
        GroupLayout JPI_InformacionContableLayout = new GroupLayout(this.JPI_InformacionContable);
        this.JPI_InformacionContable.setLayout(JPI_InformacionContableLayout);
        JPI_InformacionContableLayout.setHorizontalGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 112, -2).addGap(14, 14, 14).addComponent(this.JCH_AplicaMC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoC, -2, 438, -2)).addComponent(this.JTFFNDoc, -2, 140, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(40, 40, 40)));
        JPI_InformacionContableLayout.setVerticalGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionContableLayout.createSequentialGroup().addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionContableLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionContableLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionContableLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JDFFechaC, -2, 50, -2)).addGroup(JPI_InformacionContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JCH_AplicaMC))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNDoc, -1, -1, -2))).addGap(8, 8, 8)));
        this.JTPDatosU.addTab("DATOS CONTABLES", this.JPI_InformacionContable);
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
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMP).addGap(31, 31, 31).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addGap(297, 297, 297).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addContainerGap()));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt)).addGroup(JPIDContables1Layout.createSequentialGroup().addComponent(this.JCH_AplicaMP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, -2))).addGap(71, 71, 71)));
        this.JTPDatosU.addTab("DATOS PRESUPUESTALES", this.JPIDContables1);
        this.JBTAdicionar2.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/d_autoriza.png")));
        this.JBTAdicionar2.setText("Nota (Debito)");
        this.JBTAdicionar2.addActionListener(new ActionListener() { // from class: Armado.JIFGestionCartera.72
            public void actionPerformed(ActionEvent evt) {
                JIFGestionCartera.this.JBTAdicionar2ActionPerformed(evt);
            }
        });
        this.JBTAdicionar2.addKeyListener(new KeyAdapter() { // from class: Armado.JIFGestionCartera.73
            public void keyPressed(KeyEvent evt) {
                JIFGestionCartera.this.JBTAdicionar2KeyPressed(evt);
            }
        });
        GroupLayout JPINotaDebitoLayout = new GroupLayout(this.JPINotaDebito);
        this.JPINotaDebito.setLayout(JPINotaDebitoLayout);
        JPINotaDebitoLayout.setHorizontalGroup(JPINotaDebitoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotaDebitoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTAdicionar2, -2, 239, -2).addContainerGap(822, 32767)));
        JPINotaDebitoLayout.setVerticalGroup(JPINotaDebitoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotaDebitoLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.JBTAdicionar2, -2, 50, -2).addContainerGap(60, 32767)));
        this.JTPDatosU.addTab("UTILIDADES", this.JPINotaDebito);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTBGestionC).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosU, -2, 0, 32767).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTBGestionC, -2, 640, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosU, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            mNuevaRadica();
            mNuevaGlosa();
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 9).toString()).booleanValue()) {
                this.JTFNRadi.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 10).toString());
                this.JDFechaEnt.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 11).toString()));
                this.JDFechaRad.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 12).toString()));
                this.JTAObsRadicacion.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 14).toString());
                this.JTFRutaSoporteRad.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 24).toString());
                this.idFactura = this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 45).toString();
                this.idEmpresa = this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 30).toString();
                System.out.println("idEmpresa -> " + this.idEmpresa);
                if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 25).toString()).intValue() == 0) {
                    this.JRBNo.setSelected(true);
                    this.xcjuridico = 0;
                } else {
                    this.JRBSi.setSelected(true);
                    this.xcjuridico = 1;
                }
                this.JCBEProceso.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 26).toString());
                this.JTFNCDebito.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 37).toString());
                this.JTFNCCredito.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 38).toString());
                this.JTFRGDebito.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 32).toString());
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    this.JTFDebitoSub.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 33).toString());
                    this.JTFCreditoSub.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 29).toString());
                    this.JTFCreditoG.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 35).toString());
                } else {
                    this.JTFCreditoSub.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 29).toString());
                    this.JTFDebitoSub.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 33).toString());
                    this.JTFCreditoG.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 40).toString());
                }
                this.listaGlosa = new ArrayList();
                mBucarDetallePagos();
                mBucarDetalleGlosas();
            } else {
                this.JTFDebitoSub.setText("");
                this.JTFRGDebito.setText("");
                this.JTFCreditoG.setText("");
                this.JTFCreditoSub.setText("");
                JOptionPane.showInternalMessageDialog(this, "Factura No Radicada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            this.ingreso = Long.valueOf(Long.parseLong(this.JTDetalleS.getValueAt(this.JTDetalleS.getSelectedRow(), 44).toString()));
            this.idFactura = this.JTDetalleS.getValueAt(this.JTDetalleS.getSelectedRow(), 45).toString();
            this.esCapita = Integer.valueOf(Integer.parseInt(this.JTDetalleS.getValueAt(this.JTDetalleS.getSelectedRow(), 46).toString()));
            this.nFactura = this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString();
            System.out.println("el numero es de " + this.nFactura);
            cargarDatosItemsGlosa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JCHEsGrupal.isSelected()) {
            if (this.JTDetalleS.getSelectedRow() != -1) {
                if (this.JCH_AplicaMC.isSelected()) {
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || (!this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 28).toString().equals("") && !this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 29).toString().equals(""))) {
                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                mGrabarRadicacionSimple();
                                mBucarDetalleFact();
                                return;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Faltan parametrizacion de cuentas contables para radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDetalleFa.setSelectedIndex(0);
                    return;
                }
                mGrabarRadicacionSimple();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleS, 0)) {
            if (!this.JTFNRadi.getText().isEmpty()) {
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                    if (this.JCH_AplicaMC.isSelected()) {
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || (!this.xmt.mVerificarDatosLLeno(this.JTDetalleS, 28) && !this.xmt.mVerificarDatosLLeno(this.JTDetalleS, 29))) {
                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (y == 0) {
                                        mGrabarRadicacionAgrupada();
                                        mBucarDetalleFact();
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Faltan parametrizacion de cuentas contables para radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPDetalleFa.setSelectedIndex(0);
                        return;
                    }
                    int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y2 == 0) {
                        mGrabarRadicacionAgrupada();
                        mBucarDetalleFact();
                        return;
                    }
                    return;
                }
                int y3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y3 == 0) {
                    mGrabarRadicacionAgrupada();
                    mBucarDetalleFact();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "En N° Radicación no debe ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNRadi.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existen registro(s) seleccionado(s)", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarPActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 9).toString()).booleanValue()) {
                if (this.JCBConceptoP.getSelectedIndex() == -1) {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBConceptoP.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JTFFValorPagado.getValue().toString()).doubleValue() > 0.0d) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        this.xsql = "insert into f_factura_pagos(Id_PeriodoC, Id_Liquidacion, Id_ConceptoPago, FechaAbono, Valor, UrlSoporte, Observacion, UsuarioS) values('" + Principal.xclase.getXidperiodoc() + "','" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "','" + this.xidconceptop[this.JCBConceptoP.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.JDFechaPago.getDate()) + "','" + this.JTFFValorPagado.getValue() + "','" + this.JTFRutaSoportePago.getText() + "','" + this.JTAObsPago.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        this.xsql = "update f_liquidacion set TPagado=TPagado+" + this.JTFFValorPagado.getValue() + ", FechaUltimoPago='" + this.xmt.formatoAMD.format(this.JDFechaPago.getDate()) + "' where Id='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mBucarDetallePagos();
                        mNuevoPago();
                        this.JDFechaPago.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta registrar el valor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValorPagado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta registro de datos de radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBGestionC.setSelectedIndex(0);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBGestionC.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePMouseClicked(MouseEvent evt) {
        if (this.JTDetalleP.getSelectedRow() != -1 && !this.xmodelo1.getValueAt(this.JTDetalleP.getSelectedRow(), 6).toString().equals("")) {
            this.xmt.mostrarPdf(this.xmodelo1.getValueAt(this.JTDetalleP.getSelectedRow(), 6).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarGActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 9).toString()).booleanValue()) {
                if (this.JCBConceptoG.getSelectedIndex() == -1) {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBConceptoG.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue() > 0.0d) {
                    if (this.JCHEsReiterada.isSelected()) {
                        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (y == 0) {
                            mGrabar_Glosa();
                            mBucarDetallePagos();
                            mBucarDetalleGlosas();
                            mNuevaGlosa();
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                        return;
                    }
                    if (this.JCH_AplicaMC.isSelected()) {
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || (!this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 32).toString().equals("") && !this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 33).toString().equals(""))) {
                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                if (Principal.xclase.mValidarFechasDoc(this.JDFechaGlosa.getDate())) {
                                    int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (y2 == 0) {
                                        if (!Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && this.JCH_AplicaMC.isSelected()) {
                                            mGenerarDocContableGlosa(this.JTDetalleS.getSelectedRow());
                                        }
                                        mGrabar_Glosa();
                                        mBucarDetallePagos();
                                        mBucarDetalleGlosas();
                                        mNuevaGlosa();
                                        this.JDFechaPago.requestFocus();
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Faltan parametrizacion de cuentas contables para radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPDetalleFa.setSelectedIndex(0);
                        return;
                    }
                    int y3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y3 == 0) {
                        mGrabar_Glosa();
                        mBucarDetallePagos();
                        mBucarDetalleGlosas();
                        mNuevaGlosa();
                        this.JDFechaPago.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta registrar el valor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValorGlosado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta registro de datos de radicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBGestionC.setSelectedIndex(0);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBGestionC.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleGMouseClicked(MouseEvent evt) {
        this.idGlosaF = Long.valueOf(Long.parseLong(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 0).toString()));
        if (this.JTDetalleG.getSelectedColumn() != 11) {
            this.xmodelo2.setValueAt(true, this.JTDetalleG.getSelectedRow(), 11);
        }
        if (evt.getClickCount() == 2) {
            mBucarHistoricoRespuestaGlosas();
            if (this.JTDetalleG.getSelectedRow() != -1 && this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 7).equals("")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea generar respuesta?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.jchbNotaSinFactura.setSelected(false);
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mNuevaRespuestaGlosa();
                        System.out.println("idIngreso cargar -> " + this.idIngreso);
                        if (this.idIngreso == 0) {
                            System.out.println("conceptos");
                            cargarDatosBienestar();
                        } else {
                            System.out.println("pacientes");
                            cargarDatosBienestarP();
                        }
                        this.JTBDetalleGlosa.setSelectedIndex(2);
                        this.JTFFValorGlosado.setValue(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 4));
                        this.JTARespuestaGlosa.requestFocus();
                        return;
                    }
                    mNuevaRespuestaGlosa();
                    cargarDatos();
                    this.JTBDetalleGlosa.setSelectedIndex(2);
                    this.JTFFValorGlosado.setValue(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 4));
                    this.JTARespuestaGlosa.requestFocus();
                    return;
                }
                return;
            }
            Object[] botones = {"Generar Respuesta", "Visualizar Soporte", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "CONFIRMAR", 0, 3, (Icon) null, botones, "Cerrar");
            if (n == 0) {
                mNuevaRespuestaGlosa();
                cargarDatos();
                this.JTBDetalleGlosa.setSelectedIndex(2);
                this.JTFFValorGlosado.setValue(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 4));
                this.JTARespuestaGlosa.requestFocus();
                return;
            }
            if (n == 1) {
                this.xmt.mostrarPdf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 7).toString());
                return;
            }
            return;
        }
        if (this.JTDetalleG.getSelectedRow() != -1) {
            this.idGlosa = "";
            for (int x2 = 0; x2 < this.JTDetalleG.getRowCount(); x2++) {
                if (Boolean.valueOf(this.xmodelo2.getValueAt(x2, 11).toString()).booleanValue()) {
                    this.idGlosa += "," + this.JTDetalleG.getValueAt(x2, 0).toString();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoGItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBConceptoG.getSelectedIndex() != -1) {
            if (this.xidconceptog[this.JCBConceptoG.getSelectedIndex()][2].equals("2")) {
                this.JCH_AplicaMC.setSelected(false);
            } else {
                this.JCH_AplicaMC.setSelected(true);
            }
        }
    }

    private void cargarDatosItemsGlosa() {
        List<ItemsGlosaNotaCredito> listaItemsGlosa;
        this.JCBDevolucionTotal.setSelected(false);
        crearModeloItemsGlosa();
        List<ItemsGlosaNotaCredito> listaCirugia = new ArrayList<>();
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosaSaludIntegral(this.idFactura);
            if (listaItemsGlosa.size() == 0) {
                listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosa(this.idFactura);
            }
        } else if (this.esCapita.intValue() == 1) {
            listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosa(this.idFactura);
        } else {
            listaItemsGlosa = this.xItemsGlosaNotacredito.listaItems(this.ingreso);
            if (listaItemsGlosa.isEmpty()) {
                listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosa(this.idFactura);
            }
            listaCirugia = this.xItemsGlosaNotacredito.listaItemsCirugia(this.idFactura);
        }
        int fila = 0;
        for (int j = 0; j < listaItemsGlosa.size(); j++) {
            this.modeloItemsGlosados.addRow(this.xdato);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getIdOrden(), fila, 0);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getNombreServicio(), fila, 1);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getNombreItems(), fila, 2);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getCantidad(), fila, 3);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getValorUnitario(), fila, 4);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getValorDescuento(), fila, 5);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getPorcentajeImpuesto(), fila, 6);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getValorImpuesto(), fila, 7);
            this.modeloItemsGlosados.setValueAt(Double.valueOf(((listaItemsGlosa.get(fila).getValorUnitario().doubleValue() * listaItemsGlosa.get(fila).getCantidad().doubleValue()) + listaItemsGlosa.get(fila).getValorImpuesto().doubleValue()) - listaItemsGlosa.get(fila).getValorDescuento().doubleValue()), fila, 8);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getIdSuminsitroProcedimiento(), fila, 9);
            this.modeloItemsGlosados.setValueAt(listaItemsGlosa.get(fila).getIdTipoServicio(), fila, 10);
            this.modeloItemsGlosados.setValueAt(false, fila, 11);
            this.modeloItemsGlosados.setValueAt(0, fila, 12);
            this.modeloItemsGlosados.setValueAt("", fila, 13);
            fila++;
        }
        for (int j2 = 0; j2 < listaCirugia.size(); j2++) {
            this.modeloItemsGlosados.addRow(this.xdato);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getIdOrden(), fila, 0);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getNombreServicio(), fila, 1);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getNombreItems(), fila, 2);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getCantidad(), fila, 3);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getValorUnitario(), fila, 4);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getValorDescuento(), fila, 5);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getPorcentajeImpuesto(), fila, 6);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getValorImpuesto(), fila, 7);
            this.modeloItemsGlosados.setValueAt(Double.valueOf(((listaCirugia.get(j2).getValorUnitario().doubleValue() * listaCirugia.get(j2).getCantidad().doubleValue()) + listaCirugia.get(j2).getValorImpuesto().doubleValue()) - listaCirugia.get(j2).getValorDescuento().doubleValue()), fila, 8);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getIdSuminsitroProcedimiento(), fila, 9);
            this.modeloItemsGlosados.setValueAt(listaCirugia.get(j2).getIdTipoServicio(), fila, 10);
            this.modeloItemsGlosados.setValueAt(false, fila, 11);
            this.modeloItemsGlosados.setValueAt(0, fila, 12);
            this.modeloItemsGlosados.setValueAt("", fila, 13);
            fila++;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloItemsGlosa() {
        this.modeloItemsGlosados = new DefaultTableModel(new Object[0], new String[]{"idOrden", "NombreServicio", "NombreItem", "Cantidad", "VrUnitario", "VrDescuento", "%Impuesto", "VrImpuesto", "VrTotal", "idSuministroxprocedimiento", "idTipoServicio", "Selecionar", "VrGlosado", "Observacion"}) { // from class: Armado.JIFGestionCartera.74
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class, String.class, Boolean.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false, false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTItemsGlosados.setModel(this.modeloItemsGlosados);
        this.JTItemsGlosados.setAutoResizeMode(0);
        this.JTItemsGlosados.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTItemsGlosados.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTItemsGlosados.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTItemsGlosados.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTItemsGlosados.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTItemsGlosados.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTItemsGlosados.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTItemsGlosados.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTItemsGlosados.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTItemsGlosados.getColumnModel().getColumn(11).setPreferredWidth(70);
        this.JTItemsGlosados.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTItemsGlosados.getColumnModel().getColumn(13).setPreferredWidth(280);
        this.xmt.mEstablecerTextEditor(this.JTItemsGlosados, 2);
        this.xmt.mEstablecerTextEditor(this.JTItemsGlosados, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoPItemStateChanged(ItemEvent evt) {
        if (this.xlleno1) {
            if (this.JTDetalleS.getSelectedRow() != -1 && this.JCBConceptoP.getSelectedIndex() != -1) {
                if (this.xidconceptop[this.JCBConceptoP.getSelectedIndex()][1].equals("1")) {
                    this.JTFFValorPagado.setValue(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15));
                    return;
                } else {
                    this.JTFFValorPagado.setValue(new Double(0.0d));
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBGestionC.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleS.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFUrlSoporteGSMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\Soporte Glosas GP\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFUrlSoporteGS.setText(this.xfile.getAbsolutePath());
                this.JTFUrlSoporteGS.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoActionPerformed(ActionEvent evt) {
        mCalcularVRespuestaGlosa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoFocusLost(FocusEvent evt) {
        mCalcularVRespuestaGlosa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTERespGrabarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleG.getSelectedRow() != -1) {
            if (!this.JTARespuestaGlosa.getText().isEmpty()) {
                if (this.JLBNRespuesta.getText().isEmpty()) {
                    if (mValidarValoresRespuesta()) {
                        if (Boolean.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 10).toString()).booleanValue()) {
                            if (this.JCH_AplicaMC.isSelected()) {
                                if (this.JCBTipoC.getSelectedIndex() != -1) {
                                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || (mVerificaUltNivel(this.JTFDebitoSub.getText()) && mVerificaUltNivel(this.JTFRGDebito.getText()) && mVerificaUltNivel(this.JTFCreditoG.getText()) && mVerificaUltNivel(this.JTFCreditoSub.getText()))) {
                                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            if (x == 0) {
                                                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                                    mGenerarDocContableRespuestaGlosaBienestar(this.JTDetalleS.getSelectedRow());
                                                } else if (this.JCH_AplicaMC.isSelected()) {
                                                    mGenerarDocContableRespuestaGlosa(this.JTDetalleS.getSelectedRow());
                                                }
                                                mGrabar_RespuestaGlosa();
                                                mActualizarLiquidacionRespuestaGlosa();
                                                mBucarHistoricoRespuestaGlosas();
                                                guardarPresupuesto();
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
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x2 == 0) {
                                mGrabar_RespuestaGlosa();
                                mActualizarLiquidacionRespuestaGlosa();
                                mBucarHistoricoRespuestaGlosas();
                                return;
                            }
                            return;
                        }
                        if (this.JCH_AplicaMC.isSelected()) {
                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || (mVerificaUltNivel(this.JTFDebitoSub.getText()) && mVerificaUltNivel(this.JTFRGDebito.getText()) && mVerificaUltNivel(this.JTFCreditoG.getText()) && mVerificaUltNivel(this.JTFCreditoSub.getText()))) {
                                        int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (x3 == 0) {
                                            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                                mGenerarDocContableRespuestaGlosaBienestar(this.JTDetalleS.getSelectedRow());
                                            } else if (this.JCH_AplicaMC.isSelected()) {
                                                mGenerarDocContableRespuestaGlosa(this.JTDetalleS.getSelectedRow());
                                            }
                                            mGrabar_RespuestaGlosa();
                                            mActualizarLiquidacionRespuestaGlosa();
                                            mBucarHistoricoRespuestaGlosas();
                                            guardarPresupuesto();
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
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x4 == 0) {
                            mGrabar_RespuestaGlosa();
                            mActualizarLiquidacionRespuestaGlosa();
                            mBucarHistoricoRespuestaGlosas();
                            guardarPresupuesto();
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Respuesta ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Respuesta no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTARespuestaGlosa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una glosa a responder", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBDetalleGlosa.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoRespMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoResp.getSelectedRow() != -1) {
            this.JLBNRespuesta.setText(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 0).toString());
            this.JDFechaRGlosa.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 1).toString()));
            this.JTARespuestaGlosa.setText(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 2).toString());
            this.JTFFRValorGlosado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 3).toString()));
            this.JTFFRValorAceptado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 4).toString()));
            this.JTFFRValorRecobrado.setValue(Double.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 5).toString()));
            this.JCHEsTraslado.setSelected(Boolean.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEsTraslado.isSelected()) {
                this.xtraslado = 1;
            } else {
                this.xtraslado = 0;
            }
            this.jchbNotaSinFactura.setSelected(Boolean.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 8).toString()).booleanValue());
            mBucarSoporteRespuestaGlosas();
            this.JTPDatosRespuesta.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRespAnularActionPerformed(ActionEvent evt) {
        if (this.JLBNRespuesta.getText().isEmpty()) {
            return;
        }
        if (Long.valueOf(this.xmodelo3.getValueAt(this.JTHistoricoResp.getSelectedRow(), 7).toString()).longValue() == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (!this.JLBNRespuesta.getText().isEmpty()) {
                    String sql = "SELECT `f_factura_notas`.`id` AS factura FROM `f_factura_notas` \nINNER JOIN `f_factura_glosa` \nON (`f_factura_glosa`.`Id_Liquidacion`=`f_factura_notas`.`idLiquidacion`)\nINNER JOIN `f_factura_glosa_respuesta` \nON (`f_factura_glosa_respuesta`.`Id_Factura_glosa`=`f_factura_glosa`.`Id`)\nWHERE `f_factura_glosa_respuesta`.`Id` = '" + this.JLBNRespuesta.getText() + "'";
                    System.out.println("consulta -> " + sql);
                    int resultado = 0;
                    ResultSet rs = this.xct.traerRs(sql);
                    try {
                        if (rs.next()) {
                            rs.first();
                            resultado = rs.getInt("factura");
                            System.out.println("resultado -> " + resultado);
                        }
                        rs.close();
                        this.xct.cerrarConexionBd();
                    } catch (Exception e) {
                    }
                    String xsql = "update f_factura_notas set estado=0 where Id='" + resultado + "'";
                    String xsql1 = "update f_factura_nota_detalle set estado = 0 where idFacturaNota = '" + resultado + "'";
                    this.xct.ejecutarSQL(xsql);
                    this.xct.ejecutarSQL(xsql1);
                    this.xct.cerrarConexionBd();
                    System.out.println("" + xsql + "\n " + xsql1);
                }
                Anular frm = new Anular(null, true, "Anular Respuesta Glosa", 5);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Respuesta Glosa Con Documento Contable Activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBDetalleGlosa.setSelectedIndex(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRespImprimirActionPerformed(ActionEvent evt) {
        if (!this.JLBNRespuesta.getText().isEmpty()) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRespuesta.getText();
            mparametros[1][0] = "usuarioSiste";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[4][0] = "NUM_FACTURA";
            mparametros[4][1] = this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 45).toString();
            mparametros[5][0] = "idGlosa";
            mparametros[5][1] = this.idGlosa.substring(1, this.idGlosa.length());
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa", mparametros);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa_2", mparametros);
                return;
            }
            Object[] botones = {"Individual", "Por Glosa", "Por Factura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que información desea visualizar?", "IMPRESIÓN RESPUESTA GLOSA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (n) {
                case 0:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3_IdRespuesta", mparametros);
                    break;
                case 1:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3_IdGlosa", mparametros);
                    break;
                case 2:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3", mparametros);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoFocusLost(FocusEvent evt) {
        mValidarVGlosado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoActionPerformed(ActionEvent evt) {
        this.JTFFValorGlosado.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorGlosadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 18 || evt.getKeyCode() == 10) {
            this.JTFFValorGlosado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporteRadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTFRutaSoporteRad.getText().isEmpty()) {
                JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\");
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    this.xfile = xfilec.getSelectedFile();
                    this.JTFRutaSoporteRad.setText(this.xfile.getAbsolutePath());
                    this.JTFRutaSoporteRad.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
                    return;
                }
                return;
            }
            Object[] botones = {"Visualizar", "Cargar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "SOPORTE", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xmt.mostrarPdf(this.JTFRutaSoporteRad.getText());
                return;
            }
            JFileChooser xfilec2 = new JFileChooser("S:\\FACTURACION\\");
            int xv2 = xfilec2.showOpenDialog(this);
            if (xv2 == 0) {
                this.xfile = xfilec2.getSelectedFile();
                this.JTFRutaSoporteRad.setText(this.xfile.getAbsolutePath());
                this.JTFRutaSoporteRad.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoportePagoMouseClicked(MouseEvent evt) {
        JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\");
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            this.xfile = xfilec.getSelectedFile();
            this.JTFRutaSoportePago.setText(this.xfile.getAbsolutePath());
            this.JTFRutaSoportePago.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (this.JCBEProceso.getSelectedIndex() != -1) {
                this.xsql = "update f_factura_evento set CJuridico='" + this.xcjuridico + "', NRadicado='" + this.JTFNRadi.getText() + "', FechaEntrega='" + this.xmt.formatoAMD.format(this.JDFechaEnt.getDate()) + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + this.JTAObsRadicacion.getText() + "', UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', IdEtapaProcedo='" + this.xidetapa[this.JCBEProceso.getSelectedIndex()] + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar etapa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEProceso.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xcjuridico = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xcjuridico = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorGlosadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFFRValorAceptado.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFFRValorAceptado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCH_Seleccionar.isSelected()) {
            mSeleccionar(true);
            this.JCHEsGrupal.setSelected(true);
        } else {
            mSeleccionar(false);
            this.JCHEsGrupal.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNCuentaCFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNCuentaCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFacturaActionPerformed(ActionEvent evt) {
        this.esFactura = true;
        this.JTFFNCuentaC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCCobroActionPerformed(ActionEvent evt) {
        this.esFactura = false;
        this.JTFFNCuentaC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsTrasladoActionPerformed(ActionEvent evt) {
        if (this.JCHEsTraslado.isSelected()) {
            this.xtraslado = 1;
        } else {
            this.xtraslado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoDevolucionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDevolucionActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (this.JCBConceptoDevolucion.getSelectedIndex() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConceptoDevolucion.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFValorDevolucion.getValue().toString()).doubleValue() > 0.0d) {
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                    if (this.JCH_AplicaMC.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                            if (this.JCBTipoC.getSelectedIndex() != -1) {
                                mGenerarDocContableDevolucion(this.JTDetalleS.getSelectedRow());
                                mGrabar_Devolucion();
                                mNuevaDevoluciones();
                                return;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTPDatosU.setSelectedIndex(1);
                                this.JCBTipoC.requestFocus();
                                return;
                            }
                        }
                        JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTPDatosU.setSelectedIndex(1);
                        this.JDFFechaC.requestFocus();
                        return;
                    }
                    mGrabar_Devolucion();
                    return;
                }
                mGrabar_Devolucion();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta registrar el valor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValorDevolucion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBGestionC.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFUrlSoporteDevolucionesMouseClicked(MouseEvent evt) {
        JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\");
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            this.xfile = xfilec.getSelectedFile();
            this.JTFUrlSoporteDevoluciones.setText(this.xfile.getAbsolutePath());
            this.JTFUrlSoporteDevoluciones.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarSoporteRActionPerformed(ActionEvent evt) {
        if (!this.JLBNRespuesta.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xgrabadosoporteRespuesta == 1) {
                    this.xct.ejecutarSQL("UPDATE `f_factura_glosa_respuesta_soporte`\nSET\n  `Observacion` = '" + this.JTAObservacionSoporte.getText() + "',\n  `Estado` = '" + this.xsoporterespuesta + "',\n  `Id_UsuarioR` = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\nWHERE `Id` = '" + this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 0) + "';");
                    this.xct.cerrarConexionBd();
                } else {
                    File directorio = new File(this.xmt.mRutaSoporte("JPSoporteRespuestaG"));
                    String xidDoc = this.xct.ejecutarSQLId("INSERT INTO `f_factura_glosa_respuesta_soporte` (`Id_Respuesta`,`Observacion`,`Estado`,`Id_UsuarioR`)\nVALUES('" + this.JLBNRespuesta.getText() + "','" + this.JTAObservacionSoporte.getText() + "','" + this.xsoporterespuesta + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "');");
                    String adjunto = xidDoc + "_" + this.JLBNRespuesta.getText() + ".pdf";
                    String sql = "UPDATE f_factura_glosa_respuesta_soporte set UrlSoporte='" + this.xmt.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    File f1 = new File(this.JTFSoporteRespuesta.getText());
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(directorio, f2.getName()));
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mNuevoRespuestaSoporte();
                }
                mBucarSoporteRespuestaGlosas();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Respuesta no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTARespuestaGlosa.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsGrupalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSoporteActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoSoporte.isSelected()) {
            this.xsoporterespuesta = 1;
        } else {
            this.xsoporterespuesta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRespuestaSoporteMouseClicked(MouseEvent evt) {
        if (this.JTRespuestaSoporte.getSelectedRow() != -1) {
            this.JTAObservacionSoporte.setText(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 1).toString());
            this.JTFSoporteRespuesta.setText(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstadoSoporte.setSelected(true);
                this.xsoporterespuesta = 1;
            } else {
                this.JCHEstadoSoporte.setSelected(false);
                this.xsoporterespuesta = 0;
            }
            this.xgrabadosoporteRespuesta = 1;
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo4.getValueAt(this.JTRespuestaSoporte.getSelectedRow(), 2).toString();
                this.xmt.mostrarPdf(this.directorio + "\\" + rutaa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSoporteRespuestaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFSoporteRespuesta.setText(this.xfile.getAbsolutePath());
                this.JTFSoporteRespuesta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoSubFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoSub.getText().isEmpty() && !mVerificaUltNivel(this.JTFDebitoSub.getText())) {
            this.JTFDebitoSub.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoSubMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoSubFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoSub.getText().isEmpty() && !mVerificaUltNivel(this.JTFCreditoSub.getText())) {
            this.JTFCreditoSub.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoSubMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoG.getText().isEmpty() && !mVerificaUltNivel(this.JTFCreditoG.getText())) {
            this.JTFCreditoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRGDebitoFocusLost(FocusEvent evt) {
        if (!this.JTFRGDebito.getText().isEmpty() && !mVerificaUltNivel(this.JTFRGDebito.getText())) {
            this.JTFRGDebito.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRGDebitoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCBEmpresa.removeAllItems();
            List<GCGenericoDTO> list1 = this.gcuenta.listadoEmpresaCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            this.xidempresa = new String[list1.size()];
            for (int x = 0; x < list1.size(); x++) {
                this.xidempresa[x] = String.valueOf(list1.get(x).getId());
                this.JCBEmpresa.addItem(list1.get(x).getNombre());
            }
            this.JCBEmpresa.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObsGlosaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalGlosaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalGlosaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalGlosaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsReiteradaActionPerformed(ActionEvent evt) {
        if (this.JCHEsReiterada.isSelected()) {
            this.xEsReiterada = 1;
        } else {
            this.xEsReiterada = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTFFRValorAceptado.getValue() != null) {
            mCalcularVRespuestaGlosa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTItemsGlosadosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTItemsGlosadosPropertyChange(PropertyChangeEvent evt) {
        if (this.JTItemsGlosados.getSelectedRow() != -1) {
            totalizarItemsGlosa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTItemsRespuestaGlosaPropertyChange(PropertyChangeEvent evt) {
        if (this.JTItemsRespuestaGlosa.getRowCount() > 0 && this.JTItemsRespuestaGlosa.getSelectedRow() != -1) {
            Double suma = Double.valueOf(0.0d);
            for (int j = 0; j < this.JTItemsRespuestaGlosa.getRowCount(); j++) {
                suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(j, 6).toString()));
                if (Double.parseDouble(this.modeloItemsRespuestaGlosa.getValueAt(j, 2).toString()) != 0.0d) {
                    this.modeloItemsRespuestaGlosa.setValueAt(Double.valueOf(Double.parseDouble(this.modeloItemsRespuestaGlosa.getValueAt(j, 6).toString()) / Double.parseDouble(this.modeloItemsRespuestaGlosa.getValueAt(j, 2).toString())), j, 10);
                }
            }
            this.JTFFRValorAceptado.setValue(suma);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDevolucionTotalActionPerformed(ActionEvent evt) {
        if (this.JCBDevolucionTotal.isSelected()) {
            double total = 0.0d;
            for (int x = 0; x < this.JTItemsGlosados.getRowCount(); x++) {
                this.modeloItemsGlosados.setValueAt(this.modeloItemsGlosados.getValueAt(x, 8), x, 12);
                this.modeloItemsGlosados.setValueAt(true, x, 11);
                System.out.println("modeloItemsGlosados.getValueAt(x, 8) -> " + this.modeloItemsGlosados.getValueAt(x, 8));
                total += Double.valueOf(this.modeloItemsGlosados.getValueAt(x, 8).toString()).doubleValue();
                this.JTFFValorGlosado.setValue(Double.valueOf(total));
                totalizarItemsGlosa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar2ActionPerformed(ActionEvent evt) {
        JD_NotasP notas = new JD_NotasP(null, true, String.valueOf(this.idFactura), String.valueOf(this.nFactura));
        notas.setLocationRelativeTo(this);
        notas.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetalleFaMouseClicked(MouseEvent evt) {
        if (this.JTPDetalleFa.getSelectedIndex() == 1 && this.JTBGestionC.getSelectedIndex() == 0) {
            this.JCBTipoC.setSelectedItem("RADICACION");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBGestionCMouseClicked(MouseEvent evt) {
        if (this.JTBGestionC.getSelectedIndex() == 1) {
            this.JCBTipoC.setSelectedItem("GLOSA");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchbNotaSinFacturaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorGlosadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTItemsGlosadosCaretPositionChanged(InputMethodEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsConciliadaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCConceptoNotaItemStateChanged(ItemEvent evt) {
        if (!this.listaConceptoNotas.isEmpty()) {
            Double suma = Double.valueOf(0.0d);
            for (int j = 0; j < this.JTItemsRespuestaGlosa.getRowCount(); j++) {
                if (this.JCConceptoNota.getSelectedItem().equals("Anulación de factura electrónica")) {
                    this.modeloItemsRespuestaGlosa.setValueAt(Double.valueOf(Double.parseDouble(this.modeloItemsRespuestaGlosa.getValueAt(j, 3).toString())), j, 6);
                    this.modeloItemsRespuestaGlosa.setValueAt(Double.valueOf(Double.parseDouble(this.modeloItemsRespuestaGlosa.getValueAt(j, 3).toString())), j, 10);
                    suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(j, 6).toString()));
                }
            }
            this.JTFFRValorAceptado.setValue(suma);
        }
    }

    private void totalizarItemsGlosa() {
        Double suma = Double.valueOf(0.0d);
        for (int j = 0; j < this.JTItemsGlosados.getRowCount(); j++) {
            if (((Boolean) this.JTItemsGlosados.getValueAt(j, 11)).booleanValue()) {
                Double.valueOf(Double.parseDouble(this.modeloItemsGlosados.getValueAt(j, 3).toString()) * Double.parseDouble(this.modeloItemsGlosados.getValueAt(j, 4).toString()));
                suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.JTItemsGlosados.getValueAt(j, 12).toString()));
            }
        }
        this.JLValorItemsGlosado.setText("" + suma);
    }

    private void mSeleccionar(boolean xestado) {
        for (int x = 0; x < this.JTDetalleS.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 23).toString().equals(this.JTFFNCuentaC.getText()) && !this.JTFFNCuentaC.getText().isEmpty()) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 0);
            } else {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 0);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloItemsRespuestaGlosa() {
        this.modeloItemsRespuestaGlosa = new DefaultTableModel(new Object[0], new String[]{"idGlosa", "NombreItem", "Cantidad", "valorGlosa", "idSuministroxprocedimiento", "idTipoServicio", "VrAceptado", "VrARecobrar", "Observacion", "esCapita", "valorUnitario", "%Impuesto"}) { // from class: Armado.JIFGestionCartera.75
            Class[] types = {Long.class, String.class, Integer.class, Double.class, Long.class, Integer.class, Double.class, Double.class, String.class, Integer.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, true, false, false, false, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTItemsRespuestaGlosa.setModel(this.modeloItemsRespuestaGlosa);
        this.JTItemsRespuestaGlosa.setAutoResizeMode(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(8).setPreferredWidth(380);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setMinWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setMaxWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.xmt.mEstablecerTextEditor(this.JTItemsRespuestaGlosa, 1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloItemsRespuestaGlosaBienestar() {
        this.modeloItemsRespuestaGlosa = new DefaultTableModel(new Object[0], new String[]{"idGlosa", "NombreItem", "Cantidad", "valorGlosa", "idSuministroxprocedimiento", "idTipoServicio", "VrAceptado", "VrARecobrar", "Observacion", "esCapita", "valorUnitario", "%Impuesto", "Nbre", "CCredito", "CDebito"}) { // from class: Armado.JIFGestionCartera.76
            Class[] types = {Long.class, String.class, Integer.class, Double.class, Long.class, Integer.class, Integer.class, Double.class, String.class, Integer.class, Double.class, Double.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, true, false, false, false, true, true, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTItemsRespuestaGlosa.setModel(this.modeloItemsRespuestaGlosa);
        this.JTItemsRespuestaGlosa.setAutoResizeMode(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(8).setPreferredWidth(380);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setMinWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setMaxWidth(30);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.xmt.mEstablecerTextEditor(this.JTItemsRespuestaGlosa, 1);
    }

    private void cargarDatos() {
        crearModeloItemsRespuestaGlosa();
        if (this.JTDetalleG.getSelectedRow() != -1) {
            List<DetalleGlosa> listaItemsGlosa = this.xItemsGlosaNotacredit.listaGlosa(Long.valueOf(Long.parseLong(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 0).toString())));
            for (int j = 0; j < listaItemsGlosa.size(); j++) {
                this.modeloItemsRespuestaGlosa.addRow(this.xdato);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdFactura(), j, 0);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getItem(), j, 1);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getCantidad(), j, 2);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getValorGlosado(), j, 3);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdCodigo(), j, 4);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getTipo(), j, 5);
                this.modeloItemsRespuestaGlosa.setValueAt(0, j, 6);
                this.modeloItemsRespuestaGlosa.setValueAt(0, j, 7);
                this.modeloItemsRespuestaGlosa.setValueAt("", j, 8);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getEsCapita(), j, 9);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getPorcentajeImpuesto(), j, 11);
            }
        }
    }

    private void cargarDatosBienestar() {
        crearModeloItemsRespuestaGlosaBienestar();
        if (this.JTDetalleG.getSelectedRow() != -1) {
            List<DetalleGlosa> listaItemsGlosa = this.xItemsGlosaNotacredit.listaGlosaBienestar(Long.valueOf(Long.parseLong(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 0).toString())));
            if (!listaItemsGlosa.isEmpty()) {
                if (listaItemsGlosa.get(0).getNbre() != null) {
                    for (int j = 0; j < listaItemsGlosa.size(); j++) {
                        this.modeloItemsRespuestaGlosa.addRow(this.xdato);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdFactura(), j, 0);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getItem(), j, 1);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getCantidad(), j, 2);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getValorGlosado(), j, 3);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdCodigo(), j, 4);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getTipo(), j, 5);
                        this.modeloItemsRespuestaGlosa.setValueAt(0, j, 6);
                        this.modeloItemsRespuestaGlosa.setValueAt(0, j, 7);
                        this.modeloItemsRespuestaGlosa.setValueAt("", j, 8);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getEsCapita(), j, 9);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getPorcentajeImpuesto(), j, 11);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getNbre(), j, 12);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdPucCredito(), j, 13);
                        this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdPucDebito(), j, 14);
                    }
                    return;
                }
                List<DetalleGlosa> listaItemsGlosaCapita = this.xItemsGlosaNotacredit.listaGlosaBienestarCapita(Long.valueOf(Long.parseLong(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 0).toString())));
                System.out.println("entroo :    " + listaItemsGlosaCapita.size());
                for (int j2 = 0; j2 < listaItemsGlosaCapita.size(); j2++) {
                    this.modeloItemsRespuestaGlosa.addRow(this.xdato);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getIdFactura(), j2, 0);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getItem(), j2, 1);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getCantidad(), j2, 2);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getValorGlosado(), j2, 3);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getIdCodigo(), j2, 4);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getTipo(), j2, 5);
                    this.modeloItemsRespuestaGlosa.setValueAt(0, j2, 6);
                    this.modeloItemsRespuestaGlosa.setValueAt(0, j2, 7);
                    this.modeloItemsRespuestaGlosa.setValueAt("", j2, 8);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getEsCapita(), j2, 9);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getPorcentajeImpuesto(), j2, 11);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getNbre(), j2, 12);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getIdPucCredito(), j2, 13);
                    this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosaCapita.get(j2).getIdPucDebito(), j2, 14);
                }
            }
        }
    }

    private void cargarDatosBienestarP() {
        crearModeloItemsRespuestaGlosaBienestar();
        if (this.JTDetalleG.getSelectedRow() != -1) {
            List<DetalleGlosa> listaItemsGlosa = this.xItemsGlosaNotacredit.listaGlosaBienestarP(Long.valueOf(Long.parseLong(this.JTDetalleG.getValueAt(this.JTDetalleG.getSelectedRow(), 0).toString())));
            for (int j = 0; j < listaItemsGlosa.size(); j++) {
                this.modeloItemsRespuestaGlosa.addRow(this.xdato);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdFactura(), j, 0);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getItem(), j, 1);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getCantidad(), j, 2);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getValorGlosado(), j, 3);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getIdCodigo(), j, 4);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getTipo(), j, 5);
                this.modeloItemsRespuestaGlosa.setValueAt(0, j, 6);
                this.modeloItemsRespuestaGlosa.setValueAt(0, j, 7);
                this.modeloItemsRespuestaGlosa.setValueAt("", j, 8);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getEsCapita(), j, 9);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getPorcentajeImpuesto(), j, 11);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getNbre(), j, 12);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getCCredito(), j, 13);
                this.modeloItemsRespuestaGlosa.setValueAt(listaItemsGlosa.get(j).getCDebito(), j, 14);
            }
        }
    }

    private void mGrabarRadicacionSimple() {
        if (!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 9).toString()).booleanValue()) {
            if (!this.JTFNRadi.getText().isEmpty()) {
                int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y == 0) {
                    this.xsql = "update f_factura_evento set NRadicado='" + this.JTFNRadi.getText() + "', FechaEntrega='" + this.xmt.formatoAMD.format(this.JDFechaEnt.getDate()) + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + quitarSaltos(this.JTAObsRadicacion.getText()) + "', UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
                    System.out.println("factura evento -> " + this.xsql);
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    if (this.JCH_AplicaMC.isSelected() && !Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGenerarDocContable(this.JTDetalleS.getSelectedRow());
                    }
                    if (this.JCH_AplicaMP.isSelected()) {
                        mGenerarDoc_Presupuesto(this.JTDetalleS.getSelectedRow());
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "En N° de Radicación debe ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNRadi.requestFocus();
            return;
        }
        int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y2 == 0) {
            this.xsql = "update  f_factura_evento set UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', NRadicado='" + this.JTFNRadi.getText() + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + this.JTAObsRadicacion.getText() + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void armarDetalleGlosa() {
        if (this.JTItemsGlosados.isEditing()) {
            this.JTItemsGlosados.getCellEditor().stopCellEditing();
        }
        List<FacturaGlosaDetalle> listaGlosa = new ArrayList<>();
        for (int i = 0; i < this.JTItemsGlosados.getRowCount(); i++) {
            System.out.println("item glosados posicion 11 -> " + this.JTItemsGlosados.getValueAt(i, 11).toString());
            if (((Boolean) this.JTItemsGlosados.getValueAt(i, 11)).booleanValue()) {
                FacturaGlosaDetalle factura = FacturaGlosaDetalle.builder().idFacturaGlosa(this.ingreso).idCodigo(Long.valueOf(Long.parseLong(this.JTItemsGlosados.getValueAt(i, 9).toString()))).tipo(Integer.valueOf(Integer.parseInt(this.JTItemsGlosados.getValueAt(i, 10).toString()))).cantidad(Double.valueOf(Double.parseDouble(this.JTItemsGlosados.getValueAt(i, 3).toString()))).valorGlosado(Double.valueOf(Double.parseDouble(this.JTItemsGlosados.getValueAt(i, 12).toString()))).observacion(this.JTItemsGlosados.getValueAt(i, 13).toString()).estado(true).porcentajeImpuesto(Double.valueOf(Double.parseDouble(this.JTItemsGlosados.getValueAt(i, 6).toString()))).esCapita(this.esCapita).nombreItem(this.JTItemsGlosados.getValueAt(i, 2).toString()).build();
                System.out.println("factura result -> " + factura);
                listaGlosa.add(factura);
            }
        }
        Double suma = Double.valueOf(0.0d);
        for (int j = 0; j < listaGlosa.size(); j++) {
            System.out.println("item glosado pasocion 12 -> " + this.JTItemsGlosados.getValueAt(j, 12).toString());
            suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.JTItemsGlosados.getValueAt(j, 12).toString()));
        }
        System.out.println("suma valor glosado -> " + suma);
        this.JTFFValorGlosado.setValue(suma);
        this.listaGlosa = listaGlosa;
    }

    private void mGrabar_Glosa() {
        System.out.println("idEmpresa -> " + this.idEmpresa);
        this.xsql = "insert into f_factura_glosa(Id_PeriodoC, Id_Liquidacion, Id_ConceptoG, NRadicacionG, FechaG, ObservacionG, Valor, UrlSoporte, IdDocumentoC, EsReiterada,UsuarioS,`IdTercero`,`IdFactura` ) values('" + Principal.xclase.getXidperiodoc() + "','" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "','" + this.xidconceptog[this.JCBConceptoG.getSelectedIndex()][0] + "','" + this.JTFNGlosa.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + quitarSaltos(this.JTAObsGlosa.getText()) + "','" + this.JTFFValorGlosado.getValue() + "','" + this.JTFUrlSoporteGS.getText() + "','" + this.xIdDocGlosa + "','" + this.xEsReiterada + "','" + Principal.usuarioSistemaDTO.getLogin() + "', " + this.idEmpresa + ", " + this.idFactura + ")";
        System.out.println("insert factura glosa -> " + this.xsql);
        Long glosa = Long.valueOf(Long.parseLong(this.xct.ejecutarSQLId(this.xsql)));
        System.out.println("glosa -> " + glosa);
        armarDetalleGlosa();
        this.listaGlosa.forEach(f -> {
            f.setIdFacturaGlosa(glosa);
        });
        System.out.println("lista glosa -> " + this.listaGlosa);
        if (!this.listaGlosa.isEmpty()) {
            this.facturaGlosaDetalle.save(this.listaGlosa);
        }
        this.xct.cerrarConexionBd();
        this.xsql = "update f_liquidacion set TGlosa=TGlosa+" + this.JTFFValorGlosado.getValue() + " where Id='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGrabar_RespuestaGlosa() {
        System.out.println("mostrarme" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 45));
        int xconciliada = this.JCHEsConciliada.isSelected() ? 1 : 0;
        System.out.println("lleva" + String.valueOf(this.JCConceptoNota.getSelectedIndex()).equals("2"));
        this.xsql = "insert into f_factura_glosa_respuesta (Id_PeriodoC, Id_Factura_glosa, DetalleR, ValorG, ValorA, ValorR, EsTraslado, IdDocumentoC, FechaD, UsuarioS, Id_Usuario, esConciliada)values ('" + Principal.xclase.getXidperiodoc() + "','" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "','" + quitarSaltos(this.JTARespuestaGlosa.getText()) + "','" + this.JTFFRValorGlosado.getValue() + "','" + this.JTFFRValorAceptado.getValue() + "','" + this.JTFFRValorRecobrado.getValue() + "','" + this.xtraslado + "','" + this.xIdDocRespuestaGlosa + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + xconciliada + "')";
        this.JLBNRespuesta.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() > 0.0d && Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 47).toString()).booleanValue()) {
            armarRespuesta();
            if (this.listaNotaDetalle.size() > 0) {
                List<IResolucionFacturaElectronica> listaResolucionDian = this.resolucionDian.consultarResolucionPorSede(Principal.sedeUsuarioSeleccionadaDTO.getId(), 3);
                String prefijo = "";
                Integer idResolucion = 0;
                if (listaResolucionDian.size() > 0) {
                    prefijo = listaResolucionDian.get(0).getPrefijo();
                    idResolucion = listaResolucionDian.get(0).getId();
                }
                armarRespuesta();
                FacturaNota factura = FacturaNota.builder().idRespuestaGlosa(Long.valueOf(Long.parseLong(this.JLBNRespuesta.getText()))).idUsuarioRh(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).descripcionGeneral(this.JTARespuestaGlosa.getText()).prefijo(prefijo).fechaNota(this.xmt.getFechaActual()).idLiquidacion(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString())).idConceptoNota(this.listaConceptoNotas.get(this.JCConceptoNota.getSelectedIndex()).getId()).idResolucion(idResolucion).numeroConsecutivo(0).estado(true).enviada(false).notaSinFactura(Boolean.valueOf(this.jchbNotaSinFactura.isSelected())).fechaPeriodoInicial(Principal.xclase.getXfechai()).fechaPeriodoFinal(Principal.xclase.getXfechaf()).build();
                FacturaNota facturaG = this.facturaNotaService.save(factura);
                this.listaNotaDetalle.forEach(j -> {
                    j.setIdFacturaNota(facturaG.getId());
                });
                this.facturaNotaDetalleService.saveAll(this.listaNotaDetalle);
                if (this.listaConceptoNotas.get(this.JCConceptoNota.getSelectedIndex()).getCodigo().intValue() == 2) {
                    this.xsql = "UPDATE f_factura_capita SET No_FacturaEvento = 0, EstaArmada = 1 WHERE No_FacturaEvento = '" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 45) + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    System.out.println("imprimir" + this.xsql);
                }
                if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
                    String sql = "select ffn.id , CONCAT(ffe.Prefijo, ffe.No_FacturaEvento_M) noFactura, if(ffn.notaSinFactura =0, 'CREDIT_NOTE', 'CREDIT_NOTE_WBR') tipoNota \nfrom f_factura_notas ffn\ninner join f_liquidacion fl on (fl.Id=ffn.idLiquidacion)\ninner join f_factura_evento ffe on (ffe.Id_Liquidacion=fl.Id)\ninner join f_empresacontxconvenio fe on (fe.Id=fl.IdEmpresaContxConv)\nwhere ffn.id =" + factura.getId() + "";
                    try {
                        ResultSet rs = this.xct.getResultSet(sql);
                        Throwable th = null;
                        try {
                            try {
                                if (rs.next()) {
                                    this.facturaNotaService.generarNotasDebitoCredito(facturaG.getId(), rs.getString("noFactura"), rs.getString("tipoNota"));
                                }
                                this.xct.cerrarConexionBd();
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
                        } finally {
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
        }
        this.xestadograbadorglosa = true;
    }

    private void armarRespuesta() {
        if (this.JTItemsRespuestaGlosa.isEditing()) {
            this.JTItemsRespuestaGlosa.getCellEditor().stopCellEditing();
        }
        List<FacturaNotaDetalle> listaNota = new ArrayList<>();
        for (int i = 0; i < this.JTItemsRespuestaGlosa.getRowCount(); i++) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                if (Integer.parseInt(this.modeloItemsRespuestaGlosa.getValueAt(i, 6).toString()) > 0) {
                    System.out.println("valor aceptado -> " + this.modeloItemsRespuestaGlosa.getValueAt(i, 6).toString());
                    FacturaNotaDetalle facturadetalle = FacturaNotaDetalle.builder().cantidad(Integer.valueOf(Integer.parseInt(this.JTItemsRespuestaGlosa.getValueAt(i, 2).toString()))).idCodigo(this.JTItemsRespuestaGlosa.getValueAt(i, 4).toString()).observacion(this.JTItemsRespuestaGlosa.getValueAt(i, 8).toString()).valorNota(Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 6).toString())).estado(true).tipo(Integer.valueOf(Integer.parseInt(this.JTItemsRespuestaGlosa.getValueAt(i, 5).toString()))).valorUnitario(Double.valueOf(Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(i, 10).toString()))).porcentajeImpuesto(Double.valueOf(Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(i, 11).toString()))).fecha(LocalDateTime.now()).nombreItem(this.JTItemsRespuestaGlosa.getValueAt(i, 1).toString()).build();
                    listaNota.add(facturadetalle);
                }
            } else {
                FacturaNotaDetalle facturadetalle2 = FacturaNotaDetalle.builder().cantidad(Integer.valueOf(Integer.parseInt(this.JTItemsRespuestaGlosa.getValueAt(i, 2).toString()))).idCodigo(this.JTItemsRespuestaGlosa.getValueAt(i, 4).toString()).observacion(this.JTItemsRespuestaGlosa.getValueAt(i, 8).toString()).valorNota(Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 6).toString())).estado(true).tipo(Integer.valueOf(Integer.parseInt(this.JTItemsRespuestaGlosa.getValueAt(i, 5).toString()))).valorUnitario(Double.valueOf(Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(i, 10).toString()))).porcentajeImpuesto(Double.valueOf(Double.parseDouble(this.JTItemsRespuestaGlosa.getValueAt(i, 11).toString()))).fecha(LocalDateTime.now()).nombreItem(this.JTItemsRespuestaGlosa.getValueAt(i, 1).toString()).build();
                listaNota.add(facturadetalle2);
            }
        }
        this.listaNotaDetalle = listaNota;
    }

    private void mGrabar_Devolucion() {
        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            this.xsql = "insert into f_factura_glosa(Id_PeriodoC, Id_Liquidacion, Id_ConceptoG, NRadicacionG, FechaG, ObservacionG, Valor, UrlSoporte, IdDocumentoC,UsuarioS) values('" + Principal.xclase.getXidperiodoc() + "','" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "','" + this.xidconceptod[this.JCBConceptoDevolucion.getSelectedIndex()][0] + "','" + this.JTFNDevolucion.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaDevolucion.getDate()) + "','" + this.JTAObsDevolucion.getText() + "','" + this.JTFFValorDevolucion.getValue() + "','" + this.JTFUrlSoporteDevoluciones.getText() + "','" + this.xIdDocDevoluciones + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mGrabarRadicacionAgrupada() {
        for (int x = 0; x < this.JTDetalleS.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 0).toString()).booleanValue()) {
                if (!Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                    this.xsql = "update f_factura_evento set NRadicado='" + this.JTFNRadi.getText() + "', FechaEntrega='" + this.xmt.formatoAMD.format(this.JDFechaEnt.getDate()) + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + this.JTAObsRadicacion.getText() + "', UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(x, 13).toString() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    if (this.JCH_AplicaMC.isSelected() && !Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGenerarDocContable(x);
                    }
                    if (this.JCH_AplicaMP.isSelected()) {
                        mGenerarDoc_Presupuesto(x);
                    }
                } else {
                    this.xsql = "update  f_factura_evento set UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', NRadicado='" + this.JTFNRadi.getText() + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + this.JTAObsRadicacion.getText() + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(x, 13).toString() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    if (this.JCH_AplicaMC.isSelected() && !Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGenerarDocContable(x);
                    }
                }
            }
        }
    }

    private void mConsecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "' AND `Estado` =1);";
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
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mGenerarDoc_Presupuesto(int xFila) {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,NoFact, IdDocContable, IdUsuarioR,`UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.JTFFNDoc.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        System.out.println("Inserta Encabezado -->" + this.xsql);
        this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,NCCobro, Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodelo.getValueAt(xFila, 41).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(xFila, 30) + "','" + this.xmodelo.getValueAt(xFila, 8) + "','" + this.xmodelo.getValueAt(xFila, 23) + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "');";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDocContable(int xFila) {
        if (this.JCH_AplicaMC.isSelected() && Long.valueOf(this.xmodelo.getValueAt(xFila, 31).toString()).longValue() == 0) {
            mConsecutivo();
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xIdDoc = this.xct.ejecutarSQLId(this.xsql);
            this.JTFFNDoc.setText(xIdDoc);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + xIdDoc + "','" + this.xmodelo.getValueAt(xFila, 29) + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.xmodelo.getValueAt(xFila, 8) + "','0','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + xIdDoc + "','" + this.xmodelo.getValueAt(xFila, 28) + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.xmodelo.getValueAt(xFila, 8) + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_factura_evento set Id_DocumentoCR='" + xIdDoc + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(xFila, 13).toString() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                this.gcuenta.crearDocumentoContableInterfaz(xIdDoc);
            }
        }
    }

    private void mGenerarDocContableBienestar(int xFila) {
        if (this.JCH_AplicaMC.isSelected() && Long.valueOf(this.xmodelo.getValueAt(xFila, 31).toString()).longValue() == 0) {
            mConsecutivo();
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xIdDoc = this.xct.ejecutarSQLId(this.xsql);
            this.JTFFNDoc.setText(xIdDoc);
            this.xct.cerrarConexionBd();
            for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
                if (Boolean.valueOf(this.JTDetalleS.getValueAt(i, 0).toString()).booleanValue()) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + xIdDoc + "','" + this.xmodelo.getValueAt(i, 29) + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.xmodelo.getValueAt(xFila, 8) + "','0','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + xIdDoc + "','" + this.xmodelo.getValueAt(i, 28) + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.xmodelo.getValueAt(xFila, 8) + "','RADICACIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update f_factura_evento set Id_DocumentoCR='" + xIdDoc + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(xFila, 13).toString() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    private void mGenerarDocContableGlosa(int xFila) {
        this.xIdDocGlosa = 0L;
        mConsecutivo();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xIdDocGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.xmodelo.getValueAt(xFila, 32) + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFValorGlosado.getValue() + "','0','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.xmodelo.getValueAt(xFila, 33) + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFValorGlosado.getValue() + "','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.gcuenta.crearDocumentoContableInterfaz(String.valueOf(this.xIdDocGlosa));
        }
    }

    private void mGenerarDocContableGlosaBienestar(int xFila) {
        this.xIdDocGlosa = 0L;
        mConsecutivo();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaGlosa.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        System.out.println(this.xsql);
        this.xIdDocGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
        this.xct.cerrarConexionBd();
        for (int i = 0; i < this.JTItemsGlosados.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTItemsGlosados.getValueAt(i, 11).toString()).booleanValue()) {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.xmodelo.getValueAt(i, 29) + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFValorGlosado.getValue() + "','0','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                System.out.println(" Detalle Puc : " + this.xsql);
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocGlosa + "','" + this.xmodelo.getValueAt(i, 28) + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFValorGlosado.getValue() + "','GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                System.out.println(" Detalle Puc : " + this.xsql);
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    private void mGenerarDocContableRespuestaGlosa(int xFila) {
        this.xIdDocRespuestaGlosa = 0L;
        mConsecutivo();
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() == 0.0d) {
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xIdDocRespuestaGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFDebitoSub.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFRGDebito.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorAceptado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoG.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoSub.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorAceptado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            }
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoG.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoSub.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorGlosado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            return;
        }
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() <= 0.0d || Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() <= 0.0d || Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() <= 0.0d) {
            if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() == 0.0d && Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue() > 0.0d) {
                this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xIdDocRespuestaGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFDebitoSub.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorRecobrado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFRGDebito.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorRecobrado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFDebitoSub.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorRecobrado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoSub.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorGlosado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            }
            return;
        }
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xIdDocRespuestaGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFDebitoSub.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorRecobrado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFRGDebito.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorRecobrado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoG.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoSub.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorAceptado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            return;
        }
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoG.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFRGDebito.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorAceptado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            return;
        }
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFDebitoSub.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorRecobrado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoG.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFRValorAceptado.getValue() + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTFCreditoSub.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFRValorGlosado.getValue() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDocContableRespuestaGlosaBienestar(int xFila) {
        this.xIdDocRespuestaGlosa = 0L;
        mConsecutivo();
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() > 0.0d && Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue() > 0.0d) {
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xIdDocRespuestaGlosa = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
            for (int i = 0; i < this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                if (mVerificaUltNivel(this.JTItemsRespuestaGlosa.getValueAt(i, 13).toString()) && mVerificaUltNivel(this.JTItemsRespuestaGlosa.getValueAt(i, 14).toString()) && Long.valueOf(this.modeloItemsRespuestaGlosa.getValueAt(i, 6).toString()).longValue() != 0) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTItemsRespuestaGlosa.getValueAt(i, 13) + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.modeloItemsRespuestaGlosa.getValueAt(i, 6) + "','0','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    System.out.println("debito -> " + this.xsql);
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocRespuestaGlosa + "','" + this.JTItemsRespuestaGlosa.getValueAt(i, 14) + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.modeloItemsRespuestaGlosa.getValueAt(i, 6) + "','RESPUESTA GLOSA FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    System.out.println("credito -> " + this.xsql);
                }
            }
        }
    }

    private void mGenerarDocContableDevolucion(int xFila) {
        mConsecutivo();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaDevolucion.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + Principal.xclase.getXidperiodoc() + "','DEVOLUCIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2).toString() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xIdDocDevoluciones = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocDevoluciones + "','" + this.JTFNCDebito.getText() + "','0','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','" + this.JTFFValorDevolucion.getValue() + "','0','DEVOLUCIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.xIdDocDevoluciones + "','" + this.JTFNCCredito.getText() + "','1','" + this.xmodelo.getValueAt(xFila, 30) + "','0','" + this.xmodelo.getValueAt(xFila, 2) + "','0','" + this.JTFFValorDevolucion.getValue() + "','DEVOLUCIÓN FACTURA DE VENTA N° " + this.xmodelo.getValueAt(xFila, 2) + "' )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.gcuenta.crearDocumentoContableInterfaz(String.valueOf(this.xIdDocDevoluciones));
        }
    }

    public void mAnular() {
        if (this.JTBGestionC.getSelectedIndex() != 1 || this.JTDetalleG.getSelectedRow() == -1) {
            return;
        }
        if (Long.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 9).toString()).longValue() != 0) {
            JOptionPane.showInternalMessageDialog(this, "Glosa Con Documento Contable Activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBDetalleGlosa.setSelectedIndex(1);
        } else {
            if (Double.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 8).toString()).doubleValue() == 0.0d) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Respuesta Glosa", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Glosa con respuesta activa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBDetalleGlosa.setSelectedIndex(1);
            this.JTPDatosRespuesta.setSelectedIndex(2);
        }
    }

    public void mAnular_Glosa(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        this.xsql = "update f_factura_glosa set Estado=0,  Id_Motivo_Anulacion=" + idMotivoAnulacion + ",`Motivo_Anulacion`='" + xMotivo + "' ,`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' ,`Observacion_Anulacion`='" + xObservacion + "' ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id= '" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mBuscar();
        this.JTBGestionC.setSelectedIndex(0);
    }

    public void mAnular_RGlosa(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        this.xsql = "update f_factura_glosa_respuesta set Estado=0, Id_Motivo_Anulacion=" + idMotivoAnulacion + ",`Motivo_Anulacion`='" + xMotivo + "' ,`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' ,`Observacion_Anulacion`='" + xObservacion + "' ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id='" + this.JLBNRespuesta.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_liquidacion set VGlosaR=VGlosaR-" + this.JTFFRValorRecobrado.getValue() + ", TGlosa=TGlosa-" + this.JTFFRValorGlosado.getValue() + ", VGlosaNR=VGlosaNR-" + this.JTFFRValorAceptado.getValue() + " ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id= '" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mBuscar();
        this.JTBGestionC.setSelectedIndex(0);
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.gcuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.presupuesto = (PresupuestoDAOImpl) classPathXmlApplicationContext.getBean("presupuestoDAOImpl");
        this.contabilidad = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
    }

    private void mValidarVGlosado() {
        if (Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue() > Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()).doubleValue() && Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()).doubleValue() < Double.valueOf(this.JTFFValorGlosado.getValue().toString()).doubleValue()) {
            System.out.println("textfield-------" + Double.valueOf(this.JTFFValorGlosado.getValue().toString()));
            System.out.println("columnaaaa ----- " + Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()));
            System.out.println("tectfiel 22222 --------- " + Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 15).toString()));
            System.out.println("columnaaaa 2222 -------- " + Double.valueOf(this.JTFFValorGlosado.getValue().toString()));
            JOptionPane.showInternalMessageDialog(this, "Valor de glosa mayor que el saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValorGlosado.requestFocus();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTDetalleS.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleS.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleS.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                    sheet.addCell(new Number(4, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).doubleValue()));
                    sheet.addCell(new Number(5, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).doubleValue()));
                    sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                    sheet.addCell(new Number(7, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).doubleValue()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Number(12, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 12).toString()).longValue()));
                    sheet.addCell(new Number(14, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 14).toString()).doubleValue()));
                    sheet.addCell(new Number(15, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 15).toString()).doubleValue()));
                    sheet.addCell(new Number(16, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 16).toString()).doubleValue()));
                    sheet.addCell(new Number(17, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 17).toString()).doubleValue()));
                    sheet.addCell(new Number(18, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 18).toString()).doubleValue()));
                    sheet.addCell(new Label(19, x2 + 1, this.xmodelo.getValueAt(x2, 19).toString()));
                    sheet.addCell(new Number(20, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 20).toString()).longValue()));
                    sheet.addCell(new Label(21, x2 + 1, this.xmodelo.getValueAt(x2, 21).toString()));
                    sheet.addCell(new Number(22, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 22).toString()).longValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mCalcularVRespuestaGlosa() {
        this.JTFFRValorRecobrado.setValue(Double.valueOf(Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() - Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue()));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFFTotalFac.setValue(new Long(0L));
        this.JTFFTotalFac.setEditable(false);
        this.JTFFTotalGlosado.setValue(new Long(0L));
        this.JTFFTotalGlosado.setEditable(false);
        this.JTFFTotalPagado.setValue(new Long(0L));
        this.JTFFTotalPagado.setEditable(false);
        this.JTFFTotalSaldo.setValue(new Long(0L));
        this.JTFFTotalSaldo.setEditable(false);
        this.JTFFPDiasC.setValue(new Long(0L));
        this.JCBEmpresa.removeAllItems();
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        mCrearTablaDetalleFacturas();
        mCrearTablaDetallePagos();
        mCrearTablaDetalleGlosa();
        mCrearTablaHistoricoRespuestaGlosa();
        mCrearTablaSoporteRespuestaGlosa();
        mNuevaRadica();
        mNuevoPago();
        mNuevaGlosa();
        mNuevoRespuestaSoporte();
        mNuevaDevoluciones();
        mLlenarComboPresupuesto();
        mLlenarComboConceptoNotas();
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCH_AplicaMP.setSelected(true);
            if (Principal.informacionIps.getIdentificacion().equals("812003382")) {
                this.JCH_AplicaMP.setEnabled(false);
                this.JCH_AplicaMP.setSelected(true);
            }
        }
        if ((Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) && Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.jPanel2.setVisible(false);
        }
    }

    private void mLlenarComboPresupuesto() {
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.xct.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt, 3);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
    }

    public void mBuscar() {
        mCargarInformacion();
    }

    public void mCargarInformacion() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                mBucarDetalleFact();
                mCrearTablaDetallePagos();
                mCrearTablaDetalleGlosa();
                mNuevaRadica();
                mNuevoPago();
                mNuevaGlosa();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEmpresa.requestFocus();
            return;
        }
        mBucarDetalleFact();
        mCrearTablaDetallePagos();
        mCrearTablaDetalleGlosa();
        mNuevaRadica();
        mNuevoPago();
        mNuevaGlosa();
    }

    private void mLLenarCEmpresa() {
        this.xlleno = false;
        this.JCBEmpresa.removeAllItems();
        mCrearTablaDetalleFacturas();
        mCrearTablaDetallePagos();
        mCrearTablaDetalleGlosa();
        mNuevaRadica();
        mNuevoPago();
        mNuevaGlosa();
        this.xsql = "SELECT f_liquidacion.IdEmpresaContxConv , f_empresacontxconvenio.Nbre NEmpresa  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) WHERE (f_factura_evento.Estado =0 AND f_liquidacion.Estado =0 AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND f_factura_evento.EstaArmada=2) GROUP BY f_liquidacion.IdEmpresaContxConv ORDER BY  f_empresacontxconvenio.Nbre NEmpresa ASC ";
        System.out.println("la emrpesa " + this.xsql);
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
        this.xlleno = true;
        if (this.xidempresa.length == 1) {
            this.JCBEmpresa.setSelectedIndex(0);
        } else {
            this.JCBEmpresa.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
    }

    private void mCrearTablaDetalleFacturas() {
        this.xmodelo = new DefaultTableModel() { // from class: Armado.JIFGestionCartera.77
            Class[] types = {Boolean.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("S");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("N°Factura");
        this.xmodelo.addColumn("Servicio");
        this.xmodelo.addColumn("V/Servicio");
        this.xmodelo.addColumn("V/Descuento");
        this.xmodelo.addColumn("V/CModeradora");
        this.xmodelo.addColumn("V/Copago");
        this.xmodelo.addColumn("Total");
        this.xmodelo.addColumn("R?");
        this.xmodelo.addColumn("NRadicado");
        this.xmodelo.addColumn("FechaEntrega");
        this.xmodelo.addColumn("FechaRadicado");
        this.xmodelo.addColumn("IdLiquidacion");
        this.xmodelo.addColumn("ObservacionRad");
        this.xmodelo.addColumn("Saldo");
        this.xmodelo.addColumn("VPagado");
        this.xmodelo.addColumn("Glosa");
        this.xmodelo.addColumn("GlosaR");
        this.xmodelo.addColumn("GlosaNR");
        this.xmodelo.addColumn("Fecha UPago");
        this.xmodelo.addColumn("DíasC");
        this.xmodelo.addColumn("Empresa");
        this.xmodelo.addColumn("CCobro");
        this.xmodelo.addColumn("SoporteRad");
        this.xmodelo.addColumn("CJuridico");
        this.xmodelo.addColumn("Etapa");
        this.xmodelo.addColumn("Nips");
        this.xmodelo.addColumn("RCredito");
        this.xmodelo.addColumn("RDebito");
        this.xmodelo.addColumn("IdEmpresa");
        this.xmodelo.addColumn("Id_DocumentoCR");
        this.xmodelo.addColumn("RGDebito");
        this.xmodelo.addColumn("RGCredito");
        this.xmodelo.addColumn("RGSDebito");
        this.xmodelo.addColumn("RGSCredito");
        this.xmodelo.addColumn("Regimen");
        this.xmodelo.addColumn("DDebito");
        this.xmodelo.addColumn("DCredito");
        this.xmodelo.addColumn("Convenio");
        this.xmodelo.addColumn("GCredito");
        this.xmodelo.addColumn("IdRuproP");
        this.xmodelo.addColumn("Id_DocumentoC");
        this.xmodelo.addColumn("FechaD");
        this.xmodelo.addColumn("Ingreso");
        this.xmodelo.addColumn("IdFactura");
        this.xmodelo.addColumn("esCapita");
        this.xmodelo.addColumn("esTrasmitida");
        JTable jTable = this.JTDetalleS;
        JTable jTable2 = this.JTDetalleS;
        jTable.setAutoResizeMode(0);
        this.JTDetalleS.doLayout();
        this.JTDetalleS.setModel(this.xmodelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(26).setPreferredWidth(1000);
        this.JTDetalleS.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(36).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(38).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(39).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(40).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(41).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(42).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(43).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(47).setPreferredWidth(100);
    }

    private void mCrearTablaDetalleGlosa() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Concepto", "NRadicación", "Valor", "Observación", "Estado", "UrlSoporte", "VRespuesta", "idDocumentoC", "Es Reiterada?", "Seleccionar"}) { // from class: Armado.JIFGestionCartera.78
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class, Double.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleG.setModel(this.xmodelo2);
        this.JTDetalleG.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleG.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleG.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleG.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleG.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleG.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleG.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleG.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleG.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    private void mCrearTablaDetallePagos() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Concepto", "Valor", "Observación", "Estado", "UrlSoporte"}) { // from class: Armado.JIFGestionCartera.79
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleP.setModel(this.xmodelo1);
        this.JTDetalleP.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleP.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleP.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleP.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalleP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCrearTablaHistoricoRespuestaGlosa() {
        this.xmodelo3 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "VGlosado", "VNRecuperable", "V/Recuperable", "EsTraslado?", "IdDocumentoC", "Sin Factura", "Es Conciliada?"}) { // from class: Armado.JIFGestionCartera.80
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Boolean.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTHistoricoResp.setModel(this.xmodelo3);
        JTable jTable = this.JTHistoricoResp;
        JTable jTable2 = this.JTHistoricoResp;
        jTable.setAutoResizeMode(0);
        this.JTHistoricoResp.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(2).setPreferredWidth(320);
        this.JTHistoricoResp.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(6).setPreferredWidth(98);
        this.JTHistoricoResp.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTHistoricoResp.getColumnModel().getColumn(9).setPreferredWidth(85);
        this.xmt.mEstablecerTextEditor(this.JTHistoricoResp, 2);
    }

    private void mCrearTablaSoporteRespuestaGlosa() {
        this.xmodelo4 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Observacion", "Ruta", "Estado"}) { // from class: Armado.JIFGestionCartera.81
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTRespuestaSoporte.setModel(this.xmodelo4);
        this.JTRespuestaSoporte.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTRespuestaSoporte.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTRespuestaSoporte.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTRespuestaSoporte.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mBucarDetalleFact() {
        List<Object[]> list;
        double xvalor = 0.0d;
        double xvalog = 0.0d;
        double xvalop = 0.0d;
        double xsaldo = 0.0d;
        double xndias = 0.0d;
        double xndiasr = 0.0d;
        if (this.JCHFiltro.isSelected()) {
            list = this.gcuenta.cargarSetDatosCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidempresa[this.JCBEmpresa.getSelectedIndex()], this.JTFFNCuentaC.getText(), this.esFactura);
        } else {
            list = this.gcuenta.cargarSetDatosCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", this.JTFFNCuentaC.getText(), this.esFactura);
        }
        mCrearTablaDetalleFacturas();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(list.get(x)[27], x, 0);
                this.xmodelo.setValueAt(list.get(x)[0], x, 1);
                this.xmodelo.setValueAt(list.get(x)[1], x, 2);
                this.xmodelo.setValueAt(list.get(x)[2], x, 3);
                this.xmodelo.setValueAt(list.get(x)[3], x, 4);
                this.xmodelo.setValueAt(list.get(x)[4], x, 5);
                this.xmodelo.setValueAt(list.get(x)[5], x, 6);
                this.xmodelo.setValueAt(list.get(x)[6], x, 7);
                this.xmodelo.setValueAt(list.get(x)[7], x, 8);
                this.xmodelo.setValueAt(list.get(x)[8], x, 9);
                this.xmodelo.setValueAt(list.get(x)[9], x, 10);
                this.xmodelo.setValueAt(list.get(x)[10], x, 11);
                this.xmodelo.setValueAt(list.get(x)[11], x, 12);
                this.xmodelo.setValueAt(list.get(x)[12], x, 13);
                this.xmodelo.setValueAt(list.get(x)[13], x, 14);
                this.xmodelo.setValueAt(list.get(x)[14], x, 15);
                this.xmodelo.setValueAt(list.get(x)[15], x, 16);
                this.xmodelo.setValueAt(list.get(x)[16], x, 17);
                this.xmodelo.setValueAt(list.get(x)[17], x, 18);
                this.xmodelo.setValueAt(list.get(x)[18], x, 19);
                this.xmodelo.setValueAt(list.get(x)[19], x, 20);
                this.xmodelo.setValueAt(list.get(x)[20], x, 21);
                this.xmodelo.setValueAt(list.get(x)[21], x, 22);
                this.xmodelo.setValueAt(list.get(x)[22], x, 23);
                this.xmodelo.setValueAt(this.xmt.mTraerUrlBD(list.get(x)[23].toString()), x, 24);
                this.xmodelo.setValueAt(list.get(x)[24], x, 25);
                this.xmodelo.setValueAt(list.get(x)[25], x, 26);
                this.xmodelo.setValueAt(list.get(x)[26], x, 27);
                this.xmodelo.setValueAt(list.get(x)[28], x, 28);
                this.xmodelo.setValueAt(list.get(x)[29], x, 29);
                this.xmodelo.setValueAt(list.get(x)[30], x, 30);
                this.xmodelo.setValueAt(list.get(x)[31], x, 31);
                this.xmodelo.setValueAt(list.get(x)[32], x, 32);
                this.xmodelo.setValueAt(list.get(x)[33], x, 33);
                this.xmodelo.setValueAt(list.get(x)[34], x, 34);
                this.xmodelo.setValueAt(list.get(x)[35], x, 35);
                this.xmodelo.setValueAt(list.get(x)[36], x, 36);
                this.xmodelo.setValueAt(list.get(x)[37], x, 37);
                this.xmodelo.setValueAt(list.get(x)[38], x, 38);
                this.xmodelo.setValueAt(list.get(x)[39], x, 39);
                this.xmodelo.setValueAt(list.get(x)[40], x, 40);
                this.xmodelo.setValueAt(list.get(x)[41], x, 41);
                this.xmodelo.setValueAt(list.get(x)[42], x, 42);
                this.xmodelo.setValueAt(list.get(x)[43], x, 43);
                this.xmodelo.setValueAt(list.get(x)[44], x, 44);
                this.xmodelo.setValueAt(list.get(x)[45], x, 45);
                this.xmodelo.setValueAt(list.get(x)[46], x, 46);
                this.xmodelo.setValueAt(list.get(x)[47], x, 47);
                xvalor += Double.valueOf(list.get(x)[7].toString()).doubleValue();
                xvalog += Double.valueOf(list.get(x)[16].toString()).doubleValue();
                xvalop += Double.valueOf(list.get(x)[15].toString()).doubleValue();
                xsaldo += Double.valueOf(list.get(x)[14].toString()).doubleValue();
                if (Double.valueOf(list.get(x)[14].toString()).doubleValue() != 0.0d && Double.valueOf(list.get(x)[20].toString()).doubleValue() != 0.0d) {
                    xndias += Double.valueOf(list.get(x)[20].toString()).doubleValue();
                    xndiasr += 1.0d;
                }
            }
            this.JTFFTotalFac.setValue(Double.valueOf(xvalor));
            this.JTFFTotalGlosado.setValue(Double.valueOf(xvalog));
            this.JTFFTotalPagado.setValue(Double.valueOf(xvalop));
            this.JTFFTotalSaldo.setValue(Double.valueOf(xsaldo));
            this.JTFFPDiasC.setValue(Double.valueOf(xndias / xndiasr));
        }
    }

    private void mBucarDetalleFact_ant() {
        mCrearTablaDetalleFacturas();
        double xvalor = 0.0d;
        double xvalog = 0.0d;
        double xvalop = 0.0d;
        double xsaldo = 0.0d;
        double xndias = 0.0d;
        double xndiasr = 0.0d;
        this.gcuenta.cargarSetDatosCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        if (this.JTFFNCuentaC.getText().isEmpty()) {
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT \n d.FFactura\n , d.NFactura\n , d.NServicio\n , d.TotalServicio\n , d.TotalDescuento\n , d.TotalCModeradora\n , d.TotalCopago\n , d.VTotal\n , d.Radicado\n , d.NRadicado\n , d.FEntrega\n , d.FRAdicado\n , d.IdLiquidacion\n , d.CRad\n , ((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )Saldo\n , IFNULL(p.VPagado,0) VPagado\n , IFNULL(f.VGlosado,0) VGlosado\n , IFNULL(g.VRecuperable,0) VRecuperable\n , IFNULL(g.VAceptado,0)VAceptado\n ,  d.FechaUP\n , IF(((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )<=0 ,0, IF(d.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY)) ) ))  AS NDias\n , d.FRAdicado NFecha\n , IF(d.NEmpresa= '', d.Convenio,d.NEmpresa)  NEmpresa\n , d.No_CuentaCobro\n , d.UrlRadicado\n , d.CJuridico\n , d.NEtapaProceso\n , d.NIps\n , d.CPuc_Credito_R\n , d.CPuc_Debito_R\n , d.Id_empresa\n , d.Id_DocumentoCR\n , d.CPuc_Debito_G\n , d.CPuc_Credito_G\n , d.CPuc_Debito_GS\n , d.CPuc_Credito_GS\n , d.Regimen\n , d.CPuc_Debito_D\n , d.CPuc_Credito_D\n , d.Convenio\n , d.CPuc_Credito, d.IdRubroP, d.IdDocumentoC, d.FechaD\nFROM tmp_cartera_facturacion d\nLEFT JOIN tmp_cartera_glosas f\n  ON d.IdLiquidacion=f.IdLiquidacion\nLEFT JOIN tmp_cartera_resp_glosas g\n ON d.IdLiquidacion=g.IdLiquidacion\nLEFT JOIN tmp_cartera_pagos p\n ON d.IdLiquidacion=p.IdLiquidacion\nWHERE d.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'\nORDER BY d.`NFactura` ASC";
            } else {
                this.xsql = "SELECT \n d.FFactura\n , d.NFactura\n , d.NServicio\n , d.TotalServicio\n , d.TotalDescuento\n , d.TotalCModeradora\n , d.TotalCopago\n , d.VTotal\n , d.Radicado\n , d.NRadicado\n , d.FEntrega\n , d.FRAdicado\n , d.IdLiquidacion\n , d.CRad\n , ((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )Saldo\n , IFNULL(p.VPagado,0) VPagado\n , IFNULL(f.VGlosado,0) VGlosado\n , IFNULL(g.VRecuperable,0) VRecuperable\n , IFNULL(g.VAceptado,0)VAceptado\n ,  d.FechaUP\n , IF(((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )<=0 ,0, IF(d.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY)) ) ))  AS NDias\n , d.FRAdicado NFecha\n , IF(d.NEmpresa= '', d.Convenio,d.NEmpresa)  NEmpresa\n , d.No_CuentaCobro\n , d.UrlRadicado\n , d.CJuridico\n , d.NEtapaProceso\n , d.NIps\n , d.CPuc_Credito_R\n , d.CPuc_Debito_R\n , d.Id_empresa\n , d.Id_DocumentoCR\n , d.CPuc_Debito_G\n , d.CPuc_Credito_G\n , d.CPuc_Debito_GS\n , d.CPuc_Credito_GS\n , d.Regimen\n , d.CPuc_Debito_D\n , d.CPuc_Credito_D\n , d.Convenio\n , d.CPuc_Credito, d.IdRubroP, d.IdDocumentoC, d.FechaD\nFROM tmp_cartera_facturacion d\nLEFT JOIN tmp_cartera_glosas f\n  ON d.IdLiquidacion=f.IdLiquidacion\nLEFT JOIN tmp_cartera_resp_glosas g\n ON d.IdLiquidacion=g.IdLiquidacion\nLEFT JOIN tmp_cartera_pagos p\n ON d.IdLiquidacion=p.IdLiquidacion\nORDER BY d.`NFactura` ASC";
            }
        } else if (this.JRBCCobro.isSelected()) {
            this.xsql = "SELECT \n d.FFactura\n , d.NFactura\n , d.NServicio\n , d.TotalServicio\n , d.TotalDescuento\n , d.TotalCModeradora\n , d.TotalCopago\n , d.VTotal\n , d.Radicado\n , d.NRadicado\n , d.FEntrega\n , d.FRAdicado\n , d.IdLiquidacion\n , d.CRad\n , ((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )Saldo\n , IFNULL(p.VPagado,0) VPagado\n , IFNULL(f.VGlosado,0) VGlosado\n , IFNULL(g.VRecuperable,0) VRecuperable\n , IFNULL(g.VAceptado,0)VAceptado\n ,  d.FechaUP\n , IF(((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )<=0 ,0, IF(d.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY)) ) ))  AS NDias\n , d.FRAdicado NFecha\n , IF(d.NEmpresa= '', d.Convenio,d.NEmpresa)  NEmpresa\n , d.No_CuentaCobro\n , d.UrlRadicado\n , d.CJuridico\n , d.NEtapaProceso\n , d.NIps\n , d.CPuc_Credito_R\n , d.CPuc_Debito_R\n , d.Id_empresa\n , d.Id_DocumentoCR\n , d.CPuc_Debito_G\n , d.CPuc_Credito_G\n , d.CPuc_Debito_GS\n , d.CPuc_Credito_GS\n , d.Regimen\n , d.CPuc_Debito_D\n , d.CPuc_Credito_D\n , d.Convenio\n , d.CPuc_Credito, d.IdRubroP, d.IdDocumentoC, d.FechaD\nFROM tmp_cartera_facturacion d\nLEFT JOIN tmp_cartera_glosas f\n  ON d.IdLiquidacion=f.IdLiquidacion\nLEFT JOIN tmp_cartera_resp_glosas g\n ON d.IdLiquidacion=g.IdLiquidacion\nLEFT JOIN tmp_cartera_pagos p\n ON d.IdLiquidacion=p.IdLiquidacion\nWHERE d.`No_CuentaCobro` = '" + this.JTFFNCuentaC.getText() + "'\nORDER BY d.`NFactura` ASC";
        } else {
            this.xsql = "SELECT \n d.FFactura\n , d.NFactura\n , d.NServicio\n , d.TotalServicio\n , d.TotalDescuento\n , d.TotalCModeradora\n , d.TotalCopago\n , d.VTotal\n , d.Radicado\n , d.NRadicado\n , d.FEntrega\n , d.FRAdicado\n , d.IdLiquidacion\n , d.CRad\n , ((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )Saldo\n , IFNULL(p.VPagado,0) VPagado\n , IFNULL(f.VGlosado,0) VGlosado\n , IFNULL(g.VRecuperable,0) VRecuperable\n , IFNULL(g.VAceptado,0)VAceptado\n ,  d.FechaUP\n , IF(((d.VTotal- IFNULL(g.VAceptado,0))-IFNULL(p.VPagado,0) )<=0 ,0, IF(d.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(d.FechaRadicado, INTERVAL d.NDiasP DAY)) ) ))  AS NDias\n , d.FRAdicado NFecha\n , IF(d.NEmpresa= '', d.Convenio,d.NEmpresa)  NEmpresa\n , d.No_CuentaCobro\n , d.UrlRadicado\n , d.CJuridico\n , d.NEtapaProceso\n , d.NIps\n , d.CPuc_Credito_R\n , d.CPuc_Debito_R\n , d.Id_empresa\n , d.Id_DocumentoCR\n , d.CPuc_Debito_G\n , d.CPuc_Credito_G\n , d.CPuc_Debito_GS\n , d.CPuc_Credito_GS\n , d.Regimen\n , d.CPuc_Debito_D\n , d.CPuc_Credito_D\n , d.Convenio\n , d.CPuc_Credito, d.IdRubroP, d.IdDocumentoC, d.FechaD\nFROM tmp_cartera_facturacion d\nLEFT JOIN tmp_cartera_glosas f\n  ON d.IdLiquidacion=f.IdLiquidacion\nLEFT JOIN tmp_cartera_resp_glosas g\n ON d.IdLiquidacion=g.IdLiquidacion\nLEFT JOIN tmp_cartera_pagos p\n ON d.IdLiquidacion=p.IdLiquidacion\nWHERE d.`NFactura` = '" + this.JTFFNCuentaC.getText() + "'\nORDER BY d.`NFactura` ASC";
        }
        System.out.println("Facturas :  " + this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), xnfila, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), xnfila, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), xnfila, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), xnfila, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), xnfila, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), xnfila, 11);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), xnfila, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(16)), xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(17)), xnfila, 16);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(18)), xnfila, 17);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(19)), xnfila, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), xnfila, 19);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(21)), xnfila, 20);
                    this.xmodelo.setValueAt(xrs.getString(23), xnfila, 21);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(24)), xnfila, 22);
                    this.xmodelo.setValueAt(this.xmt.mTraerUrlBD(xrs.getString(25)), xnfila, 23);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(26)), xnfila, 24);
                    this.xmodelo.setValueAt(xrs.getString(27), xnfila, 25);
                    this.xmodelo.setValueAt(xrs.getString("NIps"), xnfila, 26);
                    this.xmodelo.setValueAt(false, xnfila, 27);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Credito_R"), xnfila, 28);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Debito_R"), xnfila, 29);
                    this.xmodelo.setValueAt(xrs.getString("Id_empresa"), xnfila, 30);
                    this.xmodelo.setValueAt(xrs.getString("Id_DocumentoCR"), xnfila, 31);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Debito_G"), xnfila, 32);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Credito_G"), xnfila, 33);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Debito_GS"), xnfila, 34);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Credito_GS"), xnfila, 35);
                    this.xmodelo.setValueAt(xrs.getString("Regimen"), xnfila, 36);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Debito_D"), xnfila, 37);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Credito_D"), xnfila, 38);
                    this.xmodelo.setValueAt(xrs.getString("Convenio"), xnfila, 39);
                    this.xmodelo.setValueAt(xrs.getString("CPuc_Credito"), xnfila, 40);
                    this.xmodelo.setValueAt(xrs.getString("IdRubroP"), xnfila, 41);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("IdDocumentoC")), xnfila, 42);
                    this.xmodelo.setValueAt(xrs.getString("FechaD"), xnfila, 43);
                    xvalor += xrs.getDouble(8);
                    xvalog += xrs.getDouble(17);
                    xvalop += xrs.getDouble(16);
                    xsaldo += xrs.getDouble(15);
                    if (xrs.getDouble(15) != 0.0d && xrs.getLong(21) != 0) {
                        xndias += xrs.getLong(21);
                        xndiasr += 1.0d;
                    }
                    xnfila++;
                }
            }
            this.JTFFTotalFac.setValue(Double.valueOf(xvalor));
            this.JTFFTotalGlosado.setValue(Double.valueOf(xvalog));
            this.JTFFTotalPagado.setValue(Double.valueOf(xvalop));
            this.JTFFTotalSaldo.setValue(Double.valueOf(xsaldo));
            this.JTFFPDiasC.setValue(Double.valueOf(xndias / xndiasr));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarDatosCartera() {
        mCrearEncabezado();
        mCrearTabla();
        mAlterarTabla();
        mllenarTabla();
        mActualizarDatos();
    }

    private void mCrearEncabezado() {
        this.xsql = "SELECT `Id`, `Nbre`, `VMinimo`, `VMaximo`  FROM  `f_tipo_periodos_cartera` WHERE (`Estado` =1) ORDER BY `Orden` ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.last();
                this.xencabezado = new String[xrs.getRow()][3];
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xencabezado[x][0] = xrs.getString(2);
                    this.xencabezado[x][1] = xrs.getString(3);
                    this.xencabezado[x][2] = xrs.getString(4);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTabla() {
        this.xsql = "DROP TABLE IF EXISTS f_tmp_cartera";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `f_tmp_cartera` ( `Id` smallint(5) NOT NULL default '0', `Empresa` varchar(2000) default '' ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mAlterarTabla() {
        for (int x = 0; x < this.xencabezado.length; x++) {
            if (x == 0) {
                this.xsql = "alter table  f_tmp_cartera add " + this.xencabezado[x][0] + " double default '0' after `Empresa` ";
            } else {
                this.xsql = "alter table  f_tmp_cartera add " + this.xencabezado[x][0] + " double default '0' after " + this.xencabezado[x - 1][0] + " ";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mllenarTabla() {
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "INSERT INTO f_tmp_cartera (Id, Empresa) SELECT g_empresacont.Id_empresa, `cc_terceros`.`RazonSocialCompleta` FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)   INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)   INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)   INNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)   INNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)  WHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "'  AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0  AND g_empresacont.Id_empresa='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND f_factura_evento.EstaArmada=2 AND (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))<>0 )    GROUP BY  g_empresacont.Id_empresa ORDER BY  `cc_terceros`.`RazonSocialCompleta` ASC  ";
        } else {
            this.xsql = "INSERT INTO f_tmp_cartera (Id, Empresa) SELECT g_empresacont.Id_empresa,  `cc_terceros`.`RazonSocialCompleta` FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)   INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)   INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `g_empresacont`.`Id_empresa`)  INNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)   INNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)  WHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "'  AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0   AND f_factura_evento.EstaArmada=2 AND (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))<>0 )    GROUP BY  g_empresacont.Id_empresa ORDER BY  `cc_terceros`.`RazonSocialCompleta` ASC  ";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mActualizarDatos() {
        try {
            this.xsql = "SELECT `Id` FROM `f_tmp_cartera` ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    for (int x = 0; x < this.xencabezado.length; x++) {
                        this.xsql = "SELECT SUM(IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)) AS Saldo FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv)   INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)   INNER JOIN `g_etapa_proceso`  ON (f_factura_evento.`IdEtapaProcedo` = g_etapa_proceso.`Id`)   INNER JOIN .`f_cuentacobro`  ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) WHERE ( `f_cuentacobro`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "'  AND f_factura_evento.Estado =0 AND f_liquidacion.Estado =0  AND g_empresacont.Id_empresa=" + xrs.getLong(1) + " AND f_factura_evento.EstaArmada=2 AND (IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))<>0  AND (IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(),  DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) >=" + Long.valueOf(this.xencabezado[x][1]) + " AND (IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(),  DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) <=" + Long.valueOf(this.xencabezado[x][2]) + ")  GROUP BY g_empresacont.Id_empresa  ORDER BY  f_factura_evento.Fecha_FacturaEvento ASC, f_subgruposervicio.Nbre ASC, f_factura_evento.No_FacturaEvento ASC ";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        ResultSet xrs1 = xct1.traerRs(this.xsql);
                        if (xrs1.next()) {
                            xrs1.first();
                            ConsultasMySQL xct2 = new ConsultasMySQL();
                            this.xsql = "update f_tmp_cartera set " + this.xencabezado[x][0] + "=" + xrs1.getDouble(1) + " where Id='" + xrs.getString(1) + "'";
                            xct2.ejecutarSQL(this.xsql);
                            xct2.cerrarConexionBd();
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarDetallePagos() {
        mCrearTablaDetallePagos();
        this.xsql = "SELECT f_factura_pagos.Id, f_factura_pagos.FechaAbono, f_tipoconcepto_pago.Nbre, f_factura_pagos.Valor, f_factura_pagos.Observacion, f_factura_pagos.Estado, f_factura_pagos.UrlSoporte FROM f_factura_pagos INNER JOIN f_tipoconcepto_pago  ON (f_factura_pagos.Id_ConceptoPago = f_tipoconcepto_pago.Id) WHERE f_factura_pagos.Id_Liquidacion ='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "' ORDER BY f_factura_pagos.FechaAbono DESC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(4)), xnfila, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), xnfila, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), xnfila, 6);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarDetalleGlosas() {
        mNuevaGlosa();
        mCrearTablaDetalleGlosa();
        this.xsql = "SELECT\n  f_factura_glosa.Id,\n  f_factura_glosa.FechaG,\n  f_tipoconcepto_pago.Nbre,\n  f_factura_glosa.NRadicacionG,\n  f_factura_glosa.Valor,\n  f_factura_glosa.ObservacionG,\n  f_factura_glosa.Estado,\n  f_factura_glosa.UrlSoporte,\n  \n  IF(\n    (SELECT\n      SUM(\n        `f_factura_glosa_respuesta`.`ValorG`\n      )\n    FROM\n      `f_factura_glosa_respuesta`\n    WHERE (\n        `f_factura_glosa_respuesta`.`Id_Factura_glosa` = f_factura_glosa.Id\n        AND `f_factura_glosa_respuesta`.`Estado` = 1\n      )\n    GROUP BY `f_factura_glosa_respuesta`.`Id_Factura_glosa`) IS NULL,\n    0,\n    (SELECT\n      SUM(\n        `f_factura_glosa_respuesta`.`ValorG`\n      )\n      \n    FROM\n      `f_factura_glosa_respuesta`\n    WHERE (\n        `f_factura_glosa_respuesta`.`Id_Factura_glosa` = f_factura_glosa.Id\n        AND `f_factura_glosa_respuesta`.`Estado` = 1\n      )\n    GROUP BY `f_factura_glosa_respuesta`.`Id_Factura_glosa`)\n  ) AS `ValorR`,\n  `f_factura_glosa`.`IdDocumentoC`,\n  f_factura_glosa.EsReiterada\n  ,`f_liquidacion`.`Id_Ingreso`\nFROM\n  f_factura_glosa\n  INNER JOIN f_tipoconcepto_pago\n    ON (\n      f_factura_glosa.Id_ConceptoG = f_tipoconcepto_pago.Id\n    )\n  INNER JOIN `f_liquidacion`\n  ON (`f_liquidacion`.`Id`=`f_factura_glosa`.`Id_Liquidacion`)\n  WHERE (\n     f_factura_glosa.Id_Liquidacion = '" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'\n     AND \n    f_factura_glosa.Estado = 1\n  )\nORDER BY f_factura_glosa.FechaG DESC";
        System.out.println("consulta detalle glosa -> " + this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        this.xvalorg = 0.0d;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 4);
                    this.xmodelo2.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo2.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), xnfila, 6);
                    this.xmodelo2.setValueAt(xrs.getString(8), xnfila, 7);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble("ValorR")), xnfila, 8);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong("IdDocumentoC")), xnfila, 9);
                    this.xmodelo2.setValueAt(Boolean.valueOf(xrs.getBoolean("EsReiterada")), xnfila, 10);
                    this.xmodelo2.setValueAt(false, xnfila, 11);
                    this.JTDetalleG.setDefaultRenderer(Object.class, new MiRender2());
                    if (!xrs.getBoolean("EsReiterada")) {
                        this.xvalorg += xrs.getDouble(5);
                    }
                    this.idIngreso = xrs.getInt("Id_Ingreso");
                    System.out.println("idIngreso -> " + this.idIngreso);
                    xnfila++;
                }
            }
            this.JTFFTotalGlosa.setValue(Double.valueOf(this.xvalorg));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarHistoricoRespuestaGlosas() {
        mCrearTablaHistoricoRespuestaGlosa();
        this.xsql = "SELECT ffgr.Id ,date_format(ffgr.FechaD,'%d-%m-%Y'), ffgr.DetalleR, ffgr.ValorG , ffgr.ValorA, ffgr.ValorR, ffgr.EsTraslado, ffgr.IdDocumentoC, ifnull(ffn.notaSinFactura,0) notaSinFactura, ifnull(ffgr.esConciliada, 0) esConciliada \nFROM f_factura_glosa_respuesta ffgr\nleft join f_factura_notas ffn on (ffn.idRespuestaGlosa =ffgr.Id )\nWHERE (ffgr.Estado =1 AND ffgr.id_Factura_glosa ='" + this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 0) + "') ";
        System.out.println("busca historico rglosa -> " + this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo3.addRow(this.xdato);
                    this.xmodelo3.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo3.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo3.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(4)), xnfila, 3);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 4);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo3.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), xnfila, 6);
                    this.xmodelo3.setValueAt(Long.valueOf(xrs.getLong(8)), xnfila, 7);
                    this.xmodelo3.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), xnfila, 8);
                    this.xmodelo3.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), xnfila, 9);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarSoporteRespuestaGlosas() {
        mCrearTablaSoporteRespuestaGlosa();
        this.xsql = "SELECT `Id`, `Observacion`, `UrlSoporte`, `Estado` FROM `f_factura_glosa_respuesta_soporte` WHERE (`Id_Respuesta` ='" + this.JLBNRespuesta.getText() + "') ORDER BY `Id` DESC;";
        System.out.println(this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo4.addRow(this.xdato);
                    this.xmodelo4.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo4.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo4.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo4.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), xnfila, 3);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevaRadica() {
        this.JTFNRadi.setText("");
        this.JDFechaEnt.setDate(this.xmt.getFechaActual());
        this.JDFechaRad.setDate(this.xmt.getFechaActual());
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
        this.JTAObsRadicacion.setText("");
        this.JTFRutaSoporteRad.setText("");
        this.JTFNRadi.requestFocus();
        this.JCBEProceso.removeAllItems();
        this.xsql = "SELECT `Id`, `Nbre` FROM  `g_etapa_proceso` WHERE (`Estado` =1) ";
        this.xidetapa = this.xct.llenarCombo(this.xsql, this.xidetapa, this.JCBEProceso);
        this.xct.cerrarConexionBd();
    }

    private void mNuevoPago() {
        this.xlleno1 = false;
        this.JDFechaPago.setDate(this.xmt.getFechaActual());
        this.JCBConceptoP.removeAllItems();
        this.xidconceptop = this.xct.llenarComboyLista("SELECT Id, Nbre, Completo FROM f_tipoconcepto_pago WHERE (Estado =1 AND Tipo=0) ORDER BY Nbre ASC", this.xidconceptop, this.JCBConceptoP, 3);
        this.JCBConceptoP.setSelectedIndex(-1);
        this.JTFFValorPagado.setValue(new Double(0.0d));
        this.JTAObsPago.setText("");
        this.JTFRutaSoportePago.setText("");
        this.xct.cerrarConexionBd();
        this.xlleno1 = true;
    }

    private void mNuevaGlosa() {
        this.xlleno1 = false;
        this.JDFechaGlosa.setDate(this.xmt.getFechaActual());
        this.JDFechaRGlosa.setDate(this.xmt.getFechaActual());
        this.JCBConceptoG.removeAllItems();
        this.xidconceptog = this.xct.llenarComboyLista("SELECT Id, Nbre, Completo, Tipo FROM f_tipoconcepto_pago WHERE (Estado =1 AND Tipo in(1,2)) ORDER BY Nbre ASC", this.xidconceptog, this.JCBConceptoG, 4);
        this.JCBConceptoG.setSelectedIndex(-1);
        this.JTFFValorGlosado.setValue(new Double(0.0d));
        this.JTAObsGlosa.setText("");
        this.xct.cerrarConexionBd();
        this.JTARespuestaGlosa.setText("");
        this.xestadograbadorglosa = false;
        this.JTFFRValorGlosado.setValue(new Double(0.0d));
        this.JTFFRValorAceptado.setValue(new Double(0.0d));
        this.JTFFRValorRecobrado.setValue(new Double(0.0d));
        this.JTFFTotalGlosa.setValue(new Double(0.0d));
        this.JLBNRespuesta.setText("");
        this.JTFUrlSoporteGS.setText("");
        this.JCHEsTraslado.setSelected(false);
        this.xtraslado = 0;
        this.xIdDocGlosa = 0L;
        this.xIdDocRespuestaGlosa = 0L;
        this.JCHEsReiterada.setSelected(false);
        this.xEsReiterada = 0;
        this.xlleno1 = true;
    }

    private void mNuevaRespuestaGlosa() {
        this.JDFechaRGlosa.setDate(this.xmt.getFechaActual());
        this.JTARespuestaGlosa.setText("");
        this.xestadograbadorglosa = false;
        this.JTFFRValorGlosado.setValue(Double.valueOf(this.xmodelo2.getValueAt(this.JTDetalleG.getSelectedRow(), 4).toString()));
        this.JTFFRValorAceptado.setValue(new Double(0.0d));
        this.JTFFRValorRecobrado.setValue(new Double(0.0d));
        this.JLBNRespuesta.setText("");
        this.JCHEsTraslado.setSelected(false);
        this.xtraslado = 0;
        this.xIdDocRespuestaGlosa = 0L;
    }

    private void mNuevaDevoluciones() {
        this.xlleno1 = false;
        this.JDFechaDevolucion.setDate(this.xmt.getFechaActual());
        this.JCBConceptoDevolucion.removeAllItems();
        this.xidconceptod = this.xct.llenarComboyLista("SELECT Id, Nbre, Completo FROM f_tipoconcepto_pago WHERE (Estado =1 AND Tipo=2) ORDER BY Nbre ASC", this.xidconceptod, this.JCBConceptoDevolucion, 3);
        this.JCBConceptoDevolucion.setSelectedIndex(-1);
        this.JTFFValorDevolucion.setValue(new Double(0.0d));
        this.JTAObsDevolucion.setText("");
        this.JTFNDevolucion.setText("");
        this.JTFNCCredito.setText("");
        this.JTFNCDebito.setText("");
        this.xct.cerrarConexionBd();
        this.JTFUrlSoporteDevoluciones.setText("");
        this.xIdDocDevoluciones = 0L;
        this.xlleno1 = true;
    }

    private void mNuevoRespuestaSoporte() {
        this.directorio = new File(this.xmt.mRutaSoporte("JPSoporteRespuestaG"));
        this.JTFSoporteRespuesta.setText("");
        this.JTAObservacionSoporte.setText("");
        this.JCHEstadoSoporte.setSelected(true);
        this.xsoporterespuesta = 1;
        this.xgrabadosoporteRespuesta = 0;
    }

    private void mLlenarComboConceptoNotas() {
        this.listaConceptoNotas = this.feConceptoNotasService.listaDeConcep();
        this.JCConceptoNota.removeAllItems();
        this.listaConceptoNotas.forEach(f -> {
            this.JCConceptoNota.addItem(f.getNombre());
        });
    }

    private void guardarPresupuesto() {
        if (this.JCH_AplicaMP.isSelected()) {
            Long id = this.presupuesto.addMovimientoPpt(Long.valueOf(Long.parseLong(this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0])), this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()], this.xmt.formatoAMD.format(this.JDFFechaC.getDate()), this.JTARespuestaGlosa.getText(), this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString(), 0);
            guardarDetalle(id);
        }
    }

    private void guardarDetalle(Long id) {
        this.presupuesto.addMovimientoDetallePpt(id, this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 41).toString(), this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1], this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 30).toString(), Double.valueOf(Double.parseDouble(this.JTFFRValorAceptado.getValue().toString()) * (-1.0d)), this.JTARespuestaGlosa.getText());
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JIFGestionCartera$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Double.valueOf(table.getValueAt(row, 14).toString()).doubleValue() == 0.0d) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(new Color(255, 255, 255));
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JIFGestionCartera$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 10).toString()).booleanValue()) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(new Color(255, 255, 255));
            }
            return cell;
        }
    }

    private void mActualizarLiquidacionRespuestaGlosa() {
        this.xsql = "update f_liquidacion set VGlosaR=VGlosaR+" + this.JTFFRValorRecobrado.getValue() + ", VGlosaNR=VGlosaNR+" + this.JTFFRValorAceptado.getValue() + " where Id= '" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update f_factura_evento set Indicador='A', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 13).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private Double mActualizarValorGlosado(String xidliquidacion) {
        double xvalor = 0.0d;
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(Valor) FROM f_factura_glosa WHERE (Id_Liquidacion ='" + xidliquidacion + "' AND Estado =1 and Id_PeriodoC<='" + Principal.xclase.getXidperiodoc() + "') GROUP BY Id_Liquidacion ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                xvalor = xrs.getDouble(1);
                this.xsql = "update f_liquidacion set TGlosa='" + xvalor + "' where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xvalor);
    }

    private Double mActualizarValorPagado(String xidliquidacion) {
        double xvalor = 0.0d;
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(Valor) FROM f_factura_pagos WHERE (Id_Liquidacion ='" + xidliquidacion + "' AND Estado =1 and Id_PeriodoC<='" + Principal.xclase.getXidperiodoc() + "') GROUP BY Id_Liquidacion ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                xvalor = xrs.getDouble(1);
                this.xsql = "update f_liquidacion set TPagado='" + xvalor + "' where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            } else {
                ConsultasMySQL xct22 = new ConsultasMySQL();
                this.xsql = "update f_liquidacion set TPagado='0.0' where Id='" + xidliquidacion + "'";
                xct22.ejecutarSQL(this.xsql);
                xct22.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xvalor);
    }

    private void mActualizarValorGlosado(String xidliquidacion, int xnfila) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.xsql = "SELECT SUM(f_factura_glosa_respuesta.ValorA), SUM(f_factura_glosa_respuesta.ValorR) FROM f_factura_glosa_respuesta INNER JOIN f_factura_glosa  ON (f_factura_glosa_respuesta.Id_Factura_glosa = f_factura_glosa.Id) WHERE (f_factura_glosa.Id_Liquidacion ='" + xidliquidacion + "' AND f_factura_glosa_respuesta.Estado =1 and f_factura_glosa.Id_PeriodoC<='" + Principal.xclase.getXidperiodoc() + "' ) GROUP BY f_factura_glosa.Id_Liquidacion ";
            System.out.println(this.xsql);
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), xnfila, 17);
                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(1)), xnfila, 18);
                this.xsql = "update f_liquidacion set VGlosaR='" + xrs.getDouble(2) + "',VGlosaNR='" + xrs.getDouble(1) + "'  where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            } else {
                this.xmodelo.setValueAt(new Double(0.0d), xnfila, 17);
                this.xmodelo.setValueAt(new Double(0.0d), xnfila, 18);
                this.xsql = "update f_liquidacion set VGlosaR='0',VGlosaNR='0'  where Id='" + xidliquidacion + "'";
                xct2.ejecutarSQL(this.xsql);
                xct2.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarDatosL() {
        this.xsql = "update `f_liquidacion` set `f_liquidacion`.`TPagado`=0, `f_liquidacion`.`TGlosa`=0, `f_liquidacion`.`VGlosaNR`=0, `f_liquidacion`.`VGlosaR`=0 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_pagos`.`Id_Liquidacion`, SUM(`f_factura_pagos`.`Valor`) AS `Total`, MAX(`f_factura_pagos`.`FechaAbono`) AS `FechaA` FROM  `f_factura_pagos` INNER JOIN `f_liquidacion`  ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) WHERE ( `f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_liquidacion`.`Estado` =0 AND `f_factura_pagos`.`Estado` =1 AND `f_factura_pagos`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "') GROUP BY `f_factura_pagos`.`Id_Liquidacion`";
        } else {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_pagos`.`Id_Liquidacion`, SUM(`f_factura_pagos`.`Valor`) AS `Total`, MAX(`f_factura_pagos`.`FechaAbono`) AS `FechaA` FROM  `f_factura_pagos` INNER JOIN `f_liquidacion`  ON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_pagos`.`Estado` =1 AND `f_factura_pagos`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "') GROUP BY `f_factura_pagos`.`Id_Liquidacion`";
        }
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`TPagado`=v_f_tmp.Total, `f_liquidacion`.`FechaUltimoPago`=v_f_tmp.FechaA WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa`.`Valor`) AS ValorG  FROM  `f_factura_glosa` INNER JOIN `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) WHERE ( `f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion`";
        } else {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa`.`Valor`) AS ValorG  FROM  `f_factura_glosa` INNER JOIN `f_liquidacion`  ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion`";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`TGlosa`=v_f_tmp.ValorG  WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa_respuesta`.`ValorA`) AS `VNRecuperable`, SUM(`f_factura_glosa_respuesta`.`ValorR`) AS `VRecuperable` FROM `f_factura_glosa`INNER JOIN`f_liquidacion` ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_factura_glosa_respuesta`  ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) WHERE (`f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1 AND `f_factura_glosa_respuesta`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion` ";
        } else {
            this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_factura_glosa`.`Id_Liquidacion`, SUM(`f_factura_glosa_respuesta`.`ValorA`) AS `VNRecuperable`, SUM(`f_factura_glosa_respuesta`.`ValorR`) AS `VRecuperable` FROM `f_factura_glosa`INNER JOIN`f_liquidacion` ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_factura_glosa_respuesta`  ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`) WHERE ( `f_liquidacion`.`Estado` =0 AND `f_factura_glosa`.`Id_PeriodoC` <='" + Principal.xclase.getXidperiodoc() + "' AND `f_factura_glosa`.`Estado` =1 AND `f_factura_glosa_respuesta`.`Estado` =1) GROUP BY `f_factura_glosa`.`Id_Liquidacion` ";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `f_liquidacion`, `v_f_tmp`  SET  `f_liquidacion`.`VGlosaNR`=v_f_tmp.VNRecuperable, `f_liquidacion`.`VGlosaR`=v_f_tmp.VRecuperable WHERE `f_liquidacion`.`Id`=v_f_tmp.Id_Liquidacion");
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
    }

    private boolean mVerificaUltNivel(String xcampo) {
        System.out.println("xcampo -> " + xcampo);
        boolean xOk = false;
        String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo.trim() + "'";
        System.out.println("consulta ultimo nivel -> " + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0 || "".equals(xrs.getString("UNivel"))) {
                    JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    xOk = true;
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xcampo + " NO Existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionCartera.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }

    private boolean mValidarValoresRespuesta() {
        boolean xvalidado = true;
        if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() < Double.valueOf(this.JTFFRValorAceptado.getValue().toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor Aceptado no puede ser mayor al Valor Glosado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            xvalidado = false;
        } else if (Double.valueOf(this.JTFFRValorGlosado.getValue().toString()).doubleValue() < Double.valueOf(this.JTFFRValorRecobrado.getValue().toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor a Recobrar no puede ser mayor al Valor Glosado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            xvalidado = false;
        }
        return xvalidado;
    }

    public String quitarSaltos(String cadena) {
        return cadena.replaceAll("(\\n|\\r)", " ");
    }
}
