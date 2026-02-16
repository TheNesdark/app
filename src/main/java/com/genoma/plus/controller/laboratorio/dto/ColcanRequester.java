package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanRequester.class */
public class ColcanRequester {
    private Integer idProceso;
    private String mensaje;
    private Long oidDocumento;
    private String archivo;
    private Integer codigoError;
    private String identificadorError;

    @Generated
    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    @Generated
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Generated
    public void setOidDocumento(Long oidDocumento) {
        this.oidDocumento = oidDocumento;
    }

    @Generated
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Generated
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    @Generated
    public void setIdentificadorError(String identificadorError) {
        this.identificadorError = identificadorError;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColcanRequester)) {
            return false;
        }
        ColcanRequester other = (ColcanRequester) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idProceso = getIdProceso();
        Object other$idProceso = other.getIdProceso();
        if (this$idProceso == null) {
            if (other$idProceso != null) {
                return false;
            }
        } else if (!this$idProceso.equals(other$idProceso)) {
            return false;
        }
        Object this$oidDocumento = getOidDocumento();
        Object other$oidDocumento = other.getOidDocumento();
        if (this$oidDocumento == null) {
            if (other$oidDocumento != null) {
                return false;
            }
        } else if (!this$oidDocumento.equals(other$oidDocumento)) {
            return false;
        }
        Object this$codigoError = getCodigoError();
        Object other$codigoError = other.getCodigoError();
        if (this$codigoError == null) {
            if (other$codigoError != null) {
                return false;
            }
        } else if (!this$codigoError.equals(other$codigoError)) {
            return false;
        }
        Object this$mensaje = getMensaje();
        Object other$mensaje = other.getMensaje();
        if (this$mensaje == null) {
            if (other$mensaje != null) {
                return false;
            }
        } else if (!this$mensaje.equals(other$mensaje)) {
            return false;
        }
        Object this$archivo = getArchivo();
        Object other$archivo = other.getArchivo();
        if (this$archivo == null) {
            if (other$archivo != null) {
                return false;
            }
        } else if (!this$archivo.equals(other$archivo)) {
            return false;
        }
        Object this$identificadorError = getIdentificadorError();
        Object other$identificadorError = other.getIdentificadorError();
        return this$identificadorError == null ? other$identificadorError == null : this$identificadorError.equals(other$identificadorError);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ColcanRequester;
    }

    @Generated
    public int hashCode() {
        Object $idProceso = getIdProceso();
        int result = (1 * 59) + ($idProceso == null ? 43 : $idProceso.hashCode());
        Object $oidDocumento = getOidDocumento();
        int result2 = (result * 59) + ($oidDocumento == null ? 43 : $oidDocumento.hashCode());
        Object $codigoError = getCodigoError();
        int result3 = (result2 * 59) + ($codigoError == null ? 43 : $codigoError.hashCode());
        Object $mensaje = getMensaje();
        int result4 = (result3 * 59) + ($mensaje == null ? 43 : $mensaje.hashCode());
        Object $archivo = getArchivo();
        int result5 = (result4 * 59) + ($archivo == null ? 43 : $archivo.hashCode());
        Object $identificadorError = getIdentificadorError();
        return (result5 * 59) + ($identificadorError == null ? 43 : $identificadorError.hashCode());
    }

    @Generated
    public String toString() {
        return "ColcanRequester(idProceso=" + getIdProceso() + ", mensaje=" + getMensaje() + ", oidDocumento=" + getOidDocumento() + ", archivo=" + getArchivo() + ", codigoError=" + getCodigoError() + ", identificadorError=" + getIdentificadorError() + ")";
    }

    @Generated
    public ColcanRequester(Integer idProceso, String mensaje, Long oidDocumento, String archivo, Integer codigoError, String identificadorError) {
        this.idProceso = idProceso;
        this.mensaje = mensaje;
        this.oidDocumento = oidDocumento;
        this.archivo = archivo;
        this.codigoError = codigoError;
        this.identificadorError = identificadorError;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanRequester$ColcanRequesterBuilder.class */
    @Generated
    public static class ColcanRequesterBuilder {

        @Generated
        private Integer idProceso;

        @Generated
        private String mensaje;

        @Generated
        private Long oidDocumento;

        @Generated
        private String archivo;

        @Generated
        private Integer codigoError;

        @Generated
        private String identificadorError;

        @Generated
        ColcanRequesterBuilder() {
        }

        @Generated
        public ColcanRequesterBuilder idProceso(Integer idProceso) {
            this.idProceso = idProceso;
            return this;
        }

        @Generated
        public ColcanRequesterBuilder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        @Generated
        public ColcanRequesterBuilder oidDocumento(Long oidDocumento) {
            this.oidDocumento = oidDocumento;
            return this;
        }

        @Generated
        public ColcanRequesterBuilder archivo(String archivo) {
            this.archivo = archivo;
            return this;
        }

        @Generated
        public ColcanRequesterBuilder codigoError(Integer codigoError) {
            this.codigoError = codigoError;
            return this;
        }

        @Generated
        public ColcanRequesterBuilder identificadorError(String identificadorError) {
            this.identificadorError = identificadorError;
            return this;
        }

        @Generated
        public ColcanRequester build() {
            return new ColcanRequester(this.idProceso, this.mensaje, this.oidDocumento, this.archivo, this.codigoError, this.identificadorError);
        }

        @Generated
        public String toString() {
            return "ColcanRequester.ColcanRequesterBuilder(idProceso=" + this.idProceso + ", mensaje=" + this.mensaje + ", oidDocumento=" + this.oidDocumento + ", archivo=" + this.archivo + ", codigoError=" + this.codigoError + ", identificadorError=" + this.identificadorError + ")";
        }
    }

    @Generated
    public ColcanRequester() {
    }

    @Generated
    public static ColcanRequesterBuilder builder() {
        return new ColcanRequesterBuilder();
    }

    @Generated
    public Integer getIdProceso() {
        return this.idProceso;
    }

    @Generated
    public String getMensaje() {
        return this.mensaje;
    }

    @Generated
    public Long getOidDocumento() {
        return this.oidDocumento;
    }

    @Generated
    public String getArchivo() {
        return this.archivo;
    }

    @Generated
    public Integer getCodigoError() {
        return this.codigoError;
    }

    @Generated
    public String getIdentificadorError() {
        return this.identificadorError;
    }
}
