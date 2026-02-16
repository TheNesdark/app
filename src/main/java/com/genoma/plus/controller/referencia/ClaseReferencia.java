package com.genoma.plus.controller.referencia;

import Acceso.Principal;
import com.genoma.plus.controller.facturacion.JIFGestion_Servicios;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/ClaseReferencia.class */
public class ClaseReferencia {
    private JIF_Referencia referencia;
    private JIF_ConsolidadoReferencia consolidadoReferencia;
    private JIF_Reportes_PyP_Generico jifreportes;
    private JIFGestion_Servicios jIFGestion_Servicios;

    public ClaseReferencia(Principal frmPrincipal) {
    }

    public void anular(String frm) {
    }

    public void buscar(String frm) {
        if (frm.equals("jifReferencia")) {
            this.referencia.buscar();
        } else if (frm.equals("jifConsolidadoReferencia")) {
            this.consolidadoReferencia.buscar();
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "jifReferencia":
                this.referencia = new JIF_Referencia();
                Principal.cargarPantalla(this.referencia);
                break;
            case "jifGestionSolicitudes1":
                this.jIFGestion_Servicios = new JIFGestion_Servicios("jifGestionSolicitudes1");
                Principal.cargarPantalla(this.jIFGestion_Servicios);
                break;
            case "jifConsolidadoReferencia":
                this.consolidadoReferencia = new JIF_ConsolidadoReferencia();
                Principal.cargarPantalla(this.consolidadoReferencia);
                break;
            case "Informes Generales":
                this.jifreportes = new JIF_Reportes_PyP_Generico(10, "INFORMES GENERALES", "jif_ReportesPyP");
                Principal.cargarPantalla(this.jifreportes);
                break;
        }
    }

    public void grabar(String frm) {
    }

    public void imprimir(String frm) {
    }

    public void nuevo(String frm) {
        if (frm.equals("jifReferencia")) {
            this.referencia.nuevo();
        } else if (frm.equals("jifConsolidadoReferencia")) {
            this.consolidadoReferencia.nuevo();
        }
    }
}
