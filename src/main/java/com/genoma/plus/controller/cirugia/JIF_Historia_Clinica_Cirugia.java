package com.genoma.plus.controller.cirugia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import Utilidades.SwingworkeTableModel_AgendaServicio;
import com.genoma.plus.controller.historia.FuncionalidadPanelHistoriaClinica;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/cirugia/JIF_Historia_Clinica_Cirugia.class */
public class JIF_Historia_Clinica_Cirugia extends JInternalFrame implements Runnable {
    private HistoriaDAO historiaDAO;
    public FuncionalidadPanelHistoriaClinica funcionalidadPanelHistoriaClinica;
    private DefaultTableModel modeloModel;
    private DefaultTableModel modeloCitasNPModel;
    private DefaultTableModel modeloServicio;
    private Thread hilo;
    private InformacionVariaUrgenciasHospitalizacionDAO informacionVariaUrgenciasHospitalizacionDAO;
    private String[] idServicio;
    private ButtonGroup JBG_Filtrado;
    private ButtonGroup JBG_FiltroEstado;
    private ButtonGroup JBG_FiltroEstadoAtencion;
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
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_U;
    private JScrollPane JSP_AgendaServicios;
    private JScrollPane JSP_Datos1;
    private JScrollPane JSP_Datos2;
    private JTable JTB_AgendaServicios;
    private JTabbedPane JTP_Informacion;
    private JTree JTree_Atencion;
    private DefaultTreeModel modelo = null;
    private String filtroEstado = "1";
    private Metodos metodos = new Metodos();
    private Boolean esLlenoCombo = false;
    private Boolean estadoHilo = true;
    private Vector<ConfiguracionItems> listadoItemsCargados = new Vector<>();
    private Integer estadoAtencion = 0;
    private Integer filtroAtencion = 0;

