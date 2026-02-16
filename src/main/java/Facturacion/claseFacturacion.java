package Facturacion;

import Acceso.Menus;
import Acceso.Principal;
import Armado.JIFDigitacionDx;
import Caja.JIF_Cierre_Caja;
import Caja.claseCaja;
import Cirugia.JIF_Programacion_Cx;
import Enfermeria.JIFCensoCama;
import General.ClaseImpresionInformes;
import General.JDAtencionesPreferenciales;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFRegistroAtencionesEsp;
import Informes.JIFInformesVarios;
import Inventarios.JIFConsultarInfSum;
import Laboratorio.AgendaBienestar;
import Laboratorio.RecepcionAuto;
import Laboratorio.RecepcionAutoBienestarSalud;
import Sgc.JIFEncuestaS;
import Sig.JIFFConsultarInformacionGenerico;
import Sig.JIFInformesNProgramada;
import Sig.JIFInformesNProgramadaRangoHora;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat;
import com.genoma.plus.controller.facturacion.JIFGestion_Servicios;
import com.genoma.plus.controller.facturacion.JIFListaFacturaVentas;
import com.genoma.plus.controller.facturacion.JIF_ConsultarIngresosPorLiquidacion;
import com.genoma.plus.controller.facturacion.JIF_Informacion_Facturas_Auditadas;
import com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto;
import com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil;
import com.genoma.plus.controller.gcuenta.JDRadicacion;
import com.genoma.plus.controller.gcuenta.JIFGestinDeFactura;
import com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedis;
import com.genoma.plus.controller.integracion_simedis.JIF_AgendaSimedisBienestar;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.controller.sig.JIFListaOrdenesInternas;
import com.genoma.plus.jpa.entities.GPersona;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/claseFacturacion.class */
public class claseFacturacion {
    public Principal frmPrincipal;
    public Facturac frmFacturac;
    private JIFCambiarGrupo xjifcambiargrupo;
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private int modulo;
    public int cajaAbierta;
    public int xaplicaencuesta;
    public int xrecepcionalaboratorio;
    public int xeslab;
    public int xlugarprocesamiento;
    public int xCargarAutorizacion;
    private long xvalor;
    private long xId_Rechazo;
    private String sql;
    public claseCaja clasecaja;
    private ResultSet rs;
    private boolean xgrabadofact;
    private JIFConsultarInfSum xjifconsultard;
    private JIFEncuestaS xjifencuenta;
    private JIFRelacionExamenesO xjifrelacionexameno;
    private JIFRegistroAtencionesEsp xjifregistroatencionesesp;
    private JIFInformesNProgramada xjifinformecnprogramada;
    private JIFReliquidacionFac xjifreliquidacionfac;
    public RecepcionAuto xjifrecepcionlab;
    public RecepcionAutoBienestarSalud xjifrecepcionlabBienestar;
    public AgendaBienestar xjifagendabienestar;
    private JIFSAutorizaciones xjifsaturoizaciones;
    public JIFConsultarExamenesxUsuario xjiconsultarRemOrd;
    public JIFLiqServicios xjiliqServicio;
    private JIFInformesVarios xJIFInformesVarios;
    public JIFAutorizacion_Servicios xjifautorizacion_servicio;
    public JIFGenerarCotizacion xgenerarcotizacion;
    private JIFInformacion_Empresa xjifconsultar_infempresa;
    private JIFRiesgoObstetrico xJIFRiesgoObstetrico;
    private JIFRiesgoCardiovascular xJIFRiesgoCardiovascular;
    public JIFDigitacionDx xjifdigitaciondx;
    private int xidbodega;
    private JIF_Cierre_Caja xjif_cierre_caja;
    private JIFFServicioEmpresaConvenio xJIFFServicioEmpresaConvenio;
    private JIFFConsultarInformacionGenerico xJIFFConsultarInformacionGenerico;
    private JIFInformesNProgramadaRangoHora xJIFInformesNProgramadaRangoHora;
    private JIFListaFacturaVentas xJIFListaFacturaVentas;
    private JIFCensoCama xJIFCensoCama;
    private JIFConsultarIngresoSoat xJIFConsultarIngresoSoat;
    private JIFListaOrdenesInternas xJIFListaOrdenesInternas;
    public JPAEventoECastPacienteGasto jPAEventoECastPacienteGasto;
    private JIF_ConsultarIngresosPorLiquidacion jIF_ConsultarIngresosPorLiquidacion;
    private JIFAgendaTaquilla agendaTaquilla;
    private JIF_FacturacionAgil facturacionAgil;
    private JIFGestinDeFactura factura;
    private JDRadicacion dRadicacion;
    private JIF_Informacion_Facturas_Auditadas informacion_Facturas_Auditadas;
    private String noLiquidacion;
    private String factOrdenEps;
    private String factOrdenPaciente;
    private String fechaFactOrdEps;
    private String fechaFactOrdPaciente;
    private String estadoFactOrdenEps;
    private String estadoFactOrdenPaciente;
    private String xIdManual;
    private String xEsCapitado;
    private String xCValor;
    private String xFiltroProc;
    private String xIdTipoPlan;
    private String xId_Cx;
    private double xPCopago;
    private double xCModeradora;
    private double xTopeAtencion;
    private double xTopeAnual;
    private long xIdIngreso;
    private long xTipoEstrato;
    private long xIdEmpresa;
    private long xIdGIps;
    private long xIdPersona;
    private int xIdTipoAtencion;
    private int xMetodoFact;
    private int xRedondeo;
    public JIF_AgendaSimedis agendaSimedis;
    public JIF_AgendaSimedisBienestar agendaSimedisBienestar;
    private GPersona persona;
    private JIF_Reportes_PyP_Generico jifreportes;
    private String idCodigoInternoInterface;
    public String idSalida;
    private JIFGestion_Servicios jIFGestion_Servicios;

    @Generated
    public void setFrmPrincipal(Principal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }

    @Generated
    public void setFrmFacturac(Facturac frmFacturac) {
        this.frmFacturac = frmFacturac;
    }

    @Generated
    public void setXjifcambiargrupo(JIFCambiarGrupo xjifcambiargrupo) {
        this.xjifcambiargrupo = xjifcambiargrupo;
    }

