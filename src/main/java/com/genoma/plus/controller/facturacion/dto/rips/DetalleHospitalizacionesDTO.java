package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleHospitalizacionesDTO.class */
public class DetalleHospitalizacionesDTO {
    private String codPrestador;
    private String viaIngresoServicioSalud;
    private String fechaInicioAtencion;
    private String numAutorizacion;
    private String causaMotivoAtencion;
    private String codDiagnosticoPrincipal;
    private String codDiagnosticoPrincipalE;
    private String codDiagnosticoRelacionadoE1;
    private String codDiagnosticoRelacionadoE2;
    private String codDiagnosticoRelacionadoE3;
    private String codComplicacion;
    private String condicionDestinoUsuarioEgreso;
    private String codDiagnosticoCausaMuerte;
    private String fechaEgreso;
    private Integer consecutivo;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleHospitalizacionesDTO$DetalleHospitalizacionesDTOBuilder.class */
    @Generated
    public static class DetalleHospitalizacionesDTOBuilder {

        @Generated
        private String codPrestador;

        @Generated
        private String viaIngresoServicioSalud;

        @Generated
        private String fechaInicioAtencion;

        @Generated
        private String numAutorizacion;

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
        private String codComplicacion;

        @Generated
        private String condicionDestinoUsuarioEgreso;

        @Generated
        private String codDiagnosticoCausaMuerte;

        @Generated
        private String fechaEgreso;

        @Generated
        private Integer consecutivo;

