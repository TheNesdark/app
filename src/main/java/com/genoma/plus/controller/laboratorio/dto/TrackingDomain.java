package com.genoma.plus.controller.laboratorio.dto;

import com.genoma.plus.controller.laboratorio.enums.EstadoMuestra;
import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/TrackingDomain.class */
public class TrackingDomain {
    private Long id;
    private Long idRecepcion;
    private LocalDateTime fechaHoraRegistro;
    private String area;
    private EstadoMuestra estadoMAnEnum;
    private String usuario;
    private String cargo;
    private String observacion;
    private Boolean estado;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/TrackingDomain$TrackingDomainBuilder.class */
    @Generated
    public static class TrackingDomainBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idRecepcion;

        @Generated
        private LocalDateTime fechaHoraRegistro;

        @Generated
        private String area;

        @Generated
        private EstadoMuestra estadoMAnEnum;

        @Generated
        private String usuario;

        @Generated
        private String cargo;

        @Generated
        private String observacion;

        @Generated
        private Boolean estado;

        @Generated
        TrackingDomainBuilder() {
        }

        @Generated
        public TrackingDomainBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public TrackingDomainBuilder idRecepcion(Long idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public TrackingDomainBuilder fechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
            this.fechaHoraRegistro = fechaHoraRegistro;
            return this;
        }

        @Generated
        public TrackingDomainBuilder area(String area) {
            this.area = area;
            return this;
        }

        @Generated
        public TrackingDomainBuilder estadoMAnEnum(EstadoMuestra estadoMAnEnum) {
            this.estadoMAnEnum = estadoMAnEnum;
            return this;
        }

        @Generated
        public TrackingDomainBuilder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        @Generated
        public TrackingDomainBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        @Generated
        public TrackingDomainBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public TrackingDomainBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public TrackingDomain build() {
            return new TrackingDomain(this.id, this.idRecepcion, this.fechaHoraRegistro, this.area, this.estadoMAnEnum, this.usuario, this.cargo, this.observacion, this.estado);
        }

        @Generated
        public String toString() {
            return "TrackingDomain.TrackingDomainBuilder(id=" + this.id + ", idRecepcion=" + this.idRecepcion + ", fechaHoraRegistro=" + this.fechaHoraRegistro + ", area=" + this.area + ", estadoMAnEnum=" + this.estadoMAnEnum + ", usuario=" + this.usuario + ", cargo=" + this.cargo + ", observacion=" + this.observacion + ", estado=" + this.estado + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Generated
    public void setArea(String area) {
        this.area = area;
    }

    @Generated
    public void setEstadoMAnEnum(EstadoMuestra estadoMAnEnum) {
        this.estadoMAnEnum = estadoMAnEnum;
    }

    @Generated
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Generated
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public static TrackingDomainBuilder builder() {
        return new TrackingDomainBuilder();
    }

    @Generated
    public TrackingDomain(Long id, Long idRecepcion, LocalDateTime fechaHoraRegistro, String area, EstadoMuestra estadoMAnEnum, String usuario, String cargo, String observacion, Boolean estado) {
        this.id = id;
        this.idRecepcion = idRecepcion;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.area = area;
        this.estadoMAnEnum = estadoMAnEnum;
        this.usuario = usuario;
        this.cargo = cargo;
        this.observacion = observacion;
        this.estado = estado;
    }

    @Generated
    public TrackingDomain() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public LocalDateTime getFechaHoraRegistro() {
        return this.fechaHoraRegistro;
    }

    @Generated
    public String getArea() {
        return this.area;
    }

    @Generated
    public EstadoMuestra getEstadoMAnEnum() {
        return this.estadoMAnEnum;
    }

    @Generated
    public String getUsuario() {
        return this.usuario;
    }

    @Generated
    public String getCargo() {
        return this.cargo;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }
}
