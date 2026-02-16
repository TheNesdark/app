package Laboratorio;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/pruebasDTO.class */
public class pruebasDTO {
    private String uuid;
    private String persona;
    private String lugarLlamado;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof pruebasDTO)) {
            return false;
        }
        pruebasDTO other = (pruebasDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$uuid = getUuid();
        Object other$uuid = other.getUuid();
        if (this$uuid == null) {
            if (other$uuid != null) {
                return false;
            }
        } else if (!this$uuid.equals(other$uuid)) {
            return false;
        }
        Object this$persona = getPersona();
        Object other$persona = other.getPersona();
        if (this$persona == null) {
            if (other$persona != null) {
                return false;
            }
        } else if (!this$persona.equals(other$persona)) {
            return false;
        }
        Object this$lugarLlamado = getLugarLlamado();
        Object other$lugarLlamado = other.getLugarLlamado();
        return this$lugarLlamado == null ? other$lugarLlamado == null : this$lugarLlamado.equals(other$lugarLlamado);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof pruebasDTO;
    }

    @Generated
    public int hashCode() {
        Object $uuid = getUuid();
        int result = (1 * 59) + ($uuid == null ? 43 : $uuid.hashCode());
        Object $persona = getPersona();
        int result2 = (result * 59) + ($persona == null ? 43 : $persona.hashCode());
        Object $lugarLlamado = getLugarLlamado();
        return (result2 * 59) + ($lugarLlamado == null ? 43 : $lugarLlamado.hashCode());
    }

    @Generated
    public String toString() {
        return "pruebasDTO(uuid=" + getUuid() + ", persona=" + getPersona() + ", lugarLlamado=" + getLugarLlamado() + ")";
    }

    @Generated
    public pruebasDTO(String uuid, String persona, String lugarLlamado) {
        this.uuid = uuid;
        this.persona = persona;
        this.lugarLlamado = lugarLlamado;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/pruebasDTO$pruebasDTOBuilder.class */
    @Generated
    public static class pruebasDTOBuilder {

        @Generated
        private String uuid;

        @Generated
        private String persona;

        @Generated
        private String lugarLlamado;

        @Generated
        pruebasDTOBuilder() {
        }

        @Generated
        public pruebasDTOBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        @Generated
        public pruebasDTOBuilder persona(String persona) {
            this.persona = persona;
            return this;
        }

        @Generated
        public pruebasDTOBuilder lugarLlamado(String lugarLlamado) {
            this.lugarLlamado = lugarLlamado;
            return this;
        }

        @Generated
        public pruebasDTO build() {
            return new pruebasDTO(this.uuid, this.persona, this.lugarLlamado);
        }

        @Generated
        public String toString() {
            return "pruebasDTO.pruebasDTOBuilder(uuid=" + this.uuid + ", persona=" + this.persona + ", lugarLlamado=" + this.lugarLlamado + ")";
        }
    }

    @Generated
    public pruebasDTO() {
    }

    @Generated
    public static pruebasDTOBuilder builder() {
        return new pruebasDTOBuilder();
    }

    @Generated
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Generated
    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Generated
    public void setLugarLlamado(String lugarLlamado) {
        this.lugarLlamado = lugarLlamado;
    }

    @Generated
    public String getUuid() {
        return this.uuid;
    }

    @Generated
    public String getPersona() {
        return this.persona;
    }

    @Generated
    public String getLugarLlamado() {
        return this.lugarLlamado;
    }
}
