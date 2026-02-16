package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleRecienNacidoDTO.class */
public class DetalleRecienNacidoDTO {
    private String codPrestador;
    private String tipoDocumentoIdentificacion;
    private String numDocumentoIdentificacion;
    private String fechaNacimiento;
    private Integer edadGestacional;
    private Integer numConsultasCPrenatal;
    private String codSexoBiologico;
    private Long peso;
    private String codDiagnosticoPrincipal;
    private String condicionDestino;
    private String codDiagnosticoCausaMuerte;
    private String fechaEgreso;
    private Integer consecutivo;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleRecienNacidoDTO$DetalleRecienNacidoDTOBuilder.class */
    @Generated
    public static class DetalleRecienNacidoDTOBuilder {

        @Generated
        private String codPrestador;

        @Generated
        private String tipoDocumentoIdentificacion;

        @Generated
        private String numDocumentoIdentificacion;

        @Generated
        private String fechaNacimiento;

        @Generated
        private Integer edadGestacional;

        @Generated
        private Integer numConsultasCPrenatal;

        @Generated
        private String codSexoBiologico;

        @Generated
        private Long peso;

        @Generated
        private String codDiagnosticoPrincipal;

        @Generated
        private String condicionDestino;

        @Generated
        private String codDiagnosticoCausaMuerte;

        @Generated
        private String fechaEgreso;

        @Generated
        private Integer consecutivo;

        @Generated
        DetalleRecienNacidoDTOBuilder() {
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder codPrestador(String codPrestador) {
            this.codPrestador = codPrestador;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder tipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
            this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder numDocumentoIdentificacion(String numDocumentoIdentificacion) {
            this.numDocumentoIdentificacion = numDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder fechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder edadGestacional(Integer edadGestacional) {
            this.edadGestacional = edadGestacional;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder numConsultasCPrenatal(Integer numConsultasCPrenatal) {
            this.numConsultasCPrenatal = numConsultasCPrenatal;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder codSexoBiologico(String codSexoBiologico) {
            this.codSexoBiologico = codSexoBiologico;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder peso(Long peso) {
            this.peso = peso;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder codDiagnosticoPrincipal(String codDiagnosticoPrincipal) {
            this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder condicionDestino(String condicionDestino) {
            this.condicionDestino = condicionDestino;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder codDiagnosticoCausaMuerte(String codDiagnosticoCausaMuerte) {
            this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder fechaEgreso(String fechaEgreso) {
            this.fechaEgreso = fechaEgreso;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTOBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public DetalleRecienNacidoDTO build() {
            return new DetalleRecienNacidoDTO(this.codPrestador, this.tipoDocumentoIdentificacion, this.numDocumentoIdentificacion, this.fechaNacimiento, this.edadGestacional, this.numConsultasCPrenatal, this.codSexoBiologico, this.peso, this.codDiagnosticoPrincipal, this.condicionDestino, this.codDiagnosticoCausaMuerte, this.fechaEgreso, this.consecutivo);
        }

        @Generated
        public String toString() {
            return "DetalleRecienNacidoDTO.DetalleRecienNacidoDTOBuilder(codPrestador=" + this.codPrestador + ", tipoDocumentoIdentificacion=" + this.tipoDocumentoIdentificacion + ", numDocumentoIdentificacion=" + this.numDocumentoIdentificacion + ", fechaNacimiento=" + this.fechaNacimiento + ", edadGestacional=" + this.edadGestacional + ", numConsultasCPrenatal=" + this.numConsultasCPrenatal + ", codSexoBiologico=" + this.codSexoBiologico + ", peso=" + this.peso + ", codDiagnosticoPrincipal=" + this.codDiagnosticoPrincipal + ", condicionDestino=" + this.condicionDestino + ", codDiagnosticoCausaMuerte=" + this.codDiagnosticoCausaMuerte + ", fechaEgreso=" + this.fechaEgreso + ", consecutivo=" + this.consecutivo + ")";
        }
    }

    @Generated
    public void setCodPrestador(String codPrestador) {
        this.codPrestador = codPrestador;
    }

    @Generated
    public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }

    @Generated
    public void setNumDocumentoIdentificacion(String numDocumentoIdentificacion) {
        this.numDocumentoIdentificacion = numDocumentoIdentificacion;
    }

    @Generated
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Generated
    public void setEdadGestacional(Integer edadGestacional) {
        this.edadGestacional = edadGestacional;
    }

    @Generated
    public void setNumConsultasCPrenatal(Integer numConsultasCPrenatal) {
        this.numConsultasCPrenatal = numConsultasCPrenatal;
    }

    @Generated
    public void setCodSexoBiologico(String codSexoBiologico) {
        this.codSexoBiologico = codSexoBiologico;
    }

    @Generated
    public void setPeso(Long peso) {
        this.peso = peso;
    }

    @Generated
    public void setCodDiagnosticoPrincipal(String codDiagnosticoPrincipal) {
        this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
    }

    @Generated
    public void setCondicionDestino(String condicionDestino) {
        this.condicionDestino = condicionDestino;
    }

    @Generated
    public void setCodDiagnosticoCausaMuerte(String codDiagnosticoCausaMuerte) {
        this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
    }

    @Generated
    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    @Generated
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public static DetalleRecienNacidoDTOBuilder builder() {
        return new DetalleRecienNacidoDTOBuilder();
    }

    @Generated
    public DetalleRecienNacidoDTO(String codPrestador, String tipoDocumentoIdentificacion, String numDocumentoIdentificacion, String fechaNacimiento, Integer edadGestacional, Integer numConsultasCPrenatal, String codSexoBiologico, Long peso, String codDiagnosticoPrincipal, String condicionDestino, String codDiagnosticoCausaMuerte, String fechaEgreso, Integer consecutivo) {
        this.codPrestador = codPrestador;
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
        this.numDocumentoIdentificacion = numDocumentoIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.edadGestacional = edadGestacional;
        this.numConsultasCPrenatal = numConsultasCPrenatal;
        this.codSexoBiologico = codSexoBiologico;
        this.peso = peso;
        this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
        this.condicionDestino = condicionDestino;
        this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
        this.fechaEgreso = fechaEgreso;
        this.consecutivo = consecutivo;
    }

    @Generated
    public DetalleRecienNacidoDTO() {
    }

    @Generated
    public String getCodPrestador() {
        return this.codPrestador;
    }

    @Generated
    public String getTipoDocumentoIdentificacion() {
        return this.tipoDocumentoIdentificacion;
    }

    @Generated
    public String getNumDocumentoIdentificacion() {
        return this.numDocumentoIdentificacion;
    }

    @Generated
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    @Generated
    public Integer getEdadGestacional() {
        return this.edadGestacional;
    }

    @Generated
    public Integer getNumConsultasCPrenatal() {
        return this.numConsultasCPrenatal;
    }

    @Generated
    public String getCodSexoBiologico() {
        return this.codSexoBiologico;
    }

    @Generated
    public Long getPeso() {
        return this.peso;
    }

    @Generated
    public String getCodDiagnosticoPrincipal() {
        return this.codDiagnosticoPrincipal;
    }

    @Generated
    public String getCondicionDestino() {
        return this.condicionDestino;
    }

    @Generated
    public String getCodDiagnosticoCausaMuerte() {
        return this.codDiagnosticoCausaMuerte;
    }

    @Generated
    public String getFechaEgreso() {
        return this.fechaEgreso;
    }

    @Generated
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
}
