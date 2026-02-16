package com.genoma.plus.controller.gcuenta.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/InfoDataConvenio.class */
public class InfoDataConvenio {
    private String dateStart;
    private String dateEnd;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InfoDataConvenio)) {
            return false;
        }
        InfoDataConvenio other = (InfoDataConvenio) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dateStart = getDateStart();
        Object other$dateStart = other.getDateStart();
        if (this$dateStart == null) {
            if (other$dateStart != null) {
                return false;
            }
        } else if (!this$dateStart.equals(other$dateStart)) {
            return false;
        }
        Object this$dateEnd = getDateEnd();
        Object other$dateEnd = other.getDateEnd();
        return this$dateEnd == null ? other$dateEnd == null : this$dateEnd.equals(other$dateEnd);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InfoDataConvenio;
    }

    @Generated
    public int hashCode() {
        Object $dateStart = getDateStart();
        int result = (1 * 59) + ($dateStart == null ? 43 : $dateStart.hashCode());
        Object $dateEnd = getDateEnd();
        return (result * 59) + ($dateEnd == null ? 43 : $dateEnd.hashCode());
    }

    @Generated
    public String toString() {
        return "InfoDataConvenio(dateStart=" + getDateStart() + ", dateEnd=" + getDateEnd() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/InfoDataConvenio$InfoDataConvenioBuilder.class */
    @Generated
    public static class InfoDataConvenioBuilder {

        @Generated
        private String dateStart;

        @Generated
        private String dateEnd;

        @Generated
        InfoDataConvenioBuilder() {
        }

        @Generated
        public InfoDataConvenioBuilder dateStart(String dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        @Generated
        public InfoDataConvenioBuilder dateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        @Generated
        public InfoDataConvenio build() {
            return new InfoDataConvenio(this.dateStart, this.dateEnd);
        }

        @Generated
        public String toString() {
            return "InfoDataConvenio.InfoDataConvenioBuilder(dateStart=" + this.dateStart + ", dateEnd=" + this.dateEnd + ")";
        }
    }

    @Generated
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Generated
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Generated
    public static InfoDataConvenioBuilder builder() {
        return new InfoDataConvenioBuilder();
    }

    @Generated
    public InfoDataConvenio(String dateStart, String dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    @Generated
    public InfoDataConvenio() {
    }

    @Generated
    public String getDateStart() {
        return this.dateStart;
    }

    @Generated
    public String getDateEnd() {
        return this.dateEnd;
    }
}
