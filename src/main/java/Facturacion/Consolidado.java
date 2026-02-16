package Facturacion;

import Acceso.Principal;
import General.Anular;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import UtilidadesMetodosHttp.MetodosHttp;
import co.com.genomaempresarial.ankara.dto.Adjunto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.facturacion.JPIngresoDocumento;
import com.genoma.plus.controller.gcuenta.GeneracionFacturaElectronica;
import com.genoma.plus.jpa.entities.CcDetalleDocumentoc;
import com.genoma.plus.jpa.entities.CcDocumentoc;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcPuc;
import com.genoma.plus.jpa.entities.CcTipoClasificacionTercero;
import com.genoma.plus.jpa.entities.CcTipoDocumentoc;
import com.genoma.plus.jpa.entities.CcTipoVigenciaPago;
import com.genoma.plus.jpa.entities.DatosIpsEntity;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FCuentacobro;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FFacturaEventoDetalle;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEtapaProceso;
import com.genoma.plus.jpa.entities.GMunicipio;
import com.genoma.plus.jpa.entities.GruposervicioEntity;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.ResolucionDianDTO;
import com.genoma.plus.jpa.entities.SubgrupoEmpresaEntity;
import com.genoma.plus.jpa.entities.SubgruposervicioEntity;
import com.genoma.plus.jpa.entities.TipoAseguramientoDTO;
import com.genoma.plus.jpa.entities.TipoCoberturaPlanDTO;
import com.genoma.plus.jpa.entities.TipoContratacionDTO;
import com.genoma.plus.jpa.entities.TipoPlanEntity;
import com.genoma.plus.jpa.entities.TipoRegimenEntity;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.FFacturaEventoDetalleService;
import com.genoma.plus.jpa.service.FFacturaEventoService;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import com.genoma.plus.jpa.service.ICcDocumentocService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IFCuentacobroService;
import com.genoma.plus.jpa.service.IFacturaElectronicaDAO;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ISubgrupoEmpresaService;
import com.genoma.plus.jpa.service.ISubgrupoServicioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Consolidado.class */
public class Consolidado extends JDialog {
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private String noLiquidacion;
    private String idEmpresa;
    private String sql;
    private String clave;
    private String idIngreso;
    private String idRecibo;
    private String xrdescuento;
    private String xIdrecibo;
    private String idFactura;
    private int tipoFactura;
    private int esCapitado;
    private int xtipo;
    private int xConsecutivo;
    private ResultSet rs;
    private Facturac frmFacturac;
    private Facturac1 frmFacturac1;
    private boolean xllenoc;
    private boolean xllenof;
    private JPEventoECat xJPEventoECat;
    private String[] xid_tipodoc;
    private String[] xidperiodo;
    private String[][] xId_Fpago;
    private String[][] xId_Concepto;
    private String[][] xidservicio;
    private final IResolucionDianDAO xIResolucionDianDAO;
    private IResolucionFacturaElectronica resolucionDian;
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO;
    private List<ICargarCombo> medioDePago;
    private Object empresa;
    public Ingreso frmIngreso;
    public String xcuentacobro;
    private JPIngresoDocumento frmSE;
    private boolean cambioTag;
    private IFacturaElectronicaDAO xIFacturaElectronicaDAO;
    private List<Adjunto> adjunto;
    private final IEmpresaContConvenioService iEmpresaContConvenioService;
    private EmpresaContConvenioEntity empresaContConvenioEntity;
    private final IGEmpresaService iGEmpresaService;
    private GEmpresa gEmpresaEntity;
    private final ISubgrupoEmpresaService iSubgrupoEmpresaService;
    private SubgrupoEmpresaEntity subgrupoEmpresaEntity;
    private final ISubgrupoServicioService iSubgrupoServicioService;
    private SubgruposervicioEntity subgruposervicioEntity;
    private ILiquidacionService iLiquidacionService;
    private LiquidacionEntity liquidacionEntity;
    private FFacturaEvento facturaEvento;
    private FFacturaEventoService fFacturaEventoService;
    private List<LiquidacionEntity> listFacturasVentaCop;
    private FFacturaEventoDetalle fFacturaEventoDetalle;
    private FFacturaEventoDetalleService fFacturaEventoDetalleService;
    private IFCuentacobroService iFCuentacobroService;
    private FCuentacobro fCuentacobro;
    private CcDocumentoc cCDocumentoc;
    private final ICcDocumentocService ccDocumentocService;
    private long numeroFcturaCopago;
    private JButton JBT_EnvioDian;
    private JComboBox JCBConcepto_C;
    private JComboBox JCBFPago;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBTipoDocC;
    private JTableComboBox JCB_CCosto;
    private JCheckBox JCHAplicaCobro;
    public JDateChooser JDCFecha;
    private JLabel JLB_EstadoDian;
    private JLabel JLB_MensajeDian;
    private JPanel JPIDCaja;
    private JPanel JPIDSoportesEscaneados;
    private JPanel JPIDTotales;
    private JPanel JPI_ADescuento;
    private JFormattedTextField JTFF_Descuento;
    private JFormattedTextField JTFF_TotalRecibo;
    private JTextField JTFNTransaccion;
    private JTextField JTF_NoDocContable;
    private JTextField JTF_NoRecibo;
    private JTabbedPane JTPDATOS;
    private JRadioButton btnAmbos;
    private JButton btnAnular;
    private JRadioButton btnEps;
    private JButton btnGrabar;
    private JButton btnGrabar1;
    private JButton btnGrabarFactura;
    private JButton btnImprimir;
    private JRadioButton btnPaciente;
    private JButton btnSalir;
    private ButtonGroup buttonGroup1;
    private JTableComboBox cboGrupo;
    private JTableComboBox cboSubGrupo;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JScrollPane jScrollPane3;
    private JPasswordField txtClave;
    private JFormattedTextField txtCopago;
    private JFormattedTextField txtCubierto;
    private JFormattedTextField txtCuotaM;
    private JTextField txtEstadoEps;
    private JTextField txtEstadoPaciente;
    private JTextField txtFechaPaciente;
    private JTextField txtLogin;
    private JTextField txtNbreAutoriza;
    private JTextField txtNoEps;
    private JTextField txtNoFactura;
    private JTextField txtNoPaciente;
    private JTextArea txtObservacion;
    private JFormattedTextField txtTotalDescuento;
    private JFormattedTextField txtTotalEps;
    private JFormattedTextField txtTotalNoCubierto;
    private JFormattedTextField txtTotalServicio;
    private JFormattedTextField txtTotalpaciente;

