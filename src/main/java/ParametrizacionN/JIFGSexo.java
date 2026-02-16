package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GSexo;
import com.genoma.plus.jpa.service.ISexoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGSexo.class */
public class JIFGSexo extends JInternalFrame {
    private GSexo gSexo;
    private final ISexoService iSexoService;
    private Metodos xmetodos;
    private int xestado = 1;
    private DefaultTableModel modelo;
    private String idSexoBiologico;
    private List<GSexo> listaGSexo;
    private GSexo gsexo;
    private Object[] dato;
    private JCheckBox JCHEstado;
    private JPanel JPSexo_biologico;
    private JRadioButton JRBHombre;
    private JRadioButton JRBIndeterminado;
    private JRadioButton JRBMujer;
    private ButtonGroup JRBTNSexo;
    private JTable JTBSexo;
    private JTextField JTFId;
    private JTextField JTFNombre;
    private JTextField JTFResolucion;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFGSexo() {
        this.xmetodos = new Metodos();
        initComponents();
        this.xmetodos = new Metodos();
        this.iSexoService = (ISexoService) Principal.contexto.getBean(ISexoService.class);
        this.modelo = new DefaultTableModel();
        this.listaGSexo = new ArrayList();
        this.gSexo = new GSexo();
        cargarDatosTabla();
    }

    public void setIdSexoBiologico(String idSexoBiologico) {
        this.idSexoBiologico = idSexoBiologico;
    }

    public String getIdSexoBiologico() {
        return this.idSexoBiologico;
    }

    public void Nuevo() {
        this.JTFId.setText("");
        this.JTFNombre.setText("");
        this.JTFResolucion.setText("");
        cargarDatosTabla();
    }

    public void Grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.gSexo.setId(this.JTFId.getText());
            this.gSexo.setNbre(this.JTFNombre.getText());
            this.gSexo.setV256(this.JTFResolucion.getText());
            this.gSexo.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.iSexoService.grabar(this.gSexo);
        }
    }

    private void crearModeloDeDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "v256", "IdSexoBiologico", "Estado"}) { // from class: ParametrizacionN.JIFGSexo.1
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBSexo.setModel(this.modelo);
        this.JTBSexo.setAutoResizeMode(0);
        this.JTBSexo.doLayout();
        this.JTBSexo.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBSexo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBSexo.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBSexo.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBSexo.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void cargarDatosTabla() {
        crearModeloDeDatos();
        this.listaGSexo = this.iSexoService.listaSexoOrdenadoNombreAsc();
        this.listaGSexo.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.JTBSexo.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNbre(), this.JTBSexo.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getV256(), this.JTBSexo.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getIdSexoBiologico(), this.JTBSexo.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getEstado(), this.JTBSexo.getRowCount() - 1, 4);
        });
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JRBTNSexo = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.JTBSexo = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFId = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JTFResolucion = new JTextField();
        this.JPSexo_biologico = new JPanel();
        this.JRBHombre = new JRadioButton();
        this.JRBMujer = new JRadioButton();
        this.JRBIndeterminado = new JRadioButton();
        setTitle("GENERO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsexo");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTBSexo.setFont(new Font("Arial", 1, 14));
        this.JTBSexo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBSexo.setToolTipText("");
        this.JTBSexo.setName("jifsexo");
        this.JTBSexo.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGSexo.2
            public void mouseClicked(MouseEvent evt) {
                JIFGSexo.this.JTBSexoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTBSexo);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGSexo.3
            public void mouseClicked(MouseEvent evt) {
                JIFGSexo.this.jPanel1MouseClicked(evt);
            }
        });
        this.JTFId.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFId.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.4
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JTFIdActionPerformed(evt);
            }
        });
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.5
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.6
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFResolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "V256", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFResolucion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.7
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JTFResolucionActionPerformed(evt);
            }
        });
        this.JPSexo_biologico.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo Biologico", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBTNSexo.add(this.JRBHombre);
        this.JRBHombre.setText("Hombre");
        this.JRBHombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.8
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JRBHombreActionPerformed(evt);
            }
        });
        this.JRBTNSexo.add(this.JRBMujer);
        this.JRBMujer.setText("Mujer");
        this.JRBMujer.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.9
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JRBMujerActionPerformed(evt);
            }
        });
        this.JRBTNSexo.add(this.JRBIndeterminado);
        this.JRBIndeterminado.setText("Indetereminado");
        this.JRBIndeterminado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSexo.10
            public void actionPerformed(ActionEvent evt) {
                JIFGSexo.this.JRBIndeterminadoActionPerformed(evt);
            }
        });
        GroupLayout JPSexo_biologicoLayout = new GroupLayout(this.JPSexo_biologico);
        this.JPSexo_biologico.setLayout(JPSexo_biologicoLayout);
        JPSexo_biologicoLayout.setHorizontalGroup(JPSexo_biologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSexo_biologicoLayout.createSequentialGroup().addGap(34, 34, 34).addGroup(JPSexo_biologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIndeterminado).addComponent(this.JRBMujer).addComponent(this.JRBHombre)).addContainerGap(44, 32767)));
        JPSexo_biologicoLayout.setVerticalGroup(JPSexo_biologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSexo_biologicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBHombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBMujer).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBIndeterminado).addGap(22, 22, 22)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFId, -2, 69, -2).addGap(31, 31, 31).addComponent(this.JTFNombre, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFResolucion, -2, 53, -2).addGap(18, 18, 18).addComponent(this.JPSexo_biologico, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPSexo_biologico, GroupLayout.Alignment.TRAILING, -2, 105, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFId, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JTFResolucion, -2, -1, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JCHEstado))).addGap(45, 45, 45)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 236, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResolucionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMujerActionPerformed(ActionEvent evt) {
        setIdSexoBiologico("02");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIndeterminadoActionPerformed(ActionEvent evt) {
        setIdSexoBiologico("03");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHombreActionPerformed(ActionEvent evt) {
        setIdSexoBiologico("01");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSexoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.gSexo = this.listaGSexo.get(this.JTBSexo.getSelectedRow());
            this.JTFNombre.setText(this.listaGSexo.get(this.JTBSexo.getSelectedRow()).getNbre());
            this.JTFId.setText(this.listaGSexo.get(this.JTBSexo.getSelectedRow()).getId());
            this.JTFResolucion.setText(this.listaGSexo.get(this.JTBSexo.getSelectedRow()).getV256());
            this.JCHEstado.setSelected(this.listaGSexo.get(this.JTBSexo.getSelectedRow()).getEstado().booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jPanel1MouseClicked(MouseEvent evt) {
    }
}
