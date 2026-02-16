package com.genoma.plus.controller.facturacion.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/Persona.class */
public class Persona {
    private Identificacion identificacion;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/Persona$PersonaBuilder.class */
    @Generated
    public static class PersonaBuilder {

        @Generated
        private Identificacion identificacion;

        @Generated
        PersonaBuilder() {
        }

        @Generated
        public PersonaBuilder identificacion(Identificacion identificacion) {
            this.identificacion = identificacion;
            return this;
        }

        @Generated
        public Persona build() {
            return new Persona(this.identificacion);
        }

        @Generated
        public String toString() {
            return "Persona.PersonaBuilder(identificacion=" + this.identificacion + ")";
        }
    }

    @Generated
    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    @Generated
    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }

    @Generated
    public Persona(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    @Generated
    public Persona() {
    }

    @Generated
    public Identificacion getIdentificacion() {
        return this.identificacion;
    }
}
