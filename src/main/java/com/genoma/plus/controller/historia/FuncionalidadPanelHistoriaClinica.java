package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Citas.JDCitasInterConsulta;
import Enfermeria.JPControlDiabetes;
import Enfermeria.JPControlLiquidos;
import Enfermeria.JPControlOxigeno;
import Enfermeria.JPRSignosVitales;
import Historia.JIFAdultoJoven;
import Historia.JIFAdultoJoven2;
import Historia.JPAAPatologiasAsociadas;
import Historia.JPAActividadesPyP;
import Historia.JPAAntecedenteGineco;
import Historia.JPAAntecedenteGineco_Nuevo;
import Historia.JPAAntecedentesPediatricos;
import Historia.JPAAntecentesFamiliares;
import Historia.JPAAntecentesHabitos;
import Historia.JPAAntecentesOcupacionales;
import Historia.JPAAntecentesOcupacionalesNuevo;
import Historia.JPAAntecentesPPersonales;
import Historia.JPAAtencion;
import Historia.JPAColposcopia;
import Historia.JPAConclusion;
import Historia.JPADiagnostico;
import Historia.JPAEcografiaGenerico;
import Historia.JPAEcografiaObstetrica;
import Historia.JPAEcografiaPelvica;
import Historia.JPAEvaluacionRiesgo;
import Historia.JPAEventoNoDeseado;
import Historia.JPAExamenFisico;
import Historia.JPAExamenFisicoPrenatal;
import Historia.JPAExamenFisicoPrenatal_v2;
import Historia.JPAHExamenFisico;
import Historia.JPAIncapacidad;
import Historia.JPAIncapacidad_v2;
import Historia.JPANotas;
import Historia.JPANotas_v2;
import Historia.JPARevisionAyudasDx;
import Historia.JPARevisionAyudasDxRx;
import Historia.JPARevisionAyudasDxS;
import Historia.JPARevisionSistemas;
import Historia.JPASaludOcupacional;
import Historia.JPATestMorisky;
import Historia.JPAdultoMayor;
import Historia.JPEgresoUrgencias;
import Historia.JPEscalaDolor;
import Historia.JPEscalaFuerzaMuscular;
import Historia.JPFichaUsuario;
import Historia.JPFiltroIFG;
import Historia.JPFramingham;
import Historia.JPFramingham1;
import Historia.JPFramingham_M;
import Historia.JPGestionRiesgo_Dm;
import Historia.JPGestionRiesgo_Hta;
import Historia.JPGlasgow;
import Historia.JPGraficaAgenteSEG;
import Historia.JPGraficasPyP;
import Historia.JPGraficasPyPTierraAlta;
import Historia.JPGraficasPyPTierraAlta_v2;
import Historia.JPHNutricional;
import Historia.JPHistoria_Terapias;
import Historia.JPHistoricoAtenciones;
import Historia.JPHistoricoAtencionesVisionIPS;
import Historia.JPIExamenClinicoPE;
import Historia.JPIOrden_Tratamiento;
import Historia.JPISeguimiento_Pac;
import Historia.JPITriage;
import Historia.JPI_Cirugias;
import Historia.JPI_Cirugias1;
import Historia.JPI_Control_Impresion;
import Historia.JPI_Test_AgudezaVisual;
import Historia.JPListaCHequeo;
import Historia.JPOOrdenProcedimientosH;
import Historia.JPOOrdenSuministroH;
import Historia.JPORemisiones;
import Historia.JPORemisiones1;
import Historia.JPOftamologiaGen;
import Historia.JPPartograma;
import Historia.JPPermisosMedicos;
import Historia.JPPlanificacionFliar;
import Historia.JPReuConteoArticulaciones;
import Historia.JPRiesgoBiosicoSocial;
import Historia.JPRuffier;
import Historia.JPSoBiblioteca;
import Historia.JPSo_Audiometria;
import Historia.JPSo_Concepto_E;
import Historia.JPSo_Concepto_I;
import Historia.JPSo_CuestionarioSico;
import Historia.JPSo_Cuestionario_N;
import Historia.JPSo_Cuestionarios;
import Historia.JPSo_Espirometria;
import Historia.JPSo_EspirometriaSI;
import Historia.JPSo_Optometria;
import Historia.JPSo_Osteomuscular;
import Historia.JPSo_PEjercicio;
import Historia.JPSo_Test_PRespiratorio;
import Historia.JPSo_Visiometria;
import Historia.JPSo_VisiometriaFPZ;
import Historia.JPSo_VisiometriaG;
import Historia.JPSo_VisiometriaMineros;
import Historia.JPSociodemografico;
import Historia.JPTestFindrisk;
import Historia.JPTransfuciones;
import Historia.JPTrasnporteAsis;
import Historia.JPVacunacion;
import Historia.JP_CP_DatosPyP;
import Historia.JP_CP_ResultadoExamenes1;
import Historia.JP_Cargar_DocumentosHC;
import Historia.JP_Optometria;
import Historia.JP_PyP_DMyHTA;
import Historia.JP_PyP_Diabetes;
import Historia.JP_PyP_HTA;
import Historia.aiepi.JPAiepi;
import Historia.aiepi.JPAiepiAtencionMadres;
import Historia.aiepi.JPAiepiMadres;
import Historia.aiepi.JPAiepiNinos;
import Historia.clasesHistoriaCE;
import Odontologia.JPAAntecentesOdontologicos;
import Odontologia.JPAnalisiOclusal;
import Odontologia.JPAnalisisEstomatologico;
import Odontologia.JPAnalisisFuncional;
import Odontologia.JPCefalometria;
import Odontologia.JPControlPlaca;
import Odontologia.JPControlPlacaCompleto;
import Odontologia.JPEndoExamenClinico;
import Odontologia.JPExamenDentario;
import Odontologia.JPOclusion;
import Odontologia.JPOdontograma;
import Odontologia.JPOdontogramaClinico;
import Odontologia.JPOdontogramaInicial;
import Odontologia.JPRxOdontologia;
import PyP.Alimentacion;
import PyP.JPEscalaAbreviada;
import PyP.MotricidadFina;
import PyP.MotricidadGruesa;
import PyP.ValoracionLenguaje;
import PyP.ValoracionPersonal;
import PyP.ValoracionResultado;
import Salud_Ocupacional.JPPruebaAyD;
import Salud_Ocupacional.JPTestFatiga;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3;
import com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R;
import com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO;
import com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo;
import com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2;
import com.genoma.plus.controller.sgc.JPEventoAdverso;
import com.genoma.plus.dao.general.AlertasGeneralesDAO;
import com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/FuncionalidadPanelHistoriaClinica.class */
public class FuncionalidadPanelHistoriaClinica {
    private JPAAtencion pAAtencion;
    private JPARevisionSistemas xJPARevisionSistemas;
    private JPARevisionAyudasDxS xJPARevisionAyudasDxS;
    private JPARevisionAyudasDxRx xJPARevisionAyudasDxRx;
    private JPRxOdontologia xJPRxOdontologia;
    private JPIOrden_Tratamiento xjiftratamiento;
    private JPIOrden_Tratamiento_Nueva orden_Tratamiento_Nueva;
    private JPADiagnostico xJPADiagnostico;
    private JPFichaUsuario fichaUsuario;
    private JP_ExamenFisicoI examenFisicoI;
    private JP_ExamenFisicoSo examenFisicoSo;
    private JP_ExamenFisicoI1 examenFisicoI1;
    private JPHistoricoAtenciones historicoAtenciones;
    private JPI_Test_AgudezaVisual agudezaVisual;
    public JPOOrdenSuministroH xjpsuministroh;
    private JPOOrdenProcedimientosH xjpprocedimientosh;
    private JPORemisiones xjpremisiones;
    private JPORemisiones1 xjpremisiones1;
    public JPAIncapacidad xjpincapacidad;
    public JPAIncapacidad_v2 aIncapacidad_v2;
    private JPAEventoNoDeseado xjpeventonodeseado;
    private JPPermisosMedicos xjppermisos;
    private JPANotas xjpnotas;
    private JPANotas_v2 xjpnotas1;
    private JPHNutricional xjpnutricion;
    private JPAConclusion xjifconclusion;
    private JP_CP_ResultadoExamenes1 xjifpyprevisionexamenes;
    private JPSo_Visiometria xjifvisiometria;
    private JPSo_VisiometriaFPZ xjifvisiometriafpz;
    private JPSo_VisiometriaG xjifvisiometriaG;
    private JPSo_Espirometria xjifespirometria;
    private JPSo_EspirometriaSI xjifespirometriaSI;
    private JPSo_Audiometria xjifaudiometria;
    private JPSo_Audiometria_nueva1 audiometria_nueva1;
    private JPSo_Concepto_E xjifconceptoso_e;
    private JPSo_Concepto_I xjifconceptosio_i;
    private JPSo_Concepto_R concepto_R;
    private JPSo_Osteomuscular xjifosteomuscuar;
    private JPAEcografiaGenerico xjifecografiagenerico;
    private JPAColposcopia xjifcolposcopia;
    private JPSo_PEjercicio xjifprescripcionejercicio;
    private JPSo_Optometria xjifoptometria;
    private JP_Optometria jP_Optometria;
    private JPSo_Cuestionarios xjifcuestionarios;
    private JPSo_Cuestionario_N xjifcuestionarios_n;
    private JPSo_Test_PRespiratorio xjiftest_prespiratorio;
    private JPHistoricoAtenciones xjifhatenciones;
    private JPPruebaAyD xjifpruebaayd;
    private JPOdontograma xjifOdontograma;
    private JPControlPlaca xjifControlPlaca;
    private JPTestFatiga xjptestfatiga;
    private JPAEcografiaPelvica xjifecografiap;
    private JP_PyP_HTA xjifHTA;
    private JP_PyP_Diabetes xjifdiabetes;
    private JPExamenDentario xJPExamenDentario;
    private JPOclusion xJPOclusion;
    private JPITriage xjptriage;
    private String xnombre;
    private JPEndoExamenClinico xJPEndoExamenClinico;
    private JPOdontogramaInicial xJPOdontogramaInicial;
    private JPCefalometria xJPCefalometria;
    private JPAnalisiOclusal xJPAnalisiOclusal;
    private JPAnalisisEstomatologico xJPAnalisisEstomatologico;
    private JPAnalisisFuncional xJPAnalisisFuncional;
    private JPGestionRiesgo_Dm xjpgestionriesgo;
    private JPISeguimiento_Pac xjifseguimiento;
    private JPGestionRiesgo_Hta xjpgestionriesgohta;
    private JPEscalaAbreviada xJPEscalaAbreviada;
    private JPFiltroIFG xJPFiltroIFG;
    private JPVacunacion xJPVacunacion;
    private JPAExamenFisicoPrenatal xJPAExamenFisicoPrenatal;
    private JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal_v2;
    private JPGraficasPyP xJPGraficasPyP;
    private JPSo_CuestionarioSico xJPSo_CuestionarioSico;
    private JPHistoria_Terapias xjif_terapiaf;
    private JPAiepi xJPAiepi;
    private JPAiepiNinos xJPAiepiNinos;
    private JPAiepiMadres xJPAiepiMadres;
    private JPTransfuciones xJPTransfuciones;
    private JPTrasnporteAsis xJPTrasnporteAsis;
    private JPI_Cirugias xJPCirugias;
    private JPI_Cirugias1 xJPCirugias1;
    private JPI_Control_Impresion xJPImpresion_Doc;
    private JPListaCHequeo xJPListaCHequeo;
    private JPAdultoMayor xJPAdultoMayor;
    private JIFAdultoJoven xJIFAdultoJoven;
    private JPSociodemografico xJPSociodemografico;
    private JPOftamologiaGen xJPOftamologiaGen;
    private JP_Cargar_DocumentosHC xjif_importardochc;
    private JPI_Test_AgudezaVisual xjif_testagudeza_visual;
    private JPControlPlacaCompleto xJPControlPlacaCompleto;
    private JIFAdultoJoven2 xJIFAdultoJoven2;
    private JPPartograma xJPPartograma;
    private JPOdontogramaClinico xJPOdontogramaClinico;
    private JPPlanificacionFliar xJPPlanificacionFliar;
    private JPGraficaAgenteSEG xJPGraficaAgenteSEG;
    private JPEventoAdverso xJPEventoAdverso;
    private JPAEvaluacionRiesgo xJPAEvaluacionRiesgo;
    private JPFramingham xJPFramingham;
    private JPFramingham1 xJPFramingham1;
    private JPFramingham_M xJPFraminghamM;
    private JPRuffier xJPRuffier;
    private JPTestFindrisk xJPTestFindrisk;
    private JPRevisonExamenSo xJPRevisonExamenSo;
    private JPRevisonExamenSo_V2 xJPRevisonExamenSo_V2;
    private JPCertificadoSO xJPCertificadoSO;
    private JPSoBiblioteca xJPSoBiblioteca;
    private JPARevisionAyudasDx xJPARevisionAyudasDx;
    private JPAAtencion xJPAAtencion;
    private JPRSignosVitales xJPRSignosVitales;
    private JPControlDiabetes xJPControlDiabetes;
    private JPIExamenClinicoPE xJPIExamenClinicoPE;
    private JPAAntecentesFamiliares xJPAAntecentesFamiliares;
    private JPAAntecentesHabitos xJPAAntecentesHabitos;
    private JPAAntecentesPPersonales xJPAAntecentesPPersonales;
    private JPAAPatologiasAsociadas xJPAAPatologiasAsociadas;
    private JPAAntecedentesPediatricos xJPAAntecedentesPediatricos;
    private JPAAntecentesOdontologicos xJPAAntecentesOdontologicos;
    private JPAExamenFisico xJPAExamenFisico;
    private JPAHExamenFisico xJPAHExamenFisico;
    private JPRiesgoBiosicoSocial xJPRiesgoBiosicoSocial;
    public JPEgresoUrgencias xJPEgresoUrgencias;
    private JPAAntecedenteGineco xJPAAntecedenteGineco;
    private JPAAntecedenteGineco_Nuevo xJPAAntecedenteGineco_Nuevo;
    private JPATestMorisky xJPATestMorisky;
    private JPASaludOcupacional xJPASaludOcupacional;
    private JPAEcografiaObstetrica xJPAEcografiaObstetrica;
    private JPGaleriaImagenes xJPGaleriaImagenes;
    private JPEscalaDolor xJPEscalaDolor;
    private JPEscalaFuerzaMuscular xJPEscalaFuerzaMuscular;
    private JPAFonoaudiologia xJPAFonoaudiologia;
    private JPAAntecedenteReumatologia xJPAAntecedenteReumatologia;
    private JPATamizajeEstetico xJPATamizajeEstetico;
    private JPSo_Psicomotriz xJPSo_Psicomotriz;
    private JPDepresionPosparto xJPDepresionPosparto;
    private JPMaltratoViolencia xJPMaltratoViolencia;
    private JPReuConteoArticulaciones xJPReuConteoArticulaciones;
    private JPAClasificacionEular xJPAClasificacionEular;
    private JPCuestionarioHAQ xJPCuestionarioHAQ;
    private JPSo_VisiometriaMineros xJPSo_VisiometriaMineros;
    private JPA_AntecedentesPersonalesTabla xJPAntecedentesPersonalesTabla;
    private JPA_RevisionSistemasTabla xRevisionSistemasTabla;
    private JPAAntecedentesGinecobstetricos xJPAAntecedentesGinecobstetricos;
    private JPA_Atencion_InformacionN10 xJPA_Atencion_InformacionN10;
    private JPAntecedenteFamiliarTexto antecedenteFamiliarTexto;
    private JPA_NotasMedicasN xNotasMedicasNa;
    private JPAFamiliograma xJPAFamiliograma;
    private JPA_NotasProcedimientosMenores xA_NotasProcedimientosMenores;
    private JPAEscalaAbreviadaDeDesarrollo jPAEscalaAbreviadaDeDesarrollo;
    private JPAEscalaAbreviadaDeDesarrollo_V2 jPAEscalaAbreviadaDeDesarrollo_V2;
    private JPControlOxigeno controlOxigeno;
    private JPControlLiquidos controlLiquidos;
    private JP_CP_DatosPyP datosPyP;
    private JPAActividadesPyP actividadesPyP;
    private Alimentacion alimentacion;
    private MotricidadFina motricidadFina;
    private MotricidadGruesa motricidadGruesa;
    private ValoracionLenguaje valoracionLenguaje;
    private ValoracionPersonal valoracionPersonal;
    private ValoracionResultado valoracionResultado;
    private JPAAntecentesOcupacionales aAntecentesOcupacionales;
    private JPAAntecentesOcupacionalesNuevo aAntecentesOcupacionalesNuevo;
    private JP_CP_DatosPyP datosPyP1;
    private AlertasGeneralesDAO alertasGeneralesDAO;
    private JPARevisionAyudasDx_Nueva revisionAyudasDx_Nueva;
    private JPGlasgow xJPGlasgow;
    private JPAEvaluacionRecienNacido evaluacionRecienNacido;
    private JPAVale jPaVale;
    private JPAListaChequeo jPAListaChequeo;
    private JPATestSmokingAndSubstance jPATestSmokingAndSubstance;
    private JPAntecedentesFisicosPsiquiatricos jpAntecedentesFisicosPsiquiatricos;
    public JPI_FormularioAnexo3 formularioAnexo3;
    public JPI_FormularioAnexo2 formularioAnexo2;
    private JPTriageRespiratorio triageRespiratorio;
    private JPTriageRespiratorio_V2 triageRespiratorio_V2;
    private JPAtencionDieta xJPAtencionDieta;
    public JPA_TestCrb65 testCrb65;
    private JPGraficasPyPTierraAlta xJPGraficasPyPTierraAlta;
    private JPGraficasPyPTierraAlta_v2 xJPGraficasPyPTierraAlta_v2;
    private JP_PyP_DMyHTA xIngresoHTAyDM;
    private JP_IngresoProgramaCyD xJP_IngresoProgramaCyD;
    private JPAiepiAtencionMadres xJPAiepiAtencionMadres;
    private JPPeligros xjPPeligros;
    private JPAiepiOncologicoTest aiepiOncologicoTest;
    private JPHistoricoAtencionesVisionIPS atencionesVisionIPS;
    private JPIngresoPlanificacionFamiliar jPIngresoPlanificacionFamiliar;
    private ConsultasMySQL xct = new ConsultasMySQL();
    public String pueba1 = "prueba funcionalidad";

