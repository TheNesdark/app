package General;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Historia.JIFAcronimos;
import ParametrizacionN.JIFSgcGlosario;
import RecursosHumanos.JIFNovedadesNomina;
import Salud_Ocupacional.JIFControlDeRemisiones;
import Sgc.JIFEncuestaS;
import Sgc.JIFFicha5w1H;
import Sgc.JIFGestionSolicitudes;
import Sgc.JIFRNoConfomidad;
import Sgc.JIFSolicitudes;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.controller.auditoria_medica.JIF_Seguimientos_Filtrados_Usuario;
import com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables;
import com.genoma.plus.controller.facturacion.JDConsolidadoPagosPendientes;
import com.genoma.plus.controller.gcuenta.JIFGestinDeFactura;
import com.genoma.plus.controller.general.JIFBitacora;
import com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario;
import com.genoma.plus.controller.general.JIFINgresoFactura;
import com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno;
import com.genoma.plus.controller.sgc.JIFImportacionDatosUsuarios;
import com.genoma.plus.jpa.projection.ILiquidacionDeudaUsuarioProjection;
import com.genoma.plus.jpa.service.ILiquidacionService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:General/claseGeneral.class */
public class claseGeneral {
    public Principal frmPrincipal;
    private CrearPersona frmCrearP;
    public Llamadas frmLlamadas;
    public JIFINgresoFactura factura;
    private CambiarIdentificacion frmCambiarIdenti;
    private JIFEncuestaS xjifencuesta;
    private JIFSolicitudes xjifsolicitudes;
    private JIFRNoConfomidad xjifreportenc;
    private JIFSgcGlosario xjifsgcglosario;
    private JIFFicha5w1H xjifficha5w1h;
    private JIFAcronimos xjifacronimos;
    private JIFCrearPersona xjifcrearpesona;
    private JIFBuscarDatos xbuscard;
    private JIFGestionActivos xactivos;
    private JIFRadicacionDocClinico xradicacion;
    public JIFGestionSolicitudes jifgestionsol;
    private JIF_Seguimientos_Filtrados_Usuario xJifSeguimientoFiltrado;
    private JIFGEmpresaUnificacionUsuario xJIFGEmpresaUnificacionUsuario;
    private JIF_AuditoriaFacturasContables auditoriaFacturasContables;
    public JIFSolicitudPedidoInterno solicitudPedidoInterno;
    public JIFImportacionDatosUsuarios importarDatosUsuario;
    public JIFNovedadesNomina xJIFNovedadesNomina;
    private JIFGestinDeFactura deFactura;
    public JIFBitacora jifbitacora;
    public JIFControlDeRemisiones jifcontrolRemisiones;
    private String xsql;
    private String xidnumero = "0";
    private long xidsolicitud = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final ILiquidacionService liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);

    @Generated
    public Principal getFrmPrincipal() {
        return this.frmPrincipal;
    }

    @Generated
    public CrearPersona getFrmCrearP() {
        return this.frmCrearP;
    }

    @Generated
    public Llamadas getFrmLlamadas() {
        return this.frmLlamadas;
    }

    @Generated
    public JIFINgresoFactura getFactura() {
        return this.factura;
    }

    @Generated
    public CambiarIdentificacion getFrmCambiarIdenti() {
        return this.frmCambiarIdenti;
    }

    @Generated
    public JIFEncuestaS getXjifencuesta() {
        return this.xjifencuesta;
    }

    @Generated
    public JIFSolicitudes getXjifsolicitudes() {
        return this.xjifsolicitudes;
    }

    @Generated
    public JIFRNoConfomidad getXjifreportenc() {
        return this.xjifreportenc;
    }

    @Generated
    public JIFSgcGlosario getXjifsgcglosario() {
        return this.xjifsgcglosario;
    }

    @Generated
    public JIFFicha5w1H getXjifficha5w1h() {
        return this.xjifficha5w1h;
    }

    @Generated
    public JIFAcronimos getXjifacronimos() {
        return this.xjifacronimos;
    }

    @Generated
    public JIFCrearPersona getXjifcrearpesona() {
        return this.xjifcrearpesona;
    }

    @Generated
    public JIFBuscarDatos getXbuscard() {
        return this.xbuscard;
    }

    @Generated
    public JIFGestionActivos getXactivos() {
        return this.xactivos;
    }

    @Generated
    public JIFRadicacionDocClinico getXradicacion() {
        return this.xradicacion;
    }

    @Generated
    public JIFGestionSolicitudes getJifgestionsol() {
        return this.jifgestionsol;
    }

    @Generated
    public JIF_Seguimientos_Filtrados_Usuario getXJifSeguimientoFiltrado() {
        return this.xJifSeguimientoFiltrado;
    }

    @Generated
    public JIFGEmpresaUnificacionUsuario getXJIFGEmpresaUnificacionUsuario() {
        return this.xJIFGEmpresaUnificacionUsuario;
    }

    @Generated
    public JIF_AuditoriaFacturasContables getAuditoriaFacturasContables() {
        return this.auditoriaFacturasContables;
    }

    @Generated
    public JIFSolicitudPedidoInterno getSolicitudPedidoInterno() {
        return this.solicitudPedidoInterno;
    }

    @Generated
    public JIFImportacionDatosUsuarios getImportarDatosUsuario() {
        return this.importarDatosUsuario;
    }

    @Generated
    public JIFNovedadesNomina getXJIFNovedadesNomina() {
        return this.xJIFNovedadesNomina;
    }

    @Generated
    public JIFGestinDeFactura getDeFactura() {
        return this.deFactura;
    }

    @Generated
    public JIFBitacora getJifbitacora() {
        return this.jifbitacora;
    }

    @Generated
    public JIFControlDeRemisiones getJifcontrolRemisiones() {
        return this.jifcontrolRemisiones;
    }

    @Generated
    public ConsultasMySQL getXct() {
        return this.xct;
    }

    @Generated
    public String getXsql() {
        return this.xsql;
    }

    @Generated
    public ILiquidacionService getLiquidacionService() {
        return this.liquidacionService;
    }

    public void cargarPantalla(String Llamador, int xForma) {
        if (Llamador.equals("SeguimientoFiltradoUsuario")) {
            this.xJifSeguimientoFiltrado = new JIF_Seguimientos_Filtrados_Usuario(xForma);
            Principal.cargarPantalla(this.xJifSeguimientoFiltrado);
        }
    }

    public void cargarPantalla(String Llamador) {
        switch (Llamador) {
            case "CrearPersona":
                this.xjifcrearpesona = new JIFCrearPersona(1);
                Principal.cargarPantalla(this.xjifcrearpesona);
                break;
            case "Acrónimos":
                this.xjifacronimos = new JIFAcronimos();
                Principal.cargarPantalla(this.xjifacronimos);
                break;
            case "Auditoría Facturas Contables":
                this.auditoriaFacturasContables = new JIF_AuditoriaFacturasContables(Llamador.toUpperCase());
                Principal.cargarPantalla(this.auditoriaFacturasContables);
                break;
            case "DesactivarPersona":
                this.xjifcrearpesona = new JIFCrearPersona(2);
                Principal.cargarPantalla(this.xjifcrearpesona);
                break;
            case "Glosario":
                this.xjifsgcglosario = new JIFSgcGlosario("xjifglosario1");
                Principal.cargarPantalla(this.xjifsgcglosario);
                break;
            case "ActivarPersona":
                this.xjifcrearpesona = new JIFCrearPersona(3);
                Principal.cargarPantalla(this.xjifcrearpesona);
                break;
            case "Llamadas":
                this.frmLlamadas = new Llamadas("", getXidnumero());
                Principal.cargarPantalla(this.frmLlamadas);
                break;
            case "Registro Factura":
                this.factura = new JIFINgresoFactura();
                Principal.cargarPantalla(this.factura);
                break;
            case "CambiarIdentificacion":
                this.frmCambiarIdenti = new CambiarIdentificacion();
                Principal.cargarPantalla(this.frmCambiarIdenti);
                break;
            case "Encuesta":
                this.xjifencuesta = new JIFEncuestaS("xjifregistroencuesta1");
                Principal.cargarPantalla(this.xjifencuesta);
                break;
            case "Solicitud":
                this.xjifsolicitudes = new JIFSolicitudes();
                Principal.cargarPantalla(this.xjifsolicitudes);
                break;
            case "ReporteNC":
                this.xjifreportenc = new JIFRNoConfomidad(0, "xjifreportenc");
                Principal.cargarPantalla(this.xjifreportenc);
                break;
            case "Ficha 5w1H":
                this.xjifficha5w1h = new JIFFicha5w1H(2, "xjifficha5w1h1");
                Principal.cargarPantalla(this.xjifficha5w1h);
                break;
            case "Agrupacion":
                Principal.cargarPantalla(this.xbuscard);
                break;
            case "Radicación documentos clínicos":
                this.xradicacion = new JIFRadicacionDocClinico("Radicación documentos clínicos");
                Principal.cargarPantalla(this.xradicacion);
                break;
            case "Autorizar Solicitudes":
                this.jifgestionsol = new JIFGestionSolicitudes(0, "jifgestionsolicitudes1", true);
                Principal.cargarPantalla(this.jifgestionsol);
                break;
            case "Unificar Usuario Empresa Duplicados":
                this.xJIFGEmpresaUnificacionUsuario = new JIFGEmpresaUnificacionUsuario();
                Principal.cargarPantalla(this.xJIFGEmpresaUnificacionUsuario);
                break;
            case "Solicitud Pedido Interno":
                this.solicitudPedidoInterno = new JIFSolicitudPedidoInterno();
                Principal.cargarPantalla(this.solicitudPedidoInterno);
                break;
            case "NovedadesNomina":
                this.xJIFNovedadesNomina = new JIFNovedadesNomina(0, "xjif_NovedadesNomina1");
                Principal.cargarPantalla(this.xJIFNovedadesNomina);
                break;
            case "Importar Información de Usuario":
                this.importarDatosUsuario = new JIFImportacionDatosUsuarios();
                Principal.cargarPantalla(this.importarDatosUsuario);
                break;
            case "Bitacora":
                this.jifbitacora = new JIFBitacora();
                Principal.cargarPantalla(this.jifbitacora);
                break;
            case "Control de remisiones":
                this.jifcontrolRemisiones = new JIFControlDeRemisiones("xjifcontrolderemisiones");
                Principal.cargarPantalla(this.jifcontrolRemisiones);
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "CambiarIdentificacion":
                this.frmCambiarIdenti.mGrabar();
                break;
            case "Llamadas":
                this.frmLlamadas.agregarFilaAlGrid();
                break;
            case "xjifregistroencuesta1":
                this.xjifencuesta.mGrabar();
                break;
            case "jifsolicitudes":
                this.xjifsolicitudes.mGrabar();
                break;
            case "xjifreportenc":
                this.xjifreportenc.mGrabar();
                break;
            case "xjifficha5w1h1":
                this.xjifficha5w1h.mGrabar();
                break;
            case "Radicación documentos clínicos":
                this.xradicacion.mGrabar();
                break;
            case "jifgestionsolicitudes1":
                this.jifgestionsol.mGrabar();
                break;
            case "xJIFGEmpresaUnificacionUsuario":
                this.xJIFGEmpresaUnificacionUsuario.mGrabar();
                break;
            case "jifSolicitudPedidoInterno":
                this.solicitudPedidoInterno.grabar();
                break;
            case "xjif_NovedadesNomina1":
                this.xJIFNovedadesNomina.mGrabar();
                break;
            case "jifImporteDatosUsuarios":
                this.importarDatosUsuario.mGrabar();
                break;
            case "jifbitacora":
                this.jifbitacora.grabar();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "CambiarIdentificacion":
                this.frmCambiarIdenti.mNuevo();
                break;
            case "Llamadas":
                this.frmLlamadas.nuevo();
                break;
            case "jifsolicitudes":
                this.xjifsolicitudes.mNuevo();
                break;
            case "xjifreportenc":
                this.xjifreportenc.mNuevo();
                break;
            case "Radicación documentos clínicos":
                this.xradicacion.mNuevo();
                break;
            case "jifgestionsolicitudes1":
                this.jifgestionsol.mNuevo();
                break;
            case "xjifSeguimientoAuditoriaMedica":
                this.xJifSeguimientoFiltrado.mNuevo();
                break;
            case "xJIFGEmpresaUnificacionUsuario":
                this.xJIFGEmpresaUnificacionUsuario.mNuevo();
                break;
            case "jifSolicitudPedidoInterno":
                this.solicitudPedidoInterno.nuevo();
                break;
            case "xjif_NovedadesNomina1":
                this.xJIFNovedadesNomina.mNuevo();
                break;
            case "xJIFGestionDeFactura":
                this.deFactura.nuevo();
                break;
            case "jifbitacora":
                this.jifbitacora.nuevo();
                break;
            case "jifImporteDatosUsuarios":
                this.importarDatosUsuario.nuevo();
                break;
        }
    }

    public void mBuscar(String frm) {
        switch (frm) {
            case "xjifreportenc":
                this.xjifreportenc.mBuscar();
                break;
            case "Llamadas":
                this.frmLlamadas.mBuscar();
                break;
            case "jifgestionsolicitudes1":
                this.jifgestionsol.mBuscar();
                break;
            case "xjifcrearpersona":
                this.xjifcrearpesona.mBuscar();
                break;
            case "xjifSeguimientoAuditoriaMedica":
                this.xJifSeguimientoFiltrado.mBuscar();
                break;
            case "xjifSeguimientoAuditoriaMedica_Usuario":
                this.xJifSeguimientoFiltrado.mBuscar();
                break;
            case "jifSolicitudPedidoInterno":
                this.solicitudPedidoInterno.buscar();
                break;
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("jifSolicitudPedidoInterno")) {
            this.solicitudPedidoInterno.imprimir();
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifSolicitudPedidoInterno":
                this.solicitudPedidoInterno.anular();
                break;
            case "xjif_NovedadesNomina1":
                this.xJIFNovedadesNomina.mAnulacion();
                break;
            case "jifbitacora":
                this.jifbitacora.anular();
                break;
        }
    }

    public void mActualizar_ResolucionDian(String xId_Factura, String xId_Gips) {
        try {
            this.xsql = "SELECT\n    `cc_resolucion_dian`.`Descripcion`\nFROM\n    `baseserver`.`g_sede_resoluciondian`\n    INNER JOIN `baseserver`.`cc_resolucion_dian` \n        ON (`g_sede_resoluciondian`.`Id_CC_ResolucionD` = `cc_resolucion_dian`.`Id`)\nWHERE (`g_sede_resoluciondian`.`Id_Sede` ='" + xId_Gips + "'\n    AND `cc_resolucion_dian`.`Estado` =1\n    AND `cc_resolucion_dian`.`clasificacion` =1)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.xsql = "update f_factura_evento set RDian='" + xrs.getString(1) + "' where No_FacturaEvento='" + xId_Factura + "'";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        xct1.ejecutarSQL(this.xsql);
                        xct1.cerrarConexionBd();
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
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(claseGeneral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getXidnumero() {
        return this.xidnumero;
    }

    public void setXidnumero(String xidnumero) {
        this.xidnumero = xidnumero;
    }

    public long getXidsolicitud() {
        return this.xidsolicitud;
    }

    public void setXidsolicitud(long xidsolicitud) {
        this.xidsolicitud = xidsolicitud;
    }

    public void activarFormularioConsolidadoPagoPendiente(Long idPersona, JInternalFrame formulario) {
        List<ILiquidacionDeudaUsuarioProjection> liquidacionDeudaUsuarios;
        if (idPersona.longValue() != 0) {
            new ArrayList();
            if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                liquidacionDeudaUsuarios = this.liquidacionService.listaLiquidacionDeudaPorIdPersonaBiomed(idPersona);
            } else {
                liquidacionDeudaUsuarios = this.liquidacionService.listaLiquidacionDeudaPorIdPersona(idPersona);
            }
            if (liquidacionDeudaUsuarios.size() > 0) {
                JDConsolidadoPagosPendientes pagosPendientes = new JDConsolidadoPagosPendientes(null, true, idPersona, formulario.getName(), liquidacionDeudaUsuarios);
                pagosPendientes.setLocationRelativeTo(formulario);
                pagosPendientes.setVisible(true);
            }
        }
    }
}
