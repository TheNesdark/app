package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/AnexoDatoUsuarioDto.class */
public class AnexoDatoUsuarioDto {
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String municipio;
    private String correo;
    private String direccionAlternativa;
    private String nombreContactoEmergencia;
    private String telefonoContactoEmergencia;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AnexoDatoUsuarioDto)) {
            return false;
        }
        AnexoDatoUsuarioDto other = (AnexoDatoUsuarioDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$primerApellido = getPrimerApellido();
        Object other$primerApellido = other.getPrimerApellido();
        if (this$primerApellido == null) {
            if (other$primerApellido != null) {
                return false;
            }
        } else if (!this$primerApellido.equals(other$primerApellido)) {
            return false;
        }
        Object this$segundoApellido = getSegundoApellido();
        Object other$segundoApellido = other.getSegundoApellido();
        if (this$segundoApellido == null) {
            if (other$segundoApellido != null) {
                return false;
            }
        } else if (!this$segundoApellido.equals(other$segundoApellido)) {
            return false;
        }
        Object this$primerNombre = getPrimerNombre();
        Object other$primerNombre = other.getPrimerNombre();
        if (this$primerNombre == null) {
            if (other$primerNombre != null) {
                return false;
            }
        } else if (!this$primerNombre.equals(other$primerNombre)) {
            return false;
        }
        Object this$segundoNombre = getSegundoNombre();
        Object other$segundoNombre = other.getSegundoNombre();
        if (this$segundoNombre == null) {
            if (other$segundoNombre != null) {
                return false;
            }
        } else if (!this$segundoNombre.equals(other$segundoNombre)) {
            return false;
        }
        Object this$tipoDocumento = getTipoDocumento();
        Object other$tipoDocumento = other.getTipoDocumento();
        if (this$tipoDocumento == null) {
            if (other$tipoDocumento != null) {
                return false;
            }
        } else if (!this$tipoDocumento.equals(other$tipoDocumento)) {
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
        Object this$fechaNacimiento = getFechaNacimiento();
        Object other$fechaNacimiento = other.getFechaNacimiento();
        if (this$fechaNacimiento == null) {
            if (other$fechaNacimiento != null) {
                return false;
            }
        } else if (!this$fechaNacimiento.equals(other$fechaNacimiento)) {
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
        Object this$municipio = getMunicipio();
        Object other$municipio = other.getMunicipio();
        if (this$municipio == null) {
            if (other$municipio != null) {
                return false;
            }
        } else if (!this$municipio.equals(other$municipio)) {
            return false;
        }
        Object this$correo = getCorreo();
        Object other$correo = other.getCorreo();
        if (this$correo == null) {
            if (other$correo != null) {
                return false;
            }
        } else if (!this$correo.equals(other$correo)) {
            return false;
        }
        Object this$direccionAlternativa = getDireccionAlternativa();
        Object other$direccionAlternativa = other.getDireccionAlternativa();
        if (this$direccionAlternativa == null) {
            if (other$direccionAlternativa != null) {
                return false;
            }
        } else if (!this$direccionAlternativa.equals(other$direccionAlternativa)) {
            return false;
        }
        Object this$nombreContactoEmergencia = getNombreContactoEmergencia();
        Object other$nombreContactoEmergencia = other.getNombreContactoEmergencia();
        if (this$nombreContactoEmergencia == null) {
            if (other$nombreContactoEmergencia != null) {
                return false;
            }
        } else if (!this$nombreContactoEmergencia.equals(other$nombreContactoEmergencia)) {
            return false;
        }
        Object this$telefonoContactoEmergencia = getTelefonoContactoEmergencia();
        Object other$telefonoContactoEmergencia = other.getTelefonoContactoEmergencia();
        return this$telefonoContactoEmergencia == null ? other$telefonoContactoEmergencia == null : this$telefonoContactoEmergencia.equals(other$telefonoContactoEmergencia);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AnexoDatoUsuarioDto;
    }

    @Generated
    public int hashCode() {
        Object $primerApellido = getPrimerApellido();
        int result = (1 * 59) + ($primerApellido == null ? 43 : $primerApellido.hashCode());
        Object $segundoApellido = getSegundoApellido();
        int result2 = (result * 59) + ($segundoApellido == null ? 43 : $segundoApellido.hashCode());
        Object $primerNombre = getPrimerNombre();
        int result3 = (result2 * 59) + ($primerNombre == null ? 43 : $primerNombre.hashCode());
        Object $segundoNombre = getSegundoNombre();
        int result4 = (result3 * 59) + ($segundoNombre == null ? 43 : $segundoNombre.hashCode());
        Object $tipoDocumento = getTipoDocumento();
        int result5 = (result4 * 59) + ($tipoDocumento == null ? 43 : $tipoDocumento.hashCode());
        Object $numeroDocumento = getNumeroDocumento();
        int result6 = (result5 * 59) + ($numeroDocumento == null ? 43 : $numeroDocumento.hashCode());
        Object $fechaNacimiento = getFechaNacimiento();
        int result7 = (result6 * 59) + ($fechaNacimiento == null ? 43 : $fechaNacimiento.hashCode());
        Object $direccion = getDireccion();
        int result8 = (result7 * 59) + ($direccion == null ? 43 : $direccion.hashCode());
        Object $telefono = getTelefono();
        int result9 = (result8 * 59) + ($telefono == null ? 43 : $telefono.hashCode());
        Object $municipio = getMunicipio();
        int result10 = (result9 * 59) + ($municipio == null ? 43 : $municipio.hashCode());
        Object $correo = getCorreo();
        int result11 = (result10 * 59) + ($correo == null ? 43 : $correo.hashCode());
        Object $direccionAlternativa = getDireccionAlternativa();
        int result12 = (result11 * 59) + ($direccionAlternativa == null ? 43 : $direccionAlternativa.hashCode());
        Object $nombreContactoEmergencia = getNombreContactoEmergencia();
        int result13 = (result12 * 59) + ($nombreContactoEmergencia == null ? 43 : $nombreContactoEmergencia.hashCode());
        Object $telefonoContactoEmergencia = getTelefonoContactoEmergencia();
        return (result13 * 59) + ($telefonoContactoEmergencia == null ? 43 : $telefonoContactoEmergencia.hashCode());
    }

    @Generated
    public String toString() {
        return "AnexoDatoUsuarioDto(primerApellido=" + getPrimerApellido() + ", segundoApellido=" + getSegundoApellido() + ", primerNombre=" + getPrimerNombre() + ", segundoNombre=" + getSegundoNombre() + ", tipoDocumento=" + getTipoDocumento() + ", numeroDocumento=" + getNumeroDocumento() + ", fechaNacimiento=" + getFechaNacimiento() + ", direccion=" + getDireccion() + ", telefono=" + getTelefono() + ", municipio=" + getMunicipio() + ", correo=" + getCorreo() + ", direccionAlternativa=" + getDireccionAlternativa() + ", nombreContactoEmergencia=" + getNombreContactoEmergencia() + ", telefonoContactoEmergencia=" + getTelefonoContactoEmergencia() + ")";
    }

    @Generated
    public AnexoDatoUsuarioDto(String primerApellido, String segundoApellido, String primerNombre, String segundoNombre, String tipoDocumento, String numeroDocumento, String fechaNacimiento, String direccion, String telefono, String municipio, String correo, String direccionAlternativa, String nombreContactoEmergencia, String telefonoContactoEmergencia) {
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.municipio = municipio;
        this.correo = correo;
        this.direccionAlternativa = direccionAlternativa;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/AnexoDatoUsuarioDto$AnexoDatoUsuarioDtoBuilder.class */
    @Generated
    public static class AnexoDatoUsuarioDtoBuilder {

        @Generated
        private String primerApellido;

        @Generated
        private String segundoApellido;

        @Generated
        private String primerNombre;

        @Generated
        private String segundoNombre;

        @Generated
        private String tipoDocumento;

        @Generated
        private String numeroDocumento;

        @Generated
        private String fechaNacimiento;

        @Generated
        private String direccion;

        @Generated
        private String telefono;

        @Generated
        private String municipio;

        @Generated
        private String correo;

        @Generated
        private String direccionAlternativa;

        @Generated
        private String nombreContactoEmergencia;

        @Generated
        private String telefonoContactoEmergencia;

        @Generated
        AnexoDatoUsuarioDtoBuilder() {
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder primerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder segundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder primerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder segundoNombre(String segundoNombre) {
            this.segundoNombre = segundoNombre;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder tipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder numeroDocumento(String numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder fechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder municipio(String municipio) {
            this.municipio = municipio;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder correo(String correo) {
            this.correo = correo;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder direccionAlternativa(String direccionAlternativa) {
            this.direccionAlternativa = direccionAlternativa;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder nombreContactoEmergencia(String nombreContactoEmergencia) {
            this.nombreContactoEmergencia = nombreContactoEmergencia;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDtoBuilder telefonoContactoEmergencia(String telefonoContactoEmergencia) {
            this.telefonoContactoEmergencia = telefonoContactoEmergencia;
            return this;
        }

        @Generated
        public AnexoDatoUsuarioDto build() {
            return new AnexoDatoUsuarioDto(this.primerApellido, this.segundoApellido, this.primerNombre, this.segundoNombre, this.tipoDocumento, this.numeroDocumento, this.fechaNacimiento, this.direccion, this.telefono, this.municipio, this.correo, this.direccionAlternativa, this.nombreContactoEmergencia, this.telefonoContactoEmergencia);
        }

        @Generated
        public String toString() {
            return "AnexoDatoUsuarioDto.AnexoDatoUsuarioDtoBuilder(primerApellido=" + this.primerApellido + ", segundoApellido=" + this.segundoApellido + ", primerNombre=" + this.primerNombre + ", segundoNombre=" + this.segundoNombre + ", tipoDocumento=" + this.tipoDocumento + ", numeroDocumento=" + this.numeroDocumento + ", fechaNacimiento=" + this.fechaNacimiento + ", direccion=" + this.direccion + ", telefono=" + this.telefono + ", municipio=" + this.municipio + ", correo=" + this.correo + ", direccionAlternativa=" + this.direccionAlternativa + ", nombreContactoEmergencia=" + this.nombreContactoEmergencia + ", telefonoContactoEmergencia=" + this.telefonoContactoEmergencia + ")";
        }
    }

    @Generated
    public AnexoDatoUsuarioDto() {
    }

    @Generated
    public static AnexoDatoUsuarioDtoBuilder builder() {
        return new AnexoDatoUsuarioDtoBuilder();
    }

    @Generated
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Generated
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Generated
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Generated
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Generated
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Generated
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Generated
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Generated
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Generated
    public void setDireccionAlternativa(String direccionAlternativa) {
        this.direccionAlternativa = direccionAlternativa;
    }

    @Generated
    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    @Generated
    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    @Generated
    public String getPrimerApellido() {
        return this.primerApellido;
    }

    @Generated
    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    @Generated
    public String getPrimerNombre() {
        return this.primerNombre;
    }

    @Generated
    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    @Generated
    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    @Generated
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    @Generated
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
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
    public String getMunicipio() {
        return this.municipio;
    }

    @Generated
    public String getCorreo() {
        return this.correo;
    }

    @Generated
    public String getDireccionAlternativa() {
        return this.direccionAlternativa;
    }

    @Generated
    public String getNombreContactoEmergencia() {
        return this.nombreContactoEmergencia;
    }

    @Generated
    public String getTelefonoContactoEmergencia() {
        return this.telefonoContactoEmergencia;
    }
}
