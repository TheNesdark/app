package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/ModificarLote.class */
public class ModificarLote extends JInternalFrame {
    private claseInventario claseInv;
    private ResultSet rs;
    private Object[] dato;
    private String sql;
    private String idProducto;
    private String idBodega;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private String[] listaBodega;
    private String[][] listaLote;
    private JCheckBox btnConteo;
    private JCheckBox btnInventario;
    private ButtonGroup buttonGroup1;
    private JComboBox cboBodega;
    private JComboBox cboLote;
    public JTable gridProductos;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JPanel panelValor;
    public JTextField txtBodega;
    private JTextField txtCodigo;
    private JTextField txtInventario;
    private JTextField txtLote;
    private JTextField txtProducto;
    private JDateChooser txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private int cboLleno = 0;
    private int cboLlenoLote = 0;
    private String lote = "";

    public ModificarLote(claseInventario clase) {
        initComponents();
        this.claseInv = clase;
        cargarComboBodega();
        crearGridProductos();
        this.gridProductos.addMouseListener(new MouseAdapter() { // from class: Inventarios.ModificarLote.1
            public void mouseClicked(MouseEvent e) {
                ModificarLote.this.filaGrid = ModificarLote.this.gridProductos.rowAtPoint(e.getPoint());
                ModificarLote.this.txtCodigo.setText(ModificarLote.this.modelo1.getValueAt(ModificarLote.this.filaGrid, 1).toString());
                ModificarLote.this.txtProducto.setText(ModificarLote.this.modelo1.getValueAt(ModificarLote.this.filaGrid, 2).toString());
                ModificarLote.this.setIdProducto(ModificarLote.this.modelo1.getValueAt(ModificarLote.this.filaGrid, 0).toString());
                ModificarLote.this.cargarLote();
            }
        });
    }

    private void buscarNoInventario() {
        this.sql = "SELECT Id FROM i_inventario WHERE (Id_Bodega ='" + getIdBodega() + "' AND Fecha_Cierre ='0000-00-00 00:00:00')";
        this.txtInventario.setText(this.consultas.traerDato(this.sql));
        this.consultas.cerrarConexionBd();
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
                cargarLote();
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

    public void cargarLote() {
        this.consultas = new ConsultasMySQL();
        this.cboLlenoLote = 0;
        try {
            this.cboLote.removeAllItems();
            this.cboLote.setSelectedIndex(-1);
            this.sql = "SELECT i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.FechaVencimiento FROM  i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.idBodega + "' AND i_suministroxbodega.IdSuministro ='" + this.idProducto + "') ORDER BY i_suministroxlotexbodega.FechaVencimiento ASC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            int i = 0;
            int noFilas = this.rs.getRow();
            if (noFilas > 0) {
                this.rs.beforeFirst();
                this.listaLote = new String[noFilas][3];
                while (this.rs.next()) {
                    this.listaLote[i][0] = this.rs.getString("Id");
                    this.listaLote[i][1] = this.rs.getString("Lote");
                    this.listaLote[i][2] = this.metodos.formatoDMA.format((Date) this.rs.getDate("FechaVencimiento"));
                    this.cboLote.addItem(this.rs.getString("Lote") + " - Vence " + this.rs.getString("FechaVencimiento").substring(0, 10));
                    i++;
                }
            }
            this.cboLote.setSelectedIndex(-1);
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.txtVencimiento.setDate((Date) null);
        this.cboLlenoLote = 1;
    }

    private void crearGridProductos() {
        this.modelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "Cant. Unidad", "R. Invima"}) { // from class: Inventarios.ModificarLote.2
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
            String id = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (id != null && !id.equals("0")) {
                if (this.btnInventario.isSelected()) {
                    modificarInventario(id);
                    this.metodos.mostrarMensaje("Lote Actualizado");
                    return;
                } else {
                    if (this.btnConteo.isSelected()) {
                        modificarInventario(id);
                        modificarConteo(id);
                        this.metodos.mostrarMensaje("Lote Actualizado en Inventario y Conteo");
                        return;
                    }
                    return;
                }
            }
            this.metodos.mostrarMensaje("No se encontró el registro del Lote");
        }
    }

