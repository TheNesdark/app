package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/InformesAuditoria.class */
public class InformesAuditoria extends JInternalFrame {
    private ResultSet rs;
    private String sql;
    private int cboLleno;
    private int IdAuditoria;
    private Object[] dato;
    private String[] listaBodega;
    private DefaultTableModel modelo;
    private JButton btnAceptar;
    private JRadioButton btnConsultarFecha;
    private JRadioButton btnConsultarNumero;
    private JRadioButton btnGenerar;
    private JButton btnGrabar;
    private JButton btnImprimir;
    private JButton btnModificar;
    private ButtonGroup buttonGroup1;
    private JComboBox cboBodega;
    private JTable grid;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JLabel lblNumero;
    private JLabel lblTitulo;
    private JTextArea txtAccion;
    private JFormattedTextField txtCantDiferencia;
    private JFormattedTextField txtCantFisica;
    private JFormattedTextField txtCantInventario;
    private JSpinner txtCantidad;
    private JFormattedTextField txtCostoDiferencia;
    private JTextArea txtExplicacion;
    public JDateChooser txtFecha;
    private JSpinner txtNumero;
    private JTextField txtProducto;
    private JTextField txtResponsable;
    private JSpinner txtValorMaximo;
    private JSpinner txtValorMinimo;
    private JFormattedTextField txtValorUnidad;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private int opcion = 1;
    GregorianCalendar fechaAnterior = new GregorianCalendar();

