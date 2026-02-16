package com.genoma.plus.controller.integracion_simedis.dto;

import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/InterfazLabGenomaDto.class */
public class InterfazLabGenomaDto {
    private Long id;
    private Long idIngreso;
    private PersonaInterfazDto personaInterfazDomain;
    private IngresoInterfazDto ingresoInterfazDomain;
    private List<ItemsInterfazDto> itemsInterfazDomain;
    private Integer estado;
    private Long idUsuario;

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setPersonaInterfazDomain(PersonaInterfazDto personaInterfazDomain) {
        this.personaInterfazDomain = personaInterfazDomain;
    }

    @Generated
    public void setIngresoInterfazDomain(IngresoInterfazDto ingresoInterfazDomain) {
        this.ingresoInterfazDomain = ingresoInterfazDomain;
    }

    @Generated
    public void setItemsInterfazDomain(List<ItemsInterfazDto> itemsInterfazDomain) {
        this.itemsInterfazDomain = itemsInterfazDomain;
    }

    @Generated
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Generated
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InterfazLabGenomaDto)) {
            return false;
        }
        InterfazLabGenomaDto other = (InterfazLabGenomaDto) o;
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
        Object this$idIngreso = getIdIngreso();
        Object other$idIngreso = other.getIdIngreso();
        if (this$idIngreso == null) {
            if (other$idIngreso != null) {
                return false;
            }
        } else if (!this$idIngreso.equals(other$idIngreso)) {
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
        Object this$idUsuario = getIdUsuario();
        Object other$idUsuario = other.getIdUsuario();
        if (this$idUsuario == null) {
            if (other$idUsuario != null) {
                return false;
            }
        } else if (!this$idUsuario.equals(other$idUsuario)) {
            return false;
        }
        Object this$personaInterfazDomain = getPersonaInterfazDomain();
        Object other$personaInterfazDomain = other.getPersonaInterfazDomain();
        if (this$personaInterfazDomain == null) {
            if (other$personaInterfazDomain != null) {
                return false;
            }
        } else if (!this$personaInterfazDomain.equals(other$personaInterfazDomain)) {
            return false;
        }
        Object this$ingresoInterfazDomain = getIngresoInterfazDomain();
        Object other$ingresoInterfazDomain = other.getIngresoInterfazDomain();
        if (this$ingresoInterfazDomain == null) {
            if (other$ingresoInterfazDomain != null) {
                return false;
            }
        } else if (!this$ingresoInterfazDomain.equals(other$ingresoInterfazDomain)) {
            return false;
        }
        Object this$itemsInterfazDomain = getItemsInterfazDomain();
        Object other$itemsInterfazDomain = other.getItemsInterfazDomain();
        return this$itemsInterfazDomain == null ? other$itemsInterfazDomain == null : this$itemsInterfazDomain.equals(other$itemsInterfazDomain);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InterfazLabGenomaDto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idIngreso = getIdIngreso();
        int result2 = (result * 59) + ($idIngreso == null ? 43 : $idIngreso.hashCode());
        Object $estado = getEstado();
        int result3 = (result2 * 59) + ($estado == null ? 43 : $estado.hashCode());
        Object $idUsuario = getIdUsuario();
        int result4 = (result3 * 59) + ($idUsuario == null ? 43 : $idUsuario.hashCode());
        Object $personaInterfazDomain = getPersonaInterfazDomain();
        int result5 = (result4 * 59) + ($personaInterfazDomain == null ? 43 : $personaInterfazDomain.hashCode());
        Object $ingresoInterfazDomain = getIngresoInterfazDomain();
        int result6 = (result5 * 59) + ($ingresoInterfazDomain == null ? 43 : $ingresoInterfazDomain.hashCode());
        Object $itemsInterfazDomain = getItemsInterfazDomain();
        return (result6 * 59) + ($itemsInterfazDomain == null ? 43 : $itemsInterfazDomain.hashCode());
    }

    @Generated
    public String toString() {
        return "InterfazLabGenomaDto(id=" + getId() + ", idIngreso=" + getIdIngreso() + ", personaInterfazDomain=" + getPersonaInterfazDomain() + ", ingresoInterfazDomain=" + getIngresoInterfazDomain() + ", itemsInterfazDomain=" + getItemsInterfazDomain() + ", estado=" + getEstado() + ", idUsuario=" + getIdUsuario() + ")";
    }

    @Generated
    public InterfazLabGenomaDto(Long id, Long idIngreso, PersonaInterfazDto personaInterfazDomain, IngresoInterfazDto ingresoInterfazDomain, List<ItemsInterfazDto> itemsInterfazDomain, Integer estado, Long idUsuario) {
        this.id = id;
        this.idIngreso = idIngreso;
        this.personaInterfazDomain = personaInterfazDomain;
        this.ingresoInterfazDomain = ingresoInterfazDomain;
        this.itemsInterfazDomain = itemsInterfazDomain;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/dto/InterfazLabGenomaDto$InterfazLabGenomaDtoBuilder.class */
    @Generated
    public static class InterfazLabGenomaDtoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idIngreso;

        @Generated
        private PersonaInterfazDto personaInterfazDomain;

        @Generated
        private IngresoInterfazDto ingresoInterfazDomain;

        @Generated
        private List<ItemsInterfazDto> itemsInterfazDomain;

        @Generated
        private Integer estado;

        @Generated
        private Long idUsuario;

        @Generated
        InterfazLabGenomaDtoBuilder() {
        }

        @Generated
        public InterfazLabGenomaDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder idIngreso(Long idIngreso) {
            this.idIngreso = idIngreso;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder personaInterfazDomain(PersonaInterfazDto personaInterfazDomain) {
            this.personaInterfazDomain = personaInterfazDomain;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder ingresoInterfazDomain(IngresoInterfazDto ingresoInterfazDomain) {
            this.ingresoInterfazDomain = ingresoInterfazDomain;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder itemsInterfazDomain(List<ItemsInterfazDto> itemsInterfazDomain) {
            this.itemsInterfazDomain = itemsInterfazDomain;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder estado(Integer estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public InterfazLabGenomaDtoBuilder idUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        @Generated
        public InterfazLabGenomaDto build() {
            return new InterfazLabGenomaDto(this.id, this.idIngreso, this.personaInterfazDomain, this.ingresoInterfazDomain, this.itemsInterfazDomain, this.estado, this.idUsuario);
        }

        @Generated
        public String toString() {
            return "InterfazLabGenomaDto.InterfazLabGenomaDtoBuilder(id=" + this.id + ", idIngreso=" + this.idIngreso + ", personaInterfazDomain=" + this.personaInterfazDomain + ", ingresoInterfazDomain=" + this.ingresoInterfazDomain + ", itemsInterfazDomain=" + this.itemsInterfazDomain + ", estado=" + this.estado + ", idUsuario=" + this.idUsuario + ")";
        }
    }

    @Generated
    public InterfazLabGenomaDto() {
    }

    @Generated
    public static InterfazLabGenomaDtoBuilder builder() {
        return new InterfazLabGenomaDtoBuilder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public PersonaInterfazDto getPersonaInterfazDomain() {
        return this.personaInterfazDomain;
    }

    @Generated
    public IngresoInterfazDto getIngresoInterfazDomain() {
        return this.ingresoInterfazDomain;
    }

    @Generated
    public List<ItemsInterfazDto> getItemsInterfazDomain() {
        return this.itemsInterfazDomain;
    }

    @Generated
    public Integer getEstado() {
        return this.estado;
    }

    @Generated
    public Long getIdUsuario() {
        return this.idUsuario;
    }
}