    @Generated
    public void setPAAtencion(JPAAtencion pAAtencion) {
        this.pAAtencion = pAAtencion;
    }

    @Generated
    public void setXJPARevisionSistemas(JPARevisionSistemas xJPARevisionSistemas) {
        this.xJPARevisionSistemas = xJPARevisionSistemas;
    }

    @Generated
    public void setXJPARevisionAyudasDxS(JPARevisionAyudasDxS xJPARevisionAyudasDxS) {
        this.xJPARevisionAyudasDxS = xJPARevisionAyudasDxS;
    }

    @Generated
    public void setXJPARevisionAyudasDxRx(JPARevisionAyudasDxRx xJPARevisionAyudasDxRx) {
        this.xJPARevisionAyudasDxRx = xJPARevisionAyudasDxRx;
    }

    @Generated
    public void setXJPRxOdontologia(JPRxOdontologia xJPRxOdontologia) {
        this.xJPRxOdontologia = xJPRxOdontologia;
    }

    @Generated
    public void setXjiftratamiento(JPIOrden_Tratamiento xjiftratamiento) {
        this.xjiftratamiento = xjiftratamiento;
    }

    @Generated
    public void setOrden_Tratamiento_Nueva(JPIOrden_Tratamiento_Nueva orden_Tratamiento_Nueva) {
        this.orden_Tratamiento_Nueva = orden_Tratamiento_Nueva;
    }

    @Generated
    public void setXJPADiagnostico(JPADiagnostico xJPADiagnostico) {
        this.xJPADiagnostico = xJPADiagnostico;
    }

    @Generated
    public void setFichaUsuario(JPFichaUsuario fichaUsuario) {
        this.fichaUsuario = fichaUsuario;
    }

    @Generated
    public void setExamenFisicoI(JP_ExamenFisicoI examenFisicoI) {
        this.examenFisicoI = examenFisicoI;
    }

    @Generated
    public void setExamenFisicoSo(JP_ExamenFisicoSo examenFisicoSo) {
        this.examenFisicoSo = examenFisicoSo;
    }

    @Generated
    public void setExamenFisicoI1(JP_ExamenFisicoI1 examenFisicoI1) {
        this.examenFisicoI1 = examenFisicoI1;
    }

    @Generated
    public void setHistoricoAtenciones(JPHistoricoAtenciones historicoAtenciones) {
        this.historicoAtenciones = historicoAtenciones;
    }

    @Generated
    public void setAgudezaVisual(JPI_Test_AgudezaVisual agudezaVisual) {
        this.agudezaVisual = agudezaVisual;
    }

    @Generated
    public void setXjpsuministroh(JPOOrdenSuministroH xjpsuministroh) {
        this.xjpsuministroh = xjpsuministroh;
    }

    @Generated
    public void setXjpprocedimientosh(JPOOrdenProcedimientosH xjpprocedimientosh) {
        this.xjpprocedimientosh = xjpprocedimientosh;
    }

    @Generated
    public void setXjpremisiones(JPORemisiones xjpremisiones) {
        this.xjpremisiones = xjpremisiones;
    }

    @Generated
    public void setXjpremisiones1(JPORemisiones1 xjpremisiones1) {
        this.xjpremisiones1 = xjpremisiones1;
    }

    @Generated
    public void setXjpincapacidad(JPAIncapacidad xjpincapacidad) {
        this.xjpincapacidad = xjpincapacidad;
    }

    @Generated
    public void setAIncapacidad_v2(JPAIncapacidad_v2 aIncapacidad_v2) {
        this.aIncapacidad_v2 = aIncapacidad_v2;
    }

    @Generated
    public void setXjpeventonodeseado(JPAEventoNoDeseado xjpeventonodeseado) {
        this.xjpeventonodeseado = xjpeventonodeseado;
    }

    @Generated
    public void setXjppermisos(JPPermisosMedicos xjppermisos) {
        this.xjppermisos = xjppermisos;
    }

    @Generated
    public void setXjpnotas(JPANotas xjpnotas) {
        this.xjpnotas = xjpnotas;
    }

    @Generated
    public void setXjpnotas1(JPANotas_v2 xjpnotas1) {
        this.xjpnotas1 = xjpnotas1;
    }

    @Generated
    public void setXjpnutricion(JPHNutricional xjpnutricion) {
        this.xjpnutricion = xjpnutricion;
    }

    @Generated
    public void setXjifconclusion(JPAConclusion xjifconclusion) {
        this.xjifconclusion = xjifconclusion;
    }

    @Generated
    public void setXjifpyprevisionexamenes(JP_CP_ResultadoExamenes1 xjifpyprevisionexamenes) {
        this.xjifpyprevisionexamenes = xjifpyprevisionexamenes;
    }

    @Generated
    public void setXjifvisiometria(JPSo_Visiometria xjifvisiometria) {
        this.xjifvisiometria = xjifvisiometria;
    }

    @Generated
    public void setXjifvisiometriafpz(JPSo_VisiometriaFPZ xjifvisiometriafpz) {
        this.xjifvisiometriafpz = xjifvisiometriafpz;
    }

    @Generated
    public void setXjifvisiometriaG(JPSo_VisiometriaG xjifvisiometriaG) {
        this.xjifvisiometriaG = xjifvisiometriaG;
    }

    @Generated
    public void setXjifespirometria(JPSo_Espirometria xjifespirometria) {
        this.xjifespirometria = xjifespirometria;
    }

    @Generated
    public void setXjifespirometriaSI(JPSo_EspirometriaSI xjifespirometriaSI) {
        this.xjifespirometriaSI = xjifespirometriaSI;
    }

    @Generated
    public void setXjifaudiometria(JPSo_Audiometria xjifaudiometria) {
        this.xjifaudiometria = xjifaudiometria;
    }

    @Generated
    public void setAudiometria_nueva1(JPSo_Audiometria_nueva1 audiometria_nueva1) {
        this.audiometria_nueva1 = audiometria_nueva1;
    }

    @Generated
    public void setXjifconceptoso_e(JPSo_Concepto_E xjifconceptoso_e) {
        this.xjifconceptoso_e = xjifconceptoso_e;
    }

    @Generated
    public void setXjifconceptosio_i(JPSo_Concepto_I xjifconceptosio_i) {
        this.xjifconceptosio_i = xjifconceptosio_i;
    }

    @Generated
    public void setConcepto_R(JPSo_Concepto_R concepto_R) {
        this.concepto_R = concepto_R;
    }

    @Generated
    public void setXjifosteomuscuar(JPSo_Osteomuscular xjifosteomuscuar) {
        this.xjifosteomuscuar = xjifosteomuscuar;
    }

    @Generated
    public void setXjifecografiagenerico(JPAEcografiaGenerico xjifecografiagenerico) {
        this.xjifecografiagenerico = xjifecografiagenerico;
    }

    @Generated
    public void setXjifcolposcopia(JPAColposcopia xjifcolposcopia) {
        this.xjifcolposcopia = xjifcolposcopia;
    }

    @Generated
    public void setXjifprescripcionejercicio(JPSo_PEjercicio xjifprescripcionejercicio) {
        this.xjifprescripcionejercicio = xjifprescripcionejercicio;
    }

    @Generated
    public void setXjifoptometria(JPSo_Optometria xjifoptometria) {
        this.xjifoptometria = xjifoptometria;
    }

    @Generated
    public void setJP_Optometria(JP_Optometria jP_Optometria) {
        this.jP_Optometria = jP_Optometria;
    }

    @Generated
    public void setXjifcuestionarios(JPSo_Cuestionarios xjifcuestionarios) {
        this.xjifcuestionarios = xjifcuestionarios;
    }

    @Generated
    public void setXjifcuestionarios_n(JPSo_Cuestionario_N xjifcuestionarios_n) {
        this.xjifcuestionarios_n = xjifcuestionarios_n;
    }

    @Generated
    public void setXjiftest_prespiratorio(JPSo_Test_PRespiratorio xjiftest_prespiratorio) {
        this.xjiftest_prespiratorio = xjiftest_prespiratorio;
    }

    @Generated
    public void setXjifhatenciones(JPHistoricoAtenciones xjifhatenciones) {
        this.xjifhatenciones = xjifhatenciones;
    }

    @Generated
    public void setXjifpruebaayd(JPPruebaAyD xjifpruebaayd) {
        this.xjifpruebaayd = xjifpruebaayd;
    }

    @Generated
    public void setXjifOdontograma(JPOdontograma xjifOdontograma) {
        this.xjifOdontograma = xjifOdontograma;
    }

    @Generated
    public void setXjifControlPlaca(JPControlPlaca xjifControlPlaca) {
        this.xjifControlPlaca = xjifControlPlaca;
    }

    @Generated
    public void setXjptestfatiga(JPTestFatiga xjptestfatiga) {
        this.xjptestfatiga = xjptestfatiga;
    }

    @Generated
    public void setXjifecografiap(JPAEcografiaPelvica xjifecografiap) {
        this.xjifecografiap = xjifecografiap;
    }

    @Generated
    public void setXjifHTA(JP_PyP_HTA xjifHTA) {
        this.xjifHTA = xjifHTA;
    }

    @Generated
    public void setXjifdiabetes(JP_PyP_Diabetes xjifdiabetes) {
        this.xjifdiabetes = xjifdiabetes;
    }

    @Generated
    public void setXJPExamenDentario(JPExamenDentario xJPExamenDentario) {
        this.xJPExamenDentario = xJPExamenDentario;
    }

    @Generated
    public void setXJPOclusion(JPOclusion xJPOclusion) {
        this.xJPOclusion = xJPOclusion;
    }

    @Generated
    public void setXjptriage(JPITriage xjptriage) {
        this.xjptriage = xjptriage;
    }

    @Generated
    public void setXnombre(String xnombre) {
        this.xnombre = xnombre;
    }

    @Generated
    public void setXJPEndoExamenClinico(JPEndoExamenClinico xJPEndoExamenClinico) {
        this.xJPEndoExamenClinico = xJPEndoExamenClinico;
    }

    @Generated
    public void setXJPOdontogramaInicial(JPOdontogramaInicial xJPOdontogramaInicial) {
        this.xJPOdontogramaInicial = xJPOdontogramaInicial;
    }

    @Generated
    public void setXJPCefalometria(JPCefalometria xJPCefalometria) {
        this.xJPCefalometria = xJPCefalometria;
    }

    @Generated
    public void setXJPAnalisiOclusal(JPAnalisiOclusal xJPAnalisiOclusal) {
        this.xJPAnalisiOclusal = xJPAnalisiOclusal;
    }

    @Generated
    public void setXJPAnalisisEstomatologico(JPAnalisisEstomatologico xJPAnalisisEstomatologico) {
        this.xJPAnalisisEstomatologico = xJPAnalisisEstomatologico;
    }

    @Generated
    public void setXJPAnalisisFuncional(JPAnalisisFuncional xJPAnalisisFuncional) {
        this.xJPAnalisisFuncional = xJPAnalisisFuncional;
    }

    @Generated
    public void setXjpgestionriesgo(JPGestionRiesgo_Dm xjpgestionriesgo) {
        this.xjpgestionriesgo = xjpgestionriesgo;
    }

    @Generated
    public void setXjifseguimiento(JPISeguimiento_Pac xjifseguimiento) {
        this.xjifseguimiento = xjifseguimiento;
    }

    @Generated
    public void setXjpgestionriesgohta(JPGestionRiesgo_Hta xjpgestionriesgohta) {
        this.xjpgestionriesgohta = xjpgestionriesgohta;
    }

    @Generated
    public void setXJPEscalaAbreviada(JPEscalaAbreviada xJPEscalaAbreviada) {
        this.xJPEscalaAbreviada = xJPEscalaAbreviada;
    }

    @Generated
    public void setXJPFiltroIFG(JPFiltroIFG xJPFiltroIFG) {
        this.xJPFiltroIFG = xJPFiltroIFG;
    }

    @Generated
    public void setXJPVacunacion(JPVacunacion xJPVacunacion) {
        this.xJPVacunacion = xJPVacunacion;
    }

    @Generated
    public void setXJPAExamenFisicoPrenatal(JPAExamenFisicoPrenatal xJPAExamenFisicoPrenatal) {
        this.xJPAExamenFisicoPrenatal = xJPAExamenFisicoPrenatal;
    }

    @Generated
    public void setXJPAExamenFisicoPrenatal_v2(JPAExamenFisicoPrenatal_v2 xJPAExamenFisicoPrenatal_v2) {
        this.xJPAExamenFisicoPrenatal_v2 = xJPAExamenFisicoPrenatal_v2;
    }

    @Generated
    public void setXJPGraficasPyP(JPGraficasPyP xJPGraficasPyP) {
        this.xJPGraficasPyP = xJPGraficasPyP;
    }

    @Generated
    public void setXJPSo_CuestionarioSico(JPSo_CuestionarioSico xJPSo_CuestionarioSico) {
        this.xJPSo_CuestionarioSico = xJPSo_CuestionarioSico;
    }

    @Generated
    public void setXjif_terapiaf(JPHistoria_Terapias xjif_terapiaf) {
        this.xjif_terapiaf = xjif_terapiaf;
    }

    @Generated
    public void setXJPAiepi(JPAiepi xJPAiepi) {
        this.xJPAiepi = xJPAiepi;
    }

    @Generated
    public void setXJPAiepiNinos(JPAiepiNinos xJPAiepiNinos) {
        this.xJPAiepiNinos = xJPAiepiNinos;
    }

    @Generated
    public void setXJPAiepiMadres(JPAiepiMadres xJPAiepiMadres) {
        this.xJPAiepiMadres = xJPAiepiMadres;
    }

    @Generated
    public void setXJPTransfuciones(JPTransfuciones xJPTransfuciones) {
        this.xJPTransfuciones = xJPTransfuciones;
    }

    @Generated
    public void setXJPTrasnporteAsis(JPTrasnporteAsis xJPTrasnporteAsis) {
        this.xJPTrasnporteAsis = xJPTrasnporteAsis;
    }

    @Generated
    public void setXJPCirugias(JPI_Cirugias xJPCirugias) {
        this.xJPCirugias = xJPCirugias;
    }

    @Generated
    public void setXJPCirugias1(JPI_Cirugias1 xJPCirugias1) {
        this.xJPCirugias1 = xJPCirugias1;
    }

    @Generated
    public void setXJPImpresion_Doc(JPI_Control_Impresion xJPImpresion_Doc) {
        this.xJPImpresion_Doc = xJPImpresion_Doc;
    }

    @Generated
    public void setXJPListaCHequeo(JPListaCHequeo xJPListaCHequeo) {
        this.xJPListaCHequeo = xJPListaCHequeo;
    }

    @Generated
    public void setXJPAdultoMayor(JPAdultoMayor xJPAdultoMayor) {
        this.xJPAdultoMayor = xJPAdultoMayor;
    }

    @Generated
    public void setXJIFAdultoJoven(JIFAdultoJoven xJIFAdultoJoven) {
        this.xJIFAdultoJoven = xJIFAdultoJoven;
    }

    @Generated
    public void setXJPSociodemografico(JPSociodemografico xJPSociodemografico) {
        this.xJPSociodemografico = xJPSociodemografico;
    }

    @Generated
    public void setXJPOftamologiaGen(JPOftamologiaGen xJPOftamologiaGen) {
        this.xJPOftamologiaGen = xJPOftamologiaGen;
    }

    @Generated
    public void setXjif_importardochc(JP_Cargar_DocumentosHC xjif_importardochc) {
        this.xjif_importardochc = xjif_importardochc;
    }

    @Generated
    public void setXjif_testagudeza_visual(JPI_Test_AgudezaVisual xjif_testagudeza_visual) {
        this.xjif_testagudeza_visual = xjif_testagudeza_visual;
    }

    @Generated
    public void setXJPControlPlacaCompleto(JPControlPlacaCompleto xJPControlPlacaCompleto) {
        this.xJPControlPlacaCompleto = xJPControlPlacaCompleto;
    }

    @Generated
    public void setXJIFAdultoJoven2(JIFAdultoJoven2 xJIFAdultoJoven2) {
        this.xJIFAdultoJoven2 = xJIFAdultoJoven2;
    }

    @Generated
    public void setXJPPartograma(JPPartograma xJPPartograma) {
        this.xJPPartograma = xJPPartograma;
    }

    @Generated
    public void setXJPOdontogramaClinico(JPOdontogramaClinico xJPOdontogramaClinico) {
        this.xJPOdontogramaClinico = xJPOdontogramaClinico;
    }