    public JIF_Historia_Clinica_Cirugia() {
        initComponents();
        springStart();
        inicioInformacionHistoria();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JBG_FiltroEstadoAtencion = new ButtonGroup();
        this.JTP_Informacion = new JTabbedPane();
        this.JPI_Servicios = new JPanel();
        this.JPI_Filtro = new JPanel();
        this.JCB_Servicio = new JComboBox<>();
        this.JCH_PorClasificar = new JCheckBox();
        this.JCH_Observacion = new JCheckBox();
        this.JCH_Clasificado = new JCheckBox();
        this.JCH_Interconsulta = new JCheckBox();
        this.JPIEstado = new JPanel();
        this.JRBEnAtencion_U = new JRadioButton();
        this.JRBDeAlta_U = new JRadioButton();
        this.JLB_NumeroRegistro = new JLabel();
        this.JSP_AgendaServicios = new JScrollPane();
        this.JTB_AgendaServicios = new JTable();
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
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.formInternalFrameClosed(evt);
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
        this.JTP_Informacion.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.2
            public void stateChanged(ChangeEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JTP_InformacionStateChanged(evt);
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
        this.JCH_PorClasificar.setText("Por Ingresar");
        this.JCH_PorClasificar.setOpaque(true);
        this.JCH_PorClasificar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JCH_PorClasificarActionPerformed(evt);
            }
        });
        this.JCH_Observacion.setBackground(Color.orange);
        this.JBG_FiltroEstado.add(this.JCH_Observacion);
        this.JCH_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Observacion.setText("Observación");
        this.JCH_Observacion.setOpaque(true);
        this.JCH_Observacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JCH_ObservacionActionPerformed(evt);
            }
        });
        this.JCH_Clasificado.setBackground(new Color(133, 218, 160));
        this.JBG_FiltroEstado.add(this.JCH_Clasificado);
        this.JCH_Clasificado.setFont(new Font("Arial", 1, 12));
        this.JCH_Clasificado.setText("Clasificado");
        this.JCH_Clasificado.setOpaque(true);
        this.JCH_Clasificado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JCH_ClasificadoActionPerformed(evt);
            }
        });
        this.JCH_Interconsulta.setBackground(Color.pink);
        this.JBG_FiltroEstado.add(this.JCH_Interconsulta);
        this.JCH_Interconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_Interconsulta.setText("Interconsulta");
        this.JCH_Interconsulta.setOpaque(true);
        this.JCH_Interconsulta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JCH_InterconsultaActionPerformed(evt);
            }
        });
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBG_FiltroEstadoAtencion.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JRBEnAtencion_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JRBEnAtencion_UActionPerformed(evt);
            }
        });
        this.JBG_FiltroEstadoAtencion.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        this.JRBDeAlta_U.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JRBDeAlta_UActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JLB_NumeroRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NumeroRegistro.setHorizontalAlignment(0);
        this.JLB_NumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JCB_Servicio, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH_PorClasificar, -1, -1, 32767).addComponent(this.JCH_Clasificado, -2, 110, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Observacion).addComponent(this.JCH_Interconsulta)).addGap(18, 18, 18).addComponent(this.JLB_NumeroRegistro, -2, 127, -2).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_PorClasificar).addComponent(this.JCH_Observacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Clasificado).addComponent(this.JCH_Interconsulta))).addComponent(this.JPIEstado, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCB_Servicio, GroupLayout.Alignment.LEADING).addComponent(this.JLB_NumeroRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(20, 32767)));
        this.JSP_AgendaServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_AgendaServicios.setFont(new Font("Arial", 1, 12));
        this.JTB_AgendaServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_AgendaServicios.setRowHeight(30);
        this.JTB_AgendaServicios.setSelectionMode(0);
        this.JTB_AgendaServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.9
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JTB_AgendaServiciosMouseClicked(evt);
            }
        });
        this.JSP_AgendaServicios.setViewportView(this.JTB_AgendaServicios);
        GroupLayout JPI_ServiciosLayout = new GroupLayout(this.JPI_Servicios);
        this.JPI_Servicios.setLayout(JPI_ServiciosLayout);
        JPI_ServiciosLayout.setHorizontalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI_ServiciosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -1, -1, 32767)).addComponent(this.JSP_AgendaServicios, -2, 1106, -2)).addGap(0, 16, 32767)));
        JPI_ServiciosLayout.setVerticalGroup(JPI_ServiciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ServiciosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_AgendaServicios, -1, 580, 32767).addGap(17, 17, 17)));
        this.JTP_Informacion.addTab("SERVICIOS", this.JPI_Servicios);
        this.JPS_PanelHistoria.setDividerSize(15);
        this.JPS_PanelHistoria.setResizeWeight(0.1d);
        this.JPS_PanelHistoria.setOneTouchExpandable(true);
        this.JSP_Datos1.setMinimumSize(new Dimension(80, 80));
        this.JSP_Datos1.setPreferredSize(new Dimension(200, 200));
        this.JTree_Atencion.setFont(new Font("Arial", 1, 12));
        this.JTree_Atencion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.10
            public void mouseClicked(MouseEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JTree_AtencionMouseClicked(evt);
            }
        });
        this.JTree_Atencion.addTreeSelectionListener(new TreeSelectionListener() { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.11
            public void valueChanged(TreeSelectionEvent evt) {
                JIF_Historia_Clinica_Cirugia.this.JTree_AtencionValueChanged(evt);
            }
        });
        this.JSP_Datos1.setViewportView(this.JTree_Atencion);
        this.JPS_PanelHistoria.setLeftComponent(this.JSP_Datos1);
        this.JSP_Datos2.setHorizontalScrollBarPolicy(31);
        this.JSP_Datos2.setPreferredSize(new Dimension(804, 504));
        this.JPI_PanelPrincipal.setPreferredSize(new Dimension(800, 500));
        GroupLayout JPI_PanelPrincipalLayout = new GroupLayout(this.JPI_PanelPrincipal);
        this.JPI_PanelPrincipal.setLayout(JPI_PanelPrincipalLayout);
        JPI_PanelPrincipalLayout.setHorizontalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 869, 32767));
        JPI_PanelPrincipalLayout.setVerticalGroup(JPI_PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 692, 32767));
        this.JSP_Datos2.setViewportView(this.JPI_PanelPrincipal);
        this.JPS_PanelHistoria.setRightComponent(this.JSP_Datos2);
        GroupLayout JPI_HistoriaLayout = new GroupLayout(this.JPI_Historia);
        this.JPI_Historia.setLayout(JPI_HistoriaLayout);
        JPI_HistoriaLayout.setHorizontalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPS_PanelHistoria, -1, 1097, 32767).addContainerGap()));
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
            if (ultimoNodo.isLeaf()) {
                if (validacionPanel(1)) {
                    consultarEstadoItems(ultimoNodo.getUserObject().toString(), 0, false);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Faltan campos por diligencias;<br>por favor revisar!!!</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                this.JPI_PanelPrincipal.removeAll();
            }
            seleccionarItemArbol();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_InformacionStateChanged(ChangeEvent evt) {
        if (this.esLlenoCombo.booleanValue()) {
            if (this.JTP_Informacion.getSelectedIndex() == 0) {
                this.listadoItemsCargados = new Vector<>();
                this.estadoHilo = true;
                iniciarHilo();
                return;
            }
            this.estadoHilo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        this.estadoHilo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AgendaServiciosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTB_AgendaServicios.getSelectedRow() != -1) {
            inicializarDatosClaseInformacionAgendaServicios(this.JTB_AgendaServicios, this.JTB_AgendaServicios.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ClasificadoActionPerformed(ActionEvent evt) {
        this.filtroAtencion = 1;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 0;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_UActionPerformed(ActionEvent evt) {
        this.estadoAtencion = 1;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PorClasificarActionPerformed(ActionEvent evt) {
        this.filtroAtencion = 0;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ObservacionActionPerformed(ActionEvent evt) {
        this.filtroAtencion = 2;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_InterconsultaActionPerformed(ActionEvent evt) {
        this.filtroAtencion = 3;
        iniciarHilo();
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
                    if (this.JPI_PanelPrincipal.getComponent(0).getName().equals(elementAt.getNombreFormulario())) {
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

    public void consultarEstadoItems(String nombreItem, Integer formaAplicacion, Boolean estado) {
        for (int i = 0; i < this.listadoItemsCargados.size(); i++) {
            ConfiguracionItems elementAt = this.listadoItemsCargados.elementAt(i);
            if (formaAplicacion.intValue() == 0) {
                if (nombreItem.equals(elementAt.getNombre())) {
                    this.funcionalidadPanelHistoriaClinica.cargarPanel(elementAt.getNombreFormulario(), this.JPI_PanelPrincipal, this, elementAt.getNombre(), 1);
                }
            } else if (formaAplicacion.intValue() == 1 && nombreItem.equals(elementAt.getNombreFormulario())) {
                elementAt.setValidadoCompleto(estado);
            }
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
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 9).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(jTable.getValueAt(filaSeleccionada, 10).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(jTable.getValueAt(filaSeleccionada, 11).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraFinal(jTable.getValueAt(filaSeleccionada, 12).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 13).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 14).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 15).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 16).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setAsistida(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 17).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 18).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(jTable.getValueAt(filaSeleccionada, 19).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 20).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 21).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 22).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 23).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 24).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 25).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 26).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(jTable.getValueAt(filaSeleccionada, 27).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(jTable.getValueAt(filaSeleccionada, 28).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 29).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 30).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(jTable.getValueAt(filaSeleccionada, 31).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 32).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 33).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailUsuario(jTable.getValueAt(filaSeleccionada, 34).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailsupervisor(jTable.getValueAt(filaSeleccionada, 35).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoEmpresa(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 36).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdParentesco(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 37).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 38).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 39).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(jTable.getValueAt(filaSeleccionada, 40).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 41).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 42).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 43).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdServicio(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 44).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 45).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFiltradoAgenda(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 46).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setExpandirHistoria(Boolean.valueOf(jTable.getValueAt(filaSeleccionada, 47).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 48).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 49).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 50).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(new Long(0L));
        this.historiaDAO.actualizarFechaHoraAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        inicioInformacionHistoria();
        this.JTP_Informacion.setSelectedIndex(2);
        configuracionPanel();
    }

    private void inicializarDatosClaseInformacionAgendaServicios(JTable jTable, int filaSeleccionada) {
        this.listadoItemsCargados = new Vector<>();
        jTable.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(jTable.getValueAt(filaSeleccionada, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(jTable.getValueAt(filaSeleccionada, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(jTable.getValueAt(filaSeleccionada, 5).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(jTable.getValueAt(filaSeleccionada, 4).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(jTable.getValueAt(filaSeleccionada, 4).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(jTable.getValueAt(filaSeleccionada, 11).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraIncial(jTable.getValueAt(filaSeleccionada, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEstadoTextoAtencion(jTable.getValueAt(filaSeleccionada, 13).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(jTable.getValueAt(filaSeleccionada, 6).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 9).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(jTable.getValueAt(filaSeleccionada, 15).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setHoraFinal(jTable.getValueAt(filaSeleccionada, 12).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 17).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 18).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 19).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 20).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setAsistida(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 21).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 22).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(jTable.getValueAt(filaSeleccionada, 23).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 24).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 25).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 26).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 27).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 28).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 29).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 30).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(jTable.getValueAt(filaSeleccionada, 7).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(jTable.getValueAt(filaSeleccionada, 32).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 33).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsControl(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 34).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(jTable.getValueAt(filaSeleccionada, 35).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 36).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 37).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailUsuario(jTable.getValueAt(filaSeleccionada, 38).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEmailsupervisor(jTable.getValueAt(filaSeleccionada, 39).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoEmpresa(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 40).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdParentesco(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 41).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 42).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 43).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(jTable.getValueAt(filaSeleccionada, 44).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 45).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 46).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 47).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdServicio(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 48).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 49).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFiltradoAgenda(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 50).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setExpandirHistoria(Boolean.valueOf(jTable.getValueAt(filaSeleccionada, 51).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(Long.valueOf(Long.parseLong(jTable.getValueAt(filaSeleccionada, 52).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 53).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(Integer.valueOf(Integer.parseInt(jTable.getValueAt(filaSeleccionada, 54).toString())));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(new Long(0L));
        this.historiaDAO.actualizarFechaHoraAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        inicioInformacionHistoria();
        this.JTP_Informacion.setSelectedIndex(1);
        configuracionPanel();
    }

    private void configuracionPanel() {
        if (this.JTP_Informacion.getSelectedIndex() == 1) {
            this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "  EDAD: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "  SEXO: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "  TIPO CONSULTA : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta(), 0, 0, new Font("Arial", 1, 10), Color.red));
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
        List<ConfiguracionItems> informacionItemsHistoria = this.historiaDAO.listaItemsPorIdHistoria(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
        if (!informacionItemsHistoria.isEmpty()) {
            DefaultMutableTreeNode rama = null;
            for (int i = 0; i < informacionItemsHistoria.size(); i++) {
                System.out.println("" + informacionItemsHistoria.get(i).getIdPadre());
                System.out.println("" + informacionItemsHistoria.get(i).getUltimoNivel());
                if (informacionItemsHistoria.get(i).getIdPadre().longValue() == 0 && informacionItemsHistoria.get(i).getUltimoNivel().booleanValue()) {
                    rama = new DefaultMutableTreeNode(informacionItemsHistoria.get(i).getNombre());
                } else if (informacionItemsHistoria.get(i).getIdPadre().longValue() != 0 && informacionItemsHistoria.get(i).getUltimoNivel().booleanValue()) {
                    this.JTree_Atencion.getCellRenderer();
                    DefaultMutableTreeNode hojasNodo = new DefaultMutableTreeNode(informacionItemsHistoria.get(i).getNombre());
                    rama.add(hojasNodo);
                    this.listadoItemsCargados.add(informacionItemsHistoria.get(i));
                    List<ConfiguracionItems> informacionItemsHistoriaHijos = this.historiaDAO.listaItemsPorIdPadre(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), informacionItemsHistoria.get(i).getId(), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
                    if (!informacionItemsHistoriaHijos.isEmpty()) {
                        for (int j = 0; j < informacionItemsHistoriaHijos.size(); j++) {
                            DefaultMutableTreeNode hojasNodoHijo = new DefaultMutableTreeNode(informacionItemsHistoriaHijos.get(j).getNombre());
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

    private void nuevo() {
        this.esLlenoCombo = false;
        LlenarComboServicio();
        this.esLlenoCombo = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "Documento", "Usuario", "Sexo", "Edad", "Entidad", "Motivo Consulta", "CEspecial", "esAtencionEspecial", "Triage", "Tipo Consulta", "Hora", "Estado", "nombreSexo", "fechaNacimiento", "horaFinal", "idUsuarioAtendido", "idIngreso", "idClaseCita", "idTipohc", "asistida", "idCita", "idAtencion", "idTipoCita", "esRemitada", "idPrograma", "esSaludOcupacional", "esControl", "esOdontologica", "idTratamiento", "Cama", "enfermedadActual", "esPeriodico", "esControlHistoria", "fechaIngreso", "idTipoAtencion", "TipoAtencion", "emailUsuario", "emailsupervisor", "idTipoEmpresa", "idParentesco", "tipoCita", "tipoGuardado", "fecha_HoraAtencion", "idUsuarioPrograma", "idOrden", "idProcedimiento", "idServicio", "idManPower", "filtradoAgenda", "expandirHistoria", "tipoTratamiento", "esTriage", "formaHistoria", "estadoUrgencias", "Especialidad Interconsulta"}) { // from class: com.genoma.plus.controller.cirugia.JIF_Historia_Clinica_Cirugia.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Long.class, Integer.class, Boolean.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.estadoHilo.booleanValue()) {
            List<InformacionAgendaMedicaDTO> listadoAtencionServicios = null;
            if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() != 382) {
                listadoAtencionServicios = this.historiaDAO.listadoAgendaServicioCirugia(Principal.sedeUsuarioSeleccionadaDTO.getId(), this.idServicio[this.JCB_Servicio.getSelectedIndex()], Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), this.estadoAtencion);
            }
            crearTablaAgendaServicio();
            SwingworkeTableModel_AgendaServicio agendaServicio = new SwingworkeTableModel_AgendaServicio(this.JTB_AgendaServicios, this.modeloServicio, listadoAtencionServicios, this.JLB_NumeroRegistro, 0);
            agendaServicio.execute();
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
            }
            System.out.println("Entro a la ejecucion del hilo");
        }
        System.out.println("supendido");
    }

    public void iniciarHilo() {
        this.hilo = new Thread(this);
        this.hilo.start();
        this.estadoHilo = true;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/cirugia/JIF_Historia_Clinica_Cirugia$MyTreeCellRenderer.class */
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
            this.JCB_Servicio.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreServicio());
        }
    }
}
