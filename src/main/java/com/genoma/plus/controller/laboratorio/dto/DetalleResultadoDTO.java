package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/DetalleResultadoDTO.class */
public class DetalleResultadoDTO {
    private Long id;
    private Long idResultado;
    private String fecha;
    private Long bacteriologo;
    private Long idEspecialidad;
    private Long idProcedimiento;
    private Integer idProtocolprocedim;
    private Integer resultado;
    private String vrNumerico;
    private String unidad;
    private String valorRefecenciaMinimo;
    private String valorRefecenciaMaximo;
    private String observacion;
    private Integer alterado;
    private Integer imprime;
    private Integer validado;
    private Long idEspecialidadV;
    private Long idProfesionalV;
    private Integer enviado;
    private String nEquipoT;
    private Integer estado;
    private Integer estadoGIIS;
    private String codigoExterno;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DetalleResultadoDTO)) {
            return false;
        }
        DetalleResultadoDTO other = (DetalleResultadoDTO) o;
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
        Object this$idResultado = getIdResultado();
        Object other$idResultado = other.getIdResultado();
        if (this$idResultado == null) {
            if (other$idResultado != null) {
                return false;
            }
        } else if (!this$idResultado.equals(other$idResultado)) {
            return false;
        }
        Object this$bacteriologo = getBacteriologo();
        Object other$bacteriologo = other.getBacteriologo();
        if (this$bacteriologo == null) {
            if (other$bacteriologo != null) {
                return false;
            }
        } else if (!this$bacteriologo.equals(other$bacteriologo)) {
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
        Object this$idProcedimiento = getIdProcedimiento();
        Object other$idProcedimiento = other.getIdProcedimiento();
        if (this$idProcedimiento == null) {
            if (other$idProcedimiento != null) {
                return false;
            }
        } else if (!this$idProcedimiento.equals(other$idProcedimiento)) {
            return false;
        }
        Object this$idProtocolprocedim = getIdProtocolprocedim();
        Object other$idProtocolprocedim = other.getIdProtocolprocedim();
        if (this$idProtocolprocedim == null) {
            if (other$idProtocolprocedim != null) {
                return false;
            }
        } else if (!this$idProtocolprocedim.equals(other$idProtocolprocedim)) {
            return false;
        }
        Object this$resultado = getResultado();
        Object other$resultado = other.getResultado();
        if (this$resultado == null) {
            if (other$resultado != null) {
                return false;
            }
        } else if (!this$resultado.equals(other$resultado)) {
            return false;
        }
        Object this$alterado = getAlterado();
        Object other$alterado = other.getAlterado();
        if (this$alterado == null) {
            if (other$alterado != null) {
                return false;
            }
        } else if (!this$alterado.equals(other$alterado)) {
            return false;
        }
        Object this$imprime = getImprime();
        Object other$imprime = other.getImprime();
        if (this$imprime == null) {
            if (other$imprime != null) {
                return false;
            }
        } else if (!this$imprime.equals(other$imprime)) {
            return false;
        }
        Object this$validado = getValidado();
        Object other$validado = other.getValidado();
        if (this$validado == null) {
            if (other$validado != null) {
                return false;
            }
        } else if (!this$validado.equals(other$validado)) {
            return false;
        }
        Object this$idEspecialidadV = getIdEspecialidadV();
        Object other$idEspecialidadV = other.getIdEspecialidadV();
        if (this$idEspecialidadV == null) {
            if (other$idEspecialidadV != null) {
                return false;
            }
        } else if (!this$idEspecialidadV.equals(other$idEspecialidadV)) {
            return false;
        }
        Object this$idProfesionalV = getIdProfesionalV();
        Object other$idProfesionalV = other.getIdProfesionalV();
        if (this$idProfesionalV == null) {
            if (other$idProfesionalV != null) {
                return false;
            }
        } else if (!this$idProfesionalV.equals(other$idProfesionalV)) {
            return false;
        }
        Object this$enviado = getEnviado();
        Object other$enviado = other.getEnviado();
        if (this$enviado == null) {
            if (other$enviado != null) {
                return false;
            }
        } else if (!this$enviado.equals(other$enviado)) {
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
        Object this$estadoGIIS = getEstadoGIIS();
        Object other$estadoGIIS = other.getEstadoGIIS();
        if (this$estadoGIIS == null) {
            if (other$estadoGIIS != null) {
                return false;
            }
        } else if (!this$estadoGIIS.equals(other$estadoGIIS)) {
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
        Object this$vrNumerico = getVrNumerico();
        Object other$vrNumerico = other.getVrNumerico();
        if (this$vrNumerico == null) {
            if (other$vrNumerico != null) {
                return false;
            }
        } else if (!this$vrNumerico.equals(other$vrNumerico)) {
            return false;
        }
        Object this$unidad = getUnidad();
        Object other$unidad = other.getUnidad();
        if (this$unidad == null) {
            if (other$unidad != null) {
                return false;
            }
        } else if (!this$unidad.equals(other$unidad)) {
            return false;
        }
        Object this$valorRefecenciaMinimo = getValorRefecenciaMinimo();
        Object other$valorRefecenciaMinimo = other.getValorRefecenciaMinimo();
        if (this$valorRefecenciaMinimo == null) {
            if (other$valorRefecenciaMinimo != null) {
                return false;
            }
        } else if (!this$valorRefecenciaMinimo.equals(other$valorRefecenciaMinimo)) {
            return false;
        }
        Object this$valorRefecenciaMaximo = getValorRefecenciaMaximo();
        Object other$valorRefecenciaMaximo = other.getValorRefecenciaMaximo();
        if (this$valorRefecenciaMaximo == null) {
            if (other$valorRefecenciaMaximo != null) {
                return false;
            }
        } else if (!this$valorRefecenciaMaximo.equals(other$valorRefecenciaMaximo)) {
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
        Object this$nEquipoT = getNEquipoT();
        Object other$nEquipoT = other.getNEquipoT();
        if (this$nEquipoT == null) {
            if (other$nEquipoT != null) {
                return false;
            }
        } else if (!this$nEquipoT.equals(other$nEquipoT)) {
            return false;
        }
        Object this$codigoExterno = getCodigoExterno();
        Object other$codigoExterno = other.getCodigoExterno();
        return this$codigoExterno == null ? other$codigoExterno == null : this$codigoExterno.equals(other$codigoExterno);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DetalleResultadoDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idResultado = getIdResultado();
        int result2 = (result * 59) + ($idResultado == null ? 43 : $idResultado.hashCode());
        Object $bacteriologo = getBacteriologo();
        int result3 = (result2 * 59) + ($bacteriologo == null ? 43 : $bacteriologo.hashCode());
        Object $idEspecialidad = getIdEspecialidad();
        int result4 = (result3 * 59) + ($idEspecialidad == null ? 43 : $idEspecialidad.hashCode());
        Object $idProcedimiento = getIdProcedimiento();
        int result5 = (result4 * 59) + ($idProcedimiento == null ? 43 : $idProcedimiento.hashCode());
        Object $idProtocolprocedim = getIdProtocolprocedim();
        int result6 = (result5 * 59) + ($idProtocolprocedim == null ? 43 : $idProtocolprocedim.hashCode());
        Object $resultado = getResultado();
        int result7 = (result6 * 59) + ($resultado == null ? 43 : $resultado.hashCode());
        Object $alterado = getAlterado();
        int result8 = (result7 * 59) + ($alterado == null ? 43 : $alterado.hashCode());
        Object $imprime = getImprime();
        int result9 = (result8 * 59) + ($imprime == null ? 43 : $imprime.hashCode());
        Object $validado = getValidado();
        int result10 = (result9 * 59) + ($validado == null ? 43 : $validado.hashCode());
        Object $idEspecialidadV = getIdEspecialidadV();
        int result11 = (result10 * 59) + ($idEspecialidadV == null ? 43 : $idEspecialidadV.hashCode());
        Object $idProfesionalV = getIdProfesionalV();
        int result12 = (result11 * 59) + ($idProfesionalV == null ? 43 : $idProfesionalV.hashCode());
        Object $enviado = getEnviado();
        int result13 = (result12 * 59) + ($enviado == null ? 43 : $enviado.hashCode());
        Object $estado = getEstado();
        int result14 = (result13 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $estadoGIIS = getEstadoGIIS();
        int result15 = (result14 * 59) + ($estadoGIIS == null ? 43 : $estadoGIIS.hashCode());
        Object $fecha = getFecha();
        int result16 = (result15 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $vrNumerico = getVrNumerico();
        int result17 = (result16 * 59) + ($vrNumerico == null ? 43 : $vrNumerico.hashCode());
        Object $unidad = getUnidad();
        int result18 = (result17 * 59) + ($unidad == null ? 43 : $unidad.hashCode());
        Object $valorRefecenciaMinimo = getValorRefecenciaMinimo();
        int result19 = (result18 * 59) + ($valorRefecenciaMinimo == null ? 43 : $valorRefecenciaMinimo.hashCode());
        Object $valorRefecenciaMaximo = getValorRefecenciaMaximo();
        int result20 = (result19 * 59) + ($valorRefecenciaMaximo == null ? 43 : $valorRefecenciaMaximo.hashCode());
        Object $observacion = getObservacion();
        int result21 = (result20 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $nEquipoT = getNEquipoT();
        int result22 = (result21 * 59) + ($nEquipoT == null ? 43 : $nEquipoT.hashCode());
        Object $codigoExterno = getCodigoExterno();
        return (result22 * 59) + ($codigoExterno == null ? 43 : $codigoExterno.hashCode());
    }

    @Generated
    public String toString() {
        return "DetalleResultadoDTO(id=" + getId() + ", idResultado=" + getIdResultado() + ", fecha=" + getFecha() + ", bacteriologo=" + getBacteriologo() + ", idEspecialidad=" + getIdEspecialidad() + ", idProcedimiento=" + getIdProcedimiento() + ", idProtocolprocedim=" + getIdProtocolprocedim() + ", resultado=" + getResultado() + ", vrNumerico=" + getVrNumerico() + ", unidad=" + getUnidad() + ", valorRefecenciaMinimo=" + getValorRefecenciaMinimo() + ", valorRefecenciaMaximo=" + getValorRefecenciaMaximo() + ", observacion=" + getObservacion() + ", alterado=" + getAlterado() + ", imprime=" + getImprime() + ", validado=" + getValidado() + ", idEspecialidadV=" + getIdEspecialidadV() + ", idProfesionalV=" + getIdProfesionalV() + ", enviado=" + getEnviado() + ", nEquipoT=" + getNEquipoT() + ", estado=" + getEstado() + ", estadoGIIS=" + getEstadoGIIS() + ", codigoExterno=" + getCodigoExterno() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/DetalleResultadoDTO$DetalleResultadoDTOBuilder.class */
    @Generated
    public static class DetalleResultadoDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idResultado;

        @Generated
        private String fecha;

        @Generated
        private Long bacteriologo;

        @Generated
        private Long idEspecialidad;

        @Generated
        private Long idProcedimiento;

        @Generated
        private Integer idProtocolprocedim;

        @Generated
        private Integer resultado;

        @Generated
        private String vrNumerico;

        @Generated
        private String unidad;

        @Generated
        private String valorRefecenciaMinimo;

        @Generated
        private String valorRefecenciaMaximo;

        @Generated
        private String observacion;

        @Generated
        private Integer alterado;

        @Generated
        private Integer imprime;

        @Generated
        private Integer validado;

        @Generated
        private Long idEspecialidadV;

        @Generated
        private Long idProfesionalV;

        @Generated
        private Integer enviado;

        @Generated
        private String nEquipoT;

        @Generated
        private Integer estado;

        @Generated
        private Integer estadoGIIS;

        @Generated
        private String codigoExterno;

        @Generated
        DetalleResultadoDTOBuilder() {
        }

        @Generated
        public DetalleResultadoDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idResultado(Long idResultado) {
            this.idResultado = idResultado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder bacteriologo(Long bacteriologo) {
            this.bacteriologo = bacteriologo;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idEspecialidad(Long idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idProcedimiento(Long idProcedimiento) {
            this.idProcedimiento = idProcedimiento;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idProtocolprocedim(Integer idProtocolprocedim) {
            this.idProtocolprocedim = idProtocolprocedim;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder resultado(Integer resultado) {
            this.resultado = resultado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder vrNumerico(String vrNumerico) {
            this.vrNumerico = vrNumerico;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder unidad(String unidad) {
            this.unidad = unidad;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder valorRefecenciaMinimo(String valorRefecenciaMinimo) {
            this.valorRefecenciaMinimo = valorRefecenciaMinimo;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder valorRefecenciaMaximo(String valorRefecenciaMaximo) {
            this.valorRefecenciaMaximo = valorRefecenciaMaximo;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder alterado(Integer alterado) {
            this.alterado = alterado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder imprime(Integer imprime) {
            this.imprime = imprime;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder validado(Integer validado) {
            this.validado = validado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idEspecialidadV(Long idEspecialidadV) {
            this.idEspecialidadV = idEspecialidadV;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder idProfesionalV(Long idProfesionalV) {
            this.idProfesionalV = idProfesionalV;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder enviado(Integer enviado) {
            this.enviado = enviado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder nEquipoT(String nEquipoT) {
            this.nEquipoT = nEquipoT;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder estado(Integer estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder estadoGIIS(Integer estadoGIIS) {
            this.estadoGIIS = estadoGIIS;
            return this;
        }

        @Generated
        public DetalleResultadoDTOBuilder codigoExterno(String codigoExterno) {
            this.codigoExterno = codigoExterno;
            return this;
        }

        @Generated
        public DetalleResultadoDTO build() {
            return new DetalleResultadoDTO(this.id, this.idResultado, this.fecha, this.bacteriologo, this.idEspecialidad, this.idProcedimiento, this.idProtocolprocedim, this.resultado, this.vrNumerico, this.unidad, this.valorRefecenciaMinimo, this.valorRefecenciaMaximo, this.observacion, this.alterado, this.imprime, this.validado, this.idEspecialidadV, this.idProfesionalV, this.enviado, this.nEquipoT, this.estado, this.estadoGIIS, this.codigoExterno);
        }

        @Generated
        public String toString() {
            return "DetalleResultadoDTO.DetalleResultadoDTOBuilder(id=" + this.id + ", idResultado=" + this.idResultado + ", fecha=" + this.fecha + ", bacteriologo=" + this.bacteriologo + ", idEspecialidad=" + this.idEspecialidad + ", idProcedimiento=" + this.idProcedimiento + ", idProtocolprocedim=" + this.idProtocolprocedim + ", resultado=" + this.resultado + ", vrNumerico=" + this.vrNumerico + ", unidad=" + this.unidad + ", valorRefecenciaMinimo=" + this.valorRefecenciaMinimo + ", valorRefecenciaMaximo=" + this.valorRefecenciaMaximo + ", observacion=" + this.observacion + ", alterado=" + this.alterado + ", imprime=" + this.imprime + ", validado=" + this.validado + ", idEspecialidadV=" + this.idEspecialidadV + ", idProfesionalV=" + this.idProfesionalV + ", enviado=" + this.enviado + ", nEquipoT=" + this.nEquipoT + ", estado=" + this.estado + ", estadoGIIS=" + this.estadoGIIS + ", codigoExterno=" + this.codigoExterno + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    @Generated
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setBacteriologo(Long bacteriologo) {
        this.bacteriologo = bacteriologo;
    }

    @Generated
    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Generated
    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Generated
    public void setIdProtocolprocedim(Integer idProtocolprocedim) {
        this.idProtocolprocedim = idProtocolprocedim;
    }

    @Generated
    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    @Generated
    public void setVrNumerico(String vrNumerico) {
        this.vrNumerico = vrNumerico;
    }

    @Generated
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Generated
    public void setValorRefecenciaMinimo(String valorRefecenciaMinimo) {
        this.valorRefecenciaMinimo = valorRefecenciaMinimo;
    }

    @Generated
    public void setValorRefecenciaMaximo(String valorRefecenciaMaximo) {
        this.valorRefecenciaMaximo = valorRefecenciaMaximo;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setAlterado(Integer alterado) {
        this.alterado = alterado;
    }

    @Generated
    public void setImprime(Integer imprime) {
        this.imprime = imprime;
    }

    @Generated
    public void setValidado(Integer validado) {
        this.validado = validado;
    }

    @Generated
    public void setIdEspecialidadV(Long idEspecialidadV) {
        this.idEspecialidadV = idEspecialidadV;
    }

    @Generated
    public void setIdProfesionalV(Long idProfesionalV) {
        this.idProfesionalV = idProfesionalV;
    }

    @Generated
    public void setEnviado(Integer enviado) {
        this.enviado = enviado;
    }

    @Generated
    public void setNEquipoT(String nEquipoT) {
        this.nEquipoT = nEquipoT;
    }

    @Generated
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Generated
    public void setEstadoGIIS(Integer estadoGIIS) {
        this.estadoGIIS = estadoGIIS;
    }

    @Generated
    public void setCodigoExterno(String codigoExterno) {
        this.codigoExterno = codigoExterno;
    }

    @Generated
    public static DetalleResultadoDTOBuilder builder() {
        return new DetalleResultadoDTOBuilder();
    }

    @Generated
    public DetalleResultadoDTO(Long id, Long idResultado, String fecha, Long bacteriologo, Long idEspecialidad, Long idProcedimiento, Integer idProtocolprocedim, Integer resultado, String vrNumerico, String unidad, String valorRefecenciaMinimo, String valorRefecenciaMaximo, String observacion, Integer alterado, Integer imprime, Integer validado, Long idEspecialidadV, Long idProfesionalV, Integer enviado, String nEquipoT, Integer estado, Integer estadoGIIS, String codigoExterno) {
        this.id = id;
        this.idResultado = idResultado;
        this.fecha = fecha;
        this.bacteriologo = bacteriologo;
        this.idEspecialidad = idEspecialidad;
        this.idProcedimiento = idProcedimiento;
        this.idProtocolprocedim = idProtocolprocedim;
        this.resultado = resultado;
        this.vrNumerico = vrNumerico;
        this.unidad = unidad;
        this.valorRefecenciaMinimo = valorRefecenciaMinimo;
        this.valorRefecenciaMaximo = valorRefecenciaMaximo;
        this.observacion = observacion;
        this.alterado = alterado;
        this.imprime = imprime;
        this.validado = validado;
        this.idEspecialidadV = idEspecialidadV;
        this.idProfesionalV = idProfesionalV;
        this.enviado = enviado;
        this.nEquipoT = nEquipoT;
        this.estado = estado;
        this.estadoGIIS = estadoGIIS;
        this.codigoExterno = codigoExterno;
    }

    @Generated
    public DetalleResultadoDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdResultado() {
        return this.idResultado;
    }

    @Generated
    public String getFecha() {
        return this.fecha;
    }

    @Generated
    public Long getBacteriologo() {
        return this.bacteriologo;
    }

    @Generated
    public Long getIdEspecialidad() {
        return this.idEspecialidad;
    }

    @Generated
    public Long getIdProcedimiento() {
        return this.idProcedimiento;
    }

    @Generated
    public Integer getIdProtocolprocedim() {
        return this.idProtocolprocedim;
    }

    @Generated
    public Integer getResultado() {
        return this.resultado;
    }

    @Generated
    public String getVrNumerico() {
        return this.vrNumerico;
    }

    @Generated
    public String getUnidad() {
        return this.unidad;
    }

    @Generated
    public String getValorRefecenciaMinimo() {
        return this.valorRefecenciaMinimo;
    }

    @Generated
    public String getValorRefecenciaMaximo() {
        return this.valorRefecenciaMaximo;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Integer getAlterado() {
        return this.alterado;
    }

    @Generated
    public Integer getImprime() {
        return this.imprime;
    }

    @Generated
    public Integer getValidado() {
        return this.validado;
    }

    @Generated
    public Long getIdEspecialidadV() {
        return this.idEspecialidadV;
    }

    @Generated
    public Long getIdProfesionalV() {
        return this.idProfesionalV;
    }

    @Generated
    public Integer getEnviado() {
        return this.enviado;
    }

    @Generated
    public String getNEquipoT() {
        return this.nEquipoT;
    }

    @Generated
    public Integer getEstado() {
        return this.estado;
    }

    @Generated
    public Integer getEstadoGIIS() {
        return this.estadoGIIS;
    }

    @Generated
    public String getCodigoExterno() {
        return this.codigoExterno;
    }
}
