package GestionDoc;

import Acceso.Principal;
import General.JIFRadicacionDocClinico;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFConsultarHistorial;
import Historia.JIFConsultarResultadoExamenes;
import Historia.JIFIncapacidades;
import Laboratorio.JIFGenerarReporteExamen;
import Mantenimiento.JIFReporte;
import Sgc.JIFEncuestaS;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla;
import com.genoma.plus.controller.imagenesdx.JIFFInformeLecturaUsuarios;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/clasesGestionDoc.class */
public class clasesGestionDoc {
    private JIFConsultarAyudasDx xjifconsultaradx;
    public JIFConsultarHistorial xjifconsultarhc;
    private JIFCargarAyudasDxLote xjifimportarayudaslotes;
    private JIFCargarDocumentosHC xjifcargaatencionesmanuales;
    private JIFGestionExamenes xjigestionexamenes;
    public JIFRegistroQrsr xjiregistroqrsr;
    private JIFSeguimientoQrsr xjifseguimientoqrsr;
    private JIFConsultarResultadoExamenes xjifconsultarexamen;
    public JIFConsultarExamenesxUsuario xjiconsultarexusuario;
    public JIFReporte xjifreporte;
    private JIFGenerarExamenUsuario xjidgenerarexamenusuario;
    private JIFGenerarReporteExamen xjifgenerarreportesexamen;
    private JIFSolicitudDocumentosHC xjifsolicituddoc;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    public Principal frmPrincipal;
    private JIFEncuestaS xjifencuenta;
    private JIFCopiaDocumentosG xjifcopiadocumentos;
    public JIFIncapacidades xjifincapacidad;
    private JIFCargarSoporteLoteGD xjifcargarsoportelote;
    private JIFConsultarMovDocClinicos xjifdocclinico;
    private JIFConsultarCitaProgramada xjifcitaprogramada;
    private JIFRadicacionDocClinico xradicadodoc;
    private JIFFInformeLecturaUsuarios xJIFFInformeLecturaUsuarios;
    private JIFExportacionHCPDFPlantilla cPDFPlantilla;
    private JIF_Reportes_PyP_Generico jifreportes;

