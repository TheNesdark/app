package com.genoma.plus.controller.laboratorio.dto;

import java.time.LocalDate;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/InfoCitologiaDTO.class */
public class InfoCitologiaDTO {
    private String consecutivo;
    private LocalDate fechaIngreso;
    private String numeroDocumento;
    private String nombreUsuario;
    private LocalDate fechaNacimiento;
    private String edad;
    private String sexo;
    private String empresaConvenio;
    private String nombreProcedimiento;
    private boolean estadoResultado;
    private Long idRecepcion;
    private Long idIngreso;
    private Integer idSede;
    private Boolean controlCalidad;
    private Long idProfesionalValida;

    @Generated
    public InfoCitologiaDTO() {
    }

    @Generated
    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Generated
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Generated
    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Generated
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Generated
    public void setEmpresaConvenio(String empresaConvenio) {
        this.empresaConvenio = empresaConvenio;
    }

    @Generated
    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    @Generated
    public void setEstadoResultado(boolean estadoResultado) {
        this.estadoResultado = estadoResultado;
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
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    @Generated
    public void setControlCalidad(Boolean controlCalidad) {
        this.controlCalidad = controlCalidad;
    }

    @Generated
    public void setIdProfesionalValida(Long idProfesionalValida) {
        this.idProfesionalValida = idProfesionalValida;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InfoCitologiaDTO)) {
            return false;
        }
        InfoCitologiaDTO other = (InfoCitologiaDTO) o;
        if (!other.canEqual(this) || isEstadoResultado() != other.isEstadoResultado()) {
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
        Object this$idSede = getIdSede();
        Object other$idSede = other.getIdSede();
        if (this$idSede == null) {
            if (other$idSede != null) {
                return false;
            }
        } else if (!this$idSede.equals(other$idSede)) {
            return false;
        }
        Object this$controlCalidad = getControlCalidad();
        Object other$controlCalidad = other.getControlCalidad();
        if (this$controlCalidad == null) {
            if (other$controlCalidad != null) {
                return false;
            }
        } else if (!this$controlCalidad.equals(other$controlCalidad)) {
            return false;
        }
        Object this$idProfesionalValida = getIdProfesionalValida();
        Object other$idProfesionalValida = other.getIdProfesionalValida();
        if (this$idProfesionalValida == null) {
            if (other$idProfesionalValida != null) {
                return false;
            }
        } else if (!this$idProfesionalValida.equals(other$idProfesionalValida)) {
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
        Object this$fechaIngreso = getFechaIngreso();
        Object other$fechaIngreso = other.getFechaIngreso();
        if (this$fechaIngreso == null) {
            if (other$fechaIngreso != null) {
                return false;
            }
        } else if (!this$fechaIngreso.equals(other$fechaIngreso)) {
            return false;
        }
        Object this$numeroDocumento = getNumeroDocumento();
        Object other$numeroDocumento = other.getNumeroDocumento();
        if (this$numeroDocumento == null) {
            if (other$numeroDocumento != null) {
                return false;
            }
        } else if (!this$numeroDocumento.equals(other$numeroDocumento)) {
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
        Object this$fechaNacimiento = getFechaNacimiento();
        Object other$fechaNacimiento = other.getFechaNacimiento();
        if (this$fechaNacimiento == null) {
            if (other$fechaNacimiento != null) {
                return false;
            }
        } else if (!this$fechaNacimiento.equals(other$fechaNacimiento)) {
            return false;
        }
        Object this$edad = getEdad();
        Object other$edad = other.getEdad();
        if (this$edad == null) {
            if (other$edad != null) {
                return false;
            }
        } else if (!this$edad.equals(other$edad)) {
            return false;
        }
        Object this$sexo = getSexo();
        Object other$sexo = other.getSexo();
        if (this$sexo == null) {
            if (other$sexo != null) {
                return false;
            }
        } else if (!this$sexo.equals(other$sexo)) {
            return false;
        }
        Object this$empresaConvenio = getEmpresaConvenio();
        Object other$empresaConvenio = other.getEmpresaConvenio();
        if (this$empresaConvenio == null) {
            if (other$empresaConvenio != null) {
                return false;
            }
        } else if (!this$empresaConvenio.equals(other$empresaConvenio)) {
            return false;
        }
        Object this$nombreProcedimiento = getNombreProcedimiento();
        Object other$nombreProcedimiento = other.getNombreProcedimiento();
        return this$nombreProcedimiento == null ? other$nombreProcedimiento == null : this$nombreProcedimiento.equals(other$nombreProcedimiento);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InfoCitologiaDTO;
    }

    @Generated
    public int hashCode() {
        int result = (1 * 59) + (isEstadoResultado() ? 79 : 97);
        Object $idRecepcion = getIdRecepcion();
        int result2 = (result * 59) + ($idRecepcion == null ? 43 : $idRecepcion.hashCode());
        Object $idIngreso = getIdIngreso();
        int result3 = (result2 * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $idSede = getIdSede();
        int result4 = (result3 * 59) + ($idSede == null ? 43 : $idSede.hashCode());
        Object $controlCalidad = getControlCalidad();
        int result5 = (result4 * 59) + ($controlCalidad == null ? 43 : $controlCalidad.hashCode());
        Object $idProfesionalValida = getIdProfesionalValida();
        int result6 = (result5 * 59) + ($idProfesionalValida == null ? 43 : $idProfesionalValida.hashCode());
        Object $consecutivo = getConsecutivo();
        int result7 = (result6 * 59) + ($consecutivo == null ? 43 : $consecutivo.hashCode());
        Object $fechaIngreso = getFechaIngreso();
        int result8 = (result7 * 59) + ($fechaIngreso == null ? 43 : $fechaIngreso.hashCode());
        Object $numeroDocumento = getNumeroDocumento();
        int result9 = (result8 * 59) + ($numeroDocumento == null ? 43 : $numeroDocumento.hashCode());
        Object $nombreUsuario = getNombreUsuario();
        int result10 = (result9 * 59) + ($nombreUsuario == null ? 43 : $nombreUsuario.hashCode());
        Object $fechaNacimiento = getFechaNacimiento();
        int result11 = (result10 * 59) + ($fechaNacimiento == null ? 43 : $fechaNacimiento.hashCode());
        Object $edad = getEdad();
        int result12 = (result11 * 59) + ($edad == null ? 43 : $edad.hashCode());
        Object $sexo = getSexo();
        int result13 = (result12 * 59) + ($sexo == null ? 43 : $sexo.hashCode());
        Object $empresaConvenio = getEmpresaConvenio();
        int result14 = (result13 * 59) + ($empresaConvenio == null ? 43 : $empresaConvenio.hashCode());
        Object $nombreProcedimiento = getNombreProcedimiento();
        return (result14 * 59) + ($nombreProcedimiento == null ? 43 : $nombreProcedimiento.hashCode());
    }

    @Generated
    public String toString() {
        return "InfoCitologiaDTO(consecutivo=" + getConsecutivo() + ", fechaIngreso=" + getFechaIngreso() + ", numeroDocumento=" + getNumeroDocumento() + ", nombreUsuario=" + getNombreUsuario() + ", fechaNacimiento=" + getFechaNacimiento() + ", edad=" + getEdad() + ", sexo=" + getSexo() + ", empresaConvenio=" + getEmpresaConvenio() + ", nombreProcedimiento=" + getNombreProcedimiento() + ", estadoResultado=" + isEstadoResultado() + ", idRecepcion=" + getIdRecepcion() + ", idIngreso=" + getIdIngreso() + ", idSede=" + getIdSede() + ", controlCalidad=" + getControlCalidad() + ", idProfesionalValida=" + getIdProfesionalValida() + ")";
    }

    @Generated
    public String getConsecutivo() {
        return this.consecutivo;
    }

    @Generated
    public LocalDate getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Generated
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    @Generated
    public String getEdad() {
        return this.edad;
    }

    @Generated
    public String getSexo() {
        return this.sexo;
    }

    @Generated
    public String getEmpresaConvenio() {
        return this.empresaConvenio;
    }

    @Generated
    public String getNombreProcedimiento() {
        return this.nombreProcedimiento;
    }

    @Generated
    public boolean isEstadoResultado() {
        return this.estadoResultado;
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
    public Integer getIdSede() {
        return this.idSede;
    }

    @Generated
    public Boolean getControlCalidad() {
        return this.controlCalidad;
    }

    @Generated
    public Long getIdProfesionalValida() {
        return this.idProfesionalValida;
    }
}