    @Generated
    public void setXJPPlanificacionFliar(JPPlanificacionFliar xJPPlanificacionFliar) {
        this.xJPPlanificacionFliar = xJPPlanificacionFliar;
    }

    @Generated
    public void setXJPGraficaAgenteSEG(JPGraficaAgenteSEG xJPGraficaAgenteSEG) {
        this.xJPGraficaAgenteSEG = xJPGraficaAgenteSEG;
    }

    @Generated
    public void setXJPEventoAdverso(JPEventoAdverso xJPEventoAdverso) {
        this.xJPEventoAdverso = xJPEventoAdverso;
    }

    @Generated
    public void setXJPAEvaluacionRiesgo(JPAEvaluacionRiesgo xJPAEvaluacionRiesgo) {
        this.xJPAEvaluacionRiesgo = xJPAEvaluacionRiesgo;
    }

    @Generated
    public void setXJPFramingham(JPFramingham xJPFramingham) {
        this.xJPFramingham = xJPFramingham;
    }

    @Generated
    public void setXJPFramingham1(JPFramingham1 xJPFramingham1) {
        this.xJPFramingham1 = xJPFramingham1;
    }

    @Generated
    public void setXJPFraminghamM(JPFramingham_M xJPFraminghamM) {
        this.xJPFraminghamM = xJPFraminghamM;
    }

    @Generated
    public void setXJPRuffier(JPRuffier xJPRuffier) {
        this.xJPRuffier = xJPRuffier;
    }

    @Generated
    public void setXJPTestFindrisk(JPTestFindrisk xJPTestFindrisk) {
        this.xJPTestFindrisk = xJPTestFindrisk;
    }

    @Generated
    public void setXJPRevisonExamenSo(JPRevisonExamenSo xJPRevisonExamenSo) {
        this.xJPRevisonExamenSo = xJPRevisonExamenSo;
    }

    @Generated
    public void setXJPRevisonExamenSo_V2(JPRevisonExamenSo_V2 xJPRevisonExamenSo_V2) {
        this.xJPRevisonExamenSo_V2 = xJPRevisonExamenSo_V2;
    }

    @Generated
    public void setXJPCertificadoSO(JPCertificadoSO xJPCertificadoSO) {
        this.xJPCertificadoSO = xJPCertificadoSO;
    }

    @Generated
    public void setXJPSoBiblioteca(JPSoBiblioteca xJPSoBiblioteca) {
        this.xJPSoBiblioteca = xJPSoBiblioteca;
    }

    @Generated
    public void setXJPARevisionAyudasDx(JPARevisionAyudasDx xJPARevisionAyudasDx) {
        this.xJPARevisionAyudasDx = xJPARevisionAyudasDx;
    }

    @Generated
    public void setXJPAAtencion(JPAAtencion xJPAAtencion) {
        this.xJPAAtencion = xJPAAtencion;
    }

    @Generated
    public void setXJPRSignosVitales(JPRSignosVitales xJPRSignosVitales) {
        this.xJPRSignosVitales = xJPRSignosVitales;
    }

    @Generated
    public void setXJPControlDiabetes(JPControlDiabetes xJPControlDiabetes) {
        this.xJPControlDiabetes = xJPControlDiabetes;
    }

    @Generated
    public void setXJPIExamenClinicoPE(JPIExamenClinicoPE xJPIExamenClinicoPE) {
        this.xJPIExamenClinicoPE = xJPIExamenClinicoPE;
    }

    @Generated
    public void setXJPAAntecentesFamiliares(JPAAntecentesFamiliares xJPAAntecentesFamiliares) {
        this.xJPAAntecentesFamiliares = xJPAAntecentesFamiliares;
    }

    @Generated
    public void setXJPAAntecentesHabitos(JPAAntecentesHabitos xJPAAntecentesHabitos) {
        this.xJPAAntecentesHabitos = xJPAAntecentesHabitos;
    }

    @Generated
    public void setXJPAAntecentesPPersonales(JPAAntecentesPPersonales xJPAAntecentesPPersonales) {
        this.xJPAAntecentesPPersonales = xJPAAntecentesPPersonales;
    }

    @Generated
    public void setXJPAAPatologiasAsociadas(JPAAPatologiasAsociadas xJPAAPatologiasAsociadas) {
        this.xJPAAPatologiasAsociadas = xJPAAPatologiasAsociadas;
    }

    @Generated
    public void setXJPAAntecedentesPediatricos(JPAAntecedentesPediatricos xJPAAntecedentesPediatricos) {
        this.xJPAAntecedentesPediatricos = xJPAAntecedentesPediatricos;
    }

    @Generated
    public void setXJPAAntecentesOdontologicos(JPAAntecentesOdontologicos xJPAAntecentesOdontologicos) {
        this.xJPAAntecentesOdontologicos = xJPAAntecentesOdontologicos;
    }

    @Generated
    public void setXJPAExamenFisico(JPAExamenFisico xJPAExamenFisico) {
        this.xJPAExamenFisico = xJPAExamenFisico;
    }

    @Generated
    public void setXJPAHExamenFisico(JPAHExamenFisico xJPAHExamenFisico) {
        this.xJPAHExamenFisico = xJPAHExamenFisico;
    }

    @Generated
    public void setXJPRiesgoBiosicoSocial(JPRiesgoBiosicoSocial xJPRiesgoBiosicoSocial) {
        this.xJPRiesgoBiosicoSocial = xJPRiesgoBiosicoSocial;
    }

    @Generated
    public void setXJPEgresoUrgencias(JPEgresoUrgencias xJPEgresoUrgencias) {
        this.xJPEgresoUrgencias = xJPEgresoUrgencias;
    }

    @Generated
    public void setXJPAAntecedenteGineco(JPAAntecedenteGineco xJPAAntecedenteGineco) {
        this.xJPAAntecedenteGineco = xJPAAntecedenteGineco;
    }

    @Generated
    public void setXJPAAntecedenteGineco_Nuevo(JPAAntecedenteGineco_Nuevo xJPAAntecedenteGineco_Nuevo) {
        this.xJPAAntecedenteGineco_Nuevo = xJPAAntecedenteGineco_Nuevo;
    }

    @Generated
    public void setXJPATestMorisky(JPATestMorisky xJPATestMorisky) {
        this.xJPATestMorisky = xJPATestMorisky;
    }

    @Generated
    public void setXJPASaludOcupacional(JPASaludOcupacional xJPASaludOcupacional) {
        this.xJPASaludOcupacional = xJPASaludOcupacional;
    }

    @Generated
    public void setXJPAEcografiaObstetrica(JPAEcografiaObstetrica xJPAEcografiaObstetrica) {
        this.xJPAEcografiaObstetrica = xJPAEcografiaObstetrica;
    }

    @Generated
    public void setXJPGaleriaImagenes(JPGaleriaImagenes xJPGaleriaImagenes) {
        this.xJPGaleriaImagenes = xJPGaleriaImagenes;
    }

    @Generated
    public void setXJPEscalaDolor(JPEscalaDolor xJPEscalaDolor) {
        this.xJPEscalaDolor = xJPEscalaDolor;
    }

    @Generated
    public void setXJPEscalaFuerzaMuscular(JPEscalaFuerzaMuscular xJPEscalaFuerzaMuscular) {
        this.xJPEscalaFuerzaMuscular = xJPEscalaFuerzaMuscular;
    }

    @Generated
    public void setXJPAFonoaudiologia(JPAFonoaudiologia xJPAFonoaudiologia) {
        this.xJPAFonoaudiologia = xJPAFonoaudiologia;
    }

    @Generated
    public void setXJPAAntecedenteReumatologia(JPAAntecedenteReumatologia xJPAAntecedenteReumatologia) {
        this.xJPAAntecedenteReumatologia = xJPAAntecedenteReumatologia;
    }

    @Generated
    public void setXJPATamizajeEstetico(JPATamizajeEstetico xJPATamizajeEstetico) {
        this.xJPATamizajeEstetico = xJPATamizajeEstetico;
    }

    @Generated
    public void setXJPSo_Psicomotriz(JPSo_Psicomotriz xJPSo_Psicomotriz) {
        this.xJPSo_Psicomotriz = xJPSo_Psicomotriz;
    }

    @Generated
    public void setXJPDepresionPosparto(JPDepresionPosparto xJPDepresionPosparto) {
        this.xJPDepresionPosparto = xJPDepresionPosparto;
    }

    @Generated
    public void setXJPMaltratoViolencia(JPMaltratoViolencia xJPMaltratoViolencia) {
        this.xJPMaltratoViolencia = xJPMaltratoViolencia;
    }

    @Generated
    public void setXJPReuConteoArticulaciones(JPReuConteoArticulaciones xJPReuConteoArticulaciones) {
        this.xJPReuConteoArticulaciones = xJPReuConteoArticulaciones;
    }

    @Generated
    public void setXJPAClasificacionEular(JPAClasificacionEular xJPAClasificacionEular) {
        this.xJPAClasificacionEular = xJPAClasificacionEular;
    }

    @Generated
    public void setXJPCuestionarioHAQ(JPCuestionarioHAQ xJPCuestionarioHAQ) {
        this.xJPCuestionarioHAQ = xJPCuestionarioHAQ;
    }

    @Generated
    public void setXJPSo_VisiometriaMineros(JPSo_VisiometriaMineros xJPSo_VisiometriaMineros) {
        this.xJPSo_VisiometriaMineros = xJPSo_VisiometriaMineros;
    }

    @Generated
    public void setXJPAntecedentesPersonalesTabla(JPA_AntecedentesPersonalesTabla xJPAntecedentesPersonalesTabla) {
        this.xJPAntecedentesPersonalesTabla = xJPAntecedentesPersonalesTabla;
    }

    @Generated
    public void setXRevisionSistemasTabla(JPA_RevisionSistemasTabla xRevisionSistemasTabla) {
        this.xRevisionSistemasTabla = xRevisionSistemasTabla;
    }

    @Generated
    public void setXJPAAntecedentesGinecobstetricos(JPAAntecedentesGinecobstetricos xJPAAntecedentesGinecobstetricos) {
        this.xJPAAntecedentesGinecobstetricos = xJPAAntecedentesGinecobstetricos;
    }

    @Generated
    public void setXJPA_Atencion_InformacionN10(JPA_Atencion_InformacionN10 xJPA_Atencion_InformacionN10) {
        this.xJPA_Atencion_InformacionN10 = xJPA_Atencion_InformacionN10;
    }

    @Generated
    public void setAntecedenteFamiliarTexto(JPAntecedenteFamiliarTexto antecedenteFamiliarTexto) {
        this.antecedenteFamiliarTexto = antecedenteFamiliarTexto;
    }

    @Generated
    public void setXNotasMedicasNa(JPA_NotasMedicasN xNotasMedicasNa) {
        this.xNotasMedicasNa = xNotasMedicasNa;
    }

    @Generated
    public void setXJPAFamiliograma(JPAFamiliograma xJPAFamiliograma) {
        this.xJPAFamiliograma = xJPAFamiliograma;
    }

    @Generated
    public void setXA_NotasProcedimientosMenores(JPA_NotasProcedimientosMenores xA_NotasProcedimientosMenores) {
        this.xA_NotasProcedimientosMenores = xA_NotasProcedimientosMenores;
    }

    @Generated
    public void setJPAEscalaAbreviadaDeDesarrollo(JPAEscalaAbreviadaDeDesarrollo jPAEscalaAbreviadaDeDesarrollo) {
        this.jPAEscalaAbreviadaDeDesarrollo = jPAEscalaAbreviadaDeDesarrollo;
    }

    @Generated
    public void setJPAEscalaAbreviadaDeDesarrollo_V2(JPAEscalaAbreviadaDeDesarrollo_V2 jPAEscalaAbreviadaDeDesarrollo_V2) {
        this.jPAEscalaAbreviadaDeDesarrollo_V2 = jPAEscalaAbreviadaDeDesarrollo_V2;
    }

    @Generated
    public void setControlOxigeno(JPControlOxigeno controlOxigeno) {
        this.controlOxigeno = controlOxigeno;
    }

    @Generated
    public void setControlLiquidos(JPControlLiquidos controlLiquidos) {
        this.controlLiquidos = controlLiquidos;
    }

    @Generated
    public void setDatosPyP(JP_CP_DatosPyP datosPyP) {
        this.datosPyP = datosPyP;
    }

    @Generated
    public void setActividadesPyP(JPAActividadesPyP actividadesPyP) {
        this.actividadesPyP = actividadesPyP;
    }

    @Generated
    public void setAlimentacion(Alimentacion alimentacion) {
        this.alimentacion = alimentacion;
    }

    @Generated
    public void setMotricidadFina(MotricidadFina motricidadFina) {
        this.motricidadFina = motricidadFina;
    }

    @Generated
    public void setMotricidadGruesa(MotricidadGruesa motricidadGruesa) {
        this.motricidadGruesa = motricidadGruesa;
    }

    @Generated
    public void setValoracionLenguaje(ValoracionLenguaje valoracionLenguaje) {
        this.valoracionLenguaje = valoracionLenguaje;
    }

    @Generated
    public void setValoracionPersonal(ValoracionPersonal valoracionPersonal) {
        this.valoracionPersonal = valoracionPersonal;
    }

    @Generated
    public void setValoracionResultado(ValoracionResultado valoracionResultado) {
        this.valoracionResultado = valoracionResultado;
    }

    @Generated
    public void setAAntecentesOcupacionales(JPAAntecentesOcupacionales aAntecentesOcupacionales) {
        this.aAntecentesOcupacionales = aAntecentesOcupacionales;
    }

    @Generated
    public void setAAntecentesOcupacionalesNuevo(JPAAntecentesOcupacionalesNuevo aAntecentesOcupacionalesNuevo) {
        this.aAntecentesOcupacionalesNuevo = aAntecentesOcupacionalesNuevo;
    }

    @Generated
    public void setDatosPyP1(JP_CP_DatosPyP datosPyP1) {
        this.datosPyP1 = datosPyP1;
    }

    @Generated
    public void setAlertasGeneralesDAO(AlertasGeneralesDAO alertasGeneralesDAO) {
        this.alertasGeneralesDAO = alertasGeneralesDAO;
    }

    @Generated
    public void setRevisionAyudasDx_Nueva(JPARevisionAyudasDx_Nueva revisionAyudasDx_Nueva) {
        this.revisionAyudasDx_Nueva = revisionAyudasDx_Nueva;
    }

    @Generated
    public void setXJPGlasgow(JPGlasgow xJPGlasgow) {
        this.xJPGlasgow = xJPGlasgow;
    }

    @Generated
    public void setXct(ConsultasMySQL xct) {
        this.xct = xct;
    }

    @Generated
    public void setEvaluacionRecienNacido(JPAEvaluacionRecienNacido evaluacionRecienNacido) {
        this.evaluacionRecienNacido = evaluacionRecienNacido;
    }

    @Generated
    public void setJPaVale(JPAVale jPaVale) {
        this.jPaVale = jPaVale;
    }

    @Generated
    public void setJPAListaChequeo(JPAListaChequeo jPAListaChequeo) {
        this.jPAListaChequeo = jPAListaChequeo;
    }

    @Generated
    public void setJPATestSmokingAndSubstance(JPATestSmokingAndSubstance jPATestSmokingAndSubstance) {
        this.jPATestSmokingAndSubstance = jPATestSmokingAndSubstance;
    }

    @Generated
    public void setJpAntecedentesFisicosPsiquiatricos(JPAntecedentesFisicosPsiquiatricos jpAntecedentesFisicosPsiquiatricos) {
        this.jpAntecedentesFisicosPsiquiatricos = jpAntecedentesFisicosPsiquiatricos;
    }

    @Generated
    public void setFormularioAnexo3(JPI_FormularioAnexo3 formularioAnexo3) {
        this.formularioAnexo3 = formularioAnexo3;
    }

    @Generated
    public void setFormularioAnexo2(JPI_FormularioAnexo2 formularioAnexo2) {
        this.formularioAnexo2 = formularioAnexo2;
    }

    @Generated
    public void setTriageRespiratorio(JPTriageRespiratorio triageRespiratorio) {
        this.triageRespiratorio = triageRespiratorio;
    }

    @Generated
    public void setTriageRespiratorio_V2(JPTriageRespiratorio_V2 triageRespiratorio_V2) {
        this.triageRespiratorio_V2 = triageRespiratorio_V2;
    }

    @Generated
    public void setXJPAtencionDieta(JPAtencionDieta xJPAtencionDieta) {
        this.xJPAtencionDieta = xJPAtencionDieta;
    }

    @Generated
    public void setTestCrb65(JPA_TestCrb65 testCrb65) {
        this.testCrb65 = testCrb65;
    }

    @Generated
    public void setXJPGraficasPyPTierraAlta(JPGraficasPyPTierraAlta xJPGraficasPyPTierraAlta) {
        this.xJPGraficasPyPTierraAlta = xJPGraficasPyPTierraAlta;
    }

    @Generated
    public void setXJPGraficasPyPTierraAlta_v2(JPGraficasPyPTierraAlta_v2 xJPGraficasPyPTierraAlta_v2) {
        this.xJPGraficasPyPTierraAlta_v2 = xJPGraficasPyPTierraAlta_v2;
    }

    @Generated
    public void setXIngresoHTAyDM(JP_PyP_DMyHTA xIngresoHTAyDM) {
        this.xIngresoHTAyDM = xIngresoHTAyDM;
    }

