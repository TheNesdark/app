package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoAlertaTiempoRecepcionesDTO.class */
public class InfoAlertaTiempoRecepcionesDTO {
    private Long idRecepcion;
    private String documento;
    private String nombreUsuario;
    private String sexo;
    private String procedimiento;
    private String fechaRecepcion;
    private String fechaRecepcionFinal;
    private String diferenciaTiempo;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoAlertaTiempoRecepcionesDTO$InfoAlertaTiempoRecepcionesDTOBuilder.class */
    @Generated
    public static class InfoAlertaTiempoRecepcionesDTOBuilder {

        @Generated
        private Long idRecepcion;

        @Generated
        private String documento;

        @Generated
        private String nombreUsuario;

        @Generated
        private String sexo;

        @Generated
        private String procedimiento;

        @Generated
        private String fechaRecepcion;

        @Generated
        private String fechaRecepcionFinal;

        @Generated
        private String diferenciaTiempo;

        @Generated
        InfoAlertaTiempoRecepcionesDTOBuilder() {
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder idRecepcion(Long idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder documento(String documento) {
            this.documento = documento;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder sexo(String sexo) {
            this.sexo = sexo;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder procedimiento(String procedimiento) {
            this.procedimiento = procedimiento;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder fechaRecepcion(String fechaRecepcion) {
            this.fechaRecepcion = fechaRecepcion;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder fechaRecepcionFinal(String fechaRecepcionFinal) {
            this.fechaRecepcionFinal = fechaRecepcionFinal;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTOBuilder diferenciaTiempo(String diferenciaTiempo) {
            this.diferenciaTiempo = diferenciaTiempo;
            return this;
        }

        @Generated
        public InfoAlertaTiempoRecepcionesDTO build() {
            return new InfoAlertaTiempoRecepcionesDTO(this.idRecepcion, this.documento, this.nombreUsuario, this.sexo, this.procedimiento, this.fechaRecepcion, this.fechaRecepcionFinal, this.diferenciaTiempo);
        }

        @Generated
        public String toString() {
            return "InfoAlertaTiempoRecepcionesDTO.InfoAlertaTiempoRecepcionesDTOBuilder(idRecepcion=" + this.idRecepcion + ", documento=" + this.documento + ", nombreUsuario=" + this.nombreUsuario + ", sexo=" + this.sexo + ", procedimiento=" + this.procedimiento + ", fechaRecepcion=" + this.fechaRecepcion + ", fechaRecepcionFinal=" + this.fechaRecepcionFinal + ", diferenciaTiempo=" + this.diferenciaTiempo + ")";
        }
    }

    @Generated
    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Generated
    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Generated
    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Generated
    public void setFechaRecepcionFinal(String fechaRecepcionFinal) {
        this.fechaRecepcionFinal = fechaRecepcionFinal;
    }

    @Generated
    public void setDiferenciaTiempo(String diferenciaTiempo) {
        this.diferenciaTiempo = diferenciaTiempo;
    }

    @Generated
    public static InfoAlertaTiempoRecepcionesDTOBuilder builder() {
        return new InfoAlertaTiempoRecepcionesDTOBuilder();
    }

    @Generated
    public InfoAlertaTiempoRecepcionesDTO(Long idRecepcion, String documento, String nombreUsuario, String sexo, String procedimiento, String fechaRecepcion, String fechaRecepcionFinal, String diferenciaTiempo) {
        this.idRecepcion = idRecepcion;
        this.documento = documento;
        this.nombreUsuario = nombreUsuario;
        this.sexo = sexo;
        this.procedimiento = procedimiento;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaRecepcionFinal = fechaRecepcionFinal;
        this.diferenciaTiempo = diferenciaTiempo;
    }

    @Generated
    public InfoAlertaTiempoRecepcionesDTO() {
    }

    @Generated
    public Long getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public String getDocumento() {
        return this.documento;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public String getSexo() {
        return this.sexo;
    }

    @Generated
    public String getProcedimiento() {
        return this.procedimiento;
    }

    @Generated
    public String getFechaRecepcion() {
        return this.fechaRecepcion;
    }

    @Generated
    public String getFechaRecepcionFinal() {
        return this.fechaRecepcionFinal;
    }

    @Generated
    public String getDiferenciaTiempo() {
        return this.diferenciaTiempo;
    }
}
