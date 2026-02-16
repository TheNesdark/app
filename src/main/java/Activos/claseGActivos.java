package Activos;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.activos.JIFInformeActivos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:Activos/claseGActivos.class */
public class claseGActivos {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public Principal xjpprincipal;
    private JIFGestionActivos xjifgestionactivo;
    private JIFInformeActivos xJIFInformeActivos;
    private JIF_Reportes_PyP_Generico jifreportes;

    public claseGActivos(Principal xjpprincipal) {
    }

    public void anular(String frm) {
    }

    public void buscar(String frm) {
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Activos Fijos") || frm.equals("Activos Fijos1")) {
            this.xjifgestionactivo = new JIFGestionActivos("xjifgestionactivos1");
            Principal.cargarPantalla(this.xjifgestionactivo);
        } else if (frm.equals("Informe de Activos")) {
            this.xJIFInformeActivos = new JIFInformeActivos();
            Principal.cargarPantalla(this.xJIFInformeActivos);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(34, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void grabar(String frm) {
        if (frm.equals("xjifgestionactivos1")) {
            this.xjifgestionactivo.mGrabar();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("xjifgestionactivos1")) {
            this.xjifgestionactivo.mImprimir();
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("xjifgestionactivos1")) {
            this.xjifgestionactivo.mNuevo1();
        }
    }
}
