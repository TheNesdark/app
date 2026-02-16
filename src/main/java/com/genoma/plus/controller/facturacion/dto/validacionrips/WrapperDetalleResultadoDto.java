package com.genoma.plus.controller.facturacion.dto.validacionrips;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/WrapperDetalleResultadoDto.class */
public class WrapperDetalleResultadoDto {
    private List<ResultadoValidacionDTO> detalle;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/WrapperDetalleResultadoDto$WrapperDetalleResultadoDtoBuilder.class */
    @Generated
    public static class WrapperDetalleResultadoDtoBuilder {

        @Generated
        private List<ResultadoValidacionDTO> detalle;

        @Generated
        WrapperDetalleResultadoDtoBuilder() {
        }

        @Generated
        public WrapperDetalleResultadoDtoBuilder detalle(List<ResultadoValidacionDTO> detalle) {
            this.detalle = detalle;
            return this;
        }

        @Generated
        public WrapperDetalleResultadoDto build() {
            return new WrapperDetalleResultadoDto(this.detalle);
        }

        @Generated
        public String toString() {
            return "WrapperDetalleResultadoDto.WrapperDetalleResultadoDtoBuilder(detalle=" + this.detalle + ")";
        }
    }

    @Generated
    public void setDetalle(List<ResultadoValidacionDTO> detalle) {
        this.detalle = detalle;
    }

    @Generated
    public static WrapperDetalleResultadoDtoBuilder builder() {
        return new WrapperDetalleResultadoDtoBuilder();
    }

    @Generated
    public WrapperDetalleResultadoDto(List<ResultadoValidacionDTO> detalle) {
        this.detalle = detalle;
    }

    @Generated
    public WrapperDetalleResultadoDto() {
    }

    @Generated
    public List<ResultadoValidacionDTO> getDetalle() {
        return this.detalle;
    }
}
