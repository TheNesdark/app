package com.genoma.plus.controller.facturacion.saludocupacional;

import Acceso.Principal;
import Facturacion.claseFacturacion;
import General.ClaseImpresionInformes;
import General.JDBiometrico;
import ParametrizacionN.JDcargos;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.BuscarIngresoAgil;
import com.genoma.plus.controller.parametrizacion.JDEmpresaMision;
import com.genoma.plus.dto.facturacion.IngresoAgil;
import com.genoma.plus.jpa.entities.BarrioEntity;
import com.genoma.plus.jpa.entities.CClasecita;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FCentrocosto;
import com.genoma.plus.jpa.entities.FEmpresacontxconvenioMision;
import com.genoma.plus.jpa.entities.FEstratoxemprcontconv;
import com.genoma.plus.jpa.entities.FFacturaCapita;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FItemordenesproced;
import com.genoma.plus.jpa.entities.FOrdenes;
import com.genoma.plus.jpa.entities.FTipofinprocedimiento;
import com.genoma.plus.jpa.entities.FTiposervicio;
import com.genoma.plus.jpa.entities.GCargos;
import com.genoma.plus.jpa.entities.GCausaexterna;
import com.genoma.plus.jpa.entities.GContratos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEmpresacont;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GEstadocivil;
import com.genoma.plus.jpa.entities.GEtapaProceso;
import com.genoma.plus.jpa.entities.GNivelestudio;
import com.genoma.plus.jpa.entities.GOrigenadmision;
import com.genoma.plus.jpa.entities.GParentesco;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GPoblacionEspecial;
import com.genoma.plus.jpa.entities.GProcedimiento;
import com.genoma.plus.jpa.entities.GProfesional;
import com.genoma.plus.jpa.entities.GSexo;
import com.genoma.plus.jpa.entities.GSoJornada;
import com.genoma.plus.jpa.entities.GSoLateralidad;
import com.genoma.plus.jpa.entities.GTipoEtnia;
import com.genoma.plus.jpa.entities.GTipoafiliado;
import com.genoma.plus.jpa.entities.GTipoatencion;
import com.genoma.plus.jpa.entities.GTipoedad;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.HAtencion;
import com.genoma.plus.jpa.entities.HSoDatosOcupacionales;
import com.genoma.plus.jpa.entities.Ingreso;
import com.genoma.plus.jpa.entities.KFormapago;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.entities.MedioPago;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.ResolucionDianDTO;
import com.genoma.plus.jpa.entities.SoTipoGrupo;
import com.genoma.plus.jpa.entities.SoTipoSegmento;
import com.genoma.plus.jpa.entities.SubgrupoEmpresaEntity;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.projection.IInformacionSuministroProcedimiento;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.CClasecitaService;
import com.genoma.plus.jpa.service.FCentrocostoService;
import com.genoma.plus.jpa.service.GEmpresacontService;
import com.genoma.plus.jpa.service.GNivelestudioService;
import com.genoma.plus.jpa.service.GTipoafiliadoService;
import com.genoma.plus.jpa.service.GTipoatencionService;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IEspecialidadService;
import com.genoma.plus.jpa.service.IEstadocivilService;
import com.genoma.plus.jpa.service.IFTipofinprocedimientoService;
import com.genoma.plus.jpa.service.IGCargosService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.genoma.plus.jpa.service.IGPoblacionEspecialService;
import com.genoma.plus.jpa.service.IKFormapagoService;
import com.genoma.plus.jpa.service.IMedioPagoService;
import com.genoma.plus.jpa.service.IMunicipioService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ISexoService;
import com.genoma.plus.jpa.service.ISubgrupoEmpresaService;
import com.genoma.plus.jpa.service.ITipoEtniaService;
import com.genoma.plus.jpa.service.ITipoIdentificacionService;
import com.genoma.plus.jpa.service.IngresoService;
import com.genoma.plus.jpa.service.f_empresacontxconvenio_misionService;
import com.genoma.plus.utils.UtilidadesGenericas;
import com.toedter.calendar.JDateChooser;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Cursor;
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
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/saludocupacional/JIF_FacturacionAgil.class */
public class JIF_FacturacionAgil extends JInternalFrame {
    private final IEmpresaContConvenioService empresaContConvenioService;
    private final CClasecitaService claseCitaService;
    private final ITipoIdentificacionService identificacionService;
    private final ISexoService sexoService;
    private final IEstadocivilService estadocivilService;
    private final IMunicipioService municipioService;
    private final ITipoEtniaService tipoEtniaService;
    private final GTipoafiliadoService tipoafiliadoService;
    private final IGPoblacionEspecialService poblacionEspecialService;
    private final GTipoatencionService tipoatencionService;
    private final IEspecialidadService especialidadService;
    private final GNivelestudioService nivelestudioService;
    private final FCentrocostoService centrocostoService;
    private final IGPersonaService personaService;
    private final GUsuarioService usuarioService;
    private final IGCargosService cargosService;
    private final GEmpresacontService empresacontService;
    private final IMedioPagoService medioPagoService;
    private final IKFormapagoService formapagoService;
    private final ISubgrupoEmpresaService subgrupoEmpresaService;
    private final IResolucionDianDAO xIResolucionDianDAO;
    private final f_empresacontxconvenio_misionService empresaEnMisionService;
    private final IFTipofinprocedimientoService tipofinprocedimientoService;
    private final IngresoService ingresoService;
    private List<EmpresaContConvenioEntity> listEmpresaContConvenioEntity;
    private List<CClasecita> listClaseCitas;
    private List<TipoIdentificacionDTO> listTipoIdentificacionDTO;
    private List<GSexo> listSexo;
    private List<GEstadocivil> listEstadocivils;
    private List<MunicipioDTO> listMunicipioDTOs;
    private List<BarrioEntity> listBarrioEntitys;
    private List<GTipoEtnia> listTipoEtnia;
    private List<GTipoafiliado> listTipoafiliados;
    private List<GPoblacionEspecial> listPoblacionEspecials;
    private List<GTipoatencion> listTipoatencion;
    private List<FEstratoxemprcontconv> listEstratoxemprcontconvs;
    private List<GContratos> listContratoConvenio;
    private List<GEspecialidad> listEspecialidad;
    private List<GProfesional> listProfesionales;
    private List<GNivelestudio> listNivelEstudio;
    private List<FEmpresacontxconvenioMision> listEmpresaMision;
    private List<GCargos> listCargo;
    private List<FCentrocosto> listCentroCosto;
    private List<FTiposervicio> listServicio;
    private List<FTipofinprocedimiento> listFinProcedimiento;
    private List<IInformacionSuministroProcedimiento> listProcedimientoSuministro;
    private List<SubgrupoEmpresaEntity> listSubgrupoEmpresa;
    private List<KFormapago> listFormaPago;
    private List<MedioPago> listMedioPago;
    private IResolucionFacturaElectronica resolucionDian;
    private GPersona persona;
    private GUsuario usuario;
    private Ingreso ingreso;
    private List<FOrdenes> listOrden;
    private LiquidacionEntity liquidacionEntity;
    private FFacturaCapita facturaCapita;
    private FFacturaEvento facturaEvento;
    private HAtencion atencion;
    private HSoDatosOcupacionales soDatosOcupacionales;
    HashSet ordenesHS;
    private IngresoAgil ingresoAgil;
    private final UtilidadesGenericas utilidadesGenericas;
    private final Metodos metodos;
    private Boolean filtro;
    private DefaultTableModel modeloDetalle;
    private boolean lleno;
    private boolean llenado1;
    private boolean validacion;
    private GEmpresacont empresaContrato;
    private Double totalOrden = new Double(0.0d);
    private Double totalEps = new Double(0.0d);
    private Double totalDescuento = new Double(0.0d);
    private Double totalPaciente = new Double(0.0d);
    private String numeroOrdenFact;
    private String edad;
    private ButtonGroup JBG_Filtro;
    private ButtonGroup JBG_FiltroSanguineo;
    private JButton JBTAdicionar;
    private JComboBox JCBBarrio;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBContrato;
    private JComboBox JCBEmpresa;
    private JComboBox JCBEmpresaMision;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBEstadoCivil;
    private JComboBox JCBEstrato;
    private JComboBox JCBEtnia;
    private JComboBox JCBFPago;
    private JComboBox JCBFinProcedimiento;
    private JComboBox JCBItems;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBMunicipio;
    private JComboBox JCBMunicipioNacimiento;
    private JComboBox JCBNivelEstudio;
    private JComboBox JCBPobEspecial;
    private JComboBox JCBProfesional;
    private JComboBox JCBSangre;
    private JComboBox JCBServicio;
    private JComboBox JCBSexo;
    private JComboBox<String> JCBSubgrupo;
    private JComboBox JCBTipoAfiliado;
    private JComboBox JCBTipoAtencion;
    private JComboBox JCBTipoExamen;
    private JComboBox JCBTipoIdentificacion;
    private JRadioButton JCHCModeradora;
    private JRadioButton JCHCopago;
    private JCheckBox JCHNegativo;
    private JCheckBox JCHPositivo;
    private JDateChooser JDCFecha;
    private JDateChooser JDCFechaNacimiento;
    private JLabel JLBEstadoBloqueo;
    private JLabel JLB_Foto;
    private JLabel JLB_Ingreso;
    private JLabel JLB_NOrdenFactura;
    private JPanel JPDPersonales;
    public JPanel JPIGrupoSangre;
    private JPanel JPIIngreso;
    private JPanel JPI_Datos;
    private JPanel JPI_DatosFactura;
    private JPanel JPI_DatosInfoExamen;
    private JPanel JPI_Encabezado;
    private JPanel JPI_Orden;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDatosTabla;
    private JSpinner JSPNClaSE;
    private JSpinner JSPNHijos;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacionFac;
    private JScrollPane JSP_Datos;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionFac;
    private JTable JTBDetalle;
    private JTextField JTFAfiliacion;
    private JTextField JTFArl;
    private JTextField JTFCargo;
    private JTextField JTFCelular;
    private JTextField JTFCodigo;
    private JTextField JTFCorreo;
    private JTextField JTFDireccion;
    private JTextField JTFEps;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFNoAutorizacion;
    private JTextField JTFTelefono;
    private JTextFieldValidator JTFVApellido1;
    private JTextFieldValidator JTFVApellido2;
    private JFormattedTextField JTFVDescuento;
    private JTextField JTFVEdad;
    private JTextFieldValidator JTFVIdentificacion;
    private JTextFieldValidator JTFVNombre1;
    private JTextFieldValidator JTFVNombre2;
    private JFormattedTextField JTFVSubtotal;
    private JFormattedTextField JTFVTotal;
    private JFormattedTextField JTFVrTotal;
    private JFormattedTextField JTFVrUnitario;
    private JTabbedPane JTP_Datos;
    private JButton jButton1;
    private JPanel jPanel4;

