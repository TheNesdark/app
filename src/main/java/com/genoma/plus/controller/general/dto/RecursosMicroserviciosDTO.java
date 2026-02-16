package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/RecursosMicroserviciosDTO.class */
public class RecursosMicroserviciosDTO {
    private Integer id;
    private Integer idModulo;
    private String nombreFormulario;
    private String nombreIdentificador;
    private String urlRecurso;
    private Boolean state;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/RecursosMicroserviciosDTO$RecursosMicroserviciosDTOBuilder.class */
    @Generated
    public static class RecursosMicroserviciosDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private Integer idModulo;

        @Generated
        private String nombreFormulario;

        @Generated
        private String nombreIdentificador;

        @Generated
        private String urlRecurso;

        @Generated
        private Boolean state;

        @Generated
        RecursosMicroserviciosDTOBuilder() {
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder idModulo(Integer idModulo) {
            this.idModulo = idModulo;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder nombreFormulario(String nombreFormulario) {
            this.nombreFormulario = nombreFormulario;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder nombreIdentificador(String nombreIdentificador) {
            this.nombreIdentificador = nombreIdentificador;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder urlRecurso(String urlRecurso) {
            this.urlRecurso = urlRecurso;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDTO build() {
            return new RecursosMicroserviciosDTO(this.id, this.idModulo, this.nombreFormulario, this.nombreIdentificador, this.urlRecurso, this.state);
        }

        @Generated
        public String toString() {
            return "RecursosMicroserviciosDTO.RecursosMicroserviciosDTOBuilder(id=" + this.id + ", idModulo=" + this.idModulo + ", nombreFormulario=" + this.nombreFormulario + ", nombreIdentificador=" + this.nombreIdentificador + ", urlRecurso=" + this.urlRecurso + ", state=" + this.state + ")";
        }
    }

    @Generated
    public static RecursosMicroserviciosDTOBuilder builder() {
        return new RecursosMicroserviciosDTOBuilder();
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    @Generated
    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    @Generated
    public void setNombreIdentificador(String nombreIdentificador) {
        this.nombreIdentificador = nombreIdentificador;
    }

    @Generated
    public void setUrlRecurso(String urlRecurso) {
        this.urlRecurso = urlRecurso;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RecursosMicroserviciosDTO)) {
            return false;
        }
        RecursosMicroserviciosDTO other = (RecursosMicroserviciosDTO) o;
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
        Object this$idModulo = getIdModulo();
        Object other$idModulo = other.getIdModulo();
        if (this$idModulo == null) {
            if (other$idModulo != null) {
                return false;
            }
        } else if (!this$idModulo.equals(other$idModulo)) {
            return false;
        }
        Object this$state = getState();
        Object other$state = other.getState();
        if (this$state == null) {
            if (other$state != null) {
                return false;
            }
        } else if (!this$state.equals(other$state)) {
            return false;
        }
        Object this$nombreFormulario = getNombreFormulario();
        Object other$nombreFormulario = other.getNombreFormulario();
        if (this$nombreFormulario == null) {
            if (other$nombreFormulario != null) {
                return false;
            }
        } else if (!this$nombreFormulario.equals(other$nombreFormulario)) {
            return false;
        }
        Object this$nombreIdentificador = getNombreIdentificador();
        Object other$nombreIdentificador = other.getNombreIdentificador();
        if (this$nombreIdentificador == null) {
            if (other$nombreIdentificador != null) {
                return false;
            }
        } else if (!this$nombreIdentificador.equals(other$nombreIdentificador)) {
            return false;
        }
        Object this$urlRecurso = getUrlRecurso();
        Object other$urlRecurso = other.getUrlRecurso();
        return this$urlRecurso == null ? other$urlRecurso == null : this$urlRecurso.equals(other$urlRecurso);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RecursosMicroserviciosDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idModulo = getIdModulo();
        int result2 = (result * 59) + ($idModulo == null ? 43 : $idModulo.hashCode());
        Object $state = getState();
        int result3 = (result2 * 59) + ($state == null ? 43 : $state.hashCode());
        Object $nombreFormulario = getNombreFormulario();
        int result4 = (result3 * 59) + ($nombreFormulario == null ? 43 : $nombreFormulario.hashCode());
        Object $nombreIdentificador = getNombreIdentificador();
        int result5 = (result4 * 59) + ($nombreIdentificador == null ? 43 : $nombreIdentificador.hashCode());
        Object $urlRecurso = getUrlRecurso();
        return (result5 * 59) + ($urlRecurso == null ? 43 : $urlRecurso.hashCode());
    }

    @Generated
    public String toString() {
        return "RecursosMicroserviciosDTO(id=" + getId() + ", idModulo=" + getIdModulo() + ", nombreFormulario=" + getNombreFormulario() + ", nombreIdentificador=" + getNombreIdentificador() + ", urlRecurso=" + getUrlRecurso() + ", state=" + getState() + ")";
    }

    @Generated
    public RecursosMicroserviciosDTO() {
    }

    @Generated
    public RecursosMicroserviciosDTO(Integer id, Integer idModulo, String nombreFormulario, String nombreIdentificador, String urlRecurso, Boolean state) {
        this.id = id;
        this.idModulo = idModulo;
        this.nombreFormulario = nombreFormulario;
        this.nombreIdentificador = nombreIdentificador;
        this.urlRecurso = urlRecurso;
        this.state = state;
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public Integer getIdModulo() {
        return this.idModulo;
    }

    @Generated
    public String getNombreFormulario() {
        return this.nombreFormulario;
    }

    @Generated
    public String getNombreIdentificador() {
        return this.nombreIdentificador;
    }

    @Generated
    public String getUrlRecurso() {
        return this.urlRecurso;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }
}
