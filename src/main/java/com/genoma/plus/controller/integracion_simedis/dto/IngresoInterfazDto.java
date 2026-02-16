package com.genoma.plus.controller.integracion_simedis.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/IngresoInterfazDto.class */
public class IngresoInterfazDto {
    private String idUsuario;
    private String fechaIngreso;
    private String horaIngreso;
    private String idEmpresaContxConv;
    private String esCapitado;
    private String idOrigenAdmision;
    private String idCausaExterna;
    private String idEspecialidad;
    private String idProfesional;
    private String idTipoAtencion;
    private String dxIngreso;
    private String idContrato;
    private String idNivelEstudio;
    private String idParentesco;
    private String idOcupacion;
    private String idAtencion;
    private String idCondVict;
    private String idRemoto;
    private String idTipoAfiliacion;
    private String idTipoContratacion;
    private String idTipoCoberturaPlan;
    private String idSexo;
    private String idTipoDoc;
    private String idIdentidadG;
    private String idTipoDiscapacidad;
    private String idModalidad;
    private String idEntornoAtencion;

    @Generated
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Generated
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Generated
    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    @Generated
    public void setIdEmpresaContxConv(String idEmpresaContxConv) {
        this.idEmpresaContxConv = idEmpresaContxConv;
    }

    @Generated
    public void setEsCapitado(String esCapitado) {
        this.esCapitado = esCapitado;
    }

    @Generated
    public void setIdOrigenAdmision(String idOrigenAdmision) {
        this.idOrigenAdmision = idOrigenAdmision;
    }

    @Generated
    public void setIdCausaExterna(String idCausaExterna) {
        this.idCausaExterna = idCausaExterna;
    }

