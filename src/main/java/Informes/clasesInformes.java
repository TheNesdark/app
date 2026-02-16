package Informes;

import Acceso.Principal;
import Laboratorio.JIFConsultasInfLab;
import Sgc.JIFResultadoEncuesta;
import Sig.JIFAuditoriaTriage;
import Sig.JIFInformesNProgramada;
import Sig.JIFRefConsultaNutricion;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import com.genoma.plus.controller.sig.JIFReporteExamenOcupacional;

/* JADX INFO: loaded from: GenomaP.jar:Informes/clasesInformes.class */
public class clasesInformes {
    private String sql;
    private Metodos metodos = new Metodos();
    private Principal principal;
    private JIFInformes jifinformes;
    private JIFInformesP jifinformesp;
    private JIFRActividades jifactividades;
    private JIFProgramacionActividadesPyP jifprogactividades;
    private JIFRegistroActividadesPyPUsuario jifregactividades;
    private JIFAuditoriaTriage jifauditoriatriage;
    private JIFAuditoriaHC jifauditoriahc;
    private JIFAuditoriaTiemposInf jifautoriatiempo;
    public JIFConsultasInfLab xjiconsultainf;
    private JIFRefConsultaNutricion xjifconsnutricion;
    private JIFInformesNProgramada xjifconsultarNp;
    private JIFAuditoriaInventario xjifauditoriainventario;
    private JIFResultadoEncuesta xjifresultadoencuesta;
    private JIFInformesVarios xjifinformesv;
    private JIFReporteExamenOcupacional xJifReporteSO;
    private JIF_Reportes_PyP_Generico jifreportes;

