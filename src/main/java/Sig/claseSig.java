package Sig;

import Acceso.Principal;
import AutorizacionMP.JIFConsultasUsuarioEnv;
import ImagenesDx.JIFInformesPlacas;
import Informes.JIFAuditoriaHC;
import Inventarios.JIFConsultasInfMed;
import com.genoma.plus.controller.sig.CensoHospitalizacion;
import com.genoma.plus.controller.sig.JIFComsultarResolucion_4725;
import com.genoma.plus.controller.sig.JIFConsulta_Resolucion1604_2013;
import com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos;
import com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento;
import com.genoma.plus.controller.sig.JIFDiagnosticoSalud;
import com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463;
import com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion;
import com.genoma.plus.controller.sig.JIFInformacionConvenios;
import com.genoma.plus.controller.sig.JIFInformeAnexos;
import com.genoma.plus.controller.sig.JIFInformeCitasAtendidas;
import com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad;
import com.genoma.plus.controller.sig.JIFInformeInterconsultas;
import com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA;
import com.genoma.plus.controller.sig.JIFInformeMorbilidadIra;
import com.genoma.plus.controller.sig.JIFInformesGeneralesPyP;
import com.genoma.plus.controller.sig.JIFInformesGenericoSO;
import com.genoma.plus.controller.sig.JIFMedicamentosxFormula;
import com.genoma.plus.controller.sig.JIFReporteExamenOcupacional;
import com.genoma.plus.controller.sig.JIFReportesProduccionPorSede;
import com.genoma.plus.controller.sig.JIF_GeneracionRipsMinisterio;

/* JADX INFO: loaded from: GenomaP.jar:Sig/claseSig.class */
public class claseSig {
    private JIFInformesPyP xjifinforme;
    private JIFConsultarInfCove xjifconsultarcove;
    private JIFConsultarInf3Tabla xjifconsultarinf2tablas;
    private JIFInformesPlacas xjifinformeplacas;
    private JIFConsultarInf1CombTabla1 xjifconsultar1comtabla;
    private JIFConsultarInf1Comb2Tabla xjifconsulta1tablar;
    private JIFConsultarInforSo xjifconsultarinfso;
    private JIFAuditoriaHC xjifauditoriahc;
    private JIFInformesSupersalud xjifinformesupersalud;
    private JIFConsultasInfMed xjifformulacionmed;
    private JIFVigenciaPoliza xjifpoliza;
    private JIFConsultasUsuarioEnv xjifuser_envio;
    private JIFFConsultarInformacionGenerico xJIFFConsultarInformacionGenerico;
    private JIFFConsultarInfoRes2463 xJIFFConsultarInfoRes2463;
    private JIFComsultarResolucion_4725 xJIFComsultarResolucion_4725;
    private JIFGenericoxFecha xJIFGenericoxFecha;
    private CensoHospitalizacion xCensoHospitalizacion;
    private JIFInformacionConvenios xJIFInformacionConvenios;
    private JIFInfoAtencionPrioritariaxClasificacion xJIFInfoAtencionPrioritariaxClasificacion;
    private JIFMedicamentosxFormula xJIFMedicamentosxFormula;
    private JIFDiagnosticoSalud xJIFDiagnosticoSalud;
    private JIFConsulta_Resolucion1604_2013 xJIFInforme_Resolucion1604;
    private JIFInformeMorbilidadIra xJIFInformeMorbilidadIra;
    private JIFConsultarInformacionCronicos xJIFConsultarInformacionCronico;
    private JIFConsultarPeriodoDuracionTratamiento xJIFConsultarPeriodoDuracionTratamiento;
    private JIFReporteExamenOcupacional xJIFReporteExamenOcupacional;
    private JIFInformesGenericoSO xJIFInformesGenericoSO;
    private JIF_GeneracionRipsMinisterio generacionRipsMiniterio;
    private JIFInformesGeneralesPyP xJIFInformesGeneralesPyP;
    private JIFInformeAnexos xJIFInformeAnexos;
    private JIFInformeCitasAtendidas xJIFInformeCitasAtendidas;
    private JIFInformeInterconsultas xJIFInformeInterconsultas;
    private JIFReportesProduccionPorSede xJIFReportesProduccionPorSede;
    private JIFInformeConsolidadoPypFinalidad informeConsolidadoPypFinalidad;
    private JIFInformeMorbilidadEDA xJIFInformeMorbilidadEDA;

