package com.genoma.plus.controller.facturacion.dto.rips;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleOtrosServiciosDTO.class */
public class DetalleOtrosServiciosDTO {
    private String codPrestador;
    private String numAutorizacion;
    private String idMIPRES;
    private String fechaSuministroTecnologia;
    private String tipoOS;
    private String codTecnologiaSalud;
    private String nomTecnologiaSalud;
    private Integer cantidadOS;
    private String tipoDocumentoIdentificacion;
    private String numDocumentoIdentificacion;
    private Long vrUnitOS;
    private Long vrServicio;
    private String conceptoRecaudo;
    private Long valorPagoModerador;
    private String numFEVPagoModerador;
    private Integer consecutivo;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/DetalleOtrosServiciosDTO$DetalleOtrosServiciosDTOBuilder.class */
    @Generated
    public static class DetalleOtrosServiciosDTOBuilder {

        @Generated
        private String codPrestador;

        @Generated
        private String numAutorizacion;

        @Generated
        private String idMIPRES;

        @Generated
        private String fechaSuministroTecnologia;

        @Generated
        private String tipoOS;

        @Generated
        private String codTecnologiaSalud;

        @Generated
        private String nomTecnologiaSalud;

        @Generated
        private Integer cantidadOS;

        @Generated
        private String tipoDocumentoIdentificacion;

        @Generated
        private String numDocumentoIdentificacion;

        @Generated
        private Long vrUnitOS;

        @Generated
        private Long vrServicio;

        @Generated
        private String conceptoRecaudo;

        @Generated
        private Long valorPagoModerador;

        @Generated
        private String numFEVPagoModerador;

        @Generated
        private Integer consecutivo;

