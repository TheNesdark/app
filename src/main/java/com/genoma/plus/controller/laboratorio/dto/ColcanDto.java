package com.genoma.plus.controller.laboratorio.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanDto.class */
public class ColcanDto {
    private String Token;
    private String Cliente;
    private String IdPresolicitud;
    private String FechaPresolicitud;
    private Integer TipoDocumento;
    private String Documento;
    private String FechaNacimiento;
    private Integer Sexo;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String DatosClinicos;
    private String CodigoIps;
    private String AuxiliarPresolicitud;
    private String Sede;
    private List<PreprocedureDetailDto> Detalle;

    @Generated
    public void setToken(String Token) {
        this.Token = Token;
    }

    @Generated
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    @Generated
    public void setIdPresolicitud(String IdPresolicitud) {
        this.IdPresolicitud = IdPresolicitud;
    }

    @Generated
    public void setFechaPresolicitud(String FechaPresolicitud) {
        this.FechaPresolicitud = FechaPresolicitud;
    }

    @Generated
    public void setTipoDocumento(Integer TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    @Generated
    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    @Generated
    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    @Generated
    public void setSexo(Integer Sexo) {
        this.Sexo = Sexo;
    }

    @Generated
    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    @Generated
    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    @Generated
    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    @Generated
    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    @Generated
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Generated
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Generated
    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Generated
    public void setDatosClinicos(String DatosClinicos) {
        this.DatosClinicos = DatosClinicos;
    }

    @Generated
    public void setCodigoIps(String CodigoIps) {
        this.CodigoIps = CodigoIps;
    }

    @Generated
    public void setAuxiliarPresolicitud(String AuxiliarPresolicitud) {
        this.AuxiliarPresolicitud = AuxiliarPresolicitud;
    }

    @Generated
    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    @Generated
    public void setDetalle(List<PreprocedureDetailDto> Detalle) {
        this.Detalle = Detalle;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColcanDto)) {
            return false;
        }
        ColcanDto other = (ColcanDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$TipoDocumento = getTipoDocumento();
        Object other$TipoDocumento = other.getTipoDocumento();
        if (this$TipoDocumento == null) {
            if (other$TipoDocumento != null) {
                return false;
            }
        } else if (!this$TipoDocumento.equals(other$TipoDocumento)) {
            return false;
        }
        Object this$Sexo = getSexo();
        Object other$Sexo = other.getSexo();
        if (this$Sexo == null) {
            if (other$Sexo != null) {
                return false;
            }
        } else if (!this$Sexo.equals(other$Sexo)) {
            return false;
        }
        Object this$Token = getToken();
        Object other$Token = other.getToken();
        if (this$Token == null) {
            if (other$Token != null) {
                return false;
            }
        } else if (!this$Token.equals(other$Token)) {
            return false;
        }
        Object this$Cliente = getCliente();
        Object other$Cliente = other.getCliente();
        if (this$Cliente == null) {
            if (other$Cliente != null) {
                return false;
            }
        } else if (!this$Cliente.equals(other$Cliente)) {
            return false;
        }
        Object this$IdPresolicitud = getIdPresolicitud();
        Object other$IdPresolicitud = other.getIdPresolicitud();
        if (this$IdPresolicitud == null) {
            if (other$IdPresolicitud != null) {
                return false;
            }
        } else if (!this$IdPresolicitud.equals(other$IdPresolicitud)) {
            return false;
        }
        Object this$FechaPresolicitud = getFechaPresolicitud();
        Object other$FechaPresolicitud = other.getFechaPresolicitud();
        if (this$FechaPresolicitud == null) {
            if (other$FechaPresolicitud != null) {
                return false;
            }
        } else if (!this$FechaPresolicitud.equals(other$FechaPresolicitud)) {
            return false;
        }
        Object this$Documento = getDocumento();
        Object other$Documento = other.getDocumento();
        if (this$Documento == null) {
            if (other$Documento != null) {
                return false;
            }
        } else if (!this$Documento.equals(other$Documento)) {
            return false;
        }
        Object this$FechaNacimiento = getFechaNacimiento();
        Object other$FechaNacimiento = other.getFechaNacimiento();
        if (this$FechaNacimiento == null) {
            if (other$FechaNacimiento != null) {
                return false;
            }
        } else if (!this$FechaNacimiento.equals(other$FechaNacimiento)) {
            return false;
        }
        Object this$PrimerNombre = getPrimerNombre();
        Object other$PrimerNombre = other.getPrimerNombre();
        if (this$PrimerNombre == null) {
            if (other$PrimerNombre != null) {
                return false;
            }
        } else if (!this$PrimerNombre.equals(other$PrimerNombre)) {
            return false;
        }
        Object this$SegundoNombre = getSegundoNombre();
        Object other$SegundoNombre = other.getSegundoNombre();
        if (this$SegundoNombre == null) {
            if (other$SegundoNombre != null) {
                return false;
            }
        } else if (!this$SegundoNombre.equals(other$SegundoNombre)) {
            return false;
        }
        Object this$PrimerApellido = getPrimerApellido();
        Object other$PrimerApellido = other.getPrimerApellido();
        if (this$PrimerApellido == null) {
            if (other$PrimerApellido != null) {
                return false;
            }
        } else if (!this$PrimerApellido.equals(other$PrimerApellido)) {
            return false;
        }
        Object this$SegundoApellido = getSegundoApellido();
        Object other$SegundoApellido = other.getSegundoApellido();
        if (this$SegundoApellido == null) {
            if (other$SegundoApellido != null) {
                return false;
            }
        } else if (!this$SegundoApellido.equals(other$SegundoApellido)) {
            return false;
        }
        Object this$Direccion = getDireccion();
        Object other$Direccion = other.getDireccion();
        if (this$Direccion == null) {
            if (other$Direccion != null) {
                return false;
            }
        } else if (!this$Direccion.equals(other$Direccion)) {
            return false;
        }
        Object this$Telefono = getTelefono();
        Object other$Telefono = other.getTelefono();
        if (this$Telefono == null) {
            if (other$Telefono != null) {
                return false;
            }
        } else if (!this$Telefono.equals(other$Telefono)) {
            return false;
        }
        Object this$Email = getEmail();
        Object other$Email = other.getEmail();
        if (this$Email == null) {
            if (other$Email != null) {
                return false;
            }
        } else if (!this$Email.equals(other$Email)) {
            return false;
        }
        Object this$DatosClinicos = getDatosClinicos();
        Object other$DatosClinicos = other.getDatosClinicos();
        if (this$DatosClinicos == null) {
            if (other$DatosClinicos != null) {
                return false;
            }
        } else if (!this$DatosClinicos.equals(other$DatosClinicos)) {
            return false;
        }
        Object this$CodigoIps = getCodigoIps();
        Object other$CodigoIps = other.getCodigoIps();
        if (this$CodigoIps == null) {
            if (other$CodigoIps != null) {
                return false;
            }
        } else if (!this$CodigoIps.equals(other$CodigoIps)) {
            return false;
        }
        Object this$AuxiliarPresolicitud = getAuxiliarPresolicitud();
        Object other$AuxiliarPresolicitud = other.getAuxiliarPresolicitud();
        if (this$AuxiliarPresolicitud == null) {
            if (other$AuxiliarPresolicitud != null) {
                return false;
            }
        } else if (!this$AuxiliarPresolicitud.equals(other$AuxiliarPresolicitud)) {
            return false;
        }
        Object this$Sede = getSede();
        Object other$Sede = other.getSede();
        if (this$Sede == null) {
            if (other$Sede != null) {
                return false;
            }
        } else if (!this$Sede.equals(other$Sede)) {
            return false;
        }
        Object this$Detalle = getDetalle();
        Object other$Detalle = other.getDetalle();
        return this$Detalle == null ? other$Detalle == null : this$Detalle.equals(other$Detalle);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ColcanDto;
    }

