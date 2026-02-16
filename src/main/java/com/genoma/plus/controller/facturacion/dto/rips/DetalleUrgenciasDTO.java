package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleUrgenciasDTO.class */
public class DetalleUrgenciasDTO {
    private String codPrestador;
    private String fechaInicioAtencion;
    private String causaMotivoAtencion;
    private String codDiagnosticoPrincipal;
    private String codDiagnosticoPrincipalE;
    private String codDiagnosticoRelacionadoE1;
    private String codDiagnosticoRelacionadoE2;
    private String codDiagnosticoRelacionadoE3;
    private String condicionDestinoUsuarioEgreso;
    private String codDiagnosticoCausaMuerte;
    private String fechaEgreso;
    private Integer consecutivo;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleUrgenciasDTO$DetalleUrgenciasDTOBuilder.class */
    @Generated
    public static class DetalleUrgenciasDTOBuilder {

        @Generated
        private String codPrestador;

        @Generated
        private String fechaInicioAtencion;

        @Generated
        private String causaMotivoAtencion;

        @Generated
        private String codDiagnosticoPrincipal;

        @Generated
        private String codDiagnosticoPrincipalE;

        @Generated
        private String codDiagnosticoRelacionadoE1;

        @Generated
        private String codDiagnosticoRelacionadoE2;

        @Generated
        private String codDiagnosticoRelacionadoE3;

        @Generated
        private String condicionDestinoUsuarioEgreso;

        @Generated
        private String codDiagnosticoCausaMuerte;

        @Generated
        private String fechaEgreso;

        @Generated
        private Integer consecutivo;