        @Generated
        DetalleOtrosServiciosDTOBuilder() {
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder codPrestador(String codPrestador) {
            this.codPrestador = codPrestador;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder numAutorizacion(String numAutorizacion) {
            this.numAutorizacion = numAutorizacion;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder idMIPRES(String idMIPRES) {
            this.idMIPRES = idMIPRES;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder fechaSuministroTecnologia(String fechaSuministroTecnologia) {
            this.fechaSuministroTecnologia = fechaSuministroTecnologia;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder tipoOS(String tipoOS) {
            this.tipoOS = tipoOS;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder codTecnologiaSalud(String codTecnologiaSalud) {
            this.codTecnologiaSalud = codTecnologiaSalud;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder nomTecnologiaSalud(String nomTecnologiaSalud) {
            this.nomTecnologiaSalud = nomTecnologiaSalud;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder cantidadOS(Integer cantidadOS) {
            this.cantidadOS = cantidadOS;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder tipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
            this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder numDocumentoIdentificacion(String numDocumentoIdentificacion) {
            this.numDocumentoIdentificacion = numDocumentoIdentificacion;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder vrUnitOS(Long vrUnitOS) {
            this.vrUnitOS = vrUnitOS;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder vrServicio(Long vrServicio) {
            this.vrServicio = vrServicio;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder conceptoRecaudo(String conceptoRecaudo) {
            this.conceptoRecaudo = conceptoRecaudo;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder valorPagoModerador(Long valorPagoModerador) {
            this.valorPagoModerador = valorPagoModerador;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder numFEVPagoModerador(String numFEVPagoModerador) {
            this.numFEVPagoModerador = numFEVPagoModerador;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTOBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public DetalleOtrosServiciosDTO build() {
            return new DetalleOtrosServiciosDTO(this.codPrestador, this.numAutorizacion, this.idMIPRES, this.fechaSuministroTecnologia, this.tipoOS, this.codTecnologiaSalud, this.nomTecnologiaSalud, this.cantidadOS, this.tipoDocumentoIdentificacion, this.numDocumentoIdentificacion, this.vrUnitOS, this.vrServicio, this.conceptoRecaudo, this.valorPagoModerador, this.numFEVPagoModerador, this.consecutivo);
        }

        @Generated
        public String toString() {
            return "DetalleOtrosServiciosDTO.DetalleOtrosServiciosDTOBuilder(codPrestador=" + this.codPrestador + ", numAutorizacion=" + this.numAutorizacion + ", idMIPRES=" + this.idMIPRES + ", fechaSuministroTecnologia=" + this.fechaSuministroTecnologia + ", tipoOS=" + this.tipoOS + ", codTecnologiaSalud=" + this.codTecnologiaSalud + ", nomTecnologiaSalud=" + this.nomTecnologiaSalud + ", cantidadOS=" + this.cantidadOS + ", tipoDocumentoIdentificacion=" + this.tipoDocumentoIdentificacion + ", numDocumentoIdentificacion=" + this.numDocumentoIdentificacion + ", vrUnitOS=" + this.vrUnitOS + ", vrServicio=" + this.vrServicio + ", conceptoRecaudo=" + this.conceptoRecaudo + ", valorPagoModerador=" + this.valorPagoModerador + ", numFEVPagoModerador=" + this.numFEVPagoModerador + ", consecutivo=" + this.consecutivo + ")";
        }
    }

    @Generated
    public void setCodPrestador(String codPrestador) {
        this.codPrestador = codPrestador;
    }

    @Generated
    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    @Generated
    public void setIdMIPRES(String idMIPRES) {
        this.idMIPRES = idMIPRES;
    }

    @Generated
    public void setFechaSuministroTecnologia(String fechaSuministroTecnologia) {
        this.fechaSuministroTecnologia = fechaSuministroTecnologia;
    }

    @Generated
    public void setTipoOS(String tipoOS) {
        this.tipoOS = tipoOS;
    }

    @Generated
    public void setCodTecnologiaSalud(String codTecnologiaSalud) {
        this.codTecnologiaSalud = codTecnologiaSalud;
    }

    @Generated
    public void setNomTecnologiaSalud(String nomTecnologiaSalud) {
        this.nomTecnologiaSalud = nomTecnologiaSalud;
    }

    @Generated
    public void setCantidadOS(Integer cantidadOS) {
        this.cantidadOS = cantidadOS;
    }

    @Generated
    public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }

    @Generated
    public void setNumDocumentoIdentificacion(String numDocumentoIdentificacion) {
        this.numDocumentoIdentificacion = numDocumentoIdentificacion;
    }

    @Generated
    public void setVrUnitOS(Long vrUnitOS) {
        this.vrUnitOS = vrUnitOS;
    }

    @Generated
    public void setVrServicio(Long vrServicio) {
        this.vrServicio = vrServicio;
    }

    @Generated
    public void setConceptoRecaudo(String conceptoRecaudo) {
        this.conceptoRecaudo = conceptoRecaudo;
    }

    @Generated
    public void setValorPagoModerador(Long valorPagoModerador) {
        this.valorPagoModerador = valorPagoModerador;
    }

    @Generated
    public void setNumFEVPagoModerador(String numFEVPagoModerador) {
        this.numFEVPagoModerador = numFEVPagoModerador;
    }

    @Generated
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public static DetalleOtrosServiciosDTOBuilder builder() {
        return new DetalleOtrosServiciosDTOBuilder();
    }

    @Generated
    public DetalleOtrosServiciosDTO(String codPrestador, String numAutorizacion, String idMIPRES, String fechaSuministroTecnologia, String tipoOS, String codTecnologiaSalud, String nomTecnologiaSalud, Integer cantidadOS, String tipoDocumentoIdentificacion, String numDocumentoIdentificacion, Long vrUnitOS, Long vrServicio, String conceptoRecaudo, Long valorPagoModerador, String numFEVPagoModerador, Integer consecutivo) {
        this.codPrestador = codPrestador;
        this.numAutorizacion = numAutorizacion;
        this.idMIPRES = idMIPRES;
        this.fechaSuministroTecnologia = fechaSuministroTecnologia;
        this.tipoOS = tipoOS;
        this.codTecnologiaSalud = codTecnologiaSalud;
        this.nomTecnologiaSalud = nomTecnologiaSalud;
        this.cantidadOS = cantidadOS;
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
        this.numDocumentoIdentificacion = numDocumentoIdentificacion;
        this.vrUnitOS = vrUnitOS;
        this.vrServicio = vrServicio;
        this.conceptoRecaudo = conceptoRecaudo;
        this.valorPagoModerador = valorPagoModerador;
        this.numFEVPagoModerador = numFEVPagoModerador;
        this.consecutivo = consecutivo;
    }

    @Generated
    public DetalleOtrosServiciosDTO() {
    }

    @Generated
    public String getCodPrestador() {
        return this.codPrestador;
    }

    @Generated
    public String getNumAutorizacion() {
        return this.numAutorizacion;
    }

    @Generated
    public String getIdMIPRES() {
        return this.idMIPRES;
    }

    @Generated
    public String getFechaSuministroTecnologia() {
        return this.fechaSuministroTecnologia;
    }

    @Generated
    public String getTipoOS() {
        return this.tipoOS;
    }

    @Generated
    public String getCodTecnologiaSalud() {
        return this.codTecnologiaSalud;
    }

    @Generated
    public String getNomTecnologiaSalud() {
        return this.nomTecnologiaSalud;
    }

    @Generated
    public Integer getCantidadOS() {
        return this.cantidadOS;
    }

    @Generated
    public String getTipoDocumentoIdentificacion() {
        return this.tipoDocumentoIdentificacion;
    }

    @Generated
    public String getNumDocumentoIdentificacion() {
        return this.numDocumentoIdentificacion;
    }

    @Generated
    public Long getVrUnitOS() {
        return this.vrUnitOS;
    }

    @Generated
    public Long getVrServicio() {
        return this.vrServicio;
    }

    @Generated
    public String getConceptoRecaudo() {
        return this.conceptoRecaudo;
    }

    @Generated
    public Long getValorPagoModerador() {
        return this.valorPagoModerador;
    }

    @Generated
    public String getNumFEVPagoModerador() {
        return this.numFEVPagoModerador;
    }

    @Generated
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
}
