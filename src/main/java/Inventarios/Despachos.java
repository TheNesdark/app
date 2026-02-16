package Inventarios;

import Acceso.Principal;
import General.Anular;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.dto.inventario.InfomacionLote;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.projection.IInformacionOrdenMedicaSuministro;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Despachos.class */
public class Despachos extends JInternalFrame {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private String idDespacho;
    private String estado;
    private String fecha;
    private String xllamador;
    private String sql;
    private String idProducto;
    private String idPrincipioActivo;
    private String cantxUnidad;
    private String idLote;
    private String xidpricipioactivo;
    private String xcodigoagrupacion;
    private String xidIngreso;
    private GregorianCalendar fechaAnterior;
    public String xIdProductoB;
    public String xnconcentracion;
    public String xsql;
    public int filaGrid;
    public int grabada;
    public int cboLleno;
    public String[] listaTipoMovimiento;
    public String[] listaEps;
    public String[][] listaProfesional;
    public List<InfomacionLote> listaLote;
    public int cboLlenoLote;
    public int xcfechav;
    public int xidconcentracion;
    private double xvalortemp;
    private double existenciaReal;
    private DefaultTableModel modelo;
    public Persona frmPersona;
    private claseInventario claseInv;
    private JIFVerificacionPActivo xjifverficarpa;
    private int xmodulo;
    private int xtp;
    private int xTipoProducto;
    private int xCerrar;
    private long xidunidosis;
    private long xIdIngreso;
    private boolean xPaso;
    private boolean xFiltro;
    private boolean xcontroltemp;
    private String productosSinExistencia;
    private List<IInformacionInventario> informacionInventarios;
    private JButton JBTEventoAdverso;
    private JButton JBT_Facturacion;
    private JSpinner JSPNPendiente;
    private JButton btnBuscarProducto;
    private JButton btnBuscarUltimoDespacho;
    private JButton btnCargar;
    private ButtonGroup buttonGroup1;
    public JComboBox cboEps;
    public JComboBox cboLote;
    public JComboBox cboProfesional;
    public JComboBox cboTipoMovimiento;
    public JTable grid;
    private JCheckBox jCheckBox1;
    private JScrollPane jScrollPane1;
    private JPanel panelCantidades;
    private JPanel panelDatosSalida;
    private JPanel panelLote;
    private JPanel panelPersona;
    private JPanel panelPrecios;
    private JPanel panelProducto;
    public JTextField txtCodigo;
    private JSpinner txtEntregada;
    private JFormattedTextField txtExistencia;
    public JFormattedTextField txtExistenciaInventario;
    private JFormattedTextField txtFaltante;
    public JDateChooser txtFecha;
    public JFormattedTextField txtNoFaltante;
    public JTextField txtOrden;
    public JTextField txtProducto;
    private JSpinner txtSolicitada;
    public JFormattedTextField txtTotalFactura;
    private JFormattedTextField txtValorTotal;
    public JFormattedTextField txtValorUnidad;
    private JFormattedTextField txtVencimiento;