    @Generated
    public void setConsultas(ConsultasMySQL consultas) {
        this.consultas = consultas;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    @Generated
    public void setCajaAbierta(int cajaAbierta) {
        this.cajaAbierta = cajaAbierta;
    }

    @Generated
    public void setXvalor(long xvalor) {
        this.xvalor = xvalor;
    }

    @Generated
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Generated
    public void setClasecaja(claseCaja clasecaja) {
        this.clasecaja = clasecaja;
    }

    @Generated
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    @Generated
    public void setXjifconsultard(JIFConsultarInfSum xjifconsultard) {
        this.xjifconsultard = xjifconsultard;
    }

    @Generated
    public void setXjifencuenta(JIFEncuestaS xjifencuenta) {
        this.xjifencuenta = xjifencuenta;
    }

    @Generated
    public void setXjifrelacionexameno(JIFRelacionExamenesO xjifrelacionexameno) {
        this.xjifrelacionexameno = xjifrelacionexameno;
    }

    @Generated
    public void setXjifregistroatencionesesp(JIFRegistroAtencionesEsp xjifregistroatencionesesp) {
        this.xjifregistroatencionesesp = xjifregistroatencionesesp;
    }

    @Generated
    public void setXjifinformecnprogramada(JIFInformesNProgramada xjifinformecnprogramada) {
        this.xjifinformecnprogramada = xjifinformecnprogramada;
    }

    @Generated
    public void setXjifreliquidacionfac(JIFReliquidacionFac xjifreliquidacionfac) {
        this.xjifreliquidacionfac = xjifreliquidacionfac;
    }

    @Generated
    public void setXjifrecepcionlab(RecepcionAuto xjifrecepcionlab) {
        this.xjifrecepcionlab = xjifrecepcionlab;
    }

    @Generated
    public void setXjifrecepcionlabBienestar(RecepcionAutoBienestarSalud xjifrecepcionlabBienestar) {
        this.xjifrecepcionlabBienestar = xjifrecepcionlabBienestar;
    }

    @Generated
    public void setXjifagendabienestar(AgendaBienestar xjifagendabienestar) {
        this.xjifagendabienestar = xjifagendabienestar;
    }

    @Generated
    public void setXjifsaturoizaciones(JIFSAutorizaciones xjifsaturoizaciones) {
        this.xjifsaturoizaciones = xjifsaturoizaciones;
    }

    @Generated
    public void setXjiconsultarRemOrd(JIFConsultarExamenesxUsuario xjiconsultarRemOrd) {
        this.xjiconsultarRemOrd = xjiconsultarRemOrd;
    }

    @Generated
    public void setXjiliqServicio(JIFLiqServicios xjiliqServicio) {
        this.xjiliqServicio = xjiliqServicio;
    }

    @Generated
    public void setXJIFInformesVarios(JIFInformesVarios xJIFInformesVarios) {
        this.xJIFInformesVarios = xJIFInformesVarios;
    }

    @Generated
    public void setXjifautorizacion_servicio(JIFAutorizacion_Servicios xjifautorizacion_servicio) {
        this.xjifautorizacion_servicio = xjifautorizacion_servicio;
    }

    @Generated
    public void setXgenerarcotizacion(JIFGenerarCotizacion xgenerarcotizacion) {
        this.xgenerarcotizacion = xgenerarcotizacion;
    }

    @Generated
    public void setXjifconsultar_infempresa(JIFInformacion_Empresa xjifconsultar_infempresa) {
        this.xjifconsultar_infempresa = xjifconsultar_infempresa;
    }

    @Generated
    public void setXJIFRiesgoObstetrico(JIFRiesgoObstetrico xJIFRiesgoObstetrico) {
        this.xJIFRiesgoObstetrico = xJIFRiesgoObstetrico;
    }

    @Generated
    public void setXJIFRiesgoCardiovascular(JIFRiesgoCardiovascular xJIFRiesgoCardiovascular) {
        this.xJIFRiesgoCardiovascular = xJIFRiesgoCardiovascular;
    }

    @Generated
    public void setXjifdigitaciondx(JIFDigitacionDx xjifdigitaciondx) {
        this.xjifdigitaciondx = xjifdigitaciondx;
    }

    @Generated
    public void setXjif_cierre_caja(JIF_Cierre_Caja xjif_cierre_caja) {
        this.xjif_cierre_caja = xjif_cierre_caja;
    }

    @Generated
    public void setXJIFFServicioEmpresaConvenio(JIFFServicioEmpresaConvenio xJIFFServicioEmpresaConvenio) {
        this.xJIFFServicioEmpresaConvenio = xJIFFServicioEmpresaConvenio;
    }

    @Generated
    public void setXJIFFConsultarInformacionGenerico(JIFFConsultarInformacionGenerico xJIFFConsultarInformacionGenerico) {
        this.xJIFFConsultarInformacionGenerico = xJIFFConsultarInformacionGenerico;
    }

    @Generated
    public void setXJIFInformesNProgramadaRangoHora(JIFInformesNProgramadaRangoHora xJIFInformesNProgramadaRangoHora) {
        this.xJIFInformesNProgramadaRangoHora = xJIFInformesNProgramadaRangoHora;
    }

    @Generated
    public void setXJIFListaFacturaVentas(JIFListaFacturaVentas xJIFListaFacturaVentas) {
        this.xJIFListaFacturaVentas = xJIFListaFacturaVentas;
    }

    @Generated
    public void setXJIFCensoCama(JIFCensoCama xJIFCensoCama) {
        this.xJIFCensoCama = xJIFCensoCama;
    }

    @Generated
    public void setXJIFConsultarIngresoSoat(JIFConsultarIngresoSoat xJIFConsultarIngresoSoat) {
        this.xJIFConsultarIngresoSoat = xJIFConsultarIngresoSoat;
    }

    @Generated
    public void setXJIFListaOrdenesInternas(JIFListaOrdenesInternas xJIFListaOrdenesInternas) {
        this.xJIFListaOrdenesInternas = xJIFListaOrdenesInternas;
    }

    @Generated
    public void setJPAEventoECastPacienteGasto(JPAEventoECastPacienteGasto jPAEventoECastPacienteGasto) {
        this.jPAEventoECastPacienteGasto = jPAEventoECastPacienteGasto;
    }

    @Generated
    public void setJIF_ConsultarIngresosPorLiquidacion(JIF_ConsultarIngresosPorLiquidacion jIF_ConsultarIngresosPorLiquidacion) {
        this.jIF_ConsultarIngresosPorLiquidacion = jIF_ConsultarIngresosPorLiquidacion;
    }

    @Generated
    public void setAgendaTaquilla(JIFAgendaTaquilla agendaTaquilla) {
        this.agendaTaquilla = agendaTaquilla;
    }

    @Generated
    public void setFacturacionAgil(JIF_FacturacionAgil facturacionAgil) {
        this.facturacionAgil = facturacionAgil;
    }

    @Generated
    public void setFactura(JIFGestinDeFactura factura) {
        this.factura = factura;
    }

    @Generated
    public void setDRadicacion(JDRadicacion dRadicacion) {
        this.dRadicacion = dRadicacion;
    }

    @Generated
    public void setInformacion_Facturas_Auditadas(JIF_Informacion_Facturas_Auditadas informacion_Facturas_Auditadas) {
        this.informacion_Facturas_Auditadas = informacion_Facturas_Auditadas;
    }

    @Generated
    public void setXId_Cx(String xId_Cx) {
        this.xId_Cx = xId_Cx;
    }

    @Generated
    public void setAgendaSimedis(JIF_AgendaSimedis agendaSimedis) {
        this.agendaSimedis = agendaSimedis;
    }

    @Generated
    public void setAgendaSimedisBienestar(JIF_AgendaSimedisBienestar agendaSimedisBienestar) {
        this.agendaSimedisBienestar = agendaSimedisBienestar;
    }

    @Generated
    public void setJifreportes(JIF_Reportes_PyP_Generico jifreportes) {
        this.jifreportes = jifreportes;
    }

    @Generated
    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    @Generated
    public void setJIFGestion_Servicios(JIFGestion_Servicios jIFGestion_Servicios) {
        this.jIFGestion_Servicios = jIFGestion_Servicios;
    }

    @Generated
    public Principal getFrmPrincipal() {
        return this.frmPrincipal;
    }

    @Generated
    public Facturac getFrmFacturac() {
        return this.frmFacturac;
    }

    @Generated
    public JIFCambiarGrupo getXjifcambiargrupo() {
        return this.xjifcambiargrupo;
    }

    @Generated
    public ConsultasMySQL getConsultas() {
        return this.consultas;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public int getModulo() {
        return this.modulo;
    }

    @Generated
    public int getCajaAbierta() {
        return this.cajaAbierta;
    }

    @Generated
    public long getXvalor() {
        return this.xvalor;
    }

    @Generated
    public String getSql() {
        return this.sql;
    }

    @Generated
    public claseCaja getClasecaja() {
        return this.clasecaja;
    }

    @Generated
    public ResultSet getRs() {
        return this.rs;
    }

    @Generated
    public JIFConsultarInfSum getXjifconsultard() {
        return this.xjifconsultard;
    }

    @Generated
    public JIFEncuestaS getXjifencuenta() {
        return this.xjifencuenta;
    }

    @Generated
    public JIFRelacionExamenesO getXjifrelacionexameno() {
        return this.xjifrelacionexameno;
    }

    @Generated
    public JIFRegistroAtencionesEsp getXjifregistroatencionesesp() {
        return this.xjifregistroatencionesesp;
    }

    @Generated
    public JIFInformesNProgramada getXjifinformecnprogramada() {
        return this.xjifinformecnprogramada;
    }

    @Generated
    public JIFReliquidacionFac getXjifreliquidacionfac() {
        return this.xjifreliquidacionfac;
    }

    @Generated
    public RecepcionAuto getXjifrecepcionlab() {
        return this.xjifrecepcionlab;
    }

    @Generated
    public RecepcionAutoBienestarSalud getXjifrecepcionlabBienestar() {
        return this.xjifrecepcionlabBienestar;
    }

    @Generated
    public AgendaBienestar getXjifagendabienestar() {
        return this.xjifagendabienestar;
    }

    @Generated
    public JIFSAutorizaciones getXjifsaturoizaciones() {
        return this.xjifsaturoizaciones;
    }

    @Generated
    public JIFConsultarExamenesxUsuario getXjiconsultarRemOrd() {
        return this.xjiconsultarRemOrd;
    }

    @Generated
    public JIFLiqServicios getXjiliqServicio() {
        return this.xjiliqServicio;
    }

    @Generated
    public JIFInformesVarios getXJIFInformesVarios() {
        return this.xJIFInformesVarios;
    }

    @Generated
    public JIFAutorizacion_Servicios getXjifautorizacion_servicio() {
        return this.xjifautorizacion_servicio;
    }

    @Generated
    public JIFGenerarCotizacion getXgenerarcotizacion() {
        return this.xgenerarcotizacion;
    }

    @Generated
    public JIFInformacion_Empresa getXjifconsultar_infempresa() {
        return this.xjifconsultar_infempresa;
    }

    @Generated
    public JIFRiesgoObstetrico getXJIFRiesgoObstetrico() {
        return this.xJIFRiesgoObstetrico;
    }

    @Generated
    public JIFRiesgoCardiovascular getXJIFRiesgoCardiovascular() {
        return this.xJIFRiesgoCardiovascular;
    }

    @Generated
    public JIFDigitacionDx getXjifdigitaciondx() {
        return this.xjifdigitaciondx;
    }

    @Generated
    public JIF_Cierre_Caja getXjif_cierre_caja() {
        return this.xjif_cierre_caja;
    }

    @Generated
    public JIFFServicioEmpresaConvenio getXJIFFServicioEmpresaConvenio() {
        return this.xJIFFServicioEmpresaConvenio;
    }

    @Generated
    public JIFFConsultarInformacionGenerico getXJIFFConsultarInformacionGenerico() {
        return this.xJIFFConsultarInformacionGenerico;
    }

    @Generated
    public JIFInformesNProgramadaRangoHora getXJIFInformesNProgramadaRangoHora() {
        return this.xJIFInformesNProgramadaRangoHora;
    }

    @Generated
    public JIFListaFacturaVentas getXJIFListaFacturaVentas() {
        return this.xJIFListaFacturaVentas;
    }

    @Generated
    public JIFCensoCama getXJIFCensoCama() {
        return this.xJIFCensoCama;
    }

    @Generated
    public JIFConsultarIngresoSoat getXJIFConsultarIngresoSoat() {
        return this.xJIFConsultarIngresoSoat;
    }

    @Generated
    public JIFListaOrdenesInternas getXJIFListaOrdenesInternas() {
        return this.xJIFListaOrdenesInternas;
    }

    @Generated
    public JPAEventoECastPacienteGasto getJPAEventoECastPacienteGasto() {
        return this.jPAEventoECastPacienteGasto;
    }

    @Generated
    public JIF_ConsultarIngresosPorLiquidacion getJIF_ConsultarIngresosPorLiquidacion() {
        return this.jIF_ConsultarIngresosPorLiquidacion;
    }

    @Generated
    public JIFAgendaTaquilla getAgendaTaquilla() {
        return this.agendaTaquilla;
    }

    @Generated
    public JIF_FacturacionAgil getFacturacionAgil() {
        return this.facturacionAgil;
    }

    @Generated
    public JIFGestinDeFactura getFactura() {
        return this.factura;
    }

    @Generated
    public JDRadicacion getDRadicacion() {
        return this.dRadicacion;
    }

    @Generated
    public JIF_Informacion_Facturas_Auditadas getInformacion_Facturas_Auditadas() {
        return this.informacion_Facturas_Auditadas;
    }

    @Generated
    public String getXId_Cx() {
        return this.xId_Cx;
    }

    @Generated
    public JIF_AgendaSimedis getAgendaSimedis() {
        return this.agendaSimedis;
    }

    @Generated
    public JIF_AgendaSimedisBienestar getAgendaSimedisBienestar() {
        return this.agendaSimedisBienestar;
    }

    @Generated
    public JIF_Reportes_PyP_Generico getJifreportes() {
        return this.jifreportes;
    }

    @Generated
    public String getIdSalida() {
        return this.idSalida;
    }

    @Generated
    public JIFGestion_Servicios getJIFGestion_Servicios() {
        return this.jIFGestion_Servicios;
    }

    public claseFacturacion(Principal frmP, int xmodulo, int cajaabierta, claseCaja claseC) {
        this.frmPrincipal = null;
        this.frmFacturac = null;
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xaplicaencuesta = 1;
        this.xrecepcionalaboratorio = 1;
        this.xeslab = 0;
        this.xlugarprocesamiento = 0;
        this.xCargarAutorizacion = 0;
        this.xId_Rechazo = 0L;
        this.xgrabadofact = false;
        this.xjifencuenta = null;
        this.xidbodega = 0;
        this.xIdManual = "";
        this.xEsCapitado = "";
        this.xCValor = "";
        this.xFiltroProc = "";
        this.xIdTipoPlan = "";
        this.xId_Cx = "";
        this.xPCopago = 0.0d;
        this.xCModeradora = 0.0d;
        this.xTopeAtencion = 0.0d;
        this.xTopeAnual = 0.0d;
        this.xTipoEstrato = 0L;
        this.xIdEmpresa = 0L;
        this.xIdGIps = 0L;
        this.xIdPersona = 0L;
        this.xIdTipoAtencion = 0;
        this.idSalida = "";
        this.frmPrincipal = frmP;
        this.clasecaja = claseC;
        this.modulo = xmodulo;
        this.cajaAbierta = cajaabierta;
        this.persona = new GPersona();
        if (cajaabierta == 1) {
            Menus menus = this.frmPrincipal.xMenus;
            Menus.JMFCaja.setEnabled(false);
        }
    }

    public claseFacturacion() {
        this.frmPrincipal = null;
        this.frmFacturac = null;
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xaplicaencuesta = 1;
        this.xrecepcionalaboratorio = 1;
        this.xeslab = 0;
        this.xlugarprocesamiento = 0;
        this.xCargarAutorizacion = 0;
        this.xId_Rechazo = 0L;
        this.xgrabadofact = false;
        this.xjifencuenta = null;
        this.xidbodega = 0;
        this.xIdManual = "";
        this.xEsCapitado = "";
        this.xCValor = "";
        this.xFiltroProc = "";
        this.xIdTipoPlan = "";
        this.xId_Cx = "";
        this.xPCopago = 0.0d;
        this.xCModeradora = 0.0d;
        this.xTopeAtencion = 0.0d;
        this.xTopeAnual = 0.0d;
        this.xTipoEstrato = 0L;
        this.xIdEmpresa = 0L;
        this.xIdGIps = 0L;
        this.xIdPersona = 0L;
        this.xIdTipoAtencion = 0;
        this.idSalida = "";
    }

    public void mInicar_Variables_Ingreso(String xid_ingreso) {
        try {
            this.sql = "SELECT  `f_empresacontxconvenio`.`Id_Manual` , `f_empresacontxconvenio`.`EsCapitado` , `f_empresacontxconvenio`.`CualValor` , `f_empresacontxconvenio`.`FiltroProcxEmp`, `g_empresacont`.`Id_TipoPlan`, f_empresacontxconvenio.Id  , `f_estratoxemprcontconv`.`PorcSubsidio`, `f_estratoxemprcontconv`.`ValorMaximo` , `ingreso`.`SiCopago`, ingreso.`Id_TipoAtencion`, IF(f_v_datos_liquidacion_fac.IdLiquidacion IS NULL, 0,f_v_datos_liquidacion_fac.IdLiquidacion) AS IdLiquidacion, `f_estratoxemprcontconv`.`TopeAtencion` , `f_estratoxemprcontconv`.`ToPeAnual`, f_empresacontxconvenio.Id_GIps, ingreso.Id_Usuario ,f_empresacontxconvenio.MetodoFact, f_empresacontxconvenio.Redondeo   FROM `ingreso` INNER JOIN `baseserver`.`f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN `f_estrato`  ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`) INNER JOIN `profesional1`  ON (`ingreso`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) AND (`ingreso`.`Id_Profesional` = `profesional1`.`Id_Persona`) INNER JOIN `g_tipoatencion`   ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) INNER JOIN `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `f_estrato`.`Id`) LEFT JOIN `f_v_datos_liquidacion_fac`  ON (`ingreso`.`Id` = `f_v_datos_liquidacion_fac`.`Id_Ingreso`)   WHERE (`ingreso`.`Id` ='" + xid_ingreso + "' AND `ingreso`.`Estado`=0) ORDER BY `ingreso`.`FechaIngreso` DESC,`ingreso`.`HoraIngreso` DESC  ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        setxIdManual(xrs.getString("Id_Manual"));
                        setxEsCapitado(xrs.getString("EsCapitado"));
                        setxCValor(xrs.getString("CualValor"));
                        setxFiltroProc(xrs.getString("FiltroProcxEmp"));
                        setxIdTipoPlan(xrs.getString("Id_TipoPlan"));
                        setxIdEmpresa(xrs.getLong("Id"));
                        setxPCopago(xrs.getDouble("PorcSubsidio"));
                        setxTopeAtencion(xrs.getDouble("TopeAtencion"));
                        setxTopeAnual(xrs.getDouble("TopeAnual"));
                        setxCModeradora(xrs.getDouble("ValorMaximo"));
                        setxTipoEstrato(xrs.getLong("SiCopago"));
                        setNoLiquidacion(xrs.getString("IdLiquidacion"));
                        setxIdTipoAtencion(xrs.getInt("Id_TipoAtencion"));
                        setxIdGIps(xrs.getLong("Id_GIps"));
                        setxIdPersona(xrs.getLong("Id_Usuario"));
                        setxMetodoFact(xrs.getInt("MetodoFact"));
                        setxRedondeo(xrs.getInt("Redondeo"));
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiqServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public ResultSet mBuscarLiquidacion(String noIngreso) {
        this.sql = "SELECT f_liquidacion.Id , f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps, f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, f_liquidacion.CuotaModeradora, f_liquidacion.Copago, f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre AS GrupoServicio, f_subgruposervicio.Id_SubgrupoServicio, f_subgruposervicio.Nbre AS SubGrupoServicio, f_liquidacion.Observacion FROM f_liquidacion INNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  AND (f_subgrupo_empresa.Id_Empresa = ingreso.Id_EmpresaContxConv)  INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (ingreso.Id =" + noIngreso + " AND f_liquidacion.Estado =0) ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        return rs;
    }

    public ResultSet mbuscarFacturas(String noIngreso) {
        if (getxEsCapitado().equals("2")) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.sql = "SELECT IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento_M, \tCONCAT(f_factura_evento.Prefijo,'-',f_factura_evento.No_FacturaEvento_M) ) AS No_Factura , DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS Fecha_Factura , f_factura_evento.TipoFactura , IF(f_factura_evento.Estado=0,'ACTIVA','') AS Estado, f_factura_evento.EstaArmada  FROM  f_factura_evento INNER JOIN  f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) WHERE ( f_factura_evento.Estado =0 AND f_liquidacion.Id_Ingreso=" + noIngreso + ")";
            } else {
                this.sql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_Factura , DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS Fecha_Factura , f_factura_evento.TipoFactura , IF(f_factura_evento.Estado=0,'ACTIVA','') AS Estado, f_factura_evento.EstaArmada  FROM  f_factura_evento INNER JOIN  f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE ( f_factura_evento.Estado =0 AND f_liquidacion.Id_Ingreso=" + noIngreso + ")";
            }
        } else {
            this.sql = "SELECT f_factura_capita.No_FacturaCapita AS No_Factura , DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS Fecha_Factura ,f_factura_capita.TipoFactura , IF(f_factura_capita.Estado=0,'ACTIVA','') AS Estado,f_factura_capita.EstaArmada FROM  f_factura_capita INNER JOIN  f_liquidacion ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) WHERE ( f_factura_capita.Estado =0 AND f_liquidacion.Id_Ingreso=" + noIngreso + ")";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        return rs;
    }

    public void mGrabarLiquidacion(String Id_Ingreso, String TotalServicio, String TotalPlan, String TotalEps, String TotalDescuento, String TotalPaciente, String CuotaModeradora, String Copago, String Id_SubGrupoServicio, String IdEmpresaContxConv, String Observacion, String Id_UsuarioRH, String Fecha, String UsuarioS) {
        this.sql = " (Id_Ingreso, TotalServicio,TotalPlan, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, Observacion, NEquipo, DireccionIp, Id_UsuarioRH,   Fecha, UsuarioS) VALUES (" + Id_Ingreso + "," + TotalServicio + "," + TotalPlan + "," + TotalEps + "," + TotalDescuento + "," + TotalPaciente + "," + CuotaModeradora + "," + Copago + "," + Id_SubGrupoServicio + ",'" + IdEmpresaContxConv + "','" + Observacion + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','" + Id_UsuarioRH + "','" + Fecha + "','" + UsuarioS + "')";
        setNoLiquidacion(this.consultas.ejecutarSQLId(this.sql));
    }

    public void mGrabarFacturaUOrden(String Fecha_Factura, String Prefijo, long No_FacturaEvento_M, String Id_Liquidacion, int TipoFactura, String Fecha, String UsuarioS) {
        if (getxEsCapitado().equals("2")) {
            this.sql = "INSERT INTO f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M,  Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + Fecha_Factura + "','" + Prefijo + "','" + No_FacturaEvento_M + "'," + Id_Liquidacion + "," + TipoFactura + ",'" + Fecha + "','" + UsuarioS + "')";
            if (TipoFactura == 0) {
                setFactOrdenEps(this.consultas.ejecutarSQLId(this.sql));
                this.consultas.cerrarConexionBd();
                setEstadoFactOrdenEps("ACTIVA");
                setFechaFactOrdEps(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
                return;
            }
            setFactOrdenPaciente(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            setEstadoFactOrdenPaciente("ACTIVA");
            setFechaFactOrdPaciente(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
            return;
        }
        this.sql = "INSERT INTO f_factura_capita(Fecha_FacturaCapita, Id_Liquidacion, TipoFactura, Fecha, UsuarioS) VALUES('" + Fecha_Factura + "'," + Id_Liquidacion + "," + TipoFactura + ",'" + Fecha + "','" + UsuarioS + "')";
        if (TipoFactura == 0) {
            setFactOrdenEps(this.consultas.ejecutarSQLId(this.sql));
            this.consultas.cerrarConexionBd();
            setEstadoFactOrdenEps("ACTIVA");
            setFechaFactOrdEps(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
            return;
        }
        setFactOrdenPaciente(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        setEstadoFactOrdenPaciente("ACTIVA");
        setFechaFactOrdPaciente(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
    }

    public void anular(String frm) {
        switch (frm) {
            case "Facturac":
            case "Facturac1":
                if (!Principal.txtNo.getText().isEmpty()) {
                    this.frmFacturac.anular();
                    break;
                }
                break;
            case "jifLiqServicios":
                switch (this.xjiliqServicio.JPnVentana.getComponent(0).getName()) {
                    case "xjprocedimientos":
                        this.xjiliqServicio.xjpprocedimiento.mAnular();
                        break;
                    case "xjp_consolidadon":
                        this.xjiliqServicio.xjpconsolidado.mAnular();
                        break;
                    case "xEgresoFact":
                        this.xjiliqServicio.xJPEgresoUrgencias.mAnular();
                        break;
                    case "xjp_quirurgico":
                        this.xjiliqServicio.xJPQuirurgico.mAnular();
                        break;
                    case "xjpglosa":
                        this.xjiliqServicio.xJPGlosa.mAnular();
                        break;
                    case "xjpingresoseguimientos":
                        this.xjiliqServicio.xJPIngresoSeguimientos.mAnular();
                        break;
                    case "xjpordensalidaingreso":
                        this.xjiliqServicio.xJPOrdenSalidaIngreso.anular();
                        break;
                    case "xjphojatratamiento1":
                        this.xjiliqServicio.xJPHojaTratamiento.mAnular();
                        break;
                    case "JPAEventoECastPacienteGasto":
                        this.xjiliqServicio.jPAEventoECastPacienteGasto.anular();
                        break;
                    case "jpSalidaAdministrativa":
                        this.xjiliqServicio.ingresoSalidaAdministrativa.anular();
                        break;
                    case "jpi_ingresoAnexo1":
                        this.xjiliqServicio.formularioAnexo1.anular();
                        break;
                }
                break;
            case "xjifautorizacion_servicios":
                this.xjifautorizacion_servicio.mAnular();
                break;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00d1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:20:0x00d1 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00d6: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x00d6 */
    public String mCrearTercero_GEmpresa(String xIdPersona, String xTipoDOc, String xDocumento) {
        String xIdTercero = "";
        try {
            try {
                this.sql = "SELECT  `Id` FROM `g_empresa`\nWHERE (`No_identificacion` ='" + xDocumento + "'   AND `Id_TipoIdentificacion` ='" + xTipoDOc + "')";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    xIdTercero = xrs.getString("Id");
                } else {
                    this.sql = "INSERT INTO g_empresa (Id_TipoIdentificacion, No_identificacion, Dig_Verificacion, Id_Municipio, Direccion, Tel_Numero, Eps, Id_Persona, TipoPersona,Apellido1, Apellido2, Nombre1, Nombre2,Id_ClasificacionT, Fecha, UsuarioS) \nSELECT `g_persona`.`Id_TipoIdentificacion` , `g_persona`.`NoDocumento`  , ''  , `g_persona`.`Id_Municipio`  , `g_persona`.`Direccion` , `g_persona`.`Telefono` , 0 , `g_persona`.`Id` , 1 , `g_persona`.`Apellido1` , `g_persona`.`Apellido2` , `g_persona`.`Nombre1`  , `g_persona`.`Nombre2` , 1 , NOW(), '" + Principal.usuarioSistemaDTO.getLogin() + "'\nFROM `g_usuario`  INNER JOIN   `g_persona`   ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`g_persona`.`Id` ='" + xIdPersona + "')";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    xIdTercero = xct.ejecutarSQLId(this.sql);
                    xct.cerrarConexionBd();
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
            Logger.getLogger(claseFacturacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xIdTercero;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x009a: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:20:0x009a */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x009e: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x009e */
    public String mCrearConvenioGenerico(String idTercero) {
        String idConvenio = "";
        try {
            try {
                this.sql = "SELECT     `Id`     , `Id_EmpresaCont`     , `Nbre`  FROM     `baseserver`.`f_empresacontxconvenio` WHERE (`Id_EmpresaCont` ='" + idTercero + "' AND estado=0);";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    idConvenio = xrs.getString("Id");
                } else {
                    this.sql = "";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    idConvenio = xct.ejecutarSQLId(this.sql);
                    xct.cerrarConexionBd();
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
            Logger.getLogger(claseFacturacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idConvenio;
    }

    public void mImprimir_Factura(String xreporte, String valor, int opc) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "usuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (opc == 1) {
            mparametros[2][0] = "valorletra";
            mparametros[2][1] = valor;
        }
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + xreporte, mparametros);
    }

    public void mImprimir_Factura_Relacion(String nIngreso, String xCCobro, String valor, String Id_Factura, String N_Ips, String xCCobroC) {
        if (Principal.informacionIps.getAplicaFacturaElectronica().booleanValue()) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.visualizarFacturasEventoMetodoPrinicpal(nIngreso, "0", "0", "0", "0", "0", "0", 1, 0);
            return;
        }
        new convertirNumerosLetras();
        if (!nIngreso.equals("0")) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "idingreso";
            mparametros[0][1] = nIngreso;
            mparametros[1][0] = "usuario";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[2][0] = "id_factura";
            mparametros[2][1] = Id_Factura;
            mparametros[3][0] = "valorletra";
            mparametros[3][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
            mparametros[4][0] = "SUBREPORT_DIR";
            mparametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[5][0] = "SUBREPORTFIRMA_DIR";
            mparametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (N_Ips.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips.equals("JAIME CESAR DAJUD FERNANDEZ")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_Liquidacion_Servicios_Dajud_Anulada", mparametros);
                return;
            }
            if (N_Ips.equals("COD-OPTICA UT")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_Liquidacion_Servicios_Dajud_UMT_Anulada", mparametros);
                return;
            }
            if (N_Ips.equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || N_Ips.equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_Liquidacion_Servicios_Psiquiatras", mparametros);
                return;
            }
            if (N_Ips.equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                mImprimir_Factura("F_Liquidacion_Servicios_Radiologos_Asociados", this.metodos.mConvertirNumeroLetras(valor.replace(".", ",")), 1);
                return;
            }
            if (N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S.S") || N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_Liquidacion_Servicios", mparametros);
                return;
            }
            if (N_Ips.equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
                return;
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_Liquidacion_Servicios_Psiquiatras", mparametros);
                return;
            }
        }
        if (N_Ips.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips.equals("JAIME CESAR DAJUD FERNANDEZ")) {
            if (xCCobroC.equals("0")) {
                String[][] mparametros2 = new String[5][2];
                mparametros2[0][0] = "id_factura";
                mparametros2[0][1] = Id_Factura;
                mparametros2[1][0] = "UsuarioS";
                mparametros2[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros2[2][0] = "nvalor";
                mparametros2[2][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
                mparametros2[3][0] = "SUBREPORT_DIR";
                mparametros2[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros2[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaDianConsolidada1_F3_Dajud", mparametros2);
                return;
            }
            String[][] mparametros3 = new String[5][2];
            mparametros3[0][0] = "id_factura";
            mparametros3[0][1] = Id_Factura;
            mparametros3[1][0] = "UsuarioS";
            mparametros3[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros3[2][0] = "nvalor";
            mparametros3[2][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
            mparametros3[3][0] = "SUBREPORT_DIR";
            mparametros3[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros3[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros3[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "CC_FacturaDianConsolidada1_F3_Dajud", mparametros3);
            return;
        }
        if (N_Ips.equals("COD-OPTICA UT")) {
            String[][] mparametros4 = new String[4][2];
            mparametros4[0][0] = "id_factura";
            mparametros4[0][1] = Id_Factura;
            mparametros4[1][0] = "valorletra";
            mparametros4[1][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
            mparametros4[2][0] = "SUBREPORT_DIR";
            mparametros4[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros4[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros4[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaDianConsolidada1_F3_UMT", mparametros4);
            return;
        }
        if (N_Ips.equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            String[][] mparametros5 = new String[4][2];
            mparametros5[0][0] = "idcuenta";
            mparametros5[0][1] = xCCobro;
            mparametros5[1][0] = "valorletra";
            mparametros5[1][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
            mparametros5[2][0] = "SUBREPORT_DIR";
            mparametros5[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros5[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros5[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaDianConsolidada1_LFonnegra", mparametros5);
            return;
        }
        String[][] mparametros6 = new String[5][2];
        mparametros6[0][0] = "id_factura";
        mparametros6[0][1] = Id_Factura;
        mparametros6[1][0] = "UsuarioS";
        mparametros6[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros6[2][0] = "nvalor";
        mparametros6[2][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
        mparametros6[3][0] = "SUBREPORT_DIR";
        mparametros6[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros6[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros6[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "CC_F_FacturaDianConsolidada", mparametros6);
    }

    public void mImprimir_Autorizacion(String xreporte, String xId_Ingreso) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = xId_Ingreso;
        mparametros[1][0] = "usuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + xreporte, mparametros);
    }

    public void actualizarOrden(String idOrden, Long totalOrden, String idTipoPlan) {
        long tEps = 0;
        long tPaciente = 0;
        if (idTipoPlan.equals(this.frmFacturac.frmIngreso.getIdTipoPlanEmpresa())) {
            tEps = totalOrden.longValue();
        } else {
            tPaciente = totalOrden.longValue();
        }
        this.sql = "UPDATE f_ordenes SET TotalOrdenes =" + totalOrden + ", TotalEPS =" + tEps + ", TotalPaciente =" + tPaciente + "WHERE Id = " + idOrden;
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void buscar(String frm) {
        switch (frm) {
            case "Facturac":
            case "Facturac1":
                this.frmFacturac.buscar();
                break;
            case "jifdigitaciondx1":
                this.xjifdigitaciondx.mBuscar();
                break;
            case "jifGestionSolicitudes":
                this.jIFGestion_Servicios.buscar();
                break;
            case "jif_facturas_auditadas":
                this.informacion_Facturas_Auditadas.buscar();
                break;
            case "xjifexamenocupacional":
                this.xjifrelacionexameno.mBuscar();
                break;
            case "jifconsultardespacho":
                this.xjifconsultard.mBuscar();
                break;
            case "jifatencionesnpfac1":
                this.xjifinformecnprogramada.mBuscar();
                break;
            case "xjifsautorizaciones":
                this.xjifsaturoizaciones.mBuscar();
                break;
            case "jifinformesvarios":
                this.xJIFInformesVarios.mBuscar();
                break;
            case "xjifconsulta_informacion_proc":
            case "xjifconsulta_informacion_1":
            case "xjifconsulta_informacion_3":
            case "xjifconsulta_informacion_Hosp":
                this.xjifconsultar_infempresa.mBuscar();
                break;
            case "xjiflistafacturasventa":
                this.xJIFListaFacturaVentas.mBuscar();
                break;
            case "xjif_cierre_caja":
                this.xjif_cierre_caja.mBuscar();
                break;
            case "jifLiqServicios":
                this.xjiliqServicio.mBuscar();
                break;
            case "xJIFRiesgoObstetrico":
                this.xJIFRiesgoObstetrico.mBuscar();
                break;
            case "xJIFRiesgoCardiovascular":
                this.xJIFRiesgoCardiovascular.mBuscar();
                break;
            case "xJIFFServicioEmpresaConvenio":
                this.xJIFFServicioEmpresaConvenio.mBuscar();
                break;
            case "informeAutorizacion":
                this.xJIFFConsultarInformacionGenerico.mBuscar();
                break;
            case "consolDescuenNomina":
                this.xJIFFConsultarInformacionGenerico.mBuscar();
                break;
            case "jifatencionesnpfachora":
                this.xJIFInformesNProgramadaRangoHora.mBuscar();
                break;
            case "xjifconsultaringresossoat":
                this.xJIFConsultarIngresoSoat.mBuscar();
                break;
            case "xjiflistaordenesinternas":
                this.xJIFListaOrdenesInternas.mBuscar();
                break;
            case "jifConsultarIngresosLiquidacion":
                this.jIF_ConsultarIngresosPorLiquidacion.buscar();
                break;
            case "xJIFFacturacionAgil":
                this.facturacionAgil.buscar();
                break;
            case "jmiInformesGeneralesFac":
                this.jifreportes.mBuscar();
                break;
        }
    }

    public void mImprimir(String frm) {
        switch (frm) {
            case "xjifexamenocupacional":
                this.xjifrelacionexameno.mImprimir();
                break;
            case "xjifconsulta_informacion_3":
                this.xjifconsultar_infempresa.mImprimir();
                break;
            case "xjiflistafacturasventa":
                this.xJIFListaFacturaVentas.mImprimir();
                break;
            case "Facturac":
                if (Principal.informacionIps.getIdentificacion().equals("900549914")) {
                    if (!Principal.txtNo.getText().isEmpty()) {
                        String[][] parametros = new String[1][2];
                        parametros[0][0] = "idRecepcion";
                        parametros[0][1] = Principal.txtNo.getText();
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_ListadoProcedimientosFacturados_IdIngreso", parametros, "F_ListadoProcedimientosFacturados_IdIngreso");
                    }
                    break;
                } else {
                    mImprimirListaChequeoSo();
                    mImprimirCertificadoA();
                    break;
                }
                break;
            case "jifcambiardatosliquidacion":
                this.xjifcambiargrupo.mImprimir();
                break;
            case "jifreliquidacionfactura2":
                this.xjifreliquidacionfac.mImprimir();
                break;
            case "jifLiqServicios":
                switch (this.xjiliqServicio.JPnVentana.getComponent(0).getName()) {
                    case "xjp_consolidadon":
                        this.xjiliqServicio.xjpconsolidado.mImprimir();
                        break;
                    case "xjp_impresion_doc":
                        this.xjiliqServicio.xJPImpresion_Doc.mImprimir();
                        break;
                    case "xjpordensalidaingreso":
                        this.xjiliqServicio.xJPOrdenSalidaIngreso.mImprimir();
                        break;
                    case "xjpi_formulaanexo3":
                        this.xjiliqServicio.formularioAnexo3.imprimir();
                        break;
                    case "jpi_formulario_anexo2":
                        this.xjiliqServicio.formularioAnexo2.imprimir();
                        break;
                    case "xjphojatratamiento1":
                        this.xjiliqServicio.xJPHojaTratamiento.mImprimir();
                        break;
                    case "xjpaplicaciontto":
                        this.xjiliqServicio.xjpaplicaciontto.imprimirInsumo();
                        break;
                    case "jpi_ingresoAnexo1":
                        this.xjiliqServicio.formularioAnexo1.imprimir();
                        break;
                    case "xjpi_formulaanexo3Res2335":
                        this.xjiliqServicio.formularioAnexo3Res2335.imprimir();
                        break;
                    case "jpremisiones":
                        this.xjiliqServicio.imprimir("Remisiones");
                        break;
                }
                break;
            case "xjifautorizacion_servicios":
                this.xjifautorizacion_servicio.mImprimir();
                break;
            case "jifatencionesnpfachora":
                this.xJIFInformesNProgramadaRangoHora.mImprimir();
                break;
            case "xjifcensocama2":
                this.xJIFCensoCama.mImprimir();
                break;
            case "xjifrecepcionlab":
                this.xjifrecepcionlab.imprimir();
                break;
            case "xJIFFacturacionAgil":
                this.facturacionAgil.imprimir();
                break;
        }
    }

    public void cargarPantalla(String frm, String xid_persona, String xid, JIF_Programacion_Cx xjif_cx1, String xid_Ingreso, Integer idClaseCita) {
        if (frm.equals("Ingreso_Cx")) {
            this.xjiliqServicio = new JIFLiqServicios(xid_persona, xid, xjif_cx1, xid_Ingreso, idClaseCita);
            Principal.cargarPantalla(this.xjiliqServicio);
        }
    }

    public void cargarPantalla(String frm, long xIdIgreso) {
        if (frm.equals("Generador de Autorizacion de Servicios")) {
            this.xjifautorizacion_servicio = new JIFAutorizacion_Servicios(xIdIgreso, 0, "xjifautorizacion_servicios", "", "");
            Principal.cargarPantalla(this.xjifautorizacion_servicio);
        }
    }

    public void cargarPantalla(String frm, String idOrdenSimedis) {
        if (frm.equals("Facturac")) {
            this.frmFacturac = new Facturac(this, this.cajaAbierta, this.clasecaja, idOrdenSimedis, "");
            Principal.cargarPantalla(this.frmFacturac);
        }
    }

    public void cargarPantalla(String frm, String idOrdenSimedis, String NombreConvenio) {
        if (frm.equals("Facturac")) {
            this.frmFacturac = new Facturac(this, this.cajaAbierta, this.clasecaja, idOrdenSimedis, NombreConvenio);
            Principal.cargarPantalla(this.frmFacturac);
        }
    }

    public void cargarPantalla1(String frm, int n, String idOrdenSimedis, Long IdordenInternaGIIS, String Obsevacion, String numeroGestion) {
        if (frm.equals("Recepcion Laboratorio")) {
            if (this.xjifrecepcionlab != null) {
                this.xjifrecepcionlab.dispose();
            }
            this.xjifrecepcionlab = new RecepcionAuto("xjifrecepcionlab", 1, idOrdenSimedis, IdordenInternaGIIS, Obsevacion, numeroGestion);
            Principal.cargarPantalla(this.xjifrecepcionlab);
            return;
        }
        if (frm.equals("RecepcionAutoBienestarSalud")) {
            this.xjifrecepcionlabBienestar = new RecepcionAutoBienestarSalud("xjifrecepcionlabBienestar", 1, idOrdenSimedis, IdordenInternaGIIS, Obsevacion);
            Principal.cargarPantalla(this.xjifrecepcionlabBienestar);
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Facturac":
                this.frmFacturac = new Facturac(this, this.cajaAbierta, this.clasecaja);
                Principal.cargarPantalla(this.frmFacturac);
                break;
            case "Consultar Auditoria Por Factura":
                this.informacion_Facturas_Auditadas = new JIF_Informacion_Facturas_Auditadas();
                Principal.cargarPantalla(this.informacion_Facturas_Auditadas);
                break;
            case "Gestión Solicitudes Servicio":
                this.jIFGestion_Servicios = new JIFGestion_Servicios("jifGestionSolicitudes");
                Principal.cargarPantalla(this.jIFGestion_Servicios);
                break;
            case "AgendaSimedis":
                this.agendaSimedis = new JIF_AgendaSimedis();
                Principal.cargarPantalla(this.agendaSimedis);
                break;
            case "AgendaSimedisBienestar":
                this.agendaSimedisBienestar = new JIF_AgendaSimedisBienestar();
                Principal.cargarPantalla(this.agendaSimedisBienestar);
                break;
            case "Consultar Ingresos por Liquidación":
                this.jIF_ConsultarIngresosPorLiquidacion = new JIF_ConsultarIngresosPorLiquidacion();
                Principal.cargarPantalla(this.jIF_ConsultarIngresosPorLiquidacion);
                break;
            case "Digitación Manual":
                this.xjifdigitaciondx = new JIFDigitacionDx("jifdigitaciondx1");
                Principal.cargarPantalla(this.xjifdigitaciondx);
                break;
            case "Cierre de Caja":
                this.xjif_cierre_caja = new JIF_Cierre_Caja(this.frmFacturac);
                Principal.cargarPantalla(this.xjif_cierre_caja);
                break;
            case "Listado de Facturas de Ventas":
                this.xJIFListaFacturaVentas = new JIFListaFacturaVentas();
                Principal.cargarPantalla(this.xJIFListaFacturaVentas);
                break;
            case "Listado de Ordenes Internas":
                this.xJIFListaOrdenesInternas = new JIFListaOrdenesInternas();
                Principal.cargarPantalla(this.xJIFListaOrdenesInternas);
                break;
            case "Generador de Autorizacion de Servicios":
                this.xjifautorizacion_servicio = new JIFAutorizacion_Servicios();
                Principal.cargarPantalla(this.xjifautorizacion_servicio);
                break;
            case "Generador de Cotizacion":
                this.xgenerarcotizacion = new JIFGenerarCotizacion();
                Principal.cargarPantalla(this.xgenerarcotizacion);
                break;
            case "Consolidado de Procedimientos Facturados":
                this.xjifconsultar_infempresa = new JIFInformacion_Empresa("xjifconsulta_informacion_proc", frm.toUpperCase());
                Principal.cargarPantalla(this.xjifconsultar_infempresa);
                break;
            case "Recepcion Laboratorio":
                if (this.xjifrecepcionlab != null) {
                    this.xjifrecepcionlab.dispose();
                }
                this.xjifrecepcionlab = new RecepcionAuto("xjifrecepcionlab", Principal.clasefacturacion.getXlugarprocesamiento(), Principal.clasefacturacion.frmFacturac.getIdOrdenSimedis());
                Principal.cargarPantalla(this.xjifrecepcionlab);
                break;
            case "Solicitud Autorizaciones P":
                this.xjifsaturoizaciones = new JIFSAutorizaciones();
                Principal.cargarPantalla(this.xjifsaturoizaciones);
                break;
            case "Facturac1":
                this.frmFacturac = new Facturac(this, this.cajaAbierta, this.clasecaja, this.xjifinformecnprogramada.xmodelo1.getValueAt(this.xjifinformecnprogramada.JTBDetalle1.getSelectedRow(), 1).toString());
                Principal.cargarPantalla(this.frmFacturac);
                break;
            case "Registro Atencion Especial":
                this.xjifregistroatencionesesp = new JIFRegistroAtencionesEsp("jifregistroatencionesp1");
                Principal.cargarPantalla(this.xjifregistroatencionesesp);
                break;
            case "Cambiar Grupo Factura":
                this.xjifcambiargrupo = new JIFCambiarGrupo("jifcambiardatosliquidacion");
                Principal.cargarPantalla(this.xjifcambiargrupo);
                break;
            case "Consultar Notas de Cargo":
                this.xjifconsultard = new JIFConsultarInfSum(frm.toUpperCase(), "jifconsultardespacho");
                Principal.cargarPantalla(this.xjifconsultard);
                break;
            case "Registro Encuesta":
                this.xjifencuenta = new JIFEncuestaS("xjifregistroencuesta2");
                Principal.cargarPantalla(this.xjifencuenta);
                break;
            case "Obstetricos":
                this.xJIFRiesgoObstetrico = new JIFRiesgoObstetrico();
                Principal.cargarPantalla(this.xJIFRiesgoObstetrico);
                break;
            case "Cardiovascular":
                this.xJIFRiesgoCardiovascular = new JIFRiesgoCardiovascular();
                Principal.cargarPantalla(this.xJIFRiesgoCardiovascular);
                break;
            case "Relacion Examen Ocupacional":
                this.xjifrelacionexameno = new JIFRelacionExamenesO();
                Principal.cargarPantalla(this.xjifrelacionexameno);
                break;
            case "Consultar Atenciones NP":
                this.xjifinformecnprogramada = new JIFInformesNProgramada("jifatencionesnpfac1");
                Principal.cargarPantalla(this.xjifinformecnprogramada);
                break;
            case "Reliquidacion Facturas":
                this.xjifreliquidacionfac = new JIFReliquidacionFac("jifreliquidacionfactura2");
                Principal.cargarPantalla(this.xjifreliquidacionfac);
                break;
            case "Consultar Remisiones y Ordenes":
                this.xjiconsultarRemOrd = new JIFConsultarExamenesxUsuario("jiconsultarRemOrdFacturacion");
                Principal.cargarPantalla(this.xjiconsultarRemOrd);
                break;
            case "Facturación":
                this.xjiliqServicio = new JIFLiqServicios(this);
                Principal.cargarPantalla(this.xjiliqServicio);
                break;
            case "Consulta de Oportunidad Urgencia":
                this.xJIFInformesVarios = new JIFInformesVarios("consulta de oportunidad en atención de urgencias", "jifinformesvarios");
                Principal.cargarPantalla(this.xJIFInformesVarios);
                break;
            case "Consulta de Usuarios Hospitalizados":
                this.xjifconsultar_infempresa = new JIFInformacion_Empresa("xjifconsulta_informacion_Hosp", frm.toUpperCase());
                Principal.cargarPantalla(this.xjifconsultar_infempresa);
                break;
            case "Actualizar Año Servicios Empresa Convenio":
                this.xJIFFServicioEmpresaConvenio = new JIFFServicioEmpresaConvenio();
                Principal.cargarPantalla(this.xJIFFServicioEmpresaConvenio);
                break;
            case "informeAutorizacion":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("informeAutorizacion", "Informe de Autorización");
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Consolidado Descuento de Nómina":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("consolDescuenNomina", "Consolidado Descuento de Nómina");
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Consultar Atenciones NP Hora":
                this.xJIFInformesNProgramadaRangoHora = new JIFInformesNProgramadaRangoHora("jifatencionesnpfachora");
                Principal.cargarPantalla(this.xJIFInformesNProgramadaRangoHora);
                break;
            case "Censo de Camas":
                this.xJIFCensoCama = new JIFCensoCama("xjifcensocama2");
                Principal.cargarPantalla(this.xJIFCensoCama);
                break;
            case "Consultar Ingresos con Evento SOAT":
                this.xJIFConsultarIngresoSoat = new JIFConsultarIngresoSoat();
                Principal.cargarPantalla(this.xJIFConsultarIngresoSoat);
                break;
            case "Recepcion Lab":
                this.xjifrecepcionlab = new RecepcionAuto("xjifrecepcionlab", Principal.clasefacturacion.getXlugarprocesamiento(), "");
                Principal.cargarPantalla(this.xjifrecepcionlab);
                break;
            case "AgendaTaquilla":
                this.agendaTaquilla = new JIFAgendaTaquilla();
                Principal.cargarPantalla(this.agendaTaquilla);
                break;
            case "FacturaA":
                this.facturacionAgil = new JIF_FacturacionAgil(this, this.persona);
                Principal.cargarPantalla(this.facturacionAgil);
                break;
            case "AgendaBienestar":
                Principal.claselab.cargarPantalla("Agenda Bienestar");
                break;
            case "jmiInformesGeneralesFac":
                this.jifreportes = new JIF_Reportes_PyP_Generico(5, "INFORMES DE FACTURACIÓN", "jmiInformesGeneralesFac");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public String getPatologia(String Id) {
        this.sql = "SELECT Nbre FROM g_patologia where (Id='" + Id + "')";
        String strTraerDato = this.consultas.traerDato(this.sql);
        this.sql = strTraerDato;
        return strTraerDato;
    }

    public void grabar(String pantalla) {
        if (!isXgrabadofact()) {
            switch (pantalla) {
                case "Facturac":
                case "Facturac1":
                    if (this.frmFacturac.frmIngreso.txtFecha.getDate().before(this.metodos.getFechaActual()) || this.frmFacturac.frmIngreso.txtFecha.getDate().equals(this.metodos.getFechaActual())) {
                        if (!this.frmFacturac.frmPersona.validadEdad()) {
                            if (this.frmFacturac.frmOrdenes.DetalleFacturacion.getSelectedIndex() == 0) {
                                if (Principal.txtNo.getText().isEmpty()) {
                                    if ((Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("1") || this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("2") || (this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("3") && this.frmFacturac.panelMvto.getComponent(0).getName().equals("Ordenes"))) && this.frmFacturac.frmPersona.validarDatos(1) == 1 && this.frmFacturac.frmIngreso.getValidarComponentes() == 1) {
                                        if (this.frmFacturac.frmOrdenes.getValidarDatos() > 0) {
                                            if (Principal.informacionGeneralPrincipalDTO.getAplicaAtencionPreferencial().booleanValue()) {
                                                JDAtencionesPreferenciales xjdatencion = new JDAtencionesPreferenciales(null, true, this.frmFacturac);
                                                xjdatencion.setVisible(true);
                                            }
                                            this.frmFacturac.frmPersona.grabar();
                                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getIdentificacion().equals("900518561")) {
                                                if (this.frmFacturac.frmPersona.validarTipoDoc) {
                                                    this.frmFacturac.frmIngreso.grabar(this.frmFacturac.frmPersona.IdPersona);
                                                    if (this.frmFacturac.frmOrdenes.getXidorden().equals("0") || this.frmFacturac.frmOrdenes.getXidorden().equals("")) {
                                                        this.frmFacturac.frmOrdenes.grabar(this.frmFacturac.frmIngreso.getIdIngreso());
                                                        this.frmFacturac.frmOrdenes.buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
                                                    }
                                                    this.frmFacturac.btnConsolidado.setEnabled(true);
                                                    Principal.txtNo.setText(this.frmFacturac.frmIngreso.getIdIngreso());
                                                    Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                                                    Principal.txtEstado.setText("ACTIVO");
                                                    if (!"SERVICIOS MEDICOS SAN IGNACIO SAS".equals(Principal.informacionIps.getNombreIps()) && !"HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"E.S.E. HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH".equals(Principal.informacionIps.getNombreIps()) && !"CLINICA SANTA CLARA SAS".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO".equals(Principal.informacionIps.getNombreIps()) && !"ZONAMEDICA MR S.A.S".equals(Principal.informacionIps.getNombreIps())) {
                                                        Consolidado frmc = new Consolidado((Frame) null, true, this.frmFacturac.frmIngreso.getIdIngreso(), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), this.frmFacturac, this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento(), 0, this.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
                                                        frmc.setVisible(true);
                                                    }
                                                    this.frmFacturac.frmOrdenes.mVerificarProcEsCita();
                                                    if (getxCargarAutorizacion() == 1) {
                                                        cargarPantalla("Generador de Autorizacion de Servicios", Long.valueOf(Principal.txtNo.getText()).longValue());
                                                    }
                                                    if (getXaplicaencuesta() == 0) {
                                                        Principal.informacionGeneralPrincipalDTO.setIdTipoEncuesta(new Long(7L));
                                                        cargarPantalla("Registro Encuesta");
                                                    }
                                                    if (this.xjifencuenta != null) {
                                                        this.xjifencuenta.setXidingreso(Long.valueOf(Principal.txtNo.getText()).longValue());
                                                    }
                                                    if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                                        if (this.frmFacturac.xesconsulta && this.frmFacturac.frmOrdenes.getXidclasecita().equals("0")) {
                                                            int x = JOptionPane.showConfirmDialog(this.frmFacturac, "Desea generar atención", "ATENCIÓN OCUPACIONAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                            if (x == 0) {
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
                                                        } else if (this.frmFacturac.xesso.equals("si")) {
                                                            mImprimirListaChequeoSo();
                                                        }
                                                    }
                                                    if (getxId_Rechazo() != 0) {
                                                        this.metodos.mImprimir_Pendiente_Laboratorio(String.valueOf(getxId_Rechazo()));
                                                    }
                                                    mLimpiar_Formulario();
                                                    if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
                                                        nuevo(pantalla);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog((Component) null, "Para poder continuar debe cambiar el tipo de documento", "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                }
                                            } else {
                                                this.frmFacturac.frmIngreso.grabar(this.frmFacturac.frmPersona.IdPersona);
                                                if (this.frmFacturac.frmOrdenes.getXidorden().equals("0") || this.frmFacturac.frmOrdenes.getXidorden().equals("")) {
                                                    this.frmFacturac.frmOrdenes.grabar(this.frmFacturac.frmIngreso.getIdIngreso());
                                                    this.frmFacturac.frmOrdenes.buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
                                                }
                                                this.frmFacturac.btnConsolidado.setEnabled(true);
                                                Principal.txtNo.setText(this.frmFacturac.frmIngreso.getIdIngreso());
                                                Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                                                Principal.txtEstado.setText("ACTIVO");
                                                if (!"SERVICIOS MEDICOS SAN IGNACIO SAS".equals(Principal.informacionIps.getNombreIps()) && !"HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"E.S.E. HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH".equals(Principal.informacionIps.getNombreIps()) && !"CLINICA SANTA CLARA SAS".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO".equals(Principal.informacionIps.getNombreIps()) && !"ZONAMEDICA MR S.A.S".equals(Principal.informacionIps.getNombreIps())) {
                                                    Consolidado frmc2 = new Consolidado((Frame) null, true, this.frmFacturac.frmIngreso.getIdIngreso(), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), this.frmFacturac, this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento(), 0, this.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
                                                    frmc2.setVisible(true);
                                                }
                                                this.frmFacturac.frmOrdenes.mVerificarProcEsCita();
                                                if (getxCargarAutorizacion() == 1) {
                                                    cargarPantalla("Generador de Autorizacion de Servicios", Long.valueOf(Principal.txtNo.getText()).longValue());
                                                }
                                                if (getXaplicaencuesta() == 0) {
                                                    Principal.informacionGeneralPrincipalDTO.setIdTipoEncuesta(new Long(7L));
                                                    cargarPantalla("Registro Encuesta");
                                                }
                                                if (this.xjifencuenta != null) {
                                                    this.xjifencuenta.setXidingreso(Long.valueOf(Principal.txtNo.getText()).longValue());
                                                }
                                                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                                    if (this.frmFacturac.xesconsulta && this.frmFacturac.frmOrdenes.getXidclasecita().equals("0")) {
                                                        int x2 = JOptionPane.showConfirmDialog(this.frmFacturac, "Desea generar atención", "ATENCIÓN OCUPACIONAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                        if (x2 == 0) {
                                                            if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                                                                JDDatosOcupacionales_Nueva frmc13 = new JDDatosOcupacionales_Nueva(null, true);
                                                                frmc13.setLocationRelativeTo(this.frmFacturac);
                                                                frmc13.setVisible(true);
                                                            } else {
                                                                JDDatosOcupacionales frmc14 = new JDDatosOcupacionales(null, true);
                                                                frmc14.setLocationRelativeTo(this.frmFacturac);
                                                                frmc14.setVisible(true);
                                                            }
                                                        }
                                                    } else if (this.frmFacturac.xesso.equals("si")) {
                                                        mImprimirListaChequeoSo();
                                                    }
                                                }
                                                if (getxId_Rechazo() != 0) {
                                                    this.metodos.mImprimir_Pendiente_Laboratorio(String.valueOf(getxId_Rechazo()));
                                                }
                                                mLimpiar_Formulario();
                                                if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
                                                    nuevo(pantalla);
                                                }
                                            }
                                        } else {
                                            this.metodos.mostrarMensaje("Por favor adicionar Procedimientos o Suministros");
                                        }
                                    }
                                    break;
                                } else if (this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("1") || this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("2") || (this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("3") && this.frmFacturac.panelMvto.getComponent(0).getName().equals("Ordenes"))) {
                                    if (this.frmFacturac.frmPersona.validarDatos(1) == 1 && this.frmFacturac.frmIngreso.getValidarComponentes() == 1) {
                                        if (this.frmFacturac.frmOrdenes.getValidarDatos() > 0) {
                                            if (mVerificarFacturaGrabada()) {
                                                if (Principal.txtEstado.getText().equals("ACTIVO")) {
                                                    this.frmFacturac.frmPersona.grabar();
                                                    this.frmFacturac.frmIngreso.mActualizarIngreso();
                                                    if (this.frmFacturac.frmOrdenes.getXidorden().equals("0") || this.frmFacturac.frmOrdenes.getXidorden().equals("")) {
                                                        this.frmFacturac.frmOrdenes.grabar(Principal.txtNo.getText());
                                                        this.frmFacturac.frmOrdenes.buscarOrdenesHC(this.frmFacturac.frmPersona.IdPersona);
                                                    }
                                                    this.frmFacturac.btnConsolidado.setEnabled(true);
                                                    Principal.txtNo.setText(this.frmFacturac.frmIngreso.getIdIngreso());
                                                    Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                                                    Principal.txtEstado.setText("ACTIVO");
                                                    if (!"SERVICIOS MEDICOS SAN IGNACIO SAS".equals(Principal.informacionIps.getNombreIps()) && !"HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"E.S.E. HOSPITAL SAN VICENTE DE PAUL".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH".equals(Principal.informacionIps.getNombreIps()) && !"CLINICA SANTA CLARA SAS".equals(Principal.informacionIps.getNombreIps()) && !"EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO".equals(Principal.informacionIps.getNombreIps()) && !"ZONAMEDICA MR S.A.S".equals(Principal.informacionIps.getNombreIps())) {
                                                        Consolidado frmc3 = new Consolidado((Frame) null, true, this.frmFacturac.frmIngreso.getIdIngreso(), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), this.frmFacturac, this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento(), 0, this.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
                                                        frmc3.setVisible(true);
                                                    }
                                                    mLimpiar_Formulario();
                                                    if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
                                                        nuevo(pantalla);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(this.frmFacturac, "Ingreso anulado", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(this.frmFacturac, "Usuario con factura ya grabada", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            }
                                        } else {
                                            this.frmFacturac.frmIngreso.mActualizarIngreso1();
                                        }
                                        break;
                                    }
                                } else {
                                    this.frmFacturac.frmIngreso.mActualizarIngreso1();
                                    break;
                                }
                            } else {
                                if (this.frmFacturac.frmOrdenes.DetalleFacturacion.getSelectedIndex() == 4) {
                                    this.frmFacturac.frmOrdenes.xJp_RCaja.mGrabar();
                                }
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component) null, "La edad de la persona no es válida", "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "La fecha del ingreso no debe ser superior a la fecha actual", "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        break;
                    }
                    break;
                case "jifcambiardatosliquidacion":
                    this.xjifcambiargrupo.mGrabar();
                    break;
                case "xjifexamenocupacional":
                    this.xjifrelacionexameno.mGrabar();
                    break;
                case "jifregistroatencionesp1":
                    this.xjifregistroatencionesesp.mGrabar();
                    break;
                case "xjifrecepcionlab":
                    this.xjifrecepcionlab.grabar();
                    break;
                case "xjifrecepcionlabBienestar":
                    this.xjifrecepcionlabBienestar.grabar();
                    break;
                case "jifreliquidacionfactura2":
                    this.xjifreliquidacionfac.mGrabar();
                    break;
                case "xjifsautorizaciones":
                    this.xjifsaturoizaciones.mGrabar();
                    break;
                case "xjif_cierre_caja":
                    this.xjif_cierre_caja.mGrabar();
                    break;
                case "xjifautorizacion_servicios":
                    this.xjifautorizacion_servicio.mGrabar();
                    break;
                case "xgenerarcotizacion":
                    this.xgenerarcotizacion.mGrabar();
                    break;
                case "xJIFRiesgoObstetrico":
                    this.xJIFRiesgoObstetrico.mGrabar();
                    break;
                case "xJIFRiesgoCardiovascular":
                    this.xJIFRiesgoCardiovascular.mGrabar();
                    break;
                case "xJIFFServicioEmpresaConvenio":
                    this.xJIFFServicioEmpresaConvenio.mGrabar();
                    break;
                case "jifdigitaciondx1":
                    this.xjifdigitaciondx.mGrabar();
                    break;
                case "xJIFFacturacionAgil":
                    this.facturacionAgil.grabar();
                    break;
                case "Agenda":
                    this.agendaSimedis.grabarOrdenXenco();
                    break;
            }
        }
        if (pantalla.equals("xjifautorizacion_servicios")) {
            this.xjifautorizacion_servicio.mGrabar();
            return;
        }
        if (pantalla.equals("xjifrecepcionlab")) {
            this.xjifrecepcionlab.grabar();
            return;
        }
        if (pantalla.equals("FacturacN2")) {
            Principal.txtNo.setText("");
            if (Principal.txtNo.getText().isEmpty()) {
                if ((this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("1") || this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("2") || (this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("3") && this.frmFacturac.panelMvto.getComponent(0).getName().equals("Ordenes"))) && this.frmFacturac.frmPersona.validarDatos(1) == 1 && this.frmFacturac.frmIngreso.getValidarComponentes() == 1) {
                    if (this.frmFacturac.frmOrdenes.getValidarDatos() > 0) {
                        this.frmFacturac.frmPersona.grabar();
                        this.frmFacturac.frmIngreso.grabar1(this.frmFacturac.frmPersona.IdPersona);
                        this.frmFacturac.frmOrdenes.JLBIngreso.setText(this.frmFacturac.frmIngreso.getIdIngreso());
                        this.frmFacturac.frmOrdenes.grabar1(this.frmFacturac.frmIngreso.getIdIngreso());
                        this.frmFacturac.frmOrdenes.buscarOrdenesHC(this.frmFacturac.frmPersona.getIdPersona());
                        this.frmFacturac.btnConsolidado.setEnabled(true);
                        Principal.txtNo.setText(this.frmFacturac.frmIngreso.getIdIngreso());
                        Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                        Principal.txtEstado.setText("ACTIVO");
                        Consolidado frmc4 = new Consolidado((Frame) null, true, this.frmFacturac.frmIngreso.getIdIngreso(), this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), this.frmFacturac, this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento(), 1, this.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
                        frmc4.setVisible(true);
                        this.frmFacturac.frmOrdenes.mVerificarProcEsCita();
                        if (getXaplicaencuesta() == 0) {
                            Principal.informacionGeneralPrincipalDTO.setIdTipoEncuesta(new Long(7L));
                            cargarPantalla("Registro Encuesta");
                        }
                        if (this.xjifencuenta != null) {
                            this.xjifencuenta.setXidingreso(Long.valueOf(Principal.txtNo.getText()).longValue());
                        }
                        if (this.frmFacturac.xesconsulta && this.frmFacturac.frmOrdenes.getXidclasecita().equals("0")) {
                            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                                int x3 = JOptionPane.showConfirmDialog(this.frmFacturac, "Desea generar atención", "ATENCIÓN OCUPACIONAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x3 == 0) {
                                    if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                                        JDDatosOcupacionales_Nueva frmc15 = new JDDatosOcupacionales_Nueva(null, true);
                                        frmc15.setLocationRelativeTo(this.frmFacturac);
                                        frmc15.setVisible(true);
                                    } else {
                                        JDDatosOcupacionales frmc16 = new JDDatosOcupacionales(null, true);
                                        frmc16.setLocationRelativeTo(this.frmFacturac);
                                        frmc16.setVisible(true);
                                    }
                                }
                            }
                        } else if (this.frmFacturac.xesso.equals("si")) {
                            mImprimirListaChequeoSo();
                        }
                        mLimpiar_Formulario();
                        return;
                    }
                    this.metodos.mostrarMensaje("Por favor adicionar Procedimientos o Suministros");
                    return;
                }
                return;
            }
            return;
        }
        if (pantalla.equals("jifLiqServicios")) {
            if (this.xjiliqServicio.JPnVentana.getComponentCount() != 0) {
                switch (this.xjiliqServicio.JPnVentana.getComponent(0).getName()) {
                    case "jpingresoN":
                        this.xjiliqServicio.mGrabar("Ingreso");
                        break;
                    case "jpEstanciasH":
                        this.xjiliqServicio.mGrabar("Estancias");
                        break;
                    case "xjp_consolidadon":
                        this.xjiliqServicio.xjpconsolidado.mGrabar();
                        break;
                    case "xjp_quirurgico":
                        this.xjiliqServicio.xJPQuirurgico.mGrabar();
                        break;
                    case "jpremisiones":
                        this.xjiliqServicio.mGrabar("Remisiones");
                        break;
                    case "xjpingresodocumento":
                        this.xjiliqServicio.xJPIngresoDocumento.mGrabar();
                        break;
                    case "xjpingresoseguimientos":
                        this.xjiliqServicio.xJPIngresoSeguimientos.mGuardar();
                        break;
                    case "xjpglosa":
                        this.xjiliqServicio.xJPGlosa.mGrabar();
                        break;
                    case "xjpescaneodocumentosenf":
                        this.xjiliqServicio.xJPEscaneoDocumentosEnf.mGrabar();
                        break;
                    case "xjpordensalidaingreso":
                        this.xjiliqServicio.xJPOrdenSalidaIngreso.mGrabar();
                        break;
                    case "jpi_formulario_anexo2":
                        this.xjiliqServicio.formularioAnexo2.grabar();
                        break;
                    case "xjpi_formulaanexo3":
                        this.xjiliqServicio.formularioAnexo3.grabar();
                        break;
                    case "jpi_ingresoAnexo1":
                        this.xjiliqServicio.formularioAnexo1.grabar();
                        break;
                    case "xjprocedimientos":
                        this.xjiliqServicio.xjpprocedimiento.grabar();
                        break;
                    case "jpSalidaAdministrativa":
                        this.xjiliqServicio.ingresoSalidaAdministrativa.grabar();
                        break;
                    case "jpi_ingresoAnexo1Res2335":
                        this.xjiliqServicio.formularioAnexo1Res2335.grabar();
                        break;
                    case "jpi_formulario_anexo2Res2335":
                        this.xjiliqServicio.formularioAnexo2Res2335.grabar();
                        break;
                    case "xjpi_formulaanexo3Res2335":
                        this.xjiliqServicio.formularioAnexo3Res2335.grabar();
                        break;
                }
            }
            return;
        }
        if (pantalla.equals("xJIFFacturacionAgil")) {
            this.facturacionAgil.grabar();
        }
    }

    private void mLimpiar_Formulario() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
            this.frmFacturac.nuevo();
        }
    }

    public GPersona getPersona() {
        return this.persona;
    }

    public void setPersona(GPersona persona) {
        this.persona = persona;
    }

    public void mImprimirListaChequeoSo() {
        int x = JOptionPane.showConfirmDialog(this.frmFacturac, "Desea visualizar lista de Chequeo?", "LISTA DE CHEQUEO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id_Ingreso";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_Concentimiento_Informado", mparametros);
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_So_ProcedimientosFacturados1", mparametros);
            }
        }
    }

    public void grabarOrdenCama(String fecha, String hora, String idProfesional, String idEspecialidad, String idProceCama) {
        this.sql = "INSERT INTO f_ordenes(Id_Ingreso, Id_TipoServicio, FechaOrden, HoraOrden, Id_Profesional, Id_Especialidad, Id_CentroCosto, TotalOrdenes, TotalEPS, TotalDescuento, TotalPaciente, Estado, Fecha, UsuarioS) VALUES('" + this.frmFacturac.frmIngreso.getIdIngreso() + "',(SELECT Id FROM f_tiposervicio WHERE (Estado =0 AND TipoServicio =3)),'" + fecha + "','" + hora + "'," + idProfesional + "," + idEspecialidad + ",(SELECT MIN(Id) FROM f_centrocosto WHERE (EsEstancia =0 AND Estado =0) GROUP BY Id),0,0,0,0,0,'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void mImprmir_Factura_Codigos(String NoFactura, String idIngreso) {
        String[][] mparametros = new String[8][2];
        new convertirNumerosLetras();
        this.sql = null;
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = idIngreso;
        mparametros[1][0] = "usuarioSiste";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "valorletra";
        mparametros[3][0] = "ruta";
        mparametros[3][1] = this.metodos.getRutaRep();
        mparametros[4][0] = "noFactura";
        mparametros[4][1] = NoFactura;
        mparametros[5][0] = "ntriage";
        mparametros[5][1] = this.consultas.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
        mparametros[6][0] = "SUBREPORT_DIR";
        mparametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[7][0] = "SUBREPORTFIRMA_DIR";
        mparametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.consultas.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta1", mparametros);
        }
    }

    public void imprimir_FacturayOrden(int op, String NoFactura, String idIngreso, String UsuarioS, int esCapitado, int TipoFactura, int tamanoFactura) {
        if (Principal.informacionIps.getAplicaFacturaElectronica().booleanValue()) {
            if (esCapitado == 0 || esCapitado == 1) {
                String[][] mparametros = new String[8][2];
                new convertirNumerosLetras();
                this.sql = null;
                mparametros[0][0] = "idingreso";
                mparametros[0][1] = idIngreso;
                mparametros[1][0] = "usuarioSiste";
                mparametros[1][1] = UsuarioS;
                mparametros[2][0] = "valorletra";
                mparametros[3][0] = "ruta";
                mparametros[3][1] = this.metodos.getRutaRep();
                mparametros[4][0] = "noFactura";
                mparametros[4][1] = NoFactura;
                mparametros[5][0] = "ntriage";
                mparametros[5][1] = this.consultas.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
                mparametros[6][0] = "SUBREPORT_DIR";
                mparametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros[7][0] = "SUBREPORTFIRMA_DIR";
                mparametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                this.consultas.cerrarConexionBd();
                switch (TipoFactura) {
                    case 1:
                        this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                        String valor = this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor.replace(".", ","));
                        if (op == 0) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.":
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta_Radiologos_Asociado", mparametros);
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros);
                                    break;
                                case "CLINICA PAJONAL S.A.S":
                                case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                                case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                                case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                                    if (tamanoFactura == 1) {
                                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros);
                                        break;
                                    } else {
                                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
                                        break;
                                    }
                                    break;
                                default:
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta", mparametros);
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros);
                                    break;
                            }
                        } else {
                            if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta_Radiologos_Asociado", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                if (tamanoFactura == 1) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros);
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
                                }
                            } else {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta", mparametros);
                            }
                            break;
                        }
                        break;
                    case 2:
                        this.sql = "SELECT ROUND((f_liquidacion.TotalPaciente+f_liquidacion.Copago+f_liquidacion.CuotaModeradora)) AS total FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                        String valor2 = this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        mparametros[2][1] = this.metodos.mConvertirNumeroLetras(valor2.replace(".", ","));
                        if (op == 0) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.":
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario_RadiologosA", mparametros);
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros);
                                    break;
                                case "CLINICA PAJONAL S.A.S":
                                case "UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS":
                                case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                                case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                                case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                                    if (tamanoFactura == 1) {
                                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros);
                                        break;
                                    } else {
                                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
                                        break;
                                    }
                                    break;
                                default:
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros);
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros);
                                    break;
                            }
                        } else {
                            if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario_RadiologosA", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                if (tamanoFactura == 1) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros);
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros);
                                }
                            } else {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros);
                            }
                            break;
                        }
                        break;
                }
            }
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.visualizarFacturasEventoMetodoPrinicpal(idIngreso, "0", "0", "0", "0", "0", "0", 1, 0);
            return;
        }
        String[][] mparametros2 = new String[8][2];
        String valor3 = null;
        new convertirNumerosLetras();
        this.sql = null;
        mparametros2[0][0] = "idingreso";
        mparametros2[0][1] = idIngreso;
        mparametros2[1][0] = "usuarioSiste";
        mparametros2[1][1] = UsuarioS;
        mparametros2[2][0] = "valorletra";
        mparametros2[3][0] = "ruta";
        mparametros2[3][1] = this.metodos.getRutaRep();
        mparametros2[4][0] = "noFactura";
        mparametros2[4][1] = NoFactura;
        mparametros2[5][0] = "ntriage";
        mparametros2[5][1] = this.consultas.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
        mparametros2[6][0] = "SUBREPORT_DIR";
        mparametros2[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros2[7][0] = "SUBREPORTFIRMA_DIR";
        mparametros2[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.consultas.cerrarConexionBd();
        if (esCapitado == 0 || esCapitado == 1) {
            switch (TipoFactura) {
                case 1:
                    this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                    String valor4 = this.consultas.traerDato(this.sql);
                    this.consultas.cerrarConexionBd();
                    mparametros2[2][1] = this.metodos.mConvertirNumeroLetras(valor4.replace(".", ","));
                    if (op == 0) {
                        switch (Principal.informacionIps.getNombreIps()) {
                            case "RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.":
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta_Radiologos_Asociado", mparametros2);
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                                break;
                            case "CLINICA PAJONAL S.A.S":
                            case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                            case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                            case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                                if (tamanoFactura == 1) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros2);
                                    break;
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros2);
                                    break;
                                }
                                break;
                            default:
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta", mparametros2);
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                                break;
                        }
                    } else {
                        if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta_Radiologos_Asociado", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                            if (tamanoFactura == 1) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros2);
                            } else {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros2);
                            }
                        } else {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCarta", mparametros2);
                        }
                        break;
                    }
                    break;
                case 2:
                    this.sql = "SELECT ROUND((f_liquidacion.TotalPaciente+f_liquidacion.Copago+f_liquidacion.CuotaModeradora)) AS total FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                    String valor5 = this.consultas.traerDato(this.sql);
                    this.consultas.cerrarConexionBd();
                    mparametros2[2][1] = this.metodos.mConvertirNumeroLetras(valor5.replace(".", ","));
                    if (op == 0) {
                        switch (Principal.informacionIps.getNombreIps()) {
                            case "RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.":
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario_RadiologosA", mparametros2);
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                                break;
                            case "CLINICA PAJONAL S.A.S":
                            case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                            case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                            case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                                if (tamanoFactura == 1) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros2);
                                    break;
                                } else {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros2);
                                    break;
                                }
                                break;
                            default:
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros2);
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                                break;
                        }
                    } else {
                        if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario_RadiologosA", mparametros2);
                        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                            if (tamanoFactura == 1) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios_MediaCarta", mparametros2);
                            } else {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_F_Liquidacion_Servicios", mparametros2);
                            }
                        } else {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros2);
                        }
                        break;
                    }
                    break;
            }
        }
        switch (TipoFactura) {
            case 1:
                this.sql = "SELECT  `f_liquidacion`.`TotalEps`  , `g_ips`.`Nbre` FROM `f_factura_evento`  INNER JOIN  `f_liquidacion`   ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN  `ingreso`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  `g_ips`    ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)  WHERE ingreso.`Id`='" + idIngreso + "' AND `f_liquidacion`.`Estado`=0";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                String N_Ips = Principal.informacionIps.getNombreIps();
                try {
                    if (xrs.next()) {
                        xrs.first();
                        valor3 = xrs.getString(1);
                        N_Ips = xrs.getString(2);
                    }
                    xrs.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(claseFacturacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                mparametros2[2][1] = this.metodos.mConvertirNumeroLetras(valor3.replace(".", ","));
                if (op == 0) {
                    if (N_Ips.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips.equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Dajud", "", 0);
                        mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                    } else if (N_Ips.equals("COD-OPTICA UT")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Dajud_UMT", "", 0);
                        mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                    } else if (N_Ips.equals("FUNDACIÓN PANZENÚ")) {
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaEventoCarta", mparametros2);
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                    } else if (N_Ips.equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Radiologos_Asociados", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                    } else if (N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S.S") || N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_San_Jorge", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                    } else if (N_Ips.equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                        if (tamanoFactura == 1) {
                            mImprimir_Factura("Pajonal_F_Liquidacion_Servicios_MediaCarta", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                        } else {
                            mImprimir_Factura("Pajonal_F_Liquidacion_Servicios", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                        }
                    } else {
                        mImprimir_Factura("F_Liquidacion_Servicios_Psiquiatras", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                    }
                } else if (N_Ips.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips.equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Dajud", "", 0);
                    mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                } else if (N_Ips.equals("COD-OPTICA UT")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Dajud_UMT", "", 0);
                    mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                } else if (N_Ips.equals("FUNDACIÓN PANZENÚ")) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaEventoCarta", mparametros2);
                } else if (N_Ips.equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Radiologos_Asociados", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                } else if (N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S.S") || N_Ips.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_San_Jorge", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                } else if (N_Ips.equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    if (tamanoFactura == 1) {
                        mImprimir_Factura("Pajonal_F_Liquidacion_Servicios_MediaCarta", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                    } else {
                        mImprimir_Factura("Pajonal_F_Liquidacion_Servicios", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                    }
                } else {
                    mImprimir_Factura("F_Liquidacion_Servicios_Psiquiatras", this.metodos.mConvertirNumeroLetras(valor3.replace(".", ",")), 1);
                }
                break;
            case 2:
                this.sql = "SELECT  f_liquidacion.TotalPaciente , `g_ips`.`Nbre` FROM `f_factura_evento`  INNER JOIN  `f_liquidacion`   ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN  `ingreso`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  `g_ips`    ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)  WHERE `f_liquidacion`.`Id_Ingreso`='" + idIngreso + "' AND `f_liquidacion`.`Estado`=0";
                ResultSet xrs2 = this.consultas.traerRs(this.sql);
                String N_Ips2 = Principal.informacionIps.getNombreIps();
                try {
                    if (xrs2.next()) {
                        xrs2.first();
                        xrs2.getString(1);
                        N_Ips2 = xrs2.getString(2);
                    }
                    xrs2.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex2) {
                    Logger.getLogger(claseFacturacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
                this.sql = "SELECT f_liquidacion.TotalPaciente FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND `f_liquidacion`.`Id_Ingreso`='" + idIngreso + "' AND `f_liquidacion`.`Estado`=0";
                String valor6 = this.consultas.traerDato(this.sql);
                this.consultas.cerrarConexionBd();
                mparametros2[2][1] = this.metodos.mConvertirNumeroLetras(valor6.replace(".", ","));
                if (op == 0) {
                    if (N_Ips2.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips2.equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Dajud", "", 0);
                        mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                    } else if (N_Ips2.equals("COD-OPTICA UT")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Dajud_UMT", "", 0);
                        mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                    } else if (N_Ips2.equals("FUNDACIÓN PANZENÚ")) {
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaEventoCartaUsuario", mparametros2);
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_OrdenServicioMP", mparametros2);
                    } else if (N_Ips2.equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                        mImprimir_Factura("F_Liquidacion_Servicios_Radiologos_Asociados", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                    } else if (N_Ips2.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S.S") || N_Ips2.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                        mImprimir_Factura("F_Liquidacion_Servicios", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                    } else if (N_Ips2.equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        if (tamanoFactura == 1) {
                            mImprimir_Factura("Pajonal_F_Liquidacion_Servicios_MediaCarta", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                        } else {
                            mImprimir_Factura("Pajonal_F_Liquidacion_Servicios", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                        }
                    } else {
                        mImprimir_Factura("F_Liquidacion_Servicios_Psiquiatras", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                    }
                } else if (N_Ips2.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || N_Ips2.equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Dajud", "", 0);
                    mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                } else if (N_Ips2.equals("COD-OPTICA UT")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Dajud_UMT", "", 0);
                    mImprimir_Autorizacion("F_Autorizacion_Atencion", Principal.txtNo.getText());
                } else if (N_Ips2.equals("FUNDACIÓN PANZENÚ")) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_FacturaEventoCartaUsuario", mparametros2);
                } else if (N_Ips2.equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_Radiologos_Asociados", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                } else if (N_Ips2.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S.S") || N_Ips2.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                    mImprimir_Factura("F_Liquidacion_Servicios_San_Jorge", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                } else if (N_Ips2.equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    if (tamanoFactura == 1) {
                        mImprimir_Factura("Pajonal_F_Liquidacion_Servicios_MediaCarta", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                    } else {
                        mImprimir_Factura("Pajonal_F_Liquidacion_Servicios", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                    }
                } else {
                    mImprimir_Factura("F_Liquidacion_Servicios_Psiquiatras", this.metodos.mConvertirNumeroLetras(valor6.replace(".", ",")), 1);
                }
                break;
        }
    }

    public int buscarCapitado(String idIngreso) {
        this.sql = "SELECT esCapitado FROM ingreso WHERE (ingreso.Id =" + idIngreso + ")";
        int retorno = Integer.parseInt(this.consultas.traerDato(this.sql));
        this.consultas.cerrarConexionBd();
        return retorno;
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "Facturac":
            case "Facturac1":
                this.frmFacturac.nuevo();
                break;
            case "jifcambiardatosliquidacion":
                this.xjifcambiargrupo.mNuevo();
                break;
            case "jifconsultardespacho":
                this.xjifconsultard.mNuevo();
                break;
            case "jif_facturas_auditadas":
                this.informacion_Facturas_Auditadas.nuevo();
                break;
            case "jifregistroatencionesp1":
                this.xjifregistroatencionesesp.mNuevo();
                break;
            case "jifdigitaciondx1":
                this.xjifdigitaciondx.mNuevo();
                break;
            case "jifatencionesnpfac1":
                this.xjifinformecnprogramada.mNuevo();
                break;
            case "jifLiqServicios":
                if (this.xjiliqServicio.JPnVentana.getComponentCount() > 0) {
                    if (this.xjiliqServicio.JPnVentana.getComponent(0).getName().equals("jifhistoricoingreso")) {
                        Principal.txtNo.setText("");
                        this.xjiliqServicio.JLB_NIngreso.setText("");
                        this.xjiliqServicio.xjppersona.nuevo();
                    }
                    if (this.xjiliqServicio.JPnVentana.getComponent(0).getName().equals("jpingresoN")) {
                        Principal.txtNo.setText("");
                        this.xjiliqServicio.JLB_NIngreso.setText("");
                        this.xjiliqServicio.xjpingreso.mNuevo();
                    } else {
                        this.xjiliqServicio.mNuevo();
                    }
                    break;
                } else {
                    this.xjiliqServicio.mNuevo();
                    break;
                }
                break;
            case "xjifconsulta_informacion_proc":
            case "xjifconsulta_informacion_1":
            case "xjifconsulta_informacion_3":
                this.xjifconsultar_infempresa.mNuevo();
                break;
            case "xjiflistafacturasventa":
                this.xJIFListaFacturaVentas.mNuevo();
                break;
            case "xjif_cierre_caja":
                this.xjif_cierre_caja.mNuevo();
                break;
            case "jifreliquidacionfactura2":
                this.xjifreliquidacionfac.mNuevo();
                break;
            case "xjifautorizacion_servicios":
                this.xjifautorizacion_servicio.mNuevo();
                break;
            case "xJIFRiesgoObstetrico":
                this.xJIFRiesgoObstetrico.mNuevo();
                break;
            case "xJIFRiesgoCardiovascular":
                this.xJIFRiesgoCardiovascular.mNuevo();
                break;
            case "informeAutorizacion":
                this.xJIFFConsultarInformacionGenerico.mNuevo();
                break;
            case "consolDescuenNomina":
                this.xJIFFConsultarInformacionGenerico.mNuevo();
                break;
            case "jifatencionesnpfachora":
                this.xJIFInformesNProgramadaRangoHora.mNuevo();
                break;
            case "xjifcensocama2":
                this.xJIFCensoCama.mNuevo();
                break;
            case "xjifconsultaringresossoat":
                this.xJIFConsultarIngresoSoat.mNuevo();
                break;
            case "xjiflistaordenesinternas":
                this.xJIFListaOrdenesInternas.mNuevo();
                break;
            case "xjifconsulta_informacion_Hosp":
                this.xjifconsultar_infempresa.mNuevo();
                break;
            case "jifConsultarIngresosLiquidacion":
                this.jIF_ConsultarIngresosPorLiquidacion.nuevo();
                break;
            case "xJIFFacturacionAgil":
                this.facturacionAgil.nuevo();
                break;
            case "xgenerarcotizacion":
                this.xgenerarcotizacion.mNuevo();
                break;
        }
    }

    public boolean isXgrabadofact() {
        return this.xgrabadofact;
    }

    public void setXgrabadofact(boolean xgrabadofact) {
        this.xgrabadofact = xgrabadofact;
    }

    public void setCamaDisponible(int dis) {
        this.sql = "UPDATE f_camas SET Disponible = " + dis + " WHERE Id=" + this.frmFacturac.frmIngreso.getIdCama();
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void actualizarItemOrden(String llamador) {
        try {
            this.sql = "SELECT f_ordenes.Id, f_itemordenescamas.FechaIngCama as FechaIng,  f_itemordenescamas.ValorCama, Id_TipoPlan  FROM f_itemordenescamas INNER JOIN f_ordenes ON (f_itemordenescamas.IdOrdenes = f_ordenes.Id) INNER JOIN f_tiposervicio  ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_ordenes.Id_Ingreso = " + this.frmFacturac.frmIngreso.getIdIngreso() + " AND f_tiposervicio.TipoServicio =3 AND f_itemordenescamas.FechaEgreCama IS NULL )";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.next();
            String fechaHora = this.metodos.formatoAMD.format(this.frmFacturac.frmEgreso.txtFechaEgreso.getDate()) + " " + this.metodos.formatoH24.format(this.frmFacturac.frmEgreso.txtHoraEgreso.getDate());
            int noDias = 0;
            if (llamador.equals("Egreso")) {
                noDias = this.consultas.getRestarFechas(fechaHora, this.rs.getString(2));
            }
            this.sql = "UPDATE f_itemordenescamas SET  FechaEgreCama ='" + fechaHora + "', NoDias = " + noDias + " WHERE f_itemordenescamas.Id_Ordenes = " + this.rs.getString(1);
            this.consultas.ejecutarSQL(this.sql);
            Long totalOrden = Long.valueOf(this.rs.getLong(3) * ((long) this.consultas.getRestarFechas(fechaHora, this.rs.getString(2))));
            actualizarOrden(this.rs.getString(1), totalOrden, this.rs.getString(4));
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    public int getXlugarprocesamiento() {
        return this.xlugarprocesamiento;
    }

    public void setXlugarprocesamiento(int xlugarprocesamiento) {
        this.xlugarprocesamiento = xlugarprocesamiento;
    }

    public int getXidbodega() {
        return this.xidbodega;
    }

    public void setXidbodega(int xidbodega) {
        this.xidbodega = xidbodega;
    }

    public int getXaplicaencuesta() {
        return this.xaplicaencuesta;
    }

    public void setXaplicaencuesta(int xaplicaencuesta) {
        this.xaplicaencuesta = xaplicaencuesta;
    }

    public int getXrecepcionalaboratorio() {
        return this.xrecepcionalaboratorio;
    }

    public void setXrecepcionalaboratorio(int xrecepcionalaboratorio) {
        this.xrecepcionalaboratorio = xrecepcionalaboratorio;
    }

    public int getXeslab() {
        return this.xeslab;
    }

    public void setXeslab(int xeslab) {
        this.xeslab = xeslab;
    }

    public long getxId_Rechazo() {
        return this.xId_Rechazo;
    }

    public void setxId_Rechazo(long xId_Rechazo) {
        this.xId_Rechazo = xId_Rechazo;
    }

    private boolean mVerificarFacturaGrabada() {
        boolean xestado = true;
        if (buscarCapitado(Principal.txtNo.getText()) < 2) {
            this.sql = "SELECT f_factura_capita.No_FacturaCapita FROM ingreso INNER JOIN f_liquidacion  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_factura_capita  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) WHERE (f_liquidacion.Estado =0 AND f_factura_capita.Estado =0 AND ingreso.Id ='" + Principal.txtNo.getText() + "') ";
        } else {
            this.sql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento FROM ingreso INNER JOIN f_liquidacion  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_factura_evento  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_liquidacion.Estado =0 AND f_factura_evento.Estado =0 AND ingreso.Id ='" + Principal.txtNo.getText() + "') ";
        }
        ResultSet xrs = this.consultas.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xestado = false;
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseFacturacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    public String getNoLiquidacion() {
        return this.noLiquidacion;
    }

    public void setNoLiquidacion(String noLiquidacion) {
        this.noLiquidacion = noLiquidacion;
    }

    public String getFactOrdenEps() {
        return this.factOrdenEps;
    }

    public void setFactOrdenEps(String factOrdenEps) {
        this.factOrdenEps = factOrdenEps;
    }

    public String getFactOrdenPaciente() {
        return this.factOrdenPaciente;
    }

    public void setFactOrdenPaciente(String factOrdenPaciente) {
        this.factOrdenPaciente = factOrdenPaciente;
    }

    public String getFechaFactOrdEps() {
        return this.fechaFactOrdEps;
    }

    public void setFechaFactOrdEps(String fechaFactOrdEps) {
        this.fechaFactOrdEps = fechaFactOrdEps;
    }

    public String getFechaFactOrdPaciente() {
        return this.fechaFactOrdPaciente;
    }

    public void setFechaFactOrdPaciente(String fechaFactOrdPaciente) {
        this.fechaFactOrdPaciente = fechaFactOrdPaciente;
    }

    public String getEstadoFactOrdenEps() {
        return this.estadoFactOrdenEps;
    }

    public void setEstadoFactOrdenEps(String estadoFactOrdenEps) {
        this.estadoFactOrdenEps = estadoFactOrdenEps;
    }

    public String getEstadoFactOrdenPaciente() {
        return this.estadoFactOrdenPaciente;
    }

    public void setEstadoFactOrdenPaciente(String estadoFactOrdenPaciente) {
        this.estadoFactOrdenPaciente = estadoFactOrdenPaciente;
    }

    public double getxPCopago() {
        return this.xPCopago;
    }

    public void setxPCopago(double xPCopago) {
        this.xPCopago = xPCopago;
    }

    public double getxCModeradora() {
        return this.xCModeradora;
    }

    public void setxCModeradora(double xCModeradora) {
        this.xCModeradora = xCModeradora;
    }

    public String getxEsCapitado() {
        return this.xEsCapitado;
    }

    public void setxEsCapitado(String xEsCapitado) {
        this.xEsCapitado = xEsCapitado;
    }

    public int getxCargarAutorizacion() {
        return this.xCargarAutorizacion;
    }

    public void setxCargarAutorizacion(int xCargarAutorizacion) {
        this.xCargarAutorizacion = xCargarAutorizacion;
    }

    public String getxCValor() {
        return this.xCValor;
    }

    public void setxCValor(String xCValor) {
        this.xCValor = xCValor;
    }

    public String getxFiltroProc() {
        return this.xFiltroProc;
    }

    public void setxFiltroProc(String xFiltroProc) {
        this.xFiltroProc = xFiltroProc;
    }

    public String getxIdTipoPlan() {
        return this.xIdTipoPlan;
    }

    public void setxIdTipoPlan(String xIdTipoPlan) {
        this.xIdTipoPlan = xIdTipoPlan;
    }

    public double getxTopeAtencion() {
        return this.xTopeAtencion;
    }

    public void setxTopeAtencion(double xTopeAtencion) {
        this.xTopeAtencion = xTopeAtencion;
    }

    public double getxTopeAnual() {
        return this.xTopeAnual;
    }

    public void setxTopeAnual(double xTopeAnual) {
        this.xTopeAnual = xTopeAnual;
    }

    public String getxIdManual() {
        return this.xIdManual;
    }

    public void setxIdManual(String xIdManual) {
        this.xIdManual = xIdManual;
    }

    public int getxIdTipoAtencion() {
        return this.xIdTipoAtencion;
    }

    public void setxIdTipoAtencion(int xIdTipoAtencion) {
        this.xIdTipoAtencion = xIdTipoAtencion;
    }

    public long getxTipoEstrato() {
        return this.xTipoEstrato;
    }

    public void setxTipoEstrato(long xTipoEstrato) {
        this.xTipoEstrato = xTipoEstrato;
    }

    public long getxIdEmpresa() {
        return this.xIdEmpresa;
    }

    public void setxIdEmpresa(long xIdEmpresa) {
        this.xIdEmpresa = xIdEmpresa;
    }

    public long getxIdGIps() {
        return this.xIdGIps;
    }

    public void setxIdGIps(long xIdGIps) {
        this.xIdGIps = xIdGIps;
    }

    public long getxIdIngreso() {
        return this.xIdIngreso;
    }

    public void setxIdIngreso(long xIdIngreso) {
        this.xIdIngreso = xIdIngreso;
    }

    public long getxIdPersona() {
        return this.xIdPersona;
    }

    public void setxIdPersona(long xIdPersona) {
        this.xIdPersona = xIdPersona;
    }

    public int getxMetodoFact() {
        return this.xMetodoFact;
    }

    public void setxMetodoFact(int xMetodoFact) {
        this.xMetodoFact = xMetodoFact;
    }

    public int getxRedondeo() {
        return this.xRedondeo;
    }

    public void setxRedondeo(int xRedondeo) {
        this.xRedondeo = xRedondeo;
    }

    public String getIdCodigoInternoInterface() {
        return this.idCodigoInternoInterface;
    }

    public void setIdCodigoInternoInterface(String idCodigoInternoInterface) {
        this.idCodigoInternoInterface = idCodigoInternoInterface;
    }

    private void mImprimirCertificadoA() {
        int x = JOptionPane.showConfirmDialog(this.frmFacturac, "Desea visualizar Certificado de atencion?", "CERTIFICADO DE ATENCION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (!Principal.txtNo.getText().isEmpty()) {
                String[][] parametros = new String[3][2];
                parametros[0][0] = "idingreso";
                parametros[0][1] = Principal.txtNo.getText();
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getNombreIps().equals("CAMI S.A.S")) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Certificado_Ingreso_Cami", parametros);
                    return;
                } else {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_Certificado_Ingreso", parametros);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this.frmFacturac, "El Ingreso no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void anularLiquidacionMasivamente(String idMotivoAnulacion, String xMotivo, String xObservacion, Long idLiquidacion, Long idFacturaEvento, Long idFacturaCapita) {
        this.sql = "Update f_liquidacion set Estado=1  WHERE Id=" + idLiquidacion;
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        if (idFacturaEvento.longValue() != 0) {
            this.sql = "UPDATE f_factura_evento  SET f_factura_evento.Estado =1 , Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_evento.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_evento.`Fecha_Anulacion`='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' , f_factura_evento.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_evento.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_evento.No_FacturaEvento  =" + idFacturaEvento + ")";
        } else if (idFacturaCapita.longValue() != 0) {
            this.sql = "UPDATE f_factura_capita SET f_factura_capita.Estado =1, Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_capita.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_capita.`Fecha_Anulacion`='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' , f_factura_capita.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_capita.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE  (f_factura_capita.No_FacturaCapita = " + idFacturaCapita + ")";
        }
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(Long.valueOf(this.xIdIngreso), "ANULACIÓN DE LIQUIDACIÓN", xObservacion, false);
    }
}
