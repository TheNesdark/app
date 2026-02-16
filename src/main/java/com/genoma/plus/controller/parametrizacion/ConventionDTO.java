package com.genoma.plus.controller.parametrizacion;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ConventionDTO.class */
public class ConventionDTO {
    private Integer id;
    private String name;
    private List<CorreosConvenioDTO> metadataDomain;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ConventionDTO$ConventionDTOBuilder.class */
    @Generated
    public static class ConventionDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String name;

        @Generated
        private List<CorreosConvenioDTO> metadataDomain;

        @Generated
        ConventionDTOBuilder() {
        }

        @Generated
        public ConventionDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public ConventionDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public ConventionDTOBuilder metadataDomain(List<CorreosConvenioDTO> metadataDomain) {
            this.metadataDomain = metadataDomain;
            return this;
        }

        @Generated
        public ConventionDTO build() {
            return new ConventionDTO(this.id, this.name, this.metadataDomain);
        }

        @Generated
        public String toString() {
            return "ConventionDTO.ConventionDTOBuilder(id=" + this.id + ", name=" + this.name + ", metadataDomain=" + this.metadataDomain + ")";
        }
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
    public void setMetadataDomain(List<CorreosConvenioDTO> metadataDomain) {
        this.metadataDomain = metadataDomain;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConventionDTO)) {
            return false;
        }
        ConventionDTO other = (ConventionDTO) o;
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
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$metadataDomain = getMetadataDomain();
        Object other$metadataDomain = other.getMetadataDomain();
        return this$metadataDomain == null ? other$metadataDomain == null : this$metadataDomain.equals(other$metadataDomain);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ConventionDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $name = getName();
        int result2 = (result * 59) + ($name == null ? 43 : $name.hashCode());
        Object $metadataDomain = getMetadataDomain();
        return (result2 * 59) + ($metadataDomain == null ? 43 : $metadataDomain.hashCode());
    }

    @Generated
    public String toString() {
        return "ConventionDTO(id=" + getId() + ", name=" + getName() + ", metadataDomain=" + getMetadataDomain() + ")";
    }

    @Generated
    public static ConventionDTOBuilder builder() {
        return new ConventionDTOBuilder();
    }

    @Generated
    public ConventionDTO(Integer id, String name, List<CorreosConvenioDTO> metadataDomain) {
        this.id = id;
        this.name = name;
        this.metadataDomain = metadataDomain;
    }

    @Generated
    public ConventionDTO() {
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
    public List<CorreosConvenioDTO> getMetadataDomain() {
        return this.metadataDomain;
    }
}
