package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GOrigenadmision;
import com.genoma.plus.jpa.service.GOrigenadmisionService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFOrigenAdmision.class */
public class JIFOrigenAdmision extends JInternalFrame {
    private GOrigenadmision gOrigenadmision;
    private final GOrigenadmisionService gOrigenadmisionService;
    private List<GOrigenadmision> listarAdmision;
    private DefaultTableModel modelo;
    private Metodos metodos;
    private Object[] datos;
    private int estado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTable JTable;

    public JIFOrigenAdmision() {
        initComponents();
        this.gOrigenadmision = new GOrigenadmision();
        this.gOrigenadmisionService = (GOrigenadmisionService) Principal.contexto.getBean(GOrigenadmisionService.class);
        this.listarAdmision = new ArrayList();
        this.modelo = new DefaultTableModel();
        this.estado = 1;
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("ORIGEN ADMISION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiforigenadmision");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFOrigenAdmision.1
            public void keyTyped(KeyEvent evt) {
                JIFOrigenAdmision.this.JTFCodigoKeyTyped(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFOrigenAdmision.2
            public void actionPerformed(ActionEvent evt) {
                JIFOrigenAdmision.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 309, -2).addGap(32, 32, 32).addComponent(this.JCHEstado).addContainerGap(66, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFOrigenAdmision.3
            public void mouseClicked(MouseEvent evt) {
                JIFOrigenAdmision.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 293, -2).addContainerGap(33, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        selecionarFila();
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
        if (this.JTFCodigo.getText().length() == 2) {
            evt.consume();
        }
    }

    public void nuevo() {
        this.metodos.limpiarControles(this.JPIDatos, true);
        this.gOrigenadmision = new GOrigenadmision();
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"CODIGO", "NOMBRE", "ESTADO"}) { // from class: ParametrizacionN.JIFOrigenAdmision.4
            Class[] types = {String.class, String.class, Boolean.class};
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
        this.listarAdmision = this.gOrigenadmisionService.listarTodosLosOrigenesDeAdminision();
        this.listarAdmision.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getCodigoRes1936(), this.JTable.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNbre(), this.JTable.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTable.getRowCount() - 1, 2);
        });
    }

    public void grabar() {
        if (!this.JTFCodigo.getText().isEmpty() || !this.JTFNombre.getText().isEmpty()) {
            this.gOrigenadmision.setCodigoRes1936(this.JTFCodigo.getText());
            this.gOrigenadmision.setNbre(this.JTFNombre.getText());
            this.gOrigenadmision.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            String id = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
            this.gOrigenadmision.setUsuarioS(id);
            this.gOrigenadmisionService.save(this.gOrigenadmision);
            JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
            this.JTFCodigo.setText("");
            this.JTFNombre.setText("");
            Principal.txtNo.setText("");
            cargarDatosTabla();
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese los datos");
        }
        cargarDatosTabla();
    }

    private void selecionarFila() {
        if (this.JTable.getSelectedRow() != -1) {
            this.gOrigenadmision = this.listarAdmision.get(this.JTable.getSelectedRow());
            Principal.txtNo.setText(this.gOrigenadmision.getId().toString());
            this.JTFCodigo.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(this.listarAdmision.get(this.JTable.getSelectedRow()).getEstado().booleanValue());
        }
    }
}
