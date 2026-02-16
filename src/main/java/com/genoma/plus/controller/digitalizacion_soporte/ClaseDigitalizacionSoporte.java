package com.genoma.plus.controller.digitalizacion_soporte;

import Acceso.Principal;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/digitalizacion_soporte/ClaseDigitalizacionSoporte.class */
public class ClaseDigitalizacionSoporte {
    private JIFDigitalizacionSopote JIFDigitalizacionSopote;

    public void anular(String frm) {
    }

    public void buscar(String frm) {
        if (frm.equals("jifdigitalizacionsoporte")) {
            this.JIFDigitalizacionSopote.mBuscar();
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Digitalizacion de Soportes")) {
            this.JIFDigitalizacionSopote = new JIFDigitalizacionSopote();
            Principal.cargarPantalla(this.JIFDigitalizacionSopote);
        }
    }

    public void grabar(String frm) {
    }

    public void imprimir(String frm) {
        if (frm.equals("jifdigitalizacionsoporte")) {
            this.JIFDigitalizacionSopote.mImprimir();
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("jifdigitalizacionsoporte")) {
            this.JIFDigitalizacionSopote.mNuevo();
        }
    }
}
