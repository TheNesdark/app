package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import Facturacion.Consolidado;
import Facturacion.Facturac;
import Facturacion.JIFAgendaTaquilla;
import Facturacion.claseFacturacion;
import General.Persona;
import Laboratorio.Agenda;
import Laboratorio.RecepcionAuto;
import Laboratorio.claseLab;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaBienestarDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.LaboratorioBienestarDAOImpl;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO;
import com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO;
import com.genoma.plus.dto.facturacion.IngresoAgil;
import com.genoma.plus.dto.integracion_simedis.LaboratoriosDTO;
import com.genoma.plus.jpa.entities.BarrioEntity;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FEstrato;
import com.genoma.plus.jpa.entities.FFacturaCapita;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FItemsOrdenProcDTO;
import com.genoma.plus.jpa.entities.FOrdenesDTO;
import com.genoma.plus.jpa.entities.GCargos;
import com.genoma.plus.jpa.entities.GCausaexterna;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEmpresacont;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GEstadocivil;
import com.genoma.plus.jpa.entities.GEtapaProceso;
import com.genoma.plus.jpa.entities.GOrigenadmision;
import com.genoma.plus.jpa.entities.GParentesco;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GPoblacionEspecial;
import com.genoma.plus.jpa.entities.GSexo;
import com.genoma.plus.jpa.entities.GSoJornada;
import com.genoma.plus.jpa.entities.GSoLateralidad;
import com.genoma.plus.jpa.entities.GTipoafiliado;
import com.genoma.plus.jpa.entities.GTipoatencion;
import com.genoma.plus.jpa.entities.GTipoedad;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.Ingreso;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.ResolucionDianDTO;
import com.genoma.plus.jpa.entities.SoTipoGrupo;
import com.genoma.plus.jpa.entities.SoTipoSegmento;
import com.genoma.plus.jpa.entities.SubgrupoEmpresaEntity;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.FItiemsOrdenProcService;
import com.genoma.plus.jpa.service.FOrdenesService;
import com.genoma.plus.jpa.service.GEmpresacontService;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.ICcDocumentocService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ISubgrupoEmpresaService;
import com.genoma.plus.jpa.service.IngresoService;
import com.genoma.plus.jpa.service.UsuarioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIF_AgendaSimedisBienestar.class */
public class JIF_AgendaSimedisBienestar extends JInternalFrame {
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTabla1;
    private String tipoNuremoAutorizacion;
    private String idOrdenInterna;
    private String observacionBs1;
    private String NumeroHcBs1;
    private AgendaTareaSimedi agendaTarea;
    private Object[] datos;
    public String[][] lisEmpresa;
    private IngresoAgil ingresoAgil;
    private GPersona persona;
    private GUsuario usuario;
    private Ingreso ingreso;
    private GEmpresacont empresaContrato;
    private IntegracionExternaBienestarDAO integracionExternaDAO;
    private ILiquidacionService xLiquidacionService;
    public Facturac frmFacturac;
    public RecepcionAuto xjifrecepcionlab;
    private int identificadorTabla;
    private DefaultTableModel modcombos;
    private String[] xidconvenio;
    private Long llaveResultado;
    public int idConvenioGenoma;
    private LiquidacionEntity liquidacionEntity;
    private FFacturaCapita facturaCapita;
    private FFacturaEvento facturaEvento;
    private List<SubgrupoEmpresaEntity> listSubgrupoEmpresa;
    private List<EmpresaContConvenioEntity> listEmpresaContConvenioEntity;
    private IResolucionFacturaElectronica resolucionDian;
    private final IResolucionDianDAO xIResolucionDianDAO;
    private final ISubgrupoEmpresaService subgrupoEmpresaService;
    private final ICcDocumentocService ccDocumentocService;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private ButtonGroup JBGFiltro_LP;
    private JComboBox<String> JCconvenio;
    private JDateChooser JDC_Fecha;
    private JPanel JPIFiltro;
    private JRadioButton JRB_Atender;
    private JRadioButton JRB_Atendidas;
    private JRadioButton JRB_Todas;
    private JScrollPane JSPDatosAgenta;
    private JScrollPane JSPDatosServicio;
    private JTable JTBDatosAgenda;
    private JTable JTBDatosServicio;
    public JTextField JTFNombre;
    private JTextField JTF_Cantidad;
    private JTabbedPane JTPDatos;
    public static claseFacturacion clasefacturacion = null;
    public static List<Object[]> listaDetalleProcedimientoValidadoConsulta = null;
    public static List<Object[]> listaDetalleProcedimientoValidadoLaboratorio = null;
    public static Boolean cancelarOperacion = false;
    public static int formaDePagoLiquidacion = 0;
    public static int medioDePagoLiquidacion = 0;
    public static double totalConsultas = 0.0d;
    public static double totalLaboratorio = 0.0d;
    public Persona frmPersona = null;
    public Consolidado frmc = null;
    private String estado = "0";
    private long ordenGenoma = 0;
    private Metodos metodos = new Metodos();
    private Metodos metodos1 = new Metodos();
    private boolean lleno = false;
    private Long idpersona = 0L;
    private Long idIngreso = 0L;
    private Long idOrden = 0L;
    private final GUsuarioService usuarioService = (GUsuarioService) Principal.contexto.getBean(GUsuarioService.class);
    private final GEmpresacontService empresacontService = (GEmpresacontService) Principal.contexto.getBean(GEmpresacontService.class);
    private final IGPersonaService xPersonaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
    private final UsuarioService xUsuarioService = (UsuarioService) Principal.contexto.getBean(UsuarioService.class);
    private final IngresoService xIngresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
    private final FOrdenesService xFOrdenesService = (FOrdenesService) Principal.contexto.getBean(FOrdenesService.class);
    private final FItiemsOrdenProcService xFItiemsOrdenProcService = (FItiemsOrdenProcService) Principal.contexto.getBean(FItiemsOrdenProcService.class);
    private boolean xlleno = false;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public String idConvenio = "";
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);

    public JIF_AgendaSimedisBienestar() {
        this.xLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        initComponents();
        nuevo();
        springStart();
        ejecutarTarea();
        this.xLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        this.subgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
        this.xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
    }

    private void springStart() {
        this.integracionExternaDAO = (IntegracionExternaBienestarDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("integracionExternaBienestarDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JBGFiltro_LP = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JRB_Atender = new JRadioButton();
        this.JRB_Atendidas = new JRadioButton();
        this.JRB_Todas = new JRadioButton();
        this.JDC_Fecha = new JDateChooser();
        this.JTF_Cantidad = new JTextField();
        this.JTPDatos = new JTabbedPane();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JSPDatosServicio = new JScrollPane();
        this.JTBDatosServicio = new JTable();
        this.JTFNombre = new JTextField();
        this.JCconvenio = new JComboBox<>();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("AgendaBienestar");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_AgendaSimedisBienestar.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendaSimedisBienestar.this.formInternalFrameClosing(evt);
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
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltro.add(this.JRB_Atender);
        this.JRB_Atender.setFont(new Font("Arial", 1, 12));
        this.JRB_Atender.setForeground(Color.blue);
        this.JRB_Atender.setSelected(true);
        this.JRB_Atender.setText("Por Atender");
        this.JRB_Atender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.3
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedisBienestar.this.JRB_AtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRB_Atendidas);
        this.JRB_Atendidas.setFont(new Font("Arial", 1, 12));
        this.JRB_Atendidas.setForeground(Color.blue);
        this.JRB_Atendidas.setText("Atendidas");
        this.JRB_Atendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedisBienestar.this.JRB_AtendidasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setForeground(Color.blue);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedisBienestar.this.JRB_TodasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Atender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Atendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Todas).addContainerGap(16, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Atender).addComponent(this.JRB_Atendidas).addComponent(this.JRB_Todas)).addContainerGap(-1, 32767)));
        this.JDC_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_Fecha.setFont(new Font("Arial", 1, 12));
        this.JDC_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_AgendaSimedisBienestar.this.JDC_FechaPropertyChange(evt);
            }
        });
        this.JTF_Cantidad.setBackground(new Color(0, 0, 102));
        this.JTF_Cantidad.setFont(new Font("Arial", 1, 14));
        this.JTF_Cantidad.setHorizontalAlignment(0);
        this.JTF_Cantidad.setText("0");
        this.JTF_Cantidad.setToolTipText("Cantidad de usuarios");
        this.JTF_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), new Color(255, 255, 255)));
        this.JTF_Cantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.JTF_Cantidad.setEnabled(false);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.7
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedisBienestar.this.JTPDatosMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setBorder((Border) null);
        this.JSPDatosAgenta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.8
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedisBienestar.this.JSPDatosAgentaMouseClicked(evt);
            }
        });
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(35);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.9
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedisBienestar.this.JTBDatosAgendaMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIF_AgendaSimedisBienestar.this.JTBDatosAgendaMouseEntered(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JTPDatos.addTab("CONSULTA EXTERNA", this.JSPDatosAgenta);
        this.JTBDatosServicio.setFont(new Font("Arial", 1, 12));
        this.JTBDatosServicio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosServicio.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.10
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedisBienestar.this.JTBDatosServicioMouseClicked(evt);
            }
        });
        this.JSPDatosServicio.setViewportView(this.JTBDatosServicio);
        this.JTPDatos.addTab("SERVICIOS", this.JSPDatosServicio);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.11
            public void keyPressed(KeyEvent evt) {
                JIF_AgendaSimedisBienestar.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCconvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCconvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.12
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedisBienestar.this.JCconvenioActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDC_Fecha, -2, 123, -2).addGap(10, 10, 10).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Cantidad, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 318, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, 32767).addComponent(this.JCconvenio, -2, 160, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 524, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCconvenio).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_Fecha, -2, 50, -2).addComponent(this.JPIFiltro, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTF_Cantidad, -2, 50, -2))))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        String Correo;
        if (evt.getClickCount() == 2) {
            if (this.JTBDatosAgenda.getSelectedColumn() == 6 && Integer.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()).intValue() != 0) {
                cargarRecepcion(Long.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()));
                dispose();
                System.err.println("entra recepcion");
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getIdentificacion().equals("891408918") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                if (this.estado.equals("1")) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                this.estadoAgenda.set(false);
                this.identificadorTabla = 1;
                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                    this.tipoNuremoAutorizacion = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString();
                    grabarGenomaAPIIndigo(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                }
                if (Principal.informacionIps.getIdentificacion().equals("891408918")) {
                    this.tipoNuremoAutorizacion = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString();
                    grabaCNT(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString());
                }
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    this.tipoNuremoAutorizacion = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8).toString();
                    this.NumeroHcBs1 = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString();
                    this.JCconvenio.setSelectedItem(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
                    try {
                        Correo = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 9).toString();
                    } catch (Exception e) {
                        Correo = "";
                    }
                    grabaBS1(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString(), this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString(), this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 7).toString(), this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString(), this.tipoNuremoAutorizacion, Correo);
                }
                if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                    this.tipoNuremoAutorizacion = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString();
                    grabaColgenes(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    return;
                }
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                this.estadoAgenda.set(false);
                System.err.println("entra factu");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString(), this.JCconvenio.getSelectedItem().toString());
                this.estadoAgenda.set(false);
                dispose();
                return;
            }
            this.estadoAgenda.set(false);
            System.err.println("entra factu");
            Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
            this.estadoAgenda.set(false);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AtenderActionPerformed(ActionEvent evt) {
        this.estado = "0";
        cargarDatos(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AtendidasActionPerformed(ActionEvent evt) {
        this.estado = "1";
        cargarDatos(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        this.estado = "0,1";
        cargarDatos(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            cargarDatos(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFNombre.getText().isEmpty()) {
            cargarDatos(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosServicioMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTBDatosServicio.getSelectedColumn() == 6 && Integer.valueOf(this.modeloTabla1.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString()).intValue() != 0) {
                cargarRecepcion(Long.valueOf(this.modeloTabla1.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString()));
                dispose();
                System.err.println("entra recepcion");
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                if (this.estado.equals("1")) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    this.estadoAgenda.set(false);
                    System.err.println("entra factu");
                    this.identificadorTabla = 2;
                    this.tipoNuremoAutorizacion = this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString();
                    grabarGenomaAPIIndigo(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                    dispose();
                }
            }
            if (Principal.informacionIps.getIdentificacion().equals("891408918")) {
                System.err.println("891408918");
                this.tipoNuremoAutorizacion = this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString();
                grabaCNT(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString());
            } else {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                    this.estadoAgenda.set(false);
                    System.err.println("entra factu");
                    Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString(), this.JCconvenio.getSelectedItem().toString());
                    this.estadoAgenda.set(false);
                    dispose();
                    return;
                }
                this.estadoAgenda.set(false);
                System.err.println("entra factu1");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                this.estadoAgenda.set(false);
                dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCconvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDatosAgentaMouseClicked(MouseEvent evt) {
    }

    private void grabarGenomaAPI(String IdOrdenGIIS) {
        this.idOrdenInterna = IdOrdenGIIS;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaGenomaAPI(this.idOrdenInterna);
        CrearIngresoGenomaAPI(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void CrearIngresoGenomaAPI(Long IdPersona) {
        int TipoAtencion;
        int origen;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.identificadorTabla == 1) {
            switch (this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString()) {
                case "CONSULTA EXTERNA":
                    TipoAtencion = 1;
                    origen = 2;
                    break;
                default:
                    TipoAtencion = 0;
                    origen = 1;
                    break;
            }
        } else {
            switch (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString()) {
                case "URGENCIA":
                    TipoAtencion = 2;
                    origen = 1;
                    break;
                case "HOSPITALIZACION":
                    TipoAtencion = 3;
                    origen = 1;
                    break;
                default:
                    TipoAtencion = 1;
                    origen = 2;
                    break;
            }
        }
        System.err.println("origen: " + origen);
        System.err.println("TipoAtencion: " + TipoAtencion);
        System.err.println("origen" + origen);
        System.err.println("TipoAtencion" + TipoAtencion);
        EmpresaContConvenioEntity idEmpresaContxConv = new EmpresaContConvenioEntity();
        idEmpresaContxConv.setId(1);
        FEstrato estrato = new FEstrato();
        estrato.setId(1);
        GOrigenadmision origenadmision = new GOrigenadmision();
        origenadmision.setId(1);
        GCausaexterna causaexterna = new GCausaexterna();
        causaexterna.setId("13");
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(353);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(5);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(1);
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(1);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.tipoNuremoAutorizacion);
        this.ingreso.setIdContrato(1);
        this.ingreso.setEstado(false);
        this.ingreso.setEsAtencion(true);
        this.ingreso.setIdNivelEstudio(13);
        this.ingreso.setNAcompanante("NO APLICA");
        this.ingreso.setIdParentesco(parentesco);
        this.ingreso.setIdOcupacion("9998");
        this.ingreso.setSOCargo("ADMINISTRACION");
        this.ingreso.setSOSupervisor("AYALA ISAZA LUIS ALFONSO");
        this.ingreso.setSoSeg("NO APLICA");
        this.ingreso.setSOJornada("NO APLICA");
        this.ingreso.setHorasTrabajadas(0);
        this.ingreso.setSOArl("ARL");
        this.ingreso.setSOGrupo("NO APLICA");
        this.ingreso.setSOLateralidad("DIESTRO");
        this.ingreso.setSOFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setSOUNegocio("NO APLICA");
        this.ingreso.setTipoEmpresa("NO APLICA");
        this.ingreso.setEgreso(false);
        this.ingreso.setEgresoH(false);
        this.ingreso.setIdAtencion(new BigInteger("0"));
        this.ingreso.setIdCondVict(0);
        this.ingreso.setNEntidad("PARTICULAR");
        this.ingreso.setIdMotivoAnulacion(1);
        this.ingreso.setIdRemoto(BigInteger.ZERO);
        this.ingreso.setNoHijos(0);
        this.ingreso.setClaseSE(0);
        this.ingreso.setObservacion("");
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private void CrearpersonaPersonaGenomaAPI(String IdOrdenColgenes) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenDinamica(IdOrdenColgenes);
        if (e != null) {
            System.err.println("si entra a cargar de interface " + e.getDocumento());
            Optional<GPersona> personaDato = this.xPersonaService.datosPersonaPorNoDocumento(e.getDocumento());
            if (personaDato.isPresent()) {
                System.err.println("Existe la persona");
                this.persona = personaDato.get();
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2(e.getNombre2());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2(e.getApellido2());
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
            } else {
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId(e.getTipoDocumento());
                GSexo sexoEntity = new GSexo();
                sexoEntity.setId(e.getIdSexo());
                GTipoedad tipoEdadEntity = new GTipoedad();
                tipoEdadEntity.setId(1);
                MunicipioDTO municipioDTO = new MunicipioDTO();
                municipioDTO.setId("76834");
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(1106);
                GEstadocivil estadoCivilEntity = new GEstadocivil();
                estadoCivilEntity.setId(2);
                this.persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                this.persona.setNoDocumento(e.getDocumento());
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2(e.getNombre2());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2(e.getApellido2());
                this.persona.setIdSexo(sexoEntity);
                this.persona.setFechaNac(Date.valueOf(e.getFechaNacimiento()));
                this.persona.setIdTipoEdad(tipoEdadEntity);
                this.persona.setEdad(Integer.valueOf(Integer.parseInt("0")));
                this.persona.setIdMunicipio(municipioDTO);
                this.persona.setIdBarrio(barrioEntity);
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
                this.persona.setMovil(e.getMovil());
                this.persona.setIdEstadoCivil(estadoCivilEntity);
                this.persona.setGrupoSangre("-");
                this.persona.setIdMunicipioNac("76834");
                this.persona.setFecha(this.metodos.getFechaActual());
                this.persona.setCorreo("");
                this.persona.setRh(false);
                this.persona.setCodigo1Sap(new Double(0.0d));
                this.persona.setIdEtnia(6);
                this.persona.setActivoSo(true);
                this.persona.setTipoPersona(false);
                this.persona.setIdPrincipal(new BigInteger("0"));
                this.persona.setNAfiliacion("0");
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
    }

    private void CrearOrdenProcedimientoGenomaAPI(Long IdOrden, String IdOrdenGIIS) {
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsDinamica(String.valueOf(IdOrdenGIIS));
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                System.err.println("lista pos 1" + listaDetalle.get(i)[0].toString());
                FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaDetalle.get(i)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[2].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).build();
                this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
            }
        }
    }

    private void grabarGenomaAPIIndigo(String IdOrdenIndigo) {
        this.idOrdenInterna = IdOrdenIndigo;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaGenomaAPI(this.idOrdenInterna);
        CrearIngresoGenomaAPIIndigo(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void CrearIngresoGenomaAPIIndigo(Long IdPersona) {
        int TipoAtencion;
        int origen;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.identificadorTabla == 1) {
            switch (this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 7).toString()) {
                case "01 - URGENCIAS ADULTO":
                case "02 - URGENCIAS PEDIATRIA":
                case "70 - OBSERVACION URGENCIAS":
                    TipoAtencion = 3;
                    origen = 1;
                    break;
                case "05 - HOSPITALIZACION TERCER PISO":
                    TipoAtencion = 11;
                    origen = 1;
                    break;
                case "06 - HOSPITALIZACION CUARTO PISO":
                    TipoAtencion = 12;
                    origen = 1;
                    break;
                case "08 - GINECOLOGIA-OBSTETRICIA HOSPITALIZACION":
                    TipoAtencion = 13;
                    origen = 1;
                    break;
                case "13 - UNIDAD DE CUIDADO INTENSIVO ADULTOS":
                    TipoAtencion = 4;
                    origen = 1;
                    break;
                case "17 - CIRUGIA":
                    TipoAtencion = 14;
                    origen = 1;
                    break;
                case "18 - LABORATORIO":
                    TipoAtencion = 10;
                    origen = 2;
                    break;
                default:
                    TipoAtencion = 1;
                    origen = 2;
                    break;
            }
        } else {
            switch (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 7).toString()) {
                case "01 - URGENCIAS ADULTO":
                case "02 - URGENCIAS PEDIATRIA":
                case "70 - OBSERVACION URGENCIAS":
                    TipoAtencion = 3;
                    origen = 1;
                    break;
                case "05 - HOSPITALIZACION TERCER PISO":
                    TipoAtencion = 11;
                    origen = 1;
                    break;
                case "06 - HOSPITALIZACION CUARTO PISO":
                    TipoAtencion = 12;
                    origen = 1;
                    break;
                case "08 - GINECOLOGIA-OBSTETRICIA HOSPITALIZACION":
                    TipoAtencion = 13;
                    origen = 1;
                    break;
                case "13 - UNIDAD DE CUIDADO INTENSIVO ADULTOS":
                    TipoAtencion = 4;
                    origen = 1;
                    break;
                case "17 - CIRUGIA":
                    TipoAtencion = 14;
                    origen = 1;
                    break;
                case "18 - LABORATORIO":
                    TipoAtencion = 10;
                    origen = 2;
                    break;
                default:
                    TipoAtencion = 1;
                    origen = 2;
                    break;
            }
        }
        System.err.println("origen" + origen);
        System.err.println("TipoAtencion" + TipoAtencion);
        EmpresaContConvenioEntity idEmpresaContxConv = new EmpresaContConvenioEntity();
        idEmpresaContxConv.setId(1);
        FEstrato estrato = new FEstrato();
        estrato.setId(1);
        GOrigenadmision origenadmision = new GOrigenadmision();
        origenadmision.setId(1);
        GCausaexterna causaexterna = new GCausaexterna();
        causaexterna.setId("13");
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(353);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(5);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(1);
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(1);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.tipoNuremoAutorizacion);
        this.ingreso.setIdContrato(1);
        this.ingreso.setEstado(false);
        this.ingreso.setEsAtencion(true);
        this.ingreso.setIdNivelEstudio(13);
        this.ingreso.setNAcompanante("NO APLICA");
        this.ingreso.setIdParentesco(parentesco);
        this.ingreso.setIdOcupacion("9998");
        this.ingreso.setSOCargo("ADMINISTRACION");
        this.ingreso.setSOSupervisor("AYALA ISAZA LUIS ALFONSO");
        this.ingreso.setSoSeg("NO APLICA");
        this.ingreso.setSOJornada("NO APLICA");
        this.ingreso.setHorasTrabajadas(0);
        this.ingreso.setSOArl("ARL");
        this.ingreso.setSOGrupo("NO APLICA");
        this.ingreso.setSOLateralidad("DIESTRO");
        this.ingreso.setSOFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setSOUNegocio("NO APLICA");
        this.ingreso.setTipoEmpresa("NO APLICA");
        this.ingreso.setEgreso(false);
        this.ingreso.setEgresoH(false);
        this.ingreso.setIdAtencion(new BigInteger("0"));
        this.ingreso.setIdCondVict(0);
        this.ingreso.setNEntidad("PARTICULAR");
        this.ingreso.setIdMotivoAnulacion(1);
        this.ingreso.setIdRemoto(BigInteger.ZERO);
        this.ingreso.setNoHijos(0);
        this.ingreso.setClaseSE(0);
        this.ingreso.setObservacion("");
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private void grabaGIIS(String IdOrdenGIIS) {
        this.idOrdenInterna = IdOrdenGIIS;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaGenomaAPI(this.idOrdenInterna);
        CrearIngreso(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void grabaCNT(String IdOrdenCNT) {
        this.idOrdenInterna = IdOrdenCNT;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaCNT(this.idOrdenInterna);
        CrearIngresoCNT(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private int RecuperarIdConvenioGenoma(String id, String Nombre) {
        int num = 0;
        String xsql = "SELECT idConvenioGenoma, nombreConvenioGenoma FROM `g_homologacion_convenio`\nINNER JOIN `f_empresacontxconvenio` ON `f_empresacontxconvenio`.`Id` = g_homologacion_convenio.idConvenioGenoma\nINNER JOIN g_empresa on g_empresa.Id = f_empresacontxconvenio.Id_EmpresaCont\n\nwhere g_empresa.Estado=1 and idConvenioBS1 ='" + id + "';";
        System.out.println(xsql);
        ResultSet rs = this.consultas.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.first();
                num = Integer.parseInt(rs.getString("idConvenioGenoma"));
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return num;
    }

    private String validarIngresoDelDia(String noDocumentoUsuario, String idHIstoriaBS1) {
        ConsultasMySQL csm = new ConsultasMySQL();
        LocalDate date_of_today = LocalDate.now();
        String Query = "    select  COUNT(ingreso.Id)\n    from baseserver.ingreso\n    INNER JOIN baseserver.g_persona ON (ingreso.Id_Usuario = g_persona.Id)\n    where g_persona.NoDocumento ='" + noDocumentoUsuario + "' and ingreso.NumeroHcBs1 ='" + idHIstoriaBS1 + "' and ingreso.FechaIngreso between '" + date_of_today + "' and  '" + date_of_today + "';";
        String valor = csm.traerDato(Query);
        csm.cerrarConexionBd();
        return valor;
    }

    private String recuperarIdIngresoDia(String noDocumento, String noAutorizacionLab, int idConvenioGenoma) {
        ConsultasMySQL csm = new ConsultasMySQL();
        LocalDate date_of_today = LocalDate.now();
        String Query = "  select  ingreso.Id as idIngreso\n    from baseserver.ingreso\n    INNER JOIN baseserver.g_persona ON (ingreso.Id_Usuario = g_persona.Id)\n    where g_persona.NoDocumento ='" + noDocumento + "' and ingreso.FechaIngreso between '" + date_of_today + "' and  '" + date_of_today + "' limit 1;";
        String idIngreso = csm.traerDato(Query);
        if (!noAutorizacionLab.equals("00000000-0000-0000-0000-000000000000")) {
            String QueryUpdateIdLabIngreso = "update ingreso set NoAutorizacion='" + noAutorizacionLab + "' where Id='" + idIngreso + "';";
            int modificacos = csm.ejecutaSQLUpdate(QueryUpdateIdLabIngreso);
            if (modificacos > 0) {
                System.out.println("Se actualizó, el ID LABORATORIO que contenia valor null");
            }
        }
        String sqlUpdateCopago = "update ingreso i set i.SiCopago ='0', Id_EmpresaContxConv='" + idConvenioGenoma + "' \nwhere i.Id ='" + idIngreso + "'";
        csm.ejecutaSQLUpdate(sqlUpdateCopago);
        csm.cerrarConexionBd();
        return idIngreso;
    }

    private void grabaBS1(String idOrdenInternas, String observacionBS1, String idConvenioBs1, String nombreConvenioBs1, String noAutorizacionLab, String Correo) {
        this.idOrdenInterna = idOrdenInternas;
        this.observacionBs1 = observacionBS1;
        System.err.println("Idorden" + this.idOrdenInterna);
        this.idConvenioGenoma = RecuperarIdConvenioGenoma(idConvenioBs1, nombreConvenioBs1);
        if (this.idConvenioGenoma > 0) {
            String docNumero = CrearpersonaPersonaBs1(this.idOrdenInterna, Correo);
            Long idIngresoExistente = 0L;
            boolean ingresoNuevo = false;
            int hayIngreso = Integer.valueOf(validarIngresoDelDia(docNumero, idOrdenInternas)).intValue();
            if (hayIngreso == 0) {
                ingresoNuevo = true;
            } else if (hayIngreso > 0) {
                ingresoNuevo = false;
            }
            if (ingresoNuevo) {
                CrearIngresoBs1(this.idpersona, this.idConvenioGenoma, nombreConvenioBs1);
            } else if (!ingresoNuevo) {
                idIngresoExistente = Long.valueOf(recuperarIdIngresoDia(docNumero, noAutorizacionLab, this.idConvenioGenoma));
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> ID INGRESO RECUPERADO >>>>>>>>>>>>>>>>>>>> " + idIngresoExistente);
            }
            if (this.ingresoAgil.getIngreso().getId() != null || !ingresoNuevo) {
                if (ingresoNuevo) {
                    CrearOrdenBs1(this.ingresoAgil.getIngreso().getId(), Boolean.valueOf(ingresoNuevo), docNumero, idConvenioBs1);
                    claseLab claselab = Principal.claselab;
                    if (claseLab.interaccionAgendas) {
                        Principal.clasefacturacion.cargarPantalla("AgendaBienestar");
                        this.estadoAgenda.set(false);
                        dispose();
                    }
                } else if (!ingresoNuevo) {
                    CrearOrdenBs1(idIngresoExistente, Boolean.valueOf(ingresoNuevo), docNumero, idConvenioBs1);
                    claseLab claselab2 = Principal.claselab;
                    if (claseLab.interaccionAgendas) {
                        Principal.clasefacturacion.cargarPantalla("AgendaBienestar");
                        this.estadoAgenda.set(false);
                        dispose();
                    }
                }
                cargarDatos(true);
                return;
            }
            System.err.println("Problema retornar id ingreso");
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Este convenio no está registrado en Genoma\nEs necesario crear la empresa para poder facturar.");
    }

    private void mLiquidacion(String idconvenio) {
    }

    private void grabaColgenes(String idOrdenInternas) {
        this.idOrdenInterna = idOrdenInternas;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaColgenes(this.idOrdenInterna);
        CrearIngresoBs1(this.idpersona, 0, "particular");
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void CrearpersonaPersona(String IdOrdenColgenes) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenGIIS(IdOrdenColgenes);
        if (e != null) {
            System.err.println("si entra a cargar de interface " + e.getDocumento());
            Optional<GPersona> personaDato = this.xPersonaService.datosPersonaPorNoDocumento(e.getDocumento());
            if (personaDato.isPresent()) {
                System.err.println("Existe la persona");
                this.persona = personaDato.get();
                this.persona.setNombre1(e.getNombre1());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
            } else {
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId(e.getTipoDocumento());
                GSexo sexoEntity = new GSexo();
                sexoEntity.setId(e.getIdSexo());
                GTipoedad tipoEdadEntity = new GTipoedad();
                tipoEdadEntity.setId(1);
                MunicipioDTO municipioDTO = new MunicipioDTO();
                municipioDTO.setId("76834");
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(1106);
                GEstadocivil estadoCivilEntity = new GEstadocivil();
                estadoCivilEntity.setId(2);
                this.persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                this.persona.setNoDocumento(e.getDocumento());
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2("");
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2("");
                this.persona.setIdSexo(sexoEntity);
                this.persona.setFechaNac(Date.valueOf(e.getFechaNacimiento()));
                this.persona.setIdTipoEdad(tipoEdadEntity);
                this.persona.setEdad(Integer.valueOf(Integer.parseInt("0")));
                this.persona.setIdMunicipio(municipioDTO);
                this.persona.setIdBarrio(barrioEntity);
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
                this.persona.setMovil(e.getMovil());
                this.persona.setIdEstadoCivil(estadoCivilEntity);
                this.persona.setGrupoSangre("-");
                this.persona.setIdMunicipioNac("76834");
                this.persona.setFecha(this.metodos.getFechaActual());
                this.persona.setCorreo("");
                this.persona.setRh(false);
                this.persona.setCodigo1Sap(new Double(1.0d));
                this.persona.setIdEtnia(6);
                this.persona.setActivoSo(true);
                this.persona.setTipoPersona(false);
                this.persona.setIdPrincipal(new BigInteger("0"));
                this.persona.setNAfiliacion("0");
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
    }

    private void CrearpersonaPersonaCNT(String IdOrdenCNT) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenCNT(IdOrdenCNT);
        if (e != null) {
            System.err.println("si entra a cargar de interface " + e.getDocumento());
            Optional<GPersona> personaDato = this.xPersonaService.datosPersonaPorNoDocumento(e.getDocumento());
            if (personaDato.isPresent()) {
                System.err.println("Existe la persona");
                this.persona = personaDato.get();
                this.persona.setNombre1(e.getNombre1());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
            } else {
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId(e.getTipoDocumento());
                GSexo sexoEntity = new GSexo();
                sexoEntity.setId(e.getIdSexo());
                GTipoedad tipoEdadEntity = new GTipoedad();
                tipoEdadEntity.setId(1);
                MunicipioDTO municipioDTO = new MunicipioDTO();
                municipioDTO.setId("66088");
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(900);
                GEstadocivil estadoCivilEntity = new GEstadocivil();
                estadoCivilEntity.setId(2);
                System.err.println("Fecha " + e.getFechaNacimiento());
                System.err.println("Tipo Documento LAB " + e.getTipoDocumento());
                System.err.println("Tipo Documento " + tipoIdentificacionDTO.getId());
                this.persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                this.persona.setNoDocumento(e.getDocumento());
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2(e.getNombre2());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2(e.getApellido2());
                this.persona.setIdSexo(sexoEntity);
                this.persona.setFechaNac(Date.valueOf(e.getFechaNacimiento()));
                this.persona.setIdTipoEdad(tipoEdadEntity);
                this.persona.setEdad(Integer.valueOf(Integer.parseInt(e.getEdad())));
                this.persona.setIdMunicipio(municipioDTO);
                this.persona.setIdBarrio(barrioEntity);
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
                this.persona.setMovil(e.getMovil());
                this.persona.setIdEstadoCivil(estadoCivilEntity);
                this.persona.setGrupoSangre("-");
                this.persona.setIdMunicipioNac("66088");
                this.persona.setFecha(this.metodos.getFechaActual());
                this.persona.setCorreo("");
                this.persona.setRh(false);
                this.persona.setCodigo1Sap(new Double(1.0d));
                this.persona.setIdEtnia(6);
                this.persona.setActivoSo(true);
                this.persona.setTipoPersona(false);
                this.persona.setIdPrincipal(new BigInteger("0"));
                this.persona.setNAfiliacion("0");
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
    }

    private void CrearpersonaPersonaColgenes(String IdOrdenBs1) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenColgenes(IdOrdenBs1);
        if (e != null) {
            System.err.println("si entra a cargar de interface " + e.getDocumento());
            Optional<GPersona> personaDato = this.xPersonaService.datosPersonaPorNoDocumento(e.getDocumento());
            if (personaDato.isPresent()) {
                System.err.println("Existe la persona");
                this.persona = personaDato.get();
                this.persona.setNombre1(e.getNombre1());
                this.persona.setApellido1(e.getApellido1());
            } else {
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId(e.getTipoDocumento());
                GSexo sexoEntity = new GSexo();
                sexoEntity.setId(e.getIdSexo());
                GTipoedad tipoEdadEntity = new GTipoedad();
                tipoEdadEntity.setId(1);
                MunicipioDTO municipioDTO = new MunicipioDTO();
                municipioDTO.setId("05001");
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(907);
                GEstadocivil estadoCivilEntity = new GEstadocivil();
                estadoCivilEntity.setId(2);
                System.err.println("Fecha " + e.getFechaNacimiento());
                this.persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                this.persona.setNoDocumento(e.getDocumento());
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2(e.getNombre2());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2(e.getApellido2());
                this.persona.setIdSexo(sexoEntity);
                this.persona.setFechaNac(Date.valueOf(e.getFechaNacimiento()));
                this.persona.setIdTipoEdad(tipoEdadEntity);
                this.persona.setEdad(0);
                this.persona.setIdMunicipio(municipioDTO);
                this.persona.setIdBarrio(barrioEntity);
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
                this.persona.setMovil(e.getMovil());
                this.persona.setIdEstadoCivil(estadoCivilEntity);
                this.persona.setGrupoSangre("-");
                this.persona.setIdMunicipioNac("05001");
                this.persona.setFecha(this.metodos.getFechaActual());
                this.persona.setCorreo("");
                this.persona.setRh(false);
                this.persona.setCodigo1Sap(new Double(1.0d));
                this.persona.setIdEtnia(6);
                this.persona.setActivoSo(true);
                this.persona.setTipoPersona(false);
                this.persona.setIdPrincipal(new BigInteger("0"));
                this.persona.setNAfiliacion("0");
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
    }

    private void ActualizarCorreoPersona(String idPersona, String Correo) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Query = "update g_persona set Correo = '" + Correo + "' \nwhere Id = '" + idPersona + "';";
        int actualizado = csm.ejecutaSQLUpdate(Query);
        if (actualizado > 0) {
            System.out.println("SE ACTUALIZO EL CORREO ");
        }
        csm.cerrarConexionBd();
    }

    private String CrearpersonaPersonaBs1(String IdOrdenBs1, String Correo) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenBs1(IdOrdenBs1);
        if (e != null) {
            System.err.println("si entra a cargar de interface " + e.getDocumento());
            Optional<GPersona> personaDato = this.xPersonaService.datosPersonaPorNoDocumento(e.getDocumento());
            if (personaDato.isPresent()) {
                System.err.println("Existe la persona");
                this.persona = personaDato.get();
                this.persona.setNombre1(e.getNombre1());
                this.persona.setApellido1(e.getApellido1());
                if (!Correo.equals("")) {
                    ActualizarCorreoPersona(String.valueOf(this.persona.getId()), Correo);
                }
            } else {
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId(e.getTipoDocumento());
                GSexo sexoEntity = new GSexo();
                sexoEntity.setId(e.getIdSexo());
                GTipoedad tipoEdadEntity = new GTipoedad();
                tipoEdadEntity.setId(1);
                MunicipioDTO municipioDTO = new MunicipioDTO();
                municipioDTO.setId("66001");
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(907);
                GEstadocivil estadoCivilEntity = new GEstadocivil();
                estadoCivilEntity.setId(2);
                System.err.println("Fecha " + e.getFechaNacimiento());
                this.persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                this.persona.setNoDocumento(e.getDocumento());
                this.persona.setNombre1(e.getNombre1());
                this.persona.setNombre2(e.getNombre2());
                this.persona.setApellido1(e.getApellido1());
                this.persona.setApellido2(e.getApellido2());
                this.persona.setIdSexo(sexoEntity);
                this.persona.setFechaNac(Date.valueOf(e.getFechaNacimiento()));
                this.persona.setIdTipoEdad(tipoEdadEntity);
                this.persona.setEdad(Integer.valueOf(Integer.parseInt(e.getEdad())));
                this.persona.setIdMunicipio(municipioDTO);
                this.persona.setIdBarrio(barrioEntity);
                this.persona.setDireccion(e.getDireccion());
                this.persona.setTelefono(e.getMovil());
                this.persona.setMovil(e.getMovil());
                this.persona.setIdEstadoCivil(estadoCivilEntity);
                this.persona.setGrupoSangre("-");
                this.persona.setIdMunicipioNac("76834");
                this.persona.setFecha(this.metodos.getFechaActual());
                this.persona.setCorreo("");
                this.persona.setRh(false);
                this.persona.setCodigo1Sap(new Double(1.0d));
                this.persona.setIdEtnia(6);
                this.persona.setActivoSo(true);
                this.persona.setTipoPersona(false);
                this.persona.setIdPrincipal(new BigInteger("0"));
                this.persona.setNAfiliacion("0");
                this.persona.setCorreo(Correo);
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
        return e.getDocumento();
    }

    private void CrearUsuario() {
        this.usuario = new GUsuario();
        if (this.persona.getId() != null) {
            Optional<GUsuario> usuarioDato = this.usuarioService.findByIdPersona(this.persona);
            if (usuarioDato.isPresent()) {
                System.err.println("Existe El Usuario");
                this.usuario = usuarioDato.get();
            } else {
                llenarUsuario();
            }
        } else {
            llenarUsuario();
        }
        this.ingresoAgil.setUsuario(this.usuario);
    }

    private void llenarUsuario() {
        GTipoafiliado gTipoAfiliado = new GTipoafiliado();
        gTipoAfiliado.setId(6);
        GEmpresacont empresacont = new GEmpresacont();
        empresacont.setId(1);
        GCargos cargo = new GCargos();
        cargo.setId(2);
        SoTipoSegmento tipoSegmento = new SoTipoSegmento();
        tipoSegmento.setId(1);
        SoTipoGrupo tipoGrupo = new SoTipoGrupo();
        tipoGrupo.setId(1);
        GEmpresa empresa = new GEmpresa();
        empresa.setId(new Long(1L));
        GSoLateralidad soLateralidad = new GSoLateralidad();
        soLateralidad.setId(1);
        GSoJornada soJornada = new GSoJornada();
        soJornada.setId(1);
        GPoblacionEspecial gPoblacionEspecial = new GPoblacionEspecial();
        gPoblacionEspecial.setId(99);
        Optional<GEmpresacont> empreOptional = this.empresacontService.findByIdempresa(empresa);
        if (empreOptional.isPresent()) {
            this.empresaContrato = empreOptional.get();
        }
        this.ingresoAgil.setUsuario(this.usuario);
        this.usuario.setGPersona(this.persona);
        this.usuario.setNoHistoria(this.persona.getNoDocumento());
        this.usuario.setIdOcupacion("6");
        this.usuario.setIdTipoAfiliado(gTipoAfiliado);
        this.usuario.setEstado(false);
        this.usuario.setDetalleAnulacion((String) null);
        this.usuario.setIdEmpresaCont(this.empresaContrato);
        this.usuario.setEsFpz(false);
        this.usuario.setFechaDA((java.util.Date) null);
        this.usuario.setNAfiliacion("0");
        this.usuario.setIdCargo(cargo);
        this.usuario.setIdSupervisor(1L);
        this.usuario.setIdSegmento(tipoSegmento);
        this.usuario.setIdTipoGrupo(tipoGrupo);
        this.usuario.setIdArl(empresa);
        this.usuario.setIdLateralidad(soLateralidad);
        this.usuario.setIdHorario(soJornada);
        this.usuario.setHorasTrabajadas(0);
        this.usuario.setNHijo(0);
        this.usuario.setCSEconomica(0);
        this.usuario.setFechaIngreso(this.metodos.getFechaActual());
        this.usuario.setEtnia("Otras etnias ND No definido ");
        this.usuario.setIdPoblacionEspecial(gPoblacionEspecial);
        this.usuario.setNEducativo((String) null);
        this.usuario.setOcupacion((String) null);
        this.usuario.setEmail(this.persona.getCorreo());
        this.usuario.setFecha(this.metodos.getFechaActual());
        this.usuario.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
    }

    private void CrearIngreso(Long IdPersona) {
        int origen;
        int TipoAtencion;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.identificadorTabla == 1) {
            System.err.println("TipoAtencion " + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
            if (Integer.parseInt(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString()) == 4289 || Integer.parseInt(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString()) == 4481) {
                origen = 2;
            } else {
                origen = 1;
            }
            switch (this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString()) {
                case "010301":
                    TipoAtencion = 1;
                    break;
                case "010101":
                    TipoAtencion = 2;
                    break;
                case "010201":
                    TipoAtencion = 3;
                    break;
                case "010405":
                    TipoAtencion = 4;
                    break;
                case "010404":
                    TipoAtencion = 5;
                    break;
                case "010406":
                    TipoAtencion = 6;
                    break;
                case "010410":
                    TipoAtencion = 7;
                    break;
                case "010604":
                    TipoAtencion = 9;
                    break;
                case "010601":
                    TipoAtencion = 10;
                    break;
                case "010401":
                    TipoAtencion = 11;
                    break;
                case "010402":
                    TipoAtencion = 12;
                    break;
                case "010403":
                    TipoAtencion = 13;
                    break;
                case "010501":
                    TipoAtencion = 14;
                    break;
                default:
                    TipoAtencion = 8;
                    break;
            }
        } else {
            System.err.println("TipoAtencion " + this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 2).toString());
            if (Integer.parseInt(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 2).toString()) == 4289 || Integer.parseInt(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 2).toString()) == 4481) {
                origen = 2;
            } else {
                origen = 1;
            }
            switch (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 2).toString()) {
                case "010301":
                    TipoAtencion = 1;
                    break;
                case "010101":
                    TipoAtencion = 2;
                    break;
                case "010201":
                    TipoAtencion = 3;
                    break;
                case "010405":
                    TipoAtencion = 4;
                    break;
                case "010404":
                    TipoAtencion = 5;
                    break;
                case "010406":
                    TipoAtencion = 6;
                    break;
                case "010410":
                    TipoAtencion = 7;
                    break;
                case "010604":
                    TipoAtencion = 9;
                    break;
                case "010601":
                    TipoAtencion = 10;
                    break;
                case "010401":
                    TipoAtencion = 11;
                    break;
                case "010402":
                    TipoAtencion = 12;
                    break;
                case "010403":
                    TipoAtencion = 13;
                    break;
                case "010501":
                    TipoAtencion = 14;
                    break;
                default:
                    TipoAtencion = 8;
                    break;
            }
        }
        System.err.println("origen" + origen);
        System.err.println("TipoAtencion" + TipoAtencion);
        EmpresaContConvenioEntity idEmpresaContxConv = new EmpresaContConvenioEntity();
        idEmpresaContxConv.setId(1);
        FEstrato estrato = new FEstrato();
        estrato.setId(1);
        GOrigenadmision origenadmision = new GOrigenadmision();
        origenadmision.setId(1);
        GCausaexterna causaexterna = new GCausaexterna();
        causaexterna.setId("13");
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(353);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(5);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(1);
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(1);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.tipoNuremoAutorizacion);
        this.ingreso.setIdContrato(1);
        this.ingreso.setEstado(false);
        this.ingreso.setEsAtencion(true);
        this.ingreso.setIdNivelEstudio(13);
        this.ingreso.setNAcompanante("NO APLICA");
        this.ingreso.setIdParentesco(parentesco);
        this.ingreso.setIdOcupacion("9998");
        this.ingreso.setSOCargo("ADMINISTRACION");
        this.ingreso.setSOSupervisor(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.ingreso.setSoSeg("NO APLICA");
        this.ingreso.setSOJornada("NO APLICA");
        this.ingreso.setHorasTrabajadas(0);
        this.ingreso.setSOArl("ARL");
        this.ingreso.setSOGrupo("NO APLICA");
        this.ingreso.setSOLateralidad("DIESTRO");
        this.ingreso.setSOFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setSOUNegocio("NO APLICA");
        this.ingreso.setTipoEmpresa("NO APLICA");
        this.ingreso.setEgreso(false);
        this.ingreso.setEgresoH(false);
        this.ingreso.setIdAtencion(new BigInteger("0"));
        this.ingreso.setIdCondVict(0);
        this.ingreso.setNEntidad("PARTICULAR");
        this.ingreso.setIdMotivoAnulacion(1);
        this.ingreso.setIdRemoto(BigInteger.ZERO);
        this.ingreso.setNoHijos(0);
        this.ingreso.setClaseSE(0);
        this.ingreso.setObservacion("");
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private void CrearIngresoCNT(Long IdPersona) {
        int origen;
        int TipoAtencion;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.identificadorTabla == 1) {
            System.err.println("TipoAtencion " + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
            if ("AMBULATORIO".equals(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString())) {
                origen = 2;
            } else {
                origen = 1;
            }
            switch (this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString()) {
                case "AMBULATORIO":
                    TipoAtencion = 1;
                    break;
                default:
                    TipoAtencion = 0;
                    break;
            }
        } else {
            System.err.println("TipoAtencion " + this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString());
            if ("AMBULATORIO".equals(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString())) {
                origen = 2;
            } else {
                origen = 1;
            }
            switch (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString()) {
                case "URGENCIA":
                    TipoAtencion = 2;
                    break;
                case "HOSPITALIZACION":
                    TipoAtencion = 3;
                    break;
                default:
                    TipoAtencion = 1;
                    break;
            }
        }
        System.err.println("origen" + origen);
        System.err.println("TipoAtencion" + TipoAtencion);
        EmpresaContConvenioEntity idEmpresaContxConv = new EmpresaContConvenioEntity();
        idEmpresaContxConv.setId(1);
        FEstrato estrato = new FEstrato();
        estrato.setId(1);
        GOrigenadmision origenadmision = new GOrigenadmision();
        origenadmision.setId(1);
        GCausaexterna causaexterna = new GCausaexterna();
        causaexterna.setId("13");
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(353);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(5);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(1);
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(1);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.tipoNuremoAutorizacion);
        this.ingreso.setIdContrato(1);
        this.ingreso.setEstado(false);
        this.ingreso.setEsAtencion(true);
        this.ingreso.setIdNivelEstudio(13);
        this.ingreso.setNAcompanante("NO APLICA");
        this.ingreso.setIdParentesco(parentesco);
        this.ingreso.setIdOcupacion("9998");
        this.ingreso.setSOCargo("ADMINISTRACION");
        this.ingreso.setSOSupervisor("AYALA ISAZA LUIS ALFONSO");
        this.ingreso.setSoSeg("NO APLICA");
        this.ingreso.setSOJornada("NO APLICA");
        this.ingreso.setHorasTrabajadas(0);
        this.ingreso.setSOArl("ARL");
        this.ingreso.setSOGrupo("NO APLICA");
        this.ingreso.setSOLateralidad("DIESTRO");
        this.ingreso.setSOFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setSOUNegocio("NO APLICA");
        this.ingreso.setTipoEmpresa("NO APLICA");
        this.ingreso.setEgreso(false);
        this.ingreso.setEgresoH(false);
        this.ingreso.setIdAtencion(new BigInteger("0"));
        this.ingreso.setIdCondVict(0);
        this.ingreso.setNEntidad("PARTICULAR");
        this.ingreso.setIdMotivoAnulacion(1);
        this.ingreso.setIdRemoto(BigInteger.ZERO);
        this.ingreso.setNoHijos(0);
        this.ingreso.setClaseSE(0);
        this.ingreso.setObservacion("");
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private void CrearIngresoBs1(Long IdPersona, int IdConvenio, String nombreEntidad) {
        EmpresaContConvenioEntity idEmpresaContxConv = new EmpresaContConvenioEntity();
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            idEmpresaContxConv.setId(Integer.valueOf(IdConvenio));
        } else {
            idEmpresaContxConv.setId(1);
        }
        FEstrato estrato = new FEstrato();
        estrato.setId(1);
        GOrigenadmision origenadmision = new GOrigenadmision();
        origenadmision.setId(1);
        GCausaexterna causaexterna = new GCausaexterna();
        causaexterna.setId("13");
        GEspecialidad especialidad = new GEspecialidad();
        especialidad.setId(1012);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(1);
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(5);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(0);
        this.ingreso.setIdSede(1);
        this.ingreso.setSiCopago(false);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(8);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("Z100");
        this.ingreso.setNoAutorizacion(this.tipoNuremoAutorizacion);
        this.ingreso.setIdContrato(1);
        this.ingreso.setEstado(false);
        this.ingreso.setEsAtencion(true);
        this.ingreso.setIdNivelEstudio(13);
        this.ingreso.setNAcompanante("NO APLICA");
        this.ingreso.setIdParentesco(parentesco);
        this.ingreso.setIdOcupacion("9998");
        this.ingreso.setSOCargo("ADMINISTRACION");
        this.ingreso.setSOSupervisor("AYALA ISAZA LUIS ALFONSO");
        this.ingreso.setSoSeg("NO APLICA");
        this.ingreso.setSOJornada("NO APLICA");
        this.ingreso.setHorasTrabajadas(0);
        this.ingreso.setSOArl("ARL");
        this.ingreso.setSOGrupo("NO APLICA");
        this.ingreso.setSOLateralidad("DIESTRO");
        this.ingreso.setSOFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setSOUNegocio("NO APLICA");
        this.ingreso.setTipoEmpresa("NO APLICA");
        this.ingreso.setEgreso(false);
        this.ingreso.setEgresoH(false);
        this.ingreso.setIdAtencion(BigInteger.ZERO);
        this.ingreso.setIdCondVict(0);
        this.ingreso.setNEntidad(nombreEntidad);
        this.ingreso.setIdMotivoAnulacion(1);
        this.ingreso.setIdRemoto(BigInteger.ZERO);
        this.ingreso.setNoHijos(0);
        this.ingreso.setClaseSE(0);
        this.ingreso.setObservacion("");
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingreso.setNumeroHcBs1(this.NumeroHcBs1);
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private int esCapitadoBS1(int idConvenio) {
        ResultSet rs;
        Throwable th;
        int esCapitado = 0;
        String Query = "SELECT fe.`EsCapitado` FROM `f_empresacontxconvenio` fe\nWHERE fe.`Id` = '" + idConvenio + "'";
        ConsultasMySQL Cs = new ConsultasMySQL();
        System.out.println("CONSULTA esCapitadoBS1 : " + Query);
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    esCapitado = rs.getInt("EsCapitado");
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
                Cs.cerrarConexionBd();
                return esCapitado;
            } finally {
            }
        } finally {
        }
    }

    private int tipoPlanConvenioBS1(int idConvenio) {
        int idTipoPlan = 0;
        String Query = "SELECT fe.`Id_TipoPlan` FROM `f_empresacontxconvenio` fe\nWHERE fe.`Id` = '" + idConvenio + "'";
        ConsultasMySQL Cs = new ConsultasMySQL();
        System.out.println("CONSULTA tipoPlanConvenioBS1 : " + Query);
        try {
            ResultSet rs = Cs.traerRs(Query);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        System.out.println("RS TIPO PLAN >>>>> " + rs.getString("Id_TipoPlan"));
                        idTipoPlan = Integer.valueOf(rs.getString("Id_TipoPlan")).intValue();
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        Cs.cerrarConexionBd();
        return idTipoPlan;
    }

    private String RecuperarIdOrdenIngresoCreadoDeBS1(String noDocumento, String tipoServicio) {
        ConsultasMySQL csm = new ConsultasMySQL();
        LocalDate date_of_today = LocalDate.now();
        String Query = "select   f_ordenes.Id as 'idOrden',f_ordenes.Id_TipoServicio, ingreso.Id as 'idIngreso',f_ordenes.FechaOrden\nfrom baseserver.ingreso\nINNER JOIN baseserver.g_persona ON (ingreso.Id_Usuario = g_persona.Id)\nINNER JOIN baseserver.g_usuario ON (g_usuario.Id_persona = g_persona.Id)\nINNER JOIN baseserver.f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)\nwhere g_persona.NoDocumento ='" + noDocumento + "' and ingreso.FechaIngreso between '" + date_of_today + "' and  '" + date_of_today + "' and f_ordenes.Id_TipoServicio ='" + tipoServicio + "' ;";
        String id = csm.traerDato(Query);
        csm.cerrarConexionBd();
        return id;
    }

    private void ActualizarTotalOrdenes(String idTipoServicio, String idOrden, String totalOrden) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Sql = "update f_ordenes set TotalOrdenes ='" + totalOrden + "', TotalEPS ='" + totalOrden + "'\nwhere Id_TipoServicio ='" + idTipoServicio + "' and Id ='" + idOrden + "'";
        int actualizada = csm.ejecutaSQLUpdate(Sql);
        if (actualizada > 0) {
            System.out.println("Se actualizo el total de la orden a: " + totalOrden);
        }
    }

    private void CrearOrdenBs1(Long IdIngreso, Boolean ingresoNuevo, String noDocumentoUsuario, String idConvenioBS1) {
        if (IdIngreso != null) {
            List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsBS1(this.idOrdenInterna);
            if (!listaDetalle.isEmpty()) {
                System.out.println("INGRESO ORDEN BS1");
                List<Object[]> Encabezado = this.integracionExternaDAO.listadoProcedimientoEncabezadoBS1(this.idOrdenInterna, this.idConvenioGenoma);
                if (!Encabezado.isEmpty()) {
                    double subtTotal = 0.0d;
                    for (int i = 0; i < Encabezado.size(); i++) {
                        if (ingresoNuevo.booleanValue()) {
                            FOrdenesDTO xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(IdIngreso).id_TipoServicio(Integer.valueOf(Integer.parseInt(Encabezado.get(i)[0].toString()))).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf("1")).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble(Encabezado.get(i)[2].toString()))).totalEPS(Double.valueOf(Double.parseDouble(Encabezado.get(i)[2].toString()))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
                            this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO);
                            System.err.println("idOrden " + this.idOrden);
                            System.err.println("idOrdenInternaDeBS1 " + this.idOrdenInterna);
                            List<Object[]> listaDetalleProcedimiento = this.integracionExternaDAO.listadoProcedimientosBS1(this.idConvenioGenoma, this.idOrdenInterna, Encabezado.get(i)[0].toString());
                            if (!listaDetalleProcedimiento.isEmpty()) {
                                claseLab claselab = Principal.claselab;
                                if (!claseLab.interaccionAgendas) {
                                    DetalleItemsOrden detallesItemsOrden = new DetalleItemsOrden(null, true, listaDetalleProcedimiento);
                                    detallesItemsOrden.setLocationRelativeTo(null);
                                    detallesItemsOrden.setVisible(true);
                                }
                                if (!cancelarOperacion.booleanValue()) {
                                    claseLab claselab2 = Principal.claselab;
                                    if (!claseLab.interaccionAgendas) {
                                        int tipoServicioValidado = Integer.valueOf(Encabezado.get(i)[0].toString()).intValue();
                                        if (tipoServicioValidado == 1) {
                                            listaDetalleProcedimiento = listaDetalleProcedimientoValidadoConsulta;
                                            ActualizarTotalOrdenes(String.valueOf(tipoServicioValidado), String.valueOf(this.idOrden), String.valueOf(totalConsultas));
                                        } else if (tipoServicioValidado == 2) {
                                            listaDetalleProcedimiento = listaDetalleProcedimientoValidadoLaboratorio;
                                            ActualizarTotalOrdenes(String.valueOf(tipoServicioValidado), String.valueOf(this.idOrden), String.valueOf(totalLaboratorio));
                                        }
                                    }
                                    for (int k = 0; k < listaDetalleProcedimiento.size(); k++) {
                                        mCrearItemsOrdeneBs1(this.idOrden, listaDetalleProcedimiento.get(k)[1].toString(), listaDetalleProcedimiento.get(k)[5].toString(), listaDetalleProcedimiento.get(k)[7].toString(), listaDetalleProcedimiento.get(k)[3].toString(), listaDetalleProcedimiento.get(k)[8].toString());
                                        subtTotal += Double.valueOf(listaDetalleProcedimiento.get(k)[3].toString()).doubleValue();
                                        try {
                                            System.err.println("PCli_ID" + listaDetalleProcedimiento.get(i)[8].toString());
                                        } catch (Exception e) {
                                            System.err.println("Ocurrio un error al escribir en consola.");
                                        }
                                    }
                                    System.out.println("SUTOTAL : " + subtTotal);
                                }
                            }
                        } else if (!ingresoNuevo.booleanValue()) {
                            if (RecuperarIdOrdenIngresoCreadoDeBS1(noDocumentoUsuario, Encabezado.get(i)[0].toString()).equals("")) {
                                FOrdenesDTO xFOrdenesDTO2 = FOrdenesDTO.builder().id_Ingreso(IdIngreso).id_TipoServicio(Integer.valueOf(Integer.parseInt(Encabezado.get(i)[0].toString()))).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf("1")).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble(Encabezado.get(i)[2].toString()))).totalEPS(Double.valueOf(Double.parseDouble(Encabezado.get(i)[2].toString()))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
                                this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO2);
                                System.err.println("idOrden " + this.idOrden);
                                System.err.println("idOrdenInternaDeBS1 " + this.idOrdenInterna);
                            }
                            this.idOrden = Long.valueOf(RecuperarIdOrdenIngresoCreadoDeBS1(noDocumentoUsuario, Encabezado.get(i)[0].toString()));
                            ActualizarTotalOrdenes(String.valueOf(Integer.parseInt(Encabezado.get(i)[0].toString())), String.valueOf(this.idOrden), String.valueOf(Double.parseDouble(Encabezado.get(i)[2].toString())));
                            System.err.println("idOrden " + this.idOrden);
                            System.err.println("idOrdenInternaDeBS1 " + this.idOrdenInterna);
                            List<Object[]> listaDetalleProcedimiento2 = this.integracionExternaDAO.listadoProcedimientosBS1(this.idConvenioGenoma, this.idOrdenInterna, Encabezado.get(i)[0].toString());
                            if (!listaDetalleProcedimiento2.isEmpty()) {
                                claseLab claselab3 = Principal.claselab;
                                if (!claseLab.interaccionAgendas) {
                                    DetalleItemsOrden detallesItemsOrden2 = new DetalleItemsOrden(null, true, listaDetalleProcedimiento2);
                                    detallesItemsOrden2.setLocationRelativeTo(null);
                                    detallesItemsOrden2.setVisible(true);
                                }
                                if (!cancelarOperacion.booleanValue()) {
                                    claseLab claselab4 = Principal.claselab;
                                    if (!claseLab.interaccionAgendas) {
                                        int tipoServicioValidado2 = Integer.valueOf(Encabezado.get(i)[0].toString()).intValue();
                                        if (tipoServicioValidado2 == 1) {
                                            listaDetalleProcedimiento2 = listaDetalleProcedimientoValidadoConsulta;
                                            ActualizarTotalOrdenes(String.valueOf(tipoServicioValidado2), String.valueOf(this.idOrden), String.valueOf(totalConsultas));
                                        } else if (tipoServicioValidado2 == 2) {
                                            listaDetalleProcedimiento2 = listaDetalleProcedimientoValidadoLaboratorio;
                                            ActualizarTotalOrdenes(String.valueOf(tipoServicioValidado2), String.valueOf(this.idOrden), String.valueOf(totalLaboratorio));
                                        }
                                    }
                                    for (int k2 = 0; k2 < listaDetalleProcedimiento2.size(); k2++) {
                                        mCrearItemsOrdeneBs1(this.idOrden, listaDetalleProcedimiento2.get(k2)[1].toString(), listaDetalleProcedimiento2.get(k2)[5].toString(), listaDetalleProcedimiento2.get(k2)[7].toString(), listaDetalleProcedimiento2.get(k2)[3].toString(), listaDetalleProcedimiento2.get(k2)[8].toString());
                                        try {
                                            System.err.println("PCli_ID" + listaDetalleProcedimiento2.get(i)[8].toString());
                                        } catch (Exception e2) {
                                            System.err.println("Ocurrio un error al escribir en consola.");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("PASO POR AQUI A LLENAR LIQUIDACION");
                    try {
                        subtTotal = Double.valueOf(CalcularLiquidacionOrdenBs1(String.valueOf(IdIngreso))).doubleValue();
                    } catch (Exception e3) {
                    }
                    if (!cancelarOperacion.booleanValue()) {
                        claseLab claselab5 = Principal.claselab;
                        if (!claseLab.interaccionAgendas) {
                            TipoDePago tipoDePago = new TipoDePago(null, true);
                            tipoDePago.setLocationRelativeTo(null);
                            tipoDePago.setVisible(true);
                            mLlenarLiquidacion(Double.valueOf(subtTotal), IdIngreso.longValue(), ingresoNuevo, formaDePagoLiquidacion, medioDePagoLiquidacion);
                            this.integracionExternaDAO.actualizarHistoriaBS1(this.idOrdenInterna);
                        } else {
                            System.out.println("NO SE GENERÓ LIQUIDACION POR NO ESTAR EN MODO FACTURACION -- INTERACCION DE AGENDAS ");
                        }
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No se lograron crear encabezados para este ingreso", "Verificar", 1);
                }
            }
        }
        listaDetalleProcedimientoValidadoLaboratorio = null;
        listaDetalleProcedimientoValidadoConsulta = null;
        totalConsultas = 0.0d;
        totalLaboratorio = 0.0d;
        cancelarOperacion = false;
    }

    private int RecuperarFormaPagoBS1(String idEmpresa) {
        ConsultasSqlServer csq = new ConsultasSqlServer();
        String sql = "select zFPag_ID as fPago from Empresa where Empr_ID='" + idEmpresa + "'";
        int fPago = Integer.valueOf(csq.traerDato(sql)).intValue();
        return fPago;
    }

    private String CalcularLiquidacionOrdenBs1(String idIngreso) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Query = "select sum(fo.TotalOrdenes) as total  from f_ordenes fo \nwhere fo.Id_Ingreso ='" + idIngreso + "'";
        String resultado = csm.traerDato(Query);
        return resultado;
    }

    private void llenarComboDependeciaConvenio() {
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

    private int AnularLiquidacion(String idIngreso) {
        ConsultasMySQL csm = new ConsultasMySQL();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String Query = "update f_liquidacion set Estado= '1', Observacion_Anulacion ='Anulada por modificación en el ingreso', Fecha_Anulacion='" + dtf.format(LocalDateTime.now()) + "',Usuario_Anulacion ='" + this.usuario.getUsuarioS() + "'\nwhere Id_Ingreso='" + idIngreso + "';";
        int editados = csm.ejecutaSQLUpdate(Query);
        if (editados > 0) {
            System.out.println("Se anuló una liquidacion anterior relacionada al ingreso");
        }
        return editados;
    }

    private int AnularFacturaEvento(String idLiquidacion) {
        ConsultasMySQL csm = new ConsultasMySQL();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String Query = "update f_factura_evento set Estado =1, Id_MotivoAnulacion =2, Motivo_Anulacion ='Anulacion de liquidacion por cambios en procedimientos',\nFecha_Anulacion ='" + dtf.format(LocalDateTime.now()) + "',Usuario_Anulacion ='" + this.usuario.getUsuarioS() + "' where Id_Liquidacion ='" + idLiquidacion + "'";
        int editados = csm.ejecutaSQLUpdate(Query);
        if (editados > 0) {
            System.out.println("Se anuló una factura evento anterior relacionada a la liquidacion");
        }
        return editados;
    }

    private int AnularFacturaCapita(String idLiquidacion) {
        ConsultasMySQL csm = new ConsultasMySQL();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String Query = "update f_factura_capita set Estado =1,Id_MotivoAnulacion =2, Motivo_Anulacion ='Anulacion de liquidación por cambios en ingreso'\n,Fecha_Anulacion ='" + dtf.format(LocalDateTime.now()) + "',Usuario_Anulacion ='" + this.usuario.getUsuarioS() + "' where Id_Liquidacion ='" + idLiquidacion + "'";
        int editados = csm.ejecutaSQLUpdate(Query);
        if (editados > 0) {
            System.out.println("Se anuló una factura capita anterior relacionada a la liquidacion");
        }
        return editados;
    }

    private String recuperaIdLiquidacion(String idIngreso) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Sql = "select Id  from f_liquidacion fl\nwhere fl.Id_Ingreso ='" + idIngreso + "'\norder \tby fl.Fecha desc limit 1";
        String idLiquidacion = csm.traerDato(Sql);
        return idLiquidacion;
    }

    private void mLlenarLiquidacion(Double subTotal, long idIngreso, Boolean ingresoNuevo, int formaDePago, int medioDePago) {
        int tipoDePlan = tipoPlanConvenioBS1(this.idConvenioGenoma);
        int esCapitado = esCapitadoBS1(this.idConvenioGenoma);
        if (!ingresoNuevo.booleanValue()) {
            AnularLiquidacion(String.valueOf(idIngreso));
            String idLiquidacion = recuperaIdLiquidacion(String.valueOf(idIngreso));
            AnularFacturaEvento(String.valueOf(idLiquidacion));
            AnularFacturaCapita(String.valueOf(idLiquidacion));
        }
        EmpresaContConvenioEntity empConv = new EmpresaContConvenioEntity();
        empConv.setId(Integer.valueOf(this.idConvenioGenoma));
        this.listSubgrupoEmpresa = this.subgrupoEmpresaService.listaSubgrupoEmpresaPorIdConvenioOrdenadoPorNombre(empConv, true);
        this.liquidacionEntity = new LiquidacionEntity();
        this.liquidacionEntity.setIdIngreso(idIngreso);
        this.liquidacionEntity.setCopago(new Double(0.0d).doubleValue());
        this.liquidacionEntity.setCuotaModeradora(new Double(0.0d).doubleValue());
        this.liquidacionEntity.setDireccionIp(Principal.getLocalHost().getHostAddress());
        this.liquidacionEntity.setEstado(false);
        this.liquidacionEntity.setFecha(this.metodos.getFechaActual());
        this.liquidacionEntity.setIdEmpresaContxConv(Integer.valueOf(this.idConvenioGenoma));
        this.liquidacionEntity.setIdFormaPago(Integer.valueOf(formaDePago));
        this.liquidacionEntity.setIdSubGrupoServicio(this.listSubgrupoEmpresa.get(0));
        this.liquidacionEntity.setIdMotivoAnulacion(1);
        this.liquidacionEntity.setIdUsuarioRH(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().intValue()));
        this.liquidacionEntity.setNEquipo(Principal.getLocalHost().getHostName());
        this.liquidacionEntity.setNFolios(0);
        this.liquidacionEntity.setObservacion("");
        this.liquidacionEntity.setObservacionAnulacion("");
        this.liquidacionEntity.setTGlosa(new Double(0.0d));
        this.liquidacionEntity.setTPagado(new Double(0.0d));
        this.liquidacionEntity.setTotalServicio(Double.valueOf(subTotal.doubleValue()).doubleValue());
        this.liquidacionEntity.setTotalDescuento(Double.valueOf(0.0d).doubleValue());
        if (tipoDePlan == 4) {
            this.liquidacionEntity.setTotalEps(new Double(0.0d).doubleValue());
            this.liquidacionEntity.setTotalPlan(new Double(0.0d).doubleValue());
            this.liquidacionEntity.setTotalPaciente(Double.valueOf(subTotal.doubleValue()).doubleValue());
        } else {
            this.liquidacionEntity.setTotalEps(Double.valueOf(subTotal.doubleValue()).doubleValue());
            this.liquidacionEntity.setTotalPlan(Double.valueOf(subTotal.doubleValue()).doubleValue());
            this.liquidacionEntity.setTotalPaciente(new Double(0.0d).doubleValue());
        }
        this.liquidacionEntity.setUsuarioAnulacion("");
        this.liquidacionEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.liquidacionEntity.setVGlosaNR(new Double(0.0d));
        this.liquidacionEntity.setVGlosaR(new Double(0.0d));
        List<FFacturaEvento> eventos = new ArrayList<>();
        List<FFacturaCapita> capitas = new ArrayList<>();
        if (esCapitado == 2) {
            mValidaResolucionDian(true);
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
            this.facturaEvento.setIdMedioPago(Integer.valueOf(medioDePago));
            Long numDefault = Long.valueOf("0");
            this.facturaEvento.setNoFacturaeventoM(numDefault);
            this.facturaEvento.setIdMotivoanulacion(0);
            this.facturaEvento.setMotivoAnulacion("");
            this.facturaEvento.setUsuarioAnulacion("");
            this.facturaEvento.setEstaArmada(0);
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
        this.xLiquidacionService.grabar(this.liquidacionEntity);
        try {
            System.out.println("No Liquidacion: " + this.liquidacionEntity.getId() + "id documento= " + this.facturaEvento.getIdDocumentoc().toString());
            Long idFacturaEventoM = Long.valueOf(RecuperarNoFacturaEvento(this.liquidacionEntity.getId().toString()));
            this.ccDocumentocService.grabarDocumentoContableServiciosFacturacion(idFacturaEventoM, 6);
            insertarProcedureFFacturaPagos(this.liquidacionEntity.getId());
            System.out.println(">>>insertarProcedureFFacturaPagos");
        } catch (Exception e) {
            System.err.println("Error>>>>> : " + e);
        }
        System.out.println("LIQUIDACIÓN GRABADA");
        System.out.println("x");
    }

    public void insertarProcedureFFacturaPagos(Long idLiquidacion) {
        System.out.println("idLiquidacioon -> " + idLiquidacion);
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `insertarFFPagos`('" + idLiquidacion + "')}");
            cs.execute();
            JOptionPane.showMessageDialog((Component) null, "Se realizó el pago correctamente");
            cs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String RecuperarNoFacturaEvento(String str) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Query = "SELECT  `No_FacturaEvento` FROM f_factura_evento\nWHERE Id_Liquidacion ='" + str + "'";
        String result = csm.traerDato(Query);
        csm.cerrarConexionBd();
        return result;
    }

    private void mCrearItemsOrdeneBs1(Long idOrden, String idProcedimiento, String idTipoFinProcedimiento, String IdcodigoBs1, String Valor, String idHistoriaParaclinico) {
        ConsultasMySQL csm = new ConsultasMySQL();
        String Query = "select COUNT(Id_Procedimiento) from f_itemordenesproced\nwhere Id_Ordenes = '" + idOrden + "' and Id_Procedimiento ='" + idProcedimiento + "';";
        int valor = Integer.valueOf(csm.traerDato(Query)).intValue();
        if (valor == 1) {
            String UpdateItem = "update f_itemordenesproced fi set ValorUnitario ='" + Valor + "', fi.EsCobrable ='1'\nwhere fi.Id_Ordenes ='" + idOrden + "' and Id_Procedimiento ='" + idProcedimiento + "'";
            int actualizados = csm.ejecutaSQLUpdate(UpdateItem);
            if (actualizados > 0) {
                System.out.println("se actualizo el valor del procedimiento ORDEN: " + idOrden + "  PROCEDIMIENTO: " + idProcedimiento);
            }
        }
        if (valor == 0) {
            FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(idOrden).id_Procedimiento(Long.valueOf(Long.parseLong(idProcedimiento))).id_TipofinProc(idTipoFinProcedimiento).cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble(Valor))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(IdcodigoBs1).esCobrable(true).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(UUID.randomUUID().toString()).codigoEncabezadoOrdenBs1(idHistoriaParaclinico).build();
            this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
        }
    }

    private void CrearOrden(Long IdIngreso) {
        if (IdIngreso != null) {
            FOrdenesDTO xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(IdIngreso).id_TipoServicio(2).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf("1")).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble("1"))).totalEPS(Double.valueOf(Double.parseDouble("1"))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
            this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO);
            System.err.println("idOrden " + this.idOrden);
            System.err.println("idOrdenInterna " + this.idOrdenInterna);
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                CrearOrdenProcedimientoGenomaAPI(this.idOrden, this.idOrdenInterna);
                return;
            }
            if (Principal.informacionIps.getIdentificacion().equals("891408918") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                CrearOrdenProcedimientoCNT_Bs1(this.idOrden, this.idOrdenInterna);
                return;
            } else {
                if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                    System.err.println("entro col " + this.idOrden + " " + this.idOrdenInterna);
                    CrearOrdenProcedimientoColgenes(this.idOrden, this.idOrdenInterna);
                    return;
                }
                return;
            }
        }
        System.err.println("Problema Id ingreso " + IdIngreso);
    }

    private void CrearOrdenProcedimiento(Long IdOrden, String IdOrdenGIIS) {
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsGIIS(String.valueOf(IdOrdenGIIS));
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                System.err.println("lista pos 1" + listaDetalle.get(i)[0].toString());
                FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaDetalle.get(i)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[2].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).build();
                this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
            }
        }
    }

    private void CrearOrdenProcedimientoColgenes(Long IdOrden, String IdOrdenCNT) {
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsColgenes(String.valueOf(IdOrdenCNT));
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                System.err.println("lista pos " + listaDetalle.get(i)[0].toString());
                List<Object[]> listaCNT = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                if (!listaCNT.isEmpty()) {
                    System.err.println("lista colgenes pos " + listaCNT.get(0)[0].toString());
                    FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaCNT.get(0)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[0].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(UUID.randomUUID().toString()).codigoEncabezadoOrdenBs1(listaDetalle.get(i)[3].toString()).build();
                    this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
                } else {
                    System.err.println("No encontro Procedimeinto Relacionado");
                }
            }
        }
    }

    private void CrearOrdenProcedimientoCNT_Bs1(Long IdOrden, String IdOrdenCNT) {
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsCNT(String.valueOf(IdOrdenCNT), "LABOBIOSYSTEM");
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                System.err.println("lista pos " + listaDetalle.get(i)[0].toString());
                List<Object[]> listaCNT = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                if (!listaCNT.isEmpty()) {
                    System.err.println("lista CNT pos " + listaCNT.get(0)[0].toString());
                    FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaCNT.get(0)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[0].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(UUID.randomUUID().toString()).codigoEncabezadoOrdenBs1(listaDetalle.get(i)[3].toString()).build();
                    this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
                } else {
                    System.err.println("No encontro Procedimeinto Relacionado");
                }
            }
        }
    }

    public void nuevo() {
        if (Principal.informacionIps.getIdentificacion().equals("891408918")) {
            this.JRB_Todas.setText("anulada");
        }
        this.lleno = false;
        this.JDC_Fecha.setDate(this.metodos.getFechaActual());
        crearTablaAgendaProgramada();
        crearTablaAgendaServicios();
        this.lleno = true;
        this.identificadorTabla = 0;
        this.tipoNuremoAutorizacion = "0";
        this.idOrdenInterna = "0";
        this.JCconvenio.removeAllItems();
        if (Principal.informacionIps.getIdentificacion().equals("900454815") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
            this.xidconvenio = this.consultas.llenarCombo("select   `Id`,   `Nbre` from   `f_empresacontxconvenio` WHERE (Estado =0) ORDER BY Nbre ASC", this.xidconvenio, this.JCconvenio);
            if (this.xidconvenio.length == 1) {
                this.JCconvenio.setSelectedIndex(0);
                return;
            } else {
                this.JCconvenio.setSelectedIndex(-1);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.lisEmpresa = this.consultas.llenarComboyLista("SELECT   `Id`,   `Nbre` , EsCapitado  FROM   `f_empresacontxconvenio` WHERE (Estado =0) ORDER BY Nbre ASC", this.lisEmpresa, this.JCconvenio, 3);
        } else {
            this.JCconvenio.setEnabled(false);
        }
    }

    private void ejecutarTarea() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendaSimedisBienestar.this.estadoAgenda.get()) {
                    if (!JIF_AgendaSimedisBienestar.this.JTFNombre.getText().isEmpty()) {
                        JIF_AgendaSimedisBienestar.this.cargarDatos(true);
                    } else {
                        JIF_AgendaSimedisBienestar.this.cargarDatos(false);
                    }
                } else {
                    timer.cancel();
                }
                System.out.println(" tarea ejecutando time");
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaProgramada() {
        this.modeloTabla = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Hora", "Usuario", "Sexo", "Entidad", "No. Recepcion", "Sede", "No. Admision", "Email"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDatosAgenda;
        JTable jTable2 = this.JTBDatosAgenda;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda.doLayout();
        this.JTBDatosAgenda.setModel(this.modeloTabla);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(250);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicios() {
        this.modeloTabla1 = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Hora", "Usuario", "Sexo", "Entidad", "No. Recepcion", "Sede", "No. Lab"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar.15
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDatosServicio;
        JTable jTable2 = this.JTBDatosServicio;
        jTable.setAutoResizeMode(0);
        this.JTBDatosServicio.doLayout();
        this.JTBDatosServicio.setModel(this.modeloTabla1);
        this.JTBDatosServicio.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosServicio.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosServicio.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosServicio.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDatosServicio.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosServicio.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTBDatosServicio.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosServicio.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDatosServicio.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void cargarDatos(Boolean filtro) {
        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
            List<LaboratoriosDTO> listadoOrdenes = laboratorioDAO.listadoAgendaFechaSede(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServicios(listadoOrdenes);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
            List<LaboratoriosDTO> listadoOrdenes2 = laboratorioDAO.listadoAgendaFechaSedeSifa(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServicios(listadoOrdenes2);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            List<LaboratoriosDTO> listadoOrdenes3 = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencial(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServicios(listadoOrdenes3);
            List<LaboratoriosDTO> listadoOrdenesS = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencialServicios(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServiciosInterno(listadoOrdenesS);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            List<LaboratoriosDTO> listadoOrdenes4 = laboratorioDAO.listadoAgendaSedeIndigo(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServicios(listadoOrdenes4);
            List<LaboratoriosDTO> listadoOrdenesS2 = laboratorioDAO.listadoAgendaSedeIndigoServicios(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
            mCargaAgendaServiciosInterno(listadoOrdenesS2);
            return;
        }
        if (Principal.informacionIps.getIdentificacion().equals("891408918")) {
            List<LaboratoriosDTO> listadoOrdenes5 = laboratorioDAO.listadoAgendaFechaCNT(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
            mCargaAgendaServicios(listadoOrdenes5);
            List<LaboratoriosDTO> listadoOrdenesS3 = laboratorioDAO.listadoAgendaFechaCNTServicios(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
            mCargaAgendaServiciosInterno(listadoOrdenesS3);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
            List<LaboratoriosDTO> listadoOrdenes6 = laboratorioDAO.listadoAgendaFechaCNTBiomed(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
            mCargaAgendaServicios(listadoOrdenes6);
            List<LaboratoriosDTO> listadoOrdenesS4 = laboratorioDAO.listadoAgendaFechaCNTServiciosBiomed(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
            mCargaAgendaServiciosInterno(listadoOrdenesS4);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            List<LaboratoriosDTO> listadoOrdenes7 = laboratorioDAO.listadoAgendaFechaSedeBienEstarIps(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase(), this.JTFNombre.getText());
            mCargaAgendaServicios(listadoOrdenes7);
        } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
            List<LaboratoriosDTO> listadoOrdenes8 = laboratorioDAO.listadoAgendaFechaColgenes(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
            mCargaAgendaServicios(listadoOrdenes8);
        }
    }

    private void mCargaAgendaServiciosInterno(List<LaboratoriosDTO> listadoList) {
        Integer numero = 0;
        this.JSPDatosServicio.remove(this.JTBDatosServicio);
        this.JSPDatosServicio.setViewportView((Component) null);
        this.JSPDatosServicio.repaint();
        if (listadoList.size() != -1) {
            this.metodos1.mEstablecerTextEditor(this.JTBDatosServicio, 3);
            this.metodos1.mEstablecerTextEditor(this.JTBDatosServicio, 5);
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloTabla1.addRow(this.datos);
                this.modeloTabla1.setValueAt(listadoList.get(i).getNumeroOrden(), i, 0);
                this.modeloTabla1.setValueAt(listadoList.get(i).getFechaOrden(), i, 1);
                this.modeloTabla1.setValueAt(listadoList.get(i).getHoraOrden(), i, 2);
                this.modeloTabla1.setValueAt(listadoList.get(i).getApellido1() + " " + listadoList.get(i).getApellido2() + " " + listadoList.get(i).getNombre1() + " " + listadoList.get(i).getNombre2(), i, 3);
                this.modeloTabla1.setValueAt(listadoList.get(i).getIdSexo(), i, 4);
                this.modeloTabla1.setValueAt(listadoList.get(i).getNombreEmpresa(), i, 5);
                this.modeloTabla1.setValueAt(listadoList.get(i).getIdRecepcion(), i, 6);
                this.modeloTabla1.setValueAt(listadoList.get(i).getNombreSede(), i, 7);
                this.modeloTabla1.setValueAt(listadoList.get(i).getNumeroAdmision(), i, 8);
                this.JTBDatosServicio.setDefaultRenderer(Object.class, new MiRender());
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloTabla1.setRowCount(listadoList.size());
            this.modeloTabla1.fireTableDataChanged();
        }
        this.JSPDatosServicio.setViewportView(this.JTBDatosServicio);
        this.JSPDatosServicio.repaint();
    }

    private void mCargaAgendaServicios(List<LaboratoriosDTO> listadoList) {
        Integer numero = 0;
        this.JSPDatosAgenta.remove(this.JTBDatosAgenda);
        this.JSPDatosAgenta.setViewportView((Component) null);
        this.JSPDatosAgenta.repaint();
        if (listadoList.size() != -1) {
            this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 3);
            this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 5);
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloTabla.addRow(this.datos);
                this.modeloTabla.setValueAt(listadoList.get(i).getNumeroOrden(), i, 0);
                this.modeloTabla.setValueAt(listadoList.get(i).getFechaOrden(), i, 1);
                this.modeloTabla.setValueAt(listadoList.get(i).getHoraOrden(), i, 2);
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                    this.modeloTabla.setValueAt(listadoList.get(i).getApellido1(), i, 3);
                } else {
                    this.modeloTabla.setValueAt(listadoList.get(i).getApellido1() + " " + listadoList.get(i).getApellido2() + " " + listadoList.get(i).getNombre1() + " " + listadoList.get(i).getNombre2(), i, 3);
                }
                this.modeloTabla.setValueAt(listadoList.get(i).getIdSexo(), i, 4);
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                    this.modeloTabla.setValueAt(listadoList.get(i).getNombreExterno(), i, 5);
                    this.modeloTabla.setValueAt(listadoList.get(i).getIdConvenioExterno(), i, 7);
                } else {
                    this.modeloTabla.setValueAt(listadoList.get(i).getNombreEmpresa(), i, 5);
                    this.modeloTabla.setValueAt(listadoList.get(i).getNombreSede(), i, 7);
                }
                this.modeloTabla.setValueAt(listadoList.get(i).getIdRecepcion(), i, 6);
                this.modeloTabla.setValueAt(listadoList.get(i).getNumeroAdmision(), i, 8);
                this.modeloTabla.setValueAt(listadoList.get(i).getDireccion(), i, 9);
                this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloTabla.setRowCount(listadoList.size());
            this.modeloTabla.fireTableDataChanged();
        }
        this.JTF_Cantidad.setText("" + numero);
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JSPDatosAgenta.repaint();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIF_AgendaSimedisBienestar$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 6) != null) {
                if (Long.valueOf(table.getValueAt(row, 6).toString()).longValue() != 0) {
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    private void cargarRecepcion(Long idRecepcionGenoma) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Orden recepcionada, \nDesea cargarla", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (n == 0) {
            try {
                LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
                this.ordenGenoma = laboratorioDAO.consultarOrdenGenoma(idRecepcionGenoma).longValue();
                if (this.ordenGenoma != 0) {
                    Principal.clasefacturacion.setXlugarprocesamiento(0);
                    Principal.clasefacturacion.cargarPantalla("Recepcion Lab");
                    Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(String.valueOf(this.ordenGenoma));
                    Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
                }
            } catch (Throwable ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }
}
