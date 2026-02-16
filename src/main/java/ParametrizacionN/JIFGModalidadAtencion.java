package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GModalidadatencion;
import com.genoma.plus.jpa.service.IGModalidadAtencionService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGModalidadAtencion.class */
public class JIFGModalidadAtencion extends JInternalFrame {
    private GModalidadatencion gModalidadAtencion;
    private final IGModalidadAtencionService iGModalidadAtencionService;
    private List<GModalidadatencion> listGModalidadAtencion;
    private DefaultTableModel modelo;
    private Object[] datos;
    private Metodos metodo;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JTable JTBHistorico;
    private JTextField JTFCodigo;
    private JTextField JTFModalidadAtencion;
    private JPanel jPanel1;

    public JIFGModalidadAtencion() {
        initComponents();
        this.iGModalidadAtencionService = (IGModalidadAtencionService) Principal.contexto.getBean(IGModalidadAtencionService.class);
        loadDataTable();
    }

    public void mNew() {
        this.JTFCodigo.setText("");
        this.JTFModalidadAtencion.setText("");
        this.JCHEstado.setSelected(false);
        loadDataTable();
        Principal.mLimpiarDatosP();
    }

    public void mSave() {
        if (!this.JTFModalidadAtencion.getText().isEmpty() && !this.JTFCodigo.getText().isEmpty()) {
            this.gModalidadAtencion = new GModalidadatencion();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.gModalidadAtencion = this.listGModalidadAtencion.get(this.JTBHistorico.getSelectedRow());
                this.gModalidadAtencion.setCodigo(this.JTFCodigo.getText());
                this.gModalidadAtencion.setNombre(this.JTFModalidadAtencion.getText());
                this.gModalidadAtencion.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            } else {
                this.gModalidadAtencion.setCodigo(this.JTFCodigo.getText());
                this.gModalidadAtencion.setNombre(this.JTFModalidadAtencion.getText());
                this.gModalidadAtencion.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            }
            this.iGModalidadAtencionService.save(this.gModalidadAtencion);
        } else {
            JOptionPane.showMessageDialog((Component) null, "Faltan datos por llenar");
            this.JTFModalidadAtencion.requestFocus();
            this.JTFCodigo.requestFocus();
        }
        mNew();
    }

    public void createModelTable() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Codigo", "Nombre", "Estado", "UsuarioSistema", "Fecha"}) { // from class: ParametrizacionN.JIFGModalidadAtencion.1
            Class[] types = {String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.modelo);
        this.JTBHistorico.setAutoResizeMode(0);
        this.JTBHistorico.doLayout();
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(129);
    }

    public void loadDataTable() {
        createModelTable();
        this.listGModalidadAtencion = this.iGModalidadAtencionService.getListAllOrderById();
        this.listGModalidadAtencion.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getCodigo(), this.JTBHistorico.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNombre(), this.JTBHistorico.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTBHistorico.getRowCount() - 1, 2);
        });
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFModalidadAtencion = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBHistorico = new JTable();
        setClosable(true);
        setTitle("MODALIDAD DE ATENCION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmodalidadatencion");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Liberation Sans", 1, 14), new Color(0, 105, 0)));
        this.JTFModalidadAtencion.setFont(new Font("Liberation Sans", 1, 12));
        this.JTFModalidadAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Modalidad Atencion", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JTFModalidadAtencion.setPreferredSize(new Dimension(64, 50));
        this.JTFCodigo.setFont(new Font("Liberation Sans", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JCHEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFModalidadAtencion, -2, 435, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JTFCodigo, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(17, 17, 17)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFModalidadAtencion, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2)))).addContainerGap(16, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Liberation Sans", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Liberation Sans", 1, 14));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGModalidadAtencion.2
            public void mouseClicked(MouseEvent evt) {
                JIFGModalidadAtencion.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 290, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.gModalidadAtencion = this.listGModalidadAtencion.get(this.JTBHistorico.getSelectedRow());
            this.JTFCodigo.setText(this.listGModalidadAtencion.get(this.JTBHistorico.getSelectedRow()).getCodigo());
            this.JTFModalidadAtencion.setText(this.listGModalidadAtencion.get(this.JTBHistorico.getSelectedRow()).getNombre());
            this.JCHEstado.setSelected(this.listGModalidadAtencion.get(this.JTBHistorico.getSelectedRow()).getEstado().booleanValue());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString());
        }
    }
}
