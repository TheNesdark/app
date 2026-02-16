package Laboratorio;

import Acceso.Principal;
import General.JDEnvioCorreoElectronico;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.SseListener;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import co.com.genomaempresarial.ankara.dto.NotificacionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.general.JDHistoricoTrazabilidad;
import com.genoma.plus.controller.general.dto.EventDataDTO;
import com.genoma.plus.controller.general.dto.EventSubscriberDTO;
import com.genoma.plus.controller.laboratorio.JDPatologias;
import com.genoma.plus.controller.parametrizacion.GenericParametrizacionDTO;
import com.genoma.plus.dao.general.SseClosableDAO;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.historia.ExamenFisicoDTO;
import com.genoma.plus.dto.integracion_simedis.DGLEnvioResultadosDTO;
import com.genoma.plus.dto.integracion_simedis.DGLResponseDTO;
import com.genoma.plus.dto.integracion_simedis.SifasOrdenDTO;
import com.genoma.plus.dto.laboratorio.DetalleComentarioProtocoloDTO;
import com.genoma.plus.dto.laboratorio.DetalleRecepcionComentarioDTO;
import com.genoma.plus.dto.laboratorio.DetalleRecepcionSoporteDTO;
import com.genoma.plus.dto.laboratorio.GenericoDTO;
import com.genoma.plus.dto.laboratorio.HistoricoResultadoProtocoloDTO;
import com.genoma.plus.dto.laboratorio.RecepcionDTO;
import com.genoma.plus.dto.laboratorio.RecepcionDetalleDTO;
import com.genoma.plus.jpa.dto.ParametroFiltroPlanillaTrabajoDTO;
import com.genoma.plus.jpa.entities.LRecepcion;
import com.genoma.plus.jpa.service.LDetalleresultadoService;
import com.genoma.plus.jpa.service.LResultadoService;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import lombok.Generated;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFPlanillaTrabajo.class */
public class JIFPlanillaTrabajo extends JInternalFrame implements SseClosableDAO {
    private LaboratorioDAO laboratorioDAO;
    private String xsql;
    private String xsqlc;
    private DefaultListModel xmodelo;
    public DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodelo4;
    private DefaultTableModel xmodelo5;
    private DefaultTableModel xmodelo6;
    private Object[] xdatos;
    private Object[] xDatosResultados;
    private ParametroFiltroPlanillaTrabajoDTO xparametrop;
    private String[][] xidcometario;
    private int xlprocesamiento;
    private int xForma;
    private String nombreSede;
    private LaboratorioDAO xImplLabotaorio;
    private HistoriaDAO xImplHistoria;
    private File xfile;
    private File directorio;
    private String urlResultados;
    private Matcher matcher;
    private SseListener sseListener;
    private List<EventSubscriberDTO> eventSubscriberDTOs;
    private JDResultadoDescriptivo frmCRD;
    private CapturarResultado frmCR;
    private JDPatologias xJDPatologias;
    private JDEnvioCorreoElectronico xifenviocorreo;
    private ButtonGroup JBGFiltro;
    private JButton JBTAgregar;
    private JButton JBTAgregar1;
    private JButton JBTAgregarC;
    private JButton JBTAgregarS;
    private JButton JBTCerarHCBs1;
    private JButton JBTCerarHCBs2;
    private JButton JBTEnvioCorreo;
    private JButton JBTReporte;
    private JButton JBTResultadoDefecto;
    private JButton JBTResultadoDefecto1;
    private JButton JBTValidar;
    private JButton JBTValidar1;
    private JButton JBT_InfoTrazabilidad;
    private JComboBox JCBComentario;
    private JCheckBox JCHAgregar;
    private JCheckBox JCHEsRemitido;
    private JCheckBox JCHEstadoC;
    private JCheckBox JCHEstadoS;
    private JCheckBox JCHLlamarUsuario;
    private JCheckBox JCHNuevaMuestra;
    private JCheckBox JCHRaza;
    private JDateChooser JDFechaC;
    private JDateChooser JDFechaS;
    private JLabel JLBNAnalitos;
    private JLabel JLBNConsecutivo;
    private JLabel JLBNRecepcion;
    private JLabel JLBNTRecepcion;
    private JLabel JLGrafico;
    private JPanel JPIComentarios;
    private JPanel JPIDatosA;
    private JPanel JPIDatosComentario;
    private JPanel JPIFiltroLista;
    private JPanel JPIGrafico;
    private JPanel JPIHistorico;
    private JPanel JPISeguimientos;
    private JPanel JPSoportes;
    private JRadioButton JRBFPPorGrabar;
    private JRadioButton JRBFPValidado;
    private JRadioButton JRBFTodas;
    private JRadioButton JRBValidado;
    private JScrollPane JSPDatosUsuario;
    private JScrollPane JSPDescripcionC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalleAnalito;
    private JScrollPane JSPDetalleComentario;
    private JScrollPane JSPDetalleHc;
    private JScrollPane JSPNRecepcion;
    private JSpinner JSPOrdenC;
    private JTextArea JTADescripcionSeguimiento;
    public JTable JTBDetalleAnalito;
    private JTable JTBDetalleComentario;
    private JTable JTBDetalleHc;
    private JTable JTBRecepcion;
    private JTable JTDetalleC;
    private JTable JTDetalleS;
    private JFormattedTextField JTFFSCorporal1;
    private JFormattedTextField JTFFSIMC1;
    private JFormattedTextField JTFFSPerimetroAbd1;
    private JFormattedTextField JTFFSPeso1;
    private JFormattedTextField JTFFSTalla1;
    private JTextField JTFSoporte;
    public JTextField JTF_NRecepcion;
    private JTextPane JTPDatosUsuario;
    private JTextPane JTPDescripcionC;
    public static JTabbedPane JTPDetalle;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private String xcorreousuario = "";
    private String xcorreomedico = "";
    private String idPatologia = "0";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xfilac = 0;
    private int xtipo = 0;
    private int xEstadoC = 0;
    private int xEstadoS = 0;
    private int xgrabarSeguimiento = 0;
    private int xgrabarSoporte = 0;
    private int xEsRemitido = 0;
    private int nClicBoton = 0;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xGrabo = false;
    private long xedad = 0;
    private long xraza = 1;
    private long xidusuario = 0;
    private String nombrePaciente = "";
    private String xsexo = "";
    private String xagregar = "0";
    private Integer numeroOrden = 0;
    private RestTemplate restTemplate = new RestTemplate();
    private String articuloX = "";
    private String sql = "";
    private boolean envioCorreo = false;
    private final LResultadoService lResultadoService = (LResultadoService) Principal.contexto.getBean(LResultadoService.class);
    private final LDetalleresultadoService lDetalleresultadoService = (LDetalleresultadoService) Principal.contexto.getBean(LDetalleresultadoService.class);
    private DecimalFormat xdf = new DecimalFormat("#.##");
    private ScriptEngineManager manager = new ScriptEngineManager();
    private ScriptEngine engine = this.manager.getEngineByName("js");
    private Pattern patron = Pattern.compile("\\[(.*?)\\]");
    private String idRecepcionDinamica = "";

    @Generated
    public String getIdRecepcionDinamica() {
        return this.idRecepcionDinamica;
    }

    @Generated
    public void setIdRecepcionDinamica(String idRecepcionDinamica) {
        this.idRecepcionDinamica = idRecepcionDinamica;
    }

