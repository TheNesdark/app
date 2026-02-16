package com.genoma.plus.controller.gcuenta.dto;

import com.genoma.plus.controller.general.dto.CorreosConvenioDto;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/ConvenioDTO.class */
public class ConvenioDTO {
    private Integer id;
    private String name;
    private List<CorreosConvenioDto> metadataDomain;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/ConvenioDTO$ConvenioDTOBuilder.class */
    @Generated
    public static class ConvenioDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String name;

        @Generated
        private List<CorreosConvenioDto> metadataDomain;

        @Generated
        ConvenioDTOBuilder() {
        }

        @Generated
        public ConvenioDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public ConvenioDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public ConvenioDTOBuilder metadataDomain(List<CorreosConvenioDto> metadataDomain) {
            this.metadataDomain = metadataDomain;
            return this;
        }

        @Generated
        public ConvenioDTO build() {
            return new ConvenioDTO(this.id, this.name, this.metadataDomain);
        }

        @Generated
        public String toString() {
            return "ConvenioDTO.ConvenioDTOBuilder(id=" + this.id + ", name=" + this.name + ", metadataDomain=" + this.metadataDomain + ")";
        }
    }

    @Generated
    public static ConvenioDTOBuilder builder() {
        return new ConvenioDTOBuilder();
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConvenioDTO)) {
            return false;
        }
        ConvenioDTO other = (ConvenioDTO) o;
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
        return other instanceof ConvenioDTO;
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
        return "ConvenioDTO(id=" + getId() + ", name=" + getName() + ", metadataDomain=" + getMetadataDomain() + ")";
    }

    @Generated
    public ConvenioDTO() {
    }

    @Generated
    public ConvenioDTO(Integer id, String name, List<CorreosConvenioDto> metadataDomain) {
        this.id = id;
        this.name = name;
        this.metadataDomain = metadataDomain;
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
    public void setMetadataDomain(List<CorreosConvenioDto> metadataDomain) {
        this.metadataDomain = metadataDomain;
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
    public List<CorreosConvenioDto> getMetadataDomain() {
        return this.metadataDomain;
    }
}
