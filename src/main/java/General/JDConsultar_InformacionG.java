package General;

import Acceso.Principal;
import ParametrizacionN.JIFCClaseCita;
import com.genoma.plus.jpa.projection.Procedimientos;
import com.genoma.plus.jpa.service.IClaseCitaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JDConsultar_InformacionG.class */
public class JDConsultar_InformacionG extends JDialog {
    private JInternalFrame xjif_generico;
    private DefaultTableModel xmodelo;
    private final IClaseCitaService claseCitaService;
    private Object[] xdato;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JDConsultar_InformacionG(Frame parent, boolean modal, JInternalFrame xjif_generico, String xTitulo) {
        super(parent, modal);
        this.claseCitaService = (IClaseCitaService) Principal.contexto.getBean(IClaseCitaService.class);
        initComponents();
        setTitle(xTitulo);
        this.xjif_generico = xjif_generico;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: General.JDConsultar_InformacionG.1
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
    }

    private void cargarDatos(String busqueda) {
        crearModelo();
        List<Procedimientos> listaProcedimientos = this.claseCitaService.listaProcedimientos(busqueda);
        for (int j = 0; j < listaProcedimientos.size(); j++) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(listaProcedimientos.get(j).getId(), j, 0);
            this.xmodelo.setValueAt(listaProcedimientos.get(j).getNombre(), j, 1);
        }
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE BUSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: General.JDConsultar_InformacionG.2
            public void keyPressed(KeyEvent evt) {
                JDConsultar_InformacionG.this.JTFCodigoKeyPressed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: General.JDConsultar_InformacionG.3
            public void keyPressed(KeyEvent evt) {
                JDConsultar_InformacionG.this.JTFNombreKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFCodigo, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -1, 563, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: General.JDConsultar_InformacionG.4
            public void mouseClicked(MouseEvent evt) {
                JDConsultar_InformacionG.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane1).addGap(5, 5, 5)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, 254, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -1, -1, 32767).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -1, -1, 32767).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        cargarDatos(this.JTFNombre.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyPressed(KeyEvent evt) {
        cargarDatos(this.JTFCodigo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xjif_generico.getName().equals("jifclasecita")) {
            JIFCClaseCita xjif_generico1 = (JIFCClaseCita) this.xjif_generico;
            xjif_generico1.JCBProcedimiento.setSelectedItem(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "-" + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1));
            dispose();
        }
    }
}