    public JIF_FacturacionAgil(claseFacturacion xclasefacturacion, GPersona persona) {
        initComponents();
        this.empresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.claseCitaService = (CClasecitaService) Principal.contexto.getBean(CClasecitaService.class);
        this.identificacionService = (ITipoIdentificacionService) Principal.contexto.getBean(ITipoIdentificacionService.class);
        this.sexoService = (ISexoService) Principal.contexto.getBean(ISexoService.class);
        this.estadocivilService = (IEstadocivilService) Principal.contexto.getBean(IEstadocivilService.class);
        this.municipioService = (IMunicipioService) Principal.contexto.getBean(IMunicipioService.class);
        this.tipoafiliadoService = (GTipoafiliadoService) Principal.contexto.getBean(GTipoafiliadoService.class);
        this.tipoEtniaService = (ITipoEtniaService) Principal.contexto.getBean(ITipoEtniaService.class);
        this.poblacionEspecialService = (IGPoblacionEspecialService) Principal.contexto.getBean(IGPoblacionEspecialService.class);
        this.tipoatencionService = (GTipoatencionService) Principal.contexto.getBean(GTipoatencionService.class);
        this.especialidadService = (IEspecialidadService) Principal.contexto.getBean(IEspecialidadService.class);
        this.nivelestudioService = (GNivelestudioService) Principal.contexto.getBean(GNivelestudioService.class);
        this.personaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
        this.usuarioService = (GUsuarioService) Principal.contexto.getBean(GUsuarioService.class);
        this.cargosService = (IGCargosService) Principal.contexto.getBean(IGCargosService.class);
        this.empresacontService = (GEmpresacontService) Principal.contexto.getBean(GEmpresacontService.class);
        this.xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.empresaEnMisionService = (f_empresacontxconvenio_misionService) Principal.contexto.getBean(f_empresacontxconvenio_misionService.class);
        this.centrocostoService = (FCentrocostoService) Principal.contexto.getBean(FCentrocostoService.class);
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
        this.tipofinprocedimientoService = (IFTipofinprocedimientoService) Principal.contexto.getBean(IFTipofinprocedimientoService.class);
        this.medioPagoService = (IMedioPagoService) Principal.contexto.getBean(IMedioPagoService.class);
        this.formapagoService = (IKFormapagoService) Principal.contexto.getBean(IKFormapagoService.class);
        this.subgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
        this.metodos = new Metodos();
        this.utilidadesGenericas = new UtilidadesGenericas();
        Set<AWTKeyStroke> teclas = new HashSet<>();
        teclas.add(AWTKeyStroke.getAWTKeyStroke(9, 0));
        setFocusTraversalKeys(0, teclas);
        inicializar();
        nuevo();
        this.persona = persona;
        buscarPersona();
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_FiltroSanguineo = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JSP_Datos = new JScrollPane();
        this.JPI_Datos = new JPanel();
        this.JPI_DatosInfoExamen = new JPanel();
        this.JDCFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFFHora = new JFormattedTextField();
        this.JCBEmpresa = new JComboBox();
        this.JCBTipoExamen = new JComboBox();
        this.JCBEmpresaMision = new JComboBox();
        this.JTFEps = new JTextField();
        this.JTFArl = new JTextField();
        this.JTFCargo = new JTextField();
        this.JPDPersonales = new JPanel();
        this.JCBTipoIdentificacion = new JComboBox();
        this.JTFVIdentificacion = new JTextFieldValidator();
        this.JTFVApellido1 = new JTextFieldValidator();
        this.JTFVApellido2 = new JTextFieldValidator();
        this.JTFVNombre1 = new JTextFieldValidator();
        this.JTFVNombre2 = new JTextFieldValidator();
        this.JDCFechaNacimiento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFVEdad = new JTextField();
        this.JCBSexo = new JComboBox();
        this.JSPNHijos = new JSpinner();
        this.JSPNClaSE = new JSpinner();
        this.JPIGrupoSangre = new JPanel();
        this.JCBSangre = new JComboBox();
        this.JCHNegativo = new JCheckBox();
        this.JCHPositivo = new JCheckBox();
        this.JCBEstadoCivil = new JComboBox();
        this.JTFTelefono = new JTextField();
        this.JTFCelular = new JTextField();
        this.JTFCorreo = new JTextField();
        this.JCBMunicipio = new JComboBox();
        this.JCBBarrio = new JComboBox();
        this.JTFDireccion = new JTextField();
        this.JCBMunicipioNacimiento = new JComboBox();
        this.JCBEtnia = new JComboBox();
        this.JCBTipoAfiliado = new JComboBox();
        this.JTFAfiliacion = new JTextField();
        this.JCBPobEspecial = new JComboBox();
        this.JPIIngreso = new JPanel();
        this.JCBTipoAtencion = new JComboBox();
        this.jPanel4 = new JPanel();
        this.JCHCModeradora = new JRadioButton();
        this.JCHCopago = new JRadioButton();
        this.JCBEstrato = new JComboBox();
        this.JCBContrato = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBNivelEstudio = new JComboBox();
        this.JTFNoAutorizacion = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLB_Foto = new JLabel();
        this.JLB_Ingreso = new JLabel();
        this.jButton1 = new JButton();
        this.JLBEstadoBloqueo = new JLabel();
        this.JPI_Orden = new JPanel();
        this.JPI_Encabezado = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCBItems = new JComboBox();
        this.JSPCantidad = new JSpinner();
        this.JTFVrUnitario = new JFormattedTextField();
        this.JTFVrTotal = new JFormattedTextField();
        this.JCBServicio = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JCBFinProcedimiento = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.JSPDatosTabla = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_DatosFactura = new JPanel();
        this.JCBFPago = new JComboBox();
        this.JCBMedioDePago = new JComboBox<>();
        this.JCBSubgrupo = new JComboBox<>();
        this.JTFVSubtotal = new JFormattedTextField();
        this.JTFVDescuento = new JFormattedTextField();
        this.JTFVTotal = new JFormattedTextField();
        this.JSPObservacionFac = new JScrollPane();
        this.JTAObservacionFac = new JTextArea();
        this.JLB_NOrdenFactura = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("FACTURACIÓN SALUD OCUPACIONAL");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        setName("xJIFFacturacionAgil");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder(""));
        this.JPI_DatosInfoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE EXÁMEN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setName("hora");
        this.JCBEmpresa.setFont(new Font("Arial", 1, 10));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEmpresa.setName("convenio");
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.2
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCBTipoExamen.setFont(new Font("Arial", 1, 10));
        this.JCBTipoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Exámen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoExamen.setName("claseCita");
        this.JCBEmpresaMision.setFont(new Font("Arial", 1, 10));
        this.JCBEmpresaMision.setToolTipText("Doble clic para crear empresa en misión");
        this.JCBEmpresaMision.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa en misión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresaMision.setName("empresaMision");
        this.JCBEmpresaMision.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.3
            public void mouseClicked(MouseEvent evt) {
                JIF_FacturacionAgil.this.JCBEmpresaMisionMouseClicked(evt);
            }
        });
        this.JCBEmpresaMision.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.4
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JCBEmpresaMisionKeyPressed(evt);
            }
        });
        this.JTFEps.setFont(new Font("Arial", 1, 12));
        this.JTFEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad de Salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEps.setName("Entidad_de_Salud");
        this.JTFArl.setFont(new Font("Arial", 1, 12));
        this.JTFArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFArl.setName("arl");
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCargo.setName("Entidad_de_Salud");
        this.JTFCargo.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.5
            public void mouseClicked(MouseEvent evt) {
                JIF_FacturacionAgil.this.JTFCargoMouseClicked(evt);
            }
        });
        this.JTFCargo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.6
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTFCargoKeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosInfoExamenLayout = new GroupLayout(this.JPI_DatosInfoExamen);
        this.JPI_DatosInfoExamen.setLayout(JPI_DatosInfoExamenLayout);
        JPI_DatosInfoExamenLayout.setHorizontalGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosInfoExamenLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_DatosInfoExamenLayout.createSequentialGroup().addComponent(this.JCBEmpresaMision, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCargo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEps, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFArl, -2, 209, -2)).addGroup(JPI_DatosInfoExamenLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 451, -2).addGap(18, 18, 18).addComponent(this.JCBTipoExamen, -2, 231, -2))).addContainerGap(-1, 32767)));
        JPI_DatosInfoExamenLayout.setVerticalGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosInfoExamenLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JDCFecha, -2, 50, -2).addGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, 50, -2).addComponent(this.JCBTipoExamen, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosInfoExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresaMision, -2, 50, -2).addComponent(this.JTFArl, -2, 50, -2).addComponent(this.JTFEps, -2, 50, -2).addComponent(this.JTFCargo, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JPDPersonales.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTipoIdentificacion.setFont(new Font("Arial", 1, 10));
        this.JCBTipoIdentificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoIdentificacion.setName("tipoDocumento");
        this.JCBTipoIdentificacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.7
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBTipoIdentificacionItemStateChanged(evt);
            }
        });
        this.JTFVIdentificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVIdentificacion.setFont(new Font("Arial", 1, 12));
        this.JTFVIdentificacion.setName("NoDocumento");
        this.JTFVIdentificacion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.8
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVIdentificacionFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVIdentificacionFocusLost(evt);
            }
        });
        this.JTFVApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "1. Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVApellido1.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.JTFVApellido1.setFont(new Font("Arial", 1, 12));
        this.JTFVApellido1.setName("Primer_ Apellido");
        this.JTFVApellido1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.9
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVApellido1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVApellido1FocusLost(evt);
            }
        });
        this.JTFVApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "2. Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVApellido2.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.JTFVApellido2.setFont(new Font("Arial", 1, 12));
        this.JTFVApellido2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.10
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVApellido2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVApellido2FocusLost(evt);
            }
        });
        this.JTFVApellido2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.11
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JTFVApellido2ActionPerformed(evt);
            }
        });
        this.JTFVNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "1.Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVNombre1.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.JTFVNombre1.setFont(new Font("Arial", 1, 12));
        this.JTFVNombre1.setName("primer_ Nombre");
        this.JTFVNombre1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.12
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVNombre1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVNombre1FocusLost(evt);
            }
        });
        this.JTFVNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "2. Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVNombre2.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.JTFVNombre2.setFont(new Font("Arial", 1, 12));
        this.JTFVNombre2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.13
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVNombre2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVNombre2FocusLost(evt);
            }
        });
        this.JDCFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "F.Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaNacimiento.setFont(new Font("Arial", 1, 12));
        this.JDCFechaNacimiento.setName("txtFecha");
        this.JDCFechaNacimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_FacturacionAgil.this.JDCFechaNacimientoPropertyChange(evt);
            }
        });
        this.JTFVEdad.setEditable(false);
        this.JTFVEdad.setFont(new Font("Arial", 1, 14));
        this.JTFVEdad.setForeground(Color.red);
        this.JTFVEdad.setHorizontalAlignment(0);
        this.JTFVEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVEdad.setDisabledTextColor(new Color(255, 255, 255));
        this.JCBSexo.setFont(new Font("Arial", 1, 10));
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexo.setCursor(new Cursor(0));
        this.JCBSexo.setName("sexo");
        this.JSPNHijos.setFont(new Font("Arial", 1, 12));
        this.JSPNHijos.setModel(new SpinnerNumberModel(0, 0, 30, 1));
        this.JSPNHijos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNHijos.setName("NoHijos");
        this.JSPNClaSE.setFont(new Font("Arial", 1, 12));
        this.JSPNClaSE.setToolTipText("CLasificacion Socio Economica");
        this.JSPNClaSE.setBorder(BorderFactory.createTitledBorder((Border) null, "Cla. SE", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIGrupoSangre.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Sanguineo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JPIGrupoSangre.setForeground(new Color(0, 0, 204));
        this.JCBSangre.setFont(new Font("Arial", 1, 12));
        this.JCBSangre.setModel(new DefaultComboBoxModel(new String[]{"-", "A", "B", "O", "AB"}));
        this.JCBSangre.setName("tipoSangre");
        this.JBG_FiltroSanguineo.add(this.JCHNegativo);
        this.JCHNegativo.setFont(new Font("Arial", 1, 12));
        this.JCHNegativo.setForeground(Color.blue);
        this.JCHNegativo.setText("Negativo");
        this.JCHNegativo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.15
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JCHNegativoActionPerformed(evt);
            }
        });
        this.JBG_FiltroSanguineo.add(this.JCHPositivo);
        this.JCHPositivo.setFont(new Font("Arial", 1, 12));
        this.JCHPositivo.setForeground(Color.blue);
        this.JCHPositivo.setText("Positivo");
        GroupLayout JPIGrupoSangreLayout = new GroupLayout(this.JPIGrupoSangre);
        this.JPIGrupoSangre.setLayout(JPIGrupoSangreLayout);
        JPIGrupoSangreLayout.setHorizontalGroup(JPIGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGrupoSangreLayout.createSequentialGroup().addComponent(this.JCBSangre, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHNegativo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPositivo)));
        JPIGrupoSangreLayout.setVerticalGroup(JPIGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSangre, -2, 29, -2).addComponent(this.JCHPositivo).addComponent(this.JCHNegativo)));
        this.JCBEstadoCivil.setFont(new Font("Arial", 1, 10));
        this.JCBEstadoCivil.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Cívil", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstadoCivil.setName("estadoCivil");
        this.JTFTelefono.setFont(new Font("Arial", 1, 12));
        this.JTFTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono Fijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCelular.setFont(new Font("Arial", 1, 12));
        this.JTFCelular.setBorder(BorderFactory.createTitledBorder((Border) null, "Celular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Electrónico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 10));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio Residencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.setName("municipioResidencia");
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.16
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JCBBarrio.setFont(new Font("Arial", 1, 10));
        this.JCBBarrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Barrio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBarrio.setName("barrio");
        this.JCBBarrio.setPreferredSize(new Dimension(20, 20));
        this.JTFDireccion.setFont(new Font("Arial", 1, 12));
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDireccion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.17
            public void focusGained(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFDireccionFocusGained(evt);
            }
        });
        this.JCBMunicipioNacimiento.setFont(new Font("Arial", 1, 10));
        this.JCBMunicipioNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipioNacimiento.setName("municipioNacimiento");
        this.JCBMunicipioNacimiento.setPreferredSize(new Dimension(20, 20));
        this.JCBEtnia.setFont(new Font("Arial", 1, 10));
        this.JCBEtnia.setBorder(BorderFactory.createTitledBorder((Border) null, "Etnia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEtnia.setName("tipoEtnia");
        this.JCBTipoAfiliado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAfiliado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Afiliado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAfiliado.setName("tipoAfiliado");
        this.JTFAfiliacion.setFont(new Font("Arial", 1, 12));
        this.JTFAfiliacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Afiliacion/Carnet", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPobEspecial.setFont(new Font("Arial", 1, 10));
        this.JCBPobEspecial.setBorder(BorderFactory.createTitledBorder((Border) null, "Población Especial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPobEspecial.setName("tipoPoblacionEspecial");
        GroupLayout JPDPersonalesLayout = new GroupLayout(this.JPDPersonales);
        this.JPDPersonales.setLayout(JPDPersonalesLayout);
        JPDPersonalesLayout.setHorizontalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaNacimiento, -1, -1, 32767).addComponent(this.JCBTipoIdentificacion, -2, 150, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFVIdentificacion, -1, 158, 32767).addComponent(this.JTFVEdad)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFVApellido1, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JTFVApellido2, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JTFVNombre1, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JTFVNombre2, -2, 150, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPDPersonalesLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCBSexo, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNHijos, -2, 78, -2).addGap(6, 6, 6).addComponent(this.JSPNClaSE, -2, 78, -2).addGap(18, 18, 18).addComponent(this.JPIGrupoSangre, -2, -1, -2)))).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.JCBEstadoCivil, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTelefono, -2, 187, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCelular, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCorreo)).addComponent(this.JTFDireccion, GroupLayout.Alignment.TRAILING, -2, 429, -2).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBMunicipio, 0, 254, 32767).addComponent(this.JCBMunicipioNacimiento, 0, -1, 32767)).addGap(6, 6, 6).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.JCBEtnia, -2, 359, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTipoAfiliado, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFAfiliacion, -2, 139, -2)).addComponent(this.JCBBarrio, -2, 246, -2)))).addComponent(this.JCBPobEspecial, -2, 254, -2)).addGap(0, 22, 32767)));
        JPDPersonalesLayout.setVerticalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoIdentificacion, -2, 50, -2).addComponent(this.JTFVIdentificacion, -2, 50, -2)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFVApellido1, -2, 50, -2).addComponent(this.JTFVApellido2, -2, 50, -2).addComponent(this.JTFVNombre1, -2, 50, -2).addComponent(this.JTFVNombre2, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFVEdad, -2, 50, -2).addComponent(this.JDCFechaNacimiento, -2, 50, -2)).addComponent(this.JPIGrupoSangre, -2, 50, -2)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNHijos, -2, 50, -2).addComponent(this.JCBSexo, -2, 50, -2)).addComponent(this.JSPNClaSE, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEstadoCivil, -2, 50, -2).addComponent(this.JTFTelefono, -2, 50, -2).addComponent(this.JTFCelular, -2, 50, -2).addComponent(this.JTFCorreo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFDireccion, -2, 50, -2).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JCBBarrio, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipioNacimiento, -2, 50, -2).addComponent(this.JCBTipoAfiliado, -2, 50, -2).addComponent(this.JTFAfiliacion, -2, 50, -2)).addComponent(this.JCBEtnia, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPobEspecial, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JPIIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOSINGRESO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIIngreso.setForeground(new Color(0, 0, 102));
        this.JPIIngreso.setFont(new Font("Tahoma", 1, 11));
        this.JCBTipoAtencion.setFont(new Font("Arial", 1, 10));
        this.JCBTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAtencion.setName("tipoAtencion");
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cobro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_Filtro.add(this.JCHCModeradora);
        this.JCHCModeradora.setFont(new Font("Arial", 1, 12));
        this.JCHCModeradora.setForeground(new Color(0, 0, 255));
        this.JCHCModeradora.setSelected(true);
        this.JCHCModeradora.setText("C. Moderadora");
        this.JCHCModeradora.setFocusable(false);
        this.JCHCModeradora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.18
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JCHCModeradoraActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCHCopago);
        this.JCHCopago.setFont(new Font("Arial", 1, 12));
        this.JCHCopago.setForeground(new Color(0, 0, 255));
        this.JCHCopago.setText("Copago");
        this.JCHCopago.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.19
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JCHCopagoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JCHCModeradora, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHCopago).addGap(40, 40, 40)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCModeradora).addComponent(this.JCHCopago)).addContainerGap(-1, 32767)));
        this.JCBEstrato.setFont(new Font("Arial", 1, 10));
        this.JCBEstrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstrato.setName("estrato");
        this.JCBContrato.setFont(new Font("Arial", 1, 10));
        this.JCBContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBContrato.setName("contrato");
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 10));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.setName("especialidad");
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.20
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 10));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.setName("profesional");
        this.JCBNivelEstudio.setFont(new Font("Arial", 1, 12));
        this.JCBNivelEstudio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel Estudio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNivelEstudio.setName("nivelEstudio");
        this.JTFNoAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JTFNoAutorizacion.setName("autorizacion");
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.21
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTAObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIIngresoLayout = new GroupLayout(this.JPIIngreso);
        this.JPIIngreso.setLayout(JPIIngresoLayout);
        JPIIngresoLayout.setHorizontalGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIngresoLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 270, -2).addGap(12, 12, 12).addComponent(this.JCBProfesional, -2, 373, -2)).addGroup(JPIIngresoLayout.createSequentialGroup().addComponent(this.JCBTipoAtencion, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, 223, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEstrato, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBNivelEstudio, -2, 285, -2).addComponent(this.JCBContrato, -2, 285, -2))).addGroup(JPIIngresoLayout.createSequentialGroup().addComponent(this.JTFNoAutorizacion, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 670, -2))).addGap(0, 18, 32767)));
        JPIIngresoLayout.setVerticalGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIngresoLayout.createSequentialGroup().addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEstrato, -2, 50, -2).addComponent(this.JCBContrato, -2, 50, -2)).addComponent(this.jPanel4, -2, 0, 32767)).addComponent(this.JCBTipoAtencion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCBProfesional, -2, 50, -2).addComponent(this.JCBNivelEstudio, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNoAutorizacion, -1, 50, 32767).addComponent(this.JSPObservacion)).addGap(20, 20, 20)));
        this.JLB_Foto.setBorder(BorderFactory.createTitledBorder((Border) null, "Foto", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Ingreso.setFont(new Font("Arial", 1, 12));
        this.JLB_Ingreso.setForeground(Color.red);
        this.JLB_Ingreso.setHorizontalAlignment(0);
        this.JLB_Ingreso.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Ingreso.setName("idIngreso");
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.jButton1.setText("Huella/Foto");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.22
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.23
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.jButton1KeyPressed(evt);
            }
        });
        this.JLBEstadoBloqueo.setBackground(new Color(0, 153, 51));
        this.JLBEstadoBloqueo.setFont(new Font("Arial", 1, 14));
        this.JLBEstadoBloqueo.setHorizontalAlignment(0);
        this.JLBEstadoBloqueo.setText("ACTIVO");
        this.JLBEstadoBloqueo.setToolTipText("Estado para prestación del servicio\nVerder = Activo\nRojo = Bloqueado");
        this.JLBEstadoBloqueo.setOpaque(true);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPDPersonales, -1, -1, 32767).addComponent(this.JPIIngreso, -1, -1, 32767).addComponent(this.JPI_DatosInfoExamen, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Foto, -1, 161, 32767).addComponent(this.JLB_Ingreso, -1, -1, 32767).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.JLBEstadoBloqueo, -1, -1, 32767)).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JPI_DatosInfoExamen, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPDPersonales, -2, -1, -2)).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JLB_Ingreso, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Foto, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstadoBloqueo, -2, 46, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIIngreso, -2, 188, -2).addContainerGap(15, 32767)));
        this.JSP_Datos.setViewportView(this.JPI_Datos);
        this.JTP_Datos.addTab("DATOS PRINCIPAL", this.JSP_Datos);
        this.JPI_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTO/SUMINISTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setHorizontalAlignment(4);
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.24
            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFCodigoFocusLost(evt);
            }
        });
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.25
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTFCodigoKeyPressed(evt);
            }
        });
        this.JCBItems.setFont(new Font("Arial", 1, 12));
        this.JCBItems.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBItems.setName("ItemsProcSuministro");
        this.JCBItems.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.26
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBItemsItemStateChanged(evt);
            }
        });
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.27
            public void stateChanged(ChangeEvent evt) {
                JIF_FacturacionAgil.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTFVrUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVrUnitario.setForeground(Color.red);
        this.JTFVrUnitario.setHorizontalAlignment(4);
        this.JTFVrUnitario.setFont(new Font("Arial", 1, 12));
        this.JTFVrUnitario.setName("valorUnitario");
        this.JTFVrUnitario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.28
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JTFVrUnitarioActionPerformed(evt);
            }
        });
        this.JTFVrUnitario.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.29
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTFVrUnitarioKeyPressed(evt);
            }
        });
        this.JTFVrTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVrTotal.setForeground(Color.red);
        this.JTFVrTotal.setHorizontalAlignment(4);
        this.JTFVrTotal.setFont(new Font("Arial", 1, 12));
        this.JTFVrTotal.setName("valorTotal");
        this.JCBServicio.setFont(new Font("Arial", 1, 12));
        this.JCBServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBServicio.setName("servicio");
        this.JCBServicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.30
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBServicioItemStateChanged(evt);
            }
        });
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro Costo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCentroCosto.setName("centroCosto");
        this.JCBFinProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBFinProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fin Procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBFinProcedimiento.setName("finProcedimiento");
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setForeground(Color.red);
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.31
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.32
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JBTAdicionarKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIF_FacturacionAgil.this.JBTAdicionarKeyReleased(evt);
            }
        });
        GroupLayout JPI_EncabezadoLayout = new GroupLayout(this.JPI_Encabezado);
        this.JPI_Encabezado.setLayout(JPI_EncabezadoLayout);
        JPI_EncabezadoLayout.setHorizontalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JCBServicio, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCentroCosto, -2, 346, -2).addContainerGap(-1, 32767)).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JCBFinProcedimiento, -2, 404, -2).addGap(0, 478, 32767)).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBItems, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCantidad, -2, 89, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JTFVrUnitario, -2, 110, -2).addGap(12, 12, 12).addComponent(this.JTFVrTotal, -2, 110, -2)).addComponent(this.JBTAdicionar, -1, -1, 32767)).addGap(15, 15, 15)))));
        JPI_EncabezadoLayout.setVerticalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBServicio, -2, 50, -2).addComponent(this.JCBCentroCosto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBItems, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JSPCantidad, -2, 50, -2).addComponent(this.JTFVrUnitario, -2, 50, -2).addComponent(this.JTFVrTotal, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBFinProcedimiento, -2, 50, -2).addComponent(this.JBTAdicionar, -2, 50, -2)).addContainerGap()));
        this.JSPDatosTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.33
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDatosTabla.setViewportView(this.JTBDetalle);
        this.JPI_DatosFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA FACTURACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBFPago.setFont(new Font("Arial", 1, 12));
        this.JCBFPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFPago.setName("forma_pago");
        this.JCBFPago.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.34
            public void itemStateChanged(ItemEvent evt) {
                JIF_FacturacionAgil.this.JCBFPagoItemStateChanged(evt);
            }
        });
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMedioDePago.setName("medio_pago");
        this.JCBSubgrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubgrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Subgrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubgrupo.setName("subgrupo");
        this.JTFVSubtotal.setEditable(false);
        this.JTFVSubtotal.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVSubtotal.setForeground(Color.red);
        this.JTFVSubtotal.setHorizontalAlignment(4);
        this.JTFVSubtotal.setFont(new Font("Arial", 1, 12));
        this.JTFVSubtotal.setName("valorUnitario");
        this.JTFVDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVDescuento.setForeground(Color.red);
        this.JTFVDescuento.setHorizontalAlignment(4);
        this.JTFVDescuento.setFont(new Font("Arial", 1, 12));
        this.JTFVDescuento.setName("valorTotal");
        this.JTFVDescuento.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.35
            public void focusLost(FocusEvent evt) {
                JIF_FacturacionAgil.this.JTFVDescuentoFocusLost(evt);
            }
        });
        this.JTFVDescuento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.36
            public void actionPerformed(ActionEvent evt) {
                JIF_FacturacionAgil.this.JTFVDescuentoActionPerformed(evt);
            }
        });
        this.JTFVDescuento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.37
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTFVDescuentoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTFVDescuentoKeyReleased(evt);
            }
        });
        this.JTFVTotal.setEditable(false);
        this.JTFVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVTotal.setForeground(Color.red);
        this.JTFVTotal.setHorizontalAlignment(4);
        this.JTFVTotal.setFont(new Font("Arial", 1, 12));
        this.JTFVTotal.setName("valorUnitario");
        this.JSPObservacionFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacionFac.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionFac.setColumns(20);
        this.JTAObservacionFac.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionFac.setRows(1);
        this.JTAObservacionFac.setTabSize(1);
        this.JTAObservacionFac.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.38
            public void keyPressed(KeyEvent evt) {
                JIF_FacturacionAgil.this.JTAObservacionFacKeyPressed(evt);
            }
        });
        this.JSPObservacionFac.setViewportView(this.JTAObservacionFac);
        this.JLB_NOrdenFactura.setFont(new Font("Arial", 1, 14));
        this.JLB_NOrdenFactura.setForeground(Color.red);
        this.JLB_NOrdenFactura.setHorizontalAlignment(0);
        this.JLB_NOrdenFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura/Orden", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DatosFacturaLayout = new GroupLayout(this.JPI_DatosFactura);
        this.JPI_DatosFactura.setLayout(JPI_DatosFacturaLayout);
        JPI_DatosFacturaLayout.setHorizontalGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObservacionFac).addComponent(this.JCBSubgrupo, 0, -1, 32767).addGroup(JPI_DatosFacturaLayout.createSequentialGroup().addComponent(this.JCBFPago, -2, 175, -2).addGap(18, 18, 18).addComponent(this.JCBMedioDePago, -2, 334, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DatosFacturaLayout.createSequentialGroup().addComponent(this.JTFVSubtotal, -2, 150, -2).addGap(12, 12, 12).addComponent(this.JTFVDescuento, -2, 150, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFacturaLayout.createSequentialGroup().addComponent(this.JTFVTotal, -2, 150, -2).addGap(78, 78, 78)).addComponent(this.JLB_NOrdenFactura, -1, -1, 32767)).addContainerGap()));
        JPI_DatosFacturaLayout.setVerticalGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFacturaLayout.createSequentialGroup().addGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFPago, -2, 50, -2).addComponent(this.JCBMedioDePago, -2, 50, -2).addComponent(this.JTFVSubtotal, -2, 50, -2).addComponent(this.JTFVDescuento, -2, 50, -2)).addGap(11, 11, 11).addGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSubgrupo, -2, 50, -2).addComponent(this.JTFVTotal, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacionFac, -1, 50, 32767).addComponent(this.JLB_NOrdenFactura, -1, -1, 32767)).addGap(19, 19, 19)));
        GroupLayout JPI_OrdenLayout = new GroupLayout(this.JPI_Orden);
        this.JPI_Orden.setLayout(JPI_OrdenLayout);
        JPI_OrdenLayout.setHorizontalGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OrdenLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatosTabla).addComponent(this.JPI_Encabezado, -1, -1, 32767).addComponent(this.JPI_DatosFactura, -1, -1, 32767)).addContainerGap()));
        JPI_OrdenLayout.setVerticalGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Encabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosTabla, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_DatosFactura, -2, -1, -2).addContainerGap(23, 32767)));
        this.JTP_Datos.addTab("ORDENES", this.JPI_Orden);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTP_Datos).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTP_Datos, -2, 778, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVNombre2FocusGained(FocusEvent evt) {
        this.JTFVNombre2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVNombre2FocusLost(FocusEvent evt) {
        this.JTFVNombre2.setText(this.metodos.validarTexto(this.JTFVNombre2.getText(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVNombre1FocusGained(FocusEvent evt) {
        this.JTFVNombre1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVNombre1FocusLost(FocusEvent evt) {
        this.JTFVNombre1.setText(this.metodos.validarTexto(this.JTFVNombre1.getText(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVApellido2ActionPerformed(ActionEvent evt) {
        this.JTFVApellido2.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVApellido2FocusGained(FocusEvent evt) {
        this.JTFVApellido2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVApellido2FocusLost(FocusEvent evt) {
        this.JTFVApellido2.setText(this.metodos.validarTexto(this.JTFVApellido2.getText(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVApellido1FocusGained(FocusEvent evt) {
        this.JTFVApellido1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVApellido1FocusLost(FocusEvent evt) {
        this.JTFVApellido1.setText(this.metodos.validarTexto(this.JTFVApellido1.getText(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVIdentificacionFocusGained(FocusEvent evt) {
        this.JTFVIdentificacion.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoIdentificacionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionFocusGained(FocusEvent evt) {
        this.JTFDireccion.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.JCBMunicipio.getSelectedIndex() != -1) {
            this.JCBBarrio.removeAllItems();
            this.listBarrioEntitys = new ArrayList();
            this.listBarrioEntitys = (List) this.listMunicipioDTOs.get(this.JCBMunicipio.getSelectedIndex()).getBarrioEntityCollection();
            this.utilidadesGenericas.llenarCombo(this.JCBBarrio, this.listBarrioEntitys);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNegativoActionPerformed(ActionEvent evt) {
        this.JCHNegativo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCopagoActionPerformed(ActionEvent evt) {
        this.filtro = true;
        this.JCHCopago.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            llenadoComboEstrato();
            llenarComboContrato();
            llenarComboServicio();
            llenarComboDependeciaConvenio();
            llenarComboEmpresaMision();
            limpiarControles(this.JPI_Encabezado, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (!this.listEspecialidad.isEmpty() && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.listProfesionales = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBServicioItemStateChanged(ItemEvent evt) {
        this.JCBItems.removeAllItems();
        this.llenado1 = false;
        if (this.lleno && this.JCBEmpresa.getSelectedIndex() >= 0 && this.JCBServicio.getSelectedIndex() >= 0) {
            this.listProcedimientoSuministro = new ArrayList();
            this.listProcedimientoSuministro = this.ingresoService.listaProcedimientoSiministro(this.persona, this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()), this.listServicio.get(this.JCBServicio.getSelectedIndex()), Principal.informacionIps);
            this.utilidadesGenericas.llenarCombo(this.JCBItems, this.listProcedimientoSuministro);
            this.llenado1 = true;
            limpiarControles(this.JPI_Encabezado, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBItemsItemStateChanged(ItemEvent evt) {
        if (this.llenado1 && this.JCBItems.getSelectedIndex() >= 0) {
            this.JTFCodigo.setText(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getCodigo());
            this.JTFVrUnitario.setValue(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getValorUnitario());
            this.JCBFinProcedimiento.setSelectedItem(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getFinProcedimiento());
            calcularValorTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadStateChanged(ChangeEvent evt) {
        calcularValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVrUnitarioActionPerformed(ActionEvent evt) {
        calcularValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVrUnitarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            calcularValorTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.metodos.mVerificarDatosDoblesTabla(this.JTBDetalle, 0, this.JTFCodigo.getText())) {
            addItems();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Código ya ingresado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        addItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTP_Datos.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyPressed(KeyEvent evt) {
        buscarProcedimientosCodigo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoFocusLost(FocusEvent evt) {
        buscarProcedimientosCodigo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCModeradoraActionPerformed(ActionEvent evt) {
        this.filtro = true;
        this.JCHCopago.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVIdentificacionFocusLost(FocusEvent evt) {
        buscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.JLB_Ingreso.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "xIngreso", this.JLB_Ingreso.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setLocationRelativeTo(this);
            xjdBiometrico.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaMisionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            crearEmpresasMision();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaMisionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 113) {
            crearEmpresasMision();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCargoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            crearCargos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVDescuentoFocusLost(FocusEvent evt) {
        calcularValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVDescuentoActionPerformed(ActionEvent evt) {
        calcularValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionFacKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVDescuentoKeyReleased(KeyEvent evt) {
        calcularValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            calcularValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (this.JLB_Ingreso.getText().isEmpty()) {
            if (evt.getKeyCode() == 127) {
                this.listOrden.remove(this.JTBDetalle.getSelectedRow());
                this.modeloDetalle.removeRow(this.JTBDetalle.getSelectedRow());
                calcularValores();
            }
            System.out.println("code suprimir " + evt.getKeyCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaNacimientoPropertyChange(PropertyChangeEvent evt) {
        this.edad = this.utilidadesGenericas.calcularEdadAnnos(this.JDCFechaNacimiento.getDate(), this.JDCFecha.getDate());
        this.JTFVEdad.setText(this.edad + "Años");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCargoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 112) {
            crearCargos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFPagoItemStateChanged(ItemEvent evt) {
        if (this.JCBFPago.getSelectedIndex() != -1 && this.listMedioPago.size() > 0) {
            if (this.JCBFPago.getSelectedIndex() == 0) {
                this.JCBMedioDePago.setSelectedIndex(19);
            } else {
                this.JCBMedioDePago.setSelectedIndex(31);
            }
        }
    }

    private void crearEmpresasMision() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            JDEmpresaMision dEmpresaMision = new JDEmpresaMision(null, true, this, this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getId(), this);
            dEmpresaMision.setLocationRelativeTo(this);
            dEmpresaMision.setVisible(true);
        }
    }

    private void crearCargos() {
        JDcargos jd = new JDcargos(null, true, this.JTFCargo);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    private void llenarInformacionPersona() {
        this.JCBTipoIdentificacion.setSelectedItem(this.persona.getIdTipoIdentificacion().getNombre());
        this.JTFVIdentificacion.setText(this.persona.getNoDocumento());
        this.JTFVApellido1.setText(this.persona.getApellido1());
        this.JTFVApellido2.setText(this.persona.getApellido2());
        this.JTFVNombre1.setText(this.persona.getNombre1());
        this.JTFVNombre2.setText(this.persona.getNombre2());
        this.JDCFechaNacimiento.setDate(this.persona.getFechaNac());
        this.JCBSexo.setSelectedItem(this.persona.getIdSexo().getNbre());
        if (this.persona.getIdEstadoCivil() != null) {
            this.JCBEstadoCivil.setSelectedItem(this.persona.getIdEstadoCivil().getNbre());
        }
        if (this.persona.getGrupoSangre() != null) {
            this.JCBSangre.setSelectedItem(this.persona.getGrupoSangre());
        }
        if (this.persona.getTelefono() != null) {
            this.JTFTelefono.setText(this.persona.getTelefono());
        }
        if (this.persona.getMovil() != null) {
            this.JTFCelular.setText(this.persona.getMovil());
        }
        if (this.persona.getCorreo() != null) {
            this.JTFCorreo.setText(this.persona.getCorreo());
        }
        if (this.persona.getIdMunicipio() != null) {
            this.JCBMunicipio.setSelectedItem(this.persona.getIdMunicipio().getNombre().toUpperCase().concat(" - ").concat(this.persona.getIdMunicipio().getIdDpto().getNbre().toUpperCase()));
        }
        if (this.persona.getDireccion() != null) {
            this.JTFDireccion.setText(this.persona.getDireccion());
        }
        if (this.persona.getDireccion() != null) {
            this.listMunicipioDTOs.stream().filter(m -> {
                return m.getId().equals(this.persona.getIdMunicipioNac());
            }).forEach(e -> {
                this.JCBMunicipioNacimiento.setSelectedItem(e.getNombre().toUpperCase());
            });
        }
        if (this.persona.getIdBarrio() != null) {
            this.JCBBarrio.setSelectedItem(this.persona.getIdBarrio().getNbre());
        }
        if (this.persona.getIdEtnia() != null) {
            this.listTipoEtnia.stream().filter(m2 -> {
                return m2.getId().equals(this.persona.getIdEtnia());
            }).forEach(e2 -> {
                this.JCBEtnia.setSelectedItem(e2.getNbre());
            });
        }
        if (this.persona.getNAfiliacion() != null) {
            this.JTFAfiliacion.setText(this.persona.getNAfiliacion());
        }
    }

    private void buscarPersona() {
        if (this.persona.getNombre1() == null) {
            if (this.JCBTipoIdentificacion.getSelectedIndex() != -1 && !this.JTFVIdentificacion.getText().isEmpty()) {
                Optional<GPersona> personaDato = this.personaService.datosPersonaPorTipoDocumentoNumero(this.listTipoIdentificacionDTO.get(this.JCBTipoIdentificacion.getSelectedIndex()), this.JTFVIdentificacion.getText());
                if (personaDato.isPresent()) {
                    this.persona = personaDato.get();
                    Optional<GUsuario> usuarioDato = this.usuarioService.findById(this.persona);
                    this.usuario = usuarioDato.get();
                    this.usuario.setGPersona(this.persona);
                    llenarInformacionPersona();
                    return;
                }
                this.persona = new GPersona();
                this.usuario = new GUsuario();
                return;
            }
            return;
        }
        llenarInformacionPersona();
    }

    private void buscarProcedimientosCodigo() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            List<IInformacionSuministroProcedimiento> suministroProcedimiento = (List) this.listProcedimientoSuministro.stream().filter(e -> {
                return e.getCodigo().equals(this.JTFCodigo.getText());
            }).collect(Collectors.toList());
            if (suministroProcedimiento.isEmpty()) {
                this.JTFCodigo.setText("");
                this.JCBItems.setSelectedIndex(-1);
                this.JSPCantidad.setValue(1);
                this.JTFVrUnitario.setValue(new Double(0.0d));
                this.JTFVrTotal.setValue(new Double(0.0d));
                this.JTFCodigo.requestFocus();
                return;
            }
            suministroProcedimiento.forEach(e2 -> {
                this.JCBItems.setSelectedItem(e2.getNombre());
            });
        }
    }

    private void calcularValorTotal() {
        if (!this.JTFVrUnitario.getText().isEmpty()) {
            this.JTFVrTotal.setValue(Double.valueOf(Double.valueOf(this.JSPCantidad.getValue().toString()).doubleValue() * Double.valueOf(this.JTFVrUnitario.getValue().toString()).doubleValue()));
        }
    }

    private void llenadoComboEstrato() {
        this.listEstratoxemprcontconvs = new ArrayList();
        this.JCBEstrato.removeAllItems();
        this.listEstratoxemprcontconvs = (List) this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getFEstratoxemprcontconvCollection();
        this.listEstratoxemprcontconvs.stream().filter(estrato -> {
            return estrato.isCopago() == this.filtro.booleanValue();
        }).forEach(e -> {
            this.JCBEstrato.addItem(e.getFEstrato().getNbre());
        });
    }

    private void llenarComboContrato() {
        this.JCBContrato.removeAllItems();
        this.listContratoConvenio = new ArrayList();
        this.listContratoConvenio = (List) this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getGContratosCollection();
        this.utilidadesGenericas.llenarCombo(this.JCBContrato, this.listContratoConvenio);
    }

    public void llenarComboEmpresaMision() {
        this.listEmpresaMision = new ArrayList();
        this.listEmpresaMision = this.empresaEnMisionService.listaEmpresaEnMisionporIdConvenio(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()));
        this.utilidadesGenericas.llenarCombo(this.JCBEmpresaMision, this.listEmpresaMision);
    }

    private void llenarComboDependeciaConvenio() {
        this.JCBEmpresaMision.removeAllItems();
        this.empresaContrato = new GEmpresacont();
        this.listSubgrupoEmpresa = new ArrayList();
        this.listSubgrupoEmpresa = this.subgrupoEmpresaService.listaSubgrupoEmpresaPorIdConvenioOrdenadoPorNombre(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()), true);
        this.utilidadesGenericas.llenarCombo(this.JCBSubgrupo, this.listSubgrupoEmpresa);
        Optional<GEmpresacont> empreOptional = this.empresacontService.findByIdempresa(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getIdEmpresaCont());
        if (empreOptional.isPresent()) {
            this.empresaContrato = empreOptional.get();
        }
        if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getEsCapitado().intValue() == 2) {
            mValidaResolucionDian(true);
        }
        controlBloqueoConvenio();
    }

    private void llenarComboServicio() {
        limpiarControles(this.JPI_Encabezado, false);
        this.JCBServicio.removeAllItems();
        this.listServicio = new ArrayList();
        this.listServicio = (List) this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getFServicioempresaconvCollection().stream().filter(e -> {
            return !e.getEstado().booleanValue();
        }).sorted(Comparator.comparing(e2 -> {
            return e2.getFTiposervicio().getNbre();
        })).map(p -> {
            return p.getFTiposervicio();
        }).collect(Collectors.toList());
        this.utilidadesGenericas.llenarCombo(this.JCBServicio, this.listServicio);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modeloDetalle = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre", "Cantidad", "Vr. Unitario", "Vr. Total", "Finalidad", "idServicio", "idCentroCosto", "idPlan", "porcentajeIva", "IdProcedimiento", "idFinalidad"}) { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil.39
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, String.class, Integer.class, Integer.class, Integer.class, Double.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modeloDetalle);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(60);
    }

    private void inicializar() {
        this.lleno = false;
        this.listEmpresaContConvenioEntity = new ArrayList();
        this.listClaseCitas = new ArrayList();
        this.listTipoIdentificacionDTO = new ArrayList();
        this.listSexo = new ArrayList();
        this.listEstadocivils = new ArrayList();
        this.listMunicipioDTOs = new ArrayList();
        this.listTipoEtnia = new ArrayList();
        this.listTipoafiliados = new ArrayList();
        this.listPoblacionEspecials = new ArrayList();
        this.listTipoatencion = new ArrayList();
        this.listEspecialidad = new ArrayList();
        this.listCentroCosto = new ArrayList();
        this.listCargo = new ArrayList();
        this.listSubgrupoEmpresa = new ArrayList();
        this.listFinProcedimiento = new ArrayList();
        this.listMedioPago = new ArrayList();
        this.listFormaPago = new ArrayList();
        this.listEmpresaContConvenioEntity = this.empresaContConvenioService.listarConveniosPorEstado(false);
        this.listClaseCitas = this.claseCitaService.listaClaseCitaPorEstadoOrderPorNombreAsc(false);
        this.listTipoIdentificacionDTO = this.identificacionService.listaTipoIdentificacionPorEstado(false);
        this.listSexo = this.sexoService.listaSexoOrdenadoNombreAsc();
        this.listEstadocivils = this.estadocivilService.listaOrdenadoPorNombre();
        this.listMunicipioDTOs = this.municipioService.listaMunicipioConcatenadoDepartamentoEstado(false);
        this.listTipoEtnia = this.tipoEtniaService.listaEtniaOrdenadaPorNombre();
        this.listTipoafiliados = this.tipoafiliadoService.findAll();
        this.listPoblacionEspecials = this.poblacionEspecialService.listaOrdenadaPorNombres();
        this.listTipoatencion = this.tipoatencionService.findAll();
        new ArrayList();
        List<GEspecialidad> listEspecialidadTmp = this.especialidadService.listarEspecialidadesPorEstado(false);
        this.listEspecialidad = (List) listEspecialidadTmp.stream().filter(e -> {
            return !e.getGProfesionalespecialCollection().isEmpty();
        }).collect(Collectors.toList());
        this.listNivelEstudio = this.nivelestudioService.listarTodosLosNivelesDeEstudio();
        this.listCentroCosto = this.centrocostoService.listarTodosLosFCentrocosto();
        this.listFinProcedimiento = this.tipofinprocedimientoService.listarFinProcedimiento();
        this.listCargo = this.cargosService.listCargoOrdenadoPorNombreAsc();
        this.listFormaPago = this.formapagoService.listaFormaPagoFiltroEstadoOrderNombre(true);
        this.listMedioPago = this.medioPagoService.listaMedioPagoFiltroEstados(true);
        this.utilidadesGenericas.llenarCombo(this.JCBMedioDePago, this.listMedioPago);
        this.utilidadesGenericas.llenarCombo(this.JCBFPago, this.listFormaPago);
        this.utilidadesGenericas.llenarCombo(this.JCBEmpresa, this.listEmpresaContConvenioEntity);
        this.utilidadesGenericas.llenarCombo(this.JCBTipoExamen, this.listClaseCitas);
        this.utilidadesGenericas.llenarCombo(this.JCBTipoIdentificacion, this.listTipoIdentificacionDTO);
        this.utilidadesGenericas.llenarCombo(this.JCBSexo, this.listSexo);
        this.utilidadesGenericas.llenarCombo(this.JCBEstadoCivil, this.listEstadocivils);
        this.utilidadesGenericas.llenarCombo(this.JCBMunicipio, this.listMunicipioDTOs);
        this.utilidadesGenericas.llenarCombo(this.JCBMunicipioNacimiento, this.listMunicipioDTOs);
        this.utilidadesGenericas.llenarCombo(this.JCBEtnia, this.listTipoEtnia);
        this.utilidadesGenericas.llenarCombo(this.JCBTipoAfiliado, this.listTipoafiliados);
        this.utilidadesGenericas.llenarCombo(this.JCBPobEspecial, this.listPoblacionEspecials);
        this.utilidadesGenericas.llenarCombo(this.JCBTipoAtencion, this.listTipoatencion);
        this.utilidadesGenericas.llenarCombo(this.JCBEspecialidad, this.listEspecialidad);
        this.utilidadesGenericas.llenarCombo(this.JCBNivelEstudio, this.listNivelEstudio);
        this.utilidadesGenericas.llenarCombo(this.JCBCentroCosto, this.listCentroCosto);
        this.utilidadesGenericas.llenarCombo(this.JCBFinProcedimiento, this.listFinProcedimiento);
        this.lleno = true;
    }

    public final void nuevo() {
        this.ingresoAgil = new IngresoAgil();
        this.filtro = false;
        this.validacion = false;
        controlBloqueoConvenio();
        this.persona = new GPersona();
        this.usuario = new GUsuario();
        this.numeroOrdenFact = "";
        limpiarControles(this.JPI_DatosInfoExamen, false);
        limpiarControles(this.JPDPersonales, false);
        limpiarControles(this.JPIIngreso, false);
        limpiarControles(this.JPIGrupoSangre, false);
        limpiarControles(this.JPI_DatosFactura, false);
        this.JCHCModeradora.setSelected(true);
        crearModeloDatos();
        this.JTP_Datos.setSelectedIndex(0);
        this.listOrden = new ArrayList();
        this.JCBEmpresa.requestFocus();
    }

    public final void buscar() {
        if (this.usuario.getId() != null) {
            BuscarIngresoAgil buscarIngresoAgil = new BuscarIngresoAgil(null, true, this, this.usuario);
            buscarIngresoAgil.setLocationRelativeTo(this);
            buscarIngresoAgil.setVisible(true);
        }
    }

    public final void imprimir() {
        if (!this.JLB_NOrdenFactura.getText().isEmpty()) {
            imprimirFacturaOrden(this.ingresoAgil);
        }
    }

    private void controlBloqueoConvenio() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getBloquear().booleanValue()) {
                this.JLBEstadoBloqueo.setBackground(Color.RED);
                this.JLBEstadoBloqueo.setForeground(Color.WHITE);
                this.JLBEstadoBloqueo.setText("BLOQUEADA");
                return;
            } else {
                this.JLBEstadoBloqueo.setBackground(new Color(0, 153, 51));
                this.JLBEstadoBloqueo.setForeground(Color.BLACK);
                this.JLBEstadoBloqueo.setText("ACTIVO");
                return;
            }
        }
        this.JLBEstadoBloqueo.setBackground(new Color(0, 153, 51));
        this.JLBEstadoBloqueo.setForeground(Color.BLACK);
        this.JLBEstadoBloqueo.setText("ACTIVO");
    }

    private void limpiarControles(JPanel jpanel, boolean forma) {
        this.validacion = false;
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            switch (jpanel.getComponent(i).getClass().toString()) {
                case "class javax.swing.JTextField":
                    jpanel.getComponent(i).setText("");
                    break;
                case "class javax.swing.JSpinner":
                    JSpinner dato = jpanel.getComponent(i);
                    if (dato.getName() != null && dato.getName().equals("NoHijos")) {
                        dato.setValue(0);
                        break;
                    } else {
                        dato.setValue(1);
                        break;
                    }
                    break;
                case "class javax.swing.JFormattedTextField":
                    JFormattedTextField dato2 = jpanel.getComponent(i);
                    if (dato2.getName().equals("hora")) {
                        dato2.setValue(this.metodos.getFechaActual());
                        break;
                    } else {
                        if (dato2.getName().equals("autorizacion")) {
                            dato2.setValue("");
                        } else {
                            dato2.setValue(new Double(0.0d));
                        }
                        break;
                    }
                    break;
                case "class javax.swing.Label":
                    JLabel dato3 = jpanel.getComponent(i);
                    if (dato3.getName() != null && dato3.getName().equals("idIngreso")) {
                        dato3.setText("");
                        break;
                    } else {
                        break;
                    }
                    break;
                case "class com.toedter.calendar.JDateChooser":
                    jpanel.getComponent(i).setDate(this.metodos.getFechaActual());
                    break;
                case "class Utilidades.JTextFieldValidator":
                    jpanel.getComponent(i).setText("");
                    break;
                case "class javax.swing.JComboBox":
                    JComboBox dato4 = jpanel.getComponent(i);
                    if (dato4.getName().equals("servicio") || dato4.getName().equals("centroCosto") || dato4.getName().equals("tipoAtencion") || dato4.getName().equals("tipoEtnia") || dato4.getName().equals("tipoPoblacionEspecial") || dato4.getName().equals("tipoAfiliado")) {
                        if (dato4.getName().equals("tipoEtnia")) {
                            dato4.setSelectedIndex(2);
                        }
                        if (dato4.getName().equals("tipoPoblacionEspecial")) {
                            dato4.setSelectedIndex(22);
                        }
                        if (dato4.getName().equals("tipoAfiliado") || dato4.getName().equals("tipoSangre") || dato4.getName().equals("tipoAtencion") || dato4.getName().equals("forma_pago")) {
                            dato4.setSelectedIndex(0);
                        }
                        break;
                    } else {
                        dato4.setSelectedIndex(-1);
                        break;
                    }
                    break;
            }
        }
    }

    private Boolean metodoValidacion(JPanel jpanel, int index) {
        this.validacion = false;
        System.out.println("" + jpanel.getName());
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            switch (jpanel.getComponent(i).getClass().toString()) {
                case "class javax.swing.JTextField":
                    jpanel.getComponent(i);
                    break;
                case "class javax.swing.JSpinner":
                    jpanel.getComponent(i);
                    break;
                case "class javax.swing.JFormattedTextField":
                    JFormattedTextField dato = jpanel.getComponent(i);
                    if (dato.getName() != null && dato.getText().isEmpty()) {
                        this.validacion = true;
                        JOptionPane.showInternalMessageDialog(this, "Campo no puede ser nulo : " + dato.getName().toUpperCase(), "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTP_Datos.setSelectedIndex(index);
                        dato.requestFocus();
                        break;
                    }
                    break;
                case "class com.toedter.calendar.JDateChooser":
                    jpanel.getComponent(i);
                    break;
                case "class Utilidades.JTextFieldValidator":
                    JTextFieldValidator dato2 = jpanel.getComponent(i);
                    if (dato2.getName() != null && dato2.getText().isEmpty()) {
                        this.validacion = true;
                        JOptionPane.showInternalMessageDialog(this, "Campo no puede ser nulo : " + dato2.getName().toUpperCase(), "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTP_Datos.setSelectedIndex(index);
                        dato2.requestFocus();
                        break;
                    }
                    break;
                case "class javax.swing.JComboBox":
                    JComboBox dato3 = jpanel.getComponent(i);
                    if (dato3.getSelectedIndex() == -1) {
                        this.validacion = true;
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items del combo : " + dato3.getName().toUpperCase(), "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTP_Datos.setSelectedIndex(index);
                        dato3.requestFocus();
                        break;
                    }
                    break;
            }
            if (this.validacion) {
                return Boolean.valueOf(this.validacion);
            }
        }
        return Boolean.valueOf(this.validacion);
    }

    private boolean validacionControles() {
        this.validacion = false;
        for (int i = 0; i < this.JPI_Datos.getComponentCount(); i++) {
            if (this.JPI_Datos.getComponent(i).getClass().toString().equals("class javax.swing.JPanel")) {
                JPanel jpanel = (JPanel) this.JPI_Datos.getComponent(i);
                for (int j = 0; j < jpanel.getComponentCount(); j++) {
                    System.out.println("" + jpanel.getComponent(j).getClass());
                    this.validacion = metodoValidacion(jpanel, 0).booleanValue();
                    if (this.validacion) {
                        break;
                    }
                }
                if (this.validacion) {
                    break;
                }
            }
        }
        if (!this.validacion) {
            for (int i2 = 0; i2 < this.JPI_DatosFactura.getComponentCount(); i2++) {
                System.out.println("" + this.JPI_DatosFactura.getComponent(i2).getClass());
                this.validacion = metodoValidacion(this.JPI_DatosFactura, 1).booleanValue();
                if (this.validacion) {
                    break;
                }
            }
        }
        return this.validacion;
    }

    private void addItems() {
        if (this.JCBProfesional.getSelectedIndex() != -1) {
            if (!this.JTFCodigo.getText().isEmpty()) {
                if (this.JCBItems.getSelectedIndex() != -1) {
                    this.modeloDetalle.addRow((Object[]) null);
                    this.modeloDetalle.setValueAt(this.JTFCodigo.getText(), this.JTBDetalle.getRowCount() - 1, 0);
                    this.modeloDetalle.setValueAt(this.JCBItems.getSelectedItem(), this.JTBDetalle.getRowCount() - 1, 1);
                    this.modeloDetalle.setValueAt(this.JSPCantidad.getValue(), this.JTBDetalle.getRowCount() - 1, 2);
                    this.modeloDetalle.setValueAt(this.JTFVrUnitario.getValue(), this.JTBDetalle.getRowCount() - 1, 3);
                    this.modeloDetalle.setValueAt(this.JTFVrTotal.getValue(), this.JTBDetalle.getRowCount() - 1, 4);
                    this.modeloDetalle.setValueAt(this.JCBFinProcedimiento.getSelectedItem(), this.JTBDetalle.getRowCount() - 1, 5);
                    this.modeloDetalle.setValueAt(this.listServicio.get(this.JCBServicio.getSelectedIndex()).getId(), this.JTBDetalle.getRowCount() - 1, 6);
                    this.modeloDetalle.setValueAt(this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex()).getId(), this.JTBDetalle.getRowCount() - 1, 7);
                    this.modeloDetalle.setValueAt(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getIdPlan(), this.JTBDetalle.getRowCount() - 1, 8);
                    this.modeloDetalle.setValueAt(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getPorcentajeImpuesto(), this.JTBDetalle.getRowCount() - 1, 9);
                    this.modeloDetalle.setValueAt(this.listProcedimientoSuministro.get(this.JCBItems.getSelectedIndex()).getId(), this.JTBDetalle.getRowCount() - 1, 10);
                    this.modeloDetalle.setValueAt(this.listFinProcedimiento.get(this.JCBFinProcedimiento.getSelectedIndex()).getId(), this.JTBDetalle.getRowCount() - 1, 11);
                    this.listOrden.add(getOrden());
                    limpiarControles(this.JPI_Encabezado, false);
                    calcularValores();
                    this.JTFCodigo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBItems.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Codigo no puede estar vacio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFCodigo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTP_Datos.setSelectedIndex(0);
        this.JCBProfesional.requestFocus();
    }

    private void calcularValores() {
        Double valorTotal = new Double(0.0d);
        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
            valorTotal = Double.valueOf(valorTotal.doubleValue() + Double.valueOf(this.JTBDetalle.getValueAt(i, 4).toString()).doubleValue());
        }
        this.JTFVSubtotal.setValue(valorTotal);
        if (!this.JTFVDescuento.getText().isEmpty()) {
            this.JTFVTotal.setValue(Double.valueOf(valorTotal.doubleValue() - Double.valueOf(this.JTFVDescuento.getValue().toString()).doubleValue()));
        }
    }

    public void grabar() {
        if (!validacionControles()) {
            if (!this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getBloquear().booleanValue()) {
                if (this.JCBSangre.getSelectedIndex() != -1) {
                    if (this.JTBDetalle.getRowCount() > 0) {
                        GEmpresa empresa = new GEmpresa();
                        empresa.setId(new Long(1L));
                        GCargos cargo = new GCargos();
                        cargo.setId(1);
                        GEmpresacont empresacont = new GEmpresacont();
                        empresacont.setId(Integer.valueOf(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getIdEmpresaCont().getId().intValue()));
                        GSoJornada soJornada = new GSoJornada();
                        soJornada.setId(1);
                        GSoLateralidad soLateralidad = new GSoLateralidad();
                        soLateralidad.setId(1);
                        SoTipoSegmento tipoSegmento = new SoTipoSegmento();
                        tipoSegmento.setId(1);
                        SoTipoGrupo tipoGrupo = new SoTipoGrupo();
                        tipoGrupo.setId(1);
                        GTipoedad tipoedad = new GTipoedad();
                        tipoedad.setId(1);
                        this.persona.setActivoSo(true);
                        this.persona.setApellido1(this.JTFVApellido1.getText());
                        this.persona.setApellido2(this.JTFVApellido2.getText());
                        this.persona.setCodigo1Sap(new Double(0.0d));
                        this.persona.setCorreo(this.JTFCorreo.getText());
                        this.persona.setDireccion(this.JTFDireccion.getText());
                        this.persona.setEdad(Integer.valueOf(this.edad));
                        this.persona.setFEPeriodico((Date) null);
                        this.persona.setFecha(this.metodos.getFechaActual());
                        this.persona.setFechaNac(this.JDCFechaNacimiento.getDate());
                        this.persona.setGrupoSangre(this.JCBSangre.getSelectedItem().toString());
                        this.persona.setIdBarrio(this.listBarrioEntitys.get(this.JCBBarrio.getSelectedIndex()));
                        this.persona.setIdEstadoCivil(this.listEstadocivils.get(this.JCBEstadoCivil.getSelectedIndex()));
                        this.persona.setIdEtnia(this.listTipoEtnia.get(this.JCBEtnia.getSelectedIndex()).getId());
                        this.persona.setIdMunicipio(this.listMunicipioDTOs.get(this.JCBMunicipio.getSelectedIndex()));
                        this.persona.setIdMunicipioNac(this.listMunicipioDTOs.get(this.JCBMunicipioNacimiento.getSelectedIndex()).getId());
                        this.persona.setIdSexo(this.listSexo.get(this.JCBSexo.getSelectedIndex()));
                        this.persona.setIdTipoEdad(tipoedad);
                        this.persona.setIdTipoIdentificacion(this.listTipoIdentificacionDTO.get(this.JCBTipoIdentificacion.getSelectedIndex()));
                        this.persona.setMovil(this.JTFCelular.getText());
                        this.persona.setNAfiliacion(this.JTFAfiliacion.getText());
                        this.persona.setNoDocumento(this.JTFVIdentificacion.getText());
                        this.persona.setNombre1(this.JTFVNombre1.getText());
                        this.persona.setNombre2(this.JTFVNombre2.getText());
                        if (this.JCHNegativo.isSelected()) {
                            this.persona.setRh(false);
                        }
                        if (this.JCHPositivo.isSelected()) {
                            this.persona.setRh(true);
                        }
                        this.persona.setTelefono(this.JTFTelefono.getText());
                        this.persona.setTipoPersona(false);
                        this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.usuario.setCSEconomica(Integer.valueOf(this.JSPNClaSE.getValue().toString()));
                        this.usuario.setDetalleAnulacion((String) null);
                        this.usuario.setEmail(this.JTFCorreo.getText());
                        this.usuario.setEsFpz(false);
                        this.usuario.setEstado(false);
                        this.usuario.setEtnia(this.JCBEtnia.getSelectedItem().toString());
                        this.usuario.setFecha(this.metodos.getFechaActual());
                        this.usuario.setFechaDA((Date) null);
                        this.usuario.setFechaIngreso(this.JDCFecha.getDate());
                        this.usuario.setGPersona(this.persona);
                        this.usuario.setHorasTrabajadas(1);
                        this.usuario.setIdArl(empresa);
                        this.usuario.setIdCargo(cargo);
                        this.usuario.setIdEmpresaCont(this.empresaContrato);
                        this.usuario.setIdHorario(soJornada);
                        this.usuario.setIdLateralidad(soLateralidad);
                        this.usuario.setIdOcupacion("6");
                        this.usuario.setIdPoblacionEspecial(this.listPoblacionEspecials.get(this.JCBPobEspecial.getSelectedIndex()));
                        this.usuario.setIdSegmento(tipoSegmento);
                        this.usuario.setIdSupervisor(new Long(1L));
                        this.usuario.setIdTipoAfiliado(this.listTipoafiliados.get(this.JCBTipoAfiliado.getSelectedIndex()));
                        this.usuario.setIdTipoGrupo(tipoGrupo);
                        this.usuario.setNAfiliacion(this.JTFAfiliacion.getText());
                        this.usuario.setNEducativo((String) null);
                        this.usuario.setNHijo(Integer.valueOf(this.JSPNHijos.getValue().toString()));
                        this.usuario.setNoHistoria(this.JTFVIdentificacion.getText());
                        this.usuario.setOcupacion((String) null);
                        this.usuario.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        GOrigenadmision origenadmision = new GOrigenadmision();
                        origenadmision.setId(1);
                        GCausaexterna causaexterna = new GCausaexterna();
                        causaexterna.setId("15");
                        GParentesco parentesco = new GParentesco();
                        parentesco.setId(1);
                        GTipoafiliado tipoafiliado = new GTipoafiliado();
                        tipoafiliado.setId(8);
                        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
                        tipoContratacionDTO.setId(1);
                        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
                        tipoCoberturaPlanDTO.setId(5);
                        this.ingreso = new Ingreso();
                        this.ingreso.setIdUsuario(this.persona);
                        this.ingreso.setFechaIngreso(this.JDCFecha.getDate());
                        this.ingreso.setHoraIngreso(this.utilidadesGenericas.getUnirFechaHora(this.metodos.formatoAMD.format(this.JDCFecha.getDate()), this.JTFFHora.getText()));
                        this.ingreso.setIdEmpresaContxConv(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()));
                        this.ingreso.setEsCapitado(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getEsCapitado());
                        this.ingreso.setIdSede(Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().intValue()));
                        if (this.JCHCModeradora.isSelected()) {
                            this.ingreso.setSiCopago(false);
                        }
                        if (this.JCHCopago.isSelected()) {
                            this.ingreso.setSiCopago(false);
                        }
                        this.ingreso.setIdEstrato(this.listEstratoxemprcontconvs.get(this.JCBEstrato.getSelectedIndex()).getFEstrato());
                        this.ingreso.setIdOrigenAdmision(origenadmision);
                        this.ingreso.setIdCausaExterna(causaexterna);
                        this.ingreso.setIdEspecialidad(this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()));
                        this.ingreso.setIdProfesional(this.listProfesionales.get(this.JCBProfesional.getSelectedIndex()).getGPersona().getId().intValue());
                        this.ingreso.setIdTipoAtencion(this.listTipoatencion.get(this.JCBTipoAtencion.getSelectedIndex()));
                        this.ingreso.setIdContrato(this.listContratoConvenio.get(this.JCBContrato.getSelectedIndex()).getId());
                        this.ingreso.setNoAutorizacion(this.JTFNoAutorizacion.getText());
                        this.ingreso.setEstado(false);
                        this.ingreso.setEsAtencion(true);
                        this.ingreso.setNAcompanante("NO APLICA");
                        this.ingreso.setIdNivelEstudio(this.listNivelEstudio.get(this.JCBNivelEstudio.getSelectedIndex()).getId());
                        this.ingreso.setIdParentesco(parentesco);
                        this.ingreso.setIdOcupacion("9998");
                        this.ingreso.setSOCargo(this.JTFCargo.getText());
                        this.ingreso.setSOArl(this.JTFArl.getText());
                        this.ingreso.setNoHijos(Integer.valueOf(this.JSPNHijos.getValue().toString()));
                        this.ingreso.setClaseSE(Integer.valueOf(this.JSPNClaSE.getValue().toString()));
                        this.ingreso.setObservacion(this.JTAObservacion.getText());
                        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
                        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
                        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
                        this.ingreso.setFecha(this.metodos.getFechaActual());
                        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.atencion = new HAtencion();
                        this.atencion.setIdIngreso(this.ingreso);
                        this.atencion.setIdClaseCita(this.listClaseCitas.get(this.JCBTipoExamen.getSelectedIndex()));
                        this.atencion.setFechaAtencion(this.JDCFecha.getDate());
                        this.atencion.setHoraAtencion(this.utilidadesGenericas.getUnirFechaHora(this.metodos.formatoAMD.format(this.JDCFecha.getDate()), this.JTFFHora.getText()));
                        this.atencion.setMotivoAtencion(this.JCBTipoExamen.getSelectedItem().toString());
                        this.atencion.setIdProfesional(this.listProfesionales.get(this.JCBProfesional.getSelectedIndex()));
                        this.atencion.setIdEspecialidad(this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()));
                        this.atencion.setIdTipoDx(1);
                        this.atencion.setTipoGuardado(0);
                        this.atencion.setIp1(false);
                        this.atencion.setIp2(false);
                        this.atencion.setIp3(false);
                        this.atencion.setIp4(false);
                        this.atencion.setIp5(false);
                        this.atencion.setIp6(false);
                        this.atencion.setInicioAtencion(false);
                        this.atencion.setHospitalizado(false);
                        this.atencion.setAdherido(false);
                        this.atencion.setCodigoDxp("");
                        this.atencion.setCodigoDxR1("");
                        this.atencion.setCodigoDxR2("");
                        this.atencion.setCodigoDxR3("");
                        this.atencion.setConclusion("");
                        this.atencion.setEstado(false);
                        this.atencion.setFecha(this.metodos.getFechaActual());
                        this.atencion.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.soDatosOcupacionales = new HSoDatosOcupacionales();
                        this.soDatosOcupacionales.setArp(this.JTFArl.getText());
                        this.soDatosOcupacionales.setCargo(this.JTFCargo.getText());
                        this.soDatosOcupacionales.setEmpresaMision(this.JCBEmpresaMision.getSelectedItem().toString());
                        this.soDatosOcupacionales.setEps(this.JTFEps.getText());
                        this.soDatosOcupacionales.setEstado(true);
                        this.soDatosOcupacionales.setFecha(this.metodos.getFechaActual());
                        this.soDatosOcupacionales.setIdAtencion(this.atencion);
                        this.soDatosOcupacionales.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.ingresoAgil.setUsuario(this.usuario);
                        this.ingresoAgil.setPersona(this.persona);
                        this.ingresoAgil.setAtencion(this.atencion);
                        this.ingresoAgil.setDatosOcupacionales(this.soDatosOcupacionales);
                        List<FOrdenes> listOrdene = new ArrayList<>();
                        Integer idServicio = 0;
                        for (FOrdenes fOrdenes : this.listOrden) {
                            if (!Objects.equals(idServicio, fOrdenes.getIdTipoServicio().getId())) {
                                listOrdene.add(fOrdenes);
                                idServicio = fOrdenes.getIdTipoServicio().getId();
                            }
                        }
                        List<FOrdenes> listOrdeneI = new ArrayList<>();
                        listOrdene.stream().map(fOrdenes2 -> {
                            List<FItemordenesproced> listItems = new ArrayList<>();
                            for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
                                if (fOrdenes2.getIdTipoServicio().getId().equals(Integer.valueOf(this.JTBDetalle.getValueAt(i, 6).toString()))) {
                                    listItems.add(getItems(fOrdenes2, i));
                                }
                            }
                            fOrdenes2.setIdIngreso(this.ingreso);
                            fOrdenes2.setFItemordenesprocedCollection(listItems);
                            return fOrdenes2;
                        }).forEachOrdered(fOrdenes3 -> {
                            listOrdeneI.add(fOrdenes3);
                        });
                        listOrdeneI.forEach(fOrdenes4 -> {
                            this.totalOrden = new Double(0.0d);
                            this.totalEps = new Double(0.0d);
                            this.totalDescuento = new Double(0.0d);
                            this.totalPaciente = new Double(0.0d);
                            fOrdenes4.getFItemordenesprocedCollection().forEach(p -> {
                                this.totalOrden = Double.valueOf(this.totalOrden.doubleValue() + (p.getValorUnitario() * p.getCantidad().doubleValue()));
                                this.totalDescuento = Double.valueOf(this.totalDescuento.doubleValue() + (p.getValorDescuento() * p.getCantidad().doubleValue()));
                                if (this.ingreso.getIdEmpresaContxConv().getIdTipoPlan().getId() == p.getPlan()) {
                                    this.totalEps = Double.valueOf(this.totalEps.doubleValue() + (p.getValorUnitario() * p.getCantidad().doubleValue()));
                                } else {
                                    this.totalPaciente = Double.valueOf(this.totalPaciente.doubleValue() + (p.getValorUnitario() * p.getCantidad().doubleValue()));
                                }
                            });
                            fOrdenes4.setTotalOrdenes(this.totalOrden);
                            fOrdenes4.setTotalEPS(this.totalEps);
                            fOrdenes4.setTotalPaciente(this.totalPaciente);
                            fOrdenes4.setTotalDescuento(this.totalDescuento);
                        });
                        this.liquidacionEntity = new LiquidacionEntity();
                        this.liquidacionEntity.setCopago(new Double(0.0d).doubleValue());
                        this.liquidacionEntity.setCuotaModeradora(new Double(0.0d).doubleValue());
                        this.liquidacionEntity.setDireccionIp(Principal.getLocalHost().getHostAddress());
                        this.liquidacionEntity.setEstado(false);
                        this.liquidacionEntity.setFecha(this.metodos.getFechaActual());
                        this.liquidacionEntity.setIdEmpresaContxConv(this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getId());
                        this.liquidacionEntity.setIdFormaPago(this.listFormaPago.get(this.JCBFPago.getSelectedIndex()).getId());
                        this.liquidacionEntity.setIdSubGrupoServicio(this.listSubgrupoEmpresa.get(this.JCBSubgrupo.getSelectedIndex()));
                        this.liquidacionEntity.setIdMotivoAnulacion(1);
                        this.liquidacionEntity.setIdUsuarioRH(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().intValue()));
                        this.liquidacionEntity.setNEquipo(Principal.getLocalHost().getHostName());
                        this.liquidacionEntity.setNFolios(0);
                        this.liquidacionEntity.setObservacion(this.JTAObservacionFac.getText());
                        this.liquidacionEntity.setObservacionAnulacion("");
                        this.liquidacionEntity.setTGlosa(new Double(0.0d));
                        this.liquidacionEntity.setTPagado(new Double(0.0d));
                        this.liquidacionEntity.setTotalServicio(Double.valueOf(this.JTFVSubtotal.getValue().toString()).doubleValue());
                        this.liquidacionEntity.setTotalDescuento(Double.valueOf(this.JTFVDescuento.getValue().toString()).doubleValue());
                        if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getIdTipoPlan().getId().intValue() == 4) {
                            this.liquidacionEntity.setTotalEps(new Double(0.0d).doubleValue());
                            this.liquidacionEntity.setTotalPlan(new Double(0.0d).doubleValue());
                            this.liquidacionEntity.setTotalPaciente(Double.valueOf(this.JTFVTotal.getValue().toString()).doubleValue());
                        } else {
                            this.liquidacionEntity.setTotalEps(Double.valueOf(this.JTFVTotal.getValue().toString()).doubleValue());
                            this.liquidacionEntity.setTotalPlan(Double.valueOf(this.JTFVTotal.getValue().toString()).doubleValue());
                            this.liquidacionEntity.setTotalPaciente(new Double(0.0d).doubleValue());
                        }
                        this.liquidacionEntity.setUsuarioAnulacion("");
                        this.liquidacionEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.liquidacionEntity.setVGlosaNR(new Double(0.0d));
                        this.liquidacionEntity.setVGlosaR(new Double(0.0d));
                        List<FFacturaEvento> eventos = new ArrayList<>();
                        List<FFacturaCapita> capitas = new ArrayList<>();
                        if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getEsCapitado().intValue() == 2) {
                            ResolucionDianDTO resolucionDianDTO = new ResolucionDianDTO();
                            resolucionDianDTO.setId(this.resolucionDian.getId());
                            GEtapaProceso etapaProceso = new GEtapaProceso();
                            etapaProceso.setId("0");
                            this.facturaEvento = new FFacturaEvento();
                            this.facturaEvento.setFechaFacturaevento(this.metodos.getFechaActual());
                            this.facturaEvento.setIdLiquidacion(this.liquidacionEntity);
                            this.facturaEvento.setIdResolucionDian(resolucionDianDTO);
                            this.facturaEvento.setEstado(0);
                            this.facturaEvento.setTipoFactura(0);
                            this.facturaEvento.setIdMedioPago(this.listMedioPago.get(this.JCBMedioDePago.getSelectedIndex()).getId());
                            this.facturaEvento.setIdMotivoanulacion(0);
                            this.facturaEvento.setMotivoAnulacion("");
                            this.facturaEvento.setUsuarioAnulacion("");
                            this.facturaEvento.setEstaArmada(0);
                            this.facturaEvento.setNoCuentacobro(new Long(0L));
                            this.facturaEvento.setIdDocumentoc(new Long(0L));
                            this.facturaEvento.setNRadicado("");
                            this.facturaEvento.setUrlRadicado("");
                            this.facturaEvento.setSede(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
                            this.facturaEvento.setIndicador("I");
                            this.facturaEvento.setCJuridico(0);
                            this.facturaEvento.setIdEtapaProcedo(etapaProceso);
                            this.facturaEvento.setIdDocumentocr(new Long(0L));
                            this.facturaEvento.setRDian(this.resolucionDian.getDescripcion());
                            this.facturaEvento.setDireccionIp(Principal.getLocalHost().getHostAddress());
                            this.facturaEvento.setNEquipo(Principal.getLocalHost().getHostName());
                            this.facturaEvento.setFecha(this.metodos.getFechaActual());
                            this.facturaEvento.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            eventos.add(this.facturaEvento);
                        } else {
                            this.facturaCapita = new FFacturaCapita();
                            this.facturaCapita.setFechaFacturacapita(this.metodos.getFechaActual());
                            this.facturaCapita.setIdLiquidacion(this.liquidacionEntity);
                            this.facturaCapita.setEstado(0);
                            this.facturaCapita.setTipoFactura(0);
                            this.facturaCapita.setIdMotivoanulacion(0);
                            this.facturaCapita.setMotivoAnulacion("");
                            this.facturaCapita.setUsuarioAnulacion("");
                            this.facturaCapita.setEstaArmada(0);
                            this.facturaCapita.setNoFacturaevento(0);
                            this.facturaCapita.setFecha(this.metodos.getFechaActual());
                            this.facturaCapita.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            capitas.add(this.facturaCapita);
                        }
                        this.liquidacionEntity.setFFacturaCapitaCollection(capitas);
                        this.liquidacionEntity.setFFacturaEventoCollection(eventos);
                        this.ingresoAgil.setLiquidacion(this.liquidacionEntity);
                        new IngresoAgil();
                        IngresoAgil nuevoIngreso = this.ingresoService.crearIngresoAgil(this.ingresoAgil);
                        this.numeroOrdenFact = "";
                        if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getEsCapitado().intValue() == 2) {
                            nuevoIngreso.getLiquidacion().getFFacturaEventoCollection().stream().forEach(f -> {
                                this.numeroOrdenFact = f.getPrefijo() + "" + f.getNoFacturaeventoM();
                            });
                        } else {
                            nuevoIngreso.getLiquidacion().getFFacturaCapitaCollection().stream().forEach(e -> {
                                this.numeroOrdenFact = e.getId().toString();
                            });
                        }
                        this.JLB_NOrdenFactura.setText(this.numeroOrdenFact);
                        if (this.listEmpresaContConvenioEntity.get(this.JCBEmpresa.getSelectedIndex()).getEsCapitado().intValue() == 2) {
                            imprimirFacturaOrden(nuevoIngreso);
                        }
                        this.JTP_Datos.setSelectedIndex(0);
                        this.ingresoAgil = nuevoIngreso;
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe agregar un registro a facturar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTP_Datos.setSelectedIndex(1);
                    this.JCBServicio.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Convenio bloqueado por la institucion;\nNo es posible ingresar!!", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de sangre", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTP_Datos.setSelectedIndex(0);
            this.JCBSangre.requestFocus();
        }
    }

    private void imprimirFacturaOrden(IngresoAgil nuevoIngreso) {
        ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
        impresionInformes.visualizarFacturasEventoMetodoPrinicpal(this.JLB_Ingreso.getText(), String.valueOf(nuevoIngreso.getLiquidacion().getTotalServicio()), String.valueOf(nuevoIngreso.getLiquidacion().getTotalPlan()), String.valueOf(nuevoIngreso.getLiquidacion().getTotalDescuento()), String.valueOf(nuevoIngreso.getLiquidacion().getCuotaModeradora() + nuevoIngreso.getLiquidacion().getCopago()), String.valueOf(nuevoIngreso.getLiquidacion().getTotalPaciente()), String.valueOf(nuevoIngreso.getLiquidacion().getTotalEps()), 1, 0);
    }

    private void mValidaResolucionDian(Boolean validar) {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0) {
            this.resolucionDian = lis.get(0);
            if (validar.booleanValue()) {
                this.metodos.mResolucionDian(lis.get(0));
            }
        }
    }

    private FOrdenes getOrden() {
        FOrdenes orden = new FOrdenes();
        orden.setEsPrioritaria(false);
        orden.setIdTipoServicio(this.listServicio.get(this.JCBServicio.getSelectedIndex()));
        orden.setFechaOrden(this.JDCFecha.getDate());
        orden.setHoraOrden(this.utilidadesGenericas.getUnirFechaHora(this.metodos.formatoAMD.format(this.JDCFecha.getDate()), this.JTFFHora.getText()));
        orden.setIdProfesional(this.listProfesionales.get(this.JCBProfesional.getSelectedIndex()));
        orden.setIdEspecialidad(this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()));
        orden.setIdCentroCosto(this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex()));
        orden.setEstado(false);
        orden.setEstadoRecep(1);
        orden.setIdOrdenRecep(BigInteger.ZERO);
        orden.setLProcesamiento(0);
        orden.setFecha(this.metodos.getFechaActual());
        orden.setUsuarioA(Principal.usuarioSistemaDTO.getLogin());
        orden.setIdMotivoAnulacion(1);
        return orden;
    }

    private FItemordenesproced getItems(FOrdenes ordene, int pos) {
        FCentrocosto centrocosto = new FCentrocosto();
        centrocosto.setId(Integer.valueOf(this.JTBDetalle.getValueAt(pos, 7).toString()));
        GProcedimiento procedimiento = new GProcedimiento();
        procedimiento.setId(Long.valueOf(this.JTBDetalle.getValueAt(pos, 10).toString()));
        FTipofinprocedimiento tipofinprocedimiento = new FTipofinprocedimiento();
        tipofinprocedimiento.setId(this.JTBDetalle.getValueAt(pos, 11).toString());
        FItemordenesproced itemordenesproced = new FItemordenesproced();
        itemordenesproced.setCantidad(Double.valueOf(this.JTBDetalle.getValueAt(pos, 2).toString()));
        itemordenesproced.setFOrdenes(ordene);
        itemordenesproced.setEsCobrable(true);
        itemordenesproced.setEsRecepcionado(false);
        itemordenesproced.setFecha(this.metodos.getFechaActual());
        itemordenesproced.setGProcedimiento(procedimiento);
        itemordenesproced.setIdCentroCosto(centrocosto);
        itemordenesproced.setIdResultadoLab(0);
        itemordenesproced.setCodigoEncabezadoOrdenBs1("");
        itemordenesproced.setCodigoEnvioBs1("");
        itemordenesproced.setNAutorizacion(this.JTFNoAutorizacion.getText());
        itemordenesproced.setIdTipofinProc(tipofinprocedimiento);
        itemordenesproced.setObservacion("");
        itemordenesproced.setPlan(Integer.valueOf(this.JTBDetalle.getValueAt(pos, 8).toString()));
        itemordenesproced.setPorcentajeImpuesto(Double.valueOf(this.JTBDetalle.getValueAt(pos, 9).toString()));
        itemordenesproced.setResultadoTexto("");
        itemordenesproced.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        itemordenesproced.setValorDescuento(new Double(0.0d).doubleValue());
        itemordenesproced.setValorImpuesto(new Double(0.0d));
        itemordenesproced.setValorUnitario(Double.valueOf(this.JTBDetalle.getValueAt(pos, 3).toString()).doubleValue());
        return itemordenesproced;
    }
}