    private void modificarInventario(String id) {
        this.sql = "UPDATE i_suministroxlotexbodega SET Lote = '" + this.txtLote.getText() + "', FechaVencimiento = '" + this.metodos.formatoAMD.format(this.txtVencimiento.getDate()) + "' WHERE (Id='" + id + "' AND Lote='" + this.lote + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void modificarConteo(String id) {
        this.sql = "UPDATE i_suministroxlotexbodegainv SET Lote = '" + this.txtLote.getText() + "', FechaVencimiento = '" + this.metodos.formatoAMD.format(this.txtVencimiento.getDate()) + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id='" + id + "' AND Lote='" + this.lote + "' AND Id_Inventario ='" + this.txtInventario.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void nuevo() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.txtLote.setText("");
        this.txtVencimiento.setDate((Date) null);
        this.cboLote.removeAllItems();
        this.cboLote.setSelectedIndex(-1);
        crearGridProductos();
        this.txtProducto.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.cboBodega.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Bodega");
            this.cboBodega.requestFocus();
        } else if (this.txtProducto.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
        } else if (this.cboLote.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Lote a Modificar");
            this.cboLote.requestFocus();
        } else if (this.txtLote.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el Nuevo Lote del Producto");
            this.txtLote.requestFocus();
        } else if (this.txtVencimiento.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione la Fecha de Vencimiento del Lote");
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

    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.txtBodega = new JTextField();
        this.jPanel2 = new JPanel();
        this.txtCodigo = new JTextField();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.gridProductos = new JTable();
        this.cboBodega = new JComboBox();
        this.jPanel1 = new JPanel();
        this.btnInventario = new JCheckBox();
        this.btnConteo = new JCheckBox();
        this.txtInventario = new JTextField();
        this.panelValor = new JPanel();
        this.txtLote = new JTextField();
        this.cboLote = new JComboBox();
        this.txtVencimiento = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICACIÓN DE LOTES DE SUMINISTROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ModificarLote");
        this.txtBodega.setFont(new Font("Arial", 1, 16));
        this.txtBodega.setForeground(new Color(0, 102, 0));
        this.txtBodega.setHorizontalAlignment(0);
        this.txtBodega.setText("MODIFICACION DE LOTES");
        this.txtBodega.setDisabledTextColor(new Color(0, 102, 0));
        this.txtBodega.setEnabled(false);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL PRODUCTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.ModificarLote.3
            public void actionPerformed(ActionEvent evt) {
                ModificarLote.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.ModificarLote.4
            public void focusGained(FocusEvent evt) {
                ModificarLote.this.txtCodigoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                ModificarLote.this.txtCodigoFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 100, 190, 40);
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProducto.addFocusListener(new FocusAdapter() { // from class: Inventarios.ModificarLote.5
            public void focusGained(FocusEvent evt) {
                ModificarLote.this.txtProductoFocusGained(evt);
            }
        });
        this.txtProducto.addKeyListener(new KeyAdapter() { // from class: Inventarios.ModificarLote.6
            public void keyTyped(KeyEvent evt) {
                ModificarLote.this.txtProductoKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                ModificarLote.this.txtProductoKeyPressed(evt);
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
        this.gridProductos.addKeyListener(new KeyAdapter() { // from class: Inventarios.ModificarLote.7
            public void keyReleased(KeyEvent evt) {
                ModificarLote.this.gridProductosKeyReleased(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridProductos);
        this.jPanel2.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 150, 950, 170);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addItemListener(new ItemListener() { // from class: Inventarios.ModificarLote.8
            public void itemStateChanged(ItemEvent evt) {
                ModificarLote.this.cboBodegaItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboBodega);
        this.cboBodega.setBounds(10, 40, 390, 40);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "MODIFICAR EN", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.buttonGroup1.add(this.btnInventario);
        this.btnInventario.setFont(new Font("Arial", 1, 12));
        this.btnInventario.setForeground(new Color(0, 0, 255));
        this.btnInventario.setSelected(true);
        this.btnInventario.setText("Inventario");
        this.jPanel1.add(this.btnInventario, new AbsoluteConstraints(10, 30, 100, -1));
        this.buttonGroup1.add(this.btnConteo);
        this.btnConteo.setFont(new Font("Arial", 1, 12));
        this.btnConteo.setForeground(new Color(0, 0, 255));
        this.btnConteo.setText("Inventario y Conteo");
        this.btnConteo.addActionListener(new ActionListener() { // from class: Inventarios.ModificarLote.9
            public void actionPerformed(ActionEvent evt) {
                ModificarLote.this.btnConteoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnConteo, new AbsoluteConstraints(110, 30, 170, -1));
        this.jPanel2.add(this.jPanel1);
        this.jPanel1.setBounds(410, 30, 290, 70);
        this.txtInventario.setBackground(new Color(0, 0, 153));
        this.txtInventario.setFont(new Font("Arial", 1, 18));
        this.txtInventario.setForeground(new Color(204, 255, 255));
        this.txtInventario.setHorizontalAlignment(0);
        this.txtInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Inventario", 0, 0, new Font("Tahoma", 0, 14), new Color(255, 255, 255)));
        this.txtInventario.setDisabledTextColor(new Color(255, 255, 255));
        this.txtInventario.setEnabled(false);
        this.jPanel2.add(this.txtInventario);
        this.txtInventario.setBounds(720, 30, 230, 70);
        this.panelValor.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN LOTE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.panelValor.setLayout((LayoutManager) null);
        this.txtLote.setFont(new Font("Arial", 1, 12));
        this.txtLote.setHorizontalAlignment(0);
        this.txtLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Nuevo Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtLote.setDisabledTextColor(new Color(0, 0, 102));
        this.txtLote.addActionListener(new ActionListener() { // from class: Inventarios.ModificarLote.10
            public void actionPerformed(ActionEvent evt) {
                ModificarLote.this.txtLoteActionPerformed(evt);
            }
        });
        this.txtLote.addFocusListener(new FocusAdapter() { // from class: Inventarios.ModificarLote.11
            public void focusGained(FocusEvent evt) {
                ModificarLote.this.txtLoteFocusGained(evt);
            }
        });
        this.panelValor.add(this.txtLote);
        this.txtLote.setBounds(400, 29, 320, 36);
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote Actuial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboLote.addItemListener(new ItemListener() { // from class: Inventarios.ModificarLote.12
            public void itemStateChanged(ItemEvent evt) {
                ModificarLote.this.cboLoteItemStateChanged(evt);
            }
        });
        this.panelValor.add(this.cboLote);
        this.cboLote.setBounds(20, 30, 340, 40);
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Vencimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtVencimiento.setToolTipText("Formato dd/mm/aaaa");
        this.txtVencimiento.setDateFormatString("dd/MM/yyyy");
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        this.panelValor.add(this.txtVencimiento);
        this.txtVencimiento.setBounds(780, 20, 150, 50);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtBodega, -1, 983, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.panelValor, -1, -1, 32767)).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -2, 970, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.txtBodega, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 330, -2).addGap(18, 18, 18).addComponent(this.panelValor, -2, 93, -2).addContainerGap(36, 32767)));
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
    public void txtLoteActionPerformed(ActionEvent evt) {
        this.gridProductos.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyTyped(KeyEvent evt) {
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
    public void btnConteoActionPerformed(ActionEvent evt) {
        buscarNoInventario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteItemStateChanged(ItemEvent evt) {
        if (this.cboLlenoLote == 1 && this.cboLote.getSelectedIndex() > -1) {
            this.lote = this.listaLote[this.cboLote.getSelectedIndex()][1];
            this.txtLote.setText("");
            this.txtVencimiento.setDate((Date) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoFocusGained(FocusEvent evt) {
        this.txtProducto.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoteFocusGained(FocusEvent evt) {
        this.txtLote.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarProductoPorNombre();
        }
    }
}
