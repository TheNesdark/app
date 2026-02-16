package com.genoma.plus.controller.enfermeria.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/dto/ListPacienteSinExamenFisicoDto.class */
public class ListPacienteSinExamenFisicoDto {
    private String idPersona;
    private String idIngreso;
    private String idAtencion;
    private String fechaIngreso;
    private String convenio;
    private String claseCita;
    private String profesional;
    private String especialidad;
    private String exemenFisico;
    private String paciente;
    private String idProfesional;
    private String idEspecialidad;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/dto/ListPacienteSinExamenFisicoDto$ListPacienteSinExamenFisicoDtoBuilder.class */
    @Generated
    public static class ListPacienteSinExamenFisicoDtoBuilder {

        @Generated
        private String idPersona;

        @Generated
        private String idIngreso;

        @Generated
        private String idAtencion;

        @Generated
        private String fechaIngreso;

        @Generated
        private String convenio;

        @Generated
        private String claseCita;

        @Generated
        private String profesional;

        @Generated
        private String especialidad;

        @Generated
        private String exemenFisico;

        @Generated
        private String paciente;

        @Generated
        private String idProfesional;

        @Generated
        private String idEspecialidad;

        @Generated
        ListPacienteSinExamenFisicoDtoBuilder() {
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder idPersona(String idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder idIngreso(String idIngreso) {
            this.idIngreso = idIngreso;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder idAtencion(String idAtencion) {
            this.idAtencion = idAtencion;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder fechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder convenio(String convenio) {
            this.convenio = convenio;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder claseCita(String claseCita) {
            this.claseCita = claseCita;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder profesional(String profesional) {
            this.profesional = profesional;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder especialidad(String especialidad) {
            this.especialidad = especialidad;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder exemenFisico(String exemenFisico) {
            this.exemenFisico = exemenFisico;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder paciente(String paciente) {
            this.paciente = paciente;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder idProfesional(String idProfesional) {
            this.idProfesional = idProfesional;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDtoBuilder idEspecialidad(String idEspecialidad) {
            this.idEspecialidad = idEspecialidad;
            return this;
        }

        @Generated
        public ListPacienteSinExamenFisicoDto build() {
            return new ListPacienteSinExamenFisicoDto(this.idPersona, this.idIngreso, this.idAtencion, this.fechaIngreso, this.convenio, this.claseCita, this.profesional, this.especialidad, this.exemenFisico, this.paciente, this.idProfesional, this.idEspecialidad);
        }

        @Generated
        public String toString() {
            return "ListPacienteSinExamenFisicoDto.ListPacienteSinExamenFisicoDtoBuilder(idPersona=" + this.idPersona + ", idIngreso=" + this.idIngreso + ", idAtencion=" + this.idAtencion + ", fechaIngreso=" + this.fechaIngreso + ", convenio=" + this.convenio + ", claseCita=" + this.claseCita + ", profesional=" + this.profesional + ", especialidad=" + this.especialidad + ", exemenFisico=" + this.exemenFisico + ", paciente=" + this.paciente + ", idProfesional=" + this.idProfesional + ", idEspecialidad=" + this.idEspecialidad + ")";
        }
    }

    @Generated
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    @Generated
    public void setIdIngreso(String idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Generated
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Generated
    public void setClaseCita(String claseCita) {
        this.claseCita = claseCita;
    }

    @Generated
    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    @Generated
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Generated
    public void setExemenFisico(String exemenFisico) {
        this.exemenFisico = exemenFisico;
    }

    @Generated
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Generated
    public void setIdProfesional(String idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Generated
    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListPacienteSinExamenFisicoDto)) {
            return false;
        }
        ListPacienteSinExamenFisicoDto other = (ListPacienteSinExamenFisicoDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idPersona = getIdPersona();
        Object other$idPersona = other.getIdPersona();
        if (this$idPersona == null) {
            if (other$idPersona != null) {
                return false;
            }
        } else if (!this$idPersona.equals(other$idPersona)) {
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
        Object this$idAtencion = getIdAtencion();
        Object other$idAtencion = other.getIdAtencion();
        if (this$idAtencion == null) {
            if (other$idAtencion != null) {
                return false;
            }
        } else if (!this$idAtencion.equals(other$idAtencion)) {
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
        Object this$convenio = getConvenio();
        Object other$convenio = other.getConvenio();
        if (this$convenio == null) {
            if (other$convenio != null) {
                return false;
            }
        } else if (!this$convenio.equals(other$convenio)) {
            return false;
        }
        Object this$claseCita = getClaseCita();
        Object other$claseCita = other.getClaseCita();
        if (this$claseCita == null) {
            if (other$claseCita != null) {
                return false;
            }
        } else if (!this$claseCita.equals(other$claseCita)) {
            return false;
        }
        Object this$profesional = getProfesional();
        Object other$profesional = other.getProfesional();
        if (this$profesional == null) {
            if (other$profesional != null) {
                return false;
            }
        } else if (!this$profesional.equals(other$profesional)) {
            return false;
        }
        Object this$especialidad = getEspecialidad();
        Object other$especialidad = other.getEspecialidad();
        if (this$especialidad == null) {
            if (other$especialidad != null) {
                return false;
            }
        } else if (!this$especialidad.equals(other$especialidad)) {
            return false;
        }
        Object this$exemenFisico = getExemenFisico();
        Object other$exemenFisico = other.getExemenFisico();
        if (this$exemenFisico == null) {
            if (other$exemenFisico != null) {
                return false;
            }
        } else if (!this$exemenFisico.equals(other$exemenFisico)) {
            return false;
        }
        Object this$paciente = getPaciente();
        Object other$paciente = other.getPaciente();
        if (this$paciente == null) {
            if (other$paciente != null) {
                return false;
            }
        } else if (!this$paciente.equals(other$paciente)) {
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
        return this$idEspecialidad == null ? other$idEspecialidad == null : this$idEspecialidad.equals(other$idEspecialidad);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListPacienteSinExamenFisicoDto;
    }

    @Generated
    public int hashCode() {
        Object $idPersona = getIdPersona();
        int result = (1 * 59) + ($idPersona == null ? 43 : $idPersona.hashCode());
        Object $idIngreso = getIdIngreso();
        int result2 = (result * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $idAtencion = getIdAtencion();
        int result3 = (result2 * 59) + ($idAtencion == null ? 43 : $idAtencion.hashCode());
        Object $fechaIngreso = getFechaIngreso();
        int result4 = (result3 * 59) + ($fechaIngreso == null ? 43 : $fechaIngreso.hashCode());
        Object $convenio = getConvenio();
        int result5 = (result4 * 59) + ($convenio == null ? 43 : $convenio.hashCode());
        Object $claseCita = getClaseCita();
        int result6 = (result5 * 59) + ($claseCita == null ? 43 : $claseCita.hashCode());
        Object $profesional = getProfesional();
        int result7 = (result6 * 59) + ($profesional == null ? 43 : $profesional.hashCode());
        Object $especialidad = getEspecialidad();
        int result8 = (result7 * 59) + ($especialidad == null ? 43 : $especialidad.hashCode());
        Object $exemenFisico = getExemenFisico();
        int result9 = (result8 * 59) + ($exemenFisico == null ? 43 : $exemenFisico.hashCode());
        Object $paciente = getPaciente();
        int result10 = (result9 * 59) + ($paciente == null ? 43 : $paciente.hashCode());
        Object $idProfesional = getIdProfesional();
        int result11 = (result10 * 59) + ($idProfesional == null ? 43 : $idProfesional.hashCode());
        Object $idEspecialidad = getIdEspecialidad();
        return (result11 * 59) + ($idEspecialidad == null ? 43 : $idEspecialidad.hashCode());
    }

    @Generated
    public String toString() {
        return "ListPacienteSinExamenFisicoDto(idPersona=" + getIdPersona() + ", idIngreso=" + getIdIngreso() + ", idAtencion=" + getIdAtencion() + ", fechaIngreso=" + getFechaIngreso() + ", convenio=" + getConvenio() + ", claseCita=" + getClaseCita() + ", profesional=" + getProfesional() + ", especialidad=" + getEspecialidad() + ", exemenFisico=" + getExemenFisico() + ", paciente=" + getPaciente() + ", idProfesional=" + getIdProfesional() + ", idEspecialidad=" + getIdEspecialidad() + ")";
    }

    @Generated
    public static ListPacienteSinExamenFisicoDtoBuilder builder() {
        return new ListPacienteSinExamenFisicoDtoBuilder();
    }

    @Generated
    public ListPacienteSinExamenFisicoDto(String idPersona, String idIngreso, String idAtencion, String fechaIngreso, String convenio, String claseCita, String profesional, String especialidad, String exemenFisico, String paciente, String idProfesional, String idEspecialidad) {
        this.idPersona = idPersona;
        this.idIngreso = idIngreso;
        this.idAtencion = idAtencion;
        this.fechaIngreso = fechaIngreso;
        this.convenio = convenio;
        this.claseCita = claseCita;
        this.profesional = profesional;
        this.especialidad = especialidad;
        this.exemenFisico = exemenFisico;
        this.paciente = paciente;
        this.idProfesional = idProfesional;
        this.idEspecialidad = idEspecialidad;
    }

    @Generated
    public ListPacienteSinExamenFisicoDto() {
    }

    @Generated
    public String getIdPersona() {
        return this.idPersona;
    }

    @Generated
    public String getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public String getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Generated
    public String getConvenio() {
        return this.convenio;
    }

    @Generated
    public String getClaseCita() {
        return this.claseCita;
    }

    @Generated
    public String getProfesional() {
        return this.profesional;
    }

    @Generated
    public String getEspecialidad() {
        return this.especialidad;
    }

    @Generated
    public String getExemenFisico() {
        return this.exemenFisico;
    }

    @Generated
    public String getPaciente() {
        return this.paciente;
    }

    @Generated
    public String getIdProfesional() {
        return this.idProfesional;
    }

    @Generated
    public String getIdEspecialidad() {
        return this.idEspecialidad;
    }
}