    public Consolidado(Frame parent, boolean modal, String noIngreso, String idempresa, Facturac facturac, String xdescuento, int xtipo, Object empresa) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xIdrecibo = "0";
        this.idFactura = "0";
        this.xtipo = 0;
        this.xConsecutivo = 0;
        this.xllenoc = false;
        this.xllenof = false;
        this.xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);
        this.frmIngreso = null;
        this.xcuentacobro = "";
        this.cambioTag = false;
        this.xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
        this.iSubgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
        this.iSubgrupoServicioService = (ISubgrupoServicioService) Principal.contexto.getBean(ISubgrupoServicioService.class);
        this.iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        this.fFacturaEventoService = (FFacturaEventoService) Principal.contexto.getBean(FFacturaEventoService.class);
        this.fFacturaEventoDetalleService = (FFacturaEventoDetalleService) Principal.contexto.getBean(FFacturaEventoDetalleService.class);
        this.iFCuentacobroService = (IFCuentacobroService) Principal.contexto.getBean(IFCuentacobroService.class);
        this.ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
        this.numeroFcturaCopago = 0L;
        initComponents();
        this.adjunto = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.empresa = empresa;
        System.out.println("empresa --> " + empresa);
        this.xtipo = xtipo;
        this.JDCFecha.setDate(this.metodos.getFechaActual());
        this.frmFacturac = facturac;
        this.tipoFactura = 1;
        this.xrdescuento = xdescuento;
        this.idEmpresa = idempresa;
        this.idIngreso = noIngreso;
        this.esCapitado = this.frmFacturac.clasefacturacion.buscarCapitado(this.frmFacturac.frmIngreso.getIdIngreso());
        cargarCombos();
        buscarLiquidacion(noIngreso);
        activarPanelCaja();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JCHAplicaCobro.setVisible(true);
            this.JCHAplicaCobro.setSelected(true);
        } else {
            this.JCHAplicaCobro.setVisible(false);
            this.JCHAplicaCobro.setSelected(true);
        }
        if (this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][3].equals("1")) {
            this.txtCuotaM.setEnabled(true);
            this.txtCopago.setEnabled(true);
        }
        mEstablercerValoresPorDefecto();
        this.xllenoc = true;
        mValidaResolucionDian(true);
        mCargarCombo();
        this.JTPDATOS.setSelectedIndex(2);
        this.JTPDATOS.setSelectedIndex(0);
        this.listFacturasVentaCop = new ArrayList();
        this.listFacturasVentaCop = this.iLiquidacionService.listaLiquidacionFacturaIngresoPrincipal(Integer.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()));
        if (!this.listFacturasVentaCop.isEmpty()) {
            this.listFacturasVentaCop.forEach(e -> {
                System.err.println("idliquidacion Prin" + e.getId());
                e.getFFacturaEventoCollection().forEach(f -> {
                    System.err.println("idFctura Prin" + f.getId());
                    this.txtNoFactura.setEnabled(true);
                    this.txtNoFactura.setText(f.getPrefijo() + "" + f.getNoFacturaeventoM());
                });
            });
        } else if (!this.txtCuotaM.getText().equals("0") || !this.txtCopago.getText().equals("0")) {
            this.btnGrabarFactura.setEnabled(true);
        }
    }

    public Consolidado(Frame parent, boolean modal, String noIngreso, String idempresa, Facturac1 facturac, String xdescuento, int xtipo, Object empresa) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xIdrecibo = "0";
        this.idFactura = "0";
        this.xtipo = 0;
        this.xConsecutivo = 0;
        this.xllenoc = false;
        this.xllenof = false;
        this.xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);
        this.frmIngreso = null;
        this.xcuentacobro = "";
        this.cambioTag = false;
        this.xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
        this.iSubgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
        this.iSubgrupoServicioService = (ISubgrupoServicioService) Principal.contexto.getBean(ISubgrupoServicioService.class);
        this.iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        this.fFacturaEventoService = (FFacturaEventoService) Principal.contexto.getBean(FFacturaEventoService.class);
        this.fFacturaEventoDetalleService = (FFacturaEventoDetalleService) Principal.contexto.getBean(FFacturaEventoDetalleService.class);
        this.iFCuentacobroService = (IFCuentacobroService) Principal.contexto.getBean(IFCuentacobroService.class);
        this.ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
        this.numeroFcturaCopago = 0L;
        initComponents();
        this.adjunto = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.empresa = empresa;
        System.out.println("empresa --> " + empresa);
        this.xtipo = xtipo;
        this.JDCFecha.setDate(this.metodos.getFechaActual());
        this.frmFacturac1 = facturac;
        this.frmFacturac1 = facturac;
        this.tipoFactura = 1;
        this.xrdescuento = xdescuento;
        this.idEmpresa = idempresa;
        this.idIngreso = noIngreso;
        this.esCapitado = this.frmFacturac.clasefacturacion.buscarCapitado(this.frmFacturac.frmIngreso.getIdIngreso());
        cargarCombos();
        buscarLiquidacion(noIngreso);
        activarPanelCaja();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JCHAplicaCobro.setVisible(true);
            this.JCHAplicaCobro.setSelected(true);
        } else {
            this.JCHAplicaCobro.setVisible(false);
            this.JCHAplicaCobro.setSelected(true);
        }
        if (this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][3].equals("1")) {
            this.txtCuotaM.setEnabled(true);
            this.txtCopago.setEnabled(true);
        }
        mEstablercerValoresPorDefecto();
        this.xllenoc = true;
        mValidaResolucionDian(true);
        mCargarCombo();
        this.JTPDATOS.setSelectedIndex(2);
        this.JTPDATOS.setSelectedIndex(0);
        this.listFacturasVentaCop = new ArrayList();
        this.listFacturasVentaCop = this.iLiquidacionService.listaLiquidacionFacturaIngresoPrincipal(Integer.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()));
        if (!this.listFacturasVentaCop.isEmpty()) {
            this.listFacturasVentaCop.forEach(e -> {
                System.err.println("idliquidacion Prin" + e.getId());
                e.getFFacturaEventoCollection().forEach(f -> {
                    System.err.println("idFctura Prin" + f.getId());
                    this.txtNoFactura.setEnabled(true);
                    this.txtNoFactura.setText(f.getPrefijo() + "" + f.getNoFacturaeventoM());
                });
            });
        } else if (!this.txtCuotaM.getText().equals("0") || !this.txtCopago.getText().equals("0")) {
            this.btnGrabarFactura.setEnabled(true);
        }
    }

    private void mCargarCombo() {
        this.medioDePago = this.xICargarComboMedioPagoDAO.cargarComboMedioDePago();
        this.JCBMedioDePago.removeAllItems();
        for (int i = 0; i < this.medioDePago.size(); i++) {
            this.JCBMedioDePago.addItem(this.medioDePago.get(i).getNombre());
        }
        this.JCBMedioDePago.setSelectedItem("Crédito ACH");
    }

    private void mValidaResolucionDian(Boolean validar) {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0 && lis.get(0).getId() != null) {
            this.resolucionDian = lis.get(0);
            if (validar.booleanValue()) {
                this.metodos.mResolucionDian(lis.get(0));
            }
        }
    }

    private void mResolucionDian() {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0) {
            this.resolucionDian = lis.get(0);
            if (this.resolucionDian.getConsecutivoFE().longValue() <= this.resolucionDian.getNumeroF().longValue()) {
                String date = this.metodos.formatoAMD1.format(this.metodos.getFechaActual());
                new Date();
                try {
                    Date fecha = this.metodos.formatoAMD1.parse(date);
                    if (fecha.after(this.resolucionDian.getFechaF())) {
                        JOptionPane.showMessageDialog(this, "<html><h1 style=\"text-align:center; color:red;\">Esta resolución ya esta vencida..</h1><table style=\"border: 0px; padding: 5px;\"><tr><td> <h2>DESCRIPCIÓN: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getDescripcion() + "</h2> </td><td> <h2><b>PREFIJO: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getPrefijo() + "</h2> </td></tr><tr><td> <h2><b>FECHA INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getFechaI() + "</h2> </td><td> <h2><b>NÚMERO INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getNumeroI() + "</h2> </td></tr><tr><td> <h2><b>FECHA FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getFechaF() + "</h2> </td><td> <h2><b>NÚMERO FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getNumeroF() + "</h2> </td></tr></table></html>", "VERIFICAR", 2);
                    }
                    return;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e, "Error", 0);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "<html><h1 style=\"text-align:center; color:red;\">El consecutivo sobrepaso el limite de la resolución vigente.</h1><table style=\"border: 0px; padding: 5px;\"><tr><td> <h2>DESCRIPCIÓN: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getDescripcion() + "</h2> </td><td> <h2><b>PREFIJO: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getPrefijo() + "</h2> </td></tr><tr><td> <h2><b>FECHA INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getFechaI() + "</h2> </td><td> <h2><b>NÚMERO INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getNumeroI() + "</h2> </td></tr><tr><td> <h2><b>FECHA FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getFechaF() + "</h2> </td><td> <h2><b>NÚMERO FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + this.resolucionDian.getNumeroF() + "</h2> </td></tr></table></html>", "VERIFICAR", 2);
        }
    }

    public void mCambio_Copago_CModeradora() {
        if (!this.txtCopago.getText().equals("0") || !this.txtCuotaM.getText().equals("0")) {
            String conv = "SELECT\n  `f_tipoplan`.`Nbre`\nFROM\n  `f_empresacontxconvenio`\n  INNER JOIN `f_tipoplan`\n    ON (\n      `f_empresacontxconvenio`.`Id_TipoPlan` = `f_tipoplan`.`Id`\n    )\nWHERE `f_empresacontxconvenio`.`Nbre` = '" + this.empresa + "'";
            ResultSet xrs1 = this.consultas.traerRs(conv);
            String result = "";
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    result = xrs1.getString("f_tipoplan.Nbre");
                    System.out.println("tipo de convenio -> " + result);
                }
                xrs1.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException e) {
                System.out.println("error");
            }
            if (result.equals("Particular")) {
                this.txtTotalpaciente.setValue(Double.valueOf(Double.valueOf(this.txtTotalNoCubierto.getValue().toString()).doubleValue() + Double.valueOf(this.txtCopago.getValue().toString()).doubleValue() + Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue()));
                this.txtTotalEps.setValue(Double.valueOf(Double.valueOf(this.txtTotalServicio.getValue().toString()).doubleValue() - Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue()));
            } else if (!this.txtCuotaM.getText().equals("0") || !this.txtCopago.getText().equals("0")) {
                this.txtTotalpaciente.setValue(Double.valueOf(Double.valueOf(this.txtCopago.getValue().toString()).doubleValue() + Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue()));
                this.txtTotalEps.setValue(Double.valueOf(Double.valueOf(this.txtTotalServicio.getValue().toString()).doubleValue() - Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue()));
            } else {
                this.txtTotalpaciente.setValue(0);
                this.txtTotalEps.setValue(Double.valueOf(Double.valueOf(this.txtTotalServicio.getValue().toString()).doubleValue() - Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue()));
            }
        }
    }

    private void nuevo() {
        this.txtNoEps.setText("");
        this.txtEstadoEps.setText("");
        this.txtNoPaciente.setText("");
        this.txtFechaPaciente.setText("");
        this.txtEstadoPaciente.setText("");
        this.cboGrupo.setSelectedIndex(-1);
        this.cboSubGrupo.setSelectedIndex(-1);
        this.cboSubGrupo.setEnabled(false);
        this.JTF_NoRecibo.setText("");
    }

    private void mEstablercerValoresPorDefecto() {
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCBPeriodoC.setSelectedIndex(0);
            this.JCBTipoDocC.setSelectedItem("VENTAS");
        }
    }

    private void activarPanelCaja() {
        if (this.frmFacturac.cajaAbierta == 0) {
            this.xllenof = false;
            this.JCBConcepto_C.setEnabled(true);
            this.JCB_CCosto.setEnabled(true);
            this.txtObservacion.setEnabled(true);
            this.txtLogin.setEnabled(true);
            this.txtClave.setEnabled(true);
            this.JCBFPago.setEnabled(true);
            this.JTFNTransaccion.setText("");
            this.JTFNTransaccion.setEnabled(false);
            this.JCB_CCosto.setEnabled(true);
            this.sql = "SELECT k_cajaxconceptos.Id_Concepto, k_conceptos.Nbre, k_conceptos.Abono FROM k_cajaxconceptos INNER JOIN k_conceptos ON (k_cajaxconceptos.Id_Concepto = k_conceptos.Id) WHERE (k_cajaxconceptos.Id_Caja ='" + this.frmFacturac.clasecaja.getIdCaja() + "' and k_conceptos.Tipo=0 AND k_cajaxconceptos.Estado =1) ORDER BY Orden asc, k_conceptos.Nbre ASC";
            this.xId_Concepto = this.consultas.llenarComboyLista(this.sql, this.xId_Concepto, this.JCBConcepto_C, 3);
            this.consultas.llenarComboTabla("SELECT Id, Nbre FROM f_centrocosto WHERE Estado = 0 ORDER BY Nbre ASC", this.JCB_CCosto, this.metodos.modcombos, 1);
            this.consultas.cerrarConexionBd();
            this.xllenoc = true;
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                System.out.println("entra 1");
                this.JCB_CCosto.setSelectedIndex(0);
                this.JTFF_TotalRecibo.setValue(Double.valueOf(this.frmFacturac.frmPersona.listaRelacionLaboral[this.frmFacturac.frmPersona.cboRelacionLaboral.getSelectedIndex()][6]));
                this.JTFF_Descuento.setEnabled(false);
            } else {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    if (Double.valueOf(this.JTFF_TotalRecibo.getValue().toString()).doubleValue() > 0.0d) {
                        this.JCBConcepto_C.setSelectedIndex(-1);
                        this.JCB_CCosto.setSelectedIndex(-1);
                    } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                        this.JCBConcepto_C.setSelectedItem("PAGO DE EXAMENES PARTICUALRES");
                        this.JCB_CCosto.setSelectedItem("LABORATORIO");
                    } else {
                        this.JCBConcepto_C.setSelectedIndex(0);
                        this.JCB_CCosto.setSelectedIndex(0);
                    }
                } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    this.JCBConcepto_C.setSelectedItem("PAGO DE EXAMENES PARTICUALRES");
                    this.JCB_CCosto.setSelectedItem("LABORATORIO");
                } else {
                    this.JCBConcepto_C.setSelectedIndex(-1);
                    this.JCB_CCosto.setSelectedIndex(-1);
                }
                calcularTotalRecibo();
            }
            this.xllenoc = true;
            this.xllenof = true;
        }
    }

    private void cargarCombos() {
        this.sql = "SELECT f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre, f_gruposervicio.ConSubGrupo FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.idEmpresa + " AND f_subgrupo_empresa.Estado =1) GROUP BY f_gruposervicio.Id_GrupoServicio ORDER BY f_gruposervicio.Nbre ASC ";
        this.consultas.llenarComboTabla(this.sql, this.cboGrupo, this.metodos.modcombos, 1);
        this.consultas.cerrarConexionBd();
        if (this.cboGrupo.getPopupTable().getRowCount() == 1) {
            this.cboGrupo.setSelectedIndex(0);
        }
        if (this.xrdescuento.equals("true")) {
            this.txtTotalDescuento.setEnabled(true);
        } else {
            this.txtTotalDescuento.setEnabled(false);
        }
        this.xid_tipodoc = this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC", this.xid_tipodoc, this.JCBTipoDocC);
        if (Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JCBTipoDocC.setSelectedItem("VENTAS");
        } else if (this.xid_tipodoc.length > 0) {
            this.JCBTipoDocC.setSelectedIndex(0);
        }
        this.JCBFPago.removeAllItems();
        this.xId_Fpago = this.consultas.llenarComboyLista("SELECT  `Id` , `Nbre` , `DatosA`, CDebito FROM `k_formapago` WHERE (`Estado` =1) ORDER BY `Orden` ASC, `Nbre` ASC", this.xId_Fpago, this.JCBFPago, 4);
        if (Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.JCBFPago.setSelectedIndex(1);
        } else {
            this.JCBFPago.setSelectedIndex(0);
        }
        this.consultas.cerrarConexionBd();
        this.xidperiodo = this.consultas.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
        }
    }

    private void cargarSubGrupo(String p) {
        this.sql = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre, f_subgrupo_empresa.`CPuc_Debito` , f_subgrupo_empresa.`CPuc_Credito`, g_empresa.`Id` IdEmmpresa, f_subgruposervicio.formaImpresion  FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id)  INNER JOIN g_empresa  ON (g_empresa.`Id`= f_empresacontxconvenio.`Id_EmpresaCont`)  WHERE (f_subgrupo_empresa.Id_Empresa =" + this.idEmpresa + " AND f_subgrupo_empresa.Estado =1 AND f_subgruposervicio.Id_GrupoServicio ='" + this.cboGrupo.getPopupTable().getValueAt(this.cboGrupo.getSelectedIndex(), 0) + "') ORDER BY f_subgruposervicio.Nbre ASC ";
        this.consultas.llenarComboTabla(this.sql, this.cboSubGrupo, this.metodos.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    public long calcularcuota_copago(double vrservicio, int tipo) {
        long valor = 0;
        double porcentaje = Double.parseDouble(this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][1]);
        long vrMaximo = Long.parseLong(this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][2]);
        if (tipo == 0) {
            valor = vrMaximo;
        } else {
            long copago = Math.round((vrservicio * (100.0d - porcentaje)) / 100.0d);
            this.rs = this.consultas.traerRs("SELECT Redondear(" + copago + ")");
            try {
                if (this.rs.next()) {
                    this.rs.first();
                    valor = this.rs.getLong(1);
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return valor;
    }

    public void grabar() {
        if (this.frmSE.tablaLlena) {
            if (this.frmFacturac.cajaAbierta == 0) {
                if (validarCampos() == 1 && mValidad_DCaja() && mValidadMovContable()) {
                    if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() >= 0.0d) {
                        if (this.xtipo == 0) {
                            setNoLiquidacion(grabarLiquidacion());
                        } else {
                            setNoLiquidacion(grabarLiquidacion1());
                        }
                        this.consultas.cerrarConexionBd();
                        grabarFacturaUOrden(getNoLiquidacion());
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            mGrabarDocContableBienestar();
                        } else {
                            mGrabarDocContable();
                        }
                        this.btnGrabar.setEnabled(false);
                        this.btnAnular.setEnabled(true);
                        this.btnImprimir.setEnabled(true);
                        this.frmFacturac.clasefacturacion.setXgrabadofact(true);
                        if ((Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.") || Principal.informacionIps.getIdentificacion().equals("900895500")) && ((this.frmFacturac.frmOrdenes.getIdServicio().equals("2") || this.frmFacturac.frmOrdenes.getIdServicio().equals("5")) && this.frmFacturac.clasefacturacion.getXrecepcionalaboratorio() == 0)) {
                            this.frmFacturac.clasefacturacion.cargarPantalla("Recepcion Laboratorio");
                            this.frmFacturac.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(this.frmFacturac.frmOrdenes.getXidorden());
                            this.frmFacturac.clasefacturacion.xjifrecepcionlab.buscarOrden();
                        }
                    }
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        if (this.JCHAplicaCobro.isSelected()) {
                            grabarReciboCaja(this.txtNoEps.getText(), getNoLiquidacion());
                        }
                    } else if (this.btnEps.isSelected() || this.btnAmbos.isSelected()) {
                        if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() > 0.0d) {
                            if (this.JCHAplicaCobro.isSelected()) {
                                grabarReciboCaja(this.txtNoEps.getText(), getNoLiquidacion());
                            }
                        } else if (this.JCHAplicaCobro.isSelected()) {
                            grabarReciboCaja("0", getNoLiquidacion());
                        }
                    } else if (!this.txtNoPaciente.getText().equals("0")) {
                        if (this.JCHAplicaCobro.isSelected()) {
                            grabarReciboCaja(this.txtNoPaciente.getText(), getNoLiquidacion());
                        }
                    } else if (this.JCHAplicaCobro.isSelected()) {
                        grabarReciboCaja("0", getNoLiquidacion());
                    }
                    imprimir();
                    dispose();
                    getGrabarEncuesta();
                    mVerificaCausaExterna();
                    getLimpiaraFormulario();
                    return;
                }
                return;
            }
            if (validarCampos() == 1 && mValidadMovContable()) {
                if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() >= 0.0d) {
                    if (this.xtipo == 0) {
                        setNoLiquidacion(grabarLiquidacion());
                    } else {
                        setNoLiquidacion(grabarLiquidacion1());
                    }
                    this.consultas.cerrarConexionBd();
                    grabarFacturaUOrden(getNoLiquidacion());
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGrabarDocContableBienestar();
                    } else {
                        mGrabarDocContable();
                    }
                    this.btnGrabar.setEnabled(false);
                    this.btnAnular.setEnabled(true);
                    this.btnImprimir.setEnabled(true);
                    this.frmFacturac.clasefacturacion.setXgrabadofact(true);
                    imprimir();
                }
                dispose();
                getGrabarEncuesta();
                mVerificaCausaExterna();
                getLimpiaraFormulario();
                return;
            }
            return;
        }
        int n = JOptionPane.showOptionDialog(this, "¿Desea adjuntar soportes escaneados?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, (Object) null);
        if (n == 0) {
            this.JTPDATOS.setSelectedIndex(2);
            return;
        }
        if (this.frmFacturac.cajaAbierta == 0) {
            if (validarCampos() == 1 && mValidad_DCaja() && mValidadMovContable()) {
                if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() >= 0.0d) {
                    if (this.xtipo == 0) {
                        setNoLiquidacion(grabarLiquidacion());
                    } else {
                        setNoLiquidacion(grabarLiquidacion1());
                    }
                    this.consultas.cerrarConexionBd();
                    grabarFacturaUOrden(getNoLiquidacion());
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        mGrabarDocContableBienestar();
                    } else {
                        mGrabarDocContable();
                    }
                    this.btnGrabar.setEnabled(false);
                    this.btnAnular.setEnabled(true);
                    this.btnImprimir.setEnabled(true);
                    this.frmFacturac.clasefacturacion.setXgrabadofact(true);
                    if ((Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) && ((this.frmFacturac.frmOrdenes.getIdServicio().equals("2") || this.frmFacturac.frmOrdenes.getIdServicio().equals("5")) && this.frmFacturac.clasefacturacion.getXrecepcionalaboratorio() == 0)) {
                        this.frmFacturac.clasefacturacion.cargarPantalla("Recepcion Laboratorio");
                        this.frmFacturac.clasefacturacion.xjifrecepcionlab.txtNoOrden.setText(this.frmFacturac.frmOrdenes.getXidorden());
                        this.frmFacturac.clasefacturacion.xjifrecepcionlab.buscarOrden();
                    }
                }
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (this.JCHAplicaCobro.isSelected()) {
                        grabarReciboCaja(this.txtNoEps.getText(), getNoLiquidacion());
                    }
                } else if (this.btnEps.isSelected() || this.btnAmbos.isSelected()) {
                    if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() > 0.0d) {
                        if (this.JCHAplicaCobro.isSelected()) {
                            grabarReciboCaja(this.txtNoEps.getText(), getNoLiquidacion());
                        }
                    } else if (this.JCHAplicaCobro.isSelected()) {
                        grabarReciboCaja("0", getNoLiquidacion());
                    }
                } else if (!this.txtNoPaciente.getText().equals("0")) {
                    if (this.JCHAplicaCobro.isSelected()) {
                        grabarReciboCaja(this.txtNoPaciente.getText(), getNoLiquidacion());
                    }
                } else if (this.JCHAplicaCobro.isSelected()) {
                    grabarReciboCaja("0", getNoLiquidacion());
                }
                imprimir();
                dispose();
                getGrabarEncuesta();
                mVerificaCausaExterna();
                getLimpiaraFormulario();
                return;
            }
            return;
        }
        if (validarCampos() == 1 && mValidadMovContable()) {
            if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() >= 0.0d) {
                if (this.xtipo == 0) {
                    setNoLiquidacion(grabarLiquidacion());
                } else {
                    setNoLiquidacion(grabarLiquidacion1());
                }
                this.consultas.cerrarConexionBd();
                grabarFacturaUOrden(getNoLiquidacion());
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    mGrabarDocContableBienestar();
                } else {
                    mGrabarDocContable();
                }
                this.btnGrabar.setEnabled(false);
                this.btnAnular.setEnabled(true);
                this.btnImprimir.setEnabled(true);
                this.frmFacturac.clasefacturacion.setXgrabadofact(true);
                imprimir();
            }
            dispose();
            mVerificaCausaExterna();
            getGrabarEncuesta();
            getLimpiaraFormulario();
        }
    }

    private void getGrabarEncuesta() {
        if (Principal.clasefacturacion.frmFacturac.getEncuestaRegistroUsuario() != null) {
            try {
                if (this.frmFacturac.getEncuestaRegistroUsuario() != null) {
                    System.err.println("entro a grabar encuesta");
                    MetodosHttp metodosHttp = new MetodosHttp();
                    this.frmFacturac.getEncuestaRegistroUsuario().setIdIngreso(Long.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()));
                    System.out.println("" + this.metodos.getMapper().writeValueAsString("consolidado " + this.frmFacturac.getEncuestaRegistroUsuario()));
                }
            } catch (JsonProcessingException e) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void getLimpiaraFormulario() {
    }

    private void mGrabarDocContable() {
        String xNFactura;
        if (this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento().equals("true")) {
            try {
                if (this.btnPaciente.isSelected()) {
                    xNFactura = this.txtNoPaciente.getText();
                } else {
                    xNFactura = this.txtNoEps.getText();
                }
                System.err.println("idFactura" + this.idFactura);
                String xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xid_tipodoc[this.JCBTipoDocC.getSelectedIndex()] + "','" + this.idFactura + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','0',' FACTURA VENTA N° " + xNFactura + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JTF_NoDocContable.setText(this.consultas.ejecutarSQLId(xsql));
                this.consultas.cerrarConexionBd();
                String xsql2 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + this.cboSubGrupo.getPopupTable().getValueAt(this.cboSubGrupo.getSelectedIndex(), 3) + "','1','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','" + xNFactura + "','0','" + this.txtTotalpaciente.getValue() + "',' FACTURA VENTA N° " + xNFactura + "')";
                this.consultas.ejecutarSQL(xsql2);
                this.consultas.cerrarConexionBd();
                String xsql3 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + this.cboSubGrupo.getPopupTable().getValueAt(this.cboSubGrupo.getSelectedIndex(), 2) + "','0','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','" + xNFactura + "','" + this.txtTotalpaciente.getValue() + "','0',' FACTURA VENTA N° " + xNFactura + "')";
                this.consultas.ejecutarSQL(xsql3);
                this.consultas.cerrarConexionBd();
                String xsql4 = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, round((" + this.txtTotalpaciente.getValue() + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, round((" + this.txtTotalpaciente.getValue() + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getIdEmpresa() + "') GROUP BY `cc_puc`.`Id`";
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs2 = xct2.traerRs(xsql4);
                Throwable th = null;
                try {
                    try {
                        if (xrs2.next()) {
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                ConsultasMySQL xct3 = new ConsultasMySQL();
                                String xsql5 = " into into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','0','" + xNFactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "','" + this.txtTotalpaciente.getValue() + "',' FACTURA VENTA N° " + xNFactura + "' )";
                                xct3.ejecutarSQL(xsql5);
                                xct3.cerrarConexionBd();
                            }
                        }
                        if (xrs2 != null) {
                            if (0 != 0) {
                                try {
                                    xrs2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs2.close();
                            }
                        }
                        xct2.cerrarConexionBd();
                        String sqlCuentaCobro = "insert into f_cuentacobro(Id_PeriodoC, IdGrupoServicio, IdEmpContxConv, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + this.cboGrupo.getPopupTable().getValueAt(this.cboGrupo.getSelectedIndex(), 0) + "','" + this.frmFacturac.frmIngreso.getIdEmpresa() + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.txtTotalServicio.getValue() + "','" + this.txtCuotaM.getValue() + "','" + this.txtCopago.getValue() + "','" + this.txtTotalDescuento.getValue() + "','" + this.txtTotalpaciente.getValue() + "', '0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xcuentacobro = this.consultas.ejecutarSQLId(sqlCuentaCobro);
                        this.consultas.cerrarConexionBd();
                        String xsql6 = "update f_factura_evento set EstaArmada=2, Id_DocumentoC='" + this.JTF_NoDocContable.getText() + "', No_CuentaCobro='" + xcuentacobro + "'  WHERE (`No_FacturaEvento` ='" + this.idFactura + "')";
                        this.consultas.ejecutarSQL(xsql6);
                        this.consultas.cerrarConexionBd();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mFacturaEventoCopagoCuotaModeradora() {
        if (!this.frmFacturac.frmPersona.txtCorreo.getText().equals("")) {
            this.gEmpresaEntity = this.iGEmpresaService.getGEmpresaByNumeroDocumento(this.frmFacturac.frmPersona.getIdentificacion());
            if (this.gEmpresaEntity != null) {
                this.gEmpresaEntity.setCorreo(this.frmFacturac.frmPersona.txtCorreo.getText());
                this.gEmpresaEntity.setCorreoFacturaElectronica(this.frmFacturac.frmPersona.txtCorreo.getText());
                this.gEmpresaEntity.setNbre(this.frmFacturac.frmPersona.getApellido1() + " " + this.frmFacturac.frmPersona.getApellido2() + " " + this.frmFacturac.frmPersona.getNombre1() + " " + this.frmFacturac.frmPersona.getNombre2());
                this.gEmpresaEntity.setDireccion(this.frmFacturac.frmPersona.getDireccion());
                this.gEmpresaEntity.setTelNumero(this.frmFacturac.frmPersona.getTelefono());
                this.iGEmpresaService.seve(this.gEmpresaEntity);
                mCrearConvenio();
                return;
            }
            GMunicipio municipio = new GMunicipio();
            municipio.setId(this.frmFacturac.frmPersona.getIdMunicipio());
            CcTipoClasificacionTercero ccTipoClasificacionTercero = new CcTipoClasificacionTercero();
            ccTipoClasificacionTercero.setId(1);
            CcTipoVigenciaPago ccTipoVigenciaPago = new CcTipoVigenciaPago();
            ccTipoVigenciaPago.setId(1);
            this.gEmpresaEntity = new GEmpresa();
            this.gEmpresaEntity.setIdTipoIdentificacion(this.frmFacturac.frmPersona.getIdTipoIdentifiacion());
            this.gEmpresaEntity.setApellido1(this.frmFacturac.frmPersona.getApellido1());
            this.gEmpresaEntity.setApellido2(this.frmFacturac.frmPersona.getApellido2());
            this.gEmpresaEntity.setNombre1(this.frmFacturac.frmPersona.getNombre1());
            this.gEmpresaEntity.setNombre2(this.frmFacturac.frmPersona.getNombre2());
            this.gEmpresaEntity.setNbre(this.frmFacturac.frmPersona.getApellido1() + " " + this.frmFacturac.frmPersona.getApellido2() + " " + this.frmFacturac.frmPersona.getNombre1() + " " + this.frmFacturac.frmPersona.getNombre2());
            this.gEmpresaEntity.setNoidentificacion(this.frmFacturac.frmPersona.getIdentificacion());
            this.gEmpresaEntity.setIdMunicipio(municipio);
            this.gEmpresaEntity.setDireccion(this.frmFacturac.frmPersona.getDireccion());
            this.gEmpresaEntity.setTelNumero(this.frmFacturac.frmPersona.getTelefono());
            this.gEmpresaEntity.setCorreo(this.frmFacturac.frmPersona.txtCorreo.getText());
            this.gEmpresaEntity.setCorreoFacturaElectronica(this.frmFacturac.frmPersona.txtCorreo.getText());
            this.gEmpresaEntity.setIdClasificacionT(ccTipoClasificacionTercero);
            this.gEmpresaEntity.setIdVigenciaP(ccTipoVigenciaPago);
            this.iGEmpresaService.seve(this.gEmpresaEntity);
            mCrearConvenio();
            return;
        }
        JOptionPane.showMessageDialog(this, "Error paciente sin correo: ", "Error", 0);
    }

    private void mCrearConvenio() {
        this.empresaContConvenioEntity = this.iEmpresaContConvenioService.getEmpresaContConvenioEntityByidEmpresaCont(this.gEmpresaEntity);
        if (this.empresaContConvenioEntity != null) {
            mCrearGrupoSubgrupo();
            return;
        }
        DatosIpsEntity datosIpsEntity = new DatosIpsEntity();
        datosIpsEntity.setId(1);
        MunicipioDTO municipio = new MunicipioDTO();
        municipio.setId(this.frmFacturac.frmPersona.getIdMunicipio());
        TipoAseguramientoDTO tipoAseguramientoDTO = new TipoAseguramientoDTO();
        tipoAseguramientoDTO.setId(1);
        TipoCoberturaPlanDTO tipoCoberturaPlanDTO = new TipoCoberturaPlanDTO();
        tipoCoberturaPlanDTO.setId(1);
        TipoContratacionDTO tipoContratacionDTO = new TipoContratacionDTO();
        tipoContratacionDTO.setId(1);
        TipoPlanEntity tipoPlanEntity = new TipoPlanEntity();
        tipoPlanEntity.setId(1);
        TipoRegimenEntity tipoRegimenEntity = new TipoRegimenEntity();
        tipoRegimenEntity.setId(true);
        this.empresaContConvenioEntity = new EmpresaContConvenioEntity();
        this.empresaContConvenioEntity.setIdEmpresaCont(this.gEmpresaEntity);
        this.empresaContConvenioEntity.setIdGIps(datosIpsEntity);
        this.empresaContConvenioEntity.setIdMunicipio(municipio);
        this.empresaContConvenioEntity.setIdTipoAseguramiento(tipoAseguramientoDTO);
        this.empresaContConvenioEntity.setIdTipoCoberturaPlan(tipoCoberturaPlanDTO);
        this.empresaContConvenioEntity.setIdTipoContratacion(tipoContratacionDTO);
        this.empresaContConvenioEntity.setIdTipoPlan(tipoPlanEntity);
        this.empresaContConvenioEntity.setIdTipoRegimen(tipoRegimenEntity);
        this.empresaContConvenioEntity.setNbre(this.frmFacturac.frmPersona.getApellido1() + " " + this.frmFacturac.frmPersona.getApellido2() + " " + this.frmFacturac.frmPersona.getNombre1() + " " + this.frmFacturac.frmPersona.getNombre2());
        this.empresaContConvenioEntity.setEstado(false);
        this.empresaContConvenioEntity.setId_Manual(true);
        this.iEmpresaContConvenioService.save(this.empresaContConvenioEntity);
        mCrearGrupoSubgrupo();
    }

    private void mCrearGrupoSubgrupo() {
        this.subgrupoEmpresaEntity = this.iSubgrupoEmpresaService.getSubgrupoEmpresaEntityByempresaContConvenioEntity(this.empresaContConvenioEntity);
        if (this.subgrupoEmpresaEntity != null) {
            crearLiquidacion();
            return;
        }
        if (!this.txtCopago.getText().equals("0")) {
            this.subgruposervicioEntity = this.iSubgrupoServicioService.getSubgruposervicioEntityByesCuotaModeradora(2);
        } else if (!this.txtCuotaM.getText().equals("0")) {
            this.subgruposervicioEntity = this.iSubgrupoServicioService.getSubgruposervicioEntityByesCuotaModeradora(1);
        }
        System.err.println("credito" + this.subgruposervicioEntity.getIdSubgrupoServicio());
        System.err.println("debito" + this.subgruposervicioEntity.getCPucDebito());
        System.err.println("credito" + this.subgruposervicioEntity.getCPucCredito());
        this.subgrupoEmpresaEntity = new SubgrupoEmpresaEntity();
        this.subgrupoEmpresaEntity.setEmpresaContConvenioEntity(this.empresaContConvenioEntity);
        this.subgrupoEmpresaEntity.setSubgruposervicioEntity(this.subgruposervicioEntity);
        this.subgrupoEmpresaEntity.setCPucDebito(this.subgruposervicioEntity.getCPucDebito());
        this.subgrupoEmpresaEntity.setCPucCredito(this.subgruposervicioEntity.getCPucCredito());
        this.subgrupoEmpresaEntity.setUsuarioS(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.subgrupoEmpresaEntity.setFecha(this.metodos.getFechaActual());
        this.iSubgrupoEmpresaService.grabar(this.subgrupoEmpresaEntity);
        crearLiquidacion();
    }

    private void crearLiquidacion() {
        try {
            this.liquidacionEntity = new LiquidacionEntity();
            this.liquidacionEntity.setIdIngreso(0L);
            this.liquidacionEntity.setCopago(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setCuotaModeradora(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setDireccionIp(Principal.getLocalHost().getHostAddress());
            this.liquidacionEntity.setEstado(false);
            this.liquidacionEntity.setFecha(this.metodos.getFechaActual());
            this.liquidacionEntity.setIdEmpresaContxConv(this.empresaContConvenioEntity.getId());
            this.liquidacionEntity.setIdFormaPago(Integer.valueOf(this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0]));
            this.liquidacionEntity.setIdSubGrupoServicio(this.subgrupoEmpresaEntity);
            this.liquidacionEntity.setIdMotivoAnulacion(1);
            this.liquidacionEntity.setIdUsuarioRH(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().intValue()));
            this.liquidacionEntity.setNEquipo(Principal.getLocalHost().getHostName());
            this.liquidacionEntity.setNFolios(0);
            this.liquidacionEntity.setObservacion("");
            this.liquidacionEntity.setObservacionAnulacion("");
            this.liquidacionEntity.setTGlosa(Double.valueOf(0.0d));
            this.liquidacionEntity.setTPagado(Double.valueOf(0.0d));
            if (!this.txtCopago.getText().equals("0")) {
                this.liquidacionEntity.setTotalServicio(Double.valueOf(this.txtCopago.getValue().toString()).doubleValue());
                this.liquidacionEntity.setTotalEps(Double.valueOf(this.txtCopago.getValue().toString()).doubleValue());
            } else if (!this.txtCuotaM.getText().equals("0")) {
                this.liquidacionEntity.setTotalServicio(Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue());
                this.liquidacionEntity.setTotalEps(Double.valueOf(this.txtCopago.getValue().toString()).doubleValue());
            }
            this.liquidacionEntity.setTotalDescuento(Double.valueOf(0.0d).doubleValue());
            this.liquidacionEntity.setUsuarioAnulacion("");
            this.liquidacionEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.liquidacionEntity.setVGlosaNR(Double.valueOf(0.0d));
            this.liquidacionEntity.setVGlosaR(Double.valueOf(0.0d));
            this.liquidacionEntity.setIdIngresoPrincipal(Integer.valueOf(Integer.parseInt(this.frmFacturac.frmIngreso.getIdIngreso())));
            this.iLiquidacionService.save(this.liquidacionEntity);
            mFacturaEventoCopago();
            mFacturaDetalleCopago();
            mCuentaCobro();
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                mDocumentoContableCopago();
            }
            actualizarFacturaCopago(this.facturaEvento.getId().longValue(), this.fCuentacobro.getNoCuenta().longValue(), this.cCDocumentoc.getId().longValue(), this.fCuentacobro.getNoCuenta().longValue());
            this.btnGrabarFactura.setEnabled(false);
            System.err.println("factura copa grabada" + this.facturaEvento.getPrefijo() + "" + this.facturaEvento.getNoFacturaeventoM());
            this.txtNoFactura.setText(this.facturaEvento.getPrefijo() + "" + this.facturaEvento.getNoFacturaeventoM().toString());
        } catch (NumberFormatException e) {
            System.err.println("liquidacion no grabada");
        }
    }

    private void mFacturaEventoCopago() {
        mValidaResolucionDian(true);
        ResolucionDianDTO resolucionDianDTO = new ResolucionDianDTO();
        resolucionDianDTO.setId(this.resolucionDian.getId());
        GEtapaProceso etapaProceso = new GEtapaProceso();
        etapaProceso.setId("0");
        this.facturaEvento = new FFacturaEvento();
        this.facturaEvento.setFechaFacturaevento(this.metodos.getFechaActual());
        this.facturaEvento.setIdLiquidacion(this.liquidacionEntity);
        this.facturaEvento.setIdResolucionDian(resolucionDianDTO);
        this.facturaEvento.setEstado(0);
        this.facturaEvento.setTipoFactura(0);
        int fPago = Integer.parseInt(this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0]);
        this.facturaEvento.setIdMedioPago(Integer.valueOf(fPago));
        Long numDefault = Long.valueOf("0");
        this.facturaEvento.setNoFacturaeventoM(numDefault);
        this.facturaEvento.setIdMotivoanulacion(0);
        this.facturaEvento.setMotivoAnulacion("");
        this.facturaEvento.setUsuarioAnulacion("");
        this.facturaEvento.setEstaArmada(2);
        this.facturaEvento.setNoCuentacobro(new Long(0L));
        this.facturaEvento.setPrefijo(this.resolucionDian.getPrefijo());
        this.facturaEvento.setIdDocumentoc(new Long(0L));
        this.facturaEvento.setNRadicado("");
        this.facturaEvento.setUrlRadicado("");
        this.facturaEvento.setSede(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.facturaEvento.setIndicador("I");
        this.facturaEvento.setCJuridico(0);
        this.facturaEvento.setIdEtapaProcedo(etapaProceso);
        this.facturaEvento.setIdDocumentocr(new Long(0L));
        this.facturaEvento.setConceptoCobro("ejemplo");
        this.facturaEvento.setEsta(0);
        this.facturaEvento.setRDian(this.resolucionDian.getDescripcion());
        this.facturaEvento.setDireccionIp(Principal.getLocalHost().getHostAddress());
        this.facturaEvento.setNEquipo(Principal.getLocalHost().getHostName());
        this.facturaEvento.setFecha(this.metodos.getFechaActual());
        this.facturaEvento.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.fFacturaEventoService.save(this.facturaEvento);
    }

    private void mFacturaDetalleCopago() {
        this.fFacturaEventoDetalle = new FFacturaEventoDetalle();
        this.fFacturaEventoDetalle.setNo_FacturaEvento(this.facturaEvento);
        this.fFacturaEventoDetalle.setNUsuarios("0");
        if (!this.txtCopago.getText().equals("0")) {
            this.fFacturaEventoDetalle.setConcepto("COPAGO");
            this.fFacturaEventoDetalle.setTotal(Double.valueOf(this.txtCopago.getValue().toString()));
        } else if (!this.txtCuotaM.getText().equals("0")) {
            this.fFacturaEventoDetalle.setConcepto("CUOTAMODERADORA");
            this.fFacturaEventoDetalle.setTotal(Double.valueOf(this.txtCuotaM.getValue().toString()));
        }
        this.fFacturaEventoDetalleService.save(this.fFacturaEventoDetalle);
    }

    private void mCuentaCobro() {
        CcPeriodoContable cPeriodoContable = new CcPeriodoContable();
        cPeriodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
        GruposervicioEntity gruposervicioEntity = new GruposervicioEntity();
        gruposervicioEntity.setIdGrupoServicio(2);
        this.fCuentacobro = new FCuentacobro();
        this.fCuentacobro.setIdPeriodoC(cPeriodoContable);
        this.fCuentacobro.setIdEmpContxConv(this.empresaContConvenioEntity);
        this.fCuentacobro.setIdGrupoServicio(gruposervicioEntity);
        this.fCuentacobro.setConceptoCobro("ejemplo");
        this.fCuentacobro.setTotalServicio(Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue());
        this.fCuentacobro.setNoRegistros(1);
        this.fCuentacobro.setTotalNeto(Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue());
        this.fCuentacobro.setPeriodoFact(this.metodos.getFechaActual());
        this.fCuentacobro.setPeriodoFact1(this.metodos.getFechaActual());
        this.fCuentacobro.setFecha(this.metodos.getFechaActual());
        this.fCuentacobro.setRadicacion("0");
        this.facturaEvento.setFechaFacturaevento(this.metodos.getFechaActual());
        this.fCuentacobro.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.iFCuentacobroService.save(this.fCuentacobro);
    }

    private void mDocumentoContableCopago() {
        try {
            CcTipoDocumentoc tipoDocumentoc = new CcTipoDocumentoc();
            tipoDocumentoc.setId(6);
            CcPeriodoContable periodoContable = new CcPeriodoContable();
            periodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
            this.cCDocumentoc = new CcDocumentoc();
            this.cCDocumentoc.setFechaD(this.metodos.getFechaActual());
            this.cCDocumentoc.setIdTipoComprobante(tipoDocumentoc);
            this.cCDocumentoc.setIdPeriodoC(periodoContable);
            this.cCDocumentoc.setDescripcion("Factura Venta N° " + this.facturaEvento.getId());
            this.cCDocumentoc.setNConsecutivo(BigInteger.ZERO);
            this.cCDocumentoc.setAprobadoA(false);
            this.cCDocumentoc.setEjecutado(false);
            this.cCDocumentoc.setEsGlobal(false);
            this.cCDocumentoc.setEstado(true);
            this.cCDocumentoc.setEstadoA(false);
            this.cCDocumentoc.setExportadoC(false);
            this.cCDocumentoc.setFechaR(new Date());
            this.cCDocumentoc.setGenerarC(false);
            this.cCDocumentoc.setIdCertificado(0);
            this.cCDocumentoc.setIdCierreCaja(0);
            this.cCDocumentoc.setIdConcepto(0);
            this.cCDocumentoc.setIdCuentaCobro(0);
            this.cCDocumentoc.setIdCuentaEmpresa(0);
            this.cCDocumentoc.setIdCuentaEmpresaP(0);
            this.cCDocumentoc.setIdNomina(BigInteger.ZERO);
            this.cCDocumentoc.setIdRadicacion(BigInteger.ZERO);
            this.cCDocumentoc.setRevisadoC(false);
            this.cCDocumentoc.setTipoPago(0);
            this.cCDocumentoc.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            System.err.println("subgrupoEmpresaEntity.getCPucDebito()" + this.subgrupoEmpresaEntity.getCPucDebito());
            CcPuc pucDebito = CcPuc.builder().id(this.subgrupoEmpresaEntity.getCPucDebito()).build();
            List<CcDetalleDocumentoc> listDetalle = new ArrayList<>();
            CcDetalleDocumentoc dDebito = CcDetalleDocumentoc.builder().idDocumentoc(this.cCDocumentoc).vDebito(Double.valueOf(this.txtCuotaM.getValue().toString())).base(new Double(0.0d)).concepto("Factura Venta N° " + this.facturaEvento.getId()).idRadicacion(0).idCertificado(0).idPuc(pucDebito).estado(1).tipoCPuc(0).vCredito(new Double(0.0d)).idConceptoN(0).nFactura(this.facturaEvento.getId().toString()).pRetencion(new Double(0.0d)).idTercero(this.gEmpresaEntity).build();
            listDetalle.add(dDebito);
            if (listDetalle != null) {
                CcPuc pucCredito = CcPuc.builder().id(this.subgrupoEmpresaEntity.getCPucCredito()).build();
                CcDetalleDocumentoc dCredito = CcDetalleDocumentoc.builder().idDocumentoc(this.cCDocumentoc).vDebito(new Double(0.0d)).base(new Double(0.0d)).concepto("Factura Venta N° " + this.facturaEvento.getId()).idRadicacion(0).idCertificado(0).idPuc(pucCredito).estado(1).tipoCPuc(1).vCredito(Double.valueOf(this.txtCuotaM.getValue().toString())).idConceptoN(0).nFactura(this.facturaEvento.getId().toString()).pRetencion(new Double(0.0d)).idTercero(this.gEmpresaEntity).build();
                listDetalle.add(dCredito);
            }
            this.cCDocumentoc.setCcDetalleDocumentocCollection(listDetalle);
            this.ccDocumentocService.grabar(this.cCDocumentoc);
        } catch (Exception e) {
            System.err.println("Error>>>>> : " + e);
        }
    }

    private void actualizarFacturaCopago(long id, long idCuenta, long idDocumento, long idCuentaCobro) {
        try {
            Optional<FFacturaEvento> optionaFFacturaEvento = this.fFacturaEventoService.findById(Long.valueOf(id));
            if (optionaFFacturaEvento.isPresent()) {
                FFacturaEvento fFacturaEventoExistente = optionaFFacturaEvento.get();
                fFacturaEventoExistente.setNoCuentacobro(Long.valueOf(idCuenta));
                fFacturaEventoExistente.setIdDocumentoc(Long.valueOf(idDocumento));
                fFacturaEventoExistente.setNoCuentacobro(Long.valueOf(idCuentaCobro));
                this.fFacturaEventoService.save(fFacturaEventoExistente);
                System.err.println("FACTURA actualizada con éxito");
            } else {
                System.err.println("No se encontró la FACTURA con el ID proporcionado");
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al actualizar la FACTURA");
        }
    }

    private void mGrabarDocContableBienestar() {
        String xNFactura;
        ResultSet rs0;
        Throwable th;
        if (this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getGMovimientoContable().equals("1")) {
            try {
                String idFactura = "0";
                if (this.btnPaciente.isSelected()) {
                    xNFactura = this.txtNoPaciente.getText();
                } else {
                    xNFactura = this.txtNoEps.getText();
                }
                String credito = "";
                try {
                    String SQLCredito = "SELECT\n  `f_centrocosto`.`CCredito` \nFROM\n  `f_factura_evento`\n  INNER JOIN `f_liquidacion`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  inner join `ingreso`\n    on (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  inner join `f_centrocosto`\n    on (`f_centrocosto`.`Id`=`f_ordenes`.`Id_CentroCosto`)\nwhere `f_factura_evento`.`No_FacturaEvento` = '" + xNFactura + "'";
                    System.out.println("SQLCredito -> " + SQLCredito);
                    rs0 = this.consultas.getResultSet(SQLCredito);
                    th = null;
                } catch (SQLException e) {
                    System.out.println("error ");
                }
                try {
                    try {
                        if (rs0.next()) {
                            credito = rs0.getString("CCredito");
                            System.out.println("credito -> " + credito);
                        }
                        if (rs0 != null) {
                            if (0 != 0) {
                                try {
                                    rs0.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                rs0.close();
                            }
                        }
                        rs0 = this.consultas.getResultSet("select concat(ffe.Prefijo,'',ffe.No_FacturaEvento_M) numeroFactura, ffe.No_FacturaEvento_M idFactura\nfrom f_factura_evento ffe \nwhere ffe.No_FacturaEvento ='" + xNFactura + "'");
                        Throwable th3 = null;
                        try {
                            try {
                                if (rs0.next()) {
                                    xNFactura = rs0.getString("numeroFactura");
                                    idFactura = rs0.getString("idFactura");
                                }
                                if (rs0 != null) {
                                    if (0 != 0) {
                                        try {
                                            rs0.close();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                    } else {
                                        rs0.close();
                                    }
                                }
                                System.err.println("f" + xNFactura);
                                System.err.println("idFactura" + idFactura);
                                String xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xid_tipodoc[this.JCBTipoDocC.getSelectedIndex()] + "','" + idFactura + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','0',' FACTURA VENTA N° " + xNFactura + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                System.out.println("Documentoc -> " + xsql);
                                this.JTF_NoDocContable.setText(this.consultas.ejecutarSQLId(xsql));
                                this.consultas.cerrarConexionBd();
                                String xsql2 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + credito + "','1','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','" + xNFactura + "','0','" + this.txtTotalpaciente.getValue() + "',' FACTURA VENTA N° " + xNFactura + "')";
                                System.out.println(" Detalle Puc 1: " + xsql2);
                                this.consultas.ejecutarSQL(xsql2);
                                this.consultas.cerrarConexionBd();
                                String xsql3 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + traerMedioPago() + "','0','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','" + xNFactura + "','" + this.txtTotalpaciente.getValue() + "','0',' FACTURA VENTA N° " + xNFactura + "')";
                                System.out.println(" Detalle Puc 2: " + xsql3);
                                this.consultas.ejecutarSQL(xsql3);
                                this.consultas.cerrarConexionBd();
                                String xsql4 = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, round((" + this.txtTotalpaciente.getValue() + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, round((" + this.txtTotalpaciente.getValue() + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getIdEmpresa() + "') GROUP BY `cc_puc`.`Id`";
                                System.out.println("consulta puc -> " + xsql4);
                                ConsultasMySQL xct2 = new ConsultasMySQL();
                                ResultSet xrs2 = xct2.traerRs(xsql4);
                                Throwable th5 = null;
                                try {
                                    try {
                                        if (xrs2.next()) {
                                            xrs2.beforeFirst();
                                            while (xrs2.next()) {
                                                ConsultasMySQL xct3 = new ConsultasMySQL();
                                                String xsql5 = " into into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTF_NoDocContable.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + Principal.clasefacturacion.mCrearTercero_GEmpresa(this.frmFacturac.frmPersona.getIdPersona(), this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmFacturac.frmPersona.getIdentificacion()) + "','0','" + xNFactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "','" + this.txtTotalpaciente.getValue() + "',' FACTURA VENTA N° " + xNFactura + "' )";
                                                System.out.println(" Detalle Puc 3: " + xsql5);
                                                xct3.ejecutarSQL(xsql5);
                                                xct3.cerrarConexionBd();
                                            }
                                        }
                                        if (xrs2 != null) {
                                            if (0 != 0) {
                                                try {
                                                    xrs2.close();
                                                } catch (Throwable th6) {
                                                    th5.addSuppressed(th6);
                                                }
                                            } else {
                                                xrs2.close();
                                            }
                                        }
                                        xct2.cerrarConexionBd();
                                        String xsql6 = "update f_factura_evento set EstaArmada=2, Id_DocumentoC='" + this.JTF_NoDocContable.getText() + "' WHERE `No_FacturaEvento_M` = (SELECT REPLACE('" + xNFactura + "', 'FVE', ''))";
                                        System.out.println("xsql update -> " + xsql6);
                                        this.consultas.ejecutarSQL(xsql6);
                                        this.consultas.cerrarConexionBd();
                                    } finally {
                                    }
                                } catch (Throwable th7) {
                                    th5 = th7;
                                    throw th7;
                                }
                            } finally {
                            }
                        } catch (Throwable th8) {
                            th3 = th8;
                            throw th8;
                        }
                    } finally {
                        if (rs0 != null) {
                            if (th != null) {
                                try {
                                    rs0.close();
                                } catch (Throwable th9) {
                                    th.addSuppressed(th9);
                                }
                            } else {
                                rs0.close();
                            }
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    throw th10;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void imprimir() {
        if (!Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") && !Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") && !Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            if (!this.txtNoEps.getText().isEmpty() || !this.txtNoPaciente.getText().isEmpty()) {
                dispose();
                int tamanoFactura = 1;
                if (this.cboSubGrupo.getPopupTable().getValueAt(this.cboSubGrupo.getSelectedIndex(), 5).toString().equals("false")) {
                    tamanoFactura = 0;
                }
                switch (getTipoFactura()) {
                    case 2:
                        this.frmFacturac.clasefacturacion.imprimir_FacturayOrden(1, this.txtNoPaciente.getText().toString(), this.frmFacturac.frmIngreso.getIdIngreso(), Principal.usuarioSistemaDTO.getNombreUsuario(), this.esCapitado, getTipoFactura(), tamanoFactura);
                        break;
                    case 3:
                        this.frmFacturac.clasefacturacion.imprimir_FacturayOrden(1, this.txtNoEps.getText().toString(), this.frmFacturac.frmIngreso.getIdIngreso(), Principal.usuarioSistemaDTO.getNombreUsuario(), this.esCapitado, 1, tamanoFactura);
                        this.frmFacturac.clasefacturacion.imprimir_FacturayOrden(1, this.txtNoPaciente.getText().toString(), this.frmFacturac.frmIngreso.getIdIngreso(), Principal.usuarioSistemaDTO.getNombreUsuario(), this.esCapitado, 2, tamanoFactura);
                        break;
                    default:
                        this.frmFacturac.clasefacturacion.imprimir_FacturayOrden(1, this.txtNoEps.getText().toString(), this.frmFacturac.frmIngreso.getIdIngreso(), Principal.usuarioSistemaDTO.getNombreUsuario(), this.esCapitado, getTipoFactura(), tamanoFactura);
                        if (Principal.informacionIps.getNombreIps().equals("SALUD A SU HOGAR IPS S.A.S.") || Principal.informacionIps.getIdentificacion().equals("812005644")) {
                            System.err.println("Variable" + this.frmFacturac.frmIngreso.getIdIngreso());
                            String[][] parametros = new String[3][2];
                            parametros[0][0] = "idingreso";
                            parametros[0][1] = this.frmFacturac.frmIngreso.getIdIngreso();
                            parametros[1][0] = "SUBREPORT_DIR";
                            parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                            parametros[2][0] = "SUBREPORTFIRMA_DIR";
                            parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Certificado_Ingreso", parametros);
                            System.out.println("pdf generado");
                        }
                        break;
                }
            }
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.visualizarFacturasEventoMetodoPrinicpal(this.frmFacturac.frmIngreso.getIdIngreso(), this.txtTotalServicio.getText(), this.txtTotalEps.getText(), this.txtTotalDescuento.getText(), this.txtCuotaM.getText(), this.txtTotalpaciente.getText(), this.txtTotalEps.getText(), 1, 0);
        }
    }

    private void mImprimirDocAdiconales() {
        try {
            this.sql = "SELECT  `h_so_datos_ocupacionales`.`Id`, `h_atencion`.`Id_ClaseCita` FROM  `h_so_datos_ocupacionales` INNER JOIN  `h_atencion`  ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_atencion`.`Id_Ingreso` ='" + Principal.txtNo.getText() + "'  AND `h_so_datos_ocupacionales`.`Estado` =1); ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                String[][] mparametros = new String[4][2];
                mparametros[0][0] = "Id";
                mparametros[0][1] = xrs.getString(1);
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "so_Autorizacion_examen", mparametros);
                if (xrs.getInt(2) == 181 || xrs.getInt(2) == 204) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "so_AptitudMedicaEgreso", mparametros);
                } else {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "so_aptitud_medica", mparametros);
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String BuscarIdFactura(String id) {
        String idFac = "";
        String sql = "SELECT CONCAT(`Prefijo`, `No_FacturaEvento_M`) AS fac\nFROM `baseserver`.`f_factura_evento` WHERE (`No_FacturaEvento` =" + id + " )";
        this.rs = this.consultas.traerRs(sql);
        System.out.println(sql);
        while (this.rs.next()) {
            try {
                idFac = this.rs.getString("fac");
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
        return idFac;
    }

    private void grabarFacturaUOrden(String idLiquidacion) {
        int tipofactura;
        int tipofactura2;
        if (this.esCapitado == 2) {
            mValidaResolucionDian(false);
            if (this.btnEps.isSelected()) {
                tipofactura2 = 0;
            } else if (this.btnPaciente.isSelected()) {
                tipofactura2 = 1;
            } else {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                    this.sql = "INSERT INTO f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M,  Id_Liquidacion, idResolucionDian, idMedioPago , TipoFactura, Sede, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "'," + idLiquidacion + "," + this.resolucionDian.getId() + "," + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + ",0,'" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    this.sql = "INSERT INTO f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M,  Id_Liquidacion, idResolucionDian, idMedioPago , TipoFactura, Sede, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "'," + idLiquidacion + "," + this.resolucionDian.getId() + "," + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + ",0,'" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.idFactura = this.consultas.ejecutarSQLId(this.sql);
                this.txtNoEps.setText(BuscarIdFactura(this.idFactura));
                this.consultas.cerrarConexionBd();
                this.txtEstadoEps.setText("ACTIVA");
                this.JDCFecha.setDate(this.metodos.getFechaActual());
                Principal.clasegeneral.mActualizar_ResolucionDian(this.idFactura, String.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId()));
                tipofactura2 = 1;
                if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
                    envioFacturaDian();
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.sql = "INSERT INTO f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M, Id_Liquidacion, idResolucionDian, idMedioPago , TipoFactura, Sede, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "'," + idLiquidacion + "," + this.resolucionDian.getId() + "," + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "," + tipofactura2 + ",'" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            } else {
                this.sql = "INSERT INTO f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M, Id_Liquidacion, idResolucionDian, idMedioPago , TipoFactura, Sede, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "'," + idLiquidacion + "," + this.resolucionDian.getId() + "," + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "," + tipofactura2 + ",'" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            }
            if (tipofactura2 == 0) {
                this.idFactura = this.consultas.ejecutarSQLId(this.sql);
                this.txtNoEps.setText(BuscarIdFactura(this.idFactura));
                this.consultas.cerrarConexionBd();
                this.txtEstadoEps.setText("ACTIVA");
                this.JDCFecha.setDate(this.metodos.getFechaActual());
                Principal.clasegeneral.mActualizar_ResolucionDian(this.idFactura, String.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId()));
                if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
                    envioFacturaDian();
                    return;
                }
                return;
            }
            this.idFactura = this.consultas.ejecutarSQLId(this.sql);
            this.txtNoPaciente.setText(BuscarIdFactura(this.idFactura));
            this.consultas.cerrarConexionBd();
            this.txtEstadoPaciente.setText("ACTIVA");
            this.txtFechaPaciente.setText(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
            Principal.clasegeneral.mActualizar_ResolucionDian(this.idFactura, String.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId()));
            if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
                envioFacturaDian();
                return;
            }
            return;
        }
        if (this.btnEps.isSelected()) {
            tipofactura = 0;
        } else if (this.btnPaciente.isSelected()) {
            tipofactura = 1;
        } else {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.sql = "INSERT INTO f_factura_capita(Fecha_FacturaCapita, Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'," + idLiquidacion + ",0,'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            } else {
                this.sql = "INSERT INTO f_factura_capita(Fecha_FacturaCapita, Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'," + idLiquidacion + ",0,'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            }
            this.txtNoEps.setText(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            this.txtEstadoEps.setText("ACTIVA");
            this.JDCFecha.setDate(this.metodos.getFechaActual());
            tipofactura = 1;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
            this.sql = "INSERT INTO f_factura_capita(Fecha_FacturaCapita, Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'," + idLiquidacion + "," + tipofactura + ",'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        } else {
            this.sql = "INSERT INTO f_factura_capita(Fecha_FacturaCapita, Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD.format(this.JDCFecha.getDate()) + "'," + idLiquidacion + "," + tipofactura + ",'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        }
        if (tipofactura == 0) {
            this.txtNoEps.setText(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            this.txtEstadoEps.setText("ACTIVA");
            this.JDCFecha.setDate(this.metodos.getFechaActual());
            return;
        }
        this.txtNoPaciente.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        this.txtEstadoPaciente.setText("ACTIVA");
        this.txtFechaPaciente.setText(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
    }

    private void buscarLiquidacion(String noIngreso) {
        this.sql = "SELECT f_liquidacion.Id , f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps, f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, f_liquidacion.CuotaModeradora, f_liquidacion.Copago, f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre AS GrupoServicio, f_subgruposervicio.Id_SubgrupoServicio, f_subgruposervicio.Nbre AS SubGrupoServicio, `k_formapago`.`Nbre` nFormaPago FROM f_liquidacion INNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  AND (f_subgrupo_empresa.Id_Empresa = ingreso.Id_EmpresaContxConv)  INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN  `k_formapago`   ON (`f_liquidacion`.`IdFormaPago` = `k_formapago`.`Id`) WHERE (ingreso.Id =" + noIngreso + " AND f_liquidacion.Estado =0) ";
        System.out.println(" Liquidacion  " + this.sql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(this.sql);
        try {
            if (xrs.next()) {
                this.txtTotalServicio.setValue(Long.valueOf(xrs.getLong("TotalServicio")));
                this.txtTotalEps.setValue(Long.valueOf(xrs.getLong("TotalEps")));
                this.txtTotalDescuento.setValue(Long.valueOf(xrs.getLong("TotalDescuento")));
                this.txtTotalpaciente.setValue(Long.valueOf(xrs.getLong("TotalPaciente")));
                this.txtCubierto.setValue(Long.valueOf(xrs.getLong("TotalPlan")));
                this.txtCuotaM.setValue(Long.valueOf(xrs.getLong("CuotaModeradora")));
                this.txtCopago.setValue(Long.valueOf(xrs.getLong("Copago")));
                this.cboGrupo.setSelectedItem(xrs.getString("GrupoServicio"));
                this.cboSubGrupo.setSelectedItem(xrs.getString("SubGrupoServicio"));
                this.JCBFPago.setSelectedItem(xrs.getString("nFormaPago"));
                this.txtTotalpaciente.setValue(Long.valueOf(xrs.getLong("TotalPaciente") + xrs.getLong("CuotaModeradora") + xrs.getLong("Copago")));
                setNoLiquidacion(xrs.getString("Id"));
                buscarFacturas(xrs.getString("Id"));
                mBuscar_Recibo_Caja();
                mActivarBotonGrabar();
            } else {
                System.out.println("no entra");
                totalizar();
                mActivarBotonGrabar();
            }
            if (this.txtTotalEps.getText().equals("0")) {
                this.btnEps.setEnabled(false);
                this.btnAmbos.setEnabled(false);
                this.btnPaciente.setEnabled(true);
                this.btnPaciente.setSelected(true);
                setTipoFactura(2);
            } else if (this.txtTotalpaciente.getText().equals("0")) {
                this.btnEps.setEnabled(true);
                this.btnAmbos.setEnabled(false);
                this.btnPaciente.setEnabled(false);
                this.btnEps.setSelected(true);
                setTipoFactura(1);
            } else {
                this.btnEps.setEnabled(true);
                this.btnAmbos.setEnabled(true);
                this.btnPaciente.setEnabled(true);
                this.btnEps.setSelected(true);
                setTipoFactura(1);
            }
            mActivarBotonGrabar();
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActivarBotonGrabar() {
        if (Double.valueOf(this.txtTotalServicio.getValue().toString()).doubleValue() > 0.0d) {
            if (this.btnEps.isSelected()) {
                if (!this.txtNoEps.getText().isEmpty()) {
                    this.btnGrabar.setEnabled(false);
                    this.btnAnular.setEnabled(true);
                    return;
                } else if (Double.valueOf(this.txtTotalEps.getValue().toString()).doubleValue() > 0.0d) {
                    this.btnGrabar.setEnabled(true);
                    this.btnAnular.setEnabled(true);
                    return;
                } else {
                    this.btnGrabar.setEnabled(false);
                    this.btnAnular.setEnabled(true);
                    return;
                }
            }
            if (this.btnPaciente.isSelected() && this.txtNoPaciente.getText().isEmpty()) {
                if (Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue() > 0.0d) {
                    this.btnGrabar.setEnabled(true);
                    this.btnAnular.setEnabled(true);
                    return;
                } else {
                    this.btnGrabar.setEnabled(false);
                    this.btnAnular.setEnabled(true);
                    return;
                }
            }
            return;
        }
        this.btnGrabar.setEnabled(false);
        this.btnAnular.setEnabled(true);
    }

    private void buscarFacturas(String idLiquidacion) {
        if (this.esCapitado == 2) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.sql = "SELECT f_factura_evento.No_FacturaEvento_M as No_Factura , f_factura_evento.Fecha_FacturaEvento as Fecha_Factura , f_factura_evento.TipoFactura , IF(f_factura_evento.Estado=0,'ACTIVA','') AS Estado, ifnull(f_factura_evento.No_FacturaEvento, '0') idFacturaEvento, ifnull(f_factura_evento.responseEstado, '') estadoEnvioDian, ifnull(f_factura_evento.responseMensaje, '') mensajeEnvioDian, f_factura_evento.No_FacturaEvento idFactura FROM f_factura_evento INNER JOIN f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_evento.Estado =0 AND f_liquidacion.Id =" + idLiquidacion + ")";
            } else {
                this.sql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,CONCAT(f_factura_evento.`Prefijo`, f_factura_evento.`No_FacturaEvento`),CONCAT(f_factura_evento.`Prefijo`, f_factura_evento.`No_FacturaEvento_M`)) as No_Factura , f_factura_evento.Fecha_FacturaEvento as Fecha_Factura , f_factura_evento.TipoFactura , IF(f_factura_evento.Estado=0,'ACTIVA','') AS Estado, ifnull(f_factura_evento.No_FacturaEvento, '0') idFacturaEvento, ifnull(f_factura_evento.responseEstado, '') estadoEnvioDian, ifnull(f_factura_evento.responseMensaje, '') mensajeEnvioDian, f_factura_evento.No_FacturaEvento idFactura  FROM f_factura_evento INNER JOIN f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_factura_evento.Estado =0 AND f_liquidacion.Id =" + idLiquidacion + " )";
            }
        } else {
            this.sql = "SELECT f_factura_capita.No_FacturaCapita as No_Factura, f_factura_capita.Fecha_FacturaCapita as Fecha_Factura  , f_factura_capita.TipoFactura , IF(f_factura_capita.Estado=0,'ACTIVA','') AS Estado, '' estadoEnvioDian, '' mensajeEnvioDian, '0' as idFactura  FROM f_factura_capita INNER JOIN f_liquidacion ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_capita.Estado =0 AND f_liquidacion.Id =" + idLiquidacion + ")";
        }
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                if (this.rs.getInt("TipoFactura") == 0) {
                    this.idFactura = this.rs.getString("idFactura");
                    this.txtNoEps.setText(this.rs.getString("No_Factura"));
                    this.JDCFecha.setDate(this.rs.getDate("Fecha_Factura"));
                    this.txtEstadoEps.setText(this.rs.getString("Estado"));
                    this.JLB_EstadoDian.setText(this.rs.getString("estadoEnvioDian"));
                    this.JLB_MensajeDian.setText(this.rs.getString("mensajeEnvioDian"));
                    this.btnGrabar.setEnabled(false);
                } else {
                    this.idFactura = this.rs.getString("idFactura");
                    this.txtNoPaciente.setText(this.rs.getString("No_Factura"));
                    this.txtFechaPaciente.setText(this.rs.getDate("Fecha_Factura").toString());
                    this.txtEstadoPaciente.setText(this.rs.getString("Estado"));
                    this.JLB_EstadoDian.setText(this.rs.getString("estadoEnvioDian"));
                    this.JLB_MensajeDian.setText(this.rs.getString("mensajeEnvioDian"));
                    this.btnGrabar.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void mBuscar_Recibo_Caja() {
        String xsql;
        try {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                xsql = "SELECT `k_recibos_n`.`VDescuento` , `k_recibos_n`.`Valor` , `k_conceptos`.`Nbre` AS `NConcepto` , `k_formapago`.`Nbre` AS `NFPago` , `k_recibos_n`.`NTransaccion` , `k_recibos_n`.`NoRecibo`, k_recibos_n.`Id` FROM  `k_recibos_n` INNER JOIN `k_formapago`  ON (`k_recibos_n`.`Id_FPago` = `k_formapago`.`Id`) INNER JOIN `k_itemrecibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos_n`.`Id`) INNER JOIN `k_conceptos`  ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`) WHERE (`k_recibos_n`.`Id_Liquidacion` ='" + getNoLiquidacion() + "' AND `k_recibos_n`.`Estado` =1) ";
            } else {
                xsql = "SELECT  `k_recibos`.`Descuento` , (`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`) AS `Valor` , `k_conceptos`.`Nbre` , `k_formapago`.`Nbre` , `k_recibos`.`NTransaccion` , `k_recibos`.`NoRecibo`, k_recibos.`Id` FROM  `k_formapago` INNER JOIN `k_recibos`  ON (`k_formapago`.`Id` = `k_recibos`.`Id_FPago`) INNER JOIN `k_itemrecibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_conceptos`  ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`) WHERE (`k_recibos`.`Id_Ingreso` ='" + getIdIngreso() + "') ";
            }
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFF_Descuento.setValue(Double.valueOf(xrs.getDouble(1)));
                this.JTFF_TotalRecibo.setValue(Double.valueOf(xrs.getDouble(2)));
                this.JCBFPago.setSelectedItem(xrs.getString(4));
                this.JTFNTransaccion.setText(xrs.getString(5));
                this.JTF_NoRecibo.setText(xrs.getString(6));
                this.xIdrecibo = xrs.getString(7);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String grabarLiquidacion() {
        String conv = "SELECT\n  `f_tipoplan`.`Nbre`\nFROM\n  `f_empresacontxconvenio`\n  INNER JOIN `f_tipoplan`\n    ON (\n      `f_empresacontxconvenio`.`Id_TipoPlan` = `f_tipoplan`.`Id`\n    )\nWHERE `f_empresacontxconvenio`.`Nbre` = '" + this.empresa + "'";
        ResultSet xrs1 = this.consultas.traerRs(conv);
        String result = "";
        try {
            if (xrs1.next()) {
                xrs1.first();
                result = xrs1.getString("f_tipoplan.Nbre");
                System.out.println("tipo de convenio -> " + result);
            }
            xrs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
            System.out.println("error");
        }
        if (result.equals("Particular")) {
            System.out.println("particular");
            this.sql = "INSERT INTO f_liquidacion(Id_Ingreso, TotalServicio,TotalPlan, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, Observacion, NEquipo, DireccionIp, Id_UsuarioRH, IdFormaPago,   Fecha, UsuarioS) VALUES (" + this.frmFacturac.frmIngreso.getIdIngreso() + "," + this.txtTotalServicio.getValue().toString() + "," + this.txtCubierto.getValue().toString() + ",0," + this.txtTotalDescuento.getValue().toString() + "," + this.txtTotalpaciente.getValue().toString() + "," + this.txtCuotaM.getValue().toString() + "," + this.txtCopago.getValue().toString() + "," + this.cboSubGrupo.getPopupTable().getValueAt(this.cboSubGrupo.getSelectedIndex(), 0) + ",'" + this.frmFacturac.frmIngreso.getIdEmpresa() + "','" + this.txtObservacion.getText() + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        } else {
            System.out.println("no particular");
            this.sql = "INSERT INTO f_liquidacion(Id_Ingreso, TotalServicio,TotalPlan, TotalEps, TotalDescuento,  CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, Observacion, NEquipo, DireccionIp, Id_UsuarioRH, IdFormaPago,   Fecha, UsuarioS) VALUES (" + this.frmFacturac.frmIngreso.getIdIngreso() + "," + this.txtTotalServicio.getValue().toString() + "," + this.txtCubierto.getValue().toString() + "," + this.txtTotalEps.getValue().toString() + "," + this.txtTotalDescuento.getValue().toString() + "," + this.txtCuotaM.getValue().toString() + "," + this.txtCopago.getValue().toString() + "," + this.cboSubGrupo.getPopupTable().getValueAt(this.cboSubGrupo.getSelectedIndex(), 0) + ",'" + this.frmFacturac.frmIngreso.getIdEmpresa() + "','" + this.txtObservacion.getText() + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        }
        this.metodos.getInterceptor(Long.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()), "GRABADO DE LIQUIDACIÓN", "Se graba liqudiación", false);
        return this.consultas.ejecutarSQLId(this.sql);
    }

    private String grabarLiquidacion1() {
        System.out.println("entra a grabar liquidadcion 1");
        this.sql = "INSERT INTO f_liquidacion(Id_Ingreso, TotalServicio,TotalPlan, TotalEps, TotalDescuento, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Id_UsuarioRH,  Fecha, UsuarioS) VALUES (" + this.frmFacturac.frmIngreso.getIdIngreso() + "," + this.txtTotalServicio.getValue().toString() + "," + this.txtCubierto.getValue().toString() + "," + this.txtTotalEps.getValue().toString() + "," + this.txtTotalDescuento.getValue().toString() + "," + this.txtTotalpaciente.getValue().toString() + "," + this.txtCuotaM.getValue().toString() + "," + this.txtCopago.getValue().toString() + ",4,'" + this.frmFacturac.frmIngreso.getIdEmpresa() + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.metodos.getInterceptor(Long.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()), "GRABADO DE LIQUIDACIÓN", "Se graba liqudiación", false);
        return this.consultas.ejecutarSQLId(this.sql);
    }

    public void grabarReciboCaja(String NoFactura, String xliquidacion) {
        if (Double.valueOf(this.JTFF_TotalRecibo.getText()).doubleValue() != 0.0d) {
            this.JTF_NoRecibo.setText(this.frmFacturac.clasecaja.getUltimoNoRecibo());
            this.idRecibo = grabarRecibo(NoFactura);
            grabarDetalle(this.idRecibo);
            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                grabarFormaPago(this.idRecibo);
            }
            this.JTF_NoRecibo.setText(this.frmFacturac.clasecaja.setActualizarNoRecibo());
            this.frmFacturac.clasecaja.imprimirRecibo(String.valueOf(this.idRecibo), String.valueOf(this.JTFF_TotalRecibo.getValue().toString()).substring(0, this.JTFF_TotalRecibo.getValue().toString().length() - 2), "0", this.frmFacturac);
        }
    }

    private String grabarRecibo(String NoFactura) {
        int xtipof;
        if (this.esCapitado == 2) {
            xtipof = 1;
        } else {
            xtipof = 0;
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.sql = "insert into k_recibos_n (`Id_Caja`, `Id_Persona`, `Id_EmpresaContxConv`, `FechaR`, `NoRecibo`, `Id_FPago`, `NTransaccion`, `VDescuento`, `Valor`, `Observacion`,  `Id_Liquidacion`, `Id_Tercero`,`UsuarioS`, `Id_UsuarioS`) values('" + this.frmFacturac.clasecaja.getIdCaja() + "','" + this.frmFacturac.frmPersona.getIdPersona() + "','" + this.idEmpresa + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmFacturac.clasecaja.getUltimoNoRecibo() + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','" + this.JTFNTransaccion.getText() + "','" + this.JTFF_Descuento.getValue() + "','" + this.JTFF_TotalRecibo.getValue() + "','" + this.txtObservacion.getText() + "','" + this.noLiquidacion + "','" + mConsultar_IdTercero() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
        } else {
            this.sql = "INSERT INTO k_recibos (Id_Caja, NoRecibo, Id_FPago, Fecha_Recibo, Tipo, NoFactura, Id_Profesional, Id_CentroCosto, Descuento, Observacion, Id_EmpresaContxConv, Id_TipoDocumento, Id_Paciente, Identificacion, Nbre_Paciente, Id_Ingreso, NTransaccion, Fecha, `Id_UsuarioS`, UsuarioS) VALUES ('" + this.frmFacturac.clasecaja.getIdCaja() + "','" + this.frmFacturac.clasecaja.getUltimoNoRecibo() + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + xtipof + "','" + NoFactura + "','" + this.frmFacturac.frmIngreso.getIdProfesional() + "','" + this.JCB_CCosto.getPopupTable().getValueAt(this.JCB_CCosto.getSelectedIndex(), 0) + "','" + this.JTFF_Descuento.getValue() + "','" + this.txtObservacion.getText() + "','" + this.idEmpresa + "','" + this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "','" + this.frmFacturac.frmPersona.getIdPersona() + "','" + this.frmFacturac.frmPersona.getIdentificacion() + "','" + this.frmFacturac.frmPersona.getApellido1() + " " + this.frmFacturac.frmPersona.getApellido2() + " " + this.frmFacturac.frmPersona.getNombre1() + " " + this.frmFacturac.frmPersona.getNombre2() + "','" + this.frmFacturac.frmIngreso.getIdIngreso() + "','" + this.JTFNTransaccion.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.metodos.getInterceptor(Long.valueOf(this.frmFacturac.frmIngreso.getIdIngreso()), "GRABAR RECIBO CAJA", "Se graba recibo de caja", false);
        }
        this.idRecibo = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        return this.idRecibo;
    }

    private String mConsultar_IdTercero() {
        String xid = "0";
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.sql = "SELECT  `Id` FROM `g_empresa` WHERE (`Id_TipoIdentificacion` ='" + this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "' AND `No_identificacion` ='" + this.frmFacturac.frmPersona.txtIdentificacion.getText() + "') ";
            ResultSet xrs = xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                xid = xrs.getString(1);
            } else {
                this.sql = "insert into g_empresa (    `Apellido1` , `Apellido2` , `Nombre1` , `Nombre2` , `Id_TipoIdentificacion` , `No_identificacion` ,`Dig_Verificacion`, `Id_Municipio` , `Direccion` , `Tel_Numero` , `FacTInterna` , `Fecha` , `UsuarioS` )values('" + this.frmFacturac.frmPersona.txtApellido1.getText() + "','" + this.frmFacturac.frmPersona.txtApellido2.getText() + "','" + this.frmFacturac.frmPersona.txtNombre1.getText() + "','" + this.frmFacturac.frmPersona.txtNombre2.getText() + "','" + this.frmFacturac.frmPersona.listaTipoIdentificacion[this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "','" + this.frmFacturac.frmPersona.txtIdentificacion.getText() + "','','" + this.frmFacturac.frmPersona.listaMunicipio[this.frmFacturac.frmPersona.cboMunicipio.getSelectedIndex()] + "','" + this.frmFacturac.frmPersona.txtDireccion.getText() + "','" + this.frmFacturac.frmPersona.txtTelefono.getText() + "','1','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                xid = xct.ejecutarSQLId(this.sql);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xid;
    }

    private void grabarDetalle(String idRecibo) {
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.sql = "INSERT INTO k_itemrecibos (Id_Recibo, Id_Concepto, Cantidad, VrUnitario) VALUES ('" + idRecibo + "','" + this.xId_Concepto[this.JCBConcepto_C.getSelectedIndex()][0] + "','1','" + (Double.valueOf(this.JTFF_TotalRecibo.getValue().toString()).doubleValue() + Double.valueOf(this.JTFF_Descuento.getValue().toString()).doubleValue()) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        } else {
            this.sql = "INSERT INTO k_itemrecibos (Id_Recibo, Id_Concepto, Cantidad, VrUnitario) VALUES ('" + idRecibo + "','" + this.xId_Concepto[this.JCBConcepto_C.getSelectedIndex()][0] + "','1','" + (Double.valueOf(this.JTFF_TotalRecibo.getValue().toString()).doubleValue() + Double.valueOf(this.JTFF_Descuento.getValue().toString()).doubleValue()) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void grabarFormaPago(String idRecibo) {
        this.sql = "INSERT INTO k_itemformapago (Id_Recibo, Id_FormaPago, Id_Banco, NoDocumento, Valor) VALUES ('" + idRecibo + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','1','0','" + this.JTFF_TotalRecibo.getValue() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void totalizar() {
        try {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.sql = "SELECT SUM(`f_ordenes`.`TotalOrdenes`) AS `VrServicio` , SUM(`f_ordenes`.`TotalEPS`) AS `VEps` , SUM(`f_ordenes`.`TotalDescuento`) AS `VrDescuento` , SUM(`f_ordenes`.`TotalPaciente`) AS `VrNoCubierto`  , round(IF(ingreso.`SiCopago`=1,IF(`f_estratoxemprcontconv`.`TopeAtencion`=0,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),  IF(((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)<`f_estratoxemprcontconv`.`TopeAtencion`,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),`f_estratoxemprcontconv`.`TopeAtencion` ) ) ,`f_estratoxemprcontconv`.`ValorMaximo`  ),-2) AS CuotaCopago, round(IF(ingreso.`SiCopago`=1,IF(`f_estratoxemprcontconv`.`TopeAtencion`=0,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),  IF(((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)<`f_estratoxemprcontconv`.`TopeAtencion`,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),`f_estratoxemprcontconv`.`TopeAtencion` ) ) ,`f_estratoxemprcontconv`.`ValorMaximo`  ),-2) VCopagoRe  FROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `ingreso`.`Id_Estrato`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) WHERE (`ingreso`.`Id` ='" + this.frmFacturac.frmIngreso.getIdIngreso() + "' AND `f_ordenes`.`Estado` =0)  GROUP BY `ingreso`.`Id` ";
            } else {
                this.sql = "SELECT SUM(`f_ordenes`.`TotalOrdenes`) AS `VrServicio` , SUM(`f_ordenes`.`TotalEPS`) AS `VEps` , SUM(`f_ordenes`.`TotalDescuento`) AS `VrDescuento` , SUM(`f_ordenes`.`TotalPaciente`) AS `VrNoCubierto`  , IF(f_estratoxemprcontconv.`Descontable`=1, 0,IF(ingreso.`SiCopago`=1,IF(`f_estratoxemprcontconv`.`TopeAtencion`=0,IF(`f_estratoxemprcontconv`.`PorcSubsidio`=0,0, ((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)),  IF(((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)<`f_estratoxemprcontconv`.`TopeAtencion`,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),`f_estratoxemprcontconv`.`TopeAtencion` ) ) ,`f_estratoxemprcontconv`.`ValorMaximo`  )) AS CuotaCopago, IF(ingreso.`SiCopago`=1,IF(`f_estratoxemprcontconv`.`TopeAtencion`=0,IF(`f_estratoxemprcontconv`.`PorcSubsidio`=0,0, ((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)),  IF(((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100)<`f_estratoxemprcontconv`.`TopeAtencion`,((SUM(`f_ordenes`.`TotalEPS`)*(100-`f_estratoxemprcontconv`.`PorcSubsidio`) )/100),`f_estratoxemprcontconv`.`TopeAtencion` ) ) ,`f_estratoxemprcontconv`.`ValorMaximo`  ) VCopagoRe  FROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `ingreso`.`Id_Estrato`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) WHERE (`ingreso`.`Id` ='" + this.frmFacturac.frmIngreso.getIdIngreso() + "' AND `f_ordenes`.`Estado` =0)  GROUP BY `ingreso`.`Id` ";
            }
            System.out.println("totalizar Ordenes-->" + this.sql);
            ResultSet xrs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    System.out.println("entra");
                    xrs.first();
                    this.txtTotalServicio.setValue(Double.valueOf(xrs.getDouble("VrServicio")));
                    this.txtCubierto.setValue(Double.valueOf(xrs.getDouble("VEps")));
                    this.txtTotalNoCubierto.setValue(Double.valueOf(xrs.getDouble("VrNoCubierto")));
                    this.txtTotalDescuento.setValue(Double.valueOf(xrs.getDouble("VrDescuento")));
                    if (this.frmFacturac.frmIngreso.xcopago == 0) {
                        this.txtCuotaM.setValue(Double.valueOf(xrs.getDouble("CuotaCopago")));
                        this.txtCopago.setValue(new Long(0L));
                    } else {
                        this.txtCopago.setValue(Double.valueOf(xrs.getDouble("CuotaCopago")));
                        this.txtCuotaM.setValue(new Long(0L));
                    }
                    this.txtTotalEps.setValue(Double.valueOf(xrs.getDouble("VEps") - xrs.getDouble("CuotaCopago")));
                    this.txtTotalpaciente.setValue(Double.valueOf(xrs.getDouble("VrNoCubierto")));
                    if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                        this.JTFF_TotalRecibo.setValue(Double.valueOf(xrs.getDouble("VCopagoRe")));
                    }
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
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void validarClaveCaja() {
        if (!this.metodos.getEncryptedPassword(new String(this.txtClave.getPassword())).equals(this.clave)) {
            this.metodos.mostrarMensaje("La Clave no es correcta");
            this.txtLogin.requestFocus();
        } else {
            this.JTFF_Descuento.setEnabled(true);
        }
    }

    private void calcularTotalRecibo() {
        if (Double.parseDouble(this.JTFF_Descuento.getValue().toString()) > Double.parseDouble(this.txtTotalpaciente.getValue().toString())) {
            this.JTFF_TotalRecibo.setValue(Double.valueOf(Double.parseDouble(this.txtTotalpaciente.getValue().toString()) - Double.parseDouble(this.JTFF_Descuento.getValue().toString())));
            this.JTFF_Descuento.requestFocus();
            this.btnGrabar.setEnabled(false);
        } else {
            if (this.txtTotalpaciente.getValue().toString().equals("0.0") && this.JTFF_Descuento.getValue().toString().equals("0")) {
                this.JTFF_TotalRecibo.setValue(Double.valueOf(Double.parseDouble(this.txtCuotaM.getValue().toString())));
                return;
            }
            this.JTFF_TotalRecibo.setValue(Double.valueOf(Double.parseDouble(this.txtTotalpaciente.getValue().toString()) - Double.parseDouble(this.JTFF_Descuento.getValue().toString())));
            this.JTFF_Descuento.setEnabled(false);
            if (this.txtNoEps.getText().isEmpty() && this.txtNoPaciente.getText().isEmpty()) {
                this.btnGrabar.setEnabled(true);
            }
            this.btnGrabar.requestFocus();
        }
    }

    private void validarUsuarioCaja() {
        this.sql = "SELECT w_persona.NUsuario, g_usuario_sist.Clave FROM w_persona INNER JOIN g_usuario_sist ON (w_persona.Id_persona = g_usuario_sist.Id_Persona) WHERE (g_usuario_sist.Login ='" + this.txtLogin.getText() + "' AND g_usuario_sist.Estado =0 AND g_usuario_sist.Descuento =1)";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.txtNbreAutoriza.setText(this.rs.getString(1));
                this.clave = this.rs.getString(2);
            } else {
                this.metodos.mostrarMensaje("El Usuario no se encontró o no tiene permisos de asignar Descuentos");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRealizar_Mov_Contable() {
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            try {
                this.sql = "SELECT `Id`  FROM `g_empresa` WHERE (`Id_TipoIdentificacion` ='" + this.frmFacturac.frmPersona.cboTipoIdentificacion.getSelectedItem() + "' AND `No_identificacion` ='" + this.frmFacturac.frmPersona.getIdentificacion() + "') ";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(this.sql);
                if (xrs.next()) {
                    xrs.first();
                    xrs.getString(1);
                } else {
                    this.sql = "INSERT IGNORE INTO `g_empresa`(`Apellido1`, `Apellido2`, `Nombre1`, `Nombre2`, `Nbre`, `Id_TipoIdentificacion`, `No_identificacion`,`Dig_Verificacion`, `Id_Municipio` , `Direccion` , `Tel_Numero` , `Correo` , `Id_ClasificacionT`) SELECT  `Apellido1` , `Apellido2` , `Nombre1` , `Nombre2` , `NUsuario` , `Id_TipoIdentificacion` , `NoDocumento` ,'' , `CodNMunicipio` , `Direccion` , `Telefono` , `Corre`, 1 FROM `persona` WHERE (`Id_TipoIdentificacion` ='CC' AND `NoDocumento` ='98653493') ";
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    xct2.ejecutarSQLId(this.sql);
                    xct2.cerrarConexionBd();
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.btnSalir = new JButton();
        this.btnGrabar = new JButton();
        this.btnGrabar1 = new JButton();
        this.btnImprimir = new JButton();
        this.btnAnular = new JButton();
        this.jPanel4 = new JPanel();
        try {
            this.cboGrupo = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboSubGrupo = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.jPanel2 = new JPanel();
        this.btnEps = new JRadioButton();
        this.btnPaciente = new JRadioButton();
        this.btnAmbos = new JRadioButton();
        this.txtNoEps = new JTextField();
        this.txtNoPaciente = new JTextField();
        this.txtFechaPaciente = new JTextField();
        this.txtEstadoEps = new JTextField();
        this.txtEstadoPaciente = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.txtObservacion = new JTextArea();
        this.JTPDATOS = new JTabbedPane();
        this.JPIDTotales = new JPanel();
        this.txtTotalServicio = new JFormattedTextField();
        this.txtTotalNoCubierto = new JFormattedTextField();
        this.txtCubierto = new JFormattedTextField();
        this.txtTotalEps = new JFormattedTextField();
        this.txtTotalDescuento = new JFormattedTextField();
        this.txtCuotaM = new JFormattedTextField();
        this.txtCopago = new JFormattedTextField();
        this.txtTotalpaciente = new JFormattedTextField();
        this.JCBTipoDocC = new JComboBox();
        this.JCBFPago = new JComboBox();
        this.JCBPeriodoC = new JComboBox();
        this.JTF_NoDocContable = new JTextField();
        this.JCBMedioDePago = new JComboBox<>();
        this.btnGrabarFactura = new JButton();
        this.txtNoFactura = new JTextField();
        this.JPIDCaja = new JPanel();
        try {
            this.JCB_CCosto = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        this.JPI_ADescuento = new JPanel();
        this.txtNbreAutoriza = new JTextField();
        this.txtLogin = new JTextField();
        this.txtClave = new JPasswordField();
        this.JTFF_Descuento = new JFormattedTextField();
        this.JTFF_TotalRecibo = new JFormattedTextField();
        this.JTF_NoRecibo = new JTextField();
        this.JTFNTransaccion = new JTextField();
        this.JCHAplicaCobro = new JCheckBox();
        this.JCBConcepto_C = new JComboBox();
        this.JPIDSoportesEscaneados = new JPanel();
        this.jPanel1 = new JPanel();
        this.JLB_MensajeDian = new JLabel();
        this.JLB_EstadoDian = new JLabel();
        this.JBT_EnvioDian = new JButton();
        this.JDCFecha = new JDateChooser();
        setDefaultCloseOperation(2);
        setTitle("CONSOLIDADO DE SERVICIOS");
        setMinimumSize(null);
        setResizable(false);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.1
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.2
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnGrabarActionPerformed(evt);
            }
        });
        this.btnGrabar1.setFont(new Font("Arial", 1, 12));
        this.btnGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/procedimientos.png")));
        this.btnGrabar1.setText("Datos SO");
        this.btnGrabar1.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.3
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnGrabar1ActionPerformed(evt);
            }
        });
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setText("Imprimir");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.4
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnImprimirActionPerformed(evt);
            }
        });
        this.btnAnular.setFont(new Font("Arial", 1, 12));
        this.btnAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.btnAnular.setText("Anular");
        this.btnAnular.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.5
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnAnularActionPerformed(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel4.setForeground(new Color(0, 103, 0));
        this.cboGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo del Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboGrupo.setFont(new Font("Arial", 1, 12));
        this.cboGrupo.addItemListener(new ItemListener() { // from class: Facturacion.Consolidado.6
            public void itemStateChanged(ItemEvent evt) {
                Consolidado.this.cboGrupoItemStateChanged(evt);
            }
        });
        this.cboSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo del Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboSubGrupo.setFont(new Font("Arial", 1, 12));
        this.cboSubGrupo.addItemListener(new ItemListener() { // from class: Facturacion.Consolidado.7
            public void itemStateChanged(ItemEvent evt) {
                Consolidado.this.cboSubGrupoItemStateChanged(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generar Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.btnEps);
        this.btnEps.setFont(new Font("Arial", 1, 12));
        this.btnEps.setSelected(true);
        this.btnEps.setText("EPS o Empresa Contratante");
        this.btnEps.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.8
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnEpsActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnPaciente);
        this.btnPaciente.setFont(new Font("Arial", 1, 12));
        this.btnPaciente.setText("Paciente");
        this.btnPaciente.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.9
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnPacienteActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnAmbos);
        this.btnAmbos.setFont(new Font("Arial", 1, 12));
        this.btnAmbos.setText("EPS y Paciente");
        this.btnAmbos.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.10
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnAmbosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnEps, -2, 185, -2).addComponent(this.btnPaciente, -2, 130, -2).addComponent(this.btnAmbos, -2, 140, -2)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.btnEps).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnPaciente, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAmbos, -2, 30, -2).addContainerGap()));
        this.txtNoEps.setEditable(false);
        this.txtNoEps.setFont(new Font("Arial", 1, 18));
        this.txtNoEps.setHorizontalAlignment(0);
        this.txtNoEps.setToolTipText("N° Orden o Factura Empresa");
        this.txtNoEps.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden / F. Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoPaciente.setEditable(false);
        this.txtNoPaciente.setFont(new Font("Arial", 1, 18));
        this.txtNoPaciente.setHorizontalAlignment(0);
        this.txtNoPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden / F. Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaPaciente.setEditable(false);
        this.txtFechaPaciente.setFont(new Font("Arial", 1, 24));
        this.txtFechaPaciente.setHorizontalAlignment(0);
        this.txtFechaPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtEstadoEps.setEditable(false);
        this.txtEstadoEps.setFont(new Font("Arial", 1, 18));
        this.txtEstadoEps.setHorizontalAlignment(0);
        this.txtEstadoEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtEstadoPaciente.setEditable(false);
        this.txtEstadoPaciente.setFont(new Font("Arial", 1, 18));
        this.txtEstadoPaciente.setHorizontalAlignment(0);
        this.txtEstadoPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setFont(new Font("Arial", 1, 12));
        this.txtObservacion.setColumns(20);
        this.txtObservacion.setFont(new Font("Arial", 1, 12));
        this.txtObservacion.setRows(1);
        this.txtObservacion.setTabSize(1);
        this.jScrollPane3.setViewportView(this.txtObservacion);
        this.JTPDATOS.setForeground(Color.red);
        this.JTPDATOS.setFont(new Font("Arial", 1, 14));
        this.JTPDATOS.addChangeListener(new ChangeListener() { // from class: Facturacion.Consolidado.11
            public void stateChanged(ChangeEvent evt) {
                Consolidado.this.JTPDATOSStateChanged(evt);
            }
        });
        this.JTPDATOS.addMouseListener(new MouseAdapter() { // from class: Facturacion.Consolidado.12
            public void mouseClicked(MouseEvent evt) {
                Consolidado.this.JTPDATOSMouseClicked(evt);
            }
        });
        this.txtTotalServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalServicio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalServicio.setHorizontalAlignment(4);
        this.txtTotalServicio.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalServicio.setEnabled(false);
        this.txtTotalServicio.setFont(new Font("Arial", 1, 18));
        this.txtTotalServicio.setValue(0);
        this.txtTotalNoCubierto.setBorder(BorderFactory.createTitledBorder((Border) null, "V/No Cubierto Por Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTotalNoCubierto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalNoCubierto.setHorizontalAlignment(4);
        this.txtTotalNoCubierto.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalNoCubierto.setEnabled(false);
        this.txtTotalNoCubierto.setFont(new Font("Arial", 1, 18));
        this.txtTotalNoCubierto.setValue(0);
        this.txtCubierto.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Cubierto Por Plan", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCubierto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCubierto.setHorizontalAlignment(4);
        this.txtCubierto.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCubierto.setEnabled(false);
        this.txtCubierto.setFont(new Font("Arial", 1, 18));
        this.txtCubierto.setValue(0);
        this.txtTotalEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Eps o Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalEps.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalEps.setHorizontalAlignment(4);
        this.txtTotalEps.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalEps.setEnabled(false);
        this.txtTotalEps.setFont(new Font("Arial", 1, 18));
        this.txtTotalEps.setValue(0);
        this.txtTotalDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalDescuento.setHorizontalAlignment(4);
        this.txtTotalDescuento.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalDescuento.setEnabled(false);
        this.txtTotalDescuento.setFont(new Font("Arial", 1, 18));
        this.txtTotalDescuento.setValue(0);
        this.txtTotalDescuento.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.13
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.txtTotalDescuentoActionPerformed(evt);
            }
        });
        this.txtTotalDescuento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Consolidado.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Consolidado.this.txtTotalDescuentoPropertyChange(evt);
            }
        });
        this.txtCuotaM.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Cuota Moderadora", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCuotaM.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCuotaM.setHorizontalAlignment(4);
        this.txtCuotaM.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCuotaM.setEnabled(false);
        this.txtCuotaM.setFont(new Font("Arial", 1, 18));
        this.txtCuotaM.setValue(0);
        this.txtCuotaM.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Consolidado.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Consolidado.this.txtCuotaMPropertyChange(evt);
            }
        });
        this.txtCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Copago", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCopago.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCopago.setHorizontalAlignment(4);
        this.txtCopago.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCopago.setEnabled(false);
        this.txtCopago.setFont(new Font("Arial", 1, 18));
        this.txtCopago.setValue(0);
        this.txtCopago.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Consolidado.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Consolidado.this.txtCopagoPropertyChange(evt);
            }
        });
        this.txtTotalpaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Paciente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalpaciente.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalpaciente.setHorizontalAlignment(4);
        this.txtTotalpaciente.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalpaciente.setEnabled(false);
        this.txtTotalpaciente.setFont(new Font("Arial", 1, 18));
        this.txtTotalpaciente.setValue(0);
        this.JCBTipoDocC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFPago.setFont(new Font("Arial", 1, 12));
        this.JCBFPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFPago.addItemListener(new ItemListener() { // from class: Facturacion.Consolidado.17
            public void itemStateChanged(ItemEvent evt) {
                Consolidado.this.JCBFPagoItemStateChanged(evt);
            }
        });
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NoDocContable.setEditable(false);
        this.JTF_NoDocContable.setFont(new Font("Arial", 1, 14));
        this.JTF_NoDocContable.setHorizontalAlignment(0);
        this.JTF_NoDocContable.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnGrabarFactura.setFont(new Font("Arial", 1, 12));
        this.btnGrabarFactura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.btnGrabarFactura.setText("Factura Paciente");
        this.btnGrabarFactura.setCursor(new Cursor(0));
        this.btnGrabarFactura.setEnabled(false);
        this.btnGrabarFactura.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.18
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.btnGrabarFacturaActionPerformed(evt);
            }
        });
        this.txtNoFactura.setEditable(false);
        this.txtNoFactura.setFont(new Font("Arial", 1, 18));
        this.txtNoFactura.setHorizontalAlignment(0);
        this.txtNoFactura.setToolTipText("N° Orden o Factura Empresa");
        this.txtNoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoFactura.setEnabled(false);
        GroupLayout JPIDTotalesLayout = new GroupLayout(this.JPIDTotales);
        this.JPIDTotales.setLayout(JPIDTotalesLayout);
        JPIDTotalesLayout.setHorizontalGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtTotalServicio, -2, 150, -2).addComponent(this.txtTotalDescuento, -2, 150, -2)).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.txtCuotaM, -2, 150, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDTotalesLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.txtTotalNoCubierto, -2, 150, -2))).addGap(18, 18, 18).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDTotalesLayout.createSequentialGroup().addComponent(this.txtCubierto, -2, 150, -2).addGap(35, 35, 35).addComponent(this.txtTotalEps, -2, 150, -2)).addGroup(JPIDTotalesLayout.createSequentialGroup().addComponent(this.txtCopago, -2, 150, -2).addGap(35, 35, 35).addComponent(this.txtTotalpaciente, -2, 150, -2)))).addGroup(JPIDTotalesLayout.createSequentialGroup().addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBFPago, -2, 175, -2).addComponent(this.JTF_NoDocContable, -2, 156, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocC, -2, 318, -2).addComponent(this.JCBMedioDePago, -2, 308, -2)).addGap(18, 18, 18).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addComponent(this.JCBPeriodoC, 0, 141, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGrabarFactura, -2, 165, -2)).addComponent(this.txtNoFactura)))).addContainerGap()));
        JPIDTotalesLayout.setVerticalGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTotalesLayout.createSequentialGroup().addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTotalServicio, -2, 50, -2).addComponent(this.txtTotalNoCubierto, -2, 50, -2).addComponent(this.txtCubierto, -2, 50, -2).addComponent(this.txtTotalEps, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTotalDescuento, -2, 50, -2).addComponent(this.txtCuotaM, -2, 50, -2).addComponent(this.txtCopago, -2, 50, -2).addComponent(this.txtTotalpaciente, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocC, -2, 50, -2).addComponent(this.JCBFPago, -2, 50, -2).addComponent(this.JCBPeriodoC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDTotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NoDocContable, -2, 47, -2).addComponent(this.JCBMedioDePago, -2, 50, -2).addComponent(this.txtNoFactura))).addGroup(JPIDTotalesLayout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.btnGrabarFactura, -2, 50, -2))).addContainerGap(9, 32767)));
        this.JTPDATOS.addTab("TOTALES", this.JPIDTotales);
        this.JCB_CCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_CCosto.setEnabled(false);
        this.JCB_CCosto.setFont(new Font("Arial", 1, 12));
        this.JPI_ADescuento.setBackground(new Color(0, 153, 153));
        this.JPI_ADescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizador del Descuento", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtNbreAutoriza.setFont(new Font("Arial", 1, 12));
        this.txtNbreAutoriza.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNbreAutoriza.setDisabledTextColor(new Color(102, 0, 102));
        this.txtNbreAutoriza.setEnabled(false);
        this.txtLogin.setFont(new Font("Arial", 1, 12));
        this.txtLogin.setBorder(BorderFactory.createTitledBorder((Border) null, "Login", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtLogin.setEnabled(false);
        this.txtLogin.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.19
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.txtLoginActionPerformed(evt);
            }
        });
        this.txtLogin.addFocusListener(new FocusAdapter() { // from class: Facturacion.Consolidado.20
            public void focusLost(FocusEvent evt) {
                Consolidado.this.txtLoginFocusLost(evt);
            }
        });
        this.txtClave.setFont(new Font("Arial", 1, 12));
        this.txtClave.setBorder(BorderFactory.createTitledBorder((Border) null, "Clave", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtClave.setEnabled(false);
        this.txtClave.addFocusListener(new FocusAdapter() { // from class: Facturacion.Consolidado.21
            public void focusLost(FocusEvent evt) {
                Consolidado.this.txtClaveFocusLost(evt);
            }
        });
        GroupLayout JPI_ADescuentoLayout = new GroupLayout(this.JPI_ADescuento);
        this.JPI_ADescuento.setLayout(JPI_ADescuentoLayout);
        JPI_ADescuentoLayout.setHorizontalGroup(JPI_ADescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ADescuentoLayout.createSequentialGroup().addContainerGap().addComponent(this.txtLogin, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtNbreAutoriza, -2, 336, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtClave, -2, 118, -2).addGap(23, 23, 23)));
        JPI_ADescuentoLayout.setVerticalGroup(JPI_ADescuentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ADescuentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNbreAutoriza, -2, 50, -2).addComponent(this.txtClave, -2, 50, -2).addComponent(this.txtLogin, -2, 50, -2)));
        this.JTFF_Descuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_Descuento.setForeground(new Color(153, 0, 0));
        this.JTFF_Descuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_Descuento.setHorizontalAlignment(4);
        this.JTFF_Descuento.setDisabledTextColor(new Color(255, 0, 0));
        this.JTFF_Descuento.setEnabled(false);
        this.JTFF_Descuento.setFont(new Font("Arial", 1, 18));
        this.JTFF_Descuento.setValue(0);
        this.JTFF_Descuento.addFocusListener(new FocusAdapter() { // from class: Facturacion.Consolidado.22
            public void focusGained(FocusEvent evt) {
                Consolidado.this.JTFF_DescuentoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Consolidado.this.JTFF_DescuentoFocusLost(evt);
            }
        });
        this.JTFF_TotalRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Pagar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_TotalRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JTFF_TotalRecibo.setHorizontalAlignment(4);
        this.JTFF_TotalRecibo.setDisabledTextColor(new Color(0, 51, 153));
        this.JTFF_TotalRecibo.setEnabled(false);
        this.JTFF_TotalRecibo.setFont(new Font("Arial", 1, 18));
        this.JTFF_TotalRecibo.setValue(0);
        this.JTFF_TotalRecibo.addFocusListener(new FocusAdapter() { // from class: Facturacion.Consolidado.23
            public void focusLost(FocusEvent evt) {
                Consolidado.this.JTFF_TotalReciboFocusLost(evt);
            }
        });
        this.JTFF_TotalRecibo.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.24
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.JTFF_TotalReciboActionPerformed(evt);
            }
        });
        this.JTF_NoRecibo.setEditable(false);
        this.JTF_NoRecibo.setFont(new Font("Arial", 1, 24));
        this.JTF_NoRecibo.setHorizontalAlignment(0);
        this.JTF_NoRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recibo", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 51, 102)));
        this.JTF_NoRecibo.setEnabled(false);
        this.JTFNTransaccion.setFont(new Font("Arial", 1, 12));
        this.JTFNTransaccion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Transacción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaCobro.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaCobro.setForeground(new Color(0, 103, 0));
        this.JCHAplicaCobro.setText("Aplica cobro?");
        this.JCBConcepto_C.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto_C.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto_C.setEnabled(false);
        this.JCBConcepto_C.addItemListener(new ItemListener() { // from class: Facturacion.Consolidado.25
            public void itemStateChanged(ItemEvent evt) {
                Consolidado.this.JCBConcepto_CItemStateChanged(evt);
            }
        });
        this.JCBConcepto_C.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.26
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.JCBConcepto_CActionPerformed(evt);
            }
        });
        GroupLayout JPIDCajaLayout = new GroupLayout(this.JPIDCaja);
        this.JPIDCaja.setLayout(JPIDCajaLayout);
        JPIDCajaLayout.setHorizontalGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createSequentialGroup().addComponent(this.JCHAplicaCobro).addGap(726, 726, 726)).addGroup(GroupLayout.Alignment.TRAILING, JPIDCajaLayout.createSequentialGroup().addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDCajaLayout.createSequentialGroup().addComponent(this.JTFF_Descuento, -2, 129, -2).addGap(27, 27, 27).addComponent(this.JTFF_TotalRecibo, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JCBConcepto_C, -2, 483, -2).addGap(0, 0, 32767)).addGroup(JPIDCajaLayout.createSequentialGroup().addComponent(this.JTFNTransaccion, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_CCosto, -2, 408, -2)).addGroup(JPIDCajaLayout.createSequentialGroup().addComponent(this.JPI_ADescuento, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTF_NoRecibo, -2, 156, -2))).addGap(23, 23, 23)))));
        JPIDCajaLayout.setVerticalGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCHAplicaCobro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_Descuento, -2, 50, -2).addComponent(this.JTFF_TotalRecibo, -2, 50, -2).addComponent(this.JCBConcepto_C, -2, 50, -2)).addGap(23, 23, 23).addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_CCosto, -2, 50, -2).addComponent(this.JTFNTransaccion, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_ADescuento, -2, -1, -2).addComponent(this.JTF_NoRecibo, -2, 71, -2)).addGap(29, 29, 29)));
        this.JTPDATOS.addTab("RECIBO DE CAJA", this.JPIDCaja);
        this.JPIDSoportesEscaneados.addMouseListener(new MouseAdapter() { // from class: Facturacion.Consolidado.27
            public void mouseClicked(MouseEvent evt) {
                Consolidado.this.JPIDSoportesEscaneadosMouseClicked(evt);
            }
        });
        GroupLayout JPIDSoportesEscaneadosLayout = new GroupLayout(this.JPIDSoportesEscaneados);
        this.JPIDSoportesEscaneados.setLayout(JPIDSoportesEscaneadosLayout);
        JPIDSoportesEscaneadosLayout.setHorizontalGroup(JPIDSoportesEscaneadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 845, 32767));
        JPIDSoportesEscaneadosLayout.setVerticalGroup(JPIDSoportesEscaneadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 263, 32767));
        this.JTPDATOS.addTab("SOPORTES ESCANEADOS", this.JPIDSoportesEscaneados);
        this.JLB_MensajeDian.setFont(new Font("Arial", 1, 12));
        this.JLB_MensajeDian.setForeground(Color.red);
        this.JLB_MensajeDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Mensaje Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JLB_EstadoDian.setFont(new Font("Arial", 1, 12));
        this.JLB_EstadoDian.setForeground(Color.red);
        this.JLB_EstadoDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Dian", 0, 0, new Font("Arial", 1, 12)));
        this.JBT_EnvioDian.setFont(new Font("Arial", 1, 12));
        this.JBT_EnvioDian.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_EnvioDian.setText("<html><P ALIGN=center>Enviar Factura Electronica(DIAN)");
        this.JBT_EnvioDian.setEnabled(false);
        this.JBT_EnvioDian.addActionListener(new ActionListener() { // from class: Facturacion.Consolidado.28
            public void actionPerformed(ActionEvent evt) {
                Consolidado.this.JBT_EnvioDianActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLB_MensajeDian, -2, 618, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_EstadoDian, -1, 178, 32767).addGap(39, 39, 39)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBT_EnvioDian, -2, 166, -2).addContainerGap(-1, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_MensajeDian, -2, 35, -2).addComponent(this.JLB_EstadoDian, -2, 35, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_EnvioDian, -2, 50, -2).addContainerGap(156, 32767)));
        this.JTPDATOS.addTab("DIAN", this.jPanel1);
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDATOS, -2, 847, -2).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNoPaciente, -2, 153, -2).addComponent(this.txtNoEps, -2, 153, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaPaciente, -2, 113, -2).addComponent(this.JDCFecha, -2, 110, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtEstadoPaciente, -2, 107, -2).addComponent(this.txtEstadoEps, -2, 107, -2)).addGap(10, 10, 10).addComponent(this.jScrollPane3, -2, 229, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.cboGrupo, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboSubGrupo, -2, 527, -2))).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtEstadoEps, -2, 55, -2).addComponent(this.JDCFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtEstadoPaciente, -2, 55, -2).addComponent(this.txtFechaPaciente, -2, 55, -2))).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 116, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel2, -2, 110, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.txtNoEps, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtNoPaciente, -2, 55, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboGrupo, -2, 50, -2).addComponent(this.cboSubGrupo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDATOS, -2, 290, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnGrabar, -2, 157, -2).addGap(18, 18, 18).addComponent(this.btnGrabar1, -2, 157, -2).addGap(18, 18, 18).addComponent(this.btnImprimir, -2, 157, -2).addGap(18, 18, 18).addComponent(this.btnAnular, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnSalir, -2, 157, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel4, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnGrabar, -2, 50, -2).addComponent(this.btnImprimir, -2, 50, -2).addComponent(this.btnAnular, -2, 50, -2).addComponent(this.btnGrabar1, -2, 50, -2).addComponent(this.btnSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEpsActionPerformed(ActionEvent evt) {
        setTipoFactura(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboGrupoItemStateChanged(ItemEvent evt) {
        if (this.cboGrupo.getSelectedIndex() > -1) {
            if (this.cboGrupo.getPopupTable().getValueAt(this.cboGrupo.getSelectedIndex(), 2).equals(0)) {
                cargarSubGrupo("1");
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    if (this.cboSubGrupo.getPopupTable().getRowCount() > 0) {
                        this.cboSubGrupo.setSelectedIndex(0);
                        return;
                    } else {
                        this.cboSubGrupo.setSelectedIndex(-1);
                        return;
                    }
                }
                if (this.cboSubGrupo.getPopupTable().getRowCount() == 1) {
                    this.cboSubGrupo.setSelectedIndex(0);
                    return;
                } else {
                    this.cboSubGrupo.setSelectedIndex(-1);
                    return;
                }
            }
            cargarSubGrupo("0");
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                if (this.cboSubGrupo.getPopupTable().getRowCount() > 0) {
                    this.cboSubGrupo.setSelectedIndex(0);
                    return;
                } else {
                    this.cboSubGrupo.setSelectedIndex(-1);
                    return;
                }
            }
            if (this.cboSubGrupo.getPopupTable().getRowCount() == 1) {
                this.cboSubGrupo.setSelectedIndex(0);
            } else {
                this.cboSubGrupo.setSelectedIndex(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginActionPerformed(ActionEvent evt) {
        this.txtClave.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginFocusLost(FocusEvent evt) {
        if (!this.txtLogin.getText().isEmpty()) {
            validarUsuarioCaja();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtClaveFocusLost(FocusEvent evt) {
        if (!this.txtClave.getText().isEmpty()) {
            validarClaveCaja();
            this.JTFF_Descuento.setEnabled(true);
            this.JTFF_Descuento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DescuentoFocusLost(FocusEvent evt) {
        this.JTFF_Descuento.setValue(Long.valueOf(Long.parseLong(this.JTFF_Descuento.getText().replaceAll("\\.", ""))));
        calcularTotalRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        if (!this.txtNoEps.getText().isEmpty() && this.JTF_NoRecibo.getText().isEmpty()) {
            imprimir();
        } else if (!this.txtNoEps.getText().isEmpty() || !this.JTF_NoRecibo.getText().isEmpty() || !this.txtNoPaciente.getText().isEmpty()) {
            Object[] botones = {"Orden/Factura", "Recibo Caja", "Cerrar"};
            Object n = JOptionPane.showInputDialog((Component) null, "Que desea visualizar?", "VISUALIZACIÓN", 0, (Icon) null, botones, "Cerrar");
            if (n.equals("Orden/Factura")) {
                imprimir();
            } else if (n.equals("Recibo Caja")) {
                this.frmFacturac.clasecaja.imprimirRecibo(this.xIdrecibo, String.valueOf(this.JTFF_TotalRecibo.getValue().toString()).substring(0, this.JTFF_TotalRecibo.getValue().toString().length() - 2), "0", this.frmFacturac);
            }
        } else if (!this.txtNoPaciente.getText().isEmpty() && this.JTF_NoRecibo.getText().isEmpty()) {
            imprimir();
        } else if (!this.txtNoPaciente.getText().isEmpty() && this.JTF_NoRecibo.getText().isEmpty()) {
            imprimir();
        } else {
            imprimir();
            this.frmFacturac.clasecaja.imprimirRecibo(this.xIdrecibo, String.valueOf(this.JTFF_TotalRecibo.getValue().toString()).substring(0, this.JTFF_TotalRecibo.getValue().toString().length() - 2), "0", this.frmFacturac);
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAnularActionPerformed(ActionEvent evt) {
        anular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPacienteActionPerformed(ActionEvent evt) {
        setTipoFactura(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAmbosActionPerformed(ActionEvent evt) {
        setTipoFactura(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DescuentoFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Facturacion.Consolidado.29
            @Override // java.lang.Runnable
            public void run() {
                Consolidado.this.JTFF_Descuento.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_TotalReciboActionPerformed(ActionEvent evt) {
        this.JTFF_TotalRecibo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_TotalReciboFocusLost(FocusEvent evt) {
        mValidarValorRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalDescuentoPropertyChange(PropertyChangeEvent evt) {
        actualizarDescuento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabar1ActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
            JDDatosOcupacionales_Nueva frmc1 = new JDDatosOcupacionales_Nueva(null, true);
            frmc1.setLocationRelativeTo(this.frmFacturac);
            frmc1.setVisible(true);
        } else {
            JDDatosOcupacionales frmc12 = new JDDatosOcupacionales(null, true);
            frmc12.setLocationRelativeTo(this.frmFacturac);
            frmc12.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFPagoItemStateChanged(ItemEvent evt) {
        if (this.xllenof && this.JCBFPago.getSelectedIndex() != -1) {
            if (this.xId_Fpago[this.JCBFPago.getSelectedIndex()][1].equals("1")) {
                this.JTFNTransaccion.setEnabled(true);
                this.JTFNTransaccion.requestFocus();
            } else {
                this.JTFNTransaccion.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConcepto_CItemStateChanged(ItemEvent evt) {
        if (this.xllenof && this.JCBConcepto_C.getSelectedIndex() != -1) {
            if (this.xId_Concepto[this.JCBConcepto_C.getSelectedIndex()][1].equals("1")) {
                calcularTotalRecibo();
                this.JTFF_TotalRecibo.setEnabled(true);
                this.JTFF_TotalRecibo.requestFocus();
            } else {
                calcularTotalRecibo();
                this.JTFF_TotalRecibo.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCuotaMPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc && this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][3].equals("1")) {
            mCambio_Copago_CModeradora();
            mActivarBotonGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCopagoPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc && this.frmFacturac.frmIngreso.xidestrato[this.frmFacturac.frmIngreso.cboEstrato1.getSelectedIndex()][3].equals("1")) {
            mCambio_Copago_CModeradora();
            mActivarBotonGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboSubGrupoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConcepto_CActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDATOSMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPIDSoportesEscaneadosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDATOSStateChanged(ChangeEvent evt) {
        if (this.JTPDATOS.getSelectedIndex() == 2 && !this.cambioTag) {
            this.frmSE = new JPIngresoDocumento(Long.valueOf(Long.parseLong(Principal.txtNo.getText().toString())));
            loadScannedMedia();
            this.cambioTag = true;
            if (!this.txtNoPaciente.getText().isEmpty()) {
                this.frmSE.btnGrabar.setVisible(true);
                this.frmSE.btnGrabar.setEnabled(true);
            }
            if (!this.txtNoPaciente.getText().isEmpty() || !this.txtNoEps.getText().isEmpty()) {
                this.btnGrabar.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EnvioDianActionPerformed(ActionEvent evt) {
        envioFacturaDian();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarFacturaActionPerformed(ActionEvent evt) {
        if (!this.txtNoFactura.equals("0")) {
            mFacturaEventoCopagoCuotaModeradora();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalDescuentoActionPerformed(ActionEvent evt) {
    }

    private void actualizarDescuento() {
        if (!Double.valueOf(this.txtTotalDescuento.getText()).equals(0)) {
            this.txtTotalpaciente.setValue(Double.valueOf(Double.valueOf(this.txtTotalServicio.getValue().toString()).doubleValue() - Double.valueOf(this.txtTotalDescuento.getValue().toString()).doubleValue()));
            this.txtCuotaM.setEnabled(false);
            this.txtCopago.setEnabled(false);
        }
    }

    private void mValidarValorRecibo() {
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") && Double.valueOf(this.JTFF_TotalRecibo.getValue().toString()).doubleValue() > Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue()) {
            JOptionPane.showMessageDialog(this, "El valor del recibo no puede ser mayor,\nal total a pagar por el usuario;\nFavor revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            calcularTotalRecibo();
        }
    }

    private void envioFacturaDian() {
        if (this.esCapitado == 2) {
            boolean formaEnvio = false;
            if (!this.JLB_EstadoDian.getText().equals("SUCCESS")) {
                formaEnvio = true;
            }
            if (Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900754259") || Principal.informacionIps.getIdentificacion().equals("812004304") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                GeneracionFacturaElectronica facturaElectronica = new GeneracionFacturaElectronica();
                List<com.genoma.plus.controller.gcuenta.Adjunto> adjuntos = new ArrayList<>();
                facturaElectronica.generacionFacturaEventoSalud(String.valueOf(this.idFactura), 0, Boolean.valueOf(formaEnvio), adjuntos);
                return;
            }
            this.xIFacturaElectronicaDAO.mGenerarFacturaElectronica(this.idFactura, 0, Boolean.valueOf(formaEnvio), this.adjunto);
        }
    }

    private void mVerificaCausaExterna() {
        if (this.frmFacturac.frmIngreso.cboCausaExterna.getPopupTable().getValueAt(this.frmFacturac.frmIngreso.cboCausaExterna.getSelectedIndex(), 0).equals("2")) {
            this.xJPEventoECat = new JPEventoECat(null, true, this.frmFacturac.frmPersona.IdPersona, Long.valueOf(this.frmFacturac.frmIngreso.cboCausaExterna.getPopupTable().getValueAt(this.frmFacturac.frmIngreso.cboCausaExterna.getSelectedIndex(), 0).toString()).longValue(), Long.valueOf(this.frmFacturac.frmIngreso.xidCondVict[this.frmFacturac.frmIngreso.JCBCondVict.getSelectedIndex()].toString()).longValue(), this.frmFacturac.frmIngreso.getIdIngreso());
            this.xJPEventoECat.setVisible(true);
        }
    }

    private String traerMedioPago() {
        String medioPago = null;
        System.out.println("medio de pago -> " + this.JCBMedioDePago.getSelectedItem());
        String xsql = "SELECT cuentaDebito FROM medio_pago WHERE nombre = '" + this.JCBMedioDePago.getSelectedItem() + "'";
        System.out.println("consulta -> " + xsql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                medioPago = xrs.getString("cuentaDebito");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
            System.out.println(">>>error<<<");
        }
        return medioPago;
    }

    private void anular() {
        if (mVerificarEstadoFactura()) {
            Anular frm = new Anular(null, true, "Consolidado", 5);
            frm.setVisible(true);
            refrescar();
            return;
        }
        JOptionPane.showMessageDialog(this, "N° orden y/o factura no se puede anular;\nEsta ya se encuentra armada y/o presentada", this.sql, this.esCapitado);
    }

    private boolean mVerificarEstadoFactura() {
        boolean xestado = false;
        try {
            if (this.esCapitado == 2) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                    this.sql = "SELECT No_FacturaEvento_M, Id_Liquidacion FROM f_factura_evento WHERE (EstaArmada =0 AND Id_Liquidacion =" + getNoLiquidacion() + ") ";
                } else {
                    this.sql = "SELECT No_FacturaEvento, Id_Liquidacion FROM f_factura_evento WHERE (EstaArmada =0 AND Id_Liquidacion =" + getNoLiquidacion() + ") ";
                }
            } else {
                this.sql = "SELECT No_FacturaCapita FROM f_factura_capita WHERE (Id_Liquidacion =" + getNoLiquidacion() + " AND EstaArmada =0) ";
            }
            ResultSet xrs = this.consultas.traerRs(this.sql);
            if (xrs.next()) {
                xestado = true;
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    public void AnularFacturayLiq(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        this.sql = "Update f_liquidacion set Estado=1  WHERE Id=" + getNoLiquidacion();
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        if (this.esCapitado == 2) {
            this.sql = "UPDATE f_factura_evento, f_liquidacion SET f_factura_evento.Estado =1 , Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_evento.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_evento.`Fecha_Anulacion`='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' , f_factura_evento.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_evento.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_liquidacion.Id =" + getNoLiquidacion() + ")";
        } else {
            this.sql = "UPDATE f_factura_capita, f_liquidacion SET f_factura_capita.Estado =1, Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_capita.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_capita.`Fecha_Anulacion`='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' , f_factura_capita.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_capita.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_liquidacion.Id =" + getNoLiquidacion() + ")";
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(Long.valueOf(this.idIngreso), "ANULACIÓN DE LIQUIDACIÓN", xObservacion, false);
        this.btnImprimir.setEnabled(false);
    }

    public String getNoLiquidacion() {
        return this.noLiquidacion;
    }

    public void setNoLiquidacion(String noLiquidacion) {
        this.noLiquidacion = noLiquidacion;
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.cboGrupo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Grupo del Servicio");
        } else if (this.cboSubGrupo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el SubGrupo del Servicio");
        } else if (this.JCBFPago.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione forma de pago");
            this.JCBFPago.requestFocus();
        } else if (this.JCBMedioDePago.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione medio de pago");
            this.JCBMedioDePago.requestFocus();
        } else if (this.frmFacturac.cajaAbierta == 0) {
            System.out.println("empresa -> " + this.empresa);
            String conv = "SELECT\n  `f_tipoplan`.`Nbre`\nFROM\n  `f_empresacontxconvenio`\n  INNER JOIN `f_tipoplan`\n    ON (\n      `f_empresacontxconvenio`.`Id_TipoPlan` = `f_tipoplan`.`Id`\n    )\nWHERE `f_empresacontxconvenio`.`Nbre` = '" + this.empresa + "'";
            ResultSet xrs1 = this.consultas.traerRs(conv);
            String result = "";
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    result = xrs1.getString("f_tipoplan.Nbre");
                    System.out.println("tipo de convenio -> " + result);
                }
                xrs1.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException e) {
                System.out.println("error");
            }
            System.out.println("cuota moderadora -> " + Double.valueOf(this.txtCuotaM.getValue().toString()));
            System.out.println("cuota moderadora -> " + Double.valueOf(this.txtTotalpaciente.getValue().toString()));
            if (Double.valueOf(this.txtTotalpaciente.getValue().toString()).doubleValue() != 0.0d) {
                System.out.println("--> ");
                if (this.JCB_CCosto.getSelectedIndex() < 0 && result.equals("Particular")) {
                    this.metodos.mostrarMensaje("Por favor seleccione el Centro de Costo");
                } else if (this.JCBConcepto_C.getSelectedIndex() < 0 && result.equals("Particular")) {
                    this.metodos.mostrarMensaje("Por favor seleccione el Concepto de Pago");
                } else if (Long.parseLong(this.JTFF_Descuento.getValue().toString()) > 0 && this.txtObservacion.getText().isEmpty()) {
                    this.metodos.mostrarMensaje("Por favor Digite una Observación sobre el Descuento Realizado");
                } else {
                    retorno = 1;
                }
            } else {
                retorno = 1;
            }
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private boolean mValidad_DCaja() {
        boolean xvalor = false;
        System.out.println("empresa -> " + this.empresa);
        String conv = "SELECT\n  `f_tipoplan`.`Nbre`\nFROM\n  `f_empresacontxconvenio`\n  INNER JOIN `f_tipoplan`\n    ON (\n      `f_empresacontxconvenio`.`Id_TipoPlan` = `f_tipoplan`.`Id`\n    )\nWHERE `f_empresacontxconvenio`.`Nbre` = '" + this.empresa + "'";
        ResultSet xrs1 = this.consultas.traerRs(conv);
        String result = "";
        try {
            if (xrs1.next()) {
                xrs1.first();
                result = xrs1.getString("f_tipoplan.Nbre");
                System.out.println("tipo de convenio -> " + result);
            }
            xrs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
            System.out.println("error");
        }
        System.out.println("----> " + this.JCBConcepto_C.getSelectedIndex());
        System.out.println("----> " + Double.valueOf(this.txtCuotaM.getValue().toString()));
        System.out.println("----> " + result);
        if (this.JCBConcepto_C.getSelectedIndex() == -1 && !result.equals("Particular") && Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue() == 0.0d) {
            if (this.JCB_CCosto.getSelectedIndex() == -1 && !result.equals("Particular") && Double.valueOf(this.txtCuotaM.getValue().toString()).doubleValue() == 0.0d) {
                xvalor = true;
                System.out.println("valor -> true");
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el centro de costo", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDATOS.setSelectedIndex(1);
                this.JCB_CCosto.requestFocus();
            }
        } else if (this.JCBConcepto_C.getSelectedIndex() != -1) {
            xvalor = true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el concepto de pago", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDATOS.setSelectedIndex(1);
            this.JCBConcepto_C.requestFocus();
        }
        return xvalor;
    }

    private boolean mValidadMovContable() {
        boolean xvalor = false;
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            if (this.JCBTipoDocC.getSelectedIndex() != -1) {
                if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                    xvalor = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDATOS.setSelectedIndex(0);
                    this.JCBPeriodoC.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento Contable", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDATOS.setSelectedIndex(0);
                this.JCBTipoDocC.requestFocus();
            }
        } else {
            xvalor = true;
        }
        return xvalor;
    }

    private void refrescar() {
        nuevo();
        cargarCombos();
        buscarLiquidacion(getIdIngreso());
        this.cboGrupo.setRequestFocusEnabled(true);
    }

    public String getIdIngreso() {
        return this.idIngreso;
    }

    public int getTipoFactura() {
        return this.tipoFactura;
    }

    public void setTipoFactura(int tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    private void loadScannedMedia() {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.frmSE.setVisible(true);
            this.JPIDSoportesEscaneados.setVisible(false);
            this.frmSE.setBounds(1, 1, 1190, 500);
            this.JPIDSoportesEscaneados.add(this.frmSE);
            this.JPIDSoportesEscaneados.setVisible(true);
            return;
        }
        System.out.println("No hay un ingreso seleccionado");
    }
}
