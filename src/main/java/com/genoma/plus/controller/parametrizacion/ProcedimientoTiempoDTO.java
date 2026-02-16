package com.genoma.plus.controller.parametrizacion;

import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ProcedimientoTiempoDTO.class */
public class ProcedimientoTiempoDTO {
    private Integer id;
    private Long idProcedimiento;
    private Integer idServicio;
    private String idUsuarioRh;
    private Integer tiempo;
    private Boolean estado;
    private LocalDateTime fecha;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProcedimientoTiempoDTO)) {
            return false;
        }
        ProcedimientoTiempoDTO other = (ProcedimientoTiempoDTO) o;
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
        Object this$idProcedimiento = getIdProcedimiento();
        Object other$idProcedimiento = other.getIdProcedimiento();
        if (this$idProcedimiento == null) {
            if (other$idProcedimiento != null) {
                return false;
            }
        } else if (!this$idProcedimiento.equals(other$idProcedimiento)) {
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
        Object this$tiempo = getTiempo();
        Object other$tiempo = other.getTiempo();
        if (this$tiempo == null) {
            if (other$tiempo != null) {
                return false;
            }
        } else if (!this$tiempo.equals(other$tiempo)) {
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
        Object this$idUsuarioRh = getIdUsuarioRh();
        Object other$idUsuarioRh = other.getIdUsuarioRh();
        if (this$idUsuarioRh == null) {
            if (other$idUsuarioRh != null) {
                return false;
            }
        } else if (!this$idUsuarioRh.equals(other$idUsuarioRh)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        return this$fecha == null ? other$fecha == null : this$fecha.equals(other$fecha);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ProcedimientoTiempoDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idProcedimiento = getIdProcedimiento();
        int result2 = (result * 59) + ($idProcedimiento == null ? 43 : $idProcedimiento.hashCode());
        Object $idServicio = getIdServicio();
        int result3 = (result2 * 59) + ($idServicio == null ? 43 : $idServicio.hashCode());
        Object $tiempo = getTiempo();
        int result4 = (result3 * 59) + ($tiempo == null ? 43 : $tiempo.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $idUsuarioRh = getIdUsuarioRh();
        int result6 = (result5 * 59) + ($idUsuarioRh == null ? 43 : $idUsuarioRh.hashCode());
        Object $fecha = getFecha();
        return (result6 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
    }

    @Generated
    public String toString() {
        return "ProcedimientoTiempoDTO(id=" + getId() + ", idProcedimiento=" + getIdProcedimiento() + ", idServicio=" + getIdServicio() + ", idUsuarioRh=" + getIdUsuarioRh() + ", tiempo=" + getTiempo() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ProcedimientoTiempoDTO$ProcedimientoTiempoDTOBuilder.class */
    @Generated
    public static class ProcedimientoTiempoDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private Long idProcedimiento;

        @Generated
        private Integer idServicio;

        @Generated
        private String idUsuarioRh;

        @Generated
        private Integer tiempo;

        @Generated
        private Boolean estado;

        @Generated
        private LocalDateTime fecha;

        @Generated
        ProcedimientoTiempoDTOBuilder() {
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder idProcedimiento(Long idProcedimiento) {
            this.idProcedimiento = idProcedimiento;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder idServicio(Integer idServicio) {
            this.idServicio = idServicio;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder idUsuarioRh(String idUsuarioRh) {
            this.idUsuarioRh = idUsuarioRh;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder tiempo(Integer tiempo) {
            this.tiempo = tiempo;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTOBuilder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public ProcedimientoTiempoDTO build() {
            return new ProcedimientoTiempoDTO(this.id, this.idProcedimiento, this.idServicio, this.idUsuarioRh, this.tiempo, this.estado, this.fecha);
        }

        @Generated
        public String toString() {
            return "ProcedimientoTiempoDTO.ProcedimientoTiempoDTOBuilder(id=" + this.id + ", idProcedimiento=" + this.idProcedimiento + ", idServicio=" + this.idServicio + ", idUsuarioRh=" + this.idUsuarioRh + ", tiempo=" + this.tiempo + ", estado=" + this.estado + ", fecha=" + this.fecha + ")";
        }
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Generated
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    @Generated
    public void setIdUsuarioRh(String idUsuarioRh) {
        this.idUsuarioRh = idUsuarioRh;
    }

    @Generated
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Generated
    public static ProcedimientoTiempoDTOBuilder builder() {
        return new ProcedimientoTiempoDTOBuilder();
    }

    @Generated
    public ProcedimientoTiempoDTO(Integer id, Long idProcedimiento, Integer idServicio, String idUsuarioRh, Integer tiempo, Boolean estado, LocalDateTime fecha) {
        this.id = id;
        this.idProcedimiento = idProcedimiento;
        this.idServicio = idServicio;
        this.idUsuarioRh = idUsuarioRh;
        this.tiempo = tiempo;
        this.estado = estado;
        this.fecha = fecha;
    }

    @Generated
    public ProcedimientoTiempoDTO() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public Long getIdProcedimiento() {
        return this.idProcedimiento;
    }

    @Generated
    public Integer getIdServicio() {
        return this.idServicio;
    }

    @Generated
    public String getIdUsuarioRh() {
        return this.idUsuarioRh;
    }

    @Generated
    public Integer getTiempo() {
        return this.tiempo;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public LocalDateTime getFecha() {
        return this.fecha;
    }
}
