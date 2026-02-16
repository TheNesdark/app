package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/AnexoInformacionIpsDto.class */
public class AnexoInformacionIpsDto {
    private String numeroAutorizacion;
    private String numeroIdentificacionIps;
    private String codigoPrestador;
    private String codigoEntidadPagadora;
    private String usuarioGenera;
    private String documentoUsuarioGenera;
    private String cargoUsuarioGenera;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AnexoInformacionIpsDto)) {
            return false;
        }
        AnexoInformacionIpsDto other = (AnexoInformacionIpsDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$numeroAutorizacion = getNumeroAutorizacion();
        Object other$numeroAutorizacion = other.getNumeroAutorizacion();
        if (this$numeroAutorizacion == null) {
            if (other$numeroAutorizacion != null) {
                return false;
            }
        } else if (!this$numeroAutorizacion.equals(other$numeroAutorizacion)) {
            return false;
        }
        Object this$numeroIdentificacionIps = getNumeroIdentificacionIps();
        Object other$numeroIdentificacionIps = other.getNumeroIdentificacionIps();
        if (this$numeroIdentificacionIps == null) {
            if (other$numeroIdentificacionIps != null) {
                return false;
            }
        } else if (!this$numeroIdentificacionIps.equals(other$numeroIdentificacionIps)) {
            return false;
        }
        Object this$codigoPrestador = getCodigoPrestador();
        Object other$codigoPrestador = other.getCodigoPrestador();
        if (this$codigoPrestador == null) {
            if (other$codigoPrestador != null) {
                return false;
            }
        } else if (!this$codigoPrestador.equals(other$codigoPrestador)) {
            return false;
        }
        Object this$codigoEntidadPagadora = getCodigoEntidadPagadora();
        Object other$codigoEntidadPagadora = other.getCodigoEntidadPagadora();
        if (this$codigoEntidadPagadora == null) {
            if (other$codigoEntidadPagadora != null) {
                return false;
            }
        } else if (!this$codigoEntidadPagadora.equals(other$codigoEntidadPagadora)) {
            return false;
        }
        Object this$usuarioGenera = getUsuarioGenera();
        Object other$usuarioGenera = other.getUsuarioGenera();
        if (this$usuarioGenera == null) {
            if (other$usuarioGenera != null) {
                return false;
            }
        } else if (!this$usuarioGenera.equals(other$usuarioGenera)) {
            return false;
        }
        Object this$documentoUsuarioGenera = getDocumentoUsuarioGenera();
        Object other$documentoUsuarioGenera = other.getDocumentoUsuarioGenera();
        if (this$documentoUsuarioGenera == null) {
            if (other$documentoUsuarioGenera != null) {
                return false;
            }
        } else if (!this$documentoUsuarioGenera.equals(other$documentoUsuarioGenera)) {
            return false;
        }
        Object this$cargoUsuarioGenera = getCargoUsuarioGenera();
        Object other$cargoUsuarioGenera = other.getCargoUsuarioGenera();
        return this$cargoUsuarioGenera == null ? other$cargoUsuarioGenera == null : this$cargoUsuarioGenera.equals(other$cargoUsuarioGenera);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AnexoInformacionIpsDto;
    }

    @Generated
    public int hashCode() {
        Object $numeroAutorizacion = getNumeroAutorizacion();
        int result = (1 * 59) + ($numeroAutorizacion == null ? 43 : $numeroAutorizacion.hashCode());
        Object $numeroIdentificacionIps = getNumeroIdentificacionIps();
        int result2 = (result * 59) + ($numeroIdentificacionIps == null ? 43 : $numeroIdentificacionIps.hashCode());
        Object $codigoPrestador = getCodigoPrestador();
        int result3 = (result2 * 59) + ($codigoPrestador == null ? 43 : $codigoPrestador.hashCode());
        Object $codigoEntidadPagadora = getCodigoEntidadPagadora();
        int result4 = (result3 * 59) + ($codigoEntidadPagadora == null ? 43 : $codigoEntidadPagadora.hashCode());
        Object $usuarioGenera = getUsuarioGenera();
        int result5 = (result4 * 59) + ($usuarioGenera == null ? 43 : $usuarioGenera.hashCode());
        Object $documentoUsuarioGenera = getDocumentoUsuarioGenera();
        int result6 = (result5 * 59) + ($documentoUsuarioGenera == null ? 43 : $documentoUsuarioGenera.hashCode());
        Object $cargoUsuarioGenera = getCargoUsuarioGenera();
        return (result6 * 59) + ($cargoUsuarioGenera == null ? 43 : $cargoUsuarioGenera.hashCode());
    }

    @Generated
    public String toString() {
        return "AnexoInformacionIpsDto(numeroAutorizacion=" + getNumeroAutorizacion() + ", numeroIdentificacionIps=" + getNumeroIdentificacionIps() + ", codigoPrestador=" + getCodigoPrestador() + ", codigoEntidadPagadora=" + getCodigoEntidadPagadora() + ", usuarioGenera=" + getUsuarioGenera() + ", documentoUsuarioGenera=" + getDocumentoUsuarioGenera() + ", cargoUsuarioGenera=" + getCargoUsuarioGenera() + ")";
    }

    @Generated
    public AnexoInformacionIpsDto(String numeroAutorizacion, String numeroIdentificacionIps, String codigoPrestador, String codigoEntidadPagadora, String usuarioGenera, String documentoUsuarioGenera, String cargoUsuarioGenera) {
        this.numeroAutorizacion = numeroAutorizacion;
        this.numeroIdentificacionIps = numeroIdentificacionIps;
        this.codigoPrestador = codigoPrestador;
        this.codigoEntidadPagadora = codigoEntidadPagadora;
        this.usuarioGenera = usuarioGenera;
        this.documentoUsuarioGenera = documentoUsuarioGenera;
        this.cargoUsuarioGenera = cargoUsuarioGenera;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/AnexoInformacionIpsDto$AnexoInformacionIpsDtoBuilder.class */
    @Generated
    public static class AnexoInformacionIpsDtoBuilder {

        @Generated
        private String numeroAutorizacion;

        @Generated
        private String numeroIdentificacionIps;

        @Generated
        private String codigoPrestador;

        @Generated
        private String codigoEntidadPagadora;

        @Generated
        private String usuarioGenera;

        @Generated
        private String documentoUsuarioGenera;

        @Generated
        private String cargoUsuarioGenera;

        @Generated
        AnexoInformacionIpsDtoBuilder() {
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder numeroAutorizacion(String numeroAutorizacion) {
            this.numeroAutorizacion = numeroAutorizacion;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder numeroIdentificacionIps(String numeroIdentificacionIps) {
            this.numeroIdentificacionIps = numeroIdentificacionIps;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder codigoPrestador(String codigoPrestador) {
            this.codigoPrestador = codigoPrestador;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder codigoEntidadPagadora(String codigoEntidadPagadora) {
            this.codigoEntidadPagadora = codigoEntidadPagadora;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder usuarioGenera(String usuarioGenera) {
            this.usuarioGenera = usuarioGenera;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder documentoUsuarioGenera(String documentoUsuarioGenera) {
            this.documentoUsuarioGenera = documentoUsuarioGenera;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDtoBuilder cargoUsuarioGenera(String cargoUsuarioGenera) {
            this.cargoUsuarioGenera = cargoUsuarioGenera;
            return this;
        }

        @Generated
        public AnexoInformacionIpsDto build() {
            return new AnexoInformacionIpsDto(this.numeroAutorizacion, this.numeroIdentificacionIps, this.codigoPrestador, this.codigoEntidadPagadora, this.usuarioGenera, this.documentoUsuarioGenera, this.cargoUsuarioGenera);
        }

        @Generated
        public String toString() {
            return "AnexoInformacionIpsDto.AnexoInformacionIpsDtoBuilder(numeroAutorizacion=" + this.numeroAutorizacion + ", numeroIdentificacionIps=" + this.numeroIdentificacionIps + ", codigoPrestador=" + this.codigoPrestador + ", codigoEntidadPagadora=" + this.codigoEntidadPagadora + ", usuarioGenera=" + this.usuarioGenera + ", documentoUsuarioGenera=" + this.documentoUsuarioGenera + ", cargoUsuarioGenera=" + this.cargoUsuarioGenera + ")";
        }
    }

    @Generated
    public AnexoInformacionIpsDto() {
    }

    @Generated
    public static AnexoInformacionIpsDtoBuilder builder() {
        return new AnexoInformacionIpsDtoBuilder();
    }

    @Generated
    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    @Generated
    public void setNumeroIdentificacionIps(String numeroIdentificacionIps) {
        this.numeroIdentificacionIps = numeroIdentificacionIps;
    }

    @Generated
    public void setCodigoPrestador(String codigoPrestador) {
        this.codigoPrestador = codigoPrestador;
    }

    @Generated
    public void setCodigoEntidadPagadora(String codigoEntidadPagadora) {
        this.codigoEntidadPagadora = codigoEntidadPagadora;
    }

    @Generated
    public void setUsuarioGenera(String usuarioGenera) {
        this.usuarioGenera = usuarioGenera;
    }

    @Generated
    public void setDocumentoUsuarioGenera(String documentoUsuarioGenera) {
        this.documentoUsuarioGenera = documentoUsuarioGenera;
    }

    @Generated
    public void setCargoUsuarioGenera(String cargoUsuarioGenera) {
        this.cargoUsuarioGenera = cargoUsuarioGenera;
    }

    @Generated
    public String getNumeroAutorizacion() {
        return this.numeroAutorizacion;
    }

    @Generated
    public String getNumeroIdentificacionIps() {
        return this.numeroIdentificacionIps;
    }

    @Generated
    public String getCodigoPrestador() {
        return this.codigoPrestador;
    }

    @Generated
    public String getCodigoEntidadPagadora() {
        return this.codigoEntidadPagadora;
    }

    @Generated
    public String getUsuarioGenera() {
        return this.usuarioGenera;
    }

    @Generated
    public String getDocumentoUsuarioGenera() {
        return this.documentoUsuarioGenera;
    }

    @Generated
    public String getCargoUsuarioGenera() {
        return this.cargoUsuarioGenera;
    }
}
