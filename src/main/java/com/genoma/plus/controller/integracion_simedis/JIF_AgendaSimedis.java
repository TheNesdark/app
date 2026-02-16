package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import Facturacion.Facturac;
import Facturacion.claseFacturacion;
import General.Persona;
import Laboratorio.Agenda;
import Laboratorio.RecepcionAuto;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO;
import com.genoma.plus.dao.integracion_simedis.LaboratorioDAO;
import com.genoma.plus.dto.facturacion.IngresoAgil;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.integracion_simedis.LaboratoriosDTO;
import com.genoma.plus.jpa.entities.BarrioEntity;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FEstrato;
import com.genoma.plus.jpa.entities.FItemsOrdenProcDTO;
import com.genoma.plus.jpa.entities.FOrdenesDTO;
import com.genoma.plus.jpa.entities.GCargos;
import com.genoma.plus.jpa.entities.GCausaexterna;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEmpresacont;
import com.genoma.plus.jpa.entities.GEspecialidad;
import com.genoma.plus.jpa.entities.GEstadocivil;
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
import com.genoma.plus.jpa.entities.IInterfazXencoOrden;
import com.genoma.plus.jpa.entities.Ingreso;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.SoTipoGrupo;
import com.genoma.plus.jpa.entities.SoTipoSegmento;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.service.FItiemsOrdenProcService;
import com.genoma.plus.jpa.service.FOrdenesService;
import com.genoma.plus.jpa.service.GEmpresacontService;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.genoma.plus.jpa.service.IInterfaceXencoService;
import com.genoma.plus.jpa.service.IngresoService;
import com.genoma.plus.jpa.service.UsuarioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIF_AgendaSimedis.class */
public class JIF_AgendaSimedis extends JInternalFrame {
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTabla1;
    private DefaultTableModel modeloTabla2;
    private String tipoNuremoAutorizacion;
    private String idOrdenInterna;
    private String observacionBs1;
    private String NumeroHcBs1;
    private String noDocumento;
    private String nombrePaciente;
    private String xsql;
    private Object[] datos;
    private IngresoAgil ingresoAgil;
    private GPersona persona;
    private GUsuario usuario;
    private Ingreso ingreso;
    private IGPersonaService personaService;
    private GEmpresacont empresaContrato;
    private IntegracionExternaDAO integracionExternaDAO;
    private IInterfaceXencoService xencoService;
    public Facturac frmFacturac;
    public static claseFacturacion clasefacturacion = null;
    public RecepcionAuto xjifrecepcionlab;
    private int identificadorTabla;
    private DefaultTableModel modcombos;
    private String[] xidconvenio;
    private List<GCGenericoDTO> sede;
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
    public Persona frmPersona = null;
    private String estado = "0";
    private long ordenGenoma = 0;
    private String[][] xEmpresa = (String[][]) null;
    private Metodos metodos = new Metodos();
    private Metodos metodos1 = new Metodos();
    private boolean lleno = false;
    private String nombreProfesional = "SIN PROFESIONAL";
    private IInterfazXencoOrden xencoOrden = new IInterfazXencoOrden();
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
    private String estadoTexto = "Por Atender";
    public AtomicBoolean estadoAgenda = new AtomicBoolean(true);
    private List<IInterfazXencoOrden> interfazXencoOrdens = new ArrayList();
    private Integer idEmpr = 0;
    private Integer idProfesiona = 0;

    public JIF_AgendaSimedis() {
        initComponents();
        springStart();
        nuevo();
        ejecutarTarea();
        this.xencoService = (IInterfaceXencoService) Principal.contexto.getBean(IInterfaceXencoService.class);
        this.personaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
    }

