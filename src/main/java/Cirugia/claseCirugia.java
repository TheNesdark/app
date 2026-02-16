package Cirugia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.cirugia.JIFInformeCirugia;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Cirugia/claseCirugia.class */
public class claseCirugia {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql;
    public Principal xjfp;
    public JIF_Programacion_Cx xjif_progracion_cx;
    private JIF_IProgramacion xjif_aprogramacion;
    private JIFInformeCirugia xjIFInformeCirugia;
    private JIF_Reportes_PyP_Generico jifreportes;

    public claseCirugia(Principal xjfp) {
        this.xjfp = xjfp;
    }

    public void mBurcar(String frm) {
        if (!frm.equals("xjig_programacion_cx")) {
            this.xjIFInformeCirugia.cargarDatos();
        } else {
            this.xjif_progracion_cx.mBuscar();
        }
    }

    public void mCargarPantalla(String frm) {
        switch (frm) {
            case "xjig_programacion_cx":
                this.xjif_progracion_cx = new JIF_Programacion_Cx("xjig_programacion_cx", frm);
                Principal.cargarPantalla(this.xjif_progracion_cx);
                break;
            case "Programación":
                this.xjif_aprogramacion = new JIF_IProgramacion("xjifiprogramacion", frm);
                Principal.cargarPantalla(this.xjif_aprogramacion);
                break;
            case "JIFInformeCirugia":
                this.xjIFInformeCirugia = new JIFInformeCirugia();
                Principal.cargarPantalla(this.xjIFInformeCirugia);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(35, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void mGrabar(String frm) {
        if (frm.equals("xjig_programacion_cx")) {
            try {
                this.xjif_progracion_cx.mGrabar();
            } catch (ParseException ex) {
                Logger.getLogger(claseCirugia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo(String frm) {
        if (frm.equals("xjig_programacion_cx")) {
            this.xjif_progracion_cx.mNuevo();
        }
        if (frm.equals("xjifiprogramacion")) {
            this.xjif_aprogramacion.mNuevo();
        }
    }

    public void mAnular(String frm) {
        if (frm.equals("xjig_programacion_cx")) {
            this.xjif_progracion_cx.mAnular();
        }
    }

    public void mImprimir(String frm) {
        if (frm.equals("xjifiprogramacion")) {
            this.xjif_aprogramacion.mImprimir();
        }
    }
}
