package com.genoma.plus.controller.parametrizacion;

import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/RemisionExamenDTO.class */
public class RemisionExamenDTO {
    private Long id;
    private Long idEmpresaConvenio;
    private String nombreConvenio;
    private Long idProcedimiento;
    private String nombreProcedimiento;
    private Integer idTipoPrograma;
    private String nombrePrograma;
    private Boolean estado;
    private LocalDateTime fecha;
    private String idUsuarioS;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RemisionExamenDTO)) {
            return false;
        }
        RemisionExamenDTO other = (RemisionExamenDTO) o;
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
        Object this$idEmpresaConvenio = getIdEmpresaConvenio();
        Object other$idEmpresaConvenio = other.getIdEmpresaConvenio();
        if (this$idEmpresaConvenio == null) {
            if (other$idEmpresaConvenio != null) {
                return false;
            }
        } else if (!this$idEmpresaConvenio.equals(other$idEmpresaConvenio)) {
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
        Object this$idTipoPrograma = getIdTipoPrograma();
        Object other$idTipoPrograma = other.getIdTipoPrograma();
        if (this$idTipoPrograma == null) {
            if (other$idTipoPrograma != null) {
                return false;
            }
        } else if (!this$idTipoPrograma.equals(other$idTipoPrograma)) {
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
        Object this$nombreConvenio = getNombreConvenio();
        Object other$nombreConvenio = other.getNombreConvenio();
        if (this$nombreConvenio == null) {
            if (other$nombreConvenio != null) {
                return false;
            }
        } else if (!this$nombreConvenio.equals(other$nombreConvenio)) {
            return false;
        }
        Object this$nombreProcedimiento = getNombreProcedimiento();
        Object other$nombreProcedimiento = other.getNombreProcedimiento();
        if (this$nombreProcedimiento == null) {
            if (other$nombreProcedimiento != null) {
                return false;
            }
        } else if (!this$nombreProcedimiento.equals(other$nombreProcedimiento)) {
            return false;
        }
        Object this$nombrePrograma = getNombrePrograma();
        Object other$nombrePrograma = other.getNombrePrograma();
        if (this$nombrePrograma == null) {
            if (other$nombrePrograma != null) {
                return false;
            }
        } else if (!this$nombrePrograma.equals(other$nombrePrograma)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        if (this$fecha == null) {
            if (other$fecha != null) {
                return false;
            }
        } else if (!this$fecha.equals(other$fecha)) {
            return false;
        }
        Object this$idUsuarioS = getIdUsuarioS();
        Object other$idUsuarioS = other.getIdUsuarioS();
        return this$idUsuarioS == null ? other$idUsuarioS == null : this$idUsuarioS.equals(other$idUsuarioS);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RemisionExamenDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idEmpresaConvenio = getIdEmpresaConvenio();
        int result2 = (result * 59) + ($idEmpresaConvenio == null ? 43 : $idEmpresaConvenio.hashCode());
        Object $idProcedimiento = getIdProcedimiento();
        int result3 = (result2 * 59) + ($idProcedimiento == null ? 43 : $idProcedimiento.hashCode());
        Object $idTipoPrograma = getIdTipoPrograma();
        int result4 = (result3 * 59) + ($idTipoPrograma == null ? 43 : $idTipoPrograma.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $nombreConvenio = getNombreConvenio();
        int result6 = (result5 * 59) + ($nombreConvenio == null ? 43 : $nombreConvenio.hashCode());
        Object $nombreProcedimiento = getNombreProcedimiento();
        int result7 = (result6 * 59) + ($nombreProcedimiento == null ? 43 : $nombreProcedimiento.hashCode());
        Object $nombrePrograma = getNombrePrograma();
        int result8 = (result7 * 59) + ($nombrePrograma == null ? 43 : $nombrePrograma.hashCode());
        Object $fecha = getFecha();
        int result9 = (result8 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $idUsuarioS = getIdUsuarioS();
        return (result9 * 59) + ($idUsuarioS == null ? 43 : $idUsuarioS.hashCode());
    }

    @Generated
    public String toString() {
        return "RemisionExamenDTO(id=" + getId() + ", idEmpresaConvenio=" + getIdEmpresaConvenio() + ", nombreConvenio=" + getNombreConvenio() + ", idProcedimiento=" + getIdProcedimiento() + ", nombreProcedimiento=" + getNombreProcedimiento() + ", idTipoPrograma=" + getIdTipoPrograma() + ", nombrePrograma=" + getNombrePrograma() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ", idUsuarioS=" + getIdUsuarioS() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/RemisionExamenDTO$RemisionExamenDTOBuilder.class */
    @Generated
    public static class RemisionExamenDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idEmpresaConvenio;

        @Generated
        private String nombreConvenio;

        @Generated
        private Long idProcedimiento;

        @Generated
        private String nombreProcedimiento;

        @Generated
        private Integer idTipoPrograma;

        @Generated
        private String nombrePrograma;

        @Generated
        private Boolean estado;

        @Generated
        private LocalDateTime fecha;

        @Generated
        private String idUsuarioS;

        @Generated
        RemisionExamenDTOBuilder() {
        }

        @Generated
        public RemisionExamenDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder idEmpresaConvenio(Long idEmpresaConvenio) {
            this.idEmpresaConvenio = idEmpresaConvenio;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder nombreConvenio(String nombreConvenio) {
            this.nombreConvenio = nombreConvenio;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder idProcedimiento(Long idProcedimiento) {
            this.idProcedimiento = idProcedimiento;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder nombreProcedimiento(String nombreProcedimiento) {
            this.nombreProcedimiento = nombreProcedimiento;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder idTipoPrograma(Integer idTipoPrograma) {
            this.idTipoPrograma = idTipoPrograma;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder nombrePrograma(String nombrePrograma) {
            this.nombrePrograma = nombrePrograma;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public RemisionExamenDTOBuilder idUsuarioS(String idUsuarioS) {
            this.idUsuarioS = idUsuarioS;
            return this;
        }

        @Generated
        public RemisionExamenDTO build() {
            return new RemisionExamenDTO(this.id, this.idEmpresaConvenio, this.nombreConvenio, this.idProcedimiento, this.nombreProcedimiento, this.idTipoPrograma, this.nombrePrograma, this.estado, this.fecha, this.idUsuarioS);
        }

        @Generated
        public String toString() {
            return "RemisionExamenDTO.RemisionExamenDTOBuilder(id=" + this.id + ", idEmpresaConvenio=" + this.idEmpresaConvenio + ", nombreConvenio=" + this.nombreConvenio + ", idProcedimiento=" + this.idProcedimiento + ", nombreProcedimiento=" + this.nombreProcedimiento + ", idTipoPrograma=" + this.idTipoPrograma + ", nombrePrograma=" + this.nombrePrograma + ", estado=" + this.estado + ", fecha=" + this.fecha + ", idUsuarioS=" + this.idUsuarioS + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdEmpresaConvenio(Long idEmpresaConvenio) {
        this.idEmpresaConvenio = idEmpresaConvenio;
    }

    @Generated
    public void setNombreConvenio(String nombreConvenio) {
        this.nombreConvenio = nombreConvenio;
    }

    @Generated
    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Generated
    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    @Generated
    public void setIdTipoPrograma(Integer idTipoPrograma) {
        this.idTipoPrograma = idTipoPrograma;
    }

    @Generated
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
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
    public void setIdUsuarioS(String idUsuarioS) {
        this.idUsuarioS = idUsuarioS;
    }

    @Generated
    public static RemisionExamenDTOBuilder builder() {
        return new RemisionExamenDTOBuilder();
    }

    @Generated
    public RemisionExamenDTO(Long id, Long idEmpresaConvenio, String nombreConvenio, Long idProcedimiento, String nombreProcedimiento, Integer idTipoPrograma, String nombrePrograma, Boolean estado, LocalDateTime fecha, String idUsuarioS) {
        this.id = id;
        this.idEmpresaConvenio = idEmpresaConvenio;
        this.nombreConvenio = nombreConvenio;
        this.idProcedimiento = idProcedimiento;
        this.nombreProcedimiento = nombreProcedimiento;
        this.idTipoPrograma = idTipoPrograma;
        this.nombrePrograma = nombrePrograma;
        this.estado = estado;
        this.fecha = fecha;
        this.idUsuarioS = idUsuarioS;
    }

    @Generated
    public RemisionExamenDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdEmpresaConvenio() {
        return this.idEmpresaConvenio;
    }

    @Generated
    public String getNombreConvenio() {
        return this.nombreConvenio;
    }

    @Generated
    public Long getIdProcedimiento() {
        return this.idProcedimiento;
    }

    @Generated
    public String getNombreProcedimiento() {
        return this.nombreProcedimiento;
    }

    @Generated
    public Integer getIdTipoPrograma() {
        return this.idTipoPrograma;
    }

    @Generated
    public String getNombrePrograma() {
        return this.nombrePrograma;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public LocalDateTime getFecha() {
        return this.fecha;
    }

    @Generated
    public String getIdUsuarioS() {
        return this.idUsuarioS;
    }
}
