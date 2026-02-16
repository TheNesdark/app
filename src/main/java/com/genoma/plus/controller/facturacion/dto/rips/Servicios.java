package com.genoma.plus.controller.facturacion.dto.rips;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/Servicios.class */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Servicios {
    List<DetalleConsultasDTO> consultas;
    List<DetalleMedicamentosDTO> medicamentos;
    List<DetalleProcedimientosDTO> procedimientos;
    List<DetalleUrgenciasDTO> urgencias;
    List<DetalleHospitalizacionesDTO> hospitalizacion;
    List<DetalleRecienNacidoDTO> recienNacido;
    List<DetalleOtrosServiciosDTO> otrosServicios;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/dto/rips/Servicios$ServiciosBuilder.class */
    @Generated
    public static class ServiciosBuilder {

        @Generated
        private List<DetalleConsultasDTO> consultas;

        @Generated
        private List<DetalleMedicamentosDTO> medicamentos;

        @Generated
        private List<DetalleProcedimientosDTO> procedimientos;

        @Generated
        private List<DetalleUrgenciasDTO> urgencias;

        @Generated
        private List<DetalleHospitalizacionesDTO> hospitalizacion;

        @Generated
        private List<DetalleRecienNacidoDTO> recienNacido;

        @Generated
        private List<DetalleOtrosServiciosDTO> otrosServicios;

        @Generated
        ServiciosBuilder() {
        }

        @Generated
        public ServiciosBuilder consultas(List<DetalleConsultasDTO> consultas) {
            this.consultas = consultas;
            return this;
        }

        @Generated
        public ServiciosBuilder medicamentos(List<DetalleMedicamentosDTO> medicamentos) {
            this.medicamentos = medicamentos;
            return this;
        }

        @Generated
        public ServiciosBuilder procedimientos(List<DetalleProcedimientosDTO> procedimientos) {
            this.procedimientos = procedimientos;
            return this;
        }

        @Generated
        public ServiciosBuilder urgencias(List<DetalleUrgenciasDTO> urgencias) {
            this.urgencias = urgencias;
            return this;
        }

        @Generated
        public ServiciosBuilder hospitalizacion(List<DetalleHospitalizacionesDTO> hospitalizacion) {
            this.hospitalizacion = hospitalizacion;
            return this;
        }

        @Generated
        public ServiciosBuilder recienNacido(List<DetalleRecienNacidoDTO> recienNacido) {
            this.recienNacido = recienNacido;
            return this;
        }

        @Generated
        public ServiciosBuilder otrosServicios(List<DetalleOtrosServiciosDTO> otrosServicios) {
            this.otrosServicios = otrosServicios;
            return this;
        }

        @Generated
        public Servicios build() {
            return new Servicios(this.consultas, this.medicamentos, this.procedimientos, this.urgencias, this.hospitalizacion, this.recienNacido, this.otrosServicios);
        }

        @Generated
        public String toString() {
            return "Servicios.ServiciosBuilder(consultas=" + this.consultas + ", medicamentos=" + this.medicamentos + ", procedimientos=" + this.procedimientos + ", urgencias=" + this.urgencias + ", hospitalizacion=" + this.hospitalizacion + ", recienNacido=" + this.recienNacido + ", otrosServicios=" + this.otrosServicios + ")";
        }
    }

    @Generated
    public void setConsultas(List<DetalleConsultasDTO> consultas) {
        this.consultas = consultas;
    }

    @Generated
    public void setMedicamentos(List<DetalleMedicamentosDTO> medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Generated
    public void setProcedimientos(List<DetalleProcedimientosDTO> procedimientos) {
        this.procedimientos = procedimientos;
    }

    @Generated
    public void setUrgencias(List<DetalleUrgenciasDTO> urgencias) {
        this.urgencias = urgencias;
    }

    @Generated
    public void setHospitalizacion(List<DetalleHospitalizacionesDTO> hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    @Generated
    public void setRecienNacido(List<DetalleRecienNacidoDTO> recienNacido) {
        this.recienNacido = recienNacido;
    }

    @Generated
    public void setOtrosServicios(List<DetalleOtrosServiciosDTO> otrosServicios) {
        this.otrosServicios = otrosServicios;
    }

    @Generated
    public static ServiciosBuilder builder() {
        return new ServiciosBuilder();
    }

    @Generated
    public Servicios(List<DetalleConsultasDTO> consultas, List<DetalleMedicamentosDTO> medicamentos, List<DetalleProcedimientosDTO> procedimientos, List<DetalleUrgenciasDTO> urgencias, List<DetalleHospitalizacionesDTO> hospitalizacion, List<DetalleRecienNacidoDTO> recienNacido, List<DetalleOtrosServiciosDTO> otrosServicios) {
        this.consultas = consultas;
        this.medicamentos = medicamentos;
        this.procedimientos = procedimientos;
        this.urgencias = urgencias;
        this.hospitalizacion = hospitalizacion;
        this.recienNacido = recienNacido;
        this.otrosServicios = otrosServicios;
    }

    @Generated
    public Servicios() {
    }

    @Generated
    public List<DetalleConsultasDTO> getConsultas() {
        return this.consultas;
    }

    @Generated
    public List<DetalleMedicamentosDTO> getMedicamentos() {
        return this.medicamentos;
    }

    @Generated
    public List<DetalleProcedimientosDTO> getProcedimientos() {
        return this.procedimientos;
    }

    @Generated
    public List<DetalleUrgenciasDTO> getUrgencias() {
        return this.urgencias;
    }

    @Generated
    public List<DetalleHospitalizacionesDTO> getHospitalizacion() {
        return this.hospitalizacion;
    }

    @Generated
    public List<DetalleRecienNacidoDTO> getRecienNacido() {
        return this.recienNacido;
    }

    @Generated
    public List<DetalleOtrosServiciosDTO> getOtrosServicios() {
        return this.otrosServicios;
    }
}