    public JIFPlanillaTrabajo(ParametroFiltroPlanillaTrabajoDTO xparametrop, int xfiltro) {
        this.xparametrop = new ParametroFiltroPlanillaTrabajoDTO();
        this.xlprocesamiento = 0;
        initComponents();
        springStart();
        this.urlResultados = Principal.informacionIps.getEndPointGenomaEnvioOrdenExamen() + "/rest/v1.0/ordenexamen/envia";
        this.xparametrop = xparametrop;
        this.xlprocesamiento = xfiltro;
        activarBotonInfoTrazabilidad();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTPDescripcionC);
        SpellChecker.register(this.JTADescripcionSeguimiento);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mCargarRecepcion_nuevo();
        } else {
            mCargarRecepcion();
        }
        mNuevo();
        System.out.println(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        mIniciarLabel();
        this.JCHNuevaMuestra.setVisible(false);
        inicializarSseListener();
    }

    private void inicializarSseListener() {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.eventSubscriberDTOs = new ArrayList();
            RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("100", "notificacionesDeEventos");
            if (microserviciosDomain.getUrlRecurso() != null && !microserviciosDomain.getUrlRecurso().isEmpty()) {
                this.sseListener = new SseListener(microserviciosDomain.getUrlRecurso());
                this.sseListener.startListening();
                this.eventSubscriberDTOs.add(this.sseListener.subscribe("update-reception", data -> {
                    try {
                        GenericParametrizacionDTO.builder().build();
                        GenericParametrizacionDTO genericParametrizacionDTO = (GenericParametrizacionDTO) this.xmt.getMapper().readValue(data, GenericParametrizacionDTO.class);
                        if (!this.JLBNRecepcion.getText().isEmpty() && genericParametrizacionDTO.getId().toString().equals(this.JLBNRecepcion.getText())) {
                            SwingUtilities.invokeLater(() -> {
                                if (this.frmCR != null) {
                                    this.frmCR.dispose();
                                    this.frmCR = null;
                                }
                                if (this.frmCRD != null) {
                                    this.frmCRD.dispose();
                                    this.frmCRD = null;
                                }
                                if (this.xJDPatologias != null) {
                                    this.xJDPatologias.dispose();
                                    this.xJDPatologias = null;
                                }
                                if (this.xifenviocorreo != null) {
                                    this.xifenviocorreo.dispose();
                                    this.xifenviocorreo = null;
                                }
                                mCargarInformacion();
                                this.JTBDetalleAnalito.revalidate();
                                this.JTBDetalleAnalito.repaint();
                            });
                        }
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                }));
            }
        }
    }

    private void enviarNotificacion(String idRecepcion) {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("100", "publicacionDeNotificacioneDeEvento");
            if (microserviciosDomain.getUrlRecurso() != null && !microserviciosDomain.getUrlRecurso().isEmpty()) {
                new NotificacionResponse();
                RestTemplate restTemplate = new RestTemplate();
                GenericParametrizacionDTO genericParametrizacionDTO = new GenericParametrizacionDTO();
                genericParametrizacionDTO.setId(Long.valueOf(this.JLBNRecepcion.getText()));
                genericParametrizacionDTO.setNombre("Notificacion");
                genericParametrizacionDTO.setEstado(true);
                EventDataDTO<GenericParametrizacionDTO> eventDataDTO = EventDataDTO.init("update-reception", genericParametrizacionDTO);
                NotificacionResponse response = (NotificacionResponse) restTemplate.postForObject(microserviciosDomain.getUrlRecurso(), eventDataDTO, NotificacionResponse.class, new Object[0]);
                if (response != null) {
                    System.out.println("Mensaje: " + response.getMensaje());
                } else {
                    System.out.println("Ocurrió un error al transmitir");
                }
            }
        }
    }

    @Override // com.genoma.plus.dao.general.SseClosableDAO
    public void closeSseListeners() {
        for (EventSubscriberDTO subscriber : this.eventSubscriberDTOs) {
            this.sseListener.unsubscribe(subscriber);
        }
        this.eventSubscriberDTOs.clear();
    }

    /* JADX WARN: Type inference failed for: r3v119, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v142, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v201, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JSPDatosUsuario = new JScrollPane();
        this.JTPDatosUsuario = new JTextPane();
        this.JLBNTRecepcion = new JLabel();
        this.JLBNAnalitos = new JLabel();
        JTPDetalle = new JTabbedPane();
        this.JSPDetalleAnalito = new JScrollPane();
        this.JTBDetalleAnalito = new JTable();
        this.JPIComentarios = new JPanel();
        this.JSPDetalleComentario = new JScrollPane();
        this.JTBDetalleComentario = new JTable();
        this.JPIDatosComentario = new JPanel();
        this.JCBComentario = new JComboBox();
        this.JSPDescripcionC = new JScrollPane();
        this.JTPDescripcionC = new JTextPane();
        this.JBTValidar1 = new JButton();
        this.JSPOrdenC = new JSpinner();
        this.JPISeguimientos = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcionSeguimiento = new JTextArea();
        this.JCHEstadoC = new JCheckBox();
        this.JCHEsRemitido = new JCheckBox();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JBTAgregarC = new JButton();
        this.JPSoportes = new JPanel();
        this.JDFechaS = new JDateChooser();
        this.JTFSoporte = new JTextField();
        this.JCHEstadoS = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JBTAgregarS = new JButton();
        this.JPIHistorico = new JPanel();
        this.JSPDetalleHc = new JScrollPane();
        this.JTBDetalleHc = new JTable();
        this.JBTAgregar = new JButton();
        this.JPIGrafico = new JPanel();
        this.JLGrafico = new JLabel();
        this.JBTAgregar1 = new JButton();
        this.JBTReporte = new JButton();
        this.JBTValidar = new JButton();
        this.JSPNRecepcion = new JScrollPane();
        this.JTBRecepcion = new JTable();
        this.JBTResultadoDefecto = new JButton();
        this.JPIDatosA = new JPanel();
        this.JTFFSTalla1 = new JFormattedTextField();
        this.JTFFSPeso1 = new JFormattedTextField();
        this.JTFFSIMC1 = new JFormattedTextField();
        this.JTFFSPerimetroAbd1 = new JFormattedTextField();
        this.JTFFSCorporal1 = new JFormattedTextField();
        this.JCHAgregar = new JCheckBox();
        this.JLBNRecepcion = new JLabel();
        this.JPIFiltroLista = new JPanel();
        this.JRBFTodas = new JRadioButton();
        this.JRBFPPorGrabar = new JRadioButton();
        this.JRBFPValidado = new JRadioButton();
        this.JRBValidado = new JRadioButton();
        this.JBTResultadoDefecto1 = new JButton();
        this.JBTEnvioCorreo = new JButton("<html><center><b><u>E</u>nviar Resultado</b></html>");
        this.JCHRaza = new JCheckBox();
        this.JTF_NRecepcion = new JTextField();
        this.JCHNuevaMuestra = new JCheckBox();
        this.JBTCerarHCBs1 = new JButton();
        this.jButton2 = new JButton();
        this.JCHLlamarUsuario = new JCheckBox();
        this.JBTCerarHCBs2 = new JButton();
        this.JBT_InfoTrazabilidad = new JButton();
        this.JLBNConsecutivo = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("PLANILLA DE TRABAJO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("xjifplanillatrabajo");
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFPlanillaTrabajo.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFPlanillaTrabajo.this.formInternalFrameClosing(evt);
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
        this.JSPDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPDatosUsuario.setContentType("text/html");
        this.JTPDatosUsuario.setFont(new Font("Arial", 1, 12));
        this.JSPDatosUsuario.setViewportView(this.JTPDatosUsuario);
        this.JLBNTRecepcion.setFont(new Font("Arial", 1, 18));
        this.JLBNTRecepcion.setForeground(Color.red);
        this.JLBNTRecepcion.setHorizontalAlignment(0);
        this.JLBNTRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Recepción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNAnalitos.setFont(new Font("Arial", 1, 18));
        this.JLBNAnalitos.setForeground(Color.red);
        this.JLBNAnalitos.setHorizontalAlignment(0);
        this.JLBNAnalitos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Analitos", 2, 0, new Font("Arial", 1, 12), Color.blue));
        JTPDetalle.setForeground(new Color(0, 103, 0));
        JTPDetalle.setFont(new Font("Arial", 1, 14));
        JTPDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.2
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTPDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleAnalito.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPDetalleAnalito.setDoubleBuffered(true);
        this.JTBDetalleAnalito.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleAnalito.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleAnalito.setDoubleBuffered(true);
        this.JTBDetalleAnalito.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleAnalito.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleAnalito.setSelectionMode(0);
        this.JTBDetalleAnalito.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.3
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTBDetalleAnalitoMouseClicked(evt);
            }
        });
        this.JTBDetalleAnalito.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFPlanillaTrabajo.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPlanillaTrabajo.this.JTBDetalleAnalitoPropertyChange(evt);
            }
        });
        this.JTBDetalleAnalito.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.5
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTBDetalleAnalitoKeyPressed(evt);
            }
        });
        this.JTBDetalleAnalito.addVetoableChangeListener(new VetoableChangeListener() { // from class: Laboratorio.JIFPlanillaTrabajo.6
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                JIFPlanillaTrabajo.this.JTBDetalleAnalitoVetoableChange(evt);
            }
        });
        this.JSPDetalleAnalito.setViewportView(this.JTBDetalleAnalito);
        JTPDetalle.addTab("PROTOCOLOS", this.JSPDetalleAnalito);
        this.JSPDetalleComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalleComentario.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleComentario.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleComentario.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleComentario.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleComentario.setSelectionMode(0);
        this.JTBDetalleComentario.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.7
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTBDetalleComentarioKeyPressed(evt);
            }
        });
        this.JSPDetalleComentario.setViewportView(this.JTBDetalleComentario);
        this.JPIDatosComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JCBComentario.setFont(new Font("Arial", 1, 12));
        this.JCBComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "Comentario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBComentario.addItemListener(new ItemListener() { // from class: Laboratorio.JIFPlanillaTrabajo.8
            public void itemStateChanged(ItemEvent evt) {
                JIFPlanillaTrabajo.this.JCBComentarioItemStateChanged(evt);
            }
        });
        this.JSPDescripcionC.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDescripcionC.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionC.setViewportView(this.JTPDescripcionC);
        this.JBTValidar1.setFont(new Font("Arial", 1, 12));
        this.JBTValidar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidar1.setText("Agregar");
        this.JBTValidar1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.9
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTValidar1ActionPerformed(evt);
            }
        });
        this.JSPOrdenC.setFont(new Font("Arial", 1, 12));
        this.JSPOrdenC.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrdenC.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosComentarioLayout = new GroupLayout(this.JPIDatosComentario);
        this.JPIDatosComentario.setLayout(JPIDatosComentarioLayout);
        JPIDatosComentarioLayout.setHorizontalGroup(JPIDatosComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosComentarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBComentario, -2, 273, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcionC, -2, 316, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrdenC, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTValidar1, -2, 128, -2).addContainerGap(-1, 32767)));
        JPIDatosComentarioLayout.setVerticalGroup(JPIDatosComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosComentarioLayout.createSequentialGroup().addGroup(JPIDatosComentarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPOrdenC, GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcionC, GroupLayout.Alignment.LEADING, -1, 79, 32767).addComponent(this.JCBComentario, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JBTValidar1, -1, -1, 32767)).addContainerGap(-1, 32767)));
        GroupLayout JPIComentariosLayout = new GroupLayout(this.JPIComentarios);
        this.JPIComentarios.setLayout(JPIComentariosLayout);
        JPIComentariosLayout.setHorizontalGroup(JPIComentariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComentariosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosComentario, -2, -1, -2).addContainerGap(39, 32767)).addGroup(JPIComentariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIComentariosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalleComentario, -2, 823, -2).addGap(43, 43, 43))));
        JPIComentariosLayout.setVerticalGroup(JPIComentariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComentariosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosComentario, -2, -1, -2).addContainerGap(426, 32767)).addGroup(JPIComentariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIComentariosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalleComentario, -2, 290, -2).addContainerGap())));
        JTPDetalle.addTab("COMENTARIOS", this.JPIComentarios);
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JDFechaC.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFPlanillaTrabajo.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPlanillaTrabajo.this.JDFechaCPropertyChange(evt);
            }
        });
        this.JTADescripcionSeguimiento.setColumns(20);
        this.JTADescripcionSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JTADescripcionSeguimiento.setRows(5);
        this.JTADescripcionSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTADescripcionSeguimiento);
        this.JCHEstadoC.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoC.setText("Estado");
        this.JCHEstadoC.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.11
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHEstadoCActionPerformed(evt);
            }
        });
        this.JCHEsRemitido.setFont(new Font("Arial", 1, 12));
        this.JCHEsRemitido.setText("Remitido?");
        this.JCHEsRemitido.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.12
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHEsRemitidoActionPerformed(evt);
            }
        });
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setSelectionBackground(Color.white);
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.13
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalleC);
        this.JBTAgregarC.setFont(new Font("Arial", 1, 12));
        this.JBTAgregarC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregarC.setText("Agregar");
        this.JBTAgregarC.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.14
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTAgregarCActionPerformed(evt);
            }
        });
        GroupLayout JPISeguimientosLayout = new GroupLayout(this.JPISeguimientos);
        this.JPISeguimientos.setLayout(JPISeguimientosLayout);
        JPISeguimientosLayout.setHorizontalGroup(JPISeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientosLayout.createSequentialGroup().addGroup(JPISeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaC, -2, 115, -2).addComponent(this.JCHEsRemitido).addComponent(this.JCHEstadoC)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 579, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAgregarC, -2, 114, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle1)).addContainerGap()));
        JPISeguimientosLayout.setVerticalGroup(JPISeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientosLayout.createSequentialGroup().addComponent(this.JDFechaC, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsRemitido).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoC).addGap(0, 0, 32767)).addComponent(this.JBTAgregarC, -1, -1, 32767).addComponent(this.jScrollPane1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -2, 299, -2)));
        JTPDetalle.addTab("SEGUIMIENTOS", this.JPISeguimientos);
        this.JDFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDFechaS.setFont(new Font("Arial", 1, 12));
        this.JDFechaS.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFPlanillaTrabajo.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPlanillaTrabajo.this.JDFechaSPropertyChange(evt);
            }
        });
        this.JTFSoporte.setFont(new Font("Arial", 1, 12));
        this.JTFSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta del Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSoporte.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.16
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTFSoporteMouseClicked(evt);
            }
        });
        this.JCHEstadoS.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoS.setText("Estado");
        this.JCHEstadoS.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.17
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHEstadoSActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setSelectionBackground(Color.white);
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.18
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalleS);
        this.JBTAgregarS.setFont(new Font("Arial", 1, 12));
        this.JBTAgregarS.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregarS.setText("Agregar");
        this.JBTAgregarS.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.19
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTAgregarSActionPerformed(evt);
            }
        });
        GroupLayout JPSoportesLayout = new GroupLayout(this.JPSoportes);
        this.JPSoportes.setLayout(JPSoportesLayout);
        JPSoportesLayout.setHorizontalGroup(JPSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSoportesLayout.createSequentialGroup().addComponent(this.JDFechaS, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoS).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAgregarS, -2, 128, -2)).addComponent(this.JSPDetalle, -1, 829, 32767)).addContainerGap()));
        JPSoportesLayout.setVerticalGroup(JPSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstadoS).addComponent(this.JTFSoporte, -2, 50, -2).addComponent(this.JDFechaS, -2, 50, -2).addComponent(this.JBTAgregarS, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 473, 32767).addContainerGap()));
        JTPDetalle.addTab("SOPORTES", this.JPSoportes);
        this.JSPDetalleHc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalleHc.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleHc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleHc.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleHc.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleHc.setSelectionMode(0);
        this.JSPDetalleHc.setViewportView(this.JTBDetalleHc);
        this.JBTAgregar.setFont(new Font("Arial", 1, 12));
        this.JBTAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregar.setText("Agregar");
        this.JBTAgregar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.20
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTAgregarActionPerformed(evt);
            }
        });
        this.JPIGrafico.setBorder(BorderFactory.createTitledBorder((Border) null, "GRAFICO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLGrafico.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIGraficoLayout = new GroupLayout(this.JPIGrafico);
        this.JPIGrafico.setLayout(JPIGraficoLayout);
        JPIGraficoLayout.setHorizontalGroup(JPIGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 421, 32767).addGroup(JPIGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLGrafico, GroupLayout.Alignment.TRAILING, -1, 421, 32767)));
        JPIGraficoLayout.setVerticalGroup(JPIGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 323, 32767).addGroup(JPIGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLGrafico, GroupLayout.Alignment.TRAILING, -1, 323, 32767)));
        this.JBTAgregar1.setFont(new Font("Arial", 1, 12));
        this.JBTAgregar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregar1.setText("Graficar");
        this.JBTAgregar1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.21
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTAgregar1ActionPerformed(evt);
            }
        });
        this.JBTReporte.setFont(new Font("Arial", 1, 12));
        this.JBTReporte.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTReporte.setText("Reporte");
        this.JBTReporte.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.22
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTReporteActionPerformed(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addComponent(this.JBTAgregar, -2, 392, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAgregar1, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTReporte, -2, 213, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIGrafico, -2, -1, -2))).addContainerGap()).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleHc, -2, 393, -2).addContainerGap(451, 32767))));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIGrafico, -2, -1, -2).addGap(8, 8, 8).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAgregar, -2, 59, -2).addComponent(this.JBTAgregar1, -2, 59, -2).addComponent(this.JBTReporte, -2, 59, -2)).addContainerGap()).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleHc, -2, 349, -2).addContainerGap(186, 32767))));
        JTPDetalle.addTab("HISTÓRICO", this.JPIHistorico);
        this.JBTValidar.setFont(new Font("Arial", 1, 12));
        this.JBTValidar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidar.setMnemonic('D');
        this.JBTValidar.setText("Grabar");
        this.JBTValidar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.23
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTValidarActionPerformed(evt);
            }
        });
        this.JSPNRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° RECEPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPNRecepcion.setDoubleBuffered(true);
        this.JSPNRecepcion.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.24
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JSPNRecepcionMouseClicked(evt);
            }
        });
        this.JTBRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTBRecepcion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRecepcion.setDoubleBuffered(true);
        this.JTBRecepcion.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRecepcion.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRecepcion.setSelectionMode(0);
        this.JTBRecepcion.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.25
            public void mouseClicked(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTBRecepcionMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIFPlanillaTrabajo.this.JTBRecepcionMouseEntered(evt);
            }
        });
        this.JSPNRecepcion.setViewportView(this.JTBRecepcion);
        this.JBTResultadoDefecto.setFont(new Font("Arial", 1, 12));
        this.JBTResultadoDefecto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Puc.png")));
        this.JBTResultadoDefecto.setMnemonic('e');
        this.JBTResultadoDefecto.setText("<html><P ALIGN=center>Resultado por Defecto");
        this.JBTResultadoDefecto.setToolTipText("Resultado por Defecto");
        this.JBTResultadoDefecto.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.26
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTResultadoDefectoActionPerformed(evt);
            }
        });
        this.JPIDatosA.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ANTROPOMÉTRICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFSTalla1.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSTalla1.setHorizontalAlignment(4);
        this.JTFFSTalla1.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.27
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSTalla1ActionPerformed(evt);
            }
        });
        this.JTFFSTalla1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.28
            public void focusLost(FocusEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSTalla1FocusLost(evt);
            }
        });
        this.JTFFSTalla1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.29
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSTalla1KeyPressed(evt);
            }
        });
        this.JTFFSPeso1.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSPeso1.setHorizontalAlignment(4);
        this.JTFFSPeso1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.30
            public void focusLost(FocusEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSPeso1FocusLost(evt);
            }
        });
        this.JTFFSPeso1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.31
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSPeso1ActionPerformed(evt);
            }
        });
        this.JTFFSPeso1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.32
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSPeso1KeyPressed(evt);
            }
        });
        this.JTFFSIMC1.setEditable(false);
        this.JTFFSIMC1.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSIMC1.setHorizontalAlignment(4);
        this.JTFFSIMC1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd1.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPerimetroAbd1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSPerimetroAbd1.setHorizontalAlignment(4);
        this.JTFFSPerimetroAbd1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.33
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTFFSPerimetroAbd1KeyPressed(evt);
            }
        });
        this.JTFFSCorporal1.setEditable(false);
        this.JTFFSCorporal1.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Corporal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSCorporal1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSCorporal1.setHorizontalAlignment(4);
        this.JTFFSCorporal1.setFont(new Font("Arial", 1, 12));
        this.JCHAgregar.setFont(new Font("Arial", 1, 12));
        this.JCHAgregar.setText("Agregar a Impresión");
        this.JCHAgregar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.34
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHAgregarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAgregar).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosALayout.createSequentialGroup().addComponent(this.JTFFSTalla1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSPeso1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSIMC1, -2, 81, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosALayout.createSequentialGroup().addComponent(this.JTFFSPerimetroAbd1).addGap(18, 18, 18).addComponent(this.JTFFSCorporal1, -2, 122, -2)))).addContainerGap(-1, 32767)));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla1, -2, 55, -2).addComponent(this.JTFFSPeso1, -2, 55, -2).addComponent(this.JTFFSIMC1, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSPerimetroAbd1, -2, 55, -2).addComponent(this.JTFFSCorporal1, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAgregar).addContainerGap(-1, 32767)));
        this.JLBNRecepcion.setFont(new Font("Arial", 1, 18));
        this.JLBNRecepcion.setForeground(new Color(255, 0, 0));
        this.JLBNRecepcion.setHorizontalAlignment(0);
        this.JLBNRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° RECEPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIFiltroLista.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Lista Trabajo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFiltro.add(this.JRBFTodas);
        this.JRBFTodas.setFont(new Font("Arial", 1, 12));
        this.JRBFTodas.setSelected(true);
        this.JRBFTodas.setText("Todas");
        this.JRBFTodas.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.35
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JRBFTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBFPPorGrabar);
        this.JRBFPPorGrabar.setFont(new Font("Arial", 1, 12));
        this.JRBFPPorGrabar.setText("Por Grabar");
        this.JRBFPPorGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.36
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JRBFPPorGrabarActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBFPValidado);
        this.JRBFPValidado.setFont(new Font("Arial", 1, 12));
        this.JRBFPValidado.setText("Por Validar");
        this.JRBFPValidado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.37
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JRBFPValidadoActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBValidado);
        this.JRBValidado.setFont(new Font("Arial", 1, 12));
        this.JRBValidado.setText("Validado");
        this.JRBValidado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.38
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JRBValidadoActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroListaLayout = new GroupLayout(this.JPIFiltroLista);
        this.JPIFiltroLista.setLayout(JPIFiltroListaLayout);
        JPIFiltroListaLayout.setHorizontalGroup(JPIFiltroListaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroListaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroListaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFTodas).addComponent(this.JRBFPValidado).addComponent(this.JRBValidado).addComponent(this.JRBFPPorGrabar)).addContainerGap(29, 32767)));
        JPIFiltroListaLayout.setVerticalGroup(JPIFiltroListaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroListaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBFPPorGrabar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBFPValidado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBValidado).addGap(18, 18, 18)));
        this.JBTResultadoDefecto1.setFont(new Font("Arial", 1, 12));
        this.JBTResultadoDefecto1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTResultadoDefecto1.setMnemonic('e');
        this.JBTResultadoDefecto1.setText("<html><P ALIGN=center>Cargar Filtro Planilla");
        this.JBTResultadoDefecto1.setToolTipText("");
        this.JBTResultadoDefecto1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.39
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTResultadoDefecto1ActionPerformed(evt);
            }
        });
        this.JBTEnvioCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTEnvioCorreo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTEnvioCorreo.setToolTipText("");
        this.JBTEnvioCorreo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.40
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTEnvioCorreoActionPerformed(evt);
            }
        });
        this.JCHRaza.setFont(new Font("Arial", 1, 12));
        this.JCHRaza.setText("Afrodescendiente?");
        this.JCHRaza.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.41
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHRazaActionPerformed(evt);
            }
        });
        this.JTF_NRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTF_NRecepcion.setHorizontalAlignment(0);
        this.JTF_NRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Recepción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NRecepcion.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFPlanillaTrabajo.42
            public void keyPressed(KeyEvent evt) {
                JIFPlanillaTrabajo.this.JTF_NRecepcionKeyPressed(evt);
            }
        });
        this.JCHNuevaMuestra.setFont(new Font("Arial", 1, 14));
        this.JCHNuevaMuestra.setForeground(Color.red);
        this.JCHNuevaMuestra.setText("NUEVA MUESTRA!!!");
        this.JCHNuevaMuestra.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.43
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHNuevaMuestraActionPerformed(evt);
            }
        });
        this.JBTCerarHCBs1.setFont(new Font("Arial", 1, 12));
        this.JBTCerarHCBs1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bloqueo.png")));
        this.JBTCerarHCBs1.setMnemonic('e');
        this.JBTCerarHCBs1.setText("<html><P ALIGN=center>Cerra HC Bs1");
        this.JBTCerarHCBs1.setToolTipText("Resultado por Defecto");
        this.JBTCerarHCBs1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.44
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTCerarHCBs1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton2.setText("<html><P ALIGN=center>Resultado por Defecto por Patologia");
        this.jButton2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.45
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.jButton2ActionPerformed(evt);
            }
        });
        this.JCHLlamarUsuario.setFont(new Font("Arial", 1, 14));
        this.JCHLlamarUsuario.setForeground(Color.red);
        this.JCHLlamarUsuario.setText("Llamar Usuario?");
        this.JCHLlamarUsuario.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.46
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JCHLlamarUsuarioActionPerformed(evt);
            }
        });
        this.JBTCerarHCBs2.setFont(new Font("Arial", 1, 12));
        this.JBTCerarHCBs2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTCerarHCBs2.setMnemonic('e');
        this.JBTCerarHCBs2.setText("<html><P ALIGN=center>Limpiar Valor");
        this.JBTCerarHCBs2.setToolTipText("Resultado por Defecto");
        this.JBTCerarHCBs2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.47
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBTCerarHCBs2ActionPerformed(evt);
            }
        });
        this.JBT_InfoTrazabilidad.setFont(new Font("Arial", 1, 14));
        this.JBT_InfoTrazabilidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info_FILL0_wght400_GRAD0_opsz24.png")));
        this.JBT_InfoTrazabilidad.setText("Info");
        this.JBT_InfoTrazabilidad.setToolTipText("Información de trazabilidad de ingreso");
        this.JBT_InfoTrazabilidad.addActionListener(new ActionListener() { // from class: Laboratorio.JIFPlanillaTrabajo.48
            public void actionPerformed(ActionEvent evt) {
                JIFPlanillaTrabajo.this.JBT_InfoTrazabilidadActionPerformed(evt);
            }
        });
        this.JLBNConsecutivo.setFont(new Font("Arial", 1, 18));
        this.JLBNConsecutivo.setForeground(new Color(255, 0, 0));
        this.JLBNConsecutivo.setHorizontalAlignment(0);
        this.JLBNConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° CONSECUTIVO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPNRecepcion, -2, 0, 32767).addComponent(this.JTF_NRecepcion, -1, 149, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNTRecepcion, -2, 125, -2).addComponent(this.JLBNAnalitos, -2, 125, -2)))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPDatosUsuario, -2, 553, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosA, -2, -1, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JTPDetalle, -2, 854, -2))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JPIFiltroLista, -2, -1, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_InfoTrazabilidad).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTEnvioCorreo, -2, 167, -2).addComponent(this.JBTResultadoDefecto1, -2, 167, -2).addComponent(this.JBTResultadoDefecto, -2, 167, -2).addComponent(this.JBTValidar, -2, 167, -2).addComponent(this.JBTCerarHCBs1, -2, 167, -2).addComponent(this.jButton2, -2, 167, -2).addComponent(this.JBTCerarHCBs2, -2, 167, -2)))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHNuevaMuestra)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHLlamarUsuario)).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNConsecutivo, -2, 162, -2).addComponent(this.JLBNRecepcion, -2, 158, -2))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHRaza))).addGap(11, 11, 11)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPNRecepcion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NRecepcion, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNTRecepcion, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNAnalitos, -2, 61, -2).addGap(35, 35, 35)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosA, -2, -1, -2).addComponent(this.JSPDatosUsuario, -2, 199, -2).addGroup(layout.createSequentialGroup().addComponent(this.JLBNRecepcion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNConsecutivo, -2, 50, -2).addGap(1, 1, 1).addComponent(this.JCHRaza).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHNuevaMuestra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHLlamarUsuario))).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBT_InfoTrazabilidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTValidar, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTResultadoDefecto, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTResultadoDefecto1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEnvioCorreo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerarHCBs1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerarHCBs2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltroLista, -2, -1, -2)).addComponent(JTPDetalle)).addContainerGap()))));
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JBTResultadoDefecto.setEnabled(false);
        }
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidarActionPerformed(ActionEvent evt) {
        System.out.println("esFpz -> " + Principal.informacionIps.getEsFpz());
        System.out.println("autorizacion laboratorio ->" + Principal.usuarioSistemaDTO.getAutorizacionLaboratorio());
        if (this.JTBDetalleAnalito.getRowCount() > 0) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0 && !Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                mOpcGrabar();
                mCargarInformacion();
                mOpcValidar();
                mCargarInformacion();
                return;
            }
            if (null == Principal.usuarioSistemaDTO.getAutorizacionLaboratorio()) {
                Object[] botones = {"Grabar", "Validar", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "VERIFICACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))), botones, "Cerrar");
                if (n == 0) {
                    this.JBTValidar.setText("Grabar");
                    mGrabar();
                    return;
                } else {
                    if (n == 1) {
                        this.JBTValidar.setText("Validar");
                        mGrabar();
                        return;
                    }
                    return;
                }
            }
            switch (Principal.usuarioSistemaDTO.getAutorizacionLaboratorio().intValue()) {
                case 0:
                    this.JBTValidar.setText("Validar");
                    mGrabar();
                    break;
                case 1:
                    this.JBTValidar.setText("Grabar");
                    mGrabar();
                    break;
                default:
                    Object[] botones2 = {"Grabar", "Validar", "Cerrar"};
                    int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "VERIFICACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))), botones2, "Cerrar");
                    if (n2 == 0) {
                        this.JBTValidar.setText("Grabar");
                        mGrabar();
                    } else if (n2 == 1) {
                        this.JBTValidar.setText("Validar");
                        mGrabar();
                    }
                    break;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No existe protocolos para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mCargarInformacion() {
        this.nClicBoton = 0;
        mCrearModeloSoportes();
        mCrearModeloSeguimientos();
        mCargarDetalleRecepcion_NUevo();
        this.JSPDetalleAnalito.getVerticalScrollBar().setValue(this.JSPDetalleAnalito.getVerticalScrollBar().getMinimum());
        if (this.JTBDetalleAnalito.getRowCount() != 0) {
            this.JTBDetalleAnalito.setRowSelectionInterval(0, 0);
        }
        System.err.println("ips" + Principal.informacionIps.getNombreIps());
        if (Principal.informacionIps.getNombreIps().equals("APLICA PARA CLINETES QUE LO SOLICITEN")) {
            this.JBTResultadoDefecto.doClick();
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && this.JTBDetalleAnalito.getRowCount() != -1) {
            for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
                if (!Boolean.valueOf(this.xmodelo1.getValueAt(x, 9).toString()).booleanValue()) {
                    List<GenericoDTO> list = this.xImplLabotaorio.listTipoResultadoporDefectoBs1(Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 21).toString()));
                    if (list.size() > 0) {
                        this.xmodelo1.setValueAt(list.get(0).getNombre(), x, 3);
                        this.xmodelo1.setValueAt(list.get(0).getId(), x, 16);
                    }
                }
            }
        }
        if (Principal.informacionIps.getAplicaFormulasDinamicasLab().booleanValue()) {
            formulas();
        } else {
            mCalcularDato();
        }
        mValidarResultadoAlterado();
        this.JTBDetalleAnalito.requestFocus();
        mIniciarLabel();
    }

    private void activarBotonInfoTrazabilidad() {
        if (!Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.JBT_InfoTrazabilidad.setVisible(false);
        }
    }

    private void mIniciarLabel() {
        if (null == Principal.usuarioSistemaDTO.getAutorizacionLaboratorio()) {
            this.JBTValidar.setText("Super Usuario");
            return;
        }
        switch (Principal.usuarioSistemaDTO.getAutorizacionLaboratorio().intValue()) {
            case 0:
                this.JBTValidar.setText("Validar");
                break;
            case 1:
                this.JBTValidar.setText("Grabar");
                break;
            case 2:
                this.JBTValidar.setText("Graba y Validar");
                break;
            default:
                this.JBTValidar.setText("Super Usuario");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTResultadoDefectoActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getRowCount() != -1) {
            for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
                if (!Boolean.valueOf(this.xmodelo1.getValueAt(x, 9).toString()).booleanValue()) {
                    List<GenericoDTO> list = this.xImplLabotaorio.listTipoResultadoporDefecto(Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 21).toString()));
                    if (list.size() > 0) {
                        this.xmodelo1.setValueAt(list.get(0).getNombre(), x, 3);
                        this.xmodelo1.setValueAt(list.get(0).getId(), x, 16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        closeSseListeners();
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFTodasActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mCargarRecepcion_nuevo();
        } else {
            mCargarRecepcion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFPValidadoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mCargarRecepcion_nuevo();
        } else {
            mCargarRecepcion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValidadoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mCargarRecepcion_nuevo();
        } else {
            mCargarRecepcion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTResultadoDefecto1ActionPerformed(ActionEvent evt) {
        closeSseListeners();
        dispose();
        JDFiltroPlanillaTrabajo xjiffiltroplantilla = new JDFiltroPlanillaTrabajo(null, true, Principal.claselab);
        xjiffiltroplantilla.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnvioCorreoActionPerformed(ActionEvent evt) {
        if (!this.JLBNRecepcion.getText().isEmpty()) {
            if (this.JTBDetalleAnalito.getRowCount() > 0) {
                System.err.println("correo" + this.xcorreousuario);
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                impresion.mEvioResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getIdentificacion().equals("901613732") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "id";
                    parametros[0][1] = this.JLBNRecepcion.getText();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    System.err.println("ruta" + this.xmt.getRutaRep());
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + this.JLBNRecepcion.getText() + ".pdf"));
                    this.xmt.CrearPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1", parametros, this.xmt.getRutaRep() + this.JLBNRecepcion.getText());
                    if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        String mensaje = "<html>Estimado(a) " + this.nombrePaciente + "<br><br>Adjunto a este correo encontrará los resultados de su análisis de laboratorio. Le invitamos a revisarlos con detenimiento y, si tiene alguna inquietud, no dude en contactarnos..<br><br>Además, queremos conocer su opinión sobre nuestro servicio. Lo invitamos a responder la siguiente encuesta de satisfacción, ya que su retroalimentación es fundamental para mejorar la calidad de nuestra atención:<br><br><a href='https://forms.gle/z998ZzmTJRPt8wK87'>https://forms.gle/z998ZzmTJRPt8wK87</a><br><br>Agradecemos su tiempo y confianza en nuestros servicios.<br><br>Atentamente,<br><br>" + this.nombreSede + "<br><br></html>";
                        this.xifenviocorreo = new JDEnvioCorreoElectronico(null, true, impresion.getNombreReporte() + ".pdf", this.xcorreousuario, mensaje, "Adjunto Resultado de examen");
                        this.xifenviocorreo = new JDEnvioCorreoElectronico(null, true, impresion.getNombreReporte() + ".pdf", this.xcorreousuario, mensaje, "Adjunto Resultado de examen");
                    } else {
                        this.xifenviocorreo = new JDEnvioCorreoElectronico(null, true, impresion.getNombreReporte() + ".pdf", this.xcorreousuario, "Resultado Examen", "Adjunto Resultado de examen");
                    }
                    this.xifenviocorreo.setVisible(true);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Utilidad No Utorizada, contaca a Genoma Empresarial para activarlo", "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe protocolos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFSTalla1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCalcularImc();
            mCalcularSCorporal();
            this.JTFFSPeso1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPerimetroAbd1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1ActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1ActionPerformed(ActionEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1FocusLost(FocusEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
        this.JTFFSPerimetroAbd1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1FocusLost(FocusEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRazaActionPerformed(ActionEvent evt) {
        if (this.JCHRaza.isSelected()) {
            this.xraza = 0L;
        } else {
            this.xraza = 1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAgregarActionPerformed(ActionEvent evt) {
        if (this.JCHAgregar.isSelected()) {
            this.xagregar = "1";
        } else {
            this.xagregar = "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNRecepcionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NRecepcionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                mCargarRecepcion_nuevo();
            } else {
                mCargarRecepcion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            this.JDFechaS.setDate(Date.valueOf(this.xmodelo6.getValueAt(this.JTDetalleS.getSelectedRow(), 1).toString()));
            this.JTFSoporte.setText(this.xmodelo6.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo6.getValueAt(this.JTDetalleS.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstadoS.setSelected(true);
                this.xEstadoS = 1;
            } else {
                this.JCHEstadoS.setSelected(false);
                this.xEstadoS = 0;
            }
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo6.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString();
                this.xmt.mostrarPdf(this.directorio + "\\" + rutaa);
            }
            this.xgrabarSoporte = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoS.isSelected()) {
            this.xEstadoS = 1;
        } else {
            this.xEstadoS = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaSPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoC.isSelected()) {
            this.xEstadoC = 1;
        } else {
            this.xEstadoC = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaCPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTReporteActionPerformed(ActionEvent evt) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "ID_PROTOCOLO";
        mparametros[0][1] = this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString();
        mparametros[1][0] = "ID_RECEPCION";
        mparametros[1][1] = Principal.txtNo.getText();
        mparametros[2][0] = "NPROTOCOLO";
        mparametros[2][1] = this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 1).toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Grafica_Resultados_Protocolo", mparametros);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregar1ActionPerformed(ActionEvent evt) {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        BufferedImage bufferedImage = chart.createBufferedImage(421, 323);
        this.JLGrafico.setIcon(new ImageIcon(bufferedImage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregarActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleHc, 10)) {
                int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y == 0) {
                    for (int x = 0; x < this.JTBDetalleHc.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo3.getValueAt(x, 10).toString()).booleanValue()) {
                            this.xImplLabotaorio.addResultadoHistoricoGrafica(this.JLBNRecepcion.getText(), Long.valueOf(this.xmodelo3.getValueAt(x, 1).toString()), Long.valueOf(this.xmodelo3.getValueAt(x, 0).toString()));
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe resultado seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleecionar un protocolo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        JTPDetalle.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidar1ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
            if (!this.JTPDescripcionC.getText().isEmpty()) {
                if (!this.xmt.mVerificarDatosDoblesTabla(this.JTBDetalleComentario, 0, this.xidcometario[this.JCBComentario.getSelectedIndex()][0])) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xImplLabotaorio.addComentarioArea(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()), Long.valueOf(this.xidcometario[this.JCBComentario.getSelectedIndex()][0]), this.JTPDescripcionC.getText(), Integer.valueOf(this.JSPOrdenC.getValue().toString()), "");
                        mCargarDetalleComentario();
                        this.JCBComentario.setSelectedIndex(-1);
                        this.JTPDescripcionC.setText("");
                        this.JCBComentario.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Comentario ya se encuentra agregado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDescripcionC.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleecionar un protocolo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        JTPDetalle.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBComentarioItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBComentario.getSelectedIndex() != -1) {
            this.JTPDescripcionC.setText(this.xidcometario[this.JCBComentario.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleComentarioKeyPressed(KeyEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1 && this.JTBDetalleComentario.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar el comentario?", "CONFIRMAR", 0, 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            if (x == 0) {
                this.xImplLabotaorio.deleteComentarioResultadoProcedimento(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
                mCargarDetalleComentario();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAnalitoVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAnalitoKeyPressed(KeyEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1 && Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 32).toString()).intValue() == 0 && evt.getKeyCode() == 10 && this.JTBDetalleAnalito.getSelectedColumn() == 3) {
            mCargarDetalleComentario();
            mCargarDetalleHistorico();
            if (!Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 9).toString()).booleanValue()) {
                if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 2).toString()).intValue() == 1) {
                    mCargarTipoResultado();
                } else if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 2).toString()).intValue() == 2) {
                    mCargarTipoResultadoD(0, 3);
                }
            }
            if (Principal.informacionIps.getAplicaFormulasDinamicasLab().booleanValue()) {
                formulas();
            } else {
                mCalcularDato();
            }
            mAlertaValoresFueraRango();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAnalitoPropertyChange(PropertyChangeEvent evt) {
        mValidarResultadoAlterado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAnalitoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTBDetalleAnalito.getSelectedColumn() == 1) {
                System.out.println("entra a ejecutar eventos en la columna dos");
                if (this.JTBDetalleAnalito.getSelectedRow() != -1 && Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 32).toString()).intValue() == 0) {
                    System.out.println("ejecuta metodos comentario-historico");
                    mCargarDetalleComentario();
                    mCargarDetalleHistorico();
                    mCargarDetalleSeguimientos();
                    mCargarDetalleSoportes();
                    return;
                }
                return;
            }
        }
        if (this.JTBDetalleAnalito.getSelectedRow() != -1 && Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 32).toString()).intValue() == 0) {
            mCargarDetalleComentario();
            mCargarDetalleHistorico();
            mCargarDetalleSeguimientos();
            mCargarDetalleSoportes();
            mCargarComboCometario(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 20).toString());
            switch (this.JTBDetalleAnalito.getSelectedColumn()) {
                case 3:
                    if (!Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 9).toString()).booleanValue()) {
                        if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 2).toString()).intValue() == 1) {
                            mCargarTipoResultado();
                        } else if (Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 2).toString()).intValue() == 2) {
                            mCargarTipoResultadoD(0, 3);
                        }
                    }
                    if (Principal.informacionIps.getAplicaFormulasDinamicasLab().booleanValue()) {
                        formulas();
                    } else {
                        mCalcularDato();
                    }
                    mAlertaValoresFueraRango();
                    break;
                case 9:
                    if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString().equals("0")) {
                        mAnular(1);
                    }
                    break;
                case 17:
                    mCargarTipoResultadoD(1, 17);
                    if (Principal.informacionIps.getAplicaFormulasDinamicasLab().booleanValue()) {
                        formulas();
                    } else {
                        mCalcularDato();
                    }
                    mAlertaValoresFueraRango();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            this.JDFechaS.setDate(Date.valueOf(this.xmodelo5.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString()));
            this.JTADescripcionSeguimiento.setText(this.xmodelo5.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo5.getValueAt(this.JTDetalleC.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstadoC.setSelected(true);
                this.xEstadoC = 1;
            } else {
                this.JCHEstadoC.setSelected(false);
                this.xEstadoC = 0;
            }
            this.xgrabarSeguimiento = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregarCActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
            if (!this.JTADescripcionSeguimiento.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    DetalleRecepcionComentarioDTO e = new DetalleRecepcionComentarioDTO();
                    if (this.xgrabarSeguimiento == 0) {
                        e.setIdRecepcion(Long.valueOf(this.JLBNRecepcion.getText()));
                        e.setIdProcedimiento(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
                        e.setFecha(this.xmt.formatoAMD.format(this.JDFechaC.getDate()));
                        e.setDescripcion(this.JTADescripcionSeguimiento.getText());
                        e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
                        e.setEstado(this.xEstadoC);
                        e.setEsRemitido(this.xEsRemitido);
                        this.xImplLabotaorio.mCreateSeguimiento(e);
                    } else {
                        e.setFecha(this.xmt.formatoAMD.format(this.JDFechaC.getDate()));
                        e.setDescripcion(this.JTADescripcionSeguimiento.getText());
                        e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
                        e.setEstado(this.xEstadoC);
                        e.setEsRemitido(this.xEsRemitido);
                        e.setId(Long.valueOf(this.xmodelo5.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString()));
                        this.xImplLabotaorio.mUpdateSeguimientos(e);
                    }
                    if ((Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS")) && this.xEsRemitido == 1) {
                        this.xImplLabotaorio.updateDetalleRecepcion(0, 1, Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString()), 2, 1);
                    }
                    mCargarDetalleSeguimientos();
                    this.JDFechaC.setDate(this.xmt.getFechaActual());
                    this.JTADescripcionSeguimiento.setText("");
                    this.JCHEstadoC.setSelected(true);
                    this.xEstadoC = 1;
                    this.xgrabarSeguimiento = 0;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTADescripcionSeguimiento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregarSActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
            if (!this.JTFSoporte.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    DetalleRecepcionSoporteDTO e = new DetalleRecepcionSoporteDTO();
                    if (this.xgrabarSoporte == 0) {
                        File directorio = new File(this.xmt.mRutaSoporte("JIFPlanillaTrabajo"));
                        e.setIdRecepcion(Long.valueOf(this.JLBNRecepcion.getText()));
                        e.setIdProcedimiento(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
                        e.setFecha(this.xmt.formatoAMD.format(this.JDFechaS.getDate()));
                        e.setEstado(this.xEstadoS);
                        String xidDoc = this.xImplLabotaorio.create_return_id_Soporte(e);
                        String adjunto = xidDoc + "_" + Long.valueOf(this.JLBNRecepcion.getText()) + "_" + Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()) + ".pdf";
                        e.setSoporte(this.xmt.mTraerUrlBD(adjunto));
                        e.setId(Long.valueOf(xidDoc));
                        this.xImplLabotaorio.mUpdateRuta(e);
                        File f1 = new File(this.JTFSoporte.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    } else {
                        e.setEstado(this.xEstadoS);
                        e.setId(Long.valueOf(this.xmodelo6.getValueAt(this.JTDetalleS.getSelectedRow(), 0).toString()));
                        this.xImplLabotaorio.mUpdateSoportes(e);
                    }
                    mCargarDetalleSoportes();
                    this.JDFechaS.setDate(this.xmt.getFechaActual());
                    this.JTFSoporte.setText("");
                    this.JCHEstadoS.setSelected(true);
                    this.xEstadoS = 1;
                    this.xgrabarSoporte = 0;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La ruta del soporte no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFSoporte.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSoporteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFSoporte.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsRemitidoActionPerformed(ActionEvent evt) {
        if (this.JCHEsRemitido.isSelected()) {
            this.xEsRemitido = 1;
            this.JTADescripcionSeguimiento.setText("Remitido");
        } else {
            this.JTADescripcionSeguimiento.setText("");
            this.xEsRemitido = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRecepcionMouseClicked(MouseEvent evt) {
        if (this.JTBRecepcion.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            System.out.println("" + this.JTBRecepcion.getValueAt(this.JTBRecepcion.getSelectedRow(), 4).toString());
            setIdRecepcionDinamica(this.JTBRecepcion.getValueAt(this.JTBRecepcion.getSelectedRow(), 4).toString());
            if (Boolean.valueOf(this.xmodelo4.getValueAt(this.JTBRecepcion.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHNuevaMuestra.setVisible(true);
            } else {
                this.JCHNuevaMuestra.setVisible(false);
            }
            this.JLBNRecepcion.setText(this.xmodelo4.getValueAt(this.JTBRecepcion.getSelectedRow(), 0).toString());
            this.JLBNConsecutivo.setText(this.xmodelo4.getValueAt(this.JTBRecepcion.getSelectedRow(), 2).toString().replaceAll("[-a-zA-Z]+", ""));
            mCargarInformacion();
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JBTCerarHCBs1.setEnabled(true);
            try {
                String sql = "SELECT\n    `l_recepcion`.`Id`\n    , `l_resultados`.`Id` AS `resultado`\n    , `l_resultados`.`estadoHcBs1`\nFROM\n    `l_resultados`\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Id` ='" + this.JLBNRecepcion.getText() + "')GROUP BY  `l_recepcion`.`Id` ;";
                System.out.println("RBS1" + sql);
                ResultSet rs = this.xct.getResultSet(sql);
                if (rs.next()) {
                    rs.first();
                    if ("0".equals(rs.getString("estadoHcBs1"))) {
                        this.JBTCerarHCBs1.setEnabled(true);
                        System.out.println("abierta");
                    } else {
                        this.JBTCerarHCBs1.setEnabled(false);
                        System.out.println("cerrada");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFPPorGrabarActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mCargarRecepcion_nuevo();
        } else {
            mCargarRecepcion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNuevaMuestraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerarHCBs1ActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            try {
                String sql = "SELECT\n    `l_recepcion`.`Id`\n    , `f_ordenes`.`Id`\n    , `ingreso`.`Id`\n    , `ingreso`.`NoAutorizacion`\nFROM\n    `l_recepcion`\n    INNER JOIN `f_ordenes` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`l_recepcion`.`Id` ='" + this.JLBNRecepcion.getText() + "');";
                System.out.println("RBS1" + sql);
                ResultSet rs = this.xct.getResultSet(sql);
                if (rs.next()) {
                    rs.first();
                    this.xImplLabotaorio.updateCierreHcBs1(rs.getString("NoAutorizacion"));
                    this.JBTCerarHCBs1.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.xImplLabotaorio.updateCierreGenomHcBs1(this.JLBNRecepcion.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getRowCount() != -1) {
            System.err.println("idprocedimeinto11 " + this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString());
            this.xJDPatologias = new JDPatologias(null, true, this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString(), this);
            this.xJDPatologias.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLlamarUsuarioActionPerformed(ActionEvent evt) {
        Integer estado;
        if (!this.JLBNRecepcion.getText().isEmpty()) {
            if (this.JCHLlamarUsuario.isSelected()) {
                estado = 1;
            } else {
                estado = 0;
            }
            String sql = "update l_recepcion set brigada=" + estado + " where Id=" + this.JLBNRecepcion.getText() + "";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRecepcionMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerarHCBs2ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1 && Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 27).toString()).intValue() == -1) {
            this.xmodelo1.setValueAt("", this.JTBDetalleAnalito.getSelectedRow(), 3);
            this.xmodelo1.setValueAt(0, this.JTBDetalleAnalito.getSelectedRow(), 24);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_InfoTrazabilidadActionPerformed(ActionEvent evt) {
        if (!this.JLBNRecepcion.getText().isEmpty()) {
            JDHistoricoTrazabilidad trazabilidad = new JDHistoricoTrazabilidad(null, true, Long.valueOf(this.JTBRecepcion.getValueAt(this.JTBRecepcion.getSelectedRow(), 5).toString()));
            trazabilidad.setLocationRelativeTo(this);
            trazabilidad.setVisible(true);
        }
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < this.JTBDetalleHc.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo3.getValueAt(i, 10).toString()).booleanValue()) {
                dataset.addValue(Double.parseDouble(this.xmodelo3.getValueAt(i, 6).toString()), "Resultado", this.xmodelo3.getValueAt(i, 2).toString());
            }
        }
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 1).toString().toUpperCase(), "Fecha", "Valores", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        NumberAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        LineAndShapeRenderer renderer = plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        return chart;
    }

    private void mCargarTipoResultado() {
        this.frmCR = new CapturarResultado(null, true, this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString(), this);
        this.frmCR.setVisible(true);
    }

    private void mCargarTipoResultadoD(int xtipoc, int xcoluma) {
        this.frmCRD = new JDResultadoDescriptivo(null, true, this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString(), this, xcoluma, xtipoc);
        this.frmCRD.setLocationRelativeTo(this);
        this.frmCRD.setVisible(true);
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xImplLabotaorio = (LaboratorioDAOImpl) classPathXmlApplicationContext.getBean("laboratorioDAOImpl");
        this.xImplHistoria = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
    }

    private void mNuevo() {
        this.directorio = new File(this.xmt.mRutaSoporte("JIFPlanillaTrabajo"));
        this.JTPDatosUsuario.setText("");
        this.JCBComentario.removeAllItems();
        this.JTPDescripcionC.setText("");
        this.JTF_NRecepcion.setText("");
        this.JDFechaC.setDate(this.xmt.getFechaActual());
        this.JTADescripcionSeguimiento.setText("");
        this.JCHEstadoC.setSelected(true);
        this.xEstadoC = 1;
        this.xEsRemitido = 0;
        this.xgrabarSeguimiento = 0;
        this.JDFechaS.setDate(this.xmt.getFechaActual());
        this.JTFSoporte.setText("");
        this.JCHEstadoS.setSelected(true);
        this.xEstadoS = 1;
        this.xgrabarSoporte = 0;
        mCrearModeloDetalleAnalito();
        mCrearModeloDetalleComentario();
        mCrearModeloDetalleHistorico();
        mCrearModeloSeguimientos();
        mCrearModeloSoportes();
        if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
            this.JLBNConsecutivo.setVisible(true);
        } else {
            this.JLBNConsecutivo.setVisible(false);
        }
        if (!Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JBTCerarHCBs1.setEnabled(false);
        }
    }

    private void mNuevoL() {
        this.JTPDatosUsuario.setText("");
        this.JCBComentario.removeAllItems();
        this.JTPDescripcionC.setText("");
        this.JLBNRecepcion.setText("");
        this.xidusuario = 0L;
        mCrearModeloDetalleAnalito();
        mCrearModeloDetalleComentario();
        mCrearModeloDetalleHistorico();
    }

    public void mAsignarResultaodReferencia(String idTipoPatologia) {
        this.idPatologia = idTipoPatologia;
        System.err.println("recibe" + this.idPatologia);
        if (this.JTBDetalleAnalito.getRowCount() != -1) {
            for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
                if (!Boolean.valueOf(this.xmodelo1.getValueAt(x, 9).toString()).booleanValue()) {
                    List<GenericoDTO> list = this.xImplLabotaorio.listTipoResultadoporDefectoPorPatologia(Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), this.idPatologia, this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString());
                    if (!list.isEmpty()) {
                        this.xmodelo1.setValueAt(list.get(0).getNombre(), x, 3);
                        this.xmodelo1.setValueAt(list.get(0).getId(), x, 16);
                    } else {
                        this.xmodelo1.setValueAt("", x, 3);
                    }
                }
            }
        }
    }

    private void mGrabarComentarioProcedimiento(int numeroFila) {
        List<Object[]> listComentarioProcedimiento;
        if (this.xmodelo1.getValueAt(numeroFila, 37) != null) {
            List<Object[]> list = this.xImplLabotaorio.listComentariosProcedimientoMaquinaResultado(this.xmodelo1.getValueAt(numeroFila, 11).toString(), this.xmodelo1.getValueAt(numeroFila, 37).toString(), this.JLBNRecepcion.getText());
            if ((list == null || list.isEmpty()) && ((listComentarioProcedimiento = this.xImplLabotaorio.listComentariosProcedimientoMaquina(this.xmodelo1.getValueAt(numeroFila, 11).toString(), this.xmodelo1.getValueAt(numeroFila, 37).toString())) != null || !listComentarioProcedimiento.isEmpty())) {
                for (int x = 0; x < listComentarioProcedimiento.size(); x++) {
                    System.out.println("Descripcion: " + listComentarioProcedimiento.get(x)[1].toString());
                    System.out.println("Nombre Maquina: " + listComentarioProcedimiento.get(x)[2].toString());
                    System.out.println("No. Orden: " + listComentarioProcedimiento.get(x)[3].toString());
                    this.xImplLabotaorio.addComentarioArea(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(numeroFila, 11).toString()), new Long(0L), listComentarioProcedimiento.get(x)[1].toString(), Integer.valueOf(listComentarioProcedimiento.get(x)[3].toString()), listComentarioProcedimiento.get(x)[2].toString());
                }
            }
            mCargarDetalleComentario();
        }
    }

    public void mCargarRecepcion() {
        List<RecepcionDTO> list = null;
        if (this.JTF_NRecepcion.getText().isEmpty()) {
            if (this.JRBFTodas.isSelected()) {
                if (this.xparametrop.getAplicaFiltroMunicipio().equals("0")) {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 0, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 0, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 0, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                } else {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 0, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 0, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 0, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                }
            } else if (this.JRBFPValidado.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    if (this.xparametrop.getAplicaFiltroMunicipio().equals("0")) {
                        switch (this.xparametrop.getFiltro()) {
                            case "0":
                                list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 2, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                            case "1":
                                list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 2, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                            case "2":
                                list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 2, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                        }
                    } else {
                        switch (this.xparametrop.getFiltro()) {
                            case "0":
                                list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 2, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                            case "1":
                                list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 2, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                            case "2":
                                list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 2, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                                break;
                        }
                    }
                } else if (this.xparametrop.getAplicaFiltroMunicipio().equals("0")) {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                } else {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                }
            } else if (this.JRBValidado.isSelected()) {
                if (this.xparametrop.getAplicaFiltroMunicipio().equals("0")) {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 1, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 1, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 1, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                } else {
                    switch (this.xparametrop.getFiltro()) {
                        case "0":
                            list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 1, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "1":
                            list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 1, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                        case "2":
                            list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 1, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                            break;
                    }
                }
            } else if (this.xparametrop.getAplicaFiltroMunicipio().equals("0")) {
                switch (this.xparametrop.getFiltro()) {
                    case "0":
                        list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                    case "1":
                        list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                    case "2":
                        list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                }
            } else {
                switch (this.xparametrop.getFiltro()) {
                    case "0":
                        list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                    case "1":
                        list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                    case "2":
                        list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), this.xparametrop.getLugarProcesamiento(), this.xparametrop.getEsRemitido(), this.xparametrop.getProcedimientoarea(), 1, 0, this.xparametrop.getMunicipio(), this.xparametrop.getAplicaFiltroServicio(), this.xparametrop.getServicio());
                        break;
                }
            }
        } else {
            list = this.xImplLabotaorio.listRecepcionId(this.JTF_NRecepcion.getText());
        }
        mCrearModeloRecepcion();
        mNuevoL();
        int xtrecepcion = 0;
        int xtanalitos = 0;
        String fechaActualConcatenada = this.xmt.formatoAMD_Unida.format(this.xmt.getFechaActual());
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo4.addRow(this.xdatos);
            this.xmodelo4.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo4.setValueAt(list.get(x).getNPrioridad(), x, 1);
            if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                if (!list.get(x).getFechaRecepcionConcatenada().equals(fechaActualConcatenada)) {
                    String[] partes = list.get(x).getNconsecutivo().split("-");
                    if (partes.length == 2) {
                        String formatted = String.format("%03d", Integer.valueOf(partes[0]));
                        this.xmodelo4.setValueAt(list.get(x).getFechaRecepcionConcatenada() + "" + formatted + "-" + partes[1], x, 2);
                    } else {
                        String formatted2 = String.format("%03d", list.get(x).getNconsecutivo());
                        this.xmodelo4.setValueAt(list.get(x).getFechaRecepcionConcatenada() + "" + formatted2, x, 2);
                    }
                } else {
                    this.xmodelo4.setValueAt(list.get(x).getNconsecutivo(), x, 2);
                }
            } else {
                this.xmodelo4.setValueAt(list.get(x).getNRecepcion(), x, 2);
            }
            this.xmodelo4.setValueAt(list.get(x).getNuevaMuestra(), x, 3);
            this.xmodelo4.setValueAt(list.get(x).getIdOrdenExterna(), x, 4);
            this.xmodelo4.setValueAt(list.get(x).getIdIngreso(), x, 5);
            this.JTBRecepcion.setDefaultRenderer(Object.class, new MiRender2());
            xtrecepcion++;
            xtanalitos = (int) (((long) xtanalitos) + list.get(x).getCantidad().longValue());
        }
        this.JTBRecepcion.setModel(this.xmodelo4);
        this.JLBNTRecepcion.setText("" + xtrecepcion);
        this.JLBNAnalitos.setText("" + xtanalitos);
    }

    public void mCargarRecepcion_nuevo() {
        List<RecepcionDTO> list;
        if (this.JTF_NRecepcion.getText().isEmpty()) {
            String filtro = this.xparametrop.getFiltro();
            String municipio = this.xparametrop.getMunicipio();
            String procedimientoArea = this.xparametrop.getProcedimientoarea();
            String servicio = this.xparametrop.getServicio();
            String lugarProcesamiento = this.xparametrop.getLugarProcesamiento();
            String esRemitido = this.xparametrop.getEsRemitido();
            String aplicaFiltroServicio = this.xparametrop.getAplicaFiltroServicio();
            String aplicaFiltroMunicipio = this.xparametrop.getAplicaFiltroMunicipio();
            if (this.JRBFTodas.isSelected()) {
                list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 0, 0);
            } else if (this.JRBFPPorGrabar.isSelected()) {
                if (esLaboratorioValidado()) {
                    list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 0);
                } else {
                    list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 0);
                }
            } else if (this.JRBFPValidado.isSelected()) {
                if (esLaboratorioValidado()) {
                    list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 1);
                } else {
                    list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 0);
                }
            } else if (this.JRBValidado.isSelected()) {
                list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 2);
            } else {
                list = obtenerListaRecepcionPorFiltro(filtro, municipio, procedimientoArea, servicio, lugarProcesamiento, esRemitido, aplicaFiltroServicio, aplicaFiltroMunicipio, 1, 0);
            }
        } else {
            list = this.xImplLabotaorio.listRecepcionId(this.JTF_NRecepcion.getText());
        }
        cargarDatosEnInterfaz(list);
    }

    private List<RecepcionDTO> obtenerListaRecepcionPorFiltro(String filtro, String municipio, String procedimientoArea, String servicio, String lugarProcesamiento, String esRemitido, String aplicaFiltroServicio, String aplicaFiltroMunicipio, int valor1, int valor2) {
        List<RecepcionDTO> list = null;
        if (aplicaFiltroMunicipio.equals("0")) {
            switch (filtro) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionPlanillaC(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, Integer.valueOf(valor1), Integer.valueOf(valor2), aplicaFiltroServicio, servicio);
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionPlanillaArea(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, procedimientoArea, Integer.valueOf(valor1), Integer.valueOf(valor2), aplicaFiltroServicio, servicio);
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionPlanillaProcedimiento(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, procedimientoArea, Integer.valueOf(valor1), Integer.valueOf(valor2), aplicaFiltroServicio, servicio);
                    break;
            }
        } else {
            switch (filtro) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionPlanillaCMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, Integer.valueOf(valor1), Integer.valueOf(valor2), municipio, aplicaFiltroServicio, servicio);
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionPlanillaAreaMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, procedimientoArea, Integer.valueOf(valor1), Integer.valueOf(valor2), municipio, aplicaFiltroServicio, servicio);
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionPlanillaProcedimientoMunicipio(this.xparametrop.getFechaInicial(), this.xparametrop.getFechaFinal(), lugarProcesamiento, esRemitido, procedimientoArea, Integer.valueOf(valor1), Integer.valueOf(valor2), municipio, aplicaFiltroServicio, servicio);
                    break;
            }
        }
        return list;
    }

    private void cargarDatosEnInterfaz(List<RecepcionDTO> list) {
        mCrearModeloRecepcion();
        mNuevoL();
        int xtrecepcion = 0;
        int xtanalitos = 0;
        String fechaActualConcatenada = this.xmt.formatoAMD_Unida.format(this.xmt.getFechaActual());
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo4.addRow(this.xdatos);
            this.xmodelo4.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo4.setValueAt(list.get(x).getNPrioridad(), x, 1);
            if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue() && !list.get(x).getFechaRecepcionConcatenada().equals(fechaActualConcatenada)) {
                String[] partes = list.get(x).getNconsecutivo().split("-");
                String formatted = partes.length == 2 ? String.format("%03d", Integer.valueOf(partes[0])) : String.format("%03d", list.get(x).getNconsecutivo());
                this.xmodelo4.setValueAt(list.get(x).getFechaRecepcionConcatenada() + formatted + "-" + partes[1], x, 2);
            } else {
                this.xmodelo4.setValueAt(list.get(x).getId(), x, 2);
            }
            this.xmodelo4.setValueAt(list.get(x).getNuevaMuestra(), x, 3);
            this.xmodelo4.setValueAt(list.get(x).getIdOrdenExterna(), x, 4);
            this.xmodelo4.setValueAt(list.get(x).getIdIngreso(), x, 5);
            xtrecepcion++;
            xtanalitos = (int) (((long) xtanalitos) + list.get(x).getCantidad().longValue());
        }
        this.JTBRecepcion.setModel(this.xmodelo4);
        this.JLBNTRecepcion.setText(String.valueOf(xtrecepcion));
        this.JLBNAnalitos.setText(String.valueOf(xtanalitos));
    }

    private boolean esLaboratorioValidado() {
        String nombreIps = Principal.informacionIps.getNombreIps();
        return nombreIps.equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || nombreIps.equals("BIOMED VIDA IPS S.A.S");
    }

    private int[] obtenerValidadoYTpo() {
        int validado = 0;
        int tipo = 0;
        if (this.JRBFTodas.isSelected()) {
            validado = 0;
            tipo = 0;
        } else if (this.JRBFPPorGrabar.isSelected()) {
            validado = 0;
            tipo = 1;
        } else if (this.JRBFPValidado.isSelected()) {
            validado = 1;
            tipo = 1;
        } else if (this.JRBValidado.isSelected()) {
            validado = 2;
            tipo = 1;
        }
        return new int[]{validado, tipo};
    }

    private List<RecepcionDetalleDTO> obtenerListaRecepcionDetalle(String recepcionText, int validado, int tipo, int esRemitido) {
        System.err.println("validado" + validado);
        System.err.println("estado" + tipo);
        switch (this.xparametrop.getFiltro()) {
            case "0":
                return this.xImplLabotaorio.listRecepcionDetalle(recepcionText, Integer.valueOf(tipo), Integer.valueOf(validado), Integer.valueOf(esRemitido));
            case "1":
                return this.xImplLabotaorio.listRecepcionDetalleArea(recepcionText, this.xparametrop.getProcedimientoarea(), Integer.valueOf(tipo), Integer.valueOf(validado), Integer.valueOf(esRemitido));
            case "2":
                return this.xImplLabotaorio.listRecepcionDetalleIdProcedimiento(recepcionText, this.xparametrop.getProcedimientoarea(), Integer.valueOf(tipo), Integer.valueOf(validado), Integer.valueOf(esRemitido));
            default:
                return new ArrayList();
        }
    }

    private void mCargarDetalleRecepcion_NUevo() {
        List<RecepcionDetalleDTO> list = null;
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            int[] validadoYTipo = obtenerValidadoYTpo();
            int validado = validadoYTipo[0];
            int estado = validadoYTipo[1];
            int esRemitido = Integer.parseInt(this.xparametrop.getEsRemitido());
            list = obtenerListaRecepcionDetalle(this.JLBNRecepcion.getText(), validado, estado, esRemitido);
        } else if (this.JRBFTodas.isSelected()) {
            switch (this.xparametrop.getFiltro()) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionDetalle(this.JLBNRecepcion.getText(), 0, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionDetalleArea(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 0, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionDetalleIdProcedimiento(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 0, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
            }
        } else if (this.JRBFPValidado.isSelected()) {
            switch (this.xparametrop.getFiltro()) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionDetalle(this.JLBNRecepcion.getText(), 1, 2, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionDetalleArea(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 2, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionDetalleIdProcedimiento(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 2, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
            }
        } else if (this.JRBValidado.isSelected()) {
            switch (this.xparametrop.getFiltro()) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionDetalle(this.JLBNRecepcion.getText(), 1, 1, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionDetalleArea(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 1, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionDetalleIdProcedimiento(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 1, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
            }
        } else {
            switch (this.xparametrop.getFiltro()) {
                case "0":
                    list = this.xImplLabotaorio.listRecepcionDetalle(this.JLBNRecepcion.getText(), 1, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "1":
                    list = this.xImplLabotaorio.listRecepcionDetalleArea(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
                case "2":
                    list = this.xImplLabotaorio.listRecepcionDetalleIdProcedimiento(this.JLBNRecepcion.getText(), this.xparametrop.getProcedimientoarea(), 1, 0, Integer.valueOf(this.xparametrop.getEsRemitido()));
                    break;
            }
        }
        if (!list.isEmpty()) {
            mNuevoL();
            this.xidusuario = list.get(0).getIdPaciente().longValue();
            this.nombrePaciente = list.get(0).getUUsuario();
            this.nombreSede = list.get(0).getNSede();
            this.xcorreousuario = "";
            this.xcorreomedico = "";
            Principal.txtNo.setText("" + list.get(0).getIdRecepcion());
            this.JLBNRecepcion.setText("" + list.get(0).getIdRecepcion());
            String xnombre = "<font face='Arial' color='red' size=5>" + list.get(0).getUUsuario() + "           Fecha: " + list.get(0).getFRecepcion() + "</font><br>";
            System.out.println("-->" + xnombre);
            System.out.println("-->" + list.get(0).getUUsuario());
            String xNMunicipio = "<font face='Arial' color='red' size=4>" + list.get(0).getUMunicipio() + "</font><br>";
            String xNEmpresa = "<font face='Arial' color='red' size=4>" + list.get(0).getUEmpresaUsuario() + "</font>";
            String xNSede = "<font face='Arial' color='red' size=4>" + list.get(0).getNSede() + "</font>";
            consultarCorreo();
            String correo = "";
            if (this.envioCorreo && Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                correo = "SOLICITADO";
            }
            this.JTPDatosUsuario.setText(xnombre + " <font face='Arial' color='black' size=4>DOCUMENTO : " + list.get(0).getUDocumento() + "<font face='Arial' color='black' size=4>    SEXO : " + list.get(0).getUIdSexo() + "  EDAD : " + list.get(0).getUEdad() + "<br>TELEFONO: " + list.get(0).getUTelefono() + "<br><br>      PROFESIONAL : " + list.get(0).getUProfesional() + "<br>DX : " + list.get(0).getUPatologia() + "<br><font face='Arial' color='red' size=5>" + list.get(0).getObservacionRecepcion() + "</font><br>SEDE : " + xNSede + "</font>   MUNICIPIO : " + xNMunicipio + "</font>ENTIDAD : " + xNEmpresa + "<br><font face='Arial' color='blue' size=4> ¿ENVIAR RESULTADO POR CORREO? :" + correo + "<br>");
            this.envioCorreo = false;
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                List<ExamenFisicoDTO> list1 = this.xImplHistoria.listExamenFisicoIdUsuarioUltimo(list.get(0).getIdPaciente());
                if (list1.size() > 0) {
                    this.JTFFSPeso1.setValue(list1.get(0).getPeso());
                    this.JTFFSTalla1.setValue(list1.get(0).getTalla());
                    this.JTFFSPerimetroAbd1.setValue(list1.get(0).getPAbdominal());
                    mCalcularImc();
                    mCalcularSCorporal();
                }
            } else {
                this.JTFFSPeso1.setValue(list.get(0).getPeso());
                this.JTFFSTalla1.setValue(list.get(0).getTalla());
                this.JTFFSIMC1.setValue(list.get(0).getImc());
                this.JTFFSPerimetroAbd1.setValue(list.get(0).getPAbdominal());
                this.JTFFSCorporal1.setValue(list.get(0).getSCorporal());
                mCalcularImc();
                mCalcularSCorporal();
            }
            this.xcorreousuario = list.get(0).getUCorreoUsuario();
            this.xcorreomedico = list.get(0).getCorreoMedico();
            this.xedad = list.get(0).getUEdadCalculada().intValue();
            this.xsexo = list.get(0).getUIdSexo();
            String xnombrep = "";
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL SAN JUAN DE SAHAGUN") || Principal.informacionIps.getNombreIps().equals("UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("FUNDACION UNIONVIDA")) {
                this.xmt.mEstablecerTextEditor(this.JTBDetalleAnalito, 1);
            }
            int y = 0;
            for (int x = 0; x < list.size(); x++) {
                if (Principal.informacionIps.getAplicaEncabezadoPlanillaLaboratorio().booleanValue() && !xnombrep.equals(list.get(x).getNProcedimiento())) {
                    xnombrep = list.get(x).getNProcedimiento();
                    this.xmodelo1.addRow(this.xDatosResultados);
                    this.xmodelo1.setValueAt(-100, y, 0);
                    this.xmodelo1.setValueAt(list.get(x).getNProcedimiento(), y, 1);
                    this.xmodelo1.setValueAt("", y, 3);
                    this.xmodelo1.setValueAt(1, y, 32);
                    this.xmodelo1.setValueAt("", y, 6);
                    this.xmodelo1.setValueAt("", y, 7);
                    this.xmodelo1.setValueAt(false, y, 8);
                    this.xmodelo1.setValueAt(true, y, 9);
                    this.xmodelo1.setValueAt(list.get(x).getIdProcedimiento(), y, 11);
                    this.xmodelo1.setValueAt(0, y, 18);
                    this.xmodelo1.setValueAt(false, y, 26);
                    this.xmodelo1.setValueAt(false, y, 33);
                    this.xmodelo1.setValueAt(false, y, 35);
                    this.xmodelo1.setValueAt("", y, 36);
                    this.xmodelo1.setValueAt("", y, 43);
                    y++;
                }
                this.xmodelo1.addRow(this.xDatosResultados);
                this.xmodelo1.setValueAt(list.get(x).getIdProtocoloProc(), y, 0);
                this.xmodelo1.setValueAt(list.get(x).getNProtocolo(), y, 1);
                this.xmodelo1.setValueAt(list.get(x).getVandera(), y, 2);
                this.xmodelo1.setValueAt(list.get(x).getVResultado(), y, 3);
                this.xmodelo1.setValueAt(list.get(x).getVResultadoA(), y, 4);
                this.xmodelo1.setValueAt(list.get(x).getUnidadMed(), y, 5);
                this.xmodelo1.setValueAt(list.get(x).getValorRefMin(), y, 6);
                this.xmodelo1.setValueAt(list.get(x).getValorRefMax(), y, 7);
                this.xmodelo1.setValueAt(list.get(x).getAlterado(), y, 8);
                this.xmodelo1.setValueAt(list.get(x).getValidado(), y, 9);
                this.xmodelo1.setValueAt(list.get(x).getImpreso(), y, 10);
                this.xmodelo1.setValueAt(list.get(x).getIdProcedimiento(), y, 11);
                this.xmodelo1.setValueAt(list.get(x).getIdRecepcion(), y, 12);
                this.xmodelo1.setValueAt(list.get(x).getIdPaciente(), y, 13);
                this.xmodelo1.setValueAt(list.get(x).getUEdadCalculada(), y, 14);
                this.xmodelo1.setValueAt(list.get(x).getUIdSexo(), y, 15);
                this.xmodelo1.setValueAt(list.get(x).getIdTipoResultado(), y, 16);
                this.xmodelo1.setValueAt(list.get(x).getObservacion(), y, 17);
                this.xmodelo1.setValueAt(list.get(x).getIdResultado(), y, 18);
                this.xmodelo1.setValueAt(list.get(x).getIdOrdenFac(), y, 19);
                this.xmodelo1.setValueAt(list.get(x).getIdArea(), y, 20);
                this.xmodelo1.setValueAt(list.get(x).getIdTipoResultado(), y, 21);
                this.xmodelo1.setValueAt(list.get(x).getAResultado(), y, 22);
                this.xmodelo1.setValueAt(list.get(x).getAplicaFormula(), y, 23);
                this.xmodelo1.setValueAt(list.get(x).getIdSql(), y, 24);
                this.xmodelo1.setValueAt(false, y, 25);
                this.xmodelo1.setValueAt(false, y, 26);
                this.xmodelo1.setValueAt(list.get(x).getValidadoProtoc(), y, 27);
                this.xmodelo1.setValueAt(list.get(x).getCExamen(), y, 28);
                this.xmodelo1.setValueAt(list.get(x).getValorRefMin(), y, 29);
                this.xmodelo1.setValueAt(list.get(x).getValorRefMax(), y, 30);
                this.xmodelo1.setValueAt(list.get(x).getVConstante(), y, 31);
                this.xmodelo1.setValueAt(0, y, 32);
                this.xmodelo1.setValueAt(list.get(x).getValidadoRecepcion(), y, 33);
                this.xmodelo1.setValueAt(list.get(x).getNOrdenProtocolo(), y, 34);
                this.xmodelo1.setValueAt(list.get(x).getEsRemitido(), y, 35);
                this.xmodelo1.setValueAt(list.get(x).getIdRemision(), y, 36);
                this.xmodelo1.setValueAt(list.get(x).getNombreAnalizador(), y, 37);
                this.xmodelo1.setValueAt(list.get(x).getTipoMuestra(), y, 38);
                this.xmodelo1.setValueAt(list.get(x).getFechaResultado(), y, 39);
                this.xmodelo1.setValueAt(list.get(x).getFechaValidado(), y, 40);
                this.xmodelo1.setValueAt("", y, 41);
                this.xmodelo1.setValueAt(Integer.valueOf(list.get(x).getComentarioResultado()), y, 42);
                this.xmodelo1.setValueAt(list.get(x).getFormula(), y, 43);
                this.JTBDetalleAnalito.setDefaultRenderer(Object.class, new MiRender1());
                y++;
            }
            return;
        }
        mCrearModeloDetalleAnalito();
        mCrearModeloDetalleComentario();
        mCrearModeloDetalleHistorico();
    }

    private String generarRecepcionProtocolo(boolean aplicaConsecutivo, String nConsecutivo, String idRecepcion) {
        if (aplicaConsecutivo) {
            return nConsecutivo;
        }
        return idRecepcion;
    }

    private void actualizarModelo(DefaultTableModel modelo, int row, GenericoDTO resultado) {
        modelo.setValueAt(resultado.getNombre(), row, 3);
        modelo.setValueAt(resultado.getNAnalizador(), row, 37);
        if (!resultado.getMedida().isEmpty()) {
            modelo.setValueAt(resultado.getMedida(), row, 5);
        }
        if (!resultado.getRefMin().isEmpty()) {
            modelo.setValueAt(resultado.getRefMin(), row, 6);
        }
        if (!resultado.getRefMax().isEmpty()) {
            modelo.setValueAt(resultado.getRefMax(), row, 7);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalleAnalito() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"IdProtoclo", "Protocolo", "TipoResultado", "Resultado", "ResultadoA", "UnidadM", "V/Mímino", "V/Máximo", "Alterado?", "Validado?", "Impreso", "IdProcedimiento", "IdUsuario", "IdRecepcion", "Edad", "Sexo", "IdTipoResultado", "Observación", "IdResultado", "IdOrdenFac", "IdArea", "IdTipoResultado", "AplicaResultado", "AplicaFormula", "IdSql", "Imprime?", "I", "ValidadoProtoco", "NExamen", "VMinimo", "VMaximo", "VCostante", "Titulo", "Valid Recepcion", "OrdenProtocolo", "EsRemitido", "IdRemision", "NEquipoT", "TipoMuestra", "Fecha Grabado", "Fecha Validado", "Codigo Interfaz", "ComentarioResultado", "Formula"}) { // from class: Laboratorio.JIFPlanillaTrabajo.49
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Boolean.class, Boolean.class, Long.class, Boolean.class, Boolean.class, Integer.class, Integer.class, String.class, String.class, Double.class, Long.class, Boolean.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, true, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalleAnalito;
        JTable jTable2 = this.JTBDetalleAnalito;
        jTable.setAutoResizeMode(0);
        this.JTBDetalleAnalito.doLayout();
        this.JTBDetalleAnalito.setModel(this.xmodelo1);
        this.JTBDetalleAnalito.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalleAnalito.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTBDetalleAnalito.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTBDetalleAnalito.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTBDetalleAnalito.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTBDetalleAnalito.getColumnModel().getColumn(7).setPreferredWidth(70);
        this.JTBDetalleAnalito.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTBDetalleAnalito.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.JTBDetalleAnalito.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTBDetalleAnalito.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(17).setPreferredWidth(60);
        this.JTBDetalleAnalito.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTBDetalleAnalito.getColumnModel().getColumn(26).setPreferredWidth(20);
        this.JTBDetalleAnalito.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTBDetalleAnalito.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(35).setPreferredWidth(40);
        this.JTBDetalleAnalito.getColumnModel().getColumn(36).setPreferredWidth(40);
        this.JTBDetalleAnalito.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.JTBDetalleAnalito.getColumnModel().getColumn(38).setPreferredWidth(120);
        this.JTBDetalleAnalito.getColumnModel().getColumn(39).setPreferredWidth(120);
        this.JTBDetalleAnalito.getColumnModel().getColumn(40).setPreferredWidth(120);
        this.JTBDetalleAnalito.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTBDetalleAnalito.getColumnModel().getColumn(42).setPreferredWidth(100);
        this.JTBDetalleAnalito.getColumnModel().getColumn(43).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalleComentario() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdComentario", "Nombre", "Descripción", "Orden"}) { // from class: Laboratorio.JIFPlanillaTrabajo.50
            Class[] types = {Long.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleComentario.setModel(this.xmodelo2);
        this.JTBDetalleComentario.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleComentario.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleComentario.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleComentario.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalleComentario.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDetalleComentario.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.xfilac = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRecepcion() {
        this.xmodelo4 = new DefaultTableModel(new Object[0], new String[]{"", "Tipo", "", "Nueva Muestra", "idOdenExterna", "idIngreso"}) { // from class: Laboratorio.JIFPlanillaTrabajo.51
            Class[] types = {String.class, Long.class, String.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBRecepcion.setModel(this.xmodelo4);
        this.JTBRecepcion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBRecepcion.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBRecepcion.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalleHistorico() {
        this.xmodelo3 = new DefaultTableModel(new Object[0], new String[]{"IdProtocolo", "IdResultado", "Fecha", "Protocolo", "VRef1", "VRef2", "Resultado", "Especialidad", "Profesional", "Alterado?", "Agregar?"}) { // from class: Laboratorio.JIFPlanillaTrabajo.52
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleHc.setModel(this.xmodelo3);
        this.JTBDetalleHc.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTBDetalleHc.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalleHc.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBDetalleHc.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalleHc.getColumnModel().getColumn(10).setPreferredWidth(5);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSeguimientos() {
        this.xmodelo5 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Descripcion", "Estado"}) { // from class: Laboratorio.JIFPlanillaTrabajo.53
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo5);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDetalleSeguimientos() {
        mCrearModeloSeguimientos();
        List<DetalleRecepcionComentarioDTO> list = this.xImplLabotaorio.listSeguimientos(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
        this.xmt.mEstablecerTextEditor(this.JTDetalleC, 2);
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo5.addRow(this.xdatos);
                this.xmodelo5.setValueAt(list.get(x).getId(), x, 0);
                this.xmodelo5.setValueAt(list.get(x).getFecha(), x, 1);
                this.xmodelo5.setValueAt(list.get(x).getDescripcion(), x, 2);
                if (list.get(x).getEstado() == 1) {
                    this.xmodelo5.setValueAt(true, x, 3);
                } else {
                    this.xmodelo5.setValueAt(false, x, 3);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSoportes() {
        this.xmodelo6 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Soporte", "Estado"}) { // from class: Laboratorio.JIFPlanillaTrabajo.54
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleS.setModel(this.xmodelo6);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDetalleSoportes() {
        mCrearModeloSoportes();
        List<DetalleRecepcionSoporteDTO> list = this.xImplLabotaorio.listSoportes(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo6.addRow(this.xdatos);
                this.xmodelo6.setValueAt(list.get(x).getId(), x, 0);
                this.xmodelo6.setValueAt(list.get(x).getFecha(), x, 1);
                this.xmodelo6.setValueAt(list.get(x).getSoporte(), x, 2);
                if (list.get(x).getEstado() == 1) {
                    this.xmodelo6.setValueAt(true, x, 3);
                } else {
                    this.xmodelo6.setValueAt(false, x, 3);
                }
            }
        }
    }

    private int mBuscarTipoResultado(String xid) {
        int xtipo = 0;
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT  `l_tiporesultado`.`Vandera` FROM `l_protocoloxtiporesultado` INNER JOIN  `l_protocolos`  ON (`l_protocoloxtiporesultado`.`Id_Protocolo` = `l_protocolos`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) INNER JOIN  `l_tiporesultado`  ON (`l_protocoloxtiporesultado`.`Id_TipoResultado` = `l_tiporesultado`.`Id`) WHERE (`l_protocoloxprocedimiento`.`Id` ='" + xid + "') ";
        System.out.println("resultado : " + this.xsql);
        ResultSet xrs1 = xct1.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xtipo = xrs1.getInt(1);
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xtipo;
    }

    public void mAsignarResultado(String nbreResul, String codigo, boolean xalt) {
        this.xmodelo1.setValueAt(nbreResul, this.JTBDetalleAnalito.getSelectedRow(), 3);
        this.xmodelo1.setValueAt(codigo, this.JTBDetalleAnalito.getSelectedRow(), 16);
        this.xmodelo1.setValueAt(Boolean.valueOf(xalt), this.JTBDetalleAnalito.getSelectedRow(), 8);
    }

    public void mAsignarResultado(String nbreResul, String codigo, boolean xalt, String vInterfaz) {
        this.xmodelo1.setValueAt(nbreResul, this.JTBDetalleAnalito.getSelectedRow(), 3);
        this.xmodelo1.setValueAt(codigo, this.JTBDetalleAnalito.getSelectedRow(), 16);
        this.xmodelo1.setValueAt(Boolean.valueOf(xalt), this.JTBDetalleAnalito.getSelectedRow(), 8);
        this.xmodelo1.setValueAt(vInterfaz, this.JTBDetalleAnalito.getSelectedRow(), 41);
    }

    private boolean mVerificarDatosParaGrabar() {
        boolean xestado = false;
        for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
            String valor32 = this.xmodelo1.getValueAt(x, 32).toString();
            String valor33 = this.xmodelo1.getValueAt(x, 33).toString();
            String valor3 = this.xmodelo1.getValueAt(x, 3).toString().trim();
            String valor9 = this.xmodelo1.getValueAt(x, 9).toString();
            boolean condicion32 = Long.valueOf(valor32).longValue() == 0;
            boolean condicion3NoVacio = !valor3.isEmpty();
            boolean condicion33 = !Boolean.valueOf(valor33).booleanValue();
            boolean condicion9 = !Boolean.valueOf(valor9).booleanValue();
            if (condicion32 && condicion3NoVacio) {
                if (condicion33 || condicion9) {
                    xestado = true;
                    break;
                }
                if (!condicion33 || !condicion9) {
                    xestado = true;
                    break;
                }
            } else {
                System.out.println("  No se cumplieron las condiciones principales");
            }
        }
        return xestado;
    }

    private void mGrabar() {
        if (mVerificarDatosParaGrabar()) {
            switch (Principal.usuarioSistemaDTO.getAutorizacionLaboratorio().intValue()) {
                case 0:
                    if (this.JBTValidar.getText().equals("Grabar")) {
                        mOpcGrabar();
                    } else {
                        mOpcValidar();
                    }
                    mCargarInformacion();
                    this.xGrabo = false;
                    break;
                case 1:
                    mOpcGrabar();
                    mCargarInformacion();
                    break;
                case 2:
                    if (this.JBTValidar.getText().equals("Grabar")) {
                        mOpcGrabar();
                    } else {
                        mOpcValidar();
                    }
                    this.xGrabo = false;
                    mCargarInformacion();
                    break;
                case 3:
                    if (this.JBTValidar.getText().equals("Grabar")) {
                        mOpcGrabar();
                    } else {
                        mOpcValidar();
                    }
                    this.xGrabo = false;
                    mCargarInformacion();
                    break;
                default:
                    JOptionPane.showInternalMessageDialog(this, "Este usuario no tiene autorización para ejecutar esta función", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    break;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No existe resultado para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mOpcGrabar() {
        String xnombrep = "";
        new LRecepcion();
        Long idResultado = null;
        for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
            if (Long.parseLong(this.xmodelo1.getValueAt(x, 32).toString()) == 0 && !this.xmodelo1.getValueAt(x, 3).toString().equals("")) {
                int xalterado = verificarProcedimientosAlterados(this.xmodelo1.getValueAt(x, 11).toString()).intValue();
                int ximpirme = Boolean.parseBoolean(this.xmodelo1.getValueAt(x, 25).toString()) ? 1 : 1;
                if (Integer.parseInt(this.xmodelo1.getValueAt(x, 27).toString()) == -1 && Long.valueOf(this.xmodelo1.getValueAt(x, 18).toString()).longValue() == 0) {
                    if (!xnombrep.equals(this.xmodelo1.getValueAt(x, 11).toString())) {
                        xnombrep = this.xmodelo1.getValueAt(x, 11).toString();
                        idResultado = this.xImplLabotaorio.addResultado(this.JLBNRecepcion.getText(), this.xmt.formatoAMD.format(this.xmt.getFechaActual()), "", Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), "0", "");
                        this.xImplLabotaorio.addResultadoDetalle(idResultado, this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), this.xmodelo1.getValueAt(x, 16).toString(), this.xmodelo1.getValueAt(x, 3).toString(), this.xmodelo1.getValueAt(x, 5).toString(), this.xmodelo1.getValueAt(x, 6).toString(), this.xmodelo1.getValueAt(x, 7).toString(), this.xmodelo1.getValueAt(x, 17).toString(), Integer.valueOf(Boolean.valueOf(this.JTBDetalleAnalito.getValueAt(x, 8).toString()).compareTo((Boolean) false)), Integer.valueOf(ximpirme), 0, this.xmodelo1.getValueAt(x, 37).toString(), this.xmodelo1.getValueAt(x, 41).toString());
                        mGrabarComentarioProcedimiento(x);
                        switch (Principal.informacionIps.getNombreIps()) {
                            case "LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.":
                                this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 1, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 0, 1);
                                break;
                            case "BIOMED VIDA IPS S.A.S":
                                this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 2, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 0, 1);
                                break;
                            case "UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS":
                                this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 2, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 0, 1);
                                break;
                            default:
                                this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 0, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 0, 1);
                                break;
                        }
                        this.xImplLabotaorio.updateDetalleResultadoHistorio(idResultado, Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        this.xImplLabotaorio.updateIdResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), idResultado);
                        this.xImplLabotaorio.updateIdResultadoOrdenFacturacion(idResultado, Long.valueOf(this.xmodelo1.getValueAt(x, 19).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()));
                        this.xGrabo = true;
                    } else {
                        this.xImplLabotaorio.addResultadoDetalle(idResultado, this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), this.xmodelo1.getValueAt(x, 16).toString(), this.xmodelo1.getValueAt(x, 3).toString(), this.xmodelo1.getValueAt(x, 5).toString(), this.xmodelo1.getValueAt(x, 6).toString(), this.xmodelo1.getValueAt(x, 7).toString(), this.xmodelo1.getValueAt(x, 17).toString(), Integer.valueOf(Boolean.valueOf(this.JTBDetalleAnalito.getValueAt(x, 8).toString()).compareTo((Boolean) false)), Integer.valueOf(ximpirme), 0, this.xmodelo1.getValueAt(x, 37).toString(), this.xmodelo1.getValueAt(x, 41).toString());
                        mGrabarComentarioProcedimiento(x);
                        this.xImplLabotaorio.updateDetalleResultadoHistorio(idResultado, Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        this.xImplLabotaorio.updateIdResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), idResultado);
                        this.xGrabo = true;
                    }
                }
            }
        }
        enviarNotificacion(this.JLBNRecepcion.getText());
    }

    private void grabarDatosSimedis(Long idOrden, Long idProtocolo, String fechaResultado, String valorResultado, int tipoGrabado, String observacion) {
        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
            try {
                String sql = "SELECT\n    l_protocoloxprocedimiento.`Id`\n    , `l_protocoloxprocedimiento`.`IdInfinity`, g_procedimiento.Id idCodigoCups\n   FROM\n    `l_detallerecepcion`\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE (`l_recepcion`.`Id` = " + idOrden + " AND  l_protocoloxprocedimiento.`Id`= " + idProtocolo + "\n    AND `l_protocoloxprocedimiento`.`Estado` =0 AND `l_protocoloxprocedimiento`.`IdInfinity`<>0)\n    ORDER BY `l_protocoloxprocedimiento`.`Orden` ASC";
                ResultSet rs = this.xct.getResultSet(sql);
                if (rs.next()) {
                    rs.first();
                    if (valorResultado != null && !valorResultado.isEmpty()) {
                        boolean esEncabezado = false;
                        if (rs.getLong("idCodigoCups") == rs.getLong("IdInfinity")) {
                            esEncabezado = true;
                        }
                        com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                        laboratorioDAOI.actualizarResultadoSimedis(idOrden, fechaResultado, valorResultado, Long.valueOf(rs.getLong("IdInfinity")), esEncabezado, observacion);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public Integer verificarProcedimientosAlterados(String idProcedimiento) {
        int estado = 0;
        if (this.JTBDetalleAnalito.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTBDetalleAnalito.getRowCount()) {
                    if (this.JTBDetalleAnalito.getValueAt(i, 0).toString().equals("-100") || !this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals(idProcedimiento) || !Boolean.valueOf(this.JTBDetalleAnalito.getValueAt(i, 8).toString()).booleanValue()) {
                        i++;
                    } else {
                        estado = 1;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Integer.valueOf(estado);
    }

    private void mOpcValidar() {
        Map<Long, Long> listaProcedimiento;
        System.out.println("entra met mOpcValidar");
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
        }
        listaProcedimiento = new HashMap<>();
        for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
            System.out.println(this.xmodelo1.getValueAt(x, 32).toString());
            if (Long.parseLong(this.xmodelo1.getValueAt(x, 32).toString()) == 0) {
                if (!this.xmodelo1.getValueAt(x, 3).toString().equals("")) {
                    int xalterado = verificarProcedimientosAlterados(this.xmodelo1.getValueAt(x, 11).toString()).intValue();
                    if (!Boolean.parseBoolean(this.xmodelo1.getValueAt(x, 25).toString())) {
                    }
                    if (Integer.parseInt(this.xmodelo1.getValueAt(x, 27).toString()) == 0 && Long.parseLong(this.xmodelo1.getValueAt(x, 18).toString()) != 0) {
                        this.xGrabo = false;
                        this.xImplLabotaorio.updateDetalleResultado(1, Long.valueOf(this.xmodelo1.getValueAt(x, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()));
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                            Long procedimientoId = Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString());
                            System.out.println("CODIGO PROCEDIMIENTO: " + procedimientoId);
                            if (!listaProcedimiento.containsKey(procedimientoId)) {
                                System.out.println("AGREGA EL CODIGO AL MAP: " + procedimientoId + " VALUE: " + Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()));
                                listaProcedimiento.put(procedimientoId, Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()));
                            }
                        }
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 2, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 2, 1);
                        } else {
                            this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 1, Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), 2, 1);
                        }
                        actualizacionEstadoProcedimientoLaboratorio(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(x, 12).toString())));
                        if (Principal.informacionIps.getIdentificacion().equals("900595873")) {
                            insertarTablaEnvioEntidades(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(x, 12).toString())));
                        }
                        this.xImplLabotaorio.updateDetalleResultadoHistorio(Long.valueOf(this.xmodelo1.getValueAt(x, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        this.xImplLabotaorio.updateIdResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(x, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 12).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 18).toString()));
                        this.xGrabo = true;
                        if (Integer.valueOf(this.xmodelo1.getValueAt(x, 28).toString()).intValue() != 0) {
                            List<GenericoDTO> list = this.xImplLabotaorio.listHistoricoResultadosProtocolo(Long.valueOf(this.xidusuario), Long.valueOf(this.JLBNRecepcion.getText()), Integer.valueOf(this.xmodelo1.getValueAt(x, 28).toString()));
                            for (int y = 0; y < list.size(); y++) {
                                this.xImplLabotaorio.addResultadoHistoricoGrafica(this.xmodelo1.getValueAt(x, 12).toString(), list.get(y).getIdResultado(), list.get(y).getIdProtooloProcedimiento());
                            }
                        }
                    }
                }
                switch (Principal.informacionIps.getNombreIps()) {
                    case "BIEN ESTAR SALUD BS S.A.S.":
                        mEjecutaTrasferenciaBs1(Long.valueOf(this.xmodelo4.getValueAt(this.JTBRecepcion.getSelectedRow(), 0).toString()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        break;
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE":
                        if (!Principal.informacionIps.getIdTipoIdentificacion().equals("NI") || !Principal.informacionIps.getIdentificacion().equals("891408918")) {
                            break;
                        } else {
                            mEjecutaTrasferenciaCNT(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                            break;
                        }
                        break;
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA":
                        mEjecutaTrasferenciaCNT(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        break;
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
                    case "ESE HOSPITAL JOSE MARIA CORDOBA":
                        mEjecutaTrasferenciaCNT(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        break;
                    case "E.S.E HOSPITAL HECTOR ABAD GOMEZ":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL":
                    case "E. S. E. HOSPITAL SAN RAFAEL":
                    case "E. S. E HOSPITAL SAN JUAN DE DIOS":
                        mEjecutaTrasferenciaXenco(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()));
                        break;
                    case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                    case "ZONAMEDICA MR S.A.S":
                        if (this.xmodelo1.getValueAt(x, 41).toString().isEmpty()) {
                            grabarDatosSimedis(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), this.xmodelo1.getValueAt(x, 3).toString(), 1, this.xmodelo1.getValueAt(x, 17).toString());
                            break;
                        } else {
                            grabarDatosSimedis(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(x, 0).toString()), this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), this.xmodelo1.getValueAt(x, 41).toString(), 1, this.xmodelo1.getValueAt(x, 17).toString());
                            break;
                        }
                        break;
                }
            }
        }
        enviarNotificacion(this.JLBNRecepcion.getText());
        switch (Principal.informacionIps.getNombreIps()) {
            case "HOSPITAL SAN VICENTE DE PAUL":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
            case "CLINICA SANTA CLARA SAS":
                mEjecutaTrasferenciaSIFAS(listaProcedimiento);
                break;
            case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
            case "CLINICA SAN FRANCISCO S.A.":
            case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                TransmisionXML(listaProcedimiento);
                break;
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            mActualizarMedicoBs1(this.JLBNRecepcion.getText());
        }
    }

    public void actualizacionEstadoProcedimientoLaboratorio(Long nRecepcion) {
        String sql1 = "\tupdate l_detallerecepcion, (\n\twith maestra as (\n\t\tselect ld.Id_Recepcion idRecepcion, ld.Id_Procedim idProcedimiento , count(lp.Id_Protocolo) cantidad \n\t\tfrom l_detallerecepcion ld \n\t\tinner join l_protocoloxprocedimiento lp on (lp.Id_Procedim=ld.Id_Procedim) and (lp.Estado=0)\n\t\twhere ld.Id_Recepcion =" + nRecepcion + " and lp.esObligatorio =1\n\t\tgroup by ld.Id_Recepcion , ld.Id_Procedim \n\t),\n\tresultado as (\n\t\tSELECT  ld.Id_Procedimiento idProcedimiento , count(lp.Id_Protocolo) numeroResultado\n\t\tfrom l_resultados lr \n\t\tinner join l_detalleresultado ld on (lr.Id=ld.Id_Resultado)\n\t\tinner join l_protocoloxprocedimiento lp on (lp.Id=ld.Id_ProtocolProcedim)\n\t\tinner join l_detallerecepcion ld2 on (ld2.Id_Recepcion=lr.Id_Recepcion) and (ld2.Id_Procedim=ld.Id_Procedimiento )\n\t\twhere lr.Id_Recepcion =" + nRecepcion + "   and lp.esObligatorio =1 and lr.Estado =0 and ld2.ValidadoLab =1\n\t\tgroup by lr.Id_Recepcion, ld.Id_Procedimiento \n\t)\n\tSELECT m.idRecepcion,  m.idProcedimiento, if(ifnull(r.numeroResultado, 0)=0,'PENDIENTE', if(m.cantidad=ifnull(r.numeroResultado, 0), 'COMPLETADO', 'PARCIALMENTE')) estado\n\tfrom maestra m\n\tleft join resultado r on (m.idProcedimiento=r.idProcedimiento)\n\t) d set l_detallerecepcion.validacionEstado =d.estado \n\twhere l_detallerecepcion.Id_Recepcion =d.idRecepcion and l_detallerecepcion.Id_Procedim =d.idProcedimiento";
        System.out.println("sql " + sql1);
        this.xct.ejecutarSQL(sql1);
        this.xct.cerrarConexionBd();
    }

    public void insertarTablaEnvioEntidades(Long nRecepcion) {
        String sql1 = "INSERT\n\tINTO\n\tl_bitacora_envio_entidades (               \n    idRecepcion,\n\tidProcedimiento,\n\tfecha,\n\tenvio, idUsuarioS)\nselect\n\tld.Id_Recepcion ,\n\tld.Id_Procedim ,\n\tnow(),\n\t0, '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'\nfrom\n\tl_recepcion lr\ninner join l_detallerecepcion ld on\n\t(lr.Id = ld.Id_Recepcion)\ninner join f_ordenes fo on\n\t(fo.Id = lr.Id_OrdenFacturac)\ninner join ingreso i on\n\t(i.Id = fo.Id_Ingreso)\n\tleft join l_bitacora_envio_entidades lb on (lb.idRecepcion=lr.Id) and (lb.idProcedimiento=ld.Id_Procedim) \nwhere\n\t((i.DxIngreso IN ('I10X', 'Z359', 'E119')\n\t\tor ld.Id_Procedim in (898001))\n\t\tand i.Id_EmpresaContxConv in (119, 65 , 11 , 10 , 118 , 49)\n\t\t\tand ld.ValidadoLab = 1\n\t\t\tand lr.Estado = 0\n\t\t\tand ld.Id_Recepcion = " + nRecepcion + "\n and lb.id  is null)";
        System.out.println("sql " + sql1);
        this.xct.ejecutarSQL(sql1);
        this.xct.cerrarConexionBd();
    }

    private void TransmisionXML(Map<Long, Long> listaProcedimiento) {
        for (Map.Entry<Long, Long> entrada : listaProcedimiento.entrySet()) {
            System.out.println("Entra al for: clave: " + entrada.getKey() + " Valor: " + entrada.getValue());
            String url = Principal.informacionIps.getEndPointGenomaEnvioOrdenExamen();
            System.out.println("Url: " + url);
            new ArrayList();
            com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
            List<DGLEnvioResultadosDTO> e = laboratorioDAOI.enviarDetalleResultadoDinamica(entrada.getKey(), entrada.getValue());
            System.out.println("tamaño de la lista: " + e.size());
            DGLResponseDTO response = (DGLResponseDTO) this.restTemplate.postForObject(url, e, DGLResponseDTO.class, new Object[0]);
            System.out.println("Mensaje: " + response.getMensaje() + " Exito: " + response.getExito() + " Error: " + response.getMensajeInterno());
            if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                if (response.getExito().booleanValue()) {
                    if (!e.isEmpty()) {
                        for (int i = 0; i < e.size(); i++) {
                            laboratorioDAOI.validacionResultadosDinamica(e.get(i).getConsecutivoOrden(), e.get(i).getExamenCodigo());
                        }
                    }
                    this.xImplLabotaorio.updateDatelleResultadoEnviado(Integer.valueOf(entrada.getValue().toString()).intValue(), entrada.getKey().longValue());
                }
            }
        }
    }

    private void mActualizarMedicoBs1(String idOrden) {
        try {
            String sql = "SELECT\n    `l_recepcion`.`Id`\n    , `f_ordenes`.`Id`\n    , `ingreso`.`Id`\n    , `ingreso`.`NoAutorizacion`\nFROM\n    `l_recepcion`\n    INNER JOIN `f_ordenes` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`l_recepcion`.`Id` ='" + idOrden + "');";
            System.out.println("RBS1" + sql);
            ResultSet rs = this.xct.getResultSet(sql);
            if (rs.next()) {
                rs.first();
                com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                laboratorioDAOI.actualizarMedicoBs1(rs.getString("NoAutorizacion"), Principal.usuarioSistemaDTO.getIdUsuarioBs1());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEjecutaTrasferenciaBs1(Long idOrden, Long idProtocolo) {
        try {
            String sql = " WITH setResultado AS (\n \n  SELECT\n   `l_recepcion`.`Id` idRecepcion\n   , `l_detallerecepcion`.`codigoEnvioBs1`\n   , `l_detalleresultado`.`Id_Procedimiento`\n   , `l_detalleresultado`.`Resultado`\n   , `l_detalleresultado`.`VrNumerico`\n   , `l_protocolos`.`Id` idProtocolo\n   , l_protocoloxtiporesultado.Codigo AS Codigo1\n   , l_protocoloxtiporesultado.`Id_TipoResultado` \n   , `l_protocolos`.`Nbre` AS nombreProtocolo\n   , `l_resultados`.`Id` AS idR\n   , ingreso.`NoAutorizacion`\n   , l_detalleresultado.`Observacion`\n   , l_protocoloxprocedimiento.`Id` AS idProtocoloResul\n   , l_resultados.`Id` idResultado\n  FROM\n     `f_ordenes`\n   INNER JOIN   `ingreso`     ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n   INNER JOIN   `l_recepcion`     ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n   INNER JOIN   `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n   INNER JOIN  `l_resultados`   ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n   INNER JOIN  `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n   AND (l_detalleresultado.`Id_Procedimiento`=l_detallerecepcion.`Id_Procedim`)\n   INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n   INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n   LEFT JOIN  `l_protocoloxtiporesultado` ON (`l_protocoloxtiporesultado`.`Id_Protocolo` = `l_protocolos`.`Id`)\n   AND l_protocoloxtiporesultado.`Id_TipoResultado`=l_detalleresultado.`Resultado`\n   WHERE `l_recepcion`.`Id`='" + idOrden + "'  \n   AND  l_protocoloxprocedimiento.`Id`='" + idProtocolo + "'\n \n ), setTipoResultado AS (\n   SELECT     \n   COUNT(l_protocoloxtiporesultado.`Id_TipoResultado`) contador    \n   , l_protocoloxtiporesultado.`Id_TipoResultado`  AS idTipoResul   \n   , l_protocoloxtiporesultado.`Id_Protocolo`        \n   , `l_protocoloxtiporesultado`.`Codigo` Codigo2  \n   , l_protocoloxprocedimiento.`Id` idProtocoloR \n   FROM  `baseserver`.`l_protocoloxprocedimiento`\n    INNER JOIN `baseserver`.`l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxtiporesultado` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocoloxtiporesultado`.`Id_Protocolo`)\n       WHERE  l_protocoloxprocedimiento.`Id`='" + idProtocolo + "'\n   GROUP BY l_protocoloxtiporesultado.`Id_Protocolo` , l_protocoloxtiporesultado.`Id_TipoResultado`\n )\n \n SELECT\n      setResultado.`idRecepcion`        \n   , `setResultado`.`codigoEnvioBs1`        \n   , `setResultado`.`Id_Procedimiento`        \n   , `setResultado`.`Resultado`        \n   , `setResultado`.`VrNumerico`        \n   , `setResultado`.`idProtocolo`        \n   , `setResultado`.`nombreProtocolo`         \n   , `setResultado`.idR   \n   , IF(IFNULL(setTipoResultado.contador,1)=1, setTipoResultado.idTipoResul,setResultado.`Id_TipoResultado`) Id_TipoResultado    \n   , IF(IFNULL(setTipoResultado.contador,1)=1, setTipoResultado.Codigo2,setResultado.Codigo1) Codigo    \n   , setResultado.`NoAutorizacion`\n   , setResultado.`Observacion`\n FROM setResultado\n LEFT JOIN setTipoResultado \n ON setResultado.idProtocoloResul=setTipoResultado.idProtocoloR  AND setResultado.Id_TipoResultado=setTipoResultado.idTipoResul";
            System.out.println("RBS1" + sql);
            ResultSet rs = this.xct.getResultSet(sql);
            if (rs.next()) {
                rs.first();
                com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                laboratorioDAOI.actualizarResultadoBs1(rs.getString("codigoEnvioBs1"), rs.getString("VrNumerico"), rs.getString("Codigo"), rs.getString("idR"), idProtocolo);
                if (!rs.getString("Observacion").equals("")) {
                    laboratorioDAOI.actualizarObservacionBs1(rs.getString("NoAutorizacion"), rs.getString("Observacion"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEjecutaTrasferenciaXenco(Long idOrden, Long idProtocolo) {
        try {
            String sql = "select\n\t'RL1' as TDocumentoLaboratorio,\n\tfi.codigoEncabezadoOrdenBs1 as NDocumentoLaboratorio,\n\tDATE_FORMAT(lr2.FechaResult,'%Y-%m-%d') as FechaDocumento,\n\tgp2.NoDocumento as Cedula,\n\tiixo.TipoDocGestion as TDocumentoGestion,\n\tfi.NAutorizacion as NDocumentoGestion,\n\tREPLACE(LTRIM(REPLACE(iixo.CodigoEntidad, '0', ' ')),' ', '0') as CodigoEntidad,\n\tgp4.NoDocumento as CodigoProfesional,\n\tiixo.Articulo,\n\tlp.Id as CodifoParametro,\n\tlp2.Nbre as NombreParametro,\n\tcase\n\t\twhen ld.VReferencia1 <> ''\n\t\tand ld.VReferencia2 = '' then ld.VReferencia1\n\t\twhen ld.VReferencia1 = ''\n\t\tand ld.VReferencia2 <> '' then ld.VReferencia2\n\t\twhen ld.VReferencia1 <> ''\n\t\tand ld.VReferencia2 <> '' then CONCAT(ld.VReferencia1, ' - ', ld.VReferencia2)\n\t\telse 'NO APLICA'\n\t\tend ValorReferencia,\n\t\tTRIM(CONCAT(ld.VrNumerico, ' ', ld.Unidad)) as Resultado,\n\t\t'' as CProfecional2,\n\t\tgp.Nbre as NombreArticulo,\n\t\tla.Nbre as NombreAreaAnalsis,\n\t\tla.Id as CoAreaAnlisis,\n\t\tiixo.NombreEntidad as NombreEntidad\n\tfrom\n\t\tl_recepcion lr\n\tinner join g_persona gp2 on\n\t\t(gp2.Id = lr.Id_Paciente)\n\tinner join l_resultados lr2 on\n\t\t(lr2.Id_Recepcion = lr.Id)\n\tinner join l_detalleresultado ld on\n\t\t(ld.Id_Resultado = lr2.Id)\n\tinner join g_persona gp4 on\n\t\t(ld.IdProfesionalV = gp4.Id)\n\tinner join l_protocoloxprocedimiento lp on\n\t\t(lp.Id = ld.Id_ProtocolProcedim)\n\tinner join l_protocolos lp2 on\n\t\t(lp2.Id = lp.Id_Protocolo)\n\tinner join g_procedimiento gp on\n\t\t(gp.Id = lp.Id_Procedim)\n\tinner join l_areas la on\n\t\t(la.Id = gp.Id_Area)\n\tinner join f_ordenes fo on\n\t\t(fo.Id = lr.Id_OrdenFacturac)\n\tinner join f_itemordenesproced fi on\n\t\t(fi.Id_Ordenes = fo.Id)\n\tinner join i_interfaz_xenco_orden iixo on\n\t\t(iixo.NumeroDocumentoGestion = fi.NAutorizacion)\n\tinner join g_procedimientoxcnt gp3 on\n\t\t(gp3.codigocnt = iixo.Articulo)\n\t\tand (gp3.idprocedimiento = ld.Id_Procedimiento)\n\twhere\n\t\t(\n\tfo.Estado = 0\n\t\tand \n\tlr.Estado = 0\n\t\tand \n\tlr.Id = " + idOrden + "\n \tand \n lp.Id = " + idProtocolo + "\n\t)\n\tgroup by\n\t\tlp2.Id\n\torder by\n\t\tgp.Id asc,\n\t\tlp.Orden asc";
            ResultSet rs = this.xct.getResultSet(sql);
            if (rs.next()) {
                rs.first();
                com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                laboratorioDAOI.actualizarResultadoXenco(rs.getString("TDocumentoLaboratorio"), rs.getString("NDocumentoLaboratorio"), rs.getString("FechaDocumento"), rs.getString("Cedula"), rs.getString("TDocumentoGestion"), rs.getString("NDocumentoGestion"), rs.getString("CodigoEntidad"), rs.getString("CodigoProfesional"), rs.getString("Articulo"), rs.getString("CodifoParametro"), rs.getString("NombreParametro"), rs.getString("ValorReferencia"), rs.getString("Resultado"), rs.getString("CProfecional2"), rs.getString("NombreArticulo"), rs.getString("NombreAreaAnalsis"), rs.getString("CoAreaAnlisis"), rs.getString("NombreEntidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEjecutaTrasferenciaSIFAS(Map<Long, Long> listaProcedimiento) {
        System.out.println("Ejecuta transferencia resultado SIFAS");
        System.out.println("this.urlResultados-->" + this.urlResultados);
        for (Map.Entry<Long, Long> entrada : listaProcedimiento.entrySet()) {
            SifasOrdenDTO e = new SifasOrdenDTO();
            e.setIdRecepcion(entrada.getValue());
            e.setIdProcedimiento(entrada.getKey());
            String result = (String) this.restTemplate.postForObject(this.urlResultados, e, String.class, new Object[0]);
            System.out.println("result sifas-->" + result);
            if (result.equals("202 ACCEPTED")) {
                int idRecepcion = Integer.valueOf(this.JLBNRecepcion.getText()).intValue();
                this.xImplLabotaorio.updateDatelleResultadoEnviado(idRecepcion, e.getIdProcedimiento().longValue());
            }
        }
    }

    private void mEjecutaTrasferenciaCNT(Long idOrden, Long idProtocolo) {
        try {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                this.sql = "SELECT\n   ingreso.`NoAutorizacion`\n , l_resultados.`FechaResult`\n , g_persona.`NoDocumento`\n , `f_itemordenesproced`.`NAutorizacion`\n , `l_protocolos`.`Nbre` AS protocolo \n , l_protocoloxprocedimiento.`Id` AS idprotocoloxprocedimiento \n , `l_detalleresultado`.`VrNumerico`\n , l_detalleresultado.`VReferencia1` AS VrMin\n , l_detalleresultado.`VReferencia2` AS VrMax\n , `l_detalleresultado`.`Unidad`\n , `l_detalleresultado`.`Observacion` \n , g_usuario_sist.`Login`\n , IF(`l_detalleresultado`.`Alterado`='0','N', 'S') AS Alterado  , `l_resultados`.`Id` AS idR  \n , l_detalleresultado.`Enviado`\nr , f_itemordenesproced.`codigoEncabezadoOrdenBs1`\n , `f_itemordenesproced`.`codigoEnvioBs1`\n , `l_detalleresultado`.`Id_Procedimiento`\n , `l_protocolos`.`Id` AS idProtocolo \n  FROM \n `f_itemordenesproced`\n INNER JOIN `f_ordenes` \n     ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n      INNER JOIN `ingreso` \n     ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`)\n INNER JOIN `l_recepcion` \n     ON (`l_recepcion`.`Id` = `f_ordenes`.`Id_OrdenRecep`)\n INNER JOIN `l_resultados` \n     ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n INNER JOIN `g_persona` \n     ON (`l_recepcion`.`Id_Paciente` = `g_persona`.`Id`)\n INNER JOIN `l_detalleresultado` \n     ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n INNER JOIN `profesional1` \n     ON (`l_resultados`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n     INNER JOIN `g_usuario_sist`\n     ON (  profesional1.`Id_Persona`=g_usuario_sist.`Id_Persona`)\n INNER JOIN `l_protocoloxprocedimiento` \n     ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n AND f_itemordenesproced.`Id_Procedimiento`=l_protocoloxprocedimiento.`Id_Procedim`\n INNER JOIN `l_protocolos` \n     ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n     WHERE (`f_ordenes`.`Estado` =0\n  AND `l_recepcion`.`Estado` =0\n  AND `l_recepcion`.`Id` =" + idOrden + " \n  AND `l_detalleresultado`.`Enviado` = 0 \n  AND `l_protocoloxprocedimiento`.`Id` =" + idProtocolo + " )\n  GROUP BY l_protocolos.`Id`";
            } else {
                this.sql = "SELECT\n   ingreso.`NoAutorizacion`\n , l_resultados.`FechaResult`\n , g_persona.`NoDocumento`\n , `f_itemordenesproced`.`NAutorizacion`\n , `l_protocolos`.`Nbre` AS protocolo \n , l_protocoloxprocedimiento.`Id` AS idprotocoloxprocedimiento \n , `l_detalleresultado`.`VrNumerico`\n , l_detalleresultado.`VReferencia1` AS VrMin\n , l_detalleresultado.`VReferencia2` AS VrMax\n , `l_detalleresultado`.`Unidad`\n , `l_detalleresultado`.`Observacion` \n , g_usuario_sist.`Login`\n , IF(`l_detalleresultado`.`Alterado`='0','N', 'S') AS Alterado  , `l_resultados`.`Id` AS idR  \n , l_detalleresultado.`Enviado`\nr , f_itemordenesproced.`codigoEncabezadoOrdenBs1`\n , `f_itemordenesproced`.`codigoEnvioBs1`\n , `l_detalleresultado`.`Id_Procedimiento`\n , `l_protocolos`.`Id` AS idProtocolo \n `f_itemordenesproced`\n INNER JOIN `f_ordenes` \n     ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n      INNER JOIN `ingreso` \n     ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`)\n INNER JOIN `l_recepcion` \n     ON (`l_recepcion`.`Id` = `f_ordenes`.`Id_OrdenRecep`)\n INNER JOIN `l_resultados` \n     ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n INNER JOIN `g_persona` \n     ON (`l_recepcion`.`Id_Paciente` = `g_persona`.`Id`)\n INNER JOIN `l_detalleresultado` \n     ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n INNER JOIN `profesional1` \n     ON (`l_resultados`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n     INNER JOIN `g_usuario_sist`\n     ON (  profesional1.`Id_Persona`=g_usuario_sist.`Id_Persona`)\n INNER JOIN `l_protocoloxprocedimiento` \n     ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n AND f_itemordenesproced.`Id_Procedimiento`=l_protocoloxprocedimiento.`Id_Procedim`\n INNER JOIN `l_protocolos` \n     ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n     WHERE (`f_ordenes`.`Estado` =0\n  AND `l_recepcion`.`Estado` =0\n  AND `l_recepcion`.`Id` =" + idOrden + " \n  AND `l_detalleresultado`.`Enviado` = 0 \n  AND `l_protocoloxprocedimiento`.`Id` =" + idProtocolo + " )\n  GROUP BY l_protocolos.`Id`";
            }
            System.out.println("RCNT" + this.sql);
            ResultSet rs = this.xct.getResultSet(this.sql);
            if (rs.next()) {
                rs.first();
                if (Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI.actualizarResultadoCNT2(rs.getString("codigoEncabezadoOrdenBs1"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idProtocolo"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("idR"), rs.getString("Alterado"), idProtocolo, "LABO_INTER_BIOSYSTEM");
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI2 = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI2.actualizarResultadoCNT2(rs.getString("codigoEncabezadoOrdenBs1"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idprotocoloxprocedimiento"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("idR"), rs.getString("Alterado"), idProtocolo, "LABO_INTER_BIOSYSTEM");
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI3 = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI3.actualizarResultadoCNTBiomed(rs.getString("NoAutorizacion"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idprotocoloxprocedimiento"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("Alterado"), rs.getString("idR"), idProtocolo, "LABO_INTER_ROCHE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidarResultadoAlterado() {
        for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
            if (Integer.valueOf(this.xmodelo1.getValueAt(x, 32).toString()).intValue() == 0 && Boolean.valueOf(this.xmodelo1.getValueAt(x, 22).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo1.getValueAt(x, 9).toString()).booleanValue() && this.xmodelo1.getValueAt(x, 2).toString().equals("0") && !this.xmodelo1.getValueAt(x, 6).toString().equals("") && !this.xmodelo1.getValueAt(x, 7).toString().equals("") && !this.xmodelo1.getValueAt(x, 3).toString().equals("") && Integer.valueOf(this.xmodelo1.getValueAt(x, 2).toString()).intValue() == 0) {
                double xvminimo = 0.0d;
                double xvmaximo = 0.0d;
                double xvalorr = Double.parseDouble(this.xmodelo1.getValueAt(x, 3).toString().replaceAll(",", "."));
                if (!this.xmodelo1.getValueAt(x, 6).toString().equals("")) {
                    xvminimo = Double.parseDouble(this.xmodelo1.getValueAt(x, 6).toString().replaceAll(",", "."));
                }
                if (!this.xmodelo1.getValueAt(x, 7).toString().equals("")) {
                    xvmaximo = Double.parseDouble(this.xmodelo1.getValueAt(x, 7).toString().replaceAll(",", "."));
                }
                if (xvalorr < xvminimo || xvalorr > xvmaximo) {
                    this.xmodelo1.setValueAt(true, x, 8);
                } else {
                    this.xmodelo1.setValueAt(false, x, 8);
                }
                this.JTBDetalleAnalito.setDefaultRenderer(Object.class, new MiRender3());
            }
        }
    }

    private void mCargarComboCometario(String idArea) {
        List<GenericoDTO> list = this.xImplLabotaorio.listComentarioIdArea(idArea);
        this.xlleno1 = false;
        if (list.size() > 0) {
            this.xlleno1 = true;
            this.xidcometario = new String[list.size()][3];
            this.JCBComentario.removeAllItems();
            for (int x = 0; x < list.size(); x++) {
                this.xidcometario[x][0] = list.get(x).getId().toString();
                this.xidcometario[x][1] = list.get(x).getDescripcion();
                this.xidcometario[x][2] = list.get(x).getTipo().toString();
                this.JCBComentario.addItem(list.get(x).getNombre());
            }
            this.JCBComentario.setSelectedIndex(-1);
        }
    }

    private void mCargarDetalleComentario() {
        mCrearModeloDetalleComentario();
        List<DetalleComentarioProtocoloDTO> list = this.xImplLabotaorio.listDetalleComentarioProtocolo(Long.valueOf(this.JLBNRecepcion.getText()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo2.addRow(this.xdatos);
                this.xmodelo2.setValueAt(list.get(x).getId(), x, 0);
                this.xmodelo2.setValueAt(list.get(x).getNombre(), x, 1);
                this.xmodelo2.setValueAt(list.get(x).getDescripcion(), x, 2);
                this.xmodelo2.setValueAt(list.get(x).getNOrden(), x, 3);
            }
        }
    }

    private void mCargarDetalleHistorico() {
        mCrearModeloDetalleHistorico();
        List<HistoricoResultadoProtocoloDTO> list = this.xImplLabotaorio.listHistoricoResultadoProtocolo(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 13).toString()));
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo3.addRow(this.xdatos);
                this.xmodelo3.setValueAt(list.get(x).getIdProtocoloProc(), x, 0);
                this.xmodelo3.setValueAt(list.get(x).getIdResultado(), x, 1);
                this.xmodelo3.setValueAt(list.get(x).getFecha(), x, 2);
                this.xmodelo3.setValueAt(list.get(x).getNombreProtocolo(), x, 3);
                this.xmodelo3.setValueAt(list.get(x).getVRefencia1(), x, 4);
                this.xmodelo3.setValueAt(list.get(x).getVRefencia2(), x, 5);
                this.xmodelo3.setValueAt(list.get(x).getValor(), x, 6);
                this.xmodelo3.setValueAt(list.get(x).getNEspecialidad(), x, 7);
                this.xmodelo3.setValueAt(list.get(x).getNProfesional(), x, 8);
                this.xmodelo3.setValueAt(list.get(x).getVAlterado(), x, 9);
                this.xmodelo3.setValueAt(false, x, 10);
                this.JTBDetalleHc.setDefaultRenderer(Object.class, new MiRender());
            }
        }
    }

    private void mActualizarResultadoHc(String xnresultado, String xidprotocolo) {
        this.xsql = "update l_detalleresultado_historico set `Id_RsesultadoN`='" + xnresultado + "' where `Id_Protocolo_Proc`='" + xidprotocolo + "' and `Id_RsesultadoN`=0";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        xct1.ejecutarSQL(this.xsql);
        xct1.cerrarConexionBd();
    }

    private void mActualizarResultadoComentario(String xidprocedimiento, String xidrecepcion, String nresultado) {
        this.xsql = "update l_detalleresultado_comentario set `Id_Resultado`='" + nresultado + "' where `Id_Procedimiento`='" + xidprocedimiento + "' AND `Id_Recepcion`='" + xidrecepcion + "' and `Id_Resultado`=0";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        xct1.ejecutarSQL(this.xsql);
        xct1.cerrarConexionBd();
    }

    public void mImprimir() {
        Principal.claselab.mAlertaResultadoPendientes(this.JLBNRecepcion.getText());
        Object[] botones = {"Formato PreImpreso", "Normal", "Por Procedimiento", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
        switch (n) {
            case 0:
                impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), false, String.valueOf(this.xidusuario), true);
                break;
            case 1:
                if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
                        if (this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString().equals("898001")) {
                            mImprimirCitologia();
                        } else {
                            impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                        }
                    } else {
                        impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                    }
                } else if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
                    if (this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString().equals("898001")) {
                        mImprimirCitologia();
                    } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                        System.out.println("thi --- " + this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra());
                        impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), false);
                        imprimirPdfFusionado(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "biomedL_Reporte_Resultado_Con_Encabezado.pdf");
                    } else {
                        impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                    }
                } else {
                    impresion.mImprimirResultado(this.JLBNRecepcion.getText(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                }
                break;
            case 2:
                if (this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleAnalito, 26)) {
                    Object[] botones1 = {"Formato PreImpreso", "Normal", "Cerrar"};
                    String xcodigopro = "";
                    for (int x = 0; x < this.JTBDetalleAnalito.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 26).toString()).booleanValue() && this.JTBDetalleAnalito.getValueAt(x, 11) != null) {
                            xcodigopro = xcodigopro + "," + this.xmodelo1.getValueAt(x, 11).toString();
                        }
                    }
                    int z = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
                    if (z == 0) {
                        impresion.mImprimirResultado(this.JLBNRecepcion.getText(), xcodigopro.substring(1, xcodigopro.length()), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), false, String.valueOf(this.xidusuario), true);
                    } else if (z == 1) {
                        impresion.mImprimirResultado(this.JLBNRecepcion.getText(), xcodigopro.substring(1, xcodigopro.length()), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xidusuario), true);
                    }
                }
                break;
        }
    }

    private void mImprimirCitologia() {
        String[][] parametros = new String[3][2];
        parametros[0][0] = "Id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "P_EnvioCitologiaN_1_1_03", parametros);
    }

    private void mCrearVistaAjustes(String xsql) {
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS l_v_tmp_planilla  ");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW l_v_tmp_planilla AS " + xsql;
        System.out.println("vista " + sqlw);
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFPlanillaTrabajo$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean xvalor = Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue();
            if (xvalor) {
                cell.setBackground(new Color(204, 255, 204));
                cell.setForeground(new Color(0, 0, 0));
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(new Color(0, 0, 0));
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFPlanillaTrabajo$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            try {
                JIFPlanillaTrabajo.JTPDetalle.setBackgroundAt(2, new Color(238, 238, 238));
                if (Boolean.valueOf(table.getValueAt(row, 35).toString()).booleanValue()) {
                    cell.setBackground(new Color(204, 204, 255));
                    cell.setForeground(new Color(0, 0, 0));
                } else if (Long.valueOf(table.getValueAt(row, 32).toString()).longValue() == 0) {
                    if (Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue() && Integer.valueOf(table.getValueAt(row, 27).toString()).intValue() == 1) {
                        if (Boolean.valueOf(table.getValueAt(row, 8).toString()).booleanValue() && Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue()) {
                            cell.setBackground(new Color(51, 171, 255));
                            cell.setForeground(new Color(0, 0, 0));
                        } else if (!Boolean.valueOf(table.getValueAt(row, 8).toString()).booleanValue() && Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue()) {
                            cell.setBackground(new Color(51, 240, 255));
                            cell.setForeground(new Color(0, 0, 0));
                        } else {
                            cell.setBackground(new Color(255, 255, 255));
                            cell.setForeground(new Color(0, 0, 0));
                        }
                    } else if (Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue() && Integer.valueOf(table.getValueAt(row, 27).toString()).intValue() == 0) {
                        cell.setBackground(Color.PINK);
                        cell.setForeground(new Color(0, 0, 0));
                    } else if (Integer.valueOf(table.getValueAt(row, 42).toString()).intValue() == 0) {
                        cell.setBackground(new Color(255, 255, 255));
                        cell.setForeground(new Color(0, 0, 0));
                    } else {
                        cell.setBackground(new Color(255, 255, 0));
                        cell.setForeground(new Color(0, 0, 0));
                        JIFPlanillaTrabajo.JTPDetalle.setBackgroundAt(2, new Color(255, 255, 0));
                    }
                } else {
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(new Color(0, 0, 0));
                }
            } catch (NullPointerException e) {
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFPlanillaTrabajo$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 0) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 1) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.RED);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 2) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.ORANGE);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 3) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(0, 103, 0));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 4) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLUE);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 5) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.MAGENTA);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 6) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.GRAY);
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 7) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(123, 63, 0));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 8) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(168, 36, 0));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 9) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(138, 43, 226));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 10) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(204, 0, 255));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 11) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(102, 255, 102));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 12) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(255, 0, 102));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 13) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(51, 153, 255));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 14) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(51, 204, 204));
            } else if (Integer.valueOf(table.getValueAt(row, 1).toString()).intValue() == 15) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(new Color(204, 153, 0));
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFPlanillaTrabajo$MiRender3.class */
    public static class MiRender3 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 32).toString()).longValue() == 0) {
                if (Boolean.valueOf(table.getValueAt(row, 8).toString()).booleanValue()) {
                    cell.setBackground(new Color(51, 171, 255));
                    cell.setForeground(new Color(0, 0, 0));
                } else if (!Boolean.valueOf(table.getValueAt(row, 8).toString()).booleanValue() && Boolean.valueOf(table.getValueAt(row, 9).toString()).booleanValue()) {
                    cell.setBackground(new Color(51, 240, 255));
                    cell.setForeground(new Color(0, 0, 0));
                } else {
                    cell.setBackground(new Color(255, 255, 255));
                    cell.setForeground(new Color(0, 0, 0));
                }
            } else {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(new Color(0, 0, 0));
            }
            return cell;
        }
    }

    public void mAnular(int opc) {
        if (this.JTBDetalleAnalito.getSelectedRow() != -1) {
            if (opc == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Anular los Analitos Validados de este Procedimiento?", "CONFIRMAR", 0, 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                if (x == 0) {
                    int pos = 0;
                    while (true) {
                        if (pos >= this.JTBDetalleAnalito.getRowCount()) {
                            break;
                        }
                        if (Long.valueOf(this.xmodelo1.getValueAt(pos, 0).toString()).longValue() != -100 && this.JTBDetalleAnalito.getValueAt(pos, 11).toString().equals(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString())) {
                            if (this.xImplLabotaorio.verificarProfesionalResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(pos, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 0).toString())).intValue() == 1) {
                                this.xImplLabotaorio.deleteDetalleResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(pos, 12).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 11).toString()));
                                this.xImplLabotaorio.deleteResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(pos, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 0).toString()), 0);
                                actualizacionEstadoProcedimientoLaboratorio(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(pos, 12).toString())));
                                this.xmodelo1.setValueAt(-1, pos, 27);
                                int cont = 0;
                                for (int i = 0; i < this.JTBDetalleAnalito.getRowCount(); i++) {
                                    if (Long.valueOf(this.xmodelo1.getValueAt(i, 32).toString()).longValue() == 0 && this.xmodelo1.getValueAt(i, 11).toString().equals(this.xmodelo1.getValueAt(pos, 11).toString()) && Integer.valueOf(this.xmodelo1.getValueAt(i, 27).toString()).intValue() == 1) {
                                        cont++;
                                    }
                                }
                                System.out.println("N0. Validados: " + cont);
                                if (cont == 0) {
                                    this.xImplLabotaorio.updateDetalleRecepcion(0, 0, Long.valueOf(this.xmodelo1.getValueAt(pos, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 12).toString()), 3, 0);
                                }
                            } else if (Principal.usuarioSistemaDTO.getAutorizacionLaboratorio().intValue() == 3) {
                                this.xImplLabotaorio.deleteDetalleResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(pos, 12).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 11).toString()));
                                this.xImplLabotaorio.deleteResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(pos, 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 0).toString()), 1);
                                actualizacionEstadoProcedimientoLaboratorio(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(pos, 12).toString())));
                                this.xmodelo1.setValueAt(-1, pos, 27);
                                int cont2 = 0;
                                for (int i2 = 0; i2 < this.JTBDetalleAnalito.getRowCount(); i2++) {
                                    if (Long.valueOf(this.xmodelo1.getValueAt(i2, 32).toString()).longValue() == 0 && this.xmodelo1.getValueAt(i2, 11).toString().equals(this.xmodelo1.getValueAt(pos, 11).toString()) && Integer.valueOf(this.xmodelo1.getValueAt(i2, 27).toString()).intValue() == 1) {
                                        cont2++;
                                    }
                                }
                                System.out.println("N0. Validados: " + cont2);
                                if (cont2 == 0) {
                                    this.xImplLabotaorio.updateDetalleRecepcion(0, 0, Long.valueOf(this.xmodelo1.getValueAt(pos, 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(pos, 12).toString()), 3, 0);
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Resultado registrado por otro profesional;\nNo se puede anular!!!!", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                break;
                            }
                        }
                        pos++;
                    }
                    enviarNotificacion(this.JLBNRecepcion.getText());
                }
            } else {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Analito ya validado;\nDesea eliminarlo?", "CONFIRMAR", 0, 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                if (x2 == 0) {
                    if (this.xImplLabotaorio.verificarProfesionalResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString())).intValue() == 1) {
                        this.xImplLabotaorio.deleteDetalleResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
                        actualizacionEstadoProcedimientoLaboratorio(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString())));
                        this.xImplLabotaorio.deleteResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString()), 0);
                        this.xmodelo1.setValueAt(-1, this.JTBDetalleAnalito.getSelectedRow(), 27);
                        int cont3 = 0;
                        for (int i3 = 0; i3 < this.JTBDetalleAnalito.getRowCount(); i3++) {
                            if (Long.valueOf(this.xmodelo1.getValueAt(i3, 32).toString()).longValue() == 0 && this.xmodelo1.getValueAt(i3, 11).toString().equals(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()) && Integer.valueOf(this.xmodelo1.getValueAt(i3, 27).toString()).intValue() == 1) {
                                cont3++;
                            }
                        }
                        System.out.println("N0. Validados: " + cont3);
                        if (cont3 == 0) {
                            this.xImplLabotaorio.updateDetalleRecepcion(0, 0, Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString()), 3, 0);
                        }
                    } else if (Principal.usuarioSistemaDTO.getAutorizacionLaboratorio().intValue() == 3) {
                        this.xImplLabotaorio.deleteDetalleResultadoComentario(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()));
                        actualizacionEstadoProcedimientoLaboratorio(Long.valueOf(Long.parseLong(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString())));
                        this.xImplLabotaorio.deleteResultado(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 0).toString()), 1);
                        this.xmodelo1.setValueAt(-1, this.JTBDetalleAnalito.getSelectedRow(), 27);
                        int cont4 = 0;
                        for (int i4 = 0; i4 < this.JTBDetalleAnalito.getRowCount(); i4++) {
                            if (Long.valueOf(this.xmodelo1.getValueAt(i4, 32).toString()).longValue() == 0 && this.xmodelo1.getValueAt(i4, 11).toString().equals(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()) && Integer.valueOf(this.xmodelo1.getValueAt(i4, 27).toString()).intValue() == 1) {
                                cont4++;
                            }
                        }
                        System.out.println("N0. Validados: " + cont4);
                        if (cont4 == 0) {
                            this.xImplLabotaorio.updateDetalleRecepcion(0, 0, Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 11).toString()), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 12).toString()), 3, 0);
                        }
                    } else {
                        this.xmodelo1.setValueAt(true, this.JTBDetalleAnalito.getSelectedRow(), 9);
                        JOptionPane.showInternalMessageDialog(this, "Resultado registrado por otro profesional;\nNo se puede anular!!!!", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    enviarNotificacion(this.JLBNRecepcion.getText());
                }
            }
            mCargarDetalleRecepcion_NUevo();
        }
    }

    private void formulas() {
        String replacement;
        if (this.JTBDetalleAnalito.getRowCount() != 0) {
            for (int i = 0; i < this.JTBDetalleAnalito.getRowCount(); i++) {
                if (this.xmodelo1.getValueAt(i, 43).toString() != null && !this.xmodelo1.getValueAt(i, 43).toString().isEmpty()) {
                    String formula = this.xmodelo1.getValueAt(i, 43).toString();
                    this.matcher = this.patron.matcher(formula);
                    Map<String, String> valores = new HashMap<>();
                    while (this.matcher.find()) {
                        String variable = this.matcher.group(1);
                        if (!valores.containsKey(variable)) {
                            replacement = null;
                            switch (variable) {
                                case "EDAD":
                                    replacement = Double.toString(this.xedad);
                                    break;
                                case "SEXO":
                                    replacement = "'" + this.xsexo + "'";
                                    break;
                                case "ESAFRO":
                                    replacement = this.JCHRaza.isSelected() ? "true" : "false";
                                    break;
                                case "TALLA":
                                    replacement = this.JTFFSTalla1.getText();
                                    break;
                                case "PESO":
                                    replacement = this.JTFFSPeso1.getText();
                                    break;
                                case "IMC":
                                    replacement = this.JTFFSIMC1.getText().replace(",", ".");
                                    break;
                                case "P.ABDOMINAL":
                                    replacement = this.JTFFSPerimetroAbd1.getText().replace(",", ".");
                                    break;
                                case "S.CORPORAL":
                                    replacement = this.JTFFSCorporal1.getText().replace(",", ".");
                                    break;
                                default:
                                    int j = 0;
                                    while (true) {
                                        if (j < this.JTBDetalleAnalito.getRowCount()) {
                                            if (!this.xmodelo1.getValueAt(j, 0).toString().equals(variable) || this.xmodelo1.getValueAt(j, 3).toString().isEmpty()) {
                                                j++;
                                            } else {
                                                replacement = this.xmodelo1.getValueAt(j, 3).toString();
                                            }
                                        }
                                        break;
                                    }
                                    break;
                            }
                            if (replacement != null) {
                                valores.put(variable, replacement);
                            }
                        }
                    }
                    for (Map.Entry<String, String> entry : valores.entrySet()) {
                        formula = formula.replaceAll("\\[" + entry.getKey() + "\\]", entry.getValue());
                    }
                    if (!formula.contains("[") && !formula.contains("]")) {
                        try {
                            System.out.println("Evaluando fórmula: " + formula);
                            double resultado = ((Double) this.engine.eval(formula)).doubleValue();
                            String valor = String.valueOf(this.xdf.format(resultado)).replace(',', '.');
                            this.xmodelo1.setValueAt(valor, i, 3);
                            this.xmodelo1.setValueAt("82", i, 16);
                            System.out.println("Resultado de " + this.xmodelo1.getValueAt(i, 1).toString() + ": " + valor);
                        } catch (ScriptException e) {
                            System.out.println("Error al evaluar la fórmula: " + formula + " -> " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private void mCalcularDato() {
        int xPos;
        try {
            if (this.JTBDetalleAnalito.getRowCount() != -1) {
                for (int x = 0; x < this.xmodelo1.getRowCount(); x++) {
                    if (Integer.valueOf(this.xmodelo1.getValueAt(x, 32).toString()).intValue() == 0 && this.xmodelo1.getValueAt(x, 2).toString().equals("0") && Boolean.valueOf(this.xmodelo1.getValueAt(x, 23).toString()).booleanValue()) {
                        System.out.println(this.xmodelo1.getValueAt(x, 2).toString());
                        switch (this.xmodelo1.getValueAt(x, 24).toString()) {
                            case "1":
                                if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                                    if (!this.xmodelo1.getValueAt(x, 0).toString().equals("-100") && this.xmodelo1.getValueAt(x, 1).toString().equals("BILIRRUBINA INDIRECTA") && !this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 2, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    } else if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                        System.out.println("ENtra aki 1");
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                        System.out.println("ENtra aki 1");
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "2":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula2(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "3":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula3(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), 3), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "4":
                                if (!this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula4(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "5":
                                if (!this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula4(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "6":
                                if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 5, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula5(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "7":
                                if (!this.xmodelo1.getValueAt(x - 5, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "8":
                                if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "9":
                                if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "10":
                                if (!this.xmodelo1.getValueAt(x - 6, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "11":
                                if (!this.xmodelo1.getValueAt(x - 8, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 8, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "12":
                                if (!this.xmodelo1.getValueAt(x - 10, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 10, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "13":
                                if (!this.xmodelo1.getValueAt(x - 12, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 12, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "14":
                                if (!this.xmodelo1.getValueAt(x - 14, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 14, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "15":
                                if (!this.xmodelo1.getValueAt(x - 16, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x - 16, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "16":
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA")) {
                                    if (!this.xmodelo1.getValueAt(x - 7, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue() <= 700.0d) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                        if (!this.xmodelo1.getValueAt(x - 7, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue() <= 700.0d) {
                                            this.xmodelo1.setValueAt(Long.valueOf(Math.round(Double.valueOf(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue())).doubleValue())), x, 3);
                                            this.xmodelo1.setValueAt("82", x, 16);
                                        }
                                    } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                                        if (!this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 400.0d) {
                                            this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                            this.xmodelo1.setValueAt("82", x, 16);
                                        }
                                    } else {
                                        int aplicaFormula = 0;
                                        for (int i = 0; i < this.JTBDetalleAnalito.getRowCount(); i++) {
                                            if (this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals("903818") || this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals("903868")) {
                                                aplicaFormula++;
                                            }
                                            if (this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals("223") || this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals("220") || this.JTBDetalleAnalito.getValueAt(i, 11).toString().equals("221")) {
                                                aplicaFormula++;
                                            }
                                        }
                                        if (aplicaFormula >= 2 || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                            switch (Principal.informacionIps.getNombreIps()) {
                                                case "E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 400.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                                                case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                                                case "E.S.E HOSPITAL HECTOR ABAD GOMEZ":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 700.0d && !this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleAnalito, 11, "903816") && !this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleAnalito, 11, "903817")) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                case "CLINICA SANTA CLARA SAS":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue() <= 300.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue() <= 300.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                                                case "ZONAMEDICA MR S.A.S":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue() <= 400.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                case "FUNDACIÓN PANZENÚ":
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue() <= 700.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue() / 5.0d, Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    if (Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 700.0d) {
                                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula8(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                                        this.xmodelo1.setValueAt("82", x, 16);
                                                        break;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                break;
                            case "17":
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                                    if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue() <= 700.0d) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), 5.0d), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                        if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue() <= 700.0d) {
                                            this.xmodelo1.setValueAt(Long.valueOf(Math.round(Double.valueOf(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), 5.0d)).doubleValue())), x, 3);
                                            this.xmodelo1.setValueAt("82", x, 16);
                                        }
                                    } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                                        if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 400.0d) {
                                            this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), 5.0d), x, 3);
                                            this.xmodelo1.setValueAt("82", x, 16);
                                        }
                                    } else {
                                        boolean aplicaFormula2 = false;
                                        for (int i2 = 0; i2 < this.JTBDetalleAnalito.getRowCount(); i2++) {
                                            if (this.JTBDetalleAnalito.getValueAt(i2, 11).toString().equals("903868") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                                aplicaFormula2 = true;
                                            }
                                            if (this.JTBDetalleAnalito.getValueAt(i2, 11).toString().equals("655")) {
                                                aplicaFormula2 = true;
                                            }
                                        }
                                        if (aplicaFormula2) {
                                            if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                                                if (Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue() <= 400.0d) {
                                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), 5.0d), x, 3);
                                                    this.xmodelo1.setValueAt("82", x, 16);
                                                }
                                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
                                                if (Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue() <= 300.0d) {
                                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), 5.0d), x, 3);
                                                    this.xmodelo1.setValueAt("82", x, 16);
                                                }
                                            } else if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                                                if (Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue() <= 400.0d) {
                                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue(), 5.0d), x, 3);
                                                    this.xmodelo1.setValueAt("82", x, 16);
                                                }
                                            } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                                                if (Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue() <= 700.0d) {
                                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), 5.0d), x, 3);
                                                    this.xmodelo1.setValueAt("82", x, 16);
                                                }
                                            } else if (Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue() <= 700.0d) {
                                                this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), 5.0d), x, 3);
                                                this.xmodelo1.setValueAt("82", x, 16);
                                            }
                                        }
                                    }
                                    break;
                                }
                                break;
                            case "18":
                                if (!this.xmodelo1.getValueAt(x - 5, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "19":
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                                    if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "20":
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                                    if (!this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "21":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(2.14d).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "22":
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                                    if (!this.xmodelo1.getValueAt(x + 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 7, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula10(Double.valueOf(this.xmodelo1.getValueAt(x + 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 4, 3).toString()).doubleValue(), 1440, Double.valueOf(this.xmodelo1.getValueAt(x + 7, 3).toString()).doubleValue(), 1.73d), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x + 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 3, 3).toString().equals("") && mTraerValorDatosAntopometricos(this.JTFFSCorporal1) != 0.0d) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula10(Double.valueOf(this.xmodelo1.getValueAt(x + 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), 1440, mTraerValorDatosAntopometricos(this.JTFFSCorporal1), 1.73d), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "23":
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                                    if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula7(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula11(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "24":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "25":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && this.xedad != 0) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula12(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), this.xedad, this.xraza, this.xsexo), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "26":
                                if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && this.xedad != 0 && this.JTFFSPeso1.getValue() != null) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula13(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), this.xedad, mTraerValorDatosAntopometricos(this.JTFFSPeso1), this.xsexo), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "27":
                                if (!this.xmodelo1.getValueAt(x - 7, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 5, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "28":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "29":
                                if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 3, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula14(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), 1440.0d), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "30":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula16(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), this.xedad, this.xraza, this.xsexo), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "31":
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    if (!this.xmodelo1.getValueAt(x - 6, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 4, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x - 5, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "32":
                                if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula15(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "33":
                                if (this.xedad > 17 && !this.xmodelo1.getValueAt(x - 5, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula18(this.xedad, Double.valueOf(this.JTFFSPeso1.getValue().toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue(), this.xsexo), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "34":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    xPos = 3;
                                } else {
                                    xPos = 2;
                                }
                                if (!this.xmodelo1.getValueAt(x + xPos, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x + xPos, 3).toString()).doubleValue(), 5.0d), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "35":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula19(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula19(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "36":
                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                    if (!this.xmodelo1.getValueAt(x - 6, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 4, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 6, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                } else {
                                    System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                    if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 3, 3).toString().equals("")) {
                                        this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue()), x, 3);
                                        this.xmodelo1.setValueAt("82", x, 16);
                                    }
                                    break;
                                }
                                break;
                            case "37":
                                if (this.xedad > 17 && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && this.JTFFSCorporal1.getValue() != null) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula20(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(this.JTFFSCorporal1.getValue().toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "38":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "39":
                                if (!this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x - 1, 31).toString()).doubleValue() > 0.0d) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula22(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 31).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "40":
                                if (this.xedad > 17 && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula40(this.xedad, Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), this.xsexo, this.JCHRaza.isSelected()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "41":
                                if (!this.xmodelo1.getValueAt(x + 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula41(Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "42":
                                if (!this.xmodelo1.getValueAt(x - 3, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula41(Double.valueOf(this.xmodelo1.getValueAt(x - 3, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "44":
                                if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula46(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), 100.0d), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "45":
                                if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula44(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), new Double(20.0d).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "46":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (!this.xmodelo1.getValueAt(x - 4, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 2, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "47":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (!this.xmodelo1.getValueAt(x - 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula45(Double.valueOf(this.xmodelo1.getValueAt(x - 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "48":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (!this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula46(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), 1440.0d), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "49":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (!this.xmodelo1.getValueAt(x + 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && Double.valueOf(this.xmodelo1.getValueAt(x, 31).toString()).doubleValue() > 0.0d) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula47(Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x, 31).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "50":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") && !this.xmodelo1.getValueAt(x + 2, 3).toString().equals("") && !this.xmodelo1.getValueAt(x + 1, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x + 2, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x + 1, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "51":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if ((Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) && !this.xmodelo1.getValueAt(x - 1, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 4, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 1, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 4, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "52":
                                System.out.println("valor " + this.xmodelo1.getValueAt(x, 3).toString().equals(""));
                                if ((Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) && !this.xmodelo1.getValueAt(x - 7, 3).toString().equals("") && !this.xmodelo1.getValueAt(x - 5, 3).toString().equals("")) {
                                    this.xmodelo1.setValueAt(Principal.claselab.mFormula9(Double.valueOf(this.xmodelo1.getValueAt(x - 7, 3).toString()).doubleValue(), Double.valueOf(this.xmodelo1.getValueAt(x - 5, 3).toString()).doubleValue()), x, 3);
                                    this.xmodelo1.setValueAt("82", x, 16);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private void mActualizarDatosRecepcion() {
        this.xsql = "update `l_recepcion` set `Peso`=" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + ", `Talla`=" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + ", `PAbdominal`=" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + ", `Imc`=" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + ", `SCorporal`=" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + " where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private double mTraerValorDatosAntopometricos(JFormattedTextField xjtf) {
        double xvalor;
        if (xjtf.getText().isEmpty()) {
            xvalor = 0.0d;
        } else {
            xvalor = Double.valueOf(xjtf.getText().replaceAll(",", ".")).doubleValue();
        }
        return xvalor;
    }

    private double mInicarDatosAntopometricos(double xvalor, JFormattedTextField xjtf) {
        if (xvalor == 0.0d) {
            xjtf.setValue((Object) null);
        } else {
            xjtf.setValue(Double.valueOf(xvalor));
        }
        return xvalor;
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla1.getValue() != null && this.JTFFSPeso1.getValue() != null) {
            this.JTFFSIMC1.setValue(Double.valueOf(mTraerValorDatosAntopometricos(this.JTFFSPeso1) / Math.pow(mTraerValorDatosAntopometricos(this.JTFFSTalla1) / 100.0d, 2.0d)));
        }
    }

    private void mCalcularSCorporal() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            if (this.JTFFSPeso1.getValue() != null && this.JTFFSTalla1.getValue() != null) {
                double xv1 = (mTraerValorDatosAntopometricos(this.JTFFSTalla1) * mTraerValorDatosAntopometricos(this.JTFFSPeso1)) / 3600.0d;
                double raiz = Math.sqrt(xv1);
                new DecimalFormat("#.00");
                this.JTFFSCorporal1.setValue(Double.valueOf(raiz));
                return;
            }
            return;
        }
        if (this.JTFFSPeso1.getValue() != null) {
            double xv12 = (mTraerValorDatosAntopometricos(this.JTFFSPeso1) * 4.0d) + 7.0d;
            double xv2 = mTraerValorDatosAntopometricos(this.JTFFSPeso1) + 90.0d;
            this.JTFFSCorporal1.setValue(Double.valueOf(xv12 / xv2));
        }
    }

    private void mAlertaValoresFueraRango() {
        if (this.JTBDetalleAnalito.getRowCount() != -1 && Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 32).toString()).intValue() == 0 && this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 2).toString().equals("0") && Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 18).toString()).longValue() == 0 && !this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 3).toString().equals("")) {
            if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 29).toString().equals("0") || !this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 30).toString().equals("0")) {
                double xvminimo = 0.0d;
                double xvmaximo = 0.0d;
                double xvalorr = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 3).toString());
                if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 29).toString().equals("")) {
                    xvminimo = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 29).toString());
                }
                if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 30).toString().equals("")) {
                    xvmaximo = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 30).toString());
                }
                if (xvalorr < xvminimo || xvalorr > xvmaximo) {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Por favor revise el resultado final de este estudio;</p><font face='Arial' color='red' size=4>Aseguramos calidad en el informe.", "VERIFICAR L�?MITES DE SEGURIDAD", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
            }
            if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 6).toString().equals("") || !this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 7).toString().equals("0")) {
                double xminimo1 = 0.0d;
                double xvmaximo1 = 0.0d;
                double xvalorr2 = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 3).toString());
                if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 6).toString().equals("")) {
                    xminimo1 = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 6).toString());
                }
                if (!this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 7).toString().equals("")) {
                    xvmaximo1 = Double.parseDouble(this.xmodelo1.getValueAt(this.JTBDetalleAnalito.getSelectedRow(), 7).toString());
                }
                if (xvalorr2 < xminimo1 || xvalorr2 > xvmaximo1) {
                    this.xmodelo1.setValueAt(true, this.JTBDetalleAnalito.getSelectedRow(), 8);
                }
            }
        }
    }

    private void consultarCorreo() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT envioCorreo from l_recepcion WHERE Id = '" + this.JLBNRecepcion.getText() + "'";
        System.out.println("resultado correo: " + this.xsql);
        ResultSet xrs1 = xct1.traerRs(this.xsql);
        try {
            if (xrs1.next() && xrs1.getInt(1) == 1) {
                this.envioCorreo = true;
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void imprimirPdfFusionado(String ruta, String archivoPrincipal) {
        String recepcion = this.JLBNRecepcion.getText();
        String rutaCarpeta = this.xmt.mRutaSoporte("JDCarguePDFResultadosExternos");
        String outputFileName = "Recepcion unificada_" + recepcion;
        List<InputStream> inputStreams = new ArrayList<>();
        System.err.println("ruta" + rutaCarpeta);
        try {
            try {
                inputStreams.add(new FileInputStream(archivoPrincipal));
                File folder = new File(rutaCarpeta);
                File[] listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().startsWith(recepcion) && file.getName().endsWith(".pdf")) {
                        inputStreams.add(new FileInputStream(rutaCarpeta + "\\" + file.getName()));
                    }
                }
                System.out.println("ruta: " + ruta);
                System.out.println("inputStreams: " + inputStreams);
                this.xmt.unirPdf_Generico(ruta + "\\Recepcion unificada", outputFileName, inputStreams);
                Desktop.getDesktop().open(new File(ruta + "\\Recepcion unificada\\" + outputFileName + ".pdf"));
                for (InputStream inputStream : inputStreams) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                for (InputStream inputStream2 : inputStreams) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            for (InputStream inputStream3 : inputStreams) {
                try {
                    inputStream3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
