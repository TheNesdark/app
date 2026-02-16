package Armado;

import Acceso.Principal;
import Contabilidad.JIFGenerarCuentaCobroM;
import Contabilidad.JIFGenerarCuentaCobroMImpuestos;
import Facturacion.JIFCambiarGrupo;
import Facturacion.JIFConsultarInformesE;
import Facturacion.JIFReliquidacionFac;
import General.ClaseImpresionInformes;
import Historia.JIFConsultarHAyudasDx;
import Historia.JIFConsultarHistorial;
import Sig.JIFFConsultarInformacionGenerico;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.genoma.plus.controller.gcuenta.JIFF_ConsolidadoDePagos;
import com.genoma.plus.controller.gcuenta.JIFFacturaElectronica;
import com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal;
import com.genoma.plus.controller.gcuenta.JIFGeneracionRipsCovid;
import com.genoma.plus.controller.gcuenta.JIFGestinDeFactura;
import com.genoma.plus.controller.gcuenta.JIFInformesCartera2193;
import com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva;
import com.genoma.plus.controller.gcuenta.JIFReliquidarCuentasCapitaController;
import com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera;
import com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:Armado/claseGestionCuentas.class */
public class claseGestionCuentas {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JIFPItemRipsConsultas xjifimportarripsc;
    public JIFDigitacionDx xjifdigitaciondx;
    private JIFArmadoAuditoriaProc xjifarmadoproc;
    private String sql;
    public JIFConsultarHAyudasDx xjifconsultaradx;
    public JIFConsultarHistorial xjifconsutlarhc;
    private JIFArmado xjifarmado;
    private JIFCuentaCobroCapitacionServicio xjifccobrocapitacion;
    private JIFCuentaCobroCapitacionGlobalT xjifccobrocapitaciont;
    public Principal xjifprincipal;
    public JIFConsultarCuentaxEmpresa xjifconsultarcuentas;
    public JIFGeneracionRips xjifgenerarrips;
    private JIFGeneracionFutRips xjifgenerarfutrips;
    private JIFGeneracionFutRipsV2023 xJIFGeneracionFutRipsV2023;
    private JIFArmarCapitacion xjifcapiacionglobal;
    public JIFGestionCartera xjifgestioncartera;
    private JIFReliquidacionFac xjifreliquidacionfac;
    private JIFConsultarInformesE xjifconsultarinffac;
    private JIFConciliacionCartera xjifconciliacioncartera;
    private JIF_Consultar_DatosG xjif_consultar_datosG;
    private JIFGenerarCuentaCobroM xjif_generarFC;
    private JIFGenerarCuentaCobroMImpuestos cobroMImpuestos;
    public JIFGC_Pagos_Grupal xJifPagosGrupales;
    private JIFFConsultarInformacionGenerico xJIFFConsultarInformacionGenerico;
    private JIFGeneracionRips_Extranjeros xjifRipsExtranjeros;
    private JIF_ConsolidadoCartera xJifConsolidadoCartera;
    private JIF_GeneracionCircular030 xJifGeneracionCircular030;
    private JIFCambiarGrupo xjifcambiargrupo;
    private JIFInformesCartera2193 xJIFInformesCartera2193;
    private JIFF_ConsolidadoDePagos xJIFF_ConsolidadoDePagos;
    private JIFFacturaElectronica xJIFFacturaElectronica;
    private JIFGeneracionRipsCovid generacionRipsCovid;
    private JIFGestinDeFactura deFactura;
    private JIFRadicacionMasiva radicacionMasiva;
    private JIF_Reportes_PyP_Generico jifreportes;
    private JIFReliquidarCuentasCapitaController jifReliquidarCuentasCapita;

