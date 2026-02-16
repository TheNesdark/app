package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/CrearLote.class */
public class CrearLote extends JInternalFrame {
    private ResultSet rs;
    private Object[] dato;
    private String sql;
    private String idProducto;
    private String idBodega;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private String[] listaBodega;
    private String[][] listaLote;
    private JComboBox cboBodega;
    public JTable gridProductos;
    private JLabel jLabel2;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JPanel panelValor;
    public JTextField txtBodega;
    private JSpinner txtCantidad;
    private JTextField txtCodigo;
    private JTextField txtLote;
    private JTextField txtProducto;
    private JTextField txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private int cboLleno = 0;

    public CrearLote() {
        initComponents();
        cargarComboBodega();
        crearGridProductos();
        this.gridProductos.addMouseListener(new MouseAdapter() { // from class: Inventarios.CrearLote.1
            public void mouseClicked(MouseEvent e) {
                CrearLote.this.filaGrid = CrearLote.this.gridProductos.rowAtPoint(e.getPoint());
                CrearLote.this.txtCodigo.setText(CrearLote.this.modelo1.getValueAt(CrearLote.this.filaGrid, 1).toString());
                CrearLote.this.txtProducto.setText(CrearLote.this.modelo1.getValueAt(CrearLote.this.filaGrid, 2).toString());
                CrearLote.this.setIdProducto(CrearLote.this.modelo1.getValueAt(CrearLote.this.filaGrid, 0).toString());
            }
        });
    }

