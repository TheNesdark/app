package com.genoma.plus.controller.laboratorio.dto;

import java.time.LocalDate;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoResultadosDTO.class */
public class InfoResultadosDTO {
    private LocalDate fecha;
    private String documento;
    private String nombreUsuario;
    private String nombreProcedimiento;
    private String fechaHoraValidado;
    private String nombreProfesionalValida;
    private String especialidaValida;
    private int esValidado;
    private Long idRecepcion;
    private Long idIngreso;
    private Long idDetalleRecepcion;
    private Long idUsuario;
    private Long idCodigoProcedimiento;
    private String idMunicipality;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InfoResultadosDTO)) {
            return false;
        }
        InfoResultadosDTO other = (InfoResultadosDTO) o;
        if (!other.canEqual(this) || getEsValidado() != other.getEsValidado()) {
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
        Object this$idIngreso = getIdIngreso();
        Object other$idIngreso = other.getIdIngreso();
        if (this$idIngreso == null) {
            if (other$idIngreso != null) {
                return false;
            }
        } else if (!this$idIngreso.equals(other$idIngreso)) {
            return false;
        }
        Object this$idDetalleRecepcion = getIdDetalleRecepcion();
        Object other$idDetalleRecepcion = other.getIdDetalleRecepcion();
        if (this$idDetalleRecepcion == null) {
            if (other$idDetalleRecepcion != null) {
                return false;
            }
        } else if (!this$idDetalleRecepcion.equals(other$idDetalleRecepcion)) {
            return false;
        }
        Object this$idUsuario = getIdUsuario();
        Object other$idUsuario = other.getIdUsuario();
        if (this$idUsuario == null) {
            if (other$idUsuario != null) {
                return false;
            }
        } else if (!this$idUsuario.equals(other$idUsuario)) {
            return false;
        }
        Object this$idCodigoProcedimiento = getIdCodigoProcedimiento();
        Object other$idCodigoProcedimiento = other.getIdCodigoProcedimiento();
        if (this$idCodigoProcedimiento == null) {
            if (other$idCodigoProcedimiento != null) {
                return false;
            }
        } else if (!this$idCodigoProcedimiento.equals(other$idCodigoProcedimiento)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        if (this$fecha == null) {
            if (other$fecha != null) {
                return false;
            }
        } else if (!this$fecha.equals(other$fecha)) {
            return false;
        }
        Object this$documento = getDocumento();
        Object other$documento = other.getDocumento();
        if (this$documento == null) {
            if (other$documento != null) {
                return false;
            }
        } else if (!this$documento.equals(other$documento)) {
            return false;
        }
        Object this$nombreUsuario = getNombreUsuario();
        Object other$nombreUsuario = other.getNombreUsuario();
        if (this$nombreUsuario == null) {
            if (other$nombreUsuario != null) {
                return false;
            }
        } else if (!this$nombreUsuario.equals(other$nombreUsuario)) {
            return false;
        }
        Object this$nombreProcedimiento = getNombreProcedimiento();
        Object other$nombreProcedimiento = other.getNombreProcedimiento();
        if (this$nombreProcedimiento == null) {
            if (other$nombreProcedimiento != null) {
                return false;
            }
        } else if (!this$nombreProcedimiento.equals(other$nombreProcedimiento)) {
            return false;
        }
        Object this$fechaHoraValidado = getFechaHoraValidado();
        Object other$fechaHoraValidado = other.getFechaHoraValidado();
        if (this$fechaHoraValidado == null) {
            if (other$fechaHoraValidado != null) {
                return false;
            }
        } else if (!this$fechaHoraValidado.equals(other$fechaHoraValidado)) {
            return false;
        }
        Object this$nombreProfesionalValida = getNombreProfesionalValida();
        Object other$nombreProfesionalValida = other.getNombreProfesionalValida();
        if (this$nombreProfesionalValida == null) {
            if (other$nombreProfesionalValida != null) {
                return false;
            }
        } else if (!this$nombreProfesionalValida.equals(other$nombreProfesionalValida)) {
            return false;
        }
        Object this$especialidaValida = getEspecialidaValida();
        Object other$especialidaValida = other.getEspecialidaValida();
        if (this$especialidaValida == null) {
            if (other$especialidaValida != null) {
                return false;
            }
        } else if (!this$especialidaValida.equals(other$especialidaValida)) {
            return false;
        }
        Object this$idMunicipality = getIdMunicipality();
        Object other$idMunicipality = other.getIdMunicipality();
        return this$idMunicipality == null ? other$idMunicipality == null : this$idMunicipality.equals(other$idMunicipality);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InfoResultadosDTO;
    }

    @Generated
    public int hashCode() {
        int result = (1 * 59) + getEsValidado();
        Object $idRecepcion = getIdRecepcion();
        int result2 = (result * 59) + ($idRecepcion == null ? 43 : $idRecepcion.hashCode());
        Object $idIngreso = getIdIngreso();
        int result3 = (result2 * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $idDetalleRecepcion = getIdDetalleRecepcion();
        int result4 = (result3 * 59) + ($idDetalleRecepcion == null ? 43 : $idDetalleRecepcion.hashCode());
        Object $idUsuario = getIdUsuario();
        int result5 = (result4 * 59) + ($idUsuario == null ? 43 : $idUsuario.hashCode());
        Object $idCodigoProcedimiento = getIdCodigoProcedimiento();
        int result6 = (result5 * 59) + ($idCodigoProcedimiento == null ? 43 : $idCodigoProcedimiento.hashCode());
        Object $fecha = getFecha();
        int result7 = (result6 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $documento = getDocumento();
        int result8 = (result7 * 59) + ($documento == null ? 43 : $documento.hashCode());
        Object $nombreUsuario = getNombreUsuario();
        int result9 = (result8 * 59) + ($nombreUsuario == null ? 43 : $nombreUsuario.hashCode());
        Object $nombreProcedimiento = getNombreProcedimiento();
        int result10 = (result9 * 59) + ($nombreProcedimiento == null ? 43 : $nombreProcedimiento.hashCode());
        Object $fechaHoraValidado = getFechaHoraValidado();
        int result11 = (result10 * 59) + ($fechaHoraValidado == null ? 43 : $fechaHoraValidado.hashCode());
        Object $nombreProfesionalValida = getNombreProfesionalValida();
        int result12 = (result11 * 59) + ($nombreProfesionalValida == null ? 43 : $nombreProfesionalValida.hashCode());
        Object $especialidaValida = getEspecialidaValida();
        int result13 = (result12 * 59) + ($especialidaValida == null ? 43 : $especialidaValida.hashCode());
        Object $idMunicipality = getIdMunicipality();
        return (result13 * 59) + ($idMunicipality == null ? 43 : $idMunicipality.hashCode());
    }

    @Generated
    public String toString() {
        return "InfoResultadosDTO(fecha=" + getFecha() + ", documento=" + getDocumento() + ", nombreUsuario=" + getNombreUsuario() + ", nombreProcedimiento=" + getNombreProcedimiento() + ", fechaHoraValidado=" + getFechaHoraValidado() + ", nombreProfesionalValida=" + getNombreProfesionalValida() + ", especialidaValida=" + getEspecialidaValida() + ", esValidado=" + getEsValidado() + ", idRecepcion=" + getIdRecepcion() + ", idIngreso=" + getIdIngreso() + ", idDetalleRecepcion=" + getIdDetalleRecepcion() + ", idUsuario=" + getIdUsuario() + ", idCodigoProcedimiento=" + getIdCodigoProcedimiento() + ", idMunicipality=" + getIdMunicipality() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoResultadosDTO$InfoResultadosDTOBuilder.class */
    @Generated
    public static class InfoResultadosDTOBuilder {

        @Generated
        private LocalDate fecha;

        @Generated
        private String documento;

        @Generated
        private String nombreUsuario;

        @Generated
        private String nombreProcedimiento;

        @Generated
        private String fechaHoraValidado;

        @Generated
        private String nombreProfesionalValida;

        @Generated
        private String especialidaValida;

        @Generated
        private int esValidado;

        @Generated
        private Long idRecepcion;

        @Generated
        private Long idIngreso;

        @Generated
        private Long idDetalleRecepcion;

        @Generated
        private Long idUsuario;

        @Generated
        private Long idCodigoProcedimiento;

        @Generated
        private String idMunicipality;

        @Generated
        InfoResultadosDTOBuilder() {
        }

        @Generated
        public InfoResultadosDTOBuilder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder documento(String documento) {
            this.documento = documento;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder nombreProcedimiento(String nombreProcedimiento) {
            this.nombreProcedimiento = nombreProcedimiento;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder fechaHoraValidado(String fechaHoraValidado) {
            this.fechaHoraValidado = fechaHoraValidado;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder nombreProfesionalValida(String nombreProfesionalValida) {
            this.nombreProfesionalValida = nombreProfesionalValida;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder especialidaValida(String especialidaValida) {
            this.especialidaValida = especialidaValida;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder esValidado(int esValidado) {
            this.esValidado = esValidado;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idRecepcion(Long idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idIngreso(Long idIngreso) {
            this.idIngreso = idIngreso;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idDetalleRecepcion(Long idDetalleRecepcion) {
            this.idDetalleRecepcion = idDetalleRecepcion;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idCodigoProcedimiento(Long idCodigoProcedimiento) {
            this.idCodigoProcedimiento = idCodigoProcedimiento;
            return this;
        }

        @Generated
        public InfoResultadosDTOBuilder idMunicipality(String idMunicipality) {
            this.idMunicipality = idMunicipality;
            return this;
        }

        @Generated
        public InfoResultadosDTO build() {
            return new InfoResultadosDTO(this.fecha, this.documento, this.nombreUsuario, this.nombreProcedimiento, this.fechaHoraValidado, this.nombreProfesionalValida, this.especialidaValida, this.esValidado, this.idRecepcion, this.idIngreso, this.idDetalleRecepcion, this.idUsuario, this.idCodigoProcedimiento, this.idMunicipality);
        }

        @Generated
        public String toString() {
            return "InfoResultadosDTO.InfoResultadosDTOBuilder(fecha=" + this.fecha + ", documento=" + this.documento + ", nombreUsuario=" + this.nombreUsuario + ", nombreProcedimiento=" + this.nombreProcedimiento + ", fechaHoraValidado=" + this.fechaHoraValidado + ", nombreProfesionalValida=" + this.nombreProfesionalValida + ", especialidaValida=" + this.especialidaValida + ", esValidado=" + this.esValidado + ", idRecepcion=" + this.idRecepcion + ", idIngreso=" + this.idIngreso + ", idDetalleRecepcion=" + this.idDetalleRecepcion + ", idUsuario=" + this.idUsuario + ", idCodigoProcedimiento=" + this.idCodigoProcedimiento + ", idMunicipality=" + this.idMunicipality + ")";
        }
    }

    @Generated
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    @Generated
    public void setFechaHoraValidado(String fechaHoraValidado) {
        this.fechaHoraValidado = fechaHoraValidado;
    }

    @Generated
    public void setNombreProfesionalValida(String nombreProfesionalValida) {
        this.nombreProfesionalValida = nombreProfesionalValida;
    }

    @Generated
    public void setEspecialidaValida(String especialidaValida) {
        this.especialidaValida = especialidaValida;
    }

    @Generated
    public void setEsValidado(int esValidado) {
        this.esValidado = esValidado;
    }

    @Generated
    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setIdDetalleRecepcion(Long idDetalleRecepcion) {
        this.idDetalleRecepcion = idDetalleRecepcion;
    }

    @Generated
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Generated
    public void setIdCodigoProcedimiento(Long idCodigoProcedimiento) {
        this.idCodigoProcedimiento = idCodigoProcedimiento;
    }

    @Generated
    public void setIdMunicipality(String idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    @Generated
    public static InfoResultadosDTOBuilder builder() {
        return new InfoResultadosDTOBuilder();
    }

    @Generated
    public InfoResultadosDTO(LocalDate fecha, String documento, String nombreUsuario, String nombreProcedimiento, String fechaHoraValidado, String nombreProfesionalValida, String especialidaValida, int esValidado, Long idRecepcion, Long idIngreso, Long idDetalleRecepcion, Long idUsuario, Long idCodigoProcedimiento, String idMunicipality) {
        this.fecha = fecha;
        this.documento = documento;
        this.nombreUsuario = nombreUsuario;
        this.nombreProcedimiento = nombreProcedimiento;
        this.fechaHoraValidado = fechaHoraValidado;
        this.nombreProfesionalValida = nombreProfesionalValida;
        this.especialidaValida = especialidaValida;
        this.esValidado = esValidado;
        this.idRecepcion = idRecepcion;
        this.idIngreso = idIngreso;
        this.idDetalleRecepcion = idDetalleRecepcion;
        this.idUsuario = idUsuario;
        this.idCodigoProcedimiento = idCodigoProcedimiento;
        this.idMunicipality = idMunicipality;
    }

    @Generated
    public InfoResultadosDTO() {
    }

    @Generated
    public LocalDate getFecha() {
        return this.fecha;
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
    public String getNombreProcedimiento() {
        return this.nombreProcedimiento;
    }

    @Generated
    public String getFechaHoraValidado() {
        return this.fechaHoraValidado;
    }

    @Generated
    public String getNombreProfesionalValida() {
        return this.nombreProfesionalValida;
    }

    @Generated
    public String getEspecialidaValida() {
        return this.especialidaValida;
    }

    @Generated
    public int getEsValidado() {
        return this.esValidado;
    }

    @Generated
    public Long getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public Long getIdDetalleRecepcion() {
        return this.idDetalleRecepcion;
    }

    @Generated
    public Long getIdUsuario() {
        return this.idUsuario;
    }

    @Generated
    public Long getIdCodigoProcedimiento() {
        return this.idCodigoProcedimiento;
    }

    @Generated
    public String getIdMunicipality() {
        return this.idMunicipality;
    }
}
