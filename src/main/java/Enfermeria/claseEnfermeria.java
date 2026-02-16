package Enfermeria;

import Acceso.Principal;
import Citas.CitaNP;
import Facturacion.JIFAutorizacion_Servicios;
import Facturacion.JIFInformacion_Empresa;
import Historia.JIFAcronimos;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFRVisitasDomiciliarias;
import Historia.JIFRegistroAtencionesEsp;
import Mantenimiento.JIFReporte;
import Salud_Ocupacional.JIFFInformes;
import Salud_Ocupacional.JIFPrueba_AyD;
import Salud_Ocupacional.JIFTest_Fatiga;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia;
import com.genoma.plus.controller.enfermeria.JIFReporteSolicitudAlimentacion;
import com.genoma.plus.controller.enfermeria.JIFSolicitudAlimentacion;
import com.genoma.plus.controller.enfermeria.JIF_AgendProcedimiento;
import com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeria;
import com.genoma.plus.controller.enfermeria.JIF_AgendaServicioEnfermeriaV2;
import com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/claseEnfermeria.class */
public class claseEnfermeria {
    public Atencion frmAtencion;
    private JIFInformes xjifinformes;
    private String sql;
    public JIFReporte xjifreporte;
    private JIFAcronimos xjifacronimos;
    private JIFRVisitasDomiciliarias xjifregistronotas;
    private JIFRegistroAtencionesEsp xjifatencionesp;
    public JIFRVisitasDomiciliarias xjifvisitasdoc;
    private JIFConsultarExamenesxUsuario xjifexausuario;
    private JIFPrueba_AyD xJIFPrueba_AyD;
    private JIFTest_Fatiga xjiftestfatiga;
    private JIFFInformes xjiffinformes;
    public JIFHistoria_UH xjifhc_uhh;
    public CitaNP xjif_citanp;
    public Principal xjp;
    private JIFCensoCama xJIFCensoCama;
    public JIFAutorizacion_Servicios xjifautorizacion_servicio;
    public JIFConteoUnidosisAgrupadasUregencia xJIFConteoUnidosisAgrupadasUregencia;
    public JIF_AgendProcedimiento agendProcedimiento;
    public JIFSolicitudAlimentacion solicitudAlimentacion;
    public JIFReporteSolicitudAlimentacion reporteSolicitudAlimentacion;
    public JPI_SeguimientoPosparto xSeguimientoPosparto;
    public JIF_AgendaServicioEnfermeria agendaServicioEnfermeria;
    public JIF_AgendaServicioEnfermeriaV2 agendaServicioEnfermeriaV2;
    private JIF_Reportes_PyP_Generico jifreportes;
    private JIFInformacion_Empresa xjifconsultar_infempresa;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public Agenda xjifagenda = null;
    public JIFAgenda_UH xjifagenda_UH = null;

    public claseEnfermeria(Principal xjp) {
        this.xjp = xjp;
    }

