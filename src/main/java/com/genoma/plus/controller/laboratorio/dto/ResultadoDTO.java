package com.genoma.plus.controller.laboratorio.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ResultadoDTO.class */
public class ResultadoDTO {
    private Long id;
    private Long idRecepcion;
    private String fechaResult;
    private String observacion;
    private Long idProfesional;
    private Long idEspecialidad;
    private Integer estado;
    private Integer soporte;
    private String url;
    private Integer estadoHcBs1;
    private String fecha;
    private String usuarioS;
    private List<DetalleResultadoDTO> detallesResultado;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ResultadoDTO)) {
            return false;
        }
        ResultadoDTO other = (ResultadoDTO) o;
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
        Object this$idRecepcion = getIdRecepcion();
        Object other$idRecepcion = other.getIdRecepcion();
        if (this$idRecepcion == null) {
            if (other$idRecepcion != null) {
                return false;
            }
        } else if (!this$idRecepcion.equals(other$idRecepcion)) {
            return false;
        }
        Object this$idProfesional = getIdProfesional();
        Object other$idProfesional = other.getIdProfesional();
        if (this$idProfesional == null) {
            if (other$idProfesional != null) {
                return false;
            }
        } else if (!this$idProfesional.equals(other$idProfesional)) {
            return false;
        }
        Object this$idEspecialidad = getIdEspecialidad();
        Object other$idEspecialidad = other.getIdEspecialidad();
        if (this$idEspecialidad == null) {
            if (other$idEspecialidad != null) {
                return false;
            }
        } else if (!this$idEspecialidad.equals(other$idEspecialidad)) {
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
        Object this$soporte = getSoporte();
        Object other$soporte = other.getSoporte();
        if (this$soporte == null) {
            if (other$soporte != null) {
                return false;
            }
        } else if (!this$soporte.equals(other$soporte)) {
            return false;
        }
        Object this$estadoHcBs1 = getEstadoHcBs1();
        Object other$estadoHcBs1 = other.getEstadoHcBs1();
        if (this$estadoHcBs1 == null) {
            if (other$estadoHcBs1 != null) {
                return false;
            }
        } else if (!this$estadoHcBs1.equals(other$estadoHcBs1)) {
            return false;
        }
        Object this$fechaResult = getFechaResult();
        Object other$fechaResult = other.getFechaResult();
        if (this$fechaResult == null) {
            if (other$fechaResult != null) {
                return false;
            }
        } else if (!this$fechaResult.equals(other$fechaResult)) {
            return false;
        }
        Object this$observacion = getObservacion();
        Object other$observacion = other.getObservacion();
        if (this$observacion == null) {
            if (other$observacion != null) {
                return false;
            }
        } else if (!this$observacion.equals(other$observacion)) {
            return false;
        }
        Object this$url = getUrl();
        Object other$url = other.getUrl();
        if (this$url == null) {
            if (other$url != null) {
                return false;
            }
        } else if (!this$url.equals(other$url)) {
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
        Object this$usuarioS = getUsuarioS();
        Object other$usuarioS = other.getUsuarioS();
        if (this$usuarioS == null) {
            if (other$usuarioS != null) {
                return false;
            }
        } else if (!this$usuarioS.equals(other$usuarioS)) {
            return false;
        }
        Object this$detallesResultado = getDetallesResultado();
        Object other$detallesResultado = other.getDetallesResultado();
        return this$detallesResultado == null ? other$detallesResultado == null : this$detallesResultado.equals(other$detallesResultado);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ResultadoDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idRecepcion = getIdRecepcion();
        int result2 = (result * 59) + ($idRecepcion == null ? 43 : $idRecepcion.hashCode());
        Object $idProfesional = getIdProfesional();
        int result3 = (result2 * 59) + ($idProfesional == null ? 43 : $idProfesional.hashCode());
        Object $idEspecialidad = getIdEspecialidad();
        int result4 = (result3 * 59) + ($idEspecialidad == null ? 43 : $idEspecialidad.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $soporte = getSoporte();
        int result6 = (result5 * 59) + ($soporte == null ? 43 : $soporte.hashCode());
        Object $estadoHcBs1 = getEstadoHcBs1();
        int result7 = (result6 * 59) + ($estadoHcBs1 == null ? 43 : $estadoHcBs1.hashCode());
        Object $fechaResult = getFechaResult();
        int result8 = (result7 * 59) + ($fechaResult == null ? 43 : $fechaResult.hashCode());
        Object $observacion = getObservacion();
        int result9 = (result8 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $url = getUrl();
        int result10 = (result9 * 59) + ($url == null ? 43 : $url.hashCode());
        Object $fecha = getFecha();
        int result11 = (result10 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $usuarioS = getUsuarioS();
        int result12 = (result11 * 59) + ($usuarioS == null ? 43 : $usuarioS.hashCode());
        Object $detallesResultado = getDetallesResultado();
        return (result12 * 59) + ($detallesResultado == null ? 43 : $detallesResultado.hashCode());
    }

    @Generated
    public String toString() {
        return "ResultadoDTO(id=" + getId() + ", idRecepcion=" + getIdRecepcion() + ", fechaResult=" + getFechaResult() + ", observacion=" + getObservacion() + ", idProfesional=" + getIdProfesional() + ", idEspecialidad=" + getIdEspecialidad() + ", estado=" + getEstado() + ", soporte=" + getSoporte() + ", url=" + getUrl() + ", estadoHcBs1=" + getEstadoHcBs1() + ", fecha=" + getFecha() + ", usuarioS=" + getUsuarioS() + ", detallesResultado=" + getDetallesResultado() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ResultadoDTO$ResultadoDTOBuilder.class */
    @Generated
    public static class ResultadoDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idRecepcion;

        @Generated
        private String fechaResult;

        @Generated
        private String observacion;

        @Generated
        private Long idProfesional;

        @Generated
        private Long idEspecialidad;

        @Generated
        private Integer estado;

        @Generated
        private Integer soporte;

        @Generated
        private String url;

        @Generated
        private Integer estadoHcBs1;

        @Generated
        private String fecha;

        @Generated
        private String usuarioS;

        @Generated
        private List<DetalleResultadoDTO> detallesResultado;

        @Generated
        ResultadoDTOBuilder() {
        }

        @Generated
        public ResultadoDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder idRecepcion(Long idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder fechaResult(String fechaResult) {
            this.fechaResult = fechaResult;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder idProfesional(Long idProfesional) {
            this.idProfesional = idProfesional;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder idEspecialidad(Long idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder estado(Integer estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder soporte(Integer soporte) {
            this.soporte = soporte;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder url(String url) {
            this.url = url;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder estadoHcBs1(Integer estadoHcBs1) {
            this.estadoHcBs1 = estadoHcBs1;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder usuarioS(String usuarioS) {
            this.usuarioS = usuarioS;
            return this;
        }

        @Generated
        public ResultadoDTOBuilder detallesResultado(List<DetalleResultadoDTO> detallesResultado) {
            this.detallesResultado = detallesResultado;
            return this;
        }

        @Generated
        public ResultadoDTO build() {
            return new ResultadoDTO(this.id, this.idRecepcion, this.fechaResult, this.observacion, this.idProfesional, this.idEspecialidad, this.estado, this.soporte, this.url, this.estadoHcBs1, this.fecha, this.usuarioS, this.detallesResultado);
        }

        @Generated
        public String toString() {
            return "ResultadoDTO.ResultadoDTOBuilder(id=" + this.id + ", idRecepcion=" + this.idRecepcion + ", fechaResult=" + this.fechaResult + ", observacion=" + this.observacion + ", idProfesional=" + this.idProfesional + ", idEspecialidad=" + this.idEspecialidad + ", estado=" + this.estado + ", soporte=" + this.soporte + ", url=" + this.url + ", estadoHcBs1=" + this.estadoHcBs1 + ", fecha=" + this.fecha + ", usuarioS=" + this.usuarioS + ", detallesResultado=" + this.detallesResultado + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setFechaResult(String fechaResult) {
        this.fechaResult = fechaResult;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Generated
    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Generated
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Generated
    public void setSoporte(Integer soporte) {
        this.soporte = soporte;
    }

    @Generated
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated
    public void setEstadoHcBs1(Integer estadoHcBs1) {
        this.estadoHcBs1 = estadoHcBs1;
    }

    @Generated
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setUsuarioS(String usuarioS) {
        this.usuarioS = usuarioS;
    }

    @Generated
    public void setDetallesResultado(List<DetalleResultadoDTO> detallesResultado) {
        this.detallesResultado = detallesResultado;
    }

    @Generated
    public static ResultadoDTOBuilder builder() {
        return new ResultadoDTOBuilder();
    }

    @Generated
    public ResultadoDTO(Long id, Long idRecepcion, String fechaResult, String observacion, Long idProfesional, Long idEspecialidad, Integer estado, Integer soporte, String url, Integer estadoHcBs1, String fecha, String usuarioS, List<DetalleResultadoDTO> detallesResultado) {
        this.id = id;
        this.idRecepcion = idRecepcion;
        this.fechaResult = fechaResult;
        this.observacion = observacion;
        this.idProfesional = idProfesional;
        this.idEspecialidad = idEspecialidad;
        this.estado = estado;
        this.soporte = soporte;
        this.url = url;
        this.estadoHcBs1 = estadoHcBs1;
        this.fecha = fecha;
        this.usuarioS = usuarioS;
        this.detallesResultado = detallesResultado;
    }

    @Generated
    public ResultadoDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public String getFechaResult() {
        return this.fechaResult;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Long getIdProfesional() {
        return this.idProfesional;
    }

    @Generated
    public Long getIdEspecialidad() {
        return this.idEspecialidad;
    }

    @Generated
    public Integer getEstado() {
        return this.estado;
    }

    @Generated
    public Integer getSoporte() {
        return this.soporte;
    }

    @Generated
    public String getUrl() {
        return this.url;
    }

    @Generated
    public Integer getEstadoHcBs1() {
        return this.estadoHcBs1;
    }

    @Generated
    public String getFecha() {
        return this.fecha;
    }

    @Generated
    public String getUsuarioS() {
        return this.usuarioS;
    }

    @Generated
    public List<DetalleResultadoDTO> getDetallesResultado() {
        return this.detallesResultado;
    }
}
