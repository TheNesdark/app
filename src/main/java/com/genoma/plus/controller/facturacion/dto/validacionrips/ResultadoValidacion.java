package com.genoma.plus.controller.facturacion.dto.validacionrips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoValidacion.class */
public class ResultadoValidacion {
    private String clase;
    private String codigo;
    private String descripcion;
    private String observaciones;
    private String pathFuente;
    private String fuente;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoValidacion$ResultadoValidacionBuilder.class */
    @Generated
    public static class ResultadoValidacionBuilder {

        @Generated
        private String clase;

        @Generated
        private String codigo;

        @Generated
        private String descripcion;

        @Generated
        private String observaciones;

        @Generated
        private String pathFuente;

        @Generated
        private String fuente;

        @Generated
        ResultadoValidacionBuilder() {
        }

        @Generated
        public ResultadoValidacionBuilder clase(String clase) {
            this.clase = clase;
            return this;
        }

        @Generated
        public ResultadoValidacionBuilder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        @Generated
        public ResultadoValidacionBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        @Generated
        public ResultadoValidacionBuilder observaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        @Generated
        public ResultadoValidacionBuilder pathFuente(String pathFuente) {
            this.pathFuente = pathFuente;
            return this;
        }

        @Generated
        public ResultadoValidacionBuilder fuente(String fuente) {
            this.fuente = fuente;
            return this;
        }

        @Generated
        public ResultadoValidacion build() {
            return new ResultadoValidacion(this.clase, this.codigo, this.descripcion, this.observaciones, this.pathFuente, this.fuente);
        }

        @Generated
        public String toString() {
            return "ResultadoValidacion.ResultadoValidacionBuilder(clase=" + this.clase + ", codigo=" + this.codigo + ", descripcion=" + this.descripcion + ", observaciones=" + this.observaciones + ", pathFuente=" + this.pathFuente + ", fuente=" + this.fuente + ")";
        }
    }

    @Generated
    public void setClase(String clase) {
        this.clase = clase;
    }

    @Generated
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Generated
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Generated
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Generated
    public void setPathFuente(String pathFuente) {
        this.pathFuente = pathFuente;
    }

    @Generated
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    @Generated
    public static ResultadoValidacionBuilder builder() {
        return new ResultadoValidacionBuilder();
    }

    @Generated
    public ResultadoValidacion(String clase, String codigo, String descripcion, String observaciones, String pathFuente, String fuente) {
        this.clase = clase;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.pathFuente = pathFuente;
        this.fuente = fuente;
    }

    @Generated
    public ResultadoValidacion() {
    }

    @Generated
    public String getClase() {
        return this.clase;
    }

    @Generated
    public String getCodigo() {
        return this.codigo;
    }

    @Generated
    public String getDescripcion() {
        return this.descripcion;
    }

    @Generated
    public String getObservaciones() {
        return this.observaciones;
    }

    @Generated
    public String getPathFuente() {
        return this.pathFuente;
    }

    @Generated
    public String getFuente() {
        return this.fuente;
    }
}
