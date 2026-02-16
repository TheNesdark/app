package com.genoma.plus.controller.facturacion.dto.validacionrips;

import com.google.gson.annotations.SerializedName;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoValidacionDTO.class */
public class ResultadoValidacionDTO {

    @SerializedName("Clase")
    private String clase;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("Observaciones")
    private String observaciones;

    @SerializedName("PathFuente")
    private String pathFuente;

    @SerializedName("Fuente")
    private String fuente;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoValidacionDTO$ResultadoValidacionDTOBuilder.class */
    @Generated
    public static class ResultadoValidacionDTOBuilder {

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
        ResultadoValidacionDTOBuilder() {
        }

        @Generated
        public ResultadoValidacionDTOBuilder clase(String clase) {
            this.clase = clase;
            return this;
        }

        @Generated
        public ResultadoValidacionDTOBuilder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        @Generated
        public ResultadoValidacionDTOBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        @Generated
        public ResultadoValidacionDTOBuilder observaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        @Generated
        public ResultadoValidacionDTOBuilder pathFuente(String pathFuente) {
            this.pathFuente = pathFuente;
            return this;
        }

        @Generated
        public ResultadoValidacionDTOBuilder fuente(String fuente) {
            this.fuente = fuente;
            return this;
        }

        @Generated
        public ResultadoValidacionDTO build() {
            return new ResultadoValidacionDTO(this.clase, this.codigo, this.descripcion, this.observaciones, this.pathFuente, this.fuente);
        }

        @Generated
        public String toString() {
            return "ResultadoValidacionDTO.ResultadoValidacionDTOBuilder(clase=" + this.clase + ", codigo=" + this.codigo + ", descripcion=" + this.descripcion + ", observaciones=" + this.observaciones + ", pathFuente=" + this.pathFuente + ", fuente=" + this.fuente + ")";
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
    public static ResultadoValidacionDTOBuilder builder() {
        return new ResultadoValidacionDTOBuilder();
    }

    @Generated
    public ResultadoValidacionDTO(String clase, String codigo, String descripcion, String observaciones, String pathFuente, String fuente) {
        this.clase = clase;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.pathFuente = pathFuente;
        this.fuente = fuente;
    }

    @Generated
    public ResultadoValidacionDTO() {
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
