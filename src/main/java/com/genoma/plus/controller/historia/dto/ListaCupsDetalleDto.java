package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCupsDetalleDto.class */
public class ListaCupsDetalleDto {
    private String codigoCups;
    private String nombreCups;
    private String cantidadRequerida;
    private String finalidadTecnologia;
    private String codigoServicio;
    private String grupoServicios;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListaCupsDetalleDto)) {
            return false;
        }
        ListaCupsDetalleDto other = (ListaCupsDetalleDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$codigoCups = getCodigoCups();
        Object other$codigoCups = other.getCodigoCups();
        if (this$codigoCups == null) {
            if (other$codigoCups != null) {
                return false;
            }
        } else if (!this$codigoCups.equals(other$codigoCups)) {
            return false;
        }
        Object this$nombreCups = getNombreCups();
        Object other$nombreCups = other.getNombreCups();
        if (this$nombreCups == null) {
            if (other$nombreCups != null) {
                return false;
            }
        } else if (!this$nombreCups.equals(other$nombreCups)) {
            return false;
        }
        Object this$cantidadRequerida = getCantidadRequerida();
        Object other$cantidadRequerida = other.getCantidadRequerida();
        if (this$cantidadRequerida == null) {
            if (other$cantidadRequerida != null) {
                return false;
            }
        } else if (!this$cantidadRequerida.equals(other$cantidadRequerida)) {
            return false;
        }
        Object this$finalidadTecnologia = getFinalidadTecnologia();
        Object other$finalidadTecnologia = other.getFinalidadTecnologia();
        if (this$finalidadTecnologia == null) {
            if (other$finalidadTecnologia != null) {
                return false;
            }
        } else if (!this$finalidadTecnologia.equals(other$finalidadTecnologia)) {
            return false;
        }
        Object this$codigoServicio = getCodigoServicio();
        Object other$codigoServicio = other.getCodigoServicio();
        if (this$codigoServicio == null) {
            if (other$codigoServicio != null) {
                return false;
            }
        } else if (!this$codigoServicio.equals(other$codigoServicio)) {
            return false;
        }
        Object this$grupoServicios = getGrupoServicios();
        Object other$grupoServicios = other.getGrupoServicios();
        return this$grupoServicios == null ? other$grupoServicios == null : this$grupoServicios.equals(other$grupoServicios);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListaCupsDetalleDto;
    }

    @Generated
    public int hashCode() {
        Object $codigoCups = getCodigoCups();
        int result = (1 * 59) + ($codigoCups == null ? 43 : $codigoCups.hashCode());
        Object $nombreCups = getNombreCups();
        int result2 = (result * 59) + ($nombreCups == null ? 43 : $nombreCups.hashCode());
        Object $cantidadRequerida = getCantidadRequerida();
        int result3 = (result2 * 59) + ($cantidadRequerida == null ? 43 : $cantidadRequerida.hashCode());
        Object $finalidadTecnologia = getFinalidadTecnologia();
        int result4 = (result3 * 59) + ($finalidadTecnologia == null ? 43 : $finalidadTecnologia.hashCode());
        Object $codigoServicio = getCodigoServicio();
        int result5 = (result4 * 59) + ($codigoServicio == null ? 43 : $codigoServicio.hashCode());
        Object $grupoServicios = getGrupoServicios();
        return (result5 * 59) + ($grupoServicios == null ? 43 : $grupoServicios.hashCode());
    }

    @Generated
    public String toString() {
        return "ListaCupsDetalleDto(codigoCups=" + getCodigoCups() + ", nombreCups=" + getNombreCups() + ", cantidadRequerida=" + getCantidadRequerida() + ", finalidadTecnologia=" + getFinalidadTecnologia() + ", codigoServicio=" + getCodigoServicio() + ", grupoServicios=" + getGrupoServicios() + ")";
    }

    @Generated
    public ListaCupsDetalleDto(String codigoCups, String nombreCups, String cantidadRequerida, String finalidadTecnologia, String codigoServicio, String grupoServicios) {
        this.codigoCups = codigoCups;
        this.nombreCups = nombreCups;
        this.cantidadRequerida = cantidadRequerida;
        this.finalidadTecnologia = finalidadTecnologia;
        this.codigoServicio = codigoServicio;
        this.grupoServicios = grupoServicios;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/ListaCupsDetalleDto$ListaCupsDetalleDtoBuilder.class */
    @Generated
    public static class ListaCupsDetalleDtoBuilder {

        @Generated
        private String codigoCups;

        @Generated
        private String nombreCups;

        @Generated
        private String cantidadRequerida;

        @Generated
        private String finalidadTecnologia;

        @Generated
        private String codigoServicio;

        @Generated
        private String grupoServicios;

        @Generated
        ListaCupsDetalleDtoBuilder() {
        }

        @Generated
        public ListaCupsDetalleDtoBuilder codigoCups(String codigoCups) {
            this.codigoCups = codigoCups;
            return this;
        }

        @Generated
        public ListaCupsDetalleDtoBuilder nombreCups(String nombreCups) {
            this.nombreCups = nombreCups;
            return this;
        }

        @Generated
        public ListaCupsDetalleDtoBuilder cantidadRequerida(String cantidadRequerida) {
            this.cantidadRequerida = cantidadRequerida;
            return this;
        }

        @Generated
        public ListaCupsDetalleDtoBuilder finalidadTecnologia(String finalidadTecnologia) {
            this.finalidadTecnologia = finalidadTecnologia;
            return this;
        }

        @Generated
        public ListaCupsDetalleDtoBuilder codigoServicio(String codigoServicio) {
            this.codigoServicio = codigoServicio;
            return this;
        }

        @Generated
        public ListaCupsDetalleDtoBuilder grupoServicios(String grupoServicios) {
            this.grupoServicios = grupoServicios;
            return this;
        }

        @Generated
        public ListaCupsDetalleDto build() {
            return new ListaCupsDetalleDto(this.codigoCups, this.nombreCups, this.cantidadRequerida, this.finalidadTecnologia, this.codigoServicio, this.grupoServicios);
        }

        @Generated
        public String toString() {
            return "ListaCupsDetalleDto.ListaCupsDetalleDtoBuilder(codigoCups=" + this.codigoCups + ", nombreCups=" + this.nombreCups + ", cantidadRequerida=" + this.cantidadRequerida + ", finalidadTecnologia=" + this.finalidadTecnologia + ", codigoServicio=" + this.codigoServicio + ", grupoServicios=" + this.grupoServicios + ")";
        }
    }

    @Generated
    public ListaCupsDetalleDto() {
    }

    @Generated
    public static ListaCupsDetalleDtoBuilder builder() {
        return new ListaCupsDetalleDtoBuilder();
    }

    @Generated
    public void setCodigoCups(String codigoCups) {
        this.codigoCups = codigoCups;
    }

    @Generated
    public void setNombreCups(String nombreCups) {
        this.nombreCups = nombreCups;
    }

    @Generated
    public void setCantidadRequerida(String cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    @Generated
    public void setFinalidadTecnologia(String finalidadTecnologia) {
        this.finalidadTecnologia = finalidadTecnologia;
    }

    @Generated
    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    @Generated
    public void setGrupoServicios(String grupoServicios) {
        this.grupoServicios = grupoServicios;
    }

    @Generated
    public String getCodigoCups() {
        return this.codigoCups;
    }

    @Generated
    public String getNombreCups() {
        return this.nombreCups;
    }

    @Generated
    public String getCantidadRequerida() {
        return this.cantidadRequerida;
    }

    @Generated
    public String getFinalidadTecnologia() {
        return this.finalidadTecnologia;
    }

    @Generated
    public String getCodigoServicio() {
        return this.codigoServicio;
    }

    @Generated
    public String getGrupoServicios() {
        return this.grupoServicios;
    }
}
