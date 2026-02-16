package com.genoma.plus.controller.facturacion.dto.validacionrips;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/RespuestaValidacion.class */
public class RespuestaValidacion {
    private boolean resultState;
    private int procesoId;
    private String numFactura;
    private String codigoUnicoValidacion;
    private String codigoUnicoValidacionToShow;
    private String fechaRadicacion;
    private String rutaArchivos;
    private List<ResultadoValidacion> resultadosValidacion;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/validacionrips/RespuestaValidacion$RespuestaValidacionBuilder.class */
    @Generated
    public static class RespuestaValidacionBuilder {

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
        private List<ResultadoValidacion> resultadosValidacion;

        @Generated
        RespuestaValidacionBuilder() {
        }

        @Generated
        public RespuestaValidacionBuilder resultState(boolean resultState) {
            this.resultState = resultState;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder procesoId(int procesoId) {
            this.procesoId = procesoId;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder numFactura(String numFactura) {
            this.numFactura = numFactura;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder codigoUnicoValidacion(String codigoUnicoValidacion) {
            this.codigoUnicoValidacion = codigoUnicoValidacion;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder codigoUnicoValidacionToShow(String codigoUnicoValidacionToShow) {
            this.codigoUnicoValidacionToShow = codigoUnicoValidacionToShow;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder fechaRadicacion(String fechaRadicacion) {
            this.fechaRadicacion = fechaRadicacion;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder rutaArchivos(String rutaArchivos) {
            this.rutaArchivos = rutaArchivos;
            return this;
        }

        @Generated
        public RespuestaValidacionBuilder resultadosValidacion(List<ResultadoValidacion> resultadosValidacion) {
            this.resultadosValidacion = resultadosValidacion;
            return this;
        }

        @Generated
        public RespuestaValidacion build() {
            return new RespuestaValidacion(this.resultState, this.procesoId, this.numFactura, this.codigoUnicoValidacion, this.codigoUnicoValidacionToShow, this.fechaRadicacion, this.rutaArchivos, this.resultadosValidacion);
        }

        @Generated
        public String toString() {
            return "RespuestaValidacion.RespuestaValidacionBuilder(resultState=" + this.resultState + ", procesoId=" + this.procesoId + ", numFactura=" + this.numFactura + ", codigoUnicoValidacion=" + this.codigoUnicoValidacion + ", codigoUnicoValidacionToShow=" + this.codigoUnicoValidacionToShow + ", fechaRadicacion=" + this.fechaRadicacion + ", rutaArchivos=" + this.rutaArchivos + ", resultadosValidacion=" + this.resultadosValidacion + ")";
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

    @Generated
    public void setCodigoUnicoValidacionToShow(String codigoUnicoValidacionToShow) {
        this.codigoUnicoValidacionToShow = codigoUnicoValidacionToShow;
    }

    @Generated
    public void setFechaRadicacion(String fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    @Generated
    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
    }

    @Generated
    public void setResultadosValidacion(List<ResultadoValidacion> resultadosValidacion) {
        this.resultadosValidacion = resultadosValidacion;
    }

    @Generated
    public static RespuestaValidacionBuilder builder() {
        return new RespuestaValidacionBuilder();
    }

    @Generated
    public RespuestaValidacion(boolean resultState, int procesoId, String numFactura, String codigoUnicoValidacion, String codigoUnicoValidacionToShow, String fechaRadicacion, String rutaArchivos, List<ResultadoValidacion> resultadosValidacion) {
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
    public RespuestaValidacion() {
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
    public List<ResultadoValidacion> getResultadosValidacion() {
        return this.resultadosValidacion;
    }
}