    public void anular(String frm) {
        if (frm.equals("Atencion")) {
            this.frmAtencion.anular();
        }
        if (frm.equals("xjifhistoriauh")) {
            switch (this.xjifhc_uhh.JPNVentana.getComponent(0).getName()) {
                case "xpControlOxigeno":
                    this.xjifhc_uhh.xJPControlOxigeno.mAnular();
                    break;
                case "xjpescaneodocumentosenf":
                    this.xjifhc_uhh.xJPEscaneoDocumentosEnf.mAnular();
                    break;
                case "xjphojatratamiento":
                    this.xjifhc_uhh.xJPHojaTratamiento.mAnular();
                    break;
                case "jifControlDM_Enf":
                    this.xjifhc_uhh.xJPControlDiabetes.mAnular();
                    break;
                case "xjpseguimientoposparto":
                    this.xjifhc_uhh.xSeguimientoPosparto.mAnular();
                    break;
                case "jpi_atencionEnfermeria":
                    this.xjifhc_uhh.atencionEnfermeria.anular();
                    break;
            }
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "Atencion":
                this.frmAtencion.buscar();
                break;
            case "jifregistronota":
                this.xjifregistronotas.mBuscar();
                break;
            case "jifregistroatencionesp":
                this.xjifatencionesp.mBuscar();
                break;
            case "jifconsultarRemOrdEnfer":
                this.xjifexausuario.mBuscar();
                break;
            case "xjifaydInfe":
            case "xjiftestfatigaInfe":
                this.xjiffinformes.mBuscar();
                break;
            case "xJIFConsultarUnidosis":
                this.xJIFConteoUnidosisAgrupadasUregencia.mBuscar();
                break;
            case "jifSolicitudAlimentacion":
                this.solicitudAlimentacion.buscar();
                break;
            case "jifReporteSolicitudAlimentacion":
                this.reporteSolicitudAlimentacion.buscar();
                break;
            case "jif_ReportesGeneralEnfermeria":
                this.jifreportes.mBuscar();
                break;
            case "xjifconsulta_informacion_Hosp1":
                this.xjifconsultar_infempresa.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm, String idOrdenAyudaDiagnostica, String idOrdenProcedimiento) {
        if (frm.equals("Generador de Autorizacion de Servicios")) {
            this.xjifautorizacion_servicio = new JIFAutorizacion_Servicios(0L, 3, "xjifautorizacion_servicios1", idOrdenAyudaDiagnostica, idOrdenProcedimiento);
            Principal.cargarPantalla(this.xjifautorizacion_servicio);
        }
    }

    public void cargarPantalla(String frm, String modulo) {
        if (frm.equals("Agenda")) {
            if (this.xjifagenda != null) {
                this.xjifagenda.dispose();
            }
            this.xjifagenda = new Agenda(this, modulo);
            Principal.cargarPantalla(this.xjifagenda);
            this.xjifagenda.moveToFront();
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Agenda":
                if (this.xjifagenda != null) {
                    this.xjifagenda.dispose();
                }
                this.xjifagenda = new Agenda(this, "enfermeria");
                Principal.cargarPantalla(this.xjifagenda);
                this.xjifagenda.moveToFront();
                break;
            case "Consulta de Usuarios Hospitalizados":
                this.xjifconsultar_infempresa = new JIFInformacion_Empresa("xjifconsulta_informacion_Hosp1", frm.toUpperCase());
                Principal.cargarPantalla(this.xjifconsultar_infempresa);
                break;
            case "Atencion":
                if (this.frmAtencion != null) {
                    this.frmAtencion.dispose();
                }
                this.frmAtencion = new Atencion(this);
                Principal.cargarPantalla(this.frmAtencion);
                this.frmAtencion.moveToFront();
                break;
            case "Reporte Solicitud Alimentación":
                if (this.reporteSolicitudAlimentacion != null) {
                    this.reporteSolicitudAlimentacion.dispose();
                }
                this.reporteSolicitudAlimentacion = new JIFReporteSolicitudAlimentacion();
                Principal.cargarPantalla(this.reporteSolicitudAlimentacion);
                this.reporteSolicitudAlimentacion.moveToFront();
                break;
            case "Solicitud de Alimentación":
                if (this.solicitudAlimentacion != null) {
                    this.solicitudAlimentacion.dispose();
                }
                this.solicitudAlimentacion = new JIFSolicitudAlimentacion();
                Principal.cargarPantalla(this.solicitudAlimentacion);
                this.solicitudAlimentacion.moveToFront();
                break;
            case "Registro Diario":
                if (this.xjifinformes != null) {
                    this.xjifinformes.dispose();
                }
                this.xjifinformes = new JIFInformes();
                Principal.cargarPantalla(this.xjifinformes);
                this.xjifinformes.moveToFront();
                break;
            case "Reporte":
                if (this.xjifreporte != null) {
                    this.xjifreporte.dispose();
                }
                this.xjifreporte = new JIFReporte("jifreporte3");
                Principal.cargarPantalla(this.xjifreporte);
                this.xjifreporte.moveToFront();
                break;
            case "Consultar Acrónimos":
                if (this.xjifacronimos != null) {
                    this.xjifacronimos.dispose();
                }
                this.xjifacronimos = new JIFAcronimos();
                Principal.cargarPantalla(this.xjifacronimos);
                this.xjifacronimos.moveToFront();
                break;
            case "Registro de Notas":
                if (this.xjifregistronotas != null) {
                    this.xjifregistronotas.dispose();
                }
                this.xjifregistronotas = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), frm, "jifregistronota", new Long(0L), 0);
                Principal.cargarPantalla(this.xjifregistronotas);
                this.xjifregistronotas.moveToFront();
                break;
            case "Atencion Especial":
                if (this.xjifatencionesp != null) {
                    this.xjifatencionesp.dispose();
                }
                this.xjifatencionesp = new JIFRegistroAtencionesEsp("jifregistroatencionesp");
                Principal.cargarPantalla(this.xjifatencionesp);
                this.xjifatencionesp.moveToFront();
                break;
            case "Notas_Procedimiento":
                if (this.xjifvisitasdoc != null) {
                    this.xjifvisitasdoc.dispose();
                }
                this.xjifvisitasdoc = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), "Notas", "xjifnotas", Principal.claseenfer.agendProcedimiento.getIdIngreso(), 1);
                Principal.cargarPantalla(this.xjifvisitasdoc);
                this.xjifvisitasdoc.moveToFront();
                break;
            case "Notas":
                if (this.xjifvisitasdoc != null) {
                    this.xjifvisitasdoc.dispose();
                }
                this.xjifvisitasdoc = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), "Notas", "xjifnotas", this.xjifagenda.xidingreso, 0);
                Principal.cargarPantalla(this.xjifvisitasdoc);
                this.xjifvisitasdoc.moveToFront();
                break;
            case "Consultar Remisiones y Ordenes":
                this.xjifexausuario = new JIFConsultarExamenesxUsuario("jifconsultarRemOrdEnfer");
                Principal.cargarPantalla(this.xjifexausuario);
                break;
            case "Prueba AyD":
                this.xJIFPrueba_AyD = new JIFPrueba_AyD("xjifpuebaaydE");
                Principal.cargarPantalla(this.xJIFPrueba_AyD);
                break;
            case "Test Fatiga":
                this.xjiftestfatiga = new JIFTest_Fatiga("xjiftestfatigaE");
                Principal.cargarPantalla(this.xjiftestfatiga);
                break;
            case "AyD por Fecha":
                this.xjiffinformes = new JIFFInformes("xjifaydInfe", "Informe AyD");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "Test de Fatiga por Fecha":
                this.xjiffinformes = new JIFFInformes("xjiftestfatigaInfe", "Informe Test de Fatiga");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "Agenda Servicios":
                if (this.agendaServicioEnfermeria != null) {
                    this.agendaServicioEnfermeria.dispose();
                }
                if (this.agendaServicioEnfermeriaV2 != null) {
                    this.agendaServicioEnfermeriaV2.dispose();
                }
                this.agendaServicioEnfermeria = new JIF_AgendaServicioEnfermeria();
                Principal.cargarPantalla(this.agendaServicioEnfermeria);
                this.agendaServicioEnfermeria.moveToFront();
                break;
            case "Agenda Servicios (Beta)":
                System.out.println("entrooo en beta ");
                if (this.agendaServicioEnfermeria != null) {
                    this.agendaServicioEnfermeria.dispose();
                }
                if (this.agendaServicioEnfermeriaV2 != null) {
                    this.agendaServicioEnfermeriaV2.dispose();
                }
                this.agendaServicioEnfermeriaV2 = new JIF_AgendaServicioEnfermeriaV2();
                Principal.cargarPantalla(this.agendaServicioEnfermeriaV2);
                this.agendaServicioEnfermeriaV2.moveToFront();
                break;
            case "Agenda Urgencias - Hospitalizacion":
                this.xjifagenda_UH = new JIFAgenda_UH(0);
                Principal.cargarPantalla(this.xjifagenda_UH);
                break;
            case "CitasNP":
                if (this.xjif_citanp != null) {
                    this.xjif_citanp.dispose();
                }
                this.xjif_citanp = new CitaNP(Principal.clasescita);
                Principal.cargarPantalla(this.xjif_citanp);
                this.xjif_citanp.moveToFront();
                break;
            case "Censo de Camas":
                this.xJIFCensoCama = new JIFCensoCama("xjifcensocama");
                Principal.cargarPantalla(this.xJIFCensoCama);
                break;
            case "Consultar Unidosis Aplicada":
                this.xJIFConteoUnidosisAgrupadasUregencia = new JIFConteoUnidosisAgrupadasUregencia("xJIFConsultarUnidosis");
                Principal.cargarPantalla(this.xJIFConteoUnidosisAgrupadasUregencia);
                break;
            case "Agenda de Procedimientos":
                this.agendProcedimiento = new JIF_AgendProcedimiento();
                Principal.cargarPantalla(this.agendProcedimiento);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(3, "INFORMES GENERALES", "jif_ReportesGeneralEnfermeria");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void desplazarPuntero(int pos, String frm) {
        if (frm.equals("Atencion")) {
            if (pos == 6) {
                this.frmAtencion.frmIngreso.mPrimerIngreso();
                return;
            }
            if (pos == 7) {
                this.frmAtencion.frmIngreso.mAnteriorIngreso();
            } else if (pos == 8) {
                this.frmAtencion.frmIngreso.mSiguienteIngreso();
            } else if (pos == 9) {
                this.frmAtencion.frmIngreso.mUltimoIngreso();
            }
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "Atencion":
                this.frmAtencion.grabar();
                break;
            case "jifreporte3":
                this.xjifreporte.grabar();
                break;
            case "jifregistronota":
                this.xjifregistronotas.grabar();
                break;
            case "jifregistroatencionesp":
                this.xjifatencionesp.mGrabar();
                break;
            case "xjifnotas":
                this.xjifvisitasdoc.grabar();
                break;
            case "xjifpuebaaydE":
                this.xJIFPrueba_AyD.mGrabar();
                break;
            case "xjiftestfatigaE":
                this.xjiftestfatiga.mGrabar();
                break;
            case "xjifhistoriauh":
                this.xjifhc_uhh.mGrabar();
                break;
            case "jifSolicitudAlimentacion":
                this.solicitudAlimentacion.grabar();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "Atencion":
                this.frmAtencion.imprimirTriage();
                break;
            case "xjiftestfatigaE":
                this.xjiftestfatiga.mImprimir();
                break;
            case "xjifcensocama":
                this.xJIFCensoCama.mImprimir();
                break;
            case "xjifhistoriauh":
                switch (this.xjifhc_uhh.JPNVentana.getComponent(0).getName()) {
                    case "xjp_impresion_doc":
                        this.xjifhc_uhh.xJPImpresion_Doc.mImprimir();
                        break;
                    case "xjpaplicaciontto":
                        this.xjifhc_uhh.xjpaplicaciontto.mImprimirAplicacionTto();
                        break;
                    case "jifControlDM_Enf":
                        this.xjifhc_uhh.xJPControlDiabetes.mImprimir();
                        break;
                    case "xpControlOxigeno":
                        this.xjifhc_uhh.xJPControlOxigeno.mImprimir();
                        break;
                    case "xpControlLiquidos":
                        this.xjifhc_uhh.xJPControlLiquidos.mImprimir();
                        break;
                    case "jpnotac":
                        this.xjifhc_uhh.xjp_notas.mImprimir();
                        break;
                    case "xjphojatratamiento":
                        this.xjifhc_uhh.xJPHojaTratamiento.mImprimir();
                        break;
                    case "jpi_formulario_anexo2":
                        this.xjifhc_uhh.formularioAnexo2.imprimir();
                        break;
                    case "xjpi_formulaanexo3":
                        this.xjifhc_uhh.formularioAnexo3.imprimir();
                        break;
                    case "xjpeventoadverso":
                        this.xjifhc_uhh.xJPEventoAdverso.mImprimir();
                        break;
                    case "xjpseguimientoposparto":
                        this.xjifhc_uhh.xSeguimientoPosparto.Imprimir();
                        break;
                    case "jpi_atencionEnfermeria":
                        this.xjifhc_uhh.atencionEnfermeria.imprimir();
                        break;
                    case "jpremisiones":
                        this.xjifhc_uhh.xJPRemisiones.imprimir();
                        break;
                }
                break;
            case "jifReporteSolicitudAlimentacion":
                this.reporteSolicitudAlimentacion.imprimir();
                break;
            case "xjpseguimientoposparto":
                this.xSeguimientoPosparto.Imprimir();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "Atencion":
                this.frmAtencion.nuevo();
                break;
            case "jifreporte3":
                this.xjifreporte.nuevo();
                break;
            case "jifregistronota":
                this.xjifregistronotas.nuevo();
                break;
            case "jifregistroatencionesp":
                this.xjifatencionesp.mNuevo();
                break;
            case "xjifnotas":
                this.xjifvisitasdoc.nuevo();
                break;
            case "jifconsultarRemOrdEnfer":
                this.xjifexausuario.mNuevo();
                break;
            case "xjifpuebaaydE":
                this.xJIFPrueba_AyD.mNuevo();
                break;
            case "xjiftestfatigaE":
                this.xjiftestfatiga.mNuevo();
                break;
            case "xjifhistoriauh":
                this.xjifhc_uhh.mNuevo();
                break;
            case "xjifcensocama":
                this.xJIFCensoCama.mNuevo();
                break;
            case "xJIFConsultarUnidosis":
                this.xJIFConteoUnidosisAgrupadasUregencia.mNuevo();
                break;
            case "jifSolicitudAlimentacion":
                this.solicitudAlimentacion.nuevo();
                break;
            case "jifReporteSolicitudAlimentacion":
                this.reporteSolicitudAlimentacion.nuevo();
                break;
        }
    }
}
