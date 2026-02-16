package Acceso;

import Utilidades.Metodos;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/MetodosBotones.class */
public class MetodosBotones {
    private Principal xjp;
    private Metodos metodos = new Metodos();

    public MetodosBotones(Principal xjp) {
        this.xjp = xjp;
    }

    public void Nuevo() {
        if (Principal.PanelPpal.getComponentCount() > 0) {
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Autoriza")) {
                this.xjp.frmAutoriza.nuevo();
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultar_reciboc")) {
                Principal.clasecaja.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Agendar")) {
                Principal.clasetriage.botones(1, "Agendar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsolidadoReferencia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsolidadoReferencia")) {
                Principal.claseReferencia.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_prestamos")) {
                Principal.claserecursoshumanos.nuevo("xjif_prestamos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina")) {
                Principal.claserecursoshumanos.nuevo("xjif_NovedadesNomina");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedicaFac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedicaAdmin") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_InformeSeguimentosAM")) {
                Principal.xclaseAuditoriaMedica.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jif_hojatratamiento")) {
                Principal.claseTrancision.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexamenocupacional") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultardespacho") || Principal.PanelPpal.getSelectedFrame().getName().equals("Qco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLiqServicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_proc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_3") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_cierre_caja") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_Hosp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifautorizacion_servicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xgenerarcotizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoObstetrico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoCardiovascular") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx1") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolDescuenNomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfachora") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflistafacturasventa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultaringresossoat") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflistaordenesinternas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsultarIngresosLiquidacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFacturacionAgil") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_facturas_auditadas")) {
                Principal.clasefacturacion.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos1")) {
                Principal principal = this.xjp;
                Principal.xclasegactivo.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjig_programacion_cx")) {
                Principal principal2 = this.xjp;
                Principal.xclaseCirugia.mNuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifiprogramacion")) {
                Principal principal3 = this.xjp;
                Principal.xclaseCirugia.mNuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos")) {
                Principal.clasecaja.nuevo("Recibos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Cierre")) {
                Principal.clasecaja.nuevo("Cierre");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Consolidado")) {
                Principal.clasecaja.nuevo("Consolidado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifasignacionreciboingresos")) {
                Principal.clasecaja.nuevo("xjifasignacionreciboingresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecibosegresos")) {
                Principal.clasecaja.nuevo("xjifrecibosegresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierreegresos")) {
                Principal.clasecaja.nuevo("xjifcierreegresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaarmadoproc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifarmado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionserv") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionglobalt") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcuentacobroempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifarmadocapitacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconciliacioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarDG") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarDG1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestion_pagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolidadoglosasdefinitivo") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolidadoglosas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoCartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_generacion_circular030") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFInformesCartera2193") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifFacturaElectronica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgenerarrips") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSeguimientoSolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionmasivafacturas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos")) {
                Principal principal4 = this.xjp;
                Principal.xclasegc.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifordenservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrequisicion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcotizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFSolicitudContrato") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontratoinformecgr")) {
                Principal.clasecomprabn.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifMovManualOP_PP") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsultarInformeCgrPresupuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO_N") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTOv2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitud_new") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompromisopresupuestal")) {
                Principal.xclasePresupuesto.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifanticipo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_conolidado_concepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_causacion_nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadopersonal") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnominainformecgr") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarnominaxfecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionnuevo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeregistronovedades")) {
                Principal.claserecursoshumanos.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpuebaayd") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatiga") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionmanp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionep") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsegprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifseguimientosve") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultar_seguimientoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifso_tipoAgentes") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFSOTipoSegmento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMedicionSEG") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsoautoreportes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifframingham") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestruffier") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informeSo_SO") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_Reporte_de_seguimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_TipoSistemasVigilancia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformesistemavigilancia")) {
                Principal.xclaseso.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoordenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroplacas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifagendalecturarx")) {
                Principal.claseimagendx.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotasmedicas1")) {
                Principal.claseimagendx.nuevo("xjifnotasmedicas1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Entradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarformulas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadocierrecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSuministrosFechaInvima")) {
                Principal.xClaseInventario.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Despachos")) {
                Principal.xClaseInventario.nuevo("Despachos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ITraslados")) {
                Principal.xClaseInventario.nuevo("ITraslados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Salidas")) {
                Principal.xClaseInventario.nuevo("Salidas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Faltantes")) {
                Principal.xClaseInventario.nuevo("Faltantes");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("PrepararInventario")) {
                Principal.xClaseInventario.nuevo("PrepararInventario");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Conteo")) {
                Principal.xClaseInventario.nuevo("Conteo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CerrarInventario")) {
                Principal.xClaseInventario.nuevo("CerrarInventario");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CrearLote")) {
                Principal.xClaseInventario.nuevo("CrearLote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ModificarLote")) {
                Principal.xClaseInventario.nuevo("ModificarLote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte7")) {
                Principal.xClaseInventario.nuevo("jifreporte7");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionpendiente")) {
                Principal.xClaseInventario.nuevo("jifgestionpendiente");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudproductos")) {
                Principal.xClaseInventario.nuevo("jifsolicitudproductos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras1")) {
                Principal.xClaseInventario.nuevo("jifcompras1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras2")) {
                Principal.xClaseInventario.nuevo("jifcompras2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcierrescontables")) {
                Principal.xClaseInventario.nuevo("jifcierrescontables");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarinf")) {
                Principal.xClaseInventario.nuevo("xjifconsultarinf");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodificarcodagrup")) {
                Principal.xClaseInventario.nuevo("jifmodificarcodagrup");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodificarr")) {
                Principal.xClaseInventario.nuevo("jifmodificarr");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifadicionarp")) {
                Principal.xClaseInventario.nuevo("jifadicionarp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Temperatura Bodega")) {
                Principal.xClaseInventario.nuevo("Temperatura Bodega");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifnotamedicaSF")) {
                Principal.xClaseInventario.nuevo("jifnotamedicaSF");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodocontableI")) {
                Principal.xClaseInventario.nuevo("jifperiodocontableI");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeestradas")) {
                Principal.xClaseInventario.nuevo("jifinformeestradas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformesdespachopaciente")) {
                Principal.xClaseInventario.nuevo("jifinformeestradas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadosalidas")) {
                Principal.xClaseInventario.nuevo("xjifconsolidadosalidas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoentradas")) {
                Principal.xClaseInventario.nuevo("xjifconsolidadoentradas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Informes1.5")) {
                Principal.xClaseInventario.nuevo("Informes1.5");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_InformeDeSalidas")) {
                Principal.xClaseInventario.nuevo("jiff_InformeDeSalidas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Citas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreorganizardiaasignacioncitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaNP") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaTerapia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programar") || Principal.PanelPpal.getSelectedFrame().getName().equals("PasarTurnos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaft") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoft") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcitasxlote") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroreembolso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifalertaxusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrd") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasprofesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programación Cirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasnoatendidas")) {
                Principal.clasescita.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Llamadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CambiarIdentificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc") || Principal.PanelPpal.getSelectedFrame().getName().equals("Radicación documentos clínicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSeguimientoAuditoriaMedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudPedidoInterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbitacora") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifImporteDatosUsuarios")) {
                Principal.clasegeneral.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("IntegraFactura") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconciliacioninventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjicuentaspagar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistrofact") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmoddocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdepreciacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecuentascgi") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionterceros") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarpagos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_balancefecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_rangocuentas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_terceros") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informe Cuentas por Pagar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcuentasxpagarcontacart") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_balancegeneral") || Principal.PanelPpal.getSelectedFrame().getName().equals("MovimientoxRFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_informesvarioscontabilidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_informesestadofinanciero")) {
                Principal.xclase.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac")) {
                Principal.xclase.nuevo("jifradicacionfac");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcomprobantep")) {
                Principal.xclase.nuevo("jifcomprobantep");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresa")) {
                Principal.xclase.nuevo("jifconfempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodoc")) {
                Principal.xclase.nuevo("jifperiodoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentoc")) {
                Principal.xclase.nuevo("jifdocumentoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos")) {
                Principal.xclase.nuevo("jifregistrorecibos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobro")) {
                Principal.xclase.nuevo("jifcuentacobro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom")) {
                Principal.xclase.nuevo("jifcuentacobrom");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos")) {
                Principal.xclase.nuevo("jifcuentacobromImpuestos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionnc")) {
                Principal.xclase.nuevo("jifradicacionnc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso")) {
                Principal.xclase.nuevo("jifrgeistroreembolso");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargargasto")) {
                Principal.xclase.nuevo("jifcargargasto");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifexportarinformacionc")) {
                Principal.xclase.nuevo("jifexportarinformacionc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcosultarinformesc")) {
                Principal.xclase.nuevo("xjifcosultarinformesc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfultainfproveedeor")) {
                Principal.xclase.nuevo("jifconfultainfproveedeor");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneracioncertificadoman")) {
                Principal.xclase.nuevo("jifgeneracioncertificadoman");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgenerarcertificadoautomatico")) {
                Principal.xclase.nuevo("xjifgenerarcertificadoautomatico");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifPucGastos")) {
                Principal.xclase.nuevo("jifPucGastos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfigurarcuenta")) {
                Principal.xclase.nuevo("jifconfigurarcuenta");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos1")) {
                Principal.clascajamenor.nuevo("jifregistrorecibos1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso1")) {
                Principal.clascajamenor.nuevo("jifsolicitudreembolso1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Atencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaE") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhistoriauh") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudAlimentacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifReporteSolicitudAlimentacion")) {
                Principal.claseenfer.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte3")) {
                Principal.claseenfer.nuevo("jifreporte3");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistronota")) {
                Principal.claseenfer.nuevo("jifregistronota");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp")) {
                Principal.claseenfer.nuevo("jifregistroatencionesp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotas")) {
                Principal.claseenfer.nuevo("xjifnotas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrdEnfer")) {
                Principal.claseenfer.nuevo("jifconsultarRemOrdEnfer");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpuebaaydE")) {
                Principal.claseenfer.nuevo("xjifpuebaaydE");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama")) {
                Principal.claseenfer.nuevo("xjifcensocama");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFConsultarUnidosis")) {
                Principal.claseenfer.nuevo("xJIFConsultarUnidosis");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixToma") || Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("UsuarioxPrograma") || Principal.PanelPpal.getSelectedFrame().getName().equals("CyD") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifingresohta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifingresodiabetes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_pyp_informes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifR4505") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregactividadespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifractividadespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprogactividadespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJifGestionExamenesPyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifegresoprograma")) {
                Principal.clasepyp.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifractividadespyp")) {
                Principal.claseinformes.nuevo("jifractividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprogactividadespyp")) {
                Principal.claseinformes.nuevo("jifprogactividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregactividadespyp")) {
                Principal.claseinformes.nuevo("jifregactividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFReporteExamenOcupacional1")) {
                Principal.claseinformes.nuevo("xJIFReporteExamenOcupacional1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizacion")) {
                Principal.claseautorizacionmp.nuevo("jifautorizacion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jpicargardescuento")) {
                Principal.claseautorizacionmp.nuevo("jpicargardescuento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultardescuentos")) {
                Principal.claseautorizacionmp.nuevo("jifconsultardescuentos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarrelacioncobro")) {
                Principal.claseautorizacionmp.nuevo("jifgenerarrelacioncobro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifverificacion")) {
                Principal.claseautorizacionmp.nuevo("jifverificacion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargarsoportelote")) {
                Principal.claseautorizacionmp.nuevo("jifcargarsoportelote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte1")) {
                Principal.claseautorizacionmp.nuevo("jifreporte1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmatriculape")) {
                Principal.claseautorizacionmp.nuevo("jifmatriculape");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroenvio")) {
                Principal.claseautorizacionmp.nuevo("jifregistroenvio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneraciondescuento")) {
                Principal.claseautorizacionmp.nuevo("jifgeneraciondescuento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargardescuentoacumulado")) {
                Principal.claseautorizacionmp.nuevo("jifcargardescuentoacumulado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarplantillacd")) {
                Principal.claseautorizacionmp.nuevo("jifgenerarplantillacd");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpn")) {
                Principal.claseautorizacionmp.nuevo("xjifconsultarpn");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoauditoria")) {
                Principal.claseautorizacionmp.nuevo("xjifconsolidadoauditoria");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotasmedicas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifjuntamedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifvisitadomiciliaria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte5") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifincapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpermisomedicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformulapyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorialadx") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrdHist") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav4") || Principal.PanelPpal.getSelectedFrame().getName().equals("JPAVale") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav3") || Principal.PanelPpal.getSelectedFrame().getName().equals("jpnotac2")) {
                Principal.clasehistoriace.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarayudasdx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifimportarayudasdxlote") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargaratencionesmanuales") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionexamenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte4") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportexusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroencuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcargarsoportelotegd") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrd") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconshc_atenciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconscprogramada") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifexportacionmasivahcpdf")) {
                Principal.clasegestiondoc.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsgcconfiguracionuno") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsgcconfiguracioncdos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroencuesta3") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformacioncove") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffasignacioncitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriahcmed") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriahcenfer") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformesupersalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformacionr4505") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriatriage1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_pyp_informes1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultas_informes_p") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultas_informes_p1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifactas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informescasosseguridadclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiFOportunidadAtencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFInformeMedicamentosSivigilia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFEstadisticaCitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffConsultarSIMEDTrimestral") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_planificacion_Familias_AIC_clinica_pajonal") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_ConsultarInformacionGenericaHospitalizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_InformePacientesFacturadosConFinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_MedicamentosEntregadosPorEPS") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_EjecucionPresupuestalPorFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifCargueInformacionEntidades") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformegenericofechas")) {
                Principal.xclasesgc.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarPrograma") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarEspecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarRadiologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarProcedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarProcedimientoDet") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoAsignacionCitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitasPorEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("RiesgoObstetrico") || Principal.PanelPpal.getSelectedFrame().getName().equals("RiesgoCardiovascular") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoAtencionFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientosEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasNoProgramadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoPorProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasPorEPS") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasUsuariosEPSyProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("DetalleEntradaPorBodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarAtenciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidOrdenConvenioProf") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadOrdenesMedico") || Principal.PanelPpal.getSelectedFrame().getName().equals("EstadisProcedLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolProcedLabDet") || Principal.PanelPpal.getSelectedFrame().getName().equals("pacienteFacAtencionLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("pacienteFacAtencionRad") || Principal.PanelPpal.getSelectedFrame().getName().equals("InformeControlPrenatar") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultaSaludOcupacionalDX") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarOrdenesProcedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultaInforLipidosCarbo") || Principal.PanelPpal.getSelectedFrame().getName().equals("totalDosiSuministradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("totalDosiSuministroEntidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("vacunacionAplicxUsuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("formuSubgruFarmacologico") || Principal.PanelPpal.getSelectedFrame().getName().equals("empresaConveFarmacologico") || Principal.PanelPpal.getSelectedFrame().getName().equals("informeRes4725") || Principal.PanelPpal.getSelectedFrame().getName().equals("informeRes2463") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informe Resolucion 4725") || Principal.PanelPpal.getSelectedFrame().getName().equals("produccionPorSedeYProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("consultaPrenatal") || Principal.PanelPpal.getSelectedFrame().getName().equals("lecturaPorEmpresaYValor") || Principal.PanelPpal.getSelectedFrame().getName().equals("Censo Hospitalización") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinfoantencionprioritariaxclasificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdiagnosticosalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJif_informe_resolucion1604") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadira") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarperiododuraciontratamiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientosOrdenadosUsuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_generacion_rips_ministerio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformeanexos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformedecitasatendidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformeinterconsultas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFReportesProduccionPorSede") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadeda") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmorbilidad_mortalidad")) {
                Principal principal5 = this.xjp;
                Principal.xclasesig.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recepcion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcomentarioarea") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiporesultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Areas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Protocolos") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocolxAreaxProcedim") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocoloxTipoResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("TipoResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("GenericoLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoxexamen") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremisione") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte6") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientor") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifareas1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrodatosv") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexportaciond") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimiento1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientounificado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientorelacionado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Muestra") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_municipio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_entidad_municipio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_entidad_municipio_proc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_municipio_valor") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_procedimientos_Fac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIfValidacionResultadoInterfaz") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifestadisticamuestrasnuevas") || Principal.PanelPpal.getSelectedFrame().getName().equals("frmRecepBienestarSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhomologacionitemsexternos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifValidacionAdministrativa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifPlanillaCitologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportecitologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("ValidacionMasiva") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcionstikers_citologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTracking")) {
                Principal.claselab.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFConfigurar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos")) {
                Principal.clasemant.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinforlab1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifplacasdanadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeplacas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadosolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformacionxespecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifficha5w1h") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroindicadores") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifestudiosrealizados") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarinformes_eps") || Principal.PanelPpal.getSelectedFrame().getName().equals("agudezaVisual") || Principal.PanelPpal.getSelectedFrame().getName().equals("planificacionFamiliar") || Principal.PanelPpal.getSelectedFrame().getName().equals("jovenSano") || Principal.PanelPpal.getSelectedFrame().getName().equals("adultoSano") || Principal.PanelPpal.getSelectedFrame().getName().equals("crecimientoYDesarrollo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffSesionesXTrabajdor") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpanoramaeventos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFConsultarNovedad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformegenericoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroreuniones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteProduccion2193_V1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionordenes")) {
                Principal.xclasesgc.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitalizacionsoporte")) {
                Principal.claseDigitalizacionSoporte.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresa1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdetallecontenido1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_Notas_clinicas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdatosempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifparentesco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifparametrodetalle") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipo_Pregunta_Respuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoxcaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoestudio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcargosunidadf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifactividadsolictud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoactividadproceso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifunidadnegocio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifepreguntaxarea") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontenidohc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoalerta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifetiporespuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetallecontenidohc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontenidoxdetallehc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoexamenfisico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodetalleexamenf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmotivoanulacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetalleincumplimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifglosario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubgrupofacempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptodetalle") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptopagoglosa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffichatecnicaindicador") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifaeropuertos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdoccontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptonomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnovconceptonomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifubicacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifprocedimientoxpaquete") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifunidadfuncional") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresagrupo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaservicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcontratoempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifestrato") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgrupofactura") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubgrupofac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiposervicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifservicioxprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientoccosto") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifaprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerico1chbox") || Principal.PanelPpal.getSelectedFrame().getName().equals("Manual de Tarifas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministro") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifasuministro") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministrobodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprincipioactivo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresentacionfarma") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresentacioncomer") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconcentracion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiflaboratorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrelacionlaboral") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmovimientosbodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprofesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifespecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdepartamento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmunicipio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifetapaproceso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbarrio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsupervisor") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifturnoscitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifclaseconsultorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifclasecita") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifalertaxusuario1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifareafuncional") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenericoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptounidadf") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdetalleconceptounidadf") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoimpuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbanco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsucursal") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresupuestopuc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifimpuestoempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdatosbancoempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiporegimen") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentapucxempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcontratoempresac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipocaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoconceptocaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauxiliarxconcepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptocc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptoreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifunidadfempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariocargo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentousuariof") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinteracionmed") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifamp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformatodian") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptodian") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformatoconceptodian") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifareas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistronovedades") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpregunta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifarmadoencuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsuministroxarealab") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftcaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoprocesossgc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifocupacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifencabezadopreguntaso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetallepreguntas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariosistemas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifvacunaesquema") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreportepatologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenericocombox1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministroxTformula") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhorariomedicion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipomedida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Medición x Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Horario x Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("Demanda Inducida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Programa") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Formula") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Acción") || Principal.PanelPpal.getSelectedFrame().getName().equals("Temperatura Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("Categoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmanualesmodulos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetalleexafisico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpartesecografia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifelementospp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifantencedentespatologicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Concepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Restricción") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecomendaciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifencabezadorecomendacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsegmento_encabezado") || Principal.PanelPpal.getSelectedFrame().getName().equals("SEG") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadovisiometria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoRecomendaciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoTipoRespuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoTipoPregunta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpreguntasxSubcategorias") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoejercicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifGenerico1Text1Combo2SpinerEstado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpreguntaxdominio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFGenerico2Text2CheckBox") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifEscalaAbreviada") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpatologiacie10") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifConceptoCaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifTipoDestino") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffTipoEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfsalacirugias") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Doc Ayudas DX") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffsalacirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Profesional Sala Cirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("GrupoVr") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientoTipoQx") || Principal.PanelPpal.getSelectedFrame().getName().equals("Excepción") || Principal.PanelPpal.getSelectedFrame().getName().equals("Centro de Costo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Camas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Grupo Sistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Alerta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoperiodoscartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Cita Prioritaria") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFUnidadCama") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunas x Edad") || Principal.PanelPpal.getSelectedFrame().getName().equals("procedimientoxprioridad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Anestesia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Horario de Farmacia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Sistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Destido Salida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Concepto Agrupado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Causa Externa") || Principal.PanelPpal.getSelectedFrame().getName().equals("Estadio Glomerural") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periocidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Prioridad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periodos de Nómina") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Edad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Ambito") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Población") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periodo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Documento Presupuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("Documento Tercero Firma") || Principal.PanelPpal.getSelectedFrame().getName().equals("RubroxTipoDoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifRubrosPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjtipoconaccion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("PPResolucion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Parentesco") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifCodigoAlternos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFHistoricoSalarioMinimo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifCodigoAlterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasif Concepto Nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_unificar_usuarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMaestroRubros") || Principal.PanelPpal.getSelectedFrame().getName().equals("Nombre Encuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Sexo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoevento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Riesgo seguridad Clínica") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo De Causa Analisis") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion De Riesgo Adverso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffTProcesoTRiesgo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffTRiesgoTEvento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vigencia de Pago Facturas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifformapago") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffpprubroencabezado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informe de Procedimientos Facturados") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informe de Insumos Facturados") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifftipodocumentof") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_CExamen") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipotubo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentoS") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrutasoporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrhtipocargo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsotiporesultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion De Cita") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifactividadeconomica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnivelactividade") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipocertificadoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoconceptoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentosRH") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Categoría Seguridad Clínica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoclasificacionresiduos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroresiduos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpais") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiporiesgocomplicacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoconcentimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasificacion Tipo Complicacion de Riesgo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Producto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiposeguimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodocumentoclasificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoagrupacioncgr") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion de Imagenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffichanotificacionsivigila") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifclasificacionnotas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xEntornoFamiliar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRelacionesFamiliares") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFTipoDeInforme") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFPucTipoInforme") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFTipoHistoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFEntidadesContraloria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFOrigenIngreso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDestinacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoRecursos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoSituacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoVigencia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFinalidadGasto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRubroContraloria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconfiguracionitems") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFClasificacionLasa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifunidadmedida") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFTipoAtencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFConsultorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodof") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoAgente") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_importar_cetificado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifAuditorPorEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoComida") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoDieta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ResolucionDian") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaserviciosN") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipopoliticas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifVigilancia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifturnosjpa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodedocumentosoporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhtipoayudadx") || Principal.PanelPpal.getSelectedFrame().getName().equals("fPeligros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhtipodocumentoshc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenero") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsexo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Agenda") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprueba") || Principal.PanelPpal.getSelectedFrame().getName().equals("MedioDePago") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifftiposistemavigilancia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifftipovigilanciasistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodalidadatencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipomedicamento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcodigoservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasificación AIEPI") || Principal.PanelPpal.getSelectedFrame().getName().equals("Respuestas AIEPI") || Principal.PanelPpal.getSelectedFrame().getName().equals("Preguntas AIEPI Oncologíco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifserviciosrips") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipodestino") || Principal.PanelPpal.getSelectedFrame().getName().equals("Unidad Minima Dispensacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Procedimiento Servicio Rips") || Principal.PanelPpal.getSelectedFrame().getName().equals("Procedimiento Tipo Finalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifPrueba")) {
                Principal.claseparametrizacionn.nuevo(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione alguna Pantalla");
    }

    public void mGrabar() {
        String name = Principal.PanelPpal.getSelectedFrame().getName();
        System.out.println("------------------" + name);
        if (Principal.PanelPpal.getComponentCount() > 0) {
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Agendar")) {
                Principal.clasetriage.botones(2, "Agendar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Triage")) {
                Principal.clasetriage.botones(2, "Triage");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Autoriza")) {
                this.xjp.frmAutoriza.grabar();
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xejemploauditoria")) {
                Principal.xclaseAuditoriaMedica.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_prestamos")) {
                Principal.claserecursoshumanos.grabar("xjif_prestamos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina")) {
                Principal.claserecursoshumanos.grabar("xjif_NovedadesNomina");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionnuevo")) {
                Principal.claserecursoshumanos.grabar("xjif_liquidacionnuevo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrequisicion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifordenservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcotizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFSolicitudContrato")) {
                Principal.clasecomprabn.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifanticipo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriacp1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionn") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_causacion_nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_gestion_concepto_empleado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFDesactivarOActivarEmpleado")) {
                Principal.claserecursoshumanos.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjig_programacion_cx")) {
                Principal principal = this.xjp;
                Principal.xclaseCirugia.mGrabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpuebaayd") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatiga") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionmanp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsegprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifso_tipoAgentes") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFSOTipoSegmento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMedicionSEG") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_TipoSistemasVigilancia")) {
                Principal.xclaseso.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos1")) {
                Principal principal2 = this.xjp;
                Principal.xclasegactivo.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos")) {
                Principal.clasecaja.grabar("Recibos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Cierre")) {
                Principal.clasecaja.grabar("Cierre");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Consolidado")) {
                Principal.clasecaja.grabar("Consolidado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifasignacionreciboingresos")) {
                Principal.clasecaja.grabar("xjifasignacionreciboingresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecibosegresos")) {
                Principal.clasecaja.grabar("xjifrecibosegresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierreegresos")) {
                Principal.clasecaja.grabar("xjifcierreegresos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("Qco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexamenocupacional") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp1") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionlab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionlabBienestar") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsautorizaciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLiqServicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_cierre_caja") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifautorizacion_servicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xgenerarcotizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoObstetrico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoCardiovascular") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFServicioEmpresaConvenio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifautorizacion_servicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFacturacionAgil") || Principal.PanelPpal.getSelectedFrame().getName().equals("Agenda")) {
                Principal.clasefacturacion.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaarmadoproc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifarmado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionserv") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionglobalt") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifarmadocapitacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestion_pagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionmasivafacturas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifReliquidarCuentasCapita")) {
                Principal principal3 = this.xjp;
                Principal.xclasegc.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Entradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpsrotacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmonitoreoinventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifajustarpminmax")) {
                Principal.xClaseInventario.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Despachos")) {
                Principal.xClaseInventario.grabar("Despachos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Salidas")) {
                Principal.xClaseInventario.grabar("Salidas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ITraslados")) {
                Principal.xClaseInventario.grabar("ITraslados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Faltantes")) {
                Principal.xClaseInventario.grabar("Faltantes");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("PrepararInventario")) {
                Principal.xClaseInventario.grabar("PrepararInventario");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Conteo")) {
                Principal.xClaseInventario.grabar("Conteo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CerrarInventario")) {
                Principal.xClaseInventario.grabar("CerrarInventario");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CrearLote")) {
                Principal.xClaseInventario.grabar("CrearLote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ModificarLote")) {
                Principal.xClaseInventario.grabar("ModificarLote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte7")) {
                Principal.xClaseInventario.grabar("jifreporte7");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministrolote")) {
                Principal.xClaseInventario.grabar("jifsuministrolote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudproductos")) {
                Principal.xClaseInventario.grabar("jifsolicitudproductos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras1")) {
                Principal.xClaseInventario.grabar("jifcompras1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jismodificarsolicitudp")) {
                Principal.xClaseInventario.grabar("jismodificarsolicitudp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionpendiente")) {
                Principal.xClaseInventario.grabar("jifgestionpendiente");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras2")) {
                Principal.xClaseInventario.grabar("jifcompras2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcierrescontables")) {
                Principal.xClaseInventario.grabar("jifcierrescontables");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodificarcodagrup")) {
                Principal.xClaseInventario.grabar("jifmodificarcodagrup");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodificarr")) {
                Principal.xClaseInventario.grabar("jifmodificarr");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifadicionarp")) {
                Principal.xClaseInventario.grabar("jifadicionarp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Temperatura Bodega")) {
                Principal.xClaseInventario.grabar("Temperatura Bodega");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifnotamedicaSF")) {
                Principal.xClaseInventario.grabar("jifnotamedicaSF");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodocontableI")) {
                Principal.xClaseInventario.grabar("jifperiodocontableI");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Llamadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CambiarIdentificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroencuesta1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes1") || Principal.PanelPpal.getSelectedFrame().getName().equals("Radicación documentos clínicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFGEmpresaUnificacionUsuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudPedidoInterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifImporteDatosUsuarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbitacora")) {
                Principal.clasegeneral.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientolab1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroreembolso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcitasxlote") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcierreft") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoft") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaft") || Principal.PanelPpal.getSelectedFrame().getName().equals("PasarTurnos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programar") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaNP") || Principal.PanelPpal.getSelectedFrame().getName().equals("Citas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifalertaxusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp2") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programación Cirugia")) {
                Principal.clasescita.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotasmedicas1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionar_rx") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroplacas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoordenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflecturaoit")) {
                Principal.claseimagendx.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifPTOInicial") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifMovimientoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifMovManualOP_PP") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTOv2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO_N") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitud_new") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompromisopresupuestal")) {
                Principal.xclasePresupuesto.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("IntegraFactura")) {
                Principal.xclase.grabar("IntegraFactura");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac")) {
                Principal.xclase.grabar("jifradicacionfac");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresa")) {
                Principal.xclase.grabar("jifconfempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresabienestar")) {
                Principal.xclase.grabar("jifconfempresabienestar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcomprobantep")) {
                Principal.xclase.grabar("jifcomprobantep");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodoc")) {
                Principal.xclase.grabar("jifperiodoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriacp")) {
                Principal.xclase.grabar("jifauditoriacp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarpagos")) {
                Principal.xclase.grabar("jifgenerarpagos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentoc")) {
                Principal.xclase.grabar("jifdocumentoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargarsoportelote1")) {
                Principal.xclase.grabar("jifcargarsoportelote1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos")) {
                Principal.xclase.grabar("jifregistrorecibos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso")) {
                Principal.xclase.grabar("jifsolicitudreembolso");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobro")) {
                Principal.xclase.grabar("jifcuentacobro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifajustedoc")) {
                Principal.xclase.grabar("jifajustedoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom")) {
                Principal.xclase.grabar("jifcuentacobrom");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos")) {
                Principal.xclase.grabar("jifcuentacobromImpuestos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionnc")) {
                Principal.xclase.grabar("jifradicacionnc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso")) {
                Principal.xclase.grabar("jifrgeistroreembolso");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargargasto")) {
                Principal.xclase.grabar("jifcargargasto");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos3")) {
                Principal.xclase.grabar("jifautorizaciondocumentos3");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocn")) {
                Principal.xclase.grabar("jifautorizaciondocn");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfigurarcuenta")) {
                Principal.xclase.grabar("jifconfigurarcuenta");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifPucGastos")) {
                Principal.xclase.grabar("jifPucGastos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneracioncertificadoman")) {
                Principal.xclase.grabar("jifgeneracioncertificadoman");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgenerarcertificadoautomatico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistrofact") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmoddocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdepreciacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecuentascgi") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarpagos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpagosnominac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptocc1")) {
                Principal.xclase.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos1")) {
                Principal.clascajamenor.grabar("jifregistrorecibos1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso1")) {
                Principal.clascajamenor.grabar("jifsolicitudreembolso1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudReembolso2")) {
                Principal.clascajamenor.grabar("jifsolicitudreembolso2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Atencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaE") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhistoriauh") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudAlimentacion")) {
                Principal.claseenfer.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte3")) {
                Principal.claseenfer.grabar("jifreporte3");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistronota")) {
                Principal.claseenfer.grabar("jifregistronota");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp")) {
                Principal.claseenfer.grabar("jifregistroatencionesp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotas")) {
                Principal.claseenfer.grabar("xjifnotas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpuebaaydE")) {
                Principal.claseenfer.grabar("xjifpuebaaydE");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixToma")) {
                Principal.clasepyp.grabar("CACervixToma");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixResultado")) {
                Principal.clasepyp.grabar("CACervixResultado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunacion")) {
                Principal.clasepyp.grabar("Vacunacion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("UsuarioxPrograma")) {
                Principal.clasepyp.grabar("UsuarioxPrograma");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CyD")) {
                Principal.clasepyp.grabar("CyD");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifingresodiabetes")) {
                Principal.clasepyp.grabar("xjifingresodiabetes");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifractividadespyp")) {
                Principal.clasepyp.grabar("jifractividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprogactividadespyp")) {
                Principal.clasepyp.grabar("jifprogactividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifractividadespyp")) {
                Principal.claseinformes.grabar("jifractividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprogactividadespyp")) {
                Principal.claseinformes.grabar("jifprogactividadespyp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrefnutricion")) {
                Principal.claseinformes.grabar("jifrefnutricion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreferenciac")) {
                Principal.claseinformes.grabar("xjifreferenciac");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizacion")) {
                Principal.claseautorizacionmp.grabar("jifautorizacion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jpicargardescuento")) {
                Principal.claseautorizacionmp.grabar("jpicargardescuento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifverificacion")) {
                Principal.claseautorizacionmp.grabar("jifverificacion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarrelacioncobro")) {
                Principal.claseautorizacionmp.grabar("jifgenerarrelacioncobro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargarsoportelote")) {
                Principal.claseautorizacionmp.grabar("jifcargarsoportelote");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte1")) {
                Principal.claseautorizacionmp.grabar("jifreporte1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmatriculape")) {
                Principal.claseautorizacionmp.grabar("jifmatriculape");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroenvio")) {
                Principal.claseautorizacionmp.grabar("jifregistroenvio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneraciondescuento")) {
                Principal.claseautorizacionmp.grabar("jifgeneraciondescuento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargardescuentoacumulado")) {
                Principal.claseautorizacionmp.grabar("jifcargardescuentoacumulado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarplantillacd")) {
                Principal.claseautorizacionmp.grabar("jifgenerarplantillacd");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubirplantillad")) {
                Principal.claseautorizacionmp.grabar("jifsubirplantillad");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriafmp")) {
                Principal.claseautorizacionmp.grabar("jifauditoriafmp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpnoautorizados")) {
                Principal.claseautorizacionmp.grabar("jifpnoautorizados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav4") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformulapyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpermisomedicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifincapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte5") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifvisitadomiciliaria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifjuntamedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotasmedicas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientolab") || Principal.PanelPpal.getSelectedFrame().getName().equals("JPAVale") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav3")) {
                Principal.clasehistoriace.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarayudasdx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftranferenciadoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifimportarayudasdxlote") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargaratencionesmanuales") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionexamenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte4") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreporte1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroencuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcargarsoportelotegd")) {
                Principal.clasegestiondoc.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsgcconfiguracionuno") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsgcconfiguracioncdos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroencuesta3") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifficha5w1h") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroindicadores") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreferenciac3") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifactas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroreuniones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifCargueInformacionEntidades")) {
                Principal.xclasesgc.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recepcion") || Principal.PanelPpal.getSelectedFrame().getName().equals("frmRecepBienestarSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcomentarioarea") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiporesultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifareas1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrodatosv") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimiento1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIfValidacionResultadoInterfaz") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhomologacionitemsexternos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTracking")) {
                Principal.claselab.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual")) {
                Principal.claselab.grabar("TomaManual");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Areas")) {
                Principal.claselab.grabar("Areas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Protocolos")) {
                Principal.claselab.grabar("Protocolos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocolxAreaxProcedim")) {
                Principal.claselab.grabar("ProtocolxAreaxProcedim");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocoloxTipoResultado")) {
                Principal.claselab.grabar("ProtocoloxTipoResultado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("TipoResultado")) {
                Principal.claselab.grabar("TipoResultado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual")) {
                Principal.claselab.grabar("ResultadoManual");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ConfProcedimiento")) {
                Principal.claselab.grabar("Procedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("GenericoLab")) {
                Principal.claselab.grabar("GenericoLab");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifremisione")) {
                Principal.claselab.grabar("jifremisione");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifremision2")) {
                Principal.claselab.grabar("jifremision2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoxexamen")) {
                Principal.claselab.grabar("jifresultadoxexamen");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte6")) {
                Principal principal4 = this.xjp;
                Principal.claselab.grabar("jifreporte6");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio1")) {
                Principal.claselab.grabar("jifconstanciaservicio1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientor")) {
                Principal.claselab.grabar("jifprocedimientor");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Registro de Rechazo de Muestra")) {
                Principal.claselab.grabar("Registro de Rechazo de Muestra");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientorelacionado")) {
                Principal.claselab.grabar("jifprocedimientorelacionado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientounificado")) {
                Principal.claselab.grabar("jifprocedimientounificado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Muestra")) {
                Principal.claselab.grabar("Tipo Muestra");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ValidacionMasiva")) {
                Principal.claselab.grabar("ValidacionMasiva");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte")) {
                Principal.clasemant.grabar("jifreporte");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("seguimiento")) {
                Principal.clasemant.grabar("seguimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFConfigurar")) {
                Principal.clasemant.grabar("JIFConfigurar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Seguimiento_Mantenimiento")) {
                Principal.clasemant.grabar("Seguimiento_Mantenimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFEquiposdebaja")) {
                Principal.clasemant.grabar("JIFEquiposdebaja");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFCalibrar")) {
                Principal principal5 = this.xjp;
                Principal.clasemant.grabar("JIFCalibrar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("seguimiento")) {
                Principal.clasemant.grabar("Seguimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte")) {
                Principal.clasemant.grabar("jifreporte");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenericoc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifubicacion1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos")) {
                Principal.clasemant.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFServiciosMantenimiento")) {
                Principal.claseparametrizacion.grabar("JIFServiciosMantenimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiflaboratorio")) {
                Principal.claseparametrizacion.grabar("jiflaboratorio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifprocedimientoxpaquete")) {
                Principal principal6 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjifprocedimientoxpaquete");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifunidadfuncional")) {
                Principal principal7 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifunidadfuncional");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodedocumentosoporte")) {
                Principal principal8 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjiftipodedocumentosoporte");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhtipoayudadx")) {
                Principal principal9 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjifhtipoayudadx");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhtipodocumentoshc")) {
                Principal principal10 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjifhtipodocumentoshc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("MedioDePago")) {
                Principal principal11 = this.xjp;
                Principal.claseparametrizacionn.grabar("MedioDePago");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFRespuestos")) {
                Principal principal12 = this.xjp;
                Principal.claseparametrizacion.grabar("JIFRespuestos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFRegistroTecnico")) {
                Principal.claseparametrizacion.grabar("JIFRegistroTecnico");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFComponentes")) {
                Principal.claseparametrizacion.grabar("JIFComponentes");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFFrecuencias")) {
                Principal.claseparametrizacion.grabar("JIFFrecuencias");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFNormalidades")) {
                Principal.claseparametrizacion.grabar("JIFNormalidades");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFManuales")) {
                Principal.claseparametrizacion.grabar("JIFManuales");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFProcedimientos")) {
                Principal.claseparametrizacion.grabar("JIFProcedimientos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresa1")) {
                Principal principal13 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconfempresa1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifestratoempresa")) {
                Principal principal14 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifestratoempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresagrupo")) {
                Principal principal15 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifempresagrupo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaservicios")) {
                Principal principal16 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifempresaservicios");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaserviciosN")) {
                Principal principal17 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifempresaserviciosN");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifempresaprocedimiento")) {
                Principal principal18 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifempresaprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcontratoempresa")) {
                Principal principal19 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifcontratoempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariosistemas")) {
                Principal principal20 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifusuariosistemas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifestrato")) {
                Principal principal21 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifestrato");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgrupofactura")) {
                Principal principal22 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifgrupofactura");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubgrupofac")) {
                Principal principal23 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifsubgrupofac");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoprocedimiento")) {
                Principal principal24 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftipoprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiposervicio")) {
                Principal principal25 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftiposervicio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifservicioxprocedimiento")) {
                Principal principal26 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifservicioxprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimiento")) {
                Principal principal27 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientoccosto")) {
                Principal principal28 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifprocedimientoccosto");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifaprocedimiento")) {
                Principal principal29 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftarifaprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerico1chbox")) {
                Principal principal30 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifgenerico1chbox");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Manual de Tarifas")) {
                Principal principal31 = this.xjp;
                Principal.claseparametrizacionn.grabar("Manual de Tarifas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifaumentotarifas")) {
                Principal principal32 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifaumentotarifas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministro")) {
                Principal principal33 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifsuministro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifasuministro")) {
                Principal principal34 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftarifasuministro");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministrobodega")) {
                Principal principal35 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifsuministrobodega");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprincipioactivo")) {
                Principal principal36 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifprincipioactivo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresentacionfarma")) {
                Principal principal37 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifpresentacionfarma");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresentacioncomer")) {
                Principal principal38 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifpresentacioncomer");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconcentracion")) {
                Principal principal39 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconcentracion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiflaboratorio1")) {
                Principal principal40 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiflaboratorio1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrelacionlaboral")) {
                Principal principal41 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifrelacionlaboral");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifbodega")) {
                Principal principal42 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifbodega");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmovimientosbodega")) {
                Principal principal43 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifmovimientosbodega");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprofesional")) {
                Principal principal44 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifprofesional");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifespecialidad")) {
                Principal principal45 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifespecialidad");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdatosempresa")) {
                Principal principal46 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifdatosempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdepartamento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifocupacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_Notas_clinicas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifactividadsolictud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifparentesco") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifepreguntaxarea") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoactividadproceso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifunidadnegocio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjtipoconaccion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipo_Pregunta_Respuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontenidohc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifglosario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetalleincumplimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetallecontenidohc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontenidoxdetallehc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoexamenfisico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmotivoanulacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubgrupofacempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptodetalle") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptopagoglosa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffichatecnicaindicador") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifaeropuertos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdoccontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptonomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnovconceptonomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifubicacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifencabezadopreguntaso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetallepreguntas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Doc Ayudas DX") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_unificar_usuarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifturnosjpa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprueba") || Principal.PanelPpal.getSelectedFrame().getName().equals("MedioDePago")) {
                Principal principal47 = this.xjp;
                Principal.claseparametrizacionn.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmunicipio")) {
                Principal principal48 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifmunicipio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifetapaproceso")) {
                Principal principal49 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifetapaproceso");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifbarrio")) {
                Principal principal50 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifbarrio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsupervisor")) {
                Principal principal51 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifsupervisor");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifturnoscitas")) {
                Principal principal52 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifturnoscitas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifclaseconsultorio")) {
                Principal principal53 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifclaseconsultorio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultorio")) {
                Principal principal54 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconsultorio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifclasecita")) {
                Principal principal55 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifclasecita");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifalertaxusuario1")) {
                Principal principal56 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifalertaxusuario1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifareafuncional")) {
                Principal principal57 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifareafuncional");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenericoc")) {
                Principal principal58 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifgenericoc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptounidadf")) {
                Principal principal59 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconceptounidadf");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdetalleconceptounidadf")) {
                Principal principal60 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifdetalleconceptounidadf");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoimpuesto")) {
                Principal principal61 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftipoimpuesto");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifbanco")) {
                Principal principal62 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifbanco");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsucursal")) {
                Principal principal63 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifsucursal");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresupuestopuc")) {
                Principal principal64 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifpresupuestopuc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifimpuestoempresa")) {
                Principal principal65 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifimpuestoempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdatosbancoempresa")) {
                Principal principal66 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifdatosbancoempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiporegimen")) {
                Principal principal67 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftiporegimen");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentapucxempresa")) {
                Principal principal68 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifcuentapucxempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcontratoempresac")) {
                Principal principal69 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifcontratoempresac");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipocaja")) {
                Principal principal70 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftipocaja");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoconceptocaja")) {
                Principal principal71 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftipoconceptocaja");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifauxiliarxconcepto")) {
                Principal principal72 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifauxiliarxconcepto");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpresupuestopucn")) {
                Principal principal73 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifpresupuestopucn");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura")) {
                Principal principal74 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifreliquidacionfactura");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptocc")) {
                Principal principal75 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconceptocc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptoreembolso")) {
                Principal principal76 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconceptoreembolso");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifunidadfempresa")) {
                Principal principal77 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifunidadfempresa");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariocargo")) {
                Principal principal78 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifusuariocargo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentousuariof")) {
                Principal principal79 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifdocumentousuariof");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifinteracionmed")) {
                Principal principal80 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifinteracionmed");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftarifamp")) {
                Principal principal81 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftarifamp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifformatodian")) {
                Principal principal82 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifformatodian");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconceptodian")) {
                Principal principal83 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifconceptodian");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifformatoconceptodian")) {
                Principal principal84 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifformatoconceptodian");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifareas")) {
                Principal principal85 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjifareas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistronovedades")) {
                Principal principal86 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifregistronovedades");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifpregunta")) {
                Principal principal87 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifpregunta");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifarmadoencuesta")) {
                Principal principal88 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifarmadoencuesta");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftcaja")) {
                Principal principal89 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftcaja");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoprocesossgc")) {
                Principal principal90 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftipoprocesossgc");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifvacunaesquema")) {
                Principal principal91 = this.xjp;
                Principal.claseparametrizacionn.grabar("jifvacunaesquema");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifVigilancia")) {
                Principal principal92 = this.xjp;
                Principal.claseparametrizacionn.grabar("xjifVigilancia");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftecnologiaSalud")) {
                Principal principal93 = this.xjp;
                Principal.claseparametrizacionn.grabar("jiftecnologiaSalud");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("MedioDePago")) {
                Principal principal94 = this.xjp;
                Principal.claseparametrizacionn.grabar("MedioDePago");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsuministroxarealab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoalerta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifetiporespuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoperiodoscartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdetallecontenido1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifparametrodetalle") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoxcaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("GrupoVr") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcargosunidadf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodetalleexamenf") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreportepatologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Formula") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenericocombox1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministroxTformula") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhorariomedicion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipomedida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Medición x Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Horario x Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("Demanda Inducida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Programa") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Acción") || Principal.PanelPpal.getSelectedFrame().getName().equals("Categoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifequipoxprocedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmanualesmodulos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdetalleexafisico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpartesecografia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifelementospp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifantencedentespatologicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Concepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Restricción") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifencabezadorecomendacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsegmento_encabezado") || Principal.PanelPpal.getSelectedFrame().getName().equals("SEG") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadovisiometria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoRecomendaciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoPeligrosSubcategoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoTipoRespuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSoTipoPregunta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpreguntasxSubcategorias") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoejercicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifGenerico1Text1Combo2SpinerEstado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpreguntaxdominio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFGenerico2Text2CheckBox") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifEscalaAbreviada") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpatologiacie10") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifConceptoCaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifTipoDestino") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffTipoEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfsalacirugias") || Principal.PanelPpal.getSelectedFrame().getName().equals("Profesional Sala Cirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffsalacirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientoTipoQx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoatencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Excepción") || Principal.PanelPpal.getSelectedFrame().getName().equals("Centro de Costo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Camas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Horario de Farmacia") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFUnidadCama") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Cita Prioritaria") || Principal.PanelPpal.getSelectedFrame().getName().equals("Grupo Sistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Alerta") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunas x Edad") || Principal.PanelPpal.getSelectedFrame().getName().equals("procedimientoxprioridad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Anestesia") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Sistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Destido Salida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Concepto Agrupado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Causa Externa") || Principal.PanelPpal.getSelectedFrame().getName().equals("Estadio Glomerural") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periocidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Prioridad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periodos de Nómina") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Edad") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Ambito") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Población") || Principal.PanelPpal.getSelectedFrame().getName().equals("Periodo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Documento Presupuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("Documento Tercero Firma") || Principal.PanelPpal.getSelectedFrame().getName().equals("RubroxTipoDoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifRubrosPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMaestroRubros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifJIFFRubroTDoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoestudio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("PPResolucion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Parentesco") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifCodigoAlternos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFHistoricoSalarioMinimo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifCodigoAlterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasif Concepto Nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("Nombre Encuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Sexo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoevento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Riesgo seguridad Clínica") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo De Causa Analisis") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion De Riesgo Adverso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffTProcesoTRiesgo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffTRiesgoTEvento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vigencia de Pago Facturas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifformapago") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffpprubroencabezado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifftipodocumentof") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipotubo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentoS") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrutasoporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrhtipocargo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsotiporesultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion De Cita") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifactividadeconomica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnivelactividade") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipocertificadoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoconceptoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDocumentosRH") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Categoría Seguridad Clínica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoclasificacionresiduos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroresiduos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifpais") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiporiesgocomplicacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipoconcentimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasificacion Tipo Complicacion de Riesgo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo de Producto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftiposeguimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipodocumentoclasificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconceptoagrupacioncgr") || Principal.PanelPpal.getSelectedFrame().getName().equals("Tipo Clasificacion de Imagenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffichanotificacionsivigila") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifclasificacionnotas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xEntornoFamiliar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRelacionesFamiliares") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFPucTipoInforme") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFTipoDeInforme") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFTipoHistoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFEntidadesContraloria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFOrigenIngreso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoDestinacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoRecursos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoSituacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFTipoVigencia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFinalidadGasto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRubroContraloria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconfiguracionitems") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFClasificacionLasa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifunidadmedida") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFTipoAtencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFConsultorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifperiodof") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoAgente") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_importar_cetificado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifAuditorPorEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoComida") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifTipoDieta") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ResolucionDian") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipopoliticas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifjifentornoatencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifentornoatencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministrotecnologiasalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipodiscapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiforigenadmision") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipoparentesco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifprocedimientofinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ResolucionDian") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftipopoliticas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenero") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftecnologiaSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsexo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifftiposistemavigilancia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifftipovigilanciasistema") || Principal.PanelPpal.getSelectedFrame().getName().equals("Rubros Centro de Costos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Rubros Fuente Financiacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Rubros CPC") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmodalidadatencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipomedicamento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcodigoservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("Clasificación AIEPI") || Principal.PanelPpal.getSelectedFrame().getName().equals("Respuestas AIEPI") || Principal.PanelPpal.getSelectedFrame().getName().equals("Preguntas AIEPI Oncologíco") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifserviciosrips") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftipodestino") || Principal.PanelPpal.getSelectedFrame().getName().equals("Unidad Minima Dispensacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("Procedimiento Servicio Rips") || Principal.PanelPpal.getSelectedFrame().getName().equals("Procedimiento Tipo Finalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifPrueba")) {
                System.out.println("Esta llegando" + Principal.PanelPpal.getSelectedFrame().getName());
                Principal principal95 = this.xjp;
                Principal.claseparametrizacionn.grabar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            return;
        }
        this.metodos.mostrarMensaje("Por Favor seleccione alguna Pantalla");
    }

    public void mImprimir() {
        if (Principal.PanelPpal.getComponentCount() > 0) {
            System.out.println(Principal.PanelPpal.getSelectedFrame().getName());
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Agendar")) {
                Principal.clasetriage.botones(4, "Agendar");
                return;
            }
            if (!Principal.PanelPpal.getSelectedFrame().getName().equals("Autoriza")) {
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xejemploauditoria")) {
                    Principal.xclaseAuditoriaMedica.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jif_hojatratamiento")) {
                    Principal.claseTrancision.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatiga")) {
                    Principal.xclaseso.mImprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflecturaoit") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios")) {
                    Principal.claseimagendx.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifiprogramacion")) {
                    Principal principal = this.xjp;
                    Principal.xclaseCirugia.mImprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xConsultaRubros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xBuscarDocumPpto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTOv2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO_N") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitud_new") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompromisopresupuestal")) {
                    Principal.xclasePresupuesto.mImprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexamenocupacional") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLiqServicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifautorizacion_servicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xgenerarcotizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_3") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfachora") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflistafacturasventa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama2") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionlab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFacturacionAgil")) {
                    Principal.clasefacturacion.mImprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionserv") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionglobalt") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcuentacobroempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreliquidacionfactura1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifarmado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoCartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcambiardatosliquidacion1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifFacturaElectronica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos")) {
                    Principal principal2 = this.xjp;
                    Principal.xclasegc.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras")) {
                    Principal.clasecomprabn.imprimir("jifcompras");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifordenservicio")) {
                    Principal.clasecomprabn.imprimir("jifordenservicio");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrequisicion")) {
                    Principal.clasecomprabn.imprimir("jifrequisicion");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultar_reciboc") || Principal.PanelPpal.getSelectedFrame().getName().equals("Consolidado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecibosegresos")) {
                    Principal.clasecaja.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos1")) {
                    Principal.clascajamenor.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("Temperatura Bodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras1") || Principal.PanelPpal.getSelectedFrame().getName().equals("ImprimirInventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("ITraslados") || Principal.PanelPpal.getSelectedFrame().getName().equals("Despachos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Entradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Salidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmonitoreoinventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformesdespachopaciente") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informes1.5") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_InformeDeSalidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinventariogeneral")) {
                    Principal.xClaseInventario.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("Atencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaE") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaE") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhistoriauh") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifReporteSolicitudAlimentacion")) {
                    Principal.claseenfer.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunacion")) {
                    Principal.clasepyp.imprimir("Vacunacion");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("UsuarioxPrograma")) {
                    Principal.clasepyp.imprimir("UsuarioxPrograma");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixToma")) {
                    Principal.clasepyp.imprimir("CACervixToma");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarmedicamentos")) {
                    Principal.claseautorizacionmp.imprimir("jifconsultarmedicamentos");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformulapyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpermisomedicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifincapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifreportesh") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifjuntamedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_agendamedico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcensocama1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav4") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav3")) {
                    Principal.clasehistoriace.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recepcion") || Principal.PanelPpal.getSelectedFrame().getName().equals("frmRecepBienestarSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremisione") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremision2") || Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("imprimir") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio1") || Principal.PanelPpal.getSelectedFrame().getName().equals("Demanda no Atendida") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoxexamen") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifplanillatrabajo") || Principal.PanelPpal.getSelectedFrame().getName().equals("Registro de Rechazo de Muestra") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsinformelab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarresultadoLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportecitologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcionstikers_citologia")) {
                    Principal.claselab.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifreporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("seguimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFEquiposdebaja") || Principal.PanelPpal.getSelectedFrame().getName().equals("Seguimiento_Mantenimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("JIFConfigurar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos")) {
                    Principal.clasemant.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerador1")) {
                    Principal.claseinformes.imprimir("jifgenerador1");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac")) {
                    Principal.xclase.imprimir("jifradicacionfac");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaft") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroreembolso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasprofesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasnoatendidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaNP")) {
                    Principal.clasescita.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcomprobantep") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobro") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionnc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocn") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarpagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfultainfproveedeor") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneracioncertificadoman") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifenviardoctercero") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifbalancecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifenviaremail") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistrofact") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmoddocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformescontables") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconciliacioninventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconfempresa2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdepreciacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformescontables_fecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("MovimientoxRFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionterceros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_rangocuentas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_terceros")) {
                    Principal.xclase.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso1")) {
                    Principal.clascajamenor.imprimir("jifsolicitudreembolso1");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifanticipo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionn") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_causacion_nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_conolidado_concepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarplanillanomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarplanillanomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoconceptosrh") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftramisionnominaelectronica")) {
                    Principal.claserecursoshumanos.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneraciondescuento")) {
                    Principal.claseautorizacionmp.imprimir("jifgeneraciondescuento");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarrelacioncobro")) {
                    Principal.claseautorizacionmp.imprimir("jifgenerarrelacioncobro");
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconsDocClinico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhc")) {
                    Principal.clasegestiondoc.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffAnalisisEventoAdverso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifactas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpanoramaeventos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFConsultarNovedad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad1")) {
                    Principal.xclasesgc.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadira") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadeda") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad1")) {
                    Principal.xclasesig.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionactivos1")) {
                    Principal principal3 = this.xjp;
                    Principal.xclasegactivo.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitalizacionsoporte")) {
                    Principal.claseDigitalizacionSoporte.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudPedidoInterno")) {
                    Principal principal4 = this.xjp;
                    Principal.clasegeneral.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                } else {
                    if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsuministro")) {
                        Principal principal5 = this.xjp;
                        Principal.claseparametrizacionn.imprimir(Principal.PanelPpal.getSelectedFrame().getName());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.metodos.mostrarMensaje("Por Favor seleccione alguna Pantalla");
    }

    public void mAnular() {
        if (Principal.PanelPpal.getComponentCount() > 0) {
            System.out.println(Principal.PanelPpal.getSelectedFrame().getName());
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Agendar")) {
                Principal.clasetriage.botones(3, "Agendar");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xejemploauditoria")) {
                Principal.xclaseAuditoriaMedica.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Cierre") || Principal.PanelPpal.getSelectedFrame().getName().equals("Consolidado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecibosegresos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierreegresos")) {
                Principal.clasecaja.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras")) {
                Principal.clasecomprabn.anular("jifcompras");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifordenservicio")) {
                Principal.clasecomprabn.anular("jifordenservicio");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrequisicion")) {
                Principal.clasecomprabn.anular("jifrequisicion");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Traslados") || Principal.PanelPpal.getSelectedFrame().getName().equals("Egreso") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLiqServicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifautorizacion_servicios")) {
                Principal.clasefacturacion.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjig_programacion_cx")) {
                Principal principal = this.xjp;
                Principal.xclaseCirugia.mAnular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifhistoriauh")) {
                Principal.claseenfer.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xpControlOxigeno")) {
                Principal.claseenfer.anular("xpControlOxigeno");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaarmadoproc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifarmado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcuentacobroempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestion_pagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos")) {
                Principal principal2 = this.xjp;
                Principal.xclasegc.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudPedidoInterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbitacora")) {
                Principal principal3 = this.xjp;
                Principal.clasegeneral.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Entradas")) {
                Principal.xClaseInventario.anular("Entradas");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Despachos")) {
                Principal.xClaseInventario.anular("Despachos");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Salidas")) {
                Principal.xClaseInventario.anular("Salidas");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("ITraslados")) {
                Principal.xClaseInventario.anular("ITraslados");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Faltantes")) {
                Principal.xClaseInventario.anular("Faltantes");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras1")) {
                Principal.xClaseInventario.anular("jifcompras1");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras2")) {
                Principal.xClaseInventario.anular("jifcompras2");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Citas")) {
                Principal.clasescita.frmCita.desistir();
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("CitaNP")) {
                Principal.clasescita.frmCitaNP.desistir();
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("CitaTerapia")) {
                Principal.clasescita.frmCitaTerapia.desistir();
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Programar")) {
                Principal.clasescita.frmProgramar.desistir(10);
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifeliminarprogramacioncitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroreembolso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programación Cirugia")) {
                Principal.clasescita.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Atencion")) {
                Principal.claseenfer.anular("Atencion");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixToma")) {
                Principal.clasepyp.anular("CACervixToma");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixResultado")) {
                Principal.clasepyp.anular("CACervixResultado");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunacion")) {
                Principal.clasepyp.anular("Vacunacion");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarmedicamentos")) {
                Principal.claseautorizacionmp.anular("jifconsultarmedicamentos");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneraciondescuento")) {
                Principal.claseautorizacionmp.anular("jifgeneraciondescuento");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpermisomedicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifincapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformulapyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav4") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav3")) {
                Principal.clasehistoriace.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionar_rx")) {
                Principal.claseimagendx.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarayudasdx") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargaratencionesmanuales") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionexamenes")) {
                Principal.clasegestiondoc.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremisione") || Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("TipoResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocoloxTipoResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocolxAreaxProcedim") || Principal.PanelPpal.getSelectedFrame().getName().equals("Protocolos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Areas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Recepcion") || Principal.PanelPpal.getSelectedFrame().getName().equals("frmRecepBienestarSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifplanillatrabajo") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProtocoloxTipoResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremision2")) {
                Principal.claselab.anular(Principal.PanelPpal.getSelectedFrame().getName());
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFRegistroTecnico")) {
                Principal.claseparametrizacion.anular("JIFRegistroTecnico");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFComponentes")) {
                Principal.claseparametrizacion.anular("JIFComponentes");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFFrecuencias")) {
                Principal.claseparametrizacion.anular("JIFFrecuencias");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFNormalidades")) {
                Principal.claseparametrizacion.anular("JIFNormalidades");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFManuales")) {
                Principal.claseparametrizacion.anular("JIFManuales");
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("JIFProcedimientos")) {
                Principal.claseparametrizacion.anular("JIFProcedimientos");
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Excepción")) {
                Principal.claseparametrizacionn.anular("JIFFExcepcion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifservicioxprocedimiento")) {
                Principal.claseparametrizacionn.anular("jifservicioxprocedimiento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcomprobantep") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionnc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneracioncertificadoman") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobro") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifenviaremail") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcuentacobro")) {
                Principal.xclase.anular(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos1")) {
                Principal.clascajamenor.anular("jifregistrorecibos1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso1")) {
                Principal.clascajamenor.anular("jifsolicitudreembolso1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudReembolso2")) {
                Principal.clascajamenor.anular("jifsolicitudreembolso2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom1")) {
                Principal.claserecursoshumanos.anular("jifcuentacobrom1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_causacion_nomina")) {
                Principal.claserecursoshumanos.anular("xjif_causacion_nomina");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTOv2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAnularDocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitud_new") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO_N") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompromisopresupuestal")) {
                Principal.xclasePresupuesto.mAnular(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_prestamos")) {
                Principal.claserecursoshumanos.anular("xjif_prestamos");
                return;
            } else if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_NovedadesNomina")) {
                Principal.claserecursoshumanos.anular("xjif_NovedadesNomina");
                return;
            } else {
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiffAnalisisEventoAdverso")) {
                    Principal.xclasesgc.anular(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                return;
            }
        }
        this.metodos.mostrarMensaje("Por Favor seleccione alguna Pantalla");
    }

    public void mBuscar() {
        if (Principal.PanelPpal.getComponentCount() > 0 && Principal.PanelPpal.getSelectedFrame().getName() != null) {
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Agendar")) {
                Principal.clasetriage.botones(5, "Agendar");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("BuscarTriage")) {
                Principal.clasetriage.botones(5, "BuscarTriage");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedicaFac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAuditoriaMedicaAdmin") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP_Auditoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_InformeSeguimentosAM") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifCierreSeguimientoAuditoriaMedica")) {
                Principal.xclaseAuditoriaMedica.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Autoriza")) {
                this.xjp.frmAutoriza.grabar();
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP2")) {
                Principal principal = this.xjp;
                Principal.xclaseodontolgia.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsolidadoReferencia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsolidadoReferencia")) {
                Principal.claseReferencia.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc") || Principal.PanelPpal.getSelectedFrame().getName().equals("Llamadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcrearpersona") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSeguimientoAuditoriaMedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSeguimientoAuditoriaMedica_Usuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudPedidoInterno") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifbitacora")) {
                Principal principal2 = this.xjp;
                Principal.clasegeneral.mBuscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTO") || Principal.PanelPpal.getSelectedFrame().getName().equals("xBuscarDocumPpto") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffInformeCuentasxPagar") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLibroPresupuestal") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAnularDocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xConsultaRubros") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsultarInformeCgrPresupuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifSolicitudPTOv2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifMovManualOP_PP") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifMovimientoPPTO_N") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitud_new") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompromisopresupuestal")) {
                Principal principal3 = this.xjp;
                Principal.xclasePresupuesto.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjig_programacion_cx")) {
                Principal principal4 = this.xjp;
                Principal.xclaseCirugia.mBurcar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jIFInformeCirugia")) {
                Principal principal5 = this.xjp;
                Principal.xclaseCirugia.mBurcar("jIFInformeCirugia");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarPrograma") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarEspecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarRadiologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarProcedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarProcedimientoDet") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoAsignacionCitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitasPorEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("RiesgoObstetrico") || Principal.PanelPpal.getSelectedFrame().getName().equals("RiesgoCardiovascular") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoAtencionFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientosEmpresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasNoProgramadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadoPorProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasPorEPS") || Principal.PanelPpal.getSelectedFrame().getName().equals("CirugiasUsuariosEPSyProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("DetalleEntradaPorBodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarAtenciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidOrdenConvenioProf") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolidadOrdenesMedico") || Principal.PanelPpal.getSelectedFrame().getName().equals("EstadisProcedLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsolProcedLabDet") || Principal.PanelPpal.getSelectedFrame().getName().equals("pacienteFacAtencionLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("pacienteFacAtencionRad") || Principal.PanelPpal.getSelectedFrame().getName().equals("InformeControlPrenatar") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultaSaludOcupacionalDX") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultarOrdenesProcedimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("ConsultaInforLipidosCarbo") || Principal.PanelPpal.getSelectedFrame().getName().equals("totalDosiSuministradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("totalDosiSuministroEntidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("vacunacionAplicxUsuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("formuSubgruFarmacologico") || Principal.PanelPpal.getSelectedFrame().getName().equals("empresaConveFarmacologico") || Principal.PanelPpal.getSelectedFrame().getName().equals("informeRes4725") || Principal.PanelPpal.getSelectedFrame().getName().equals("informeRes2463") || Principal.PanelPpal.getSelectedFrame().getName().equals("produccionPorSedeYProfesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("consultaPrenatal") || Principal.PanelPpal.getSelectedFrame().getName().equals("lecturaPorEmpresaYValor") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informe Resolucion 4725") || Principal.PanelPpal.getSelectedFrame().getName().equals("Censo Hospitalización") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinfoantencionprioritariaxclasificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdiagnosticosalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJif_informe_resolucion1604") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadira") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarinformacioncronicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarperiododuraciontratamiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFReporteExamenOcupacional") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformegenericoso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("ProcedimientosOrdenadosUsuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_generacion_rips_ministerio") || Principal.PanelPpal.getSelectedFrame().getName().equals("InformeGeneralPyP") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformeanexos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformedecitasatendidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformeinterconsultas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFReportesProduccionPorSede") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformemorbilidadeda")) {
                Principal principal6 = this.xjp;
                Principal.xclasesig.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreportenc2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistroindicadores") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsinformelab2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiemposespera1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreferenciac3") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarinfnutricion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoencuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformacionxespecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifestudiosrealizados") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffasignacioncitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifplacasdanadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeplacas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformacioncove") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinforlab1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoencuesta") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadosolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionsolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifremisionesxprofesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformacionso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformesupersalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriahcmed") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriahcenfer") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifficha5w1h") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformacionr4505") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiemposesperarx2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriatriage1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarinformes_eps") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifResultadoSicosocial") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaInf2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesm1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_pyp_informes1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultas_informes_p") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultas_informes_p1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifGenericoxFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriatiempo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifnofacturadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informes_resoluciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifInformeOdont") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffAnalisisEventoAdverso") || Principal.PanelPpal.getSelectedFrame().getName().equals("agudezaVisual") || Principal.PanelPpal.getSelectedFrame().getName().equals("planificacionFamiliar") || Principal.PanelPpal.getSelectedFrame().getName().equals("jovenSano") || Principal.PanelPpal.getSelectedFrame().getName().equals("adultoSano") || Principal.PanelPpal.getSelectedFrame().getName().equals("crecimientoYDesarrollo") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffSesionesXTrabajdor") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpanoramaeventos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFConsultarNovedad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informescasosseguridadclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informeSo_SGC") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformegenericoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiFOportunidadAtencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFInformeMedicamentosSivigilia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFEstadisticaCitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiffConsultarSIMEDTrimestral") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_planificacion_Familias_AIC_clinica_pajonal") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_ConsultarInformacionGenericaHospitalizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifAReferenciac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_InformePacientesFacturadosConFinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifIndicadoresOdontologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_MedicamentosEntregadosPorEPS") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_EjecucionPresupuestalPorFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteConsultasDiarias") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteProduccion2193") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteRemisiones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteCronicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifInformeConsoliadoPorFinalidad1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_InformeDiagnostico") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ConsultarAtencionPorFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_AuditoriaMedicamentosFacRips") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_AuditoriaProcedimientosFacRips") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformegenericofechas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReporteProduccion2193_V1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesGenerico") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmorbilidad_mortalidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSeguimientoSolicitudes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionordenes")) {
                Principal principal7 = this.xjp;
                Principal.xclasesgc.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaarmadoproc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifarmado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionserv") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrocapitacionglobalt") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcuentacobroempresa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconciliacioncartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarDG") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarDG1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestion_pagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolidadoglosasdefinitivo") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolidadoglosas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoCartera") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_generacion_circular030") || Principal.PanelPpal.getSelectedFrame().getName().equals("jIFInformesCartera2193") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_ConsolidadosDePagos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifFacturaElectronica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionmasivafacturas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobromImpuestos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP_GestionCuenta")) {
                Principal principal8 = this.xjp;
                Principal.xclasegc.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras")) {
                Principal.clasecomprabn.buscar("jifcompras");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos2")) {
                Principal.clasecomprabn.buscar("jifautorizaciondocumentos2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifordenservicio")) {
                Principal.clasecomprabn.buscar("jifordenservicio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifrequisicion")) {
                Principal.clasecomprabn.buscar("jifrequisicion");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifaurizacionreq")) {
                Principal.clasecomprabn.buscar("jifaurizacionreq");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcontratoinformecgr")) {
                Principal.clasecomprabn.buscar("xjifcontratoinformecgr");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("Cierre") || Principal.PanelPpal.getSelectedFrame().getName().equals("Consolidado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultar_reciboc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifasignacionreciboingresos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecibosegresos")) {
                Principal.clasecaja.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarordeneshc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroplacas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiemposesperarx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifagendalecturarx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios")) {
                Principal.claseimagendx.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionn") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_causacion_nomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_gestion_concepto_empleado") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_conolidado_concepto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultarplanillanomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadopersonal") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnominainformecgr") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarnominaxfecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftramisionnominaelectronica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_liquidacionnuevo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeregistronovedades")) {
                Principal.claserecursoshumanos.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Entradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarformulas")) {
                Principal.xClaseInventario.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Despachos")) {
                Principal.xClaseInventario.buscar("Despachos");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Salidas")) {
                Principal.xClaseInventario.buscar("Salidas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("ITraslados")) {
                Principal.xClaseInventario.buscar("Traslados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Faltantes")) {
                Principal.xClaseInventario.buscar("Faltantes");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarformulas")) {
                Principal.xClaseInventario.buscar("jifconsultarformulas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesi")) {
                Principal.xClaseInventario.buscar("jifconsultarinformesi");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesi1")) {
                Principal.xClaseInventario.buscar("jifconsultarinformesi1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiemposllamada")) {
                Principal.xClaseInventario.buscar("jiftiemposllamada");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesi2")) {
                Principal.xClaseInventario.buscar("jifconsultarinformesi2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesm")) {
                Principal.xClaseInventario.buscar("jifconsultarinformesm");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionpendiente")) {
                Principal.xClaseInventario.buscar("jifgestionpendiente");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras1")) {
                Principal.xClaseInventario.buscar("jifcompras1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcompras2")) {
                Principal.xClaseInventario.buscar("jifcompras2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jismodificarsolicitudp")) {
                Principal.xClaseInventario.buscar("jismodificarsolicitudp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcierrescontables")) {
                Principal.xClaseInventario.buscar("jifcierrescontables");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesv")) {
                Principal.xClaseInventario.buscar("jifconsultarinformesv");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarinf")) {
                Principal.xClaseInventario.buscar("xjifconsultarinf");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("LASA")) {
                Principal.xClaseInventario.buscar("LASA");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpsrotacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifajustarpminmax") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarfespecialidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifkardex") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarordenesc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultar_inf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifRotacionBodega") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformeestradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformesdespachopaciente") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadosalidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoentradas") || Principal.PanelPpal.getSelectedFrame().getName().equals("Informes1.5") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinventariogeneral") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadocierrecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiff_InformeDeSalidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_gestion_inventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSuministrosFechaInvima") || Principal.PanelPpal.getSelectedFrame().getName().equals("jmiInformesGeneralesInventario")) {
                Principal.xClaseInventario.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarordenesc")) {
                Principal.xclase.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexamenocupacional") || Principal.PanelPpal.getSelectedFrame().getName().equals("Facturac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultardespacho") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfac1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsautorizaciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformesvarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_proc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_3") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_cierre_caja") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifLiqServicios") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_Hosp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoObstetrico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFRiesgoCardiovascular") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFServicioEmpresaConvenio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitaciondx1") || Principal.PanelPpal.getSelectedFrame().getName().equals("informeAutorizacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("consolDescuenNomina") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfachora") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflistafacturasventa") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultaringresossoat") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiflistaordenesinternas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifConsultarIngresosLiquidacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFFacturacionAgil") || Principal.PanelPpal.getSelectedFrame().getName().equals("jmiInformesGeneralesFac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_facturas_auditadas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifGestionSolicitudes")) {
                Principal.clasefacturacion.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Citas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreorganizardiaasignacioncitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaNP") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarcitas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroreembolso1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientolab1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrd") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasprofesional") || Principal.PanelPpal.getSelectedFrame().getName().equals("Programación Cirugia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcitasnoatendidas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp2") || Principal.PanelPpal.getSelectedFrame().getName().equals("CitaTerapia")) {
                Principal.clasescita.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("IntegraFactura") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarportipoimpuesto") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifbalancecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadomovimiento1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifrgeistroreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifradicacionfac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifdocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinformesc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobrom") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifexportarinformacionc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos3") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifenviardoctercero") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcosultarinformesc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneracioncertificadoman") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgenerarcertificadoautomatico") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcuentacobro") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmediosdian") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarordenesc1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifmediosid") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifregistrofact") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconciliacioninventario") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjicuentaspagar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifmoddocumentoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformescontables") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifauditoriaaleatoria1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifdepreciacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarordenesc2") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecontable") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifcierrecuentascgi") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifkardex1") || Principal.PanelPpal.getSelectedFrame().getName().equals("MovimientoxRFecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarpagos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifbalancecontable_n") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_balancefecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifinformescontables_fecha") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionterceros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcuentacobro") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_rangocuentas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_libro_auxiliar_terceros") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarcuentasxpagarcontacart") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_balancegeneral") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_consultar_mov_tercero") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_informesvarioscontabilidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_informesestadofinanciero") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_estadofinancierocomparativo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpagosnominac") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP_Contable")) {
                Principal.xclase.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrorecibos1")) {
                Principal.clascajamenor.buscar("jifregistrorecibos1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsolicitudreembolso1")) {
                Principal.clascajamenor.buscar("jifsolicitudreembolso1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudReembolso2")) {
                System.err.println("prueba");
                Principal.clascajamenor.buscar("jifsolicitudreembolso2");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Atencion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistronota") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroatencionesp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrdEnfer") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifaydInfe") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaInfe") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFConsultarUnidosis") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifSolicitudAlimentacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifReporteSolicitudAlimentacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsulta_informacion_Hosp1")) {
                Principal.claseenfer.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixToma") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionpolimedicados") || Principal.PanelPpal.getSelectedFrame().getName().equals("CACervixResultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("Vacunacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultardescuentos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifverificacion") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarpn") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionpolimedicados") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_pyp_informes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregactividadespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("UsuarioxPrograma") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJifGestionExamenesPyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifegresoprograma")) {
                Principal.clasepyp.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifenviaremail")) {
                Principal.clasepyp.buscar("jifenviaremail");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizaciondocumentos1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifjuntamedica") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifvisitadomiciliaria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifincapacidad") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarresultado") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifpermisomedicos") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifformulapyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifhistoriaclinica") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifnotasmedicas") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrdHist") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorialadx") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP_hc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav3") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_historiaclinicav4")) {
                Principal.clasehistoriace.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarayudasdx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftranferenciadoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargaratencionesmanuales") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgestionexamenes") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifseguimientoqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroqrsr") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarresultado1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportexusuario") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreporte1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftranferenciadoc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsolicituddochc") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconsDocClinico") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconscprogramada") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarhistorial1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiconshc_atenciones") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarRemOrd") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiffinformelecturausuarios") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifexportacionmasivahcpdf")) {
                Principal.clasegestiondoc.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriatriage") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriahc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriatiempo") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsinformelab1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregactividadespyp") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifatencionesnpfac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifreferenciac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultarinfn") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformesvarios1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIFReporteExamenOcupacional1")) {
                Principal.claseinformes.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Recepcion") || Principal.PanelPpal.getSelectedFrame().getName().equals("frmRecepBienestarSalud") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistrodatosv") || Principal.PanelPpal.getSelectedFrame().getName().equals("TomaManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("ResultadoManual") || Principal.PanelPpal.getSelectedFrame().getName().equals("jiftiemposespera") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremisione") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreporte") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifresultadoxexamen") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarexamenesusuario2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsinformelab") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconstanciaservicio1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarinforlab") || Principal.PanelPpal.getSelectedFrame().getName().equals("Demanda no Atendida") || Principal.PanelPpal.getSelectedFrame().getName().equals("Registro de Rechazo de Muestra") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexportaciond") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftranferenciadoclab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_municipio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_entidad_municipio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_entidad_municipio_proc") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultarresultadoLab") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcion_municipio_valor") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_procedimientos_Fac") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifrecepcionstikers1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xJIfValidacionResultadoInterfaz") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifestadisticamuestrasnuevas") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifexportacionresultadosinstitucional") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjConsolidoExamenesPorServicio") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportePDF") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifremision2") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP_Laboratorio") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifretransmision") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifValidacionAdministrativa") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifPlanillaCitologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("ValidacionMasiva") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarreportecitologia") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_recepcionstikers_citologia")) {
                Principal.claselab.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariosistemas")) {
                Principal principal9 = this.xjp;
                Principal.claseparametrizacionn.buscar("jifusuariosistemas");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifprofesional")) {
                Principal principal10 = this.xjp;
                Principal.claseparametrizacionn.buscar("jifprofesional");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsupervisor")) {
                Principal principal11 = this.xjp;
                Principal.claseparametrizacionn.buscar("jifsupervisor");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifalertaxusuario1")) {
                Principal principal12 = this.xjp;
                Principal.claseparametrizacionn.buscar("jifalertaxusuario1");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifusuariocargo")) {
                Principal principal13 = this.xjp;
                Principal.claseparametrizacionn.buscar("jifusuariocargo");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Informe de Procedimientos Facturados")) {
                Principal principal14 = this.xjp;
                Principal.claseparametrizacionn.buscar("Informe de Procedimientos Facturados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Informe de Insumos Facturados")) {
                Principal principal15 = this.xjp;
                Principal.claseparametrizacionn.buscar("Informe de Insumos Facturados");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("Tipos de Medicamento")) {
                Principal principal16 = this.xjp;
                Principal.claseparametrizacionn.buscar("Tipos de Medicamento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifmatriculape")) {
                Principal.claseautorizacionmp.buscar("jifmatriculape");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifregistroenvio")) {
                Principal.claseautorizacionmp.buscar("jifregistroenvio");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgeneraciondescuento")) {
                Principal.claseautorizacionmp.buscar("jifgeneraciondescuento");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifcargardescuentoacumulado")) {
                Principal.claseautorizacionmp.buscar("jifcargardescuentoacumulado");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifgenerarplantillacd")) {
                Principal.claseautorizacionmp.buscar("jifgenerarplantillacd");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifsubirplantillad")) {
                Principal.claseautorizacionmp.buscar("jifsubirplantillad");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifauditoriafmp")) {
                Principal.claseautorizacionmp.buscar("jifauditoriafmp");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifconsultausuario")) {
                Principal.claseautorizacionmp.buscar("jifconsultausuario");
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsolidadoauditoria") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifautorizacion")) {
                Principal.claseautorizacionmp.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            }
            if (Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaInf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifaydInf") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestfatigaInf1") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifgestionep") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifc_man_power") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifseguimientosve") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifconsultar_seguimientoso") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_interpreacionesrx") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifsoautoreportes") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjifframingham") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjiftestruffier") || Principal.PanelPpal.getSelectedFrame().getName().equals("xjif_informeSo_SO") || Principal.PanelPpal.getSelectedFrame().getName().equals("CIS20") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_Reporte_de_seguimiento") || Principal.PanelPpal.getSelectedFrame().getName().equals("jif_ReportesPyP1") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifinformesistemavigilancia") || Principal.PanelPpal.getSelectedFrame().getName().equals("jifDeclaracionSalud")) {
                Principal.xclaseso.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                return;
            } else {
                if (Principal.PanelPpal.getSelectedFrame().getName().equals("jifdigitalizacionsoporte")) {
                    Principal.claseDigitalizacionSoporte.buscar(Principal.PanelPpal.getSelectedFrame().getName());
                    return;
                }
                return;
            }
        }
        this.metodos.mostrarMensaje("Por Favor seleccione alguna Pantalla");
    }
}
