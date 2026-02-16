package Odontologia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/claseOdonto.class */
public class claseOdonto {
    public Principal frmPrincipal;
    public JPOdontograma xjifOdonotograma;
    private JIF_Reportes_PyP_Generico pyP_Generico;
    private Metodos metodos = new Metodos();
    public JIFHistoriaOdontologica xjifhcodontologia = null;

    public claseOdonto(Principal frm) {
        this.frmPrincipal = frm;
    }

    public void anular() {
        this.metodos.mostrarMensaje("Esta Opción no es permitida");
    }

    public void buscar(String frm) {
        if (frm.equals("jif_ReportesPyP2")) {
            this.pyP_Generico.mBuscar();
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Historia Odontologica")) {
            if (this.xjifhcodontologia != null) {
                this.xjifhcodontologia.dispose();
            }
            this.xjifhcodontologia = new JIFHistoriaOdontologica(this);
            Principal.cargarPantalla(this.xjifhcodontologia);
            return;
        }
        if (frm.equals("Informes Generales Odontologia")) {
            this.pyP_Generico = new JIF_Reportes_PyP_Generico(31, "INFORMES GENERALES", "jif_ReportesPyP2");
            Principal.cargarPantalla(this.pyP_Generico);
        }
    }

    public void grabar(String frm) {
    }

    public void nuevo() {
    }
}
