package com.genoma.plus.controller.laboratorio.dto;

import com.genoma.plus.controller.general.dto.GenericDomain;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/CitologiaDTO.class */
public class CitologiaDTO {
    private String consecutivo;
    private String nombreSede;
    private String nombreUsuario;
    private String numeroDocumento;
    private String edad;
    private String fechaNacimiento;
    private String municipioResidencia;
    private String direccion;
    private String telefono;
    private String idTipoRegimen;
    private String empresaConvenio;
    private String nombreIps;
    private String fechaToma;
    private String fechaRecepcion;
    private String fechaResultado;
    private String fechaValidacion;
    private Integer numeroEmbarazo;
    private Integer numeroPartos;
    private Integer numeroCesarea;
    private Integer numeroAbortos;
    private String fechaUltimaMestruacion;
    private String tipoMetodoPlanificacion;
    private String nombreTipoMetodoPlanificacion;
    private Boolean primeraVez;
    private String histerectomia;
    private String cauterizacion;
    private String conizacion;
    private String radioterapia;
    private String tratamientoHormonal;
    private String aspecCuello;
    private String descripcionAspecto;
    private String observacion;
    private String sintomas;
    private String resultadoUltimaCitologia;
    private String fechaUltimaCitologia;
    private String calidadMuestra;
    private String observacionCalidad;
    private Long idResultado;
    private Long idCitologia;
    private String profesional;
    private String especialidad;
    private String firmaProfesional;
    private String profesionalEspecialista;
    private String especialidadEspecialista;
    private String firmaProfesionalEspecialista;
    private String registro;
    private String observacionResultado;
    private String profesionalValida;
    private String especialidadValida;
    private String registroValida;
    private String firmaValida;
    private List<GenericDomain> clasificacionGeneral;
    private List<GenericDomain> microorganismo;
    private List<GenericDomain> hallazgosNeoplaticos;
    private List<GenericDomain> celulasEscamosas;
    private List<GenericDomain> celulasGlandulares;
    private String clasificacionGeneralText;
    private String microorganismoText;
    private String hallazgosNeoplaticosText;
    private String celulasEscamosasText;
    private String celulasGlandularesText;
    private String NCConducta;
    private String noPlacaCitologia;
    private String nombreQuienTomaCitologia;
    private String cargoQuienTomaCitologia;
    private String rutaReportes;

    @Generated
    public CitologiaDTO() {
    }

    @Generated
    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Generated
    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Generated
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Generated
    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    @Generated
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Generated
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Generated
    public void setIdTipoRegimen(String idTipoRegimen) {
        this.idTipoRegimen = idTipoRegimen;
    }

    @Generated
    public void setEmpresaConvenio(String empresaConvenio) {
        this.empresaConvenio = empresaConvenio;
    }

    @Generated
    public void setNombreIps(String nombreIps) {
        this.nombreIps = nombreIps;
    }

    @Generated
    public void setFechaToma(String fechaToma) {
        this.fechaToma = fechaToma;
    }

