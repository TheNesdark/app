package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GTecnologiaSalud;
import com.genoma.plus.jpa.service.IGTecnologiaSaludService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGTecnologiaSalud.class */
public class JIFGTecnologiaSalud extends JInternalFrame {
    private DefaultTableModel modelo;
    private Metodos metodos;
    private Object[] datos;
    private GTecnologiaSalud gTecnologiaSalud;
    private IGTecnologiaSaludService iGTecnologiaSaludService;
    private List<GTecnologiaSalud> listarGTecnologiaSalud;
    private int estado;
    private String clasificacion;
    private int clasificacion1;
    private boolean cla;
    private JCheckBox JCHEstado;
    private JPanel JPIClasificacion;
    private JPanel JPIDatos;
    private JRadioButton JRBProcedimiento;
    private JRadioButton JRBSuministro;
    private JScrollPane JSPDetalle;
    private JTextField JTFNombre;
    private JTextField JTFcodigRes866;
    private JTable JTable;
    private ButtonGroup buttonGroup2;

    public JIFGTecnologiaSalud() {
        initComponents();
        this.modelo = new DefaultTableModel();
        this.gTecnologiaSalud = new GTecnologiaSalud();
        this.iGTecnologiaSaludService = (IGTecnologiaSaludService) Principal.contexto.getBean(IGTecnologiaSaludService.class);
        this.listarGTecnologiaSalud = new ArrayList();
        this.estado = 1;
        this.clasificacion = "Suministro";
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup2 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPIClasificacion = new JPanel();
        this.JRBSuministro = new JRadioButton();
        this.JRBProcedimiento = new JRadioButton();
        this.JTFcodigRes866 = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setTitle("TECNOLOGÍA SALUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftecnologiaSalud");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatos.setName("jiftecnologiasalud");
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JPIClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPIClasificacion.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGTecnologiaSalud.1
            public void mouseClicked(MouseEvent evt) {
                JIFGTecnologiaSalud.this.JPIClasificacionMouseClicked(evt);
            }
        });
        this.buttonGroup2.add(this.JRBSuministro);
        this.JRBSuministro.setFont(new Font("Arial", 1, 12));
        this.JRBSuministro.setText("Suministro");
        this.buttonGroup2.add(this.JRBProcedimiento);
        this.JRBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JRBProcedimiento.setText("Procedimiento");
        this.JRBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12)));
        GroupLayout JPIClasificacionLayout = new GroupLayout(this.JPIClasificacion);
        this.JPIClasificacion.setLayout(JPIClasificacionLayout);
        JPIClasificacionLayout.setHorizontalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JRBSuministro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBProcedimiento).addContainerGap(-1, 32767)));
        JPIClasificacionLayout.setVerticalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIClasificacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSuministro).addComponent(this.JRBProcedimiento)).addContainerGap()));
        this.JTFcodigRes866.setFont(new Font("Arial", 1, 12));
        this.JTFcodigRes866.setToolTipText("");
        this.JTFcodigRes866.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Res 866", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFcodigRes866.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFGTecnologiaSalud.2
            public void keyTyped(KeyEvent evt) {
                JIFGTecnologiaSalud.this.JTFcodigRes866KeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFGTecnologiaSalud.this.JTFcodigRes866KeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 297, -2).addComponent(this.JPIClasificacion, -2, -1, -2)).addGap(18, 18, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JTFcodigRes866, -2, 173, -2)).addGap(0, 73, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFcodigRes866).addComponent(this.JTFNombre, -2, 51, -2)).addGap(20, 20, 20).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIClasificacion, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCHEstado))).addContainerGap(34, 32767)));
        this.JPIClasificacion.getAccessibleContext().setAccessibleParent(this.JPIClasificacion);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGTecnologiaSalud.3
            public void mouseClicked(MouseEvent evt) {
                JIFGTecnologiaSalud.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 259, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        selecionarFila();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFcodigRes866KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFcodigRes866KeyTyped(KeyEvent evt) {
        if (this.JTFcodigRes866.getText().length() < 2) {
            evt.setKeyChar(evt.getKeyChar());
        } else {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPIClasificacionMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"NOMBRE", "CÓDIGO", "CLASIFICACIÓN", "ESTADO"}) { // from class: ParametrizacionN.JIFGTecnologiaSalud.4
            Class[] types = {String.class, String.class, Integer.class, Boolean.class};
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
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listarGTecnologiaSalud = this.iGTecnologiaSaludService.listarGTecnologiaSalud();
        this.listarGTecnologiaSalud.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getNombre(), this.JTable.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getCodigo(), this.JTable.getRowCount() - 1, 1);
            this.clasificacion1 = e.getClasificacion().intValue();
            if (this.clasificacion1 == 0) {
                this.modelo.setValueAt("Suministro", this.JTable.getRowCount() - 1, 2);
            } else if (this.clasificacion1 == 1) {
                this.modelo.setValueAt("Procedimiento", this.JTable.getRowCount() - 1, 2);
            }
            this.modelo.setValueAt(e.getEstado(), this.JTable.getRowCount() - 1, 3);
        });
    }

    private void selecionarFila() {
        if (this.JTable.getSelectedRow() != -1) {
            this.gTecnologiaSalud = this.listarGTecnologiaSalud.get(this.JTable.getSelectedRow());
            Principal.txtNo.setText(this.gTecnologiaSalud.getId().toString());
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 0).toString());
            this.JTFcodigRes866.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 1).toString());
            if (this.modelo.getValueAt(this.JTable.getSelectedRow(), 2).toString().equals("Suministro")) {
                this.JRBSuministro.setSelected(true);
                this.clasificacion = "Suministro";
            } else {
                this.JRBProcedimiento.setSelected(true);
                this.clasificacion = "Procedimiento";
            }
            this.JCHEstado.setSelected(this.listarGTecnologiaSalud.get(this.JTable.getSelectedRow()).getEstado().booleanValue());
        }
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty() || !this.JTFcodigRes866.getText().isEmpty() || this.JPIClasificacion != null) {
            this.gTecnologiaSalud.setNombre(this.JTFNombre.getText());
            this.gTecnologiaSalud.setCodigo(this.JTFcodigRes866.getText());
            if (this.JRBSuministro.isSelected()) {
                this.clasificacion1 = 0;
            } else {
                this.clasificacion1 = 1;
            }
            this.gTecnologiaSalud.setClasificacion(Integer.valueOf(this.clasificacion1));
            this.gTecnologiaSalud.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            String id = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
            this.gTecnologiaSalud.setIdUsuario(Integer.valueOf(id));
            this.iGTecnologiaSaludService.grabar(this.gTecnologiaSalud);
            JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
            this.JTFNombre.setText("");
            this.JTFcodigRes866.setText("");
            cargarDatosTabla();
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese los datos");
        }
        cargarDatosTabla();
    }
}
