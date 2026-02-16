package com.genoma.plus.controller.historia;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Entorno.class */
public class Entorno {
    private int idPosEntorno;
    private String Dato;

    public Entorno(int idPosEntorno, String Dato) {
        this.idPosEntorno = idPosEntorno;
        this.Dato = Dato;
    }

    public int getIdPosEntorno() {
        return this.idPosEntorno;
    }

    public void setIdPosEntorno(int idPosEntorno) {
        this.idPosEntorno = idPosEntorno;
    }

    public String getDato() {
        return this.Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }
}
