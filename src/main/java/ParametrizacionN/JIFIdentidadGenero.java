package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GIdentidadGenero;
import com.genoma.plus.jpa.service.IIdentidadGeneroService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFIdentidadGenero.class */
public class JIFIdentidadGenero extends JInternalFrame {
    private GIdentidadGenero gIdentidadGenero;
    private final IIdentidadGeneroService iIdentidadGeneroService;
    private Metodos xmetodos;
    private int xestado = 1;
    private DefaultTableModel modelo;
    private List<GIdentidadGenero> ListarGIdentidadGenero;
    private GIdentidadGenero gidentidadgenero;
    private Object[] dato;
    private JCheckBox JCHEstado;
    private JTable JTBGenero;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFIdentidadGenero() {
        this.xmetodos = new Metodos();
        initComponents();
        this.iIdentidadGeneroService = (IIdentidadGeneroService) Principal.contexto.getBean(IIdentidadGeneroService.class);
        cargarDatosTabla();
        this.modelo = new DefaultTableModel();
        this.xmetodos = new Metodos();
        this.ListarGIdentidadGenero = new ArrayList();
        this.gIdentidadGenero = new GIdentidadGenero();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        cargarDatosTabla();
    }

    public void Grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.gIdentidadGenero.setNombre(this.JTFNombre.getText());
            this.gIdentidadGenero.setCodigo(this.JTFCodigo.getText());
            this.gIdentidadGenero.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.iIdentidadGeneroService.grabar(this.gIdentidadGenero);
        }
    }

    public void crearModeloDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "codigo", "Estado"}) { // from class: ParametrizacionN.JIFIdentidadGenero.1
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBGenero.setModel(this.modelo);
        this.JTBGenero.setAutoResizeMode(0);
        this.JTBGenero.doLayout();
        this.JTBGenero.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTBGenero.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBGenero.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void cargarDatosTabla() {
        crearModeloDatos();
        this.ListarGIdentidadGenero = this.iIdentidadGeneroService.listarGIdentidadGeneros();
        this.ListarGIdentidadGenero.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getNombre(), this.JTBGenero.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getCodigo(), this.JTBGenero.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTBGenero.getRowCount() - 1, 2);
        });
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTBGenero = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        setTitle("GENERO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenero");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBGenero.setFont(new Font("Arial", 1, 12));
        this.JTBGenero.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBGenero.setToolTipText("");
        this.JTBGenero.setName("jifidentidad_genero");
        this.JTBGenero.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFIdentidadGenero.2
            public void mouseClicked(MouseEvent evt) {
                JIFIdentidadGenero.this.JTBGeneroMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTBGenero);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setName("jifgenero");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFIdentidadGenero.3
            public void actionPerformed(ActionEvent evt) {
                JIFIdentidadGenero.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JTFNombre, -2, 170, -2).addGap(70, 70, 70).addComponent(this.JTFCodigo, -2, 144, -2).addGap(59, 59, 59).addComponent(this.JCHEstado).addContainerGap(63, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 47, -2).addComponent(this.JTFCodigo, -2, 47, -2).addComponent(this.JCHEstado)).addContainerGap(33, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(22, 22, 22).addComponent(this.jScrollPane1, -2, 300, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBGeneroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.gIdentidadGenero = this.ListarGIdentidadGenero.get(this.JTBGenero.getSelectedRow());
            this.JTFNombre.setText(this.ListarGIdentidadGenero.get(this.JTBGenero.getSelectedRow()).getNombre());
            this.JTFCodigo.setText(this.ListarGIdentidadGenero.get(this.JTBGenero.getSelectedRow()).getCodigo());
            this.JCHEstado.setSelected(this.ListarGIdentidadGenero.get(this.JTBGenero.getSelectedRow()).getEstado().booleanValue());
        }
    }
}
