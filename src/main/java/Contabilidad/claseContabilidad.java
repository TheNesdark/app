package Contabilidad;

import Acceso.Principal;
import Activos.JIFDepreciacion;
import Activos.JIFGestionActivos;
import ComprasBS.JIFAutorizacionOrdenesCT;
import ComprasBS.JIFConsultarEstadoOc;
import General.AccesoModulos;
import Inventarios.JIFAuditoriasProductos;
import Inventarios.JIFInformeConsolidadoMov;
import Inventarios.JIFKardex;
import ParametrizacionN.JIFFEmpresa;
import ParametrizacionN.JIFFEmpresaBienestarSalud;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro;
import com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart;
import com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad;
import com.genoma.plus.controller.contabilidad.JIFInformesFinancieros;
import com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad;
import com.genoma.plus.controller.contabilidad.JIFPagoNominaC;
import com.genoma.plus.controller.contabilidad.JIFRevisionDocumentosDescuadrados;
import com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables;
import com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal;
import com.genoma.plus.controller.gcuenta.JIFInformesCartera2193;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.jpa.dto.EntradaRadicacionDTO;
import com.genoma.plus.jpa.projection.IGenericoDosValores;
import com.genoma.plus.jpa.service.IMCcFacturaInternaService;
import com.genoma.plus.jpa.service.impl.MCcFacturaInternaServiceImpl;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/claseContabilidad.class */
public class claseContabilidad {
    public Principal frmPrincipal;
    private String xsql;
    private IntegraFactura frmIntegraFact;
    public JIFRadicacion xjifradicacion;
    private JIFFEmpresa xjifempresa;
    private JIFFEmpresaBienestarSalud xjifempresabienestar;
    public JIFLiquidacionRad xjifcomprobante;
    private JIFAuditoriaPago xjifauditoriacp;
    private JIFPeriodoContables xjifperiodoc;
    public JIFDocContable xjifdoccontable;
    private JIFGeneracionPagos xjifgenerarpago;
    private JIFGeneracionPagos_Directo xjifgenerarpago1;
    private JIFGeneracionDisfon_v1 xjifgeneraciondisfon_v1;
    private JIFCargarSoporteLoteC xjifimportacions;
    private JIFRegistroRecibos xjifregistrorecibos;
    private JIFSolicitudReembolsoCM xjifsolicitudr;
    private JIFGenerarCuentaCobro xjifcuentacobro;
    public JIFGenerarCuentaCobroM xjifcuentacobrom;
    public JIFGenerarCuentaCobroMImpuestos cobroMImpuestos;
    private JIFConsultasInfC xjifconsultainf;
    private JIFPuc xjifpuc;
    private JIFAjusteDoc xjifajuste;
    private JIFRadicacionNC xjifradicacionnc;
    private JIFRegistroSReembolso xjifradicacionr;
    private JIFCargarGasto xjifcargargasto;
    private JIFExportarDatosTipoDoc xjifexportardatostipodoc;
    private String xfechaperiodoi;
    private String xfechaperiodof;
    private String nombrePeriodo;
    private JIFCEjecucionPpto xjifejecucionppt;
    private JIFConsultarNotaCreditoA xjifconsultarnc;
    private JIFAutorizacionOrdenesCT xjifautorizaciondocc;
    private JIFConsultarEstadoOc xjifconsultarestado;
    private Date xfechai;
    private Date xfechaf;
    private JIFEnviarDocTerceros xjifenviardoctercero;
    public JIFConfigurarCuentasPuc xjifconfcuentapuc;
    private JIFAutorizacionDoc xjifautorizaciondoc;
    private JIFInformesMov xjifinformesmov;
    private JIFConsultaInformesTerceros xjifconsinfproveedor;
    private JIFGenerarCertificadoI xjifcertificadosmanual;
    private JIFGenerarCetificadoA xjifcertificadosautomatico;
    private JIFConsultarDatosMDian xjifformatodian;
    private JIFConsultarInfPeriodos xjifinformeperiodos;
    private JIFConsultarBalance xjifbalancecontable;
    private JIFInformeConsolidadoMov xjifinformeconsmovimiento;
    private JIFConsultarCuentasxP xjifcuentaxpagar;
    private JIFConciliacionInventarios xjifconciliacioninventario;
    private JIFGestionActivos xjifgestionactivo;
    private JIFRegistroFacturas xjifregistrofact;
    private JIFModificarDocumentosC xjifmodificaciondocc;
    private JIFPucGastos xjifpucgastos;
    private JIFInformeC xjifinformesc;
    private JIFInformeC_PFecha xjifinformesc1;
    private JIFDepreciacion xjifdepreciacion;
    private JIFAuditoriasProductos xjifauditoria;
    private JIFCierre_Contable xjifcierrec;
    private JIFCierre_Contable_CGI xjifcierreccgi;
    private JIFKardex xjifkardex;
    private com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento xJIFConsultarMovimiento;
    private JIFBuscarDocumentosC xjibuscardocumento;
    private JIFConsultar_BalanceP xJIFConsultarBalanceN;
    private JIFEstadosFinanc_Comparativos xJIFEstadosFinan_Comparativos;
    private JIFConsultar_BalanceP_Fecha xJIFConsultarBalanceF;
    private JIFConsultar_LibroAuxiliar_Fecha xjif_libroauxiliar;
    private JIF_GestionTerceros xjifGestionTerceros;
    public JIFConsultarCuentaCobro xJIFConsultarCuentaCobro;
    private JIFConsultar_LibroAuxiliar_RangoCuenta xJIFConsultar_LibroAuxiliar_RangoCuenta;
    private JIFConsultar_LibroAuxiliar_Terceros xJIFConsultar_LibroAuxiliar_Terceros;
    private JIFConsultar_BGeneral xjifbalancegeneral;
    private JIFConsultarCuentasxPagarContaCart xJIFConsultarCuentasxPagarContaCart;
    private JIF_Consultar_Movimiento xjif_cmovimiento_tercero;
    private JIFInformesVariosContabilidad jIFInformesVariosContabilidad;
    private JIFInformesFinancieros jIFInformesFinancieros;
    private JIFInformesCartera2193 jIFInformesCartera2193;
    private JIFRevisionDocumentosDescuadrados jIFRevisionDocumentosDescuadrados;
    private JIF_AuditoriaFacturasContables auditoriaFacturasContables;
    private Integer requiereAuditoria;
    private JIFPagoNominaC jIfPagosNomaContabilidad;
    private WorkerSQL xWorkerSQL;
    private JIFGestionFacturasDianRecibidad facturasDianRecibidad;
    private JIF_Reportes_PyP_Generico jifreportes;
    private final IMCcFacturaInternaService facturaInternaService;
    private JIFConceptoCCobro xjifconceptoccobro;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xestadop = false;
    private int xidperiodoc = -1;
    private int xForma_Gn_Niif = 0;
    private double xvalor_uvt = 0.0d;

    @Generated
    public void setFrmPrincipal(Principal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }

    @Generated
    public void setXsql(String xsql) {
        this.xsql = xsql;
    }

    @Generated
    public void setXmetodos(Metodos xmetodos) {
        this.xmetodos = xmetodos;
    }

    @Generated
    public void setXconsultas(ConsultasMySQL xconsultas) {
        this.xconsultas = xconsultas;
    }

    @Generated
    public void setFrmIntegraFact(IntegraFactura frmIntegraFact) {
        this.frmIntegraFact = frmIntegraFact;
    }

    @Generated
    public void setXjifradicacion(JIFRadicacion xjifradicacion) {
        this.xjifradicacion = xjifradicacion;
    }

    @Generated
    public void setXjifempresa(JIFFEmpresa xjifempresa) {
        this.xjifempresa = xjifempresa;
    }

    @Generated
    public void setXjifempresabienestar(JIFFEmpresaBienestarSalud xjifempresabienestar) {
        this.xjifempresabienestar = xjifempresabienestar;
    }

    @Generated
    public void setXjifcomprobante(JIFLiquidacionRad xjifcomprobante) {
        this.xjifcomprobante = xjifcomprobante;
    }

    @Generated
    public void setXjifauditoriacp(JIFAuditoriaPago xjifauditoriacp) {
        this.xjifauditoriacp = xjifauditoriacp;
    }

    @Generated
    public void setXjifperiodoc(JIFPeriodoContables xjifperiodoc) {
        this.xjifperiodoc = xjifperiodoc;
    }

    @Generated
    public void setXjifdoccontable(JIFDocContable xjifdoccontable) {
        this.xjifdoccontable = xjifdoccontable;
    }

    @Generated
    public void setXjifgenerarpago(JIFGeneracionPagos xjifgenerarpago) {
        this.xjifgenerarpago = xjifgenerarpago;
    }

    @Generated
    public void setXjifgenerarpago1(JIFGeneracionPagos_Directo xjifgenerarpago1) {
        this.xjifgenerarpago1 = xjifgenerarpago1;
    }

    @Generated
    public void setXjifgeneraciondisfon_v1(JIFGeneracionDisfon_v1 xjifgeneraciondisfon_v1) {
        this.xjifgeneraciondisfon_v1 = xjifgeneraciondisfon_v1;
    }

    @Generated
    public void setXjifimportacions(JIFCargarSoporteLoteC xjifimportacions) {
        this.xjifimportacions = xjifimportacions;
    }

    @Generated
    public void setXjifregistrorecibos(JIFRegistroRecibos xjifregistrorecibos) {
        this.xjifregistrorecibos = xjifregistrorecibos;
    }

    @Generated
    public void setXjifsolicitudr(JIFSolicitudReembolsoCM xjifsolicitudr) {
        this.xjifsolicitudr = xjifsolicitudr;
    }

    @Generated
    public void setXjifcuentacobro(JIFGenerarCuentaCobro xjifcuentacobro) {
        this.xjifcuentacobro = xjifcuentacobro;
    }

    @Generated
    public void setXjifcuentacobrom(JIFGenerarCuentaCobroM xjifcuentacobrom) {
        this.xjifcuentacobrom = xjifcuentacobrom;
    }

    @Generated
    public void setCobroMImpuestos(JIFGenerarCuentaCobroMImpuestos cobroMImpuestos) {
        this.cobroMImpuestos = cobroMImpuestos;
    }

    @Generated
    public void setXjifconsultainf(JIFConsultasInfC xjifconsultainf) {
        this.xjifconsultainf = xjifconsultainf;
    }

    @Generated
    public void setXjifpuc(JIFPuc xjifpuc) {
        this.xjifpuc = xjifpuc;
    }

    @Generated
    public void setXjifajuste(JIFAjusteDoc xjifajuste) {
        this.xjifajuste = xjifajuste;
    }

    @Generated
    public void setXjifradicacionnc(JIFRadicacionNC xjifradicacionnc) {
        this.xjifradicacionnc = xjifradicacionnc;
    }

    @Generated
    public void setXjifradicacionr(JIFRegistroSReembolso xjifradicacionr) {
        this.xjifradicacionr = xjifradicacionr;
    }

