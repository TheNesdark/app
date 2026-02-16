package com.genoma.plus.controller.historia;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Relaciones.class */
public class Relaciones {
    private int idPersona;
    private int idEntorno;
    private int tipoDeRelacion;
    private String abreviatura;

    public Relaciones(int idPersona, int idEntorno, int tipoDeRelacion, String abreviatura) {
        this.idPersona = idPersona;
        this.idEntorno = idEntorno;
        this.tipoDeRelacion = tipoDeRelacion;
        this.abreviatura = abreviatura;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdEntorno() {
        return this.idEntorno;
    }

    public void setIdEntorno(int idEntorno) {
        this.idEntorno = idEntorno;
    }

    public int getTipoDeRelacion() {
        return this.tipoDeRelacion;
    }

    public void setTipoDeRelacion(int tipoDeRelacion) {
        this.tipoDeRelacion = tipoDeRelacion;
    }
}
