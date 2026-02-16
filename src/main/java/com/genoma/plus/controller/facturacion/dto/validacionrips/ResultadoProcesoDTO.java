package com.genoma.plus.controller.facturacion.dto.validacionrips;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoProcesoDTO.class */
public class ResultadoProcesoDTO {
    private boolean resultState;
    private int procesoId;
    private String numFactura;
    private String codigoUnicoValidacion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String codigoUnicoValidacionToShow;
    private String fechaRadicacion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String rutaArchivos;
    private List<ResultadoValidacionDTO> resultadosValidacion;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/ResultadoProcesoDTO$ResultadoProcesoDTOBuilder.class */
    @Generated
    public static class ResultadoProcesoDTOBuilder {

        @Generated
        private boolean resultState;

        @Generated
        private int procesoId;

        @Generated
        private String numFactura;

        @Generated
        private String codigoUnicoValidacion;

        @Generated
        private String codigoUnicoValidacionToShow;

        @Generated
        private String fechaRadicacion;

        @Generated
        private String rutaArchivos;

        @Generated
        private List<ResultadoValidacionDTO> resultadosValidacion;

        @Generated
        ResultadoProcesoDTOBuilder() {
        }

        @Generated
        public ResultadoProcesoDTOBuilder resultState(boolean resultState) {
            this.resultState = resultState;
            return this;
        }

        @Generated
        public ResultadoProcesoDTOBuilder procesoId(int procesoId) {
            this.procesoId = procesoId;
            return this;
        }

        @Generated
        public ResultadoProcesoDTOBuilder numFactura(String numFactura) {
            this.numFactura = numFactura;
            return this;
        }

        @Generated
        public ResultadoProcesoDTOBuilder codigoUnicoValidacion(String codigoUnicoValidacion) {
            this.codigoUnicoValidacion = codigoUnicoValidacion;
            return this;
        }

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Generated
        public ResultadoProcesoDTOBuilder codigoUnicoValidacionToShow(String codigoUnicoValidacionToShow) {
            this.codigoUnicoValidacionToShow = codigoUnicoValidacionToShow;
            return this;
        }

        @Generated
        public ResultadoProcesoDTOBuilder fechaRadicacion(String fechaRadicacion) {
            this.fechaRadicacion = fechaRadicacion;
            return this;
        }

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Generated
        public ResultadoProcesoDTOBuilder rutaArchivos(String rutaArchivos) {
            this.rutaArchivos = rutaArchivos;
            return this;
        }

        @Generated
        public ResultadoProcesoDTOBuilder resultadosValidacion(List<ResultadoValidacionDTO> resultadosValidacion) {
            this.resultadosValidacion = resultadosValidacion;
            return this;
        }

        @Generated
        public ResultadoProcesoDTO build() {
            return new ResultadoProcesoDTO(this.resultState, this.procesoId, this.numFactura, this.codigoUnicoValidacion, this.codigoUnicoValidacionToShow, this.fechaRadicacion, this.rutaArchivos, this.resultadosValidacion);
        }

        @Generated
        public String toString() {
            return "ResultadoProcesoDTO.ResultadoProcesoDTOBuilder(resultState=" + this.resultState + ", procesoId=" + this.procesoId + ", numFactura=" + this.numFactura + ", codigoUnicoValidacion=" + this.codigoUnicoValidacion + ", codigoUnicoValidacionToShow=" + this.codigoUnicoValidacionToShow + ", fechaRadicacion=" + this.fechaRadicacion + ", rutaArchivos=" + this.rutaArchivos + ", resultadosValidacion=" + this.resultadosValidacion + ")";
        }
    }

    @Generated
    public void setResultState(boolean resultState) {
        this.resultState = resultState;
    }

    @Generated
    public void setProcesoId(int procesoId) {
        this.procesoId = procesoId;
    }

    @Generated
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    @Generated
    public void setCodigoUnicoValidacion(String codigoUnicoValidacion) {
        this.codigoUnicoValidacion = codigoUnicoValidacion;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Generated
    public void setCodigoUnicoValidacionToShow(String codigoUnicoValidacionToShow) {
        this.codigoUnicoValidacionToShow = codigoUnicoValidacionToShow;
    }

    @Generated
    public void setFechaRadicacion(String fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Generated
    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
    }

    @Generated
    public void setResultadosValidacion(List<ResultadoValidacionDTO> resultadosValidacion) {
        this.resultadosValidacion = resultadosValidacion;
    }

    @Generated
    public static ResultadoProcesoDTOBuilder builder() {
        return new ResultadoProcesoDTOBuilder();
    }

    @Generated
    public ResultadoProcesoDTO(boolean resultState, int procesoId, String numFactura, String codigoUnicoValidacion, String codigoUnicoValidacionToShow, String fechaRadicacion, String rutaArchivos, List<ResultadoValidacionDTO> resultadosValidacion) {
        this.resultState = resultState;
        this.procesoId = procesoId;
        this.numFactura = numFactura;
        this.codigoUnicoValidacion = codigoUnicoValidacion;
        this.codigoUnicoValidacionToShow = codigoUnicoValidacionToShow;
        this.fechaRadicacion = fechaRadicacion;
        this.rutaArchivos = rutaArchivos;
        this.resultadosValidacion = resultadosValidacion;
    }

    @Generated
    public ResultadoProcesoDTO() {
    }

    @Generated
    public boolean isResultState() {
        return this.resultState;
    }

    @Generated
    public int getProcesoId() {
        return this.procesoId;
    }

    @Generated
    public String getNumFactura() {
        return this.numFactura;
    }

    @Generated
    public String getCodigoUnicoValidacion() {
        return this.codigoUnicoValidacion;
    }

    @Generated
    public String getCodigoUnicoValidacionToShow() {
        return this.codigoUnicoValidacionToShow;
    }

    @Generated
    public String getFechaRadicacion() {
        return this.fechaRadicacion;
    }

    @Generated
    public String getRutaArchivos() {
        return this.rutaArchivos;
    }

    @Generated
    public List<ResultadoValidacionDTO> getResultadosValidacion() {
        return this.resultadosValidacion;
    }
}