    @Generated
    public void setXjifcargargasto(JIFCargarGasto xjifcargargasto) {
        this.xjifcargargasto = xjifcargargasto;
    }

    @Generated
    public void setXjifexportardatostipodoc(JIFExportarDatosTipoDoc xjifexportardatostipodoc) {
        this.xjifexportardatostipodoc = xjifexportardatostipodoc;
    }

    @Generated
    public void setXfechaperiodoi(String xfechaperiodoi) {
        this.xfechaperiodoi = xfechaperiodoi;
    }

    @Generated
    public void setXjifejecucionppt(JIFCEjecucionPpto xjifejecucionppt) {
        this.xjifejecucionppt = xjifejecucionppt;
    }

    @Generated
    public void setXjifconsultarnc(JIFConsultarNotaCreditoA xjifconsultarnc) {
        this.xjifconsultarnc = xjifconsultarnc;
    }

    @Generated
    public void setXjifautorizaciondocc(JIFAutorizacionOrdenesCT xjifautorizaciondocc) {
        this.xjifautorizaciondocc = xjifautorizaciondocc;
    }

    @Generated
    public void setXjifconsultarestado(JIFConsultarEstadoOc xjifconsultarestado) {
        this.xjifconsultarestado = xjifconsultarestado;
    }

    @Generated
    public void setXjifenviardoctercero(JIFEnviarDocTerceros xjifenviardoctercero) {
        this.xjifenviardoctercero = xjifenviardoctercero;
    }

    @Generated
    public void setXjifconfcuentapuc(JIFConfigurarCuentasPuc xjifconfcuentapuc) {
        this.xjifconfcuentapuc = xjifconfcuentapuc;
    }

    @Generated
    public void setXjifautorizaciondoc(JIFAutorizacionDoc xjifautorizaciondoc) {
        this.xjifautorizaciondoc = xjifautorizaciondoc;
    }

    @Generated
    public void setXjifinformesmov(JIFInformesMov xjifinformesmov) {
        this.xjifinformesmov = xjifinformesmov;
    }

    @Generated
    public void setXjifconsinfproveedor(JIFConsultaInformesTerceros xjifconsinfproveedor) {
        this.xjifconsinfproveedor = xjifconsinfproveedor;
    }

    @Generated
    public void setXjifcertificadosmanual(JIFGenerarCertificadoI xjifcertificadosmanual) {
        this.xjifcertificadosmanual = xjifcertificadosmanual;
    }

    @Generated
    public void setXjifcertificadosautomatico(JIFGenerarCetificadoA xjifcertificadosautomatico) {
        this.xjifcertificadosautomatico = xjifcertificadosautomatico;
    }

    @Generated
    public void setXjifformatodian(JIFConsultarDatosMDian xjifformatodian) {
        this.xjifformatodian = xjifformatodian;
    }

    @Generated
    public void setXjifinformeperiodos(JIFConsultarInfPeriodos xjifinformeperiodos) {
        this.xjifinformeperiodos = xjifinformeperiodos;
    }

    @Generated
    public void setXjifbalancecontable(JIFConsultarBalance xjifbalancecontable) {
        this.xjifbalancecontable = xjifbalancecontable;
    }

    @Generated
    public void setXjifinformeconsmovimiento(JIFInformeConsolidadoMov xjifinformeconsmovimiento) {
        this.xjifinformeconsmovimiento = xjifinformeconsmovimiento;
    }

    @Generated
    public void setXjifcuentaxpagar(JIFConsultarCuentasxP xjifcuentaxpagar) {
        this.xjifcuentaxpagar = xjifcuentaxpagar;
    }

    @Generated
    public void setXjifconciliacioninventario(JIFConciliacionInventarios xjifconciliacioninventario) {
        this.xjifconciliacioninventario = xjifconciliacioninventario;
    }

    @Generated
    public void setXjifgestionactivo(JIFGestionActivos xjifgestionactivo) {
        this.xjifgestionactivo = xjifgestionactivo;
    }

    @Generated
    public void setXjifregistrofact(JIFRegistroFacturas xjifregistrofact) {
        this.xjifregistrofact = xjifregistrofact;
    }

    @Generated
    public void setXjifmodificaciondocc(JIFModificarDocumentosC xjifmodificaciondocc) {
        this.xjifmodificaciondocc = xjifmodificaciondocc;
    }

    @Generated
    public void setXjifpucgastos(JIFPucGastos xjifpucgastos) {
        this.xjifpucgastos = xjifpucgastos;
    }

    @Generated
    public void setXjifinformesc(JIFInformeC xjifinformesc) {
        this.xjifinformesc = xjifinformesc;
    }

    @Generated
    public void setXjifinformesc1(JIFInformeC_PFecha xjifinformesc1) {
        this.xjifinformesc1 = xjifinformesc1;
    }

    @Generated
    public void setXjifdepreciacion(JIFDepreciacion xjifdepreciacion) {
        this.xjifdepreciacion = xjifdepreciacion;
    }

    @Generated
    public void setXjifauditoria(JIFAuditoriasProductos xjifauditoria) {
        this.xjifauditoria = xjifauditoria;
    }

    @Generated
    public void setXjifcierrec(JIFCierre_Contable xjifcierrec) {
        this.xjifcierrec = xjifcierrec;
    }

    @Generated
    public void setXjifcierreccgi(JIFCierre_Contable_CGI xjifcierreccgi) {
        this.xjifcierreccgi = xjifcierreccgi;
    }

    @Generated
    public void setXjifkardex(JIFKardex xjifkardex) {
        this.xjifkardex = xjifkardex;
    }

    @Generated
    public void setXvalor_uvt(double xvalor_uvt) {
        this.xvalor_uvt = xvalor_uvt;
    }

    @Generated
    public void setXJIFConsultarMovimiento(com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento xJIFConsultarMovimiento) {
        this.xJIFConsultarMovimiento = xJIFConsultarMovimiento;
    }

    @Generated
    public void setXjibuscardocumento(JIFBuscarDocumentosC xjibuscardocumento) {
        this.xjibuscardocumento = xjibuscardocumento;
    }

    @Generated
    public void setXJIFConsultarBalanceN(JIFConsultar_BalanceP xJIFConsultarBalanceN) {
        this.xJIFConsultarBalanceN = xJIFConsultarBalanceN;
    }

    @Generated
    public void setXJIFEstadosFinan_Comparativos(JIFEstadosFinanc_Comparativos xJIFEstadosFinan_Comparativos) {
        this.xJIFEstadosFinan_Comparativos = xJIFEstadosFinan_Comparativos;
    }

    @Generated
    public void setXJIFConsultarBalanceF(JIFConsultar_BalanceP_Fecha xJIFConsultarBalanceF) {
        this.xJIFConsultarBalanceF = xJIFConsultarBalanceF;
    }

    @Generated
    public void setXjif_libroauxiliar(JIFConsultar_LibroAuxiliar_Fecha xjif_libroauxiliar) {
        this.xjif_libroauxiliar = xjif_libroauxiliar;
    }

    @Generated
    public void setXjifGestionTerceros(JIF_GestionTerceros xjifGestionTerceros) {
        this.xjifGestionTerceros = xjifGestionTerceros;
    }

    @Generated
    public void setXJIFConsultarCuentaCobro(JIFConsultarCuentaCobro xJIFConsultarCuentaCobro) {
        this.xJIFConsultarCuentaCobro = xJIFConsultarCuentaCobro;
    }

    @Generated
    public void setXJIFConsultar_LibroAuxiliar_RangoCuenta(JIFConsultar_LibroAuxiliar_RangoCuenta xJIFConsultar_LibroAuxiliar_RangoCuenta) {
        this.xJIFConsultar_LibroAuxiliar_RangoCuenta = xJIFConsultar_LibroAuxiliar_RangoCuenta;
    }

    @Generated
    public void setXJIFConsultar_LibroAuxiliar_Terceros(JIFConsultar_LibroAuxiliar_Terceros xJIFConsultar_LibroAuxiliar_Terceros) {
        this.xJIFConsultar_LibroAuxiliar_Terceros = xJIFConsultar_LibroAuxiliar_Terceros;
    }

    @Generated
    public void setXjifbalancegeneral(JIFConsultar_BGeneral xjifbalancegeneral) {
        this.xjifbalancegeneral = xjifbalancegeneral;
    }

    @Generated
    public void setXJIFConsultarCuentasxPagarContaCart(JIFConsultarCuentasxPagarContaCart xJIFConsultarCuentasxPagarContaCart) {
        this.xJIFConsultarCuentasxPagarContaCart = xJIFConsultarCuentasxPagarContaCart;
    }

    @Generated
    public void setXjif_cmovimiento_tercero(JIF_Consultar_Movimiento xjif_cmovimiento_tercero) {
        this.xjif_cmovimiento_tercero = xjif_cmovimiento_tercero;
    }

    @Generated
    public void setJIFInformesVariosContabilidad(JIFInformesVariosContabilidad jIFInformesVariosContabilidad) {
        this.jIFInformesVariosContabilidad = jIFInformesVariosContabilidad;
    }

    @Generated
    public void setJIFInformesFinancieros(JIFInformesFinancieros jIFInformesFinancieros) {
        this.jIFInformesFinancieros = jIFInformesFinancieros;
    }

    @Generated
    public void setJIFInformesCartera2193(JIFInformesCartera2193 jIFInformesCartera2193) {
        this.jIFInformesCartera2193 = jIFInformesCartera2193;
    }

    @Generated
    public void setJIFRevisionDocumentosDescuadrados(JIFRevisionDocumentosDescuadrados jIFRevisionDocumentosDescuadrados) {
        this.jIFRevisionDocumentosDescuadrados = jIFRevisionDocumentosDescuadrados;
    }

    @Generated
    public void setAuditoriaFacturasContables(JIF_AuditoriaFacturasContables auditoriaFacturasContables) {
        this.auditoriaFacturasContables = auditoriaFacturasContables;
    }

    @Generated
    public void setRequiereAuditoria(Integer requiereAuditoria) {
        this.requiereAuditoria = requiereAuditoria;
    }

    @Generated
    public void setJIfPagosNomaContabilidad(JIFPagoNominaC jIfPagosNomaContabilidad) {
        this.jIfPagosNomaContabilidad = jIfPagosNomaContabilidad;
    }

    @Generated
    public void setXWorkerSQL(WorkerSQL xWorkerSQL) {
        this.xWorkerSQL = xWorkerSQL;
    }

    @Generated
    public void setFacturasDianRecibidad(JIFGestionFacturasDianRecibidad facturasDianRecibidad) {
        this.facturasDianRecibidad = facturasDianRecibidad;
    }

    @Generated
    public void setJifreportes(JIF_Reportes_PyP_Generico jifreportes) {
        this.jifreportes = jifreportes;
    }

    @Generated
    public void setXjifconceptoccobro(JIFConceptoCCobro xjifconceptoccobro) {
        this.xjifconceptoccobro = xjifconceptoccobro;
    }