    public InformesAuditoria(String xTitulo) {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 10, Toolkit.getDefaultToolkit().getScreenSize().height - 200);
        this.title = "Módulo de Informes de Auditoria : Usuario : " + Principal.usuarioSistemaDTO.getNombreUsuario();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.listaBodega = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas ORDER BY Nbre", this.listaBodega, this.cboBodega);
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
        this.fechaAnterior.add(2, -1);
        crearGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.InformesAuditoria.1
            public void mouseClicked(MouseEvent e) {
                InformesAuditoria.this.filaGrid = InformesAuditoria.this.grid.rowAtPoint(e.getPoint());
                InformesAuditoria.this.cargarDatos();
            }
        });
    }

    public void activarCampos() {
        switch (this.opcion) {
            case 1:
                this.txtValorMinimo.setEnabled(true);
                this.txtValorMaximo.setEnabled(true);
                this.txtCantidad.setEnabled(true);
                this.txtFecha.setEnabled(false);
                this.txtNumero.setEnabled(false);
                this.txtValorMinimo.requestFocus();
                break;
            case 2:
                this.txtValorMinimo.setEnabled(false);
                this.txtValorMaximo.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtFecha.setEnabled(true);
                this.txtNumero.setEnabled(false);
                this.txtFecha.requestFocus();
                break;
            case 3:
                this.txtValorMinimo.setEnabled(false);
                this.txtValorMaximo.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtFecha.setEnabled(false);
                this.txtNumero.setEnabled(true);
                this.txtNumero.requestFocus();
                break;
        }
    }

    public void cargarDatos() {
        this.txtProducto.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.txtCantInventario.setText(this.modelo.getValueAt(this.filaGrid, 3).toString());
        this.txtCantFisica.setText(this.modelo.getValueAt(this.filaGrid, 4).toString());
        this.txtCantDiferencia.setText(this.modelo.getValueAt(this.filaGrid, 5).toString());
        this.txtValorUnidad.setValue(this.modelo.getValueAt(this.filaGrid, 6));
        this.txtCostoDiferencia.setValue(this.modelo.getValueAt(this.filaGrid, 7));
        if (this.modelo.getValueAt(this.filaGrid, 8).toString().length() > 0) {
            this.txtExplicacion.setText(this.modelo.getValueAt(this.filaGrid, 8).toString());
        } else {
            this.txtExplicacion.setText("");
        }
        if (this.modelo.getValueAt(this.filaGrid, 9).toString().length() > 0) {
            this.txtAccion.setText(this.modelo.getValueAt(this.filaGrid, 9).toString());
        } else {
            this.txtAccion.setText("");
        }
        if (this.modelo.getValueAt(this.filaGrid, 10).toString().length() > 0) {
            this.txtResponsable.setText(this.modelo.getValueAt(this.filaGrid, 10).toString());
        } else {
            this.txtResponsable.setText("");
        }
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Producto", "Rotación", "Cant. Inventario", "Cant. Física", "Cant. Diferencia", "Vr. Unidad", "Costo Diferencia", "Explicación Diferencia", "Acción", "Responsable"}) { // from class: Inventarios.InformesAuditoria.2
            Class[] types = {String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Double.class, Double.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public void evaluarAccion() {
        limpiarGrid();
        this.filaGrid = 0;
        try {
            switch (this.opcion) {
                case 1:
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, SUM(i_detallesalida.CantidadDespachada), SUM(i_suministroxbodega.Existencia), AVG(i_suministroxbodega.Costo), i_laboratorio.Nbre, i_tipoproducto.Nbre FROM i_detallesalida INNER JOIN i_salidas ON i_detallesalida.IdSalida = i_salidas.Id INNER JOIN i_suministro ON i_detallesalida.IdProducto = i_suministro.Id INNER JOIN i_suministroxbodega ON i_suministro.Id = i_suministroxbodega.IdProducto INNER JOIN i_presentacioncomercial ON i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id INNER JOIN i_laboratorio ON i_suministro.IdLaboratorio = i_laboratorio.Id INNER JOIN i_tipoproducto ON i_suministro.IdTipoProducto = i_tipoproducto.Id WHERE (i_salidas.IdBodega = '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "') AND (i_salidas.FechaSalida > '" + this.metodos.formatoAMD.format(this.fechaAnterior.getTime()) + "') AND (i_salidas.FechaSalida < '" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "') AND (i_suministroxbodega.Existencia > 0) AND (i_suministroxbodega.Costo > '" + this.txtValorMinimo.getValue() + "') AND (i_suministroxbodega.Costo < '" + this.txtValorMaximo.getValue() + "') GROUP BY i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_tipoproducto.Nbre, i_suministro.CodBarraUnidad ORDER BY SUM(i_detallesalida.CantidadDespachada) DESC";
                    this.rs = this.consultas.traerRs(this.sql);
                    this.rs.last();
                    this.consultas.cerrarConexionBd();
                    int registros = this.rs.getRow();
                    if (registros < Integer.parseInt(this.txtCantidad.getValue().toString())) {
                        this.metodos.mostrarMensaje("La Cantidad de registros consultados es menor a la Cantidad solicitada.\n Se utilizarán solo la Cantidad existente según los valores Mínimo y Máximo.");
                        this.txtCantidad.setValue(Integer.valueOf(registros));
                    }
                    this.sql = "INSERT INTO i_auditoria(Fecha, Bodega, Minimo, Maximo, Cantidad) VALUES ('" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "','" + this.txtValorMinimo.getValue() + "','" + this.txtValorMaximo.getValue() + "','" + this.txtCantidad.getValue() + "')";
                    this.sql = "SELECT MAX(Id) FROM i_auditoria WHERE (Fecha = '" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "') AND (Bodega = '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
                    this.IdAuditoria = Integer.parseInt(this.consultas.traerDato(this.sql));
                    this.lblNumero.setText(String.valueOf(this.IdAuditoria));
                    this.consultas.cerrarConexionBd();
                    for (int i = 0; i < Integer.parseInt(this.txtCantidad.getValue().toString()) / 2; i++) {
                        int producto = (int) (Math.random() * ((double) registros));
                        this.rs.absolute(producto);
                        this.sql = "INSERT INTO i_detalleauditoria(Id, Producto, Rotacion, CantidadInventario, Valor) VALUES ('" + this.IdAuditoria + "','" + this.rs.getString(1) + "','" + this.rs.getString(5) + "','" + this.rs.getString(6) + "','" + this.rs.getString(7) + "')";
                        this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                        this.modelo.setValueAt(this.rs.getString(3) + " - " + this.rs.getString(4) + " - " + this.rs.getString(8) + " - " + this.rs.getString(9), this.filaGrid, 1);
                        this.modelo.setValueAt(this.rs.getString(5), this.filaGrid, 2);
                        if (this.rs.getString(6).equals(null)) {
                            this.modelo.setValueAt(0, this.filaGrid, 3);
                        } else {
                            this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.filaGrid, 3);
                        }
                        this.modelo.setValueAt(0, this.filaGrid, 4);
                        this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.filaGrid, 5);
                        if (this.rs.getInt(7) < 1) {
                            this.modelo.setValueAt(0, this.filaGrid, 6);
                        } else {
                            this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(7)), this.filaGrid, 6);
                        }
                        this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6) * this.rs.getInt(7)), this.filaGrid, 7);
                        this.filaGrid++;
                    }
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, SUM(i_detallesalida.CantidadDespachada), SUM(i_suministroxbodega.Existencia), AVG(i_suministroxbodega.Costo), i_laboratorio.Nbre, i_tipoproducto.Nbre FROM i_detallesalida INNER JOIN i_salidas ON i_detallesalida.IdSalida = i_salidas.Id INNER JOIN i_suministro ON i_detallesalida.IdProducto = i_suministro.Id INNER JOIN i_suministroxbodega ON i_suministro.Id = i_suministroxbodega.IdProducto INNER JOIN i_presentacioncomercial ON i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id INNER JOIN i_laboratorio ON i_suministro.IdLaboratorio = i_laboratorio.Id INNER JOIN i_tipoproducto ON i_suministro.IdTipoProducto = i_tipoproducto.Id WHERE (i_salidas.IdBodega = '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "') AND (i_salidas.FechaSalida > '" + this.metodos.formatoAMD.format(this.fechaAnterior.getTime()) + "') AND  (i_salidas.FechaSalida < '" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "') AND (i_suministroxbodega.Existencia > 0) AND (i_suministroxBodega.Costo > '" + this.txtValorMinimo.getValue() + "') AND (i_suministroxbodega.Costo < '" + this.txtValorMaximo.getValue() + "') AND (i_detallesalida.CantidadDespachada > 0) GROUP BY i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_tipoproducto.Nbre, i_suministro.CodBarraUnidad ORDER BY SUM(i_suministroxbodega.Costo) DESC";
                    ResultSet rsRotacion = this.consultas.traerRs(this.sql);
                    rsRotacion.last();
                    this.consultas.cerrarConexionBd();
                    int cant = rsRotacion.getRow();
                    if (cant < 1) {
                        this.metodos.mostrarMensaje("No hay existencia de productos con la condición de consulta");
                    } else {
                        if (cant < Integer.parseInt(this.txtCantidad.getValue().toString()) / 2) {
                            this.metodos.mostrarMensaje("La Cantidad de Productos solicitados de Mayor Rotación \nno alcanza, por lo tanto se tomaran los encontrados.");
                        }
                        for (int k = 1; k < (Integer.parseInt(this.txtCantidad.getValue().toString()) / 2) + 1; k++) {
                            rsRotacion.absolute(k);
                            this.sql = "INSERT INTO i_detalleauditoria(Id, Producto, Rotacion, CantidadInventario, Valor) VALUES ('" + this.IdAuditoria + "','" + rsRotacion.getString(1) + "','" + rsRotacion.getString(5) + "','" + rsRotacion.getString(6) + "','" + rsRotacion.getString(7) + "')";
                            this.consultas.ejecutarSQL(this.sql);
                            this.consultas.cerrarConexionBd();
                            this.modelo.addRow(this.dato);
                            this.modelo.setValueAt(rsRotacion.getString(1), this.filaGrid, 0);
                            this.modelo.setValueAt(rsRotacion.getString(3) + " - " + rsRotacion.getString(4) + " - " + rsRotacion.getString(8) + " - " + rsRotacion.getString(9), this.filaGrid, 1);
                            this.modelo.setValueAt(rsRotacion.getString(5), this.filaGrid, 2);
                            if (rsRotacion.getString(6).equals(null)) {
                                this.modelo.setValueAt(0, this.filaGrid, 3);
                            } else {
                                this.modelo.setValueAt(Integer.valueOf(rsRotacion.getInt(6)), this.filaGrid, 3);
                            }
                            this.modelo.setValueAt(0, this.filaGrid, 4);
                            this.modelo.setValueAt(Integer.valueOf(rsRotacion.getInt(6)), this.filaGrid, 5);
                            if (rsRotacion.getInt(7) < 1) {
                                this.modelo.setValueAt(0, this.filaGrid, 6);
                            } else {
                                this.modelo.setValueAt(Integer.valueOf(rsRotacion.getInt(7)), this.filaGrid, 6);
                            }
                            this.modelo.setValueAt(Integer.valueOf(rsRotacion.getInt(6) * rsRotacion.getInt(7)), this.filaGrid, 7);
                            this.filaGrid++;
                        }
                    }
                    break;
                case 2:
                    this.sql = "SELECT MAX(Id) FROM i_auditoria WHERE (Fecha = '" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "') AND (Bodega = '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
                    this.IdAuditoria = Integer.parseInt(this.consultas.traerDato(this.sql));
                    this.lblNumero.setText(String.valueOf(this.IdAuditoria));
                    this.consultas.cerrarConexionBd();
                    if (this.IdAuditoria > 0) {
                        llenarGrid(this.lblNumero.getText());
                    } else {
                        this.metodos.mostrarMensaje("No existe Información de productos para la Bodega seleccionada");
                    }
                    break;
                case 3:
                    this.lblNumero.setText(this.txtNumero.getValue().toString());
                    llenarGrid(this.txtNumero.getValue().toString());
                    break;
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void grabar() {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.sql = "UPDATE i_detalleauditoria SET CantidadFisica = '" + this.modelo.getValueAt(i, 4) + "', Explicacion = '" + this.modelo.getValueAt(i, 8) + "', Accion = '" + this.modelo.getValueAt(i, 9) + "', Responsable = '" + this.modelo.getValueAt(i, 10) + "' WHERE (Id = '" + this.lblNumero.getText() + "') AND (Producto = '" + this.modelo.getValueAt(i, 0) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
        this.metodos.mostrarMensaje("Grabada las modificaciones del registro");
    }

    public void limpiarGrid() {
        int fila = this.modelo.getRowCount();
        if (fila >= 0) {
            for (int i = 1; i <= fila; i++) {
                this.modelo.removeRow(0);
            }
        }
    }

    public void llenarGrid(String numero) {
        try {
            this.sql = "SELECT i_suministro.Nbre, i_presentacioncomercial.Nbre, i_detalleauditoria.Rotacion, i_detalleauditoria.CantidadInventario, i_detalleauditoria.CantidadFisica, i_detalleauditoria.Valor, i_detalleauditoria.Explicacion, i_detalleauditoria.Accion, i_detalleauditoria.Responsable, i_suministro.Id, i_auditoria.Id, i_tipoproducto.Nbre, i_laboratorio.Nbre FROM i_auditoria INNER JOIN i_detalleauditoria ON i_auditoria.Id = i_detalleauditoria.Id INNER JOIN i_suministro ON i_detalleauditoria.Producto = i_suministro.Id INNER JOIN i_presentacioncomercial ON i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id INNER JOIN i_laboratorio ON i_suministro.IdLaboratorio = i_laboratorio.Id INNER JOIN i_tipoproducto ON i_suministro.IdTipoProducto = i_tipoproducto.Id WHERE (i_auditoria.Id = '" + numero + "')";
            this.rs = this.consultas.traerRs(this.sql);
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1) + " - " + this.rs.getString(2) + " - " + this.rs.getString(12) + " - " + this.rs.getString(13), this.filaGrid, 1);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(3)), this.filaGrid, 2);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(4)), this.filaGrid, 3);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(5)), this.filaGrid, 4);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(4) - this.rs.getInt(5)), this.filaGrid, 5);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(6) * (this.rs.getInt(4) - this.rs.getInt(5))), this.filaGrid, 7);
                this.modelo.setValueAt(this.rs.getString(7), this.filaGrid, 8);
                this.modelo.setValueAt(this.rs.getString(8), this.filaGrid, 9);
                this.modelo.setValueAt(this.rs.getString(9), this.filaGrid, 10);
                this.modelo.setValueAt(this.rs.getString(10), this.filaGrid, 0);
                this.filaGrid++;
            }
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnAceptar = new JButton();
        this.lblTitulo = new JLabel();
        this.jLabel5 = new JLabel();
        this.cboBodega = new JComboBox();
        this.jPanel2 = new JPanel();
        this.btnConsultarFecha = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.btnConsultarNumero = new JRadioButton();
        this.txtNumero = new JSpinner();
        this.jPanel3 = new JPanel();
        this.btnGenerar = new JRadioButton();
        this.txtCantidad = new JSpinner();
        this.txtValorMinimo = new JSpinner();
        this.txtValorMaximo = new JSpinner();
        this.lblNumero = new JLabel();
        this.jPanel4 = new JPanel();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.txtExplicacion = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.txtAccion = new JTextArea();
        this.txtResponsable = new JTextField();
        this.btnModificar = new JButton();
        this.jPanel5 = new JPanel();
        this.txtCantInventario = new JFormattedTextField();
        this.txtCantFisica = new JFormattedTextField();
        this.txtCantDiferencia = new JFormattedTextField();
        this.jPanel6 = new JPanel();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtCostoDiferencia = new JFormattedTextField();
        this.btnImprimir = new JButton();
        this.btnGrabar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE AUDITORIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(604, 492));
        setMinimumSize(new Dimension(604, 492));
        setName("FIInformes");
        setNormalBounds(new Rectangle(0, 0, 604, 460));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        this.jPanel1.setLayout((LayoutManager) null);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 10, 1160, 200);
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(30, 400, 1180, 220);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.3
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnAceptar);
        this.btnAceptar.setBounds(990, 130, 210, 35);
        this.lblTitulo.setBackground(new Color(255, 255, 255));
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(0, 102, 0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("CONSULTA DE AUDITORIA");
        this.lblTitulo.setOpaque(true);
        getContentPane().add(this.lblTitulo);
        this.lblTitulo.setBounds(20, 20, 1180, 20);
        this.jLabel5.setBackground((Color) null);
        this.jLabel5.setFont(new Font("Arial", 1, 14));
        this.jLabel5.setForeground(new Color(0, 102, 0));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("Bodega");
        this.jLabel5.setOpaque(true);
        getContentPane().add(this.jLabel5);
        this.jLabel5.setBounds(990, 60, 210, 20);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.4
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.cboBodegaActionPerformed(evt);
            }
        });
        getContentPane().add(this.cboBodega);
        this.cboBodega.setBounds(990, 90, 210, 30);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.buttonGroup1.add(this.btnConsultarFecha);
        this.btnConsultarFecha.setFont(new Font("Arial", 1, 12));
        this.btnConsultarFecha.setForeground(new Color(0, 0, 255));
        this.btnConsultarFecha.setText("Consultar fechas anteriores");
        this.btnConsultarFecha.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.5
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnConsultarFechaActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnConsultarFecha);
        this.btnConsultarFecha.setBounds(10, 20, 210, 30);
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtFecha);
        this.txtFecha.setBounds(220, 20, 100, 30);
        this.buttonGroup1.add(this.btnConsultarNumero);
        this.btnConsultarNumero.setFont(new Font("Arial", 1, 12));
        this.btnConsultarNumero.setForeground(new Color(0, 0, 255));
        this.btnConsultarNumero.setText("Consultar Número");
        this.btnConsultarNumero.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.6
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnConsultarNumeroActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnConsultarNumero);
        this.btnConsultarNumero.setBounds(10, 90, 140, 23);
        this.txtNumero.setFont(new Font("Arial", 1, 12));
        this.txtNumero.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtNumero.setEnabled(false);
        this.txtNumero.addChangeListener(new ChangeListener() { // from class: Inventarios.InformesAuditoria.7
            public void stateChanged(ChangeEvent evt) {
                InformesAuditoria.this.txtNumeroStateChanged(evt);
            }
        });
        this.txtNumero.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.InformesAuditoria.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                InformesAuditoria.this.txtNumeroPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.txtNumero);
        this.txtNumero.setBounds(220, 80, 100, 30);
        getContentPane().add(this.jPanel2);
        this.jPanel2.setBounds(450, 50, 330, 130);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "GENERAR Y CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.buttonGroup1.add(this.btnGenerar);
        this.btnGenerar.setFont(new Font("Arial", 1, 12));
        this.btnGenerar.setForeground(new Color(0, 0, 255));
        this.btnGenerar.setSelected(true);
        this.btnGenerar.setText("Generar y mostrar reporte");
        this.btnGenerar.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.9
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnGenerarActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnGenerar);
        this.btnGenerar.setBounds(10, 20, 190, 23);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setModel(new SpinnerNumberModel(10, 1, (Comparable) null, 1));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad de Productos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.txtCantidad);
        this.txtCantidad.setBounds(250, 60, 160, 40);
        this.txtValorMinimo.setFont(new Font("Arial", 1, 12));
        this.txtValorMinimo.setModel(new SpinnerNumberModel(10000, 1, (Comparable) null, 1));
        this.txtValorMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.txtValorMinimo);
        this.txtValorMinimo.setBounds(10, 60, 110, 40);
        this.txtValorMaximo.setFont(new Font("Arial", 1, 12));
        this.txtValorMaximo.setModel(new SpinnerNumberModel(20000, 1, (Comparable) null, 1));
        this.txtValorMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.txtValorMaximo);
        this.txtValorMaximo.setBounds(130, 60, 110, 40);
        getContentPane().add(this.jPanel3);
        this.jPanel3.setBounds(20, 50, 420, 130);
        this.lblNumero.setBackground(new Color(0, 0, 153));
        this.lblNumero.setFont(new Font("Arial", 1, 24));
        this.lblNumero.setForeground(new Color(255, 255, 255));
        this.lblNumero.setHorizontalAlignment(0);
        this.lblNumero.setText("0");
        this.lblNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, (Font) null, new Color(204, 255, 255)));
        this.lblNumero.setEnabled(false);
        this.lblNumero.setOpaque(true);
        getContentPane().add(this.lblNumero);
        this.lblNumero.setBounds(790, 60, 180, 120);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PRODUCTO A AUDITAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel4.setLayout((LayoutManager) null);
        this.txtProducto.setEditable(false);
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.add(this.txtProducto);
        this.txtProducto.setBounds(20, 30, 520, 40);
        this.txtExplicacion.setColumns(20);
        this.txtExplicacion.setFont(new Font("Arial", 1, 12));
        this.txtExplicacion.setRows(5);
        this.txtExplicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Explicación de la Diferencia", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jScrollPane2.setViewportView(this.txtExplicacion);
        this.jPanel4.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(20, 100, 410, 90);
        this.txtAccion.setColumns(20);
        this.txtAccion.setFont(new Font("Arial", 1, 12));
        this.txtAccion.setRows(5);
        this.txtAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Acción", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jScrollPane3.setViewportView(this.txtAccion);
        this.jPanel4.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(440, 100, 450, 90);
        this.txtResponsable.setFont(new Font("Arial", 1, 12));
        this.txtResponsable.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.add(this.txtResponsable);
        this.txtResponsable.setBounds(900, 120, 250, 40);
        this.btnModificar.setFont(new Font("Arial", 1, 12));
        this.btnModificar.setText("Modificar");
        this.btnModificar.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.10
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnModificarActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.btnModificar);
        this.btnModificar.setBounds(900, 170, 250, 30);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "CANTIDADES", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel5.setLayout((LayoutManager) null);
        this.txtCantInventario.setEditable(false);
        this.txtCantInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "Inventario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantInventario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtCantInventario.setHorizontalAlignment(4);
        this.txtCantInventario.setFont(new Font("Arial", 1, 12));
        this.jPanel5.add(this.txtCantInventario);
        this.txtCantInventario.setBounds(10, 30, 110, 40);
        this.txtCantFisica.setBorder(BorderFactory.createTitledBorder((Border) null, "Física", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantFisica.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtCantFisica.setHorizontalAlignment(4);
        this.txtCantFisica.setFont(new Font("Arial", 1, 12));
        this.txtCantFisica.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.11
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.txtCantFisicaActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.txtCantFisica);
        this.txtCantFisica.setBounds(130, 30, 100, 40);
        this.txtCantDiferencia.setEditable(false);
        this.txtCantDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Diferencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantDiferencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtCantDiferencia.setHorizontalAlignment(4);
        this.txtCantDiferencia.setFont(new Font("Arial", 1, 12));
        this.jPanel5.add(this.txtCantDiferencia);
        this.txtCantDiferencia.setBounds(240, 30, 100, 40);
        this.jPanel4.add(this.jPanel5);
        this.jPanel5.setBounds(550, 10, 360, 90);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "COSTOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.txtValorUnidad.setEditable(false);
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("¤#,##0;(¤#,##0)"))));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.jPanel6.add(this.txtValorUnidad);
        this.txtValorUnidad.setBounds(10, 30, 100, 40);
        this.txtCostoDiferencia.setEditable(false);
        this.txtCostoDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Costo Diferencia ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCostoDiferencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("¤#,##0;(¤#,##0)"))));
        this.txtCostoDiferencia.setHorizontalAlignment(4);
        this.txtCostoDiferencia.setFont(new Font("Arial", 1, 12));
        this.jPanel6.add(this.txtCostoDiferencia);
        this.txtCostoDiferencia.setBounds(110, 30, 120, 40);
        this.jPanel4.add(this.jPanel6);
        this.jPanel6.setBounds(910, 10, 240, 90);
        getContentPane().add(this.jPanel4);
        this.jPanel4.setBounds(30, 180, 1180, 220);
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Impresora29x27.png")));
        this.btnImprimir.setText("Imprimir Informe de Gerencia");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.12
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnImprimir);
        this.btnImprimir.setBounds(620, 640, 580, 40);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Inventarios.InformesAuditoria.13
            public void actionPerformed(ActionEvent evt) {
                InformesAuditoria.this.btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnGrabar);
        this.btnGrabar.setBounds(10, 640, 600, 40);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        evaluarAccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsultarFechaActionPerformed(ActionEvent evt) {
        this.opcion = 2;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGenerarActionPerformed(ActionEvent evt) {
        this.opcion = 1;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsultarNumeroActionPerformed(ActionEvent evt) {
        this.opcion = 3;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroPropertyChange(PropertyChangeEvent evt) {
        this.lblNumero.setText(String.valueOf(this.txtNumero.getValue().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroStateChanged(ChangeEvent evt) {
        this.lblNumero.setText(String.valueOf(this.txtNumero.getValue().toString()));
        this.btnAceptar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantFisicaActionPerformed(ActionEvent evt) {
        this.txtCantDiferencia.setText(String.valueOf(Integer.parseInt(this.txtCantInventario.getText()) - Integer.parseInt(this.txtCantFisica.getText())));
        this.txtCostoDiferencia.setValue(Integer.valueOf(Integer.parseInt(this.txtValorUnidad.getValue().toString()) * (Integer.parseInt(this.txtCantInventario.getText()) - Integer.parseInt(this.txtCantFisica.getText()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnModificarActionPerformed(ActionEvent evt) {
        this.grid.setValueAt(this.txtCantFisica.getText(), this.filaGrid, 4);
        this.grid.setValueAt(this.txtCantDiferencia.getText(), this.filaGrid, 5);
        this.grid.setValueAt(this.txtCostoDiferencia.getText(), this.filaGrid, 7);
        this.grid.setValueAt(this.txtExplicacion.getText(), this.filaGrid, 8);
        this.grid.setValueAt(this.txtAccion.getText(), this.filaGrid, 9);
        this.grid.setValueAt(this.txtResponsable.getText(), this.filaGrid, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }
}
