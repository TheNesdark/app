package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/BitacoraCorreoDto.class */
public class BitacoraCorreoDto {
    private Long id;
    private String fecha;
    private String correoEnvio;
    private String usuarioSistemaEnvio;
    private String hostName;
    private String hostAddress;
    private String correoRecibe;
    private String state;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/BitacoraCorreoDto$BitacoraCorreoDtoBuilder.class */
    @Generated
    public static class BitacoraCorreoDtoBuilder {

        @Generated
        private Long id;

        @Generated
        private String fecha;

        @Generated
        private String correoEnvio;

        @Generated
        private String usuarioSistemaEnvio;

        @Generated
        private String hostName;

        @Generated
        private String hostAddress;

        @Generated
        private String correoRecibe;

        @Generated
        private String state;

        @Generated
        BitacoraCorreoDtoBuilder() {
        }

        @Generated
        public BitacoraCorreoDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder correoEnvio(String correoEnvio) {
            this.correoEnvio = correoEnvio;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder usuarioSistemaEnvio(String usuarioSistemaEnvio) {
            this.usuarioSistemaEnvio = usuarioSistemaEnvio;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder hostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder hostAddress(String hostAddress) {
            this.hostAddress = hostAddress;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder correoRecibe(String correoRecibe) {
            this.correoRecibe = correoRecibe;
            return this;
        }

        @Generated
        public BitacoraCorreoDtoBuilder state(String state) {
            this.state = state;
            return this;
        }

        @Generated
        public BitacoraCorreoDto build() {
            return new BitacoraCorreoDto(this.id, this.fecha, this.correoEnvio, this.usuarioSistemaEnvio, this.hostName, this.hostAddress, this.correoRecibe, this.state);
        }

        @Generated
        public String toString() {
            return "BitacoraCorreoDto.BitacoraCorreoDtoBuilder(id=" + this.id + ", fecha=" + this.fecha + ", correoEnvio=" + this.correoEnvio + ", usuarioSistemaEnvio=" + this.usuarioSistemaEnvio + ", hostName=" + this.hostName + ", hostAddress=" + this.hostAddress + ", correoRecibe=" + this.correoRecibe + ", state=" + this.state + ")";
        }
    }

    @Generated
    public static BitacoraCorreoDtoBuilder builder() {
        return new BitacoraCorreoDtoBuilder();
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BitacoraCorreoDto)) {
            return false;
        }
        BitacoraCorreoDto other = (BitacoraCorreoDto) o;
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
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        if (this$fecha == null) {
            if (other$fecha != null) {
                return false;
            }
        } else if (!this$fecha.equals(other$fecha)) {
            return false;
        }
        Object this$correoEnvio = getCorreoEnvio();
        Object other$correoEnvio = other.getCorreoEnvio();
        if (this$correoEnvio == null) {
            if (other$correoEnvio != null) {
                return false;
            }
        } else if (!this$correoEnvio.equals(other$correoEnvio)) {
            return false;
        }
        Object this$usuarioSistemaEnvio = getUsuarioSistemaEnvio();
        Object other$usuarioSistemaEnvio = other.getUsuarioSistemaEnvio();
        if (this$usuarioSistemaEnvio == null) {
            if (other$usuarioSistemaEnvio != null) {
                return false;
            }
        } else if (!this$usuarioSistemaEnvio.equals(other$usuarioSistemaEnvio)) {
            return false;
        }
        Object this$hostName = getHostName();
        Object other$hostName = other.getHostName();
        if (this$hostName == null) {
            if (other$hostName != null) {
                return false;
            }
        } else if (!this$hostName.equals(other$hostName)) {
            return false;
        }
        Object this$hostAddress = getHostAddress();
        Object other$hostAddress = other.getHostAddress();
        if (this$hostAddress == null) {
            if (other$hostAddress != null) {
                return false;
            }
        } else if (!this$hostAddress.equals(other$hostAddress)) {
            return false;
        }
        Object this$correoRecibe = getCorreoRecibe();
        Object other$correoRecibe = other.getCorreoRecibe();
        if (this$correoRecibe == null) {
            if (other$correoRecibe != null) {
                return false;
            }
        } else if (!this$correoRecibe.equals(other$correoRecibe)) {
            return false;
        }
        Object this$state = getState();
        Object other$state = other.getState();
        return this$state == null ? other$state == null : this$state.equals(other$state);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BitacoraCorreoDto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $fecha = getFecha();
        int result2 = (result * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $correoEnvio = getCorreoEnvio();
        int result3 = (result2 * 59) + ($correoEnvio == null ? 43 : $correoEnvio.hashCode());
        Object $usuarioSistemaEnvio = getUsuarioSistemaEnvio();
        int result4 = (result3 * 59) + ($usuarioSistemaEnvio == null ? 43 : $usuarioSistemaEnvio.hashCode());
        Object $hostName = getHostName();
        int result5 = (result4 * 59) + ($hostName == null ? 43 : $hostName.hashCode());
        Object $hostAddress = getHostAddress();
        int result6 = (result5 * 59) + ($hostAddress == null ? 43 : $hostAddress.hashCode());
        Object $correoRecibe = getCorreoRecibe();
        int result7 = (result6 * 59) + ($correoRecibe == null ? 43 : $correoRecibe.hashCode());
        Object $state = getState();
        return (result7 * 59) + ($state == null ? 43 : $state.hashCode());
    }

    @Generated
    public String toString() {
        return "BitacoraCorreoDto(id=" + getId() + ", fecha=" + getFecha() + ", correoEnvio=" + getCorreoEnvio() + ", usuarioSistemaEnvio=" + getUsuarioSistemaEnvio() + ", hostName=" + getHostName() + ", hostAddress=" + getHostAddress() + ", correoRecibe=" + getCorreoRecibe() + ", state=" + getState() + ")";
    }

    @Generated
    public BitacoraCorreoDto() {
    }

    @Generated
    public BitacoraCorreoDto(Long id, String fecha, String correoEnvio, String usuarioSistemaEnvio, String hostName, String hostAddress, String correoRecibe, String state) {
        this.id = id;
        this.fecha = fecha;
        this.correoEnvio = correoEnvio;
        this.usuarioSistemaEnvio = usuarioSistemaEnvio;
        this.hostName = hostName;
        this.hostAddress = hostAddress;
        this.correoRecibe = correoRecibe;
        this.state = state;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setCorreoEnvio(String correoEnvio) {
        this.correoEnvio = correoEnvio;
    }

    @Generated
    public void setUsuarioSistemaEnvio(String usuarioSistemaEnvio) {
        this.usuarioSistemaEnvio = usuarioSistemaEnvio;
    }

    @Generated
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Generated
    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    @Generated
    public void setCorreoRecibe(String correoRecibe) {
        this.correoRecibe = correoRecibe;
    }

    @Generated
    public void setState(String state) {
        this.state = state;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getFecha() {
        return this.fecha;
    }

    @Generated
    public String getCorreoEnvio() {
        return this.correoEnvio;
    }

    @Generated
    public String getUsuarioSistemaEnvio() {
        return this.usuarioSistemaEnvio;
    }

    @Generated
    public String getHostName() {
        return this.hostName;
    }

    @Generated
    public String getHostAddress() {
        return this.hostAddress;
    }

    @Generated
    public String getCorreoRecibe() {
        return this.correoRecibe;
    }

    @Generated
    public String getState() {
        return this.state;
    }
}
