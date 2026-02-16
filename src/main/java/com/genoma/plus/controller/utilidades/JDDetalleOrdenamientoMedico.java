package com.genoma.plus.controller.utilidades;

import Acceso.Principal;
import Sgc.JD_RegistoSeguimientoAmbulatorio;
import Utilidades.Metodos;
import Utilidades.SseListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.dto.EventSubscriberDTO;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedicoDetalle;
import com.genoma.plus.dao.general.SseClosableDAO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.jdesktop.swingx.JXTree;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/JDDetalleOrdenamientoMedico.class */
public class JDDetalleOrdenamientoMedico extends JDialog implements SseClosableDAO {
    private Metodos metodos;
    private Long idNumeroFactura;
    private List<OrdenamientoMedico> listOrdenamiento;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    private DefaultTableModel modeloServicio;
    private Object[] datos;
    private SseListener sseListener;
    private List<EventSubscriberDTO> eventSubscriberDTOs;
    private Integer idServicio;
    private JButton JBTRegistrarSeguimiento;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JCheckBox JCH_Cerrar;
    private JLabel JLB_Especialidad;
    private JLabel JLB_NRegistros;
    private JLabel JLB_Profesional;
    private JLabel JLB_Tipo;
    private JLabel JLB_Usuario;
    private JPanel JPI_InfoFactura;
    private JRadioButton JRB_ConSeguimiento;
    private JScrollPane JSP_Datos;
    private JScrollPane JSP_DetalleOrden;
    private JTable JTB_DetalleOrden;
    private JXTree JTX_Datos;