        @Generated
        DetalleUrgenciasDTOBuilder() {
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codPrestador(String codPrestador) {
            this.codPrestador = codPrestador;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder fechaInicioAtencion(String fechaInicioAtencion) {
            this.fechaInicioAtencion = fechaInicioAtencion;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder causaMotivoAtencion(String causaMotivoAtencion) {
            this.causaMotivoAtencion = causaMotivoAtencion;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoPrincipal(String codDiagnosticoPrincipal) {
            this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoPrincipalE(String codDiagnosticoPrincipalE) {
            this.codDiagnosticoPrincipalE = codDiagnosticoPrincipalE;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoRelacionadoE1(String codDiagnosticoRelacionadoE1) {
            this.codDiagnosticoRelacionadoE1 = codDiagnosticoRelacionadoE1;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoRelacionadoE2(String codDiagnosticoRelacionadoE2) {
            this.codDiagnosticoRelacionadoE2 = codDiagnosticoRelacionadoE2;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoRelacionadoE3(String codDiagnosticoRelacionadoE3) {
            this.codDiagnosticoRelacionadoE3 = codDiagnosticoRelacionadoE3;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder condicionDestinoUsuarioEgreso(String condicionDestinoUsuarioEgreso) {
            this.condicionDestinoUsuarioEgreso = condicionDestinoUsuarioEgreso;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder codDiagnosticoCausaMuerte(String codDiagnosticoCausaMuerte) {
            this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder fechaEgreso(String fechaEgreso) {
            this.fechaEgreso = fechaEgreso;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTOBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public DetalleUrgenciasDTO build() {
            return new DetalleUrgenciasDTO(this.codPrestador, this.fechaInicioAtencion, this.causaMotivoAtencion, this.codDiagnosticoPrincipal, this.codDiagnosticoPrincipalE, this.codDiagnosticoRelacionadoE1, this.codDiagnosticoRelacionadoE2, this.codDiagnosticoRelacionadoE3, this.condicionDestinoUsuarioEgreso, this.codDiagnosticoCausaMuerte, this.fechaEgreso, this.consecutivo);
        }

        @Generated
        public String toString() {
            return "DetalleUrgenciasDTO.DetalleUrgenciasDTOBuilder(codPrestador=" + this.codPrestador + ", fechaInicioAtencion=" + this.fechaInicioAtencion + ", causaMotivoAtencion=" + this.causaMotivoAtencion + ", codDiagnosticoPrincipal=" + this.codDiagnosticoPrincipal + ", codDiagnosticoPrincipalE=" + this.codDiagnosticoPrincipalE + ", codDiagnosticoRelacionadoE1=" + this.codDiagnosticoRelacionadoE1 + ", codDiagnosticoRelacionadoE2=" + this.codDiagnosticoRelacionadoE2 + ", codDiagnosticoRelacionadoE3=" + this.codDiagnosticoRelacionadoE3 + ", condicionDestinoUsuarioEgreso=" + this.condicionDestinoUsuarioEgreso + ", codDiagnosticoCausaMuerte=" + this.codDiagnosticoCausaMuerte + ", fechaEgreso=" + this.fechaEgreso + ", consecutivo=" + this.consecutivo + ")";
        }
    }

    @Generated
    public void setCodPrestador(String codPrestador) {
        this.codPrestador = codPrestador;
    }

    @Generated
    public void setFechaInicioAtencion(String fechaInicioAtencion) {
        this.fechaInicioAtencion = fechaInicioAtencion;
    }

    @Generated
    public void setCausaMotivoAtencion(String causaMotivoAtencion) {
        this.causaMotivoAtencion = causaMotivoAtencion;
    }

    @Generated
    public void setCodDiagnosticoPrincipal(String codDiagnosticoPrincipal) {
        this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
    }

    @Generated
    public void setCodDiagnosticoPrincipalE(String codDiagnosticoPrincipalE) {
        this.codDiagnosticoPrincipalE = codDiagnosticoPrincipalE;
    }

    @Generated
    public void setCodDiagnosticoRelacionadoE1(String codDiagnosticoRelacionadoE1) {
        this.codDiagnosticoRelacionadoE1 = codDiagnosticoRelacionadoE1;
    }

    @Generated
    public void setCodDiagnosticoRelacionadoE2(String codDiagnosticoRelacionadoE2) {
        this.codDiagnosticoRelacionadoE2 = codDiagnosticoRelacionadoE2;
    }

    @Generated
    public void setCodDiagnosticoRelacionadoE3(String codDiagnosticoRelacionadoE3) {
        this.codDiagnosticoRelacionadoE3 = codDiagnosticoRelacionadoE3;
    }

    @Generated
    public void setCondicionDestinoUsuarioEgreso(String condicionDestinoUsuarioEgreso) {
        this.condicionDestinoUsuarioEgreso = condicionDestinoUsuarioEgreso;
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
    public static DetalleUrgenciasDTOBuilder builder() {
        return new DetalleUrgenciasDTOBuilder();
    }

    @Generated
    public DetalleUrgenciasDTO(String codPrestador, String fechaInicioAtencion, String causaMotivoAtencion, String codDiagnosticoPrincipal, String codDiagnosticoPrincipalE, String codDiagnosticoRelacionadoE1, String codDiagnosticoRelacionadoE2, String codDiagnosticoRelacionadoE3, String condicionDestinoUsuarioEgreso, String codDiagnosticoCausaMuerte, String fechaEgreso, Integer consecutivo) {
        this.codPrestador = codPrestador;
        this.fechaInicioAtencion = fechaInicioAtencion;
        this.causaMotivoAtencion = causaMotivoAtencion;
        this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
        this.codDiagnosticoPrincipalE = codDiagnosticoPrincipalE;
        this.codDiagnosticoRelacionadoE1 = codDiagnosticoRelacionadoE1;
        this.codDiagnosticoRelacionadoE2 = codDiagnosticoRelacionadoE2;
        this.codDiagnosticoRelacionadoE3 = codDiagnosticoRelacionadoE3;
        this.condicionDestinoUsuarioEgreso = condicionDestinoUsuarioEgreso;
        this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
        this.fechaEgreso = fechaEgreso;
        this.consecutivo = consecutivo;
    }

    @Generated
    public DetalleUrgenciasDTO() {
    }

    @Generated
    public String getCodPrestador() {
        return this.codPrestador;
    }

    @Generated
    public String getFechaInicioAtencion() {
        return this.fechaInicioAtencion;
    }

    @Generated
    public String getCausaMotivoAtencion() {
        return this.causaMotivoAtencion;
    }

    @Generated
    public String getCodDiagnosticoPrincipal() {
        return this.codDiagnosticoPrincipal;
    }

    @Generated
    public String getCodDiagnosticoPrincipalE() {
        return this.codDiagnosticoPrincipalE;
    }

    @Generated
    public String getCodDiagnosticoRelacionadoE1() {
        return this.codDiagnosticoRelacionadoE1;
    }

    @Generated
    public String getCodDiagnosticoRelacionadoE2() {
        return this.codDiagnosticoRelacionadoE2;
    }

    @Generated
    public String getCodDiagnosticoRelacionadoE3() {
        return this.codDiagnosticoRelacionadoE3;
    }

    @Generated
    public String getCondicionDestinoUsuarioEgreso() {
        return this.condicionDestinoUsuarioEgreso;
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
