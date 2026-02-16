package com.genoma.plus.controller.facturacion.dto.rips;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/TransaccionDTO.class */
public class TransaccionDTO {
    private String numDocumentoIdObligado;
    private String numFactura;
    private String tipoNota;
    private String numNota;
    private List<DetalleUsuariosDTO> usuarios;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/TransaccionDTO$TransaccionDTOBuilder.class */
    @Generated
    public static class TransaccionDTOBuilder {

        @Generated
        private String numDocumentoIdObligado;

        @Generated
        private String numFactura;

        @Generated
        private String tipoNota;

        @Generated
        private String numNota;

        @Generated
        private List<DetalleUsuariosDTO> usuarios;

        @Generated
        TransaccionDTOBuilder() {
        }

        @Generated
        public TransaccionDTOBuilder numDocumentoIdObligado(String numDocumentoIdObligado) {
            this.numDocumentoIdObligado = numDocumentoIdObligado;
            return this;
        }

        @Generated
        public TransaccionDTOBuilder numFactura(String numFactura) {
            this.numFactura = numFactura;
            return this;
        }

        @Generated
        public TransaccionDTOBuilder tipoNota(String tipoNota) {
            this.tipoNota = tipoNota;
            return this;
        }

        @Generated
        public TransaccionDTOBuilder numNota(String numNota) {
            this.numNota = numNota;
            return this;
        }

        @Generated
        public TransaccionDTOBuilder usuarios(List<DetalleUsuariosDTO> usuarios) {
            this.usuarios = usuarios;
            return this;
        }

        @Generated
        public TransaccionDTO build() {
            return new TransaccionDTO(this.numDocumentoIdObligado, this.numFactura, this.tipoNota, this.numNota, this.usuarios);
        }

        @Generated
        public String toString() {
            return "TransaccionDTO.TransaccionDTOBuilder(numDocumentoIdObligado=" + this.numDocumentoIdObligado + ", numFactura=" + this.numFactura + ", tipoNota=" + this.tipoNota + ", numNota=" + this.numNota + ", usuarios=" + this.usuarios + ")";
        }
    }

    @Generated
    public void setNumDocumentoIdObligado(String numDocumentoIdObligado) {
        this.numDocumentoIdObligado = numDocumentoIdObligado;
    }

    @Generated
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    @Generated
    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    @Generated
    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    @Generated
    public void setUsuarios(List<DetalleUsuariosDTO> usuarios) {
        this.usuarios = usuarios;
    }

    @Generated
    public static TransaccionDTOBuilder builder() {
        return new TransaccionDTOBuilder();
    }

    @Generated
    public TransaccionDTO(String numDocumentoIdObligado, String numFactura, String tipoNota, String numNota, List<DetalleUsuariosDTO> usuarios) {
        this.numDocumentoIdObligado = numDocumentoIdObligado;
        this.numFactura = numFactura;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.usuarios = usuarios;
    }

    @Generated
    public TransaccionDTO() {
    }

    @Generated
    public String getNumDocumentoIdObligado() {
        return this.numDocumentoIdObligado;
    }

    @Generated
    public String getNumFactura() {
        return this.numFactura;
    }

    @Generated
    public String getTipoNota() {
        return this.tipoNota;
    }

    @Generated
    public String getNumNota() {
        return this.numNota;
    }

    @Generated
    public List<DetalleUsuariosDTO> getUsuarios() {
        return this.usuarios;
    }
}
