package com.genoma.plus.controller.general.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/EncuestaRegistroUsuario.class */
public class EncuestaRegistroUsuario {
    private Long id;
    private Long idPersona;
    private LocalDateTime fechaOrden;
    private String nombreSede;
    private String usuarioSistema;
    private String cargo;
    private List<DetalleCuestionarioDto> preguntas;
    private Long idIngreso;
    private String firma;
    private String huella;
    private Boolean estado;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/EncuestaRegistroUsuario$EncuestaRegistroUsuarioBuilder.class */
    @Generated
    public static class EncuestaRegistroUsuarioBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idPersona;

        @Generated
        private LocalDateTime fechaOrden;

        @Generated
        private String nombreSede;

        @Generated
        private String usuarioSistema;

        @Generated
        private String cargo;

        @Generated
        private List<DetalleCuestionarioDto> preguntas;

        @Generated
        private Long idIngreso;

        @Generated
        private String firma;

        @Generated
        private String huella;

        @Generated
        private Boolean estado;

        @Generated
        EncuestaRegistroUsuarioBuilder() {
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder idPersona(Long idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder fechaOrden(LocalDateTime fechaOrden) {
            this.fechaOrden = fechaOrden;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder nombreSede(String nombreSede) {
            this.nombreSede = nombreSede;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder usuarioSistema(String usuarioSistema) {
            this.usuarioSistema = usuarioSistema;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder cargo(String cargo) {
            this.cargo = cargo;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder preguntas(List<DetalleCuestionarioDto> preguntas) {
            this.preguntas = preguntas;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder idIngreso(Long idIngreso) {
            this.idIngreso = idIngreso;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder firma(String firma) {
            this.firma = firma;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder huella(String huella) {
            this.huella = huella;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuarioBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public EncuestaRegistroUsuario build() {
            return new EncuestaRegistroUsuario(this.id, this.idPersona, this.fechaOrden, this.nombreSede, this.usuarioSistema, this.cargo, this.preguntas, this.idIngreso, this.firma, this.huella, this.estado);
        }

        @Generated
        public String toString() {
            return "EncuestaRegistroUsuario.EncuestaRegistroUsuarioBuilder(id=" + this.id + ", idPersona=" + this.idPersona + ", fechaOrden=" + this.fechaOrden + ", nombreSede=" + this.nombreSede + ", usuarioSistema=" + this.usuarioSistema + ", cargo=" + this.cargo + ", preguntas=" + this.preguntas + ", idIngreso=" + this.idIngreso + ", firma=" + this.firma + ", huella=" + this.huella + ", estado=" + this.estado + ")";
        }
    }

    @Generated
    public static EncuestaRegistroUsuarioBuilder builder() {
        return new EncuestaRegistroUsuarioBuilder();
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Generated
    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @Generated
    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    @Generated
    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    @Generated
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Generated
    public void setPreguntas(List<DetalleCuestionarioDto> preguntas) {
        this.preguntas = preguntas;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Generated
    public void setHuella(String huella) {
        this.huella = huella;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EncuestaRegistroUsuario)) {
            return false;
        }
        EncuestaRegistroUsuario other = (EncuestaRegistroUsuario) o;
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
        Object this$estado = getEstado();
        Object other$estado = other.getEstado();
        if (this$estado == null) {
            if (other$estado != null) {
                return false;
            }
        } else if (!this$estado.equals(other$estado)) {
            return false;
        }
        Object this$fechaOrden = getFechaOrden();
        Object other$fechaOrden = other.getFechaOrden();
        if (this$fechaOrden == null) {
            if (other$fechaOrden != null) {
                return false;
            }
        } else if (!this$fechaOrden.equals(other$fechaOrden)) {
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
        Object this$usuarioSistema = getUsuarioSistema();
        Object other$usuarioSistema = other.getUsuarioSistema();
        if (this$usuarioSistema == null) {
            if (other$usuarioSistema != null) {
                return false;
            }
        } else if (!this$usuarioSistema.equals(other$usuarioSistema)) {
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
        Object this$preguntas = getPreguntas();
        Object other$preguntas = other.getPreguntas();
        if (this$preguntas == null) {
            if (other$preguntas != null) {
                return false;
            }
        } else if (!this$preguntas.equals(other$preguntas)) {
            return false;
        }
        Object this$firma = getFirma();
        Object other$firma = other.getFirma();
        if (this$firma == null) {
            if (other$firma != null) {
                return false;
            }
        } else if (!this$firma.equals(other$firma)) {
            return false;
        }
        Object this$huella = getHuella();
        Object other$huella = other.getHuella();
        return this$huella == null ? other$huella == null : this$huella.equals(other$huella);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof EncuestaRegistroUsuario;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idPersona = getIdPersona();
        int result2 = (result * 59) + ($idPersona == null ? 43 : $idPersona.hashCode());
        Object $idIngreso = getIdIngreso();
        int result3 = (result2 * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $estado = getEstado();
        int result4 = (result3 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $fechaOrden = getFechaOrden();
        int result5 = (result4 * 59) + ($fechaOrden == null ? 43 : $fechaOrden.hashCode());
        Object $nombreSede = getNombreSede();
        int result6 = (result5 * 59) + ($nombreSede == null ? 43 : $nombreSede.hashCode());
        Object $usuarioSistema = getUsuarioSistema();
        int result7 = (result6 * 59) + ($usuarioSistema == null ? 43 : $usuarioSistema.hashCode());
        Object $cargo = getCargo();
        int result8 = (result7 * 59) + ($cargo == null ? 43 : $cargo.hashCode());
        Object $preguntas = getPreguntas();
        int result9 = (result8 * 59) + ($preguntas == null ? 43 : $preguntas.hashCode());
        Object $firma = getFirma();
        int result10 = (result9 * 59) + ($firma == null ? 43 : $firma.hashCode());
        Object $huella = getHuella();
        return (result10 * 59) + ($huella == null ? 43 : $huella.hashCode());
    }

    @Generated
    public String toString() {
        return "EncuestaRegistroUsuario(id=" + getId() + ", idPersona=" + getIdPersona() + ", fechaOrden=" + getFechaOrden() + ", nombreSede=" + getNombreSede() + ", usuarioSistema=" + getUsuarioSistema() + ", cargo=" + getCargo() + ", preguntas=" + getPreguntas() + ", idIngreso=" + getIdIngreso() + ", firma=" + getFirma() + ", huella=" + getHuella() + ", estado=" + getEstado() + ")";
    }

    @Generated
    public EncuestaRegistroUsuario() {
    }

    @Generated
    public EncuestaRegistroUsuario(Long id, Long idPersona, LocalDateTime fechaOrden, String nombreSede, String usuarioSistema, String cargo, List<DetalleCuestionarioDto> preguntas, Long idIngreso, String firma, String huella, Boolean estado) {
        this.id = id;
        this.idPersona = idPersona;
        this.fechaOrden = fechaOrden;
        this.nombreSede = nombreSede;
        this.usuarioSistema = usuarioSistema;
        this.cargo = cargo;
        this.preguntas = preguntas;
        this.idIngreso = idIngreso;
        this.firma = firma;
        this.huella = huella;
        this.estado = estado;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdPersona() {
        return this.idPersona;
    }

    @Generated
    public LocalDateTime getFechaOrden() {
        return this.fechaOrden;
    }

    @Generated
    public String getNombreSede() {
        return this.nombreSede;
    }

    @Generated
    public String getUsuarioSistema() {
        return this.usuarioSistema;
    }

    @Generated
    public String getCargo() {
        return this.cargo;
    }

    @Generated
    public List<DetalleCuestionarioDto> getPreguntas() {
        return this.preguntas;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public String getFirma() {
        return this.firma;
    }

    @Generated
    public String getHuella() {
        return this.huella;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }
}
