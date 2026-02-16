package com.genoma.plus.controller.laboratorio.dto;

import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoRecepcion.class */
public class InfoRecepcion {
    private Long id;
    private LocalDateTime fechaRecepcion;
    private String nombreUsuario;
    private String sede;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoRecepcion$InfoRecepcionBuilder.class */
    @Generated
    public static class InfoRecepcionBuilder {

        @Generated
        private Long id;

        @Generated
        private LocalDateTime fechaRecepcion;

        @Generated
        private String nombreUsuario;

        @Generated
        private String sede;

        @Generated
        InfoRecepcionBuilder() {
        }

        @Generated
        public InfoRecepcionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public InfoRecepcionBuilder fechaRecepcion(LocalDateTime fechaRecepcion) {
            this.fechaRecepcion = fechaRecepcion;
            return this;
        }

        @Generated
        public InfoRecepcionBuilder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        @Generated
        public InfoRecepcionBuilder sede(String sede) {
            this.sede = sede;
            return this;
        }

        @Generated
        public InfoRecepcion build() {
            return new InfoRecepcion(this.id, this.fechaRecepcion, this.nombreUsuario, this.sede);
        }

        @Generated
        public String toString() {
            return "InfoRecepcion.InfoRecepcionBuilder(id=" + this.id + ", fechaRecepcion=" + this.fechaRecepcion + ", nombreUsuario=" + this.nombreUsuario + ", sede=" + this.sede + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setSede(String sede) {
        this.sede = sede;
    }

    @Generated
    public static InfoRecepcionBuilder builder() {
        return new InfoRecepcionBuilder();
    }

    @Generated
    public InfoRecepcion(Long id, LocalDateTime fechaRecepcion, String nombreUsuario, String sede) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.nombreUsuario = nombreUsuario;
        this.sede = sede;
    }

    @Generated
    public InfoRecepcion() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public LocalDateTime getFechaRecepcion() {
        return this.fechaRecepcion;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public String getSede() {
        return this.sede;
    }
}
