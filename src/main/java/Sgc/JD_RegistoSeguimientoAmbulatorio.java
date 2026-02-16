package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JIFGestion_Servicios;
import com.genoma.plus.jpa.entities.HItemordenesProcedSeguimientoEntity;
import com.genoma.plus.jpa.entities.HTipoSeguimientoItemEntity;
import com.genoma.plus.jpa.projection.HItemOrdenesProcedSeguimientoProjection;
import com.genoma.plus.jpa.service.HItemordenesProcedSeguimientoService;
import com.genoma.plus.jpa.service.HTipoSeguimientoItemService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JD_RegistoSeguimientoAmbulatorio.class */
public class JD_RegistoSeguimientoAmbulatorio extends JDialog {
    private Long idRemision;
    private Metodos metodos;
    private ConsultasMySQL consulta;
    private final HItemordenesProcedSeguimientoService seguimientoService;
    private final HTipoSeguimientoItemService seguimientoItemService;
    private DefaultTableModel modelo;
    private Object[] dato;
    private DefaultTableModel xmodelo1;
    private Boolean seguimiento;
    private JIFSeguimientoAmbulatorio ambulatorio;
    private JIFGestion_Servicios gestion_Servicios;
    private List<HTipoSeguimientoItemEntity> tipoSeguimientoItemEntitys;
    private Integer idUusario;
    private List<HItemOrdenesProcedSeguimientoProjection> listSeguimientoProjections;
    private JButton JBGuardar;
    private JButton JBNuevo;
    private JButton JBT_Salir;
    private JComboBox JCBTipoSeguimiento;
    private JCheckBox JCH_Cerrar;
    private JLabel JLBNItem;
    private JPanel JPI_DatosRegistro;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Detalle;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JTextField JTF_NumeroAutorizacion;