    @Generated
    public void setXJP_IngresoProgramaCyD(JP_IngresoProgramaCyD xJP_IngresoProgramaCyD) {
        this.xJP_IngresoProgramaCyD = xJP_IngresoProgramaCyD;
    }

    @Generated
    public void setXJPAiepiAtencionMadres(JPAiepiAtencionMadres xJPAiepiAtencionMadres) {
        this.xJPAiepiAtencionMadres = xJPAiepiAtencionMadres;
    }

    @Generated
    public void setXjPPeligros(JPPeligros xjPPeligros) {
        this.xjPPeligros = xjPPeligros;
    }

    @Generated
    public void setAiepiOncologicoTest(JPAiepiOncologicoTest aiepiOncologicoTest) {
        this.aiepiOncologicoTest = aiepiOncologicoTest;
    }

    @Generated
    public void setPueba1(String pueba1) {
        this.pueba1 = pueba1;
    }

    @Generated
    public void setAtencionesVisionIPS(JPHistoricoAtencionesVisionIPS atencionesVisionIPS) {
        this.atencionesVisionIPS = atencionesVisionIPS;
    }

    @Generated
    public void setJPIngresoPlanificacionFamiliar(JPIngresoPlanificacionFamiliar jPIngresoPlanificacionFamiliar) {
        this.jPIngresoPlanificacionFamiliar = jPIngresoPlanificacionFamiliar;
    }

    @Generated
    public JPAAtencion getPAAtencion() {
        return this.pAAtencion;
    }

    @Generated
    public JPARevisionSistemas getXJPARevisionSistemas() {
        return this.xJPARevisionSistemas;
    }

    @Generated
    public JPARevisionAyudasDxS getXJPARevisionAyudasDxS() {
        return this.xJPARevisionAyudasDxS;
    }

    @Generated
    public JPARevisionAyudasDxRx getXJPARevisionAyudasDxRx() {
        return this.xJPARevisionAyudasDxRx;
    }

    @Generated
    public JPRxOdontologia getXJPRxOdontologia() {
        return this.xJPRxOdontologia;
    }

    @Generated
    public JPIOrden_Tratamiento getXjiftratamiento() {
        return this.xjiftratamiento;
    }

    @Generated
    public JPIOrden_Tratamiento_Nueva getOrden_Tratamiento_Nueva() {
        return this.orden_Tratamiento_Nueva;
    }

    @Generated
    public JPADiagnostico getXJPADiagnostico() {
        return this.xJPADiagnostico;
    }

    @Generated
    public JPFichaUsuario getFichaUsuario() {
        return this.fichaUsuario;
    }

    @Generated
    public JP_ExamenFisicoI getExamenFisicoI() {
        return this.examenFisicoI;
    }

    @Generated
    public JP_ExamenFisicoSo getExamenFisicoSo() {
        return this.examenFisicoSo;
    }

    @Generated
    public JP_ExamenFisicoI1 getExamenFisicoI1() {
        return this.examenFisicoI1;
    }

    @Generated
    public JPHistoricoAtenciones getHistoricoAtenciones() {
        return this.historicoAtenciones;
    }

    @Generated
    public JPI_Test_AgudezaVisual getAgudezaVisual() {
        return this.agudezaVisual;
    }

    @Generated
    public JPOOrdenSuministroH getXjpsuministroh() {
        return this.xjpsuministroh;
    }

    @Generated
    public JPOOrdenProcedimientosH getXjpprocedimientosh() {
        return this.xjpprocedimientosh;
    }

    @Generated
    public JPORemisiones getXjpremisiones() {
        return this.xjpremisiones;
    }

    @Generated
    public JPORemisiones1 getXjpremisiones1() {
        return this.xjpremisiones1;
    }

    @Generated
    public JPAIncapacidad getXjpincapacidad() {
        return this.xjpincapacidad;
    }

    @Generated
    public JPAIncapacidad_v2 getAIncapacidad_v2() {
        return this.aIncapacidad_v2;
    }

    @Generated
    public JPAEventoNoDeseado getXjpeventonodeseado() {
        return this.xjpeventonodeseado;
    }

    @Generated
    public JPPermisosMedicos getXjppermisos() {
        return this.xjppermisos;
    }

    @Generated
    public JPANotas getXjpnotas() {
        return this.xjpnotas;
    }

    @Generated
    public JPANotas_v2 getXjpnotas1() {
        return this.xjpnotas1;
    }

    @Generated
    public JPHNutricional getXjpnutricion() {
        return this.xjpnutricion;
    }

    @Generated
    public JPAConclusion getXjifconclusion() {
        return this.xjifconclusion;
    }

    @Generated
    public JP_CP_ResultadoExamenes1 getXjifpyprevisionexamenes() {
        return this.xjifpyprevisionexamenes;
    }

    @Generated
    public JPSo_Visiometria getXjifvisiometria() {
        return this.xjifvisiometria;
    }

    @Generated
    public JPSo_VisiometriaFPZ getXjifvisiometriafpz() {
        return this.xjifvisiometriafpz;
    }

    @Generated
    public JPSo_VisiometriaG getXjifvisiometriaG() {
        return this.xjifvisiometriaG;
    }

    @Generated
    public JPSo_Espirometria getXjifespirometria() {
        return this.xjifespirometria;
    }

    @Generated
    public JPSo_EspirometriaSI getXjifespirometriaSI() {
        return this.xjifespirometriaSI;
    }

    @Generated
    public JPSo_Audiometria getXjifaudiometria() {
        return this.xjifaudiometria;
    }

    @Generated
    public JPSo_Audiometria_nueva1 getAudiometria_nueva1() {
        return this.audiometria_nueva1;
    }

    @Generated
    public JPSo_Concepto_E getXjifconceptoso_e() {
        return this.xjifconceptoso_e;
    }

    @Generated
    public JPSo_Concepto_I getXjifconceptosio_i() {
        return this.xjifconceptosio_i;
    }

    @Generated
    public JPSo_Concepto_R getConcepto_R() {
        return this.concepto_R;
    }

    @Generated
    public JPSo_Osteomuscular getXjifosteomuscuar() {
        return this.xjifosteomuscuar;
    }

    @Generated
    public JPAEcografiaGenerico getXjifecografiagenerico() {
        return this.xjifecografiagenerico;
    }

    @Generated
    public JPAColposcopia getXjifcolposcopia() {
        return this.xjifcolposcopia;
    }

    @Generated
    public JPSo_PEjercicio getXjifprescripcionejercicio() {
        return this.xjifprescripcionejercicio;
    }

    @Generated
    public JPSo_Optometria getXjifoptometria() {
        return this.xjifoptometria;
    }

    @Generated
    public JP_Optometria getJP_Optometria() {
        return this.jP_Optometria;
    }

    @Generated
    public JPSo_Cuestionarios getXjifcuestionarios() {
        return this.xjifcuestionarios;
    }

    @Generated
    public JPSo_Cuestionario_N getXjifcuestionarios_n() {
        return this.xjifcuestionarios_n;
    }

    @Generated
    public JPSo_Test_PRespiratorio getXjiftest_prespiratorio() {
        return this.xjiftest_prespiratorio;
    }

    @Generated
    public JPHistoricoAtenciones getXjifhatenciones() {
        return this.xjifhatenciones;
    }

    @Generated
    public JPPruebaAyD getXjifpruebaayd() {
        return this.xjifpruebaayd;
    }

    @Generated
    public JPOdontograma getXjifOdontograma() {
        return this.xjifOdontograma;
    }

    @Generated
    public JPControlPlaca getXjifControlPlaca() {
        return this.xjifControlPlaca;
    }

    @Generated
    public JPTestFatiga getXjptestfatiga() {
        return this.xjptestfatiga;
    }

    @Generated
    public JPAEcografiaPelvica getXjifecografiap() {
        return this.xjifecografiap;
    }

    @Generated
    public JP_PyP_HTA getXjifHTA() {
        return this.xjifHTA;
    }

    @Generated
    public JP_PyP_Diabetes getXjifdiabetes() {
        return this.xjifdiabetes;
    }

    @Generated
    public JPExamenDentario getXJPExamenDentario() {
        return this.xJPExamenDentario;
    }

    @Generated
    public JPOclusion getXJPOclusion() {
        return this.xJPOclusion;
    }

    @Generated
    public JPITriage getXjptriage() {
        return this.xjptriage;
    }

    @Generated
    public String getXnombre() {
        return this.xnombre;
    }

    @Generated
    public JPEndoExamenClinico getXJPEndoExamenClinico() {
        return this.xJPEndoExamenClinico;
    }

    @Generated
    public JPOdontogramaInicial getXJPOdontogramaInicial() {
        return this.xJPOdontogramaInicial;
    }

    @Generated
    public JPCefalometria getXJPCefalometria() {
        return this.xJPCefalometria;
    }

    @Generated
    public JPAnalisiOclusal getXJPAnalisiOclusal() {
        return this.xJPAnalisiOclusal;
    }

    @Generated
    public JPAnalisisEstomatologico getXJPAnalisisEstomatologico() {
        return this.xJPAnalisisEstomatologico;
    }

    @Generated
    public JPAnalisisFuncional getXJPAnalisisFuncional() {
        return this.xJPAnalisisFuncional;
    }

    @Generated
    public JPGestionRiesgo_Dm getXjpgestionriesgo() {
        return this.xjpgestionriesgo;
    }

    @Generated
    public JPISeguimiento_Pac getXjifseguimiento() {
        return this.xjifseguimiento;
    }

    @Generated
    public JPGestionRiesgo_Hta getXjpgestionriesgohta() {
        return this.xjpgestionriesgohta;
    }

    @Generated
    public JPEscalaAbreviada getXJPEscalaAbreviada() {
        return this.xJPEscalaAbreviada;
    }

    @Generated
    public JPFiltroIFG getXJPFiltroIFG() {
        return this.xJPFiltroIFG;
    }

    @Generated
    public JPVacunacion getXJPVacunacion() {
        return this.xJPVacunacion;
    }

    @Generated
    public JPAExamenFisicoPrenatal getXJPAExamenFisicoPrenatal() {
        return this.xJPAExamenFisicoPrenatal;
    }

    @Generated
    public JPAExamenFisicoPrenatal_v2 getXJPAExamenFisicoPrenatal_v2() {
        return this.xJPAExamenFisicoPrenatal_v2;
    }

    @Generated
    public JPGraficasPyP getXJPGraficasPyP() {
        return this.xJPGraficasPyP;
    }

    @Generated
    public JPSo_CuestionarioSico getXJPSo_CuestionarioSico() {
        return this.xJPSo_CuestionarioSico;
    }

    @Generated
    public JPHistoria_Terapias getXjif_terapiaf() {
        return this.xjif_terapiaf;
    }

    @Generated
    public JPAiepi getXJPAiepi() {
        return this.xJPAiepi;
    }

    @Generated
    public JPAiepiNinos getXJPAiepiNinos() {
        return this.xJPAiepiNinos;
    }

    @Generated
    public JPAiepiMadres getXJPAiepiMadres() {
        return this.xJPAiepiMadres;
    }

    @Generated
    public JPTransfuciones getXJPTransfuciones() {
        return this.xJPTransfuciones;
    }

    @Generated
    public JPTrasnporteAsis getXJPTrasnporteAsis() {
        return this.xJPTrasnporteAsis;
    }

    @Generated
    public JPI_Cirugias getXJPCirugias() {
        return this.xJPCirugias;
    }

    @Generated
    public JPI_Cirugias1 getXJPCirugias1() {
        return this.xJPCirugias1;
    }

    @Generated
    public JPI_Control_Impresion getXJPImpresion_Doc() {
        return this.xJPImpresion_Doc;
    }

    @Generated
    public JPListaCHequeo getXJPListaCHequeo() {
        return this.xJPListaCHequeo;
    }

    @Generated
    public JPAdultoMayor getXJPAdultoMayor() {
        return this.xJPAdultoMayor;
    }

    @Generated
    public JIFAdultoJoven getXJIFAdultoJoven() {
        return this.xJIFAdultoJoven;
    }

    @Generated
    public JPSociodemografico getXJPSociodemografico() {
        return this.xJPSociodemografico;
    }

    @Generated
    public JPOftamologiaGen getXJPOftamologiaGen() {
        return this.xJPOftamologiaGen;
    }

    @Generated
    public JP_Cargar_DocumentosHC getXjif_importardochc() {
        return this.xjif_importardochc;
    }

    @Generated
    public JPI_Test_AgudezaVisual getXjif_testagudeza_visual() {
        return this.xjif_testagudeza_visual;
    }

    @Generated
    public JPControlPlacaCompleto getXJPControlPlacaCompleto() {
        return this.xJPControlPlacaCompleto;
    }

    @Generated
    public JIFAdultoJoven2 getXJIFAdultoJoven2() {
        return this.xJIFAdultoJoven2;
    }

    @Generated
    public JPPartograma getXJPPartograma() {
        return this.xJPPartograma;
    }

    @Generated
    public JPOdontogramaClinico getXJPOdontogramaClinico() {
        return this.xJPOdontogramaClinico;
    }

    @Generated
    public JPPlanificacionFliar getXJPPlanificacionFliar() {
        return this.xJPPlanificacionFliar;
    }

    @Generated
    public JPGraficaAgenteSEG getXJPGraficaAgenteSEG() {
        return this.xJPGraficaAgenteSEG;
    }

    @Generated
    public JPEventoAdverso getXJPEventoAdverso() {
        return this.xJPEventoAdverso;
    }

    @Generated
    public JPAEvaluacionRiesgo getXJPAEvaluacionRiesgo() {
        return this.xJPAEvaluacionRiesgo;
    }

    @Generated
    public JPFramingham getXJPFramingham() {
        return this.xJPFramingham;
    }

    @Generated
    public JPFramingham1 getXJPFramingham1() {
        return this.xJPFramingham1;
    }

    @Generated
    public JPFramingham_M getXJPFraminghamM() {
        return this.xJPFraminghamM;
    }

    @Generated
    public JPRuffier getXJPRuffier() {
        return this.xJPRuffier;
    }

    @Generated
    public JPTestFindrisk getXJPTestFindrisk() {
        return this.xJPTestFindrisk;
    }

    @Generated
    public JPRevisonExamenSo getXJPRevisonExamenSo() {
        return this.xJPRevisonExamenSo;
    }

    @Generated
    public JPRevisonExamenSo_V2 getXJPRevisonExamenSo_V2() {
        return this.xJPRevisonExamenSo_V2;
    }

    @Generated
    public JPCertificadoSO getXJPCertificadoSO() {
        return this.xJPCertificadoSO;
    }

    @Generated
    public JPSoBiblioteca getXJPSoBiblioteca() {
        return this.xJPSoBiblioteca;
    }

    @Generated
    public JPARevisionAyudasDx getXJPARevisionAyudasDx() {
        return this.xJPARevisionAyudasDx;
    }

    @Generated
    public JPAAtencion getXJPAAtencion() {
        return this.xJPAAtencion;
    }

    @Generated
    public JPRSignosVitales getXJPRSignosVitales() {
        return this.xJPRSignosVitales;
    }

    @Generated
    public JPControlDiabetes getXJPControlDiabetes() {
        return this.xJPControlDiabetes;
    }

    @Generated
    public JPIExamenClinicoPE getXJPIExamenClinicoPE() {
        return this.xJPIExamenClinicoPE;
    }

    @Generated
    public JPAAntecentesFamiliares getXJPAAntecentesFamiliares() {
        return this.xJPAAntecentesFamiliares;
    }

    @Generated
    public JPAAntecentesHabitos getXJPAAntecentesHabitos() {
        return this.xJPAAntecentesHabitos;
    }

    @Generated
    public JPAAntecentesPPersonales getXJPAAntecentesPPersonales() {
        return this.xJPAAntecentesPPersonales;
    }

    @Generated
    public JPAAPatologiasAsociadas getXJPAAPatologiasAsociadas() {
        return this.xJPAAPatologiasAsociadas;
    }

    @Generated
    public JPAAntecedentesPediatricos getXJPAAntecedentesPediatricos() {
        return this.xJPAAntecedentesPediatricos;
    }

    @Generated
    public JPAAntecentesOdontologicos getXJPAAntecentesOdontologicos() {
        return this.xJPAAntecentesOdontologicos;
    }

    @Generated
    public JPAExamenFisico getXJPAExamenFisico() {
        return this.xJPAExamenFisico;
    }

    @Generated
    public JPAHExamenFisico getXJPAHExamenFisico() {
        return this.xJPAHExamenFisico;
    }

    @Generated
    public JPRiesgoBiosicoSocial getXJPRiesgoBiosicoSocial() {
        return this.xJPRiesgoBiosicoSocial;
    }

    @Generated
    public JPEgresoUrgencias getXJPEgresoUrgencias() {
        return this.xJPEgresoUrgencias;
    }

    @Generated
    public JPAAntecedenteGineco getXJPAAntecedenteGineco() {
        return this.xJPAAntecedenteGineco;
    }

    @Generated
    public JPAAntecedenteGineco_Nuevo getXJPAAntecedenteGineco_Nuevo() {
        return this.xJPAAntecedenteGineco_Nuevo;
    }

    @Generated
    public JPATestMorisky getXJPATestMorisky() {
        return this.xJPATestMorisky;
    }

    @Generated
    public JPASaludOcupacional getXJPASaludOcupacional() {
        return this.xJPASaludOcupacional;
    }

    @Generated
    public JPAEcografiaObstetrica getXJPAEcografiaObstetrica() {
        return this.xJPAEcografiaObstetrica;
    }

