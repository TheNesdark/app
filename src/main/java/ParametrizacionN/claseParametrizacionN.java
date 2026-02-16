package ParametrizacionN;

import Acceso.Principal;
import Caja.JIFTCaja;
import Contabilidad.JIFCPagarPucEmpresa;
import Contabilidad.JIFConceptoCCobro;
import Contabilidad.JIFConceptoReembolso;
import Contabilidad.JIFContratoEmpresa;
import Contabilidad.JIFDBancoxEmpresa;
import Contabilidad.JIFDetalleConcepto;
import Contabilidad.JIFDocumentoxUsuarioF;
import Contabilidad.JIFGenerico1CheckBoxC;
import Contabilidad.JIFGenericoDosComboxC;
import Contabilidad.JIFGenericoUnComboxEstadoC;
import Contabilidad.JIFImpuestos;
import Contabilidad.JIFImpuestoxEmpresa;
import Contabilidad.JIFPeriodoFinaciero;
import Contabilidad.JIFPlanCuenta;
import Contabilidad.JIFPresupuestoPuc;
import Contabilidad.JIFPresupuestoPucN;
import Contabilidad.JIFPuc;
import Contabilidad.JIFTipoConceptoCaja;
import Contabilidad.JIFUnidadFuncional;
import Facturacion.JIFConsultarInformesE;
import Facturacion.JIFReliquidacionFac;
import Historia.JDFormulaVencida;
import Parametrizacion.JIFPrueba;
import Parametrizacion.JIFVigilanciaSeguimiento;
import Salud_Ocupacional.JIFFTipoAgente;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JIFPucNifTipoInforme;
import com.genoma.plus.controller.contabilidad.JIFTipoDeInforme;
import com.genoma.plus.controller.facturacion.JIFInformesFacturadosController;
import com.genoma.plus.controller.facturacion.JIFUnidadCama;
import com.genoma.plus.controller.general.JIFClasificacionNotas;
import com.genoma.plus.controller.general.JIFConceptoAgrupacionCgr;
import com.genoma.plus.controller.general.JIFConfiguracionItems;
import com.genoma.plus.controller.general.JIFDepartamento;
import com.genoma.plus.controller.general.JIFFActividadEconomica;
import com.genoma.plus.controller.general.JIFFNivelActividadE;
import com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos;
import com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte;
import com.genoma.plus.controller.general.JIFF_Generico1Text1Check;
import com.genoma.plus.controller.general.JIFF_Generico3Text1Check;
import com.genoma.plus.controller.general.JIFF_PP_RubrosEncabezado;
import com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma;
import com.genoma.plus.controller.general.JIFFichaNotificacionSivigila;
import com.genoma.plus.controller.general.JIFFormapago;
import com.genoma.plus.controller.general.JIFGenerico1Text2Check;
import com.genoma.plus.controller.general.JIFGrupoExamenFisico;
import com.genoma.plus.controller.general.JIFH_GrupoSistemas;
import com.genoma.plus.controller.general.JIFH_TipoSistemas;
import com.genoma.plus.controller.general.JIFPais;
import com.genoma.plus.controller.general.JIFRHTipoCargo;
import com.genoma.plus.controller.general.JIFRegistroDisposicionResiduos;
import com.genoma.plus.controller.general.JIFRutaSoporte;
import com.genoma.plus.controller.general.JIFTipoClasificacionResiduos;
import com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones;
import com.genoma.plus.controller.general.JIFTipoConsentimiento;
import com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion;
import com.genoma.plus.controller.general.JIFTipoEventoSC;
import com.genoma.plus.controller.general.JIFTipoPolitica;
import com.genoma.plus.controller.general.JIFTipoRiesgoComplicacion;
import com.genoma.plus.controller.general.JIFTipoSeguimiento;
import com.genoma.plus.controller.general.JIFTipoTubo;
import com.genoma.plus.controller.general.JIFUnidadMedida;
import com.genoma.plus.controller.general.JIF_Generico1Text1Spinner1Check;
import com.genoma.plus.controller.general.JIF_Generico1Text2Spinner1Check;
import com.genoma.plus.controller.general.JIF_ImportacionCertificadoDigital;
import com.genoma.plus.controller.general.JIF_SO_TipoResultado;
import com.genoma.plus.controller.general.JIF_Turnos;
import com.genoma.plus.controller.general.SC_TProcesoTRiesgo;
import com.genoma.plus.controller.general.SC_TRiesgoTEvento;
import com.genoma.plus.controller.historia.JIFEntornoFamiliar;
import com.genoma.plus.controller.historia.JIFRelacionesFamiliares;
import com.genoma.plus.controller.historia.JIFTipoHistoria;
import com.genoma.plus.controller.inventario.JIFClasificacionLasa;
import com.genoma.plus.controller.parametrizacion.JIFAuditorPorEmpresa;
import com.genoma.plus.controller.parametrizacion.JIFConsultorio;
import com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN;
import com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb;
import com.genoma.plus.controller.parametrizacion.JIFMedioDePago;
import com.genoma.plus.controller.parametrizacion.JIFProcedimientoPorCentroDeCosto;
import com.genoma.plus.controller.parametrizacion.JIFTipoComida;
import com.genoma.plus.controller.parametrizacion.JIFTipoDieta;
import com.genoma.plus.controller.parametrizacion.JIF_ResolucionDian;
import com.genoma.plus.controller.presupuesto.JIFFinalidaGasto;
import com.genoma.plus.controller.presupuesto.JIFGenericoPresupuesto;
import com.genoma.plus.controller.presupuesto.JIFRubrosContraloria;
import com.genoma.plus.controller.salud_ocupacional.JIFConceptoSO;
import com.genoma.plus.controller.salud_ocupacional.JIFTipoCertificadoSO;
import com.genoma.plus.controller.sgc.JIF_Prueba;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/claseParametrizacionN.class */
public class claseParametrizacionN {
    public Principal frmPrincipal;
    private Metodos metodos = new Metodos();
    public JIFFEmpresa xjifempresa;
    public JIFFEmpresaBienestarSalud xjifempresaBienestar;
    private JIFFEmpresaEstrato xjifestratoempresa;
    private JIFFEmpresaGrupoS xjifgrupoempresa;
    private JIFFEmpresaServicios xjifservicioempresa;
    private JIFFEmpresaProcedimiento xjifprocedimientoempresa;
    private JIFEmpresaContrato xjifcontratoempresa;
    private JIFUsuarioSistema xjifusuariosistemas;
    private JIFUsuarioSistema xJIFUsuarioSistema;
    private JIFFEstrato xjifestrato;
    private JIFGenericoCh xjifgenericoch;
    private JIFFSubGrupoFactur xjidsubgrupofac;
    private JIFFTipoProcedimiento xjiftipoprocedimiento;
    private JIFGenericoDosCombox xjifgenericocombox2;
    private JIFFProcedimiento xjifprocedimiento;
    private JIFGenericoUnComboxEstado xjifgenericocombox1;
    private JIFFTarifaProcedimiento xjiftarifaprocedimiento;
    private JIFGenerico1CheckBox xjifgenerico1chbox;
    private JIFFAumentoTarifas xjifaumentotarifas;
    private JIFSSuministro xjifsuministro;
    private JIFFTarifaSuministro xjiftarifasuministro;
    private JIFSSuministroxBodega xjifsuministrobodega;
    private JIFARelacionLaboral xjifrelacionlaboral;
    private JIFSBodegas xjifbodegas;
    private JIFSMovimientoxBodega xjifmovimientobodega;
    private JIFGProfesional xjifprofesional;
    private JIFGEspecialidad xjifespecialidad;
    private JIFGDatosEmpresa xjifdatosempresa;
    private JIFGenerico2Text1CheckBox1 xjifgenerico2;
    private JIFGenerico3Text1Combo1CheckBox xjifgenerico3;
    private JIFGBarrio xjifbarrio;
    private JIFGSupervisor xjifsupervisor;
    private JIFCTurnosCita xjifturnoscitas;
    private JIFGenerico1Text1Combo1CheckBox1 xjifgenerico1txt1box;
    private JIFVacunacionEsquema xjifvacunaesquema;
    private JIFCClaseCita xjifclasecita;
    private JIFGAlertaxUsuario xjifalertausuario;
    private JIFUtilidades xjifutilidades;
    private JIFUnidadFuncional xjifunidadf;
    private JIFGenerico1CheckBoxC xjifgenicoc;
    private JIFGenericoUnComboxEstadoC xjifgenericocomboc;
    private JIFDetalleConcepto xjifdtalleconcepto;
    private JIFImpuestos xjifimpuestos;
    private JIFPlanCuenta xjifpuc;
    private JIFPresupuestoPuc xjifpresupuestopuc;
    private JIFImpuestoxEmpresa xjifimpuestoempresa;
    private JIFDBancoxEmpresa xjifcuentaempresa;
    private JIFCPagarPucEmpresa xjifcuentasxpagarempresa;
    private JIFContratoEmpresa xjifcontratoempresac;
    private Contabilidad.JIFTipoCaja xjiftipocaja;
    private JIFPuc xjifpucx;
    private JIFTipoConceptoCaja xjifconceptocaja;
    private JIFTipoDestino xjifTipoDestino;
    private JIFGenericoDosComboxC xjifgenericodoscombox;
    private JIFPresupuestoPucN xjifvalorizacionp;
    private JIFReliquidacionFac xjifreliquidacionfac;
    private JIFConsultarInformesE xjifconsultarinffac;
    private JIFConceptoCCobro xjifconceptoccobro;
    private JIFConceptoReembolso xjifconceptoreembolso;
    public JIFRHUsuarioCargo xjifusuarioxcargo;
    private JIFDocumentoxUsuarioF xjifdocfirma;
    private JIFInterracionesMed xjifinteracionmed;
    private JIFSTarifaEmpresaMP xjiftarifamp;
    private JIFRegistroNovedades xjifregistronov;
    private JIFEPreguntaEncuesta xjifpreguntaencuesta;
    private JIFEArmadoEncuesta xjifarmadoencuesta;
    private JIFTipoEncuesta xjiftipoencuesta;
    private JIFTipoProcesoSgc xjiftipoprocesosgc;
    private JIFTCaja xjiftcaja;
    private JIFConfSalaCirugias xjifconfsalacirugia;
    private JIFRHUnidadFuncional xjifunidadfuncional;
    private JIFFProcedimientoxPaquete xjifprocpaquetes;
    private JIFGenerico2SpinerEstadoC xjifgenerico4;
    private JIFHCDetalleContenidoHc xjifdetallecontenido;
    private JIFGenerico2CheckBoxC1Spiner xjifgenerico5;
    private JIFSgcGlosario xjifsgcglosario;
    private JIFFSubGrupoFacturaxEmpresa xjifsubgrupoxempersa;
    private JIFCConceptoxDetalleAnticipo xjifconceptoanticipo;
    private JIFFConceptoPagoGlosa xjifconceptopagoglosa;
    private JIFFichaTecnicaIndicador xjiffichatecnicaindicador;
    private JIFGenerico2Text1Combo1CheckBox1 xjifgenerico6;
    private JIFCTipoDocumentoC xjifdoccontable;
    private JIFRHConceptosNomina xjifoconceptonomina;
    private JIFGenerico1Text1Combo1Spiner1CheckBox11 xjifgenerico7;
    private JDFormulaVencida xjifformulav;
    private JIFReportePatologia xjifreportep;
    private JIFGenerico2CheckBox xjifgenericoch2;
    private JIFHorarioMedicion xjifhorariom;
    private JIFDemandaIndusida xiddemandaind;
    private JIFGenerico2Text1Combo1CheckBoxTemp xjiftipomedbod;
    private JIFGenerico1Text2Combos1Check xjif1text2comb1check;
    private JIFManualesxModulos xjifmanuales;
    private JIFGenericoDosComboxSpinner xjifexamenfisico;
    private JIFGenerico1Text1Combo2CheckBox xjifGenerico1Text1Combo2CheckBox;
    private JIFGenerico1CheckBox1TextArea xjifGenerico1CheckBox1TextArea;
    private JIFResultadoVisiometria xjifJIFResultadoVisiometria;
    private JIFSoRecomendaciones xjifRecomendaciones;
    private JIFPeligros fPeligros;
    private JIFTipoRespuesta xjifTipoRespuesta;
    private JIFTipoPreguntas xjifTipoPreguntas;
    private JIFSOTipo_Pregunta_Respuesta xjifTipo_Pregunta_Respuesta;
    private JIFGenerico1Text1Combo2SpinerEstado xjifGenerico1Text1Combo2SpinerEstado;
    private JIFPreguntaDominio xJIFPreguntaDominio;
    private JIFGenerico2Text2CheckBox xJIFGenerico2Text2CheckBox;
    private JIFEscalaAbreviadaP xJIFEscalaAbreviadaP;
    private JIFPatologias_Cie10 xjifpatologiacie10;
    private JIFTipoPrograma xJIFTipoPrograma;
    private JIFConceptoCaja xJIFConceptoCaja;
    private JIF_HTipo_Notas xjif_Notas_clinicas;
    private JIFFTipoEmpresa xJIFFTipoEmpresa;
    private JIFFProfSalaCirugia xJIFFProfSalaCirugia;
    private JIFGenerico3combo2text1check xJIFGenerico3combo2text1check;
    private JIFGrupoUvr xJIFGrupoUvr;
    private JIFFExcepcion xJIFFExcepcion;
    private JIFCentroCosto xJIFCentroCosto;
    private JIFFCamas xJIFFCamas;
    private JIFGenerico2CheckBoxC xJIFGenerico2CheckBoxC;
    private JIFTipoPeriodosCartera xJIFTipoPeriodosCartera;
    private JIFGenericoDosCombox1Check xJIFGenericoDosCombox1Check;
    private JIFGenerico1txt1combo1check1spiner xJIFGenerico1txt1combo1check1spiner;
    private JIFETipoRespuesta xJIFETipoRespuesta;
    private JIFEPreguntaxArea xJIFEPreguntaxArea;
    private JIFFGenerico2TextBox1Spiner1CheckBox xJIFFGenerico2TextBox1Spiner1CheckBox;
    private JIFFGenerico3TextBox1Check xJIFFGenerico3TextBox1Check;
    private JIFFManual xJIFFManual;
    private JIFHorarioFarmacia xJIFHorarioFarmacia;
    private JIFFGenerico1Text1Spiner1Check xJIFFGenerico1Text1Spiner1Check;
    private JIFFPeriodosNomina xJIFFPeriodosNomina;
    private JIFFGenerico3Text1Check xJIFFGenerico3Text1Check;
    private JIFRubros xJIFRubros;
    private JIFFPPeriodo xJIFFPPeriodo;
    private JIFFPPTipoDocumento xJIFFPPTipoDocumento;
    private JIFFTipoDocTercero xJIFFTipoDocTercero;
    private JIFFRubroTDoc xJIFFRubroTDoc;
    private JIFGenerico3CheckBoxC3 xJIFGenerico3CheckBoxC3;
    private JIFFRubroResolucion xJIFFRubroResolucion;
    private JIFFHistoricoSalarioMinimo xJIFFHistoricoSalarioMinimo;
    private JIFFCodigoAlternoRubro xJIFFCodigoAlternoRubro;
    private JIF_Unificacion_Usuario xJifUnificar_Usuario;
    private JIFFRubrosN xJIFFRubrosN;
    private JIFTipoConsecuenciAcciones xJIFTipoConsecuenciAcciones;
    private JIFF_Generico3Text1Check xJIFF_Generico3Text1Check;
    private JIFTipoEventoSC xJIFTipoEventoSC;
    private JIFF_Generico1Text1Check xJIFF_Generico1Text1Check;
    private SC_TProcesoTRiesgo xSC_TProcesoTRiesgo;
    private SC_TRiesgoTEvento xSC_TRiesgoTEvento;
    private JIF_Generico1Text1Spinner1Check xJIF_Generico1Text1Spinner1Check;
    private JIF_Generico1Text2Spinner1Check xJIF_Generico1Text2Spinner1Check;
    private JIFFormapago xJIFFormaPago;
    private JIFF_PP_RubrosEncabezado xJIFF_PP_RubrosEncabezado;
    private JIFInformesFacturadosController xJIFInformesFacturadosController;
    private JIFF_TipoDocumentoFirma xJIFF_TipoDocumentoFirma;
    private JIFTipoTubo xJIFTipoTubo;
    private JIFFTipoDocumentoSoporte xJIFFTipoDocumentoSoporte;
    private JIFRutaSoporte xJIFRutaSoporte;
    private JIFRHTipoCargo xJIFRHTipoCargo;
    private JIF_SO_TipoResultado xJIF_SO_TipoResultado;
    private JIFFActividadEconomica xJIFFActividadEconomica;
    private JIFFNivelActividadE xJIFFNivelActividadE;
    private JIFTipoCertificadoSO xJIFTipoCertificadoSO;
    private JIFConceptoSO xJIFConceptoSO;
    private JIFTipoClasificacionResiduos xJIFTipoClasificacionResiduos;
    private JIFRegistroDisposicionResiduos xJIFRegistroDisposicionResiduos;
    private JIFDepartamento xJIFDepartamento;
    private JIFPais xJIFPais;
    private JIFTipoRiesgoComplicacion xJIFTipoRiesgoComplicacion;
    private JIFTipoConsentimiento xJIFTipoConcentimiento;
    private JIFGenerico1Text2Check xJIFGenerico1Text2Check;
    private JIFTipoSeguimiento xJIFTipoSeguimiento;
    private JIFTipoDocumentoClasificacion xJIFTipoDocumentoClasificacion;
    private JIFConceptoAgrupacionCgr xJIFConceptoAgrupacionCgr;
    private JIFFichaNotificacionSivigila xJIFFichaNotificacionSivigila;
    private JIFClasificacionNotas xJIFClasificacionNotas;
    private JIFGrupoExamenFisico xJIFGrupoExamenFisico;
    private JIFH_GrupoSistemas xJIFH_GrupoSistemas;
    private JIFH_TipoSistemas xJIFH_TipoSistemas;
    private JIFEntornoFamiliar xEntornoFamiliar;
    private JIFRelacionesFamiliares xFRelacionesFamiliares;
    private JIFTipoDeInforme xJIFTipoDeInforme;
    private JIFPucNifTipoInforme xJIFPucNifTipoInforme;
    private JIFTipoHistoria xJIFTipoHistoria;
    private JIFGenericoPresupuesto xJIFGenericoPresupuesto;
    private JIFFinalidaGasto xJIFFinalidaGasto;
    private JIFRubrosContraloria xJIFRubrosContraloria;
    private JIFConfiguracionItems xJIFConfiguracionItems;
    private JIFClasificacionLasa jIFClasificacionLasa;
    private JIFUnidadMedida xJIFUnidadMedida;
    private JIFFTipoAntecedentesPsiquiatricos jiffTipoAntecedentesPsiquiatricos;
    private com.genoma.plus.controller.facturacion.JIFTipoAtencion jIFTipoAtencion;
    private JIFProcedimientoPorCentroDeCosto jIFProcedimientoPorCentroDeCosto;
    private JIFUnidadCama jIFUnidadCama;
    private JIFConsultorio jIFConsultorio;
    private JIFImportatPaiweb JIFImportatPaiweb;
    private JIFPeriodoFinaciero xjifperiodof;
    private JIFFTipoAgente xJIFFTipoAgente;
    private JIF_ImportacionCertificadoDigital certificadoDigital;
    private JIFAuditorPorEmpresa xJIFAuditorPorEmpresa;
    private JIFTipoComida xJIFTipoComida;
    private JIFTipoDieta xJIFTipoDieta;
    private JIF_ResolucionDian xJIF_ResolucionDian;
    private JIFFEmpresaServiciosN xJIFFEmpresaServiciosN;
    private JIFTipoPolitica xJIFTipoPolitica;
    private JIFVigilanciaSeguimiento xJIFVigilanciaSeguimiento;
    private JIFGTipoDocumentoSoporte xjiftipodedocumentosoporte;
    private JIFHTipoDocumentosHc xjifhtipodocumentoshc;
    private JIFHTipoAyudaDx xjifhtipoayudadx;
    private JIF_Turnos turnos;
    private JIFTipoDiscapacidad jiftipodiscapacidad;
    private JIFEntornoAtencion jifentornoatencion;
    private JIFSuministroTecnologiaSalud jifSuministroTecnologiaSalud;
    private JIFOrigenAdmision jIFOrigenAdmision;
    private JIFTipoParentesco jIFTipoParentesco;
    private JIFGSexo jifsexo;
    private JIFIdentidadGenero jifgenero;
    private JIFGTecnologiaSalud jIFGTecnologiaSalud;
    private JIF_Prueba jifprueba;
    private JIFMedioDePago jIFMedioDePago;
    private JIFFTipoSistemaVigilancia jifftiposistemavigilancia;
    private JIFFTipoVigilanciaSistemas jiffttipovigilanciasistemas;
    private JIFRubros1 xJIFRubros1;
    private JIFGenericoRubros jIFGenericoRubros;
    private JIFGModalidadAtencion jifmodalidadatencion;
    private JIFTipoMedicamento jiftipomedicamento;
    private JIFCodigoServicio jifcodigoservicio;
    private JIFGenericoAIEPI jifgaiepi;
    private JIFServiciosRips jifserviciosrips;
    private JIFTipoDestino jiftipodestino;
    private JIFPrueba jIFPruebaBuena;