    @Generated
    public int hashCode() {
        Object $TipoDocumento = getTipoDocumento();
        int result = (1 * 59) + ($TipoDocumento == null ? 43 : $TipoDocumento.hashCode());
        Object $Sexo = getSexo();
        int result2 = (result * 59) + ($Sexo == null ? 43 : $Sexo.hashCode());
        Object $Token = getToken();
        int result3 = (result2 * 59) + ($Token == null ? 43 : $Token.hashCode());
        Object $Cliente = getCliente();
        int result4 = (result3 * 59) + ($Cliente == null ? 43 : $Cliente.hashCode());
        Object $IdPresolicitud = getIdPresolicitud();
        int result5 = (result4 * 59) + ($IdPresolicitud == null ? 43 : $IdPresolicitud.hashCode());
        Object $FechaPresolicitud = getFechaPresolicitud();
        int result6 = (result5 * 59) + ($FechaPresolicitud == null ? 43 : $FechaPresolicitud.hashCode());
        Object $Documento = getDocumento();
        int result7 = (result6 * 59) + ($Documento == null ? 43 : $Documento.hashCode());
        Object $FechaNacimiento = getFechaNacimiento();
        int result8 = (result7 * 59) + ($FechaNacimiento == null ? 43 : $FechaNacimiento.hashCode());
        Object $PrimerNombre = getPrimerNombre();
        int result9 = (result8 * 59) + ($PrimerNombre == null ? 43 : $PrimerNombre.hashCode());
        Object $SegundoNombre = getSegundoNombre();
        int result10 = (result9 * 59) + ($SegundoNombre == null ? 43 : $SegundoNombre.hashCode());
        Object $PrimerApellido = getPrimerApellido();
        int result11 = (result10 * 59) + ($PrimerApellido == null ? 43 : $PrimerApellido.hashCode());
        Object $SegundoApellido = getSegundoApellido();
        int result12 = (result11 * 59) + ($SegundoApellido == null ? 43 : $SegundoApellido.hashCode());
        Object $Direccion = getDireccion();
        int result13 = (result12 * 59) + ($Direccion == null ? 43 : $Direccion.hashCode());
        Object $Telefono = getTelefono();
        int result14 = (result13 * 59) + ($Telefono == null ? 43 : $Telefono.hashCode());
        Object $Email = getEmail();
        int result15 = (result14 * 59) + ($Email == null ? 43 : $Email.hashCode());
        Object $DatosClinicos = getDatosClinicos();
        int result16 = (result15 * 59) + ($DatosClinicos == null ? 43 : $DatosClinicos.hashCode());
        Object $CodigoIps = getCodigoIps();
        int result17 = (result16 * 59) + ($CodigoIps == null ? 43 : $CodigoIps.hashCode());
        Object $AuxiliarPresolicitud = getAuxiliarPresolicitud();
        int result18 = (result17 * 59) + ($AuxiliarPresolicitud == null ? 43 : $AuxiliarPresolicitud.hashCode());
        Object $Sede = getSede();
        int result19 = (result18 * 59) + ($Sede == null ? 43 : $Sede.hashCode());
        Object $Detalle = getDetalle();
        return (result19 * 59) + ($Detalle == null ? 43 : $Detalle.hashCode());
    }

