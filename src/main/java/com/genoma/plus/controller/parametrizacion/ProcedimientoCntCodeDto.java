package com.genoma.plus.controller.parametrizacion;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ProcedimientoCntCodeDto.class */
public class ProcedimientoCntCodeDto {
    private Long id;
    private Long idprocedimiento;
    private String codigoCnt;
    private String usuario;
    private Boolean estado;
    private Date fecha;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProcedimientoCntCodeDto)) {
            return false;
        }
        ProcedimientoCntCodeDto other = (ProcedimientoCntCodeDto) o;
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
        Object this$idprocedimiento = getIdprocedimiento();
        Object other$idprocedimiento = other.getIdprocedimiento();
        if (this$idprocedimiento == null) {
            if (other$idprocedimiento != null) {
                return false;
            }
        } else if (!this$idprocedimiento.equals(other$idprocedimiento)) {
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
        Object this$codigoCnt = getCodigoCnt();
        Object other$codigoCnt = other.getCodigoCnt();
        if (this$codigoCnt == null) {
            if (other$codigoCnt != null) {
                return false;
            }
        } else if (!this$codigoCnt.equals(other$codigoCnt)) {
            return false;
        }
        Object this$usuario = getUsuario();
        Object other$usuario = other.getUsuario();
        if (this$usuario == null) {
            if (other$usuario != null) {
                return false;
            }
        } else if (!this$usuario.equals(other$usuario)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        return this$fecha == null ? other$fecha == null : this$fecha.equals(other$fecha);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ProcedimientoCntCodeDto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idprocedimiento = getIdprocedimiento();
        int result2 = (result * 59) + ($idprocedimiento == null ? 43 : $idprocedimiento.hashCode());
        Object $estado = getEstado();
        int result3 = (result2 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $codigoCnt = getCodigoCnt();
        int result4 = (result3 * 59) + ($codigoCnt == null ? 43 : $codigoCnt.hashCode());
        Object $usuario = getUsuario();
        int result5 = (result4 * 59) + ($usuario == null ? 43 : $usuario.hashCode());
        Object $fecha = getFecha();
        return (result5 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
    }

    @Generated
    public String toString() {
        return "ProcedimientoCntCodeDto(id=" + getId() + ", idprocedimiento=" + getIdprocedimiento() + ", codigoCnt=" + getCodigoCnt() + ", usuario=" + getUsuario() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/ProcedimientoCntCodeDto$ProcedimientoCntCodeDtoBuilder.class */
    @Generated
    public static class ProcedimientoCntCodeDtoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idprocedimiento;

        @Generated
        private String codigoCnt;

        @Generated
        private String usuario;

        @Generated
        private Boolean estado;

        @Generated
        private Date fecha;

        @Generated
        ProcedimientoCntCodeDtoBuilder() {
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder idprocedimiento(Long idprocedimiento) {
            this.idprocedimiento = idprocedimiento;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder codigoCnt(String codigoCnt) {
            this.codigoCnt = codigoCnt;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDtoBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public ProcedimientoCntCodeDto build() {
            return new ProcedimientoCntCodeDto(this.id, this.idprocedimiento, this.codigoCnt, this.usuario, this.estado, this.fecha);
        }

        @Generated
        public String toString() {
            return "ProcedimientoCntCodeDto.ProcedimientoCntCodeDtoBuilder(id=" + this.id + ", idprocedimiento=" + this.idprocedimiento + ", codigoCnt=" + this.codigoCnt + ", usuario=" + this.usuario + ", estado=" + this.estado + ", fecha=" + this.fecha + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdprocedimiento(Long idprocedimiento) {
        this.idprocedimiento = idprocedimiento;
    }

    @Generated
    public void setCodigoCnt(String codigoCnt) {
        this.codigoCnt = codigoCnt;
    }

    @Generated
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public static ProcedimientoCntCodeDtoBuilder builder() {
        return new ProcedimientoCntCodeDtoBuilder();
    }

    @Generated
    public ProcedimientoCntCodeDto(Long id, Long idprocedimiento, String codigoCnt, String usuario, Boolean estado, Date fecha) {
        this.id = id;
        this.idprocedimiento = idprocedimiento;
        this.codigoCnt = codigoCnt;
        this.usuario = usuario;
        this.estado = estado;
        this.fecha = fecha;
    }

    @Generated
    public ProcedimientoCntCodeDto() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdprocedimiento() {
        return this.idprocedimiento;
    }

    @Generated
    public String getCodigoCnt() {
        return this.codigoCnt;
    }

    @Generated
    public String getUsuario() {
        return this.usuario;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }
}
