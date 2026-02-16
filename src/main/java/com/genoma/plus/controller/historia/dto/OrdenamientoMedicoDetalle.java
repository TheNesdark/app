package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/OrdenamientoMedicoDetalle.class */
public class OrdenamientoMedicoDetalle {
    private String codigo;
    private String nombre;
    private String observacion;
    private String cantidad;
    private Boolean ejecutado;
    private Boolean autorizacion;
    private Long idItemsDetalle;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrdenamientoMedicoDetalle)) {
            return false;
        }
        OrdenamientoMedicoDetalle other = (OrdenamientoMedicoDetalle) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ejecutado = getEjecutado();
        Object other$ejecutado = other.getEjecutado();
        if (this$ejecutado == null) {
            if (other$ejecutado != null) {
                return false;
            }
        } else if (!this$ejecutado.equals(other$ejecutado)) {
            return false;
        }
        Object this$autorizacion = getAutorizacion();
        Object other$autorizacion = other.getAutorizacion();
        if (this$autorizacion == null) {
            if (other$autorizacion != null) {
                return false;
            }
        } else if (!this$autorizacion.equals(other$autorizacion)) {
            return false;
        }
        Object this$idItemsDetalle = getIdItemsDetalle();
        Object other$idItemsDetalle = other.getIdItemsDetalle();
        if (this$idItemsDetalle == null) {
            if (other$idItemsDetalle != null) {
                return false;
            }
        } else if (!this$idItemsDetalle.equals(other$idItemsDetalle)) {
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
        Object this$nombre = getNombre();
        Object other$nombre = other.getNombre();
        if (this$nombre == null) {
            if (other$nombre != null) {
                return false;
            }
        } else if (!this$nombre.equals(other$nombre)) {
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
        Object this$cantidad = getCantidad();
        Object other$cantidad = other.getCantidad();
        return this$cantidad == null ? other$cantidad == null : this$cantidad.equals(other$cantidad);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrdenamientoMedicoDetalle;
    }

    @Generated
    public int hashCode() {
        Object $ejecutado = getEjecutado();
        int result = (1 * 59) + ($ejecutado == null ? 43 : $ejecutado.hashCode());
        Object $autorizacion = getAutorizacion();
        int result2 = (result * 59) + ($autorizacion == null ? 43 : $autorizacion.hashCode());
        Object $idItemsDetalle = getIdItemsDetalle();
        int result3 = (result2 * 59) + ($idItemsDetalle == null ? 43 : $idItemsDetalle.hashCode());
        Object $codigo = getCodigo();
        int result4 = (result3 * 59) + ($codigo == null ? 43 : $codigo.hashCode());
        Object $nombre = getNombre();
        int result5 = (result4 * 59) + ($nombre == null ? 43 : $nombre.hashCode());
        Object $observacion = getObservacion();
        int result6 = (result5 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $cantidad = getCantidad();
        return (result6 * 59) + ($cantidad == null ? 43 : $cantidad.hashCode());
    }

    @Generated
    public String toString() {
        return "OrdenamientoMedicoDetalle(codigo=" + getCodigo() + ", nombre=" + getNombre() + ", observacion=" + getObservacion() + ", cantidad=" + getCantidad() + ", ejecutado=" + getEjecutado() + ", autorizacion=" + getAutorizacion() + ", idItemsDetalle=" + getIdItemsDetalle() + ")";
    }

    @Generated
    public OrdenamientoMedicoDetalle(String codigo, String nombre, String observacion, String cantidad, Boolean ejecutado, Boolean autorizacion, Long idItemsDetalle) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.observacion = observacion;
        this.cantidad = cantidad;
        this.ejecutado = ejecutado;
        this.autorizacion = autorizacion;
        this.idItemsDetalle = idItemsDetalle;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/OrdenamientoMedicoDetalle$OrdenamientoMedicoDetalleBuilder.class */
    @Generated
    public static class OrdenamientoMedicoDetalleBuilder {

        @Generated
        private String codigo;

        @Generated
        private String nombre;

        @Generated
        private String observacion;

        @Generated
        private String cantidad;

        @Generated
        private Boolean ejecutado;

        @Generated
        private Boolean autorizacion;

        @Generated
        private Long idItemsDetalle;

        @Generated
        OrdenamientoMedicoDetalleBuilder() {
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder cantidad(String cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder ejecutado(Boolean ejecutado) {
            this.ejecutado = ejecutado;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder autorizacion(Boolean autorizacion) {
            this.autorizacion = autorizacion;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalleBuilder idItemsDetalle(Long idItemsDetalle) {
            this.idItemsDetalle = idItemsDetalle;
            return this;
        }

        @Generated
        public OrdenamientoMedicoDetalle build() {
            return new OrdenamientoMedicoDetalle(this.codigo, this.nombre, this.observacion, this.cantidad, this.ejecutado, this.autorizacion, this.idItemsDetalle);
        }

        @Generated
        public String toString() {
            return "OrdenamientoMedicoDetalle.OrdenamientoMedicoDetalleBuilder(codigo=" + this.codigo + ", nombre=" + this.nombre + ", observacion=" + this.observacion + ", cantidad=" + this.cantidad + ", ejecutado=" + this.ejecutado + ", autorizacion=" + this.autorizacion + ", idItemsDetalle=" + this.idItemsDetalle + ")";
        }
    }

    @Generated
    public OrdenamientoMedicoDetalle() {
    }

    @Generated
    public static OrdenamientoMedicoDetalleBuilder builder() {
        return new OrdenamientoMedicoDetalleBuilder();
    }

    @Generated
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Generated
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setEjecutado(Boolean ejecutado) {
        this.ejecutado = ejecutado;
    }

    @Generated
    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    @Generated
    public void setIdItemsDetalle(Long idItemsDetalle) {
        this.idItemsDetalle = idItemsDetalle;
    }

    @Generated
    public String getCodigo() {
        return this.codigo;
    }

    @Generated
    public String getNombre() {
        return this.nombre;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public String getCantidad() {
        return this.cantidad;
    }

    @Generated
    public Boolean getEjecutado() {
        return this.ejecutado;
    }

    @Generated
    public Boolean getAutorizacion() {
        return this.autorizacion;
    }

    @Generated
    public Long getIdItemsDetalle() {
        return this.idItemsDetalle;
    }
}