    @Generated
    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Generated
    public void setIdProfesional(String idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Generated
    public void setIdTipoAtencion(String idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    @Generated
    public void setDxIngreso(String dxIngreso) {
        this.dxIngreso = dxIngreso;
    }

    @Generated
    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    @Generated
    public void setIdNivelEstudio(String idNivelEstudio) {
        this.idNivelEstudio = idNivelEstudio;
    }

    @Generated
    public void setIdParentesco(String idParentesco) {
        this.idParentesco = idParentesco;
    }

    @Generated
    public void setIdOcupacion(String idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    @Generated
    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setIdCondVict(String idCondVict) {
        this.idCondVict = idCondVict;
    }

    @Generated
    public void setIdRemoto(String idRemoto) {
        this.idRemoto = idRemoto;
    }

    @Generated
    public void setIdTipoAfiliacion(String idTipoAfiliacion) {
        this.idTipoAfiliacion = idTipoAfiliacion;
    }

    @Generated
    public void setIdTipoContratacion(String idTipoContratacion) {
        this.idTipoContratacion = idTipoContratacion;
    }

    @Generated
    public void setIdTipoCoberturaPlan(String idTipoCoberturaPlan) {
        this.idTipoCoberturaPlan = idTipoCoberturaPlan;
    }

    @Generated
    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    @Generated
    public void setIdTipoDoc(String idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    @Generated
    public void setIdIdentidadG(String idIdentidadG) {
        this.idIdentidadG = idIdentidadG;
    }

    @Generated
    public void setIdTipoDiscapacidad(String idTipoDiscapacidad) {
        this.idTipoDiscapacidad = idTipoDiscapacidad;
    }

    @Generated
    public void setIdModalidad(String idModalidad) {
        this.idModalidad = idModalidad;
    }

    @Generated
    public void setIdEntornoAtencion(String idEntornoAtencion) {
        this.idEntornoAtencion = idEntornoAtencion;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IngresoInterfazDto)) {
            return false;
        }
        IngresoInterfazDto other = (IngresoInterfazDto) o;
        if (!other.canEqual(this)) {
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
        Object this$fechaIngreso = getFechaIngreso();
        Object other$fechaIngreso = other.getFechaIngreso();
        if (this$fechaIngreso == null) {
            if (other$fechaIngreso != null) {
                return false;
            }
        } else if (!this$fechaIngreso.equals(other$fechaIngreso)) {
            return false;
        }
        Object this$horaIngreso = getHoraIngreso();
        Object other$horaIngreso = other.getHoraIngreso();
        if (this$horaIngreso == null) {
            if (other$horaIngreso != null) {
                return false;
            }
        } else if (!this$horaIngreso.equals(other$horaIngreso)) {
            return false;
        }
        Object this$idEmpresaContxConv = getIdEmpresaContxConv();
        Object other$idEmpresaContxConv = other.getIdEmpresaContxConv();
        if (this$idEmpresaContxConv == null) {
            if (other$idEmpresaContxConv != null) {
                return false;
            }
        } else if (!this$idEmpresaContxConv.equals(other$idEmpresaContxConv)) {
            return false;
        }
        Object this$esCapitado = getEsCapitado();
        Object other$esCapitado = other.getEsCapitado();
        if (this$esCapitado == null) {
            if (other$esCapitado != null) {
                return false;
            }
        } else if (!this$esCapitado.equals(other$esCapitado)) {
            return false;
        }
        Object this$idOrigenAdmision = getIdOrigenAdmision();
        Object other$idOrigenAdmision = other.getIdOrigenAdmision();
        if (this$idOrigenAdmision == null) {
            if (other$idOrigenAdmision != null) {
                return false;
            }
        } else if (!this$idOrigenAdmision.equals(other$idOrigenAdmision)) {
            return false;
        }
        Object this$idCausaExterna = getIdCausaExterna();
        Object other$idCausaExterna = other.getIdCausaExterna();
        if (this$idCausaExterna == null) {
            if (other$idCausaExterna != null) {
                return false;
            }
        } else if (!this$idCausaExterna.equals(other$idCausaExterna)) {
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
        Object this$idProfesional = getIdProfesional();
        Object other$idProfesional = other.getIdProfesional();
        if (this$idProfesional == null) {
            if (other$idProfesional != null) {
                return false;
            }
        } else if (!this$idProfesional.equals(other$idProfesional)) {
            return false;
        }
        Object this$idTipoAtencion = getIdTipoAtencion();
        Object other$idTipoAtencion = other.getIdTipoAtencion();
        if (this$idTipoAtencion == null) {
            if (other$idTipoAtencion != null) {
                return false;
            }
        } else if (!this$idTipoAtencion.equals(other$idTipoAtencion)) {
            return false;
        }
        Object this$dxIngreso = getDxIngreso();
        Object other$dxIngreso = other.getDxIngreso();
        if (this$dxIngreso == null) {
            if (other$dxIngreso != null) {
                return false;
            }
        } else if (!this$dxIngreso.equals(other$dxIngreso)) {
            return false;
        }
        Object this$idContrato = getIdContrato();
        Object other$idContrato = other.getIdContrato();
        if (this$idContrato == null) {
            if (other$idContrato != null) {
                return false;
            }
        } else if (!this$idContrato.equals(other$idContrato)) {
            return false;
        }
        Object this$idNivelEstudio = getIdNivelEstudio();
        Object other$idNivelEstudio = other.getIdNivelEstudio();
        if (this$idNivelEstudio == null) {
            if (other$idNivelEstudio != null) {
                return false;
            }
        } else if (!this$idNivelEstudio.equals(other$idNivelEstudio)) {
            return false;
        }
        Object this$idParentesco = getIdParentesco();
        Object other$idParentesco = other.getIdParentesco();
        if (this$idParentesco == null) {
            if (other$idParentesco != null) {
                return false;
            }
        } else if (!this$idParentesco.equals(other$idParentesco)) {
            return false;
        }
        Object this$idOcupacion = getIdOcupacion();
        Object other$idOcupacion = other.getIdOcupacion();
        if (this$idOcupacion == null) {
            if (other$idOcupacion != null) {
                return false;
            }
        } else if (!this$idOcupacion.equals(other$idOcupacion)) {
            return false;
        }
        Object this$idAtencion = getIdAtencion();
        Object other$idAtencion = other.getIdAtencion();
        if (this$idAtencion == null) {
            if (other$idAtencion != null) {
                return false;
            }
        } else if (!this$idAtencion.equals(other$idAtencion)) {
            return false;
        }
        Object this$idCondVict = getIdCondVict();
        Object other$idCondVict = other.getIdCondVict();
        if (this$idCondVict == null) {
            if (other$idCondVict != null) {
                return false;
            }
        } else if (!this$idCondVict.equals(other$idCondVict)) {
            return false;
        }
        Object this$idRemoto = getIdRemoto();
        Object other$idRemoto = other.getIdRemoto();
        if (this$idRemoto == null) {
            if (other$idRemoto != null) {
                return false;
            }
        } else if (!this$idRemoto.equals(other$idRemoto)) {
            return false;
        }
        Object this$idTipoAfiliacion = getIdTipoAfiliacion();
        Object other$idTipoAfiliacion = other.getIdTipoAfiliacion();
        if (this$idTipoAfiliacion == null) {
            if (other$idTipoAfiliacion != null) {
                return false;
            }
        } else if (!this$idTipoAfiliacion.equals(other$idTipoAfiliacion)) {
            return false;
        }
        Object this$idTipoContratacion = getIdTipoContratacion();
        Object other$idTipoContratacion = other.getIdTipoContratacion();
        if (this$idTipoContratacion == null) {
            if (other$idTipoContratacion != null) {
                return false;
            }
        } else if (!this$idTipoContratacion.equals(other$idTipoContratacion)) {
            return false;
        }
        Object this$idTipoCoberturaPlan = getIdTipoCoberturaPlan();
        Object other$idTipoCoberturaPlan = other.getIdTipoCoberturaPlan();
        if (this$idTipoCoberturaPlan == null) {
            if (other$idTipoCoberturaPlan != null) {
                return false;
            }
        } else if (!this$idTipoCoberturaPlan.equals(other$idTipoCoberturaPlan)) {
            return false;
        }
        Object this$idSexo = getIdSexo();
        Object other$idSexo = other.getIdSexo();
        if (this$idSexo == null) {
            if (other$idSexo != null) {
                return false;
            }
        } else if (!this$idSexo.equals(other$idSexo)) {
            return false;
        }
        Object this$idTipoDoc = getIdTipoDoc();
        Object other$idTipoDoc = other.getIdTipoDoc();
        if (this$idTipoDoc == null) {
            if (other$idTipoDoc != null) {
                return false;
            }
        } else if (!this$idTipoDoc.equals(other$idTipoDoc)) {
            return false;
        }
        Object this$idIdentidadG = getIdIdentidadG();
        Object other$idIdentidadG = other.getIdIdentidadG();
        if (this$idIdentidadG == null) {
            if (other$idIdentidadG != null) {
                return false;
            }
        } else if (!this$idIdentidadG.equals(other$idIdentidadG)) {
            return false;
        }
        Object this$idTipoDiscapacidad = getIdTipoDiscapacidad();
        Object other$idTipoDiscapacidad = other.getIdTipoDiscapacidad();
        if (this$idTipoDiscapacidad == null) {
            if (other$idTipoDiscapacidad != null) {
                return false;
            }
        } else if (!this$idTipoDiscapacidad.equals(other$idTipoDiscapacidad)) {
            return false;
        }
        Object this$idModalidad = getIdModalidad();
        Object other$idModalidad = other.getIdModalidad();
        if (this$idModalidad == null) {
            if (other$idModalidad != null) {
                return false;
            }
        } else if (!this$idModalidad.equals(other$idModalidad)) {
            return false;
        }
        Object this$idEntornoAtencion = getIdEntornoAtencion();
        Object other$idEntornoAtencion = other.getIdEntornoAtencion();
        return this$idEntornoAtencion == null ? other$idEntornoAtencion == null : this$idEntornoAtencion.equals(other$idEntornoAtencion);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IngresoInterfazDto;
    }

    @Generated
    public int hashCode() {
        Object $idUsuario = getIdUsuario();
        int result = (1 * 59) + ($idUsuario == null ? 43 : $idUsuario.hashCode());
        Object $fechaIngreso = getFechaIngreso();
        int result2 = (result * 59) + ($fechaIngreso == null ? 43 : $fechaIngreso.hashCode());
        Object $horaIngreso = getHoraIngreso();
        int result3 = (result2 * 59) + ($horaIngreso == null ? 43 : $horaIngreso.hashCode());
        Object $idEmpresaContxConv = getIdEmpresaContxConv();
        int result4 = (result3 * 59) + ($idEmpresaContxConv == null ? 43 : $idEmpresaContxConv.hashCode());
        Object $esCapitado = getEsCapitado();
        int result5 = (result4 * 59) + ($esCapitado == null ? 43 : $esCapitado.hashCode());
        Object $idOrigenAdmision = getIdOrigenAdmision();
        int result6 = (result5 * 59) + ($idOrigenAdmision == null ? 43 : $idOrigenAdmision.hashCode());
        Object $idCausaExterna = getIdCausaExterna();
        int result7 = (result6 * 59) + ($idCausaExterna == null ? 43 : $idCausaExterna.hashCode());
        Object $idEspecialidad = getIdEspecialidad();
        int result8 = (result7 * 59) + ($idEspecialidad == null ? 43 : $idEspecialidad.hashCode());
        Object $idProfesional = getIdProfesional();
        int result9 = (result8 * 59) + ($idProfesional == null ? 43 : $idProfesional.hashCode());
        Object $idTipoAtencion = getIdTipoAtencion();
        int result10 = (result9 * 59) + ($idTipoAtencion == null ? 43 : $idTipoAtencion.hashCode());
        Object $dxIngreso = getDxIngreso();
        int result11 = (result10 * 59) + ($dxIngreso == null ? 43 : $dxIngreso.hashCode());
        Object $idContrato = getIdContrato();
        int result12 = (result11 * 59) + ($idContrato == null ? 43 : $idContrato.hashCode());
        Object $idNivelEstudio = getIdNivelEstudio();
        int result13 = (result12 * 59) + ($idNivelEstudio == null ? 43 : $idNivelEstudio.hashCode());
        Object $idParentesco = getIdParentesco();
        int result14 = (result13 * 59) + ($idParentesco == null ? 43 : $idParentesco.hashCode());
        Object $idOcupacion = getIdOcupacion();
        int result15 = (result14 * 59) + ($idOcupacion == null ? 43 : $idOcupacion.hashCode());
        Object $idAtencion = getIdAtencion();
        int result16 = (result15 * 59) + ($idAtencion == null ? 43 : $idAtencion.hashCode());
        Object $idCondVict = getIdCondVict();
        int result17 = (result16 * 59) + ($idCondVict == null ? 43 : $idCondVict.hashCode());
        Object $idRemoto = getIdRemoto();
        int result18 = (result17 * 59) + ($idRemoto == null ? 43 : $idRemoto.hashCode());
        Object $idTipoAfiliacion = getIdTipoAfiliacion();
        int result19 = (result18 * 59) + ($idTipoAfiliacion == null ? 43 : $idTipoAfiliacion.hashCode());
        Object $idTipoContratacion = getIdTipoContratacion();
        int result20 = (result19 * 59) + ($idTipoContratacion == null ? 43 : $idTipoContratacion.hashCode());
        Object $idTipoCoberturaPlan = getIdTipoCoberturaPlan();
        int result21 = (result20 * 59) + ($idTipoCoberturaPlan == null ? 43 : $idTipoCoberturaPlan.hashCode());
        Object $idSexo = getIdSexo();
        int result22 = (result21 * 59) + ($idSexo == null ? 43 : $idSexo.hashCode());
        Object $idTipoDoc = getIdTipoDoc();
        int result23 = (result22 * 59) + ($idTipoDoc == null ? 43 : $idTipoDoc.hashCode());
        Object $idIdentidadG = getIdIdentidadG();
        int result24 = (result23 * 59) + ($idIdentidadG == null ? 43 : $idIdentidadG.hashCode());
        Object $idTipoDiscapacidad = getIdTipoDiscapacidad();
        int result25 = (result24 * 59) + ($idTipoDiscapacidad == null ? 43 : $idTipoDiscapacidad.hashCode());
        Object $idModalidad = getIdModalidad();
        int result26 = (result25 * 59) + ($idModalidad == null ? 43 : $idModalidad.hashCode());
        Object $idEntornoAtencion = getIdEntornoAtencion();
        return (result26 * 59) + ($idEntornoAtencion == null ? 43 : $idEntornoAtencion.hashCode());
    }

    @Generated
    public String toString() {
        return "IngresoInterfazDto(idUsuario=" + getIdUsuario() + ", fechaIngreso=" + getFechaIngreso() + ", horaIngreso=" + getHoraIngreso() + ", idEmpresaContxConv=" + getIdEmpresaContxConv() + ", esCapitado=" + getEsCapitado() + ", idOrigenAdmision=" + getIdOrigenAdmision() + ", idCausaExterna=" + getIdCausaExterna() + ", idEspecialidad=" + getIdEspecialidad() + ", idProfesional=" + getIdProfesional() + ", idTipoAtencion=" + getIdTipoAtencion() + ", dxIngreso=" + getDxIngreso() + ", idContrato=" + getIdContrato() + ", idNivelEstudio=" + getIdNivelEstudio() + ", idParentesco=" + getIdParentesco() + ", idOcupacion=" + getIdOcupacion() + ", idAtencion=" + getIdAtencion() + ", idCondVict=" + getIdCondVict() + ", idRemoto=" + getIdRemoto() + ", idTipoAfiliacion=" + getIdTipoAfiliacion() + ", idTipoContratacion=" + getIdTipoContratacion() + ", idTipoCoberturaPlan=" + getIdTipoCoberturaPlan() + ", idSexo=" + getIdSexo() + ", idTipoDoc=" + getIdTipoDoc() + ", idIdentidadG=" + getIdIdentidadG() + ", idTipoDiscapacidad=" + getIdTipoDiscapacidad() + ", idModalidad=" + getIdModalidad() + ", idEntornoAtencion=" + getIdEntornoAtencion() + ")";
    }

    @Generated
    public IngresoInterfazDto(String idUsuario, String fechaIngreso, String horaIngreso, String idEmpresaContxConv, String esCapitado, String idOrigenAdmision, String idCausaExterna, String idEspecialidad, String idProfesional, String idTipoAtencion, String dxIngreso, String idContrato, String idNivelEstudio, String idParentesco, String idOcupacion, String idAtencion, String idCondVict, String idRemoto, String idTipoAfiliacion, String idTipoContratacion, String idTipoCoberturaPlan, String idSexo, String idTipoDoc, String idIdentidadG, String idTipoDiscapacidad, String idModalidad, String idEntornoAtencion) {
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.idEmpresaContxConv = idEmpresaContxConv;
        this.esCapitado = esCapitado;
        this.idOrigenAdmision = idOrigenAdmision;
        this.idCausaExterna = idCausaExterna;
        this.idEspecialidad = idEspecialidad;
        this.idProfesional = idProfesional;
        this.idTipoAtencion = idTipoAtencion;
        this.dxIngreso = dxIngreso;
        this.idContrato = idContrato;
        this.idNivelEstudio = idNivelEstudio;
        this.idParentesco = idParentesco;
        this.idOcupacion = idOcupacion;
        this.idAtencion = idAtencion;
        this.idCondVict = idCondVict;
        this.idRemoto = idRemoto;
        this.idTipoAfiliacion = idTipoAfiliacion;
        this.idTipoContratacion = idTipoContratacion;
        this.idTipoCoberturaPlan = idTipoCoberturaPlan;
        this.idSexo = idSexo;
        this.idTipoDoc = idTipoDoc;
        this.idIdentidadG = idIdentidadG;
        this.idTipoDiscapacidad = idTipoDiscapacidad;
        this.idModalidad = idModalidad;
        this.idEntornoAtencion = idEntornoAtencion;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/IngresoInterfazDto$IngresoInterfazDtoBuilder.class */
    @Generated
    public static class IngresoInterfazDtoBuilder {

        @Generated
        private String idUsuario;

        @Generated
        private String fechaIngreso;

        @Generated
        private String horaIngreso;

        @Generated
        private String idEmpresaContxConv;

        @Generated
        private String esCapitado;

        @Generated
        private String idOrigenAdmision;

        @Generated
        private String idCausaExterna;

        @Generated
        private String idEspecialidad;

        @Generated
        private String idProfesional;

        @Generated
        private String idTipoAtencion;

        @Generated
        private String dxIngreso;

        @Generated
        private String idContrato;

        @Generated
        private String idNivelEstudio;

        @Generated
        private String idParentesco;

        @Generated
        private String idOcupacion;

        @Generated
        private String idAtencion;

        @Generated
        private String idCondVict;

        @Generated
        private String idRemoto;

        @Generated
        private String idTipoAfiliacion;

        @Generated
        private String idTipoContratacion;

        @Generated
        private String idTipoCoberturaPlan;

        @Generated
        private String idSexo;

        @Generated
        private String idTipoDoc;

        @Generated
        private String idIdentidadG;

        @Generated
        private String idTipoDiscapacidad;

        @Generated
        private String idModalidad;

        @Generated
        private String idEntornoAtencion;

        @Generated
        IngresoInterfazDtoBuilder() {
        }

        @Generated
        public IngresoInterfazDtoBuilder idUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder fechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder horaIngreso(String horaIngreso) {
            this.horaIngreso = horaIngreso;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idEmpresaContxConv(String idEmpresaContxConv) {
            this.idEmpresaContxConv = idEmpresaContxConv;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder esCapitado(String esCapitado) {
            this.esCapitado = esCapitado;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idOrigenAdmision(String idOrigenAdmision) {
            this.idOrigenAdmision = idOrigenAdmision;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idCausaExterna(String idCausaExterna) {
            this.idCausaExterna = idCausaExterna;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idEspecialidad(String idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idProfesional(String idProfesional) {
            this.idProfesional = idProfesional;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoAtencion(String idTipoAtencion) {
            this.idTipoAtencion = idTipoAtencion;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder dxIngreso(String dxIngreso) {
            this.dxIngreso = dxIngreso;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idContrato(String idContrato) {
            this.idContrato = idContrato;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idNivelEstudio(String idNivelEstudio) {
            this.idNivelEstudio = idNivelEstudio;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idParentesco(String idParentesco) {
            this.idParentesco = idParentesco;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idOcupacion(String idOcupacion) {
            this.idOcupacion = idOcupacion;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idAtencion(String idAtencion) {
            this.idAtencion = idAtencion;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idCondVict(String idCondVict) {
            this.idCondVict = idCondVict;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idRemoto(String idRemoto) {
            this.idRemoto = idRemoto;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoAfiliacion(String idTipoAfiliacion) {
            this.idTipoAfiliacion = idTipoAfiliacion;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoContratacion(String idTipoContratacion) {
            this.idTipoContratacion = idTipoContratacion;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoCoberturaPlan(String idTipoCoberturaPlan) {
            this.idTipoCoberturaPlan = idTipoCoberturaPlan;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idSexo(String idSexo) {
            this.idSexo = idSexo;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoDoc(String idTipoDoc) {
            this.idTipoDoc = idTipoDoc;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idIdentidadG(String idIdentidadG) {
            this.idIdentidadG = idIdentidadG;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idTipoDiscapacidad(String idTipoDiscapacidad) {
            this.idTipoDiscapacidad = idTipoDiscapacidad;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idModalidad(String idModalidad) {
            this.idModalidad = idModalidad;
            return this;
        }

        @Generated
        public IngresoInterfazDtoBuilder idEntornoAtencion(String idEntornoAtencion) {
            this.idEntornoAtencion = idEntornoAtencion;
            return this;
        }

        @Generated
        public IngresoInterfazDto build() {
            return new IngresoInterfazDto(this.idUsuario, this.fechaIngreso, this.horaIngreso, this.idEmpresaContxConv, this.esCapitado, this.idOrigenAdmision, this.idCausaExterna, this.idEspecialidad, this.idProfesional, this.idTipoAtencion, this.dxIngreso, this.idContrato, this.idNivelEstudio, this.idParentesco, this.idOcupacion, this.idAtencion, this.idCondVict, this.idRemoto, this.idTipoAfiliacion, this.idTipoContratacion, this.idTipoCoberturaPlan, this.idSexo, this.idTipoDoc, this.idIdentidadG, this.idTipoDiscapacidad, this.idModalidad, this.idEntornoAtencion);
        }

        @Generated
        public String toString() {
            return "IngresoInterfazDto.IngresoInterfazDtoBuilder(idUsuario=" + this.idUsuario + ", fechaIngreso=" + this.fechaIngreso + ", horaIngreso=" + this.horaIngreso + ", idEmpresaContxConv=" + this.idEmpresaContxConv + ", esCapitado=" + this.esCapitado + ", idOrigenAdmision=" + this.idOrigenAdmision + ", idCausaExterna=" + this.idCausaExterna + ", idEspecialidad=" + this.idEspecialidad + ", idProfesional=" + this.idProfesional + ", idTipoAtencion=" + this.idTipoAtencion + ", dxIngreso=" + this.dxIngreso + ", idContrato=" + this.idContrato + ", idNivelEstudio=" + this.idNivelEstudio + ", idParentesco=" + this.idParentesco + ", idOcupacion=" + this.idOcupacion + ", idAtencion=" + this.idAtencion + ", idCondVict=" + this.idCondVict + ", idRemoto=" + this.idRemoto + ", idTipoAfiliacion=" + this.idTipoAfiliacion + ", idTipoContratacion=" + this.idTipoContratacion + ", idTipoCoberturaPlan=" + this.idTipoCoberturaPlan + ", idSexo=" + this.idSexo + ", idTipoDoc=" + this.idTipoDoc + ", idIdentidadG=" + this.idIdentidadG + ", idTipoDiscapacidad=" + this.idTipoDiscapacidad + ", idModalidad=" + this.idModalidad + ", idEntornoAtencion=" + this.idEntornoAtencion + ")";
        }
    }

    @Generated
    public IngresoInterfazDto() {
    }

    @Generated
    public static IngresoInterfazDtoBuilder builder() {
        return new IngresoInterfazDtoBuilder();
    }

    @Generated
    public String getIdUsuario() {
        return this.idUsuario;
    }

    @Generated
    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Generated
    public String getHoraIngreso() {
        return this.horaIngreso;
    }

    @Generated
    public String getIdEmpresaContxConv() {
        return this.idEmpresaContxConv;
    }

    @Generated
    public String getEsCapitado() {
        return this.esCapitado;
    }

    @Generated
    public String getIdOrigenAdmision() {
        return this.idOrigenAdmision;
    }

    @Generated
    public String getIdCausaExterna() {
        return this.idCausaExterna;
    }

    @Generated
    public String getIdEspecialidad() {
        return this.idEspecialidad;
    }

    @Generated
    public String getIdProfesional() {
        return this.idProfesional;
    }

    @Generated
    public String getIdTipoAtencion() {
        return this.idTipoAtencion;
    }

    @Generated
    public String getDxIngreso() {
        return this.dxIngreso;
    }

    @Generated
    public String getIdContrato() {
        return this.idContrato;
    }

    @Generated
    public String getIdNivelEstudio() {
        return this.idNivelEstudio;
    }

    @Generated
    public String getIdParentesco() {
        return this.idParentesco;
    }

    @Generated
    public String getIdOcupacion() {
        return this.idOcupacion;
    }

    @Generated
    public String getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public String getIdCondVict() {
        return this.idCondVict;
    }

    @Generated
    public String getIdRemoto() {
        return this.idRemoto;
    }

    @Generated
    public String getIdTipoAfiliacion() {
        return this.idTipoAfiliacion;
    }

    @Generated
    public String getIdTipoContratacion() {
        return this.idTipoContratacion;
    }

    @Generated
    public String getIdTipoCoberturaPlan() {
        return this.idTipoCoberturaPlan;
    }

    @Generated
    public String getIdSexo() {
        return this.idSexo;
    }

    @Generated
    public String getIdTipoDoc() {
        return this.idTipoDoc;
    }

    @Generated
    public String getIdIdentidadG() {
        return this.idIdentidadG;
    }

    @Generated
    public String getIdTipoDiscapacidad() {
        return this.idTipoDiscapacidad;
    }

    @Generated
    public String getIdModalidad() {
        return this.idModalidad;
    }

    @Generated
    public String getIdEntornoAtencion() {
        return this.idEntornoAtencion;
    }
}