    public void buscar(String frm) {
        if (frm.equals("jifinformespyp")) {
            this.xjifinforme.mBuscar();
            return;
        }
        if (frm.equals("jifinformacioncove")) {
            this.xjifconsultarcove.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarperiododuraciontratamiento")) {
            this.xJIFConsultarPeriodoDuracionTratamiento.mBuscar();
            return;
        }
        if (frm.equals("xjifconsultarinformacioncronicos")) {
            this.xJIFConsultarInformacionCronico.mBuscar();
            return;
        }
        if (frm.equals("xjifplacasdanadas")) {
            this.xjifconsultarinf2tablas.mBuscar();
            return;
        }
        if (frm.equals("jifinformeplacas")) {
            this.xjifinformeplacas.mBuscar();
            return;
        }
        if (frm.equals("xjiffasignacioncitas")) {
            this.xjifconsultar1comtabla.mBuscar();
            return;
        }
        if (frm.equals("xjifinformacionxespecialidad")) {
            this.xjifconsulta1tablar.mBuscar();
            return;
        }
        if (frm.equals("xjifestudiosrealizados")) {
            this.xjifinformeplacas.mBuscar();
            return;
        }
        if (frm.equals("xjifremisionesxprofesional")) {
            this.xjifconsulta1tablar.mBuscar();
            return;
        }
        if (frm.equals("xjifinformacionso")) {
            this.xjifconsultarinfso.mBuscar();
            return;
        }
        if (frm.equals("xjifauditoriahcmed") || frm.equals("xjifauditoriahcenfer")) {
            this.xjifauditoriahc.buscar();
            return;
        }
        if (frm.equals("xjifinformesupersalud")) {
            this.xjifinformesupersalud.mBuscar();
            return;
        }
        if (frm.equals("xjif_informes_resoluciones")) {
            this.xjifinformesupersalud.mBuscar();
            return;
        }
        if (frm.equals("ConsultarPrograma") || frm.equals("ConsultarEspecialidad") || frm.equals("ConsultarRadiologia") || frm.equals("ConsultarProcedimiento") || frm.equals("ConsultarProcedimientoDet") || frm.equals("ConsolidadoAsignacionCitas") || frm.equals("CirugiasNoProgramadas") || frm.equals("ConsolidadoPorProfesional") || frm.equals("CirugiasPorEPS") || frm.equals("") || frm.equals("RiesgoObstetrico") || frm.equals("RiesgoCardiovascular") || frm.equals("ConsolidadoAtencionFecha") || frm.equals("ProcedimientosEmpresa") || frm.equals("CirugiasUsuariosEPSyProfesional") || frm.equals("DetalleEntradaPorBodega") || frm.equals("ConsultarAtenciones") || frm.equals("CitasPorEmpresa") || frm.equals("ConsolidOrdenConvenioProf") || frm.equals("ConsolidadOrdenesMedico") || frm.equals("EstadisProcedLab") || frm.equals("ConsolProcedLabDet") || frm.equals("pacienteFacAtencionLab") || frm.equals("pacienteFacAtencionRad") || frm.equals("InformeControlPrenatar") || frm.equals("ConsultaSaludOcupacionalDX") || frm.equals("ConsultarOrdenesProcedimiento") || frm.equals("ConsultaInforLipidosCarbo") || frm.equals("totalDosiSuministradas") || frm.equals("totalDosiSuministroEntidad") || frm.equals("vacunacionAplicxUsuario") || frm.equals("formuSubgruFarmacologico") || frm.equals("empresaConveFarmacologico") || frm.equals("produccionPorSedeYProfesional") || frm.equals("consultaPrenatal") || frm.equals("lecturaPorEmpresaYValor") || frm.equals("ProcedimientosOrdenadosUsuario")) {
            this.xJIFFConsultarInformacionGenerico.mBuscar();
            return;
        }
        if (frm.equals("informeRes2463")) {
            this.xJIFFConsultarInfoRes2463.mBuscar();
            return;
        }
        if (frm.equals("Informe Resolucion 4725")) {
            this.xJIFComsultarResolucion_4725.mBuscar();
            return;
        }
        if (frm.equals("Censo Hospitalización")) {
            this.xCensoHospitalizacion.mBuscar();
            return;
        }
        if (frm.equals("xjifinfoantencionprioritariaxclasificacion")) {
            this.xJIFInfoAtencionPrioritariaxClasificacion.mBuscar();
            return;
        }
        if (frm.equals("xjifdiagnosticosalud")) {
            this.xJIFDiagnosticoSalud.mBuscar();
            return;
        }
        if (frm.equals("xJif_informe_resolucion1604")) {
            this.xJIFInforme_Resolucion1604.mBuscar();
            return;
        }
        if (frm.equals("xjifinformemorbilidadira")) {
            this.xJIFInformeMorbilidadIra.mBuscar();
            return;
        }
        if (frm.equals("xjifinformemorbilidadeda")) {
            this.xJIFInformeMorbilidadEDA.mBuscar();
            return;
        }
        if (frm.equals("xJIFReporteExamenOcupacional")) {
            this.xJIFReporteExamenOcupacional.mBuscar();
            return;
        }
        if (frm.equals("xjifinformegenericoso1")) {
            this.xJIFInformesGenericoSO.mBuscar();
            return;
        }
        if (frm.equals("xjif_generacion_rips_ministerio")) {
            this.generacionRipsMiniterio.buscar();
            return;
        }
        if (frm.equals("InformeGeneralPyP")) {
            this.xJIFInformesGeneralesPyP.buscar();
            return;
        }
        if (frm.equals("xjifinformeanexos")) {
            this.xJIFInformeAnexos.mBuscar();
            return;
        }
        if (frm.equals("xjifinformedecitasatendidas")) {
            this.xJIFInformeCitasAtendidas.mBuscar();
            return;
        }
        if (frm.equals("xjifinformeinterconsultas")) {
            this.xJIFInformeInterconsultas.mBuscar();
        } else if (frm.equals("jIFReportesProduccionPorSede")) {
            this.xJIFReportesProduccionPorSede.buscar();
        } else if (frm.equals("jifInformeConsoliadoPorFinalidad")) {
            this.informeConsolidadoPypFinalidad.buscar();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("xjifinformemorbilidadira")) {
            this.xJIFInformeMorbilidadIra.mImprimir();
        } else if (frm.equals("xjifinformemorbilidadeda")) {
            this.xJIFInformeMorbilidadEDA.mImprimir();
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Usuario x Programa") || frm.equals("Usuario x Actividad") || frm.equals("Hospitalizaciones-Remisiones") || frm.equals("Información Cardiovascular") || frm.equals("Patologías Asociadas") || frm.equals("Suministro Multivitamínicos") || frm.equals("Atenciones por Especialidad") || frm.equals("Formulación por Tipo de Fórmula") || frm.equals("Citas Programadas por Especialidad") || frm.equals("Consultar Alertas Parametrizadas") || frm.equals("Consultar Usuarios Inactivos") || frm.equals("Información Crónicos Colmedica") || frm.equals("Residuos Peligrosos") || frm.equals("-")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase());
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Resolucion4505")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 0);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Edades")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 1);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Sexo")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 2);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Consultar Morbilidad General por Sexo y Edad")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase(), 3);
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Auditoria Medica")) {
            this.xjifauditoriahc = new JIFAuditoriaHC("xjifauditoriahcmed");
            Principal.cargarPantalla(this.xjifauditoriahc);
            return;
        }
        if (frm.equals("Auditoria Enfermeria")) {
            this.xjifauditoriahc = new JIFAuditoriaHC("xjifauditoriahcenfer");
            Principal.cargarPantalla(this.xjifauditoriahc);
            return;
        }
        if (frm.equals("Consolidado Eventos No Deseados")) {
            this.xjifinforme = new JIFInformesPyP(frm.toUpperCase());
            Principal.cargarPantalla(this.xjifinforme);
            return;
        }
        if (frm.equals("Informacion SO")) {
            this.xjifconsultarinfso = new JIFConsultarInforSo();
            Principal.cargarPantalla(this.xjifconsultarinfso);
            return;
        }
        if (frm.equals("Reporte de Gestión de Riesgo")) {
            this.xjifconsultarcove = new JIFConsultarInfCove();
            Principal.cargarPantalla(this.xjifconsultarcove);
            return;
        }
        if (frm.equals("Placas Dañadas")) {
            this.xjifconsultarinf2tablas = new JIFConsultarInf3Tabla("xjifplacasdanadas", "INFORME DE PLACAS DAÑADAS");
            Principal.cargarPantalla(this.xjifconsultarinf2tablas);
            return;
        }
        if (frm.equals("Informes de Placas")) {
            this.xjifinformeplacas = new JIFInformesPlacas("Informes de Placas", "jifinformeplacas");
            Principal.cargarPantalla(this.xjifinformeplacas);
            return;
        }
        if (frm.equals("Forma de Asignación Citas")) {
            this.xjifconsultar1comtabla = new JIFConsultarInf1CombTabla1("xjiffasignacioncitas", "INFORME FORMA DE ASIGNACIÓN DE CITAS");
            Principal.cargarPantalla(this.xjifconsultar1comtabla);
            return;
        }
        if (frm.equals("Remisiones por Profesional")) {
            this.xjifconsulta1tablar = new JIFConsultarInf1Comb2Tabla("xjifremisionesxprofesional", frm.toUpperCase());
            Principal.cargarPantalla(this.xjifconsulta1tablar);
            return;
        }
        if (frm.equals("Información Cita x Especialidad")) {
            this.xjifconsulta1tablar = new JIFConsultarInf1Comb2Tabla("xjifinformacionxespecialidad", frm.toUpperCase());
            Principal.cargarPantalla(this.xjifconsulta1tablar);
            return;
        }
        if (frm.equals("Usuarios Atendidos")) {
            this.xjifinformeplacas = new JIFInformesPlacas("USUARIOS ATENDIDOS Y ESTUDIOS REALIZADOS", "xjifestudiosrealizados");
            Principal.cargarPantalla(this.xjifinformeplacas);
            return;
        }
        if (frm.equals("Usuarios Atendidos")) {
            this.xjifconsultarinf2tablas = new JIFConsultarInf3Tabla("xjifusuariosatendidos", "INFORME DE USUARIOS ATENDIDOS Y ESTUDIOS REALIZADOS");
            Principal.cargarPantalla(this.xjifconsultarinf2tablas);
            return;
        }
        if (frm.equals("Informe Super Salud")) {
            this.xjifinformesupersalud = new JIFInformesSupersalud();
            Principal.cargarPantalla(this.xjifinformesupersalud);
            return;
        }
        if (frm.equals("Formulacion Medica")) {
            this.xjifformulacionmed = new JIFConsultasInfMed("jifconsultarinformesm1");
            Principal.cargarPantalla(this.xjifformulacionmed);
            return;
        }
        if (frm.equals("Vigencia de Pólizas x Proveedor")) {
            this.xjifpoliza = new JIFVigenciaPoliza("jifvigenciapoliza");
            Principal.cargarPantalla(this.xjifpoliza);
            return;
        }
        if (frm.equals("CONSULTA USUARIOS MATRICULADOS")) {
            this.xjifuser_envio = new JIFConsultasUsuarioEnv("jifconsultausuario");
            Principal.cargarPantalla(this.xjifuser_envio);
            return;
        }
        if (frm.equals("Consulta Detalle Alto Riesgo Obstétrico")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarPrograma", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe Consolidado de Clases de Citas por Especialidad")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarEspecialidad", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Atenciones por Empresa")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarRadiologia", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Estadistica de Procedimientos por Tipo de Atencion")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarProcedimiento", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Procedimientos Detallado por Empresa")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarProcedimientoDet", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Asignacion Citas por Usuario del Sistema")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolidadoAsignacionCitas", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Citas Por Empresa")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("CitasPorEmpresa", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Atenciones Riesgo Obstetrico (Facturacion)")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("RiesgoObstetrico", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Atenciones Riesgo Cardiovascular (Facturacion)")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("RiesgoCardiovascular", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado De Atenciones Por Fecha")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolidadoAtencionFecha", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Procedimientos Realizados Por Empresa")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ProcedimientosEmpresa", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Cirugias No Programadas")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("CirugiasNoProgramadas", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Consolidado Por Profesional")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolidadoPorProfesional", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Cirugias Por EPS")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("CirugiasPorEPS", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Cirugias Usuarios EPS y Profesional")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("CirugiasUsuariosEPSyProfesional", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Detalle Entrada Por Bodega")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("DetalleEntradaPorBodega", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consultar Atenciones")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarAtenciones", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Ordenes por Medico")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolidadOrdenesMedico", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Ordenes por Convenio y Profesional")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolidOrdenConvenioProf", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Estadistica de Procedimientos Laboratorio")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("EstadisProcedLab", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consolidado de Procedimientos Detallado Laboratorio")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsolProcedLabDet", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Listado De Pacientes Facturados Para Atención Laboratorio")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("pacienteFacAtencionLab", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Listado De Pacientes Facturados Para Atención Radiología")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("pacienteFacAtencionRad", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe De Gestantes x Control prenatal")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("InformeControlPrenatar", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consulta Salud Ocupacional para DX")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultaSaludOcupacionalDX", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consulta Orden Por Procedimiento")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultarOrdenesProcedimiento", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Consulta Informacion de Lipidos y Carbohidratos")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ConsultaInforLipidosCarbo", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Total de Dosis Suministradas")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("totalDosiSuministradas", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Total de Dosis Suministrada por Entidad")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("totalDosiSuministroEntidad", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe de Aplicacion de Vacunas por Usuario")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("vacunacionAplicxUsuario", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe de Aplicacion de Vacunas por Usuario")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("vacunacionAplicxUsuario", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Formulación Por Subgrupo Farmacológico")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("formuSubgruFarmacologico", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Empresa por Convenio (Farmacológico)")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("empresaConveFarmacologico", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe Resolucion 4725")) {
            this.xJIFComsultarResolucion_4725 = new JIFComsultarResolucion_4725();
            Principal.cargarPantalla(this.xJIFComsultarResolucion_4725);
            return;
        }
        if (frm.equals("Informe Resolucion 2463")) {
            this.xJIFFConsultarInfoRes2463 = new JIFFConsultarInfoRes2463();
            Principal.cargarPantalla(this.xJIFFConsultarInfoRes2463);
            return;
        }
        if (frm.equals("Producción Por Sede y Profesional")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("produccionPorSedeYProfesional", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe de Control Prenatal")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("consultaPrenatal", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Informe de Lecturas Por Empresa y Valor")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("lecturaPorEmpresaYValor", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Censo Hospitalización")) {
            this.xCensoHospitalizacion = new CensoHospitalizacion();
            Principal.cargarPantalla(this.xCensoHospitalizacion);
            return;
        }
        if (frm.equals("Información de Convenios")) {
            this.xJIFInformacionConvenios = new JIFInformacionConvenios();
            Principal.cargarPantalla(this.xJIFInformacionConvenios);
            return;
        }
        if (frm.equals("Información De Atención Prioritaria Preferencial")) {
            this.xJIFInfoAtencionPrioritariaxClasificacion = new JIFInfoAtencionPrioritariaxClasificacion();
            Principal.cargarPantalla(this.xJIFInfoAtencionPrioritariaxClasificacion);
            return;
        }
        if (frm.equals("Medicamentos por Tipo de Formula")) {
            this.xJIFMedicamentosxFormula = new JIFMedicamentosxFormula();
            Principal.cargarPantalla(this.xJIFMedicamentosxFormula);
            return;
        }
        if (frm.equals("Informe de Diagnosticos de Salud")) {
            this.xJIFDiagnosticoSalud = new JIFDiagnosticoSalud();
            Principal.cargarPantalla(this.xJIFDiagnosticoSalud);
            return;
        }
        if (frm.equals("Informe Resolución 1604")) {
            this.xJIFInforme_Resolucion1604 = new JIFConsulta_Resolucion1604_2013();
            Principal.cargarPantalla(this.xJIFInforme_Resolucion1604);
            return;
        }
        if (frm.equals("Informe Morbilidad IRA")) {
            this.xJIFInformeMorbilidadIra = new JIFInformeMorbilidadIra();
            Principal.cargarPantalla(this.xJIFInformeMorbilidadIra);
            return;
        }
        if (frm.equals("Informe Morbilidad EDA")) {
            this.xJIFInformeMorbilidadEDA = new JIFInformeMorbilidadEDA();
            Principal.cargarPantalla(this.xJIFInformeMorbilidadEDA);
            return;
        }
        if (frm.equals("Informe Atenciones Cronicos")) {
            this.xJIFConsultarInformacionCronico = new JIFConsultarInformacionCronicos();
            Principal.cargarPantalla(this.xJIFConsultarInformacionCronico);
            return;
        }
        if (frm.equals("Informe Duracion de Tratamientos Medicos")) {
            this.xJIFConsultarPeriodoDuracionTratamiento = new JIFConsultarPeriodoDuracionTratamiento();
            Principal.cargarPantalla(this.xJIFConsultarPeriodoDuracionTratamiento);
            return;
        }
        if (frm.equals("Reporte Examen Ocupacional")) {
            this.xJIFReporteExamenOcupacional = new JIFReporteExamenOcupacional("xJIFReporteExamenOcupacional1");
            Principal.cargarPantalla(this.xJIFReporteExamenOcupacional);
            return;
        }
        if (frm.equals("Tratamientos Odontologicos por Facturar")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO(frm, "xjifinformegenericoso1");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Consolidado de Procedimientos ordenados por usuario")) {
            this.xJIFFConsultarInformacionGenerico = new JIFFConsultarInformacionGenerico("ProcedimientosOrdenadosUsuario", frm);
            Principal.cargarPantalla(this.xJIFFConsultarInformacionGenerico);
            return;
        }
        if (frm.equals("Rips Ministerio(Atenciones Sentencia T-733 de 2017)")) {
            if (Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.generacionRipsMiniterio = new JIF_GeneracionRipsMinisterio(frm.toUpperCase());
                Principal.cargarPantalla(this.generacionRipsMiniterio);
                return;
            }
            return;
        }
        if (frm.equals("InformesGeneralesPyP")) {
            this.xJIFInformesGeneralesPyP = new JIFInformesGeneralesPyP();
            Principal.cargarPantalla(this.xJIFInformesGeneralesPyP);
            return;
        }
        if (frm.equals("Informe de Accidentes de Transito")) {
            this.xJIFInformesGenericoSO = new JIFInformesGenericoSO("Informe de Accidentes de Transito", "xjifinformegenericoso1");
            Principal.cargarPantalla(this.xJIFInformesGenericoSO);
            return;
        }
        if (frm.equals("Informe de Anexos")) {
            this.xJIFInformeAnexos = new JIFInformeAnexos();
            Principal.cargarPantalla(this.xJIFInformeAnexos);
            return;
        }
        if (frm.equals("Informe de Citas Atendidas")) {
            this.xJIFInformeCitasAtendidas = new JIFInformeCitasAtendidas();
            Principal.cargarPantalla(this.xJIFInformeCitasAtendidas);
            return;
        }
        if (frm.equals("Informe de Interconsultas") || frm.equals("Reingreso antes de 72 Horas")) {
            this.xJIFInformeInterconsultas = new JIFInformeInterconsultas(frm);
            Principal.cargarPantalla(this.xJIFInformeInterconsultas);
        } else if (frm.equals("Informe Produccion Por Sede")) {
            this.xJIFReportesProduccionPorSede = new JIFReportesProduccionPorSede();
            Principal.cargarPantalla(this.xJIFReportesProduccionPorSede);
        } else if (!frm.equals("Número de Atenciones por Servicio") && frm.equals("Información de Facturación Agrupada")) {
            this.informeConsolidadoPypFinalidad = new JIFInformeConsolidadoPypFinalidad("jifInformeConsoliadoPorFinalidad1", frm.toUpperCase());
            Principal.cargarPantalla(this.informeConsolidadoPypFinalidad);
        }
    }

    public void grabar(String frm) {
    }

    public void nuevo(String frm) {
        if (frm.equals("jifinformacioncove")) {
            this.xjifconsultarcove.mNuevo();
            return;
        }
        if (frm.equals("xjif_generacion_rips_ministerio")) {
            this.generacionRipsMiniterio.nuevo();
            return;
        }
        if (frm.equals("xjifplacasdanadas")) {
            this.xjifconsultarinf2tablas.mNuevo();
            return;
        }
        if (frm.equals("jifinformeplacas")) {
            this.xjifinformeplacas.mNuevo();
            return;
        }
        if (frm.equals("xjiffasignacioncitas")) {
            this.xjifconsultar1comtabla.mNuevo();
            return;
        }
        if (frm.equals("xjifinformacionxespecialidad")) {
            this.xjifconsulta1tablar.mNuevo();
            return;
        }
        if (frm.equals("xjifestudiosrealizados")) {
            this.xjifinformeplacas.mNuevo();
            return;
        }
        if (frm.equals("xjifinformesupersalud")) {
            this.xjifinformesupersalud.mNuevo();
            return;
        }
        if (frm.equals("xjifauditoriahcmed") || frm.equals("xjifauditoriahcenfer")) {
            this.xjifauditoriahc.nuevo();
            return;
        }
        if (frm.equals("ConsultarPrograma") || frm.equals("ConsultarEspecialidad") || frm.equals("ConsultarRadiologia") || frm.equals("ConsultarProcedimiento") || frm.equals("ConsultarProcedimientoDet") || frm.equals("ConsolidadoAsignacionCitas") || frm.equals("CirugiasNoProgramadas") || frm.equals("ConsolidadoPorProfesional") || frm.equals("CirugiasPorEPS") || frm.equals("CirugiasUsuariosEPSyProfesional") || frm.equals("DetalleEntradaPorBodega") || frm.equals("") || frm.equals("RiesgoObstetrico") || frm.equals("ConsolidadoAtencionFecha") || frm.equals("ProcedimientosEmpresa") || frm.equals("ConsultarAtenciones") || frm.equals("CitasPorEmpresa") || frm.equals("ConsolidOrdenConvenioProf") || frm.equals("ConsolidadOrdenesMedico") || frm.equals("EstadisProcedLab") || frm.equals("ConsolProcedLabDet") || frm.equals("pacienteFacAtencionLab") || frm.equals("pacienteFacAtencionRad") || frm.equals("InformeControlPrenatar") || frm.equals("ConsultaSaludOcupacionalDX") || frm.equals("ConsultarOrdenesProcedimiento") || frm.equals("ConsultaInforLipidosCarbo") || frm.equals("totalDosiSuministradas") || frm.equals("totalDosiSuministroEntidad") || frm.equals("vacunacionAplicxUsuario") || frm.equals("formuSubgruFarmacologico") || frm.equals("empresaConveFarmacologico") || frm.equals("produccionPorSedeYProfesional") || frm.equals("consultaPrenatal") || frm.equals("lecturaPorEmpresaYValor") || frm.equals("ProcedimientosOrdenadosUsuario")) {
            this.xJIFFConsultarInformacionGenerico.mNuevo();
            return;
        }
        if (frm.equals("informeRes2463")) {
            this.xJIFFConsultarInfoRes2463.mNuevo();
            return;
        }
        if (frm.equals("Informe Resolucion 4725")) {
            this.xJIFComsultarResolucion_4725.mNuevo();
            return;
        }
        if (frm.equals("Censo Hospitalización")) {
            this.xCensoHospitalizacion.mNuevo();
            return;
        }
        if (frm.equals("xjifinfoantencionprioritariaxclasificacion")) {
            this.xJIFInfoAtencionPrioritariaxClasificacion.mNuevo();
            return;
        }
        if (frm.equals("xjifdiagnosticosalud")) {
            this.xJIFDiagnosticoSalud.mNuevo();
            return;
        }
        if (frm.equals("xJif_informe_resolucion1604")) {
            this.xJIFInforme_Resolucion1604.mNuevo();
            return;
        }
        if (frm.equals("xjifinformemorbilidadira")) {
            this.xJIFInformeMorbilidadIra.mNuevo();
            return;
        }
        if (frm.equals("xjifinformemorbilidadeda")) {
            this.xJIFInformeMorbilidadEDA.mNuevo();
            return;
        }
        if (frm.equals("xjifconsultarperiododuraciontratamiento")) {
            this.xJIFConsultarPeriodoDuracionTratamiento.mNuevo();
            return;
        }
        if (frm.equals("xjifinformeanexos")) {
            this.xJIFInformeAnexos.mNuevo();
            return;
        }
        if (frm.equals("xjifinformedecitasatendidas")) {
            this.xJIFInformeCitasAtendidas.mNuevo();
            return;
        }
        if (frm.equals("xjifinformeinterconsultas")) {
            this.xJIFInformeInterconsultas.mNuevo();
        } else if (frm.equals("jIFReportesProduccionPorSede")) {
            this.xJIFReportesProduccionPorSede.nuevo();
        } else if (frm.equals("jifInformeConsoliadoPorFinalidad")) {
            this.informeConsolidadoPypFinalidad.nuevo();
        }
    }

    public void anular(String frm) {
    }
}
