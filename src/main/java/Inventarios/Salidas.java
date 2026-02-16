package Inventarios;

import Acceso.Menus;
import Acceso.Principal;
import General.Anular;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas;
import com.genoma.plus.dto.inventario.InfomacionLote;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoEntity;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.projection.ISuministroBodegaInventario;
import com.genoma.plus.jpa.service.IBodegaDAO;
import com.genoma.plus.jpa.service.ISolicitudPedidoInternoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
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

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Salidas.class */
public class Salidas extends JInternalFrame {
    private int IdSuministroxBodega;
    private Object[] dato;
    private int cboLleno;
    private String sql;
    private String IdDestino;
    private String cantxUnidad;
    private String[] listaTipoMovimiento;
    private String[] listaDestino;
    public List<InfomacionLote> listaLote;
    public String idProducto;
    public String idSalida;
    public String estado;
    public String fecha;
    private DefaultTableModel modelo;
    public claseInventario claseInv;
    private SolicitudPedidoInternoEntity pedidoInternoEntity;
    private Double cantidad;
    private Long idSuministroItems;
    public JLabel JLB_Registro;
    private JCheckBox btnBodega;
    private JButton btnBuscarProducto;
    private JCheckBox btnCC;
    private JButton btnCargar;
    private JButton btnCargarEntrada;
    private JButton btnCargarEntrada1;
    private JCheckBox btnProveedor;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    public JComboBox cboDestino;
    public JComboBox cboLote;
    public JComboBox cboTipoMovimiento;
    public JTable grid;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelCantidades;
    private JPanel panelDatosSalida;
    private JPanel panelLote;
    private JPanel panelProducto;
    private JSpinner txtCantSale;
    public JTextField txtCodigo;
    private JFormattedTextField txtExistencia;
    public JFormattedTextField txtExistenciaInventario;
    public JDateChooser txtFecha;
    public JTextArea txtObservaciones;
    public JTextField txtProducto;
    public JFormattedTextField txtTotalFactura;
    private JFormattedTextField txtValorTotal;
    public JFormattedTextField txtValorUnidad;
    private JFormattedTextField txtVencimiento;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int destino = 2;
    private int filaGrid = 0;
    public int grabada = 0;
    public int cboLlenoLote = 0;
    public int xidtipo = 0;
    private final ISolicitudPedidoInternoService pedidoInternoService = (ISolicitudPedidoInternoService) Principal.contexto.getBean(ISolicitudPedidoInternoService.class);
    private final IBodegaDAO bodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);

    public Salidas(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        cargarCombos();
        crearGrid();
        setTitle("SALIDA DE PRODUCTOS Y SUMINISTROS DE : " + this.claseInv.getNbreBodega().toUpperCase());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.Salidas.1
            public void mouseClicked(MouseEvent e) {
                Salidas.this.filaGrid = Salidas.this.grid.rowAtPoint(e.getPoint());
            }
        });
        nuevo();
    }

    public String getIdProducto() {
        return this.idProducto;
    }

    public String getIdSalida() {
        return this.idSalida;
    }

    public void setcantUnidad(String can) {
        this.cantxUnidad = can;
    }

    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    public void setIdSalida(String id) {
        this.idSalida = id;
    }

    public void anular() {
        if (this.JLB_Registro.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Salida para Anular");
        } else {
            if (Principal.txtEstado.getText().equals("ANULADA")) {
                this.metodos.mostrarMensaje("La Salida ya se encuentra Anulada.");
                return;
            }
            Anular frm = new Anular(null, true, "Salidas", 4);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
        }
    }

    public void anularSalida(String razon) {
        this.sql = "UPDATE i_salidas SET  Estado = '" + razon + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + getIdSalida() + "')";
        this.consultas.ejecutarSQL(this.sql);
        ActualizarSuministroxBodega();
        this.metodos.marcarEstado(0);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Salida Anulada");
    }

    public void ActualizarSuministroxBodega() {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.sql = "SELECT Id FROM i_suministroxBodega WHERE (IdBodega = '" + this.claseInv.getIdBodega() + "') AND (IdSuministro = '" + this.modelo.getValueAt(i, 0) + "')";
            String idSuministroxBodega = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxbodega SET Existencia = (Existencia + '" + this.modelo.getValueAt(i, 6).toString() + "') WHERE Id = '" + idSuministroxBodega + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxLotexbodega SET Cantidad = (Cantidad + '" + this.modelo.getValueAt(i, 6).toString() + "') WHERE Id = '" + idSuministroxBodega + "' AND Lote = '" + this.modelo.getValueAt(i, 3).toString() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    public void ActualizarSuministroxBodegaAnular() {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.sql = "SELECT Id FROM i_suministroxbodega WHERE (IdBodega = '" + this.claseInv.getIdBodega() + "') AND (IdSuministro = '" + this.modelo.getValueAt(i, 0) + "')";
            String idSuministroxBodega = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxbodega SET Existencia = (Existencia + '" + Double.parseDouble(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + idSuministroxBodega + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + '" + Double.parseDouble(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + idSuministroxBodega + "' AND Lote = '" + this.modelo.getValueAt(i, 3).toString() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxbodega SET Existencia = (Existencia + '" + Double.parseDouble(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + idSuministroxBodega + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxlotexbodega SET Cantidad = (Cantidad + '" + Double.parseDouble(this.modelo.getValueAt(i, 6).toString()) + "') WHERE Id = '" + idSuministroxBodega + "' AND Lote = '" + this.modelo.getValueAt(i, 3).toString() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
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
                this.txtValorTotal.setValue(Double.valueOf(informacionInventarios.get(0).getValorUnitario().doubleValue() * Double.parseDouble(this.txtCantSale.getValue().toString())));
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
            JOptionPane.showInternalMessageDialog(this, "Medicamento con fecha: " + xfecha + " de invima vencido.\nFavor revisar", "VERIFICIACIÓN DE VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void buscarSalidas() {
        BuscarSalida frm = new BuscarSalida(null, true, this.claseInv);
        frm.setVisible(true);
    }

    public void cargarEntrada(String id) {
        nuevo();
        Principal.txtEstado.setText("");
        Principal.txtFecha.setText("");
        Double vrTotal = Double.valueOf(0.0d);
        this.sql = "SELECT w_suministros.Id, w_suministros.CodBarraUnidad as Codigo, w_suministros.Producto, i_detalleentrada.Lote, i_detalleentrada.FechaVencimiento as Vencimiento, i_detalleentrada.Cantidad, i_detalleentrada.ValorUnitario, w_suministros.CantidadUnidad  FROM i_detalleentrada INNER JOIN w_suministros ON  (i_detalleentrada.IdSuministro = w_suministros.Id)  WHERE (i_detalleentrada.IdEntrada ='" + id + "') ORDER BY w_suministros.Producto ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    vrTotal = Double.valueOf(vrTotal.doubleValue() + (((double) rs.getInt(6)) * rs.getDouble(7)));
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString("Id"), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString("Codigo"), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString("Producto"), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString("Lote"), this.filaGrid, 3);
                    this.modelo.setValueAt(rs.getString("Vencimiento"), this.filaGrid, 4);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt("Cantidad")), this.filaGrid, 6);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble("ValorUnitario")), this.filaGrid, 7);
                    this.modelo.setValueAt(vrTotal, this.filaGrid, 8);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt("CantidadUnidad")), this.filaGrid, 9);
                    this.filaGrid++;
                }
            }
            this.txtTotalFactura.setValue(vrTotal);
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void cargarSalida() {
        this.sql = "SELECT `i_suministro`.`Id` , `i_suministro`.`CodBarraUnidad`  as Codigo, CONCAT(`i_suministro`.`Nbre` , ' ' ,`i_presentacioncomercial`.`Nbre`) AS `Producto` , `i_detallesalida`.`Lote` , `i_detallesalida`.`FechaVencimiento` as Vencimiento, `i_detallesalida`.`CantidadDespachada` as Despachada, `i_detallesalida`.`ValorUnitario`  as VrUnidad, `i_suministro`.`CantidadUnidad` , `i_salidas`.`TipoD` , `i_salidas`.`IdDestino` FROM `i_detallesalida` INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)  INNER JOIN  `i_tiposmovimientos`   ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) INNER JOIN  `i_suministro`  ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_presentacioncomercial`   ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) WHERE (`i_salidas`.`Id` ='" + this.JLB_Registro.getText() + "') ORDER BY `Producto` ASC ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        limpiarGrid();
        int fila = 0;
        this.txtTotalFactura.setValue(0);
        try {
            this.pedidoInternoEntity = this.pedidoInternoService.buscarPorIdSalida(Long.valueOf(this.JLB_Registro.getText()));
            rs.first();
            switch (rs.getInt("TipoD")) {
                case 0:
                    this.destino = 1;
                    this.xidtipo = 0;
                    this.btnBodega.setSelected(true);
                    break;
                case 1:
                    this.destino = 3;
                    this.xidtipo = 1;
                    this.btnCC.setSelected(true);
                    break;
                case 2:
                    this.destino = 2;
                    this.xidtipo = 2;
                    this.btnProveedor.setSelected(true);
                    break;
            }
            rs.beforeFirst();
            while (rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString("Id"), fila, 0);
                this.modelo.setValueAt(rs.getString("Codigo"), fila, 1);
                this.modelo.setValueAt(rs.getString("Producto"), fila, 2);
                this.modelo.setValueAt(rs.getString("Lote"), fila, 3);
                this.modelo.setValueAt(this.metodos.formatoAMD.format((Date) rs.getDate("Vencimiento")), fila, 4);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(7)), fila, 5);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt("Despachada")), fila, 6);
                this.modelo.setValueAt(Double.valueOf(rs.getDouble("VrUnidad")), fila, 7);
                this.modelo.setValueAt(Double.valueOf(((double) rs.getInt("Despachada")) * rs.getDouble("VrUnidad")), fila, 8);
                this.txtTotalFactura.setValue(Double.valueOf(Double.parseDouble(this.txtTotalFactura.getValue().toString()) + (((double) rs.getInt("Despachada")) * rs.getDouble("VrUnidad"))));
                fila++;
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiposmovimientos WHERE Estado = 0 AND TipoMovimiento = 1 AND Despacho<>1 AND Bodega='" + this.claseInv.getIdBodega() + "' ORDER BY Nbre ASC", this.listaTipoMovimiento, this.cboTipoMovimiento);
        JTextComponent editor = this.cboTipoMovimiento.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboTipoMovimiento));
        cargarComboDestino();
        this.consultas.cerrarConexionBd();
    }

    private void cargarComboDestino() {
        this.cboDestino.removeAllItems();
        switch (this.destino) {
            case 1:
                this.listaDestino = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE Estado = 0  AND Id <>'" + this.claseInv.getIdBodega() + "' ORDER BY Nbre ASC", this.listaDestino, this.cboDestino);
                this.consultas.cerrarConexionBd();
                break;
            case 2:
                this.listaDestino = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1 AND EsMInventario =1) ORDER BY Nbre ASC", this.listaDestino, this.cboDestino);
                this.consultas.cerrarConexionBd();
                break;
            default:
                if (this.claseInv.getNbreBodega().equals("ODONTOLOGIA")) {
                    this.listaDestino = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (Estado = 0 AND Odontologia=1) ORDER BY Nbre ASC", this.listaDestino, this.cboDestino);
                    this.consultas.cerrarConexionBd();
                } else {
                    this.listaDestino = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE Estado = 0 ORDER BY Nbre ASC", this.listaDestino, this.cboDestino);
                }
                this.consultas.cerrarConexionBd();
                break;
        }
        this.cboLleno = 1;
        JTextComponent editor = this.cboDestino.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboDestino));
        this.consultas.cerrarConexionBd();
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
        this.txtValorTotal.setValue(Double.valueOf(Double.parseDouble(this.txtCantSale.getValue().toString()) * Double.parseDouble(this.txtValorUnidad.getValue().toString())));
    }

    public void cargarGrid() {
        if (Double.parseDouble(this.txtCantSale.getValue().toString()) > Double.parseDouble(this.txtExistencia.getValue().toString())) {
            this.metodos.mostrarMensaje("La Cantidad que Sale no puede ser superior a la Existencia en el Lote");
            this.txtCantSale.setValue(Double.valueOf(this.txtExistencia.getValue().toString()));
        } else if (this.txtProducto.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
        } else if (this.cboLote.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Lote");
            this.cboLote.requestFocus();
        } else if (Double.parseDouble(this.txtExistencia.getValue().toString()) < Double.parseDouble(this.txtCantSale.getValue().toString())) {
            this.metodos.mostrarMensaje("No hay Existencia para este Producto");
        } else {
            this.filaGrid = this.modelo.getRowCount();
            int encontrado = 0;
            double Existencia = 0.0d;
            int i = 0;
            while (true) {
                if (i < this.modelo.getRowCount()) {
                    if (!this.modelo.getValueAt(i, 1).equals(this.txtCodigo.getText()) || !this.modelo.getValueAt(i, 3).toString().equals(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote())) {
                        i++;
                    } else {
                        encontrado = 1;
                        this.filaGrid = i;
                        Existencia = Double.parseDouble(this.modelo.getValueAt(i, 6).toString());
                        break;
                    }
                } else {
                    break;
                }
            }
            if (encontrado == 0) {
                this.modelo.addRow(this.dato);
            }
            double Existencia2 = Existencia + Double.parseDouble(this.txtCantSale.getValue().toString());
            this.modelo.setValueAt(this.idProducto, this.filaGrid, 0);
            this.modelo.setValueAt(this.txtCodigo.getText(), this.filaGrid, 1);
            this.modelo.setValueAt(this.txtProducto.getText(), this.filaGrid, 2);
            this.modelo.setValueAt(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote(), this.filaGrid, 3);
            this.modelo.setValueAt(this.txtVencimiento.getText(), this.filaGrid, 4);
            this.modelo.setValueAt(this.txtExistencia.getText(), this.filaGrid, 5);
            this.modelo.setValueAt(Double.valueOf(Existencia2), this.filaGrid, 6);
            this.modelo.setValueAt(Double.valueOf(Math.floor(Double.parseDouble(this.txtValorUnidad.getValue().toString()))), this.filaGrid, 7);
            this.modelo.setValueAt(Double.valueOf(Math.floor(Double.parseDouble(this.txtValorUnidad.getValue().toString()) * Double.parseDouble(this.txtCantSale.getValue().toString()))), this.filaGrid, 8);
            this.txtTotalFactura.setValue(Double.valueOf(Double.parseDouble(this.txtTotalFactura.getValue().toString()) + Double.parseDouble(this.txtValorTotal.getValue().toString())));
            this.modelo.setValueAt(this.cantxUnidad, this.filaGrid, 9);
            limpiarDatosProductos();
            this.filaGrid++;
        }
        this.txtCodigo.requestFocus();
    }

    private void totalizarSalida() {
        Double valorTotal = new Double(0.0d);
        for (int i = 0; i < this.grid.getRowCount(); i++) {
            valorTotal = Double.valueOf(valorTotal.doubleValue() + Double.valueOf(this.modelo.getValueAt(i, 8).toString()).doubleValue());
        }
        this.txtTotalFactura.setValue(valorTotal);
    }

    public void cargarLote(List<IInformacionInventario> informacionInventarios) {
        this.cboLlenoLote = 0;
        this.listaLote = this.claseInv.cargarLote(this.cboLote, this.listaLote, informacionInventarios);
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtExistencia.setValue(0);
        this.cboLlenoLote = 1;
    }

    public final void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Lote", "Vencimiento", "Existencia", "Salen", "Vr. Unidad", "Vr. Total", "Cant. Unidad"}) { // from class: Inventarios.Salidas.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Integer.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    public void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar El Producto?") == 0) {
            this.txtTotalFactura.setValue(Double.valueOf(Math.floor(Double.parseDouble(this.txtTotalFactura.getValue().toString()) - (Double.parseDouble(this.grid.getValueAt(this.filaGrid, 6).toString()) * Double.parseDouble(this.grid.getValueAt(this.filaGrid, 7).toString())))));
            this.modelo.removeRow(this.filaGrid);
        }
    }

    public void grabar() {
        if (this.grabada == 0) {
            if (this.cboTipoMovimiento.getSelectedIndex() != -1) {
                if (this.modelo.getRowCount() > 0) {
                    if (this.claseInv.getXidperiodoc() != -1) {
                        if (!this.claseInv.mVerificarMovDPeriodo(this.txtFecha.getDate())) {
                            this.sql = "INSERT INTO i_salidas(IdTipoMovimiento, IdBodega, FechaSalida, Id_Periodo, Destino,TipoD, IdDestino, Observaciones, Fecha, UsuarioS , IdUsuarioR ) VALUES ('" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()] + "','" + this.claseInv.getIdBodega() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.claseInv.getXidperiodoc() + "','" + this.destino + "','" + this.xidtipo + "','" + this.IdDestino + "','" + this.txtObservaciones.getText() + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                            setIdSalida(this.consultas.ejecutarSQLId(this.sql));
                            this.JLB_Registro.setText(getIdSalida());
                            System.err.println("sql" + this.sql);
                            for (int i = 0; i < this.modelo.getRowCount(); i++) {
                                this.sql = "INSERT INTO i_detallesalida(IdSalida, IdSuministro, Lote, CantidadSolicitada, CantidadDespachada, ValorUnitario, FechaVencimiento) VALUES ('" + getIdSalida() + "','" + this.modelo.getValueAt(i, 0) + "','" + this.modelo.getValueAt(i, 3) + "','" + this.modelo.getValueAt(i, 6) + "','" + this.modelo.getValueAt(i, 6) + "','" + this.modelo.getValueAt(i, 7) + "','" + this.modelo.getValueAt(i, 4) + "')";
                                this.consultas.ejecutarSQL(this.sql);
                                this.consultas.cerrarConexionBd();
                                this.sql = "SELECT Id FROM i_suministroxbodega WHERE IdBodega = '" + this.claseInv.getIdBodega() + "' AND IdSuministro = '" + this.modelo.getValueAt(i, 0) + "'";
                                this.IdSuministroxBodega = Integer.parseInt(this.consultas.traerDato(this.sql));
                                this.consultas.cerrarConexionBd();
                                this.sql = "UPDATE i_suministroxlotexbodega SET  Cantidad = (Cantidad - " + this.modelo.getValueAt(i, 6) + ") WHERE Id = '" + this.IdSuministroxBodega + "' AND Lote = '" + this.modelo.getValueAt(i, 3) + "'";
                                this.consultas.ejecutarSQL(this.sql);
                                this.consultas.cerrarConexionBd();
                            }
                            this.grabada = 1;
                            imprimir();
                            this.consultas.cerrarConexionBd();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.txtFecha.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    return;
                }
                this.metodos.mostrarMensaje("Por favor digite los Productos que salen");
                this.txtProducto.requestFocus();
                return;
            }
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Movimiento");
            this.cboTipoMovimiento.requestFocus();
            return;
        }
        this.metodos.mostrarMensaje("Por favor presione el Botón nuevo para solicitar una nueva Salida");
    }

    public void imprimir() {
        String nbreArchivo = "";
        String[][] parametros = new String[5][2];
        parametros[0][0] = "IdSalida";
        parametros[0][1] = this.idSalida;
        parametros[1][0] = "BodegaOrigen";
        parametros[1][1] = this.claseInv.getNbreBodega();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (this.destino == 1) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                nbreArchivo = "I_SalidasBodegas";
            } else {
                nbreArchivo = "I_SalidasBodegas_1";
            }
        } else if (this.destino == 2) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                nbreArchivo = "I_SalidasAProveedores";
            } else {
                nbreArchivo = "I_SalidasAProveedores_1";
            }
        } else if (this.destino == 3) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                nbreArchivo = "I_SalidasCC";
            } else {
                nbreArchivo = "I_SalidasCC_1";
            }
        }
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo, parametros);
    }

    public void limpiarDatosProductos() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtCantSale.setValue(1);
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
        this.JLB_Registro.setText("");
        limpiarDatosProductos();
        limpiarGrid();
        this.cantidad = new Double(0.0d);
        this.idSuministroItems = new Long(0L);
        this.destino = 1;
        this.xidtipo = 0;
        cargarComboDestino();
        this.metodos.limpiarDatosPrincipal();
        this.grabada = 0;
        this.filaGrid = 0;
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.txtTotalFactura.setValue(0);
        this.cboDestino.setSelectedIndex(-1);
        this.txtObservaciones.setText("");
        this.cboTipoMovimiento.requestFocus();
        this.pedidoInternoEntity = new SolicitudPedidoInternoEntity();
    }

    /* JADX WARN: Type inference failed for: r3v78, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.panelDatosSalida = new JPanel();
        this.txtFecha = new JDateChooser();
        this.btnCargarEntrada = new JButton();
        this.txtTotalFactura = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.cboDestino = new JComboBox();
        this.btnProveedor = new JCheckBox();
        this.btnBodega = new JCheckBox();
        this.btnCC = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.txtObservaciones = new JTextArea();
        this.cboTipoMovimiento = new JComboBox();
        this.btnCargarEntrada1 = new JButton();
        this.JLB_Registro = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.panelProducto = new JPanel();
        this.txtCodigo = new JTextField();
        this.btnCargar = new JButton();
        this.panelLote = new JPanel();
        this.cboLote = new JComboBox();
        this.txtExistencia = new JFormattedTextField();
        this.txtVencimiento = new JFormattedTextField();
        this.txtExistenciaInventario = new JFormattedTextField();
        this.panelCantidades = new JPanel();
        this.txtCantSale = new JSpinner();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.txtProducto = new JTextField();
        this.btnBuscarProducto = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SALIDA DE PRODUCTOS Y/O DISPOSITVOS MEDICOS");
        setDoubleBuffered(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("Salidas");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.Salidas.3
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                Salidas.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.panelDatosSalida.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE SALIDA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.btnCargarEntrada.setFont(new Font("Arial", 1, 12));
        this.btnCargarEntrada.setForeground(Color.blue);
        this.btnCargarEntrada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.btnCargarEntrada.setText("Cargar Entrada");
        this.btnCargarEntrada.setHorizontalTextPosition(0);
        this.btnCargarEntrada.setVerticalTextPosition(3);
        this.btnCargarEntrada.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.4
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnCargarEntradaActionPerformed(evt);
            }
        });
        this.txtTotalFactura.setEditable(false);
        this.txtTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtTotalFactura.setHorizontalAlignment(4);
        this.txtTotalFactura.setText("0");
        this.txtTotalFactura.setDisabledTextColor(new Color(0, 0, 0));
        this.txtTotalFactura.setEnabled(false);
        this.txtTotalFactura.setFocusable(false);
        this.txtTotalFactura.setFont(new Font("Arial", 1, 15));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Salida hacia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboDestino.setFont(new Font("Arial", 1, 12));
        this.cboDestino.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.5
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.cboDestinoActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.btnProveedor);
        this.btnProveedor.setFont(new Font("Arial", 1, 12));
        this.btnProveedor.setForeground(Color.red);
        this.btnProveedor.setText("Proveedor");
        this.btnProveedor.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.6
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnProveedorActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.btnBodega);
        this.btnBodega.setFont(new Font("Arial", 1, 12));
        this.btnBodega.setForeground(Color.red);
        this.btnBodega.setSelected(true);
        this.btnBodega.setText("Bodega");
        this.btnBodega.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.7
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnBodegaActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.btnCC);
        this.btnCC.setFont(new Font("Arial", 1, 12));
        this.btnCC.setForeground(Color.red);
        this.btnCC.setText("CC");
        this.btnCC.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.8
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnCCActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.btnBodega).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCC).addGap(18, 18, 18).addComponent(this.btnProveedor)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.cboDestino, -2, 285, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnProveedor).addComponent(this.btnBodega).addComponent(this.btnCC)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.cboDestino, -2, 50, -2).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setHorizontalScrollBarPolicy(31);
        this.jScrollPane2.setVerticalScrollBarPolicy(21);
        this.jScrollPane2.setFont(new Font("Arial", 1, 12));
        this.txtObservaciones.setColumns(20);
        this.txtObservaciones.setFont(new Font("Arial", 0, 12));
        this.txtObservaciones.setForeground(new Color(102, 0, 102));
        this.txtObservaciones.setRows(5);
        this.txtObservaciones.setBorder((Border) null);
        this.jScrollPane2.setViewportView(this.txtObservaciones);
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.9
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.btnCargarEntrada1.setFont(new Font("Arial", 1, 12));
        this.btnCargarEntrada1.setForeground(Color.blue);
        this.btnCargarEntrada1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnCargarEntrada1.setText(" Cargar Solicitudes Internas");
        this.btnCargarEntrada1.setHorizontalTextPosition(0);
        this.btnCargarEntrada1.setVerticalTextPosition(3);
        this.btnCargarEntrada1.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.10
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnCargarEntrada1ActionPerformed(evt);
            }
        });
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout panelDatosSalidaLayout = new GroupLayout(this.panelDatosSalida);
        this.panelDatosSalida.setLayout(panelDatosSalidaLayout);
        panelDatosSalidaLayout.setHorizontalGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addContainerGap().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addComponent(this.txtFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboTipoMovimiento, -2, 220, -2)).addComponent(this.jScrollPane2, -2, 342, -2)).addGap(2, 2, 2).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JLB_Registro, -2, 123, -2)).addComponent(this.txtTotalFactura, -2, 110, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addComponent(this.btnCargarEntrada1, -1, -1, 32767).addGap(8, 8, 8)).addGroup(panelDatosSalidaLayout.createSequentialGroup().addComponent(this.btnCargarEntrada, -1, -1, 32767).addContainerGap()))));
        panelDatosSalidaLayout.setVerticalGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelDatosSalidaLayout.createSequentialGroup().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(panelDatosSalidaLayout.createSequentialGroup().addContainerGap().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.cboTipoMovimiento, -2, 50, -2).addComponent(this.txtFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 56, -2)).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, panelDatosSalidaLayout.createSequentialGroup().addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCargarEntrada, -2, 60, -2).addComponent(this.JLB_Registro, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(panelDatosSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtTotalFactura, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.btnCargarEntrada1, GroupLayout.Alignment.TRAILING, -2, 60, -2)))).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setGridColor(new Color(0, 51, 51));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.Salidas.11
            public void keyPressed(KeyEvent evt) {
                Salidas.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.panelProducto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "INFORMACIÓN DEL PRODUCTO QUE SALE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.Salidas.12
            public void focusLost(FocusEvent evt) {
                Salidas.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.13
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.txtCodigoActionPerformed(evt);
            }
        });
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.14
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnCargarActionPerformed(evt);
            }
        });
        this.panelLote.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "LOTE", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.15
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.cboLoteActionPerformed(evt);
            }
        });
        this.txtExistencia.setEditable(false);
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(0, 102, 51));
        this.txtExistencia.setFocusable(false);
        this.txtExistencia.setFont(new Font("Arial", 1, 12));
        this.txtExistencia.setSelectionColor(new Color(0, 0, 0));
        this.txtExistencia.setValue(new Integer(0));
        this.txtVencimiento.setEditable(false);
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Venc.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtVencimiento.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        this.txtVencimiento.setHorizontalAlignment(4);
        this.txtVencimiento.setDisabledTextColor(new Color(0, 102, 51));
        this.txtVencimiento.setFocusable(false);
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        GroupLayout panelLoteLayout = new GroupLayout(this.panelLote);
        this.panelLote.setLayout(panelLoteLayout);
        panelLoteLayout.setHorizontalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.cboLote, -2, 210, -2).addGap(0, 0, 0).addComponent(this.txtExistencia, -2, 90, -2).addGap(10, 10, 10).addComponent(this.txtVencimiento, -2, 110, -2).addContainerGap(12, 32767)));
        panelLoteLayout.setVerticalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboLote, -2, 50, -2).addComponent(this.txtExistencia, -2, 50, -2).addComponent(this.txtVencimiento, -2, 50, -2)).addContainerGap(15, 32767)));
        this.txtExistenciaInventario.setEditable(false);
        this.txtExistenciaInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtExistenciaInventario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtExistenciaInventario.setHorizontalAlignment(4);
        this.txtExistenciaInventario.setDisabledTextColor(new Color(0, 0, 0));
        this.txtExistenciaInventario.setEnabled(false);
        this.txtExistenciaInventario.setFocusable(false);
        this.txtExistenciaInventario.setFont(new Font("Arial", 1, 16));
        this.txtExistenciaInventario.setValue(new Integer(0));
        this.panelCantidades.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "VALORES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.txtCantSale.setFont(new Font("Arial", 1, 12));
        this.txtCantSale.setModel(new SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(1.0d)));
        this.txtCantSale.setToolTipText("Cantidad que sale");
        this.txtCantSale.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantSale.addChangeListener(new ChangeListener() { // from class: Inventarios.Salidas.16
            public void stateChanged(ChangeEvent evt) {
                Salidas.this.txtCantSaleStateChanged(evt);
            }
        });
        this.txtValorUnidad.setEditable(false);
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unitario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.txtValorUnidad.setDisabledTextColor(new Color(0, 102, 51));
        this.txtValorUnidad.setFocusable(false);
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.txtValorUnidad.setValue(new Double(0.0d));
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setDisabledTextColor(new Color(0, 102, 51));
        this.txtValorTotal.setFocusable(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 12));
        this.txtValorTotal.setValue(new Double(0.0d));
        this.txtValorTotal.addFocusListener(new FocusAdapter() { // from class: Inventarios.Salidas.17
            public void focusLost(FocusEvent evt) {
                Salidas.this.txtValorTotalFocusLost(evt);
            }
        });
        this.txtValorTotal.addKeyListener(new KeyAdapter() { // from class: Inventarios.Salidas.18
            public void keyPressed(KeyEvent evt) {
                Salidas.this.txtValorTotalKeyPressed(evt);
            }
        });
        GroupLayout panelCantidadesLayout = new GroupLayout(this.panelCantidades);
        this.panelCantidades.setLayout(panelCantidadesLayout);
        panelCantidadesLayout.setHorizontalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCantidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.txtCantSale, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorUnidad, -2, 100, -2).addGap(8, 8, 8).addComponent(this.txtValorTotal, -2, 100, -2).addGap(0, 8, 32767)));
        panelCantidadesLayout.setVerticalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCantidadesLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorTotal, -2, 50, -2).addComponent(this.txtValorUnidad, -2, 50, -2).addComponent(this.txtCantSale, -2, 50, -2)).addContainerGap(9, 32767)));
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setHorizontalAlignment(2);
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtProducto.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProducto.setEnabled(false);
        this.txtProducto.addMouseWheelListener(new MouseWheelListener() { // from class: Inventarios.Salidas.19
            public void mouseWheelMoved(MouseWheelEvent evt) {
                Salidas.this.txtProductoMouseWheelMoved(evt);
            }
        });
        this.txtProducto.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.20
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.txtProductoActionPerformed(evt);
            }
        });
        this.txtProducto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.Salidas.21
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Salidas.this.txtProductoPropertyChange(evt);
            }
        });
        this.txtProducto.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.Salidas.22
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Salidas.this.txtProductoVetoableChange(evt);
            }
        });
        this.btnBuscarProducto.setFont(new Font("Arial", 1, 14));
        this.btnBuscarProducto.setForeground(Color.red);
        this.btnBuscarProducto.setText("...");
        this.btnBuscarProducto.addActionListener(new ActionListener() { // from class: Inventarios.Salidas.23
            public void actionPerformed(ActionEvent evt) {
                Salidas.this.btnBuscarProductoActionPerformed(evt);
            }
        });
        this.btnBuscarProducto.addFocusListener(new FocusAdapter() { // from class: Inventarios.Salidas.24
            public void focusLost(FocusEvent evt) {
                Salidas.this.btnBuscarProductoFocusLost(evt);
            }
        });
        GroupLayout panelProductoLayout = new GroupLayout(this.panelProducto);
        this.panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addComponent(this.txtCodigo, -2, 170, -2).addGap(10, 10, 10).addComponent(this.txtProducto, -2, 630, -2)).addGroup(panelProductoLayout.createSequentialGroup().addComponent(this.panelLote, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelCantidades, -2, -1, -2))).addGap(10, 10, 10).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.btnBuscarProducto, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtExistenciaInventario, -2, 120, -2)).addComponent(this.btnCargar, -2, 190, -2)).addContainerGap()));
        panelProductoLayout.setVerticalGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelProductoLayout.createSequentialGroup().addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCodigo, -2, 50, -2).addComponent(this.txtProducto, -2, 50, -2)).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelLote, -1, -1, 32767).addGroup(panelProductoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnCargar, -2, 70, -2).addComponent(this.panelCantidades, -2, -1, -2)).addGap(0, 0, 32767)))).addGroup(panelProductoLayout.createSequentialGroup().addGroup(panelProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtExistenciaInventario, -2, 50, -2).addComponent(this.btnBuscarProducto, -2, 50, -2)).addGap(0, 0, 32767))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelProducto, -1, -1, 32767).addComponent(this.jScrollPane1).addComponent(this.panelDatosSalida, -1, -1, 32767)).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelDatosSalida, -2, -1, -2).addGap(18, 18, 18).addComponent(this.panelProducto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 239, -2).addContainerGap(13, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
        if (this.cboLlenoLote == 1 && this.cboLote.getSelectedIndex() > -1) {
            cargarDatosDelLote();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantSaleStateChanged(ChangeEvent evt) {
        this.txtValorTotal.setValue(Double.valueOf(Double.parseDouble(this.txtCantSale.getValue().toString()) * Double.parseDouble(this.txtValorUnidad.getValue().toString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDestinoActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboDestino.getSelectedIndex() > -1) {
            this.IdDestino = this.listaDestino[this.cboDestino.getSelectedIndex()];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        this.txtProducto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarEntradaActionPerformed(ActionEvent evt) {
        BuscarEntrada frm = new BuscarEntrada(null, true, this.claseInv, "Salidas");
        frm.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnProveedorActionPerformed(ActionEvent evt) {
        this.destino = 2;
        this.xidtipo = 2;
        cargarComboDestino();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBodegaActionPerformed(ActionEvent evt) {
        this.destino = 1;
        this.xidtipo = 0;
        cargarComboDestino();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCCActionPerformed(ActionEvent evt) {
        this.destino = 3;
        this.xidtipo = 1;
        cargarComboDestino();
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
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal principal = this.claseInv.frmPrincipal;
        Menus menus = this.claseInv.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarEntrada1ActionPerformed(ActionEvent evt) {
        JDBusquedaSolicitudesInternas internas = new JDBusquedaSolicitudesInternas(null, true, getName());
        internas.setLocationRelativeTo(this);
        internas.setVisible(true);
    }

    public void buscarOrden(SolicitudPedidoInternoEntity solicitudPedidoInternoEntity) {
        nuevo();
        if (this.pedidoInternoEntity != null) {
            new ArrayList();
            this.pedidoInternoEntity = solicitudPedidoInternoEntity;
            List<ISuministroBodegaInventario> suministroBodegaInventarios = this.bodegaDAO.listSuministroBodegaExistenciaSolicitudPedido(this.metodos.formatoAMD1.format(this.metodos.getFechaActual()), Long.valueOf(Principal.xClaseInventario.getIdBodega()), this.pedidoInternoEntity.getId());
            if (suministroBodegaInventarios != null) {
                this.cantidad = new Double(0.0d);
                this.idSuministroItems = new Long(0L);
                suministroBodegaInventarios.forEach(item -> {
                    if (Objects.equals(this.idSuministroItems, item.getIdSuministro())) {
                        if (!Objects.equals(this.cantidad, item.getCantidadSolicitada())) {
                            this.modelo.addRow(this.dato);
                            this.modelo.setValueAt(item.getIdSuministro(), this.grid.getRowCount() - 1, 0);
                            this.modelo.setValueAt(item.getCodigoBarra(), this.grid.getRowCount() - 1, 1);
                            this.modelo.setValueAt(item.getNombreItem(), this.grid.getRowCount() - 1, 2);
                            this.modelo.setValueAt(item.getLote(), this.grid.getRowCount() - 1, 3);
                            this.modelo.setValueAt(item.getFechaVencimiento(), this.grid.getRowCount() - 1, 4);
                            this.modelo.setValueAt(item.getExistencia(), this.grid.getRowCount() - 1, 5);
                            this.modelo.setValueAt(Double.valueOf(this.cantidad.doubleValue() - item.getExistencia().doubleValue()), this.grid.getRowCount() - 1, 6);
                            this.modelo.setValueAt(item.getValorUnitario(), this.grid.getRowCount() - 1, 7);
                            this.modelo.setValueAt(Double.valueOf(item.getValorUnitario().doubleValue() * (this.cantidad.doubleValue() - item.getExistencia().doubleValue())), this.grid.getRowCount() - 1, 8);
                            this.modelo.setValueAt(item.getCantidadUnidad(), this.grid.getRowCount() - 1, 9);
                            this.idSuministroItems = item.getIdSuministro();
                            this.cantidad = Double.valueOf(this.cantidad.doubleValue() + item.getExistencia().doubleValue());
                            return;
                        }
                        return;
                    }
                    if (item.getExistencia().doubleValue() >= item.getCantidadSolicitada().doubleValue()) {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(item.getIdSuministro(), this.grid.getRowCount() - 1, 0);
                        this.modelo.setValueAt(item.getCodigoBarra(), this.grid.getRowCount() - 1, 1);
                        this.modelo.setValueAt(item.getNombreItem(), this.grid.getRowCount() - 1, 2);
                        this.modelo.setValueAt(item.getLote(), this.grid.getRowCount() - 1, 3);
                        this.modelo.setValueAt(item.getFechaVencimiento(), this.grid.getRowCount() - 1, 4);
                        this.modelo.setValueAt(item.getExistencia(), this.grid.getRowCount() - 1, 5);
                        this.modelo.setValueAt(item.getCantidadSolicitada(), this.grid.getRowCount() - 1, 6);
                        this.modelo.setValueAt(item.getValorUnitario(), this.grid.getRowCount() - 1, 7);
                        this.modelo.setValueAt(Double.valueOf(item.getValorUnitario().doubleValue() * item.getCantidadSolicitada().doubleValue()), this.grid.getRowCount() - 1, 8);
                        this.modelo.setValueAt(item.getCantidadUnidad(), this.grid.getRowCount() - 1, 9);
                        this.idSuministroItems = item.getIdSuministro();
                        this.cantidad = item.getCantidadSolicitada();
                        return;
                    }
                    if (item.getExistencia().doubleValue() != 0.0d) {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(item.getIdSuministro(), this.grid.getRowCount() - 1, 0);
                        this.modelo.setValueAt(item.getCodigoBarra(), this.grid.getRowCount() - 1, 1);
                        this.modelo.setValueAt(item.getNombreItem(), this.grid.getRowCount() - 1, 2);
                        this.modelo.setValueAt(item.getLote(), this.grid.getRowCount() - 1, 3);
                        this.modelo.setValueAt(item.getFechaVencimiento(), this.grid.getRowCount() - 1, 4);
                        this.modelo.setValueAt(item.getExistencia(), this.grid.getRowCount() - 1, 5);
                        this.modelo.setValueAt(item.getExistencia(), this.grid.getRowCount() - 1, 6);
                        this.modelo.setValueAt(item.getValorUnitario(), this.grid.getRowCount() - 1, 7);
                        this.modelo.setValueAt(Double.valueOf(item.getValorUnitario().doubleValue() * item.getExistencia().doubleValue()), this.grid.getRowCount() - 1, 8);
                        this.modelo.setValueAt(item.getCantidadUnidad(), this.grid.getRowCount() - 1, 9);
                        this.idSuministroItems = item.getIdSuministro();
                        this.cantidad = Double.valueOf(this.cantidad.doubleValue() + item.getExistencia().doubleValue());
                    }
                });
                totalizarSalida();
            }
        }
    }
}
