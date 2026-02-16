package com.genoma.plus.controller.laboratorio.dto;

import java.time.LocalDate;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/BitacoraEnvioRemisionDto.class */
public class BitacoraEnvioRemisionDto {
    private Long id;
    private Long idRemision;
    private Long idRecepcion;
    private LocalDate fechaRegistro;
    private ColcanResponseDTO responseDomain;
    private Boolean estado;
    private Long idUsuarioS;

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdRemision(Long idRemision) {
        this.idRemision = idRemision;
    }

    @Generated
    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Generated
    public void setResponseDomain(ColcanResponseDTO responseDomain) {
        this.responseDomain = responseDomain;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setIdUsuarioS(Long idUsuarioS) {
        this.idUsuarioS = idUsuarioS;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BitacoraEnvioRemisionDto)) {
            return false;
        }
        BitacoraEnvioRemisionDto other = (BitacoraEnvioRemisionDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$idRemision = getIdRemision();
        Object other$idRemision = other.getIdRemision();
        if (this$idRemision == null) {
            if (other$idRemision != null) {
                return false;
            }
        } else if (!this$idRemision.equals(other$idRemision)) {
            return false;
        }
        Object this$idRecepcion = getIdRecepcion();
        Object other$idRecepcion = other.getIdRecepcion();
        if (this$idRecepcion == null) {
            if (other$idRecepcion != null) {
                return false;
            }
        } else if (!this$idRecepcion.equals(other$idRecepcion)) {
            return false;
        }
        Object this$estado = getEstado();
        Object other$estado = other.getEstado();
        if (this$estado == null) {
            if (other$estado != null) {
                return false;
            }
        } else if (!this$estado.equals(other$estado)) {
            return false;
        }
        Object this$idUsuarioS = getIdUsuarioS();
        Object other$idUsuarioS = other.getIdUsuarioS();
        if (this$idUsuarioS == null) {
            if (other$idUsuarioS != null) {
                return false;
            }
        } else if (!this$idUsuarioS.equals(other$idUsuarioS)) {
            return false;
        }
        Object this$fechaRegistro = getFechaRegistro();
        Object other$fechaRegistro = other.getFechaRegistro();
        if (this$fechaRegistro == null) {
            if (other$fechaRegistro != null) {
                return false;
            }
        } else if (!this$fechaRegistro.equals(other$fechaRegistro)) {
            return false;
        }
        Object this$responseDomain = getResponseDomain();
        Object other$responseDomain = other.getResponseDomain();
        return this$responseDomain == null ? other$responseDomain == null : this$responseDomain.equals(other$responseDomain);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BitacoraEnvioRemisionDto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idRemision = getIdRemision();
        int result2 = (result * 59) + ($idRemision == null ? 43 : $idRemision.hashCode());
        Object $idRecepcion = getIdRecepcion();
        int result3 = (result2 * 59) + ($idRecepcion == null ? 43 : $idRecepcion.hashCode());
        Object $estado = getEstado();
        int result4 = (result3 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $idUsuarioS = getIdUsuarioS();
        int result5 = (result4 * 59) + ($idUsuarioS == null ? 43 : $idUsuarioS.hashCode());
        Object $fechaRegistro = getFechaRegistro();
        int result6 = (result5 * 59) + ($fechaRegistro == null ? 43 : $fechaRegistro.hashCode());
        Object $responseDomain = getResponseDomain();
        return (result6 * 59) + ($responseDomain == null ? 43 : $responseDomain.hashCode());
    }

    @Generated
    public String toString() {
        return "BitacoraEnvioRemisionDto(id=" + getId() + ", idRemision=" + getIdRemision() + ", idRecepcion=" + getIdRecepcion() + ", fechaRegistro=" + getFechaRegistro() + ", responseDomain=" + getResponseDomain() + ", estado=" + getEstado() + ", idUsuarioS=" + getIdUsuarioS() + ")";
    }

    @Generated
    public BitacoraEnvioRemisionDto(Long id, Long idRemision, Long idRecepcion, LocalDate fechaRegistro, ColcanResponseDTO responseDomain, Boolean estado, Long idUsuarioS) {
        this.id = id;
        this.idRemision = idRemision;
        this.idRecepcion = idRecepcion;
        this.fechaRegistro = fechaRegistro;
        this.responseDomain = responseDomain;
        this.estado = estado;
        this.idUsuarioS = idUsuarioS;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/BitacoraEnvioRemisionDto$BitacoraEnvioRemisionDtoBuilder.class */
    @Generated
    public static class BitacoraEnvioRemisionDtoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idRemision;

        @Generated
        private Long idRecepcion;

        @Generated
        private LocalDate fechaRegistro;

        @Generated
        private ColcanResponseDTO responseDomain;

        @Generated
        private Boolean estado;

        @Generated
        private Long idUsuarioS;

        @Generated
        BitacoraEnvioRemisionDtoBuilder() {
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder idRemision(Long idRemision) {
            this.idRemision = idRemision;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder idRecepcion(Long idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder fechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder responseDomain(ColcanResponseDTO responseDomain) {
            this.responseDomain = responseDomain;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDtoBuilder idUsuarioS(Long idUsuarioS) {
            this.idUsuarioS = idUsuarioS;
            return this;
        }

        @Generated
        public BitacoraEnvioRemisionDto build() {
            return new BitacoraEnvioRemisionDto(this.id, this.idRemision, this.idRecepcion, this.fechaRegistro, this.responseDomain, this.estado, this.idUsuarioS);
        }

        @Generated
        public String toString() {
            return "BitacoraEnvioRemisionDto.BitacoraEnvioRemisionDtoBuilder(id=" + this.id + ", idRemision=" + this.idRemision + ", idRecepcion=" + this.idRecepcion + ", fechaRegistro=" + this.fechaRegistro + ", responseDomain=" + this.responseDomain + ", estado=" + this.estado + ", idUsuarioS=" + this.idUsuarioS + ")";
        }
    }

    @Generated
    public BitacoraEnvioRemisionDto() {
    }

    @Generated
    public static BitacoraEnvioRemisionDtoBuilder builder() {
        return new BitacoraEnvioRemisionDtoBuilder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdRemision() {
        return this.idRemision;
    }

    @Generated
    public Long getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    @Generated
    public ColcanResponseDTO getResponseDomain() {
        return this.responseDomain;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Long getIdUsuarioS() {
        return this.idUsuarioS;
    }
}
