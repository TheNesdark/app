package com.genoma.plus.controller.historia.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo2Dto.class */
public class Anexo2Dto {
    private String motivoConsulta;
    private String clasificacionTriage;
    private String fechaHoraIngreso;
    private String viaIngreso;
    private String codigoPrestadorRemite;
    private String diagnostico;
    private String diagnosticoRelacionado1;
    private String diagnosticoRelacionado2;
    private String diagnosticoRelacionado3;
    private String condicionDestino;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Anexo2Dto)) {
            return false;
        }
        Anexo2Dto other = (Anexo2Dto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$motivoConsulta = getMotivoConsulta();
        Object other$motivoConsulta = other.getMotivoConsulta();
        if (this$motivoConsulta == null) {
            if (other$motivoConsulta != null) {
                return false;
            }
        } else if (!this$motivoConsulta.equals(other$motivoConsulta)) {
            return false;
        }
        Object this$clasificacionTriage = getClasificacionTriage();
        Object other$clasificacionTriage = other.getClasificacionTriage();
        if (this$clasificacionTriage == null) {
            if (other$clasificacionTriage != null) {
                return false;
            }
        } else if (!this$clasificacionTriage.equals(other$clasificacionTriage)) {
            return false;
        }
        Object this$fechaHoraIngreso = getFechaHoraIngreso();
        Object other$fechaHoraIngreso = other.getFechaHoraIngreso();
        if (this$fechaHoraIngreso == null) {
            if (other$fechaHoraIngreso != null) {
                return false;
            }
        } else if (!this$fechaHoraIngreso.equals(other$fechaHoraIngreso)) {
            return false;
        }
        Object this$viaIngreso = getViaIngreso();
        Object other$viaIngreso = other.getViaIngreso();
        if (this$viaIngreso == null) {
            if (other$viaIngreso != null) {
                return false;
            }
        } else if (!this$viaIngreso.equals(other$viaIngreso)) {
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
        return this$condicionDestino == null ? other$condicionDestino == null : this$condicionDestino.equals(other$condicionDestino);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Anexo2Dto;
    }

    @Generated
    public int hashCode() {
        Object $motivoConsulta = getMotivoConsulta();
        int result = (1 * 59) + ($motivoConsulta == null ? 43 : $motivoConsulta.hashCode());
        Object $clasificacionTriage = getClasificacionTriage();
        int result2 = (result * 59) + ($clasificacionTriage == null ? 43 : $clasificacionTriage.hashCode());
        Object $fechaHoraIngreso = getFechaHoraIngreso();
        int result3 = (result2 * 59) + ($fechaHoraIngreso == null ? 43 : $fechaHoraIngreso.hashCode());
        Object $viaIngreso = getViaIngreso();
        int result4 = (result3 * 59) + ($viaIngreso == null ? 43 : $viaIngreso.hashCode());
        Object $codigoPrestadorRemite = getCodigoPrestadorRemite();
        int result5 = (result4 * 59) + ($codigoPrestadorRemite == null ? 43 : $codigoPrestadorRemite.hashCode());
        Object $diagnostico = getDiagnostico();
        int result6 = (result5 * 59) + ($diagnostico == null ? 43 : $diagnostico.hashCode());
        Object $diagnosticoRelacionado1 = getDiagnosticoRelacionado1();
        int result7 = (result6 * 59) + ($diagnosticoRelacionado1 == null ? 43 : $diagnosticoRelacionado1.hashCode());
        Object $diagnosticoRelacionado2 = getDiagnosticoRelacionado2();
        int result8 = (result7 * 59) + ($diagnosticoRelacionado2 == null ? 43 : $diagnosticoRelacionado2.hashCode());
        Object $diagnosticoRelacionado3 = getDiagnosticoRelacionado3();
        int result9 = (result8 * 59) + ($diagnosticoRelacionado3 == null ? 43 : $diagnosticoRelacionado3.hashCode());
        Object $condicionDestino = getCondicionDestino();
        return (result9 * 59) + ($condicionDestino == null ? 43 : $condicionDestino.hashCode());
    }

    @Generated
    public String toString() {
        return "Anexo2Dto(motivoConsulta=" + getMotivoConsulta() + ", clasificacionTriage=" + getClasificacionTriage() + ", fechaHoraIngreso=" + getFechaHoraIngreso() + ", viaIngreso=" + getViaIngreso() + ", codigoPrestadorRemite=" + getCodigoPrestadorRemite() + ", diagnostico=" + getDiagnostico() + ", diagnosticoRelacionado1=" + getDiagnosticoRelacionado1() + ", diagnosticoRelacionado2=" + getDiagnosticoRelacionado2() + ", diagnosticoRelacionado3=" + getDiagnosticoRelacionado3() + ", condicionDestino=" + getCondicionDestino() + ")";
    }

    @Generated
    public Anexo2Dto(String motivoConsulta, String clasificacionTriage, String fechaHoraIngreso, String viaIngreso, String codigoPrestadorRemite, String diagnostico, String diagnosticoRelacionado1, String diagnosticoRelacionado2, String diagnosticoRelacionado3, String condicionDestino) {
        this.motivoConsulta = motivoConsulta;
        this.clasificacionTriage = clasificacionTriage;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.viaIngreso = viaIngreso;
        this.codigoPrestadorRemite = codigoPrestadorRemite;
        this.diagnostico = diagnostico;
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
        this.condicionDestino = condicionDestino;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/dto/Anexo2Dto$Anexo2DtoBuilder.class */
    @Generated
    public static class Anexo2DtoBuilder {

        @Generated
        private String motivoConsulta;

        @Generated
        private String clasificacionTriage;

        @Generated
        private String fechaHoraIngreso;

        @Generated
        private String viaIngreso;

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
        Anexo2DtoBuilder() {
        }

        @Generated
        public Anexo2DtoBuilder motivoConsulta(String motivoConsulta) {
            this.motivoConsulta = motivoConsulta;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder clasificacionTriage(String clasificacionTriage) {
            this.clasificacionTriage = clasificacionTriage;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder fechaHoraIngreso(String fechaHoraIngreso) {
            this.fechaHoraIngreso = fechaHoraIngreso;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder viaIngreso(String viaIngreso) {
            this.viaIngreso = viaIngreso;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder codigoPrestadorRemite(String codigoPrestadorRemite) {
            this.codigoPrestadorRemite = codigoPrestadorRemite;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder diagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder diagnosticoRelacionado1(String diagnosticoRelacionado1) {
            this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder diagnosticoRelacionado2(String diagnosticoRelacionado2) {
            this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder diagnosticoRelacionado3(String diagnosticoRelacionado3) {
            this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
            return this;
        }

        @Generated
        public Anexo2DtoBuilder condicionDestino(String condicionDestino) {
            this.condicionDestino = condicionDestino;
            return this;
        }

        @Generated
        public Anexo2Dto build() {
            return new Anexo2Dto(this.motivoConsulta, this.clasificacionTriage, this.fechaHoraIngreso, this.viaIngreso, this.codigoPrestadorRemite, this.diagnostico, this.diagnosticoRelacionado1, this.diagnosticoRelacionado2, this.diagnosticoRelacionado3, this.condicionDestino);
        }

        @Generated
        public String toString() {
            return "Anexo2Dto.Anexo2DtoBuilder(motivoConsulta=" + this.motivoConsulta + ", clasificacionTriage=" + this.clasificacionTriage + ", fechaHoraIngreso=" + this.fechaHoraIngreso + ", viaIngreso=" + this.viaIngreso + ", codigoPrestadorRemite=" + this.codigoPrestadorRemite + ", diagnostico=" + this.diagnostico + ", diagnosticoRelacionado1=" + this.diagnosticoRelacionado1 + ", diagnosticoRelacionado2=" + this.diagnosticoRelacionado2 + ", diagnosticoRelacionado3=" + this.diagnosticoRelacionado3 + ", condicionDestino=" + this.condicionDestino + ")";
        }
    }

    @Generated
    public Anexo2Dto() {
    }

    @Generated
    public static Anexo2DtoBuilder builder() {
        return new Anexo2DtoBuilder();
    }

    @Generated
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    @Generated
    public void setClasificacionTriage(String clasificacionTriage) {
        this.clasificacionTriage = clasificacionTriage;
    }

    @Generated
    public void setFechaHoraIngreso(String fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    @Generated
    public void setViaIngreso(String viaIngreso) {
        this.viaIngreso = viaIngreso;
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
    public String getMotivoConsulta() {
        return this.motivoConsulta;
    }

    @Generated
    public String getClasificacionTriage() {
        return this.clasificacionTriage;
    }

    @Generated
    public String getFechaHoraIngreso() {
        return this.fechaHoraIngreso;
    }

    @Generated
    public String getViaIngreso() {
        return this.viaIngreso;
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
}