    public JD_RegistoSeguimientoAmbulatorio(Frame parent, boolean modal, Long item) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consulta = new ConsultasMySQL();
        this.seguimiento = false;
        this.idUusario = 0;
        initComponents();
        this.JLBNItem.setText("" + item);
        this.seguimientoService = (HItemordenesProcedSeguimientoService) Principal.contexto.getBean(HItemordenesProcedSeguimientoService.class);
        this.seguimientoItemService = (HTipoSeguimientoItemService) Principal.contexto.getBean(HTipoSeguimientoItemService.class);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosRegistro = new JPanel();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCBTipoSeguimiento = new JComboBox();
        this.JTF_NumeroAutorizacion = new JTextField();
        this.JCH_Cerrar = new JCheckBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBNuevo = new JButton();
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JLBNItem = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO DE SEGUIMIENTO");
        setFont(new Font("Arial", 1, 14));
        this.JPI_DatosRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS REGISTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_DatosRegistro.setFont(new Font("Arial", 1, 14));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBTipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NumeroAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JTF_NumeroAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Cerrar.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrar.setText("Cerrar?");
        GroupLayout JPI_DatosRegistroLayout = new GroupLayout(this.JPI_DatosRegistro);
        this.JPI_DatosRegistro.setLayout(JPI_DatosRegistroLayout);
        JPI_DatosRegistroLayout.setHorizontalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoSeguimiento, 0, -1, 32767).addComponent(this.JSPObservacion)).addGap(18, 18, 18).addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addComponent(this.JTF_NumeroAutorizacion, -2, 204, -2).addContainerGap()).addComponent(this.JCH_Cerrar, GroupLayout.Alignment.TRAILING))));
        JPI_DatosRegistroLayout.setVerticalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoSeguimiento, -2, 50, -2).addComponent(this.JCH_Cerrar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacion, -2, -1, -2).addComponent(this.JTF_NumeroAutorizacion, -2, 50, -2)).addContainerGap()));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: Sgc.JD_RegistoSeguimientoAmbulatorio.1
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimientoAmbulatorio.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Sgc.JD_RegistoSeguimientoAmbulatorio.2
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimientoAmbulatorio.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Sgc.JD_RegistoSeguimientoAmbulatorio.3
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoSeguimientoAmbulatorio.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JLBNItem.setBackground(new Color(255, 255, 255));
        this.JLBNItem.setFont(new Font("Arial", 1, 18));
        this.JLBNItem.setHorizontalAlignment(0);
        this.JLBNItem.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 200, -2).addGap(59, 59, 59).addComponent(this.JBGuardar, -2, 200, -2).addGap(47, 47, 47).addComponent(this.JBT_Salir, -2, 200, -2).addGap(18, 18, 18).addComponent(this.JLBNItem, -2, 164, -2).addGap(0, 1, 32767)).addComponent(this.JPI_DatosRegistro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPI_DatosRegistro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -2, 208, -2).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGuardar, -2, 50, -2)).addGap(0, 0, 32767)).addComponent(this.JLBNItem, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.JTAObservacion.setText("");
        this.JCH_Cerrar.setSelected(false);
        this.JTF_NumeroAutorizacion.setText("");
        this.tipoSeguimientoItemEntitys = new ArrayList();
        this.tipoSeguimientoItemEntitys = this.seguimientoItemService.getLisAllTipoSeguimiento();
        this.JCBTipoSeguimiento.removeAllItems();
        if (!this.tipoSeguimientoItemEntitys.isEmpty()) {
            this.tipoSeguimientoItemEntitys.forEach(e -> {
                this.JCBTipoSeguimiento.addItem(e.getNombre());
            });
            if (this.tipoSeguimientoItemEntitys.size() > 1) {
                this.JCBTipoSeguimiento.setSelectedIndex(-1);
            }
        }
        cargarDatosTabla();
        this.JCBTipoSeguimiento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTAObservacion.getText().isEmpty()) {
            if (this.JCBTipoSeguimiento.getSelectedIndex() != -1) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    HItemordenesProcedSeguimientoEntity seguimientos = new HItemordenesProcedSeguimientoEntity();
                    seguimientos.setTipoSeguimientoItem(this.tipoSeguimientoItemEntitys.get(this.JCBTipoSeguimiento.getSelectedIndex()));
                    seguimientos.setIdItemsProcedimiento(Long.valueOf(this.JLBNItem.getText()));
                    seguimientos.setFechaHora(this.metodos.getFechaActualLocalTime());
                    seguimientos.setDescripcion(this.JTAObservacion.getText());
                    seguimientos.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    seguimientos.setEstado(true);
                    seguimientos.setFecha(this.metodos.getFechaActualLocalTime());
                    this.seguimientoService.Grabar(seguimientos);
                    this.seguimiento = true;
                    String sql = "update h_itemordenesproced  \n\tset h_itemordenesproced.cerrado=" + (this.JCH_Cerrar.isSelected() ? 1 : 0) + ", h_itemordenesproced.numeroAutorizacion='" + this.JTF_NumeroAutorizacion.getText() + "'\n\twhere h_itemordenesproced.Id = " + Long.valueOf(this.JLBNItem.getText()) + "";
                    this.consulta.ejecutaSQLUpdate(sql);
                    nuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de seguimiento", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoSeguimiento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "La observación no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTAObservacion.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTabla() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Seguimiento", "Fecha Hora ", "Descripcion", "Usuario Registro", "Cargo", "Estado"}) { // from class: Sgc.JD_RegistoSeguimientoAmbulatorio.4
            Class[] types = {Long.class, String.class, LocalDateTime.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarDatosTabla() {
        crearTabla();
        this.listSeguimientoProjections = new ArrayList();
        this.listSeguimientoProjections = this.seguimientoService.listDetalleSeguientoItemOrden(Long.valueOf(this.JLBNItem.getText()));
        if (!this.listSeguimientoProjections.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 3);
            this.listSeguimientoProjections.forEach(e -> {
                this.xmodelo1.addRow(this.dato);
                int x = this.JTDetalle.getRowCount() - 1;
                this.xmodelo1.setValueAt(e.getId(), x, 0);
                this.xmodelo1.setValueAt(e.getTipoSeguimiento(), x, 1);
                this.xmodelo1.setValueAt(e.getFecha(), x, 2);
                this.xmodelo1.setValueAt(e.getDescripcion(), x, 3);
                this.xmodelo1.setValueAt(e.getUsuarioRegistro(), x, 4);
                this.xmodelo1.setValueAt(e.getCargo(), x, 5);
                this.xmodelo1.setValueAt(e.getEstado(), x, 6);
            });
        }
    }
}
