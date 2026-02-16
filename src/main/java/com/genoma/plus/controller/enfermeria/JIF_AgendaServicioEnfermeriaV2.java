package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Enfermeria.JIFHistoria_UH;
import Laboratorio.JIFPlanillaTrabajo;
import Laboratorio.Render;
import Utilidades.Metodos;
import Utilidades.SseListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.dto.EventSubscriberDTO;
import com.genoma.plus.controller.historia.FuncionalidadPanelHistoriaClinica;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.utilidades.InformacionOrdenamientoMedico;
import com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico;
import com.genoma.plus.dao.general.SseClosableDAO;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.historia.AgendaHCDTO;
import com.genoma.plus.dto.historia.AgendaOrdenesGenericoDTO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import com.genoma.plus.jpa.service.AgendaHCService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeriaV2.class */
public final class JIF_AgendaServicioEnfermeriaV2 extends JInternalFrame implements SseClosableDAO {
    private HistoriaDAO historiaDAO;
    public FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
    private DefaultTableModel modeloServicio;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idServicio;
    private Object[] datos;
    private SseListener sseListener;
    private List<EventSubscriberDTO> eventSubscriberDTOs;
    private List<OrdenamientoMedico> ordenamientoMedico;
    private ButtonGroup JBG_Filtrado;
    private ButtonGroup JBG_FiltroEstado;
    private ButtonGroup JBG_FiltroEstadoAtencion;
    private ButtonGroup JBG_FiltroServicio;
    private JButton JBT_Campana;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_Interconsulta;
    private JCheckBox JCH_Observacion;
    public JDateChooser JDCFechaAgenda1;
    private JLabel JLB_NumeroRegistro;
    private JPanel JPIEstado;
    private JPanel JPI_Filtro;
    private JPanel JPI_FiltroServicio;
    private JPanel JPI_Servicios;
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_U;
    private JRadioButton JRB_FSSeleccion;
    private JRadioButton JRB_FSTodos;
    private JSpinner JSDias;
    private JScrollPane JSP_AgendaServicios;
    private JTable JTB_AgendaServicios;
    private JTextField JTFBuscar;
    private ButtonGroup jbgFiltroSexo;
    private JPanel jpFiltroSexo;
    private JRadioButton jrbAmbos;
    private JRadioButton jrbFemenino;
    private JRadioButton jrbMasculino;
    private DefaultTreeModel modelo = null;
    private String filtroEstado = "1";
    private Metodos metodos = new Metodos();
    private Boolean esLlenoCombo = false;
    private Vector<ConfiguracionItems> listadoItemsCargados = new Vector<>();
    private Integer estadoAtencion = 0;
    private String filtroAtencion = "2,3";
    private List<String> sexo = new ArrayList();
    private Integer estadoEgreso = 0;
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);
    private final AgendaHCService AgendaService = (AgendaHCService) Principal.contexto.getBean(AgendaHCService.class);
    private boolean numeroDias = false;

    public JIF_AgendaServicioEnfermeriaV2() {
        initComponents();
        springStart();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        this.ordenamientoMedico = new ArrayList();
        nuevo();
        ejecutarTareaTimer();
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.jrbMasculino.setVisible(false);
            this.jrbFemenino.setVisible(false);
            this.jpFiltroSexo.setVisible(false);
            this.jrbAmbos.setVisible(false);
        }
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
            this.JSDias.setValue(30);
        } else {
            this.JSDias.setValue(2);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
            this.JSDias.setValue(30);
        }
        inicializarSseListener();
    }

    @Override // com.genoma.plus.dao.general.SseClosableDAO
    public void closeSseListeners() {
        if (this.eventSubscriberDTOs != null) {
            if (this.sseListener != null) {
                for (EventSubscriberDTO subscriber : this.eventSubscriberDTOs) {
                    this.sseListener.unsubscribe(subscriber);
                }
            } else {
                System.out.println("sseListener es null");
            }
            this.eventSubscriberDTOs.clear();
            return;
        }
        System.out.println("eventSubscriberDTOs es null");
    }

    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JBG_FiltroEstadoAtencion = new ButtonGroup();
        this.jbgFiltroSexo = new ButtonGroup();
        this.JBG_FiltroServicio = new ButtonGroup();
        this.JPI_Servicios = new JPanel();
        this.JPI_Filtro = new JPanel();
        this.JCB_Servicio = new JComboBox<>();
        this.JCH_Observacion = new JCheckBox();
        this.JCH_Interconsulta = new JCheckBox();
        this.JPIEstado = new JPanel();
        this.JRBEnAtencion_U = new JRadioButton();
        this.JRBDeAlta_U = new JRadioButton();
        this.JTFBuscar = new JTextField();
        this.JLB_NumeroRegistro = new JLabel();
        this.jpFiltroSexo = new JPanel();
        this.jrbFemenino = new JRadioButton();
        this.jrbMasculino = new JRadioButton();
        this.jrbAmbos = new JRadioButton();
        this.JDCFechaAgenda1 = new JDateChooser();
        this.JSDias = new JSpinner();
        this.JPI_FiltroServicio = new JPanel();
        this.JRB_FSTodos = new JRadioButton();
        this.JRB_FSSeleccion = new JRadioButton();
        this.JSP_AgendaServicios = new JScrollPane();
        this.JTB_AgendaServicios = new JTable();
        this.JBT_Campana = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA SERVICIOS ENFERMERIA V2");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1300, 767));
        setName("jif_historiaclinicav2");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.formInternalFrameClosing(evt);
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
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setToolTipText("");
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.3
            public void itemStateChanged(ItemEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_Observacion.setBackground(new Color(177, 251, 177));
        this.JBG_FiltroEstado.add(this.JCH_Observacion);
        this.JCH_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Observacion.setSelected(true);
        this.JCH_Observacion.setText("Observación");
        this.JCH_Observacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JCH_ObservacionActionPerformed(evt);
            }
        });
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JBG_FiltroEstado.add(this.JCH_Interconsulta);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Interconsulta");
        this.JCH_Interconsulta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JCH_InterconsultaActionPerformed(evt);
            }
        });
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroEstadoAtencion.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JRBEnAtencion_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.6
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JRBEnAtencion_UActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstadoAtencion.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        this.JRBDeAlta_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.7
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JRBDeAlta_UActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.8
            public void keyPressed(KeyEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.JLB_NumeroRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NumeroRegistro.setFont(new Font("Arial", 1, 12));
        this.JLB_NumeroRegistro.setForeground(Color.red);
        this.JLB_NumeroRegistro.setHorizontalAlignment(0);
        this.JLB_NumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jpFiltroSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jbgFiltroSexo.add(this.jrbFemenino);
        this.jrbFemenino.setFont(new Font("Arial", 1, 12));
        this.jrbFemenino.setText("F");
        this.jrbFemenino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.9
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.jrbFemeninoActionPerformed(evt);
            }
        });
        this.jbgFiltroSexo.add(this.jrbMasculino);
        this.jrbMasculino.setFont(new Font("Arial", 1, 12));
        this.jrbMasculino.setText("M");
        this.jrbMasculino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.10
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.jrbMasculinoActionPerformed(evt);
            }
        });
        this.jbgFiltroSexo.add(this.jrbAmbos);
        this.jrbAmbos.setFont(new Font("Arial", 1, 12));
        this.jrbAmbos.setSelected(true);
        this.jrbAmbos.setText("Ambos");
        this.jrbAmbos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.11
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.jrbAmbosActionPerformed(evt);
            }
        });
        GroupLayout jpFiltroSexoLayout = new GroupLayout(this.jpFiltroSexo);
        this.jpFiltroSexo.setLayout(jpFiltroSexoLayout);
        jpFiltroSexoLayout.setHorizontalGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpFiltroSexoLayout.createSequentialGroup().addContainerGap().addComponent(this.jrbFemenino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbMasculino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbAmbos).addContainerGap(-1, 32767)));
        jpFiltroSexoLayout.setVerticalGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpFiltroSexoLayout.createSequentialGroup().addContainerGap().addGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbFemenino).addComponent(this.jrbMasculino).addComponent(this.jrbAmbos)).addContainerGap(-1, 32767)));
        this.JDCFechaAgenda1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda1.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda1.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JDCFechaAgenda1PropertyChange(evt);
            }
        });
        this.JSDias.setFont(new Font("Arial", 1, 12));
        this.JSDias.setModel(new SpinnerNumberModel(2, (Comparable) null, (Comparable) null, 1));
        this.JSDias.setToolTipText("Intervalo de dias hacia atras a visualizar");
        this.JSDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSDias.setRequestFocusEnabled(false);
        this.JSDias.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.13
            public void mouseEntered(MouseEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JSDiasMouseEntered(evt);
            }
        });
        this.JPI_FiltroServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Servicio", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroServicio.add(this.JRB_FSTodos);
        this.JRB_FSTodos.setFont(new Font("Arial", 1, 12));
        this.JRB_FSTodos.setForeground(Color.blue);
        this.JRB_FSTodos.setText("Todos");
        this.JRB_FSTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.14
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JRB_FSTodosActionPerformed(evt);
            }
        });
        this.JBG_FiltroServicio.add(this.JRB_FSSeleccion);
        this.JRB_FSSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRB_FSSeleccion.setForeground(Color.blue);
        this.JRB_FSSeleccion.setSelected(true);
        this.JRB_FSSeleccion.setText("Selección");
        this.JRB_FSSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.15
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JRB_FSSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroServicioLayout = new GroupLayout(this.JPI_FiltroServicio);
        this.JPI_FiltroServicio.setLayout(JPI_FiltroServicioLayout);
        JPI_FiltroServicioLayout.setHorizontalGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroServicioLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FSTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FSSeleccion).addContainerGap(-1, 32767)));
        JPI_FiltroServicioLayout.setVerticalGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroServicioLayout.createSequentialGroup().addGroup(JPI_FiltroServicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FSTodos).addComponent(this.JRB_FSSeleccion)).addContainerGap(-1, 32767)));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCB_Servicio, -2, 296, -2).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroServicio, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFBuscar).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JPIEstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jpFiltroSexo, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Observacion).addComponent(this.JCH_Interconsulta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaAgenda1, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDias, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NumeroRegistro, -2, 108, -2))).addGap(27, 27, 27)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_FiltroServicio, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCB_Servicio, -2, 50, -2)).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCH_Observacion).addGap(4, 4, 4).addComponent(this.JCH_Interconsulta, -1, -1, 32767)).addComponent(this.JPIEstado, -2, -1, -2))).addComponent(this.JLB_NumeroRegistro, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jpFiltroSexo, -2, -1, -2)).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaAgenda1, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JSDias, GroupLayout.Alignment.TRAILING, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFBuscar, -2, 60, -2))).addContainerGap()));
        this.JSP_AgendaServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_AgendaServicios.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaServicios.setRowHeight(30);
        this.JTB_AgendaServicios.setSelectionMode(0);
        this.JTB_AgendaServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.16
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JTB_AgendaServiciosMouseClicked(evt);
            }
        });
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        GroupLayout JPI_ServiciosLayout = new GroupLayout(this.JPI_Servicios);
        this.JPI_Servicios.setLayout(JPI_ServiciosLayout);
        JPI_ServiciosLayout.setHorizontalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JSP_AgendaServicios).addGap(2, 2, 2)).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -1, -1, 32767).addContainerGap()))));
        JPI_ServiciosLayout.setVerticalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_AgendaServicios, -2, 534, -2).addContainerGap(11, 32767)));
        this.JBT_Campana.setFont(new Font("Arial", 1, 12));
        this.JBT_Campana.setForeground(Color.red);
        this.JBT_Campana.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana_alerta.gif")));
        this.JBT_Campana.setHorizontalTextPosition(0);
        this.JBT_Campana.setVerticalTextPosition(3);
        this.JBT_Campana.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.17
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeriaV2.this.JBT_CampanaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPI_Servicios, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Campana, -2, 68, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPI_Servicios, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JBT_Campana, -2, 77, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTB_AgendaServicios.getSelectedRow() != -1) {
            inicializarDatosClaseInformacionAgendaServicios(this.JTB_AgendaServicios.getSelectedRow());
            this.EstadoTarea.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 0;
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 1;
        crearTablaAgendaServicio();
        this.JLB_NumeroRegistro.setText("0");
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ObservacionActionPerformed(ActionEvent evt) {
        this.filtroAtencion = "2,3";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_InterconsultaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFBuscar.getText().isEmpty()) {
            crearTablaAgendaServicio();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
        if (this.esLlenoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbFemeninoActionPerformed(ActionEvent evt) {
        this.sexo.clear();
        this.sexo.add(this.jrbFemenino.getText());
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbMasculinoActionPerformed(ActionEvent evt) {
        this.sexo.clear();
        this.sexo.add(this.jrbMasculino.getText());
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbAmbosActionPerformed(ActionEvent evt) {
        this.sexo.clear();
        this.sexo.add(this.jrbFemenino.getText());
        this.sexo.add(this.jrbMasculino.getText());
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        closeSseListeners();
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgenda1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSDiasMouseEntered(MouseEvent evt) {
        this.numeroDias = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CampanaActionPerformed(ActionEvent evt) {
        if (!this.JBT_Campana.getText().equals("0")) {
            cargarDatosOrdenamiento();
            JDDetalleOrdenamientoMedico ordenamientoMedico = new JDDetalleOrdenamientoMedico(null, true, this.ordenamientoMedico, Integer.valueOf(Integer.parseInt(this.idServicio[this.JCB_Servicio.getSelectedIndex()])));
            ordenamientoMedico.setLocationRelativeTo(this);
            ordenamientoMedico.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FSTodosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FSSeleccionActionPerformed(ActionEvent evt) {
    }

    private void inicializarDatosClaseInformacionAgendaServicios(int filaSeleccionada) {
        String noHistoria = this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 1).toString();
        Principal.claseenfer.xjifhc_uhh = new JIFHistoria_UH(noHistoria.substring(noHistoria.indexOf("-") + 1), this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 17).toString(), Integer.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]).intValue(), this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 18).toString(), Integer.valueOf(this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 15).toString()), "Agenda Servicios (Beta)");
        Principal.cargarPantalla(Principal.claseenfer.xjifhc_uhh);
        dispose();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    private void inicializarSseListener() {
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            System.out.println("antes");
            if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
                this.eventSubscriberDTOs = new ArrayList();
                RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("100", "notificacionesDeEventos");
                if (microserviciosDomain.getUrlRecurso() != null && !microserviciosDomain.getUrlRecurso().isEmpty()) {
                    this.sseListener = new SseListener(microserviciosDomain.getUrlRecurso());
                    this.sseListener.startListening();
                    System.out.println("entra microervicio");
                    this.eventSubscriberDTOs.add(this.sseListener.subscribe("ordenamientoMedico", data -> {
                        System.out.println("entra sucribe antes");
                        try {
                            new ArrayList();
                            List<OrdenamientoMedico> ordenamientoMedico1 = (List) this.metodos.getMapper().readValue(data, new TypeReference<List<OrdenamientoMedico>>() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.18
                            });
                            this.ordenamientoMedico = getOrdenamientoMedicoFiltrado(ordenamientoMedico1, Integer.parseInt(this.idServicio[this.JCB_Servicio.getSelectedIndex()]));
                            SwingUtilities.invokeLater(() -> {
                                this.JBT_Campana.setText("" + this.ordenamientoMedico.size());
                            });
                            System.out.println("entra sucribe");
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                    }));
                }
            }
        }
    }

    private List<OrdenamientoMedico> getOrdenamientoMedicoFiltrado(List<OrdenamientoMedico> dato, int idServicio) {
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            System.out.println(" lista " + dato.size());
            System.out.println(" servicio  " + idServicio);
            return (List) dato.stream().filter(ordenamientoMedico -> {
                return ordenamientoMedico.getIdServicio().equals(Integer.valueOf(idServicio));
            }).collect(Collectors.toList());
        }
        return null;
    }

    private void nuevo() {
        this.JDCFechaAgenda1.setDate(this.metodos.getFechaActual());
        this.sexo.clear();
        this.sexo.add(this.jrbFemenino.getText());
        this.sexo.add(this.jrbMasculino.getText());
        this.esLlenoCombo = false;
        LlenarComboServicio();
        this.esLlenoCombo = true;
        crearTablaAgendaServicio();
        cargarCantidadDatosOrdenamiento();
    }

    private void cargarDatosOrdenamiento() {
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JBT_Campana.setText("" + InformacionOrdenamientoMedico.getNumeroRegistro(false, Integer.parseInt(this.idServicio[this.JCB_Servicio.getSelectedIndex()])));
            this.ordenamientoMedico = InformacionOrdenamientoMedico.getOrdenamientoMedicoFiltrado(Integer.parseInt(this.idServicio[this.JCB_Servicio.getSelectedIndex()]));
        }
    }

    private void cargarCantidadDatosOrdenamiento() {
        this.JBT_Campana.setText("" + InformacionOrdenamientoMedico.getSoloCantidadNumeroRegistro(false, Integer.parseInt(this.idServicio[this.JCB_Servicio.getSelectedIndex()])));
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.19
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendaServicioEnfermeriaV2.this.EstadoTarea.get()) {
                    JIF_AgendaServicioEnfermeriaV2.this.cargarDatos();
                } else {
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "Usuario", "IdSexo", "Sexo", "Edad", "fechaNacimiento", "Triage", "Clase Cita", "idUsuario", "Tipo de Atencion", "Convenio", "clasificacionAtencionEspecialIcono", "Motivo Consulta", "Enfermedad Actual", "idTipoHistoria", "Profesional Asignado", "No Ingreso", "No Atencion", "Orden", "Orden Unidosis", "Especialidad Interconsulta", "IdTipoAtencion", "TipoGuardado", "clasificacionAtencionEspecialIcono", "idClaseCita", "fase", "Tiempo(Horas)"}) { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Long.class, String.class, String.class, Icon.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, Long.class, Integer.class, Integer.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_AgendaServicios.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2.21
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTB_AgendaServicios;
        JTable jTable2 = this.JTB_AgendaServicios;
        jTable.setAutoResizeMode(0);
        this.JTB_AgendaServicios.doLayout();
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
        this.JTB_AgendaServicios.getColumnModel().getColumn(8).setPreferredWidth(320);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTB_AgendaServicios.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(13).setMaxWidth(0);
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
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(21).setMaxWidth(0);
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
    }

    public void cargarDatos() {
        if (this.esLlenoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            cargarCantidadDatosOrdenamiento();
            List<AgendaHCDTO> listadoAtencionServicios = null;
            if (!this.idServicio[this.JCB_Servicio.getSelectedIndex()].equals("3")) {
                this.filtroAtencion = "2,3";
            }
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            }
            List<Integer> filtroServicio = new ArrayList<>();
            if (this.JRB_FSSeleccion.isSelected()) {
                filtroServicio.add(Integer.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]));
            } else {
                for (String idServicio1 : this.idServicio) {
                    filtroServicio.add(Integer.valueOf(idServicio1));
                }
            }
            if (this.estadoAtencion.intValue() == 0 || (this.estadoAtencion.intValue() == 1 && !this.JTFBuscar.getText().isEmpty())) {
                if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                        listadoAtencionServicios = this.AgendaService.listarPacientesEnObservacionEnfermeriaCompleta(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoAtencion, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)));
                    } else {
                        listadoAtencionServicios = this.AgendaService.listarPacientesEnObservacion(filtroServicio, Principal.sedeUsuarioSeleccionadaDTO.getId(), this.estadoAtencion, this.JTFBuscar.getText(), this.metodos.formatoAMD1.format(this.JDCFechaAgenda1.getDate()), Integer.valueOf(((Integer) this.JSDias.getValue()).intValue() * (-1)));
                    }
                    if (!this.numeroDias) {
                        if (Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
                            this.JSDias.setValue(30);
                        } else {
                            this.JSDias.setValue(2);
                        }
                    } else {
                        this.numeroDias = false;
                    }
                }
                if (listadoAtencionServicios != null) {
                    mCargaAgendaServiciosV2(listadoAtencionServicios);
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
        this.JSP_AgendaServicios.remove(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.setViewportView((Component) null);
        this.JSP_AgendaServicios.repaint();
        if (!listadoList.isEmpty()) {
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloServicio.addRow(this.datos);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaHoraIngreso(), i, 0);
                this.modeloServicio.setValueAt(listadoList.get(i).getDocumento(), i, 1);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreUsuario(), i, 2);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdSexo(), i, 3);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreSexo(), i, 4);
                this.modeloServicio.setValueAt(listadoList.get(i).getEdad(), i, 5);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaNacimiento(), i, 6);
                this.modeloServicio.setValueAt(listadoList.get(i).getTriage(), i, 7);
                this.modeloServicio.setValueAt(listadoList.get(i).getClaseCita(), i, 8);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuario(), i, 9);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoAtencion(), i, 10);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmpresaConvenio(), i, 11);
                if (null == listadoList.get(i).getClasificacionAtencionEspecial()) {
                    this.modeloServicio.setValueAt(new ImageIcon(""), i, 12);
                } else {
                    switch (listadoList.get(i).getClasificacionAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png")), i, 12);
                            break;
                        case 2:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png")), i, 12);
                            break;
                        case 3:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png")), i, 12);
                            break;
                        case 4:
                            this.modeloServicio.setValueAt(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png")), i, 12);
                            break;
                        default:
                            this.modeloServicio.setValueAt(new ImageIcon(""), i, 12);
                            break;
                    }
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getMotivoConsulta(), i, 13);
                this.modeloServicio.setValueAt(listadoList.get(i).getEnfermedadActual(), i, 14);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoHistoria(), i, 15);
                this.modeloServicio.setValueAt(listadoList.get(i).getProfesionalAsignado(), i, 16);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdIngreso(), i, 17);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdAtencion(), i, 18);
                if (listadoList.get(i).getAgendaOrdenes() == null || listadoList.get(i).getAgendaOrdenes().isEmpty()) {
                    this.modeloServicio.setValueAt(0, i, 19);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenes().get(0)).getIdOrden(), i, 19);
                }
                if (listadoList.get(i).getAgendaOrdenesUnidosis() == null || listadoList.get(i).getAgendaOrdenesUnidosis().isEmpty()) {
                    this.modeloServicio.setValueAt(0, i, 20);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenesUnidosis().get(0)).getIdOrden(), i, 20);
                }
                if (listadoList.get(i).getAgendaOrdenesInterconsulta() == null || listadoList.get(i).getAgendaOrdenesInterconsulta().isEmpty()) {
                    this.modeloServicio.setValueAt("", i, 21);
                } else {
                    this.modeloServicio.setValueAt(((AgendaOrdenesGenericoDTO) listadoList.get(i).getAgendaOrdenesInterconsulta().get(0)).getEspecialidad(), i, 21);
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoAtencion(), i, 22);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoGuardado(), i, 23);
                this.modeloServicio.setValueAt(listadoList.get(i).getClasificacionAtencionEspecial(), i, 24);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), i, 25);
                if (listadoList.get(i).getFase() == null) {
                    this.modeloServicio.setValueAt("", i, 26);
                } else if (isNumber(listadoList.get(i).getFase()) && listadoList.get(i).getIdTipoAtencion().longValue() > 1) {
                    int fase = Integer.parseInt(listadoList.get(i).getFase());
                    double valor = Math.floor(fase / 30) + 1.0d;
                    if (listadoList.get(i).getIdTipoAtencion().longValue() != 4) {
                        this.modeloServicio.setValueAt(fase + " días", i, 26);
                    } else if (valor > 6.0d) {
                        this.modeloServicio.setValueAt("Ha superado la fase 6  " + fase + " días", i, 26);
                    } else {
                        this.modeloServicio.setValueAt("fase " + valor + " -  " + fase + " días", i, 26);
                    }
                }
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), i, 25);
                if (listadoList.get(i).getHora() == null) {
                    this.modeloServicio.setValueAt(0, i, 27);
                } else {
                    this.modeloServicio.setValueAt(listadoList.get(i).getHora(), i, 27);
                }
                this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRender());
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

    private void mCargaAgendaServicios(List<InformacionAgendaMedicaDTO> listadoList) {
        Integer numero = 0;
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
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloServicio.addRow(this.datos);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), i, 0);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIngreso(), i, 1);
                this.modeloServicio.setValueAt(listadoList.get(i).getNumeroHistoria(), i, 2);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreUsuario(), i, 3);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdSexo(), i, 4);
                this.modeloServicio.setValueAt(listadoList.get(i).getEdad(), i, 5);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreEmpresaCovenio(), i, 6);
                this.modeloServicio.setValueAt(listadoList.get(i).getMotivoConsulta(), i, 7);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsAtencionEspecial(), i, 9);
                if (null == listadoList.get(i).getEsAtencionEspecial()) {
                    this.modeloServicio.setValueAt(new JLabel(""), i, 8);
                } else {
                    switch (listadoList.get(i).getEsAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), i, 8);
                            break;
                        case 2:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), i, 8);
                            break;
                        case 3:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), i, 8);
                            break;
                        case 4:
                            this.modeloServicio.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), i, 8);
                            break;
                        default:
                            this.modeloServicio.setValueAt(new JLabel(""), i, 8);
                            break;
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(JLabel.class, new Render(listadoList.get(i).getEsAtencionEspecial().intValue(), 9));
                this.modeloServicio.setValueAt(listadoList.get(i).getClasificacionTriage(), i, 10);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreTipoConsulta(), i, 11);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraIncial(), i, 12);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoTextoAtencion(), i, 13);
                this.modeloServicio.setValueAt(listadoList.get(i).getNombreSexo(), i, 14);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaNacimiento(), i, 15);
                this.modeloServicio.setValueAt(listadoList.get(i).getHoraFinal(), i, 16);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioAtendido(), i, 17);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdIngreso(), i, 18);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdClaseCita(), i, 19);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipohc(), i, 20);
                this.modeloServicio.setValueAt(listadoList.get(i).getAsistida(), i, 21);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdCita(), i, 22);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdAtencion(), i, 23);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoCita(), i, 24);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsRemitada(), i, 25);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdPrograma(), i, 26);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsSaludOcupacional(), i, 27);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControl(), i, 28);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsOdontologica(), i, 29);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTratamiento(), i, 30);
                this.modeloServicio.setValueAt(listadoList.get(i).getCama(), i, 31);
                this.modeloServicio.setValueAt(listadoList.get(i).getEnfermedadActual(), i, 32);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsPeriodico(), i, 33);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsControlHistoria(), i, 34);
                this.modeloServicio.setValueAt(listadoList.get(i).getFechaIngreso(), i, 35);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoAtencion(), i, 36);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoAtencion(), i, 37);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailUsuario(), i, 38);
                this.modeloServicio.setValueAt(listadoList.get(i).getEmailsupervisor(), i, 39);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdTipoEmpresa(), i, 40);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdParentesco(), i, 41);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoCita(), i, 42);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoGuardado(), i, 43);
                this.modeloServicio.setValueAt(listadoList.get(i).getFecha_HoraAtencion(), i, 44);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdUsuarioPrograma(), i, 45);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdOrden(), i, 46);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdProcedimiento(), i, 47);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdServicio(), i, 48);
                this.modeloServicio.setValueAt(listadoList.get(i).getIdManPower(), i, 49);
                this.modeloServicio.setValueAt(listadoList.get(i).getFiltradoAgenda(), i, 50);
                this.modeloServicio.setValueAt(listadoList.get(i).getExpandirHistoria(), i, 51);
                this.modeloServicio.setValueAt(listadoList.get(i).getTipoTratamiento(), i, 52);
                this.modeloServicio.setValueAt(listadoList.get(i).getEsTriage(), i, 53);
                this.modeloServicio.setValueAt(listadoList.get(i).getFormaHistoria(), i, 54);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoUsuarioUrgencias(), i, 55);
                this.modeloServicio.setValueAt(listadoList.get(i).getEspecialidadInterconsulta(), i, 56);
                this.modeloServicio.setValueAt(listadoList.get(i).getEstadoOrdenMedica(), i, 57);
                this.modeloServicio.setValueAt(listadoList.get(i).getHora(), i, 59);
                if (isNumber(listadoList.get(i).getFase()) && listadoList.get(i).getIdTipoAtencion().intValue() > 1) {
                    int fase = Integer.parseInt(listadoList.get(i).getFase());
                    double valor = Math.floor(fase / 30) + 1.0d;
                    if (listadoList.get(i).getIdTipoAtencion().intValue() != 4) {
                        this.modeloServicio.setValueAt(fase + " días", i, 58);
                    } else if (valor > 6.0d) {
                        this.modeloServicio.setValueAt("Ha superado la fase 6  " + fase + " días", i, 58);
                    } else {
                        this.modeloServicio.setValueAt("fase " + valor + " -  " + fase + " días", i, 58);
                    }
                }
                this.JTB_AgendaServicios.setDefaultRenderer(Object.class, new MiRender());
                numero = Integer.valueOf(numero.intValue() + 1);
            }
            this.modeloServicio.setRowCount(listadoList.size());
            this.modeloServicio.fireTableDataChanged();
        }
        this.JLB_NumeroRegistro.setText("" + numero);
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        this.JSP_AgendaServicios.repaint();
    }

    public boolean isNumber(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeriaV2$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 19).toString()).intValue() != 0 || Integer.valueOf(table.getValueAt(row, 20).toString()).intValue() != 0) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeriaV2$MyTreeCellRenderer.class */
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
        List<Object[]> listServicio = this.informacionVariaUrgenciasHospitalizacionDAO.listadoServiciosEnfermeria();
        if (!listServicio.isEmpty()) {
            this.idServicio = new String[listServicio.size()];
            for (int i = 0; i < listServicio.size(); i++) {
                this.idServicio[i] = String.valueOf(listServicio.get(i)[0]);
                this.JCB_Servicio.addItem(listServicio.get(i)[1].toString());
            }
            this.JCB_Servicio.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreServicio());
        }
    }
}