    @Generated
    public JPGaleriaImagenes getXJPGaleriaImagenes() {
        return this.xJPGaleriaImagenes;
    }

    @Generated
    public JPEscalaDolor getXJPEscalaDolor() {
        return this.xJPEscalaDolor;
    }

    @Generated
    public JPEscalaFuerzaMuscular getXJPEscalaFuerzaMuscular() {
        return this.xJPEscalaFuerzaMuscular;
    }

    @Generated
    public JPAFonoaudiologia getXJPAFonoaudiologia() {
        return this.xJPAFonoaudiologia;
    }

    @Generated
    public JPAAntecedenteReumatologia getXJPAAntecedenteReumatologia() {
        return this.xJPAAntecedenteReumatologia;
    }

    @Generated
    public JPATamizajeEstetico getXJPATamizajeEstetico() {
        return this.xJPATamizajeEstetico;
    }

    @Generated
    public JPSo_Psicomotriz getXJPSo_Psicomotriz() {
        return this.xJPSo_Psicomotriz;
    }

    @Generated
    public JPDepresionPosparto getXJPDepresionPosparto() {
        return this.xJPDepresionPosparto;
    }

    @Generated
    public JPMaltratoViolencia getXJPMaltratoViolencia() {
        return this.xJPMaltratoViolencia;
    }

    @Generated
    public JPReuConteoArticulaciones getXJPReuConteoArticulaciones() {
        return this.xJPReuConteoArticulaciones;
    }

    @Generated
    public JPAClasificacionEular getXJPAClasificacionEular() {
        return this.xJPAClasificacionEular;
    }

    @Generated
    public JPCuestionarioHAQ getXJPCuestionarioHAQ() {
        return this.xJPCuestionarioHAQ;
    }

    @Generated
    public JPSo_VisiometriaMineros getXJPSo_VisiometriaMineros() {
        return this.xJPSo_VisiometriaMineros;
    }

    @Generated
    public JPA_AntecedentesPersonalesTabla getXJPAntecedentesPersonalesTabla() {
        return this.xJPAntecedentesPersonalesTabla;
    }

    @Generated
    public JPA_RevisionSistemasTabla getXRevisionSistemasTabla() {
        return this.xRevisionSistemasTabla;
    }

    @Generated
    public JPAAntecedentesGinecobstetricos getXJPAAntecedentesGinecobstetricos() {
        return this.xJPAAntecedentesGinecobstetricos;
    }

    @Generated
    public JPA_Atencion_InformacionN10 getXJPA_Atencion_InformacionN10() {
        return this.xJPA_Atencion_InformacionN10;
    }

    @Generated
    public JPAntecedenteFamiliarTexto getAntecedenteFamiliarTexto() {
        return this.antecedenteFamiliarTexto;
    }

    @Generated
    public JPA_NotasMedicasN getXNotasMedicasNa() {
        return this.xNotasMedicasNa;
    }

    @Generated
    public JPAFamiliograma getXJPAFamiliograma() {
        return this.xJPAFamiliograma;
    }

    @Generated
    public JPA_NotasProcedimientosMenores getXA_NotasProcedimientosMenores() {
        return this.xA_NotasProcedimientosMenores;
    }

    @Generated
    public JPAEscalaAbreviadaDeDesarrollo getJPAEscalaAbreviadaDeDesarrollo() {
        return this.jPAEscalaAbreviadaDeDesarrollo;
    }

    @Generated
    public JPAEscalaAbreviadaDeDesarrollo_V2 getJPAEscalaAbreviadaDeDesarrollo_V2() {
        return this.jPAEscalaAbreviadaDeDesarrollo_V2;
    }

    @Generated
    public JPControlOxigeno getControlOxigeno() {
        return this.controlOxigeno;
    }

    @Generated
    public JPControlLiquidos getControlLiquidos() {
        return this.controlLiquidos;
    }

    @Generated
    public JP_CP_DatosPyP getDatosPyP() {
        return this.datosPyP;
    }

    @Generated
    public JPAActividadesPyP getActividadesPyP() {
        return this.actividadesPyP;
    }

    @Generated
    public Alimentacion getAlimentacion() {
        return this.alimentacion;
    }

    @Generated
    public MotricidadFina getMotricidadFina() {
        return this.motricidadFina;
    }

    @Generated
    public MotricidadGruesa getMotricidadGruesa() {
        return this.motricidadGruesa;
    }

    @Generated
    public ValoracionLenguaje getValoracionLenguaje() {
        return this.valoracionLenguaje;
    }

    @Generated
    public ValoracionPersonal getValoracionPersonal() {
        return this.valoracionPersonal;
    }

    @Generated
    public ValoracionResultado getValoracionResultado() {
        return this.valoracionResultado;
    }

    @Generated
    public JPAAntecentesOcupacionales getAAntecentesOcupacionales() {
        return this.aAntecentesOcupacionales;
    }

    @Generated
    public JPAAntecentesOcupacionalesNuevo getAAntecentesOcupacionalesNuevo() {
        return this.aAntecentesOcupacionalesNuevo;
    }

    @Generated
    public JP_CP_DatosPyP getDatosPyP1() {
        return this.datosPyP1;
    }

    @Generated
    public AlertasGeneralesDAO getAlertasGeneralesDAO() {
        return this.alertasGeneralesDAO;
    }

    @Generated
    public JPARevisionAyudasDx_Nueva getRevisionAyudasDx_Nueva() {
        return this.revisionAyudasDx_Nueva;
    }

    @Generated
    public JPGlasgow getXJPGlasgow() {
        return this.xJPGlasgow;
    }

    @Generated
    public ConsultasMySQL getXct() {
        return this.xct;
    }

    @Generated
    public JPAEvaluacionRecienNacido getEvaluacionRecienNacido() {
        return this.evaluacionRecienNacido;
    }

    @Generated
    public JPAVale getJPaVale() {
        return this.jPaVale;
    }

    @Generated
    public JPAListaChequeo getJPAListaChequeo() {
        return this.jPAListaChequeo;
    }

    @Generated
    public JPATestSmokingAndSubstance getJPATestSmokingAndSubstance() {
        return this.jPATestSmokingAndSubstance;
    }

    @Generated
    public JPAntecedentesFisicosPsiquiatricos getJpAntecedentesFisicosPsiquiatricos() {
        return this.jpAntecedentesFisicosPsiquiatricos;
    }

    @Generated
    public JPI_FormularioAnexo3 getFormularioAnexo3() {
        return this.formularioAnexo3;
    }

    @Generated
    public JPI_FormularioAnexo2 getFormularioAnexo2() {
        return this.formularioAnexo2;
    }

    @Generated
    public JPTriageRespiratorio getTriageRespiratorio() {
        return this.triageRespiratorio;
    }

    @Generated
    public JPTriageRespiratorio_V2 getTriageRespiratorio_V2() {
        return this.triageRespiratorio_V2;
    }

    @Generated
    public JPAtencionDieta getXJPAtencionDieta() {
        return this.xJPAtencionDieta;
    }

    @Generated
    public JPA_TestCrb65 getTestCrb65() {
        return this.testCrb65;
    }

    @Generated
    public JPGraficasPyPTierraAlta getXJPGraficasPyPTierraAlta() {
        return this.xJPGraficasPyPTierraAlta;
    }

    @Generated
    public JPGraficasPyPTierraAlta_v2 getXJPGraficasPyPTierraAlta_v2() {
        return this.xJPGraficasPyPTierraAlta_v2;
    }

    @Generated
    public JP_PyP_DMyHTA getXIngresoHTAyDM() {
        return this.xIngresoHTAyDM;
    }

    @Generated
    public JP_IngresoProgramaCyD getXJP_IngresoProgramaCyD() {
        return this.xJP_IngresoProgramaCyD;
    }

    @Generated
    public JPAiepiAtencionMadres getXJPAiepiAtencionMadres() {
        return this.xJPAiepiAtencionMadres;
    }

    @Generated
    public JPPeligros getXjPPeligros() {
        return this.xjPPeligros;
    }

    @Generated
    public JPAiepiOncologicoTest getAiepiOncologicoTest() {
        return this.aiepiOncologicoTest;
    }

    @Generated
    public String getPueba1() {
        return this.pueba1;
    }

    @Generated
    public JPHistoricoAtencionesVisionIPS getAtencionesVisionIPS() {
        return this.atencionesVisionIPS;
    }

    @Generated
    public JPIngresoPlanificacionFamiliar getJPIngresoPlanificacionFamiliar() {
        return this.jPIngresoPlanificacionFamiliar;
    }

    public FuncionalidadPanelHistoriaClinica() {
        springStart();
    }

