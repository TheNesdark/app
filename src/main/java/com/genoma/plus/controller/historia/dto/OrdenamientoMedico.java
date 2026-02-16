package com.genoma.plus.controller.historia.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/OrdenamientoMedico.class */
public class OrdenamientoMedico {
    private Long id;
    private Long idAtencion;
    private String documentoUsuario;
    private String nombreUsuario;
    private Long idOrden;
    private LocalDateTime fechaOrden;
    private String descripcion;
    private Integer idServicio;
    private String nombreServicio;
    private List<OrdenamientoMedicoDetalle> detalleOrden;
    private String profesional;
    private String especialidad;
    private Boolean estado;
    private Boolean cerrada;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrdenamientoMedico)) {
            return false;
        }
        OrdenamientoMedico other = (OrdenamientoMedico) o;
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
        Object this$idAtencion = getIdAtencion();
        Object other$idAtencion = other.getIdAtencion();
        if (this$idAtencion == null) {
            if (other$idAtencion != null) {
                return false;
            }
        } else if (!this$idAtencion.equals(other$idAtencion)) {
            return false;
        }
        Object this$idOrden = getIdOrden();
        Object other$idOrden = other.getIdOrden();
        if (this$idOrden == null) {
            if (other$idOrden != null) {
                return false;
            }
        } else if (!this$idOrden.equals(other$idOrden)) {
            return false;
        }
        Object this$idServicio = getIdServicio();
        Object other$idServicio = other.getIdServicio();
        if (this$idServicio == null) {
            if (other$idServicio != null) {
                return false;
            }
        } else if (!this$idServicio.equals(other$idServicio)) {
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
        Object this$cerrada = getCerrada();
        Object other$cerrada = other.getCerrada();
        if (this$cerrada == null) {
            if (other$cerrada != null) {
                return false;
            }
        } else if (!this$cerrada.equals(other$cerrada)) {
            return false;
        }
        Object this$documentoUsuario = getDocumentoUsuario();
        Object other$documentoUsuario = other.getDocumentoUsuario();
        if (this$documentoUsuario == null) {
            if (other$documentoUsuario != null) {
                return false;
            }
        } else if (!this$documentoUsuario.equals(other$documentoUsuario)) {
            return false;
        }
        Object this$nombreUsuario = getNombreUsuario();
        Object other$nombreUsuario = other.getNombreUsuario();
        if (this$nombreUsuario == null) {
            if (other$nombreUsuario != null) {
                return false;
            }
        } else if (!this$nombreUsuario.equals(other$nombreUsuario)) {
            return false;
        }
        Object this$fechaOrden = getFechaOrden();
        Object other$fechaOrden = other.getFechaOrden();
        if (this$fechaOrden == null) {
            if (other$fechaOrden != null) {
                return false;
            }
        } else if (!this$fechaOrden.equals(other$fechaOrden)) {
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
        Object this$nombreServicio = getNombreServicio();
        Object other$nombreServicio = other.getNombreServicio();
        if (this$nombreServicio == null) {
            if (other$nombreServicio != null) {
                return false;
            }
        } else if (!this$nombreServicio.equals(other$nombreServicio)) {
            return false;
        }
        Object this$detalleOrden = getDetalleOrden();
        Object other$detalleOrden = other.getDetalleOrden();
        if (this$detalleOrden == null) {
            if (other$detalleOrden != null) {
                return false;
            }
        } else if (!this$detalleOrden.equals(other$detalleOrden)) {
            return false;
        }
        Object this$profesional = getProfesional();
        Object other$profesional = other.getProfesional();
        if (this$profesional == null) {
            if (other$profesional != null) {
                return false;
            }
        } else if (!this$profesional.equals(other$profesional)) {
            return false;
        }
        Object this$especialidad = getEspecialidad();
        Object other$especialidad = other.getEspecialidad();
        return this$especialidad == null ? other$especialidad == null : this$especialidad.equals(other$especialidad);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrdenamientoMedico;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idAtencion = getIdAtencion();
        int result2 = (result * 59) + ($idAtencion == null ? 43 : $idAtencion.hashCode());
        Object $idOrden = getIdOrden();
        int result3 = (result2 * 59) + ($idOrden == null ? 43 : $idOrden.hashCode());
        Object $idServicio = getIdServicio();
        int result4 = (result3 * 59) + ($idServicio == null ? 43 : $idServicio.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $cerrada = getCerrada();
        int result6 = (result5 * 59) + ($cerrada == null ? 43 : $cerrada.hashCode());
        Object $documentoUsuario = getDocumentoUsuario();
        int result7 = (result6 * 59) + ($documentoUsuario == null ? 43 : $documentoUsuario.hashCode());
        Object $nombreUsuario = getNombreUsuario();
        int result8 = (result7 * 59) + ($nombreUsuario == null ? 43 : $nombreUsuario.hashCode());
        Object $fechaOrden = getFechaOrden();
        int result9 = (result8 * 59) + ($fechaOrden == null ? 43 : $fechaOrden.hashCode());
        Object $descripcion = getDescripcion();
        int result10 = (result9 * 59) + ($descripcion == null ? 43 : $descripcion.hashCode());
        Object $nombreServicio = getNombreServicio();
        int result11 = (result10 * 59) + ($nombreServicio == null ? 43 : $nombreServicio.hashCode());
        Object $detalleOrden = getDetalleOrden();
        int result12 = (result11 * 59) + ($detalleOrden == null ? 43 : $detalleOrden.hashCode());
        Object $profesional = getProfesional();
        int result13 = (result12 * 59) + ($profesional == null ? 43 : $profesional.hashCode());
        Object $especialidad = getEspecialidad();
        return (result13 * 59) + ($especialidad == null ? 43 : $especialidad.hashCode());
    }

    @Generated
    public String toString() {
        return "OrdenamientoMedico(id=" + getId() + ", idAtencion=" + getIdAtencion() + ", documentoUsuario=" + getDocumentoUsuario() + ", nombreUsuario=" + getNombreUsuario() + ", idOrden=" + getIdOrden() + ", fechaOrden=" + getFechaOrden() + ", descripcion=" + getDescripcion() + ", idServicio=" + getIdServicio() + ", nombreServicio=" + getNombreServicio() + ", detalleOrden=" + getDetalleOrden() + ", profesional=" + getProfesional() + ", especialidad=" + getEspecialidad() + ", estado=" + getEstado() + ", cerrada=" + getCerrada() + ")";
    }

    @Generated
    public OrdenamientoMedico(Long id, Long idAtencion, String documentoUsuario, String nombreUsuario, Long idOrden, LocalDateTime fechaOrden, String descripcion, Integer idServicio, String nombreServicio, List<OrdenamientoMedicoDetalle> detalleOrden, String profesional, String especialidad, Boolean estado, Boolean cerrada) {
        this.id = id;
        this.idAtencion = idAtencion;
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.descripcion = descripcion;
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.detalleOrden = detalleOrden;
        this.profesional = profesional;
        this.especialidad = especialidad;
        this.estado = estado;
        this.cerrada = cerrada;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/OrdenamientoMedico$OrdenamientoMedicoBuilder.class */
    @Generated
    public static class OrdenamientoMedicoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idAtencion;

        @Generated
        private String documentoUsuario;

        @Generated
        private String nombreUsuario;

        @Generated
        private Long idOrden;

        @Generated
        private LocalDateTime fechaOrden;

        @Generated
        private String descripcion;

        @Generated
        private Integer idServicio;

        @Generated
        private String nombreServicio;

        @Generated
        private List<OrdenamientoMedicoDetalle> detalleOrden;

        @Generated
        private String profesional;

        @Generated
        private String especialidad;

        @Generated
        private Boolean estado;

        @Generated
        private Boolean cerrada;

        @Generated
        OrdenamientoMedicoBuilder() {
        }

        @Generated
        public OrdenamientoMedicoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder idAtencion(Long idAtencion) {
            this.idAtencion = idAtencion;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder documentoUsuario(String documentoUsuario) {
            this.documentoUsuario = documentoUsuario;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder idOrden(Long idOrden) {
            this.idOrden = idOrden;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder fechaOrden(LocalDateTime fechaOrden) {
            this.fechaOrden = fechaOrden;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder idServicio(Integer idServicio) {
            this.idServicio = idServicio;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder nombreServicio(String nombreServicio) {
            this.nombreServicio = nombreServicio;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder detalleOrden(List<OrdenamientoMedicoDetalle> detalleOrden) {
            this.detalleOrden = detalleOrden;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder profesional(String profesional) {
            this.profesional = profesional;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder especialidad(String especialidad) {
            this.especialidad = especialidad;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public OrdenamientoMedicoBuilder cerrada(Boolean cerrada) {
            this.cerrada = cerrada;
            return this;
        }

        @Generated
        public OrdenamientoMedico build() {
            return new OrdenamientoMedico(this.id, this.idAtencion, this.documentoUsuario, this.nombreUsuario, this.idOrden, this.fechaOrden, this.descripcion, this.idServicio, this.nombreServicio, this.detalleOrden, this.profesional, this.especialidad, this.estado, this.cerrada);
        }

        @Generated
        public String toString() {
            return "OrdenamientoMedico.OrdenamientoMedicoBuilder(id=" + this.id + ", idAtencion=" + this.idAtencion + ", documentoUsuario=" + this.documentoUsuario + ", nombreUsuario=" + this.nombreUsuario + ", idOrden=" + this.idOrden + ", fechaOrden=" + this.fechaOrden + ", descripcion=" + this.descripcion + ", idServicio=" + this.idServicio + ", nombreServicio=" + this.nombreServicio + ", detalleOrden=" + this.detalleOrden + ", profesional=" + this.profesional + ", especialidad=" + this.especialidad + ", estado=" + this.estado + ", cerrada=" + this.cerrada + ")";
        }
    }

    @Generated
    public OrdenamientoMedico() {
    }

    @Generated
    public static OrdenamientoMedicoBuilder builder() {
        return new OrdenamientoMedicoBuilder();
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdAtencion(Long idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    @Generated
    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @Generated
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Generated
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    @Generated
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    @Generated
    public void setDetalleOrden(List<OrdenamientoMedicoDetalle> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    @Generated
    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    @Generated
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setCerrada(Boolean cerrada) {
        this.cerrada = cerrada;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public String getDocumentoUsuario() {
        return this.documentoUsuario;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public Long getIdOrden() {
        return this.idOrden;
    }

    @Generated
    public LocalDateTime getFechaOrden() {
        return this.fechaOrden;
    }

    @Generated
    public String getDescripcion() {
        return this.descripcion;
    }

    @Generated
    public Integer getIdServicio() {
        return this.idServicio;
    }

    @Generated
    public String getNombreServicio() {
        return this.nombreServicio;
    }

    @Generated
    public List<OrdenamientoMedicoDetalle> getDetalleOrden() {
        return this.detalleOrden;
    }

    @Generated
    public String getProfesional() {
        return this.profesional;
    }

    @Generated
    public String getEspecialidad() {
        return this.especialidad;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Boolean getCerrada() {
        return this.cerrada;
    }
}
