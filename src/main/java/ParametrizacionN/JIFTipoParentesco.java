package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HTipoparantec;
import com.genoma.plus.jpa.service.IHTipoparantecService;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoParentesco.class */
public class JIFTipoParentesco extends JInternalFrame {
    private HTipoparantec hTipoparantec;
    private final IHTipoparantecService hTipoparantecService;
    private List<HTipoparantec> listarP;
    private DefaultTableModel modelo;
    private Metodos metodo;
    private Object[] dato;
    private int estado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPTipo;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTable JTable;

    public JIFTipoParentesco() {
        initComponents();
        this.hTipoparantec = new HTipoparantec();
        this.hTipoparantecService = (IHTipoparantecService) Principal.contexto.getBean(IHTipoparantecService.class);
        this.listarP = new ArrayList();
        this.estado = 1;
        cargarDatostabla();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JSPTipo = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE PARENTESCO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftipoparentesco");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFTipoParentesco.1
            public void keyTyped(KeyEvent evt) {
                JIFTipoParentesco.this.JTFCodigoKeyTyped(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoParentesco.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoParentesco.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 270, -2).addGap(18, 18, 18).addComponent(this.JSPTipo, -1, 95, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado))).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JSPTipo, -2, 50, -2))).addContainerGap(35, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoParentesco.3
            public void mouseClicked(MouseEvent evt) {
                JIFTipoParentesco.this.JSPDetalleMouseClicked(evt);
            }
        });
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoParentesco.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoParentesco.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 293, -2).addContainerGap(8, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        selecionarFila();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyTyped(KeyEvent evt) {
        if (this.JTFCodigo.getText().length() == 2) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleMouseClicked(MouseEvent evt) {
    }

    public void nuevo() {
        this.metodo.limpiarControles(this.JPIDatos, true);
        cargarDatostabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"CODIGO", "NOMBRE", "TIPO", "ESTADO"}) { // from class: ParametrizacionN.JIFTipoParentesco.5
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
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

    private void cargarDatostabla() {
        crearModeloDatos();
        this.listarP = this.hTipoparantecService.listarTipoparantec();
        this.listarP.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getCodigo(), this.JTable.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNbre(), this.JTable.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getTipo(), this.JTable.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getEstado(), this.JTable.getRowCount() - 1, 3);
        });
    }

    public void grabar() {
        if (!this.JTFCodigo.getText().isEmpty() || !this.JTFNombre.getText().isEmpty()) {
            this.hTipoparantec.setCodigo(this.JTFCodigo.getText());
            this.hTipoparantec.setNbre(this.JTFNombre.getText());
            this.hTipoparantec.setTipo((Integer) this.JSPTipo.getValue());
            this.hTipoparantec.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            String id = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
            this.hTipoparantec.setUsuarioS(id);
            this.hTipoparantecService.grabar(this.hTipoparantec);
            JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
            this.JTFCodigo.setText("");
            this.JTFNombre.setText("");
            this.JSPTipo.setValue(0);
            cargarDatostabla();
            Principal.txtNo.setText("");
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese los datos");
        }
        cargarDatostabla();
    }

    private void selecionarFila() {
        if (this.JTable.getSelectedRow() != -1) {
            this.hTipoparantec = this.listarP.get(this.JTable.getSelectedRow());
            Principal.txtNo.setText(this.hTipoparantec.getId().toString());
            this.JTFCodigo.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTable.getSelectedRow(), 1).toString());
            this.JSPTipo.setValue(Integer.valueOf(this.modelo.getValueAt(this.JTable.getSelectedRow(), 2).toString()));
            this.JCHEstado.setSelected(this.listarP.get(this.JTable.getSelectedRow()).getEstado().booleanValue());
        }
    }
}