    private void buscarProductoPorCodigoBarra() {
        crearGridProductos();
        this.sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministro.CantidadUnidad, i_suministro.RegistroInvima FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) WHERE (i_suministro.CodBarraUnidad ='" + this.txtCodigo.getText() + "' AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                setIdProducto(this.rs.getString(1));
                this.txtProducto.setText(this.rs.getString(2) + " " + this.rs.getString(3) + " " + this.rs.getString(4));
            } else {
                nuevo();
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    private void buscarProductoPorNombre() {
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministro.CantidadUnidad, i_suministro.RegistroInvima FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) WHERE (i_suministro.Nbre LIKE'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                crearGridProductos();
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo1.addRow(this.dato);
                    this.modelo1.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modelo1.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.modelo1.setValueAt(this.rs.getString(3) + " " + this.rs.getString(4) + " " + this.rs.getString(5), this.filaGrid, 2);
                    this.modelo1.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.filaGrid, 3);
                    this.modelo1.setValueAt(this.rs.getString(7), this.filaGrid, 4);
                    this.filaGrid++;
                }
            } else {
                nuevo();
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarComboBodega() {
        this.cboLleno = 0;
        this.sql = "SELECT i_bodegas.Id, i_bodegas.Nbre FROM i_bodegas WHERE (i_bodegas.Estado =0) ORDER BY i_bodegas.Nbre ASC";
        this.listaBodega = this.consultas.llenarCombo(this.sql, this.listaBodega, this.cboBodega);
        this.consultas.cerrarConexionBd();
        this.cboBodega.setSelectedIndex(-1);
        this.cboLleno = 1;
    }

    private void crearGridProductos() {
        this.modelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "Cant. Unidad", "R. Invima"}) { // from class: Inventarios.CrearLote.2
            Class[] types = {String.class, String.class, String.class, Integer.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridProductos.setModel(this.modelo1);
        this.gridProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridProductos.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.gridProductos.getColumnModel().getColumn(2).setPreferredWidth(600);
        this.gridProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.gridProductos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridProductos.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.filaGrid = 0;
    }

    public void grabar() {
        if (validarDatos() == 1) {
            this.sql = "SELECT  Id FROM i_suministroxbodega WHERE (IdBodega ='" + getIdBodega() + "' AND IdSuministro ='" + getIdProducto() + "')";
            String info = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (info != null && !info.equals("") && !info.equals("0")) {
                crearLote(info);
            } else {
                crearSumxBodega();
            }
        }
    }

    private void crearLote(String id) {
        this.sql = "INSERT INTO i_suministroxlotexbodega(Id, Lote, FechaVencimiento, Cantidad) VALUES('" + id + "','" + this.txtLote.getText() + "','" + this.txtVencimiento.getText() + "','" + this.txtCantidad.getValue() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "INSERT INTO i_suministroxlotexbodegainv(Id, Id_Inventario, Lote, FechaVencimiento, Cantidad) VALUES('" + id + "','" + getUltimoInventario() + "','" + this.txtLote.getText() + "','" + this.txtVencimiento.getText() + "','" + this.txtCantidad.getValue() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Lote Grabado");
    }

    private void crearSumxBodega() {
        this.sql = "INSERT INTO i_suministroxbodega(IdBodega, IdSuministro, Costo) VALUES('" + getIdBodega() + "','" + getIdProducto() + "','0')";
        this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "INSERT INTO i_suministroxbodegainv(IdBodega, IdSuministro, Costo) VALUES('" + getIdBodega() + "','" + getIdProducto() + "','0')";
        String info = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        crearLote(info);
    }

    public void nuevo() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.txtCantidad.setValue(1);
        this.txtLote.setText("");
        this.txtVencimiento.setText("");
        crearGridProductos();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtProducto.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
        } else if (this.txtLote.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el Lote del Producto");
            this.txtLote.requestFocus();
        } else if (Integer.parseInt(this.txtCantidad.getValue().toString()) < 1) {
            this.metodos.mostrarMensaje("Por favor digite la Cantidad del Producto del Lote");
            this.txtCantidad.requestFocus();
        } else if (this.txtVencimiento.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite la Fecha de Vencimiento del Lote");
            this.txtVencimiento.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private String getIdBodega() {
        return this.idBodega;
    }

    private String getIdProducto() {
        return this.idProducto;
    }

    private String getUltimoInventario() {
        this.sql = "SELECT max(Id) FROM i_inventario WHERE (Id_Bodega ='" + getIdBodega() + "')";
        String idInv = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (idInv == null || idInv.equals("") || idInv.equals("0")) {
            this.metodos.mostrarMensaje("No se grabo el Nùmero de Inventario en la tabla i_suministroxlotexbodegainv");
        }
        return idInv;
    }

    private void setIdBodega() {
        this.idBodega = this.listaBodega[this.cboBodega.getSelectedIndex()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtBodega = new JTextField();
        this.jPanel2 = new JPanel();
        this.txtCodigo = new JTextField();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.gridProductos = new JTable();
        this.cboBodega = new JComboBox();
        this.panelValor = new JPanel();
        this.txtCantidad = new JSpinner();
        this.txtLote = new JTextField();
        this.txtVencimiento = new JTextField();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CREACIÓN DE LOTES DE SUMINISTROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("CrearLote");
        this.txtBodega.setBackground((Color) null);
        this.txtBodega.setFont(new Font("Arial", 1, 14));
        this.txtBodega.setForeground(new Color(204, 255, 255));
        this.txtBodega.setHorizontalAlignment(0);
        this.txtBodega.setText("CREACION DE LOTES");
        this.txtBodega.setDisabledTextColor(new Color(0, 102, 0));
        this.txtBodega.setEnabled(false);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL PRODUCTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.CrearLote.3
            public void actionPerformed(ActionEvent evt) {
                CrearLote.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.CrearLote.4
            public void focusLost(FocusEvent evt) {
                CrearLote.this.txtCodigoFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 100, 190, 40);
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProducto.addKeyListener(new KeyAdapter() { // from class: Inventarios.CrearLote.5
            public void keyTyped(KeyEvent evt) {
                CrearLote.this.txtProductoKeyTyped(evt);
            }
        });
        this.jPanel2.add(this.txtProducto);
        this.txtProducto.setBounds(210, 100, 750, 40);
        this.gridProductos.setBorder(BorderFactory.createBevelBorder(0));
        this.gridProductos.setFont(new Font("Arial", 1, 12));
        this.gridProductos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridProductos.setEditingColumn(1);
        this.gridProductos.setEditingRow(1);
        this.gridProductos.setRowHeight(25);
        this.gridProductos.setSelectionBackground(new Color(255, 255, 255));
        this.gridProductos.setSelectionForeground(new Color(255, 0, 0));
        this.gridProductos.setSelectionMode(0);
        this.gridProductos.addKeyListener(new KeyAdapter() { // from class: Inventarios.CrearLote.6
            public void keyReleased(KeyEvent evt) {
                CrearLote.this.gridProductosKeyReleased(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridProductos);
        this.jPanel2.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 150, 950, 170);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addItemListener(new ItemListener() { // from class: Inventarios.CrearLote.7
            public void itemStateChanged(ItemEvent evt) {
                CrearLote.this.cboBodegaItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboBodega);
        this.cboBodega.setBounds(10, 40, 390, 40);
        this.panelValor.setBorder(BorderFactory.createEtchedBorder());
        this.panelValor.setLayout((LayoutManager) null);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setToolTipText("Cantidad del Producto que entra");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantidad.addKeyListener(new KeyAdapter() { // from class: Inventarios.CrearLote.8
            public void keyPressed(KeyEvent evt) {
                CrearLote.this.txtCantidadKeyPressed(evt);
            }
        });
        this.panelValor.add(this.txtCantidad);
        this.txtCantidad.setBounds(250, 20, 140, 40);
        this.txtLote.setFont(new Font("Arial", 1, 12));
        this.txtLote.setHorizontalAlignment(0);
        this.txtLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtLote.setDisabledTextColor(new Color(0, 0, 102));
        this.txtLote.addActionListener(new ActionListener() { // from class: Inventarios.CrearLote.9
            public void actionPerformed(ActionEvent evt) {
                CrearLote.this.txtLoteActionPerformed(evt);
            }
        });
        this.panelValor.add(this.txtLote);
        this.txtLote.setBounds(10, 19, 230, 41);
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        this.txtVencimiento.setHorizontalAlignment(0);
        this.txtVencimiento.setToolTipText("Formato de Fecha aaaa/mm/dd");
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Vencimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtVencimiento.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVencimiento.addActionListener(new ActionListener() { // from class: Inventarios.CrearLote.10
            public void actionPerformed(ActionEvent evt) {
                CrearLote.this.txtVencimientoActionPerformed(evt);
            }
        });
        this.panelValor.add(this.txtVencimiento);
        this.txtVencimiento.setBounds(400, 10, 150, 50);
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setForeground(new Color(255, 0, 0));
        this.jLabel2.setText("Formato de fecha aaaa-mm-dd.    Ejemplo 2010-12-31");
        this.panelValor.add(this.jLabel2);
        this.jLabel2.setBounds(560, 20, 380, 30);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtBodega, -1, 990, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, 970, -2).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelValor, -2, 950, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.txtBodega, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 330, -2).addGap(18, 18, 18).addComponent(this.panelValor, -2, 80, -2).addContainerGap(27, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        this.txtProducto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        buscarProductoPorCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoteActionPerformed(ActionEvent evt) {
        this.gridProductos.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyTyped(KeyEvent evt) {
        buscarProductoPorNombre();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridProductosKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno != 1 || this.cboBodega.getSelectedIndex() <= -1) {
            return;
        }
        setIdBodega();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVencimientoActionPerformed(ActionEvent evt) {
    }
}
