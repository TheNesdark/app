package Inventarios;

import Acceso.Menus;
import Acceso.Principal;
import General.Anular;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas;
import com.genoma.plus.dto.inventario.InfomacionLote;
import com.genoma.plus.jpa.entities.BodegaDTO;
import com.genoma.plus.jpa.entities.ISuministroxbodega;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.service.IISuministroxbodegaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/ITraslados.class */
public class ITraslados extends JInternalFrame {
    private int tipoBodegaOrigen;
    private int tipoBodegaDestino;
    private Object[] dato;
    private int cboLleno;
    private String sql;
    private String bodegaDestino;
    private String idProducto;
    private String idLote;
    private String cantxUnidad;
    private String estado;
    private String fecha;
    public int idproductobodega;
    private String[][] listaBodega;
    public List<InfomacionLote> listaLote;
    private String[][] listaTipoMovimiento;
    private DefaultTableModel modelo;
    public claseInventario claseInv;
    private List<ISuministroxbodega> suministroxbodega;
    private IISuministroxbodegaService suministroxbodegaService;
    public JFormattedTextField JTFFIVa;
    public JFormattedTextField JTFFTotal;
    private JButton btnBuscarProducto;
    private JButton btnCargar;
    private JButton btnCargarEntrada;
    private JButton btnCargarEntrada1;
    private ButtonGroup buttonGroup1;
    public JComboBox cboBodega;
    public JComboBox cboLote;
    public JComboBox cboTipoMovimiento;
    public JTable grid;
    private JScrollPane jScrollPane1;
    private JPanel panelCantidades;
    private JPanel panelDatosSalida;
    private JPanel panelLote;
    private JPanel panelProducto;
    private JSpinner txtCantTrasladar;
    public JTextField txtCodigo;
    public JTextField txtEntrada;
    private JFormattedTextField txtExistencia;
    public JFormattedTextField txtExistenciaInventario;
    public JDateChooser txtFecha;
    public JTextField txtProducto;
    public JFormattedTextField txtValorTotal;
    public JFormattedTextField txtValorUnidad;
    private JFormattedTextField txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private int grabada = 0;
    public int cboLlenoLote = 0;
    private long xidentrada = 0;
    private String IdTraslado = "0";
    private String xidproveedor = "0";
    private String xidnfactura = "0";
    private String xidordencompra = "";
    private String xncajas = "0";
    private String xidtranpostadora = "0";
    private String xauxiliar_conteo = "";
    private String xobservacion = "";

