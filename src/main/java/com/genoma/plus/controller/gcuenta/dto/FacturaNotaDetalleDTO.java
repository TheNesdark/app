package com.genoma.plus.controller.gcuenta.dto;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDetalleDTO.class */
public class FacturaNotaDetalleDTO {
    private Integer id;
    private Integer idFacturaNota;
    private Integer tipo;
    private String idCodigo;
    private Integer cantidad;
    private Double valorNota;
    private String nombreItem;
    private String observacion;
    private Boolean estado;
    private Date fecha;
    private Double valorUnitario;
    private Double porcentajeImpuesto;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDetalleDTO$FacturaNotaDetalleDTOBuilder.class */
    @Generated
    public static class FacturaNotaDetalleDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private Integer idFacturaNota;

        @Generated
        private Integer tipo;

        @Generated
        private String idCodigo;

        @Generated
        private Integer cantidad;

        @Generated
        private Double valorNota;

        @Generated
        private String nombreItem;

        @Generated
        private String observacion;

        @Generated
        private Boolean estado;

        @Generated
        private Date fecha;

        @Generated
        private Double valorUnitario;

        @Generated
        private Double porcentajeImpuesto;

        @Generated
        FacturaNotaDetalleDTOBuilder() {
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder idFacturaNota(Integer idFacturaNota) {
            this.idFacturaNota = idFacturaNota;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder tipo(Integer tipo) {
            this.tipo = tipo;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder idCodigo(String idCodigo) {
            this.idCodigo = idCodigo;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder cantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder valorNota(Double valorNota) {
            this.valorNota = valorNota;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder nombreItem(String nombreItem) {
            this.nombreItem = nombreItem;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder valorUnitario(Double valorUnitario) {
            this.valorUnitario = valorUnitario;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTOBuilder porcentajeImpuesto(Double porcentajeImpuesto) {
            this.porcentajeImpuesto = porcentajeImpuesto;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDTO build() {
            return new FacturaNotaDetalleDTO(this.id, this.idFacturaNota, this.tipo, this.idCodigo, this.cantidad, this.valorNota, this.nombreItem, this.observacion, this.estado, this.fecha, this.valorUnitario, this.porcentajeImpuesto);
        }

        @Generated
        public String toString() {
            return "FacturaNotaDetalleDTO.FacturaNotaDetalleDTOBuilder(id=" + this.id + ", idFacturaNota=" + this.idFacturaNota + ", tipo=" + this.tipo + ", idCodigo=" + this.idCodigo + ", cantidad=" + this.cantidad + ", valorNota=" + this.valorNota + ", nombreItem=" + this.nombreItem + ", observacion=" + this.observacion + ", estado=" + this.estado + ", fecha=" + this.fecha + ", valorUnitario=" + this.valorUnitario + ", porcentajeImpuesto=" + this.porcentajeImpuesto + ")";
        }
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setIdFacturaNota(Integer idFacturaNota) {
        this.idFacturaNota = idFacturaNota;
    }

    @Generated
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Generated
    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    @Generated
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    @Generated
    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Generated
    public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FacturaNotaDetalleDTO)) {
            return false;
        }
        FacturaNotaDetalleDTO other = (FacturaNotaDetalleDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$idFacturaNota = getIdFacturaNota();
        Object other$idFacturaNota = other.getIdFacturaNota();
        if (this$idFacturaNota == null) {
            if (other$idFacturaNota != null) {
                return false;
            }
        } else if (!this$idFacturaNota.equals(other$idFacturaNota)) {
            return false;
        }
        Object this$tipo = getTipo();
        Object other$tipo = other.getTipo();
        if (this$tipo == null) {
            if (other$tipo != null) {
                return false;
            }
        } else if (!this$tipo.equals(other$tipo)) {
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
        Object this$valorNota = getValorNota();
        Object other$valorNota = other.getValorNota();
        if (this$valorNota == null) {
            if (other$valorNota != null) {
                return false;
            }
        } else if (!this$valorNota.equals(other$valorNota)) {
            return false;
        }
        Object this$estado = getEstado();
        Object other$estado = other.getEstado();
        if (this$estado == null) {
            if (other$estado != null) {
                return false;
            }
        } else if (!this$estado.equals(other$estado)) {
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
        Object this$porcentajeImpuesto = getPorcentajeImpuesto();
        Object other$porcentajeImpuesto = other.getPorcentajeImpuesto();
        if (this$porcentajeImpuesto == null) {
            if (other$porcentajeImpuesto != null) {
                return false;
            }
        } else if (!this$porcentajeImpuesto.equals(other$porcentajeImpuesto)) {
            return false;
        }
        Object this$idCodigo = getIdCodigo();
        Object other$idCodigo = other.getIdCodigo();
        if (this$idCodigo == null) {
            if (other$idCodigo != null) {
                return false;
            }
        } else if (!this$idCodigo.equals(other$idCodigo)) {
            return false;
        }
        Object this$nombreItem = getNombreItem();
        Object other$nombreItem = other.getNombreItem();
        if (this$nombreItem == null) {
            if (other$nombreItem != null) {
                return false;
            }
        } else if (!this$nombreItem.equals(other$nombreItem)) {
            return false;
        }
        Object this$observacion = getObservacion();
        Object other$observacion = other.getObservacion();
        if (this$observacion == null) {
            if (other$observacion != null) {
                return false;
            }
        } else if (!this$observacion.equals(other$observacion)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        return this$fecha == null ? other$fecha == null : this$fecha.equals(other$fecha);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof FacturaNotaDetalleDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idFacturaNota = getIdFacturaNota();
        int result2 = (result * 59) + ($idFacturaNota == null ? 43 : $idFacturaNota.hashCode());
        Object $tipo = getTipo();
        int result3 = (result2 * 59) + ($tipo == null ? 43 : $tipo.hashCode());
        Object $cantidad = getCantidad();
        int result4 = (result3 * 59) + ($cantidad == null ? 43 : $cantidad.hashCode());
        Object $valorNota = getValorNota();
        int result5 = (result4 * 59) + ($valorNota == null ? 43 : $valorNota.hashCode());
        Object $estado = getEstado();
        int result6 = (result5 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $valorUnitario = getValorUnitario();
        int result7 = (result6 * 59) + ($valorUnitario == null ? 43 : $valorUnitario.hashCode());
        Object $porcentajeImpuesto = getPorcentajeImpuesto();
        int result8 = (result7 * 59) + ($porcentajeImpuesto == null ? 43 : $porcentajeImpuesto.hashCode());
        Object $idCodigo = getIdCodigo();
        int result9 = (result8 * 59) + ($idCodigo == null ? 43 : $idCodigo.hashCode());
        Object $nombreItem = getNombreItem();
        int result10 = (result9 * 59) + ($nombreItem == null ? 43 : $nombreItem.hashCode());
        Object $observacion = getObservacion();
        int result11 = (result10 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $fecha = getFecha();
        return (result11 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
    }

    @Generated
    public String toString() {
        return "FacturaNotaDetalleDTO(id=" + getId() + ", idFacturaNota=" + getIdFacturaNota() + ", tipo=" + getTipo() + ", idCodigo=" + getIdCodigo() + ", cantidad=" + getCantidad() + ", valorNota=" + getValorNota() + ", nombreItem=" + getNombreItem() + ", observacion=" + getObservacion() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ", valorUnitario=" + getValorUnitario() + ", porcentajeImpuesto=" + getPorcentajeImpuesto() + ")";
    }

    @Generated
    public static FacturaNotaDetalleDTOBuilder builder() {
        return new FacturaNotaDetalleDTOBuilder();
    }

    @Generated
    public FacturaNotaDetalleDTO(Integer id, Integer idFacturaNota, Integer tipo, String idCodigo, Integer cantidad, Double valorNota, String nombreItem, String observacion, Boolean estado, Date fecha, Double valorUnitario, Double porcentajeImpuesto) {
        this.id = id;
        this.idFacturaNota = idFacturaNota;
        this.tipo = tipo;
        this.idCodigo = idCodigo;
        this.cantidad = cantidad;
        this.valorNota = valorNota;
        this.nombreItem = nombreItem;
        this.observacion = observacion;
        this.estado = estado;
        this.fecha = fecha;
        this.valorUnitario = valorUnitario;
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    @Generated
    public FacturaNotaDetalleDTO() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public Integer getIdFacturaNota() {
        return this.idFacturaNota;
    }

    @Generated
    public Integer getTipo() {
        return this.tipo;
    }

    @Generated
    public String getIdCodigo() {
        return this.idCodigo;
    }

    @Generated
    public Integer getCantidad() {
        return this.cantidad;
    }

    @Generated
    public Double getValorNota() {
        return this.valorNota;
    }

    @Generated
    public String getNombreItem() {
        return this.nombreItem;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public Double getValorUnitario() {
        return this.valorUnitario;
    }

    @Generated
    public Double getPorcentajeImpuesto() {
        return this.porcentajeImpuesto;
    }
}
