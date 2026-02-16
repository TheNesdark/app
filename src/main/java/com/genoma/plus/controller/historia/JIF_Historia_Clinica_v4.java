package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Laboratorio.Render;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDSalidaAdministrativa;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.dto.historia.AgendaHCDTO;
import com.genoma.plus.dto.historia.AgendaOrdenesGenericoDTO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import com.genoma.plus.jpa.entities.GenericoValorDoubleDTO;
import com.genoma.plus.jpa.service.AgendaHCService;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.IHAtencionService;
import com.genoma.plus.jpa.service.UsuarioPorProgramaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4.class */
public final class JIF_Historia_Clinica_v4 extends JInternalFrame {
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
    private ButtonGroup JBG_Filtrado;
    private ButtonGroup JBG_FiltroEstado;
    private ButtonGroup JBG_FiltroEstadoAtencion;
    private ButtonGroup JBG_FiltroServicio;
    private ButtonGroup JBG_FiltroSexo;
    private static JButton JBT_AtencionesPendientes;
    private static JButton JBT_SalidasAdminsitrativas;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_Clasificado;
    private JCheckBox JCH_ImagenesDx;
    private JCheckBox JCH_Interconsulta;
    private JCheckBox JCH_Observacion;
    public JCheckBox JCH_PorClasificar;
    public JDateChooser JDCFechaAgenda;
    public JDateChooser JDCFechaAgenda1;
    private JLabel JLAlergia;
    private JLabel JLBNPRegistro;
    private JLabel JLBNRegistro;
    private JLabel JLB_NumeroRegistro;
    private JPanel JPIEstado;
    private JPanel JPIFiltro;
    private JPanel JPI_Agenda;
    private JPanel JPI_AgendaDetalle;
    private JPanel JPI_Filtro;
    private JPanel JPI_FiltroServicio;
    private JPanel JPI_Historia;
    public JPanel JPI_PanelPrincipal;
    private JPanel JPI_Servicios;
    private JSplitPane JPS_PanelHistoria;
    private JPanel JP_FiltroSexo;
    private JRadioButton JRBAtendidas;
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_U;
    private JRadioButton JRBFemenino;
    private JRadioButton JRBMasculino;
    private JRadioButton JRBPorAtender;
    private JRadioButton JRBSinFact;
    private JRadioButton JRBTodas;
    private JRadioButton JRB_AmbosSexo;
    private JRadioButton JRB_FSSeleccion;
    private JRadioButton JRB_FSTodos;
    private JSpinner JSDias;
    private JSplitPane JSP_Agenda;
    private JScrollPane JSP_AgendaNoProgramada;
    private JScrollPane JSP_AgendaProgramada;
    private JScrollPane JSP_AgendaServicios;
    private JScrollPane JSP_Datos1;
    private JScrollPane JSP_Datos2;
    private JTable JTB_AgendaNoProgramada;
    private JTable JTB_AgendaProgramada;
    private JTable JTB_AgendaServicios;
    private JTextField JTFBuscar;
    private JTabbedPane JTP_Informacion;
    private JTree JTree_Atencion;
    private JPanel jPanel1;
    private JPanel jPanel2;
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
    private List<String> sexo = new ArrayList();
    private Integer estadoEgreso = 0;
    private final UsuarioPorProgramaService xUsuarioPorProgramaService = (UsuarioPorProgramaService) Principal.contexto.getBean(UsuarioPorProgramaService.class);
    private final EstadoAtencionService estadoAtencionService = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    private final IHAtencionService atencionService = (IHAtencionService) Principal.contexto.getBean(IHAtencionService.class);
    private boolean numeroDias = false;
    private final AgendaHCService AgendaService = (AgendaHCService) Principal.contexto.getBean(AgendaHCService.class);
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);

    public JIF_Historia_Clinica_v4() {
        initComponents();
        springStart();
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JRBMasculino.setVisible(false);
            this.JRBFemenino.setVisible(false);
            this.JP_FiltroSexo.setVisible(false);
            this.JRB_AmbosSexo.setVisible(false);
        }
        inicioInformacionHistoria();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        if (Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Consulta Externa")) {
            this.JTP_Informacion.remove(1);
        } else if (Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Servicios")) {
            this.JTP_Informacion.remove(0);
        }
        nuevo();
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
            this.JSDias.setValue(30);
        } else {
            this.JSDias.setValue(2);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579") || Principal.informacionIps.getIdentificacion().equals("812003851")) {
            JBT_SalidasAdminsitrativas.setEnabled(false);
            if (Principal.informacionIps.getIdentificacion().equals("900520293")) {
                this.JCH_Clasificado.setSelected(true);
            }
        } else {
            JBT_SalidasAdminsitrativas.setEnabled(true);
            this.JCH_Interconsulta.setSelected(true);
        }
        mEjecutaTarea();
    }

    private void mEjecutaTarea() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_Historia_Clinica_v4.this.estadoAgenda.get()) {
                    JIF_Historia_Clinica_v4.this.cargarDatos();
                } else {
                    timer.cancel();
                }
                System.out.println(" tarea ejecutando time");
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r3v207, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JBG_FiltroEstadoAtencion = new ButtonGroup();
        this.JBG_FiltroSexo = new ButtonGroup();
        this.JBG_FiltroServicio = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JLAlergia = new JLabel();
        this.JTP_Informacion = new JTabbedPane();
        this.JPI_Agenda = new JPanel();
        this.JPI_AgendaDetalle = new JPanel();
        this.JSP_Agenda = new JSplitPane();
        this.JSP_AgendaProgramada = new JScrollPane();
        this.JTB_AgendaProgramada = new JTable();
        this.JSP_AgendaNoProgramada = new JScrollPane();
        this.JTB_AgendaNoProgramada = new JTable();
        this.JDCFechaAgenda = new JDateChooser();
        this.JPIFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBSinFact = new JRadioButton();
        this.JRBPorAtender = new JRadioButton();
        this.JRBAtendidas = new JRadioButton();
        this.JLBNRegistro = new JLabel();
        this.JLBNPRegistro = new JLabel();
        JBT_AtencionesPendientes = new JButton();
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
        this.JDCFechaAgenda1 = new JDateChooser();
        this.JSDias = new JSpinner();
        this.JCH_ImagenesDx = new JCheckBox();
        this.JPI_FiltroServicio = new JPanel();
        this.JRB_FSTodos = new JRadioButton();
        this.JRB_FSSeleccion = new JRadioButton();
        this.JSP_AgendaServicios = new JScrollPane();
        this.JTB_AgendaServicios = new JTable();
        JBT_SalidasAdminsitrativas = new JButton();
        this.JPI_Historia = new JPanel();
        this.JPS_PanelHistoria = new JSplitPane();
        this.JSP_Datos1 = new JScrollPane();
        this.JTree_Atencion = new JTree();
        this.JSP_Datos2 = new JScrollPane();
        this.JPI_PanelPrincipal = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORIA CLINICA V4.0");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_historiaclinicav4");
        addContainerListener(new ContainerAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.2
            public void componentRemoved(ContainerEvent evt) {
                JIF_Historia_Clinica_v4.this.formComponentRemoved(evt);
            }
        });
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.3
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_Historia_Clinica_v4.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.4
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_Historia_Clinica_v4.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_Historia_Clinica_v4.this.formInternalFrameClosing(evt);
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
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLAlergia, -1, -1, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLAlergia, -2, 29, -2).addContainerGap(17, 32767)));
        this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO:", 0, 0, new Font("Arial", 1, 20), Color.red));
        this.JTP_Informacion.setForeground(new Color(0, 103, 0));
        this.JTP_Informacion.setFont(new Font("Arial", 1, 14));
        this.JTP_Informacion.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.5
            public void stateChanged(ChangeEvent evt) {
                JIF_Historia_Clinica_v4.this.JTP_InformacionStateChanged(evt);
            }
        });
        this.JSP_Agenda.setDividerSize(15);
        this.JSP_Agenda.setOrientation(0);
        this.JSP_Agenda.setResizeWeight(0.6d);
        this.JSP_Agenda.setToolTipText("");
        this.JSP_Agenda.setAutoscrolls(true);
        this.JSP_Agenda.setFont(new Font("Arial", 1, 14));
        this.JSP_Agenda.setOneTouchExpandable(true);
        this.JSP_AgendaProgramada.setBorder(BorderFactory.createTitledBorder((Border) null, "PROGRAMADA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_AgendaProgramada.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaProgramada.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaProgramada.setRowHeight(30);
        this.JTB_AgendaProgramada.setSelectionMode(0);
        this.JTB_AgendaProgramada.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.6
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaProgramadaMouseClicked(evt);
            }
        });
        this.JSP_AgendaProgramada.setViewportView(this.JTB_AgendaProgramada);
        this.JSP_Agenda.setTopComponent(this.JSP_AgendaProgramada);
        this.JSP_AgendaNoProgramada.setBorder(BorderFactory.createTitledBorder((Border) null, "NO PROGRAMADA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSP_AgendaNoProgramada.setFont(new Font("Arial", 1, 14));
        this.JTB_AgendaNoProgramada.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaNoProgramada.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaNoProgramada.setRowHeight(25);
        this.JTB_AgendaNoProgramada.setSelectionMode(0);
        this.JTB_AgendaNoProgramada.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.7
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaNoProgramadaMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaNoProgramadaMouseEntered(evt);
            }
        });
        this.JSP_AgendaNoProgramada.setViewportView(this.JTB_AgendaNoProgramada);
        this.JSP_Agenda.setRightComponent(this.JSP_AgendaNoProgramada);
        this.JDCFechaAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Historia_Clinica_v4.this.JDCFechaAgendaPropertyChange(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR : ", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBG_Filtrado.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(new Color(0, 0, 255));
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBG_Filtrado.add(this.JRBSinFact);
        this.JRBSinFact.setFont(new Font("Arial", 1, 12));
        this.JRBSinFact.setForeground(new Color(0, 0, 255));
        this.JRBSinFact.setText("Sin Facturar");
        this.JRBSinFact.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBSinFactActionPerformed(evt);
            }
        });
        this.JBG_Filtrado.add(this.JRBPorAtender);
        this.JRBPorAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtender.setForeground(new Color(0, 0, 255));
        this.JRBPorAtender.setSelected(true);
        this.JRBPorAtender.setText("Por Atender");
        this.JRBPorAtender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.11
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBPorAtenderActionPerformed(evt);
            }
        });
        this.JBG_Filtrado.add(this.JRBAtendidas);
        this.JRBAtendidas.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidas.setForeground(new Color(0, 0, 255));
        this.JRBAtendidas.setText("Atendidas");
        this.JRBAtendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.12
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSinFact).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAtendidas).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBSinFact).addComponent(this.JRBPorAtender).addComponent(this.JRBAtendidas)).addContainerGap(-1, 32767)));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro Programado", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBNPRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNPRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNPRegistro.setHorizontalAlignment(0);
        this.JLBNPRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro No Programado", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        JBT_AtencionesPendientes.setFont(new Font("Tahoma", 1, 12));
        JBT_AtencionesPendientes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.13
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JBT_AtencionesPendientesActionPerformed(evt);
            }
        });
        GroupLayout JPI_AgendaDetalleLayout = new GroupLayout(this.JPI_AgendaDetalle);
        this.JPI_AgendaDetalle.setLayout(JPI_AgendaDetalleLayout);
        JPI_AgendaDetalleLayout.setHorizontalGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_AgendaDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_Agenda).addGroup(JPI_AgendaDetalleLayout.createSequentialGroup().addComponent(this.JDCFechaAgenda, -1, 218, 32767).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNRegistro, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNPRegistro, -2, 183, -2).addGap(18, 18, 18).addComponent(JBT_AtencionesPendientes, -2, 331, -2))).addContainerGap()));
        JPI_AgendaDetalleLayout.setVerticalGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_AgendaDetalleLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaAgenda, GroupLayout.Alignment.LEADING, -2, 54, -2)).addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNPRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBNRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(JBT_AtencionesPendientes, -2, 56, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Agenda, -1, 633, 32767).addContainerGap()));
        GroupLayout JPI_AgendaLayout = new GroupLayout(this.JPI_Agenda);
        this.JPI_Agenda.setLayout(JPI_AgendaLayout);
        JPI_AgendaLayout.setHorizontalGroup(JPI_AgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_AgendaDetalle, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPI_AgendaLayout.setVerticalGroup(JPI_AgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AgendaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_AgendaDetalle, -1, -1, 32767).addContainerGap()));
        this.JTP_Informacion.addTab("CONSULTA EXTERNA", this.JPI_Agenda);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setToolTipText("");
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.14
            public void itemStateChanged(ItemEvent evt) {
                JIF_Historia_Clinica_v4.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_PorClasificar.setBackground(Color.cyan);
        this.JBG_FiltroEstado.add(this.JCH_PorClasificar);
        this.JCH_PorClasificar.setFont(new Font("Arial", 1, 12));
        this.JCH_PorClasificar.setSelected(true);
        this.JCH_PorClasificar.setText("Por Clasificar");
        this.JCH_PorClasificar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.15
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JCH_PorClasificarActionPerformed(evt);
            }
        });
        this.JCH_Clasificado.setBackground(new Color(133, 218, 160));
        this.JBG_FiltroEstado.add(this.JCH_Clasificado);
        this.JCH_Clasificado.setFont(new Font("Arial", 1, 12));
        this.JCH_Clasificado.setText("Clasificado");
        this.JCH_Clasificado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.16
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JCH_ClasificadoActionPerformed(evt);
            }
        });
        this.JCH_Observacion.setBackground(Color.orange);
        this.JBG_FiltroEstado.add(this.JCH_Observacion);
        this.JCH_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Observacion.setText("Observación");
        this.JCH_Observacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.17
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JCH_ObservacionActionPerformed(evt);
            }
        });
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JBG_FiltroEstado.add(this.JCH_Interconsulta);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Interconsulta");
        this.JCH_Interconsulta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.18
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JCH_InterconsultaActionPerformed(evt);
            }
        });
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroEstadoAtencion.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JRBEnAtencion_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.19
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBEnAtencion_UActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstadoAtencion.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        this.JRBDeAlta_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.20
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBDeAlta_UActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(23, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.21
            public void keyPressed(KeyEvent evt) {
                JIF_Historia_Clinica_v4.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.JLB_NumeroRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NumeroRegistro.setFont(new Font("Arial", 1, 18));
        this.JLB_NumeroRegistro.setForeground(Color.red);
        this.JLB_NumeroRegistro.setHorizontalAlignment(0);
        this.JLB_NumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JP_FiltroSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por sexo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroSexo.add(this.JRBFemenino);
        this.JRBFemenino.setFont(new Font("Arial", 1, 12));
        this.JRBFemenino.setText("F");
        this.JRBFemenino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.22
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBFemeninoActionPerformed(evt);
            }
        });
        this.JBG_FiltroSexo.add(this.JRBMasculino);
        this.JRBMasculino.setFont(new Font("Arial", 1, 12));
        this.JRBMasculino.setText("M");
        this.JRBMasculino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.23
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRBMasculinoActionPerformed(evt);
            }
        });
        this.JBG_FiltroSexo.add(this.JRB_AmbosSexo);
        this.JRB_AmbosSexo.setFont(new Font("Arial", 1, 12));
        this.JRB_AmbosSexo.setSelected(true);
        this.JRB_AmbosSexo.setText("Ambos");
        this.JRB_AmbosSexo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.24
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRB_AmbosSexoActionPerformed(evt);
            }
        });
        GroupLayout JP_FiltroSexoLayout = new GroupLayout(this.JP_FiltroSexo);
        this.JP_FiltroSexo.setLayout(JP_FiltroSexoLayout);
        JP_FiltroSexoLayout.setHorizontalGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroSexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFemenino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMasculino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_AmbosSexo).addContainerGap(13, 32767)));
        JP_FiltroSexoLayout.setVerticalGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroSexoLayout.createSequentialGroup().addGroup(JP_FiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFemenino).addComponent(this.JRBMasculino).addComponent(this.JRB_AmbosSexo)).addGap(0, 1, 32767)));
        this.jSpinner1.setFont(new Font("Arial", 1, 12));
        this.jSpinner1.setModel(new SpinnerNumberModel(3, 1, 5, 1));
        this.jSpinner1.setToolTipText("Clasificación Triage");
        this.jSpinner1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda1.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda1.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.25
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Historia_Clinica_v4.this.JDCFechaAgenda1PropertyChange(evt);
            }
        });
        this.JSDias.setFont(new Font("Arial", 1, 12));
        this.JSDias.setModel(new SpinnerNumberModel(2, (Comparable) null, (Comparable) null, 1));
        this.JSDias.setToolTipText("Intervalo de dias hacia atras a visualizar");
        this.JSDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSDias.setRequestFocusEnabled(false);
        this.JSDias.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.26
            public void mouseEntered(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JSDiasMouseEntered(evt);
            }
        });
        this.JCH_ImagenesDx.setBackground(new Color(51, 153, 255));
        this.JBG_FiltroEstado.add(this.JCH_ImagenesDx);
        this.JCH_ImagenesDx.setFont(new Font("Arial", 1, 12));
        this.JCH_ImagenesDx.setText("Imagenes Diagnósticas");
        this.JCH_ImagenesDx.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.27
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JCH_ImagenesDxActionPerformed(evt);
            }
        });
        this.JPI_FiltroServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Servicio", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroServicio.add(this.JRB_FSTodos);
        this.JRB_FSTodos.setFont(new Font("Arial", 1, 12));
        this.JRB_FSTodos.setForeground(Color.blue);
        this.JRB_FSTodos.setText("Todos");
        this.JRB_FSTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.28
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRB_FSTodosActionPerformed(evt);
            }
        });
        this.JBG_FiltroServicio.add(this.JRB_FSSeleccion);
        this.JRB_FSSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRB_FSSeleccion.setForeground(Color.blue);
        this.JRB_FSSeleccion.setSelected(true);
        this.JRB_FSSeleccion.setText("Selección");
        this.JRB_FSSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.29
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JRB_FSSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroServicioLayout = new GroupLayout(this.JPI_FiltroServicio);
        this.JPI_FiltroServicio.setLayout(JPI_FiltroServicioLayout);
        JPI_FiltroServicioLayout.setHorizontalGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroServicioLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FSTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FSSeleccion).addContainerGap(-1, 32767)));
        JPI_FiltroServicioLayout.setVerticalGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroServicioLayout.createSequentialGroup().addGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FSTodos).addComponent(this.JRB_FSSeleccion)).addContainerGap(-1, 32767)));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JPI_FiltroServicio, -2, -1, -2).addGap(28, 28, 28).addComponent(this.JDCFechaAgenda1, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDias, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSpinner1, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_PorClasificar).addComponent(this.JCH_Clasificado, -2, 104, -2)).addGap(27, 27, 27).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Observacion).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCH_Interconsulta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_ImagenesDx)))).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCB_Servicio, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JTFBuscar, -2, 681, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JP_FiltroSexo, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NumeroRegistro, -2, 108, -2).addGap(28, 28, 28)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(21, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDias, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jSpinner1, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JPIEstado, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_FiltroServicio, -2, -1, -2).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_PorClasificar).addComponent(this.JCH_Observacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Clasificado).addComponent(this.JCH_Interconsulta).addComponent(this.JCH_ImagenesDx))).addComponent(this.JDCFechaAgenda1, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Servicio, -1, 44, 32767)).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFBuscar, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addComponent(this.JLB_NumeroRegistro, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JP_FiltroSexo, -2, -1, -2).addGap(1, 1, 1)));
        this.JSP_AgendaServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSP_AgendaServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.30
            public void mousePressed(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JSP_AgendaServiciosMousePressed(evt);
            }
        });
        this.JTB_AgendaServicios.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaServicios.setAutoResizeMode(0);
        this.JTB_AgendaServicios.setRowHeight(30);
        this.JTB_AgendaServicios.setSelectionMode(0);
        this.JTB_AgendaServicios.addMouseMotionListener(new MouseMotionAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.31
            public void mouseMoved(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaServiciosMouseMoved(evt);
            }
        });
        this.JTB_AgendaServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.32
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaServiciosMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaServiciosMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaServiciosMouseExited(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTB_AgendaServiciosMousePressed(evt);
            }
        });
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        JBT_SalidasAdminsitrativas.setFont(new Font("Tahoma", 1, 12));
        JBT_SalidasAdminsitrativas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        JBT_SalidasAdminsitrativas.setText("Salida Administrativa");
        JBT_SalidasAdminsitrativas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.33
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v4.this.JBT_SalidasAdminsitrativasActionPerformed(evt);
            }
        });
        GroupLayout JPI_ServiciosLayout = new GroupLayout(this.JPI_Servicios);
        this.JPI_Servicios.setLayout(JPI_ServiciosLayout);
        JPI_ServiciosLayout.setHorizontalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -2, 1341, 32767).addComponent(this.JSP_AgendaServicios).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(JBT_SalidasAdminsitrativas, -2, 331, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_ServiciosLayout.setVerticalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_AgendaServicios, -2, 499, -2).addGap(18, 18, 18).addComponent(JBT_SalidasAdminsitrativas, -2, 56, -2).addGap(0, 0, 32767)));
        this.JTP_Informacion.addTab("SERVICIOS", this.JPI_Servicios);
        this.JPS_PanelHistoria.setDividerSize(15);
        this.JPS_PanelHistoria.setResizeWeight(0.1d);
        this.JPS_PanelHistoria.setOneTouchExpandable(true);
        this.JSP_Datos1.setMinimumSize(new Dimension(80, 80));
        this.JSP_Datos1.setPreferredSize(new Dimension(200, 200));
        this.JTree_Atencion.setFont(new Font("Arial", 1, 12));
        this.JTree_Atencion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.34
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v4.this.JTree_AtencionMouseClicked(evt);
            }
        });
        this.JTree_Atencion.addTreeSelectionListener(new TreeSelectionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.35
            public void valueChanged(TreeSelectionEvent evt) {
                JIF_Historia_Clinica_v4.this.JTree_AtencionValueChanged(evt);
            }
        });
        this.JSP_Datos1.setViewportView(this.JTree_Atencion);
        this.JPS_PanelHistoria.setLeftComponent(this.JSP_Datos1);
        this.JSP_Datos2.setHorizontalScrollBarPolicy(31);
        this.JSP_Datos2.setPreferredSize(new Dimension(804, 504));
        this.JPI_PanelPrincipal.setPreferredSize(new Dimension(800, 500));
        GroupLayout JPI_PanelPrincipalLayout = new GroupLayout(this.JPI_PanelPrincipal);
        this.JPI_PanelPrincipal.setLayout(JPI_PanelPrincipalLayout);
        JPI_PanelPrincipalLayout.setHorizontalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1078, 32767));
        JPI_PanelPrincipalLayout.setVerticalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 713, 32767));
        this.JSP_Datos2.setViewportView(this.JPI_PanelPrincipal);
        this.JPS_PanelHistoria.setRightComponent(this.JSP_Datos2);
        GroupLayout JPI_HistoriaLayout = new GroupLayout(this.JPI_Historia);
        this.JPI_Historia.setLayout(JPI_HistoriaLayout);
        JPI_HistoriaLayout.setHorizontalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPS_PanelHistoria, -1, 1328, 32767).addContainerGap()));
        JPI_HistoriaLayout.setVerticalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPS_PanelHistoria, -1, 718, 32767).addContainerGap()));
        this.JTP_Informacion.addTab("HISTORIA CLINICA", this.JPI_Historia);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Informacion).addContainerGap()).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap())));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.JTP_Informacion, -2, -1, -2).addContainerGap(37, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 835, 32767))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
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
    public void JDCFechaAgendaPropertyChange(PropertyChangeEvent evt) {
        if (this.esLlenoCombo.booleanValue()) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.filtroEstado = "0,1,2,3";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinFactActionPerformed(ActionEvent evt) {
        this.filtroEstado = "0";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderActionPerformed(ActionEvent evt) {
        this.filtroEstado = "1";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasActionPerformed(ActionEvent evt) {
        this.filtroEstado = "3";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AtencionesPendientesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaProgramadaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTB_AgendaProgramada.getSelectedRow() != -1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
            this.JPI_PanelPrincipal.removeAll();
            if (this.JTB_AgendaProgramada.getSelectedColumn() == 51) {
                if (!this.JTB_AgendaProgramada.getValueAt(this.JTB_AgendaProgramada.getSelectedRow(), 51).toString().isEmpty()) {
                    this.metodos.abrirEnlaceWeb(this.JTB_AgendaProgramada.getValueAt(this.JTB_AgendaProgramada.getSelectedRow(), 51).toString());
                    return;
                }
                return;
            }
            if (Long.valueOf(this.JTB_AgendaProgramada.getValueAt(this.JTB_AgendaProgramada.getSelectedRow(), 14).toString()).longValue() != 0) {
                if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                    new GenericoValorDoubleDTO();
                    GenericoValorDoubleDTO genericoUnValor = this.estadoAtencionService.devuelveValorPorPagarPorIngreso(Long.valueOf(this.JTB_AgendaProgramada.getValueAt(this.JTB_AgendaProgramada.getSelectedRow(), 14).toString()));
                    System.out.println("Valor" + genericoUnValor);
                    if (genericoUnValor == null) {
                        inicializarDatosClaseInformacionAgendaProgramada(this.JTB_AgendaProgramada, this.JTB_AgendaProgramada.getSelectedRow());
                        return;
                    } else if (genericoUnValor.getValor().doubleValue() > 0.0d) {
                        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El usuario tiene pendiente por cancelar copago/cuota moderadora", "VERIFICAR ESTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    } else {
                        inicializarDatosClaseInformacionAgendaProgramada(this.JTB_AgendaProgramada, this.JTB_AgendaProgramada.getSelectedRow());
                        return;
                    }
                }
                if (Principal.sedeUsuarioSeleccionadaDTO.getMinutos().intValue() == 0) {
                    inicializarDatosClaseInformacionAgendaProgramada(this.JTB_AgendaProgramada, this.JTB_AgendaProgramada.getSelectedRow());
                    return;
                }
                Integer minuto = this.estadoAtencionService.validarHoraAtencion(this.metodos.formatoAMD.format(this.JDCFechaAgenda.getDate()) + " " + this.JTB_AgendaProgramada.getValueAt(this.JTB_AgendaProgramada.getSelectedRow(), 5).toString());
                if (minuto.intValue() <= Principal.sedeUsuarioSeleccionadaDTO.getMinutos().intValue()) {
                    inicializarDatosClaseInformacionAgendaProgramada(this.JTB_AgendaProgramada, this.JTB_AgendaProgramada.getSelectedRow());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "El usuario no esta dentro del horario de atencion", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Usuario sin facturar ", "VERIFICAR ESTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_InformacionStateChanged(ChangeEvent evt) {
        Color color;
        if (consultarEstadoItems()) {
            color = new Color(238, 238, 238);
            switch (Principal.clasehistoriace.getNombreAgenda()) {
                case "Agenda de Consulta Externa":
                    if (this.JTP_Informacion.getSelectedIndex() == 0) {
                        configuracionPanel();
                        this.modelo = null;
                        this.JTree_Atencion.setModel(this.modelo);
                        this.listadoItemsCargados = new Vector<>();
                        if (!this.estadoAgenda.get()) {
                            this.estadoAgenda.set(true);
                            mEjecutaTarea();
                        }
                    } else {
                        this.estadoAgenda.set(false);
                    }
                    this.JPI_Historia.setBackground(color);
                    this.jPanel2.setBackground(color);
                    this.jPanel1.setBackground(color);
                    this.JLAlergia.setVisible(false);
                    break;
                case "Agenda de Servicios":
                    if (this.JTP_Informacion.getSelectedIndex() == 0) {
                        configuracionPanel();
                        this.modelo = null;
                        this.JTree_Atencion.setModel(this.modelo);
                        this.listadoItemsCargados = new Vector<>();
                        this.JPI_PanelPrincipal.removeAll();
                        if (!this.estadoAgenda.get()) {
                            this.estadoAgenda.set(true);
                            mEjecutaTarea();
                        }
                    } else {
                        this.estadoAgenda.set(false);
                    }
                    this.JPI_Historia.setBackground(color);
                    this.jPanel2.setBackground(color);
                    this.jPanel1.setBackground(color);
                    this.JLAlergia.setVisible(false);
                    break;
                default:
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
                    break;
            }
        }
        if (this.JTP_Informacion.getSelectedIndex() != this.JTP_Informacion.getTabCount() - 1) {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se encontraron Items Obligatorios sin diligenciar<br>Por favor revisar!!!</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Informacion.setSelectedIndex(this.JTP_Informacion.getTabCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaNoProgramadaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTB_AgendaNoProgramada.getSelectedRow() != -1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
            this.JPI_PanelPrincipal.removeAll();
            if (this.JTB_AgendaNoProgramada.getSelectedColumn() == 51) {
                if (!this.JTB_AgendaNoProgramada.getValueAt(this.JTB_AgendaNoProgramada.getSelectedRow(), 51).toString().isEmpty()) {
                    this.metodos.abrirEnlaceWeb(this.JTB_AgendaNoProgramada.getValueAt(this.JTB_AgendaNoProgramada.getSelectedRow(), 51).toString());
                }
            } else if (Long.parseLong(this.JTB_AgendaNoProgramada.getValueAt(this.JTB_AgendaNoProgramada.getSelectedRow(), 14).toString()) != 0) {
                inicializarDatosClaseInformacionAgendaProgramada(this.JTB_AgendaNoProgramada, this.JTB_AgendaNoProgramada.getSelectedRow());
                this.variableTabLlamador = 0;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Usuario sin facturar ", "VERIFICAR ESTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTB_AgendaServicios.getSelectedRow() != -1) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") && this.filtroAtencion.equals("0")) {
                JDTriageInicial triageInicial = new JDTriageInicial(null, this.JPI_PanelPrincipal);
                triageInicial.setLocationRelativeTo(this);
                triageInicial.setVisible(true);
                System.out.println("filtro triage -> " + triageInicial.triageLleno);
                if (triageInicial.triageLleno) {
                    clasesHistoriaCE.informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
                    this.JPI_PanelPrincipal.removeAll();
                    inicializarDatosClaseInformacionAgendaServicios(this.JTB_AgendaServicios, this.JTB_AgendaServicios.getSelectedRow());
                    inicioInformacionHistoria();
                    if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva")) {
                        this.JTP_Informacion.setSelectedIndex(2);
                        mConsultarALerta();
                    } else {
                        this.JTP_Informacion.setSelectedIndex(1);
                        mConsultarALerta();
                    }
                    configuracionPanel();
                    this.variableTabLlamador = 1;
                    return;
                }
                return;
            }
            clasesHistoriaCE.informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
            this.JPI_PanelPrincipal.removeAll();
            inicializarDatosClaseInformacionAgendaServicios(this.JTB_AgendaServicios, this.JTB_AgendaServicios.getSelectedRow());
            inicioInformacionHistoria();
            if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva")) {
                this.JTP_Informacion.setSelectedIndex(2);
                mConsultarALerta();
            } else {
                this.JTP_Informacion.setSelectedIndex(1);
                mConsultarALerta();
            }
            configuracionPanel();
            this.variableTabLlamador = 1;
            return;
        }
        if (evt.getClickCount() == 1 && this.JTB_AgendaServicios.getSelectedRow() != -1) {
            inicializarDatosClaseInformacionAgendaServicios(this.JTB_AgendaServicios, this.JTB_AgendaServicios.getSelectedRow());
            this.variableTabLlamador = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ClasificadoActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "1";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion_UActionPerformed(ActionEvent evt) {
        crearTablaAgendaServicio();
        this.estadoAtencion = 0;
        this.estadoEgreso = 0;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 1;
        crearTablaAgendaServicio();
        this.estadoEgreso = 1;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PorClasificarActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "0";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ObservacionActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "2";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_InterconsultaActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "3";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFBuscar.getText().isEmpty()) {
            crearTablaAgendaServicio();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_AgendaServiciosMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFemeninoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.sexo.clear();
            this.sexo.add(this.JRBFemenino.getText());
            crearTablaAgendaServicio();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMasculinoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.sexo.clear();
            this.sexo.add(this.JRBMasculino.getText());
            crearTablaAgendaServicio();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AmbosSexoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.sexo.clear();
            this.sexo.add(this.JRBFemenino.getText());
            this.sexo.add(this.JRBMasculino.getText());
            crearTablaAgendaServicio();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaNoProgramadaMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        System.err.println("ENTRO A formAncestorRemoved");
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgenda1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalidasAdminsitrativasActionPerformed(ActionEvent evt) {
        if (this.JCH_PorClasificar.isSelected() || this.JCH_Clasificado.isSelected()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseExited(MouseEvent evt) {
        this.estadoAgenda.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseMoved(MouseEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        System.err.println("ENTRO A formInternalFrameClosing1");
        setDefaultCloseOperation(0);
        if (consultarEstadoItems()) {
            System.err.println("PASO VALIDACION formInternalFrameClosing");
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se encontraron Items Obligatorios sin diligenciar<br>Por favor revisar!!!</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formComponentRemoved(ContainerEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSDiasMouseEntered(MouseEvent evt) {
        this.numeroDias = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ImagenesDxActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "3";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FSTodosActionPerformed(ActionEvent evt) {
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FSSeleccionActionPerformed(ActionEvent evt) {
        crearTablaAgendaServicio();
        cargarDatos();
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
                } else if (forma == 1 && this.JPI_PanelPrincipal.getComponent(0).getName() != null && this.JPI_PanelPrincipal.getComponent(0).getName().equals(elementAt.getNombreFormulario())) {
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
        Enumeration<?> e = raiz.children();
        while (e.hasMoreElements()) {
            for (int i = 0; i < raiz.getChildCount(); i++) {
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

    private void inicializarDatosClaseInformacionAgendaProgramada(JTable jTable, int filaSeleccionada) {
        this.listadoItemsCargados = new Vector<>();
        jTable.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(jTable.getValueAt(filaSeleccionada, 0).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(jTable.getValueAt(filaSeleccionada, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(jTable.getValueAt(filaSeleccionada, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(jTable.getValueAt(filaSeleccionada, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(jTable.getValueAt(filaSeleccionada, 4).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraIncial(jTable.getValueAt(filaSeleccionada, 5).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEstadoTextoAtencion(jTable.getValueAt(filaSeleccionada, 6).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(jTable.getValueAt(filaSeleccionada, 7).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 9).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(jTable.getValueAt(filaSeleccionada, 10).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(jTable.getValueAt(filaSeleccionada, 11).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraFinal(jTable.getValueAt(filaSeleccionada, 12).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(jTable.getValueAt(filaSeleccionada, 13).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(jTable.getValueAt(filaSeleccionada, 14).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 15).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 16).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setAsistida(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 17).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(jTable.getValueAt(filaSeleccionada, 18).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(jTable.getValueAt(filaSeleccionada, 19).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(jTable.getValueAt(filaSeleccionada, 20).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 21).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 22).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 23).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 24).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 25).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(jTable.getValueAt(filaSeleccionada, 26).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(jTable.getValueAt(filaSeleccionada, 27).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(jTable.getValueAt(filaSeleccionada, 28).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 29).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 30).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(jTable.getValueAt(filaSeleccionada, 31).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 32).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 33).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailUsuario(jTable.getValueAt(filaSeleccionada, 34).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailsupervisor(jTable.getValueAt(filaSeleccionada, 35).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoEmpresa(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 36).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdParentesco(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 37).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 38).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 39).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(jTable.getValueAt(filaSeleccionada, 40).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(jTable.getValueAt(filaSeleccionada, 41).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(jTable.getValueAt(filaSeleccionada, 42).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(Long.valueOf(jTable.getValueAt(filaSeleccionada, 43).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdServicio(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 44).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 45).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFiltradoAgenda(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 46).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setExpandirHistoria(Boolean.valueOf(jTable.getValueAt(filaSeleccionada, 47).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(Long.valueOf(jTable.getValueAt(filaSeleccionada, 48).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 49).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 50).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(0L);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 52).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 53).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 54).toString()));
        mUpdateUsuarioxprograma(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().toString(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        this.historiaDAO.actualizarFechaHoraAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        inicioInformacionHistoria();
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva")) {
            this.JTP_Informacion.setSelectedIndex(2);
        } else {
            this.JTP_Informacion.setSelectedIndex(1);
        }
        configuracionPanel();
        this.estadoAgenda.set(false);
    }

    private void mUpdateUsuarioxprograma(String idusuario, String idprograma, String idatencion) {
        try {
            String idUsuarioPrograma = this.xUsuarioPorProgramaService.buscarUsuarioPorPrograma(idusuario, idprograma);
            if (idUsuarioPrograma != null && !idUsuarioPrograma.equals("0")) {
                this.xUsuarioPorProgramaService.actualizarAtencionUsuarioPorPrograma(idUsuarioPrograma, idatencion);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void inicializarDatosClaseInformacionAgendaServicios(JTable jTable, int filaSeleccionada) {
        this.listadoItemsCargados = new Vector<>();
        jTable.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO = new InformacionAgendaMedicaDTO();
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(jTable.getValueAt(filaSeleccionada, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(jTable.getValueAt(filaSeleccionada, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(jTable.getValueAt(filaSeleccionada, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(jTable.getValueAt(filaSeleccionada, 4).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(jTable.getValueAt(filaSeleccionada, 5).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(jTable.getValueAt(filaSeleccionada, 8).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(jTable.getValueAt(filaSeleccionada, 11).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(jTable.getValueAt(filaSeleccionada, 6).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(jTable.getValueAt(filaSeleccionada, 12).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(jTable.getValueAt(filaSeleccionada, 17).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(jTable.getValueAt(filaSeleccionada, 18).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 15).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(jTable.getValueAt(filaSeleccionada, 13).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(jTable.getValueAt(filaSeleccionada, 14).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(jTable.getValueAt(filaSeleccionada, 0).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(jTable.getValueAt(filaSeleccionada, 19).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(new Long(0L));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 22).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 23).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 24).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 31).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 25).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(1);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 28).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 29).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 30).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdConvenio(Long.valueOf(jTable.getValueAt(filaSeleccionada, 33).toString()));
        this.historiaDAO.actualizarFechaHoraAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
    }

    private void configuracionPanel() {
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva")) {
            if (this.JTP_Informacion.getSelectedIndex() == 2) {
                this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + "_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "  EDAD: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "  SEXO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "  TIPO CONSULTA : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta() + "  No. Atención : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "  No. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + " F. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), 0, 0, new Font("Arial", 1, 14), Color.red));
                return;
            } else {
                this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), Color.red));
                return;
            }
        }
        if (this.JTP_Informacion.getSelectedIndex() == 1) {
            this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + "_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "  EDAD: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "  SEXO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "  No. Atención : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "  No. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + " F. Ingreso : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), 0, 0, new Font("Arial", 1, 14), Color.red));
        } else {
            this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), Color.red));
        }
    }

    private void inicioInformacionHistoria() {
        configuracionPanel();
        crearArbolItemsHistoria();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    private void crearArbolItemsHistoria() {
        String nombreNodo;
        String nombre;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO != null) {
            this.modelo = null;
            List<ConfiguracionItems> informacionItemsHistoria = this.historiaDAO.listaItemsPorIdHistoria(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4$MyTreeRenderer.class */
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
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva") || Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Consulta Externa")) {
            crearTablaAgendaProgramada();
            crearTablaAgendaNoProgramada();
            this.JDCFechaAgenda.setDate(this.metodos.getFechaActual());
        }
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva") || Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Servicios")) {
            this.JDCFechaAgenda1.setDate(this.metodos.getFechaActual());
            crearTablaAgendaServicio();
            this.esLlenoCombo = false;
            LlenarComboServicio();
            if (Principal.informacionIps.getIdentificacion().equals("800080586") || Principal.informacionIps.getIdentificacion().equals("812002836")) {
                this.filtroAtencion = "1";
                this.JCH_Clasificado.setSelected(true);
            }
            this.sexo.clear();
            this.sexo.add(this.JRBFemenino.getText());
            this.sexo.add(this.JRBMasculino.getText());
        }
        this.JLAlergia.setVisible(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaProgramada() {
        this.modeloModel = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Tipo Consulta", "Hora", "Estado", "Empresa Convenio", "CEspecial", "esAtencionEspecial", "nombreSexo", "fechaNacimiento", "horaFinal", "idUsuarioAtendido", "idIngreso", "idClaseCita", "idTipohc", "asistida", "idCita", "idAtencion", "idTipoCita", "esRemitada", "idPrograma", "esSaludOcupacional", "esControl", "esOdontologica", "idTratamiento", "motivoConsulta", "enfermedadActual", "esPeriodico", "esControlHistoria", "fechaIngreso", "idTipoAtencion", "TipoAtencion", "emailUsuario", "emailsupervisor", "idTipoEmpresa", "idParentesco", "tipoCita", "tipoGuardado", "fecha_HoraAtencion", "idUsuarioPrograma", "idOrden", "idProcedimiento", "idServicio", "idManPower", "filtradoAgenda", "expandirHistoria", "tipoTratamiento", "esTriage", "formaHistoria", "Url_Videollamada", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.36
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, Integer.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Boolean.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_AgendaProgramada;
        JTable jTable2 = this.JTB_AgendaProgramada;
        jTable.setAutoResizeMode(0);
        this.JTB_AgendaProgramada.doLayout();
        this.JTB_AgendaProgramada.setModel(this.modeloModel);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(7).setPreferredWidth(280);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(53).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTB_AgendaProgramada.getColumnModel().getColumn(54).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaNoProgramada() {
        this.modeloCitasNPModel = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Tipo Consulta", "Hora", "Estado", "Empresa Convenio", "CEspecial", "esAtencionEspecial", "nombreSexo", "fechaNacimiento", "horaFinal", "idUsuarioAtendido", "idIngreso", "idClaseCita", "idTipohc", "asistida", "idCita", "idAtencion", "idTipoCita", "esRemitada", "idPrograma", "esSaludOcupacional", "esControl", "esOdontologica", "idTratamiento", "motivoConsulta", "enfermedadActual", "esPeriodico", "esControlHistoria", "fechaIngreso", "idTipoAtencion", "TipoAtencion", "emailUsuario", "emailsupervisor", "idTipoEmpresa", "idParentesco", "tipoCita", "tipoGuardado", "fecha_HoraAtencion", "idUsuarioPrograma", "idOrden", "idProcedimiento", "idServicio", "idManPower", "filtradoAgenda", "expandirHistoria", "tipoTratamiento", "esTriage", "formaHistoria", "Url_Videollamada", "Triage", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.37
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, Integer.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Boolean.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_AgendaNoProgramada;
        JTable jTable2 = this.JTB_AgendaNoProgramada;
        jTable.setAutoResizeMode(0);
        this.JTB_AgendaNoProgramada.doLayout();
        this.JTB_AgendaNoProgramada.setModel(this.modeloCitasNPModel);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(53).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTB_AgendaNoProgramada.getColumnModel().getColumn(54).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "Usuario", "IdSexo", "Sexo", "Edad", "fechaNacimiento", "Triage", "Clase Cita", "clasificacionAtencionEspecialIcono", "Motivo Consulta", "Convenio", "idUsuario", "Servicio", "Enfermedad Actual", "idTipoHistoria", "Profesional Asignado", "No Ingreso", "No Atencion", "Orden", "Orden Unidosis", "Especialidad Interconsulta", "IdTipoAtencion", "TipoGuardado", "clasificacionAtencionEspecialIcono", "idClaseCita", "fase", "Tiempo(Horas)", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad", "idPrograma", "Camilla/Cama", "idConvenio"}) { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.38
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Icon.class, String.class, String.class, Long.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, Long.class, Integer.class, Integer.class, Long.class, String.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_AgendaServicios.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.39
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTB_AgendaServicios.setModel(this.modeloServicio);
        this.JTB_AgendaServicios.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTB_AgendaServicios.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTB_AgendaServicios.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_AgendaServicios.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(4).setPreferredWidth(80);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.")) {
            this.JTB_AgendaServicios.getColumnModel().getColumn(5).setPreferredWidth(70);
            this.JTB_AgendaServicios.getColumnModel().getColumn(6).setPreferredWidth(80);
        } else {
            this.JTB_AgendaServicios.getColumnModel().getColumn(5).setPreferredWidth(170);
            this.JTB_AgendaServicios.getColumnModel().getColumn(6).setPreferredWidth(120);
        }
        this.JTB_AgendaServicios.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(8).setPreferredWidth(250);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setPreferredWidth(500);
        this.JTB_AgendaServicios.getColumnModel().getColumn(11).setPreferredWidth(400);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(32).setPreferredWidth(150);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(33).setMaxWidth(0);
    }

    private void cargarAgendaConsulta(JTable table, DefaultTableModel modeloModel, List<InformacionAgendaMedicaDTO> listadoList, JLabel jlabel, JScrollPane jspScroll) {
        jspScroll.remove(table);
        jspScroll.setViewportView((Component) null);
        jspScroll.repaint();
        int nitems = 0;
        if (listadoList.size() != -1) {
            if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                this.metodos.mEstablecerTextEditor(table, 1);
                this.metodos.mEstablecerTextEditor(table, 4);
                this.metodos.mEstablecerTextEditor(table, 7);
                this.metodos.mEstablecerTextEditor(table, 2);
            }
            for (int i = 0; i < listadoList.size(); i++) {
                modeloModel.addRow(this.datosAgenServicio);
                modeloModel.setValueAt(listadoList.get(i).getNumeroHistoria(), i, 0);
                modeloModel.setValueAt(listadoList.get(i).getNombreUsuario(), i, 1);
                modeloModel.setValueAt(listadoList.get(i).getEdad(), i, 2);
                modeloModel.setValueAt(listadoList.get(i).getIdSexo(), i, 3);
                modeloModel.setValueAt(listadoList.get(i).getNombreTipoConsulta(), i, 4);
                modeloModel.setValueAt(listadoList.get(i).getHoraIncial(), i, 5);
                modeloModel.setValueAt(listadoList.get(i).getEstadoTextoAtencion(), i, 6);
                modeloModel.setValueAt(listadoList.get(i).getNombreEmpresaCovenio(), i, 7);
                modeloModel.setValueAt(listadoList.get(i).getEsAtencionEspecial(), i, 9);
                if (null == listadoList.get(i).getEsAtencionEspecial()) {
                    modeloModel.setValueAt(new JLabel(""), i, 8);
                } else {
                    switch (listadoList.get(i).getEsAtencionEspecial().intValue()) {
                        case 1:
                            modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), i, 8);
                            break;
                        case 2:
                            modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), i, 8);
                            break;
                        case 3:
                            modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), i, 8);
                            break;
                        case 4:
                            modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), i, 8);
                            break;
                        default:
                            modeloModel.setValueAt(new JLabel(""), i, 8);
                            break;
                    }
                }
                table.setDefaultRenderer(JLabel.class, new Render(listadoList.get(i).getEsAtencionEspecial().intValue(), 9));
                modeloModel.setValueAt(listadoList.get(i).getNombreSexo(), i, 10);
                modeloModel.setValueAt(listadoList.get(i).getFechaNacimiento(), i, 11);
                modeloModel.setValueAt(listadoList.get(i).getHoraFinal(), i, 12);
                modeloModel.setValueAt(listadoList.get(i).getIdUsuarioAtendido(), i, 13);
                modeloModel.setValueAt(listadoList.get(i).getIdIngreso(), i, 14);
                modeloModel.setValueAt(listadoList.get(i).getIdClaseCita(), i, 15);
                modeloModel.setValueAt(listadoList.get(i).getIdTipohc(), i, 16);
                modeloModel.setValueAt(listadoList.get(i).getAsistida(), i, 17);
                modeloModel.setValueAt(listadoList.get(i).getIdCita(), i, 18);
                modeloModel.setValueAt(listadoList.get(i).getIdAtencion(), i, 19);
                modeloModel.setValueAt(listadoList.get(i).getIdTipoCita(), i, 20);
                modeloModel.setValueAt(listadoList.get(i).getEsRemitada(), i, 21);
                modeloModel.setValueAt(listadoList.get(i).getIdPrograma(), i, 22);
                modeloModel.setValueAt(listadoList.get(i).getEsSaludOcupacional(), i, 23);
                modeloModel.setValueAt(listadoList.get(i).getEsControl(), i, 24);
                modeloModel.setValueAt(listadoList.get(i).getEsOdontologica(), i, 25);
                modeloModel.setValueAt(listadoList.get(i).getIdTratamiento(), i, 26);
                modeloModel.setValueAt(listadoList.get(i).getMotivoConsulta(), i, 27);
                modeloModel.setValueAt(listadoList.get(i).getEnfermedadActual(), i, 28);
                modeloModel.setValueAt(listadoList.get(i).getEsPeriodico(), i, 29);
                modeloModel.setValueAt(listadoList.get(i).getEsControlHistoria(), i, 30);
                modeloModel.setValueAt(listadoList.get(i).getFechaIngreso(), i, 31);
                modeloModel.setValueAt(listadoList.get(i).getIdTipoAtencion(), i, 32);
                modeloModel.setValueAt(listadoList.get(i).getTipoAtencion(), i, 33);
                modeloModel.setValueAt(listadoList.get(i).getEmailUsuario(), i, 34);
                modeloModel.setValueAt(listadoList.get(i).getEmailsupervisor(), i, 35);
                modeloModel.setValueAt(listadoList.get(i).getIdTipoEmpresa(), i, 36);
                modeloModel.setValueAt(listadoList.get(i).getIdParentesco(), i, 37);
                modeloModel.setValueAt(listadoList.get(i).getTipoCita(), i, 38);
                modeloModel.setValueAt(listadoList.get(i).getTipoGuardado(), i, 39);
                modeloModel.setValueAt(listadoList.get(i).getFecha_HoraAtencion(), i, 40);
                modeloModel.setValueAt(listadoList.get(i).getIdUsuarioPrograma(), i, 41);
                modeloModel.setValueAt(listadoList.get(i).getIdOrden(), i, 42);
                modeloModel.setValueAt(listadoList.get(i).getIdProcedimiento(), i, 43);
                modeloModel.setValueAt(listadoList.get(i).getIdServicio(), i, 44);
                modeloModel.setValueAt(listadoList.get(i).getIdManPower(), i, 45);
                modeloModel.setValueAt(listadoList.get(i).getFiltradoAgenda(), i, 46);
                modeloModel.setValueAt(listadoList.get(i).getExpandirHistoria(), i, 47);
                modeloModel.setValueAt(listadoList.get(i).getTipoTratamiento(), i, 48);
                modeloModel.setValueAt(listadoList.get(i).getEsTriage(), i, 49);
                modeloModel.setValueAt(listadoList.get(i).getFormaHistoria(), i, 50);
                modeloModel.setValueAt(listadoList.get(i).getUrlVideollamada(), i, 51);
                modeloModel.setValueAt(listadoList.get(i).getIdModalidad(), i, 52);
                modeloModel.setValueAt(listadoList.get(i).getIdEntornoAtencion(), i, 53);
                modeloModel.setValueAt(listadoList.get(i).getIdTipoDiscapacidad(), i, 54);
                nitems++;
                table.setDefaultRenderer(Object.class, new MiRenderProgramada());
            }
            modeloModel.setRowCount(listadoList.size());
            modeloModel.fireTableDataChanged();
        }
        jspScroll.setViewportView(table);
        jspScroll.repaint();
        jlabel.setText(String.valueOf(nitems));
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4$MiRenderProgramada.class */
    public class MiRenderProgramada extends DefaultTableCellRenderer {
        public MiRenderProgramada() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 17) != null) {
                int valorCelda = Integer.valueOf(table.getValueAt(row, 17).toString()).intValue();
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

    private void cargarAgendaNoProgramada() {
        List<InformacionAgendaMedicaDTO> listadoCitasNPList;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            listadoCitasNPList = this.historiaDAO.listadoCitasNoProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId(), 1);
        } else {
            listadoCitasNPList = this.historiaDAO.listadoCitasNoProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId(), 0);
        }
        cargarAgendaConsulta(this.JTB_AgendaNoProgramada, this.modeloCitasNPModel, listadoCitasNPList, this.JLBNPRegistro, this.JSP_AgendaNoProgramada);
    }

    private void cargarAgendaProgramada() {
        List<InformacionAgendaMedicaDTO> listadoList = this.historiaDAO.listadoCitasProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId());
        cargarAgendaConsulta(this.JTB_AgendaProgramada, this.modeloModel, listadoList, this.JLBNRegistro, this.JSP_AgendaProgramada);
    }

    public void cargarDatosNuevos() {
        if (this.JTP_Informacion.getSelectedIndex() == 0) {
            cargarAgendaProgramada();
            cargarAgendaNoProgramada();
        } else {
            if (this.JTP_Informacion.getSelectedIndex() == 1) {
            }
        }
    }

    public void cargarDatos() {
        List<InformacionAgendaMedicaDTO> listadoCitasNPList;
        this.JLB_NumeroRegistro.setText("0");
        if ((Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva") || Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Consulta Externa")) && this.JTP_Informacion.getTitleAt(this.JTP_Informacion.getSelectedIndex()).equals("CONSULTA EXTERNA")) {
            List<InformacionAgendaMedicaDTO> listadoList = this.historiaDAO.listadoCitasProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId());
            cargarAgendaConsulta(this.JTB_AgendaProgramada, this.modeloModel, listadoList, this.JLBNRegistro, this.JSP_AgendaProgramada);
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                listadoCitasNPList = this.historiaDAO.listadoCitasNoProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId(), 1);
            } else {
                listadoCitasNPList = this.historiaDAO.listadoCitasNoProgramadas(this.filtroEstado, this.metodos.formatoAMD1.format(this.JDCFechaAgenda.getDate()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), Principal.sedeUsuarioSeleccionadaDTO.getId(), 0);
            }
            cargarAgendaConsulta(this.JTB_AgendaNoProgramada, this.modeloCitasNPModel, listadoCitasNPList, this.JLBNPRegistro, this.JSP_AgendaNoProgramada);
        }
        if (Principal.clasehistoriace.getNombreAgenda().equals("Historia_Nueva") || Principal.clasehistoriace.getNombreAgenda().equals("Agenda de Servicios")) {
            List<Integer> filtroServicio = new ArrayList<>();
            if (this.JRB_FSSeleccion.isSelected()) {
                filtroServicio.add(Integer.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]));
            } else {
                for (String idServicio1 : this.idServicio) {
                    filtroServicio.add(Integer.valueOf(idServicio1));
                }
            }
            if (this.JTP_Informacion.getTitleAt(this.JTP_Informacion.getSelectedIndex()).equals("SERVICIOS")) {
                if (this.estadoAtencion.intValue() == 0 || this.estadoAtencion.intValue() == 1 || !this.JTFBuscar.getText().isEmpty()) {
                    List<AgendaHCDTO> listadoAtencionServicios = null;
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                        if (this.esLlenoCombo.booleanValue() && ((Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) && !this.sexo.isEmpty())) {
                            if (this.JCH_Clasificado.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesClasificadosPsiquiatras(Long.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.sexo);
                            } else if (this.JCH_Observacion.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesEnObservacionPsiquiatras(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.sexo);
                            }
                        }
                    } else if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 382 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 21 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 2 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 710) {
                        if (this.esLlenoCombo.booleanValue()) {
                            if (this.JCH_PorClasificar.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesSinClasificar(Long.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)));
                                if (!this.numeroDias) {
                                    if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
                                        this.JSDias.setValue(30);
                                    } else {
                                        this.JSDias.setValue(2);
                                    }
                                } else {
                                    this.numeroDias = false;
                                }
                            } else if (this.JCH_Clasificado.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesClasificados(Long.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, Integer.valueOf(this.jSpinner1.getValue().toString()), this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)));
                                if (!this.numeroDias) {
                                    if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
                                        this.JSDias.setValue(30);
                                    } else {
                                        this.JSDias.setValue(2);
                                    }
                                } else {
                                    this.numeroDias = false;
                                }
                            } else if (this.JCH_Observacion.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesObservacionV4(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)));
                                if (!this.numeroDias) {
                                    if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
                                        this.JSDias.setValue(30);
                                    } else {
                                        this.JSDias.setValue(2);
                                    }
                                } else {
                                    this.numeroDias = false;
                                }
                            } else if (this.JCH_Interconsulta.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesInterconsultas(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)), 0L);
                            } else if (this.JCH_ImagenesDx.isSelected()) {
                                listadoAtencionServicios = this.AgendaService.listarPacientesImagenesDxV4(Long.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(this.filtroAtencion), this.idServicio[this.JCB_Servicio.getSelectedIndex()]);
                            }
                        }
                    } else if (this.esLlenoCombo.booleanValue() && this.JCH_Interconsulta.isSelected()) {
                        listadoAtencionServicios = this.AgendaService.listarPacientesInterconsultas(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoEgreso, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                    }
                    if (listadoAtencionServicios != null) {
                        mCargaAgendaServiciosV2(listadoAtencionServicios);
                    }
                }
            }
        }
    }

    private void ocultarColumnasServicios() {
        List<Integer> posiciones = new ArrayList<>();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            posiciones.add(7);
            posiciones.add(8);
            posiciones.add(16);
            posiciones.add(17);
        } else if (this.JCH_PorClasificar.isSelected()) {
            posiciones.add(7);
            posiciones.add(26);
            posiciones.add(27);
        } else if (this.JCH_Clasificado.isSelected()) {
            posiciones.add(26);
            posiciones.add(27);
        } else if (this.JCH_Observacion.isSelected()) {
            posiciones.add(7);
            posiciones.add(16);
            posiciones.add(17);
            posiciones.add(26);
            posiciones.add(27);
        } else if (this.JCH_Interconsulta.isSelected()) {
            posiciones.add(26);
            posiciones.add(27);
        }
        posiciones.forEach(e -> {
            this.JTB_AgendaServicios.getColumnModel().getColumn(e.intValue()).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(e.intValue()).setMaxWidth(0);
        });
    }

    private void mCargaAgendaServiciosV2(List<AgendaHCDTO> listadoList) {
        this.xEntra++;
        this.JSP_AgendaServicios.remove(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.setViewportView((Component) null);
        this.JSP_AgendaServicios.repaint();
        if (!listadoList.isEmpty()) {
            this.rowAgendaServicio = 0;
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloServicio.addRow(this.datosAgenServicio);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaHoraIngreso(), this.rowAgendaServicio, 0);
                this.modeloServicio.setValueAt(listadoList.get(i).getDocumento(), this.rowAgendaServicio, 1);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreUsuario(), this.rowAgendaServicio, 2);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdSexo(), this.rowAgendaServicio, 3);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreSexo(), this.rowAgendaServicio, 4);
                this.modeloServicio.setValueAt(listadoList.get(i).getEdad(), this.rowAgendaServicio, 5);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaNacimiento(), this.rowAgendaServicio, 6);
                this.modeloServicio.setValueAt(listadoList.get(i).getTriage(), this.rowAgendaServicio, 7);
                this.modeloServicio.setValueAt(listadoList.get(i).getClaseCita(), this.rowAgendaServicio, 8);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuario(), this.rowAgendaServicio, 12);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoAtencion(), this.rowAgendaServicio, 13);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmpresaConvenio(), this.rowAgendaServicio, 11);
                if (null == listadoList.get(i).getClasificacionAtencionEspecial()) {
                    this.modeloServicio.setValueAt(new ImageIcon(""), this.rowAgendaServicio, 9);
                } else {
                    switch (listadoList.get(i).getClasificacionAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png")), this.rowAgendaServicio, 9);
                            break;
                        case 2:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png")), this.rowAgendaServicio, 9);
                            break;
                        case 3:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png")), this.rowAgendaServicio, 9);
                            break;
                        case 4:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png")), this.rowAgendaServicio, 9);
                            break;
                        default:
                            this.modeloServicio.setValueAt(new ImageIcon(""), this.rowAgendaServicio, 9);
                            break;
                    }
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getMotivoConsulta(), this.rowAgendaServicio, 10);
                this.modeloServicio.setValueAt(listadoList.get(i).getEnfermedadActual(), this.rowAgendaServicio, 14);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoHistoria(), this.rowAgendaServicio, 15);
                this.modeloServicio.setValueAt(listadoList.get(i).getProfesionalAsignado(), this.rowAgendaServicio, 16);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdIngreso(), this.rowAgendaServicio, 17);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdAtencion(), this.rowAgendaServicio, 18);
                if (listadoList.get(i).getAgendaOrdenes() == null || listadoList.get(i).getAgendaOrdenes().isEmpty()) {
                    this.modeloServicio.setValueAt(0, this.rowAgendaServicio, 19);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenes().get(0)).getIdOrden(), this.rowAgendaServicio, 19);
                }
                if (listadoList.get(i).getAgendaOrdenesUnidosis() == null || listadoList.get(i).getAgendaOrdenesUnidosis().isEmpty()) {
                    this.modeloServicio.setValueAt(0, this.rowAgendaServicio, 20);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenesUnidosis().get(0)).getIdOrden(), this.rowAgendaServicio, 20);
                }
                if (listadoList.get(i).getAgendaOrdenesInterconsulta() == null || listadoList.get(i).getAgendaOrdenesInterconsulta().isEmpty()) {
                    this.modeloServicio.setValueAt("", this.rowAgendaServicio, 21);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenesInterconsulta().get(0)).getEspecialidad(), this.rowAgendaServicio, 21);
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoAtencion(), this.rowAgendaServicio, 22);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoGuardado(), this.rowAgendaServicio, 23);
                this.modeloServicio.setValueAt(listadoList.get(i).getClasificacionAtencionEspecial(), this.rowAgendaServicio, 24);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), this.rowAgendaServicio, 25);
                if (listadoList.get(i).getFase() == null) {
                    this.modeloServicio.setValueAt("", this.rowAgendaServicio, 26);
                } else if (isNumber(listadoList.get(i).getFase()) && listadoList.get(i).getIdTipoAtencion().longValue() > 1) {
                    int fase = Integer.valueOf(listadoList.get(i).getFase()).intValue();
                    double valor = Math.floor(fase / 30) + 1.0d;
                    if (listadoList.get(i).getIdTipoAtencion().longValue() != 4) {
                        this.modeloServicio.setValueAt(fase + " días", this.rowAgendaServicio, 26);
                    } else if (valor > 6.0d) {
                        this.modeloServicio.setValueAt("Ha superado la fase 6  " + fase + " días", this.rowAgendaServicio, 26);
                    } else {
                        this.modeloServicio.setValueAt("fase " + valor + " -  " + fase + " días", this.rowAgendaServicio, 26);
                    }
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), this.rowAgendaServicio, 25);
                if (listadoList.get(i).getHora() == null) {
                    this.modeloServicio.setValueAt(0, this.rowAgendaServicio, 27);
                } else {
                    this.modeloServicio.setValueAt(listadoList.get(i).getHora(), this.rowAgendaServicio, 27);
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getIdModalidad(), this.rowAgendaServicio, 28);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdEntornoAtencion(), this.rowAgendaServicio, 29);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoDiscapacidad(), this.rowAgendaServicio, 30);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdPrograma(), this.rowAgendaServicio, 31);
                this.modeloServicio.setValueAt(listadoList.get(i).getCama(), this.rowAgendaServicio, 32);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdConvenio(), this.rowAgendaServicio, 33);
                this.rowAgendaServicio++;
                this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRenderAgendaServicios2());
            }
            this.modeloServicio.setRowCount(listadoList.size());
            this.modeloServicio.fireTableDataChanged();
            this.JLB_NumeroRegistro.setText("" + listadoList.size());
        } else {
            this.JLB_NumeroRegistro.setText("0");
        }
        ocultarColumnasServicios();
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.repaint();
    }

    public boolean isNumber(String valor) {
        try {
            Integer.valueOf(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4$MiRenderAgendaServicios2.class */
    public class MiRenderAgendaServicios2 extends DefaultTableCellRenderer {
        public MiRenderAgendaServicios2() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String filtro = JIF_Historia_Clinica_v4.this.filtroAtencion;
            switch (filtro) {
                case "0":
                    cell.setBackground(Color.CYAN);
                    cell.setForeground(Color.BLACK);
                    break;
                case "1":
                    cell.setBackground(new Color(133, 218, 160));
                    cell.setForeground(Color.BLACK);
                    break;
                case "2":
                    cell.setBackground(Color.ORANGE);
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    if (JIF_Historia_Clinica_v4.this.JCH_ImagenesDx.isSelected()) {
                        cell.setBackground(new Color(51, 153, 255));
                        cell.setForeground(Color.BLACK);
                        break;
                    } else {
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                        break;
                    }
                    break;
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4$MiRenderAgendaServicios.class */
    public class MiRenderAgendaServicios extends DefaultTableCellRenderer {
        public MiRenderAgendaServicios() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 55) != null) {
                int valorCelda = Integer.valueOf(table.getValueAt(row, 55).toString()).intValue();
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v4$MyTreeCellRenderer.class */
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
        List<Object[]> listServicio = this.informacionVariaUrgenciasHospitalizacionDAO.listadoServiciosEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), 1);
        if (!listServicio.isEmpty()) {
            this.idServicio = new String[listServicio.size()];
            for (int i = 0; i < listServicio.size(); i++) {
                this.idServicio[i] = String.valueOf(listServicio.get(i)[0]);
                this.JCB_Servicio.addItem(listServicio.get(i)[1].toString());
            }
            this.esLlenoCombo = true;
            this.JCB_Servicio.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreServicio());
        }
    }

    private void mConsultarALerta() {
        String xsql = "SELECT g_tipoalerta.Nbre, g_usuarioxtipoalerta.Detalle FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) WHERE (g_usuarioxtipoalerta.Estado =1 AND g_tipoalerta.EsHC =1 AND g_usuarioxtipoalerta.Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY g_tipoalerta.Nbre ASC ";
        System.out.println("Alerta : " + xsql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            String mensaje = "";
            if (xrs.next()) {
                String xmensaje = "";
                xrs.beforeFirst();
                while (xrs.next()) {
                    mensaje = "EL PACIENTE ES " + xrs.getString(1).toUpperCase() + " A " + xrs.getString(2).toUpperCase();
                    xmensaje = xmensaje + "TIPO DE MENSAJE: " + xrs.getString(1) + "\nINFORMACIÓN:" + xrs.getString(2).toUpperCase() + "\n";
                }
                this.JPI_Historia.setBackground(Color.YELLOW);
                this.jPanel2.setBackground(Color.YELLOW);
                this.jPanel1.setBackground(Color.YELLOW);
                this.JLAlergia.setVisible(true);
                this.JLAlergia.setBackground(Color.YELLOW);
                this.JLAlergia.setFont(new Font("Arial", 1, 16));
                this.JLAlergia.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
                this.JLAlergia.setForeground(Color.BLACK);
                this.JLAlergia.setHorizontalAlignment(0);
                this.JLAlergia.setVerticalAlignment(0);
                this.JLAlergia.setText("¡ALERTA!  " + mensaje);
                final Color[] colores = {Color.WHITE, Color.RED, Color.BLACK};
                new Thread(new Runnable() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v4.40
                    int indice = 0;

                    @Override // java.lang.Runnable
                    public void run() {
                        while (true) {
                            JIF_Historia_Clinica_v4.this.JLAlergia.setForeground(colores[this.indice]);
                            this.indice = (this.indice + 1) % colores.length;
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            } else {
                this.JLAlergia.setVisible(false);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Historia_Clinica_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
