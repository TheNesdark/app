package com.genoma.plus.controller.laboratorio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.genoma.plus.controller.laboratorio.enums.ValidationType;
import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ValidationDTO.class */
public class ValidationDTO {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateTime;
    private Long idDetailReception;
    private Enum<ValidationType> validationTypeEnum;
    private String observation;
    private String user;
    private String cargo;
    private Boolean state;
    private String usuarioCreacion;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ValidationDTO)) {
            return false;
        }
        ValidationDTO other = (ValidationDTO) o;
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
        Object this$idDetailReception = getIdDetailReception();
        Object other$idDetailReception = other.getIdDetailReception();
        if (this$idDetailReception == null) {
            if (other$idDetailReception != null) {
                return false;
            }
        } else if (!this$idDetailReception.equals(other$idDetailReception)) {
            return false;
        }
        Object this$state = getState();
        Object other$state = other.getState();
        if (this$state == null) {
            if (other$state != null) {
                return false;
            }
        } else if (!this$state.equals(other$state)) {
            return false;
        }
        Object this$dateTime = getDateTime();
        Object other$dateTime = other.getDateTime();
        if (this$dateTime == null) {
            if (other$dateTime != null) {
                return false;
            }
        } else if (!this$dateTime.equals(other$dateTime)) {
            return false;
        }
        Object this$validationTypeEnum = getValidationTypeEnum();
        Object other$validationTypeEnum = other.getValidationTypeEnum();
        if (this$validationTypeEnum == null) {
            if (other$validationTypeEnum != null) {
                return false;
            }
        } else if (!this$validationTypeEnum.equals(other$validationTypeEnum)) {
            return false;
        }
        Object this$observation = getObservation();
        Object other$observation = other.getObservation();
        if (this$observation == null) {
            if (other$observation != null) {
                return false;
            }
        } else if (!this$observation.equals(other$observation)) {
            return false;
        }
        Object this$user = getUser();
        Object other$user = other.getUser();
        if (this$user == null) {
            if (other$user != null) {
                return false;
            }
        } else if (!this$user.equals(other$user)) {
            return false;
        }
        Object this$cargo = getCargo();
        Object other$cargo = other.getCargo();
        if (this$cargo == null) {
            if (other$cargo != null) {
                return false;
            }
        } else if (!this$cargo.equals(other$cargo)) {
            return false;
        }
        Object this$usuarioCreacion = getUsuarioCreacion();
        Object other$usuarioCreacion = other.getUsuarioCreacion();
        return this$usuarioCreacion == null ? other$usuarioCreacion == null : this$usuarioCreacion.equals(other$usuarioCreacion);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ValidationDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idDetailReception = getIdDetailReception();
        int result2 = (result * 59) + ($idDetailReception == null ? 43 : $idDetailReception.hashCode());
        Object $state = getState();
        int result3 = (result2 * 59) + ($state == null ? 43 : $state.hashCode());
        Object $dateTime = getDateTime();
        int result4 = (result3 * 59) + ($dateTime == null ? 43 : $dateTime.hashCode());
        Object $validationTypeEnum = getValidationTypeEnum();
        int result5 = (result4 * 59) + ($validationTypeEnum == null ? 43 : $validationTypeEnum.hashCode());
        Object $observation = getObservation();
        int result6 = (result5 * 59) + ($observation == null ? 43 : $observation.hashCode());
        Object $user = getUser();
        int result7 = (result6 * 59) + ($user == null ? 43 : $user.hashCode());
        Object $cargo = getCargo();
        int result8 = (result7 * 59) + ($cargo == null ? 43 : $cargo.hashCode());
        Object $usuarioCreacion = getUsuarioCreacion();
        return (result8 * 59) + ($usuarioCreacion == null ? 43 : $usuarioCreacion.hashCode());
    }

    @Generated
    public String toString() {
        return "ValidationDTO(id=" + getId() + ", dateTime=" + getDateTime() + ", idDetailReception=" + getIdDetailReception() + ", validationTypeEnum=" + getValidationTypeEnum() + ", observation=" + getObservation() + ", user=" + getUser() + ", cargo=" + getCargo() + ", state=" + getState() + ", usuarioCreacion=" + getUsuarioCreacion() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ValidationDTO$ValidationDTOBuilder.class */
    @Generated
    public static class ValidationDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private Date dateTime;

        @Generated
        private Long idDetailReception;

        @Generated
        private Enum<ValidationType> validationTypeEnum;

        @Generated
        private String observation;

        @Generated
        private String user;

        @Generated
        private String cargo;

        @Generated
        private Boolean state;

        @Generated
        private String usuarioCreacion;

        @Generated
        ValidationDTOBuilder() {
        }

        @Generated
        public ValidationDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        public ValidationDTOBuilder dateTime(Date dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        @Generated
        public ValidationDTOBuilder idDetailReception(Long idDetailReception) {
            this.idDetailReception = idDetailReception;
            return this;
        }

        @Generated
        public ValidationDTOBuilder validationTypeEnum(Enum<ValidationType> validationTypeEnum) {
            this.validationTypeEnum = validationTypeEnum;
            return this;
        }

        @Generated
        public ValidationDTOBuilder observation(String observation) {
            this.observation = observation;
            return this;
        }

        @Generated
        public ValidationDTOBuilder user(String user) {
            this.user = user;
            return this;
        }

        @Generated
        public ValidationDTOBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        @Generated
        public ValidationDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public ValidationDTOBuilder usuarioCreacion(String usuarioCreacion) {
            this.usuarioCreacion = usuarioCreacion;
            return this;
        }

        @Generated
        public ValidationDTO build() {
            return new ValidationDTO(this.id, this.dateTime, this.idDetailReception, this.validationTypeEnum, this.observation, this.user, this.cargo, this.state, this.usuarioCreacion);
        }

        @Generated
        public String toString() {
            return "ValidationDTO.ValidationDTOBuilder(id=" + this.id + ", dateTime=" + this.dateTime + ", idDetailReception=" + this.idDetailReception + ", validationTypeEnum=" + this.validationTypeEnum + ", observation=" + this.observation + ", user=" + this.user + ", cargo=" + this.cargo + ", state=" + this.state + ", usuarioCreacion=" + this.usuarioCreacion + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Generated
    public void setIdDetailReception(Long idDetailReception) {
        this.idDetailReception = idDetailReception;
    }

    @Generated
    public void setValidationTypeEnum(Enum<ValidationType> validationTypeEnum) {
        this.validationTypeEnum = validationTypeEnum;
    }

    @Generated
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Generated
    public void setUser(String user) {
        this.user = user;
    }

    @Generated
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    @Generated
    public static ValidationDTOBuilder builder() {
        return new ValidationDTOBuilder();
    }

    @Generated
    public ValidationDTO(Long id, Date dateTime, Long idDetailReception, Enum<ValidationType> validationTypeEnum, String observation, String user, String cargo, Boolean state, String usuarioCreacion) {
        this.id = id;
        this.dateTime = dateTime;
        this.idDetailReception = idDetailReception;
        this.validationTypeEnum = validationTypeEnum;
        this.observation = observation;
        this.user = user;
        this.cargo = cargo;
        this.state = state;
        this.usuarioCreacion = usuarioCreacion;
    }

    @Generated
    public ValidationDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Date getDateTime() {
        return this.dateTime;
    }

    @Generated
    public Long getIdDetailReception() {
        return this.idDetailReception;
    }

    @Generated
    public Enum<ValidationType> getValidationTypeEnum() {
        return this.validationTypeEnum;
    }

    @Generated
    public String getObservation() {
        return this.observation;
    }

    @Generated
    public String getUser() {
        return this.user;
    }

    @Generated
    public String getCargo() {
        return this.cargo;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }

    @Generated
    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }
}