    public void cargarPantalla(String frm, Principal frmP) {
        this.frmPrincipal = frmP;
        switch (frm) {
            case "Consultar Historia":
                this.xjifconsultarhc = new JIFConsultarHistorial(0, "jifconsultarhistorial1");
                this.xjifconsultarhc.setName("jifconsultarhc");
                Principal.cargarPantalla(this.xjifconsultarhc);
                break;
            case "Informe De Lecturas Por Usuario":
                this.xJIFFInformeLecturaUsuarios = new JIFFInformeLecturaUsuarios("xjiffinformelecturausuarios1");
                Principal.cargarPantalla(this.xJIFFInformeLecturaUsuarios);
                break;
            case "Solicitud de Documentos Clínicos":
                this.xjifsolicituddoc = new JIFSolicitudDocumentosHC("xjifsolicituddochc");
                Principal.cargarPantalla(this.xjifsolicituddoc);
                break;
            case "Copia de Docuemtos":
                this.xjifcopiadocumentos = new JIFCopiaDocumentosG("xjiftranferenciadoc");
                Principal.cargarPantalla(this.xjifcopiadocumentos);
                break;
            case "Consultar Ayudas Dx":
            case "Ayudas Diagnostica Individual":
                this.xjifconsultaradx = new JIFConsultarAyudasDx();
                Principal.cargarPantalla(this.xjifconsultaradx);
                break;
            case "Ayudas Diagnosticas x Lote":
                this.xjifimportarayudaslotes = new JIFCargarAyudasDxLote();
                Principal.cargarPantalla(this.xjifimportarayudaslotes);
                break;
            case "Atenciones Manuales":
                this.xjifcargaatencionesmanuales = new JIFCargarDocumentosHC();
                Principal.cargarPantalla(this.xjifcargaatencionesmanuales);
                break;
            case "Historia Clinica en PDF":
                this.xjifconsultarhc = new JIFConsultarHistorial(1);
                Principal.cargarPantalla(this.xjifconsultarhc);
                break;
            case "Gestion de Examenes":
                this.xjigestionexamenes = new JIFGestionExamenes();
                Principal.cargarPantalla(this.xjigestionexamenes);
                break;
            case "Registro de QRSR":
                this.xjiregistroqrsr = new JIFRegistroQrsr(this);
                Principal.cargarPantalla(this.xjiregistroqrsr);
                break;
            case "Seguimiento a QRSR":
                this.xjifseguimientoqrsr = new JIFSeguimientoQrsr();
                Principal.cargarPantalla(this.xjifseguimientoqrsr);
                break;
            case "Consultar Resultado de Exámenes":
                this.xjifconsultarexamen = new JIFConsultarResultadoExamenes("jifconsultarresultado1");
                Principal.cargarPantalla(this.xjifconsultarexamen);
                break;
            case "Consultar Resultado de Exámenes x Usuario":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarexamenesusuario1");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Reporte":
                this.xjifreporte = new JIFReporte("jifreporte4");
                Principal.cargarPantalla(this.xjifreporte);
                break;
            case "Exámenes de Laboratorio por Usuario":
                this.xjidgenerarexamenusuario = new JIFGenerarExamenUsuario();
                Principal.cargarPantalla(this.xjidgenerarexamenusuario);
                break;
            case "Resultados de  Laboratorio por Fecha":
                this.xjifgenerarreportesexamen = new JIFGenerarReporteExamen("jifgenerarreporte1");
                Principal.cargarPantalla(this.xjifgenerarreportesexamen);
                break;
            case "Registro Encuesta":
                this.xjifencuenta = new JIFEncuestaS("xjifregistroencuesta");
                Principal.cargarPantalla(this.xjifencuenta);
                break;
            case "Cargar Soporte Lotes GD":
                this.xjifcargarsoportelote = new JIFCargarSoporteLoteGD();
                Principal.cargarPantalla(this.xjifcargarsoportelote);
                break;
            case "Reporte Movimiento Documentos Clínicos":
                this.xjifdocclinico = new JIFConsultarMovDocClinicos("Reporte Movimiento Documentos Clínicos");
                Principal.cargarPantalla(this.xjifdocclinico);
                break;
            case "Consultar Citas Programadas":
                this.xjifcitaprogramada = new JIFConsultarCitaProgramada("Consultar Citas Programadas", "xjiconscprogramada");
                Principal.cargarPantalla(this.xjifcitaprogramada);
                break;
            case "Archivar Documentos Clínicos":
                this.xradicadodoc = new JIFRadicacionDocClinico("Archivar Documentos Clínicos");
                Principal.cargarPantalla(this.xradicadodoc);
                break;
            case "Consultar Remisiones y Ordenes":
                this.xjiconsultarexusuario = new JIFConsultarExamenesxUsuario("jifconsultarRemOrd");
                Principal.cargarPantalla(this.xjiconsultarexusuario);
                break;
            case "Consultar Atenciones":
                this.xjifcitaprogramada = new JIFConsultarCitaProgramada("Consultar Historia Clínica de Atenciones", "xjiconshc_atenciones");
                Principal.cargarPantalla(this.xjifcitaprogramada);
                break;
            case "ExportacionHCPDFPlantilla":
                this.cPDFPlantilla = new JIFExportacionHCPDFPlantilla();
                Principal.cargarPantalla(this.cPDFPlantilla);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(14, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifconsultarayudasdx":
                this.xjifconsultaradx.nuevo();
                break;
            case "jifimportarayudasdxlote":
                this.xjifimportarayudaslotes.nuevo();
                break;
            case "jifcargaratencionesmanuales":
                this.xjifcargaatencionesmanuales.nuevo();
                break;
            case "jifexportacionmasivahcpdf":
                this.cPDFPlantilla.nuevo();
                break;
            case "jifgestionexamenes":
                this.xjigestionexamenes.nuevo();
                break;
            case "jifconsultarhc":
            case "jifconsultarhistorial1":
                this.xjifconsultarhc.nuevo();
                break;
            case "jifregistroqrsr":
                this.xjiregistroqrsr.nuevo();
                break;
            case "jifseguimientoqrsr":
                this.xjifseguimientoqrsr.nuevo();
                break;
            case "jifreporte4":
                this.xjifreporte.nuevo();
                break;
            case "jifgenerarreportexusuario":
                this.xjidgenerarexamenusuario.mNuevo();
                break;
            case "xjifregistroencuesta":
                this.xjifencuenta.mNuevo(1);
                break;
            case "xjifsolicituddochc":
                this.xjifsolicituddoc.mNuevo();
                break;
            case "jifconsultarexamenesusuario1":
                this.xjiconsultarexusuario.mNuevo();
                break;
            case "jifconsultarRemOrd":
                this.xjiconsultarexusuario.mNuevo();
                break;
            case "xjiconsDocClinico":
                this.xjifdocclinico.mNuevo();
                break;
            case "Archivar Documentos Clínicos":
                this.xradicadodoc.mNuevo();
                break;
            case "xjiconscprogramada":
            case "xjiconshc_atenciones":
                this.xjifcitaprogramada.mNuevo();
                break;
            case "xjiffinformelecturausuarios1":
                this.xJIFFInformeLecturaUsuarios.mNuevo();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifconsultarayudasdx":
                this.xjifconsultaradx.grabar();
                break;
            case "jifimportarayudasdxlote":
                this.xjifimportarayudaslotes.grabar();
                break;
            case "jifcargaratencionesmanuales":
                this.xjifcargaatencionesmanuales.grabar();
                break;
            case "jifgestionexamenes":
                this.xjigestionexamenes.grabar();
                break;
            case "jifregistroqrsr":
                this.xjiregistroqrsr.grabar();
                break;
            case "jifseguimientoqrsr":
                this.xjifseguimientoqrsr.grabar();
                break;
            case "jifreporte4":
                this.xjifreporte.grabar();
                break;
            case "xjifregistroencuesta":
                this.xjifencuenta.mGrabar();
                break;
            case "xjiftranferenciadoc":
                this.xjifcopiadocumentos.mGrabar();
                break;
            case "xjifsolicituddochc":
                this.xjifsolicituddoc.mGrabar();
                break;
            case "xjifcargarsoportelotegd":
                this.xjifcargarsoportelote.mGrabar();
                break;
            case "Archivar Documentos Clínicos":
                this.xradicadodoc.mGrabar();
                break;
        }
    }

    public void buscar(String frm) {
        if (frm.equals("jifconsultarayudasdx")) {
            this.xjifconsultaradx.buscar();
            return;
        }
        if (frm.equals("jifcargaratencionesmanuales")) {
            this.xjifcargaatencionesmanuales.buscar();
            return;
        }
        if (frm.equals("jifgestionexamenes")) {
            this.xjigestionexamenes.buscar();
            return;
        }
        if (frm.equals("jifconsultarhistorial1")) {
            this.xjifconsultarhc.buscar();
            return;
        }
        if (frm.equals("jifexportacionmasivahcpdf")) {
            this.cPDFPlantilla.buscar();
            return;
        }
        if (frm.equals("jifseguimientoqrsr")) {
            this.xjifseguimientoqrsr.buscar();
            return;
        }
        if (frm.equals("jifregistroqrsr")) {
            this.xjiregistroqrsr.buscar();
            return;
        }
        if (frm.equals("jifconsultarresultado1")) {
            this.xjifconsultarexamen.mBuscar();
            return;
        }
        if (frm.equals("jifconsultarexamenesusuario1")) {
            this.xjiconsultarexusuario.mBuscar();
            return;
        }
        if (frm.equals("jifgenerarreportexusuario")) {
            this.xjidgenerarexamenusuario.mBuscar();
            return;
        }
        if (frm.equals("jifgenerarreporte1")) {
            this.xjifgenerarreportesexamen.mBuscar();
            return;
        }
        if (frm.equals("xjiftranferenciadoc")) {
            this.xjifcopiadocumentos.mBuscar();
            return;
        }
        if (frm.equals("xjifsolicituddochc")) {
            this.xjifsolicituddoc.mBuscar();
            return;
        }
        if (frm.equals("xjiconsDocClinico")) {
            this.xjifdocclinico.mBuscar();
            return;
        }
        if (frm.equals("xjiconscprogramada") || frm.equals("xjiconshc_atenciones")) {
            this.xjifcitaprogramada.mBuscar();
            return;
        }
        if (frm.equals("jifconsultarhc") || frm.equals("jifconsultarhistorial1")) {
            this.xjifconsultarhc.buscar();
        } else if (frm.equals("jifconsultarRemOrd")) {
            this.xjiconsultarexusuario.mBuscar();
        } else if (frm.equals("xjiffinformelecturausuarios1")) {
            this.xJIFFInformeLecturaUsuarios.mBuscar();
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "xjifsolicituddochc":
                this.xjifsolicituddoc.mImprimir();
                break;
            case "xjiconsDocClinico":
                this.xjifdocclinico.mImprimir();
                break;
            case "xjiffinformelecturausuarios1":
                this.xJIFFInformeLecturaUsuarios.mImprimir();
                break;
            case "jifconsultarhc":
                this.xjifconsultarhc.imprimir();
                break;
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifconsultarayudasdx":
                this.xjifconsultaradx.eliminar();
                break;
            case "jifcargaratencionesmanuales":
                this.xjifcargaatencionesmanuales.eliminar();
                break;
            case "jifgestionexamenes":
                this.xjigestionexamenes.anular();
                break;
            case "xjifsolicituddochc":
                this.xjifsolicituddoc.mAnular();
                break;
        }
    }
}
