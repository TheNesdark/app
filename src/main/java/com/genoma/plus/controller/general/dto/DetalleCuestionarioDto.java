package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/DetalleCuestionarioDto.class */
public class DetalleCuestionarioDto {
    private String pregunta;
    private String respuesta;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/DetalleCuestionarioDto$DetalleCuestionarioDtoBuilder.class */
    @Generated
    public static class DetalleCuestionarioDtoBuilder {

        @Generated
        private String pregunta;

        @Generated
        private String respuesta;

        @Generated
        DetalleCuestionarioDtoBuilder() {
        }

        @Generated
        public DetalleCuestionarioDtoBuilder pregunta(String pregunta) {
            this.pregunta = pregunta;
            return this;
        }

        @Generated
        public DetalleCuestionarioDtoBuilder respuesta(String respuesta) {
            this.respuesta = respuesta;
            return this;
        }

        @Generated
        public DetalleCuestionarioDto build() {
            return new DetalleCuestionarioDto(this.pregunta, this.respuesta);
        }

        @Generated
        public String toString() {
            return "DetalleCuestionarioDto.DetalleCuestionarioDtoBuilder(pregunta=" + this.pregunta + ", respuesta=" + this.respuesta + ")";
        }
    }

    @Generated
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Generated
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DetalleCuestionarioDto)) {
            return false;
        }
        DetalleCuestionarioDto other = (DetalleCuestionarioDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pregunta = getPregunta();
        Object other$pregunta = other.getPregunta();
        if (this$pregunta == null) {
            if (other$pregunta != null) {
                return false;
            }
        } else if (!this$pregunta.equals(other$pregunta)) {
            return false;
        }
        Object this$respuesta = getRespuesta();
        Object other$respuesta = other.getRespuesta();
        return this$respuesta == null ? other$respuesta == null : this$respuesta.equals(other$respuesta);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DetalleCuestionarioDto;
    }

    @Generated
    public int hashCode() {
        Object $pregunta = getPregunta();
        int result = (1 * 59) + ($pregunta == null ? 43 : $pregunta.hashCode());
        Object $respuesta = getRespuesta();
        return (result * 59) + ($respuesta == null ? 43 : $respuesta.hashCode());
    }

    @Generated
    public String toString() {
        return "DetalleCuestionarioDto(pregunta=" + getPregunta() + ", respuesta=" + getRespuesta() + ")";
    }

    @Generated
    public static DetalleCuestionarioDtoBuilder builder() {
        return new DetalleCuestionarioDtoBuilder();
    }

    @Generated
    public DetalleCuestionarioDto() {
    }

    @Generated
    public DetalleCuestionarioDto(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    @Generated
    public String getPregunta() {
        return this.pregunta;
    }

    @Generated
    public String getRespuesta() {
        return this.respuesta;
    }
}
