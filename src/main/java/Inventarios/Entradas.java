package Inventarios;

import Acceso.Principal;
import General.Anular;
import Utilidades.BoundsPopupMenuListener;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.BodegaDTO;
import com.genoma.plus.jpa.entities.IDetalleentrada;
import com.genoma.plus.jpa.entities.IEntradas;
import com.genoma.plus.jpa.entities.IPeriodo;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.ISuministroxbodega;
import com.genoma.plus.jpa.entities.ISuministroxlotexbodega;
import com.genoma.plus.jpa.entities.ISuministroxlotexbodegaPK;
import com.genoma.plus.jpa.entities.ITiposmovimientos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.service.IEntradaService;
import com.genoma.plus.jpa.service.IISuministroxbodegaService;
import com.genoma.plus.jpa.service.IISuministroxlotexbodegaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Entradas.class */
public class Entradas extends JInternalFrame {
    private Color color;
    public claseInventario claseInv;
    private DefaultTableModel modelo;
    public String[] listaProveedor;
    public String[] xidtipo;
    public String[] xidtransp;
    private String[][] listaTipoMovimiento;
    private Object[] dato;
    private String sql;
    private String IdSuministroxLotexBodega;
    private String IdSuministroxBodega;
    private String estado;
    public String Existencia;
    public String fecha;
    public List<IInformacionInventario> informacionInventarios;
    private Entrada entrada;
    private List<ISuministroxbodega> suministroxbodega;
    private IISuministroxbodegaService suministroxbodegaService;
    private IISuministroxlotexbodegaService suministroxlotexbodegaService;
    private IEntradaService iEntradaService;
    private ButtonGroup JBGTipoDistribucion;
    private JButton JBTCarguesA;
    private JButton JBTCarguesA1;
    private JButton JBTCarguesA2;
    public JComboBox JCBTransportadora;
    private JCheckBox JCHAcepta;
    public JComboBox JCTipo;
    public JLabel JLBIdEntrada;
    private JPanel JPDistribucion;
    private JPanel JPI_Utilidades;
    private JPanel JPTipoRecepcion;
    private JRadioButton JRBAutomatica;
    private JRadioButton JRBManual;
    public JSpinner JSPCPendiente;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNCajas;
    public JSpinner JSPNSolicitudP;
    private JScrollPane JSPObservacion;
    public JSpinner JSPTemperatura;
    public JTextField JTFAuxiliar;
    public JFormattedTextField JTFFCU;
    private JFormattedTextField JTFFValor;
    public JTextField JTFOrdenC;
    private JTextField JTFRuta;
    public JFormattedTextField JTFTotalOCompra;
    private JTabbedPane JTPDatosE;
    private JTextPane JTPObservacion;
    private JTabbedPane JTP_Datos;
    private JButton btnBuscarProducto;
    private JButton btnCargar;
    public JRadioButton btnContado;
    public JRadioButton btnCredito;
    public JRadioButton btnNoAplica;
    private JButton btnOrdenCompra;
    private ButtonGroup buttonGroup1;
    public JComboBox cboProveedor;
    public JComboBox cboTipoMovimiento;
    public JTable grid;
    private JPanel jPanel1;
    private JPanel panelDatosEntrada;
    private JPanel panelFletes;
    private JPanel panelInformacion;
    private JPanel panelValor;
    private JPanel panelformapago;
    private JSpinner txtCantidad;
    public JTextField txtCodigo;
    public JFormattedTextField txtDescuento;
    public JFormattedTextField txtExistencia;
    public JTextField txtFactura;
    public JDateChooser txtFecha;
    public JFormattedTextField txtFlete;
    public JSpinner txtIva;
    public JTextField txtLote;
    public JTextField txtMuestreo;
    public JTextField txtProducto;
    public JFormattedTextField txtTotalCosto;
    public JFormattedTextField txtTotalFactura;
    public JFormattedTextField txtTotalIva;
    private JFormattedTextField txtValorIva;
    private JFormattedTextField txtValorTotal;
    private JFormattedTextField txtValorTotalUnidad;
    public JSpinner txtValorUnidad;
    public JDateChooser txtVencimiento;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int afectaCosto = 0;
    private int filaGrid = 0;
    private int cboLleno = 0;
    private int formaPago = 0;
    private int grabada = 0;
    private int xfilaGrid = -1;
    private String idEntrada = "";
    private String xCodigoCUM = "";
    private String xCodigoATC = "";
    public String idProducto = null;
    public String xobservacion = "";
    public long xcodogi_agrupacion = 0;
    public long idDocContable = 0;
    public int sueno = 0;
    public int xacepta = 1;
    public int xidproductobd = 0;
    public int xcontroltemp = 0;
    public int xidtiporecepcion = 0;
    public int xidtransportadora = 0;
    private double xvalortemp = 0.0d;
    private boolean xestado = false;
    private boolean xlleno = false;
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private JFileChooser FileChooser = new JFileChooser();

    public Entradas(claseInventario clase) {
        this.claseInv = null;
        initComponents();
        BoundsPopupMenuListener listener = new BoundsPopupMenuListener(true, false);
        this.JPDistribucion.setVisible(false);
        this.cboTipoMovimiento.addPopupMenuListener(listener);
        this.cboTipoMovimiento.setPrototypeDisplayValue("ItemWWW");
        this.iEntradaService = (IEntradaService) Principal.contexto.getBean(IEntradaService.class);
        this.suministroxbodegaService = (IISuministroxbodegaService) Principal.contexto.getBean(IISuministroxbodegaService.class);
        this.suministroxlotexbodegaService = (IISuministroxlotexbodegaService) Principal.contexto.getBean(IISuministroxlotexbodegaService.class);
        this.claseInv = clase;
        setTitle("Entrada de Productos y Suministros a la Bodega : " + this.claseInv.getNbreBodega());
        crearGrid();
        cargarCombos();
        if (this.claseInv.getTipoBodega() == 1) {
            aplicarConfiguracion(1);
        } else {
            aplicarConfiguracion(2);
        }
        nuevo();
    }

    public void setFormaPago(int f) {
        this.formaPago = f;
    }

    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    public void setXidproductobd(int xidproductobd) {
        this.xidproductobd = xidproductobd;
    }

    public String getxCodigoCUM() {
        return this.xCodigoCUM;
    }

    public void setxCodigoCUM(String xCodigoCUM) {
        this.xCodigoCUM = xCodigoCUM;
    }

    public String getxCodigoATC() {
        return this.xCodigoATC;
    }

    public void setxCodigoATC(String xCodigoATC) {
        this.xCodigoATC = xCodigoATC;
    }

    public boolean isXestado() {
        return this.xestado;
    }

    public void setXestado(boolean xestado) {
        this.xestado = xestado;
    }

    public JComboBox getJCTipo() {
        return this.JCTipo;
    }

    public void setJCTipo(JComboBox JCTipo) {
        this.JCTipo = JCTipo;
    }

