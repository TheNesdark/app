package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/MunicipalityDTO.class */
public class MunicipalityDTO {
    private Integer id;
    private String name;
    private Boolean state;
    private Integer idDpto;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/MunicipalityDTO$MunicipalityDTOBuilder.class */
    @Generated
    public static class MunicipalityDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String name;

        @Generated
        private Boolean state;

        @Generated
        private Integer idDpto;

        @Generated
        MunicipalityDTOBuilder() {
        }

        @Generated
        public MunicipalityDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public MunicipalityDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public MunicipalityDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public MunicipalityDTOBuilder idDpto(Integer idDpto) {
            this.idDpto = idDpto;
            return this;
        }

        @Generated
        public MunicipalityDTO build() {
            return new MunicipalityDTO(this.id, this.name, this.state, this.idDpto);
        }

        @Generated
        public String toString() {
            return "MunicipalityDTO.MunicipalityDTOBuilder(id=" + this.id + ", name=" + this.name + ", state=" + this.state + ", idDpto=" + this.idDpto + ")";
        }
    }

    @Generated
    public static MunicipalityDTOBuilder builder() {
        return new MunicipalityDTOBuilder();
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MunicipalityDTO)) {
            return false;
        }
        MunicipalityDTO other = (MunicipalityDTO) o;
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
        Object this$state = getState();
        Object other$state = other.getState();
        if (this$state == null) {
            if (other$state != null) {
                return false;
            }
        } else if (!this$state.equals(other$state)) {
            return false;
        }
        Object this$idDpto = getIdDpto();
        Object other$idDpto = other.getIdDpto();
        if (this$idDpto == null) {
            if (other$idDpto != null) {
                return false;
            }
        } else if (!this$idDpto.equals(other$idDpto)) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MunicipalityDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $state = getState();
        int result2 = (result * 59) + ($state == null ? 43 : $state.hashCode());
        Object $idDpto = getIdDpto();
        int result3 = (result2 * 59) + ($idDpto == null ? 43 : $idDpto.hashCode());
        Object $name = getName();
        return (result3 * 59) + ($name == null ? 43 : $name.hashCode());
    }

    @Generated
    public String toString() {
        return "MunicipalityDTO(id=" + getId() + ", name=" + getName() + ", state=" + getState() + ", idDpto=" + getIdDpto() + ")";
    }

    @Generated
    public MunicipalityDTO() {
    }

    @Generated
    public MunicipalityDTO(Integer id, String name, Boolean state, Integer idDpto) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.idDpto = idDpto;
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }

    @Generated
    public Integer getIdDpto() {
        return this.idDpto;
    }
}
