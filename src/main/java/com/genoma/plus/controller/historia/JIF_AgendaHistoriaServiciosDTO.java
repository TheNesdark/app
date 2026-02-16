package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Laboratorio.Render;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDSalidaAdministrativa;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.projection.IInformacionAgendaMedica;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.IHAtencionService;
import com.genoma.plus.jpa.service.UsuarioPorProgramaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_AgendaHistoriaServiciosDTO.class */
public final class JIF_AgendaHistoriaServiciosDTO extends JInternalFrame {
    private HistoriaDAO historiaDAO;
    public FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
    private DefaultTableModel modeloModel;
    private DefaultTableModel modeloCitasNPModel;
    private DefaultTableModel modeloServicio;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idServicio;
    private int column;
    private int rowAgendaServicio;
    private Object[] datosAgenServicio;
    private JScrollBar vScroll;
    private boolean isAutoScroll;
    private final UsuarioPorProgramaService xUsuarioPorProgramaService;
    private final EstadoAtencionService estadoAtencionService;
    private final IHAtencionService atencionService;
    private List<GenericCombo> listaTipoServicio;
    private ButtonGroup JBG_Filtrado;
    private ButtonGroup JBG_FiltroEstado;
    private ButtonGroup JBG_FiltroEstadoAtencion;
    private ButtonGroup JBG_FiltroSexo;
    private static JButton JBT_AtencionesPendientes1;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_Clasificado;
    private JCheckBox JCH_Interconsulta;
    private JCheckBox JCH_Observacion;
    private JCheckBox JCH_PorClasificar;
    private JLabel JLB_NumeroRegistro;
    private JPanel JPIEstado;
    private JPanel JPI_Filtro;
    private JPanel JPI_Historia;
    public JPanel JPI_PanelPrincipal;
    private JPanel JPI_Servicios;
    private JSplitPane JPS_PanelHistoria;
    private JPanel JP_FiltroSexo;
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_U;
    private JRadioButton JRBFemenino;
    private JRadioButton JRBMasculino;
    private JRadioButton JRB_AmbosSexo;
    private JScrollPane JSP_AgendaServicios;
    private JScrollPane JSP_Datos1;
    private JScrollPane JSP_Datos2;
    private JTable JTB_AgendaServicios;
    private JTextField JTFBuscar;
    private JTabbedPane JTP_Informacion;
    private JTree JTree_Atencion;
    private JSpinner jSpinner1;
    private DefaultTreeModel modelo = null;
    private String filtroEstado = "1";
    private Metodos metodos = new Metodos();
    private Boolean esLlenoCombo = false;
    private Boolean estadoHilo = true;
    private Vector<ConfiguracionItems> listadoItemsCargados = new Vector<>();
    private Integer estadoAtencion = 0;
    String filtroAtencion = "0";
    private int scrollPosition = 0;
    private int xEntra = 0;
    private int variableTabLlamador = -1;
    private String sexo = "";
    private Integer estadoEgreso = 0;
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);

    public JIF_AgendaHistoriaServiciosDTO() {
        initComponents();
        this.atencionService = (IHAtencionService) Principal.contexto.getBean(IHAtencionService.class);
        this.estadoAtencionService = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
        this.xUsuarioPorProgramaService = (UsuarioPorProgramaService) Principal.contexto.getBean(UsuarioPorProgramaService.class);
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JRBMasculino.setVisible(false);
            this.JRBFemenino.setVisible(false);
            this.JP_FiltroSexo.setVisible(false);
            this.JRB_AmbosSexo.setVisible(false);
        }
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        nuevo();
        mEjecutaTarea();
    }

    private void mEjecutaTarea() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendaHistoriaServiciosDTO.this.estadoAgenda.get()) {
                    JIF_AgendaHistoriaServiciosDTO.this.cargarDatos();
                } else {
                    timer.cancel();
                }
                System.out.println(" tarea ejecutando time");
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JBG_FiltroEstadoAtencion = new ButtonGroup();
        this.JBG_FiltroSexo = new ButtonGroup();
        this.JTP_Informacion = new JTabbedPane();
        this.JPI_Servicios = new JPanel();
        this.JPI_Filtro = new JPanel();
        this.JCB_Servicio = new JComboBox<>();
        this.JCH_PorClasificar = new JCheckBox();
        this.JCH_Clasificado = new JCheckBox();
        this.JCH_Observacion = new JCheckBox();
        this.JCH_Interconsulta = new JCheckBox();
        this.JPIEstado = new JPanel();
        this.JRBEnAtencion_U = new JRadioButton();
        this.JRBDeAlta_U = new JRadioButton();
        this.JTFBuscar = new JTextField();
        this.JLB_NumeroRegistro = new JLabel();
        this.JP_FiltroSexo = new JPanel();
        this.JRBFemenino = new JRadioButton();
        this.JRBMasculino = new JRadioButton();
        this.JRB_AmbosSexo = new JRadioButton();
        this.jSpinner1 = new JSpinner();
        this.JSP_AgendaServicios = new JScrollPane();
        this.JTB_AgendaServicios = new JTable();
        JBT_AtencionesPendientes1 = new JButton();
        this.JPI_Historia = new JPanel();
        this.JPS_PanelHistoria = new JSplitPane();
        this.JSP_Datos1 = new JScrollPane();
        this.JTree_Atencion = new JTree();
        this.JSP_Datos2 = new JScrollPane();
        this.JPI_PanelPrincipal = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORIA CLINICA V2.0");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_historiaclinicav2");
        this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO:", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTP_Informacion.setForeground(new Color(0, 103, 0));
        this.JTP_Informacion.setFont(new Font("Arial", 1, 14));
        this.JTP_Informacion.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.2
            public void stateChanged(ChangeEvent evt) {
                JIF_AgendaHistoriaServiciosDTO.this.JTP_InformacionStateChanged(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setToolTipText("");
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_PorClasificar.setBackground(Color.cyan);
        this.JBG_FiltroEstado.add(this.JCH_PorClasificar);
        this.JCH_PorClasificar.setFont(new Font("Arial", 1, 12));
        this.JCH_PorClasificar.setSelected(true);
        this.JCH_PorClasificar.setText("Por Clasificar");
        this.JCH_Clasificado.setBackground(new Color(133, 218, 160));
        this.JBG_FiltroEstado.add(this.JCH_Clasificado);
        this.JCH_Clasificado.setFont(new Font("Arial", 1, 12));
        this.JCH_Clasificado.setText("Clasificado");
        this.JCH_Observacion.setBackground(Color.orange);
        this.JBG_FiltroEstado.add(this.JCH_Observacion);
        this.JCH_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Observacion.setText("Observación");
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JBG_FiltroEstado.add(this.JCH_Interconsulta);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Interconsulta");
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroEstadoAtencion.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JBG_FiltroEstadoAtencion.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(23, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_NumeroRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NumeroRegistro.setFont(new Font("Arial", 1, 18));
        this.JLB_NumeroRegistro.setForeground(Color.red);
        this.JLB_NumeroRegistro.setHorizontalAlignment(0);
        this.JLB_NumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JP_FiltroSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por sexo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroSexo.add(this.JRBFemenino);
        this.JRBFemenino.setFont(new Font("Arial", 1, 12));
        this.JRBFemenino.setText("F");
        this.JBG_FiltroSexo.add(this.JRBMasculino);
        this.JRBMasculino.setFont(new Font("Arial", 1, 12));
        this.JRBMasculino.setText("M");
        this.JBG_FiltroSexo.add(this.JRB_AmbosSexo);
        this.JRB_AmbosSexo.setFont(new Font("Arial", 1, 12));
        this.JRB_AmbosSexo.setSelected(true);
        this.JRB_AmbosSexo.setText("Ambos");
        GroupLayout JP_FiltroSexoLayout = new GroupLayout(this.JP_FiltroSexo);
        this.JP_FiltroSexo.setLayout(JP_FiltroSexoLayout);
        JP_FiltroSexoLayout.setHorizontalGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroSexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFemenino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMasculino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_AmbosSexo).addContainerGap(13, 32767)));
        JP_FiltroSexoLayout.setVerticalGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroSexoLayout.createSequentialGroup().addGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFemenino).addComponent(this.JRBMasculino).addComponent(this.JRB_AmbosSexo)).addGap(0, 1, 32767)));
        this.jSpinner1.setFont(new Font("Arial", 1, 12));
        this.jSpinner1.setModel(new SpinnerNumberModel(3, 1, 5, 1));
        this.jSpinner1.setToolTipText("Clasificación Triage");
        this.jSpinner1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JCB_Servicio, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFBuscar, -2, 611, -2)).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jSpinner1, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JCH_PorClasificar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Clasificado, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Observacion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Interconsulta))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_NumeroRegistro, -2, 108, -2).addComponent(this.JP_FiltroSexo, -2, -1, -2)).addContainerGap(117, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(7, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstado, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_PorClasificar).addComponent(this.JCH_Clasificado).addComponent(this.JCH_Observacion).addComponent(this.JCH_Interconsulta).addComponent(this.jSpinner1, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFBuscar, -2, 50, -2).addComponent(this.JCB_Servicio))).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addComponent(this.JLB_NumeroRegistro, -1, -1, 32767).addGap(5, 5, 5).addComponent(this.JP_FiltroSexo, -2, -1, -2))).addGap(2, 2, 2)));
        this.JSP_AgendaServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_AgendaServicios.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaServicios.setAutoResizeMode(0);
        this.JTB_AgendaServicios.setRowHeight(30);
        this.JTB_AgendaServicios.setSelectionMode(0);
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        JBT_AtencionesPendientes1.setFont(new Font("Tahoma", 1, 12));
        JBT_AtencionesPendientes1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        JBT_AtencionesPendientes1.setText("Salida Administrativa");
        JBT_AtencionesPendientes1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.3
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaHistoriaServiciosDTO.this.JBT_AtencionesPendientes1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_ServiciosLayout = new GroupLayout(this.JPI_Servicios);
        this.JPI_Servicios.setLayout(JPI_ServiciosLayout);
        JPI_ServiciosLayout.setHorizontalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSP_AgendaServicios).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(JBT_AtencionesPendientes1, -2, 331, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_ServiciosLayout.setVerticalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_AgendaServicios, -2, 499, -2).addGap(18, 18, 18).addComponent(JBT_AtencionesPendientes1, -2, 56, -2).addGap(0, 35, 32767)));
        this.JTP_Informacion.addTab("SERVICIOS", this.JPI_Servicios);
        this.JPS_PanelHistoria.setDividerSize(15);
        this.JPS_PanelHistoria.setResizeWeight(0.1d);
        this.JPS_PanelHistoria.setOneTouchExpandable(true);
        this.JSP_Datos1.setMinimumSize(new Dimension(80, 80));
        this.JSP_Datos1.setPreferredSize(new Dimension(200, 200));
        this.JTree_Atencion.setFont(new Font("Arial", 1, 12));
        this.JTree_Atencion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.4
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaHistoriaServiciosDTO.this.JTree_AtencionMouseClicked(evt);
            }
        });
        this.JTree_Atencion.addTreeSelectionListener(new TreeSelectionListener() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.5
            public void valueChanged(TreeSelectionEvent evt) {
                JIF_AgendaHistoriaServiciosDTO.this.JTree_AtencionValueChanged(evt);
            }
        });
        this.JSP_Datos1.setViewportView(this.JTree_Atencion);
        this.JPS_PanelHistoria.setLeftComponent(this.JSP_Datos1);
        this.JSP_Datos2.setHorizontalScrollBarPolicy(31);
        this.JSP_Datos2.setPreferredSize(new Dimension(804, 504));
        this.JPI_PanelPrincipal.setPreferredSize(new Dimension(800, 500));
        GroupLayout JPI_PanelPrincipalLayout = new GroupLayout(this.JPI_PanelPrincipal);
        this.JPI_PanelPrincipal.setLayout(JPI_PanelPrincipalLayout);
        JPI_PanelPrincipalLayout.setHorizontalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 965, 32767));
        JPI_PanelPrincipalLayout.setVerticalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 692, 32767));
        this.JSP_Datos2.setViewportView(this.JPI_PanelPrincipal);
        this.JPS_PanelHistoria.setRightComponent(this.JSP_Datos2);
        GroupLayout JPI_HistoriaLayout = new GroupLayout(this.JPI_Historia);
        this.JPI_Historia.setLayout(JPI_HistoriaLayout);
        JPI_HistoriaLayout.setHorizontalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPS_PanelHistoria, -1, 1202, 32767).addContainerGap()));
        JPI_HistoriaLayout.setVerticalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPS_PanelHistoria, -1, 700, 32767).addContainerGap()));
        this.JTP_Informacion.addTab("HISTORIA CLINICA", this.JPI_Historia);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Informacion)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Informacion).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTree_AtencionValueChanged(TreeSelectionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTree_AtencionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            TreePath path = this.JTree_Atencion.getSelectionPath();
            Object[] nodos = path.getPath();
            DefaultMutableTreeNode ultimoNodo = (DefaultMutableTreeNode) nodos[nodos.length - 1];
            if (validacionPanel(1)) {
                if (ultimoNodo.isLeaf()) {
                    consultarEstadoItems(ultimoNodo.getUserObject().toString(), 0, false);
                    seleccionarItemArbol();
                    return;
                } else {
                    this.JPI_PanelPrincipal.removeAll();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Faltan campos por diligenciar<br>Por favor revisar!!!</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_InformacionStateChanged(ChangeEvent evt) {
        if (consultarEstadoItems()) {
            if (Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Servicios")) {
                if (this.JTP_Informacion.getSelectedIndex() == 0) {
                    configuracionPanel();
                    this.modelo = null;
                    this.JTree_Atencion.setModel(this.modelo);
                    this.listadoItemsCargados = new Vector<>();
                    this.JPI_PanelPrincipal.removeAll();
                    if (!this.estadoAgenda.get()) {
                        this.estadoAgenda.set(true);
                        mEjecutaTarea();
                        return;
                    }
                    return;
                }
                this.estadoAgenda.set(false);
                return;
            }
            switch (this.JTP_Informacion.getSelectedIndex()) {
                case 0:
                    configuracionPanel();
                    this.modelo = null;
                    this.JTree_Atencion.setModel(this.modelo);
                    this.listadoItemsCargados = new Vector<>();
                    if (!this.estadoAgenda.get()) {
                        this.estadoAgenda.set(true);
                        mEjecutaTarea();
                    }
                    break;
                case 1:
                    configuracionPanel();
                    this.modelo = null;
                    this.JTree_Atencion.setModel(this.modelo);
                    this.listadoItemsCargados = new Vector<>();
                    this.JPI_PanelPrincipal.removeAll();
                    if (!this.estadoAgenda.get()) {
                        this.estadoAgenda.set(true);
                        mEjecutaTarea();
                    }
                    break;
                default:
                    this.estadoAgenda.set(false);
                    break;
            }
        }
        if (this.JTP_Informacion.getSelectedIndex() != this.JTP_Informacion.getTabCount() - 1) {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se encontraron Items Obligatorios sin diligenciar<br>Por favor revisar!!!</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Informacion.setSelectedIndex(this.JTP_Informacion.getTabCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AtencionesPendientes1ActionPerformed(ActionEvent evt) {
        if (this.JCH_PorClasificar.isSelected()) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() != null) {
                JDSalidaAdministrativa salidaAdministrativa = new JDSalidaAdministrativa(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
                salidaAdministrativa.setLocationRelativeTo(this);
                salidaAdministrativa.setVisible(true);
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Funcionalidad solo aplica a usuarios por clasificar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private boolean validacionPanel(int forma) {
        boolean estado = true;
        if (this.JPI_PanelPrincipal.getComponentCount() == 1) {
            for (int i = 0; i < this.listadoItemsCargados.size(); i++) {
                ConfiguracionItems elementAt = this.listadoItemsCargados.elementAt(i);
                if (forma == 0) {
                    if (this.JPI_PanelPrincipal.getComponent(0).getName().equals(elementAt.getNombreFormulario())) {
                        if (elementAt.getValidable().booleanValue()) {
                            if (elementAt.getValidadoCompleto().booleanValue()) {
                                estado = true;
                            } else {
                                estado = false;
                            }
                        } else {
                            estado = true;
                        }
                    }
                } else if (forma == 1) {
                    System.out.println("validable" + elementAt.getValidable());
                    System.out.println("editable" + elementAt.getNombreFormulario());
                    System.out.println("Componente : " + this.JPI_PanelPrincipal.getComponent(0).getName());
                    if (this.JPI_PanelPrincipal.getComponent(0).getName() != null && this.JPI_PanelPrincipal.getComponent(0).getName().equals(elementAt.getNombreFormulario())) {
                        if (elementAt.getValidable().booleanValue()) {
                            System.out.println("vaalidado completo : " + elementAt.getValidadoCompleto());
                            if (elementAt.getValidadoCompleto().booleanValue()) {
                                estado = true;
                            } else {
                                estado = false;
                            }
                        } else {
                            estado = true;
                        }
                    }
                }
            }
        }
        return estado;
    }

    public boolean consultarEstadoItems() {
        boolean estado = true;
        int i = 0;
        while (true) {
            if (i >= this.listadoItemsCargados.size()) {
                break;
            }
            ConfiguracionItems elementAt = this.listadoItemsCargados.get(i);
            if (elementAt.getValidadoCompleto().booleanValue()) {
                i++;
            } else {
                estado = false;
                System.err.println(">>>>>> Nombre Items: " + elementAt.getNombre());
                seleccionarItemArbol(elementAt.getNombre());
                this.funcionalidadPanelHistoriaClinica.cargarPanel(elementAt.getNombreFormulario(), this.JPI_PanelPrincipal, this, elementAt.getNombre(), 1);
                break;
            }
        }
        return estado;
    }

    public void seleccionarItemArbol() {
        TreeNode raiz = (TreeNode) this.JTree_Atencion.getModel().getRoot();
        System.err.println("Hija : " + raiz.children());
        Enumeration<?> e = raiz.children();
        while (e.hasMoreElements()) {
            for (int i = 0; i < raiz.getChildCount(); i++) {
                TreeNode n = (TreeNode) e.nextElement();
                System.err.println("Datos : " + n);
            }
        }
    }

    public void seleccionarItemArbol(String nombreItem) {
        TreeNode raiz = (TreeNode) this.JTree_Atencion.getModel().getRoot();
        System.err.println("Hija : " + raiz.toString());
        Enumeration<?> e = raiz.children();
        while (e.hasMoreElements()) {
            int i = 0;
            while (true) {
                if (i >= raiz.getChildCount()) {
                    break;
                }
                if (e.hasMoreElements()) {
                    TreeNode n = (TreeNode) e.nextElement();
                    if (nombreItem == n.toString().replaceAll("<[^>]*>", "").trim()) {
                        System.err.println("Datos : " + n);
                        break;
                    }
                }
                i++;
            }
        }
    }

    public void consultarEstadoItems(String nombreItem, Integer formaAplicacion, Boolean estado) {
        for (int i = 0; i < this.listadoItemsCargados.size(); i++) {
            ConfiguracionItems elementAt = this.listadoItemsCargados.elementAt(i);
            if (formaAplicacion.intValue() == 0) {
                if (nombreItem.replaceAll("<[^>]*>", "").trim().equals(elementAt.getNombre())) {
                    this.funcionalidadPanelHistoriaClinica.cargarPanel(elementAt.getNombreFormulario(), this.JPI_PanelPrincipal, this, elementAt.getNombre(), 1);
                    return;
                }
            } else if (formaAplicacion.intValue() == 1 && nombreItem.replaceAll("<[^>]*>", "").trim().equals(elementAt.getNombreFormulario())) {
                this.listadoItemsCargados.elementAt(i).setValidadoCompleto(estado);
                if (estado.booleanValue()) {
                    try {
                        TreePath currentSelection = this.JTree_Atencion.getSelectionPath();
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) currentSelection.getLastPathComponent();
                        if (node.getUserObject().toString().replaceAll("<[^>]*>", "").equals(elementAt.getNombre())) {
                            node.setUserObject(new DefaultMutableTreeNode(elementAt.getNombre()));
                            this.JTree_Atencion.getModel().nodeChanged(node);
                            this.JTree_Atencion.setSelectionRow(-1);
                        }
                        return;
                    } catch (NullPointerException e) {
                        return;
                    }
                }
                return;
            }
        }
    }

    private void configuracionPanel() {
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva")) {
            if (this.JTP_Informacion.getSelectedIndex() == 2) {
                this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + "_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "  EDAD: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "  SEXO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "  TIPO CONSULTA : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta() + "  No. Atención : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "  No. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + " F. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), 0, 0, new Font("Arial", 1, 10), Color.red));
                return;
            } else {
                this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 10), Color.red));
                return;
            }
        }
        if (this.JTP_Informacion.getSelectedIndex() == 1) {
            this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + "_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "  EDAD: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "  SEXO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "  TIPO CONSULTA : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta() + "  No. Atención : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "  No. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + " F. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), 0, 0, new Font("Arial", 1, 10), Color.red));
        } else {
            this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 10), Color.red));
        }
    }

    private void inicioInformacionHistoria() {
        configuracionPanel();
        crearArbolItemsHistoria();
    }

    private void crearArbolItemsHistoria() {
        String nombreNodo;
        String nombre;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO != null) {
            this.modelo = null;
            List<ConfiguracionItems> informacionItemsHistoria = null;
            if (!informacionItemsHistoria.isEmpty()) {
                DefaultMutableTreeNode rama = null;
                for (int i = 0; i < informacionItemsHistoria.size(); i++) {
                    if (informacionItemsHistoria.get(i).getIdPadre().longValue() == 0 && informacionItemsHistoria.get(i).getUltimoNivel().booleanValue()) {
                        rama = new DefaultMutableTreeNode(informacionItemsHistoria.get(i).getNombre());
                    } else if (informacionItemsHistoria.get(i).getIdPadre().longValue() != 0 && informacionItemsHistoria.get(i).getUltimoNivel().booleanValue()) {
                        this.JTree_Atencion.getCellRenderer();
                        if (informacionItemsHistoria.get(i).getValidable().booleanValue()) {
                            nombreNodo = "<html><p><span style=\"color: #0000FF;\"><strong>" + informacionItemsHistoria.get(i).getNombre() + "</strong></span></p></html>";
                        } else {
                            nombreNodo = informacionItemsHistoria.get(i).getNombre();
                        }
                        DefaultMutableTreeNode hojasNodo = new DefaultMutableTreeNode(nombreNodo);
                        rama.add(hojasNodo);
                        this.listadoItemsCargados.add(informacionItemsHistoria.get(i));
                        List<ConfiguracionItems> informacionItemsHistoriaHijos = this.historiaDAO.listaItemsPorIdPadre(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), informacionItemsHistoria.get(i).getId(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
                        if (!informacionItemsHistoriaHijos.isEmpty()) {
                            for (int j = 0; j < informacionItemsHistoriaHijos.size(); j++) {
                                if (informacionItemsHistoriaHijos.get(j).getValidable().booleanValue()) {
                                    nombre = "<html><p><span style=\"color: #0000FF;\"><strong>" + informacionItemsHistoriaHijos.get(j).getNombre() + "</strong></span></p></html>";
                                } else {
                                    nombre = informacionItemsHistoriaHijos.get(j).getNombre();
                                }
                                String nombreNodo2 = nombre;
                                DefaultMutableTreeNode hojasNodoHijo = new DefaultMutableTreeNode(nombreNodo2);
                                hojasNodo.add(hojasNodoHijo);
                                this.listadoItemsCargados.add(informacionItemsHistoriaHijos.get(j));
                            }
                        }
                    }
                }
                this.modelo = new DefaultTreeModel(rama);
                System.out.println("Tamaño lista : " + this.listadoItemsCargados.size());
            }
            this.JTree_Atencion.setCellRenderer(new MyTreeCellRenderer());
            this.JTree_Atencion.setModel(this.modelo);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_AgendaHistoriaServiciosDTO$MyTreeRenderer.class */
    public class MyTreeRenderer extends DefaultTreeCellRenderer {
        Boolean validable;
        String nombre;
        private static final String BOLD_FORMAT = "<span style='font-weight: bold;'>%s</span>";
        private static final String ITALIC_STYLE = "<span style='font-style: italic;'>%s</span>";

        public MyTreeRenderer(Boolean validable, String nombre) {
            this.validable = validable;
            this.nombre = nombre;
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            String nombreNodo = "";
            if (this.validable.booleanValue()) {
                nombreNodo = "<html><p><span style=\"color: #0000FF;\"><strong>" + this.nombre + "</strong></span></p></html>";
            }
            setText(nombreNodo);
            return this;
        }
    }

    private void nuevo() {
        crearTablaAgendaServicio();
        this.esLlenoCombo = false;
        LlenarComboServicio();
        if (Principal.informacionIps.getIdentificacion().equals("800080586") || Principal.informacionIps.getIdentificacion().equals("812002836")) {
            this.filtroAtencion = "1";
            this.JCH_Clasificado.setSelected(true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "Documento", "Usuario", "Sexo", "Edad", "Entidad", "Motivo Consulta", "CEspecial", "esAtencionEspecial", "Triage", "Tipo Consulta", "Hora", "Estado", "nombreSexo", "fechaNacimiento", "horaFinal", "idUsuarioAtendido", "idIngreso", "idClaseCita", "idTipohc", "asistida", "idCita", "idAtencion", "idTipoCita", "esRemitada", "idPrograma", "esSaludOcupacional", "esControl", "esOdontologica", "idTratamiento", "Cama", "enfermedadActual", "esPeriodico", "esControlHistoria", "fechaIngreso", "idTipoAtencion", "TipoAtencion", "emailUsuario", "emailsupervisor", "idTipoEmpresa", "idParentesco", "tipoCita", "tipoGuardado", "fecha_HoraAtencion", "idUsuarioPrograma", "idOrden", "idProcedimiento", "idServicio", "idManPower", "filtradoAgenda", "expandirHistoria", "tipoTratamiento", "esTriage", "formaHistoria", "estadoUrgencias", "Especialidad Interconsulta", "fase", "Tiempo(Horas)", "Profesional Asignado en Ingreso", "Accion", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Boolean.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Long.class, String.class, JButton.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_AgendaServicios.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.historia.JIF_AgendaHistoriaServiciosDTO.7
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTB_AgendaServicios.setModel(this.modeloServicio);
        this.JTB_AgendaServicios.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_AgendaServicios.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTB_AgendaServicios.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(6).setPreferredWidth(230);
        this.JTB_AgendaServicios.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTB_AgendaServicios.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(53).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(54).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(55).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(55).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(55).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(56).setPreferredWidth(150);
        this.JTB_AgendaServicios.getColumnModel().getColumn(58).setPreferredWidth(150);
        this.JTB_AgendaServicios.getColumnModel().getColumn(59).setPreferredWidth(300);
        this.JTB_AgendaServicios.getColumnModel().getColumn(60).setPreferredWidth(150);
        this.JTB_AgendaServicios.getColumnModel().getColumn(61).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(61).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(61).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(62).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(62).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(62).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(63).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(63).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(63).setMaxWidth(0);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTB_AgendaServicios.getColumnModel().getColumn(3).setPreferredWidth(250);
            this.JTB_AgendaServicios.getColumnModel().getColumn(5).setPreferredWidth(50);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(31).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(31).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(31).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(57).setPreferredWidth(150);
            return;
        }
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setMaxWidth(0);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_AgendaHistoriaServiciosDTO$MiRenderProgramada.class */
    public class MiRenderProgramada extends DefaultTableCellRenderer {
        public MiRenderProgramada() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 17) != null) {
                int valorCelda = Integer.parseInt(table.getValueAt(row, 17).toString());
                switch (valorCelda) {
                    case 0:
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 1:
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(Color.YELLOW);
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.MAGENTA);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }

    public void cargarDatos() {
        List<Integer> filtroAtencionS = new ArrayList<>();
        filtroAtencionS.add(Integer.valueOf(this.filtroAtencion));
        this.JLB_NumeroRegistro.setText("0");
    }

    private void mAgregaRegistroAgendaServicio(InformacionAgendaMedicaDTO cita) {
        System.out.println("se agrega registro-->" + cita.getIdCita());
        this.rowAgendaServicio++;
        int row = 0;
        for (int i = 0; i < this.JTB_AgendaServicios.getRowCount() && this.modeloServicio.getValueAt(i, 0).toString().equals(cita.getFechaIngreso()); i++) {
            row = i;
        }
        int row2 = row + 1;
        this.modeloServicio.addRow(this.datosAgenServicio);
        this.modeloServicio.setValueAt(cita.getFechaIngreso(), row2, 0);
        this.modeloServicio.setValueAt(cita.getHoraIngreso(), row2, 1);
        this.modeloServicio.setValueAt(cita.getNumeroHistoria(), row2, 2);
        this.modeloServicio.setValueAt(cita.getNombreUsuario(), row2, 3);
        this.modeloServicio.setValueAt(cita.getIdSexo(), row2, 4);
        this.modeloServicio.setValueAt(cita.getEdad(), row2, 5);
        this.modeloServicio.setValueAt(cita.getNombreEmpresaCovenio(), row2, 6);
        this.modeloServicio.setValueAt(cita.getMotivoConsulta(), row2, 7);
        this.modeloServicio.setValueAt(cita.getEsAtencionEspecial(), row2, 9);
        if (null == cita.getEsAtencionEspecial()) {
            this.modeloServicio.setValueAt(new JLabel(""), row2, 8);
        } else {
            switch (cita.getEsAtencionEspecial().intValue()) {
                case 1:
                    this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), row2, 8);
                    break;
                case 2:
                    this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), row2, 8);
                    break;
                case 3:
                    this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), row2, 8);
                    break;
                case 4:
                    this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), row2, 8);
                    break;
                default:
                    this.modeloServicio.setValueAt(new JLabel(""), row2, 8);
                    break;
            }
        }
        this.JTB_AgendaServicios.setDefaultRenderer(JLabel.class, new Render(cita.getEsAtencionEspecial().intValue(), 9));
        this.modeloServicio.setValueAt(cita.getClasificacionTriage(), row2, 10);
        this.modeloServicio.setValueAt(cita.getNombreTipoConsulta(), row2, 11);
        this.modeloServicio.setValueAt(cita.getHoraIncial(), row2, 12);
        this.modeloServicio.setValueAt(cita.getEstadoTextoAtencion(), row2, 13);
        this.modeloServicio.setValueAt(cita.getNombreSexo(), row2, 14);
        this.modeloServicio.setValueAt(cita.getFechaNacimiento(), row2, 15);
        this.modeloServicio.setValueAt(cita.getHoraFinal(), row2, 16);
        this.modeloServicio.setValueAt(cita.getIdUsuarioAtendido(), row2, 17);
        this.modeloServicio.setValueAt(cita.getIdIngreso(), row2, 18);
        this.modeloServicio.setValueAt(cita.getIdClaseCita(), row2, 19);
        this.modeloServicio.setValueAt(cita.getIdTipohc(), row2, 20);
        this.modeloServicio.setValueAt(cita.getAsistida(), row2, 21);
        this.modeloServicio.setValueAt(cita.getIdCita(), row2, 22);
        this.modeloServicio.setValueAt(cita.getIdAtencion(), row2, 23);
        this.modeloServicio.setValueAt(cita.getIdTipoCita(), row2, 24);
        this.modeloServicio.setValueAt(cita.getEsRemitada(), row2, 25);
        this.modeloServicio.setValueAt(cita.getIdPrograma(), row2, 26);
        this.modeloServicio.setValueAt(cita.getEsSaludOcupacional(), row2, 27);
        this.modeloServicio.setValueAt(cita.getEsControl(), row2, 28);
        this.modeloServicio.setValueAt(cita.getEsOdontologica(), row2, 29);
        this.modeloServicio.setValueAt(cita.getIdTratamiento(), row2, 30);
        this.modeloServicio.setValueAt(cita.getCama(), row2, 31);
        this.modeloServicio.setValueAt(cita.getEnfermedadActual(), row2, 32);
        this.modeloServicio.setValueAt(cita.getEsPeriodico(), row2, 33);
        this.modeloServicio.setValueAt(cita.getEsControlHistoria(), row2, 34);
        this.modeloServicio.setValueAt(cita.getFechaIngreso(), row2, 35);
        this.modeloServicio.setValueAt(cita.getIdTipoAtencion(), row2, 36);
        this.modeloServicio.setValueAt(cita.getTipoAtencion(), row2, 37);
        this.modeloServicio.setValueAt(cita.getEmailUsuario(), row2, 38);
        this.modeloServicio.setValueAt(cita.getEmailsupervisor(), row2, 39);
        this.modeloServicio.setValueAt(cita.getIdTipoEmpresa(), row2, 40);
        this.modeloServicio.setValueAt(cita.getIdParentesco(), row2, 41);
        this.modeloServicio.setValueAt(cita.getTipoCita(), row2, 42);
        this.modeloServicio.setValueAt(cita.getTipoGuardado(), row2, 43);
        this.modeloServicio.setValueAt(cita.getFecha_HoraAtencion(), row2, 44);
        this.modeloServicio.setValueAt(cita.getIdUsuarioPrograma(), row2, 45);
        this.modeloServicio.setValueAt(cita.getIdOrden(), row2, 46);
        this.modeloServicio.setValueAt(cita.getIdProcedimiento(), row2, 47);
        this.modeloServicio.setValueAt(cita.getIdServicio(), row2, 48);
        this.modeloServicio.setValueAt(cita.getIdManPower(), row2, 49);
        this.modeloServicio.setValueAt(cita.getFiltradoAgenda(), row2, 50);
        this.modeloServicio.setValueAt(cita.getExpandirHistoria(), row2, 51);
        this.modeloServicio.setValueAt(cita.getTipoTratamiento(), row2, 52);
        this.modeloServicio.setValueAt(cita.getEsTriage(), row2, 53);
        this.modeloServicio.setValueAt(cita.getFormaHistoria(), row2, 54);
        this.modeloServicio.setValueAt(cita.getEstadoUsuarioUrgencias(), row2, 55);
        this.modeloServicio.setValueAt(cita.getEspecialidadInterconsulta(), row2, 56);
        this.modeloServicio.setValueAt(cita.getIdModalidad(), row2, 61);
        this.modeloServicio.setValueAt(cita.getIdEntornoAtencion(), row2, 62);
        this.modeloServicio.setValueAt(cita.getIdTipoDiscapacidad(), row2, 63);
        this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRenderAgendaServicios());
        this.JLB_NumeroRegistro.setText("" + this.rowAgendaServicio);
    }

    private void mCargaAgendaServicios(List<InformacionAgendaMedicaDTO> listadoList) {
        this.xEntra++;
        int numero = 0;
        System.out.println("quita " + listadoList);
        this.JSP_AgendaServicios.remove(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.setViewportView((Component) null);
        this.JSP_AgendaServicios.repaint();
        if (listadoList.size() != -1) {
            if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 3);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 5);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 6);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 56);
            }
            this.rowAgendaServicio = 0;
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloServicio.addRow(this.datosAgenServicio);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), this.rowAgendaServicio, 0);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIngreso(), this.rowAgendaServicio, 1);
                this.modeloServicio.setValueAt(listadoList.get(i).getNumeroHistoria(), this.rowAgendaServicio, 2);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreUsuario(), this.rowAgendaServicio, 3);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdSexo(), this.rowAgendaServicio, 4);
                this.modeloServicio.setValueAt(listadoList.get(i).getEdad(), this.rowAgendaServicio, 5);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreEmpresaCovenio(), this.rowAgendaServicio, 6);
                this.modeloServicio.setValueAt(listadoList.get(i).getMotivoConsulta(), this.rowAgendaServicio, 7);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsAtencionEspecial(), this.rowAgendaServicio, 9);
                if (null == listadoList.get(i).getEsAtencionEspecial()) {
                    this.modeloServicio.setValueAt(new JLabel(""), this.rowAgendaServicio, 8);
                } else {
                    switch (listadoList.get(i).getEsAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 2:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 3:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 4:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), this.rowAgendaServicio, 8);
                            break;
                        default:
                            this.modeloServicio.setValueAt(new JLabel(""), this.rowAgendaServicio, 8);
                            break;
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(JLabel.class, new Render(listadoList.get(i).getEsAtencionEspecial().intValue(), 9));
                this.modeloServicio.setValueAt(listadoList.get(i).getClasificacionTriage(), this.rowAgendaServicio, 10);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreTipoConsulta(), this.rowAgendaServicio, 11);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIncial(), this.rowAgendaServicio, 12);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoTextoAtencion(), this.rowAgendaServicio, 13);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreSexo(), this.rowAgendaServicio, 14);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaNacimiento(), this.rowAgendaServicio, 15);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraFinal(), this.rowAgendaServicio, 16);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioAtendido(), this.rowAgendaServicio, 17);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdIngreso(), this.rowAgendaServicio, 18);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), this.rowAgendaServicio, 19);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipohc(), this.rowAgendaServicio, 20);
                this.modeloServicio.setValueAt(listadoList.get(i).getAsistida(), this.rowAgendaServicio, 21);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdCita(), this.rowAgendaServicio, 22);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdAtencion(), this.rowAgendaServicio, 23);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoCita(), this.rowAgendaServicio, 24);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsRemitada(), this.rowAgendaServicio, 25);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdPrograma(), this.rowAgendaServicio, 26);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsSaludOcupacional(), this.rowAgendaServicio, 27);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControl(), this.rowAgendaServicio, 28);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsOdontologica(), this.rowAgendaServicio, 29);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTratamiento(), this.rowAgendaServicio, 30);
                this.modeloServicio.setValueAt(listadoList.get(i).getCama(), this.rowAgendaServicio, 31);
                this.modeloServicio.setValueAt(listadoList.get(i).getEnfermedadActual(), this.rowAgendaServicio, 32);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsPeriodico(), this.rowAgendaServicio, 33);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControlHistoria(), this.rowAgendaServicio, 34);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), this.rowAgendaServicio, 35);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoAtencion(), this.rowAgendaServicio, 36);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoAtencion(), this.rowAgendaServicio, 37);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailUsuario(), this.rowAgendaServicio, 38);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailsupervisor(), this.rowAgendaServicio, 39);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoEmpresa(), this.rowAgendaServicio, 40);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdParentesco(), this.rowAgendaServicio, 41);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoCita(), this.rowAgendaServicio, 42);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoGuardado(), this.rowAgendaServicio, 43);
                this.modeloServicio.setValueAt(listadoList.get(i).getFecha_HoraAtencion(), this.rowAgendaServicio, 44);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioPrograma(), this.rowAgendaServicio, 45);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdOrden(), this.rowAgendaServicio, 46);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdProcedimiento(), this.rowAgendaServicio, 47);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdServicio(), this.rowAgendaServicio, 48);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdManPower(), this.rowAgendaServicio, 49);
                this.modeloServicio.setValueAt(listadoList.get(i).getFiltradoAgenda(), this.rowAgendaServicio, 50);
                this.modeloServicio.setValueAt(listadoList.get(i).getExpandirHistoria(), this.rowAgendaServicio, 51);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoTratamiento(), this.rowAgendaServicio, 52);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsTriage(), this.rowAgendaServicio, 53);
                this.modeloServicio.setValueAt(listadoList.get(i).getFormaHistoria(), this.rowAgendaServicio, 54);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoUsuarioUrgencias(), this.rowAgendaServicio, 55);
                this.modeloServicio.setValueAt(listadoList.get(i).getEspecialidadInterconsulta(), this.rowAgendaServicio, 56);
                this.modeloServicio.setValueAt(listadoList.get(i).getHora(), this.rowAgendaServicio, 58);
                this.modeloServicio.setValueAt(listadoList.get(i).getProfesionalAsignado(), this.rowAgendaServicio, 59);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdModalidad(), this.rowAgendaServicio, 61);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdEntornoAtencion(), this.rowAgendaServicio, 62);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoDiscapacidad(), this.rowAgendaServicio, 63);
                if (isNumber(listadoList.get(i).getFase()) && listadoList.get(i).getIdTipoAtencion().intValue() > 1) {
                    int fase = Integer.parseInt(listadoList.get(i).getFase());
                    double valor = Math.floor(fase / 30) + 1.0d;
                    if (listadoList.get(i).getIdTipoAtencion().intValue() != 4) {
                        this.modeloServicio.setValueAt(fase + " días", this.rowAgendaServicio, 57);
                    } else if (valor > 6.0d) {
                        this.modeloServicio.setValueAt("Ha superado la fase 6  " + fase + " días", this.rowAgendaServicio, 57);
                    } else {
                        this.modeloServicio.setValueAt("fase " + valor + " -  " + fase + " días", this.rowAgendaServicio, 57);
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRenderAgendaServicios());
                numero++;
                this.rowAgendaServicio++;
            }
            this.modeloServicio.setRowCount(listadoList.size());
            this.modeloServicio.fireTableDataChanged();
            System.out.println("combo " + this.idServicio[this.JCB_Servicio.getSelectedIndex()]);
            if (this.idServicio[this.JCB_Servicio.getSelectedIndex()].equals("4")) {
            }
        }
        System.out.println("Coloca tabla");
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.repaint();
        System.out.println("Entra this.JTB_AgendaServicios.getRowCount()-->" + this.JTB_AgendaServicios.getRowCount());
        this.JLB_NumeroRegistro.setText("" + numero);
    }

    private void mCargaAgendaServicios_P(List<IInformacionAgendaMedica> listadoList) {
        this.xEntra++;
        int numero = 0;
        System.out.println("" + listadoList.isEmpty());
        this.JSP_AgendaServicios.remove(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.setViewportView((Component) null);
        this.JSP_AgendaServicios.repaint();
        if (!listadoList.isEmpty()) {
            if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 3);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 5);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 6);
                this.metodos.mEstablecerTextEditor(this.JTB_AgendaServicios, 56);
            }
            this.rowAgendaServicio = 0;
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloServicio.addRow(this.datosAgenServicio);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), this.rowAgendaServicio, 0);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIngreso(), this.rowAgendaServicio, 1);
                this.modeloServicio.setValueAt(listadoList.get(i).getNumeroHistoria(), this.rowAgendaServicio, 2);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreUsuario(), this.rowAgendaServicio, 3);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdSexo(), this.rowAgendaServicio, 4);
                this.modeloServicio.setValueAt(listadoList.get(i).getEdad(), this.rowAgendaServicio, 5);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreEmpresaCovenio(), this.rowAgendaServicio, 6);
                this.modeloServicio.setValueAt(listadoList.get(i).getMotivoConsulta(), this.rowAgendaServicio, 7);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsAtencionEspecial(), this.rowAgendaServicio, 9);
                if (null == listadoList.get(i).getEsAtencionEspecial()) {
                    this.modeloServicio.setValueAt(new JLabel(""), this.rowAgendaServicio, 8);
                } else {
                    switch (listadoList.get(i).getEsAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 2:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 3:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), this.rowAgendaServicio, 8);
                            break;
                        case 4:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), this.rowAgendaServicio, 8);
                            break;
                        default:
                            this.modeloServicio.setValueAt(new JLabel(""), this.rowAgendaServicio, 8);
                            break;
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(JLabel.class, new Render(listadoList.get(i).getEsAtencionEspecial().intValue(), 9));
                this.modeloServicio.setValueAt(listadoList.get(i).getClasificacionTriage(), this.rowAgendaServicio, 10);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreTipoConsulta(), this.rowAgendaServicio, 11);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIncial(), this.rowAgendaServicio, 12);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoTextoAtencion(), this.rowAgendaServicio, 13);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreSexo(), this.rowAgendaServicio, 14);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaNacimiento(), this.rowAgendaServicio, 15);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraFinal(), this.rowAgendaServicio, 16);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioAtendido(), this.rowAgendaServicio, 17);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdIngreso(), this.rowAgendaServicio, 18);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), this.rowAgendaServicio, 19);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipohc(), this.rowAgendaServicio, 20);
                this.modeloServicio.setValueAt(listadoList.get(i).getAsistida(), this.rowAgendaServicio, 21);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdCita(), this.rowAgendaServicio, 22);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdAtencion(), this.rowAgendaServicio, 23);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoCita(), this.rowAgendaServicio, 24);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsRemitada(), this.rowAgendaServicio, 25);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdPrograma(), this.rowAgendaServicio, 26);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsSaludOcupacional(), this.rowAgendaServicio, 27);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControl(), this.rowAgendaServicio, 28);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsOdontologica(), this.rowAgendaServicio, 29);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTratamiento(), this.rowAgendaServicio, 30);
                this.modeloServicio.setValueAt(listadoList.get(i).getCama(), this.rowAgendaServicio, 31);
                this.modeloServicio.setValueAt(listadoList.get(i).getEnfermedadActual(), this.rowAgendaServicio, 32);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsPeriodico(), this.rowAgendaServicio, 33);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControlHistoria(), this.rowAgendaServicio, 34);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), this.rowAgendaServicio, 35);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoAtencion(), this.rowAgendaServicio, 36);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoAtencion(), this.rowAgendaServicio, 37);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailUsuario(), this.rowAgendaServicio, 38);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailsupervisor(), this.rowAgendaServicio, 39);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoEmpresa(), this.rowAgendaServicio, 40);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdParentesco(), this.rowAgendaServicio, 41);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoCita(), this.rowAgendaServicio, 42);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoGuardado(), this.rowAgendaServicio, 43);
                this.modeloServicio.setValueAt(listadoList.get(i).getFecha_HoraAtencion(), this.rowAgendaServicio, 44);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioPrograma(), this.rowAgendaServicio, 45);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdOrden(), this.rowAgendaServicio, 46);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdProcedimiento(), this.rowAgendaServicio, 47);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdServicio(), this.rowAgendaServicio, 48);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdManPower(), this.rowAgendaServicio, 49);
                this.modeloServicio.setValueAt(listadoList.get(i).getFiltradoAgenda(), this.rowAgendaServicio, 50);
                this.modeloServicio.setValueAt(listadoList.get(i).getExpandirHistoria(), this.rowAgendaServicio, 51);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoTratamiento(), this.rowAgendaServicio, 52);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsTriage(), this.rowAgendaServicio, 53);
                this.modeloServicio.setValueAt(listadoList.get(i).getFormaHistoria(), this.rowAgendaServicio, 54);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoUsuarioUrgencias(), this.rowAgendaServicio, 55);
                this.modeloServicio.setValueAt(listadoList.get(i).getEspecialidadInterconsulta(), this.rowAgendaServicio, 56);
                this.modeloServicio.setValueAt(listadoList.get(i).getHora(), this.rowAgendaServicio, 58);
                this.modeloServicio.setValueAt(listadoList.get(i).getProfesionalAsignado(), this.rowAgendaServicio, 59);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdModalidad(), this.rowAgendaServicio, 61);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdEntornoAtencion(), this.rowAgendaServicio, 62);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoDiscapacidad(), this.rowAgendaServicio, 63);
                if (isNumber(listadoList.get(i).getFase()) && listadoList.get(i).getIdTipoAtencion().intValue() > 1) {
                    int fase = Integer.parseInt(listadoList.get(i).getFase());
                    double valor = Math.floor(fase / 30) + 1.0d;
                    if (listadoList.get(i).getIdTipoAtencion().intValue() != 4) {
                        this.modeloServicio.setValueAt(fase + " días", this.rowAgendaServicio, 57);
                    } else if (valor > 6.0d) {
                        this.modeloServicio.setValueAt("Ha superado la fase 6  " + fase + " días", this.rowAgendaServicio, 57);
                    } else {
                        this.modeloServicio.setValueAt("fase " + valor + " -  " + fase + " días", this.rowAgendaServicio, 57);
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRenderAgendaServicios());
                numero++;
                this.rowAgendaServicio++;
            }
            this.modeloServicio.setRowCount(listadoList.size());
            this.modeloServicio.fireTableDataChanged();
            System.out.println("combo " + this.idServicio[this.JCB_Servicio.getSelectedIndex()]);
            if (this.idServicio[this.JCB_Servicio.getSelectedIndex()].equals("4")) {
            }
        }
        System.out.println("Coloca tabla");
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.repaint();
        System.out.println("Entra this.JTB_AgendaServicios.getRowCount()-->" + this.JTB_AgendaServicios.getRowCount());
        this.JLB_NumeroRegistro.setText("" + numero);
    }

    public boolean isNumber(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_AgendaHistoriaServiciosDTO$MiRenderAgendaServicios.class */
    public class MiRenderAgendaServicios extends DefaultTableCellRenderer {
        public MiRenderAgendaServicios() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 55) != null) {
                int valorCelda = Integer.parseInt(table.getValueAt(row, 55).toString());
                switch (valorCelda) {
                    case 0:
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 1:
                        cell.setBackground(new Color(133, 218, 160));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(Color.ORANGE);
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_AgendaHistoriaServiciosDTO$MyTreeCellRenderer.class */
    public static class MyTreeCellRenderer extends DefaultTreeCellRenderer {
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            tree.setRowHeight(26);
            DefaultMutableTreeNode v = (DefaultMutableTreeNode) value;
            setOpaque(true);
            setForeground(Color.black);
            if (selected) {
                setForeground(Color.red);
            }
            if (tree.getModel().getRoot().equals((DefaultMutableTreeNode) value)) {
                setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/CarpetaAtencion1.png"))));
            } else if (v.isLeaf()) {
                setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/hojaAtencion.png"))));
            } else {
                setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/padreHojas.png"))));
            }
            return this;
        }
    }

    private void LlenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        this.listaTipoServicio = new ArrayList();
        this.listaTipoServicio = this.atencionService.listaTipoServicio();
        this.listaTipoServicio.forEach(e -> {
            this.JCB_Servicio.addItem(e.getNombre());
        });
        this.JCB_Servicio.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreServicio());
        this.esLlenoCombo = true;
    }
}
