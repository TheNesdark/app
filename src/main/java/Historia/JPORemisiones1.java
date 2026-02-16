package Historia;

import Acceso.Principal;
import Citas.JDCitasInterConsulta;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedicoDetalle;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.GAmbulancia;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GModalidadatencion;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.entities.GTipoDestinoEntity;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.RemisionesDTO;
import com.genoma.plus.jpa.projection.ListRemisionesDTO;
import com.genoma.plus.jpa.service.IAmbulanciaService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IEspecialidadService;
import com.genoma.plus.jpa.service.IMunicipioService;
import com.genoma.plus.jpa.service.IRemisionesService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPORemisiones1.class */
public class JPORemisiones1 extends JPanel {
    private clasesHistoriaCE xclase;
    private String[] idespecialida;
    private String[] xidempresa;
    private String[] xidmunicipio;
    private int esllenado;
    private int xtipo;
    private String xsql;
    private String xplaca;
    private String xconductor;
    private ReporteRemision xReporteRemision;
    private ReporteContraRemision xReporteContraRemision;
    private boolean xForma;
    private Object[] dato;
    private ResultSet rs;
    private RemisionesDTO remisionesDTO;
    List<GEspecialidad> listEspecialidad;
    List<MunicipioDTO> listMunicipios;
    List<EmpresaContConvenioEntity> listEmpresaCont;
    List<ListRemisionesDTO> listarRemisiones;
    private List<GAmbulancia> ambulancia;
    private Integer idAmbulancia;
    public List<GServicioGrupoEntity> listGrupoEntitys;
    public List<GServicioRipsEntity> ListripsEntitys;
    public List<GModalidadatencion> listGModalidadatencions;
    private String[] idDestino;
    private ButtonGroup JBGAmbulancia;
    private ButtonGroup JBGHospitalizacion;
    private ButtonGroup JBGTipoAtencionSolicitada;
    private ButtonGroup JBGTipoProceso;
    private ButtonGroup JBGUrgente;
    private JPanel JBTRemitido;
    public JComboBox JCBAmbulancia;
    private JComboBox JCBDestino;
    public JComboBox JCBEmpresaCR;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBModalidadAtencion;
    public JComboBox JCBMunicipio;
    public JComboBox JCBSevicioRips;
    private JCheckBox JCHLimpiar;
    private JCheckBox JCH_S_Prioritaria;
    private JCheckBox JCH_S_Urgencia;
    private JCheckBox JCH_S_programable;
    private JCheckBox JCH_UtilizarDxEgreso;
    private JCheckBox JCKContrareferencia;
    private JCheckBox JCKReferecia;
    private JCheckBox JCKinterconsulta;
    private JLabel JLBEstado;
    private JLabel JLBIdAtencion1;
    private JLabel JLBNRemision;
    private JPanel JPRemisiones;
    private JRadioButton JRBNoP8;
    private JRadioButton JRBNoP9;
    private JRadioButton JRBSiP8;
    private JRadioButton JRBSiP9;
    private JRadioButton JRBUNo;
    private JRadioButton JRBUSi;
    private JScrollPane JSPDRObservaciones;
    private JScrollPane JSPEor;
    private JScrollPane JSPHistorico;
    private JTextPane JTADRObservaciones;
    private JTextPane JTADRemisiones;
    private JTable JTBDetalle;
    private JTabbedPane JTDRemision;
    public JTextField JTFCHabitacion;
    private JTextField JTFConductor;
    public JTextField JTFInstirucionRecibe;
    private JTextField JTFProfesionalRecibe;

    /* JADX INFO: renamed from: JTFProfesión, reason: contains not printable characters */
    private JTextField f11JTFProfesin;
    private JTextPane JTPP8;
    private JTextPane JTPP9;
    private JToggleButton btnCita;
    private JToggleButton btnCita1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFecha;
    public JFormattedTextField txtHora;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xp8 = 0;
    private int xp9 = 0;
    private int urgente = 0;
    private int xidm = -1;
    private int xidem = -1;
    private String nombreAmbulancia = "";
    private DefaultTableModel xmodelod = new DefaultTableModel();
    private TableColumn column = null;
    private int xestado = 0;
    private final IRemisionesService remisiones = (IRemisionesService) Principal.contexto.getBean(IRemisionesService.class);
    private final IEspecialidadService especialidadService = (IEspecialidadService) Principal.contexto.getBean(IEspecialidadService.class);
    private final IMunicipioService municipioService = (IMunicipioService) Principal.contexto.getBean(IMunicipioService.class);
    private final IEmpresaContConvenioService empresaContService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
    public Boolean lleno = false;
    private final IAmbulanciaService ambulanciaService = (IAmbulanciaService) Principal.contexto.getBean(IAmbulanciaService.class);
    private String tipoAtencionSolictada = "02";

