package com.genoma.plus.domains.models.domains.general;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/domains/models/domains/general/RecursosMicroserviciosDomain.class */
public class RecursosMicroserviciosDomain {
    private Integer id;
    private Integer idModulo;
    private String nombreFormulario;
    private String nombreIdentificador;
    private String urlRecurso;
    private Boolean esUrlExterna;
    private Boolean state;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RecursosMicroserviciosDomain)) {
            return false;
        }
        RecursosMicroserviciosDomain other = (RecursosMicroserviciosDomain) o;
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
        Object this$esUrlExterna = getEsUrlExterna();
        Object other$esUrlExterna = other.getEsUrlExterna();
        if (this$esUrlExterna == null) {
            if (other$esUrlExterna != null) {
                return false;
            }
        } else if (!this$esUrlExterna.equals(other$esUrlExterna)) {
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
        return other instanceof RecursosMicroserviciosDomain;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idModulo = getIdModulo();
        int result2 = (result * 59) + ($idModulo == null ? 43 : $idModulo.hashCode());
        Object $esUrlExterna = getEsUrlExterna();
        int result3 = (result2 * 59) + ($esUrlExterna == null ? 43 : $esUrlExterna.hashCode());
        Object $state = getState();
        int result4 = (result3 * 59) + ($state == null ? 43 : $state.hashCode());
        Object $nombreFormulario = getNombreFormulario();
        int result5 = (result4 * 59) + ($nombreFormulario == null ? 43 : $nombreFormulario.hashCode());
        Object $nombreIdentificador = getNombreIdentificador();
        int result6 = (result5 * 59) + ($nombreIdentificador == null ? 43 : $nombreIdentificador.hashCode());
        Object $urlRecurso = getUrlRecurso();
        return (result6 * 59) + ($urlRecurso == null ? 43 : $urlRecurso.hashCode());
    }

    @Generated
    public String toString() {
        return "RecursosMicroserviciosDomain(id=" + getId() + ", idModulo=" + getIdModulo() + ", nombreFormulario=" + getNombreFormulario() + ", nombreIdentificador=" + getNombreIdentificador() + ", urlRecurso=" + getUrlRecurso() + ", esUrlExterna=" + getEsUrlExterna() + ", state=" + getState() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/domains/models/domains/general/RecursosMicroserviciosDomain$RecursosMicroserviciosDomainBuilder.class */
    @Generated
    public static class RecursosMicroserviciosDomainBuilder {

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
        private Boolean esUrlExterna;

        @Generated
        private Boolean state;

        @Generated
        RecursosMicroserviciosDomainBuilder() {
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder idModulo(Integer idModulo) {
            this.idModulo = idModulo;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder nombreFormulario(String nombreFormulario) {
            this.nombreFormulario = nombreFormulario;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder nombreIdentificador(String nombreIdentificador) {
            this.nombreIdentificador = nombreIdentificador;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder urlRecurso(String urlRecurso) {
            this.urlRecurso = urlRecurso;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder esUrlExterna(Boolean esUrlExterna) {
            this.esUrlExterna = esUrlExterna;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomainBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public RecursosMicroserviciosDomain build() {
            return new RecursosMicroserviciosDomain(this.id, this.idModulo, this.nombreFormulario, this.nombreIdentificador, this.urlRecurso, this.esUrlExterna, this.state);
        }

        @Generated
        public String toString() {
            return "RecursosMicroserviciosDomain.RecursosMicroserviciosDomainBuilder(id=" + this.id + ", idModulo=" + this.idModulo + ", nombreFormulario=" + this.nombreFormulario + ", nombreIdentificador=" + this.nombreIdentificador + ", urlRecurso=" + this.urlRecurso + ", esUrlExterna=" + this.esUrlExterna + ", state=" + this.state + ")";
        }
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
    public void setEsUrlExterna(Boolean esUrlExterna) {
        this.esUrlExterna = esUrlExterna;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public static RecursosMicroserviciosDomainBuilder builder() {
        return new RecursosMicroserviciosDomainBuilder();
    }

    @Generated
    public RecursosMicroserviciosDomain(Integer id, Integer idModulo, String nombreFormulario, String nombreIdentificador, String urlRecurso, Boolean esUrlExterna, Boolean state) {
        this.id = id;
        this.idModulo = idModulo;
        this.nombreFormulario = nombreFormulario;
        this.nombreIdentificador = nombreIdentificador;
        this.urlRecurso = urlRecurso;
        this.esUrlExterna = esUrlExterna;
        this.state = state;
    }

    @Generated
    public RecursosMicroserviciosDomain() {
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
    public Boolean getEsUrlExterna() {
        return this.esUrlExterna;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }
}
