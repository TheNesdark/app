package com.genoma.plus.controller.gcuenta.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDetalleDescDTO.class */
public class FacturaNotaDetalleDescDTO {
    private Integer idLiquidacion;
    private Integer idIngresoItems;
    private Integer id_Orden;
    private String codigo;
    private String nombreServicio;
    private String nombreItems;
    private Integer cantidad;
    private Double ValorUnitario;
    private Double valorFacturado;
    private Double porcentajeImpuesto;
    private String idProcediminetos;
    private Integer EsCapitado;
    private Integer cantidadNotas;
    private Double valorNota;
    private Double valorConDescuentoNota;
    private Integer tipoItems;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDetalleDescDTO$FacturaNotaDetalleDescDTOBuilder.class */
    @Generated
    public static class FacturaNotaDetalleDescDTOBuilder {

        @Generated
        private Integer idLiquidacion;

        @Generated
        private Integer idIngresoItems;

        @Generated
        private Integer id_Orden;

        @Generated
        private String codigo;

        @Generated
        private String nombreServicio;

        @Generated
        private String nombreItems;

        @Generated
        private Integer cantidad;

        @Generated
        private Double ValorUnitario;

        @Generated
        private Double valorFacturado;

        @Generated
        private Double porcentajeImpuesto;

        @Generated
        private String idProcediminetos;

        @Generated
        private Integer EsCapitado;

        @Generated
        private Integer cantidadNotas;

        @Generated
        private Double valorNota;

        @Generated
        private Double valorConDescuentoNota;

        @Generated
        private Integer tipoItems;

