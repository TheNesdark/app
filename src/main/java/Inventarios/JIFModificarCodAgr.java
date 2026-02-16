package Inventarios;

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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFModificarCodAgr.class */
public class JIFModificarCodAgr extends JInternalFrame {
    private DefaultTableModel xmodeloP;
    private Object[] xdato;
    private DefaultTableModel xmodcombos;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xestado = false;
    private int xopc = 0;
    private ButtonGroup JBGOpciones;
    private JTableComboBox JCBSuministroAgr;
    private JPanel JPTipo;
    private JRadioButton JRBSeleccion;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle1;
    public JTable JTBDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JPanel jPanel1;

    public JIFModificarCodAgr() {
        initComponents();
        mCargarCombos();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPTipo = new JPanel();
        this.JRBSeleccion = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        try {
            this.JCBSuministroAgr = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("MODIFICAR Y/O CONSULTAR CÓDIGOS DE AGRUPACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifmodificarcodagrup");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e12) {
            e12.printStackTrace();
        }
        setVerifyInputWhenFocusTarget(false);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JTBDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setEditingColumn(1);
        this.JTBDetalle.setEditingRow(1);
        this.JTBDetalle.setGridColor(new Color(255, 255, 255));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFModificarCodAgr.1
            public void mouseClicked(MouseEvent evt) {
                JIFModificarCodAgr.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTBDetalle);
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Actualizacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOpciones.add(this.JRBSeleccion);
        this.JRBSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccion.setSelected(true);
        this.JRBSeleccion.setText("Seleccion");
        this.JRBSeleccion.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarCodAgr.2
            public void actionPerformed(ActionEvent evt) {
                JIFModificarCodAgr.this.JRBSeleccionActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarCodAgr.3
            public void actionPerformed(ActionEvent evt) {
                JIFModificarCodAgr.this.JRBTodosActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addComponent(this.JRBSeleccion).addGap(18, 18, 18).addComponent(this.JRBTodos).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSeleccion).addComponent(this.JRBTodos)).addContainerGap(-1, 32767)));
        this.JCBSuministroAgr.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Producto para Agrupar", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSuministroAgr.setFont(new Font("Arial", 1, 12));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setHorizontalAlignment(2);
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarCodAgr.4
            public void actionPerformed(ActionEvent evt) {
                JIFModificarCodAgr.this.JTFCodigoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFModificarCodAgr.5
            public void keyReleased(KeyEvent evt) {
                JIFModificarCodAgr.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -1, 55, 32767).addComponent(this.JTFNombre, -2, 53, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSuministroAgr, -2, 732, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipo, -2, -1, -2).addComponent(this.JCBSuministroAgr, -2, 52, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoActionPerformed(ActionEvent evt) {
        this.xopc = 1;
        buscarProductos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        this.xopc = 2;
        buscarProductos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionActionPerformed(ActionEvent evt) {
        this.xestado = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xestado = true;
    }

    private void mCargarCombos() {
        this.xmodcombos = new DefaultTableModel();
        this.xconsultas.llenarComboTabla("SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacionfarmaceutica.Nbre ,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS nombres   FROM baseserver.i_suministro INNER JOIN baseserver.i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN baseserver.i_presentacionfarmaceutica   ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN baseserver.i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN baseserver.i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id)  ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre", this.JCBSuministroAgr, this.xmodcombos, 1);
        this.JCBSuministroAgr.setSelectedItem(-1);
        this.xconsultas.cerrarConexionBd();
    }

    private void buscarProductos() {
        crearGridProductos();
        String sql = this.xopc == 1 ? "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacionfarmaceutica.Nbre ,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS nombres , i_suministro.CodigoAgrupacion AS CodAgru  FROM baseserver.i_suministro INNER JOIN baseserver.i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN baseserver.i_presentacionfarmaceutica   ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN baseserver.i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN baseserver.i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (i_suministro.CodBarraUnidad ='" + this.JTFCodigo.getText() + "'" : "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacionfarmaceutica.Nbre ,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS nombres , i_suministro.CodigoAgrupacion AS CodAgru  FROM baseserver.i_suministro INNER JOIN baseserver.i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN baseserver.i_presentacionfarmaceutica   ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN baseserver.i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN baseserver.i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (i_suministro.Nbre like'" + this.JTFNombre.getText() + "%'";
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(sql + ") ORDER BY i_presentacionfarmaceutica.Nbre, i_suministro.Nbre ASC");
        int fila = 0;
        while (rs.next()) {
            try {
                this.xmodeloP.addRow(this.xdato);
                this.xmodeloP.setValueAt(Long.valueOf(rs.getLong(1)), fila, 0);
                this.xmodeloP.setValueAt(rs.getString(2), fila, 1);
                this.xmodeloP.setValueAt(Long.valueOf(rs.getLong(3)), fila, 2);
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
        this.xmodeloP = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Suministro", "CódigoAgr"}) { // from class: Inventarios.JIFModificarCodAgr.6
            Class[] types = {Integer.class, String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodeloP);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void nuevo() {
        crearGridProductos();
        this.JTFCodigo.setText((String) null);
        this.JTFNombre.setText((String) null);
        mCargarCombos();
        this.xopc = 0;
    }

    public void grabar() {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            if (this.JCBSuministroAgr.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    ConsultasMySQL xmt = new ConsultasMySQL();
                    if (!this.xestado) {
                        String sql = "update i_suministro set CodigoAgrupacion='" + this.JCBSuministroAgr.getPopupTable().getValueAt(this.JCBSuministroAgr.getSelectedIndex(), 0) + "' where Id='" + this.xmodeloP.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                        xmt.ejecutarSQL(sql);
                        xmt.cerrarConexionBd();
                    } else {
                        for (int y = 0; y < this.JTBDetalle.getRowCount(); y++) {
                            if (this.xmodeloP.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals(this.xmodeloP.getValueAt(y, 2).toString())) {
                                String sql2 = "update i_suministro set CodigoAgrupacion='" + this.JCBSuministroAgr.getPopupTable().getValueAt(this.JCBSuministroAgr.getSelectedIndex(), 0) + "' where Id='" + this.xmodeloP.getValueAt(y, 0) + "'";
                                xmt.ejecutarSQL(sql2);
                                xmt.cerrarConexionBd();
                            }
                        }
                    }
                    buscarProductos();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar suminitro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBSuministroAgr.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTBDetalle.requestFocus();
    }
}
