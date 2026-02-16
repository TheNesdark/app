package com.genoma.plus.controller.laboratorio.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/WrapperColocanDto.class */
public class WrapperColocanDto {
    private List<ColcanDto> colcan;

    @Generated
    public void setColcan(List<ColcanDto> colcan) {
        this.colcan = colcan;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WrapperColocanDto)) {
            return false;
        }
        WrapperColocanDto other = (WrapperColocanDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$colcan = getColcan();
        Object other$colcan = other.getColcan();
        return this$colcan == null ? other$colcan == null : this$colcan.equals(other$colcan);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof WrapperColocanDto;
    }

    @Generated
    public int hashCode() {
        Object $colcan = getColcan();
        int result = (1 * 59) + ($colcan == null ? 43 : $colcan.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "WrapperColocanDto(colcan=" + getColcan() + ")";
    }

    @Generated
    public WrapperColocanDto(List<ColcanDto> colcan) {
        this.colcan = colcan;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/WrapperColocanDto$WrapperColocanDtoBuilder.class */
    @Generated
    public static class WrapperColocanDtoBuilder {

        @Generated
        private List<ColcanDto> colcan;

        @Generated
        WrapperColocanDtoBuilder() {
        }

        @Generated
        public WrapperColocanDtoBuilder colcan(List<ColcanDto> colcan) {
            this.colcan = colcan;
            return this;
        }

        @Generated
        public WrapperColocanDto build() {
            return new WrapperColocanDto(this.colcan);
        }

        @Generated
        public String toString() {
            return "WrapperColocanDto.WrapperColocanDtoBuilder(colcan=" + this.colcan + ")";
        }
    }

    @Generated
    public WrapperColocanDto() {
    }

    @Generated
    public static WrapperColocanDtoBuilder builder() {
        return new WrapperColocanDtoBuilder();
    }

    @Generated
    public List<ColcanDto> getColcan() {
        return this.colcan;
    }
}
