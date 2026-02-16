package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Enfermeria.JIFHistoria_UH;
import Laboratorio.Render;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.FuncionalidadPanelHistoriaClinica;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeria.class */
public final class JIF_AgendaServicioEnfermeria extends JInternalFrame {
    private HistoriaDAO historiaDAO;
    public FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
    private DefaultTableModel modeloServicio;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idServicio;
    private Object[] datos;
    private ButtonGroup JBG_Filtrado;
    private ButtonGroup JBG_FiltroEstado;
    private ButtonGroup JBG_FiltroEstadoAtencion;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_Interconsulta;
    private JCheckBox JCH_Observacion;
    private JLabel JLB_NumeroRegistro;
    private JPanel JPIEstado;
    private JPanel JPI_Filtro;
    private JPanel JPI_Servicios;
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_U;
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
    private String sexo = "";
    private Integer estadoEgreso = 0;
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public JIF_AgendaServicioEnfermeria() {
        initComponents();
        springStart();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        nuevo();
        ejecutarTareaTimer();
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.jrbMasculino.setVisible(false);
            this.jrbFemenino.setVisible(false);
            this.jpFiltroSexo.setVisible(false);
            this.jrbAmbos.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JBG_FiltroEstadoAtencion = new ButtonGroup();
        this.jbgFiltroSexo = new ButtonGroup();
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
        this.JSP_AgendaServicios = new JScrollPane();
        this.JTB_AgendaServicios = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA SERVICIOS ENFERMERIA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_historiaclinicav2");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIF_AgendaServicioEnfermeria.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_AgendaServicioEnfermeria.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendaServicioEnfermeria.this.formInternalFrameClosing(evt);
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
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.3
            public void itemStateChanged(ItemEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_Observacion.setBackground(new Color(177, 251, 177));
        this.JBG_FiltroEstado.add(this.JCH_Observacion);
        this.JCH_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Observacion.setSelected(true);
        this.JCH_Observacion.setText("Observación");
        this.JCH_Observacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JCH_ObservacionActionPerformed(evt);
            }
        });
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JBG_FiltroEstado.add(this.JCH_Interconsulta);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Interconsulta");
        this.JCH_Interconsulta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JCH_InterconsultaActionPerformed(evt);
            }
        });
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroEstadoAtencion.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JRBEnAtencion_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.6
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JRBEnAtencion_UActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstadoAtencion.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        this.JRBDeAlta_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.7
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JRBDeAlta_UActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar No. Documento/Paciente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.8
            public void keyPressed(KeyEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JTFBuscarKeyPressed(evt);
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
        this.jrbFemenino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.9
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.jrbFemeninoActionPerformed(evt);
            }
        });
        this.jbgFiltroSexo.add(this.jrbMasculino);
        this.jrbMasculino.setFont(new Font("Arial", 1, 12));
        this.jrbMasculino.setText("M");
        this.jrbMasculino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.10
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.jrbMasculinoActionPerformed(evt);
            }
        });
        this.jbgFiltroSexo.add(this.jrbAmbos);
        this.jrbAmbos.setFont(new Font("Arial", 1, 12));
        this.jrbAmbos.setText("Ambos");
        this.jrbAmbos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.11
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaServicioEnfermeria.this.jrbAmbosActionPerformed(evt);
            }
        });
        GroupLayout jpFiltroSexoLayout = new GroupLayout(this.jpFiltroSexo);
        this.jpFiltroSexo.setLayout(jpFiltroSexoLayout);
        jpFiltroSexoLayout.setHorizontalGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpFiltroSexoLayout.createSequentialGroup().addContainerGap().addComponent(this.jrbFemenino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbMasculino).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbAmbos).addContainerGap(-1, 32767)));
        jpFiltroSexoLayout.setVerticalGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpFiltroSexoLayout.createSequentialGroup().addContainerGap().addGroup(jpFiltroSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbFemenino).addComponent(this.jrbMasculino).addComponent(this.jrbAmbos)).addContainerGap(-1, 32767)));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCB_Servicio, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jpFiltroSexo, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Observacion).addComponent(this.JCH_Interconsulta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NumeroRegistro, -2, 108, -2)).addComponent(this.JTFBuscar, -2, 1068, -2)).addGap(27, 27, 27)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCH_Observacion).addGap(4, 4, 4).addComponent(this.JCH_Interconsulta, -1, 27, 32767)).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIEstado, -1, -1, 32767).addComponent(this.JCB_Servicio, -1, 50, 32767)))).addComponent(this.JLB_NumeroRegistro, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.jpFiltroSexo, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFBuscar, -2, 60, -2).addContainerGap()));
        this.JSP_AgendaServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_AgendaServicios.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaServicios.setRowHeight(30);
        this.JTB_AgendaServicios.setSelectionMode(0);
        this.JTB_AgendaServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.12
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaServicioEnfermeria.this.JTB_AgendaServiciosMouseClicked(evt);
            }
        });
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        GroupLayout JPI_ServiciosLayout = new GroupLayout(this.JPI_Servicios);
        this.JPI_Servicios.setLayout(JPI_ServiciosLayout);
        JPI_ServiciosLayout.setHorizontalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSP_AgendaServicios)).addGap(2, 2, 2)));
        JPI_ServiciosLayout.setVerticalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_AgendaServicios, -2, 534, -2).addContainerGap(17, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPI_Servicios, -2, -1, -2).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Servicios, -2, -1, -2).addContainerGap(-1, 32767)));
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
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
            this.estadoEgreso = 0;
        }
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 1;
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
            this.estadoEgreso = 1;
        }
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
        this.sexo = this.jrbFemenino.getText();
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbMasculinoActionPerformed(ActionEvent evt) {
        this.sexo = this.jrbMasculino.getText();
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbAmbosActionPerformed(ActionEvent evt) {
        this.sexo = "";
        crearTablaAgendaServicio();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
    }

    private void inicializarDatosClaseInformacionAgendaServicios(int filaSeleccionada) {
        Principal.claseenfer.xjifhc_uhh = new JIFHistoria_UH(this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 2).toString(), this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 18).toString(), Integer.valueOf(this.idServicio[this.JCB_Servicio.getSelectedIndex()]).intValue(), this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 23).toString(), Integer.valueOf(this.JTB_AgendaServicios.getValueAt(filaSeleccionada, 20).toString()), "Agenda Servicios");
        Principal.cargarPantalla(Principal.claseenfer.xjifhc_uhh);
        dispose();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    private void nuevo() {
        this.esLlenoCombo = false;
        LlenarComboServicio();
        this.esLlenoCombo = true;
        crearTablaAgendaServicio();
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIF_AgendaServicioEnfermeria.this.EstadoTarea.get()) {
                    JIF_AgendaServicioEnfermeria.this.cargarDatos();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Servicios de Enfermeria");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "Documento", "Usuario", "Sexo", "Edad", "Entidad", "Motivo Consulta", "CEspecial", "esAtencionEspecial", "Triage", "Tipo Consulta", "Hora", "Estado", "nombreSexo", "fechaNacimiento", "horaFinal", "idUsuarioAtendido", "idIngreso", "idClaseCita", "idTipohc", "asistida", "idCita", "idAtencion", "idTipoCita", "esRemitada", "idPrograma", "esSaludOcupacional", "esControl", "esOdontologica", "idTratamiento", "Cama", "enfermedadActual", "esPeriodico", "esControlHistoria", "fechaIngreso", "idTipoAtencion", "TipoAtencion", "emailUsuario", "emailsupervisor", "idTipoEmpresa", "idParentesco", "tipoCita", "tipoGuardado", "fecha_HoraAtencion", "idUsuarioPrograma", "idOrden", "idProcedimiento", "idServicio", "idManPower", "filtradoAgenda", "expandirHistoria", "tipoTratamiento", "esTriage", "formaHistoria", "estadoUrgencias", "Especialidad Interconsulta", "EstadoOrden", "Fase", "Tiempo(Hora)"}) { // from class: com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Boolean.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_AgendaServicios;
        JTable jTable2 = this.JTB_AgendaServicios;
        jTable.setAutoResizeMode(0);
        this.JTB_AgendaServicios.doLayout();
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
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(10).setMaxWidth(0);
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
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(57).setMaxWidth(0);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTB_AgendaServicios.getColumnModel().getColumn(5).setPreferredWidth(50);
            this.JTB_AgendaServicios.getColumnModel().getColumn(6).setPreferredWidth(150);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(8).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(18).setPreferredWidth(70);
            this.JTB_AgendaServicios.getColumnModel().getColumn(23).setPreferredWidth(70);
            this.JTB_AgendaServicios.getColumnModel().getColumn(33).setPreferredWidth(50);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setPreferredWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setMinWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(56).setMaxWidth(0);
            this.JTB_AgendaServicios.getColumnModel().getColumn(58).setPreferredWidth(80);
            this.JTB_AgendaServicios.getColumnModel().getColumn(59).setPreferredWidth(100);
            this.JTB_AgendaServicios.getColumnModel().getColumn(59).setMinWidth(100);
            this.JTB_AgendaServicios.getColumnModel().getColumn(59).setMaxWidth(100);
            return;
        }
        this.JTB_AgendaServicios.getColumnModel().getColumn(58).setPreferredWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(58).setMinWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(58).setMaxWidth(0);
        this.JTB_AgendaServicios.getColumnModel().getColumn(59).setPreferredWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(59).setMinWidth(100);
        this.JTB_AgendaServicios.getColumnModel().getColumn(59).setMaxWidth(100);
    }

    public void cargarDatos() {
        List<InformacionAgendaMedicaDTO> listadoAtencionServicios;
        if (this.esLlenoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            if (!this.idServicio[this.JCB_Servicio.getSelectedIndex()].equals("3")) {
                this.filtroAtencion = "2,3";
            }
            int aplicaInterconsulta = 1;
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                aplicaInterconsulta = 0;
            }
            if (this.estadoAtencion.intValue() == 0 || (this.estadoAtencion.intValue() == 1 && !this.JTFBuscar.getText().isEmpty())) {
                if ((Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) && (this.jrbFemenino.isSelected() || this.jrbMasculino.isSelected())) {
                    listadoAtencionServicios = this.historiaDAO.listadoAgendaServicioFiltroSexo(Principal.sedeUsuarioSeleccionadaDTO.getId(), this.idServicio[this.JCB_Servicio.getSelectedIndex()], this.filtroAtencion, this.estadoAtencion, this.JTFBuscar.getText(), this.sexo);
                } else {
                    listadoAtencionServicios = this.historiaDAO.listadoAgendaServicioObservacion(Principal.sedeUsuarioSeleccionadaDTO.getId(), this.idServicio[this.JCB_Servicio.getSelectedIndex()], this.filtroAtencion, this.estadoAtencion, this.JTFBuscar.getText(), aplicaInterconsulta, this.estadoEgreso, 3, this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
                }
                mCargaAgendaServicios(listadoAtencionServicios);
            }
        }
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeria$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 57) != null) {
                if (Boolean.valueOf(table.getValueAt(row, 57).toString()).booleanValue()) {
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIF_AgendaServicioEnfermeria$MyTreeCellRenderer.class */
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
