package ParametrizacionN;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDActividadEcoTercero;
import com.genoma.plus.controller.general.JDGenerico1Combo1Check;
import com.genoma.plus.controller.general.JDSoporteCarpeta;
import com.genoma.plus.controller.parametrizacion.JDEmpresaMision;
import com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa;
import com.genoma.plus.controller.tipoDocumentoEmpresa.VistaTipoDocumentoEmpresa;
import com.genoma.plus.controller.tipoDocumentoEmpresa.vistaNotificacionDocumentosVencidosPorEmpresa;
import com.genoma.plus.jpa.entities.AAseguradora;
import com.genoma.plus.jpa.entities.TipoAseguramientoDTO;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.projection.AAseguradoraProjection;
import com.genoma.plus.jpa.service.AAseguradoraService;
import com.genoma.plus.jpa.service.ITipoAseguramientoService;
import com.genoma.plus.jpa.service.ITipoCoberturaPlanService;
import com.genoma.plus.jpa.service.ITipoContratacionService;
import com.genoma.plus.jpa.service.ITipoDocumentoEmpresaService;
import com.genoma.plus.jpa.service.impl.TipoDocumentoEmpresaServiceImpl;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFEmpresa.class */
public class JIFFEmpresa extends JInternalFrame {
    private String[] xidtipodoc;
    private String[] xidmunicipio;
    private String[] xId_Ips;
    private String[] xidplan;
    private String[] xidregimen;
    private String[] xidtipoempresa;
    private String[] xidmanual;
    private String[] xidclasificacion;
    private String[] xidvigencia;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodeloAseguradora;
    private Object[] xdato;
    public int xidpersona;
    public Persona xjppersona;
    private int xtipo;
    private JDEmpresaMision dEmpresaMision;
    private JDCorreoConvenio jDCorreoConvenio;
    private Object[] datos;
    private List<TipoContratacionDTO> tipoContratacionDTOs;
    private List<TipoAseguramientoDTO> tipoAseguramientoDTOs;
    private List<TipoCoberturaPlanDTO> tipoCoberturaPlanDTOs;
    private List<AAseguradoraProjection> aAseguradoraProjection;
    private int isAutoGestion;
    private JButton JBAuditor;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGMetFact;
    private ButtonGroup JBGMetRedondeo;
    private ButtonGroup JBGModoFac;
    private ButtonGroup JBGTipoEntidad;
    private ButtonGroup JBGTipoP;
    private JButton JBTActividadEconomica;
    private JButton JBTCPagarPuc;
    private JButton JBTCargueTipoDoc;
    private JButton JBTContrato;
    private JButton JBTConvenioCorreo;
    private JButton JBTCuentas;
    private JButton JBTEmpresa;
    private JButton JBTEmpresa1;
    private JButton JBTEmpresaAfiliados;
    private JButton JBTEmpresaContrato;
    private JButton JBTEmpresaEstrato;
    private JButton JBTEmpresaGFactura;
    private JButton JBTEmpresaProcedimiento;
    private JButton JBTEmpresaServicios;
    private JButton JBTExportar;
    private JButton JBTExportar_tarifas;
    private JButton JBTImpuesto;
    public JButton JBTSoportes;
    private JButton JBTTipoEmpresa;
    private JButton JBTUnidadFunc;
    private JComboBox JCBClasificacion;
    private JComboBox JCBCodigoM;
    private JComboBox JCBManual;
    private JComboBox JCBMunicipio;
    private JComboBox JCBPlan;
    private JComboBox JCBRegimen;
    private JComboBox JCBTcodigo;
    private JComboBox JCBTipoEmpresa;
    private JComboBox JCBTipoIdent;
    private JComboBox JCBVigencia;
    private JComboBox JCB_GIps;
    private JComboBox JCB_TipoAseguramiento;
    private JComboBox JCB_TipoCoberturaPlan;
    private JComboBox JCB_TipoContratacion;
    private JCheckBox JCHARetencion;
    private JCheckBox JCHActivadoC;
    private JCheckBox JCHAgendaInventario;
    private JCheckBox JCHAplicaCodigoMaterial;
    private JCheckBox JCHAutogestion;
    private JCheckBox JCHBloquear;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    private JCheckBox JCHContiene1;
    private JCheckBox JCHConvenioMed;
    private JCheckBox JCHConvenioMed1;
    private JCheckBox JCHDescuentoP;
    private JCheckBox JCHEsEps;
    private JCheckBox JCHEsNomina;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoEC;
    private JCheckBox JCHFacInterna;
    private JCheckBox JCHFiltro4505;
    private JCheckBox JCHFiltroAsignarCita;
    private JCheckBox JCHFiltroCodAutorizacion;
    private JCheckBox JCHFiltroProcxEmp;
    private JCheckBox JCHGeneraMovimentoC;
    private JCheckBox JCHMCartera;
    private JCheckBox JCHMInventario;
    private JCheckBox JCHManejoResiduos;
    private JCheckBox JCHPoliza;
    private JCheckBox JCHTransportadora;
    private JCheckBox JCKBRequiereAuditoria;
    public JDateChooser JDCFechaPoliza;
    private JDateChooser JDUMovimientoC;
    private JLabel JLBMensaje;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIDatosEps;
    private JPanel JPIDatosP;
    private JPanel JPIDatosterc;
    private JPanel JPIEmpresaCont1;
    private JPanel JPIMRedondeo;
    private JPanel JPIMetodoFact;
    private JPanel JPIModoFact;
    private JPanel JPI_Convenio;
    private JPanel JPI_Historico;
    private JPanel JPI_MContable;
    private JPanel JPI_MInventario;
    private JPanel JPTipo;
    private JPanel JPTipoEntidad;
    private JRadioButton JRBCapitadoGl;
    private JRadioButton JRBCapitadoSe;
    private JRadioButton JRBEPS;
    private JRadioButton JRBEPS1;
    private JRadioButton JRBEmpresa;
    private JRadioButton JRBEvento;
    private JRadioButton JRBMetFact_0;
    private JRadioButton JRBMetFact_1;
    private JRadioButton JRBMetFact_2;
    private JRadioButton JRBPersonaJ;
    private JRadioButton JRBPersonaN;
    private JRadioButton JRB_RCentecima;
    private JRadioButton JRB_RDecima;
    private JRadioButton JRB_RNoAplica;
    private JRadioButton JRB_RSinDecimal;
    private JSpinner JSPCCita;
    private JScrollPane JSPDAseguradora;
    private JScrollPane JSPDEmpresaxC;
    private JFormattedTextField JSPDigitoV1;
    private JScrollPane JSPHistorico;
    private JSpinner JSPNDiasP;
    private JSpinner JSPNPrioridad;
    private JTable JTBAseguradora;
    private JTable JTBEmpresaxC;
    private JTable JTBHistorico;
    private JTextField JTFApellido1;
    private JTextField JTFApellido2;
    private JTextField JTFCHabilitacion;
    private JTextField JTFContacto;
    private JTextField JTFDireccion;
    private JTextField JTFEmail;
    private JTextField JTFEmailFacturaE;
    private JFormattedTextField JTFFCodRips;
    private JFormattedTextField JTFFNConvenio;
    private JFormattedTextField JTFFNDocumento;
    private JTextField JTFFax;
    private JTextField JTFFechaPoliza;
    private JTextField JTFNombre1;
    private JTextField JTFNombre2;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFRazonS;
    private JTextField JTFRuta;
    private JTextField JTFTelefono;
    private JTabbedPane JTPDatosB;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTabbedPane jTabbedPane1;
    private boolean xestado = false;
    private boolean xencontrodatos1 = false;
    private boolean xencontrodatos2 = false;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xtasportadora = 0;
    private int xestados = 1;
    private int xeseps = 0;
    private int xmodofact = 1;
    private int xmetodofact = 0;
    private int xRedondeo = 0;
    private int xfiltroprocexempresa = 0;
    private int xeps = 0;
    private int xtipobusqueda = 0;
    public int xidempresacont = 0;
    public int xminventario = 0;
    public int xtipopersona = 0;
    public int xfactinterna = 0;
    public int xconveniomed = 0;
    public int xesremisionlab = 0;
    public int xestadoec = 0;
    public int xmcartera = 0;
    public int xactivadoc = 0;
    public int xaretencion = 0;
    public int xnomina = 0;
    public int xcodigop = 0;
    public int xcodigom = 0;
    public int xmanejoresiduos = 0;
    public int xgmovcontable = 0;
    public int xagendainventario = 0;
    public int x4505 = 0;
    public int aplicaCodigoMaterial = 0;
    public int aplicaCodigoAutorizacion = 0;
    public int descuentoP = 0;
    public int habilitarParaAsignarCita = 1;
    String ruta = null;
    private final ITipoDocumentoEmpresaService xITipoDocumentoEmpresaService = (ITipoDocumentoEmpresaService) Principal.contexto.getBean(ITipoDocumentoEmpresaService.class);
    private final ITipoContratacionService tipoContratacionService = (ITipoContratacionService) Principal.contexto.getBean(ITipoContratacionService.class);
    private final ITipoAseguramientoService tipoAseguramientoService = (ITipoAseguramientoService) Principal.contexto.getBean(ITipoAseguramientoService.class);
    private final ITipoCoberturaPlanService tipoCoberturaPlanService = (ITipoCoberturaPlanService) Principal.contexto.getBean(ITipoCoberturaPlanService.class);
    private final AAseguradoraService aAseguradoraService = (AAseguradoraService) Principal.contexto.getBean(AAseguradoraService.class);

    public JIFFEmpresa(String xname, int xtipo, String xtitulo) {
        this.xtipo = 0;
        initComponents();
        setName(xname);
        setTitle(xtitulo.toUpperCase());
        this.xtipo = xtipo;
        mIniciarComponentes();
        mNuevo();
        cargarAseguradoras();
    }

