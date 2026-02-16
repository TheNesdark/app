package com.genoma.plus.controller.historia;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Persona.class */
public class Persona {
    private int idPos;
    private String PrimerNom;
    private String edad;
    private String tipoEdad;
    private String sexo;
    private boolean vive;
    private boolean esPaciente;
    private int rol;
    private String ocupacion;
    private boolean embarazo;
    private int idEstadoCivil;
    private boolean esAdoptado;
    private boolean esGemelo;

    public Persona(int idPos, String PrimerNom, String edad, String sexo, boolean vive, boolean esPaciente, int rol, String ocupacion, int idEstadoCivil, boolean embarazo, boolean esAdoptado, boolean esGemelo, String tipoEdad) {
        this.idPos = idPos;
        this.PrimerNom = PrimerNom;
        this.edad = edad;
        this.sexo = sexo;
        this.vive = vive;
        this.esPaciente = esPaciente;
        this.rol = rol;
        this.ocupacion = ocupacion;
        this.embarazo = embarazo;
        this.idEstadoCivil = idEstadoCivil;
        this.esAdoptado = esAdoptado;
        this.esGemelo = esGemelo;
        this.tipoEdad = tipoEdad;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTipoEdad() {
        return this.tipoEdad;
    }

    public void setTipoEdad(String tipoEdad) {
        this.tipoEdad = tipoEdad;
    }

    public boolean isEmbarazo() {
        return this.embarazo;
    }

    public void setEmbarazo(boolean embarazo) {
        this.embarazo = embarazo;
    }

    public String getPrimerNom() {
        return this.PrimerNom;
    }

    public void setPrimerNom(String PrimerNom) {
        this.PrimerNom = PrimerNom;
    }

    public String getEdad() {
        return this.edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean getVive() {
        return this.vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean getEsPaciente() {
        return this.esPaciente;
    }

    public void setEsPaciente(boolean esPaciente) {
        this.esPaciente = esPaciente;
    }

    public int getRol() {
        return this.rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getIdPos() {
        return this.idPos;
    }

    public void setIdPos(int idPos) {
        this.idPos = idPos;
    }

    public int getIdEstadocivil() {
        return this.idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public boolean isEsAdoptado() {
        return this.esAdoptado;
    }

    public void setEsAdoptado(boolean esAdoptado) {
        this.esAdoptado = esAdoptado;
    }

    public boolean isEsGemelo() {
        return this.esGemelo;
    }

    public void setEsGemelo(boolean esGemelo) {
        this.esGemelo = esGemelo;
    }
}
