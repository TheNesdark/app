package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/CorreosConvenioDto.class */
public class CorreosConvenioDto {
    private Integer idModulo;
    private String area;
    private String correo;
    private Boolean estado;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/CorreosConvenioDto$CorreosConvenioDtoBuilder.class */
    @Generated
    public static class CorreosConvenioDtoBuilder {

        @Generated
        private Integer idModulo;

        @Generated
        private String area;

        @Generated
        private String correo;

        @Generated
        private Boolean estado;

        @Generated
        CorreosConvenioDtoBuilder() {
        }

        @Generated
        public CorreosConvenioDtoBuilder idModulo(Integer idModulo) {
            this.idModulo = idModulo;
            return this;
        }

        @Generated
        public CorreosConvenioDtoBuilder area(String area) {
            this.area = area;
            return this;
        }

        @Generated
        public CorreosConvenioDtoBuilder correo(String correo) {
            this.correo = correo;
            return this;
        }

        @Generated
        public CorreosConvenioDtoBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public CorreosConvenioDto build() {
            return new CorreosConvenioDto(this.idModulo, this.area, this.correo, this.estado);
        }

        @Generated
        public String toString() {
            return "CorreosConvenioDto.CorreosConvenioDtoBuilder(idModulo=" + this.idModulo + ", area=" + this.area + ", correo=" + this.correo + ", estado=" + this.estado + ")";
        }
    }

    @Generated
    public static CorreosConvenioDtoBuilder builder() {
        return new CorreosConvenioDtoBuilder();
    }

    @Generated
    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    @Generated
    public void setArea(String area) {
        this.area = area;
    }

    @Generated
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CorreosConvenioDto)) {
            return false;
        }
        CorreosConvenioDto other = (CorreosConvenioDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idModulo = getIdModulo();
        Object other$idModulo = other.getIdModulo();
        if (this$idModulo == null) {
            if (other$idModulo != null) {
                return false;
            }
        } else if (!this$idModulo.equals(other$idModulo)) {
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
        Object this$area = getArea();
        Object other$area = other.getArea();
        if (this$area == null) {
            if (other$area != null) {
                return false;
            }
        } else if (!this$area.equals(other$area)) {
            return false;
        }
        Object this$correo = getCorreo();
        Object other$correo = other.getCorreo();
        return this$correo == null ? other$correo == null : this$correo.equals(other$correo);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CorreosConvenioDto;
    }

    @Generated
    public int hashCode() {
        Object $idModulo = getIdModulo();
        int result = (1 * 59) + ($idModulo == null ? 43 : $idModulo.hashCode());
        Object $estado = getEstado();
        int result2 = (result * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $area = getArea();
        int result3 = (result2 * 59) + ($area == null ? 43 : $area.hashCode());
        Object $correo = getCorreo();
        return (result3 * 59) + ($correo == null ? 43 : $correo.hashCode());
    }

    @Generated
    public String toString() {
        return "CorreosConvenioDto(idModulo=" + getIdModulo() + ", area=" + getArea() + ", correo=" + getCorreo() + ", estado=" + getEstado() + ")";
    }

    @Generated
    public CorreosConvenioDto() {
    }

    @Generated
    public CorreosConvenioDto(Integer idModulo, String area, String correo, Boolean estado) {
        this.idModulo = idModulo;
        this.area = area;
        this.correo = correo;
        this.estado = estado;
    }

    @Generated
    public Integer getIdModulo() {
        return this.idModulo;
    }

    @Generated
    public String getArea() {
        return this.area;
    }

    @Generated
    public String getCorreo() {
        return this.correo;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }
}
