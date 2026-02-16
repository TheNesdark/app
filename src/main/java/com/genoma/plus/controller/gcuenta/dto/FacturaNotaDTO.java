package com.genoma.plus.controller.gcuenta.dto;

import java.util.Date;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDTO.class */
public class FacturaNotaDTO {
    private Integer id;
    private Date fechaNota;
    private Integer idConceptoNota;
    private Long idRespuestaGlosa;
    private Long idLiquidacion;
    private String prefijo;
    private Integer numeroConsecutivo;
    private Integer idResolucion;
    private String descripcionGeneral;
    private Boolean estado;
    private Date fecha;
    private Long idUsuarioRh;
    private Boolean enviada;
    private String response;
    private String responseEstado;
    private Boolean notaSinFactura;
    private List<FacturaNotaDetalleDTO> listaDetalleNota;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/dto/FacturaNotaDTO$FacturaNotaDTOBuilder.class */
    @Generated
    public static class FacturaNotaDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private Date fechaNota;

        @Generated
        private Integer idConceptoNota;

        @Generated
        private Long idRespuestaGlosa;

        @Generated
        private Long idLiquidacion;

        @Generated
        private String prefijo;

        @Generated
        private Integer numeroConsecutivo;

        @Generated
        private Integer idResolucion;

        @Generated
        private String descripcionGeneral;

        @Generated
        private Boolean estado;

        @Generated
        private Date fecha;

        @Generated
        private Long idUsuarioRh;

        @Generated
        private Boolean enviada;

        @Generated
        private String response;

        @Generated
        private String responseEstado;

        @Generated
        private Boolean notaSinFactura;

        @Generated
        private List<FacturaNotaDetalleDTO> listaDetalleNota;

        @Generated
        FacturaNotaDTOBuilder() {
        }

