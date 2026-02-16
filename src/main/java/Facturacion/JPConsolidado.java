package Facturacion;

import Acceso.Principal;
import Armado.JIFCuentaCobroCapitacionServicio;
import General.Anular;
import General.ClaseImpresionInformes;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Interceptores.InterceptorManager;
import Utilidades.Metodos;
import co.com.genomaempresarial.ankara.dto.Adjunto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.facturacion.dto.DetalleConsolidadoDTO;
import com.genoma.plus.controller.gcuenta.GeneracionFacturaElectronica;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.trazabilidad.TrazabilidadProcesoDTO;
import com.genoma.plus.jpa.entities.CcDetalleDocumentoc;
import com.genoma.plus.jpa.entities.CcDocumentoc;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcPuc;
import com.genoma.plus.jpa.entities.CcTipoClasificacionTercero;
import com.genoma.plus.jpa.entities.CcTipoDocumentoc;
import com.genoma.plus.jpa.entities.CcTipoVigenciaPago;
import com.genoma.plus.jpa.entities.DatosIpsEntity;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FCuentacobro;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FFacturaEventoDetalle;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEtapaProceso;
import com.genoma.plus.jpa.entities.GMunicipio;
import com.genoma.plus.jpa.entities.GruposervicioEntity;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.ResolucionDianDTO;
import com.genoma.plus.jpa.entities.SubgrupoEmpresaEntity;
import com.genoma.plus.jpa.entities.SubgruposervicioEntity;
import com.genoma.plus.jpa.entities.TipoAseguramientoDTO;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.entities.TipoPlanEntity;
import com.genoma.plus.jpa.entities.TipoRegimenEntity;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.FFacturaEventoDetalleService;
import com.genoma.plus.jpa.service.FFacturaEventoService;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import com.genoma.plus.jpa.service.ICcDocumentocService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IFCuentacobroService;
import com.genoma.plus.jpa.service.IFacturaElectronicaDAO;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ISubgrupoEmpresaService;
import com.genoma.plus.jpa.service.ISubgrupoServicioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPConsolidado.class */
public class JPConsolidado extends JPanel {
    private JIFLiqServicios xjifliq;
    private String xsql;
    private String xvalor;
    private String xfecha;
    private boolean xlleno;
    private String[][] xId_Grupo;
    private String[][] xId_SubGrupo;
    private String[] xcCosto;
    private String[][] xId_Fpago;
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private String[] xid_tipodoc;
    private String[] xidperiodo;
    private IResolucionFacturaElectronica resolucionDian;
    private List<ICargarCombo> medioDePago;
    private String idFacturaEvento;
    private List<Adjunto> adjunto;
    private JIFCuentaCobroCapitacionServicio cuentaCobroCapitacionServicio;
    private EmpresaContConvenioEntity empresaContConvenioEntity;
    private GEmpresa gEmpresaEntity;
    private SubgrupoEmpresaEntity subgrupoEmpresaEntity;
    private SubgruposervicioEntity subgruposervicioEntity;
    private LiquidacionEntity liquidacionEntity;
    private List<LiquidacionEntity> listFacturasVentaCop;
    private FFacturaEvento facturaEvento;
    private FFacturaEventoDetalle fFacturaEventoDetalle;
    private FCuentacobro fCuentacobro;
    private CcDocumentoc cCDocumentoc;
    private ButtonGroup JBG_FFactura;
    private ButtonGroup JBG_TFactura;
    private JButton JBT_EnvioDian;
    private JButton JBT_OrdenSalida;
    private JComboBox JCBFPago;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBTipoDocC;
    private JComboBox JCB_FGrupo;
    private JComboBox JCB_FSubGrupo;
    private JCheckBox JCH_Prefactura;
    private JDateChooser JDFFechaR;
    private JLabel JLB_EstadoDian;
    private JLabel JLB_InformacionTope;
    private JLabel JLB_MensajeDian;
    private JPanel JPI_Datos1;
    private JPanel JPI_Datos2;
    private JPanel JPI_DatosF;
    private JPanel JPI_FTipoG;
    private JPanel JPI_Modo;
    private JPanel JPI_Totales;
    private JRadioButton JRB_TAmbos;
    private JRadioButton JRB_TEps;
    private JRadioButton JRB_TPaciente;
    private JRadioButton JRB_VImpresora;
    private JRadioButton JRB_VPreliminar;
    private JScrollPane JSPDetalle;
    private JScrollPane JSP_FObservacion;
    private JSpinner JSP_NFolios;
    private JTextArea JTA_FObservacion;
    private JTabbedPane JTB_Datos;
    private JTable JTDetalle;
    private JFormattedTextField JTFF_TCModeradora_Copago;
    private JFormattedTextField JTFF_TDescuento;
    private JFormattedTextField JTFF_TEps;
    private JFormattedTextField JTFF_TNPlan;
    private JFormattedTextField JTFF_TPlan;
    private JFormattedTextField JTFF_TSubtotal;
    private JFormattedTextField JTFF_TUsuario;
    private JTextField JTF_FFechaFO;
    private JTextField JTF_FNFacturaO;
    private JTextField JTF_FNFactura_P;
    private JTextField JTF_FechaFOP;
    private JTextField JTF_NoDocContable;
    private JButton btnGrabarFactura;
    private JPanel jPanel1;
    private JTextField txtNoFactura;
    private int xTipo_Factura = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Integer formaVisualizacion = 1;
    private boolean mlleno = false;
    private int xEstado = 0;
    private long xId_Liquidacion = 0;
    private final IResolucionDianDAO xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);
    private IFacturaElectronicaDAO xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);
    private final IEmpresaContConvenioService iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
    private final IGEmpresaService iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
    private final ISubgrupoEmpresaService iSubgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
    private final ISubgrupoServicioService iSubgrupoServicioService = (ISubgrupoServicioService) Principal.contexto.getBean(ISubgrupoServicioService.class);
    private ILiquidacionService iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
    private FFacturaEventoService fFacturaEventoService = (FFacturaEventoService) Principal.contexto.getBean(FFacturaEventoService.class);
    private FFacturaEventoDetalleService fFacturaEventoDetalleService = (FFacturaEventoDetalleService) Principal.contexto.getBean(FFacturaEventoDetalleService.class);
    private IFCuentacobroService iFCuentacobroService = (IFCuentacobroService) Principal.contexto.getBean(IFCuentacobroService.class);
    private final ICcDocumentocService ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
    private List<DetalleConsolidadoDTO> listDetalleConsolidadoDTO = new ArrayList();
    private long numeroFcturaCopago = 0;

    public JPConsolidado(JIFLiqServicios xjifliq) {
        initComponents();
        this.xjifliq = xjifliq;
        this.idFacturaEvento = "0";
        this.adjunto = new ArrayList();
        mNuevo();
        mValidaResolucionDian(true);
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_TFactura = new ButtonGroup();
        this.JBG_FFactura = new ButtonGroup();
        this.JPI_DatosF = new JPanel();
        this.JCB_FGrupo = new JComboBox();
        this.JCB_FSubGrupo = new JComboBox();
        this.JPI_FTipoG = new JPanel();
        this.JRB_TEps = new JRadioButton();
        this.JRB_TPaciente = new JRadioButton();
        this.JRB_TAmbos = new JRadioButton();
        this.JTF_FNFacturaO = new JTextField();
        this.JTF_FFechaFO = new JTextField();
        this.JTF_FNFactura_P = new JTextField();
        this.JTF_FechaFOP = new JTextField();
        this.JSP_FObservacion = new JScrollPane();
        this.JTA_FObservacion = new JTextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Totales = new JPanel();
        this.JTFF_TSubtotal = new JFormattedTextField();
        this.JTFF_TPlan = new JFormattedTextField();
        this.JTFF_TNPlan = new JFormattedTextField();
        this.JTFF_TCModeradora_Copago = new JFormattedTextField();
        this.JTFF_TDescuento = new JFormattedTextField();
        this.JTFF_TUsuario = new JFormattedTextField();
        this.JTFF_TEps = new JFormattedTextField();
        this.JLB_InformacionTope = new JLabel();
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JPI_Modo = new JPanel();
        this.JRB_VPreliminar = new JRadioButton();
        this.JRB_VImpresora = new JRadioButton();
        this.JSP_NFolios = new JSpinner();
        this.JBT_OrdenSalida = new JButton();
        this.JBT_EnvioDian = new JButton();
        this.JLB_MensajeDian = new JLabel();
        this.JLB_EstadoDian = new JLabel();
        this.JCH_Prefactura = new JCheckBox();
        this.JPI_Datos2 = new JPanel();
        this.JCBTipoDocC = new JComboBox();
        this.JCBPeriodoC = new JComboBox();
        this.JCBFPago = new JComboBox();
        this.JTF_NoDocContable = new JTextField();
        this.JCBMedioDePago = new JComboBox<>();
        this.jPanel1 = new JPanel();
        this.btnGrabarFactura = new JButton();
        this.txtNoFactura = new JTextField();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO DE SERVICIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjp_consolidadon");
        this.JPI_DatosF.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE FACTURA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_FGrupo.setFont(new Font("Arial", 1, 12));
        this.JCB_FGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_FGrupo.addItemListener(new ItemListener() { // from class: Facturacion.JPConsolidado.1
            public void itemStateChanged(ItemEvent evt) {
                JPConsolidado.this.JCB_FGrupoItemStateChanged(evt);
            }
        });
        this.JCB_FSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCB_FSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPI_FTipoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_TFactura.add(this.JRB_TEps);
        this.JRB_TEps.setFont(new Font("Arial", 1, 12));
        this.JRB_TEps.setSelected(true);
        this.JRB_TEps.setText("EPS o Empresa Contratante");
        this.JRB_TEps.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.2
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JRB_TEpsActionPerformed(evt);
            }
        });
        this.JBG_TFactura.add(this.JRB_TPaciente);
        this.JRB_TPaciente.setFont(new Font("Arial", 1, 12));
        this.JRB_TPaciente.setText("Paciente");
        this.JRB_TPaciente.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.3
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JRB_TPacienteActionPerformed(evt);
            }
        });
        this.JBG_TFactura.add(this.JRB_TAmbos);
        this.JRB_TAmbos.setFont(new Font("Arial", 1, 12));
        this.JRB_TAmbos.setText("EPS y Paciente");
        this.JRB_TAmbos.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.4
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JRB_TAmbosActionPerformed(evt);
            }
        });
        GroupLayout JPI_FTipoGLayout = new GroupLayout(this.JPI_FTipoG);
        this.JPI_FTipoG.setLayout(JPI_FTipoGLayout);
        JPI_FTipoGLayout.setHorizontalGroup(JPI_FTipoGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FTipoGLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FTipoGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_TEps, -1, -1, 32767).addGroup(JPI_FTipoGLayout.createSequentialGroup().addComponent(this.JRB_TPaciente, -2, 130, -2).addContainerGap(-1, 32767)).addGroup(JPI_FTipoGLayout.createSequentialGroup().addComponent(this.JRB_TAmbos, -2, 140, -2).addGap(0, 0, 32767)))));
        JPI_FTipoGLayout.setVerticalGroup(JPI_FTipoGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FTipoGLayout.createSequentialGroup().addComponent(this.JRB_TEps).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB_TPaciente, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_TAmbos, -2, 30, -2).addContainerGap()));
        this.JTF_FNFacturaO.setEditable(false);
        this.JTF_FNFacturaO.setFont(new Font("Arial", 1, 18));
        this.JTF_FNFacturaO.setHorizontalAlignment(0);
        this.JTF_FNFacturaO.setToolTipText("N° Orden o Factura Empresa");
        this.JTF_FNFacturaO.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden / F. Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_FNFacturaO.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.5
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JTF_FNFacturaOActionPerformed(evt);
            }
        });
        this.JTF_FFechaFO.setEditable(false);
        this.JTF_FFechaFO.setFont(new Font("Arial", 1, 18));
        this.JTF_FFechaFO.setHorizontalAlignment(0);
        this.JTF_FFechaFO.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_FNFactura_P.setEditable(false);
        this.JTF_FNFactura_P.setFont(new Font("Arial", 1, 18));
        this.JTF_FNFactura_P.setHorizontalAlignment(0);
        this.JTF_FNFactura_P.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden / F. Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTF_FechaFOP.setEditable(false);
        this.JTF_FechaFOP.setFont(new Font("Arial", 1, 24));
        this.JTF_FechaFOP.setHorizontalAlignment(0);
        this.JTF_FechaFOP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSP_FObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_FObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_FObservacion.setColumns(20);
        this.JTA_FObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_FObservacion.setRows(1);
        this.JTA_FObservacion.setTabSize(1);
        this.JSP_FObservacion.setViewportView(this.JTA_FObservacion);
        GroupLayout JPI_DatosFLayout = new GroupLayout(this.JPI_DatosF);
        this.JPI_DatosF.setLayout(JPI_DatosFLayout);
        JPI_DatosFLayout.setHorizontalGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFLayout.createSequentialGroup().addComponent(this.JCB_FGrupo, -2, 304, -2).addGap(18, 18, 18).addComponent(this.JCB_FSubGrupo, 0, -1, 32767)).addGroup(JPI_DatosFLayout.createSequentialGroup().addComponent(this.JPI_FTipoG, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTF_FNFacturaO).addComponent(this.JTF_FNFactura_P, -2, 153, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTF_FechaFOP, -1, 130, 32767).addComponent(this.JTF_FFechaFO)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_FObservacion))).addContainerGap()));
        JPI_DatosFLayout.setVerticalGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_FGrupo, -2, 50, -2).addComponent(this.JCB_FSubGrupo, -2, 50, -2)).addGap(0, 0, 0).addGroup(JPI_DatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_FTipoG, -2, -1, -2).addGroup(JPI_DatosFLayout.createSequentialGroup().addComponent(this.JTF_FFechaFO, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_FechaFOP, -2, 55, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFLayout.createSequentialGroup().addComponent(this.JTF_FNFacturaO, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_FNFactura_P, -2, 55, -2)).addComponent(this.JSP_FObservacion, -2, 116, -2)).addGap(0, 6, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Totales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFF_TSubtotal.setEditable(false);
        this.JTFF_TSubtotal.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TSubtotal.setHorizontalAlignment(4);
        this.JTFF_TSubtotal.setFont(new Font("Arial", 1, 14));
        this.JTFF_TPlan.setEditable(false);
        this.JTFF_TPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TPlan.setHorizontalAlignment(4);
        this.JTFF_TPlan.setFont(new Font("Arial", 1, 14));
        this.JTFF_TNPlan.setEditable(false);
        this.JTFF_TNPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Total No Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TNPlan.setHorizontalAlignment(4);
        this.JTFF_TNPlan.setFont(new Font("Arial", 1, 14));
        this.JTFF_TCModeradora_Copago.setEditable(false);
        this.JTFF_TCModeradora_Copago.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Recuperación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TCModeradora_Copago.setHorizontalAlignment(4);
        this.JTFF_TCModeradora_Copago.setToolTipText("Cuota Moderadora o Copago");
        this.JTFF_TCModeradora_Copago.setFont(new Font("Arial", 1, 14));
        this.JTFF_TCModeradora_Copago.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPConsolidado.6
            public void focusLost(FocusEvent evt) {
                JPConsolidado.this.JTFF_TCModeradora_CopagoFocusLost(evt);
            }
        });
        this.JTFF_TCModeradora_Copago.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JPConsolidado.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPConsolidado.this.JTFF_TCModeradora_CopagoPropertyChange(evt);
            }
        });
        this.JTFF_TDescuento.setEditable(false);
        this.JTFF_TDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TDescuento.setHorizontalAlignment(4);
        this.JTFF_TDescuento.setToolTipText("Valor a cancelar por el usuario");
        this.JTFF_TDescuento.setFont(new Font("Arial", 1, 14));
        this.JTFF_TDescuento.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPConsolidado.8
            public void focusLost(FocusEvent evt) {
                JPConsolidado.this.JTFF_TDescuentoFocusLost(evt);
            }
        });
        this.JTFF_TUsuario.setEditable(false);
        this.JTFF_TUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TUsuario.setHorizontalAlignment(4);
        this.JTFF_TUsuario.setToolTipText("Valor a cancelar por el usuario");
        this.JTFF_TUsuario.setFont(new Font("Arial", 1, 14));
        this.JTFF_TEps.setEditable(false);
        this.JTFF_TEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Eps", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TEps.setHorizontalAlignment(4);
        this.JTFF_TEps.setToolTipText("Valor a cancelar por el usuario");
        this.JTFF_TEps.setFont(new Font("Arial", 1, 14));
        GroupLayout JPI_TotalesLayout = new GroupLayout(this.JPI_Totales);
        this.JPI_Totales.setLayout(JPI_TotalesLayout);
        JPI_TotalesLayout.setHorizontalGroup(JPI_TotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TotalesLayout.createSequentialGroup().addComponent(this.JTFF_TSubtotal, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_TPlan, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JTFF_TNPlan, -2, 115, -2)).addGroup(JPI_TotalesLayout.createSequentialGroup().addComponent(this.JTFF_TCModeradora_Copago, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_TDescuento, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFF_TUsuario, -2, 115, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_TotalesLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFF_TEps, -2, 115, -2)));
        JPI_TotalesLayout.setVerticalGroup(JPI_TotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TotalesLayout.createSequentialGroup().addGroup(JPI_TotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_TSubtotal, -2, 50, -2).addComponent(this.JTFF_TPlan, -2, 50, -2).addComponent(this.JTFF_TNPlan, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_TotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_TCModeradora_Copago, -2, 50, -2).addComponent(this.JTFF_TDescuento, -2, 50, -2).addComponent(this.JTFF_TUsuario, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_TEps, -2, 50, -2)));
        this.JLB_InformacionTope.setFont(new Font("Arial", 1, 12));
        this.JLB_InformacionTope.setForeground(Color.red);
        this.JLB_InformacionTope.setHorizontalAlignment(0);
        this.JTB_Datos.setForeground(Color.red);
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JDFFechaR.setMaxSelectableDate(new Date(253370786462000L));
        this.JPI_Modo.setBorder(BorderFactory.createTitledBorder((Border) null, "Modo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_FFactura.add(this.JRB_VPreliminar);
        this.JRB_VPreliminar.setFont(new Font("Arial", 1, 12));
        this.JRB_VPreliminar.setSelected(true);
        this.JRB_VPreliminar.setText("Vista Preliminar");
        this.JRB_VPreliminar.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.9
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JRB_VPreliminarActionPerformed(evt);
            }
        });
        this.JBG_FFactura.add(this.JRB_VImpresora);
        this.JRB_VImpresora.setFont(new Font("Arial", 1, 12));
        this.JRB_VImpresora.setText("Impresora");
        this.JRB_VImpresora.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.10
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JRB_VImpresoraActionPerformed(evt);
            }
        });
        GroupLayout JPI_ModoLayout = new GroupLayout(this.JPI_Modo);
        this.JPI_Modo.setLayout(JPI_ModoLayout);
        JPI_ModoLayout.setHorizontalGroup(JPI_ModoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ModoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRB_VPreliminar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_VImpresora).addContainerGap()));
        JPI_ModoLayout.setVerticalGroup(JPI_ModoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ModoLayout.createSequentialGroup().addGroup(JPI_ModoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_VPreliminar).addComponent(this.JRB_VImpresora)).addGap(0, 3, 32767)));
        this.JSP_NFolios.setFont(new Font("Arial", 1, 12));
        this.JSP_NFolios.setModel(new SpinnerNumberModel(0L, (Comparable) null, (Comparable) null, 1L));
        this.JSP_NFolios.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Folios", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBT_OrdenSalida.setFont(new Font("Arial", 1, 12));
        this.JBT_OrdenSalida.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Mantenimiento.jpg")));
        this.JBT_OrdenSalida.setText("<html><P ALIGN=center>Generar Orden Salida");
        this.JBT_OrdenSalida.setEnabled(false);
        this.JBT_OrdenSalida.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.11
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JBT_OrdenSalidaActionPerformed(evt);
            }
        });
        this.JBT_EnvioDian.setFont(new Font("Arial", 1, 12));
        this.JBT_EnvioDian.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_EnvioDian.setText("<html><P ALIGN=center>Enviar Factura Electronica(DIAN)");
        this.JBT_EnvioDian.setEnabled(false);
        this.JBT_EnvioDian.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.12
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JBT_EnvioDianActionPerformed(evt);
            }
        });
        this.JLB_MensajeDian.setFont(new Font("Arial", 1, 12));
        this.JLB_MensajeDian.setForeground(Color.red);
        this.JLB_MensajeDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Mensaje Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JLB_EstadoDian.setFont(new Font("Arial", 1, 12));
        this.JLB_EstadoDian.setForeground(Color.red);
        this.JLB_EstadoDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JCH_Prefactura.setFont(new Font("Arial", 1, 12));
        this.JCH_Prefactura.setText("Es prefactura?");
        this.JCH_Prefactura.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.13
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.JCH_PrefacturaActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 112, -2).addGap(18, 18, 18).addComponent(this.JSP_NFolios, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Modo, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JBT_EnvioDian, -2, 166, -2).addGap(18, 18, 18).addComponent(this.JBT_OrdenSalida, -2, 145, -2)).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.JLB_MensajeDian, -2, 475, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_EstadoDian, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Prefactura))).addContainerGap(-1, 32767)));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_OrdenSalida, -2, 50, -2).addComponent(this.JBT_EnvioDian, -2, 50, -2)).addComponent(this.JPI_Modo, -2, -1, -2).addComponent(this.JDFFechaR, -2, 50, -2).addComponent(this.JSP_NFolios, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_MensajeDian, -2, 35, -2).addComponent(this.JLB_EstadoDian, -2, 35, -2).addComponent(this.JCH_Prefactura)).addContainerGap(-1, 32767)));
        this.JTB_Datos.addTab("DATOS DE FACTURACIÓN", this.JPI_Datos1);
        this.JCBTipoDocC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFPago.setFont(new Font("Arial", 1, 12));
        this.JCBFPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NoDocContable.setEditable(false);
        this.JTF_NoDocContable.setFont(new Font("Arial", 1, 14));
        this.JTF_NoDocContable.setHorizontalAlignment(0);
        this.JTF_NoDocContable.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Datos2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addComponent(this.JCBFPago, -2, 175, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDocC, -2, 248, -2).addGap(18, 18, 18).addComponent(this.JCBPeriodoC, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_NoDocContable, -2, 130, -2)).addComponent(this.JCBMedioDePago, -2, 308, -2)).addContainerGap()));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocC, -2, 50, -2).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBFPago, -2, 50, -2).addComponent(this.JTF_NoDocContable, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMedioDePago, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JTB_Datos.addTab("DATOS CONTABLES", this.JPI_Datos2);
        this.btnGrabarFactura.setFont(new Font("Arial", 1, 12));
        this.btnGrabarFactura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.btnGrabarFactura.setText("Factura Paciente");
        this.btnGrabarFactura.setCursor(new Cursor(0));
        this.btnGrabarFactura.setEnabled(false);
        this.btnGrabarFactura.addActionListener(new ActionListener() { // from class: Facturacion.JPConsolidado.14
            public void actionPerformed(ActionEvent evt) {
                JPConsolidado.this.btnGrabarFacturaActionPerformed(evt);
            }
        });
        this.txtNoFactura.setEditable(false);
        this.txtNoFactura.setFont(new Font("Arial", 1, 18));
        this.txtNoFactura.setHorizontalAlignment(0);
        this.txtNoFactura.setToolTipText("N° Orden o Factura Empresa");
        this.txtNoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoFactura.setEnabled(false);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnGrabarFactura, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoFactura, -1, 312, 32767).addGap(337, 337, 337)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtNoFactura).addComponent(this.btnGrabarFactura, GroupLayout.Alignment.LEADING, -2, 50, -2)).addContainerGap(61, 32767)));
        this.JTB_Datos.addTab("FACTURA PACIENTE ", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_InformacionTope, -2, 835, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_DatosF, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 424, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Totales, -2, -1, -2))).addComponent(this.JTB_Datos, -2, 826, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_DatosF, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Totales, -1, -1, 32767).addComponent(this.JSPDetalle, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_Datos, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_InformacionTope, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TEpsActionPerformed(ActionEvent evt) {
        this.xTipo_Factura = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TPacienteActionPerformed(ActionEvent evt) {
        this.xTipo_Factura = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TAmbosActionPerformed(ActionEvent evt) {
        this.xTipo_Factura = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_FGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_FGrupo.getSelectedIndex() != -1) {
            this.JCB_FSubGrupo.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `f_subgrupo_empresa`.`Id` , `f_subgruposervicio`.`Nbre`, f_subgrupo_empresa.`CPuc_Debito` , f_subgrupo_empresa.`CPuc_Credito`, g_empresa.`Id` IdEmmpresa  FROM `f_subgrupo_empresa` INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)  INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id)  INNER JOIN g_empresa  ON (g_empresa.`Id`= f_empresacontxconvenio.`Id_EmpresaCont`) WHERE (`f_subgrupo_empresa`.`Id_Empresa` ='" + this.xjifliq.getXidempresa() + "' AND `f_subgrupo_empresa`.`Estado` =1 AND `f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xId_Grupo[this.JCB_FGrupo.getSelectedIndex()][0] + "') ORDER BY `f_subgruposervicio`.`Nbre` ASC ";
            this.xId_SubGrupo = xct1.llenarComboyLista(this.xsql, this.xId_SubGrupo, this.JCB_FSubGrupo, 5);
            if (this.xId_Grupo[this.JCB_FGrupo.getSelectedIndex()][0].equals("1")) {
                this.JCB_FSubGrupo.setSelectedItem(this.JCB_FGrupo.getSelectedItem());
            } else {
                this.JCB_FSubGrupo.setSelectedIndex(-1);
            }
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_FNFacturaOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OrdenSalidaActionPerformed(ActionEvent evt) {
        if (!this.JTF_FNFacturaO.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idingreso";
            mparametros[0][1] = this.xjifliq.JLB_NIngreso.getText();
            mparametros[1][0] = "usuario";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "f_orden_salida", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_TCModeradora_CopagoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_TCModeradora_CopagoFocusLost(FocusEvent evt) {
        mCalcularN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_TDescuentoFocusLost(FocusEvent evt) {
        mCalcularN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VPreliminarActionPerformed(ActionEvent evt) {
        this.formaVisualizacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VImpresoraActionPerformed(ActionEvent evt) {
        this.formaVisualizacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EnvioDianActionPerformed(ActionEvent evt) {
        envioFacturaDian();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PrefacturaActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xmt.getInterceptor(Long.valueOf(this.xjifliq.JLB_NIngreso.getText()), "PREFACTURA", "Liquidación en prefactura para auditoria", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarFacturaActionPerformed(ActionEvent evt) {
        if (!this.txtNoFactura.equals("0")) {
            if (this.JCBFPago.getSelectedIndex() != -1) {
                mFacturaEventoCopagoCuotaModeradora();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Selecionar Forma de Pago", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Factura activa", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void envioFacturaDian() {
        if (this.xjifliq.getxEsCapitado().equals("2")) {
            boolean formaEnvio = false;
            if (!this.JLB_EstadoDian.getText().equals("SUCCESS")) {
                formaEnvio = true;
            }
            if (Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900754259") || Principal.informacionIps.getIdentificacion().equals("812004304") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                GeneracionFacturaElectronica facturaElectronica = new GeneracionFacturaElectronica();
                List<com.genoma.plus.controller.gcuenta.Adjunto> adjuntos = new ArrayList<>();
                facturaElectronica.generacionFacturaEventoSalud(String.valueOf(this.idFacturaEvento), 0, Boolean.valueOf(formaEnvio), adjuntos);
                return;
            }
            this.xIFacturaElectronicaDAO.mGenerarFacturaElectronica(this.idFacturaEvento, 0, Boolean.valueOf(formaEnvio), this.adjunto);
        }
    }

    private void mValidaResolucionDian(Boolean validar) {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0 && lis.get(0).getId() != null) {
            this.resolucionDian = lis.get(0);
            if (validar.booleanValue()) {
                this.xmt.mResolucionDian(lis.get(0));
            }
        }
    }

    private void mCalcularN() {
        if (this.JTF_FNFacturaO.getText().isEmpty()) {
            if (Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() != 0.0d) {
                double xvalor = Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue();
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(xvalor));
                this.JTFF_TUsuario.setValue(Double.valueOf(this.JTFF_TNPlan.getValue().toString()));
                this.JTFF_TEps.setValue(Double.valueOf(Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() - Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue()));
            }
            if (Double.valueOf(this.JTFF_TNPlan.getValue().toString()).doubleValue() != 0.0d) {
                this.JTFF_TUsuario.setValue(Double.valueOf(Double.valueOf(this.JTFF_TNPlan.getValue().toString()).doubleValue() - Double.valueOf(this.JTFF_TDescuento.getValue().toString()).doubleValue()));
            }
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JCB_FSubGrupo.removeAllItems();
        this.JCB_FGrupo.removeAllItems();
        this.xsql = "SELECT `f_gruposervicio`.`Id_GrupoServicio` , `f_gruposervicio`.`Nbre` , `f_gruposervicio`.`ConSubGrupo` FROM `f_subgrupo_empresa` INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) WHERE (`f_subgrupo_empresa`.`Id_Empresa` ='" + this.xjifliq.getXidempresa() + "'  AND `f_subgrupo_empresa`.`Estado` =1) GROUP BY `f_gruposervicio`.`Id_GrupoServicio` ORDER BY `f_gruposervicio`.`Nbre` ASC ";
        this.xId_Grupo = this.xct.llenarComboyLista(this.xsql, this.xId_Grupo, this.JCB_FGrupo, 3);
        this.JCB_FGrupo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xid_tipodoc = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC", this.xid_tipodoc, this.JCBTipoDocC);
        if (Principal.informacionIps.getIdentificacion().equals("812005644") || this.xid_tipodoc.length > 0) {
            this.JCBTipoDocC.setSelectedItem("VENTAS");
        }
        this.xct.cerrarConexionBd();
        this.JCBFPago.removeAllItems();
        this.xId_Fpago = this.xct.llenarComboyLista("SELECT  `Id` , `Nbre` , `DatosA`, CDebito FROM `k_formapago` WHERE (`Estado` =1) ORDER BY `Orden` ASC, `Nbre` ASC", this.xId_Fpago, this.JCBFPago, 4);
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JCBFPago.setSelectedIndex(-1);
        } else if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.JCBFPago.setSelectedIndex(1);
        } else {
            this.JCBFPago.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        this.xidperiodo = this.xct.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        this.xct.cerrarConexionBd();
        this.JTF_FFechaFO.setText("");
        this.JTF_FNFacturaO.setText("");
        this.JTF_FNFactura_P.setText("");
        this.JTF_FechaFOP.setText("");
        this.JTA_FObservacion.setText("");
        this.JTFF_TCModeradora_Copago.setValue(new Double(0.0d));
        this.JTFF_TDescuento.setValue(new Double(0.0d));
        this.JTFF_TEps.setValue(new Double(0.0d));
        this.JTFF_TNPlan.setValue(new Double(0.0d));
        this.JTFF_TPlan.setValue(new Double(0.0d));
        this.JTFF_TUsuario.setValue(new Double(0.0d));
        this.JSP_NFolios.setValue(new Long(0L));
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
        mCargar_Datos();
        mCargarCombo();
        if (Principal.informacionIps.getIdentificacion().equals("812007286") || Principal.informacionIps.getIdentificacion().equals("901440362")) {
            System.out.println("entra - laureles");
            this.JTFF_TCModeradora_Copago.setEditable(true);
            this.JTFF_TDescuento.setEditable(true);
            this.JTFF_TCModeradora_Copago.setEnabled(true);
            this.JTFF_TDescuento.setEnabled(true);
        }
        this.listFacturasVentaCop = new ArrayList();
        this.listFacturasVentaCop = this.iLiquidacionService.listaLiquidacionFacturaIngresoPrincipal(Integer.valueOf(this.xjifliq.JLB_NIngreso.getText()));
        if (!this.listFacturasVentaCop.isEmpty()) {
            this.listFacturasVentaCop.forEach(e -> {
                System.err.println("idliquidacion Prin" + e.getId());
                e.getFFacturaEventoCollection().forEach(f -> {
                    System.err.println("idFctura Prin" + f.getId());
                    this.txtNoFactura.setEnabled(true);
                    this.txtNoFactura.setText(f.getPrefijo() + "" + f.getNoFacturaeventoM());
                });
            });
        } else if (!this.JTFF_TCModeradora_Copago.getText().equals("0")) {
            this.btnGrabarFactura.setEnabled(true);
        }
    }

    private void mCargar_Datos() {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            try {
                mCrearTabla();
                RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("100", "ListaOrdenesConsolidadoUrgenciaHospitalizacion");
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.xjifliq.JLB_NIngreso.getText();
                System.out.println("fullurlSql --- " + fullUrl);
                Response response = this.xmt.getResteasyClient().target(fullUrl).request().get();
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.xmt.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        this.listDetalleConsolidadoDTO = (List) this.xmt.getMapper().readValue(this.xmt.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<DetalleConsolidadoDTO>>() { // from class: Facturacion.JPConsolidado.15
                        });
                        if (this.listDetalleConsolidadoDTO != null && !this.listDetalleConsolidadoDTO.isEmpty()) {
                            double[] xSubTotal = {0.0d};
                            double[] xValorPlan = {0.0d};
                            double[] xValorNPlan = {0.0d};
                            this.listDetalleConsolidadoDTO.forEach(e -> {
                                System.err.println("e" + e.getIdIngreso());
                                this.xModelo.addRow(this.xDatos);
                                int lastRow = this.JTDetalle.getRowCount() - 1;
                                this.JTDetalle.setValueAt(e.getIdTipoServicio(), lastRow, 0);
                                this.JTDetalle.setValueAt(e.getNombre(), lastRow, 1);
                                this.JTDetalle.setValueAt(e.getValor(), lastRow, 2);
                                this.JTDetalle.setValueAt(e.getValorPlan(), lastRow, 3);
                                this.JTDetalle.setValueAt(e.getValorNoPlan(), lastRow, 4);
                                xSubTotal[0] = xSubTotal[0] + e.getValor().doubleValue();
                                xValorPlan[0] = xValorPlan[0] + e.getValorPlan().doubleValue();
                                xValorNPlan[0] = xValorNPlan[0] + e.getValorNoPlan().doubleValue();
                            });
                            this.JTFF_TSubtotal.setValue(Double.valueOf(xSubTotal[0]));
                            this.JTFF_TPlan.setValue(Double.valueOf(xValorPlan[0]));
                            this.JTFF_TNPlan.setValue(Double.valueOf(xValorNPlan[0]));
                            mCalcular_Copago_CModeradora();
                            mConsultar_Liquidacion();
                        }
                    } catch (Exception e2) {
                        Logger.getLogger(JPConsolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
                    }
                }
            } catch (Exception e3) {
                Logger.getLogger(JPConsolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
            }
            TrazabilidadProcesoDTO trazabilidadProcesoDTO = InterceptorManager.getTrazabilidadProcesoDTO(Long.valueOf(this.xjifliq.JLB_NIngreso.getText()));
            if (trazabilidadProcesoDTO.getId() != null && trazabilidadProcesoDTO.getDetalleProcesos().stream().anyMatch(e4 -> {
                return "PREFACTURA".equals(e4.getAccion());
            })) {
                this.JCH_Prefactura.setSelected(true);
                this.JCH_Prefactura.setEnabled(false);
            }
            if (trazabilidadProcesoDTO.getId() != null && trazabilidadProcesoDTO.getDetalleProcesos().stream().anyMatch(e5 -> {
                return "CERRAR PREFACTURA".equals(e5.getAccion());
            })) {
                this.JCH_Prefactura.setText("FACTURAR");
                this.JCH_Prefactura.setSelected(true);
                this.JCH_Prefactura.setEnabled(false);
                return;
            }
            return;
        }
        try {
            this.xsql = "SELECT f_ordenes.Id_Ingreso AS Id_Ing, f_tiposervicio.Id AS Id_TipoS , f_tiposervicio.Nbre , SUM((((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.porcentajeImpuesto)-f_itemordenesproced.ValorDescuento)) AS Valor, IF((SELECT  SUM((((Cantidad * ValorUnitario)+porcentajeImpuesto)-ValorDescuento)) FROM f_itemordenesproced INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenesproced.Plan =(SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) AND f_itemordenesproced.EsCobrable =1  AND f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) GROUP BY f_ordenes.Id_TipoServicio) IS NULL, 0, (SELECT SUM((((Cantidad * ValorUnitario)+porcentajeImpuesto)-ValorDescuento)) FROM  f_itemordenesproced INNER JOIN f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenesproced.Plan =(SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) AND f_itemordenesproced.EsCobrable =1  AND f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) GROUP BY f_ordenes.Id_TipoServicio))  AS VPlan, IF((SELECT SUM((((Cantidad * ValorUnitario)+porcentajeImpuesto)-ValorDescuento)) FROM  f_itemordenesproced INNER JOIN f_ordenes   ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenesproced.Plan NOT IN ((SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)))  AND f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) GROUP BY f_ordenes.Id_TipoServicio) IS NULL, 0, (SELECT SUM((((Cantidad * ValorUnitario)+porcentajeImpuesto)-ValorDescuento)) FROM f_itemordenesproced INNER JOIN f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenesproced.Plan NOT IN ((SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) ) AND f_itemordenesproced.EsCobrable =1  AND f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) GROUP BY f_ordenes.Id_TipoServicio) ) AS VNoPlan FROM f_itemordenesproced INNER JOIN f_ordenes   ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN f_tiposervicio   ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_ordenes.Estado =0 AND f_itemordenesproced.EsCobrable =1  AND f_ordenes.Id_Ingreso ='" + this.xjifliq.JLB_NIngreso.getText() + "') GROUP BY f_tiposervicio.Id ORDER BY f_tiposervicio.NOrden ASC";
            mCrearTabla();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            double xSubTotal2 = 0.0d;
            double xValorPlan2 = 0.0d;
            double xValorNPlan2 = 0.0d;
            int xnfila = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(2)), xnfila, 0);
                    this.xModelo.setValueAt(xrs.getString(3), xnfila, 1);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(4)), xnfila, 2);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(5)), xnfila, 3);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 4);
                    xSubTotal2 += xrs.getDouble(4);
                    xValorPlan2 += xrs.getDouble(5);
                    xValorNPlan2 += xrs.getDouble(6);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT f_ordenes.Id_Ingreso AS Id_Ing, f_tiposervicio.Id AS Id_TipoS , f_tiposervicio.Nbre , SUM((((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)-f_itemordenessum.valorDesc)) AS Valor,  IF((SELECT  SUM((((Cantidad * ValorUnit)+valorImpuesto)-valorDesc))  FROM f_itemordenessum  INNER JOIN f_ordenes  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id)  WHERE (f_itemordenessum.Plan =(SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) AND f_ordenes.Id_Ingreso =Id_Ing  AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) GROUP BY f_ordenes.Id_TipoServicio)IS NULL, 0, (SELECT SUM((((Cantidad * ValorUnit)+valorImpuesto)-valorDesc))  FROM  f_itemordenessum  INNER JOIN f_ordenes  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id)  WHERE (f_itemordenessum.EsCobrable=1 AND f_itemordenessum.Plan =(SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) AND f_ordenes.Id_Ingreso =Id_Ing  AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)  GROUP BY f_ordenes.Id_TipoServicio))  AS VPlan, IF((SELECT SUM((((Cantidad * ValorUnit)+valorImpuesto)-valorDesc))  FROM  f_itemordenessum INNER JOIN f_ordenes   ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenessum.EsCobrable=1 AND f_itemordenessum.Plan NOT IN ((SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) )  AND f_ordenes.Id_Ingreso =Id_Ing  AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)  GROUP BY f_ordenes.Id_TipoServicio) IS NULL, 0, (SELECT SUM((((Cantidad * ValorUnit)+valorImpuesto)-valorDesc))  FROM f_itemordenessum INNER JOIN f_ordenes  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) WHERE (f_itemordenessum.EsCobrable=1 AND f_itemordenessum.Plan NOT IN ((SELECT f_empresacontxconvenio.Id_TipoPlan AS Plan FROM  ingreso INNER JOIN  f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) WHERE (ingreso.Id =Id_Ing)) )  AND f_ordenes.Id_Ingreso =Id_Ing  AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)  GROUP BY f_ordenes.Id_TipoServicio) ) AS VNoPlan  FROM f_itemordenessum INNER JOIN f_ordenes   ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id)  INNER JOIN f_tiposervicio   ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_ordenes.Estado =0 AND f_itemordenessum.EsCobrable =1  AND f_ordenes.Id_Ingreso ='" + this.xjifliq.JLB_NIngreso.getText() + "')  GROUP BY f_tiposervicio.Id ORDER BY f_tiposervicio.NOrden ASC ";
            ResultSet xrs1 = this.xct.traerRs(this.xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                while (xrs1.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs1.getLong(2)), xnfila, 0);
                    this.xModelo.setValueAt(xrs1.getString(3), xnfila, 1);
                    this.xModelo.setValueAt(Double.valueOf(xrs1.getDouble(4)), xnfila, 2);
                    this.xModelo.setValueAt(Double.valueOf(xrs1.getDouble(5)), xnfila, 3);
                    this.xModelo.setValueAt(Double.valueOf(xrs1.getDouble(6)), xnfila, 4);
                    xSubTotal2 += xrs1.getDouble(4);
                    xValorPlan2 += xrs1.getDouble(5);
                    xValorNPlan2 += xrs1.getDouble(6);
                    xnfila++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT f_ordenes.Id_Ingreso AS Id_Ing, f_tiposervicio.Id AS Id_TipoS , f_tiposervicio.Nbre ,\n SUM((f_ordenesqx.Valor)) AS Valor , IF((SELECT SUM((f_ordenesqx.Valor)) FROM f_ordenesqx \n INNER JOIN f_ordenes ON (f_ordenesqx.Id_Orden = f_ordenes.Id) \n WHERE ( f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0) \n GROUP BY f_ordenes.Id_TipoServicio)IS NULL, 0,(SELECT SUM((IF(f_empresacontxconvenio.Id_TipoPlan=4,0,f_ordenesqx.Valor))) \n FROM f_ordenesqx INNER JOIN f_ordenes ON (f_ordenesqx.Id_Orden = f_ordenes.Id) \n WHERE ( f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)\n  GROUP BY f_ordenes.Id_TipoServicio)) AS VPlan,\n   IF((SELECT SUM((IF(f_empresacontxconvenio.Id_TipoPlan=4,0,f_ordenesqx.Valor))) \n   FROM f_ordenesqx INNER JOIN f_ordenes ON (f_ordenesqx.Id_Orden = f_ordenes.Id)\n    WHERE (f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)\n     GROUP BY f_ordenes.Id_TipoServicio) IS NULL, 0, (SELECT SUM((IF(f_empresacontxconvenio.Id_TipoPlan=4,f_ordenesqx.Valor,0)))\n      FROM f_ordenesqx INNER JOIN f_ordenes ON (f_ordenesqx.Id_Orden = f_ordenes.Id)\n       WHERE (f_ordenes.Id_Ingreso =Id_Ing AND f_ordenes.Id_TipoServicio =Id_TipoS AND f_ordenes.Estado =0)\n        GROUP BY f_ordenes.Id_TipoServicio) ) AS VNoPlan \n        FROM f_ordenesqx INNER JOIN f_ordenes ON (f_ordenesqx.Id_Orden = f_ordenes.Id)\n         INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) \n         INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n WHERE (f_ordenes.Estado =0 AND f_ordenesqx.EsCobrable =1 AND f_ordenes.Id_Ingreso ='" + this.xjifliq.JLB_NIngreso.getText() + "') GROUP BY f_tiposervicio.Id \n ORDER BY f_tiposervicio.NOrden ASC ";
            System.out.println(this.xsql);
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs2.getLong(2)), xnfila, 0);
                    this.xModelo.setValueAt(xrs2.getString(3), xnfila, 1);
                    this.xModelo.setValueAt(Double.valueOf(xrs2.getDouble(4)), xnfila, 2);
                    this.xModelo.setValueAt(Double.valueOf(xrs2.getDouble(5)), xnfila, 3);
                    this.xModelo.setValueAt(Double.valueOf(xrs2.getDouble(6)), xnfila, 4);
                    xSubTotal2 += xrs2.getDouble(4);
                    xValorPlan2 += xrs2.getDouble(5);
                    xValorNPlan2 += xrs2.getDouble(6);
                    xnfila++;
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.JTFF_TSubtotal.setValue(Double.valueOf(xSubTotal2));
            this.JTFF_TPlan.setValue(Double.valueOf(xValorPlan2));
            this.JTFF_TNPlan.setValue(Double.valueOf(xValorNPlan2));
            mCalcular_Copago_CModeradora();
            mConsultar_Liquidacion();
        } catch (SQLException ex) {
            Logger.getLogger(JPConsolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarCombo() {
        this.medioDePago = this.xICargarComboMedioPagoDAO.cargarComboMedioDePago();
        this.JCBMedioDePago.removeAllItems();
        for (int i = 0; i < this.medioDePago.size(); i++) {
            this.JCBMedioDePago.addItem(this.medioDePago.get(i).getNombre());
        }
        this.JCBMedioDePago.setSelectedItem("Crédito ACH");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Servicio", "VServicio", "V/Plan", "V/No Plan"}) { // from class: Facturacion.JPConsolidado.16
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCalcular_Copago_CModeradora() {
        double xvalor;
        if (this.xjifliq.getxTipoEstrato() == 0) {
            this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(this.xjifliq.getxCModeradora()));
        } else {
            try {
                if (this.xjifliq.getxPCopago() > 0.0d) {
                    xvalor = (Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() * (100.0d - this.xjifliq.getxPCopago())) / 100.0d;
                } else {
                    xvalor = (Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() * this.xjifliq.getxPCopago()) / 100.0d;
                }
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet rs = xct1.traerRs("SELECT Redondear(" + xvalor + ")");
                if (rs.next()) {
                    xvalor = rs.getDouble(1);
                }
                rs.close();
                xct1.cerrarConexionBd();
                this.xsql = "SELECT SUM(f_liquidacion.Copago) AS VAcomulado\nFROM  ingreso\n  INNER JOIN f_liquidacion    ON (ingreso.Id = f_liquidacion.Id_Ingreso)\nWHERE (ingreso.Id_Usuario = '" + this.xjifliq.xjppersona.getIdPersona() + "'\n    AND f_liquidacion.Estado = 0\n    AND ingreso.Id_EmpresaContxConv = '" + this.xjifliq.getXidempresa() + "'\n    AND DATE_FORMAT(ingreso.FechaIngreso,'%Y') = '" + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + "')\nGROUP BY ingreso.Id_Usuario HAVING (VAcomulado <> 0)";
                System.out.println(this.xsql);
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    System.out.println("valor");
                    mCalcularTope(Double.valueOf(xvalor), Double.valueOf(xrs.getDouble("VAcomulado")));
                } else {
                    System.out.println("cero");
                    mCalcularTope(Double.valueOf(xvalor), new Double(0.0d));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPConsolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        if (this.xjifliq.getxId_Editable() == 1) {
            this.JTFF_TDescuento.setEditable(true);
            this.JTFF_TCModeradora_Copago.setEditable(true);
        }
        if (Double.valueOf(this.JTFF_TNPlan.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFF_TUsuario.setValue(Double.valueOf(Double.valueOf(this.JTFF_TNPlan.getValue().toString()).doubleValue() - Double.valueOf(this.JTFF_TDescuento.getValue().toString()).doubleValue()));
        }
        if (Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFF_TEps.setValue(Double.valueOf(Double.valueOf(this.JTFF_TPlan.getValue().toString()).doubleValue() - Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue()));
        }
    }

    private void mCalcularTope(Double xValor1, Double xValor2) {
        if (this.xjifliq.getxTopeAnual() == 0.0d && this.xjifliq.getxTopeAtencion() == 0.0d) {
            this.JTFF_TCModeradora_Copago.setValue(xValor1);
            return;
        }
        if (this.xjifliq.getxTopeAnual() != 0.0d && this.xjifliq.getxTopeAtencion() == 0.0d) {
            if (xValor1.doubleValue() <= this.xjifliq.getxTopeAnual()) {
                this.JTFF_TCModeradora_Copago.setValue(xValor1);
                return;
            }
            if (xValor1.doubleValue() < this.xjifliq.getxTopeAnual() && xValor1.doubleValue() >= this.xjifliq.getxTopeAtencion()) {
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(this.xjifliq.getxTopeAtencion()));
                this.JLB_InformacionTope.setText("<html><P ALIGN=center> Se ha superado el tope anual establecido -> Valor Tope :" + this.xjifliq.getxTopeAtencion() + " -> Valor Acomulado :" + xValor2 + "</p>");
                return;
            } else if (xValor1.doubleValue() > this.xjifliq.getxTopeAnual()) {
                this.JTFF_TCModeradora_Copago.setValue(new Double(0.0d));
                this.JLB_InformacionTope.setText("<html><P ALIGN=center> Se ha superado el tope anual establecido -> Valor Tope :" + this.xjifliq.getxTopeAnual() + " -> Valor Acomulado :" + xValor2 + "</p>");
                return;
            } else {
                this.JTFF_TCModeradora_Copago.setValue(xValor1);
                return;
            }
        }
        if (this.xjifliq.getxTopeAnual() == 0.0d || this.xjifliq.getxTopeAtencion() == 0.0d) {
            if (xValor1.doubleValue() >= this.xjifliq.getxTopeAtencion()) {
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(this.xjifliq.getxTopeAtencion()));
                this.JLB_InformacionTope.setText("Se ha superado el tope por atención establecido -> Valor Tope :" + this.xjifliq.getxTopeAtencion() + " -> Valor Acomulado :" + xValor1);
                return;
            } else {
                this.JTFF_TCModeradora_Copago.setValue(xValor1);
                return;
            }
        }
        if (xValor2.doubleValue() <= 0.0d) {
            if (xValor1.doubleValue() <= this.xjifliq.getxTopeAtencion()) {
                this.JTFF_TCModeradora_Copago.setValue(xValor1);
                return;
            } else {
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(this.xjifliq.getxTopeAtencion()));
                return;
            }
        }
        if (xValor1.doubleValue() < this.xjifliq.getxTopeAnual() && xValor1.doubleValue() >= this.xjifliq.getxTopeAtencion()) {
            if (this.xjifliq.getxTopeAtencion() + xValor2.doubleValue() > this.xjifliq.getxTopeAnual()) {
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(Math.abs(this.xjifliq.getxTopeAnual() - xValor2.doubleValue())));
            } else {
                this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(this.xjifliq.getxTopeAtencion()));
            }
            this.JLB_InformacionTope.setText("<html><P ALIGN=center> Se ha superado el tope anual establecido -> Valor Tope :" + this.xjifliq.getxTopeAtencion() + " -> Valor Acomulado :" + xValor2 + "</p>");
            return;
        }
        if (xValor1.doubleValue() > this.xjifliq.getxTopeAnual()) {
            this.JTFF_TCModeradora_Copago.setValue(new Double(0.0d));
            this.JLB_InformacionTope.setText("<html><P ALIGN=center> Se ha superado el tope anual establecido -> Valor Tope :" + this.xjifliq.getxTopeAnual() + " -> Valor Acomulado :" + xValor2 + "</p>");
        } else {
            this.JTFF_TCModeradora_Copago.setValue(xValor1);
        }
    }

    public void mGrabar() {
        if (this.xjifliq.getxCerrarFactura() == 0) {
            if (this.JCB_FSubGrupo.getSelectedIndex() != -1) {
                if (this.JTF_FNFacturaO.getText().isEmpty()) {
                    if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                        if (this.JCBFPago.getSelectedIndex() != -1) {
                            if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                if (this.JCBTipoDocC.getSelectedIndex() != -1) {
                                    if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                        if (!this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][3].equals("")) {
                                            if (!this.xId_Fpago[this.JCBFPago.getSelectedIndex()][2].equals("")) {
                                                mGrabar1();
                                                return;
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Falta cuenta contable en forma de pago", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JCBFPago.requestFocus();
                                                return;
                                            }
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Falta cuenta contable en el subgrupo de factura", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCB_FSubGrupo.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe de seleccionar periodo", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTB_Datos.setSelectedIndex(1);
                                    this.JCBPeriodoC.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe de seleccionar tipo de documento", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTB_Datos.setSelectedIndex(1);
                                this.JCBTipoDocC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBMedioDePago.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe de seleccionar forma de pago", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTB_Datos.setSelectedIndex(1);
                        this.JCBFPago.requestFocus();
                        return;
                    }
                    mGrabar1();
                    return;
                }
                if (this.xjifliq.getxId_Liqidacion() != 0) {
                    this.xsql = "update f_liquidacion set Id_SubGrupoServicio='" + this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][0] + "', NFolios='" + this.JSP_NFolios.getValue() + "' where id='" + this.xjifliq.getxId_Liqidacion() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
                JOptionPane.showInternalMessageDialog(this, "N° de Orden/Factura ya generada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe de seleccionar un subgrupo", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_FSubGrupo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con seguimiento pendiente por cerrar,\nFavor revisar!!!!", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabar1() {
        if (Double.valueOf(this.JTFF_TEps.getValue().toString()).doubleValue() != 0.0d || Double.valueOf(this.JTFF_TUsuario.getValue().toString()).doubleValue() != 0.0d) {
            mValidaResolucionDian(false);
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar el N° Orden/Factura?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                double xvalorC = 0.0d;
                double xvalorP = 0.0d;
                if (this.xjifliq.getxTipoEstrato() == 0) {
                    xvalorC = Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue();
                } else {
                    xvalorP = Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue();
                }
                this.xsql = "insert into f_liquidacion (Id_Ingreso,TotalServicio,TotalPlan,TotalEps,TotalDescuento,TotalPaciente,CuotaModeradora,Copago,Id_SubGrupoServicio,IdEmpresaContxConv,Id_UsuarioRH,Observacion,NFolios,NEquipo,DireccionIp,IdFormaPago,UsuarioS)values('" + this.xjifliq.JLB_NIngreso.getText() + "','" + this.JTFF_TSubtotal.getValue() + "','" + this.JTFF_TPlan.getValue() + "','" + this.JTFF_TEps.getValue() + "','" + this.JTFF_TDescuento.getValue() + "','" + this.JTFF_TUsuario.getValue() + "','" + xvalorC + "','" + xvalorP + "','" + this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][0] + "','" + this.xjifliq.getXidempresa() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.JTA_FObservacion.getText() + "','" + this.JSP_NFolios.getValue() + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','" + Integer.valueOf(this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0]) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xid_liquidacion = this.xct.ejecutarSQLId(this.xsql);
                this.xct.cerrarConexionBd();
                if (this.xjifliq.getxEsCapitado().equals("2")) {
                    mValidaResolucionDian(false);
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                        this.xsql = "insert into f_factura_evento(`Prefijo`, No_FacturaEvento_M, `Fecha_FacturaEvento` , `Id_Liquidacion`, idResolucionDian, idMedioPago , `TipoFactura`, Sede, `UsuarioS`) values ('" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + xid_liquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','" + this.xTipo_Factura + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                        this.xsql = "insert into f_factura_evento(`Prefijo`, No_FacturaEvento_M, `Fecha_FacturaEvento` , `Id_Liquidacion`, idResolucionDian, idMedioPago  , `TipoFactura`, Sede, `UsuarioS`) values ('" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + xid_liquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','" + this.xTipo_Factura + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        this.xsql = "insert into f_factura_evento(`Prefijo`, No_FacturaEvento_M, `Fecha_FacturaEvento` , `Id_Liquidacion`, idResolucionDian, idMedioPago  , `TipoFactura`, Sede, `UsuarioS`) values ('" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + xid_liquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','" + this.xTipo_Factura + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    String xId = this.xct.ejecutarSQLId(this.xsql);
                    this.idFacturaEvento = xId;
                    this.xct.cerrarConexionBd();
                    System.out.println("this.xjifliq.getxGeneraMovContable() -> " + this.xjifliq.getxGeneraMovContable());
                    if (this.xjifliq.getxGeneraMovContable().equals("1")) {
                        System.out.println("entra generar documento contables");
                        mGrabarDocContable(xId);
                    }
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGrabarDocContableBienestar(xId);
                    }
                    int idLiquidacion = Integer.parseInt(xid_liquidacion);
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && this.JCBMedioDePago.getSelectedItem().equals("EFECTIVO")) {
                        System.out.println("idLiquidacioon -> " + idLiquidacion);
                        try {
                            ConsultasMySQL xct = new ConsultasMySQL();
                            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `insertarFFPagos`('" + idLiquidacion + "')}");
                            Throwable th = null;
                            try {
                                try {
                                    cs.execute();
                                    JOptionPane.showMessageDialog((Component) null, "Se realizó el pago correctamente");
                                    if (cs != null) {
                                        if (0 != 0) {
                                            try {
                                                cs.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        } else {
                                            cs.close();
                                        }
                                    }
                                    xct.cerrarConexionBd();
                                } finally {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th3;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                    }
                    activarEnvioDian();
                    this.xmt.getInterceptor(Long.valueOf(this.xjifliq.JLB_NIngreso.getText()), "FACTURADA", "Factura realizada y enviada a dian", true);
                } else {
                    this.xsql = "insert into f_factura_capita(`Fecha_FacturaCapita` , `Id_Liquidacion` , `TipoFactura` , `UsuarioS`) values ('" + this.xmt.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + xid_liquidacion + "','" + this.xTipo_Factura + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            mConsultar_Liquidacion();
            Principal.clasegeneral.mActualizar_ResolucionDian(this.idFacturaEvento, String.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId()));
            if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
                envioFacturaDian();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Liquidación con valor cero,\nNo es posible cerrar!!!!", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mFacturaEventoCopagoCuotaModeradora() {
        this.gEmpresaEntity = this.iGEmpresaService.getGEmpresaByNumeroDocumento(this.xjifliq.xjppersona.getIdentificacion());
        if (this.gEmpresaEntity != null) {
            this.gEmpresaEntity.setCorreo(this.xjifliq.xjppersona.txtCorreo.getText());
            this.gEmpresaEntity.setCorreoFacturaElectronica(this.xjifliq.xjppersona.txtCorreo.getText());
            this.gEmpresaEntity.setNbre(this.xjifliq.xjppersona.getApellido1() + " " + this.xjifliq.xjppersona.getApellido2() + " " + this.xjifliq.xjppersona.getNombre1() + " " + this.xjifliq.xjppersona.getNombre2());
            this.gEmpresaEntity.setDireccion(this.xjifliq.xjppersona.getDireccion());
            this.gEmpresaEntity.setTelNumero(this.xjifliq.xjppersona.getTelefono());
            this.iGEmpresaService.seve(this.gEmpresaEntity);
            mCrearConvenio();
            return;
        }
        GMunicipio municipio = new GMunicipio();
        municipio.setId(this.xjifliq.xjppersona.getIdMunicipio());
        CcTipoClasificacionTercero ccTipoClasificacionTercero = new CcTipoClasificacionTercero();
        ccTipoClasificacionTercero.setId(1);
        CcTipoVigenciaPago ccTipoVigenciaPago = new CcTipoVigenciaPago();
        ccTipoVigenciaPago.setId(1);
        this.gEmpresaEntity = new GEmpresa();
        this.gEmpresaEntity.setIdTipoIdentificacion(this.xjifliq.xjppersona.getIdTipoIdentifiacion());
        this.gEmpresaEntity.setApellido1(this.xjifliq.xjppersona.getApellido1());
        this.gEmpresaEntity.setApellido2(this.xjifliq.xjppersona.getApellido2());
        this.gEmpresaEntity.setNombre1(this.xjifliq.xjppersona.getNombre1());
        this.gEmpresaEntity.setNombre2(this.xjifliq.xjppersona.getNombre2());
        this.gEmpresaEntity.setNbre(this.xjifliq.xjppersona.getApellido1() + " " + this.xjifliq.xjppersona.getApellido2() + " " + this.xjifliq.xjppersona.getNombre1() + " " + this.xjifliq.xjppersona.getNombre2());
        this.gEmpresaEntity.setNoidentificacion(this.xjifliq.xjppersona.getIdentificacion());
        this.gEmpresaEntity.setIdMunicipio(municipio);
        this.gEmpresaEntity.setDireccion(this.xjifliq.xjppersona.getDireccion());
        this.gEmpresaEntity.setTelNumero(this.xjifliq.xjppersona.getTelefono());
        this.gEmpresaEntity.setCorreo(this.xjifliq.xjppersona.txtCorreo.getText());
        this.gEmpresaEntity.setCorreoFacturaElectronica(this.xjifliq.xjppersona.txtCorreo.getText());
        this.gEmpresaEntity.setIdClasificacionT(ccTipoClasificacionTercero);
        this.gEmpresaEntity.setIdVigenciaP(ccTipoVigenciaPago);
        this.iGEmpresaService.seve(this.gEmpresaEntity);
        mCrearConvenio();
    }

    private void mCrearConvenio() {
        this.empresaContConvenioEntity = this.iEmpresaContConvenioService.getEmpresaContConvenioEntityByidEmpresaCont(this.gEmpresaEntity);
        if (this.empresaContConvenioEntity != null) {
            mCrearGrupoSubgrupo();
            return;
        }
        DatosIpsEntity datosIpsEntity = new DatosIpsEntity();
        datosIpsEntity.setId(1);
        MunicipioDTO municipio = new MunicipioDTO();
        municipio.setId(this.xjifliq.xjppersona.getIdMunicipio());
        TipoAseguramientoDTO tipoAseguramientoDTO = new TipoAseguramientoDTO();
        tipoAseguramientoDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(1);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoPlanEntity tipoPlanEntity = new TipoPlanEntity();
        tipoPlanEntity.setId(1);
        TipoRegimenEntity tipoRegimenEntity = new TipoRegimenEntity();
        tipoRegimenEntity.setId(true);
        this.empresaContConvenioEntity = new EmpresaContConvenioEntity();
        this.empresaContConvenioEntity.setIdEmpresaCont(this.gEmpresaEntity);
        this.empresaContConvenioEntity.setIdGIps(datosIpsEntity);
        this.empresaContConvenioEntity.setIdMunicipio(municipio);
        this.empresaContConvenioEntity.setIdTipoAseguramiento(tipoAseguramientoDTO);
        this.empresaContConvenioEntity.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.empresaContConvenioEntity.setIdTipoContratacion(tipoContratacionDTO);
        this.empresaContConvenioEntity.setIdTipoPlan(tipoPlanEntity);
        this.empresaContConvenioEntity.setIdTipoRegimen(tipoRegimenEntity);
        this.empresaContConvenioEntity.setNbre(this.xjifliq.xjppersona.getApellido1() + " " + this.xjifliq.xjppersona.getApellido2() + " " + this.xjifliq.xjppersona.getNombre1() + " " + this.xjifliq.xjppersona.getNombre2());
        this.empresaContConvenioEntity.setEstado(false);
        this.empresaContConvenioEntity.setId_Manual(true);
        this.iEmpresaContConvenioService.save(this.empresaContConvenioEntity);
        mCrearGrupoSubgrupo();
    }

    private void mCrearGrupoSubgrupo() {
        this.subgrupoEmpresaEntity = this.iSubgrupoEmpresaService.getSubgrupoEmpresaEntityByempresaContConvenioEntity(this.empresaContConvenioEntity);
        if (this.subgrupoEmpresaEntity != null) {
            crearLiquidacion();
            return;
        }
        if (this.xjifliq.getxTipoEstrato() != 0) {
            this.subgruposervicioEntity = this.iSubgrupoServicioService.getSubgruposervicioEntityByesCuotaModeradora(2);
        } else {
            this.subgruposervicioEntity = this.iSubgrupoServicioService.getSubgruposervicioEntityByesCuotaModeradora(1);
        }
        this.subgrupoEmpresaEntity = new SubgrupoEmpresaEntity();
        this.subgrupoEmpresaEntity.setEmpresaContConvenioEntity(this.empresaContConvenioEntity);
        this.subgrupoEmpresaEntity.setSubgruposervicioEntity(this.subgruposervicioEntity);
        this.subgrupoEmpresaEntity.setCPucDebito(this.subgruposervicioEntity.getCPucDebito());
        this.subgrupoEmpresaEntity.setCPucCredito(this.subgruposervicioEntity.getCPucCredito());
        this.subgrupoEmpresaEntity.setUsuarioS(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.subgrupoEmpresaEntity.setFecha(this.xmt.getFechaActual());
        this.iSubgrupoEmpresaService.grabar(this.subgrupoEmpresaEntity);
        crearLiquidacion();
    }

    private void crearLiquidacion() {
        try {
            this.liquidacionEntity = new LiquidacionEntity();
            this.liquidacionEntity.setIdIngreso(0L);
            this.liquidacionEntity.setCopago(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setCuotaModeradora(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setDireccionIp(Principal.getLocalHost().getHostAddress());
            this.liquidacionEntity.setEstado(false);
            this.liquidacionEntity.setFecha(this.xmt.getFechaActual());
            this.liquidacionEntity.setIdEmpresaContxConv(this.empresaContConvenioEntity.getId());
            this.liquidacionEntity.setIdFormaPago(Integer.valueOf(this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0]));
            this.liquidacionEntity.setIdSubGrupoServicio(this.subgrupoEmpresaEntity);
            this.liquidacionEntity.setIdMotivoAnulacion(1);
            this.liquidacionEntity.setIdUsuarioRH(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().intValue()));
            this.liquidacionEntity.setNEquipo(Principal.getLocalHost().getHostName());
            this.liquidacionEntity.setNFolios(0);
            this.liquidacionEntity.setObservacion("");
            this.liquidacionEntity.setObservacionAnulacion("");
            this.liquidacionEntity.setTGlosa(Double.valueOf(0.0d));
            this.liquidacionEntity.setTPagado(Double.valueOf(0.0d));
            if (this.xjifliq.getxTipoEstrato() != 0) {
                this.liquidacionEntity.setTotalServicio(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
                this.liquidacionEntity.setTotalEps(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
            } else {
                this.liquidacionEntity.setTotalServicio(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
                this.liquidacionEntity.setTotalEps(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
            }
            this.liquidacionEntity.setTotalDescuento(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setUsuarioAnulacion("");
            this.liquidacionEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.liquidacionEntity.setVGlosaNR(Double.valueOf(0.0d));
            this.liquidacionEntity.setVGlosaR(Double.valueOf(0.0d));
            this.liquidacionEntity.setIdIngresoPrincipal(Integer.valueOf(Integer.parseInt(this.xjifliq.JLB_NIngreso.getText())));
            this.iLiquidacionService.save(this.liquidacionEntity);
            mFacturaEventoCopago();
            mFacturaDetalleCopago();
            mCuentaCobro();
            mDocumentoContableCopago();
            actualizarFacturaCopago(this.facturaEvento.getId().longValue(), this.fCuentacobro.getNoCuenta().longValue(), this.cCDocumentoc.getId().longValue(), this.fCuentacobro.getNoCuenta().longValue());
            this.txtNoFactura.setText(this.facturaEvento.getPrefijo() + "" + this.facturaEvento.getNoFacturaeventoM().toString());
            this.btnGrabarFactura.setEnabled(false);
        } catch (NumberFormatException e) {
            System.err.println("liquidacion no grabada");
        }
    }

    private void mFacturaEventoCopago() {
        mValidaResolucionDian(true);
        ResolucionDianDTO resolucionDianDTO = new ResolucionDianDTO();
        resolucionDianDTO.setId(this.resolucionDian.getId());
        GEtapaProceso etapaProceso = new GEtapaProceso();
        etapaProceso.setId("0");
        this.facturaEvento = new FFacturaEvento();
        this.facturaEvento.setFechaFacturaevento(this.xmt.getFechaActual());
        this.facturaEvento.setIdLiquidacion(this.liquidacionEntity);
        this.facturaEvento.setIdResolucionDian(resolucionDianDTO);
        this.facturaEvento.setEstado(0);
        this.facturaEvento.setTipoFactura(0);
        int fPago = Integer.parseInt(this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0]);
        this.facturaEvento.setIdMedioPago(Integer.valueOf(fPago));
        Long numDefault = Long.valueOf("0");
        this.facturaEvento.setNoFacturaeventoM(numDefault);
        this.facturaEvento.setIdMotivoanulacion(0);
        this.facturaEvento.setMotivoAnulacion("");
        this.facturaEvento.setUsuarioAnulacion("");
        this.facturaEvento.setEstaArmada(2);
        this.facturaEvento.setNoCuentacobro(new Long(0L));
        this.facturaEvento.setPrefijo(this.resolucionDian.getPrefijo());
        this.facturaEvento.setIdDocumentoc(new Long(0L));
        this.facturaEvento.setNRadicado("");
        this.facturaEvento.setUrlRadicado("");
        this.facturaEvento.setSede(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.facturaEvento.setIndicador("I");
        this.facturaEvento.setCJuridico(0);
        this.facturaEvento.setIdEtapaProcedo(etapaProceso);
        this.facturaEvento.setIdDocumentocr(new Long(0L));
        this.facturaEvento.setConceptoCobro("COBROS COPAGO O CUOTAMODERADORA");
        this.facturaEvento.setEsta(0);
        this.facturaEvento.setRDian(this.resolucionDian.getDescripcion());
        this.facturaEvento.setDireccionIp(Principal.getLocalHost().getHostAddress());
        this.facturaEvento.setNEquipo(Principal.getLocalHost().getHostName());
        this.facturaEvento.setFecha(this.xmt.getFechaActual());
        this.facturaEvento.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.fFacturaEventoService.save(this.facturaEvento);
    }

    private void mFacturaDetalleCopago() {
        this.fFacturaEventoDetalle = new FFacturaEventoDetalle();
        this.fFacturaEventoDetalle.setNo_FacturaEvento(this.facturaEvento);
        if (this.xjifliq.getxTipoEstrato() != 0) {
            this.fFacturaEventoDetalle.setConcepto("COPAGO");
            this.fFacturaEventoDetalle.setTotal(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()));
        } else {
            this.fFacturaEventoDetalle.setConcepto("CUOTAMODERADORA");
            this.fFacturaEventoDetalle.setTotal(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()));
        }
        this.fFacturaEventoDetalleService.save(this.fFacturaEventoDetalle);
    }

    private void mCuentaCobro() {
        CcPeriodoContable cPeriodoContable = new CcPeriodoContable();
        cPeriodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
        GruposervicioEntity gruposervicioEntity = new GruposervicioEntity();
        gruposervicioEntity.setIdGrupoServicio(2);
        this.fCuentacobro = new FCuentacobro();
        this.fCuentacobro.setIdPeriodoC(cPeriodoContable);
        this.fCuentacobro.setIdEmpContxConv(this.empresaContConvenioEntity);
        this.fCuentacobro.setIdGrupoServicio(gruposervicioEntity);
        this.fCuentacobro.setConceptoCobro("ejemplo");
        this.fCuentacobro.setTotalServicio(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
        this.fCuentacobro.setNoRegistros(1);
        this.fCuentacobro.setTotalNeto(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString()).doubleValue());
        this.fCuentacobro.setPeriodoFact(this.xmt.getFechaActual());
        this.fCuentacobro.setPeriodoFact1(this.xmt.getFechaActual());
        this.fCuentacobro.setFecha(this.xmt.getFechaActual());
        this.fCuentacobro.setRadicacion("0");
        this.facturaEvento.setFechaFacturaevento(this.xmt.getFechaActual());
        this.fCuentacobro.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.iFCuentacobroService.save(this.fCuentacobro);
    }

    private void mDocumentoContableCopago() {
        try {
            CcTipoDocumentoc tipoDocumentoc = new CcTipoDocumentoc();
            tipoDocumentoc.setId(6);
            CcPeriodoContable periodoContable = new CcPeriodoContable();
            periodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
            this.cCDocumentoc = new CcDocumentoc();
            this.cCDocumentoc.setFechaD(this.xmt.getFechaActual());
            this.cCDocumentoc.setIdTipoComprobante(tipoDocumentoc);
            this.cCDocumentoc.setIdPeriodoC(periodoContable);
            this.cCDocumentoc.setDescripcion("Factura Venta N° " + this.facturaEvento.getId());
            this.cCDocumentoc.setNConsecutivo(BigInteger.ZERO);
            this.cCDocumentoc.setAprobadoA(false);
            this.cCDocumentoc.setEjecutado(false);
            this.cCDocumentoc.setEsGlobal(false);
            this.cCDocumentoc.setEstado(true);
            this.cCDocumentoc.setEstadoA(false);
            this.cCDocumentoc.setExportadoC(false);
            this.cCDocumentoc.setFechaR(new Date());
            this.cCDocumentoc.setGenerarC(false);
            this.cCDocumentoc.setIdCertificado(0);
            this.cCDocumentoc.setIdCierreCaja(0);
            this.cCDocumentoc.setIdConcepto(0);
            this.cCDocumentoc.setIdCuentaCobro(0);
            this.cCDocumentoc.setIdCuentaEmpresa(0);
            this.cCDocumentoc.setIdCuentaEmpresaP(0);
            this.cCDocumentoc.setIdNomina(BigInteger.ZERO);
            this.cCDocumentoc.setIdRadicacion(BigInteger.ZERO);
            this.cCDocumentoc.setRevisadoC(false);
            this.cCDocumentoc.setTipoPago(0);
            this.cCDocumentoc.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            System.err.println("subgrupoEmpresaEntity.getCPucDebito()" + this.subgrupoEmpresaEntity.getCPucDebito());
            CcPuc pucDebito = CcPuc.builder().id(this.subgrupoEmpresaEntity.getCPucDebito()).build();
            List<CcDetalleDocumentoc> listDetalle = new ArrayList<>();
            CcDetalleDocumentoc dDebito = CcDetalleDocumentoc.builder().idDocumentoc(this.cCDocumentoc).vDebito(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString())).base(new Double(0.0d)).concepto("Factura Venta N° " + this.facturaEvento.getId()).idRadicacion(0).idCertificado(0).idPuc(pucDebito).estado(1).tipoCPuc(0).vCredito(new Double(0.0d)).idConceptoN(0).nFactura(this.facturaEvento.getId().toString()).pRetencion(new Double(0.0d)).idTercero(this.gEmpresaEntity).build();
            listDetalle.add(dDebito);
            if (listDetalle != null) {
                CcPuc pucCredito = CcPuc.builder().id(this.subgrupoEmpresaEntity.getCPucCredito()).build();
                CcDetalleDocumentoc dCredito = CcDetalleDocumentoc.builder().idDocumentoc(this.cCDocumentoc).vDebito(new Double(0.0d)).base(new Double(0.0d)).concepto("Factura Venta N° " + this.facturaEvento.getId()).idRadicacion(0).idCertificado(0).idPuc(pucCredito).estado(1).tipoCPuc(1).vCredito(Double.valueOf(this.JTFF_TCModeradora_Copago.getValue().toString())).idConceptoN(0).nFactura(this.facturaEvento.getId().toString()).pRetencion(new Double(0.0d)).idTercero(this.gEmpresaEntity).build();
                listDetalle.add(dCredito);
            }
            this.cCDocumentoc.setCcDetalleDocumentocCollection(listDetalle);
            this.ccDocumentocService.grabar(this.cCDocumentoc);
        } catch (Exception e) {
            System.err.println("Error>>>>> : " + e);
        }
    }

    private void actualizarFacturaCopago(long id, long idCuenta, long idDocumento, long idCuentaCobro) {
        try {
            Optional<FFacturaEvento> optionaFFacturaEvento = this.fFacturaEventoService.findById(Long.valueOf(id));
            if (optionaFFacturaEvento.isPresent()) {
                FFacturaEvento fFacturaEventoExistente = optionaFFacturaEvento.get();
                fFacturaEventoExistente.setNoCuentacobro(Long.valueOf(idCuenta));
                fFacturaEventoExistente.setIdDocumentoc(Long.valueOf(idDocumento));
                fFacturaEventoExistente.setNoCuentacobro(Long.valueOf(idCuentaCobro));
                this.fFacturaEventoService.save(fFacturaEventoExistente);
                System.err.println("FACTURA actualizada con éxito");
            } else {
                System.err.println("No se encontró la FACTURA con el ID proporcionado");
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al actualizar la FACTURA");
        }
    }

    private void activarEnvioDian() {
        if (Principal.usuarioSistemaDTO.getAutorizadoEnvioFacturaDian().booleanValue() && this.xjifliq.getxEsCapitado().equals("2")) {
            this.JBT_EnvioDian.setEnabled(true);
            this.JLB_EstadoDian.setVisible(true);
            this.JLB_MensajeDian.setVisible(true);
            if (this.JLB_EstadoDian.getText().equals("SUCCESS")) {
                this.JLB_MensajeDian.setForeground(new Color(0, 103, 0));
                this.JLB_EstadoDian.setForeground(new Color(0, 103, 0));
            }
        }
    }

    private void mGrabarDocContable(String xNFactura) {
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            try {
                this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.xid_tipodoc[this.JCBTipoDocC.getSelectedIndex()] + "','" + xNFactura + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','0',' FACTURA VENTA N° " + xNFactura + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JTF_NoDocContable.setText(this.xct.ejecutarSQLId(this.xsql));
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][2] + "','1','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','" + xNFactura + "','0','" + this.JTFF_TUsuario.getValue() + "',' FACTURA VENTA N° " + xNFactura + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][2] + "','0','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','" + xNFactura + "','" + this.JTFF_TUsuario.getValue() + "','0',' FACTURA VENTA N° " + xNFactura + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, round((" + this.JTFF_TUsuario.getValue() + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, round((" + this.JTFF_TUsuario.getValue() + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][3] + "') GROUP BY `cc_puc`.`Id`";
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs2 = xct2.traerRs(this.xsql);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    while (xrs2.next()) {
                        ConsultasMySQL xct3 = new ConsultasMySQL();
                        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','0','" + xNFactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "','" + this.JTFF_TUsuario.getValue() + "',' FACTURA VENTA N° " + xNFactura + "' )";
                        xct3.ejecutarSQL(this.xsql);
                        xct3.cerrarConexionBd();
                    }
                }
                xrs2.close();
                xct2.cerrarConexionBd();
                this.xsql = "update f_factura_evento set EstaArmada=2, Id_DocumentoC='" + this.JTF_NoDocContable.getText() + "' WHERE (`No_FacturaEvento` ='" + xNFactura + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mGrabarDocContableBienestar(String xNFactura) {
        String idFactura = null;
        String credito = "";
        try {
            try {
                String SQLCredito = "SELECT\n  `f_centrocosto`.`CCredito` \nFROM\n  `f_factura_evento`\n  INNER JOIN `f_liquidacion`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  inner join `ingreso`\n    on (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  inner join `f_centrocosto`\n    on (`f_centrocosto`.`Id`=`f_ordenes`.`Id_CentroCosto`)\nwhere `f_factura_evento`.`No_FacturaEvento` = '" + xNFactura + "'";
                System.out.println("SQLCredito -> " + SQLCredito);
                ResultSet rs0 = this.xct.getResultSet(SQLCredito);
                if (rs0.next()) {
                    credito = rs0.getString("CCredito");
                    System.out.println("credito -> " + credito);
                }
                rs0.close();
            } catch (Exception e) {
                System.out.println("error ");
            }
            ResultSet rs1 = this.xct.getResultSet("select concat(ffe.Prefijo,'',ffe.No_FacturaEvento_M) numeroFactura, ffe.No_FacturaEvento_M idFactura\nfrom f_factura_evento ffe \nwhere ffe.No_FacturaEvento ='" + xNFactura + "'");
            if (rs1.next()) {
                xNFactura = rs1.getString("numeroFactura");
                idFactura = rs1.getString("idFactura");
            }
            rs1.close();
            String xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.xid_tipodoc[this.JCBTipoDocC.getSelectedIndex()] + "','" + idFactura + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','0',' FACTURA VENTA N° " + xNFactura + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            System.out.println("Documentoc -> " + xsql);
            this.JTF_NoDocContable.setText(this.xct.ejecutarSQLId(xsql));
            this.xct.cerrarConexionBd();
            String xsql2 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + credito + "','1','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','" + xNFactura + "','0','" + this.JTFF_TUsuario.getValue() + "',' FACTURA VENTA N° " + xNFactura + "')";
            System.out.println(" Detalle Puc 1: " + xsql2);
            this.xct.ejecutarSQL(xsql2);
            this.xct.cerrarConexionBd();
            String xsql3 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + traerMedioPago() + "','0','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','" + xNFactura + "','" + this.JTFF_TUsuario.getValue() + "','0',' FACTURA VENTA N° " + xNFactura + "')";
            System.out.println(" Detalle Puc 2: " + xsql3);
            this.xct.ejecutarSQL(xsql3);
            this.xct.cerrarConexionBd();
            String xsql4 = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, round((" + this.JTFF_TUsuario.getValue() + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, round((" + this.JTFF_TUsuario.getValue() + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.xId_SubGrupo[this.JCB_FSubGrupo.getSelectedIndex()][3] + "') GROUP BY `cc_puc`.`Id`";
            System.out.println("consulta puc -> " + xsql4);
            ConsultasMySQL xct2 = new ConsultasMySQL();
            ResultSet xrs2 = xct2.traerRs(xsql4);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    ConsultasMySQL xct3 = new ConsultasMySQL();
                    String xsql5 = " into into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.xjifliq.xjppersona.getIdPersona(), this.xjifliq.xjppersona.listaTipoIdentificacion[this.xjifliq.xjppersona.cboTipoIdentificacion.getSelectedIndex()][0], this.xjifliq.xjppersona.getIdentificacion()) + "','0','" + xNFactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "','" + this.JTFF_TUsuario.getValue() + "',' FACTURA VENTA N° " + xNFactura + "' )";
                    System.out.println(" Detalle Puc 3: " + xsql5);
                    xct3.ejecutarSQL(xsql5);
                    xct3.cerrarConexionBd();
                }
            }
            xrs2.close();
            xct2.cerrarConexionBd();
            String xsql6 = "update f_factura_evento set EstaArmada=2, Id_DocumentoC='" + this.JTF_NoDocContable.getText() + "' WHERE `No_FacturaEvento_M` = (SELECT REPLACE('" + xNFactura + "', 'FVE', ''))";
            System.out.println("xsql update -> " + xsql6);
            this.xct.ejecutarSQL(xsql6);
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
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

    private void mConsultar_Liquidacion() {
        try {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.xsql = "SELECT  `f_liquidacion`.`Id_Ingreso` , IF(`f_empresacontxconvenio`.`EsCapitado`=2, IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`, CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)), `f_factura_capita`.`No_FacturaCapita`) AS `NFactura` , IF(`f_empresacontxconvenio`.`EsCapitado`=2,DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d/%m/%Y'), DATE_FORMAT(`f_factura_capita`.`Fecha_FacturaCapita`,'%d/%m/%Y')) AS `FechaFac` , IF(`f_empresacontxconvenio`.`EsCapitado`=2,`f_factura_evento`.`EstaArmada`,  `f_factura_capita`.`EstaArmada`) AS `Estado` , `f_liquidacion`.`TotalServicio` , `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps` , `f_liquidacion`.`TotalDescuento` , `f_liquidacion`.`TotalPaciente` , (`f_liquidacion`.`CuotaModeradora` + `f_liquidacion`.`Copago`) as CP , `f_liquidacion`.`Observacion`, `f_liquidacion`.`Id` as Id_Liquidacion , `f_gruposervicio`.`Nbre` AS Grupo , `f_subgruposervicio`.`Nbre` AS SubGrupo , IF(`f_empresacontxconvenio`.`EsCapitado`=2,`f_factura_evento`.`TipoFactura`, `f_factura_capita`.`TipoFactura`) AS Tipo, f_liquidacion.NFolios, f_factura_evento.Fecha_FacturaEvento, `f_factura_evento`.`Id_DocumentoC`      FROM `f_liquidacion`  LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) LEFT JOIN `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_ips`  ON (`g_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) WHERE (`f_liquidacion`.`Id_Ingreso` ='" + this.xjifliq.JLB_NIngreso.getText() + "' AND `f_liquidacion`.`Estado` =0) ";
            } else {
                this.xsql = "SELECT  f_liquidacion.Id_Ingreso,\n  IF(f_empresacontxconvenio.EsCapitado = 2,IF(cc_resolucion_dian.trasmision = 0,IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento,        \n  CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)),IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento_M,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento_M))),f_factura_capita.No_FacturaCapita) AS NFactura,\n  IF(f_empresacontxconvenio.EsCapitado = 2,DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y'),DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,      '%d/%m/%Y')) AS FechaFac,\n  IF(f_empresacontxconvenio.EsCapitado = 2,f_factura_evento.EstaArmada,f_factura_capita.EstaArmada) AS Estado,\n  f_liquidacion.TotalServicio,f_liquidacion.TotalPlan,f_liquidacion.TotalEps,f_liquidacion.TotalDescuento,f_liquidacion.TotalPaciente,(f_liquidacion.CuotaModeradora + f_liquidacion.Copago) AS CP,\n  f_liquidacion.Observacion,f_liquidacion.Id AS Id_Liquidacion,f_gruposervicio.Nbre AS Grupo,f_subgruposervicio.Nbre AS SubGrupo,\n  IF(f_empresacontxconvenio.EsCapitado = 2,f_factura_evento.TipoFactura,f_factura_capita.TipoFactura) AS Tipo,\n  f_liquidacion.NFolios,  f_factura_evento.Fecha_FacturaEvento,  IF(IFNULL(f_factura_evento.Id_DocumentoC,0) = 0,'',f_factura_evento.Id_DocumentoC) Id_DocumentoC, ifnull(f_factura_evento.No_FacturaEvento, '0') idFacturaEvento, ifnull(f_factura_evento.responseEstado, '') estadoEnvioDian, ifnull(f_factura_evento.responseMensaje, '') mensajeEnvioDian,  \n  f_liquidacion.`IdFormaPago` AS idFormaPago, k_formapago.`Nbre` AS formaPago\nFROM  f_liquidacion\n  LEFT JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)\n  LEFT JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = f_liquidacion.Id_Ingreso)\n  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_ips ON (g_ips.Id = f_empresacontxconvenio.Id_GIps)\n  INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)\n  INNER JOIN f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)\n  LEFT JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian)\n  INNER JOIN k_formapago ON (k_formapago.`Id` = f_liquidacion.`IdFormaPago`)WHERE (f_liquidacion.Id_Ingreso = '" + this.xjifliq.JLB_NIngreso.getText() + "' AND f_liquidacion.Estado = 0)";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                this.xjifliq.setxId_Liqidacion(0L);
                if (xrs.next()) {
                    xrs.first();
                    this.idFacturaEvento = xrs.getString("idFacturaEvento");
                    this.JLB_EstadoDian.setText(xrs.getString("estadoEnvioDian"));
                    this.JLB_MensajeDian.setText(xrs.getString("mensajeEnvioDian"));
                    this.JCB_FGrupo.setSelectedItem(xrs.getString("Grupo"));
                    this.JCB_FSubGrupo.setSelectedItem(xrs.getString("SubGrupo"));
                    this.JTA_FObservacion.setText(xrs.getString("Observacion"));
                    this.JDFFechaR.setDate(this.xmt.getPasarTextoAFecha(xrs.getString("FechaFac")));
                    if (xrs.getInt("Tipo") == 0) {
                        this.JTF_FNFacturaO.setText(xrs.getString("NFactura"));
                        this.JTF_FFechaFO.setText(xrs.getString("FechaFac"));
                    } else {
                        this.JTF_FNFactura_P.setText(xrs.getString("NFactura"));
                        this.JTF_FechaFOP.setText(xrs.getString("FechaFac"));
                    }
                    this.JTFF_TSubtotal.setValue(Double.valueOf(xrs.getDouble("TotalServicio")));
                    this.JTFF_TPlan.setValue(Double.valueOf(xrs.getDouble("TotalPlan")));
                    this.JTFF_TNPlan.setValue(Double.valueOf(xrs.getDouble("TotalServicio") - xrs.getDouble("TotalPlan")));
                    this.JTFF_TCModeradora_Copago.setValue(Double.valueOf(xrs.getDouble("CP")));
                    this.JTFF_TDescuento.setValue(Double.valueOf(xrs.getDouble("TotalDescuento")));
                    this.JTFF_TUsuario.setValue(Double.valueOf(xrs.getDouble("TotalPaciente")));
                    this.JTFF_TEps.setValue(Double.valueOf(xrs.getDouble("TotalEps")));
                    this.JSP_NFolios.setValue(Long.valueOf(xrs.getLong("NFolios")));
                    this.xId_Liquidacion = xrs.getLong("Id_Liquidacion");
                    this.xjifliq.setxId_Liqidacion(this.xId_Liquidacion);
                    this.JTF_NoDocContable.setText(xrs.getString("Id_DocumentoC"));
                    this.xEstado = xrs.getInt("Estado");
                    this.JCBFPago.setSelectedItem(xrs.getString("formaPago"));
                    this.JBT_OrdenSalida.setEnabled(true);
                } else {
                    this.JBT_OrdenSalida.setEnabled(false);
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
                activarEnvioDian();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPConsolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (!this.JTF_FNFacturaO.getText().isEmpty() || !this.JTF_FNFactura_P.getText().isEmpty()) {
            if (this.xEstado == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Liquidacion_N", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            if (this.xEstado == 1) {
                JOptionPane.showInternalMessageDialog(this, "N° Orden/Factura se encuentra armada y lista para presentarse", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else if (this.xEstado == 2) {
                JOptionPane.showInternalMessageDialog(this, "N° Orden/Factura ya presentada;\nNo se puede anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void mAnular(String xid, String xMotivo, String xObservacion) {
        this.xsql = "update f_liquidacion set `Estado`=1, `Id_Motivo_Anulacion`='" + xid + "', `Observacion_Anulacion`='" + xObservacion + "', `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.xId_Liquidacion + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.xjifliq.getxEsCapitado().equals("2")) {
            this.xsql = "UPDATE f_factura_evento, f_liquidacion SET f_factura_evento.Estado =1, Id_MotivoAnulacion=" + xid + ", f_factura_evento.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_evento.`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' , f_factura_evento.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_evento.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_liquidacion.Id =" + this.xId_Liquidacion + ")";
        } else {
            this.xsql = "UPDATE f_factura_capita, f_liquidacion SET f_factura_capita.Estado =1, Id_MotivoAnulacion=" + xid + ", f_factura_capita.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_capita.`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' , f_factura_capita.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_capita.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_liquidacion.Id =" + this.xId_Liquidacion + ")";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mNuevo();
    }

    public void mImprimir() {
        ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
        impresionInformes.visualizarFacturasEventoMetodoPrinicpal(this.xjifliq.JLB_NIngreso.getText(), this.JTFF_TSubtotal.getText(), this.JTFF_TPlan.getText(), this.JTFF_TDescuento.getText(), this.JTFF_TCModeradora_Copago.getText(), this.JTFF_TUsuario.getText(), this.JTFF_TEps.getText(), this.formaVisualizacion.intValue(), 0);
    }
}
