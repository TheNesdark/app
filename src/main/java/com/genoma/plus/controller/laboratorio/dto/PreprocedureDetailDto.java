package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/PreprocedureDetailDto.class */
public class PreprocedureDetailDto {
    private String IdServicio;
    private String Servicio;
    private double ValorServicio;

    @Generated
    public void setIdServicio(String IdServicio) {
        this.IdServicio = IdServicio;
    }

    @Generated
    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    @Generated
    public void setValorServicio(double ValorServicio) {
        this.ValorServicio = ValorServicio;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PreprocedureDetailDto)) {
            return false;
        }
        PreprocedureDetailDto other = (PreprocedureDetailDto) o;
        if (!other.canEqual(this) || Double.compare(getValorServicio(), other.getValorServicio()) != 0) {
            return false;
        }
        Object this$IdServicio = getIdServicio();
        Object other$IdServicio = other.getIdServicio();
        if (this$IdServicio == null) {
            if (other$IdServicio != null) {
                return false;
            }
        } else if (!this$IdServicio.equals(other$IdServicio)) {
            return false;
        }
        Object this$Servicio = getServicio();
        Object other$Servicio = other.getServicio();
        return this$Servicio == null ? other$Servicio == null : this$Servicio.equals(other$Servicio);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PreprocedureDetailDto;
    }

    @Generated
    public int hashCode() {
        long $ValorServicio = Double.doubleToLongBits(getValorServicio());
        int result = (1 * 59) + ((int) (($ValorServicio >>> 32) ^ $ValorServicio));
        Object $IdServicio = getIdServicio();
        int result2 = (result * 59) + ($IdServicio == null ? 43 : $IdServicio.hashCode());
        Object $Servicio = getServicio();
        return (result2 * 59) + ($Servicio == null ? 43 : $Servicio.hashCode());
    }

    @Generated
    public String toString() {
        return "PreprocedureDetailDto(IdServicio=" + getIdServicio() + ", Servicio=" + getServicio() + ", ValorServicio=" + getValorServicio() + ")";
    }

    @Generated
    public PreprocedureDetailDto(String IdServicio, String Servicio, double ValorServicio) {
        this.IdServicio = IdServicio;
        this.Servicio = Servicio;
        this.ValorServicio = ValorServicio;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/PreprocedureDetailDto$PreprocedureDetailDtoBuilder.class */
    @Generated
    public static class PreprocedureDetailDtoBuilder {

        @Generated
        private String IdServicio;

        @Generated
        private String Servicio;

        @Generated
        private double ValorServicio;

        @Generated
        PreprocedureDetailDtoBuilder() {
        }

        @Generated
        public PreprocedureDetailDtoBuilder IdServicio(String IdServicio) {
            this.IdServicio = IdServicio;
            return this;
        }

        @Generated
        public PreprocedureDetailDtoBuilder Servicio(String Servicio) {
            this.Servicio = Servicio;
            return this;
        }

        @Generated
        public PreprocedureDetailDtoBuilder ValorServicio(double ValorServicio) {
            this.ValorServicio = ValorServicio;
            return this;
        }

        @Generated
        public PreprocedureDetailDto build() {
            return new PreprocedureDetailDto(this.IdServicio, this.Servicio, this.ValorServicio);
        }

        @Generated
        public String toString() {
            return "PreprocedureDetailDto.PreprocedureDetailDtoBuilder(IdServicio=" + this.IdServicio + ", Servicio=" + this.Servicio + ", ValorServicio=" + this.ValorServicio + ")";
        }
    }

    @Generated
    public PreprocedureDetailDto() {
    }

    @Generated
    public static PreprocedureDetailDtoBuilder builder() {
        return new PreprocedureDetailDtoBuilder();
    }

    @Generated
    public String getIdServicio() {
        return this.IdServicio;
    }

    @Generated
    public String getServicio() {
        return this.Servicio;
    }

    @Generated
    public double getValorServicio() {
        return this.ValorServicio;
    }
}
