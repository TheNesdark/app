package com.genoma.plus.controller.parametrizacion;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/TipoProgramaDTO.class */
public class TipoProgramaDTO {
    private Integer idTipoPrograma;
    private String nbre;
    private Integer esPrenatal;
    private Integer edadI;
    private String tEdadI;
    private Integer edadF;
    private String tEdadF;
    private String genero;
    private Boolean estado;
    private Date fecha;
    private String usuarioS;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TipoProgramaDTO)) {
            return false;
        }
        TipoProgramaDTO other = (TipoProgramaDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idTipoPrograma = getIdTipoPrograma();
        Object other$idTipoPrograma = other.getIdTipoPrograma();
        if (this$idTipoPrograma == null) {
            if (other$idTipoPrograma != null) {
                return false;
            }
        } else if (!this$idTipoPrograma.equals(other$idTipoPrograma)) {
            return false;
        }
        Object this$esPrenatal = getEsPrenatal();
        Object other$esPrenatal = other.getEsPrenatal();
        if (this$esPrenatal == null) {
            if (other$esPrenatal != null) {
                return false;
            }
        } else if (!this$esPrenatal.equals(other$esPrenatal)) {
            return false;
        }
        Object this$edadI = getEdadI();
        Object other$edadI = other.getEdadI();
        if (this$edadI == null) {
            if (other$edadI != null) {
                return false;
            }
        } else if (!this$edadI.equals(other$edadI)) {
            return false;
        }
        Object this$edadF = getEdadF();
        Object other$edadF = other.getEdadF();
        if (this$edadF == null) {
            if (other$edadF != null) {
                return false;
            }
        } else if (!this$edadF.equals(other$edadF)) {
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
        Object this$nbre = getNbre();
        Object other$nbre = other.getNbre();
        if (this$nbre == null) {
            if (other$nbre != null) {
                return false;
            }
        } else if (!this$nbre.equals(other$nbre)) {
            return false;
        }
        Object this$tEdadI = getTEdadI();
        Object other$tEdadI = other.getTEdadI();
        if (this$tEdadI == null) {
            if (other$tEdadI != null) {
                return false;
            }
        } else if (!this$tEdadI.equals(other$tEdadI)) {
            return false;
        }
        Object this$tEdadF = getTEdadF();
        Object other$tEdadF = other.getTEdadF();
        if (this$tEdadF == null) {
            if (other$tEdadF != null) {
                return false;
            }
        } else if (!this$tEdadF.equals(other$tEdadF)) {
            return false;
        }
        Object this$genero = getGenero();
        Object other$genero = other.getGenero();
        if (this$genero == null) {
            if (other$genero != null) {
                return false;
            }
        } else if (!this$genero.equals(other$genero)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        if (this$fecha == null) {
            if (other$fecha != null) {
                return false;
            }
        } else if (!this$fecha.equals(other$fecha)) {
            return false;
        }
        Object this$usuarioS = getUsuarioS();
        Object other$usuarioS = other.getUsuarioS();
        return this$usuarioS == null ? other$usuarioS == null : this$usuarioS.equals(other$usuarioS);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TipoProgramaDTO;
    }

    @Generated
    public int hashCode() {
        Object $idTipoPrograma = getIdTipoPrograma();
        int result = (1 * 59) + ($idTipoPrograma == null ? 43 : $idTipoPrograma.hashCode());
        Object $esPrenatal = getEsPrenatal();
        int result2 = (result * 59) + ($esPrenatal == null ? 43 : $esPrenatal.hashCode());
        Object $edadI = getEdadI();
        int result3 = (result2 * 59) + ($edadI == null ? 43 : $edadI.hashCode());
        Object $edadF = getEdadF();
        int result4 = (result3 * 59) + ($edadF == null ? 43 : $edadF.hashCode());
        Object $estado = getEstado();
        int result5 = (result4 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $nbre = getNbre();
        int result6 = (result5 * 59) + ($nbre == null ? 43 : $nbre.hashCode());
        Object $tEdadI = getTEdadI();
        int result7 = (result6 * 59) + ($tEdadI == null ? 43 : $tEdadI.hashCode());
        Object $tEdadF = getTEdadF();
        int result8 = (result7 * 59) + ($tEdadF == null ? 43 : $tEdadF.hashCode());
        Object $genero = getGenero();
        int result9 = (result8 * 59) + ($genero == null ? 43 : $genero.hashCode());
        Object $fecha = getFecha();
        int result10 = (result9 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $usuarioS = getUsuarioS();
        return (result10 * 59) + ($usuarioS == null ? 43 : $usuarioS.hashCode());
    }

    @Generated
    public String toString() {
        return "TipoProgramaDTO(idTipoPrograma=" + getIdTipoPrograma() + ", nbre=" + getNbre() + ", esPrenatal=" + getEsPrenatal() + ", edadI=" + getEdadI() + ", tEdadI=" + getTEdadI() + ", edadF=" + getEdadF() + ", tEdadF=" + getTEdadF() + ", genero=" + getGenero() + ", estado=" + getEstado() + ", fecha=" + getFecha() + ", usuarioS=" + getUsuarioS() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/TipoProgramaDTO$TipoProgramaDTOBuilder.class */
    @Generated
    public static class TipoProgramaDTOBuilder {

        @Generated
        private Integer idTipoPrograma;

        @Generated
        private String nbre;

        @Generated
        private Integer esPrenatal;

        @Generated
        private Integer edadI;

        @Generated
        private String tEdadI;

        @Generated
        private Integer edadF;

        @Generated
        private String tEdadF;

        @Generated
        private String genero;

        @Generated
        private Boolean estado;

        @Generated
        private Date fecha;

        @Generated
        private String usuarioS;

        @Generated
        TipoProgramaDTOBuilder() {
        }

        @Generated
        public TipoProgramaDTOBuilder idTipoPrograma(Integer idTipoPrograma) {
            this.idTipoPrograma = idTipoPrograma;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder nbre(String nbre) {
            this.nbre = nbre;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder esPrenatal(Integer esPrenatal) {
            this.esPrenatal = esPrenatal;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder edadI(Integer edadI) {
            this.edadI = edadI;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder tEdadI(String tEdadI) {
            this.tEdadI = tEdadI;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder edadF(Integer edadF) {
            this.edadF = edadF;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder tEdadF(String tEdadF) {
            this.tEdadF = tEdadF;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder genero(String genero) {
            this.genero = genero;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public TipoProgramaDTOBuilder usuarioS(String usuarioS) {
            this.usuarioS = usuarioS;
            return this;
        }

        @Generated
        public TipoProgramaDTO build() {
            return new TipoProgramaDTO(this.idTipoPrograma, this.nbre, this.esPrenatal, this.edadI, this.tEdadI, this.edadF, this.tEdadF, this.genero, this.estado, this.fecha, this.usuarioS);
        }

        @Generated
        public String toString() {
            return "TipoProgramaDTO.TipoProgramaDTOBuilder(idTipoPrograma=" + this.idTipoPrograma + ", nbre=" + this.nbre + ", esPrenatal=" + this.esPrenatal + ", edadI=" + this.edadI + ", tEdadI=" + this.tEdadI + ", edadF=" + this.edadF + ", tEdadF=" + this.tEdadF + ", genero=" + this.genero + ", estado=" + this.estado + ", fecha=" + this.fecha + ", usuarioS=" + this.usuarioS + ")";
        }
    }

    @Generated
    public void setIdTipoPrograma(Integer idTipoPrograma) {
        this.idTipoPrograma = idTipoPrograma;
    }

    @Generated
    public void setNbre(String nbre) {
        this.nbre = nbre;
    }

    @Generated
    public void setEsPrenatal(Integer esPrenatal) {
        this.esPrenatal = esPrenatal;
    }

    @Generated
    public void setEdadI(Integer edadI) {
        this.edadI = edadI;
    }

    @Generated
    public void setTEdadI(String tEdadI) {
        this.tEdadI = tEdadI;
    }

    @Generated
    public void setEdadF(Integer edadF) {
        this.edadF = edadF;
    }

    @Generated
    public void setTEdadF(String tEdadF) {
        this.tEdadF = tEdadF;
    }

    @Generated
    public void setGenero(String genero) {
        this.genero = genero;
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
    public void setUsuarioS(String usuarioS) {
        this.usuarioS = usuarioS;
    }

    @Generated
    public static TipoProgramaDTOBuilder builder() {
        return new TipoProgramaDTOBuilder();
    }

    @Generated
    public TipoProgramaDTO(Integer idTipoPrograma, String nbre, Integer esPrenatal, Integer edadI, String tEdadI, Integer edadF, String tEdadF, String genero, Boolean estado, Date fecha, String usuarioS) {
        this.idTipoPrograma = idTipoPrograma;
        this.nbre = nbre;
        this.esPrenatal = esPrenatal;
        this.edadI = edadI;
        this.tEdadI = tEdadI;
        this.edadF = edadF;
        this.tEdadF = tEdadF;
        this.genero = genero;
        this.estado = estado;
        this.fecha = fecha;
        this.usuarioS = usuarioS;
    }

    @Generated
    public TipoProgramaDTO() {
    }

    @Generated
    public Integer getIdTipoPrograma() {
        return this.idTipoPrograma;
    }

    @Generated
    public String getNbre() {
        return this.nbre;
    }

    @Generated
    public Integer getEsPrenatal() {
        return this.esPrenatal;
    }

    @Generated
    public Integer getEdadI() {
        return this.edadI;
    }

    @Generated
    public String getTEdadI() {
        return this.tEdadI;
    }

    @Generated
    public Integer getEdadF() {
        return this.edadF;
    }

    @Generated
    public String getTEdadF() {
        return this.tEdadF;
    }

    @Generated
    public String getGenero() {
        return this.genero;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public String getUsuarioS() {
        return this.usuarioS;
    }
}
