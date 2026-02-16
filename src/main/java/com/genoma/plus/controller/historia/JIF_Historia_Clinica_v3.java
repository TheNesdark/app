package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import Historia.JPSo_Concepto_I;
import Historia.clasesHistoriaCE;
import Salud_Ocupacional.JIFAgenda;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.jpa.entities.LlamadasEntity;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.LlamadasService;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v3.class */
public final class JIF_Historia_Clinica_v3 extends JInternalFrame {
    private boolean xlleno1;
    public DefaultTableModel xmodelo;
    private String xsql;
    private Object[] xdato;
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
    private boolean disponible;
    public JPSo_Concepto_I xjifconceptosio_i;
    private ButtonGroup JBG_Filtrado;
    private JComboBox JCBProcedimiento;
    private JCheckBox JCHFiltroPorc;
    private JCheckBox JCHFiltroProfesional;
    public JDateChooser JDCFecha;
    private JPanel JPIDatosB;
    private JPanel JPIFiltro;
    private JPanel JPI_Agenda;
    private JPanel JPI_AgendaDetalle;
    private JPanel JPI_Historia;
    public JPanel JPI_PanelPrincipal;
    private JSplitPane JPS_PanelHistoria;
    private JScrollPane JSPDatosAgenta;
    private JScrollPane JSP_Datos1;
    private JScrollPane JSP_Datos2;
    private JTable JTBDatosAgenda;
    private JTextField JTF_Nombre;
    private JTabbedPane JTP_Informacion;
    private JTree JTree_Atencion;
    public JRadioButton btnAtendidas;
    public JRadioButton btnEnAtencion;
    public JRadioButton btnPorAtender;
    public JRadioButton btnTodas;
    private JTextField txtCantidad;
    private String[][] xidprocedimiento = (String[][]) null;
    private boolean xlleno = false;
    private int estado = 0;
    private int xAplicaFiltroP = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    private final EstadoAtencionService estadoAtencion = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    private Integer num = 0;
    private Integer estado_ = 0;
    private DefaultTreeModel modelo = null;
    private String filtroEstado = "1";
    private Metodos metodos = new Metodos();
    private Boolean esLlenoCombo = false;
    private Boolean estadoHilo = true;
    private Vector<ConfiguracionItems> listadoItemsCargados = new Vector<>();
    String filtroAtencion = "0";
    private int scrollPosition = 0;
    private int xEntra = 0;
    private int estado2 = 0;
    private int variableTabLlamador = -1;
    private String sexo = "";
    private String profesional = "";
    private String consultorio = "";
    private Integer estadoEgreso = 0;
    private final UsuarioPorProgramaService xUsuarioPorProgramaService = (UsuarioPorProgramaService) Principal.contexto.getBean(UsuarioPorProgramaService.class);
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);

    public JIF_Historia_Clinica_v3() {
        initComponents();
        springStart();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        mNuevo();
        ejecutarTareaTimer();
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_Historia_Clinica_v3.this.estadoAgenda.get()) {
                    JIF_Historia_Clinica_v3.this.mCargarDatos();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Salud Ocupacional");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r3v76, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JTP_Informacion = new JTabbedPane();
        this.JPI_Agenda = new JPanel();
        this.JPI_AgendaDetalle = new JPanel();
        this.JPIDatosB = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBProcedimiento = new JComboBox();
        this.JCHFiltroPorc = new JCheckBox();
        this.JCHFiltroProfesional = new JCheckBox();
        this.JPIFiltro = new JPanel();
        this.btnPorAtender = new JRadioButton();
        this.btnEnAtencion = new JRadioButton();
        this.btnAtendidas = new JRadioButton();
        this.btnTodas = new JRadioButton();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.txtCantidad = new JTextField();
        this.JTF_Nombre = new JTextField();
        this.JPI_Historia = new JPanel();
        this.JPS_PanelHistoria = new JSplitPane();
        this.JSP_Datos1 = new JScrollPane();
        this.JTree_Atencion = new JTree();
        this.JSP_Datos2 = new JScrollPane();
        this.JPI_PanelPrincipal = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORIA CLINICA V3.0");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_historiaclinicav3");
        addContainerListener(new ContainerAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.2
            public void componentRemoved(ContainerEvent evt) {
                JIF_Historia_Clinica_v3.this.formComponentRemoved(evt);
            }
        });
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.3
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_Historia_Clinica_v3.this.formAncestorRemoved(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.4
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_Historia_Clinica_v3.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_Historia_Clinica_v3.this.formInternalFrameClosed(evt);
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
        this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO:", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTP_Informacion.setForeground(new Color(0, 103, 0));
        this.JTP_Informacion.setFont(new Font("Arial", 1, 14));
        this.JTP_Informacion.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.5
            public void stateChanged(ChangeEvent evt) {
                JIF_Historia_Clinica_v3.this.JTP_InformacionStateChanged(evt);
            }
        });
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Historia_Clinica_v3.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.7
            public void itemStateChanged(ItemEvent evt) {
                JIF_Historia_Clinica_v3.this.JCBProcedimientoItemStateChanged(evt);
            }
        });
        this.JCHFiltroPorc.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPorc.setText("Filtro");
        this.JCHFiltroProfesional.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroProfesional.setForeground(Color.red);
        this.JCHFiltroProfesional.setText("Filtro Profesional(Atención)");
        this.JCHFiltroProfesional.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v3.this.JCHFiltroProfesionalActionPerformed(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.btnPorAtender.setBackground(new Color(0, 0, 102));
        this.JBG_Filtrado.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(new Color(255, 255, 255));
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.setOpaque(true);
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v3.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.btnEnAtencion.setBackground(new Color(177, 251, 177));
        this.JBG_Filtrado.add(this.btnEnAtencion);
        this.btnEnAtencion.setFont(new Font("Arial", 1, 12));
        this.btnEnAtencion.setText("En atención");
        this.btnEnAtencion.setOpaque(true);
        this.btnEnAtencion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v3.this.btnEnAtencionActionPerformed(evt);
            }
        });
        this.btnAtendidas.setBackground(new Color(103, 0, 103));
        this.JBG_Filtrado.add(this.btnAtendidas);
        this.btnAtendidas.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas.setForeground(new Color(255, 255, 255));
        this.btnAtendidas.setText("Atendidas");
        this.btnAtendidas.setOpaque(true);
        this.btnAtendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.11
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v3.this.btnAtendidasActionPerformed(evt);
            }
        });
        this.JBG_Filtrado.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.12
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_v3.this.btnTodasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addGap(12, 12, 12).addComponent(this.btnEnAtencion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnTodas).addGap(19, 19, 19)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.btnTodas).addComponent(this.btnEnAtencion).addComponent(this.btnAtendidas, -2, 23, -2)).addGap(0, 0, 32767)));
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProcedimiento, -2, 543, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltroPorc).addComponent(this.JCHFiltroProfesional, -2, 167, -2)).addContainerGap(7, 32767)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGap(0, 7, 32767).addComponent(this.JCHFiltroPorc).addGap(5, 5, 5).addComponent(this.JCHFiltroProfesional)).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBProcedimiento, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JDCFecha, GroupLayout.Alignment.LEADING, -1, 50, 32767))).addContainerGap(11, 32767)));
        this.JSPDatosAgenta.setBorder(BorderFactory.createTitledBorder((Border) null, "LISTADO DE USUARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setCursor(new Cursor(0));
        this.JTBDatosAgenda.setRowHeight(25);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.13
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v3.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JTBDatosAgenda.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.14
            public void keyPressed(KeyEvent evt) {
                JIF_Historia_Clinica_v3.this.JTBDatosAgendaKeyPressed(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setForeground(new Color(255, 0, 0));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.JTF_Nombre.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_Nombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.15
            public void keyPressed(KeyEvent evt) {
                JIF_Historia_Clinica_v3.this.JTF_NombreKeyPressed(evt);
            }
        });
        GroupLayout JPI_AgendaDetalleLayout = new GroupLayout(this.JPI_AgendaDetalle);
        this.JPI_AgendaDetalle.setLayout(JPI_AgendaDetalleLayout);
        JPI_AgendaDetalleLayout.setHorizontalGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AgendaDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPI_AgendaDetalleLayout.createSequentialGroup().addComponent(this.txtCantidad, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Nombre, -2, 280, -2)).addComponent(this.JPIDatosB, -1, -1, 32767).addComponent(this.JSPDatosAgenta)).addContainerGap(24, 32767)));
        JPI_AgendaDetalleLayout.setVerticalGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AgendaDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosAgenta, -1, 523, 32767).addGap(18, 18, 32767).addGroup(JPI_AgendaDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCantidad, -2, 50, -2).addComponent(this.JTF_Nombre, -2, 50, -2)).addContainerGap()));
        GroupLayout JPI_AgendaLayout = new GroupLayout(this.JPI_Agenda);
        this.JPI_Agenda.setLayout(JPI_AgendaLayout);
        JPI_AgendaLayout.setHorizontalGroup(JPI_AgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_AgendaDetalle, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPI_AgendaLayout.setVerticalGroup(JPI_AgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AgendaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_AgendaDetalle, -1, -1, 32767).addContainerGap()));
        this.JTP_Informacion.addTab("CONSULTA EXTERNA", this.JPI_Agenda);
        this.JPS_PanelHistoria.setDividerSize(15);
        this.JPS_PanelHistoria.setResizeWeight(0.1d);
        this.JPS_PanelHistoria.setOneTouchExpandable(true);
        this.JSP_Datos1.setMinimumSize(new Dimension(80, 80));
        this.JSP_Datos1.setPreferredSize(new Dimension(200, 200));
        this.JTree_Atencion.setFont(new Font("Arial", 1, 12));
        this.JTree_Atencion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.16
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_v3.this.JTree_AtencionMouseClicked(evt);
            }
        });
        this.JTree_Atencion.addTreeSelectionListener(new TreeSelectionListener() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.17
            public void valueChanged(TreeSelectionEvent evt) {
                JIF_Historia_Clinica_v3.this.JTree_AtencionValueChanged(evt);
            }
        });
        this.JSP_Datos1.setViewportView(this.JTree_Atencion);
        this.JPS_PanelHistoria.setLeftComponent(this.JSP_Datos1);
        this.JSP_Datos2.setHorizontalScrollBarPolicy(31);
        this.JSP_Datos2.setPreferredSize(new Dimension(804, 504));
        this.JPI_PanelPrincipal.setAutoscrolls(true);
        this.JPI_PanelPrincipal.setPreferredSize(new Dimension(800, 500));
        GroupLayout JPI_PanelPrincipalLayout = new GroupLayout(this.JPI_PanelPrincipal);
        this.JPI_PanelPrincipal.setLayout(JPI_PanelPrincipalLayout);
        JPI_PanelPrincipalLayout.setHorizontalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1019, 32767));
        JPI_PanelPrincipalLayout.setVerticalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 720, 32767));
        this.JSP_Datos2.setViewportView(this.JPI_PanelPrincipal);
        this.JPS_PanelHistoria.setRightComponent(this.JSP_Datos2);
        GroupLayout JPI_HistoriaLayout = new GroupLayout(this.JPI_Historia);
        this.JPI_Historia.setLayout(JPI_HistoriaLayout);
        JPI_HistoriaLayout.setHorizontalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPS_PanelHistoria, -1, 1260, 32767).addContainerGap()));
        JPI_HistoriaLayout.setVerticalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPS_PanelHistoria, -1, 728, 32767).addContainerGap()));
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
        if (evt.getClickCount() == 2 && this.JTree_Atencion.getSelectionPath() != null) {
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
            if (this.JTP_Informacion.getSelectedIndex() == 0) {
                configuracionPanel();
                this.modelo = null;
                this.JTree_Atencion.setModel(this.modelo);
                this.listadoItemsCargados = new Vector<>();
                if (!this.estadoAgenda.get()) {
                    this.estadoAgenda.set(true);
                    ejecutarTareaTimer();
                    return;
                }
                return;
            }
            this.estadoAgenda.set(false);
            return;
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
    public void formAncestorRemoved(AncestorEvent evt) {
        System.err.println("ENTRO A formAncestorRemoved");
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
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarComboProc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1 && this.JTBDatosAgenda.getSelectedColumn() != 13) {
            if (this.JTBDatosAgenda.getSelectedColumn() != 10) {
                this.estadoAgenda.set(false);
                inicializarDatosClaseInformacionAgendaProgramada(this.JTBDatosAgenda, this.JTBDatosAgenda.getSelectedRow());
                this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1) + "' AND Consultorio ='" + Principal.consultorio + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                System.out.println(this.xsql);
                this.estado_ = 2;
                System.out.println("el estado es de: " + this.estado);
                return;
            }
            return;
        }
        LlamadasEntity seguimientos = new LlamadasEntity();
        if (!this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString().equals("ATENDIDO")) {
            if (this.JTBDatosAgenda.getSelectedColumn() == 13) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de  llamar al paciente " + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2) + " en el consultorio " + Principal.consultorio + "?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    llamar(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                    seguimientos.setDocumento(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                    seguimientos.setNombre(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
                    seguimientos.setProfesional(Principal.usuarioSistemaDTO.getNombreUsuario());
                    seguimientos.setConsultorio(Principal.consultorio);
                    seguimientos.setEstado(1);
                    seguimientos.setUbicacion(Principal.ubicacion);
                    new JIF_Historia_Clinica_v3();
                    seguimientos.setFecha_R(this.metodos.formadFecha(this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual())));
                    System.out.println(this.metodos.formadFecha(this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual())));
                    if (this.num.intValue() < 3) {
                        new ArrayList();
                        List<LlamadasEntity> list = this.llamadasService.ListarPacientes((String) this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1), Principal.consultorio);
                        if (list.isEmpty()) {
                            seguimientos.setOriginal(1);
                        } else {
                            seguimientos.setOriginal((Integer) null);
                        }
                        if (this.disponible) {
                            this.metodos.buscarPrimero(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                            this.metodos.fechaorigen(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                            this.llamadasService.Grabar(seguimientos);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este paciente ya lo llamaron en el consultorio " + this.consultorio + "", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                        this.estado_ = 1;
                        this.num = Integer.valueOf(list.size());
                        return;
                    }
                    int x1 = JOptionPane.showConfirmDialog(this, "se excedio el numero de llamados, quieres volver a llamar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x1 == 0) {
                        this.num = 0;
                        return;
                    }
                    return;
                }
                return;
            }
            int x2 = JOptionPane.showConfirmDialog(this, "paciente ya atendido?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1) + "' AND Consultorio ='" + Principal.consultorio + "' AND Estado=1";
                System.out.println(this.xsql);
                if (this.estado_.intValue() == 1) {
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.estado_ = 2;
                    System.out.println("el estado es de: " + this.estado);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Este paciente todavia no se ha atendido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El Paciente ya fue atendido", "ACCION BLOQUEADA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00ce: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:28:0x00ce */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d2: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x00d2 */
    public void llamar(String docuemtno) {
        this.disponible = true;
        this.xsql = "SELECT  Profesional , Estado, Consultorio  FROM ll_datos_basicos ldb2 WHERE Documento ='" + docuemtno + "' and Original =1";
        System.out.println(this.xsql);
        try {
            try {
                ResultSet rs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                if (rs.next()) {
                    this.profesional = rs.getString("Profesional");
                    this.estado2 = rs.getInt("Estado");
                    this.consultorio = rs.getString("Consultorio");
                    if (this.estado2 == 2 || this.estado2 == 0 || this.estado2 == 1) {
                        if (!this.profesional.equals(Principal.usuarioSistemaDTO.getNombreUsuario())) {
                            this.disponible = false;
                        }
                    } else {
                        this.disponible = true;
                    }
                }
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
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        System.out.println(this.JTBDatosAgenda.getSelectedColumn());
        if (evt.getKeyCode() == 18 && this.JTBDatosAgenda.getSelectedColumn() != 10) {
            mActualizar_DAtencion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NombreKeyPressed(KeyEvent evt) {
        if (this.xlleno1 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCargarDatos();
        }
    }

    private void btnAtendidas1ActionPerformed(ActionEvent evt) {
        this.estado = 3;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroProfesionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnAtencionActionPerformed(ActionEvent evt) {
        this.estado = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = 2;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
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

    private void inicializarDatosClaseInformacionAgendaProgramada(JTable jTable, int filaSeleccionada) {
        this.JTBDatosAgenda.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(jTable.getValueAt(filaSeleccionada, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(jTable.getValueAt(filaSeleccionada, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(jTable.getValueAt(filaSeleccionada, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(jTable.getValueAt(filaSeleccionada, 4).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(jTable.getValueAt(filaSeleccionada, 4).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(jTable.getValueAt(filaSeleccionada, 4).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraIncial(jTable.getValueAt(filaSeleccionada, 0).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(jTable.getValueAt(filaSeleccionada, 12).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(jTable.getValueAt(filaSeleccionada, 7).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(jTable.getValueAt(filaSeleccionada, 8).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEstadoTextoAtencion(jTable.getValueAt(filaSeleccionada, 6).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 17).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(jTable.getValueAt(filaSeleccionada, 9).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(Long.valueOf(jTable.getValueAt(filaSeleccionada, 19).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(jTable.getValueAt(filaSeleccionada, 20).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(jTable.getValueAt(filaSeleccionada, 16).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 11).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(jTable.getValueAt(filaSeleccionada, 10).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 18).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(1);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(0L);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(0L);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(0L);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(1);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(jTable.getValueAt(filaSeleccionada, 15).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.metodos.formatoAMD1.format(this.JDCFecha.getDate()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 21).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 22).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(jTable.getValueAt(filaSeleccionada, 23).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(0L);
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 690 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 382) {
            this.historiaDAO.actualizarFechaHoraAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        }
        inicioInformacionHistoria();
        this.JTP_Informacion.setSelectedIndex(1);
        configuracionPanel();
        if (Principal.xclaseso != null && this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString().equals("POR ATENDER")) {
            Principal.xclaseso.actualizarEstadoAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdOrden(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdProcedimiento(), 1);
        }
        this.estadoAgenda.set(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Hora", "No. Historia", "Usuario", "Edad", "Sexo", "Estado", "NEstado", "Id_UsuarioS", "Id_Ingreso", "Id_Orden", "Id_Atencion", "IdTipoAtencion", "Empresa", "Accion Llamar", "Accion Atendido", "FechaNacimiento", "Exámen", "IdHistoria", "idClaseCita", "idProcedimiento", "idOrden", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, JButton.class, JButton.class, String.class, String.class, Integer.class, Integer.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3.19
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTBDatosAgenda;
        JTable jTable2 = this.JTBDatosAgenda;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda.doLayout();
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setPreferredWidth(30);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setPreferredWidth(30);
        this.JTBDatosAgenda.getColumnModel().getColumn(19).setPreferredWidth(30);
        this.JTBDatosAgenda.getColumnModel().getColumn(20).setPreferredWidth(30);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(23).setMaxWidth(0);
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarDatos() {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            mCrearModeloTabla();
            if (this.JTF_Nombre.getText().isEmpty()) {
                if (this.xAplicaFiltroP == 0) {
                    if (this.JCHFiltroPorc.isSelected()) {
                        if (this.JCHFiltroProfesional.isSelected()) {
                            this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN `f_itemordenesproced`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN `f_itemordenesproced`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                        }
                    } else if (this.JCHFiltroProfesional.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac , g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN `f_itemordenesproced`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND  `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac , g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN `f_itemordenesproced`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND  `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    }
                } else if (this.JCHFiltroPorc.isSelected()) {
                    if (this.JCHFiltroProfesional.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM `f_ordenes` NNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM `f_ordenes` NNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    }
                } else if (this.JCHFiltroProfesional.isSelected()) {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM `f_ordenes` NNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                } else {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Id` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM `f_ordenes` NNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                }
            } else if (this.xAplicaFiltroP == 0) {
                if (this.JCHFiltroPorc.isSelected()) {
                    if (this.JCHFiltroProfesional.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad   FROM   `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento , f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad   FROM   `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE ((CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                    }
                } else if (this.JCHFiltroProfesional.isSelected()) {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden \t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad   FROM   `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'  AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                } else {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento, g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad    FROM   `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)   INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'  AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                }
            } else if (this.JCHFiltroPorc.isSelected()) {
                if (this.JCHFiltroProfesional.isSelected()) {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                } else {
                    this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `g_procedimiento`.`Id` ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0] + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
                }
            } else if (this.JCHFiltroProfesional.isSelected()) {
                this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (h_atencion.Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and `g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'  AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
            } else {
                this.xsql = "SELECT `ingreso`.`HoraIngreso`, `g_usuario`.`NoHistoria`, CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS  `NUsuario`,  CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,' (s)') AS `Edad` , `g_sexo`.`Nbre` AS `NSexo` ,  IF(`f_itemordenesproced`.`EsRecepcionado`=0,'POR ATENDER',IF(`f_itemordenesproced`.`EsRecepcionado`=1, 'EN ATENCIÓN', 'ATENDIDO'))  AS `NEstado` , `f_itemordenesproced`.`EsRecepcionado` AS `TEstado`, `ingreso`.`Id_Usuario` AS `Id_Usuario`, `ingreso`.`Id` AS `Id_Ingreso`, `f_ordenes`.`Id` AS Id_Orden, `h_atencion`.Id  AS IdAtencion ,`ingreso`.Id_TipoAtencion, fe.Nbre  convenio, g_persona.FechaNac, g_procedimiento.Nbre procedimiento , g_procedimiento.Id_Hc  tipoHistoria, g_procedimiento.IdClaseCita  idClaseCita, g_procedimiento.Id idProcedimiento, f_ordenes.Id  idOrden\t,ingreso.idModalidad, ingreso.idEntornoAtencion, ingreso.idTipoDiscapacidad  FROM  `f_ordenes` INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)   INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  inner join f_empresacontxconvenio fe  on (fe.Id=ingreso.Id_EmpresaContxConv)    INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN  `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)  LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (h_atencion.`Estado`=0)  \n LEFT JOIN  `h_so_concepto_laboral`  ON (`h_atencion`.`Id` = `h_so_concepto_laboral`.`Id_Atencion`) AND (h_so_concepto_laboral.`Estado`=1)  WHERE (`g_procedimiento`.`EsAgenda` =1 and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' and `ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  (CONCAT(g_persona.`Apellido1` ,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like '" + this.JTF_Nombre.getText() + "%' or `g_usuario`.`NoHistoria` like '" + this.JTF_Nombre.getText() + "%' ) and `ingreso`.`FechaIngreso` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'  AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ";
            }
            switch (this.estado) {
                case 0:
                    this.xsql += " and `f_itemordenesproced`.`EsRecepcionado`='0' ) ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
                case 1:
                    this.xsql += " and `f_itemordenesproced`.`EsRecepcionado`='1' ) ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
                case 2:
                    this.xsql += " and `f_itemordenesproced`.`EsRecepcionado`='2' ) ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
                case 3:
                    this.xsql += ") ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    break;
            }
            System.out.println("--> " + this.xsql);
            try {
                ResultSet rs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 2);
                    this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 12);
                    this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 16);
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(rs.getString("HoraIngreso"), this.JTBDatosAgenda.getRowCount() - 1, 0);
                            this.xmodelo.setValueAt(rs.getString("NoHistoria"), this.JTBDatosAgenda.getRowCount() - 1, 1);
                            this.xmodelo.setValueAt(rs.getString("NUsuario"), this.JTBDatosAgenda.getRowCount() - 1, 2);
                            this.xmodelo.setValueAt(rs.getString("Edad"), this.JTBDatosAgenda.getRowCount() - 1, 3);
                            this.xmodelo.setValueAt(rs.getString("NSexo"), this.JTBDatosAgenda.getRowCount() - 1, 4);
                            this.xmodelo.setValueAt(rs.getString("NEstado"), this.JTBDatosAgenda.getRowCount() - 1, 5);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("TEstado")), this.JTBDatosAgenda.getRowCount() - 1, 6);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Usuario")), this.JTBDatosAgenda.getRowCount() - 1, 7);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Ingreso")), this.JTBDatosAgenda.getRowCount() - 1, 8);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Orden")), this.JTBDatosAgenda.getRowCount() - 1, 9);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdAtencion")), this.JTBDatosAgenda.getRowCount() - 1, 10);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_TipoAtencion")), this.JTBDatosAgenda.getRowCount() - 1, 11);
                            this.xmodelo.setValueAt(rs.getString("convenio"), this.JTBDatosAgenda.getRowCount() - 1, 12);
                            this.xmodelo.setValueAt(rs.getString("FechaNac"), this.JTBDatosAgenda.getRowCount() - 1, 15);
                            this.xmodelo.setValueAt(rs.getString("procedimiento"), this.JTBDatosAgenda.getRowCount() - 1, 16);
                            this.xmodelo.setValueAt(rs.getString("tipoHistoria"), this.JTBDatosAgenda.getRowCount() - 1, 17);
                            this.xmodelo.setValueAt(rs.getString("idClaseCita"), this.JTBDatosAgenda.getRowCount() - 1, 18);
                            this.xmodelo.setValueAt(rs.getString("idProcedimiento"), this.JTBDatosAgenda.getRowCount() - 1, 19);
                            this.xmodelo.setValueAt(rs.getString("idOrden"), this.JTBDatosAgenda.getRowCount() - 1, 20);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), this.JTBDatosAgenda.getRowCount() - 1, 21);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), this.JTBDatosAgenda.getRowCount() - 1, 22);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), this.JTBDatosAgenda.getRowCount() - 1, 23);
                            buscaarPacientes(rs.getString("NoHistoria"));
                            if (!rs.getString("NEstado").equals("ATENDIDO")) {
                                if (this.num.intValue() == 0) {
                                    this.xmodelo.setValueAt(new JButton("Llamar "), this.JTBDatosAgenda.getRowCount() - 1, 13);
                                } else {
                                    this.xmodelo.setValueAt(new JButton("Llamar " + this.num), this.JTBDatosAgenda.getRowCount() - 1, 13);
                                }
                            } else {
                                this.xmodelo.setValueAt(new JButton(rs.getString("NEstado")), this.JTBDatosAgenda.getRowCount() - 1, 13);
                            }
                            this.xmodelo.setValueAt(new JButton("Atendido"), this.JTBDatosAgenda.getRowCount() - 1, 14);
                            this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                        }
                        this.txtCantidad.setText("" + this.JTBDatosAgenda.getRowCount());
                    } else {
                        mCrearModeloTabla();
                    }
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
                    return;
                } catch (Throwable th3) {
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        mCrearModeloTabla();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v3$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            switch (table.getValueAt(row, 5).toString()) {
                case "POR ATENDER":
                    cell.setBackground(new Color(0, 0, 102));
                    cell.setForeground(Color.WHITE);
                    break;
                case "ATENDIDO":
                    cell.setBackground(new Color(103, 0, 103));
                    cell.setForeground(Color.WHITE);
                    break;
                case "EN ATENCIÓN":
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setForeground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v3$ButtonRenderer.class */
    private class ButtonRenderer implements TableCellRenderer {
        private ButtonRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }
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

    private void buscaarPacientes(String documento) {
        new ArrayList();
        this.num = 0;
        List<LlamadasEntity> list = this.llamadasService.ListarPacientes(documento, Principal.consultorio);
        if (!list.isEmpty()) {
            this.num = Integer.valueOf(list.size());
        }
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

    private void mActualizar_DAtencion() {
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()).longValue() == 0) {
            this.xsql = "update ingreso set Id_Atencion='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10) + "' Where Id='" + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
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

    private void configuracionPanel() {
        System.out.println("" + Principal.clasehistoriace.getNombreAgenda());
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

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    private void crearArbolItemsHistoria() {
        String nombreNodo;
        String nombre;
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v3$MyTreeRenderer.class */
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

    private void mNuevo() {
        this.xlleno = false;
        this.JDCFecha.setDate(this.metodos.getFechaActual());
        this.xlleno = true;
        mCargarDatos();
    }

    private void mLLenarComboProc() {
        this.xlleno1 = false;
        this.JCBProcedimiento.removeAllItems();
        if (this.xAplicaFiltroP == 0) {
            this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
        } else {
            this.xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `g_procedimiento`.Id_Hc, g_procedimiento.IdClaseCita, `h_tipohistoria`.`Expandir`  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `g_procedimxpaquete`  ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) LEFT JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `g_procedimiento`.Id_Hc) WHERE (`ingreso`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND  `g_procedimiento`.`EsAgenda` =1 AND `f_ordenes`.`Estado` =0  AND `f_ordenes`.`FechaOrden` ='" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "' AND `ingreso`.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and  g_procedimxpaquete.`Id_Especial`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
        }
        System.out.println(this.xsql);
        this.xidprocedimiento = this.xct.llenarComboyLista(this.xsql, this.xidprocedimiento, this.JCBProcedimiento, 5);
        if (this.xidprocedimiento != null) {
            if (this.xidprocedimiento.length > 0) {
                this.JCBProcedimiento.setSelectedIndex(0);
            } else {
                this.JCBProcedimiento.setSelectedIndex(-1);
            }
        }
        this.xct.cerrarConexionBd();
        mCargarDatos();
        this.xlleno1 = true;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIF_Historia_Clinica_v3$MyTreeCellRenderer.class */
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
}