    private void springStart() {
        this.alertasGeneralesDAO = (AlertasGeneralesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("alertasGeneralesDAO");
    }

    public void cargarPanel(String nombrePanel, JPanel panelPrincipal, JInternalFrame fomularioSolicita, String nombreItems, Integer tipoHistoria) {
        System.err.println("panel " + nombrePanel);
        if (nombrePanel.equals("atencion")) {
            this.pAAtencion = new JPAAtencion(Principal.clasehistoriace);
            mostrarPanel(this.pAAtencion, panelPrincipal);
            this.pAAtencion.JTPMotivoConsulta.requestFocus();
        } else if (nombrePanel.equals("revisionxsistemas")) {
            this.xJPARevisionSistemas = new JPARevisionSistemas(nombrePanel, Principal.clasehistoriace);
            mostrarPanel(this.xJPARevisionSistemas, panelPrincipal);
            this.xJPARevisionSistemas.JRBEstadoAnormal.requestFocus();
        } else if (nombrePanel.equals("jpayudasdx_nueva")) {
            this.revisionAyudasDx_Nueva = new JPARevisionAyudasDx_Nueva(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.revisionAyudasDx_Nueva, panelPrincipal);
        } else if (nombrePanel.equals("jpTriageRespiratorio")) {
            if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
                this.triageRespiratorio = new JPTriageRespiratorio(new Long(0L), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "Test Respiratorio(SARS-CoV-2)");
                mostrarPanel(this.triageRespiratorio, panelPrincipal);
            } else if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
                this.triageRespiratorio_V2 = new JPTriageRespiratorio_V2(new Long(0L), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "Test Respiratorio(SARS-CoV-2)");
                mostrarPanel(this.triageRespiratorio_V2, panelPrincipal);
            }
        } else if (nombrePanel.equals("jifCeritficadosMedicos")) {
            this.xJPCertificadoSO = new JPCertificadoSO(Principal.clasehistoriace);
            mostrarPanel(this.xJPCertificadoSO, panelPrincipal);
        } else if (nombrePanel.equals("jpayudasdxs")) {
            this.xJPARevisionAyudasDxS = new JPARevisionAyudasDxS(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xJPARevisionAyudasDxS, panelPrincipal);
        } else if (nombrePanel.equals("Radiología Sistematizadas")) {
            this.xJPARevisionAyudasDxRx = new JPARevisionAyudasDxRx(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xJPARevisionAyudasDxRx, panelPrincipal);
        } else if (nombrePanel.equals("RX Odontología")) {
            this.xJPRxOdontologia = new JPRxOdontologia();
            mostrarPanel(this.xJPRxOdontologia, panelPrincipal);
        } else if (nombrePanel.equals("jptratamiento_ordenes_nuevas")) {
            this.orden_Tratamiento_Nueva = new JPIOrden_Tratamiento_Nueva(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCargo().longValue(), "historiaV2");
            mostrarPanel(this.orden_Tratamiento_Nueva, panelPrincipal);
        } else if (nombrePanel.equals("Tratamiento") || nombrePanel.equals("Medicamentos/Dispositivos Medicos")) {
            this.xjiftratamiento = new JPIOrden_Tratamiento(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCargo().longValue(), "historiaV2");
            mostrarPanel(this.xjiftratamiento, panelPrincipal);
        } else if (nombrePanel.equals("Diagnóstico") || nombrePanel.equals("Diagnóstico de Ingreso")) {
            this.xJPADiagnostico = new JPADiagnostico(Principal.clasehistoriace);
            mostrarPanel(this.xJPADiagnostico, panelPrincipal);
        } else if (nombrePanel.equals("jpfichadusuario")) {
            this.fichaUsuario = new JPFichaUsuario(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
            mostrarPanel(this.fichaUsuario, panelPrincipal);
        } else if (nombrePanel.equals("jp_examenfisico_nuevo")) {
            this.examenFisicoI = new JP_ExamenFisicoI(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.examenFisicoI, panelPrincipal);
        } else if (nombrePanel.equals("jp_examenfisico_so")) {
            this.examenFisicoSo = new JP_ExamenFisicoSo(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.examenFisicoSo, panelPrincipal);
        } else if (nombrePanel.equals("jp_examenfisico_nuevo1")) {
            this.examenFisicoI1 = new JP_ExamenFisicoI1(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.examenFisicoI1, panelPrincipal);
        } else if (nombrePanel.equals("xjphistoricoa")) {
            this.historicoAtenciones = new JPHistoricoAtenciones(Principal.clasehistoriace);
            mostrarPanel(this.historicoAtenciones, panelPrincipal);
        } else if (nombrePanel.equals("Test Agudeza Visual") || nombrePanel.equals("Test Agudeza Visual")) {
            this.agudezaVisual = new JPI_Test_AgudezaVisual();
            setXjif_testagudeza_visual(this.agudezaVisual);
            mostrarPanel(this.agudezaVisual, panelPrincipal);
        } else if (nombrePanel.equals("Prueba Protector Respiratorio")) {
            this.xjiftest_prespiratorio = new JPSo_Test_PRespiratorio(0);
            mostrarPanel(this.xjiftest_prespiratorio, panelPrincipal);
        } else if (nombrePanel.equals("Importar Documentos HC")) {
            this.xjif_importardochc = new JP_Cargar_DocumentosHC(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.xjif_importardochc, panelPrincipal);
        } else if (nombrePanel.equals("xjptest_prespiratorio")) {
            this.xjiftest_prespiratorio = new JPSo_Test_PRespiratorio(1);
            mostrarPanel(this.xjiftest_prespiratorio, panelPrincipal);
        } else if (nombrePanel.equals("jprsignosvitales")) {
            this.xJPRSignosVitales = new JPRSignosVitales(fomularioSolicita.getName());
            mostrarPanel(this.xJPRSignosVitales, panelPrincipal);
        } else if (nombrePanel.equals("Control Oxígeno")) {
            this.controlOxigeno = new JPControlOxigeno(fomularioSolicita.getName());
            mostrarPanel(this.controlOxigeno, panelPrincipal);
        } else if (nombrePanel.equals("Control de Líquidos")) {
            this.controlLiquidos = new JPControlLiquidos(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
            mostrarPanel(this.controlLiquidos, panelPrincipal);
        } else if (nombrePanel.equals("Control Diabetes")) {
            this.xJPControlDiabetes = new JPControlDiabetes(fomularioSolicita.getName());
            mostrarPanel(this.xJPControlDiabetes, panelPrincipal);
        } else if (nombrePanel.equals("Examen Clínico PE")) {
            this.xJPIExamenClinicoPE = new JPIExamenClinicoPE(Principal.clasehistoriace);
            mostrarPanel(this.xJPIExamenClinicoPE, panelPrincipal);
        } else if (nombrePanel.equals("Intervenciones Quirúrgicas") || nombrePanel.equals("Atención del Parto") || nombrePanel.equals("Procedimientos Menores") || nombrePanel.equals("Informe de Parto")) {
            this.xJPCirugias1 = new JPI_Cirugias1(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), nombrePanel.toUpperCase());
            mostrarPanel(this.xJPCirugias1, panelPrincipal);
        } else if (nombrePanel.equals("jifantecfamiliares")) {
            this.xJPAAntecentesFamiliares = new JPAAntecentesFamiliares(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAAntecentesFamiliares, panelPrincipal);
            this.xJPAAntecentesFamiliares.JCBTipoParentesco.requestFocus();
        } else if (nombrePanel.equals("jpaantecedenteshabitos")) {
            this.xJPAAntecentesHabitos = new JPAAntecentesHabitos(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAAntecentesHabitos, panelPrincipal);
            this.xJPAAntecentesHabitos.JRBPDSi.requestFocus();
        } else if (nombrePanel.equals("jpaantecedetesppersonales")) {
            this.xJPAAntecentesPPersonales = new JPAAntecentesPPersonales(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAAntecentesPPersonales, panelPrincipal);
        } else if (nombrePanel.equals("jrevisionsistemas")) {
            this.xRevisionSistemasTabla = new JPA_RevisionSistemasTabla(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()));
            mostrarPanel(this.xRevisionSistemasTabla, panelPrincipal);
        } else if (nombrePanel.equals("Patologicos Personales.") || nombrePanel.equals("Antecedentes Personales.") || nombrePanel.equals("Antecedentes N")) {
            this.xJPAntecedentesPersonalesTabla = new JPA_AntecedentesPersonalesTabla(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
            mostrarPanel(this.xJPAntecedentesPersonalesTabla, panelPrincipal);
        } else if (nombrePanel.equals("patologiasasociadas")) {
            this.xJPAAPatologiasAsociadas = new JPAAPatologiasAsociadas(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAAPatologiasAsociadas, panelPrincipal);
        } else if (nombrePanel.equals("jpaantecedentespediatricos")) {
            this.xJPAAntecedentesPediatricos = new JPAAntecedentesPediatricos(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAAntecedentesPediatricos, panelPrincipal);
        } else if (nombrePanel.equals("jifanteodontologicos")) {
            this.xJPAAntecentesOdontologicos = new JPAAntecentesOdontologicos(Principal.clasehistoriace, 0, "jifanteodontologicos");
            mostrarPanel(this.xJPAAntecentesOdontologicos, panelPrincipal);
        } else if (nombrePanel.equals("Examen Físico") || nombrePanel.equals("Signos Vitales.")) {
            this.xJPAExamenFisico = new JPAExamenFisico(Principal.clasehistoriace);
            mostrarPanel(this.xJPAExamenFisico, panelPrincipal);
            this.xJPAExamenFisico.JTFFSFc.requestFocus();
        } else if (nombrePanel.equals("Hallazgos Examen Físico") || nombrePanel.equals("DETALLE EXÁMEN FÍSICO") || nombrePanel.equals("Detalle Exámen Físico") || nombrePanel.equals("Test Optometrico") || nombrePanel.equals("Detalle Examen Optometrico") || nombrePanel.equals("Exámen Físico N")) {
            this.xJPAHExamenFisico = new JPAHExamenFisico(nombrePanel, Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPAHExamenFisico, panelPrincipal);
            this.xJPAHExamenFisico.JRBEstadoAnormal.requestFocus();
        } else if (nombrePanel.equals("Exámen Físico N")) {
            this.xJPAHExamenFisico = new JPAHExamenFisico(nombrePanel, Principal.clasehistoriace, 1);
            mostrarPanel(this.xJPAHExamenFisico, panelPrincipal);
            this.xJPAHExamenFisico.JRBEstadoAnormal.requestFocus();
        } else if (nombrePanel.equals("Medicamentos")) {
            this.xjpsuministroh = new JPOOrdenSuministroH("HistoriaV2", Principal.clasehistoriace);
            mostrarPanel(this.xjpsuministroh, panelPrincipal);
        } else if (nombrePanel.equals("Laboratorios")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 2, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Radiologia")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 3, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Imagenologia Doppler")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 18, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Otros Servicios")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 6, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Ecografía")) {
            switch (Principal.informacionIps.getNombreIps()) {
                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 11, 1, nombrePanel);
                    break;
                case "OROSALUD CAUCASIA IPS S.A.S":
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 11, 1, nombrePanel);
                    break;
                default:
                    this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 12, 1, nombrePanel);
                    break;
            }
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Otros Procedimientos")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 6, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Procedimientos Qx")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 10, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Laboratorios.")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 2, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Banco de Sangre")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 16, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Radiologia.")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 3, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Otros Servicios.")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 6, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Ecografías.")) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 11, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            } else {
                this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 12, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), nombrePanel);
            }
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("xjptriage")) {
            this.xjptriage = new JPITriage();
            mostrarPanel(this.xjptriage, panelPrincipal);
        } else if (nombrePanel.equals("InterConsulta")) {
            this.xjpremisiones = new JPORemisiones(Principal.clasehistoriace, 0, true);
            mostrarPanel(this.xjpremisiones, panelPrincipal);
        } else if (nombrePanel.equals("Remisión")) {
            this.xjpremisiones = new JPORemisiones(Principal.clasehistoriace, 1, false);
            mostrarPanel(this.xjpremisiones, panelPrincipal);
        } else if (nombrePanel.equals("InterConsulta1")) {
            this.xjpremisiones1 = new JPORemisiones1(Principal.clasehistoriace, 0, true);
            mostrarPanel(this.xjpremisiones1, panelPrincipal);
        } else if (nombrePanel.equals("Remisión1")) {
            this.xjpremisiones1 = new JPORemisiones1(Principal.clasehistoriace, 1, false);
            mostrarPanel(this.xjpremisiones1, panelPrincipal);
        } else if (nombrePanel.equals("Impresión Documentos")) {
            this.xJPImpresion_Doc = new JPI_Control_Impresion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc(), clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario());
            mostrarPanel(this.xJPImpresion_Doc, panelPrincipal);
        } else if (nombrePanel.equals("Promoción y Prevención")) {
            this.xjpprocedimientosh = new JPOOrdenProcedimientosH(Principal.clasehistoriace, 5, 1, nombrePanel);
            mostrarPanel(this.xjpprocedimientosh, panelPrincipal);
        } else if (nombrePanel.equals("Ingreso a Programa")) {
            this.datosPyP = new JP_CP_DatosPyP("Ingreso");
            mostrarPanel(this.datosPyP, panelPrincipal);
        } else if (nombrePanel.equals("Egreso Programa")) {
            JP_CP_DatosPyP frm = new JP_CP_DatosPyP("Egreso");
            mostrarPanel(frm, panelPrincipal);
        } else if (nombrePanel.equals("Escala de Riesgo Biosicosocial")) {
            this.xJPRiesgoBiosicoSocial = new JPRiesgoBiosicoSocial();
            mostrarPanel(this.xJPRiesgoBiosicoSocial, panelPrincipal);
        } else if (nombrePanel.equals("Resultados de Examenes") || nombrePanel.equals("Resultados Examenes Prenatal")) {
            this.xjifpyprevisionexamenes = new JP_CP_ResultadoExamenes1();
            mostrarPanel(this.xjifpyprevisionexamenes, panelPrincipal);
        } else if (nombrePanel.equals("Examen Físico Prenatal N")) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0 || clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc().intValue() == 74) {
                this.xJPAExamenFisicoPrenatal_v2 = new JPAExamenFisicoPrenatal_v2(Principal.clasehistoriace);
                mostrarPanel(this.xJPAExamenFisicoPrenatal_v2, panelPrincipal);
            } else {
                JOptionPane.showInternalMessageDialog(fomularioSolicita, "<html><P ALIGN=center> <font face='Arial' color='red' size=4> <b>Primero debe ingresar el Usuario al programa<br>en el item ingreso a programa.</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (nombrePanel.equals("Examen Físico Prenatal")) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0 || clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc().intValue() == 74) {
                this.xJPAExamenFisicoPrenatal = new JPAExamenFisicoPrenatal(Principal.clasehistoriace);
                mostrarPanel(this.xJPAExamenFisicoPrenatal, panelPrincipal);
            } else {
                JOptionPane.showInternalMessageDialog(fomularioSolicita, "<html><P ALIGN=center> <font face='Arial' color='red' size=4> <b>Primero debe ingresar el Usuario al programa<br>en el item ingreso a programa.</p>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (nombrePanel.equals("jpconclusiones1")) {
            JP_ExamenFisicoI examenFisico = new JP_ExamenFisicoI(Principal.clasehistoriace, "");
            JPARevisionAyudasDxS ayudasDx = new JPARevisionAyudasDxS(Principal.clasehistoriace, "jpayudasdxs");
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") && examenFisico.nExamenFisico) {
                this.xjifconclusion = new JPAConclusion(Principal.clasehistoriace);
                mostrarPanel(this.xjifconclusion, panelPrincipal);
                this.xjifconclusion.JTFCDxP.requestFocus();
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") && !examenFisico.nExamenFisico) {
                JOptionPane.showMessageDialog((Component) null, "Por favor complete el Examen físico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mostrarPanel(examenFisico, panelPrincipal);
            } else if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || ayudasDx.revisionAyudasDxS) {
                this.xjifconclusion = new JPAConclusion(Principal.clasehistoriace);
                mostrarPanel(this.xjifconclusion, panelPrincipal);
                this.xjifconclusion.JTFCDxP.requestFocus();
            } else {
                JOptionPane.showMessageDialog((Component) null, "Por favor digite una interpretación a los exámenes de laboratorio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mostrarPanel(ayudasDx, panelPrincipal);
            }
        } else if (nombrePanel.equals("Egreso Urgencias") || nombrePanel.equals("Egreso Hospitalización")) {
            this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
            mostrarPanel(this.xJPEgresoUrgencias, panelPrincipal);
        } else if (nombrePanel.equals("Egreso")) {
            this.xjptriage = new JPITriage();
            JPADiagnostico jPADiagnostico = new JPADiagnostico(Principal.clasehistoriace);
            JPAAtencion jPAAtencion = new JPAAtencion(Principal.clasehistoriace);
            JP_ExamenFisicoI1 examenFisico1 = new JP_ExamenFisicoI1(Principal.clasehistoriace, "");
            JPA_NotasMedicasN notasMedicasN = new JPA_NotasMedicasN(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5,6,7,13)", nombrePanel.toUpperCase());
            JPANotas notas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5,6,7,13)", nombrePanel.toUpperCase());
            new JPARevisionAyudasDxS(Principal.clasehistoriace, "jpayudasdxs");
            this.xjptriage.verificarConvenioCapitado();
            System.out.println("triage --- " + this.xjptriage.nTriage + "   triage 5----" + this.xjptriage.triageFive + "----triage 4--- " + this.xjptriage.triageFour + "---triage capita----" + this.xjptriage.esCapita);
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") && this.xjptriage.nTriage && jPADiagnostico.nDiagnostico && jPAAtencion.nAtencion && examenFisico1.nExamenFisico && notas.nEvolucion) {
                this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
                mostrarPanel(this.xJPEgresoUrgencias, panelPrincipal);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") && this.xjptriage.nTriage && jPADiagnostico.nDiagnostico && jPAAtencion.nAtencion && examenFisico1.nExamenFisico && notas.nEvolucion) {
                this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
                mostrarPanel(this.xJPEgresoUrgencias, panelPrincipal);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && this.xjptriage.nTriage && this.xjptriage.esCapita && (this.xjptriage.triageFive || this.xjptriage.triageFour)) {
                this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
                mostrarPanel(this.xJPEgresoUrgencias, panelPrincipal);
            } else if (!Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") && this.xjptriage.nTriage && jPADiagnostico.nDiagnostico && jPAAtencion.nAtencion && examenFisico1.nExamenFisico && notasMedicasN.nEvolucionAsistencial) {
                this.xJPEgresoUrgencias = new JPEgresoUrgencias(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue(), Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue(), "xEgresoHC", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue());
                mostrarPanel(this.xJPEgresoUrgencias, panelPrincipal);
            } else if (!this.xjptriage.nTriage) {
                mostrarPanel(this.xjptriage, panelPrincipal);
            } else if (!notas.nEvolucion) {
                mostrarPanel(notas, panelPrincipal);
            } else if (!jPADiagnostico.nDiagnostico) {
                mostrarPanel(jPADiagnostico, panelPrincipal);
            } else if (!jPAAtencion.nAtencion) {
                mostrarPanel(jPAAtencion, panelPrincipal);
            } else if (!examenFisico1.nExamenFisico) {
                mostrarPanel(examenFisico1, panelPrincipal);
            } else if (!notasMedicasN.nEvolucionAsistencial) {
                mostrarPanel(notasMedicasN, panelPrincipal);
            }
        } else if (nombrePanel.equals("Laboratorio") || nombrePanel.equals("Lectura Radiologia") || nombrePanel.equals("Ecografia") || nombrePanel.equals("Otros Examenes Especializados") || nombrePanel.equals("Citologia") || nombrePanel.equals("Espirometria") || nombrePanel.equals("Ecocardiograma") || nombrePanel.equals("Electrocardiograma") || nombrePanel.equals("Control Glucometrias") || nombrePanel.equals("Mamografía") || nombrePanel.equals("Endoscopia") || nombrePanel.equals("Polisomnografia") || nombrePanel.equals("Resonancia") || nombrePanel.equals("Tac") || nombrePanel.equals("Prueba de Esfuerzo") || nombrePanel.equals("Densiometria Osea") || nombrePanel.equals("Tacar") || nombrePanel.equals("Esofagogastroduoendoscopia") || nombrePanel.equals("Test de Alergia") || nombrePanel.equals("Colonoscopia") || nombrePanel.equals("Audiometria") || nombrePanel.equals("Copia de Atencion") || nombrePanel.equals("Otros Documentos") || nombrePanel.equals("Tomografia")) {
            this.xJPARevisionAyudasDx = new JPARevisionAyudasDx(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xJPARevisionAyudasDx, panelPrincipal);
        } else if (nombrePanel.equals("Incapacidades")) {
            this.xjpincapacidad = new JPAIncapacidad(Principal.clasehistoriace, "xjifhistoria");
            mostrarPanel(this.xjpincapacidad, panelPrincipal);
        } else if (nombrePanel.equals("JPAIncapacidad_v2")) {
            this.aIncapacidad_v2 = new JPAIncapacidad_v2(Principal.clasehistoriace, "xjifhistoria");
            mostrarPanel(this.aIncapacidad_v2, panelPrincipal);
        } else if (nombrePanel.equals("Evento no deseado")) {
            this.xjpeventonodeseado = new JPAEventoNoDeseado(Principal.clasehistoriace);
            mostrarPanel(this.xjpeventonodeseado, panelPrincipal);
        } else if (nombrePanel.equals("Permisos")) {
            this.xjppermisos = new JPPermisosMedicos(Principal.clasehistoriace);
            mostrarPanel(this.xjppermisos, panelPrincipal);
        } else if (nombrePanel.equals("Nueva Nota") || nombrePanel.equals("Evoluciones") || nombrePanel.equals("Evolución y/o Ordenes")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Evolución y Conducta Inicial Urgencias")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(2,4)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Orden Medica Texto V2")) {
            this.xjpnotas1 = new JPANotas_v2(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(2,4)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas1, panelPrincipal);
        } else if (nombrePanel.equals("Revisión Paraclinicos y Ayudas Dx")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(10)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Orden Medica Texto")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(3)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Ordenes de texto ambulatoria")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), "1", String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(11)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Nota Interconsulta") || nombrePanel.equals("Interconsulta-HU")) {
            this.xjpnotas = new JPANotas(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5)", nombrePanel.toUpperCase());
            mostrarPanel(this.xjpnotas, panelPrincipal);
        } else if (nombrePanel.equals("Evolucion Asistencial")) {
            this.xNotasMedicasNa = new JPA_NotasMedicasN(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(5,6,7,13)", nombrePanel.toUpperCase());
            mostrarPanel(this.xNotasMedicasNa, panelPrincipal);
        } else if (nombrePanel.equals("jpi_notas_procedimientosmenores")) {
            this.xA_NotasProcedimientosMenores = new JPA_NotasProcedimientosMenores(fomularioSolicita, Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "in(8)", "PROCEDIMIENTOS MENORES");
            mostrarPanel(this.xA_NotasProcedimientosMenores, panelPrincipal);
        } else if (nombrePanel.equals("Historico de Educación")) {
            this.actividadesPyP = new JPAActividadesPyP(Principal.clasehistoriace);
            mostrarPanel(this.actividadesPyP, panelPrincipal);
        } else if (nombrePanel.equals("Ginecologicos")) {
            this.xJPAAntecedenteGineco = new JPAAntecedenteGineco(Principal.clasehistoriace, 1);
            mostrarPanel(this.xJPAAntecedenteGineco, panelPrincipal);
        } else if (nombrePanel.equals("JPAAntecedentegineco_nuevo")) {
            this.xJPAAntecedenteGineco_Nuevo = new JPAAntecedenteGineco_Nuevo(Principal.clasehistoriace, 1);
            mostrarPanel(this.xJPAAntecedenteGineco_Nuevo, panelPrincipal);
        } else if (nombrePanel.equals("Cita Control")) {
            asignarCita();
        } else if (nombrePanel.equals("Alimentacion")) {
            this.alimentacion = new Alimentacion(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.alimentacion, panelPrincipal);
        } else if (nombrePanel.equals("Motricidad Fina")) {
            this.motricidadFina = new MotricidadFina(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.motricidadFina, panelPrincipal);
        } else if (nombrePanel.equals("Motricidad Gruesa")) {
            this.motricidadGruesa = new MotricidadGruesa(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.motricidadGruesa, panelPrincipal);
        } else if (nombrePanel.equals("Valoracion Lenguaje")) {
            this.valoracionLenguaje = new ValoracionLenguaje(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.valoracionLenguaje, panelPrincipal);
        } else if (nombrePanel.equals("Valoracion Personal")) {
            this.valoracionPersonal = new ValoracionPersonal(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.valoracionPersonal, panelPrincipal);
        } else if (nombrePanel.equals("Resultados CyD")) {
            this.valoracionResultado = new ValoracionResultado(Principal.clasepyp, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo());
            mostrarPanel(this.valoracionResultado, panelPrincipal);
        } else if (nombrePanel.equals("jpayudasdxs")) {
            JPARevisionAyudasDxS frm2 = new JPARevisionAyudasDxS(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(frm2, panelPrincipal);
        } else if (nombrePanel.equals("jpayudasdxrx")) {
            this.xJPARevisionAyudasDxRx = new JPARevisionAyudasDxRx(Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xJPARevisionAyudasDxRx, panelPrincipal);
        } else if (nombrePanel.equals("jphnutricional")) {
            this.xjpnutricion = new JPHNutricional(Principal.clasehistoriace);
            mostrarPanel(this.xjpnutricion, panelPrincipal);
        } else if (nombrePanel.equals("jifantecedentesocupacionales")) {
            this.aAntecentesOcupacionales = new JPAAntecentesOcupacionales(Principal.clasehistoriace, 0);
            mostrarPanel(this.aAntecentesOcupacionales, panelPrincipal);
        } else if (nombrePanel.equals("jifantecedentesocupacionalesNuevo")) {
            this.aAntecentesOcupacionalesNuevo = new JPAAntecentesOcupacionalesNuevo(Principal.clasehistoriace, 0);
            mostrarPanel(this.aAntecentesOcupacionalesNuevo, panelPrincipal);
        } else if (nombrePanel.equals("Test de Morisky - Green")) {
            this.xJPATestMorisky = new JPATestMorisky(Principal.clasehistoriace, 0);
            mostrarPanel(this.xJPATestMorisky, panelPrincipal);
        } else if (nombrePanel.equals("Revision Sistemas")) {
            this.xJPARevisionSistemas = new JPARevisionSistemas(nombrePanel, Principal.clasehistoriace);
            mostrarPanel(this.xJPARevisionSistemas, panelPrincipal);
            this.xJPARevisionSistemas.JRBEstadoAnormal.requestFocus();
        } else if (nombrePanel.equals("Ingreso") || nombrePanel.equals("Egreso")) {
            this.datosPyP1 = new JP_CP_DatosPyP(nombrePanel);
            mostrarPanel(this.datosPyP1, panelPrincipal);
        } else if (nombrePanel.equals("Riesgo BiosicoSocial")) {
            this.xJPRiesgoBiosicoSocial = new JPRiesgoBiosicoSocial();
            mostrarPanel(this.xJPRiesgoBiosicoSocial, panelPrincipal);
        } else if (nombrePanel.equals("Trabajo en Alturas")) {
            this.xJPASaludOcupacional = new JPASaludOcupacional();
            mostrarPanel(this.xJPASaludOcupacional, panelPrincipal);
        } else if (nombrePanel.equals("Ecografia Abdominal")) {
            this.xjifecografiagenerico = new JPAEcografiaGenerico("jifecoabdominal", Principal.clasehistoriace);
            mostrarPanel(this.xjifecografiagenerico, panelPrincipal);
        } else if (nombrePanel.equals("Ecografía Ecobiliarab")) {
            this.xjifecografiagenerico = new JPAEcografiaGenerico("jifecoecobiliarab", Principal.clasehistoriace);
            mostrarPanel(this.xjifecografiagenerico, panelPrincipal);
        } else if (nombrePanel.equals("Ecografía Pélvica")) {
            this.xjifecografiap = new JPAEcografiaPelvica("xjifecografia", Principal.clasehistoriace);
            mostrarPanel(this.xjifecografiap, panelPrincipal);
        } else if (nombrePanel.equals("Endoscopia_Dx") || nombrePanel.equals("Reporte Ecografía")) {
            System.out.println("1 " + nombrePanel);
            this.xjifecografiagenerico = new JPAEcografiaGenerico("xjifecografia", Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xjifecografiagenerico, panelPrincipal);
        } else if (nombrePanel.equals("Ecografía.") || nombrePanel.equals("Colonoscopia_Dx") || nombrePanel.equals("Colposcopia_Dx") || nombrePanel.equals("Crioterapia_Dx")) {
            System.out.println("2 " + nombrePanel);
            this.xjifecografiagenerico = new JPAEcografiaGenerico("xjifecografia", Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xjifecografiagenerico, panelPrincipal);
        } else if (nombrePanel.equals("Colposcopia_Dx2")) {
            System.out.println("2 " + nombrePanel);
            this.xjifcolposcopia = new JPAColposcopia("xjifcolcospia", Principal.clasehistoriace, nombrePanel);
            mostrarPanel(this.xjifcolposcopia, panelPrincipal);
        } else if (nombrePanel.equals("Ecografia Obstetrica")) {
            this.xJPAEcografiaObstetrica = new JPAEcografiaObstetrica("jifecoobstetrica", Principal.clasehistoriace);
            mostrarPanel(this.xJPAEcografiaObstetrica, panelPrincipal);
        } else if (nombrePanel.equals("Concepto Aptitud")) {
            this.xjifconceptosio_i = new JPSo_Concepto_I(Principal.clasehistoriace, 2);
            mostrarPanel(this.xjifconceptosio_i, panelPrincipal);
        } else if (nombrePanel.equals("Concepto Aptitud Laboral")) {
            this.xjifconceptosio_i = new JPSo_Concepto_I(Principal.clasehistoriace, 0);
            mostrarPanel(this.xjifconceptosio_i, panelPrincipal);
        } else if (nombrePanel.equals("Concepto Aptitud Laboral R")) {
            this.concepto_R = new JPSo_Concepto_R(Principal.clasehistoriace, 0);
            mostrarPanel(this.concepto_R, panelPrincipal);
        } else if (nombrePanel.equals("Concepto Aptitud Laboral (Egreso)")) {
            this.xjifconceptoso_e = new JPSo_Concepto_E(Principal.clasehistoriace);
            mostrarPanel(this.xjifconceptoso_e, panelPrincipal);
        } else if (nombrePanel.equals("Prescripción Ejercicio")) {
            this.xjifprescripcionejercicio = new JPSo_PEjercicio(Principal.clasehistoriace);
            mostrarPanel(this.xjifprescripcionejercicio, panelPrincipal);
        } else if (nombrePanel.equals("Audiometria So")) {
            this.xjifaudiometria = new JPSo_Audiometria();
            mostrarPanel(this.xjifaudiometria, panelPrincipal);
        } else if (nombrePanel.equals("jifaudiometria_so_nuevo")) {
            this.audiometria_nueva1 = new JPSo_Audiometria_nueva1();
            mostrarPanel(this.audiometria_nueva1, panelPrincipal);
        } else if (nombrePanel.equals("Espirometria So")) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xjifespirometria = new JPSo_Espirometria();
                mostrarPanel(this.xjifespirometria, panelPrincipal);
            } else {
                this.xjifespirometriaSI = new JPSo_EspirometriaSI();
                mostrarPanel(this.xjifespirometriaSI, panelPrincipal);
            }
        } else if (nombrePanel.equals("Visiometria So")) {
            this.xjifvisiometriafpz = new JPSo_VisiometriaFPZ();
            mostrarPanel(this.xjifvisiometriafpz, panelPrincipal);
        } else if (nombrePanel.equals("Visiometria So2")) {
            this.xjifvisiometriaG = new JPSo_VisiometriaG();
            mostrarPanel(this.xjifvisiometriaG, panelPrincipal);
        } else if (nombrePanel.equals("NOMA")) {
            this.xjifosteomuscuar = new JPSo_Osteomuscular();
            mostrarPanel(this.xjifosteomuscuar, panelPrincipal);
        } else if (nombrePanel.equals("Exámen Optometrico")) {
            this.jP_Optometria = new JP_Optometria(Principal.clasehistoriace);
            mostrarPanel(this.jP_Optometria, panelPrincipal);
        } else if (nombrePanel.equals("Visual")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 1, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Auditivo")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 2, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Respiratorio")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 3, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Alergia")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 4, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Altura")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 5, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Escala de  Kessler (K10)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 13, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Consumo de Alcohol - Audit Test")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 14, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Apgar familiar")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 25, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("M-chat")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 28, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Whooley")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 29, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("GAD-2")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 30, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("AUDIT")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 31, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Zarit")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 32, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("EPOC")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 33, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("LINDAFRIED")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 34, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("BARTHEL")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 35, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Síntomas neurotóxicos Q16")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 49, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Lawton-Brody_H")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 36, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Lawton-Brody_M")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 37, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("ANAMNESIS")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 39, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("INF_ADICIONAL")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 40, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("JPATestSmokingAndSubstance")) {
            this.jPATestSmokingAndSubstance = new JPATestSmokingAndSubstance();
            mostrarPanel(this.jPATestSmokingAndSubstance, panelPrincipal);
        } else if (nombrePanel.equals("Reporting Questionnaire for Children (RQC)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 18, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Self Report Questionnaire (SRQ)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 19, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Escala de Epworth - Tamiz Somnolencia")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 15, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Escala DSM4")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 16, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("CAGE - Riesgo de Alcoholismo")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 17, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Evaluación Estres")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 7, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Factores Psicosociales Extralaborales")) {
            this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nombrePanel.toUpperCase(), 8);
            mostrarPanel(this.xJPSo_CuestionarioSico, panelPrincipal);
        } else if (nombrePanel.equals("Estilos de Afrontamiento")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 9, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Formato A (Intralaboral)")) {
            this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nombrePanel.toUpperCase(), 10);
            mostrarPanel(this.xJPSo_CuestionarioSico, panelPrincipal);
        } else if (nombrePanel.equals("Formato B (Intralaboral)")) {
            this.xJPSo_CuestionarioSico = new JPSo_CuestionarioSico(nombrePanel.toUpperCase(), 11);
            mostrarPanel(this.xJPSo_CuestionarioSico, panelPrincipal);
        } else if (nombrePanel.equals("Evaluación de Fatiga")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 12, 0);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if (nombrePanel.equals("Resultado Tacto Rectal")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 4);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado Test Agudeza Visual")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 5);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado de Colonoscopia Tamizaje")) {
            this.xjifcuestionarios = new JPSo_Cuestionarios(nombrePanel.toUpperCase(), 0, 6);
            mostrarPanel(this.xjifcuestionarios, panelPrincipal);
        } else if ((Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && nombrePanel.equals("Resultado Tamizajes")) || nombrePanel.equals("Resultado Tamizaje Auditivo Neonatal")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 7);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado Tamizaje Visual Neonatal")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 8);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Tratamiento ablativo o de escisión posterior a la realización de la técnica de inspección visual (Crioterapia o LETZ)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 9);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Cuestionario Resultado de Tamización con oximetria pre y post ductal")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 10);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado de TSH neonatal")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 11);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Fecha de Resultado de Colposcopia")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 12);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Cuestionario Resultado Biopsia Cervicouterina")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 13);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado Mamografia")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 14);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Resultado de Biopsia de Mama")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 15);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Riesgo Cardiovascular y Metabólico")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 0, 16);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("jpIngresoPlanificacionFamiliar")) {
            this.jPIngresoPlanificacionFamiliar = new JPIngresoPlanificacionFamiliar(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma(), true);
            mostrarPanel(this.jPIngresoPlanificacionFamiliar, panelPrincipal);
        } else if (nombrePanel.equals("Test de Fatiga")) {
            this.xjptestfatiga = new JPTestFatiga(fomularioSolicita);
            mostrarPanel(this.xjptestfatiga, panelPrincipal);
        } else if (nombrePanel.equals("Odontograma")) {
            this.xjifOdontograma = new JPOdontograma();
            mostrarPanel(this.xjifOdontograma, panelPrincipal);
        } else if (nombrePanel.equals("Odontograma Inicial")) {
            this.xJPOdontogramaInicial = new JPOdontogramaInicial();
            mostrarPanel(this.xJPOdontogramaInicial, panelPrincipal);
        } else if (nombrePanel.equals("Odontograma Clínico")) {
            this.xJPOdontogramaClinico = new JPOdontogramaClinico();
            mostrarPanel(this.xJPOdontogramaClinico, panelPrincipal);
        } else if (nombrePanel.equals("Control Placa")) {
            this.xjifControlPlaca = new JPControlPlaca();
            mostrarPanel(this.xjifControlPlaca, panelPrincipal);
        } else if (nombrePanel.equals("Clasificación Riesgo.")) {
            this.xjpgestionriesgohta = new JPGestionRiesgo_Hta(Principal.clasehistoriace);
            mostrarPanel(this.xjpgestionriesgohta, panelPrincipal);
        } else if (nombrePanel.equals("Clasificación Riesgo")) {
            this.xjpgestionriesgo = new JPGestionRiesgo_Dm(Principal.clasehistoriace);
            mostrarPanel(this.xjpgestionriesgo, panelPrincipal);
        } else if (nombrePanel.equals("Seguimiento")) {
            this.xjifseguimiento = new JPISeguimiento_Pac(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.xjifseguimiento, panelPrincipal);
        } else if (nombrePanel.equals("Ingreso HTA")) {
            this.xjifHTA = new JP_PyP_HTA("xjifhta_HC", 1L);
            mostrarPanel(this.xjifHTA, panelPrincipal);
        } else if (nombrePanel.equals("Egreso HTA")) {
            this.xjifHTA = new JP_PyP_HTA("xjifhta_HC", 2L);
            mostrarPanel(this.xjifHTA, panelPrincipal);
        } else if (nombrePanel.equals("Ingreso DM")) {
            this.xjifdiabetes = new JP_PyP_Diabetes("xjifDiabetes_HC", 1L);
            mostrarPanel(this.xjifdiabetes, panelPrincipal);
        } else if (nombrePanel.equals("Egreso DM")) {
            this.xjifdiabetes = new JP_PyP_Diabetes("xjifDiabetes_HC", 2L);
            mostrarPanel(this.xjifdiabetes, panelPrincipal);
        } else if (nombrePanel.equals("Ingreso HTA y DM")) {
            this.xIngresoHTAyDM = new JP_PyP_DMyHTA("ingreso");
            mostrarPanel(this.xIngresoHTAyDM, panelPrincipal);
        } else if (nombrePanel.equals("Egreso HTA y DM")) {
            this.xIngresoHTAyDM = new JP_PyP_DMyHTA("egreso");
            mostrarPanel(this.xIngresoHTAyDM, panelPrincipal);
        } else if (nombrePanel.equals("Exámenes Dentarios")) {
            this.xJPExamenDentario = new JPExamenDentario();
            mostrarPanel(this.xJPExamenDentario, panelPrincipal);
        } else if (nombrePanel.equals("Hábitos Dentarios")) {
            this.xJPAAntecentesOdontologicos = new JPAAntecentesOdontologicos(Principal.clasehistoriace, 0, "jifhdentarios");
            mostrarPanel(this.xJPAAntecentesOdontologicos, panelPrincipal);
        } else if (nombrePanel.equals("Oclusión")) {
            this.xJPOclusion = new JPOclusion();
            mostrarPanel(this.xJPOclusion, panelPrincipal);
        } else if (nombrePanel.equals("Endodoncia")) {
            this.xJPEndoExamenClinico = new JPEndoExamenClinico();
            mostrarPanel(this.xJPEndoExamenClinico, panelPrincipal);
        } else if (nombrePanel.equals("Análisis Cefalométrico")) {
            this.xJPCefalometria = new JPCefalometria();
            mostrarPanel(this.xJPCefalometria, panelPrincipal);
        } else if (nombrePanel.equals("Análisis Oclusal")) {
            this.xJPAnalisiOclusal = new JPAnalisiOclusal();
            mostrarPanel(this.xJPAnalisiOclusal, panelPrincipal);
        } else if (nombrePanel.equals("Análisis Estomatológico")) {
            this.xJPAnalisisEstomatologico = new JPAnalisisEstomatologico();
            mostrarPanel(this.xJPAnalisisEstomatologico, panelPrincipal);
        } else if (nombrePanel.equals("Análisis Funcional")) {
            this.xJPAnalisisFuncional = new JPAnalisisFuncional();
            mostrarPanel(this.xJPAnalisisFuncional, panelPrincipal);
        } else if (nombrePanel.equals("Escala Abreviada")) {
            this.xJPEscalaAbreviada = new JPEscalaAbreviada();
            mostrarPanel(this.xJPEscalaAbreviada, panelPrincipal);
        } else if (nombrePanel.equals("Cálculo IFG")) {
            this.xJPFiltroIFG = new JPFiltroIFG();
            mostrarPanel(this.xJPFiltroIFG, panelPrincipal);
        } else if (nombrePanel.equals("Vacunación") || nombrePanel.equals("Esquema de Vacunación")) {
            this.xJPVacunacion = new JPVacunacion();
            mostrarPanel(this.xJPVacunacion, panelPrincipal);
        } else if (nombrePanel.equals("Exámen Físico CyD")) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
                this.xJPGraficasPyPTierraAlta = new JPGraficasPyPTierraAlta();
                mostrarPanel(this.xJPGraficasPyPTierraAlta, panelPrincipal);
            } else {
                this.xJPGraficasPyP = new JPGraficasPyP();
                mostrarPanel(this.xJPGraficasPyP, panelPrincipal);
            }
        } else if (nombrePanel.equals("Exámen Físico CyD_N")) {
            this.xJPGraficasPyPTierraAlta_v2 = new JPGraficasPyPTierraAlta_v2();
            mostrarPanel(this.xJPGraficasPyPTierraAlta_v2, panelPrincipal);
        } else if (nombrePanel.equals("JPAEscalaAbreviadaDeDesarrollo")) {
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace = Principal.clasehistoriace;
            this.jPAEscalaAbreviadaDeDesarrollo = new JPAEscalaAbreviadaDeDesarrollo(fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
            mostrarPanel(this.jPAEscalaAbreviadaDeDesarrollo, panelPrincipal);
        } else if (nombrePanel.equals("JPAEscalaAbreviadaDeDesarrollo_V2")) {
            String fechaNacimiento2 = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace2 = Principal.clasehistoriace;
            this.jPAEscalaAbreviadaDeDesarrollo_V2 = new JPAEscalaAbreviadaDeDesarrollo_V2(fechaNacimiento2, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
            mostrarPanel(this.jPAEscalaAbreviadaDeDesarrollo_V2, panelPrincipal);
        } else if (nombrePanel.equals("Terapia Física")) {
            this.xjif_terapiaf = new JPHistoria_Terapias(0);
            mostrarPanel(this.xjif_terapiaf, panelPrincipal);
        } else if (nombrePanel.equals("Terapia Respiratoria")) {
            this.xjif_terapiaf = new JPHistoria_Terapias(1);
            mostrarPanel(this.xjif_terapiaf, panelPrincipal);
        } else if (nombrePanel.equals("Atención del niño de 2 meses a 5 años")) {
            this.xJPAiepi = new JPAiepi();
            mostrarPanel(this.xJPAiepi, panelPrincipal);
        } else if (nombrePanel.equals("Control de Transfusiones")) {
            this.xJPTransfuciones = new JPTransfuciones("xTransfusionHC");
            mostrarPanel(this.xJPTransfuciones, panelPrincipal);
        } else if (nombrePanel.equals("Trasnporte Asistencial")) {
            this.xJPTrasnporteAsis = new JPTrasnporteAsis();
            mostrarPanel(this.xJPTrasnporteAsis, panelPrincipal);
        } else if (nombrePanel.equals("Aiepi Niños 0 a 2 Meses")) {
            this.xJPAiepiNinos = new JPAiepiNinos();
            mostrarPanel(this.xJPAiepiNinos, panelPrincipal);
        } else if (nombrePanel.equals("Aiepi Atención a la Madre")) {
            this.xJPAiepiMadres = new JPAiepiMadres();
            mostrarPanel(this.xJPAiepiMadres, panelPrincipal);
        } else if (nombrePanel.equals("Aiepi Atencion Materna")) {
            this.xJPAiepiAtencionMadres = new JPAiepiAtencionMadres();
            mostrarPanel(this.xJPAiepiAtencionMadres, panelPrincipal);
        } else if (nombrePanel.equals("Lista de chequeo")) {
            this.xJPListaCHequeo = new JPListaCHequeo();
            mostrarPanel(this.xJPListaCHequeo, panelPrincipal);
        } else if (nombrePanel.equals("Adulto Mayor") || nombrePanel.equals("Evaluación Riesgo Psicosocial")) {
            this.xJPAdultoMayor = new JPAdultoMayor();
            mostrarPanel(this.xJPAdultoMayor, panelPrincipal);
        } else if (nombrePanel.equals("Adulto Joven")) {
            this.xJIFAdultoJoven = new JIFAdultoJoven();
            mostrarPanel(this.xJIFAdultoJoven, panelPrincipal);
        } else if (nombrePanel.equals("Datos sociodemográficos")) {
            this.xJPSociodemografico = new JPSociodemografico();
            mostrarPanel(this.xJPSociodemografico, panelPrincipal);
        } else if (nombrePanel.equals("Exámen Oftamológico")) {
            this.xJPOftamologiaGen = new JPOftamologiaGen();
            mostrarPanel(this.xJPOftamologiaGen, panelPrincipal);
        } else if (nombrePanel.equals("Control Placa Bacteriana")) {
            this.xJPControlPlacaCompleto = new JPControlPlacaCompleto();
            mostrarPanel(this.xJPControlPlacaCompleto, panelPrincipal);
        } else if (nombrePanel.equals("Información Complementaria")) {
            this.xJIFAdultoJoven2 = new JIFAdultoJoven2();
            mostrarPanel(this.xJIFAdultoJoven2, panelPrincipal);
        } else if (nombrePanel.equals("Partograma")) {
            this.xJPPartograma = new JPPartograma(nombrePanel.toUpperCase());
            mostrarPanel(this.xJPPartograma, panelPrincipal);
        } else if (nombrePanel.equals("Planificación Familiar")) {
            this.xJPPlanificacionFliar = new JPPlanificacionFliar();
            mostrarPanel(this.xJPPlanificacionFliar, panelPrincipal);
        } else if (nombrePanel.equals("Histórico de exposición")) {
            this.xJPGraficaAgenteSEG = new JPGraficaAgenteSEG();
            mostrarPanel(this.xJPGraficaAgenteSEG, panelPrincipal);
        } else if (nombrePanel.equals("Evento Adverso")) {
            this.xJPEventoAdverso = new JPEventoAdverso(false, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), 2);
            mostrarPanel(this.xJPEventoAdverso, panelPrincipal);
        } else if (nombrePanel.equals("Evaluacion de Riesgo")) {
            this.xJPAEvaluacionRiesgo = new JPAEvaluacionRiesgo();
            mostrarPanel(this.xJPAEvaluacionRiesgo, panelPrincipal);
        } else if (nombrePanel.equals("Framingham")) {
            this.xJPFramingham = new JPFramingham();
            mostrarPanel(this.xJPFramingham, panelPrincipal);
        } else if (nombrePanel.equals("Framingham1")) {
            this.xJPFramingham1 = new JPFramingham1();
            mostrarPanel(this.xJPFramingham1, panelPrincipal);
        } else if (nombrePanel.equals("Framingham_M")) {
            this.xJPFraminghamM = new JPFramingham_M();
            mostrarPanel(this.xJPFraminghamM, panelPrincipal);
        } else if (nombrePanel.equals("Biblioteca SO")) {
            this.xJPSoBiblioteca = new JPSoBiblioteca();
            mostrarPanel(this.xJPSoBiblioteca, panelPrincipal);
        } else if (nombrePanel.equals("Ruffier")) {
            this.xJPRuffier = new JPRuffier();
            mostrarPanel(this.xJPRuffier, panelPrincipal);
        } else if (nombrePanel.equals("Escala del dolor")) {
            this.xJPEscalaDolor = new JPEscalaDolor();
            mostrarPanel(this.xJPEscalaDolor, panelPrincipal);
        } else if (nombrePanel.equals("Escala fuerza muscular")) {
            this.xJPEscalaFuerzaMuscular = new JPEscalaFuerzaMuscular();
            mostrarPanel(this.xJPEscalaFuerzaMuscular, panelPrincipal);
        } else if (nombrePanel.equals("Test Findrisk")) {
            try {
                String sql = "SELECT PerimetroAbdominal, IMC FROM h_examenfisico WHERE Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                ResultSet xrs = this.xct.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getInt("IMC") > 0) {
                        if (xrs.getInt("PerimetroAbdominal") > 0) {
                            this.xJPTestFindrisk = new JPTestFindrisk();
                            mostrarPanel(this.xJPTestFindrisk, panelPrincipal);
                        } else {
                            JOptionPane.showInternalMessageDialog(fomularioSolicita, "Debe diligenciar el perímetro abdominal en el examen físico \n para poder continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(fomularioSolicita, "Debe diligenciar el IMC en el examen físico \n para poder continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        } else if (nombrePanel.equals("Revision Examenes So")) {
            this.xJPRevisonExamenSo = new JPRevisonExamenSo(Principal.clasehistoriace);
            mostrarPanel(this.xJPRevisonExamenSo, panelPrincipal);
        } else if (nombrePanel.equals("Revision Examenes So2")) {
            this.xJPRevisonExamenSo_V2 = new JPRevisonExamenSo_V2(Principal.clasehistoriace);
            mostrarPanel(this.xJPRevisonExamenSo_V2, panelPrincipal);
        } else if (nombrePanel.equals("jpeligros")) {
            this.xjPPeligros = new JPPeligros();
            mostrarPanel(this.xjPPeligros, panelPrincipal);
        } else if (nombrePanel.equals("Certificados Salud Ocupacional")) {
            this.xJPCertificadoSO = new JPCertificadoSO(Principal.clasehistoriace);
            mostrarPanel(this.xJPCertificadoSO, panelPrincipal);
        } else if (nombrePanel.equals("Evidencia Fotografica")) {
            this.xJPGaleriaImagenes = new JPGaleriaImagenes(Principal.clasehistoriace);
            mostrarPanel(this.xJPGaleriaImagenes, panelPrincipal);
        } else if (nombrePanel.equals("Fonoaudiologia")) {
            this.xJPAFonoaudiologia = new JPAFonoaudiologia(Principal.clasehistoriace);
            mostrarPanel(this.xJPAFonoaudiologia, panelPrincipal);
        } else if (nombrePanel.equals("Antecedentes Reumatología")) {
            this.xJPAAntecedenteReumatologia = new JPAAntecedenteReumatologia(Principal.clasehistoriace);
            mostrarPanel(this.xJPAAntecedenteReumatologia, panelPrincipal);
        } else if (nombrePanel.equals("Tamizaje Estético")) {
            this.xJPATamizajeEstetico = new JPATamizajeEstetico(Principal.clasehistoriace);
            mostrarPanel(this.xJPATamizajeEstetico, panelPrincipal);
        } else if (nombrePanel.equals("Test Psicomotriz")) {
            this.xJPSo_Psicomotriz = new JPSo_Psicomotriz(Principal.clasehistoriace);
            mostrarPanel(this.xJPSo_Psicomotriz, panelPrincipal);
        } else if (nombrePanel.equals("Deprecion Posparto") || nombrePanel.equals("Deprecion en Embarazo")) {
            this.xJPDepresionPosparto = new JPDepresionPosparto(Principal.clasehistoriace);
            mostrarPanel(this.xJPDepresionPosparto, panelPrincipal);
        } else if (nombrePanel.equals("Violencia y Maltrato")) {
            this.xJPMaltratoViolencia = new JPMaltratoViolencia(Principal.clasehistoriace);
            mostrarPanel(this.xJPMaltratoViolencia, panelPrincipal);
        } else if (nombrePanel.equals("Exámen Reumatológico")) {
            this.xJPReuConteoArticulaciones = new JPReuConteoArticulaciones();
            mostrarPanel(this.xJPReuConteoArticulaciones, panelPrincipal);
        } else if (nombrePanel.equals("Clasificación ACR Eular")) {
            this.xJPAClasificacionEular = new JPAClasificacionEular(Principal.clasehistoriace);
            mostrarPanel(this.xJPAClasificacionEular, panelPrincipal);
        } else if (nombrePanel.equals("Cuestionario de Discapacidad HAQ")) {
            this.xJPCuestionarioHAQ = new JPCuestionarioHAQ(Principal.clasehistoriace);
            mostrarPanel(this.xJPCuestionarioHAQ, panelPrincipal);
        } else if (nombrePanel.equals("Visiometria M")) {
            this.xJPSo_VisiometriaMineros = new JPSo_VisiometriaMineros();
            mostrarPanel(this.xJPSo_VisiometriaMineros, panelPrincipal);
        } else if (nombrePanel.equals("Antecedentes Gineco-Obstétricos")) {
            this.xJPAAntecedentesGinecobstetricos = new JPAAntecedentesGinecobstetricos(Principal.clasehistoriace);
            mostrarPanel(this.xJPAAntecedentesGinecobstetricos, panelPrincipal);
        } else if (nombrePanel.equals("jpiantecedentesFamiliares")) {
            this.antecedenteFamiliarTexto = new JPAntecedenteFamiliarTexto(Principal.clasehistoriace);
            mostrarPanel(this.antecedenteFamiliarTexto, panelPrincipal);
        } else if (nombrePanel.equals("Familiograma  y Ecomapa")) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            long idPersona = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            clasesHistoriaCE.informacionAgendaMedicaDTO.getFecha_HoraAtencion();
            System.out.println(Principal.informacionIps.getNombreIps());
            if (Principal.informacionIps.getAplica3280().intValue() == 1) {
                this.xJPAFamiliograma = new JPAFamiliograma(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), clasesHistoriaCE.informacionAgendaMedicaDTO.getFecha_HoraAtencion(), idPersona);
                mostrarPanel(this.xJPAFamiliograma, panelPrincipal);
            }
        } else if (nombrePanel.equals("JPAListaChequeo")) {
            System.err.println("llego");
            clasesHistoriaCE claseshistoriace3 = Principal.clasehistoriace;
            int i = Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            clasesHistoriaCE claseshistoriace4 = Principal.clasehistoriace;
            this.jPAListaChequeo = new JPAListaChequeo(i, nombreItems, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()));
            mostrarPanel(this.jPAListaChequeo, panelPrincipal);
        } else if (nombrePanel.equals("RQC")) {
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS")) {
                this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 18, 0);
                mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
            }
        } else if (nombrePanel.equals("Escala de Glasgow")) {
            this.xJPGlasgow = new JPGlasgow();
            mostrarPanel(this.xJPGlasgow, panelPrincipal);
        } else if (nombrePanel.equals("Progreso en los Hitos del desarrollo") || nombrePanel.equals("Resultados de las pruebas de tamizaje neonatal") || nombrePanel.equals("Valoración de salud mental") || nombrePanel.equals("Valoración de prácticas alimentarias") || nombrePanel.equals("Dinámica familiar como apoyo al desarrollo integral") || nombrePanel.equals("Valorar la salud sexual") || nombrePanel.equals("Valorar la salud visual") || nombrePanel.equals("Valorar la salud auditiva y comunicativa") || nombrePanel.equals("Otros aspectos físicos") || nombrePanel.equals("Valorar las estructuras dentomaxilofaciales  y su funcionalidad") || nombrePanel.equals("jpa_atencion_informacionn10")) {
            System.out.println("prueba" + Principal.informacionIps.getAplica3280());
            if (Principal.informacionIps.getAplica3280().intValue() == 1) {
                this.xJPA_Atencion_InformacionN10 = new JPA_Atencion_InformacionN10(nombreItems.toUpperCase(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), tipoHistoria, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaIngreso(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mostrarPanel(this.xJPA_Atencion_InformacionN10, panelPrincipal);
            }
        } else if (nombrePanel.equals("JPAEvaluacionRecienNacido")) {
            this.evaluacionRecienNacido = new JPAEvaluacionRecienNacido(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), "" + Principal.usuarioSistemaDTO.getIdUsuarioSistema());
            System.out.println("llego ");
            mostrarPanel(this.evaluacionRecienNacido, panelPrincipal);
        } else if (nombrePanel.equals("JPAVale")) {
            String fechaNacimiento3 = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace5 = Principal.clasehistoriace;
            this.jPaVale = new JPAVale(fechaNacimiento3, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
            mostrarPanel(this.jPaVale, panelPrincipal);
        } else if (nombrePanel.equals("jpAntecedentesFisicoPsiquiatrico")) {
            this.jpAntecedentesFisicosPsiquiatricos = new JPAntecedentesFisicosPsiquiatricos();
            mostrarPanel(this.jpAntecedentesFisicosPsiquiatricos, panelPrincipal);
        } else if (nombrePanel.equals("Comportamiento (Impresión de los Padres)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 13, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Método de disciplina")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 14, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Inteligencia (Impresión de los Padres)")) {
            this.xjifcuestionarios_n = new JPSo_Cuestionario_N(nombrePanel.toUpperCase(), 15, 0);
            mostrarPanel(this.xjifcuestionarios_n, panelPrincipal);
        } else if (nombrePanel.equals("Anexo 2")) {
            clasesHistoriaCE claseshistoriace6 = Principal.clasehistoriace;
            String string = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString();
            clasesHistoriaCE claseshistoriace7 = Principal.clasehistoriace;
            this.formularioAnexo2 = new JPI_FormularioAnexo2(string, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            mostrarPanel(this.formularioAnexo2, panelPrincipal);
        } else if (nombrePanel.equals("Anexo 3")) {
            clasesHistoriaCE claseshistoriace8 = Principal.clasehistoriace;
            this.formularioAnexo3 = new JPI_FormularioAnexo3(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString());
            mostrarPanel(this.formularioAnexo3, panelPrincipal);
        } else if (nombrePanel.equals("jpAtencionDieta")) {
            this.xJPAtencionDieta = new JPAtencionDieta(Principal.clasehistoriace);
            mostrarPanel(this.xJPAtencionDieta, panelPrincipal);
        } else if (nombrePanel.equals("jpa_TestCrb65")) {
            this.testCrb65 = new JPA_TestCrb65(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
            mostrarPanel(this.testCrb65, panelPrincipal);
        } else if (nombrePanel.equals("Ingreso CyD")) {
            this.xJP_IngresoProgramaCyD = new JP_IngresoProgramaCyD();
            mostrarPanel(this.xJP_IngresoProgramaCyD, panelPrincipal);
        } else if (nombrePanel.equals("JPAiepiOncologicoTest")) {
            clasesHistoriaCE claseshistoriace9 = Principal.clasehistoriace;
            this.aiepiOncologicoTest = new JPAiepiOncologicoTest(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido(), Principal.usuarioSistemaDTO.getNombreUsuario());
            mostrarPanel(this.aiepiOncologicoTest, panelPrincipal);
        } else if (nombrePanel.equals("jphistoricoatencionesvisionips")) {
            this.atencionesVisionIPS = new JPHistoricoAtencionesVisionIPS(Principal.clasehistoriace);
            mostrarPanel(this.atencionesVisionIPS, panelPrincipal);
        }
        System.out.println("llego paso por aqui " + nombrePanel);
    }

    private void mostrarPanel(JPanel formulario, JPanel panelPrincipal) {
        limpiarPanelPrincipal(panelPrincipal);
        formulario.setBounds(5, 5, panelPrincipal.getWidth() - 10, panelPrincipal.getHeight() - 10);
        panelPrincipal.add(formulario);
        panelPrincipal.setVisible(true);
    }

    private void limpiarPanelPrincipal(JPanel panelPrincipal) {
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
    }

    private void asignarCita() {
        System.out.println("\n\n\n\n\n" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "\n\n\n\n\n");
        List<Object[]> listaCitasRepetida = this.alertasGeneralesDAO.verificarNumeroCitasPorEspecialdiad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        if (listaCitasRepetida.isEmpty()) {
            return;
        }
        if (Long.valueOf(listaCitasRepetida.get(0)[1].toString()).longValue() == 0) {
            JOptionPane.showMessageDialog((Component) null, "Esta opción no esta disponible aun para esta Especialidad", "GENOMA SOFT", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else if (Long.valueOf(listaCitasRepetida.get(0)[1].toString()).longValue() == 1) {
            JDCitasInterConsulta xjdcita = new JDCitasInterConsulta(null, false, String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), Principal.usuarioSistemaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad(), "0", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
            xjdcita.setVisible(true);
        }
    }
}
