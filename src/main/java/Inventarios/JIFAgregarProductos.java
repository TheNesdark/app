package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAgregarProductos.class */
public class JIFAgregarProductos extends JInternalFrame {
    private String[] xiduno;
    private String[] xidlaboratorio;
    private DefaultTableModel modeloB;
    private DefaultTableModel modeloP;
    private Object[] xdato;
    private DefaultTableModel xmodcombos;
    private ButtonGroup JBGOpciones;
    private JTableComboBox JCBUno;
    private JPanel JPDatos;
    private JPanel JPITipo;
    private JRadioButton JRBBodega;
    private JRadioButton JRBProveedores;
    private JScrollPane JSPDetalle;
    private JSpinner JSPMaximo;
    private JSpinner JSPMinimo;
    private JSpinner JSPPFRepo;
    public JTable JTBDetalle;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNombre;
    private JPanel jPanel2;
    private String xsql = null;
    private boolean xestado = true;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();

    public JIFAgregarProductos() {
        initComponents();
        mCargarComboEmpresa();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JPITipo = new JPanel();
        this.JRBProveedores = new JRadioButton();
        this.JRBBodega = new JRadioButton();
        try {
            this.JCBUno = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.jPanel2 = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPPFRepo = new JSpinner();
        this.JSPMinimo = new JSpinner();
        this.JSPMaximo = new JSpinner();
        this.JTFFValor = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("ADICIONAR PRODUCTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifadicionarp");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e12) {
            e12.printStackTrace();
        }
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOpciones.add(this.JRBProveedores);
        this.JRBProveedores.setFont(new Font("Arial", 1, 12));
        this.JRBProveedores.setSelected(true);
        this.JRBProveedores.setText("Proveedores");
        this.JRBProveedores.addActionListener(new ActionListener() { // from class: Inventarios.JIFAgregarProductos.1
            public void actionPerformed(ActionEvent evt) {
                JIFAgregarProductos.this.JRBProveedoresActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBBodega);
        this.JRBBodega.setFont(new Font("Arial", 1, 12));
        this.JRBBodega.setText("Bodega");
        this.JRBBodega.addActionListener(new ActionListener() { // from class: Inventarios.JIFAgregarProductos.2
            public void actionPerformed(ActionEvent evt) {
                JIFAgregarProductos.this.JRBBodegaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBBodega).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JRBProveedores).addContainerGap()));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProveedores).addComponent(this.JRBBodega)).addContainerGap(-1, 32767)));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setHorizontalAlignment(2);
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addActionListener(new ActionListener() { // from class: Inventarios.JIFAgregarProductos.3
            public void actionPerformed(ActionEvent evt) {
                JIFAgregarProductos.this.JTFCodigoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFAgregarProductos.4
            public void keyReleased(KeyEvent evt) {
                JIFAgregarProductos.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JPITipo, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCBUno, -1, -1, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 800, -2))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBUno, -1, -1, 32767).addComponent(this.JPITipo, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigo).addComponent(this.JTFNombre, -2, 50, -2)).addGap(24, 24, 24)));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setForeground(new Color(0, 0, 204));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setEditingColumn(1);
        this.JTBDetalle.setEditingRow(1);
        this.JTBDetalle.setGridColor(new Color(204, 255, 204));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAgregarProductos.5
            public void mouseClicked(MouseEvent evt) {
                JIFAgregarProductos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JSPPFRepo.setFont(new Font("Arial", 1, 12));
        this.JSPPFRepo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPPFRepo.setBorder(BorderFactory.createTitledBorder((Border) null, "PReposición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMinimo.setFont(new Font("Arial", 1, 12));
        this.JSPMinimo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "PMínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMaximo.setFont(new Font("Arial", 1, 12));
        this.JSPMaximo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "PMáximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setText("0");
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 950, -2).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSPPFRepo, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMinimo, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMaximo, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JTFFValor, -2, 150, -2))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 368, -2).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValor, 0, -1, 32767).addComponent(this.JSPPFRepo).addComponent(this.JSPMinimo).addComponent(this.JSPMaximo, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(43, 43, 43)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, 467, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoActionPerformed(ActionEvent evt) {
        buscarProductos(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        buscarProductos(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProveedoresActionPerformed(ActionEvent evt) {
        mCargarComboEmpresa();
        this.xestado = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBodegaActionPerformed(ActionEvent evt) {
        mCargarComboBodega();
        this.xestado = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
    }

    private void mCargarComboEmpresa() {
        this.xmodcombos = new DefaultTableModel();
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xsql = "SELECT `Id` , `RazonSocialCompleta` FROM  `cc_terceros` WHERE (`EsMInventario` =1) ORDER BY `RazonSocialCompleta` ASC";
        this.xconsulta.llenarComboTabla(this.xsql, this.JCBUno, this.xmodcombos, 1);
        this.JCBUno.setSelectedItem(-1);
        this.xconsulta.cerrarConexionBd();
    }

    private void mCargarComboBodega() {
        this.xmodcombos = new DefaultTableModel();
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodegas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xsql = "SELECT i_bodegas.Id , i_bodegas.Nbre FROM `i_suministroxbodega` INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`)  WHERE (i_bodegas.Estado =0) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC";
        this.xconsulta.llenarComboTabla(this.xsql, this.JCBUno, this.xmodcombos, 1);
        this.JCBUno.setSelectedItem(-1);
        this.xconsulta.cerrarConexionBd();
    }

    private void buscarProductos(int op) {
        crearGridProductos();
        String sql = op == 1 ? "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacionfarmaceutica.Nbre ,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS nombres, i_suministro.CodigoAgrupacion   FROM i_suministro INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_presentacionfarmaceutica   ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) Where ( i_suministro.CodBarraUnidad ='" + this.JTFCodigo.getText() + "'" : "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacionfarmaceutica.Nbre ,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS nombres, i_suministro.CodigoAgrupacion   FROM i_suministro INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_presentacionfarmaceutica   ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) Where ( i_suministro.Nbre like'" + this.JTFNombre.getText() + "%'";
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(sql + ") ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre");
        int fila = 0;
        while (rs.next()) {
            try {
                this.modeloP.addRow(this.xdato);
                this.modeloP.setValueAt(Long.valueOf(rs.getLong(1)), fila, 0);
                this.modeloP.setValueAt(rs.getString(2), fila, 1);
                this.modeloP.setValueAt(Long.valueOf(rs.getLong(3)), fila, 2);
                fila++;
            } catch (SQLException ex) {
                xmt.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        xmt.cerrarConexionBd();
    }

    private void crearGridProductos() {
        this.modeloP = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre Producto", "Codigo Agrupacion"}) { // from class: Inventarios.JIFAgregarProductos.6
            Class[] types = {Integer.class, String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.modeloP);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setMinWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setMaxWidth(100);
    }

    public void nuevo() {
        this.xestado = true;
        mCargarComboEmpresa();
        crearGridProductos();
        this.JRBProveedores.setSelected(true);
        this.JTFCodigo.setText((String) null);
        this.JTFNombre.setText((String) null);
        this.JSPPFRepo.setValue(new Integer(0));
        this.JSPMinimo.setValue(new Integer(0));
        this.JSPMaximo.setValue(new Integer(0));
    }

    public void grabar() {
        String sql;
        if (this.JCBUno.getSelectedIndex() != -1) {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    if (this.xestado) {
                        sql = "insert ignore into  i_reposiciones set Id_Suministro='" + this.modeloP.getValueAt(this.JTBDetalle.getSelectedRow(), 2) + "', Id_Proveedores='" + this.JCBUno.getPopupTable().getValueAt(this.JCBUno.getSelectedIndex(), 0) + "', Id_Bodega='" + Principal.xClaseInventario.getIdBodega() + "', PReposicion='" + this.JSPPFRepo.getValue() + "', Minimo='" + this.JSPMinimo.getValue() + "', Maximo='" + this.JSPMaximo.getValue() + "', Valor='" + this.JTFFValor.getValue() + "'";
                    } else {
                        sql = "Insert ignore into i_reposicionesbodegas set Id_Suministro='" + this.modeloP.getValueAt(this.JTBDetalle.getSelectedRow(), 2) + "', Id_Bodegas='" + this.JCBUno.getPopupTable().getValueAt(this.JCBUno.getSelectedIndex(), 0) + "', PReposicion='" + this.JSPPFRepo.getValue() + "', Minimo='" + this.JSPMinimo.getValue() + "', Maximo='" + this.JSPMaximo.getValue() + "'";
                    }
                    ConsultasMySQL xmt = new ConsultasMySQL();
                    xmt.ejecutarSQL(sql);
                    xmt.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTBDetalle.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor/bodega", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBUno.requestFocus();
    }
}