    @Generated
    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Generated
    public void setFechaResultado(String fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    @Generated
    public void setFechaValidacion(String fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }

    @Generated
    public void setNumeroEmbarazo(Integer numeroEmbarazo) {
        this.numeroEmbarazo = numeroEmbarazo;
    }

    @Generated
    public void setNumeroPartos(Integer numeroPartos) {
        this.numeroPartos = numeroPartos;
    }

    @Generated
    public void setNumeroCesarea(Integer numeroCesarea) {
        this.numeroCesarea = numeroCesarea;
    }

    @Generated
    public void setNumeroAbortos(Integer numeroAbortos) {
        this.numeroAbortos = numeroAbortos;
    }

    @Generated
    public void setFechaUltimaMestruacion(String fechaUltimaMestruacion) {
        this.fechaUltimaMestruacion = fechaUltimaMestruacion;
    }

    @Generated
    public void setTipoMetodoPlanificacion(String tipoMetodoPlanificacion) {
        this.tipoMetodoPlanificacion = tipoMetodoPlanificacion;
    }

    @Generated
    public void setNombreTipoMetodoPlanificacion(String nombreTipoMetodoPlanificacion) {
        this.nombreTipoMetodoPlanificacion = nombreTipoMetodoPlanificacion;
    }

    @Generated
    public void setPrimeraVez(Boolean primeraVez) {
        this.primeraVez = primeraVez;
    }

    @Generated
    public void setHisterectomia(String histerectomia) {
        this.histerectomia = histerectomia;
    }

    @Generated
    public void setCauterizacion(String cauterizacion) {
        this.cauterizacion = cauterizacion;
    }

    @Generated
    public void setConizacion(String conizacion) {
        this.conizacion = conizacion;
    }

    @Generated
    public void setRadioterapia(String radioterapia) {
        this.radioterapia = radioterapia;
    }

    @Generated
    public void setTratamientoHormonal(String tratamientoHormonal) {
        this.tratamientoHormonal = tratamientoHormonal;
    }

    @Generated
    public void setAspecCuello(String aspecCuello) {
        this.aspecCuello = aspecCuello;
    }

    @Generated
    public void setDescripcionAspecto(String descripcionAspecto) {
        this.descripcionAspecto = descripcionAspecto;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Generated
    public void setResultadoUltimaCitologia(String resultadoUltimaCitologia) {
        this.resultadoUltimaCitologia = resultadoUltimaCitologia;
    }

    @Generated
    public void setFechaUltimaCitologia(String fechaUltimaCitologia) {
        this.fechaUltimaCitologia = fechaUltimaCitologia;
    }

    @Generated
    public void setCalidadMuestra(String calidadMuestra) {
        this.calidadMuestra = calidadMuestra;
    }

    @Generated
    public void setObservacionCalidad(String observacionCalidad) {
        this.observacionCalidad = observacionCalidad;
    }

    @Generated
    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    @Generated
    public void setIdCitologia(Long idCitologia) {
        this.idCitologia = idCitologia;
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
    public void setFirmaProfesional(String firmaProfesional) {
        this.firmaProfesional = firmaProfesional;
    }

    @Generated
    public void setProfesionalEspecialista(String profesionalEspecialista) {
        this.profesionalEspecialista = profesionalEspecialista;
    }

    @Generated
    public void setEspecialidadEspecialista(String especialidadEspecialista) {
        this.especialidadEspecialista = especialidadEspecialista;
    }

    @Generated
    public void setFirmaProfesionalEspecialista(String firmaProfesionalEspecialista) {
        this.firmaProfesionalEspecialista = firmaProfesionalEspecialista;
    }

    @Generated
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Generated
    public void setObservacionResultado(String observacionResultado) {
        this.observacionResultado = observacionResultado;
    }

    @Generated
    public void setProfesionalValida(String profesionalValida) {
        this.profesionalValida = profesionalValida;
    }

    @Generated
    public void setEspecialidadValida(String especialidadValida) {
        this.especialidadValida = especialidadValida;
    }

    @Generated
    public void setRegistroValida(String registroValida) {
        this.registroValida = registroValida;
    }

    @Generated
    public void setFirmaValida(String firmaValida) {
        this.firmaValida = firmaValida;
    }

    @Generated
    public void setClasificacionGeneral(List<GenericDomain> clasificacionGeneral) {
        this.clasificacionGeneral = clasificacionGeneral;
    }

    @Generated
    public void setMicroorganismo(List<GenericDomain> microorganismo) {
        this.microorganismo = microorganismo;
    }

    @Generated
    public void setHallazgosNeoplaticos(List<GenericDomain> hallazgosNeoplaticos) {
        this.hallazgosNeoplaticos = hallazgosNeoplaticos;
    }

    @Generated
    public void setCelulasEscamosas(List<GenericDomain> celulasEscamosas) {
        this.celulasEscamosas = celulasEscamosas;
    }

    @Generated
    public void setCelulasGlandulares(List<GenericDomain> celulasGlandulares) {
        this.celulasGlandulares = celulasGlandulares;
    }

    @Generated
    public void setClasificacionGeneralText(String clasificacionGeneralText) {
        this.clasificacionGeneralText = clasificacionGeneralText;
    }

    @Generated
    public void setMicroorganismoText(String microorganismoText) {
        this.microorganismoText = microorganismoText;
    }

    @Generated
    public void setHallazgosNeoplaticosText(String hallazgosNeoplaticosText) {
        this.hallazgosNeoplaticosText = hallazgosNeoplaticosText;
    }

    @Generated
    public void setCelulasEscamosasText(String celulasEscamosasText) {
        this.celulasEscamosasText = celulasEscamosasText;
    }

    @Generated
    public void setCelulasGlandularesText(String celulasGlandularesText) {
        this.celulasGlandularesText = celulasGlandularesText;
    }

    @Generated
    public void setNCConducta(String NCConducta) {
        this.NCConducta = NCConducta;
    }

    @Generated
    public void setNoPlacaCitologia(String noPlacaCitologia) {
        this.noPlacaCitologia = noPlacaCitologia;
    }

    @Generated
    public void setNombreQuienTomaCitologia(String nombreQuienTomaCitologia) {
        this.nombreQuienTomaCitologia = nombreQuienTomaCitologia;
    }

    @Generated
    public void setCargoQuienTomaCitologia(String cargoQuienTomaCitologia) {
        this.cargoQuienTomaCitologia = cargoQuienTomaCitologia;
    }

    @Generated
    public void setRutaReportes(String rutaReportes) {
        this.rutaReportes = rutaReportes;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CitologiaDTO)) {
            return false;
        }
        CitologiaDTO other = (CitologiaDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$numeroEmbarazo = getNumeroEmbarazo();
        Object other$numeroEmbarazo = other.getNumeroEmbarazo();
        if (this$numeroEmbarazo == null) {
            if (other$numeroEmbarazo != null) {
                return false;
            }
        } else if (!this$numeroEmbarazo.equals(other$numeroEmbarazo)) {
            return false;
        }
        Object this$numeroPartos = getNumeroPartos();
        Object other$numeroPartos = other.getNumeroPartos();
        if (this$numeroPartos == null) {
            if (other$numeroPartos != null) {
                return false;
            }
        } else if (!this$numeroPartos.equals(other$numeroPartos)) {
            return false;
        }
        Object this$numeroCesarea = getNumeroCesarea();
        Object other$numeroCesarea = other.getNumeroCesarea();
        if (this$numeroCesarea == null) {
            if (other$numeroCesarea != null) {
                return false;
            }
        } else if (!this$numeroCesarea.equals(other$numeroCesarea)) {
            return false;
        }
        Object this$numeroAbortos = getNumeroAbortos();
        Object other$numeroAbortos = other.getNumeroAbortos();
        if (this$numeroAbortos == null) {
            if (other$numeroAbortos != null) {
                return false;
            }
        } else if (!this$numeroAbortos.equals(other$numeroAbortos)) {
            return false;
        }
        Object this$primeraVez = getPrimeraVez();
        Object other$primeraVez = other.getPrimeraVez();
        if (this$primeraVez == null) {
            if (other$primeraVez != null) {
                return false;
            }
        } else if (!this$primeraVez.equals(other$primeraVez)) {
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
        Object this$idCitologia = getIdCitologia();
        Object other$idCitologia = other.getIdCitologia();
        if (this$idCitologia == null) {
            if (other$idCitologia != null) {
                return false;
            }
        } else if (!this$idCitologia.equals(other$idCitologia)) {
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
        Object this$nombreSede = getNombreSede();
        Object other$nombreSede = other.getNombreSede();
        if (this$nombreSede == null) {
            if (other$nombreSede != null) {
                return false;
            }
        } else if (!this$nombreSede.equals(other$nombreSede)) {
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
        Object this$numeroDocumento = getNumeroDocumento();
        Object other$numeroDocumento = other.getNumeroDocumento();
        if (this$numeroDocumento == null) {
            if (other$numeroDocumento != null) {
                return false;
            }
        } else if (!this$numeroDocumento.equals(other$numeroDocumento)) {
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
        Object this$fechaNacimiento = getFechaNacimiento();
        Object other$fechaNacimiento = other.getFechaNacimiento();
        if (this$fechaNacimiento == null) {
            if (other$fechaNacimiento != null) {
                return false;
            }
        } else if (!this$fechaNacimiento.equals(other$fechaNacimiento)) {
            return false;
        }
        Object this$municipioResidencia = getMunicipioResidencia();
        Object other$municipioResidencia = other.getMunicipioResidencia();
        if (this$municipioResidencia == null) {
            if (other$municipioResidencia != null) {
                return false;
            }
        } else if (!this$municipioResidencia.equals(other$municipioResidencia)) {
            return false;
        }
        Object this$direccion = getDireccion();
        Object other$direccion = other.getDireccion();
        if (this$direccion == null) {
            if (other$direccion != null) {
                return false;
            }
        } else if (!this$direccion.equals(other$direccion)) {
            return false;
        }
        Object this$telefono = getTelefono();
        Object other$telefono = other.getTelefono();
        if (this$telefono == null) {
            if (other$telefono != null) {
                return false;
            }
        } else if (!this$telefono.equals(other$telefono)) {
            return false;
        }
        Object this$idTipoRegimen = getIdTipoRegimen();
        Object other$idTipoRegimen = other.getIdTipoRegimen();
        if (this$idTipoRegimen == null) {
            if (other$idTipoRegimen != null) {
                return false;
            }
        } else if (!this$idTipoRegimen.equals(other$idTipoRegimen)) {
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
        Object this$nombreIps = getNombreIps();
        Object other$nombreIps = other.getNombreIps();
        if (this$nombreIps == null) {
            if (other$nombreIps != null) {
                return false;
            }
        } else if (!this$nombreIps.equals(other$nombreIps)) {
            return false;
        }
        Object this$fechaToma = getFechaToma();
        Object other$fechaToma = other.getFechaToma();
        if (this$fechaToma == null) {
            if (other$fechaToma != null) {
                return false;
            }
        } else if (!this$fechaToma.equals(other$fechaToma)) {
            return false;
        }
        Object this$fechaRecepcion = getFechaRecepcion();
        Object other$fechaRecepcion = other.getFechaRecepcion();
        if (this$fechaRecepcion == null) {
            if (other$fechaRecepcion != null) {
                return false;
            }
        } else if (!this$fechaRecepcion.equals(other$fechaRecepcion)) {
            return false;
        }
        Object this$fechaResultado = getFechaResultado();
        Object other$fechaResultado = other.getFechaResultado();
        if (this$fechaResultado == null) {
            if (other$fechaResultado != null) {
                return false;
            }
        } else if (!this$fechaResultado.equals(other$fechaResultado)) {
            return false;
        }
        Object this$fechaValidacion = getFechaValidacion();
        Object other$fechaValidacion = other.getFechaValidacion();
        if (this$fechaValidacion == null) {
            if (other$fechaValidacion != null) {
                return false;
            }
        } else if (!this$fechaValidacion.equals(other$fechaValidacion)) {
            return false;
        }
        Object this$fechaUltimaMestruacion = getFechaUltimaMestruacion();
        Object other$fechaUltimaMestruacion = other.getFechaUltimaMestruacion();
        if (this$fechaUltimaMestruacion == null) {
            if (other$fechaUltimaMestruacion != null) {
                return false;
            }
        } else if (!this$fechaUltimaMestruacion.equals(other$fechaUltimaMestruacion)) {
            return false;
        }
        Object this$tipoMetodoPlanificacion = getTipoMetodoPlanificacion();
        Object other$tipoMetodoPlanificacion = other.getTipoMetodoPlanificacion();
        if (this$tipoMetodoPlanificacion == null) {
            if (other$tipoMetodoPlanificacion != null) {
                return false;
            }
        } else if (!this$tipoMetodoPlanificacion.equals(other$tipoMetodoPlanificacion)) {
            return false;
        }
        Object this$nombreTipoMetodoPlanificacion = getNombreTipoMetodoPlanificacion();
        Object other$nombreTipoMetodoPlanificacion = other.getNombreTipoMetodoPlanificacion();
        if (this$nombreTipoMetodoPlanificacion == null) {
            if (other$nombreTipoMetodoPlanificacion != null) {
                return false;
            }
        } else if (!this$nombreTipoMetodoPlanificacion.equals(other$nombreTipoMetodoPlanificacion)) {
            return false;
        }
        Object this$histerectomia = getHisterectomia();
        Object other$histerectomia = other.getHisterectomia();
        if (this$histerectomia == null) {
            if (other$histerectomia != null) {
                return false;
            }
        } else if (!this$histerectomia.equals(other$histerectomia)) {
            return false;
        }
        Object this$cauterizacion = getCauterizacion();
        Object other$cauterizacion = other.getCauterizacion();
        if (this$cauterizacion == null) {
            if (other$cauterizacion != null) {
                return false;
            }
        } else if (!this$cauterizacion.equals(other$cauterizacion)) {
            return false;
        }
        Object this$conizacion = getConizacion();
        Object other$conizacion = other.getConizacion();
        if (this$conizacion == null) {
            if (other$conizacion != null) {
                return false;
            }
        } else if (!this$conizacion.equals(other$conizacion)) {
            return false;
        }
        Object this$radioterapia = getRadioterapia();
        Object other$radioterapia = other.getRadioterapia();
        if (this$radioterapia == null) {
            if (other$radioterapia != null) {
                return false;
            }
        } else if (!this$radioterapia.equals(other$radioterapia)) {
            return false;
        }
        Object this$tratamientoHormonal = getTratamientoHormonal();
        Object other$tratamientoHormonal = other.getTratamientoHormonal();
        if (this$tratamientoHormonal == null) {
            if (other$tratamientoHormonal != null) {
                return false;
            }
        } else if (!this$tratamientoHormonal.equals(other$tratamientoHormonal)) {
            return false;
        }
        Object this$aspecCuello = getAspecCuello();
        Object other$aspecCuello = other.getAspecCuello();
        if (this$aspecCuello == null) {
            if (other$aspecCuello != null) {
                return false;
            }
        } else if (!this$aspecCuello.equals(other$aspecCuello)) {
            return false;
        }
        Object this$descripcionAspecto = getDescripcionAspecto();
        Object other$descripcionAspecto = other.getDescripcionAspecto();
        if (this$descripcionAspecto == null) {
            if (other$descripcionAspecto != null) {
                return false;
            }
        } else if (!this$descripcionAspecto.equals(other$descripcionAspecto)) {
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
        Object this$sintomas = getSintomas();
        Object other$sintomas = other.getSintomas();
        if (this$sintomas == null) {
            if (other$sintomas != null) {
                return false;
            }
        } else if (!this$sintomas.equals(other$sintomas)) {
            return false;
        }
        Object this$resultadoUltimaCitologia = getResultadoUltimaCitologia();
        Object other$resultadoUltimaCitologia = other.getResultadoUltimaCitologia();
        if (this$resultadoUltimaCitologia == null) {
            if (other$resultadoUltimaCitologia != null) {
                return false;
            }
        } else if (!this$resultadoUltimaCitologia.equals(other$resultadoUltimaCitologia)) {
            return false;
        }
        Object this$fechaUltimaCitologia = getFechaUltimaCitologia();
        Object other$fechaUltimaCitologia = other.getFechaUltimaCitologia();
        if (this$fechaUltimaCitologia == null) {
            if (other$fechaUltimaCitologia != null) {
                return false;
            }
        } else if (!this$fechaUltimaCitologia.equals(other$fechaUltimaCitologia)) {
            return false;
        }
        Object this$calidadMuestra = getCalidadMuestra();
        Object other$calidadMuestra = other.getCalidadMuestra();
        if (this$calidadMuestra == null) {
            if (other$calidadMuestra != null) {
                return false;
            }
        } else if (!this$calidadMuestra.equals(other$calidadMuestra)) {
            return false;
        }
        Object this$observacionCalidad = getObservacionCalidad();
        Object other$observacionCalidad = other.getObservacionCalidad();
        if (this$observacionCalidad == null) {
            if (other$observacionCalidad != null) {
                return false;
            }
        } else if (!this$observacionCalidad.equals(other$observacionCalidad)) {
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
        Object this$firmaProfesional = getFirmaProfesional();
        Object other$firmaProfesional = other.getFirmaProfesional();
        if (this$firmaProfesional == null) {
            if (other$firmaProfesional != null) {
                return false;
            }
        } else if (!this$firmaProfesional.equals(other$firmaProfesional)) {
            return false;
        }
        Object this$profesionalEspecialista = getProfesionalEspecialista();
        Object other$profesionalEspecialista = other.getProfesionalEspecialista();
        if (this$profesionalEspecialista == null) {
            if (other$profesionalEspecialista != null) {
                return false;
            }
        } else if (!this$profesionalEspecialista.equals(other$profesionalEspecialista)) {
            return false;
        }
        Object this$especialidadEspecialista = getEspecialidadEspecialista();
        Object other$especialidadEspecialista = other.getEspecialidadEspecialista();
        if (this$especialidadEspecialista == null) {
            if (other$especialidadEspecialista != null) {
                return false;
            }
        } else if (!this$especialidadEspecialista.equals(other$especialidadEspecialista)) {
            return false;
        }
        Object this$firmaProfesionalEspecialista = getFirmaProfesionalEspecialista();
        Object other$firmaProfesionalEspecialista = other.getFirmaProfesionalEspecialista();
        if (this$firmaProfesionalEspecialista == null) {
            if (other$firmaProfesionalEspecialista != null) {
                return false;
            }
        } else if (!this$firmaProfesionalEspecialista.equals(other$firmaProfesionalEspecialista)) {
            return false;
        }
        Object this$registro = getRegistro();
        Object other$registro = other.getRegistro();
        if (this$registro == null) {
            if (other$registro != null) {
                return false;
            }
        } else if (!this$registro.equals(other$registro)) {
            return false;
        }
        Object this$observacionResultado = getObservacionResultado();
        Object other$observacionResultado = other.getObservacionResultado();
        if (this$observacionResultado == null) {
            if (other$observacionResultado != null) {
                return false;
            }
        } else if (!this$observacionResultado.equals(other$observacionResultado)) {
            return false;
        }
        Object this$profesionalValida = getProfesionalValida();
        Object other$profesionalValida = other.getProfesionalValida();
        if (this$profesionalValida == null) {
            if (other$profesionalValida != null) {
                return false;
            }
        } else if (!this$profesionalValida.equals(other$profesionalValida)) {
            return false;
        }
        Object this$especialidadValida = getEspecialidadValida();
        Object other$especialidadValida = other.getEspecialidadValida();
        if (this$especialidadValida == null) {
            if (other$especialidadValida != null) {
                return false;
            }
        } else if (!this$especialidadValida.equals(other$especialidadValida)) {
            return false;
        }
        Object this$registroValida = getRegistroValida();
        Object other$registroValida = other.getRegistroValida();
        if (this$registroValida == null) {
            if (other$registroValida != null) {
                return false;
            }
        } else if (!this$registroValida.equals(other$registroValida)) {
            return false;
        }
        Object this$firmaValida = getFirmaValida();
        Object other$firmaValida = other.getFirmaValida();
        if (this$firmaValida == null) {
            if (other$firmaValida != null) {
                return false;
            }
        } else if (!this$firmaValida.equals(other$firmaValida)) {
            return false;
        }
        Object this$clasificacionGeneral = getClasificacionGeneral();
        Object other$clasificacionGeneral = other.getClasificacionGeneral();
        if (this$clasificacionGeneral == null) {
            if (other$clasificacionGeneral != null) {
                return false;
            }
        } else if (!this$clasificacionGeneral.equals(other$clasificacionGeneral)) {
            return false;
        }
        Object this$microorganismo = getMicroorganismo();
        Object other$microorganismo = other.getMicroorganismo();
        if (this$microorganismo == null) {
            if (other$microorganismo != null) {
                return false;
            }
        } else if (!this$microorganismo.equals(other$microorganismo)) {
            return false;
        }
        Object this$hallazgosNeoplaticos = getHallazgosNeoplaticos();
        Object other$hallazgosNeoplaticos = other.getHallazgosNeoplaticos();
        if (this$hallazgosNeoplaticos == null) {
            if (other$hallazgosNeoplaticos != null) {
                return false;
            }
        } else if (!this$hallazgosNeoplaticos.equals(other$hallazgosNeoplaticos)) {
            return false;
        }
        Object this$celulasEscamosas = getCelulasEscamosas();
        Object other$celulasEscamosas = other.getCelulasEscamosas();
        if (this$celulasEscamosas == null) {
            if (other$celulasEscamosas != null) {
                return false;
            }
        } else if (!this$celulasEscamosas.equals(other$celulasEscamosas)) {
            return false;
        }
        Object this$celulasGlandulares = getCelulasGlandulares();
        Object other$celulasGlandulares = other.getCelulasGlandulares();
        if (this$celulasGlandulares == null) {
            if (other$celulasGlandulares != null) {
                return false;
            }
        } else if (!this$celulasGlandulares.equals(other$celulasGlandulares)) {
            return false;
        }
        Object this$clasificacionGeneralText = getClasificacionGeneralText();
        Object other$clasificacionGeneralText = other.getClasificacionGeneralText();
        if (this$clasificacionGeneralText == null) {
            if (other$clasificacionGeneralText != null) {
                return false;
            }
        } else if (!this$clasificacionGeneralText.equals(other$clasificacionGeneralText)) {
            return false;
        }
        Object this$microorganismoText = getMicroorganismoText();
        Object other$microorganismoText = other.getMicroorganismoText();
        if (this$microorganismoText == null) {
            if (other$microorganismoText != null) {
                return false;
            }
        } else if (!this$microorganismoText.equals(other$microorganismoText)) {
            return false;
        }
        Object this$hallazgosNeoplaticosText = getHallazgosNeoplaticosText();
        Object other$hallazgosNeoplaticosText = other.getHallazgosNeoplaticosText();
        if (this$hallazgosNeoplaticosText == null) {
            if (other$hallazgosNeoplaticosText != null) {
                return false;
            }
        } else if (!this$hallazgosNeoplaticosText.equals(other$hallazgosNeoplaticosText)) {
            return false;
        }
        Object this$celulasEscamosasText = getCelulasEscamosasText();
        Object other$celulasEscamosasText = other.getCelulasEscamosasText();
        if (this$celulasEscamosasText == null) {
            if (other$celulasEscamosasText != null) {
                return false;
            }
        } else if (!this$celulasEscamosasText.equals(other$celulasEscamosasText)) {
            return false;
        }
        Object this$celulasGlandularesText = getCelulasGlandularesText();
        Object other$celulasGlandularesText = other.getCelulasGlandularesText();
        if (this$celulasGlandularesText == null) {
            if (other$celulasGlandularesText != null) {
                return false;
            }
        } else if (!this$celulasGlandularesText.equals(other$celulasGlandularesText)) {
            return false;
        }
        Object this$NCConducta = getNCConducta();
        Object other$NCConducta = other.getNCConducta();
        if (this$NCConducta == null) {
            if (other$NCConducta != null) {
                return false;
            }
        } else if (!this$NCConducta.equals(other$NCConducta)) {
            return false;
        }
        Object this$noPlacaCitologia = getNoPlacaCitologia();
        Object other$noPlacaCitologia = other.getNoPlacaCitologia();
        if (this$noPlacaCitologia == null) {
            if (other$noPlacaCitologia != null) {
                return false;
            }
        } else if (!this$noPlacaCitologia.equals(other$noPlacaCitologia)) {
            return false;
        }
        Object this$nombreQuienTomaCitologia = getNombreQuienTomaCitologia();
        Object other$nombreQuienTomaCitologia = other.getNombreQuienTomaCitologia();
        if (this$nombreQuienTomaCitologia == null) {
            if (other$nombreQuienTomaCitologia != null) {
                return false;
            }
        } else if (!this$nombreQuienTomaCitologia.equals(other$nombreQuienTomaCitologia)) {
            return false;
        }
        Object this$cargoQuienTomaCitologia = getCargoQuienTomaCitologia();
        Object other$cargoQuienTomaCitologia = other.getCargoQuienTomaCitologia();
        if (this$cargoQuienTomaCitologia == null) {
            if (other$cargoQuienTomaCitologia != null) {
                return false;
            }
        } else if (!this$cargoQuienTomaCitologia.equals(other$cargoQuienTomaCitologia)) {
            return false;
        }
        Object this$rutaReportes = getRutaReportes();
        Object other$rutaReportes = other.getRutaReportes();
        return this$rutaReportes == null ? other$rutaReportes == null : this$rutaReportes.equals(other$rutaReportes);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CitologiaDTO;
    }

    @Generated
    public int hashCode() {
        Object $numeroEmbarazo = getNumeroEmbarazo();
        int result = (1 * 59) + ($numeroEmbarazo == null ? 43 : $numeroEmbarazo.hashCode());
        Object $numeroPartos = getNumeroPartos();
        int result2 = (result * 59) + ($numeroPartos == null ? 43 : $numeroPartos.hashCode());
        Object $numeroCesarea = getNumeroCesarea();
        int result3 = (result2 * 59) + ($numeroCesarea == null ? 43 : $numeroCesarea.hashCode());
        Object $numeroAbortos = getNumeroAbortos();
        int result4 = (result3 * 59) + ($numeroAbortos == null ? 43 : $numeroAbortos.hashCode());
        Object $primeraVez = getPrimeraVez();
        int result5 = (result4 * 59) + ($primeraVez == null ? 43 : $primeraVez.hashCode());
        Object $idResultado = getIdResultado();
        int result6 = (result5 * 59) + ($idResultado == null ? 43 : $idResultado.hashCode());
        Object $idCitologia = getIdCitologia();
        int result7 = (result6 * 59) + ($idCitologia == null ? 43 : $idCitologia.hashCode());
        Object $consecutivo = getConsecutivo();
        int result8 = (result7 * 59) + ($consecutivo == null ? 43 : $consecutivo.hashCode());
        Object $nombreSede = getNombreSede();
        int result9 = (result8 * 59) + ($nombreSede == null ? 43 : $nombreSede.hashCode());
        Object $nombreUsuario = getNombreUsuario();
        int result10 = (result9 * 59) + ($nombreUsuario == null ? 43 : $nombreUsuario.hashCode());
        Object $numeroDocumento = getNumeroDocumento();
        int result11 = (result10 * 59) + ($numeroDocumento == null ? 43 : $numeroDocumento.hashCode());
        Object $edad = getEdad();
        int result12 = (result11 * 59) + ($edad == null ? 43 : $edad.hashCode());
        Object $fechaNacimiento = getFechaNacimiento();
        int result13 = (result12 * 59) + ($fechaNacimiento == null ? 43 : $fechaNacimiento.hashCode());
        Object $municipioResidencia = getMunicipioResidencia();
        int result14 = (result13 * 59) + ($municipioResidencia == null ? 43 : $municipioResidencia.hashCode());
        Object $direccion = getDireccion();
        int result15 = (result14 * 59) + ($direccion == null ? 43 : $direccion.hashCode());
        Object $telefono = getTelefono();
        int result16 = (result15 * 59) + ($telefono == null ? 43 : $telefono.hashCode());
        Object $idTipoRegimen = getIdTipoRegimen();
        int result17 = (result16 * 59) + ($idTipoRegimen == null ? 43 : $idTipoRegimen.hashCode());
        Object $empresaConvenio = getEmpresaConvenio();
        int result18 = (result17 * 59) + ($empresaConvenio == null ? 43 : $empresaConvenio.hashCode());
        Object $nombreIps = getNombreIps();
        int result19 = (result18 * 59) + ($nombreIps == null ? 43 : $nombreIps.hashCode());
        Object $fechaToma = getFechaToma();
        int result20 = (result19 * 59) + ($fechaToma == null ? 43 : $fechaToma.hashCode());
        Object $fechaRecepcion = getFechaRecepcion();
        int result21 = (result20 * 59) + ($fechaRecepcion == null ? 43 : $fechaRecepcion.hashCode());
        Object $fechaResultado = getFechaResultado();
        int result22 = (result21 * 59) + ($fechaResultado == null ? 43 : $fechaResultado.hashCode());
        Object $fechaValidacion = getFechaValidacion();
        int result23 = (result22 * 59) + ($fechaValidacion == null ? 43 : $fechaValidacion.hashCode());
        Object $fechaUltimaMestruacion = getFechaUltimaMestruacion();
        int result24 = (result23 * 59) + ($fechaUltimaMestruacion == null ? 43 : $fechaUltimaMestruacion.hashCode());
        Object $tipoMetodoPlanificacion = getTipoMetodoPlanificacion();
        int result25 = (result24 * 59) + ($tipoMetodoPlanificacion == null ? 43 : $tipoMetodoPlanificacion.hashCode());
        Object $nombreTipoMetodoPlanificacion = getNombreTipoMetodoPlanificacion();
        int result26 = (result25 * 59) + ($nombreTipoMetodoPlanificacion == null ? 43 : $nombreTipoMetodoPlanificacion.hashCode());
        Object $histerectomia = getHisterectomia();
        int result27 = (result26 * 59) + ($histerectomia == null ? 43 : $histerectomia.hashCode());
        Object $cauterizacion = getCauterizacion();
        int result28 = (result27 * 59) + ($cauterizacion == null ? 43 : $cauterizacion.hashCode());
        Object $conizacion = getConizacion();
        int result29 = (result28 * 59) + ($conizacion == null ? 43 : $conizacion.hashCode());
        Object $radioterapia = getRadioterapia();
        int result30 = (result29 * 59) + ($radioterapia == null ? 43 : $radioterapia.hashCode());
        Object $tratamientoHormonal = getTratamientoHormonal();
        int result31 = (result30 * 59) + ($tratamientoHormonal == null ? 43 : $tratamientoHormonal.hashCode());
        Object $aspecCuello = getAspecCuello();
        int result32 = (result31 * 59) + ($aspecCuello == null ? 43 : $aspecCuello.hashCode());
        Object $descripcionAspecto = getDescripcionAspecto();
        int result33 = (result32 * 59) + ($descripcionAspecto == null ? 43 : $descripcionAspecto.hashCode());
        Object $observacion = getObservacion();
        int result34 = (result33 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $sintomas = getSintomas();
        int result35 = (result34 * 59) + ($sintomas == null ? 43 : $sintomas.hashCode());
        Object $resultadoUltimaCitologia = getResultadoUltimaCitologia();
        int result36 = (result35 * 59) + ($resultadoUltimaCitologia == null ? 43 : $resultadoUltimaCitologia.hashCode());
        Object $fechaUltimaCitologia = getFechaUltimaCitologia();
        int result37 = (result36 * 59) + ($fechaUltimaCitologia == null ? 43 : $fechaUltimaCitologia.hashCode());
        Object $calidadMuestra = getCalidadMuestra();
        int result38 = (result37 * 59) + ($calidadMuestra == null ? 43 : $calidadMuestra.hashCode());
        Object $observacionCalidad = getObservacionCalidad();
        int result39 = (result38 * 59) + ($observacionCalidad == null ? 43 : $observacionCalidad.hashCode());
        Object $profesional = getProfesional();
        int result40 = (result39 * 59) + ($profesional == null ? 43 : $profesional.hashCode());
        Object $especialidad = getEspecialidad();
        int result41 = (result40 * 59) + ($especialidad == null ? 43 : $especialidad.hashCode());
        Object $firmaProfesional = getFirmaProfesional();
        int result42 = (result41 * 59) + ($firmaProfesional == null ? 43 : $firmaProfesional.hashCode());
        Object $profesionalEspecialista = getProfesionalEspecialista();
        int result43 = (result42 * 59) + ($profesionalEspecialista == null ? 43 : $profesionalEspecialista.hashCode());
        Object $especialidadEspecialista = getEspecialidadEspecialista();
        int result44 = (result43 * 59) + ($especialidadEspecialista == null ? 43 : $especialidadEspecialista.hashCode());
        Object $firmaProfesionalEspecialista = getFirmaProfesionalEspecialista();
        int result45 = (result44 * 59) + ($firmaProfesionalEspecialista == null ? 43 : $firmaProfesionalEspecialista.hashCode());
        Object $registro = getRegistro();
        int result46 = (result45 * 59) + ($registro == null ? 43 : $registro.hashCode());
        Object $observacionResultado = getObservacionResultado();
        int result47 = (result46 * 59) + ($observacionResultado == null ? 43 : $observacionResultado.hashCode());
        Object $profesionalValida = getProfesionalValida();
        int result48 = (result47 * 59) + ($profesionalValida == null ? 43 : $profesionalValida.hashCode());
        Object $especialidadValida = getEspecialidadValida();
        int result49 = (result48 * 59) + ($especialidadValida == null ? 43 : $especialidadValida.hashCode());
        Object $registroValida = getRegistroValida();
        int result50 = (result49 * 59) + ($registroValida == null ? 43 : $registroValida.hashCode());
        Object $firmaValida = getFirmaValida();
        int result51 = (result50 * 59) + ($firmaValida == null ? 43 : $firmaValida.hashCode());
        Object $clasificacionGeneral = getClasificacionGeneral();
        int result52 = (result51 * 59) + ($clasificacionGeneral == null ? 43 : $clasificacionGeneral.hashCode());
        Object $microorganismo = getMicroorganismo();
        int result53 = (result52 * 59) + ($microorganismo == null ? 43 : $microorganismo.hashCode());
        Object $hallazgosNeoplaticos = getHallazgosNeoplaticos();
        int result54 = (result53 * 59) + ($hallazgosNeoplaticos == null ? 43 : $hallazgosNeoplaticos.hashCode());
        Object $celulasEscamosas = getCelulasEscamosas();
        int result55 = (result54 * 59) + ($celulasEscamosas == null ? 43 : $celulasEscamosas.hashCode());
        Object $celulasGlandulares = getCelulasGlandulares();
        int result56 = (result55 * 59) + ($celulasGlandulares == null ? 43 : $celulasGlandulares.hashCode());
        Object $clasificacionGeneralText = getClasificacionGeneralText();
        int result57 = (result56 * 59) + ($clasificacionGeneralText == null ? 43 : $clasificacionGeneralText.hashCode());
        Object $microorganismoText = getMicroorganismoText();
        int result58 = (result57 * 59) + ($microorganismoText == null ? 43 : $microorganismoText.hashCode());
        Object $hallazgosNeoplaticosText = getHallazgosNeoplaticosText();
        int result59 = (result58 * 59) + ($hallazgosNeoplaticosText == null ? 43 : $hallazgosNeoplaticosText.hashCode());
        Object $celulasEscamosasText = getCelulasEscamosasText();
        int result60 = (result59 * 59) + ($celulasEscamosasText == null ? 43 : $celulasEscamosasText.hashCode());
        Object $celulasGlandularesText = getCelulasGlandularesText();
        int result61 = (result60 * 59) + ($celulasGlandularesText == null ? 43 : $celulasGlandularesText.hashCode());
        Object $NCConducta = getNCConducta();
        int result62 = (result61 * 59) + ($NCConducta == null ? 43 : $NCConducta.hashCode());
        Object $noPlacaCitologia = getNoPlacaCitologia();
        int result63 = (result62 * 59) + ($noPlacaCitologia == null ? 43 : $noPlacaCitologia.hashCode());
        Object $nombreQuienTomaCitologia = getNombreQuienTomaCitologia();
        int result64 = (result63 * 59) + ($nombreQuienTomaCitologia == null ? 43 : $nombreQuienTomaCitologia.hashCode());
        Object $cargoQuienTomaCitologia = getCargoQuienTomaCitologia();
        int result65 = (result64 * 59) + ($cargoQuienTomaCitologia == null ? 43 : $cargoQuienTomaCitologia.hashCode());
        Object $rutaReportes = getRutaReportes();
        return (result65 * 59) + ($rutaReportes == null ? 43 : $rutaReportes.hashCode());
    }

    @Generated
    public String toString() {
        return "CitologiaDTO(consecutivo=" + getConsecutivo() + ", nombreSede=" + getNombreSede() + ", nombreUsuario=" + getNombreUsuario() + ", numeroDocumento=" + getNumeroDocumento() + ", edad=" + getEdad() + ", fechaNacimiento=" + getFechaNacimiento() + ", municipioResidencia=" + getMunicipioResidencia() + ", direccion=" + getDireccion() + ", telefono=" + getTelefono() + ", idTipoRegimen=" + getIdTipoRegimen() + ", empresaConvenio=" + getEmpresaConvenio() + ", nombreIps=" + getNombreIps() + ", fechaToma=" + getFechaToma() + ", fechaRecepcion=" + getFechaRecepcion() + ", fechaResultado=" + getFechaResultado() + ", fechaValidacion=" + getFechaValidacion() + ", numeroEmbarazo=" + getNumeroEmbarazo() + ", numeroPartos=" + getNumeroPartos() + ", numeroCesarea=" + getNumeroCesarea() + ", numeroAbortos=" + getNumeroAbortos() + ", fechaUltimaMestruacion=" + getFechaUltimaMestruacion() + ", tipoMetodoPlanificacion=" + getTipoMetodoPlanificacion() + ", nombreTipoMetodoPlanificacion=" + getNombreTipoMetodoPlanificacion() + ", primeraVez=" + getPrimeraVez() + ", histerectomia=" + getHisterectomia() + ", cauterizacion=" + getCauterizacion() + ", conizacion=" + getConizacion() + ", radioterapia=" + getRadioterapia() + ", tratamientoHormonal=" + getTratamientoHormonal() + ", aspecCuello=" + getAspecCuello() + ", descripcionAspecto=" + getDescripcionAspecto() + ", observacion=" + getObservacion() + ", sintomas=" + getSintomas() + ", resultadoUltimaCitologia=" + getResultadoUltimaCitologia() + ", fechaUltimaCitologia=" + getFechaUltimaCitologia() + ", calidadMuestra=" + getCalidadMuestra() + ", observacionCalidad=" + getObservacionCalidad() + ", idResultado=" + getIdResultado() + ", idCitologia=" + getIdCitologia() + ", profesional=" + getProfesional() + ", especialidad=" + getEspecialidad() + ", firmaProfesional=" + getFirmaProfesional() + ", profesionalEspecialista=" + getProfesionalEspecialista() + ", especialidadEspecialista=" + getEspecialidadEspecialista() + ", firmaProfesionalEspecialista=" + getFirmaProfesionalEspecialista() + ", registro=" + getRegistro() + ", observacionResultado=" + getObservacionResultado() + ", profesionalValida=" + getProfesionalValida() + ", especialidadValida=" + getEspecialidadValida() + ", registroValida=" + getRegistroValida() + ", firmaValida=" + getFirmaValida() + ", clasificacionGeneral=" + getClasificacionGeneral() + ", microorganismo=" + getMicroorganismo() + ", hallazgosNeoplaticos=" + getHallazgosNeoplaticos() + ", celulasEscamosas=" + getCelulasEscamosas() + ", celulasGlandulares=" + getCelulasGlandulares() + ", clasificacionGeneralText=" + getClasificacionGeneralText() + ", microorganismoText=" + getMicroorganismoText() + ", hallazgosNeoplaticosText=" + getHallazgosNeoplaticosText() + ", celulasEscamosasText=" + getCelulasEscamosasText() + ", celulasGlandularesText=" + getCelulasGlandularesText() + ", NCConducta=" + getNCConducta() + ", noPlacaCitologia=" + getNoPlacaCitologia() + ", nombreQuienTomaCitologia=" + getNombreQuienTomaCitologia() + ", cargoQuienTomaCitologia=" + getCargoQuienTomaCitologia() + ", rutaReportes=" + getRutaReportes() + ")";
    }

    @Generated
    public String getConsecutivo() {
        return this.consecutivo;
    }

    @Generated
    public String getNombreSede() {
        return this.nombreSede;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    @Generated
    public String getEdad() {
        return this.edad;
    }

    @Generated
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    @Generated
    public String getMunicipioResidencia() {
        return this.municipioResidencia;
    }

    @Generated
    public String getDireccion() {
        return this.direccion;
    }

    @Generated
    public String getTelefono() {
        return this.telefono;
    }

    @Generated
    public String getIdTipoRegimen() {
        return this.idTipoRegimen;
    }

    @Generated
    public String getEmpresaConvenio() {
        return this.empresaConvenio;
    }

    @Generated
    public String getNombreIps() {
        return this.nombreIps;
    }

    @Generated
    public String getFechaToma() {
        return this.fechaToma;
    }

    @Generated
    public String getFechaRecepcion() {
        return this.fechaRecepcion;
    }

    @Generated
    public String getFechaResultado() {
        return this.fechaResultado;
    }

    @Generated
    public String getFechaValidacion() {
        return this.fechaValidacion;
    }

    @Generated
    public Integer getNumeroEmbarazo() {
        return this.numeroEmbarazo;
    }

    @Generated
    public Integer getNumeroPartos() {
        return this.numeroPartos;
    }

    @Generated
    public Integer getNumeroCesarea() {
        return this.numeroCesarea;
    }

    @Generated
    public Integer getNumeroAbortos() {
        return this.numeroAbortos;
    }

    @Generated
    public String getFechaUltimaMestruacion() {
        return this.fechaUltimaMestruacion;
    }

    @Generated
    public String getTipoMetodoPlanificacion() {
        return this.tipoMetodoPlanificacion;
    }

    @Generated
    public String getNombreTipoMetodoPlanificacion() {
        return this.nombreTipoMetodoPlanificacion;
    }

    @Generated
    public Boolean getPrimeraVez() {
        return this.primeraVez;
    }

    @Generated
    public String getHisterectomia() {
        return this.histerectomia;
    }

    @Generated
    public String getCauterizacion() {
        return this.cauterizacion;
    }

    @Generated
    public String getConizacion() {
        return this.conizacion;
    }

    @Generated
    public String getRadioterapia() {
        return this.radioterapia;
    }

    @Generated
    public String getTratamientoHormonal() {
        return this.tratamientoHormonal;
    }

    @Generated
    public String getAspecCuello() {
        return this.aspecCuello;
    }

    @Generated
    public String getDescripcionAspecto() {
        return this.descripcionAspecto;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public String getSintomas() {
        return this.sintomas;
    }

    @Generated
    public String getResultadoUltimaCitologia() {
        return this.resultadoUltimaCitologia;
    }

    @Generated
    public String getFechaUltimaCitologia() {
        return this.fechaUltimaCitologia;
    }

    @Generated
    public String getCalidadMuestra() {
        return this.calidadMuestra;
    }

    @Generated
    public String getObservacionCalidad() {
        return this.observacionCalidad;
    }

    @Generated
    public Long getIdResultado() {
        return this.idResultado;
    }

    @Generated
    public Long getIdCitologia() {
        return this.idCitologia;
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
    public String getFirmaProfesional() {
        return this.firmaProfesional;
    }

    @Generated
    public String getProfesionalEspecialista() {
        return this.profesionalEspecialista;
    }

    @Generated
    public String getEspecialidadEspecialista() {
        return this.especialidadEspecialista;
    }

    @Generated
    public String getFirmaProfesionalEspecialista() {
        return this.firmaProfesionalEspecialista;
    }

    @Generated
    public String getRegistro() {
        return this.registro;
    }

    @Generated
    public String getObservacionResultado() {
        return this.observacionResultado;
    }

    @Generated
    public String getProfesionalValida() {
        return this.profesionalValida;
    }

    @Generated
    public String getEspecialidadValida() {
        return this.especialidadValida;
    }

    @Generated
    public String getRegistroValida() {
        return this.registroValida;
    }

    @Generated
    public String getFirmaValida() {
        return this.firmaValida;
    }

    @Generated
    public List<GenericDomain> getClasificacionGeneral() {
        return this.clasificacionGeneral;
    }

    @Generated
    public List<GenericDomain> getMicroorganismo() {
        return this.microorganismo;
    }

    @Generated
    public List<GenericDomain> getHallazgosNeoplaticos() {
        return this.hallazgosNeoplaticos;
    }

    @Generated
    public List<GenericDomain> getCelulasEscamosas() {
        return this.celulasEscamosas;
    }

    @Generated
    public List<GenericDomain> getCelulasGlandulares() {
        return this.celulasGlandulares;
    }

    @Generated
    public String getNCConducta() {
        return this.NCConducta;
    }

    @Generated
    public String getNoPlacaCitologia() {
        return this.noPlacaCitologia;
    }

    @Generated
    public String getNombreQuienTomaCitologia() {
        return this.nombreQuienTomaCitologia;
    }

    @Generated
    public String getCargoQuienTomaCitologia() {
        return this.cargoQuienTomaCitologia;
    }

    @Generated
    public String getRutaReportes() {
        return this.rutaReportes;
    }

    public String getClasificacionGeneralText() {
        return getTextFromList(this.clasificacionGeneral);
    }

    public String getMicroorganismoText() {
        return getTextFromList(this.microorganismo);
    }

    public String getHallazgosNeoplaticosText() {
        return getTextFromList(this.hallazgosNeoplaticos);
    }

    public String getCelulasEscamosasText() {
        return getTextFromList(this.celulasEscamosas);
    }

    public String getCelulasGlandularesText() {
        return getTextFromList(this.celulasGlandulares);
    }

    private String getTextFromList(List<GenericDomain> list) {
        return (list == null || list.isEmpty()) ? "" : (String) list.stream().map((v0) -> {
            return v0.getNombre();
        }).collect(Collectors.joining("\n"));
    }
}
