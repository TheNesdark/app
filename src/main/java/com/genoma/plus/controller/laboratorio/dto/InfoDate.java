package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoDate.class */
public class InfoDate {
    private String dateInit;
    private String dateEnd;
    private String idMunicipality;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InfoDate)) {
            return false;
        }
        InfoDate other = (InfoDate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dateInit = getDateInit();
        Object other$dateInit = other.getDateInit();
        if (this$dateInit == null) {
            if (other$dateInit != null) {
                return false;
            }
        } else if (!this$dateInit.equals(other$dateInit)) {
            return false;
        }
        Object this$dateEnd = getDateEnd();
        Object other$dateEnd = other.getDateEnd();
        if (this$dateEnd == null) {
            if (other$dateEnd != null) {
                return false;
            }
        } else if (!this$dateEnd.equals(other$dateEnd)) {
            return false;
        }
        Object this$idMunicipality = getIdMunicipality();
        Object other$idMunicipality = other.getIdMunicipality();
        return this$idMunicipality == null ? other$idMunicipality == null : this$idMunicipality.equals(other$idMunicipality);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InfoDate;
    }

    @Generated
    public int hashCode() {
        Object $dateInit = getDateInit();
        int result = (1 * 59) + ($dateInit == null ? 43 : $dateInit.hashCode());
        Object $dateEnd = getDateEnd();
        int result2 = (result * 59) + ($dateEnd == null ? 43 : $dateEnd.hashCode());
        Object $idMunicipality = getIdMunicipality();
        return (result2 * 59) + ($idMunicipality == null ? 43 : $idMunicipality.hashCode());
    }

    @Generated
    public String toString() {
        return "InfoDate(dateInit=" + getDateInit() + ", dateEnd=" + getDateEnd() + ", idMunicipality=" + getIdMunicipality() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoDate$InfoDateBuilder.class */
    @Generated
    public static class InfoDateBuilder {

        @Generated
        private String dateInit;

        @Generated
        private String dateEnd;

        @Generated
        private String idMunicipality;

        @Generated
        InfoDateBuilder() {
        }

        @Generated
        public InfoDateBuilder dateInit(String dateInit) {
            this.dateInit = dateInit;
            return this;
        }

        @Generated
        public InfoDateBuilder dateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        @Generated
        public InfoDateBuilder idMunicipality(String idMunicipality) {
            this.idMunicipality = idMunicipality;
            return this;
        }

        @Generated
        public InfoDate build() {
            return new InfoDate(this.dateInit, this.dateEnd, this.idMunicipality);
        }

        @Generated
        public String toString() {
            return "InfoDate.InfoDateBuilder(dateInit=" + this.dateInit + ", dateEnd=" + this.dateEnd + ", idMunicipality=" + this.idMunicipality + ")";
        }
    }

    @Generated
    public void setDateInit(String dateInit) {
        this.dateInit = dateInit;
    }

    @Generated
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Generated
    public void setIdMunicipality(String idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    @Generated
    public static InfoDateBuilder builder() {
        return new InfoDateBuilder();
    }

    @Generated
    public InfoDate(String dateInit, String dateEnd, String idMunicipality) {
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.idMunicipality = idMunicipality;
    }

    @Generated
    public InfoDate() {
    }

    @Generated
    public String getDateInit() {
        return this.dateInit;
    }

    @Generated
    public String getDateEnd() {
        return this.dateEnd;
    }

    @Generated
    public String getIdMunicipality() {
        return this.idMunicipality;
    }
}
