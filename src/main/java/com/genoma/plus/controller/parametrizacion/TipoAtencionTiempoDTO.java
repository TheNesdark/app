package com.genoma.plus.controller.parametrizacion;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/TipoAtencionTiempoDTO.class */
public class TipoAtencionTiempoDTO {
    private Integer id;
    private String nbre;
    private boolean genHosp;
    private Boolean esQx;
    private boolean estado;
    private Boolean orden;
    private Date fecha;
    private String usuarioS;
    private Integer idTipoAmbito;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TipoAtencionTiempoDTO)) {
            return false;
        }
        TipoAtencionTiempoDTO other = (TipoAtencionTiempoDTO) o;
        if (!other.canEqual(this) || isGenHosp() != other.isGenHosp() || isEstado() != other.isEstado()) {
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
        Object this$esQx = getEsQx();
        Object other$esQx = other.getEsQx();
        if (this$esQx == null) {
            if (other$esQx != null) {
                return false;
            }
        } else if (!this$esQx.equals(other$esQx)) {
            return false;
        }
        Object this$orden = getOrden();
        Object other$orden = other.getOrden();
        if (this$orden == null) {
            if (other$orden != null) {
                return false;
            }
        } else if (!this$orden.equals(other$orden)) {
            return false;
        }
        Object this$idTipoAmbito = getIdTipoAmbito();
        Object other$idTipoAmbito = other.getIdTipoAmbito();
        if (this$idTipoAmbito == null) {
            if (other$idTipoAmbito != null) {
                return false;
            }
        } else if (!this$idTipoAmbito.equals(other$idTipoAmbito)) {
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
        return other instanceof TipoAtencionTiempoDTO;
    }

    @Generated
    public int hashCode() {
        int result = (1 * 59) + (isGenHosp() ? 79 : 97);
        int result2 = (result * 59) + (isEstado() ? 79 : 97);
        Object $id = getId();
        int result3 = (result2 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $esQx = getEsQx();
        int result4 = (result3 * 59) + ($esQx == null ? 43 : $esQx.hashCode());
        Object $orden = getOrden();
        int result5 = (result4 * 59) + ($orden == null ? 43 : $orden.hashCode());
        Object $idTipoAmbito = getIdTipoAmbito();
        int result6 = (result5 * 59) + ($idTipoAmbito == null ? 43 : $idTipoAmbito.hashCode());
        Object $nbre = getNbre();
        int result7 = (result6 * 59) + ($nbre == null ? 43 : $nbre.hashCode());
        Object $fecha = getFecha();
        int result8 = (result7 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $usuarioS = getUsuarioS();
        return (result8 * 59) + ($usuarioS == null ? 43 : $usuarioS.hashCode());
    }

    @Generated
    public String toString() {
        return "TipoAtencionTiempoDTO(id=" + getId() + ", nbre=" + getNbre() + ", genHosp=" + isGenHosp() + ", esQx=" + getEsQx() + ", estado=" + isEstado() + ", orden=" + getOrden() + ", fecha=" + getFecha() + ", usuarioS=" + getUsuarioS() + ", idTipoAmbito=" + getIdTipoAmbito() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/TipoAtencionTiempoDTO$TipoAtencionTiempoDTOBuilder.class */
    @Generated
    public static class TipoAtencionTiempoDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String nbre;

        @Generated
        private boolean genHosp;

        @Generated
        private Boolean esQx;

        @Generated
        private boolean estado;

        @Generated
        private Boolean orden;

        @Generated
        private Date fecha;

        @Generated
        private String usuarioS;

        @Generated
        private Integer idTipoAmbito;

        @Generated
        TipoAtencionTiempoDTOBuilder() {
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder nbre(String nbre) {
            this.nbre = nbre;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder genHosp(boolean genHosp) {
            this.genHosp = genHosp;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder esQx(Boolean esQx) {
            this.esQx = esQx;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder estado(boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder orden(Boolean orden) {
            this.orden = orden;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder usuarioS(String usuarioS) {
            this.usuarioS = usuarioS;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTOBuilder idTipoAmbito(Integer idTipoAmbito) {
            this.idTipoAmbito = idTipoAmbito;
            return this;
        }

        @Generated
        public TipoAtencionTiempoDTO build() {
            return new TipoAtencionTiempoDTO(this.id, this.nbre, this.genHosp, this.esQx, this.estado, this.orden, this.fecha, this.usuarioS, this.idTipoAmbito);
        }

        @Generated
        public String toString() {
            return "TipoAtencionTiempoDTO.TipoAtencionTiempoDTOBuilder(id=" + this.id + ", nbre=" + this.nbre + ", genHosp=" + this.genHosp + ", esQx=" + this.esQx + ", estado=" + this.estado + ", orden=" + this.orden + ", fecha=" + this.fecha + ", usuarioS=" + this.usuarioS + ", idTipoAmbito=" + this.idTipoAmbito + ")";
        }
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setNbre(String nbre) {
        this.nbre = nbre;
    }

    @Generated
    public void setGenHosp(boolean genHosp) {
        this.genHosp = genHosp;
    }

    @Generated
    public void setEsQx(Boolean esQx) {
        this.esQx = esQx;
    }

    @Generated
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setOrden(Boolean orden) {
        this.orden = orden;
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
    public void setIdTipoAmbito(Integer idTipoAmbito) {
        this.idTipoAmbito = idTipoAmbito;
    }

    @Generated
    public static TipoAtencionTiempoDTOBuilder builder() {
        return new TipoAtencionTiempoDTOBuilder();
    }

    @Generated
    public TipoAtencionTiempoDTO(Integer id, String nbre, boolean genHosp, Boolean esQx, boolean estado, Boolean orden, Date fecha, String usuarioS, Integer idTipoAmbito) {
        this.id = id;
        this.nbre = nbre;
        this.genHosp = genHosp;
        this.esQx = esQx;
        this.estado = estado;
        this.orden = orden;
        this.fecha = fecha;
        this.usuarioS = usuarioS;
        this.idTipoAmbito = idTipoAmbito;
    }

    @Generated
    public TipoAtencionTiempoDTO() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getNbre() {
        return this.nbre;
    }

    @Generated
    public boolean isGenHosp() {
        return this.genHosp;
    }

    @Generated
    public Boolean getEsQx() {
        return this.esQx;
    }

    @Generated
    public boolean isEstado() {
        return this.estado;
    }

    @Generated
    public Boolean getOrden() {
        return this.orden;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public String getUsuarioS() {
        return this.usuarioS;
    }

    @Generated
    public Integer getIdTipoAmbito() {
        return this.idTipoAmbito;
    }
}