    public void cargarPantalla(String frm) {
        if (frm.equals("Usuarios por Programas") || frm.equals("Usuarios por Programa por EPS por Edad") || frm.equals("Morbilidad x Tipo de Consulta") || frm.equals("Consultadores Crónicos x Especialidad") || frm.equals("Procedimientos Facturados x Empresa") || frm.equals("Consolidado de Información")) {
            this.jifinformes = new JIFInformes(frm);
            Principal.cargarPantalla(this.jifinformes);
            return;
        }
        if (frm.equals("Incapacidades")) {
            this.jifinformesp = new JIFInformesP("INCAPACIDADES", "jifgenerador");
            Principal.cargarPantalla(this.jifinformesp);
            return;
        }
        if (frm.equals("Actividades")) {
            this.jifactividades = new JIFRActividades();
            Principal.cargarPantalla(this.jifactividades);
            return;
        }
        if (frm.equals("Consultar Concepto Salud Ocupacional")) {
            this.xJifReporteSO = new JIFReporteExamenOcupacional("xJIFReporteExamenOcupacional1");
            Principal.cargarPantalla(this.xJifReporteSO);
            return;
        }
        if (frm.equals("Calendario de Actividades")) {
            this.jifprogactividades = new JIFProgramacionActividadesPyP();
            Principal.cargarPantalla(this.jifprogactividades);
            return;
        }
        if (frm.equals("Registro x Usuario")) {
            this.jifregactividades = new JIFRegistroActividadesPyPUsuario();
            Principal.cargarPantalla(this.jifregactividades);
            return;
        }
        if (frm.equals("Auditoria de Triage")) {
            this.jifauditoriatriage = new JIFAuditoriaTriage("jifauditoriatriage");
            Principal.cargarPantalla(this.jifauditoriatriage);
            return;
        }
        if (frm.equals("Auditoria HC")) {
            this.jifauditoriahc = new JIFAuditoriaHC("jifauditoriahc");
            Principal.cargarPantalla(this.jifauditoriahc);
            return;
        }
        if (frm.equals("Laboratorio - Atención Médica")) {
            this.jifautoriatiempo = new JIFAuditoriaTiemposInf(0, frm.toUpperCase());
            Principal.cargarPantalla(this.jifautoriatiempo);
            return;
        }
        if (frm.equals("Facturación - Atención Médica Programada")) {
            this.jifautoriatiempo = new JIFAuditoriaTiemposInf(1, frm.toUpperCase());
            Principal.cargarPantalla(this.jifautoriatiempo);
            return;
        }
        if (frm.equals("Médicos Generales") || frm.equals("Médicos Especialistas") || frm.equals("Remisiones x Medicos Generales") || frm.equals("Remisiones x Medicos Especialistas") || frm.equals("Remisiones x Medicos PyP") || frm.equals("Consolidado de Citas")) {
            this.jifinformesp = new JIFInformesP(frm, "jifgenerador1");
            Principal.cargarPantalla(this.jifinformesp);
            return;
        }
        if (frm.equals("Estadistica de Recepciones")) {
            this.xjiconsultainf = new JIFConsultasInfLab("jifconsinformelab1", frm);
            Principal.cargarPantalla(this.xjiconsultainf);
            return;
        }
        if (frm.equals("Actualizar Referencia de Consulta")) {
            this.xjifconsnutricion = new JIFRefConsultaNutricion("xjifreferenciac");
            Principal.cargarPantalla(this.xjifconsnutricion);
            return;
        }
        if (frm.equals("Auditoria de Productos")) {
            this.xjifauditoriainventario = new JIFAuditoriaInventario();
            Principal.cargarPantalla(this.xjifauditoriainventario);
            return;
        }
        if (frm.equals("Consolidado de Atenciones No Programadas x Médicos")) {
            this.xjifconsultarNp = new JIFInformesNProgramada("jifatencionesnpfac");
            Principal.cargarPantalla(this.xjifconsultarNp);
            return;
        }
        if (frm.equals("Resultado Encuesta")) {
            this.xjifresultadoencuesta = new JIFResultadoEncuesta();
            Principal.cargarPantalla(this.xjifresultadoencuesta);
            return;
        }
        if (frm.equals("Consultar Información Nutricional")) {
            this.xjifconsnutricion = new JIFRefConsultaNutricion("xjifconsultarinfn");
            Principal.cargarPantalla(this.xjifconsnutricion);
        } else if (frm.equals("Atenciones_Riesgo")) {
            this.xjifinformesv = new JIFInformesVarios("CONSOLIDADO DE ATENCIONES", "jifinformesvarios1");
            Principal.cargarPantalla(this.xjifinformesv);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(8, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void nuevo(String frm) {
        if (!frm.equals("jifractividadespyp")) {
            if (!frm.equals("jifprogactividadespyp")) {
                if (!frm.equals("jifregactividadespyp")) {
                    if (!frm.equals("jifauditoriahc")) {
                        if (frm.equals("xJIFReporteExamenOcupacional1")) {
                            this.xJifReporteSO.mNuevo();
                            return;
                        }
                        return;
                    }
                    this.jifauditoriahc.nuevo();
                    return;
                }
                this.jifregactividades.mNuevo();
                return;
            }
            this.jifprogactividades.nuevo();
            return;
        }
        this.jifactividades.nuevo();
    }

    public void grabar(String frm) {
        if (!frm.equals("jifractividadespyp")) {
            if (!frm.equals("jifprogactividadespyp")) {
                if (frm.equals("xjifreferenciac")) {
                    this.xjifconsnutricion.mGrabar();
                    return;
                }
                return;
            }
            this.jifprogactividades.grabar();
            return;
        }
        this.jifactividades.grabar();
    }

    public void buscar(String frm) {
        if (!frm.equals("jifauditoriatriage")) {
            if (!frm.equals("jifauditoriahc")) {
                if (!frm.equals("jifauditoriatiempo")) {
                    if (!frm.equals("jifconsinformelab")) {
                        if (!frm.equals("jifregactividadespyp")) {
                            if (!frm.equals("jifatencionesnpfac")) {
                                if (!frm.equals("jifresultadoencuesta")) {
                                    if (!frm.equals("xjifreferenciac") && !frm.equals("xjifconsultarinfn")) {
                                        if (!frm.equals("jifinformesvarios1")) {
                                            if (frm.equals("xJIFReporteExamenOcupacional1")) {
                                                this.xJifReporteSO.mBuscar();
                                                return;
                                            }
                                            return;
                                        }
                                        this.xjifinformesv.mBuscar();
                                        return;
                                    }
                                    this.xjifconsnutricion.mBuscar();
                                    return;
                                }
                                this.xjifresultadoencuesta.mBuscar();
                                return;
                            }
                            this.xjifconsultarNp.mBuscar();
                            return;
                        }
                        this.jifregactividades.mBuscar();
                        return;
                    }
                    this.xjiconsultainf.mBuscar();
                    return;
                }
                this.jifautoriatiempo.buscar();
                return;
            }
            this.jifauditoriahc.buscar();
            return;
        }
        this.jifauditoriatriage.mBuscar();
    }

    public void imprimir(String frm) {
        if (frm.equals("jifgenerador1")) {
            this.jifinformesp.mImprimirInforme();
        }
    }

    public void anular(String frm) {
    }
}
