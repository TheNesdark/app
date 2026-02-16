package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleUsuariosDTO.class */
public class DetalleUsuariosDTO {
    private String tipoDocumentoIdentificacion;
    private String numDocumentoIdentificacion;
    private String tipoUsuario;
    private String fechaNacimiento;
    private SexoDTO codSexo;
    private String codPaisResidencia;
    private String codMunicipioResidencia;
    private String codZonaTerritorialResidencia;
    private String incapacidad;
    private Integer consecutivo;
    private String codPaisOrigen;
    private Servicios servicios;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleUsuariosDTO$DetalleUsuariosDTOBuilder.class */
    @Generated
    public static class DetalleUsuariosDTOBuilder {

        @Generated
        private String tipoDocumentoIdentificacion;

        @Generated
        private String numDocumentoIdentificacion;

        @Generated
        private String tipoUsuario;

        @Generated
        private String fechaNacimiento;

        @Generated
        private SexoDTO codSexo;

        @Generated
        private String codPaisResidencia;

        @Generated
        private String codMunicipioResidencia;

        @Generated
        private String codZonaTerritorialResidencia;

        @Generated
        private String incapacidad;

        @Generated
        private Integer consecutivo;

        @Generated
        private String codPaisOrigen;

        @Generated
        private Servicios servicios;

        @Generated
        DetalleUsuariosDTOBuilder() {
        }

        @Generated
        public DetalleUsuariosDTOBuilder tipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
            this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder numDocumentoIdentificacion(String numDocumentoIdentificacion) {
            this.numDocumentoIdentificacion = numDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder tipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder fechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder codSexo(SexoDTO codSexo) {
            this.codSexo = codSexo;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder codPaisResidencia(String codPaisResidencia) {
            this.codPaisResidencia = codPaisResidencia;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder codMunicipioResidencia(String codMunicipioResidencia) {
            this.codMunicipioResidencia = codMunicipioResidencia;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder codZonaTerritorialResidencia(String codZonaTerritorialResidencia) {
            this.codZonaTerritorialResidencia = codZonaTerritorialResidencia;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder incapacidad(String incapacidad) {
            this.incapacidad = incapacidad;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder codPaisOrigen(String codPaisOrigen) {
            this.codPaisOrigen = codPaisOrigen;
            return this;
        }

        @Generated
        public DetalleUsuariosDTOBuilder servicios(Servicios servicios) {
            this.servicios = servicios;
            return this;
        }

        @Generated
        public DetalleUsuariosDTO build() {
            return new DetalleUsuariosDTO(this.tipoDocumentoIdentificacion, this.numDocumentoIdentificacion, this.tipoUsuario, this.fechaNacimiento, this.codSexo, this.codPaisResidencia, this.codMunicipioResidencia, this.codZonaTerritorialResidencia, this.incapacidad, this.consecutivo, this.codPaisOrigen, this.servicios);
        }

        @Generated
        public String toString() {
            return "DetalleUsuariosDTO.DetalleUsuariosDTOBuilder(tipoDocumentoIdentificacion=" + this.tipoDocumentoIdentificacion + ", numDocumentoIdentificacion=" + this.numDocumentoIdentificacion + ", tipoUsuario=" + this.tipoUsuario + ", fechaNacimiento=" + this.fechaNacimiento + ", codSexo=" + this.codSexo + ", codPaisResidencia=" + this.codPaisResidencia + ", codMunicipioResidencia=" + this.codMunicipioResidencia + ", codZonaTerritorialResidencia=" + this.codZonaTerritorialResidencia + ", incapacidad=" + this.incapacidad + ", consecutivo=" + this.consecutivo + ", codPaisOrigen=" + this.codPaisOrigen + ", servicios=" + this.servicios + ")";
        }
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
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Generated
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Generated
    public void setCodSexo(SexoDTO codSexo) {
        this.codSexo = codSexo;
    }

    @Generated
    public void setCodPaisResidencia(String codPaisResidencia) {
        this.codPaisResidencia = codPaisResidencia;
    }

    @Generated
    public void setCodMunicipioResidencia(String codMunicipioResidencia) {
        this.codMunicipioResidencia = codMunicipioResidencia;
    }

    @Generated
    public void setCodZonaTerritorialResidencia(String codZonaTerritorialResidencia) {
        this.codZonaTerritorialResidencia = codZonaTerritorialResidencia;
    }

    @Generated
    public void setIncapacidad(String incapacidad) {
        this.incapacidad = incapacidad;
    }

    @Generated
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public void setCodPaisOrigen(String codPaisOrigen) {
        this.codPaisOrigen = codPaisOrigen;
    }

    @Generated
    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @Generated
    public static DetalleUsuariosDTOBuilder builder() {
        return new DetalleUsuariosDTOBuilder();
    }

    @Generated
    public DetalleUsuariosDTO(String tipoDocumentoIdentificacion, String numDocumentoIdentificacion, String tipoUsuario, String fechaNacimiento, SexoDTO codSexo, String codPaisResidencia, String codMunicipioResidencia, String codZonaTerritorialResidencia, String incapacidad, Integer consecutivo, String codPaisOrigen, Servicios servicios) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
        this.numDocumentoIdentificacion = numDocumentoIdentificacion;
        this.tipoUsuario = tipoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.codSexo = codSexo;
        this.codPaisResidencia = codPaisResidencia;
        this.codMunicipioResidencia = codMunicipioResidencia;
        this.codZonaTerritorialResidencia = codZonaTerritorialResidencia;
        this.incapacidad = incapacidad;
        this.consecutivo = consecutivo;
        this.codPaisOrigen = codPaisOrigen;
        this.servicios = servicios;
    }

    @Generated
    public DetalleUsuariosDTO() {
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
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    @Generated
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    @Generated
    public SexoDTO getCodSexo() {
        return this.codSexo;
    }

    @Generated
    public String getCodPaisResidencia() {
        return this.codPaisResidencia;
    }

    @Generated
    public String getCodMunicipioResidencia() {
        return this.codMunicipioResidencia;
    }

    @Generated
    public String getCodZonaTerritorialResidencia() {
        return this.codZonaTerritorialResidencia;
    }

    @Generated
    public String getIncapacidad() {
        return this.incapacidad;
    }

    @Generated
    public Integer getConsecutivo() {
        return this.consecutivo;
    }

    @Generated
    public String getCodPaisOrigen() {
        return this.codPaisOrigen;
    }

    @Generated
    public Servicios getServicios() {
        return this.servicios;
    }
}
