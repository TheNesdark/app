package ImagenesDx;

import Acceso.Principal;
import Historia.JIFConsultarAtenciones;
import Historia.JIFRVisitasDomiciliarias;
import Laboratorio.JIFAuditoriaTiempos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.imagenesdx.JIFFInformeLecturaUsuarios;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/claseImagenesDx.class */
public class claseImagenesDx {
    public Principal frmPrincipal;
    private JIFConsultarOrdenesHc xjifconsultarorden;
    private JIFRegistroInformacionPlacas xjifresgistro;
    private JIFRVisitasDomiciliarias xjifnotasimag;
    public JIFAgenda xjifagenda;
    public JIFRecepcion_Rx1 xjifrecepcion;
    private JIFConsultarAtenciones xjifcatencioneshc;
    private String xsql;
    private JIFAuditoriaTiempos xjifauditiemposrx;
    private JIFLecturaPlacaOit xjiflecturaoit;
    public JIFAgenda_Lectura xjifagendal;
    private JIFFInformeLecturaUsuarios xJIFFInformeLecturaUsuarios;
    private JIF_Reportes_PyP_Generico jifreportes;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private String xidorden = "0";
    private int xposfila = -1;

    public claseImagenesDx(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public void anular(String frm) {
        if (frm.equals("xjifrecepcionar_rx")) {
            this.xjifrecepcion.anular();
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifconsultarordeneshc":
                this.xjifconsultarorden.mBuscar();
                break;
            case "jifregistroplacas":
                this.xjifresgistro.mBuscar();
                break;
            case "jiftiemposesperarx":
                this.xjifauditiemposrx.mBuscar();
                break;
            case "xjifagendalecturarx":
                this.xjifagendal.mBuscar();
                break;
            case "xjiffinformelecturausuarios":
                this.xJIFFInformeLecturaUsuarios.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Consutar Estado Ordenes":
                this.xjifconsultarorden = new JIFConsultarOrdenesHc();
                Principal.cargarPantalla(this.xjifconsultarorden);
                break;
            case "Registro de Información Placas":
                this.xjifresgistro = new JIFRegistroInformacionPlacas();
                Principal.cargarPantalla(this.xjifresgistro);
                break;
            case "Notas de Radiologías":
                this.xjifnotasimag = new JIFRVisitasDomiciliarias(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), "NOTAS DE IMAGENOLOGÍA", "xjifnotasmedicas1", new Long(0L), 0);
                Principal.cargarPantalla(this.xjifnotasimag);
                break;
            case "Agenda_Rx":
                this.xjifagenda = new JIFAgenda(this);
                Principal.cargarPantalla(this.xjifagenda);
                break;
            case "Recepcion":
                this.xjifrecepcion = new JIFRecepcion_Rx1(this.xjifagenda.JCBServicio.getSelectedItem().toString());
                Principal.cargarPantalla(this.xjifrecepcion);
                break;
            case "Consultar HC":
                this.xjifcatencioneshc = new JIFConsultarAtenciones(this, 3);
                Principal.cargarPantalla(this.xjifcatencioneshc);
                break;
            case "Tiempo de Espera RX":
                this.xjifauditiemposrx = new JIFAuditoriaTiempos("jiftiemposesperarx", "Estadistica de Tiempo de Espera");
                Principal.cargarPantalla(this.xjifauditiemposrx);
                break;
            case "Lectura Oit":
                this.xjifagendal = new JIFAgenda_Lectura();
                Principal.cargarPantalla(this.xjifagendal);
                break;
            case "Informe De Lecturas Por Usuario":
                this.xJIFFInformeLecturaUsuarios = new JIFFInformeLecturaUsuarios("xjiffinformelecturausuarios");
                Principal.cargarPantalla(this.xJIFFInformeLecturaUsuarios);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(29, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void cargarPantalla(String frm, String xid, String xidestudio) {
        if (frm.equals("Formato_Oit")) {
            this.xjiflecturaoit = new JIFLecturaPlacaOit(xid, xidestudio);
            Principal.cargarPantalla(this.xjiflecturaoit);
        }
    }

    public void grabar(String frm) {
        if (frm.equals("jifseguimientoordenes")) {
            this.xjifconsultarorden.xjifseguimientoord.mGrabar();
            return;
        }
        if (frm.equals("jifregistroplacas")) {
            this.xjifresgistro.mGrabar();
            return;
        }
        if (frm.equals("xjifnotasmedicas1")) {
            this.xjifnotasimag.grabar();
            return;
        }
        if (frm.equals("xjifrecepcionar_rx")) {
            this.xjifrecepcion.grabar();
        } else if (frm.equals("xjiflecturaoit")) {
            this.xjiflecturaoit.mGrabar();
        } else if (frm.equals("xjiflecturaoit")) {
            this.xjiflecturaoit.mGrabar();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("xjiflecturaoit")) {
            this.xjiflecturaoit.mImprimir();
        } else if (frm.equals("xjiffinformelecturausuarios")) {
            this.xJIFFInformeLecturaUsuarios.mImprimir();
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("jifseguimientoordenes")) {
            this.xjifconsultarorden.xjifseguimientoord.mNuevo();
            return;
        }
        if (frm.equals("jifregistroplacas")) {
            this.xjifresgistro.mNuevo();
            return;
        }
        if (frm.equals("xjifnotasmedicas1")) {
            this.xjifnotasimag.nuevo();
        } else if (frm.equals("xjifagendalecturarx")) {
            this.xjifagendal.mNuevo();
        } else if (frm.equals("xjiffinformelecturausuarios")) {
            this.xJIFFInformeLecturaUsuarios.mNuevo();
        }
    }

    public String getXidorden() {
        return this.xidorden;
    }

    public void setXidorden(String xidorden) {
        this.xidorden = xidorden;
    }

    public int getXposfila() {
        return this.xposfila;
    }

    public void setXposfila(int xposfila) {
        this.xposfila = xposfila;
    }
}