        @Generated
        DetalleHospitalizacionesDTOBuilder() {
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codPrestador(String codPrestador) {
            this.codPrestador = codPrestador;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder viaIngresoServicioSalud(String viaIngresoServicioSalud) {
            this.viaIngresoServicioSalud = viaIngresoServicioSalud;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder fechaInicioAtencion(String fechaInicioAtencion) {
            this.fechaInicioAtencion = fechaInicioAtencion;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder numAutorizacion(String numAutorizacion) {
            this.numAutorizacion = numAutorizacion;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder causaMotivoAtencion(String causaMotivoAtencion) {
            this.causaMotivoAtencion = causaMotivoAtencion;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoPrincipal(String codDiagnosticoPrincipal) {
            this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoPrincipalE(String codDiagnosticoPrincipalE) {
            this.codDiagnosticoPrincipalE = codDiagnosticoPrincipalE;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoRelacionadoE1(String codDiagnosticoRelacionadoE1) {
            this.codDiagnosticoRelacionadoE1 = codDiagnosticoRelacionadoE1;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoRelacionadoE2(String codDiagnosticoRelacionadoE2) {
            this.codDiagnosticoRelacionadoE2 = codDiagnosticoRelacionadoE2;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoRelacionadoE3(String codDiagnosticoRelacionadoE3) {
            this.codDiagnosticoRelacionadoE3 = codDiagnosticoRelacionadoE3;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codComplicacion(String codComplicacion) {
            this.codComplicacion = codComplicacion;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder condicionDestinoUsuarioEgreso(String condicionDestinoUsuarioEgreso) {
            this.condicionDestinoUsuarioEgreso = condicionDestinoUsuarioEgreso;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder codDiagnosticoCausaMuerte(String codDiagnosticoCausaMuerte) {
            this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder fechaEgreso(String fechaEgreso) {
            this.fechaEgreso = fechaEgreso;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTOBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public DetalleHospitalizacionesDTO build() {
            return new DetalleHospitalizacionesDTO(this.codPrestador, this.viaIngresoServicioSalud, this.fechaInicioAtencion, this.numAutorizacion, this.causaMotivoAtencion, this.codDiagnosticoPrincipal, this.codDiagnosticoPrincipalE, this.codDiagnosticoRelacionadoE1, this.codDiagnosticoRelacionadoE2, this.codDiagnosticoRelacionadoE3, this.codComplicacion, this.condicionDestinoUsuarioEgreso, this.codDiagnosticoCausaMuerte, this.fechaEgreso, this.consecutivo);
        }

        @Generated
        public String toString() {
            return "DetalleHospitalizacionesDTO.DetalleHospitalizacionesDTOBuilder(codPrestador=" + this.codPrestador + ", viaIngresoServicioSalud=" + this.viaIngresoServicioSalud + ", fechaInicioAtencion=" + this.fechaInicioAtencion + ", numAutorizacion=" + this.numAutorizacion + ", causaMotivoAtencion=" + this.causaMotivoAtencion + ", codDiagnosticoPrincipal=" + this.codDiagnosticoPrincipal + ", codDiagnosticoPrincipalE=" + this.codDiagnosticoPrincipalE + ", codDiagnosticoRelacionadoE1=" + this.codDiagnosticoRelacionadoE1 + ", codDiagnosticoRelacionadoE2=" + this.codDiagnosticoRelacionadoE2 + ", codDiagnosticoRelacionadoE3=" + this.codDiagnosticoRelacionadoE3 + ", codComplicacion=" + this.codComplicacion + ", condicionDestinoUsuarioEgreso=" + this.condicionDestinoUsuarioEgreso + ", codDiagnosticoCausaMuerte=" + this.codDiagnosticoCausaMuerte + ", fechaEgreso=" + this.fechaEgreso + ", consecutivo=" + this.consecutivo + ")";
        }
    }

    @Generated
    public void setCodPrestador(String codPrestador) {
        this.codPrestador = codPrestador;
    }

    @Generated
    public void setViaIngresoServicioSalud(String viaIngresoServicioSalud) {
        this.viaIngresoServicioSalud = viaIngresoServicioSalud;
    }

    @Generated
    public void setFechaInicioAtencion(String fechaInicioAtencion) {
        this.fechaInicioAtencion = fechaInicioAtencion;
    }

    @Generated
    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
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
    public void setCodComplicacion(String codComplicacion) {
        this.codComplicacion = codComplicacion;
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
    public static DetalleHospitalizacionesDTOBuilder builder() {
        return new DetalleHospitalizacionesDTOBuilder();
    }

    @Generated
    public DetalleHospitalizacionesDTO(String codPrestador, String viaIngresoServicioSalud, String fechaInicioAtencion, String numAutorizacion, String causaMotivoAtencion, String codDiagnosticoPrincipal, String codDiagnosticoPrincipalE, String codDiagnosticoRelacionadoE1, String codDiagnosticoRelacionadoE2, String codDiagnosticoRelacionadoE3, String codComplicacion, String condicionDestinoUsuarioEgreso, String codDiagnosticoCausaMuerte, String fechaEgreso, Integer consecutivo) {
        this.codPrestador = codPrestador;
        this.viaIngresoServicioSalud = viaIngresoServicioSalud;
        this.fechaInicioAtencion = fechaInicioAtencion;
        this.numAutorizacion = numAutorizacion;
        this.causaMotivoAtencion = causaMotivoAtencion;
        this.codDiagnosticoPrincipal = codDiagnosticoPrincipal;
        this.codDiagnosticoPrincipalE = codDiagnosticoPrincipalE;
        this.codDiagnosticoRelacionadoE1 = codDiagnosticoRelacionadoE1;
        this.codDiagnosticoRelacionadoE2 = codDiagnosticoRelacionadoE2;
        this.codDiagnosticoRelacionadoE3 = codDiagnosticoRelacionadoE3;
        this.codComplicacion = codComplicacion;
        this.condicionDestinoUsuarioEgreso = condicionDestinoUsuarioEgreso;
        this.codDiagnosticoCausaMuerte = codDiagnosticoCausaMuerte;
        this.fechaEgreso = fechaEgreso;
        this.consecutivo = consecutivo;
    }

    @Generated
    public DetalleHospitalizacionesDTO() {
    }

    @Generated
    public String getCodPrestador() {
        return this.codPrestador;
    }

    @Generated
    public String getViaIngresoServicioSalud() {
        return this.viaIngresoServicioSalud;
    }

    @Generated
    public String getFechaInicioAtencion() {
        return this.fechaInicioAtencion;
    }

    @Generated
    public String getNumAutorizacion() {
        return this.numAutorizacion;
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
    public String getCodComplicacion() {
        return this.codComplicacion;
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
