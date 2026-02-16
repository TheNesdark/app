package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCumDetalleDto.class */
public class ListaCumDetalleDto {
    private String codigoImuCum;
    private String nombreImuCum;
    private String cantidadRequeridaImuCum;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListaCumDetalleDto)) {
            return false;
        }
        ListaCumDetalleDto other = (ListaCumDetalleDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$codigoImuCum = getCodigoImuCum();
        Object other$codigoImuCum = other.getCodigoImuCum();
        if (this$codigoImuCum == null) {
            if (other$codigoImuCum != null) {
                return false;
            }
        } else if (!this$codigoImuCum.equals(other$codigoImuCum)) {
            return false;
        }
        Object this$nombreImuCum = getNombreImuCum();
        Object other$nombreImuCum = other.getNombreImuCum();
        if (this$nombreImuCum == null) {
            if (other$nombreImuCum != null) {
                return false;
            }
        } else if (!this$nombreImuCum.equals(other$nombreImuCum)) {
            return false;
        }
        Object this$cantidadRequeridaImuCum = getCantidadRequeridaImuCum();
        Object other$cantidadRequeridaImuCum = other.getCantidadRequeridaImuCum();
        return this$cantidadRequeridaImuCum == null ? other$cantidadRequeridaImuCum == null : this$cantidadRequeridaImuCum.equals(other$cantidadRequeridaImuCum);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListaCumDetalleDto;
    }

    @Generated
    public int hashCode() {
        Object $codigoImuCum = getCodigoImuCum();
        int result = (1 * 59) + ($codigoImuCum == null ? 43 : $codigoImuCum.hashCode());
        Object $nombreImuCum = getNombreImuCum();
        int result2 = (result * 59) + ($nombreImuCum == null ? 43 : $nombreImuCum.hashCode());
        Object $cantidadRequeridaImuCum = getCantidadRequeridaImuCum();
        return (result2 * 59) + ($cantidadRequeridaImuCum == null ? 43 : $cantidadRequeridaImuCum.hashCode());
    }

    @Generated
    public String toString() {
        return "ListaCumDetalleDto(codigoImuCum=" + getCodigoImuCum() + ", nombreImuCum=" + getNombreImuCum() + ", cantidadRequeridaImuCum=" + getCantidadRequeridaImuCum() + ")";
    }

    @Generated
    public ListaCumDetalleDto(String codigoImuCum, String nombreImuCum, String cantidadRequeridaImuCum) {
        this.codigoImuCum = codigoImuCum;
        this.nombreImuCum = nombreImuCum;
        this.cantidadRequeridaImuCum = cantidadRequeridaImuCum;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCumDetalleDto$ListaCumDetalleDtoBuilder.class */
    @Generated
    public static class ListaCumDetalleDtoBuilder {

        @Generated
        private String codigoImuCum;

        @Generated
        private String nombreImuCum;

        @Generated
        private String cantidadRequeridaImuCum;

        @Generated
        ListaCumDetalleDtoBuilder() {
        }

        @Generated
        public ListaCumDetalleDtoBuilder codigoImuCum(String codigoImuCum) {
            this.codigoImuCum = codigoImuCum;
            return this;
        }

        @Generated
        public ListaCumDetalleDtoBuilder nombreImuCum(String nombreImuCum) {
            this.nombreImuCum = nombreImuCum;
            return this;
        }

        @Generated
        public ListaCumDetalleDtoBuilder cantidadRequeridaImuCum(String cantidadRequeridaImuCum) {
            this.cantidadRequeridaImuCum = cantidadRequeridaImuCum;
            return this;
        }

        @Generated
        public ListaCumDetalleDto build() {
            return new ListaCumDetalleDto(this.codigoImuCum, this.nombreImuCum, this.cantidadRequeridaImuCum);
        }

        @Generated
        public String toString() {
            return "ListaCumDetalleDto.ListaCumDetalleDtoBuilder(codigoImuCum=" + this.codigoImuCum + ", nombreImuCum=" + this.nombreImuCum + ", cantidadRequeridaImuCum=" + this.cantidadRequeridaImuCum + ")";
        }
    }

    @Generated
    public ListaCumDetalleDto() {
    }

    @Generated
    public static ListaCumDetalleDtoBuilder builder() {
        return new ListaCumDetalleDtoBuilder();
    }

    @Generated
    public void setCodigoImuCum(String codigoImuCum) {
        this.codigoImuCum = codigoImuCum;
    }

    @Generated
    public void setNombreImuCum(String nombreImuCum) {
        this.nombreImuCum = nombreImuCum;
    }

    @Generated
    public void setCantidadRequeridaImuCum(String cantidadRequeridaImuCum) {
        this.cantidadRequeridaImuCum = cantidadRequeridaImuCum;
    }

    @Generated
    public String getCodigoImuCum() {
        return this.codigoImuCum;
    }

    @Generated
    public String getNombreImuCum() {
        return this.nombreImuCum;
    }

    @Generated
    public String getCantidadRequeridaImuCum() {
        return this.cantidadRequeridaImuCum;
    }
}
