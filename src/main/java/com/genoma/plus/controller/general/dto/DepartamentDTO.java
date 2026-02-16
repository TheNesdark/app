package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/DepartamentDTO.class */
public class DepartamentDTO {
    private Integer id;
    private String name;
    private Boolean state;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/DepartamentDTO$DepartamentDTOBuilder.class */
    @Generated
    public static class DepartamentDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String name;

        @Generated
        private Boolean state;

        @Generated
        DepartamentDTOBuilder() {
        }

        @Generated
        public DepartamentDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public DepartamentDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public DepartamentDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public DepartamentDTO build() {
            return new DepartamentDTO(this.id, this.name, this.state);
        }

        @Generated
        public String toString() {
            return "DepartamentDTO.DepartamentDTOBuilder(id=" + this.id + ", name=" + this.name + ", state=" + this.state + ")";
        }
    }

    @Generated
    public static DepartamentDTOBuilder builder() {
        return new DepartamentDTOBuilder();
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DepartamentDTO)) {
            return false;
        }
        DepartamentDTO other = (DepartamentDTO) o;
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
        Object this$name = getName();
        Object other$name = other.getName();
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DepartamentDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $state = getState();
        int result2 = (result * 59) + ($state == null ? 43 : $state.hashCode());
        Object $name = getName();
        return (result2 * 59) + ($name == null ? 43 : $name.hashCode());
    }

    @Generated
    public String toString() {
        return "DepartamentDTO(id=" + getId() + ", name=" + getName() + ", state=" + getState() + ")";
    }

    @Generated
    public DepartamentDTO() {
    }

    @Generated
    public DepartamentDTO(Integer id, String name, Boolean state) {
        this.id = id;
        this.name = name;
        this.state = state;
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
}