    @Generated
    public String toString() {
        return "ColcanDto(Token=" + getToken() + ", Cliente=" + getCliente() + ", IdPresolicitud=" + getIdPresolicitud() + ", FechaPresolicitud=" + getFechaPresolicitud() + ", TipoDocumento=" + getTipoDocumento() + ", Documento=" + getDocumento() + ", FechaNacimiento=" + getFechaNacimiento() + ", Sexo=" + getSexo() + ", PrimerNombre=" + getPrimerNombre() + ", SegundoNombre=" + getSegundoNombre() + ", PrimerApellido=" + getPrimerApellido() + ", SegundoApellido=" + getSegundoApellido() + ", Direccion=" + getDireccion() + ", Telefono=" + getTelefono() + ", Email=" + getEmail() + ", DatosClinicos=" + getDatosClinicos() + ", CodigoIps=" + getCodigoIps() + ", AuxiliarPresolicitud=" + getAuxiliarPresolicitud() + ", Sede=" + getSede() + ", Detalle=" + getDetalle() + ")";
    }

    @Generated
    public ColcanDto(String Token, String Cliente, String IdPresolicitud, String FechaPresolicitud, Integer TipoDocumento, String Documento, String FechaNacimiento, Integer Sexo, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Direccion, String Telefono, String Email, String DatosClinicos, String CodigoIps, String AuxiliarPresolicitud, String Sede, List<PreprocedureDetailDto> Detalle) {
        this.Token = Token;
        this.Cliente = Cliente;
        this.IdPresolicitud = IdPresolicitud;
        this.FechaPresolicitud = FechaPresolicitud;
        this.TipoDocumento = TipoDocumento;
        this.Documento = Documento;
        this.FechaNacimiento = FechaNacimiento;
        this.Sexo = Sexo;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.DatosClinicos = DatosClinicos;
        this.CodigoIps = CodigoIps;
        this.AuxiliarPresolicitud = AuxiliarPresolicitud;
        this.Sede = Sede;
        this.Detalle = Detalle;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ColcanDto$ColcanDtoBuilder.class */
    @Generated
    public static class ColcanDtoBuilder {

        @Generated
        private String Token;

        @Generated
        private String Cliente;

        @Generated
        private String IdPresolicitud;

        @Generated
        private String FechaPresolicitud;

        @Generated
        private Integer TipoDocumento;

        @Generated
        private String Documento;

        @Generated
        private String FechaNacimiento;

        @Generated
        private Integer Sexo;

        @Generated
        private String PrimerNombre;

        @Generated
        private String SegundoNombre;

        @Generated
        private String PrimerApellido;

        @Generated
        private String SegundoApellido;

        @Generated
        private String Direccion;

        @Generated
        private String Telefono;

        @Generated
        private String Email;

        @Generated
        private String DatosClinicos;

        @Generated
        private String CodigoIps;

        @Generated
        private String AuxiliarPresolicitud;

        @Generated
        private String Sede;

        @Generated
        private List<PreprocedureDetailDto> Detalle;

        @Generated
        ColcanDtoBuilder() {
        }

        @Generated
        public ColcanDtoBuilder Token(String Token) {
            this.Token = Token;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Cliente(String Cliente) {
            this.Cliente = Cliente;
            return this;
        }

        @Generated
        public ColcanDtoBuilder IdPresolicitud(String IdPresolicitud) {
            this.IdPresolicitud = IdPresolicitud;
            return this;
        }

        @Generated
        public ColcanDtoBuilder FechaPresolicitud(String FechaPresolicitud) {
            this.FechaPresolicitud = FechaPresolicitud;
            return this;
        }

        @Generated
        public ColcanDtoBuilder TipoDocumento(Integer TipoDocumento) {
            this.TipoDocumento = TipoDocumento;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Documento(String Documento) {
            this.Documento = Documento;
            return this;
        }

        @Generated
        public ColcanDtoBuilder FechaNacimiento(String FechaNacimiento) {
            this.FechaNacimiento = FechaNacimiento;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Sexo(Integer Sexo) {
            this.Sexo = Sexo;
            return this;
        }

        @Generated
        public ColcanDtoBuilder PrimerNombre(String PrimerNombre) {
            this.PrimerNombre = PrimerNombre;
            return this;
        }

        @Generated
        public ColcanDtoBuilder SegundoNombre(String SegundoNombre) {
            this.SegundoNombre = SegundoNombre;
            return this;
        }

        @Generated
        public ColcanDtoBuilder PrimerApellido(String PrimerApellido) {
            this.PrimerApellido = PrimerApellido;
            return this;
        }

        @Generated
        public ColcanDtoBuilder SegundoApellido(String SegundoApellido) {
            this.SegundoApellido = SegundoApellido;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Direccion(String Direccion) {
            this.Direccion = Direccion;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Telefono(String Telefono) {
            this.Telefono = Telefono;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Email(String Email) {
            this.Email = Email;
            return this;
        }

        @Generated
        public ColcanDtoBuilder DatosClinicos(String DatosClinicos) {
            this.DatosClinicos = DatosClinicos;
            return this;
        }

        @Generated
        public ColcanDtoBuilder CodigoIps(String CodigoIps) {
            this.CodigoIps = CodigoIps;
            return this;
        }

        @Generated
        public ColcanDtoBuilder AuxiliarPresolicitud(String AuxiliarPresolicitud) {
            this.AuxiliarPresolicitud = AuxiliarPresolicitud;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Sede(String Sede) {
            this.Sede = Sede;
            return this;
        }

        @Generated
        public ColcanDtoBuilder Detalle(List<PreprocedureDetailDto> Detalle) {
            this.Detalle = Detalle;
            return this;
        }

        @Generated
        public ColcanDto build() {
            return new ColcanDto(this.Token, this.Cliente, this.IdPresolicitud, this.FechaPresolicitud, this.TipoDocumento, this.Documento, this.FechaNacimiento, this.Sexo, this.PrimerNombre, this.SegundoNombre, this.PrimerApellido, this.SegundoApellido, this.Direccion, this.Telefono, this.Email, this.DatosClinicos, this.CodigoIps, this.AuxiliarPresolicitud, this.Sede, this.Detalle);
        }

        @Generated
        public String toString() {
            return "ColcanDto.ColcanDtoBuilder(Token=" + this.Token + ", Cliente=" + this.Cliente + ", IdPresolicitud=" + this.IdPresolicitud + ", FechaPresolicitud=" + this.FechaPresolicitud + ", TipoDocumento=" + this.TipoDocumento + ", Documento=" + this.Documento + ", FechaNacimiento=" + this.FechaNacimiento + ", Sexo=" + this.Sexo + ", PrimerNombre=" + this.PrimerNombre + ", SegundoNombre=" + this.SegundoNombre + ", PrimerApellido=" + this.PrimerApellido + ", SegundoApellido=" + this.SegundoApellido + ", Direccion=" + this.Direccion + ", Telefono=" + this.Telefono + ", Email=" + this.Email + ", DatosClinicos=" + this.DatosClinicos + ", CodigoIps=" + this.CodigoIps + ", AuxiliarPresolicitud=" + this.AuxiliarPresolicitud + ", Sede=" + this.Sede + ", Detalle=" + this.Detalle + ")";
        }
    }

    @Generated
    public ColcanDto() {
    }

    @Generated
    public static ColcanDtoBuilder builder() {
        return new ColcanDtoBuilder();
    }

    @Generated
    public String getToken() {
        return this.Token;
    }

    @Generated
    public String getCliente() {
        return this.Cliente;
    }

    @Generated
    public String getIdPresolicitud() {
        return this.IdPresolicitud;
    }

    @Generated
    public String getFechaPresolicitud() {
        return this.FechaPresolicitud;
    }

    @Generated
    public Integer getTipoDocumento() {
        return this.TipoDocumento;
    }

    @Generated
    public String getDocumento() {
        return this.Documento;
    }

    @Generated
    public String getFechaNacimiento() {
        return this.FechaNacimiento;
    }

    @Generated
    public Integer getSexo() {
        return this.Sexo;
    }

    @Generated
    public String getPrimerNombre() {
        return this.PrimerNombre;
    }

    @Generated
    public String getSegundoNombre() {
        return this.SegundoNombre;
    }

    @Generated
    public String getPrimerApellido() {
        return this.PrimerApellido;
    }

    @Generated
    public String getSegundoApellido() {
        return this.SegundoApellido;
    }

    @Generated
    public String getDireccion() {
        return this.Direccion;
    }

    @Generated
    public String getTelefono() {
        return this.Telefono;
    }

    @Generated
    public String getEmail() {
        return this.Email;
    }

    @Generated
    public String getDatosClinicos() {
        return this.DatosClinicos;
    }

    @Generated
    public String getCodigoIps() {
        return this.CodigoIps;
    }

    @Generated
    public String getAuxiliarPresolicitud() {
        return this.AuxiliarPresolicitud;
    }

    @Generated
    public String getSede() {
        return this.Sede;
    }

    @Generated
    public List<PreprocedureDetailDto> getDetalle() {
        return this.Detalle;
    }
}
