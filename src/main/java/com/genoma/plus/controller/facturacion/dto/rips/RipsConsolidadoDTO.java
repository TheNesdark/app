package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/RipsConsolidadoDTO.class */
public class RipsConsolidadoDTO {
    private TransaccionDTO rips;
    private String xmlFevFile;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/RipsConsolidadoDTO$RipsConsolidadoDTOBuilder.class */
    @Generated
    public static class RipsConsolidadoDTOBuilder {

        @Generated
        private TransaccionDTO rips;

        @Generated
        private String xmlFevFile;

        @Generated
        RipsConsolidadoDTOBuilder() {
        }

        @Generated
        public RipsConsolidadoDTOBuilder rips(TransaccionDTO rips) {
            this.rips = rips;
            return this;
        }

        @Generated
        public RipsConsolidadoDTOBuilder xmlFevFile(String xmlFevFile) {
            this.xmlFevFile = xmlFevFile;
            return this;
        }

        @Generated
        public RipsConsolidadoDTO build() {
            return new RipsConsolidadoDTO(this.rips, this.xmlFevFile);
        }

        @Generated
        public String toString() {
            return "RipsConsolidadoDTO.RipsConsolidadoDTOBuilder(rips=" + this.rips + ", xmlFevFile=" + this.xmlFevFile + ")";
        }
    }

    @Generated
    public void setRips(TransaccionDTO rips) {
        this.rips = rips;
    }

    @Generated
    public void setXmlFevFile(String xmlFevFile) {
        this.xmlFevFile = xmlFevFile;
    }

    @Generated
    public static RipsConsolidadoDTOBuilder builder() {
        return new RipsConsolidadoDTOBuilder();
    }

    @Generated
    public RipsConsolidadoDTO(TransaccionDTO rips, String xmlFevFile) {
        this.rips = rips;
        this.xmlFevFile = xmlFevFile;
    }

    @Generated
    public RipsConsolidadoDTO() {
    }

    @Generated
    public TransaccionDTO getRips() {
        return this.rips;
    }

    @Generated
    public String getXmlFevFile() {
        return this.xmlFevFile;
    }
}
