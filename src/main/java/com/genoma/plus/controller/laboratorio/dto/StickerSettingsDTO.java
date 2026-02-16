package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/StickerSettingsDTO.class */
public class StickerSettingsDTO {
    private Integer id;
    private String namePrinter;
    private String pcName;
    private String codeZPL;
    private Integer amount;
    private Boolean state;
    private String query;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/StickerSettingsDTO$StickerSettingsDTOBuilder.class */
    @Generated
    public static class StickerSettingsDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String namePrinter;

        @Generated
        private String pcName;

        @Generated
        private String codeZPL;

        @Generated
        private Integer amount;

        @Generated
        private Boolean state;

        @Generated
        private String query;

        @Generated
        StickerSettingsDTOBuilder() {
        }

        @Generated
        public StickerSettingsDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder namePrinter(String namePrinter) {
            this.namePrinter = namePrinter;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder pcName(String pcName) {
            this.pcName = pcName;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder codeZPL(String codeZPL) {
            this.codeZPL = codeZPL;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public StickerSettingsDTOBuilder query(String query) {
            this.query = query;
            return this;
        }

        @Generated
        public StickerSettingsDTO build() {
            return new StickerSettingsDTO(this.id, this.namePrinter, this.pcName, this.codeZPL, this.amount, this.state, this.query);
        }

        @Generated
        public String toString() {
            return "StickerSettingsDTO.StickerSettingsDTOBuilder(id=" + this.id + ", namePrinter=" + this.namePrinter + ", pcName=" + this.pcName + ", codeZPL=" + this.codeZPL + ", amount=" + this.amount + ", state=" + this.state + ", query=" + this.query + ")";
        }
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setNamePrinter(String namePrinter) {
        this.namePrinter = namePrinter;
    }

    @Generated
    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    @Generated
    public void setCodeZPL(String codeZPL) {
        this.codeZPL = codeZPL;
    }

    @Generated
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public void setQuery(String query) {
        this.query = query;
    }

    @Generated
    public static StickerSettingsDTOBuilder builder() {
        return new StickerSettingsDTOBuilder();
    }

    @Generated
    public StickerSettingsDTO(Integer id, String namePrinter, String pcName, String codeZPL, Integer amount, Boolean state, String query) {
        this.id = id;
        this.namePrinter = namePrinter;
        this.pcName = pcName;
        this.codeZPL = codeZPL;
        this.amount = amount;
        this.state = state;
        this.query = query;
    }

    @Generated
    public StickerSettingsDTO() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getNamePrinter() {
        return this.namePrinter;
    }

    @Generated
    public String getPcName() {
        return this.pcName;
    }

    @Generated
    public String getCodeZPL() {
        return this.codeZPL;
    }

    @Generated
    public Integer getAmount() {
        return this.amount;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }

    @Generated
    public String getQuery() {
        return this.query;
    }
}
