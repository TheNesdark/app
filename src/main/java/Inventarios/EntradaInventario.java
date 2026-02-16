package Inventarios;

import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/EntradaInventario.class */
public class EntradaInventario extends JInternalFrame {
    private ResultSet rs;
    private Object[] dato;
    private int cboLleno;
    private String sql;
    private String[][] listaProducto;
    private String[][] listaLote;
    private DefaultTableModel modelo;
    private claseInventario claseInv;
    private JButton btnGrabar;
    private JButton btnRefrescar;
    private ButtonGroup buttonGroup1;
    private JComboBox cboLote;
    private JComboBox cboProducto;
    public JTable grid;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JPanel panelValor;
    public JTextField txtBodega;
    private JFormattedTextField txtCantLote;
    private JSpinner txtCantidad;
    private JTextField txtCodigo;
    private JFormattedTextField txtExistencia;
    private JTextField txtInvima;
    private JTextField txtPresentacionComercial;
    private JSpinner txtValor;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;

    public EntradaInventario(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 10, Toolkit.getDefaultToolkit().getScreenSize().height - 200);
        setTitle("Entrada de Productos a Inventario Inicial : Bodega : " + this.claseInv.getNbreBodega().toUpperCase());
        this.txtBodega.setText("BODEGA : " + this.claseInv.getNbreBodega().toUpperCase());
        crearGrid();
        cargarComboProductos();
    }

    private void cargarComboProductos() {
        this.cboProducto.removeAllItems();
        this.metodos = new Metodos();
        try {
            this.sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_suministro.CodBarraUnidad, i_presentacioncomercial.Nbre, i_suministroxbodega.Existencia, i_suministroxbodega.Costo, i_suministro.RegistroInvima, i_laboratorio.Nbre, i_suministroxbodega.Id FROM  i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.claseInv.getIdBodega() + "') ORDER BY i_suministro.Nbre ASC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            int i = 0;
            int noFilas = this.rs.getRow();
            this.rs.beforeFirst();
            this.listaProducto = new String[noFilas][8];
            while (this.rs.next()) {
                this.cboProducto.addItem(this.rs.getString(2) + " - " + this.rs.getString(4) + " - " + this.rs.getString(8));
                this.listaProducto[i][1] = this.rs.getString(1);
                this.listaProducto[i][2] = this.rs.getString(2) + " - " + this.rs.getString(4) + " - " + this.rs.getString(8);
                this.listaProducto[i][3] = this.rs.getString(3);
                this.listaProducto[i][4] = this.rs.getString(4);
                this.listaProducto[i][5] = this.rs.getString(5);
                this.listaProducto[i][6] = this.rs.getString(6);
                this.listaProducto[i][0] = this.rs.getString(7);
                this.listaProducto[i][7] = this.rs.getString(9);
                i++;
            }
            this.cboProducto.setSelectedIndex(-1);
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.cboLleno = 1;
        JTextComponent editor = this.cboProducto.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboProducto));
    }

    private void cargarProducto(int op) {
        if (op == 1) {
            int i = 0;
            while (true) {
                if (i >= this.listaProducto.length) {
                    break;
                }
                if (!this.txtCodigo.getText().equals(this.listaProducto[i][3])) {
                    i++;
                } else {
                    this.cboProducto.setSelectedItem(this.listaProducto[i][2]);
                    break;
                }
            }
        } else {
            this.txtCodigo.setText(this.listaProducto[this.cboProducto.getSelectedIndex()][3]);
        }
        this.txtPresentacionComercial.setText(this.listaProducto[this.cboProducto.getSelectedIndex()][4]);
        this.txtExistencia.setText(this.listaProducto[this.cboProducto.getSelectedIndex()][5]);
        this.txtValor.setValue(Double.valueOf(Double.parseDouble(this.listaProducto[this.cboProducto.getSelectedIndex()][6])));
        this.txtInvima.setText(this.listaProducto[this.cboProducto.getSelectedIndex()][0]);
        cargarLote(this.listaProducto[this.cboProducto.getSelectedIndex()][7]);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "Existencia", "Cantidad", "Vr. Unidad", "Lote", "Vencimiento", "R. Invima"}) { // from class: Inventarios.EntradaInventario.1
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void grabar() {
        if (this.cboProducto.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor escoja un Producto");
            this.cboProducto.requestFocus();
            return;
        }
        if (Integer.parseInt(this.txtCantidad.getValue().toString()) < 1) {
            this.metodos.mostrarMensaje("Por favor digite la Cantidad del Producto que Ingresa");
            this.txtCantidad.requestFocus();
            return;
        }
        if (this.cboLote.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Lote de Fabricación");
            this.cboLote.requestFocus();
            return;
        }
        this.filaGrid = this.modelo.getRowCount();
        this.modelo.addRow(this.dato);
        this.modelo.setValueAt(this.listaProducto[this.cboProducto.getSelectedIndex()][1], this.filaGrid, 0);
        this.modelo.setValueAt(this.txtCodigo.getText(), this.filaGrid, 1);
        this.modelo.setValueAt(this.cboProducto.getSelectedItem(), this.filaGrid, 2);
        this.modelo.setValueAt(this.txtExistencia.getText(), this.filaGrid, 3);
        this.modelo.setValueAt(this.txtCantidad.getValue(), this.filaGrid, 4);
        this.modelo.setValueAt(this.txtValor.getValue(), this.filaGrid, 5);
        this.modelo.setValueAt(this.listaLote[this.cboLote.getSelectedIndex()][1], this.filaGrid, 6);
        this.modelo.setValueAt(this.listaLote[this.cboLote.getSelectedIndex()][2], this.filaGrid, 7);
        this.modelo.setValueAt(this.txtInvima.getText(), this.filaGrid, 8);
        this.listaProducto[this.cboProducto.getSelectedIndex()][5] = String.valueOf(Integer.parseInt(this.txtExistencia.getText()) + Integer.parseInt(this.txtCantidad.getValue().toString()));
        this.sql = "UPDATE i_suministro SET  RegistroInvima = '" + this.txtInvima.getText() + "' WHERE CodBarraUnidad = '" + this.txtCodigo.getText().toUpperCase() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE i_suministroxbodega SET  Existencia =  Existencia +'" + this.txtCantidad.getValue() + "', Costo = '" + this.txtValor.getValue() + "' WHERE IdBodega = '" + this.claseInv.getIdBodega() + "' AND IdSuministro = '" + this.modelo.getValueAt(this.filaGrid, 0) + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "SELECT Id FROM i_suministroxbodega WHERE IdBodega = '" + this.claseInv.getIdBodega() + "' AND IdSuministro = '" + this.modelo.getValueAt(this.filaGrid, 0) + "'";
        String IdSumBod = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "SELECT Id, Lote FROM i_suministroxlotexbodega WHERE Id = '" + IdSumBod + "' AND Lote ='" + this.listaLote[this.cboLote.getSelectedIndex()][1] + "'";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.sql = "UPDATE i_suministroxlotexbodega SET  Cantidad = Cantidad + '" + this.txtCantidad.getValue() + "' WHERE Id = '" + IdSumBod + "' AND Lote ='" + this.listaLote[this.cboLote.getSelectedIndex()][1] + "'";
                this.consultas.ejecutarSQL(this.sql);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.filaGrid++;
        limpiarDatosProducto();
    }

    private void limpiarDatosProducto() {
        this.txtCodigo.setText("");
        this.cboProducto.setSelectedIndex(-1);
        this.txtPresentacionComercial.setText("");
        this.txtExistencia.setText("0");
        this.txtCantidad.setValue(1);
        this.txtValor.setValue(1);
        this.cboLote.setSelectedIndex(-1);
        this.txtInvima.setText("");
        this.txtCantLote.setText("0");
    }

    public void cargarLote(String IdLotexBodega) {
        try {
            this.cboLote.removeAllItems();
            this.cboLote.setSelectedIndex(-1);
            this.sql = "SELECT i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.FechaVencimiento, i_suministroxlotexbodega.Cantidad, i_suministroxbodega.Reposicion FROM i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxlotexbodega.Id ='" + IdLotexBodega + "' AND i_suministroxlotexbodega.Lote <> 'FALTANTE') ORDER BY i_suministroxlotexbodega.FechaVencimiento ASC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            int i = 0;
            int noFilas = this.rs.getRow();
            if (noFilas > 0) {
                this.rs.beforeFirst();
                this.listaLote = new String[noFilas + 1][4];
                while (this.rs.next()) {
                    this.listaLote[i][0] = this.rs.getString(1);
                    this.listaLote[i][1] = this.rs.getString(2);
                    this.listaLote[i][2] = this.metodos.formatoAMD.format((Date) this.rs.getDate(3));
                    this.listaLote[i][3] = this.rs.getString(4);
                    this.cboLote.addItem(this.rs.getString(2) + " - Vence " + this.rs.getString(3).substring(0, 10));
                    i++;
                }
            }
            this.cboLote.setSelectedIndex(-1);
            this.txtCantLote.setText("0");
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel2 = new JPanel();
        this.txtCodigo = new JTextField();
        this.cboProducto = new JComboBox();
        this.panelValor = new JPanel();
        this.txtCantidad = new JSpinner();
        this.txtValor = new JSpinner();
        this.txtExistencia = new JFormattedTextField();
        this.txtInvima = new JTextField();
        this.cboLote = new JComboBox();
        this.txtCantLote = new JFormattedTextField();
        this.txtPresentacionComercial = new JTextField();
        this.btnRefrescar = new JButton();
        this.btnGrabar = new JButton();
        this.txtBodega = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("INVENTARIO DE PRODUCTOS - CARGUE DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("FIEntradaInventario");
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.EntradaInventario.2
            public void keyReleased(KeyEvent evt) {
                EntradaInventario.this.gridKeyReleased(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL PRODUCTO QUE ENTRA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.3
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.EntradaInventario.4
            public void focusGained(FocusEvent evt) {
                EntradaInventario.this.txtCodigoFocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 39, 190, 41);
        this.cboProducto.setEditable(true);
        this.cboProducto.setFont(new Font("Arial", 1, 12));
        this.cboProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProducto.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.5
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.cboProductoActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.cboProducto);
        this.cboProducto.setBounds(210, 40, 560, 40);
        this.panelValor.setBorder(BorderFactory.createEtchedBorder());
        this.panelValor.setLayout((LayoutManager) null);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setModel(new SpinnerNumberModel());
        this.txtCantidad.setToolTipText("Cantidad del Producto que entra");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.panelValor.add(this.txtCantidad);
        this.txtCantidad.setBounds(530, 20, 110, 40);
        this.txtValor.setFont(new Font("Arial", 1, 12));
        this.txtValor.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValor.addChangeListener(new ChangeListener() { // from class: Inventarios.EntradaInventario.6
            public void stateChanged(ChangeEvent evt) {
                EntradaInventario.this.txtValorStateChanged(evt);
            }
        });
        this.panelValor.add(this.txtValor);
        this.txtValor.setBounds(650, 20, 120, 40);
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(0, 51, 153));
        this.txtExistencia.setEnabled(false);
        this.txtExistencia.setFont(new Font("Arial", 1, 12));
        this.panelValor.add(this.txtExistencia);
        this.txtExistencia.setBounds(310, 20, 90, 40);
        this.txtInvima.setFont(new Font("Arial", 1, 12));
        this.txtInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Registro Invima", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtInvima.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.7
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.txtInvimaActionPerformed(evt);
            }
        });
        this.txtInvima.addFocusListener(new FocusAdapter() { // from class: Inventarios.EntradaInventario.8
            public void focusGained(FocusEvent evt) {
                EntradaInventario.this.txtInvimaFocusGained(evt);
            }
        });
        this.panelValor.add(this.txtInvima);
        this.txtInvima.setBounds(780, 20, 160, 40);
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote y Fecha de Vencimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.9
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.cboLoteActionPerformed(evt);
            }
        });
        this.panelValor.add(this.cboLote);
        this.cboLote.setBounds(10, 20, 290, 40);
        this.txtCantLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantLote.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtCantLote.setHorizontalAlignment(4);
        this.txtCantLote.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCantLote.setEnabled(false);
        this.txtCantLote.setFont(new Font("Arial", 1, 12));
        this.panelValor.add(this.txtCantLote);
        this.txtCantLote.setBounds(410, 20, 110, 40);
        this.jPanel2.add(this.panelValor);
        this.panelValor.setBounds(10, 90, 950, 70);
        this.txtPresentacionComercial.setEditable(false);
        this.txtPresentacionComercial.setFont(new Font("Arial", 1, 12));
        this.txtPresentacionComercial.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Comercial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel2.add(this.txtPresentacionComercial);
        this.txtPresentacionComercial.setBounds(780, 40, 180, 40);
        this.btnRefrescar.setFont(new Font("Arial", 1, 12));
        this.btnRefrescar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnRefrescar.setText("Refrescar Productos");
        this.btnRefrescar.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.10
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.btnRefrescarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnRefrescar);
        this.btnRefrescar.setBounds(970, 30, 190, 50);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Inventarios.EntradaInventario.11
            public void actionPerformed(ActionEvent evt) {
                EntradaInventario.this.btnGrabarActionPerformed(evt);
            }
        });
        this.btnGrabar.addKeyListener(new KeyAdapter() { // from class: Inventarios.EntradaInventario.12
            public void keyPressed(KeyEvent evt) {
                EntradaInventario.this.btnGrabarKeyPressed(evt);
            }
        });
        this.jPanel2.add(this.btnGrabar);
        this.btnGrabar.setBounds(970, 90, 190, 70);
        this.txtBodega.setBackground((Color) null);
        this.txtBodega.setFont(new Font("Tahoma", 1, 16));
        this.txtBodega.setForeground(new Color(204, 255, 255));
        this.txtBodega.setHorizontalAlignment(0);
        this.txtBodega.setDisabledTextColor(new Color(204, 255, 255));
        this.txtBodega.setEnabled(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 1177, -2).addComponent(this.jPanel2, -2, 1188, -2).addComponent(this.txtBodega, -1, 1196, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtBodega, -2, 36, -2).addGap(7, 7, 7).addComponent(this.jPanel2, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 432, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProductoActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboProducto.getSelectedIndex() > -1) {
            cargarProducto(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRefrescarActionPerformed(ActionEvent evt) {
        this.cboLleno = 0;
        limpiarDatosProducto();
        cargarComboProductos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
        this.txtCodigo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        cargarProducto(1);
        this.cboProducto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            grabar();
            this.txtCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtInvimaActionPerformed(ActionEvent evt) {
        this.btnGrabar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboLote.getSelectedIndex() > -1) {
            this.txtCantLote.setText(this.listaLote[this.cboLote.getSelectedIndex()][3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtInvimaFocusGained(FocusEvent evt) {
        this.txtInvima.selectAll();
    }
}
