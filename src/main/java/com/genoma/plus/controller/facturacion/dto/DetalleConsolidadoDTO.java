package com.genoma.plus.controller.facturacion.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/DetalleConsolidadoDTO.class */
public class DetalleConsolidadoDTO {
    private Integer idIngreso;
    private Integer IdTipoServicio;
    private String nombre;
    private Double valor;
    private Double valorPlan;
    private Double valorNoPlan;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/DetalleConsolidadoDTO$DetalleConsolidadoDTOBuilder.class */
    @Generated
    public static class DetalleConsolidadoDTOBuilder {

        @Generated
        private Integer idIngreso;

        @Generated
        private Integer IdTipoServicio;

        @Generated
        private String nombre;

        @Generated
        private Double valor;

        @Generated
        private Double valorPlan;

        @Generated
        private Double valorNoPlan;

        @Generated
        DetalleConsolidadoDTOBuilder() {
        }

        @Generated
        public DetalleConsolidadoDTOBuilder idIngreso(Integer idIngreso) {
            this.idIngreso = idIngreso;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTOBuilder IdTipoServicio(Integer IdTipoServicio) {
            this.IdTipoServicio = IdTipoServicio;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTOBuilder valor(Double valor) {
            this.valor = valor;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTOBuilder valorPlan(Double valorPlan) {
            this.valorPlan = valorPlan;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTOBuilder valorNoPlan(Double valorNoPlan) {
            this.valorNoPlan = valorNoPlan;
            return this;
        }

        @Generated
        public DetalleConsolidadoDTO build() {
            return new DetalleConsolidadoDTO(this.idIngreso, this.IdTipoServicio, this.nombre, this.valor, this.valorPlan, this.valorNoPlan);
        }

        @Generated
        public String toString() {
            return "DetalleConsolidadoDTO.DetalleConsolidadoDTOBuilder(idIngreso=" + this.idIngreso + ", IdTipoServicio=" + this.IdTipoServicio + ", nombre=" + this.nombre + ", valor=" + this.valor + ", valorPlan=" + this.valorPlan + ", valorNoPlan=" + this.valorNoPlan + ")";
        }
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DetalleConsolidadoDTO)) {
            return false;
        }
        DetalleConsolidadoDTO other = (DetalleConsolidadoDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idIngreso = getIdIngreso();
        Object other$idIngreso = other.getIdIngreso();
        if (this$idIngreso == null) {
            if (other$idIngreso != null) {
                return false;
            }
        } else if (!this$idIngreso.equals(other$idIngreso)) {
            return false;
        }
        Object this$IdTipoServicio = getIdTipoServicio();
        Object other$IdTipoServicio = other.getIdTipoServicio();
        if (this$IdTipoServicio == null) {
            if (other$IdTipoServicio != null) {
                return false;
            }
        } else if (!this$IdTipoServicio.equals(other$IdTipoServicio)) {
            return false;
        }
        Object this$valor = getValor();
        Object other$valor = other.getValor();
        if (this$valor == null) {
            if (other$valor != null) {
                return false;
            }
        } else if (!this$valor.equals(other$valor)) {
            return false;
        }
        Object this$valorPlan = getValorPlan();
        Object other$valorPlan = other.getValorPlan();
        if (this$valorPlan == null) {
            if (other$valorPlan != null) {
                return false;
            }
        } else if (!this$valorPlan.equals(other$valorPlan)) {
            return false;
        }
        Object this$valorNoPlan = getValorNoPlan();
        Object other$valorNoPlan = other.getValorNoPlan();
        if (this$valorNoPlan == null) {
            if (other$valorNoPlan != null) {
                return false;
            }
        } else if (!this$valorNoPlan.equals(other$valorNoPlan)) {
            return false;
        }
        Object this$nombre = getNombre();
        Object other$nombre = other.getNombre();
        return this$nombre == null ? other$nombre == null : this$nombre.equals(other$nombre);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DetalleConsolidadoDTO;
    }

    @Generated
    public int hashCode() {
        Object $idIngreso = getIdIngreso();
        int result = (1 * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $IdTipoServicio = getIdTipoServicio();
        int result2 = (result * 59) + ($IdTipoServicio == null ? 43 : $IdTipoServicio.hashCode());
        Object $valor = getValor();
        int result3 = (result2 * 59) + ($valor == null ? 43 : $valor.hashCode());
        Object $valorPlan = getValorPlan();
        int result4 = (result3 * 59) + ($valorPlan == null ? 43 : $valorPlan.hashCode());
        Object $valorNoPlan = getValorNoPlan();
        int result5 = (result4 * 59) + ($valorNoPlan == null ? 43 : $valorNoPlan.hashCode());
        Object $nombre = getNombre();
        return (result5 * 59) + ($nombre == null ? 43 : $nombre.hashCode());
    }

    @Generated
    public String toString() {
        return "DetalleConsolidadoDTO(idIngreso=" + getIdIngreso() + ", IdTipoServicio=" + getIdTipoServicio() + ", nombre=" + getNombre() + ", valor=" + getValor() + ", valorPlan=" + getValorPlan() + ", valorNoPlan=" + getValorNoPlan() + ")";
    }

    @Generated
    public static DetalleConsolidadoDTOBuilder builder() {
        return new DetalleConsolidadoDTOBuilder();
    }

    @Generated
    public DetalleConsolidadoDTO(Integer idIngreso, Integer IdTipoServicio, String nombre, Double valor, Double valorPlan, Double valorNoPlan) {
        this.idIngreso = idIngreso;
        this.IdTipoServicio = IdTipoServicio;
        this.nombre = nombre;
        this.valor = valor;
        this.valorPlan = valorPlan;
        this.valorNoPlan = valorNoPlan;
    }

    @Generated
    public DetalleConsolidadoDTO() {
    }

    @Generated
    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setIdTipoServicio(Integer IdTipoServicio) {
        this.IdTipoServicio = IdTipoServicio;
    }

    @Generated
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Generated
    public void setValorPlan(Double valorPlan) {
        this.valorPlan = valorPlan;
    }

    @Generated
    public void setValorNoPlan(Double valorNoPlan) {
        this.valorNoPlan = valorNoPlan;
    }

    @Generated
    public Integer getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public Integer getIdTipoServicio() {
        return this.IdTipoServicio;
    }

    @Generated
    public String getNombre() {
        return this.nombre;
    }

    @Generated
    public Double getValor() {
        return this.valor;
    }

    @Generated
    public Double getValorPlan() {
        return this.valorPlan;
    }

    @Generated
    public Double getValorNoPlan() {
        return this.valorNoPlan;
    }
}
