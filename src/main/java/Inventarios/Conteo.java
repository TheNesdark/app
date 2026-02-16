package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Conteo.class */
public class Conteo extends JInternalFrame {
    private ResultSet rs;
    private Object[] dato;
    private int conteo;
    private String sql;
    private String IdSuministro;
    private String IdSuministroBodega;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private String[][] listaLote;
    private String[][] listaBodega;
    private JComboBox cboBodega;
    private JComboBox cboLote;
    public JTable grid;
    public JTable grid1;
    private JLabel jLabel1;
    private JLabel jLabel15;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel lblValorUnidad;
    private JPanel panelValor;
    public JTextField txtBodega;
    private JFormattedTextField txtCantUnidad1;
    private JFormattedTextField txtCantidad;
    private JTextField txtCodigo;
    private JTextField txtFecha;
    private JTextField txtInventario;
    private JTextField txtInvima;
    private JTextField txtProducto;
    private JTextField txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private int filaGrid1 = 0;
    private int cboLleno = 0;

    public Conteo(int Conteo) {
        this.conteo = 0;
        initComponents();
        this.txtBodega.setText("BODEGA A TRABAJAR ?? ");
        this.conteo = Conteo;
        if (this.conteo == 1) {
            setTitle("PRIMER CONTEO DE INVENTARIO");
        } else {
            setTitle("SEGUNDO CONTEO DE INVENTARIO");
        }
        cargarComboBodega();
        crearGrid();
        crearGridProductos();
        this.txtCantidad.setValue(0);
        this.grid1.addMouseListener(new MouseAdapter() { // from class: Inventarios.Conteo.1
            public void mouseClicked(MouseEvent e) {
                Conteo.this.filaGrid1 = Conteo.this.grid1.rowAtPoint(e.getPoint());
                Conteo.this.txtCodigo.setText(Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 1).toString());
                Conteo.this.txtProducto.setText(Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 2).toString());
                Conteo.this.txtCantidad.setValue(Integer.valueOf(Integer.parseInt(Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 3).toString())));
                Conteo.this.txtInvima.setText(Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 4).toString());
                Conteo.this.IdSuministro = Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 0).toString();
                Conteo.this.IdSuministroBodega = Conteo.this.modelo1.getValueAt(Conteo.this.filaGrid1, 5).toString();
                Conteo.this.cargarComboLote(Conteo.this.IdSuministroBodega);
            }
        });
    }

    private void activarObjetos() {
        this.cboBodega.setEnabled(false);
        this.txtCodigo.setEnabled(true);
        this.txtProducto.setEnabled(true);
        this.cboLote.setEnabled(true);
        this.txtCantidad.setEnabled(true);
        this.txtBodega.setText("BODEGA : " + this.cboBodega.getSelectedItem().toString());
        this.txtInventario.setText(this.listaBodega[this.cboBodega.getSelectedIndex()][1]);
        this.txtFecha.setText(this.listaBodega[this.cboBodega.getSelectedIndex()][2]);
    }

    private void actualizarGrid() {
        this.filaGrid = this.modelo.getRowCount();
        this.modelo.addRow(this.dato);
        this.modelo.setValueAt(this.IdSuministro, this.filaGrid, 0);
        this.modelo.setValueAt(this.txtCodigo.getText(), this.filaGrid, 1);
        this.modelo.setValueAt(this.txtProducto.getText(), this.filaGrid, 2);
        this.modelo.setValueAt(this.cboLote.getSelectedItem().toString(), this.filaGrid, 3);
        this.modelo.setValueAt(this.txtVencimiento.getText(), this.filaGrid, 4);
        this.modelo.setValueAt(this.txtCantidad.getValue(), this.filaGrid, 5);
        this.modelo.setValueAt(this.txtCantidad.getValue(), this.filaGrid, 6);
        this.modelo.setValueAt(this.txtInvima.getText(), this.filaGrid, 7);
    }

    private void actualizarSuministroxLotexBodegaInv(String id) {
        if (this.conteo == 1) {
            this.sql = "UPDATE i_suministroxlotexbodegainv SET  Conteo1 = Conteo1 + '" + this.txtCantidad.getText() + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + id + "' AND Lote ='" + this.listaLote[this.cboLote.getSelectedIndex()][2] + "' AND Id_Inventario ='" + this.txtInventario.getText() + "')";
        } else {
            this.sql = "UPDATE i_suministroxlotexbodegainv SET  Conteo2 = Conteo2+'" + this.txtCantidad.getText() + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + id + "' AND Lote ='" + this.listaLote[this.cboLote.getSelectedIndex()][2] + "' AND Id_Inventario ='" + this.txtInventario.getText() + "')";
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void buscarProductoPorCodigoBarra() {
        crearGridProductos();
        this.sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministro.CantidadUnidad, i_suministro.RegistroInvima, i_suministroxbodega.Id idBodegaSuministro FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) WHERE (i_suministro.CodBarraUnidad ='" + this.txtCodigo.getText() + "' AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs1.next()) {
                    this.IdSuministro = rs1.getString(1);
                    this.txtProducto.setText(rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getString(4));
                    this.txtCantUnidad1.setValue(Integer.valueOf(rs1.getInt(5)));
                    this.txtInvima.setText(rs1.getString(6));
                    this.IdSuministroBodega = rs1.getString("idBodegaSuministro");
                    cargarComboLote(rs1.getString("idBodegaSuministro"));
                } else {
                    nuevo();
                }
                if (rs1 != null) {
                    if (0 != 0) {
                        try {
                            rs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs1.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    private void buscarProductoPorNombre() {
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministro.CantidadUnidad, i_suministro.RegistroInvima FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) WHERE (i_suministro.Nbre LIKE'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "')";
        try {
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs1.next()) {
                    rs1.next();
                    if (rs1.getRow() > 0) {
                        crearGridProductos();
                        rs1.beforeFirst();
                        while (rs1.next()) {
                            this.modelo1.addRow(this.dato);
                            this.modelo1.setValueAt(rs1.getString(1), this.filaGrid1, 0);
                            this.modelo1.setValueAt(rs1.getString(2), this.filaGrid1, 1);
                            this.modelo1.setValueAt(rs1.getString(3) + " " + rs1.getString(4) + " " + rs1.getString(5), this.filaGrid1, 2);
                            this.modelo1.setValueAt(Integer.valueOf(rs1.getInt(6)), this.filaGrid1, 3);
                            this.modelo1.setValueAt(rs1.getString(7), this.filaGrid1, 4);
                            this.filaGrid1++;
                        }
                    } else {
                        nuevo();
                    }
                }
                if (rs1 != null) {
                    if (0 != 0) {
                        try {
                            rs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs1.close();
                    }
                }
            } catch (Throwable th3) {
                if (rs1 != null) {
                    if (0 != 0) {
                        try {
                            rs1.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        rs1.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarComboBodega() {
        this.sql = "SELECT i_inventario.Id_Bodega, i_bodegas.Nbre, i_inventario.Id, i_inventario.Fecha_Inventario FROM i_bodegas INNER JOIN i_inventario ON (i_bodegas.Id = i_inventario.Id_Bodega) WHERE (i_inventario.Fecha_Cierre ='0000-00-00 00:00:00') ORDER BY i_bodegas.Nbre ASC, i_inventario.Fecha_Inventario ASC";
        this.listaBodega = this.consultas.llenarComboyLista(this.sql, this.listaBodega, this.cboBodega, 4);
        this.consultas.cerrarConexionBd();
        this.cboBodega.setSelectedIndex(-1);
        this.cboLleno = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarComboLote(String idSuministroBodega) {
        this.cboLote.removeAllItems();
        this.sql = "SELECT i_suministroxlotexbodegainv.Id, i_suministroxlotexbodegainv.Lote, \ni_suministroxlotexbodegainv.FechaVencimiento , i_suministroxlotexbodegainv.Cantidad \nFROM  i_suministroxlotexbodegainv \nWHERE ( i_suministroxlotexbodegainv.Id_inventario ='" + this.txtInventario.getText() + "' \nAND i_suministroxlotexbodegainv.Id  ='" + idSuministroBodega + "') \norder by i_suministroxlotexbodegainv.Cantidad  desc";
        System.out.println("" + this.sql);
        try {
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    if (rs1.next()) {
                        rs1.last();
                        int i = 0;
                        int noFilas = rs1.getRow();
                        if (noFilas > 0) {
                            rs1.beforeFirst();
                            this.listaLote = new String[noFilas + 1][3];
                            while (rs1.next()) {
                                this.listaLote[i][0] = rs1.getString(1);
                                this.listaLote[i][1] = rs1.getString(3);
                                this.listaLote[i][2] = rs1.getString(2);
                                this.cboLote.addItem(rs1.getString(2) + " - Vence " + rs1.getString(3).substring(0, 10));
                                i++;
                            }
                        }
                        this.cboLote.setSelectedIndex(-1);
                        this.txtVencimiento.setText("");
                    }
                    if (rs1 != null) {
                        if (0 != 0) {
                            try {
                                rs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs1.close();
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.cboLleno = 1;
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "Lote", "Vencimiento", "Cantidad", "Cant. Unidad", "R. Invima"}) { // from class: Inventarios.Conteo.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.filaGrid = 0;
    }

    private void crearGridProductos() {
        this.modelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "Cant. Unidad", "R. Invima", "idSuministroBodega"}) { // from class: Inventarios.Conteo.3
            Class[] types = {String.class, String.class, String.class, Integer.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid1.setModel(this.modelo1);
        this.grid1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid1.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.grid1.getColumnModel().getColumn(2).setPreferredWidth(600);
        this.grid1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid1.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid1.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid1.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid1.getColumnModel().getColumn(5).setMaxWidth(0);
        this.filaGrid1 = 0;
    }

    public void grabar() {
        if (this.txtProducto.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
            return;
        }
        if (Integer.parseInt(this.txtCantidad.getValue().toString()) < 1) {
            this.metodos.mostrarMensaje("Por favor digite la Cantidad del Producto que Ingresa");
            this.txtCantidad.requestFocus();
        } else {
            if (this.cboLote.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Por favor seleccione el Lote de Fabricación con su fecha de Vencimiento");
                this.cboLote.requestFocus();
                return;
            }
            actualizarGrid();
            actualizarSuministroxLotexBodegaInv(this.listaLote[this.cboLote.getSelectedIndex()][0]);
            nuevo();
            this.filaGrid++;
            this.txtCodigo.requestFocus();
        }
    }

    public void nuevo() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.cboLote.removeAllItems();
        this.txtCantidad.setValue(1);
        this.txtCantidad.setValue(1);
        this.txtInvima.setText("");
        this.txtVencimiento.setText("");
    }

    /* JADX WARN: Type inference failed for: r3v58, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtBodega = new JTextField();
        this.jPanel2 = new JPanel();
        this.jLabel5 = new JLabel();
        this.jLabel7 = new JLabel();
        this.txtCodigo = new JTextField();
        this.panelValor = new JPanel();
        this.lblValorUnidad = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.txtInvima = new JTextField();
        this.cboLote = new JComboBox();
        this.txtCantidad = new JFormattedTextField();
        this.jLabel4 = new JLabel();
        this.txtVencimiento = new JTextField();
        this.txtCantUnidad1 = new JFormattedTextField();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.grid1 = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.cboBodega = new JComboBox();
        this.txtInventario = new JTextField();
        this.txtFecha = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONTEO DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Conteo");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtBodega.setBackground(new Color(0, 0, 153));
        this.txtBodega.setFont(new Font("Tahoma", 1, 18));
        this.txtBodega.setForeground(new Color(204, 255, 255));
        this.txtBodega.setHorizontalAlignment(0);
        this.txtBodega.setDisabledTextColor(new Color(204, 255, 255));
        this.txtBodega.setEnabled(false);
        getContentPane().add(this.txtBodega, new AbsoluteConstraints(0, 0, 1000, 40));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL PRODUCTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 255));
        this.jLabel5.setText("Código de Barra");
        this.jPanel2.add(this.jLabel5);
        this.jLabel5.setBounds(10, 30, 180, 15);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 255));
        this.jLabel7.setText("Producto");
        this.jPanel2.add(this.jLabel7);
        this.jLabel7.setBounds(220, 30, 200, 15);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setEnabled(false);
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.4
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.Conteo.5
            public void focusLost(FocusEvent evt) {
                Conteo.this.txtCodigoFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 50, 190, 30);
        this.panelValor.setBorder(BorderFactory.createEtchedBorder());
        this.panelValor.setLayout((LayoutManager) null);
        this.lblValorUnidad.setFont(new Font("Arial", 1, 12));
        this.lblValorUnidad.setForeground(new Color(0, 0, 255));
        this.lblValorUnidad.setText("Cant por Unidad");
        this.panelValor.add(this.lblValorUnidad);
        this.lblValorUnidad.setBounds(470, 10, 100, 15);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 255));
        this.jLabel15.setText("Lote");
        this.panelValor.add(this.jLabel15);
        this.jLabel15.setBounds(10, 10, 100, 15);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("Cantidad");
        this.panelValor.add(this.jLabel1);
        this.jLabel1.setBounds(320, 10, 60, 15);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("Registro Invima");
        this.panelValor.add(this.jLabel3);
        this.jLabel3.setBounds(570, 10, 180, 15);
        this.txtInvima.setFont(new Font("Arial", 1, 12));
        this.txtInvima.setHorizontalAlignment(0);
        this.txtInvima.setDisabledTextColor(new Color(0, 0, 102));
        this.txtInvima.setEnabled(false);
        this.txtInvima.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.6
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.txtInvimaActionPerformed(evt);
            }
        });
        this.panelValor.add(this.txtInvima);
        this.txtInvima.setBounds(570, 30, 230, 30);
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setEnabled(false);
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.7
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.cboLoteActionPerformed(evt);
            }
        });
        this.panelValor.add(this.cboLote);
        this.cboLote.setBounds(10, 30, 300, 30);
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setDisabledTextColor(new Color(0, 0, 102));
        this.txtCantidad.setEnabled(false);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.8
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.txtCantidadActionPerformed(evt);
            }
        });
        this.panelValor.add(this.txtCantidad);
        this.txtCantidad.setBounds(320, 30, 130, 30);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 255));
        this.jLabel4.setText("Fecha de Vencimiento");
        this.panelValor.add(this.jLabel4);
        this.jLabel4.setBounds(810, 10, 170, 15);
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        this.txtVencimiento.setHorizontalAlignment(0);
        this.txtVencimiento.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVencimiento.setEnabled(false);
        this.txtVencimiento.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.9
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.txtVencimientoActionPerformed(evt);
            }
        });
        this.panelValor.add(this.txtVencimiento);
        this.txtVencimiento.setBounds(810, 30, 130, 30);
        this.txtCantUnidad1.setHorizontalAlignment(0);
        this.txtCantUnidad1.setDisabledTextColor(new Color(0, 0, 102));
        this.txtCantUnidad1.setEnabled(false);
        this.txtCantUnidad1.setFont(new Font("Arial", 1, 12));
        this.panelValor.add(this.txtCantUnidad1);
        this.txtCantUnidad1.setBounds(470, 30, 80, 30);
        this.jPanel2.add(this.panelValor);
        this.panelValor.setBounds(10, 90, 950, 80);
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setEnabled(false);
        this.txtProducto.addKeyListener(new KeyAdapter() { // from class: Inventarios.Conteo.10
            public void keyTyped(KeyEvent evt) {
                Conteo.this.txtProductoKeyTyped(evt);
            }
        });
        this.jPanel2.add(this.txtProducto);
        this.txtProducto.setBounds(210, 50, 750, 30);
        this.grid1.setBorder(BorderFactory.createBevelBorder(0));
        this.grid1.setFont(new Font("Arial", 1, 12));
        this.grid1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid1.setEditingColumn(1);
        this.grid1.setEditingRow(1);
        this.grid1.setRowHeight(25);
        this.grid1.setSelectionBackground(new Color(255, 255, 255));
        this.grid1.setSelectionForeground(new Color(255, 0, 0));
        this.grid1.setSelectionMode(0);
        this.grid1.addKeyListener(new KeyAdapter() { // from class: Inventarios.Conteo.11
            public void keyReleased(KeyEvent evt) {
                Conteo.this.grid1KeyReleased(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid1);
        this.jPanel2.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 180, 950, 130);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(10, 120, 970, 330));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.Conteo.12
            public void keyReleased(KeyEvent evt) {
                Conteo.this.gridKeyReleased(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 460, 970, 210));
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addActionListener(new ActionListener() { // from class: Inventarios.Conteo.13
            public void actionPerformed(ActionEvent evt) {
                Conteo.this.cboBodegaActionPerformed(evt);
            }
        });
        getContentPane().add(this.cboBodega, new AbsoluteConstraints(10, 60, 430, 40));
        this.txtInventario.setBackground(new Color(0, 0, 153));
        this.txtInventario.setFont(new Font("Tahoma", 1, 20));
        this.txtInventario.setForeground(new Color(204, 255, 255));
        this.txtInventario.setHorizontalAlignment(0);
        this.txtInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Inventario", 0, 0, (Font) null, new Color(255, 255, 255)));
        this.txtInventario.setDisabledTextColor(new Color(255, 255, 255));
        this.txtInventario.setEnabled(false);
        getContentPane().add(this.txtInventario, new AbsoluteConstraints(750, 50, 230, 60));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setForeground(new Color(0, 0, 102));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDisabledTextColor(new Color(0, 0, 102));
        this.txtFecha.setEnabled(false);
        getContentPane().add(this.txtFecha, new AbsoluteConstraints(460, 60, 140, 40));
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
    public void txtInvimaActionPerformed(ActionEvent evt) {
        this.grid1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboLote.getSelectedIndex() > -1) {
            this.txtVencimiento.setText(this.listaLote[this.cboLote.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVencimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyTyped(KeyEvent evt) {
        buscarProductoPorNombre();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid1KeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboBodega.getSelectedIndex() > -1) {
            activarObjetos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadActionPerformed(ActionEvent evt) {
    }
}