    /* JADX WARN: Type inference failed for: r3v325, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v437, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v605, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGModoFac = new ButtonGroup();
        this.JBGTipoP = new ButtonGroup();
        this.JBGFiltro = new ButtonGroup();
        this.JBGTipoEntidad = new ButtonGroup();
        this.JBGMetFact = new ButtonGroup();
        this.JBGMetRedondeo = new ButtonGroup();
        this.JTPDatosB = new JTabbedPane();
        this.JPIDatosterc = new JPanel();
        this.jPanel1 = new JPanel();
        this.JBTImpuesto = new JButton();
        this.JBTCuentas = new JButton();
        this.JBTTipoEmpresa = new JButton();
        this.JBTCPagarPuc = new JButton();
        this.JBTContrato = new JButton();
        this.JBTUnidadFunc = new JButton();
        this.JBTActividadEconomica = new JButton();
        this.JBAuditor = new JButton();
        this.JBTCargueTipoDoc = new JButton();
        this.JPIDatosP = new JPanel();
        this.JTFRazonS = new JTextField();
        this.JCBTipoIdent = new JComboBox();
        this.JTFFNDocumento = new JFormattedTextField();
        this.JCBMunicipio = new JComboBox();
        this.JTFDireccion = new JTextField();
        this.JTFTelefono = new JTextField();
        this.JTFFax = new JTextField();
        this.JTFEmail = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFContacto = new JTextField();
        this.JPTipo = new JPanel();
        this.JRBPersonaN = new JRadioButton();
        this.JRBPersonaJ = new JRadioButton();
        this.JCHConvenioMed1 = new JCheckBox();
        this.JSPDigitoV1 = new JFormattedTextField();
        this.JTFApellido1 = new JTextField();
        this.JTFApellido2 = new JTextField();
        this.JTFNombre1 = new JTextField();
        this.JTFNombre2 = new JTextField();
        this.JPTipoEntidad = new JPanel();
        this.JRBEmpresa = new JRadioButton();
        this.JRBEPS = new JRadioButton();
        this.JRBEPS1 = new JRadioButton();
        this.JPI_MInventario = new JPanel();
        this.JCHTransportadora = new JCheckBox();
        this.JCHConvenioMed = new JCheckBox();
        this.JCHMInventario = new JCheckBox();
        this.JPI_MContable = new JPanel();
        this.JCHFacInterna = new JCheckBox();
        this.JCBClasificacion = new JComboBox();
        this.JCHActivadoC = new JCheckBox();
        this.JCHMCartera = new JCheckBox();
        this.JCHPoliza = new JCheckBox();
        this.JDUMovimientoC = new JDateChooser();
        this.JTFFechaPoliza = new JTextField();
        this.JDCFechaPoliza = new JDateChooser();
        this.JCHARetencion = new JCheckBox();
        this.JCHEsNomina = new JCheckBox();
        this.JCBVigencia = new JComboBox();
        this.JCHManejoResiduos = new JCheckBox();
        this.JTFCHabilitacion = new JTextField();
        this.JCKBRequiereAuditoria = new JCheckBox();
        this.JTFEmailFacturaE = new JTextField();
        this.JLBMensaje = new JLabel();
        this.JPI_Convenio = new JPanel();
        this.JPIDatosEps = new JPanel();
        this.JPIEmpresaCont1 = new JPanel();
        this.JCBManual = new JComboBox();
        this.JCHFiltroProcxEmp = new JCheckBox();
        this.JPIModoFact = new JPanel();
        this.JRBCapitadoGl = new JRadioButton();
        this.JRBEvento = new JRadioButton();
        this.JRBCapitadoSe = new JRadioButton();
        this.JSPCCita = new JSpinner();
        this.JSPDEmpresaxC = new JScrollPane();
        this.JTBEmpresaxC = new JTable();
        this.JTFFNConvenio = new JFormattedTextField();
        this.JSPNDiasP = new JSpinner();
        this.JCHEstadoEC = new JCheckBox();
        this.JSPNPrioridad = new JSpinner();
        this.JTFFCodRips = new JFormattedTextField();
        this.JCBRegimen = new JComboBox();
        this.JCBPlan = new JComboBox();
        this.JCBTipoEmpresa = new JComboBox();
        this.JCHEsEps = new JCheckBox();
        this.JCB_GIps = new JComboBox();
        this.JPIMetodoFact = new JPanel();
        this.JRBMetFact_0 = new JRadioButton();
        this.JRBMetFact_1 = new JRadioButton();
        this.JRBMetFact_2 = new JRadioButton();
        this.JCBTcodigo = new JComboBox();
        this.JCBCodigoM = new JComboBox();
        this.JPIMRedondeo = new JPanel();
        this.JRB_RNoAplica = new JRadioButton();
        this.JRB_RDecima = new JRadioButton();
        this.JRB_RCentecima = new JRadioButton();
        this.JRB_RSinDecimal = new JRadioButton();
        this.JCHGeneraMovimentoC = new JCheckBox();
        this.JCHAgendaInventario = new JCheckBox();
        this.JCHFiltro4505 = new JCheckBox();
        this.JCHFiltroCodAutorizacion = new JCheckBox();
        this.JCHFiltroAsignarCita = new JCheckBox();
        this.JCB_TipoContratacion = new JComboBox();
        this.JCB_TipoAseguramiento = new JComboBox();
        this.JCB_TipoCoberturaPlan = new JComboBox();
        this.JCHAplicaCodigoMaterial = new JCheckBox();
        this.JSPDAseguradora = new JScrollPane();
        this.JTBAseguradora = new JTable();
        this.JCHDescuentoP = new JCheckBox();
        this.JCHBloquear = new JCheckBox();
        this.JCHAutogestion = new JCheckBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JBTEmpresaContrato = new JButton();
        this.JBTEmpresaServicios = new JButton();
        this.JBTEmpresaProcedimiento = new JButton();
        this.JBTEmpresaGFactura = new JButton();
        this.JBTEmpresaEstrato = new JButton();
        this.jPanel3 = new JPanel();
        this.JBTEmpresaAfiliados = new JButton();
        this.JBTSoportes = new JButton();
        this.JBTExportar_tarifas = new JButton();
        this.JBTEmpresa = new JButton();
        this.JBTEmpresa1 = new JButton();
        this.JBTConvenioCorreo = new JButton();
        this.JPI_Historico = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JCHComienza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JCHContiene1 = new JCheckBox();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TERCERO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifconfempresa");
        setNormalBounds(null);
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFEmpresa.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFEmpresa.this.formInternalFrameClosing(evt);
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
        this.JTPDatosB.setForeground(new Color(0, 103, 0));
        this.JTPDatosB.setFont(new Font("Arial", 1, 14));
        this.JTPDatosB.addChangeListener(new ChangeListener() { // from class: ParametrizacionN.JIFFEmpresa.2
            public void stateChanged(ChangeEvent evt) {
                JIFFEmpresa.this.JTPDatosBStateChanged(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "PARAMETRIZACIÓN CONTABLE", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTImpuesto.setFont(new Font("Arial", 1, 12));
        this.JBTImpuesto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Porcentaje.png")));
        this.JBTImpuesto.setText("Impuesto");
        this.JBTImpuesto.setEnabled(false);
        this.JBTImpuesto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTImpuestoActionPerformed(evt);
            }
        });
        this.JBTCuentas.setFont(new Font("Arial", 1, 12));
        this.JBTCuentas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cuentasxempresa.png")));
        this.JBTCuentas.setText("<html><P ALIGN=center>Cuentas Bancarias");
        this.JBTCuentas.setEnabled(false);
        this.JBTCuentas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTCuentasActionPerformed(evt);
            }
        });
        this.JBTTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JBTTipoEmpresa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Empresa.png")));
        this.JBTTipoEmpresa.setText("<html><P ALIGN=center>Tipo Empresa");
        this.JBTTipoEmpresa.setEnabled(false);
        this.JBTTipoEmpresa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTTipoEmpresaActionPerformed(evt);
            }
        });
        this.JBTCPagarPuc.setFont(new Font("Arial", 1, 12));
        this.JBTCPagarPuc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Puc.png")));
        this.JBTCPagarPuc.setText("<html><P ALIGN=center>Cuenta por Pagar (Puc)");
        this.JBTCPagarPuc.setEnabled(false);
        this.JBTCPagarPuc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.6
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTCPagarPucActionPerformed(evt);
            }
        });
        this.JBTContrato.setFont(new Font("Arial", 1, 12));
        this.JBTContrato.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBTContrato.setText("Contrato");
        this.JBTContrato.setEnabled(false);
        this.JBTContrato.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.7
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTContratoActionPerformed(evt);
            }
        });
        this.JBTUnidadFunc.setFont(new Font("Arial", 1, 12));
        this.JBTUnidadFunc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBTUnidadFunc.setText("<html><P ALIGN=center>Unidad Funcional");
        this.JBTUnidadFunc.setEnabled(false);
        this.JBTUnidadFunc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.8
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTUnidadFuncActionPerformed(evt);
            }
        });
        this.JBTActividadEconomica.setFont(new Font("Arial", 1, 12));
        this.JBTActividadEconomica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTActividadEconomica.setText("<html><P ALIGN=center>Actividad Economica");
        this.JBTActividadEconomica.setEnabled(false);
        this.JBTActividadEconomica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.9
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTActividadEconomicaActionPerformed(evt);
            }
        });
        this.JBAuditor.setFont(new Font("Arial", 1, 12));
        this.JBAuditor.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Auditor40x40.png")));
        this.JBAuditor.setText("Auditores");
        this.JBAuditor.setEnabled(false);
        this.JBAuditor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.10
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBAuditorActionPerformed(evt);
            }
        });
        this.JBTCargueTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JBTCargueTipoDoc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTCargueTipoDoc.setText("CargueTipoDoc");
        this.JBTCargueTipoDoc.setEnabled(false);
        this.JBTCargueTipoDoc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.11
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTCargueTipoDocActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTCargueTipoDoc, -1, -1, 32767).addComponent(this.JBTImpuesto, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCuentas, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCPagarPuc, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTContrato).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTUnidadFunc, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTTipoEmpresa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTActividadEconomica, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAuditor, -2, 140, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTImpuesto, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCPagarPuc, -2, 50, -2).addComponent(this.JBTCuentas, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTTipoEmpresa, -2, 50, -2).addComponent(this.JBTUnidadFunc, -2, 50, -2).addComponent(this.JBTContrato, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCargueTipoDoc, -2, 50, -2)).addComponent(this.JBTActividadEconomica, -2, 50, -2).addComponent(this.JBAuditor, -2, 50, -2)).addGap(0, 0, 32767)));
        this.JPIDatosP.setBorder(BorderFactory.createEtchedBorder());
        this.JPIDatosP.setFont(new Font("Arial", 1, 12));
        this.JTFRazonS.setFont(new Font("Arial", 1, 12));
        this.JTFRazonS.setBorder(BorderFactory.createTitledBorder((Border) null, "Razón Social", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoIdent.setFont(new Font("Arial", 1, 12));
        this.JCBTipoIdent.setBorder(BorderFactory.createTitledBorder((Border) null, "TipoDoc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoIdent.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresa.12
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresa.this.JCBTipoIdentItemStateChanged(evt);
            }
        });
        this.JTFFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Doc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFFNDocumento.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFEmpresa.13
            public void focusLost(FocusEvent evt) {
                JIFFEmpresa.this.JTFFNDocumentoFocusLost(evt);
            }
        });
        this.JTFFNDocumento.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFEmpresa.14
            public void keyPressed(KeyEvent evt) {
                JIFFEmpresa.this.JTFFNDocumentoKeyPressed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDireccion.setFont(new Font("Arial", 1, 12));
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelefono.setFont(new Font("Arial", 1, 12));
        this.JTFTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFax.setFont(new Font("Arial", 1, 12));
        this.JTFFax.setBorder(BorderFactory.createTitledBorder((Border) null, "Fax", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.15
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFContacto.setFont(new Font("Arial", 1, 12));
        this.JTFContacto.setBorder(BorderFactory.createTitledBorder((Border) null, "Contacto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFContacto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.16
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JTFContactoActionPerformed(evt);
            }
        });
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGTipoP.add(this.JRBPersonaN);
        this.JRBPersonaN.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaN.setText("Persona Natural");
        this.JRBPersonaN.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.17
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBPersonaNActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBPersonaJ);
        this.JRBPersonaJ.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaJ.setSelected(true);
        this.JRBPersonaJ.setText("Persona Jurídica");
        this.JRBPersonaJ.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.18
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBPersonaJActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBPersonaN).addGap(18, 18, 18).addComponent(this.JRBPersonaJ)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPersonaN).addComponent(this.JRBPersonaJ)));
        this.JCHConvenioMed1.setFont(new Font("Arial", 1, 12));
        this.JCHConvenioMed1.setForeground(Color.blue);
        this.JCHConvenioMed1.setText("Remisión Laboratorio?");
        this.JCHConvenioMed1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.19
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHConvenioMed1ActionPerformed(evt);
            }
        });
        this.JSPDigitoV1.setBorder(BorderFactory.createTitledBorder((Border) null, "DV", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDigitoV1.setFont(new Font("Arial", 1, 12));
        this.JSPDigitoV1.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFEmpresa.20
            public void focusLost(FocusEvent evt) {
                JIFFEmpresa.this.JSPDigitoV1FocusLost(evt);
            }
        });
        this.JTFApellido1.setFont(new Font("Arial", 1, 12));
        this.JTFApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "Apellido1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFApellido2.setFont(new Font("Arial", 1, 12));
        this.JTFApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "Apellido2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre1.setFont(new Font("Arial", 1, 12));
        this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre 1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre2.setFont(new Font("Arial", 1, 12));
        this.JTFNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre 2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPTipoEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoría", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGTipoEntidad.add(this.JRBEmpresa);
        this.JRBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JRBEmpresa.setForeground(new Color(0, 0, 255));
        this.JRBEmpresa.setSelected(true);
        this.JRBEmpresa.setText("Empresa");
        this.JRBEmpresa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.21
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBEmpresaActionPerformed(evt);
            }
        });
        this.JBGTipoEntidad.add(this.JRBEPS);
        this.JRBEPS.setFont(new Font("Arial", 1, 12));
        this.JRBEPS.setForeground(new Color(0, 0, 255));
        this.JRBEPS.setText("EPS");
        this.JRBEPS.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.22
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBEPSActionPerformed(evt);
            }
        });
        this.JBGTipoEntidad.add(this.JRBEPS1);
        this.JRBEPS1.setFont(new Font("Arial", 1, 12));
        this.JRBEPS1.setForeground(new Color(0, 0, 255));
        this.JRBEPS1.setText("ARL");
        this.JRBEPS1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.23
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBEPS1ActionPerformed(evt);
            }
        });
        GroupLayout JPTipoEntidadLayout = new GroupLayout(this.JPTipoEntidad);
        this.JPTipoEntidad.setLayout(JPTipoEntidadLayout);
        JPTipoEntidadLayout.setHorizontalGroup(JPTipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoEntidadLayout.createSequentialGroup().addComponent(this.JRBEmpresa, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEPS).addGap(18, 18, 18).addComponent(this.JRBEPS1).addGap(0, 17, 32767)));
        JPTipoEntidadLayout.setVerticalGroup(JPTipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEmpresa).addComponent(this.JRBEPS).addComponent(this.JRBEPS1)));
        this.JPI_MInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "VARIABLE MODULO INVENTARIO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHTransportadora.setFont(new Font("Arial", 1, 12));
        this.JCHTransportadora.setForeground(Color.blue);
        this.JCHTransportadora.setText("Transportadora?");
        this.JCHTransportadora.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.24
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHTransportadoraActionPerformed(evt);
            }
        });
        this.JCHConvenioMed.setFont(new Font("Arial", 1, 12));
        this.JCHConvenioMed.setForeground(Color.blue);
        this.JCHConvenioMed.setText("Convenio Medicamentos?");
        this.JCHConvenioMed.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.25
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHConvenioMedActionPerformed(evt);
            }
        });
        this.JCHMInventario.setFont(new Font("Arial", 1, 12));
        this.JCHMInventario.setForeground(Color.blue);
        this.JCHMInventario.setText("Inventario?");
        this.JCHMInventario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.26
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHMInventarioActionPerformed(evt);
            }
        });
        GroupLayout JPI_MInventarioLayout = new GroupLayout(this.JPI_MInventario);
        this.JPI_MInventario.setLayout(JPI_MInventarioLayout);
        JPI_MInventarioLayout.setHorizontalGroup(JPI_MInventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MInventarioLayout.createSequentialGroup().addContainerGap().addGroup(JPI_MInventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MInventarioLayout.createSequentialGroup().addComponent(this.JCHTransportadora).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHConvenioMed)).addComponent(this.JCHMInventario, -2, 101, -2)).addContainerGap(-1, 32767)));
        JPI_MInventarioLayout.setVerticalGroup(JPI_MInventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MInventarioLayout.createSequentialGroup().addContainerGap().addGroup(JPI_MInventarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTransportadora).addComponent(this.JCHConvenioMed)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHMInventario).addContainerGap(-1, 32767)));
        this.JPI_MContable.setBorder(BorderFactory.createTitledBorder((Border) null, "VARIABLE MODULO CONTABLE", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHFacInterna.setFont(new Font("Arial", 1, 12));
        this.JCHFacInterna.setForeground(Color.blue);
        this.JCHFacInterna.setText("Factura Interna?");
        this.JCHFacInterna.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.27
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHFacInternaActionPerformed(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivadoC.setFont(new Font("Arial", 1, 12));
        this.JCHActivadoC.setForeground(Color.blue);
        this.JCHActivadoC.setSelected(true);
        this.JCHActivadoC.setText("Activado para contabilidad?");
        this.JCHActivadoC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.28
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHActivadoCActionPerformed(evt);
            }
        });
        this.JCHMCartera.setFont(new Font("Arial", 1, 12));
        this.JCHMCartera.setForeground(Color.blue);
        this.JCHMCartera.setText("Manejo Cartera");
        this.JCHMCartera.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.29
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHMCarteraActionPerformed(evt);
            }
        });
        this.JCHPoliza.setFont(new Font("Arial", 1, 12));
        this.JCHPoliza.setForeground(Color.blue);
        this.JCHPoliza.setText("Póliza?");
        this.JCHPoliza.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.30
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHPolizaActionPerformed(evt);
            }
        });
        this.JDUMovimientoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Último Movimiento Contable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDUMovimientoC.setToolTipText("Último Movimiento Contable");
        this.JDUMovimientoC.setDateFormatString("dd/MM/yyyy");
        this.JDUMovimientoC.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPoliza.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPoliza.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Poliza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaPoliza.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.31
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JTFFechaPolizaActionPerformed(evt);
            }
        });
        this.JDCFechaPoliza.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaPoliza.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaPoliza.setFont(new Font("Tahoma", 1, 12));
        this.JDCFechaPoliza.addPropertyChangeListener(new PropertyChangeListener() { // from class: ParametrizacionN.JIFFEmpresa.32
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFEmpresa.this.JDCFechaPolizaPropertyChange(evt);
            }
        });
        this.JCHARetencion.setFont(new Font("Arial", 1, 12));
        this.JCHARetencion.setForeground(Color.blue);
        this.JCHARetencion.setText("ARetención?");
        this.JCHARetencion.setToolTipText("Aplica Retención");
        this.JCHARetencion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.33
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHARetencionActionPerformed(evt);
            }
        });
        GroupLayout JPI_MContableLayout = new GroupLayout(this.JPI_MContable);
        this.JPI_MContable.setLayout(JPI_MContableLayout);
        JPI_MContableLayout.setHorizontalGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MContableLayout.createSequentialGroup().addContainerGap().addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MContableLayout.createSequentialGroup().addComponent(this.JCHFacInterna).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHMCartera, -2, 136, -2)).addComponent(this.JCBClasificacion, -2, 286, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MContableLayout.createSequentialGroup().addComponent(this.JCHActivadoC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHPoliza).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaPoliza, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaPoliza, -2, 29, -2)).addGroup(JPI_MContableLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JDUMovimientoC, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHARetencion))).addContainerGap(-1, 32767)));
        JPI_MContableLayout.setVerticalGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MContableLayout.createSequentialGroup().addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_MContableLayout.createSequentialGroup().addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFacInterna).addComponent(this.JCHMCartera).addComponent(this.JCHActivadoC).addComponent(this.JCHPoliza)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDUMovimientoC, -2, 0, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPI_MContableLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBClasificacion, -2, -1, -2)))).addGroup(JPI_MContableLayout.createSequentialGroup().addGroup(JPI_MContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFechaPoliza).addComponent(this.JDCFechaPoliza, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHARetencion))).addGap(22, 22, 22)));
        this.JCHEsNomina.setFont(new Font("Arial", 1, 12));
        this.JCHEsNomina.setForeground(Color.blue);
        this.JCHEsNomina.setText("Manejo de Nomina?");
        this.JCHEsNomina.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.34
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHEsNominaActionPerformed(evt);
            }
        });
        this.JCBVigencia.setFont(new Font("Arial", 1, 12));
        this.JCBVigencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Vigencia de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHManejoResiduos.setFont(new Font("Arial", 1, 12));
        this.JCHManejoResiduos.setForeground(Color.blue);
        this.JCHManejoResiduos.setText("Manejo de Residuos?");
        this.JCHManejoResiduos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.35
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHManejoResiduosActionPerformed(evt);
            }
        });
        this.JTFCHabilitacion.setFont(new Font("Arial", 1, 12));
        this.JTFCHabilitacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo de Habilitacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCKBRequiereAuditoria.setFont(new Font("Arial", 1, 12));
        this.JCKBRequiereAuditoria.setForeground(Color.blue);
        this.JCKBRequiereAuditoria.setText("Requiere auditoria");
        this.JTFEmailFacturaE.setFont(new Font("Arial", 1, 12));
        this.JTFEmailFacturaE.setBorder(BorderFactory.createTitledBorder((Border) null, "Email Factura Electronica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JPI_MInventario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_MContable, -2, -1, -2)).addComponent(this.JCBVigencia, -2, 332, -2).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JPTipoEntidad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHConvenioMed1).addComponent(this.JCHEstado)).addGap(38, 38, 38).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHManejoResiduos).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCHEsNomina).addGap(59, 59, 59).addComponent(this.JCKBRequiereAuditoria)))).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFNombre1, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFNombre2, -2, 171, -2)).addComponent(this.JTFEmail, -2, 340, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFEmailFacturaE, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFContacto, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFax, -2, 180, -2)).addComponent(this.JCBMunicipio, -2, 271, -2))).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBTipoIdent, -2, 66, -2).addGap(18, 18, 18).addComponent(this.JTFFNDocumento, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDigitoV1, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRazonS).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFApellido1, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFApellido2, -2, 223, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPLayout.createSequentialGroup().addGap(628, 628, 628).addComponent(this.JTFDireccion, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTelefono, -2, 139, -2).addGap(18, 18, 18).addComponent(this.JTFCHabilitacion, -2, 149, -2)))).addContainerGap(15, 32767)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNDocumento, -2, 50, -2).addComponent(this.JSPDigitoV1, -2, 50, -2).addComponent(this.JTFApellido1, -2, 50, -2).addComponent(this.JTFApellido2, -2, 50, -2).addComponent(this.JTFRazonS, -2, 50, -2)).addComponent(this.JCBTipoIdent, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTelefono, -2, 50, -2).addComponent(this.JTFDireccion, -2, 50, -2).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JTFNombre2, -2, 50, -2).addComponent(this.JTFNombre1, -2, 50, -2).addComponent(this.JTFCHabilitacion, -2, 50, -2)).addGap(11, 11, 11).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEmail, -2, 50, -2).addComponent(this.JTFFax, -2, 50, -2).addComponent(this.JTFContacto, -2, 50, -2).addComponent(this.JTFEmailFacturaE, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHConvenioMed1).addComponent(this.JCHEsNomina).addComponent(this.JCKBRequiereAuditoria)).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHEstado)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCHManejoResiduos).addGap(0, 0, 32767)))).addComponent(this.JPTipoEntidad, -2, -1, -2).addComponent(this.JPTipo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_MContable, -1, -1, 32767).addComponent(this.JPI_MInventario, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBVigencia, -2, 53, -2).addGap(10, 10, 10)));
        this.JLBMensaje.setFont(new Font("Arial", 1, 14));
        this.JLBMensaje.setForeground(Color.red);
        this.JLBMensaje.setHorizontalAlignment(0);
        GroupLayout JPIDatostercLayout = new GroupLayout(this.JPIDatosterc);
        this.JPIDatosterc.setLayout(JPIDatostercLayout);
        JPIDatostercLayout.setHorizontalGroup(JPIDatostercLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatostercLayout.createSequentialGroup().addGroup(JPIDatostercLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatostercLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JLBMensaje, -2, 1124, -2)).addGroup(JPIDatostercLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatostercLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JPIDatosP, -2, -1, -2)).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatostercLayout.setVerticalGroup(JPIDatostercLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatostercLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBMensaje, -1, -1, 32767).addContainerGap()));
        this.JTPDatosB.addTab("DATOS TERCERO", this.JPIDatosterc);
        this.JPIEmpresaCont1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBManual.setFont(new Font("Arial", 1, 12));
        this.JCBManual.setBorder(BorderFactory.createTitledBorder((Border) null, "Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroProcxEmp.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroProcxEmp.setForeground(Color.blue);
        this.JCHFiltroProcxEmp.setText("Filtro por Procedimiento");
        this.JCHFiltroProcxEmp.setToolTipText(" Filtro por procedimiento");
        this.JCHFiltroProcxEmp.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.36
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHFiltroProcxEmpActionPerformed(evt);
            }
        });
        this.JPIModoFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Modo Facturación", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGModoFac.add(this.JRBCapitadoGl);
        this.JRBCapitadoGl.setFont(new Font("Arial", 1, 12));
        this.JRBCapitadoGl.setText("Capitación");
        this.JRBCapitadoGl.setToolTipText("Capitación General");
        this.JRBCapitadoGl.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.37
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBCapitadoGlActionPerformed(evt);
            }
        });
        this.JBGModoFac.add(this.JRBEvento);
        this.JRBEvento.setFont(new Font("Arial", 1, 12));
        this.JRBEvento.setText("Evento");
        this.JRBEvento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.38
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBEventoActionPerformed(evt);
            }
        });
        this.JBGModoFac.add(this.JRBCapitadoSe);
        this.JRBCapitadoSe.setFont(new Font("Arial", 1, 12));
        this.JRBCapitadoSe.setText("Agrupación x Servicios");
        this.JRBCapitadoSe.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.39
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBCapitadoSeActionPerformed(evt);
            }
        });
        GroupLayout JPIModoFactLayout = new GroupLayout(this.JPIModoFact);
        this.JPIModoFact.setLayout(JPIModoFactLayout);
        JPIModoFactLayout.setHorizontalGroup(JPIModoFactLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIModoFactLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBCapitadoGl).addGap(18, 18, 18).addComponent(this.JRBEvento).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIModoFactLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBCapitadoSe, -2, 175, -2).addGap(25, 25, 25)));
        JPIModoFactLayout.setVerticalGroup(JPIModoFactLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIModoFactLayout.createSequentialGroup().addGroup(JPIModoFactLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCapitadoGl).addComponent(this.JRBEvento)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCapitadoSe)));
        this.JSPCCita.setFont(new Font("Arial", 1, 12));
        this.JSPCCita.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        this.JSPCCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Cupo Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDEmpresaxC.setBorder(BorderFactory.createTitledBorder((Border) null, "CONVENIOS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPDEmpresaxC.setFont(new Font("Arial", 1, 12));
        this.JTBEmpresaxC.setFont(new Font("Arial", 1, 12));
        this.JTBEmpresaxC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBEmpresaxC.setSelectionBackground(new Color(255, 255, 255));
        this.JTBEmpresaxC.setSelectionForeground(new Color(255, 0, 0));
        this.JTBEmpresaxC.setSelectionMode(0);
        this.JTBEmpresaxC.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresa.40
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresa.this.JTBEmpresaxCMouseClicked(evt);
            }
        });
        this.JSPDEmpresaxC.setViewportView(this.JTBEmpresaxC);
        this.JTFFNConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNConvenio.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasP.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasP.setModel(new SpinnerNumberModel(0, 0, 360, 5));
        this.JSPNDiasP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoEC.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEC.setForeground(Color.blue);
        this.JCHEstadoEC.setSelected(true);
        this.JCHEstadoEC.setText("Estado");
        this.JCHEstadoEC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.41
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHEstadoECActionPerformed(evt);
            }
        });
        this.JSPNPrioridad.setFont(new Font("Arial", 1, 12));
        this.JSPNPrioridad.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        this.JSPNPrioridad.setToolTipText("Nivel de Prioridad (0-10) Colores Plantilla");
        this.JSPNPrioridad.setBorder(BorderFactory.createTitledBorder((Border) null, "NP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodRips.setFont(new Font("Arial", 1, 12));
        this.JTFFCodRips.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFEmpresa.42
            public void keyTyped(KeyEvent evt) {
                JIFFEmpresa.this.JTFFCodRipsKeyTyped(evt);
            }
        });
        this.JCBRegimen.setFont(new Font("Arial", 1, 12));
        this.JCBRegimen.setBorder(BorderFactory.createTitledBorder((Border) null, "Régimen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPlan.setFont(new Font("Arial", 1, 12));
        this.JCBPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsEps.setFont(new Font("Arial", 1, 12));
        this.JCHEsEps.setForeground(Color.blue);
        this.JCHEsEps.setSelected(true);
        this.JCHEsEps.setText("Es Eps?");
        this.JCHEsEps.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.43
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHEsEpsActionPerformed(evt);
            }
        });
        this.JCB_GIps.setFont(new Font("Arial", 1, 12));
        this.JCB_GIps.setBorder(BorderFactory.createTitledBorder((Border) null, "IPS", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIMetodoFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Método de Facturación", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGMetFact.add(this.JRBMetFact_0);
        this.JRBMetFact_0.setFont(new Font("Arial", 1, 11));
        this.JRBMetFact_0.setSelected(true);
        this.JRBMetFact_0.setText("Valores Fijos");
        this.JRBMetFact_0.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.44
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBMetFact_0ActionPerformed(evt);
            }
        });
        this.JBGMetFact.add(this.JRBMetFact_1);
        this.JRBMetFact_1.setFont(new Font("Arial", 1, 11));
        this.JRBMetFact_1.setText("Servicio con % Incr. y Decrem.");
        this.JRBMetFact_1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.45
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBMetFact_1ActionPerformed(evt);
            }
        });
        this.JBGMetFact.add(this.JRBMetFact_2);
        this.JRBMetFact_2.setFont(new Font("Arial", 1, 11));
        this.JRBMetFact_2.setText("Servicio con %, Factor y Año");
        this.JRBMetFact_2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.46
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRBMetFact_2ActionPerformed(evt);
            }
        });
        GroupLayout JPIMetodoFactLayout = new GroupLayout(this.JPIMetodoFact);
        this.JPIMetodoFact.setLayout(JPIMetodoFactLayout);
        JPIMetodoFactLayout.setHorizontalGroup(JPIMetodoFactLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMetodoFactLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBMetFact_0).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIMetodoFactLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIMetodoFactLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBMetFact_2).addComponent(this.JRBMetFact_1)).addContainerGap()));
        JPIMetodoFactLayout.setVerticalGroup(JPIMetodoFactLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMetodoFactLayout.createSequentialGroup().addComponent(this.JRBMetFact_0).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBMetFact_1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBMetFact_2).addContainerGap(-1, 32767)));
        this.JCBTcodigo.setFont(new Font("Arial", 1, 12));
        this.JCBTcodigo.setModel(new DefaultComboBoxModel(new String[]{"Codigo Tarifa Procedimiento", "Codigo Real (Soat)", "Codigo Homologado(Cups)"}));
        this.JCBTcodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Codigo Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTcodigo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresa.47
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresa.this.JCBTcodigoItemStateChanged(evt);
            }
        });
        this.JCBCodigoM.setFont(new Font("Arial", 1, 12));
        this.JCBCodigoM.setModel(new DefaultComboBoxModel(new String[]{"Codigo Tarifa Suministro", "Codigo ATC", "Codigo CUM"}));
        this.JCBCodigoM.setToolTipText("");
        this.JCBCodigoM.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Codigo Medicamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCodigoM.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresa.48
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresa.this.JCBCodigoMItemStateChanged(evt);
            }
        });
        this.JCBCodigoM.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.49
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCBCodigoMActionPerformed(evt);
            }
        });
        this.JPIMRedondeo.setBorder(BorderFactory.createTitledBorder((Border) null, "Redondeo", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGMetRedondeo.add(this.JRB_RNoAplica);
        this.JRB_RNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_RNoAplica.setSelected(true);
        this.JRB_RNoAplica.setText("No Aplica");
        this.JRB_RNoAplica.setToolTipText("No Aplica");
        this.JRB_RNoAplica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.50
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRB_RNoAplicaActionPerformed(evt);
            }
        });
        this.JBGMetRedondeo.add(this.JRB_RDecima);
        this.JRB_RDecima.setFont(new Font("Arial", 1, 12));
        this.JRB_RDecima.setText("Decima");
        this.JRB_RDecima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.51
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRB_RDecimaActionPerformed(evt);
            }
        });
        this.JBGMetRedondeo.add(this.JRB_RCentecima);
        this.JRB_RCentecima.setFont(new Font("Arial", 1, 12));
        this.JRB_RCentecima.setText("Centecima");
        this.JRB_RCentecima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.52
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRB_RCentecimaActionPerformed(evt);
            }
        });
        this.JBGMetRedondeo.add(this.JRB_RSinDecimal);
        this.JRB_RSinDecimal.setFont(new Font("Arial", 1, 12));
        this.JRB_RSinDecimal.setText("Sin Decimal");
        this.JRB_RSinDecimal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.53
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JRB_RSinDecimalActionPerformed(evt);
            }
        });
        GroupLayout JPIMRedondeoLayout = new GroupLayout(this.JPIMRedondeo);
        this.JPIMRedondeo.setLayout(JPIMRedondeoLayout);
        JPIMRedondeoLayout.setHorizontalGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMRedondeoLayout.createSequentialGroup().addContainerGap().addGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_RNoAplica).addComponent(this.JRB_RSinDecimal)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_RCentecima).addComponent(this.JRB_RDecima)).addContainerGap(-1, 32767)));
        JPIMRedondeoLayout.setVerticalGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMRedondeoLayout.createSequentialGroup().addGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_RNoAplica).addComponent(this.JRB_RDecima)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIMRedondeoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_RCentecima).addComponent(this.JRB_RSinDecimal))));
        this.JCHGeneraMovimentoC.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraMovimentoC.setForeground(Color.blue);
        this.JCHGeneraMovimentoC.setText("Generar Movimiento Contable?");
        this.JCHGeneraMovimentoC.setToolTipText("Genera movimiento contable desde la generacion de la factura");
        this.JCHGeneraMovimentoC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.54
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHGeneraMovimentoCActionPerformed(evt);
            }
        });
        this.JCHAgendaInventario.setFont(new Font("Arial", 1, 12));
        this.JCHAgendaInventario.setForeground(Color.blue);
        this.JCHAgendaInventario.setText("Agenda Inventario");
        this.JCHAgendaInventario.setToolTipText("Para la visualizacion en la agenda de inventario de dispensacion de formulas");
        this.JCHAgendaInventario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.55
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHAgendaInventarioActionPerformed(evt);
            }
        });
        this.JCHFiltro4505.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro4505.setForeground(Color.blue);
        this.JCHFiltro4505.setText("Aplica 202?");
        this.JCHFiltro4505.setToolTipText("Aplica 4505?");
        this.JCHFiltro4505.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.56
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHFiltro4505ActionPerformed(evt);
            }
        });
        this.JCHFiltroCodAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroCodAutorizacion.setForeground(Color.blue);
        this.JCHFiltroCodAutorizacion.setText("Código Autorización");
        this.JCHFiltroCodAutorizacion.setToolTipText("Si el convenio necesita código autorización");
        this.JCHFiltroCodAutorizacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.57
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHFiltroCodAutorizacionActionPerformed(evt);
            }
        });
        this.JCHFiltroAsignarCita.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroAsignarCita.setForeground(Color.blue);
        this.JCHFiltroAsignarCita.setSelected(true);
        this.JCHFiltroAsignarCita.setText("Asignar Cita");
        this.JCHFiltroAsignarCita.setToolTipText("");
        this.JCHFiltroAsignarCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.58
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHFiltroAsignarCitaActionPerformed(evt);
            }
        });
        this.JCB_TipoContratacion.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoContratacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Contratación (Res014-FT025)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoAseguramiento.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoAseguramiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Aseguramiento (Res014-FT025)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoCoberturaPlan.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoCoberturaPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Plan de Cobertura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaCodigoMaterial.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaCodigoMaterial.setForeground(Color.blue);
        this.JCHAplicaCodigoMaterial.setText("Aplica Codigo Material");
        this.JCHAplicaCodigoMaterial.setToolTipText("");
        this.JCHAplicaCodigoMaterial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.59
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHAplicaCodigoMaterialActionPerformed(evt);
            }
        });
        this.JSPDAseguradora.setBorder(BorderFactory.createTitledBorder((Border) null, "ASEGURADORAS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPDAseguradora.setFont(new Font("Arial", 1, 12));
        this.JTBAseguradora.setFont(new Font("Arial", 1, 12));
        this.JTBAseguradora.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBAseguradora.setSelectionBackground(new Color(255, 255, 255));
        this.JTBAseguradora.setSelectionForeground(new Color(255, 0, 0));
        this.JTBAseguradora.setSelectionMode(0);
        this.JTBAseguradora.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresa.60
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresa.this.JTBAseguradoraMouseClicked(evt);
            }
        });
        this.JSPDAseguradora.setViewportView(this.JTBAseguradora);
        this.JCHDescuentoP.setFont(new Font("Arial", 1, 12));
        this.JCHDescuentoP.setForeground(Color.blue);
        this.JCHDescuentoP.setText("Descuento");
        this.JCHDescuentoP.setToolTipText("");
        this.JCHDescuentoP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.61
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHDescuentoPActionPerformed(evt);
            }
        });
        this.JCHBloquear.setFont(new Font("Arial", 1, 12));
        this.JCHBloquear.setForeground(Color.blue);
        this.JCHBloquear.setText("Bloquear?");
        this.JCHBloquear.setToolTipText("");
        this.JCHAutogestion.setFont(new Font("Arial", 1, 12));
        this.JCHAutogestion.setForeground(Color.blue);
        this.JCHAutogestion.setText("Autogestión");
        this.JCHAutogestion.setToolTipText("");
        GroupLayout JPIEmpresaCont1Layout = new GroupLayout(this.JPIEmpresaCont1);
        this.JPIEmpresaCont1.setLayout(JPIEmpresaCont1Layout);
        JPIEmpresaCont1Layout.setHorizontalGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDEmpresaxC).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFFCodRips, -2, 136, -2).addGap(10, 10, 10).addComponent(this.JCBRegimen, -2, 248, -2).addGap(6, 6, 6).addComponent(this.JCBPlan, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEmpresa, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCHEstadoEC)).addComponent(this.JCHEsEps, -2, 79, -2)).addGap(9, 9, 9)).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JTFFNConvenio, -2, 500, -2).addGap(14, 14, 14).addComponent(this.JCBManual, 0, -1, 32767)).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JSPCCita, -2, 101, -2).addGap(9, 9, 9).addComponent(this.JSPNDiasP, -2, 101, -2).addGap(9, 9, 9).addComponent(this.JSPNPrioridad, -2, 61, -2).addGap(9, 9, 9).addComponent(this.JCBTcodigo, -2, 210, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBCodigoM, -2, 216, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoCoberturaPlan, -2, 258, -2)).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JCB_GIps, -2, 311, -2).addGap(18, 18, 18).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAgendaInventario).addComponent(this.JCHFiltroProcxEmp)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JCHFiltro4505).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroCodAutorizacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroAsignarCita).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHDescuentoP, -2, 97, -2)).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JCHGeneraMovimentoC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAplicaCodigoMaterial, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBloquear, -2, 97, -2)))).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addComponent(this.JCB_TipoContratacion, -2, 320, -2).addGap(18, 18, 18).addComponent(this.JCB_TipoAseguramiento, -2, 310, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAutogestion, -2, 97, -2))).addGap(0, 0, 32767)))).addGroup(GroupLayout.Alignment.TRAILING, JPIEmpresaCont1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDAseguradora))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIMetodoFact, -1, -1, 32767).addComponent(this.JPIMRedondeo, -1, -1, 32767).addComponent(this.JPIModoFact, -2, 0, 32767)))).addGap(24, 24, 24)));
        JPIEmpresaCont1Layout.setVerticalGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFCodRips, -2, 50, -2).addComponent(this.JCBRegimen, -2, 50, -2).addComponent(this.JCBPlan, -2, 50, -2).addComponent(this.JCBTipoEmpresa, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPIEmpresaCont1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstadoEC).addGap(0, 0, 0).addComponent(this.JCHEsEps))).addGap(6, 6, 6).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFFNConvenio, -2, 50, -2)).addComponent(this.JCBManual, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPCCita, -2, 50, -2).addComponent(this.JSPNDiasP, -2, 50, -2).addComponent(this.JSPNPrioridad, -2, 50, -2).addComponent(this.JCBTcodigo, -2, 50, -2).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCodigoM, -2, 50, -2).addComponent(this.JCB_TipoCoberturaPlan, -2, 50, -2)))).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPIModoFact, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIMetodoFact, -2, -1, -2))).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIMRedondeo, -2, -1, -2)).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCB_GIps, -2, 50, -2).addGroup(JPIEmpresaCont1Layout.createSequentialGroup().addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltroProcxEmp).addComponent(this.JCHGeneraMovimentoC).addComponent(this.JCHAplicaCodigoMaterial).addComponent(this.JCHBloquear)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAgendaInventario).addComponent(this.JCHFiltro4505).addComponent(this.JCHFiltroCodAutorizacion).addComponent(this.JCHFiltroAsignarCita).addComponent(this.JCHDescuentoP)))))).addGap(4, 4, 4).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEmpresaCont1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoContratacion, -2, 50, -2).addComponent(this.JCB_TipoAseguramiento, -2, 50, -2)).addComponent(this.JCHAutogestion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDAseguradora, -2, 0, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDEmpresaxC, -2, 163, -2).addContainerGap()));
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaContrato.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaContrato.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contrato.png")));
        this.JBTEmpresaContrato.setText("Contrato");
        this.JBTEmpresaContrato.setEnabled(false);
        this.JBTEmpresaContrato.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.62
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaContratoActionPerformed(evt);
            }
        });
        this.JBTEmpresaServicios.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaServicios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBTEmpresaServicios.setText("Servicios");
        this.JBTEmpresaServicios.setEnabled(false);
        this.JBTEmpresaServicios.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.63
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaServiciosActionPerformed(evt);
            }
        });
        this.JBTEmpresaProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaProcedimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/procedimientos.png")));
        this.JBTEmpresaProcedimiento.setText("Procedimiento");
        this.JBTEmpresaProcedimiento.setEnabled(false);
        this.JBTEmpresaProcedimiento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.64
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaProcedimientoActionPerformed(evt);
            }
        });
        this.JBTEmpresaGFactura.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaGFactura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBTEmpresaGFactura.setText("Grupo Factura");
        this.JBTEmpresaGFactura.setEnabled(false);
        this.JBTEmpresaGFactura.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.65
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaGFacturaActionPerformed(evt);
            }
        });
        this.JBTEmpresaEstrato.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaEstrato.setIcon(new ImageIcon(getClass().getResource("/Imagenes/estratos.png")));
        this.JBTEmpresaEstrato.setText("Estrato");
        this.JBTEmpresaEstrato.setEnabled(false);
        this.JBTEmpresaEstrato.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.66
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaEstratoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTEmpresaContrato, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEmpresaServicios, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEmpresaProcedimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEmpresaGFactura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEmpresaEstrato, -2, 140, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEmpresaContrato, -2, 40, -2).addComponent(this.JBTEmpresaServicios, -2, 40, -2).addComponent(this.JBTEmpresaProcedimiento, -2, 40, -2).addComponent(this.JBTEmpresaGFactura, -2, 40, -2).addComponent(this.JBTEmpresaEstrato, -2, 40, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("MENU 1", this.jPanel2);
        this.JBTEmpresaAfiliados.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresaAfiliados.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_So2.png")));
        this.JBTEmpresaAfiliados.setText("Afiliados");
        this.JBTEmpresaAfiliados.setEnabled(false);
        this.JBTEmpresaAfiliados.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.67
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaAfiliadosActionPerformed(evt);
            }
        });
        this.JBTSoportes.setFont(new Font("Arial", 1, 12));
        this.JBTSoportes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTSoportes.setText("Soportes");
        this.JBTSoportes.setEnabled(false);
        this.JBTSoportes.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.68
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTSoportesActionPerformed(evt);
            }
        });
        this.JBTExportar_tarifas.setFont(new Font("Arial", 1, 12));
        this.JBTExportar_tarifas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar_tarifas.setText("Exportar");
        this.JBTExportar_tarifas.setEnabled(false);
        this.JBTExportar_tarifas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.69
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTExportar_tarifasActionPerformed(evt);
            }
        });
        this.JBTEmpresa.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresa.setText("Empresa en Misión");
        this.JBTEmpresa.setEnabled(false);
        this.JBTEmpresa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.70
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresaActionPerformed(evt);
            }
        });
        this.JBTEmpresa1.setFont(new Font("Arial", 1, 12));
        this.JBTEmpresa1.setText("Convenio Homologado BS1");
        this.JBTEmpresa1.setEnabled(false);
        this.JBTEmpresa1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.71
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTEmpresa1ActionPerformed(evt);
            }
        });
        this.JBTConvenioCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTConvenioCorreo.setText("Correo Convenio");
        this.JBTConvenioCorreo.setEnabled(false);
        this.JBTConvenioCorreo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.72
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTConvenioCorreoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTEmpresaAfiliados, -2, 152, -2).addGap(18, 18, 18).addComponent(this.JBTSoportes, -2, 152, -2).addGap(18, 18, 18).addComponent(this.JBTExportar_tarifas, -2, 152, -2).addGap(18, 18, 18).addComponent(this.JBTEmpresa, -2, 155, -2).addGap(18, 18, 18).addComponent(this.JBTEmpresa1).addGap(18, 18, 18).addComponent(this.JBTConvenioCorreo, -2, 152, -2).addContainerGap(181, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEmpresaAfiliados, -2, 40, -2).addComponent(this.JBTSoportes, -2, 40, -2).addComponent(this.JBTExportar_tarifas, -2, 40, -2)).addComponent(this.JBTEmpresa, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEmpresa1, -2, 40, -2).addComponent(this.JBTConvenioCorreo, -2, 40, -2))).addContainerGap(17, 32767)));
        this.jTabbedPane1.addTab("MENU 2", this.jPanel3);
        GroupLayout JPIDatosEpsLayout = new GroupLayout(this.JPIDatosEps);
        this.JPIDatosEps.setLayout(JPIDatosEpsLayout);
        JPIDatosEpsLayout.setHorizontalGroup(JPIDatosEpsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpsLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosEpsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEmpresaCont1, -2, 1222, 32767).addComponent(this.jTabbedPane1, -1, 1222, 32767))));
        JPIDatosEpsLayout.setVerticalGroup(JPIDatosEpsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpsLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIEmpresaCont1, -2, 481, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 94, -2)));
        GroupLayout JPI_ConvenioLayout = new GroupLayout(this.JPI_Convenio);
        this.JPI_Convenio.setLayout(JPI_ConvenioLayout);
        JPI_ConvenioLayout.setHorizontalGroup(JPI_ConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvenioLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatosEps, -1, -1, 32767).addContainerGap()));
        JPI_ConvenioLayout.setVerticalGroup(JPI_ConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvenioLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPIDatosEps, -1, -1, 32767).addContainerGap()));
        this.JTPDatosB.addTab("DATOS DEL CONVENIO", this.JPI_Convenio);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda Filtrada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFEmpresa.73
            public void keyTyped(KeyEvent evt) {
                JIFFEmpresa.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        this.JBGFiltro.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setText("Comienza");
        this.JCHComienza.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.74
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHComienzaActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setSelected(true);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.75
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JCHContiene1.setBackground(new Color(177, 251, 177));
        this.JCHContiene1.setFont(new Font("Arial", 1, 12));
        this.JCHContiene1.setText("Activo para contabilidad");
        this.JCHContiene1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.76
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JCHContiene1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -2, 843, -2).addGap(18, 18, 18).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHComienza).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHContiene).addGap(64, 64, 64).addComponent(this.JCHContiene1))).addContainerGap(19, 32767)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreBusqueda, -2, 50, -2).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHContiene).addComponent(this.JCHContiene1)))).addContainerGap(13, 32767)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(22);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(Color.red);
        this.JTBHistorico.setSelectionMode(0);
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresa.77
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresa.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresa.78
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresa.79
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresa.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -1, 1240, 32767).addGroup(JPI_HistoricoLayout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 234, -2)).addComponent(this.JPIDatosBusqueda, -1, -1, 32767)).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -1, 434, 32767).addGap(18, 18, 18).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        this.JTPDatosB.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPDatosB, -2, 1248, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosB));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTransportadoraActionPerformed(ActionEvent evt) {
        if (this.JCHTransportadora.isSelected()) {
            this.xtasportadora = 1;
        } else {
            this.xtasportadora = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestados = 1;
        } else {
            this.xestados = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTBHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mSeleccionarDatosTabla();
            Principal.consultar_Datos_Uvt(this.xmt.formatoANO.format(this.xmt.getFechaActual()), this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString(), new Double(0.0d).doubleValue(), new Integer(1));
            this.JLBMensaje.setText(Principal.informacionGeneralPrincipalDTO.getMensanjeContable());
            boolean hayDocumentosVencidos = this.xITipoDocumentoEmpresaService.hayDocumentosActivosVencidos(Long.parseLong(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString()));
            if (hayDocumentosVencidos) {
                vistaNotificacionDocumentosVencidosPorEmpresa documentosVencidosPorEmpresax = new vistaNotificacionDocumentosVencidosPorEmpresa(null, true, Long.parseLong(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString()));
                documentosVencidosPorEmpresax.setLocationRelativeTo(null);
            }
            mNuevoDatosConvenio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsEpsActionPerformed(ActionEvent evt) {
        if (this.JCHEsEps.isSelected()) {
            this.xeseps = 0;
        } else {
            this.xeseps = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroProcxEmpActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroProcxEmp.isSelected()) {
            this.xfiltroprocexempresa = 0;
        } else {
            this.xfiltroprocexempresa = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEventoActionPerformed(ActionEvent evt) {
        this.xmodofact = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCapitadoSeActionPerformed(ActionEvent evt) {
        this.xmodofact = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCapitadoGlActionPerformed(ActionEvent evt) {
        this.xmodofact = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBEmpresaxCMouseClicked(MouseEvent evt) {
        if (this.JTBEmpresaxC.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xidempresacont = Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 0).toString()).intValue();
            this.JTFFNConvenio.setText(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 1).toString());
            this.JCBManual.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 2).toString());
            if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 3).toString()).intValue() == 0) {
                this.JRBCapitadoSe.setSelected(true);
                this.xmodofact = 0;
            } else if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 3).toString()).intValue() == 1) {
                this.JRBCapitadoGl.setSelected(true);
                this.xmodofact = 1;
            } else {
                this.JRBEvento.setSelected(true);
                this.xmodofact = 2;
            }
            this.JCHFiltroProcxEmp.setSelected(Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 5).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 5).toString()).booleanValue()) {
                this.xfiltroprocexempresa = 0;
            } else {
                this.xfiltroprocexempresa = 1;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 7).toString()).booleanValue()) {
                this.JCHEstadoEC.setSelected(true);
                this.xestadoec = 0;
            } else {
                this.JCHEstadoEC.setSelected(false);
                this.xestadoec = 1;
            }
            int xmetfact = Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 13).toString()).intValue();
            switch (xmetfact) {
                case 0:
                    this.JRBMetFact_0.setSelected(true);
                    this.xmetodofact = 0;
                    break;
                case 1:
                    this.JRBMetFact_1.setSelected(true);
                    this.xmetodofact = 1;
                    break;
                default:
                    this.JRBMetFact_2.setSelected(true);
                    this.xmetodofact = 2;
                    break;
            }
            this.xRedondeo = Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 14).toString()).intValue();
            switch (this.xRedondeo) {
                case -2:
                    this.JRB_RCentecima.setSelected(true);
                    break;
                case -1:
                    this.JRB_RDecima.setSelected(true);
                    break;
                case 0:
                    this.JRB_RNoAplica.setSelected(true);
                    break;
                default:
                    this.JRB_RSinDecimal.setSelected(true);
                    break;
            }
            this.JBTEmpresa.setEnabled(true);
            this.JCBRegimen.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 10).toString());
            this.JTFFCodRips.setText(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 11).toString());
            this.JCB_GIps.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 12).toString());
            this.JSPCCita.setValue(Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 6).toString()));
            this.JSPNDiasP.setValue(Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 8).toString()));
            this.JSPNPrioridad.setValue(Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 9).toString()));
            this.JBTEmpresaAfiliados.setEnabled(true);
            this.JBTEmpresaEstrato.setEnabled(true);
            this.JBTEmpresaGFactura.setEnabled(true);
            this.JBTEmpresaServicios.setEnabled(true);
            this.JBTEmpresaContrato.setEnabled(true);
            this.JBTEmpresaProcedimiento.setEnabled(true);
            this.JBTUnidadFunc.setEnabled(true);
            this.JBTExportar_tarifas.setEnabled(true);
            this.JBTSoportes.setEnabled(true);
            this.JBTConvenioCorreo.setEnabled(true);
            this.xidempresacont = Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 0).toString()).intValue();
            this.xencontrodatos2 = true;
            this.JCBTcodigo.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 15).toString());
            if (null == this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 15).toString()) {
                this.xcodigop = 2;
            } else {
                switch (this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 15).toString()) {
                    case "Codigo Tarifa Procedimiento":
                        this.xcodigop = 0;
                        break;
                    case "Codigo Real (Soat)":
                        this.xcodigop = 1;
                        break;
                    default:
                        this.xcodigop = 2;
                        break;
                }
            }
            this.JCBCodigoM.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 16).toString());
            if (null == this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 16).toString()) {
                this.xcodigom = 2;
            } else {
                switch (this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 16).toString()) {
                    case "Codigo Tarifa Suministro":
                        this.xcodigom = 0;
                        break;
                    case "Codigo ATC":
                        this.xcodigom = 1;
                        break;
                    default:
                        this.xcodigom = 2;
                        break;
                }
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 17).toString()).booleanValue()) {
                this.JCHGeneraMovimentoC.setSelected(true);
                this.xgmovcontable = 1;
            } else {
                this.JCHGeneraMovimentoC.setSelected(false);
                this.xgmovcontable = 0;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 18).toString()).booleanValue()) {
                this.JCHAgendaInventario.setSelected(true);
                this.xagendainventario = 1;
            } else {
                this.JCHAgendaInventario.setSelected(false);
                this.xagendainventario = 0;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 19).toString()).booleanValue()) {
                this.JCHFiltro4505.setSelected(true);
                this.x4505 = 1;
            } else {
                this.JCHFiltro4505.setSelected(false);
                this.x4505 = 0;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 20).toString()).booleanValue()) {
                this.JCHFiltroCodAutorizacion.setSelected(true);
                this.aplicaCodigoAutorizacion = 1;
            } else {
                this.JCHFiltro4505.setSelected(false);
                this.aplicaCodigoAutorizacion = 0;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 21).toString()).booleanValue()) {
                this.JCHFiltroAsignarCita.setSelected(true);
                this.habilitarParaAsignarCita = 1;
            } else {
                this.JCHFiltroAsignarCita.setSelected(false);
                this.habilitarParaAsignarCita = 0;
            }
            this.JCB_TipoContratacion.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 22).toString());
            this.JCB_TipoAseguramiento.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 23).toString());
            this.JCB_TipoCoberturaPlan.setSelectedItem(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 24).toString());
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 25).toString()).booleanValue()) {
                this.JCHFiltro4505.setSelected(true);
            } else {
                this.JCHFiltro4505.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 26).toString()).booleanValue()) {
                this.JCHAplicaCodigoMaterial.setSelected(true);
                this.aplicaCodigoMaterial = 1;
            } else {
                this.JCHAplicaCodigoMaterial.setSelected(false);
                this.aplicaCodigoMaterial = 0;
            }
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 27).toString()).booleanValue()) {
                this.JCHDescuentoP.setSelected(true);
                this.descuentoP = 1;
            } else {
                this.JCHDescuentoP.setSelected(false);
                this.descuentoP = 0;
            }
            this.JCHBloquear.setSelected(Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 28).toString()).booleanValue());
            this.JCHAutogestion.setSelected(Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 29).toString()).booleanValue());
            return;
        }
        this.JBTEmpresaEstrato.setEnabled(false);
        this.JBTEmpresaGFactura.setEnabled(false);
        this.JBTEmpresaServicios.setEnabled(false);
        this.JBTEmpresaProcedimiento.setEnabled(false);
        this.JBTEmpresaContrato.setEnabled(false);
        this.JBTUnidadFunc.setEnabled(false);
        this.JBTEmpresaAfiliados.setEnabled(false);
        this.JBTSoportes.setEnabled(false);
        this.JBTEmpresa.setEnabled(false);
        this.JBTConvenioCorreo.setEnabled(false);
        this.xencontrodatos2 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaEstratoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("jifestratoempresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaGFacturaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("jifempresagrupo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaServiciosActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("jifempresaserviciosN", Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 13).toString()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaProcedimientoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("jifempresaprocedimiento");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaContratoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("jifcontratoempresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaNActionPerformed(ActionEvent evt) {
        this.xtipopersona = 1;
        this.JCHFacInterna.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaJActionPerformed(ActionEvent evt) {
        this.xtipopersona = 0;
        this.xidpersona = 12215;
        this.JCHFacInterna.setSelected(false);
        this.JCHFacInterna.setEnabled(false);
        this.xfactinterna = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImpuestoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Impuesto x Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCuentasActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Cuentas x Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFacInternaActionPerformed(ActionEvent evt) {
        if (this.JCHFacInterna.isSelected()) {
            this.xfactinterna = 1;
        } else {
            this.xfactinterna = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTipoEmpresaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tipo Regimen x Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
        mBuscarTercero(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHComienzaActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCPagarPucActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Cuenta Puc x Pagar Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTContratoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Contrato x Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTUnidadFuncActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Unidad Funcional x Empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xtipo == 1) {
            Principal.xclase.xjifdoccontable.mLLenar_Combo_Tercero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDocumentoFocusLost(FocusEvent evt) {
        if (!this.JTFFNDocumento.getText().isEmpty() && Principal.txtNo.getText().isEmpty() && this.JCBTipoIdent.getSelectedIndex() != -1) {
            mBuscarTercero(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConvenioMedActionPerformed(ActionEvent evt) {
        if (this.JCHConvenioMed.isSelected()) {
            this.xconveniomed = 1;
        } else {
            this.xconveniomed = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConvenioMed1ActionPerformed(ActionEvent evt) {
        if (this.JCHConvenioMed1.isSelected()) {
            this.xesremisionlab = 1;
        } else {
            this.xesremisionlab = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDigitoV1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMInventarioActionPerformed(ActionEvent evt) {
        if (this.JCHMInventario.isSelected()) {
            this.xminventario = 1;
        } else {
            this.xminventario = 0;
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
            if (this.JTBHistorico.getRowCount() > -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBHistorico, this.JTFRuta.getText(), getTitle());
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoECActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEC.isSelected()) {
            this.xestadoec = 0;
        } else {
            this.xestadoec = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMCarteraActionPerformed(ActionEvent evt) {
        if (this.JCHMCartera.isSelected()) {
            this.xmcartera = 1;
        } else {
            this.xmcartera = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPolizaActionPerformed(ActionEvent evt) {
        if (this.JCHPoliza.isSelected()) {
            this.JDCFechaPoliza.setEnabled(true);
            this.JTFFechaPoliza.setEnabled(true);
            this.JTFFechaPoliza.setText(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
        } else {
            this.JDCFechaPoliza.setEnabled(false);
            this.JTFFechaPoliza.setEnabled(false);
            this.JTFFechaPoliza.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPolizaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDCFechaPoliza.getDate() != null) {
            this.JTFFechaPoliza.setText(this.xmt.formatoAMD.format(this.JDCFechaPoliza.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar_tarifasActionPerformed(ActionEvent evt) {
        if (!this.JTFFNConvenio.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
                xfilec.setFileSelectionMode(1);
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    File xfile = xfilec.getSelectedFile();
                    this.ruta = xfile.getAbsolutePath() + this.xmt.getBarra();
                }
                mExportar3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEmpresaActionPerformed(ActionEvent evt) {
        this.xeps = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEPSActionPerformed(ActionEvent evt) {
        this.xeps = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEPS1ActionPerformed(ActionEvent evt) {
        this.xeps = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivadoCActionPerformed(ActionEvent evt) {
        if (this.JCHActivadoC.isSelected()) {
            JDEmpresa_Novedades xjde = new JDEmpresa_Novedades(null, true, Principal.txtNo.getText(), "0");
            xjde.setVisible(true);
        } else {
            JDEmpresa_Novedades xjde2 = new JDEmpresa_Novedades(null, true, Principal.txtNo.getText(), "1");
            xjde2.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNDocumento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHARetencionActionPerformed(ActionEvent evt) {
        if (this.JCHARetencion.isSelected()) {
            this.xaretencion = 1;
        } else {
            this.xaretencion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMetFact_1ActionPerformed(ActionEvent evt) {
        this.xmetodofact = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMetFact_0ActionPerformed(ActionEvent evt) {
        this.xmetodofact = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMetFact_2ActionPerformed(ActionEvent evt) {
        this.xmetodofact = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsNominaActionPerformed(ActionEvent evt) {
        if (this.JCHEsNomina.isSelected()) {
            this.xnomina = 1;
        } else {
            this.xnomina = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoIdentItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoIdent.getSelectedIndex() != -1) {
            switch (this.JCBTipoIdent.getSelectedItem().toString()) {
                case "CC":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(false);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaN.setSelected(true);
                    this.JRBPersonaJ.setEnabled(false);
                    break;
                case "CE":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(false);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaN.setSelected(true);
                    this.JRBPersonaJ.setEnabled(false);
                    break;
                case "NI":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(true);
                    this.JRBPersonaJ.setEnabled(true);
                    this.JRBPersonaJ.setSelected(true);
                    this.JRBPersonaN.setEnabled(true);
                    break;
                case "NA":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(true);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaJ.setEnabled(true);
                    break;
                case "PA":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(true);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaJ.setEnabled(true);
                    break;
                case "RC":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(false);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaJ.setEnabled(true);
                    break;
                case "TI":
                    this.JTFApellido1.setEditable(true);
                    this.JTFApellido2.setEditable(true);
                    this.JTFNombre1.setEditable(true);
                    this.JTFNombre2.setEditable(true);
                    this.JTFRazonS.setEditable(false);
                    this.JRBPersonaN.setEnabled(true);
                    this.JRBPersonaJ.setEnabled(true);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTcodigoItemStateChanged(ItemEvent evt) {
        switch (this.JCBTcodigo.getSelectedIndex()) {
            case 0:
                this.xcodigop = 0;
                break;
            case 1:
                this.xcodigop = 1;
                break;
            case 2:
                this.xcodigop = 2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCodigoMItemStateChanged(ItemEvent evt) {
        switch (this.JCBCodigoM.getSelectedIndex()) {
            case 0:
                this.xcodigom = 0;
                break;
            case 1:
                this.xcodigom = 1;
                break;
            case 2:
                this.xcodigom = 2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCodigoMActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RNoAplicaActionPerformed(ActionEvent evt) {
        this.xRedondeo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RDecimaActionPerformed(ActionEvent evt) {
        this.xRedondeo = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RCentecimaActionPerformed(ActionEvent evt) {
        this.xRedondeo = -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RSinDecimalActionPerformed(ActionEvent evt) {
        this.xRedondeo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActividadEconomicaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDActividadEcoTercero dialogAct = new JDActividadEcoTercero(null, true);
            dialogAct.setLocationRelativeTo(this);
            dialogAct.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHManejoResiduosActionPerformed(ActionEvent evt) {
        if (this.JCHManejoResiduos.isSelected()) {
            this.xmanejoresiduos = 1;
        } else {
            this.xmanejoresiduos = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGeneraMovimentoCActionPerformed(ActionEvent evt) {
        if (this.JCHGeneraMovimentoC.isSelected()) {
            this.xgmovcontable = 1;
        } else {
            this.xgmovcontable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodRipsKeyTyped(KeyEvent evt) {
        if (this.JTFFCodRips.getText().length() == 6) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAgendaInventarioActionPerformed(ActionEvent evt) {
        if (this.JCHAgendaInventario.isSelected()) {
            this.xagendainventario = 1;
        } else {
            this.xagendainventario = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltro4505ActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro4505.isSelected()) {
            this.x4505 = 1;
        } else {
            this.x4505 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroCodAutorizacionActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroCodAutorizacion.isSelected()) {
            this.aplicaCodigoAutorizacion = 1;
        } else {
            this.aplicaCodigoAutorizacion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFechaPolizaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroAsignarCitaActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroAsignarCita.isSelected()) {
            this.habilitarParaAsignarCita = 1;
        } else {
            this.habilitarParaAsignarCita = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAuditorActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Auditor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargueTipoDocActionPerformed(ActionEvent evt) {
        try {
            Long idEmpresa = Long.valueOf(Long.parseLong(Principal.txtNo.getText()));
            VistaTipoDocumentoEmpresa vista = new VistaTipoDocumentoEmpresa();
            TipoDocumentoEmpresaServiceImpl service = new TipoDocumentoEmpresaServiceImpl();
            new ControllerTipoDocumentoEmpresa(vista, service, idEmpresa, this.JTFRazonS.getText(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.usuarioSistemaDTO.getNombreUsuario());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosBStateChanged(ChangeEvent evt) {
        if (this.JTPDatosB.getSelectedIndex() == 2) {
            this.JTFNombreBusqueda.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFContactoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaAfiliadosActionPerformed(ActionEvent evt) {
        if (this.xidempresacont != 0) {
            JDGenerico1Combo1Check jd = new JDGenerico1Combo1Check(null, true, String.valueOf(this.xidempresacont), "Afiliados por Convenio");
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSoportesActionPerformed(ActionEvent evt) {
        if (this.xidempresacont != 0) {
            JDSoporteCarpeta jd = new JDSoporteCarpeta(null, true, Long.valueOf(this.xidempresacont));
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContiene1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaCodigoMaterialActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaCodigoMaterial.isSelected()) {
            this.aplicaCodigoMaterial = 1;
        } else {
            this.aplicaCodigoMaterial = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAseguradoraMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresaActionPerformed(ActionEvent evt) {
        this.dEmpresaMision = new JDEmpresaMision(null, true, this, Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 0).toString()), this);
        this.dEmpresaMision.setLocationRelativeTo(this);
        this.dEmpresaMision.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEmpresa1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDescuentoPActionPerformed(ActionEvent evt) {
        if (this.JCHDescuentoP.isSelected()) {
            this.descuentoP = 1;
        } else {
            this.descuentoP = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConvenioCorreoActionPerformed(ActionEvent evt) {
        if (this.xidempresacont != 0) {
            this.jDCorreoConvenio = new JDCorreoConvenio(null, true, this, Integer.valueOf(this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 0).toString()));
            this.jDCorreoConvenio.setLocationRelativeTo(this);
            this.jDCorreoConvenio.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mSeleccionarDatosTabla() {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString());
        this.JTFRazonS.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 1).toString());
        this.JCBTipoIdent.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 2).toString());
        this.JTFFNDocumento.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 3).toString());
        this.JSPDigitoV1.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 4).toString());
        this.JCBMunicipio.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 5).toString());
        this.JTFDireccion.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 6).toString());
        this.JTFTelefono.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 7).toString());
        this.JTFFax.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 8).toString());
        this.JTFEmail.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 9).toString());
        this.JTFContacto.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 10).toString());
        this.JTFEmailFacturaE.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 35).toString());
        switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 12).toString()).intValue()) {
            case 0:
                this.JRBEmpresa.setSelected(true);
                this.xeps = 0;
                break;
            case 1:
                this.JRBEPS.setSelected(true);
                this.xeps = 1;
                break;
            default:
                this.JRBEPS1.setSelected(true);
                this.xeps = 2;
                break;
        }
        this.JCHTransportadora.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 11).toString()).booleanValue());
        if (this.JCHTransportadora.isSelected()) {
            this.xtasportadora = 1;
        } else {
            this.xtasportadora = 0;
        }
        this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 13).toString()).booleanValue());
        if (this.JCHEstado.isSelected()) {
            this.xestados = 1;
        } else {
            this.xestados = 0;
        }
        this.JCHFacInterna.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 14).toString()).booleanValue());
        if (this.JCHFacInterna.isSelected()) {
            this.xfactinterna = 1;
        } else {
            this.xfactinterna = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 15).toString()).booleanValue()) {
            this.xtipopersona = 1;
            this.JRBPersonaN.setSelected(true);
            this.JCHFacInterna.setEnabled(true);
        } else {
            this.xtipopersona = 0;
            this.JRBPersonaJ.setSelected(true);
            this.JCHFacInterna.setEnabled(false);
        }
        this.JCHConvenioMed.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 17).toString()).booleanValue());
        if (this.JCHConvenioMed.isSelected()) {
            this.xconveniomed = 1;
        } else {
            this.xconveniomed = 0;
        }
        this.JCHConvenioMed1.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 18).toString()).booleanValue());
        if (this.JCHConvenioMed.isSelected()) {
            this.xesremisionlab = 1;
        } else {
            this.xesremisionlab = 0;
        }
        this.JCHMInventario.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 19).toString()).booleanValue());
        if (this.JCHMInventario.isSelected()) {
            this.xminventario = 1;
        } else {
            this.xminventario = 0;
        }
        this.JTFApellido1.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 20).toString());
        this.JTFApellido2.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 21).toString());
        this.JTFNombre1.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 22).toString());
        this.JTFNombre2.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 23).toString());
        this.JCHMCartera.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 24).toString()).booleanValue());
        if (this.JCHMCartera.isSelected()) {
            this.xmcartera = 1;
        } else {
            this.xmcartera = 0;
        }
        if (!this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 25).toString().equals("")) {
            this.JDCFechaPoliza.setEnabled(true);
            this.JTFFechaPoliza.setEnabled(true);
            this.JTFFechaPoliza.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 25).toString());
            this.JCHPoliza.setSelected(true);
        } else {
            this.JDCFechaPoliza.setEnabled(false);
            this.JTFFechaPoliza.setText("");
            this.JTFFechaPoliza.setEnabled(false);
            this.JCHPoliza.setSelected(false);
        }
        this.JDUMovimientoC.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 26).toString()));
        this.JCHActivadoC.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 27).toString()).booleanValue());
        if (this.JCHActivadoC.isSelected()) {
            this.xactivadoc = 1;
        } else {
            this.xactivadoc = 1;
        }
        this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 28).toString());
        this.JCHARetencion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 29).toString()).booleanValue());
        if (this.JCHARetencion.isSelected()) {
            this.xaretencion = 1;
        } else {
            this.xaretencion = 0;
        }
        this.JCHEsNomina.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 30).toString()).booleanValue());
        if (this.JCHEsNomina.isSelected()) {
            this.xnomina = 1;
        } else {
            this.xnomina = 0;
        }
        this.JCBVigencia.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 31).toString());
        this.JCHManejoResiduos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 32).toString()).booleanValue());
        if (this.JCHManejoResiduos.isSelected()) {
            this.xmanejoresiduos = 1;
        } else {
            this.xmanejoresiduos = 0;
        }
        this.JTFCHabilitacion.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 33).toString());
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 34).toString()).booleanValue()) {
            this.JCKBRequiereAuditoria.setSelected(true);
        } else {
            this.JCKBRequiereAuditoria.setSelected(false);
        }
        Boolean estado = false;
        if (this.JCKBRequiereAuditoria.isSelected()) {
            estado = true;
        }
        this.JBTImpuesto.setEnabled(true);
        this.JBTCuentas.setEnabled(true);
        this.JBTTipoEmpresa.setEnabled(true);
        this.JBTCPagarPuc.setEnabled(true);
        this.JBTContrato.setEnabled(true);
        this.JBTUnidadFunc.setEnabled(true);
        this.JBTActividadEconomica.setEnabled(true);
        this.JBAuditor.setEnabled(estado.booleanValue());
        this.JBTCargueTipoDoc.setEnabled(true);
        mCargarDatosEps();
        mCargarDatosEmpresaxConvenio();
        this.JTPDatosB.setSelectedIndex(0);
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Plantilla", 0);
                for (int x = 0; x < this.JTBHistorico.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBHistorico.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBHistorico.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Label(12, x2 + 1, this.xmodelo.getValueAt(x2, 12).toString()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo.getValueAt(x2, 13).toString()));
                    sheet.addCell(new Label(14, x2 + 1, this.xmodelo.getValueAt(x2, 14).toString()));
                    sheet.addCell(new Label(15, x2 + 1, this.xmodelo.getValueAt(x2, 15).toString()));
                    sheet.addCell(new Label(16, x2 + 1, this.xmodelo.getValueAt(x2, 16).toString()));
                    sheet.addCell(new Label(17, x2 + 1, this.xmodelo.getValueAt(x2, 17).toString()));
                    sheet.addCell(new Label(18, x2 + 1, this.xmodelo.getValueAt(x2, 18).toString()));
                    sheet.addCell(new Label(19, x2 + 1, this.xmodelo.getValueAt(x2, 19).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException | WriteException ex) {
                Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mIniciarComponentes() {
        this.xidtipodoc = this.xct.llenarCombo("SELECT Id, Id FROM g_tipoidentificacion WHERE (EsContable =1) order by Nbre ", this.xidtipodoc, this.JCBTipoIdent);
        this.JCBTipoIdent.setSelectedIndex(-1);
        this.xidmunicipio = this.xct.llenarCombo("SELECT Id, Nbre FROM g_municipio ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.xidplan = this.xct.llenarCombo("SELECT Id, Nbre, Estado FROM f_tipoplan WHERE (Estado =0) ORDER BY Nbre ASC", this.xidplan, this.JCBPlan);
        this.JCBPlan.setSelectedIndex(-1);
        this.JCBPlan.setSelectedItem("POS");
        this.xidregimen = this.xct.llenarCombo("SELECT Id, Nbre FROM f_tiporegimen WHERE (Estado =0) ORDER BY Nbre ASC", this.xidregimen, this.JCBRegimen);
        this.JCBRegimen.setSelectedIndex(-1);
        this.xidtipoempresa = this.xct.llenarCombo("SELECT Id, Nbre FROM f_tipoempresacont WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresa);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xidmanual = this.xct.llenarCombo("SELECT Id, Nbre FROM f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmanual, this.JCBManual);
        this.JCBManual.setSelectedIndex(-1);
        this.JCBClasificacion.removeAllItems();
        this.xidclasificacion = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `cc_tipo_clasificacion_tercero` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidclasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCB_GIps.removeAllItems();
        this.xId_Ips = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `g_ips` ORDER BY `Id` ASC", this.xId_Ips, this.JCB_GIps);
        this.JCB_GIps.setSelectedIndex(0);
        this.JCBVigencia.removeAllItems();
        this.xidvigencia = this.xct.llenarCombo("SELECT Id, Nbre FROM cc_tipo_vigencia_pago WHERE (Estado =1) ORDER BY Nbre ASC", this.xidvigencia, this.JCBVigencia);
        this.JCBVigencia.setSelectedIndex(0);
        this.xct.cerrarConexionBd();
        this.xestado = true;
    }

    private void mExportar3() {
        String sql;
        try {
            if (this.xfiltroprocexempresa == 0) {
                switch (this.xmetodofact) {
                    case 0:
                        sql = "SELECT \t`f_tiposervicio`.`Nbre` AS `NServicio`,\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor) ,if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)) AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,\n            f_tarifaprocedimiento.FactorMinimo\n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n            WHERE (f_empresacontxconvenio.Id ='" + this.xidempresacont + "'  \n            AND g_procedimiento.Estado=0) \n            ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC; ";
                        break;
                    case 1:
                        sql = "SELECT  `f_tiposervicio`.`Nbre` AS `NServicio`,\t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,\t\n            f_tarifaprocedimiento.FactorMinimo\n             \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n            WHERE f_empresacontxconvenio.Id ='" + this.xidempresacont + "' \n            AND g_procedimiento.Estado=0\n            ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC;";
                        break;
                    default:
                        sql = " SELECT  `f_tiposervicio`.`Nbre` AS `NServicio`,\t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)))\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100))))\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-1))\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)+((if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)*f_servicioempresaconv.Incr_Decrem)/100)),-2))\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))))\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1))\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor<>0, f_procedempresaconvenio.Valor,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2))\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,\n            f_tarifaprocedimiento.FactorMinimo\n\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n\t\t\tAND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id)\t\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n\t\t    WHERE f_empresacontxconvenio.Id ='" + this.xidempresacont + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC; ";
                        break;
                }
            } else {
                switch (this.xmetodofact) {
                    case 0:
                        sql = "SELECT `f_tiposervicio`.`Nbre` AS `NServicio`,\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo) AS Valor,\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n            f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,\n            f_tarifaprocedimiento.FactorMinimo\n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n            WHERE (f_empresacontxconvenio.Id ='" + this.xidempresacont + "'  \n            AND g_procedimiento.Estado=0) \n            ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC; ";
                        break;
                    case 1:
                        sql = "SELECT  \t`f_tiposervicio`.`Nbre` AS `NServicio`,\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n            g_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t    f_tipoplan.Nbre  AS Plan,\n            f_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n            g_procedimiento.Paquete,\n            g_procedimiento.EsCita,\n            f_tarifaprocedimiento.Id_Manual,\t\n            f_tarifaprocedimiento.FactorMinimo\n             \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n            WHERE f_empresacontxconvenio.Id ='" + this.xidempresacont + "' \n            AND g_procedimiento.Estado=0\n            ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC;";
                        break;
                    default:
                        sql = " SELECT  `f_tiposervicio`.`Nbre` AS `NServicio`,\t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\tg_procedimiento.NivelComplejidad AS Nivel_Complejidad,\n\t\tf_tipoplan.Nbre  AS Plan,\n\t\tf_tarifaprocedimiento.Id_TipoPlan  AS IdPlan,\n\t\tg_procedimiento.Paquete,\n\t\tg_procedimiento.EsCita,\n\t\tf_tarifaprocedimiento.Id_Manual AS Id_Manual,\n            f_tarifaprocedimiento.FactorMinimo\n\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n             INNER JOIN  `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) \n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n\t\t    WHERE f_empresacontxconvenio.Id ='" + this.xidempresacont + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY `f_tiposervicio`.`Nbre` ASC,Procedimiento ASC; ";
                        break;
                }
            }
            System.out.println("sql " + sql);
            this.xmt.mExportar_Datos_Formato_Consulta(sql, this.ruta + "Tarifas_procedimiento", "TARIFA DE PROCEDIMIENTO");
            String sql2 = "SELECT\n    `i_suministro`.`Id`\n    , `i_principioactivo`.`Nbre` AS `NPActivo`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_suministro`.`CodigoCUM`\n    , `i_suministro`.`RegistroInvima`\n    , `i_suministro`.`FechaVInvima`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    , `i_presentacionfarmaceutica`.`Nbre` AS `FFarmaceutica`\n    , `i_presentacioncomercial`.`Nbre` AS `PComercial`\n    , `i_tipoproducto`.`Nbre` AS `NTipoProducto`\n    , `f_tarifasuministro`.`Valor`\nFROM\n     `i_suministro`\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN  `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    INNER JOIN  `f_tarifasuministro` \n        ON (`f_tarifasuministro`.`Id_suministro` = `i_suministro`.`Id`)\nWHERE (`f_tarifasuministro`.`Id_manual` ='" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "')\nORDER BY `NSuministro` ASC";
            this.xmt.mExportar_Datos_Formato_Consulta(sql2, this.ruta + "Tarifas_Suministro", "TARIFA DE SUMINISTRO MANUAL: " + this.JCBManual.getSelectedItem());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        if (this.JTPDatosB.getSelectedIndex() == 0) {
            Principal.mLimpiarDatosP();
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
            this.JTFRazonS.setText("");
            this.JCBTipoIdent.setSelectedIndex(-1);
            this.JTFFNDocumento.setText("");
            this.JSPDigitoV1.setText("");
            this.JCBMunicipio.setSelectedIndex(-1);
            this.JTFDireccion.setText("");
            this.JTFTelefono.setText("");
            this.JTFFax.setText("");
            this.JTFEmail.setText("");
            this.JTFContacto.setText("");
            this.JTFApellido1.setText("");
            this.JTFApellido2.setText("");
            this.JTFNombre1.setText("");
            this.JTFNombre2.setText("");
            this.JTFCHabilitacion.setText("");
            this.xtasportadora = 0;
            this.xestados = 1;
            this.xfactinterna = 0;
            this.xminventario = 0;
            this.xmcartera = 0;
            this.xactivadoc = 1;
            this.xaretencion = 0;
            this.JCHARetencion.setSelected(false);
            this.JCHActivadoC.setSelected(true);
            this.JCHMCartera.setSelected(false);
            this.JCHMInventario.setSelected(false);
            this.JCHFacInterna.setSelected(false);
            this.JCHFacInterna.setEnabled(true);
            this.JCHTransportadora.setSelected(false);
            this.JCHEstado.setSelected(false);
            this.xtipopersona = 0;
            this.JCHConvenioMed1.setSelected(false);
            this.xesremisionlab = 0;
            this.JTFRazonS.requestFocus();
            this.JBTImpuesto.setEnabled(false);
            this.JBTCuentas.setEnabled(false);
            this.JBTTipoEmpresa.setEnabled(false);
            this.JBTCPagarPuc.setEnabled(false);
            this.JBTContrato.setEnabled(false);
            this.JBTUnidadFunc.setEnabled(false);
            this.JBTActividadEconomica.setEnabled(false);
            this.JBTCargueTipoDoc.setEnabled(false);
            this.JCHEstadoEC.setSelected(true);
            this.JCHEsNomina.setSelected(false);
            this.xnomina = 0;
            this.JCHManejoResiduos.setSelected(false);
            this.xmanejoresiduos = 0;
            this.xestadoec = 0;
            this.xeps = 0;
            this.JRBEmpresa.setSelected(true);
            this.JDCFechaPoliza.setEnabled(false);
            this.JTFFechaPoliza.setEnabled(false);
            this.JCBClasificacion.setSelectedIndex(-1);
            this.JCBVigencia.setSelectedIndex(-1);
            this.habilitarParaAsignarCita = 1;
            this.JCHFiltroAsignarCita.setSelected(true);
            this.JBAuditor.setEnabled(false);
            mCrearTablaHistorico();
            mNuevoDatosEps();
            llenarComboRes014();
            return;
        }
        if (this.JTPDatosB.getSelectedIndex() == 1) {
            mNuevoDatosConvenio();
        }
    }

    private void llenarComboRes014() {
        this.tipoContratacionDTOs = this.tipoContratacionService.listaPorEstadoOrdenadoPorNombre(true);
        this.JCB_TipoContratacion.removeAllItems();
        this.tipoContratacionDTOs.forEach(next -> {
            this.JCB_TipoContratacion.addItem(next.getNombre());
        });
        this.tipoAseguramientoDTOs = this.tipoAseguramientoService.listaPorEstadoOrdenadoPorNombre(true);
        this.JCB_TipoAseguramiento.removeAllItems();
        this.tipoAseguramientoDTOs.forEach(next2 -> {
            this.JCB_TipoAseguramiento.addItem(next2.getNombre());
        });
        this.tipoCoberturaPlanDTOs = this.tipoCoberturaPlanService.listaPorEstadoOrdenadoPorNombre(true);
        this.JCB_TipoCoberturaPlan.removeAllItems();
        this.tipoCoberturaPlanDTOs.forEach(next3 -> {
            this.JCB_TipoCoberturaPlan.addItem(next3.getNombre());
        });
    }

    private boolean mValida_TipoDoc() {
        boolean xvalidar_tipoD = false;
        if (this.JCBTipoIdent.getSelectedItem().toString().equals("NI")) {
            if (!this.JTFRazonS.getText().isEmpty() && !this.JSPDigitoV1.getText().isEmpty()) {
                xvalidar_tipoD = true;
            }
        } else {
            xvalidar_tipoD = true;
        }
        return xvalidar_tipoD;
    }

    private boolean mValidarDatosP() {
        boolean estado = false;
        if (this.JCBTipoIdent.getSelectedIndex() != -1) {
            if (this.JTFFNDocumento.getValue() != null || !this.JTFFNDocumento.getText().isEmpty()) {
                if (mValida_TipoDoc()) {
                    if (this.JCBMunicipio.getSelectedIndex() != -1) {
                        if (this.JCBClasificacion.getSelectedIndex() != -1) {
                            if (this.JCBVigencia.getSelectedIndex() != -1) {
                                if (this.xidpersona != -1) {
                                    estado = true;
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JRBPersonaN.requestFocus();
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una vigencia de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBVigencia.requestFocus();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBClasificacion.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBMunicipio.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "La razón social o digito de verificación no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFRazonS.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Numero de identificación no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFNDocumento.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de identificación ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoIdent.requestFocus();
        }
        return estado;
    }

    private int validarExistenciaNit(String noIdentificacion) {
        String Sql = "select COUNT(ge.No_identificacion) as registro from g_empresa ge\nwhere ge.No_identificacion ='" + noIdentificacion + "' ";
        int resultado = Integer.valueOf(this.xct.traerDato(Sql)).intValue();
        return resultado;
    }

    public void mGrabar() {
        if (this.JTPDatosB.getSelectedIndex() != 0) {
            if (this.JTPDatosB.getSelectedIndex() == 1) {
                if (!Principal.txtNo.getText().isEmpty()) {
                    mGrabarDatosEps();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe empresa seleccionada , para asignar convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            return;
        }
        String requiereAuditoria = "0";
        if (this.JCKBRequiereAuditoria.isSelected()) {
            requiereAuditoria = "1";
        }
        if (Principal.txtNo.getText().isEmpty()) {
            if (mValidarDatosP()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.xtipopersona == 1) {
                        this.xtipopersona = 0;
                    } else {
                        this.xtipopersona = 1;
                    }
                    if (this.xidtipodoc[this.JCBTipoIdent.getSelectedIndex()].toString().equals("CC")) {
                        this.JTFRazonS.setText(StringUtils.trim(this.JTFNombre1.getText()) + " " + StringUtils.trim(this.JTFNombre2.getText()) + " " + StringUtils.trim(this.JTFApellido1.getText()) + " " + StringUtils.trim(this.JTFApellido2.getText()));
                    }
                    int existe = validarExistenciaNit(StringUtils.trim(this.JTFFNDocumento.getText()));
                    if (existe == 0) {
                        String sql = "insert into g_empresa (Nbre, Id_TipoIdentificacion, No_identificacion, Dig_Verificacion, Id_Municipio, Direccion, Tel_Numero, Fax, Correo,CorreoFacturaElectronica , Contacto, Transp, Eps, Id_Persona, TipoPersona, FactInterna,  EsConvenioMp, GRetencion,  EsPlaboratorio, EsMInventario,Apellido1, Apellido2, Nombre1, Nombre2, EsManejoC, FechaPoliza,Id_ClasificacionT,  UFMovimientoC, EsNomina, Estado, Id_VigenciaP, EsManejoResiduos, CHabilitacion, requiereAuditoria, Fecha, UsuarioS) Values ('" + this.JTFRazonS.getText() + "','" + this.xidtipodoc[this.JCBTipoIdent.getSelectedIndex()] + "','" + StringUtils.trim(this.JTFFNDocumento.getText()) + "','" + this.JSPDigitoV1.getText() + "','" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "','" + this.JTFDireccion.getText() + "','" + this.JTFTelefono.getText() + "','" + this.JTFFax.getText() + "','" + this.JTFEmail.getText() + "','" + this.JTFEmailFacturaE.getText() + "','" + this.JTFContacto.getText() + "','" + this.xtasportadora + "','" + this.xeps + "','" + this.xidpersona + "','" + this.xtipopersona + "','" + this.xfactinterna + "','" + this.xesremisionlab + "','" + this.xconveniomed + "','" + this.xaretencion + "','" + this.xminventario + "','" + StringUtils.trim(this.JTFApellido1.getText()) + "','" + StringUtils.trim(this.JTFApellido2.getText()) + "','" + StringUtils.trim(this.JTFNombre1.getText()) + "','" + StringUtils.trim(this.JTFNombre2.getText()) + "','" + this.xmcartera + "','" + this.JTFFechaPoliza.getText() + "','" + this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xnomina + "','" + this.xestados + "','" + this.xidvigencia[this.JCBVigencia.getSelectedIndex()] + "','" + this.xmanejoresiduos + "','" + this.JTFCHabilitacion.getText() + "','" + requiereAuditoria + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                        this.xct.cerrarConexionBd();
                        mCargarDatosTablaHistorico("SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) AS NEmpresa, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), IF(`UFMovimientoC` IS NULL,DATE_FORMAT(NOW(),'%d/%m/%Y'),DATE_FORMAT(`UFMovimientoC`,'%d/%m/%Y')) AS FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria,`g_empresa`.`CorreoFacturaElectronica` FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`) ORDER BY IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) ASC ", 0);
                    }
                }
            }
        } else {
            String sql2 = "update g_empresa set Nbre='" + this.JTFRazonS.getText().toUpperCase() + "',Id_TipoIdentificacion='" + this.xidtipodoc[this.JCBTipoIdent.getSelectedIndex()] + "',No_identificacion='" + this.JTFFNDocumento.getText() + "',Dig_Verificacion='" + this.JSPDigitoV1.getText() + "',Id_Municipio='" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "',Direccion='" + this.JTFDireccion.getText() + "',Tel_Numero='" + this.JTFTelefono.getText() + "',Fax='" + this.JTFFax.getText() + "',Correo='" + this.JTFEmail.getText() + "',CorreoFacturaElectronica='" + this.JTFEmailFacturaE.getText() + "',Contacto='" + this.JTFContacto.getText() + "',Eps='" + this.xeps + "',Transp='" + this.xtasportadora + "',Id_Persona='" + this.xidpersona + "',TipoPersona='" + this.xtipopersona + "',FacTInterna='" + this.xfactinterna + "',EsConvenioMp='" + this.xconveniomed + "',GRetencion='" + this.xaretencion + "',EsPlaboratorio='" + this.xesremisionlab + "',EsMInventario='" + this.xminventario + "',Apellido1='" + this.JTFApellido1.getText().toUpperCase() + "',Apellido2='" + this.JTFApellido2.getText().toUpperCase() + "',Nombre1='" + this.JTFNombre1.getText().toUpperCase() + "',Nombre2='" + this.JTFNombre2.getText().toUpperCase() + "',EsManejoC='" + this.xmcartera + "',FechaPoliza='" + this.JTFFechaPoliza.getText() + "',Id_ClasificacionT='" + this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()] + "',EsNomina='" + this.xnomina + "',Estado='" + this.xestados + "',Id_VigenciaP='" + this.xidvigencia[this.JCBVigencia.getSelectedIndex()] + "',EsManejoResiduos='" + this.xmanejoresiduos + "',CHabilitacion='" + this.JTFCHabilitacion.getText() + "',requiereAuditoria='" + requiereAuditoria + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
            mCargarDatosTablaHistorico("SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) AS NEmpresa, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), IF(`UFMovimientoC` IS NULL,DATE_FORMAT(NOW(),'%d/%m/%Y'),DATE_FORMAT(`UFMovimientoC`,'%d/%m/%Y')) AS FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria, `g_empresa`.`CorreoFacturaElectronica`  FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`) ORDER BY IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) ASC ", 0);
        }
        if (!Principal.txtNo.getText().isEmpty() && this.JCKBRequiereAuditoria.isSelected()) {
            this.JBAuditor.setEnabled(true);
        } else {
            this.JBAuditor.setEnabled(false);
        }
    }

    private void cargarAseguradoras() {
        mCrearModeloAseguradora();
        this.aAseguradoraProjection = this.aAseguradoraService.ListarAseguradoras();
        if (this.aAseguradoraProjection != null && !this.aAseguradoraProjection.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTBAseguradora, 2);
            this.aAseguradoraProjection.forEach(detalle -> {
                this.xmodeloAseguradora.addRow(this.datos);
                this.JTBAseguradora.setValueAt(detalle.getId(), this.JTBAseguradora.getRowCount() - 1, 0);
                this.JTBAseguradora.setValueAt(detalle.getNbre(), this.JTBAseguradora.getRowCount() - 1, 1);
                this.JTBAseguradora.setValueAt(detalle.getCodigo(), this.JTBAseguradora.getRowCount() - 1, 2);
                this.JTBAseguradora.setValueAt(detalle.getFecha(), this.JTBAseguradora.getRowCount() - 1, 3);
            });
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloAseguradora() {
        this.xmodeloAseguradora = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Codigo", "Fecha"}) { // from class: ParametrizacionN.JIFFEmpresa.80
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBAseguradora;
        JTable jTable2 = this.JTBAseguradora;
        jTable.setAutoResizeMode(0);
        this.JTBAseguradora.doLayout();
        this.JTBAseguradora.setModel(this.xmodeloAseguradora);
        this.JTBAseguradora.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBAseguradora.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBAseguradora.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBAseguradora.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBAseguradora.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBAseguradora.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mCrearTablaEmpresaxConvenio() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Manual", "Modo", "Metodo Facturación", "FiltroEmpresa", "Cupo Cita", "Estado", "NDiasP", "NPrioridad", "Régimen", "CodRips", "DIps", "Metodo Fact", "Redondeo", "CodigoP", "CodigoM", "GMovimientoC", "AgendaInventario", "4505", "Código Autorización", "Para Asignar Citas", "Tipo Contratación", "Tipo Aseguramiento", "Tipo Plan de Cobertura", "Aplica4505", "Codigo Material?", "Descuento", "Bloquear", "esAutoGestión"}) { // from class: ParametrizacionN.JIFFEmpresa.81
            Class[] types = {Integer.class, String.class, String.class, Integer.class, String.class, Boolean.class, Integer.class, Boolean.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBEmpresaxC.setAutoResizeMode(0);
        this.JTBEmpresaxC.doLayout();
        this.JTBEmpresaxC.setModel(this.xmodelo1);
        this.JTBEmpresaxC.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBEmpresaxC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBEmpresaxC.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBEmpresaxC.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBEmpresaxC.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBEmpresaxC.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTBEmpresaxC.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTBEmpresaxC.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTBEmpresaxC.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTBEmpresaxC.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTBEmpresaxC.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTBEmpresaxC.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTBEmpresaxC.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTBEmpresaxC.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTBEmpresaxC.getColumnModel().getColumn(21).setPreferredWidth(120);
        this.JTBEmpresaxC.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTBEmpresaxC.getColumnModel().getColumn(23).setPreferredWidth(200);
        this.JTBEmpresaxC.getColumnModel().getColumn(24).setPreferredWidth(200);
        this.JTBEmpresaxC.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTBEmpresaxC.getColumnModel().getColumn(29).setPreferredWidth(100);
    }

    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "TipoID", "N° Identificación", "DV", "Municipio", "Dirección", "Teléfono", "Fax", "Email", "Contacto", "Transp?", "Eps", "Estado", "FacInterna", "Tipo Persona", "DocComodin", "EsConvMP", "EsRemisionLab", "ManejoInventario", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "EsMCartera", "FechaPoliza", "FUMovimientoC", "ActivoC", "Clasificacion", "GRetencion", "Nomina?", "VigenciaP", "MResiduos?", "CodHabilitacion", "RequiereAuditoria", "CorreoFacturaElectronica"}) { // from class: ParametrizacionN.JIFFEmpresa.82
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Boolean.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.JTBHistorico.getColumnModel().getColumn(13).setMinWidth(30);
        this.JTBHistorico.getColumnModel().getColumn(13).setMaxWidth(30);
        this.JTBHistorico.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(29).setPreferredWidth(10);
        this.JTBHistorico.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(35).setMinWidth(0);
    }

    private void mCargarDatosTablaHistorico(String sql, int xtipo) {
        mCrearTablaHistorico();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(12)), x, 11);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(13)), x, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(14)), x, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(15)), x, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(16)), x, 15);
                    this.xmodelo.setValueAt(rs.getString(17), x, 16);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(18)), x, 17);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(19)), x, 18);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(20)), x, 19);
                    this.xmodelo.setValueAt(rs.getString(21), x, 20);
                    this.xmodelo.setValueAt(rs.getString(22), x, 21);
                    this.xmodelo.setValueAt(rs.getString(23), x, 22);
                    this.xmodelo.setValueAt(rs.getString(24), x, 23);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(25)), x, 24);
                    this.xmodelo.setValueAt(rs.getString(26), x, 25);
                    this.xmodelo.setValueAt(rs.getString(27), x, 26);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(28)), x, 27);
                    this.xmodelo.setValueAt(rs.getString(29), x, 28);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(30)), x, 29);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(31)), x, 30);
                    this.xmodelo.setValueAt(rs.getString(32), x, 31);
                    this.xmodelo.setValueAt(rs.getString(33), x, 32);
                    this.xmodelo.setValueAt(rs.getString(34), x, 33);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(35)), x, 34);
                    this.xmodelo.setValueAt(rs.getString(36), x, 35);
                    this.JTBHistorico.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
                if (xtipo == 1) {
                    JOptionPane.showInternalMessageDialog(this, "Ya existe un tercero con ese tipo y N° de identificación", "VERIFICACIÓN DE TERCERO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDatosB.setSelectedIndex(2);
                    this.JTBHistorico.selectAll();
                    mSeleccionarDatosTabla();
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosEmpresaxConvenio() {
        mCrearTablaEmpresaxConvenio();
        String sql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, f_manual.Nbre, f_empresacontxconvenio.EsCapitado, f_empresacontxconvenio.FiltroProcxEmp, f_empresacontxconvenio.CupoDiaCitas, f_empresacontxconvenio.Estado, f_empresacontxconvenio.Id_EmpresaCont, f_empresacontxconvenio.NDiasP, f_empresacontxconvenio.NPrioridad,f_tiporegimen.`Nbre`, f_empresacontxconvenio.`CRips`, g_ips.`Nbre`,f_empresacontxconvenio.MetodoFact, f_empresacontxconvenio.Redondeo , IF(f_empresacontxconvenio.`TCodigo`=0,'Codigo Tarifa Procedimiento' , IF(f_empresacontxconvenio.`TCodigo`=1, 'Codigo Real (Soat)', 'Codigo Homologado(Cups)')) TCodigop , IF (f_empresacontxconvenio.TCodigoS =0,'Codigo Tarifa Suministro' , IF (f_empresacontxconvenio.`TCodigoS`=1, 'Codigo ATC', 'Codigo CUM')) TCodigom, GMovimientoContable, AgendaInventario, Aplica4505,validaCodigoAutorizacion ,   `f_empresacontxconvenio`.`HabilitarParaAsignarCita`,   g_tipo_aseguramiento.nombre as tipoAseguramiento, g_tipo_contratacion.nombre as tipoContratacion, f_tipo_cobertura_plan.nombre as tipoCoberturaPlan, f_empresacontxconvenio.Aplica4505, f_empresacontxconvenio.aplicaCodigoMaterial, f_empresacontxconvenio.Descuento, f_empresacontxconvenio.bloquear, f_empresacontxconvenio.esAutoGestion\nFROM f_manual INNER JOIN f_empresacontxconvenio  ON (f_manual.Id = f_empresacontxconvenio.Id_Manual)  INNER JOIN `f_tiporegimen`  ON (f_tiporegimen.Id = f_empresacontxconvenio.`Id_TipoRegimen`) INNER JOIN `g_ips`  ON (g_ips.Id = f_empresacontxconvenio.`Id_GIps`) inner join g_tipo_aseguramiento on  (g_tipo_aseguramiento.id=f_empresacontxconvenio.idTipoAseguramiento) inner join g_tipo_contratacion on (g_tipo_contratacion.id=f_empresacontxconvenio.idTipoContratacion) inner join f_tipo_cobertura_plan on (f_tipo_cobertura_plan.id=f_empresacontxconvenio.idTipoCoberturaPlan)   WHERE (f_empresacontxconvenio.Id_EmpresaCont ='" + Principal.txtNo.getText() + "') ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(4)), x, 3);
                    if (rs.getInt(4) == 0) {
                        this.xmodelo1.setValueAt("CAPITACION SERVICIO", x, 4);
                    } else if (rs.getInt(4) == 1) {
                        this.xmodelo1.setValueAt("CAPITACION GENERAL", x, 4);
                    } else {
                        this.xmodelo1.setValueAt("EVENTO", x, 4);
                    }
                    this.xmodelo1.setValueAt(Boolean.valueOf(!rs.getBoolean(5)), x, 5);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(6)), x, 6);
                    this.xmodelo1.setValueAt(Boolean.valueOf(!rs.getBoolean(7)), x, 7);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(9)), x, 8);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(10)), x, 9);
                    this.xmodelo1.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo1.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo1.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(14)), x, 13);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(15)), x, 14);
                    this.xmodelo1.setValueAt(rs.getString(16), x, 15);
                    this.xmodelo1.setValueAt(rs.getString(17), x, 16);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(18)), x, 17);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(19)), x, 18);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(20)), x, 19);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(21)), x, 20);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(22)), x, 21);
                    this.xmodelo1.setValueAt(rs.getString("tipoAseguramiento"), x, 23);
                    this.xmodelo1.setValueAt(rs.getString("tipoContratacion"), x, 22);
                    this.xmodelo1.setValueAt(rs.getString("tipoCoberturaPlan"), x, 24);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean("Aplica4505")), x, 25);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean("aplicaCodigoMaterial")), x, 26);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean("Descuento")), x, 27);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean("Bloquear")), x, 28);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean("esAutoGestion")), x, 29);
                    x++;
                }
            } else {
                this.xencontrodatos2 = false;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosEps() {
        String sql = "SELECT g_empresacont.Codigo, f_tiporegimen.Nbre, f_tipoplan.Nbre, f_tipoempresacont.Nbre, g_empresacont.EsEps, g_empresacont.Id_empresa FROM g_empresacont INNER JOIN f_tiporegimen  ON (g_empresacont.Id_TipoRegimen = f_tiporegimen.Id) INNER JOIN f_tipoplan  ON (g_empresacont.Id_TipoPlan = f_tipoplan.Id) INNER JOIN f_tipoempresacont  ON (g_empresacont.Id_TipoEmprCont = f_tipoempresacont.Id) WHERE (g_empresacont.Id_empresa ='" + Principal.txtNo.getText() + "') ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                this.JTFFCodRips.setText(rs.getString(1));
                this.JCBRegimen.setSelectedItem(rs.getString(2));
                this.JCBPlan.setSelectedItem(rs.getString(3));
                this.JCBTipoEmpresa.setSelectedItem(rs.getString(4));
                this.JCHEsEps.setSelected(!rs.getBoolean(5));
                this.xencontrodatos1 = true;
            } else {
                this.xencontrodatos1 = false;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevoDatosEps() {
        this.JTFFCodRips.setText("");
        this.JCBPlan.setSelectedIndex(-1);
        this.JCBPlan.setSelectedItem("POS");
        this.JCBRegimen.setSelectedIndex(-1);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.JCHEsEps.setSelected(true);
        this.xeseps = 0;
        this.JTFFNConvenio.setText("");
        this.JCBManual.setSelectedIndex(-1);
        this.JRBCapitadoGl.setSelected(true);
        this.xmodofact = 1;
        this.JCHFiltroProcxEmp.setSelected(true);
        this.xfiltroprocexempresa = 0;
        this.JSPCCita.setValue(new Integer(0));
        this.JSPNPrioridad.setValue(new Integer(0));
        this.xconveniomed = 0;
        this.JCHConvenioMed.setSelected(false);
        this.xgmovcontable = 0;
        this.JCHGeneraMovimentoC.setSelected(false);
        this.xagendainventario = 0;
        this.JCHAgendaInventario.setSelected(false);
        this.JCHAplicaCodigoMaterial.setSelected(true);
        this.aplicaCodigoMaterial = 1;
        mCrearTablaEmpresaxConvenio();
    }

    private void mNuevoDatosConvenio() {
        this.JTFFNConvenio.setText("");
        this.JTFFCodRips.setText("");
        this.xidempresacont = 0;
        this.JCBManual.setSelectedIndex(-1);
        this.JRBCapitadoGl.setSelected(true);
        this.xencontrodatos2 = false;
        this.xmodofact = 1;
        this.JCHFiltroProcxEmp.setSelected(true);
        this.xfiltroprocexempresa = 0;
        this.JSPCCita.setValue(new Integer(0));
        this.JSPNPrioridad.setValue(new Integer(0));
        this.xconveniomed = 0;
        this.JCHConvenioMed.setSelected(false);
        this.xgmovcontable = 0;
        this.JCHGeneraMovimentoC.setSelected(false);
        this.xagendainventario = 0;
        this.JCHAgendaInventario.setSelected(false);
        this.JCHFiltro4505.setSelected(false);
        this.x4505 = 0;
        this.JCHFiltroCodAutorizacion.setSelected(false);
        this.aplicaCodigoAutorizacion = 0;
        mCrearTablaEmpresaxConvenio();
        mCargarDatosEmpresaxConvenio();
        this.JRBMetFact_0.setSelected(true);
        this.xmetodofact = 0;
        this.xRedondeo = 0;
        this.JRB_RNoAplica.setSelected(true);
        this.JCBTcodigo.setSelectedIndex(0);
        this.JCBCodigoM.setSelectedIndex(0);
        this.xcodigop = 0;
        this.xcodigom = 0;
        this.habilitarParaAsignarCita = 1;
        this.JCHFiltroAsignarCita.setSelected(true);
        this.JCHAplicaCodigoMaterial.setSelected(true);
        this.JCHBloquear.setSelected(false);
        this.aplicaCodigoMaterial = 1;
    }

    private void mGabarDatosGEps() {
        if (!this.xencontrodatos1) {
            String sql = "insert into g_empresacont (Id_empresa, Codigo, Id_TipoRegimen, Id_TipoPlan, Id_TipoEmprCont, EsEps, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.JTFFCodRips.getText() + "','" + this.xidregimen[this.JCBRegimen.getSelectedIndex()] + "','" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "','" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "','" + this.xeseps + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            mCargarDatosEps();
            return;
        }
        String sql2 = "update g_empresacont set Codigo='" + this.JTFFCodRips.getText() + "', Id_TipoRegimen='" + this.xidregimen[this.JCBRegimen.getSelectedIndex()] + "', Id_TipoPlan='" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "', Id_TipoEmprCont='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "', EsEps='" + this.xeseps + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_empresa='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
    }

    private void mGrabarAseguradora() {
        Boolean existe = false;
        AAseguradora aAseguradora = new AAseguradora();
        String tipoEmpresa = this.JCBTipoEmpresa.getSelectedItem().toString();
        for (int i = 0; i < this.JTBAseguradora.getRowCount(); i++) {
            if (this.JTBAseguradora.getValueAt(i, 2).toString().equals(this.JTFFCodRips.getText())) {
                existe = true;
            }
        }
        if (tipoEmpresa.equals("SOAT") && !existe.booleanValue()) {
            aAseguradora.setNbre(this.JTFRazonS.getText());
            aAseguradora.setCodigo(this.JTFFCodRips.getText());
            aAseguradora.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            aAseguradora.setFecha(this.xmt.getFechaActual());
            this.aAseguradoraService.grabar(aAseguradora);
        }
    }

    private void mGrabarDatosEps() {
        cargarAseguradoras();
        if (!this.JTFFNConvenio.getText().isEmpty()) {
            if (this.JCBManual.getSelectedIndex() != -1) {
                if (this.JCBPlan.getSelectedIndex() != -1) {
                    if (this.JCBRegimen.getSelectedIndex() != -1) {
                        if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
                            mGabarDatosGEps();
                            if (this.xidempresacont == 0) {
                                String sql = "insert into f_empresacontxconvenio (Id_EmpresaCont, Nbre, CRips,  Id_Manual, EsCapitado, CupoDiaCitas, NDiasP, FiltroProcxEmp,  Estado,Redondeo,MetodoFact,NPrioridad, `Id_TipoPlan` , `Id_TipoRegimen`, Id_GIps,IdMunicipio , TCodigo , TCodigoS, GMovimientoContable, AgendaInventario, Fecha, UsuarioS, Aplica4505,validaCodigoAutorizacion , idTipoContratacion, idTipoAseguramiento,HabilitarParaAsignarCita, idTipoCoberturaPlan, aplicaCodigoMaterial, Descuento, esAutoGestion, bloquear)  values ('" + Principal.txtNo.getText() + "','" + this.JTFFNConvenio.getText() + "','" + this.JTFFCodRips.getText() + "','" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "','" + this.xmodofact + "','" + this.JSPCCita.getValue() + "','" + this.JSPNDiasP.getValue() + "','" + this.xfiltroprocexempresa + "','" + this.xestadoec + "','" + this.xRedondeo + "','" + this.xmetodofact + "','" + this.JSPNPrioridad.getValue() + "','" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "','" + this.xidregimen[this.JCBRegimen.getSelectedIndex()] + "','" + this.xId_Ips[this.JCB_GIps.getSelectedIndex()] + "','" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "','" + this.xcodigop + "','" + this.xcodigom + "','" + this.xgmovcontable + "','" + this.xagendainventario + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.x4505 + "','" + this.aplicaCodigoAutorizacion + "','" + this.tipoContratacionDTOs.get(this.JCB_TipoContratacion.getSelectedIndex()).getId() + "','" + this.tipoAseguramientoDTOs.get(this.JCB_TipoAseguramiento.getSelectedIndex()).getId() + "','" + this.habilitarParaAsignarCita + "','" + this.tipoCoberturaPlanDTOs.get(this.JCB_TipoCoberturaPlan.getSelectedIndex()).getId() + "','" + this.aplicaCodigoMaterial + "','" + this.descuentoP + "','" + (this.JCHAutogestion.isSelected() ? 1 : 0) + "','" + (this.JCHBloquear.isSelected() ? 1 : 0) + "')";
                                this.xct.ejecutarSQL(sql);
                                this.xct.cerrarConexionBd();
                                mCargarDatosEmpresaxConvenio();
                                mGrabarAseguradora();
                                return;
                            }
                            if (this.JTBEmpresaxC.getSelectedRow() != -1) {
                                String sql2 = "update f_empresacontxconvenio set Nbre='" + this.JTFFNConvenio.getText() + "', Id_Manual='" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "', CRips='" + this.JTFFCodRips.getText() + "', Id_GIps='" + this.xId_Ips[this.JCB_GIps.getSelectedIndex()] + "', EsCapitado='" + this.xmodofact + "', CupoDiaCitas='" + this.JSPCCita.getValue() + "', NDiasP='" + this.JSPNDiasP.getValue() + "', FiltroProcxEmp='" + this.xfiltroprocexempresa + "', Estado='" + this.xestadoec + "', Redondeo='" + this.xRedondeo + "', MetodoFact='" + this.xmetodofact + "', NPrioridad='" + this.JSPNPrioridad.getValue() + "', Id_TipoPlan='" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "', Id_TipoRegimen='" + this.xidregimen[this.JCBRegimen.getSelectedIndex()] + "', IdMunicipio='" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "', TCodigo='" + this.xcodigop + "', TCodigoS='" + this.xcodigom + "', GMovimientoContable='" + this.xgmovcontable + "', AgendaInventario='" + this.xagendainventario + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Aplica4505='" + this.x4505 + "', validaCodigoAutorizacion='" + this.aplicaCodigoAutorizacion + "', idTipoContratacion='" + this.tipoContratacionDTOs.get(this.JCB_TipoContratacion.getSelectedIndex()).getId() + "', idTipoAseguramiento='" + this.tipoAseguramientoDTOs.get(this.JCB_TipoAseguramiento.getSelectedIndex()).getId() + "', HabilitarParaAsignarCita='" + this.habilitarParaAsignarCita + "', idTipoCoberturaPlan='" + this.tipoCoberturaPlanDTOs.get(this.JCB_TipoCoberturaPlan.getSelectedIndex()).getId() + "', aplicaCodigoMaterial='" + this.aplicaCodigoMaterial + "', Descuento='" + this.descuentoP + "', bloquear='" + (this.JCHBloquear.isSelected() ? 1 : 0) + "', esAutoGestion='" + (this.JCHAutogestion.isSelected() ? 1 : 0) + "' where Id='" + this.xmodelo1.getValueAt(this.JTBEmpresaxC.getSelectedRow(), 0).toString() + "'";
                                this.xct.ejecutarSQL(sql2);
                                this.xct.cerrarConexionBd();
                                mCargarDatosEmpresaxConvenio();
                                mGrabarAseguradora();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoEmpresa.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un régimen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBRegimen.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un plan", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPlan.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBManual.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre del convenio no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFNConvenio.requestFocus();
    }

    private void mBuscarTercero(int xforma) {
        String xsql;
        if (xforma == 0) {
            if (!this.JTFNombreBusqueda.getText().isEmpty()) {
                if (this.xtipobusqueda == 0) {
                    xsql = "SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) AS NEmpresa, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), if(`UFMovimientoC` IS NULL,date_format(NOW(),'%d/%m/%Y'),date_format(`UFMovimientoC`,'%d/%m/%Y')) as FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria , `g_empresa`.`CorreoFacturaElectronica` FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`)  where (IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) LIKE '" + this.JTFNombreBusqueda.getText() + "%' or g_empresa.No_identificacion LIKE '" + this.JTFNombreBusqueda.getText() + "%') ORDER BY IF(g_empresa.Nbre='',  IF(g_empresa.`TipoPersona`=0,CONCAT(g_empresa.`Apellido1`,' ',g_empresa.`Apellido2`,' ', g_empresa.`Nombre1`,' ', g_empresa.`Nombre2`) ,g_empresa.Nbre) , g_empresa.Nbre) ASC ";
                } else {
                    xsql = "SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) AS NEmpresa, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), if(`UFMovimientoC` IS NULL,date_format(NOW(),'%d/%m/%Y'),date_format(`UFMovimientoC`,'%d/%m/%Y')) as FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria , `g_empresa`.`CorreoFacturaElectronica` FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`)  where (IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) LIKE '%" + this.JTFNombreBusqueda.getText() + "%' or g_empresa.No_identificacion LIKE '%" + this.JTFNombreBusqueda.getText() + "%') ORDER BY IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) ";
                }
                mCargarDatosTablaHistorico(xsql, 0);
                return;
            }
            mCargarDatosTablaHistorico("SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) AS NEmpresa, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), if(`UFMovimientoC` IS NULL,date_format(NOW(),'%d/%m/%Y'),date_format(`UFMovimientoC`,'%d/%m/%Y')) as FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria ,`g_empresa`.`CorreoFacturaElectronica` FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`)  ORDER BY IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) ASC ", 0);
            return;
        }
        String xsql2 = "SELECT g_empresa.Id, IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre), g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre, g_empresa.Direccion, g_empresa.Tel_Numero, g_empresa.Fax, g_empresa.Correo, g_empresa.Contacto, g_empresa.Transp, g_empresa.Eps, g_empresa.Estado, g_empresa.FacTInterna, g_empresa.TipoPersona, g_empresa.DocComodin, g_empresa.EsConvenioMp, g_empresa.EsPlaboratorio, g_empresa.EsMInventario, Apellido1, Apellido2, Nombre1, Nombre2, g_empresa.EsManejoC,IF(`FechaPoliza` IS NULL,'',FechaPoliza), if(`UFMovimientoC` IS NULL,date_format(NOW(),'%d/%m/%Y'),date_format(`UFMovimientoC`,'%d/%m/%Y')) as FUMovimiento, `ActivoC`, `cc_tipo_clasificacion_tercero`.`Nbre`, GRetencion, g_empresa.EsNomina, `cc_tipo_vigencia_pago`.`Nbre` AS vigencia, g_empresa.EsManejoResiduos, g_empresa.CHabilitacion, g_empresa.requiereAuditoria, `g_empresa`.`CorreoFacturaElectronica` FROM g_empresa  INNER JOIN g_municipio  ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_tipo_clasificacion_tercero`  ON (`g_empresa`.`Id_ClasificacionT` = `cc_tipo_clasificacion_tercero`.`Id`) INNER JOIN `cc_tipo_vigencia_pago` ON (`g_empresa`.`Id_VigenciaP` = `cc_tipo_vigencia_pago`.`Id`)  WHERE g_empresa.Id_TipoIdentificacion ='" + this.JCBTipoIdent.getSelectedItem() + "'and g_empresa.No_identificacion='" + this.JTFFNDocumento.getText() + "' ORDER BY IF(g_empresa.Nbre='',  IF( g_empresa.Id_TipoIdentificacion='NI' ,g_empresa.Nbre,CONCAT(Apellido1,' ', Apellido2,' ', Nombre1,' ', Nombre2)) , g_empresa.Nbre) ASC ";
        mCargarDatosTablaHistorico(xsql2, 1);
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFEmpresa$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 27).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[3][2];
        parametros[0][0] = "id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero", parametros);
    }
}