    @Generated
    public Principal getFrmPrincipal() {
        return this.frmPrincipal;
    }

    @Generated
    public String getXsql() {
        return this.xsql;
    }

    @Generated
    public Metodos getXmetodos() {
        return this.xmetodos;
    }

    @Generated
    public ConsultasMySQL getXconsultas() {
        return this.xconsultas;
    }

    @Generated
    public IntegraFactura getFrmIntegraFact() {
        return this.frmIntegraFact;
    }

    @Generated
    public JIFRadicacion getXjifradicacion() {
        return this.xjifradicacion;
    }

    @Generated
    public JIFFEmpresa getXjifempresa() {
        return this.xjifempresa;
    }

    @Generated
    public JIFFEmpresaBienestarSalud getXjifempresabienestar() {
        return this.xjifempresabienestar;
    }

    @Generated
    public JIFLiquidacionRad getXjifcomprobante() {
        return this.xjifcomprobante;
    }

    @Generated
    public JIFAuditoriaPago getXjifauditoriacp() {
        return this.xjifauditoriacp;
    }

    @Generated
    public JIFPeriodoContables getXjifperiodoc() {
        return this.xjifperiodoc;
    }

    @Generated
    public JIFDocContable getXjifdoccontable() {
        return this.xjifdoccontable;
    }

    @Generated
    public JIFGeneracionPagos getXjifgenerarpago() {
        return this.xjifgenerarpago;
    }

    @Generated
    public JIFGeneracionPagos_Directo getXjifgenerarpago1() {
        return this.xjifgenerarpago1;
    }

    @Generated
    public JIFGeneracionDisfon_v1 getXjifgeneraciondisfon_v1() {
        return this.xjifgeneraciondisfon_v1;
    }

    @Generated
    public JIFCargarSoporteLoteC getXjifimportacions() {
        return this.xjifimportacions;
    }

    @Generated
    public JIFRegistroRecibos getXjifregistrorecibos() {
        return this.xjifregistrorecibos;
    }

    @Generated
    public JIFSolicitudReembolsoCM getXjifsolicitudr() {
        return this.xjifsolicitudr;
    }

    @Generated
    public JIFGenerarCuentaCobro getXjifcuentacobro() {
        return this.xjifcuentacobro;
    }

    @Generated
    public JIFGenerarCuentaCobroM getXjifcuentacobrom() {
        return this.xjifcuentacobrom;
    }

    @Generated
    public JIFGenerarCuentaCobroMImpuestos getCobroMImpuestos() {
        return this.cobroMImpuestos;
    }

    @Generated
    public JIFConsultasInfC getXjifconsultainf() {
        return this.xjifconsultainf;
    }

    @Generated
    public JIFPuc getXjifpuc() {
        return this.xjifpuc;
    }

    @Generated
    public JIFAjusteDoc getXjifajuste() {
        return this.xjifajuste;
    }

    @Generated
    public JIFRadicacionNC getXjifradicacionnc() {
        return this.xjifradicacionnc;
    }

    @Generated
    public JIFRegistroSReembolso getXjifradicacionr() {
        return this.xjifradicacionr;
    }

    @Generated
    public JIFCargarGasto getXjifcargargasto() {
        return this.xjifcargargasto;
    }

    @Generated
    public JIFExportarDatosTipoDoc getXjifexportardatostipodoc() {
        return this.xjifexportardatostipodoc;
    }

    @Generated
    public String getXfechaperiodoi() {
        return this.xfechaperiodoi;
    }

    @Generated
    public JIFCEjecucionPpto getXjifejecucionppt() {
        return this.xjifejecucionppt;
    }

    @Generated
    public JIFConsultarNotaCreditoA getXjifconsultarnc() {
        return this.xjifconsultarnc;
    }

    @Generated
    public JIFAutorizacionOrdenesCT getXjifautorizaciondocc() {
        return this.xjifautorizaciondocc;
    }

    @Generated
    public JIFConsultarEstadoOc getXjifconsultarestado() {
        return this.xjifconsultarestado;
    }

    @Generated
    public Date getXfechai() {
        return this.xfechai;
    }

    @Generated
    public Date getXfechaf() {
        return this.xfechaf;
    }

    @Generated
    public JIFEnviarDocTerceros getXjifenviardoctercero() {
        return this.xjifenviardoctercero;
    }

    @Generated
    public JIFConfigurarCuentasPuc getXjifconfcuentapuc() {
        return this.xjifconfcuentapuc;
    }

    @Generated
    public JIFAutorizacionDoc getXjifautorizaciondoc() {
        return this.xjifautorizaciondoc;
    }

    @Generated
    public JIFInformesMov getXjifinformesmov() {
        return this.xjifinformesmov;
    }

    @Generated
    public JIFConsultaInformesTerceros getXjifconsinfproveedor() {
        return this.xjifconsinfproveedor;
    }

    @Generated
    public JIFGenerarCertificadoI getXjifcertificadosmanual() {
        return this.xjifcertificadosmanual;
    }

    @Generated
    public JIFGenerarCetificadoA getXjifcertificadosautomatico() {
        return this.xjifcertificadosautomatico;
    }

    @Generated
    public JIFConsultarDatosMDian getXjifformatodian() {
        return this.xjifformatodian;
    }

    @Generated
    public JIFConsultarInfPeriodos getXjifinformeperiodos() {
        return this.xjifinformeperiodos;
    }

    @Generated
    public JIFConsultarBalance getXjifbalancecontable() {
        return this.xjifbalancecontable;
    }

    @Generated
    public JIFInformeConsolidadoMov getXjifinformeconsmovimiento() {
        return this.xjifinformeconsmovimiento;
    }

    @Generated
    public JIFConsultarCuentasxP getXjifcuentaxpagar() {
        return this.xjifcuentaxpagar;
    }

    @Generated
    public JIFConciliacionInventarios getXjifconciliacioninventario() {
        return this.xjifconciliacioninventario;
    }

    @Generated
    public JIFGestionActivos getXjifgestionactivo() {
        return this.xjifgestionactivo;
    }

    @Generated
    public JIFRegistroFacturas getXjifregistrofact() {
        return this.xjifregistrofact;
    }

    @Generated
    public JIFModificarDocumentosC getXjifmodificaciondocc() {
        return this.xjifmodificaciondocc;
    }

    @Generated
    public JIFPucGastos getXjifpucgastos() {
        return this.xjifpucgastos;
    }

    @Generated
    public JIFInformeC getXjifinformesc() {
        return this.xjifinformesc;
    }

    @Generated
    public JIFInformeC_PFecha getXjifinformesc1() {
        return this.xjifinformesc1;
    }

    @Generated
    public JIFDepreciacion getXjifdepreciacion() {
        return this.xjifdepreciacion;
    }

    @Generated
    public JIFAuditoriasProductos getXjifauditoria() {
        return this.xjifauditoria;
    }

    @Generated
    public JIFCierre_Contable getXjifcierrec() {
        return this.xjifcierrec;
    }

    @Generated
    public JIFCierre_Contable_CGI getXjifcierreccgi() {
        return this.xjifcierreccgi;
    }

    @Generated
    public JIFKardex getXjifkardex() {
        return this.xjifkardex;
    }

    @Generated
    public double getXvalor_uvt() {
        return this.xvalor_uvt;
    }

    @Generated
    public com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento getXJIFConsultarMovimiento() {
        return this.xJIFConsultarMovimiento;
    }

    @Generated
    public JIFBuscarDocumentosC getXjibuscardocumento() {
        return this.xjibuscardocumento;
    }

    @Generated
    public JIFConsultar_BalanceP getXJIFConsultarBalanceN() {
        return this.xJIFConsultarBalanceN;
    }

    @Generated
    public JIFEstadosFinanc_Comparativos getXJIFEstadosFinan_Comparativos() {
        return this.xJIFEstadosFinan_Comparativos;
    }

    @Generated
    public JIFConsultar_BalanceP_Fecha getXJIFConsultarBalanceF() {
        return this.xJIFConsultarBalanceF;
    }

    @Generated
    public JIFConsultar_LibroAuxiliar_Fecha getXjif_libroauxiliar() {
        return this.xjif_libroauxiliar;
    }

    @Generated
    public JIF_GestionTerceros getXjifGestionTerceros() {
        return this.xjifGestionTerceros;
    }

    @Generated
    public JIFConsultarCuentaCobro getXJIFConsultarCuentaCobro() {
        return this.xJIFConsultarCuentaCobro;
    }

    @Generated
    public JIFConsultar_LibroAuxiliar_RangoCuenta getXJIFConsultar_LibroAuxiliar_RangoCuenta() {
        return this.xJIFConsultar_LibroAuxiliar_RangoCuenta;
    }

    @Generated
    public JIFConsultar_LibroAuxiliar_Terceros getXJIFConsultar_LibroAuxiliar_Terceros() {
        return this.xJIFConsultar_LibroAuxiliar_Terceros;
    }

    @Generated
    public JIFConsultar_BGeneral getXjifbalancegeneral() {
        return this.xjifbalancegeneral;
    }

    @Generated
    public JIFConsultarCuentasxPagarContaCart getXJIFConsultarCuentasxPagarContaCart() {
        return this.xJIFConsultarCuentasxPagarContaCart;
    }

    @Generated
    public JIF_Consultar_Movimiento getXjif_cmovimiento_tercero() {
        return this.xjif_cmovimiento_tercero;
    }

    @Generated
    public JIFInformesVariosContabilidad getJIFInformesVariosContabilidad() {
        return this.jIFInformesVariosContabilidad;
    }

    @Generated
    public JIFInformesFinancieros getJIFInformesFinancieros() {
        return this.jIFInformesFinancieros;
    }

    @Generated
    public JIFInformesCartera2193 getJIFInformesCartera2193() {
        return this.jIFInformesCartera2193;
    }

    @Generated
    public JIFRevisionDocumentosDescuadrados getJIFRevisionDocumentosDescuadrados() {
        return this.jIFRevisionDocumentosDescuadrados;
    }

    @Generated
    public JIF_AuditoriaFacturasContables getAuditoriaFacturasContables() {
        return this.auditoriaFacturasContables;
    }

    @Generated
    public JIFPagoNominaC getJIfPagosNomaContabilidad() {
        return this.jIfPagosNomaContabilidad;
    }

    @Generated
    public WorkerSQL getXWorkerSQL() {
        return this.xWorkerSQL;
    }

    @Generated
    public JIFGestionFacturasDianRecibidad getFacturasDianRecibidad() {
        return this.facturasDianRecibidad;
    }

    @Generated
    public JIF_Reportes_PyP_Generico getJifreportes() {
        return this.jifreportes;
    }

    @Generated
    public IMCcFacturaInternaService getFacturaInternaService() {
        return this.facturaInternaService;
    }

    @Generated
    public JIFConceptoCCobro getXjifconceptoccobro() {
        return this.xjifconceptoccobro;
    }

