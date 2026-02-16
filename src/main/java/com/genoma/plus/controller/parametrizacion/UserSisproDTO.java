package com.genoma.plus.controller.parametrizacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/UserSisproDTO.class */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSisproDTO {
    private Long id;
    private Long idPersona;
    private String clave;
    private Boolean tipoMecanismoValidacion;
    private Boolean reps;
    private Boolean estado;
    private String idUsuarioS;
    private Date fecha;
    private String tipoDocumento;
    private String documento;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UserSisproDTO)) {
            return false;
        }
        UserSisproDTO other = (UserSisproDTO) o;
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
        Object this$idPersona = getIdPersona();
        Object other$idPersona = other.getIdPersona();
        if (this$idPersona == null) {
            if (other$idPersona != null) {
                return false;
            }
        } else if (!this$idPersona.equals(other$idPersona)) {
            return false;
        }
        Object this$tipoMecanismoValidacion = getTipoMecanismoValidacion();
        Object other$tipoMecanismoValidacion = other.getTipoMecanismoValidacion();
        if (this$tipoMecanismoValidacion == null) {
            if (other$tipoMecanismoValidacion != null) {
                return false;
            }
        } else if (!this$tipoMecanismoValidacion.equals(other$tipoMecanismoValidacion)) {
            return false;
        }
        Object this$reps = getReps();
        Object other$reps = other.getReps();
        if (this$reps == null) {
            if (other$reps != null) {
                return false;
            }
        } else if (!this$reps.equals(other$reps)) {
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
        Object this$clave = getClave();
        Object other$clave = other.getClave();
        if (this$clave == null) {
            if (other$clave != null) {
                return false;
            }
        } else if (!this$clave.equals(other$clave)) {
            return false;
        }
        Object this$idUsuarioS = getIdUsuarioS();
        Object other$idUsuarioS = other.getIdUsuarioS();
        if (this$idUsuarioS == null) {
            if (other$idUsuarioS != null) {
                return false;
            }
        } else if (!this$idUsuarioS.equals(other$idUsuarioS)) {
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
        Object this$tipoDocumento = getTipoDocumento();
        Object other$tipoDocumento = other.getTipoDocumento();
        if (this$tipoDocumento == null) {
            if (other$tipoDocumento != null) {
                return false;
            }
        } else if (!this$tipoDocumento.equals(other$tipoDocumento)) {
            return false;
        }
        Object this$documento = getDocumento();
        Object other$documento = other.getDocumento();
        return this$documento == null ? other$documento == null : this$documento.equals(other$documento);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UserSisproDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idPersona = getIdPersona();
        int result2 = (result * 59) + ($idPersona == null ? 43 : $idPersona.hashCode());
        Object $tipoMecanismoValidacion = getTipoMecanismoValidacion();
        int result3 = (result2 * 59) + ($tipoMecanismoValidacion == null ? 43 : $tipoMecanismoValidacion.hashCode());
        Object $reps = getReps();
        int result4 = (result3 * 59) + ($reps == null ? 43 : $reps.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $clave = getClave();
        int result6 = (result5 * 59) + ($clave == null ? 43 : $clave.hashCode());
        Object $idUsuarioS = getIdUsuarioS();
        int result7 = (result6 * 59) + ($idUsuarioS == null ? 43 : $idUsuarioS.hashCode());
        Object $fecha = getFecha();
        int result8 = (result7 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $tipoDocumento = getTipoDocumento();
        int result9 = (result8 * 59) + ($tipoDocumento == null ? 43 : $tipoDocumento.hashCode());
        Object $documento = getDocumento();
        return (result9 * 59) + ($documento == null ? 43 : $documento.hashCode());
    }

    @Generated
    public String toString() {
        return "UserSisproDTO(id=" + getId() + ", idPersona=" + getIdPersona() + ", clave=" + getClave() + ", tipoMecanismoValidacion=" + getTipoMecanismoValidacion() + ", reps=" + getReps() + ", estado=" + getEstado() + ", idUsuarioS=" + getIdUsuarioS() + ", fecha=" + getFecha() + ", tipoDocumento=" + getTipoDocumento() + ", documento=" + getDocumento() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/UserSisproDTO$UserSisproDTOBuilder.class */
    @Generated
    public static class UserSisproDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idPersona;

        @Generated
        private String clave;

        @Generated
        private Boolean tipoMecanismoValidacion;

        @Generated
        private Boolean reps;

        @Generated
        private Boolean estado;

        @Generated
        private String idUsuarioS;

        @Generated
        private Date fecha;

        @Generated
        private String tipoDocumento;

        @Generated
        private String documento;

        @Generated
        UserSisproDTOBuilder() {
        }

        @Generated
        public UserSisproDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder idPersona(Long idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder clave(String clave) {
            this.clave = clave;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder tipoMecanismoValidacion(Boolean tipoMecanismoValidacion) {
            this.tipoMecanismoValidacion = tipoMecanismoValidacion;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder reps(Boolean reps) {
            this.reps = reps;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder idUsuarioS(String idUsuarioS) {
            this.idUsuarioS = idUsuarioS;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder tipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }

        @Generated
        public UserSisproDTOBuilder documento(String documento) {
            this.documento = documento;
            return this;
        }

        @Generated
        public UserSisproDTO build() {
            return new UserSisproDTO(this.id, this.idPersona, this.clave, this.tipoMecanismoValidacion, this.reps, this.estado, this.idUsuarioS, this.fecha, this.tipoDocumento, this.documento);
        }

        @Generated
        public String toString() {
            return "UserSisproDTO.UserSisproDTOBuilder(id=" + this.id + ", idPersona=" + this.idPersona + ", clave=" + this.clave + ", tipoMecanismoValidacion=" + this.tipoMecanismoValidacion + ", reps=" + this.reps + ", estado=" + this.estado + ", idUsuarioS=" + this.idUsuarioS + ", fecha=" + this.fecha + ", tipoDocumento=" + this.tipoDocumento + ", documento=" + this.documento + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Generated
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Generated
    public void setTipoMecanismoValidacion(Boolean tipoMecanismoValidacion) {
        this.tipoMecanismoValidacion = tipoMecanismoValidacion;
    }

    @Generated
    public void setReps(Boolean reps) {
        this.reps = reps;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setIdUsuarioS(String idUsuarioS) {
        this.idUsuarioS = idUsuarioS;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Generated
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Generated
    public static UserSisproDTOBuilder builder() {
        return new UserSisproDTOBuilder();
    }

    @Generated
    public UserSisproDTO(Long id, Long idPersona, String clave, Boolean tipoMecanismoValidacion, Boolean reps, Boolean estado, String idUsuarioS, Date fecha, String tipoDocumento, String documento) {
        this.id = id;
        this.idPersona = idPersona;
        this.clave = clave;
        this.tipoMecanismoValidacion = tipoMecanismoValidacion;
        this.reps = reps;
        this.estado = estado;
        this.idUsuarioS = idUsuarioS;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    @Generated
    public UserSisproDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdPersona() {
        return this.idPersona;
    }

    @Generated
    public String getClave() {
        return this.clave;
    }

    @Generated
    public Boolean getTipoMecanismoValidacion() {
        return this.tipoMecanismoValidacion;
    }

    @Generated
    public Boolean getReps() {
        return this.reps;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public String getIdUsuarioS() {
        return this.idUsuarioS;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    @Generated
    public String getDocumento() {
        return this.documento;
    }
}
