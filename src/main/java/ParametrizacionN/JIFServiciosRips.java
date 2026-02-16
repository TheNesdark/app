package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.service.GServicioGrupoService;
import com.genoma.plus.jpa.service.GServicioRipsService;
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
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFServiciosRips.class */
public class JIFServiciosRips extends JInternalFrame {
    private GServicioRipsEntity gServicioRipsEntity;
    private final GServicioRipsService gServicioRipsService;
    private List<GServicioRipsEntity> listgServicioRipsEntitys;
    private GServicioGrupoEntity gServicioGrupoEntity;
    private final GServicioGrupoService gServicioGrupoService;
    private List<GServicioGrupoEntity> ListaGruposervicios;
    private DefaultTableModel modelo;
    private Metodos metodos;
    private Object[] datos;
    private int estado;
    private JComboBox JCBGrupoServicio;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTable JTable;

    public JIFServiciosRips() {
        initComponents();
        this.gServicioRipsEntity = new GServicioRipsEntity();
        this.gServicioRipsService = (GServicioRipsService) Principal.contexto.getBean(GServicioRipsService.class);
        this.gServicioGrupoService = (GServicioGrupoService) Principal.contexto.getBean(GServicioGrupoService.class);
        this.listgServicioRipsEntitys = new ArrayList();
        this.ListaGruposervicios = new ArrayList();
        this.modelo = new DefaultTableModel();
        this.estado = 1;
        cargarDatosTabla();
        cargarCombo();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JCBGrupoServicio = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setTitle("SERVICIOS RIPS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifserviciosrips");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFServiciosRips.1
            public void keyTyped(KeyEvent evt) {
                JIFServiciosRips.this.JTFCodigoKeyTyped(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFServiciosRips.2
            public void actionPerformed(ActionEvent evt) {
                JIFServiciosRips.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Servicios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoServicio.setName("");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGrupoServicio, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JCBGrupoServicio)).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFServiciosRips.3
            public void mouseClicked(MouseEvent evt) {
                JIFServiciosRips.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -1, 650, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 293, -2).addContainerGap(36, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        seleccionarFila();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.estado = 1;
        } else {
            this.estado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyTyped(KeyEvent evt) {
    }

    public void nuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        Principal.txtNo.setText("");
        cargarDatosTabla();
        this.JCBGrupoServicio.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"CODIGO", "NOMBRE", "GRUPO SERVICIO", "ESTADO"}) { // from class: ParametrizacionN.JIFServiciosRips.4
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.modelo);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listgServicioRipsEntitys = this.gServicioRipsService.findAllOrderByNombre();
        this.modelo.setRowCount(0);
        for (GServicioRipsEntity e : this.listgServicioRipsEntitys) {
            Object[] fila = {e.getCodigo(), e.getNombre(), e.getIdGrupoServicio().getNombre(), e.getEstado()};
            this.modelo.addRow(fila);
        }
    }

    public void grabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (this.JCBGrupoServicio.getSelectedIndex() != -1) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    GServicioRipsEntity nuevoServicioRipsEntity = new GServicioRipsEntity();
                    if (!Principal.txtNo.getText().isEmpty()) {
                        nuevoServicioRipsEntity.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                    }
                    nuevoServicioRipsEntity.setCodigo(this.JTFCodigo.getText());
                    nuevoServicioRipsEntity.setNombre(this.JTFNombre.getText());
                    nuevoServicioRipsEntity.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                    int selectedIndex = this.JCBGrupoServicio.getSelectedIndex();
                    if (selectedIndex != -1) {
                        GServicioGrupoEntity grupoSeleccionado = this.ListaGruposervicios.get(selectedIndex);
                        nuevoServicioRipsEntity.setIdGrupoServicio(grupoSeleccionado);
                        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (y == 0) {
                            this.gServicioRipsService.save(nuevoServicioRipsEntity);
                        }
                        JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
                        nuevo();
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleecionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBGrupoServicio.requestFocusInWindow();
                        return;
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe ingresar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFNombre.requestFocusInWindow();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleecionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBGrupoServicio.requestFocusInWindow();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Ingresar un codigo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGrupoServicio.requestFocusInWindow();
        }
        cargarDatosTabla();
    }

    private void cargarCombo() {
        this.JCBGrupoServicio.removeAllItems();
        this.ListaGruposervicios = this.gServicioGrupoService.findAByOrderByNombre();
        this.ListaGruposervicios.forEach(a -> {
            this.JCBGrupoServicio.addItem(a.getNombre());
        });
        this.JCBGrupoServicio.setSelectedIndex(-1);
    }

    private void seleccionarFila() {
        int indiceSeleccionado = this.JTable.getSelectedRow();
        if (indiceSeleccionado != -1 && indiceSeleccionado < this.listgServicioRipsEntitys.size()) {
            this.gServicioRipsEntity = this.listgServicioRipsEntitys.get(indiceSeleccionado);
            Principal.txtNo.setText(this.gServicioRipsEntity.getId().toString());
            this.JTFCodigo.setText(this.modelo.getValueAt(indiceSeleccionado, 0).toString());
            this.JTFNombre.setText(this.modelo.getValueAt(indiceSeleccionado, 1).toString());
            this.JCBGrupoServicio.setSelectedItem(this.modelo.getValueAt(indiceSeleccionado, 2).toString());
            this.JCHEstado.setSelected(this.gServicioRipsEntity.getEstado().booleanValue());
        }
    }
}
