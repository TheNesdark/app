package com.genoma.plus.controller.laboratorio.dto;

import java.time.Instant;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/AreaDTO.class */
public class AreaDTO {
    private Integer id;
    private String nombre;
    private Integer idReporte;
    private String nombreReporte;
    private String nombreReferencia;
    private String descripcion;
    private Boolean seguimiento;
    private Boolean estado;
    private String usuarioSistemas;
    private Instant fecha;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AreaDTO)) {
            return false;
        }
        AreaDTO other = (AreaDTO) o;
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
        Object this$idReporte = getIdReporte();
        Object other$idReporte = other.getIdReporte();
        if (this$idReporte == null) {
            if (other$idReporte != null) {
                return false;
            }
        } else if (!this$idReporte.equals(other$idReporte)) {
            return false;
        }
        Object this$seguimiento = getSeguimiento();
        Object other$seguimiento = other.getSeguimiento();
        if (this$seguimiento == null) {
            if (other$seguimiento != null) {
                return false;
            }
        } else if (!this$seguimiento.equals(other$seguimiento)) {
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
        Object this$nombre = getNombre();
        Object other$nombre = other.getNombre();
        if (this$nombre == null) {
            if (other$nombre != null) {
                return false;
            }
        } else if (!this$nombre.equals(other$nombre)) {
            return false;
        }
        Object this$nombreReporte = getNombreReporte();
        Object other$nombreReporte = other.getNombreReporte();
        if (this$nombreReporte == null) {
            if (other$nombreReporte != null) {
                return false;
            }
        } else if (!this$nombreReporte.equals(other$nombreReporte)) {
            return false;
        }
        Object this$nombreReferencia = getNombreReferencia();
        Object other$nombreReferencia = other.getNombreReferencia();
        if (this$nombreReferencia == null) {
            if (other$nombreReferencia != null) {
                return false;
            }
        } else if (!this$nombreReferencia.equals(other$nombreReferencia)) {
            return false;
        }
        Object this$descripcion = getDescripcion();
        Object other$descripcion = other.getDescripcion();
        if (this$descripcion == null) {
            if (other$descripcion != null) {
                return false;
            }
        } else if (!this$descripcion.equals(other$descripcion)) {
            return false;
        }
        Object this$usuarioSistemas = getUsuarioSistemas();
        Object other$usuarioSistemas = other.getUsuarioSistemas();
        if (this$usuarioSistemas == null) {
            if (other$usuarioSistemas != null) {
                return false;
            }
        } else if (!this$usuarioSistemas.equals(other$usuarioSistemas)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        return this$fecha == null ? other$fecha == null : this$fecha.equals(other$fecha);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AreaDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idReporte = getIdReporte();
        int result2 = (result * 59) + ($idReporte == null ? 43 : $idReporte.hashCode());
        Object $seguimiento = getSeguimiento();
        int result3 = (result2 * 59) + ($seguimiento == null ? 43 : $seguimiento.hashCode());
        Object $estado = getEstado();
        int result4 = (result3 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $nombre = getNombre();
        int result5 = (result4 * 59) + ($nombre == null ? 43 : $nombre.hashCode());
        Object $nombreReporte = getNombreReporte();
        int result6 = (result5 * 59) + ($nombreReporte == null ? 43 : $nombreReporte.hashCode());
        Object $nombreReferencia = getNombreReferencia();
        int result7 = (result6 * 59) + ($nombreReferencia == null ? 43 : $nombreReferencia.hashCode());
        Object $descripcion = getDescripcion();
        int result8 = (result7 * 59) + ($descripcion == null ? 43 : $descripcion.hashCode());
        Object $usuarioSistemas = getUsuarioSistemas();
        int result9 = (result8 * 59) + ($usuarioSistemas == null ? 43 : $usuarioSistemas.hashCode());
        Object $fecha = getFecha();
        return (result9 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
    }

    @Generated
    public String toString() {
        return "AreaDTO(id=" + getId() + ", nombre=" + getNombre() + ", idReporte=" + getIdReporte() + ", nombreReporte=" + getNombreReporte() + ", nombreReferencia=" + getNombreReferencia() + ", descripcion=" + getDescripcion() + ", seguimiento=" + getSeguimiento() + ", estado=" + getEstado() + ", usuarioSistemas=" + getUsuarioSistemas() + ", fecha=" + getFecha() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/AreaDTO$AreaDTOBuilder.class */
    @Generated
    public static class AreaDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String nombre;

        @Generated
        private Integer idReporte;

        @Generated
        private String nombreReporte;

        @Generated
        private String nombreReferencia;

        @Generated
        private String descripcion;

        @Generated
        private Boolean seguimiento;

        @Generated
        private Boolean estado;

        @Generated
        private String usuarioSistemas;

        @Generated
        private Instant fecha;

        @Generated
        AreaDTOBuilder() {
        }

        @Generated
        public AreaDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public AreaDTOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        @Generated
        public AreaDTOBuilder idReporte(Integer idReporte) {
            this.idReporte = idReporte;
            return this;
        }

        @Generated
        public AreaDTOBuilder nombreReporte(String nombreReporte) {
            this.nombreReporte = nombreReporte;
            return this;
        }

        @Generated
        public AreaDTOBuilder nombreReferencia(String nombreReferencia) {
            this.nombreReferencia = nombreReferencia;
            return this;
        }

        @Generated
        public AreaDTOBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        @Generated
        public AreaDTOBuilder seguimiento(Boolean seguimiento) {
            this.seguimiento = seguimiento;
            return this;
        }

        @Generated
        public AreaDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public AreaDTOBuilder usuarioSistemas(String usuarioSistemas) {
            this.usuarioSistemas = usuarioSistemas;
            return this;
        }

        @Generated
        public AreaDTOBuilder fecha(Instant fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public AreaDTO build() {
            return new AreaDTO(this.id, this.nombre, this.idReporte, this.nombreReporte, this.nombreReferencia, this.descripcion, this.seguimiento, this.estado, this.usuarioSistemas, this.fecha);
        }

        @Generated
        public String toString() {
            return "AreaDTO.AreaDTOBuilder(id=" + this.id + ", nombre=" + this.nombre + ", idReporte=" + this.idReporte + ", nombreReporte=" + this.nombreReporte + ", nombreReferencia=" + this.nombreReferencia + ", descripcion=" + this.descripcion + ", seguimiento=" + this.seguimiento + ", estado=" + this.estado + ", usuarioSistemas=" + this.usuarioSistemas + ", fecha=" + this.fecha + ")";
        }
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated
    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    @Generated
    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    @Generated
    public void setNombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    @Generated
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Generated
    public void setSeguimiento(Boolean seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setUsuarioSistemas(String usuarioSistemas) {
        this.usuarioSistemas = usuarioSistemas;
    }

    @Generated
    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    @Generated
    public static AreaDTOBuilder builder() {
        return new AreaDTOBuilder();
    }

    @Generated
    public AreaDTO(Integer id, String nombre, Integer idReporte, String nombreReporte, String nombreReferencia, String descripcion, Boolean seguimiento, Boolean estado, String usuarioSistemas, Instant fecha) {
        this.id = id;
        this.nombre = nombre;
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.nombreReferencia = nombreReferencia;
        this.descripcion = descripcion;
        this.seguimiento = seguimiento;
        this.estado = estado;
        this.usuarioSistemas = usuarioSistemas;
        this.fecha = fecha;
    }

    @Generated
    public AreaDTO() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getNombre() {
        return this.nombre;
    }

    @Generated
    public Integer getIdReporte() {
        return this.idReporte;
    }

    @Generated
    public String getNombreReporte() {
        return this.nombreReporte;
    }

    @Generated
    public String getNombreReferencia() {
        return this.nombreReferencia;
    }

    @Generated
    public String getDescripcion() {
        return this.descripcion;
    }

    @Generated
    public Boolean getSeguimiento() {
        return this.seguimiento;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public String getUsuarioSistemas() {
        return this.usuarioSistemas;
    }

    @Generated
    public Instant getFecha() {
        return this.fecha;
    }
}
