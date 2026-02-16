package com.genoma.plus.controller.facturacion.dto.validacionrips;

import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ValidacionRipsRespuesta.class */
public class ValidacionRipsRespuesta {
    private Long id;
    private Long idFacturaEvento;
    private String numeroFacturaEvento;
    private String prefijo;
    private LocalDateTime fechaRegistro;
    private String usuario;
    private String cargo;
    private Boolean estado;
    private ResultadoProcesoDTO response;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ValidacionRipsRespuesta$ValidacionRipsRespuestaBuilder.class */
    @Generated
    public static class ValidacionRipsRespuestaBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idFacturaEvento;

        @Generated
        private String numeroFacturaEvento;

        @Generated
        private String prefijo;

        @Generated
        private LocalDateTime fechaRegistro;

        @Generated
        private String usuario;

        @Generated
        private String cargo;

        @Generated
        private Boolean estado;

        @Generated
        private ResultadoProcesoDTO response;

        @Generated
        ValidacionRipsRespuestaBuilder() {
        }

        @Generated
        public ValidacionRipsRespuestaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder idFacturaEvento(Long idFacturaEvento) {
            this.idFacturaEvento = idFacturaEvento;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder numeroFacturaEvento(String numeroFacturaEvento) {
            this.numeroFacturaEvento = numeroFacturaEvento;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder prefijo(String prefijo) {
            this.prefijo = prefijo;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder fechaRegistro(LocalDateTime fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public ValidacionRipsRespuestaBuilder response(ResultadoProcesoDTO response) {
            this.response = response;
            return this;
        }

        @Generated
        public ValidacionRipsRespuesta build() {
            return new ValidacionRipsRespuesta(this.id, this.idFacturaEvento, this.numeroFacturaEvento, this.prefijo, this.fechaRegistro, this.usuario, this.cargo, this.estado, this.response);
        }

        @Generated
        public String toString() {
            return "ValidacionRipsRespuesta.ValidacionRipsRespuestaBuilder(id=" + this.id + ", idFacturaEvento=" + this.idFacturaEvento + ", numeroFacturaEvento=" + this.numeroFacturaEvento + ", prefijo=" + this.prefijo + ", fechaRegistro=" + this.fechaRegistro + ", usuario=" + this.usuario + ", cargo=" + this.cargo + ", estado=" + this.estado + ", response=" + this.response + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdFacturaEvento(Long idFacturaEvento) {
        this.idFacturaEvento = idFacturaEvento;
    }

    @Generated
    public void setNumeroFacturaEvento(String numeroFacturaEvento) {
        this.numeroFacturaEvento = numeroFacturaEvento;
    }

    @Generated
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    @Generated
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setResponse(ResultadoProcesoDTO response) {
        this.response = response;
    }

    @Generated
    public static ValidacionRipsRespuestaBuilder builder() {
        return new ValidacionRipsRespuestaBuilder();
    }

    @Generated
    public ValidacionRipsRespuesta(Long id, Long idFacturaEvento, String numeroFacturaEvento, String prefijo, LocalDateTime fechaRegistro, String usuario, String cargo, Boolean estado, ResultadoProcesoDTO response) {
        this.id = id;
        this.idFacturaEvento = idFacturaEvento;
        this.numeroFacturaEvento = numeroFacturaEvento;
        this.prefijo = prefijo;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
        this.cargo = cargo;
        this.estado = estado;
        this.response = response;
    }

    @Generated
    public ValidacionRipsRespuesta() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdFacturaEvento() {
        return this.idFacturaEvento;
    }

    @Generated
    public String getNumeroFacturaEvento() {
        return this.numeroFacturaEvento;
    }

    @Generated
    public String getPrefijo() {
        return this.prefijo;
    }

    @Generated
    public LocalDateTime getFechaRegistro() {
        return this.fechaRegistro;
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
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public ResultadoProcesoDTO getResponse() {
        return this.response;
    }
}