    public JDDetalleOrdenamientoMedico(Frame parent, boolean modal, List<OrdenamientoMedico> listOrdenamiento, Integer idServicio) {
        super(parent, modal);
        initComponents();
        this.idServicio = idServicio;
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.listOrdenamiento = listOrdenamiento;
        configJtree();
        inicializarSseListener();
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_InfoFactura = new JPanel();
        this.JLB_Tipo = new JLabel();
        this.JLB_Profesional = new JLabel();
        this.JLB_Especialidad = new JLabel();
        this.JCH_Cerrar = new JCheckBox();
        this.JLB_Usuario = new JLabel();
        this.JSP_Datos = new JScrollPane();
        this.JTX_Datos = new JXTree();
        this.JLB_NRegistros = new JLabel();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JSP_DetalleOrden = new JScrollPane();
        this.JTB_DetalleOrden = new JTable();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JRB_ConSeguimiento = new JRadioButton();
        setDefaultCloseOperation(2);
        setTitle("DETALLE ORDENAMIENTO");
        this.JPI_InfoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ORDEN", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLB_Tipo.setFont(new Font("Arial", 1, 12));
        this.JLB_Tipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Profesional.setFont(new Font("Arial", 1, 12));
        this.JLB_Profesional.setHorizontalAlignment(0);
        this.JLB_Profesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Especialidad.setFont(new Font("Arial", 1, 12));
        this.JLB_Especialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Cerrar.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrar.setText("Cerrar?");
        this.JCH_Cerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.1
            public void actionPerformed(ActionEvent evt) {
                JDDetalleOrdenamientoMedico.this.JCH_CerrarActionPerformed(evt);
            }
        });
        this.JLB_Usuario.setFont(new Font("Arial", 1, 12));
        this.JLB_Usuario.setForeground(Color.red);
        this.JLB_Usuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_InfoFacturaLayout = new GroupLayout(this.JPI_InfoFactura);
        this.JPI_InfoFactura.setLayout(JPI_InfoFacturaLayout);
        JPI_InfoFacturaLayout.setHorizontalGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Tipo, -1, 320, 32767).addComponent(this.JLB_Especialidad, -1, -1, 32767)).addGap(24, 24, 24).addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_Profesional, -2, 525, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_Usuario, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Cerrar).addGap(17, 17, 17)))));
        JPI_InfoFacturaLayout.setVerticalGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_Tipo, -2, 50, -2).addComponent(this.JCH_Cerrar))).addComponent(this.JLB_Usuario, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_Profesional, -2, 50, -2).addGap(0, 0, 32767)).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_Especialidad, -2, 50, -2).addContainerGap(12, 32767)))));
        this.JTX_Datos.setFont(new Font("Arial", 1, 12));
        this.JTX_Datos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.2
            public void mouseClicked(MouseEvent evt) {
                JDDetalleOrdenamientoMedico.this.JTX_DatosMouseClicked(evt);
            }
        });
        this.JSP_Datos.setViewportView(this.JTX_Datos);
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Validaciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.3
            public void actionPerformed(ActionEvent evt) {
                JDDetalleOrdenamientoMedico.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.4
            public void actionPerformed(ActionEvent evt) {
                JDDetalleOrdenamientoMedico.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JSP_DetalleOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_DetalleOrden.setFont(new Font("Arial", 1, 12));
        this.JTB_DetalleOrden.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DetalleOrden.setRowHeight(30);
        this.JTB_DetalleOrden.setSelectionMode(0);
        this.JTB_DetalleOrden.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.5
            public void mouseClicked(MouseEvent evt) {
                JDDetalleOrdenamientoMedico.this.JTB_DetalleOrdenMouseClicked(evt);
            }
        });
        this.JSP_DetalleOrden.setViewportView(this.JTB_DetalleOrden);
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Seguimiento");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.6
            public void actionPerformed(ActionEvent evt) {
                JDDetalleOrdenamientoMedico.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JRB_ConSeguimiento.setBackground(new Color(255, 255, 204));
        this.JRB_ConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JRB_ConSeguimiento.setSelected(true);
        this.JRB_ConSeguimiento.setText("Requiere Autorización");
        this.JRB_ConSeguimiento.setEnabled(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_Datos, -1, 165, 32767).addComponent(this.JLB_NRegistros, -1, -1, 32767)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_InfoFactura, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JSP_DetalleOrden, -2, 895, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JBTRegistrarSeguimiento, -2, 220, -2).addGap(18, 18, 18).addComponent(this.JBT_Grabar, -2, 220, -2).addGap(18, 18, 18).addComponent(this.JBT_Salir, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB_ConSeguimiento))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Datos, -2, 461, -2).addGroup(layout.createSequentialGroup().addComponent(this.JPI_InfoFactura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DetalleOrden, -2, 313, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_NRegistros, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Salir, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBTRegistrarSeguimiento, -2, 50, -2))).addComponent(this.JRB_ConSeguimiento)).addGap(0, 17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTX_DatosMouseClicked(MouseEvent evt) {
        if (getNodoSeleccionado() > 0) {
            cargarDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (getNodoSeleccionado() != -1) {
            this.metodos.getGrabarOrdenamientoMedico(this.listOrdenamiento.get(getNodoSeleccionado() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleOrdenMouseClicked(MouseEvent evt) {
        if (this.JTB_DetalleOrden.getSelectedRow() != -1) {
            this.listOrdenamiento.get(getNodoSeleccionado() - 1).getDetalleOrden().get(this.JTB_DetalleOrden.getSelectedRow()).setEjecutado(Boolean.valueOf(this.JTB_DetalleOrden.getValueAt(this.JTB_DetalleOrden.getSelectedRow(), 4).toString()));
            verificarEstadoCerrado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CerrarActionPerformed(ActionEvent evt) {
        this.listOrdenamiento.get(getNodoSeleccionado() - 1).setCerrada(Boolean.valueOf(this.JCH_Cerrar.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        cargarPantallaSeguimiento();
    }

    private void configJtree() {
        this.root = new DefaultMutableTreeNode("Info");
        this.treeModel = new DefaultTreeModel(this.root);
        this.JTX_Datos.setModel(this.treeModel);
        this.JLB_NRegistros.setText("");
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.listOrdenamiento.forEach(e -> {
            addNode("" + e.getId() + "_" + formateador.format(e.getFechaOrden()) + "_  " + e.getDocumentoUsuario() + "-" + e.getNombreUsuario());
        });
        this.JLB_NRegistros.setText("" + this.listOrdenamiento.size());
        this.JLB_Especialidad.setText("");
        this.JLB_Profesional.setText("");
        this.JLB_Tipo.setText("");
        mExpandAll(this.JTX_Datos, true);
        crearTablaAgendaServicio();
    }

    private void verificarEstadoCerrado() {
        int numeroFilas = 0;
        this.JCH_Cerrar.setSelected(false);
        for (int i = 0; i < this.JTB_DetalleOrden.getRowCount(); i++) {
            if (Boolean.parseBoolean(this.JTB_DetalleOrden.getValueAt(i, 4).toString())) {
                numeroFilas++;
            }
        }
        if (numeroFilas == this.JTB_DetalleOrden.getRowCount()) {
            this.JCH_Cerrar.setSelected(true);
        }
    }

    public static void mExpandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        mExpandAll(tree, new TreePath(root), expand);
    }

    private static void mExpandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                mExpandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    private void addNode(String nodeName) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
        this.treeModel.insertNodeInto(newNode, this.root, this.root.getChildCount());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaAgendaServicio() {
        this.modeloServicio = new DefaultTableModel(new Object[0], new String[]{"Código", "Servicio", "Observacion", "Cantidad", "Realizado?", "Requiere Autorizacion", "IdItems"}) { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.7
            Class[] types = {String.class, String.class, String.class, Integer.class, Boolean.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_DetalleOrden;
        JTable jTable2 = this.JTB_DetalleOrden;
        jTable.setAutoResizeMode(0);
        this.JTB_DetalleOrden.doLayout();
        this.JTB_DetalleOrden.setModel(this.modeloServicio);
        this.JTB_DetalleOrden.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_DetalleOrden.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTB_DetalleOrden.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_DetalleOrden.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_DetalleOrden.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_DetalleOrden.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTB_DetalleOrden.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarDetalle() {
        if (!this.listOrdenamiento.isEmpty()) {
            int x = getNodoSeleccionado() - 1;
            crearTablaAgendaServicio();
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            this.JLB_Tipo.setText(this.listOrdenamiento.get(x).getDescripcion());
            this.JLB_Especialidad.setText(this.listOrdenamiento.get(x).getEspecialidad());
            this.JLB_Profesional.setText(this.listOrdenamiento.get(x).getProfesional());
            this.JCH_Cerrar.setSelected(this.listOrdenamiento.get(x).getCerrada().booleanValue());
            this.JLB_Usuario.setText(this.listOrdenamiento.get(x).getDocumentoUsuario() + "-" + this.listOrdenamiento.get(x).getNombreUsuario());
            int nfila = 0;
            this.metodos.mEstablecerTextEditor(this.JTB_DetalleOrden, 2);
            this.JTB_DetalleOrden.setDefaultRenderer(Object.class, new MiRender());
            if (!this.listOrdenamiento.get(x).getDetalleOrden().isEmpty()) {
                for (OrdenamientoMedicoDetalle e : this.listOrdenamiento.get(x).getDetalleOrden()) {
                    this.modeloServicio.addRow(this.datos);
                    this.JTB_DetalleOrden.setValueAt(e.getCodigo(), nfila, 0);
                    this.JTB_DetalleOrden.setValueAt(e.getNombre(), nfila, 1);
                    this.JTB_DetalleOrden.setValueAt(e.getObservacion(), nfila, 2);
                    this.JTB_DetalleOrden.setValueAt(e.getCantidad(), nfila, 3);
                    this.JTB_DetalleOrden.setValueAt(e.getEjecutado(), nfila, 4);
                    this.JTB_DetalleOrden.setValueAt(e.getAutorizacion(), nfila, 5);
                    this.JTB_DetalleOrden.setValueAt(e.getIdItemsDetalle(), nfila, 6);
                    nfila++;
                }
            }
        }
    }

    private int getNodoSeleccionado() {
        int position = 0;
        int[] selectedRows = this.JTX_Datos.getSelectionRows();
        if (selectedRows != null) {
            for (int i : selectedRows) {
                TreePath path = this.JTX_Datos.getPathForRow(i);
                position = this.JTX_Datos.getRowForPath(path);
            }
        }
        return position;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/JDDetalleOrdenamientoMedico$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean estado = obtenerBooleano(table, row, 5);
            if (estado != null) {
                cell.setBackground(estado.booleanValue() ? new Color(255, 255, 204) : Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
            }
            cell.setForeground(Color.BLACK);
            return cell;
        }

        private Boolean obtenerBooleano(JTable table, int row, int column) {
            try {
                Object valor = table.getValueAt(row, column);
                if (valor instanceof Boolean) {
                    return (Boolean) valor;
                }
                return Boolean.valueOf(valor.toString());
            } catch (Exception e) {
                return null;
            }
        }
    }

    @Override // com.genoma.plus.dao.general.SseClosableDAO
    public void closeSseListeners() {
        for (EventSubscriberDTO subscriber : this.eventSubscriberDTOs) {
            this.sseListener.unsubscribe(subscriber);
        }
        this.eventSubscriberDTOs.clear();
    }

    private void inicializarSseListener() {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.eventSubscriberDTOs = new ArrayList();
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("100", "notificacionesDeEventos");
            if (microserviciosDomain.getUrlRecurso() != null && !microserviciosDomain.getUrlRecurso().isEmpty()) {
                this.sseListener = new SseListener(microserviciosDomain.getUrlRecurso());
                this.sseListener.startListening();
                this.eventSubscriberDTOs.add(this.sseListener.subscribe("ordenamientoMedico", data -> {
                    try {
                        new ArrayList();
                        List<OrdenamientoMedico> ordenamientoMedico1 = (List) this.metodos.getMapper().readValue(data, new TypeReference<List<OrdenamientoMedico>>() { // from class: com.genoma.plus.controller.utilidades.JDDetalleOrdenamientoMedico.8
                        });
                        this.listOrdenamiento = getOrdenamientoMedicoFiltrado(ordenamientoMedico1, this.idServicio.intValue());
                        SwingUtilities.invokeLater(() -> {
                            configJtree();
                        });
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(JDDetalleOrdenamientoMedico.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                }));
            }
        }
    }

    private List<OrdenamientoMedico> getOrdenamientoMedicoFiltrado(List<OrdenamientoMedico> dato, int idServicio) {
        return (List) dato.stream().filter(ordenamientoMedico -> {
            return ordenamientoMedico.getIdServicio().equals(Integer.valueOf(idServicio));
        }).collect(Collectors.toList());
    }

    private void cargarPantallaSeguimiento() {
        if (this.JTB_DetalleOrden.getSelectedRow() != -1) {
            if (this.JTB_DetalleOrden.getValueAt(this.JTB_DetalleOrden.getSelectedRow(), 6) != null) {
                JD_RegistoSeguimientoAmbulatorio registoSeguimiento = new JD_RegistoSeguimientoAmbulatorio(null, true, Long.valueOf(this.JTB_DetalleOrden.getValueAt(this.JTB_DetalleOrden.getSelectedRow(), 6).toString()));
                registoSeguimiento.setLocationRelativeTo(this);
                registoSeguimiento.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
