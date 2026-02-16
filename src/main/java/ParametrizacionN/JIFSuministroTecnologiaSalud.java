package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GTecnologiaSalud;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.ISuministroTecnologiaSalud;
import com.genoma.plus.jpa.service.IGTecnologiaSaludService;
import com.genoma.plus.jpa.service.ISuministroService;
import com.genoma.plus.jpa.service.ISuministroTecnologiaSaludService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSuministroTecnologiaSalud.class */
public class JIFSuministroTecnologiaSalud extends JInternalFrame {
    private ISuministroTecnologiaSalud iSuministroTecnologiaSalud;
    private GTecnologiaSalud gTecnologiaSalud;
    private ISuministro iSuministro;
    private final ISuministroTecnologiaSaludService iSuministroTecnologiaSaludService;
    private final IGTecnologiaSaludService iGTecnologiaSaludService;
    private final ISuministroService iSuministroService;
    private List<ISuministroTecnologiaSalud> listarISuministroTecnologiaSalud;
    private List<GTecnologiaSalud> listarGTecnologiaSalud;
    private List<ISuministro> listarISuministro;
    private DefaultTableModel modelo;
    private Metodos metodos;
    private Object[] datos;
    private int estado;
    private String[] itemSuministro;
    private String[] tecnologiaSalud;
    private JComboBox<String> JCBIdItemSuministro;
    private JComboBox<String> JCBIdTecnologiaSalud;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTable;

    public JIFSuministroTecnologiaSalud() {
        initComponents();
        this.iSuministroTecnologiaSalud = new ISuministroTecnologiaSalud();
        this.gTecnologiaSalud = new GTecnologiaSalud();
        this.iSuministro = new ISuministro();
        this.iSuministroTecnologiaSaludService = (ISuministroTecnologiaSaludService) Principal.contexto.getBean(ISuministroTecnologiaSaludService.class);
        this.iGTecnologiaSaludService = (IGTecnologiaSaludService) Principal.contexto.getBean(IGTecnologiaSaludService.class);
        this.iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
        this.listarISuministroTecnologiaSalud = new ArrayList();
        this.listarGTecnologiaSalud = new ArrayList();
        this.listarISuministro = new ArrayList();
        this.modelo = new DefaultTableModel();
        this.estado = 1;
        cargarDatosTabla();
        cargarComboBox();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JCBIdTecnologiaSalud = new JComboBox<>();
        this.JCBIdItemSuministro = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUMINISTRO DE TECNOLOGIA SALUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsuministrotecnologiasalud");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCBIdTecnologiaSalud.setFont(new Font("Arial", 1, 12));
        this.JCBIdTecnologiaSalud.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Tecnologia Salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIdItemSuministro.setFont(new Font("Arial", 1, 12));
        this.JCBIdItemSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Item Suministro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBIdItemSuministro, -2, 328, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBIdTecnologiaSalud, -2, 331, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addContainerGap(20, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(28, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBIdTecnologiaSalud, -2, 57, -2).addComponent(this.JCBIdItemSuministro, -2, 57, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(6, 6, 6))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSuministroTecnologiaSalud.1
            public void mouseClicked(MouseEvent evt) {
                JIFSuministroTecnologiaSalud.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 293, -2).addContainerGap(21, 32767)));
        getAccessibleContext().setAccessibleName("ENTORNO DE ATENCION");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        selecionarFila();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"SUMINISTRO", "TECNOLOGIA SALUD", "ESTADO"}) { // from class: ParametrizacionN.JIFSuministroTecnologiaSalud.2
            Class[] types = {Integer.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

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
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(15);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listarISuministroTecnologiaSalud = this.iSuministroTecnologiaSaludService.listarSuministro();
        this.listarISuministroTecnologiaSalud.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getIdItemSumistro().getNbre(), this.JTable.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getIdTecnologiaSalud().getNombre(), this.JTable.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTable.getRowCount() - 1, 2);
        });
    }

    public void grabar() {
        if (this.JCBIdItemSuministro.getSelectedIndex() != -1 || this.JCBIdTecnologiaSalud.getSelectedIndex() != -1) {
            this.iSuministroTecnologiaSalud.setIdItemSumistro(this.listarISuministro.get(this.JCBIdItemSuministro.getSelectedIndex()));
            this.iSuministroTecnologiaSalud.setIdTecnologiaSalud(this.listarGTecnologiaSalud.get(this.JCBIdTecnologiaSalud.getSelectedIndex()));
            this.iSuministroTecnologiaSalud.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            String id = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
            this.iSuministroTecnologiaSalud.setIdUsuario(Integer.valueOf(id));
            this.iSuministroTecnologiaSaludService.grabar(this.iSuministroTecnologiaSalud);
            JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
            this.JCBIdItemSuministro.setSelectedIndex(-1);
            this.JCBIdTecnologiaSalud.setSelectedIndex(-1);
            Principal.txtNo.setText("");
            cargarDatosTabla();
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese los datos");
        }
        cargarDatosTabla();
    }

    private void selecionarFila() {
        if (this.JTable.getSelectedRow() != -1) {
            this.iSuministroTecnologiaSalud = this.listarISuministroTecnologiaSalud.get(this.JTable.getSelectedRow());
            Principal.txtNo.setText(this.iSuministroTecnologiaSalud.getId().toString());
            this.JCBIdItemSuministro.setSelectedItem(this.modelo.getValueAt(this.JTable.getSelectedRow(), 0).toString());
            this.JCBIdTecnologiaSalud.setSelectedItem(this.modelo.getValueAt(this.JTable.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(this.listarISuministroTecnologiaSalud.get(this.JTable.getSelectedRow()).getEstado().booleanValue());
        }
    }

    private void cargarComboBox() {
        limpiarDatos();
        llenarComboSuministro("");
        llenarComboTecnologiaSalud("");
    }

    private void limpiarDatos() {
        this.JCBIdItemSuministro.setSelectedIndex(-1);
        this.JCBIdTecnologiaSalud.setSelectedIndex(-1);
    }

    public void llenarComboSuministro(String nombre) {
        this.listarISuministro = new ArrayList();
        this.JCBIdItemSuministro.removeAllItems();
        this.listarISuministro = this.iSuministroService.listarSuministro();
        if (!this.listarISuministro.isEmpty()) {
            this.listarISuministro.forEach(items -> {
                this.JCBIdItemSuministro.addItem(items.getNbre());
            });
            if (nombre.isEmpty()) {
                if (this.listarISuministro.size() > 1) {
                    this.JCBIdItemSuministro.setSelectedIndex(-1);
                    return;
                }
                return;
            }
            this.JCBIdItemSuministro.setSelectedItem(nombre);
        }
    }

    public void llenarComboTecnologiaSalud(String nombre) {
        this.listarGTecnologiaSalud = new ArrayList();
        this.JCBIdTecnologiaSalud.removeAllItems();
        this.listarGTecnologiaSalud = this.iGTecnologiaSaludService.listarGTecnologiaSalud();
        if (!this.listarGTecnologiaSalud.isEmpty()) {
            this.listarGTecnologiaSalud.forEach(items -> {
                this.JCBIdTecnologiaSalud.addItem(items.getNombre());
            });
            if (nombre.isEmpty()) {
                if (this.listarGTecnologiaSalud.size() > 1) {
                    this.JCBIdTecnologiaSalud.setSelectedIndex(-1);
                    return;
                }
                return;
            }
            this.JCBIdTecnologiaSalud.setSelectedItem(nombre);
        }
    }
}