    public JPORemisiones1(clasesHistoriaCE xclase, int xtipo, boolean xForma) {
        this.esllenado = 0;
        this.xtipo = 0;
        initComponents();
        nuevo();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xclase = xclase;
        this.xtipo = xtipo;
        this.xForma = xForma;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
            this.JCH_UtilizarDxEgreso.setEnabled(false);
        } else {
            this.JCH_UtilizarDxEgreso.setEnabled(true);
        }
        JTextComponent editor = this.JCBEspecialidad.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.JCBEspecialidad));
        this.txtFecha.setDate(this.xmetodo.getFechaActualPC());
        this.txtHora.setValue(this.xmetodo.getFechaActual());
        mComponerDatosInicialesRemision();
        this.xconsultasbd.cerrarConexionBd();
        this.esllenado = 1;
        mRadioButonFalse();
        mDatosAmbulancia();
        mCargarDatos();
        this.remisionesDTO = new RemisionesDTO();
        this.JLBIdAtencion1.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
    }

    private void llenarComboAmbulancia() {
        this.ambulancia = this.ambulanciaService.listaAmbualanciaEstado(true);
        this.JCBAmbulancia.removeAllItems();
        this.ambulancia.forEach(GAmbulancia -> {
            this.JCBAmbulancia.addItem(GAmbulancia.getPlaca());
        });
    }

    private void initComponents() {
        this.JBGUrgente = new ButtonGroup();
        this.JBGHospitalizacion = new ButtonGroup();
        this.JBGAmbulancia = new ButtonGroup();
        this.JBGTipoAtencionSolicitada = new ButtonGroup();
        this.JBGTipoProceso = new ButtonGroup();
        this.JTDRemision = new JTabbedPane();
        this.JPRemisiones = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JSPEor = new JScrollPane();
        this.JTADRemisiones = new JTextPane();
        this.jPanel1 = new JPanel();
        this.JRBUSi = new JRadioButton();
        this.JRBUNo = new JRadioButton();
        this.JLBNRemision = new JLabel();
        this.JLBEstado = new JLabel();
        this.JCHLimpiar = new JCheckBox();
        this.JCH_UtilizarDxEgreso = new JCheckBox();
        this.JLBIdAtencion1 = new JLabel();
        this.jPanel4 = new JPanel();
        this.JCH_S_Urgencia = new JCheckBox();
        this.JCH_S_Prioritaria = new JCheckBox();
        this.JCH_S_programable = new JCheckBox();
        this.jPanel5 = new JPanel();
        this.JCKReferecia = new JCheckBox();
        this.JCKContrareferencia = new JCheckBox();
        this.JCKinterconsulta = new JCheckBox();
        this.JSPHistorico = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.btnCita = new JToggleButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.JBTRemitido = new JPanel();
        this.JCBEmpresaCR = new JComboBox();
        this.JSPDRObservaciones = new JScrollPane();
        this.JTADRObservaciones = new JTextPane();
        this.JTFProfesionalRecibe = new JTextField();
        this.JTFInstirucionRecibe = new JTextField();
        this.JCBMunicipio = new JComboBox();
        this.f11JTFProfesin = new JTextField();
        this.JTFCHabitacion = new JTextField();
        this.jPanel2 = new JPanel();
        this.JTPP8 = new JTextPane();
        this.JTPP9 = new JTextPane();
        this.JTFConductor = new JTextField();
        this.JRBSiP9 = new JRadioButton();
        this.JRBNoP8 = new JRadioButton();
        this.JRBSiP8 = new JRadioButton();
        this.JRBNoP9 = new JRadioButton();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtHora = new JFormattedTextField();
        this.JCBAmbulancia = new JComboBox();
        this.jPanel3 = new JPanel();
        this.JCBModalidadAtencion = new JComboBox();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.JCBDestino = new JComboBox();
        this.btnCita1 = new JToggleButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ORDEN DE INTERCONSULTA O REMISIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpremisiones1");
        this.JTDRemision.setForeground(Color.red);
        this.JTDRemision.setFont(new Font("Arial", 1, 14));
        this.JPRemisiones.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 18)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JPORemisiones1.1
            public void itemStateChanged(ItemEvent evt) {
                JPORemisiones1.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBEspecialidad.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.2
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.JCBEspecialidadKeyPressed(evt);
            }
        });
        this.JSPEor.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTADRemisiones.setFont(new Font("Arial", 1, 12));
        this.JTADRemisiones.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.3
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.JTADRemisionesKeyPressed(evt);
            }
        });
        this.JSPEor.setViewportView(this.JTADRemisiones);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Es Prioritaria ?", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGUrgente.add(this.JRBUSi);
        this.JRBUSi.setFont(new Font("Arial", 1, 12));
        this.JRBUSi.setForeground(Color.blue);
        this.JRBUSi.setText("Si");
        this.JRBUSi.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.4
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBUSiActionPerformed(evt);
            }
        });
        this.JRBUSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.5
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.JRBUSiKeyPressed(evt);
            }
        });
        this.JBGUrgente.add(this.JRBUNo);
        this.JRBUNo.setFont(new Font("Arial", 1, 12));
        this.JRBUNo.setForeground(Color.blue);
        this.JRBUNo.setSelected(true);
        this.JRBUNo.setText("No");
        this.JRBUNo.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.6
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBUNoActionPerformed(evt);
            }
        });
        this.JRBUNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.7
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.JRBUNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBUSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBUNo).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUSi).addComponent(this.JRBUNo)));
        this.JLBNRemision.setBackground(new Color(255, 255, 255));
        this.JLBNRemision.setFont(new Font("Arial", 1, 18));
        this.JLBNRemision.setForeground(new Color(255, 0, 0));
        this.JLBNRemision.setHorizontalAlignment(0);
        this.JLBNRemision.setBorder(BorderFactory.createTitledBorder((Border) null, "N° InterConsulta", 2, 0, new Font("Arial", 1, 12), new Color(255, 51, 51)));
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(new Color(255, 0, 0));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHLimpiar.setFont(new Font("Arial", 1, 12));
        this.JCHLimpiar.setForeground(new Color(255, 0, 0));
        this.JCHLimpiar.setText("No utlizar resumen de atención.");
        this.JCHLimpiar.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.8
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCHLimpiarActionPerformed(evt);
            }
        });
        this.JCH_UtilizarDxEgreso.setFont(new Font("Arial", 1, 12));
        this.JCH_UtilizarDxEgreso.setForeground(new Color(255, 0, 0));
        this.JCH_UtilizarDxEgreso.setText("Utilizar Diagnóstico de Egreso?");
        this.JCH_UtilizarDxEgreso.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.9
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCH_UtilizarDxEgresoActionPerformed(evt);
            }
        });
        this.JLBIdAtencion1.setBackground(new Color(255, 255, 255));
        this.JLBIdAtencion1.setFont(new Font("Arial", 1, 18));
        this.JLBIdAtencion1.setForeground(new Color(255, 0, 0));
        this.JLBIdAtencion1.setHorizontalAlignment(0);
        this.JLBIdAtencion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Id.Atencion", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo atención solicitada", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoAtencionSolicitada.add(this.JCH_S_Urgencia);
        this.JCH_S_Urgencia.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Urgencia.setText("Servicios y tecnologías en casos posteriores a urgencia ");
        this.JCH_S_Urgencia.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.10
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCH_S_UrgenciaActionPerformed(evt);
            }
        });
        this.JBGTipoAtencionSolicitada.add(this.JCH_S_Prioritaria);
        this.JCH_S_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Prioritaria.setSelected(true);
        this.JCH_S_Prioritaria.setText("Servicios y tecnologias en atención prioritaria");
        this.JCH_S_Prioritaria.setToolTipText("");
        this.JCH_S_Prioritaria.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.11
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCH_S_PrioritariaActionPerformed(evt);
            }
        });
        this.JBGTipoAtencionSolicitada.add(this.JCH_S_programable);
        this.JCH_S_programable.setFont(new Font("Arial", 1, 12));
        this.JCH_S_programable.setText("Servicios y tecnologías de salud electivos o programables no prioritaria");
        this.JCH_S_programable.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.12
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCH_S_programableActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_S_programable, -2, 483, -2).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCH_S_Urgencia, -2, 365, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_S_Prioritaria, -2, 309, -2))).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_S_Urgencia).addComponent(this.JCH_S_Prioritaria)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_S_programable).addContainerGap()));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoProceso.add(this.JCKReferecia);
        this.JCKReferecia.setFont(new Font("Arial", 1, 12));
        this.JCKReferecia.setForeground(new Color(0, 0, 255));
        this.JCKReferecia.setText("Referencia");
        this.JCKReferecia.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.13
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCKRefereciaActionPerformed(evt);
            }
        });
        this.JBGTipoProceso.add(this.JCKContrareferencia);
        this.JCKContrareferencia.setFont(new Font("Arial", 1, 12));
        this.JCKContrareferencia.setForeground(new Color(0, 0, 255));
        this.JCKContrareferencia.setText("Contrareferencia");
        this.JCKContrareferencia.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.14
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCKContrareferenciaActionPerformed(evt);
            }
        });
        this.JBGTipoProceso.add(this.JCKinterconsulta);
        this.JCKinterconsulta.setFont(new Font("Arial", 1, 12));
        this.JCKinterconsulta.setForeground(new Color(0, 0, 255));
        this.JCKinterconsulta.setText("Interconsulta");
        this.JCKinterconsulta.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.15
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCKinterconsultaActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JCKReferecia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCKContrareferencia)).addGroup(jPanel5Layout.createSequentialGroup().addGap(59, 59, 59).addComponent(this.JCKinterconsulta, -2, 144, -2))).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCKReferecia).addComponent(this.JCKContrareferencia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCKinterconsulta, -2, 19, -2)));
        GroupLayout JPRemisionesLayout = new GroupLayout(this.JPRemisiones);
        this.JPRemisiones.setLayout(JPRemisionesLayout);
        JPRemisionesLayout.setHorizontalGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addContainerGap().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPEor).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JLBNRemision, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JLBEstado, -2, 95, -2).addGap(395, 395, 395).addComponent(this.JLBIdAtencion1, -1, -1, 32767)))).addGroup(JPRemisionesLayout.createSequentialGroup().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPRemisionesLayout.createSequentialGroup().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEspecialidad, -2, 403, -2).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JCHLimpiar).addGap(18, 18, 18).addComponent(this.JCH_UtilizarDxEgreso))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel5, -2, -1, -2))).addGap(0, 0, 32767))).addContainerGap()));
        JPRemisionesLayout.setVerticalGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPRemisionesLayout.createSequentialGroup().addContainerGap().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHLimpiar).addComponent(this.JCH_UtilizarDxEgreso)).addGap(14, 14, 14)).addGroup(JPRemisionesLayout.createSequentialGroup().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(33, 33, 33)).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.jPanel4, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JSPEor, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBNRemision, -2, 40, -2).addComponent(this.JLBEstado, -2, 40, -2).addComponent(this.JLBIdAtencion1, -2, 40, -2)).addGap(5, 5, 5)));
        this.JTDRemision.addTab("DESCRIPCIÓN", this.JPRemisiones);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPORemisiones1.16
            public void mouseClicked(MouseEvent evt) {
                JPORemisiones1.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTBDetalle);
        this.JTDRemision.addTab("HISTÓRICO", this.JSPHistorico);
        this.btnCita.setFont(new Font("Arial", 1, 12));
        this.btnCita.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.btnCita.setText("Asigar Cita");
        this.btnCita.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.17
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.btnCitaActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JBTRemitido.setBorder(BorderFactory.createEtchedBorder());
        this.JCBEmpresaCR.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaCR.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa por la cual se remite", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresaCR.addItemListener(new ItemListener() { // from class: Historia.JPORemisiones1.18
            public void itemStateChanged(ItemEvent evt) {
                JPORemisiones1.this.JCBEmpresaCRItemStateChanged(evt);
            }
        });
        this.JSPDRObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADRObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTADRObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.19
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.JTADRObservacionesKeyPressed(evt);
            }
        });
        this.JSPDRObservaciones.setViewportView(this.JTADRObservaciones);
        this.JTFProfesionalRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFProfesionalRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFInstirucionRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFInstirucionRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Institución que Recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFInstirucionRecibe.addMouseListener(new MouseAdapter() { // from class: Historia.JPORemisiones1.20
            public void mouseClicked(MouseEvent evt) {
                JPORemisiones1.this.JTFInstirucionRecibeMouseClicked(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: Historia.JPORemisiones1.21
            public void itemStateChanged(ItemEvent evt) {
                JPORemisiones1.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.f11JTFProfesin.setFont(new Font("Arial", 1, 12));
        this.f11JTFProfesin.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCHabitacion.setFont(new Font("Arial", 1, 12));
        this.JTFCHabitacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo habilitacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCHabitacion.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.22
            public void keyTyped(KeyEvent evt) {
                JPORemisiones1.this.JTFCHabitacionKeyTyped(evt);
            }
        });
        GroupLayout JBTRemitidoLayout = new GroupLayout(this.JBTRemitido);
        this.JBTRemitido.setLayout(JBTRemitidoLayout);
        JBTRemitidoLayout.setHorizontalGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JBTRemitidoLayout.createSequentialGroup().addContainerGap().addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEmpresaCR, 0, 261, 32767).addComponent(this.JTFProfesionalRecibe)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMunicipio, 0, 197, 32767).addComponent(this.f11JTFProfesin)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createSequentialGroup().addComponent(this.JTFInstirucionRecibe, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCHabitacion, -1, 176, 32767)).addComponent(this.JSPDRObservaciones)).addContainerGap()));
        JBTRemitidoLayout.setVerticalGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createSequentialGroup().addContainerGap().addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresaCR).addComponent(this.JCBMunicipio).addComponent(this.JTFInstirucionRecibe, -2, -1, -2).addComponent(this.JTFCHabitacion, -2, -1, -2)).addGap(9, 9, 9).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.f11JTFProfesin, -2, -1, -2).addComponent(this.JTFProfesionalRecibe, -2, -1, -2)).addComponent(this.JSPDRObservaciones, GroupLayout.Alignment.TRAILING, -2, 41, -2)).addGap(20, 20, 20)));
        this.jTabbedPane1.addTab("DATOS DE REMISIÓN (LLENAR SOLO EN CASOS DE TRASLADO)", this.JBTRemitido);
        this.JTPP8.setEditable(false);
        this.JTPP8.setBorder((Border) null);
        this.JTPP8.setFont(new Font("Arial", 1, 12));
        this.JTPP8.setForeground(Color.blue);
        this.JTPP8.setText("El paciente amerita Hospitalización?");
        this.JTPP8.setOpaque(false);
        this.JTPP9.setEditable(false);
        this.JTPP9.setBorder((Border) null);
        this.JTPP9.setFont(new Font("Arial", 1, 12));
        this.JTPP9.setForeground(Color.blue);
        this.JTPP9.setText("El paciente amerita traslado de Ambulancia?");
        this.JTPP9.setOpaque(false);
        this.JTFConductor.setFont(new Font("Arial", 1, 12));
        this.JTFConductor.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Conductor", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGAmbulancia.add(this.JRBSiP9);
        this.JRBSiP9.setFont(new Font("Arial", 1, 12));
        this.JRBSiP9.setText("Sí");
        this.JRBSiP9.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.23
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBSiP9ActionPerformed(evt);
            }
        });
        this.JBGHospitalizacion.add(this.JRBNoP8);
        this.JRBNoP8.setFont(new Font("Arial", 1, 12));
        this.JRBNoP8.setSelected(true);
        this.JRBNoP8.setText("No");
        this.JRBNoP8.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.24
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBNoP8ActionPerformed(evt);
            }
        });
        this.JBGHospitalizacion.add(this.JRBSiP8);
        this.JRBSiP8.setFont(new Font("Arial", 1, 12));
        this.JRBSiP8.setText("Sí");
        this.JRBSiP8.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.25
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBSiP8ActionPerformed(evt);
            }
        });
        this.JBGAmbulancia.add(this.JRBNoP9);
        this.JRBNoP9.setFont(new Font("Arial", 1, 12));
        this.JRBNoP9.setSelected(true);
        this.JRBNoP9.setText("No");
        this.JRBNoP9.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.26
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JRBNoP9ActionPerformed(evt);
            }
        });
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.27
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.txtFechaKeyPressed(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Arial", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPORemisiones1.28
            public void keyPressed(KeyEvent evt) {
                JPORemisiones1.this.txtHoraKeyPressed(evt);
            }
        });
        this.JCBAmbulancia.setFont(new Font("Arial", 1, 12));
        this.JCBAmbulancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambulancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAmbulancia.addItemListener(new ItemListener() { // from class: Historia.JPORemisiones1.29
            public void itemStateChanged(ItemEvent evt) {
                JPORemisiones1.this.JCBAmbulanciaItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFConductor, -2, 420, -2).addContainerGap(-1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPP8, -2, 224, -2).addComponent(this.JTPP9, -2, 267, -2)).addGap(27, 27, 27).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBSiP9).addGap(18, 18, 18).addComponent(this.JRBNoP9)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBSiP8).addGap(18, 18, 18).addComponent(this.JRBNoP8))).addGap(35, 35, 35).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtHora, -2, 110, -2)).addComponent(this.JCBAmbulancia, -2, 298, -2)).addGap(0, 113, 32767)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBAmbulancia, -2, -1, -2).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFecha, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.txtHora, GroupLayout.Alignment.TRAILING, -2, -1, -2))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPP8, -2, -1, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP8, -1, -1, 32767).addComponent(this.JRBSiP8))).addGap(0, 0, 0).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPP9, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP9, -1, -1, 32767).addComponent(this.JRBSiP9))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConductor, -2, -1, -2).addGap(3, 3, 3))).addGap(5, 5, 5)));
        this.jTabbedPane1.addTab("DATOS ADICIONALES PARA LA REMISIÓN", this.jPanel2);
        this.JCBModalidadAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBModalidadAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Modalidad Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBModalidadAtencion.setName("modalidadAtencion");
        this.JCBModalidadAtencion.addMouseListener(new MouseAdapter() { // from class: Historia.JPORemisiones1.30
            public void mouseClicked(MouseEvent evt) {
                JPORemisiones1.this.JCBModalidadAtencionMouseClicked(evt);
            }
        });
        this.JCBModalidadAtencion.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.31
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.JCBModalidadAtencionActionPerformed(evt);
            }
        });
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Historia.JPORemisiones1.32
            public void itemStateChanged(ItemEvent evt) {
                JPORemisiones1.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        this.JCBDestino.setFont(new Font("Arial", 1, 12));
        this.JCBDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Condición destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.JCBGrupoSevicio, -2, 253, -2).addGap(18, 18, 18).addComponent(this.JCBSevicioRips, -2, 489, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.JCBModalidadAtencion, -2, 388, -2).addGap(18, 18, 18).addComponent(this.JCBDestino, -2, 290, -2))).addGap(50, 50, 50)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, -1, -2).addComponent(this.JCBSevicioRips, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBModalidadAtencion, -2, -1, -2).addComponent(this.JCBDestino)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("INFORMACIÓN ANEXO1", this.jPanel3);
        this.btnCita1.setFont(new Font("Arial", 1, 12));
        this.btnCita1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Sirel_icono27x27.png")));
        this.btnCita1.setText("Abrir enlace SIREL");
        this.btnCita1.setToolTipText("Sistema Integrado de Regulaciones En Linea");
        this.btnCita1.addActionListener(new ActionListener() { // from class: Historia.JPORemisiones1.33
            public void actionPerformed(ActionEvent evt) {
                JPORemisiones1.this.btnCita1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnCita, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnCita1, -2, 329, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTDRemision)).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTDRemision, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnCita, -1, -1, 32767).addComponent(this.btnCita1, -1, -1, 32767))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.esllenado == 1) {
            this.JTADRemisiones.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUNoActionPerformed(ActionEvent evt) {
        this.urgente = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUSiActionPerformed(ActionEvent evt) {
        this.urgente = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.urgente = 1;
            this.JRBUSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.urgente = 0;
            this.JRBUNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADRemisionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTADRemisiones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCitaActionPerformed(ActionEvent evt) {
        asignarCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADRObservacionesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaCRItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP9ActionPerformed(ActionEvent evt) {
        this.xp9 = 0;
        mDatosAmbulancia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP8ActionPerformed(ActionEvent evt) {
        this.xp8 = 1;
        this.JRBSiP9.setEnabled(true);
        this.JRBNoP9.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP8ActionPerformed(ActionEvent evt) {
        this.xp8 = 0;
        mRadioButonFalse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP9ActionPerformed(ActionEvent evt) {
        this.xp9 = 1;
        this.JCBAmbulancia.setEnabled(true);
        this.JTFConductor.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLimpiarActionPerformed(ActionEvent evt) {
        if (this.JCHLimpiar.isSelected()) {
            this.JTADRemisiones.setText("");
            this.JTADRemisiones.requestFocus();
        } else {
            mComponerDatosInicialesRemision();
            this.JTADRemisiones.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        try {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                mBuscarRemision(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                this.JTDRemision.setSelectedIndex(0);
            }
            if (this.xForma) {
                this.xclase.xjifhistoriaclinica.setSelected(true);
            }
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCHabitacionKeyTyped(KeyEvent evt) {
        mValidaLongitudCampos(12, this.JTFCHabitacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCita1ActionPerformed(ActionEvent evt) {
        try {
            try {
                Desktop.getDesktop().browse(new URI("http://sirel.com.co/"));
            } catch (IOException ex) {
                Logger.getLogger(JPORemisiones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (URISyntaxException ex2) {
            Logger.getLogger(JPORemisiones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_UtilizarDxEgresoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFInstirucionRecibeMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAmbulanciaItemStateChanged(ItemEvent evt) {
        if (this.lleno.booleanValue() && this.JCBAmbulancia.getSelectedIndex() != -1) {
            this.idAmbulancia = this.ambulancia.get(this.JCBAmbulancia.getSelectedIndex()).getId();
            this.nombreAmbulancia = this.ambulancia.get(this.JCBAmbulancia.getSelectedIndex()).getPlaca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_UrgenciaActionPerformed(ActionEvent evt) {
        this.tipoAtencionSolictada = "01";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_PrioritariaActionPerformed(ActionEvent evt) {
        this.tipoAtencionSolictada = "02";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_programableActionPerformed(ActionEvent evt) {
        this.tipoAtencionSolictada = "03";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBModalidadAtencionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBModalidadAtencionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.lleno.booleanValue()) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCKRefereciaActionPerformed(ActionEvent evt) {
        mActivarR();
        this.xtipo = 1;
        this.JCBDestino.setSelectedItem("Referido a otra institución");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCKContrareferenciaActionPerformed(ActionEvent evt) {
        mActivarR();
        this.xtipo = 2;
        this.JCBDestino.setSelectedItem("Contra referido a otra institución");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCKinterconsultaActionPerformed(ActionEvent evt) {
        mDesactivarR();
        this.xtipo = 0;
        this.JCBDestino.setSelectedItem("Paciente derivado a otro servicio");
    }

    private void mRadioButonFalse() {
        this.JRBSiP9.setEnabled(false);
        this.JRBNoP9.setEnabled(false);
    }

    private void mDatosAmbulancia() {
        this.JCBAmbulancia.setEnabled(false);
        this.JTFConductor.setEnabled(false);
        this.JCBAmbulancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa de Ambulancia", 0, 0, new Font("Arial", 1, 10), Color.RED));
        this.JTFConductor.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Conductor", 0, 0, new Font("Arial", 1, 10), Color.RED));
    }

    private void asignarCita() {
        if (this.JLBNRemision.getText().isEmpty()) {
            JOptionPane.showMessageDialog((Component) null, "Por favor, Guarde la Remisión para poder tener acceso a la Cita", "GENOMA SOFT", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        String sql = "SELECT CitaRepetida, AsignarCita FROM g_especialidad WHERE (Id ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND Estado =0)";
        ResultSet rs = this.xconsultasbd.traerRs(sql);
        try {
            rs.next();
            if (rs.getString(2).equals("0")) {
                JOptionPane.showMessageDialog((Component) null, "Esta opción no esta disponible aun para esta Especialidad", "GENOMA SOFT", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else if (!rs.getString(1).equals("4") && rs.getString(2).equals("1")) {
                JDCitasInterConsulta xjdcita = new JDCitasInterConsulta(null, false, this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()).getNbre(), Principal.usuarioSistemaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), this.JCBEspecialidad.getSelectedItem().toString(), this.JLBNRemision.getText(), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
                xjdcita.setVisible(true);
            } else if (rs.getString(1).equals("4") && rs.getString(2).equals("1")) {
                JDCitasInterConsulta xjdcita2 = new JDCitasInterConsulta(null, false, this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()).getNbre(), Principal.usuarioSistemaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), this.JCBEspecialidad.getSelectedItem().toString(), this.JLBNRemision.getText(), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
                xjdcita2.setVisible(true);
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPORemisiones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        if (this.remisionesDTO == null) {
            this.remisionesDTO = new RemisionesDTO();
        }
        GModalidadatencion gModalidadatencion = new GModalidadatencion();
        gModalidadatencion.setId(this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId());
        GServicioRipsEntity servicioRipsEntity = new GServicioRipsEntity();
        servicioRipsEntity.setId(this.listGrupoEntitys.get(this.JCBModalidadAtencion.getSelectedIndex()).getId());
        GTipoDestinoEntity destinoEntity = new GTipoDestinoEntity();
        destinoEntity.setId(Integer.valueOf(this.idDestino[this.JCBModalidadAtencion.getSelectedIndex()]));
        this.remisionesDTO.setIdAtencion(Long.valueOf(this.JLBIdAtencion1.getText()));
        this.remisionesDTO.setFecha(this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()));
        this.remisionesDTO.setHora(this.xmetodo.formatoAMDH24.format(this.txtHora.getValue()));
        this.remisionesDTO.setTipo(Integer.valueOf(this.xtipo));
        this.remisionesDTO.setEspecialidadRemitida(Long.valueOf(this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()).getId().intValue()));
        this.remisionesDTO.setEsUrgente(Boolean.valueOf(this.JRBUSi.isSelected()));
        this.remisionesDTO.setDetalle(this.JTADRemisiones.getText());
        this.remisionesDTO.setIdEmpresaRemite(Long.valueOf(this.xidem));
        this.remisionesDTO.setIdMunicipio(String.valueOf(this.xidm));
        this.remisionesDTO.setInstitucionRecibe(this.JTFInstirucionRecibe.getText());
        this.remisionesDTO.setMedicosRecibe(this.JTFProfesionalRecibe.getText());
        this.remisionesDTO.setProfesionProfesional(this.f11JTFProfesin.getText());
        this.remisionesDTO.setObservacionesRemision(this.JTADRObservaciones.getText());
        this.remisionesDTO.setEstado(false);
        this.remisionesDTO.setIdProfesionalRemite(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        this.remisionesDTO.setIdEspecialidadRemite(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        this.remisionesDTO.setHospitalizado(false);
        this.remisionesDTO.setAmbulancia(1);
        this.remisionesDTO.setPlacaAmbulancia(this.nombreAmbulancia);
        this.remisionesDTO.setConductor(this.JTFConductor.getText());
        this.remisionesDTO.setCodigoHabilitacion(this.JTFCHabitacion.getText());
        this.remisionesDTO.setIdAmbulancia(this.idAmbulancia);
        this.remisionesDTO.setCodigoTipoAtencion(this.tipoAtencionSolictada);
        this.remisionesDTO.setModalidadatencion(gModalidadatencion);
        this.remisionesDTO.setServicioRipsEntity(servicioRipsEntity);
        this.remisionesDTO.setGTipoDestinoEntity(destinoEntity);
        this.remisionesDTO = this.remisiones.grabar(this.remisionesDTO);
        OrdenamientoMedico ordenamientoMedico = OrdenamientoMedico.builder().cerrada(false).descripcion("ORDEN DE REMISIÓN A: " + this.JCBEspecialidad.getSelectedItem()).especialidad(Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad()).profesional(Principal.usuarioSistemaDTO.getNombreUsuario()).estado(true).fechaOrden(this.xmetodo.getFechaActualLocalTime()).idServicio(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()).idAtencion(Long.valueOf(this.JLBIdAtencion1.getText())).idOrden(this.remisionesDTO.getId()).build();
        List<OrdenamientoMedicoDetalle> listDetalles = new ArrayList<>();
        OrdenamientoMedicoDetalle detalle = OrdenamientoMedicoDetalle.builder().codigo(this.listEspecialidad.get(this.JCBEspecialidad.getSelectedIndex()).getId().toString()).cantidad("1").ejecutado(false).nombre(this.JCBEspecialidad.getSelectedItem().toString()).observacion(this.JTADRemisiones.getText()).build();
        listDetalles.add(detalle);
        ordenamientoMedico.setDetalleOrden(listDetalles);
        if (this.xtipo == 1) {
            if (!Principal.informacionIps.getIdentificacion().equals("812005644") || !Principal.informacionIps.getIdentificacion().equals("812004304")) {
                this.xmetodo.getGrabarOrdenamientoMedico(ordenamientoMedico);
            }
        }
    }

    public void grabar() {
        if (this.JLBNRemision.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (!this.JTADRemisiones.getText().isEmpty()) {
                    if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                        if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                            if (this.JCBModalidadAtencion.getSelectedIndex() != -1) {
                                if (this.JTFCHabitacion.getText().isEmpty() || this.JTFCHabitacion.getText().length() == 12) {
                                    mGrabar();
                                    this.JLBNRemision.setText(String.valueOf(this.remisionesDTO.getId()));
                                    this.JLBEstado.setText("ACTIVA");
                                    if (this.xForma) {
                                        int n = JOptionPane.showInternalOptionDialog(this, "Desea asignar la Cita de Interconsulta?", "ASIGNACIÓN DE CITAS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, 0);
                                        if (n == 0) {
                                            asignarCita();
                                            return;
                                        } else {
                                            imprimir();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo codigo de habitacion \n debe tener 12 caracteres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFCHabitacion.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un modalidad de la atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBModalidadAtencion.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un servicio rips", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBSevicioRips.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debes seleccionar una grupo de servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBGrupoSevicio.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo descripción de \n remision no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTADRemisiones.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tDebe seleccionar \n la especialidad a la que remite", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JTFCHabitacion.getText().isEmpty() || this.JTFCHabitacion.getText().length() == 12) {
            mGrabar();
        } else {
            JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo codigo de habitacion \n debe tener 12 caracteres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCHabitacion.requestFocus();
        }
    }

    public void nuevo() {
        this.lleno = false;
        if (this.xtipo == 0) {
            this.JCKinterconsulta.setSelected(true);
            this.xtipo = 0;
            this.JCKReferecia.setEnabled(false);
            this.JCKContrareferencia.setEnabled(false);
            mDesactivarR();
        } else {
            this.JCKinterconsulta.setSelected(false);
            this.JCKinterconsulta.setEnabled(false);
            this.JCKReferecia.setSelected(true);
            this.xtipo = 1;
            mActivarR();
        }
        this.remisionesDTO = new RemisionesDTO();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JLBNRemision.setText("");
        this.JLBEstado.setText((String) null);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JCBEmpresaCR.setSelectedIndex(-1);
        this.JTFInstirucionRecibe.setText((String) null);
        this.JTFProfesionalRecibe.setText((String) null);
        this.JTADRObservaciones.setText((String) null);
        this.JCBEspecialidad.requestFocus();
        this.JCKReferecia.setSelected(false);
        this.JTFCHabitacion.setText("");
        mDesactivarR();
        this.JTADRemisiones.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta());
        mComponerDatosInicialesRemision();
        this.listEspecialidad = new ArrayList();
        this.listEspecialidad = this.especialidadService.listarEspecialidadesPorEstado(false);
        if (!this.listEspecialidad.isEmpty()) {
            this.listEspecialidad.forEach(item -> {
                this.JCBEspecialidad.addItem(item.getNbre());
            });
        }
        this.listMunicipios = new ArrayList();
        this.listMunicipios = this.municipioService.listaMunicipioPorEstado(false);
        if (!this.listMunicipios.isEmpty()) {
            this.listMunicipios.forEach(item2 -> {
                this.JCBMunicipio.addItem(item2.getNombre());
            });
        }
        this.listEmpresaCont = new ArrayList();
        this.listEmpresaCont = this.empresaContService.listarConveniosPorEstado(false);
        if (!this.listEmpresaCont.isEmpty()) {
            this.listEmpresaCont.forEach(item3 -> {
                this.JCBEmpresaCR.addItem(item3.getNbre());
            });
        }
        this.listGModalidadatencions = new ArrayList();
        LlenarCombosGenericos<GModalidadatencion> combosGenericos = new LlenarCombosGenericos<>();
        this.listGModalidadatencions = combosGenericos.getListComboLleno(this.JCBModalidadAtencion.getName());
        this.listGModalidadatencions.forEach(e -> {
            this.JCBModalidadAtencion.addItem(e.getNombre());
        });
        if (!this.listGModalidadatencions.isEmpty()) {
            this.JCBModalidadAtencion.setSelectedItem("Intramural");
        }
        llenarComboAmbulancia();
        llenarComboGrupoServicio();
        this.JCBDestino.removeAllItems();
        this.idDestino = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `g_tipodestino` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.idDestino, this.JCBDestino);
        this.JCBDestino.setSelectedIndex(-1);
        this.lleno = true;
    }

    private void llenarComboGrupoServicio() {
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
    }

    public void imprimir(int x) {
        new Metodos();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "idremision";
            mparametros[0][1] = this.JLBNRemision.getText();
            mparametros[1][0] = "idatencion1";
            mparametros[1][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            mparametros[2][0] = "marca";
            mparametros[2][1] = "HISTORIA CLINICA";
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (!this.JCKReferecia.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (this.JTADRemisiones.getText().length() < 400) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision", mparametros, "RRemisionO1");
                        return;
                    } else {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision", mparametros, "RRemisionO1");
                        return;
                    }
                }
                if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision1", mparametros, "RRemision1");
                        return;
                    } else {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision2", mparametros, "RRemision2");
                            return;
                        }
                        return;
                    }
                }
                Object[] botones = {"Visualizar", "Imprimir", "Cerrar"};
                int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (m == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision1", mparametros);
                        return;
                    } else {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemision2", mparametros);
                            return;
                        }
                        return;
                    }
                }
                if (m == 1) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RRemision1.jasper", mparametros);
                        return;
                    } else {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RRemision2.jasper", mparametros);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (this.JTADRemisiones.getText().length() < 400) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionO", mparametros, "RRemisionO");
                    return;
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionOTO", mparametros, "RRemision");
                    return;
                }
            }
            if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionO1", mparametros, "RRemisionO1");
                    return;
                } else {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionO2", mparametros, "RRemisionO1");
                        return;
                    }
                    return;
                }
            }
            Object[] botones2 = {"Visualizar", "Imprimir", "Cerrar"};
            int m2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            if (m2 == 0) {
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionO1", mparametros, "RRemisionO1");
                    return;
                } else {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RRemisionO2", mparametros, "RRemisionO1");
                        return;
                    }
                    return;
                }
            }
            if (m2 == 1) {
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RRemisionO1.jasper", mparametros);
                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RRemisionO2.jasper", mparametros);
                }
            }
        }
    }

    public void imprimirHojaTraslado() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idremision";
        mparametros[0][1] = this.JLBNRemision.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_HojaTrasladoAsistencial", mparametros, "Pajonal_HojaTrasladoAsistencial");
    }

    public void imprimir() {
        if (!this.JLBNRemision.getText().isEmpty()) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                imprimir(0);
                return;
            }
            Object[] botones1 = {"INSTITUCIONAL", "REFERENCIA", "CONTRAREFERENCIA", "CERRAR"};
            int n = JOptionPane.showOptionDialog(this, "Que desea imprimir?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "CERRAR");
            switch (n) {
                case 0:
                    imprimir(0);
                    break;
                case 1:
                    System.err.println("REFERENCIA");
                    this.xReporteRemision = new ReporteRemision(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), this.JLBNRemision.getText());
                    this.xReporteRemision.build();
                    this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "FReferencia_" + this.JLBNRemision.getText() + ".pdf");
                    break;
                case 2:
                    System.err.println("CONTRAREFERENCIA");
                    this.xReporteContraRemision = new ReporteContraRemision(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                    this.xReporteContraRemision.build();
                    this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "FContraReferencia.pdf");
                    break;
            }
        }
    }

    public void mBuscarRemision(String id) {
        try {
            String sql = " SELECT h_remisiones.Id, h_remisiones.EsUrgente, h_remisiones.Detalle, h_remisiones.Estado, g_especialidad.Nbre, Id_Municipio \n , IFNULL(g_municipio.`Nbre` ,'') MunicipioR, IFNULL(f_empresacontxconvenio.`Nbre`,'') EmpresaC, h_remisiones.`NInstitucion`\n , h_remisiones.`MedicosRecibe`, h_remisiones.`ProfesionPR`, h_remisiones.`ObservacionesRM`, h_remisiones.`PlacaAmbulancia`\n ,h_remisiones.`Conductor`, h_remisiones.`Hospitalizado`, h_remisiones.`Ambulancia`,  IF(f_empresacontxconvenio.`Nbre`=NULL,FALSE, TRUE) EsRemitido, CHabilitacion, idAmbulancia\n FROM h_remisiones \n INNER JOIN g_especialidad ON (h_remisiones.I_Especialidad = g_especialidad.Id) \n LEFT JOIN `f_empresacontxconvenio` ON (h_remisiones.`Id_EmpresaR`= f_empresacontxconvenio.Id) \n LEFT JOIN `g_municipio` ON  (h_remisiones.`Id_Municipio`= g_municipio.Id) \n WHERE (h_remisiones.Id ='" + id + "')";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.first();
                this.JCBEspecialidad.setSelectedItem(rs.getString(5));
                if (rs.getInt(4) == 1) {
                    this.JLBEstado.setText("ANULADA");
                } else {
                    this.JLBEstado.setText("ACTIVA");
                }
                if (rs.getInt(2) == 1) {
                    this.JRBUSi.setSelected(true);
                } else {
                    this.JRBUSi.setSelected(false);
                }
                if (rs.getBoolean("EsRemitido")) {
                    this.JCKReferecia.setSelected(true);
                    mActivarR();
                }
                this.JTADRemisiones.setText(rs.getString(3));
                this.JLBNRemision.setText("" + rs.getInt(1));
                this.JCBEmpresaCR.setSelectedItem(rs.getString("EmpresaC"));
                this.JCBMunicipio.setSelectedItem(rs.getString("MunicipioR"));
                this.JTFInstirucionRecibe.setText(rs.getString("NInstitucion"));
                this.JTFProfesionalRecibe.setText(rs.getString("MedicosRecibe"));
                this.f11JTFProfesin.setText(rs.getString("ProfesionPR"));
                this.JTADRObservaciones.setText(rs.getString("ObservacionesRM"));
                this.JTFConductor.setText(rs.getString("Conductor"));
                if (rs.getBoolean("Hospitalizado")) {
                    this.JRBSiP8.setSelected(true);
                    this.xp8 = 1;
                } else {
                    this.JRBNoP8.setSelected(true);
                    this.xp8 = 0;
                }
                if (rs.getBoolean("Ambulancia")) {
                    this.JRBSiP9.setSelected(true);
                    this.xp9 = 1;
                } else {
                    this.JRBNoP9.setSelected(true);
                    this.xp9 = 0;
                }
                this.JTFCHabitacion.setText(rs.getString("CHabilitacion"));
                Iterator<GAmbulancia> it = this.ambulancia.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GAmbulancia next = it.next();
                    if (next.getId().equals(rs.getString("idAmbulancia"))) {
                        this.JCBAmbulancia.setSelectedItem(next.getPlaca());
                        break;
                    }
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mComponerDatosInicialesRemision() {
        try {
            this.xsql = "SELECT  CONCAT('DATOS EXAMEN FISICO : \n', CONCAT('FC (p/m) : ',h_examenfisico.FCardiaca) ,'     ', CONCAT('FR (r/m): ',h_examenfisico.FRespiratoria) ,'     ', CONCAT('Talla (cm): ',h_examenfisico.Talla),'     ',CONCAT('Peso (Kg): ',h_examenfisico.Peso),'     ',CONCAT('Imc: ',h_examenfisico.IMC) ,'     ',IF( h_examenfisico.TArtSentadoD<>0,CONCAT('Presión : ',`h_examenfisico`.`TArtSentadoS`,'/',`h_examenfisico`.`TArtSentadoD` ),'') ) AS Examen,  ifnull(h_examenfisico.Observacion,'') Observacion, h_atencion.Motivo_atencion, h_atencion.EActual, IF(`h_examenfisico`.`Observacion`=NULL OR `h_examenfisico`.`Observacion`='','',CONCAT('\n\nOBSERVACIÓN EXAMEN FÍSICO:\n',IFNULL(`h_examenfisico`.`Observacion`, ''))) AS ObsExamen FROM  h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) WHERE (h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencion.Id_Especialidad ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'); ";
            this.JTADRemisiones.setText("MC:" + clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta() + "\n\nEA: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual());
            ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getString(3).length() > 0) {
                    this.JTADRemisiones.setText("MC:" + xrs.getString(3) + "\n\n");
                }
                if (xrs.getString(4).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "EA: " + xrs.getString(4) + "\n\n");
                }
                if (xrs.getString(1).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + xrs.getString(1));
                }
                if (xrs.getString(5).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + xrs.getString(5));
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "SELECT h_grupoexamenfisico.Nbre, h_tipoexamenfisico.Nbre, h_detalleexamenfisico.Descripcion , h_grupoexamenfisico.Orden FROM  h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_detalleexamenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_grupoexamenfisico.Id = h_tipoexamenfisico.Id_GrupoExamenFisico) WHERE (h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_detalleexamenfisico.Valor =1) ORDER BY h_grupoexamenfisico.Orden ASC, h_tipoexamenfisico.Nbre ASC ";
            ResultSet xrs2 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.last();
                int xn = xrs2.getRow();
                if (xn == 1) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nDETALLE EXÁMEN FÍSICO\n" + xrs2.getString(1) + "\t" + xrs2.getString(2) + "\t" + xrs2.getString(3));
                } else {
                    xrs2.beforeFirst();
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nDETALLE EXÁMEN FÍSICO");
                    while (xrs2.next()) {
                        this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n" + xrs2.getString(1) + "\t" + xrs2.getString(2) + "\t" + xrs2.getString(3) + "\n");
                    }
                }
            }
            xrs2.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "SELECT IF(Conclusion IS NULL,'',Conclusion) AS Conclusion, IF(Recomendaciones IS NULL,'',Recomendaciones)  AS Recomendaciones FROM h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet xrs3 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs3.next()) {
                xrs3.first();
                if (xrs3.getString(1).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nCONCLUSIÓN \n" + xrs3.getString(1));
                }
                if (xrs3.getString(2).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\nRECOMENDACIONES \n" + xrs3.getString(2));
                }
            }
            xrs3.close();
            this.xconsultasbd.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1 || !this.JCH_UtilizarDxEgreso.isSelected()) {
                this.xsql = "SELECT h_atenciondx.Orden, g_patologia.Id, g_patologia.Nbre FROM h_atenciondx INNER JOIN g_patologia  ON (h_atenciondx.Id_Dx = g_patologia.Id) WHERE (h_atenciondx.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ORDER BY h_atenciondx.Orden ASC ";
                ResultSet xrs4 = this.xconsultasbd.traerRs(this.xsql);
                if (xrs4.next()) {
                    xrs4.last();
                    int xn2 = xrs4.getRow();
                    if (xn2 == 1) {
                        this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nIMPRESIÓN DIAGNÓSTICA\n" + xrs4.getString(1) + "-" + xrs4.getString(2) + "  -  " + xrs4.getString(3));
                    } else {
                        xrs4.beforeFirst();
                        this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nIMPRESIÓN DIAGNÓSTICA\n");
                        while (xrs4.next()) {
                            this.JTADRemisiones.setText(this.JTADRemisiones.getText() + xrs4.getString(1) + "-" + xrs4.getString(2) + "   -   " + xrs4.getString(3) + "\n");
                        }
                    }
                }
                xrs4.close();
                this.xconsultasbd.cerrarConexionBd();
            } else {
                this.xsql = "SELECT `DxP` , `NDxP` , IF(`DxR1`='', '', CONCAT(DxR1,'-', `NDxR1`)) DxR1 \n, IF(`DxR2`='', '', CONCAT(DxR2,'-', `NDxR2`)) DxR2 \n, IF(`DxR3`='', '', CONCAT(DxR3,'-', `NDxR3`)) DxR3 \nFROM `h_egreso_atencion`\nWHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1 AND `Id_Tipo` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() + "')";
                ResultSet xrs5 = this.xconsultasbd.traerRs(this.xsql);
                if (xrs5.next()) {
                    xrs5.first();
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nIMPRESIÓN DIAGNÓSTICA\n" + xrs5.getString("DxP") + "-" + xrs5.getString("NDxP") + " \n" + xrs5.getString("DxR1") + "\n " + xrs5.getString("DxR2") + "\n " + xrs5.getString("DxR3"));
                }
                xrs5.close();
                this.xconsultasbd.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPORemisiones1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void anular() {
        if (!this.JLBNRemision.getText().isEmpty()) {
            int n = JOptionPane.showInternalOptionDialog(this, "Esta seguro de anular", "ANULAR", 0, 3, (Icon) null, (Object[]) null, 0);
            if (n == 0) {
                String sql = "UPDATE h_remisiones SET Estado =1 WHERE Id ='" + this.JLBNRemision.getText() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                this.JLBEstado.setText("ANULADA");
            }
        }
    }

    private void mActivarR() {
        this.JCBMunicipio.setEnabled(true);
        this.JCBEmpresaCR.setEnabled(true);
        this.JTFInstirucionRecibe.setEnabled(true);
        this.JTFCHabitacion.setEnabled(true);
        this.JTFProfesionalRecibe.setEnabled(true);
        this.JTADRObservaciones.setEnabled(true);
        this.JCBEmpresaCR.setSelectedIndex(-1);
        this.JCBMunicipio.setSelectedIndex(-1);
    }

    private void mDesactivarR() {
        this.JCBMunicipio.setEnabled(false);
        this.JCBEmpresaCR.setEnabled(false);
        this.JTFInstirucionRecibe.setEnabled(false);
        this.JTFProfesionalRecibe.setEnabled(false);
        this.JTADRObservaciones.setEnabled(false);
        this.JTFCHabitacion.setEnabled(false);
        this.JCBEmpresaCR.setSelectedIndex(-1);
        this.JCBMunicipio.setSelectedIndex(-1);
    }

    public void buscar() {
        try {
            Component jIFConsultarRemisiones = new JIFConsultarRemisiones(this.xclase, this.xtipo);
            Principal.PanelPpal.add(jIFConsultarRemisiones, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarRemisiones.setVisible(true);
            jIFConsultarRemisiones.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "Especialidad", "Es Prioritaria", "Detalle", "IdIngreso", "IdAtencion", "Tipo"}) { // from class: Historia.JPORemisiones1.34
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelod);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
    }

    private void mCargarDatos() {
        mCrearTablaDetalle();
        this.listarRemisiones = this.remisiones.listarRemisiones(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        if (!this.listarRemisiones.isEmpty()) {
            for (int i = 0; i < this.listarRemisiones.size(); i++) {
                this.xmodelod.addRow(this.dato);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getId(), i, 0);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getFecha(), i, 1);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getNbre(), i, 2);
                if (this.listarRemisiones.get(i).getEsUrgente().equals(true)) {
                    this.xmodelod.setValueAt("Si", i, 3);
                } else {
                    this.xmodelod.setValueAt("No", i, 3);
                }
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getDetalle(), i, 4);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getIdIngreso(), i, 5);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getIdAtencion(), i, 6);
                this.xmodelod.setValueAt(this.listarRemisiones.get(i).getTipo(), i, 7);
            }
        }
    }

    private void mValidaLongitudCampos(int xLimite, JTextField xcampo) {
        if (!xcampo.getText().isEmpty()) {
            if (xcampo.getText().length() < xLimite - 1 || xcampo.getText().length() > xLimite - 1) {
                xcampo.setBackground(new Color(255, 85, 111));
                xcampo.setForeground(Color.WHITE);
                xcampo.setToolTipText("número de caracteres no permitidos");
                return;
            } else {
                if (xcampo.getText().length() == xLimite - 1) {
                    xcampo.setBackground(Color.WHITE);
                    xcampo.setForeground(Color.BLACK);
                    xcampo.setToolTipText((String) null);
                    return;
                }
                return;
            }
        }
        xcampo.setBackground(Color.WHITE);
        xcampo.setForeground(Color.BLACK);
        xcampo.setToolTipText((String) null);
    }
}
