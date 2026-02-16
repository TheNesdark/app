package Inventarios;

import Acceso.Menus;
import Acceso.Principal;
import General.Anular;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Faltantes.class */
public class Faltantes extends JInternalFrame {
    private Object[] dato;
    private int cboLleno;
    private int IdSuministroxBodega;
    private String sql;
    private String estado;
    private String fecha;
    private String[][] listaFaltantes;
    private String[][] listaLote;
    private String[][] listaProductos;
    private DefaultTableModel modelo;
    private claseInventario claseInv;
    private List<IInformacionInventario> informacionInventarios;
    private JButton btnEntregar;
    private JButton btnLlamar;
    private ButtonGroup buttonGroup1;
    public JComboBox cboDespacho;
    public JComboBox cboFaltantes;
    private JComboBox cboLote;
    private JComboBox cboProducto;
    public JTable gridFaltantes;
    private JPanel jPanel1;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField txtCodigo;
    private JFormattedTextField txtEntregada;
    private JFormattedTextField txtExistencia;
    private JFormattedTextField txtFaltante;
    public JFormattedTextField txtFecha;
    public JDateChooser txtFechaEntrega;
    public JTextField txtHistoria;
    public JEditorPane txtObservaciones;
    public JTextField txtPaciente;
    public JTextField txtProfesional;
    private JSpinner txtSeEntregara;
    private JFormattedTextField txtSolicitada;
    private JFormattedTextField txtValorTotal;
    private JFormattedTextField txtValorUnidad;
    private JFormattedTextField txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int empacado = 0;
    private int filaGrid = 0;
    private int grabarFaltante = 0;
    private String IdSalida = "0";

    public Faltantes(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        crearGrid();
        cargarProductos();
        this.gridFaltantes.addMouseListener(new MouseAdapter() { // from class: Inventarios.Faltantes.1
            public void mouseClicked(MouseEvent e) {
                Faltantes.this.filaGrid = Faltantes.this.gridFaltantes.rowAtPoint(e.getPoint());
                Faltantes.this.cargarDatosDelGrid();
            }
        });
        nuevo();
    }

