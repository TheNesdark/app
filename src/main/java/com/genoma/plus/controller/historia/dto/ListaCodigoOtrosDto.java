package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCodigoOtrosDto.class */
public class ListaCodigoOtrosDto {
    private String codigoOtrosServicios;
    private String nombreOtrosServicios;
    private String cantidadOtrosServicios;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListaCodigoOtrosDto)) {
            return false;
        }
        ListaCodigoOtrosDto other = (ListaCodigoOtrosDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$codigoOtrosServicios = getCodigoOtrosServicios();
        Object other$codigoOtrosServicios = other.getCodigoOtrosServicios();
        if (this$codigoOtrosServicios == null) {
            if (other$codigoOtrosServicios != null) {
                return false;
            }
        } else if (!this$codigoOtrosServicios.equals(other$codigoOtrosServicios)) {
            return false;
        }
        Object this$nombreOtrosServicios = getNombreOtrosServicios();
        Object other$nombreOtrosServicios = other.getNombreOtrosServicios();
        if (this$nombreOtrosServicios == null) {
            if (other$nombreOtrosServicios != null) {
                return false;
            }
        } else if (!this$nombreOtrosServicios.equals(other$nombreOtrosServicios)) {
            return false;
        }
        Object this$cantidadOtrosServicios = getCantidadOtrosServicios();
        Object other$cantidadOtrosServicios = other.getCantidadOtrosServicios();
        return this$cantidadOtrosServicios == null ? other$cantidadOtrosServicios == null : this$cantidadOtrosServicios.equals(other$cantidadOtrosServicios);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListaCodigoOtrosDto;
    }

    @Generated
    public int hashCode() {
        Object $codigoOtrosServicios = getCodigoOtrosServicios();
        int result = (1 * 59) + ($codigoOtrosServicios == null ? 43 : $codigoOtrosServicios.hashCode());
        Object $nombreOtrosServicios = getNombreOtrosServicios();
        int result2 = (result * 59) + ($nombreOtrosServicios == null ? 43 : $nombreOtrosServicios.hashCode());
        Object $cantidadOtrosServicios = getCantidadOtrosServicios();
        return (result2 * 59) + ($cantidadOtrosServicios == null ? 43 : $cantidadOtrosServicios.hashCode());
    }

    @Generated
    public String toString() {
        return "ListaCodigoOtrosDto(codigoOtrosServicios=" + getCodigoOtrosServicios() + ", nombreOtrosServicios=" + getNombreOtrosServicios() + ", cantidadOtrosServicios=" + getCantidadOtrosServicios() + ")";
    }

    @Generated
    public ListaCodigoOtrosDto(String codigoOtrosServicios, String nombreOtrosServicios, String cantidadOtrosServicios) {
        this.codigoOtrosServicios = codigoOtrosServicios;
        this.nombreOtrosServicios = nombreOtrosServicios;
        this.cantidadOtrosServicios = cantidadOtrosServicios;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCodigoOtrosDto$ListaCodigoOtrosDtoBuilder.class */
    @Generated
    public static class ListaCodigoOtrosDtoBuilder {

        @Generated
        private String codigoOtrosServicios;

        @Generated
        private String nombreOtrosServicios;

        @Generated
        private String cantidadOtrosServicios;

        @Generated
        ListaCodigoOtrosDtoBuilder() {
        }

        @Generated
        public ListaCodigoOtrosDtoBuilder codigoOtrosServicios(String codigoOtrosServicios) {
            this.codigoOtrosServicios = codigoOtrosServicios;
            return this;
        }

        @Generated
        public ListaCodigoOtrosDtoBuilder nombreOtrosServicios(String nombreOtrosServicios) {
            this.nombreOtrosServicios = nombreOtrosServicios;
            return this;
        }

        @Generated
        public ListaCodigoOtrosDtoBuilder cantidadOtrosServicios(String cantidadOtrosServicios) {
            this.cantidadOtrosServicios = cantidadOtrosServicios;
            return this;
        }

        @Generated
        public ListaCodigoOtrosDto build() {
            return new ListaCodigoOtrosDto(this.codigoOtrosServicios, this.nombreOtrosServicios, this.cantidadOtrosServicios);
        }

        @Generated
        public String toString() {
            return "ListaCodigoOtrosDto.ListaCodigoOtrosDtoBuilder(codigoOtrosServicios=" + this.codigoOtrosServicios + ", nombreOtrosServicios=" + this.nombreOtrosServicios + ", cantidadOtrosServicios=" + this.cantidadOtrosServicios + ")";
        }
    }

    @Generated
    public ListaCodigoOtrosDto() {
    }

    @Generated
    public static ListaCodigoOtrosDtoBuilder builder() {
        return new ListaCodigoOtrosDtoBuilder();
    }

    @Generated
    public void setCodigoOtrosServicios(String codigoOtrosServicios) {
        this.codigoOtrosServicios = codigoOtrosServicios;
    }

    @Generated
    public void setNombreOtrosServicios(String nombreOtrosServicios) {
        this.nombreOtrosServicios = nombreOtrosServicios;
    }

    @Generated
    public void setCantidadOtrosServicios(String cantidadOtrosServicios) {
        this.cantidadOtrosServicios = cantidadOtrosServicios;
    }

    @Generated
    public String getCodigoOtrosServicios() {
        return this.codigoOtrosServicios;
    }

    @Generated
    public String getNombreOtrosServicios() {
        return this.nombreOtrosServicios;
    }

    @Generated
    public String getCantidadOtrosServicios() {
        return this.cantidadOtrosServicios;
    }
}
