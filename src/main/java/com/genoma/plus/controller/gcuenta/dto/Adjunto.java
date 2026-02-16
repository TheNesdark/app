package com.genoma.plus.controller.gcuenta.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/Adjunto.class */
public class Adjunto {
    private String fileName;
    private String base64;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/Adjunto$AdjuntoBuilder.class */
    @Generated
    public static class AdjuntoBuilder {

        @Generated
        private String fileName;

        @Generated
        private String base64;

        @Generated
        AdjuntoBuilder() {
        }

        @Generated
        public AdjuntoBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        @Generated
        public AdjuntoBuilder base64(String base64) {
            this.base64 = base64;
            return this;
        }

        @Generated
        public Adjunto build() {
            return new Adjunto(this.fileName, this.base64);
        }

        @Generated
        public String toString() {
            return "Adjunto.AdjuntoBuilder(fileName=" + this.fileName + ", base64=" + this.base64 + ")";
        }
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Adjunto)) {
            return false;
        }
        Adjunto other = (Adjunto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fileName = getFileName();
        Object other$fileName = other.getFileName();
        if (this$fileName == null) {
            if (other$fileName != null) {
                return false;
            }
        } else if (!this$fileName.equals(other$fileName)) {
            return false;
        }
        Object this$base64 = getBase64();
        Object other$base64 = other.getBase64();
        return this$base64 == null ? other$base64 == null : this$base64.equals(other$base64);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Adjunto;
    }

    @Generated
    public int hashCode() {
        Object $fileName = getFileName();
        int result = (1 * 59) + ($fileName == null ? 43 : $fileName.hashCode());
        Object $base64 = getBase64();
        return (result * 59) + ($base64 == null ? 43 : $base64.hashCode());
    }

    @Generated
    public String toString() {
        return "Adjunto(fileName=" + getFileName() + ", base64=" + getBase64() + ")";
    }

    @Generated
    public static AdjuntoBuilder builder() {
        return new AdjuntoBuilder();
    }

    @Generated
    public Adjunto(String fileName, String base64) {
        this.fileName = fileName;
        this.base64 = base64;
    }

    @Generated
    public Adjunto() {
    }

    @Generated
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Generated
    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Generated
    public String getFileName() {
        return this.fileName;
    }

    @Generated
    public String getBase64() {
        return this.base64;
    }
}
