package com.genoma.plus.controller.laboratorio.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/StickerPrintDto.class */
public class StickerPrintDto {
    private String namePrinter;
    private List<String> listCodesZPL;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/StickerPrintDto$StickerPrintDtoBuilder.class */
    @Generated
    public static class StickerPrintDtoBuilder {

        @Generated
        private String namePrinter;

        @Generated
        private List<String> listCodesZPL;

        @Generated
        StickerPrintDtoBuilder() {
        }

        @Generated
        public StickerPrintDtoBuilder namePrinter(String namePrinter) {
            this.namePrinter = namePrinter;
            return this;
        }

        @Generated
        public StickerPrintDtoBuilder listCodesZPL(List<String> listCodesZPL) {
            this.listCodesZPL = listCodesZPL;
            return this;
        }

        @Generated
        public StickerPrintDto build() {
            return new StickerPrintDto(this.namePrinter, this.listCodesZPL);
        }

        @Generated
        public String toString() {
            return "StickerPrintDto.StickerPrintDtoBuilder(namePrinter=" + this.namePrinter + ", listCodesZPL=" + this.listCodesZPL + ")";
        }
    }

    @Generated
    public void setNamePrinter(String namePrinter) {
        this.namePrinter = namePrinter;
    }

    @Generated
    public void setListCodesZPL(List<String> listCodesZPL) {
        this.listCodesZPL = listCodesZPL;
    }

    @Generated
    public static StickerPrintDtoBuilder builder() {
        return new StickerPrintDtoBuilder();
    }

    @Generated
    public StickerPrintDto(String namePrinter, List<String> listCodesZPL) {
        this.namePrinter = namePrinter;
        this.listCodesZPL = listCodesZPL;
    }

    @Generated
    public StickerPrintDto() {
    }

    @Generated
    public String getNamePrinter() {
        return this.namePrinter;
    }

    @Generated
    public List<String> getListCodesZPL() {
        return this.listCodesZPL;
    }
}