    public claseParametrizacionN(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifusuariosistemas":
                this.xJIFUsuarioSistema.mBuscar();
                break;
            case "jifprofesional":
                this.xjifprofesional.mBuscar();
                break;
            case "jifsupervisor":
                this.xjifsupervisor.mBuscar();
                break;
            case "jifalertaxusuario1":
                this.xjifalertausuario.mBuscar();
                break;
            case "jifusuariocargo":
                this.xjifusuarioxcargo.mBuscar();
                break;
            case "Informe de Procedimientos Facturados":
                this.xJIFInformesFacturadosController.mBuscar();
                break;
            case "Informe de Insumos Facturados":
                this.xJIFInformesFacturadosController.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm, int x) {
        switch (frm) {
            case "Empresa":
                this.xjifempresa = new JIFFEmpresa("jifconfempresa1", 1, "Empresa Contratante");
                Principal.cargarPantalla(this.xjifempresa);
                break;
            case "jifempresaservicios":
                this.xjifservicioempresa = new JIFFEmpresaServicios(this, x);
                Principal.cargarPantalla(this.xjifservicioempresa);
                break;
            case "jifempresaserviciosN":
                this.xJIFFEmpresaServiciosN = new JIFFEmpresaServiciosN(this, x);
                Principal.cargarPantalla(this.xJIFFEmpresaServiciosN);
                break;
            case "Antecedentes Patológicos":
                this.xjifGenerico1Text1Combo2CheckBox = new JIFGenerico1Text1Combo2CheckBox("xjifantencedentespatologicos", "Antecedentes Patológicos", x);
                Principal.cargarPantalla(this.xjifGenerico1Text1Combo2CheckBox);
                break;
        }
    }