    public void anular() {
        if (this.IdSalida == null || this.IdSalida.equals("")) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Faltante para Anular");
            this.cboFaltantes.requestFocus();
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("El Faltante ya se encuentra Anulado.");
        } else {
            Anular frm = new Anular(null, true, "Faltantes", 4);
            frm.setVisible(true);
        }
    }

    public void anularFaltante(String razon) {
        this.sql = "UPDATE i_faltantes SET  Estado = '" + razon + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + this.cboFaltantes.getSelectedItem().toString() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.marcarEstado(1);
        sumarCantidades();
        this.metodos.mostrarMensaje("Faltante Anulado, Ok");
    }

    private void buscarProducto(int op) {
        int pos = 0;
        int encontrado = 0;
        if (op == 1) {
            this.cboProducto.setSelectedIndex(-1);
            int i = 0;
            while (true) {
                if (i >= this.listaProductos.length) {
                    break;
                }
                if (!this.txtCodigo.getText().equals(this.listaProductos[i][0])) {
                    i++;
                } else {
                    this.cboProducto.setSelectedItem(this.listaProductos[i][1]);
                    pos = i;
                    encontrado = 1;
                    break;
                }
            }
        } else {
            this.txtCodigo.setText(this.listaProductos[this.cboProducto.getSelectedIndex()][0]);
            pos = this.cboProducto.getSelectedIndex();
            encontrado = 1;
        }
        if (encontrado == 1) {
            this.txtExistencia.setText(this.listaProductos[pos][3]);
            this.txtValorUnidad.setText(String.valueOf(this.metodos.redondear(Double.parseDouble(this.listaProductos[pos][4]), 2)));
            cargarLoteFechaVencimiento();
        }
    }

    public void buscarFaltante() {
        BuscarFaltante frm = new BuscarFaltante(null, true, this);
        frm.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
        this.txtCodigo.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.cboProducto.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 2).toString());
        this.txtSolicitada.setValue(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(this.filaGrid, 3).toString())));
        this.txtEntregada.setValue(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(this.filaGrid, 4).toString())));
        this.txtFaltante.setValue(Integer.valueOf(((Integer) this.txtSolicitada.getValue()).intValue() - ((Integer) this.txtEntregada.getValue()).intValue()));
        this.txtSeEntregara.setValue(this.txtFaltante.getValue());
    }

    private void cargarDatosFaltantes() {
        limpiarCabecera();
        limpiarDatos();
        limpiarGrid();
        this.txtFecha.setText(this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][2].toString().substring(0, 10));
        this.txtHistoria.setText(this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][3]);
        this.txtPaciente.setText(this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][4]);
        this.txtProfesional.setText(this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][5]);
        this.txtObservaciones.setText(this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][6]);
        try {
            this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_detallefaltante.Cantidad, i_detallefaltante.Entregada, i_detallefaltante.Empacado, i_detallefaltante.FechaEntrega, i_suministroxbodega.Costo, i_suministroxbodega.IdBodega, i_laboratorio.Nbre FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_detallefaltante ON (i_detallefaltante.IdSuministro = i_suministro.Id) WHERE (i_detallefaltante.Entregada < i_detallefaltante.Cantidad AND i_suministroxbodega.IdBodega ='" + this.claseInv.getIdBodega() + "' AND i_detallefaltante.IdFaltante ='" + this.cboFaltantes.getSelectedItem() + "') ORDER BY i_suministro.Nbre ASC";
            ResultSet rs = this.consultas.traerRs(this.sql);
            int i = 0;
            while (rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString(1), i, 0);
                this.modelo.setValueAt(rs.getString(2), i, 1);
                this.modelo.setValueAt(rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(11), i, 2);
                this.modelo.setValueAt(rs.getString(5), i, 3);
                this.modelo.setValueAt(rs.getString(6), i, 4);
                this.modelo.setValueAt(Integer.valueOf(Integer.parseInt(rs.getString(5)) - Integer.parseInt(rs.getString(6))), i, 5);
                this.modelo.setValueAt(Integer.valueOf(Integer.parseInt(rs.getString(5)) - Integer.parseInt(rs.getString(6))), i, 6);
                this.modelo.setValueAt(Double.valueOf(this.metodos.redondear(rs.getDouble(9), 2)), i, 9);
                this.modelo.setValueAt(rs.getDate(8), i, 10);
                this.modelo.setValueAt("", i, 11);
                i++;
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void cargarListaFaltantes() {
        this.cboFaltantes.removeAllItems();
        this.cboDespacho.removeAllItems();
        this.cboLleno = 0;
        try {
            this.sql = "SELECT i_faltantes.Id, i_faltantes.IdSalida, i_salidas.FechaSalida, w_persona.NoHistoria, w_persona.NUsuario, w_profesional.NProfesional, i_faltantes.Observacion, i_faltantes.EntregadoCompleto, i_salidas.IdTipoMovimiento, i_salidas.IdDestino, i_salidas.IdProfesional FROM i_faltantes INNER JOIN i_salidas ON (i_faltantes.IdSalida = i_salidas.Id) INNER JOIN w_persona ON (i_salidas.IdDestino = w_persona.Id_persona) INNER JOIN w_profesional ON (i_salidas.IdProfesional = w_profesional.Id_Persona) WHERE (i_faltantes.Estado =0 AND i_faltantes.EntregadoCompleto =0) ORDER BY i_faltantes.Id ASC";
            ResultSet rs = this.consultas.traerRs(this.sql);
            rs.last();
            if (rs.getRow() >= 0) {
                int i = 0;
                int noFilas = rs.getRow();
                rs.beforeFirst();
                this.listaFaltantes = new String[noFilas][11];
                while (rs.next()) {
                    this.listaFaltantes[i][0] = rs.getString(1);
                    this.listaFaltantes[i][1] = rs.getString(2);
                    this.listaFaltantes[i][2] = rs.getString(3);
                    this.listaFaltantes[i][3] = rs.getString(4);
                    this.listaFaltantes[i][4] = rs.getString(5);
                    this.listaFaltantes[i][5] = rs.getString(6);
                    this.listaFaltantes[i][6] = rs.getString(7);
                    this.listaFaltantes[i][7] = rs.getString(8);
                    this.listaFaltantes[i][8] = rs.getString(9);
                    this.listaFaltantes[i][9] = rs.getString(10);
                    this.listaFaltantes[i][10] = rs.getString(11);
                    this.cboFaltantes.addItem(rs.getString(1));
                    this.cboDespacho.addItem(rs.getString(2));
                    i++;
                }
            }
            JTextComponent editor = this.cboFaltantes.getEditor().getEditorComponent();
            editor.setDocument(new Autocomplete(this.cboFaltantes));
            JTextComponent editor2 = this.cboDespacho.getEditor().getEditorComponent();
            editor2.setDocument(new Autocomplete(this.cboDespacho));
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.cboLleno = 1;
    }

    private void cargarLoteFechaVencimiento() {
        try {
            this.cboLote.removeAllItems();
            this.cboLleno = 0;
            this.sql = "SELECT Lote, i_suministroxlotexbodega.FechaVencimiento, i_suministroxlotexbodega.Cantidad, i_suministroxbodega.Costo, i_suministroxlotexbodega.Id FROM  i_suministroxlotexbodega  INNER JOIN i_suministroxbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega = '" + this.claseInv.getIdBodega() + "' AND i_suministroxbodega.IdSuministro ='" + this.listaProductos[this.cboProducto.getSelectedIndex()][2] + "' AND Lote <> 'FALTANTE' AND i_suministroxlotexbodega.Cantidad >0 )";
            ResultSet rs = this.consultas.traerRs(this.sql);
            rs.last();
            int i = 0;
            if (rs.getRow() > 0) {
                int noFilas = rs.getRow();
                rs.beforeFirst();
                this.listaLote = new String[noFilas][5];
                while (rs.next()) {
                    this.listaLote[i][0] = rs.getString(1);
                    this.listaLote[i][1] = this.metodos.formatoAMD.format((Date) rs.getDate(2));
                    this.listaLote[i][2] = rs.getString(3);
                    this.listaLote[i][3] = rs.getString(4);
                    this.listaLote[i][4] = rs.getString(5);
                    this.cboLote.addItem(rs.getString(1));
                    i++;
                }
                JTextComponent editor = this.cboLote.getEditor().getEditorComponent();
                editor.setDocument(new Autocomplete(this.cboLote));
            } else {
                this.metodos.mostrarMensaje("No se encontró Lote disponible para el Producto");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            if (i > 0) {
                this.cboLote.setSelectedIndex(0);
                this.txtVencimiento.setText(this.listaLote[0][1]);
                this.txtExistencia.setValue(Integer.valueOf(Integer.parseInt(this.listaLote[0][2].toString())));
                this.txtValorUnidad.setValue(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.listaLote[0][3].toString()), 2)));
                this.txtValorTotal.setValue(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtSeEntregara.getValue().toString()) * Double.parseDouble(this.listaLote[0][3].toString()), 2)));
            }
            this.cboLleno = 1;
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarProductos() {
        try {
            this.sql = "SELECT i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_suministro.Id, i_suministroxbodega.Existencia, i_suministroxbodega.Costo, i_laboratorio.Nbre FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.claseInv.getIdBodega() + "') ORDER BY i_suministro.Nbre ASC";
            ResultSet rs = this.consultas.traerRs(this.sql);
            rs.last();
            int i = 0;
            int noFilas = rs.getRow();
            this.listaProductos = new String[noFilas][5];
            rs.beforeFirst();
            while (rs.next()) {
                this.listaProductos[i][0] = rs.getString(1);
                this.listaProductos[i][1] = rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(7);
                this.listaProductos[i][2] = rs.getString(4);
                this.listaProductos[i][3] = rs.getString(5);
                this.listaProductos[i][4] = rs.getString(6);
                this.cboProducto.addItem(this.listaProductos[i][1]);
                i++;
            }
            JTextComponent editor = this.cboProducto.getEditor().getEditorComponent();
            editor.setDocument(new Autocomplete(this.cboProducto));
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Solicitado", "Entregado", "Faltante", "Se Entregará", "Lote", "Vencimiento", "Vr. Unidad", "Fecha Entrega", "IdSxLxB"}) { // from class: Inventarios.Faltantes.2
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, Double.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridFaltantes.setModel(this.modelo);
        this.gridFaltantes.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.gridFaltantes.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridFaltantes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridFaltantes.getColumnModel().getColumn(1).setPreferredWidth(110);
        this.gridFaltantes.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.gridFaltantes.getColumnModel().getColumn(3).setPreferredWidth(75);
        this.gridFaltantes.getColumnModel().getColumn(4).setPreferredWidth(75);
        this.gridFaltantes.getColumnModel().getColumn(5).setPreferredWidth(75);
        this.gridFaltantes.getColumnModel().getColumn(6).setPreferredWidth(78);
        this.gridFaltantes.getColumnModel().getColumn(7).setPreferredWidth(90);
        this.gridFaltantes.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.gridFaltantes.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.gridFaltantes.getColumnModel().getColumn(10).setPreferredWidth(90);
        this.gridFaltantes.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.filaGrid = 0;
    }

    private void descargarFaltante(int entregado) {
        this.sql = "UPDATE i_faltantes SET  EntregadoCompleto = '" + entregado + "', Observacion = '" + this.txtObservaciones.getText() + "'";
        if (entregado == 1) {
            this.sql += ", Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "'";
        }
        this.sql += " WHERE (Id = '" + this.cboFaltantes.getSelectedItem() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void entregar() {
        if (((Integer) this.txtSeEntregara.getValue()).intValue() > Integer.parseInt(this.txtExistencia.getValue().toString())) {
            this.metodos.mostrarMensaje("La Cantidad que se Entregará no puede ser superior a la Existencia del Producto por Lote");
            this.txtSeEntregara.setValue(this.txtExistencia.getValue());
            this.txtSeEntregara.requestFocus();
            return;
        }
        if (((Integer) this.txtSeEntregara.getValue()).intValue() > Integer.parseInt(this.txtFaltante.getValue().toString()) && this.cboProducto.getSelectedItem().equals(this.modelo.getValueAt(this.filaGrid, 2))) {
            this.metodos.mostrarMensaje("La Cantidad que se entregará no puede ser superior al Faltante del Producto");
            this.txtSeEntregara.setValue(this.txtFaltante.getValue());
            this.txtSeEntregara.requestFocus();
            return;
        }
        if (this.txtCodigo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione el Producto que Saldra.");
            this.cboProducto.requestFocus();
            return;
        }
        if (this.cboLote.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Lote del Producto que Entregará");
            this.cboLote.requestFocus();
            return;
        }
        this.modelo.setValueAt(this.listaProductos[this.cboProducto.getSelectedIndex()][2], this.filaGrid, 0);
        this.modelo.setValueAt(this.listaProductos[this.cboProducto.getSelectedIndex()][0], this.filaGrid, 1);
        this.modelo.setValueAt(this.listaProductos[this.cboProducto.getSelectedIndex()][1], this.filaGrid, 2);
        this.modelo.setValueAt(this.txtSolicitada.getText(), this.filaGrid, 3);
        this.modelo.setValueAt(this.txtEntregada.getText(), this.filaGrid, 4);
        this.modelo.setValueAt(this.txtFaltante.getValue(), this.filaGrid, 5);
        this.modelo.setValueAt(this.txtSeEntregara.getValue(), this.filaGrid, 6);
        this.modelo.setValueAt(this.cboLote.getSelectedItem(), this.filaGrid, 7);
        this.modelo.setValueAt(this.txtVencimiento.getText(), this.filaGrid, 8);
        this.modelo.setValueAt(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)), this.filaGrid, 9);
        this.modelo.setValueAt(this.metodos.formatoAMD.format(this.txtFechaEntrega.getDate()), this.filaGrid, 10);
        this.modelo.setValueAt(this.listaLote[this.cboLote.getSelectedIndex()][4], this.filaGrid, 11);
        this.grabarFaltante = 1;
    }

    public void grabar() {
        if (this.grabarFaltante == 1) {
            if (!this.claseInv.mVerificarMovDPeriodo(this.txtFechaEntrega.getDate())) {
                grabarCabeceraSalida();
                int entregado = 1;
                for (int i = 0; i < this.modelo.getRowCount(); i++) {
                    if (this.modelo.getValueAt(i, 7) != null) {
                        if (Integer.parseInt(this.modelo.getValueAt(i, 5).toString()) > Integer.parseInt(this.modelo.getValueAt(i, 6).toString())) {
                            entregado = 0;
                        }
                        grabarDetalleSalida(i);
                        grabarSuministroxLotexBodega(i);
                        grabarDetalleFaltante(i);
                    } else {
                        entregado = 0;
                    }
                }
                descargarFaltante(entregado);
                this.metodos.mostrarMensaje("Faltante Descargado y Salida Realizada");
            } else {
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.txtFechaEntrega.requestFocus();
            }
        }
        this.consultas.cerrarConexionBd();
    }

    private void grabarCabeceraSalida() {
        this.sql = "INSERT INTO i_salidas(IdTipoMovimiento, IdBodega, FechaSalida, Id_Periodo, Destino, IdDestino, IdProfesional, Fecha, UsuarioS) VALUES ('" + this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][8] + "','" + this.claseInv.getIdBodega() + "','" + this.metodos.formatoAMD.format(this.txtFechaEntrega.getDate()) + "','" + this.claseInv.getXidperiodoc() + "','0','" + this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][9] + "','" + this.listaFaltantes[this.cboFaltantes.getSelectedIndex()][10] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.IdSalida = this.consultas.ejecutarSQLId(this.sql);
        this.estado = "ACTIVA";
        this.fecha = this.metodos.formatoDMA.format(this.metodos.getFechaActual());
        Principal.txtNo.setText(this.IdSalida);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalleSalida(int i) {
        this.sql = "INSERT INTO i_detallesalida(IdSalida, IdSuministro, Lote, FechaVencimiento, CantidadSolicitada, CantidadDespachada, ValorUnitario) VALUES ('" + this.IdSalida + "','" + this.modelo.getValueAt(i, 0) + "','" + this.modelo.getValueAt(i, 7) + "','" + this.modelo.getValueAt(i, 10) + "','" + this.modelo.getValueAt(i, 3) + "','" + this.modelo.getValueAt(i, 6) + "','" + this.modelo.getValueAt(i, 9) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarSuministroxLotexBodega(int i) {
        this.sql = "SELECT Id FROM i_suministroxbodega WHERE IdBodega = '" + this.claseInv.getIdBodega() + "' AND IdSuministro = '" + this.modelo.getValueAt(i, 0) + "'";
        this.IdSuministroxBodega = Integer.parseInt(this.consultas.traerDato(this.sql));
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad - " + Integer.parseInt(this.modelo.getValueAt(i, 6).toString()) + ") WHERE (Id = '" + this.IdSuministroxBodega + "') AND (Lote = '" + this.modelo.getValueAt(i, 7) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalleFaltante(int i) {
        this.sql = "UPDATE i_detallefaltante SET  Empacado = '" + this.empacado + "', FechaEntrega = '" + this.metodos.formatoAMD.format(this.txtFechaEntrega.getDate()) + "', Entregada = (Entregada + '" + this.modelo.getValueAt(i, 6) + "') WHERE IdSuministro = '" + this.modelo.getValueAt(i, 0) + "' AND IdFaltante = '" + this.cboFaltantes.getSelectedItem() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void limpiarCabecera() {
        this.txtFecha.setText("");
        this.txtHistoria.setText("");
        this.txtPaciente.setText("");
        this.txtProfesional.setText("");
        this.metodos.limpiarDatosPrincipal();
    }

    private void limpiarGrid() {
        int f = this.modelo.getRowCount();
        if (f > 0) {
            for (int i = 0; i < f; i++) {
                this.modelo.removeRow(0);
            }
        }
    }

    private void limpiarDatos() {
        this.txtCodigo.setText("");
        this.cboProducto.setSelectedIndex(-1);
        this.cboLote.removeAllItems();
        this.txtVencimiento.setText("");
        this.txtSolicitada.setValue(0);
        this.txtEntregada.setValue(0);
        this.txtFaltante.setValue(0);
        this.txtSeEntregara.setValue(0);
        this.txtValorUnidad.setValue(0);
        this.txtValorTotal.setValue(0);
        this.txtExistencia.setValue(0);
    }

    public final void nuevo() {
        cargarListaFaltantes();
        limpiarGrid();
        this.cboFaltantes.setSelectedIndex(-1);
        this.cboDespacho.setSelectedIndex(-1);
        this.txtFecha.setText("");
        this.txtHistoria.setText("");
        this.txtPaciente.setText("");
        this.txtProfesional.setText("");
        this.txtObservaciones.setText("");
        this.metodos.limpiarDatosPrincipal();
        this.txtCodigo.setText("");
        this.cboProducto.setSelectedIndex(-1);
        this.cboLote.removeAllItems();
        this.txtVencimiento.setText("");
        this.txtSolicitada.setValue(0);
        this.txtEntregada.setValue(0);
        this.txtFaltante.setValue(0);
        this.txtSeEntregara.setValue(0);
        this.txtValorUnidad.setValue(0);
        this.txtValorTotal.setValue(0);
        this.txtExistencia.setValue(0);
        this.txtFechaEntrega.setDate(this.metodos.getFechaActual());
        this.empacado = 0;
        this.grabarFaltante = 0;
        this.filaGrid = 0;
        this.estado = "";
        this.fecha = "";
    }

    private void llamarUsuario() {
        if (this.cboFaltantes.getSelectedIndex() != -1) {
            Principal.clasegeneral.setXidnumero(this.cboFaltantes.getSelectedItem().toString());
            Principal.clasegeneral.cargarPantalla("Llamadas");
            Principal.clasegeneral.frmLlamadas.frmPersona.txtHistoria.setText(this.txtHistoria.getText());
            Principal.clasegeneral.frmLlamadas.frmPersona.buscar(2);
            dispose();
        }
    }

    private void sumarCantidades() {
        for (int fila = 0; fila < this.modelo.getRowCount(); fila++) {
            if (this.modelo.getValueAt(fila, 11) != null || !this.modelo.getValueAt(fila, 11).toString().isEmpty()) {
                this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + " + Integer.parseInt(this.modelo.getValueAt(fila, 6).toString()) + ") WHERE (Id = '" + this.modelo.getValueAt(fila, 11) + "') AND (Lote = '" + this.modelo.getValueAt(fila, 7) + "')";
                this.consultas.ejecutarSQL(this.sql);
            }
        }
        this.consultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.gridFaltantes = new JTable();
        this.jPanel4 = new JPanel();
        this.cboFaltantes = new JComboBox();
        this.cboDespacho = new JComboBox();
        this.txtFecha = new JFormattedTextField();
        this.txtHistoria = new JTextField();
        this.txtPaciente = new JTextField();
        this.txtProfesional = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.btnLlamar = new JButton();
        this.jPanel5 = new JPanel();
        this.txtCodigo = new JTextField();
        this.txtSolicitada = new JFormattedTextField();
        this.txtEntregada = new JFormattedTextField();
        this.txtFaltante = new JFormattedTextField();
        this.txtSeEntregara = new JSpinner();
        this.cboProducto = new JComboBox();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.txtFechaEntrega = new JDateChooser();
        this.btnEntregar = new JButton();
        this.cboLote = new JComboBox();
        this.txtVencimiento = new JFormattedTextField();
        this.txtExistencia = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FALTANTE DE PRODUCTOS Y SUMINISTROS");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setLayer(1);
        setMaximumSize(new Dimension(1204, 675));
        setMinimumSize(new Dimension(1204, 675));
        setName("Faltantes");
        setPreferredSize(new Dimension(1204, 675));
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.Faltantes.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                Faltantes.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE SALIDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.gridFaltantes.setFont(new Font("Tahoma", 0, 12));
        this.gridFaltantes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridFaltantes.setEditingColumn(1);
        this.gridFaltantes.setEditingRow(1);
        this.gridFaltantes.setRowHeight(20);
        this.jScrollPane1.setViewportView(this.gridFaltantes);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1178, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 293, 32767).addContainerGap()));
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(0, 300, 1190, 330);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE LA CABECERA DEL PENDIENTE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel4.setLayout((LayoutManager) null);
        this.cboFaltantes.setEditable(true);
        this.cboFaltantes.setFont(new Font("Arial", 1, 12));
        this.cboFaltantes.setBorder(BorderFactory.createTitledBorder((Border) null, "No. de Faltante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboFaltantes.addItemListener(new ItemListener() { // from class: Inventarios.Faltantes.4
            public void itemStateChanged(ItemEvent evt) {
                Faltantes.this.cboFaltantesItemStateChanged(evt);
            }
        });
        this.cboFaltantes.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.5
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.cboFaltantesActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.cboFaltantes);
        this.cboFaltantes.setBounds(13, 30, 110, 40);
        this.cboDespacho.setEditable(true);
        this.cboDespacho.setFont(new Font("Arial", 1, 12));
        this.cboDespacho.setBorder(BorderFactory.createTitledBorder((Border) null, "No. de Despacho", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboDespacho.addItemListener(new ItemListener() { // from class: Inventarios.Faltantes.6
            public void itemStateChanged(ItemEvent evt) {
                Faltantes.this.cboDespachoItemStateChanged(evt);
            }
        });
        this.cboDespacho.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.7
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.cboDespachoActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.cboDespacho);
        this.cboDespacho.setBounds(140, 30, 120, 40);
        this.txtFecha.setEditable(false);
        this.txtFecha.setBackground((Color) null);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getDateInstance(2))));
        this.txtFecha.setHorizontalAlignment(4);
        this.txtFecha.setDisabledTextColor(new Color(102, 0, 102));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel4.add(this.txtFecha);
        this.txtFecha.setBounds(270, 30, 98, 40);
        this.txtHistoria.setEditable(false);
        this.txtHistoria.setFont(new Font("Arial", 1, 12));
        this.txtHistoria.setForeground(new Color(255, 255, 255));
        this.txtHistoria.setHorizontalAlignment(4);
        this.txtHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Historia Clínica", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtHistoria.setDisabledTextColor(new Color(102, 0, 102));
        this.txtHistoria.setEnabled(false);
        this.jPanel4.add(this.txtHistoria);
        this.txtHistoria.setBounds(370, 30, 113, 40);
        this.txtPaciente.setEditable(false);
        this.txtPaciente.setBackground((Color) null);
        this.txtPaciente.setFont(new Font("Arial", 1, 12));
        this.txtPaciente.setForeground(new Color(255, 255, 255));
        this.txtPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Paciente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtPaciente.setDisabledTextColor(new Color(0, 0, 0));
        this.txtPaciente.setEnabled(false);
        this.jPanel4.add(this.txtPaciente);
        this.txtPaciente.setBounds(487, 29, 270, 41);
        this.txtProfesional.setEditable(false);
        this.txtProfesional.setBackground((Color) null);
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setForeground(new Color(255, 255, 255));
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProfesional.setEnabled(false);
        this.jPanel4.add(this.txtProfesional);
        this.txtProfesional.setBounds(770, 29, 242, 41);
        this.txtObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 0, 255)));
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane2.setViewportView(this.txtObservaciones);
        this.jPanel4.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(20, 80, 990, 60);
        this.btnLlamar.setFont(new Font("Arial", 1, 12));
        this.btnLlamar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/celular.png")));
        this.btnLlamar.setText("Llamar al usuario");
        this.btnLlamar.setHorizontalTextPosition(0);
        this.btnLlamar.setVerticalTextPosition(3);
        this.btnLlamar.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.8
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.btnLlamarActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.btnLlamar);
        this.btnLlamar.setBounds(1030, 30, 140, 110);
        getContentPane().add(this.jPanel4);
        this.jPanel4.setBounds(0, 0, 1190, 150);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL PRODUCTO PENDIETNE QUE SALE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel5.setLayout((LayoutManager) null);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.setDisabledTextColor(new Color(0, 0, 102));
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.9
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.txtCodigoActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 30, 120, 40);
        this.txtSolicitada.setEditable(false);
        this.txtSolicitada.setBackground((Color) null);
        this.txtSolicitada.setBorder(BorderFactory.createTitledBorder((Border) null, "Solicitada", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtSolicitada.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtSolicitada.setHorizontalAlignment(4);
        this.txtSolicitada.setDisabledTextColor(new Color(0, 0, 0));
        this.txtSolicitada.setEnabled(false);
        this.txtSolicitada.setFont(new Font("Arial", 1, 12));
        this.txtSolicitada.setValue(new Integer(0));
        this.jPanel5.add(this.txtSolicitada);
        this.txtSolicitada.setBounds(10, 89, 120, 40);
        this.txtEntregada.setEditable(false);
        this.txtEntregada.setBackground((Color) null);
        this.txtEntregada.setBorder(BorderFactory.createTitledBorder((Border) null, "Entregada", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtEntregada.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtEntregada.setHorizontalAlignment(4);
        this.txtEntregada.setDisabledTextColor(new Color(0, 0, 0));
        this.txtEntregada.setEnabled(false);
        this.txtEntregada.setFont(new Font("Arial", 1, 12));
        this.txtEntregada.setValue(new Integer(0));
        this.jPanel5.add(this.txtEntregada);
        this.txtEntregada.setBounds(140, 90, 95, 40);
        this.txtFaltante.setEditable(false);
        this.txtFaltante.setBackground((Color) null);
        this.txtFaltante.setBorder(BorderFactory.createTitledBorder((Border) null, "Faltante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFaltante.setForeground(new Color(255, 255, 255));
        this.txtFaltante.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.txtFaltante.setHorizontalAlignment(4);
        this.txtFaltante.setDisabledTextColor(new Color(0, 0, 0));
        this.txtFaltante.setEnabled(false);
        this.txtFaltante.setFont(new Font("Arial", 1, 12));
        this.txtFaltante.setValue(new Integer(0));
        this.jPanel5.add(this.txtFaltante);
        this.txtFaltante.setBounds(240, 90, 127, 40);
        this.txtSeEntregara.setFont(new Font("Arial", 1, 12));
        this.txtSeEntregara.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtSeEntregara.setToolTipText("Cantidad que se entrega del producto faltante");
        this.txtSeEntregara.setBorder(BorderFactory.createTitledBorder((Border) null, "Se entregará", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtSeEntregara.addChangeListener(new ChangeListener() { // from class: Inventarios.Faltantes.10
            public void stateChanged(ChangeEvent evt) {
                Faltantes.this.txtSeEntregaraStateChanged(evt);
            }
        });
        this.jPanel5.add(this.txtSeEntregara);
        this.txtSeEntregara.setBounds(380, 90, 141, 40);
        this.cboProducto.setEditable(true);
        this.cboProducto.setFont(new Font("Arial", 1, 12));
        this.cboProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProducto.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.11
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.cboProductoActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.cboProducto);
        this.cboProducto.setBounds(140, 30, 470, 40);
        this.txtValorUnidad.setEditable(false);
        this.txtValorUnidad.setBackground((Color) null);
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorUnidad.setForeground(new Color(255, 255, 255));
        this.txtValorUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.txtValorUnidad.setDisabledTextColor(new Color(0, 0, 0));
        this.txtValorUnidad.setEnabled(false);
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.txtValorUnidad.setValue(new Double(0.0d));
        this.jPanel5.add(this.txtValorUnidad);
        this.txtValorUnidad.setBounds(530, 90, 120, 40);
        this.txtValorTotal.setEditable(false);
        this.txtValorTotal.setBackground((Color) null);
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorTotal.setForeground(new Color(255, 255, 255));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setDisabledTextColor(new Color(0, 0, 0));
        this.txtValorTotal.setEnabled(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 12));
        this.txtValorTotal.setValue(new Double(0.0d));
        this.txtValorTotal.addFocusListener(new FocusAdapter() { // from class: Inventarios.Faltantes.12
            public void focusLost(FocusEvent evt) {
                Faltantes.this.txtValorTotalFocusLost(evt);
            }
        });
        this.txtValorTotal.addKeyListener(new KeyAdapter() { // from class: Inventarios.Faltantes.13
            public void keyPressed(KeyEvent evt) {
                Faltantes.this.txtValorTotalKeyPressed(evt);
            }
        });
        this.jPanel5.add(this.txtValorTotal);
        this.txtValorTotal.setBounds(660, 90, 120, 40);
        this.txtFechaEntrega.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Entrega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaEntrega.setFont(new Font("Arial", 1, 12));
        this.jPanel5.add(this.txtFechaEntrega);
        this.txtFechaEntrega.setBounds(790, 80, 124, 50);
        this.btnEntregar.setFont(new Font("Arial", 1, 12));
        this.btnEntregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnEntregar.setText("Entregar");
        this.btnEntregar.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.14
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.btnEntregarActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.btnEntregar);
        this.btnEntregar.setBounds(920, 80, 260, 50);
        this.cboLote.setEditable(true);
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboLote.addItemListener(new ItemListener() { // from class: Inventarios.Faltantes.15
            public void itemStateChanged(ItemEvent evt) {
                Faltantes.this.cboLoteItemStateChanged(evt);
            }
        });
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.Faltantes.16
            public void actionPerformed(ActionEvent evt) {
                Faltantes.this.cboLoteActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.cboLote);
        this.cboLote.setBounds(620, 30, 250, 40);
        this.txtVencimiento.setEditable(false);
        this.txtVencimiento.setBackground(new Color(0, 0, 102));
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vencimiento", 0, 0, (Font) null, new Color(255, 255, 255)));
        this.txtVencimiento.setForeground(new Color(255, 255, 255));
        this.txtVencimiento.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getDateInstance(2))));
        this.txtVencimiento.setHorizontalAlignment(0);
        this.txtVencimiento.setDisabledTextColor(new Color(102, 0, 102));
        this.txtVencimiento.setEnabled(false);
        this.txtVencimiento.setFont(new Font("Tahoma", 1, 12));
        this.jPanel5.add(this.txtVencimiento);
        this.txtVencimiento.setBounds(890, 20, 133, 50);
        this.txtExistencia.setBackground(new Color(0, 0, 102));
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Tahoma", 0, 12), new Color(255, 255, 255)));
        this.txtExistencia.setEditable(false);
        this.txtExistencia.setForeground(new Color(255, 255, 255));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(102, 0, 102));
        this.txtExistencia.setEnabled(false);
        this.txtExistencia.setFont(new Font("Tahoma", 1, 12));
        this.txtExistencia.setValue(new Integer(0));
        this.jPanel5.add(this.txtExistencia);
        this.txtExistencia.setBounds(1022, 20, 160, 50);
        getContentPane().add(this.jPanel5);
        this.jPanel5.setBounds(0, 150, 1190, 150);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLlamarActionPerformed(ActionEvent evt) {
        llamarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalFocusLost(FocusEvent evt) {
        this.txtValorUnidad.setValue(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtValorTotal.getValue().toString()) / ((double) Integer.parseInt(this.txtSolicitada.getValue().toString())), 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEntregarActionPerformed(ActionEvent evt) {
        entregar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFaltantesActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboFaltantes.getSelectedIndex() > -1) {
            this.cboDespacho.setSelectedIndex(this.cboFaltantes.getSelectedIndex());
            cargarDatosFaltantes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSeEntregaraStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDespachoActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboDespacho.getSelectedIndex() > -1) {
            this.cboFaltantes.setSelectedIndex(this.cboDespacho.getSelectedIndex());
            cargarDatosFaltantes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        buscarProducto(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProductoActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboProducto.getSelectedIndex() > -1) {
            buscarProducto(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboLote.getSelectedIndex() > -1) {
            this.txtVencimiento.setText(this.listaLote[this.cboLote.getSelectedIndex()][1]);
            this.txtExistencia.setValue(Integer.valueOf(Integer.parseInt(this.listaLote[this.cboLote.getSelectedIndex()][2].toString())));
            if (Integer.parseInt(this.txtSolicitada.getValue().toString()) > Integer.parseInt(this.txtExistencia.getValue().toString())) {
                this.txtSeEntregara.setValue(Integer.valueOf(Integer.parseInt(this.txtExistencia.getValue().toString())));
            } else {
                this.txtSeEntregara.setValue(Integer.valueOf(Integer.parseInt(this.txtSolicitada.getText())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFaltantesItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDespachoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal principal = this.claseInv.frmPrincipal;
        Menus menus = this.claseInv.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
    }
}