    public claseContabilidad(Principal frmP) {
        this.frmPrincipal = frmP;
        this.frmPrincipal.JLBPeridoC.setVisible(true);
        this.facturaInternaService = (IMCcFacturaInternaService) Principal.contexto.getBean(MCcFacturaInternaServiceImpl.class);
        mBuscarIdPeriodoContable();
        this.requiereAuditoria = Principal.informacionIps.getRequiereAuditoria();
    }

    public void buscar(String frm) {
        switch (frm) {
            case "IntegraFactura":
                this.frmIntegraFact.buscar();
                break;
            case "jif_ReportesPyP_Contable":
                this.jifreportes.mBuscar();
                break;
            case "jifradicacionfac":
                this.xjifradicacion.mBuscar();
                break;
            case "jifdocumentoc":
                this.xjifdoccontable.mBuscar();
                break;
            case "jifregistrorecibos":
                this.xjifregistrorecibos.mBuscar();
                break;
            case "jifconsultarinformesc":
                this.xjifconsultainf.mBuscar();
                break;
            case "jifcuentacobrom":
                this.xjifcuentacobrom.mBuscar();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mBuscar();
                break;
            case "jifrgeistroreembolso":
                this.xjifradicacionr.mBuscar();
                break;
            case "jifsolicitudreembolso":
                this.xjifsolicitudr.mBuscar();
                break;
            case "jifexportarinformacionc":
                this.xjifexportardatostipodoc.mBuscar();
                break;
            case "jifautorizaciondocumentos3":
                this.xjifautorizaciondocc.mBuscar();
                break;
            case "jifenviardoctercero":
                this.xjifenviardoctercero.mBuscar();
                break;
            case "xjifcosultarinformesc":
                this.xjifinformesmov.mBuscar();
                break;
            case "jifgeneracioncertificadoman":
                this.xjifcertificadosmanual.mBuscar();
                break;
            case "xjifgenerarcertificadoautomatico":
                this.xjifcertificadosautomatico.mBuscar();
                break;
            case "jifcuentacobro":
                this.xjifcuentacobro.mBuscar();
                break;
            case "jifmediosdian":
            case "jifmediosid":
                this.xjifformatodian.mBuscar();
                break;
            case "jifconsultarordenesc2":
                this.xjifconsultarestado.mBuscar();
                break;
            case "xjifconsultarportipoimpuesto":
                this.xjifinformeperiodos.mBuscar();
                break;
            case "xjifbalancecontable":
                this.xjifbalancecontable.mBuscar();
                break;
            case "xjifbalancecontable_n":
                this.xJIFConsultarBalanceN.mBuscar();
                break;
            case "xjif_estadofinancierocomparativo":
                this.xJIFEstadosFinan_Comparativos.mBuscar();
                break;
            case "xjifconsolidadomovimiento1":
                this.xjifinformeconsmovimiento.mBuscar();
                break;
            case "xjicuentaspagar":
                this.xjifcuentaxpagar.mBuscar();
                break;
            case "xjifconciliacioninventario":
                this.xjifconciliacioninventario.mBuscar();
                break;
            case "xjifregistrofact":
                this.xjifregistrofact.mBuscar();
                break;
            case "xjifmoddocumentoc":
                this.xjifmodificaciondocc.mBuscar();
                break;
            case "xjifinformescontables":
                this.xjifinformesc.mBuscar();
                break;
            case "xjifinformescontables_fecha":
                this.xjifinformesc1.mBuscar();
                break;
            case "xjifauditoriaaleatoria1":
                this.xjifauditoria.mBuscar();
                break;
            case "xjifdepreciacion":
                this.xjifdepreciacion.mBuscar();
                break;
            case "xjifcierrecontable":
                this.xjifcierrec.mBuscar();
                break;
            case "xjifcierrecuentascgi":
                this.xjifcierreccgi.mBuscar();
                break;
            case "xjifkardex1":
                this.xjifkardex.mBuscar();
                break;
            case "MovimientoxRFecha":
                this.xJIFConsultarMovimiento.mBuscar();
                break;
            case "jifgenerarpagos1":
                this.xjifgenerarpago1.mBuscar();
                break;
            case "xjif_balancefecha":
                this.xJIFConsultarBalanceF.mBuscar();
                break;
            case "xjif_libro_auxiliar":
                this.xjif_libroauxiliar.mBuscar();
                break;
            case "xjifgestionterceros":
                this.xjifGestionTerceros.mBuscar();
                break;
            case "xjifconsultarcuentacobro":
                this.xJIFConsultarCuentaCobro.mBuscar();
                break;
            case "xjif_libro_auxiliar_rangocuentas":
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.mBuscar();
                break;
            case "xjif_libro_auxiliar_terceros":
                this.xJIFConsultar_LibroAuxiliar_Terceros.mBuscar();
                break;
            case "xjifconsultarcuentasxpagarcontacart":
                this.xJIFConsultarCuentasxPagarContaCart.mBuscar();
                break;
            case "xjif_balancegeneral":
                this.xjifbalancegeneral.mBuscar();
                break;
            case "xjif_consultar_mov_tercero":
                this.xjif_cmovimiento_tercero.mBuscar();
                break;
            case "jif_informesvarioscontabilidad":
                this.jIFInformesVariosContabilidad.buscar();
                break;
            case "jif_informesestadofinanciero":
                this.jIFInformesFinancieros.buscar();
                break;
            case "jIFInformesCartera2193":
                this.jIFInformesCartera2193.buscar();
                break;
            case "xJIFReportesCamu633":
                this.jIFInformesCartera2193.buscar();
                break;
            case "jifpagosnominac":
                this.jIfPagosNomaContabilidad.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm, JIFGC_Pagos_Grupal xjf) {
        if (frm.equals("Documento Contable")) {
            this.xjifdoccontable = new JIFDocContable(this, xjf);
            Principal.cargarPantalla(this.xjifdoccontable);
        }
    }

    public void cargarPantalla(String frm, EntradaRadicacionDTO entrada) {
        if (frm.equals("Documento Contable")) {
            this.xjifdoccontable = new JIFDocContable(this, entrada);
            Principal.cargarPantalla(this.xjifdoccontable);
        }
    }

    public void cargarPantalla(String frm, JIFGeneracionPagos_Directo xjf) {
        if (frm.equals("Documento Contable")) {
            this.xjifdoccontable = new JIFDocContable(this, xjf, 1);
            Principal.cargarPantalla(this.xjifdoccontable);
        }
    }

    public void cargarPantalla(String form, int tipo) {
        this.xjifcomprobante = new JIFLiquidacionRad(this.xjifradicacion, "0", "2", tipo, null, this.xjifradicacion.JTFNFactura.getText(), Long.valueOf(this.xjifradicacion.xidempresa[this.xjifradicacion.JCBEmpresa.getSelectedIndex()][0]), this.xjifradicacion.JLBId.getText());
        this.xjifcomprobante.tipo = tipo;
        Principal.cargarPantalla(this.xjifcomprobante);
    }

    public void cargarPantalla(String frm, Long idParametro) {
        if (frm.equals("Consultar Bienes o Servicios")) {
            this.xjifconsultarestado = new JIFConsultarEstadoOc("jifconsultarordenesc2", this.xjifradicacion);
            Principal.cargarPantalla(this.xjifconsultarestado);
        } else if (frm.equals("Radicación_Inventario")) {
            this.xjifradicacion = new JIFRadicacion(this, idParametro);
            Principal.cargarPantalla(this.xjifradicacion);
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "IntegraFactura":
                this.frmIntegraFact = new IntegraFactura(this);
                Principal.cargarPantalla(this.frmIntegraFact);
                break;
            case "Informacion Controloria":
                this.jIFInformesVariosContabilidad = new JIFInformesVariosContabilidad("Información Contraloría");
                Principal.cargarPantalla(this.jIFInformesVariosContabilidad);
                break;
            case "Consultar Estado de Facturas para Auditoría":
                this.auditoriaFacturasContables = new JIF_AuditoriaFacturasContables(frm.toUpperCase());
                Principal.cargarPantalla(this.auditoriaFacturasContables);
                break;
            case "Estado de Resultado":
                this.jIFInformesFinancieros = new JIFInformesFinancieros(frm.toUpperCase());
                Principal.cargarPantalla(this.jIFInformesFinancieros);
                break;
            case "jiffacturaciondianrecibida":
                this.facturasDianRecibidad = new JIFGestionFacturasDianRecibidad();
                Principal.cargarPantalla(this.facturasDianRecibidad);
                break;
            case "Estados Financieros":
                this.xJIFEstadosFinan_Comparativos = new JIFEstadosFinanc_Comparativos(frm.toUpperCase());
                Principal.cargarPantalla(this.xJIFEstadosFinan_Comparativos);
                break;
            case "Libro Mayor":
                this.xJIFConsultarBalanceF = new JIFConsultar_BalanceP_Fecha("LIBRO MAYOR");
                Principal.cargarPantalla(this.xJIFConsultarBalanceF);
                break;
            case "Libro Auxiliar":
                this.xjif_libroauxiliar = new JIFConsultar_LibroAuxiliar_Fecha("LIBRO AUXILIAR");
                Principal.cargarPantalla(this.xjif_libroauxiliar);
                break;
            case "Informe Libro Auxiliar":
                this.xjifinformesc1 = new JIFInformeC_PFecha(frm);
                Principal.cargarPantalla(this.xjifinformesc1);
                break;
            case "Depreciacion Activos":
                this.xjifdepreciacion = new JIFDepreciacion();
                Principal.cargarPantalla(this.xjifdepreciacion);
                break;
        }
        if (frm.equals("Informe Libro Auxiliar Tercero") || frm.equals("Informe Libro Auxiliar Banco")) {
            this.xjifinformesc1 = new JIFInformeC_PFecha(frm);
            Principal.cargarPantalla(this.xjifinformesc1);
        }
        if (frm.equals("Modificacion DocumentoC")) {
            this.xjifmodificaciondocc = new JIFModificarDocumentosC();
            Principal.cargarPantalla(this.xjifmodificaciondocc);
        }
        if (frm.equals("Conciliacion Inventario")) {
            this.xjifconciliacioninventario = new JIFConciliacionInventarios();
            Principal.cargarPantalla(this.xjifconciliacioninventario);
        }
        if (frm.equals("Consolidado de Movimiento")) {
            this.xjifinformeconsmovimiento = new JIFInformeConsolidadoMov("xjifconsolidadomovimiento1");
            Principal.cargarPantalla(this.xjifinformeconsmovimiento);
        }
        if (frm.equals("Informe Cuentas por Pagar")) {
            this.xjifcuentaxpagar = new JIFConsultarCuentasxP();
            Principal.cargarPantalla(this.xjifcuentaxpagar);
        }
        if (frm.equals("Balance Contable")) {
            this.xJIFConsultarBalanceN = new JIFConsultar_BalanceP("BALANCE DE COMPROBACIÓN POR PERIODO");
            Principal.cargarPantalla(this.xJIFConsultarBalanceN);
        }
        if (frm.equals("Balance Contable por Fecha")) {
            this.xJIFConsultarBalanceF = new JIFConsultar_BalanceP_Fecha("BALANCE DE COMPROBACIÓN POR FECHA");
            Principal.cargarPantalla(this.xJIFConsultarBalanceF);
        }
        if (frm.equals("Informe Tipo Impuesto")) {
            this.xjifinformeperiodos = new JIFConsultarInfPeriodos();
            Principal.cargarPantalla(this.xjifinformeperiodos);
        }
        if (frm.equals("Radicación")) {
            this.xjifradicacion = new JIFRadicacion(this);
            Principal.cargarPantalla(this.xjifradicacion);
        }
        if (frm.equals("Empresa")) {
            this.xjifempresa = new JIFFEmpresa("jifconfempresa", 0, "Empresa Contratante");
            Principal.cargarPantalla(this.xjifempresa);
        }
        if (frm.equals("Generar Liquidacion")) {
            this.xjifcomprobante = new JIFLiquidacionRad(this.xjifradicacion, "0", "2", 0, this.xjifradicacion.radicacionCompromisos, this.xjifradicacion.JTFNFactura.getText(), Long.valueOf(this.xjifradicacion.xidempresa[this.xjifradicacion.JCBEmpresa.getSelectedIndex()][0]), this.xjifradicacion.JLBId.getText());
            Principal.cargarPantalla(this.xjifcomprobante);
        }
        if (frm.equals("Generar Liquidacion Nc")) {
            this.xjifcomprobante = new JIFLiquidacionRad(this.xjifradicacionnc, this.xjifradicacionnc.getxIdObligacion(), "5", 0, null, this.xjifradicacionnc.JCBNFactura.getSelectedItem().toString(), Long.valueOf(this.xjifradicacionnc.xidempresa[this.xjifradicacionnc.JCBEmpresa.getSelectedIndex()][0]), this.xjifradicacionnc.JLBId.getText());
            Principal.cargarPantalla(this.xjifcomprobante);
        }
        if (frm.equals("Movimientos")) {
            this.xjifinformesmov = new JIFInformesMov();
            Principal.cargarPantalla(this.xjifinformesmov);
        }
        if (frm.equals("Periodos Contables")) {
            this.xjifperiodoc = new JIFPeriodoContables("jifperiodoc");
            Principal.cargarPantalla(this.xjifperiodoc);
        }
        if (frm.equals("Documento Contable")) {
            this.xjifdoccontable = new JIFDocContable(this);
            Principal.cargarPantalla(this.xjifdoccontable);
        }
        if (frm.equals("Plan de Cuenta")) {
            this.xjifpuc = new JIFPuc("xjifpuc");
            Principal.cargarPantalla(this.xjifpuc);
        }
        if (frm.equals("Buscar Puc")) {
            this.xjifpuc = new JIFPuc(this.xjifdoccontable, frm);
            Principal.cargarPantalla(this.xjifpuc);
        }
        if (frm.equals("Generar Pago")) {
            this.xjifgenerarpago = new JIFGeneracionPagos(0);
            Principal.cargarPantalla(this.xjifgenerarpago);
        }
        if (frm.equals("Generar Pago Individual")) {
            this.xjifgenerarpago1 = new JIFGeneracionPagos_Directo(1);
            Principal.cargarPantalla(this.xjifgenerarpago1);
        }
        if (frm.equals("Generar Disfon")) {
            this.xjifgeneraciondisfon_v1 = new JIFGeneracionDisfon_v1();
            Principal.cargarPantalla(this.xjifgeneraciondisfon_v1);
        }
        if (frm.equals("Buscar Puc L")) {
            this.xjifpuc = new JIFPuc(this.xjifcomprobante, frm);
            Principal.cargarPantalla(this.xjifpuc);
        }
        if (frm.equals("Facturas")) {
            this.xjifimportacions = new JIFCargarSoporteLoteC();
            Principal.cargarPantalla(this.xjifimportacions);
        }
        if (frm.equals("Registro Recibos")) {
            new AccesoModulos(null, true, "MODULO DE CAJA MENOR", "Caja Menor", "cajam", this.frmPrincipal);
            this.xjifregistrorecibos = new JIFRegistroRecibos("jifregistrorecibos");
            Principal.cargarPantalla(this.xjifregistrorecibos);
        }
        if (frm.equals("Solicitud de Reembolso")) {
            new AccesoModulos(null, true, "MODULO DE CAJA MENOR", "Caja Menor", "cajam", this.frmPrincipal);
            this.xjifsolicitudr = new JIFSolicitudReembolsoCM("jifsolicitudreembolso");
            Principal.cargarPantalla(this.xjifsolicitudr);
        }
        if (frm.equals("Buscar Puc M")) {
            this.xjifpuc = new JIFPuc(this.xjifcomprobante, frm);
            Principal.cargarPantalla(this.xjifpuc);
        }
        if (frm.equals("Selección de Documento para Pago")) {
            this.xjifgenerarpago = new JIFGeneracionPagos(1);
            Principal.cargarPantalla(this.xjifgenerarpago);
        }
        if (frm.equals("Generar Cuenta Cobro A")) {
            this.xjifcuentacobro = new JIFGenerarCuentaCobro();
            Principal.cargarPantalla(this.xjifcuentacobro);
        }
        if (frm.equals("Ajuste DocumentoC")) {
            this.xjifajuste = new JIFAjusteDoc();
            Principal.cargarPantalla(this.xjifajuste);
        }
        if (frm.equals("Consolidado por Fecha")) {
            this.xjifconsultainf = new JIFConsultasInfC("jifconsultarinformesc");
            Principal.cargarPantalla(this.xjifconsultainf);
        }
        if (frm.equals("Generar Cuenta Cobro M")) {
            this.xjifcuentacobrom = new JIFGenerarCuentaCobroM("jifcuentacobrom");
            Principal.cargarPantalla(this.xjifcuentacobrom);
        }
        if (frm.equals("Radicación Nota Crédito")) {
            this.xjifradicacionnc = new JIFRadicacionNC(this);
            Principal.cargarPantalla(this.xjifradicacionnc);
        }
        if (frm.equals("Radicación Reembolso")) {
            this.xjifradicacionr = new JIFRegistroSReembolso("jifrgeistroreembolso");
            Principal.cargarPantalla(this.xjifradicacionr);
        }
        if (frm.equals("Cargar Gasto")) {
            this.xjifcargargasto = new JIFCargarGasto();
            Principal.cargarPantalla(this.xjifcargargasto);
        }
        if (frm.equals("Consultar Documentos Contables")) {
            this.xjibuscardocumento = new JIFBuscarDocumentosC();
            Principal.cargarPantalla(this.xjibuscardocumento);
        }
        if (frm.equals("Ejecución Presupuestal")) {
            this.xjifejecucionppt = new JIFCEjecucionPpto();
            Principal.cargarPantalla(this.xjifejecucionppt);
        }
        if (frm.equals("Consultar NotaC")) {
            this.xjifconsultarnc = new JIFConsultarNotaCreditoA("jifconsultarnotacredito", this.xjifgenerarpago);
            Principal.cargarPantalla(this.xjifconsultarnc);
        }
        if (frm.equals("Documentos por Fecha y Tercero") || frm.equals("Autorización Documentos")) {
            this.xjifautorizaciondocc = new JIFAutorizacionOrdenesCT("jifautorizaciondocumentos3", 0);
            Principal.cargarPantalla(this.xjifautorizaciondocc);
        }
        if (frm.equals("Consultar Bienes o Servicios")) {
            this.xjifconsultarestado = new JIFConsultarEstadoOc("jifconsultarordenesc2", this.xjifradicacion);
            Principal.cargarPantalla(this.xjifconsultarestado);
        }
        if (frm.equals("Consultar Documentos x Terceros")) {
            this.xjifenviardoctercero = new JIFEnviarDocTerceros();
            Principal.cargarPantalla(this.xjifenviardoctercero);
        }
        if (frm.equals("Relación de Pagos")) {
            this.xjifconsinfproveedor = new JIFConsultaInformesTerceros();
            Principal.cargarPantalla(this.xjifconsinfproveedor);
        }
        if (frm.equals("Documentos x N°")) {
            this.xjifautorizaciondoc = new JIFAutorizacionDoc();
            Principal.cargarPantalla(this.xjifautorizaciondoc);
        }
        if (frm.equals("Certificado Manual")) {
            this.xjifcertificadosmanual = new JIFGenerarCertificadoI();
            Principal.cargarPantalla(this.xjifcertificadosmanual);
        }
        if (frm.equals("Certificado Automatico")) {
            this.xjifcertificadosautomatico = new JIFGenerarCetificadoA();
            Principal.cargarPantalla(this.xjifcertificadosautomatico);
        }
        if (frm.equals("Medios Magnéticos Dian")) {
            this.xjifformatodian = new JIFConsultarDatosMDian("jifmediosdian");
            Principal.cargarPantalla(this.xjifformatodian);
        }
        if (frm.equals("Medios Magnéticos Distritales")) {
            this.xjifformatodian = new JIFConsultarDatosMDian("jifmediosid");
            Principal.cargarPantalla(this.xjifformatodian);
        }
        if (frm.equals("Crear CPuc")) {
            this.xjifconfcuentapuc = new JIFConfigurarCuentasPuc("", false);
            Principal.cargarPantalla(this.xjifconfcuentapuc);
        }
        if (frm.equals("Registro Facturas")) {
            this.xjifregistrofact = new JIFRegistroFacturas();
            Principal.cargarPantalla(this.xjifregistrofact);
        }
        if (frm.equals("Cuentas Gastos Retención")) {
            this.xjifpucgastos = new JIFPucGastos("Cuentas Gastos Retención");
            Principal.cargarPantalla(this.xjifpucgastos);
        }
        if (frm.equals("xjifauditoriaaleatoria1")) {
            this.xjifauditoria = new JIFAuditoriasProductos("xjifauditoriaaleatoria1");
            Principal.cargarPantalla(this.xjifauditoria);
        }
        if (frm.equals("xjifcierrecontable")) {
            this.xjifcierrec = new JIFCierre_Contable();
            Principal.cargarPantalla(this.xjifcierrec);
        }
        if (frm.equals("xjifcierrecuentascgi")) {
            this.xjifcierreccgi = new JIFCierre_Contable_CGI();
            Principal.cargarPantalla(this.xjifcierreccgi);
        }
        if (frm.equals("Gestion Tercero")) {
            this.xjifGestionTerceros = new JIF_GestionTerceros();
            Principal.cargarPantalla(this.xjifGestionTerceros);
        }
        if (frm.equals("Kardex_I")) {
            this.xjifkardex = new JIFKardex("xjifkardex1");
            Principal.cargarPantalla(this.xjifkardex);
        }
        if (frm.equals("MovimientoxRangoFecha")) {
            this.xJIFConsultarMovimiento = new com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento();
            Principal.cargarPantalla(this.xJIFConsultarMovimiento);
        }
        if (frm.equals("Anular Documentos Por Cuenta de Cobro")) {
            this.xJIFConsultarCuentaCobro = new JIFConsultarCuentaCobro();
            Principal.cargarPantalla(this.xJIFConsultarCuentaCobro);
        }
        if (frm.equals("Libro Auxiliar por Rango Cuentas")) {
            this.xJIFConsultar_LibroAuxiliar_RangoCuenta = new JIFConsultar_LibroAuxiliar_RangoCuenta("CONSULTAR LIBRO AUXILIAR POR RANGO DE CUENTAS");
            Principal.cargarPantalla(this.xJIFConsultar_LibroAuxiliar_RangoCuenta);
        }
        if (frm.equals("Libro Auxiliar por Terceros")) {
            this.xJIFConsultar_LibroAuxiliar_Terceros = new JIFConsultar_LibroAuxiliar_Terceros("CONSULTAR LIBRO AUXILIAR POR TERCERO");
            Principal.cargarPantalla(this.xJIFConsultar_LibroAuxiliar_Terceros);
        }
        if (frm.equals("Balance General")) {
            this.xjifbalancegeneral = new JIFConsultar_BGeneral("BALANCE GENERAL");
            Principal.cargarPantalla(this.xjifbalancegeneral);
        }
        if (frm.equals("Consultar Cuentas Por Pagar")) {
            this.xJIFConsultarCuentasxPagarContaCart = new JIFConsultarCuentasxPagarContaCart();
            Principal.cargarPantalla(this.xJIFConsultarCuentasxPagarContaCart);
        }
        if (frm.equals("Movimientos por Tercero")) {
            this.xjif_cmovimiento_tercero = new JIF_Consultar_Movimiento();
            Principal.cargarPantalla(this.xjif_cmovimiento_tercero);
        }
        if (frm.equals("Informes Cartera 2193")) {
            this.jIFInformesCartera2193 = new JIFInformesCartera2193();
            Principal.cargarPantalla(this.jIFInformesCartera2193);
        }
        if (frm.equals("Documentos Descuadrados")) {
            this.jIFRevisionDocumentosDescuadrados = new JIFRevisionDocumentosDescuadrados();
            Principal.cargarPantalla(this.jIFRevisionDocumentosDescuadrados);
        }
        if (frm.equals("Pagos Nomina")) {
            this.jIfPagosNomaContabilidad = new JIFPagoNominaC(0);
            Principal.cargarPantalla(this.jIfPagosNomaContabilidad);
        }
        if (frm.equals("Concepto Cuenta de Cobro")) {
            this.xjifconceptoccobro = new JIFConceptoCCobro("jifconceptocc1");
            Principal.cargarPantalla(this.xjifconceptoccobro);
        }
        if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(6, "INFORMES GENERALES", "jif_ReportesPyP_Contable");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "IntegraFactura":
                this.frmIntegraFact.sumarValores();
                break;
            case "xjifmoddocumentoc":
                this.xjifmodificaciondocc.mGrabar();
                break;
            case "jifradicacionfac":
                System.out.println("entor a la clase");
                this.xjifradicacion.mGrabar();
                break;
            case "jifconfempresa":
                this.xjifempresa.mGrabar();
                break;
            case "jifconceptocc1":
                this.xjifconceptoccobro.mGrabar();
                break;
            case "jifconfempresabienestar":
                this.xjifempresabienestar.mGrabar();
                break;
            case "jifcomprobantep":
                this.xjifcomprobante.mGrabar();
                break;
            case "jifperiodoc":
                this.xjifperiodoc.mGrabar();
                break;
            case "jifauditoriacp":
                this.xjifauditoriacp.mGrabar();
                break;
            case "jifgenerarpagos":
                this.xjifgenerarpago.mGrabar();
                break;
            case "jifgenerarpagos1":
                this.xjifgenerarpago1.mGrabar();
                break;
            case "jifdocumentoc":
                this.xjifdoccontable.mGrabar();
                break;
            case "jifcargarsoportelote1":
                this.xjifimportacions.mGrabar();
                break;
            case "jifregistrorecibos":
                this.xjifregistrorecibos.mGrabar();
                break;
            case "jifsolicitudreembolso":
                this.xjifsolicitudr.mGrabar();
                break;
            case "jifcuentacobro":
                this.xjifcuentacobro.mGrabar();
                break;
            case "jifajustedoc":
                this.xjifajuste.mGrabar();
                break;
            case "jifcuentacobrom":
                this.xjifcuentacobrom.mGrabar();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mGrabar();
                break;
            case "jifradicacionnc":
                this.xjifradicacionnc.mGrabar();
                break;
            case "jifrgeistroreembolso":
                this.xjifradicacionr.mGrabar();
                break;
            case "jifcargargasto":
                this.xjifcargargasto.mGrabar();
                break;
            case "jifautorizaciondocumentos3":
                this.xjifautorizaciondocc.mGrabar();
                break;
            case "jifautorizaciondocn":
                this.xjifautorizaciondoc.mGrabar();
                break;
            case "jifconfigurarcuenta":
                this.xjifconfcuentapuc.mGrabar();
                break;
            case "jifgeneracioncertificadoman":
                this.xjifcertificadosmanual.mGrabar();
                break;
            case "xjifgenerarcertificadoautomatico":
                this.xjifcertificadosautomatico.mGrabar();
                break;
            case "xjifregistrofact":
                this.xjifregistrofact.mGrabar();
                break;
            case "jifPucGastos":
                this.xjifpucgastos.mGrabar();
                break;
            case "xjifdepreciacion":
                this.xjifdepreciacion.mGrabar();
                break;
            case "xjifcierrecontable":
                this.xjifcierrec.mGrabar();
                break;
            case "xjifcierrecuentascgi":
                this.xjifcierreccgi.mGrabar();
                break;
            case "jifpagosnominac":
                this.jIfPagosNomaContabilidad.mGrabar();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "IntegraFactura":
                this.frmIntegraFact.nuevo();
                break;
            case "xjifmoddocumentoc":
                this.xjifmodificaciondocc.mNuevo();
                break;
            case "jifradicacionfac":
                this.xjifradicacion.mNuevo();
                break;
            case "jifconfempresa":
                this.xjifempresa.mNuevo();
                break;
            case "jifcomprobantep":
                this.xjifcomprobante.mNuevo();
                break;
            case "jifperiodoc":
                this.xjifperiodoc.mNuevo();
                break;
            case "jifdocumentoc":
                this.xjifdoccontable.mNuevo();
                break;
            case "jifregistrorecibos":
                this.xjifregistrorecibos.mNuevo();
                break;
            case "jifcuentacobro":
                this.xjifcuentacobro.mNuevo();
                break;
            case "jifcuentacobrom":
                this.xjifcuentacobrom.mNuevo();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mNuevo();
                break;
            case "jifradicacionnc":
                this.xjifradicacionnc.mNuevo();
                break;
            case "jifrgeistroreembolso":
                this.xjifradicacionr.mNuevo();
                break;
            case "jifcargargasto":
                this.xjifcargargasto.mNuevo();
                break;
            case "jifexportarinformacionc":
                this.xjifexportardatostipodoc.mNuevo();
                break;
            case "xjifcosultarinformesc":
                this.xjifinformesmov.mNuevo();
                break;
            case "jifconfultainfproveedeor":
                this.xjifconsinfproveedor.mNuevo();
                break;
            case "jifgeneracioncertificadoman":
                this.xjifcertificadosmanual.mNuevo();
                break;
            case "xjifgenerarcertificadoautomatico":
                this.xjifcertificadosautomatico.mNuevo();
                break;
            case "xjifconsolidadomovimiento1":
                this.xjifinformeconsmovimiento.mNuevo();
                break;
            case "xjifconciliacioninventario":
                this.xjifconciliacioninventario.mNuevo();
                break;
            case "xjifregistrofact":
                this.xjifregistrofact.mNuevo();
                break;
            case "jifPucGastos":
                this.xjifpucgastos.mNuevo();
                break;
            case "xjifauditoriaaleatoria1":
                this.xjifauditoria.mNuevo();
                break;
            case "xjifdepreciacion":
                this.xjifdepreciacion.mNuevo();
                break;
            case "xjifcierrecontable":
                this.xjifcierrec.mNuevo();
                break;
            case "xjifcierrecuentascgi":
                this.xjifcierreccgi.mNuevo();
                break;
            case "jifconfigurarcuenta":
                this.xjifconfcuentapuc.mNuevo();
                break;
            case "jifgenerarpagos1":
                this.xjifgenerarpago1.mNuevo();
                break;
            case "xjif_balancefecha":
                this.xJIFConsultarBalanceF.mNuevo();
                break;
            case "xjifgestionterceros":
                this.xjifGestionTerceros.mNuevo();
                break;
            case "xjif_libro_auxiliar_rangocuentas":
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.mNuevo();
                break;
            case "xjif_libro_auxiliar_terceros":
                this.xJIFConsultar_LibroAuxiliar_Terceros.mNuevo();
                break;
            case "xjicuentaspagar":
                this.xjifcuentaxpagar.mNuevo();
                break;
            case "xjifconsultarcuentasxpagarcontacart":
                this.xJIFConsultarCuentasxPagarContaCart.mNuevo();
                break;
            case "xjif_balancegeneral":
                this.xjifbalancegeneral.mNuevo();
                break;
            case "MovimientoxRFecha":
                this.xJIFConsultarMovimiento.mNuevo();
                break;
            case "jif_informesvarioscontabilidad":
                this.jIFInformesVariosContabilidad.nuevo();
                break;
            case "jif_informesestadofinanciero":
                this.jIFInformesFinancieros.nuevo();
                break;
            case "jIFInformesCartera2193":
                this.jIFInformesCartera2193.nuevo();
                break;
            case "xJIFReportesCamu633":
                this.jIFInformesCartera2193.nuevo();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "jifradicacionfac":
                this.xjifradicacion.mImprimir();
                break;
            case "xjifmoddocumentoc":
                this.xjifmodificaciondocc.mImprimir();
                break;
            case "jifgenerarpagos":
                this.xjifgenerarpago.mImprimir();
                break;
            case "jifcomprobantep":
                this.xjifcomprobante.mImprimir();
                break;
            case "jifdocumentoc":
                this.xjifdoccontable.mImprimir();
                break;
            case "jifcuentacobro":
                this.xjifcuentacobro.mImprimir();
                break;
            case "jifcuentacobrom":
                this.xjifcuentacobrom.mImprimir();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mImprimir();
                break;
            case "jifradicacionnc":
                this.xjifradicacionnc.mImprimir();
                break;
            case "jifautorizaciondocn":
                this.xjifautorizaciondoc.mImprimir();
                break;
            case "jifconfultainfproveedeor":
                this.xjifconsinfproveedor.mImprimir();
                break;
            case "jifgeneracioncertificadoman":
                this.xjifcertificadosmanual.mImprimir();
                break;
            case "jifenviardoctercero":
                this.xjifenviardoctercero.mImprimir();
                break;
            case "xjifbalancecontable":
                this.xjifbalancecontable.mImprimir();
                break;
            case "jifenviaremail":
                this.xjifcertificadosautomatico.xjifenvioc.mImprimir();
                break;
            case "jifrgeistroreembolso":
                this.xjifradicacionr.mImprimir();
                break;
            case "xjifregistrofact":
                this.xjifregistrofact.mImprimir();
                break;
            case "xjifinformescontables":
                this.xjifinformesc.mImprimir();
                break;
            case "xjifinformescontables_fecha":
                this.xjifinformesc1.mImprimir();
                break;
            case "xjifauditoriaaleatoria1":
                this.xjifauditoria.mImprimir();
                break;
            case "xjifconciliacioninventario":
                this.xjifconciliacioninventario.mImprimir();
                break;
            case "jifconsultarinformesc":
                this.xjifconsultainf.mImprimir();
                break;
            case "xjifgestionterceros":
                this.xjifGestionTerceros.mImprimir();
                break;
            case "xjifdepreciacion":
                this.xjifdepreciacion.mImprimir(0L);
                break;
            case "xjifbalancecontable_n":
                this.xJIFConsultarBalanceN.mImprimir();
                break;
            case "MovimientoxRFecha":
                this.xJIFConsultarMovimiento.mImprimir();
                break;
            case "xjif_libro_auxiliar_rangocuentas":
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.mImprimir();
                break;
            case "xjif_libro_auxiliar_terceros":
                this.xJIFConsultar_LibroAuxiliar_Terceros.mImprimir();
                break;
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifradicacionfac":
                this.xjifradicacion.mAnular();
                break;
            case "jifradicacionnc":
                this.xjifradicacionnc.mAnular();
                break;
            case "jifcomprobantep":
                this.xjifcomprobante.mAnular();
                break;
            case "jifdocumentoc":
                this.xjifdoccontable.mAnular();
                break;
            case "jifregistrorecibos":
                this.xjifregistrorecibos.mAnular();
                break;
            case "jifcuentacobrom":
                this.xjifcuentacobrom.mAnular();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mAnular();
                break;
            case "jifrgeistroreembolso":
                this.xjifradicacionr.mAnular();
                break;
            case "jifsolicitudreembolso":
                this.xjifsolicitudr.mAnular();
                break;
            case "jifgeneracioncertificadoman":
                this.xjifcertificadosmanual.mAnular();
                break;
            case "jifcuentacobro":
                this.xjifcuentacobro.mAnular();
                break;
            case "jifenviaremail":
                this.xjifcertificadosautomatico.xjifenvioc.mAnular();
                break;
            case "xjifconsultarcuentacobro":
                this.xJIFConsultarCuentaCobro.mAnular();
                break;
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x019d: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:24:0x019d */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x01a2: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:26:0x01a2 */
    public void mImprimDocumentoContable(String xnparameto, String xvparametro, String xnarchivo, String xid, String xvalor, String xValoC) {
        DecimalFormat formato = new DecimalFormat("#0.00");
        String[][] mparametros = new String[10][2];
        mparametros[0][0] = xnparameto;
        mparametros[0][1] = xvparametro;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "TipoDoc";
        mparametros[2][1] = xid;
        mparametros[3][0] = "nvalor";
        mparametros[4][0] = "nvalorp";
        mparametros[5][0] = "nvNumeros";
        if (!xvalor.isEmpty()) {
            mparametros[3][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(Double.valueOf(xvalor)));
            mparametros[4][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(Double.valueOf(xvalor)));
            mparametros[5][1] = this.xmetodos.formatoMoneda.format(Double.valueOf(xvalor));
        } else {
            mparametros[3][1] = "";
            mparametros[4][1] = "";
            mparametros[5][1] = "";
        }
        mparametros[6][0] = "nvNomina";
        mparametros[7][0] = "nvNominaLetra";
        String sql = "SELECT\n    (SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`) -  SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`)) AS VNomina\n    , `rh_nomina_liquidacion`.`Id`\n    , `cc_documentoc`.`Id`\nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Nomina` = `rh_nomina_liquidacion`.`Id`)\nWHERE (`cc_documentoc`.`Id` ='" + xvparametro + "')\nGROUP BY `rh_nomina_liquidacion`.`Id`;";
        try {
            try {
                ResultSet xrs = this.xconsultas.traerRs(sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    mparametros[6][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(xrs.getDouble(1)));
                    mparametros[7][1] = this.xmetodos.formatoMoneda.format(xrs.getDouble(1));
                } else {
                    mparametros[6][1] = "";
                    mparametros[7][1] = "";
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xconsultas.cerrarConexionBd();
        mparametros[8][0] = "SUBREPORT_DIR";
        mparametros[8][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[9][0] = "SUBREPORTFIRMA_DIR";
        mparametros[9][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xnarchivo, mparametros);
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x019d: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:24:0x019d */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x01a2: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:26:0x01a2 */
    public String crearPDFDocumentoContable(String xnparameto, String xvparametro, String xnarchivo, String xid, String xvalor, String xValoC) {
        DecimalFormat formato = new DecimalFormat("#0.00");
        String[][] mparametros = new String[10][2];
        mparametros[0][0] = xnparameto;
        mparametros[0][1] = xvparametro;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "TipoDoc";
        mparametros[2][1] = xid;
        mparametros[3][0] = "nvalor";
        mparametros[4][0] = "nvalorp";
        mparametros[5][0] = "nvNumeros";
        if (!xvalor.isEmpty()) {
            mparametros[3][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(Double.valueOf(xvalor)));
            mparametros[4][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(Double.valueOf(xvalor)));
            mparametros[5][1] = this.xmetodos.formatoMoneda.format(Double.valueOf(xvalor));
        } else {
            mparametros[3][1] = "";
            mparametros[4][1] = "";
            mparametros[5][1] = "";
        }
        mparametros[6][0] = "nvNomina";
        mparametros[7][0] = "nvNominaLetra";
        String sql = "SELECT\n    (SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`) -  SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`)) AS VNomina\n    , `rh_nomina_liquidacion`.`Id`\n    , `cc_documentoc`.`Id`\nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Nomina` = `rh_nomina_liquidacion`.`Id`)\nWHERE (`cc_documentoc`.`Id` ='" + xvparametro + "')\nGROUP BY `rh_nomina_liquidacion`.`Id`;";
        try {
            try {
                ResultSet xrs = this.xconsultas.traerRs(sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    mparametros[6][1] = this.xmetodos.mConvertirNumeroLetras(formato.format(xrs.getDouble(1)));
                    mparametros[7][1] = this.xmetodos.formatoMoneda.format(xrs.getDouble(1));
                } else {
                    mparametros[6][1] = "";
                    mparametros[7][1] = "";
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xconsultas.cerrarConexionBd();
        mparametros[8][0] = "SUBREPORT_DIR";
        mparametros[8][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[9][0] = "SUBREPORTFIRMA_DIR";
        mparametros[9][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.CrearPDF(this.xmetodos.getRutaRep() + xnarchivo, mparametros);
        return xnarchivo;
    }

    public Long mValidarExistenciaComprobanteContable(String xid) {
        long xestado = 0;
        try {
            String sql = "SELECT Id FROM cc_documentoc WHERE (Id_Radicacion ='" + xid + "' AND Estado =1)";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xestado = xrs.getLong(1);
            } else {
                xestado = 0;
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Long.valueOf(xestado);
    }

    private void mBuscarIdPeriodoContable() {
        try {
            ResultSet rs = this.xconsultas.traerRs("SELECT Id, Date_format(FechaI,'%m/%Y') as Fecha FROM cc_periodo_contable WHERE (Activo =1 AND Estado =1) ");
            if (rs.next()) {
                rs.last();
                if (rs.getRow() > 1) {
                    this.xidperiodoc = -1;
                } else {
                    rs.first();
                    this.xidperiodoc = rs.getInt(1);
                    this.xfechaperiodoi = rs.getString(2);
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getXfechaperiodo() {
        return this.xfechaperiodoi;
    }

    public void setXfechaperiodo(String xfechaperiodo) {
        this.xfechaperiodoi = xfechaperiodo;
    }

    public int getXidperiodoc() {
        return this.xidperiodoc;
    }

    public String getXfechaperiodof() {
        return this.xfechaperiodof;
    }

    public void setXfechaperiodof(String xfechaperiodof) {
        this.xfechaperiodof = xfechaperiodof;
    }

    public void setXfechai(Date xfechai) {
        this.xfechai = xfechai;
    }

    public void setXfechaf(Date xfechaf) {
        this.xfechaf = xfechaf;
    }

    public void setXestadop(boolean xestadop) {
        this.xestadop = xestadop;
    }

    public boolean isXestadop() {
        return this.xestadop;
    }

    public int getxForma_Gn_Niif() {
        return this.xForma_Gn_Niif;
    }

    public void setxForma_Gn_Niif(int xForma_Gn_Niif) {
        this.xForma_Gn_Niif = xForma_Gn_Niif;
    }

    public String getNombrePeriodo() {
        return this.nombrePeriodo;
    }

    public int getRequiereAuditoria() {
        return this.requiereAuditoria.intValue();
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public void mImprimirOrdenCompra(String xid) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = xid;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
    }

    public void setXidperiodoc(int xidperiodoc) {
        this.xidperiodoc = xidperiodoc;
    }

    public String mGrabarEncabezadoDocContable(String xdetalle, int xtipoc, int xidradicacion, int xtipop, String ncheque, String xNConsecutivoD, String xfecha) {
        String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_Radicacion, Id_PeriodoC, NConsecutivo, TipoPago, NCheque, Descripcion, Fecha, UsuarioS) Values ('" + xfecha + "','" + xtipoc + "','0','" + getXidperiodoc() + "','" + xNConsecutivoD + "','" + xtipop + "','" + ncheque + "','" + xdetalle + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xid = this.xconsultas.ejecutarSQLId(sql);
        this.xconsultas.cerrarConexionBd();
        return xid;
    }

    public void mActulizarPagoRadicacion(String xidc, String xid) {
        String sql = "update cc_radicacion set Id_Comprobante='" + xidc + "' where Id='" + xid + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarSalidasSiAnulaDocContable(String xid) {
        String sql = "update i_salidas set Id_DocContable=0 where Id_DocContable='" + xid + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "update i_entradas set Id_DocContable=0 where Id_DocContable='" + xid + "'";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
    }

    public void mAnularDocumentoContable(String xidc, String xid, String xmotivo) {
        String sql;
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            sql = "update cc_documentoc set Estado=0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'  where Id='" + xidc + "'";
        } else {
            sql = "update cc_documentoc set Estado=0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `NConsecutivo`=0  where Id='" + xidc + "'";
        }
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "update cc_radicacion_pago set Estado=0 where Id_Documento='" + xidc + "'";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADA");
    }

    public void mAnularDocumentoPresupuesto(String xidc, String xid, String xmotivo) {
        String sql = "update pp_movimiento set `NoConcecutivo`='0', `IdSolicitud`=0 , `IdDisponibilidad`=0 , `IdCompromiso`=0 , `IdObligacion`=0,  `Id_MotivoAnulacion`='" + xid + "', `Observacion_Anul`='" + xmotivo + "', `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `Usuario_Anul`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'  where IdDocContable='" + xidc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "UPDATE `pp_detalle_movimiento`, (SELECT `Id` , `IdDocContable` FROM `pp_movimiento` WHERE (`IdDocContable` ='" + xidc + "')) a SET pp_detalle_movimiento.`Estado`=0 WHERE pp_detalle_movimiento.`Id_Movimiento`=a.id";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADA");
    }

    public void mLimpiarIdComprobanteEnLiquidacionNomina(String xidc) {
        String sql = "update rh_nomina_liquidacion_detalle set `Id_DocContableE`=0  where Id_DocContableE='" + xidc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mAnularCuentaCobro(String xid) {
        String sql = "update cc_cuentacobro set Estado=0  where Id='" + xid + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADA");
    }

    public void mAnularFacturaEvento(String xid) {
        try {
            String sql = "update f_factura_evento set Estado=0  where No_FacturaEvento='" + xid + "'";
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
            String sql2 = "SELECT `f_liquidacion`.`Id`, `f_cuentacobro`.`NoCuenta` FROM  `f_factura_evento` IN NER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`) WHERE (`f_factura_evento`.`No_FacturaEvento` ='" + xid + "') ";
            ResultSet xrs = this.xconsultas.traerRs(sql2);
            if (xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql3 = "update `f_liquidacion` set Estado=0  where Id='" + xrs.getLong(1) + "'";
                xct.ejecutarSQL(sql3);
                xct.cerrarConexionBd();
                String sql4 = "update `f_cuentacobro` set Estado=0  where NoCuenta='" + xrs.getLong(2) + "'";
                xct.ejecutarSQL(sql4);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean mValidarFechasDoc(Date xfecha1) {
        boolean xestado = false;
        if (this.xmetodos == null) {
            System.out.println("xmetodos es null");
            return false;
        }
        if (xfecha1 == null) {
            System.out.println("xfecha1 es null");
            return false;
        }
        if (this.xfechai == null || this.xfechaf == null) {
            System.out.println("xfechai o xfechaf es null");
            return false;
        }
        GregorianCalendar fecha = new GregorianCalendar();
        Date fecha1 = new Date();
        System.out.println("xfecha1: " + xfecha1);
        String texto = this.xmetodos.formatoDMA.format(xfecha1);
        String texto1 = this.xmetodos.formatoH24.format(fecha1);
        System.out.println("texto: " + texto);
        System.out.println("texto1: " + texto1);
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        String hora = texto1.substring(0, 2);
        String minuto = texto1.substring(3, 5);
        String segundo = texto1.substring(6, 8);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto), Integer.parseInt(segundo));
        Date fecha12 = fecha.getTime();
        System.out.println("fecha1: " + fecha12);
        System.out.println("xfechai: " + this.xfechai);
        System.out.println("xfechaf: " + this.xfechaf);
        if (fecha12.getTime() >= this.xfechai.getTime() && fecha12.getTime() <= this.xfechaf.getTime()) {
            xestado = true;
        }
        return xestado;
    }

    public int mNumeroChequeGenerar() {
        int xnumero = 0;
        try {
            ResultSet xrs = this.xconsultas.traerRs("SELECT (`NCheque`+1) FROM `g_ips`");
            if (xrs.next()) {
                xrs.first();
                xnumero = xrs.getInt(1);
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnumero;
    }

    public void mActualizarNCheque(String xnumero) {
        this.xsql = "Update g_ips set NCheque='" + xnumero + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    public String mBuscarNCuentaPuc(String xid) {
        String xnombre = "";
        try {
            this.xsql = "SELECT `Nbre` FROM `cc_puc` WHERE (`Id` ='" + xid + "') ";
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xnombre = xrs.getString(1);
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnombre;
    }

    public void mActualizarFacturaEvento(String xidDoc, String xid, Boolean xtacccion, int xtipo) {
        if (xtacccion.booleanValue()) {
            if (xtipo == 2) {
                String sql = "update f_factura_evento set Id_DocumentoC='" + xidDoc + "' where No_FacturaEvento='" + xid + "'";
                ConsultasMySQL xct = new ConsultasMySQL();
                xct.ejecutarSQL(sql);
                xct.cerrarConexionBd();
                return;
            }
            return;
        }
        String sql2 = "update f_factura_evento set Id_DocumentoC=0, EstaArmada=0 where Id_DocumentoC='" + xidDoc + "'";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        xct2.ejecutarSQL(sql2);
        xct2.cerrarConexionBd();
    }

    public void mActualizarNDocContable(String xidc, String xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "update  cc_documentoc  set Id_DocumentoC='" + xidc + "' where Id in(" + xid + ")";
        xct.ejecutarSQL(sql);
        xct.cerrarConexionBd();
    }

    public void mActualizarEstadoSReembolso(String xidDoc, Double xvalor) {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql = "SELECT `cc_recibocm`.`Id_TipoCaja` FROM `cc_recibocm` INNER JOIN `cc_solicitud_reembolso`  ON (`cc_recibocm`.`Id_SolicitudR` = `cc_solicitud_reembolso`.`Id`) WHERE (`cc_solicitud_reembolso`.`Id_DocContable` ='" + xidDoc + "') GROUP BY `cc_solicitud_reembolso`.`Id_DocContable` ";
            ResultSet xrs = xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                String xsql2 = "UPDATE  `cc_tipo_caja` SET  `Saldo`=(`Saldo`+" + xvalor + ") WHERE `cc_tipo_caja`.`Id`=" + xrs.getInt(1) + " ";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                xct1.ejecutarSQL(xsql2);
                xct1.cerrarConexionBd();
            }
            xrs.close();
            xct.cerrarConexionBd();
            String sql = "update cc_solicitud_reembolso set Id_DocContable=0 where Id_DocContable='" + xidDoc + "'";
            xct.ejecutarSQL(sql);
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarFacRadicadas(String xidDoc) {
        String sql = "update cc_radicacion set Id_Comprobante=0 where Id_Comprobante='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarCierres(String xidDoc) {
        String sql = "update k_cierre_n set Id_DocumentoC=0 where Id_DocumentoC='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarCierresIngreso(String xidDoc) {
        String sql = "update k_cierre set Id_DocContable=0 where Id_DocContable='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarActivos(String xidDoc) {
        String sql = "update rh_activo_contable set Id_Doc=0 where Id_Doc='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
        String sql2 = "update rh_activos_movimiento set estado=0 where Id_DocumentoC='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql2);
        this.xconsultas.cerrarConexionBd();
    }

    public void mAnulado_RadicacionFactura(String xidDoc) {
        this.xsql = "update cc_radicacion_pago set Estado=0 where Id_Documento='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarGlosas(String xidDoc) {
        String sql = "update f_factura_glosa set IdDocumentoC=0 where IdDocumentoC='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarRespuestaGlosas(String xidDoc) {
        String sql = "update f_factura_glosa_respuesta set IdDocumentoC=0 where IdDocumentoC='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarPagosFacturas(String xidDoc, String xid, String xmotivo) {
        String sql = "update f_factura_pagos set Id_DContable=0,  Estado= 0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xmotivo + "' , `FechaAnulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' , `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE Id_DContable='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mActualizarDatosRadicaciondeFacturas(String xidDoc) {
        String sql = "update f_factura_evento set Id_DocumentoCR=0 WHERE Id_DocumentoCR='" + xidDoc + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mAtualizarDatosSolicitudPresupuesto(String idDoc, String idMotivo, String Observasion) {
        String sql = "UPDATE\n  pp_solicitud_pto\nSET\n  Estado = '0',\n  Id_MotivoAnulacion = '" + idMotivo + "',\n  Observacion_Anul = '" + Observasion + "',\n  Fecha_Anul = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',\n  Usuario_Anul = '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' \nWHERE idDocumentoContable = '" + idDoc + "';";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void crearArchivos(String ruta, JTable table, int posNombreReporte, int posSeleccion, int posValor) {
        File f1;
        System.out.println("Entroo crear");
        System.out.println("Ruta : " + ruta);
        File directorio = new File(ruta);
        if (directorio.mkdir()) {
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getValueAt(i, posSeleccion).toString().equals("true")) {
                    String narchivo = this.xmetodos.getRutaRep() + crearPDFDocumentoContable("IdC", table.getValueAt(i, 0).toString(), table.getValueAt(i, 10).toString(), "2", table.getValueAt(i, posValor).toString(), "0");
                    new File(narchivo + ".pdf");
                    String adjunto = this.xmetodos.getRutaRep() + table.getValueAt(i, 0).toString() + "_No_" + table.getValueAt(i, 5).toString() + "_" + table.getValueAt(i, 1).toString() + "_" + table.getValueAt(i, 2).toString() + "_" + table.getValueAt(i, 3).toString() + ".pdf";
                    if (narchivo.substring(narchivo.length() - 4, narchivo.length()).equals(".pdf")) {
                        f1 = new File(narchivo);
                    } else {
                        f1 = new File(narchivo + ".pdf");
                    }
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(directorio, f2.getName()));
                }
            }
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimirFacturaInterna(String xid) {
        String[][] mparametros = new String[1][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = xid;
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Factura_Interna", mparametros);
    }

    public void mImprimirFacturaInterna(Long idInterna, int trasmitida) {
        IGenericoDosValores numeroFactura = this.facturaInternaService.getNumeroFacturaConcatenadoPrefijo(idInterna);
        if (numeroFactura.getNumeroConsecutivo() != null) {
            try {
                if (numeroFactura.getEstado().intValue() == 1) {
                    String ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura.getNumeroConsecutivo()).concat(this.xmetodos.getBarra()).concat(numeroFactura.getNumeroConsecutivo()).concat(".pdf");
                    System.out.println("" + ruta);
                    this.xmetodos.recuperarBlob("", 0, numeroFactura.getNumeroConsecutivo(), 0, ruta);
                } else {
                    mImprimirFacturaInterna(String.valueOf(idInterna));
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mImprimirNotaDebito(Long idInterna, int trasmitida) {
        System.out.println("entra a imprimir la nota debito");
        IGenericoDosValores numeroFactura = this.facturaInternaService.getNumeroConsecutivoNotaDebito(idInterna);
        System.out.println("el consecutivo " + numeroFactura.getNumeroConsecutivo());
        if (numeroFactura.getNumeroConsecutivo() != null) {
            try {
                if (numeroFactura.getEstado().intValue() == 1) {
                    String ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(numeroFactura.getNumeroConsecutivo()).concat(this.xmetodos.getBarra()).concat(numeroFactura.getNumeroConsecutivo()).concat(".pdf");
                    System.out.println("la ruta" + ruta);
                    this.xmetodos.recuperarBlob("", 0, numeroFactura.getNumeroConsecutivo(), 0, ruta);
                } else {
                    mImprimirFacturaInterna(String.valueOf(idInterna));
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(claseContabilidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
