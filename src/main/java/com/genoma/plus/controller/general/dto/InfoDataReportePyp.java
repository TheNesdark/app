package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/InfoDataReportePyp.class */
public class InfoDataReportePyp {
    private String name;
    private Integer idModule;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InfoDataReportePyp)) {
            return false;
        }
        InfoDataReportePyp other = (InfoDataReportePyp) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idModule = getIdModule();
        Object other$idModule = other.getIdModule();
        if (this$idModule == null) {
            if (other$idModule != null) {
                return false;
            }
        } else if (!this$idModule.equals(other$idModule)) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InfoDataReportePyp;
    }

    @Generated
    public int hashCode() {
        Object $idModule = getIdModule();
        int result = (1 * 59) + ($idModule == null ? 43 : $idModule.hashCode());
        Object $name = getName();
        return (result * 59) + ($name == null ? 43 : $name.hashCode());
    }

    @Generated
    public String toString() {
        return "InfoDataReportePyp(name=" + getName() + ", idModule=" + getIdModule() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/InfoDataReportePyp$InfoDataReportePypBuilder.class */
    @Generated
    public static class InfoDataReportePypBuilder {

        @Generated
        private String name;

        @Generated
        private Integer idModule;

        @Generated
        InfoDataReportePypBuilder() {
        }

        @Generated
        public InfoDataReportePypBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public InfoDataReportePypBuilder idModule(Integer idModule) {
            this.idModule = idModule;
            return this;
        }

        @Generated
        public InfoDataReportePyp build() {
            return new InfoDataReportePyp(this.name, this.idModule);
        }

        @Generated
        public String toString() {
            return "InfoDataReportePyp.InfoDataReportePypBuilder(name=" + this.name + ", idModule=" + this.idModule + ")";
        }
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    @Generated
    public static InfoDataReportePypBuilder builder() {
        return new InfoDataReportePypBuilder();
    }

    @Generated
    public InfoDataReportePyp(String name, Integer idModule) {
        this.name = name;
        this.idModule = idModule;
    }

    @Generated
    public InfoDataReportePyp() {
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Integer getIdModule() {
        return this.idModule;
    }
}
