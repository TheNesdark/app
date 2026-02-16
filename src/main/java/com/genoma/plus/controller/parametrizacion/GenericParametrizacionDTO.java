package com.genoma.plus.controller.parametrizacion;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/GenericParametrizacionDTO.class */
public class GenericParametrizacionDTO {
    private Long id;
    private String nombre;
    private Boolean estado;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenericParametrizacionDTO)) {
            return false;
        }
        GenericParametrizacionDTO other = (GenericParametrizacionDTO) o;
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
        Object this$estado = getEstado();
        Object other$estado = other.getEstado();
        if (this$estado == null) {
            if (other$estado != null) {
                return false;
            }
        } else if (!this$estado.equals(other$estado)) {
            return false;
        }
        Object this$nombre = getNombre();
        Object other$nombre = other.getNombre();
        return this$nombre == null ? other$nombre == null : this$nombre.equals(other$nombre);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof GenericParametrizacionDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $estado = getEstado();
        int result2 = (result * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $nombre = getNombre();
        return (result2 * 59) + ($nombre == null ? 43 : $nombre.hashCode());
    }

    @Generated
    public String toString() {
        return "GenericParametrizacionDTO(id=" + getId() + ", nombre=" + getNombre() + ", estado=" + getEstado() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/GenericParametrizacionDTO$GenericParametrizacionDTOBuilder.class */
    @Generated
    public static class GenericParametrizacionDTOBuilder {

        @Generated
        private Long id;

        @Generated
        private String nombre;

        @Generated
        private Boolean estado;

        @Generated
        GenericParametrizacionDTOBuilder() {
        }

        @Generated
        public GenericParametrizacionDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public GenericParametrizacionDTOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        @Generated
        public GenericParametrizacionDTOBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public GenericParametrizacionDTO build() {
            return new GenericParametrizacionDTO(this.id, this.nombre, this.estado);
        }

        @Generated
        public String toString() {
            return "GenericParametrizacionDTO.GenericParametrizacionDTOBuilder(id=" + this.id + ", nombre=" + this.nombre + ", estado=" + this.estado + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public static GenericParametrizacionDTOBuilder builder() {
        return new GenericParametrizacionDTOBuilder();
    }

    @Generated
    public GenericParametrizacionDTO(Long id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    @Generated
    public GenericParametrizacionDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getNombre() {
        return this.nombre;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }
}
