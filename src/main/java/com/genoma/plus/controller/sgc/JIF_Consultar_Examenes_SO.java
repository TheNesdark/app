package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Historia.JPSo_Concepto_I;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.FuncionalidadPanelHistoriaClinica;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.InformacionVariaUrgenciasHospitalizacionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionVariaUrgenciasHospitalizacionDAOImpl;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import com.genoma.plus.jpa.projection.CnsultarExamanesProjection;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.IngresoService;
import com.genoma.plus.jpa.service.LlamadasService;
import com.genoma.plus.jpa.service.UsuarioPorProgramaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consultar_Examenes_SO.class */
public final class JIF_Consultar_Examenes_SO extends JInternalFrame {
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
    private List<CnsultarExamanesProjection> list;
    private final IngresoService ingresoService;
    private Object[] datos;
    private ButtonGroup JBG_Filtrado;
    private JButton JBTExportar;
    public JDateChooser JDCFecha3;
    private JPanel JPIDatosB3;
    private JPanel JPI_Utilizades;
    private JScrollPane JSP_Datos;
    private JTable JTBDatosAgenda;
    private JFormattedTextField JTFNdocumento;
    private JFormattedTextField JTFNombre;
    private JTextField JTFRuta;
    private JPanel jPanel1;
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

    public JIF_Consultar_Examenes_SO() {
        initComponents();
        springStart();
        this.funcionalidadPanelHistoriaClinica = new FuncionalidadPanelHistoriaClinica();
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtrado = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPIDatosB3 = new JPanel();
        this.JDCFecha3 = new JDateChooser();
        this.JTFNdocumento = new JFormattedTextField();
        this.JTFNombre = new JFormattedTextField();
        this.JSP_Datos = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JPI_Utilizades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR EXAMENES SALUD OCUPACIONAL");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_historiaclinicav3");
        addContainerListener(new ContainerAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.1
            public void componentRemoved(ContainerEvent evt) {
                JIF_Consultar_Examenes_SO.this.formComponentRemoved(evt);
            }
        });
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.2
            public void ancestorRemoved(AncestorEvent evt) {
                JIF_Consultar_Examenes_SO.this.formAncestorRemoved(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.3
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_Consultar_Examenes_SO.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_Consultar_Examenes_SO.this.formInternalFrameClosed(evt);
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
        this.JPIDatosB3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDCFecha3.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha3.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha3.setFont(new Font("Arial", 1, 12));
        this.JDCFecha3.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_Examenes_SO.this.JDCFecha3PropertyChange(evt);
            }
        });
        this.JTFNdocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNdocumento.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFNdocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNdocumento.setName("hora");
        this.JTFNdocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.5
            public void keyPressed(KeyEvent evt) {
                JIF_Consultar_Examenes_SO.this.JTFNdocumentoKeyPressed(evt);
            }
        });
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setName("hora");
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.6
            public void keyPressed(KeyEvent evt) {
                JIF_Consultar_Examenes_SO.this.JTFNombreKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosB3Layout = new GroupLayout(this.JPIDatosB3);
        this.JPIDatosB3.setLayout(JPIDatosB3Layout);
        JPIDatosB3Layout.setHorizontalGroup(JPIDatosB3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosB3Layout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha3, -2, 115, -2).addGap(41, 41, 41).addComponent(this.JTFNdocumento, -2, 277, -2).addGap(35, 35, 35).addComponent(this.JTFNombre, -2, 230, -2).addContainerGap(-1, 32767)));
        JPIDatosB3Layout.setVerticalGroup(JPIDatosB3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosB3Layout.createSequentialGroup().addGroup(JPIDatosB3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFecha3, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(JPIDatosB3Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosB3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre).addComponent(this.JTFNdocumento)))).addGap(26, 26, 26)));
        this.JSP_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDatosAgenda.setAutoResizeMode(0);
        this.JTBDatosAgenda.setRowHeight(25);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(Color.red);
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JSP_Datos.setViewportView(this.JTBDatosAgenda);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosB3, -1, -1, 32767).addComponent(this.JSP_Datos));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPIDatosB3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Datos, -2, 285, -2).addContainerGap(-1, 32767)));
        this.JPI_Utilizades.setForeground(Color.red);
        GroupLayout JPI_UtilizadesLayout = new GroupLayout(this.JPI_Utilizades);
        this.JPI_Utilizades.setLayout(JPI_UtilizadesLayout);
        JPI_UtilizadesLayout.setHorizontalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 401, 32767));
        JPI_UtilizadesLayout.setVerticalGroup(JPI_UtilizadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 67, 32767));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.7
            public void mouseClicked(MouseEvent evt) {
                JIF_Consultar_Examenes_SO.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_Examenes_SO.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 408, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Utilizades, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Utilizades, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2))).addContainerGap()));
        pack();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formComponentRemoved(ContainerEvent evt) {
    }

    private void btnAtendidas1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFecha3PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNdocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarIngreso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBDatosAgenda.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDatosAgenda, this.metodos.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarIngreso();
        }
    }

    private void buscarIngreso() {
        mCrearModeloTabla();
        this.list = new ArrayList();
        this.list = this.ingresoService.ListarExamnesSaludOcupacional(this.metodos.formatoAMD.format(this.JDCFecha3.getDate()), this.JTFNdocumento.getText(), this.JTFNdocumento.getText());
        System.out.println("" + this.list.size());
        if (this.list != null && !this.list.isEmpty()) {
            this.list.forEach(detalle -> {
                this.xmodelo.addRow(this.datos);
                this.JTBDatosAgenda.setValueAt(detalle.getFechaIngreso(), this.JTBDatosAgenda.getRowCount() - 1, 0);
                this.JTBDatosAgenda.setValueAt(detalle.getHoraIngreso(), this.JTBDatosAgenda.getRowCount() - 1, 1);
                this.JTBDatosAgenda.setValueAt(detalle.getIdTipoIdentificacion(), this.JTBDatosAgenda.getRowCount() - 1, 2);
                this.JTBDatosAgenda.setValueAt(detalle.getNoDocumento(), this.JTBDatosAgenda.getRowCount() - 1, 3);
                this.JTBDatosAgenda.setValueAt(detalle.getnombre(), this.JTBDatosAgenda.getRowCount() - 1, 4);
                this.JTBDatosAgenda.setValueAt(detalle.getId(), this.JTBDatosAgenda.getRowCount() - 1, 5);
                this.JTBDatosAgenda.setValueAt(detalle.getNbre(), this.JTBDatosAgenda.getRowCount() - 1, 6);
                this.JTBDatosAgenda.setValueAt(detalle.getEstado(), this.JTBDatosAgenda.getRowCount() - 1, 7);
            });
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha INgreso", "Hora Ingreso", "IdTipoIdentificacion", "NO.Documento", "Nombre paciente", "Id", "Examen", "Estado"}) { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.sgc.JIF_Consultar_Examenes_SO.10
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTBDatosAgenda;
        JTable jTable2 = this.JTBDatosAgenda;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda.doLayout();
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consultar_Examenes_SO$MiRender.class */
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consultar_Examenes_SO$ButtonRenderer.class */
    private class ButtonRenderer implements TableCellRenderer {
        private ButtonRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
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

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.informacionVariaUrgenciasHospitalizacionDAO = (InformacionVariaUrgenciasHospitalizacionDAOImpl) classPathXmlApplicationContext.getBean("informacionVariaUrgenciasHospitalizacionDAOImpl");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consultar_Examenes_SO$MyTreeRenderer.class */
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
        this.JDCFecha3.setDate(this.metodos.getFechaActual());
        this.JTFNdocumento.setText("");
        mCrearModeloTabla();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Consultar_Examenes_SO$MyTreeCellRenderer.class */
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
