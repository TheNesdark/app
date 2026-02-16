package com.genoma.plus.controller.gcuenta;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/ParametrosFacturaElectronica.class */
public class ParametrosFacturaElectronica {
    private String numeroFactura;
    private Integer forma;
    private Boolean reenviado;
    private List<Adjunto> adjunto;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/ParametrosFacturaElectronica$ParametrosFacturaElectronicaBuilder.class */
    @Generated
    public static class ParametrosFacturaElectronicaBuilder {

        @Generated
        private String numeroFactura;

        @Generated
        private Integer forma;

        @Generated
        private Boolean reenviado;

        @Generated
        private List<Adjunto> adjunto;

        @Generated
        ParametrosFacturaElectronicaBuilder() {
        }

        @Generated
        public ParametrosFacturaElectronicaBuilder numeroFactura(String numeroFactura) {
            this.numeroFactura = numeroFactura;
            return this;
        }

        @Generated
        public ParametrosFacturaElectronicaBuilder forma(Integer forma) {
            this.forma = forma;
            return this;
        }

        @Generated
        public ParametrosFacturaElectronicaBuilder reenviado(Boolean reenviado) {
            this.reenviado = reenviado;
            return this;
        }

        @Generated
        public ParametrosFacturaElectronicaBuilder adjunto(List<Adjunto> adjunto) {
            this.adjunto = adjunto;
            return this;
        }

        @Generated
        public ParametrosFacturaElectronica build() {
            return new ParametrosFacturaElectronica(this.numeroFactura, this.forma, this.reenviado, this.adjunto);
        }

        @Generated
        public String toString() {
            return "ParametrosFacturaElectronica.ParametrosFacturaElectronicaBuilder(numeroFactura=" + this.numeroFactura + ", forma=" + this.forma + ", reenviado=" + this.reenviado + ", adjunto=" + this.adjunto + ")";
        }
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParametrosFacturaElectronica)) {
            return false;
        }
        ParametrosFacturaElectronica other = (ParametrosFacturaElectronica) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$forma = getForma();
        Object other$forma = other.getForma();
        if (this$forma == null) {
            if (other$forma != null) {
                return false;
            }
        } else if (!this$forma.equals(other$forma)) {
            return false;
        }
        Object this$reenviado = getReenviado();
        Object other$reenviado = other.getReenviado();
        if (this$reenviado == null) {
            if (other$reenviado != null) {
                return false;
            }
        } else if (!this$reenviado.equals(other$reenviado)) {
            return false;
        }
        Object this$numeroFactura = getNumeroFactura();
        Object other$numeroFactura = other.getNumeroFactura();
        if (this$numeroFactura == null) {
            if (other$numeroFactura != null) {
                return false;
            }
        } else if (!this$numeroFactura.equals(other$numeroFactura)) {
            return false;
        }
        Object this$adjunto = getAdjunto();
        Object other$adjunto = other.getAdjunto();
        return this$adjunto == null ? other$adjunto == null : this$adjunto.equals(other$adjunto);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ParametrosFacturaElectronica;
    }

    @Generated
    public int hashCode() {
        Object $forma = getForma();
        int result = (1 * 59) + ($forma == null ? 43 : $forma.hashCode());
        Object $reenviado = getReenviado();
        int result2 = (result * 59) + ($reenviado == null ? 43 : $reenviado.hashCode());
        Object $numeroFactura = getNumeroFactura();
        int result3 = (result2 * 59) + ($numeroFactura == null ? 43 : $numeroFactura.hashCode());
        Object $adjunto = getAdjunto();
        return (result3 * 59) + ($adjunto == null ? 43 : $adjunto.hashCode());
    }

    @Generated
    public String toString() {
        return "ParametrosFacturaElectronica(numeroFactura=" + getNumeroFactura() + ", forma=" + getForma() + ", reenviado=" + getReenviado() + ", adjunto=" + getAdjunto() + ")";
    }

    @Generated
    public static ParametrosFacturaElectronicaBuilder builder() {
        return new ParametrosFacturaElectronicaBuilder();
    }

    @Generated
    public ParametrosFacturaElectronica(String numeroFactura, Integer forma, Boolean reenviado, List<Adjunto> adjunto) {
        this.numeroFactura = numeroFactura;
        this.forma = forma;
        this.reenviado = reenviado;
        this.adjunto = adjunto;
    }

    @Generated
    public ParametrosFacturaElectronica() {
    }

    @Generated
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @Generated
    public void setForma(Integer forma) {
        this.forma = forma;
    }

    @Generated
    public void setReenviado(Boolean reenviado) {
        this.reenviado = reenviado;
    }

    @Generated
    public void setAdjunto(List<Adjunto> adjunto) {
        this.adjunto = adjunto;
    }

    @Generated
    public String getNumeroFactura() {
        return this.numeroFactura;
    }

    @Generated
    public Integer getForma() {
        return this.forma;
    }

    @Generated
    public Boolean getReenviado() {
        return this.reenviado;
    }

    @Generated
    public List<Adjunto> getAdjunto() {
        return this.adjunto;
    }
}