        @Generated
        FacturaNotaDetalleDescDTOBuilder() {
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder idLiquidacion(Integer idLiquidacion) {
            this.idLiquidacion = idLiquidacion;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder idIngresoItems(Integer idIngresoItems) {
            this.idIngresoItems = idIngresoItems;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder id_Orden(Integer id_Orden) {
            this.id_Orden = id_Orden;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder nombreServicio(String nombreServicio) {
            this.nombreServicio = nombreServicio;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder nombreItems(String nombreItems) {
            this.nombreItems = nombreItems;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder cantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder ValorUnitario(Double ValorUnitario) {
            this.ValorUnitario = ValorUnitario;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder valorFacturado(Double valorFacturado) {
            this.valorFacturado = valorFacturado;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder porcentajeImpuesto(Double porcentajeImpuesto) {
            this.porcentajeImpuesto = porcentajeImpuesto;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder idProcediminetos(String idProcediminetos) {
            this.idProcediminetos = idProcediminetos;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder EsCapitado(Integer EsCapitado) {
            this.EsCapitado = EsCapitado;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder cantidadNotas(Integer cantidadNotas) {
            this.cantidadNotas = cantidadNotas;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder valorNota(Double valorNota) {
            this.valorNota = valorNota;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder valorConDescuentoNota(Double valorConDescuentoNota) {
            this.valorConDescuentoNota = valorConDescuentoNota;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTOBuilder tipoItems(Integer tipoItems) {
            this.tipoItems = tipoItems;
            return this;
        }

        @Generated
        public FacturaNotaDetalleDescDTO build() {
            return new FacturaNotaDetalleDescDTO(this.idLiquidacion, this.idIngresoItems, this.id_Orden, this.codigo, this.nombreServicio, this.nombreItems, this.cantidad, this.ValorUnitario, this.valorFacturado, this.porcentajeImpuesto, this.idProcediminetos, this.EsCapitado, this.cantidadNotas, this.valorNota, this.valorConDescuentoNota, this.tipoItems);
        }

        @Generated
        public String toString() {
            return "FacturaNotaDetalleDescDTO.FacturaNotaDetalleDescDTOBuilder(idLiquidacion=" + this.idLiquidacion + ", idIngresoItems=" + this.idIngresoItems + ", id_Orden=" + this.id_Orden + ", codigo=" + this.codigo + ", nombreServicio=" + this.nombreServicio + ", nombreItems=" + this.nombreItems + ", cantidad=" + this.cantidad + ", ValorUnitario=" + this.ValorUnitario + ", valorFacturado=" + this.valorFacturado + ", porcentajeImpuesto=" + this.porcentajeImpuesto + ", idProcediminetos=" + this.idProcediminetos + ", EsCapitado=" + this.EsCapitado + ", cantidadNotas=" + this.cantidadNotas + ", valorNota=" + this.valorNota + ", valorConDescuentoNota=" + this.valorConDescuentoNota + ", tipoItems=" + this.tipoItems + ")";
        }
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FacturaNotaDetalleDescDTO)) {
            return false;
        }
        FacturaNotaDetalleDescDTO other = (FacturaNotaDetalleDescDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idLiquidacion = getIdLiquidacion();
        Object other$idLiquidacion = other.getIdLiquidacion();
        if (this$idLiquidacion == null) {
            if (other$idLiquidacion != null) {
                return false;
            }
        } else if (!this$idLiquidacion.equals(other$idLiquidacion)) {
            return false;
        }
        Object this$idIngresoItems = getIdIngresoItems();
        Object other$idIngresoItems = other.getIdIngresoItems();
        if (this$idIngresoItems == null) {
            if (other$idIngresoItems != null) {
                return false;
            }
        } else if (!this$idIngresoItems.equals(other$idIngresoItems)) {
            return false;
        }
        Object this$id_Orden = getId_Orden();
        Object other$id_Orden = other.getId_Orden();
        if (this$id_Orden == null) {
            if (other$id_Orden != null) {
                return false;
            }
        } else if (!this$id_Orden.equals(other$id_Orden)) {
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
        Object this$ValorUnitario = getValorUnitario();
        Object other$ValorUnitario = other.getValorUnitario();
        if (this$ValorUnitario == null) {
            if (other$ValorUnitario != null) {
                return false;
            }
        } else if (!this$ValorUnitario.equals(other$ValorUnitario)) {
            return false;
        }
        Object this$valorFacturado = getValorFacturado();
        Object other$valorFacturado = other.getValorFacturado();
        if (this$valorFacturado == null) {
            if (other$valorFacturado != null) {
                return false;
            }
        } else if (!this$valorFacturado.equals(other$valorFacturado)) {
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
        Object this$EsCapitado = getEsCapitado();
        Object other$EsCapitado = other.getEsCapitado();
        if (this$EsCapitado == null) {
            if (other$EsCapitado != null) {
                return false;
            }
        } else if (!this$EsCapitado.equals(other$EsCapitado)) {
            return false;
        }
        Object this$cantidadNotas = getCantidadNotas();
        Object other$cantidadNotas = other.getCantidadNotas();
        if (this$cantidadNotas == null) {
            if (other$cantidadNotas != null) {
                return false;
            }
        } else if (!this$cantidadNotas.equals(other$cantidadNotas)) {
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
        Object this$valorConDescuentoNota = getValorConDescuentoNota();
        Object other$valorConDescuentoNota = other.getValorConDescuentoNota();
        if (this$valorConDescuentoNota == null) {
            if (other$valorConDescuentoNota != null) {
                return false;
            }
        } else if (!this$valorConDescuentoNota.equals(other$valorConDescuentoNota)) {
            return false;
        }
        Object this$tipoItems = getTipoItems();
        Object other$tipoItems = other.getTipoItems();
        if (this$tipoItems == null) {
            if (other$tipoItems != null) {
                return false;
            }
        } else if (!this$tipoItems.equals(other$tipoItems)) {
            return false;
        }
        Object this$codigo = getCodigo();
        Object other$codigo = other.getCodigo();
        if (this$codigo == null) {
            if (other$codigo != null) {
                return false;
            }
        } else if (!this$codigo.equals(other$codigo)) {
            return false;
        }
        Object this$nombreServicio = getNombreServicio();
        Object other$nombreServicio = other.getNombreServicio();
        if (this$nombreServicio == null) {
            if (other$nombreServicio != null) {
                return false;
            }
        } else if (!this$nombreServicio.equals(other$nombreServicio)) {
            return false;
        }
        Object this$nombreItems = getNombreItems();
        Object other$nombreItems = other.getNombreItems();
        if (this$nombreItems == null) {
            if (other$nombreItems != null) {
                return false;
            }
        } else if (!this$nombreItems.equals(other$nombreItems)) {
            return false;
        }
        Object this$idProcediminetos = getIdProcediminetos();
        Object other$idProcediminetos = other.getIdProcediminetos();
        return this$idProcediminetos == null ? other$idProcediminetos == null : this$idProcediminetos.equals(other$idProcediminetos);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof FacturaNotaDetalleDescDTO;
    }

    @Generated
    public int hashCode() {
        Object $idLiquidacion = getIdLiquidacion();
        int result = (1 * 59) + ($idLiquidacion == null ? 43 : $idLiquidacion.hashCode());
        Object $idIngresoItems = getIdIngresoItems();
        int result2 = (result * 59) + ($idIngresoItems == null ? 43 : $idIngresoItems.hashCode());
        Object $id_Orden = getId_Orden();
        int result3 = (result2 * 59) + ($id_Orden == null ? 43 : $id_Orden.hashCode());
        Object $cantidad = getCantidad();
        int result4 = (result3 * 59) + ($cantidad == null ? 43 : $cantidad.hashCode());
        Object $ValorUnitario = getValorUnitario();
        int result5 = (result4 * 59) + ($ValorUnitario == null ? 43 : $ValorUnitario.hashCode());
        Object $valorFacturado = getValorFacturado();
        int result6 = (result5 * 59) + ($valorFacturado == null ? 43 : $valorFacturado.hashCode());
        Object $porcentajeImpuesto = getPorcentajeImpuesto();
        int result7 = (result6 * 59) + ($porcentajeImpuesto == null ? 43 : $porcentajeImpuesto.hashCode());
        Object $EsCapitado = getEsCapitado();
        int result8 = (result7 * 59) + ($EsCapitado == null ? 43 : $EsCapitado.hashCode());
        Object $cantidadNotas = getCantidadNotas();
        int result9 = (result8 * 59) + ($cantidadNotas == null ? 43 : $cantidadNotas.hashCode());
        Object $valorNota = getValorNota();
        int result10 = (result9 * 59) + ($valorNota == null ? 43 : $valorNota.hashCode());
        Object $valorConDescuentoNota = getValorConDescuentoNota();
        int result11 = (result10 * 59) + ($valorConDescuentoNota == null ? 43 : $valorConDescuentoNota.hashCode());
        Object $tipoItems = getTipoItems();
        int result12 = (result11 * 59) + ($tipoItems == null ? 43 : $tipoItems.hashCode());
        Object $codigo = getCodigo();
        int result13 = (result12 * 59) + ($codigo == null ? 43 : $codigo.hashCode());
        Object $nombreServicio = getNombreServicio();
        int result14 = (result13 * 59) + ($nombreServicio == null ? 43 : $nombreServicio.hashCode());
        Object $nombreItems = getNombreItems();
        int result15 = (result14 * 59) + ($nombreItems == null ? 43 : $nombreItems.hashCode());
        Object $idProcediminetos = getIdProcediminetos();
        return (result15 * 59) + ($idProcediminetos == null ? 43 : $idProcediminetos.hashCode());
    }

    @Generated
    public String toString() {
        return "FacturaNotaDetalleDescDTO(idLiquidacion=" + getIdLiquidacion() + ", idIngresoItems=" + getIdIngresoItems() + ", id_Orden=" + getId_Orden() + ", codigo=" + getCodigo() + ", nombreServicio=" + getNombreServicio() + ", nombreItems=" + getNombreItems() + ", cantidad=" + getCantidad() + ", ValorUnitario=" + getValorUnitario() + ", valorFacturado=" + getValorFacturado() + ", porcentajeImpuesto=" + getPorcentajeImpuesto() + ", idProcediminetos=" + getIdProcediminetos() + ", EsCapitado=" + getEsCapitado() + ", cantidadNotas=" + getCantidadNotas() + ", valorNota=" + getValorNota() + ", valorConDescuentoNota=" + getValorConDescuentoNota() + ", tipoItems=" + getTipoItems() + ")";
    }

    @Generated
    public static FacturaNotaDetalleDescDTOBuilder builder() {
        return new FacturaNotaDetalleDescDTOBuilder();
    }

    @Generated
    public FacturaNotaDetalleDescDTO(Integer idLiquidacion, Integer idIngresoItems, Integer id_Orden, String codigo, String nombreServicio, String nombreItems, Integer cantidad, Double ValorUnitario, Double valorFacturado, Double porcentajeImpuesto, String idProcediminetos, Integer EsCapitado, Integer cantidadNotas, Double valorNota, Double valorConDescuentoNota, Integer tipoItems) {
        this.idLiquidacion = idLiquidacion;
        this.idIngresoItems = idIngresoItems;
        this.id_Orden = id_Orden;
        this.codigo = codigo;
        this.nombreServicio = nombreServicio;
        this.nombreItems = nombreItems;
        this.cantidad = cantidad;
        this.ValorUnitario = ValorUnitario;
        this.valorFacturado = valorFacturado;
        this.porcentajeImpuesto = porcentajeImpuesto;
        this.idProcediminetos = idProcediminetos;
        this.EsCapitado = EsCapitado;
        this.cantidadNotas = cantidadNotas;
        this.valorNota = valorNota;
        this.valorConDescuentoNota = valorConDescuentoNota;
        this.tipoItems = tipoItems;
    }

    @Generated
    public FacturaNotaDetalleDescDTO() {
    }

    @Generated
    public void setIdLiquidacion(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    @Generated
    public void setIdIngresoItems(Integer idIngresoItems) {
        this.idIngresoItems = idIngresoItems;
    }

    @Generated
    public void setId_Orden(Integer id_Orden) {
        this.id_Orden = id_Orden;
    }

    @Generated
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Generated
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    @Generated
    public void setNombreItems(String nombreItems) {
        this.nombreItems = nombreItems;
    }

    @Generated
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    @Generated
    public void setValorFacturado(Double valorFacturado) {
        this.valorFacturado = valorFacturado;
    }

    @Generated
    public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    @Generated
    public void setIdProcediminetos(String idProcediminetos) {
        this.idProcediminetos = idProcediminetos;
    }

    @Generated
    public void setEsCapitado(Integer EsCapitado) {
        this.EsCapitado = EsCapitado;
    }

    @Generated
    public void setCantidadNotas(Integer cantidadNotas) {
        this.cantidadNotas = cantidadNotas;
    }

    @Generated
    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    @Generated
    public void setValorConDescuentoNota(Double valorConDescuentoNota) {
        this.valorConDescuentoNota = valorConDescuentoNota;
    }

    @Generated
    public void setTipoItems(Integer tipoItems) {
        this.tipoItems = tipoItems;
    }

    @Generated
    public Integer getIdLiquidacion() {
        return this.idLiquidacion;
    }

    @Generated
    public Integer getIdIngresoItems() {
        return this.idIngresoItems;
    }

    @Generated
    public Integer getId_Orden() {
        return this.id_Orden;
    }

    @Generated
    public String getCodigo() {
        return this.codigo;
    }

    @Generated
    public String getNombreServicio() {
        return this.nombreServicio;
    }

    @Generated
    public String getNombreItems() {
        return this.nombreItems;
    }

    @Generated
    public Integer getCantidad() {
        return this.cantidad;
    }

    @Generated
    public Double getValorUnitario() {
        return this.ValorUnitario;
    }

    @Generated
    public Double getValorFacturado() {
        return this.valorFacturado;
    }

    @Generated
    public Double getPorcentajeImpuesto() {
        return this.porcentajeImpuesto;
    }

    @Generated
    public String getIdProcediminetos() {
        return this.idProcediminetos;
    }

    @Generated
    public Integer getEsCapitado() {
        return this.EsCapitado;
    }

    @Generated
    public Integer getCantidadNotas() {
        return this.cantidadNotas;
    }

    @Generated
    public Double getValorNota() {
        return this.valorNota;
    }

    @Generated
    public Double getValorConDescuentoNota() {
        return this.valorConDescuentoNota;
    }

    @Generated
    public Integer getTipoItems() {
        return this.tipoItems;
    }
}