    public void cargarPantalla(String frm, String titulo) {
        if (frm.equals("Empresa")) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                this.xjifempresaBienestar = new JIFFEmpresaBienestarSalud("jifconfempresa1", 0, "EMPRESA CONTRATANTE BIEN ESTAR SALUD");
                Principal.cargarPantalla(this.xjifempresaBienestar);
            } else {
                this.xjifempresa = new JIFFEmpresa("jifconfempresa1", 0, titulo);
                Principal.cargarPantalla(this.xjifempresa);
            }
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Empresa":
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    this.xjifempresaBienestar = new JIFFEmpresaBienestarSalud("jifconfempresa1", 0, "EMPRESA CONTRATANTE BIEN ESTAR SALUD");
                    Principal.cargarPantalla(this.xjifempresaBienestar);
                    break;
                } else {
                    this.xjifempresa = new JIFFEmpresa("jifconfempresa1", 0, "Empresa");
                    Principal.cargarPantalla(this.xjifempresa);
                    break;
                }
                break;
            case "Patología Cie10":
                this.xjifpatologiacie10 = new JIFPatologias_Cie10();
                Principal.cargarPantalla(this.xjifpatologiacie10);
                break;
            case "jifPrueba1":
                this.jIFPruebaBuena = new JIFPrueba();
                Principal.cargarPantalla(this.jIFPruebaBuena);
                break;
            case "Prueba_Datos":
                this.jifprueba = new JIF_Prueba();
                Principal.cargarPantalla(this.jifprueba);
                break;
            case "Turnos_Nuevo":
                this.turnos = new JIF_Turnos();
                Principal.cargarPantalla(this.turnos);
                break;
            case "Detalle Preguntas So":
                this.xjifgenerico7 = new JIFGenerico1Text1Combo1Spiner1CheckBox11("xjifdetallepreguntas", "Detalle Preguntas SO");
                Principal.cargarPantalla(this.xjifgenerico7);
                break;
            case "Tipo de Ejercicio":
                this.xjifgenerico7 = new JIFGenerico1Text1Combo1Spiner1CheckBox11("xjiftipoejercicio", "Tipo de Ejercicio");
                Principal.cargarPantalla(this.xjifgenerico7);
                break;
            case "Concepto de Estudio Citologico":
                this.xjifgenerico7 = new JIFGenerico1Text1Combo1Spiner1CheckBox11("xjifconceptoestudio", "Concepto de Estudio Citologico");
                Principal.cargarPantalla(this.xjifgenerico7);
                break;
            case "Aeropuertos":
                this.xjifgenerico6 = new JIFGenerico2Text1Combo1CheckBox1("Aeropuertos", "xjifaeropuertos");
                Principal.cargarPantalla(this.xjifgenerico6);
                break;
            case "Unificar Usuario Duplicado":
                this.xJifUnificar_Usuario = new JIF_Unificacion_Usuario();
                Principal.cargarPantalla(this.xJifUnificar_Usuario);
                break;
            case "Novedades por Concepto de Nomina":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifnovconceptonomina", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Concepto Nomina":
                this.xjifoconceptonomina = new JIFRHConceptosNomina();
                Principal.cargarPantalla(this.xjifoconceptonomina);
                break;
            case "Concepto Pago-Glosa":
                this.xjifconceptopagoglosa = new JIFFConceptoPagoGlosa();
                Principal.cargarPantalla(this.xjifconceptopagoglosa);
                break;
            case "Ficha Técnica Indicador SGC":
                this.xjiffichatecnicaindicador = new JIFFichaTecnicaIndicador();
                Principal.cargarPantalla(this.xjiffichatecnicaindicador);
                break;
            case "Glosario":
                this.xjifsgcglosario = new JIFSgcGlosario("xjifglosario");
                Principal.cargarPantalla(this.xjifsgcglosario);
                break;
            case "Concepto x Detalle Anticipo":
                this.xjifconceptoanticipo = new JIFCConceptoxDetalleAnticipo();
                Principal.cargarPantalla(this.xjifconceptoanticipo);
                break;
            case "Tipo Medición":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjiftipomedida", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Motivo de Anulación":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjifmotivoanulacion", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Tipo Detalle Exámen Físico":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjiftipodetalleexamenf", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Sala de Cirugia":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjiffsalacirugia", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Elementos PP":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjifelementospp", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Contenido HC":
                this.xjifgenerico4 = new JIFGenerico2SpinerEstadoC("xjifcontenidohc", frm);
                Principal.cargarPantalla(this.xjifgenerico4);
                break;
            case "Tipo Exámen Físico":
                this.xjifgenerico5 = new JIFGenerico2CheckBoxC1Spiner("xjiftipoexamenfisico", frm);
                Principal.cargarPantalla(this.xjifgenerico5);
                break;
            case "Encabezado Preguntas":
                this.xjifgenerico5 = new JIFGenerico2CheckBoxC1Spiner("xjifencabezadopreguntaso", frm);
                Principal.cargarPantalla(this.xjifgenerico5);
                break;
            case "Encabezado Recomendaciones":
                this.xjifgenerico5 = new JIFGenerico2CheckBoxC1Spiner("xjifencabezadorecomendacion", frm);
                Principal.cargarPantalla(this.xjifgenerico5);
                break;
            case "Vacunas x Edad":
                this.xjifgenerico5 = new JIFGenerico2CheckBoxC1Spiner("Vacunas x Edad", frm);
                Principal.cargarPantalla(this.xjifgenerico5);
                break;
            case "Detalle Contenido HC":
                this.xjifdetallecontenido = new JIFHCDetalleContenidoHc();
                Principal.cargarPantalla(this.xjifdetallecontenido);
                break;
            case "Unidad de Negocio":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjifunidadnegocio", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Ocupación":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1(frm, "xjifocupacion");
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Unidad Funcional":
                this.xjifunidadfuncional = new JIFRHUnidadFuncional();
                Principal.cargarPantalla(this.xjifunidadfuncional);
                break;
            case "Horarios Medición":
                this.xjifhorariom = new JIFHorarioMedicion("jifhorariomedicion", frm);
                Principal.cargarPantalla(this.xjifhorariom);
                break;
            case "Tipo Proceso Sgc":
                this.xjiftipoprocesosgc = new JIFTipoProcesoSgc();
                Principal.cargarPantalla(this.xjiftipoprocesosgc);
                break;
            case "Tipo Caja":
                this.xjiftcaja = new JIFTCaja();
                Principal.cargarPantalla(this.xjiftcaja);
                break;
            case "jifestratoempresa":
                this.xjifestratoempresa = new JIFFEmpresaEstrato(this);
                Principal.cargarPantalla(this.xjifestratoempresa);
                break;
            case "jifempresagrupo":
                this.xjifsubgrupoxempersa = new JIFFSubGrupoFacturaxEmpresa();
                Principal.cargarPantalla(this.xjifsubgrupoxempersa);
                break;
            case "jifempresaprocedimiento":
                this.xjifprocedimientoempresa = new JIFFEmpresaProcedimiento(this);
                Principal.cargarPantalla(this.xjifprocedimientoempresa);
                break;
            case "jifcontratoempresa":
                this.xjifcontratoempresa = new JIFEmpresaContrato(this);
                Principal.cargarPantalla(this.xjifcontratoempresa);
                break;
            case "jifusuariosistemas":
                this.xJIFUsuarioSistema = new JIFUsuarioSistema();
                Principal.cargarPantalla(this.xJIFUsuarioSistema);
                break;
            case "Importar Firma Electronica":
                this.certificadoDigital = new JIF_ImportacionCertificadoDigital();
                Principal.cargarPantalla(this.certificadoDigital);
                break;
            case "Estrato":
                this.xjifestrato = new JIFFEstrato();
                Principal.cargarPantalla(this.xjifestrato);
                break;
            case "Grupo Factura":
                this.xjifgenericoch = new JIFGenericoCh("jifgrupofactura", "Grupo Factura");
                Principal.cargarPantalla(this.xjifgenericoch);
                break;
            case "Tipo de Alerta":
                this.xjifgenericoch = new JIFGenericoCh("xjiftipoalerta", "Tipo de Alerta");
                Principal.cargarPantalla(this.xjifgenericoch);
                break;
            case "Sub Grupo Factura":
                this.xjidsubgrupofac = new JIFFSubGrupoFactur();
                Principal.cargarPantalla(this.xjidsubgrupofac);
                break;
            case "Tipo de Procedimiento":
                this.xjiftipoprocedimiento = new JIFFTipoProcedimiento();
                Principal.cargarPantalla(this.xjiftipoprocedimiento);
                break;
            case "Tipo de Servicio":
                this.xjifgenericoch = new JIFGenericoCh("jiftiposervicio", "Tipo de Servicio");
                Principal.cargarPantalla(this.xjifgenericoch);
                break;
            case "Procedimiento x Tipo de Servicio":
                this.xjifgenericocombox2 = new JIFGenericoDosCombox("jifservicioxprocedimiento", "Procedimiento x Tipo de Servicio");
                Principal.cargarPantalla(this.xjifgenericocombox2);
                break;
            case "Segmento x Encabezado":
                this.xjifgenericocombox2 = new JIFGenericoDosCombox("jifsegmento_encabezado", "Segmento x Encabezado");
                Principal.cargarPantalla(this.xjifgenericocombox2);
                break;
            case "Procedimiento":
                this.xjifprocedimiento = new JIFFProcedimiento("jifprocedimiento");
                Principal.cargarPantalla(this.xjifprocedimiento);
                break;
            case "Procedimiento x Centro Costo":
                this.xjifgenericocombox1 = new JIFGenericoUnComboxEstado("jifprocedimientoccosto", "Procedimiento x Centro Costo");
                Principal.cargarPantalla(this.xjifgenericocombox1);
                break;
            case "Equipo x Procedimiento":
                this.xjifgenericocombox1 = new JIFGenericoUnComboxEstado("jifequipoxprocedimiento", "Equipo x Procedimiento");
                Principal.cargarPantalla(this.xjifgenericocombox1);
                break;
            case "Tipo de Fórmula":
                this.xjifgenericocombox1 = new JIFGenericoUnComboxEstado("jifgenericocombox1", "Tipo de Fórmula");
                Principal.cargarPantalla(this.xjifgenericocombox1);
                break;
            case "Suministro x Tipo de Fórmula":
                this.xjifgenericocombox1 = new JIFGenericoUnComboxEstado("jifsuministroxTformula", "Suministro x Tipo de Fórmula");
                Principal.cargarPantalla(this.xjifgenericocombox1);
                break;
            case "Tarifa Procedimiento":
                this.xjiftarifaprocedimiento = new JIFFTarifaProcedimiento();
                Principal.cargarPantalla(this.xjiftarifaprocedimiento);
                break;
            case "Tipo de Clasificacion":
            case "Frecuencias":
            case "Sitio Ocurrencia":
            case "Tipo de Registro":
            case "Clasificacion de Respuesta":
            case "Estado Civil":
            case "Tipo de Plan":
            case "Tipo de Régimen":
            case "Dosis Vacunas":
            case "Tipo Cita":
            case "Concepto Anticipo":
            case "Motivo Anulación Citas":
            case "Causa de Daño":
            case "Tipo Placa":
            case "Nivel de Estudio":
            case "Clasificación":
            case "Motivo de Traslado":
            case "Grupo Equipo":
            case "Tipo de DocumentosHC":
            case "Ecografía":
            case "Concepto Específico":
            case "Segmentos":
            case "Correción":
            case "Grupo Turnos":
            case "Actividad Física":
            case "Escala del Dolor":
            case "Tipo de Parto":
            case "Tipo de Dolor":
            case "Tipo Actividad Física":
            case "Tipo Vinculación":
            case "Tipo Sustancia":
            case "Tipo Subcategoria":
            case "Motivo Prueba":
            case "Tipo Cuestionario":
            case "Escala CyD":
            case "Preguntas CyD":
            case "Prueba Mauricio":
            case "Población Especial":
            case "Medio Recepción":
            case "Tipo Afiliado":
            case "Tipo Manual Tarifas":
            case "Tipo Etnia":
            case "Tipo División":
            case "Tipo Descuento":
            case "Muestra Citologia":
            case "Tipo Seguimiento":
            case "Esquema Citologia":
            case "Tipo Documento Soporte":
                this.xjifgenerico1chbox = new JIFGenerico1CheckBox(frm, "jifgenerico1chbox");
                Principal.cargarPantalla(this.xjifgenerico1chbox);
                break;
            case "Manual de Tarifas":
                this.xJIFFManual = new JIFFManual();
                Principal.cargarPantalla(this.xJIFFManual);
                break;
            case "Parentesco":
                this.xjifgenericoch = new JIFGenericoCh("xjifparentesco", "Parentesco");
                Principal.cargarPantalla(this.xjifgenericoch);
                break;
            case "Tipo de Nota":
                this.xjif_Notas_clinicas = new JIF_HTipo_Notas();
                Principal.cargarPantalla(this.xjif_Notas_clinicas);
                break;
            case "Incremento, Decremento o Aumento de Tarifas":
                this.xjifaumentotarifas = new JIFFAumentoTarifas();
                Principal.cargarPantalla(this.xjifaumentotarifas);
                break;
            case "Suministro":
                this.xjifsuministro = new JIFSSuministro();
                Principal.cargarPantalla(this.xjifsuministro);
                break;
            case "Tarifa Suministro":
                this.xjiftarifasuministro = new JIFFTarifaSuministro();
                Principal.cargarPantalla(this.xjiftarifasuministro);
                break;
            case "Suministro x Bodega":
                this.xjifsuministrobodega = new JIFSSuministroxBodega();
                Principal.cargarPantalla(this.xjifsuministrobodega);
                break;
            case "Relación Laboral":
                this.xjifrelacionlaboral = new JIFARelacionLaboral();
                Principal.cargarPantalla(this.xjifrelacionlaboral);
                break;
            case "Bodegas":
                this.xjifbodegas = new JIFSBodegas();
                Principal.cargarPantalla(this.xjifbodegas);
                break;
            case "Movimiento x Bodega":
                this.xjifmovimientobodega = new JIFSMovimientoxBodega();
                Principal.cargarPantalla(this.xjifmovimientobodega);
                break;
            case "Profesional":
                this.xjifprofesional = new JIFGProfesional();
                Principal.cargarPantalla(this.xjifprofesional);
                break;
            case "Especialidad":
                this.xjifespecialidad = new JIFGEspecialidad();
                Principal.cargarPantalla(this.xjifespecialidad);
                break;
            case "Datos Ips":
                this.xjifdatosempresa = new JIFGDatosEmpresa();
                Principal.cargarPantalla(this.xjifdatosempresa);
                break;
            case "Departamento":
                this.xJIFDepartamento = new JIFDepartamento();
                Principal.cargarPantalla(this.xJIFDepartamento);
                break;
            case "Etapa Proceso":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1(frm, "jifetapaproceso");
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Municipio":
                this.xjifgenerico3 = new JIFGenerico3Text1Combo1CheckBox(frm, "jifmunicipio");
                Principal.cargarPantalla(this.xjifgenerico3);
                break;
            case "Barrio":
                this.xjifbarrio = new JIFGBarrio();
                Principal.cargarPantalla(this.xjifbarrio);
                break;
            case "Encuesta Tipo de Respuesta":
                this.xJIFETipoRespuesta = new JIFETipoRespuesta();
                Principal.cargarPantalla(this.xJIFETipoRespuesta);
                break;
            case "Tipo de Periodos Cartera":
                this.xJIFTipoPeriodosCartera = new JIFTipoPeriodosCartera();
                Principal.cargarPantalla(this.xJIFTipoPeriodosCartera);
                break;
            case "Supervisor":
                this.xjifsupervisor = new JIFGSupervisor();
                Principal.cargarPantalla(this.xjifsupervisor);
                break;
            case "Turnos":
                this.xjifturnoscitas = new JIFCTurnosCita();
                Principal.cargarPantalla(this.xjifturnoscitas);
                break;
            case "Clase Consultorio":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("jifclaseconsultorio", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Consultorio":
                this.jIFConsultorio = new JIFConsultorio();
                Principal.cargarPantalla(this.jIFConsultorio);
                break;
            case "MedioDePago":
                this.jIFMedioDePago = new JIFMedioDePago();
                Principal.cargarPantalla(this.jIFMedioDePago);
                break;
            case "Clase de Cita":
                this.xjifclasecita = new JIFCClaseCita();
                Principal.cargarPantalla(this.xjifclasecita);
                break;
            case "Alerta x Usuario":
                if (this.xjifalertausuario != null) {
                    this.xjifalertausuario.dispose();
                }
                this.xjifalertausuario = new JIFGAlertaxUsuario("jifalertaxusuario1");
                Principal.cargarPantalla(this.xjifalertausuario);
                this.xjifalertausuario.moveToFront();
                break;
            case "Utilidades":
                this.xjifutilidades = new JIFUtilidades();
                Principal.cargarPantalla(this.xjifutilidades);
                break;
            case "Unidades Funcionales":
                this.xjifunidadf = new JIFUnidadFuncional();
                Principal.cargarPantalla(this.xjifunidadf);
                break;
            case "Concepto":
            case "Detalle Concepto":
            case "Tipo Régimen":
            case "Banco":
            case "Conceptos de Radicacion":
            case "Tipo Cuenta":
            case "Condiciones":
            case "Tipo de Novedad":
            case "Tipo de Respuesta":
            case "Festivos":
            case "Contenido HC Odontologica":
            case "Detalle Contenido HC Odontologica":
            case "Parametro":
            case "Tipo Solicitud":
            case "Proceso Sgc":
            case "Diagnóstico Odontológicos":
            case "Cargos SO":
            case "Turnos SO":
            case "Partes Examinar":
            case "Peligros SO":
            case "Tipo No Conformidad":
            case "Origen No Conformidad":
            case "Incumplimiento":
            case "Detalle de Incumplimiento":
            case "Tipo Anticipo":
            case "Detalle Concepto Anticipo":
            case "Entidad":
            case "Unidad Medida Sgc":
            case "Caracteristicas Sgc":
            case "Tipo Indicador Sgc":
            case "Novedades Nomina":
            case "Categorias Activo":
            case "Marca Activo":
            case "Tipo de Reunion":
                this.xjifgenicoc = new JIFGenerico1CheckBoxC(frm, "jifgenericoc");
                Principal.cargarPantalla(this.xjifgenicoc);
                break;
            case "Concepto x Unidad Funcional":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jifconceptounidadf", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Detalle Concepto x Unidad Funcional":
                this.xjifdtalleconcepto = new JIFDetalleConcepto();
                Principal.cargarPantalla(this.xjifdtalleconcepto);
                break;
            case "Tipo Impuesto":
                this.xjifimpuestos = new JIFImpuestos();
                Principal.cargarPantalla(this.xjifimpuestos);
                break;
            case "Detalle de Incumplimientos":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifdetalleincumplimiento", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Sucursal":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jifsucursal", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Plan Único de Cuentas":
                this.xjifpuc = new JIFPlanCuenta();
                Principal.cargarPantalla(this.xjifpuc);
                break;
            case "Presupuesto Puc":
                this.xjifpresupuestopuc = new JIFPresupuestoPuc();
                Principal.cargarPantalla(this.xjifpresupuestopuc);
                break;
            case "Impuesto x Empresa":
                this.xjifimpuestoempresa = new JIFImpuestoxEmpresa();
                Principal.cargarPantalla(this.xjifimpuestoempresa);
                break;
            case "Cuentas x Empresa":
                this.xjifcuentaempresa = new JIFDBancoxEmpresa();
                Principal.cargarPantalla(this.xjifcuentaempresa);
                break;
            case "Tipo Regimen x Empresa":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jiftiporegimen", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Cuenta Puc x Pagar Empresa":
                this.xjifcuentasxpagarempresa = new JIFCPagarPucEmpresa();
                Principal.cargarPantalla(this.xjifcuentasxpagarempresa);
                break;
            case "Contrato x Empresa":
                this.xjifcontratoempresac = new JIFContratoEmpresa();
                Principal.cargarPantalla(this.xjifcontratoempresac);
                break;
            case "Tipo de Cajas":
                this.xjiftipocaja = new Contabilidad.JIFTipoCaja();
                Principal.cargarPantalla(this.xjiftipocaja);
                break;
            case "Buscar Puc":
                this.xjifpucx = new JIFPuc(this.xjifconceptocaja, frm);
                Principal.cargarPantalla(this.xjifpucx);
                break;
            case "Conceptos":
                this.xjifconceptocaja = new JIFTipoConceptoCaja();
                Principal.cargarPantalla(this.xjifconceptocaja);
                break;
            case "Cuenta Contable x Concepto":
                this.xjifgenericodoscombox = new JIFGenericoDosComboxC("jifauxiliarxconcepto", "Auxiliar x Concepto");
                Principal.cargarPantalla(this.xjifgenericodoscombox);
                break;
            case "Valorización":
                this.xjifvalorizacionp = new JIFPresupuestoPucN();
                Principal.cargarPantalla(this.xjifvalorizacionp);
                break;
            case "Reeliquidación de Orden o Factura":
                this.xjifreliquidacionfac = new JIFReliquidacionFac("jifreliquidacionfactura");
                Principal.cargarPantalla(this.xjifreliquidacionfac);
                break;
            case "Listado de Facturas x Empresa":
                this.xjifconsultarinffac = new JIFConsultarInformesE("jifconsultarinformacionf", 0);
                Principal.cargarPantalla(this.xjifconsultarinffac);
                break;
            case "Listado de Facturas Armadas x Empresa":
                this.xjifconsultarinffac = new JIFConsultarInformesE("jifconsultarinformacionf", 1);
                Principal.cargarPantalla(this.xjifconsultarinffac);
                break;
            case "Concepto Cuenta de Cobro":
                this.xjifconceptoccobro = new JIFConceptoCCobro("jifconceptocc");
                Principal.cargarPantalla(this.xjifconceptoccobro);
                break;
            case "Concepto Reembolso":
                this.xjifconceptoreembolso = new JIFConceptoReembolso();
                Principal.cargarPantalla(this.xjifconceptoreembolso);
                break;
            case "Buscar Puc1":
                this.xjifpucx = new JIFPuc(this.xjifconceptoreembolso, frm);
                Principal.cargarPantalla(this.xjifpucx);
                break;
            case "Unidad Funcional x Empresa":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jifunidadfempresa", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Cargo x Usuario":
                this.xjifusuarioxcargo = new JIFRHUsuarioCargo();
                Principal.cargarPantalla(this.xjifusuarioxcargo);
                break;
            case "Documento x Usuario Firmar":
                this.xjifdocfirma = new JIFDocumentoxUsuarioF();
                Principal.cargarPantalla(this.xjifdocfirma);
                break;
            case "Interraciones Medicamentosas":
                this.xjifinteracionmed = new JIFInterracionesMed();
                Principal.cargarPantalla(this.xjifinteracionmed);
                break;
            case "Tarifa MP":
                this.xjiftarifamp = new JIFSTarifaEmpresaMP();
                Principal.cargarPantalla(this.xjiftarifamp);
                break;
            case "Formato Dian":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1(frm, "jifformatodian");
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Concepto Dian":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1(frm, "jifconceptodian");
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Formato x Concepto Dian":
                this.xjifgenericocombox2 = new JIFGenericoDosCombox("jifformatoconceptodian", "Formato x Concepto Dian");
                Principal.cargarPantalla(this.xjifgenericocombox2);
                break;
            case "Areas":
                this.xjifgenericoch = new JIFGenericoCh("xjifareas", "Areas");
                Principal.cargarPantalla(this.xjifgenericoch);
                break;
            case "Registro de Novedad":
                this.xjifregistronov = new JIFRegistroNovedades();
                Principal.cargarPantalla(this.xjifregistronov);
                break;
            case "Preguntas":
                this.xjifpreguntaencuesta = new JIFEPreguntaEncuesta();
                Principal.cargarPantalla(this.xjifpreguntaencuesta);
                break;
            case "Pregunta x Encuesta":
            case "Asignación x Encuesta":
                this.xjifarmadoencuesta = new JIFEArmadoEncuesta(frm);
                Principal.cargarPantalla(this.xjifarmadoencuesta);
                break;
            case "Suministro x Area":
                this.xjifgenericocombox1 = new JIFGenericoUnComboxEstado("xjifsuministroxarealab", "Suministro x Area");
                Principal.cargarPantalla(this.xjifgenericocombox1);
                break;
            case "Detalle Contenido":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jifdetallecontenido1", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Parametro Detalle":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("jifparametrodetalle", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Concepto x Caja":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifconceptoxcaja", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Actividad Solicitud":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifactividadsolictud", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Cargos UnidadF":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifcargosunidadf", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Procedimiento x Paquete":
                this.xjifprocpaquetes = new JIFFProcedimientoxPaquete();
                Principal.cargarPantalla(this.xjifprocpaquetes);
                break;
            case "Tipo Actividad x Proceso":
                this.xjifgenericodoscombox = new JIFGenericoDosComboxC("xjiftipoactividadproceso", frm.toUpperCase());
                Principal.cargarPantalla(this.xjifgenericodoscombox);
                break;
            case "Contenido x Detalle HC":
                this.xjifgenericocomboc = new JIFGenericoUnComboxEstadoC("xjifcontenidoxdetallehc", frm);
                Principal.cargarPantalla(this.xjifgenericocomboc);
                break;
            case "Detalle Examen Físico":
                this.xjifexamenfisico = new JIFGenericoDosComboxSpinner("xjifdetalleexafisico", frm);
                Principal.cargarPantalla(this.xjifexamenfisico);
                break;
            case "Tipo Documento C":
                this.xjifdoccontable = new JIFCTipoDocumentoC();
                Principal.cargarPantalla(this.xjifdoccontable);
                break;
            case "Encuesta Pregunta por Area":
                this.xJIFEPreguntaxArea = new JIFEPreguntaxArea();
                Principal.cargarPantalla(this.xJIFEPreguntaxArea);
                break;
            case "Ubicacion":
                this.xjifgenerico1txt1box = new JIFGenerico1Text1Combo1CheckBox1("xjifubicacion", frm);
                Principal.cargarPantalla(this.xjifgenerico1txt1box);
                break;
            case "Vacunación x Esquema":
                this.xjifvacunaesquema = new JIFVacunacionEsquema("jifvacunaesquema", frm);
                Principal.cargarPantalla(this.xjifvacunaesquema);
                break;
            case "Configuración Agenda Quirófano":
                this.xjifconfsalacirugia = new JIFConfSalaCirugias("jifconfsalacirugias", frm);
                Principal.cargarPantalla(this.xjifconfsalacirugia);
                break;
            case "Patología Reporte":
                this.xjifreportep = new JIFReportePatologia("jifreportepatologia", frm);
                Principal.cargarPantalla(this.xjifreportep);
                break;
            case "Tipo Sala Quirurgica":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo Sala", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Categoria":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Categoria", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo de Cita Prioritaria":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo de Cita Prioritaria", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Grupo Sistema":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Grupo Sistema", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo de Formula":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo de Formula", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo de Programa":
                this.xJIFTipoPrograma = new JIFTipoPrograma("Tipo de Programa", frm);
                Principal.cargarPantalla(this.xJIFTipoPrograma);
                break;
            case "Tipo de Acción":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo de Acción", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo de Doc Ayudas DX":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo de Doc Ayudas DX", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo de Concepto":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo de Concepto", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo Restricción":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo Restricción", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Clasif Concepto Nomina":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Clasif Concepto Nomina", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo Medición x Bodega":
                this.xjiftipomedbod = new JIFGenerico2Text1Combo1CheckBoxTemp("Tipo Medición x Bodega", frm);
                Principal.cargarPantalla(this.xjiftipomedbod);
                break;
            case "Tipo Horario x Bodega":
                this.xjiftipomedbod = new JIFGenerico2Text1Combo1CheckBoxTemp("Tipo Horario x Bodega", frm);
                Principal.cargarPantalla(this.xjiftipomedbod);
                break;
            case "Demanda Inducida":
                this.xiddemandaind = new JIFDemandaIndusida("Demanda Inducida", frm);
                Principal.cargarPantalla(this.xiddemandaind);
                break;
            case "Vacunas":
                this.xjif1text2comb1check = new JIFGenerico1Text2Combos1Check("Vacunas", frm);
                Principal.cargarPantalla(this.xjif1text2comb1check);
                break;
            case "Manuales":
                this.xjifmanuales = new JIFManualesxModulos("Manuales");
                Principal.cargarPantalla(this.xjifmanuales);
                break;
            case "Partes x Tipo de Ecografía":
                this.xjifexamenfisico = new JIFGenericoDosComboxSpinner("xjifpartesecografia", frm);
                Principal.cargarPantalla(this.xjifexamenfisico);
                break;
            case "Antecedentes Patológicos":
                this.xjifGenerico1Text1Combo2CheckBox = new JIFGenerico1Text1Combo2CheckBox("xjifantencedentespatologicos", "Antecedentes Patológicos", 0);
                Principal.cargarPantalla(this.xjifGenerico1Text1Combo2CheckBox);
                break;
            case "SEG":
                this.xjifGenerico1CheckBox1TextArea = new JIFGenerico1CheckBox1TextArea("jifSEG", "SEG");
                Principal.cargarPantalla(this.xjifGenerico1CheckBox1TextArea);
                break;
            case "Resultado Visiometría":
                this.xjifJIFResultadoVisiometria = new JIFResultadoVisiometria();
                Principal.cargarPantalla(this.xjifJIFResultadoVisiometria);
                break;
            case "Recomendaciones":
                this.xjifRecomendaciones = new JIFSoRecomendaciones();
                Principal.cargarPantalla(this.xjifRecomendaciones);
                break;
            case "Subcategoria Peligros":
                this.fPeligros = new JIFPeligros();
                Principal.cargarPantalla(this.fPeligros);
                break;
            case "Tipo Respuesta":
                this.xjifTipoRespuesta = new JIFTipoRespuesta();
                Principal.cargarPantalla(this.xjifTipoRespuesta);
                break;
            case "Tipo de Preguntas":
                this.xjifTipoPreguntas = new JIFTipoPreguntas();
                Principal.cargarPantalla(this.xjifTipoPreguntas);
                break;
            case "Preguntas x Subcategoria":
                this.xjifexamenfisico = new JIFGenericoDosComboxSpinner("xjifpreguntasxSubcategorias", frm);
                Principal.cargarPantalla(this.xjifexamenfisico);
                break;
            case "Tipo pregunta x Respuesta":
                this.xjifTipo_Pregunta_Respuesta = new JIFSOTipo_Pregunta_Respuesta("jifTipo_Pregunta_Respuesta", frm);
                Principal.cargarPantalla(this.xjifTipo_Pregunta_Respuesta);
                break;
            case "Dimensión":
                this.xjifGenerico1Text1Combo2SpinerEstado = new JIFGenerico1Text1Combo2SpinerEstado("xjifGenerico1Text1Combo2SpinerEstado", "Dimensión");
                Principal.cargarPantalla(this.xjifGenerico1Text1Combo2SpinerEstado);
                break;
            case "Dominio":
                this.xJIFPreguntaDominio = new JIFPreguntaDominio();
                Principal.cargarPantalla(this.xJIFPreguntaDominio);
                break;
            case "Forma Farmacéutica":
                this.xJIFGenerico2Text2CheckBox = new JIFGenerico2Text2CheckBox("Forma Farmacéutica", "xJIFGenerico2Text2CheckBox");
                Principal.cargarPantalla(this.xJIFGenerico2Text2CheckBox);
                break;
            case "Tipo Sala":
                this.xJIFGenerico2Text2CheckBox = new JIFGenerico2Text2CheckBox("Tipo Sala", "xJIFGenerico2Text2CheckBox");
                Principal.cargarPantalla(this.xJIFGenerico2Text2CheckBox);
                break;
            case "Via de Administracion":
                this.xJIFGenerico2Text2CheckBox = new JIFGenerico2Text2CheckBox("Via de Administracion", "xJIFGenerico2Text2CheckBox");
                Principal.cargarPantalla(this.xJIFGenerico2Text2CheckBox);
                break;
            case "Preguntas x Categoría":
                this.xJIFEscalaAbreviadaP = new JIFEscalaAbreviadaP();
                Principal.cargarPantalla(this.xJIFEscalaAbreviadaP);
                break;
            case "Concepto Caja":
                this.xJIFConceptoCaja = new JIFConceptoCaja();
                Principal.cargarPantalla(this.xJIFConceptoCaja);
                break;
            case "Condición Vítima":
                this.xJIFConceptoCaja = new JIFConceptoCaja();
                Principal.cargarPantalla(this.xJIFConceptoCaja);
                break;
            case "Tipo de Empresa":
                this.xJIFFTipoEmpresa = new JIFFTipoEmpresa();
                Principal.cargarPantalla(this.xJIFFTipoEmpresa);
                break;
            case "Profesional Sala Cirugia":
                this.xJIFFProfSalaCirugia = new JIFFProfSalaCirugia();
                Principal.cargarPantalla(this.xJIFFProfSalaCirugia);
                break;
            case "ProcedimientoTipoQx":
                this.xJIFGenerico3combo2text1check = new JIFGenerico3combo2text1check(frm, "ProcedimientoTipoQx");
                Principal.cargarPantalla(this.xJIFGenerico3combo2text1check);
                break;
            case "GrupoUvr":
                this.xJIFGrupoUvr = new JIFGrupoUvr();
                Principal.cargarPantalla(this.xJIFGrupoUvr);
                break;
            case "Excepción":
                this.xJIFFExcepcion = new JIFFExcepcion();
                Principal.cargarPantalla(this.xJIFFExcepcion);
                break;
            case "Centro de Costo":
                this.xJIFCentroCosto = new JIFCentroCosto();
                Principal.cargarPantalla(this.xJIFCentroCosto);
                break;
            case "Camas":
                this.xJIFFCamas = new JIFFCamas();
                Principal.cargarPantalla(this.xJIFFCamas);
                break;
            case "Horario de Farmacia":
                this.xJIFHorarioFarmacia = new JIFHorarioFarmacia();
                Principal.cargarPantalla(this.xJIFHorarioFarmacia);
                break;
            case "Unidad Camas":
                this.jIFUnidadCama = new JIFUnidadCama();
                Principal.cargarPantalla(this.jIFUnidadCama);
                break;
            case "Tipo Alerta":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo Alerta", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Procedimiento x Prioridad":
                this.xJIFGenericoDosCombox1Check = new JIFGenericoDosCombox1Check("procedimientoxprioridad", frm);
                Principal.cargarPantalla(this.xJIFGenericoDosCombox1Check);
                break;
            case "Tipo Anestesia":
                this.xjifgenericoch2 = new JIFGenerico2CheckBox("Tipo Anestesia", frm);
                Principal.cargarPantalla(this.xjifgenericoch2);
                break;
            case "Tipo Sistema":
                this.xJIFGenerico1txt1combo1check1spiner = new JIFGenerico1txt1combo1check1spiner("Tipo Sistema", frm);
                Principal.cargarPantalla(this.xJIFGenerico1txt1combo1check1spiner);
                break;
            case "Tipo Destido Salida":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1("Tipo Destido Salida", frm);
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Tipo Concepto Agrupado":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1("Tipo Concepto Agrupado", frm);
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Causa Externa":
                this.xJIFFGenerico2TextBox1Spiner1CheckBox = new JIFFGenerico2TextBox1Spiner1CheckBox("Causa Externa", frm);
                Principal.cargarPantalla(this.xJIFFGenerico2TextBox1Spiner1CheckBox);
                break;
            case "Estadio Glomerural":
                this.xJIFFGenerico3TextBox1Check = new JIFFGenerico3TextBox1Check("Estadio Glomerural", frm);
                Principal.cargarPantalla(this.xJIFFGenerico3TextBox1Check);
                break;
            case "Periocidad":
                this.xjifgenerico4 = new JIFGenerico2SpinerEstadoC("Periocidad", frm);
                Principal.cargarPantalla(this.xjifgenerico4);
                break;
            case "Tipo Prioridad":
                this.xJIFFGenerico1Text1Spiner1Check = new JIFFGenerico1Text1Spiner1Check("Tipo Prioridad", frm);
                Principal.cargarPantalla(this.xJIFFGenerico1Text1Spiner1Check);
                break;
            case "Nombre Encuesta":
                this.xJIFFGenerico1Text1Spiner1Check = new JIFFGenerico1Text1Spiner1Check("Nombre Encuesta", frm);
                Principal.cargarPantalla(this.xJIFFGenerico1Text1Spiner1Check);
                break;
            case "Periodos de Nómina":
                this.xJIFFPeriodosNomina = new JIFFPeriodosNomina();
                Principal.cargarPantalla(this.xJIFFPeriodosNomina);
                break;
            case "Tipo Edad":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1("Tipo Edad", frm);
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Tipo Ambito":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1("Tipo Ambito", frm);
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Tipo Población":
                this.xJIFFGenerico3Text1Check = new JIFFGenerico3Text1Check("Tipo Población", frm);
                Principal.cargarPantalla(this.xJIFFGenerico3Text1Check);
                break;
            case "Rubros":
                this.xJIFRubros = new JIFRubros();
                Principal.cargarPantalla(this.xJIFRubros);
                break;
            case "Periodo":
                this.xJIFFPPeriodo = new JIFFPPeriodo();
                Principal.cargarPantalla(this.xJIFFPPeriodo);
                break;
            case "Tipo Documento Presupuesto":
                this.xJIFFPPTipoDocumento = new JIFFPPTipoDocumento();
                Principal.cargarPantalla(this.xJIFFPPTipoDocumento);
                break;
            case "Documento Tercero Firma":
                this.xJIFFTipoDocTercero = new JIFFTipoDocTercero();
                Principal.cargarPantalla(this.xJIFFTipoDocTercero);
                break;
            case "Rubro x Tipo Documento":
                this.xJIFFRubroTDoc = new JIFFRubroTDoc();
                Principal.cargarPantalla(this.xJIFFRubroTDoc);
                break;
            case "Resoluciones Presupuesto":
                this.xJIFGenerico2CheckBoxC = new JIFGenerico2CheckBoxC("PPResolucion", "PPResolucion");
                Principal.cargarPantalla(this.xJIFGenerico2CheckBoxC);
                break;
            case "Tipo Parentesco":
                this.xJIFGenerico2Text2CheckBox = new JIFGenerico2Text2CheckBox("Tipo Parentesco", frm);
                Principal.cargarPantalla(this.xJIFGenerico2Text2CheckBox);
                break;
            case "Codigos alternos Rubros":
                this.xJIFFRubroResolucion = new JIFFRubroResolucion();
                Principal.cargarPantalla(this.xJIFFRubroResolucion);
                break;
            case "Cod Resolucion Rubro":
                this.xJIFFCodigoAlternoRubro = new JIFFCodigoAlternoRubro();
                Principal.cargarPantalla(this.xJIFFCodigoAlternoRubro);
                break;
            case "Maestro Rubros":
                this.xJIFFRubrosN = new JIFFRubrosN();
                Principal.cargarPantalla(this.xJIFFRubrosN);
                break;
            case "Tipo de Consecuencia - Acciones":
                this.xJIFTipoConsecuenciAcciones = new JIFTipoConsecuenciAcciones();
                Principal.cargarPantalla(this.xJIFTipoConsecuenciAcciones);
                break;
            case "Tipo Sexo":
                this.xJIFF_Generico3Text1Check = new JIFF_Generico3Text1Check("Tipo Sexo");
                Principal.cargarPantalla(this.xJIFF_Generico3Text1Check);
                break;
            case "Nombre Del Evento":
                this.xJIFTipoEventoSC = new JIFTipoEventoSC();
                Principal.cargarPantalla(this.xJIFTipoEventoSC);
                break;
            case "Riesgo seguridad Clínica":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Riesgo seguridad Clínica");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "SO Tipo de Resultado":
                this.xJIF_SO_TipoResultado = new JIF_SO_TipoResultado();
                Principal.cargarPantalla(this.xJIF_SO_TipoResultado);
                break;
            case "Tipo De Causa Analisis":
                this.xJIF_Generico1Text1Spinner1Check = new JIF_Generico1Text1Spinner1Check("Tipo De Causa Analisis");
                Principal.cargarPantalla(this.xJIF_Generico1Text1Spinner1Check);
                break;
            case "Tipo Clasificacion De Riesgo Adverso":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Tipo Clasificacion De Riesgo Adverso");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "SC Tipo Proceso x Tipo Riesgo":
                this.xSC_TProcesoTRiesgo = new SC_TProcesoTRiesgo();
                Principal.cargarPantalla(this.xSC_TProcesoTRiesgo);
                break;
            case "SC Tipo Riesgo x Tipo Evento":
                this.xSC_TRiesgoTEvento = new SC_TRiesgoTEvento();
                Principal.cargarPantalla(this.xSC_TRiesgoTEvento);
                break;
            case "Vigencia de Pago Facturas":
                this.xJIF_Generico1Text2Spinner1Check = new JIF_Generico1Text2Spinner1Check("Vigencia de Pago Facturas");
                Principal.cargarPantalla(this.xJIF_Generico1Text2Spinner1Check);
                break;
            case "Forma de Pago":
                this.xJIFFormaPago = new JIFFormapago();
                Principal.cargarPantalla(this.xJIFFormaPago);
                break;
            case "Histórico Salario Mínimo":
                this.xJIFFHistoricoSalarioMinimo = new JIFFHistoricoSalarioMinimo();
                Principal.cargarPantalla(this.xJIFFHistoricoSalarioMinimo);
                break;
            case "Encabezado de Rubro":
                this.xJIFF_PP_RubrosEncabezado = new JIFF_PP_RubrosEncabezado();
                Principal.cargarPantalla(this.xJIFF_PP_RubrosEncabezado);
                break;
            case "Informe de Procedimientos Facturados":
                this.xJIFInformesFacturadosController = new JIFInformesFacturadosController("Informe de Procedimientos Facturados");
                Principal.cargarPantalla(this.xJIFInformesFacturadosController);
                break;
            case "Informe de Insumos Facturados":
                this.xJIFInformesFacturadosController = new JIFInformesFacturadosController("Informe de Insumos Facturados");
                Principal.cargarPantalla(this.xJIFInformesFacturadosController);
                break;
            case "Tipo Documento Firmas":
                this.xJIFF_TipoDocumentoFirma = new JIFF_TipoDocumentoFirma();
                Principal.cargarPantalla(this.xJIFF_TipoDocumentoFirma);
                break;
            case "Tipo de Tubo":
                this.xJIFTipoTubo = new JIFTipoTubo();
                Principal.cargarPantalla(this.xJIFTipoTubo);
                break;
            case "Tipo Documentos":
                this.xJIFFTipoDocumentoSoporte = new JIFFTipoDocumentoSoporte();
                Principal.cargarPantalla(this.xJIFFTipoDocumentoSoporte);
                break;
            case "Rutas de Soportes":
                this.xJIFRutaSoporte = new JIFRutaSoporte();
                Principal.cargarPantalla(this.xJIFRutaSoporte);
                break;
            case "Cargo":
                this.xJIFRHTipoCargo = new JIFRHTipoCargo();
                Principal.cargarPantalla(this.xJIFRHTipoCargo);
                break;
            case "Tipo Clasificacion De Cita":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Tipo Clasificacion De Cita");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "Actividad Economica":
                this.xJIFFActividadEconomica = new JIFFActividadEconomica();
                Principal.cargarPantalla(this.xJIFFActividadEconomica);
                break;
            case "Nivel de Actividad Economica":
                this.xJIFFNivelActividadE = new JIFFNivelActividadE();
                Principal.cargarPantalla(this.xJIFFNivelActividadE);
                break;
            case "Tipo de Certificado SO":
                this.xJIFTipoCertificadoSO = new JIFTipoCertificadoSO();
                Principal.cargarPantalla(this.xJIFTipoCertificadoSO);
                break;
            case "Tipo de Concepto SO":
                this.xJIFConceptoSO = new JIFConceptoSO();
                Principal.cargarPantalla(this.xJIFConceptoSO);
                break;
            case "Tipo de Documento de Recursos Humanos":
                this.xJIFGenerico3CheckBoxC3 = new JIFGenerico3CheckBoxC3("Tipo de Documento de Recursos Humanos", "xJIFTipoDocumentosRH");
                Principal.cargarPantalla(this.xJIFGenerico3CheckBoxC3);
                break;
            case "Tipo Categoría Seguridad Clínica":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Tipo Categoría Seguridad Clínica");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "Tipo Clasificacion de Residuos":
                this.xJIFTipoClasificacionResiduos = new JIFTipoClasificacionResiduos();
                Principal.cargarPantalla(this.xJIFTipoClasificacionResiduos);
                break;
            case "Registro de Disposicion de Residuos":
                this.xJIFRegistroDisposicionResiduos = new JIFRegistroDisposicionResiduos();
                Principal.cargarPantalla(this.xJIFRegistroDisposicionResiduos);
                break;
            case "País":
                this.xJIFPais = new JIFPais();
                Principal.cargarPantalla(this.xJIFPais);
                break;
            case "Tipo Riesgo de Complicacion":
                this.xJIFTipoRiesgoComplicacion = new JIFTipoRiesgoComplicacion();
                Principal.cargarPantalla(this.xJIFTipoRiesgoComplicacion);
                break;
            case "Tipo de Consentimiento":
                this.xJIFTipoConcentimiento = new JIFTipoConsentimiento();
                Principal.cargarPantalla(this.xJIFTipoConcentimiento);
                break;
            case "Clasificacion Tipo Complicacion de Riesgo":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Clasificacion Tipo Complicacion de Riesgo");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "Tipo de Producto":
                this.xJIFGenerico1Text2Check = new JIFGenerico1Text2Check("Tipo de Producto");
                Principal.cargarPantalla(this.xJIFGenerico1Text2Check);
                break;
            case "Tipo de Seguimiento":
                this.xJIFTipoSeguimiento = new JIFTipoSeguimiento();
                Principal.cargarPantalla(this.xJIFTipoSeguimiento);
                break;
            case "Clasifacion de Tipo Documento":
                this.xJIFTipoDocumentoClasificacion = new JIFTipoDocumentoClasificacion();
                Principal.cargarPantalla(this.xJIFTipoDocumentoClasificacion);
                break;
            case "Conceptos de Agrupacion del Informe CGR":
                this.xJIFConceptoAgrupacionCgr = new JIFConceptoAgrupacionCgr();
                Principal.cargarPantalla(this.xJIFConceptoAgrupacionCgr);
                break;
            case "Tipo Clasificacion de Imagenes":
                this.xJIFF_Generico1Text1Check = new JIFF_Generico1Text1Check("Tipo Clasificacion de Imagenes");
                Principal.cargarPantalla(this.xJIFF_Generico1Text1Check);
                break;
            case "Ficha de Notificaciones Sivigila":
                this.xJIFFichaNotificacionSivigila = new JIFFichaNotificacionSivigila();
                Principal.cargarPantalla(this.xJIFFichaNotificacionSivigila);
                break;
            case "Clasificacion de Notas":
                this.xJIFClasificacionNotas = new JIFClasificacionNotas();
                Principal.cargarPantalla(this.xJIFClasificacionNotas);
                break;
            case "Grupo Examen Fisico":
                this.xJIFGrupoExamenFisico = new JIFGrupoExamenFisico();
                Principal.cargarPantalla(this.xJIFGrupoExamenFisico);
                break;
            case "Grupo SistemasP":
                this.xJIFH_GrupoSistemas = new JIFH_GrupoSistemas();
                Principal.cargarPantalla(this.xJIFH_GrupoSistemas);
                break;
            case "Tipo Sistemas":
                this.xJIFH_TipoSistemas = new JIFH_TipoSistemas();
                Principal.cargarPantalla(this.xJIFH_TipoSistemas);
                break;
            case "Entorno Familiar":
                this.xEntornoFamiliar = new JIFEntornoFamiliar();
                Principal.cargarPantalla(this.xEntornoFamiliar);
                break;
            case "Relacion Familiar":
                this.xFRelacionesFamiliares = new JIFRelacionesFamiliares();
                Principal.cargarPantalla(this.xFRelacionesFamiliares);
                break;
            case "Tipo de Informe":
                this.xJIFTipoDeInforme = new JIFTipoDeInforme();
                Principal.cargarPantalla(this.xJIFTipoDeInforme);
                break;
            case "Puc Tipo de Informe":
                this.xJIFPucNifTipoInforme = new JIFPucNifTipoInforme();
                Principal.cargarPantalla(this.xJIFPucNifTipoInforme);
                break;
            case "Tipo HC":
                this.xJIFTipoHistoria = new JIFTipoHistoria();
                Principal.cargarPantalla(this.xJIFTipoHistoria);
                break;
            case "Entidades Contraloria":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 1, "EntidadesContraloria");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Origen Ingreso":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 2, "OrigenIngreso");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Tipo Destinacion":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 3, "TipoDestinacion");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Tipo Recursos":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 4, "TipoRecursos");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Tipo Situacion":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 5, "TipoSituacion");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Tipo Vigencia":
                this.xJIFGenericoPresupuesto = new JIFGenericoPresupuesto(frm, 6, "TipoVigencia");
                Principal.cargarPantalla(this.xJIFGenericoPresupuesto);
                break;
            case "Finalidad Gasto":
                this.xJIFFinalidaGasto = new JIFFinalidaGasto();
                Principal.cargarPantalla(this.xJIFFinalidaGasto);
                break;
            case "Rubro Contraloria":
                this.xJIFRubrosContraloria = new JIFRubrosContraloria();
                Principal.cargarPantalla(this.xJIFRubrosContraloria);
                break;
            case "Configuracion de Items":
                this.xJIFConfiguracionItems = new JIFConfiguracionItems();
                Principal.cargarPantalla(this.xJIFConfiguracionItems);
                break;
            case "Clasificacion Lasa":
                this.jIFClasificacionLasa = new JIFClasificacionLasa();
                Principal.cargarPantalla(this.jIFClasificacionLasa);
                break;
            case "Unidad de Medida":
                this.xJIFUnidadMedida = new JIFUnidadMedida();
                Principal.cargarPantalla(this.xJIFUnidadMedida);
                break;
            case "Tipo Antecedente Psiquiátrico":
                this.jiffTipoAntecedentesPsiquiatricos = new JIFFTipoAntecedentesPsiquiatricos();
                Principal.cargarPantalla(this.jiffTipoAntecedentesPsiquiatricos);
                break;
            case "Tipo Atención":
                this.jIFTipoAtencion = new com.genoma.plus.controller.facturacion.JIFTipoAtencion();
                Principal.cargarPantalla(this.jIFTipoAtencion);
                break;
            case "Procedimiento Por Centro De Costo":
                this.jIFProcedimientoPorCentroDeCosto = new JIFProcedimientoPorCentroDeCosto();
                Principal.cargarPantalla(this.jIFProcedimientoPorCentroDeCosto);
                break;
            case "Importar Esquema PaiWeb":
                this.JIFImportatPaiweb = new JIFImportatPaiweb();
                Principal.cargarPantalla(this.JIFImportatPaiweb);
                break;
            case "Periodos Financieros":
                this.xjifperiodof = new JIFPeriodoFinaciero();
                Principal.cargarPantalla(this.xjifperiodof);
                break;
            case "TipoAgente":
                this.xJIFFTipoAgente = new JIFFTipoAgente();
                Principal.cargarPantalla(this.xJIFFTipoAgente);
                break;
            case "Auditor":
                this.xJIFAuditorPorEmpresa = new JIFAuditorPorEmpresa();
                Principal.cargarPantalla(this.xJIFAuditorPorEmpresa);
                break;
            case "Tipo de comida":
                this.xJIFTipoComida = new JIFTipoComida();
                Principal.cargarPantalla(this.xJIFTipoComida);
                break;
            case "Tipo de dieta":
                this.xJIFTipoDieta = new JIFTipoDieta();
                Principal.cargarPantalla(this.xJIFTipoDieta);
                break;
            case "Resolucion dian":
                this.xJIF_ResolucionDian = new JIF_ResolucionDian();
                Principal.cargarPantalla(this.xJIF_ResolucionDian);
                break;
            case "Tipo de Politicas":
                this.xJIFTipoPolitica = new JIFTipoPolitica();
                Principal.cargarPantalla(this.xJIFTipoPolitica);
                break;
            case "Vigilancia Seguimiento":
                this.xJIFVigilanciaSeguimiento = new JIFVigilanciaSeguimiento();
                Principal.cargarPantalla(this.xJIFVigilanciaSeguimiento);
                break;
            case "Tipo de Documento Soporte":
                this.xjiftipodedocumentosoporte = new JIFGTipoDocumentoSoporte();
                this.xjiftipodedocumentosoporte.mNuevo();
                Principal.cargarPantalla(this.xjiftipodedocumentosoporte);
                break;
            case "Tipo de Documentos Hc":
                this.xjifhtipodocumentoshc = new JIFHTipoDocumentosHc();
                this.xjifhtipodocumentoshc.mNuevo();
                Principal.cargarPantalla(this.xjifhtipodocumentoshc);
                break;
            case "Tipos de Ayuda Dx":
                this.xjifhtipoayudadx = new JIFHTipoAyudaDx();
                this.xjifhtipoayudadx.mNuevo();
                Principal.cargarPantalla(this.xjifhtipoayudadx);
                break;
            case "Tipo Discapacidad":
                this.jiftipodiscapacidad = new JIFTipoDiscapacidad();
                Principal.cargarPantalla(this.jiftipodiscapacidad);
                break;
            case "Entorno Atencion":
                this.jifentornoatencion = new JIFEntornoAtencion();
                Principal.cargarPantalla(this.jifentornoatencion);
                break;
            case "Suministro Tecnologia Salud":
                this.jifSuministroTecnologiaSalud = new JIFSuministroTecnologiaSalud();
                Principal.cargarPantalla(this.jifSuministroTecnologiaSalud);
                break;
            case "Origen Admision":
                this.jIFOrigenAdmision = new JIFOrigenAdmision();
                Principal.cargarPantalla(this.jIFOrigenAdmision);
                break;
            case "Tipo de Parentesco":
                this.jIFTipoParentesco = new JIFTipoParentesco();
                Principal.cargarPantalla(this.jIFTipoParentesco);
                break;
            case "Sexo":
                this.jifsexo = new JIFGSexo();
                Principal.cargarPantalla(this.jifsexo);
                break;
            case "Tipo sistema de vigilancia":
                this.jifftiposistemavigilancia = new JIFFTipoSistemaVigilancia();
                Principal.cargarPantalla(this.jifftiposistemavigilancia);
                break;
            case "Tipo vigilancia sistema":
                this.jiffttipovigilanciasistemas = new JIFFTipoVigilanciaSistemas();
                Principal.cargarPantalla(this.jiffttipovigilanciasistemas);
                break;
            case "Identidad Genero":
                this.jifgenero = new JIFIdentidadGenero();
                Principal.cargarPantalla(this.jifgenero);
                break;
            case "Tecnología Salud":
                this.jIFGTecnologiaSalud = new JIFGTecnologiaSalud();
                Principal.cargarPantalla(this.jIFGTecnologiaSalud);
                break;
            case "Rubros N":
                this.xJIFRubros1 = new JIFRubros1();
                Principal.cargarPantalla(this.xJIFRubros1);
                break;
            case "Rubros CPC":
                this.jIFGenericoRubros = new JIFGenericoRubros(frm, "Rubros CPC");
                Principal.cargarPantalla(this.jIFGenericoRubros);
                break;
            case "Rubros Fuente Financiacion":
                this.jIFGenericoRubros = new JIFGenericoRubros(frm, "Rubros Fuente Financiacion");
                Principal.cargarPantalla(this.jIFGenericoRubros);
                break;
            case "Rubros Centro de Costos":
                this.jIFGenericoRubros = new JIFGenericoRubros(frm, "Rubros Centro de Costos");
                Principal.cargarPantalla(this.jIFGenericoRubros);
                break;
            case "Modalidad Atencion":
                this.jifmodalidadatencion = new JIFGModalidadAtencion();
                Principal.cargarPantalla(this.jifmodalidadatencion);
                break;
            case "Tipo Medicamento":
                this.jiftipomedicamento = new JIFTipoMedicamento();
                Principal.cargarPantalla(this.jiftipomedicamento);
                break;
            case "Codigo Servicio":
                this.jifcodigoservicio = new JIFCodigoServicio();
                Principal.cargarPantalla(this.jifcodigoservicio);
                break;
            case "Clasificación AIEPI":
                this.jifgaiepi = new JIFGenericoAIEPI(frm, "Clasificación AIEPI");
                Principal.cargarPantalla(this.jifgaiepi);
                break;
            case "Respuestas AIEPI":
                this.jifgaiepi = new JIFGenericoAIEPI(frm, "Respuestas AIEPI");
                Principal.cargarPantalla(this.jifgaiepi);
                break;
            case "Preguntas AIEPI Oncologíco":
                this.jifgaiepi = new JIFGenericoAIEPI(frm, "Preguntas AIEPI Oncologíco");
                Principal.cargarPantalla(this.jifgaiepi);
                break;
            case "Servicios RIPS":
                this.jifserviciosrips = new JIFServiciosRips();
                Principal.cargarPantalla(this.jifserviciosrips);
                break;
            case "Tipo Destino":
                this.jiftipodestino = new JIFTipoDestino();
                Principal.cargarPantalla(this.jiftipodestino);
                break;
            case "Unidad Minima Dispensacion":
                this.xjifgenerico2 = new JIFGenerico2Text1CheckBox1(frm, "Unidad Minima Dispensacion");
                Principal.cargarPantalla(this.xjifgenerico2);
                break;
            case "Procedimiento Servicio Rips":
                this.xJIFGenericoDosCombox1Check = new JIFGenericoDosCombox1Check(frm, "Procedimiento Servicio Rips");
                Principal.cargarPantalla(this.xJIFGenericoDosCombox1Check);
                break;
            case "Procedimiento Tipo Finalidad":
                this.xJIFGenericoDosCombox1Check = new JIFGenericoDosCombox1Check("Procedimiento Tipo Finalidad", frm);
                Principal.cargarPantalla(this.xJIFGenericoDosCombox1Check);
                break;
            case "Tipo de Atencion":
                this.jIFTipoAtencion = new com.genoma.plus.controller.facturacion.JIFTipoAtencion();
                Principal.cargarPantalla(this.jIFTipoAtencion);
                break;
        }
    }

    public void anular(String frm) {
        if (frm.equals("JIFFExcepcion")) {
            this.xJIFFExcepcion.mEliminar();
        } else if (frm.equals("jifservicioxprocedimiento")) {
            this.xjifgenericocombox2.mEliminar();
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifconfempresa1":
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    this.xjifempresaBienestar.mGrabar();
                    break;
                } else {
                    this.xjifempresa.mGrabar();
                    break;
                }
                break;
            case "Categoria":
            case "Clasif Concepto Nomina":
                this.xjifgenericoch2.mGrabar();
                break;
            case "xjifconceptonomina":
                this.xjifoconceptonomina.mGrabar();
                break;
            case "xjif_Notas_clinicas":
                this.xjif_Notas_clinicas.mGrabar();
                break;
            case "xjifconceptodetalle":
                this.xjifconceptoanticipo.mGrabar();
                break;
            case "xjifdoccontable":
                this.xjifdoccontable.mGrabar();
                break;
            case "xjifaeropuertos":
                this.xjifgenerico6.mGrabar();
                break;
            case "xjifdetallepreguntas":
                this.xjifgenerico7.mGrabar();
                break;
            case "xjifconceptoestudio":
                this.xjifgenerico7.mGrabar();
                break;
            case "xjiftipoejercicio":
                this.xjifgenerico7.mGrabar();
                break;
            case "xjifconceptopagoglosa":
                this.xjifconceptopagoglosa.mGrabar();
                break;
            case "xjifglosario":
                this.xjifsgcglosario.mGrabar();
                break;
            case "jifsubgrupofacempresa":
                this.xjifsubgrupoxempersa.mGrabar();
                break;
            case "xjiftipoexamenfisico":
            case "xjifencabezadopreguntaso":
            case "xjifencabezadorecomendacion":
            case "Vacunas x Edad":
                this.xjifgenerico5.mGrabar();
                break;
            case "xjifdetallecontenidohc":
                this.xjifdetallecontenido.mGrabar();
                break;
            case "xjifcontenidohc":
                this.xjifgenerico4.mGrabar();
                break;
            case "jifunidadfuncional":
                this.xjifunidadfuncional.mGrabar();
                break;
            case "jiftcaja":
                this.xjiftcaja.mGrabar();
                break;
            case "jifTipo_Pregunta_Respuesta":
                this.xjifTipo_Pregunta_Respuesta.mGrabar();
                break;
            case "jifestratoempresa":
                this.xjifestratoempresa.mGrabar();
                break;
            case "jifempresagrupo":
                this.xjifgrupoempresa.mGrabar();
                break;
            case "jifempresaservicios":
                this.xjifservicioempresa.mGrabar();
                break;
            case "jifempresaserviciosN":
                this.xJIFFEmpresaServiciosN.mGrabar();
                break;
            case "jifempresaprocedimiento":
                this.xjifprocedimientoempresa.mGrabar();
                break;
            case "jifcontratoempresa":
                this.xjifcontratoempresa.mGrabar();
                break;
            case "jifusuariosistemas":
                this.xJIFUsuarioSistema.mGrabar();
                break;
            case "jifestrato":
                this.xjifestrato.mGrabar();
                break;
            case "jifgrupofactura":
            case "xjifareas":
                this.xjifgenericoch.mGrabar();
                break;
            case "jifsubgrupofac":
                this.xjidsubgrupofac.mGrabar();
                break;
            case "jiftipoprocedimiento":
                this.xjiftipoprocedimiento.mGrabar();
                break;
            case "jiftiposervicio":
                this.xjifgenericoch.mGrabar();
                break;
            case "xjifparentesco":
                this.xjifgenericoch.mGrabar();
                break;
            case "xjiftipoalerta":
                this.xjifgenericoch.mGrabar();
                break;
            case "jifservicioxprocedimiento":
            case "jifformatoconceptodian":
            case "jifsegmento_encabezado":
                this.xjifgenericocombox2.mGrabar();
                break;
            case "jifprocedimiento":
                this.xjifprocedimiento.mGrabar();
                break;
            case "jifprocedimientoccosto":
            case "xjifsuministroxarealab":
            case "jifgenericocombox1":
            case "jifsuministroxTformula":
            case "jifequipoxprocedimiento":
                this.xjifgenericocombox1.mGrabar();
                break;
            case "jiftarifaprocedimiento":
                this.xjiftarifaprocedimiento.mGrabar();
                break;
            case "jifgenerico1chbox":
                this.xjifgenerico1chbox.mGrabar();
                break;
            case "Manual de Tarifas":
                this.xJIFFManual.mGrabar();
                break;
            case "jifaumentotarifas":
                this.xjifaumentotarifas.mGrabar();
                break;
            case "jifsuministro":
                this.xjifsuministro.mGrabar();
                break;
            case "jiftarifasuministro":
                this.xjiftarifasuministro.mGrabar();
                break;
            case "jifsuministrobodega":
                this.xjifsuministrobodega.mGrabar();
                break;
            case "jifprincipioactivo":
                this.xjifsuministro.xjifprincipioactivo.mGrabar();
                break;
            case "jifpresentacionfarma":
                this.xjifsuministro.xjifpresentaconfarmaceutica.mGrabar();
                break;
            case "jifpresentacioncomer":
                this.xjifsuministro.xjifgenerico.mGrabar();
                break;
            case "jifconcentracion":
                this.xjifsuministro.xjifconcentracion.grabar();
                break;
            case "jiflaboratorio1":
                this.xjifsuministro.xjifgenerico.mGrabar();
                break;
            case "jifrelacionlaboral":
                this.xjifrelacionlaboral.mGrabar();
                break;
            case "jifbodega":
                this.xjifbodegas.mGrabar();
                break;
            case "jifmovimientosbodega":
                this.xjifmovimientobodega.mGrabar();
                break;
            case "jifprofesional":
                this.xjifprofesional.mGrabar();
                break;
            case "jifespecialidad":
                this.xjifespecialidad.mGrabar();
                break;
            case "jifdatosempresa":
                this.xjifdatosempresa.mGrabar();
                break;
            case "xjifocupacion":
                this.xjifgenerico2.mGrabar();
                break;
            case "jifetapaproceso":
                this.xjifgenerico2.mGrabar();
                break;
            case "jifmunicipio":
                this.xjifgenerico3.mGrabar();
                break;
            case "jifbarrio":
                this.xjifbarrio.mGrabar();
                break;
            case "jifetiporespuesta":
                this.xJIFETipoRespuesta.mGrabar();
                break;
            case "jifsupervisor":
                this.xjifsupervisor.mGrabar();
                break;
            case "jifturnoscitas":
                this.xjifturnoscitas.mGrabar();
                break;
            case "jifclaseconsultorio":
            case "jifconsultorio":
            case "xjifunidadnegocio":
            case "jifbanco":
            case "xjiftipodetalleexamenf":
            case "xjifmotivoanulacion":
            case "xjifubicacion":
            case "xjiftipomedida":
            case "xjifelementospp":
            case "xjifrecomendaciones":
                this.xjifgenerico1txt1box.mGrabar();
                break;
            case "jifclasecita":
                this.xjifclasecita.mGrabar();
                break;
            case "jifalertaxusuario1":
                this.xjifalertausuario.mGrabar();
                break;
            case "jifareafuncional":
                this.xjifunidadf.mGrabar();
                break;
            case "jifgenericoc":
                this.xjifgenicoc.mGrabar();
                break;
            case "jifconceptounidadf":
            case "jifdetallecontenido1":
            case "xjifconceptoxcaja":
            case "xjifcargosunidadf":
            case "jifparametrodetalle":
            case "xjifactividadsolictud":
            case "xjifcontenidoxdetallehc":
            case "jifsucursal":
            case "jiftiporegimen":
            case "jifunidadfempresa":
            case "xjifdetalleincumplimiento":
            case "xjifnovconceptonomina":
                this.xjifgenericocomboc.mGrabar();
                break;
            case "jifdetalleconceptounidadf":
                this.xjifdtalleconcepto.mGrabar();
                break;
            case "jiftipoimpuesto":
                this.xjifimpuestos.mGrabar();
                break;
            case "jifpresupuestopuc":
                this.xjifpresupuestopuc.mGrabar();
                break;
            case "jifimpuestoempresa":
                this.xjifimpuestoempresa.mGrabar();
                break;
            case "jifdatosbancoempresa":
                this.xjifcuentaempresa.mGrabar();
                break;
            case "jifcuentapucxempresa":
                this.xjifcuentasxpagarempresa.mGrabar();
                break;
            case "jifcontratoempresac":
                this.xjifcontratoempresac.mGrabar();
                break;
            case "jiftipocaja":
                this.xjiftipocaja.mGrabar();
                break;
            case "jiftipoconceptocaja":
                this.xjifconceptocaja.mGrabar();
                break;
            case "xjifTipoDestino":
                this.xjifTipoDestino.grabar();
                break;
            case "jifauxiliarxconcepto":
            case "xjiftipoactividadproceso":
                this.xjifgenericodoscombox.mGrabar();
                break;
            case "jifpresupuestopucn":
                this.xjifvalorizacionp.mGrabar();
                break;
            case "jifreliquidacionfactura":
                this.xjifreliquidacionfac.mGrabar();
                break;
            case "jifconceptocc":
                this.xjifconceptoccobro.mGrabar();
                break;
            case "jifconceptoreembolso":
                this.xjifconceptoreembolso.mGrabar();
                break;
            case "jifusuariocargo":
                this.xjifusuarioxcargo.mGrabar();
                break;
            case "jifdocumentousuariof":
                this.xjifdocfirma.mGrabar();
                break;
            case "jifinteracionmed":
                this.xjifinteracionmed.mGrabar();
                break;
            case "jiftarifamp":
                this.xjiftarifamp.mGrabar();
                break;
            case "jifregistronovedades":
                this.xjifregistronov.mGrabar();
                break;
            case "jifformatodian":
            case "jifconceptodian":
                this.xjifgenerico2.mGrabar();
                break;
            case "jifpregunta":
                this.xjifpreguntaencuesta.mGrabar();
                break;
            case "jifarmadoencuesta":
                this.xjifarmadoencuesta.mGrabar();
                break;
            case "jiftipoprocesossgc":
                this.xjiftipoprocesosgc.mGrabar();
                break;
            case "xjifprocedimientoxpaquete":
                this.xjifprocpaquetes.mGrabar();
                break;
            case "xjiffichatecnicaindicador":
                this.xjiffichatecnicaindicador.mGrabar();
                break;
            case "jifvacunaesquema":
                this.xjifvacunaesquema.mGrabar();
                break;
            case "jifreportepatologia":
                this.xjifreportep.mGrabar();
                break;
            case "Tipo de Formula":
            case "Tipo de Acción":
            case "Tipo de Doc Ayudas DX":
                this.xjifgenericoch2.mGrabar();
                break;
            case "jifhorariomedicion":
                this.xjifhorariom.mGrabar();
                break;
            case "Tipo Medición x Bodega":
            case "Tipo Horario x Bodega":
                this.xjiftipomedbod.mGrabar();
                break;
            case "Demanda Inducida":
                this.xiddemandaind.mGrabar();
                break;
            case "Vacunas":
                this.xjif1text2comb1check.mGrabar();
                break;
            case "jifmanualesmodulos":
                this.xjifmanuales.mGrabar();
                break;
            case "xjifdetalleexafisico":
            case "xjifpartesecografia":
            case "xjifpreguntasxSubcategorias":
                this.xjifexamenfisico.mGrabar();
                break;
            case "xjifantencedentespatologicos":
                this.xjifGenerico1Text1Combo2CheckBox.mGrabar();
                break;
            case "Tipo de Concepto":
                this.xjifgenericoch2.mGrabar();
                break;
            case "Tipo Restricción":
                this.xjifgenericoch2.mGrabar();
                break;
            case "SEG":
                this.xjifGenerico1CheckBox1TextArea.mGrabar();
                break;
            case "jifresultadovisiometria":
                this.xjifJIFResultadoVisiometria.mGrabar();
                break;
            case "jifSoRecomendaciones":
                this.xjifRecomendaciones.mGrabar();
                break;
            case "jifSoPeligrosSubcategoria":
                this.fPeligros.mGrabar();
                break;
            case "jiftipodiscapacidad":
                this.jiftipodiscapacidad.grabar();
                break;
            case "jifentornoatencion":
                this.jifentornoatencion.grabar();
                break;
            case "jifSoTipoRespuesta":
                this.xjifTipoRespuesta.mGrabar();
                break;
            case "jifSoTipoPregunta":
                this.xjifTipoPreguntas.mGrabar();
                break;
            case "xjifGenerico1Text1Combo2SpinerEstado":
                this.xjifGenerico1Text1Combo2SpinerEstado.mGrabar();
                break;
            case "jifpreguntaxdominio":
                this.xJIFPreguntaDominio.mGrabar();
                break;
            case "xJIFGenerico2Text2CheckBox":
                this.xJIFGenerico2Text2CheckBox.mGrabar();
                break;
            case "xjifEscalaAbreviada":
                this.xJIFEscalaAbreviadaP.mGuardar();
                break;
            case "xjifpatologiacie10":
                this.xjifpatologiacie10.mGrabar();
                break;
            case "Tipo de Programa":
                this.xJIFTipoPrograma.mGrabar();
                break;
            case "jifconfsalacirugias":
                this.xjifconfsalacirugia.mGrabar();
                break;
            case "xjifConceptoCaja":
                this.xJIFConceptoCaja.mGrabar();
                break;
            case "xjiffTipoEmpresa":
                this.xJIFFTipoEmpresa.mGrabar();
                break;
            case "xjiffsalacirugia":
                this.xjifgenerico1txt1box.mGrabar();
                break;
            case "Profesional Sala Cirugia":
                this.xJIFFProfSalaCirugia.mGrabar();
                break;
            case "GrupoVr":
                this.xJIFGrupoUvr.mGrabar();
                break;
            case "ProcedimientoTipoQx":
                this.xJIFGenerico3combo2text1check.mGrabar();
                break;
            case "Excepción":
                this.xJIFFExcepcion.mGrabar();
                break;
            case "Centro de Costo":
                this.xJIFCentroCosto.mGrabar();
                break;
            case "Camas":
                this.xJIFFCamas.mGrabar();
                break;
            case "Horario de Farmacia":
                this.xJIFHorarioFarmacia.mGrabar();
                break;
            case "JIFUnidadCama":
                this.jIFUnidadCama.mGrabar();
                break;
            case "Grupo Sistema":
                this.xjifgenericoch2.mGrabar();
                break;
            case "Tipo Alerta":
                this.xjifgenericoch2.mGrabar();
                break;
            case "jiftipoperiodoscartera":
                this.xJIFTipoPeriodosCartera.mGrabar();
                break;
            case "Tipo de Cita Prioritaria":
                this.xjifgenericoch2.mGrabar();
                break;
            case "procedimientoxprioridad":
            case "RubroxTipoDoc":
            case "Procedimiento Servicio Rips":
                this.xJIFGenericoDosCombox1Check.mGrabar();
                break;
            case "Tipo Anestesia":
                this.xjifgenericoch2.mGrabar();
                break;
            case "Tipo Sistema":
                this.xJIFGenerico1txt1combo1check1spiner.mGrabar();
                break;
            case "Tipo Destido Salida":
                this.xjifgenerico2.mGrabar();
                break;
            case "Tipo Concepto Agrupado":
                this.xjifgenerico2.mGrabar();
                break;
            case "xjifepreguntaxarea":
                this.xJIFEPreguntaxArea.mGrabar();
                break;
            case "Causa Externa":
                this.xJIFFGenerico2TextBox1Spiner1CheckBox.mGrabar();
                break;
            case "Estadio Glomerural":
                this.xJIFFGenerico3TextBox1Check.mGrabar();
                break;
            case "Periocidad":
                this.xjifgenerico4.mGrabar();
                break;
            case "Tipo Prioridad":
                this.xJIFFGenerico1Text1Spiner1Check.mGrabar();
                break;
            case "Nombre Encuesta":
                this.xJIFFGenerico1Text1Spiner1Check.mGrabar();
                break;
            case "Periodos de Nómina":
                this.xJIFFPeriodosNomina.mGrabar();
                break;
            case "Tipo Edad":
                this.xjifgenerico2.mGrabar();
                break;
            case "Tipo Ambito":
                this.xjifgenerico2.mGrabar();
                break;
            case "Tipo Población":
                this.xJIFFGenerico3Text1Check.mGrabar();
                break;
            case "Periodo":
                this.xJIFFPPeriodo.mGrabar();
                break;
            case "Tipo Documento Presupuesto":
                this.xJIFFPPTipoDocumento.mGrabar();
                break;
            case "Documento Tercero Firma":
                this.xJIFFTipoDocTercero.mGrabar();
                break;
            case "xjifRubrosPTO":
                this.xJIFRubros.mGrabar();
                break;
            case "xjifJIFFRubroTDoc":
                this.xJIFFRubroTDoc.mGrabar();
                break;
            case "PPResolucion":
                this.xJIFGenerico2CheckBoxC.mGrabar();
                break;
            case "Tipo Parentesco":
                this.xJIFGenerico2Text2CheckBox.mGrabar();
                break;
            case "xjifCodigoAlternos":
                this.xJIFFRubroResolucion.mGrabar();
                break;
            case "xJIFFHistoricoSalarioMinimo":
                this.xJIFFHistoricoSalarioMinimo.mGrabar();
                break;
            case "xjifCodigoAlterno":
                this.xJIFFCodigoAlternoRubro.mGrabar();
                break;
            case "xjif_unificar_usuarios":
                this.xJifUnificar_Usuario.mGrabar();
                break;
            case "xjifMaestroRubros":
                this.xJIFFRubrosN.mGuardar();
                break;
            case "xjtipoconaccion":
                this.xJIFTipoConsecuenciAcciones.mGrabar();
                break;
            case "Tipo Sexo":
                this.xJIFF_Generico3Text1Check.mGuardar();
                break;
            case "xjiftipoevento":
                this.xJIFTipoEventoSC.mGrabar();
                break;
            case "Riesgo seguridad Clínica":
            case "Tipo Clasificacion De Riesgo Adverso":
            case "Tipo Clasificacion De Cita":
            case "Tipo Categoría Seguridad Clínica":
            case "Clasificacion Tipo Complicacion de Riesgo":
            case "Tipo Clasificacion de Imagenes":
                this.xJIFF_Generico1Text1Check.mGuardar();
                break;
            case "Tipo De Causa Analisis":
                this.xJIF_Generico1Text1Spinner1Check.mGuardar();
                break;
            case "xjifsotiporesultado":
                this.xJIF_SO_TipoResultado.mGuardar();
                break;
            case "jiffTProcesoTRiesgo":
                this.xSC_TProcesoTRiesgo.mGrabar();
                break;
            case "jiffTRiesgoTEvento":
                this.xSC_TRiesgoTEvento.mGrabar();
                break;
            case "Vigencia de Pago Facturas":
                this.xJIF_Generico1Text2Spinner1Check.mGuardar();
                break;
            case "xjifformapago":
                this.xJIFFormaPago.mGuardar();
                break;
            case "xjiffpprubroencabezado":
                this.xJIFF_PP_RubrosEncabezado.mGrabar();
                break;
            case "xjifftipodocumentof":
                this.xJIFF_TipoDocumentoFirma.mGuardar();
                break;
            case "xjiftipotubo":
                this.xJIFTipoTubo.mGuardar();
                break;
            case "xJIFTipoDocumentoS":
                this.xJIFFTipoDocumentoSoporte.mGuardar();
                break;
            case "xjifrutasoporte":
                this.xJIFRutaSoporte.mGuardar();
                break;
            case "jifrhtipocargo":
                this.xJIFRHTipoCargo.mGuardar();
                break;
            case "xjifactividadeconomica":
                this.xJIFFActividadEconomica.mGrabar();
                break;
            case "xjifnivelactividade":
                this.xJIFFNivelActividadE.mGrabar();
                break;
            case "xjiftipocertificadoso":
                this.xJIFTipoCertificadoSO.mGrabar();
                break;
            case "xjiftipoconceptoso":
                this.xJIFConceptoSO.mGrabar();
                break;
            case "xJIFTipoDocumentosRH":
                this.xJIFGenerico3CheckBoxC3.mGrabar();
                break;
            case "xjiftipoclasificacionresiduos":
                this.xJIFTipoClasificacionResiduos.mGuardar();
                break;
            case "xjifregistroresiduos":
                this.xJIFRegistroDisposicionResiduos.mGuardar();
                break;
            case "jifdepartamento":
                this.xJIFDepartamento.mGuardar();
                break;
            case "xjifpais":
                this.xJIFPais.mGuardar();
                break;
            case "xjiftiporiesgocomplicacion":
                this.xJIFTipoRiesgoComplicacion.mGuardar();
                break;
            case "xjiftipoconcentimiento":
                this.xJIFTipoConcentimiento.mGuardar();
                break;
            case "Tipo de Producto":
                this.xJIFGenerico1Text2Check.mGuardar();
                break;
            case "xjiftiposeguimiento":
                this.xJIFTipoSeguimiento.mGuardar();
                break;
            case "xjiftipodocumentoclasificacion":
                this.xJIFTipoDocumentoClasificacion.mGrabar();
                break;
            case "xjifconceptoagrupacioncgr":
                this.xJIFConceptoAgrupacionCgr.mGuardar();
                break;
            case "xjiffichanotificacionsivigila":
                this.xJIFFichaNotificacionSivigila.mGuardar();
                break;
            case "xjifclasificacionnotas":
                this.xJIFClasificacionNotas.mGuardar();
                break;
            case "JIFGrupoExamenFisico":
                this.xJIFGrupoExamenFisico.mGrabar();
                break;
            case "JIFH_GrupoSistemas":
                this.xJIFH_GrupoSistemas.mGrabar();
                break;
            case "JIFH_TipoSistemas":
                this.xJIFH_TipoSistemas.mGrabar();
                break;
            case "xEntornoFamiliar":
                this.xEntornoFamiliar.mGrabar();
                break;
            case "xJIFRelacionesFamiliares":
                this.xFRelacionesFamiliares.mGrabar();
                break;
            case "JIFTipoDeInforme":
                this.xJIFTipoDeInforme.mGrabar();
                break;
            case "JIFPucTipoInforme":
                this.xJIFPucNifTipoInforme.mGuardar();
                break;
            case "JIFTipoHistoria":
                this.xJIFTipoHistoria.mGuardar();
                break;
            case "xJIFEntidadesContraloria":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFOrigenIngreso":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFTipoDestinacion":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFTipoRecursos":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFTipoSituacion":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFTipoVigencia":
                this.xJIFGenericoPresupuesto.mGuardar();
                break;
            case "xJIFFinalidadGasto":
                this.xJIFFinalidaGasto.mGrabar();
                break;
            case "xJIFRubroContraloria":
                this.xJIFRubrosContraloria.mGuardar();
                break;
            case "xjifconfiguracionitems":
                this.xJIFConfiguracionItems.mGuardar();
                break;
            case "JIFClasificacionLasa":
                this.jIFClasificacionLasa.grabar();
                break;
            case "xjifunidadmedida":
                this.xJIFUnidadMedida.mGuardar();
                break;
            case "tipoAntecedentePsiquiatrico":
                this.jiffTipoAntecedentesPsiquiatricos.guardar();
                break;
            case "jIFTipoAtencion":
                this.jIFTipoAtencion.mGrabar();
                break;
            case "JIFConsultorio":
                this.jIFConsultorio.mGrabar();
                break;
            case "jifperiodof":
                this.xjifperiodof.mGrabar();
                break;
            case "jifTipoAgente":
                this.xJIFFTipoAgente.mGuardar();
                break;
            case "jif_importar_cetificado":
                this.certificadoDigital.grabar();
                break;
            case "jifAuditorPorEmpresa":
                this.xJIFAuditorPorEmpresa.mGrabar();
                break;
            case "jifTipoComida":
                this.xJIFTipoComida.mGrabar();
                break;
            case "jifTipoDieta":
                this.xJIFTipoDieta.mGrabar();
                break;
            case "jif_ResolucionDian":
                this.xJIF_ResolucionDian.mGrabar();
                break;
            case "xjiftipopoliticas":
                this.xJIFTipoPolitica.mGrabar();
                break;
            case "xjifVigilancia":
                this.xJIFVigilanciaSeguimiento.mGrabar();
                break;
            case "jifturnosjpa":
                this.turnos.grabar();
                break;
            case "xjiftipodedocumentosoporte":
                this.xjiftipodedocumentosoporte.mGrabar();
                break;
            case "xjifhtipoayudadx":
                this.xjifhtipoayudadx.mGrabar();
                break;
            case "xjifhtipodocumentoshc":
                this.xjifhtipodocumentoshc.mGrabar();
                break;
            case "jifsuministrotecnologiasalud":
                this.jifSuministroTecnologiaSalud.grabar();
                break;
            case "jiforigenadmision":
                this.jIFOrigenAdmision.grabar();
                break;
            case "jiftipoparentesco":
                this.jIFTipoParentesco.grabar();
                break;
            case "jifsexo":
                this.jifsexo.Grabar();
                break;
            case "jifgenero":
                this.jifgenero.Grabar();
                break;
            case "jiftecnologiaSalud":
                this.jIFGTecnologiaSalud.grabar();
                break;
            case "jifprueba":
                this.jifprueba.save();
                break;
            case "MedioDePago":
                this.jIFMedioDePago.grabar();
                break;
            case "jifftiposistemavigilancia":
                this.jifftiposistemavigilancia.grabar();
                break;
            case "jifftipovigilanciasistema":
                this.jiffttipovigilanciasistemas.grabar();
                break;
            case "Rubros CPC":
                this.jIFGenericoRubros.mGrabar();
                break;
            case "Rubros Fuente Financiacion":
                this.jIFGenericoRubros.mGrabar();
                break;
            case "Rubros Centro de Costos":
                this.jIFGenericoRubros.mGrabar();
                break;
            case "jifmodalidadatencion":
                this.jifmodalidadatencion.mSave();
                break;
            case "jiftipomedicamento":
                this.jiftipomedicamento.mSave();
                break;
            case "jifcodigoservicio":
                this.jifcodigoservicio.mSave();
                break;
            case "Clasificación AIEPI":
                this.jifgaiepi.save();
                break;
            case "Respuestas AIEPI":
                this.jifgaiepi.save();
                break;
            case "Preguntas AIEPI Oncologíco":
                this.jifgaiepi.save();
                break;
            case "jifserviciosrips":
                this.jifserviciosrips.grabar();
                break;
            case "jiftipodestino":
                this.jiftipodestino.grabar();
                break;
            case "Unidad Minima Dispensacion":
                this.xjifgenerico2.mGrabar();
                break;
            case "Procedimiento Tipo Finalidad":
                this.xJIFGenericoDosCombox1Check.mGrabar();
                break;
            case "Menu Prueba":
                this.jIFPruebaBuena.grabar();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifconfempresa1":
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    this.xjifempresaBienestar.mNuevo();
                    break;
                } else {
                    this.xjifempresa.mNuevo();
                    break;
                }
                break;
            case "jifturnosjpa":
                this.turnos.nuevo();
                break;
            case "Menu Prueba":
                this.jIFPruebaBuena.nuevo();
                break;
            case "xjif_Notas_clinicas":
                this.xjif_Notas_clinicas.mNuevo();
                break;
            case "xjif_unificar_usuarios":
                this.xJifUnificar_Usuario.mNuevo();
                break;
            case "jifconfsalacirugias":
                this.xjifconfsalacirugia.mNuevo();
                break;
            case "xjifconceptonomina":
                this.xjifoconceptonomina.mNuevo();
                break;
            case "xjifdetallepreguntas":
                this.xjifgenerico7.mNuevo();
                break;
            case "xjifconceptoestudio":
                this.xjifgenerico7.mNuevo();
                break;
            case "xjiftipoejercicio":
                this.xjifgenerico7.mNuevo();
                break;
            case "jifTipo_Pregunta_Respuesta":
                this.xjifTipo_Pregunta_Respuesta.mNuevo();
                break;
            case "xjifaeropuertos":
                this.xjifgenerico6.mNuevo();
                break;
            case "xjifdoccontable":
                this.xjifdoccontable.mNuevo();
                break;
            case "xjifconceptopagoglosa":
                this.xjifconceptopagoglosa.mNuevo();
                break;
            case "xjiffichatecnicaindicador":
                this.xjiffichatecnicaindicador.mNuevo();
                break;
            case "xjifconceptodetalle":
                this.xjifconceptoanticipo.mNuevo();
                break;
            case "jifsubgrupofacempresa":
                this.xjifsubgrupoxempersa.mNuevo();
                break;
            case "xjifglosario":
                this.xjifsgcglosario.mNuevo();
                break;
            case "xjiftipoexamenfisico":
            case "xjifencabezadopreguntaso":
            case "xjifencabezadorecomendacion":
            case "Vacunas x Edad":
                this.xjifgenerico5.mNuevo();
                break;
            case "xjifcontenidohc":
                this.xjifgenerico4.mNuevo();
                break;
            case "xjifdetallecontenidohc":
                this.xjifdetallecontenido.mNuevo();
                break;
            case "jifunidadfuncional":
                this.xjifunidadfuncional.mNuevo();
                break;
            case "jiftipoprocesossgc":
                this.xjiftipoprocesosgc.mNuevo();
                break;
            case "jifestratoempresa":
                this.xjifestratoempresa.mNuevo();
                break;
            case "jifempresagrupo":
                this.xjifgrupoempresa.mNuevo();
                break;
            case "jifempresaservicios":
                this.xjifservicioempresa.mNuevo();
                break;
            case "jifempresaserviciosN":
                this.xJIFFEmpresaServiciosN.mNuevo();
                break;
            case "jifempresaprocedimiento":
                this.xjifprocedimientoempresa.mNuevo();
                break;
            case "jifcontratoempresa":
                this.xjifcontratoempresa.mNuevo();
                break;
            case "jifestrato":
                this.xjifestrato.mNuevo();
                break;
            case "jifetiporespuesta":
                this.xJIFETipoRespuesta.mNuevo();
                break;
            case "xjifepreguntaxarea":
                this.xJIFEPreguntaxArea.mNuevo();
                break;
            case "xjifparentesco":
                this.xjifgenericoch.mNuevo();
                break;
            case "jifgrupofactura":
            case "xjifareas":
                this.xjifgenericoch.mNuevo();
                break;
            case "jifsubgrupofac":
                this.xjidsubgrupofac.mNuevo();
                break;
            case "jiftipoprocedimiento":
                this.xjiftipoprocedimiento.mNuevo();
                break;
            case "jiftiposervicio":
                this.xjifgenericoch.mNuevo();
                break;
            case "xjiftipoalerta":
                this.xjifgenericoch.mNuevo();
                break;
            case "jifservicioxprocedimiento":
            case "jifformatoconceptodian":
            case "jifsegmento_encabezado":
                this.xjifgenericocombox2.mNuevo();
                break;
            case "jifprocedimiento":
                this.xjifprocedimiento.mNuevo();
                break;
            case "jifprocedimientoccosto":
            case "xjifsuministroxarealab":
            case "jifgenericocombox1":
            case "jifsuministroxTformula":
                this.xjifgenericocombox1.mNuevo();
                break;
            case "jiftarifaprocedimiento":
                this.xjiftarifaprocedimiento.mNuevo();
                break;
            case "jifgenerico1chbox":
                this.xjifgenerico1chbox.mNuevo();
                break;
            case "Manual de Tarifas":
                this.xJIFFManual.mNuevo();
                break;
            case "jifsuministro":
                this.xjifsuministro.mNuevo();
                break;
            case "jiftarifasuministro":
                this.xjiftarifasuministro.mNuevo();
                break;
            case "jifsuministrobodega":
                this.xjifsuministrobodega.mNuevo();
                break;
            case "jifprincipioactivo":
                this.xjifsuministro.xjifprincipioactivo.mNuevo();
                break;
            case "jifpresentacionfarma":
                this.xjifsuministro.xjifpresentaconfarmaceutica.mNuevo();
                break;
            case "jifpresentacioncomer":
                this.xjifsuministro.xjifgenerico.mNuevo();
                break;
            case "jifconcentracion":
                this.xjifsuministro.xjifconcentracion.nuevo();
                break;
            case "jiflaboratorio1":
                this.xjifsuministro.xjifgenerico.mNuevo();
                break;
            case "jifrelacionlaboral":
                this.xjifrelacionlaboral.mNuevo();
                break;
            case "jifbodega":
                this.xjifbodegas.mNuevo();
                break;
            case "jifmovimientosbodega":
                this.xjifmovimientobodega.mNuevo();
                break;
            case "jifprofesional":
                this.xjifprofesional.mNuevo();
                break;
            case "jifespecialidad":
                this.xjifespecialidad.mNuevo();
                break;
            case "xjifocupacion":
                this.xjifgenerico2.mNuevo();
                break;
            case "jifmunicipio":
                this.xjifgenerico3.mNuevo();
                break;
            case "jifetapaproceso":
                this.xjifgenerico2.mNuevo();
                break;
            case "jifbarrio":
                this.xjifbarrio.mNuevo();
                break;
            case "jifsupervisor":
                this.xjifsupervisor.mNuevo();
                break;
            case "jifturnoscitas":
                this.xjifturnoscitas.mNuevo();
                break;
            case "jifclaseconsultorio":
            case "xjifunidadnegocio":
            case "jifconsultorio":
            case "jifbanco":
            case "xjiftipodetalleexamenf":
            case "xjifmotivoanulacion":
            case "xjifubicacion":
            case "xjiftipomedida":
            case "xjifelementospp":
            case "xjifrecomendaciones":
                this.xjifgenerico1txt1box.mNuevo();
                break;
            case "jifclasecita":
                this.xjifclasecita.mNuevo();
                break;
            case "jifalertaxusuario1":
                this.xjifalertausuario.mNuevo();
                break;
            case "jifareafuncional":
                this.xjifunidadf.mNuevo();
                break;
            case "jifgenericoc":
                this.xjifgenicoc.mNuevo();
                break;
            case "jifconceptounidadf":
            case "jifdetallecontenido1":
            case "xjifconceptoxcaja":
            case "xjifcargosunidadf":
            case "jifparametrodetalle":
            case "xjifactividadsolictud":
            case "jifsucursal":
            case "xjifcontenidoxdetallehc":
            case "jiftiporegimen":
            case "jifunidadfempresa":
            case "xjifdetalleincumplimiento":
            case "xjifnovconceptonomina":
                this.xjifgenericocomboc.mNuevo();
                break;
            case "jifdetalleconceptounidadf":
                this.xjifdtalleconcepto.mNuevo();
                break;
            case "jiftipoimpuesto":
                this.xjifimpuestos.mNuevo();
                break;
            case "jifpresupuestopuc":
                this.xjifpresupuestopuc.mNuevo();
                break;
            case "jifimpuestoempresa":
                this.xjifimpuestoempresa.mNuevo();
                break;
            case "jifdatosbancoempresa":
                this.xjifcuentaempresa.mNuevo();
                break;
            case "jifcuentapucxempresa":
                this.xjifcuentasxpagarempresa.mNuevo();
                break;
            case "jifcontratoempresac":
                this.xjifcontratoempresac.mNuevo();
                break;
            case "jiftipocaja":
                this.xjiftipocaja.mNuevo();
                break;
            case "jiftipoconceptocaja":
                this.xjifconceptocaja.mNuevo();
                break;
            case "jifauxiliarxconcepto":
            case "xjiftipoactividadproceso":
                this.xjifgenericodoscombox.mNuevo();
                break;
            case "jifconceptocc":
                this.xjifconceptoccobro.mNuevo();
                break;
            case "jifconceptoreembolso":
                this.xjifconceptoreembolso.mNuevo();
                break;
            case "jifusuariocargo":
                this.xjifusuarioxcargo.mNuevo();
                break;
            case "jifdocumentousuariof":
                this.xjifdocfirma.mNuevo();
                break;
            case "jifinteracionmed":
                this.xjifinteracionmed.mNuevo();
                break;
            case "jiftarifamp":
                this.xjiftarifamp.mNuevo();
                break;
            case "jifregistronovedades":
                this.xjifregistronov.mNuevo();
                break;
            case "jifformatodian":
            case "jifconceptodian":
                this.xjifgenerico2.mNuevo();
                break;
            case "jifpregunta":
                this.xjifpreguntaencuesta.mNuevo();
                break;
            case "jifarmadoencuesta":
                this.xjifarmadoencuesta.mNuevo();
                break;
            case "jiftcaja":
                this.xjiftcaja.mNuevo();
                break;
            case "xjifprocedimientoxpaquete":
                this.xjifprocpaquetes.mNuevo();
                break;
            case "jifusuariosistemas":
                this.xJIFUsuarioSistema.mNuevo();
                break;
            case "jifvacunaesquema":
                this.xjifvacunaesquema.mNuevo();
                break;
            case "jifreportepatologia":
                this.xjifreportep.mNuevo();
                break;
            case "Tipo de Formula":
            case "Tipo de Acción":
            case "Tipo de Doc Ayudas DX":
            case "Clasif Concepto Nomina":
                this.xjifgenericoch2.mNuevo();
                break;
            case "jifhorariomedicion":
                this.xjifhorariom.mNuevo();
                break;
            case "Tipo Medición x Bodega":
            case "Tipo Horario x Bodega":
                this.xjiftipomedbod.mNuevo();
                break;
            case "Demanda Inducida":
                this.xiddemandaind.mNuevo();
                break;
            case "Vacunas":
                this.xjif1text2comb1check.mNuevo();
                break;
            case "jifmanualesmodulos":
                this.xjifmanuales.mNuevo();
                break;
            case "xjifdetalleexafisico":
            case "xjifpartesecografia":
            case "xjifpreguntasxSubcategorias":
                this.xjifexamenfisico.mNuevo();
                break;
            case "xjifantencedentespatologicos":
                this.xjifGenerico1Text1Combo2CheckBox.mNuevo();
                break;
            case "Tipo de Concepto":
                this.xjifgenericoch2.mNuevo();
                break;
            case "Tipo Restricción":
                this.xjifgenericoch2.mNuevo();
                break;
            case "Categoria":
                this.xjifgenericoch2.mNuevo();
                break;
            case "SEG":
                this.xjifGenerico1CheckBox1TextArea.mNuevo();
                break;
            case "jifresultadovisiometria":
                this.xjifJIFResultadoVisiometria.mNuevo();
                break;
            case "jifSoRecomendaciones":
                this.xjifRecomendaciones.mNuevo();
                break;
            case "jifSoTipoRespuesta":
                this.xjifTipoRespuesta.mNuevo();
                break;
            case "jifSoTipoPregunta":
                this.xjifTipoPreguntas.mNuevo();
                break;
            case "xjifGenerico1Text1Combo2SpinerEstado":
                this.xjifGenerico1Text1Combo2SpinerEstado.mNuevo();
                break;
            case "jifpreguntaxdominio":
                this.xJIFPreguntaDominio.mNuevo();
                break;
            case "xJIFGenerico2Text2CheckBox":
                this.xJIFGenerico2Text2CheckBox.mNuevo();
                break;
            case "xjifEscalaAbreviada":
                this.xJIFEscalaAbreviadaP.mNuevo();
                break;
            case "xjifpatologiacie10":
                this.xjifpatologiacie10.mNuevo();
                break;
            case "Tipo de Programa":
                this.xJIFTipoPrograma.mNuevo();
                break;
            case "xjifConceptoCaja":
                this.xJIFConceptoCaja.mNuevo();
                break;
            case "xjiffTipoEmpresa":
                this.xJIFFTipoEmpresa.mNuevo();
                break;
            case "xjiffsalacirugia":
                this.xjifgenerico1txt1box.mNuevo();
                break;
            case "Profesional Sala Cirugia":
                this.xJIFFProfSalaCirugia.mNuevo();
                break;
            case "jifdatosempresa":
                this.xjifdatosempresa.mNuevo();
                break;
            case "GrupoVr":
                this.xJIFGrupoUvr.mNuevo();
                break;
            case "ProcedimientoTipoQx":
                this.xJIFGenerico3combo2text1check.mNuevo();
                break;
            case "Excepción":
                this.xJIFFExcepcion.mNuevo();
                break;
            case "Centro de Costo":
                this.xJIFCentroCosto.mNuevo();
                break;
            case "Camas":
                this.xJIFFCamas.mNuevo();
                break;
            case "Horario de Farmacia":
                this.xJIFHorarioFarmacia.mNuevo();
                break;
            case "JIFUnidadCama":
                this.jIFUnidadCama.mNuevo();
                break;
            case "Grupo Sistema":
                this.xjifgenericoch2.mNuevo();
                break;
            case "Tipo Alerta":
                this.xjifgenericoch2.mNuevo();
                break;
            case "Tipo de Cita Prioritaria":
                this.xjifgenericoch2.mNuevo();
                break;
            case "jiftipoperiodoscartera":
                this.xJIFTipoPeriodosCartera.mNuevo();
                break;
            case "jIFtipoatencion":
                this.jIFTipoAtencion.mNuevo();
                break;
            case "procedimientoxprioridad":
            case "RubroxTipoDoc":
                this.xJIFGenericoDosCombox1Check.mNuevo();
                break;
            case "Tipo Anestesia":
                this.xjifgenericoch2.mNuevo();
                break;
            case "Tipo Sistema":
                this.xJIFGenerico1txt1combo1check1spiner.mNuevo();
                break;
            case "Tipo Destido Salida":
                this.xjifgenerico2.mNuevo();
                break;
            case "Tipo Concepto Agrupado":
                this.xjifgenerico2.mNuevo();
                break;
            case "Causa Externa":
                this.xJIFFGenerico2TextBox1Spiner1CheckBox.mNuevo();
                break;
            case "Estadio Glomerural":
                this.xJIFFGenerico3TextBox1Check.mNuevo();
                break;
            case "Periocidad":
                this.xjifgenerico4.mNuevo();
                break;
            case "Tipo Prioridad":
                this.xJIFFGenerico1Text1Spiner1Check.mNuevo();
                break;
            case "xjifTipoDestino":
                this.xjifTipoDestino.nuevo();
                break;
            case "Nombre Encuesta":
                this.xJIFFGenerico1Text1Spiner1Check.mNuevo();
                break;
            case "Periodos de Nómina":
                this.xJIFFPeriodosNomina.mNuevo();
                break;
            case "Tipo Edad":
                this.xjifgenerico2.mNuevo();
                break;
            case "Tipo Ambito":
                this.xjifgenerico2.mNuevo();
                break;
            case "Tipo Población":
                this.xJIFFGenerico3Text1Check.mNuevo();
                break;
            case "Periodo":
                this.xJIFFPPeriodo.mNuevo();
                break;
            case "Tipo Documento Presupuesto":
                this.xJIFFPPTipoDocumento.mNuevo();
                break;
            case "Documento Tercero Firma":
                this.xJIFFTipoDocTercero.mNuevo();
                break;
            case "xjifRubrosPTO":
                this.xJIFRubros.mNuevo();
                break;
            case "PPResolucion":
                this.xJIFGenerico2CheckBoxC.mNuevo();
                break;
            case "Tipo Parentesco":
                this.xJIFGenerico2Text2CheckBox.mNuevo();
                break;
            case "xjifCodigoAlternos":
                this.xJIFFRubroResolucion.mNuevo();
                break;
            case "xJIFFHistoricoSalarioMinimo":
                this.xJIFFHistoricoSalarioMinimo.mNuevo();
                break;
            case "xjifCodigoAlterno":
                this.xJIFFCodigoAlternoRubro.mNuevo();
                break;
            case "xjifMaestroRubros":
                this.xJIFFRubrosN.mNuevo();
                break;
            case "xjtipoconaccion":
                this.xJIFTipoConsecuenciAcciones.mNuevo();
                break;
            case "Tipo Sexo":
                this.xJIFF_Generico3Text1Check.mNuevo();
                break;
            case "xjiftipoevento":
                this.xJIFTipoEventoSC.mNuevo();
                break;
            case "Riesgo seguridad Clínica":
            case "Tipo Clasificacion De Riesgo Adverso":
            case "Tipo Clasificacion De Cita":
            case "Tipo Categoría Seguridad Clínica":
            case "Clasificacion Tipo Complicacion de Riesgo":
            case "Tipo Clasificacion de Imagenes":
                this.xJIFF_Generico1Text1Check.mNuevo();
                break;
            case "Tipo De Causa Analisis":
                this.xJIF_Generico1Text1Spinner1Check.mNuevo();
                break;
            case "xjifsotiporesultado":
                this.xJIF_SO_TipoResultado.mNuevo();
                break;
            case "jiffTProcesoTRiesgo":
                this.xSC_TProcesoTRiesgo.mNuevo();
                break;
            case "jiffTRiesgoTEvento":
                this.xSC_TRiesgoTEvento.mNuevo();
                break;
            case "Vigencia de Pago Facturas":
                this.xJIF_Generico1Text2Spinner1Check.mNuevo();
                break;
            case "xjifformapago":
                this.xJIFFormaPago.mNuevo();
                break;
            case "xjiffpprubroencabezado":
                this.xJIFF_PP_RubrosEncabezado.mNuevo();
                break;
            case "Informe de Procedimientos Facturados":
                this.xJIFInformesFacturadosController.mNuevo();
                break;
            case "Informe de Insumos Facturados":
                this.xJIFInformesFacturadosController.mNuevo();
                break;
            case "xjifftipodocumentof":
                this.xJIFF_TipoDocumentoFirma.mNuevo();
                break;
            case "xjiftipotubo":
                this.xJIFTipoTubo.mNuevo();
                break;
            case "xJIFTipoDocumentoS":
                this.xJIFFTipoDocumentoSoporte.mNuevo();
                break;
            case "xjifrutasoporte":
                this.xJIFRutaSoporte.mNuevo();
                break;
            case "jifrhtipocargo":
                this.xJIFRHTipoCargo.mNuevo();
                break;
            case "xjifactividadeconomica":
                this.xJIFFActividadEconomica.mNuevo();
                break;
            case "xjifnivelactividade":
                this.xJIFFNivelActividadE.mNuevo();
                break;
            case "xjiftipocertificadoso":
                this.xJIFTipoCertificadoSO.mNuevo();
                break;
            case "xjiftipoconceptoso":
                this.xJIFConceptoSO.mNuevo();
                break;
            case "xJIFTipoDocumentosRH":
                this.xJIFGenerico3CheckBoxC3.mNuevo();
                break;
            case "xjiftipoclasificacionresiduos":
                this.xJIFTipoClasificacionResiduos.mNuevo();
                break;
            case "xjifregistroresiduos":
                this.xJIFRegistroDisposicionResiduos.mNuevo();
                break;
            case "jifdepartamento":
                this.xJIFDepartamento.mNuevo();
                break;
            case "xjifpais":
                this.xJIFPais.mNuevo();
                break;
            case "xjiftiporiesgocomplicacion":
                this.xJIFTipoRiesgoComplicacion.mNuevo();
                break;
            case "xjiftipoconcentimiento":
                this.xJIFTipoConcentimiento.mNuevo();
                break;
            case "Tipo de Producto":
                this.xJIFGenerico1Text2Check.mNuevo();
                break;
            case "xjiftiposeguimiento":
                this.xJIFTipoSeguimiento.mNuevo();
                break;
            case "xjiftipodocumentoclasificacion":
                this.xJIFTipoDocumentoClasificacion.mNuevo();
                break;
            case "xjifconceptoagrupacioncgr":
                this.xJIFConceptoAgrupacionCgr.mNuevo();
                break;
            case "xjiffichanotificacionsivigila":
                this.xJIFFichaNotificacionSivigila.mNuevo();
                break;
            case "xjifclasificacionnotas":
                this.xJIFClasificacionNotas.mNuevo();
                break;
            case "JIFGrupoExamenFisico":
                this.xJIFGrupoExamenFisico.mNuevo();
                break;
            case "JIFH_GrupoSistemas":
                this.xJIFH_GrupoSistemas.mNuevo();
                break;
            case "xEntornoFamiliar":
                this.xEntornoFamiliar.mNuevo();
                break;
            case "xJIFRelacionesFamiliares":
                this.xFRelacionesFamiliares.mNuevo();
                break;
            case "JIFTipoDeInforme":
                this.xJIFTipoDeInforme.mNuevo();
                break;
            case "JIFPucTipoInforme":
                this.xJIFPucNifTipoInforme.mNuevo();
                break;
            case "JIFTipoHistoria":
                this.xJIFTipoHistoria.mNuevo();
                break;
            case "jifprueba":
                this.jifprueba.nuevo();
                break;
            case "xJIFEntidadesContraloria":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFOrigenIngreso":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFTipoDestinacion":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFTipoRecursos":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFTipoSituacion":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFTipoVigencia":
                this.xJIFGenericoPresupuesto.mNuevo();
                break;
            case "xJIFFinalidadGasto":
                this.xJIFFinalidaGasto.mNuevo();
                break;
            case "xJIFRubroContraloria":
                this.xJIFRubrosContraloria.mNuevo();
                break;
            case "xjifconfiguracionitems":
                this.xJIFConfiguracionItems.mNuevo();
                break;
            case "JIFClasificacionLasa":
                this.jIFClasificacionLasa.limpiarCampos();
                break;
            case "xjifunidadmedida":
                this.xJIFUnidadMedida.mNuevo();
                break;
            case "tipoAntecedentePsiquiatrico":
                this.jiffTipoAntecedentesPsiquiatricos.nuevo();
                break;
            case "jIFTipoAtencion":
                this.jIFTipoAtencion.mNuevo();
                break;
            case "JIFConsultorio":
                this.jIFConsultorio.mNuevo();
                break;
            case "jifperiodof":
                this.xjifperiodof.mNuevo();
                break;
            case "jifTipoAgente":
                this.xJIFFTipoAgente.mNuevo();
                break;
            case "jif_importar_cetificado":
                this.certificadoDigital.nuevo();
                break;
            case "jifAuditorPorEmpresa":
                this.xJIFAuditorPorEmpresa.mNuevo();
                break;
            case "jifTipoComida":
                this.xJIFTipoComida.mNuevo();
                break;
            case "jifTipoDieta":
                this.xJIFTipoDieta.mNuevo();
                break;
            case "jif_ResolucionDian":
                this.xJIF_ResolucionDian.mNuevo();
                break;
            case "xjiftipopoliticas":
                this.xJIFTipoPolitica.mNuevo();
                break;
            case "xjifVigilancia":
                this.xJIFVigilanciaSeguimiento.mNuevo();
                break;
            case "xjiftipodedocumentosoporte":
                this.xjiftipodedocumentosoporte.mNuevo();
                break;
            case "xjifhtipoayudadx":
                this.xjifhtipoayudadx.mNuevo();
                break;
            case "xjifhtipodocumentoshc":
                this.xjifhtipodocumentoshc.mNuevo();
                break;
            case "jifsexo":
                this.jifsexo.Nuevo();
                break;
            case "jifgenero":
                this.jifgenero.mNuevo();
                break;
            case "jifftipovigilanciasistema":
                this.jiffttipovigilanciasistemas.nuevo();
                break;
            case "jifftiposistemavigilancia":
                this.jiffttipovigilanciasistemas.nuevo();
                break;
            case "jifmodalidadatencion":
                this.jifmodalidadatencion.mNew();
                break;
            case "jiftipomedicamento":
                this.jiftipomedicamento.mNew();
                break;
            case "jifcodigoservicio":
                this.jifcodigoservicio.mNew();
                break;
            case "Clasificación AIEPI":
                this.jifgaiepi.newM();
                break;
            case "Respuestas AIEPI":
                this.jifgaiepi.newM();
                break;
            case "PAiepiOncologicoPreguntas":
                this.jifgaiepi.newM();
                break;
            case "jifserviciosrips":
                this.jifserviciosrips.nuevo();
                break;
            case "jiftipodestino":
                this.jiftipodestino.nuevo();
                break;
            case "jifgenerico2":
                this.xjifgenerico2.mNuevo();
                break;
            case "Procedimiento Servicio Rips":
                this.xJIFGenericoDosCombox1Check.mNuevo();
                break;
            case "Procedimiento Tipo Finalidad":
                this.xJIFGenericoDosCombox1Check.mNuevo();
                break;
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("jifconfempresa1")) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                this.xjifempresaBienestar.mImprimir();
                return;
            } else {
                this.xjifempresa.mImprimir();
                return;
            }
        }
        if (frm.equals("jifsuministro")) {
            this.xjifsuministro.imprimir();
        }
    }
}