    public ITraslados(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        this.tipoBodegaOrigen = this.claseInv.getTipoBodega();
        crearGrid();
        setTitle("Traslado de Productos y Suministros de : " + this.claseInv.getNbreBodega().toUpperCase());
        cargarCombos();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.ITraslados.1
            public void mouseClicked(MouseEvent e) {
                ITraslados.this.filaGrid = ITraslados.this.grid.rowAtPoint(e.getPoint());
            }
        });
        nuevo();
    }

    public String getIdProducto() {
        return this.idProducto;
    }

    public void setcantUnidad(String can) {
        this.cantxUnidad = can;
    }

    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    public void anular() {
        if (this.IdTraslado == null || this.IdTraslado.equals("")) {
            this.metodos.mostrarMensaje("Por Favor Escoja un Número de Traslado a Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("El Traslado ya se encuentra Anulado.");
        } else {
            Anular frm = new Anular(null, true, "ITraslados", 4);
            frm.setVisible(true);
        }
    }

    private void anularEntradaBodegaDestino(String idRazon) {
        this.sql = "UPDATE i_entradas SET  Estado = '" + idRazon + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id  = '" + this.txtEntrada.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void anularRegistroraslado(String idRazon) {
        this.sql = "UPDATE i_salidas SET  Estado = '" + idRazon + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + this.IdTraslado + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void anularTraslado(String idRazon) {
        this.metodos.marcarEstado(1);
        anularRegistroraslado(idRazon);
        anularEntradaBodegaDestino(idRazon);
        deshacerEntrada();
        deshacerSalida();
        this.metodos.mostrarMensaje("Traslado Anulado");
    }

    private void actualizarSxLxBDestino(int fila, String id) {
        this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = Cantidad +" + getCantidadDestino(fila) + " WHERE Id='" + id + "' AND Lote='" + this.modelo.getValueAt(fila, 3).toString() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void ActualizarSuministroxBodegaAnular() throws SQLException {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.sql = "SELECT Id FROM i_suministroxbodega WHERE (IdBodega = '" + this.claseInv.getIdBodega() + "') AND (IdSuministro = '" + this.modelo.getValueAt(i, 0) + "')";
            this.idLote = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + '" + Integer.parseInt(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + this.idLote + "' AND Lote = '" + this.modelo.getValueAt(i, 3).toString() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "SELECT Id FROM i_suministroxbodega WHERE (IdBodega = '" + this.bodegaDestino + "') AND (IdSuministro = '" + this.modelo.getValueAt(i, 0) + "')";
            this.idLote = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + '" + Integer.parseInt(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + this.idLote + "' AND Lote = '" + this.modelo.getValueAt(i, 3).toString() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void actualizarCostoProducto(int fila, String id) {
        this.sql = "UPDATE i_suministroxbodega SET Costo='" + getCostoDestino(fila) + "' WHERE Id='" + id + "' AND IdBodega='" + this.claseInv.getIdBodega() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void actualizarCostoPromedio(int fila, String id, double cantidad, double costo) {
        double valorO = this.metodos.redondear(costo, 0);
        double valorD = getCostoDestino(fila).doubleValue();
        double cantO = this.metodos.redondear(cantidad, 0);
        double cantD = getCantidadDestino(fila);
        this.sql = "UPDATE i_suministroxbodega SET Costo =(ROUND(" + (((valorO * cantO) + (valorD * cantD)) / (cantO + cantD)) + ")) WHERE Id='" + id + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void buscarTraslados() {
        BuscarTraslado frm = new BuscarTraslado(null, true, this.claseInv);
        frm.setVisible(true);
        this.grabada = 1;
    }

    public void buscarProducto(int op) {
        if (op == 1) {
            new ArrayList();
            List<IInformacionInventario> informacionInventarios = this.claseInv.listInventarioGeneral(this.metodos.getFechaActual(), this.claseInv.getListaIdBodega(), 0, 1, this.txtCodigo.getText(), "");
            if (!informacionInventarios.isEmpty()) {
                this.idProducto = informacionInventarios.get(0).getIdSuministro().toString();
                this.txtProducto.setText(informacionInventarios.get(0).getNombreSuministro() + " " + informacionInventarios.get(0).getNombrePresentacionComercial() + " " + informacionInventarios.get(0).getNombreLaboratorio());
                this.txtValorUnidad.setValue(informacionInventarios.get(0).getValorUnitario());
                this.txtExistenciaInventario.setValue(informacionInventarios.get(0).getCantidadTotal());
                this.txtValorUnidad.setValue(informacionInventarios.get(0).getValorUnitario());
                this.JTFFIVa.setValue(informacionInventarios.get(0).getIva());
                this.txtValorTotal.setValue(Double.valueOf(informacionInventarios.get(0).getValorUnitario().doubleValue() * Double.parseDouble(this.txtCantTrasladar.getValue().toString())));
                this.idproductobodega = Integer.valueOf(informacionInventarios.get(0).getIdSUministroBodega().toString()).intValue();
                this.cantxUnidad = informacionInventarios.get(0).getCantidadUnidad().toString();
                cargarLote(informacionInventarios);
                mVerificarFVencimientoInvima(informacionInventarios.get(0).getContolVencimiento().intValue(), informacionInventarios.get(0).getFechaVencimientoInvima());
                return;
            }
            limpiarDatosProductos();
            return;
        }
        BuscarProducto frm = new BuscarProducto(null, true, this, this.claseInv.getIdBodega(), this.claseInv, 1);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
    }

    private void mVerificarFVencimientoInvima(int xt, String xfecha) {
        if (xt == 0) {
            JOptionPane.showInternalMessageDialog(this, "Medicamento con fecha: " + xfecha + " de invima vencido.\nFavor revisar", "VERIFICACIÓN VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void cargarLote(List<IInformacionInventario> informacionInventarios) {
        this.cboLlenoLote = 0;
        this.listaLote = this.claseInv.cargarLote(this.cboLote, this.listaLote, informacionInventarios);
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtExistencia.setValue(0);
        this.txtCantTrasladar.setValue(1);
        this.cboLlenoLote = 1;
    }

    private void cargarDatosDelLote() {
        double cant = this.listaLote.get(this.cboLote.getSelectedIndex()).getCantidad().doubleValue();
        this.txtValorUnidad.setValue(this.listaLote.get(this.cboLote.getSelectedIndex()).getValor());
        int i = 0;
        while (true) {
            if (i >= this.modelo.getRowCount()) {
                break;
            }
            if (!this.modelo.getValueAt(i, 1).equals(this.txtCodigo.getText()) || !this.modelo.getValueAt(i, 3).equals(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote())) {
                i++;
            } else {
                cant -= Double.parseDouble(this.modelo.getValueAt(i, 6).toString());
                if (this.listaLote.get(this.cboLote.getSelectedIndex()).getCantidad().doubleValue() < 1.0d) {
                    this.listaLote.get(this.cboLote.getSelectedIndex()).setCantidad(new Double(0.0d));
                }
            }
        }
        this.txtVencimiento.setText(this.listaLote.get(this.cboLote.getSelectedIndex()).getFechaVencimiento());
        this.txtExistencia.setValue(Double.valueOf(cant));
    }

    private void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarComboyLista("SELECT Id, Nbre, Traslado FROM i_tiposmovimientos WHERE (Traslado = 1 AND TipoMovimiento = 1 AND Bodega ='" + this.claseInv.getIdBodega() + "' and Estado=0) ORDER BY Nbre ASC", this.listaTipoMovimiento, this.cboTipoMovimiento, 2);
        this.consultas.cerrarConexionBd();
        this.listaBodega = this.consultas.llenarComboyLista("SELECT Id, Nbre, UnidadEmpaque FROM i_bodegas WHERE Id <> '" + this.claseInv.getIdBodega() + "' AND Estado=0 ORDER BY Nbre", this.listaBodega, this.cboBodega, 3);
        this.consultas.cerrarConexionBd();
        JTextComponent editor = this.cboTipoMovimiento.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboTipoMovimiento));
        JTextComponent editor2 = this.cboBodega.getEditor().getEditorComponent();
        editor2.setDocument(new Autocomplete(this.cboBodega));
        JTextComponent editor3 = this.cboLote.getEditor().getEditorComponent();
        editor3.setDocument(new Autocomplete(this.cboLote));
        this.cboLleno = 1;
    }

    public void cargarTraslado() {
        this.IdTraslado = Principal.txtNo.getText();
        this.estado = Principal.txtEstado.getText();
        this.fecha = Principal.txtFecha.getText();
        this.sql = "SELECT i_detallesalida.IdSalida, i_detallesalida.IdSuministro, i_suministro.CodBarraUnidad, i_suministro.Nbre as Producto, i_presentacioncomercial.Nbre as Presentacion, i_detallesalida.Lote, i_detallesalida.FechaVencimiento as Vencimiento, i_detallesalida.CantidadSolicitada as Solicitada, i_detallesalida.CantidadDespachada as Despachada, i_detallesalida.ValorUnitario as VrUnidad FROM i_presentacioncomercial INNER JOIN i_suministro ON i_presentacioncomercial.Id = i_suministro.IdPresentacionComercial INNER JOIN i_detallesalida ON i_suministro.Id = i_detallesalida.IdSuministro WHERE (i_detallesalida.IdSalida = '" + this.IdTraslado + "')ORDER BY i_suministro.Nbre";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString("IdSalida"), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString("IdSuministro"), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Producto") + " - " + rs.getString("Presentacion"), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString("Lote"), this.filaGrid, 3);
                this.modelo.setValueAt(this.metodos.formatoAMD.format((Date) rs.getDate("Vencimiento")), this.filaGrid, 4);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt("Solicitada")), this.filaGrid, 5);
                this.modelo.setValueAt(Double.valueOf(rs.getDouble("Despachada")), this.filaGrid, 6);
                this.modelo.setValueAt(Double.valueOf(rs.getDouble("VrUnidad")), this.filaGrid, 7);
                this.modelo.setValueAt(Double.valueOf(((double) rs.getInt("Despachada")) * rs.getDouble("VrUnidad")), this.filaGrid, 8);
                this.modelo.setValueAt(0, this.filaGrid, 9);
                this.modelo.setValueAt(0, this.filaGrid, 10);
                this.modelo.setValueAt(0, this.filaGrid, 11);
                this.modelo.setValueAt(0, this.filaGrid, 12);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        mTotalizarTraslado();
    }

    private void cargarGrid() {
        if (Double.parseDouble(this.txtCantTrasladar.getValue().toString()) > Double.parseDouble(this.txtExistenciaInventario.getText())) {
            this.metodos.mostrarMensaje("La Cantidad que Trasladará del Producto es mayor a la del Inventario\nSolo se podrá trasladar la Existencia del Producto");
            this.txtCantTrasladar.setValue(this.txtExistenciaInventario.getValue());
            this.txtCantTrasladar.requestFocus();
        } else if (Double.parseDouble(this.txtCantTrasladar.getValue().toString()) > Double.parseDouble(this.txtExistencia.getValue().toString())) {
            this.metodos.mostrarMensaje("La Cantidad que Trasladará es mayor a la del Lote en el Inventario\nSolo podrá trasladar la Existencia del Lote en el Inventario de la bodega de " + this.claseInv.getNbreBodega());
            this.txtCantTrasladar.setValue(this.txtExistencia.getValue());
            this.txtCantTrasladar.requestFocus();
        } else if (Integer.parseInt(this.idProducto) < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
        } else if (this.cboLote.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Lote");
            this.cboLote.requestFocus();
        } else {
            this.filaGrid = this.modelo.getRowCount();
            int encontrado = 0;
            double trasladara = 0.0d;
            int i = 0;
            while (true) {
                if (i < this.modelo.getRowCount()) {
                    if (!this.modelo.getValueAt(i, 1).equals(this.txtCodigo.getText()) || !this.modelo.getValueAt(i, 3).toString().equals(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote())) {
                        i++;
                    } else {
                        encontrado = 1;
                        trasladara = Double.parseDouble(this.modelo.getValueAt(i, 6).toString());
                        this.filaGrid = i;
                        Integer.parseInt(this.modelo.getValueAt(i, 5).toString());
                        break;
                    }
                } else {
                    break;
                }
            }
            if (encontrado == 0) {
                this.modelo.addRow(this.dato);
            }
            double trasladara2 = trasladara + Double.parseDouble(this.txtCantTrasladar.getValue().toString());
            this.modelo.setValueAt(this.idProducto, this.filaGrid, 0);
            this.modelo.setValueAt(this.txtCodigo.getText(), this.filaGrid, 1);
            this.modelo.setValueAt(this.txtProducto.getText(), this.filaGrid, 2);
            this.modelo.setValueAt(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote(), this.filaGrid, 3);
            this.modelo.setValueAt(this.txtVencimiento.getText(), this.filaGrid, 4);
            this.modelo.setValueAt(this.txtExistencia.getText(), this.filaGrid, 5);
            this.modelo.setValueAt(Double.valueOf(trasladara2), this.filaGrid, 6);
            this.modelo.setValueAt(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)), this.filaGrid, 7);
            this.modelo.setValueAt(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2) * trasladara2), this.filaGrid, 8);
            this.modelo.setValueAt(this.cantxUnidad, this.filaGrid, 9);
            this.modelo.setValueAt(this.listaLote.get(this.cboLote.getSelectedIndex()).getIdSumnistroBodega(), this.filaGrid, 10);
            this.modelo.setValueAt(Integer.valueOf(this.idproductobodega), this.filaGrid, 11);
            this.modelo.setValueAt(0, this.filaGrid, 12);
            limpiarDatosProductos();
            this.filaGrid++;
        }
        mTotalizarTraslado();
        this.txtCodigo.requestFocus();
    }

    private void crearLoteFaltante(String id) {
        this.sql = "INSERT IGNORE INTO i_suministroxlotexbodega(Id, Lote, FechaVencimiento, Cantidad) VALUES ('" + id + "','FALTANTE','2100/12/31','0')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private String crearSxBDestino(int fila) {
        this.sql = "INSERT IGNORE INTO i_suministroxbodega(IdBodega, IdSuministro, Costo) VALUES ('";
        if (this.tipoBodegaOrigen == 1 && this.tipoBodegaDestino == 0) {
            double valor = this.metodos.redondear(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()) / Double.parseDouble(this.modelo.getValueAt(fila, 9).toString()), 2);
            this.sql += this.listaBodega[this.cboBodega.getSelectedIndex()].toString() + "','" + this.modelo.getValueAt(fila, 0).toString() + "','" + valor + "')";
        } else if (this.tipoBodegaOrigen == 0 && this.tipoBodegaDestino == 1) {
            double valor2 = this.metodos.redondear(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()) * Double.parseDouble(this.modelo.getValueAt(fila, 9).toString()), 2);
            this.sql += this.listaBodega[this.cboBodega.getSelectedIndex()] + "','" + this.modelo.getValueAt(fila, 0) + "','" + valor2 + "')";
        } else {
            this.sql += this.listaBodega[this.cboBodega.getSelectedIndex()] + "','" + this.modelo.getValueAt(fila, 0) + "','" + this.modelo.getValueAt(fila, 7) + "')";
        }
        String id = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        return id;
    }

    private void crearSxLxBDestino(String id, int fila) {
        this.sql = "INSERT INTO i_suministroxlotexbodega(Id, Lote, FechaVencimiento, Cantidad) VALUES('" + id + "','" + this.modelo.getValueAt(fila, 3) + "','" + this.modelo.getValueAt(fila, 4) + "','" + getCantidadDestino(fila) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void deshacerSalida() {
        this.sql = "SELECT i_suministroxbodega.Id, i_detallesalida.Lote, i_detallesalida.CantidadDespachada FROM  i_detallesalida INNER JOIN i_suministroxbodega ON (i_detallesalida.IdSuministro = i_suministroxbodega.IdSuministro) WHERE (i_detallesalida.IdSalida ='" + this.IdTraslado + " ' AND i_suministroxbodega.IdBodega ='" + this.claseInv.getIdBodega() + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                sumarCantidadesSalidas(rs.getString(3), rs.getString(1), rs.getString(2));
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.consultas.cerrarConexionBd();
    }

    private void deshacerEntrada() {
        this.sql = "SELECT i_suministroxbodega.Id, i_detalleentrada.Lote, i_detalleentrada.Cantidad FROM i_detalleentrada INNER JOIN i_suministroxbodega ON (i_detalleentrada.IdSuministro = i_suministroxbodega.IdSuministro) WHERE (i_detalleentrada.IdEntrada ='" + this.txtEntrada.getText() + "' AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                restarCantidadesEntradas(rs.getString(3), rs.getString(1), rs.getString(2));
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.consultas.cerrarConexionBd();
    }

    private void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar El Producto?") == 0) {
            this.modelo.removeRow(this.filaGrid);
        }
    }

    private double getCantidadDestino(int fila) {
        double cant;
        if (this.tipoBodegaOrigen == 1 && this.tipoBodegaDestino == 0) {
            cant = Double.valueOf(this.modelo.getValueAt(fila, 6).toString()).doubleValue() * Double.valueOf(this.modelo.getValueAt(fila, 9).toString()).doubleValue();
        } else if (this.tipoBodegaOrigen == 0 && this.tipoBodegaDestino == 1) {
            cant = Double.valueOf(this.modelo.getValueAt(fila, 6).toString()).doubleValue() / Double.valueOf(this.modelo.getValueAt(fila, 9).toString()).doubleValue();
        } else {
            cant = Double.valueOf(this.modelo.getValueAt(fila, 6).toString()).doubleValue();
        }
        return cant;
    }

    private double getValorDestino(int fila) {
        double xvalor;
        if (this.tipoBodegaOrigen == 1 && this.tipoBodegaDestino == 0) {
            xvalor = Double.valueOf(this.modelo.getValueAt(fila, 7).toString()).doubleValue() / ((double) Integer.parseInt(this.modelo.getValueAt(fila, 9).toString()));
        } else if (this.tipoBodegaOrigen == 0 && this.tipoBodegaDestino == 1) {
            xvalor = Double.valueOf(this.modelo.getValueAt(fila, 7).toString()).doubleValue() * ((double) Integer.parseInt(this.modelo.getValueAt(fila, 9).toString()));
        } else {
            xvalor = Double.valueOf(this.modelo.getValueAt(fila, 7).toString()).doubleValue();
        }
        return xvalor;
    }

    private double getCantidadOrigen(int fila) {
        double cant = Double.parseDouble(this.modelo.getValueAt(fila, 6).toString());
        return cant;
    }

    public Double getCostoDestino(int fila) {
        Double valor;
        if (this.tipoBodegaOrigen == 1 && this.tipoBodegaDestino == 0) {
            valor = Double.valueOf(this.metodos.redondear(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()) / Double.parseDouble(this.modelo.getValueAt(fila, 9).toString()), 2));
        } else if (this.tipoBodegaOrigen == 0 && this.tipoBodegaDestino == 1) {
            valor = Double.valueOf(this.metodos.redondear(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()) * Double.parseDouble(this.modelo.getValueAt(fila, 9).toString()), 2));
        } else {
            valor = Double.valueOf(this.metodos.redondear(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()), 2));
        }
        return valor;
    }

    public Double getCostoOrigen(int fila) {
        Double costo = Double.valueOf(Double.parseDouble(this.modelo.getValueAt(fila, 7).toString()));
        return costo;
    }

    private String getLote(String id, int fila) {
        this.sql = "SELECT Id FROM i_suministroxlotexbodega WHERE (Id ='" + id + "' AND Lote='" + this.modelo.getValueAt(fila, 3) + "')";
        String resultado = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (resultado.equals("") || resultado == null || resultado.isEmpty()) {
            resultado = "0";
        }
        return resultado;
    }

    private void descargarBodegaOrigen(int fila) {
        this.sql = "SELECT Id FROM i_suministroxbodega WHERE (IdBodega = '" + this.claseInv.getIdBodega() + "') AND (IdSuministro = '" + this.modelo.getValueAt(fila, 0) + "')";
        String idlote = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE i_suministroxlotexbodega SET  Cantidad = (Cantidad - " + getCantidadOrigen(fila) + ") WHERE Id = '" + idlote + "' AND Lote = '" + this.modelo.getValueAt(fila, 3) + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarCabeceraEntrada() {
        this.sql = "INSERT INTO i_entradas(FechaEntrada, Id_Periodo, NoFactura, IdProveedor, NOrdenCompra, IdTipoMovimiento, IdBodega, TipoPago, Transladada, Fecha, UsuarioS) VALUES ('" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.claseInv.getXidperiodoc() + "','" + this.xidnfactura + "','" + this.xidproveedor + "','" + this.xidordencompra + "','" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][0] + "','" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "','0','1','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.txtEntrada.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalleEntrada(int fila) {
        this.sql = "INSERT INTO i_detalleentrada(IdEntrada, IdSuministro, Lote, FechaVencimiento, Cantidad, ValorUnitario, Iva) VALUES ('" + this.txtEntrada.getText() + "','" + this.modelo.getValueAt(fila, 0) + "','" + this.modelo.getValueAt(fila, 3) + "','" + this.modelo.getValueAt(fila, 4) + "','" + getCantidadDestino(fila) + "','" + getValorDestino(fila) + "','" + this.modelo.getValueAt(fila, 12) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarBodegaDestino(int fila) {
        this.sql = "SELECT i_suministroxbodega.Id, ROUND(i_suministroxbodega.Costo) FROM i_suministroxbodega WHERE (i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' AND i_suministroxbodega.IdSuministro ='" + this.modelo.getValueAt(fila, 0) + "')";
        ResultSet rsb = this.consultas.traerRs(this.sql);
        try {
            if (rsb.next()) {
                if (!rsb.getString(1).isEmpty() || rsb.getString(1) != null) {
                    if (rsb.getDouble(2) < 1.0d) {
                        actualizarCostoProducto(fila, rsb.getString(1));
                    } else {
                        this.sql = "SELECT Cantidad FROM i_suministroxlotexbodega WHERE (Id ='" + rsb.getString(1) + "' AND Lote ='" + this.modelo.getValueAt(fila, 3) + "')";
                        String can = this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        if (can.isEmpty() || can == null) {
                            can = "0";
                        }
                        actualizarCostoPromedio(fila, rsb.getString(1), Double.parseDouble(can), rsb.getDouble(2));
                    }
                    if (getLote(rsb.getString(1), fila).equals("0")) {
                        crearSxLxBDestino(rsb.getString(1), fila);
                        crearLoteFaltante(rsb.getString(1));
                    } else {
                        actualizarSxLxBDestino(fila, rsb.getString(1));
                    }
                }
            } else {
                String id = crearSxBDestino(fila);
                crearSxLxBDestino(id, fila);
                crearLoteFaltante(id);
            }
            rsb.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void limpiarDatosProductos() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtCantTrasladar.setValue(1);
        this.txtCantTrasladar.setValue(1);
        this.txtValorUnidad.setValue(0);
        this.txtValorTotal.setValue(0);
        this.txtExistencia.setValue(0);
        this.txtExistenciaInventario.setValue(0);
    }

    public void limpiarGrid() {
        int fila = this.modelo.getRowCount();
        if (fila >= 0) {
            for (int i = 1; i <= fila; i++) {
                this.modelo.removeRow(0);
            }
        }
    }

    public void nuevo() {
        limpiarDatosProductos();
        limpiarGrid();
        this.metodos.limpiarDatosPrincipal();
        this.grabada = 0;
        this.filaGrid = 0;
        this.IdTraslado = "";
        this.xidentrada = 0L;
        this.xidordencompra = "0";
        this.xncajas = "0";
        this.xidtranpostadora = "0";
        this.xauxiliar_conteo = "";
        this.xobservacion = "";
        this.txtEntrada.setText("");
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.cboBodega.setSelectedIndex(-1);
        this.JTFFTotal.setValue(new Double(0.0d));
        this.cboTipoMovimiento.requestFocus();
    }

    public void restarCantidadesEntradas(String cant, String id, String lote) {
        this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad - " + cant + ") WHERE Id = '" + id + "' AND Lote = '" + lote + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void sumarCantidadesSalidas(String cant, String Id, String lote) {
        this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + " + cant + ") WHERE Id = '" + Id + "' AND Lote = '" + lote + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void setTipoBodegaDestino() {
        this.sql = "SELECT Principal FROM i_bodegas WHERE Id = '" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "'";
        this.tipoBodegaDestino = Integer.parseInt(this.consultas.traerDato(this.sql));
        this.consultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.panelDatosSalida = new JPanel();
        this.txtFecha = new JDateChooser();
        this.cboTipoMovimiento = new JComboBox();
        this.btnCargarEntrada = new JButton();
        this.txtEntrada = new JTextField();
        this.cboBodega = new JComboBox();
        this.btnCargarEntrada1 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.panelProducto = new JPanel();
        this.txtCodigo = new JTextField();
        this.btnCargar = new JButton();
        this.panelLote = new JPanel();
        this.cboLote = new JComboBox();
        this.txtExistencia = new JFormattedTextField();
        this.txtVencimiento = new JFormattedTextField();
        this.JTFFIVa = new JFormattedTextField();
        this.txtExistenciaInventario = new JFormattedTextField();
        this.panelCantidades = new JPanel();
        this.txtCantTrasladar = new JSpinner();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.txtProducto = new JTextField();
        this.btnBuscarProducto = new JButton();
        this.JTFFTotal = new JFormattedTextField();
        setBackground(new Color(211, 240, 235));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TRASLADO DE PRODUCTOS Y/O DISPOSITIVOS MEDICOS ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("ITraslados");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.ITraslados.2
            public void internalFrameActivated(InternalFrameEvent evt) {
                ITraslados.this.formInternalFrameActivated(evt);
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
        this.panelDatosSalida.setBackground(new Color(211, 240, 235));
        this.panelDatosSalida.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DATO DE TRASLADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.3
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.btnCargarEntrada.setFont(new Font("Arial", 1, 12));
        this.btnCargarEntrada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.btnCargarEntrada.setText("<html><P ALIGN=center>Cargar Entrada");
        this.btnCargarEntrada.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.4
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.btnCargarEntradaActionPerformed(evt);
            }
        });
        this.txtEntrada.setBackground(new Color(0, 204, 204));
        this.txtEntrada.setFont(new Font("Arial", 1, 24));
        this.txtEntrada.setHorizontalAlignment(4);
        this.txtEntrada.setText("0");
        this.txtEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Entrada", 0, 0, new Font("Tahoma", 1, 12), new Color(255, 255, 204)));
        this.txtEntrada.setDisabledTextColor(new Color(0, 0, 153));
        this.txtEntrada.setEnabled(false);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega de Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboBodega.addItemListener(new ItemListener() { // from class: Inventarios.ITraslados.5
            public void itemStateChanged(ItemEvent evt) {
                ITraslados.this.cboBodegaItemStateChanged(evt);
            }
        });
        this.cboBodega.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.6
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.cboBodegaActionPerformed(evt);
            }
        });
        this.btnCargarEntrada1.setFont(new Font("Arial", 1, 12));
        this.btnCargarEntrada1.setForeground(Color.blue);
        this.btnCargarEntrada1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnCargarEntrada1.setText(" Cargar Solicitudes Internas");
        this.btnCargarEntrada1.setHorizontalTextPosition(0);
        this.btnCargarEntrada1.setVerticalTextPosition(3);
        this.btnCargarEntrada1.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.7
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.btnCargarEntrada1ActionPerformed(evt);
            }
        });
        GroupLayout panelDatosSalidaLayout = new GroupLayout(this.panelDatosSalida);
        this.panelDatosSalida.setLayout(panelDatosSalidaLayout);
        panelDatosSalidaLayout.setHorizontalGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.btnCargarEntrada, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargarEntrada1, -2, 154, -2).addGap(5, 5, 5).addComponent(this.txtFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboTipoMovimiento, -2, 330, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboBodega, -2, 286, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtEntrada, -2, 117, -2).addContainerGap(-1, 32767)));
        panelDatosSalidaLayout.setVerticalGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelDatosSalidaLayout.createSequentialGroup().addContainerGap().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtEntrada, -2, 50, -2).addComponent(this.cboBodega, -2, 50, -2).addComponent(this.cboTipoMovimiento, -2, 50, -2))).addGroup(panelDatosSalidaLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCargarEntrada1, -2, 60, -2).addComponent(this.btnCargarEntrada, -2, 60, -2)))).addGroup(panelDatosSalidaLayout.createSequentialGroup().addContainerGap().addComponent(this.txtFecha, -2, 50, -2))).addGap(20, 20, 20)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setGridColor(new Color(0, 51, 51));
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.ITraslados.8
            public void keyPressed(KeyEvent evt) {
                ITraslados.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.panelProducto.setBackground(new Color(211, 240, 235));
        this.panelProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN PRODUCTO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.ITraslados.9
            public void focusGained(FocusEvent evt) {
                ITraslados.this.txtCodigoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                ITraslados.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.10
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.txtCodigoActionPerformed(evt);
            }
        });
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.11
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.btnCargarActionPerformed(evt);
            }
        });
        this.panelLote.setBackground(new Color(211, 240, 235));
        this.panelLote.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "Lote", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 102, 102)));
        this.cboLote.setEditable(true);
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.12
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.cboLoteActionPerformed(evt);
            }
        });
        this.txtExistencia.setEditable(false);
        this.txtExistencia.setBackground(new Color(0, 204, 204));
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtExistencia.setForeground(new Color(255, 255, 255));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(0, 0, 0));
        this.txtExistencia.setEnabled(false);
        this.txtExistencia.setFocusable(false);
        this.txtExistencia.setFont(new Font("Arial", 1, 12));
        this.txtExistencia.setValue(new Integer(0));
        this.txtVencimiento.setEditable(false);
        this.txtVencimiento.setBackground(new Color(0, 204, 204));
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vencimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtVencimiento.setForeground(new Color(255, 255, 255));
        this.txtVencimiento.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        this.txtVencimiento.setHorizontalAlignment(0);
        this.txtVencimiento.setDisabledTextColor(new Color(0, 0, 0));
        this.txtVencimiento.setEnabled(false);
        this.txtVencimiento.setFocusable(false);
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        this.JTFFIVa.setEditable(false);
        this.JTFFIVa.setBackground(new Color(0, 204, 204));
        this.JTFFIVa.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIVa.setForeground(new Color(255, 255, 255));
        this.JTFFIVa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFIVa.setHorizontalAlignment(4);
        this.JTFFIVa.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFFIVa.setEnabled(false);
        this.JTFFIVa.setFocusable(false);
        this.JTFFIVa.setFont(new Font("Arial", 1, 12));
        this.JTFFIVa.setValue(new Integer(0));
        GroupLayout panelLoteLayout = new GroupLayout(this.panelLote);
        this.panelLote.setLayout(panelLoteLayout);
        panelLoteLayout.setHorizontalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addContainerGap().addComponent(this.cboLote, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFIVa, -2, 80, -2).addGap(10, 10, 10).addComponent(this.txtExistencia, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVencimiento, -2, 134, -2).addContainerGap(-1, 32767)));
        panelLoteLayout.setVerticalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboLote, -2, 50, -2).addComponent(this.JTFFIVa, -2, 50, -2).addComponent(this.txtExistencia, -2, 50, -2).addComponent(this.txtVencimiento, -2, 50, -2)).addGap(0, 0, 32767)));
        this.txtExistenciaInventario.setEditable(false);
        this.txtExistenciaInventario.setBackground(new Color(0, 204, 204));
        this.txtExistenciaInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtExistenciaInventario.setForeground(new Color(255, 255, 255));
        this.txtExistenciaInventario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtExistenciaInventario.setHorizontalAlignment(4);
        this.txtExistenciaInventario.setDisabledTextColor(new Color(0, 0, 0));
        this.txtExistenciaInventario.setEnabled(false);
        this.txtExistenciaInventario.setFocusable(false);
        this.txtExistenciaInventario.setFont(new Font("Arial", 1, 12));
        this.panelCantidades.setBackground(new Color(211, 240, 235));
        this.panelCantidades.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "Valores", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 102, 102)));
        this.txtCantTrasladar.setFont(new Font("Arial", 1, 12));
        this.txtCantTrasladar.setModel(new SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(1.0d), (Comparable) null, Double.valueOf(0.10000000000000009d)));
        this.txtCantTrasladar.setToolTipText("Cantidad del Producto que entra");
        this.txtCantTrasladar.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantTrasladar.addChangeListener(new ChangeListener() { // from class: Inventarios.ITraslados.13
            public void stateChanged(ChangeEvent evt) {
                ITraslados.this.txtCantTrasladarStateChanged(evt);
            }
        });
        this.txtValorUnidad.setBackground(new Color(0, 204, 204));
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtValorUnidad.setForeground(new Color(255, 255, 255));
        this.txtValorUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.txtValorUnidad.setDisabledTextColor(new Color(0, 0, 0));
        this.txtValorUnidad.setEnabled(false);
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.txtValorUnidad.setValue(new Double(0.0d));
        this.txtValorTotal.setBackground(new Color(0, 204, 204));
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorTotal.setForeground(new Color(255, 255, 255));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setDisabledTextColor(new Color(0, 0, 0));
        this.txtValorTotal.setEnabled(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 12));
        this.txtValorTotal.setValue(new Double(0.0d));
        GroupLayout panelCantidadesLayout = new GroupLayout(this.panelCantidades);
        this.panelCantidades.setLayout(panelCantidadesLayout);
        panelCantidadesLayout.setHorizontalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelCantidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.txtCantTrasladar, -1, 82, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorUnidad, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtValorTotal, -2, 130, -2)));
        panelCantidadesLayout.setVerticalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCantidadesLayout.createSequentialGroup().addGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorUnidad, -2, 50, -2).addComponent(this.txtValorTotal, -2, 50, -2).addComponent(this.txtCantTrasladar)).addContainerGap(-1, 32767)));
        this.txtProducto.setBackground(new Color(0, 204, 204));
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setHorizontalAlignment(2);
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Insumo o Dispositivo Médico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProducto.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProducto.setEnabled(false);
        this.txtProducto.addMouseWheelListener(new MouseWheelListener() { // from class: Inventarios.ITraslados.14
            public void mouseWheelMoved(MouseWheelEvent evt) {
                ITraslados.this.txtProductoMouseWheelMoved(evt);
            }
        });
        this.txtProducto.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.15
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.txtProductoActionPerformed(evt);
            }
        });
        this.txtProducto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.ITraslados.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                ITraslados.this.txtProductoPropertyChange(evt);
            }
        });
        this.txtProducto.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.ITraslados.17
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                ITraslados.this.txtProductoVetoableChange(evt);
            }
        });
        this.btnBuscarProducto.setFont(new Font("Arial", 1, 12));
        this.btnBuscarProducto.setForeground(new Color(0, 0, 153));
        this.btnBuscarProducto.setText("...");
        this.btnBuscarProducto.addFocusListener(new FocusAdapter() { // from class: Inventarios.ITraslados.18
            public void focusLost(FocusEvent evt) {
                ITraslados.this.btnBuscarProductoFocusLost(evt);
            }
        });
        this.btnBuscarProducto.addActionListener(new ActionListener() { // from class: Inventarios.ITraslados.19
            public void actionPerformed(ActionEvent evt) {
                ITraslados.this.btnBuscarProductoActionPerformed(evt);
            }
        });
        GroupLayout panelProductoLayout = new GroupLayout(this.panelProducto);
        this.panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(panelProductoLayout.createSequentialGroup().addComponent(this.txtCodigo, -2, 222, -2).addGap(10, 10, 10).addComponent(this.txtProducto, -2, 710, -2).addGap(10, 10, 10).addComponent(this.btnBuscarProducto, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtExistenciaInventario, -2, 123, -2)).addGroup(panelProductoLayout.createSequentialGroup().addComponent(this.panelLote, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelCantidades, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargar, -1, -1, 32767))).addContainerGap()));
        panelProductoLayout.setVerticalGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtCodigo).addComponent(this.txtProducto).addComponent(this.txtExistenciaInventario).addComponent(this.btnBuscarProducto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelCantidades, -1, -1, 32767).addComponent(this.panelLote, -1, -1, 32767).addComponent(this.btnCargar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBackground(new Color(0, 204, 204));
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Tahoma", 1, 11), new Color(255, 255, 204)));
        this.JTFFTotal.setForeground(new Color(255, 255, 255));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setDisabledTextColor(new Color(0, 0, 153));
        this.JTFFTotal.setEnabled(false);
        this.JTFFTotal.setFocusable(false);
        this.JTFFTotal.setFont(new Font("Arial", 1, 16));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addComponent(this.panelProducto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.panelDatosSalida, -2, -1, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotal, -2, 218, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelDatosSalida, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelProducto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 348, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal, -2, -1, -2).addContainerGap(55, 32767)));
        getAccessibleContext().setAccessibleName("Traslado de Productos y Suministros");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantTrasladarStateChanged(ChangeEvent evt) {
        this.txtValorTotal.setValue(Double.valueOf(Double.parseDouble(this.txtCantTrasladar.getValue().toString()) * Double.parseDouble(this.txtValorUnidad.getValue().toString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
        if (this.cboLlenoLote == 1 && this.cboLote.getSelectedIndex() > -1) {
            cargarDatosDelLote();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        this.cboLote.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarEntradaActionPerformed(ActionEvent evt) {
        BuscarEntrada frm = new BuscarEntrada(null, true, this.claseInv, "ITraslados");
        frm.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoMouseWheelMoved(MouseWheelEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarProductoActionPerformed(ActionEvent evt) {
        buscarProducto(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarProductoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        buscarProducto(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboBodega.getSelectedIndex() > -1) {
            this.bodegaDestino = this.listaBodega[this.cboBodega.getSelectedIndex()][0];
            setTipoBodegaDestino();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal principal = this.claseInv.frmPrincipal;
        Menus menus = this.claseInv.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
        Principal.txtNo.setText(this.IdTraslado);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarEntrada1ActionPerformed(ActionEvent evt) {
        JDBusquedaSolicitudesInternas internas = new JDBusquedaSolicitudesInternas(null, true, getName());
        internas.setLocationRelativeTo(this);
        internas.setVisible(true);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Lote", "Vencimiento", "Existencia", "Trasladará", "Vr. Unidad", "Vr. Total", "Cant. Unidad", "Id Lote", "IdSuministroxBodega", "iva"}) { // from class: Inventarios.ITraslados.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Double.class, Integer.class, String.class, Integer.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(110);
    }

    public void cargarEntrada(String entrada) {
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_detalleentrada.Lote, i_detalleentrada.FechaVencimiento, i_detalleentrada.Cantidad, (((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+ i_detalleentrada.ValorUnitario) AS ValorUnitario, i_suministro.CantidadUnidad,  i_suministroxbodega.Id , i_detalleentrada.Iva, i_detalleentrada.ValorUnitario, `i_entradas`.`NoFactura`, `i_entradas`.`IdProveedor`, `i_entradas`.`NOrdenCompra`, `i_entradas`.`NCajas`, `i_entradas`.`Id_Transportadora`, `i_entradas`.`AuxiliarConteo`, `i_entradas`.`Observacion` FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)  INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  INNER JOIN i_detalleentrada ON (i_detalleentrada.IdSuministro = i_suministro.Id)    INNER JOIN i_entradas ON (i_detalleentrada.IdEntrada=i_entradas.Id)  INNER JOIN i_suministroxbodega ON (i_detalleentrada.IdSuministro=i_suministroxbodega.IdSuministro)  WHERE (i_detalleentrada.IdEntrada ='" + entrada + "' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "' AND i_entradas.Estado=0 ) ORDER BY i_suministro.Nbre ASC ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        limpiarGrid();
        this.filaGrid = 0;
        try {
            if (rs.next()) {
                rs.first();
                this.xidnfactura = rs.getString(14);
                this.xidproveedor = rs.getString(15);
                this.xidordencompra = rs.getString(16);
                this.xidentrada = Long.valueOf(entrada).longValue();
                this.xncajas = rs.getString("NCajas");
                this.xidtranpostadora = rs.getString("Id_Transportadora");
                this.xauxiliar_conteo = rs.getString("AuxiliarConteo");
                this.xobservacion = rs.getString("Observacion");
                rs.beforeFirst();
                while (rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString(6), this.filaGrid, 3);
                    this.modelo.setValueAt(rs.getString(7), this.filaGrid, 4);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(8)), this.filaGrid, 6);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(9)), this.filaGrid, 7);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(8) * rs.getDouble(9)), this.filaGrid, 8);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(10)), this.filaGrid, 9);
                    this.modelo.setValueAt(this.idLote, this.filaGrid, 10);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(11)), this.filaGrid, 11);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(12)), this.filaGrid, 12);
                    this.filaGrid++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            mTotalizarTraslado();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void grabar() {
        if (this.IdTraslado.isEmpty()) {
            if (this.cboTipoMovimiento.getSelectedIndex() != -1) {
                if (this.cboBodega.getSelectedIndex() != -1) {
                    if (this.claseInv.getXidperiodoc() != -1) {
                        if (this.claseInv.isXestadop()) {
                            if (!this.claseInv.mVerificarMovDPeriodo(this.txtFecha.getDate())) {
                                grabarCabeceraEntrada();
                                grabarCabeceraTraslado();
                                for (int i = 0; i < this.modelo.getRowCount(); i++) {
                                    this.sql = "INSERT INTO i_detallesalida(IdSalida, IdSuministro, Lote, CantidadSolicitada, CantidadDespachada, ValorUnitario, FechaVencimiento) VALUES ('" + Principal.txtNo.getText() + "','" + this.modelo.getValueAt(i, 0) + "','" + this.modelo.getValueAt(i, 3) + "','" + this.modelo.getValueAt(i, 6) + "','" + this.modelo.getValueAt(i, 6) + "','" + this.modelo.getValueAt(i, 7) + "','" + this.modelo.getValueAt(i, 4) + "')";
                                    this.consultas.ejecutarSQL(this.sql);
                                    this.consultas.cerrarConexionBd();
                                    this.sql = "INSERT INTO i_detalleentrada(IdEntrada, IdSuministro, Lote, FechaVencimiento, Cantidad, ValorUnitario, Iva) VALUES ('" + this.txtEntrada.getText() + "','" + this.modelo.getValueAt(i, 0) + "','" + this.modelo.getValueAt(i, 3) + "','" + this.modelo.getValueAt(i, 4) + "','" + getCantidadDestino(i) + "','" + getValorDestino(i) + "','" + this.modelo.getValueAt(i, 12) + "')";
                                    this.consultas.ejecutarSQL(this.sql);
                                    this.consultas.cerrarConexionBd();
                                    this.claseInv.mDescontarCantidadInventario(Integer.valueOf(this.modelo.getValueAt(i, 11).toString()).intValue(), Double.valueOf(this.modelo.getValueAt(i, 6).toString()), this.modelo.getValueAt(i, 3).toString(), "0", "0");
                                    String xidproducto = this.claseInv.mVerificarSiProductoenBodega(this.modelo.getValueAt(i, 0).toString(), this.listaBodega[this.cboBodega.getSelectedIndex()][0]);
                                    if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                        BodegaDTO bodegaDTO = new BodegaDTO();
                                        bodegaDTO.setId(Long.valueOf(this.claseInv.getIdBodega()));
                                        double valor = Double.valueOf(this.modelo.getValueAt(i, 7).toString()).doubleValue() / Double.valueOf(this.modelo.getValueAt(i, 9).toString()).doubleValue();
                                        this.claseInv.mActualizarValorPromedioPanzenu(Integer.valueOf(xidproducto).intValue(), Double.valueOf(this.modelo.getValueAt(i, 7).toString()).doubleValue(), 0.0d, Double.valueOf(this.modelo.getValueAt(i, 9).toString()).doubleValue());
                                        this.sql = "UPDATE i_suministroxbodega SET costo ='" + valor + "' WHERE IdBodega='" + bodegaDTO.getId() + "' AND IdSuministro='" + Integer.valueOf(this.modelo.getValueAt(i, 11).toString()) + "'";
                                        this.claseInv.mSumarCantidadInventario(Integer.valueOf(xidproducto).intValue(), Double.valueOf(this.modelo.getValueAt(i, 6).toString()), this.modelo.getValueAt(i, 3).toString(), this.modelo.getValueAt(i, 4).toString(), Double.valueOf(0.0d));
                                    } else {
                                        this.claseInv.mActualizarValorPromedio(Integer.valueOf(xidproducto).intValue(), Double.valueOf(this.modelo.getValueAt(i, 7).toString()).doubleValue(), 0.0d);
                                        this.claseInv.mSumarCantidadInventario(Integer.valueOf(xidproducto).intValue(), Double.valueOf(this.modelo.getValueAt(i, 6).toString()), this.modelo.getValueAt(i, 3).toString(), this.modelo.getValueAt(i, 4).toString(), Double.valueOf(0.0d));
                                    }
                                }
                                mCambiarEstadoEntrada();
                                this.claseInv.setxBodegaDestino(this.listaBodega[this.cboBodega.getSelectedIndex()][0]);
                                this.claseInv.imprimir("Traslados");
                                this.metodos.mostrarMensaje("Traslado Grabado.");
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "Validación", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.txtFecha.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "Validación", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No existen abierto, \nFavor revisar", "Validación", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la bodega de destino", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.cboBodega.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de movimiento", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboTipoMovimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Entrada ya grabada", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.claseInv.imprimir("Traslados");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Cargar Un Traslado", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void grabarCabeceraTraslado() {
        this.metodos = new Metodos();
        this.sql = "INSERT INTO i_salidas(IdTipoMovimiento, IdBodega, FechaSalida, Id_Periodo, Destino, IdDestino, Entrada, Fecha, UsuarioS) VALUES ('" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][0] + "','" + this.claseInv.getIdBodega() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.claseInv.getXidperiodoc() + "','" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "','" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "','" + this.txtEntrada.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.IdTraslado = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        Principal.txtNo.setText(this.IdTraslado);
        Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.txtFecha.getDate()));
        Principal.txtEstado.setText("ACTIVA");
    }

    private void grabarDetalleTraslado(int fila) {
        this.sql = "INSERT INTO i_detallesalida(IdSalida, IdSuministro, Lote, CantidadSolicitada, CantidadDespachada, ValorUnitario, FechaVencimiento) VALUES ('" + this.IdTraslado + "','" + this.modelo.getValueAt(fila, 0) + "','" + this.modelo.getValueAt(fila, 3) + "','" + this.modelo.getValueAt(fila, 6) + "','" + this.modelo.getValueAt(fila, 6) + "','" + this.modelo.getValueAt(fila, 7) + "','" + this.modelo.getValueAt(fila, 4) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void mCambiarEstadoEntrada() {
        String xsql = "Update i_entradas set Transladada=1 where Id='" + this.xidentrada + "'";
        this.consultas.ejecutarSQL(xsql);
        this.consultas.cerrarConexionBd();
    }

    private void mTotalizarTraslado() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            xvalor += Double.valueOf(this.modelo.getValueAt(x, 8).toString()).doubleValue();
        }
        this.JTFFTotal.setValue(Double.valueOf(xvalor));
    }
}
