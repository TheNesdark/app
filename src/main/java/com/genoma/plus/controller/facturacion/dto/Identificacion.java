package com.genoma.plus.controller.facturacion.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/Identificacion.class */
public class Identificacion {
    private String tipo;
    private String numero;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/Identificacion$IdentificacionBuilder.class */
    @Generated
    public static class IdentificacionBuilder {

        @Generated
        private String tipo;

        @Generated
        private String numero;

        @Generated
        IdentificacionBuilder() {
        }

        @Generated
        public IdentificacionBuilder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        @Generated
        public IdentificacionBuilder numero(String numero) {
            this.numero = numero;
            return this;
        }

        @Generated
        public Identificacion build() {
            return new Identificacion(this.tipo, this.numero);
        }

        @Generated
        public String toString() {
            return "Identificacion.IdentificacionBuilder(tipo=" + this.tipo + ", numero=" + this.numero + ")";
        }
    }

    @Generated
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Generated
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Generated
    public static IdentificacionBuilder builder() {
        return new IdentificacionBuilder();
    }

    @Generated
    public Identificacion(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    @Generated
    public Identificacion() {
    }

    @Generated
    public String getTipo() {
        return this.tipo;
    }

    @Generated
    public String getNumero() {
        return this.numero;
    }
}
