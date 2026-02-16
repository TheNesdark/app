package com.genoma.plus.controller.facturacion.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/DatosUsuarioRes.class */
public class DatosUsuarioRes {
    private Persona persona;
    private String clave;
    private String nit;
    private int tipoMecanismoValidacion;
    private boolean reps;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/DatosUsuarioRes$DatosUsuarioResBuilder.class */
    @Generated
    public static class DatosUsuarioResBuilder {

        @Generated
        private Persona persona;

        @Generated
        private String clave;

        @Generated
        private String nit;

        @Generated
        private int tipoMecanismoValidacion;

        @Generated
        private boolean reps;

        @Generated
        DatosUsuarioResBuilder() {
        }

        @Generated
        public DatosUsuarioResBuilder persona(Persona persona) {
            this.persona = persona;
            return this;
        }

        @Generated
        public DatosUsuarioResBuilder clave(String clave) {
            this.clave = clave;
            return this;
        }

        @Generated
        public DatosUsuarioResBuilder nit(String nit) {
            this.nit = nit;
            return this;
        }

        @Generated
        public DatosUsuarioResBuilder tipoMecanismoValidacion(int tipoMecanismoValidacion) {
            this.tipoMecanismoValidacion = tipoMecanismoValidacion;
            return this;
        }

        @Generated
        public DatosUsuarioResBuilder reps(boolean reps) {
            this.reps = reps;
            return this;
        }

        @Generated
        public DatosUsuarioRes build() {
            return new DatosUsuarioRes(this.persona, this.clave, this.nit, this.tipoMecanismoValidacion, this.reps);
        }

        @Generated
        public String toString() {
            return "DatosUsuarioRes.DatosUsuarioResBuilder(persona=" + this.persona + ", clave=" + this.clave + ", nit=" + this.nit + ", tipoMecanismoValidacion=" + this.tipoMecanismoValidacion + ", reps=" + this.reps + ")";
        }
    }

    @Generated
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Generated
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Generated
    public void setNit(String nit) {
        this.nit = nit;
    }

    @Generated
    public void setTipoMecanismoValidacion(int tipoMecanismoValidacion) {
        this.tipoMecanismoValidacion = tipoMecanismoValidacion;
    }

    @Generated
    public void setReps(boolean reps) {
        this.reps = reps;
    }

    @Generated
    public static DatosUsuarioResBuilder builder() {
        return new DatosUsuarioResBuilder();
    }

    @Generated
    public DatosUsuarioRes(Persona persona, String clave, String nit, int tipoMecanismoValidacion, boolean reps) {
        this.persona = persona;
        this.clave = clave;
        this.nit = nit;
        this.tipoMecanismoValidacion = tipoMecanismoValidacion;
        this.reps = reps;
    }

    @Generated
    public DatosUsuarioRes() {
    }

    @Generated
    public Persona getPersona() {
        return this.persona;
    }

    @Generated
    public String getClave() {
        return this.clave;
    }

    @Generated
    public String getNit() {
        return this.nit;
    }

    @Generated
    public int getTipoMecanismoValidacion() {
        return this.tipoMecanismoValidacion;
    }

    @Generated
    public boolean isReps() {
        return this.reps;
    }
}
