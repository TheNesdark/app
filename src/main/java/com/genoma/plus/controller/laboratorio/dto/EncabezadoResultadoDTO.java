package com.genoma.plus.controller.laboratorio.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/EncabezadoResultadoDTO.class */
public class EncabezadoResultadoDTO {
    private List<ResultadoDTO> detallesEncabezadoResultado;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EncabezadoResultadoDTO)) {
            return false;
        }
        EncabezadoResultadoDTO other = (EncabezadoResultadoDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$detallesEncabezadoResultado = getDetallesEncabezadoResultado();
        Object other$detallesEncabezadoResultado = other.getDetallesEncabezadoResultado();
        return this$detallesEncabezadoResultado == null ? other$detallesEncabezadoResultado == null : this$detallesEncabezadoResultado.equals(other$detallesEncabezadoResultado);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof EncabezadoResultadoDTO;
    }

    @Generated
    public int hashCode() {
        Object $detallesEncabezadoResultado = getDetallesEncabezadoResultado();
        int result = (1 * 59) + ($detallesEncabezadoResultado == null ? 43 : $detallesEncabezadoResultado.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "EncabezadoResultadoDTO(detallesEncabezadoResultado=" + getDetallesEncabezadoResultado() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/EncabezadoResultadoDTO$EncabezadoResultadoDTOBuilder.class */
    @Generated
    public static class EncabezadoResultadoDTOBuilder {

        @Generated
        private List<ResultadoDTO> detallesEncabezadoResultado;

        @Generated
        EncabezadoResultadoDTOBuilder() {
        }

        @Generated
        public EncabezadoResultadoDTOBuilder detallesEncabezadoResultado(List<ResultadoDTO> detallesEncabezadoResultado) {
            this.detallesEncabezadoResultado = detallesEncabezadoResultado;
            return this;
        }

        @Generated
        public EncabezadoResultadoDTO build() {
            return new EncabezadoResultadoDTO(this.detallesEncabezadoResultado);
        }

        @Generated
        public String toString() {
            return "EncabezadoResultadoDTO.EncabezadoResultadoDTOBuilder(detallesEncabezadoResultado=" + this.detallesEncabezadoResultado + ")";
        }
    }

    @Generated
    public void setDetallesEncabezadoResultado(List<ResultadoDTO> detallesEncabezadoResultado) {
        this.detallesEncabezadoResultado = detallesEncabezadoResultado;
    }

    @Generated
    public static EncabezadoResultadoDTOBuilder builder() {
        return new EncabezadoResultadoDTOBuilder();
    }

    @Generated
    public EncabezadoResultadoDTO(List<ResultadoDTO> detallesEncabezadoResultado) {
        this.detallesEncabezadoResultado = detallesEncabezadoResultado;
    }

    @Generated
    public EncabezadoResultadoDTO() {
    }

    @Generated
    public List<ResultadoDTO> getDetallesEncabezadoResultado() {
        return this.detallesEncabezadoResultado;
    }
}
