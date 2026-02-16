package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFCambiarEstadoProductoSolicitud.class */
public class JIFCambiarEstadoProductoSolicitud extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidempresa;
    private String xname;
    private int xp;
    private boolean xlleno;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JCheckBox JCHActivo;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNSP;
    private JTable JTDetalle;
    public JTextField JTFProducto;
    public JTextField JTFProveedor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xnfila = 0;
    private String sql = "";

    public JIFCambiarEstadoProductoSolicitud() {
        this.xlleno = false;
        initComponents();
        mCrearModeloDatos();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JSPNSP = new JSpinner();
        this.JTFProveedor = new JTextField();
        this.JTFProducto = new JTextField();
        this.JCHActivo = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(817, 640));
        setMinimumSize(new Dimension(817, 640));
        setName("jismodificarsolicitudp");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPNSP.setFont(new Font("Arial", 1, 12));
        this.JSPNSP.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNSP.setBorder(BorderFactory.createTitledBorder((Border) null, "NSP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProveedor.setFont(new Font("Arial", 1, 12));
        this.JTFProveedor.setHorizontalAlignment(2);
        this.JTFProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProducto.setFont(new Font("Arial", 1, 12));
        this.JTFProducto.setHorizontalAlignment(2);
        this.JTFProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setText("Entro?");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Inventarios.JIFCambiarEstadoProductoSolicitud.1
            public void actionPerformed(ActionEvent evt) {
                JIFCambiarEstadoProductoSolicitud.this.JCHActivoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPNSP, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFProveedor, -1, 702, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFProducto, -1, 700, 32767).addGap(25, 25, 25).addComponent(this.JCHActivo))).addGap(18, 18, 18)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNSP, -2, 46, -2).addComponent(this.JTFProveedor)).addGap(13, 13, 13).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFProducto, -1, 52, 32767).addComponent(this.JCHActivo)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFCambiarEstadoProductoSolicitud.2
            public void mouseClicked(MouseEvent evt) {
                JIFCambiarEstadoProductoSolicitud.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 832, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(26, 26, 26).addComponent(this.JSPDetalle, -2, 330, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        if (this.JCHActivo.isSelected()) {
            this.xp = 1;
        } else {
            this.xp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFProducto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHActivo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xp = 1;
            } else {
                this.xp = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        mCrearModeloDatos();
        this.xp = 1;
        this.JSPNSP.setValue(new Integer(0));
        this.JTFProducto.setText("");
        this.JTFProveedor.setText("");
        this.JCHActivo.setSelected(true);
        this.JSPNSP.requestFocus();
    }

    public void mGrabar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.sql = "update i_manejo_puntosr set Entro='" + this.xp + "' where Id='" + Principal.txtNo.getText() + "'";
            this.xconsulta.ejecutarSQL(this.sql);
            this.xconsulta.cerrarConexionBd();
            mBuscar();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe sleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mBuscar() {
        this.sql = "SELECT cc_terceros.RazonSocialCompleta, i_manejo_puntosr.Id, concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre) AS NombreS, i_manejo_puntosr.Cantidad, i_manejo_puntosr.Entro FROM i_manejo_puntosr INNER JOIN cc_terceros ON (i_manejo_puntosr.Id_Proveedor = cc_terceros.Id) INNER JOIN i_suministro ON (i_manejo_puntosr.Id_Producto = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_manejo_puntosr.Id_msolicitud ='" + this.JSPNSP.getValue() + "') ORDER BY NombreS ASC ";
        mCargarDatosTabla(this.sql);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Suministro", "Cantidad", "Entro?"}) { // from class: Inventarios.JIFCambiarEstadoProductoSolicitud.3
            Class[] types = {Long.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFProveedor.setText(xrs.getString(1));
                xrs.beforeFirst();
                this.xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(3), this.xnfila, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), this.xnfila, 3);
                    this.xnfila++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCambiarEstadoProductoSolicitud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
