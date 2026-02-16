package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo2335Dto.class */
public class Anexo2335Dto {
    private Long id;
    private Long ingresoId;
    private Long idOrden;
    private Integer consecutivo;
    private Integer consecutivoTipo;
    private String fechaRegistro;
    private String horaRegistro;
    private Integer tipoAnexo;
    private Boolean estado;
    private Long idUsuarioS;
    private AnexoDatoUsuarioDto anexoDatoUsuario;
    private AnexoInformacionIpsDto anexoInformacionIps;
    private Anexo2Dto anexo2;
    private Anexo3Dto anexo3;
    private Anexo5Dto anexo5;
    private Anexo6Dto anexo6;
    private String profesionalId;
    private String especialidadId;
    private String identificacion;
    private String cargo;
    private String personaCargo;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Anexo2335Dto)) {
            return false;
        }
        Anexo2335Dto other = (Anexo2335Dto) o;
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
        Object this$ingresoId = getIngresoId();
        Object other$ingresoId = other.getIngresoId();
        if (this$ingresoId == null) {
            if (other$ingresoId != null) {
                return false;
            }
        } else if (!this$ingresoId.equals(other$ingresoId)) {
            return false;
        }
        Object this$idOrden = getIdOrden();
        Object other$idOrden = other.getIdOrden();
        if (this$idOrden == null) {
            if (other$idOrden != null) {
                return false;
            }
        } else if (!this$idOrden.equals(other$idOrden)) {
            return false;
        }
        Object this$consecutivo = getConsecutivo();
        Object other$consecutivo = other.getConsecutivo();
        if (this$consecutivo == null) {
            if (other$consecutivo != null) {
                return false;
            }
        } else if (!this$consecutivo.equals(other$consecutivo)) {
            return false;
        }
        Object this$consecutivoTipo = getConsecutivoTipo();
        Object other$consecutivoTipo = other.getConsecutivoTipo();
        if (this$consecutivoTipo == null) {
            if (other$consecutivoTipo != null) {
                return false;
            }
        } else if (!this$consecutivoTipo.equals(other$consecutivoTipo)) {
            return false;
        }
        Object this$tipoAnexo = getTipoAnexo();
        Object other$tipoAnexo = other.getTipoAnexo();
        if (this$tipoAnexo == null) {
            if (other$tipoAnexo != null) {
                return false;
            }
        } else if (!this$tipoAnexo.equals(other$tipoAnexo)) {
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
        Object this$idUsuarioS = getIdUsuarioS();
        Object other$idUsuarioS = other.getIdUsuarioS();
        if (this$idUsuarioS == null) {
            if (other$idUsuarioS != null) {
                return false;
            }
        } else if (!this$idUsuarioS.equals(other$idUsuarioS)) {
            return false;
        }
        Object this$fechaRegistro = getFechaRegistro();
        Object other$fechaRegistro = other.getFechaRegistro();
        if (this$fechaRegistro == null) {
            if (other$fechaRegistro != null) {
                return false;
            }
        } else if (!this$fechaRegistro.equals(other$fechaRegistro)) {
            return false;
        }
        Object this$horaRegistro = getHoraRegistro();
        Object other$horaRegistro = other.getHoraRegistro();
        if (this$horaRegistro == null) {
            if (other$horaRegistro != null) {
                return false;
            }
        } else if (!this$horaRegistro.equals(other$horaRegistro)) {
            return false;
        }
        Object this$anexoDatoUsuario = getAnexoDatoUsuario();
        Object other$anexoDatoUsuario = other.getAnexoDatoUsuario();
        if (this$anexoDatoUsuario == null) {
            if (other$anexoDatoUsuario != null) {
                return false;
            }
        } else if (!this$anexoDatoUsuario.equals(other$anexoDatoUsuario)) {
            return false;
        }
        Object this$anexoInformacionIps = getAnexoInformacionIps();
        Object other$anexoInformacionIps = other.getAnexoInformacionIps();
        if (this$anexoInformacionIps == null) {
            if (other$anexoInformacionIps != null) {
                return false;
            }
        } else if (!this$anexoInformacionIps.equals(other$anexoInformacionIps)) {
            return false;
        }
        Object this$anexo2 = getAnexo2();
        Object other$anexo2 = other.getAnexo2();
        if (this$anexo2 == null) {
            if (other$anexo2 != null) {
                return false;
            }
        } else if (!this$anexo2.equals(other$anexo2)) {
            return false;
        }
        Object this$anexo3 = getAnexo3();
        Object other$anexo3 = other.getAnexo3();
        if (this$anexo3 == null) {
            if (other$anexo3 != null) {
                return false;
            }
        } else if (!this$anexo3.equals(other$anexo3)) {
            return false;
        }
        Object this$anexo5 = getAnexo5();
        Object other$anexo5 = other.getAnexo5();
        if (this$anexo5 == null) {
            if (other$anexo5 != null) {
                return false;
            }
        } else if (!this$anexo5.equals(other$anexo5)) {
            return false;
        }
        Object this$anexo6 = getAnexo6();
        Object other$anexo6 = other.getAnexo6();
        if (this$anexo6 == null) {
            if (other$anexo6 != null) {
                return false;
            }
        } else if (!this$anexo6.equals(other$anexo6)) {
            return false;
        }
        Object this$profesionalId = getProfesionalId();
        Object other$profesionalId = other.getProfesionalId();
        if (this$profesionalId == null) {
            if (other$profesionalId != null) {
                return false;
            }
        } else if (!this$profesionalId.equals(other$profesionalId)) {
            return false;
        }
        Object this$especialidadId = getEspecialidadId();
        Object other$especialidadId = other.getEspecialidadId();
        if (this$especialidadId == null) {
            if (other$especialidadId != null) {
                return false;
            }
        } else if (!this$especialidadId.equals(other$especialidadId)) {
            return false;
        }
        Object this$identificacion = getIdentificacion();
        Object other$identificacion = other.getIdentificacion();
        if (this$identificacion == null) {
            if (other$identificacion != null) {
                return false;
            }
        } else if (!this$identificacion.equals(other$identificacion)) {
            return false;
        }
        Object this$cargo = getCargo();
        Object other$cargo = other.getCargo();
        if (this$cargo == null) {
            if (other$cargo != null) {
                return false;
            }
        } else if (!this$cargo.equals(other$cargo)) {
            return false;
        }
        Object this$personaCargo = getPersonaCargo();
        Object other$personaCargo = other.getPersonaCargo();
        return this$personaCargo == null ? other$personaCargo == null : this$personaCargo.equals(other$personaCargo);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Anexo2335Dto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $ingresoId = getIngresoId();
        int result2 = (result * 59) + ($ingresoId == null ? 43 : $ingresoId.hashCode());
        Object $idOrden = getIdOrden();
        int result3 = (result2 * 59) + ($idOrden == null ? 43 : $idOrden.hashCode());
        Object $consecutivo = getConsecutivo();
        int result4 = (result3 * 59) + ($consecutivo == null ? 43 : $consecutivo.hashCode());
        Object $consecutivoTipo = getConsecutivoTipo();
        int result5 = (result4 * 59) + ($consecutivoTipo == null ? 43 : $consecutivoTipo.hashCode());
        Object $tipoAnexo = getTipoAnexo();
        int result6 = (result5 * 59) + ($tipoAnexo == null ? 43 : $tipoAnexo.hashCode());
        Object $estado = getEstado();
        int result7 = (result6 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $idUsuarioS = getIdUsuarioS();
        int result8 = (result7 * 59) + ($idUsuarioS == null ? 43 : $idUsuarioS.hashCode());
        Object $fechaRegistro = getFechaRegistro();
        int result9 = (result8 * 59) + ($fechaRegistro == null ? 43 : $fechaRegistro.hashCode());
        Object $horaRegistro = getHoraRegistro();
        int result10 = (result9 * 59) + ($horaRegistro == null ? 43 : $horaRegistro.hashCode());
        Object $anexoDatoUsuario = getAnexoDatoUsuario();
        int result11 = (result10 * 59) + ($anexoDatoUsuario == null ? 43 : $anexoDatoUsuario.hashCode());
        Object $anexoInformacionIps = getAnexoInformacionIps();
        int result12 = (result11 * 59) + ($anexoInformacionIps == null ? 43 : $anexoInformacionIps.hashCode());
        Object $anexo2 = getAnexo2();
        int result13 = (result12 * 59) + ($anexo2 == null ? 43 : $anexo2.hashCode());
        Object $anexo3 = getAnexo3();
        int result14 = (result13 * 59) + ($anexo3 == null ? 43 : $anexo3.hashCode());
        Object $anexo5 = getAnexo5();
        int result15 = (result14 * 59) + ($anexo5 == null ? 43 : $anexo5.hashCode());
        Object $anexo6 = getAnexo6();
        int result16 = (result15 * 59) + ($anexo6 == null ? 43 : $anexo6.hashCode());
        Object $profesionalId = getProfesionalId();
        int result17 = (result16 * 59) + ($profesionalId == null ? 43 : $profesionalId.hashCode());
        Object $especialidadId = getEspecialidadId();
        int result18 = (result17 * 59) + ($especialidadId == null ? 43 : $especialidadId.hashCode());
        Object $identificacion = getIdentificacion();
        int result19 = (result18 * 59) + ($identificacion == null ? 43 : $identificacion.hashCode());
        Object $cargo = getCargo();
        int result20 = (result19 * 59) + ($cargo == null ? 43 : $cargo.hashCode());
        Object $personaCargo = getPersonaCargo();
        return (result20 * 59) + ($personaCargo == null ? 43 : $personaCargo.hashCode());
    }

    @Generated
    public String toString() {
        return "Anexo2335Dto(id=" + getId() + ", ingresoId=" + getIngresoId() + ", idOrden=" + getIdOrden() + ", consecutivo=" + getConsecutivo() + ", consecutivoTipo=" + getConsecutivoTipo() + ", fechaRegistro=" + getFechaRegistro() + ", horaRegistro=" + getHoraRegistro() + ", tipoAnexo=" + getTipoAnexo() + ", estado=" + getEstado() + ", idUsuarioS=" + getIdUsuarioS() + ", anexoDatoUsuario=" + getAnexoDatoUsuario() + ", anexoInformacionIps=" + getAnexoInformacionIps() + ", anexo2=" + getAnexo2() + ", anexo3=" + getAnexo3() + ", anexo5=" + getAnexo5() + ", anexo6=" + getAnexo6() + ", profesionalId=" + getProfesionalId() + ", especialidadId=" + getEspecialidadId() + ", identificacion=" + getIdentificacion() + ", cargo=" + getCargo() + ", personaCargo=" + getPersonaCargo() + ")";
    }

    @Generated
    public Anexo2335Dto(Long id, Long ingresoId, Long idOrden, Integer consecutivo, Integer consecutivoTipo, String fechaRegistro, String horaRegistro, Integer tipoAnexo, Boolean estado, Long idUsuarioS, AnexoDatoUsuarioDto anexoDatoUsuario, AnexoInformacionIpsDto anexoInformacionIps, Anexo2Dto anexo2, Anexo3Dto anexo3, Anexo5Dto anexo5, Anexo6Dto anexo6, String profesionalId, String especialidadId, String identificacion, String cargo, String personaCargo) {
        this.id = id;
        this.ingresoId = ingresoId;
        this.idOrden = idOrden;
        this.consecutivo = consecutivo;
        this.consecutivoTipo = consecutivoTipo;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.tipoAnexo = tipoAnexo;
        this.estado = estado;
        this.idUsuarioS = idUsuarioS;
        this.anexoDatoUsuario = anexoDatoUsuario;
        this.anexoInformacionIps = anexoInformacionIps;
        this.anexo2 = anexo2;
        this.anexo3 = anexo3;
        this.anexo5 = anexo5;
        this.anexo6 = anexo6;
        this.profesionalId = profesionalId;
        this.especialidadId = especialidadId;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.personaCargo = personaCargo;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo2335Dto$Anexo2335DtoBuilder.class */
    @Generated
    public static class Anexo2335DtoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long ingresoId;

        @Generated
        private Long idOrden;

        @Generated
        private Integer consecutivo;

        @Generated
        private Integer consecutivoTipo;

        @Generated
        private String fechaRegistro;

        @Generated
        private String horaRegistro;

        @Generated
        private Integer tipoAnexo;

        @Generated
        private Boolean estado;

        @Generated
        private Long idUsuarioS;

        @Generated
        private AnexoDatoUsuarioDto anexoDatoUsuario;

        @Generated
        private AnexoInformacionIpsDto anexoInformacionIps;

        @Generated
        private Anexo2Dto anexo2;

        @Generated
        private Anexo3Dto anexo3;

        @Generated
        private Anexo5Dto anexo5;

        @Generated
        private Anexo6Dto anexo6;

        @Generated
        private String profesionalId;

        @Generated
        private String especialidadId;

        @Generated
        private String identificacion;

        @Generated
        private String cargo;

        @Generated
        private String personaCargo;

        @Generated
        Anexo2335DtoBuilder() {
        }

        @Generated
        public Anexo2335DtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder ingresoId(Long ingresoId) {
            this.ingresoId = ingresoId;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder idOrden(Long idOrden) {
            this.idOrden = idOrden;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder consecutivo(Integer consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder consecutivoTipo(Integer consecutivoTipo) {
            this.consecutivoTipo = consecutivoTipo;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder fechaRegistro(String fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder horaRegistro(String horaRegistro) {
            this.horaRegistro = horaRegistro;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder tipoAnexo(Integer tipoAnexo) {
            this.tipoAnexo = tipoAnexo;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder idUsuarioS(Long idUsuarioS) {
            this.idUsuarioS = idUsuarioS;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexoDatoUsuario(AnexoDatoUsuarioDto anexoDatoUsuario) {
            this.anexoDatoUsuario = anexoDatoUsuario;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexoInformacionIps(AnexoInformacionIpsDto anexoInformacionIps) {
            this.anexoInformacionIps = anexoInformacionIps;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexo2(Anexo2Dto anexo2) {
            this.anexo2 = anexo2;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexo3(Anexo3Dto anexo3) {
            this.anexo3 = anexo3;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexo5(Anexo5Dto anexo5) {
            this.anexo5 = anexo5;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder anexo6(Anexo6Dto anexo6) {
            this.anexo6 = anexo6;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder profesionalId(String profesionalId) {
            this.profesionalId = profesionalId;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder especialidadId(String especialidadId) {
            this.especialidadId = especialidadId;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder identificacion(String identificacion) {
            this.identificacion = identificacion;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        @Generated
        public Anexo2335DtoBuilder personaCargo(String personaCargo) {
            this.personaCargo = personaCargo;
            return this;
        }

        @Generated
        public Anexo2335Dto build() {
            return new Anexo2335Dto(this.id, this.ingresoId, this.idOrden, this.consecutivo, this.consecutivoTipo, this.fechaRegistro, this.horaRegistro, this.tipoAnexo, this.estado, this.idUsuarioS, this.anexoDatoUsuario, this.anexoInformacionIps, this.anexo2, this.anexo3, this.anexo5, this.anexo6, this.profesionalId, this.especialidadId, this.identificacion, this.cargo, this.personaCargo);
        }

        @Generated
        public String toString() {
            return "Anexo2335Dto.Anexo2335DtoBuilder(id=" + this.id + ", ingresoId=" + this.ingresoId + ", idOrden=" + this.idOrden + ", consecutivo=" + this.consecutivo + ", consecutivoTipo=" + this.consecutivoTipo + ", fechaRegistro=" + this.fechaRegistro + ", horaRegistro=" + this.horaRegistro + ", tipoAnexo=" + this.tipoAnexo + ", estado=" + this.estado + ", idUsuarioS=" + this.idUsuarioS + ", anexoDatoUsuario=" + this.anexoDatoUsuario + ", anexoInformacionIps=" + this.anexoInformacionIps + ", anexo2=" + this.anexo2 + ", anexo3=" + this.anexo3 + ", anexo5=" + this.anexo5 + ", anexo6=" + this.anexo6 + ", profesionalId=" + this.profesionalId + ", especialidadId=" + this.especialidadId + ", identificacion=" + this.identificacion + ", cargo=" + this.cargo + ", personaCargo=" + this.personaCargo + ")";
        }
    }

    @Generated
    public Anexo2335Dto() {
    }

    @Generated
    public static Anexo2335DtoBuilder builder() {
        return new Anexo2335DtoBuilder();
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIngresoId(Long ingresoId) {
        this.ingresoId = ingresoId;
    }

    @Generated
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    @Generated
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public void setConsecutivoTipo(Integer consecutivoTipo) {
        this.consecutivoTipo = consecutivoTipo;
    }

    @Generated
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Generated
    public void setHoraRegistro(String horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    @Generated
    public void setTipoAnexo(Integer tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setIdUsuarioS(Long idUsuarioS) {
        this.idUsuarioS = idUsuarioS;
    }

    @Generated
    public void setAnexoDatoUsuario(AnexoDatoUsuarioDto anexoDatoUsuario) {
        this.anexoDatoUsuario = anexoDatoUsuario;
    }

    @Generated
    public void setAnexoInformacionIps(AnexoInformacionIpsDto anexoInformacionIps) {
        this.anexoInformacionIps = anexoInformacionIps;
    }

    @Generated
    public void setAnexo2(Anexo2Dto anexo2) {
        this.anexo2 = anexo2;
    }

    @Generated
    public void setAnexo3(Anexo3Dto anexo3) {
        this.anexo3 = anexo3;
    }

    @Generated
    public void setAnexo5(Anexo5Dto anexo5) {
        this.anexo5 = anexo5;
    }

    @Generated
    public void setAnexo6(Anexo6Dto anexo6) {
        this.anexo6 = anexo6;
    }

    @Generated
    public void setProfesionalId(String profesionalId) {
        this.profesionalId = profesionalId;
    }

    @Generated
    public void setEspecialidadId(String especialidadId) {
        this.especialidadId = especialidadId;
    }

    @Generated
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Generated
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Generated
    public void setPersonaCargo(String personaCargo) {
        this.personaCargo = personaCargo;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIngresoId() {
        return this.ingresoId;
    }

    @Generated
    public Long getIdOrden() {
        return this.idOrden;
    }

    @Generated
    public Integer getConsecutivo() {
        return this.consecutivo;
    }

    @Generated
    public Integer getConsecutivoTipo() {
        return this.consecutivoTipo;
    }

    @Generated
    public String getFechaRegistro() {
        return this.fechaRegistro;
    }

    @Generated
    public String getHoraRegistro() {
        return this.horaRegistro;
    }

    @Generated
    public Integer getTipoAnexo() {
        return this.tipoAnexo;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Long getIdUsuarioS() {
        return this.idUsuarioS;
    }

    @Generated
    public AnexoDatoUsuarioDto getAnexoDatoUsuario() {
        return this.anexoDatoUsuario;
    }

    @Generated
    public AnexoInformacionIpsDto getAnexoInformacionIps() {
        return this.anexoInformacionIps;
    }

    @Generated
    public Anexo2Dto getAnexo2() {
        return this.anexo2;
    }

    @Generated
    public Anexo3Dto getAnexo3() {
        return this.anexo3;
    }

    @Generated
    public Anexo5Dto getAnexo5() {
        return this.anexo5;
    }

    @Generated
    public Anexo6Dto getAnexo6() {
        return this.anexo6;
    }

    @Generated
    public String getProfesionalId() {
        return this.profesionalId;
    }

    @Generated
    public String getEspecialidadId() {
        return this.especialidadId;
    }

    @Generated
    public String getIdentificacion() {
        return this.identificacion;
    }

    @Generated
    public String getCargo() {
        return this.cargo;
    }

    @Generated
    public String getPersonaCargo() {
        return this.personaCargo;
    }
}
