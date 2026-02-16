package com.genoma.plus.controller.laboratorio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanResponseDTO.class */
public class ColcanResponseDTO {

    @JsonProperty("IdProceso")
    private Integer idProceso;

    @JsonProperty("Mensaje")
    private String mensaje;

    @JsonProperty("IdRadicado")
    private Integer idRadicado;

    @JsonProperty("OidDocumento")
    private Integer oidDocumento;

    @JsonProperty("Archivo")
    private String archivo;

    @JsonProperty("CodigoError")
    private Integer codigoError;

    @JsonProperty("IdentificadorError")
    private String identificadorError;

    @JsonProperty("IdProceso")
    @Generated
    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    @JsonProperty("Mensaje")
    @Generated
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @JsonProperty("IdRadicado")
    @Generated
    public void setIdRadicado(Integer idRadicado) {
        this.idRadicado = idRadicado;
    }

    @JsonProperty("OidDocumento")
    @Generated
    public void setOidDocumento(Integer oidDocumento) {
        this.oidDocumento = oidDocumento;
    }

    @JsonProperty("Archivo")
    @Generated
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @JsonProperty("CodigoError")
    @Generated
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    @JsonProperty("IdentificadorError")
    @Generated
    public void setIdentificadorError(String identificadorError) {
        this.identificadorError = identificadorError;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColcanResponseDTO)) {
            return false;
        }
        ColcanResponseDTO other = (ColcanResponseDTO) o;
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
        Object this$idRadicado = getIdRadicado();
        Object other$idRadicado = other.getIdRadicado();
        if (this$idRadicado == null) {
            if (other$idRadicado != null) {
                return false;
            }
        } else if (!this$idRadicado.equals(other$idRadicado)) {
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
        return other instanceof ColcanResponseDTO;
    }

    @Generated
    public int hashCode() {
        Object $idProceso = getIdProceso();
        int result = (1 * 59) + ($idProceso == null ? 43 : $idProceso.hashCode());
        Object $idRadicado = getIdRadicado();
        int result2 = (result * 59) + ($idRadicado == null ? 43 : $idRadicado.hashCode());
        Object $oidDocumento = getOidDocumento();
        int result3 = (result2 * 59) + ($oidDocumento == null ? 43 : $oidDocumento.hashCode());
        Object $codigoError = getCodigoError();
        int result4 = (result3 * 59) + ($codigoError == null ? 43 : $codigoError.hashCode());
        Object $mensaje = getMensaje();
        int result5 = (result4 * 59) + ($mensaje == null ? 43 : $mensaje.hashCode());
        Object $archivo = getArchivo();
        int result6 = (result5 * 59) + ($archivo == null ? 43 : $archivo.hashCode());
        Object $identificadorError = getIdentificadorError();
        return (result6 * 59) + ($identificadorError == null ? 43 : $identificadorError.hashCode());
    }

    @Generated
    public String toString() {
        return "ColcanResponseDTO(idProceso=" + getIdProceso() + ", mensaje=" + getMensaje() + ", idRadicado=" + getIdRadicado() + ", oidDocumento=" + getOidDocumento() + ", archivo=" + getArchivo() + ", codigoError=" + getCodigoError() + ", identificadorError=" + getIdentificadorError() + ")";
    }

    @Generated
    public ColcanResponseDTO(Integer idProceso, String mensaje, Integer idRadicado, Integer oidDocumento, String archivo, Integer codigoError, String identificadorError) {
        this.idProceso = idProceso;
        this.mensaje = mensaje;
        this.idRadicado = idRadicado;
        this.oidDocumento = oidDocumento;
        this.archivo = archivo;
        this.codigoError = codigoError;
        this.identificadorError = identificadorError;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanResponseDTO$ColcanResponseDTOBuilder.class */
    @Generated
    public static class ColcanResponseDTOBuilder {

        @Generated
        private Integer idProceso;

        @Generated
        private String mensaje;

        @Generated
        private Integer idRadicado;

        @Generated
        private Integer oidDocumento;

        @Generated
        private String archivo;

        @Generated
        private Integer codigoError;

        @Generated
        private String identificadorError;

        @Generated
        ColcanResponseDTOBuilder() {
        }

        @JsonProperty("IdProceso")
        @Generated
        public ColcanResponseDTOBuilder idProceso(Integer idProceso) {
            this.idProceso = idProceso;
            return this;
        }

        @JsonProperty("Mensaje")
        @Generated
        public ColcanResponseDTOBuilder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        @JsonProperty("IdRadicado")
        @Generated
        public ColcanResponseDTOBuilder idRadicado(Integer idRadicado) {
            this.idRadicado = idRadicado;
            return this;
        }

        @JsonProperty("OidDocumento")
        @Generated
        public ColcanResponseDTOBuilder oidDocumento(Integer oidDocumento) {
            this.oidDocumento = oidDocumento;
            return this;
        }

        @JsonProperty("Archivo")
        @Generated
        public ColcanResponseDTOBuilder archivo(String archivo) {
            this.archivo = archivo;
            return this;
        }

        @JsonProperty("CodigoError")
        @Generated
        public ColcanResponseDTOBuilder codigoError(Integer codigoError) {
            this.codigoError = codigoError;
            return this;
        }

        @JsonProperty("IdentificadorError")
        @Generated
        public ColcanResponseDTOBuilder identificadorError(String identificadorError) {
            this.identificadorError = identificadorError;
            return this;
        }

        @Generated
        public ColcanResponseDTO build() {
            return new ColcanResponseDTO(this.idProceso, this.mensaje, this.idRadicado, this.oidDocumento, this.archivo, this.codigoError, this.identificadorError);
        }

        @Generated
        public String toString() {
            return "ColcanResponseDTO.ColcanResponseDTOBuilder(idProceso=" + this.idProceso + ", mensaje=" + this.mensaje + ", idRadicado=" + this.idRadicado + ", oidDocumento=" + this.oidDocumento + ", archivo=" + this.archivo + ", codigoError=" + this.codigoError + ", identificadorError=" + this.identificadorError + ")";
        }
    }

    @Generated
    public ColcanResponseDTO() {
    }

    @Generated
    public static ColcanResponseDTOBuilder builder() {
        return new ColcanResponseDTOBuilder();
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
    public Integer getIdRadicado() {
        return this.idRadicado;
    }

    @Generated
    public Integer getOidDocumento() {
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
