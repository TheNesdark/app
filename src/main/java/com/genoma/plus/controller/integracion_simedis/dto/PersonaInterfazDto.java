package com.genoma.plus.controller.integracion_simedis.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/PersonaInterfazDto.class */
public class PersonaInterfazDto {
    private String idTipoIdentificacion;
    private String noDocumento;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String idSexo;
    private String fechaNac;
    private String horaNac;
    private String edad;
    private String idTipoEdad;
    private String idMunicipio;
    private String idBarrio;
    private String direccion;
    private String telefono;
    private String movil;
    private String idPrincipal;

    @Generated
    public void setIdTipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    @Generated
    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    @Generated
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    @Generated
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    @Generated
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @Generated
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Generated
    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    @Generated
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Generated
    public void setHoraNac(String horaNac) {
        this.horaNac = horaNac;
    }

    @Generated
    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Generated
    public void setIdTipoEdad(String idTipoEdad) {
        this.idTipoEdad = idTipoEdad;
    }

    @Generated
    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Generated
    public void setIdBarrio(String idBarrio) {
        this.idBarrio = idBarrio;
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
    public void setMovil(String movil) {
        this.movil = movil;
    }

    @Generated
    public void setIdPrincipal(String idPrincipal) {
        this.idPrincipal = idPrincipal;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PersonaInterfazDto)) {
            return false;
        }
        PersonaInterfazDto other = (PersonaInterfazDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idTipoIdentificacion = getIdTipoIdentificacion();
        Object other$idTipoIdentificacion = other.getIdTipoIdentificacion();
        if (this$idTipoIdentificacion == null) {
            if (other$idTipoIdentificacion != null) {
                return false;
            }
        } else if (!this$idTipoIdentificacion.equals(other$idTipoIdentificacion)) {
            return false;
        }
        Object this$noDocumento = getNoDocumento();
        Object other$noDocumento = other.getNoDocumento();
        if (this$noDocumento == null) {
            if (other$noDocumento != null) {
                return false;
            }
        } else if (!this$noDocumento.equals(other$noDocumento)) {
            return false;
        }
        Object this$nombre1 = getNombre1();
        Object other$nombre1 = other.getNombre1();
        if (this$nombre1 == null) {
            if (other$nombre1 != null) {
                return false;
            }
        } else if (!this$nombre1.equals(other$nombre1)) {
            return false;
        }
        Object this$nombre2 = getNombre2();
        Object other$nombre2 = other.getNombre2();
        if (this$nombre2 == null) {
            if (other$nombre2 != null) {
                return false;
            }
        } else if (!this$nombre2.equals(other$nombre2)) {
            return false;
        }
        Object this$apellido1 = getApellido1();
        Object other$apellido1 = other.getApellido1();
        if (this$apellido1 == null) {
            if (other$apellido1 != null) {
                return false;
            }
        } else if (!this$apellido1.equals(other$apellido1)) {
            return false;
        }
        Object this$apellido2 = getApellido2();
        Object other$apellido2 = other.getApellido2();
        if (this$apellido2 == null) {
            if (other$apellido2 != null) {
                return false;
            }
        } else if (!this$apellido2.equals(other$apellido2)) {
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
        Object this$fechaNac = getFechaNac();
        Object other$fechaNac = other.getFechaNac();
        if (this$fechaNac == null) {
            if (other$fechaNac != null) {
                return false;
            }
        } else if (!this$fechaNac.equals(other$fechaNac)) {
            return false;
        }
        Object this$horaNac = getHoraNac();
        Object other$horaNac = other.getHoraNac();
        if (this$horaNac == null) {
            if (other$horaNac != null) {
                return false;
            }
        } else if (!this$horaNac.equals(other$horaNac)) {
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
        Object this$idTipoEdad = getIdTipoEdad();
        Object other$idTipoEdad = other.getIdTipoEdad();
        if (this$idTipoEdad == null) {
            if (other$idTipoEdad != null) {
                return false;
            }
        } else if (!this$idTipoEdad.equals(other$idTipoEdad)) {
            return false;
        }
        Object this$idMunicipio = getIdMunicipio();
        Object other$idMunicipio = other.getIdMunicipio();
        if (this$idMunicipio == null) {
            if (other$idMunicipio != null) {
                return false;
            }
        } else if (!this$idMunicipio.equals(other$idMunicipio)) {
            return false;
        }
        Object this$idBarrio = getIdBarrio();
        Object other$idBarrio = other.getIdBarrio();
        if (this$idBarrio == null) {
            if (other$idBarrio != null) {
                return false;
            }
        } else if (!this$idBarrio.equals(other$idBarrio)) {
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
        Object this$movil = getMovil();
        Object other$movil = other.getMovil();
        if (this$movil == null) {
            if (other$movil != null) {
                return false;
            }
        } else if (!this$movil.equals(other$movil)) {
            return false;
        }
        Object this$idPrincipal = getIdPrincipal();
        Object other$idPrincipal = other.getIdPrincipal();
        return this$idPrincipal == null ? other$idPrincipal == null : this$idPrincipal.equals(other$idPrincipal);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PersonaInterfazDto;
    }

    @Generated
    public int hashCode() {
        Object $idTipoIdentificacion = getIdTipoIdentificacion();
        int result = (1 * 59) + ($idTipoIdentificacion == null ? 43 : $idTipoIdentificacion.hashCode());
        Object $noDocumento = getNoDocumento();
        int result2 = (result * 59) + ($noDocumento == null ? 43 : $noDocumento.hashCode());
        Object $nombre1 = getNombre1();
        int result3 = (result2 * 59) + ($nombre1 == null ? 43 : $nombre1.hashCode());
        Object $nombre2 = getNombre2();
        int result4 = (result3 * 59) + ($nombre2 == null ? 43 : $nombre2.hashCode());
        Object $apellido1 = getApellido1();
        int result5 = (result4 * 59) + ($apellido1 == null ? 43 : $apellido1.hashCode());
        Object $apellido2 = getApellido2();
        int result6 = (result5 * 59) + ($apellido2 == null ? 43 : $apellido2.hashCode());
        Object $idSexo = getIdSexo();
        int result7 = (result6 * 59) + ($idSexo == null ? 43 : $idSexo.hashCode());
        Object $fechaNac = getFechaNac();
        int result8 = (result7 * 59) + ($fechaNac == null ? 43 : $fechaNac.hashCode());
        Object $horaNac = getHoraNac();
        int result9 = (result8 * 59) + ($horaNac == null ? 43 : $horaNac.hashCode());
        Object $edad = getEdad();
        int result10 = (result9 * 59) + ($edad == null ? 43 : $edad.hashCode());
        Object $idTipoEdad = getIdTipoEdad();
        int result11 = (result10 * 59) + ($idTipoEdad == null ? 43 : $idTipoEdad.hashCode());
        Object $idMunicipio = getIdMunicipio();
        int result12 = (result11 * 59) + ($idMunicipio == null ? 43 : $idMunicipio.hashCode());
        Object $idBarrio = getIdBarrio();
        int result13 = (result12 * 59) + ($idBarrio == null ? 43 : $idBarrio.hashCode());
        Object $direccion = getDireccion();
        int result14 = (result13 * 59) + ($direccion == null ? 43 : $direccion.hashCode());
        Object $telefono = getTelefono();
        int result15 = (result14 * 59) + ($telefono == null ? 43 : $telefono.hashCode());
        Object $movil = getMovil();
        int result16 = (result15 * 59) + ($movil == null ? 43 : $movil.hashCode());
        Object $idPrincipal = getIdPrincipal();
        return (result16 * 59) + ($idPrincipal == null ? 43 : $idPrincipal.hashCode());
    }

    @Generated
    public String toString() {
        return "PersonaInterfazDto(idTipoIdentificacion=" + getIdTipoIdentificacion() + ", noDocumento=" + getNoDocumento() + ", nombre1=" + getNombre1() + ", nombre2=" + getNombre2() + ", apellido1=" + getApellido1() + ", apellido2=" + getApellido2() + ", idSexo=" + getIdSexo() + ", fechaNac=" + getFechaNac() + ", horaNac=" + getHoraNac() + ", edad=" + getEdad() + ", idTipoEdad=" + getIdTipoEdad() + ", idMunicipio=" + getIdMunicipio() + ", idBarrio=" + getIdBarrio() + ", direccion=" + getDireccion() + ", telefono=" + getTelefono() + ", movil=" + getMovil() + ", idPrincipal=" + getIdPrincipal() + ")";
    }

    @Generated
    public PersonaInterfazDto(String idTipoIdentificacion, String noDocumento, String nombre1, String nombre2, String apellido1, String apellido2, String idSexo, String fechaNac, String horaNac, String edad, String idTipoEdad, String idMunicipio, String idBarrio, String direccion, String telefono, String movil, String idPrincipal) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.noDocumento = noDocumento;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.idSexo = idSexo;
        this.fechaNac = fechaNac;
        this.horaNac = horaNac;
        this.edad = edad;
        this.idTipoEdad = idTipoEdad;
        this.idMunicipio = idMunicipio;
        this.idBarrio = idBarrio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.idPrincipal = idPrincipal;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/PersonaInterfazDto$PersonaInterfazDtoBuilder.class */
    @Generated
    public static class PersonaInterfazDtoBuilder {

        @Generated
        private String idTipoIdentificacion;

        @Generated
        private String noDocumento;

        @Generated
        private String nombre1;

        @Generated
        private String nombre2;

        @Generated
        private String apellido1;

        @Generated
        private String apellido2;

        @Generated
        private String idSexo;

        @Generated
        private String fechaNac;

        @Generated
        private String horaNac;

        @Generated
        private String edad;

        @Generated
        private String idTipoEdad;

        @Generated
        private String idMunicipio;

        @Generated
        private String idBarrio;

        @Generated
        private String direccion;

        @Generated
        private String telefono;

        @Generated
        private String movil;

        @Generated
        private String idPrincipal;

        @Generated
        PersonaInterfazDtoBuilder() {
        }

        @Generated
        public PersonaInterfazDtoBuilder idTipoIdentificacion(String idTipoIdentificacion) {
            this.idTipoIdentificacion = idTipoIdentificacion;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder noDocumento(String noDocumento) {
            this.noDocumento = noDocumento;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder nombre1(String nombre1) {
            this.nombre1 = nombre1;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder nombre2(String nombre2) {
            this.nombre2 = nombre2;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder apellido1(String apellido1) {
            this.apellido1 = apellido1;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder apellido2(String apellido2) {
            this.apellido2 = apellido2;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder idSexo(String idSexo) {
            this.idSexo = idSexo;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder fechaNac(String fechaNac) {
            this.fechaNac = fechaNac;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder horaNac(String horaNac) {
            this.horaNac = horaNac;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder edad(String edad) {
            this.edad = edad;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder idTipoEdad(String idTipoEdad) {
            this.idTipoEdad = idTipoEdad;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder idMunicipio(String idMunicipio) {
            this.idMunicipio = idMunicipio;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder idBarrio(String idBarrio) {
            this.idBarrio = idBarrio;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder movil(String movil) {
            this.movil = movil;
            return this;
        }

        @Generated
        public PersonaInterfazDtoBuilder idPrincipal(String idPrincipal) {
            this.idPrincipal = idPrincipal;
            return this;
        }

        @Generated
        public PersonaInterfazDto build() {
            return new PersonaInterfazDto(this.idTipoIdentificacion, this.noDocumento, this.nombre1, this.nombre2, this.apellido1, this.apellido2, this.idSexo, this.fechaNac, this.horaNac, this.edad, this.idTipoEdad, this.idMunicipio, this.idBarrio, this.direccion, this.telefono, this.movil, this.idPrincipal);
        }

        @Generated
        public String toString() {
            return "PersonaInterfazDto.PersonaInterfazDtoBuilder(idTipoIdentificacion=" + this.idTipoIdentificacion + ", noDocumento=" + this.noDocumento + ", nombre1=" + this.nombre1 + ", nombre2=" + this.nombre2 + ", apellido1=" + this.apellido1 + ", apellido2=" + this.apellido2 + ", idSexo=" + this.idSexo + ", fechaNac=" + this.fechaNac + ", horaNac=" + this.horaNac + ", edad=" + this.edad + ", idTipoEdad=" + this.idTipoEdad + ", idMunicipio=" + this.idMunicipio + ", idBarrio=" + this.idBarrio + ", direccion=" + this.direccion + ", telefono=" + this.telefono + ", movil=" + this.movil + ", idPrincipal=" + this.idPrincipal + ")";
        }
    }

    @Generated
    public PersonaInterfazDto() {
    }

    @Generated
    public static PersonaInterfazDtoBuilder builder() {
        return new PersonaInterfazDtoBuilder();
    }

    @Generated
    public String getIdTipoIdentificacion() {
        return this.idTipoIdentificacion;
    }

    @Generated
    public String getNoDocumento() {
        return this.noDocumento;
    }

    @Generated
    public String getNombre1() {
        return this.nombre1;
    }

    @Generated
    public String getNombre2() {
        return this.nombre2;
    }

    @Generated
    public String getApellido1() {
        return this.apellido1;
    }

    @Generated
    public String getApellido2() {
        return this.apellido2;
    }

    @Generated
    public String getIdSexo() {
        return this.idSexo;
    }

    @Generated
    public String getFechaNac() {
        return this.fechaNac;
    }

    @Generated
    public String getHoraNac() {
        return this.horaNac;
    }

    @Generated
    public String getEdad() {
        return this.edad;
    }

    @Generated
    public String getIdTipoEdad() {
        return this.idTipoEdad;
    }

    @Generated
    public String getIdMunicipio() {
        return this.idMunicipio;
    }

    @Generated
    public String getIdBarrio() {
        return this.idBarrio;
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
    public String getMovil() {
        return this.movil;
    }

    @Generated
    public String getIdPrincipal() {
        return this.idPrincipal;
    }
}
