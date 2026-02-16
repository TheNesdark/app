package com.genoma.plus.controller.historia.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo5Dto.class */
public class Anexo5Dto {
    private String causaAtencion;
    private String codigoPrestadorRemite;
    private String diagnostico;
    private String diagnosticoRelacionado1;
    private String diagnosticoRelacionado2;
    private String diagnosticoRelacionado3;
    private String condicionDestino;
    private String prioridadAtencion;
    private String tipoAtencionSolicitada;
    private String grupoServicios;
    private String modalidadAtencion;
    private String codigoServicio;
    private List<ListaCupsDetalleDto> cupsDetalle;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Anexo5Dto)) {
            return false;
        }
        Anexo5Dto other = (Anexo5Dto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$causaAtencion = getCausaAtencion();
        Object other$causaAtencion = other.getCausaAtencion();
        if (this$causaAtencion == null) {
            if (other$causaAtencion != null) {
                return false;
            }
        } else if (!this$causaAtencion.equals(other$causaAtencion)) {
            return false;
        }
        Object this$codigoPrestadorRemite = getCodigoPrestadorRemite();
        Object other$codigoPrestadorRemite = other.getCodigoPrestadorRemite();
        if (this$codigoPrestadorRemite == null) {
            if (other$codigoPrestadorRemite != null) {
                return false;
            }
        } else if (!this$codigoPrestadorRemite.equals(other$codigoPrestadorRemite)) {
            return false;
        }
        Object this$diagnostico = getDiagnostico();
        Object other$diagnostico = other.getDiagnostico();
        if (this$diagnostico == null) {
            if (other$diagnostico != null) {
                return false;
            }
        } else if (!this$diagnostico.equals(other$diagnostico)) {
            return false;
        }
        Object this$diagnosticoRelacionado1 = getDiagnosticoRelacionado1();
        Object other$diagnosticoRelacionado1 = other.getDiagnosticoRelacionado1();
        if (this$diagnosticoRelacionado1 == null) {
            if (other$diagnosticoRelacionado1 != null) {
                return false;
            }
        } else if (!this$diagnosticoRelacionado1.equals(other$diagnosticoRelacionado1)) {
            return false;
        }
        Object this$diagnosticoRelacionado2 = getDiagnosticoRelacionado2();
        Object other$diagnosticoRelacionado2 = other.getDiagnosticoRelacionado2();
        if (this$diagnosticoRelacionado2 == null) {
            if (other$diagnosticoRelacionado2 != null) {
                return false;
            }
        } else if (!this$diagnosticoRelacionado2.equals(other$diagnosticoRelacionado2)) {
            return false;
        }
        Object this$diagnosticoRelacionado3 = getDiagnosticoRelacionado3();
        Object other$diagnosticoRelacionado3 = other.getDiagnosticoRelacionado3();
        if (this$diagnosticoRelacionado3 == null) {
            if (other$diagnosticoRelacionado3 != null) {
                return false;
            }
        } else if (!this$diagnosticoRelacionado3.equals(other$diagnosticoRelacionado3)) {
            return false;
        }
        Object this$condicionDestino = getCondicionDestino();
        Object other$condicionDestino = other.getCondicionDestino();
        if (this$condicionDestino == null) {
            if (other$condicionDestino != null) {
                return false;
            }
        } else if (!this$condicionDestino.equals(other$condicionDestino)) {
            return false;
        }
        Object this$prioridadAtencion = getPrioridadAtencion();
        Object other$prioridadAtencion = other.getPrioridadAtencion();
        if (this$prioridadAtencion == null) {
            if (other$prioridadAtencion != null) {
                return false;
            }
        } else if (!this$prioridadAtencion.equals(other$prioridadAtencion)) {
            return false;
        }
        Object this$tipoAtencionSolicitada = getTipoAtencionSolicitada();
        Object other$tipoAtencionSolicitada = other.getTipoAtencionSolicitada();
        if (this$tipoAtencionSolicitada == null) {
            if (other$tipoAtencionSolicitada != null) {
                return false;
            }
        } else if (!this$tipoAtencionSolicitada.equals(other$tipoAtencionSolicitada)) {
            return false;
        }
        Object this$grupoServicios = getGrupoServicios();
        Object other$grupoServicios = other.getGrupoServicios();
        if (this$grupoServicios == null) {
            if (other$grupoServicios != null) {
                return false;
            }
        } else if (!this$grupoServicios.equals(other$grupoServicios)) {
            return false;
        }
        Object this$modalidadAtencion = getModalidadAtencion();
        Object other$modalidadAtencion = other.getModalidadAtencion();
        if (this$modalidadAtencion == null) {
            if (other$modalidadAtencion != null) {
                return false;
            }
        } else if (!this$modalidadAtencion.equals(other$modalidadAtencion)) {
            return false;
        }
        Object this$codigoServicio = getCodigoServicio();
        Object other$codigoServicio = other.getCodigoServicio();
        if (this$codigoServicio == null) {
            if (other$codigoServicio != null) {
                return false;
            }
        } else if (!this$codigoServicio.equals(other$codigoServicio)) {
            return false;
        }
        Object this$cupsDetalle = getCupsDetalle();
        Object other$cupsDetalle = other.getCupsDetalle();
        return this$cupsDetalle == null ? other$cupsDetalle == null : this$cupsDetalle.equals(other$cupsDetalle);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Anexo5Dto;
    }

    @Generated
    public int hashCode() {
        Object $causaAtencion = getCausaAtencion();
        int result = (1 * 59) + ($causaAtencion == null ? 43 : $causaAtencion.hashCode());
        Object $codigoPrestadorRemite = getCodigoPrestadorRemite();
        int result2 = (result * 59) + ($codigoPrestadorRemite == null ? 43 : $codigoPrestadorRemite.hashCode());
        Object $diagnostico = getDiagnostico();
        int result3 = (result2 * 59) + ($diagnostico == null ? 43 : $diagnostico.hashCode());
        Object $diagnosticoRelacionado1 = getDiagnosticoRelacionado1();
        int result4 = (result3 * 59) + ($diagnosticoRelacionado1 == null ? 43 : $diagnosticoRelacionado1.hashCode());
        Object $diagnosticoRelacionado2 = getDiagnosticoRelacionado2();
        int result5 = (result4 * 59) + ($diagnosticoRelacionado2 == null ? 43 : $diagnosticoRelacionado2.hashCode());
        Object $diagnosticoRelacionado3 = getDiagnosticoRelacionado3();
        int result6 = (result5 * 59) + ($diagnosticoRelacionado3 == null ? 43 : $diagnosticoRelacionado3.hashCode());
        Object $condicionDestino = getCondicionDestino();
        int result7 = (result6 * 59) + ($condicionDestino == null ? 43 : $condicionDestino.hashCode());
        Object $prioridadAtencion = getPrioridadAtencion();
        int result8 = (result7 * 59) + ($prioridadAtencion == null ? 43 : $prioridadAtencion.hashCode());
        Object $tipoAtencionSolicitada = getTipoAtencionSolicitada();
        int result9 = (result8 * 59) + ($tipoAtencionSolicitada == null ? 43 : $tipoAtencionSolicitada.hashCode());
        Object $grupoServicios = getGrupoServicios();
        int result10 = (result9 * 59) + ($grupoServicios == null ? 43 : $grupoServicios.hashCode());
        Object $modalidadAtencion = getModalidadAtencion();
        int result11 = (result10 * 59) + ($modalidadAtencion == null ? 43 : $modalidadAtencion.hashCode());
        Object $codigoServicio = getCodigoServicio();
        int result12 = (result11 * 59) + ($codigoServicio == null ? 43 : $codigoServicio.hashCode());
        Object $cupsDetalle = getCupsDetalle();
        return (result12 * 59) + ($cupsDetalle == null ? 43 : $cupsDetalle.hashCode());
    }

    @Generated
    public String toString() {
        return "Anexo5Dto(causaAtencion=" + getCausaAtencion() + ", codigoPrestadorRemite=" + getCodigoPrestadorRemite() + ", diagnostico=" + getDiagnostico() + ", diagnosticoRelacionado1=" + getDiagnosticoRelacionado1() + ", diagnosticoRelacionado2=" + getDiagnosticoRelacionado2() + ", diagnosticoRelacionado3=" + getDiagnosticoRelacionado3() + ", condicionDestino=" + getCondicionDestino() + ", prioridadAtencion=" + getPrioridadAtencion() + ", tipoAtencionSolicitada=" + getTipoAtencionSolicitada() + ", grupoServicios=" + getGrupoServicios() + ", modalidadAtencion=" + getModalidadAtencion() + ", codigoServicio=" + getCodigoServicio() + ", cupsDetalle=" + getCupsDetalle() + ")";
    }

    @Generated
    public Anexo5Dto(String causaAtencion, String codigoPrestadorRemite, String diagnostico, String diagnosticoRelacionado1, String diagnosticoRelacionado2, String diagnosticoRelacionado3, String condicionDestino, String prioridadAtencion, String tipoAtencionSolicitada, String grupoServicios, String modalidadAtencion, String codigoServicio, List<ListaCupsDetalleDto> cupsDetalle) {
        this.causaAtencion = causaAtencion;
        this.codigoPrestadorRemite = codigoPrestadorRemite;
        this.diagnostico = diagnostico;
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
        this.condicionDestino = condicionDestino;
        this.prioridadAtencion = prioridadAtencion;
        this.tipoAtencionSolicitada = tipoAtencionSolicitada;
        this.grupoServicios = grupoServicios;
        this.modalidadAtencion = modalidadAtencion;
        this.codigoServicio = codigoServicio;
        this.cupsDetalle = cupsDetalle;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo5Dto$Anexo5DtoBuilder.class */
    @Generated
    public static class Anexo5DtoBuilder {

        @Generated
        private String causaAtencion;

        @Generated
        private String codigoPrestadorRemite;

        @Generated
        private String diagnostico;

        @Generated
        private String diagnosticoRelacionado1;

        @Generated
        private String diagnosticoRelacionado2;

        @Generated
        private String diagnosticoRelacionado3;

        @Generated
        private String condicionDestino;

        @Generated
        private String prioridadAtencion;

        @Generated
        private String tipoAtencionSolicitada;

        @Generated
        private String grupoServicios;

        @Generated
        private String modalidadAtencion;

        @Generated
        private String codigoServicio;

        @Generated
        private List<ListaCupsDetalleDto> cupsDetalle;

        @Generated
        Anexo5DtoBuilder() {
        }

        @Generated
        public Anexo5DtoBuilder causaAtencion(String causaAtencion) {
            this.causaAtencion = causaAtencion;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder codigoPrestadorRemite(String codigoPrestadorRemite) {
            this.codigoPrestadorRemite = codigoPrestadorRemite;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder diagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder diagnosticoRelacionado1(String diagnosticoRelacionado1) {
            this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder diagnosticoRelacionado2(String diagnosticoRelacionado2) {
            this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder diagnosticoRelacionado3(String diagnosticoRelacionado3) {
            this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder condicionDestino(String condicionDestino) {
            this.condicionDestino = condicionDestino;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder prioridadAtencion(String prioridadAtencion) {
            this.prioridadAtencion = prioridadAtencion;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder tipoAtencionSolicitada(String tipoAtencionSolicitada) {
            this.tipoAtencionSolicitada = tipoAtencionSolicitada;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder grupoServicios(String grupoServicios) {
            this.grupoServicios = grupoServicios;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder modalidadAtencion(String modalidadAtencion) {
            this.modalidadAtencion = modalidadAtencion;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder codigoServicio(String codigoServicio) {
            this.codigoServicio = codigoServicio;
            return this;
        }

        @Generated
        public Anexo5DtoBuilder cupsDetalle(List<ListaCupsDetalleDto> cupsDetalle) {
            this.cupsDetalle = cupsDetalle;
            return this;
        }

        @Generated
        public Anexo5Dto build() {
            return new Anexo5Dto(this.causaAtencion, this.codigoPrestadorRemite, this.diagnostico, this.diagnosticoRelacionado1, this.diagnosticoRelacionado2, this.diagnosticoRelacionado3, this.condicionDestino, this.prioridadAtencion, this.tipoAtencionSolicitada, this.grupoServicios, this.modalidadAtencion, this.codigoServicio, this.cupsDetalle);
        }

        @Generated
        public String toString() {
            return "Anexo5Dto.Anexo5DtoBuilder(causaAtencion=" + this.causaAtencion + ", codigoPrestadorRemite=" + this.codigoPrestadorRemite + ", diagnostico=" + this.diagnostico + ", diagnosticoRelacionado1=" + this.diagnosticoRelacionado1 + ", diagnosticoRelacionado2=" + this.diagnosticoRelacionado2 + ", diagnosticoRelacionado3=" + this.diagnosticoRelacionado3 + ", condicionDestino=" + this.condicionDestino + ", prioridadAtencion=" + this.prioridadAtencion + ", tipoAtencionSolicitada=" + this.tipoAtencionSolicitada + ", grupoServicios=" + this.grupoServicios + ", modalidadAtencion=" + this.modalidadAtencion + ", codigoServicio=" + this.codigoServicio + ", cupsDetalle=" + this.cupsDetalle + ")";
        }
    }

    @Generated
    public Anexo5Dto() {
    }

    @Generated
    public static Anexo5DtoBuilder builder() {
        return new Anexo5DtoBuilder();
    }

    @Generated
    public void setCausaAtencion(String causaAtencion) {
        this.causaAtencion = causaAtencion;
    }

    @Generated
    public void setCodigoPrestadorRemite(String codigoPrestadorRemite) {
        this.codigoPrestadorRemite = codigoPrestadorRemite;
    }

    @Generated
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Generated
    public void setDiagnosticoRelacionado1(String diagnosticoRelacionado1) {
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
    }

    @Generated
    public void setDiagnosticoRelacionado2(String diagnosticoRelacionado2) {
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
    }

    @Generated
    public void setDiagnosticoRelacionado3(String diagnosticoRelacionado3) {
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
    }

    @Generated
    public void setCondicionDestino(String condicionDestino) {
        this.condicionDestino = condicionDestino;
    }

    @Generated
    public void setPrioridadAtencion(String prioridadAtencion) {
        this.prioridadAtencion = prioridadAtencion;
    }

    @Generated
    public void setTipoAtencionSolicitada(String tipoAtencionSolicitada) {
        this.tipoAtencionSolicitada = tipoAtencionSolicitada;
    }

    @Generated
    public void setGrupoServicios(String grupoServicios) {
        this.grupoServicios = grupoServicios;
    }

    @Generated
    public void setModalidadAtencion(String modalidadAtencion) {
        this.modalidadAtencion = modalidadAtencion;
    }

    @Generated
    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    @Generated
    public void setCupsDetalle(List<ListaCupsDetalleDto> cupsDetalle) {
        this.cupsDetalle = cupsDetalle;
    }

    @Generated
    public String getCausaAtencion() {
        return this.causaAtencion;
    }

    @Generated
    public String getCodigoPrestadorRemite() {
        return this.codigoPrestadorRemite;
    }

    @Generated
    public String getDiagnostico() {
        return this.diagnostico;
    }

    @Generated
    public String getDiagnosticoRelacionado1() {
        return this.diagnosticoRelacionado1;
    }

    @Generated
    public String getDiagnosticoRelacionado2() {
        return this.diagnosticoRelacionado2;
    }

    @Generated
    public String getDiagnosticoRelacionado3() {
        return this.diagnosticoRelacionado3;
    }

    @Generated
    public String getCondicionDestino() {
        return this.condicionDestino;
    }

    @Generated
    public String getPrioridadAtencion() {
        return this.prioridadAtencion;
    }

    @Generated
    public String getTipoAtencionSolicitada() {
        return this.tipoAtencionSolicitada;
    }

    @Generated
    public String getGrupoServicios() {
        return this.grupoServicios;
    }

    @Generated
    public String getModalidadAtencion() {
        return this.modalidadAtencion;
    }

    @Generated
    public String getCodigoServicio() {
        return this.codigoServicio;
    }

    @Generated
    public List<ListaCupsDetalleDto> getCupsDetalle() {
        return this.cupsDetalle;
    }
}