    public Despachos(claseInventario claseI, int xmodulo) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xllamador = "";
        this.fechaAnterior = new GregorianCalendar();
        this.filaGrid = 0;
        this.grabada = 0;
        this.cboLlenoLote = 0;
        this.xvalortemp = 0.0d;
        this.existenciaReal = 0.0d;
        this.xmodulo = 0;
        this.xtp = 0;
        this.xTipoProducto = 0;
        this.xCerrar = 0;
        this.xidunidosis = 0L;
        this.xIdIngreso = 0L;
        this.xPaso = false;
        this.xFiltro = false;
        this.xcontroltemp = false;
        this.productosSinExistencia = "";
        initComponents();
        this.claseInv = claseI;
        this.xmodulo = xmodulo;
        cargarPanelPersona();
        cargarCombos();
        crearGrid();
        nuevo();
        this.xtp = 0;
        if (this.xmodulo == 1) {
            this.txtOrden.setText("" + this.claseInv.xjifformulacionmedica.getXnorden());
        }
        setTitle("Dispensación de Productos y Suministros de : " + this.claseInv.getNbreBodega().toUpperCase());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.Despachos.1
            public void mouseClicked(MouseEvent e) {
                Despachos.this.filaGrid = Despachos.this.grid.rowAtPoint(e.getPoint());
            }
        });
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            try {
                this.cboEps.setSelectedIndex(0);
                this.cboProfesional.setSelectedIndex(0);
                this.cboTipoMovimiento.setSelectedIndex(0);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog((Component) null, "Debe configurar los tipo de movimientos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (!Principal.informacionIps.getAplicaFacturacionDespacho().booleanValue()) {
            this.JBT_Facturacion.setVisible(false);
        }
    }

    public Despachos(claseInventario claseI, int xmodulo, String xnhistoria, Long xidunidosis, Long xIdIngreso, Boolean xFiltro, int xTipoProducto, int xCerrar, String xllamador) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xllamador = "";
        this.fechaAnterior = new GregorianCalendar();
        this.filaGrid = 0;
        this.grabada = 0;
        this.cboLlenoLote = 0;
        this.xvalortemp = 0.0d;
        this.existenciaReal = 0.0d;
        this.xmodulo = 0;
        this.xtp = 0;
        this.xTipoProducto = 0;
        this.xCerrar = 0;
        this.xidunidosis = 0L;
        this.xIdIngreso = 0L;
        this.xPaso = false;
        this.xFiltro = false;
        this.xcontroltemp = false;
        this.productosSinExistencia = "";
        initComponents();
        this.claseInv = claseI;
        this.xidunidosis = xidunidosis.longValue();
        this.xIdIngreso = xIdIngreso.longValue();
        this.xmodulo = xmodulo;
        this.xFiltro = xFiltro.booleanValue();
        this.xCerrar = xCerrar;
        this.xTipoProducto = xTipoProducto;
        this.xllamador = xllamador;
        cargarPanelPersona();
        cargarCombos();
        nuevo();
        if (this.xllamador.equals("JIFAgenda_Unidosis")) {
            mBuscarInsumoUnidosis();
        } else {
            mBuscarSuministroCirugia();
        }
        this.xtp = 0;
        setTitle("Despacho de Productos y Suministros de : " + this.claseInv.getNbreBodega().toUpperCase());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.Despachos.2
            public void mouseClicked(MouseEvent e) {
                Despachos.this.filaGrid = Despachos.this.grid.rowAtPoint(e.getPoint());
            }
        });
        if (!Principal.informacionIps.getAplicaFacturacionDespacho().booleanValue()) {
            this.JBT_Facturacion.setVisible(false);
        }
        this.frmPersona.txtHistoria.setText(xnhistoria);
        this.frmPersona.buscar(2);
    }

    public String getIdProfesional() {
        return this.listaProfesional[this.cboProfesional.getSelectedIndex()][0];
    }

    public String getIdEspecialidad() {
        return this.listaProfesional[this.cboProfesional.getSelectedIndex()][1];
    }

    public String getIdProducto() {
        return this.idProducto;
    }

    public String getXcodigoagrupacion() {
        return this.xcodigoagrupacion;
    }

    public void setXcodigoagrupacion(String xcodigoagrupacion) {
        this.xcodigoagrupacion = xcodigoagrupacion;
    }

    public void setcantUnidad(String can) {
        this.cantxUnidad = can;
    }

    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    public void setIdPrincipioActivo(String idPA) {
        this.idPrincipioActivo = idPA;
    }

    public String getIdPrincipioActivo() {
        return this.idPrincipioActivo;
    }

    public int getXidconcentracion() {
        return this.xidconcentracion;
    }

    public void setXidconcentracion(int xidconcentracion) {
        this.xidconcentracion = xidconcentracion;
    }

    public String getXnconcentracion() {
        return this.xnconcentracion;
    }

    public void setXnconcentracion(String xnconcentracion) {
        this.xnconcentracion = xnconcentracion;
    }

    public void anular() {
        if (this.idDespacho.isEmpty() || this.idDespacho.equals("") || this.idDespacho.equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Por Favor seleccione un Número de Despacho a Anular", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            JOptionPane.showInternalMessageDialog(this, "El Despacho ya se encuentra Anulado.", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            Anular frm = new Anular(null, true, "Despachos", 4);
            frm.setVisible(true);
        }
    }

    public void anularDespacho(String razon, String detalle) {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs("SELECT Id FROM i_salidas WHERE (Id_DocContable =0 AND Id ='" + Principal.txtNo.getText() + "')");
            if (xrs.next()) {
                this.sql = "UPDATE i_salidas SET  Estado = 1, Id_MotivoAnulacion = " + razon + " ,Observacion_Anulacion = '" + detalle + "', Fecha_Anulacion = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Usuario_Anulacion = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + this.idDespacho + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                ActualizarSuministroxBodega();
                this.metodos.marcarEstado(1);
                this.sql = "UPDATE i_faltantes SET  Estado = 1, Id_MotivoAnulacion =" + razon + " ,Observacion_Anulacion = '" + detalle + "', Fecha_Anulacion =  '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Usuario_Anulacion = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdSalida = '" + this.idDespacho + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Despacho Anulado, Ok", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else {
                JOptionPane.showInternalMessageDialog(this, "El despacho no se puede anular;\nya se encuentra contabilizado,", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void ActualizarSuministroxBodega() throws SQLException {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.claseInv.mSumarCantidadInventario(Integer.valueOf(this.modelo.getValueAt(i, 11).toString()).intValue(), Double.valueOf(this.modelo.getValueAt(i, 7).toString()), this.modelo.getValueAt(i, 3).toString(), "", Double.valueOf(0.0d));
        }
    }

    private String traerIdLote(int fila) {
        this.sql = "SELECT Id FROM i_suministroxbodega WHERE (IdBodega ='" + this.claseInv.getIdBodega() + "' AND IdSuministro ='" + this.modelo.getValueAt(fila, 0) + "')";
        String idL = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        return idL;
    }

    public void buscarDespachos() {
        Object[] botones = {"Usuario", "Despacho", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this.frmPersona);
            frmBuscar.setVisible(true);
        } else if (n == 1) {
            BuscarDespacho frm = new BuscarDespacho(null, true, this.frmPersona.txtHistoria.getText(), this.claseInv);
            frm.setVisible(true);
            this.grabada = 1;
        }
    }

    public void buscarOrden() {
        double cantidadTotal;
        try {
            if (!this.txtOrden.getText().equals("0")) {
                this.sql = "SELECT `h_ordenes`.`Id`, ingreso.Id_Usuario, CONCAT(`profesional1`.NProfesional, ' - ', `profesional1`.`Especialidad`) NProfesional, `g_usuario`.`NoHistoria`, IFNULL(i_tiposmovimientos.Nbre,'') AS TipoMovimiento\n, f_empresacontxconvenio.Nbre AS Empresa, ingreso.`Id` AS Ingreso, `h_itemordenessum`.`Id_Suministro`, `h_itemordenessum`.`Cantidad`    \nFROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`h_ordenes`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\nLEFT JOIN `i_tipomovimientoxtformula` ON (`h_ordenes`.`IdTipoFormula` = `i_tipomovimientoxtformula`.`Id_TipoFormula`) INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nLEFT JOIN `i_tiposmovimientos` ON (`i_tipomovimientoxtformula`.`Id_Movimiento` = `i_tiposmovimientos`.`Id`)\nWHERE (`h_ordenes`.`Id` ='" + this.txtOrden.getText() + "' AND `h_ordenes`.`EstaEntregada` in(0,1) AND `h_ordenes`.`Estado` =0) GROUP BY `h_itemordenessum`.`Id_Suministro`";
                ResultSet rs = this.consultas.traerRs(this.sql);
                if (rs.next()) {
                    nuevo();
                    this.txtOrden.setText(rs.getString(1));
                    this.frmPersona.IdPersona = rs.getString(2);
                    this.cboProfesional.setSelectedItem(rs.getString(3));
                    this.frmPersona.txtHistoria.setText(rs.getString(4));
                    this.cboTipoMovimiento.setSelectedItem(rs.getString(5));
                    this.cboEps.setSelectedItem(rs.getString(6));
                    this.xidIngreso = rs.getString(7);
                    if (!"0".equals(this.xidIngreso) && !this.xidIngreso.isEmpty()) {
                        this.JBTEventoAdverso.setEnabled(true);
                    }
                    this.txtCodigo.requestFocus();
                    rs.first();
                    new Double(0.0d);
                    rs.beforeFirst();
                    this.filaGrid = 0;
                    while (rs.next()) {
                        Double xcantidad = Double.valueOf(rs.getDouble(9));
                        List<IInformacionOrdenMedicaSuministro> medicaSuministro = this.claseInv.listItemOrdenMedica(this.metodos.getFechaActual(), this.claseInv.getListaIdBodega(), Long.valueOf(rs.getLong(8)), xcantidad);
                        if (!medicaSuministro.isEmpty()) {
                            for (IInformacionOrdenMedicaSuministro next : medicaSuministro) {
                                this.modelo.addRow(this.dato);
                                this.modelo.setValueAt(next.getIdSuministro(), this.filaGrid, 0);
                                this.modelo.setValueAt(next.getCodigoBarra(), this.filaGrid, 1);
                                this.modelo.setValueAt(next.getNombreSuministro(), this.filaGrid, 2);
                                this.modelo.setValueAt(next.getLote(), this.filaGrid, 3);
                                this.modelo.setValueAt(next.getFechaVencimiento(), this.filaGrid, 4);
                                this.modelo.setValueAt(next.getCantidadInventario(), this.filaGrid, 5);
                                this.modelo.setValueAt(xcantidad, this.filaGrid, 6);
                                System.out.println("" + next.getCantidadInventario());
                                if (next.getCantidadInventario().compareTo(xcantidad) < 0) {
                                    this.modelo.setValueAt(next.getCantidadInventario(), this.filaGrid, 7);
                                    cantidadTotal = 0.0d + xcantidad.doubleValue();
                                } else {
                                    this.modelo.setValueAt(xcantidad, this.filaGrid, 7);
                                    cantidadTotal = 0.0d + next.getCantidadInventario().doubleValue();
                                }
                                this.modelo.setValueAt(next.getValorUnitario(), this.filaGrid, 8);
                                this.modelo.setValueAt(Double.valueOf(next.getValorUnitario().doubleValue() * Double.valueOf(this.modelo.getValueAt(this.filaGrid, 7).toString()).doubleValue()), this.filaGrid, 9);
                                this.modelo.setValueAt(next.getCantidadUnidad(), this.filaGrid, 10);
                                this.modelo.setValueAt(next.getIdSuministroBodega(), this.filaGrid, 11);
                                this.modelo.setValueAt(next.getCantidadPendiente(), this.filaGrid, 12);
                                this.modelo.setValueAt(true, this.filaGrid, 13);
                                this.modelo.setValueAt("", this.filaGrid, 14);
                                this.modelo.setValueAt(false, this.filaGrid, 15);
                                this.filaGrid++;
                                if (next.getCantidadEntregada().compareTo(xcantidad) == 0) {
                                    break;
                                }
                                xcantidad = Double.valueOf(xcantidad.doubleValue() - next.getCantidadEntregada().doubleValue());
                                if (cantidadTotal == rs.getInt(9)) {
                                    break;
                                }
                            }
                        }
                    }
                    mTotalizarOrden();
                    int x = JOptionPane.showInternalConfirmDialog(this, "Desea Buscar e Imprimir la siguiente Orden", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        buscarImprimirSiguienteOrden();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No se encontró la Orden solicitada", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void buscarProducto(int op) {
        if (op == 1) {
            this.informacionInventarios = new ArrayList();
            this.informacionInventarios = this.claseInv.listInventarioGeneral(this.metodos.getFechaActual(), this.claseInv.getListaIdBodega(), 0, 1, this.txtCodigo.getText(), "");
            if (!this.informacionInventarios.isEmpty()) {
                this.idProducto = this.informacionInventarios.get(0).getIdSuministro().toString();
                this.txtProducto.setText(this.informacionInventarios.get(0).getNombreSuministro() + " " + this.informacionInventarios.get(0).getNombrePresentacionComercial() + " " + this.informacionInventarios.get(0).getNombreLaboratorio());
                this.txtValorUnidad.setValue(this.informacionInventarios.get(0).getValorUnitario());
                this.txtExistenciaInventario.setValue(this.informacionInventarios.get(0).getCantidadTotal());
                this.xIdProductoB = this.informacionInventarios.get(0).getIdSUministroBodega().toString();
                this.txtValorTotal.setValue(Double.valueOf(this.informacionInventarios.get(0).getValorUnitario().doubleValue() * ((double) Integer.parseInt(this.txtEntregada.getValue().toString()))));
                setIdPrincipioActivo(this.informacionInventarios.get(0).getIdPrincipioActivo().toString());
                setXcodigoagrupacion(this.informacionInventarios.get(0).getCodigoAgruacion());
                System.out.println("" + this.informacionInventarios);
                cargarLote(this.informacionInventarios);
                if ((this.claseInv.getIdBodega().equals("2") || this.claseInv.getIdBodega().equals("4")) && Principal.informacionIps.getEsFpz().intValue() == 0) {
                    mVerificarMedicamento();
                }
                this.xcontroltemp = this.informacionInventarios.get(0).getControlTemperatura().booleanValue();
                this.xvalortemp = this.informacionInventarios.get(0).getTemperaturaMinima().doubleValue();
                setXidconcentracion(this.informacionInventarios.get(0).getIdConcentracion().intValue());
                setXnconcentracion(this.informacionInventarios.get(0).getNombreConcentracion());
                this.xPaso = true;
                return;
            }
            limpiarDatosProductos();
            return;
        }
        BuscarProducto frm = new BuscarProducto(null, true, this, this.claseInv.getIdBodega(), this.claseInv, 1);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
    }

    private void buscarAlertas() {
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xPaso = false;
            System.out.println("" + this.informacionInventarios.size());
            System.out.println("" + this.informacionInventarios.get(0).getCalculoFechaVencimientoInvima());
            System.out.println("" + this.informacionInventarios.get(0).getFechaVencimientoInvima());
            if (this.informacionInventarios != null && this.informacionInventarios.size() > 0 && this.informacionInventarios.get(0).getNumeroDiasVencimientoInvima() != null && this.informacionInventarios.get(0).getFechaVencimientoInvima() != null && this.informacionInventarios.get(0).getCalculoFechaVencimientoInvima() != null) {
                mVerificarFVencimientoInvima(this.informacionInventarios.get(0).getCalculoFechaVencimientoInvima().intValue(), this.informacionInventarios.get(0).getFechaVencimientoInvima(), this.informacionInventarios.get(0).getNumeroDiasVencimientoInvima().toString());
            }
            mVerificarNovedadP();
            mVerificarControlTemperatura();
            mVerificarDespchoPactivoVsFormula();
            mVerificarDespchoPactivoVsUnidosis();
            mVerificarDespachoConcentracionVsFormula();
            mVerificarDespachoConcentracionVsUnidosis();
            if (this.claseInv.getIdBodega().equals("2")) {
                mPedirProductoProveedor();
            }
            this.xPaso = true;
        }
        mVerificarMensaje_ClasificacionLasa(this.informacionInventarios.get(0).getAlertaClasificacionLasa());
    }

    private void mVerificarFechaVencimiento() {
        try {
            this.sql = "SELECT IF(DATE('" + this.txtVencimiento.getText() + "')<=NOW(), FALSE,TRUE) AS Res ";
            System.out.println(this.sql);
            ResultSet rs = this.consultas.traerRs(this.sql);
            if (rs.next()) {
                if (!rs.getBoolean(1)) {
                    this.xcfechav = 1;
                    String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Este medicamento y/o dispositivo  no se pude dispensar por fecha de vencimiento : " + this.txtVencimiento.getText() + ";</p><font face='Arial' color='red' size=4>Favor verificar.</html>";
                    JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL FECHA DE VENCIMIENTO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                } else {
                    this.xcfechav = 0;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarControlTemperatura() {
        if (this.xcontroltemp) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Medicamento y/o dispositivo medico con control de temperatura de " + this.xvalortemp + "°;</p><font face='Arial' color='red' size=4>Favor verificar condiciones del producto.</html>";
            JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL DE TEMPERATURA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void mVerificarDespchoPactivoVsFormula() {
        if (!this.txtOrden.getText().equals("0")) {
            this.sql = "SELECT i_suministro.IdPrincipioActivo FROM h_itemordenessum INNER JOIN h_ordenes  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) WHERE (h_ordenes.Id ='" + this.txtOrden.getText() + "' AND i_suministro.IdPrincipioActivo='" + getIdPrincipioActivo() + "') ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            try {
                if (!xrs.next()) {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Principio activo a despachar no se encuentra dentro de la formula medica expedida por el profesional tratante;</p><font face='Arial' color='red' size=4>Favor revisar producto a despachar</html>", "VALIDACIÓN PRINCIPIO ACTIVO DESPACHADO Vs FORMULA MEDICA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mVerificarDespchoPactivoVsUnidosis() {
        if (this.xidunidosis != 0) {
            this.sql = "SELECT `i_suministro`.`IdPrincipioActivo` FROM `h_ordenes_unidosis_detalle` INNER JOIN  `i_suministro`  ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`) WHERE (`h_ordenes_unidosis_detalle`.`Id_Ordenes` ='" + this.xidunidosis + "'   AND `i_suministro`.`IdPrincipioActivo` ='" + getIdPrincipioActivo() + "') ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            try {
                if (!xrs.next()) {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Principio activo a despachar no se encuentra dentro de la unidosis medica expedida por el profesional tratante;</p><font face='Arial' color='red' size=4>Favor revisar producto a despachar</html>", "VALIDACIÓN PRINCIPIO ACTIVO DESPACHADO Vs FORMULA MEDICA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mVerificarDespachoConcentracionVsFormula() {
        if (!this.txtOrden.getText().equals("0")) {
            this.sql = "SELECT i_suministro.IdPrincipioActivo, i_concentracion.Nbre FROM h_itemordenessum INNER JOIN h_ordenes  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id)  INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id)  INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id)  WHERE (h_ordenes.Id ='" + this.txtOrden.getText() + "' AND i_suministro.IdPrincipioActivo='" + getIdPrincipioActivo() + "' and i_suministro.IdConcentracion='" + getXidconcentracion() + "') ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            try {
                if (!xrs.next()) {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Concentración del producto diferente a la solicitada en  la formula médica expedida por el profesional tratante ;</p><font face='Arial' color='red' size=4>Favor revisar producto a despachar.</html>", "VALIDACIÓN CONCENTRACIÓN Vs FORMULA MEDICA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mVerificarDespachoConcentracionVsUnidosis() {
        if (this.xidunidosis != 0) {
            this.sql = "SELECT `i_suministro`.`IdPrincipioActivo` , `i_concentracion`.`Nbre` FROM `h_ordenes_unidosis_detalle`  INNER JOIN  `i_suministro`  ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`) INNER JOIN  `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) WHERE (`h_ordenes_unidosis_detalle`.`Id_Ordenes` ='" + this.xidunidosis + "'  AND i_suministro.IdPrincipioActivo='" + getIdPrincipioActivo() + "' AND `i_suministro`.`IdConcentracion` ='" + getXidconcentracion() + "') ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            try {
                if (!xrs.next()) {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Concentración del producto diferente a la solicitada en  la unidosis médica expedida por el profesional tratante ;</p><font face='Arial' color='red' size=4>Favor revisar producto a despachar.</html>", "VALIDACIÓN CONCENTRACIÓN Vs FORMULA MEDICA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mVerificarNovedadP() {
        String sql = "SELECT g_tiponovedad.Nbre, i_novedad_suministro.Soporte, i_novedad_suministro.Documento  FROM i_novedad_suministro INNER JOIN g_tiponovedad  ON (i_novedad_suministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (i_novedad_suministro.Estado =1 AND i_novedad_suministro.Id_Suministro ='" + getIdProducto() + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(2)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1) + "\ndesea visualizarla?", "NOVEDADES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x == 0) {
                        this.metodos.mostrarPdf(xrs.getString(3));
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1), "NOVEDADES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarFVencimientoInvima(int xt, String xfecha, String NFecha) {
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && xt == 0 && !this.xPaso) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Medicamento con fecha: " + xfecha + " de invima vencido.</p><font face='Arial' color='red' size=4>Favor revisar y actualizar.</html>";
            JOptionPane.showInternalMessageDialog(this, xmensaje, "VERIFICACIÓN DE VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void mVerificarMedicamento() {
        String xsql = "SELECT DATE_FORMAT(i_salidas.FechaSalida,'%d/%m/%Y') AS fecha, CONCAT(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS Nombre, i_detallesalida.CantidadDespachada, i_salidas.OrdenH, i_suministro.IdPrincipioActivo, i_salidas.Id FROM i_salidas INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id)  INNER JOIN persona  ON (persona.Id_persona = i_salidas.IdDestino) INNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (persona.Id_persona ='" + this.frmPersona.getIdPersona() + "'  AND i_salidas.FechaSalida >='" + this.metodos.formatoAMD.format(Metodos.mRestarFechasDias(this.metodos.getFechaActual(), 30)) + "' AND i_salidas.FechaSalida <='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "' AND i_salidas.Estado =0 and i_suministro.IdPrincipioActivo='" + getIdPrincipioActivo() + "') ORDER BY i_salidas.FechaSalida DESC ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Principio despachado en el ultimo mes,\nDesea visualizarlo?", "CONSULTAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xjifverficarpa = new JIFVerificacionPActivo(this.frmPersona.getIdPersona());
                    Principal.cargarPantalla(this.xjifverficarpa);
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mPedirProductoProveedor() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql = "SELECT Id FROM i_manejo_puntosr WHERE (entro=0 AND Id_Producto ='" + getXcodigoagrupacion() + "')";
            ResultSet xrs = xct.traerRs(xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                String xsql2 = "SELECT Id_Suministro , Id_Proveedores, PReposicion,Minimo, (Minimo-ROUND(" + this.txtExistenciaInventario.getValue() + "/i_suministro.CantidadUnidad)) AS CPedir  , valor  FROM i_reposiciones inner join i_suministro on i_reposiciones.Id_Suministro=i_suministro.Id WHERE (Id_Suministro ='" + getXcodigoagrupacion() + "' AND PReposicion <>0 AND Minimo <>0 AND P =1 AND ROUND(" + this.txtExistenciaInventario.getValue() + "/i_suministro.CantidadUnidad)<=PReposicion) ";
                ResultSet xrs1 = xct1.traerRs(xsql2);
                if (xrs1.next()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Producto en punto de reposicion;\nDesea agregarlo a pedido?", "Verificación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        String xsql3 = "insert into i_manejo_puntosr(Id_Producto , Id_Proveedor, Cantidad, Valor, Fecha, UsuarioS) values ('" + xrs1.getString(1) + "','" + xrs1.getString(2) + "','" + xrs1.getString(5) + "','" + xrs1.getString(6) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.consultas.ejecutarSQL(xsql3);
                        this.consultas.cerrarConexionBd();
                    }
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_Despacho_Formula_1", mparametros);
        }
    }

    private void buscarImprimirSiguienteOrden() {
        this.sql = "SELECT h_atencion.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) WHERE (h_ordenes.Id ='" + this.txtOrden.getText() + "')";
        String datos = this.consultas.traerDato(this.sql);
        this.sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, h_ordenes.EstaEntregada FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) WHERE (h_ordenes.Estado = 0 AND h_atencion.Id ='" + datos + "' AND h_ordenes.Id > '" + this.txtOrden.getText() + "') ORDER BY h_ordenes.FechaOrden ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            if (rs.getRow() > 0) {
                if (rs.getInt(3) == 2) {
                    JOptionPane.showInternalMessageDialog(this, "Esta Formula ya fue entregada", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    String orden = rs.getString(1);
                    String nota = "";
                    if (!rs.isLast()) {
                        rs.next();
                        nota = "Orden N° : " + rs.getString(1) + "  - - - Fecha Proxima Entrega : " + rs.getString(2);
                    }
                    this.metodos.impimirOrdenFormulaMedica(orden, "Farmacia", nota, Principal.usuarioSistemaDTO.getLogin(), 2);
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void buscarUltimoDespacho() {
        if (this.frmPersona.txtHistoria.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione un Usuario", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
            return;
        }
        try {
            this.sql = "SELECT i_salidas.Id, i_salidas.FechaSalida, CONCAT(`w_profesional`.NProfesional, ' - ', `w_profesional`.`Especialidad`) NProfesional, i_tiposmovimientos.Nbre FROM i_salidas INNER JOIN w_profesional ON (i_salidas.IdProfesional = w_profesional.Id_Persona) INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.IdDestino ='" + this.frmPersona.IdPersona + "' AND i_salidas.IdBodega ='" + this.claseInv.getIdBodega() + "' AND i_salidas.Destino = 0) GROUP BY i_salidas.Id ORDER BY i_salidas.Id DESC";
            ResultSet rs = this.consultas.traerRs(this.sql);
            if (rs.next()) {
                String tmp = this.frmPersona.txtHistoria.getText();
                nuevo();
                this.idDespacho = rs.getString(1);
                Principal.txtNo.setText(this.idDespacho);
                this.fecha = rs.getString(2);
                this.txtFecha.setDate(rs.getDate(2));
                this.cboProfesional.setSelectedItem(rs.getString(3));
                this.cboTipoMovimiento.setSelectedItem(rs.getString(4));
                this.frmPersona.txtHistoria.setText(tmp);
                this.frmPersona.buscar(2);
                rs.close();
                this.consultas.cerrarConexionBd();
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_detallesalida.Lote, i_detallesalida.FechaVencimiento, i_detallesalida.CantidadSolicitada, i_detallesalida.CantidadDespachada, i_detallesalida.ValorUnitario FROM i_detallesalida INNER JOIN i_suministro ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_detallesalida.IdSalida ='" + Principal.txtNo.getText() + "')";
                crearGrid();
                rs = this.consultas.traerRs(this.sql);
                while (rs.next()) {
                    Long valor = Long.valueOf(rs.getLong(10));
                    Long vrtotal = Long.valueOf(((long) rs.getInt(9)) * rs.getLong(10));
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString(6), this.filaGrid, 3);
                    this.modelo.setValueAt(rs.getString(7), this.filaGrid, 4);
                    this.modelo.setValueAt(rs.getString(8), this.filaGrid, 6);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(9)), this.filaGrid, 7);
                    this.modelo.setValueAt(valor, this.filaGrid, 8);
                    this.modelo.setValueAt(vrtotal, this.filaGrid, 9);
                    this.txtTotalFactura.setValue(Double.valueOf(Double.parseDouble(this.txtTotalFactura.getValue().toString()) + vrtotal.longValue()));
                    this.filaGrid++;
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "No se encontro Despacho para este Usuario", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiposmovimientos WHERE TipoMovimiento = 1 AND Bodega = '" + this.claseInv.getIdBodega() + "' AND Estado = 0 AND Despacho = 1 ORDER BY Nbre", this.listaTipoMovimiento, this.cboTipoMovimiento);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.listaProfesional = this.consultas.llenarComboyLista("SELECT Id_Persona, CONCAT(NProfesional, ' - ', `Especialidad`) NProfesional, IdEspecialidad FROM profesional1 ORDER BY NProfesional ASC", this.listaProfesional, this.cboProfesional, 3);
        this.cboProfesional.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.listaEps = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_empresacontxconvenio WHERE (Estado =0) ORDER BY Nbre ASC", this.listaEps, this.cboEps);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarDatosDelLote() {
        Double cant = this.listaLote.get(this.cboLote.getSelectedIndex()).getCantidad();
        System.out.println("Cantidad  : " + cant);
        this.idLote = this.listaLote.get(this.cboLote.getSelectedIndex()).getIdSumnistroBodega().toString();
        this.txtVencimiento.setText(this.listaLote.get(this.cboLote.getSelectedIndex()).getFechaVencimiento());
        this.txtValorUnidad.setValue(this.listaLote.get(this.cboLote.getSelectedIndex()).getValor());
        this.txtExistencia.setValue(cant);
        if (this.modelo != null && this.modelo.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.modelo.getRowCount()) {
                    break;
                }
                if (!this.modelo.getValueAt(i, 1).equals(this.txtCodigo.getText()) || !this.modelo.getValueAt(i, 3).equals(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote())) {
                    i++;
                } else {
                    cant = Double.valueOf(cant.doubleValue() - Double.parseDouble(this.modelo.getValueAt(i, 7).toString()));
                    if (this.listaLote.get(this.cboLote.getSelectedIndex()).getCantidad().doubleValue() < 1.0d) {
                        this.listaLote.get(this.cboLote.getSelectedIndex()).setCantidad(new Double(0.0d));
                    }
                }
            }
        }
        this.idLote = this.listaLote.get(this.cboLote.getSelectedIndex()).getIdSumnistroBodega().toString();
        this.txtVencimiento.setText(this.listaLote.get(this.cboLote.getSelectedIndex()).getFechaVencimiento());
        this.txtValorUnidad.setValue(this.listaLote.get(this.cboLote.getSelectedIndex()).getValor());
        this.txtExistencia.setValue(cant);
        if (cant.doubleValue() == 0.0d) {
            this.txtEntregada.setValue(0);
        } else {
            this.txtEntregada.setValue(1);
        }
        this.txtValorTotal.setValue(this.txtValorUnidad.getValue());
    }

    public void cargarDespacho() {
        this.idDespacho = Principal.txtNo.getText();
        this.fecha = Principal.txtFecha.getText();
        this.estado = Principal.txtEstado.getText();
        this.sql = "SELECT IdSalida, i_detallesalida.IdSuministro, i_suministro.CodBarraUnidad, i_suministro.Nbre as Producto, i_presentacioncomercial.Nbre as Presentacion, Lote, i_detallesalida.FechaVencimiento as Vencimiento, i_detallesalida.CantidadSolicitada as Solicitada, i_detallesalida.CantidadDespachada as Despachada, i_detallesalida.ValorUnitario as VrUnidad, i_suministroxbodega.Id, if(i_detallesalida.Observacion is null, '',i_detallesalida.Observacion) as Observacion  FROM  i_detallesalida  INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxbodega  ON (i_detallesalida.IdSuministro= i_suministroxbodega.IdSuministro) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) WHERE (IdSalida = '" + this.idDespacho + "' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString("IdSalida"), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString("IdSuministro"), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Producto") + " - " + rs.getString("Presentacion"), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString("Lote"), this.filaGrid, 3);
                this.modelo.setValueAt(this.metodos.formatoAMD.format((Date) rs.getDate("Vencimiento")), this.filaGrid, 4);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt("Solicitada")), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt("Despachada")), this.filaGrid, 7);
                this.modelo.setValueAt(Double.valueOf(rs.getDouble("VrUnidad")), this.filaGrid, 8);
                this.modelo.setValueAt(Double.valueOf(((double) rs.getInt("Despachada")) * rs.getDouble("VrUnidad")), this.filaGrid, 9);
                this.modelo.setValueAt(rs.getString(11), this.filaGrid, 11);
                this.modelo.setValueAt(rs.getString("Observacion"), this.filaGrid, 14);
                this.txtTotalFactura.setValue(Double.valueOf(Double.parseDouble(this.txtTotalFactura.getValue().toString()) + (((double) rs.getInt("Despachada")) * rs.getDouble("VrUnidad"))));
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void cargarGrid() {
        if (this.cboLote.getSelectedIndex() < 0) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione un Lote", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboLote.requestFocus();
            return;
        }
        if (Double.valueOf(this.txtValorUnidad.getText()).doubleValue() <= 0.0d && !this.cboLote.getSelectedItem().toString().contains("FALTANTE")) {
            JOptionPane.showInternalMessageDialog(this, "El valor unitario debe ser mayor que cero", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboLote.requestFocus();
            return;
        }
        if (this.xcfechav == 1) {
            JOptionPane.showInternalMessageDialog(this, "Medicamentos y/o dispositivo medico vencido;\nFavor verificar", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            return;
        }
        this.metodos.mEstablecerTextEditor(this.grid, 2);
        this.filaGrid = this.grid.getRowCount();
        int encontrado = 0;
        double Existencia = 0.0d;
        double Solicitado = 0.0d;
        int i = 0;
        while (true) {
            if (i < this.modelo.getRowCount()) {
                if (!this.modelo.getValueAt(i, 1).equals(this.txtCodigo.getText()) || !this.modelo.getValueAt(i, 3).toString().equals(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote())) {
                    i++;
                } else {
                    encontrado = 1;
                    this.filaGrid = i;
                    Solicitado = Double.parseDouble(this.modelo.getValueAt(i, 6).toString());
                    Existencia = Double.parseDouble(this.modelo.getValueAt(i, 7).toString());
                    break;
                }
            } else {
                break;
            }
        }
        double xcpendiente = 0.0d;
        if (this.listaLote.get(this.cboLote.getSelectedIndex()).getCantidadPendiente().doubleValue() != 0.0d) {
            int x = JOptionPane.showInternalConfirmDialog(this, "El medicamento a descargar es de un faltante?", "CONFIRMAR DESPACHO DE FALTANTE", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                xcpendiente = Double.parseDouble(this.txtEntregada.getValue().toString());
            } else {
                xcpendiente = 0.0d;
            }
        }
        if (Double.parseDouble(this.txtEntregada.getValue().toString()) + Existencia > Double.parseDouble(this.txtExistencia.getValue().toString()) && !this.cboLote.getSelectedItem().toString().substring(0, 8).equals("FALTANTE")) {
            JOptionPane.showInternalMessageDialog(this, "La cantidad que saldrá del Producto es mayor al Inventario del Lote\nPor tanto se disminuirá la Entrega solo a la Cantidad existente", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtEntregada.setValue(this.txtExistencia.getValue());
        }
        verificarSiTieneMedicamentosVigentesEnConsumo();
        if (encontrado == 0) {
            this.modelo.addRow(this.dato);
        }
        this.filaGrid = this.grid.getRowCount() - 1;
        buscarAlertas();
        this.modelo.setValueAt(this.idProducto, this.filaGrid, 0);
        this.modelo.setValueAt(this.txtCodigo.getText(), this.filaGrid, 1);
        this.modelo.setValueAt(this.txtProducto.getText(), this.filaGrid, 2);
        this.modelo.setValueAt(this.listaLote.get(this.cboLote.getSelectedIndex()).getLote(), this.filaGrid, 3);
        this.modelo.setValueAt(this.txtVencimiento.getText(), this.filaGrid, 4);
        this.modelo.setValueAt(this.txtExistencia.getValue(), this.filaGrid, 5);
        Double cantidaEntregada = Double.valueOf(Double.parseDouble(this.txtEntregada.getValue().toString() == null ? "0" : this.txtEntregada.getValue().toString()));
        this.modelo.setValueAt(Double.valueOf(((double) Integer.parseInt(this.txtSolicitada.getValue().toString() == null ? "0" : this.txtSolicitada.getValue().toString())) + Solicitado), this.filaGrid, 6);
        this.modelo.setValueAt(cantidaEntregada, this.filaGrid, 7);
        this.modelo.setValueAt(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)), this.filaGrid, 8);
        this.modelo.setValueAt(Double.valueOf(Double.parseDouble(this.txtValorUnidad.getValue().toString()) * cantidaEntregada.doubleValue()), this.filaGrid, 9);
        this.txtTotalFactura.setValue(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtTotalFactura.getValue().toString()) + (Double.parseDouble(this.txtValorUnidad.getValue().toString()) * cantidaEntregada.doubleValue()), 2)));
        this.modelo.setValueAt(this.cantxUnidad, this.filaGrid, 10);
        this.modelo.setValueAt(this.xIdProductoB, this.filaGrid, 11);
        this.modelo.setValueAt(Double.valueOf(xcpendiente), this.filaGrid, 12);
        this.modelo.setValueAt(true, this.filaGrid, 13);
        this.modelo.setValueAt("", this.filaGrid, 14);
        this.modelo.setValueAt(false, this.filaGrid, 15);
        this.grid.setDefaultRenderer(Object.class, new MiRender());
        limpiarDatosProductos();
        this.txtCodigo.requestFocus();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/Despachos$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            try {
                Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 15).toString());
                if (nvalidacion.booleanValue()) {
                    cell.setBackground(Color.RED);
                    cell.setForeground(Color.white);
                } else {
                    cell.setBackground(Color.white);
                    cell.setForeground(Color.BLACK);
                }
            } catch (Exception e) {
            }
            return cell;
        }
    }

    private void mActualizarEstadoPendiente() {
        if (Integer.valueOf(this.JSPNPendiente.getValue().toString()).intValue() != 0) {
            this.sql = "update i_faltantes set EntregadoCompleto=1, IdSalida='" + Principal.txtNo.getText() + "' where Id ='" + this.JSPNPendiente.getValue() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void mActualizarIdSalida_Unidosis(String xidSuministro) {
        if (this.xidunidosis != 0) {
            this.sql = "update h_ordenes_unidosis_detalle set Id_Salida='" + Principal.txtNo.getText() + "', usuario='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE  `h_ordenes_unidosis_detalle`.`Id_Suministro` ='" + xidSuministro + "' and Id_Ordenes='" + this.xidunidosis + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void mActualizarIdSalida_Cirugia() {
        if (this.xidunidosis != 0 && this.xCerrar == 1) {
            this.sql = "update q_procedsuministro set Id_Salida='" + Principal.txtNo.getText() + "' WHERE Id_AgendaCX='" + this.xidunidosis + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void mBuscarInsumoUnidosis() {
        Double cantidadTotal;
        try {
            if (this.xFiltro) {
                this.xsql = "SELECT `profesional1`.`Especialidad`, CONCAT(`profesional1`.NProfesional, ' - ', `profesional1`.`Especialidad`) NProfesional, `f_empresacontxconvenio`.`Nbre` , `h_ordenes_unidosis_detalle`.`Id_Suministro` , sum(`h_ordenes_unidosis_detalle`.`Cantidad`)Cantidad FROM  `h_ordenes_unidosis_detalle` INNER JOIN `h_ordenes_unidosis`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_ordenes_unidosis`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_ordenes_unidosis`.`Id_Profesional`) INNER JOIN `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN i_suministro  ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) WHERE (`h_ordenes_unidosis`.`Estado` =1 AND h_ordenes_unidosis_detalle.`Id_Salida` =0 AND `h_ordenes_unidosis`.`Id` ='" + this.xidunidosis + "' and i_suministro.`EsMaterial` = '" + this.xTipoProducto + "') group by  `h_ordenes_unidosis_detalle`.`Id_Suministro`";
            } else {
                this.xsql = "SELECT `profesional1`.`Especialidad`, CONCAT(`profesional1`.NProfesional, ' - ', `profesional1`.`Especialidad`) NProfesional, `f_empresacontxconvenio`.`Nbre` , `h_ordenes_unidosis_detalle`.`Id_Suministro` ,  sum(`h_ordenes_unidosis_detalle`.`Cantidad`)Cantidad  FROM  `h_ordenes_unidosis_detalle` INNER JOIN `h_ordenes_unidosis`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_ordenes_unidosis`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_ordenes_unidosis`.`Id_Profesional`) INNER JOIN `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) WHERE (`h_ordenes_unidosis`.`Estado` =1 AND h_ordenes_unidosis_detalle.`Id_Salida` =0 AND `h_ordenes_unidosis`.`Id` ='" + this.xidunidosis + "')  group by   `h_ordenes_unidosis_detalle`.`Id_Suministro` ";
            }
            System.out.println("BUSCA INSUMO UNIDOSIS: " + this.xsql);
            ResultSet xrs = this.consultas.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    this.cboTipoMovimiento.setSelectedIndex(-1);
                    this.cboProfesional.setSelectedItem(xrs.getString(2));
                    this.cboEps.setSelectedItem(xrs.getString(3));
                    xrs.first();
                    new Double(0.0d);
                    xrs.beforeFirst();
                    this.filaGrid = 0;
                    while (xrs.next()) {
                        Double xcantidad = Double.valueOf(xrs.getDouble(5));
                        List<IInformacionOrdenMedicaSuministro> medicaSuministro = this.claseInv.listItemOrdenMedica(this.metodos.getFechaActual(), this.claseInv.getListaIdBodega(), Long.valueOf(xrs.getLong(4)), xcantidad);
                        if (!medicaSuministro.isEmpty()) {
                            for (IInformacionOrdenMedicaSuministro next : medicaSuministro) {
                                Double cantidadTotal2 = new Double(0.0d);
                                this.modelo.addRow(this.dato);
                                this.modelo.setValueAt(next.getIdSuministro(), this.filaGrid, 0);
                                this.modelo.setValueAt(next.getCodigoBarra(), this.filaGrid, 1);
                                this.modelo.setValueAt(next.getNombreSuministro(), this.filaGrid, 2);
                                this.modelo.setValueAt(next.getLote(), this.filaGrid, 3);
                                this.modelo.setValueAt(next.getFechaVencimiento(), this.filaGrid, 4);
                                this.modelo.setValueAt(next.getCantidadInventario(), this.filaGrid, 5);
                                this.modelo.setValueAt(xcantidad, this.filaGrid, 6);
                                if (next.getCantidadInventario().compareTo(xcantidad) < 0) {
                                    this.modelo.setValueAt(next.getCantidadInventario(), this.filaGrid, 7);
                                    cantidadTotal = Double.valueOf(cantidadTotal2.doubleValue() + xcantidad.doubleValue());
                                } else {
                                    this.modelo.setValueAt(xcantidad, this.filaGrid, 7);
                                    cantidadTotal = Double.valueOf(cantidadTotal2.doubleValue() + next.getCantidadInventario().doubleValue());
                                }
                                this.modelo.setValueAt(next.getValorUnitario(), this.filaGrid, 8);
                                this.modelo.setValueAt(Double.valueOf(next.getValorUnitario().doubleValue() * Double.valueOf(this.modelo.getValueAt(this.filaGrid, 7).toString()).doubleValue()), this.filaGrid, 9);
                                this.modelo.setValueAt(next.getCantidadUnidad(), this.filaGrid, 10);
                                this.modelo.setValueAt(next.getIdSuministroBodega(), this.filaGrid, 11);
                                this.modelo.setValueAt(next.getCantidadPendiente(), this.filaGrid, 12);
                                this.modelo.setValueAt(true, this.filaGrid, 13);
                                this.modelo.setValueAt("", this.filaGrid, 14);
                                this.modelo.setValueAt(false, this.filaGrid, 15);
                                this.filaGrid++;
                                if (next.getCantidadEntregada().compareTo(xcantidad) == 0) {
                                    break;
                                }
                                xcantidad = Double.valueOf(xcantidad.doubleValue() - next.getCantidadEntregada().doubleValue());
                                if (cantidadTotal.doubleValue() == xrs.getDouble(5)) {
                                    break;
                                }
                            }
                        }
                    }
                    mTotalizarOrden();
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.consultas.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarSuministroCirugia() {
        try {
            if (this.xFiltro) {
                this.xsql = "SELECT `profesional1`.`Especialidad`, CONCAT(`profesional1`.NProfesional, ' - ', `profesional1`.`Especialidad`) NProfesional, `f_empresacontxconvenio`.`Nbre` , `q_procedsuministro`.`Id_Suministro` , `q_procedsuministro`.`Cantidad` \nFROM  `q_procedsuministro` INNER JOIN `q_agendacx`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \nINNER JOIN `f_empresacontxconvenio`  ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN i_suministro  ON (`q_procedsuministro`.`Id_Suministro` = `i_suministro`.`Id`) WHERE (`q_procedsuministro`.`Estado` =1 AND `q_procedsuministro`.`Id_AgendaCX` ='" + this.xidunidosis + "' AND i_suministro.`EsMaterial` = '" + this.xTipoProducto + "') ";
            } else {
                this.xsql = "SELECT `profesional1`.`Especialidad`, CONCAT(`profesional1`.NProfesional, ' - ', `profesional1`.`Especialidad`) NProfesional, `f_empresacontxconvenio`.`Nbre` , `q_procedsuministro`.`Id_Suministro` , `q_procedsuministro`.`Cantidad` \nFROM  `q_procedsuministro` INNER JOIN `q_agendacx`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \n INNER JOIN `f_empresacontxconvenio`  ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nWHERE (`q_procedsuministro`.`Estado` =1 AND `q_procedsuministro`.`Id_AgendaCX` ='" + this.xidunidosis + "') ";
            }
            ResultSet xrs = this.consultas.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    this.cboTipoMovimiento.setSelectedIndex(0);
                    this.cboProfesional.setSelectedItem(xrs.getString(2));
                    this.cboEps.setSelectedItem(xrs.getString(3));
                    xrs.first();
                    xrs.beforeFirst();
                    this.filaGrid = 0;
                    while (xrs.next()) {
                        long xcantidad = xrs.getLong(5);
                        ConsultasMySQL xct = new ConsultasMySQL();
                        this.xsql = "SELECT `i_suministroxbodega`.`IdSuministro`, `i_suministro`.`CodBarraUnidad`, CONCAT(`i_suministro`.`Nbre`,' ',`i_presentacionfarmaceutica`.`Nbre`,' ', `i_laboratorio`.`Nbre`) AS `NProducto` , `i_suministroxlotexbodega`.`Lote` , `i_suministroxlotexbodega`.`FechaVencimiento` , `i_suministroxlotexbodega`.`Cantidad` , " + xcantidad + " AS `CSolicitada` , IF(" + xcantidad + "<=`i_suministroxlotexbodega`.`Cantidad`, " + xcantidad + ", `i_suministroxlotexbodega`.`Cantidad`) AS `CEntregada` , `i_suministroxbodega`.`Costo` AS `VUnitario` , round((`i_suministroxbodega`.`Costo`*IF(" + xcantidad + "<=`i_suministroxlotexbodega`.`Cantidad`, " + xcantidad + ", `i_suministroxlotexbodega`.`Cantidad`))) AS `VTotal` , `i_suministro`.`CantidadUnidad` , `i_suministroxlotexbodega`.`Id` AS SB, 0 AS `CPendiente` FROM  `i_suministroxbodega` INNER JOIN `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (`i_suministroxbodega`.`IdBodega` ='" + this.claseInv.getIdBodega() + "' AND `i_suministroxbodega`.`IdSuministro` ='" + xrs.getLong(4) + "' AND `i_suministroxlotexbodega`.`Cantidad` >0) ORDER BY `i_suministroxlotexbodega`.`FechaVencimiento` asc ";
                        ResultSet xrs1 = xct.traerRs(this.xsql);
                        if (xrs1.next()) {
                            xrs1.beforeFirst();
                            while (xrs1.next()) {
                                this.modelo.addRow(this.dato);
                                this.modelo.setValueAt(Long.valueOf(xrs1.getLong(1)), this.filaGrid, 0);
                                this.modelo.setValueAt(xrs1.getString(2), this.filaGrid, 1);
                                this.modelo.setValueAt(xrs1.getString(3), this.filaGrid, 2);
                                this.modelo.setValueAt(xrs1.getString(4), this.filaGrid, 3);
                                this.modelo.setValueAt(xrs1.getString(5), this.filaGrid, 4);
                                this.modelo.setValueAt(Long.valueOf(xrs1.getLong(6)), this.filaGrid, 5);
                                this.modelo.setValueAt(Long.valueOf(xcantidad), this.filaGrid, 6);
                                if (xrs1.getLong(6) >= xcantidad) {
                                    this.modelo.setValueAt(Long.valueOf(xcantidad), this.filaGrid, 7);
                                } else {
                                    this.modelo.setValueAt(Long.valueOf(xrs1.getLong(6)), this.filaGrid, 7);
                                }
                                this.modelo.setValueAt(Double.valueOf(xrs1.getDouble(9)), this.filaGrid, 8);
                                this.modelo.setValueAt(Double.valueOf(xrs1.getDouble(9) * Double.valueOf(this.modelo.getValueAt(this.filaGrid, 7).toString()).doubleValue()), this.filaGrid, 9);
                                this.modelo.setValueAt(Long.valueOf(xrs1.getLong(11)), this.filaGrid, 10);
                                this.modelo.setValueAt(Long.valueOf(xrs1.getLong(12)), this.filaGrid, 11);
                                this.modelo.setValueAt(Long.valueOf(xrs1.getLong(13)), this.filaGrid, 12);
                                this.modelo.setValueAt(true, this.filaGrid, 13);
                                this.filaGrid++;
                                if (xrs1.getLong(8) == xcantidad) {
                                    break;
                                } else {
                                    xcantidad -= xrs1.getLong(8);
                                }
                            }
                        }
                        xrs1.close();
                        xct.cerrarConexionBd();
                    }
                    mTotalizarOrden();
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.consultas.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTotalizarOrden() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            xvalor += Double.valueOf(this.modelo.getValueAt(x, 9).toString()).doubleValue();
        }
        this.txtTotalFactura.setValue(Double.valueOf(xvalor));
    }

    public void cargarLote(List<IInformacionInventario> informacionInventarios) {
        this.cboLlenoLote = 0;
        this.listaLote = this.claseInv.cargarLote(this.cboLote, this.listaLote, informacionInventarios);
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtExistencia.setValue(0);
        this.cboLlenoLote = 1;
    }

    private void cargarPanelPersona() {
        if (this.frmPersona == null) {
            this.frmPersona = new Persona(this);
        }
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 928, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
        this.frmPersona.setBackground(new Color(185, 205, 181));
        this.frmPersona.JPDPersonales.setBackground(new Color(185, 205, 181));
        this.frmPersona.JPDAdicionales.setBackground(new Color(185, 205, 181));
    }

    public final void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Lote", "Vencimiento", "Existencia", "Solicitado", "Entregado", "Vr. Unidad", "Vr. Total", "Cant. Unidad", "", "CPendiente", "D", "Observación", "validacionE", "StockMinimo"}) { // from class: Inventarios.Despachos.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Integer.class, String.class, Integer.class, Boolean.class, String.class, Boolean.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setMinWidth(0);
        this.grid.getColumnModel().getColumn(11).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(15).setMinWidth(0);
        this.grid.getColumnModel().getColumn(15).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(16).setMinWidth(0);
        this.grid.getColumnModel().getColumn(16).setMaxWidth(0);
        this.filaGrid = 0;
    }

    public void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de quitar el Producto de la Entrada?") == 0) {
            this.modelo.removeRow(this.filaGrid);
            this.filaGrid--;
        }
    }

    private void entregarValores() {
        if (this.txtCodigo.getText().isEmpty()) {
            return;
        }
        if (Double.parseDouble(this.txtEntregada.getValue().toString()) > Double.parseDouble(this.txtExistencia.getValue().toString())) {
            JOptionPane.showInternalMessageDialog(this, "La Cantidad que se entrega no puede ser superior a la solicitada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            try {
                this.txtEntregada.setValue(this.txtExistencia.getValue().toString());
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        if (Integer.parseInt(this.txtEntregada.getValue().toString()) > Integer.parseInt(this.txtSolicitada.getValue().toString())) {
            JOptionPane.showInternalMessageDialog(this, "La Cantidad que se Entrega no puede ser Superior a la Solicitada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtEntregada.setValue(this.txtSolicitada.getValue());
            return;
        }
        if (this.txtSolicitada.getValue() != null && this.txtEntregada.getValue() != null) {
            System.out.println("solicitado: " + this.txtSolicitada.getValue());
            System.out.println("entregado: " + this.txtEntregada.getValue());
            this.txtFaltante.setValue(Integer.valueOf(Integer.parseInt(this.txtSolicitada.getValue().toString()) - Integer.parseInt(this.txtEntregada.getValue().toString())));
            if (Integer.parseInt(this.txtEntregada.getValue().toString()) > 0 && this.txtValorUnidad.getValue() != null && Double.parseDouble(this.txtValorUnidad.getValue().toString()) > 0.0d) {
                this.txtFaltante.setValue(Integer.valueOf(Integer.parseInt(this.txtSolicitada.getValue().toString()) - Integer.parseInt(this.txtEntregada.getValue().toString())));
                this.txtValorTotal.setValue(Double.valueOf(this.metodos.redondear(Double.parseDouble(this.txtEntregada.getValue().toString()) * Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)));
            }
        }
    }

    public void grabar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Por favor presione el Botón nuevo para solicitar una nueva Entrada", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.cboTipoMovimiento.getSelectedIndex() < 0) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Tipo de Movimiento", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboTipoMovimiento.requestFocus();
            return;
        }
        if (this.modelo.getRowCount() < 1) {
            JOptionPane.showInternalMessageDialog(this, "Por favor digite los Productos que Despachará.", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtCodigo.requestFocus();
            return;
        }
        if (this.frmPersona.IdPersona == null) {
            JOptionPane.showInternalMessageDialog(this, "Por Favor seleccione el Usuario a quien se despachará.", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.frmPersona.txtHistoria.requestFocus();
            return;
        }
        if (this.txtOrden.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Por Favor digite el Número de Orden del Usuario a quien se despachará.", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtOrden.requestFocus();
            return;
        }
        if (this.cboEps.getSelectedIndex() < 0) {
            JOptionPane.showInternalMessageDialog(this, "Por Favor seleccione la Empresa por la cual se Despachará.", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboEps.requestFocus();
            return;
        }
        if (this.frmPersona.validarDatos(1) == 1) {
            if (this.claseInv.getXidperiodoc() != -1) {
                this.frmPersona.grabar();
                grabarCabeceraDespacho();
                int faltante = 0;
                int cabeceraFaltante = 0;
                for (int x = 0; x < this.modelo.getRowCount(); x++) {
                    if (this.metodos.mVerificarDatosTablaTrue(this.grid, 13)) {
                        grabarDetalleSalida(x);
                        mActualizarEstadoPendiente();
                        this.claseInv.mActualizarFechaRotacion(Long.valueOf(this.modelo.getValueAt(x, 11).toString()).longValue());
                        if (this.xidunidosis == 0 && Double.parseDouble(this.modelo.getValueAt(x, 6).toString()) != Double.parseDouble(this.modelo.getValueAt(x, 7).toString())) {
                            if (cabeceraFaltante == 0) {
                                faltante = grabarCabeceraFaltante();
                                cabeceraFaltante = 1;
                                this.txtNoFaltante.setText(String.valueOf(faltante));
                            }
                            grabarDetalleFaltante(faltante, x);
                        }
                        if (this.xllamador.equals("JIFIAgenda_Cirugia")) {
                            mActualizarIdSalida_Cirugia();
                        } else {
                            mActualizarIdSalida_Unidosis(this.modelo.getValueAt(x, 0).toString());
                        }
                    }
                }
                grabarOrden();
                if (faltante > 0) {
                    String[][] parametros = new String[5][2];
                    parametros[0][0] = "faltante";
                    parametros[0][1] = this.txtNoFaltante.getText();
                    parametros[1][0] = "nbreUsuario";
                    parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    parametros[2][0] = "ruta";
                    parametros[2][1] = this.metodos.getRutaRep();
                    parametros[3][0] = "SUBREPORT_DIR";
                    parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                    parametros[4][0] = "SUBREPORTFIRMA_DIR";
                    parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                    String nbreArchivo = this.metodos.getRutaRep() + "I_PendientesxDespacho";
                    this.metodos.GenerarPDF(nbreArchivo, parametros);
                    this.consultas.cerrarConexionBd();
                }
                if (this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()].equals("100") || this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()].equals("18") || this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()].equals("93") || this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()].equals("94") || this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()].equals("95")) {
                    String[][] parametros2 = new String[4][2];
                    parametros2[0][0] = "Id";
                    parametros2[0][1] = Principal.txtNo.getText();
                    parametros2[1][0] = "UsuarioS";
                    parametros2[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    parametros2[2][0] = "SUBREPORT_DIR";
                    parametros2[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                    parametros2[3][0] = "SUBREPORTFIRMA_DIR";
                    parametros2[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_Nota_Cargo", parametros2);
                }
                cargarFormularioFacturacion(this.idDespacho);
                this.grabada = 1;
                mImprimir();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen periodos abiertos, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    public void cargarFormularioFacturacion(String idDespacho) {
        if (Principal.informacionIps.getAplicaFacturacionDespacho().booleanValue()) {
            this.claseInv.iniciarDatosFacturacion(idDespacho, this.frmPersona.txtHistoria.getText());
        }
    }

    private boolean hayExistencias() {
        boolean resul = true;
        this.existenciaReal = 0.0d;
        for (int x = 0; x < this.modelo.getRowCount(); x++) {
            this.sql = "SELECT\n  i_suministro.Id,\n  SUM(\n    i_suministroxlotexbodega.Cantidad\n  ) AS Cantidad\n, i_suministro.CodBarraUnidad  FROM\n  i_suministro\n  INNER JOIN i_laboratorio\n    ON (\n      i_suministro.IdLaboratorio = i_laboratorio.Id\n    )\n  INNER JOIN i_suministroxbodega\n    ON (\n      i_suministroxbodega.IdSuministro = i_suministro.Id\n    )\n  INNER JOIN i_suministroxlotexbodega\n    ON (\n      i_suministroxlotexbodega.Id = i_suministroxbodega.Id\n    )\n  \nWHERE (\n    i_suministro.EstaActivo = 1\n    AND i_suministro.Id = " + this.modelo.getValueAt(x, 0) + "    AND i_suministroxlotexbodega.`Lote` = '" + this.modelo.getValueAt(x, 3) + "'    AND i_suministroxbodega.IdBodega = '" + this.claseInv.getIdBodega() + "'\n  )\nGROUP BY i_suministroxbodega.IdSuministro\nORDER BY i_suministro.CodBarraUnidad,\n  i_suministro.Nbre";
            try {
                ResultSet xrs1 = this.consultas.traerRs(this.sql);
                if (xrs1.next()) {
                    xrs1.beforeFirst();
                    while (xrs1.next()) {
                        this.existenciaReal = xrs1.getDouble(2);
                        if (this.existenciaReal >= Double.valueOf(this.modelo.getValueAt(x, 7).toString()).doubleValue()) {
                            this.productosSinExistencia += " " + xrs1.getString(3);
                            resul = false;
                            this.modelo.setValueAt(false, x, 15);
                        } else {
                            this.modelo.setValueAt(true, x, 15);
                        }
                    }
                }
            } catch (SQLException e) {
            }
        }
        return resul;
    }

    private void grabarCabeceraDespacho() {
        this.sql = "INSERT INTO i_salidas(IdTipoMovimiento, IdBodega, FechaSalida, Destino, Id_Periodo, IdDestino, Eps, IdProfesional, IdEspecialidad, OrdenH,Id_Ingreso, Fecha, UsuarioS , IdUsuarioR) VALUES ('" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()] + "','" + this.claseInv.getIdBodega() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','0','" + this.claseInv.getXidperiodoc() + "','" + this.frmPersona.IdPersona + "','" + this.listaEps[this.cboEps.getSelectedIndex()] + "','" + getIdProfesional() + "','" + getIdEspecialidad() + "','" + this.txtOrden.getText() + "','" + this.xIdIngreso + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
        this.idDespacho = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.idDespacho);
        this.consultas.cerrarConexionBd();
    }

    private int grabarCabeceraFaltante() {
        this.sql = "INSERT INTO i_faltantes(IdSalida, Fecha, UsuarioS) VALUES ('" + this.idDespacho + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String falta = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        return Integer.parseInt(falta);
    }

    private void grabarDetalleFaltante(int faltante, int fila) {
        this.sql = "INSERT INTO i_detallefaltante(IdFaltante, IdSuministro, Cantidad) VALUES ('" + faltante + "','" + this.modelo.getValueAt(fila, 0) + "','" + (Double.parseDouble(this.modelo.getValueAt(fila, 6).toString()) - Double.parseDouble(this.modelo.getValueAt(fila, 7).toString())) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalleSalida(int fila) {
        this.sql = "INSERT INTO i_detallesalida(IdSalida, IdSuministro, Lote, CantidadSolicitada, CantidadDespachada, ValorUnitario, FechaVencimiento, Observacion) VALUES ('" + this.idDespacho + "','" + this.modelo.getValueAt(fila, 0) + "','" + this.modelo.getValueAt(fila, 3) + "','" + this.modelo.getValueAt(fila, 6) + "','" + this.modelo.getValueAt(fila, 7) + "','" + this.modelo.getValueAt(fila, 8) + "','" + this.modelo.getValueAt(fila, 4) + "','" + this.modelo.getValueAt(fila, 14) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabarOrden() {
        this.sql = "UPDATE h_ordenes SET  EstaEntregada = 2 WHERE (Id = " + this.txtOrden.getText() + ")";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void limpiarDatosProductos() {
        this.xPaso = false;
        this.cboLote.removeAllItems();
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.cboLote.setSelectedIndex(-1);
        this.txtVencimiento.setText("");
        this.txtSolicitada.setValue(1);
        this.txtEntregada.setValue(1);
        this.txtFaltante.setValue(0);
        this.txtValorUnidad.setValue(0);
        this.txtValorTotal.setValue(0);
        this.txtExistencia.setValue(0);
        this.txtExistenciaInventario.setValue(0);
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        Principal.mLimpiarDatosP();
        limpiarDatosProductos();
        crearGrid();
        this.grabada = 0;
        this.filaGrid = 0;
        this.txtOrden.setText("0");
        this.idDespacho = "0";
        this.estado = "";
        this.fecha = "";
        this.xidIngreso = "0";
        this.JBTEventoAdverso.setEnabled(false);
        this.txtNoFaltante.setText("0");
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtTotalFactura.setValue(0);
        this.cboTipoMovimiento.requestFocus();
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.JSPNPendiente.setValue(new Integer(0));
        this.frmPersona.txtHistoria.requestFocus();
    }

    private void verificarSiTieneMedicamentosVigentesEnConsumo() {
        this.sql = "SELECT DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m/%Y'), concat(i_suministro.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ',i_concentracion.Nbre,' ',i_presentacioncomercial.Nbre)as NSuministro  , h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, w_profesional.NProfesional, h_tipoformula.Nbre,DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion AS DURACION FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN h_tipoformula  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN w_profesional  ON (w_profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (h_ordenes.Estado =0 AND i_principioactivo.Id ='" + this.idPrincipioActivo + "' AND ingreso.Id_Usuario ='" + this.frmPersona.getIdPersona() + "' AND (DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion)>0) ORDER BY h_ordenes.FechaOrden DESC ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                JOptionPane.showInternalMessageDialog(this, "El Usuario aún tiene el tratamiento con el medicamento vigente\nEn la orden anterior se prescibió lo siguiente:\nFecha : " + rs.getString(1) + "\nProducto : " + rs.getString(2) + "\nPosología Manual : " + rs.getString(3) + "\nDuración : " + rs.getString(4) + "\nCantidad : " + rs.getString(5) + "\nProfesional que Prescibió : " + rs.getString(6) + "\nTipo de Formula : " + rs.getString(7) + "\n", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.panelDatosSalida = new JPanel();
        this.txtFecha = new JDateChooser();
        this.cboTipoMovimiento = new JComboBox();
        this.txtOrden = new JTextField();
        this.cboProfesional = new JComboBox();
        this.cboEps = new JComboBox();
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
        this.txtSolicitada = new JSpinner();
        this.txtEntregada = new JSpinner();
        this.txtFaltante = new JFormattedTextField();
        this.panelPrecios = new JPanel();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.txtProducto = new JTextField();
        this.btnBuscarProducto = new JButton();
        this.JSPNPendiente = new JSpinner();
        this.panelPersona = new JPanel();
        this.txtNoFaltante = new JFormattedTextField();
        this.txtTotalFactura = new JFormattedTextField();
        this.btnBuscarUltimoDespacho = new JButton();
        this.JBTEventoAdverso = new JButton();
        this.jCheckBox1 = new JCheckBox();
        this.JBT_Facturacion = new JButton();
        setBackground(new Color(185, 205, 181));
        setClosable(true);
        setIconifiable(true);
        setTitle("DESPACHO DE PRODUCTOS Y SUMINISTROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1200, 796));
        setMinimumSize(new Dimension(1200, 796));
        setName("Despachos");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.Despachos.4
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Despachos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                Despachos.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.panelDatosSalida.setBackground(new Color(185, 205, 181));
        this.panelDatosSalida.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DATOS DEL DESPACHO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 102)));
        this.panelDatosSalida.setForeground(new Color(204, 255, 204));
        this.panelDatosSalida.setLayout((LayoutManager) null);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.panelDatosSalida.add(this.txtFecha);
        this.txtFecha.setBounds(20, 30, 110, 50);
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.5
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.panelDatosSalida.add(this.cboTipoMovimiento);
        this.cboTipoMovimiento.setBounds(260, 30, 260, 50);
        this.txtOrden.setFont(new Font("Arial", 1, 12));
        this.txtOrden.setHorizontalAlignment(0);
        this.txtOrden.setText("0");
        this.txtOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. de Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtOrden.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.6
            public void focusGained(FocusEvent evt) {
                Despachos.this.txtOrdenFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Despachos.this.txtOrdenFocusLost(evt);
            }
        });
        this.txtOrden.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.7
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.txtOrdenActionPerformed(evt);
            }
        });
        this.panelDatosSalida.add(this.txtOrden);
        this.txtOrden.setBounds(140, 30, 110, 50);
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.cboProfesional.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.8
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.cboProfesionalActionPerformed(evt);
            }
        });
        this.panelDatosSalida.add(this.cboProfesional);
        this.cboProfesional.setBounds(530, 30, 330, 50);
        this.cboEps.setFont(new Font("Arial", 1, 12));
        this.cboEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa / EPS", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.panelDatosSalida.add(this.cboEps);
        this.cboEps.setBounds(870, 30, 290, 50);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 102)));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setGridColor(new Color(0, 51, 51));
        this.grid.setRowHeight(20);
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.Despachos.9
            public void mouseClicked(MouseEvent evt) {
                Despachos.this.gridMouseClicked(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.Despachos.10
            public void keyPressed(KeyEvent evt) {
                Despachos.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.panelProducto.setBackground(new Color(185, 205, 181));
        this.panelProducto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "INFORMACIÓN DEL PRODUCTO QUE SE DESPACHA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 102)));
        this.panelProducto.setLayout((LayoutManager) null);
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.11
            public void focusGained(FocusEvent evt) {
                Despachos.this.txtCodigoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Despachos.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.12
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.txtCodigoActionPerformed(evt);
            }
        });
        this.panelProducto.add(this.txtCodigo);
        this.txtCodigo.setBounds(20, 20, 170, 50);
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setForeground(new Color(0, 0, 153));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.setHorizontalTextPosition(0);
        this.btnCargar.setVerticalTextPosition(3);
        this.btnCargar.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.13
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.btnCargarActionPerformed(evt);
            }
        });
        this.btnCargar.addKeyListener(new KeyAdapter() { // from class: Inventarios.Despachos.14
            public void keyPressed(KeyEvent evt) {
                Despachos.this.btnCargarKeyPressed(evt);
            }
        });
        this.panelProducto.add(this.btnCargar);
        this.btnCargar.setBounds(1070, 80, 90, 70);
        this.panelLote.setBackground(new Color(185, 205, 181));
        this.panelLote.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "LOTE", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 102)));
        this.cboLote.setFont(new Font("Arial", 1, 12));
        this.cboLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.cboLote.addItemListener(new ItemListener() { // from class: Inventarios.Despachos.15
            public void itemStateChanged(ItemEvent evt) {
                Despachos.this.cboLoteItemStateChanged(evt);
            }
        });
        this.cboLote.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.16
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.cboLoteActionPerformed(evt);
            }
        });
        this.txtExistencia.setEditable(false);
        this.txtExistencia.setBackground(new Color(0, 102, 102));
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12)));
        this.txtExistencia.setForeground(new Color(255, 255, 255));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(255, 255, 255));
        this.txtExistencia.setEnabled(false);
        this.txtExistencia.setFocusable(false);
        this.txtExistencia.setFont(new Font("Arial", 1, 12));
        this.txtExistencia.setValue(new Integer(0));
        this.txtVencimiento.setEditable(false);
        this.txtVencimiento.setBackground(new Color(0, 102, 102));
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vencimiento", 0, 0, new Font("Arial", 1, 12)));
        this.txtVencimiento.setForeground(new Color(255, 255, 255));
        this.txtVencimiento.setHorizontalAlignment(0);
        this.txtVencimiento.setDisabledTextColor(new Color(255, 255, 255));
        this.txtVencimiento.setEnabled(false);
        this.txtVencimiento.setFocusable(false);
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        GroupLayout panelLoteLayout = new GroupLayout(this.panelLote);
        this.panelLote.setLayout(panelLoteLayout);
        panelLoteLayout.setHorizontalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.cboLote, -2, 223, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtExistencia, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtVencimiento, -2, 130, -2).addContainerGap()));
        panelLoteLayout.setVerticalGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLoteLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtVencimiento, -2, 50, -2).addGroup(panelLoteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboLote, -2, 50, -2).addComponent(this.txtExistencia, -2, 50, -2))).addGap(20, 20, 20)));
        this.panelProducto.add(this.panelLote);
        this.panelLote.setBounds(10, 70, 470, 80);
        this.txtExistenciaInventario.setBackground(new Color(0, 102, 102));
        this.txtExistenciaInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 153)));
        this.txtExistenciaInventario.setForeground(new Color(255, 255, 255));
        this.txtExistenciaInventario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtExistenciaInventario.setHorizontalAlignment(4);
        this.txtExistenciaInventario.setDisabledTextColor(new Color(255, 255, 255));
        this.txtExistenciaInventario.setEnabled(false);
        this.txtExistenciaInventario.setFocusable(false);
        this.txtExistenciaInventario.setFont(new Font("Arial", 1, 14));
        this.txtExistenciaInventario.setValue(0);
        this.panelProducto.add(this.txtExistenciaInventario);
        this.txtExistenciaInventario.setBounds(920, 20, 100, 50);
        this.panelCantidades.setBackground(new Color(185, 205, 181));
        this.panelCantidades.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "CANTIDADES", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 102)));
        this.txtSolicitada.setFont(new Font("Arial", 1, 12));
        this.txtSolicitada.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtSolicitada.setToolTipText("Cantidad del Producto que entra");
        this.txtSolicitada.setBorder(BorderFactory.createTitledBorder((Border) null, "Solicitada", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtSolicitada.addChangeListener(new ChangeListener() { // from class: Inventarios.Despachos.17
            public void stateChanged(ChangeEvent evt) {
                Despachos.this.txtSolicitadaStateChanged(evt);
            }
        });
        this.txtSolicitada.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.18
            public void focusLost(FocusEvent evt) {
                Despachos.this.txtSolicitadaFocusLost(evt);
            }
        });
        this.txtSolicitada.addKeyListener(new KeyAdapter() { // from class: Inventarios.Despachos.19
            public void keyPressed(KeyEvent evt) {
                Despachos.this.txtSolicitadaKeyPressed(evt);
            }
        });
        this.txtEntregada.setFont(new Font("Arial", 1, 12));
        this.txtEntregada.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtEntregada.setBorder(BorderFactory.createTitledBorder((Border) null, "Entregada", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtEntregada.addChangeListener(new ChangeListener() { // from class: Inventarios.Despachos.20
            public void stateChanged(ChangeEvent evt) {
                Despachos.this.txtEntregadaStateChanged(evt);
            }
        });
        this.txtEntregada.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.21
            public void focusLost(FocusEvent evt) {
                Despachos.this.txtEntregadaFocusLost(evt);
            }
        });
        this.txtEntregada.addKeyListener(new KeyAdapter() { // from class: Inventarios.Despachos.22
            public void keyPressed(KeyEvent evt) {
                Despachos.this.txtEntregadaKeyPressed(evt);
            }
        });
        this.txtFaltante.setEditable(false);
        this.txtFaltante.setBackground(new Color(0, 102, 102));
        this.txtFaltante.setBorder(BorderFactory.createTitledBorder((Border) null, "Faltante", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 153)));
        this.txtFaltante.setForeground(new Color(255, 255, 255));
        this.txtFaltante.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtFaltante.setHorizontalAlignment(4);
        this.txtFaltante.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFaltante.setEnabled(false);
        this.txtFaltante.setFocusable(false);
        this.txtFaltante.setFont(new Font("Arial", 1, 12));
        this.txtFaltante.setValue(new Integer(0));
        GroupLayout panelCantidadesLayout = new GroupLayout(this.panelCantidades);
        this.panelCantidades.setLayout(panelCantidadesLayout);
        panelCantidadesLayout.setHorizontalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCantidadesLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.txtSolicitada, -2, 100, -2).addGap(10, 10, 10).addComponent(this.txtEntregada, -2, 100, -2).addGap(10, 10, 10).addComponent(this.txtFaltante, -2, 90, -2)));
        panelCantidadesLayout.setVerticalGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCantidadesLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(panelCantidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtSolicitada, -2, 50, -2).addComponent(this.txtEntregada, -2, 50, -2).addComponent(this.txtFaltante, -2, 50, -2))));
        this.panelProducto.add(this.panelCantidades);
        this.panelCantidades.setBounds(490, 70, 330, 80);
        this.panelPrecios.setBackground(new Color(185, 205, 181));
        this.panelPrecios.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "PRECIOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 102)));
        this.txtValorUnidad.setEditable(false);
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr Unidad", 0, 0, new Font("Arial", 1, 12)));
        this.txtValorUnidad.setForeground(new Color(255, 255, 255));
        this.txtValorUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.txtValorUnidad.setDisabledTextColor(new Color(0, 0, 0));
        this.txtValorUnidad.setEnabled(false);
        this.txtValorUnidad.setFocusable(false);
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.txtValorUnidad.setValue(new Double(0.0d));
        this.txtValorTotal.setBackground(new Color(0, 102, 102));
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12)));
        this.txtValorTotal.setForeground(new Color(255, 255, 255));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setDisabledTextColor(new Color(255, 255, 255));
        this.txtValorTotal.setEnabled(false);
        this.txtValorTotal.setFocusable(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 12));
        this.txtValorTotal.setValue(new Double(0.0d));
        this.txtValorTotal.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.23
            public void focusLost(FocusEvent evt) {
                Despachos.this.txtValorTotalFocusLost(evt);
            }
        });
        this.txtValorTotal.addKeyListener(new KeyAdapter() { // from class: Inventarios.Despachos.24
            public void keyPressed(KeyEvent evt) {
                Despachos.this.txtValorTotalKeyPressed(evt);
            }
        });
        GroupLayout panelPreciosLayout = new GroupLayout(this.panelPrecios);
        this.panelPrecios.setLayout(panelPreciosLayout);
        panelPreciosLayout.setHorizontalGroup(panelPreciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelPreciosLayout.createSequentialGroup().addContainerGap().addComponent(this.txtValorUnidad, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorTotal, -2, 120, -2).addContainerGap()));
        panelPreciosLayout.setVerticalGroup(panelPreciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelPreciosLayout.createSequentialGroup().addGroup(panelPreciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorUnidad, -2, 50, -2).addComponent(this.txtValorTotal, -2, 50, -2)).addGap(15, 15, 15)));
        this.panelProducto.add(this.panelPrecios);
        this.panelPrecios.setBounds(820, 70, 240, 80);
        this.txtProducto.setBackground(new Color(0, 102, 102));
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setForeground(new Color(255, 255, 255));
        this.txtProducto.setHorizontalAlignment(2);
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtProducto.setDisabledTextColor(new Color(255, 255, 255));
        this.txtProducto.setEnabled(false);
        this.txtProducto.addMouseWheelListener(new MouseWheelListener() { // from class: Inventarios.Despachos.25
            public void mouseWheelMoved(MouseWheelEvent evt) {
                Despachos.this.txtProductoMouseWheelMoved(evt);
            }
        });
        this.txtProducto.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.26
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.txtProductoActionPerformed(evt);
            }
        });
        this.txtProducto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.Despachos.27
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Despachos.this.txtProductoPropertyChange(evt);
            }
        });
        this.txtProducto.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.Despachos.28
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Despachos.this.txtProductoVetoableChange(evt);
            }
        });
        this.panelProducto.add(this.txtProducto);
        this.txtProducto.setBounds(200, 20, 700, 50);
        this.btnBuscarProducto.setFont(new Font("Arial", 1, 12));
        this.btnBuscarProducto.setForeground(new Color(0, 0, 153));
        this.btnBuscarProducto.setText("...");
        this.btnBuscarProducto.addFocusListener(new FocusAdapter() { // from class: Inventarios.Despachos.29
            public void focusLost(FocusEvent evt) {
                Despachos.this.btnBuscarProductoFocusLost(evt);
            }
        });
        this.btnBuscarProducto.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.30
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.btnBuscarProductoActionPerformed(evt);
            }
        });
        this.panelProducto.add(this.btnBuscarProducto);
        this.btnBuscarProducto.setBounds(1110, 20, 50, 50);
        this.JSPNPendiente.setFont(new Font("Arial", 1, 12));
        this.JSPNPendiente.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNPendiente.setBorder(BorderFactory.createTitledBorder((Border) null, "NPend", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNPendiente.addChangeListener(new ChangeListener() { // from class: Inventarios.Despachos.31
            public void stateChanged(ChangeEvent evt) {
                Despachos.this.JSPNPendienteStateChanged(evt);
            }
        });
        this.panelProducto.add(this.JSPNPendiente);
        this.JSPNPendiente.setBounds(1030, 20, 70, 50);
        this.panelPersona.setBackground(new Color(185, 205, 181));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 950, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 210, 32767));
        this.txtNoFaltante.setEditable(false);
        this.txtNoFaltante.setBackground(new Color(0, 102, 102));
        this.txtNoFaltante.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Faltante", 0, 0, new Font("Tahoma", 1, 11), new Color(0, 0, 153)));
        this.txtNoFaltante.setForeground(new Color(102, 0, 102));
        this.txtNoFaltante.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtNoFaltante.setHorizontalAlignment(4);
        this.txtNoFaltante.setText("0");
        this.txtNoFaltante.setDisabledTextColor(new Color(102, 0, 102));
        this.txtNoFaltante.setEnabled(false);
        this.txtNoFaltante.setFocusable(false);
        this.txtNoFaltante.setFont(new Font("Tahoma", 1, 24));
        this.txtNoFaltante.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.32
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.txtNoFaltanteActionPerformed(evt);
            }
        });
        this.txtTotalFactura.setEditable(false);
        this.txtTotalFactura.setBackground(new Color(0, 102, 102));
        this.txtTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Factura", 0, 0, new Font("Tahoma", 1, 11), new Color(0, 0, 153)));
        this.txtTotalFactura.setForeground(new Color(102, 0, 102));
        this.txtTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtTotalFactura.setHorizontalAlignment(4);
        this.txtTotalFactura.setDisabledTextColor(new Color(102, 0, 102));
        this.txtTotalFactura.setEnabled(false);
        this.txtTotalFactura.setFocusable(false);
        this.txtTotalFactura.setFont(new Font("Tahoma", 1, 24));
        this.txtTotalFactura.setValue(new Double(0.0d));
        this.btnBuscarUltimoDespacho.setFont(new Font("Arial", 1, 12));
        this.btnBuscarUltimoDespacho.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ayuda29x27.png")));
        this.btnBuscarUltimoDespacho.setText("<html><P ALIGN=center>Ultimo Despacho al Usuario");
        this.btnBuscarUltimoDespacho.setContentAreaFilled(false);
        this.btnBuscarUltimoDespacho.setHorizontalAlignment(11);
        this.btnBuscarUltimoDespacho.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.33
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.btnBuscarUltimoDespachoActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n");
        this.JBTEventoAdverso.setToolTipText("");
        this.JBTEventoAdverso.setEnabled(false);
        this.JBTEventoAdverso.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.34
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.JBTEventoAdversoActionPerformed(evt);
            }
        });
        this.jCheckBox1.setBackground(Color.red);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Lote sin  existencia");
        this.jCheckBox1.setOpaque(true);
        this.JBT_Facturacion.setFont(new Font("Arial", 1, 12));
        this.JBT_Facturacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.JBT_Facturacion.setContentAreaFilled(false);
        this.JBT_Facturacion.setHorizontalAlignment(11);
        this.JBT_Facturacion.setLabel("<html><P ALIGN=center>Facturación");
        this.JBT_Facturacion.addActionListener(new ActionListener() { // from class: Inventarios.Despachos.35
            public void actionPerformed(ActionEvent evt) {
                Despachos.this.JBT_FacturacionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCheckBox1).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtTotalFactura, -2, 230, -2).addComponent(this.btnBuscarUltimoDespacho, -2, 114, -2)).addContainerGap(21, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_Facturacion, -2, 114, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNoFaltante, -2, 230, -2).addComponent(this.JBTEventoAdverso, -2, 230, -2))).addGap(0, 0, 32767)))).addComponent(this.panelDatosSalida, -2, 1170, -2).addComponent(this.panelProducto, -2, 1170, -2).addComponent(this.jScrollPane1, -2, 1170, -2))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.txtNoFaltante, -2, -1, -2).addGap(9, 9, 9).addComponent(this.txtTotalFactura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnBuscarUltimoDespacho, -2, 50, -2).addComponent(this.JBT_Facturacion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso, -2, 50, -2))).addComponent(this.panelDatosSalida, -2, 90, -2).addGap(0, 0, 0).addComponent(this.panelProducto, -2, 160, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox1).addContainerGap()));
        getAccessibleContext().setAccessibleName("Despacho de Medimanetos");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSolicitadaStateChanged(ChangeEvent evt) {
        if ((!this.txtExistencia.getValue().equals("") || this.txtExistencia.getValue() != null) && ((!this.txtSolicitada.getValue().equals("") || this.txtSolicitada.getValue() != null) && Double.parseDouble(this.txtExistencia.getValue().toString()) >= Double.parseDouble(this.txtSolicitada.getValue().toString()))) {
            this.txtEntregada.setValue(this.txtSolicitada.getValue());
        }
        if (!this.txtSolicitada.getValue().equals("") || this.txtSolicitada.getValue() != null) {
            entregarValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalFocusLost(FocusEvent evt) {
        this.txtValorUnidad.setValue(Integer.valueOf(Integer.parseInt(this.txtValorTotal.getValue().toString()) / Integer.parseInt(this.txtSolicitada.getValue().toString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEntregadaStateChanged(ChangeEvent evt) {
        if (!this.txtEntregada.getValue().equals("") || this.txtEntregada.getValue() != null) {
            entregarValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalActionPerformed(ActionEvent evt) {
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
    public void btnBuscarUltimoDespachoActionPerformed(ActionEvent evt) {
        buscarUltimoDespacho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoFaltanteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtOrdenActionPerformed(ActionEvent evt) {
        this.cboTipoMovimiento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarProductoActionPerformed(ActionEvent evt) {
        buscarProducto(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        buscarProducto(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarProductoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoMouseWheelMoved(MouseWheelEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtOrdenFocusLost(FocusEvent evt) {
        buscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtOrdenFocusGained(FocusEvent evt) {
        this.txtOrden.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboLoteItemStateChanged(ItemEvent evt) {
        if (this.cboLlenoLote == 1 && this.cboLote.getSelectedIndex() > -1) {
            cargarDatosDelLote();
            mVerificarFechaVencimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xmodulo == 1) {
            this.claseInv.xjifformulacionmedica.setVisible(true);
            return;
        }
        if (this.xmodulo == 3) {
            if (Principal.xClaseInventario.xjifagendaunidosis == null) {
                this.claseInv.cargarPantalla("Agenda_Unidosis");
                return;
            }
            Principal.xClaseInventario.xjifagendaunidosis.setVisible(true);
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
                Principal.xClaseInventario.xjifagendaunidosis.mCargarDatos();
            }
        }
    }

    public void mVerificarAlergia(String usuario) {
        try {
            String sql = "SELECT `g_usuarioxtipoalerta`.`Detalle` FROM `g_usuarioxtipoalerta`  INNER JOIN `baseserver`.`g_tipoalerta` ON (`g_usuarioxtipoalerta`.`Id_TipoAlerta` = `g_tipoalerta`.`Id`) WHERE (`g_tipoalerta`.`EsHC` =1 AND `g_usuarioxtipoalerta`.`Id_Usuario` ='" + usuario + "' AND `g_usuarioxtipoalerta`.`Id_TipoAlerta` =4)";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                String xalergias = "";
                while (xrs.next()) {
                    xalergias = xalergias + "<html><P ALIGN=left><font color=#FF0000> " + xrs.getString(1) + "</font> <P>";
                }
                JOptionPane.showMessageDialog(this, xalergias, " PACIENTE CON ALERGIA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.txtCodigo.requestFocus();
            } else {
                this.txtCodigo.requestFocus();
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Despachos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mVerificarMensaje_ClasificacionLasa(String nAlerta) {
        if (!nAlerta.equals("")) {
            String xalergias = "<html><P ALIGN=left><font color=#FF0000> " + nAlerta.toUpperCase() + "</font> <P></html>";
            JOptionPane.showMessageDialog(this, xalergias, "ALERTA DE SEGURIDAD CLINICA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNPendienteStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdversoActionPerformed(ActionEvent evt) {
        if (!"0".equals(this.xidIngreso) && !this.xidIngreso.isEmpty()) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.xidIngreso, 3);
            detalle.setLocationRelativeTo(this.panelDatosSalida);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un ingreso", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            if (Principal.txtNo.getText().isEmpty()) {
                if (evt.getClickCount() == 2) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Desea actualizar este registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.txtCodigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                        this.txtSolicitada.setValue(Integer.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 6).toString()));
                        this.txtEntregada.setValue(Integer.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 7).toString()));
                        buscarProducto(1);
                        this.cboLote.setSelectedItem("<html><P ALIGN=center><font face='Arial' color='red' size=4>" + this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString() + " - Vence " + this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString().replace("/", "-") + "</font></P></html>");
                        this.cboLote.setSelectedItem("<html><P ALIGN=center><font face='Arial' color='green' size=4>" + this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString() + " - Vence " + this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString().replace("/", "-") + "</font></P></html>");
                        this.cboLote.setSelectedItem("<html><P ALIGN=center><font face='Arial' color='black' size=4>" + this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString() + " - Vence " + this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString().replace("/", "-") + "</font></P></html>");
                        this.modelo.removeRow(this.grid.getSelectedRow());
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este despacho ya se encuetra grabado", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_FacturacionActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            cargarFormularioFacturacion(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSolicitadaFocusLost(FocusEvent evt) {
        entregarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEntregadaFocusLost(FocusEvent evt) {
        entregarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSolicitadaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtSolicitada.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEntregadaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtEntregada.transferFocus();
        }
    }
}
