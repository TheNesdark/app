package com.genoma.plus.controller.integracion_simedis.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/ItemsInterfazDto.class */
public class ItemsInterfazDto {
    private String idProcedimiento;
    private String idTipofinProc;
    private String cantidad;
    private String valorUnitario;
    private String valorDescuento;
    private String porcentajeImpuesto;
    private String valorImpuesto;

    @Generated
    public void setIdProcedimiento(String idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Generated
    public void setIdTipofinProc(String idTipofinProc) {
        this.idTipofinProc = idTipofinProc;
    }

    @Generated
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Generated
    public void setValorDescuento(String valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    @Generated
    public void setPorcentajeImpuesto(String porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    @Generated
    public void setValorImpuesto(String valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ItemsInterfazDto)) {
            return false;
        }
        ItemsInterfazDto other = (ItemsInterfazDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idProcedimiento = getIdProcedimiento();
        Object other$idProcedimiento = other.getIdProcedimiento();
        if (this$idProcedimiento == null) {
            if (other$idProcedimiento != null) {
                return false;
            }
        } else if (!this$idProcedimiento.equals(other$idProcedimiento)) {
            return false;
        }
        Object this$idTipofinProc = getIdTipofinProc();
        Object other$idTipofinProc = other.getIdTipofinProc();
        if (this$idTipofinProc == null) {
            if (other$idTipofinProc != null) {
                return false;
            }
        } else if (!this$idTipofinProc.equals(other$idTipofinProc)) {
            return false;
        }
        Object this$cantidad = getCantidad();
        Object other$cantidad = other.getCantidad();
        if (this$cantidad == null) {
            if (other$cantidad != null) {
                return false;
            }
        } else if (!this$cantidad.equals(other$cantidad)) {
            return false;
        }
        Object this$valorUnitario = getValorUnitario();
        Object other$valorUnitario = other.getValorUnitario();
        if (this$valorUnitario == null) {
            if (other$valorUnitario != null) {
                return false;
            }
        } else if (!this$valorUnitario.equals(other$valorUnitario)) {
            return false;
        }
        Object this$valorDescuento = getValorDescuento();
        Object other$valorDescuento = other.getValorDescuento();
        if (this$valorDescuento == null) {
            if (other$valorDescuento != null) {
                return false;
            }
        } else if (!this$valorDescuento.equals(other$valorDescuento)) {
            return false;
        }
        Object this$porcentajeImpuesto = getPorcentajeImpuesto();
        Object other$porcentajeImpuesto = other.getPorcentajeImpuesto();
        if (this$porcentajeImpuesto == null) {
            if (other$porcentajeImpuesto != null) {
                return false;
            }
        } else if (!this$porcentajeImpuesto.equals(other$porcentajeImpuesto)) {
            return false;
        }
        Object this$valorImpuesto = getValorImpuesto();
        Object other$valorImpuesto = other.getValorImpuesto();
        return this$valorImpuesto == null ? other$valorImpuesto == null : this$valorImpuesto.equals(other$valorImpuesto);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ItemsInterfazDto;
    }

    @Generated
    public int hashCode() {
        Object $idProcedimiento = getIdProcedimiento();
        int result = (1 * 59) + ($idProcedimiento == null ? 43 : $idProcedimiento.hashCode());
        Object $idTipofinProc = getIdTipofinProc();
        int result2 = (result * 59) + ($idTipofinProc == null ? 43 : $idTipofinProc.hashCode());
        Object $cantidad = getCantidad();
        int result3 = (result2 * 59) + ($cantidad == null ? 43 : $cantidad.hashCode());
        Object $valorUnitario = getValorUnitario();
        int result4 = (result3 * 59) + ($valorUnitario == null ? 43 : $valorUnitario.hashCode());
        Object $valorDescuento = getValorDescuento();
        int result5 = (result4 * 59) + ($valorDescuento == null ? 43 : $valorDescuento.hashCode());
        Object $porcentajeImpuesto = getPorcentajeImpuesto();
        int result6 = (result5 * 59) + ($porcentajeImpuesto == null ? 43 : $porcentajeImpuesto.hashCode());
        Object $valorImpuesto = getValorImpuesto();
        return (result6 * 59) + ($valorImpuesto == null ? 43 : $valorImpuesto.hashCode());
    }

    @Generated
    public String toString() {
        return "ItemsInterfazDto(idProcedimiento=" + getIdProcedimiento() + ", idTipofinProc=" + getIdTipofinProc() + ", cantidad=" + getCantidad() + ", valorUnitario=" + getValorUnitario() + ", valorDescuento=" + getValorDescuento() + ", porcentajeImpuesto=" + getPorcentajeImpuesto() + ", valorImpuesto=" + getValorImpuesto() + ")";
    }

    @Generated
    public ItemsInterfazDto(String idProcedimiento, String idTipofinProc, String cantidad, String valorUnitario, String valorDescuento, String porcentajeImpuesto, String valorImpuesto) {
        this.idProcedimiento = idProcedimiento;
        this.idTipofinProc = idTipofinProc;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorDescuento = valorDescuento;
        this.porcentajeImpuesto = porcentajeImpuesto;
        this.valorImpuesto = valorImpuesto;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/ItemsInterfazDto$ItemsInterfazDtoBuilder.class */
    @Generated
    public static class ItemsInterfazDtoBuilder {

        @Generated
        private String idProcedimiento;

        @Generated
        private String idTipofinProc;

        @Generated
        private String cantidad;

        @Generated
        private String valorUnitario;

        @Generated
        private String valorDescuento;

        @Generated
        private String porcentajeImpuesto;

        @Generated
        private String valorImpuesto;

        @Generated
        ItemsInterfazDtoBuilder() {
        }

        @Generated
        public ItemsInterfazDtoBuilder idProcedimiento(String idProcedimiento) {
            this.idProcedimiento = idProcedimiento;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder idTipofinProc(String idTipofinProc) {
            this.idTipofinProc = idTipofinProc;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder cantidad(String cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder valorUnitario(String valorUnitario) {
            this.valorUnitario = valorUnitario;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder valorDescuento(String valorDescuento) {
            this.valorDescuento = valorDescuento;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder porcentajeImpuesto(String porcentajeImpuesto) {
            this.porcentajeImpuesto = porcentajeImpuesto;
            return this;
        }

        @Generated
        public ItemsInterfazDtoBuilder valorImpuesto(String valorImpuesto) {
            this.valorImpuesto = valorImpuesto;
            return this;
        }

        @Generated
        public ItemsInterfazDto build() {
            return new ItemsInterfazDto(this.idProcedimiento, this.idTipofinProc, this.cantidad, this.valorUnitario, this.valorDescuento, this.porcentajeImpuesto, this.valorImpuesto);
        }

        @Generated
        public String toString() {
            return "ItemsInterfazDto.ItemsInterfazDtoBuilder(idProcedimiento=" + this.idProcedimiento + ", idTipofinProc=" + this.idTipofinProc + ", cantidad=" + this.cantidad + ", valorUnitario=" + this.valorUnitario + ", valorDescuento=" + this.valorDescuento + ", porcentajeImpuesto=" + this.porcentajeImpuesto + ", valorImpuesto=" + this.valorImpuesto + ")";
        }
    }

    @Generated
    public ItemsInterfazDto() {
    }

    @Generated
    public static ItemsInterfazDtoBuilder builder() {
        return new ItemsInterfazDtoBuilder();
    }

    @Generated
    public String getIdProcedimiento() {
        return this.idProcedimiento;
    }

    @Generated
    public String getIdTipofinProc() {
        return this.idTipofinProc;
    }

    @Generated
    public String getCantidad() {
        return this.cantidad;
    }

    @Generated
    public String getValorUnitario() {
        return this.valorUnitario;
    }

    @Generated
    public String getValorDescuento() {
        return this.valorDescuento;
    }

    @Generated
    public String getPorcentajeImpuesto() {
        return this.porcentajeImpuesto;
    }

    @Generated
    public String getValorImpuesto() {
        return this.valorImpuesto;
    }
}