        @Generated
        public FacturaNotaDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder fechaNota(Date fechaNota) {
            this.fechaNota = fechaNota;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder idConceptoNota(Integer idConceptoNota) {
            this.idConceptoNota = idConceptoNota;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder idRespuestaGlosa(Long idRespuestaGlosa) {
            this.idRespuestaGlosa = idRespuestaGlosa;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder idLiquidacion(Long idLiquidacion) {
            this.idLiquidacion = idLiquidacion;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder prefijo(String prefijo) {
            this.prefijo = prefijo;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder numeroConsecutivo(Integer numeroConsecutivo) {
            this.numeroConsecutivo = numeroConsecutivo;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder idResolucion(Integer idResolucion) {
            this.idResolucion = idResolucion;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder descripcionGeneral(String descripcionGeneral) {
            this.descripcionGeneral = descripcionGeneral;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder idUsuarioRh(Long idUsuarioRh) {
            this.idUsuarioRh = idUsuarioRh;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder enviada(Boolean enviada) {
            this.enviada = enviada;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder response(String response) {
            this.response = response;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder responseEstado(String responseEstado) {
            this.responseEstado = responseEstado;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder notaSinFactura(Boolean notaSinFactura) {
            this.notaSinFactura = notaSinFactura;
            return this;
        }

        @Generated
        public FacturaNotaDTOBuilder listaDetalleNota(List<FacturaNotaDetalleDTO> listaDetalleNota) {
            this.listaDetalleNota = listaDetalleNota;
            return this;
        }

        @Generated
        public FacturaNotaDTO build() {
            return new FacturaNotaDTO(this.id, this.fechaNota, this.idConceptoNota, this.idRespuestaGlosa, this.idLiquidacion, this.prefijo, this.numeroConsecutivo, this.idResolucion, this.descripcionGeneral, this.estado, this.fecha, this.idUsuarioRh, this.enviada, this.response, this.responseEstado, this.notaSinFactura, this.listaDetalleNota);
        }

        @Generated
        public String toString() {
            return "FacturaNotaDTO.FacturaNotaDTOBuilder(id=" + this.id + ", fechaNota=" + this.fechaNota + ", idConceptoNota=" + this.idConceptoNota + ", idRespuestaGlosa=" + this.idRespuestaGlosa + ", idLiquidacion=" + this.idLiquidacion + ", prefijo=" + this.prefijo + ", numeroConsecutivo=" + this.numeroConsecutivo + ", idResolucion=" + this.idResolucion + ", descripcionGeneral=" + this.descripcionGeneral + ", estado=" + this.estado + ", fecha=" + this.fecha + ", idUsuarioRh=" + this.idUsuarioRh + ", enviada=" + this.enviada + ", response=" + this.response + ", responseEstado=" + this.responseEstado + ", notaSinFactura=" + this.notaSinFactura + ", listaDetalleNota=" + this.listaDetalleNota + ")";
        }
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FacturaNotaDTO)) {
            return false;
        }
        FacturaNotaDTO other = (FacturaNotaDTO) o;
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
        Object this$idConceptoNota = getIdConceptoNota();
        Object other$idConceptoNota = other.getIdConceptoNota();
        if (this$idConceptoNota == null) {
            if (other$idConceptoNota != null) {
                return false;
            }
        } else if (!this$idConceptoNota.equals(other$idConceptoNota)) {
            return false;
        }
        Object this$idRespuestaGlosa = getIdRespuestaGlosa();
        Object other$idRespuestaGlosa = other.getIdRespuestaGlosa();
        if (this$idRespuestaGlosa == null) {
            if (other$idRespuestaGlosa != null) {
                return false;
            }
        } else if (!this$idRespuestaGlosa.equals(other$idRespuestaGlosa)) {
            return false;
        }
        Object this$idLiquidacion = getIdLiquidacion();
        Object other$idLiquidacion = other.getIdLiquidacion();
        if (this$idLiquidacion == null) {
            if (other$idLiquidacion != null) {
                return false;
            }
        } else if (!this$idLiquidacion.equals(other$idLiquidacion)) {
            return false;
        }
        Object this$numeroConsecutivo = getNumeroConsecutivo();
        Object other$numeroConsecutivo = other.getNumeroConsecutivo();
        if (this$numeroConsecutivo == null) {
            if (other$numeroConsecutivo != null) {
                return false;
            }
        } else if (!this$numeroConsecutivo.equals(other$numeroConsecutivo)) {
            return false;
        }
        Object this$idResolucion = getIdResolucion();
        Object other$idResolucion = other.getIdResolucion();
        if (this$idResolucion == null) {
            if (other$idResolucion != null) {
                return false;
            }
        } else if (!this$idResolucion.equals(other$idResolucion)) {
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
        Object this$idUsuarioRh = getIdUsuarioRh();
        Object other$idUsuarioRh = other.getIdUsuarioRh();
        if (this$idUsuarioRh == null) {
            if (other$idUsuarioRh != null) {
                return false;
            }
        } else if (!this$idUsuarioRh.equals(other$idUsuarioRh)) {
            return false;
        }
        Object this$enviada = getEnviada();
        Object other$enviada = other.getEnviada();
        if (this$enviada == null) {
            if (other$enviada != null) {
                return false;
            }
        } else if (!this$enviada.equals(other$enviada)) {
            return false;
        }
        Object this$notaSinFactura = getNotaSinFactura();
        Object other$notaSinFactura = other.getNotaSinFactura();
        if (this$notaSinFactura == null) {
            if (other$notaSinFactura != null) {
                return false;
            }
        } else if (!this$notaSinFactura.equals(other$notaSinFactura)) {
            return false;
        }
        Object this$fechaNota = getFechaNota();
        Object other$fechaNota = other.getFechaNota();
        if (this$fechaNota == null) {
            if (other$fechaNota != null) {
                return false;
            }
        } else if (!this$fechaNota.equals(other$fechaNota)) {
            return false;
        }
        Object this$prefijo = getPrefijo();
        Object other$prefijo = other.getPrefijo();
        if (this$prefijo == null) {
            if (other$prefijo != null) {
                return false;
            }
        } else if (!this$prefijo.equals(other$prefijo)) {
            return false;
        }
        Object this$descripcionGeneral = getDescripcionGeneral();
        Object other$descripcionGeneral = other.getDescripcionGeneral();
        if (this$descripcionGeneral == null) {
            if (other$descripcionGeneral != null) {
                return false;
            }
        } else if (!this$descripcionGeneral.equals(other$descripcionGeneral)) {
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
        Object this$response = getResponse();
        Object other$response = other.getResponse();
        if (this$response == null) {
            if (other$response != null) {
                return false;
            }
        } else if (!this$response.equals(other$response)) {
            return false;
        }
        Object this$responseEstado = getResponseEstado();
        Object other$responseEstado = other.getResponseEstado();
        if (this$responseEstado == null) {
            if (other$responseEstado != null) {
                return false;
            }
        } else if (!this$responseEstado.equals(other$responseEstado)) {
            return false;
        }
        Object this$listaDetalleNota = getListaDetalleNota();
        Object other$listaDetalleNota = other.getListaDetalleNota();
        return this$listaDetalleNota == null ? other$listaDetalleNota == null : this$listaDetalleNota.equals(other$listaDetalleNota);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof FacturaNotaDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idConceptoNota = getIdConceptoNota();
        int result2 = (result * 59) + ($idConceptoNota == null ? 43 : $idConceptoNota.hashCode());
        Object $idRespuestaGlosa = getIdRespuestaGlosa();
        int result3 = (result2 * 59) + ($idRespuestaGlosa == null ? 43 : $idRespuestaGlosa.hashCode());
        Object $idLiquidacion = getIdLiquidacion();
        int result4 = (result3 * 59) + ($idLiquidacion == null ? 43 : $idLiquidacion.hashCode());
        Object $numeroConsecutivo = getNumeroConsecutivo();
        int result5 = (result4 * 59) + ($numeroConsecutivo == null ? 43 : $numeroConsecutivo.hashCode());
        Object $idResolucion = getIdResolucion();
        int result6 = (result5 * 59) + ($idResolucion == null ? 43 : $idResolucion.hashCode());
        Object $estado = getEstado();
        int result7 = (result6 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $idUsuarioRh = getIdUsuarioRh();
        int result8 = (result7 * 59) + ($idUsuarioRh == null ? 43 : $idUsuarioRh.hashCode());
        Object $enviada = getEnviada();
        int result9 = (result8 * 59) + ($enviada == null ? 43 : $enviada.hashCode());
        Object $notaSinFactura = getNotaSinFactura();
        int result10 = (result9 * 59) + ($notaSinFactura == null ? 43 : $notaSinFactura.hashCode());
        Object $fechaNota = getFechaNota();
        int result11 = (result10 * 59) + ($fechaNota == null ? 43 : $fechaNota.hashCode());
        Object $prefijo = getPrefijo();
        int result12 = (result11 * 59) + ($prefijo == null ? 43 : $prefijo.hashCode());
        Object $descripcionGeneral = getDescripcionGeneral();
        int result13 = (result12 * 59) + ($descripcionGeneral == null ? 43 : $descripcionGeneral.hashCode());
        Object $fecha = getFecha();
        int result14 = (result13 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $response = getResponse();
        int result15 = (result14 * 59) + ($response == null ? 43 : $response.hashCode());
        Object $responseEstado = getResponseEstado();
        int result16 = (result15 * 59) + ($responseEstado == null ? 43 : $responseEstado.hashCode());
        Object $listaDetalleNota = getListaDetalleNota();
        return (result16 * 59) + ($listaDetalleNota == null ? 43 : $listaDetalleNota.hashCode());
    }

    @Generated
    public String toString() {
        return "FacturaNotaDTO(id=" + getId() + ", fechaNota=" + getFechaNota() + ", idConceptoNota=" + getIdConceptoNota() + ", idRespuestaGlosa=" + getIdRespuestaGlosa() + ", idLiquidacion=" + getIdLiquidacion() + ", prefijo=" + getPrefijo() + ", numeroConsecutivo=" + getNumeroConsecutivo() + ", idResolucion=" + getIdResolucion() + ", descripcionGeneral=" + getDescripcionGeneral() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ", idUsuarioRh=" + getIdUsuarioRh() + ", enviada=" + getEnviada() + ", response=" + getResponse() + ", responseEstado=" + getResponseEstado() + ", notaSinFactura=" + getNotaSinFactura() + ", listaDetalleNota=" + getListaDetalleNota() + ")";
    }

    @Generated
    public static FacturaNotaDTOBuilder builder() {
        return new FacturaNotaDTOBuilder();
    }

    @Generated
    public FacturaNotaDTO(Integer id, Date fechaNota, Integer idConceptoNota, Long idRespuestaGlosa, Long idLiquidacion, String prefijo, Integer numeroConsecutivo, Integer idResolucion, String descripcionGeneral, Boolean estado, Date fecha, Long idUsuarioRh, Boolean enviada, String response, String responseEstado, Boolean notaSinFactura, List<FacturaNotaDetalleDTO> listaDetalleNota) {
        this.id = id;
        this.fechaNota = fechaNota;
        this.idConceptoNota = idConceptoNota;
        this.idRespuestaGlosa = idRespuestaGlosa;
        this.idLiquidacion = idLiquidacion;
        this.prefijo = prefijo;
        this.numeroConsecutivo = numeroConsecutivo;
        this.idResolucion = idResolucion;
        this.descripcionGeneral = descripcionGeneral;
        this.estado = estado;
        this.fecha = fecha;
        this.idUsuarioRh = idUsuarioRh;
        this.enviada = enviada;
        this.response = response;
        this.responseEstado = responseEstado;
        this.notaSinFactura = notaSinFactura;
        this.listaDetalleNota = listaDetalleNota;
    }

    @Generated
    public FacturaNotaDTO() {
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setFechaNota(Date fechaNota) {
        this.fechaNota = fechaNota;
    }

    @Generated
    public void setIdConceptoNota(Integer idConceptoNota) {
        this.idConceptoNota = idConceptoNota;
    }

    @Generated
    public void setIdRespuestaGlosa(Long idRespuestaGlosa) {
        this.idRespuestaGlosa = idRespuestaGlosa;
    }

    @Generated
    public void setIdLiquidacion(Long idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    @Generated
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    @Generated
    public void setNumeroConsecutivo(Integer numeroConsecutivo) {
        this.numeroConsecutivo = numeroConsecutivo;
    }

    @Generated
    public void setIdResolucion(Integer idResolucion) {
        this.idResolucion = idResolucion;
    }

    @Generated
    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setIdUsuarioRh(Long idUsuarioRh) {
        this.idUsuarioRh = idUsuarioRh;
    }

    @Generated
    public void setEnviada(Boolean enviada) {
        this.enviada = enviada;
    }

    @Generated
    public void setResponse(String response) {
        this.response = response;
    }

    @Generated
    public void setResponseEstado(String responseEstado) {
        this.responseEstado = responseEstado;
    }

    @Generated
    public void setNotaSinFactura(Boolean notaSinFactura) {
        this.notaSinFactura = notaSinFactura;
    }

    @Generated
    public void setListaDetalleNota(List<FacturaNotaDetalleDTO> listaDetalleNota) {
        this.listaDetalleNota = listaDetalleNota;
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public Date getFechaNota() {
        return this.fechaNota;
    }

    @Generated
    public Integer getIdConceptoNota() {
        return this.idConceptoNota;
    }

    @Generated
    public Long getIdRespuestaGlosa() {
        return this.idRespuestaGlosa;
    }

    @Generated
    public Long getIdLiquidacion() {
        return this.idLiquidacion;
    }

    @Generated
    public String getPrefijo() {
        return this.prefijo;
    }

    @Generated
    public Integer getNumeroConsecutivo() {
        return this.numeroConsecutivo;
    }

    @Generated
    public Integer getIdResolucion() {
        return this.idResolucion;
    }

    @Generated
    public String getDescripcionGeneral() {
        return this.descripcionGeneral;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public Long getIdUsuarioRh() {
        return this.idUsuarioRh;
    }

    @Generated
    public Boolean getEnviada() {
        return this.enviada;
    }

    @Generated
    public String getResponse() {
        return this.response;
    }

    @Generated
    public String getResponseEstado() {
        return this.responseEstado;
    }

    @Generated
    public Boolean getNotaSinFactura() {
        return this.notaSinFactura;
    }

    @Generated
    public List<FacturaNotaDetalleDTO> getListaDetalleNota() {
        return this.listaDetalleNota;
    }
}
