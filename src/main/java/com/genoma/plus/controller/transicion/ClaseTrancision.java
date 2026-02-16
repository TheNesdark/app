package com.genoma.plus.controller.transicion;

import Acceso.Principal;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/transicion/ClaseTrancision.class */
public class ClaseTrancision {
    private JIF_HojaTratamiento hojaTratamiento;

    public void anular(String frm) {
    }

    public void buscar(String frm) {
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("jif_hojatratamiento")) {
            this.hojaTratamiento = new JIF_HojaTratamiento();
            Principal.cargarPantalla(this.hojaTratamiento);
        }
    }

    public void grabar(String frm) {
    }

    public void imprimir(String frm) {
        if (frm.equals("jif_hojatratamiento")) {
            this.hojaTratamiento.imprimir();
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("jif_hojatratamiento")) {
            this.hojaTratamiento.nuevo();
        }
    }
}