    private void springStart() {
        this.integracionExternaDAO = (IntegracionExternaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("integracionExternaDAOImpl");
    }

    public String getTipoNuremoAutorizacion() {
        return this.tipoNuremoAutorizacion;
    }

    public void setTipoNuremoAutorizacion(String tipoNuremoAutorizacion) {
        this.tipoNuremoAutorizacion = tipoNuremoAutorizacion;
    }

    public String getNoDocumento() {
        return this.noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getNombrePaciente() {
        return this.nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
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
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_AgendaSimedis.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendaSimedis.this.formInternalFrameClosing(evt);
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
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.JRB_Atender);
        this.JRB_Atender.setFont(new Font("Arial", 1, 12));
        this.JRB_Atender.setForeground(Color.blue);
        this.JRB_Atender.setSelected(true);
        this.JRB_Atender.setText("Por Atender");
        this.JRB_Atender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.3
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedis.this.JRB_AtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRB_Atendidas);
        this.JRB_Atendidas.setFont(new Font("Arial", 1, 12));
        this.JRB_Atendidas.setForeground(Color.blue);
        this.JRB_Atendidas.setText("Atendidas");
        this.JRB_Atendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedis.this.JRB_AtendidasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setForeground(Color.blue);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedis.this.JRB_TodasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Atender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Atendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Todas).addContainerGap(16, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Atender).addComponent(this.JRB_Atendidas).addComponent(this.JRB_Todas)).addContainerGap(-1, 32767)));
        this.JDC_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_Fecha.setFont(new Font("Arial", 1, 12));
        this.JDC_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_AgendaSimedis.this.JDC_FechaPropertyChange(evt);
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
        this.JTPDatos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.7
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedis.this.JTPDatosMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setBorder((Border) null);
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(35);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.8
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedis.this.JTBDatosAgendaMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIF_AgendaSimedis.this.JTBDatosAgendaMouseEntered(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JTPDatos.addTab("CONSULTA EXTERNA", this.JSPDatosAgenta);
        this.JTBDatosServicio.setFont(new Font("Arial", 1, 12));
        this.JTBDatosServicio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosServicio.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.9
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaSimedis.this.JTBDatosServicioMouseClicked(evt);
            }
        });
        this.JSPDatosServicio.setViewportView(this.JTBDatosServicio);
        this.JTPDatos.addTab("SERVICIOS", this.JSPDatosServicio);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.10
            public void keyPressed(KeyEvent evt) {
                JIF_AgendaSimedis.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCconvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCconvenio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.11
            public void itemStateChanged(ItemEvent evt) {
                JIF_AgendaSimedis.this.JCconvenioItemStateChanged(evt);
            }
        });
        this.JCconvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.12
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaSimedis.this.JCconvenioActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDC_Fecha, -2, 123, -2).addGap(10, 10, 10).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Cantidad, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 318, -2).addGap(18, 18, 18).addComponent(this.JCconvenio, 0, 351, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 524, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCconvenio).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDC_Fecha, -2, 50, -2).addComponent(this.JPIFiltro, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTF_Cantidad, -2, 50, -2))))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTBDatosAgenda.getSelectedColumn() == 6 && Integer.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()).intValue() != 0) {
                cargarRecepcion(Long.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()));
                dispose();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                if (this.estado.equals("1")) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                this.estadoAgenda.set(false);
                this.identificadorTabla = 1;
                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                    setTipoNuremoAutorizacion(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    grabarGenomaAPIIndigo(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                }
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    System.out.println("entra al metodo de grabar cnt");
                    setTipoNuremoAutorizacion(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    setNoDocumento(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 9).toString());
                    grabaCNT(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                }
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    setTipoNuremoAutorizacion(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8).toString());
                    this.NumeroHcBs1 = this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString();
                    this.JCconvenio.setSelectedItem(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
                    grabaBS1(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString(), this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
                }
                if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                    setTipoNuremoAutorizacion(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    grabaColgenes(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                }
                dispose();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                this.estadoAgenda.set(false);
                System.err.println("entra factu");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString(), "1");
                dispose();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                mLLenarComboempresa();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                if (Integer.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()).intValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                } else {
                    this.estadoAgenda.set(false);
                    grabaDinamica(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    return;
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                if (Integer.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()).intValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                this.estadoAgenda.set(false);
                setTipoNuremoAutorizacion(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                grabaXenco(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                if (Integer.valueOf(this.modeloTabla.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()).intValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                this.estadoAgenda.set(false);
                System.err.println("entra factu");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                dispose();
                return;
            }
            this.estadoAgenda.set(false);
            System.err.println("entra factu");
            Principal.clasefacturacion.setIdCodigoInternoInterface(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 9).toString());
            Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
            this.estadoAgenda.set(false);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.estadoAgenda.set(false);
    }

    public void grabarOrdenXenco() {
        if (this.estadoTexto == "Por Atender") {
            grabaXenco(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Esta orden ya esta atendida", "Informacion", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AtendidasActionPerformed(ActionEvent evt) {
        this.estado = "1";
        this.estadoTexto = "Atendidas";
        cargarDatos(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        this.estado = "0,1";
        cargarDatos(false);
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
                    setTipoNuremoAutorizacion(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                    grabarGenomaAPIIndigo(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                    dispose();
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                setTipoNuremoAutorizacion(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                setNoDocumento(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 9).toString());
                grabaCNT(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                this.estadoAgenda.set(false);
                System.err.println("entra factu");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString(), "1");
                this.estadoAgenda.set(false);
                dispose();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                if (Integer.valueOf(this.modeloTabla1.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString()).intValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                } else {
                    this.estadoAgenda.set(false);
                    grabaDinamica(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                    return;
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                if (Integer.valueOf(this.modeloTabla1.getValueAt(this.JTBDatosServicio.getSelectedRow(), 6).toString()).intValue() != 0) {
                    JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                this.estadoAgenda.set(false);
                System.err.println("entra factu1");
                Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
                this.estadoAgenda.set(false);
                dispose();
                return;
            }
            this.estadoAgenda.set(false);
            System.err.println("entra factu1");
            Principal.clasefacturacion.setIdCodigoInternoInterface(this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 9).toString());
            Principal.clasefacturacion.cargarPantalla("Facturac", this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 0).toString());
            this.estadoAgenda.set(false);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.estadoAgenda.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            cargarDatos(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AtenderActionPerformed(ActionEvent evt) {
        this.estado = "0";
        this.estadoTexto = "Por Atender";
        cargarDatos(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCconvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCconvenioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCconvenio.getSelectedIndex() != -1) {
            cargarDatos(false);
        }
    }

    private void grabarGenomaAPI(String IdOrdenGIIS) {
        this.idOrdenInterna = IdOrdenGIIS;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaGenomaAPI(this.idOrdenInterna);
        CrearIngresoGenomaAPI(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
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
        this.ingreso.setNoAutorizacion(getTipoNuremoAutorizacion());
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
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
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
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
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
        this.ingreso.setNoAutorizacion(getTipoNuremoAutorizacion());
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
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
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
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
            CrearpersonaPersonaCNT(this.idOrdenInterna, "05040", 17);
        } else if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") && Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
            CrearpersonaPersonaCNT(this.idOrdenInterna, "05206", 46);
        } else {
            CrearpersonaPersonaCNT(this.idOrdenInterna, "63130", 888);
        }
        CrearIngresoCNT(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            System.out.println("grabo todo en cnt");
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void grabaBS1(String idOrdenInternas, String observacionBS1) {
        this.idOrdenInterna = idOrdenInternas;
        this.observacionBs1 = observacionBS1;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaBs1(this.idOrdenInterna);
        CrearIngresoBs1(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, this.observacionBs1, "");
            Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
            Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
            this.estadoAgenda.set(false);
            dispose();
            return;
        }
        System.err.println("Problema retornar id ingreso");
    }

    private void grabadoUserWanglab() {
        String queryValidation = "SELECT COUNT(`numeroDocumento`) AS Existe FROM `wanglab`.`w_ttercero`\nWHERE(`numeroDocumento`='" + this.frmPersona.getIdentificacion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        int existe = 0;
        try {
            ResultSet rs = xct.traerRs(queryValidation);
            if (rs.next()) {
                existe = rs.getInt(1);
            }
            rs.close();
            xct.cerrarConexionBd();
            if (existe == 0) {
                System.err.println("" + this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0]);
                int tipoIdentificacion = Integer.parseInt(this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0]);
                String sqlGTercero = "INSERT INTO wanglab.`w_ttercero` (`esActivo`,`fechaActualizacion`,`fechaCreacion`,`usuarioSistema`,`digitoVerificacion`,`email`,`fechaNacimiento`,\n`movil`,`numeroDocumento`,`primerApellido`,`segundoApellido`,`primerNombre`,`segundoNombre`,`razonSocial`,`telefono`,`tipoIdentificacion_id`,`usuarioActualizacion`,\n`usuarioCreacion`,`updatePass`)\nVALUES('1','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdentificacion() + "',NULL,'" + this.frmPersona.txtCorreo.getText() + "','" + this.metodos.formatoAMD1.format(this.frmPersona.cboFechaNacimiento.getDate()) + "','" + this.frmPersona.txtTelefono1.getText() + "','" + this.frmPersona.getIdentificacion() + "',\n'" + this.frmPersona.getApellido1() + "','" + this.frmPersona.getApellido2() + "','" + this.frmPersona.getNombre1() + "','" + this.frmPersona.getNombre2() + "',NULL,'" + this.frmPersona.getTelefono() + "','" + tipoIdentificacion + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','1')";
                String idTercero = xct.ejecutarSQLId(sqlGTercero);
                String sqlGUsuario = "INSERT INTO `wanglab`.`w_tusuario` (`esActivo`,`fechaActualizacion`,`fechaCreacion`,`usuarioSistema`,`contrasena`,`esAdmin`,`esProtegido`,`usuario`,`tercero_id`,\n`usuarioActualizacion`,`usuarioCreacion`,`estado`)\nVALUES('1','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdentificacion() + "','" + this.metodos.getEncryptedPassword(new String(this.frmPersona.getIdentificacion())) + "',\n'0','0','" + this.frmPersona.getIdentificacion() + "','" + idTercero + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getLogin() + "', 'A')";
                String idUsuario = xct.ejecutarSQLId(sqlGUsuario);
                String sqlGUsuarioGrupo = "INSERT INTO `wanglab`.`w_tusuario_tgrupo`(grupo_id,`usuario_id`)\nVALUES('5','" + idUsuario + "')";
                xct.ejecutarSQL(sqlGUsuarioGrupo);
                xct.cerrarConexionBd();
                JOptionPane.showMessageDialog((Component) null, "Usuario registrado exitosamente en WangLab");
            } else if (existe > 0) {
                JOptionPane.showMessageDialog((Component) null, "Usuario existente en wanglab");
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    private void grabaDinamica(String idOrdenDinamica) {
        this.idOrdenInterna = idOrdenDinamica;
        System.err.println("Idorden" + this.idOrdenInterna);
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            CrearPersonaDinamica(this.idOrdenInterna, "08001", 141);
        } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            CrearPersonaDinamica(this.idOrdenInterna, "05040", 17);
        }
        CrearIngresoDinamica(this.idpersona);
        CrearOrdenDinamica();
    }

    private void CrearOrdenDinamica() {
        String sinHomologar = "";
        List<String> listaSinHomologar = new ArrayList<>();
        List<FItemsOrdenProcDTO> listaItemsOrdenProcedimiento = new ArrayList<>();
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsDinamica(String.valueOf(this.idOrdenInterna));
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                List<Object[]> listaHomologada = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                if (!listaHomologada.isEmpty()) {
                    FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Procedimiento(Long.valueOf(Long.parseLong(listaHomologada.get(0)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[0].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(listaDetalle.get(i)[2].toString()).codigoEncabezadoOrdenBs1(listaDetalle.get(i)[2].toString()).build();
                    listaItemsOrdenProcedimiento.add(xFItemsOrdenProcDTO);
                } else {
                    sinHomologar = sinHomologar + "<b><font face='Arial' color='red' size=4>→ " + listaDetalle.get(i)[0].toString() + "</font></b><br>";
                    listaSinHomologar.add(listaDetalle.get(i)[0].toString());
                }
            }
            if (sinHomologar.isEmpty()) {
                this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
                if (this.ingresoAgil.getIngreso().getId() != null) {
                    new FOrdenesDTO();
                    FOrdenesDTO xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(this.ingresoAgil.getIngreso().getId()).id_TipoServicio(2).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble("1"))).totalEPS(Double.valueOf(Double.parseDouble("1"))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
                    this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO);
                    listaItemsOrdenProcedimiento.forEach(e -> {
                        e.setId_Ordenes(this.idOrden);
                    });
                    this.xFItiemsOrdenProcService.saveAll(listaItemsOrdenProcedimiento);
                    Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
                    Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
                    Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
                    System.out.println("grabo todo en cnt");
                    this.estadoAgenda.set(false);
                    dispose();
                    return;
                }
                return;
            }
            this.estadoAgenda.set(true);
            int opc = JOptionPane.showInternalOptionDialog(this, "<html><p ALIGN=center><font face='Arial' color='red' size=4><b>Se encontraron " + listaSinHomologar.size() + " Codigo(s) De Dinamica Que No Se Encuentran Homologado(s) En Genoma:</font></b></p><br>" + sinHomologar + "<br><br><p ALIGN=center><b><font face='Arial' color='red' size=4> Desea Homologarlo(s)?</font></b></p></html>", "VERIFICAR", 1, 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))), new Object[]{"Homologar", "Cancelar"}, "Cancelar");
            if (opc == 0) {
                JDHomologacionProcedimiento jDHomologar = new JDHomologacionProcedimiento(null, true, listaSinHomologar);
                jDHomologar.setVisible(true);
            }
        }
    }

    private void CrearPersonaDinamica(String idOrdenDinamica, String idMunicipio, Integer idBarrio) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenDinamica(idOrdenDinamica);
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
                municipioDTO.setId(idMunicipio);
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(idBarrio);
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
                this.persona.setIdMunicipioNac(idMunicipio);
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

    private void CrearIngresoDinamica(Long IdPersona) {
        int TipoAtencion;
        int origen;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.JTPDatos.getSelectedIndex() == 0) {
            TipoAtencion = 1;
            origen = 2;
        } else if (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString().contains("HOSPITALIZACION")) {
            TipoAtencion = 3;
            origen = 1;
        } else {
            TipoAtencion = 2;
            origen = 1;
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
        especialidad.setId(1012);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(15);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().intValue()));
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(1);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.idOrdenInterna);
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
        this.ingreso.setNMuestra(false);
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
    }

    private void grabaXenco(String idOrdenXenco) {
        this.idOrdenInterna = idOrdenXenco;
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL")) {
            CrearPersonaXenco(this.idOrdenInterna, Principal.informacionIps.getIdMunicipio(), 58);
        } else if (Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL")) {
            CrearPersonaXenco(idOrdenXenco, Principal.informacionIps.getIdMunicipio(), 100);
        } else if (Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
            CrearPersonaXenco(idOrdenXenco, Principal.informacionIps.getIdMunicipio(), 111);
        }
        CrearIngresoXenco(this.idpersona);
        CrearOrdenXenco();
    }

    private void CrearPersonaXenco(String idOrdenXenco, String idMunicipio, Integer idBarrio) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenXenco(idOrdenXenco);
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
                municipioDTO.setId(idMunicipio);
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(idBarrio);
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
                this.persona.setIdMunicipioNac(idMunicipio);
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

    private void CrearIngresoXenco(Long IdPersona) {
        int TipoAtencion;
        int origen;
        System.err.println("Idpersona Metodo usuario " + IdPersona);
        if (this.JTPDatos.getSelectedIndex() == 0) {
            TipoAtencion = 1;
            origen = 2;
        } else if (this.JTBDatosServicio.getValueAt(this.JTBDatosServicio.getSelectedRow(), 5).toString().contains("HOSPITALIZACION")) {
            TipoAtencion = 3;
            origen = 1;
        } else {
            TipoAtencion = 2;
            origen = 1;
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
        especialidad.setId(1012);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(8);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(15);
        this.ingreso = new Ingreso();
        this.ingreso.setIdUsuario(this.persona);
        this.ingreso.setFechaIngreso(this.metodos.getFechaActual());
        this.ingreso.setHoraIngreso(this.metodos.getFechaActual());
        this.ingreso.setIdEmpresaContxConv(idEmpresaContxConv);
        this.ingreso.setEsCapitado(2);
        this.ingreso.setIdSede(Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().intValue()));
        this.ingreso.setSiCopago(true);
        this.ingreso.setIdEstrato(estrato);
        this.ingreso.setIdOrigenAdmision(origenadmision);
        this.ingreso.setIdCausaExterna(causaexterna);
        this.ingreso.setIdEspecialidad(especialidad);
        this.ingreso.setIdProfesional(15);
        this.ingreso.setIdTipoAtencion(tipoatencion);
        this.ingreso.setDxIngreso("0000");
        this.ingreso.setNoAutorizacion(this.idOrdenInterna);
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
        this.ingreso.setNMuestra(false);
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
    }

    private void CrearOrdenXenco() {
        String sinHomologar = "";
        List<String> listaSinHomologar = new ArrayList<>();
        List<FItemsOrdenProcDTO> listaItemsOrdenProcedimiento = new ArrayList<>();
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsXenco(this.idOrdenInterna);
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                List<Object[]> listaHomologada = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                if (!listaHomologada.isEmpty()) {
                    FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Procedimiento(Long.valueOf(Long.parseLong(listaHomologada.get(0)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[1].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1("").codigoEncabezadoOrdenBs1("").build();
                    listaItemsOrdenProcedimiento.add(xFItemsOrdenProcDTO);
                } else {
                    sinHomologar = sinHomologar + "<b><font face='Arial' color='red' size=4>→ " + listaDetalle.get(i)[0].toString() + "</font></b><br>";
                    listaSinHomologar.add(listaDetalle.get(i)[0].toString());
                }
            }
            if (sinHomologar.isEmpty()) {
                this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
                if (this.ingresoAgil.getIngreso().getId() != null) {
                    new FOrdenesDTO();
                    FOrdenesDTO xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(this.ingresoAgil.getIngreso().getId()).id_TipoServicio(2).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble("1"))).totalEPS(Double.valueOf(Double.parseDouble("1"))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
                    this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO);
                    listaItemsOrdenProcedimiento.forEach(e -> {
                        e.setId_Ordenes(this.idOrden);
                    });
                    this.xFItiemsOrdenProcService.saveAll(listaItemsOrdenProcedimiento);
                    Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, "", "");
                    Principal.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(Long.toString(this.idOrden.longValue()));
                    Principal.clasefacturacion.xjifrecepcionlab.buscarOrden();
                    System.out.println("grabo todo en cnt");
                    this.estadoAgenda.set(false);
                    dispose();
                    return;
                }
                return;
            }
            this.estadoAgenda.set(true);
            int opc = JOptionPane.showInternalOptionDialog(this, "<html><p ALIGN=center><font face='Arial' color='red' size=4><b>Se encontraron " + listaSinHomologar.size() + " Codigo(s) De Xenco Que No Se Encuentran Homologado(s) En Genoma:</font></b></p><br>" + sinHomologar + "<br><br><p ALIGN=center><b><font face='Arial' color='red' size=4> Desea Homologarlo(s)?</font></b></p></html>", "VERIFICAR", 1, 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))), new Object[]{"Homologar", "Cancelar"}, "Cancelar");
            if (opc == 0) {
                JDHomologacionProcedimiento jDHomologar = new JDHomologacionProcedimiento(null, true, listaSinHomologar);
                jDHomologar.setVisible(true);
            }
        }
    }

    private void mLLenarComboempresa() {
        idEmpresa(this.modeloTabla2.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 18).toString());
        this.JCconvenio.removeAllItems();
        this.xsql = "SELECT Id,Nbre FROM f_empresacontxconvenio fe WHERE  Id_EmpresaCont =" + this.idEmpr + "";
        System.out.println(this.xsql);
        this.xEmpresa = this.consultas.llenarComboyLista(this.xsql, this.xEmpresa, this.JCconvenio, 2);
        System.out.println(this.xEmpresa.length);
        if (this.xEmpresa != null) {
            if (this.xEmpresa.length > 0) {
                this.JCconvenio.setEnabled(true);
                this.JCconvenio.setSelectedIndex(0);
            } else {
                this.JCconvenio.setSelectedIndex(-1);
                this.JCconvenio.setEnabled(true);
            }
        }
        this.consultas.cerrarConexionBd();
    }

    private void grabaColgenes(String idOrdenInternas) {
        this.idOrdenInterna = idOrdenInternas;
        System.err.println("Idorden" + this.idOrdenInterna);
        CrearpersonaPersonaColgenes(this.idOrdenInterna);
        CrearIngresoBs1(this.idpersona);
        if (this.ingresoAgil.getIngreso().getId() != null) {
            CrearOrden(this.ingresoAgil.getIngreso().getId());
            Principal.clasefacturacion.cargarPantalla1("Recepcion Laboratorio", 1, this.idOrdenInterna, this.idOrden, this.observacionBs1, "");
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
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
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

    private void CrearpersonaPersonaCNT(String IdOrdenCNT, String idMunicipio, Integer idBarrio) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenCNT(IdOrdenCNT, getNoDocumento(), this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()));
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
                municipioDTO.setId(idMunicipio);
                BarrioEntity barrioEntity = new BarrioEntity();
                barrioEntity.setId(idBarrio);
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
                this.persona.setIdMunicipioNac(idMunicipio);
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
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
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

    private void CrearpersonaPersonaBs1(String IdOrdenBs1) {
        this.ingresoAgil = new IngresoAgil();
        this.persona = new GPersona();
        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
        LaboratoriosDTO e = laboratorioDAO.recepcionIdOrdenBs1(IdOrdenBs1);
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
                this.persona.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            }
            this.ingresoAgil.setPersona(this.persona);
            CrearUsuario();
        }
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
        System.out.println("entra a guardar el usuario");
        GTipoafiliado gTipoAfiliado = new GTipoafiliado();
        gTipoAfiliado.setId(4);
        GEmpresa empresa = new GEmpresa();
        GEmpresacont empresacont = new GEmpresacont();
        if (Principal.informacionIps.getIdentificacion().equals("890000600")) {
            System.out.println("entra al de cnt");
            empresa.setId(new Long(408L));
            empresacont.setId(1);
            empresacont.setIdempresa(empresa);
        } else {
            empresacont.setId(1);
            empresa.setId(new Long(1L));
        }
        GCargos cargo = new GCargos();
        cargo.setId(1);
        SoTipoSegmento tipoSegmento = new SoTipoSegmento();
        tipoSegmento.setId(1);
        SoTipoGrupo tipoGrupo = new SoTipoGrupo();
        tipoGrupo.setId(1);
        GSoLateralidad soLateralidad = new GSoLateralidad();
        soLateralidad.setId(1);
        GSoJornada soJornada = new GSoJornada();
        soJornada.setId(1);
        GPoblacionEspecial gPoblacionEspecial = new GPoblacionEspecial();
        gPoblacionEspecial.setId(5);
        System.out.println("antes de buscar por id empresa");
        System.out.println("id empresa " + empresa.getId());
        Optional<GEmpresacont> empreOptional = this.empresacontService.findByIdempresa(empresa);
        if (empreOptional.isPresent()) {
            this.empresaContrato = empreOptional.get();
        }
        this.ingresoAgil.setUsuario(this.usuario);
        this.usuario.setGPersona(this.persona);
        this.usuario.setNoHistoria(this.persona.getNoDocumento());
        this.usuario.setIdOcupacion("6");
        System.out.println("el tipo afiliacion " + gTipoAfiliado.getId());
        this.usuario.setIdTipoAfiliado(gTipoAfiliado);
        this.usuario.setEstado(false);
        this.usuario.setDetalleAnulacion((String) null);
        this.usuario.setIdEmpresaCont(this.empresaContrato);
        this.usuario.setEsFpz(false);
        this.usuario.setFechaDA((java.util.Date) null);
        this.usuario.setNAfiliacion("");
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
        this.usuario.setNEducativo("NINGUNO");
        this.usuario.setOcupacion("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
        this.usuario.setEmail(this.persona.getCorreo());
        this.usuario.setFecha(this.metodos.getFechaActual());
        this.usuario.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
    }

    public void idEmpresa(String nombre) {
        String xsql = "SELECT Id  FROM g_empresa ge WHERE Nbre ='" + nombre + "'";
        System.out.println(xsql);
        try {
            ResultSet rs = this.consultas.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        this.idEmpr = Integer.valueOf(rs.getInt("Id"));
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIF_AgendaSimedis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
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
        this.ingreso.setNoAutorizacion(getTipoNuremoAutorizacion());
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
        if (Principal.informacionIps.getIdentificacion().equals("890000600")) {
            idEmpresaContxConv.setId(8);
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
        especialidad.setId(353);
        GTipoatencion tipoatencion = new GTipoatencion();
        tipoatencion.setId(Integer.valueOf(TipoAtencion));
        GParentesco parentesco = new GParentesco();
        parentesco.setId(5);
        GTipoafiliado tipoafiliado = new GTipoafiliado();
        tipoafiliado.setId(4);
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
        this.ingreso.setNoAutorizacion(getTipoNuremoAutorizacion());
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
        this.ingreso.setNMuestra(false);
        this.ingreso.setIdTipoAfiliacion(tipoafiliado);
        this.ingreso.setIdTipoContratacion(tipoContratacionDTO);
        this.ingreso.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.ingreso.setFecha(this.metodos.getFechaActual());
        this.ingreso.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.ingresoAgil.setIngreso(this.ingreso);
        new IngresoAgil();
        this.xIngresoService.crearIngresoAgilV2(this.ingresoAgil);
    }

    private void CrearIngresoBs1(Long IdPersona) {
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
        this.ingreso.setNoAutorizacion(getTipoNuremoAutorizacion());
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

    private void buscarProfesional(String nombre) {
        this.xsql = "SELECT Id_Persona  FROM profesional1 p WHERE trim(p.NProfesional)  = '" + nombre + "' GROUP by Id_Persona";
        System.out.println("buscar " + this.xsql);
        ResultSet xrs = this.consultas.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                this.idProfesiona = Integer.valueOf(xrs.getInt("Id_Persona"));
            } else {
                this.idProfesiona = 125;
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_AgendaSimedis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void CrearOrden(Long IdIngreso) {
        FOrdenesDTO xFOrdenesDTO;
        this.idProfesiona = Integer.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        System.out.println("el id del profesional " + this.idProfesiona);
        if (IdIngreso != null) {
            if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(IdIngreso).id_TipoServicio(2).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf(this.idProfesiona.intValue())).id_Especialidad(382).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble("1"))).totalEPS(Double.valueOf(Double.parseDouble("1"))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
            } else {
                xFOrdenesDTO = FOrdenesDTO.builder().id_Ingreso(IdIngreso).id_TipoServicio(2).fechaOrden(this.metodos.getFechaActual()).horaOrden(this.metodos.formatoH24.format(this.metodos.getFechaActual())).id_Profesional(Long.valueOf(this.idProfesiona.intValue())).id_Especialidad(353).id_CentroCosto(2).totalOrdenes(Double.valueOf(Double.parseDouble("1"))).totalEPS(Double.valueOf(Double.parseDouble("1"))).totalDescuento(Double.valueOf(Double.parseDouble("1"))).totalPaciente(Double.valueOf(Double.parseDouble("1"))).estado(false).usuarioS(Principal.usuarioSistemaDTO.getLogin()).id_Remoto(Long.valueOf("1")).estadoRecep(0).id_OrdenRecep(Long.valueOf("0")).lProcesamiento(0).build();
            }
            this.idOrden = this.xFOrdenesService.crearEmcabezadoOrden(xFOrdenesDTO);
            System.err.println("idOrden " + this.idOrden);
            System.err.println("idOrdenInterna " + this.idOrdenInterna);
            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                CrearOrdenProcedimientoGenomaAPI(this.idOrden, this.idOrdenInterna);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                CrearOrdenProcedimientoCNT_Bs1(this.idOrden, this.idOrdenInterna);
                return;
            }
            if (Principal.informacionIps.getIdentificacion().equals("890000600") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                CrearOrdenProcedimientoCNT(this.idOrden, this.idOrdenInterna);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                System.err.println("entro col " + this.idOrden + " " + this.idOrdenInterna);
                CrearOrdenProcedimientoColgenes(this.idOrden, this.idOrdenInterna);
                return;
            } else {
                if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                    CrearOrdenProcedimientoXenco(this.idOrden);
                    System.out.println("grabo en la oreden");
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
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsBS1(String.valueOf(IdOrdenCNT));
        System.err.println("entro bs1");
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

    private void CrearOrdenProcedimientoCNT(Long IdOrden, String IdOrdenCNT) {
        List<Object[]> listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsCNT(String.valueOf(IdOrdenCNT), this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), "LABOBIOSYSTEM", getNoDocumento());
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                System.err.println("lista pos " + listaDetalle.get(i)[0].toString());
                List<Object[]> listaCNT = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                if (!listaCNT.isEmpty()) {
                    System.err.println("lista CNT pos " + listaCNT.get(0)[0].toString());
                    FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaCNT.get(0)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[0].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(listaDetalle.get(i)[2].toString()).codigoEncabezadoOrdenBs1(listaDetalle.get(i)[2].toString()).build();
                    this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
                } else {
                    System.err.println("No encontro Procedimeinto Relacionado");
                }
            }
        }
    }

    private void CrearOrdenProcedimientoXenco(Long IdOrden) {
        List<Object[]> listaDetalle = null;
        if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
            listaDetalle = this.xencoService.listadoProcedimientoItemsXenco2(this.modeloTabla2.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
            System.err.println("entro bs1");
        }
        if (!listaDetalle.isEmpty()) {
            for (int i = 0; i < listaDetalle.size(); i++) {
                FItemsOrdenProcDTO xFItemsOrdenProcDTO = FItemsOrdenProcDTO.builder().id_Ordenes(IdOrden).id_Procedimiento(Long.valueOf(Long.parseLong(listaDetalle.get(i)[0].toString()))).id_TipofinProc("1").cantidad(1).valorUnitario(Double.valueOf(Double.parseDouble("1"))).valorDescuento(Double.valueOf(Double.parseDouble("0"))).valorImpuesto(Double.valueOf(Double.parseDouble("0"))).porcentajeImpuesto(Double.valueOf(Double.parseDouble("0"))).id_CentroCosto(2).esRecepcionado(false).id_ResultadoLab(0).nAutorizacion(listaDetalle.get(i)[1].toString()).esCobrable(false).plan(1).fecha(LocalDateTime.now()).codigoEnvioBs1(UUID.randomUUID().toString()).codigoEncabezadoOrdenBs1("").build();
                this.xFItiemsOrdenProcService.crearDetalleOrden(xFItemsOrdenProcDTO);
            }
            System.out.println("grabo en la oredn detalle");
            return;
        }
        System.err.println("No encontro Procedimeinto Relacionado");
    }

    public void nuevo() {
        this.estadoTexto = "Por Atender";
        if (Principal.informacionIps.getIdentificacion().equals("890000600") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE")) {
            this.JRB_Todas.setText("anulada");
        }
        this.lleno = false;
        this.JDC_Fecha.setDate(this.metodos.getFechaActual());
        crearTablaAgendaServicios();
        crearTablaAgendaProgramada();
        this.lleno = true;
        this.identificadorTabla = 0;
        setTipoNuremoAutorizacion("0");
        this.idOrdenInterna = "0";
        this.JCconvenio.removeAllItems();
        if (Principal.informacionIps.getIdentificacion().equals("900454815") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.xidconvenio = this.consultas.llenarCombo("select   `Id`,   `Nbre` from   `f_empresacontxconvenio` WHERE (Estado =0) ORDER BY Nbre ASC", this.xidconvenio, this.JCconvenio);
            if (this.xidconvenio.length == 1) {
                this.JCconvenio.setSelectedIndex(0);
            } else {
                this.JCconvenio.setSelectedIndex(-1);
            }
        } else {
            this.JCconvenio.setEnabled(false);
        }
        if (Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
            this.JCconvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
            LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
            this.sede = laboratorioDAO.listarSedesSimedi();
            this.JCconvenio.removeAllItems();
            for (int i = 0; i < this.sede.size(); i++) {
                this.JCconvenio.addItem(this.sede.get(i).getNombre());
            }
            this.JCconvenio.setSelectedIndex(-1);
            this.JCconvenio.setEnabled(true);
        } else {
            this.JCconvenio.setEnabled(false);
        }
        this.xlleno = true;
    }

    private void ejecutarTarea() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendaSimedis.this.estadoAgenda.get()) {
                    try {
                        if (JIF_AgendaSimedis.this.JDC_Fecha.getDate() != null) {
                            if (!JIF_AgendaSimedis.this.JTFNombre.getText().isEmpty()) {
                                JIF_AgendaSimedis.this.cargarDatos(true);
                            } else {
                                JIF_AgendaSimedis.this.cargarDatos(false);
                            }
                        }
                    } catch (NullPointerException e) {
                    } catch (NumberFormatException e2) {
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
        this.modeloTabla = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Hora", "Usuario", "Sexo", "Entidad", "No. Recepcion", "Sede", "No. Admision", "No Documento"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
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
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(180);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(250);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaXenco() {
        this.modeloTabla2 = new DefaultTableModel(new Object[0], new String[]{"id", "DocGeneradoLaboratorio", "DocGenerado", "TipoDocGestion", "NumeroDocumentoGestion", "FechaDoc", "Articulo", "NombreArticulo", "Bodega1", "Cantidad", "ValorUnitario", "CentroCostos", "NombreCentroCosto", "UsuarioDigito", "UsuarioAnulo", "TipoMedicamento", "FechaMOdificacion", "CodigoEntidad", "NombreEntidad", "Sexo", "TipoDocumento", "NumeroDocumento", "Nombre", "Apellido", "FechaNacimiento", "Estado", "Profesional", "Telefono Paciente"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.15
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDatosAgenda.setModel(this.modeloTabla2);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(250);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(27).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicios() {
        this.modeloTabla1 = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Hora", "Usuario", "Sexo", "Entidad", "No. Recepcion", "Sede", "No. Admision", "No Documento"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDatosServicio.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosServicio.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosServicio.getColumnModel().getColumn(9).setMinWidth(0);
    }

    public void cargarDatos(Boolean filtro) {
        List<LaboratoriosDTO> listadoOrdenes;
        try {
            LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
            if (Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
                if (this.JCconvenio.getSelectedIndex() == -1) {
                    listadoOrdenes = laboratorioDAO.listadoAgendaFechaSede(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getCodigoInterfaz(), this.estado, filtro, this.JTFNombre.getText());
                } else {
                    listadoOrdenes = laboratorioDAO.listadoAgendaFechaSede(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), this.sede.get(this.JCconvenio.getSelectedIndex()).getIdString(), this.estado, filtro, this.JTFNombre.getText());
                }
                mCargaAgendaServicios(listadoOrdenes);
            } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL")) {
                List<LaboratoriosDTO> listadoOrdenes2 = laboratorioDAO.listadoAgendaFechaSedeSifa(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes2);
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                List<LaboratoriosDTO> listadoOrdenes3 = laboratorioDAO.listadoAgendaFechaSedeSifaSantaClara(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes3);
                List<LaboratoriosDTO> listadoOrdenesS = laboratorioDAO.listadoAgendaFechaSedeSifaServiciosSantaClara(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServiciosInterno(listadoOrdenesS);
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL")) {
                List<LaboratoriosDTO> listadoOrdenes4 = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencial(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes4);
                List<LaboratoriosDTO> listadoOrdenesS2 = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencialServicios(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServiciosInterno(listadoOrdenesS2);
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                List<LaboratoriosDTO> listadoOrdenes5 = laboratorioDAO.listadoAgendaSedeIndigo(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes5);
                List<LaboratoriosDTO> listadoOrdenesS3 = laboratorioDAO.listadoAgendaSedeIndigoServicios(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServiciosInterno(listadoOrdenesS3);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                List<LaboratoriosDTO> listadoOrdenes6 = laboratorioDAO.listadoAgendaFechaCNTAnori(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServicios(listadoOrdenes6);
                List<LaboratoriosDTO> listadoOrdenesS4 = laboratorioDAO.listadoAgendaFechaCNTServiciosAnori(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServiciosInterno(listadoOrdenesS4);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                List<LaboratoriosDTO> listadoOrdenes7 = laboratorioDAO.listadoAgendaFechaCNTBiomed(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServicios(listadoOrdenes7);
                List<LaboratoriosDTO> listadoOrdenesS5 = laboratorioDAO.listadoAgendaFechaCNTServiciosBiomed(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServiciosInterno(listadoOrdenesS5);
            } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                List<LaboratoriosDTO> listadoOrdenes8 = laboratorioDAO.listadoAgendaFechaSedeBienEstarIps(this.metodos.formatoDMA.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServicios(listadoOrdenes8);
            } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                List<LaboratoriosDTO> listadoOrdenes9 = laboratorioDAO.listadoAgendaFechaColgenes(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), this.estado, filtro, this.JTFNombre.getText().toUpperCase());
                mCargaAgendaServicios(listadoOrdenes9);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                List<LaboratoriosDTO> listadoOrdenes10 = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencialAtlantico(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes10);
                List<LaboratoriosDTO> listadoOrdenesS6 = laboratorioDAO.listadoAgendaFechaSedeDinamicaGerencialServiciosAtlantico(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServiciosInterno(listadoOrdenesS6);
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                List<LaboratoriosDTO> listadoOrdenes11 = laboratorioDAO.listadoAgendaFechaCentralReferencia(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes11);
                List<LaboratoriosDTO> listadoOrdenesS7 = laboratorioDAO.listadoAgendaFechaServiciosCentralReferencia(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServiciosInterno(listadoOrdenesS7);
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                List<IInterfazXencoOrden> listaXEnco = laboratorioDAO.listadoAgendaFechaInterfaceXenco(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), this.estado, this.JTFNombre.getText());
                mCargaAgendaServicios2(listaXEnco);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                List<LaboratoriosDTO> listadoOrdenes12 = laboratorioDAO.listadoAgendaFechaSedeXenco(this.metodos.formatoAMD1.format(this.JDC_Fecha.getDate()), Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estado, filtro, this.JTFNombre.getText());
                mCargaAgendaServicios(listadoOrdenes12);
            }
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void mCargaAgendaServiciosInterno(List<LaboratoriosDTO> listadoList) {
        Integer numero = 0;
        this.JSPDatosServicio.remove(this.JTBDatosServicio);
        this.JSPDatosServicio.setViewportView((Component) null);
        this.JSPDatosServicio.repaint();
        if (!listadoList.isEmpty()) {
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
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    this.modeloTabla1.setValueAt(listadoList.get(i).getDocumento(), i, 9);
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                    this.modeloTabla1.setValueAt(listadoList.get(i).getIdCodigoInterno(), i, 9);
                } else {
                    this.modeloTabla1.setValueAt("", i, 9);
                }
                if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                    this.JTBDatosServicio.setDefaultRenderer(Object.class, new MiRender());
                } else {
                    this.JTBDatosServicio.setDefaultRenderer(Object.class, new MiRender2());
                }
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloTabla1.setRowCount(listadoList.size());
            this.modeloTabla1.fireTableDataChanged();
        } else {
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
        if (!listadoList.isEmpty()) {
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
                this.modeloTabla.setValueAt(listadoList.get(i).getNombreEmpresa(), i, 5);
                this.modeloTabla.setValueAt(listadoList.get(i).getIdRecepcion(), i, 6);
                this.modeloTabla.setValueAt(listadoList.get(i).getNombreSede(), i, 7);
                this.modeloTabla.setValueAt(listadoList.get(i).getNumeroAdmision(), i, 8);
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    this.modeloTabla.setValueAt(listadoList.get(i).getDocumento(), i, 9);
                } else {
                    this.modeloTabla.setValueAt("", i, 9);
                }
                if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                    this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                } else {
                    this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender2());
                }
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloTabla.setRowCount(listadoList.size());
            this.modeloTabla.fireTableDataChanged();
        } else {
            this.modeloTabla.setRowCount(listadoList.size());
            this.modeloTabla.fireTableDataChanged();
        }
        this.JTF_Cantidad.setText("" + numero);
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JSPDatosAgenta.repaint();
    }

    private void mCargaAgendaServicios2(List<IInterfazXencoOrden> listadoList) {
        Integer numero = 0;
        this.JSPDatosAgenta.remove(this.JTBDatosAgenda);
        this.JSPDatosAgenta.setViewportView((Component) null);
        this.JSPDatosAgenta.repaint();
        if (!listadoList.isEmpty()) {
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloTabla2.addRow(this.datos);
                this.modeloTabla2.setValueAt(listadoList.get(i).getId(), i, 0);
                this.modeloTabla2.setValueAt(listadoList.get(i).getDocGeneradoLaboratorio(), i, 1);
                this.modeloTabla2.setValueAt(listadoList.get(i).getDocGenerado(), i, 2);
                this.modeloTabla2.setValueAt(listadoList.get(i).getTipoDocGestion(), i, 3);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNumeroDocumentoGestion(), i, 4);
                this.modeloTabla2.setValueAt(listadoList.get(i).getFechaDoc(), i, 5);
                this.modeloTabla2.setValueAt(listadoList.get(i).getArticulo(), i, 6);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNombreArticulo(), i, 7);
                this.modeloTabla2.setValueAt(listadoList.get(i).getBodega1(), i, 8);
                this.modeloTabla2.setValueAt(listadoList.get(i).getCantidad(), i, 9);
                this.modeloTabla2.setValueAt(listadoList.get(i).getValorUnitario(), i, 10);
                this.modeloTabla2.setValueAt(listadoList.get(i).getCentroCostos(), i, 11);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNombreCentroCosto(), i, 12);
                this.modeloTabla2.setValueAt(listadoList.get(i).getUsuarioDigito(), i, 13);
                this.modeloTabla2.setValueAt(listadoList.get(i).getUsuarioAnulo(), i, 14);
                this.modeloTabla2.setValueAt(listadoList.get(i).getTipoMedicamento(), i, 15);
                this.modeloTabla2.setValueAt(listadoList.get(i).getFechaMOdificacion(), i, 16);
                this.modeloTabla2.setValueAt(listadoList.get(i).getCodigoEntidad(), i, 17);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNombreEntidad(), i, 18);
                this.modeloTabla2.setValueAt(listadoList.get(i).getSexo(), i, 19);
                this.modeloTabla2.setValueAt(listadoList.get(i).getTipoDocumento(), i, 20);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNumeroDocumento(), i, 21);
                this.modeloTabla2.setValueAt(listadoList.get(i).getNombre(), i, 22);
                this.modeloTabla2.setValueAt(listadoList.get(i).getApellido(), i, 23);
                this.modeloTabla2.setValueAt(listadoList.get(i).getFechaNacimiento(), i, 24);
                this.modeloTabla2.setValueAt(this.estadoTexto, i, 25);
                this.modeloTabla2.setValueAt(listadoList.get(i).getProfesional(), i, 26);
                this.modeloTabla2.setValueAt(listadoList.get(i).getTelefonoPaciente(), i, 27);
                this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                numero = Integer.valueOf(numero.intValue() + 1);
                this.modeloTabla2.setRowCount(listadoList.size());
            }
            this.modeloTabla2.fireTableDataChanged();
        }
        this.JTF_Cantidad.setText("" + numero);
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JSPDatosAgenta.repaint();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIF_AgendaSimedis$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIF_AgendaSimedis$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            switch (table.getValueAt(row, 25).toString()) {
                case "Por Atender":
                    cell.setBackground(new Color(0, 0, 102));
                    cell.setForeground(Color.WHITE);
                    break;
                case "Atendidas":
                    cell.setBackground(new Color(103, 0, 103));
                    cell.setForeground(Color.WHITE);
                    break;
                default:
                    cell.setForeground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    private void cargarRecepcion(Long idRecepcionGenoma) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Orden recepcionada, \nDesea cargarla", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (n == 0) {
            try {
                LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
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