    public claseGestionCuentas(Principal xjifprincipal) {
        this.xjifprincipal = xjifprincipal;
        xjifprincipal.JLBPeridoC.setVisible(true);
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Importar de Historía Cliníca":
                this.xjifimportarripsc = new JIFPItemRipsConsultas();
                Principal.cargarPantalla(this.xjifimportarripsc);
                break;
            case "jifradicacionmasivafacturas":
                this.radicacionMasiva = new JIFRadicacionMasiva();
                Principal.cargarPantalla(this.radicacionMasiva);
                break;
            case "GeneracionCircular030":
                this.xJifGeneracionCircular030 = new JIF_GeneracionCircular030();
                Principal.cargarPantalla(this.xJifGeneracionCircular030);
                break;
            case "jifgestion_pagos":
                this.xJifPagosGrupales = new JIFGC_Pagos_Grupal();
                Principal.cargarPantalla(this.xJifPagosGrupales);
                break;
            case "Consolidado de Ingresos por Empresa":
                this.xjif_consultar_datosG = new JIF_Consultar_DatosG("xjif_consultarDG", frm.toUpperCase());
                Principal.cargarPantalla(this.xjif_consultar_datosG);
                break;
            case "Consolidado de Ingresos por Facturador":
                this.xjif_consultar_datosG = new JIF_Consultar_DatosG("xjif_consultarDG1", frm.toUpperCase());
                Principal.cargarPantalla(this.xjif_consultar_datosG);
                break;
            case "Gestion Cartera":
                this.xjifgestioncartera = new JIFGestionCartera();
                Principal.cargarPantalla(this.xjifgestioncartera);
                break;
            case "Conciliacion Cartera":
                this.xjifconciliacioncartera = new JIFConciliacionCartera();
                Principal.cargarPantalla(this.xjifconciliacioncartera);
                break;
            case "Digitación Manual":
                this.xjifdigitaciondx = new JIFDigitacionDx("jifdigitaciondx");
                Principal.cargarPantalla(this.xjifdigitaciondx);
                break;
            case "Digitar por Grupos":
                this.xjifdigitaciondx = new JIFDigitacionDx("jifdigitaciondx");
                Principal.cargarPantalla(this.xjifdigitaciondx);
                break;
            case "Armado y Auditoria Procedimientos":
                this.xjifarmadoproc = new JIFArmadoAuditoriaProc();
                Principal.cargarPantalla(this.xjifarmadoproc);
                break;
            case "Gestion Ayudas Dx":
                this.xjifconsultaradx = new JIFConsultarHAyudasDx();
                Principal.cargarPantalla(this.xjifconsultaradx);
                break;
            case "Gestion Hc":
                this.xjifconsutlarhc = new JIFConsultarHistorial(0);
                Principal.cargarPantalla(this.xjifconsutlarhc);
                break;
            case "Ordenes / Facturas":
                this.xjifarmado = new JIFArmado();
                Principal.cargarPantalla(this.xjifarmado);
                break;
            case "Capitación por Servicio":
                this.xjifccobrocapitacion = new JIFCuentaCobroCapitacionServicio(frm.toUpperCase(), 0);
                Principal.cargarPantalla(this.xjifccobrocapitacion);
                break;
            case "Evento Servicio":
                this.xjifccobrocapitacion = new JIFCuentaCobroCapitacionServicio(frm.toUpperCase(), 2);
                Principal.cargarPantalla(this.xjifccobrocapitacion);
                break;
            case "Capitacion Global":
                this.xjifccobrocapitaciont = new JIFCuentaCobroCapitacionGlobalT(frm.toUpperCase());
                Principal.cargarPantalla(this.xjifccobrocapitaciont);
                break;
            case "Consultar Cuentas x Empresa":
                this.xjifconsultarcuentas = new JIFConsultarCuentaxEmpresa();
                Principal.cargarPantalla(this.xjifconsultarcuentas);
                break;
            case "Generar Rips":
                this.xjifgenerarrips = new JIFGeneracionRips();
                Principal.cargarPantalla(this.xjifgenerarrips);
                break;
            case "Generar Rips Covid":
                this.generacionRipsCovid = new JIFGeneracionRipsCovid();
                Principal.cargarPantalla(this.generacionRipsCovid);
                break;
            case "Generar Rips - Extranjeros":
                this.xjifRipsExtranjeros = new JIFGeneracionRips_Extranjeros();
                Principal.cargarPantalla(this.xjifRipsExtranjeros);
                break;
            case "Capitación Global":
                this.xjifcapiacionglobal = new JIFArmarCapitacion();
                Principal.cargarPantalla(this.xjifcapiacionglobal);
                break;
            case "Reliquidación de Orden o Factura":
                this.xjifreliquidacionfac = new JIFReliquidacionFac("jifreliquidacionfactura1");
                Principal.cargarPantalla(this.xjifreliquidacionfac);
                break;
            case "Listado de Facturas x Empresa":
                this.xjifconsultarinffac = new JIFConsultarInformesE("jifconsultarinformacionf1", 0);
                Principal.cargarPantalla(this.xjifconsultarinffac);
                break;
            case "Listado de Facturas Armadas x Empresa":
                this.xjifconsultarinffac = new JIFConsultarInformesE("jifconsultarinformacionf1", 1);
                Principal.cargarPantalla(this.xjifconsultarinffac);
                break;
            case "GenerarFC":
                this.cobroMImpuestos = new JIFGenerarCuentaCobroMImpuestos("jifcuentacobromImpuestos");
                Principal.cargarPantalla(this.cobroMImpuestos);
                break;
            case "Generar FutRips":
                this.xjifgenerarfutrips = new JIFGeneracionFutRips();
                Principal.cargarPantalla(this.xjifgenerarfutrips);
                break;
            case "Generar FutRipsV2":
                this.xJIFGeneracionFutRipsV2023 = new JIFGeneracionFutRipsV2023();
                Principal.cargarPantalla(this.xJIFGeneracionFutRipsV2023);
                break;
            case "Consolidado de Cartera":
                this.xJifConsolidadoCartera = new JIF_ConsolidadoCartera();
                Principal.cargarPantalla(this.xJifConsolidadoCartera);
                break;
            case "Consolidado de Glosas":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("consolidadoglosas", frm);
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Consolidado de Glosas Definitivo":
                this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("consolidadoglosasdefinitivo", frm);
                Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
                break;
            case "Cambiar Grupo Factura y/o Imprimir":
                this.xjifcambiargrupo = new JIFCambiarGrupo("jifcambiardatosliquidacion1");
                Principal.cargarPantalla(this.xjifcambiargrupo);
                break;
            case "Informes Cartera 2193":
                this.xJIFInformesCartera2193 = new JIFInformesCartera2193();
                Principal.cargarPantalla(this.xJIFInformesCartera2193);
                break;
            case "Consolidados de pagos":
                this.xJIFF_ConsolidadoDePagos = new JIFF_ConsolidadoDePagos();
                Principal.cargarPantalla(this.xJIFF_ConsolidadoDePagos);
                break;
            case "Factura Electronica":
                this.xJIFFacturaElectronica = new JIFFacturaElectronica();
                Principal.cargarPantalla(this.xJIFFacturaElectronica);
                break;
            case "xJIFGestionDeFactura":
                this.deFactura = new JIFGestinDeFactura();
                Principal.cargarPantalla(this.deFactura);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(9, "INFORMES GENERALES", "jif_ReportesPyP_GestionCuenta");
                Principal.cargarPantalla(this.jifreportes);
                break;
            case "Reliquidar Ordenes Convenio":
                this.jifReliquidarCuentasCapita = new JIFReliquidarCuentasCapitaController();
                Principal.cargarPantalla(this.jifReliquidarCuentasCapita);
                break;
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifdigitaciondx":
                this.xjifdigitaciondx.mBuscar();
                break;
            case "xjifauditoriaarmadoproc":
                this.xjifarmadoproc.mBuscar();
                break;
            case "jifradicacionmasivafacturas":
                this.radicacionMasiva.buscar();
                break;
            case "xjifarmado":
                this.xjifarmado.mBuscar();
                break;
            case "jifcuentacobrocapitacionserv":
                this.xjifccobrocapitacion.mBuscar();
                break;
            case "jifcuentacobrocapitacionglobalt":
                this.xjifccobrocapitaciont.mBuscar();
                break;
            case "jifconsultarcuentacobroempresa":
                this.xjifconsultarcuentas.mBuscar();
                break;
            case "xjifgestioncartera":
                this.xjifgestioncartera.mBuscar();
                break;
            case "xjifconciliacioncartera":
                this.xjifconciliacioncartera.mBuscar();
                break;
            case "jifcuentacobrom2":
                this.xjif_generarFC.mBuscar();
                break;
            case "jifgestion_pagos":
                this.xJifPagosGrupales.mBuscar();
                break;
            case "xjif_consultarDG":
            case "xjif_consultarDG1":
                this.xjif_consultar_datosG.mBuscar();
                break;
            case "consolidadoglosasdefinitivo":
            case "consolidadoglosas":
            case "consolidadocartera":
                this.xJIFFConsultarInformacionGenerico.mBuscar();
                break;
            case "xjifconsolidadoCartera":
                this.xJifConsolidadoCartera.mBuscar();
                break;
            case "xjif_generacion_circular030":
                this.xJifGeneracionCircular030.mBuscar();
                break;
            case "jIFInformesCartera2193":
                this.xJIFInformesCartera2193.buscar();
                break;
            case "jiff_ConsolidadosDePagos":
                this.xJIFF_ConsolidadoDePagos.mBuscar();
                break;
            case "jifFacturaElectronica":
                this.xJIFFacturaElectronica.mBuscar();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mBuscar();
                break;
            case "jif_ReportesPyP_GestionCuenta":
                this.jifreportes.mBuscar();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifdigitaciondx":
                this.xjifdigitaciondx.mGrabar();
                break;
            case "jifradicacionmasivafacturas":
                this.radicacionMasiva.grabar();
                break;
            case "xjifauditoriaarmadoproc":
                this.xjifarmadoproc.mGrabar();
                break;
            case "xjifarmado":
                this.xjifarmado.mGrabar();
                break;
            case "jifcuentacobrocapitacionserv":
                this.xjifccobrocapitacion.mGrabar();
                break;
            case "jifcuentacobrocapitacionglobalt":
                this.xjifccobrocapitaciont.mGrabar();
                break;
            case "jifarmadocapitacion":
                this.xjifcapiacionglobal.mGrabar();
                break;
            case "jifreliquidacionfactura1":
                this.xjifreliquidacionfac.mGrabar();
                break;
            case "jifcuentacobrom2":
                this.xjif_generarFC.mGrabar();
                break;
            case "jifgestion_pagos":
                this.xJifPagosGrupales.mGrabar();
                break;
            case "jifcambiardatosliquidacion1":
                this.xjifcambiargrupo.mGrabar();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mGrabar();
                break;
            case "jifReliquidarCuentasCapita":
                this.jifReliquidarCuentasCapita.mGrabar();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifdigitaciondx":
                this.xjifdigitaciondx.mNuevo();
                break;
            case "jifradicacionmasivafacturas":
                this.radicacionMasiva.nuevo();
                break;
            case "xjifauditoriaarmadoproc":
                this.xjifarmadoproc.mNuevo();
                break;
            case "xjifarmado":
                this.xjifarmado.mNuevo();
                break;
            case "jifcuentacobrocapitacionserv":
                this.xjifccobrocapitacion.mNuevo();
                break;
            case "jifcuentacobrocapitacionglobalt":
                this.xjifccobrocapitaciont.mNuevo();
                break;
            case "jifconsultarcuentacobroempresa":
                this.xjifconsultarcuentas.mNuevo();
                break;
            case "jifarmadocapitacion":
                this.xjifcapiacionglobal.mNuevo();
                break;
            case "xjifgestioncartera":
                this.xjifgestioncartera.mNuevo();
                break;
            case "xjifconciliacioncartera":
                this.xjifconciliacioncartera.mNuevo();
                break;
            case "jifgestion_pagos":
                this.xJifPagosGrupales.mNuevo();
                break;
            case "xjif_consultarDG":
            case "xjif_consultarDG1":
                this.xjif_consultar_datosG.mNuevo();
                break;
            case "jifcuentacobrom2":
                this.xjif_generarFC.mNuevo();
                break;
            case "consolidadoglosasdefinitivo":
            case "consolidadoglosas":
            case "consolidadocartera":
                this.xJIFFConsultarInformacionGenerico.mNuevo();
                break;
            case "xjifconsolidadoCartera":
                this.xJifConsolidadoCartera.mNuevo();
                break;
            case "jifcambiardatosliquidacion1":
                this.xjifcambiargrupo.mNuevo();
                break;
            case "jIFInformesCartera2193":
                this.xJIFInformesCartera2193.nuevo();
                break;
            case "jifFacturaElectronica":
                this.xJIFFacturaElectronica.mNuevo();
                break;
            case "jifgeneracionrips":
                this.xjifgenerarrips.mNuevo();
                break;
            case "xJIFGestionDeFactura":
                this.deFactura.nuevo();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mNuevo();
                break;
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "xjifauditoriaarmadoproc":
                this.xjifarmadoproc.mAnular();
                break;
            case "xjifarmado":
                this.xjifarmado.mAnular();
                break;
            case "jifcuentacobrom2":
                this.cobroMImpuestos.mNuevo();
                break;
            case "jifconsultarcuentacobroempresa":
                this.xjifconsultarcuentas.mAnular();
                break;
            case "xjifgestioncartera":
                this.xjifgestioncartera.mAnular();
                break;
            case "jifgestion_pagos":
                this.xJifPagosGrupales.mAnular();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mAnular();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "jifcuentacobrocapitacionserv":
                this.xjifccobrocapitacion.mImprimir();
                break;
            case "jifconsultarcuentacobroempresa":
                this.xjifconsultarcuentas.mImprimir();
                break;
            case "xjifgestioncartera":
                this.xjifgestioncartera.mImprimir();
                break;
            case "jifcuentacobrom2":
                this.cobroMImpuestos.mNuevo();
                break;
            case "jifreliquidacionfactura1":
                this.xjifreliquidacionfac.mImprimir();
                break;
            case "xjifarmado":
                this.xjifarmado.mImprimir();
                break;
            case "xjifconsolidadoCartera":
                this.xJifConsolidadoCartera.mImprimir();
                break;
            case "jifcambiardatosliquidacion1":
                this.xjifcambiargrupo.mImprimir();
                break;
            case "jifFacturaElectronica":
                this.xJIFFacturaElectronica.mImprimir();
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos.mImprimir();
                break;
        }
    }

    public void imprimir_FacturayOrden(int op, String NoFactura, String idIngreso, String UsuarioS, int esCapitado, int TipoFactura, String N_Ips, int crearPDF) {
        if (Principal.informacionIps.getAplicaFacturaElectronica().booleanValue()) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.visualizarFacturasEventoMetodoPrinicpal(idIngreso, "0", "0", "0", "0", "0", "0", 1, crearPDF);
            return;
        }
        String[][] mparametros = new String[8][2];
        new convertirNumerosLetras();
        this.sql = null;
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = idIngreso;
        mparametros[1][0] = "usuarioSiste";
        mparametros[1][1] = UsuarioS;
        mparametros[2][0] = "valorletra";
        mparametros[3][0] = "ruta";
        mparametros[3][1] = this.xmt.getRutaRep();
        mparametros[4][0] = "noFactura";
        mparametros[4][1] = NoFactura;
        mparametros[5][0] = "ntriage";
        mparametros[5][1] = this.xct.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
        mparametros[6][0] = "SUBREPORT_DIR";
        mparametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[7][0] = "SUBREPORTFIRMA_DIR";
        mparametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xct.cerrarConexionBd();
        if (esCapitado == 0 || esCapitado == 1) {
            switch (TipoFactura) {
                case 1:
                    this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                    String valor = this.xct.traerDato(this.sql);
                    this.xct.cerrarConexionBd();
                    mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor);
                    if (op == 0) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_NotaFCapitacionCarta", mparametros);
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_OrdenServicioMP", mparametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_NotaFCapitacionCarta", mparametros);
                    }
                    break;
                case 2:
                    this.sql = "SELECT ROUND((f_liquidacion.TotalPaciente+f_liquidacion.Copago+f_liquidacion.CuotaModeradora)) AS total FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                    String valor2 = this.xct.traerDato(this.sql);
                    this.xct.cerrarConexionBd();
                    mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor2);
                    if (op == 0) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros);
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_OrdenServicioMP", mparametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_NotaFCapitacionCartaUsuario", mparametros);
                    }
                    break;
            }
        }
        switch (TipoFactura) {
            case 1:
                this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_factura_evento.No_FacturaEvento = '" + NoFactura + "'";
                String valor3 = this.xct.traerDato(this.sql);
                this.xct.cerrarConexionBd();
                mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor3);
                if (op == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaEventoCarta", mparametros);
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_OrdenServicioMP", mparametros);
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    mImprimir_Factura(idIngreso, N_Ips, this.xmt.mConvertirNumeroLetras(valor3));
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    mImprimir_Factura(idIngreso, N_Ips, this.xmt.mConvertirNumeroLetras(valor3));
                } else {
                    mImprimir_Factura(idIngreso, N_Ips, this.xmt.mConvertirNumeroLetras(valor3));
                }
                break;
            case 2:
                this.sql = "SELECT f_liquidacion.TotalPaciente FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_factura_evento.No_FacturaEvento = '" + NoFactura + "'";
                String valor4 = this.xct.traerDato(this.sql);
                this.xct.cerrarConexionBd();
                mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor4);
                if (op == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaEventoCartaUsuario", mparametros);
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaEventoCartaUsuario", mparametros);
                }
                break;
        }
    }

    public String imprimir_FacturayOrden1(int op, String NoFactura, String idIngreso, String UsuarioS, int esCapitado, int TipoFactura, String N_Ips, int crearPDF) {
        String xarchivo = "";
        if (Principal.informacionIps.getAplicaFacturaElectronica().booleanValue()) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            xarchivo = impresionInformes.visualizarFacturasEventoMetodoPrinicpal(idIngreso, "0", "0", "0", "0", "0", "0", 1, crearPDF);
        } else {
            String[][] mparametros = new String[8][2];
            new convertirNumerosLetras();
            this.sql = null;
            mparametros[0][0] = "idingreso";
            mparametros[0][1] = idIngreso;
            mparametros[1][0] = "usuarioSiste";
            mparametros[1][1] = UsuarioS;
            mparametros[2][0] = "valorletra";
            mparametros[3][0] = "ruta";
            mparametros[3][1] = this.xmt.getRutaRep();
            mparametros[4][0] = "noFactura";
            mparametros[4][1] = NoFactura;
            mparametros[5][0] = "ntriage";
            mparametros[5][1] = this.xct.traerDato("SELECT Clasificacion FROM h_triage WHERE (IdIngreso ='" + idIngreso + "' AND Estado =0)");
            mparametros[6][0] = "SUBREPORT_DIR";
            mparametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[7][0] = "SUBREPORTFIRMA_DIR";
            mparametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xct.cerrarConexionBd();
            if (esCapitado == 0 || esCapitado == 1) {
                switch (TipoFactura) {
                    case 1:
                        this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                        String valor = this.xct.traerDato(this.sql);
                        this.xct.cerrarConexionBd();
                        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor);
                        if (op == 0) {
                            xarchivo = "F_NotaFCapitacionCarta";
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                        } else {
                            xarchivo = "F_NotaFCapitacionCarta";
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + "F_NotaFCapitacionCarta", mparametros);
                        }
                        break;
                    case 2:
                        this.sql = "SELECT ROUND((f_liquidacion.TotalPaciente+f_liquidacion.Copago+f_liquidacion.CuotaModeradora)) AS total FROM f_factura_capita AS f_factura_capita, f_liquidacion AS f_liquidacion WHERE f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_factura_capita.No_FacturaCapita = '" + NoFactura + "'";
                        String valor2 = this.xct.traerDato(this.sql);
                        this.xct.cerrarConexionBd();
                        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor2);
                        if (op == 0) {
                            xarchivo = "F_NotaFCapitacionCartaUsuario";
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                        } else {
                            xarchivo = "F_NotaFCapitacionCartaUsuario";
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                        }
                        break;
                }
            } else {
                switch (TipoFactura) {
                    case 1:
                        this.sql = "SELECT f_liquidacion.TotalPaciente FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND f_factura_evento.No_FacturaEvento = '" + NoFactura + "'";
                        String valor3 = this.xct.traerDato(this.sql);
                        this.xct.cerrarConexionBd();
                        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor3);
                        if (op == 0) {
                            xarchivo = "F_Liquidacion_Servicios";
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                        } else {
                            xarchivo = "F_Liquidacion_Servicios";
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                        }
                        break;
                    case 2:
                        this.sql = "SELECT f_liquidacion.TotalEps FROM f_factura_evento AS f_factura_evento, f_liquidacion AS f_liquidacion WHERE f_factura_evento.Id_Liquidacion = f_liquidacion.Id AND IF(f_factura_evento.`Prefijo`='',f_factura_evento.No_FacturaEvento ,CONCAT(`Prefijo`,'-',f_factura_evento.No_FacturaEvento)) = '" + NoFactura + "'";
                        String valor4 = this.xct.traerDato(this.sql);
                        this.xct.cerrarConexionBd();
                        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(valor4);
                        if (op == 0) {
                            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                xarchivo = "F_Liquidacion_Servicios_Psiquiatras";
                                this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                            } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                xarchivo = "F_Liquidacion_Servicios";
                                this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                            } else {
                                xarchivo = "F_FacturaEventoCarta";
                                this.xmt.CrearPDF(this.xmt.getRutaRep() + xarchivo, mparametros);
                            }
                        } else {
                            mImprimir_Factura(idIngreso, N_Ips, this.xmt.mConvertirNumeroLetras(valor4));
                        }
                        break;
                }
            }
        }
        return xarchivo;
    }

    public void mImprimir_Factura(String nfactura, String Nbre, String ValorLetra) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = nfactura;
        mparametros[1][0] = "valorletra";
        mparametros[1][1] = ValorLetra;
        mparametros[2][0] = "usuario";
        mparametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Nbre.equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Nbre.equals("JAIME CESAR DAJUD FERNANDEZ")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios_Dajud", mparametros);
            return;
        }
        if (Nbre.equals("COD-OPTICA UT")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios_Dajud_UMT", mparametros);
            return;
        }
        if (Nbre.equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Nbre.equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios_Psiquiatras", mparametros);
            return;
        }
        if (Nbre.equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios", mparametros);
        } else if (Nbre.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S") || Nbre.equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios_1", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Servicios", mparametros);
        }
    }
}
