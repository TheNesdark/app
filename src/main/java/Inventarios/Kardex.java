package Inventarios;

import Acceso.Menus;
import Acceso.Principal;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Kardex.class */
public final class Kardex extends JInternalFrame {
    private Object[] dato;
    private int cboLleno;
    private String sql;
    private String idProducto;
    private String[][] listaProducto;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloS;
    private claseInventario claseInv;
    private JButton JBTCarguesA1;
    private JTextField JTFRuta;
    private JButton btnBuscar;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox cboProducto;
    private JTable grid;
    private JTable gridS;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JLabel txtTitulo;
    private JFormattedTextField txtTotalEntrada;
    private JFormattedTextField txtTotalSalida;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;

    public Kardex(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        this.txtFechaIni.setDate(this.metodos.getFechaActual());
        this.txtFechaFin.setDate(this.metodos.getFechaActual());
        cargarCombos();
        crearGrid();
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
    }

    private String getIdProducto() {
        return this.idProducto;
    }

    private void setIdProducto(String id) {
        this.idProducto = id;
    }

    public void cargarCombos() {
        this.listaProducto = this.consultas.llenarComboyLista("SELECT i_suministro.Id, concat(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',' - ',i_laboratorio.Nbre) as nombre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  inner join i_concentracion on (i_suministro.IdConcentracion=i_concentracion.Id) WHERE (i_suministro.EstaActivo =1) ORDER BY i_suministro.Nbre ASC", this.listaProducto, this.cboProducto, 4);
        JTextComponent editor = this.cboProducto.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboProducto));
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarGrid() {
        crearGrid();
        this.txtTotalEntrada.setValue(0);
        this.txtTotalSalida.setValue(0);
        cargarEntradas();
        cargarDespachos();
        cargarTraslados();
        cargarSalidas();
        this.consultas.cerrarConexionBd();
    }

    private void cargarEntradas() {
        this.filaGrid = 0;
        this.sql = "SELECT i_entradas.FechaEntrada, i_entradas.Id, i_entradas.NoFactura, cc_terceros.RazonSocialCompleta, i_detalleentrada.Lote, i_detalleentrada.FechaVencimiento, i_detalleentrada.Cantidad, i_detalleentrada.ValorUnitario FROM i_detalleentrada INNER JOIN i_entradas ON (i_detalleentrada.IdEntrada = i_entradas.Id) INNER JOIN cc_terceros ON (i_entradas.IdProveedor = cc_terceros.Id) WHERE (i_entradas.IdBodega ='" + this.claseInv.getIdBodega() + "' and i_entradas.Estado=0 AND i_detalleentrada.IdSuministro ='" + getIdProducto() + "' AND i_entradas.FechaEntrada >='" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND i_entradas.FechaEntrada <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "') ORDER BY i_entradas.FechaEntrada ASC, i_entradas.Id ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString(4), this.filaGrid, 3);
                this.modelo.setValueAt(rs.getString(5), this.filaGrid, 4);
                this.modelo.setValueAt(rs.getString(6), this.filaGrid, 5);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(8)), this.filaGrid, 7);
                this.txtTotalEntrada.setValue(Integer.valueOf(Integer.parseInt(this.txtTotalEntrada.getValue().toString()) + rs.getInt(7)));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarDespachos() {
        this.filaGrid = 0;
        this.sql = "SELECT i_salidas.FechaSalida, i_salidas.Id, w_persona.NUsuario, i_detallesalida.Lote, i_detallesalida.FechaVencimiento, i_detallesalida.CantidadDespachada, i_detallesalida.ValorUnitario FROM i_detallesalida INNER JOIN i_salidas ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN w_persona ON (i_salidas.IdDestino = w_persona.Id_persona) WHERE (i_salidas.Destino = '0'AND i_salidas.FechaSalida >= '" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND i_salidas.FechaSalida <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND i_salidas.IdBodega ='" + this.claseInv.getIdBodega() + "' AND i_detallesalida.IdSuministro ='" + getIdProducto() + "' AND i_detallesalida.Lote <> 'faltante') ORDER BY i_salidas.FechaSalida ASC, i_salidas.Id ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modeloS.addRow(this.dato);
                this.modeloS.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modeloS.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modeloS.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modeloS.setValueAt(rs.getString(4), this.filaGrid, 3);
                this.modeloS.setValueAt(rs.getString(5), this.filaGrid, 4);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(6)), this.filaGrid, 5);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 6);
                this.txtTotalSalida.setValue(Integer.valueOf(Integer.parseInt(this.txtTotalSalida.getValue().toString()) + rs.getInt(6)));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarSalidas() {
        this.sql = "SELECT i_salidas.FechaSalida, i_salidas.Id, cc_terceros.RazonSocialCompleta, i_detallesalida.Lote, i_detallesalida.FechaVencimiento, i_detallesalida.CantidadDespachada, i_detallesalida.ValorUnitario FROM i_detallesalida INNER JOIN i_salidas ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_proveedores ON (i_salidas.IdDestino = i_proveedores.Id_Empresa) INNER JOIN cc_terceros ON (i_proveedores.Id_Empresa = cc_terceros.Id) WHERE (i_salidas.FechaSalida >='" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND i_salidas.FechaSalida <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "' and i_salidas.Estado=0 AND i_salidas.IdBodega ='" + this.claseInv.getIdBodega() + "' AND i_detallesalida.IdSuministro ='" + getIdProducto() + "') ORDER BY i_salidas.FechaSalida ASC, i_salidas.Id ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modeloS.addRow(this.dato);
                this.modeloS.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modeloS.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modeloS.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modeloS.setValueAt(rs.getString(4), this.filaGrid, 3);
                this.modeloS.setValueAt(rs.getString(5), this.filaGrid, 4);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(6)), this.filaGrid, 5);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 6);
                this.txtTotalSalida.setValue(Integer.valueOf(Integer.parseInt(this.txtTotalSalida.getValue().toString()) + rs.getInt(6)));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarTraslados() {
        this.sql = "SELECT i_salidas.FechaSalida, i_salidas.Id, i_bodegas.Nbre, i_detallesalida.Lote, i_detallesalida.FechaVencimiento, i_detallesalida.CantidadDespachada, i_detallesalida.ValorUnitario FROM i_detallesalida INNER JOIN i_salidas ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_bodegas ON (i_salidas.IdDestino = i_bodegas.Id) WHERE (i_salidas.FechaSalida >='" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND i_salidas.FechaSalida <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND i_salidas.IdBodega ='" + this.claseInv.getIdBodega() + "' AND i_detallesalida.IdSuministro ='" + getIdProducto() + "') ORDER BY i_salidas.FechaSalida ASC, i_salidas.Id ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modeloS.addRow(this.dato);
                this.modeloS.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modeloS.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modeloS.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modeloS.setValueAt(rs.getString(4), this.filaGrid, 3);
                this.modeloS.setValueAt(rs.getString(5), this.filaGrid, 4);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(6)), this.filaGrid, 5);
                this.modeloS.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 6);
                this.txtTotalSalida.setValue(Integer.valueOf(Integer.parseInt(this.txtTotalSalida.getValue().toString()) + rs.getInt(6)));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Número", "Factura", "Proveedor", "Lote", "Vencimiento", "cant.", "Valor"}) { // from class: Inventarios.Kardex.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class};

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
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.modeloS = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Salida", "Destino", "Lote", "Vencimiento", "cant.", "Valor"}) { // from class: Inventarios.Kardex.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridS.setModel(this.modeloS);
        this.gridS.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.gridS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.gridS.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.gridS.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridS.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridS.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.gridS.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridS.getColumnModel().getColumn(0).setMinWidth(80);
        this.gridS.getColumnModel().getColumn(0).setMaxWidth(80);
        this.gridS.getColumnModel().getColumn(1).setMinWidth(100);
        this.gridS.getColumnModel().getColumn(1).setMaxWidth(100);
        this.gridS.getColumnModel().getColumn(2).setMinWidth(250);
        this.gridS.getColumnModel().getColumn(2).setMaxWidth(250);
        this.gridS.getColumnModel().getColumn(3).setMinWidth(150);
        this.gridS.getColumnModel().getColumn(3).setMaxWidth(150);
        this.gridS.getColumnModel().getColumn(4).setMinWidth(100);
        this.gridS.getColumnModel().getColumn(4).setMaxWidth(100);
        this.gridS.getColumnModel().getColumn(5).setMinWidth(100);
        this.gridS.getColumnModel().getColumn(5).setMaxWidth(100);
        this.gridS.getColumnModel().getColumn(6).setMinWidth(150);
        this.gridS.getColumnModel().getColumn(6).setMaxWidth(150);
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtTitulo = new JLabel();
        this.jPanel2 = new JPanel();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.cboProducto = new JComboBox();
        this.btnBuscar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.gridS = new JTable();
        this.txtTotalSalida = new JFormattedTextField();
        this.txtTotalEntrada = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("KARDEX DE MOVIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1017, 642));
        setMinimumSize(new Dimension(1017, 642));
        setName("Kardex");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.Kardex.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                Kardex.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "ENTRADAS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.txtTitulo.setFont(new Font("Arial", 1, 14));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("MOVIMIENTO DE PRODUCTOS");
        this.txtTitulo.setOpaque(true);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE BUSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setForeground(new Color(0, 0, 153));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaIni.setForeground(new Color(0, 0, 153));
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.Kardex.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Kardex.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.Kardex.5
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Kardex.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(580, 30, 120, 60);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.Kardex.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Kardex.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.Kardex.7
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Kardex.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(700, 30, 110, 60);
        this.cboProducto.setEditable(true);
        this.cboProducto.setFont(new Font("Arial", 1, 12));
        this.cboProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProducto.addItemListener(new ItemListener() { // from class: Inventarios.Kardex.8
            public void itemStateChanged(ItemEvent evt) {
                Kardex.this.cboProductoItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboProducto);
        this.cboProducto.setBounds(10, 30, 570, 60);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Inventarios.Kardex.9
            public void actionPerformed(ActionEvent evt) {
                Kardex.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnBuscar);
        this.btnBuscar.setBounds(810, 40, 130, 50);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "SALIDAS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.gridS.setFont(new Font("Arial", 1, 12));
        this.gridS.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.gridS.setRowHeight(25);
        this.gridS.setSelectionBackground(new Color(255, 255, 255));
        this.gridS.setSelectionForeground(new Color(255, 0, 0));
        this.gridS.setSelectionMode(0);
        this.jScrollPane2.setViewportView(this.gridS);
        this.txtTotalSalida.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Salida", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalSalida.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtTotalSalida.setHorizontalAlignment(4);
        this.txtTotalSalida.setDisabledTextColor(new Color(0, 0, 0));
        this.txtTotalSalida.setEnabled(false);
        this.txtTotalSalida.setFont(new Font("Arial", 1, 12));
        this.txtTotalEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Entrada", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalEntrada.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtTotalEntrada.setHorizontalAlignment(4);
        this.txtTotalEntrada.setDisabledTextColor(new Color(0, 0, 0));
        this.txtTotalEntrada.setEnabled(false);
        this.txtTotalEntrada.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.Kardex.10
            public void mouseClicked(MouseEvent evt) {
                Kardex.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Inventarios.Kardex.11
            public void actionPerformed(ActionEvent evt) {
                Kardex.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(layout.createSequentialGroup().addComponent(this.JBTCarguesA1, -2, 171, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtTotalEntrada, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtTotalSalida, -2, 224, -2)).addGroup(layout.createSequentialGroup().addComponent(this.txtTitulo, -2, 987, -2).addGap(0, 0, 32767)).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.txtTitulo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 101, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 178, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTotalEntrada, -2, 50, -2).addComponent(this.txtTotalSalida, -2, 50, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JBTCarguesA1, GroupLayout.Alignment.TRAILING, -2, 50, -2))).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal principal = this.claseInv.frmPrincipal;
        Menus menus = this.claseInv.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProductoItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboProducto.getSelectedIndex() > -1) {
            setIdProducto(this.listaProducto[this.cboProducto.getSelectedIndex()][0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.gridS.getRowCount() != -1) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.gridS, this.JTFRuta.getText(), getTitle() + " - SALIDAS");
        }
    }
}