    public void ActualizarSuministroxBodega() {
        for (int i = 0; i < this.grid.getModel().getRowCount(); i++) {
            this.claseInv.mDescontarCantidadInventario(Integer.valueOf(this.grid.getModel().getValueAt(i, 13).toString()).intValue(), Double.valueOf(this.grid.getModel().getValueAt(i, 3).toString()), this.grid.getModel().getValueAt(i, 8).toString(), this.JLBIdEntrada.getText(), this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][1].toString());
        }
    }

    public final void aplicarConfiguracion(int tipo) {
        if (tipo == 1) {
            this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "CE", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "V/U Emapaque", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.color = new Color(199, 218, 237);
        } else {
            this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "CU", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "V/UnitarioU", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.color = new Color(211, 240, 235);
        }
        setBackground(this.color);
        this.panelDatosEntrada.setBackground(this.color);
        this.JPTipoRecepcion.setBackground(this.color);
        this.panelformapago.setBackground(this.color);
        this.panelFletes.setBackground(this.color);
        this.btnCredito.setBackground(this.color);
        this.btnContado.setBackground(this.color);
        this.btnNoAplica.setBackground(this.color);
        this.panelInformacion.setBackground(this.color);
        this.panelValor.setBackground(this.color);
    }

    public void anular() {
        if (this.JLBIdEntrada.getText().isEmpty()) {
            this.xmt.mostrarMensaje("Por Favor seleccione un Número de Entrada a Anular");
            return;
        }
        if ("ANULADA".equals(Principal.txtEstado.getText())) {
            this.xmt.mostrarMensaje("La Entrada ya se encuentra Anulada");
        } else if (this.idDocContable != 0) {
            this.xmt.mostrarMensaje("Entrada con documentos contable No. " + this.idDocContable + ", relacionado;\nDebe anular primero el documento contable");
        } else {
            Anular frm = new Anular(null, true, "Entradas", 4);
            frm.setVisible(true);
        }
    }

    public void anularEntrada(String razon) {
        this.sql = "UPDATE i_entradas SET  Estado = '" + razon + "', Fecha = '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + this.JLBIdEntrada.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        ActualizarSuministroxBodega();
        this.xmt.marcarEstado(1);
        this.xmt.mostrarMensaje("Entrada Anulada");
        this.consultas.cerrarConexionBd();
    }

    public void bajarProducto() {
        if (this.txtProducto.getText().isEmpty()) {
            this.xmt.mostrarMensaje("Por favor seleccione un Producto");
            this.txtProducto.requestFocus();
            return;
        }
        if (this.txtLote.getText().isEmpty()) {
            this.xmt.mostrarMensaje("Por favor digite el Lote de Fabricación");
            this.txtLote.requestFocus();
            return;
        }
        if (this.xcontroltemp == 1 && Double.valueOf(this.JSPTemperatura.getValue().toString()).doubleValue() == 0.0d) {
            this.xmt.mostrarMensaje("Debe registrar la temperatura de recepción");
            this.JSPTemperatura.requestFocus();
            return;
        }
        if (this.xmt.mVerificarDatosDoblesTabla(this.grid, 1, this.txtCodigo.getText()) && this.xmt.mVerificarDatosDoblesTabla(this.grid, 8, this.txtLote.getText())) {
            this.xmt.mostrarMensaje("Ya se encuentra adicionado suministro con este mismo lote");
            this.txtLote.requestFocus();
            return;
        }
        this.entrada.setValorDescuento(Double.valueOf(this.txtDescuento.getValue().toString()));
        this.entrada.setValorFlete(Double.valueOf(this.txtFlete.getValue().toString()));
        EntradaDetalle detalle = new EntradaDetalle(this.entrada);
        detalle.setIdSuministro(Long.valueOf(this.idProducto));
        detalle.setIdSuministroBodega(Long.valueOf(this.xidproductobd));
        detalle.setCodigoBarra(this.txtCodigo.getText());
        detalle.setNombre(this.txtProducto.getText());
        detalle.setCantidad(Double.valueOf(Double.parseDouble(this.txtCantidad.getValue().toString())));
        detalle.setPoncentajeImpuesto(Double.valueOf(this.txtIva.getValue().toString()));
        detalle.setValorUnitario(Double.valueOf(Double.parseDouble(this.txtValorUnidad.getValue().toString())));
        detalle.setLote(this.txtLote.getText());
        detalle.setAcepta(Boolean.valueOf(this.JCHAcepta.isSelected()));
        detalle.setObservacion(this.xobservacion);
        detalle.setCantidadUnidad(Long.valueOf(this.JTFFCU.getValue().toString()));
        detalle.setTemperatura(Double.valueOf(this.JSPTemperatura.getValue().toString()));
        detalle.setCantidadPendiente(Double.valueOf(this.JSPCPendiente.getValue().toString()));
        detalle.setCodigoCum(getxCodigoCUM());
        detalle.setCodigoAtc(getxCodigoATC());
        detalle.setFechaVecimiento(this.txtVencimiento.getDate());
        detalle.setCantidadMuestreo(Short.valueOf(this.txtMuestreo.getText()));
        this.entrada.setAddDetalleEntrada(detalle);
        Optional<ISuministroxbodega> iSuministroxbodega = this.suministroxbodegaService.buscarPorId(Long.valueOf(this.xidproductobd));
        if (iSuministroxbodega.isPresent()) {
            ISuministroxbodega suministroxbodegaDato = iSuministroxbodega.get();
            ISuministroxlotexbodegaPK suministroxlotexbodegaPK = new ISuministroxlotexbodegaPK();
            suministroxlotexbodegaPK.setId(suministroxbodegaDato.getId().longValue());
            suministroxlotexbodegaPK.setLote(this.txtLote.getText());
            Optional<ISuministroxlotexbodega> suministroxlotexbodega = this.suministroxlotexbodegaService.listarPorIdSuministroLote(suministroxlotexbodegaPK);
            if (!suministroxlotexbodega.isPresent()) {
                ISuministroxlotexbodega suministroxlotexbodegaN = new ISuministroxlotexbodega();
                suministroxlotexbodegaN.setISuministroxbodega(suministroxbodegaDato);
                suministroxlotexbodegaN.setISuministroxlotexbodegaPK(suministroxlotexbodegaPK);
                suministroxlotexbodegaN.setFechaVencimiento(this.txtVencimiento.getDate());
                suministroxlotexbodegaN.setCPendiente(Short.valueOf("0"));
                suministroxlotexbodegaN.setCantidad(0);
                this.suministroxlotexbodegaService.grabar(suministroxlotexbodegaN);
            }
        }
        this.filaGrid = 0;
        cargarDetalleTabla();
        if (this.sueno == 1) {
            this.xmt.mostrarMensaje("Este medicamento produce sueño\nPor favor coloque el Sticker respectivo");
            this.sueno = 0;
        }
        this.txtTotalCosto.setValue(this.entrada.getValorTotalCosto());
        this.txtTotalIva.setValue(this.entrada.getValorTotalIva());
        this.txtTotalFactura.setValue(this.entrada.getTotalFactura());
        this.txtDescuento.setValue(this.entrada.getValorDescuento());
        this.txtFlete.setValue(this.entrada.getValorFlete());
        limpiarDatosProducto();
        this.txtCodigo.requestFocus();
    }

    private void cargarDetalleTabla() {
        crearGrid();
        this.entrada.getDetalleEntrada().stream().map(detalleEntrada -> {
            this.modelo.addRow(new Object[]{null});
            return detalleEntrada;
        }).map(detalleEntrada2 -> {
            this.grid.getModel().setValueAt(detalleEntrada2.getIdSuministro(), this.grid.getRowCount() - 1, 0);
            return detalleEntrada2;
        }).map(detalleEntrada3 -> {
            this.grid.getModel().setValueAt(detalleEntrada3.getIdSuministroBodega(), this.grid.getRowCount() - 1, 13);
            return detalleEntrada3;
        }).map(detalleEntrada4 -> {
            this.grid.getModel().setValueAt(detalleEntrada4.getCodigoBarra(), this.grid.getRowCount() - 1, 1);
            return detalleEntrada4;
        }).map(detalleEntrada5 -> {
            this.grid.getModel().setValueAt(detalleEntrada5.getNombre(), this.grid.getRowCount() - 1, 2);
            return detalleEntrada5;
        }).map(detalleEntrada6 -> {
            this.grid.getModel().setValueAt(detalleEntrada6.getCantidad(), this.grid.getRowCount() - 1, 3);
            return detalleEntrada6;
        }).map(detalleEntrada7 -> {
            this.grid.getModel().setValueAt(detalleEntrada7.getValorUnitario(), this.grid.getRowCount() - 1, 4);
            return detalleEntrada7;
        }).map(detalleEntrada8 -> {
            this.grid.getModel().setValueAt(detalleEntrada8.getPoncentajeImpuesto(), this.grid.getRowCount() - 1, 5);
            return detalleEntrada8;
        }).map(detalleEntrada9 -> {
            this.grid.getModel().setValueAt(detalleEntrada9.getValorImpuesto(), this.grid.getRowCount() - 1, 6);
            return detalleEntrada9;
        }).map(detalleEntrada10 -> {
            this.grid.getModel().setValueAt(detalleEntrada10.getValorTotal(), this.grid.getRowCount() - 1, 7);
            return detalleEntrada10;
        }).map(detalleEntrada11 -> {
            this.grid.getModel().setValueAt(detalleEntrada11.getLote(), this.grid.getRowCount() - 1, 8);
            return detalleEntrada11;
        }).map(detalleEntrada12 -> {
            this.grid.getModel().setValueAt(this.xmt.formatoDMA.format(detalleEntrada12.getFechaVecimiento()), this.grid.getRowCount() - 1, 9);
            return detalleEntrada12;
        }).map(detalleEntrada13 -> {
            this.grid.getModel().setValueAt(detalleEntrada13.getAcepta(), this.grid.getRowCount() - 1, 10);
            return detalleEntrada13;
        }).map(detalleEntrada14 -> {
            this.grid.getModel().setValueAt(detalleEntrada14.getObservacion(), this.grid.getRowCount() - 1, 11);
            return detalleEntrada14;
        }).map(detalleEntrada15 -> {
            this.grid.getModel().setValueAt(detalleEntrada15.getCantidadUnidad(), this.grid.getRowCount() - 1, 12);
            return detalleEntrada15;
        }).map(detalleEntrada16 -> {
            this.grid.getModel().setValueAt(detalleEntrada16.getTemperatura(), this.grid.getRowCount() - 1, 14);
            return detalleEntrada16;
        }).map(detalleEntrada17 -> {
            this.grid.getModel().setValueAt(detalleEntrada17.getCantidadPendiente(), this.grid.getRowCount() - 1, 15);
            return detalleEntrada17;
        }).map(detalleEntrada18 -> {
            this.grid.getModel().setValueAt(detalleEntrada18.getValorUnitarioFlete(), this.grid.getRowCount() - 1, 16);
            this.grid.getModel().setValueAt(detalleEntrada18.getValorUnitarioDescuento(), this.grid.getRowCount() - 1, 17);
            this.grid.getModel().setValueAt(detalleEntrada18.getCodigoCum(), this.grid.getRowCount() - 1, 18);
            return detalleEntrada18;
        }).map(detalleEntrada19 -> {
            this.grid.getModel().setValueAt(detalleEntrada19.getCodigoAtc(), this.grid.getRowCount() - 1, 19);
            return detalleEntrada19;
        }).map(detalleEntrada20 -> {
            this.grid.getModel().setValueAt(detalleEntrada20.getCantidadMuestreo(), this.grid.getRowCount() - 1, 20);
            return detalleEntrada20;
        }).forEachOrdered(_item -> {
            this.filaGrid++;
        });
        System.out.println("Costo " + this.entrada.getValorTotalCosto());
        this.txtTotalCosto.setValue(this.entrada.getValorTotalCosto());
        this.txtTotalIva.setValue(this.entrada.getValorTotalIva());
        this.txtTotalFactura.setValue(this.entrada.getTotalFactura());
        this.txtDescuento.setValue(this.entrada.getValorDescuento());
        this.txtFlete.setValue(this.entrada.getValorFlete());
    }

    public void buscarEntrada() {
        BuscarEntrada frm = new BuscarEntrada(null, true, this.claseInv, "Entradas");
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        this.grabada = 1;
    }

    public void buscarProducto(int op) {
        if (op == 1) {
            this.informacionInventarios = new ArrayList();
            this.informacionInventarios = this.claseInv.listInventarioGeneral(this.xmt.getFechaActual(), this.claseInv.getListaIdBodega(), 0, 1, this.txtCodigo.getText(), "");
            if (!this.informacionInventarios.isEmpty()) {
                this.xcontroltemp = 0;
                this.xvalortemp = 0.0d;
                this.idProducto = this.informacionInventarios.get(0).getIdSuministro().toString();
                this.xidproductobd = Integer.valueOf(this.informacionInventarios.get(0).getIdSUministroBodega().toString()).intValue();
                this.txtProducto.setText(this.informacionInventarios.get(0).getNombreSuministro() + " " + this.informacionInventarios.get(0).getNombrePresentacionComercial() + " " + this.informacionInventarios.get(0).getNombreLaboratorio());
                this.txtValorUnidad.setValue(this.informacionInventarios.get(0).getValorUnitario());
                this.Existencia = this.informacionInventarios.get(0).getCantidadTotal().toString();
                this.xcodogi_agrupacion = Long.valueOf(this.informacionInventarios.get(0).getCodigoAgruacion()).longValue();
                this.txtExistencia.setValue(Double.valueOf(Double.parseDouble(this.Existencia)));
                this.txtIva.setValue(this.informacionInventarios.get(0).getIva());
                this.JTFFCU.setValue(this.informacionInventarios.get(0).getCantidadUnidad());
                if (this.informacionInventarios.get(0).getAplicaLogoSueno().booleanValue()) {
                    this.sueno = 1;
                } else {
                    this.sueno = 0;
                }
                if (this.informacionInventarios.get(0).getControlTemperatura().booleanValue()) {
                    this.xcontroltemp = 1;
                } else {
                    this.xcontroltemp = 0;
                }
                this.xvalortemp = this.informacionInventarios.get(0).getTemperaturaMaxima().doubleValue();
                setxCodigoCUM(this.informacionInventarios.get(0).getCodigoCum());
                setxCodigoATC(this.informacionInventarios.get(0).getCodigoAtc());
                System.out.println("" + this.informacionInventarios.get(0).getNumeroDiasVencimientoInvima());
                System.out.println("" + this.informacionInventarios.get(0).getFechaVencimientoInvima());
                mVerificarFVencimientoInvima(this.informacionInventarios.get(0).getContolVencimiento().intValue(), this.informacionInventarios.get(0).getFechaVencimientoInvima());
                mVerificarControlTemperatura();
            } else {
                limpiarDatosProducto();
            }
            this.txtCantidad.setValue(new Double(1.0d));
            this.txtIva.setValue(0);
            this.txtValorIva.setValue(0);
            this.txtValorTotalUnidad.setValue(Double.valueOf(this.xmt.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)));
            this.txtValorTotal.setValue(Double.valueOf(this.xmt.redondear(Double.parseDouble(this.txtValorUnidad.getValue().toString()), 2)));
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

    private void mVerificarControlTemperatura() {
        if (this.xcontroltemp == 1) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Medicamento y/o dispositivo medico con temperatura sugerida por el fabricante de " + this.xvalortemp + "°;</p><font face='Arial' color='red' size=4>Se debe registrar temperatura de recepción.";
            JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL DE TEMPERATURA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            this.JSPTemperatura.requestFocus();
        }
    }

    public final void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"IdProducto", "Código", "Producto", "Cantidad", "Vr. Unidad", "IVA", "Vr. IVA", "Vr.Total", "Lote", "Vencimiento", "Acepta", "Observacion", "C/U", "Id_ProductoBodega", "Temperatura", "CPendiente", "Vr. Flete", "Vr. Descuento", "Codigo CUM", "Codigo ATC", "Muestreo"}) { // from class: Inventarios.Entradas.1
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, Boolean.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(60);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.filaGrid = 0;
    }

    public final void cargarCombos() {
        this.xestado = false;
        this.cboProveedor.removeAllItems();
        this.cboTipoMovimiento.removeAllItems();
        this.JCBTransportadora.removeAllItems();
        this.JCTipo.removeAllItems();
        this.listaProveedor = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1 AND EsMInventario =1) ORDER BY Nbre ASC", this.listaProveedor, this.cboProveedor);
        this.cboProveedor.setSelectedIndex(-1);
        this.listaTipoMovimiento = this.consultas.llenarComboyLista("SELECT Id, Nbre, AfectaCosto, RDatosAdicionales FROM i_tiposmovimientos WHERE (Bodega ='" + this.claseInv.getIdBodega() + "' AND TipoMovimiento =0 AND Estado =0) ORDER BY Nbre ASC ", this.listaTipoMovimiento, this.cboTipoMovimiento, 4);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.xidtipo = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiporecepcion WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipo, this.JCTipo);
        this.JCTipo.setSelectedIndex(-1);
        this.xidtransp = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Transp =1 AND Estado =1) ORDER BY Nbre ASC", this.xidtransp, this.JCBTransportadora);
        this.JCBTransportadora.setSelectedIndex(-1);
        this.xestado = true;
        this.consultas.cerrarConexionBd();
    }

    public void cargarDatos() {
        this.txtCodigo.setText(this.grid.getModel().getValueAt(this.filaGrid, 1).toString());
        this.txtProducto.setText(this.grid.getModel().getValueAt(this.filaGrid, 2).toString());
        this.txtCantidad.setValue(Double.valueOf(Double.parseDouble(this.grid.getModel().getValueAt(this.filaGrid, 3).toString())));
        this.txtValorUnidad.setValue(Double.valueOf(Double.parseDouble(this.grid.getModel().getValueAt(this.filaGrid, 4).toString())));
        this.txtIva.setValue(Double.valueOf(Double.parseDouble(this.grid.getModel().getValueAt(this.filaGrid, 5).toString())));
        this.txtValorIva.setValue(Double.valueOf(Double.parseDouble(this.grid.getModel().getValueAt(this.filaGrid, 6).toString())));
        this.txtValorTotal.setValue(Double.valueOf(Double.parseDouble(this.grid.getModel().getValueAt(this.filaGrid, 7).toString())));
        this.txtLote.setText(this.grid.getModel().getValueAt(this.filaGrid, 8).toString());
        this.txtVencimiento.setDate(this.xmt.getPasarTextoAFecha(this.grid.getModel().getValueAt(this.filaGrid, 9).toString()));
    }

    public void cargarProductos() {
        double vrCosto = 0.0d;
        double vrIva = 0.0d;
        double vrflete = 0.0d;
        double vrdescuento = 0.0d;
        this.sql = "SELECT IdEntrada, i_detalleentrada.IdSuministro, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_detalleentrada.Cantidad,  i_detalleentrada.ValorUnitario, i_detalleentrada.Iva, Lote, i_detalleentrada.FechaVencimiento, i_presentacioncomercial.Nbre, i_suministroxbodega.Id, i_detalleentrada.VFletesO, i_detalleentrada.VDescuento  FROM i_detalleentrada INNER JOIN i_suministro ON (i_detalleentrada.IdSuministro = i_suministro.Id)   INNER JOIN i_entradas ON (i_detalleentrada.IdEntrada= i_entradas.Id)  INNER JOIN i_suministroxbodega ON (i_detalleentrada.IdSuministro = i_suministroxbodega.IdSuministro)   INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)   WHERE (IdEntrada = '" + this.JLBIdEntrada.getText() + "' AND i_entradas.IdBodega=i_suministroxbodega.IdBodega) ";
        System.out.println(this.sql);
        ResultSet rs = this.consultas.traerRs(this.sql);
        crearGrid();
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.grid.getModel().setValueAt(rs.getString(2), this.filaGrid, 0);
                this.grid.getModel().setValueAt(rs.getString(3), this.filaGrid, 1);
                this.grid.getModel().setValueAt(rs.getString(4) + " - " + rs.getString(10), this.filaGrid, 2);
                this.grid.getModel().setValueAt(Double.valueOf(rs.getDouble(5)), this.filaGrid, 3);
                this.grid.getModel().setValueAt(Double.valueOf(rs.getDouble(6)), this.filaGrid, 4);
                this.grid.getModel().setValueAt(Double.valueOf(rs.getDouble(7)), this.filaGrid, 5);
                this.grid.getModel().setValueAt(Double.valueOf(((rs.getDouble(6) * rs.getDouble(7)) / 100.0d) * rs.getDouble(5)), this.filaGrid, 6);
                this.grid.getModel().setValueAt(Double.valueOf((((rs.getDouble(6) * rs.getDouble(7)) / 100.0d) + rs.getDouble(6)) * rs.getDouble(5)), this.filaGrid, 7);
                this.grid.getModel().setValueAt(rs.getString(8), this.filaGrid, 8);
                this.modelo.setValueAt(this.xmt.formatoAMD.format((Date) rs.getDate(9)), this.filaGrid, 9);
                vrCosto += rs.getDouble(6) * rs.getDouble(5);
                vrIva += ((rs.getDouble(6) * rs.getDouble(7)) / 100.0d) * rs.getDouble(5);
                this.grid.getModel().setValueAt(rs.getString(11), this.filaGrid, 13);
                this.grid.getModel().setValueAt(Double.valueOf(rs.getDouble(12)), this.filaGrid, 16);
                this.grid.getModel().setValueAt(Double.valueOf(rs.getDouble(13)), this.filaGrid, 17);
                vrflete += rs.getDouble(12);
                vrdescuento += rs.getDouble(13);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        this.JTFTotalOCompra.setValue(Double.valueOf(vrCosto));
        this.txtTotalIva.setValue(Double.valueOf(vrIva));
        this.txtDescuento.setValue(Double.valueOf(vrdescuento));
        this.txtTotalFactura.setValue(Double.valueOf(((vrCosto + vrIva) + vrflete) - vrdescuento));
    }

    public void eliminarFilaGrid() {
        if (this.xmt.getPregunta("Esta seguro de Eliminar El Producto?") == 0) {
            this.entrada.getDetalleEntrada().remove(this.grid.getSelectedRow());
            this.modelo.removeRow(this.grid.getSelectedRow());
            this.filaGrid--;
            limpiarDatosProducto();
            this.xmt.mostrarMensaje("Producto Eliminado");
        }
    }

    public boolean validarValorMasFleteMayorQueValorDescuento(int indiceColumaValorUnitario, int indiceColumnaFlete, int indiceColumnaDescuento) {
        System.err.println("Filas de la tabla: " + this.modelo.getRowCount());
        if (this.modelo.getRowCount() >= 0) {
            for (int i = 0; i < this.modelo.getRowCount(); i++) {
                if (Double.parseDouble(this.modelo.getValueAt(i, indiceColumaValorUnitario).toString()) + Double.parseDouble(this.modelo.getValueAt(i, indiceColumnaFlete).toString()) <= Double.parseDouble(this.modelo.getValueAt(i, indiceColumnaDescuento).toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void grabar() {
        if (!validarValorMasFleteMayorQueValorDescuento(4, 16, 17)) {
            JOptionPane.showMessageDialog(this.rootPane, "Existen productos cuyo descuento es mayor al valor unitario, verificar");
        } else if (this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][2].equals("1")) {
            grabar1();
        } else {
            grabarSinRecepcion();
        }
    }

    private void mGrabarDetallle() {
        int y;
        this.sql = "SELECT Id FROM  i_entradas WHERE (NoFactura ='" + this.txtFactura.getText() + "' AND IdProveedor ='" + this.listaProveedor[this.cboProveedor.getSelectedIndex()] + "' AND IdBodega ='" + this.claseInv.getIdBodega() + "' AND Estado =0)";
        String encontrada = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (encontrada.isEmpty()) {
            if (Double.parseDouble(this.txtTotalFactura.getValue().toString()) > Double.parseDouble(this.JTFTotalOCompra.getValue().toString()) && !Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                y = JOptionPane.showInternalConfirmDialog(this, "El Valor de la Factura es mayor a la Orden de Compra\n Esta seguro de Grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            } else {
                y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
            if (y == 0) {
                if (!this.entrada.getDetalleEntrada().isEmpty()) {
                    IEntradas entradas = new IEntradas();
                    BodegaDTO bodegaDTO = new BodegaDTO();
                    IPeriodo periodo = new IPeriodo();
                    ITiposmovimientos tiposmovimientos = new ITiposmovimientos();
                    tiposmovimientos.setId(Short.valueOf(this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][0]));
                    periodo.setId(Integer.valueOf(this.claseInv.getXidperiodoc()));
                    bodegaDTO.setId(Long.valueOf(this.claseInv.getIdBodega()));
                    entradas.setAuxiliarConteo(this.JTFAuxiliar.getText().toUpperCase());
                    entradas.setEstado(false);
                    entradas.setFecha(this.xmt.getFechaActual());
                    entradas.setFechaEntrada(this.txtFecha.getDate());
                    entradas.setIdBodega(bodegaDTO);
                    entradas.setIdDocContable(0L);
                    entradas.setIdPeriodo(periodo);
                    entradas.setIdProveedor(Integer.valueOf(this.listaProveedor[this.cboProveedor.getSelectedIndex()]));
                    entradas.setIdRadicacionC(0L);
                    entradas.setIdRegistrofac(0);
                    entradas.setIdTipoMovimiento(tiposmovimientos);
                    entradas.setIdTipoRecp(Integer.valueOf(this.xidtiporecepcion));
                    entradas.setIdTransportadora(Integer.valueOf(this.xidtransportadora));
                    entradas.setNCajas(Integer.valueOf(this.JSPNCajas.getValue().toString()));
                    entradas.setNOrdenCompra(Integer.valueOf(this.JTFOrdenC.getText()));
                    entradas.setNoFactura(this.txtFactura.getText());
                    entradas.setObservacion(this.JTPObservacion.getText());
                    entradas.setTipoPago((short) this.formaPago);
                    entradas.setTransladada(false);
                    entradas.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    entradas.setVDescuento(this.entrada.getValorDescuento());
                    entradas.setVFletesO(this.entrada.getValorFlete());
                    this.suministroxbodega = this.suministroxbodegaService.listaUpdateCosto(Double.valueOf(this.modelo.getValueAt(y, 4).toString()), Integer.valueOf(bodegaDTO.getId().toString()), Integer.valueOf(this.modelo.getValueAt(y, 0).toString()));
                    List<IDetalleentrada> detalleentradas = new ArrayList<>();
                    for (EntradaDetalle d : this.entrada.getDetalleEntrada()) {
                        IDetalleentrada detalleentrada = new IDetalleentrada();
                        ISuministro suministro = new ISuministro();
                        suministro.setId(d.getIdSuministro());
                        detalleentrada.setIdEntrada(entradas);
                        detalleentrada.setAcepta(d.getAcepta());
                        detalleentrada.setCantidad(d.getCantidad().doubleValue());
                        System.out.println("" + d.getFechaVecimiento());
                        detalleentrada.setFechaVencimiento(d.getFechaVecimiento());
                        detalleentrada.setIdSuministro(suministro);
                        detalleentrada.setIva(d.getPoncentajeImpuesto().doubleValue());
                        detalleentrada.setLote(d.getLote());
                        detalleentrada.setMuestreo(d.getCantidadMuestreo());
                        detalleentrada.setObservaciones(d.getObservacion());
                        detalleentrada.setTemperatura(d.getTemperatura());
                        detalleentrada.setVDescuento(d.getValorUnitarioDescuento());
                        detalleentrada.setVFletesO(d.getValorUnitarioFlete());
                        detalleentrada.setValorUnitario(d.getValorUnitario().doubleValue());
                        detalleentradas.add(detalleentrada);
                    }
                    entradas.setIDetalleentradaCollection(detalleentradas);
                    this.JLBIdEntrada.setText("" + this.iEntradaService.grabar(entradas).getId());
                    cargarFormularioContabilizacion();
                    Principal.xClaseInventario.mReportesEntradas(this.JLBIdEntrada.getText());
                    mActualizarEstadoROrdenC();
                    this.grabada = 1;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La Factura con el Proveedor y la Bodega ya se encuentra registrada \nCon el número : " + encontrada + ".    No podrá realizar cambios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void grabarRadicacion() {
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
        }
    }

    private void grabarDetalleSinRecepcion() {
        int y;
        this.sql = "SELECT Id FROM  i_entradas WHERE (NoFactura ='" + this.txtFactura.getText() + "' AND IdProveedor ='" + this.listaProveedor[this.cboProveedor.getSelectedIndex()] + "' AND IdBodega ='" + this.claseInv.getIdBodega() + "' AND Estado =0)";
        String encontrada = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (encontrada.isEmpty() && (y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))))) == 0 && !this.entrada.getDetalleEntrada().isEmpty()) {
            IEntradas entradas = new IEntradas();
            BodegaDTO bodegaDTO = new BodegaDTO();
            IPeriodo periodo = new IPeriodo();
            ITiposmovimientos tiposmovimientos = new ITiposmovimientos();
            tiposmovimientos.setId(Short.valueOf(this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][0]));
            periodo.setId(Integer.valueOf(this.claseInv.getXidperiodoc()));
            bodegaDTO.setId(Long.valueOf(this.claseInv.getIdBodega()));
            entradas.setAuxiliarConteo(this.JTFAuxiliar.getText().toUpperCase());
            entradas.setEstado(false);
            entradas.setFecha(this.xmt.getFechaActual());
            entradas.setFechaEntrada(this.txtFecha.getDate());
            entradas.setIdBodega(bodegaDTO);
            entradas.setIdDocContable(0L);
            entradas.setIdPeriodo(periodo);
            entradas.setIdProveedor(Integer.valueOf(this.listaProveedor[this.cboProveedor.getSelectedIndex()]));
            entradas.setIdRadicacionC(0L);
            entradas.setIdRegistrofac(0);
            entradas.setIdTipoMovimiento(tiposmovimientos);
            entradas.setIdTipoRecp(Integer.valueOf(this.xidtiporecepcion));
            entradas.setIdTransportadora(Integer.valueOf(this.xidtransportadora));
            entradas.setNCajas(Integer.valueOf(this.JSPNCajas.getValue().toString()));
            entradas.setNOrdenCompra(Integer.valueOf(this.JTFOrdenC.getText()));
            entradas.setNoFactura(this.txtFactura.getText());
            entradas.setObservacion(this.JTPObservacion.getText());
            entradas.setTipoPago((short) this.formaPago);
            entradas.setTransladada(false);
            entradas.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            entradas.setVDescuento(this.entrada.getValorDescuento());
            entradas.setVFletesO(this.entrada.getValorFlete());
            this.suministroxbodega = this.suministroxbodegaService.listaUpdateCosto(Double.valueOf(this.modelo.getValueAt(y, 4).toString()), Integer.valueOf(bodegaDTO.getId().toString()), Integer.valueOf(this.modelo.getValueAt(y, 0).toString()));
            List<IDetalleentrada> detalleentradas = new ArrayList<>();
            for (EntradaDetalle d : this.entrada.getDetalleEntrada()) {
                IDetalleentrada detalleentrada = new IDetalleentrada();
                ISuministro suministro = new ISuministro();
                suministro.setId(d.getIdSuministro());
                detalleentrada.setIdEntrada(entradas);
                detalleentrada.setAcepta(d.getAcepta());
                detalleentrada.setCantidad(d.getCantidad().doubleValue());
                System.out.println("" + d.getFechaVecimiento() + d.getIdSuministro());
                detalleentrada.setFechaVencimiento(d.getFechaVecimiento());
                detalleentrada.setIdSuministro(suministro);
                detalleentrada.setIva(d.getPoncentajeImpuesto().doubleValue());
                detalleentrada.setLote(d.getLote());
                detalleentrada.setMuestreo(d.getCantidadMuestreo());
                detalleentrada.setObservaciones(d.getObservacion());
                detalleentrada.setTemperatura(d.getTemperatura());
                detalleentrada.setVDescuento(d.getValorUnitarioDescuento());
                detalleentrada.setVFletesO(d.getValorUnitarioFlete());
                detalleentrada.setValorUnitario(d.getValorUnitario().doubleValue());
                detalleentradas.add(detalleentrada);
            }
            entradas.setIDetalleentradaCollection(detalleentradas);
            this.JLBIdEntrada.setText("" + this.iEntradaService.grabar(entradas).getId());
            cargarFormularioContabilizacion();
            Principal.xClaseInventario.mReportesEntradas(this.JLBIdEntrada.getText());
            mActualizarEstadoROrdenC();
            this.grabada = 1;
        }
    }

    public void grabar1() {
        if (this.JLBIdEntrada.getText().isEmpty()) {
            if (this.claseInv.getXidperiodoc() != -1) {
                if (this.claseInv.isXestadop()) {
                    if (!this.claseInv.mVerificarMovDPeriodo(this.txtFecha.getDate())) {
                        if (this.idEntrada.isEmpty()) {
                            if (!this.txtFactura.getText().isEmpty()) {
                                if (this.cboProveedor.getSelectedIndex() != -1) {
                                    if (this.cboTipoMovimiento.getSelectedIndex() != -1) {
                                        if (this.modelo.getRowCount() > 0) {
                                            if (this.JTFFValor.getText().equals(this.txtTotalFactura.getText())) {
                                                if (!Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                                                    if (!this.JTFOrdenC.getText().equals("0")) {
                                                        mGrabarDetallle();
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una orden de compra", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JTPDatosE.setSelectedIndex(1);
                                                    this.JTFOrdenC.requestFocus();
                                                    return;
                                                }
                                                mGrabarDetallle();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "El valor a entrar no es igual al valor de la factura;\nFavor ravisar.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Por favor digite los Productos para la Entrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Tipo de Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.cboTipoMovimiento.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Por favor seleccione un Proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.cboProveedor.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Por favor digite el Número de Factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.txtFactura.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Factura ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.txtFecha.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen período abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Entrada ya grabada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void grabar2() {
        if (this.JLBIdEntrada.getText().isEmpty()) {
            if (this.claseInv.getXidperiodoc() != -1) {
                if (this.claseInv.isXestadop()) {
                    if (!this.claseInv.mVerificarMovDPeriodo(this.txtFecha.getDate())) {
                        if (this.idEntrada.isEmpty()) {
                            if (!this.txtFactura.getText().isEmpty()) {
                                if (this.cboProveedor.getSelectedIndex() != -1) {
                                    if (this.cboTipoMovimiento.getSelectedIndex() != -1) {
                                        if (this.modelo.getRowCount() > 0) {
                                            if (!this.JTFOrdenC.getText().equals("0")) {
                                                if (this.JTFFValor.getText().equals(this.txtTotalFactura.getText())) {
                                                    this.sql = "SELECT Id FROM  i_entradas WHERE (NoFactura ='" + this.txtFactura.getText() + "' AND IdProveedor ='" + this.listaProveedor[this.cboProveedor.getSelectedIndex()] + "' AND IdBodega ='" + this.claseInv.getIdBodega() + "' AND Estado =0)";
                                                    String encontrada = this.consultas.traerDato(this.sql);
                                                    this.consultas.cerrarConexionBd();
                                                    if (encontrada.isEmpty()) {
                                                        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                        if (y == 0) {
                                                            grabarCabeceraEntrada();
                                                            for (int x = 0; x < this.grid.getRowCount(); x++) {
                                                                String fecha1 = this.grid.getModel().getValueAt(x, 9).toString().substring(6, 10) + this.grid.getModel().getValueAt(x, 9).toString().substring(2, 6) + this.grid.getModel().getValueAt(x, 9).toString().substring(0, 2);
                                                                this.claseInv.mActualizarIvaDelSuministro(Double.valueOf(this.modelo.getValueAt(x, 5).toString()).doubleValue(), Integer.valueOf(this.modelo.getValueAt(x, 0).toString()).intValue());
                                                                this.sql = "INSERT INTO i_detalleentrada(IdEntrada, IdSuministro, Lote, FechaVencimiento, Cantidad, ValorUnitario, Iva, Acepta, Observaciones, Temperatura,  VFletesO, VDescuento,muestreo) VALUES ('" + this.JLBIdEntrada.getText() + "','" + this.grid.getModel().getValueAt(x, 0) + "','" + this.grid.getModel().getValueAt(x, 8) + "','" + fecha1 + "','" + this.grid.getModel().getValueAt(x, 3) + "','" + this.grid.getModel().getValueAt(x, 4) + "','" + this.grid.getModel().getValueAt(x, 5) + "','" + this.xacepta + "','" + this.grid.getModel().getValueAt(x, 11).toString().toUpperCase() + "','" + this.grid.getModel().getValueAt(x, 14) + "','" + this.grid.getModel().getValueAt(x, 16) + "','" + this.grid.getModel().getValueAt(x, 17) + "','" + this.grid.getModel().getValueAt(x, 20) + "')";
                                                                JOptionPane.showMessageDialog((Component) null, this.grid.getModel().getValueAt(x, 20));
                                                                this.consultas.ejecutarSQL(this.sql);
                                                                this.consultas.cerrarConexionBd();
                                                                mActualizarMPuntoRPedido(this.grid.getModel().getValueAt(x, 0).toString());
                                                                this.sql = "INSERT INTO i_tmpentrada (Id_Entrada,Id_Suministro,ValorActual) SELECT '" + this.JLBIdEntrada.getText() + "', Id, Costo FROM i_suministroxbodega WHERE (Id ='" + Integer.valueOf(this.grid.getModel().getValueAt(x, 13).toString()) + "') ";
                                                                this.consultas.ejecutarSQL(this.sql);
                                                                this.consultas.cerrarConexionBd();
                                                                System.out.println(this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][1].toString());
                                                                if (this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][1].toString().equals("1")) {
                                                                    double xvtotal = (Double.valueOf(this.grid.getModel().getValueAt(x, 4).toString()).doubleValue() + Double.valueOf(this.grid.getModel().getValueAt(x, 16).toString()).doubleValue()) - Double.valueOf(this.grid.getModel().getValueAt(x, 17).toString()).doubleValue();
                                                                    this.claseInv.mActualizarValorPromedio(Integer.valueOf(this.grid.getModel().getValueAt(x, 13).toString()).intValue(), xvtotal, Double.valueOf(this.grid.getModel().getValueAt(x, 6).toString()).doubleValue());
                                                                }
                                                                this.claseInv.mSumarCantidadInventario(Integer.valueOf(this.grid.getModel().getValueAt(x, 13).toString()).intValue(), Double.valueOf(this.grid.getModel().getValueAt(x, 3).toString()), this.grid.getModel().getValueAt(x, 8).toString(), fecha1, Double.valueOf(this.grid.getModel().getValueAt(x, 15).toString()));
                                                                this.sql = "update cc_detalle_orden_compra set CantidadR=CantidadR+" + this.grid.getModel().getValueAt(x, 3) + " where Id_Producto='" + this.grid.getModel().getValueAt(x, 0) + "' and Id_OrdenC='" + this.JTFOrdenC.getText() + "'";
                                                                System.out.println("Cantidad re  " + this.sql);
                                                                this.consultas.ejecutarSQL(this.sql);
                                                                this.consultas.cerrarConexionBd();
                                                            }
                                                            Principal.xClaseInventario.mReportesEntradas(this.JLBIdEntrada.getText());
                                                            mActualizarEstadoROrdenC();
                                                            this.grabada = 1;
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this, "La Factura con el Proveedor y la Bodega ya se encuentra registrada \nCon el número : " + encontrada + ".    No podrá realizar cambios", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "El valor a entrar no es igual al valor de la factura;\nFavor ravisar.", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una orden de compra", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTPDatosE.setSelectedIndex(1);
                                            this.JTFOrdenC.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Por favor digite los Productos para la Entrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Tipo de Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.cboTipoMovimiento.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Por favor seleccione un Proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.cboProveedor.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Por favor digite el Número de Factura", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.txtFactura.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Factura ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.txtFecha.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen período abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Entrada ya grabada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void grabarSinRecepcion() {
        if (this.JLBIdEntrada.getText().isEmpty()) {
            if (this.claseInv.getXidperiodoc() != -1) {
                if (this.claseInv.isXestadop()) {
                    if (!this.claseInv.mVerificarMovDPeriodo(this.txtFecha.getDate())) {
                        if (this.idEntrada.isEmpty()) {
                            if (this.cboProveedor.getSelectedIndex() != -1) {
                                if (this.cboTipoMovimiento.getSelectedIndex() != -1) {
                                    if (this.modelo.getRowCount() > 0) {
                                        grabarDetalleSinRecepcion();
                                        return;
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Por favor digite los Productos para la Entrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                }
                                JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Tipo de Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.cboTipoMovimiento.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione un Proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.cboProveedor.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Factura ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.txtFecha.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen período abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Entrada ya grabada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void grabarCabeceraEntrada() {
        this.sql = "INSERT INTO i_entradas(NoFactura, IdProveedor, Id_TipoRecp, FechaEntrada, Id_Periodo, IdTipoMovimiento, IdBodega, Estado, TipoPago, NCajas, Id_Transportadora, AuxiliarConteo, NOrdenCompra, Observacion, VFletesO, VDescuento, Fecha, UsuarioS) VALUES ('" + this.txtFactura.getText() + "','" + this.listaProveedor[this.cboProveedor.getSelectedIndex()] + "','" + this.xidtiporecepcion + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.claseInv.getXidperiodoc() + "','" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][0] + "','" + this.claseInv.getIdBodega() + "', 0,'" + this.formaPago + "','" + this.JSPNCajas.getValue() + "','" + this.xidtransportadora + "','" + this.JTFAuxiliar.getText().toUpperCase() + "','" + this.JTFOrdenC.getText() + "','" + this.JTPObservacion.getText() + "','" + this.txtFlete.getValue() + "','" + this.txtDescuento.getValue() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.idEntrada = this.consultas.ejecutarSQLId(this.sql);
        Principal.txtNo.setText(this.idEntrada);
        this.fecha = this.xmt.formatoDMA.format(this.txtFecha.getDate());
        this.estado = "ACTIVO";
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        this.consultas.cerrarConexionBd();
        String xsql = "update  i_msolicitud_pedido set Id_Entrada='" + this.idEntrada + "' where Id='" + this.JSPNSolicitudP.getValue() + "'";
        this.consultas.ejecutarSQL(xsql);
        this.consultas.cerrarConexionBd();
    }

    private void mActualizarMPuntoRPedido(String xidproducto) {
        try {
            String xsql = "SELECT CodigoAgrupacion FROM i_suministro WHERE (Id ='" + xidproducto + "') ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                String xsql2 = "update  i_manejo_puntosr set Entro=1 where Id_Producto='" + xrs.getString(1) + "' and Id_msolicitud='" + this.JSPNSolicitudP.getValue() + "'";
                xct1.ejecutarSQL(xsql2);
                xct1.cerrarConexionBd();
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarEstadoROrdenC() {
        if (Double.valueOf(this.txtTotalFactura.getValue().toString()).doubleValue() <= Double.valueOf(this.JTFTotalOCompra.getValue().toString()).doubleValue()) {
            this.sql = "update cc_orden_compra set EstadoR=1 where Id='" + this.JTFOrdenC.getText() + "'";
        } else {
            this.sql = "update cc_orden_compra set EstadoR=2 where Id='" + this.JTFOrdenC.getText() + "'";
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void imprimir() {
        if (this.JLBIdEntrada.getText() == null || this.JLBIdEntrada.getText().equals("") || Integer.parseInt(this.JLBIdEntrada.getText()) < 1) {
            this.xmt.mostrarMensaje("Por favor seleccione una Entrada para Imprimir");
        } else {
            Principal.xClaseInventario.mReportesEntradas(this.JLBIdEntrada.getText());
        }
    }

    public void limpiarDatosProducto() {
        this.txtCodigo.setText("");
        this.txtProducto.setText("");
        this.txtExistencia.setValue(0);
        this.txtValorUnidad.setValue(0);
        this.txtIva.setValue(0);
        this.txtValorIva.setValue(0);
        this.txtValorTotalUnidad.setValue(0);
        this.txtValorTotal.setValue(0);
        this.JTFFCU.setValue(1);
        this.JSPTemperatura.setValue(0);
        this.JSPCPendiente.setValue(0);
        this.txtLote.setText("");
        this.xacepta = 1;
        this.JCHAcepta.setSelected(true);
        this.JTPObservacion.setText("");
        this.xobservacion = "";
        this.txtMuestreo.setText("0");
        this.sueno = 0;
    }

    public final void nuevo() {
        this.xlleno = false;
        crearGrid();
        this.JLBIdEntrada.setText("");
        this.entrada = new Entrada();
        this.idEntrada = "";
        this.suministroxbodega = new ArrayList();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        Principal.mLimpiarDatosP();
        this.txtFactura.setText("");
        this.cboProveedor.setSelectedIndex(-1);
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.btnCredito.setSelected(true);
        this.xmt.limpiarDatosPrincipal();
        this.txtVencimiento.setDate(this.xmt.getFechaActual());
        limpiarDatosProducto();
        this.txtFlete.setValue(0);
        this.txtDescuento.setValue(0);
        this.xcodogi_agrupacion = 0L;
        this.JTFFValor.setValue(0);
        this.JTFTotalOCompra.setValue(0);
        this.txtTotalIva.setValue(0);
        this.txtTotalFactura.setValue(0);
        this.txtTotalCosto.setValue(0);
        this.JTFTotalOCompra.setValue(0);
        this.JTFFCU.setValue(1);
        this.formaPago = 0;
        this.grabada = 0;
        this.filaGrid = 0;
        this.txtFactura.requestFocus();
        this.JTPDatosE.setEnabledAt(1, false);
        this.xlleno = true;
        this.txtCantidad.setValue(new Double(0.0d));
    }

    private void mValidar_Cantidad_OrdenCompra() {
        if (!this.JTFOrdenC.getText().equals("0") && Double.valueOf(this.txtCantidad.getValue().toString()).doubleValue() != 0.0d && this.xcodogi_agrupacion != 1) {
            try {
                this.sql = "SELECT `cc_detalle_orden_compra`.`Cantidad` FROM `cc_detalle_orden_compra` INNER JOIN `cc_orden_compra`  ON (`cc_detalle_orden_compra`.`Id_OrdenC` = `cc_orden_compra`.`Id`) INNER JOIN `i_suministro`  ON (`cc_detalle_orden_compra`.`Id_Producto` = `i_suministro`.`Id`) WHERE (`cc_orden_compra`.`Id` ='" + this.JTFOrdenC.getText() + "' AND `i_suministro`.`CodigoAgrupacion` =" + this.xcodogi_agrupacion + " ) ";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(this.sql);
                if (xrs.next()) {
                    xrs.first();
                    if (Double.valueOf(this.txtCantidad.getValue().toString()).doubleValue() > xrs.getDouble(1)) {
                        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Cantidad mayor a la solicitada en la orden de compra.", "CONTROL DE CANTIDAD VS ORDEN DE COMPRA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        this.txtCantidad.setValue(Long.valueOf(xrs.getLong(1)));
                    }
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void refrescarValores() {
        this.txtValorIva.setValue(Double.valueOf((Double.valueOf(this.txtValorUnidad.getValue().toString()).doubleValue() * Double.valueOf(this.txtIva.getValue().toString()).doubleValue()) / 100.0d));
        this.txtValorTotalUnidad.setValue(Double.valueOf(Double.valueOf(this.txtValorUnidad.getValue().toString()).doubleValue() + Double.valueOf(this.txtValorIva.getValue().toString()).doubleValue()));
        this.txtValorTotal.setValue(Double.valueOf(Double.valueOf(this.txtCantidad.getValue().toString()).doubleValue() * Double.valueOf(this.txtValorTotalUnidad.getValue().toString()).doubleValue()));
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JBGTipoDistribucion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.grid = new JTable();
        this.panelInformacion = new JPanel();
        this.txtCodigo = new JTextField();
        this.panelValor = new JPanel();
        this.txtCantidad = new JSpinner();
        this.txtValorUnidad = new JSpinner();
        this.txtIva = new JSpinner();
        this.txtValorIva = new JFormattedTextField();
        this.txtValorTotalUnidad = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.txtLote = new JTextField();
        this.btnCargar = new JButton();
        this.JTFFCU = new JFormattedTextField();
        this.JSPTemperatura = new JSpinner();
        this.JSPCPendiente = new JSpinner();
        this.txtVencimiento = new JDateChooser();
        this.btnBuscarProducto = new JButton();
        this.txtExistencia = new JFormattedTextField();
        this.txtProducto = new JTextField();
        this.JCHAcepta = new JCheckBox();
        this.txtMuestreo = new JTextField();
        this.JTPDatosE = new JTabbedPane();
        this.panelDatosEntrada = new JPanel();
        this.txtFactura = new JTextField();
        this.panelformapago = new JPanel();
        this.btnCredito = new JRadioButton();
        this.btnContado = new JRadioButton();
        this.btnNoAplica = new JRadioButton();
        this.txtTotalIva = new JFormattedTextField();
        this.txtTotalFactura = new JFormattedTextField();
        this.btnOrdenCompra = new JButton();
        this.JTFTotalOCompra = new JFormattedTextField();
        this.txtFecha = new JDateChooser();
        this.panelFletes = new JPanel();
        this.txtDescuento = new JFormattedTextField();
        this.txtFlete = new JFormattedTextField();
        this.cboProveedor = new JComboBox();
        this.cboTipoMovimiento = new JComboBox();
        this.txtTotalCosto = new JFormattedTextField();
        this.JTFFValor = new JFormattedTextField();
        this.JPTipoRecepcion = new JPanel();
        this.JCTipo = new JComboBox();
        this.JSPNCajas = new JSpinner();
        this.JCBTransportadora = new JComboBox();
        this.JTFAuxiliar = new JTextField();
        this.JTFOrdenC = new JTextField();
        this.JSPNSolicitudP = new JSpinner();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Utilidades = new JPanel();
        this.JBTCarguesA1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA = new JButton();
        this.JPDistribucion = new JPanel();
        this.JRBAutomatica = new JRadioButton();
        this.JRBManual = new JRadioButton();
        this.JLBIdEntrada = new JLabel();
        this.jPanel1 = new JPanel();
        this.JBTCarguesA2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ENTRADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1196, 713));
        setMinimumSize(new Dimension(1196, 713));
        setName("Entradas");
        setNormalBounds(new Rectangle(0, 0, 113, 0));
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.Entradas.2
            public void internalFrameActivated(InternalFrameEvent evt) {
                Entradas.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Entradas.this.formInternalFrameClosing(evt);
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
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.Entradas.3
            public void mouseClicked(MouseEvent evt) {
                Entradas.this.gridMouseClicked(evt);
            }
        });
        this.grid.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.Entradas.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Entradas.this.gridPropertyChange(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Inventarios.Entradas.5
            public void keyPressed(KeyEvent evt) {
                Entradas.this.gridKeyPressed(evt);
            }
        });
        this.grid.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.Entradas.6
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Entradas.this.gridVetoableChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.grid);
        this.panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DATOS DEL INSUMO Y/O DISPOSITIVO MEDICO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.7
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtCodigoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Entradas.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.8
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtCodigoActionPerformed(evt);
            }
        });
        this.panelValor.setBorder(BorderFactory.createEtchedBorder());
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setModel(new SpinnerNumberModel(Double.valueOf(1.0d), (Comparable) null, (Comparable) null, Double.valueOf(0.10000000149011612d)));
        this.txtCantidad.setToolTipText("Cantidad del Producto que entra");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCantidad.setFocusTraversalPolicyProvider(true);
        this.txtCantidad.setVerifyInputWhenFocusTarget(false);
        this.txtCantidad.addChangeListener(new ChangeListener() { // from class: Inventarios.Entradas.9
            public void stateChanged(ChangeEvent evt) {
                Entradas.this.txtCantidadStateChanged(evt);
            }
        });
        this.txtCantidad.addKeyListener(new KeyAdapter() { // from class: Inventarios.Entradas.10
            public void keyPressed(KeyEvent evt) {
                Entradas.this.txtCantidadKeyPressed(evt);
            }
        });
        this.txtValorUnidad.setFont(new Font("Arial", 1, 12));
        this.txtValorUnidad.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(1.0f)));
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtValorUnidad.setValue(new Double(0.0d));
        this.txtValorUnidad.addChangeListener(new ChangeListener() { // from class: Inventarios.Entradas.11
            public void stateChanged(ChangeEvent evt) {
                Entradas.this.txtValorUnidadStateChanged(evt);
            }
        });
        this.txtIva.setFont(new Font("Arial", 1, 12));
        this.txtIva.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.10000000000000009d));
        this.txtIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtIva.addChangeListener(new ChangeListener() { // from class: Inventarios.Entradas.12
            public void stateChanged(ChangeEvent evt) {
                Entradas.this.txtIvaStateChanged(evt);
            }
        });
        this.txtValorIva.setEditable(false);
        this.txtValorIva.setBackground(new Color(0, 0, 102));
        this.txtValorIva.setBorder(BorderFactory.createTitledBorder((Border) null, "V/iva", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtValorIva.setForeground(new Color(255, 255, 255));
        this.txtValorIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.txtValorIva.setHorizontalAlignment(4);
        this.txtValorIva.setDisabledTextColor(new Color(102, 0, 102));
        this.txtValorIva.setFocusable(false);
        this.txtValorIva.setFont(new Font("Arial", 1, 14));
        this.txtValorIva.setValue(new Double(0.0d));
        this.txtValorIva.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.13
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtValorIvaActionPerformed(evt);
            }
        });
        this.txtValorTotalUnidad.setEditable(false);
        this.txtValorTotalUnidad.setBackground(new Color(0, 0, 102));
        this.txtValorTotalUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total Unidad", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtValorTotalUnidad.setForeground(new Color(255, 255, 255));
        this.txtValorTotalUnidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.txtValorTotalUnidad.setHorizontalAlignment(4);
        this.txtValorTotalUnidad.setDisabledTextColor(new Color(102, 0, 102));
        this.txtValorTotalUnidad.setFocusable(false);
        this.txtValorTotalUnidad.setFont(new Font("Arial", 1, 14));
        this.txtValorTotalUnidad.setValue(new Double(0.0d));
        this.txtValorTotalUnidad.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.14
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtValorTotalUnidadActionPerformed(evt);
            }
        });
        this.txtValorTotal.setBackground(new Color(0, 0, 102));
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtValorTotal.setForeground(new Color(255, 255, 255));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setDisabledTextColor(new Color(102, 0, 102));
        this.txtValorTotal.setFocusable(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 14));
        this.txtValorTotal.setValue(new Double(0.0d));
        this.txtValorTotal.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.15
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtValorTotalActionPerformed(evt);
            }
        });
        this.txtLote.setFont(new Font("Arial", 1, 12));
        this.txtLote.setHorizontalAlignment(4);
        this.txtLote.setText("ABC");
        this.txtLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtLote.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.16
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtLoteFocusGained(evt);
            }
        });
        this.txtLote.addMouseListener(new MouseAdapter() { // from class: Inventarios.Entradas.17
            public void mouseClicked(MouseEvent evt) {
                Entradas.this.txtLoteMouseClicked(evt);
            }
        });
        this.txtLote.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.18
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtLoteActionPerformed(evt);
            }
        });
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.19
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnCargarActionPerformed(evt);
            }
        });
        this.JTFFCU.setEditable(false);
        this.JTFFCU.setBorder(BorderFactory.createTitledBorder((Border) null, "C/U", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCU.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCU.setHorizontalAlignment(4);
        this.JTFFCU.setFont(new Font("Arial", 1, 12));
        this.JSPTemperatura.setFont(new Font("Arial", 1, 12));
        this.JSPTemperatura.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(1.0f)));
        this.JSPTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Temp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTemperatura.addChangeListener(new ChangeListener() { // from class: Inventarios.Entradas.20
            public void stateChanged(ChangeEvent evt) {
                Entradas.this.JSPTemperaturaStateChanged(evt);
            }
        });
        this.JSPCPendiente.setFont(new Font("Arial", 1, 12));
        this.JSPCPendiente.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(50.0f), Float.valueOf(1.0f)));
        this.JSPCPendiente.setToolTipText("Cantidad para pendiente");
        this.JSPCPendiente.setBorder(BorderFactory.createTitledBorder((Border) null, "CP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCPendiente.addChangeListener(new ChangeListener() { // from class: Inventarios.Entradas.21
            public void stateChanged(ChangeEvent evt) {
                Entradas.this.JSPCPendienteStateChanged(evt);
            }
        });
        this.txtVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "FVencimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVencimiento.setDateFormatString("dd/MM/yyyy");
        this.txtVencimiento.setFont(new Font("Arial", 1, 12));
        GroupLayout panelValorLayout = new GroupLayout(this.panelValor);
        this.panelValor.setLayout(panelValorLayout);
        panelValorLayout.setHorizontalGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelValorLayout.createSequentialGroup().addContainerGap().addComponent(this.txtCantidad, -2, 85, -2).addGap(18, 18, 18).addComponent(this.JSPCPendiente, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorUnidad, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtIva, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCU, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorIva, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorTotalUnidad, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorTotal, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtLote, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVencimiento, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTemperatura, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargar, -1, -1, 32767).addContainerGap()));
        panelValorLayout.setVerticalGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelValorLayout.createSequentialGroup().addContainerGap().addGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelValorLayout.createSequentialGroup().addGap(7, 7, 7).addGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCantidad, -2, 50, -2).addComponent(this.txtValorUnidad, -2, 50, -2).addComponent(this.txtIva, -2, 50, -2).addComponent(this.JSPCPendiente, -2, 50, -2)).addComponent(this.JTFFCU, -2, 50, -2))).addComponent(this.btnCargar, -1, -1, 32767).addGroup(panelValorLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.txtValorIva, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, panelValorLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelValorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtLote, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JSPTemperatura, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.txtVencimiento, GroupLayout.Alignment.TRAILING, -1, 50, 32767)).addGroup(GroupLayout.Alignment.TRAILING, panelValorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorTotalUnidad, -2, 50, -2).addComponent(this.txtValorTotal, -2, 50, -2))))).addContainerGap()));
        this.btnBuscarProducto.setForeground(new Color(0, 0, 153));
        this.btnBuscarProducto.setText("...");
        this.btnBuscarProducto.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.22
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnBuscarProductoActionPerformed(evt);
            }
        });
        this.txtExistencia.setBackground(new Color(0, 0, 102));
        this.txtExistencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia Inventario", 0, 0, new Font("Helvetica Neue", 0, 13), new Color(204, 255, 255)));
        this.txtExistencia.setForeground(new Color(255, 255, 255));
        this.txtExistencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtExistencia.setHorizontalAlignment(4);
        this.txtExistencia.setDisabledTextColor(new Color(255, 255, 255));
        this.txtExistencia.setEnabled(false);
        this.txtExistencia.setFont(new Font("Tahoma", 1, 14));
        this.txtExistencia.setValue(new Integer(0));
        this.txtProducto.setBackground(new Color(0, 0, 102));
        this.txtProducto.setFont(new Font("Tahoma", 1, 13));
        this.txtProducto.setForeground(new Color(255, 255, 255));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12)));
        this.txtProducto.setDisabledTextColor(new Color(255, 255, 255));
        this.txtProducto.setEnabled(false);
        this.JCHAcepta.setFont(new Font("Arial", 1, 12));
        this.JCHAcepta.setSelected(true);
        this.JCHAcepta.setText("Acepta?");
        this.JCHAcepta.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.23
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JCHAceptaActionPerformed(evt);
            }
        });
        this.txtMuestreo.setFont(new Font("Arial", 1, 12));
        this.txtMuestreo.setHorizontalAlignment(0);
        this.txtMuestreo.setText("0");
        this.txtMuestreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Muestreo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtMuestreo.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.24
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtMuestreoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Entradas.this.txtMuestreoFocusLost(evt);
            }
        });
        this.txtMuestreo.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.25
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtMuestreoActionPerformed(evt);
            }
        });
        GroupLayout panelInformacionLayout = new GroupLayout(this.panelInformacion);
        this.panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInformacionLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelValor, -1, -1, 32767).addGroup(panelInformacionLayout.createSequentialGroup().addComponent(this.txtCodigo, -2, 120, -2).addGap(10, 10, 10).addComponent(this.txtProducto, -2, 638, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscarProducto, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtExistencia, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAcepta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtMuestreo, -2, 81, -2))).addContainerGap()));
        panelInformacionLayout.setVerticalGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInformacionLayout.createSequentialGroup().addGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtExistencia, -2, 51, -2).addGroup(panelInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAcepta).addComponent(this.txtMuestreo, -2, 55, -2))).addGroup(panelInformacionLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.txtCodigo, -2, 48, -2))).addComponent(this.txtProducto, GroupLayout.Alignment.TRAILING, -2, 52, -2)).addComponent(this.btnBuscarProducto, GroupLayout.Alignment.TRAILING, -2, 52, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelValor, -2, -1, -2)));
        this.JTPDatosE.setForeground(new Color(0, 103, 0));
        this.JTPDatosE.setFont(new Font("Arial", 1, 14));
        this.panelDatosEntrada.setLayout((LayoutManager) null);
        this.txtFactura.setFont(new Font("Arial", 1, 12));
        this.txtFactura.setHorizontalAlignment(4);
        this.txtFactura.setToolTipText("Número de Factura enviada por el Proveedor");
        this.txtFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFactura.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.26
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtFacturaFocusGained(evt);
            }
        });
        this.txtFactura.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.27
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtFacturaActionPerformed(evt);
            }
        });
        this.txtFactura.addKeyListener(new KeyAdapter() { // from class: Inventarios.Entradas.28
            public void keyReleased(KeyEvent evt) {
                Entradas.this.txtFacturaKeyReleased(evt);
            }
        });
        this.panelDatosEntrada.add(this.txtFactura);
        this.txtFactura.setBounds(150, 30, 130, 50);
        this.panelformapago.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMAS DE PAGO", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.buttonGroup1.add(this.btnCredito);
        this.btnCredito.setFont(new Font("Arial", 1, 12));
        this.btnCredito.setForeground(new Color(0, 0, 255));
        this.btnCredito.setSelected(true);
        this.btnCredito.setText("Credito");
        this.btnCredito.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.29
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnCreditoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnContado);
        this.btnContado.setFont(new Font("Arial", 1, 12));
        this.btnContado.setForeground(new Color(0, 0, 255));
        this.btnContado.setText("Contado");
        this.btnContado.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.30
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnContadoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnNoAplica);
        this.btnNoAplica.setFont(new Font("Arial", 1, 12));
        this.btnNoAplica.setForeground(new Color(0, 0, 255));
        this.btnNoAplica.setText("No Aplica");
        this.btnNoAplica.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.31
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnNoAplicaActionPerformed(evt);
            }
        });
        GroupLayout panelformapagoLayout = new GroupLayout(this.panelformapago);
        this.panelformapago.setLayout(panelformapagoLayout);
        panelformapagoLayout.setHorizontalGroup(panelformapagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelformapagoLayout.createSequentialGroup().addGroup(panelformapagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCredito).addComponent(this.btnContado).addComponent(this.btnNoAplica, -2, 102, -2)).addContainerGap(16, 32767)));
        panelformapagoLayout.setVerticalGroup(panelformapagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelformapagoLayout.createSequentialGroup().addComponent(this.btnCredito).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnContado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnNoAplica).addContainerGap(-1, 32767)));
        this.panelDatosEntrada.add(this.panelformapago);
        this.panelformapago.setBounds(580, 20, 130, 130);
        this.txtTotalIva.setBackground(new Color(0, 0, 102));
        this.txtTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Total IVA $", 0, 0, new Font("Helvetica Neue", 0, 13), new Color(204, 255, 255)));
        this.txtTotalIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.txtTotalIva.setHorizontalAlignment(4);
        this.txtTotalIva.setDisabledTextColor(new Color(255, 255, 255));
        this.txtTotalIva.setEnabled(false);
        this.txtTotalIva.setFont(new Font("Arial", 1, 15));
        this.txtTotalIva.setValue(new Double(0.0d));
        this.panelDatosEntrada.add(this.txtTotalIva);
        this.txtTotalIva.setBounds(1020, 20, 130, 40);
        this.txtTotalFactura.setBackground(new Color(0, 0, 102));
        this.txtTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Factura $", 0, 0, new Font("Helvetica Neue", 0, 13), new Color(204, 255, 255)));
        this.txtTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.txtTotalFactura.setHorizontalAlignment(4);
        this.txtTotalFactura.setDisabledTextColor(new Color(255, 255, 255));
        this.txtTotalFactura.setEnabled(false);
        this.txtTotalFactura.setFont(new Font("Arial", 1, 15));
        this.txtTotalFactura.setValue(new Double(0.0d));
        this.panelDatosEntrada.add(this.txtTotalFactura);
        this.txtTotalFactura.setBounds(870, 90, 140, 40);
        this.btnOrdenCompra.setFont(new Font("Arial", 1, 12));
        this.btnOrdenCompra.setText("<html><P ALIGN=center>Cargar Orden de Compra");
        this.btnOrdenCompra.setEnabled(false);
        this.btnOrdenCompra.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.32
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.btnOrdenCompraActionPerformed(evt);
            }
        });
        this.panelDatosEntrada.add(this.btnOrdenCompra);
        this.btnOrdenCompra.setBounds(10, 30, 130, 50);
        this.JTFTotalOCompra.setBackground(new Color(0, 0, 102));
        this.JTFTotalOCompra.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Orden Compra $", 0, 0, new Font("Helvetica Neue", 0, 13), new Color(204, 255, 255)));
        this.JTFTotalOCompra.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFTotalOCompra.setHorizontalAlignment(4);
        this.JTFTotalOCompra.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFTotalOCompra.setEnabled(false);
        this.JTFTotalOCompra.setFont(new Font("Arial", 1, 15));
        this.JTFTotalOCompra.setValue(new Double(0.0d));
        this.JTFTotalOCompra.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.33
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JTFTotalOCompraActionPerformed(evt);
            }
        });
        this.panelDatosEntrada.add(this.JTFTotalOCompra);
        this.JTFTotalOCompra.setBounds(1020, 90, 130, 41);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.panelDatosEntrada.add(this.txtFecha);
        this.txtFecha.setBounds(10, 100, 130, 50);
        this.panelFletes.setBorder(BorderFactory.createTitledBorder((Border) null, "FLETES Y DESCUENTOS", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.panelFletes.setLayout((LayoutManager) null);
        this.txtDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.txtDescuento.setHorizontalAlignment(4);
        this.txtDescuento.setFont(new Font("Arial", 1, 12));
        this.txtDescuento.setValue(new Integer(0));
        this.txtDescuento.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.34
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtDescuentoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Entradas.this.txtDescuentoFocusLost(evt);
            }
        });
        this.txtDescuento.addKeyListener(new KeyAdapter() { // from class: Inventarios.Entradas.35
            public void keyTyped(KeyEvent evt) {
                Entradas.this.txtDescuentoKeyTyped(evt);
            }
        });
        this.panelFletes.add(this.txtDescuento);
        this.txtDescuento.setBounds(10, 80, 130, 40);
        this.txtFlete.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Flete y Otros", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.txtFlete.setHorizontalAlignment(4);
        this.txtFlete.setFont(new Font("Arial", 1, 12));
        this.txtFlete.setValue(new Integer(0));
        this.txtFlete.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.36
            public void focusGained(FocusEvent evt) {
                Entradas.this.txtFleteFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Entradas.this.txtFleteFocusLost(evt);
            }
        });
        this.txtFlete.addKeyListener(new KeyAdapter() { // from class: Inventarios.Entradas.37
            public void keyTyped(KeyEvent evt) {
                Entradas.this.txtFleteKeyTyped(evt);
            }
        });
        this.panelFletes.add(this.txtFlete);
        this.txtFlete.setBounds(10, 20, 130, 40);
        this.panelDatosEntrada.add(this.panelFletes);
        this.panelFletes.setBounds(710, 20, 150, 130);
        this.cboProveedor.setFont(new Font("Arial", 1, 12));
        this.cboProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProveedor.setEnabled(false);
        this.cboProveedor.addItemListener(new ItemListener() { // from class: Inventarios.Entradas.38
            public void itemStateChanged(ItemEvent evt) {
                Entradas.this.cboProveedorItemStateChanged(evt);
            }
        });
        this.panelDatosEntrada.add(this.cboProveedor);
        this.cboProveedor.setBounds(290, 30, 280, 50);
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoMovimiento.setRequestFocusEnabled(false);
        this.cboTipoMovimiento.addItemListener(new ItemListener() { // from class: Inventarios.Entradas.39
            public void itemStateChanged(ItemEvent evt) {
                Entradas.this.cboTipoMovimientoItemStateChanged(evt);
            }
        });
        this.panelDatosEntrada.add(this.cboTipoMovimiento);
        this.cboTipoMovimiento.setBounds(150, 100, 250, 50);
        this.txtTotalCosto.setBackground(new Color(0, 0, 102));
        this.txtTotalCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Costo $", 0, 0, new Font("Helvetica Neue", 0, 13), new Color(204, 255, 255)));
        this.txtTotalCosto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.txtTotalCosto.setHorizontalAlignment(4);
        this.txtTotalCosto.setDisabledTextColor(new Color(255, 255, 255));
        this.txtTotalCosto.setEnabled(false);
        this.txtTotalCosto.setFont(new Font("Arial", 1, 15));
        this.txtTotalCosto.setValue(new Double(0.0d));
        this.txtTotalCosto.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.40
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.txtTotalCostoActionPerformed(evt);
            }
        });
        this.panelDatosEntrada.add(this.txtTotalCosto);
        this.txtTotalCosto.setBounds(870, 20, 140, 41);
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFValor.addFocusListener(new FocusAdapter() { // from class: Inventarios.Entradas.41
            public void focusGained(FocusEvent evt) {
                Entradas.this.JTFFValorFocusGained(evt);
            }
        });
        this.panelDatosEntrada.add(this.JTFFValor);
        this.JTFFValor.setBounds(410, 100, 160, 50);
        this.JTPDatosE.addTab("DATOS FACTURA", this.panelDatosEntrada);
        this.JCTipo.setEditable(true);
        this.JCTipo.setFont(new Font("Arial", 1, 12));
        this.JCTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCTipo.addItemListener(new ItemListener() { // from class: Inventarios.Entradas.42
            public void itemStateChanged(ItemEvent evt) {
                Entradas.this.JCTipoItemStateChanged(evt);
            }
        });
        this.JSPNCajas.setFont(new Font("Arial", 1, 12));
        this.JSPNCajas.setModel(new SpinnerNumberModel(1, 1, 200, 1));
        this.JSPNCajas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Caja(s)", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTransportadora.setEditable(true);
        this.JCBTransportadora.setFont(new Font("Arial", 1, 12));
        this.JCBTransportadora.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Transportadora", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTransportadora.addItemListener(new ItemListener() { // from class: Inventarios.Entradas.43
            public void itemStateChanged(ItemEvent evt) {
                Entradas.this.JCBTransportadoraItemStateChanged(evt);
            }
        });
        this.JTFAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JTFAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar de Conteo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFOrdenC.setFont(new Font("Arial", 1, 12));
        this.JTFOrdenC.setHorizontalAlignment(4);
        this.JTFOrdenC.setText("0");
        this.JTFOrdenC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° OrdenC", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFOrdenC.addMouseListener(new MouseAdapter() { // from class: Inventarios.Entradas.44
            public void mouseClicked(MouseEvent evt) {
                Entradas.this.JTFOrdenCMouseClicked(evt);
            }
        });
        this.JSPNSolicitudP.setFont(new Font("Arial", 1, 12));
        this.JSPNSolicitudP.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNSolicitudP.setBorder(BorderFactory.createTitledBorder((Border) null, "NSP", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPTipoRecepcionLayout = new GroupLayout(this.JPTipoRecepcion);
        this.JPTipoRecepcion.setLayout(JPTipoRecepcionLayout);
        JPTipoRecepcionLayout.setHorizontalGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRecepcionLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPTipoRecepcionLayout.createSequentialGroup().addComponent(this.JCTipo, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNCajas, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTransportadora, -2, 399, -2)).addGroup(JPTipoRecepcionLayout.createSequentialGroup().addComponent(this.JTFOrdenC, -2, 86, -2).addGap(18, 18, 18).addComponent(this.JSPNSolicitudP, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAuxiliar, -2, 344, -2).addContainerGap(-1, 32767)));
        JPTipoRecepcionLayout.setVerticalGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRecepcionLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCTipo, -2, 50, -2).addComponent(this.JSPNCajas, -2, 50, -2).addComponent(this.JTFAuxiliar, -2, 50, -2).addComponent(this.JCBTransportadora)).addGap(18, 18, 18).addGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPTipoRecepcionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNSolicitudP, -2, 50, -2).addComponent(this.JTFOrdenC, -2, 50, -2)).addComponent(this.JSPObservacion)).addContainerGap(-1, 32767)));
        this.JTPDatosE.addTab("DATOS RECEPCIÓN", this.JPTipoRecepcion);
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.45
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.Entradas.46
            public void mouseClicked(MouseEvent evt) {
                Entradas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Cargar Información");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.47
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JPDistribucion.setBorder(BorderFactory.createTitledBorder((Border) null, "DISTRIBUCIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGTipoDistribucion.add(this.JRBAutomatica);
        this.JRBAutomatica.setFont(new Font("Arial", 1, 12));
        this.JRBAutomatica.setSelected(true);
        this.JRBAutomatica.setText("Automatica");
        this.JRBAutomatica.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.48
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JRBAutomaticaActionPerformed(evt);
            }
        });
        this.JBGTipoDistribucion.add(this.JRBManual);
        this.JRBManual.setFont(new Font("Arial", 1, 12));
        this.JRBManual.setText("Manual");
        this.JRBManual.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.49
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JRBManualActionPerformed(evt);
            }
        });
        GroupLayout JPDistribucionLayout = new GroupLayout(this.JPDistribucion);
        this.JPDistribucion.setLayout(JPDistribucionLayout);
        JPDistribucionLayout.setHorizontalGroup(JPDistribucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDistribucionLayout.createSequentialGroup().addComponent(this.JRBAutomatica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBManual)));
        JPDistribucionLayout.setVerticalGroup(JPDistribucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDistribucionLayout.createSequentialGroup().addGroup(JPDistribucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAutomatica).addComponent(this.JRBManual)).addGap(0, 0, 32767)));
        this.JLBIdEntrada.setFont(new Font("Arial", 1, 14));
        this.JLBIdEntrada.setHorizontalAlignment(0);
        this.JLBIdEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTCarguesA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 418, -2).addGap(24, 24, 24).addComponent(this.JBTCarguesA1, -2, 171, -2).addGap(18, 18, 18).addComponent(this.JPDistribucion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBIdEntrada, -2, 144, -2).addContainerGap(-1, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTCarguesA, -1, -1, 32767).addComponent(this.JPDistribucion, -1, -1, 32767).addComponent(this.JBTCarguesA1, -2, 57, -2).addComponent(this.JLBIdEntrada, -1, -1, 32767).addComponent(this.JTFRuta)).addContainerGap(-1, 32767)));
        this.JTP_Datos.addTab("UTILIDADES", this.JPI_Utilidades);
        this.JBTCarguesA2.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.JBTCarguesA2.setText("Radicación contable");
        this.JBTCarguesA2.addActionListener(new ActionListener() { // from class: Inventarios.Entradas.50
            public void actionPerformed(ActionEvent evt) {
                Entradas.this.JBTCarguesA2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JBTCarguesA2).addContainerGap(961, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTCarguesA2, -1, -1, 32767).addContainerGap()));
        this.JTP_Datos.addTab("ADICIONAL", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosE).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.panelInformacion, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JTP_Datos, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosE, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 206, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 100, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        if (!mValidaFecha().booleanValue()) {
            bajarProducto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCreditoActionPerformed(ActionEvent evt) {
        this.formaPago = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnContadoActionPerformed(ActionEvent evt) {
        this.formaPago = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadStateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.txtCantidad.getValue().toString()) != 0.0d) {
            this.txtValorTotal.setValue(Double.valueOf(this.xmt.redondear(Double.parseDouble(this.txtCantidad.getValue().toString()) * Double.parseDouble(this.txtValorTotalUnidad.getValue().toString()), 2)));
            mValidar_Cantidad_OrdenCompra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorUnidadStateChanged(ChangeEvent evt) {
        refrescarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIvaStateChanged(ChangeEvent evt) {
        refrescarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNoAplicaActionPerformed(ActionEvent evt) {
        this.formaPago = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JLBIdEntrada.getText().isEmpty()) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        this.btnBuscarProducto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalActionPerformed(ActionEvent evt) {
    }

    private void txtFechaVencimientoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorTotalUnidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorIvaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarProductoActionPerformed(ActionEvent evt) {
        buscarProducto(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOrdenCompraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTotalOCompraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFacturaActionPerformed(ActionEvent evt) {
        this.cboProveedor.requestFocus();
        if (!this.txtFactura.getText().isEmpty()) {
            if (this.xestado && this.cboProveedor.getSelectedIndex() > -1 && mExiteFacturaProveedor()) {
                JOptionPane.showInternalMessageDialog(this, "Este número de Factura ya existe con este proveedor", "VERIFICAR", 1);
                return;
            }
            return;
        }
        this.cboProveedor.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFleteFocusGained(FocusEvent evt) {
        this.txtFlete.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusGained(FocusEvent evt) {
        this.txtCodigo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoteFocusGained(FocusEvent evt) {
        this.txtLote.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        buscarProducto(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoteActionPerformed(ActionEvent evt) {
        this.txtVencimiento.requestFocus();
    }

    private Boolean mValidaFecha() {
        String fechacampo = this.xmt.formatoAMD1.format(this.txtVencimiento.getDate());
        boolean fechav = false;
        int n = 0;
        String sql = "SELECT IF(CONVERT('" + fechacampo + "',DATE)<=NOW(),'0','1') AS fecha";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                n = xrs.getInt(1);
            }
            if (n == 0 && this.xidproductobd != 0) {
                fechav = true;
                JOptionPane.showInternalMessageDialog(this, "La fecha de Vencimiento que digitó es menor que la fecha Actual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.txtVencimiento.requestFocus();
            } else {
                this.btnCargar.requestFocus();
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(fechav);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFacturaFocusGained(FocusEvent evt) {
        this.txtFactura.selectAll();
        if (!this.txtFactura.getText().isEmpty()) {
            this.cboProveedor.setEnabled(true);
        } else {
            this.cboProveedor.setSelectedIndex(-1);
            this.cboProveedor.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoteMouseClicked(MouseEvent evt) {
        if (this.idProducto != null) {
            if (evt.getClickCount() == 2) {
                JDConsultarLotesExistentes dialog = new JDConsultarLotesExistentes(this.claseInv.frmPrincipal, true, this);
                dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                dialog.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAceptaActionPerformed(ActionEvent evt) {
        if (this.JCHAcepta.isSelected()) {
            this.xacepta = 1;
            this.xobservacion = "";
        } else {
            this.xacepta = 0;
            this.xobservacion = JOptionPane.showInternalInputDialog(this, "Motivo de no aceptación", "RECHAZO", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalCostoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOrdenCMouseClicked(MouseEvent evt) {
        if (this.cboProveedor.getSelectedIndex() != -1) {
            this.claseInv.cargarPantalla("Consultar Orden Compra");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Ddebe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.cboProveedor.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPTemperaturaStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCPendienteStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.cboTipoMovimiento.getSelectedIndex() != -1) {
            if (this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()][2].equals("1")) {
                this.JTPDatosE.setEnabledAt(1, true);
            } else {
                this.JTPDatosE.setEnabledAt(1, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTipoItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.JCTipo.getSelectedIndex() != -1) {
            this.xidtiporecepcion = Integer.valueOf(this.xidtipo[this.JCTipo.getSelectedIndex()]).intValue();
        } else {
            this.xidtiporecepcion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTransportadoraItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.JCBTransportadora.getSelectedIndex() != -1) {
            this.xidtransportadora = Integer.valueOf(this.xidtransp[this.JCBTransportadora.getSelectedIndex()]).intValue();
        } else {
            this.xidtransportadora = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridPropertyChange(PropertyChangeEvent evt) {
        if (this.grid.getRowCount() != -1 && this.xlleno) {
            try {
                this.entrada.getDetalleEntrada().get(this.grid.getSelectedRow()).setCantidad(Double.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString()));
                this.entrada.getDetalleEntrada().get(this.grid.getSelectedRow()).setPoncentajeImpuesto(Double.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 5).toString()));
                this.entrada.getDetalleEntrada().get(this.grid.getSelectedRow()).setValorUnitario(Double.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString()));
                this.entrada.getSubTotalEntrada();
                cargarDetalleTabla();
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        if (file != null) {
            if (file.getName().endsWith("xls")) {
                try {
                    CrearTabla(file);
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            if (file.getName().endsWith("xlsx")) {
                try {
                    mImportarXLSX(file);
                    return;
                } catch (IOException ex2) {
                    Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    return;
                }
            }
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    private void mImportarXLSX(File file) throws IOException {
        FileInputStream fis = new FileInputStream(new File(file.getAbsoluteFile().toString()));
        Throwable th = null;
        try {
            try {
                int n = 0;
                String texto = "";
                Double Valor = null;
                int cont = 0;
                Vector d = new Vector();
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator ite = sheet.rowIterator();
                if (ite.hasNext()) {
                    ite.next();
                }
                if (ite.hasNext()) {
                    ite.next();
                }
                while (ite.hasNext()) {
                    Row row = (Row) ite.next();
                    Iterator<Cell> cite = row.cellIterator();
                    while (cite.hasNext()) {
                        Cell c = cite.next();
                        switch (c.getCellType()) {
                            case 0:
                            case 2:
                                Valor = Double.valueOf(c.getNumericCellValue());
                                break;
                            case 1:
                                texto = c.getStringCellValue();
                                break;
                            default:
                                texto = c.getStringCellValue();
                                break;
                        }
                        if ((cont >= 3 && cont <= 7) || (cont >= 14 && cont <= 17)) {
                            if (Valor.equals("")) {
                                d.add(Integer.valueOf("0"));
                            } else {
                                d.add(Valor);
                            }
                        } else if (cont == 12 || cont == 13 || cont == 20 || cont == 0) {
                            if (Valor.equals("")) {
                                d.add(Integer.valueOf("0"));
                            } else {
                                d.add(Integer.valueOf(Valor.intValue()));
                            }
                        } else if (cont == 10) {
                            d.add(Boolean.valueOf(texto));
                        } else {
                            d.add(texto);
                        }
                        if (cont == 20) {
                            this.modelo.addRow(d);
                            d = new Vector();
                            cont = 0;
                        } else {
                            cont++;
                        }
                        n++;
                    }
                }
                crearDetalle();
                this.txtTotalCosto.setValue(this.entrada.getValorTotalCosto());
                this.txtTotalIva.setValue(this.entrada.getValorTotalIva());
                this.txtTotalFactura.setValue(this.entrada.getTotalFactura());
                this.txtDescuento.setValue(this.entrada.getValorDescuento());
                this.txtFlete.setValue(this.entrada.getValorFlete());
                if (fis != null) {
                    if (0 != 0) {
                        try {
                            fis.close();
                            return;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            return;
                        }
                    }
                    fis.close();
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (Throwable th4) {
            if (fis != null) {
                if (th != null) {
                    try {
                        fis.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    fis.close();
                }
            }
            throw th4;
        }
    }

    private void crearDetalle() {
        for (int i = 0; i < this.grid.getRowCount(); i++) {
            EntradaDetalle detalle = new EntradaDetalle(this.entrada);
            detalle.setIdSuministro(Long.valueOf(this.grid.getValueAt(i, 0).toString()));
            detalle.setIdSuministroBodega(Long.valueOf(this.grid.getValueAt(i, 13).toString()));
            detalle.setCodigoBarra(this.grid.getValueAt(i, 1).toString());
            detalle.setNombre(this.grid.getValueAt(i, 2).toString());
            detalle.setCantidad(Double.valueOf(this.grid.getValueAt(i, 3).toString()));
            detalle.setPoncentajeImpuesto(Double.valueOf(this.grid.getValueAt(i, 5).toString()));
            detalle.setValorUnitario(Double.valueOf(this.grid.getValueAt(i, 4).toString()));
            detalle.setLote(this.grid.getValueAt(i, 8).toString());
            detalle.setAcepta(Boolean.valueOf(this.grid.getValueAt(i, 10).toString()));
            detalle.setObservacion(this.grid.getValueAt(i, 11).toString());
            detalle.setCantidadUnidad(Long.valueOf(this.grid.getValueAt(i, 12).toString()));
            detalle.setTemperatura(Double.valueOf(this.grid.getValueAt(i, 14).toString()));
            detalle.setCantidadPendiente(Double.valueOf(this.grid.getValueAt(i, 15).toString()));
            detalle.setCodigoCum(this.grid.getValueAt(i, 18).toString());
            detalle.setCodigoAtc(this.grid.getValueAt(i, 19).toString());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha1 = formato.parse(this.grid.getValueAt(i, 9).toString());
                detalle.setFechaVecimiento(fecha1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.entrada.setAddDetalleEntrada(detalle);
        }
    }

    private Date getDateFromModel(int row, int col) {
        try {
            Object value = this.modelo.getValueAt(row, col);
            if (value instanceof Date) {
                return (Date) value;
            }
            if (value instanceof String) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                return format.parse(value.toString());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Long getLongFromModel(int row, int col) {
        try {
            return Long.valueOf(this.modelo.getValueAt(row, col).toString());
        } catch (Exception e) {
            return 0L;
        }
    }

    private String getStringFromModel(int row, int col) {
        try {
            return this.modelo.getValueAt(row, col).toString();
        } catch (Exception e) {
            return "";
        }
    }

    private Double getDoubleFromModel(int row, int col) {
        try {
            return Double.valueOf(this.modelo.getValueAt(row, col).toString());
        } catch (Exception e) {
            return Double.valueOf(0.0d);
        }
    }

    private Boolean getBooleanFromModel(int row, int col) {
        try {
            return Boolean.valueOf(this.modelo.getValueAt(row, col).toString());
        } catch (Exception e) {
            return false;
        }
    }

    private Short getShortFromModel(int row, int col) {
        try {
            return Short.valueOf(this.modelo.getValueAt(row, col).toString());
        } catch (Exception e) {
            return (short) 0;
        }
    }

    public void CrearTabla(File file) throws IOException {
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            this.columna.clear();
            for (int i = 1; i < sheet.getColumns(); i++) {
                jxl.Cell cell1 = sheet.getCell(i, 0);
                this.columna.add(cell1.getContents());
            }
            this.filas.clear();
            for (int j = 2; j < sheet.getRows(); j++) {
                new Vector();
                this.entrada.setValorDescuento(Double.valueOf(this.txtDescuento.getValue().toString()));
                this.entrada.setValorFlete(Double.valueOf(this.txtFlete.getValue().toString()));
                EntradaDetalle detalle = new EntradaDetalle(this.entrada);
                for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                    jxl.Cell cell = sheet.getCell(i2, j);
                    if (i2 == 0) {
                        detalle.setIdSuministro(Long.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 13) {
                        detalle.setIdSuministroBodega(Long.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 1) {
                        detalle.setCodigoBarra(cell.getContents());
                    } else if (i2 == 2) {
                        detalle.setNombre(cell.getContents());
                    } else if (i2 == 3) {
                        detalle.setCantidad(Double.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 5) {
                        detalle.setPoncentajeImpuesto(Double.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 4) {
                        detalle.setValorUnitario(Double.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 8) {
                        detalle.setLote(cell.getContents());
                    } else if (i2 == 10) {
                        if (cell.getContents().equals("true")) {
                            detalle.setAcepta(true);
                        } else {
                            detalle.setAcepta(false);
                        }
                    } else if (i2 == 11) {
                        detalle.setObservacion(cell.getContents());
                    } else if (i2 == 14) {
                        detalle.setTemperatura(Double.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 15) {
                        detalle.setCantidadPendiente(Double.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    } else if (i2 == 18) {
                        detalle.setCodigoCum(cell.getContents());
                    } else if (i2 == 19) {
                        detalle.setCodigoAtc(cell.getContents());
                    } else if (i2 == 9) {
                        detalle.setFechaVecimiento(this.xmt.getPasarTextoAFecha(cell.getContents()));
                    } else if (i2 == 20) {
                        detalle.setCantidadMuestreo(Short.valueOf(cell.getContents()));
                    } else if (i2 == 12) {
                        detalle.setCantidadUnidad(Long.valueOf(cell.getContents().replaceAll("\\.", "").replaceAll(",", ".")));
                    }
                }
                this.entrada.setAddDetalleEntrada(detalle);
                this.filaGrid = 0;
                cargarDetalleTabla();
                this.txtTotalCosto.setValue(this.entrada.getValorTotalCosto());
                this.txtTotalIva.setValue(this.entrada.getValorTotalIva());
                this.txtTotalFactura.setValue(this.entrada.getTotalFactura());
                limpiarDatosProducto();
                this.txtCodigo.requestFocus();
            }
        } catch (BiffException e) {
            e.printStackTrace();
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.grid.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.grid, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusGained(FocusEvent evt) {
        this.txtDescuento.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFleteFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFleteKeyTyped(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '\b' && car != '.') {
            evt.consume();
        }
        if (car == '.' && this.txtFlete.getText().contains(".")) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoKeyTyped(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '\b' && car != '.') {
            evt.consume();
        }
        if (car == '.' && this.txtDescuento.getText().contains(".")) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAutomaticaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBManualActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProveedorItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.cboProveedor.getSelectedIndex() > -1 && mExiteFacturaProveedor()) {
            JOptionPane.showInternalMessageDialog(this, "Este número de Factura ya existe con este proveedor", "VERIFICAR", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtMuestreoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtMuestreoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtMuestreoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFacturaKeyReleased(KeyEvent evt) {
        if (!this.txtFactura.getText().isEmpty()) {
            this.cboProveedor.setEnabled(true);
        } else {
            this.cboProveedor.setSelectedIndex(-1);
            this.cboProveedor.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA2ActionPerformed(ActionEvent evt) {
        cargarFormularioContabilizacion();
    }

    private void cargarFormularioContabilizacion() {
        if (Principal.informacionIps.getManejaContabilidad().intValue() != 1 || this.JLBIdEntrada.getText().isEmpty()) {
            return;
        }
        try {
            Principal.xclase.cargarPantalla("Radicación_Inventario", Long.valueOf(this.JLBIdEntrada.getText()));
        } catch (NumberFormatException e) {
            this.xmt.mostrarMensaje("El ID de entrada no es válido");
            System.err.println("Error al convertir el ID de entrada a número: " + e.getMessage());
        }
    }

    private boolean mExiteFacturaProveedor() {
        ConsultasMySQL xct;
        ResultSet xrs;
        Throwable th;
        boolean xExiste = false;
        try {
            String xsql = "select i.`Id` from i_entradas  i\nwhere i.`NoFactura`='" + this.txtFactura.getText().trim() + "' and i.`IdProveedor`=" + Integer.valueOf(this.listaProveedor[this.cboProveedor.getSelectedIndex()]) + " and i.`Estado`=0";
            xct = new ConsultasMySQL();
            xrs = xct.traerRs(xsql);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (xrs.next()) {
                    xrs.first();
                    xExiste = true;
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
                xct.cerrarConexionBd();
                return xExiste;
            } finally {
            }
        } finally {
        }
    }
}
