package com.genoma.plus.controller.historia.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo3Dto.class */
public class Anexo3Dto {
    private String causaAtencion;
    private String diagnostico;
    private String diagnosticoRelacionado1;
    private String diagnosticoRelacionado2;
    private String diagnosticoRelacionado3;
    private String prioridadAtencion;
    private String tipoAtencionSolicitada;
    private String grupoServicios;
    private String modalidadAtencion;
    private List<ListaCupsDetalleDto> cupsDetalle;
    private List<ListaCumDetalleDto> cumDetalle;
    private List<ListaCodigoOtrosDto> otroCodigoDetalle;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Anexo3Dto)) {
            return false;
        }
        Anexo3Dto other = (Anexo3Dto) o;
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
        Object this$cupsDetalle = getCupsDetalle();
        Object other$cupsDetalle = other.getCupsDetalle();
        if (this$cupsDetalle == null) {
            if (other$cupsDetalle != null) {
                return false;
            }
        } else if (!this$cupsDetalle.equals(other$cupsDetalle)) {
            return false;
        }
        Object this$cumDetalle = getCumDetalle();
        Object other$cumDetalle = other.getCumDetalle();
        if (this$cumDetalle == null) {
            if (other$cumDetalle != null) {
                return false;
            }
        } else if (!this$cumDetalle.equals(other$cumDetalle)) {
            return false;
        }
        Object this$otroCodigoDetalle = getOtroCodigoDetalle();
        Object other$otroCodigoDetalle = other.getOtroCodigoDetalle();
        return this$otroCodigoDetalle == null ? other$otroCodigoDetalle == null : this$otroCodigoDetalle.equals(other$otroCodigoDetalle);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Anexo3Dto;
    }

    @Generated
    public int hashCode() {
        Object $causaAtencion = getCausaAtencion();
        int result = (1 * 59) + ($causaAtencion == null ? 43 : $causaAtencion.hashCode());
        Object $diagnostico = getDiagnostico();
        int result2 = (result * 59) + ($diagnostico == null ? 43 : $diagnostico.hashCode());
        Object $diagnosticoRelacionado1 = getDiagnosticoRelacionado1();
        int result3 = (result2 * 59) + ($diagnosticoRelacionado1 == null ? 43 : $diagnosticoRelacionado1.hashCode());
        Object $diagnosticoRelacionado2 = getDiagnosticoRelacionado2();
        int result4 = (result3 * 59) + ($diagnosticoRelacionado2 == null ? 43 : $diagnosticoRelacionado2.hashCode());
        Object $diagnosticoRelacionado3 = getDiagnosticoRelacionado3();
        int result5 = (result4 * 59) + ($diagnosticoRelacionado3 == null ? 43 : $diagnosticoRelacionado3.hashCode());
        Object $prioridadAtencion = getPrioridadAtencion();
        int result6 = (result5 * 59) + ($prioridadAtencion == null ? 43 : $prioridadAtencion.hashCode());
        Object $tipoAtencionSolicitada = getTipoAtencionSolicitada();
        int result7 = (result6 * 59) + ($tipoAtencionSolicitada == null ? 43 : $tipoAtencionSolicitada.hashCode());
        Object $grupoServicios = getGrupoServicios();
        int result8 = (result7 * 59) + ($grupoServicios == null ? 43 : $grupoServicios.hashCode());
        Object $modalidadAtencion = getModalidadAtencion();
        int result9 = (result8 * 59) + ($modalidadAtencion == null ? 43 : $modalidadAtencion.hashCode());
        Object $cupsDetalle = getCupsDetalle();
        int result10 = (result9 * 59) + ($cupsDetalle == null ? 43 : $cupsDetalle.hashCode());
        Object $cumDetalle = getCumDetalle();
        int result11 = (result10 * 59) + ($cumDetalle == null ? 43 : $cumDetalle.hashCode());
        Object $otroCodigoDetalle = getOtroCodigoDetalle();
        return (result11 * 59) + ($otroCodigoDetalle == null ? 43 : $otroCodigoDetalle.hashCode());
    }

    @Generated
    public String toString() {
        return "Anexo3Dto(causaAtencion=" + getCausaAtencion() + ", diagnostico=" + getDiagnostico() + ", diagnosticoRelacionado1=" + getDiagnosticoRelacionado1() + ", diagnosticoRelacionado2=" + getDiagnosticoRelacionado2() + ", diagnosticoRelacionado3=" + getDiagnosticoRelacionado3() + ", prioridadAtencion=" + getPrioridadAtencion() + ", tipoAtencionSolicitada=" + getTipoAtencionSolicitada() + ", grupoServicios=" + getGrupoServicios() + ", modalidadAtencion=" + getModalidadAtencion() + ", cupsDetalle=" + getCupsDetalle() + ", cumDetalle=" + getCumDetalle() + ", otroCodigoDetalle=" + getOtroCodigoDetalle() + ")";
    }

    @Generated
    public Anexo3Dto(String causaAtencion, String diagnostico, String diagnosticoRelacionado1, String diagnosticoRelacionado2, String diagnosticoRelacionado3, String prioridadAtencion, String tipoAtencionSolicitada, String grupoServicios, String modalidadAtencion, List<ListaCupsDetalleDto> cupsDetalle, List<ListaCumDetalleDto> cumDetalle, List<ListaCodigoOtrosDto> otroCodigoDetalle) {
        this.causaAtencion = causaAtencion;
        this.diagnostico = diagnostico;
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
        this.prioridadAtencion = prioridadAtencion;
        this.tipoAtencionSolicitada = tipoAtencionSolicitada;
        this.grupoServicios = grupoServicios;
        this.modalidadAtencion = modalidadAtencion;
        this.cupsDetalle = cupsDetalle;
        this.cumDetalle = cumDetalle;
        this.otroCodigoDetalle = otroCodigoDetalle;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo3Dto$Anexo3DtoBuilder.class */
    @Generated
    public static class Anexo3DtoBuilder {

        @Generated
        private String causaAtencion;

        @Generated
        private String diagnostico;

        @Generated
        private String diagnosticoRelacionado1;

        @Generated
        private String diagnosticoRelacionado2;

        @Generated
        private String diagnosticoRelacionado3;

        @Generated
        private String prioridadAtencion;

        @Generated
        private String tipoAtencionSolicitada;

        @Generated
        private String grupoServicios;

        @Generated
        private String modalidadAtencion;

        @Generated
        private List<ListaCupsDetalleDto> cupsDetalle;

        @Generated
        private List<ListaCumDetalleDto> cumDetalle;

        @Generated
        private List<ListaCodigoOtrosDto> otroCodigoDetalle;

        @Generated
        Anexo3DtoBuilder() {
        }

        @Generated
        public Anexo3DtoBuilder causaAtencion(String causaAtencion) {
            this.causaAtencion = causaAtencion;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder diagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder diagnosticoRelacionado1(String diagnosticoRelacionado1) {
            this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder diagnosticoRelacionado2(String diagnosticoRelacionado2) {
            this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder diagnosticoRelacionado3(String diagnosticoRelacionado3) {
            this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder prioridadAtencion(String prioridadAtencion) {
            this.prioridadAtencion = prioridadAtencion;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder tipoAtencionSolicitada(String tipoAtencionSolicitada) {
            this.tipoAtencionSolicitada = tipoAtencionSolicitada;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder grupoServicios(String grupoServicios) {
            this.grupoServicios = grupoServicios;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder modalidadAtencion(String modalidadAtencion) {
            this.modalidadAtencion = modalidadAtencion;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder cupsDetalle(List<ListaCupsDetalleDto> cupsDetalle) {
            this.cupsDetalle = cupsDetalle;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder cumDetalle(List<ListaCumDetalleDto> cumDetalle) {
            this.cumDetalle = cumDetalle;
            return this;
        }

        @Generated
        public Anexo3DtoBuilder otroCodigoDetalle(List<ListaCodigoOtrosDto> otroCodigoDetalle) {
            this.otroCodigoDetalle = otroCodigoDetalle;
            return this;
        }

        @Generated
        public Anexo3Dto build() {
            return new Anexo3Dto(this.causaAtencion, this.diagnostico, this.diagnosticoRelacionado1, this.diagnosticoRelacionado2, this.diagnosticoRelacionado3, this.prioridadAtencion, this.tipoAtencionSolicitada, this.grupoServicios, this.modalidadAtencion, this.cupsDetalle, this.cumDetalle, this.otroCodigoDetalle);
        }

        @Generated
        public String toString() {
            return "Anexo3Dto.Anexo3DtoBuilder(causaAtencion=" + this.causaAtencion + ", diagnostico=" + this.diagnostico + ", diagnosticoRelacionado1=" + this.diagnosticoRelacionado1 + ", diagnosticoRelacionado2=" + this.diagnosticoRelacionado2 + ", diagnosticoRelacionado3=" + this.diagnosticoRelacionado3 + ", prioridadAtencion=" + this.prioridadAtencion + ", tipoAtencionSolicitada=" + this.tipoAtencionSolicitada + ", grupoServicios=" + this.grupoServicios + ", modalidadAtencion=" + this.modalidadAtencion + ", cupsDetalle=" + this.cupsDetalle + ", cumDetalle=" + this.cumDetalle + ", otroCodigoDetalle=" + this.otroCodigoDetalle + ")";
        }
    }

    @Generated
    public Anexo3Dto() {
    }

    @Generated
    public static Anexo3DtoBuilder builder() {
        return new Anexo3DtoBuilder();
    }

    @Generated
    public void setCausaAtencion(String causaAtencion) {
        this.causaAtencion = causaAtencion;
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
    public void setCupsDetalle(List<ListaCupsDetalleDto> cupsDetalle) {
        this.cupsDetalle = cupsDetalle;
    }

    @Generated
    public void setCumDetalle(List<ListaCumDetalleDto> cumDetalle) {
        this.cumDetalle = cumDetalle;
    }

    @Generated
    public void setOtroCodigoDetalle(List<ListaCodigoOtrosDto> otroCodigoDetalle) {
        this.otroCodigoDetalle = otroCodigoDetalle;
    }

    @Generated
    public String getCausaAtencion() {
        return this.causaAtencion;
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
    public List<ListaCupsDetalleDto> getCupsDetalle() {
        return this.cupsDetalle;
    }

    @Generated
    public List<ListaCumDetalleDto> getCumDetalle() {
        return this.cumDetalle;
    }

    @Generated
    public List<ListaCodigoOtrosDto> getOtroCodigoDetalle() {
        return this.otroCodigoDetalle;
    }
}
